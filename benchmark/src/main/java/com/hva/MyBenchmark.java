/*
 * Copyright (c) 2014, Oracle America, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 *  * Neither the name of Oracle nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.hva;

import com.hva.lcs.LcsAlgorithm;
import com.hva.lcs.util.LcsTestSet;
import org.openjdk.jmh.annotations.*;
import java.util.concurrent.TimeUnit;

import static com.hva.lcs.util.LcsInputStringFactory.LcsPositionWithinString.START;

@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@State(Scope.Thread)
public class MyBenchmark {
    private LcsAlgorithm lcsSequential;
    private LcsTestSet ts1;
    private LcsTestSet ts2;
    private LcsTestSet ts3;

    private LcsTestSet ts4;
    private LcsTestSet ts5;
    private LcsTestSet ts6;

    @Setup
    public void init() {
        // This is a demo/sample template for building your JMH benchmarks. Edit as needed.
        // Put your benchmark code here.
        int testSetSize1 = 1000;
        String a =

        ts1 = new LcsTestSet(LcsInputStringFactory.createInputString("ADH", START, '+'));
        ts2 = new LcsTestSet("ADH",1000);
        ts3 = new LcsTestSet("ADH",10000);

        ts4 = new LcsTestSet("ADH",1000);
        ts5 = new LcsTestSet("ABCDEFGHIJK",1000);
        ts6 = new LcsTestSet("AAA",1000);



        lcsSequential = new LcsSequential(new LengthTable());

        lcsConcurrent = new LcsConcurrentDiagonal(new LengthTable(), 4, 1000);
    }

    @Benchmark
    public void sequential1() {
        // This is a demo/sample template for building your JMH benchmarks. Edit as needed.
        // Put your benchmark code here.
        lcsSequential.findLongestCommonSubsequence(ts1.getStringA(),ts1.getStringB(), false, false);
    }
    @Benchmark
    public void sequential2() {
        // This is a demo/sample template for building your JMH benchmarks. Edit as needed.
        // Put your benchmark code here.
        lcsSequential.findLongestCommonSubsequence(ts2.getStringA(),ts2.getStringB(), false, false);
    }
    @Benchmark
    public void sequential3() {
        // This is a demo/sample template for building your JMH benchmarks. Edit as needed.
        // Put your benchmark code here.
        lcsSequential.findLongestCommonSubsequence(ts3.getStringA(),ts3.getStringB(), false, false);
    }
    @Benchmark
    public void sequential4() {
        // This is a demo/sample template for building your JMH benchmarks. Edit as needed.
        // Put your benchmark code here.
        lcsSequential.findLongestCommonSubsequence(ts4.getStringA(),ts4.getStringB(), false, false);
    }
    @Benchmark
    public void sequential5() {
        // This is a demo/sample template for building your JMH benchmarks. Edit as needed.
        // Put your benchmark code here.
        lcsSequential.findLongestCommonSubsequence(ts5.getStringA(),ts5.getStringB(), false, false);
    }
    @Benchmark
    public void sequential6() {
        // This is a demo/sample template for building your JMH benchmarks. Edit as needed.
        // Put your benchmark code here.
        lcsSequential.findLongestCommonSubsequence(ts6.getStringA(),ts6.getStringB(), false, false);
    }

    @Benchmark
    public void concurrent1() {
        // This is a demo/sample template for building your JMH benchmarks. Edit as needed.
        // Put your benchmark code here.
        lcsConcurrent.findLongestCommonSubsequence(ts1.getStringA(),ts1.getStringB(), false, false);
    }
    @Benchmark
    public void concurrent2() {
        // This is a demo/sample template for building your JMH benchmarks. Edit as needed.
        // Put your benchmark code here.
        lcsConcurrent.findLongestCommonSubsequence(ts2.getStringA(),ts2.getStringB(), false, false);
    }
    @Benchmark
    public void concurrent3() {
        // This is a demo/sample template for building your JMH benchmarks. Edit as needed.
        // Put your benchmark code here.
        lcsConcurrent.findLongestCommonSubsequence(ts3.getStringA(),ts3.getStringB(), false, false);
    }
    @Benchmark
    public void concurrent4() {
        // This is a demo/sample template for building your JMH benchmarks. Edit as needed.
        // Put your benchmark code here.
        lcsConcurrent.findLongestCommonSubsequence(ts4.getStringA(),ts4.getStringB(), false, false);
    }
    @Benchmark
    public void concurrent5() {
        // This is a demo/sample template for building your JMH benchmarks. Edit as needed.
        // Put your benchmark code here.
        lcsConcurrent.findLongestCommonSubsequence(ts5.getStringA(),ts5.getStringB(), false, false);
    }
    @Benchmark
    public void concurrent6() {
        // This is a demo/sample template for building your JMH benchmarks. Edit as needed.
        // Put your benchmark code here.
        lcsConcurrent.findLongestCommonSubsequence(ts6.getStringA(),ts6.getStringB(), false, false);
    }
}
