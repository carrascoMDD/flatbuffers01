#!/bin/bash

# Note: This script runs on Mac and Linux. It requires `java` to be installed
# and `flatc` to be built (using `cmake` in the root directory).

FLATC=../../../../original/flatbuffers/flatc

sampledir=$(cd $(dirname $BASH_SOURCE) && pwd)
rootdir=$(cd $sampledir/.. && pwd)
currentdir=$(pwd)

if [[ "$sampledir" != "$currentdir" ]]; then
  echo Error: This script must be run from inside the $sampledir directory.
  echo You executed it from the $currentdir directory.
  exit 1
fi

# Run `flatc`. Note: This requires you to compile using `cmake` from the
# root `/flatbuffers` directory.
if [ -e $FLATC ]; then
  $FLATC --java -o ${sampledir}/src   --gen-mutable nginxlog.fbs
elif [ -e ../Debug/flatc ]; then
  ../Debug/flatc -o ${sampledir}/src  --java --gen-mutable nginxlog.fbs
else
  echo 'flatc' could not be found. Make sure to build FlatBuffers from the \
       $rootdir directory.
  exit 1
fi

echo Compiling and running the Java sample.

# Compile and execute the sample.
javac -classpath ${sampledir}/src ./src/org/modeldd/flatbufferssamples/nginxlog/MainNginxLog.java

java -classpath ${sampledir}/src org.modeldd.flatbufferssamples.nginxlog.MainNginxLog

# Cleanup temporary files.
# rm -rf MyGame/
# rm ${sampledir}/../java/com/google/flatbuffers/*.class
# rm *.class

