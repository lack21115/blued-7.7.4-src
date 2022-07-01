package com.alipay.apmobilesecuritysdk.otherid;

import android.content.Context;
import com.alipay.security.mobile.module.a.a;

public class UmidSdkWrapper {
  private static final String UMIDTOKEN_FILE_NAME = "xxxwww_v2";
  
  private static final String UMIDTOKEN_KEY_NAME = "umidtk";
  
  private static volatile String cachedUmidToken = "";
  
  private static volatile boolean initUmidFinished = false;
  
  private static String compatUmidBug(Context paramContext, String paramString) {
    if (a.a(paramString) || a.a(paramString, "000000000000000000000000")) {
      paramString = UtdidWrapper.getUtdid(paramContext);
      String str = paramString;
      if (paramString != null) {
        str = paramString;
        if (paramString.contains("?"))
          str = ""; 
      } 
      paramString = str;
      if (a.a(str))
        paramString = ""; 
      return paramString;
    } 
    return paramString;
  }
  
  public static String getSecurityToken(Context paramContext) {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/otherid/UmidSdkWrapper
    //   2: monitorenter
    //   3: getstatic com/alipay/apmobilesecuritysdk/otherid/UmidSdkWrapper.cachedUmidToken : Ljava/lang/String;
    //   6: astore_0
    //   7: ldc com/alipay/apmobilesecuritysdk/otherid/UmidSdkWrapper
    //   9: monitorexit
    //   10: aload_0
    //   11: areturn
    //   12: astore_0
    //   13: ldc com/alipay/apmobilesecuritysdk/otherid/UmidSdkWrapper
    //   15: monitorexit
    //   16: aload_0
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
  
  public static String startUmidTaskSync(Context paramContext, int paramInt) {
    return "";
  }
  
  private static void updateLocalUmidToken(Context paramContext, String paramString) {
    // Byte code:
    //   0: ldc com/alipay/apmobilesecuritysdk/otherid/UmidSdkWrapper
    //   2: monitorenter
    //   3: aload_1
    //   4: invokestatic b : (Ljava/lang/String;)Z
    //   7: ifeq -> 23
    //   10: aload_0
    //   11: ldc 'xxxwww_v2'
    //   13: ldc 'umidtk'
    //   15: aload_1
    //   16: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   19: aload_1
    //   20: putstatic com/alipay/apmobilesecuritysdk/otherid/UmidSdkWrapper.cachedUmidToken : Ljava/lang/String;
    //   23: ldc com/alipay/apmobilesecuritysdk/otherid/UmidSdkWrapper
    //   25: monitorexit
    //   26: return
    //   27: astore_0
    //   28: ldc com/alipay/apmobilesecuritysdk/otherid/UmidSdkWrapper
    //   30: monitorexit
    //   31: aload_0
    //   32: athrow
    // Exception table:
    //   from	to	target	type
    //   3	23	27	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\apmobilesecuritysdk\otherid\UmidSdkWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */