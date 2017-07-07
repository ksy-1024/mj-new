package com.gsk.mj.msghandle.response;

import com.gsk.mj.net.constant.ConnectAPI;
import com.gsk.mj.net.model.ServerResponse;

import java.io.IOException;

/**
 * 通知前端 返回到登录界面
 * @author luck
 *
 */
public class BreakLineResponse extends ServerResponse {

	
	
	public BreakLineResponse(int status) {
		super(status, ConnectAPI.BREAK_LINE_RESPONSE);
		try {
			if(status > 0) {
				output.writeUTF("1");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
       	 output.close();
		}
	}
	
}
