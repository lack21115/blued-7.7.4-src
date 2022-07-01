package com.bytedance.sdk.openadsdk.g.a;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.e;
import com.bytedance.sdk.adnet.core.j;
import com.bytedance.sdk.adnet.core.n;
import com.bytedance.sdk.adnet.face.d;

public class c extends Request<byte[]> {
  private static final Object i = new Object();
  
  private final Object c = new Object();
  
  private a d;
  
  private final Bitmap.Config e;
  
  private final int f;
  
  private final int g;
  
  private final ImageView.ScaleType h;
  
  public c(String paramString, a parama, int paramInt1, int paramInt2, ImageView.ScaleType paramScaleType, Bitmap.Config paramConfig) {
    super(0, paramString, parama);
    setRetryPolicy((d)new e(1000, 2, 2.0F));
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
  
  private n<byte[]> b(j paramj) {
    // Byte code:
    //   0: aload_1
    //   1: getfield b : [B
    //   4: astore #6
    //   6: invokestatic a : ()Lcom/bytedance/sdk/openadsdk/g/a/a;
    //   9: aload_0
    //   10: invokevirtual getUrl : ()Ljava/lang/String;
    //   13: aload_0
    //   14: getfield f : I
    //   17: aload_0
    //   18: getfield g : I
    //   21: aload_0
    //   22: getfield h : Landroid/widget/ImageView$ScaleType;
    //   25: invokevirtual a : (Ljava/lang/String;IILandroid/widget/ImageView$ScaleType;)Ljava/lang/String;
    //   28: astore #8
    //   30: aload #6
    //   32: arraylength
    //   33: iconst_3
    //   34: if_icmplt -> 113
    //   37: aload #6
    //   39: iconst_0
    //   40: baload
    //   41: bipush #71
    //   43: if_icmpne -> 113
    //   46: aload #6
    //   48: iconst_1
    //   49: baload
    //   50: bipush #73
    //   52: if_icmpne -> 113
    //   55: aload #6
    //   57: iconst_2
    //   58: baload
    //   59: bipush #70
    //   61: if_icmpne -> 113
    //   64: invokestatic a : ()Lcom/bytedance/sdk/openadsdk/g/a/a;
    //   67: aload #8
    //   69: aload #6
    //   71: invokevirtual a : (Ljava/lang/String;[B)V
    //   74: aload_0
    //   75: getfield d : Lcom/bytedance/sdk/openadsdk/g/a/c$a;
    //   78: ifnull -> 99
    //   81: aload_0
    //   82: getfield b : Landroid/os/Handler;
    //   85: new com/bytedance/sdk/openadsdk/g/a/c$1
    //   88: dup
    //   89: aload_0
    //   90: aload #6
    //   92: invokespecial <init> : (Lcom/bytedance/sdk/openadsdk/g/a/c;[B)V
    //   95: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   98: pop
    //   99: aload #6
    //   101: aload_1
    //   102: invokestatic a : (Lcom/bytedance/sdk/adnet/core/j;)Lcom/bytedance/sdk/adnet/face/a$a;
    //   105: invokestatic a : (Ljava/lang/Object;Lcom/bytedance/sdk/adnet/face/a$a;)Lcom/bytedance/sdk/adnet/core/n;
    //   108: astore #7
    //   110: aload #7
    //   112: areturn
    //   113: new android/graphics/BitmapFactory$Options
    //   116: dup
    //   117: invokespecial <init> : ()V
    //   120: astore #7
    //   122: aload_0
    //   123: getfield f : I
    //   126: ifne -> 161
    //   129: aload_0
    //   130: getfield g : I
    //   133: ifne -> 161
    //   136: aload #7
    //   138: aload_0
    //   139: getfield e : Landroid/graphics/Bitmap$Config;
    //   142: putfield inPreferredConfig : Landroid/graphics/Bitmap$Config;
    //   145: aload #6
    //   147: iconst_0
    //   148: aload #6
    //   150: arraylength
    //   151: aload #7
    //   153: invokestatic decodeByteArray : ([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   156: astore #6
    //   158: goto -> 312
    //   161: aload #7
    //   163: iconst_1
    //   164: putfield inJustDecodeBounds : Z
    //   167: aload #6
    //   169: iconst_0
    //   170: aload #6
    //   172: arraylength
    //   173: aload #7
    //   175: invokestatic decodeByteArray : ([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   178: pop
    //   179: aload #7
    //   181: getfield outWidth : I
    //   184: istore_2
    //   185: aload #7
    //   187: getfield outHeight : I
    //   190: istore_3
    //   191: aload_0
    //   192: getfield f : I
    //   195: aload_0
    //   196: getfield g : I
    //   199: iload_2
    //   200: iload_3
    //   201: aload_0
    //   202: getfield h : Landroid/widget/ImageView$ScaleType;
    //   205: invokestatic a : (IIIILandroid/widget/ImageView$ScaleType;)I
    //   208: istore #4
    //   210: aload_0
    //   211: getfield g : I
    //   214: aload_0
    //   215: getfield f : I
    //   218: iload_3
    //   219: iload_2
    //   220: aload_0
    //   221: getfield h : Landroid/widget/ImageView$ScaleType;
    //   224: invokestatic a : (IIIILandroid/widget/ImageView$ScaleType;)I
    //   227: istore #5
    //   229: aload #7
    //   231: iconst_0
    //   232: putfield inJustDecodeBounds : Z
    //   235: aload #7
    //   237: iload_2
    //   238: iload_3
    //   239: iload #4
    //   241: iload #5
    //   243: invokestatic a : (IIII)I
    //   246: putfield inSampleSize : I
    //   249: aload #6
    //   251: iconst_0
    //   252: aload #6
    //   254: arraylength
    //   255: aload #7
    //   257: invokestatic decodeByteArray : ([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   260: astore #7
    //   262: aload #7
    //   264: astore #6
    //   266: aload #7
    //   268: ifnull -> 312
    //   271: aload #7
    //   273: invokevirtual getWidth : ()I
    //   276: iload #4
    //   278: if_icmpgt -> 295
    //   281: aload #7
    //   283: astore #6
    //   285: aload #7
    //   287: invokevirtual getHeight : ()I
    //   290: iload #5
    //   292: if_icmple -> 312
    //   295: aload #7
    //   297: iload #4
    //   299: iload #5
    //   301: iconst_1
    //   302: invokestatic createScaledBitmap : (Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   305: astore #6
    //   307: aload #7
    //   309: invokevirtual recycle : ()V
    //   312: aload #6
    //   314: ifnonnull -> 329
    //   317: new com/bytedance/sdk/adnet/err/e
    //   320: dup
    //   321: aload_1
    //   322: invokespecial <init> : (Lcom/bytedance/sdk/adnet/core/j;)V
    //   325: invokestatic a : (Lcom/bytedance/sdk/adnet/err/VAdError;)Lcom/bytedance/sdk/adnet/core/n;
    //   328: areturn
    //   329: aload #6
    //   331: invokestatic b : (Landroid/graphics/Bitmap;)[B
    //   334: astore #6
    //   336: invokestatic a : ()Lcom/bytedance/sdk/openadsdk/g/a/a;
    //   339: aload #8
    //   341: aload #6
    //   343: invokevirtual a : (Ljava/lang/String;[B)V
    //   346: aload_0
    //   347: getfield d : Lcom/bytedance/sdk/openadsdk/g/a/c$a;
    //   350: ifnull -> 371
    //   353: aload_0
    //   354: getfield b : Landroid/os/Handler;
    //   357: new com/bytedance/sdk/openadsdk/g/a/c$2
    //   360: dup
    //   361: aload_0
    //   362: aload #6
    //   364: invokespecial <init> : (Lcom/bytedance/sdk/openadsdk/g/a/c;[B)V
    //   367: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   370: pop
    //   371: aload #6
    //   373: aload_1
    //   374: invokestatic a : (Lcom/bytedance/sdk/adnet/core/j;)Lcom/bytedance/sdk/adnet/face/a$a;
    //   377: invokestatic a : (Ljava/lang/Object;Lcom/bytedance/sdk/adnet/face/a$a;)Lcom/bytedance/sdk/adnet/core/n;
    //   380: areturn
    //   381: astore #7
    //   383: goto -> 113
    // Exception table:
    //   from	to	target	type
    //   64	99	381	java/lang/Exception
    //   99	110	381	java/lang/Exception
  }
  
  public n<byte[]> a(j paramj) {
    synchronized (i) {
      return b(paramj);
    } 
  }
  
  public void a(n<byte[]> paramn) {
    synchronized (this.c) {
      a a1 = this.d;
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
  
  public static interface a extends n.a<byte[]> {
    void a(String param1String, byte[] param1ArrayOfbyte);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\g\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */