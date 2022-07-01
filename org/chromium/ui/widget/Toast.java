package org.chromium.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import org.chromium.base.SysUtils;

public final class Toast {
  private ViewGroup mSWLayout;
  
  public android.widget.Toast mToast;
  
  private Toast(Context paramContext, android.widget.Toast paramToast) {
    this.mToast = paramToast;
    if (SysUtils.isLowEndDevice() && Build.VERSION.SDK_INT >= 21) {
      this.mSWLayout = (ViewGroup)new FrameLayout((Context)new Toast$1(paramContext));
      View view = paramToast.getView();
      if (this.mSWLayout != null) {
        this.mSWLayout.removeAllViews();
        if (view != null) {
          this.mSWLayout.addView(view, -2, -2);
          this.mToast.setView((View)this.mSWLayout);
          return;
        } 
        this.mToast.setView(null);
        return;
      } 
      this.mToast.setView(view);
    } 
  }
  
  @SuppressLint({"ShowToast"})
  public static Toast makeText(Context paramContext, CharSequence paramCharSequence, int paramInt) {
    UiWidgetFactory.getInstance();
    return new Toast(paramContext, android.widget.Toast.makeText(paramContext, paramCharSequence, paramInt));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\widget\Toast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */