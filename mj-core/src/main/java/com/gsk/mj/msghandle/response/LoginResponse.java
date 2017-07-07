package com.gsk.mj.msghandle.response;



import com.gsk.mj.msghandle.pojo.AvatarVO;
import com.gsk.mj.net.constant.ConnectAPI;
import com.gsk.mj.net.model.ServerResponse;
import com.gsk.mj.util.JsonUtilTool;

import java.io.IOException;

public class LoginResponse extends ServerResponse {

	
	
	public LoginResponse(int status, AvatarVO avatarVO) {
		super(status, ConnectAPI.LOGIN_RESPONSE);
		try {
			//output.writeBoolean(isSuccess);
			if(status > 0) {
				//System.out.println("avatarVO   =  "+JsonUtilTool.toJson(avatarVO));
				output.writeUTF(JsonUtilTool.toJson(avatarVO));
			}
			//entireMsg();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
       	 output.close();
		}
	}
	
}
