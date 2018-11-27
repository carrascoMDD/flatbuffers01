package org.modeldd.flatbufferssamples.couplemodels;

import org.modeldd.flatbufferssamples.couplemodels.generated.DmesgLogLine;

public final class DmesgLogLineFacade {
    /*
    source @0 :Text;
    level @1 :Text;
    timestamp @2 :Text;
    message @3 :Text;
     */

    private DmesgLogLine dmesgLogLine;


    public DmesgLogLineFacade(DmesgLogLine theNginxLogLineCapnpReader) {
        this.dmesgLogLine = theNginxLogLineCapnpReader;
    }

    public String getSource() {
        return this.dmesgLogLine.source();
    }

    public String getLevel() {
        return this.dmesgLogLine.level();
    }

    public String getTimestamp() {
        return this.dmesgLogLine.timestamp();
    }

    public String getMessage() {
        return this.dmesgLogLine.message();
    }

}

