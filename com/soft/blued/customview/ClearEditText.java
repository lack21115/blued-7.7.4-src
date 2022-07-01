package com.soft.blued.customview;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import skin.support.widget.SkinCompatEditText;

public class ClearEditText extends SkinCompatEditText {
  private final String a = ClearEditText.class.getSimpleName();
  
  private Drawable b;
  
  private Rect c;
  
  public ClearEditText(Context paramContext) {
    super(paramContext);
    c();
  }
  
  public ClearEditText(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  public ClearEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  private void c() {
    a();
    addTextChangedListener(new TextWatcher(this) {
          public void afterTextChanged(Editable param1Editable) {}
          
          public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
          
          public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {
            this.a.a();
          }
        });
  }
  
  public void a() {
    if (getText().toString().length() == 0) {
      setCompoundDrawables((Drawable)null, (Drawable)null, (Drawable)null, (Drawable)null);
      return;
    } 
    setCompoundDrawables((Drawable)null, (Drawable)null, this.b, (Drawable)null);
  }
  
  public void b() {
    setCompoundDrawables((Drawable)null, (Drawable)null, (Drawable)null, (Drawable)null);
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    this.b = null;
    this.c = null;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    try {
      if (this.b != null) {
        int i = paramMotionEvent.getAction();
        boolean bool = true;
        if (i == 1) {
          if (paramMotionEvent.getX() <= (getWidth() - getTotalPaddingRight()) || paramMotionEvent.getX() >= (getWidth() - getPaddingRight()))
            bool = false; 
          if (bool) {
            setText("");
            paramMotionEvent.setAction(3);
          } 
        } 
      } 
    } catch (Exception exception) {}
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setCompoundDrawables(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4) {
    if (paramDrawable3 != null)
      this.b = paramDrawable3; 
    super.setCompoundDrawables(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\ClearEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */