package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Arrays;
import java.util.Map;

public final class Code39Reader extends OneDReader {
  static final int[] a = new int[] { 
      52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 
      265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 
      259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 
      385, 193, 448, 145, 400, 208, 133, 388, 196, 168, 
      162, 138, 42 };
  
  private final boolean b;
  
  private final boolean c;
  
  private final StringBuilder d;
  
  private final int[] e;
  
  public Code39Reader() {
    this(false);
  }
  
  public Code39Reader(boolean paramBoolean) {
    this(paramBoolean, false);
  }
  
  public Code39Reader(boolean paramBoolean1, boolean paramBoolean2) {
    this.b = paramBoolean1;
    this.c = paramBoolean2;
    this.d = new StringBuilder(20);
    this.e = new int[9];
  }
  
  private static char a(int paramInt) throws NotFoundException {
    int i = 0;
    while (true) {
      int[] arrayOfInt = a;
      if (i < arrayOfInt.length) {
        if (arrayOfInt[i] == paramInt)
          return "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(i); 
        i++;
        continue;
      } 
      if (paramInt == 148)
        return '*'; 
      throw NotFoundException.a();
    } 
  }
  
  private static int a(int[] paramArrayOfint) {
    int j = paramArrayOfint.length;
    boolean bool = false;
    for (int i = 0;; i = k) {
      int i2 = paramArrayOfint.length;
      int m = 0;
      int k;
      for (k = Integer.MAX_VALUE; m < i2; k = i3) {
        int i4 = paramArrayOfint[m];
        int i3 = k;
        if (i4 < k) {
          i3 = k;
          if (i4 > i)
            i3 = i4; 
        } 
        m++;
      } 
      int i1 = 0;
      i = 0;
      int n = 0;
      for (m = 0; i1 < j; m = i2) {
        int i5 = paramArrayOfint[i1];
        int i4 = i;
        int i3 = n;
        i2 = m;
        if (i5 > k) {
          i3 = n | 1 << j - 1 - i1;
          i4 = i + 1;
          i2 = m + i5;
        } 
        i1++;
        i = i4;
        n = i3;
      } 
      if (i == 3) {
        i1 = i;
        i = bool;
        while (i < j && i1 > 0) {
          int i3 = paramArrayOfint[i];
          i2 = i1;
          if (i3 > k) {
            i2 = i1 - 1;
            if (i3 << 1 >= m)
              return -1; 
          } 
          i++;
          i1 = i2;
        } 
        return n;
      } 
      if (i <= 3)
        return -1; 
    } 
  }
  
  private static String a(CharSequence paramCharSequence) throws FormatException {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface length : ()I
    //   6: istore #4
    //   8: new java/lang/StringBuilder
    //   11: dup
    //   12: iload #4
    //   14: invokespecial <init> : (I)V
    //   17: astore #5
    //   19: iconst_0
    //   20: istore_2
    //   21: iload_2
    //   22: iload #4
    //   24: if_icmpge -> 357
    //   27: aload_0
    //   28: iload_2
    //   29: invokeinterface charAt : (I)C
    //   34: istore_1
    //   35: iload_1
    //   36: bipush #43
    //   38: if_icmpeq -> 72
    //   41: iload_1
    //   42: bipush #36
    //   44: if_icmpeq -> 72
    //   47: iload_1
    //   48: bipush #37
    //   50: if_icmpeq -> 72
    //   53: iload_1
    //   54: bipush #47
    //   56: if_icmpne -> 62
    //   59: goto -> 72
    //   62: aload #5
    //   64: iload_1
    //   65: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: goto -> 346
    //   72: iload_2
    //   73: iconst_1
    //   74: iadd
    //   75: istore_3
    //   76: aload_0
    //   77: iload_3
    //   78: invokeinterface charAt : (I)C
    //   83: istore_2
    //   84: iload_1
    //   85: bipush #36
    //   87: if_icmpeq -> 317
    //   90: iload_1
    //   91: bipush #37
    //   93: if_icmpeq -> 173
    //   96: iload_1
    //   97: bipush #43
    //   99: if_icmpeq -> 149
    //   102: iload_1
    //   103: bipush #47
    //   105: if_icmpeq -> 113
    //   108: iconst_0
    //   109: istore_1
    //   110: goto -> 337
    //   113: iload_2
    //   114: bipush #65
    //   116: if_icmplt -> 133
    //   119: iload_2
    //   120: bipush #79
    //   122: if_icmpgt -> 133
    //   125: iload_2
    //   126: bipush #32
    //   128: isub
    //   129: istore_2
    //   130: goto -> 334
    //   133: iload_2
    //   134: bipush #90
    //   136: if_icmpne -> 145
    //   139: bipush #58
    //   141: istore_1
    //   142: goto -> 337
    //   145: invokestatic a : ()Lcom/google/zxing/FormatException;
    //   148: athrow
    //   149: iload_2
    //   150: bipush #65
    //   152: if_icmplt -> 169
    //   155: iload_2
    //   156: bipush #90
    //   158: if_icmpgt -> 169
    //   161: iload_2
    //   162: bipush #32
    //   164: iadd
    //   165: istore_2
    //   166: goto -> 334
    //   169: invokestatic a : ()Lcom/google/zxing/FormatException;
    //   172: athrow
    //   173: iload_2
    //   174: bipush #65
    //   176: if_icmplt -> 193
    //   179: iload_2
    //   180: bipush #69
    //   182: if_icmpgt -> 193
    //   185: iload_2
    //   186: bipush #38
    //   188: isub
    //   189: istore_2
    //   190: goto -> 334
    //   193: iload_2
    //   194: bipush #70
    //   196: if_icmplt -> 213
    //   199: iload_2
    //   200: bipush #74
    //   202: if_icmpgt -> 213
    //   205: iload_2
    //   206: bipush #11
    //   208: isub
    //   209: istore_2
    //   210: goto -> 334
    //   213: iload_2
    //   214: bipush #75
    //   216: if_icmplt -> 233
    //   219: iload_2
    //   220: bipush #79
    //   222: if_icmpgt -> 233
    //   225: iload_2
    //   226: bipush #16
    //   228: iadd
    //   229: istore_2
    //   230: goto -> 334
    //   233: iload_2
    //   234: bipush #80
    //   236: if_icmplt -> 253
    //   239: iload_2
    //   240: bipush #84
    //   242: if_icmpgt -> 253
    //   245: iload_2
    //   246: bipush #43
    //   248: iadd
    //   249: istore_2
    //   250: goto -> 334
    //   253: iload_2
    //   254: bipush #85
    //   256: if_icmpne -> 262
    //   259: goto -> 108
    //   262: iload_2
    //   263: bipush #86
    //   265: if_icmpne -> 274
    //   268: bipush #64
    //   270: istore_1
    //   271: goto -> 337
    //   274: iload_2
    //   275: bipush #87
    //   277: if_icmpne -> 286
    //   280: bipush #96
    //   282: istore_1
    //   283: goto -> 337
    //   286: iload_2
    //   287: bipush #88
    //   289: if_icmpeq -> 311
    //   292: iload_2
    //   293: bipush #89
    //   295: if_icmpeq -> 311
    //   298: iload_2
    //   299: bipush #90
    //   301: if_icmpne -> 307
    //   304: goto -> 311
    //   307: invokestatic a : ()Lcom/google/zxing/FormatException;
    //   310: athrow
    //   311: bipush #127
    //   313: istore_1
    //   314: goto -> 337
    //   317: iload_2
    //   318: bipush #65
    //   320: if_icmplt -> 353
    //   323: iload_2
    //   324: bipush #90
    //   326: if_icmpgt -> 353
    //   329: iload_2
    //   330: bipush #64
    //   332: isub
    //   333: istore_2
    //   334: iload_2
    //   335: i2c
    //   336: istore_1
    //   337: aload #5
    //   339: iload_1
    //   340: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: iload_3
    //   345: istore_2
    //   346: iload_2
    //   347: iconst_1
    //   348: iadd
    //   349: istore_2
    //   350: goto -> 21
    //   353: invokestatic a : ()Lcom/google/zxing/FormatException;
    //   356: athrow
    //   357: aload #5
    //   359: invokevirtual toString : ()Ljava/lang/String;
    //   362: areturn
  }
  
  private static int[] a(BitArray paramBitArray, int[] paramArrayOfint) throws NotFoundException {
    int m = paramBitArray.a();
    int k = paramBitArray.c(0);
    int n = paramArrayOfint.length;
    int i = k;
    boolean bool = false;
    int j = 0;
    while (k < m) {
      int i1;
      if (paramBitArray.a(k) != bool) {
        paramArrayOfint[j] = paramArrayOfint[j] + 1;
        i1 = i;
      } else {
        if (j == n - 1) {
          if (a(paramArrayOfint) == 148 && paramBitArray.a(Math.max(0, i - (k - i) / 2), i, false))
            return new int[] { i, k }; 
          int i3 = i + paramArrayOfint[0] + paramArrayOfint[1];
          i = j - 1;
          System.arraycopy(paramArrayOfint, 2, paramArrayOfint, 0, i);
          paramArrayOfint[i] = 0;
          paramArrayOfint[j] = 0;
          i = j - 1;
          j = i3;
        } else {
          int i3 = j + 1;
          j = i;
          i = i3;
        } 
        paramArrayOfint[i] = 1;
        int i2 = bool ^ true;
        i1 = j;
        j = i;
      } 
      k++;
      i = i1;
    } 
    throw NotFoundException.a();
  }
  
  public Result a(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap) throws NotFoundException, ChecksumException, FormatException {
    int[] arrayOfInt2 = this.e;
    Arrays.fill(arrayOfInt2, 0);
    StringBuilder stringBuilder = this.d;
    stringBuilder.setLength(0);
    int[] arrayOfInt1 = a(paramBitArray, arrayOfInt2);
    int i = paramBitArray.c(arrayOfInt1[1]);
    int j = paramBitArray.a();
    while (true) {
      a(paramBitArray, i, arrayOfInt2);
      int k = a(arrayOfInt2);
      if (k >= 0) {
        char c = a(k);
        stringBuilder.append(c);
        int n = arrayOfInt2.length;
        int m = i;
        for (k = 0; k < n; k++)
          m += arrayOfInt2[k]; 
        n = paramBitArray.c(m);
        if (c == '*') {
          stringBuilder.setLength(stringBuilder.length() - 1);
          int i1 = arrayOfInt2.length;
          m = 0;
          k = 0;
          while (m < i1) {
            k += arrayOfInt2[m];
            m++;
          } 
          if (n == j || n - i - k << 1 >= k) {
            if (this.b) {
              j = stringBuilder.length() - 1;
              m = 0;
              n = 0;
              while (m < j) {
                n += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(this.d.charAt(m));
                m++;
              } 
              if (stringBuilder.charAt(j) == "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(n % 43)) {
                stringBuilder.setLength(j);
              } else {
                throw ChecksumException.a();
              } 
            } 
            if (stringBuilder.length() != 0) {
              String str;
              if (this.c) {
                str = a(stringBuilder);
              } else {
                str = stringBuilder.toString();
              } 
              float f1 = (arrayOfInt1[1] + arrayOfInt1[0]) / 2.0F;
              float f2 = i;
              float f3 = k / 2.0F;
              float f4 = paramInt;
              ResultPoint resultPoint1 = new ResultPoint(f1, f4);
              ResultPoint resultPoint2 = new ResultPoint(f2 + f3, f4);
              BarcodeFormat barcodeFormat = BarcodeFormat.c;
              return new Result(str, null, new ResultPoint[] { resultPoint1, resultPoint2 }, barcodeFormat);
            } 
            throw NotFoundException.a();
          } 
          throw NotFoundException.a();
        } 
        i = n;
        continue;
      } 
      throw NotFoundException.a();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\oned\Code39Reader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */