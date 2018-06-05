package com.hva;

import com.hva.lcs.model.lengthtable.interfaces.ILengthTable;
import com.hva.lcs.model.lengthtable.implementation.LengthTable;

import javax.jms.*;

import java.util.ArrayList;

public class Producer implements MessageListener {
    private Connection connection;
    private Session session;
    private MessageProducer producer;
    private MessageConsumer consumer;
    private ILengthTable lengthTable;

    private Queue slicesQueue;
    private Queue resultQueue;

    private int sendTotal;
    private int receivedTotal;

    private String a;
    private String b;

    public Producer(ConnectionFactory factory, String slicesQueueName, String resultQueueName, String a, String b) throws JMSException {
        this.a = a;
        this.b = b;

        connection = factory.createConnection();
        connection.start();
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        slicesQueue = session.createQueue(slicesQueueName);
        resultQueue = session.createQueue(resultQueueName);

        producer = session.createProducer(slicesQueue);
        consumer = session.createConsumer(resultQueue);
        consumer.setMessageListener(this);
        sendTotal = 0;
        receivedTotal = 0;
    }

    public void run() throws JMSException {
        lengthTable = new LengthTable();
        lengthTable.setStrings(a, b);

        ArrayList<Slice> slices = lengthTable.getDiagonalPoints();
        Queue queue = session.createQueue("SlicesQueue");
        Message message;
        Slice slice;
        for (int i = 2; i < slices.size(); i++) {
            slice = slices.get(i);
            for (int j = 0; j < slice.size(); j++) {
                try {
                    message = session.createTextMessage(a + "," + b + "," + slice.get(j).getColumn() + "," + slice.get(j).getRow());
                    producer.send(queue, message);
                    sendTotal++;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


        while (receivedTotal != sendTotal) {
            try {
                Thread.sleep(0, 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(lengthTable.readLcsLeftUp(false));
    }

    public void close() throws JMSException {
        if (connection != null) {
            connection.close();
        }
    }

    public void onMessage(Message message) {
        try
        {
            if (message instanceof TextMessage) {
               String text = ((TextMessage)message).getText();
               String[] splits = text.split(",");
               int column = Integer.parseInt(splits[0]);
               int row = Integer.parseInt(splits[1]);
               boolean isMatch = splits[2].equals("match");

               if (isMatch) {
                   int diagonalCell = lengthTable.get(column -1, row-1);
                   lengthTable.set(column, row, diagonalCell+1);
               } else {
                    int max = Math.max(lengthTable.get(column-1, row), lengthTable.get(column, row-1));
                    lengthTable.set(column, row, max);
               }
                receivedTotal++;
            }
            else
            {
                System.out.println("Invalid message received.");
            }
        }
        catch (JMSException e)
        {
            System.out.println("Caught:" + e);
            e.printStackTrace();
        }
    }
}
