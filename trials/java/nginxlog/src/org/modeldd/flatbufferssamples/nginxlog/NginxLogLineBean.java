package org.modeldd.flatbufferssamples.nginxlog;

import java.util.Objects;

public class NginxLogLineBean {
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
    protected String host;
    protected String clientIP;
    protected String timestamp;
    protected String method;
    protected String url;
    protected String proto;
    protected short httpStatus;
    protected int responseLen;
    protected String referer;
    protected String agent;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getClientIP() {
        return clientIP;
    }

    public void setClientIP(String clientIP) {
        this.clientIP = clientIP;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProto() {
        return proto;
    }

    public void setProto(String proto) {
        this.proto = proto;
    }

    public short getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(short httpStatus) {
        this.httpStatus = httpStatus;
    }

    public int getResponseLen() {
        return responseLen;
    }

    public void setResponseLen(int responseLen) {
        this.responseLen = responseLen;
    }

    public String getReferer() {
        return referer;
    }

    public void setReferer(String referer) {
        this.referer = referer;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NginxLogLineBean)) return false;
        NginxLogLineBean that = (NginxLogLineBean) o;
        return getHttpStatus() == that.getHttpStatus() &&
                getResponseLen() == that.getResponseLen() &&
                Objects.equals(getHost(), that.getHost()) &&
                Objects.equals(getClientIP(), that.getClientIP()) &&
                Objects.equals(getTimestamp(), that.getTimestamp()) &&
                Objects.equals(getMethod(), that.getMethod()) &&
                Objects.equals(getUrl(), that.getUrl()) &&
                Objects.equals(getProto(), that.getProto()) &&
                Objects.equals(getReferer(), that.getReferer()) &&
                Objects.equals(getAgent(), that.getAgent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHost(), getClientIP(), getTimestamp(), getMethod(), getUrl(), getProto(), getHttpStatus(), getResponseLen(), getReferer(), getAgent());
    }
}

