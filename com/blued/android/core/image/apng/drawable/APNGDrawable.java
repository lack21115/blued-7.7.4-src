package com.blued.android.core.image.apng.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DrawFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.GlideApp;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.apng.decode.APNGDecoder;
import com.blued.android.core.image.apng.decode.FrameSeqDecoder;
import com.blued.android.core.image.apng.loader.ByteBufferLoader;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class APNGDrawable extends Drawable implements Animatable2Compat, FrameSeqDecoder.RenderListener {
  private final Paint a = new Paint();
  
  private APNGDecoder b;
  
  private DrawFilter c = (DrawFilter)new PaintFlagsDrawFilter(0, 3);
  
  private Matrix d = new Matrix();
  
  private ConcurrentHashMap<Animatable2Compat.AnimationCallback, Animatable2Compat.AnimationCallback> e = new ConcurrentHashMap<Animatable2Compat.AnimationCallback, Animatable2Compat.AnimationCallback>();
  
  private Bitmap f;
  
  private BitmapPool g;
  
  private Object h = new Object();
  
  private int i = 1;
  
  private Runnable j = new Runnable(this) {
      public void run() {
        this.a.invalidateSelf();
      }
    };
  
  public APNGDrawable(ByteBufferLoader paramByteBufferLoader) {
    this.a.setAntiAlias(true);
    this.b = new APNGDecoder(paramByteBufferLoader, this);
    this.b.a(this.i);
    this.g = GlideApp.a(AppInfo.d()).a();
  }
  
  public void a() {
    AppInfo.n().post(new Runnable(this) {
          public void run() {
            Iterator<Animatable2Compat.AnimationCallback> iterator = APNGDrawable.a(this.a).values().iterator();
            while (iterator.hasNext())
              ((Animatable2Compat.AnimationCallback)iterator.next()).onAnimationStart(this.a); 
          }
        });
  }
  
  public void a(int paramInt) {
    this.i = paramInt;
    this.b.a(paramInt);
  }
  
  public void a(ByteBuffer paramByteBuffer) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual isRunning : ()Z
    //   4: ifne -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield h : Ljava/lang/Object;
    //   12: astore_2
    //   13: aload_2
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield f : Landroid/graphics/Bitmap;
    //   19: ifnull -> 32
    //   22: aload_0
    //   23: getfield f : Landroid/graphics/Bitmap;
    //   26: invokevirtual isRecycled : ()Z
    //   29: ifeq -> 84
    //   32: aload_0
    //   33: aload_0
    //   34: getfield g : Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;
    //   37: aload_0
    //   38: getfield b : Lcom/blued/android/core/image/apng/decode/APNGDecoder;
    //   41: invokevirtual e : ()Landroid/graphics/Rect;
    //   44: invokevirtual width : ()I
    //   47: aload_0
    //   48: getfield b : Lcom/blued/android/core/image/apng/decode/APNGDecoder;
    //   51: invokevirtual k : ()I
    //   54: idiv
    //   55: aload_0
    //   56: getfield b : Lcom/blued/android/core/image/apng/decode/APNGDecoder;
    //   59: invokevirtual e : ()Landroid/graphics/Rect;
    //   62: invokevirtual height : ()I
    //   65: aload_0
    //   66: getfield b : Lcom/blued/android/core/image/apng/decode/APNGDecoder;
    //   69: invokevirtual k : ()I
    //   72: idiv
    //   73: getstatic android/graphics/Bitmap$Config.ARGB_8888 : Landroid/graphics/Bitmap$Config;
    //   76: invokeinterface a : (IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   81: putfield f : Landroid/graphics/Bitmap;
    //   84: aload_1
    //   85: ifnonnull -> 99
    //   88: aload_0
    //   89: getfield f : Landroid/graphics/Bitmap;
    //   92: iconst_0
    //   93: invokevirtual eraseColor : (I)V
    //   96: goto -> 145
    //   99: aload_1
    //   100: invokevirtual rewind : ()Ljava/nio/Buffer;
    //   103: pop
    //   104: aload_1
    //   105: invokevirtual remaining : ()I
    //   108: aload_0
    //   109: getfield f : Landroid/graphics/Bitmap;
    //   112: invokevirtual getByteCount : ()I
    //   115: if_icmpge -> 129
    //   118: ldc 'IMAGE'
    //   120: ldc 'onRender:Buffer not large enough for pixels'
    //   122: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   125: pop
    //   126: aload_2
    //   127: monitorexit
    //   128: return
    //   129: aload_0
    //   130: getfield f : Landroid/graphics/Bitmap;
    //   133: aload_1
    //   134: invokevirtual copyPixelsFromBuffer : (Ljava/nio/Buffer;)V
    //   137: goto -> 145
    //   140: astore_1
    //   141: aload_1
    //   142: invokevirtual printStackTrace : ()V
    //   145: aload_2
    //   146: monitorexit
    //   147: invokestatic n : ()Landroid/os/Handler;
    //   150: aload_0
    //   151: getfield j : Ljava/lang/Runnable;
    //   154: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   157: pop
    //   158: return
    //   159: astore_1
    //   160: aload_2
    //   161: monitorexit
    //   162: aload_1
    //   163: athrow
    // Exception table:
    //   from	to	target	type
    //   15	32	140	finally
    //   32	84	140	finally
    //   88	96	140	finally
    //   99	126	140	finally
    //   126	128	159	finally
    //   129	137	140	finally
    //   141	145	159	finally
    //   145	147	159	finally
    //   160	162	159	finally
  }
  
  public void b() {
    AppInfo.n().post(new Runnable(this) {
          public void run() {
            if (ImageLoader.a()) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(this);
              stringBuilder.append(", onEnd ");
              Log.d("IMAGE", stringBuilder.toString());
            } 
            Iterator<Animatable2Compat.AnimationCallback> iterator = APNGDrawable.a(this.a).values().iterator();
            while (iterator.hasNext())
              ((Animatable2Compat.AnimationCallback)iterator.next()).onAnimationEnd(this.a); 
          }
        });
  }
  
  public void c() {
    if (ImageLoader.a()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(toString());
      stringBuilder.append(", recycle");
      Log.d("IMAGE", stringBuilder.toString());
    } 
    AppInfo.n().removeCallbacks(this.j);
    this.j = null;
    this.b.h();
    this.b = null;
  }
  
  public void clearAnimationCallbacks() {
    this.e.clear();
  }
  
  public void draw(Canvas paramCanvas) {
    Bitmap bitmap = this.f;
    if (bitmap != null) {
      if (bitmap.isRecycled())
        return; 
      if (ImageLoader.a()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this);
        stringBuilder.append(", draw ");
        Log.v("IMAGE", stringBuilder.toString());
      } 
      paramCanvas.setDrawFilter(this.c);
      paramCanvas.drawBitmap(this.f, this.d, this.a);
    } 
  }
  
  public int getIntrinsicHeight() {
    Rect rect = this.b.e();
    return (rect != null) ? rect.height() : -1;
  }
  
  public int getIntrinsicWidth() {
    Rect rect = this.b.e();
    return (rect != null) ? rect.width() : -1;
  }
  
  public int getOpacity() {
    return -3;
  }
  
  public boolean isRunning() {
    return this.b.i();
  }
  
  public void registerAnimationCallback(Animatable2Compat.AnimationCallback paramAnimationCallback) {
    this.e.put(paramAnimationCallback, paramAnimationCallback);
  }
  
  public void setAlpha(int paramInt) {
    this.a.setAlpha(paramInt);
  }
  
  public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    this.b.b(getBounds().width(), getBounds().height());
    this.d.setScale(getBounds().width() * 1.0F * this.b.k() / this.b.e().width(), getBounds().height() * 1.0F * this.b.k() / this.b.e().height());
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {
    this.a.setColorFilter(paramColorFilter);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2) {
    if (ImageLoader.a()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(toString());
      stringBuilder.append(", visible:");
      stringBuilder.append(paramBoolean1);
      stringBuilder.append(", restart:");
      stringBuilder.append(paramBoolean2);
      Log.d("IMAGE", stringBuilder.toString());
    } 
    if (paramBoolean1) {
      paramBoolean1 = super.setVisible(true, paramBoolean2);
      if (this.i < 0 && !isRunning())
        start(); 
      return paramBoolean1;
    } 
    if (isRunning())
      stop(); 
    return super.setVisible(false, paramBoolean2);
  }
  
  public void start() {
    if (ImageLoader.a()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(toString());
      stringBuilder.append(", start, isVisible=");
      stringBuilder.append(isVisible());
      Log.d("IMAGE", stringBuilder.toString());
    } 
    if (isVisible())
      synchronized (this.h) {
        if (this.f != null && !this.f.isRecycled())
          this.f.eraseColor(0); 
        this.b.f();
        return;
      }  
  }
  
  public void stop() {
    if (ImageLoader.a()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(toString());
      stringBuilder.append(", @");
      stringBuilder.append(Thread.currentThread().getName());
      stringBuilder.append(", stop");
      Log.d("IMAGE", stringBuilder.toString());
    } 
    this.b.g();
    synchronized (this.h) {
      if (this.f != null && !this.f.isRecycled()) {
        if (this.i == 1) {
          this.f.recycle();
        } else {
          this.g.a(this.f);
        } 
        this.f = null;
      } 
      return;
    } 
  }
  
  public boolean unregisterAnimationCallback(Animatable2Compat.AnimationCallback paramAnimationCallback) {
    this.e.remove(paramAnimationCallback);
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\image\apng\drawable\APNGDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */