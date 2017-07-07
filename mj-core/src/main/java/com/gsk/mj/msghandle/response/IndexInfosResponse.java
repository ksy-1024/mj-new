package com.gsk.mj.msghandle.response;


import com.gsk.mj.net.constant.ConnectAPI;
import com.gsk.mj.net.model.ServerResponse;

import java.io.IOException;


/**
 * 
 * @author luck
 * 后台获取了游戏信息之后发送给前段
 *
 */
public class IndexInfosResponse extends ServerResponse {
	public IndexInfosResponse(int status, String content) {
        super(status, ConnectAPI.HOST_INDEXINFOS_RESPONSE);
        if(status >0){
            try {
                output.writeUTF(content);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
           	 output.close();
			}
        }
       // entireMsg();
    }
}
