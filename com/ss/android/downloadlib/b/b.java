package com.ss.android.downloadlib.b;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.ss.android.a.a.a.g;
import com.ss.android.a.a.a.n;

public class b implements g {
  private n a;
  
  public void a(Activity paramActivity, int paramInt, String[] paramArrayOfString, int[] paramArrayOfint) {
    if (paramArrayOfint.length > 0) {
      n n1 = this.a;
      if (n1 != null) {
        if (paramArrayOfint[0] == -1) {
          n1.a(paramArrayOfString[0]);
          return;
        } 
        if (paramArrayOfint[0] == 0)
          n1.a(); 
      } 
    } 
  }
  
  public void a(Activity paramActivity, String[] paramArrayOfString, n paramn) {
    if (Build.VERSION.SDK_INT >= 23) {
      this.a = paramn;
      paramActivity.requestPermissions(paramArrayOfString, 1);
      return;
    } 
    if (paramn != null)
      paramn.a(); 
  }
  
  public boolean a(Context paramContext, String paramString) {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null) {
      bool1 = bool2;
      if (ContextCompat.checkSelfPermission(paramContext, paramString) == 0)
        bool1 = true; 
    } 
    return bool1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\downloadlib\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */