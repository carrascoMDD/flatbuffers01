@0x9eb32e19f86ee171;

using Cxx = import "/capnp/c++.capnp";
$Cxx.namespace("nginxlog");

using Java = import "/capnp/java.capnp";
$Java.package("org.capnproto.examples");
$Java.outerClassname("NginxlogCapnp");


# SpringNut.access.log.43 192.168.69.129 - - [15/Apr/2018:13:01:47 +0200] "GET / HTTP/1.1" 200 2292 "-" "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36"
# nginx-workOflow-83.log.1 192.168.99.1 - - [06/Jun/2018:00:02:44 +0200] "GET /build/main.js HTTP/1.1" 200 287069 "http://workoflow.org/" "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36"

struct NginxLogLine {
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
}

struct NginxLog {
  lines @0 :List(NginxLogLine);
}

