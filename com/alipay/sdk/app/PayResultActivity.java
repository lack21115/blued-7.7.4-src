package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.alipay.sdk.app.statistic.a;
import com.alipay.sdk.util.c;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

public final class PayResultActivity extends Activity {
  public static final String a = "{\"isLogin\":\"false\"}";
  
  public static final HashMap<String, Object> b = new HashMap<String, Object>();
  
  public static final String c = "hk.alipay.wallet";
  
  public static final String d = "phonecashier.pay.hash";
  
  public static final String e = "orderSuffix";
  
  public static final String f = "externalPkgName";
  
  public static final String g = "phonecashier.pay.result";
  
  public static final String h = "phonecashier.pay.resultOrderHash";
  
  private com.alipay.sdk.sys.a i = null;
  
  private static void a(Activity paramActivity, int paramInt) {
    (new Handler()).postDelayed(new f(paramActivity), paramInt);
  }
  
  private static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3) {
    if (!TextUtils.isEmpty(paramString2) && !TextUtils.isEmpty(paramString3)) {
      Intent intent = new Intent();
      try {
        intent.setPackage("hk.alipay.wallet");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("alipayhk://platformapi/startApp?appId=20000125&schemePaySession=");
        stringBuilder.append(URLEncoder.encode(paramString1, "UTF-8"));
        stringBuilder.append("&orderSuffix=");
        stringBuilder.append(URLEncoder.encode(paramString2, "UTF-8"));
        stringBuilder.append("&packageName=");
        stringBuilder.append(URLEncoder.encode(paramString3, "UTF-8"));
        stringBuilder.append("&externalPkgName=");
        stringBuilder.append(URLEncoder.encode(paramString3, "UTF-8"));
        intent.setData(Uri.parse(stringBuilder.toString()));
      } catch (UnsupportedEncodingException unsupportedEncodingException) {
        c.a(unsupportedEncodingException);
      } 
      if (paramActivity != null)
        try {
          return;
        } finally {
          paramString1 = null;
        }  
    } 
  }
  
  private static void a(String paramString) {
    a.b = j.c();
    a(b, paramString);
  }
  
  private static void a(String paramString1, String paramString2) {
    a.b = paramString1;
    a(b, paramString2);
  }
  
  private static boolean a(HashMap<String, Object> paramHashMap, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: ifnull -> 37
    //   4: aload_1
    //   5: ifnonnull -> 10
    //   8: iconst_0
    //   9: ireturn
    //   10: aload_0
    //   11: aload_1
    //   12: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   15: astore_0
    //   16: aload_0
    //   17: ifnonnull -> 22
    //   20: iconst_0
    //   21: ireturn
    //   22: aload_0
    //   23: monitorenter
    //   24: aload_0
    //   25: invokevirtual notifyAll : ()V
    //   28: aload_0
    //   29: monitorexit
    //   30: iconst_1
    //   31: ireturn
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    //   37: iconst_0
    //   38: ireturn
    // Exception table:
    //   from	to	target	type
    //   24	30	32	finally
    //   33	35	32	finally
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    try {
      StringBuilder stringBuilder;
      Intent intent = getIntent();
      if ((TextUtils.isEmpty(intent.getStringExtra("orderSuffix")) ^ true) != 0) {
        a.a = intent.getStringExtra("phonecashier.pay.hash");
        String str1 = intent.getStringExtra("orderSuffix");
        String str2 = intent.getStringExtra("externalPkgName");
        this.i = com.alipay.sdk.sys.a.a.a(intent);
        if (this.i == null)
          finish(); 
        return;
      } 
      if (this.i == null)
        finish(); 
      String str = intent.getStringExtra("phonecashier.pay.result");
      int i = intent.getIntExtra("phonecashier.pay.resultOrderHash", 0);
      if (i == 0 || !TextUtils.equals(a.a, String.valueOf(i))) {
        com.alipay.sdk.sys.a a1 = this.i;
        stringBuilder = new StringBuilder();
        stringBuilder.append("Expected ");
        stringBuilder.append(a.a);
        stringBuilder.append(", got ");
        stringBuilder.append(i);
        a.a(a1, "biz", "SchemePayWrongHashEx", stringBuilder.toString());
        return;
      } 
      if (!TextUtils.isEmpty(stringBuilder)) {
        a((String)stringBuilder, a.a);
      } else {
        a(a.a);
      } 
      return;
    } finally {
      paramBundle = null;
      finish();
    } 
  }
  
  public static final class a {
    public static volatile String a;
    
    public static volatile String b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\app\PayResultActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */