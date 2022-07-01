package com.baidu.mobads.b;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.mobads.f.g;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdProdInfo;
import com.baidu.mobads.interfaces.download.activate.IXAppInfo;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.openad.d.b;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.h;
import com.baidu.mobads.utils.l;
import com.baidu.mobads.utils.q;
import com.baidu.mobads.vo.a.b;
import com.baidu.mobads.vo.a.c;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.json.JSONObject;

public class a {
  public static volatile String b;
  
  public static volatile String c;
  
  private static a d = new a();
  
  private static boolean f;
  
  protected final IXAdLogger a = XAdSDKFoundationFacade.getInstance().getAdLogger();
  
  private Context e;
  
  static {
    b = "";
    c = "";
    f = false;
  }
  
  private a() {
    (new Handler(Looper.getMainLooper())).postDelayed(new b(this), 2000L);
  }
  
  public static a a() {
    return d;
  }
  
  private String a(Context paramContext, String paramString, Map<String, String> paramMap) {
    try {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("type=");
      stringBuilder1.append(paramString);
      stringBuilder1.append("&");
      stringBuilder1 = new StringBuilder(stringBuilder1.toString());
      StringBuilder stringBuilder3 = new StringBuilder();
      StringBuilder stringBuilder5 = new StringBuilder();
      stringBuilder5.append(System.currentTimeMillis());
      stringBuilder5.append("");
      paramMap.put("ts", stringBuilder5.toString());
      h h = XAdSDKFoundationFacade.getInstance().getCommonUtils();
      for (String str2 : paramMap.keySet()) {
        String str1 = paramMap.get(str2);
        if (str2 != null && str1 != null) {
          str2 = h.encodeURIComponent(str2);
          str1 = h.encodeURIComponent(str1);
          stringBuilder1.append(str2);
          stringBuilder1.append("=");
          stringBuilder1.append(str1);
          stringBuilder1.append("&");
          stringBuilder3.append(str1);
          stringBuilder3.append(",");
        } 
      } 
      stringBuilder3.append("mobads,");
      String str = h.getMD5(stringBuilder3.toString());
      IXAdLogger iXAdLogger2 = this.a;
      StringBuilder stringBuilder6 = new StringBuilder();
      stringBuilder6.append("ExtraQuery.allValue:");
      stringBuilder6.append(stringBuilder3);
      iXAdLogger2.d(stringBuilder6.toString());
      stringBuilder3 = new StringBuilder();
      stringBuilder3.append("vd=");
      stringBuilder3.append(str);
      stringBuilder3.append("&");
      stringBuilder1.append(stringBuilder3.toString());
      IXAdLogger iXAdLogger1 = this.a;
      StringBuilder stringBuilder4 = new StringBuilder();
      stringBuilder4.append("ExtraQuery.params:");
      stringBuilder4.append(stringBuilder1);
      iXAdLogger1.d(stringBuilder4.toString());
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("https://mobads-logs.baidu.com/dz.zb");
      stringBuilder2.append("?");
      stringBuilder2.append(stringBuilder1.toString());
      return stringBuilder2.toString();
    } catch (Exception exception) {
      this.a.d(exception);
      return "";
    } 
  }
  
  private String a(JSONObject paramJSONObject) {
    String str = "";
    if (paramJSONObject != null) {
      str = paramJSONObject.optString("buyer", "");
      if (TextUtils.isEmpty(str))
        return paramJSONObject.optString("buyer_id", ""); 
    } 
    return str;
  }
  
  private void a(int paramInt, String paramString) {
    com.baidu.mobads.openad.d.a a1 = new com.baidu.mobads.openad.d.a();
    b b = new b(paramString, "");
    b.e = paramInt;
    a1.a(b, Boolean.valueOf(true));
  }
  
  private void a(Context paramContext, String paramString, com.baidu.mobads.command.a parama) {
    IXAppInfo iXAppInfo = com.baidu.mobads.command.a.a.a(parama);
    if (iXAppInfo != null)
      a(paramContext, paramString, iXAppInfo); 
  }
  
  private void a(Context paramContext, String paramString, IXAppInfo paramIXAppInfo) {
    b b = new b(paramContext, paramIXAppInfo);
    b.b = paramIXAppInfo.getAdId();
    b(a(paramContext, paramString, b.c()));
  }
  
  private void a(String paramString1, String paramString2, HashMap<String, String> paramHashMap) {
    l l = XAdSDKFoundationFacade.getInstance().getAdConstants();
    h h = XAdSDKFoundationFacade.getInstance().getCommonUtils();
    Uri.Builder builder = new Uri.Builder();
    try {
      String str2;
      String str3;
      IXAdSystemUtils iXAdSystemUtils = XAdSDKFoundationFacade.getInstance().getSystemUtils();
      Context context = XAdSDKFoundationFacade.getInstance().getApplicationContext();
      if (context != null) {
        str3 = iXAdSystemUtils.getEncodedSN(context);
        str2 = h.base64Encode(iXAdSystemUtils.getCUID(context));
      } else {
        str2 = "";
        str3 = str2;
      } 
      Uri.Builder builder1 = builder.appendQueryParameter("type", paramString2).appendQueryParameter("p_ver", "8.8283").appendQueryParameter("appsid", l.getAppSid());
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("android_");
      stringBuilder2.append(b());
      stringBuilder2.append("_");
      stringBuilder2.append("4.1.30");
      builder1 = builder1.appendQueryParameter("v", stringBuilder2.toString()).appendQueryParameter("pack", l.getAppPackageNameOfPublisher()).appendQueryParameter("sn", str3).appendQueryParameter("cuid", str2).appendQueryParameter("os", "android").appendQueryParameter("osv", Build.VERSION.RELEASE);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("");
      stringBuilder1.append(Build.VERSION.SDK_INT);
      builder1 = builder1.appendQueryParameter("bdr", stringBuilder1.toString());
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("");
      stringBuilder1.append(h.getTextEncoder(Build.BRAND));
      builder1.appendQueryParameter("brd", stringBuilder1.toString());
      String str1 = paramString1;
      if (paramString1 != null) {
        str1 = paramString1;
        if (paramString1.length() > 128) {
          int i = paramString1.indexOf('\n');
          if (i <= 0)
            i = 127; 
          str1 = paramString1.substring(0, i);
        } 
      } 
      builder.appendQueryParameter("reason", str1);
    } finally {
      paramString1 = null;
    } 
    b b = new b("https://mobads-logs.baidu.com/brwhis.log", "");
    b.a(builder);
    b.a(0);
    (new com.baidu.mobads.openad.d.a()).a(b);
  }
  
  private String b() {
    String str = com.baidu.mobads.constants.a.c;
    if ("0.0".equals(str))
      try {
        double d = g.a(this.e, g.a(this.e));
      } finally {
        Exception exception = null;
      }  
    return str;
  }
  
  private void b(String paramString) {
    a(1, paramString);
  }
  
  public void a(double paramDouble, Context paramContext, String paramString, IXAdInstanceInfo paramIXAdInstanceInfo, IXAdProdInfo paramIXAdProdInfo, HashMap<String, String> paramHashMap) {
    try {
      if (paramDouble > (new Random()).nextDouble()) {
        HashMap<String, String> hashMap = paramHashMap;
        if (paramHashMap == null)
          hashMap = new HashMap<String, String>(); 
        hashMap.put("probability", String.valueOf(paramDouble));
        b((new c(paramString, paramIXAdInstanceInfo, paramIXAdProdInfo, hashMap)).a(paramContext));
        return;
      } 
    } catch (Exception exception) {
      q.a().e(exception);
    } 
  }
  
  public void a(double paramDouble, Context paramContext, String paramString, IXAdInstanceInfo paramIXAdInstanceInfo, IXAdProdInfo paramIXAdProdInfo, Object... paramVarArgs) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    int i = 0;
    try {
      while (i < paramVarArgs.length) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("custom_");
        stringBuilder.append(i);
        hashMap.put(stringBuilder.toString(), String.valueOf(paramVarArgs[i]));
        i++;
      } 
      a(paramDouble, paramContext, paramString, paramIXAdInstanceInfo, paramIXAdProdInfo, (HashMap)hashMap);
      return;
    } catch (Exception exception) {
      q.a().e(exception);
      return;
    } 
  }
  
  public void a(Context paramContext) {
    if (this.e == null)
      this.e = paramContext; 
  }
  
  public void a(Context paramContext, int paramInt, IXAdInstanceInfo paramIXAdInstanceInfo, HashMap<String, String> paramHashMap) {
    try {
      IXAdSystemUtils iXAdSystemUtils = XAdSDKFoundationFacade.getInstance().getSystemUtils();
      h h = XAdSDKFoundationFacade.getInstance().getCommonUtils();
      HashMap<String, String> hashMap = paramHashMap;
      if (paramHashMap == null)
        hashMap = new HashMap<String, String>(); 
      hashMap.put("type", String.valueOf(paramInt));
      hashMap.put("os", "android");
      hashMap.put("osv", Build.VERSION.RELEASE);
      hashMap.put("brand", iXAdSystemUtils.getPhoneOSBrand());
      hashMap.put("bdr", iXAdSystemUtils.getPhoneOSBuildVersionSdk());
      hashMap.put("model", Build.MODEL);
      hashMap.put("v", b());
      hashMap.put("p_ver", "8.8283");
      hashMap.put("pack", h.getAppPackage(paramContext));
      hashMap.put("appsid", h.getAppId(paramContext));
      hashMap.put("net", iXAdSystemUtils.getNetworkType(paramContext));
      hashMap.put("cuid", iXAdSystemUtils.getCUID(paramContext));
      hashMap.put("sn", iXAdSystemUtils.getEncodedSN(paramContext));
      return;
    } finally {
      paramContext = null;
      this.a.d((Throwable)paramContext);
    } 
  }
  
  public void a(Context paramContext, com.baidu.mobads.command.a parama) {
    a(paramContext, "9", parama);
  }
  
  public void a(Context paramContext, IXAppInfo paramIXAppInfo) {
    a(paramContext, "11", paramIXAppInfo);
  }
  
  public void a(Context paramContext, String paramString, IXAdInstanceInfo paramIXAdInstanceInfo, IXAdProdInfo paramIXAdProdInfo, HashMap<String, String> paramHashMap) {
    a(1.0D, paramContext, paramString, paramIXAdInstanceInfo, paramIXAdProdInfo, paramHashMap);
  }
  
  public void a(Context paramContext, String paramString, IXAdInstanceInfo paramIXAdInstanceInfo, IXAdProdInfo paramIXAdProdInfo, Object... paramVarArgs) {
    a(0.1D, paramContext, paramString, paramIXAdInstanceInfo, paramIXAdProdInfo, paramVarArgs);
  }
  
  public void a(com.baidu.mobads.command.a parama) {}
  
  public void a(String paramString) {
    StringBuilder stringBuilder;
    if (!TextUtils.isEmpty(paramString) && paramString.contains("temp_for_feed_response_html")) {
      if (!f) {
        stringBuilder = new StringBuilder();
        stringBuilder.append(b);
        stringBuilder.append("___");
        stringBuilder.append(c);
        a("temp_for_feed_response_html", "405", stringBuilder.toString());
        f = true;
        return;
      } 
    } else {
      a((String)stringBuilder, "400", (HashMap<String, String>)null);
    } 
  }
  
  public void a(String paramString1, String paramString2, String paramString3) {
    try {
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      hashMap.put("ad", paramString3);
      hashMap.put("stacktrace", paramString2);
      a(paramString1, "404", (HashMap)hashMap);
      return;
    } catch (Exception exception) {
      this.a.d(exception);
      return;
    } 
  }
  
  public void b(Context paramContext, IXAppInfo paramIXAppInfo) {
    a(paramContext, "10", paramIXAppInfo);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */