package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.PerspectiveTransform;
import com.google.zxing.common.detector.MathUtils;
import java.util.Map;

public class Detector {
  private final BitMatrix a;
  
  private ResultPointCallback b;
  
  public Detector(BitMatrix paramBitMatrix) {
    this.a = paramBitMatrix;
  }
  
  private float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    float f1;
    float f2 = b(paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt3 = paramInt1 - paramInt3 - paramInt1;
    boolean bool = false;
    if (paramInt3 < 0) {
      f1 = paramInt1 / (paramInt1 - paramInt3);
      paramInt3 = 0;
    } else if (paramInt3 >= this.a.e()) {
      f1 = (this.a.e() - 1 - paramInt1) / (paramInt3 - paramInt1);
      paramInt3 = this.a.e() - 1;
    } else {
      f1 = 1.0F;
    } 
    float f3 = paramInt2;
    paramInt4 = (int)(f3 - (paramInt4 - paramInt2) * f1);
    if (paramInt4 < 0) {
      f1 = f3 / (paramInt2 - paramInt4);
      paramInt4 = bool;
    } else if (paramInt4 >= this.a.f()) {
      f1 = (this.a.f() - 1 - paramInt2) / (paramInt4 - paramInt2);
      paramInt4 = this.a.f() - 1;
    } else {
      f1 = 1.0F;
    } 
    return f2 + b(paramInt1, paramInt2, (int)(paramInt1 + (paramInt3 - paramInt1) * f1), paramInt4) - 1.0F;
  }
  
  private float a(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2) {
    float f1 = a((int)paramResultPoint1.a(), (int)paramResultPoint1.b(), (int)paramResultPoint2.a(), (int)paramResultPoint2.b());
    float f2 = a((int)paramResultPoint2.a(), (int)paramResultPoint2.b(), (int)paramResultPoint1.a(), (int)paramResultPoint1.b());
    return Float.isNaN(f1) ? (f2 / 7.0F) : (Float.isNaN(f2) ? (f1 / 7.0F) : ((f1 + f2) / 14.0F));
  }
  
  private static int a(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3, float paramFloat) throws NotFoundException {
    int i = (MathUtils.a(ResultPoint.a(paramResultPoint1, paramResultPoint2) / paramFloat) + MathUtils.a(ResultPoint.a(paramResultPoint1, paramResultPoint3) / paramFloat)) / 2 + 7;
    int j = i & 0x3;
    if (j != 0) {
      if (j != 2) {
        if (j != 3)
          return i; 
        throw NotFoundException.a();
      } 
      return i - 1;
    } 
    return i + 1;
  }
  
  private static BitMatrix a(BitMatrix paramBitMatrix, PerspectiveTransform paramPerspectiveTransform, int paramInt) throws NotFoundException {
    return GridSampler.a().a(paramBitMatrix, paramInt, paramInt, paramPerspectiveTransform);
  }
  
  private static PerspectiveTransform a(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3, ResultPoint paramResultPoint4, int paramInt) {
    float f1;
    float f2;
    float f3;
    float f4 = paramInt - 3.5F;
    if (paramResultPoint4 != null) {
      float f = paramResultPoint4.a();
      f1 = paramResultPoint4.b();
      f2 = f4 - 3.0F;
      f3 = f;
    } else {
      f3 = paramResultPoint2.a();
      float f6 = paramResultPoint1.a();
      float f7 = paramResultPoint3.a();
      float f5 = paramResultPoint2.b();
      f1 = paramResultPoint1.b();
      f2 = paramResultPoint3.b();
      f3 = f3 - f6 + f7;
      f1 = f5 - f1 + f2;
      f5 = f4;
      f2 = f5;
    } 
    return PerspectiveTransform.a(3.5F, 3.5F, f4, 3.5F, f2, f2, 3.5F, f4, paramResultPoint1.a(), paramResultPoint1.b(), paramResultPoint2.a(), paramResultPoint2.b(), f3, f1, paramResultPoint3.a(), paramResultPoint3.b());
  }
  
  private float b(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int i;
    int m;
    byte b1;
    if (Math.abs(paramInt4 - paramInt2) > Math.abs(paramInt3 - paramInt1)) {
      i = 1;
    } else {
      i = 0;
    } 
    if (i) {
      int i4 = paramInt1;
      m = paramInt3;
      paramInt1 = paramInt4;
      paramInt3 = paramInt2;
      paramInt4 = i4;
    } else {
      int i4 = paramInt2;
      paramInt2 = paramInt3;
      m = paramInt4;
      paramInt4 = i4;
      paramInt3 = paramInt1;
      paramInt1 = paramInt2;
    } 
    int i2 = Math.abs(paramInt1 - paramInt3);
    int i3 = Math.abs(m - paramInt4);
    int k = -i2 / 2;
    byte b2 = -1;
    if (paramInt3 < paramInt1) {
      b1 = 1;
    } else {
      b1 = -1;
    } 
    if (paramInt4 < m)
      b2 = 1; 
    int i1 = paramInt1 + b1;
    paramInt2 = paramInt4;
    int j = 0;
    paramInt1 = paramInt3;
    int n = i;
    while (paramInt1 != i1) {
      int i5;
      boolean bool;
      if (n) {
        i4 = paramInt2;
      } else {
        i4 = paramInt1;
      } 
      if (n) {
        i5 = paramInt1;
      } else {
        i5 = paramInt2;
      } 
      if (j == 1) {
        bool = true;
      } else {
        bool = false;
      } 
      i = j;
      if (bool == this.a.a(i4, i5)) {
        if (j == 2)
          return MathUtils.a(paramInt1, paramInt2, paramInt3, paramInt4); 
        i = j + 1;
      } 
      int i4 = k + i3;
      j = paramInt2;
      k = i4;
      if (i4 > 0) {
        j = i;
        if (paramInt2 != m) {
          j = paramInt2 + b2;
          k = i4 - i2;
        } else {
          break;
        } 
      } 
      paramInt1 += b1;
      paramInt2 = j;
      j = i;
    } 
    return (j == 2) ? MathUtils.a(i1, m, paramInt3, paramInt4) : Float.NaN;
  }
  
  protected final float a(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3) {
    return (a(paramResultPoint1, paramResultPoint2) + a(paramResultPoint1, paramResultPoint3)) / 2.0F;
  }
  
  protected final DetectorResult a(FinderPatternInfo paramFinderPatternInfo) throws NotFoundException, FormatException {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual b : ()Lcom/google/zxing/qrcode/detector/FinderPattern;
    //   4: astore #15
    //   6: aload_1
    //   7: invokevirtual c : ()Lcom/google/zxing/qrcode/detector/FinderPattern;
    //   10: astore #16
    //   12: aload_1
    //   13: invokevirtual a : ()Lcom/google/zxing/qrcode/detector/FinderPattern;
    //   16: astore #17
    //   18: aload_0
    //   19: aload #15
    //   21: aload #16
    //   23: aload #17
    //   25: invokevirtual a : (Lcom/google/zxing/ResultPoint;Lcom/google/zxing/ResultPoint;Lcom/google/zxing/ResultPoint;)F
    //   28: fstore_2
    //   29: fload_2
    //   30: fconst_1
    //   31: fcmpg
    //   32: iflt -> 310
    //   35: aload #15
    //   37: aload #16
    //   39: aload #17
    //   41: fload_2
    //   42: invokestatic a : (Lcom/google/zxing/ResultPoint;Lcom/google/zxing/ResultPoint;Lcom/google/zxing/ResultPoint;F)I
    //   45: istore #11
    //   47: iload #11
    //   49: invokestatic a : (I)Lcom/google/zxing/qrcode/decoder/Version;
    //   52: astore #18
    //   54: aload #18
    //   56: invokevirtual d : ()I
    //   59: istore #10
    //   61: aconst_null
    //   62: astore #14
    //   64: aload #14
    //   66: astore_1
    //   67: aload #18
    //   69: invokevirtual b : ()[I
    //   72: arraylength
    //   73: ifle -> 221
    //   76: aload #16
    //   78: invokevirtual a : ()F
    //   81: fstore_3
    //   82: aload #15
    //   84: invokevirtual a : ()F
    //   87: fstore #4
    //   89: aload #17
    //   91: invokevirtual a : ()F
    //   94: fstore #5
    //   96: aload #16
    //   98: invokevirtual b : ()F
    //   101: fstore #6
    //   103: aload #15
    //   105: invokevirtual b : ()F
    //   108: fstore #7
    //   110: aload #17
    //   112: invokevirtual b : ()F
    //   115: fstore #8
    //   117: fconst_1
    //   118: ldc 3.0
    //   120: iload #10
    //   122: bipush #7
    //   124: isub
    //   125: i2f
    //   126: fdiv
    //   127: fsub
    //   128: fstore #9
    //   130: aload #15
    //   132: invokevirtual a : ()F
    //   135: fload_3
    //   136: fload #4
    //   138: fsub
    //   139: fload #5
    //   141: fadd
    //   142: aload #15
    //   144: invokevirtual a : ()F
    //   147: fsub
    //   148: fload #9
    //   150: fmul
    //   151: fadd
    //   152: f2i
    //   153: istore #12
    //   155: aload #15
    //   157: invokevirtual b : ()F
    //   160: fload #9
    //   162: fload #6
    //   164: fload #7
    //   166: fsub
    //   167: fload #8
    //   169: fadd
    //   170: aload #15
    //   172: invokevirtual b : ()F
    //   175: fsub
    //   176: fmul
    //   177: fadd
    //   178: f2i
    //   179: istore #13
    //   181: iconst_4
    //   182: istore #10
    //   184: aload #14
    //   186: astore_1
    //   187: iload #10
    //   189: bipush #16
    //   191: if_icmpgt -> 221
    //   194: iload #10
    //   196: i2f
    //   197: fstore_3
    //   198: aload_0
    //   199: fload_2
    //   200: iload #12
    //   202: iload #13
    //   204: fload_3
    //   205: invokevirtual a : (FIIF)Lcom/google/zxing/qrcode/detector/AlignmentPattern;
    //   208: astore_1
    //   209: goto -> 221
    //   212: iload #10
    //   214: iconst_1
    //   215: ishl
    //   216: istore #10
    //   218: goto -> 184
    //   221: aload #15
    //   223: aload #16
    //   225: aload #17
    //   227: aload_1
    //   228: iload #11
    //   230: invokestatic a : (Lcom/google/zxing/ResultPoint;Lcom/google/zxing/ResultPoint;Lcom/google/zxing/ResultPoint;Lcom/google/zxing/ResultPoint;I)Lcom/google/zxing/common/PerspectiveTransform;
    //   233: astore #14
    //   235: aload_0
    //   236: getfield a : Lcom/google/zxing/common/BitMatrix;
    //   239: aload #14
    //   241: iload #11
    //   243: invokestatic a : (Lcom/google/zxing/common/BitMatrix;Lcom/google/zxing/common/PerspectiveTransform;I)Lcom/google/zxing/common/BitMatrix;
    //   246: astore #14
    //   248: aload_1
    //   249: ifnonnull -> 275
    //   252: iconst_3
    //   253: anewarray com/google/zxing/ResultPoint
    //   256: astore_1
    //   257: aload_1
    //   258: iconst_0
    //   259: aload #17
    //   261: aastore
    //   262: aload_1
    //   263: iconst_1
    //   264: aload #15
    //   266: aastore
    //   267: aload_1
    //   268: iconst_2
    //   269: aload #16
    //   271: aastore
    //   272: goto -> 299
    //   275: iconst_4
    //   276: anewarray com/google/zxing/ResultPoint
    //   279: dup
    //   280: iconst_0
    //   281: aload #17
    //   283: aastore
    //   284: dup
    //   285: iconst_1
    //   286: aload #15
    //   288: aastore
    //   289: dup
    //   290: iconst_2
    //   291: aload #16
    //   293: aastore
    //   294: dup
    //   295: iconst_3
    //   296: aload_1
    //   297: aastore
    //   298: astore_1
    //   299: new com/google/zxing/common/DetectorResult
    //   302: dup
    //   303: aload #14
    //   305: aload_1
    //   306: invokespecial <init> : (Lcom/google/zxing/common/BitMatrix;[Lcom/google/zxing/ResultPoint;)V
    //   309: areturn
    //   310: invokestatic a : ()Lcom/google/zxing/NotFoundException;
    //   313: athrow
    //   314: astore_1
    //   315: goto -> 212
    // Exception table:
    //   from	to	target	type
    //   198	209	314	com/google/zxing/NotFoundException
  }
  
  public final DetectorResult a(Map<DecodeHintType, ?> paramMap) throws NotFoundException, FormatException {
    ResultPointCallback resultPointCallback;
    if (paramMap == null) {
      resultPointCallback = null;
    } else {
      resultPointCallback = (ResultPointCallback)paramMap.get(DecodeHintType.j);
    } 
    this.b = resultPointCallback;
    return a((new FinderPatternFinder(this.a, this.b)).a(paramMap));
  }
  
  protected final AlignmentPattern a(float paramFloat1, int paramInt1, int paramInt2, float paramFloat2) throws NotFoundException {
    int j = (int)(paramFloat2 * paramFloat1);
    int i = Math.max(0, paramInt1 - j);
    paramInt1 = Math.min(this.a.e() - 1, paramInt1 + j) - i;
    paramFloat2 = paramInt1;
    float f = 3.0F * paramFloat1;
    if (paramFloat2 >= f) {
      int k = Math.max(0, paramInt2 - j);
      paramInt2 = Math.min(this.a.f() - 1, paramInt2 + j) - k;
      if (paramInt2 >= f)
        return (new AlignmentPatternFinder(this.a, i, k, paramInt1, paramInt2, paramFloat1, this.b)).a(); 
      throw NotFoundException.a();
    } 
    throw NotFoundException.a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\qrcode\detector\Detector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */