package com.heytap.mcssdk.mode;

public class SptDataMessage extends Message {
  private String a;
  
  private String b;
  
  private String c;
  
  private String d;
  
  public String a() {
    return this.a;
  }
  
  public void a(String paramString) {
    this.a = paramString;
  }
  
  public int b() {
    return 4103;
  }
  
  public void b(String paramString) {
    this.b = paramString;
  }
  
  public void c(String paramString) {
    this.c = paramString;
  }
  
  public void d(String paramString) {
    this.d = paramString;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("SptDataMessage{mGlobalID='");
    stringBuilder.append(this.a);
    stringBuilder.append('\'');
    stringBuilder.append(", mContent='");
    stringBuilder.append(this.b);
    stringBuilder.append('\'');
    stringBuilder.append(", mDescription='");
    stringBuilder.append(this.c);
    stringBuilder.append('\'');
    stringBuilder.append(", mAppID='");
    stringBuilder.append(this.d);
    stringBuilder.append('\'');
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\heytap\mcssdk\mode\SptDataMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */