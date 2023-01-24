package com.company.config;

import java.util.Locale;

public class Tunnel {
    private String name;
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    private Endpoint endpoint;
    public void setEndpoint(String endpoint) {
        switch (endpoint.toUpperCase(Locale.ROOT)) {
            case "LOCAL" -> this.endpoint = Endpoint.LOCAL;
            case "REMOTE" -> this.endpoint = Endpoint.REMOTE;
        }
    }

    public Endpoint getEndpoint_()   {
        return endpoint;
    }




    String localAddress;
    int localPort;
    public void setLocalBinding(String binding) throws Exception {
        this.localPort = Integer.parseInt(binding.split(":")[1]);
        if(this.localPort > 65535)  throw new Exception();

        this.localAddress = binding.split(":")[0];

    }

    int remotePort;
    String remoteAddress;
    public void setRemoteBinding(String binding) throws Exception {
        this.remotePort = Integer.parseInt(binding.split(":")[1]);
        if(this.remotePort > 65535)  throw new Exception();

        this.remoteAddress = binding.split(":")[0];

    }
    @Override
    public String toString() {
        return "Tunnel{" +
                "name='" + name + '\'' +
                ", endpoint=" + endpoint +
                ", localAddress='" + localAddress + '\'' +
                ", localPort=" + localPort +
                ", remotePort=" + remotePort +
                ", remoteAddress='" + remoteAddress + '\'' +
                '}';
    }

}
enum Endpoint   {
    LOCAL,
    REMOTE
}