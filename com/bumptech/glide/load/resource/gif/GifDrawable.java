package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.util.Preconditions;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class GifDrawable extends Drawable implements Animatable, Animatable2Compat, GifFrameLoader.FrameCallback {
  private final GifState a;
  
  private boolean b;
  
  private boolean c;
  
  private boolean d;
  
  private boolean e = true;
  
  private int f;
  
  private int g = -1;
  
  private boolean h;
  
  private Paint i;
  
  private Rect j;
  
  private List<Animatable2Compat.AnimationCallback> k;
  
  public GifDrawable(Context paramContext, GifDecoder paramGifDecoder, Transformation<Bitmap> paramTransformation, int paramInt1, int paramInt2, Bitmap paramBitmap) {
    this(new GifState(new GifFrameLoader(Glide.a(paramContext), paramGifDecoder, paramInt1, paramInt2, paramTransformation, paramBitmap)));
  }
  
  GifDrawable(GifState paramGifState) {
    this.a = (GifState)Preconditions.a(paramGifState);
  }
  
  private void h() {
    this.f = 0;
  }
  
  private void i() {
    Preconditions.a(this.d ^ true, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
    if (this.a.a.g() == 1) {
      invalidateSelf();
      return;
    } 
    if (!this.b) {
      this.b = true;
      this.a.a.a(this);
      invalidateSelf();
    } 
  }
  
  private void j() {
    this.b = false;
    this.a.a.b(this);
  }
  
  private Rect k() {
    if (this.j == null)
      this.j = new Rect(); 
    return this.j;
  }
  
  private Paint l() {
    if (this.i == null)
      this.i = new Paint(2); 
    return this.i;
  }
  
  private Drawable.Callback m() {
    Drawable.Callback callback;
    for (callback = getCallback(); callback instanceof Drawable; callback = ((Drawable)callback).getCallback());
    return callback;
  }
  
  private void n() {
    List<Animatable2Compat.AnimationCallback> list = this.k;
    if (list != null) {
      int i = 0;
      int j = list.size();
      while (i < j) {
        ((Animatable2Compat.AnimationCallback)this.k.get(i)).onAnimationEnd(this);
        i++;
      } 
    } 
  }
  
  public int a() {
    return this.a.a.d();
  }
  
  public void a(int paramInt) {
    if (paramInt > 0 || paramInt == -1 || paramInt == 0) {
      if (paramInt == 0) {
        int i = this.a.a.h();
        paramInt = i;
        if (i == 0)
          paramInt = -1; 
        this.g = paramInt;
        return;
      } 
      this.g = paramInt;
      return;
    } 
    throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
  }
  
  public void a(Transformation<Bitmap> paramTransformation, Bitmap paramBitmap) {
    this.a.a.a(paramTransformation, paramBitmap);
  }
  
  public Bitmap b() {
    return this.a.a.a();
  }
  
  public ByteBuffer c() {
    return this.a.a.f();
  }
  
  public void clearAnimationCallbacks() {
    List<Animatable2Compat.AnimationCallback> list = this.k;
    if (list != null)
      list.clear(); 
  }
  
  public int d() {
    return this.a.a.g();
  }
  
  public void draw(Canvas paramCanvas) {
    if (this.d)
      return; 
    if (this.h) {
      Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), k());
      this.h = false;
    } 
    paramCanvas.drawBitmap(this.a.a.j(), null, k(), l());
  }
  
  public int e() {
    return this.a.a.e();
  }
  
  public void f() {
    if (m() == null) {
      stop();
      invalidateSelf();
      return;
    } 
    invalidateSelf();
    if (e() == d() - 1)
      this.f++; 
    int i = this.g;
    if (i != -1 && this.f >= i) {
      n();
      stop();
    } 
  }
  
  public void g() {
    this.d = true;
    this.a.a.i();
  }
  
  public Drawable.ConstantState getConstantState() {
    return this.a;
  }
  
  public int getIntrinsicHeight() {
    return this.a.a.c();
  }
  
  public int getIntrinsicWidth() {
    return this.a.a.b();
  }
  
  public int getOpacity() {
    return -2;
  }
  
  public boolean isRunning() {
    return this.b;
  }
  
  protected void onBoundsChange(Rect paramRect) {
    super.onBoundsChange(paramRect);
    this.h = true;
  }
  
  public void registerAnimationCallback(Animatable2Compat.AnimationCallback paramAnimationCallback) {
    if (paramAnimationCallback == null)
      return; 
    if (this.k == null)
      this.k = new ArrayList<Animatable2Compat.AnimationCallback>(); 
    this.k.add(paramAnimationCallback);
  }
  
  public void setAlpha(int paramInt) {
    l().setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {
    l().setColorFilter(paramColorFilter);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2) {
    Preconditions.a(this.d ^ true, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
    this.e = paramBoolean1;
    if (!paramBoolean1) {
      j();
    } else if (this.c) {
      i();
    } 
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public void start() {
    this.c = true;
    h();
    if (this.e)
      i(); 
  }
  
  public void stop() {
    this.c = false;
    j();
  }
  
  public boolean unregisterAnimationCallback(Animatable2Compat.AnimationCallback paramAnimationCallback) {
    List<Animatable2Compat.AnimationCallback> list = this.k;
    return (list == null || paramAnimationCallback == null) ? false : list.remove(paramAnimationCallback);
  }
  
  static final class GifState extends Drawable.ConstantState {
    final GifFrameLoader a;
    
    GifState(GifFrameLoader param1GifFrameLoader) {
      this.a = param1GifFrameLoader;
    }
    
    public int getChangingConfigurations() {
      return 0;
    }
    
    public Drawable newDrawable() {
      return new GifDrawable(this);
    }
    
    public Drawable newDrawable(Resources param1Resources) {
      return newDrawable();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\gif\GifDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */