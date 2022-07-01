package com.amap.api.col.s;

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

public final class dj extends dn {
  private Context a;
  
  private String b;
  
  private cm e;
  
  private Object[] f;
  
  public dj(Context paramContext, dn paramdn, cm paramcm, String paramString, Object... paramVarArgs) {
    super(paramdn);
    this.a = paramContext;
    this.b = paramString;
    this.e = paramcm;
    this.f = paramVarArgs;
  }
  
  private String b() {
    try {
      return String.format(bs.c(this.b), this.f);
    } finally {
      Exception exception = null;
      exception.printStackTrace();
      cg.c(exception, "ofm", "gpj");
    } 
  }
  
  protected final byte[] a(byte[] paramArrayOfbyte) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
    String str1 = bs.a(paramArrayOfbyte);
    if (TextUtils.isEmpty(str1))
      return null; 
    String str2 = b();
    str2 = bs.a(this.e.b(bs.a(str2)));
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("{\"pinfo\":\"");
    stringBuilder.append(str2);
    stringBuilder.append("\",\"els\":[");
    stringBuilder.append(str1);
    stringBuilder.append("]}");
    return bs.a(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\dj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */