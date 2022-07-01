package com.huawei.hianalytics.ab.bc.de;

import android.text.TextUtils;
import com.huawei.hianalytics.ab.ab.bc;
import com.huawei.hianalytics.ab.bc.ab.bc;
import com.huawei.hianalytics.ab.bc.kl.de;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public class fg {
  private static fg bc = new fg();
  
  private ab ab = new ab(this);
  
  public static fg ef() {
    return bc;
  }
  
  private String fg() {
    InputStream inputStream = null;
    try {
      null = bc.fg().getResources().getAssets().open("hianalytics_njjn");
      inputStream = null;
    } catch (IOException iOException) {
    
    } finally {
      de.ab((Closeable)iOException);
    } 
    Object object = SYNTHETIC_LOCAL_VARIABLE_2;
    com.huawei.hianalytics.ab.bc.ef.ab.fg("hmsSdk", "read pubKey error,the file is corrupted");
    de.ab((Closeable)SYNTHETIC_LOCAL_VARIABLE_2);
    return null;
  }
  
  public String ab() {
    return this.ab.cd;
  }
  
  public long bc() {
    return this.ab.de;
  }
  
  public String cd() {
    return this.ab.bc;
  }
  
  public void de() {
    long l1 = bc();
    if (l1 == 0L) {
      l1 = System.currentTimeMillis();
      String str1 = fg();
      if (TextUtils.isEmpty(str1)) {
        com.huawei.hianalytics.ab.bc.ef.ab.fg("hmsSdk", "get rsa pubkey config error");
        return;
      } 
      String str2 = EncryptUtil.b(16);
      String str3 = bc.ab(str1, str2);
      this.ab.bc(str1);
      this.ab.ab(l1);
      this.ab.cd(str2);
      this.ab.ab(str3);
      return;
    } 
    long l2 = System.currentTimeMillis();
    if (l2 - l1 > 43200000L) {
      String str2 = this.ab.ab;
      String str1 = EncryptUtil.b(16);
      str2 = bc.ab(str2, str1);
      this.ab.ab(l2);
      this.ab.cd(str1);
      this.ab.ab(str2);
    } 
  }
  
  class ab {
    String ab;
    
    String bc;
    
    String cd;
    
    long de = 0L;
    
    ab(fg this$0) {}
    
    void ab(long param1Long) {
      (fg.ab(this.ef)).de = param1Long;
    }
    
    void ab(String param1String) {
      (fg.ab(this.ef)).cd = param1String;
    }
    
    void bc(String param1String) {
      (fg.ab(this.ef)).ab = param1String;
    }
    
    void cd(String param1String) {
      (fg.ab(this.ef)).bc = param1String;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hianalytics\ab\bc\de\fg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */