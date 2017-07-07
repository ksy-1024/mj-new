package com.gsk.mj.net;

import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/7/5.
 *
 */
@Component
public class NetManager {


    @Autowired
    private NioSocketAcceptor frontAcceptor;

    public NioSocketAcceptor getFrontAcceptor() {
        return frontAcceptor;
    }

    public void setFrontAcceptor(NioSocketAcceptor frontAcceptor) {
        this.frontAcceptor = frontAcceptor;
    }


}
