package com.amap.api.mapcore2d;

import android.content.Context;
import android.os.Build;
import android.os.HandlerThread;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public final class gn {
  int a = 0;
  
  ArrayList<gm> b = new ArrayList<gm>();
  
  TelephonyManager c = null;
  
  long d = 0L;
  
  CellLocation e;
  
  boolean f = false;
  
  PhoneStateListener g = null;
  
  String h = null;
  
  boolean i = false;
  
  StringBuilder j = null;
  
  HandlerThread k = null;
  
  private Context l;
  
  private String m = null;
  
  private ArrayList<gm> n = new ArrayList<gm>();
  
  private int o = -113;
  
  private gl p = null;
  
  private Object q;
  
  private int r = 0;
  
  private long s = 0L;
  
  private boolean t = false;
  
  private Object u = new Object();
  
  public gn(Context paramContext) {
    this.l = paramContext;
    if (this.c == null)
      this.c = (TelephonyManager)gy.a(this.l, "phone"); 
    j();
    this.p = new gl();
  }
  
  private CellLocation a(Object paramObject, String paramString, Object... paramVarArgs) {
    if (paramObject == null)
      return null; 
    try {
      paramObject = gw.a(paramObject, paramString, paramVarArgs);
      if (paramObject != null) {
        paramObject = paramObject;
      } else {
        paramObject = null;
      } 
      return (CellLocation)(bool ? paramObject : null);
    } finally {
      paramObject = null;
    } 
  }
  
  private CellLocation a(List<CellInfo> paramList) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #4
    //   3: aload_1
    //   4: ifnull -> 346
    //   7: aload_1
    //   8: invokeinterface isEmpty : ()Z
    //   13: ifeq -> 18
    //   16: aconst_null
    //   17: areturn
    //   18: iconst_0
    //   19: istore_2
    //   20: iload_2
    //   21: aload_1
    //   22: invokeinterface size : ()I
    //   27: if_icmpge -> 233
    //   30: aload_1
    //   31: iload_2
    //   32: invokeinterface get : (I)Ljava/lang/Object;
    //   37: checkcast android/telephony/CellInfo
    //   40: astore #5
    //   42: aload #5
    //   44: ifnull -> 226
    //   47: aload #5
    //   49: invokevirtual isRegistered : ()Z
    //   52: istore_3
    //   53: aload #5
    //   55: instanceof android/telephony/CellInfoCdma
    //   58: ifeq -> 97
    //   61: aload #5
    //   63: checkcast android/telephony/CellInfoCdma
    //   66: astore #5
    //   68: aload #5
    //   70: invokevirtual getCellIdentity : ()Landroid/telephony/CellIdentityCdma;
    //   73: invokestatic a : (Landroid/telephony/CellIdentityCdma;)Z
    //   76: ifne -> 82
    //   79: goto -> 226
    //   82: aload_0
    //   83: aload #5
    //   85: iload_3
    //   86: invokespecial a : (Landroid/telephony/CellInfoCdma;Z)Lcom/amap/api/mapcore2d/gm;
    //   89: astore #5
    //   91: aload #5
    //   93: astore_1
    //   94: goto -> 235
    //   97: aload #5
    //   99: instanceof android/telephony/CellInfoGsm
    //   102: ifeq -> 140
    //   105: aload #5
    //   107: checkcast android/telephony/CellInfoGsm
    //   110: astore #5
    //   112: aload #5
    //   114: invokevirtual getCellIdentity : ()Landroid/telephony/CellIdentityGsm;
    //   117: invokestatic a : (Landroid/telephony/CellIdentityGsm;)Z
    //   120: ifne -> 126
    //   123: goto -> 226
    //   126: aload #5
    //   128: iload_3
    //   129: invokestatic a : (Landroid/telephony/CellInfoGsm;Z)Lcom/amap/api/mapcore2d/gm;
    //   132: astore #5
    //   134: aload #5
    //   136: astore_1
    //   137: goto -> 235
    //   140: aload #5
    //   142: instanceof android/telephony/CellInfoWcdma
    //   145: ifeq -> 183
    //   148: aload #5
    //   150: checkcast android/telephony/CellInfoWcdma
    //   153: astore #5
    //   155: aload #5
    //   157: invokevirtual getCellIdentity : ()Landroid/telephony/CellIdentityWcdma;
    //   160: invokestatic a : (Landroid/telephony/CellIdentityWcdma;)Z
    //   163: ifne -> 169
    //   166: goto -> 226
    //   169: aload #5
    //   171: iload_3
    //   172: invokestatic a : (Landroid/telephony/CellInfoWcdma;Z)Lcom/amap/api/mapcore2d/gm;
    //   175: astore #5
    //   177: aload #5
    //   179: astore_1
    //   180: goto -> 235
    //   183: aload #5
    //   185: instanceof android/telephony/CellInfoLte
    //   188: ifeq -> 233
    //   191: aload #5
    //   193: checkcast android/telephony/CellInfoLte
    //   196: astore #5
    //   198: aload #5
    //   200: invokevirtual getCellIdentity : ()Landroid/telephony/CellIdentityLte;
    //   203: invokestatic a : (Landroid/telephony/CellIdentityLte;)Z
    //   206: ifne -> 212
    //   209: goto -> 226
    //   212: aload #5
    //   214: iload_3
    //   215: invokestatic a : (Landroid/telephony/CellInfoLte;Z)Lcom/amap/api/mapcore2d/gm;
    //   218: astore #5
    //   220: aload #5
    //   222: astore_1
    //   223: goto -> 235
    //   226: iload_2
    //   227: iconst_1
    //   228: iadd
    //   229: istore_2
    //   230: goto -> 20
    //   233: aconst_null
    //   234: astore_1
    //   235: aload_1
    //   236: ifnull -> 326
    //   239: aload_1
    //   240: getfield k : I
    //   243: iconst_2
    //   244: if_icmpne -> 293
    //   247: new android/telephony/cdma/CdmaCellLocation
    //   250: dup
    //   251: invokespecial <init> : ()V
    //   254: astore #5
    //   256: aload #5
    //   258: aload_1
    //   259: getfield i : I
    //   262: aload_1
    //   263: getfield e : I
    //   266: aload_1
    //   267: getfield f : I
    //   270: aload_1
    //   271: getfield g : I
    //   274: aload_1
    //   275: getfield h : I
    //   278: invokevirtual setCellLocationData : (IIIII)V
    //   281: aload #5
    //   283: astore_1
    //   284: goto -> 337
    //   287: aload #5
    //   289: astore_1
    //   290: goto -> 337
    //   293: new android/telephony/gsm/GsmCellLocation
    //   296: dup
    //   297: invokespecial <init> : ()V
    //   300: astore #5
    //   302: aload #5
    //   304: aload_1
    //   305: getfield c : I
    //   308: aload_1
    //   309: getfield d : I
    //   312: invokevirtual setLacAndCid : (II)V
    //   315: aload #5
    //   317: astore_1
    //   318: goto -> 328
    //   321: aconst_null
    //   322: astore_1
    //   323: goto -> 337
    //   326: aconst_null
    //   327: astore_1
    //   328: aconst_null
    //   329: astore #5
    //   331: aload_1
    //   332: astore #4
    //   334: aload #5
    //   336: astore_1
    //   337: aload_1
    //   338: ifnonnull -> 344
    //   341: aload #4
    //   343: areturn
    //   344: aload_1
    //   345: areturn
    //   346: aconst_null
    //   347: areturn
    //   348: astore #5
    //   350: goto -> 226
    //   353: astore_1
    //   354: goto -> 321
    //   357: astore_1
    //   358: goto -> 287
    //   361: astore_1
    //   362: aload #5
    //   364: astore_1
    //   365: goto -> 328
    // Exception table:
    //   from	to	target	type
    //   47	79	348	finally
    //   82	91	348	finally
    //   97	123	348	finally
    //   126	134	348	finally
    //   140	166	348	finally
    //   169	177	348	finally
    //   183	209	348	finally
    //   212	220	348	finally
    //   239	256	353	finally
    //   256	281	357	finally
    //   293	302	353	finally
    //   302	315	361	finally
  }
  
  private static gm a(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
    gm gm = new gm(paramInt1, paramBoolean);
    gm.a = paramInt2;
    gm.b = paramInt3;
    gm.c = paramInt4;
    gm.d = paramInt5;
    gm.j = paramInt6;
    return gm;
  }
  
  private gm a(CellInfoCdma paramCellInfoCdma, boolean paramBoolean) {
    boolean bool1;
    CellIdentityCdma cellIdentityCdma = paramCellInfoCdma.getCellIdentity();
    String[] arrayOfString = gy.a(this.c);
    try {
      int i = Integer.parseInt(arrayOfString[0]);
    } finally {
      arrayOfString = null;
    } 
    boolean bool3 = false;
    boolean bool2 = bool1;
    gm gm = a(2, paramBoolean, bool2, bool3, 0, 0, gm.getCellSignalStrength().getCdmaDbm());
    gm.g = cellIdentityCdma.getSystemId();
    gm.h = cellIdentityCdma.getNetworkId();
    gm.i = cellIdentityCdma.getBasestationId();
    gm.e = cellIdentityCdma.getLatitude();
    gm.f = cellIdentityCdma.getLongitude();
    return gm;
  }
  
  private static gm a(CellInfoGsm paramCellInfoGsm, boolean paramBoolean) {
    CellIdentityGsm cellIdentityGsm = paramCellInfoGsm.getCellIdentity();
    return a(1, paramBoolean, cellIdentityGsm.getMcc(), cellIdentityGsm.getMnc(), cellIdentityGsm.getLac(), cellIdentityGsm.getCid(), paramCellInfoGsm.getCellSignalStrength().getDbm());
  }
  
  private static gm a(CellInfoLte paramCellInfoLte, boolean paramBoolean) {
    CellIdentityLte cellIdentityLte = paramCellInfoLte.getCellIdentity();
    gm gm = a(3, paramBoolean, cellIdentityLte.getMcc(), cellIdentityLte.getMnc(), cellIdentityLte.getTac(), cellIdentityLte.getCi(), paramCellInfoLte.getCellSignalStrength().getDbm());
    gm.o = cellIdentityLte.getPci();
    return gm;
  }
  
  private static gm a(CellInfoWcdma paramCellInfoWcdma, boolean paramBoolean) {
    CellIdentityWcdma cellIdentityWcdma = paramCellInfoWcdma.getCellIdentity();
    gm gm = a(4, paramBoolean, cellIdentityWcdma.getMcc(), cellIdentityWcdma.getMnc(), cellIdentityWcdma.getLac(), cellIdentityWcdma.getCid(), paramCellInfoWcdma.getCellSignalStrength().getDbm());
    gm.o = cellIdentityWcdma.getPsc();
    return gm;
  }
  
  private static gm a(NeighboringCellInfo paramNeighboringCellInfo, String[] paramArrayOfString) {
    try {
      gm gm = new gm(1, false);
      gm.a = Integer.parseInt(paramArrayOfString[0]);
      gm.b = Integer.parseInt(paramArrayOfString[1]);
      gm.c = gw.b(paramNeighboringCellInfo, "getLac", new Object[0]);
      return gm;
    } finally {
      paramNeighboringCellInfo = null;
      gu.a((Throwable)paramNeighboringCellInfo, "CgiManager", "getGsm");
    } 
  }
  
  private void a(CellLocation paramCellLocation, String[] paramArrayOfString) {
    if (paramCellLocation != null) {
      List list;
      if (this.c == null)
        return; 
      this.b.clear();
      if (!b(paramCellLocation))
        return; 
      this.a = 1;
      CellLocation cellLocation = null;
      this.b.add(c(paramCellLocation, paramArrayOfString));
      paramCellLocation = cellLocation;
      if (Build.VERSION.SDK_INT <= 28)
        list = (List)gw.a(this.c, "getNeighboringCellInfo", new Object[0]); 
      if (list != null) {
        if (list.isEmpty())
          return; 
        for (NeighboringCellInfo neighboringCellInfo : list) {
          if (neighboringCellInfo != null && a(neighboringCellInfo.getLac(), neighboringCellInfo.getCid())) {
            gm gm = a(neighboringCellInfo, paramArrayOfString);
            if (gm != null && !this.b.contains(gm))
              this.b.add(gm); 
          } 
        } 
      } 
    } 
  }
  
  public static boolean a(int paramInt) {
    return !(paramInt <= 0 || paramInt > 15);
  }
  
  private static boolean a(int paramInt1, int paramInt2) {
    return !(paramInt1 == -1 || paramInt1 == 0 || paramInt1 > 65535 || paramInt2 == -1 || paramInt2 == 0 || paramInt2 == 65535 || paramInt2 >= 268435455);
  }
  
  private static boolean a(CellIdentityCdma paramCellIdentityCdma) {
    return (paramCellIdentityCdma == null) ? false : ((paramCellIdentityCdma.getSystemId() > 0 && paramCellIdentityCdma.getNetworkId() >= 0 && paramCellIdentityCdma.getBasestationId() >= 0));
  }
  
  private static boolean a(CellIdentityGsm paramCellIdentityGsm) {
    return (paramCellIdentityGsm == null) ? false : ((c(paramCellIdentityGsm.getLac()) && d(paramCellIdentityGsm.getCid())));
  }
  
  private static boolean a(CellIdentityLte paramCellIdentityLte) {
    return (paramCellIdentityLte == null) ? false : ((c(paramCellIdentityLte.getTac()) && d(paramCellIdentityLte.getCi())));
  }
  
  private static boolean a(CellIdentityWcdma paramCellIdentityWcdma) {
    return (paramCellIdentityWcdma == null) ? false : ((c(paramCellIdentityWcdma.getLac()) && d(paramCellIdentityWcdma.getCid())));
  }
  
  private void b(int paramInt) {
    if (paramInt == -113) {
      this.o = -113;
      return;
    } 
    this.o = paramInt;
    paramInt = this.a;
    if (paramInt != 1 && paramInt != 2)
      return; 
    ArrayList<gm> arrayList = this.b;
    if (arrayList != null && !arrayList.isEmpty())
      try {
        return;
      } finally {
        arrayList = null;
      }  
  }
  
  private void b(CellLocation paramCellLocation, String[] paramArrayOfString) {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull -> 5
    //   4: return
    //   5: aload_0
    //   6: getfield b : Ljava/util/ArrayList;
    //   9: invokevirtual clear : ()V
    //   12: invokestatic c : ()I
    //   15: iconst_5
    //   16: if_icmpge -> 20
    //   19: return
    //   20: aload_0
    //   21: getfield q : Ljava/lang/Object;
    //   24: astore #5
    //   26: iconst_1
    //   27: istore #4
    //   29: aload #5
    //   31: ifnull -> 104
    //   34: aload_1
    //   35: invokevirtual getClass : ()Ljava/lang/Class;
    //   38: ldc_w 'mGsmCellLoc'
    //   41: invokevirtual getDeclaredField : (Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   44: astore #5
    //   46: aload #5
    //   48: invokevirtual isAccessible : ()Z
    //   51: ifne -> 60
    //   54: aload #5
    //   56: iconst_1
    //   57: invokevirtual setAccessible : (Z)V
    //   60: aload #5
    //   62: aload_1
    //   63: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   66: checkcast android/telephony/gsm/GsmCellLocation
    //   69: astore #5
    //   71: aload #5
    //   73: ifnull -> 97
    //   76: aload_0
    //   77: aload #5
    //   79: invokespecial b : (Landroid/telephony/CellLocation;)Z
    //   82: ifeq -> 97
    //   85: aload_0
    //   86: aload #5
    //   88: aload_2
    //   89: invokespecial a : (Landroid/telephony/CellLocation;[Ljava/lang/String;)V
    //   92: iconst_1
    //   93: istore_3
    //   94: goto -> 99
    //   97: iconst_0
    //   98: istore_3
    //   99: iload_3
    //   100: ifeq -> 104
    //   103: return
    //   104: aload_0
    //   105: aload_1
    //   106: invokespecial b : (Landroid/telephony/CellLocation;)Z
    //   109: ifne -> 113
    //   112: return
    //   113: aload_0
    //   114: iconst_2
    //   115: putfield a : I
    //   118: new com/amap/api/mapcore2d/gm
    //   121: dup
    //   122: iconst_2
    //   123: iconst_1
    //   124: invokespecial <init> : (IZ)V
    //   127: astore #5
    //   129: aload #5
    //   131: aload_2
    //   132: iconst_0
    //   133: aaload
    //   134: invokestatic parseInt : (Ljava/lang/String;)I
    //   137: putfield a : I
    //   140: aload #5
    //   142: aload_2
    //   143: iconst_1
    //   144: aaload
    //   145: invokestatic parseInt : (Ljava/lang/String;)I
    //   148: putfield b : I
    //   151: aload #5
    //   153: aload_1
    //   154: ldc_w 'getSystemId'
    //   157: iconst_0
    //   158: anewarray java/lang/Object
    //   161: invokestatic b : (Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)I
    //   164: putfield g : I
    //   167: aload #5
    //   169: aload_1
    //   170: ldc_w 'getNetworkId'
    //   173: iconst_0
    //   174: anewarray java/lang/Object
    //   177: invokestatic b : (Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)I
    //   180: putfield h : I
    //   183: aload #5
    //   185: aload_1
    //   186: ldc_w 'getBaseStationId'
    //   189: iconst_0
    //   190: anewarray java/lang/Object
    //   193: invokestatic b : (Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)I
    //   196: putfield i : I
    //   199: aload #5
    //   201: aload_0
    //   202: getfield o : I
    //   205: putfield j : I
    //   208: aload #5
    //   210: aload_1
    //   211: ldc_w 'getBaseStationLatitude'
    //   214: iconst_0
    //   215: anewarray java/lang/Object
    //   218: invokestatic b : (Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)I
    //   221: putfield e : I
    //   224: aload #5
    //   226: aload_1
    //   227: ldc_w 'getBaseStationLongitude'
    //   230: iconst_0
    //   231: anewarray java/lang/Object
    //   234: invokestatic b : (Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)I
    //   237: putfield f : I
    //   240: aload #5
    //   242: getfield e : I
    //   245: aload #5
    //   247: getfield f : I
    //   250: if_icmpne -> 361
    //   253: aload #5
    //   255: getfield e : I
    //   258: ifle -> 361
    //   261: iload #4
    //   263: istore_3
    //   264: goto -> 267
    //   267: aload #5
    //   269: getfield e : I
    //   272: iflt -> 309
    //   275: aload #5
    //   277: getfield f : I
    //   280: iflt -> 309
    //   283: aload #5
    //   285: getfield e : I
    //   288: ldc_w 2147483647
    //   291: if_icmpeq -> 309
    //   294: aload #5
    //   296: getfield f : I
    //   299: ldc_w 2147483647
    //   302: if_icmpeq -> 309
    //   305: iload_3
    //   306: ifeq -> 321
    //   309: aload #5
    //   311: iconst_0
    //   312: putfield e : I
    //   315: aload #5
    //   317: iconst_0
    //   318: putfield f : I
    //   321: aload_0
    //   322: getfield b : Ljava/util/ArrayList;
    //   325: aload #5
    //   327: invokevirtual contains : (Ljava/lang/Object;)Z
    //   330: ifne -> 343
    //   333: aload_0
    //   334: getfield b : Ljava/util/ArrayList;
    //   337: aload #5
    //   339: invokevirtual add : (Ljava/lang/Object;)Z
    //   342: pop
    //   343: return
    //   344: astore_1
    //   345: aload_1
    //   346: ldc_w 'CgiManager'
    //   349: ldc_w 'hdlCdmaLocChange'
    //   352: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   355: return
    //   356: astore #5
    //   358: goto -> 97
    //   361: iconst_0
    //   362: istore_3
    //   363: goto -> 267
    // Exception table:
    //   from	to	target	type
    //   20	26	344	finally
    //   34	60	356	finally
    //   60	71	356	finally
    //   76	92	356	finally
    //   104	112	344	finally
    //   113	261	344	finally
    //   267	305	344	finally
    //   309	321	344	finally
    //   321	343	344	finally
  }
  
  private boolean b(CellLocation paramCellLocation) {
    boolean bool = a(paramCellLocation);
    if (!bool)
      this.a = 0; 
    return bool;
  }
  
  private int c(CellLocation paramCellLocation) {
    if (this.i)
      return 0; 
    if (paramCellLocation == null)
      return 0; 
    if (paramCellLocation instanceof GsmCellLocation)
      return 1; 
    try {
      return 2;
    } finally {
      paramCellLocation = null;
      gu.a((Throwable)paramCellLocation, "Utils", "getCellLocT");
    } 
  }
  
  private gm c(CellLocation paramCellLocation, String[] paramArrayOfString) {
    GsmCellLocation gsmCellLocation = (GsmCellLocation)paramCellLocation;
    gm gm = new gm(1, true);
    gm.a = gy.d(paramArrayOfString[0]);
    gm.b = gy.d(paramArrayOfString[1]);
    gm.c = gsmCellLocation.getLac();
    gm.d = gsmCellLocation.getCid();
    gm.j = this.o;
    return gm;
  }
  
  private static boolean c(int paramInt) {
    return !(paramInt == -1 || paramInt == 0 || paramInt > 65535);
  }
  
  private static boolean d(int paramInt) {
    return !(paramInt == -1 || paramInt == 0 || paramInt == 65535 || paramInt >= 268435455);
  }
  
  private void j() {
    TelephonyManager telephonyManager = this.c;
    if (telephonyManager == null)
      return; 
    try {
      CellLocation cellLocation = telephonyManager.getCellLocation();
      Context context = this.l;
      this.a = c(cellLocation);
    } catch (SecurityException securityException) {
    
    } finally {
      telephonyManager = null;
      this.h = null;
      gu.a((Throwable)telephonyManager, "CgiManager", "CgiManager");
    } 
  }
  
  private void k() {
    String str;
    this.g = new PhoneStateListener(this) {
        public final void onCellLocationChanged(CellLocation param1CellLocation) {
          try {
            if (!this.a.a(param1CellLocation))
              return; 
            this.a.e = param1CellLocation;
            this.a.f = true;
            return;
          } finally {
            param1CellLocation = null;
          } 
        }
        
        public final void onServiceStateChanged(ServiceState param1ServiceState) {
          try {
            int i = param1ServiceState.getState();
            if (i != 0) {
              if (i != 1)
                return; 
              return;
            } 
            return;
          } finally {
            param1ServiceState = null;
          } 
        }
        
        public final void onSignalStrengthChanged(int param1Int) {
          byte b = -113;
          try {
            int i = this.a.a;
            if (i != 1 && i != 2) {
              param1Int = b;
            } else {
              param1Int = gy.a(param1Int);
            } 
            return;
          } finally {
            Exception exception = null;
          } 
        }
        
        public final void onSignalStrengthsChanged(SignalStrength param1SignalStrength) {
          if (param1SignalStrength == null)
            return; 
          int i = -113;
          try {
            int j = this.a.a;
            if (j != 1) {
              if (j == 2)
                i = param1SignalStrength.getCdmaDbm(); 
            } else {
              i = gy.a(param1SignalStrength.getGsmSignalStrength());
            } 
            return;
          } finally {
            param1SignalStrength = null;
          } 
        }
      };
  }
  
  private CellLocation l() {
    TelephonyManager telephonyManager = this.c;
    if (telephonyManager != null)
      try {
        CellLocation cellLocation = telephonyManager.getCellLocation();
        this.h = null;
        if (b(cellLocation))
          return cellLocation; 
      } catch (SecurityException securityException) {
      
      } finally {
        telephonyManager = null;
        this.h = null;
        gu.a((Throwable)telephonyManager, "CgiManager", "getCellLocation");
      }  
    return null;
  }
  
  private boolean m() {
    return this.i ? false : (!(gy.b() - this.d < 10000L));
  }
  
  private void n() {
    h();
  }
  
  private void o() {
    int i = d();
    if (i != 1) {
      if (i != 2)
        return; 
      if (this.b.isEmpty()) {
        this.a = 0;
        return;
      } 
    } else if (this.b.isEmpty()) {
      this.a = 0;
    } 
  }
  
  private void p() {
    if (!this.i && this.c != null) {
      CellLocation cellLocation2 = q();
      CellLocation cellLocation1 = cellLocation2;
      if (!b(cellLocation2))
        cellLocation1 = r(); 
      if (b(cellLocation1)) {
        this.e = cellLocation1;
        this.s = gy.b();
      } else if (gy.b() - this.s > 60000L) {
        this.e = null;
        this.b.clear();
        this.n.clear();
      } 
    } 
    if (!this.f)
      CellLocation cellLocation = this.e; 
    this.f = true;
    if (b(this.e)) {
      String[] arrayOfString = gy.a(this.c);
      CellLocation cellLocation = this.e;
      Context context = this.l;
      int i = c(cellLocation);
      if (i != 1) {
        if (i == 2)
          b(this.e, arrayOfString); 
      } else {
        a(this.e, arrayOfString);
      } 
    } 
    try {
      if (gy.c() >= 18)
        t(); 
    } finally {
      Exception exception;
    } 
    TelephonyManager telephonyManager = this.c;
    if (telephonyManager != null) {
      this.m = telephonyManager.getNetworkOperator();
      if (!TextUtils.isEmpty(this.m))
        this.a |= 0x8; 
    } 
  }
  
  private CellLocation q() {
    TelephonyManager telephonyManager = this.c;
    CellLocation cellLocation2 = null;
    if (telephonyManager == null)
      return null; 
    CellLocation cellLocation1 = l();
    if (b(cellLocation1))
      return cellLocation1; 
    cellLocation1 = cellLocation2;
    if (gy.c() >= 18)
      try {
        cellLocation1 = a(telephonyManager.getAllCellInfo());
      } catch (SecurityException securityException) {
        this.h = securityException.getMessage();
        cellLocation1 = cellLocation2;
      }  
    if (cellLocation1 != null)
      return cellLocation1; 
    cellLocation1 = a(telephonyManager, "getCellLocationExt", new Object[] { Integer.valueOf(1) });
    return (cellLocation1 != null) ? cellLocation1 : a(telephonyManager, "getCellLocationGemini", new Object[] { Integer.valueOf(1) });
  }
  
  private CellLocation r() {
    Object object = this.q;
    CellLocation cellLocation2 = null;
    CellLocation cellLocation3 = null;
    if (object == null)
      return null; 
    CellLocation cellLocation1 = cellLocation3;
    try {
      Class<?> clazz = s();
    } finally {
      cellLocation2 = null;
      gu.a((Throwable)cellLocation2, "CgiManager", "getSim2Cgi");
    } 
    return cellLocation2;
  }
  
  private Class<?> s() {
    String str;
    ClassLoader classLoader = ClassLoader.getSystemClassLoader();
    int i = this.r;
    if (i != 0) {
      if (i != 1) {
        if (i != 2) {
          str = null;
        } else {
          str = "android.telephony.TelephonyManager2";
        } 
      } else {
        str = "android.telephony.MSimTelephonyManager";
      } 
    } else {
      str = "android.telephony.TelephonyManager";
    } 
    try {
      return classLoader.loadClass(str);
    } finally {
      str = null;
      gu.a((Throwable)str, "CgiManager", "getSim2TmClass");
    } 
  }
  
  private void t() {
    SecurityException securityException1;
    TelephonyManager telephonyManager = this.c;
    if (telephonyManager == null)
      return; 
    ArrayList<gm> arrayList = this.n;
    gl gl1 = this.p;
    List list = null;
    try {
      List list1 = telephonyManager.getAllCellInfo();
      try {
        this.h = null;
        list = list1;
      } catch (SecurityException securityException2) {}
    } catch (SecurityException securityException) {
      securityException1 = securityException2;
      securityException2 = securityException;
    } 
    this.h = securityException2.getMessage();
    securityException2 = securityException1;
  }
  
  private int u() {
    try {
      Class.forName("android.telephony.MSimTelephonyManager");
      this.r = 1;
    } finally {
      Exception exception;
    } 
    if (this.r == 0)
      try {
        Class.forName("android.telephony.TelephonyManager2");
        this.r = 2;
      } finally {
        Exception exception;
      }  
    return this.r;
  }
  
  public final ArrayList<gm> a() {
    return this.b;
  }
  
  final boolean a(CellLocation paramCellLocation) {
    String str;
    if (paramCellLocation == null)
      return false; 
    Context context = this.l;
    int i = c(paramCellLocation);
    if (i != 1) {
      if (i != 2)
        return true; 
      try {
      
      } finally {
        context = null;
        str = "cgiUseful Cgi.I_CDMA_T";
      } 
    } else {
      try {
        return a(gsmCellLocation.getLac(), gsmCellLocation.getCid());
      } finally {
        context = null;
      } 
      gu.a((Throwable)context, "CgiManager", str);
    } 
    return true;
  }
  
  public final ArrayList<gm> b() {
    return this.n;
  }
  
  public final int c() {
    return this.a;
  }
  
  public final int d() {
    return this.a & 0x3;
  }
  
  public final TelephonyManager e() {
    return this.c;
  }
  
  public final void f() {
    try {
      this.i = gy.a(this.l);
      if (m() || this.b.isEmpty()) {
        p();
        this.d = gy.b();
      } 
      return;
    } catch (SecurityException securityException) {
      return;
    } finally {
      Exception exception = null;
      gu.a(exception, "CgiManager", "refresh");
    } 
  }
  
  public final void g() {
    this.p.a();
    this.s = 0L;
    synchronized (this.u) {
      this.t = true;
      null = this.c;
      if (null != null) {
        PhoneStateListener phoneStateListener = this.g;
        if (phoneStateListener != null)
          try {
            null.listen(phoneStateListener, 0);
          } finally {
            null = null;
          }  
      } 
      this.g = null;
      null = this.k;
      if (null != null) {
        null.quit();
        this.k = null;
      } 
      this.o = -113;
      this.c = null;
      this.q = null;
      return;
    } 
  }
  
  final void h() {
    this.h = null;
    this.e = null;
    this.a = 0;
    this.b.clear();
    this.n.clear();
  }
  
  public final String i() {
    return this.m;
  }
  
  final class a extends HandlerThread {
    public a(gn this$0, String param1String) {
      super(param1String);
    }
    
    protected final void onLooperPrepared() {
      try {
        super.onLooperPrepared();
      } finally {
        Exception exception = null;
      } 
    }
    
    public final void run() {
      try {
        return;
      } finally {
        Exception exception = null;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\gn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */