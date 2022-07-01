package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.material.R;

public class Snackbar extends BaseTransientBottomBar<Snackbar> {
  private static final int[] d = new int[] { R.attr.snackbarButtonStyle };
  
  private static final int[] e = new int[] { R.attr.snackbarButtonStyle, R.attr.snackbarTextViewStyle };
  
  public void a() {
    super.a();
  }
  
  public static class Callback extends BaseTransientBottomBar.BaseCallback<Snackbar> {
    public void a(Snackbar param1Snackbar) {}
    
    public void a(Snackbar param1Snackbar, int param1Int) {}
  }
  
  public static final class SnackbarLayout extends BaseTransientBottomBar.SnackbarBaseLayout {
    public SnackbarLayout(Context param1Context) {
      super(param1Context);
    }
    
    public SnackbarLayout(Context param1Context, AttributeSet param1AttributeSet) {
      super(param1Context, param1AttributeSet);
    }
    
    protected void onMeasure(int param1Int1, int param1Int2) {
      super.onMeasure(param1Int1, param1Int2);
      param1Int2 = getChildCount();
      int i = getMeasuredWidth();
      int j = getPaddingLeft();
      int k = getPaddingRight();
      for (param1Int1 = 0; param1Int1 < param1Int2; param1Int1++) {
        View view = getChildAt(param1Int1);
        if ((view.getLayoutParams()).width == -1)
          view.measure(View.MeasureSpec.makeMeasureSpec(i - j - k, 1073741824), View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 1073741824)); 
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\snackbar\Snackbar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */