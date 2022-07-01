package com.alipay.android.phone.mrpc.core;

import android.content.Context;

public final class s {
  private static Boolean a;
  
  public static final boolean a(Context paramContext) {
    Boolean bool2 = a;
    if (bool2 != null)
      return bool2.booleanValue(); 
    try {
      if (((paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 0)).flags & 0x2) != 0) {
        null = true;
        Boolean bool = Boolean.valueOf(null);
        a = bool;
        return bool.booleanValue();
      } 
    } catch (Exception exception) {
      return false;
    } 
    null = false;
    Boolean bool1 = Boolean.valueOf(null);
    a = bool1;
    return bool1.booleanValue();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\android\phone\mrpc\core\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */