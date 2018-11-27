package org.modeldd.flatbufferssamples.couplemodels;

import com.google.flatbuffers.FlatBufferBuilder;
import org.modeldd.flatbufferssamples.couplemodels.generated.*;

import java.nio.ByteBuffer;


/* schema
table NginxLogLine {
    host:string;
    clientIP:string;
    timestamp:string;
    method:string;
    url:string;
    proto:string;
    httpStatus:short;
    responseLen:int;
    referer:string;
    agent:string;
}

Sample instances in plain text as produced by the nginx proxy
SpringNut.access.log.43 192.168.69.129 - - [15/Apr/2018:13:01:47 +0200] "GET / HTTP/1.1" 200 2292 "-" "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36"
nginx-workOflow-83.log.1 192.168.99.1 - - [06/Jun/2018:00:02:44 +0200] "GET /build/main.js HTTP/1.1" 200 287069 "http://workoflow.org/" "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36"



table DmesgLogLine {
    source:string;
    level:string;
    timestamp:string;
    message:string;
}

Sample instances in plain text as produced by the nginx proxy
kern  :info  : [dom nov 25 18:10:20 2018] Initializing cgroup subsys cpuacct
kern  :notice: [dom nov 25 18:10:20 2018] Linux version 3.13.0-162-generic (buildd@lgw01-amd64-035) (gcc version 4.8.4 (Ubuntu 4.8.4-2ubuntu1~14.04.4) ) #212-Ubuntu SMP Mon Oct 29 12:08:50 UTC 2018 (Ubuntu 3.13.0-162.212-generic 3.13.11-ckt39)

*/


class MainCoupleModelsCached {
    // Example how to use FlatBuffers to create and read binary buffers.
    public static void main(String[] args) {

        System.out.println( "Running " + MainCoupleModelsCached.class.getCanonicalName());

        System.out.println( "Creating objects");

        FlatBufferBuilder aBuilder = new FlatBufferBuilder(0);

        int[] someCoupleModelsLines = new int[4];

        int anNginxLogLine01 = NginxLogLine.createNginxLogLine(
                aBuilder,
                aBuilder.createString("SpringNut.access.log.43") /* host*/,
                aBuilder.createString("192.168.69.129") /* clientIP */,
                aBuilder.createString("15/Apr/2018:13:01:47 +0200") /* timestamp */,
                aBuilder.createString("GET") /* method */,
                aBuilder.createString("/") /* url */,
                aBuilder.createString("HTTP/1.1") /* proto */,
                (short) 200 /* httpStatus */,
                2292 /* responseLen */,
                aBuilder.createString("-") /* referer */,
                aBuilder.createString("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36") /* agent */
        );
        someCoupleModelsLines[ 0] = CoupleModelsLine.createCoupleModelsLine(aBuilder, PolymorphLine.NginxLogLine, anNginxLogLine01);

        int anNginxLogLine02 = NginxLogLine.createNginxLogLine(
                aBuilder,
                aBuilder.createString("nginx-workOflow-83.log.1") /* host*/,
                aBuilder.createString("192.168.99.1") /* clientIP */,
                aBuilder.createString("06/Jun/2018:00:02:44 +0200") /* timestamp */,
                aBuilder.createString("GET") /* method */,
                aBuilder.createString("/build/main.js") /* url */,
                aBuilder.createString("HTTP/1.1") /* proto */,
                (short) 200 /* httpStatus */,
                287069 /* responseLen */,
                aBuilder.createString("http://workoflow.org/") /* referer */,
                aBuilder.createString("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36") /* agent */
        );
        someCoupleModelsLines[ 1] = CoupleModelsLine.createCoupleModelsLine(aBuilder, PolymorphLine.NginxLogLine, anNginxLogLine02);

        int aDmesgLogLine03 = DmesgLogLine.createDmesgLogLine(
                aBuilder,
                aBuilder.createString("kern") /* source*/,
                aBuilder.createString("info") /* level */,
                aBuilder.createString("dom nov 25 18:10:20 2018") /* timestamp */,
                aBuilder.createString("Initializing cgroup subsys cpuacct") /* message */
        );
        someCoupleModelsLines[ 2] = CoupleModelsLine.createCoupleModelsLine(aBuilder, PolymorphLine.DmesgLogLine, aDmesgLogLine03);

        int aDmesgLogLine04 = DmesgLogLine.createDmesgLogLine(
                aBuilder,
                aBuilder.createString("kern") /* source*/,
                aBuilder.createString("notice") /* level */,
                aBuilder.createString("dom nov 25 18:10:20 2018") /* timestamp */,
                aBuilder.createString("Linux version 3.13.0-162-generic (buildd@lgw01-amd64-035) (gcc version 4.8.4 (Ubuntu 4.8.4-2ubuntu1~14.04.4) ) #212-Ubuntu SMP Mon Oct 29 12:08:50 UTC 2018 (Ubuntu 3.13.0-162.212-generic 3.13.11-ckt39)") /* message */
        );
        someCoupleModelsLines[ 3] = CoupleModelsLine.createCoupleModelsLine(aBuilder, PolymorphLine.DmesgLogLine, aDmesgLogLine04);


        int aLinesVector = CoupleModels.createLinesVector( aBuilder, someCoupleModelsLines);
        int anEndObj = CoupleModels.createCoupleModels(aBuilder, aLinesVector);


        System.out.println( "Writting buffer");

        aBuilder.finish(anEndObj); // You could also call NginxLog.finishNginxLogBuffer( aBuilder, anEndObj);

        // We now have a FlatBuffer that can be stored on disk or sent over a network.

        // ...Code to store to disk or send over a network goes here...

        // Instead, we are going to access it right away, as if we just received it.

        ByteBuffer aDataBuffer = aBuilder.dataBuffer();

        System.out.println( "Reading buffer");


        // Get access to the root:
        CoupleModels aCoupleModels = CoupleModels.getRootAsCoupleModels(aDataBuffer);

        int aNumLines = aCoupleModels.linesLength();
        System.out.println( "NumLines=" + aNumLines);
        System.out.println( "\n");

        boolean anAnyUnsupported = false;

        for( int aLineIdx=0; aLineIdx < aNumLines; aLineIdx++) {
            CoupleModelsLine aCoupleModelsLine = aCoupleModels.lines( aLineIdx);
            byte aLineType = aCoupleModelsLine.lineType();
            switch( aLineType) {
                case PolymorphLine.DmesgLogLine:
                    DmesgLogLine aDmesgLogLine = ( DmesgLogLine) aCoupleModelsLine.line( new DmesgLogLine());
                    DmesgLogLineCached aDmesgLogLineCached = new DmesgLogLineCached( aDmesgLogLine);
                    System.out.println( "\n");
                    System.out.println( "DmesgLogLine=" + (aLineIdx + 1) + " of NumLines=" + aNumLines);
                    System.out.println("source=" + aDmesgLogLineCached.getSource());
                    System.out.println("level=" + aDmesgLogLineCached.getLevel());
                    System.out.println("timestamp=" + aDmesgLogLineCached.getTimestamp());
                    System.out.println("message=" + aDmesgLogLineCached.getMessage());

                    System.out.println( "\nAgain");

                    System.out.println("source=" + aDmesgLogLineCached.getSource());
                    System.out.println("level=" + aDmesgLogLineCached.getLevel());
                    System.out.println("timestamp=" + aDmesgLogLineCached.getTimestamp());
                    System.out.println("message=" + aDmesgLogLineCached.getMessage());

                    break;

                case PolymorphLine.NginxLogLine:
                    NginxLogLine anNginxLogLine = ( NginxLogLine) aCoupleModelsLine.line( new NginxLogLine());
                    NginxLogLineCached anNginxLogLineCached = new NginxLogLineCached( anNginxLogLine);
                    System.out.println( "\n");
                    System.out.println( "NginxLogLine=" + (aLineIdx + 1) + " of NumLines=" + aNumLines);
                    System.out.println("host=" + anNginxLogLineCached.getHost());
                    System.out.println("clientIP=" + anNginxLogLineCached.getClientIP());
                    System.out.println("timestamp=" + anNginxLogLineCached.getTimestamp());
                    System.out.println("method=" + anNginxLogLineCached.getMethod());
                    System.out.println("url=" + anNginxLogLineCached.getUrl());
                    System.out.println("proto=" + anNginxLogLineCached.getProto());
                    System.out.println("httpStatus=" + anNginxLogLineCached.getHttpStatus());
                    System.out.println("responseLen=" + anNginxLogLineCached.getResponseLen());
                    System.out.println("referer=" + anNginxLogLineCached.getReferer());
                    System.out.println("agent=" + anNginxLogLineCached.getAgent());

                    System.out.println( "\nAgain");

                    System.out.println("host=" + anNginxLogLineCached.getHost());
                    System.out.println("clientIP=" + anNginxLogLineCached.getClientIP());
                    System.out.println("timestamp=" + anNginxLogLineCached.getTimestamp());
                    System.out.println("method=" + anNginxLogLineCached.getMethod());
                    System.out.println("url=" + anNginxLogLineCached.getUrl());
                    System.out.println("proto=" + anNginxLogLineCached.getProto());
                    System.out.println("httpStatus=" + anNginxLogLineCached.getHttpStatus());
                    System.out.println("responseLen=" + anNginxLogLineCached.getResponseLen());
                    System.out.println("referer=" + anNginxLogLineCached.getReferer());
                    System.out.println("agent=" + anNginxLogLineCached.getAgent());

                    break;

                default:
                    anAnyUnsupported = true;
                    System.out.println( "\n");
                    System.out.println( "Unsupported line=" + aLineIdx + " of NumLines=" + aNumLines);
            }

        }
        System.out.println( "\n");


        if( anAnyUnsupported) {
            System.out.println("The FlatBuffer was created and verified with some Unsupported line types");
        }
        else {
            System.out.println("The FlatBuffer was successfully created and verified!");
        }
    }
}
