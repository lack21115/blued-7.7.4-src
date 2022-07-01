package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.WindowInsets;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;

public class BluedLinearLayout extends KeyboardListenLinearLayout {
  public BluedLinearLayout(Context paramContext) {
    super(paramContext);
  }
  
  public BluedLinearLayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public BluedLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected boolean fitSystemWindows(Rect paramRect) {
    if (Build.VERSION.SDK_INT >= 19) {
      paramRect.left = 0;
      paramRect.top = 0;
      paramRect.right = 0;
    } 
    return super.fitSystemWindows(paramRect);
  }
  
  public WindowInsets onApplyWindowInsets(WindowInsets paramWindowInsets) {
    WindowInsets windowInsets = paramWindowInsets;
    if (Build.VERSION.SDK_INT >= 19)
      windowInsets = super.onApplyWindowInsets(paramWindowInsets.replaceSystemWindowInsets(0, 0, 0, paramWindowInsets.getSystemWindowInsetBottom())); 
    return windowInsets;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\view\BluedLinearLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */