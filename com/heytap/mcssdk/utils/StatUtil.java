package com.heytap.mcssdk.utils;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.PushManager;
import com.heytap.mcssdk.mode.MessageStat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class StatUtil {
  public static void a(Context paramContext, MessageStat paramMessageStat) {
    LinkedList<MessageStat> linkedList = new LinkedList();
    linkedList.add(paramMessageStat);
    a(paramContext, linkedList);
  }
  
  public static void a(Context paramContext, List<MessageStat> paramList) {
    LinkedList<MessageStat> linkedList = new LinkedList();
    linkedList.addAll(paramList);
    StringBuilder stringBuilder = new StringBuilder("isSupportStatisticByMcs:");
    stringBuilder.append(a(paramContext));
    stringBuilder.append(",list size:");
    stringBuilder.append(linkedList.size());
    LogUtil.a(stringBuilder.toString());
    if (linkedList.size() > 0 && a(paramContext))
      b(paramContext, linkedList); 
  }
  
  private static boolean a(Context paramContext) {
    String str = PushManager.a(paramContext);
    return (Utils.a(paramContext, str) && Utils.b(paramContext, str) >= 1017);
  }
  
  private static void b(Context paramContext, List<MessageStat> paramList) {
    try {
      Intent intent = new Intent();
      intent.setAction(PushManager.b(paramContext));
      intent.setPackage(PushManager.a(paramContext));
      intent.putExtra("appPackage", paramContext.getPackageName());
      intent.putExtra("type", 12291);
      intent.putExtra("count", paramList.size());
      ArrayList<String> arrayList = new ArrayList();
      Iterator<MessageStat> iterator = paramList.iterator();
      while (iterator.hasNext())
        arrayList.add(((MessageStat)iterator.next()).a()); 
      intent.putStringArrayListExtra("list", arrayList);
      paramContext.startService(intent);
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder("statisticMessage--Exception");
      stringBuilder.append(exception.getMessage());
      LogUtil.b(stringBuilder.toString());
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\heytap\mcssd\\utils\StatUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */