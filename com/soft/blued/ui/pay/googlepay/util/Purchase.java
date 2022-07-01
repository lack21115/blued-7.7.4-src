package com.soft.blued.ui.pay.googlepay.util;

import org.json.JSONException;
import org.json.JSONObject;

public class Purchase {
  String a;
  
  String b;
  
  String c;
  
  String d;
  
  long e;
  
  int f;
  
  String g;
  
  String h;
  
  String i;
  
  String j;
  
  boolean k;
  
  public Purchase(String paramString1, String paramString2, String paramString3) throws JSONException {
    this.a = paramString1;
    this.i = paramString2;
    JSONObject jSONObject = new JSONObject(this.i);
    this.b = jSONObject.optString("orderId");
    this.c = jSONObject.optString("packageName");
    this.d = jSONObject.optString("productId");
    this.e = jSONObject.optLong("purchaseTime");
    this.f = jSONObject.optInt("purchaseState");
    this.g = jSONObject.optString("developerPayload");
    this.h = jSONObject.optString("token", jSONObject.optString("purchaseToken"));
    this.k = jSONObject.optBoolean("autoRenewing");
    this.j = paramString3;
  }
  
  public String a() {
    return this.a;
  }
  
  public String b() {
    return this.d;
  }
  
  public String c() {
    return this.h;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("PurchaseInfo(type:");
    stringBuilder.append(this.a);
    stringBuilder.append("):");
    stringBuilder.append(this.i);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\pay\googlepa\\util\Purchase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */