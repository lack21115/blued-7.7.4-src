package com.heytap.mcssdk.mode;

import android.text.TextUtils;
import org.json.JSONObject;

public class MessageStat {
  private int a = 4096;
  
  private String b;
  
  private String c;
  
  private String d;
  
  private String e;
  
  private String f;
  
  private long g = System.currentTimeMillis();
  
  public MessageStat() {}
  
  public MessageStat(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    a(paramInt);
    b(paramString1);
    c(paramString2);
    a(paramString3);
    d(paramString4);
    e(paramString5);
  }
  
  public MessageStat(String paramString1, String paramString2, String paramString3) {
    this(4096, paramString1, null, null, paramString2, paramString3);
  }
  
  public String a() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.putOpt("messageType", Integer.valueOf(this.a));
      jSONObject.putOpt("eventID", this.c);
      jSONObject.putOpt("appPackage", this.b);
      jSONObject.putOpt("eventTime", Long.valueOf(this.g));
      if (!TextUtils.isEmpty(this.d))
        jSONObject.putOpt("globalID", this.d); 
      if (!TextUtils.isEmpty(this.e))
        jSONObject.putOpt("taskID", this.e); 
      if (!TextUtils.isEmpty(this.f))
        jSONObject.putOpt("property", this.f); 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return jSONObject.toString();
  }
  
  public void a(int paramInt) {
    this.a = paramInt;
  }
  
  public void a(String paramString) {
    this.e = paramString;
  }
  
  public void b(String paramString) {
    this.b = paramString;
  }
  
  public void c(String paramString) {
    this.d = paramString;
  }
  
  public void d(String paramString) {
    this.c = paramString;
  }
  
  public void e(String paramString) {
    this.f = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\heytap\mcssdk\mode\MessageStat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */