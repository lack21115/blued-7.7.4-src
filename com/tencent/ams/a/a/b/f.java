package com.tencent.ams.a.a.b;

public class f {
  public String a;
  
  public String b;
  
  public String c;
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("<offlineCache>\r\n<length>");
    stringBuilder.append(this.a);
    stringBuilder.append("</length>\r\n<queueExpirationSecs>");
    stringBuilder.append(this.b);
    stringBuilder.append("</queueExpirationSecs>\r\n<timeout>");
    stringBuilder.append(this.c);
    stringBuilder.append("</timeout></offlineCache>\r\n");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\ams\a\a\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */