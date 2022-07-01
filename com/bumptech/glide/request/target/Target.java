package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.transition.Transition;

public interface Target<R> extends LifecycleListener {
  Request a();
  
  void a(Drawable paramDrawable);
  
  void a(Request paramRequest);
  
  void a(SizeReadyCallback paramSizeReadyCallback);
  
  void a(R paramR, Transition<? super R> paramTransition);
  
  void b(Drawable paramDrawable);
  
  void b(SizeReadyCallback paramSizeReadyCallback);
  
  void c(Drawable paramDrawable);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\request\target\Target.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */