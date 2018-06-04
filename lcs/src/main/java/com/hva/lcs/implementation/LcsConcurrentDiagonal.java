package com.hva.lcs.implementation;

import com.hva.lcs.model.*;
import com.hva.lcs.model.lengthtable.interfaces.ILengthTable;

import java.util.ArrayList;
import java.util.concurrent.*;

public class LcsConcurrentDiagonal extends LcsAlgorithm {

    private ExecutorService ex;
    private int threadCount;
    private int queueSize;
    protected ArrayBlockingQueue<TablePoint> queue;

    public LcsConcurrentDiagonal(ILengthTable lengthTable, int threadCount, int queueSize) {
        super(lengthTable);
        this.threadCount = threadCount;
        this.queueSize = queueSize;
    }


    protected void compare() {
        ex = Executors.newFixedThreadPool(threadCount);

        ArrayList<Slice> slices = lengthTable.getDiagonalPoints();

        eventProfiler.log("Created slices");

        queue = new ArrayBlockingQueue<TablePoint>(queueSize);

        for (int j = 0; j < threadCount; j++) {
            ex.submit(new ProcessorDiagonal(j, this));
        }

        Slice slice;
        for (int i = 2; i < slices.size(); i++) {
            slice = slices.get(i);
            for (int j = 0; j < slice.size(); j++) {
                try {
                    queue.put(slice.get(j));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //ep.log("Slice " + i + " done");
        }


        // Wait till queue is empty
        while (!queue.isEmpty()) {

        }

        // Add poison pill to queue
        for (int i = 0; i < threadCount; i++) {
            queue.add(new TablePoint(-5, -5));
        }
        ex.shutdown();
        try {
            ex.awaitTermination(5, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


class ProcessorDiagonal implements Runnable {
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
        String a = new String (lcs.lengthTable.getStringA());
        String b = new String (lcs.lengthTable.getStringB());


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
                if (a.charAt(column-1) == b.charAt(row-1)) {
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
