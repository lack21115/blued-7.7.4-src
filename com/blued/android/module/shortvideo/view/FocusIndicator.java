package com.blued.android.module.shortvideo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.blued.android.module.shortvideo.R;

public class FocusIndicator extends View {
  private int a;
  
  private Runnable b = new Disappear();
  
  private Runnable c = new EndAction();
  
  public FocusIndicator(Context paramContext) {
    super(paramContext);
  }
  
  public FocusIndicator(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public FocusIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a() {
    if (this.a == 0) {
      setBackgroundResource(R.drawable.ic_focus_focusing);
      animate().withLayer().setDuration(800L).scaleX(1.5F).scaleY(1.5F);
      this.a = 1;
    } 
  }
  
  public void b() {
    if (this.a == 1) {
      setBackgroundResource(R.drawable.ic_focus_focused);
      animate().withLayer().setDuration(200L).scaleX(1.0F).scaleY(1.0F).withEndAction(this.c);
      this.a = 2;
    } 
  }
  
  public void c() {
    if (this.a == 1) {
      setBackgroundResource(R.drawable.ic_focus_failed);
      animate().withLayer().setDuration(200L).scaleX(1.0F).scaleY(1.0F).withEndAction(this.c);
      this.a = 2;
    } 
  }
  
  public void d() {
    animate().cancel();
    removeCallbacks(this.b);
    this.b.run();
    setScaleX(1.0F);
    setScaleY(1.0F);
  }
  
  class Disappear implements Runnable {
    private Disappear(FocusIndicator this$0) {}
    
    public void run() {
      this.a.setBackgroundDrawable(null);
      FocusIndicator.a(this.a, 0);
    }
  }
  
  class EndAction implements Runnable {
    private EndAction(FocusIndicator this$0) {}
    
    public void run() {
      FocusIndicator focusIndicator = this.a;
      focusIndicator.postDelayed(FocusIndicator.a(focusIndicator), 200L);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\view\FocusIndicator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */