package com.company.config.hosts;

public class DestinationHost {
    private String userName;
    private String hostName;
    private int port;
    private String identityFile;
    private JumpHost jumpHost;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getIdentityFile() {
        return identityFile;
    }

    public void setIdentityFile(String identityFile) {
        this.identityFile = identityFile;
    }

    public JumpHost getJumpHost() {
        return jumpHost;
    }

    public void setJumpHost(JumpHost jumpHost) {
        this.jumpHost = jumpHost;
    }
}
