package org.example.java18;
import java.net.*;
import java.net.spi.InetAddressResolver;
import java.net.spi.InetAddressResolverProvider;
import java.util.stream.Stream;

public class CustomDnsResolverProvider extends InetAddressResolverProvider {

    @Override
    public InetAddressResolver get(Configuration configuration) {
        return new InetAddressResolver() {
            @Override
            public Stream<InetAddress> lookupByName(String host, LookupPolicy lookupPolicy) throws UnknownHostException {
                System.out.println("Custom resolver called for: " + host);
                if (host.equalsIgnoreCase("test.local")) {
                    return Stream.of(InetAddress.getByName("127.0.0.1"));
                }
                // Fallback to default resolver
                return Stream.of(InetAddress.getByName(host));
            }

            @Override
            public String lookupByAddress(byte[] addr) throws UnknownHostException {
                return InetAddress.getByAddress(addr).getHostName();
            }
        };
    }

    @Override
    public String name() {
        return "CustomDNS";
    }
}
