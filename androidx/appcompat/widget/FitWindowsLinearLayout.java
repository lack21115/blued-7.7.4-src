package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class FitWindowsLinearLayout extends LinearLayout implements FitWindowsViewGroup {
  private FitWindowsViewGroup.OnFitSystemWindowsListener a;
  
  public FitWindowsLinearLayout(Context paramContext) {
    super(paramContext);
  }
  
  public FitWindowsLinearLayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  protected boolean fitSystemWindows(Rect paramRect) {
    FitWindowsViewGroup.OnFitSystemWindowsListener onFitSystemWindowsListener = this.a;
    if (onFitSystemWindowsListener != null)
      onFitSystemWindowsListener.onFitSystemWindows(paramRect); 
    return super.fitSystemWindows(paramRect);
  }
  
  public void setOnFitSystemWindowsListener(FitWindowsViewGroup.OnFitSystemWindowsListener paramOnFitSystemWindowsListener) {
    this.a = paramOnFitSystemWindowsListener;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\widget\FitWindowsLinearLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */