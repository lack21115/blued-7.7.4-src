package com.loc;

import android.content.Context;
import android.text.TextUtils;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public final class bg extends bk {
  private Context a;
  
  private String b;
  
  private ak e;
  
  private Object[] f;
  
  public bg(Context paramContext, bk parambk, ak paramak, String paramString, Object... paramVarArgs) {
    super(parambk);
    this.a = paramContext;
    this.b = paramString;
    this.e = paramak;
    this.f = paramVarArgs;
  }
  
  private String b() {
    try {
      return String.format(u.c(this.b), this.f);
    } finally {
      Exception exception = null;
      exception.printStackTrace();
      ab.b(exception, "ofm", "gpj");
    } 
  }
  
  protected final byte[] a(byte[] paramArrayOfbyte) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
    String str1 = u.a(paramArrayOfbyte);
    if (TextUtils.isEmpty(str1))
      return null; 
    String str2 = b();
    str2 = u.a(this.e.b(u.a(str2)));
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("{\"pinfo\":\"");
    stringBuilder.append(str2);
    stringBuilder.append("\",\"els\":[");
    stringBuilder.append(str1);
    stringBuilder.append("]}");
    return u.a(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */