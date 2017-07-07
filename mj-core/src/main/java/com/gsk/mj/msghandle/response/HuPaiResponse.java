package com.gsk.mj.msghandle.response;



import com.gsk.mj.net.constant.ConnectAPI;
import com.gsk.mj.net.model.ServerResponse;

import java.io.IOException;

/**
 * 
 * @author luck
 *
 */
public class HuPaiResponse extends ServerResponse {
    /**
     * 必须调用此方法设置消息号
     *
     * @param status
     * @param  str
     */
    public HuPaiResponse(int status, String str) {
        super(status, ConnectAPI.HUPAI_RESPONSE);
        if(status >0){
            try {
            	//格式
                output.writeUTF(str);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
           	 output.close();
			}
        }
        //entireMsg();
    }
}
