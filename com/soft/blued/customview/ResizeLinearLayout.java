package com.soft.blued.customview;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowInsets;
import com.blued.android.core.utils.skin.listener.BluedSkinSupportable;
import com.blued.android.framework.ui.custom.KeyboardListenLinearLayout;
import skin.support.widget.SkinCompatBackgroundHelper;

public class ResizeLinearLayout extends KeyboardListenLinearLayout implements BluedSkinSupportable {
  private int[] a = new int[4];
  
  private SkinCompatBackgroundHelper b = new SkinCompatBackgroundHelper((View)this);
  
  public ResizeLinearLayout(Context paramContext) {
    this(paramContext, null);
  }
  
  public ResizeLinearLayout(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ResizeLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.b.a(paramAttributeSet, 0);
  }
  
  protected final boolean fitSystemWindows(Rect paramRect) {
    if (Build.VERSION.SDK_INT >= 19) {
      this.a[0] = paramRect.left;
      this.a[1] = paramRect.top;
      this.a[2] = paramRect.right;
      paramRect.left = 0;
      paramRect.top = 0;
      paramRect.right = 0;
    } 
    return super.fitSystemWindows(paramRect);
  }
  
  public void g() {
    SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.b;
    if (skinCompatBackgroundHelper != null)
      skinCompatBackgroundHelper.a(); 
  }
  
  public final WindowInsets onApplyWindowInsets(WindowInsets paramWindowInsets) {
    WindowInsets windowInsets = paramWindowInsets;
    if (Build.VERSION.SDK_INT >= 20) {
      this.a[0] = paramWindowInsets.getSystemWindowInsetLeft();
      this.a[1] = paramWindowInsets.getSystemWindowInsetTop();
      this.a[2] = paramWindowInsets.getSystemWindowInsetRight();
      windowInsets = super.onApplyWindowInsets(paramWindowInsets.replaceSystemWindowInsets(0, 0, 0, paramWindowInsets.getSystemWindowInsetBottom()));
    } 
    return windowInsets;
  }
  
  public void setBackgroundResource(int paramInt) {
    super.setBackgroundResource(paramInt);
    SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.b;
    if (skinCompatBackgroundHelper != null)
      skinCompatBackgroundHelper.a(paramInt); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\ResizeLinearLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */