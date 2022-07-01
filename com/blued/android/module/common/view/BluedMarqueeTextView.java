package com.blued.android.module.common.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

public class BluedMarqueeTextView extends AppCompatTextView {
  public BluedMarqueeTextView(Context paramContext) {
    super(paramContext);
  }
  
  public BluedMarqueeTextView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public BluedMarqueeTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean isFocused() {
    return true;
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect) {
    if (paramBoolean)
      super.onFocusChanged(paramBoolean, paramInt, paramRect); 
  }
  
  public void onWindowFocusChanged(boolean paramBoolean) {
    if (paramBoolean)
      super.onWindowFocusChanged(paramBoolean); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\common\view\BluedMarqueeTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */