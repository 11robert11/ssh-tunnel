package com.company.config;

import com.company.config.hosts.DestinationHost;

import java.util.HashMap;
import java.util.Map;

public class Config {
    private Map<String, DestinationHost> destinationHosts = new HashMap<>();

    Config() {}

    public Map<String, DestinationHost> getDestinationHosts()   {
        return destinationHosts;
    }
    public void setDestinationHosts(Map<String, DestinationHost> destinationHosts)  {
        this.destinationHosts = destinationHosts;
    }
}
