package com.blued.android.chat.model;

import com.blued.android.chat.utils.MsgPackHelper;
import java.util.Map;

public class FlashVideoGiftModel {
  public int addLike;
  
  public int addTime;
  
  public String giftIcon;
  
  public String giftName;
  
  public String roomId;
  
  public int totalLike;
  
  public int totalTime;
  
  public static FlashVideoGiftModel parseData(Map<String, Object> paramMap) {
    if (paramMap != null) {
      FlashVideoGiftModel flashVideoGiftModel = new FlashVideoGiftModel();
      flashVideoGiftModel.roomId = MsgPackHelper.getStringValue(paramMap, "room_id");
      flashVideoGiftModel.addTime = MsgPackHelper.getIntValue(paramMap, "overtime");
      flashVideoGiftModel.addLike = MsgPackHelper.getIntValue(paramMap, "like");
      flashVideoGiftModel.totalTime = MsgPackHelper.getIntValue(paramMap, "total_time");
      flashVideoGiftModel.totalLike = MsgPackHelper.getIntValue(paramMap, "total_like");
      flashVideoGiftModel.giftIcon = MsgPackHelper.getStringValue(paramMap, "gift_icon");
      flashVideoGiftModel.giftName = MsgPackHelper.getStringValue(paramMap, "gift_name");
      return flashVideoGiftModel;
    } 
    return null;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[roomId:");
    stringBuilder.append(this.roomId);
    stringBuilder.append(", addTime:");
    stringBuilder.append(this.addTime);
    stringBuilder.append(", addLike:");
    stringBuilder.append(this.addLike);
    stringBuilder.append(", totalTime:");
    stringBuilder.append(this.totalTime);
    stringBuilder.append(", totalLike:");
    stringBuilder.append(this.totalLike);
    stringBuilder.append(", giftIcon:");
    stringBuilder.append(this.giftIcon);
    stringBuilder.append(", giftName:");
    stringBuilder.append(this.giftName);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\model\FlashVideoGiftModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */