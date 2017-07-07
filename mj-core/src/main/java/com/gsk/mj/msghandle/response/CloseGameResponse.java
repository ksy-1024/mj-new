package com.gsk.mj.msghandle.response;



import com.gsk.mj.net.constant.ConnectAPI;
import com.gsk.mj.net.model.ServerResponse;

import java.io.IOException;

/**
 * 关闭游戏之后向所有线程的玩家发送关闭游戏的消息
 * @author luck
 *
 */
public class CloseGameResponse extends ServerResponse {
    /**
     * 必须调用此方法设置消息号
     *
     * @param status
     * @param  str
     */
    public CloseGameResponse(int status, String str) {
        super(status, ConnectAPI.CLOSE_RESPONSE);
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
       // entireMsg();
    }
}
