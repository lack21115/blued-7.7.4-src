package com.soft.blued.ui.pay.googlepay.util;

import org.json.JSONException;
import org.json.JSONObject;

public class SkuDetails {
  private final String a;
  
  private final String b;
  
  private final String c;
  
  private final String d;
  
  private final long e;
  
  private final String f;
  
  private final String g;
  
  private final String h;
  
  private final String i;
  
  public SkuDetails(String paramString1, String paramString2) throws JSONException {
    this.a = paramString1;
    this.i = paramString2;
    JSONObject jSONObject = new JSONObject(this.i);
    this.b = jSONObject.optString("productId");
    this.c = jSONObject.optString("type");
    this.d = jSONObject.optString("price");
    this.e = jSONObject.optLong("price_amount_micros");
    this.f = jSONObject.optString("price_currency_code");
    this.g = jSONObject.optString("title");
    this.h = jSONObject.optString("description");
  }
  
  public String a() {
    return this.b;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SkuDetails:");
    stringBuilder.append(this.i);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\pay\googlepa\\util\SkuDetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */