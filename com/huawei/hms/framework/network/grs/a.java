package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.a.a;
import com.huawei.hms.framework.network.grs.a.b;
import com.huawei.hms.framework.network.grs.b.b;
import com.huawei.hms.framework.network.grs.c.e;
import com.huawei.hms.framework.network.grs.c.l;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
  private static final String a = "a";
  
  private GrsBaseInfo b;
  
  private a c;
  
  private l d;
  
  public a(GrsBaseInfo paramGrsBaseInfo, a parama, l paraml) {
    this.b = paramGrsBaseInfo;
    this.c = parama;
    this.d = paraml;
  }
  
  public static CountryCodeBean a(Context paramContext, boolean paramBoolean) {
    return new CountryCodeBean(paramContext, paramBoolean);
  }
  
  private String a(String paramString1, String paramString2, b paramb, Context paramContext) {
    String str = this.c.a(this.b, paramString1, paramString2, paramb, paramContext);
    if (!TextUtils.isEmpty(str)) {
      Logger.i(a, "get url from sp is not empty.");
      return str;
    } 
    return b.a(paramContext.getPackageName(), this.b).a(this.b, paramString1, paramString2);
  }
  
  public static String a(String paramString1, String paramString2, String paramString3) {
    if (TextUtils.isEmpty(paramString1))
      return ""; 
    try {
      return (new JSONObject(paramString1)).getJSONObject(paramString2).getString(paramString3);
    } catch (JSONException jSONException) {
      Logger.w(a, "Method{getServiceNameUrl} query url from SP occur an JSONException", (Throwable)jSONException);
      return "";
    } 
  }
  
  public static Map<String, Map<String, String>> a(String paramString) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>(16);
    if (TextUtils.isEmpty(paramString)) {
      Logger.v(a, "isSpExpire jsonValue is null.");
      return (Map)hashMap;
    } 
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      Iterator<E> iterator = jSONObject.keys();
      while (iterator.hasNext()) {
        String str = iterator.next().toString();
        hashMap.put(str, a(jSONObject.getJSONObject(str)));
      } 
      return (Map)hashMap;
    } catch (JSONException jSONException) {
      Logger.w(a, "getServicesUrlsMap occur a JSONException", (Throwable)jSONException);
      return (Map)hashMap;
    } 
  }
  
  private Map<String, String> a(String paramString, b paramb, Context paramContext) {
    Map<String, String> map = this.c.a(this.b, paramString, paramb, paramContext);
    return (map != null && !map.isEmpty()) ? map : b.a(paramContext.getPackageName(), this.b).a(this.b, paramString);
  }
  
  public static Map<String, String> a(String paramString1, String paramString2) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    if (TextUtils.isEmpty(paramString1)) {
      Logger.v(a, "isSpExpire jsonValue is null.");
      return (Map)hashMap;
    } 
    try {
      String str;
      JSONObject jSONObject = (new JSONObject(paramString1)).getJSONObject(paramString2);
      if (jSONObject == null) {
        str = a;
        Logger.v(str, "getServiceNameUrls jsObject null.");
        return (Map)hashMap;
      } 
      Iterator<E> iterator = str.keys();
      while (iterator.hasNext()) {
        String str1 = iterator.next().toString();
        hashMap.put(str1, str.get(str1).toString());
      } 
      return (Map)hashMap;
    } catch (JSONException jSONException) {
      Logger.w(a, "Method{getServiceNameUrls} query url from SP occur an JSONException", (Throwable)jSONException);
      return (Map)hashMap;
    } 
  }
  
  public static Map<String, String> a(JSONObject paramJSONObject) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>(16);
    try {
      Iterator<E> iterator = paramJSONObject.keys();
      while (iterator.hasNext()) {
        String str = iterator.next().toString();
        hashMap.put(str, paramJSONObject.get(str).toString());
      } 
      return (Map)hashMap;
    } catch (JSONException jSONException) {
      Logger.w(a, "getServiceUrls occur a JSONException", (Throwable)jSONException);
      return (Map)hashMap;
    } 
  }
  
  private void a(String paramString, Map<String, String> paramMap, IQueryUrlsCallBack paramIQueryUrlsCallBack, Context paramContext) {
    this.d.a(this.b, paramContext, new a(paramString, paramMap, paramIQueryUrlsCallBack), paramString);
  }
  
  public String a(Context paramContext, String paramString) {
    e e = this.d.a(this.b, paramContext, paramString);
    return (e == null) ? "" : e.i();
  }
  
  public String a(String paramString1, String paramString2, Context paramContext) {
    b b = new b();
    String str = a(paramString1, paramString2, b, paramContext);
    if (b.a()) {
      Logger.v(a, "get unexpired cache localUrl{%s}", new Object[] { str });
      return str;
    } 
    paramString1 = a(a(paramContext, paramString1), paramString1, paramString2);
    if (!TextUtils.isEmpty(paramString1)) {
      Logger.i(a, "get url is from remote server");
      return paramString1;
    } 
    return str;
  }
  
  public Map<String, String> a(String paramString, Context paramContext) {
    b b = new b();
    Map<String, String> map2 = a(paramString, b, paramContext);
    if (b.a())
      return map2; 
    Map<String, String> map1 = a(a(paramContext, paramString), paramString);
    return !map1.isEmpty() ? map1 : map2;
  }
  
  public void a(String paramString, IQueryUrlsCallBack paramIQueryUrlsCallBack, Context paramContext) {
    b b = new b();
    Map<String, String> map = a(paramString, b, paramContext);
    if (b.a()) {
      if (map == null || map.isEmpty()) {
        paramIQueryUrlsCallBack.onCallBackFail(-5);
        return;
      } 
      paramIQueryUrlsCallBack.onCallBackSuccess(map);
      return;
    } 
    a(paramString, map, paramIQueryUrlsCallBack, paramContext);
  }
  
  public void a(String paramString1, String paramString2, IQueryUrlCallBack paramIQueryUrlCallBack, Context paramContext) {
    b b = new b();
    String str = a(paramString1, paramString2, b, paramContext);
    if (b.a()) {
      if (TextUtils.isEmpty(str)) {
        paramIQueryUrlCallBack.onCallBackFail(-5);
        return;
      } 
      paramIQueryUrlCallBack.onCallBackSuccess(str);
      return;
    } 
    this.d.a(this.b, paramContext, new b(paramString1, paramString2, paramIQueryUrlCallBack, str), paramString1);
  }
  
  static class a implements b {
    String a;
    
    Map<String, String> b;
    
    IQueryUrlsCallBack c;
    
    a(String param1String, Map<String, String> param1Map, IQueryUrlsCallBack param1IQueryUrlsCallBack) {
      this.a = param1String;
      this.b = param1Map;
      this.c = param1IQueryUrlsCallBack;
    }
    
    public void a() {
      Map<String, String> map = this.b;
      if (map != null && !map.isEmpty()) {
        this.c.onCallBackSuccess(this.b);
        return;
      } 
      this.c.onCallBackFail(-3);
    }
    
    public void a(e param1e) {
      Map<String, String> map = a.a(param1e.i(), this.a);
      if (!map.isEmpty()) {
        this.c.onCallBackSuccess(map);
        return;
      } 
      map = this.b;
      if (map != null && !map.isEmpty()) {
        this.c.onCallBackSuccess(this.b);
        return;
      } 
      this.c.onCallBackFail(-5);
    }
  }
  
  static class b implements b {
    String a;
    
    String b;
    
    IQueryUrlCallBack c;
    
    String d;
    
    b(String param1String1, String param1String2, IQueryUrlCallBack param1IQueryUrlCallBack, String param1String3) {
      this.a = param1String1;
      this.b = param1String2;
      this.c = param1IQueryUrlCallBack;
      this.d = param1String3;
    }
    
    public void a() {
      if (!TextUtils.isEmpty(this.d)) {
        this.c.onCallBackSuccess(this.d);
        return;
      } 
      this.c.onCallBackFail(-3);
    }
    
    public void a(e param1e) {
      String str = a.a(param1e.i(), this.a, this.b);
      if (!TextUtils.isEmpty(str)) {
        this.c.onCallBackSuccess(str);
        return;
      } 
      if (!TextUtils.isEmpty(this.d)) {
        this.c.onCallBackSuccess(this.d);
        return;
      } 
      this.c.onCallBackFail(-5);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\network\grs\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */