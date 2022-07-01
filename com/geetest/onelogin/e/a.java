package com.geetest.onelogin.e;

import com.geetest.onelogin.e.a.a;
import com.geetest.onelogin.e.a.b;
import com.geetest.onelogin.e.a.h;
import java.security.interfaces.RSAPublicKey;

public class a {
  public static String a(String paramString1, String paramString2) {
    try {
      paramString1 = String.valueOf(b.a(a.b(paramString1, paramString2)));
      paramString2 = h.a(paramString2, (RSAPublicKey)h.a("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC3b9/PFJTmDI68cjDnGTsWFskS\nnr+hbxQAOiphSt/yl82XmNtj4tsaTNZx7iZ/l+4qFJvonUQ5zNpf7vRbxVrgEA60\nfQBXjrQuznVmTNOCnoNMqCG174mrdqF55k+iSgDE12ljEJjHR5KF10SWVF3E/RSz\nlRAxjIszKMzPyeHxQQIDAQAB"));
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString1);
      stringBuilder.append(paramString2);
      return stringBuilder.toString();
    } catch (Exception exception) {
      exception.printStackTrace();
      return "";
    } 
  }
  
  public static String b(String paramString1, String paramString2) {
    return String.valueOf(b.a(a.b(paramString1, paramString2)));
  }
  
  public static String c(String paramString1, String paramString2) {
    return a.c(paramString1, paramString2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */