package com.heytap.mcssdk.mode;

import android.text.TextUtils;
import com.heytap.mcssdk.utils.LogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CommandMessage extends Message {
  public static final String a;
  
  private String b;
  
  private String c;
  
  private String d;
  
  private String e;
  
  private int f;
  
  private String g;
  
  private int h = -2;
  
  public static <T> String a(List<T> paramList) {
    StringBuilder stringBuilder = new StringBuilder();
    Iterator<T> iterator = paramList.iterator();
    while (iterator.hasNext()) {
      stringBuilder.append(iterator.next());
      stringBuilder.append("&");
    } 
    return stringBuilder.toString();
  }
  
  public static List<SubscribeResult> a(String paramString1, String paramString2, String paramString3, String paramString4) {
    String str;
    if (TextUtils.isEmpty(paramString1))
      return null; 
    try {
      JSONArray jSONArray = (new JSONObject(paramString1)).getJSONArray(paramString2);
      ArrayList<SubscribeResult> arrayList = new ArrayList();
      int i = 0;
      while (true) {
        ArrayList<SubscribeResult> arrayList1 = arrayList;
        try {
          if (i < jSONArray.length()) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            SubscribeResult subscribeResult = new SubscribeResult();
            subscribeResult.b(jSONObject.getString(paramString4));
            subscribeResult.a(jSONObject.getString(paramString3));
            arrayList.add(subscribeResult);
            i++;
            continue;
          } 
        } catch (JSONException jSONException) {
          // Byte code: goto -> 108
        } 
        break;
      } 
    } catch (JSONException jSONException) {
      paramString1 = null;
      jSONException.printStackTrace();
      str = paramString1;
    } 
    StringBuilder stringBuilder = new StringBuilder("parseToSubscribeResultList--");
    stringBuilder.append(str);
    LogUtil.a(stringBuilder.toString());
    return (List<SubscribeResult>)str;
  }
  
  public int a() {
    return this.f;
  }
  
  public void a(int paramInt) {
    this.f = paramInt;
  }
  
  public void a(String paramString) {
    this.b = paramString;
  }
  
  public int b() {
    return 4105;
  }
  
  public void b(int paramInt) {
    this.h = paramInt;
  }
  
  public void b(String paramString) {
    this.c = paramString;
  }
  
  public String c() {
    return this.g;
  }
  
  public void c(String paramString) {
    this.g = paramString;
  }
  
  public int d() {
    return this.h;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("CommandMessage{, mRegisterID='");
    stringBuilder.append(this.d);
    stringBuilder.append('\'');
    stringBuilder.append(", mSdkVersion='");
    stringBuilder.append(this.e);
    stringBuilder.append('\'');
    stringBuilder.append(", mCommand=");
    stringBuilder.append(this.f);
    stringBuilder.append(", mContent='");
    stringBuilder.append(this.g);
    stringBuilder.append('\'');
    stringBuilder.append(", mResponseCode=");
    stringBuilder.append(this.h);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\heytap\mcssdk\mode\CommandMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */