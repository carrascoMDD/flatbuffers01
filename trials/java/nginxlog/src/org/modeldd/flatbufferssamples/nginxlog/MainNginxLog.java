package org.modeldd.flatbufferssamples.nginxlog;

import java.nio.ByteBuffer;

import com.google.flatbuffers.FlatBufferBuilder;

import org.modeldd.flatbufferssamples.nginxlog.generated.NginxLog;
import org.modeldd.flatbufferssamples.nginxlog.generated.NginxLogLine;


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
*/


class MainNginxLog {
    // Example how to use FlatBuffers to create and read binary buffers.
    public static void main(String[] args) {

        System.out.println( "Creating objects");

        FlatBufferBuilder aBuilder = new FlatBufferBuilder(0);

        int[] someLines = new int[2];
        someLines[0] = NginxLogLine.createNginxLogLine(
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

        someLines[1] = NginxLogLine.createNginxLogLine(
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

        int aLines = NginxLog.createLinesVector(aBuilder, someLines);

        NginxLog.startNginxLog(aBuilder);
        NginxLog.addLines(aBuilder, aLines);
        int anEndObj = NginxLog.endNginxLog(aBuilder);

        System.out.println( "Writting buffer");

        aBuilder.finish(anEndObj); // You could also call NginxLog.finishNginxLogBuffer( aBuilder, anEndObj);

        // We now have a FlatBuffer that can be stored on disk or sent over a network.

        // ...Code to store to disk or send over a network goes here...

        // Instead, we are going to access it right away, as if we just received it.

        ByteBuffer aDataBuffer = aBuilder.dataBuffer();

        System.out.println( "Reading buffer");


        // Get access to the root:
        NginxLog anNginxLog = NginxLog.getRootAsNginxLog(aDataBuffer);

        int aNumLines = anNginxLog.linesLength();
        System.out.println( "NumLines=" + aNumLines);
        System.out.println( "\n");

        for( int aLineIdx=0; aLineIdx < aNumLines; aLineIdx++) {
            NginxLogLine anNginxLogLine = anNginxLog.lines( aLineIdx);
            System.out.println( "\n");
            System.out.println( "Line=" + aLineIdx + " of NumLines=" + aNumLines);
            System.out.println("host=" + anNginxLogLine.host());
            System.out.println("clientIP=" + anNginxLogLine.clientIP());
            System.out.println("timestamp=" + anNginxLogLine.timestamp());
            System.out.println("method=" + anNginxLogLine.method());
            System.out.println("url=" + anNginxLogLine.url());
            System.out.println("proto=" + anNginxLogLine.proto());
            System.out.println("httpStatus=" + anNginxLogLine.httpStatus());
            System.out.println("responseLen=" + anNginxLogLine.responseLen());
            System.out.println("referer=" + anNginxLogLine.referer());
            System.out.println("agent=" + anNginxLogLine.agent());
        }
        System.out.println( "\n");

        System.out.println("The FlatBuffer was successfully created and verified!");
    }
}
