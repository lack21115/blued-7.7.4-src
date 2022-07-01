package com.huawei.hianalytics.ab.bc.gh;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.hianalytics.ab.bc.ab.ab;
import com.huawei.hianalytics.ab.bc.ef.ab;
import com.huawei.hianalytics.ab.bc.ij.ab;
import com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;

public class bc {
  private static bc cd;
  
  private String ab;
  
  private String bc;
  
  private String ab(String paramString) {
    String str2;
    if (fg()) {
      str2 = AesGcmKS.b("analytics_keystore", paramString);
    } else {
      str2 = "";
    } 
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      ab.cd("hmsSdk", "deCrypt work key first");
      paramString = ab.ab(paramString, ef());
      if (TextUtils.isEmpty(paramString)) {
        paramString = EncryptUtil.b(16);
        cd(bc(paramString));
        str1 = paramString;
        if (fg()) {
          ab.cd();
          return paramString;
        } 
      } else {
        str1 = paramString;
        if (fg()) {
          cd(bc(paramString));
          ab.cd();
          return paramString;
        } 
      } 
    } 
    return str1;
  }
  
  private String bc(String paramString) {
    return fg() ? AesGcmKS.a("analytics_keystore", paramString) : ab.bc(paramString, ef());
  }
  
  private String cd() {
    String str = ab.ab(com.huawei.hianalytics.ab.ab.bc.fg(), "Privacy_MY", "PrivacyData", "");
    if (TextUtils.isEmpty(str)) {
      str = EncryptUtil.b(16);
      cd(bc(str));
      return str;
    } 
    return ab(str);
  }
  
  private boolean cd(String paramString) {
    ab.cd("hmsSdk", "refresh sp aes key");
    if (TextUtils.isEmpty(paramString)) {
      ab.cd("hmsSdk", "refreshLocalKey(): encrypted key is empty");
      return false;
    } 
    ab.bc(com.huawei.hianalytics.ab.ab.bc.fg(), "Privacy_MY", "PrivacyData", paramString);
    ab.bc(com.huawei.hianalytics.ab.ab.bc.fg(), "Privacy_MY", "flashKeyTime", System.currentTimeMillis());
    return true;
  }
  
  public static bc de() {
    if (cd == null)
      gh(); 
    return cd;
  }
  
  private String ef() {
    if (TextUtils.isEmpty(this.bc))
      this.bc = (new ab()).ab(); 
    return this.bc;
  }
  
  private boolean fg() {
    return (Build.VERSION.SDK_INT >= 23);
  }
  
  private static void gh() {
    // Byte code:
    //   0: ldc com/huawei/hianalytics/ab/bc/gh/bc
    //   2: monitorenter
    //   3: getstatic com/huawei/hianalytics/ab/bc/gh/bc.cd : Lcom/huawei/hianalytics/ab/bc/gh/bc;
    //   6: ifnonnull -> 19
    //   9: new com/huawei/hianalytics/ab/bc/gh/bc
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/huawei/hianalytics/ab/bc/gh/bc.cd : Lcom/huawei/hianalytics/ab/bc/gh/bc;
    //   19: ldc com/huawei/hianalytics/ab/bc/gh/bc
    //   21: monitorexit
    //   22: return
    //   23: astore_0
    //   24: ldc com/huawei/hianalytics/ab/bc/gh/bc
    //   26: monitorexit
    //   27: aload_0
    //   28: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	23	finally
  }
  
  public String ab() {
    if (TextUtils.isEmpty(this.ab))
      this.ab = cd(); 
    return this.ab;
  }
  
  public void bc() {
    String str = EncryptUtil.b(16);
    if (cd(bc(str)))
      this.ab = str; 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hianalytics\ab\bc\gh\bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */