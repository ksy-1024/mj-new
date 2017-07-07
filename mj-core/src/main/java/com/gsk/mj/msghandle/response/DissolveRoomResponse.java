package com.gsk.mj.msghandle.response;

import com.gsk.mj.net.constant.ConnectAPI;
import com.gsk.mj.net.model.ServerResponse;

import java.io.IOException;



public class DissolveRoomResponse extends ServerResponse {

	public DissolveRoomResponse(int status, String str) {
		super(status, ConnectAPI.DISSOLVE_ROOM_RESPONSE);
		if(status>0){
			try {
				output.writeUTF(str);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
           	 output.close();
			}
		}
	}

}
