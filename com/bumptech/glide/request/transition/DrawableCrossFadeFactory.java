package com.bumptech.glide.request.transition;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;

public class DrawableCrossFadeFactory implements TransitionFactory<Drawable> {
  private final int a;
  
  private final boolean b;
  
  private DrawableCrossFadeTransition c;
  
  protected DrawableCrossFadeFactory(int paramInt, boolean paramBoolean) {
    this.a = paramInt;
    this.b = paramBoolean;
  }
  
  private Transition<Drawable> a() {
    if (this.c == null)
      this.c = new DrawableCrossFadeTransition(this.a, this.b); 
    return this.c;
  }
  
  public Transition<Drawable> a(DataSource paramDataSource, boolean paramBoolean) {
    return (paramDataSource == DataSource.e) ? NoTransition.b() : a();
  }
  
  public static class Builder {
    private final int a;
    
    private boolean b;
    
    public Builder() {
      this(300);
    }
    
    public Builder(int param1Int) {
      this.a = param1Int;
    }
    
    public Builder a(boolean param1Boolean) {
      this.b = param1Boolean;
      return this;
    }
    
    public DrawableCrossFadeFactory a() {
      return new DrawableCrossFadeFactory(this.a, this.b);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\request\transition\DrawableCrossFadeFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */