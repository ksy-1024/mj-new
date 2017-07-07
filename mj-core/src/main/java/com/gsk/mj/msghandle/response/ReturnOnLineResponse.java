package com.gsk.mj.msghandle.response;

import com.gsk.mj.net.constant.ConnectAPI;
import com.gsk.mj.net.model.ServerResponse;

import java.io.IOException;



public class ReturnOnLineResponse extends ServerResponse {

	public ReturnOnLineResponse(int status, String str) {
		
		super(status, ConnectAPI.RETURN_ONLINE_RESPONSE);
		 if(status >0){
	            try {
	            	//格式
	                output.writeUTF(str);
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	}

}
