package com.google.zxing.aztec.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.aztec.AztecDetectorResult;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.common.detector.WhiteRectangleDetector;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;

public final class Detector {
  private static final int[] a = new int[] { 3808, 476, 2107, 1799 };
  
  private final BitMatrix b;
  
  private boolean c;
  
  private int d;
  
  private int e;
  
  private int f;
  
  private int g;
  
  public Detector(BitMatrix paramBitMatrix) {
    this.b = paramBitMatrix;
  }
  
  private static float a(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2) {
    return MathUtils.a(paramResultPoint1.a(), paramResultPoint1.b(), paramResultPoint2.a(), paramResultPoint2.b());
  }
  
  private static int a(long paramLong, boolean paramBoolean) throws NotFoundException {
    byte b;
    int i;
    if (paramBoolean) {
      i = 7;
      b = 2;
    } else {
      i = 10;
      b = 4;
    } 
    int[] arrayOfInt = new int[i];
    int j;
    for (j = i - 1; j >= 0; j--) {
      arrayOfInt[j] = (int)paramLong & 0xF;
      paramLong >>= 4L;
    } 
    try {
      (new ReedSolomonDecoder(GenericGF.d)).a(arrayOfInt, i - b);
      i = 0;
      j = 0;
      while (i < b) {
        j = (j << 4) + arrayOfInt[i];
        i++;
      } 
      return j;
    } catch (ReedSolomonException reedSolomonException) {
      throw NotFoundException.a();
    } 
  }
  
  private int a(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, int paramInt) {
    float f4 = a(paramResultPoint1, paramResultPoint2);
    float f5 = f4 / paramInt;
    float f1 = paramResultPoint1.a();
    float f2 = paramResultPoint1.b();
    float f3 = (paramResultPoint2.a() - paramResultPoint1.a()) * f5 / f4;
    f4 = f5 * (paramResultPoint2.b() - paramResultPoint1.b()) / f4;
    int i = 0;
    int j;
    for (j = 0; i < paramInt; j = k) {
      BitMatrix bitMatrix = this.b;
      f5 = i;
      int k = j;
      if (bitMatrix.a(MathUtils.a(f5 * f3 + f1), MathUtils.a(f5 * f4 + f2)))
        k = j | 1 << paramInt - i - 1; 
      i++;
    } 
    return j;
  }
  
  private int a(Point paramPoint1, Point paramPoint2) {
    float f3 = b(paramPoint1, paramPoint2);
    float f4 = (paramPoint2.b() - paramPoint1.b()) / f3;
    float f5 = (paramPoint2.c() - paramPoint1.c()) / f3;
    float f1 = paramPoint1.b();
    float f2 = paramPoint1.c();
    boolean bool2 = this.b.a(paramPoint1.b(), paramPoint1.c());
    int k = (int)Math.ceil(f3);
    boolean bool1 = false;
    int i = 0;
    int j;
    for (j = 0; i < k; j = m) {
      f1 += f4;
      f2 += f5;
      int m = j;
      if (this.b.a(MathUtils.a(f1), MathUtils.a(f2)) != bool2)
        m = j + 1; 
      i++;
    } 
    f1 = j / f3;
    if (f1 > 0.1F && f1 < 0.9F)
      return 0; 
    if (f1 <= 0.1F)
      bool1 = true; 
    return (bool1 == bool2) ? 1 : -1;
  }
  
  private static int a(int[] paramArrayOfint, int paramInt) throws NotFoundException {
    int k = paramArrayOfint.length;
    boolean bool = false;
    int j = 0;
    int i = 0;
    while (j < k) {
      int m = paramArrayOfint[j];
      i = (i << 3) + (m >> paramInt - 2 << 1) + (m & 0x1);
      j++;
    } 
    for (paramInt = bool; paramInt < 4; paramInt++) {
      if (Integer.bitCount(a[paramInt] ^ ((i & 0x1) << 11) + (i >> 1)) <= 2)
        return paramInt; 
    } 
    throw NotFoundException.a();
  }
  
  private Point a() {
    ResultPoint resultPoint1;
    ResultPoint resultPoint2;
    ResultPoint resultPoint3;
    ResultPoint resultPoint4;
    try {
      ResultPoint[] arrayOfResultPoint = (new WhiteRectangleDetector(this.b)).a();
      resultPoint2 = arrayOfResultPoint[0];
      resultPoint3 = arrayOfResultPoint[1];
      resultPoint4 = arrayOfResultPoint[2];
      resultPoint1 = arrayOfResultPoint[3];
    } catch (NotFoundException notFoundException) {
      int m = this.b.e() / 2;
      int i1 = this.b.f() / 2;
      int n = m + 7;
      int k = i1 - 7;
      resultPoint1 = a(new Point(n, k), false, 1, -1).a();
      i1 += 7;
      resultPoint3 = a(new Point(n, i1), false, 1, 1).a();
      m -= 7;
      resultPoint4 = a(new Point(m, i1), false, -1, 1).a();
      ResultPoint resultPoint = a(new Point(m, k), false, -1, -1).a();
      resultPoint2 = resultPoint1;
      resultPoint1 = resultPoint;
    } 
    int i = MathUtils.a((resultPoint2.a() + resultPoint1.a() + resultPoint3.a() + resultPoint4.a()) / 4.0F);
    int j = MathUtils.a((resultPoint2.b() + resultPoint1.b() + resultPoint3.b() + resultPoint4.b()) / 4.0F);
    try {
      ResultPoint[] arrayOfResultPoint = (new WhiteRectangleDetector(this.b, 15, i, j)).a();
      resultPoint3 = arrayOfResultPoint[0];
      resultPoint4 = arrayOfResultPoint[1];
      resultPoint2 = arrayOfResultPoint[2];
      ResultPoint resultPoint = arrayOfResultPoint[3];
    } catch (NotFoundException notFoundException) {
      int m = i + 7;
      int k = j - 7;
      resultPoint3 = a(new Point(m, k), false, 1, -1).a();
      j += 7;
      resultPoint4 = a(new Point(m, j), false, 1, 1).a();
      i -= 7;
      resultPoint2 = a(new Point(i, j), false, -1, 1).a();
      ResultPoint resultPoint = a(new Point(i, k), false, -1, -1).a();
    } 
  }
  
  private Point a(Point paramPoint, boolean paramBoolean, int paramInt1, int paramInt2) {
    int i = paramPoint.b() + paramInt1;
    int j = paramPoint.c();
    while (true) {
      j += paramInt2;
      if (a(i, j) && this.b.a(i, j) == paramBoolean) {
        i += paramInt1;
        continue;
      } 
      break;
    } 
    i -= paramInt1;
    j -= paramInt2;
    while (a(i, j) && this.b.a(i, j) == paramBoolean)
      i += paramInt1; 
    i -= paramInt1;
    for (paramInt1 = j; a(i, paramInt1) && this.b.a(i, paramInt1) == paramBoolean; paramInt1 += paramInt2);
    return new Point(i, paramInt1 - paramInt2);
  }
  
  private BitMatrix a(BitMatrix paramBitMatrix, ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3, ResultPoint paramResultPoint4) throws NotFoundException {
    GridSampler gridSampler = GridSampler.a();
    int i = b();
    float f2 = i / 2.0F;
    int j = this.f;
    float f1 = f2 - j;
    f2 += j;
    return gridSampler.a(paramBitMatrix, i, i, f1, f1, f2, f1, f2, f2, f1, f2, paramResultPoint1.a(), paramResultPoint1.b(), paramResultPoint2.a(), paramResultPoint2.b(), paramResultPoint3.a(), paramResultPoint3.b(), paramResultPoint4.a(), paramResultPoint4.b());
  }
  
  private void a(ResultPoint[] paramArrayOfResultPoint) throws NotFoundException {
    int i = 0;
    if (a(paramArrayOfResultPoint[0]) && a(paramArrayOfResultPoint[1]) && a(paramArrayOfResultPoint[2]) && a(paramArrayOfResultPoint[3])) {
      int j = this.f * 2;
      int[] arrayOfInt = new int[4];
      arrayOfInt[0] = a(paramArrayOfResultPoint[0], paramArrayOfResultPoint[1], j);
      arrayOfInt[1] = a(paramArrayOfResultPoint[1], paramArrayOfResultPoint[2], j);
      arrayOfInt[2] = a(paramArrayOfResultPoint[2], paramArrayOfResultPoint[3], j);
      arrayOfInt[3] = a(paramArrayOfResultPoint[3], paramArrayOfResultPoint[0], j);
      this.g = a(arrayOfInt, j);
      long l = 0L;
      while (i < 4) {
        long l1;
        j = arrayOfInt[(this.g + i) % 4];
        if (this.c) {
          l <<= 7L;
          l1 = (j >> 1 & 0x7F);
        } else {
          l <<= 10L;
          l1 = ((j >> 2 & 0x3E0) + (j >> 1 & 0x1F));
        } 
        l += l1;
        i++;
      } 
      i = a(l, this.c);
      if (this.c) {
        this.d = (i >> 6) + 1;
        this.e = (i & 0x3F) + 1;
        return;
      } 
      this.d = (i >> 11) + 1;
      this.e = (i & 0x7FF) + 1;
      return;
    } 
    throw NotFoundException.a();
  }
  
  private boolean a(int paramInt1, int paramInt2) {
    return (paramInt1 >= 0 && paramInt1 < this.b.e() && paramInt2 > 0 && paramInt2 < this.b.f());
  }
  
  private boolean a(ResultPoint paramResultPoint) {
    return a(MathUtils.a(paramResultPoint.a()), MathUtils.a(paramResultPoint.b()));
  }
  
  private boolean a(Point paramPoint1, Point paramPoint2, Point paramPoint3, Point paramPoint4) {
    paramPoint1 = new Point(paramPoint1.b() - 3, paramPoint1.c() + 3);
    paramPoint2 = new Point(paramPoint2.b() - 3, paramPoint2.c() - 3);
    paramPoint3 = new Point(paramPoint3.b() + 3, paramPoint3.c() - 3);
    paramPoint4 = new Point(paramPoint4.b() + 3, paramPoint4.c() + 3);
    int i = a(paramPoint4, paramPoint1);
    return (i == 0) ? false : ((a(paramPoint1, paramPoint2) != i) ? false : ((a(paramPoint2, paramPoint3) != i) ? false : ((a(paramPoint3, paramPoint4) == i))));
  }
  
  private ResultPoint[] a(Point paramPoint) throws NotFoundException {
    // Byte code:
    //   0: aload_0
    //   1: iconst_1
    //   2: putfield f : I
    //   5: aload_1
    //   6: astore #6
    //   8: aload #6
    //   10: astore #7
    //   12: aload #7
    //   14: astore #8
    //   16: iconst_1
    //   17: istore #5
    //   19: aload_0
    //   20: getfield f : I
    //   23: bipush #9
    //   25: if_icmpge -> 178
    //   28: aload_0
    //   29: aload_1
    //   30: iload #5
    //   32: iconst_1
    //   33: iconst_m1
    //   34: invokespecial a : (Lcom/google/zxing/aztec/detector/Detector$Point;ZII)Lcom/google/zxing/aztec/detector/Detector$Point;
    //   37: astore #11
    //   39: aload_0
    //   40: aload #6
    //   42: iload #5
    //   44: iconst_1
    //   45: iconst_1
    //   46: invokespecial a : (Lcom/google/zxing/aztec/detector/Detector$Point;ZII)Lcom/google/zxing/aztec/detector/Detector$Point;
    //   49: astore #10
    //   51: aload_0
    //   52: aload #7
    //   54: iload #5
    //   56: iconst_m1
    //   57: iconst_1
    //   58: invokespecial a : (Lcom/google/zxing/aztec/detector/Detector$Point;ZII)Lcom/google/zxing/aztec/detector/Detector$Point;
    //   61: astore #9
    //   63: aload_0
    //   64: aload #8
    //   66: iload #5
    //   68: iconst_m1
    //   69: iconst_m1
    //   70: invokespecial a : (Lcom/google/zxing/aztec/detector/Detector$Point;ZII)Lcom/google/zxing/aztec/detector/Detector$Point;
    //   73: astore #12
    //   75: aload_0
    //   76: getfield f : I
    //   79: iconst_2
    //   80: if_icmple -> 144
    //   83: aload #12
    //   85: aload #11
    //   87: invokestatic b : (Lcom/google/zxing/aztec/detector/Detector$Point;Lcom/google/zxing/aztec/detector/Detector$Point;)F
    //   90: aload_0
    //   91: getfield f : I
    //   94: i2f
    //   95: fmul
    //   96: aload #8
    //   98: aload_1
    //   99: invokestatic b : (Lcom/google/zxing/aztec/detector/Detector$Point;Lcom/google/zxing/aztec/detector/Detector$Point;)F
    //   102: aload_0
    //   103: getfield f : I
    //   106: iconst_2
    //   107: iadd
    //   108: i2f
    //   109: fmul
    //   110: fdiv
    //   111: f2d
    //   112: dstore_2
    //   113: dload_2
    //   114: ldc2_w 0.75
    //   117: dcmpg
    //   118: iflt -> 178
    //   121: dload_2
    //   122: ldc2_w 1.25
    //   125: dcmpl
    //   126: ifgt -> 178
    //   129: aload_0
    //   130: aload #11
    //   132: aload #10
    //   134: aload #9
    //   136: aload #12
    //   138: invokespecial a : (Lcom/google/zxing/aztec/detector/Detector$Point;Lcom/google/zxing/aztec/detector/Detector$Point;Lcom/google/zxing/aztec/detector/Detector$Point;Lcom/google/zxing/aztec/detector/Detector$Point;)Z
    //   141: ifeq -> 178
    //   144: iload #5
    //   146: iconst_1
    //   147: ixor
    //   148: istore #5
    //   150: aload_0
    //   151: aload_0
    //   152: getfield f : I
    //   155: iconst_1
    //   156: iadd
    //   157: putfield f : I
    //   160: aload #12
    //   162: astore #8
    //   164: aload #11
    //   166: astore_1
    //   167: aload #10
    //   169: astore #6
    //   171: aload #9
    //   173: astore #7
    //   175: goto -> 19
    //   178: aload_0
    //   179: getfield f : I
    //   182: istore #4
    //   184: iload #4
    //   186: iconst_5
    //   187: if_icmpeq -> 204
    //   190: iload #4
    //   192: bipush #7
    //   194: if_icmpne -> 200
    //   197: goto -> 204
    //   200: invokestatic a : ()Lcom/google/zxing/NotFoundException;
    //   203: athrow
    //   204: aload_0
    //   205: getfield f : I
    //   208: iconst_5
    //   209: if_icmpne -> 218
    //   212: iconst_1
    //   213: istore #5
    //   215: goto -> 221
    //   218: iconst_0
    //   219: istore #5
    //   221: aload_0
    //   222: iload #5
    //   224: putfield c : Z
    //   227: new com/google/zxing/ResultPoint
    //   230: dup
    //   231: aload_1
    //   232: invokevirtual b : ()I
    //   235: i2f
    //   236: ldc 0.5
    //   238: fadd
    //   239: aload_1
    //   240: invokevirtual c : ()I
    //   243: i2f
    //   244: ldc 0.5
    //   246: fsub
    //   247: invokespecial <init> : (FF)V
    //   250: astore_1
    //   251: new com/google/zxing/ResultPoint
    //   254: dup
    //   255: aload #6
    //   257: invokevirtual b : ()I
    //   260: i2f
    //   261: ldc 0.5
    //   263: fadd
    //   264: aload #6
    //   266: invokevirtual c : ()I
    //   269: i2f
    //   270: ldc 0.5
    //   272: fadd
    //   273: invokespecial <init> : (FF)V
    //   276: astore #6
    //   278: new com/google/zxing/ResultPoint
    //   281: dup
    //   282: aload #7
    //   284: invokevirtual b : ()I
    //   287: i2f
    //   288: ldc 0.5
    //   290: fsub
    //   291: aload #7
    //   293: invokevirtual c : ()I
    //   296: i2f
    //   297: ldc 0.5
    //   299: fadd
    //   300: invokespecial <init> : (FF)V
    //   303: astore #7
    //   305: new com/google/zxing/ResultPoint
    //   308: dup
    //   309: aload #8
    //   311: invokevirtual b : ()I
    //   314: i2f
    //   315: ldc 0.5
    //   317: fsub
    //   318: aload #8
    //   320: invokevirtual c : ()I
    //   323: i2f
    //   324: ldc 0.5
    //   326: fsub
    //   327: invokespecial <init> : (FF)V
    //   330: astore #8
    //   332: aload_0
    //   333: getfield f : I
    //   336: istore #4
    //   338: iconst_4
    //   339: anewarray com/google/zxing/ResultPoint
    //   342: dup
    //   343: iconst_0
    //   344: aload_1
    //   345: aastore
    //   346: dup
    //   347: iconst_1
    //   348: aload #6
    //   350: aastore
    //   351: dup
    //   352: iconst_2
    //   353: aload #7
    //   355: aastore
    //   356: dup
    //   357: iconst_3
    //   358: aload #8
    //   360: aastore
    //   361: iload #4
    //   363: iconst_2
    //   364: imul
    //   365: iconst_3
    //   366: isub
    //   367: iload #4
    //   369: iconst_2
    //   370: imul
    //   371: invokestatic a : ([Lcom/google/zxing/ResultPoint;II)[Lcom/google/zxing/ResultPoint;
    //   374: areturn
  }
  
  private static ResultPoint[] a(ResultPoint[] paramArrayOfResultPoint, int paramInt1, int paramInt2) {
    float f1 = paramInt2 / paramInt1 * 2.0F;
    float f6 = paramArrayOfResultPoint[0].a();
    float f7 = paramArrayOfResultPoint[2].a();
    float f4 = paramArrayOfResultPoint[0].b();
    float f5 = paramArrayOfResultPoint[2].b();
    float f2 = (paramArrayOfResultPoint[0].a() + paramArrayOfResultPoint[2].a()) / 2.0F;
    float f3 = (paramArrayOfResultPoint[0].b() + paramArrayOfResultPoint[2].b()) / 2.0F;
    f6 = (f6 - f7) * f1;
    f4 = (f4 - f5) * f1;
    ResultPoint resultPoint1 = new ResultPoint(f2 + f6, f3 + f4);
    ResultPoint resultPoint2 = new ResultPoint(f2 - f6, f3 - f4);
    f6 = paramArrayOfResultPoint[1].a();
    f7 = paramArrayOfResultPoint[3].a();
    f4 = paramArrayOfResultPoint[1].b();
    f5 = paramArrayOfResultPoint[3].b();
    f2 = (paramArrayOfResultPoint[1].a() + paramArrayOfResultPoint[3].a()) / 2.0F;
    f3 = (paramArrayOfResultPoint[1].b() + paramArrayOfResultPoint[3].b()) / 2.0F;
    f6 = (f6 - f7) * f1;
    f1 *= f4 - f5;
    return new ResultPoint[] { resultPoint1, new ResultPoint(f2 + f6, f3 + f1), resultPoint2, new ResultPoint(f2 - f6, f3 - f1) };
  }
  
  private static float b(Point paramPoint1, Point paramPoint2) {
    return MathUtils.a(paramPoint1.b(), paramPoint1.c(), paramPoint2.b(), paramPoint2.c());
  }
  
  private int b() {
    if (this.c)
      return this.d * 4 + 11; 
    int i = this.d;
    return (i <= 4) ? (i * 4 + 15) : (i * 4 + ((i - 4) / 8 + 1) * 2 + 15);
  }
  
  private ResultPoint[] b(ResultPoint[] paramArrayOfResultPoint) {
    return a(paramArrayOfResultPoint, this.f * 2, b());
  }
  
  public AztecDetectorResult a(boolean paramBoolean) throws NotFoundException {
    ResultPoint[] arrayOfResultPoint = a(a());
    if (paramBoolean) {
      ResultPoint resultPoint = arrayOfResultPoint[0];
      arrayOfResultPoint[0] = arrayOfResultPoint[2];
      arrayOfResultPoint[2] = resultPoint;
    } 
    a(arrayOfResultPoint);
    BitMatrix bitMatrix = this.b;
    int i = this.g;
    return new AztecDetectorResult(a(bitMatrix, arrayOfResultPoint[i % 4], arrayOfResultPoint[(i + 1) % 4], arrayOfResultPoint[(i + 2) % 4], arrayOfResultPoint[(i + 3) % 4]), b(arrayOfResultPoint), this.c, this.e, this.d);
  }
  
  static final class Point {
    private final int a;
    
    private final int b;
    
    Point(int param1Int1, int param1Int2) {
      this.a = param1Int1;
      this.b = param1Int2;
    }
    
    ResultPoint a() {
      return new ResultPoint(b(), c());
    }
    
    int b() {
      return this.a;
    }
    
    int c() {
      return this.b;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder("<");
      stringBuilder.append(this.a);
      stringBuilder.append(' ');
      stringBuilder.append(this.b);
      stringBuilder.append('>');
      return stringBuilder.toString();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\aztec\detector\Detector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */