package com.alipay.apmobilesecuritysdk.face;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.a.a;
import com.alipay.apmobilesecuritysdk.b.a;
import com.alipay.apmobilesecuritysdk.e.a;
import com.alipay.apmobilesecuritysdk.e.d;
import com.alipay.apmobilesecuritysdk.e.g;
import com.alipay.apmobilesecuritysdk.e.h;
import com.alipay.apmobilesecuritysdk.e.i;
import com.alipay.apmobilesecuritysdk.f.b;
import com.alipay.apmobilesecuritysdk.otherid.UtdidWrapper;
import com.alipay.security.mobile.module.a.a;
import java.util.HashMap;
import java.util.Map;

public class APSecuritySdk {
  private static APSecuritySdk a;
  
  private static Object c = new Object();
  
  private Context b;
  
  private APSecuritySdk(Context paramContext) {
    this.b = paramContext;
  }
  
  public static APSecuritySdk getInstance(Context paramContext) {
    if (a == null)
      synchronized (c) {
        if (a == null)
          a = new APSecuritySdk(paramContext); 
      }  
    return a;
  }
  
  public static String getUtdid(Context paramContext) {
    return UtdidWrapper.getUtdid(paramContext);
  }
  
  public String getApdidToken() {
    String str = a.a(this.b, "");
    if (a.a(str))
      initToken(0, new HashMap<String, String>(), null); 
    return str;
  }
  
  public String getSdkName() {
    return "APPSecuritySDK-ALIPAYSDK";
  }
  
  public String getSdkVersion() {
    return "3.4.0.201910161639";
  }
  
  public TokenResult getTokenResult() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new com/alipay/apmobilesecuritysdk/face/APSecuritySdk$TokenResult
    //   5: dup
    //   6: aload_0
    //   7: invokespecial <init> : (Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;)V
    //   10: astore_1
    //   11: aload_1
    //   12: aload_0
    //   13: getfield b : Landroid/content/Context;
    //   16: ldc ''
    //   18: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   21: putfield apdidToken : Ljava/lang/String;
    //   24: aload_1
    //   25: aload_0
    //   26: getfield b : Landroid/content/Context;
    //   29: invokestatic f : (Landroid/content/Context;)Ljava/lang/String;
    //   32: putfield clientKey : Ljava/lang/String;
    //   35: aload_1
    //   36: aload_0
    //   37: getfield b : Landroid/content/Context;
    //   40: invokestatic a : (Landroid/content/Context;)Ljava/lang/String;
    //   43: putfield apdid : Ljava/lang/String;
    //   46: aload_1
    //   47: aload_0
    //   48: getfield b : Landroid/content/Context;
    //   51: invokestatic getSecurityToken : (Landroid/content/Context;)Ljava/lang/String;
    //   54: putfield umidToken : Ljava/lang/String;
    //   57: aload_1
    //   58: getfield apdid : Ljava/lang/String;
    //   61: invokestatic a : (Ljava/lang/String;)Z
    //   64: ifne -> 87
    //   67: aload_1
    //   68: getfield apdidToken : Ljava/lang/String;
    //   71: invokestatic a : (Ljava/lang/String;)Z
    //   74: ifne -> 87
    //   77: aload_1
    //   78: getfield clientKey : Ljava/lang/String;
    //   81: invokestatic a : (Ljava/lang/String;)Z
    //   84: ifeq -> 100
    //   87: aload_0
    //   88: iconst_0
    //   89: new java/util/HashMap
    //   92: dup
    //   93: invokespecial <init> : ()V
    //   96: aconst_null
    //   97: invokevirtual initToken : (ILjava/util/Map;Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk$InitResultListener;)V
    //   100: aload_0
    //   101: monitorexit
    //   102: aload_1
    //   103: areturn
    //   104: astore_1
    //   105: aload_0
    //   106: monitorexit
    //   107: aload_1
    //   108: athrow
    //   109: astore_2
    //   110: goto -> 100
    // Exception table:
    //   from	to	target	type
    //   2	11	104	finally
    //   11	87	109	finally
    //   87	100	109	finally
  }
  
  public void initToken(int paramInt, Map<String, String> paramMap, InitResultListener paramInitResultListener) {
    a.a().a(paramInt);
    String str2 = h.b(this.b);
    String str3 = a.a().c();
    if (a.b(str2) && !a.a(str2, str3)) {
      a.a(this.b);
      d.a(this.b);
      g.a(this.b);
      i.h();
    } 
    if (!a.a(str2, str3))
      h.c(this.b, str3); 
    str2 = a.a(paramMap, "utdid", "");
    str3 = a.a(paramMap, "tid", "");
    String str4 = a.a(paramMap, "userId", "");
    String str1 = str2;
    if (a.a(str2))
      str1 = UtdidWrapper.getUtdid(this.b); 
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("utdid", str1);
    hashMap.put("tid", str3);
    hashMap.put("userId", str4);
    hashMap.put("appName", "");
    hashMap.put("appKeyClient", "");
    hashMap.put("appchannel", "");
    hashMap.put("rpcVersion", "8");
    b.a().a(new APSecuritySdk$1(this, hashMap, paramInitResultListener));
  }
  
  public static interface InitResultListener {
    void onResult(APSecuritySdk.TokenResult param1TokenResult);
  }
  
  public class TokenResult {
    public String apdid;
    
    public String apdidToken;
    
    public String clientKey;
    
    public String umidToken;
    
    public TokenResult(APSecuritySdk this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\apmobilesecuritysdk\face\APSecuritySdk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */