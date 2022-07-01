package com.soft.blued.ui.pay.alipay;

public class Result {
  public String a;
  
  String b;
  
  String c;
  
  public Result(String paramString) {
    try {
      for (String str : paramString.split(";")) {
        if (str.startsWith("resultStatus"))
          this.a = a(str, "resultStatus"); 
        if (str.startsWith("result"))
          this.b = a(str, "result"); 
        if (str.startsWith("memo"))
          this.c = a(str, "memo"); 
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  private String a(String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString2);
    stringBuilder.append("={");
    paramString2 = stringBuilder.toString();
    return paramString1.substring(paramString1.indexOf(paramString2) + paramString2.length(), paramString1.lastIndexOf("}"));
  }
  
  public String a() {
    return this.a;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("resultStatus={");
    stringBuilder.append(this.a);
    stringBuilder.append("};memo={");
    stringBuilder.append(this.c);
    stringBuilder.append("};result={");
    stringBuilder.append(this.b);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\pay\alipay\Result.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */