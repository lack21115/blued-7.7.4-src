package com.amap.api.mapcore2d;

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

public class fk extends fo {
  private Context a;
  
  private String b;
  
  private df e;
  
  private Object[] f;
  
  public fk(Context paramContext, fo paramfo, df paramdf, String paramString, Object... paramVarArgs) {
    super(paramfo);
    this.a = paramContext;
    this.b = paramString;
    this.e = paramdf;
    this.f = paramVarArgs;
  }
  
  private String a(Context paramContext) {
    try {
      return String.format(db.c(this.b), this.f);
    } finally {
      paramContext = null;
      paramContext.printStackTrace();
      do.c((Throwable)paramContext, "ofm", "gpj");
    } 
  }
  
  private String b(Context paramContext) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
    String str = a(paramContext);
    return db.a(this.e.b(db.a(str)));
  }
  
  protected byte[] a(byte[] paramArrayOfbyte) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
    String str1 = db.a(paramArrayOfbyte);
    if (TextUtils.isEmpty(str1))
      return null; 
    String str2 = b(this.a);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("{\"pinfo\":\"");
    stringBuilder.append(str2);
    stringBuilder.append("\",\"els\":[");
    stringBuilder.append(str1);
    stringBuilder.append("]}");
    return db.a(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\fk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */