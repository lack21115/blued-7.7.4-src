package com.blued.android.chat.core.pack;

import com.blued.android.chat.ChatManager;
import com.blued.android.chat.core.utils.Log;
import com.blued.android.chat.data.PackageAckResult;
import com.blued.android.chat.utils.BytesUtils;
import java.util.ArrayList;
import java.util.List;

public class SyncAckPackage extends BasePackage {
  private static final String TAG = "Chat_SyncAckPackage";
  
  public boolean hasMore = false;
  
  public short result = 0;
  
  public long syncLocalId = 0L;
  
  public List<PushMsgPackage> syncMsgList;
  
  protected void parseMsgData(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws BasePackage.PackException {
    boolean bool;
    this.result = BytesUtils.byteTo1Number(paramArrayOfbyte, paramInt1);
    int i = paramInt1 + 1;
    this.localId = BytesUtils.bytesTo4Number(paramArrayOfbyte, i);
    i += 4;
    if ((paramArrayOfbyte[i] & 0x1) > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    this.hasMore = bool;
    this.syncLocalId = BytesUtils.bytesTo4Number(paramArrayOfbyte, ++i);
    i += 4;
    if (this.result == 0) {
      this.syncMsgList = new ArrayList<PushMsgPackage>();
      while (i - paramInt1 < this.msgBodyLength) {
        BasePackage basePackage = BasePackage.parseToPack(paramArrayOfbyte, i, paramInt2);
        if (basePackage == null) {
          if (ChatManager.debug) {
            Log.e("Chat_SyncAckPackage", "消息列表中出现了未知包无法解析");
            return;
          } 
          break;
        } 
        int j = i + basePackage.getPackLength();
        if (basePackage instanceof PushBasePackage) {
          PushBasePackage pushBasePackage = (PushBasePackage)basePackage;
          if (pushBasePackage.pushMsgPackage != null) {
            this.syncMsgList.add(pushBasePackage.pushMsgPackage);
            i = j;
            continue;
          } 
        } 
        i = j;
        if (ChatManager.debug) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("why this pack in the msg list, pack:");
          stringBuilder.append(basePackage);
          Log.e("Chat_SyncAckPackage", stringBuilder.toString());
          i = j;
        } 
      } 
    } 
  }
  
  public String toString() {
    int i;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.toString());
    stringBuilder.append("[result:");
    stringBuilder.append(this.result);
    stringBuilder.append(", hasMore:");
    stringBuilder.append(this.hasMore);
    stringBuilder.append(", syncLocalId:");
    stringBuilder.append(this.syncLocalId);
    stringBuilder.append(", _msgList size:");
    List<PushMsgPackage> list = this.syncMsgList;
    boolean bool = false;
    if (list == null) {
      i = 0;
    } else {
      i = list.size();
    } 
    stringBuilder.append(i);
    stringBuilder.append("]");
    String str2 = stringBuilder.toString();
    String str1 = str2;
    if (ChatManager.debug) {
      str1 = str2;
      if (this.syncMsgList != null) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        for (i = bool; i < this.syncMsgList.size(); i++) {
          stringBuffer.append(i);
          stringBuffer.append("-->");
          stringBuffer.append(((PushMsgPackage)this.syncMsgList.get(i)).pushBasePackage);
          stringBuffer.append(", ");
        } 
        stringBuffer.append("]");
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str2);
        stringBuilder1.append(stringBuffer.toString());
        str1 = stringBuilder1.toString();
      } 
    } 
    return str1;
  }
  
  public static interface SYNC_RESULT extends PackageAckResult {
    public static final int SYNC_FORBIDDEN = 3;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\pack\SyncAckPackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */