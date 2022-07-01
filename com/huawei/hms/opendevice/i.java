package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.aaid.encrypt.PushEncrypter;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.support.log.HMSLog;
import java.util.Map;

public class i extends PushPreferences {
  public static final String b = "i";
  
  public static i c;
  
  public static Context d;
  
  public i(Context paramContext) {
    super(paramContext, "push_client_self_info");
  }
  
  public static i a(Context paramContext) {
    // Byte code:
    //   0: ldc com/huawei/hms/opendevice/i
    //   2: monitorenter
    //   3: getstatic com/huawei/hms/opendevice/i.c : Lcom/huawei/hms/opendevice/i;
    //   6: ifnonnull -> 24
    //   9: aload_0
    //   10: putstatic com/huawei/hms/opendevice/i.d : Landroid/content/Context;
    //   13: new com/huawei/hms/opendevice/i
    //   16: dup
    //   17: aload_0
    //   18: invokespecial <init> : (Landroid/content/Context;)V
    //   21: putstatic com/huawei/hms/opendevice/i.c : Lcom/huawei/hms/opendevice/i;
    //   24: getstatic com/huawei/hms/opendevice/i.c : Lcom/huawei/hms/opendevice/i;
    //   27: astore_0
    //   28: ldc com/huawei/hms/opendevice/i
    //   30: monitorexit
    //   31: aload_0
    //   32: areturn
    //   33: astore_0
    //   34: ldc com/huawei/hms/opendevice/i
    //   36: monitorexit
    //   37: aload_0
    //   38: athrow
    // Exception table:
    //   from	to	target	type
    //   3	24	33	finally
    //   24	28	33	finally
  }
  
  public static void a() {
    Map map = c.getAll();
    if (!map.isEmpty()) {
      if (map.keySet().isEmpty())
        return; 
      for (String str : map.keySet()) {
        if ("push_kit_auto_init_enabled".equals(str))
          continue; 
        c.removeKey(str);
      } 
    } 
  }
  
  public String a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return ""; 
    try {
      return PushEncrypter.decrypter(d, getString(paramString));
    } catch (Exception exception) {
      String str = b;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getSecureData");
      stringBuilder.append(exception.getMessage());
      HMSLog.e(str, stringBuilder.toString());
      return "";
    } 
  }
  
  public boolean a(String paramString1, String paramString2) {
    if (TextUtils.isEmpty(paramString1))
      return false; 
    try {
      return saveString(paramString1, PushEncrypter.encrypter(d, paramString2));
    } catch (Exception exception) {
      paramString2 = b;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("saveSecureData");
      stringBuilder.append(exception.getMessage());
      HMSLog.e(paramString2, stringBuilder.toString());
      return false;
    } 
  }
  
  public String b(String paramString) {
    try {
      boolean bool = TextUtils.isEmpty(paramString);
      return bool ? a("token_info_v2") : a(paramString);
    } catch (Exception exception) {
      String str = b;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getSecureData");
      stringBuilder.append(exception.getMessage());
      HMSLog.e(str, stringBuilder.toString());
      return "";
    } 
  }
  
  public boolean b(String paramString1, String paramString2) {
    try {
      null = TextUtils.isEmpty(paramString1);
      return null ? a("token_info_v2", paramString2) : a(paramString1, paramString2);
    } catch (Exception exception) {
      paramString2 = b;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("saveSecureData");
      stringBuilder.append(exception.getMessage());
      HMSLog.e(paramString2, stringBuilder.toString());
      return false;
    } 
  }
  
  public boolean c(String paramString) {
    try {
      null = TextUtils.isEmpty(paramString);
      return null ? removeKey("token_info_v2") : removeKey(paramString);
    } catch (Exception exception) {
      String str = b;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("removeToken");
      stringBuilder.append(exception.getMessage());
      HMSLog.e(str, stringBuilder.toString());
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\opendevice\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */