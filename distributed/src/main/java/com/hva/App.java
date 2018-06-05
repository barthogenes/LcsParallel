package com.hva;


import com.hva.lcs.util.EventProfiler;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;


public class App
{
    // either connect to the remote ActiveMQ running on the PI, or on the localhost
    private static String url = "failover:(tcp://169.254.1.1:61616,localhost:8161)";

    public static void main( String[] args ) throws JMSException {

        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(url);
        factory.setTrustAllPackages(true);

        EventProfiler ep = new EventProfiler(true);

        String lcs = "ADH";
        int[] testSetSizes = new int[]{10, 100, 500, 1000};

        LcsTestSet testSet1 = new LcsTestSet(lcs, testSetSizes[0]);
        LcsTestSet testSet2 = new LcsTestSet(lcs, testSetSizes[1]);
        LcsTestSet testSet3 = new LcsTestSet(lcs, testSetSizes[2]);
        LcsTestSet testSet4 = new LcsTestSet(lcs, testSetSizes[3]);


        // Test 1
        String a = testSet1.getStringA();
        String b = testSet1.getStringB();
        Producer producer = new Producer(factory, "SlicesQueue", "ResultQueue", a, b);
        ep.log("Start " + testSetSizes[0]);
        producer.run();
        ep.log("End " + testSetSizes[0]);
        producer.close();

        // Test 2
        a = testSet2.getStringA();
        b = testSet2.getStringB();
        producer = new Producer(factory, "SlicesQueue", "ResultQueue", a, b);
        ep.log("Start " + testSetSizes[1]);
        producer.run();
        ep.log("End " + testSetSizes[1]);
        producer.close();

        // Test 3
        a = testSet3.getStringA();
        b = testSet3.getStringB();
        producer = new Producer(factory, "SlicesQueue", "ResultQueue", a, b);
        ep.log("Start " + testSetSizes[2]);
        producer.run();
        ep.log("End " + testSetSizes[2]);
        producer.close();

        // Test 4
        a = testSet4.getStringA();
        b = testSet4.getStringB();
        producer = new Producer(factory, "SlicesQueue", "ResultQueue", a, b);
        ep.log("Start " + testSetSizes[3]);
        producer.run();
        ep.log("End " + testSetSizes[3]);
        producer.close();

    }
}
