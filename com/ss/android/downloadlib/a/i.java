package com.ss.android.downloadlib.a;

import android.text.TextUtils;
import com.ss.android.a.a.b.c;
import com.ss.android.socialbase.appdownloader.d;
import com.ss.android.socialbase.appdownloader.g;
import com.ss.android.socialbase.downloader.k.a;

public class i {
  public static int a(c paramc, boolean paramBoolean, g paramg) {
    if (paramg == null || TextUtils.isEmpty(paramg.c()) || paramg.b() == null)
      return 0; 
    int j = d.h().a(paramg);
    a a = a.a(paramg.U());
    if (!a(paramg, a) && paramc.i()) {
      String str2 = a.c("download_start_toast_text");
      String str1 = str2;
      if (TextUtils.isEmpty(str2))
        if (paramBoolean) {
          str1 = "已开始下载，可在\"我的\"里查看管理";
        } else {
          str1 = "已开始下载";
        }  
      j.d().a(2, paramg.b(), paramc, str1, null, 0);
    } 
    return j;
  }
  
  static boolean a(int paramInt) {
    boolean bool = true;
    if (paramInt != 0) {
      if (paramInt == 1)
        return true; 
      bool = false;
    } 
    return bool;
  }
  
  static boolean a(c paramc) {
    return (paramc.r() && paramc instanceof com.ss.android.downloadad.a.a.c && paramc.x() == 1);
  }
  
  private static boolean a(g paramg, a parama) {
    // Byte code:
    //   0: aload_1
    //   1: ldc 'show_unknown_source_on_startup'
    //   3: invokevirtual b : (Ljava/lang/String;)Z
    //   6: ifeq -> 84
    //   9: aload_1
    //   10: ldc 'anti_plans'
    //   12: invokevirtual e : (Ljava/lang/String;)Lorg/json/JSONArray;
    //   15: astore_1
    //   16: aload_1
    //   17: invokevirtual length : ()I
    //   20: istore_3
    //   21: iconst_0
    //   22: istore_2
    //   23: iload_2
    //   24: iload_3
    //   25: if_icmpge -> 62
    //   28: aload_1
    //   29: iload_2
    //   30: invokevirtual optJSONObject : (I)Lorg/json/JSONObject;
    //   33: astore_0
    //   34: aload_0
    //   35: ifnull -> 55
    //   38: ldc 'jump_unknown_source'
    //   40: aload_0
    //   41: ldc 'type'
    //   43: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   46: invokevirtual equals : (Ljava/lang/Object;)Z
    //   49: ifeq -> 55
    //   52: goto -> 64
    //   55: iload_2
    //   56: iconst_1
    //   57: iadd
    //   58: istore_2
    //   59: goto -> 23
    //   62: aconst_null
    //   63: astore_0
    //   64: aload_0
    //   65: ifnull -> 84
    //   68: invokestatic B : ()Landroid/content/Context;
    //   71: aconst_null
    //   72: aload_0
    //   73: new com/ss/android/socialbase/appdownloader/a
    //   76: dup
    //   77: invokespecial <init> : ()V
    //   80: invokestatic a : (Landroid/content/Context;Landroid/content/Intent;Lorg/json/JSONObject;Lcom/ss/android/socialbase/appdownloader/a;)Z
    //   83: ireturn
    //   84: iconst_0
    //   85: ireturn
  }
  
  static boolean b(int paramInt) {
    boolean bool = true;
    if (paramInt != 2) {
      if (paramInt == 1)
        return true; 
      bool = false;
    } 
    return bool;
  }
  
  static boolean c(int paramInt) {
    return (paramInt == 2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\downloadlib\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */