package com.geetest.onelogin.a;

public class c {
  private String a = "-1";
  
  private String b = "-1";
  
  public c() {}
  
  public c(String paramString1, String paramString2) {}
  
  public String a() {
    return this.b;
  }
  
  public String b() {
    byte b;
    try {
      String str = this.a;
      b = -1;
      switch (str.hashCode()) {
        case 51:
          if (str.equals("3"))
            b = 2; 
          break;
        case 50:
          if (str.equals("2"))
            b = 1; 
          break;
        case 49:
          if (str.equals("1"))
            b = 0; 
          break;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      return "unknown";
    } 
    return (b != 0) ? ((b != 1) ? ((b == 2) ? "CT" : "unknown") : "CU") : "CM";
  }
  
  public boolean equals(Object paramObject) {
    c c1 = (c)paramObject;
    return super.equals(paramObject);
  }
  
  public int hashCode() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.a);
    stringBuilder.append(this.b);
    return stringBuilder.toString().hashCode();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("operatorType: {\"operatorType\":\"");
    stringBuilder.append(this.a);
    stringBuilder.append("\", \"networkType\":\"");
    stringBuilder.append(this.b);
    stringBuilder.append("\"");
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */