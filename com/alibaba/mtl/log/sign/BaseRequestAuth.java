package com.alibaba.mtl.log.sign;

import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.j;

public class BaseRequestAuth implements IRequestAuth {
  private String Y = null;
  
  private String b = null;
  
  public BaseRequestAuth(String paramString1, String paramString2) {
    this.b = paramString1;
    this.Y = paramString2;
  }
  
  public String getAppSecret() {
    return this.Y;
  }
  
  public String getAppkey() {
    return this.b;
  }
  
  public String getSign(String paramString) {
    if (this.b == null || this.Y == null) {
      i.a("BaseRequestAuth", new Object[] { "There is no appkey,please check it!" });
      return null;
    } 
    if (paramString == null)
      return null; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(this.Y);
    return j.a(j.a(stringBuilder.toString().getBytes()));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\log\sign\BaseRequestAuth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */