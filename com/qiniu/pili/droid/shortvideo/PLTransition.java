package com.qiniu.pili.droid.shortvideo;

import android.animation.Animator;
import android.view.View;

public abstract class PLTransition {
  protected long a;
  
  protected long b;
  
  public PLTransition(long paramLong1, long paramLong2) {
    this.b = paramLong1;
    this.a = paramLong2;
  }
  
  public long a() {
    return this.b + this.a;
  }
  
  public abstract Animator a(View paramView);
  
  public long b() {
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\PLTransition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */