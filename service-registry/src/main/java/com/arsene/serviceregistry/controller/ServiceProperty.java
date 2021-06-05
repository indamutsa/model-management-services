package com.arsene.serviceregistry.controller;

public class ServiceProperty {
    private String appName;
    private String ipAddress;
    private String hostName;

    public ServiceProperty() {
    }

    public ServiceProperty(String appName, String ipAddress, String hostName) {
        this.appName = appName;
        this.ipAddress = ipAddress;
        this.hostName = hostName;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    @Override
    public String toString() {
        return "ServiceProperty{" +
                "appName='" + appName + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", hostName='" + hostName + '\'' +
                '}';
    }
}
