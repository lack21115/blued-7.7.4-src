package com.huawei.hianalytics.ab.cd.bc;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.hianalytics.ab.ab.bc;
import com.huawei.hianalytics.ab.bc.bc.bc;
import com.huawei.secure.android.common.encrypt.hash.SHA;
import java.util.UUID;

public class ab {
  private static ab bc;
  
  private Context ab;
  
  public static ab ab() {
    // Byte code:
    //   0: ldc com/huawei/hianalytics/ab/cd/bc/ab
    //   2: monitorenter
    //   3: getstatic com/huawei/hianalytics/ab/cd/bc/ab.bc : Lcom/huawei/hianalytics/ab/cd/bc/ab;
    //   6: ifnonnull -> 19
    //   9: new com/huawei/hianalytics/ab/cd/bc/ab
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/huawei/hianalytics/ab/cd/bc/ab.bc : Lcom/huawei/hianalytics/ab/cd/bc/ab;
    //   19: getstatic com/huawei/hianalytics/ab/cd/bc/ab.bc : Lcom/huawei/hianalytics/ab/cd/bc/ab;
    //   22: astore_0
    //   23: ldc com/huawei/hianalytics/ab/cd/bc/ab
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: astore_0
    //   29: ldc com/huawei/hianalytics/ab/cd/bc/ab
    //   31: monitorexit
    //   32: aload_0
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	28	finally
    //   19	26	28	finally
    //   29	32	28	finally
  }
  
  public String ab(String paramString1, String paramString2) {
    return bc.ab(this.ab, paramString1, paramString2);
  }
  
  public String ab(boolean paramBoolean) {
    if (!paramBoolean)
      return ""; 
    String str2 = bc.ik();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str2 = com.huawei.hianalytics.ab.bc.ij.ab.ab(this.ab, "global_v2", "uuid", "");
      str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = UUID.randomUUID().toString().replace("-", "");
        com.huawei.hianalytics.ab.bc.ij.ab.bc(this.ab, "global_v2", "uuid", str1);
      } 
      bc.cd(str1);
    } 
    return str1;
  }
  
  public void ab(Context paramContext) {
    if (this.ab == null)
      this.ab = paramContext; 
  }
  
  public String bc(String paramString1, String paramString2) {
    return bc.bc(this.ab, paramString1, paramString2);
  }
  
  public com.huawei.hianalytics.ab.cd.ab.ab cd(String paramString1, String paramString2) {
    return (new ab(paramString1, paramString2)).ab(this.ab);
  }
  
  public String de(String paramString1, String paramString2) {
    return de.bc(paramString1, paramString2);
  }
  
  public Pair<String, String> ef(String paramString1, String paramString2) {
    if (com.huawei.hianalytics.ab.ab.ab.fg(paramString1, paramString2)) {
      Pair<String, String> pair;
      paramString1 = com.huawei.hianalytics.ab.bc.cd.ab.ab.cd().bc().kl();
      paramString2 = com.huawei.hianalytics.ab.bc.cd.ab.ab.cd().bc().lm();
      if (TextUtils.isEmpty(paramString1) || TextUtils.isEmpty(paramString2)) {
        pair = cd.ef(this.ab);
        com.huawei.hianalytics.ab.bc.cd.ab.ab.cd().bc().hi((String)pair.first);
        com.huawei.hianalytics.ab.bc.cd.ab.ab.cd().bc().ij((String)pair.second);
        return pair;
      } 
      return new Pair(pair, paramString2);
    } 
    return new Pair("", "");
  }
  
  public String fg(String paramString1, String paramString2) {
    return de.ab(paramString1, paramString2);
  }
  
  static class ab extends bc {
    String ab;
    
    String bc;
    
    public ab(String param1String1, String param1String2) {
      this.ab = param1String1;
      this.bc = param1String2;
    }
    
    public String ab() {
      return com.huawei.hianalytics.ab.ab.ab.de(this.ab, this.bc);
    }
    
    public String ab(String param1String) {
      return SHA.a(param1String);
    }
    
    public String bc() {
      return com.huawei.hianalytics.ab.ab.ab.gh(this.ab, this.bc);
    }
    
    public String cd() {
      return com.huawei.hianalytics.ab.ab.ab.ik(this.ab, this.bc);
    }
    
    public int de() {
      boolean bool;
      boolean bool1 = com.huawei.hianalytics.ab.ab.ab.kl(this.ab, this.bc);
      byte b = 0;
      if (bool1) {
        bool = true;
      } else {
        bool = false;
      } 
      if (com.huawei.hianalytics.ab.ab.ab.ef(this.ab, this.bc))
        b = 2; 
      return bool | false | b | com.huawei.hianalytics.ab.ab.ab.hi(this.ab, this.bc);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hianalytics\ab\cd\bc\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */