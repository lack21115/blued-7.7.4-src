package com.baidu.mobad.nativevideo;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobads.h.b;

class c implements Runnable {
  c(PatchVideoNative paramPatchVideoNative) {}
  
  public void run() {
    if (PatchVideoNative.b(this.a) != null)
      PatchVideoNative.b(this.a).onAdLoad(PatchVideoNative.c(this.a).getMaterialType()); 
    PatchVideoNative patchVideoNative = this.a;
    PatchVideoNative.a(patchVideoNative, new b(PatchVideoNative.d(patchVideoNative)));
    PatchVideoNative.f(this.a).a(PatchVideoNative.e(this.a));
    PatchVideoNative.g(this.a).addView((View)PatchVideoNative.f(this.a), (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    PatchVideoNative.f(this.a).a(new d(this));
    PatchVideoNative.f(this.a).a((XAdVideoResponse)PatchVideoNative.c(this.a));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobad\nativevideo\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */