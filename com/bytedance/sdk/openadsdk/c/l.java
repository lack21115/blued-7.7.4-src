package com.bytedance.sdk.openadsdk.c;

import android.content.Context;

public class l extends n {
  public l(Context paramContext) {
    super(paramContext);
  }
  
  public static String e() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("CREATE TABLE IF NOT EXISTS ");
    stringBuilder.append("logstatsbatch");
    stringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT,");
    stringBuilder.append("id");
    stringBuilder.append(" TEXT UNIQUE,");
    stringBuilder.append("value");
    stringBuilder.append(" TEXT ,");
    stringBuilder.append("gen_time");
    stringBuilder.append(" TEXT , ");
    stringBuilder.append("retry");
    stringBuilder.append(" INTEGER default 0");
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
  
  public void a(int paramInt) {
    this.a.a("stats_serverbusy_retrycount", paramInt);
  }
  
  public int c() {
    return this.a.b("stats_serverbusy_retrycount", 0);
  }
  
  public String d() {
    return "logstatsbatch";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\c\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */