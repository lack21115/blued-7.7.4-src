package com.soft.blued.customview.floating_action;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.soft.blued.R;

public class AddFloatingActionButton extends FloatingActionButton {
  int a;
  
  public AddFloatingActionButton(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public AddFloatingActionButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  void a(Context paramContext, AttributeSet paramAttributeSet) {
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.AddFloatingActionButton, 0, 0);
    this.a = typedArray.getColor(0, a(17170443));
    typedArray.recycle();
    super.a(paramContext, paramAttributeSet);
  }
  
  public int getPlusColor() {
    return this.a;
  }
  
  public void setIcon(int paramInt) {
    throw new UnsupportedOperationException("Use FloatingActionButton if you want to use custom icon");
  }
  
  public void setPlusColor(int paramInt) {
    if (this.a != paramInt)
      this.a = paramInt; 
  }
  
  public void setPlusColorResId(int paramInt) {
    setPlusColor(a(paramInt));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\floating_action\AddFloatingActionButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */