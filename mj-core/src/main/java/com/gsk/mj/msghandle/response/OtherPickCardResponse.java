package com.gsk.mj.msghandle.response;



import com.alibaba.fastjson.JSONObject;
import com.gsk.mj.net.constant.ConnectAPI;
import com.gsk.mj.net.model.ServerResponse;

import java.io.IOException;

/**
 * Created by kevin on 2016/7/5.
 */
public class OtherPickCardResponse extends ServerResponse {
    /**
     * 必须调用此方法设置消息号
     *
     * @param status
     * @param avatarIndex
     */
    public OtherPickCardResponse(int status, int avatarIndex) {
        super(status, ConnectAPI.OTHER_PICKCARD_RESPONSE);
        JSONObject json = new JSONObject();
        json.put("avatarIndex",avatarIndex);
        if(status >0){
            try {
            	//System.out.println("发送摸牌信息给其他玩家-----摸牌人索引："+avatarIndex);
                output.writeUTF(json.toString());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
           	 output.close();
			}
        }
       // entireMsg();
    }
}
