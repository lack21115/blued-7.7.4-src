package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class StandardGifDecoder implements GifDecoder {
  private static final String a = StandardGifDecoder.class.getSimpleName();
  
  private int[] b;
  
  private final int[] c = new int[256];
  
  private final GifDecoder.BitmapProvider d;
  
  private ByteBuffer e;
  
  private byte[] f;
  
  private short[] g;
  
  private byte[] h;
  
  private byte[] i;
  
  private byte[] j;
  
  private int[] k;
  
  private int l;
  
  private GifHeader m;
  
  private Bitmap n;
  
  private boolean o;
  
  private int p;
  
  private int q;
  
  private int r;
  
  private int s;
  
  private Boolean t;
  
  private Bitmap.Config u = Bitmap.Config.ARGB_8888;
  
  public StandardGifDecoder(GifDecoder.BitmapProvider paramBitmapProvider) {
    this.d = paramBitmapProvider;
    this.m = new GifHeader();
  }
  
  public StandardGifDecoder(GifDecoder.BitmapProvider paramBitmapProvider, GifHeader paramGifHeader, ByteBuffer paramByteBuffer, int paramInt) {
    this(paramBitmapProvider);
    a(paramGifHeader, paramByteBuffer, paramInt);
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3) {
    int i;
    int i2 = paramInt1;
    int i1 = 0;
    int n = 0;
    int m = 0;
    int k = 0;
    int j = 0;
    while (i2 < this.q + paramInt1) {
      byte[] arrayOfByte = this.j;
      if (i2 < arrayOfByte.length && i2 < paramInt2) {
        int i5 = arrayOfByte[i2];
        int i10 = this.b[i5 & 0xFF];
        int i9 = i1;
        int i8 = n;
        int i7 = m;
        int i6 = k;
        i5 = j;
        if (i10 != 0) {
          i9 = i1 + (i10 >> 24 & 0xFF);
          i8 = n + (i10 >> 16 & 0xFF);
          i7 = m + (i10 >> 8 & 0xFF);
          i6 = k + (i10 & 0xFF);
          i5 = j + 1;
        } 
        i2++;
        i1 = i9;
        n = i8;
        m = i7;
        k = i6;
        j = i5;
      } 
    } 
    int i4 = paramInt1 + paramInt3;
    paramInt1 = i4;
    int i3 = i1;
    while (paramInt1 < this.q + i4) {
      byte[] arrayOfByte = this.j;
      if (paramInt1 < arrayOfByte.length && paramInt1 < paramInt2) {
        int i5;
        paramInt3 = arrayOfByte[paramInt1];
        int i9 = this.b[paramInt3 & 0xFF];
        int i8 = i3;
        int i7 = n;
        i2 = m;
        i1 = k;
        int i6 = j;
        if (i9 != 0) {
          i8 = i3 + (i9 >> 24 & 0xFF);
          i7 = n + (i9 >> 16 & 0xFF);
          i2 = m + (i9 >> 8 & 0xFF);
          i1 = k + (i9 & 0xFF);
          i5 = j + 1;
        } 
        paramInt1++;
        i3 = i8;
        n = i7;
        m = i2;
        k = i1;
        i = i5;
      } 
    } 
    return (i == 0) ? 0 : (i3 / i << 24 | n / i << 16 | m / i << 8 | k / i);
  }
  
  private Bitmap a(GifFrame paramGifFrame1, GifFrame paramGifFrame2) {
    int[] arrayOfInt = this.k;
    int i = 0;
    if (paramGifFrame2 == null) {
      Bitmap bitmap1 = this.n;
      if (bitmap1 != null)
        this.d.a(bitmap1); 
      this.n = null;
      Arrays.fill(arrayOfInt, 0);
    } 
    if (paramGifFrame2 != null && paramGifFrame2.g == 3 && this.n == null)
      Arrays.fill(arrayOfInt, 0); 
    if (paramGifFrame2 != null && paramGifFrame2.g > 0)
      if (paramGifFrame2.g == 2) {
        int j = i;
        if (!paramGifFrame1.f) {
          j = this.m.l;
          if (paramGifFrame1.k != null && this.m.j == paramGifFrame1.h)
            j = i; 
        } 
        int n = paramGifFrame2.d / this.q;
        i = paramGifFrame2.b / this.q;
        int i1 = paramGifFrame2.c / this.q;
        int k = paramGifFrame2.a / this.q;
        int i2 = this.s;
        int m = i * i2 + k;
        for (i = m; i < n * i2 + m; i += this.s) {
          for (k = i; k < i + i1; k++)
            arrayOfInt[k] = j; 
        } 
      } else if (paramGifFrame2.g == 3) {
        Bitmap bitmap1 = this.n;
        if (bitmap1 != null) {
          i = this.s;
          bitmap1.getPixels(arrayOfInt, 0, i, 0, 0, i, this.r);
        } 
      }  
    c(paramGifFrame1);
    if (paramGifFrame1.e || this.q != 1) {
      b(paramGifFrame1);
    } else {
      a(paramGifFrame1);
    } 
    if (this.o && (paramGifFrame1.g == 0 || paramGifFrame1.g == 1)) {
      if (this.n == null)
        this.n = m(); 
      Bitmap bitmap1 = this.n;
      i = this.s;
      bitmap1.setPixels(arrayOfInt, 0, i, 0, 0, i, this.r);
    } 
    Bitmap bitmap = m();
    i = this.s;
    bitmap.setPixels(arrayOfInt, 0, i, 0, 0, i, this.r);
    return bitmap;
  }
  
  private void a(GifFrame paramGifFrame) {
    boolean bool1;
    boolean bool2;
    GifFrame gifFrame = paramGifFrame;
    int[] arrayOfInt1 = this.k;
    int k = gifFrame.d;
    int m = gifFrame.b;
    int n = gifFrame.c;
    int i1 = gifFrame.a;
    if (this.l == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    int i2 = this.s;
    byte[] arrayOfByte = this.j;
    int[] arrayOfInt2 = this.b;
    int i = 0;
    int j = -1;
    while (i < k) {
      int i3 = (i + m) * i2;
      int i5 = i3 + i1;
      int i4 = i5 + n;
      int i6 = i3 + i2;
      i3 = i4;
      if (i6 < i4)
        i3 = i6; 
      i4 = paramGifFrame.c * i;
      while (i5 < i3) {
        byte b = arrayOfByte[i4];
        int i7 = b & 0xFF;
        i6 = j;
        if (i7 != j) {
          i6 = arrayOfInt2[i7];
          if (i6 != 0) {
            arrayOfInt1[i5] = i6;
            i6 = j;
          } else {
            i6 = b;
          } 
        } 
        i4++;
        i5++;
        j = i6;
      } 
      i++;
    } 
    Boolean bool = this.t;
    if ((bool != null && bool.booleanValue()) || (this.t == null && bool1 && j != -1)) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    this.t = Boolean.valueOf(bool2);
  }
  
  private void b(GifFrame paramGifFrame) {
    boolean bool;
    int[] arrayOfInt1 = this.k;
    int i2 = paramGifFrame.d / this.q;
    int i1 = paramGifFrame.b / this.q;
    int i = paramGifFrame.c / this.q;
    int i3 = paramGifFrame.a / this.q;
    int j = this.l;
    Boolean bool2 = Boolean.valueOf(true);
    if (j == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    int i4 = this.q;
    int i5 = this.s;
    int i6 = this.r;
    byte[] arrayOfByte = this.j;
    int[] arrayOfInt2 = this.b;
    Boolean bool1 = this.t;
    int m = 0;
    j = 0;
    int n = 1;
    int k;
    for (k = 8;; k = i8) {
      int i7;
      int i8;
      Boolean bool3;
      if (m < i2) {
        int i9;
        if (paramGifFrame.e) {
          if (j >= i2)
            if (++n != 2) {
              if (n != 3) {
                if (n == 4) {
                  j = 1;
                  k = 2;
                } 
              } else {
                j = 2;
                k = 4;
              } 
            } else {
              j = 4;
            }  
          i7 = j + k;
          i9 = j;
          j = i7;
          i7 = n;
          i8 = k;
        } else {
          i9 = m;
          i8 = k;
          i7 = n;
        } 
        k = i9 + i1;
        if (i4 == 1) {
          n = 1;
        } else {
          n = 0;
        } 
        if (k < i6) {
          k *= i5;
          i9 = k + i3;
          int i10 = i9 + i;
          int i11 = k + i5;
          k = i10;
          if (i11 < i10)
            k = i11; 
          i10 = m * i4 * paramGifFrame.c;
          if (n != 0) {
            while (true) {
              n = i;
              bool3 = bool1;
              if (i9 < k) {
                n = arrayOfInt2[arrayOfByte[i10] & 0xFF];
                if (n != 0) {
                  arrayOfInt1[i9] = n;
                  bool3 = bool1;
                } else {
                  bool3 = bool1;
                  if (bool) {
                    bool3 = bool1;
                    if (bool1 == null)
                      bool3 = bool2; 
                  } 
                } 
                i10 += i4;
                i9++;
                bool1 = bool3;
                continue;
              } 
              break;
            } 
          } else {
            i11 = i;
            int i12 = i9;
            n = i10;
            i = k;
            while (true) {
              int i13 = n;
              n = i;
              bool3 = bool1;
              i = i11;
              if (i12 < n) {
                i = a(i13, (k - i9) * i4 + i10, paramGifFrame.c);
                if (i != 0) {
                  arrayOfInt1[i12] = i;
                  bool3 = bool1;
                } else {
                  bool3 = bool1;
                  if (bool) {
                    bool3 = bool1;
                    if (bool1 == null)
                      bool3 = bool2; 
                  } 
                } 
                i13 += i4;
                i12++;
                i = n;
                n = i13;
                bool1 = bool3;
                continue;
              } 
              break;
            } 
            m++;
            bool1 = bool3;
            n = i7;
            k = i8;
          } 
        } else {
          bool3 = bool1;
          n = i;
        } 
        i = n;
      } else {
        break;
      } 
      m++;
      bool1 = bool3;
      n = i7;
    } 
    if (this.t == null) {
      boolean bool3;
      if (bool1 == null) {
        bool3 = false;
      } else {
        bool3 = bool1.booleanValue();
      } 
      this.t = Boolean.valueOf(bool3);
    } 
  }
  
  private void c(GifFrame paramGifFrame) {
    int i8;
    StandardGifDecoder standardGifDecoder2 = this;
    if (paramGifFrame != null)
      standardGifDecoder2.e.position(paramGifFrame.j); 
    if (paramGifFrame == null) {
      i8 = standardGifDecoder2.m.f * standardGifDecoder2.m.g;
    } else {
      int i14 = paramGifFrame.c;
      i8 = paramGifFrame.d * i14;
    } 
    byte[] arrayOfByte1 = standardGifDecoder2.j;
    if (arrayOfByte1 == null || arrayOfByte1.length < i8)
      standardGifDecoder2.j = standardGifDecoder2.d.a(i8); 
    byte[] arrayOfByte2 = standardGifDecoder2.j;
    if (standardGifDecoder2.g == null)
      standardGifDecoder2.g = new short[4096]; 
    short[] arrayOfShort = standardGifDecoder2.g;
    if (standardGifDecoder2.h == null)
      standardGifDecoder2.h = new byte[4096]; 
    byte[] arrayOfByte3 = standardGifDecoder2.h;
    if (standardGifDecoder2.i == null)
      standardGifDecoder2.i = new byte[4097]; 
    byte[] arrayOfByte4 = standardGifDecoder2.i;
    int i = k();
    int i13 = 1 << i;
    int i9 = i13 + 2;
    int i11 = i + 1;
    int i10 = (1 << i11) - 1;
    int i12 = 0;
    for (i = 0; i < i13; i++) {
      arrayOfShort[i] = 0;
      arrayOfByte3[i] = (byte)i;
    } 
    byte[] arrayOfByte5 = standardGifDecoder2.f;
    int k = i11;
    int i1 = i9;
    int i3 = i10;
    int i4 = 0;
    int i2 = 0;
    int i6 = 0;
    int i7 = 0;
    int j = 0;
    int m = -1;
    int n = 0;
    int i5 = 0;
    i = i12;
    StandardGifDecoder standardGifDecoder1 = standardGifDecoder2;
    label77: while (i < i8) {
      i12 = i4;
      if (!i4) {
        i12 = l();
        if (i12 <= 0) {
          standardGifDecoder1.p = 3;
          break;
        } 
        i7 = 0;
      } 
      i6 += (arrayOfByte5[i7] & 0xFF) << i2;
      int i14 = i7 + 1;
      int i15 = i12 - 1;
      i7 = i2 + 8;
      i2 = m;
      m = n;
      i4 = i1;
      n = k;
      i1 = m;
      m = i4;
      k = j;
      j = i;
      i = i2;
      i4 = i11;
      i2 = i7;
      while (i2 >= n) {
        i7 = i6 & i3;
        i6 >>= n;
        i2 -= n;
        if (i7 == i13) {
          n = i4;
          m = i9;
          i3 = i10;
          i = -1;
          continue;
        } 
        if (i7 == i13 + 1) {
          i12 = n;
          i7 = j;
          j = k;
          k = m;
          n = i1;
          m = i;
          i11 = i4;
          i = i7;
          i4 = i15;
          i7 = i14;
          i1 = k;
          k = i12;
          continue label77;
        } 
        if (i == -1) {
          arrayOfByte2[k] = arrayOfByte3[i7];
          k++;
          j++;
          standardGifDecoder1 = this;
          i = i7;
          i1 = i;
          continue;
        } 
        i11 = m;
        if (i7 >= i11) {
          arrayOfByte4[i5] = (byte)i1;
          m = i5 + 1;
          i1 = i;
        } else {
          i1 = i7;
          m = i5;
        } 
        while (i1 >= i13) {
          arrayOfByte4[m] = arrayOfByte3[i1];
          m++;
          i1 = arrayOfShort[i1];
        } 
        int i16 = arrayOfByte3[i1] & 0xFF;
        byte b = (byte)i16;
        arrayOfByte2[k] = b;
        while (true) {
          k++;
          i5 = j + 1;
          if (m > 0) {
            arrayOfByte2[k] = arrayOfByte4[--m];
            j = i5;
            continue;
          } 
          j = i11;
          i12 = n;
          i1 = i3;
          if (i11 < 4096) {
            arrayOfShort[i11] = (short)i;
            arrayOfByte3[i11] = b;
            i = i11 + 1;
            j = i;
            i12 = n;
            i1 = i3;
            if ((i & i3) == 0) {
              j = i;
              i12 = n;
              i1 = i3;
              if (i < 4096) {
                i12 = n + 1;
                i1 = i3 + i;
                j = i;
              } 
            } 
          } 
          break;
        } 
        i = i7;
        i7 = i16;
        i11 = j;
        standardGifDecoder1 = this;
        n = i12;
        j = i5;
        i5 = m;
        i3 = i1;
        m = i11;
        i1 = i7;
      } 
      i12 = n;
      n = i1;
      i7 = j;
      j = k;
      i1 = m;
      m = i;
      standardGifDecoder1 = this;
      i11 = i4;
      i = i7;
      i4 = i15;
      i7 = i14;
      k = i12;
    } 
    Arrays.fill(arrayOfByte2, j, i8, (byte)0);
  }
  
  private int k() {
    return this.e.get() & 0xFF;
  }
  
  private int l() {
    int i = k();
    if (i <= 0)
      return i; 
    ByteBuffer byteBuffer = this.e;
    byteBuffer.get(this.f, 0, Math.min(i, byteBuffer.remaining()));
    return i;
  }
  
  private Bitmap m() {
    Boolean bool = this.t;
    if (bool == null || bool.booleanValue()) {
      Bitmap.Config config1 = Bitmap.Config.ARGB_8888;
      Bitmap bitmap1 = this.d.a(this.s, this.r, config1);
      bitmap1.setHasAlpha(true);
      return bitmap1;
    } 
    Bitmap.Config config = this.u;
    Bitmap bitmap = this.d.a(this.s, this.r, config);
    bitmap.setHasAlpha(true);
    return bitmap;
  }
  
  public int a(int paramInt) {
    return (paramInt >= 0 && paramInt < this.m.c) ? ((GifFrame)this.m.e.get(paramInt)).i : -1;
  }
  
  public ByteBuffer a() {
    return this.e;
  }
  
  public void a(Bitmap.Config paramConfig) {
    if (paramConfig == Bitmap.Config.ARGB_8888 || paramConfig == Bitmap.Config.RGB_565) {
      this.u = paramConfig;
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Unsupported format: ");
    stringBuilder.append(paramConfig);
    stringBuilder.append(", must be one of ");
    stringBuilder.append(Bitmap.Config.ARGB_8888);
    stringBuilder.append(" or ");
    stringBuilder.append(Bitmap.Config.RGB_565);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public void a(GifHeader paramGifHeader, ByteBuffer paramByteBuffer, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_3
    //   3: ifle -> 175
    //   6: iload_3
    //   7: invokestatic highestOneBit : (I)I
    //   10: istore_3
    //   11: aload_0
    //   12: iconst_0
    //   13: putfield p : I
    //   16: aload_0
    //   17: aload_1
    //   18: putfield m : Lcom/bumptech/glide/gifdecoder/GifHeader;
    //   21: aload_0
    //   22: iconst_m1
    //   23: putfield l : I
    //   26: aload_0
    //   27: aload_2
    //   28: invokevirtual asReadOnlyBuffer : ()Ljava/nio/ByteBuffer;
    //   31: putfield e : Ljava/nio/ByteBuffer;
    //   34: aload_0
    //   35: getfield e : Ljava/nio/ByteBuffer;
    //   38: iconst_0
    //   39: invokevirtual position : (I)Ljava/nio/Buffer;
    //   42: pop
    //   43: aload_0
    //   44: getfield e : Ljava/nio/ByteBuffer;
    //   47: getstatic java/nio/ByteOrder.LITTLE_ENDIAN : Ljava/nio/ByteOrder;
    //   50: invokevirtual order : (Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   53: pop
    //   54: aload_0
    //   55: iconst_0
    //   56: putfield o : Z
    //   59: aload_1
    //   60: getfield e : Ljava/util/List;
    //   63: invokeinterface iterator : ()Ljava/util/Iterator;
    //   68: astore_2
    //   69: aload_2
    //   70: invokeinterface hasNext : ()Z
    //   75: ifeq -> 99
    //   78: aload_2
    //   79: invokeinterface next : ()Ljava/lang/Object;
    //   84: checkcast com/bumptech/glide/gifdecoder/GifFrame
    //   87: getfield g : I
    //   90: iconst_3
    //   91: if_icmpne -> 69
    //   94: aload_0
    //   95: iconst_1
    //   96: putfield o : Z
    //   99: aload_0
    //   100: iload_3
    //   101: putfield q : I
    //   104: aload_0
    //   105: aload_1
    //   106: getfield f : I
    //   109: iload_3
    //   110: idiv
    //   111: putfield s : I
    //   114: aload_0
    //   115: aload_1
    //   116: getfield g : I
    //   119: iload_3
    //   120: idiv
    //   121: putfield r : I
    //   124: aload_0
    //   125: aload_0
    //   126: getfield d : Lcom/bumptech/glide/gifdecoder/GifDecoder$BitmapProvider;
    //   129: aload_1
    //   130: getfield f : I
    //   133: aload_1
    //   134: getfield g : I
    //   137: imul
    //   138: invokeinterface a : (I)[B
    //   143: putfield j : [B
    //   146: aload_0
    //   147: aload_0
    //   148: getfield d : Lcom/bumptech/glide/gifdecoder/GifDecoder$BitmapProvider;
    //   151: aload_0
    //   152: getfield s : I
    //   155: aload_0
    //   156: getfield r : I
    //   159: imul
    //   160: invokeinterface b : (I)[I
    //   165: putfield k : [I
    //   168: aload_0
    //   169: monitorexit
    //   170: return
    //   171: astore_1
    //   172: goto -> 209
    //   175: new java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial <init> : ()V
    //   182: astore_1
    //   183: aload_1
    //   184: ldc_w 'Sample size must be >=0, not: '
    //   187: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload_1
    //   192: iload_3
    //   193: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: new java/lang/IllegalArgumentException
    //   200: dup
    //   201: aload_1
    //   202: invokevirtual toString : ()Ljava/lang/String;
    //   205: invokespecial <init> : (Ljava/lang/String;)V
    //   208: athrow
    //   209: aload_0
    //   210: monitorexit
    //   211: aload_1
    //   212: athrow
    // Exception table:
    //   from	to	target	type
    //   6	69	171	finally
    //   69	99	171	finally
    //   99	168	171	finally
    //   175	209	171	finally
  }
  
  public void b() {
    this.l = (this.l + 1) % this.m.c;
  }
  
  public int c() {
    if (this.m.c > 0) {
      int i = this.l;
      if (i >= 0)
        return a(i); 
    } 
    return 0;
  }
  
  public int d() {
    return this.m.c;
  }
  
  public int e() {
    return this.l;
  }
  
  public void f() {
    this.l = -1;
  }
  
  public int g() {
    return (this.m.m == -1) ? 1 : ((this.m.m == 0) ? 0 : (this.m.m + 1));
  }
  
  public int h() {
    return this.e.limit() + this.j.length + this.k.length * 4;
  }
  
  public Bitmap i() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield m : Lcom/bumptech/glide/gifdecoder/GifHeader;
    //   6: getfield c : I
    //   9: ifle -> 19
    //   12: aload_0
    //   13: getfield l : I
    //   16: ifge -> 92
    //   19: getstatic com/bumptech/glide/gifdecoder/StandardGifDecoder.a : Ljava/lang/String;
    //   22: iconst_3
    //   23: invokestatic isLoggable : (Ljava/lang/String;I)Z
    //   26: ifeq -> 87
    //   29: getstatic com/bumptech/glide/gifdecoder/StandardGifDecoder.a : Ljava/lang/String;
    //   32: astore_2
    //   33: new java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial <init> : ()V
    //   40: astore_3
    //   41: aload_3
    //   42: ldc_w 'Unable to decode frame, frameCount='
    //   45: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload_3
    //   50: aload_0
    //   51: getfield m : Lcom/bumptech/glide/gifdecoder/GifHeader;
    //   54: getfield c : I
    //   57: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload_3
    //   62: ldc_w ', framePointer='
    //   65: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload_3
    //   70: aload_0
    //   71: getfield l : I
    //   74: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload_2
    //   79: aload_3
    //   80: invokevirtual toString : ()Ljava/lang/String;
    //   83: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   86: pop
    //   87: aload_0
    //   88: iconst_1
    //   89: putfield p : I
    //   92: aload_0
    //   93: getfield p : I
    //   96: iconst_1
    //   97: if_icmpeq -> 366
    //   100: aload_0
    //   101: getfield p : I
    //   104: iconst_2
    //   105: if_icmpne -> 111
    //   108: goto -> 366
    //   111: aload_0
    //   112: iconst_0
    //   113: putfield p : I
    //   116: aload_0
    //   117: getfield f : [B
    //   120: ifnonnull -> 139
    //   123: aload_0
    //   124: aload_0
    //   125: getfield d : Lcom/bumptech/glide/gifdecoder/GifDecoder$BitmapProvider;
    //   128: sipush #255
    //   131: invokeinterface a : (I)[B
    //   136: putfield f : [B
    //   139: aload_0
    //   140: getfield m : Lcom/bumptech/glide/gifdecoder/GifHeader;
    //   143: getfield e : Ljava/util/List;
    //   146: aload_0
    //   147: getfield l : I
    //   150: invokeinterface get : (I)Ljava/lang/Object;
    //   155: checkcast com/bumptech/glide/gifdecoder/GifFrame
    //   158: astore #4
    //   160: aload_0
    //   161: getfield l : I
    //   164: iconst_1
    //   165: isub
    //   166: istore_1
    //   167: iload_1
    //   168: iflt -> 423
    //   171: aload_0
    //   172: getfield m : Lcom/bumptech/glide/gifdecoder/GifHeader;
    //   175: getfield e : Ljava/util/List;
    //   178: iload_1
    //   179: invokeinterface get : (I)Ljava/lang/Object;
    //   184: checkcast com/bumptech/glide/gifdecoder/GifFrame
    //   187: astore_2
    //   188: goto -> 191
    //   191: aload #4
    //   193: getfield k : [I
    //   196: ifnull -> 208
    //   199: aload #4
    //   201: getfield k : [I
    //   204: astore_3
    //   205: goto -> 216
    //   208: aload_0
    //   209: getfield m : Lcom/bumptech/glide/gifdecoder/GifHeader;
    //   212: getfield a : [I
    //   215: astore_3
    //   216: aload_0
    //   217: aload_3
    //   218: putfield b : [I
    //   221: aload_0
    //   222: getfield b : [I
    //   225: ifnonnull -> 285
    //   228: getstatic com/bumptech/glide/gifdecoder/StandardGifDecoder.a : Ljava/lang/String;
    //   231: iconst_3
    //   232: invokestatic isLoggable : (Ljava/lang/String;I)Z
    //   235: ifeq -> 276
    //   238: getstatic com/bumptech/glide/gifdecoder/StandardGifDecoder.a : Ljava/lang/String;
    //   241: astore_2
    //   242: new java/lang/StringBuilder
    //   245: dup
    //   246: invokespecial <init> : ()V
    //   249: astore_3
    //   250: aload_3
    //   251: ldc_w 'No valid color table found for frame #'
    //   254: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload_3
    //   259: aload_0
    //   260: getfield l : I
    //   263: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: aload_2
    //   268: aload_3
    //   269: invokevirtual toString : ()Ljava/lang/String;
    //   272: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   275: pop
    //   276: aload_0
    //   277: iconst_1
    //   278: putfield p : I
    //   281: aload_0
    //   282: monitorexit
    //   283: aconst_null
    //   284: areturn
    //   285: aload #4
    //   287: getfield f : Z
    //   290: ifeq -> 354
    //   293: aload_0
    //   294: getfield b : [I
    //   297: iconst_0
    //   298: aload_0
    //   299: getfield c : [I
    //   302: iconst_0
    //   303: aload_0
    //   304: getfield b : [I
    //   307: arraylength
    //   308: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   311: aload_0
    //   312: aload_0
    //   313: getfield c : [I
    //   316: putfield b : [I
    //   319: aload_0
    //   320: getfield b : [I
    //   323: aload #4
    //   325: getfield h : I
    //   328: iconst_0
    //   329: iastore
    //   330: aload #4
    //   332: getfield g : I
    //   335: iconst_2
    //   336: if_icmpne -> 354
    //   339: aload_0
    //   340: getfield l : I
    //   343: ifne -> 354
    //   346: aload_0
    //   347: iconst_1
    //   348: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   351: putfield t : Ljava/lang/Boolean;
    //   354: aload_0
    //   355: aload #4
    //   357: aload_2
    //   358: invokespecial a : (Lcom/bumptech/glide/gifdecoder/GifFrame;Lcom/bumptech/glide/gifdecoder/GifFrame;)Landroid/graphics/Bitmap;
    //   361: astore_2
    //   362: aload_0
    //   363: monitorexit
    //   364: aload_2
    //   365: areturn
    //   366: getstatic com/bumptech/glide/gifdecoder/StandardGifDecoder.a : Ljava/lang/String;
    //   369: iconst_3
    //   370: invokestatic isLoggable : (Ljava/lang/String;I)Z
    //   373: ifeq -> 414
    //   376: getstatic com/bumptech/glide/gifdecoder/StandardGifDecoder.a : Ljava/lang/String;
    //   379: astore_2
    //   380: new java/lang/StringBuilder
    //   383: dup
    //   384: invokespecial <init> : ()V
    //   387: astore_3
    //   388: aload_3
    //   389: ldc_w 'Unable to decode frame, status='
    //   392: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: pop
    //   396: aload_3
    //   397: aload_0
    //   398: getfield p : I
    //   401: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   404: pop
    //   405: aload_2
    //   406: aload_3
    //   407: invokevirtual toString : ()Ljava/lang/String;
    //   410: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   413: pop
    //   414: aload_0
    //   415: monitorexit
    //   416: aconst_null
    //   417: areturn
    //   418: astore_2
    //   419: aload_0
    //   420: monitorexit
    //   421: aload_2
    //   422: athrow
    //   423: aconst_null
    //   424: astore_2
    //   425: goto -> 191
    // Exception table:
    //   from	to	target	type
    //   2	19	418	finally
    //   19	87	418	finally
    //   87	92	418	finally
    //   92	108	418	finally
    //   111	139	418	finally
    //   139	167	418	finally
    //   171	188	418	finally
    //   191	205	418	finally
    //   208	216	418	finally
    //   216	276	418	finally
    //   276	281	418	finally
    //   285	354	418	finally
    //   354	362	418	finally
    //   366	414	418	finally
  }
  
  public void j() {
    this.m = null;
    byte[] arrayOfByte2 = this.j;
    if (arrayOfByte2 != null)
      this.d.a(arrayOfByte2); 
    int[] arrayOfInt = this.k;
    if (arrayOfInt != null)
      this.d.a(arrayOfInt); 
    Bitmap bitmap = this.n;
    if (bitmap != null)
      this.d.a(bitmap); 
    this.n = null;
    this.e = null;
    this.t = null;
    byte[] arrayOfByte1 = this.f;
    if (arrayOfByte1 != null)
      this.d.a(arrayOfByte1); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\gifdecoder\StandardGifDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */