package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import org.json.JSONObject;

public final class a {
  private static b a(String paramString) {
    try {
      if (!com.alipay.security.mobile.module.a.a.a(paramString)) {
        JSONObject jSONObject = new JSONObject(paramString);
        return new b(jSONObject.optString("apdid"), jSONObject.optString("deviceInfoHash"), jSONObject.optString("timestamp"));
      } 
    } catch (Exception exception) {
      com.alipay.apmobilesecuritysdk.c.a.a(exception);
    } 
    return null;
  }
  
  public static void a() {
    /* monitor enter TypeReferenceDotClassExpression{ObjectType{com/alipay/apmobilesecuritysdk/e/a}} */
    /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/alipay/apmobilesecuritysdk/e/a}} */
  }
  
  public static void a(Context paramContext) {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/e/a
    //   2: monitorenter
    //   3: aload_0
    //   4: ldc 'vkeyid_profiles_v3'
    //   6: ldc 'deviceid'
    //   8: ldc ''
    //   10: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   13: ldc 'wxcasxx_v3'
    //   15: ldc 'wxcasxx'
    //   17: ldc ''
    //   19: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   22: ldc com/alipay/apmobilesecuritysdk/e/a
    //   24: monitorexit
    //   25: return
    //   26: astore_0
    //   27: ldc com/alipay/apmobilesecuritysdk/e/a
    //   29: monitorexit
    //   30: aload_0
    //   31: athrow
    // Exception table:
    //   from	to	target	type
    //   3	22	26	finally
  }
  
  public static void a(Context paramContext, b paramb) {
    /* monitor enter TypeReferenceDotClassExpression{ObjectType{com/alipay/apmobilesecuritysdk/e/a}} */
    try {
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("apdid", paramb.a);
      jSONObject.put("deviceInfoHash", paramb.b);
      jSONObject.put("timestamp", paramb.c);
      String str = jSONObject.toString();
      com.alipay.apmobilesecuritysdk.f.a.a(paramContext, "vkeyid_profiles_v3", "deviceid", str);
      com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v3", "wxcasxx", str);
      /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/alipay/apmobilesecuritysdk/e/a}} */
      return;
    } catch (Exception exception) {
      com.alipay.apmobilesecuritysdk.c.a.a(exception);
      /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/alipay/apmobilesecuritysdk/e/a}} */
      return;
    } finally {}
    /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/alipay/apmobilesecuritysdk/e/a}} */
    throw paramContext;
  }
  
  public static b b() {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/e/a
    //   2: monitorenter
    //   3: ldc 'wxcasxx_v3'
    //   5: ldc 'wxcasxx'
    //   7: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   10: astore_1
    //   11: aload_1
    //   12: invokestatic a : (Ljava/lang/String;)Z
    //   15: istore_0
    //   16: iload_0
    //   17: ifeq -> 25
    //   20: ldc com/alipay/apmobilesecuritysdk/e/a
    //   22: monitorexit
    //   23: aconst_null
    //   24: areturn
    //   25: aload_1
    //   26: invokestatic a : (Ljava/lang/String;)Lcom/alipay/apmobilesecuritysdk/e/b;
    //   29: astore_1
    //   30: ldc com/alipay/apmobilesecuritysdk/e/a
    //   32: monitorexit
    //   33: aload_1
    //   34: areturn
    //   35: astore_1
    //   36: ldc com/alipay/apmobilesecuritysdk/e/a
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    // Exception table:
    //   from	to	target	type
    //   3	16	35	finally
    //   25	30	35	finally
  }
  
  public static b b(Context paramContext) {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/e/a
    //   2: monitorenter
    //   3: aload_0
    //   4: ldc 'vkeyid_profiles_v3'
    //   6: ldc 'deviceid'
    //   8: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   11: astore_1
    //   12: aload_1
    //   13: astore_0
    //   14: aload_1
    //   15: invokestatic a : (Ljava/lang/String;)Z
    //   18: ifeq -> 29
    //   21: ldc 'wxcasxx_v3'
    //   23: ldc 'wxcasxx'
    //   25: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   28: astore_0
    //   29: aload_0
    //   30: invokestatic a : (Ljava/lang/String;)Lcom/alipay/apmobilesecuritysdk/e/b;
    //   33: astore_0
    //   34: ldc com/alipay/apmobilesecuritysdk/e/a
    //   36: monitorexit
    //   37: aload_0
    //   38: areturn
    //   39: astore_0
    //   40: ldc com/alipay/apmobilesecuritysdk/e/a
    //   42: monitorexit
    //   43: aload_0
    //   44: athrow
    // Exception table:
    //   from	to	target	type
    //   3	12	39	finally
    //   14	29	39	finally
    //   29	34	39	finally
  }
  
  public static b c(Context paramContext) {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/e/a
    //   2: monitorenter
    //   3: aload_0
    //   4: ldc 'vkeyid_profiles_v3'
    //   6: ldc 'deviceid'
    //   8: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   11: astore_0
    //   12: aload_0
    //   13: invokestatic a : (Ljava/lang/String;)Z
    //   16: istore_1
    //   17: iload_1
    //   18: ifeq -> 26
    //   21: ldc com/alipay/apmobilesecuritysdk/e/a
    //   23: monitorexit
    //   24: aconst_null
    //   25: areturn
    //   26: aload_0
    //   27: invokestatic a : (Ljava/lang/String;)Lcom/alipay/apmobilesecuritysdk/e/b;
    //   30: astore_0
    //   31: ldc com/alipay/apmobilesecuritysdk/e/a
    //   33: monitorexit
    //   34: aload_0
    //   35: areturn
    //   36: astore_0
    //   37: ldc com/alipay/apmobilesecuritysdk/e/a
    //   39: monitorexit
    //   40: aload_0
    //   41: athrow
    // Exception table:
    //   from	to	target	type
    //   3	17	36	finally
    //   26	31	36	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\apmobilesecuritysdk\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */