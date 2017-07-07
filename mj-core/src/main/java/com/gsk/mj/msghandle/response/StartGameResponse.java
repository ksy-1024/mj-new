package com.gsk.mj.msghandle.response;

import java.io.IOException;

import com.alibaba.fastjson.JSONObject;
import com.gsk.mj.net.constant.ConnectAPI;
import com.gsk.mj.net.model.ServerResponse;


public class StartGameResponse extends ServerResponse {
    /**
    *
    * @param status
    * @param paiArray 自己的牌数组
    * @param bankerId 庄家ID
    */
   public StartGameResponse(int status, int[][] paiArray,int bankerId) {
       super(status, ConnectAPI.STARTGAME_RESPONSE);
       try {
           JSONObject json = new JSONObject();
           json.put("paiArray",paiArray);
           json.put("bankerId",bankerId);
           output.writeUTF(json.toString());
       } catch (IOException e) {
           e.printStackTrace();
       }
       entireMsg();
   }

}
