package com.gsk.mj.msghandle.impl;


import com.gsk.mj.msghandle.MsgProcessor;
import com.gsk.mj.msghandle.response.OpenAppResponse;
import com.gsk.mj.net.model.ClientRequest;
import com.gsk.mj.net.session.GameSession;

/**
 * 
 *用户打开应用时，做一些初始化操作
 * @author  daiyongzhi
 * @date 2015年1月28日 下午1:15:21
 * @version V1.0
 */
public class OpenAppMsgProcessor extends MsgProcessor{

	@Override
	public void process(GameSession gameSession, ClientRequest request)
			throws Exception {
		gameSession.sendMsg(new OpenAppResponse(1,"welecome !"));
		
		
	}

}
