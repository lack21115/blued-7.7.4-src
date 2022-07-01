package com.bytedance.sdk.openadsdk.downloadnew.a.a;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.f.a;
import com.bytedance.sdk.openadsdk.utils.h;
import com.ss.android.a.a.a.g;
import com.ss.android.a.a.a.n;
import com.ss.android.downloadlib.e.g;
import java.lang.ref.WeakReference;

public class d implements g {
  private final WeakReference<Context> a;
  
  public d(Context paramContext) {
    this.a = new WeakReference<Context>(paramContext);
  }
  
  public void a(Activity paramActivity, int paramInt, String[] paramArrayOfString, int[] paramArrayOfint) {}
  
  public void a(Activity paramActivity, String[] paramArrayOfString, n paramn) {
    byte b = 0;
    if (paramArrayOfString != null && paramArrayOfString.length > 0) {
      int m = paramArrayOfString.length;
      int k = 0;
      while (true) {
        if (k < m) {
          if ("android.permission.WRITE_EXTERNAL_STORAGE".equalsIgnoreCase(paramArrayOfString[k])) {
            k = 1;
            break;
          } 
          k++;
          continue;
        } 
        k = 0;
        break;
      } 
      if (k != 0) {
        TTCustomController tTCustomController = h.c().d();
        if (tTCustomController != null && paramn != null && !tTCustomController.isCanUseWriteExternal()) {
          paramn.a("android.permission.WRITE_EXTERNAL_STORAGE");
          return;
        } 
      } 
    } 
    if (Build.VERSION.SDK_INT >= 23 && g.a((Context)paramActivity) < 23) {
      if (paramn != null)
        paramn.a(); 
      return;
    } 
    if (paramArrayOfString == null || paramArrayOfString.length <= 0) {
      if (paramn != null)
        paramn.a(); 
      return;
    } 
    long l = hashCode();
    int j = paramArrayOfString.length;
    int i;
    for (i = b; i < j; i++)
      l += paramArrayOfString[i].hashCode(); 
    h.a(String.valueOf(l), paramArrayOfString, new h.a(this, paramn, paramArrayOfString) {
          public void a() {
            n n1 = this.a;
            if (n1 != null)
              n1.a(); 
            a.a().a(true, this.b);
          }
          
          public void a(String param1String) {
            n n1 = this.a;
            if (n1 != null)
              n1.a(param1String); 
            a.a().a(false, new String[] { param1String });
          }
        });
  }
  
  public boolean a(Context paramContext, String paramString) {
    if ("android.permission.WRITE_EXTERNAL_STORAGE".equalsIgnoreCase(paramString)) {
      TTCustomController tTCustomController = h.c().d();
      if (tTCustomController != null && !tTCustomController.isCanUseWriteExternal())
        return false; 
    } 
    Context context = paramContext;
    if (paramContext == null)
      context = o.a(); 
    return com.bytedance.sdk.openadsdk.core.f.d.a().a(context, paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\downloadnew\a\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */