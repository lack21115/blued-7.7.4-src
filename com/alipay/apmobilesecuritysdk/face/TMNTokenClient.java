package com.alipay.apmobilesecuritysdk.face;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.f.b;
import com.alipay.apmobilesecuritysdk.otherid.UtdidWrapper;
import com.alipay.security.mobile.module.a.a;
import java.util.HashMap;

public class TMNTokenClient {
  private static TMNTokenClient a;
  
  private Context b = null;
  
  private TMNTokenClient(Context paramContext) {
    if (paramContext != null) {
      this.b = paramContext;
      return;
    } 
    throw new IllegalArgumentException("TMNTokenClient initialization error: context is null.");
  }
  
  public static TMNTokenClient getInstance(Context paramContext) {
    // Byte code:
    //   0: getstatic com/alipay/apmobilesecuritysdk/face/TMNTokenClient.a : Lcom/alipay/apmobilesecuritysdk/face/TMNTokenClient;
    //   3: ifnonnull -> 38
    //   6: ldc com/alipay/apmobilesecuritysdk/face/TMNTokenClient
    //   8: monitorenter
    //   9: getstatic com/alipay/apmobilesecuritysdk/face/TMNTokenClient.a : Lcom/alipay/apmobilesecuritysdk/face/TMNTokenClient;
    //   12: ifnonnull -> 26
    //   15: new com/alipay/apmobilesecuritysdk/face/TMNTokenClient
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Landroid/content/Context;)V
    //   23: putstatic com/alipay/apmobilesecuritysdk/face/TMNTokenClient.a : Lcom/alipay/apmobilesecuritysdk/face/TMNTokenClient;
    //   26: ldc com/alipay/apmobilesecuritysdk/face/TMNTokenClient
    //   28: monitorexit
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc com/alipay/apmobilesecuritysdk/face/TMNTokenClient
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic com/alipay/apmobilesecuritysdk/face/TMNTokenClient.a : Lcom/alipay/apmobilesecuritysdk/face/TMNTokenClient;
    //   41: areturn
    // Exception table:
    //   from	to	target	type
    //   9	26	32	finally
    //   26	29	32	finally
    //   33	36	32	finally
  }
  
  public void intiToken(String paramString1, String paramString2, String paramString3, InitResultListener paramInitResultListener) {
    if (a.a(paramString1) && paramInitResultListener != null)
      paramInitResultListener.onResult("", 2); 
    if (a.a(paramString2) && paramInitResultListener != null)
      paramInitResultListener.onResult("", 3); 
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("utdid", UtdidWrapper.getUtdid(this.b));
    hashMap.put("tid", "");
    hashMap.put("userId", "");
    hashMap.put("appName", paramString1);
    hashMap.put("appKeyClient", paramString2);
    hashMap.put("appchannel", "openapi");
    hashMap.put("sessionId", paramString3);
    hashMap.put("rpcVersion", "8");
    b.a().a(new TMNTokenClient$1(this, hashMap, paramInitResultListener, paramString1));
  }
  
  public static interface InitResultListener {
    void onResult(String param1String, int param1Int);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\apmobilesecuritysdk\face\TMNTokenClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */