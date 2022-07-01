package a.a.a.a.a.m;

import a.a.a.a.a.e.e;
import a.a.a.a.a.m.b.a;

public final class a {
  public static int a = 15;
  
  public static int b = 10;
  
  public static int c = 3;
  
  public static int d = 10;
  
  public float e;
  
  public int f;
  
  public int g;
  
  public int h;
  
  public int i;
  
  public double j;
  
  public double k;
  
  public a l;
  
  public boolean m = false;
  
  public static a a() {
    return a.a();
  }
  
  public static void a(int paramInt1, int paramInt2) {
    c = paramInt1;
    d = paramInt2;
    e e = e.i;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Threshold: Safe = ");
    stringBuilder.append(c);
    stringBuilder.append(", fps = ");
    stringBuilder.append(d);
    e.b("PLAdaptiveBitrate", stringBuilder.toString());
  }
  
  public final int a(int paramInt) {
    boolean bool = true;
    int i = 1;
    if (paramInt > 0) {
      double d;
      if (this.g - this.h > 5)
        i = 0; 
      if (i) {
        d = 0.20000000298023224D + this.j;
      } else {
        d = 0.0D;
      } 
      this.j = d;
      paramInt = (int)(paramInt + d);
      this.h = this.g;
      this.k = 0.0D;
      return paramInt;
    } 
    i = paramInt;
    if (paramInt < 0) {
      double d;
      if (this.g - this.i <= 5) {
        i = bool;
      } else {
        i = 0;
      } 
      if (i != 0) {
        d = this.k - 0.20000000298023224D;
      } else {
        d = 0.0D;
      } 
      this.k = d;
      i = (int)(paramInt + d);
      this.i = this.g;
      this.j = 0.0D;
    } 
    return i;
  }
  
  public b a(a.a.a.a.a.a.b paramb) {
    // Byte code:
    //   0: getstatic a/a/a/a/a/m/a$b.a : La/a/a/a/a/m/a$b;
    //   3: astore #8
    //   5: aload #8
    //   7: astore #9
    //   9: aload_1
    //   10: ifnull -> 715
    //   13: aload_0
    //   14: getfield m : Z
    //   17: ifne -> 23
    //   20: aload #8
    //   22: areturn
    //   23: aload_1
    //   24: invokevirtual f : ()Lcom/qiniu/pili/droid/streaming/StreamingProfile;
    //   27: astore #10
    //   29: aload #8
    //   31: astore #9
    //   33: aload #10
    //   35: ifnull -> 715
    //   38: aload #10
    //   40: invokevirtual a : ()Z
    //   43: ifne -> 49
    //   46: aload #8
    //   48: areturn
    //   49: aload #10
    //   51: invokevirtual getStreamStatus : ()Lcom/qiniu/pili/droid/streaming/StreamingProfile$StreamStatus;
    //   54: astore #11
    //   56: aload #8
    //   58: astore #9
    //   60: aload #11
    //   62: ifnull -> 715
    //   65: aload #11
    //   67: getfield totalAVBitrateProduce : I
    //   70: istore #6
    //   72: aload #8
    //   74: astore #9
    //   76: iload #6
    //   78: ifeq -> 715
    //   81: aload #11
    //   83: getfield meanTcpSendTimeInMilliseconds : F
    //   86: fstore #4
    //   88: fload #4
    //   90: fconst_0
    //   91: fcmpl
    //   92: ifne -> 98
    //   95: aload #8
    //   97: areturn
    //   98: aload #11
    //   100: getfield totalAVBitrate : I
    //   103: i2d
    //   104: iload #6
    //   106: i2d
    //   107: dsub
    //   108: dstore_2
    //   109: getstatic a/a/a/a/a/e/e.i : La/a/a/a/a/e/e;
    //   112: astore #9
    //   114: new java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial <init> : ()V
    //   121: astore #12
    //   123: aload #12
    //   125: ldc 'diff out - in = '
    //   127: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload #12
    //   133: dload_2
    //   134: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload #9
    //   140: ldc 'PLAdaptiveBitrate'
    //   142: aload #12
    //   144: invokevirtual toString : ()Ljava/lang/String;
    //   147: invokevirtual b : (Ljava/lang/String;Ljava/lang/String;)V
    //   150: aload_0
    //   151: getfield l : La/a/a/a/a/m/b/a;
    //   154: ifnonnull -> 175
    //   157: invokestatic a : ()La/a/a/a/a/m/b/a;
    //   160: astore #9
    //   162: aload_0
    //   163: aload #9
    //   165: putfield l : La/a/a/a/a/m/b/a;
    //   168: aload #9
    //   170: fload #4
    //   172: invokevirtual a : (F)V
    //   175: aload_0
    //   176: getfield e : F
    //   179: fstore #5
    //   181: fload #5
    //   183: fconst_0
    //   184: fcmpl
    //   185: ifle -> 233
    //   188: getstatic a/a/a/a/a/e/e.i : La/a/a/a/a/e/e;
    //   191: astore #9
    //   193: new java/lang/StringBuilder
    //   196: dup
    //   197: invokespecial <init> : ()V
    //   200: astore #12
    //   202: aload #12
    //   204: ldc 'diff send time = '
    //   206: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: aload #12
    //   212: fload #4
    //   214: fload #5
    //   216: fsub
    //   217: invokevirtual append : (F)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload #9
    //   223: ldc 'PLAdaptiveBitrate'
    //   225: aload #12
    //   227: invokevirtual toString : ()Ljava/lang/String;
    //   230: invokevirtual b : (Ljava/lang/String;Ljava/lang/String;)V
    //   233: aload_0
    //   234: aload_0
    //   235: getfield l : La/a/a/a/a/m/b/a;
    //   238: fload #4
    //   240: invokevirtual b : (F)F
    //   243: putfield e : F
    //   246: getstatic a/a/a/a/a/e/e.i : La/a/a/a/a/e/e;
    //   249: astore #9
    //   251: new java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial <init> : ()V
    //   258: astore #12
    //   260: aload #12
    //   262: ldc 'predictedTCPSendTime = '
    //   264: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: pop
    //   268: aload #12
    //   270: aload_0
    //   271: getfield e : F
    //   274: invokevirtual append : (F)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: aload #9
    //   280: ldc 'PLAdaptiveBitrate'
    //   282: aload #12
    //   284: invokevirtual toString : ()Ljava/lang/String;
    //   287: invokevirtual b : (Ljava/lang/String;Ljava/lang/String;)V
    //   290: dload_2
    //   291: dconst_0
    //   292: dcmpl
    //   293: iflt -> 309
    //   296: aload_0
    //   297: aload_0
    //   298: getfield f : I
    //   301: iconst_1
    //   302: iadd
    //   303: putfield f : I
    //   306: goto -> 319
    //   309: aload_0
    //   310: aload_0
    //   311: getfield f : I
    //   314: iconst_1
    //   315: isub
    //   316: putfield f : I
    //   319: invokestatic a : ()La/a/a/a/a/a/j/a;
    //   322: invokevirtual c : ()I
    //   325: invokestatic a : ()La/a/a/a/a/a/j/a;
    //   328: invokevirtual d : ()I
    //   331: invokestatic min : (II)I
    //   334: istore #6
    //   336: getstatic a/a/a/a/a/m/a.d : I
    //   339: iload #6
    //   341: if_icmplt -> 394
    //   344: iload #6
    //   346: iconst_2
    //   347: isub
    //   348: putstatic a/a/a/a/a/m/a.d : I
    //   351: getstatic a/a/a/a/a/e/e.i : La/a/a/a/a/e/e;
    //   354: astore #9
    //   356: new java/lang/StringBuilder
    //   359: dup
    //   360: invokespecial <init> : ()V
    //   363: astore #12
    //   365: aload #12
    //   367: ldc 'FpsDangerousThreshold = '
    //   369: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: pop
    //   373: aload #12
    //   375: getstatic a/a/a/a/a/m/a.d : I
    //   378: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   381: pop
    //   382: aload #9
    //   384: ldc 'PLAdaptiveBitrate'
    //   386: aload #12
    //   388: invokevirtual toString : ()Ljava/lang/String;
    //   391: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   394: aload_0
    //   395: getfield l : La/a/a/a/a/m/b/a;
    //   398: invokevirtual b : ()La/a/a/a/a/m/b/a$b;
    //   401: getstatic a/a/a/a/a/m/b/a$b.b : La/a/a/a/a/m/b/a$b;
    //   404: if_acmpne -> 429
    //   407: aload #11
    //   409: getfield videoFps : I
    //   412: getstatic a/a/a/a/a/m/a.d : I
    //   415: if_icmple -> 429
    //   418: aload_0
    //   419: iconst_0
    //   420: putfield f : I
    //   423: iconst_1
    //   424: istore #6
    //   426: goto -> 456
    //   429: aload_0
    //   430: getfield l : La/a/a/a/a/m/b/a;
    //   433: invokevirtual b : ()La/a/a/a/a/m/b/a$b;
    //   436: getstatic a/a/a/a/a/m/b/a$b.c : La/a/a/a/a/m/b/a$b;
    //   439: if_acmpne -> 453
    //   442: aload_0
    //   443: iconst_0
    //   444: putfield f : I
    //   447: iconst_m1
    //   448: istore #6
    //   450: goto -> 456
    //   453: iconst_0
    //   454: istore #6
    //   456: iload #6
    //   458: istore #7
    //   460: aload_0
    //   461: getfield f : I
    //   464: iconst_3
    //   465: if_icmplt -> 507
    //   468: iload #6
    //   470: istore #7
    //   472: aload_0
    //   473: getfield e : F
    //   476: getstatic a/a/a/a/a/m/a.c : I
    //   479: i2f
    //   480: fcmpg
    //   481: ifge -> 507
    //   484: iload #6
    //   486: istore #7
    //   488: aload #11
    //   490: getfield videoFps : I
    //   493: getstatic a/a/a/a/a/m/a.d : I
    //   496: if_icmple -> 507
    //   499: aload_0
    //   500: iconst_0
    //   501: putfield f : I
    //   504: iconst_1
    //   505: istore #7
    //   507: fload #4
    //   509: getstatic a/a/a/a/a/m/a.a : I
    //   512: i2f
    //   513: fcmpl
    //   514: ifle -> 520
    //   517: goto -> 548
    //   520: iload #7
    //   522: istore #6
    //   524: fload #4
    //   526: getstatic a/a/a/a/a/m/a.b : I
    //   529: i2f
    //   530: fcmpl
    //   531: ifle -> 551
    //   534: iload #7
    //   536: istore #6
    //   538: aload_1
    //   539: invokevirtual s : ()La/a/a/a/a/a/b$c;
    //   542: getstatic a/a/a/a/a/a/b$c.m : La/a/a/a/a/a/b$c;
    //   545: if_acmpne -> 551
    //   548: iconst_m1
    //   549: istore #6
    //   551: getstatic a/a/a/a/a/e/e.i : La/a/a/a/a/e/e;
    //   554: astore #9
    //   556: new java/lang/StringBuilder
    //   559: dup
    //   560: invokespecial <init> : ()V
    //   563: astore #11
    //   565: aload #11
    //   567: ldc 'tcp send time = '
    //   569: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: pop
    //   573: aload #11
    //   575: fload #4
    //   577: invokevirtual append : (F)Ljava/lang/StringBuilder;
    //   580: pop
    //   581: aload #11
    //   583: ldc ', level shift = '
    //   585: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: pop
    //   589: aload #11
    //   591: iload #6
    //   593: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   596: pop
    //   597: aload #9
    //   599: ldc 'PLAdaptiveBitrate'
    //   601: aload #11
    //   603: invokevirtual toString : ()Ljava/lang/String;
    //   606: invokevirtual b : (Ljava/lang/String;Ljava/lang/String;)V
    //   609: iload #6
    //   611: ifeq -> 701
    //   614: iload #6
    //   616: i2f
    //   617: fconst_0
    //   618: fcmpl
    //   619: ifle -> 630
    //   622: getstatic a/a/a/a/a/m/a$b.b : La/a/a/a/a/m/a$b;
    //   625: astore #8
    //   627: goto -> 635
    //   630: getstatic a/a/a/a/a/m/a$b.c : La/a/a/a/a/m/a$b;
    //   633: astore #8
    //   635: aload_0
    //   636: iload #6
    //   638: invokevirtual a : (I)I
    //   641: istore #6
    //   643: iload #6
    //   645: ifeq -> 697
    //   648: aload #8
    //   650: getstatic a/a/a/a/a/m/a$b.c : La/a/a/a/a/m/a$b;
    //   653: if_acmpne -> 670
    //   656: aload #10
    //   658: iload #6
    //   660: invokestatic abs : (I)I
    //   663: invokevirtual reduceVideoQuality : (I)Z
    //   666: pop
    //   667: goto -> 686
    //   670: aload #8
    //   672: getstatic a/a/a/a/a/m/a$b.b : La/a/a/a/a/m/a$b;
    //   675: if_acmpne -> 686
    //   678: aload #10
    //   680: iload #6
    //   682: invokevirtual improveVideoQuality : (I)Z
    //   685: pop
    //   686: aload_1
    //   687: getstatic a/a/a/a/a/a/b$c.q : La/a/a/a/a/a/b$c;
    //   690: aconst_null
    //   691: invokevirtual a : (La/a/a/a/a/a/b$c;Ljava/lang/Object;)V
    //   694: goto -> 701
    //   697: aload_0
    //   698: invokevirtual c : ()V
    //   701: aload_0
    //   702: aload_0
    //   703: getfield g : I
    //   706: iconst_1
    //   707: iadd
    //   708: putfield g : I
    //   711: aload #8
    //   713: astore #9
    //   715: aload #9
    //   717: areturn
  }
  
  public void a(boolean paramBoolean) {
    if (this.m == paramBoolean)
      return; 
    this.m = paramBoolean;
  }
  
  public void b() {
    this.e = -1.0F;
    this.f = 0;
    this.g = 0;
    this.h = 0;
    this.i = 0;
    this.j = 0.0D;
    this.k = 0.0D;
  }
  
  public final void c() {
    this.j = 0.0D;
    this.k = 0.0D;
  }
  
  public static class a {
    public static final a a = new a();
  }
  
  public enum b {
    a, b, c;
    
    static {
      b b1 = new b("PLBitrateShiftTrendingDown", 2);
      c = b1;
      d = new b[] { a, b, b1 };
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\m\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */