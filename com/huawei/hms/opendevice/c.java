package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.hms.openid.R;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.RootKeyUtil;
import com.huawei.secure.android.common.encrypt.utils.WorkKeyCryptUtil;

public abstract class c {
  public static RootKeyUtil a;
  
  public static RootKeyUtil a(Context paramContext, PushPreferences paramPushPreferences) {
    if (a == null)
      if (!TextUtils.isEmpty(paramPushPreferences.getString("Jarvis"))) {
        a = RootKeyUtil.a(paramPushPreferences.getString("CaptainA"), paramPushPreferences.getString("IronMan"), paramPushPreferences.getString("CaptainM"), paramPushPreferences.getString("SpokesMan"));
      } else {
        c(paramContext);
      }  
    return a;
  }
  
  public static String a() {
    return "2A57086C86EF54970C1E6EB37BFC72B1";
  }
  
  public static byte[] a(Context paramContext) {
    byte[] arrayOfByte2 = a.a(paramContext.getString(R.string.push_cat_head));
    byte[] arrayOfByte1 = a.a(paramContext.getString(R.string.push_cat_body));
    byte[] arrayOfByte3 = a.a(a());
    return a(a(a(arrayOfByte2, arrayOfByte1), arrayOfByte3));
  }
  
  public static byte[] a(byte[] paramArrayOfbyte) {
    int i = 0;
    if (paramArrayOfbyte == null || paramArrayOfbyte.length == 0)
      return new byte[0]; 
    while (i < paramArrayOfbyte.length) {
      paramArrayOfbyte[i] = (byte)(paramArrayOfbyte[i] >> 2);
      i++;
    } 
    return paramArrayOfbyte;
  }
  
  public static byte[] a(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    int i = 0;
    if (paramArrayOfbyte1 == null || paramArrayOfbyte2 == null || paramArrayOfbyte1.length == 0 || paramArrayOfbyte2.length == 0)
      return new byte[0]; 
    int j = paramArrayOfbyte1.length;
    if (j != paramArrayOfbyte2.length)
      return new byte[0]; 
    byte[] arrayOfByte = new byte[j];
    while (i < j) {
      arrayOfByte[i] = (byte)(paramArrayOfbyte1[i] ^ paramArrayOfbyte2[i]);
      i++;
    } 
    return arrayOfByte;
  }
  
  public static String b(Context paramContext) {
    PushPreferences pushPreferences = new PushPreferences(paramContext, "LocalAvengers");
    RootKeyUtil rootKeyUtil = a(paramContext, pushPreferences);
    return WorkKeyCryptUtil.b(pushPreferences.getString("Jarvis"), rootKeyUtil);
  }
  
  public static void c(Context paramContext) {
    PushPreferences pushPreferences = new PushPreferences(paramContext, "LocalAvengers");
    if (!TextUtils.isEmpty(pushPreferences.getString("Jarvis")))
      return; 
    byte[] arrayOfByte3 = EncryptUtil.a(32);
    byte[] arrayOfByte4 = EncryptUtil.a(32);
    byte[] arrayOfByte2 = EncryptUtil.a(32);
    byte[] arrayOfByte1 = EncryptUtil.a(32);
    String str2 = a.a(arrayOfByte3);
    String str3 = a.a(arrayOfByte4);
    String str1 = a.a(arrayOfByte2);
    a = RootKeyUtil.a(str2, str3, str1, arrayOfByte1);
    pushPreferences.saveString("CaptainA", str2);
    pushPreferences.saveString("IronMan", str3);
    pushPreferences.saveString("CaptainM", str1);
    pushPreferences.saveString("SpokesMan", a.a(arrayOfByte1));
    pushPreferences.saveString("Jarvis", WorkKeyCryptUtil.a(a.a(EncryptUtil.a(32)), a));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\opendevice\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */