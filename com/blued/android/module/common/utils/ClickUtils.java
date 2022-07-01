package com.blued.android.module.common.utils;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import com.blued.android.module.common.R;
import com.blued.android.module.common.observer.CommonTitleDoubleClickObserver;

public class ClickUtils implements View.OnTouchListener {
  private int a = 0;
  
  private int b = 0;
  
  private int c = 0;
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
    int i = paramMotionEvent.getAction();
    if (i != 0) {
      if (i != 1)
        return true; 
      paramView.performClick();
      return true;
    } 
    i = ++this.a;
    if (i == 1) {
      this.b = (int)System.currentTimeMillis();
      return true;
    } 
    if (i == 2) {
      this.c = (int)System.currentTimeMillis();
      if (this.c - this.b < 1000)
        CommonTitleDoubleClickObserver.a().b(); 
      this.a = 0;
      this.b = 0;
      this.c = 0;
    } 
    return true;
  }
  
  public static class RevoClickSpan extends ClickableSpan {
    Context a;
    
    View.OnClickListener b;
    
    public RevoClickSpan(Context param1Context, View.OnClickListener param1OnClickListener) {
      this.a = param1Context;
      this.b = param1OnClickListener;
    }
    
    public void onClick(View param1View) {
      View.OnClickListener onClickListener = this.b;
      if (onClickListener != null)
        onClickListener.onClick(param1View); 
    }
    
    public void updateDrawState(TextPaint param1TextPaint) {
      param1TextPaint.setColor(this.a.getResources().getColor(R.color.nafio_a));
      param1TextPaint.setUnderlineText(false);
    }
  }
  
  public static class RevoWhiteClickSpan extends RevoClickSpan {
    public RevoWhiteClickSpan(Context param1Context, View.OnClickListener param1OnClickListener) {
      super(param1Context, param1OnClickListener);
    }
    
    public void updateDrawState(TextPaint param1TextPaint) {
      param1TextPaint.setColor(this.a.getResources().getColor(R.color.nafio_b));
      param1TextPaint.setUnderlineText(true);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\commo\\utils\ClickUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */