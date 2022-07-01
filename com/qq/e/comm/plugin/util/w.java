package com.qq.e.comm.plugin.util;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class w {
  private JSONObject a;
  
  public w() {
    this.a = new JSONObject();
  }
  
  public w(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial <init> : ()V
    //   4: aload_1
    //   5: ifnull -> 42
    //   8: aload_1
    //   9: invokevirtual trim : ()Ljava/lang/String;
    //   12: invokevirtual isEmpty : ()Z
    //   15: ifne -> 42
    //   18: aload_1
    //   19: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   22: ldc 'null'
    //   24: invokevirtual equals : (Ljava/lang/Object;)Z
    //   27: ifne -> 42
    //   30: new org/json/JSONObject
    //   33: dup
    //   34: aload_1
    //   35: invokespecial <init> : (Ljava/lang/String;)V
    //   38: astore_1
    //   39: goto -> 50
    //   42: new org/json/JSONObject
    //   45: dup
    //   46: invokespecial <init> : ()V
    //   49: astore_1
    //   50: aload_0
    //   51: aload_1
    //   52: putfield a : Lorg/json/JSONObject;
    //   55: return
    //   56: astore_1
    //   57: aload_1
    //   58: invokevirtual printStackTrace : ()V
    //   61: aload_0
    //   62: new org/json/JSONObject
    //   65: dup
    //   66: invokespecial <init> : ()V
    //   69: putfield a : Lorg/json/JSONObject;
    //   72: return
    // Exception table:
    //   from	to	target	type
    //   8	39	56	org/json/JSONException
    //   42	50	56	org/json/JSONException
    //   50	55	56	org/json/JSONException
  }
  
  public w(JSONObject paramJSONObject) {
    JSONObject jSONObject = paramJSONObject;
    if (paramJSONObject == null)
      jSONObject = new JSONObject(); 
    this.a = jSONObject;
  }
  
  public w a(String paramString, int paramInt) {
    try {
      if (!TextUtils.isEmpty(paramString)) {
        this.a.put(paramString, paramInt);
        return this;
      } 
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    return this;
  }
  
  public w a(String paramString, long paramLong) {
    try {
      if (!TextUtils.isEmpty(paramString)) {
        this.a.put(paramString, paramLong);
        return this;
      } 
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    return this;
  }
  
  public w a(String paramString, Object paramObject) {
    try {
      if (!TextUtils.isEmpty(paramString) && paramObject != null) {
        this.a.put(paramString, paramObject);
        return this;
      } 
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    return this;
  }
  
  public w a(String paramString1, String paramString2) {
    try {
      if (!TextUtils.isEmpty(paramString1) && !TextUtils.isEmpty(paramString2)) {
        this.a.put(paramString1, paramString2);
        return this;
      } 
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    return this;
  }
  
  public JSONObject a() {
    return this.a;
  }
  
  public String toString() {
    return this.a.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */