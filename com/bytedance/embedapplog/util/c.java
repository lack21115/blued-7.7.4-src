package com.bytedance.embedapplog.util;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.embedapplog.b.h;

public class c {
  private static volatile String a;
  
  public static String a(Context paramContext, h paramh) {
    // Byte code:
    //   0: getstatic com/bytedance/embedapplog/util/c.a : Ljava/lang/String;
    //   3: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   6: ifeq -> 140
    //   9: ldc com/bytedance/embedapplog/util/c
    //   11: monitorenter
    //   12: getstatic com/bytedance/embedapplog/util/c.a : Ljava/lang/String;
    //   15: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   18: ifne -> 30
    //   21: getstatic com/bytedance/embedapplog/util/c.a : Ljava/lang/String;
    //   24: astore_0
    //   25: ldc com/bytedance/embedapplog/util/c
    //   27: monitorexit
    //   28: aload_0
    //   29: areturn
    //   30: aload_0
    //   31: invokestatic getAdvertisingIdInfo : (Landroid/content/Context;)Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;
    //   34: astore_2
    //   35: aload_2
    //   36: ifnull -> 144
    //   39: aload_2
    //   40: invokevirtual getId : ()Ljava/lang/String;
    //   43: astore_2
    //   44: goto -> 72
    //   47: astore_2
    //   48: aload_2
    //   49: instanceof java/lang/ClassNotFoundException
    //   52: ifne -> 144
    //   55: aload_2
    //   56: instanceof java/lang/NoClassDefFoundError
    //   59: ifeq -> 65
    //   62: goto -> 144
    //   65: aload_2
    //   66: invokevirtual printStackTrace : ()V
    //   69: goto -> 144
    //   72: aload_2
    //   73: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   76: ifeq -> 95
    //   79: aload_1
    //   80: invokevirtual d : ()Landroid/content/SharedPreferences;
    //   83: ldc 'google_aid'
    //   85: aconst_null
    //   86: invokeinterface getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   91: astore_3
    //   92: goto -> 124
    //   95: aload_2
    //   96: astore_3
    //   97: aload_1
    //   98: invokevirtual d : ()Landroid/content/SharedPreferences;
    //   101: ldc 'google_aid'
    //   103: aconst_null
    //   104: invokeinterface getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   109: aload_2
    //   110: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   113: ifne -> 124
    //   116: aload_0
    //   117: aload_2
    //   118: aload_1
    //   119: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Lcom/bytedance/embedapplog/b/h;)V
    //   122: aload_2
    //   123: astore_3
    //   124: aload_3
    //   125: putstatic com/bytedance/embedapplog/util/c.a : Ljava/lang/String;
    //   128: ldc com/bytedance/embedapplog/util/c
    //   130: monitorexit
    //   131: goto -> 140
    //   134: astore_0
    //   135: ldc com/bytedance/embedapplog/util/c
    //   137: monitorexit
    //   138: aload_0
    //   139: athrow
    //   140: getstatic com/bytedance/embedapplog/util/c.a : Ljava/lang/String;
    //   143: areturn
    //   144: aconst_null
    //   145: astore_2
    //   146: goto -> 72
    // Exception table:
    //   from	to	target	type
    //   12	28	134	finally
    //   30	35	47	finally
    //   39	44	47	finally
    //   48	62	134	finally
    //   65	69	134	finally
    //   72	92	134	finally
    //   97	122	134	finally
    //   124	131	134	finally
    //   135	138	134	finally
  }
  
  private static void a(Context paramContext, String paramString, h paramh) {
    if (!TextUtils.isEmpty(paramString)) {
      if (paramContext == null)
        return; 
      paramh.d().edit().putString("google_aid", paramString).apply();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplo\\util\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */