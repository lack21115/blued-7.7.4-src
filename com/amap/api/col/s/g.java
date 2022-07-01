package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.cloud.CloudItem;
import com.amap.api.services.cloud.CloudResult;
import com.amap.api.services.cloud.CloudSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class g extends e<CloudSearch.Query, CloudResult> {
  private int j = 0;
  
  public g(Context paramContext, CloudSearch.Query paramQuery) {
    super(paramContext, paramQuery);
  }
  
  private static String a(Map<String, String> paramMap) {
    StringBuilder stringBuilder = new StringBuilder();
    for (Map.Entry<String, String> entry : paramMap.entrySet()) {
      if (stringBuilder.length() > 0)
        stringBuilder.append("&"); 
      stringBuilder.append((String)entry.getKey());
      stringBuilder.append("=");
      stringBuilder.append((String)entry.getValue());
    } 
    return stringBuilder.toString();
  }
  
  private CloudResult c(String paramString) throws AMapException {
    JSONException jSONException1;
    JSONException jSONException2 = null;
    if (paramString == null || paramString.equals(""))
      return CloudResult.createPagedResult(this.b, this.j, this.b.getBound(), this.b.getPageSize(), null); 
    try {
      ArrayList<CloudItem> arrayList = c(new JSONObject(paramString));
    } catch (JSONException null) {
      jSONException1.printStackTrace();
      jSONException1 = jSONException2;
    } catch (Exception exception) {
      exception.printStackTrace();
      jSONException1 = jSONException2;
    } 
    return CloudResult.createPagedResult(this.b, this.j, this.b.getBound(), this.b.getPageSize(), (ArrayList)jSONException1);
  }
  
  private ArrayList<CloudItem> c(JSONObject paramJSONObject) throws JSONException {
    // Byte code:
    //   0: new java/util/ArrayList
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #4
    //   9: aload_1
    //   10: invokestatic a : (Lorg/json/JSONObject;)Lorg/json/JSONArray;
    //   13: astore #5
    //   15: aload #5
    //   17: ifnonnull -> 23
    //   20: aload #4
    //   22: areturn
    //   23: aload_1
    //   24: ldc 'data'
    //   26: invokevirtual optJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   29: astore_1
    //   30: iconst_0
    //   31: istore_3
    //   32: aload_1
    //   33: ifnull -> 57
    //   36: aload_1
    //   37: ldc 'info'
    //   39: invokevirtual optJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   42: astore_1
    //   43: aload_1
    //   44: ifnull -> 57
    //   47: aload_1
    //   48: ldc 'count'
    //   50: invokevirtual optInt : (Ljava/lang/String;)I
    //   53: istore_2
    //   54: goto -> 59
    //   57: iconst_0
    //   58: istore_2
    //   59: aload_0
    //   60: iload_2
    //   61: putfield j : I
    //   64: iload_3
    //   65: istore_2
    //   66: iload_2
    //   67: aload #5
    //   69: invokevirtual length : ()I
    //   72: if_icmpge -> 109
    //   75: aload #5
    //   77: iload_2
    //   78: invokevirtual optJSONObject : (I)Lorg/json/JSONObject;
    //   81: astore_1
    //   82: aload_1
    //   83: invokestatic b : (Lorg/json/JSONObject;)Lcom/amap/api/services/cloud/CloudItemDetail;
    //   86: astore #6
    //   88: aload #6
    //   90: aload_1
    //   91: invokestatic a : (Lcom/amap/api/services/cloud/CloudItem;Lorg/json/JSONObject;)V
    //   94: aload #4
    //   96: aload #6
    //   98: invokevirtual add : (Ljava/lang/Object;)Z
    //   101: pop
    //   102: iload_2
    //   103: iconst_1
    //   104: iadd
    //   105: istore_2
    //   106: goto -> 66
    //   109: aload #4
    //   111: areturn
  }
  
  private static String d(String paramString) {
    String str2;
    String str1 = paramString;
    try {
      if (TextUtils.isEmpty(paramString))
        return ""; 
      String str4 = paramString;
      if (paramString != null) {
        str1 = paramString;
        str4 = paramString.replace("&&", "%26%26");
      } 
      str1 = str4;
      String[] arrayOfString = str4.split("&");
      str1 = str4;
      Arrays.sort((Object[])arrayOfString);
      str1 = str4;
      StringBuffer stringBuffer = new StringBuffer();
      str1 = str4;
      int j = arrayOfString.length;
      for (int i = 0; i < j; i++) {
        str1 = str4;
        stringBuffer.append(arrayOfString[i]);
        str1 = str4;
        stringBuffer.append("&");
      } 
      str1 = str4;
      str2 = stringBuffer.toString();
      String str3 = str2;
      if (str2 != null) {
        str1 = str4;
        str3 = str2.replace("%26%26", "&&");
      } 
      str1 = str4;
    } finally {
      paramString = null;
      cd.a((Throwable)paramString, "ut", "sPa");
    } 
    return str2;
  }
  
  private String h() {
    return (this.b.getSortingrules() != null) ? this.b.getSortingrules().toString() : "";
  }
  
  protected final String a() {
    return null;
  }
  
  public final Map<String, String> e() {
    Hashtable<Object, Object> hashtable = new Hashtable<Object, Object>(16);
    hashtable.put("key", bi.f(this.e));
    hashtable.put("output", "json");
    if (this.b.getBound() != null)
      if (this.b.getBound().getShape().equals("Bound")) {
        double d1 = i.a(this.b.getBound().getCenter().getLongitude());
        double d2 = i.a(this.b.getBound().getCenter().getLatitude());
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(d1);
        stringBuilder1.append(",");
        stringBuilder1.append(d2);
        hashtable.put("center", stringBuilder1.toString());
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(this.b.getBound().getRange());
        hashtable.put("radius", stringBuilder1.toString());
      } else if (this.b.getBound().getShape().equals("Rectangle")) {
        LatLonPoint latLonPoint1 = this.b.getBound().getLowerLeft();
        LatLonPoint latLonPoint2 = this.b.getBound().getUpperRight();
        double d1 = i.a(latLonPoint1.getLatitude());
        double d2 = i.a(latLonPoint1.getLongitude());
        double d3 = i.a(latLonPoint2.getLatitude());
        double d4 = i.a(latLonPoint2.getLongitude());
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(d2);
        stringBuilder1.append(",");
        stringBuilder1.append(d1);
        stringBuilder1.append(";");
        stringBuilder1.append(d4);
        stringBuilder1.append(",");
        stringBuilder1.append(d3);
        hashtable.put("polygon", stringBuilder1.toString());
      } else if (this.b.getBound().getShape().equals("Polygon")) {
        List<LatLonPoint> list = this.b.getBound().getPolyGonList();
        if (list != null && list.size() > 0)
          hashtable.put("polygon", i.a(list, ";")); 
      } else if (this.b.getBound().getShape().equals("Local")) {
        hashtable.put("city", this.b.getBound().getCity());
      }  
    hashtable.put("layerId", this.b.getTableID());
    if (!i.a(h()))
      hashtable.put("sortrule", h()); 
    StringBuffer stringBuffer = new StringBuffer();
    String str3 = this.b.getFilterString();
    String str4 = this.b.getFilterNumString();
    stringBuffer.append(str3);
    if (!i.a(str3) && !i.a(str4))
      stringBuffer.append("&&"); 
    stringBuffer.append(str4);
    String str2 = stringBuffer.toString();
    if (!i.a(str2))
      hashtable.put("filter", str2); 
    str2 = this.b.getQueryString();
    if (str2 != null && !"".equals(str2)) {
      hashtable.put("keywords", str2);
    } else {
      hashtable.put("keywords", "");
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.b.getPageSize());
    hashtable.put("pageSize", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(this.b.getPageNum());
    hashtable.put("pageNum", stringBuilder.toString());
    String str1 = bl.a();
    str3 = bl.a(this.e, str1, d(a((Map)hashtable)));
    hashtable.put("ts", str1);
    hashtable.put("scode", str3);
    return (Map)hashtable;
  }
  
  public final String g() {
    StringBuilder stringBuilder1;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(h.d());
    stringBuilder2.append("/datasearch");
    String str2 = stringBuilder2.toString();
    String str3 = this.b.getBound().getShape();
    if (str3.equals("Bound")) {
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(str2);
      stringBuilder2.append("/around");
      return stringBuilder2.toString();
    } 
    if (str3.equals("Polygon") || str3.equals("Rectangle")) {
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(str2);
      stringBuilder2.append("/polygon");
      return stringBuilder2.toString();
    } 
    String str1 = str2;
    if (str3.equals("Local")) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str2);
      stringBuilder1.append("/local");
      return stringBuilder1.toString();
    } 
    return (String)stringBuilder1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */