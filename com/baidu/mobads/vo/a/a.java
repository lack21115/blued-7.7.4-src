package com.baidu.mobads.vo.a;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdProdInfo;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.h;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;

public abstract class a {
  public long a = System.currentTimeMillis();
  
  public String b = "-1";
  
  public String c = "";
  
  public String d = "";
  
  public String e = "";
  
  public String f = "";
  
  public String g = "";
  
  public String h = "";
  
  public String i;
  
  public String j = "";
  
  public String k = "";
  
  protected Context l = XAdSDKFoundationFacade.getInstance().getApplicationContext();
  
  protected h m = XAdSDKFoundationFacade.getInstance().getCommonUtils();
  
  protected IXAdSystemUtils n = XAdSDKFoundationFacade.getInstance().getSystemUtils();
  
  private a o = null;
  
  public a(a parama) {
    this(parama.a, parama.b, parama.c);
    this.o = parama;
  }
  
  @Deprecated
  public a(String paramString1, String paramString2, String paramString3) {
    this.b = paramString1;
    this.c = paramString2;
    this.e = this.m.getAppSec(this.l);
    Context context = this.l;
    if (context != null)
      this.d = context.getPackageName(); 
    this.f = this.m.getAppId(this.l);
    this.h = this.n.getEncodedSN(this.l);
    this.i = "android";
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("android_");
    stringBuilder.append(com.baidu.mobads.constants.a.c);
    stringBuilder.append("_");
    stringBuilder.append("4.1.30");
    this.g = stringBuilder.toString();
    this.j = paramString3;
    this.k = XAdSDKFoundationFacade.getInstance().getSystemUtils().getCUID(this.l);
  }
  
  protected String a(String paramString) {
    try {
      return URLEncoder.encode(paramString, "UTF-8").replaceAll("\\+", "%20").replaceAll("\\%21", "!").replaceAll("\\%27", "'").replaceAll("\\%28", "(").replaceAll("\\%29", ")").replaceAll("\\%7E", "~");
    } catch (Exception exception) {
      return paramString;
    } 
  }
  
  protected String a(HashMap<String, String> paramHashMap) {
    StringBuilder stringBuilder = new StringBuilder();
    try {
      h h1 = XAdSDKFoundationFacade.getInstance().getCommonUtils();
      StringBuilder stringBuilder1 = new StringBuilder();
      Iterator<String> iterator = paramHashMap.keySet().iterator();
      while (true) {
        boolean bool = iterator.hasNext();
        if (bool) {
          String str1 = iterator.next();
          String str2 = paramHashMap.get(str1);
          if (str1 != null && str2 != null) {
            str1 = a(str1);
            str2 = a(str2);
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(str1);
            stringBuilder4.append("=");
            stringBuilder4.append(str2);
            stringBuilder4.append("&");
            stringBuilder.append(stringBuilder4.toString());
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(str2);
            stringBuilder3.append(",");
            stringBuilder1.append(stringBuilder3.toString());
          } 
          continue;
        } 
        stringBuilder1.append("mobads,");
        String str = h1.getMD5(stringBuilder1.toString());
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("vd=");
        stringBuilder2.append(str);
        stringBuilder2.append("&");
        stringBuilder.append(stringBuilder2.toString());
        return stringBuilder.toString();
      } 
    } catch (Exception exception) {
      return "";
    } 
  }
  
  protected HashMap<String, String> a() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("adid", this.b);
    hashMap.put("appsec", this.e);
    hashMap.put("appsid", this.f);
    hashMap.put("pack", this.d);
    hashMap.put("qk", this.c);
    hashMap.put("sn", this.h);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(this.a);
    hashMap.put("ts", stringBuilder.toString());
    hashMap.put("v", this.g);
    hashMap.put("os", this.i);
    hashMap.put("prod", this.j);
    hashMap.put("cuid", XAdSDKFoundationFacade.getInstance().getBase64().encode(this.k));
    hashMap.put("p_ver", "8.8283");
    a a1 = this.o;
    if (a1 != null) {
      hashMap.put("adt", a1.d);
      hashMap.put("apid", this.o.e);
    } 
    return (HashMap)hashMap;
  }
  
  protected abstract HashMap<String, String> b();
  
  public HashMap<String, String> c() {
    HashMap<String, String> hashMap1 = a();
    HashMap<String, String> hashMap2 = b();
    if (hashMap2 != null)
      hashMap1.putAll(hashMap2); 
    return hashMap1;
  }
  
  public String toString() {
    return a(c());
  }
  
  public static class a {
    String a = "";
    
    String b = "";
    
    String c = "";
    
    String d = "";
    
    String e = "";
    
    public a(IXAdInstanceInfo param1IXAdInstanceInfo, IXAdProdInfo param1IXAdProdInfo) {
      if (param1IXAdInstanceInfo != null) {
        this.a = param1IXAdInstanceInfo.getAdId();
        this.b = param1IXAdInstanceInfo.getQueryKey();
        this.d = param1IXAdInstanceInfo.getCreativeType().getValue();
      } 
      if (param1IXAdProdInfo != null) {
        this.e = param1IXAdProdInfo.getAdPlacementId();
        this.c = param1IXAdProdInfo.getProdType();
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\vo\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */