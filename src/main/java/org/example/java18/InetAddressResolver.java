package org.example.java18;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.stream.Stream;

public interface InetAddressResolver {
    Stream<InetAddress> lookupByName(String host) throws UnknownHostException;
    String lookupByAddress(byte[] addr) throws UnknownHostException;
}
