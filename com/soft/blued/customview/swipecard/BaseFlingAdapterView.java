package com.soft.blued.customview.swipecard;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AdapterView;

abstract class BaseFlingAdapterView extends AdapterView {
  private int a;
  
  private int b;
  
  public BaseFlingAdapterView(Context paramContext) {
    super(paramContext);
  }
  
  public BaseFlingAdapterView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public BaseFlingAdapterView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public int getHeightMeasureSpec() {
    return this.a;
  }
  
  public int getWidthMeasureSpec() {
    return this.b;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
    this.b = paramInt1;
    this.a = paramInt2;
  }
  
  public void setSelection(int paramInt) {
    throw new UnsupportedOperationException("Not supported");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\swipecard\BaseFlingAdapterView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */