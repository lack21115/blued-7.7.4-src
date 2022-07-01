package com.loc;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.crypto.KeyGenerator;

public final class do implements dk {
  private static long k;
  
  Context a = null;
  
  dx b = null;
  
  dw c = null;
  
  cu d;
  
  ax e;
  
  private ArrayList<ca> f = new ArrayList<ca>();
  
  private Handler g;
  
  private LocationManager h;
  
  private a i;
  
  private volatile boolean j = false;
  
  do(Context paramContext) {
    this.a = paramContext;
    this.e = new ax();
    bd.a(this.a, this.e, z.k, 100, 1024000, "0");
    this.e.f = new bp(paramContext, ei.g, "kKey", new bn(paramContext, ei.e, ei.f, ei.f * 10, "carrierLocKey"));
    this.e.e = new am();
  }
  
  private static byte[] a(int paramInt) {
    try {
      KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
      if (keyGenerator == null)
        return null; 
      return keyGenerator.generateKey().getEncoded();
    } finally {
      Exception exception = null;
    } 
  }
  
  private static List<ca> b(ao paramao, ax paramax, List<String> paramList, byte[] paramArrayOfbyte) {
    // Byte code:
    //   0: new java/util/ArrayList
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #18
    //   9: aload_0
    //   10: invokevirtual b : ()Ljava/io/File;
    //   13: astore #13
    //   15: aload #13
    //   17: ifnull -> 663
    //   20: aload #13
    //   22: invokevirtual exists : ()Z
    //   25: ifeq -> 663
    //   28: aload #13
    //   30: invokevirtual list : ()[Ljava/lang/String;
    //   33: astore #13
    //   35: aload #13
    //   37: ifnonnull -> 43
    //   40: aload #18
    //   42: areturn
    //   43: aload #13
    //   45: arraylength
    //   46: istore #7
    //   48: iconst_0
    //   49: istore #6
    //   51: iconst_0
    //   52: istore #4
    //   54: iload #6
    //   56: iload #7
    //   58: if_icmpge -> 651
    //   61: aload #13
    //   63: iload #6
    //   65: aaload
    //   66: astore #16
    //   68: aload #16
    //   70: ldc '.0'
    //   72: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   75: istore #12
    //   77: iload #12
    //   79: ifeq -> 634
    //   82: aconst_null
    //   83: astore #15
    //   85: aconst_null
    //   86: astore #14
    //   88: aload #16
    //   90: ldc '\.'
    //   92: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   95: iconst_0
    //   96: aaload
    //   97: astore #19
    //   99: aload_0
    //   100: aload #19
    //   102: invokevirtual a : (Ljava/lang/String;)Lcom/loc/ao$b;
    //   105: astore #17
    //   107: aload #17
    //   109: ifnonnull -> 125
    //   112: aload #17
    //   114: ifnull -> 634
    //   117: aload #17
    //   119: invokevirtual close : ()V
    //   122: goto -> 634
    //   125: aload #13
    //   127: astore #16
    //   129: aload #17
    //   131: invokevirtual a : ()Ljava/io/InputStream;
    //   134: astore #14
    //   136: aload #14
    //   138: ifnonnull -> 162
    //   141: aload #14
    //   143: ifnull -> 154
    //   146: aload #14
    //   148: invokevirtual close : ()V
    //   151: goto -> 154
    //   154: aload #17
    //   156: ifnull -> 634
    //   159: goto -> 117
    //   162: aload #13
    //   164: astore #16
    //   166: aload #14
    //   168: astore #15
    //   170: iconst_2
    //   171: newarray byte
    //   173: astore #20
    //   175: aload #13
    //   177: astore #16
    //   179: aload #14
    //   181: astore #15
    //   183: aload #14
    //   185: aload #20
    //   187: invokevirtual read : ([B)I
    //   190: pop
    //   191: aload #13
    //   193: astore #16
    //   195: aload #14
    //   197: astore #15
    //   199: aload #20
    //   201: invokestatic b : ([B)I
    //   204: istore #5
    //   206: iload #5
    //   208: ifeq -> 554
    //   211: iload #5
    //   213: ldc 65535
    //   215: if_icmple -> 221
    //   218: goto -> 554
    //   221: aload #13
    //   223: astore #16
    //   225: aload #14
    //   227: astore #15
    //   229: iload #5
    //   231: newarray byte
    //   233: astore #20
    //   235: aload #13
    //   237: astore #16
    //   239: aload #14
    //   241: astore #15
    //   243: aload #14
    //   245: aload #20
    //   247: invokevirtual read : ([B)I
    //   250: pop
    //   251: aload #13
    //   253: astore #16
    //   255: aload #14
    //   257: astore #15
    //   259: iconst_2
    //   260: newarray byte
    //   262: astore #21
    //   264: iconst_0
    //   265: istore #5
    //   267: aload #13
    //   269: astore #16
    //   271: aload #14
    //   273: astore #15
    //   275: aload #14
    //   277: aload #21
    //   279: invokevirtual read : ([B)I
    //   282: istore #8
    //   284: iload #8
    //   286: iflt -> 443
    //   289: aload #21
    //   291: invokestatic b : ([B)I
    //   294: newarray byte
    //   296: astore #15
    //   298: aload #14
    //   300: aload #15
    //   302: invokevirtual read : ([B)I
    //   305: pop
    //   306: aload #20
    //   308: aload #15
    //   310: invokestatic c : ()[B
    //   313: invokestatic a : ([B[B[B)[B
    //   316: astore #15
    //   318: iload #5
    //   320: aload #15
    //   322: arraylength
    //   323: iadd
    //   324: istore #5
    //   326: iconst_4
    //   327: newarray byte
    //   329: astore #16
    //   331: aload #14
    //   333: aload #16
    //   335: invokevirtual read : ([B)I
    //   338: pop
    //   339: aload #16
    //   341: iconst_3
    //   342: baload
    //   343: istore #8
    //   345: aload #16
    //   347: iconst_2
    //   348: baload
    //   349: istore #9
    //   351: aload #16
    //   353: iconst_1
    //   354: baload
    //   355: istore #10
    //   357: aload #16
    //   359: iconst_0
    //   360: baload
    //   361: istore #11
    //   363: aload #15
    //   365: invokestatic b : ([B)[B
    //   368: astore #15
    //   370: invokestatic c : ()[B
    //   373: astore #16
    //   375: aload #18
    //   377: new com/loc/ca
    //   380: dup
    //   381: iload #9
    //   383: sipush #255
    //   386: iand
    //   387: bipush #8
    //   389: ishl
    //   390: iload #8
    //   392: sipush #255
    //   395: iand
    //   396: ior
    //   397: iload #10
    //   399: sipush #255
    //   402: iand
    //   403: bipush #16
    //   405: ishl
    //   406: ior
    //   407: iload #11
    //   409: sipush #255
    //   412: iand
    //   413: bipush #24
    //   415: ishl
    //   416: ior
    //   417: aload_3
    //   418: aload #15
    //   420: aload #16
    //   422: invokestatic b : ([B[B[B)[B
    //   425: invokespecial <init> : (I[B)V
    //   428: invokeinterface add : (Ljava/lang/Object;)Z
    //   433: pop
    //   434: goto -> 267
    //   437: goto -> 440
    //   440: goto -> 583
    //   443: iload #4
    //   445: iload #5
    //   447: iadd
    //   448: istore #5
    //   450: aload_2
    //   451: aload #19
    //   453: invokeinterface add : (Ljava/lang/Object;)Z
    //   458: pop
    //   459: aload_1
    //   460: getfield f : Lcom/loc/bq;
    //   463: invokevirtual b : ()I
    //   466: istore #4
    //   468: iload #5
    //   470: iload #4
    //   472: if_icmple -> 501
    //   475: aload #14
    //   477: ifnull -> 488
    //   480: aload #14
    //   482: invokevirtual close : ()V
    //   485: goto -> 488
    //   488: aload #17
    //   490: ifnull -> 651
    //   493: aload #17
    //   495: invokevirtual close : ()V
    //   498: aload #18
    //   500: areturn
    //   501: aload #14
    //   503: ifnull -> 514
    //   506: aload #14
    //   508: invokevirtual close : ()V
    //   511: goto -> 514
    //   514: iload #5
    //   516: istore #4
    //   518: aload #13
    //   520: astore #14
    //   522: aload #17
    //   524: ifnull -> 638
    //   527: aload #17
    //   529: astore #15
    //   531: iload #5
    //   533: istore #4
    //   535: aload #15
    //   537: invokevirtual close : ()V
    //   540: aload #13
    //   542: astore #14
    //   544: goto -> 638
    //   547: aload #17
    //   549: astore #15
    //   551: goto -> 601
    //   554: aload #14
    //   556: ifnull -> 567
    //   559: aload #14
    //   561: invokevirtual close : ()V
    //   564: goto -> 567
    //   567: aload #17
    //   569: ifnull -> 651
    //   572: goto -> 493
    //   575: aload #16
    //   577: astore #13
    //   579: aload #15
    //   581: astore #14
    //   583: iload #4
    //   585: istore #5
    //   587: aload #17
    //   589: astore #15
    //   591: goto -> 601
    //   594: aconst_null
    //   595: astore #15
    //   597: iload #4
    //   599: istore #5
    //   601: aload #14
    //   603: ifnull -> 614
    //   606: aload #14
    //   608: invokevirtual close : ()V
    //   611: goto -> 614
    //   614: iload #5
    //   616: istore #4
    //   618: aload #13
    //   620: astore #14
    //   622: aload #15
    //   624: ifnull -> 638
    //   627: iload #5
    //   629: istore #4
    //   631: goto -> 535
    //   634: aload #13
    //   636: astore #14
    //   638: iload #6
    //   640: iconst_1
    //   641: iadd
    //   642: istore #6
    //   644: aload #14
    //   646: astore #13
    //   648: goto -> 54
    //   651: aload #18
    //   653: areturn
    //   654: astore_0
    //   655: aload_0
    //   656: ldc 'aps'
    //   658: ldc 'upc'
    //   660: invokestatic b : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   663: aload #18
    //   665: areturn
    //   666: astore #15
    //   668: goto -> 594
    //   671: astore #15
    //   673: goto -> 594
    //   676: astore #14
    //   678: goto -> 634
    //   681: astore #13
    //   683: goto -> 575
    //   686: astore #14
    //   688: goto -> 154
    //   691: astore #15
    //   693: goto -> 440
    //   696: astore #15
    //   698: goto -> 437
    //   701: astore #15
    //   703: goto -> 440
    //   706: astore #15
    //   708: goto -> 547
    //   711: astore #15
    //   713: aload #17
    //   715: astore #15
    //   717: goto -> 601
    //   720: astore_0
    //   721: goto -> 488
    //   724: astore_0
    //   725: aload #18
    //   727: areturn
    //   728: astore #14
    //   730: goto -> 514
    //   733: astore #14
    //   735: aload #13
    //   737: astore #14
    //   739: goto -> 638
    //   742: astore_0
    //   743: goto -> 567
    //   746: astore #14
    //   748: goto -> 614
    // Exception table:
    //   from	to	target	type
    //   9	15	654	finally
    //   20	35	654	finally
    //   43	48	654	finally
    //   68	77	654	finally
    //   88	99	666	finally
    //   99	107	671	finally
    //   117	122	676	finally
    //   129	136	681	finally
    //   146	151	686	finally
    //   170	175	681	finally
    //   183	191	681	finally
    //   199	206	681	finally
    //   229	235	681	finally
    //   243	251	681	finally
    //   259	264	681	finally
    //   275	284	681	finally
    //   289	339	691	finally
    //   363	375	696	finally
    //   375	434	701	finally
    //   450	459	706	finally
    //   459	468	711	finally
    //   480	485	720	finally
    //   493	498	724	finally
    //   506	511	728	finally
    //   535	540	733	finally
    //   559	564	742	finally
    //   606	611	746	finally
  }
  
  private static byte[] b(int paramInt) {
    byte b = (byte)(paramInt & 0xFF);
    return new byte[] { (byte)((paramInt & 0xFF00) >> 8), b };
  }
  
  private void f() {
    try {
      return;
    } finally {
      Exception exception = null;
      ej.a(exception, "clm", "wtD");
    } 
  }
  
  public final dj a(di paramdi) {
    try {
      ed ed = new ed();
      ed.a(paramdi.b);
      ed.a(paramdi.a);
      ed.a(paramdi.d);
      aq.a();
      aw aw = aq.c(ed);
      dj dj = new dj();
      dj.c = aw.a;
      dj.b = aw.b;
      return dj;
    } finally {
      paramdi = null;
    } 
  }
  
  final void a() {
    try {
      if (this.i != null && this.h != null)
        this.h.removeUpdates(this.i); 
      return;
    } finally {
      Exception exception = null;
      ej.a(exception, "clm", "stc");
    } 
  }
  
  public final void a(Location paramLocation) {
    try {
      return;
    } finally {
      paramLocation = null;
      ab.b((Throwable)paramLocation, "cl", "olcc");
    } 
  }
  
  public final void a(dw paramdw, dx paramdx, Handler paramHandler) {
    if (this.j)
      return; 
    if (paramdw != null && paramdx != null) {
      if (paramHandler == null)
        return; 
      this.j = true;
      this.c = paramdw;
      this.b = paramdx;
      this.b.a(this);
      this.c.a(this);
      this.g = paramHandler;
      try {
        if (this.h == null && this.g != null)
          this.h = (LocationManager)this.a.getSystemService("location"); 
        if (this.i == null)
          this.i = new a(this); 
        this.i.a(this);
        if (this.i != null && this.h != null)
          this.h.requestLocationUpdates("passive", 1000L, -1.0F, this.i); 
        return;
      } finally {
        paramdw = null;
      } 
    } 
  }
  
  public final void b() {
    try {
      return;
    } finally {
      Exception exception = null;
      ej.a(exception, "cl", "upw");
    } 
  }
  
  public final void c() {
    try {
      return;
    } finally {
      Exception exception = null;
      ej.a(exception, "cl", "upc");
    } 
  }
  
  public final void d() {
    try {
      if (System.currentTimeMillis() - k < 60000L)
        return; 
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  static final class a implements LocationListener {
    private do a;
    
    a(do param1do) {
      this.a = param1do;
    }
    
    final void a() {
      this.a = null;
    }
    
    final void a(do param1do) {
      this.a = param1do;
    }
    
    public final void onLocationChanged(Location param1Location) {
      try {
        return;
      } finally {
        param1Location = null;
      } 
    }
    
    public final void onProviderDisabled(String param1String) {}
    
    public final void onProviderEnabled(String param1String) {}
    
    public final void onStatusChanged(String param1String, int param1Int, Bundle param1Bundle) {}
  }
  
  final class b implements Runnable {
    private int b = 0;
    
    private Location c;
    
    b(do this$0, int param1Int) {
      this.b = param1Int;
    }
    
    b(Location param1Location) {
      this(1);
      this.c = param1Location;
    }
    
    public final void run() {
      // Byte code:
      //   0: aload_0
      //   1: getfield b : I
      //   4: istore_1
      //   5: iload_1
      //   6: iconst_1
      //   7: if_icmpne -> 485
      //   10: aload_0
      //   11: getfield c : Landroid/location/Location;
      //   14: ifnonnull -> 18
      //   17: return
      //   18: aload_0
      //   19: getfield a : Lcom/loc/do;
      //   22: invokestatic a : (Lcom/loc/do;)Z
      //   25: ifne -> 29
      //   28: return
      //   29: aload_0
      //   30: getfield c : Landroid/location/Location;
      //   33: invokevirtual getExtras : ()Landroid/os/Bundle;
      //   36: astore_2
      //   37: iconst_0
      //   38: istore_1
      //   39: aload_2
      //   40: ifnull -> 50
      //   43: aload_2
      //   44: ldc 'satellites'
      //   46: invokevirtual getInt : (Ljava/lang/String;)I
      //   49: istore_1
      //   50: aload_0
      //   51: getfield c : Landroid/location/Location;
      //   54: iload_1
      //   55: invokestatic a : (Landroid/location/Location;I)Z
      //   58: ifeq -> 62
      //   61: return
      //   62: aload_0
      //   63: getfield a : Lcom/loc/do;
      //   66: getfield b : Lcom/loc/dx;
      //   69: ifnull -> 95
      //   72: aload_0
      //   73: getfield a : Lcom/loc/do;
      //   76: getfield b : Lcom/loc/dx;
      //   79: getfield r : Z
      //   82: ifne -> 95
      //   85: aload_0
      //   86: getfield a : Lcom/loc/do;
      //   89: getfield b : Lcom/loc/dx;
      //   92: invokevirtual f : ()V
      //   95: aload_0
      //   96: getfield a : Lcom/loc/do;
      //   99: getfield b : Lcom/loc/dx;
      //   102: invokevirtual a : ()Ljava/util/ArrayList;
      //   105: astore #4
      //   107: aload_0
      //   108: getfield a : Lcom/loc/do;
      //   111: getfield c : Lcom/loc/dw;
      //   114: invokevirtual a : ()Ljava/util/List;
      //   117: astore_2
      //   118: new com/loc/by$a
      //   121: dup
      //   122: invokespecial <init> : ()V
      //   125: astore_3
      //   126: new com/loc/dc
      //   129: dup
      //   130: invokespecial <init> : ()V
      //   133: astore #5
      //   135: aload #5
      //   137: aload_0
      //   138: getfield c : Landroid/location/Location;
      //   141: invokevirtual getAccuracy : ()F
      //   144: putfield i : F
      //   147: aload #5
      //   149: aload_0
      //   150: getfield c : Landroid/location/Location;
      //   153: invokevirtual getAltitude : ()D
      //   156: putfield f : D
      //   159: aload #5
      //   161: aload_0
      //   162: getfield c : Landroid/location/Location;
      //   165: invokevirtual getLatitude : ()D
      //   168: putfield d : D
      //   171: aload #5
      //   173: aload_0
      //   174: getfield c : Landroid/location/Location;
      //   177: invokevirtual getBearing : ()F
      //   180: putfield h : F
      //   183: aload #5
      //   185: aload_0
      //   186: getfield c : Landroid/location/Location;
      //   189: invokevirtual getLongitude : ()D
      //   192: putfield e : D
      //   195: aload #5
      //   197: aload_0
      //   198: getfield c : Landroid/location/Location;
      //   201: invokevirtual isFromMockProvider : ()Z
      //   204: putfield j : Z
      //   207: aload #5
      //   209: aload_0
      //   210: getfield c : Landroid/location/Location;
      //   213: invokevirtual getProvider : ()Ljava/lang/String;
      //   216: putfield a : Ljava/lang/String;
      //   219: aload #5
      //   221: aload_0
      //   222: getfield c : Landroid/location/Location;
      //   225: invokevirtual getSpeed : ()F
      //   228: putfield g : F
      //   231: aload #5
      //   233: iload_1
      //   234: i2b
      //   235: putfield l : B
      //   238: aload #5
      //   240: invokestatic currentTimeMillis : ()J
      //   243: putfield b : J
      //   246: aload #5
      //   248: aload_0
      //   249: getfield c : Landroid/location/Location;
      //   252: invokevirtual getTime : ()J
      //   255: putfield c : J
      //   258: aload #5
      //   260: aload_0
      //   261: getfield c : Landroid/location/Location;
      //   264: invokevirtual getTime : ()J
      //   267: putfield k : J
      //   270: aload_3
      //   271: aload #5
      //   273: putfield a : Lcom/loc/dc;
      //   276: aload_3
      //   277: aload #4
      //   279: putfield b : Ljava/util/List;
      //   282: aload_0
      //   283: getfield a : Lcom/loc/do;
      //   286: getfield b : Lcom/loc/dx;
      //   289: invokevirtual c : ()Landroid/net/wifi/WifiInfo;
      //   292: astore #4
      //   294: aload #4
      //   296: ifnull -> 311
      //   299: aload_3
      //   300: aload #4
      //   302: invokevirtual getBSSID : ()Ljava/lang/String;
      //   305: invokestatic a : (Ljava/lang/String;)J
      //   308: putfield c : J
      //   311: aload_3
      //   312: getstatic com/loc/dx.w : J
      //   315: putfield d : J
      //   318: aload_3
      //   319: aload_0
      //   320: getfield c : Landroid/location/Location;
      //   323: invokevirtual getTime : ()J
      //   326: putfield f : J
      //   329: aload_3
      //   330: aload_0
      //   331: getfield a : Lcom/loc/do;
      //   334: getfield a : Landroid/content/Context;
      //   337: invokestatic p : (Landroid/content/Context;)I
      //   340: i2b
      //   341: putfield g : B
      //   344: aload_3
      //   345: aload_0
      //   346: getfield a : Lcom/loc/do;
      //   349: getfield a : Landroid/content/Context;
      //   352: invokestatic u : (Landroid/content/Context;)Ljava/lang/String;
      //   355: putfield h : Ljava/lang/String;
      //   358: aload_3
      //   359: aload_0
      //   360: getfield a : Lcom/loc/do;
      //   363: getfield b : Lcom/loc/dx;
      //   366: getfield q : Z
      //   369: putfield e : Z
      //   372: aload_3
      //   373: aload_0
      //   374: getfield a : Lcom/loc/do;
      //   377: getfield a : Landroid/content/Context;
      //   380: invokestatic a : (Landroid/content/Context;)Z
      //   383: putfield j : Z
      //   386: aload_3
      //   387: aload_2
      //   388: putfield i : Ljava/util/List;
      //   391: aload_3
      //   392: invokestatic a : (Lcom/loc/by$a;)Lcom/loc/ca;
      //   395: astore_3
      //   396: aload_3
      //   397: ifnonnull -> 401
      //   400: return
      //   401: aload_0
      //   402: getfield a : Lcom/loc/do;
      //   405: invokestatic b : (Lcom/loc/do;)Ljava/util/ArrayList;
      //   408: astore_2
      //   409: aload_2
      //   410: monitorenter
      //   411: aload_0
      //   412: getfield a : Lcom/loc/do;
      //   415: invokestatic b : (Lcom/loc/do;)Ljava/util/ArrayList;
      //   418: aload_3
      //   419: invokevirtual add : (Ljava/lang/Object;)Z
      //   422: pop
      //   423: aload_0
      //   424: getfield a : Lcom/loc/do;
      //   427: invokestatic b : (Lcom/loc/do;)Ljava/util/ArrayList;
      //   430: invokevirtual size : ()I
      //   433: iconst_5
      //   434: if_icmplt -> 460
      //   437: aload_0
      //   438: getfield a : Lcom/loc/do;
      //   441: astore_3
      //   442: invokestatic d : ()Ljava/util/concurrent/ExecutorService;
      //   445: new com/loc/do$b
      //   448: dup
      //   449: aload_3
      //   450: iconst_3
      //   451: invokespecial <init> : (Lcom/loc/do;I)V
      //   454: invokeinterface submit : (Ljava/lang/Runnable;)Ljava/util/concurrent/Future;
      //   459: pop
      //   460: aload_2
      //   461: monitorexit
      //   462: aload_0
      //   463: getfield a : Lcom/loc/do;
      //   466: invokevirtual d : ()V
      //   469: return
      //   470: astore_3
      //   471: aload_2
      //   472: monitorexit
      //   473: aload_3
      //   474: athrow
      //   475: astore_2
      //   476: aload_2
      //   477: ldc 'cl'
      //   479: ldc 'coll'
      //   481: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
      //   484: return
      //   485: iload_1
      //   486: iconst_2
      //   487: if_icmpne -> 754
      //   490: aconst_null
      //   491: astore #4
      //   493: aconst_null
      //   494: astore_3
      //   495: aload #4
      //   497: astore_2
      //   498: invokestatic currentTimeMillis : ()J
      //   501: invokestatic a : (J)J
      //   504: pop2
      //   505: aload #4
      //   507: astore_2
      //   508: aload_0
      //   509: getfield a : Lcom/loc/do;
      //   512: getfield e : Lcom/loc/ax;
      //   515: getfield f : Lcom/loc/bq;
      //   518: invokevirtual c : ()Z
      //   521: ifeq -> 714
      //   524: aload #4
      //   526: astore_2
      //   527: new java/io/File
      //   530: dup
      //   531: aload_0
      //   532: getfield a : Lcom/loc/do;
      //   535: getfield e : Lcom/loc/ax;
      //   538: getfield a : Ljava/lang/String;
      //   541: invokespecial <init> : (Ljava/lang/String;)V
      //   544: aload_0
      //   545: getfield a : Lcom/loc/do;
      //   548: getfield e : Lcom/loc/ax;
      //   551: getfield b : J
      //   554: invokestatic a : (Ljava/io/File;J)Lcom/loc/ao;
      //   557: astore #4
      //   559: aload #4
      //   561: astore_2
      //   562: new java/util/ArrayList
      //   565: dup
      //   566: invokespecial <init> : ()V
      //   569: astore #5
      //   571: aload #4
      //   573: astore_2
      //   574: invokestatic e : ()[B
      //   577: astore #6
      //   579: aload #6
      //   581: ifnonnull -> 590
      //   584: aload #4
      //   586: invokevirtual close : ()V
      //   589: return
      //   590: aload #4
      //   592: astore_2
      //   593: aload #4
      //   595: aload_0
      //   596: getfield a : Lcom/loc/do;
      //   599: getfield e : Lcom/loc/ax;
      //   602: aload #5
      //   604: aload #6
      //   606: invokestatic a : (Lcom/loc/ao;Lcom/loc/ax;Ljava/util/List;[B)Ljava/util/List;
      //   609: astore #7
      //   611: aload #7
      //   613: ifnull -> 708
      //   616: aload #4
      //   618: astore_2
      //   619: aload #7
      //   621: invokeinterface size : ()I
      //   626: ifne -> 632
      //   629: goto -> 708
      //   632: aload #4
      //   634: astore_2
      //   635: aload_0
      //   636: getfield a : Lcom/loc/do;
      //   639: getfield e : Lcom/loc/ax;
      //   642: getfield f : Lcom/loc/bq;
      //   645: iconst_1
      //   646: invokevirtual a : (Z)V
      //   649: aload #4
      //   651: astore_2
      //   652: aload #6
      //   654: invokestatic a : ()[B
      //   657: invokestatic c : ()[B
      //   660: invokestatic b : ([B[B[B)[B
      //   663: astore #8
      //   665: aload #4
      //   667: astore_3
      //   668: aload #4
      //   670: astore_2
      //   671: aload #6
      //   673: invokestatic a : ([B)[B
      //   676: aload #8
      //   678: aload #7
      //   680: invokestatic a : ([B[BLjava/util/List;)[B
      //   683: invokestatic b : ([B)[B
      //   686: invokestatic a : ([B)Z
      //   689: ifeq -> 714
      //   692: aload #4
      //   694: astore_2
      //   695: aload #4
      //   697: aload #5
      //   699: invokestatic a : (Lcom/loc/ao;Ljava/util/List;)V
      //   702: aload #4
      //   704: astore_3
      //   705: goto -> 714
      //   708: aload #4
      //   710: invokevirtual close : ()V
      //   713: return
      //   714: aload_3
      //   715: ifnull -> 742
      //   718: aload_3
      //   719: invokevirtual close : ()V
      //   722: return
      //   723: astore_3
      //   724: aload_3
      //   725: ldc_w 'leg'
      //   728: ldc_w 'uts'
      //   731: invokestatic b : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
      //   734: aload_2
      //   735: ifnull -> 742
      //   738: aload_2
      //   739: invokevirtual close : ()V
      //   742: return
      //   743: astore_3
      //   744: aload_2
      //   745: ifnull -> 752
      //   748: aload_2
      //   749: invokevirtual close : ()V
      //   752: aload_3
      //   753: athrow
      //   754: iload_1
      //   755: iconst_3
      //   756: if_icmpne -> 766
      //   759: aload_0
      //   760: getfield a : Lcom/loc/do;
      //   763: invokestatic c : (Lcom/loc/do;)V
      //   766: return
      //   767: astore_3
      //   768: goto -> 460
      //   771: astore_2
      //   772: return
      //   773: astore_2
      //   774: return
      //   775: astore_2
      //   776: return
      //   777: astore_2
      //   778: return
      //   779: astore_2
      //   780: goto -> 752
      // Exception table:
      //   from	to	target	type
      //   10	17	475	finally
      //   18	28	475	finally
      //   29	37	475	finally
      //   43	50	475	finally
      //   50	61	475	finally
      //   62	95	475	finally
      //   95	294	475	finally
      //   299	311	475	finally
      //   311	396	475	finally
      //   401	411	475	finally
      //   411	442	470	finally
      //   442	460	767	finally
      //   460	462	470	finally
      //   462	469	475	finally
      //   471	473	470	finally
      //   473	475	475	finally
      //   498	505	723	finally
      //   508	524	723	finally
      //   527	559	723	finally
      //   562	571	723	finally
      //   574	579	723	finally
      //   584	589	771	finally
      //   593	611	723	finally
      //   619	629	723	finally
      //   635	649	723	finally
      //   652	665	723	finally
      //   671	692	723	finally
      //   695	702	723	finally
      //   708	713	773	finally
      //   718	722	775	finally
      //   724	734	743	finally
      //   738	742	777	finally
      //   748	752	779	finally
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\do.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */