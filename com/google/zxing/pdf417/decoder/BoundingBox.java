package com.google.zxing.pdf417.decoder;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

final class BoundingBox {
  private final BitMatrix a;
  
  private final ResultPoint b;
  
  private final ResultPoint c;
  
  private final ResultPoint d;
  
  private final ResultPoint e;
  
  private final int f;
  
  private final int g;
  
  private final int h;
  
  private final int i;
  
  BoundingBox(BitMatrix paramBitMatrix, ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3, ResultPoint paramResultPoint4) throws NotFoundException {
    boolean bool1;
    boolean bool2 = false;
    if (paramResultPoint1 == null || paramResultPoint2 == null) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (paramResultPoint3 == null || paramResultPoint4 == null)
      bool2 = true; 
    if (!bool1 || !bool2) {
      ResultPoint resultPoint1;
      ResultPoint resultPoint2;
      if (bool1) {
        resultPoint1 = new ResultPoint(0.0F, paramResultPoint3.b());
        resultPoint2 = new ResultPoint(0.0F, paramResultPoint4.b());
      } else {
        resultPoint1 = paramResultPoint1;
        resultPoint2 = paramResultPoint2;
        if (bool2) {
          paramResultPoint3 = new ResultPoint((paramBitMatrix.e() - 1), paramResultPoint1.b());
          paramResultPoint4 = new ResultPoint((paramBitMatrix.e() - 1), paramResultPoint2.b());
          resultPoint2 = paramResultPoint2;
          resultPoint1 = paramResultPoint1;
        } 
      } 
      this.a = paramBitMatrix;
      this.b = resultPoint1;
      this.c = resultPoint2;
      this.d = paramResultPoint3;
      this.e = paramResultPoint4;
      this.f = (int)Math.min(resultPoint1.a(), resultPoint2.a());
      this.g = (int)Math.max(paramResultPoint3.a(), paramResultPoint4.a());
      this.h = (int)Math.min(resultPoint1.b(), paramResultPoint3.b());
      this.i = (int)Math.max(resultPoint2.b(), paramResultPoint4.b());
      return;
    } 
    throw NotFoundException.a();
  }
  
  BoundingBox(BoundingBox paramBoundingBox) {
    this.a = paramBoundingBox.a;
    this.b = paramBoundingBox.e();
    this.c = paramBoundingBox.g();
    this.d = paramBoundingBox.f();
    this.e = paramBoundingBox.h();
    this.f = paramBoundingBox.a();
    this.g = paramBoundingBox.b();
    this.h = paramBoundingBox.c();
    this.i = paramBoundingBox.d();
  }
  
  static BoundingBox a(BoundingBox paramBoundingBox1, BoundingBox paramBoundingBox2) throws NotFoundException {
    return (paramBoundingBox1 == null) ? paramBoundingBox2 : ((paramBoundingBox2 == null) ? paramBoundingBox1 : new BoundingBox(paramBoundingBox1.a, paramBoundingBox1.b, paramBoundingBox1.c, paramBoundingBox2.d, paramBoundingBox2.e));
  }
  
  int a() {
    return this.f;
  }
  
  BoundingBox a(int paramInt1, int paramInt2, boolean paramBoolean) throws NotFoundException {
    // Byte code:
    //   0: aload_0
    //   1: getfield b : Lcom/google/zxing/ResultPoint;
    //   4: astore #5
    //   6: aload_0
    //   7: getfield c : Lcom/google/zxing/ResultPoint;
    //   10: astore #6
    //   12: aload_0
    //   13: getfield d : Lcom/google/zxing/ResultPoint;
    //   16: astore #7
    //   18: aload_0
    //   19: getfield e : Lcom/google/zxing/ResultPoint;
    //   22: astore #9
    //   24: iload_1
    //   25: ifle -> 97
    //   28: iload_3
    //   29: ifeq -> 39
    //   32: aload #5
    //   34: astore #8
    //   36: goto -> 43
    //   39: aload #7
    //   41: astore #8
    //   43: aload #8
    //   45: invokevirtual b : ()F
    //   48: f2i
    //   49: iload_1
    //   50: isub
    //   51: istore #4
    //   53: iload #4
    //   55: istore_1
    //   56: iload #4
    //   58: ifge -> 63
    //   61: iconst_0
    //   62: istore_1
    //   63: new com/google/zxing/ResultPoint
    //   66: dup
    //   67: aload #8
    //   69: invokevirtual a : ()F
    //   72: iload_1
    //   73: i2f
    //   74: invokespecial <init> : (FF)V
    //   77: astore #8
    //   79: iload_3
    //   80: ifeq -> 90
    //   83: aload #8
    //   85: astore #5
    //   87: goto -> 97
    //   90: aload #5
    //   92: astore #7
    //   94: goto -> 105
    //   97: aload #7
    //   99: astore #8
    //   101: aload #5
    //   103: astore #7
    //   105: iload_2
    //   106: ifle -> 190
    //   109: iload_3
    //   110: ifeq -> 122
    //   113: aload_0
    //   114: getfield c : Lcom/google/zxing/ResultPoint;
    //   117: astore #5
    //   119: goto -> 128
    //   122: aload_0
    //   123: getfield e : Lcom/google/zxing/ResultPoint;
    //   126: astore #5
    //   128: aload #5
    //   130: invokevirtual b : ()F
    //   133: f2i
    //   134: iload_2
    //   135: iadd
    //   136: istore_2
    //   137: iload_2
    //   138: istore_1
    //   139: iload_2
    //   140: aload_0
    //   141: getfield a : Lcom/google/zxing/common/BitMatrix;
    //   144: invokevirtual f : ()I
    //   147: if_icmplt -> 160
    //   150: aload_0
    //   151: getfield a : Lcom/google/zxing/common/BitMatrix;
    //   154: invokevirtual f : ()I
    //   157: iconst_1
    //   158: isub
    //   159: istore_1
    //   160: new com/google/zxing/ResultPoint
    //   163: dup
    //   164: aload #5
    //   166: invokevirtual a : ()F
    //   169: iload_1
    //   170: i2f
    //   171: invokespecial <init> : (FF)V
    //   174: astore #5
    //   176: iload_3
    //   177: ifeq -> 183
    //   180: goto -> 194
    //   183: aload #5
    //   185: astore #9
    //   187: goto -> 198
    //   190: aload #6
    //   192: astore #5
    //   194: aload #5
    //   196: astore #6
    //   198: new com/google/zxing/pdf417/decoder/BoundingBox
    //   201: dup
    //   202: aload_0
    //   203: getfield a : Lcom/google/zxing/common/BitMatrix;
    //   206: aload #7
    //   208: aload #6
    //   210: aload #8
    //   212: aload #9
    //   214: invokespecial <init> : (Lcom/google/zxing/common/BitMatrix;Lcom/google/zxing/ResultPoint;Lcom/google/zxing/ResultPoint;Lcom/google/zxing/ResultPoint;Lcom/google/zxing/ResultPoint;)V
    //   217: areturn
  }
  
  int b() {
    return this.g;
  }
  
  int c() {
    return this.h;
  }
  
  int d() {
    return this.i;
  }
  
  ResultPoint e() {
    return this.b;
  }
  
  ResultPoint f() {
    return this.d;
  }
  
  ResultPoint g() {
    return this.c;
  }
  
  ResultPoint h() {
    return this.e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\pdf417\decoder\BoundingBox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */