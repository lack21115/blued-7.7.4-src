package com.blued.android.core.image.apng;

import android.graphics.drawable.Drawable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.apng.drawable.APNGDrawable;
import com.blued.android.core.utils.Log;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

public class AnimationRequestListener implements RequestListener {
  private int a;
  
  private ImageLoader.OnAnimationStateListener b;
  
  public AnimationRequestListener(int paramInt, ImageLoader.OnAnimationStateListener paramOnAnimationStateListener) {
    this.a = paramInt;
    this.b = paramOnAnimationStateListener;
  }
  
  public boolean a(GlideException paramGlideException, Object paramObject, Target paramTarget, boolean paramBoolean) {
    if (ImageLoader.a())
      Log.e("IMAGE", "animation : onLoadFailed"); 
    return false;
  }
  
  public boolean a(Object paramObject1, Object paramObject2, Target paramTarget, DataSource paramDataSource, boolean paramBoolean) {
    if (ImageLoader.a())
      Log.e("IMAGE", "animation : onResourceReady"); 
    if (paramObject1 != null)
      if (paramObject1 instanceof APNGDrawable) {
        paramObject1 = paramObject1;
        paramObject1.a(this.a);
        if (ImageLoader.a()) {
          paramObject2 = new StringBuilder();
          paramObject2.append("animation : APNG @");
          paramObject2.append(paramObject1);
          Log.e("IMAGE", paramObject2.toString());
        } 
        if (this.b != null) {
          if (ImageLoader.a()) {
            paramObject2 = new StringBuilder();
            paramObject2.append("apng : onAnimationStart @");
            paramObject2.append(paramObject1);
            Log.e("IMAGE", paramObject2.toString());
          } 
          this.b.a();
          paramObject1.registerAnimationCallback(new Animatable2Compat.AnimationCallback(this, (APNGDrawable)paramObject1) {
                public void onAnimationEnd(Drawable param1Drawable) {
                  if (ImageLoader.a()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("apng : onAnimationEnd @");
                    stringBuilder.append(param1Drawable);
                    Log.e("IMAGE", stringBuilder.toString());
                  } 
                  this.b.unregisterAnimationCallback(this);
                  if (AnimationRequestListener.a(this.c) != null)
                    AnimationRequestListener.a(this.c).b(); 
                }
                
                public void onAnimationStart(Drawable param1Drawable) {}
              });
        } 
      } else if (paramObject1 instanceof GifDrawable) {
        paramObject1 = paramObject1;
        paramObject1.a(this.a);
        if (ImageLoader.a()) {
          paramObject2 = new StringBuilder();
          paramObject2.append("animation : GIF @");
          paramObject2.append(paramObject1);
          Log.e("IMAGE", paramObject2.toString());
        } 
        if (this.b != null) {
          if (ImageLoader.a()) {
            paramObject2 = new StringBuilder();
            paramObject2.append("gif : onAnimationStart @");
            paramObject2.append(paramObject1);
            Log.e("IMAGE", paramObject2.toString());
          } 
          this.b.a();
          paramObject1.registerAnimationCallback(new Animatable2Compat.AnimationCallback(this, (GifDrawable)paramObject1) {
                public void onAnimationEnd(Drawable param1Drawable) {
                  if (ImageLoader.a()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("gif : onAnimationEnd @");
                    stringBuilder.append(param1Drawable);
                    Log.e("IMAGE", stringBuilder.toString());
                  } 
                  this.b.unregisterAnimationCallback(this);
                  if (AnimationRequestListener.a(this.c) != null)
                    AnimationRequestListener.a(this.c).b(); 
                }
              });
        } 
      }  
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\image\apng\AnimationRequestListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */