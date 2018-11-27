package org.modeldd.flatbufferssamples.couplemodels;

import org.modeldd.flatbufferssamples.couplemodels.generated.DmesgLogLine;

public final class DmesglogLineCapnpFacade {
    /*
    source @0 :Text;
    level @1 :Text;
    timestamp @2 :Text;
    message @3 :Text;
     */

    private DmesgLogLine dmesgLogLine;


    public DmesglogLineCapnpFacade(DmesgLogLine theNginxLogLineCapnpReader) {
        this.dmesgLogLine = theNginxLogLineCapnpReader;
    }

    public String getSource() {
        return this.dmesgLogLine.source().toString();
    }

    public String getLevel() {
        return this.dmesgLogLine.level().toString();
    }

    public String getTimestamp() {
        return this.dmesgLogLine.timestamp().toString();
    }

    public String getMessage() {
        return this.dmesgLogLine.message().toString();
    }

}

