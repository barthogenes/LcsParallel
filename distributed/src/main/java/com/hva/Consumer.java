package com.hva;

import javax.jms.*;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Consumer implements MessageListener{
    // either connect to the remote ActiveMQ running on the PI, or on the localhost
    public static String brokerURL = "failover:(tcp://169.254.1.1:61616,localhost:8161)";

    private Connection connection;
    private Session session;
    private MessageConsumer consumer;
    private MessageProducer producer;

    private String a;
    private String b;

    public static void main( String[] args )
    {
        Consumer consumer = new Consumer();
        consumer.run();
    }

    public void run()
    {
        try
        {
            ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(brokerURL);
            factory.setTrustAllPackages(true);
            connection = factory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination slicesQueue = session.createQueue("SlicesQueue");
            Destination resultQueue = session.createQueue("ResultQueue");

            consumer = session.createConsumer(slicesQueue);

            producer = session.createProducer(resultQueue);

            consumer.setMessageListener(this);
        }
        catch (Exception e)
        {
            System.out.println("Caught:" + e);
            e.printStackTrace();
        }
    }

    public void onMessage(Message message)
    {
        try
        {
            if (message instanceof TextMessage) {
                String strings = ((TextMessage) message).getText();
                String[] splits = strings.split(",");
                a = splits[0];
                b = splits[1];
                int column = Integer.parseInt(splits[2]);
                int row = Integer.parseInt(splits[3]);
                String point = column + "," + row + ",";
                if (a.charAt(column-1) == b.charAt(row-1)) {
                    producer.send(session.createTextMessage(point + "match"));
                } else {
                    producer.send(session.createTextMessage(point + "mismatch"));
                }
            }
            else
            {
                System.out.println("Invalid message received.");
            }
        }
        catch (Exception e)
        {
            System.out.println("Caught:" + e);
            e.printStackTrace();
        }
    }
}
