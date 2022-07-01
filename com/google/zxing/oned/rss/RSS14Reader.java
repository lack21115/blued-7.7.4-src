package com.google.zxing.oned.rss;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.detector.MathUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class RSS14Reader extends AbstractRSSReader {
  private static final int[] a = new int[] { 1, 10, 34, 70, 126 };
  
  private static final int[] b = new int[] { 4, 20, 48, 81 };
  
  private static final int[] c = new int[] { 0, 161, 961, 2015, 2715 };
  
  private static final int[] d = new int[] { 0, 336, 1036, 1516 };
  
  private static final int[] e = new int[] { 8, 6, 4, 3, 1 };
  
  private static final int[] f = new int[] { 2, 4, 6, 8 };
  
  private static final int[][] g;
  
  private final List<Pair> h = new ArrayList<Pair>();
  
  private final List<Pair> i = new ArrayList<Pair>();
  
  static {
    int[] arrayOfInt1 = { 3, 5, 5, 1 };
    int[] arrayOfInt2 = { 2, 7, 4, 1 };
    int[] arrayOfInt3 = { 2, 3, 8, 1 };
    int[] arrayOfInt4 = { 1, 3, 9, 1 };
    g = new int[][] { { 3, 8, 2, 1 }, arrayOfInt1, { 3, 3, 7, 1 }, { 3, 1, 9, 1 }, arrayOfInt2, { 2, 5, 6, 1 }, arrayOfInt3, { 1, 5, 7, 1 }, arrayOfInt4 };
  }
  
  private static Result a(Pair paramPair1, Pair paramPair2) {
    String str2 = String.valueOf(paramPair1.a() * 4537077L + paramPair2.a());
    StringBuilder stringBuilder = new StringBuilder(14);
    int i;
    for (i = 13 - str2.length(); i > 0; i--)
      stringBuilder.append('0'); 
    stringBuilder.append(str2);
    i = 0;
    int j = 0;
    while (i < 13) {
      int m = stringBuilder.charAt(i) - 48;
      int k = m;
      if ((i & 0x1) == 0)
        k = m * 3; 
      j += k;
      i++;
    } 
    j = 10 - j % 10;
    i = j;
    if (j == 10)
      i = 0; 
    stringBuilder.append(i);
    ResultPoint[] arrayOfResultPoint2 = paramPair1.c().c();
    ResultPoint[] arrayOfResultPoint1 = paramPair2.c().c();
    String str1 = stringBuilder.toString();
    ResultPoint resultPoint1 = arrayOfResultPoint2[0];
    ResultPoint resultPoint3 = arrayOfResultPoint2[1];
    ResultPoint resultPoint4 = arrayOfResultPoint1[0];
    ResultPoint resultPoint2 = arrayOfResultPoint1[1];
    BarcodeFormat barcodeFormat = BarcodeFormat.m;
    return new Result(str1, null, new ResultPoint[] { resultPoint1, resultPoint3, resultPoint4, resultPoint2 }, barcodeFormat);
  }
  
  private DataCharacter a(BitArray paramBitArray, FinderPattern paramFinderPattern, boolean paramBoolean) throws NotFoundException {
    int[] arrayOfInt3 = c();
    int i;
    for (i = 0; i < arrayOfInt3.length; i++)
      arrayOfInt3[i] = 0; 
    if (paramBoolean) {
      b(paramBitArray, paramFinderPattern.b()[0], arrayOfInt3);
    } else {
      a(paramBitArray, paramFinderPattern.b()[1] + 1, arrayOfInt3);
      i = arrayOfInt3.length - 1;
      j = 0;
      while (j < i) {
        int i1 = arrayOfInt3[j];
        arrayOfInt3[j] = arrayOfInt3[i];
        arrayOfInt3[i] = i1;
        j++;
        i--;
      } 
    } 
    if (paramBoolean) {
      j = 16;
    } else {
      j = 15;
    } 
    float f = MathUtils.a(arrayOfInt3) / j;
    int[] arrayOfInt1 = f();
    int[] arrayOfInt2 = g();
    float[] arrayOfFloat1 = d();
    float[] arrayOfFloat2 = e();
    int k;
    for (k = 0; k < arrayOfInt3.length; k++) {
      float f1 = arrayOfInt3[k] / f;
      int i1 = (int)(0.5F + f1);
      if (i1 <= 0) {
        i = 1;
      } else {
        i = i1;
        if (i1 > 8)
          i = 8; 
      } 
      i1 = k / 2;
      if ((k & 0x1) == 0) {
        arrayOfInt1[i1] = i;
        arrayOfFloat1[i1] = f1 - i;
      } else {
        arrayOfInt2[i1] = i;
        arrayOfFloat2[i1] = f1 - i;
      } 
    } 
    a(paramBoolean, j);
    k = arrayOfInt1.length - 1;
    int j = 0;
    i = 0;
    while (k >= 0) {
      j = j * 9 + arrayOfInt1[k];
      i += arrayOfInt1[k];
      k--;
    } 
    int m = arrayOfInt2.length - 1;
    int n = 0;
    k = 0;
    while (m >= 0) {
      n = n * 9 + arrayOfInt2[m];
      k += arrayOfInt2[m];
      m--;
    } 
    j += n * 3;
    if (paramBoolean) {
      if ((i & 0x1) == 0 && i <= 12 && i >= 4) {
        i = (12 - i) / 2;
        m = e[i];
        k = RSSUtils.a(arrayOfInt1, m, false);
        m = RSSUtils.a(arrayOfInt2, 9 - m, true);
        return new DataCharacter(k * a[i] + m + c[i], j);
      } 
      throw NotFoundException.a();
    } 
    if ((k & 0x1) == 0 && k <= 10 && k >= 4) {
      i = (10 - k) / 2;
      k = f[i];
      m = RSSUtils.a(arrayOfInt1, k, true);
      return new DataCharacter(RSSUtils.a(arrayOfInt2, 9 - k, false) * b[i] + m + d[i], j);
    } 
    throw NotFoundException.a();
  }
  
  private FinderPattern a(BitArray paramBitArray, int paramInt, boolean paramBoolean, int[] paramArrayOfint) throws NotFoundException {
    boolean bool = paramBitArray.a(paramArrayOfint[0]);
    int i;
    for (i = paramArrayOfint[0] - 1; i >= 0 && bool != paramBitArray.a(i); i--);
    int k = i + 1;
    i = paramArrayOfint[0];
    int[] arrayOfInt = b();
    System.arraycopy(arrayOfInt, 0, arrayOfInt, 1, arrayOfInt.length - 1);
    arrayOfInt[0] = i - k;
    int m = a(arrayOfInt, g);
    int j = paramArrayOfint[1];
    if (paramBoolean) {
      i = paramBitArray.a();
      j = paramBitArray.a() - 1 - j;
      i = i - 1 - k;
    } else {
      i = k;
    } 
    return new FinderPattern(m, new int[] { k, paramArrayOfint[1] }, i, j, paramInt);
  }
  
  private Pair a(BitArray paramBitArray, boolean paramBoolean, int paramInt, Map<DecodeHintType, ?> paramMap) {
    try {
      ResultPointCallback resultPointCallback;
      int[] arrayOfInt = a(paramBitArray, paramBoolean);
      FinderPattern finderPattern = a(paramBitArray, paramInt, paramBoolean, arrayOfInt);
      if (paramMap == null) {
        paramMap = null;
      } else {
        resultPointCallback = (ResultPointCallback)paramMap.get(DecodeHintType.j);
      } 
      if (resultPointCallback != null) {
        float f2 = (arrayOfInt[0] + arrayOfInt[1]) / 2.0F;
        float f1 = f2;
        if (paramBoolean)
          f1 = (paramBitArray.a() - 1) - f2; 
        resultPointCallback.a(new ResultPoint(f1, paramInt));
      } 
      DataCharacter dataCharacter = a(paramBitArray, finderPattern, true);
      null = a(paramBitArray, finderPattern, false);
      return new Pair(dataCharacter.a() * 1597 + null.a(), dataCharacter.b() + null.b() * 4, finderPattern);
    } catch (NotFoundException notFoundException) {
      return null;
    } 
  }
  
  private static void a(Collection<Pair> paramCollection, Pair paramPair) {
    boolean bool1;
    if (paramPair == null)
      return; 
    boolean bool2 = false;
    Iterator<Pair> iterator = paramCollection.iterator();
    while (true) {
      bool1 = bool2;
      if (iterator.hasNext()) {
        Pair pair = iterator.next();
        if (pair.a() == paramPair.a()) {
          pair.e();
          bool1 = true;
          break;
        } 
        continue;
      } 
      break;
    } 
    if (!bool1)
      paramCollection.add(paramPair); 
  }
  
  private void a(boolean paramBoolean, int paramInt) throws NotFoundException {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual f : ()[I
    //   4: invokestatic a : ([I)I
    //   7: istore #9
    //   9: aload_0
    //   10: invokevirtual g : ()[I
    //   13: invokestatic a : ([I)I
    //   16: istore #10
    //   18: iconst_0
    //   19: istore #8
    //   21: iload_1
    //   22: ifeq -> 89
    //   25: iload #9
    //   27: bipush #12
    //   29: if_icmple -> 40
    //   32: iconst_0
    //   33: istore #4
    //   35: iconst_1
    //   36: istore_3
    //   37: goto -> 57
    //   40: iload #9
    //   42: iconst_4
    //   43: if_icmpge -> 52
    //   46: iconst_1
    //   47: istore #4
    //   49: goto -> 55
    //   52: iconst_0
    //   53: istore #4
    //   55: iconst_0
    //   56: istore_3
    //   57: iload #10
    //   59: bipush #12
    //   61: if_icmple -> 70
    //   64: iload_3
    //   65: istore #5
    //   67: goto -> 134
    //   70: iload #4
    //   72: istore #5
    //   74: iload_3
    //   75: istore #6
    //   77: iload #10
    //   79: iconst_4
    //   80: if_icmpge -> 167
    //   83: iload_3
    //   84: istore #7
    //   86: goto -> 162
    //   89: iload #9
    //   91: bipush #11
    //   93: if_icmple -> 104
    //   96: iconst_0
    //   97: istore_3
    //   98: iconst_1
    //   99: istore #4
    //   101: goto -> 120
    //   104: iload #9
    //   106: iconst_5
    //   107: if_icmpge -> 115
    //   110: iconst_1
    //   111: istore_3
    //   112: goto -> 117
    //   115: iconst_0
    //   116: istore_3
    //   117: iconst_0
    //   118: istore #4
    //   120: iload #10
    //   122: bipush #10
    //   124: if_icmple -> 142
    //   127: iload #4
    //   129: istore #5
    //   131: iload_3
    //   132: istore #4
    //   134: iconst_0
    //   135: istore_3
    //   136: iconst_1
    //   137: istore #6
    //   139: goto -> 184
    //   142: iload_3
    //   143: istore #5
    //   145: iload #4
    //   147: istore #6
    //   149: iload #10
    //   151: iconst_4
    //   152: if_icmpge -> 167
    //   155: iload #4
    //   157: istore #7
    //   159: iload_3
    //   160: istore #4
    //   162: iconst_1
    //   163: istore_3
    //   164: goto -> 177
    //   167: iconst_0
    //   168: istore_3
    //   169: iload #6
    //   171: istore #7
    //   173: iload #5
    //   175: istore #4
    //   177: iconst_0
    //   178: istore #6
    //   180: iload #7
    //   182: istore #5
    //   184: iload #9
    //   186: iload #10
    //   188: iadd
    //   189: iload_2
    //   190: isub
    //   191: istore #11
    //   193: iload #9
    //   195: iconst_1
    //   196: iand
    //   197: iload_1
    //   198: if_icmpne -> 206
    //   201: iconst_1
    //   202: istore_2
    //   203: goto -> 208
    //   206: iconst_0
    //   207: istore_2
    //   208: iload #8
    //   210: istore #7
    //   212: iload #10
    //   214: iconst_1
    //   215: iand
    //   216: iconst_1
    //   217: if_icmpne -> 223
    //   220: iconst_1
    //   221: istore #7
    //   223: iload #11
    //   225: iconst_1
    //   226: if_icmpne -> 263
    //   229: iload_2
    //   230: ifeq -> 248
    //   233: iload #7
    //   235: ifne -> 244
    //   238: iconst_1
    //   239: istore #5
    //   241: goto -> 343
    //   244: invokestatic a : ()Lcom/google/zxing/NotFoundException;
    //   247: athrow
    //   248: iload #7
    //   250: ifeq -> 259
    //   253: iconst_1
    //   254: istore #6
    //   256: goto -> 343
    //   259: invokestatic a : ()Lcom/google/zxing/NotFoundException;
    //   262: athrow
    //   263: iload #11
    //   265: iconst_m1
    //   266: if_icmpne -> 302
    //   269: iload_2
    //   270: ifeq -> 288
    //   273: iload #7
    //   275: ifne -> 284
    //   278: iconst_1
    //   279: istore #4
    //   281: goto -> 343
    //   284: invokestatic a : ()Lcom/google/zxing/NotFoundException;
    //   287: athrow
    //   288: iload #7
    //   290: ifeq -> 298
    //   293: iconst_1
    //   294: istore_3
    //   295: goto -> 343
    //   298: invokestatic a : ()Lcom/google/zxing/NotFoundException;
    //   301: athrow
    //   302: iload #11
    //   304: ifne -> 435
    //   307: iload_2
    //   308: ifeq -> 338
    //   311: iload #7
    //   313: ifeq -> 334
    //   316: iload #9
    //   318: iload #10
    //   320: if_icmpge -> 329
    //   323: iconst_1
    //   324: istore #4
    //   326: goto -> 253
    //   329: iconst_1
    //   330: istore_3
    //   331: goto -> 238
    //   334: invokestatic a : ()Lcom/google/zxing/NotFoundException;
    //   337: athrow
    //   338: iload #7
    //   340: ifne -> 431
    //   343: iload #4
    //   345: ifeq -> 371
    //   348: iload #5
    //   350: ifne -> 367
    //   353: aload_0
    //   354: invokevirtual f : ()[I
    //   357: aload_0
    //   358: invokevirtual d : ()[F
    //   361: invokestatic a : ([I[F)V
    //   364: goto -> 371
    //   367: invokestatic a : ()Lcom/google/zxing/NotFoundException;
    //   370: athrow
    //   371: iload #5
    //   373: ifeq -> 387
    //   376: aload_0
    //   377: invokevirtual f : ()[I
    //   380: aload_0
    //   381: invokevirtual d : ()[F
    //   384: invokestatic b : ([I[F)V
    //   387: iload_3
    //   388: ifeq -> 414
    //   391: iload #6
    //   393: ifne -> 410
    //   396: aload_0
    //   397: invokevirtual g : ()[I
    //   400: aload_0
    //   401: invokevirtual d : ()[F
    //   404: invokestatic a : ([I[F)V
    //   407: goto -> 414
    //   410: invokestatic a : ()Lcom/google/zxing/NotFoundException;
    //   413: athrow
    //   414: iload #6
    //   416: ifeq -> 430
    //   419: aload_0
    //   420: invokevirtual g : ()[I
    //   423: aload_0
    //   424: invokevirtual e : ()[F
    //   427: invokestatic b : ([I[F)V
    //   430: return
    //   431: invokestatic a : ()Lcom/google/zxing/NotFoundException;
    //   434: athrow
    //   435: invokestatic a : ()Lcom/google/zxing/NotFoundException;
    //   438: athrow
  }
  
  private int[] a(BitArray paramBitArray, int paramBoolean) throws NotFoundException {
    int i1;
    int[] arrayOfInt = b();
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    arrayOfInt[2] = 0;
    arrayOfInt[3] = 0;
    int n = paramBitArray.a();
    int i = 0;
    int i2 = 0;
    while (i < n) {
      int i3 = paramBitArray.a(i) ^ true;
      i2 = i3;
      if (paramBoolean != i3) {
        i++;
        i1 = i3;
      } 
    } 
    int j = i;
    int m = 0;
    int k = i;
    while (k < n) {
      if (paramBitArray.a(k) != i1) {
        arrayOfInt[m] = arrayOfInt[m] + 1;
        i = m;
      } else {
        if (m == 3) {
          if (a(arrayOfInt))
            return new int[] { j, k }; 
          j += arrayOfInt[0] + arrayOfInt[1];
          arrayOfInt[0] = arrayOfInt[2];
          arrayOfInt[1] = arrayOfInt[3];
          arrayOfInt[2] = 0;
          arrayOfInt[3] = 0;
          i = m - 1;
        } else {
          i = m + 1;
        } 
        arrayOfInt[i] = 1;
        int i3 = i1 ^ 0x1;
      } 
      k++;
      m = i;
    } 
    throw NotFoundException.a();
  }
  
  private static boolean b(Pair paramPair1, Pair paramPair2) {
    int k = paramPair1.b();
    int m = paramPair2.b();
    int j = paramPair1.c().a() * 9 + paramPair2.c().a();
    int i = j;
    if (j > 72)
      i = j - 1; 
    j = i;
    if (i > 8)
      j = i - 1; 
    return ((k + m * 16) % 79 == j);
  }
  
  public Result a(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap) throws NotFoundException {
    Pair pair2 = a(paramBitArray, false, paramInt, paramMap);
    a(this.h, pair2);
    paramBitArray.d();
    pair1 = a(paramBitArray, true, paramInt, paramMap);
    a(this.i, pair1);
    paramBitArray.d();
    for (Pair pair1 : this.h) {
      if (pair1.d() > 1)
        for (Pair pair : this.i) {
          if (pair.d() > 1 && b(pair1, pair))
            return a(pair1, pair); 
        }  
    } 
    throw NotFoundException.a();
  }
  
  public void a() {
    this.h.clear();
    this.i.clear();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\oned\rss\RSS14Reader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */