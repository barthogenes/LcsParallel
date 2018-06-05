package com.hva.parallel_computing;

import com.hva.lcs.LcsAlgorithm;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ParallelLcs extends LcsAlgorithm {

    private ExecutorService executorService;
    private int threadCount;
    private String alphabetA;
    private ArrayBlockingQueue<Character> queue;

    public ParallelLcs(int threadCount, String alphabetA) {
        this.threadCount = threadCount;

        // Regex source: https://stackoverflow.com/a/12870549/8633753
        String checkAlphabetRegex = "^(?:([A-Za-z])(?!.*\\1))*$";
        if (alphabetA.matches(checkAlphabetRegex))
            throw new IllegalArgumentException("Alphabet should contain only distinct characters!");
        this.alphabetA = alphabetA;
    }

    @Override
    public String findLongestCommonSubsequence(String a, String b) {
        executorService = Executors.newFixedThreadPool(threadCount);




        // Add work to executorService
        executorService.submit(new ProcessorDiagonal(j, this));

        // Call shutdown in advance
        executorService.shutdown();

        // Wait for executorService to complete all its jobs
        try {
            executorService.awaitTermination(2, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return null;
    }


    protected void compare() {





    }

}


class Worker implements Runnable {
    private LcsConcurrentDiagonal lcs;

    private int id;
    private ArrayBlockingQueue<TablePoint> queue;

    public ProcessorDiagonal(int id, LcsConcurrentDiagonal lcs) {
        this.id = id;
        this.lcs = lcs;
        this.queue = lcs.queue;
    }

    public void run() {
        //lcs.ep.log("Starting thread:" + id);
        String a = new String(lcs.lengthTable.getStringA());
        String b = new String(lcs.lengthTable.getStringB());


        TablePoint point;
        int column;
        int row;
        while (true) {
            try {
                point = queue.take();
                if (point.getColumn() == -5 || point.getRow() == -5) {
                    break;
                }

                column = point.getColumn();
                row = point.getRow();
                if (a.charAt(column - 1) == b.charAt(row - 1)) {
                    lcs.handleMatch(column, row);
                } else {
                    lcs.handleMismatch(column, row);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        //lcs.ep.log("Completed thread:" + id);
    }
}
