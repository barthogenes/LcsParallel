package com.hva;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Session;
import javax.jms.MessageConsumer;
import javax.jms.Message;
import javax.jms.TextMessage;
import javax.jms.MessageProducer;

import java.util.Arrays;


public class SortStringFromQueue {
    // either connect to the remote ActiveMQ running on the PI, or on the localhost
    private static String url = "failover:(tcp://169.254.1.1:61616,localhost:8161)";
    private static String subjectFrom = "testQueue1";
    private static String subjectTo = "testQueue2";

    public static void main(String args[]) throws Exception {

        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination_fromQueue = session.createQueue(subjectFrom);
        MessageConsumer consumer = session.createConsumer(destination_fromQueue);
        Message message = consumer.receive();
        int[] integers = null; // to hold the converted and sorted numbers
        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            String str = textMessage.getText();
            String[] integerStrings = str.split(" ");  //to store the string of numbers retrieved from the queue
            integers = new int[integerStrings.length];
            for (int i = 0; i < integers.length; i++) {
                integers[i] = Integer.parseInt(integerStrings[i]);
            }
        }
        Destination destination_toQueue = session.createQueue(subjectTo);
        MessageProducer producer = session.createProducer(destination_toQueue);
        Arrays.sort(integers);
        String stringForConsumer = Arrays.toString(integers);
        TextMessage messageTo = session.createTextMessage(stringForConsumer);
        producer.send(messageTo);
        connection.close();
    }
}

