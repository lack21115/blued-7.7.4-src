package com.qiniu.pili.droid.shortvideo.b;

import android.graphics.Bitmap;
import android.util.Log;
import java.io.InputStream;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;

public class a {
  private static final String C = a.class.getSimpleName();
  
  protected int A;
  
  protected int B;
  
  protected int a;
  
  protected int b;
  
  protected int c;
  
  protected boolean d;
  
  protected int e;
  
  protected int f = 1;
  
  protected int[] g;
  
  protected int[] h;
  
  protected int i;
  
  protected int j;
  
  protected int k;
  
  protected boolean l;
  
  protected int m;
  
  protected ByteBuffer n;
  
  protected byte[] o = new byte[256];
  
  protected int p = 0;
  
  protected short[] q;
  
  protected byte[] r;
  
  protected byte[] s;
  
  protected byte[] t;
  
  protected int[] u;
  
  protected int[] v;
  
  protected ArrayList<a> w;
  
  protected a x;
  
  protected Bitmap y;
  
  protected Bitmap z;
  
  public int a(int paramInt) {
    return (paramInt >= 0 && paramInt < this.B) ? ((a)this.w.get(paramInt)).i : -1;
  }
  
  public int a(InputStream paramInputStream, int paramInt) {
    // Byte code:
    //   0: invokestatic currentTimeMillis : ()J
    //   3: pop2
    //   4: aload_1
    //   5: ifnull -> 101
    //   8: sipush #4096
    //   11: istore_3
    //   12: iload_2
    //   13: ifle -> 22
    //   16: sipush #4096
    //   19: iload_2
    //   20: iadd
    //   21: istore_3
    //   22: new java/io/ByteArrayOutputStream
    //   25: dup
    //   26: iload_3
    //   27: invokespecial <init> : (I)V
    //   30: astore #4
    //   32: sipush #16384
    //   35: newarray byte
    //   37: astore #5
    //   39: aload_1
    //   40: aload #5
    //   42: iconst_0
    //   43: aload #5
    //   45: arraylength
    //   46: invokevirtual read : ([BII)I
    //   49: istore_2
    //   50: iload_2
    //   51: iconst_m1
    //   52: if_icmpeq -> 67
    //   55: aload #4
    //   57: aload #5
    //   59: iconst_0
    //   60: iload_2
    //   61: invokevirtual write : ([BII)V
    //   64: goto -> 39
    //   67: aload #4
    //   69: invokevirtual flush : ()V
    //   72: aload_0
    //   73: aload #4
    //   75: invokevirtual toByteArray : ()[B
    //   78: invokevirtual a : ([B)I
    //   81: pop
    //   82: goto -> 106
    //   85: astore #4
    //   87: getstatic com/qiniu/pili/droid/shortvideo/b/a.C : Ljava/lang/String;
    //   90: ldc 'Error reading data from stream'
    //   92: aload #4
    //   94: invokestatic w : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   97: pop
    //   98: goto -> 106
    //   101: aload_0
    //   102: iconst_2
    //   103: putfield a : I
    //   106: aload_1
    //   107: invokevirtual close : ()V
    //   110: goto -> 124
    //   113: astore_1
    //   114: getstatic com/qiniu/pili/droid/shortvideo/b/a.C : Ljava/lang/String;
    //   117: ldc 'Error closing stream'
    //   119: aload_1
    //   120: invokestatic w : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   123: pop
    //   124: aload_0
    //   125: getfield a : I
    //   128: ireturn
    // Exception table:
    //   from	to	target	type
    //   22	39	85	java/io/IOException
    //   39	50	85	java/io/IOException
    //   55	64	85	java/io/IOException
    //   67	82	85	java/io/IOException
    //   106	110	113	java/lang/Exception
  }
  
  public int a(byte[] paramArrayOfbyte) {
    g();
    if (paramArrayOfbyte != null) {
      this.n = ByteBuffer.wrap(paramArrayOfbyte);
      this.n.rewind();
      this.n.order(ByteOrder.LITTLE_ENDIAN);
      k();
      if (!f()) {
        j();
        if (this.B < 0)
          this.a = 1; 
      } 
    } else {
      this.a = 2;
    } 
    return this.a;
  }
  
  public void a() {
    this.A = (this.A + 1) % this.B;
  }
  
  protected void a(a parama, byte[] paramArrayOfbyte) {
    // Byte code:
    //   0: invokestatic currentTimeMillis : ()J
    //   3: pop2
    //   4: aload_1
    //   5: ifnull -> 20
    //   8: aload_0
    //   9: getfield n : Ljava/nio/ByteBuffer;
    //   12: aload_1
    //   13: getfield j : I
    //   16: invokevirtual position : (I)Ljava/nio/Buffer;
    //   19: pop
    //   20: aload_1
    //   21: ifnonnull -> 38
    //   24: aload_0
    //   25: getfield b : I
    //   28: aload_0
    //   29: getfield c : I
    //   32: imul
    //   33: istore #18
    //   35: goto -> 53
    //   38: aload_1
    //   39: getfield c : I
    //   42: istore #4
    //   44: aload_1
    //   45: getfield d : I
    //   48: iload #4
    //   50: imul
    //   51: istore #18
    //   53: aload_2
    //   54: ifnull -> 66
    //   57: aload_2
    //   58: astore_1
    //   59: aload_2
    //   60: arraylength
    //   61: iload #18
    //   63: if_icmpge -> 71
    //   66: iload #18
    //   68: newarray byte
    //   70: astore_1
    //   71: aload_0
    //   72: getfield q : [S
    //   75: ifnonnull -> 87
    //   78: aload_0
    //   79: sipush #4096
    //   82: newarray short
    //   84: putfield q : [S
    //   87: aload_0
    //   88: getfield r : [B
    //   91: ifnonnull -> 103
    //   94: aload_0
    //   95: sipush #4096
    //   98: newarray byte
    //   100: putfield r : [B
    //   103: aload_0
    //   104: getfield s : [B
    //   107: ifnonnull -> 119
    //   110: aload_0
    //   111: sipush #4097
    //   114: newarray byte
    //   116: putfield s : [B
    //   119: aload_0
    //   120: invokevirtual h : ()I
    //   123: istore #4
    //   125: iconst_1
    //   126: iload #4
    //   128: ishl
    //   129: istore #9
    //   131: iload #9
    //   133: iconst_1
    //   134: iadd
    //   135: istore #21
    //   137: iload #9
    //   139: iconst_2
    //   140: iadd
    //   141: istore #19
    //   143: iload #4
    //   145: iconst_1
    //   146: iadd
    //   147: istore #4
    //   149: iconst_1
    //   150: iload #4
    //   152: ishl
    //   153: iconst_1
    //   154: isub
    //   155: istore #20
    //   157: iconst_0
    //   158: istore #5
    //   160: iload #5
    //   162: iload #9
    //   164: if_icmpge -> 194
    //   167: aload_0
    //   168: getfield q : [S
    //   171: iload #5
    //   173: iconst_0
    //   174: sastore
    //   175: aload_0
    //   176: getfield r : [B
    //   179: iload #5
    //   181: iload #5
    //   183: i2b
    //   184: bastore
    //   185: iload #5
    //   187: iconst_1
    //   188: iadd
    //   189: istore #5
    //   191: goto -> 160
    //   194: iload #4
    //   196: istore #7
    //   198: iload #19
    //   200: istore #16
    //   202: iload #20
    //   204: istore #6
    //   206: iconst_m1
    //   207: istore #8
    //   209: iconst_0
    //   210: istore #22
    //   212: iconst_0
    //   213: istore #5
    //   215: iconst_0
    //   216: istore #11
    //   218: iconst_0
    //   219: istore #12
    //   221: iconst_0
    //   222: istore #14
    //   224: iconst_0
    //   225: istore #15
    //   227: iconst_0
    //   228: istore #10
    //   230: iconst_0
    //   231: istore #13
    //   233: iload #22
    //   235: iload #18
    //   237: if_icmpge -> 705
    //   240: iload #5
    //   242: ifne -> 637
    //   245: iload #11
    //   247: iload #7
    //   249: if_icmpge -> 319
    //   252: iload #14
    //   254: istore #17
    //   256: iload #14
    //   258: ifne -> 278
    //   261: aload_0
    //   262: invokevirtual i : ()I
    //   265: istore #17
    //   267: iload #17
    //   269: ifgt -> 275
    //   272: goto -> 705
    //   275: iconst_0
    //   276: istore #15
    //   278: iload #12
    //   280: aload_0
    //   281: getfield o : [B
    //   284: iload #15
    //   286: baload
    //   287: sipush #255
    //   290: iand
    //   291: iload #11
    //   293: ishl
    //   294: iadd
    //   295: istore #12
    //   297: iload #11
    //   299: bipush #8
    //   301: iadd
    //   302: istore #11
    //   304: iload #15
    //   306: iconst_1
    //   307: iadd
    //   308: istore #15
    //   310: iload #17
    //   312: iconst_1
    //   313: isub
    //   314: istore #14
    //   316: goto -> 233
    //   319: iload #12
    //   321: iload #6
    //   323: iand
    //   324: istore #17
    //   326: iload #12
    //   328: iload #7
    //   330: ishr
    //   331: istore #12
    //   333: iload #11
    //   335: iload #7
    //   337: isub
    //   338: istore #11
    //   340: iload #17
    //   342: iload #16
    //   344: if_icmpgt -> 705
    //   347: iload #17
    //   349: iload #21
    //   351: if_icmpne -> 357
    //   354: goto -> 705
    //   357: iload #17
    //   359: iload #9
    //   361: if_icmpne -> 382
    //   364: iload #4
    //   366: istore #7
    //   368: iload #19
    //   370: istore #16
    //   372: iload #20
    //   374: istore #6
    //   376: iconst_m1
    //   377: istore #8
    //   379: goto -> 233
    //   382: iload #8
    //   384: iconst_m1
    //   385: if_icmpne -> 419
    //   388: aload_0
    //   389: getfield s : [B
    //   392: iload #5
    //   394: aload_0
    //   395: getfield r : [B
    //   398: iload #17
    //   400: baload
    //   401: bastore
    //   402: iload #17
    //   404: istore #8
    //   406: iload #8
    //   408: istore #10
    //   410: iload #5
    //   412: iconst_1
    //   413: iadd
    //   414: istore #5
    //   416: goto -> 379
    //   419: iload #17
    //   421: iload #16
    //   423: if_icmpne -> 449
    //   426: aload_0
    //   427: getfield s : [B
    //   430: iload #5
    //   432: iload #10
    //   434: i2b
    //   435: bastore
    //   436: iload #8
    //   438: istore #10
    //   440: iload #5
    //   442: iconst_1
    //   443: iadd
    //   444: istore #5
    //   446: goto -> 453
    //   449: iload #17
    //   451: istore #10
    //   453: iload #10
    //   455: iload #9
    //   457: if_icmple -> 492
    //   460: aload_0
    //   461: getfield s : [B
    //   464: iload #5
    //   466: aload_0
    //   467: getfield r : [B
    //   470: iload #10
    //   472: baload
    //   473: bastore
    //   474: aload_0
    //   475: getfield q : [S
    //   478: iload #10
    //   480: saload
    //   481: istore #10
    //   483: iload #5
    //   485: iconst_1
    //   486: iadd
    //   487: istore #5
    //   489: goto -> 453
    //   492: iload #9
    //   494: istore #23
    //   496: aload_0
    //   497: getfield r : [B
    //   500: astore_2
    //   501: aload_2
    //   502: iload #10
    //   504: baload
    //   505: sipush #255
    //   508: iand
    //   509: istore #24
    //   511: iload #16
    //   513: sipush #4096
    //   516: if_icmplt -> 522
    //   519: goto -> 705
    //   522: aload_0
    //   523: getfield s : [B
    //   526: astore #25
    //   528: iload #24
    //   530: i2b
    //   531: istore_3
    //   532: aload #25
    //   534: iload #5
    //   536: iload_3
    //   537: bastore
    //   538: aload_0
    //   539: getfield q : [S
    //   542: iload #16
    //   544: iload #8
    //   546: i2s
    //   547: sastore
    //   548: aload_2
    //   549: iload #16
    //   551: iload_3
    //   552: bastore
    //   553: iload #16
    //   555: iconst_1
    //   556: iadd
    //   557: istore #16
    //   559: iload #7
    //   561: istore #9
    //   563: iload #6
    //   565: istore #8
    //   567: iload #16
    //   569: iload #6
    //   571: iand
    //   572: ifne -> 604
    //   575: iload #7
    //   577: istore #9
    //   579: iload #6
    //   581: istore #8
    //   583: iload #16
    //   585: sipush #4096
    //   588: if_icmpge -> 604
    //   591: iload #7
    //   593: iconst_1
    //   594: iadd
    //   595: istore #9
    //   597: iload #6
    //   599: iload #16
    //   601: iadd
    //   602: istore #8
    //   604: iload #5
    //   606: iconst_1
    //   607: iadd
    //   608: istore #6
    //   610: iload #17
    //   612: istore #10
    //   614: iload #24
    //   616: istore #5
    //   618: iload #6
    //   620: istore #24
    //   622: iload #9
    //   624: istore #7
    //   626: iload #8
    //   628: istore #6
    //   630: iload #23
    //   632: istore #9
    //   634: goto -> 653
    //   637: iload #10
    //   639: istore #17
    //   641: iload #5
    //   643: istore #24
    //   645: iload #8
    //   647: istore #10
    //   649: iload #17
    //   651: istore #5
    //   653: iload #24
    //   655: iconst_1
    //   656: isub
    //   657: istore #23
    //   659: aload_1
    //   660: iload #13
    //   662: aload_0
    //   663: getfield s : [B
    //   666: iload #23
    //   668: baload
    //   669: bastore
    //   670: iload #22
    //   672: iconst_1
    //   673: iadd
    //   674: istore #22
    //   676: iload #13
    //   678: iconst_1
    //   679: iadd
    //   680: istore #17
    //   682: iload #5
    //   684: istore #13
    //   686: iload #10
    //   688: istore #8
    //   690: iload #23
    //   692: istore #5
    //   694: iload #13
    //   696: istore #10
    //   698: iload #17
    //   700: istore #13
    //   702: goto -> 233
    //   705: iload #13
    //   707: iload #18
    //   709: if_icmpge -> 726
    //   712: aload_1
    //   713: iload #13
    //   715: iconst_0
    //   716: bastore
    //   717: iload #13
    //   719: iconst_1
    //   720: iadd
    //   721: istore #13
    //   723: goto -> 705
    //   726: return
  }
  
  public int b() {
    int i = 0;
    int j = 0;
    while (true) {
      int k = this.B;
      if (i < k) {
        j += ((a)this.w.get(i)).i;
        i++;
        continue;
      } 
      return j / k;
    } 
  }
  
  protected void b(int paramInt) {
    a a1 = this.w.get(paramInt);
    if (--paramInt >= 0) {
      bitmap = (Bitmap)this.w.get(paramInt);
    } else {
      bitmap = null;
    } 
    int[] arrayOfInt1 = this.u;
    int j = 0;
    if (bitmap != null && ((a)bitmap).g > 0) {
      if (((a)bitmap).g == 1) {
        Bitmap bitmap1 = this.z;
        if (bitmap1 != null) {
          paramInt = this.b;
          bitmap1.getPixels(arrayOfInt1, 0, paramInt, 0, 0, paramInt, this.c);
        } 
      } 
      if (((a)bitmap).g == 2) {
        boolean bool;
        if (!a1.f) {
          bool = this.j;
        } else {
          bool = false;
        } 
        for (int n = 0; n < ((a)bitmap).d; n++) {
          int i1 = (((a)bitmap).b + n) * this.b + ((a)bitmap).a;
          int i2 = ((a)bitmap).c;
          for (paramInt = i1; paramInt < i2 + i1; paramInt++)
            arrayOfInt1[paramInt] = bool; 
        } 
      } 
      if (((a)bitmap).g == 3) {
        bitmap = this.y;
        if (bitmap != null) {
          paramInt = this.b;
          bitmap.getPixels(arrayOfInt1, 0, paramInt, 0, 0, paramInt, this.c);
        } 
      } 
    } 
    a(a1, this.t);
    int i = 0;
    int m = 1;
    int k;
    for (k = 8; j < a1.d; k = n) {
      int n;
      if (a1.e) {
        paramInt = i;
        int i1 = m;
        n = k;
        if (i >= a1.d) {
          i1 = m + 1;
          if (i1 != 2) {
            if (i1 != 3) {
              if (i1 != 4) {
                paramInt = i;
                n = k;
              } else {
                paramInt = 1;
                n = 2;
              } 
            } else {
              paramInt = 2;
              n = 4;
            } 
          } else {
            paramInt = 4;
            n = k;
          } 
        } 
        k = paramInt + n;
        i = paramInt;
        m = i1;
        paramInt = k;
      } else {
        paramInt = i;
        i = j;
        n = k;
      } 
      i += a1.b;
      if (i < this.c) {
        int i2 = i * this.b;
        int i1 = a1.a + i2;
        k = a1.c + i1;
        int i3 = this.b;
        i = k;
        if (i2 + i3 < k)
          i = i2 + i3; 
        for (k = a1.c * j; i1 < i; k++) {
          i2 = this.t[k];
          i2 = this.h[i2 & 0xFF];
          if (i2 != 0)
            arrayOfInt1[i1] = i2; 
          i1++;
        } 
      } 
      j++;
      i = paramInt;
    } 
    Bitmap bitmap = this.z;
    int[] arrayOfInt2 = this.v;
    paramInt = this.b;
    bitmap.getPixels(arrayOfInt2, 0, paramInt, 0, 0, paramInt, this.c);
    bitmap = this.y;
    arrayOfInt2 = this.v;
    paramInt = this.b;
    bitmap.setPixels(arrayOfInt2, 0, paramInt, 0, 0, paramInt, this.c);
    bitmap = this.z;
    paramInt = this.b;
    bitmap.setPixels(arrayOfInt1, 0, paramInt, 0, 0, paramInt, this.c);
  }
  
  public int c() {
    return this.B;
  }
  
  protected int[] c(int paramInt) {
    byte[] arrayOfByte = new byte[paramInt * 3];
    int[] arrayOfInt = null;
    try {
      this.n.get(arrayOfByte);
      int[] arrayOfInt1 = new int[256];
      int i = 0;
      int j = 0;
      while (true) {
        arrayOfInt = arrayOfInt1;
        if (i < paramInt) {
          int k = j + 1;
          j = arrayOfByte[j];
          int m = k + 1;
          arrayOfInt1[i] = (j & 0xFF) << 16 | 0xFF000000 | (arrayOfByte[k] & 0xFF) << 8 | arrayOfByte[m] & 0xFF;
          j = m + 1;
          i++;
          continue;
        } 
        break;
      } 
    } catch (BufferUnderflowException bufferUnderflowException) {
      Log.w(C, "Format Error Reading Color Table", bufferUnderflowException);
      this.a = 1;
    } 
    return arrayOfInt;
  }
  
  public int d() {
    return this.A;
  }
  
  public Bitmap e() {
    if (this.B > 0) {
      int i = this.A;
      if (i >= 0) {
        if (this.z == null)
          return null; 
        a a1 = this.w.get(i);
        if (a1.k == null) {
          this.h = this.g;
        } else {
          this.h = a1.k;
          if (this.i == a1.h)
            this.j = 0; 
        } 
        if (a1.f) {
          i = this.h[a1.h];
          this.h[a1.h] = 0;
        } else {
          i = 0;
        } 
        if (this.h == null) {
          Log.w(C, "No Valid Color Table");
          this.a = 1;
          return null;
        } 
        b(this.A);
        if (a1.f)
          this.h[a1.h] = i; 
        return this.z;
      } 
    } 
    return null;
  }
  
  protected boolean f() {
    return (this.a != 0);
  }
  
  protected void g() {
    this.a = 0;
    this.B = 0;
    this.A = -1;
    this.w = new ArrayList<a>();
    this.g = null;
  }
  
  protected int h() {
    try {
      byte b = this.n.get();
      return b & 0xFF;
    } catch (Exception exception) {
      this.a = 1;
      return 0;
    } 
  }
  
  protected int i() {
    this.p = h();
    int k = this.p;
    int j = 0;
    int i = 0;
    if (k > 0)
      while (true) {
        j = i;
        try {
          if (i < this.p) {
            j = this.p - i;
            this.n.get(this.o, i, j);
            i += j;
            continue;
          } 
        } catch (Exception exception) {
          Log.w(C, "Error Reading Block", exception);
          this.a = 1;
          j = i;
        } 
        break;
      }  
    return j;
  }
  
  protected void j() {
    boolean bool = false;
    while (!bool && !f()) {
      int i = h();
      if (i != 33) {
        if (i != 44) {
          if (i != 59) {
            this.a = 1;
            continue;
          } 
          bool = true;
          continue;
        } 
        m();
        continue;
      } 
      i = h();
      if (i != 1) {
        if (i != 249) {
          if (i != 254) {
            if (i != 255) {
              q();
              continue;
            } 
            i();
            String str = "";
            for (i = 0; i < 11; i++) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(str);
              stringBuilder.append((char)this.o[i]);
              str = stringBuilder.toString();
            } 
            if (str.equals("NETSCAPE2.0")) {
              o();
              continue;
            } 
            q();
            continue;
          } 
          q();
          continue;
        } 
        this.x = new a();
        l();
        continue;
      } 
      q();
    } 
  }
  
  protected void k() {
    String str = "";
    for (int i = 0; i < 6; i++) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append((char)h());
      str = stringBuilder.toString();
    } 
    if (!str.startsWith("GIF")) {
      this.a = 1;
      return;
    } 
    n();
    if (this.d && !f()) {
      this.g = c(this.e);
      this.j = this.g[this.i];
    } 
  }
  
  protected void l() {
    h();
    int i = h();
    a a1 = this.x;
    a1.g = (i & 0x1C) >> 2;
    int j = a1.g;
    boolean bool = true;
    if (j == 0)
      this.x.g = 1; 
    a1 = this.x;
    if ((i & 0x1) == 0)
      bool = false; 
    a1.f = bool;
    this.x.i = p() * 10;
    this.x.h = h();
    h();
  }
  
  protected void m() {
    this.x.a = p();
    this.x.b = p();
    this.x.c = p();
    this.x.d = p();
    int i = h();
    boolean bool2 = false;
    if ((i & 0x80) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.l = bool1;
    this.m = (int)Math.pow(2.0D, ((i & 0x7) + 1));
    a a1 = this.x;
    boolean bool1 = bool2;
    if ((i & 0x40) != 0)
      bool1 = true; 
    a1.e = bool1;
    if (this.l) {
      this.x.k = c(this.m);
    } else {
      this.x.k = null;
    } 
    this.x.j = this.n.position();
    a((a)null, this.t);
    q();
    if (f())
      return; 
    this.B++;
    this.w.add(this.x);
  }
  
  protected void n() {
    boolean bool;
    this.b = p();
    this.c = p();
    int i = h();
    if ((i & 0x80) != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    this.d = bool;
    this.e = 2 << (i & 0x7);
    this.i = h();
    this.k = h();
    i = this.b;
    int j = this.c;
    this.t = new byte[i * j];
    this.u = new int[i * j];
    this.v = new int[i * j];
    this.y = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    this.z = Bitmap.createBitmap(this.b, this.c, Bitmap.Config.ARGB_8888);
  }
  
  protected void o() {
    do {
      i();
      byte[] arrayOfByte = this.o;
      if (arrayOfByte[0] != 1)
        continue; 
      byte b = arrayOfByte[1];
      this.f = (arrayOfByte[2] & 0xFF) << 8 | b & 0xFF;
    } while (this.p > 0 && !f());
  }
  
  protected int p() {
    return this.n.getShort();
  }
  
  protected void q() {
    do {
      i();
    } while (this.p > 0 && !f());
  }
  
  static class a {
    public int a;
    
    public int b;
    
    public int c;
    
    public int d;
    
    public boolean e;
    
    public boolean f;
    
    public int g;
    
    public int h;
    
    public int i;
    
    public int j;
    
    public int[] k;
    
    private a() {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */