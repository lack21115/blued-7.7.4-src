package com.bytedance.tea.crash.upload;

import org.json.JSONObject;

public class f {
  private final int a;
  
  private String b;
  
  private JSONObject c;
  
  public f(int paramInt) {
    this.a = paramInt;
  }
  
  public f(int paramInt, String paramString) {
    this.a = paramInt;
    this.b = paramString;
  }
  
  public f(int paramInt, Throwable paramThrowable) {
    this.a = paramInt;
    if (paramThrowable != null)
      this.b = paramThrowable.getMessage(); 
  }
  
  public f(int paramInt, JSONObject paramJSONObject) {
    this.a = paramInt;
    this.c = paramJSONObject;
  }
  
  public boolean a() {
    return (this.a == 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\cras\\upload\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */