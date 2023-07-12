package com.mjc.stage2.impl;


import com.mjc.stage2.Connection;

public class ProxyConnection implements Connection {
    private RealConnection realConnection;

    public ProxyConnection(RealConnection realConnection) {

        this.realConnection = realConnection;
    }

    public void reallyClose() {
        // Write your code here!
        // my implementation 10.07
        realConnection.close();
    }

    // Implement methods here!
    @Override
    public void close() {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        connectionPool.releaseConnection(realConnection);

    }
    // my implementation 10.07
    @Override
    public boolean isClosed() {
        return realConnection.isClosed();
        //return false;
    }
}
