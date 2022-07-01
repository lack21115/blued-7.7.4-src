package com.blued.android.chat.core.pack;

import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.core.utils.Log;
import com.blued.android.chat.utils.BytesUtils;
import com.blued.android.chat.utils.MsgPackHelper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Map;

public class SendMsgPackage extends SendBasePackage {
  public final long fromId;
  
  public final String fromName;
  
  public final String msgAt;
  
  public final String msgContent;
  
  public final String msgExtra;
  
  public MsgHeader msgHeader = new MsgHeader();
  
  public final long msgLocalTime;
  
  public final short msgType;
  
  public final long sessionId;
  
  public final short sessionType;
  
  public SendMsgPackage(short paramShort1, long paramLong1, long paramLong2, long paramLong3, short paramShort2, String paramString1, String paramString2, String paramString3, long paramLong4, String paramString4) {
    this.msgHeader.isSendByUser = true;
    this.sessionType = paramShort1;
    this.sessionId = paramLong1;
    this.localId = paramLong2;
    this.msgLocalTime = paramLong3;
    this.msgType = paramShort2;
    this.msgContent = paramString1;
    this.msgAt = paramString2;
    this.msgExtra = paramString3;
    this.fromId = paramLong4;
    this.fromName = paramString4;
  }
  
  protected BytesData msgDataToByte() {
    ArrayMap<String, Short> arrayMap = new ArrayMap();
    arrayMap.put("type", Short.valueOf(this.msgType));
    arrayMap.put("from", Long.valueOf(this.fromId));
    if (!TextUtils.isEmpty(this.fromName)) {
      ArrayMap<String, String> arrayMap1 = new ArrayMap();
      arrayMap1.put("name", this.fromName);
      arrayMap.put("profile", arrayMap1);
    } 
    arrayMap.put("contents", this.msgContent);
    if (!TextUtils.isEmpty(this.msgAt))
      arrayMap.put("at", this.msgAt); 
    if (!TextUtils.isEmpty(this.msgExtra)) {
      Gson gson = new Gson();
      type = (new TypeToken<Map<String, Object>>() {
        
        }).getType();
      arrayMap.put("extra", gson.fromJson(this.msgExtra, type));
      if (ChatManager.debug)
        for (Type type : arrayMap.keySet()) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("key: ");
          stringBuilder.append(type);
          stringBuilder.append(" value: ");
          stringBuilder.append(arrayMap.get(type));
          stringBuilder.append(" type: ");
          stringBuilder.append(arrayMap.get(type).getClass().getSimpleName());
          Log.d("extra", stringBuilder.toString());
        }  
    } 
    byte[] arrayOfByte = MsgPackHelper.packMap((Map)arrayMap);
    BytesData bytesData = new BytesData((short)(arrayOfByte.length + 10));
    bytesData.data[0] = this.msgHeader.toByte();
    BytesUtils.numberTo1Byte(bytesData.data, 1, this.sessionType);
    BytesUtils.numberTo4Bytes(bytesData.data, 2, this.sessionId);
    BytesUtils.numberTo4Bytes(bytesData.data, 6, this.localId);
    BytesUtils.copy(arrayOfByte, 0, bytesData.data, 10, arrayOfByte.length);
    int i = arrayOfByte.length;
    return bytesData;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.toString());
    stringBuilder.append("[msgHeader:");
    stringBuilder.append(this.msgHeader.toByte());
    stringBuilder.append(", sessionType:");
    stringBuilder.append(this.sessionType);
    stringBuilder.append(", sessionId:");
    stringBuilder.append(this.sessionId);
    stringBuilder.append(", localId:");
    stringBuilder.append(this.localId);
    stringBuilder.append(", msgType:");
    stringBuilder.append(this.msgType);
    stringBuilder.append(", fromId:");
    stringBuilder.append(this.fromId);
    stringBuilder.append(", fromName:");
    stringBuilder.append(this.fromName);
    stringBuilder.append(", msgContent:");
    stringBuilder.append(this.msgContent);
    stringBuilder.append(", msgAt:");
    stringBuilder.append(this.msgAt);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\pack\SendMsgPackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */