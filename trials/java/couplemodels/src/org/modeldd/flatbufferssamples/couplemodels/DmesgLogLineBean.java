package org.modeldd.flatbufferssamples.couplemodels;

import java.util.Objects;

public class DmesgLogLineBean {
    /*
    source @0 :Text;
    level @1 :Text;
    timestamp @2 :Text;
    message @3 :Text;
    */
    protected String source;
    protected String level;
    protected String timestamp;
    protected String message;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DmesgLogLineBean)) return false;
        DmesgLogLineBean that = (DmesgLogLineBean) o;
        return Objects.equals(getSource(), that.getSource()) &&
                Objects.equals(getLevel(), that.getLevel()) &&
                Objects.equals(getTimestamp(), that.getTimestamp()) &&
                Objects.equals(getMessage(), that.getMessage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSource(), getLevel(), getTimestamp(), getMessage());
    }
}

