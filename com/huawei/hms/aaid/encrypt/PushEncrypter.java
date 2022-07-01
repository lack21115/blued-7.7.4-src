package com.huawei.hms.aaid.encrypt;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.opendevice.c;
import com.huawei.secure.android.common.encrypt.aes.AesCbc;

public class PushEncrypter {
  public static String decrypter(Context paramContext, String paramString) {
    return TextUtils.isEmpty(paramString) ? "" : AesCbc.b(paramString, c.b(paramContext));
  }
  
  public static String encrypter(Context paramContext, String paramString) {
    return TextUtils.isEmpty(paramString) ? "" : AesCbc.a(paramString, c.b(paramContext));
  }
  
  public static String encrypterOld(Context paramContext, String paramString) {
    return TextUtils.isEmpty(paramString) ? "" : AesCbc.a(paramString, c.a(paramContext));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\aaid\encrypt\PushEncrypter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */