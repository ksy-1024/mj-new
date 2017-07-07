package com.gsk.mj.msghandle.response;



import com.gsk.mj.msghandle.pojo.GangBackVO;
import com.gsk.mj.net.constant.ConnectAPI;
import com.gsk.mj.net.model.ServerResponse;
import com.gsk.mj.util.JsonUtilTool;

import java.io.IOException;


/**
 * 
 * @author luck
 *
 */
public class GangResponse extends ServerResponse {
    /**
     *
     * @param status
     * @param fristPoint 第一张牌
     * @param nextPoint 第二张牌
     * @param type  明杠0 ， 暗杠 1
     */
	public GangResponse(int status, int fristPoint,int nextPoint,int type) {
        super(status, ConnectAPI.GANGPAI_RESPONSE);
        if(status >0){
            GangBackVO gangBackVO = new GangBackVO();
           /* List<Integer> cardVOList = new ArrayList<Integer>();
            //=========================================
            if(fristPoint != 100) {
                cardVOList.add(fristPoint);
            }
            //=========================================
            if(nextPoint != 100) {
                cardVOList.add(nextPoint);
            }
            //=========================================
            gangBackVO.setCardList(cardVOList);*/  //2016-8-1
            gangBackVO.setType(type);
            try {
                output.writeUTF(JsonUtilTool.toJson(gangBackVO));
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
           	 output.close();
			}
        }
       // entireMsg();
    }
}
