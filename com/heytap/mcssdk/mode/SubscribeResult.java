package com.heytap.mcssdk.mode;

public class SubscribeResult {
  private String a;
  
  private String b;
  
  public void a(String paramString) {
    this.a = paramString;
  }
  
  public void b(String paramString) {
    this.b = paramString;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("SubscribeResult{mSubscribeId='");
    stringBuilder.append(this.a);
    stringBuilder.append('\'');
    stringBuilder.append(", mContent='");
    stringBuilder.append(this.b);
    stringBuilder.append('\'');
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\heytap\mcssdk\mode\SubscribeResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */