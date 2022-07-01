package com.bumptech.glide.util;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.bumptech.glide.ListPreloader;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.transition.Transition;
import java.util.Arrays;

public class ViewPreloadSizeProvider<T> implements ListPreloader.PreloadSizeProvider<T>, SizeReadyCallback {
  private int[] a;
  
  private SizeViewTarget b;
  
  public void a(int paramInt1, int paramInt2) {
    this.a = new int[] { paramInt1, paramInt2 };
    this.b = null;
  }
  
  public int[] a(T paramT, int paramInt1, int paramInt2) {
    int[] arrayOfInt = this.a;
    return (arrayOfInt == null) ? null : Arrays.copyOf(arrayOfInt, arrayOfInt.length);
  }
  
  static final class SizeViewTarget extends CustomViewTarget<View, Object> {
    public void a(Object param1Object, Transition<? super Object> param1Transition) {}
    
    public void b(Drawable param1Drawable) {}
    
    public void d(Drawable param1Drawable) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glid\\util\ViewPreloadSizeProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */