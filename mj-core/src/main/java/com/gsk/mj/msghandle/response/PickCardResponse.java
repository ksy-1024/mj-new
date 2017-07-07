package com.gsk.mj.msghandle.response;



import com.gsk.mj.msghandle.pojo.CardVO;
import com.gsk.mj.net.constant.ConnectAPI;
import com.gsk.mj.net.model.ServerResponse;
import com.gsk.mj.util.JsonUtilTool;

import java.io.IOException;

/**
 * Created by kevin on 2016/6/23.
 */
public class PickCardResponse extends ServerResponse {
    /**
     * 必须调用此方法设置消息号
     *
     * @param status
     * @param
     *  == 100 时表示是询问海底捞还是不捞
     */
    public PickCardResponse(int status,int cardPoint) {
        super(status, ConnectAPI.PICKCARD_RESPONSE);
        CardVO cardVO = new CardVO();
        cardVO.setCardPoint(cardPoint);
        try {
            output.writeUTF(JsonUtilTool.toJson(cardVO));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
