package org.example.java18;

import java.lang.module.Configuration;
import java.net.UnknownHostException;

public abstract class InetAddressResolverProvider {
    public abstract InetAddressResolverProvider get(Configuration configuration) throws UnknownHostException;
}
