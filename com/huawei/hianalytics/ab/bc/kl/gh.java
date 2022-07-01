package com.huawei.hianalytics.ab.bc.kl;

import android.content.Context;
import android.os.Build;
import android.os.UserManager;
import com.huawei.hianalytics.ab.ab.bc;

public class gh {
  private static gh cd = new gh();
  
  private boolean ab = false;
  
  private Context bc = bc.fg();
  
  public static gh bc() {
    return cd;
  }
  
  public boolean ab() {
    if (!this.ab) {
      boolean bool;
      Context context = this.bc;
      if (context == null)
        return false; 
      if (Build.VERSION.SDK_INT >= 24) {
        UserManager userManager = (UserManager)context.getSystemService("user");
        if (userManager != null) {
          bool = userManager.isUserUnlocked();
        } else {
          this.ab = false;
          return this.ab;
        } 
      } else {
        bool = true;
      } 
      this.ab = bool;
    } 
    return this.ab;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hianalytics\ab\bc\kl\gh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */