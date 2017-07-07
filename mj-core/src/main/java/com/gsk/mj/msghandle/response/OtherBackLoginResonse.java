package com.gsk.mj.msghandle.response;

import com.gsk.mj.net.constant.ConnectAPI;
import com.gsk.mj.net.model.ServerResponse;

import java.io.IOException;


public class OtherBackLoginResonse extends ServerResponse {

	public OtherBackLoginResonse(int status, String uuid) {
		super(status, ConnectAPI.OTHER_BACK_LOGIN_RESPONSE);
		try {
			if(status>0){
					output.writeUTF(uuid);
			}
			else{
				//output.writeUTF(roomVO.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
       	 output.close();
		}
	}

}
