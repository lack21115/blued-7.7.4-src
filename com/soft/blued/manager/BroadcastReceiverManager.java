package com.soft.blued.manager;

import android.content.Context;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import java.util.Hashtable;

public class BroadcastReceiverManager {
  private static volatile BroadcastReceiverManager a;
  
  private Context b = AppInfo.d();
  
  private Hashtable<String, BluedBroadcastReceiver> c = new Hashtable<String, BluedBroadcastReceiver>();
  
  public static BroadcastReceiverManager a() {
    // Byte code:
    //   0: getstatic com/soft/blued/manager/BroadcastReceiverManager.a : Lcom/soft/blued/manager/BroadcastReceiverManager;
    //   3: ifnonnull -> 37
    //   6: ldc com/soft/blued/manager/BroadcastReceiverManager
    //   8: monitorenter
    //   9: getstatic com/soft/blued/manager/BroadcastReceiverManager.a : Lcom/soft/blued/manager/BroadcastReceiverManager;
    //   12: ifnonnull -> 25
    //   15: new com/soft/blued/manager/BroadcastReceiverManager
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/soft/blued/manager/BroadcastReceiverManager.a : Lcom/soft/blued/manager/BroadcastReceiverManager;
    //   25: ldc com/soft/blued/manager/BroadcastReceiverManager
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/soft/blued/manager/BroadcastReceiverManager
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/soft/blued/manager/BroadcastReceiverManager.a : Lcom/soft/blued/manager/BroadcastReceiverManager;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private Context b() {
    if (this.b == null)
      this.b = AppInfo.d(); 
    return this.b;
  }
  
  public void a(String paramString, BroadcastReceiverListener paramBroadcastReceiverListener) {
    if (!TextUtils.isEmpty(paramString)) {
      if (paramBroadcastReceiverListener == null)
        return; 
      a(new String[] { paramString }, paramBroadcastReceiverListener);
    } 
  }
  
  public void a(String[] paramArrayOfString, BroadcastReceiverListener paramBroadcastReceiverListener) {
    if (paramArrayOfString != null && paramArrayOfString.length != 0) {
      if (paramBroadcastReceiverListener == null)
        return; 
      int j = paramArrayOfString.length;
      for (int i = 0; i < j; i++) {
        String str = paramArrayOfString[i];
        if (this.c.containsKey(str)) {
          BluedBroadcastReceiver bluedBroadcastReceiver2 = this.c.get(str);
          BluedBroadcastReceiver bluedBroadcastReceiver1 = bluedBroadcastReceiver2;
          if (bluedBroadcastReceiver2 == null) {
            bluedBroadcastReceiver1 = new BluedBroadcastReceiver(b(), str);
            this.c.put(str, bluedBroadcastReceiver1);
          } 
          bluedBroadcastReceiver1.a(paramBroadcastReceiverListener);
        } else {
          BluedBroadcastReceiver bluedBroadcastReceiver = new BluedBroadcastReceiver(b(), str);
          bluedBroadcastReceiver.a(paramBroadcastReceiverListener);
          this.c.put(str, bluedBroadcastReceiver);
        } 
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\manager\BroadcastReceiverManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */