package com.gsk.mj.msghandle.response;


import com.gsk.mj.net.constant.ConnectAPI;
import com.gsk.mj.net.model.ServerResponse;
import com.gsk.mj.util.JsonUtilTool;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kevin on 2016/6/23.
 */
public class ChuPaiResponse extends ServerResponse {
    /**
     * 必须调用此方法设置消息号
     *
     * @param status  cardIndex牌点数   curAvatarIndex出牌人的索引
     * @param 
     */
    public ChuPaiResponse(int status, int cardIndex,int curAvatarIndex) {
        super(status, ConnectAPI.CHUPAI_RESPONSE);
        Map<String , Integer> json = new HashMap<>();
        json.put("cardIndex", cardIndex);
        json.put("curAvatarIndex", curAvatarIndex);
        if(status >0){
            try {
                output.writeUTF(JsonUtilTool.toJson(json));
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
           	 output.close();
			}
        }
       // entireMsg();
    }
}
