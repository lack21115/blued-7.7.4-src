package com.huawei.hianalytics.ab.cd.bc;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hianalytics.ab.bc.bc.ab;
import com.huawei.hianalytics.ab.bc.cd.ab.ab;
import com.huawei.hianalytics.ab.bc.cd.ab.de;
import com.huawei.hianalytics.ab.cd.ab.ab;

public abstract class bc {
  private ab ab(int paramInt, Context paramContext) {
    String str;
    if (paramInt != 0) {
      String str1 = fg();
      str = str1;
      if (!TextUtils.isEmpty(str1))
        return new ab(com.huawei.hianalytics.ab.cd.ab.bc.bc, str1); 
    } else {
      str = "";
    } 
    if ((paramInt & 0x2) != 0) {
      String str1 = bc(paramContext);
      str = str1;
      if (!TextUtils.isEmpty(str1))
        return new ab(com.huawei.hianalytics.ab.cd.ab.bc.ab, str1); 
    } 
    if ((paramInt & 0x1) != 0) {
      String str1 = cd(paramContext);
      return new ab(com.huawei.hianalytics.ab.cd.ab.bc.cd, str1);
    } 
    return new ab(com.huawei.hianalytics.ab.cd.ab.bc.de, str);
  }
  
  private ab bc(int paramInt, Context paramContext) {
    String str;
    if ((paramInt & 0x4) != 0 && (paramInt & 0x1) != 0)
      return new ab(com.huawei.hianalytics.ab.cd.ab.bc.bc, ab(cd(paramContext))); 
    if ((paramInt & 0x1) != 0) {
      String str1 = cd(paramContext);
      str = str1;
      if (!TextUtils.isEmpty(str1))
        return new ab(com.huawei.hianalytics.ab.cd.ab.bc.cd, str1); 
    } else {
      str = "";
    } 
    if ((paramInt & 0x2) != 0) {
      String str1 = bc(paramContext);
      return new ab(com.huawei.hianalytics.ab.cd.ab.bc.ab, str1);
    } 
    return new ab(com.huawei.hianalytics.ab.cd.ab.bc.de, str);
  }
  
  private String bc(Context paramContext) {
    de de = ab.cd().bc();
    if (TextUtils.isEmpty(de.ik()))
      de.gh(cd.fg(paramContext)); 
    return de.ik();
  }
  
  private String cd(Context paramContext) {
    de de = ab.cd().bc();
    if (TextUtils.isEmpty(de.a()))
      de.kl(cd.hi(paramContext)); 
    return de.a();
  }
  
  private boolean ef() {
    de de = ab.cd().bc();
    if (TextUtils.isEmpty(de.fg()))
      de.de(ab.ab()); 
    return TextUtils.isEmpty(de.fg()) ^ true;
  }
  
  private String fg() {
    de de = ab.cd().bc();
    if (TextUtils.isEmpty(de.b()))
      de.lm(cd.cd()); 
    return de.b();
  }
  
  public ab ab(Context paramContext) {
    String str = cd();
    if (!TextUtils.isEmpty(str))
      return new ab(com.huawei.hianalytics.ab.cd.ab.bc.bc, str); 
    str = ab();
    if (!TextUtils.isEmpty(str))
      return new ab(com.huawei.hianalytics.ab.cd.ab.bc.ab, str); 
    boolean bool = ef();
    str = bc();
    return !TextUtils.isEmpty(str) ? (bool ? new ab(com.huawei.hianalytics.ab.cd.ab.bc.cd, str) : new ab(com.huawei.hianalytics.ab.cd.ab.bc.bc, ab(str))) : (bool ? ab(de(), paramContext) : bc(de(), paramContext));
  }
  
  public abstract String ab();
  
  public abstract String ab(String paramString);
  
  public abstract String bc();
  
  public abstract String cd();
  
  public abstract int de();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hianalytics\ab\cd\bc\bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */