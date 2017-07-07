package com.gsk.mj.msghandle.response;

import com.gsk.mj.net.constant.ConnectAPI;
import com.gsk.mj.net.model.ServerResponse;

import java.io.IOException;



public class RoomCardChangerResponse extends ServerResponse {

	public RoomCardChangerResponse(int status, int msgCode) {
		 super(status, ConnectAPI.ROOMCARDCHANGER_RESPONSE);
	        if(status >0){
	            try {
	                output.writeUTF(msgCode+"");
	            } catch (IOException e) {
	                e.printStackTrace();
	            } finally {
	           	 output.close();
				}
	        }
		
	}

}
