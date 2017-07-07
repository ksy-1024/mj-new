package com.gsk.mj.msghandle.response;



import com.gsk.mj.net.constant.ConnectAPI;
import com.gsk.mj.net.model.ServerResponse;
import com.gsk.mj.util.JsonUtilTool;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author luck
 *
 */
public class PengResponse extends ServerResponse {
    /**
     * 必须调用此方法设置消息号
     *
     * @param status
     * @param
     */
    public PengResponse(int status, int cardPoint,int AvatarId) {
        super(status, ConnectAPI.PENGPAI_RESPONSE);
        try {
            Map<String , Integer> jsonObject = new HashMap<>();
            jsonObject.put("cardPoint",cardPoint);
            jsonObject.put("avatarId",AvatarId);
            output.writeUTF(JsonUtilTool.toJson(jsonObject));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
