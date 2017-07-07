package com.gsk.mj.msghandle.response;


import com.gsk.mj.msghandle.pojo.RoomVO;
import com.gsk.mj.net.constant.ConnectAPI;
import com.gsk.mj.net.model.ServerResponse;
import com.gsk.mj.util.JsonUtilTool;

import java.io.IOException;

public class JoinRoomResponse extends ServerResponse {

	public JoinRoomResponse(int status,RoomVO roomVO) {
		super(status, ConnectAPI.JOIN_ROOM_RESPONSE);
		try {
			if(status>0){
					output.writeUTF(JsonUtilTool.toJson(roomVO));
			}
			else{
				output.writeUTF(roomVO.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
       	 output.close();
		}
		//entireMsg();
	}

}
