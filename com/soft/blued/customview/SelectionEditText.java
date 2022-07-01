package com.soft.blued.customview;

import android.content.Context;
import android.util.AttributeSet;
import skin.support.widget.SkinCompatEditText;

public class SelectionEditText extends SkinCompatEditText {
  private OnSelectionChangeListener a;
  
  public SelectionEditText(Context paramContext) {
    super(paramContext);
  }
  
  public SelectionEditText(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public SelectionEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void onSelectionChanged(int paramInt1, int paramInt2) {
    super.onSelectionChanged(paramInt1, paramInt2);
    OnSelectionChangeListener onSelectionChangeListener = this.a;
    if (onSelectionChangeListener != null)
      onSelectionChangeListener.a(paramInt1, paramInt2); 
  }
  
  public void setOnSelectionChangeListener(OnSelectionChangeListener paramOnSelectionChangeListener) {
    this.a = paramOnSelectionChangeListener;
  }
  
  public static interface OnSelectionChangeListener {
    void a(int param1Int1, int param1Int2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\SelectionEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */