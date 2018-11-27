package org.modeldd.flatbufferssamples.couplemodels;

import org.modeldd.flatbufferssamples.couplemodels.generated.NginxLogLine;

public final class NginxLogLineFacade {
    /*
    host @0 :Text;
    clientIP @1 :Text;
    timestamp @2 :Text;
    method @3 :Text;
    url @4 :Text;
    proto @5 :Text;
    httpStatus @6 :Int16;
    responseLen @7 :Int32;
    referer @8 :Text;
    agent @9 :Text;
     */

    private NginxLogLine nginxLogLine;


    public NginxLogLineFacade(NginxLogLine theNginxLogLine) {
        this.nginxLogLine = theNginxLogLine;
    }

    public String getHost() {
        return this.nginxLogLine.host();
    }

    public String getClientIP() {
        return this.nginxLogLine.clientIP();
    }

    public String getTimestamp() {
        return this.nginxLogLine.timestamp();
    }

    public String getMethod() {
        return this.nginxLogLine.method();
    }

    public String getUrl() {
        return this.nginxLogLine.url();
    }

    public String getProto() {
        return this.nginxLogLine.proto();
    }

    public short getHttpStatus() {
        return this.nginxLogLine.httpStatus();
    }

    public int getResponseLen() {
        return this.nginxLogLine.responseLen();
    }

    public String getReferer() {
        return this.nginxLogLine.referer();
    }

    public String getAgent() {
        return this.nginxLogLine.agent();
    }

}

