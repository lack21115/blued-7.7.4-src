package com.google.zxing.oned.rss.expanded;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.oned.rss.AbstractRSSReader;
import com.google.zxing.oned.rss.DataCharacter;
import com.google.zxing.oned.rss.FinderPattern;
import com.google.zxing.oned.rss.RSSUtils;
import com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class RSSExpandedReader extends AbstractRSSReader {
  private static final int[] a = new int[] { 7, 5, 4, 3, 1 };
  
  private static final int[] b = new int[] { 4, 20, 52, 104, 204 };
  
  private static final int[] c = new int[] { 0, 348, 1388, 2948, 3988 };
  
  private static final int[][] d = new int[][] { { 1, 8, 4, 1 }, { 3, 6, 4, 1 }, { 3, 4, 6, 1 }, { 3, 2, 8, 1 }, { 2, 6, 5, 1 }, { 2, 2, 9, 1 } };
  
  private static final int[][] e;
  
  private static final int[][] f;
  
  private final List<ExpandedPair> g = new ArrayList<ExpandedPair>(11);
  
  private final List<ExpandedRow> h = new ArrayList<ExpandedRow>();
  
  private final int[] i = new int[2];
  
  private boolean j;
  
  static {
    int[] arrayOfInt1 = { 1, 3, 9, 27, 81, 32, 96, 77 };
    int[] arrayOfInt2 = { 189, 145, 13, 39, 117, 140, 209, 205 };
    int[] arrayOfInt3 = { 193, 157, 49, 147, 19, 57, 171, 91 };
    int[] arrayOfInt4 = { 185, 133, 188, 142, 4, 12, 36, 108 };
    int[] arrayOfInt5 = { 113, 128, 173, 97, 80, 29, 87, 50 };
    int[] arrayOfInt6 = { 150, 28, 84, 41, 123, 158, 52, 156 };
    int[] arrayOfInt7 = { 46, 138, 203, 187, 139, 206, 196, 166 };
    int[] arrayOfInt8 = { 43, 129, 176, 106, 107, 110, 119, 146 };
    int[] arrayOfInt9 = { 16, 48, 144, 10, 30, 90, 59, 177 };
    int[] arrayOfInt10 = { 109, 116, 137, 200, 178, 112, 125, 164 };
    int[] arrayOfInt11 = { 148, 22, 66, 198, 172, 94, 71, 2 };
    int[] arrayOfInt12 = { 6, 18, 54, 162, 64, 192, 154, 40 };
    int[] arrayOfInt13 = { 79, 26, 78, 23, 69, 207, 199, 175 };
    int[] arrayOfInt14 = { 103, 98, 83, 38, 114, 131, 182, 124 };
    int[] arrayOfInt15 = { 161, 61, 183, 127, 170, 88, 53, 159 };
    int[] arrayOfInt16 = { 55, 165, 73, 8, 24, 72, 5, 15 };
    int[] arrayOfInt17 = { 45, 135, 194, 160, 58, 174, 100, 89 };
    e = new int[][] { 
        arrayOfInt1, { 20, 60, 180, 118, 143, 7, 21, 63 }, arrayOfInt2, arrayOfInt3, { 62, 186, 136, 197, 169, 85, 44, 132 }, arrayOfInt4, arrayOfInt5, arrayOfInt6, arrayOfInt7, { 76, 17, 51, 153, 37, 111, 122, 155 }, 
        arrayOfInt8, arrayOfInt9, arrayOfInt10, { 70, 210, 208, 202, 184, 130, 179, 115 }, { 134, 191, 151, 31, 93, 68, 204, 190 }, arrayOfInt11, arrayOfInt12, { 120, 149, 25, 75, 14, 42, 126, 167 }, arrayOfInt13, arrayOfInt14, 
        arrayOfInt15, arrayOfInt16, arrayOfInt17 };
    arrayOfInt1 = new int[] { 0, 4, 1, 3, 4, 5, 5 };
    arrayOfInt2 = new int[] { 
        0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 
        5 };
    f = new int[][] { { 0, 0 }, { 0, 1, 1 }, { 0, 2, 1, 3 }, { 0, 4, 1, 3, 2 }, { 0, 4, 1, 3, 3, 5 }, arrayOfInt1, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 4, 4 }, { 0, 0, 1, 1, 2, 2, 3, 4, 5, 5 }, arrayOfInt2 };
  }
  
  private static int a(BitArray paramBitArray, int paramInt) {
    return paramBitArray.a(paramInt) ? paramBitArray.c(paramBitArray.d(paramInt)) : paramBitArray.d(paramBitArray.c(paramInt));
  }
  
  static Result a(List<ExpandedPair> paramList) throws NotFoundException, FormatException {
    String str = AbstractExpandedDecoder.a(BitArrayBuilder.a(paramList)).a();
    ResultPoint[] arrayOfResultPoint1 = ((ExpandedPair)paramList.get(0)).c().c();
    ResultPoint[] arrayOfResultPoint2 = ((ExpandedPair)paramList.get(paramList.size() - 1)).c().c();
    ResultPoint resultPoint1 = arrayOfResultPoint1[0];
    ResultPoint resultPoint2 = arrayOfResultPoint1[1];
    ResultPoint resultPoint3 = arrayOfResultPoint2[0];
    ResultPoint resultPoint4 = arrayOfResultPoint2[1];
    BarcodeFormat barcodeFormat = BarcodeFormat.n;
    return new Result(str, null, new ResultPoint[] { resultPoint1, resultPoint2, resultPoint3, resultPoint4 }, barcodeFormat);
  }
  
  private FinderPattern a(BitArray paramBitArray, int paramInt, boolean paramBoolean) {
    int i;
    int j;
    int k;
    if (paramBoolean) {
      for (i = this.i[0] - 1; i >= 0 && !paramBitArray.a(i); i--);
      k = i + 1;
      arrayOfInt = this.i;
      int m = arrayOfInt[0];
      j = arrayOfInt[1];
      i = k;
      k = m - k;
    } else {
      int[] arrayOfInt1 = this.i;
      i = arrayOfInt1[0];
      j = arrayOfInt.d(arrayOfInt1[1] + 1);
      k = j - this.i[1];
    } 
    int[] arrayOfInt = b();
    System.arraycopy(arrayOfInt, 0, arrayOfInt, 1, arrayOfInt.length - 1);
    arrayOfInt[0] = k;
    try {
      k = a(arrayOfInt, d);
      return new FinderPattern(k, new int[] { i, j }, i, j, paramInt);
    } catch (NotFoundException notFoundException) {
      return null;
    } 
  }
  
  private List<ExpandedPair> a(List<ExpandedRow> paramList, int paramInt) throws NotFoundException {
    while (true) {
      if (paramInt < this.h.size()) {
        ExpandedRow expandedRow = this.h.get(paramInt);
        this.g.clear();
        for (ExpandedRow expandedRow1 : paramList)
          this.g.addAll(expandedRow1.a()); 
        this.g.addAll(expandedRow.a());
        if (b(this.g)) {
          if (h())
            return this.g; 
          ArrayList<ExpandedRow> arrayList = new ArrayList<ExpandedRow>(paramList);
          arrayList.add(expandedRow);
          try {
            return a(arrayList, paramInt + 1);
          } catch (NotFoundException notFoundException) {}
        } 
        paramInt++;
        continue;
      } 
      throw NotFoundException.a();
    } 
  }
  
  private List<ExpandedPair> a(boolean paramBoolean) {
    int i = this.h.size();
    List<ExpandedPair> list = null;
    if (i > 25) {
      this.h.clear();
      return null;
    } 
    this.g.clear();
    if (paramBoolean)
      Collections.reverse(this.h); 
    try {
      List<ExpandedPair> list1 = a(new ArrayList<ExpandedRow>(), 0);
      list = list1;
    } catch (NotFoundException notFoundException) {}
    if (paramBoolean)
      Collections.reverse(this.h); 
    return list;
  }
  
  private void a(int paramInt) throws NotFoundException {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual f : ()[I
    //   4: invokestatic a : ([I)I
    //   7: istore #7
    //   9: aload_0
    //   10: invokevirtual g : ()[I
    //   13: invokestatic a : ([I)I
    //   16: istore #8
    //   18: iconst_0
    //   19: istore #6
    //   21: iload #7
    //   23: bipush #13
    //   25: if_icmple -> 34
    //   28: iconst_1
    //   29: istore #4
    //   31: goto -> 54
    //   34: iconst_0
    //   35: istore_2
    //   36: iconst_0
    //   37: istore #4
    //   39: iload #7
    //   41: iconst_4
    //   42: if_icmpge -> 54
    //   45: iconst_1
    //   46: istore #5
    //   48: iload_2
    //   49: istore #4
    //   51: goto -> 57
    //   54: iconst_0
    //   55: istore #5
    //   57: iload #8
    //   59: bipush #13
    //   61: if_icmple -> 71
    //   64: iconst_0
    //   65: istore_2
    //   66: iconst_1
    //   67: istore_3
    //   68: goto -> 86
    //   71: iload #8
    //   73: iconst_4
    //   74: if_icmpge -> 82
    //   77: iconst_1
    //   78: istore_2
    //   79: goto -> 84
    //   82: iconst_0
    //   83: istore_2
    //   84: iconst_0
    //   85: istore_3
    //   86: iload #7
    //   88: iload #8
    //   90: iadd
    //   91: iload_1
    //   92: isub
    //   93: istore #9
    //   95: iload #7
    //   97: iconst_1
    //   98: iand
    //   99: iconst_1
    //   100: if_icmpne -> 108
    //   103: iconst_1
    //   104: istore_1
    //   105: goto -> 110
    //   108: iconst_0
    //   109: istore_1
    //   110: iload #8
    //   112: iconst_1
    //   113: iand
    //   114: ifne -> 120
    //   117: iconst_1
    //   118: istore #6
    //   120: iload #9
    //   122: iconst_1
    //   123: if_icmpne -> 159
    //   126: iload_1
    //   127: ifeq -> 145
    //   130: iload #6
    //   132: ifne -> 141
    //   135: iconst_1
    //   136: istore #4
    //   138: goto -> 238
    //   141: invokestatic a : ()Lcom/google/zxing/NotFoundException;
    //   144: athrow
    //   145: iload #6
    //   147: ifeq -> 155
    //   150: iconst_1
    //   151: istore_3
    //   152: goto -> 238
    //   155: invokestatic a : ()Lcom/google/zxing/NotFoundException;
    //   158: athrow
    //   159: iload #9
    //   161: iconst_m1
    //   162: if_icmpne -> 198
    //   165: iload_1
    //   166: ifeq -> 184
    //   169: iload #6
    //   171: ifne -> 180
    //   174: iconst_1
    //   175: istore #5
    //   177: goto -> 238
    //   180: invokestatic a : ()Lcom/google/zxing/NotFoundException;
    //   183: athrow
    //   184: iload #6
    //   186: ifeq -> 194
    //   189: iconst_1
    //   190: istore_2
    //   191: goto -> 238
    //   194: invokestatic a : ()Lcom/google/zxing/NotFoundException;
    //   197: athrow
    //   198: iload #9
    //   200: ifne -> 328
    //   203: iload_1
    //   204: ifeq -> 233
    //   207: iload #6
    //   209: ifeq -> 229
    //   212: iload #7
    //   214: iload #8
    //   216: if_icmpge -> 224
    //   219: iconst_1
    //   220: istore_3
    //   221: goto -> 174
    //   224: iconst_1
    //   225: istore_2
    //   226: goto -> 135
    //   229: invokestatic a : ()Lcom/google/zxing/NotFoundException;
    //   232: athrow
    //   233: iload #6
    //   235: ifne -> 324
    //   238: iload #5
    //   240: ifeq -> 266
    //   243: iload #4
    //   245: ifne -> 262
    //   248: aload_0
    //   249: invokevirtual f : ()[I
    //   252: aload_0
    //   253: invokevirtual d : ()[F
    //   256: invokestatic a : ([I[F)V
    //   259: goto -> 266
    //   262: invokestatic a : ()Lcom/google/zxing/NotFoundException;
    //   265: athrow
    //   266: iload #4
    //   268: ifeq -> 282
    //   271: aload_0
    //   272: invokevirtual f : ()[I
    //   275: aload_0
    //   276: invokevirtual d : ()[F
    //   279: invokestatic b : ([I[F)V
    //   282: iload_2
    //   283: ifeq -> 308
    //   286: iload_3
    //   287: ifne -> 304
    //   290: aload_0
    //   291: invokevirtual g : ()[I
    //   294: aload_0
    //   295: invokevirtual d : ()[F
    //   298: invokestatic a : ([I[F)V
    //   301: goto -> 308
    //   304: invokestatic a : ()Lcom/google/zxing/NotFoundException;
    //   307: athrow
    //   308: iload_3
    //   309: ifeq -> 323
    //   312: aload_0
    //   313: invokevirtual g : ()[I
    //   316: aload_0
    //   317: invokevirtual e : ()[F
    //   320: invokestatic b : ([I[F)V
    //   323: return
    //   324: invokestatic a : ()Lcom/google/zxing/NotFoundException;
    //   327: athrow
    //   328: invokestatic a : ()Lcom/google/zxing/NotFoundException;
    //   331: athrow
  }
  
  private void a(int paramInt, boolean paramBoolean) {
    boolean bool2;
    boolean bool3 = false;
    int i = 0;
    boolean bool1 = false;
    while (true) {
      bool2 = bool3;
      if (i < this.h.size()) {
        ExpandedRow expandedRow = this.h.get(i);
        if (expandedRow.b() > paramInt) {
          bool2 = expandedRow.a(this.g);
          break;
        } 
        bool1 = expandedRow.a(this.g);
        i++;
        continue;
      } 
      break;
    } 
    if (!bool2) {
      if (bool1)
        return; 
      if (a(this.g, this.h))
        return; 
      this.h.add(i, new ExpandedRow(this.g, paramInt, paramBoolean));
      a(this.g, this.h);
    } 
  }
  
  private static void a(List<ExpandedPair> paramList, List<ExpandedRow> paramList1) {
    Iterator<ExpandedRow> iterator = paramList1.iterator();
    while (true) {
      boolean bool;
      if (iterator.hasNext()) {
        ExpandedRow expandedRow = iterator.next();
        if (expandedRow.a().size() != paramList.size()) {
          Iterator<ExpandedPair> iterator1 = expandedRow.a().iterator();
          while (true) {
            boolean bool2 = iterator1.hasNext();
            boolean bool1 = false;
            bool = true;
            if (bool2) {
              ExpandedPair expandedPair = iterator1.next();
              Iterator<ExpandedPair> iterator2 = paramList.iterator();
              while (true) {
                if (iterator2.hasNext()) {
                  if (expandedPair.equals(iterator2.next()))
                    break; 
                  continue;
                } 
                bool = false;
                break;
              } 
              if (!bool) {
                bool = bool1;
              } else {
                continue;
              } 
            } else {
              bool = true;
              break;
            } 
            if (bool)
              iterator.remove(); 
          } 
        } else {
          continue;
        } 
      } else {
        break;
      } 
      if (bool)
        iterator.remove(); 
    } 
  }
  
  private static boolean a(FinderPattern paramFinderPattern, boolean paramBoolean1, boolean paramBoolean2) {
    return (paramFinderPattern.a() != 0 || !paramBoolean1 || !paramBoolean2);
  }
  
  private static boolean a(Iterable<ExpandedPair> paramIterable, Iterable<ExpandedRow> paramIterable1) {
    Iterator<ExpandedRow> iterator = paramIterable1.iterator();
    while (true) {
      boolean bool1 = iterator.hasNext();
      boolean bool = false;
      if (bool1) {
        boolean bool2;
        ExpandedRow expandedRow = iterator.next();
        Iterator<ExpandedPair> iterator1 = paramIterable.iterator();
        while (true) {
          if (iterator1.hasNext()) {
            boolean bool3;
            ExpandedPair expandedPair = iterator1.next();
            Iterator<ExpandedPair> iterator2 = expandedRow.a().iterator();
            while (true) {
              if (iterator2.hasNext()) {
                if (expandedPair.equals(iterator2.next())) {
                  boolean bool4 = true;
                  break;
                } 
                continue;
              } 
              bool3 = false;
              break;
            } 
            if (!bool3) {
              bool3 = bool;
              break;
            } 
            continue;
          } 
          bool2 = true;
          break;
        } 
        if (bool2)
          return true; 
        continue;
      } 
      return false;
    } 
  }
  
  private void b(BitArray paramBitArray, List<ExpandedPair> paramList, int paramInt) throws NotFoundException {
    int[] arrayOfInt = b();
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    arrayOfInt[2] = 0;
    arrayOfInt[3] = 0;
    int n = paramBitArray.a();
    if (paramInt < 0)
      if (paramList.isEmpty()) {
        paramInt = 0;
      } else {
        paramInt = ((ExpandedPair)paramList.get(paramList.size() - 1)).c().b()[1];
      }  
    if (paramList.size() % 2 != 0) {
      i = 1;
    } else {
      i = 0;
    } 
    int j = i;
    if (this.j)
      j = i ^ 0x1; 
    int i1 = 0;
    while (paramInt < n) {
      int i2 = paramBitArray.a(paramInt) ^ true;
      i1 = i2;
      if (i2 != 0) {
        paramInt++;
        i1 = i2;
      } 
    } 
    int i = paramInt;
    int m = 0;
    int k = paramInt;
    paramInt = i;
    i = m;
    while (k < n) {
      if (paramBitArray.a(k) != i1) {
        arrayOfInt[i] = arrayOfInt[i] + 1;
        m = paramInt;
      } else {
        if (i == 3) {
          if (j != 0)
            b(arrayOfInt); 
          if (a(arrayOfInt)) {
            int[] arrayOfInt1 = this.i;
            arrayOfInt1[0] = paramInt;
            arrayOfInt1[1] = k;
            return;
          } 
          if (j != 0)
            b(arrayOfInt); 
          m = paramInt + arrayOfInt[0] + arrayOfInt[1];
          arrayOfInt[0] = arrayOfInt[2];
          arrayOfInt[1] = arrayOfInt[3];
          arrayOfInt[2] = 0;
          arrayOfInt[3] = 0;
          paramInt = i - 1;
          i = m;
        } else {
          m = i + 1;
          i = paramInt;
          paramInt = m;
        } 
        arrayOfInt[paramInt] = 1;
        i1 ^= 0x1;
        m = i;
        i = paramInt;
      } 
      k++;
      paramInt = m;
    } 
    throw NotFoundException.a();
  }
  
  private static void b(int[] paramArrayOfint) {
    int j = paramArrayOfint.length;
    for (int i = 0; i < j / 2; i++) {
      int k = paramArrayOfint[i];
      int m = j - i - 1;
      paramArrayOfint[i] = paramArrayOfint[m];
      paramArrayOfint[m] = k;
    } 
  }
  
  private static boolean b(List<ExpandedPair> paramList) {
    for (int[] arrayOfInt : f) {
      if (paramList.size() <= arrayOfInt.length) {
        int i = 0;
        while (true) {
          if (i < paramList.size()) {
            if (((ExpandedPair)paramList.get(i)).c().a() != arrayOfInt[i]) {
              i = 0;
              break;
            } 
            i++;
            continue;
          } 
          i = 1;
          break;
        } 
        if (i != 0)
          return true; 
      } 
    } 
    return false;
  }
  
  private boolean h() {
    ExpandedPair expandedPair = this.g.get(0);
    DataCharacter dataCharacter1 = expandedPair.a();
    DataCharacter dataCharacter2 = expandedPair.b();
    if (dataCharacter2 == null)
      return false; 
    int j = dataCharacter2.b();
    int k = 1;
    int i = 2;
    while (k < this.g.size()) {
      ExpandedPair expandedPair1 = this.g.get(k);
      int m = j + expandedPair1.a().b();
      int n = i + 1;
      DataCharacter dataCharacter = expandedPair1.b();
      j = m;
      i = n;
      if (dataCharacter != null) {
        j = m + dataCharacter.b();
        i = n + 1;
      } 
      k++;
    } 
    return ((i - 4) * 211 + j % 211 == dataCharacter1.a());
  }
  
  public Result a(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap) throws NotFoundException, FormatException {
    this.g.clear();
    this.j = false;
    try {
      return a(a(paramInt, paramBitArray));
    } catch (NotFoundException notFoundException) {
      this.g.clear();
      this.j = true;
      return a(a(paramInt, paramBitArray));
    } 
  }
  
  DataCharacter a(BitArray paramBitArray, FinderPattern paramFinderPattern, boolean paramBoolean1, boolean paramBoolean2) throws NotFoundException {
    int[] arrayOfInt = c();
    int i;
    for (i = 0; i < arrayOfInt.length; i++)
      arrayOfInt[i] = 0; 
    if (paramBoolean2) {
      b(paramBitArray, paramFinderPattern.b()[0], arrayOfInt);
    } else {
      a(paramBitArray, paramFinderPattern.b()[1], arrayOfInt);
      i = arrayOfInt.length - 1;
      int j = 0;
      while (j < i) {
        int k = arrayOfInt[j];
        arrayOfInt[j] = arrayOfInt[i];
        arrayOfInt[i] = k;
        j++;
        i--;
      } 
    } 
    float f1 = MathUtils.a(arrayOfInt) / 17.0F;
    float f2 = (paramFinderPattern.b()[1] - paramFinderPattern.b()[0]) / 15.0F;
    if (Math.abs(f1 - f2) / f2 <= 0.3F) {
      int[] arrayOfInt1 = f();
      int[] arrayOfInt2 = g();
      float[] arrayOfFloat1 = d();
      float[] arrayOfFloat2 = e();
      int j;
      for (j = 0; j < arrayOfInt.length; j++) {
        f2 = arrayOfInt[j] * 1.0F / f1;
        i = (int)(0.5F + f2);
        int i1 = 8;
        if (i <= 0) {
          if (f2 >= 0.3F) {
            i = 1;
          } else {
            throw NotFoundException.a();
          } 
        } else if (i > 8) {
          if (f2 <= 8.7F) {
            i = i1;
          } else {
            throw NotFoundException.a();
          } 
        } 
        i1 = j / 2;
        if ((j & 0x1) == 0) {
          arrayOfInt1[i1] = i;
          arrayOfFloat1[i1] = f2 - i;
        } else {
          arrayOfInt2[i1] = i;
          arrayOfFloat2[i1] = f2 - i;
        } 
      } 
      a(17);
      j = paramFinderPattern.a();
      if (paramBoolean1) {
        i = 0;
      } else {
        i = 2;
      } 
      int n = j * 4 + i + (paramBoolean2 ^ true) - 1;
      int k = arrayOfInt1.length - 1;
      i = 0;
      j = 0;
      while (k >= 0) {
        int i1 = i;
        if (a(paramFinderPattern, paramBoolean1, paramBoolean2)) {
          i1 = e[n][k * 2];
          i1 = i + arrayOfInt1[k] * i1;
        } 
        j += arrayOfInt1[k];
        k--;
        i = i1;
      } 
      int m = arrayOfInt2.length - 1;
      for (k = 0; m >= 0; k = i1) {
        int i1 = k;
        if (a(paramFinderPattern, paramBoolean1, paramBoolean2)) {
          i1 = e[n][m * 2 + 1];
          i1 = k + arrayOfInt2[m] * i1;
        } 
        m--;
      } 
      if ((j & 0x1) == 0 && j <= 13 && j >= 4) {
        j = (13 - j) / 2;
        int i1 = a[j];
        m = RSSUtils.a(arrayOfInt1, i1, true);
        i1 = RSSUtils.a(arrayOfInt2, 9 - i1, false);
        return new DataCharacter(m * b[j] + i1 + c[j], i + k);
      } 
      throw NotFoundException.a();
    } 
    throw NotFoundException.a();
  }
  
  ExpandedPair a(BitArray paramBitArray, List<ExpandedPair> paramList, int paramInt) throws NotFoundException {
    // Byte code:
    //   0: aload_2
    //   1: invokeinterface size : ()I
    //   6: iconst_2
    //   7: irem
    //   8: ifne -> 17
    //   11: iconst_1
    //   12: istore #7
    //   14: goto -> 20
    //   17: iconst_0
    //   18: istore #7
    //   20: iload #7
    //   22: istore #8
    //   24: aload_0
    //   25: getfield j : Z
    //   28: ifeq -> 37
    //   31: iload #7
    //   33: iconst_1
    //   34: ixor
    //   35: istore #8
    //   37: iconst_m1
    //   38: istore #5
    //   40: iconst_1
    //   41: istore #4
    //   43: aload_0
    //   44: aload_1
    //   45: aload_2
    //   46: iload #5
    //   48: invokespecial b : (Lcom/google/zxing/common/BitArray;Ljava/util/List;I)V
    //   51: aload_0
    //   52: aload_1
    //   53: iload_3
    //   54: iload #8
    //   56: invokespecial a : (Lcom/google/zxing/common/BitArray;IZ)Lcom/google/zxing/oned/rss/FinderPattern;
    //   59: astore #9
    //   61: aload #9
    //   63: ifnonnull -> 85
    //   66: aload_1
    //   67: aload_0
    //   68: getfield i : [I
    //   71: iconst_0
    //   72: iaload
    //   73: invokestatic a : (Lcom/google/zxing/common/BitArray;I)I
    //   76: istore #5
    //   78: iload #4
    //   80: istore #6
    //   82: goto -> 88
    //   85: iconst_0
    //   86: istore #6
    //   88: iload #6
    //   90: istore #4
    //   92: iload #6
    //   94: ifne -> 43
    //   97: aload_0
    //   98: aload_1
    //   99: aload #9
    //   101: iload #8
    //   103: iconst_1
    //   104: invokevirtual a : (Lcom/google/zxing/common/BitArray;Lcom/google/zxing/oned/rss/FinderPattern;ZZ)Lcom/google/zxing/oned/rss/DataCharacter;
    //   107: astore #10
    //   109: aload_2
    //   110: invokeinterface isEmpty : ()Z
    //   115: ifne -> 148
    //   118: aload_2
    //   119: aload_2
    //   120: invokeinterface size : ()I
    //   125: iconst_1
    //   126: isub
    //   127: invokeinterface get : (I)Ljava/lang/Object;
    //   132: checkcast com/google/zxing/oned/rss/expanded/ExpandedPair
    //   135: invokevirtual d : ()Z
    //   138: ifne -> 144
    //   141: goto -> 148
    //   144: invokestatic a : ()Lcom/google/zxing/NotFoundException;
    //   147: athrow
    //   148: aload_0
    //   149: aload_1
    //   150: aload #9
    //   152: iload #8
    //   154: iconst_0
    //   155: invokevirtual a : (Lcom/google/zxing/common/BitArray;Lcom/google/zxing/oned/rss/FinderPattern;ZZ)Lcom/google/zxing/oned/rss/DataCharacter;
    //   158: astore_1
    //   159: goto -> 164
    //   162: aconst_null
    //   163: astore_1
    //   164: new com/google/zxing/oned/rss/expanded/ExpandedPair
    //   167: dup
    //   168: aload #10
    //   170: aload_1
    //   171: aload #9
    //   173: iconst_1
    //   174: invokespecial <init> : (Lcom/google/zxing/oned/rss/DataCharacter;Lcom/google/zxing/oned/rss/DataCharacter;Lcom/google/zxing/oned/rss/FinderPattern;Z)V
    //   177: areturn
    //   178: astore_1
    //   179: goto -> 162
    // Exception table:
    //   from	to	target	type
    //   148	159	178	com/google/zxing/NotFoundException
  }
  
  List<ExpandedPair> a(int paramInt, BitArray paramBitArray) throws NotFoundException {
    boolean bool = false;
    while (!bool) {
      try {
        this.g.add(a(paramBitArray, this.g, paramInt));
      } catch (NotFoundException notFoundException) {
        if (!this.g.isEmpty()) {
          bool = true;
          continue;
        } 
        throw notFoundException;
      } 
    } 
    if (h())
      return this.g; 
    boolean bool1 = this.h.isEmpty();
    a(paramInt, false);
    if ((bool1 ^ true) != 0) {
      List<ExpandedPair> list = a(false);
      if (list != null)
        return list; 
      list = a(true);
      if (list != null)
        return list; 
    } 
    throw NotFoundException.a();
  }
  
  public void a() {
    this.g.clear();
    this.h.clear();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\oned\rss\expanded\RSSExpandedReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */