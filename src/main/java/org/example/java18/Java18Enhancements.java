package org.example.java18;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.net.InetAddress;

public class Java18Enhancements {
    public static void main(String[] args) throws Throwable {
        //jweb simple server
//        var server = SimpleFileServer.createFileServer(
//                new InetSocketAddress(8080),
//                Path.of(".").toAbsolutePath(),
//                SimpleFileServer.OutputLevel.VERBOSE
//        );
//        System.out.println("server started....");
//        server.start();


//        Java 18 made UTF-8 the default character encoding across the entire JDK.
//
//          ✅ Why it matters:
//        No more platform-dependent text encoding issues — consistent behavior across OSes (Windows, macOS, Linux).


        //code snippets in java doc

        /**
         * {@snippet :
         *      System.out.println("Hello from doc!");
         *}
         */

        Sample sampleObj = new Sample();
        MethodHandles.Lookup lookup = MethodHandles.lookup();

        MethodType mt = MethodType.methodType(void.class);

        MethodHandle mh = lookup.findVirtual(Sample.class, "sayHello", mt);

        mh.invoke(sampleObj);

        //Custom InetAddress Resolver

        InetAddress addr=InetAddress.getByName("test.local");
        System.out.println("Resolved : "+addr.getHostAddress());
    }
}

class Sample {
    public void sayHello() {
        System.out.println("Hello from method handle!");
    }
}
