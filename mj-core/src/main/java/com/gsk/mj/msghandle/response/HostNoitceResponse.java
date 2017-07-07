package com.gsk.mj.msghandle.response;



import com.gsk.mj.net.constant.ConnectAPI;
import com.gsk.mj.net.model.ServerResponse;

import java.io.IOException;


/**
 * 
 * @author luck
 * 后台更新公告后发送给前段
 *
 */
public class HostNoitceResponse extends ServerResponse {
	public HostNoitceResponse(int status, String noitce) {
        super(status, ConnectAPI.HOST_SEND_RESPONSE);
        if(status >0){
            try {
            	
                output.writeUTF(noitce);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
           	 output.close();
			}
        }
       // entireMsg();
    }
}
