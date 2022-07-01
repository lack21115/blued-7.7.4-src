package com.alipay.sdk.protocol;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class b {
  private a a;
  
  private String b;
  
  private String[] c;
  
  public b(String paramString) {
    this.b = paramString;
  }
  
  public b(String paramString, a parama) {
    this.b = paramString;
    this.a = parama;
  }
  
  public static List<b> a(JSONObject paramJSONObject) {
    ArrayList<b> arrayList = new ArrayList();
    if (paramJSONObject == null)
      return arrayList; 
    String[] arrayOfString = b(paramJSONObject.optString("name", ""));
    for (int i = 0; i < arrayOfString.length; i++) {
      a a1 = a.a(arrayOfString[i]);
      if (a1 != a.a) {
        b b1 = new b(arrayOfString[i], a1);
        b1.c = a(arrayOfString[i]);
        arrayList.add(b1);
      } 
    } 
    return arrayList;
  }
  
  public static void a(b paramb) {
    String[] arrayOfString = paramb.c();
    if (arrayOfString.length != 3)
      return; 
    if (TextUtils.equals("tid", arrayOfString[0])) {
      com.alipay.sdk.tid.b b1 = com.alipay.sdk.tid.b.a(com.alipay.sdk.sys.b.a().b());
      if (!TextUtils.isEmpty(arrayOfString[1])) {
        if (TextUtils.isEmpty(arrayOfString[2]))
          return; 
        b1.a(arrayOfString[1], arrayOfString[2]);
      } 
    } 
  }
  
  private static String[] a(String paramString) {
    ArrayList<String> arrayList = new ArrayList();
    int i = paramString.indexOf('(');
    int j = paramString.lastIndexOf(')');
    if (i == -1 || j == -1 || j <= i)
      return null; 
    String[] arrayOfString = paramString.substring(i + 1, j).split("' *, *'", -1);
    j = arrayOfString.length;
    for (i = 0; i < j; i++)
      arrayList.add(arrayOfString[i].trim().replaceAll("'", "").replaceAll("\"", "")); 
    return arrayList.<String>toArray(new String[0]);
  }
  
  private static String[] b(String paramString) {
    return !TextUtils.isEmpty(paramString) ? paramString.split(";") : null;
  }
  
  public String a() {
    return this.b;
  }
  
  public a b() {
    return this.a;
  }
  
  public String[] c() {
    return this.c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\protocol\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */