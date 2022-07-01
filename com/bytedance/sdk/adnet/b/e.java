package com.bytedance.sdk.adnet.b;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.j;
import com.bytedance.sdk.adnet.core.n;
import com.bytedance.sdk.adnet.face.d;

public class e extends Request<Bitmap> {
  private static final Object i = new Object();
  
  private final Object c = new Object();
  
  private n.a<Bitmap> d;
  
  private final Bitmap.Config e;
  
  private final int f;
  
  private final int g;
  
  private final ImageView.ScaleType h;
  
  public e(String paramString, n.a<Bitmap> parama, int paramInt1, int paramInt2, ImageView.ScaleType paramScaleType, Bitmap.Config paramConfig) {
    super(0, paramString, parama);
    setRetryPolicy((d)new com.bytedance.sdk.adnet.core.e(1000, 2, 2.0F));
    this.d = parama;
    this.e = paramConfig;
    this.f = paramInt1;
    this.g = paramInt2;
    this.h = paramScaleType;
    setShouldCache(false);
  }
  
  static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    double d = Math.min(paramInt1 / paramInt3, paramInt2 / paramInt4);
    float f = 1.0F;
    while (true) {
      float f1 = 2.0F * f;
      if (f1 <= d) {
        f = f1;
        continue;
      } 
      return (int)f;
    } 
  }
  
  private static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, ImageView.ScaleType paramScaleType) {
    if (paramInt1 == 0 && paramInt2 == 0)
      return paramInt3; 
    if (paramScaleType == ImageView.ScaleType.FIT_XY)
      return (paramInt1 == 0) ? paramInt3 : paramInt1; 
    if (paramInt1 == 0) {
      double d = paramInt2 / paramInt4;
      return (int)(paramInt3 * d);
    } 
    if (paramInt2 == 0)
      return paramInt1; 
    double d1 = paramInt4 / paramInt3;
    if (paramScaleType == ImageView.ScaleType.CENTER_CROP) {
      double d4 = paramInt1;
      double d5 = paramInt2;
      if (d4 * d1 < d5)
        paramInt1 = (int)(d5 / d1); 
      return paramInt1;
    } 
    double d2 = paramInt1;
    double d3 = paramInt2;
    if (d2 * d1 > d3)
      paramInt1 = (int)(d3 / d1); 
    return paramInt1;
  }
  
  private n<Bitmap> b(j paramj) {
    // Byte code:
    //   0: aload_1
    //   1: getfield b : [B
    //   4: astore #6
    //   6: new android/graphics/BitmapFactory$Options
    //   9: dup
    //   10: invokespecial <init> : ()V
    //   13: astore #7
    //   15: aload_0
    //   16: getfield f : I
    //   19: ifne -> 54
    //   22: aload_0
    //   23: getfield g : I
    //   26: ifne -> 54
    //   29: aload #7
    //   31: aload_0
    //   32: getfield e : Landroid/graphics/Bitmap$Config;
    //   35: putfield inPreferredConfig : Landroid/graphics/Bitmap$Config;
    //   38: aload #6
    //   40: iconst_0
    //   41: aload #6
    //   43: arraylength
    //   44: aload #7
    //   46: invokestatic decodeByteArray : ([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   49: astore #6
    //   51: goto -> 205
    //   54: aload #7
    //   56: iconst_1
    //   57: putfield inJustDecodeBounds : Z
    //   60: aload #6
    //   62: iconst_0
    //   63: aload #6
    //   65: arraylength
    //   66: aload #7
    //   68: invokestatic decodeByteArray : ([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   71: pop
    //   72: aload #7
    //   74: getfield outWidth : I
    //   77: istore_2
    //   78: aload #7
    //   80: getfield outHeight : I
    //   83: istore_3
    //   84: aload_0
    //   85: getfield f : I
    //   88: aload_0
    //   89: getfield g : I
    //   92: iload_2
    //   93: iload_3
    //   94: aload_0
    //   95: getfield h : Landroid/widget/ImageView$ScaleType;
    //   98: invokestatic a : (IIIILandroid/widget/ImageView$ScaleType;)I
    //   101: istore #4
    //   103: aload_0
    //   104: getfield g : I
    //   107: aload_0
    //   108: getfield f : I
    //   111: iload_3
    //   112: iload_2
    //   113: aload_0
    //   114: getfield h : Landroid/widget/ImageView$ScaleType;
    //   117: invokestatic a : (IIIILandroid/widget/ImageView$ScaleType;)I
    //   120: istore #5
    //   122: aload #7
    //   124: iconst_0
    //   125: putfield inJustDecodeBounds : Z
    //   128: aload #7
    //   130: iload_2
    //   131: iload_3
    //   132: iload #4
    //   134: iload #5
    //   136: invokestatic a : (IIII)I
    //   139: putfield inSampleSize : I
    //   142: aload #6
    //   144: iconst_0
    //   145: aload #6
    //   147: arraylength
    //   148: aload #7
    //   150: invokestatic decodeByteArray : ([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   153: astore #7
    //   155: aload #7
    //   157: astore #6
    //   159: aload #7
    //   161: ifnull -> 205
    //   164: aload #7
    //   166: invokevirtual getWidth : ()I
    //   169: iload #4
    //   171: if_icmpgt -> 188
    //   174: aload #7
    //   176: astore #6
    //   178: aload #7
    //   180: invokevirtual getHeight : ()I
    //   183: iload #5
    //   185: if_icmple -> 205
    //   188: aload #7
    //   190: iload #4
    //   192: iload #5
    //   194: iconst_1
    //   195: invokestatic createScaledBitmap : (Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   198: astore #6
    //   200: aload #7
    //   202: invokevirtual recycle : ()V
    //   205: aload #6
    //   207: ifnonnull -> 222
    //   210: new com/bytedance/sdk/adnet/err/e
    //   213: dup
    //   214: aload_1
    //   215: invokespecial <init> : (Lcom/bytedance/sdk/adnet/core/j;)V
    //   218: invokestatic a : (Lcom/bytedance/sdk/adnet/err/VAdError;)Lcom/bytedance/sdk/adnet/core/n;
    //   221: areturn
    //   222: aload #6
    //   224: aload_1
    //   225: invokestatic a : (Lcom/bytedance/sdk/adnet/core/j;)Lcom/bytedance/sdk/adnet/face/a$a;
    //   228: invokestatic a : (Ljava/lang/Object;Lcom/bytedance/sdk/adnet/face/a$a;)Lcom/bytedance/sdk/adnet/core/n;
    //   231: areturn
  }
  
  public n<Bitmap> a(j paramj) {
    synchronized (i) {
      return b(paramj);
    } 
  }
  
  public void a(n<Bitmap> paramn) {
    synchronized (this.c) {
      n.a<Bitmap> a1 = this.d;
      if (a1 != null)
        a1.a(paramn); 
      return;
    } 
  }
  
  public void cancel() {
    super.cancel();
    synchronized (this.c) {
      this.d = null;
      return;
    } 
  }
  
  public Request.b getPriority() {
    return Request.b.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\adnet\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */