package com.qq.e.comm.plugin.util;

import com.qq.e.comm.plugin.a.l;
import com.qq.e.comm.plugin.ad.j;
import com.qq.e.comm.plugin.s.a;
import com.qq.e.comm.util.StringUtil;
import org.json.JSONObject;

public class d {
  public static final String a(String paramString, int paramInt) {
    if (!StringUtil.isEmpty(paramString)) {
      if (12 == paramInt) {
        StringBuilder stringBuilder = new StringBuilder();
        String str = "http://d.gdt.qq.com/fcg-bin/gdt_appdetail.fcg?ico=1&op_appid=";
        stringBuilder.append(str);
        stringBuilder.append(paramString);
        return stringBuilder.toString();
      } 
      if (5 == paramInt) {
        StringBuilder stringBuilder = new StringBuilder();
        String str = "http://d.gdt.qq.com/fcg-bin/gdt_appdetail.fcg?ico=1&appid=";
        stringBuilder.append(str);
        stringBuilder.append(paramString);
        return stringBuilder.toString();
      } 
    } 
    return null;
  }
  
  public static boolean a(int paramInt) {
    return (paramInt == 19 || paramInt == 12 || paramInt == 5 || paramInt == 38);
  }
  
  public static boolean a(a parama) {
    return (parama == null) ? false : a(parama.a_());
  }
  
  public static boolean a(JSONObject paramJSONObject) {
    return (paramJSONObject == null) ? false : a(paramJSONObject.optInt("producttype"));
  }
  
  public static boolean b(JSONObject paramJSONObject) {
    return (paramJSONObject != null && paramJSONObject.optInt("app_landing_page") == 1);
  }
  
  public static boolean c(JSONObject paramJSONObject) {
    return (paramJSONObject != null && paramJSONObject.optInt("producttype") == 38);
  }
  
  public static j d(JSONObject paramJSONObject) {
    j j = new j();
    JSONObject jSONObject = paramJSONObject.optJSONObject("ext");
    if (c(paramJSONObject) && jSONObject != null) {
      j.b(jSONObject.optString("pkg_name"));
      j.b(jSONObject.optInt("appscore", 5));
      j.b(jSONObject.optLong("appdownloadnum", 100000L));
      j.a(jSONObject.optDouble("appprice"));
      j.c(jSONObject.optString("appname"));
      j.d(jSONObject.optString("applogo"));
      j.a(jSONObject.optString("appvername"));
      j.a(jSONObject.optLong("pkgsize"));
      j.c(l.a().a(j.d()));
      return j;
    } 
    if (a(paramJSONObject) && jSONObject != null) {
      JSONObject jSONObject1 = jSONObject.optJSONObject("alist");
      if (jSONObject1 != null) {
        String str2;
        String str1;
        paramJSONObject = jSONObject1.optJSONObject("2022");
        if (paramJSONObject != null) {
          str2 = paramJSONObject.optString("aid");
        } else {
          str2 = jSONObject1.optString("packagename");
        } 
        j.b(str2);
        j.b(jSONObject.optInt("appscore"));
        j.a(jSONObject.optDouble("appprice"));
        j.c(jSONObject.optString("appname"));
        j.a(jSONObject.optString("appvername"));
        j.a(jSONObject.optLong("pkgsize"));
        j.c(l.a().a(j.d()));
        JSONObject jSONObject2 = jSONObject1.optJSONObject("2025");
        if (jSONObject2 != null) {
          jSONObject2 = jSONObject2.optJSONObject("aid");
          if (jSONObject2 != null) {
            j.b(jSONObject2.optLong("total"));
            str1 = jSONObject2.optString("iconurl");
          } else {
            j.b(jSONObject.optLong("appdownloadnum"));
            return j;
          } 
        } else {
          j.b(jSONObject.optLong("downloadnum"));
          str1 = jSONObject.optString("applogo");
        } 
        j.d(str1);
      } 
    } 
    return j;
  }
  
  public static String e(JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      j j = d(paramJSONObject);
      if (j != null)
        return j.d(); 
    } 
    return null;
  }
  
  public static boolean f(JSONObject paramJSONObject) {
    return (paramJSONObject != null && paramJSONObject.optInt("app_store") == 1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */