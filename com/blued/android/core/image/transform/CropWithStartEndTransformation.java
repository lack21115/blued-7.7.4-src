package com.blued.android.core.image.transform;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import java.security.MessageDigest;

public class CropWithStartEndTransformation extends BitmapTransformation {
  private boolean b;
  
  public CropWithStartEndTransformation(boolean paramBoolean) {
    this.b = paramBoolean;
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
    //   19: aload_2
    //   20: invokevirtual getWidth : ()I
    //   23: istore #14
    //   25: aload_2
    //   26: invokevirtual getHeight : ()I
    //   29: istore #15
    //   31: iload_3
    //   32: i2f
    //   33: fstore #10
    //   35: iload #4
    //   37: i2f
    //   38: fstore #11
    //   40: fload #10
    //   42: fload #11
    //   44: fdiv
    //   45: fstore #12
    //   47: iload #14
    //   49: i2f
    //   50: fstore #7
    //   52: iload #15
    //   54: i2f
    //   55: fstore #5
    //   57: fload #7
    //   59: fload #5
    //   61: fdiv
    //   62: fstore #13
    //   64: fload #10
    //   66: fload #7
    //   68: fdiv
    //   69: fload #11
    //   71: fload #5
    //   73: fdiv
    //   74: invokestatic max : (FF)F
    //   77: fstore #6
    //   79: fload #7
    //   81: fload #6
    //   83: fmul
    //   84: fstore #8
    //   86: fload #6
    //   88: fload #5
    //   90: fmul
    //   91: fstore #9
    //   93: fconst_0
    //   94: fstore #6
    //   96: fconst_0
    //   97: fstore #7
    //   99: fload #13
    //   101: fload #12
    //   103: fcmpl
    //   104: ifle -> 128
    //   107: fload #7
    //   109: fstore #5
    //   111: aload_0
    //   112: getfield b : Z
    //   115: ifne -> 169
    //   118: fload #10
    //   120: fload #8
    //   122: fsub
    //   123: fstore #5
    //   125: goto -> 169
    //   128: fload #7
    //   130: fstore #5
    //   132: fload #13
    //   134: fload #12
    //   136: fcmpg
    //   137: ifge -> 169
    //   140: fload #7
    //   142: fstore #5
    //   144: aload_0
    //   145: getfield b : Z
    //   148: ifne -> 169
    //   151: fload #11
    //   153: fload #9
    //   155: fsub
    //   156: fstore #7
    //   158: fload #6
    //   160: fstore #5
    //   162: fload #7
    //   164: fstore #6
    //   166: goto -> 172
    //   169: fconst_0
    //   170: fstore #6
    //   172: new android/graphics/RectF
    //   175: dup
    //   176: fload #5
    //   178: fload #6
    //   180: fload #8
    //   182: fload #5
    //   184: fadd
    //   185: fload #9
    //   187: fload #6
    //   189: fadd
    //   190: invokespecial <init> : (FFFF)V
    //   193: astore #16
    //   195: aload_1
    //   196: aload_2
    //   197: invokestatic a : (Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   200: astore #17
    //   202: aload_1
    //   203: iload_3
    //   204: iload #4
    //   206: aload_2
    //   207: invokestatic a : (Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap$Config;
    //   210: invokeinterface a : (IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   215: astore #18
    //   217: aload #18
    //   219: iconst_1
    //   220: invokevirtual setHasAlpha : (Z)V
    //   223: invokestatic a : ()Ljava/util/concurrent/locks/Lock;
    //   226: invokeinterface lock : ()V
    //   231: new android/graphics/Canvas
    //   234: dup
    //   235: aload #18
    //   237: invokespecial <init> : (Landroid/graphics/Bitmap;)V
    //   240: astore #19
    //   242: aload #19
    //   244: aload #17
    //   246: aconst_null
    //   247: aload #16
    //   249: aconst_null
    //   250: invokevirtual drawBitmap : (Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/RectF;Landroid/graphics/Paint;)V
    //   253: aload #19
    //   255: aconst_null
    //   256: invokevirtual setBitmap : (Landroid/graphics/Bitmap;)V
    //   259: invokestatic a : ()Ljava/util/concurrent/locks/Lock;
    //   262: invokeinterface unlock : ()V
    //   267: aload #17
    //   269: aload_2
    //   270: invokevirtual equals : (Ljava/lang/Object;)Z
    //   273: ifne -> 284
    //   276: aload_1
    //   277: aload #17
    //   279: invokeinterface a : (Landroid/graphics/Bitmap;)V
    //   284: aload #18
    //   286: areturn
    //   287: astore_1
    //   288: invokestatic a : ()Ljava/util/concurrent/locks/Lock;
    //   291: invokeinterface unlock : ()V
    //   296: aload_1
    //   297: athrow
    // Exception table:
    //   from	to	target	type
    //   231	259	287	finally
  }
  
  public void a(MessageDigest paramMessageDigest) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("com.blued.android.core.transform.CropWithStartEndTransformation.1");
    stringBuilder.append(this.b);
    paramMessageDigest.update(stringBuilder.toString().getBytes(a));
  }
  
  public boolean equals(Object paramObject) {
    return (paramObject instanceof CropWithStartEndTransformation && ((CropWithStartEndTransformation)paramObject).b == this.b);
  }
  
  public int hashCode() {
    byte b;
    int i = "com.blued.android.core.transform.CropWithStartEndTransformation.1".hashCode();
    if (this.b) {
      b = 1000;
    } else {
      b = 0;
    } 
    return i + b;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("CropWithStartEndTransformation(fitStart=");
    stringBuilder.append(this.b);
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\image\transform\CropWithStartEndTransformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */