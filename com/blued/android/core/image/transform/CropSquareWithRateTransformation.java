package com.blued.android.core.image.transform;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import java.security.MessageDigest;

public class CropSquareWithRateTransformation extends BitmapTransformation {
  private float b;
  
  private float c;
  
  public CropSquareWithRateTransformation(float paramFloat1, float paramFloat2) {
    this.b = paramFloat1;
    this.c = paramFloat2;
  }
  
  public Bitmap a(BitmapPool paramBitmapPool, Bitmap paramBitmap, int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual getWidth : ()I
    //   4: iload_3
    //   5: if_icmpne -> 19
    //   8: aload_2
    //   9: invokevirtual getHeight : ()I
    //   12: iload #4
    //   14: if_icmpne -> 19
    //   17: aload_2
    //   18: areturn
    //   19: aload_0
    //   20: getfield b : F
    //   23: ldc -1.0
    //   25: fcmpl
    //   26: ifne -> 48
    //   29: aload_0
    //   30: getfield c : F
    //   33: ldc -1.0
    //   35: fcmpl
    //   36: ifne -> 48
    //   39: aload_1
    //   40: aload_2
    //   41: iload_3
    //   42: iload #4
    //   44: invokestatic a : (Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   47: areturn
    //   48: iload_3
    //   49: iload #4
    //   51: invokestatic min : (II)I
    //   54: istore_3
    //   55: aload_2
    //   56: invokevirtual getWidth : ()I
    //   59: istore #4
    //   61: aload_2
    //   62: invokevirtual getHeight : ()I
    //   65: istore #12
    //   67: iload_3
    //   68: i2f
    //   69: fstore #5
    //   71: iload #4
    //   73: i2f
    //   74: fstore #8
    //   76: fload #5
    //   78: fload #8
    //   80: fdiv
    //   81: fstore #6
    //   83: iload #12
    //   85: i2f
    //   86: fstore #11
    //   88: fload #6
    //   90: fload #5
    //   92: fload #11
    //   94: fdiv
    //   95: invokestatic max : (FF)F
    //   98: fstore #5
    //   100: fload #5
    //   102: fload #8
    //   104: fmul
    //   105: fstore #9
    //   107: fload #5
    //   109: fload #11
    //   111: fmul
    //   112: fstore #10
    //   114: fconst_0
    //   115: fstore #6
    //   117: fconst_0
    //   118: fstore #7
    //   120: iload #4
    //   122: iload #12
    //   124: if_icmple -> 181
    //   127: aload_0
    //   128: getfield b : F
    //   131: fstore #6
    //   133: fload #7
    //   135: fstore #5
    //   137: fload #6
    //   139: fconst_0
    //   140: fcmpl
    //   141: ifle -> 254
    //   144: iload #4
    //   146: iload #12
    //   148: isub
    //   149: i2f
    //   150: fload #8
    //   152: fdiv
    //   153: fstore #5
    //   155: fload #6
    //   157: fload #5
    //   159: fcmpl
    //   160: ifle -> 166
    //   163: goto -> 170
    //   166: fload #6
    //   168: fstore #5
    //   170: fload #5
    //   172: fload #9
    //   174: fneg
    //   175: fmul
    //   176: fstore #5
    //   178: goto -> 254
    //   181: fload #7
    //   183: fstore #5
    //   185: iload #4
    //   187: iload #12
    //   189: if_icmpge -> 254
    //   192: aload_0
    //   193: getfield c : F
    //   196: fstore #8
    //   198: fload #7
    //   200: fstore #5
    //   202: fload #8
    //   204: fconst_0
    //   205: fcmpl
    //   206: ifle -> 254
    //   209: iload #12
    //   211: iload #4
    //   213: isub
    //   214: i2f
    //   215: fload #11
    //   217: fdiv
    //   218: fstore #5
    //   220: fload #8
    //   222: fload #5
    //   224: fcmpl
    //   225: ifle -> 231
    //   228: goto -> 235
    //   231: fload #8
    //   233: fstore #5
    //   235: fload #5
    //   237: fload #10
    //   239: fneg
    //   240: fmul
    //   241: fstore #7
    //   243: fload #6
    //   245: fstore #5
    //   247: fload #7
    //   249: fstore #6
    //   251: goto -> 257
    //   254: fconst_0
    //   255: fstore #6
    //   257: new android/graphics/RectF
    //   260: dup
    //   261: fload #5
    //   263: fload #6
    //   265: fload #9
    //   267: fload #5
    //   269: fadd
    //   270: fload #10
    //   272: fload #6
    //   274: fadd
    //   275: invokespecial <init> : (FFFF)V
    //   278: astore #13
    //   280: aload_1
    //   281: aload_2
    //   282: invokestatic a : (Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   285: astore #14
    //   287: aload_1
    //   288: iload_3
    //   289: iload_3
    //   290: aload_2
    //   291: invokestatic a : (Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap$Config;
    //   294: invokeinterface a : (IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   299: astore #15
    //   301: aload #15
    //   303: iconst_1
    //   304: invokevirtual setHasAlpha : (Z)V
    //   307: invokestatic a : ()Ljava/util/concurrent/locks/Lock;
    //   310: invokeinterface lock : ()V
    //   315: new android/graphics/Canvas
    //   318: dup
    //   319: aload #15
    //   321: invokespecial <init> : (Landroid/graphics/Bitmap;)V
    //   324: astore #16
    //   326: aload #16
    //   328: aload #14
    //   330: aconst_null
    //   331: aload #13
    //   333: aconst_null
    //   334: invokevirtual drawBitmap : (Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/RectF;Landroid/graphics/Paint;)V
    //   337: aload #16
    //   339: aconst_null
    //   340: invokevirtual setBitmap : (Landroid/graphics/Bitmap;)V
    //   343: invokestatic a : ()Ljava/util/concurrent/locks/Lock;
    //   346: invokeinterface unlock : ()V
    //   351: aload #14
    //   353: aload_2
    //   354: invokevirtual equals : (Ljava/lang/Object;)Z
    //   357: ifne -> 368
    //   360: aload_1
    //   361: aload #14
    //   363: invokeinterface a : (Landroid/graphics/Bitmap;)V
    //   368: aload #15
    //   370: areturn
    //   371: astore_1
    //   372: invokestatic a : ()Ljava/util/concurrent/locks/Lock;
    //   375: invokeinterface unlock : ()V
    //   380: aload_1
    //   381: athrow
    // Exception table:
    //   from	to	target	type
    //   315	343	371	finally
  }
  
  public void a(MessageDigest paramMessageDigest) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("com.blued.android.core.transform.CropSquareWithRateTransformation.1");
    stringBuilder.append(this.b);
    stringBuilder.append(this.c);
    paramMessageDigest.update(stringBuilder.toString().getBytes(a));
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject instanceof CropSquareWithRateTransformation) {
      paramObject = paramObject;
      if (((CropSquareWithRateTransformation)paramObject).b == this.b && ((CropSquareWithRateTransformation)paramObject).c == this.c)
        return true; 
    } 
    return false;
  }
  
  public int hashCode() {
    return (int)("com.blued.android.core.transform.CropSquareWithRateTransformation.1".hashCode() + this.b * 1000.0F + this.c * 10.0F);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("CropSquareWithRateTransformation(rateX=");
    stringBuilder.append(this.b);
    stringBuilder.append(", rateY=");
    stringBuilder.append(this.c);
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\image\transform\CropSquareWithRateTransformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */