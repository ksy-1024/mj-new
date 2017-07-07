package com.gsk.mj.msghandle.manage;

import com.gsk.mj.msghandle.MsgProcessor;
import com.gsk.mj.msghandle.impl.LoginMsgProcessor;
import com.gsk.mj.msghandle.impl.OpenAppMsgProcessor;
import com.gsk.mj.net.constant.ConnectAPI;

/**
 * Created by Administrator on 2017/7/6.
 */
public enum MsgProcessorRegister {
    /**用户打开app*/
    openApp(ConnectAPI.OPENAPP_REQUEST,new OpenAppMsgProcessor()),
    /**登陆处理器*//**断线重连**/
    login(ConnectAPI.LOGIN_REQUEST,new LoginMsgProcessor()),
    ;

    private int msgCode;
    private MsgProcessor processor;

    /**
     * 不允许外部创建
     * @param msgCode
     * @param processor
     */
    private MsgProcessorRegister(int msgCode,MsgProcessor processor){
        this.msgCode = msgCode;
        this.processor = processor;
    }
}
