package com.huawei.hms.framework.network.grs.c.a;

import android.content.Context;
import com.huawei.hms.framework.network.grs.c.b.c;

public class a {
  private static final String a = "a";
  
  private static c b;
  
  public static c a(Context paramContext) {
    // Byte code:
    //   0: ldc com/huawei/hms/framework/network/grs/c/a/a
    //   2: monitorenter
    //   3: getstatic com/huawei/hms/framework/network/grs/c/a/a.b : Lcom/huawei/hms/framework/network/grs/c/b/c;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull -> 16
    //   11: ldc com/huawei/hms/framework/network/grs/c/a/a
    //   13: monitorexit
    //   14: aload_3
    //   15: areturn
    //   16: ldc 'grs_sdk_server_config.json'
    //   18: aload_0
    //   19: invokestatic a : (Ljava/lang/String;Landroid/content/Context;)Ljava/lang/String;
    //   22: astore_0
    //   23: aload_0
    //   24: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   27: istore_2
    //   28: aconst_null
    //   29: astore_3
    //   30: iload_2
    //   31: ifeq -> 39
    //   34: ldc com/huawei/hms/framework/network/grs/c/a/a
    //   36: monitorexit
    //   37: aconst_null
    //   38: areturn
    //   39: new org/json/JSONObject
    //   42: dup
    //   43: aload_0
    //   44: invokespecial <init> : (Ljava/lang/String;)V
    //   47: astore_0
    //   48: aload_0
    //   49: ldc 'grs_server'
    //   51: invokevirtual getJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   54: astore #4
    //   56: aload #4
    //   58: ldc 'grs_base_url'
    //   60: invokevirtual getJSONArray : (Ljava/lang/String;)Lorg/json/JSONArray;
    //   63: astore #5
    //   65: aload_3
    //   66: astore_0
    //   67: aload #5
    //   69: ifnull -> 126
    //   72: aload_3
    //   73: astore_0
    //   74: aload #5
    //   76: invokevirtual length : ()I
    //   79: ifle -> 126
    //   82: new java/util/ArrayList
    //   85: dup
    //   86: invokespecial <init> : ()V
    //   89: astore_3
    //   90: iconst_0
    //   91: istore_1
    //   92: aload_3
    //   93: astore_0
    //   94: iload_1
    //   95: aload #5
    //   97: invokevirtual length : ()I
    //   100: if_icmpge -> 126
    //   103: aload_3
    //   104: aload #5
    //   106: iload_1
    //   107: invokevirtual get : (I)Ljava/lang/Object;
    //   110: invokevirtual toString : ()Ljava/lang/String;
    //   113: invokeinterface add : (Ljava/lang/Object;)Z
    //   118: pop
    //   119: iload_1
    //   120: iconst_1
    //   121: iadd
    //   122: istore_1
    //   123: goto -> 92
    //   126: new com/huawei/hms/framework/network/grs/c/b/c
    //   129: dup
    //   130: invokespecial <init> : ()V
    //   133: putstatic com/huawei/hms/framework/network/grs/c/a/a.b : Lcom/huawei/hms/framework/network/grs/c/b/c;
    //   136: getstatic com/huawei/hms/framework/network/grs/c/a/a.b : Lcom/huawei/hms/framework/network/grs/c/b/c;
    //   139: aload_0
    //   140: invokevirtual a : (Ljava/util/List;)V
    //   143: aload #4
    //   145: ldc 'grs_query_endpoint_1.0'
    //   147: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   150: astore_0
    //   151: getstatic com/huawei/hms/framework/network/grs/c/a/a.b : Lcom/huawei/hms/framework/network/grs/c/b/c;
    //   154: aload_0
    //   155: invokevirtual b : (Ljava/lang/String;)V
    //   158: aload #4
    //   160: ldc 'grs_query_endpoint_2.0'
    //   162: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   165: astore_0
    //   166: getstatic com/huawei/hms/framework/network/grs/c/a/a.b : Lcom/huawei/hms/framework/network/grs/c/b/c;
    //   169: aload_0
    //   170: invokevirtual a : (Ljava/lang/String;)V
    //   173: aload #4
    //   175: ldc 'grs_query_timeout'
    //   177: invokevirtual getInt : (Ljava/lang/String;)I
    //   180: istore_1
    //   181: getstatic com/huawei/hms/framework/network/grs/c/a/a.b : Lcom/huawei/hms/framework/network/grs/c/b/c;
    //   184: iload_1
    //   185: invokevirtual a : (I)V
    //   188: goto -> 201
    //   191: astore_0
    //   192: getstatic com/huawei/hms/framework/network/grs/c/a/a.a : Ljava/lang/String;
    //   195: ldc 'getGrsServerBean catch JSONException'
    //   197: aload_0
    //   198: invokestatic w : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   201: getstatic com/huawei/hms/framework/network/grs/c/a/a.b : Lcom/huawei/hms/framework/network/grs/c/b/c;
    //   204: astore_0
    //   205: ldc com/huawei/hms/framework/network/grs/c/a/a
    //   207: monitorexit
    //   208: aload_0
    //   209: areturn
    //   210: astore_0
    //   211: ldc com/huawei/hms/framework/network/grs/c/a/a
    //   213: monitorexit
    //   214: aload_0
    //   215: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	210	finally
    //   16	28	210	finally
    //   39	48	191	org/json/JSONException
    //   39	48	210	finally
    //   48	56	191	org/json/JSONException
    //   48	56	210	finally
    //   56	65	191	org/json/JSONException
    //   56	65	210	finally
    //   74	90	191	org/json/JSONException
    //   74	90	210	finally
    //   94	119	191	org/json/JSONException
    //   94	119	210	finally
    //   126	143	191	org/json/JSONException
    //   126	143	210	finally
    //   143	158	191	org/json/JSONException
    //   143	158	210	finally
    //   158	173	191	org/json/JSONException
    //   158	173	210	finally
    //   173	188	191	org/json/JSONException
    //   173	188	210	finally
    //   192	201	210	finally
    //   201	205	210	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\network\grs\c\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */