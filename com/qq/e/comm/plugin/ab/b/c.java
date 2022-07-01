package com.qq.e.comm.plugin.ab.b;

import com.qq.e.comm.util.StringUtil;

public class c {
  private String a;
  
  private String[] b;
  
  public c(String paramString, String... paramVarArgs) {
    this.a = paramString;
    this.b = paramVarArgs;
  }
  
  public String a() {
    StringBuilder stringBuilder = new StringBuilder();
    String str = this.a;
    if (str != null) {
      stringBuilder.append(str);
      stringBuilder.append("(");
      String[] arrayOfString = this.b;
      if (arrayOfString != null && arrayOfString.length > 0) {
        String str1 = StringUtil.join("','", arrayOfString);
        stringBuilder.append("'");
        stringBuilder.append(str1);
        stringBuilder.append("'");
      } 
      stringBuilder.append(")");
    } 
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ab\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */