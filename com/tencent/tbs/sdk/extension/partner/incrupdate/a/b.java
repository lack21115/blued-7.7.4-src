package com.tencent.tbs.sdk.extension.partner.incrupdate.a;

import java.io.OutputStream;

public class b extends c {
  public static String a = "uncompress";
  
  public static String b = "encode";
  
  public String c;
  
  public String d;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public void a(OutputStream paramOutputStream) {
    a(paramOutputStream, this.c);
    a(paramOutputStream, this.d);
  }
  
  public void a(String paramString1, String paramString2) {
    this.c = paramString1;
    this.d = paramString2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\sdk\extension\partner\incrupdate\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */