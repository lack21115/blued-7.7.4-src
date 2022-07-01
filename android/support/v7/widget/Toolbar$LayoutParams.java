package android.support.v7.widget;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.util.AttributeSet;
import android.view.ViewGroup;

public final class Toolbar$LayoutParams extends ActionBar.LayoutParams {
  int mViewType = 0;
  
  public Toolbar$LayoutParams(int paramInt1, int paramInt2) {
    super(paramInt1, paramInt2);
    this.gravity = 8388627;
  }
  
  public Toolbar$LayoutParams(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public Toolbar$LayoutParams(ActionBar.LayoutParams paramLayoutParams) {
    super(paramLayoutParams);
  }
  
  public Toolbar$LayoutParams(Toolbar$LayoutParams paramToolbar$LayoutParams) {
    super(paramToolbar$LayoutParams);
    this.mViewType = paramToolbar$LayoutParams.mViewType;
  }
  
  public Toolbar$LayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    super(paramLayoutParams);
  }
  
  public Toolbar$LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams) {
    super((ViewGroup.LayoutParams)paramMarginLayoutParams);
    this.leftMargin = paramMarginLayoutParams.leftMargin;
    this.topMargin = paramMarginLayoutParams.topMargin;
    this.rightMargin = paramMarginLayoutParams.rightMargin;
    this.bottomMargin = paramMarginLayoutParams.bottomMargin;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\Toolbar$LayoutParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */