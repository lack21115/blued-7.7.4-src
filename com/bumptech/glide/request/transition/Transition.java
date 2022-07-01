package com.bumptech.glide.request.transition;

import android.graphics.drawable.Drawable;
import android.view.View;

public interface Transition<R> {
  boolean a(R paramR, ViewAdapter paramViewAdapter);
  
  public static interface ViewAdapter {
    Drawable e();
    
    void e(Drawable param1Drawable);
    
    View h();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\request\transition\Transition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */