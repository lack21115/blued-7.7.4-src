package com.heytap.mcssdk.a;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.PushManager;
import com.heytap.mcssdk.mode.Message;
import com.heytap.mcssdk.utils.CryptoUtil;
import com.heytap.mcssdk.utils.LogUtil;
import java.util.ArrayList;
import java.util.List;

public abstract class c implements d {
  public static List<Message> a(Context paramContext, Intent paramIntent) {
    if (paramIntent == null)
      return null; 
    int i = 4096;
    try {
      int j = Integer.parseInt(CryptoUtil.b(paramIntent.getStringExtra("type")));
      i = j;
    } catch (Exception exception) {
      StringBuilder stringBuilder1 = new StringBuilder("MessageParser--getMessageByIntent--Exception:");
      stringBuilder1.append(exception.getMessage());
      LogUtil.b(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder("MessageParser--getMessageByIntent--type:");
    stringBuilder.append(i);
    LogUtil.a(stringBuilder.toString());
    ArrayList<Message> arrayList = new ArrayList();
    for (d d1 : PushManager.a().b()) {
      if (d1 != null) {
        Message message = d1.a(paramContext, i, paramIntent);
        if (message != null)
          arrayList.add(message); 
      } 
    } 
    return arrayList;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\heytap\mcssdk\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */