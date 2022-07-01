package com.blued.android.chat.data;

import com.blued.android.chat.utils.MsgPackHelper;
import java.util.Map;

public class EntranceData {
  public String entranceAnim;
  
  public String entranceApng;
  
  public String entranceColor;
  
  public String entranceContents;
  
  public String entranceGif;
  
  public String entranceImage;
  
  public String entranceMp4;
  
  public long invisibleUid;
  
  public ProfileData userData;
  
  public static EntranceData parseEntranceData(Map<String, Object> paramMap) {
    if (paramMap == null)
      return null; 
    EntranceData entranceData = new EntranceData();
    entranceData.entranceContents = MsgPackHelper.getStringValue(paramMap, "contents");
    entranceData.entranceImage = MsgPackHelper.getStringValue(paramMap, "url");
    entranceData.entranceColor = MsgPackHelper.getStringValue(paramMap, "background_color");
    entranceData.entranceAnim = MsgPackHelper.getStringValue(paramMap, "gift_apng");
    entranceData.entranceGif = MsgPackHelper.getStringValue(paramMap, "entrance_gif");
    entranceData.entranceApng = MsgPackHelper.getStringValue(paramMap, "entrance_apng");
    entranceData.entranceMp4 = MsgPackHelper.getStringValue(paramMap, "entrance_mp4");
    entranceData.invisibleUid = MsgPackHelper.getLongValue(paramMap, "true_uid");
    return entranceData;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\data\EntranceData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */