package com.gsk.mj.net.Handle;

import com.gsk.mj.net.constant.ConnectAPI;
import com.gsk.mj.net.model.ClientRequest;
import com.gsk.mj.net.model.ServerResponse;
import com.gsk.mj.net.session.GameSession;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/7/5.
 *
 */
@Component
public class FrontMsgHandle extends IoHandlerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(FrontMsgHandle.class);

    @Override
    public void sessionOpened(IoSession session) throws Exception{
        logger.info("a session create from ip {}",session.getRemoteAddress());
        new GameSession(session);
    }

    @Override
    public void messageReceived(IoSession session, Object message)
            throws Exception {
        logger.info("receive message from front");
        ClientRequest clientRequest = (ClientRequest) message;
        GameSession gameSession = GameSession.getInstance(session);
        if (gameSession == null) {
            //logger.info("gameSession == null");
            return;
        }
        if(clientRequest.getMsgCode() == ConnectAPI.LOGIN_REQUEST){
            gameSession.sendMsg(new ServerResponse(1 , 2 , "Hello , Friend"));
        }
        else {
            gameSession.sendMsg(new ServerResponse(2 , 33 , "Hello , Friend"));
        }

//        GameServer.msgDispatcher.dispatchMsg(gameSession,clientRequest);
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause)
            throws Exception {
        //强制退出
        //logger.error("服务器出错 {}",cause.getMessage());
        //cause.printStackTrace();
    }

    /**
     * 关闭SESSION
     * @param session
     * @throws Exception
     */
    @Override
    public void sessionClosed(IoSession session) throws Exception {
        //logger.info("a session closed ip:{}",session.getRemoteAddress());
        GameSession gameSession = GameSession.getInstance(session);
        if(gameSession!=null){
            gameSession.close();
        }

    }
}
