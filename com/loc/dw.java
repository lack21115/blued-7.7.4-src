package com.loc;

import android.content.Context;
import android.os.Build;
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
import java.util.Iterator;
import java.util.List;

public final class dw {
  private static int r = 0;
  
  private static boolean v = false;
  
  int a = 0;
  
  ArrayList<dv> b = new ArrayList<dv>();
  
  ArrayList<cw> c = new ArrayList<cw>();
  
  TelephonyManager d = null;
  
  long e = 0L;
  
  CellLocation f;
  
  boolean g = false;
  
  PhoneStateListener h = null;
  
  String i = null;
  
  boolean j = false;
  
  StringBuilder k = null;
  
  private Context l;
  
  private String m = null;
  
  private ArrayList<dv> n = new ArrayList<dv>();
  
  private int o = -113;
  
  private du p = null;
  
  private Object q;
  
  private long s = 0L;
  
  private TelephonyManager.CellInfoCallback t;
  
  private boolean u = false;
  
  private do w;
  
  private boolean x = false;
  
  private Object y = new Object();
  
  public dw(Context paramContext) {
    this.l = paramContext;
    if (this.d == null)
      this.d = (TelephonyManager)ep.a(this.l, "phone"); 
    TelephonyManager telephonyManager = this.d;
    if (telephonyManager != null) {
      try {
        this.a = c(telephonyManager.getCellLocation());
      } catch (SecurityException securityException) {
      
      } finally {
        telephonyManager = null;
        this.i = null;
        ej.a((Throwable)telephonyManager, "CgiManager", "CgiManager");
      } 
      try {
        Object object;
        int i = r;
        if (i != 1) {
          Context context;
          if (i != 2) {
            context = this.l;
          } else {
            context = this.l;
          } 
          object = ep.a(context, "phone2");
        } else {
          object = ep.a(this.l, "phone_msim");
        } 
        this.q = object;
      } finally {}
      ab.d().submit(new Runnable(this) {
            public final void run() {
              synchronized (dw.a(this.a)) {
                if (!dw.b(this.a))
                  dw.c(this.a); 
                return;
              } 
            }
          });
    } 
    this.p = new du();
  }
  
  private CellLocation a(Object paramObject, String paramString, Object... paramVarArgs) {
    if (paramObject == null)
      return null; 
    try {
      paramObject = em.a(paramObject, paramString, paramVarArgs);
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
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore #6
    //   5: aload_1
    //   6: ifnull -> 198
    //   9: aload_1
    //   10: invokeinterface isEmpty : ()Z
    //   15: ifeq -> 222
    //   18: goto -> 198
    //   21: aload_3
    //   22: astore #4
    //   24: iload_2
    //   25: aload_1
    //   26: invokeinterface size : ()I
    //   31: if_icmpge -> 81
    //   34: aload_1
    //   35: iload_2
    //   36: invokeinterface get : (I)Ljava/lang/Object;
    //   41: checkcast android/telephony/CellInfo
    //   44: astore #4
    //   46: aload_3
    //   47: astore #5
    //   49: aload #4
    //   51: ifnull -> 71
    //   54: aload_0
    //   55: aload #4
    //   57: invokespecial a : (Landroid/telephony/CellInfo;)Lcom/loc/dv;
    //   60: astore #5
    //   62: aload #5
    //   64: astore #4
    //   66: aload #5
    //   68: ifnonnull -> 81
    //   71: iload_2
    //   72: iconst_1
    //   73: iadd
    //   74: istore_2
    //   75: aload #5
    //   77: astore_3
    //   78: goto -> 21
    //   81: aload #4
    //   83: ifnull -> 177
    //   86: aload #4
    //   88: getfield k : I
    //   91: iconst_2
    //   92: if_icmpne -> 144
    //   95: new android/telephony/cdma/CdmaCellLocation
    //   98: dup
    //   99: invokespecial <init> : ()V
    //   102: astore_1
    //   103: aload_1
    //   104: aload #4
    //   106: getfield i : I
    //   109: aload #4
    //   111: getfield e : I
    //   114: aload #4
    //   116: getfield f : I
    //   119: aload #4
    //   121: getfield g : I
    //   124: aload #4
    //   126: getfield h : I
    //   129: invokevirtual setCellLocationData : (IIIII)V
    //   132: aload #6
    //   134: astore_3
    //   135: goto -> 183
    //   138: aload #6
    //   140: astore_3
    //   141: goto -> 183
    //   144: new android/telephony/gsm/GsmCellLocation
    //   147: dup
    //   148: invokespecial <init> : ()V
    //   151: astore_1
    //   152: aload_1
    //   153: aload #4
    //   155: getfield c : I
    //   158: aload #4
    //   160: getfield d : I
    //   163: invokevirtual setLacAndCid : (II)V
    //   166: goto -> 179
    //   169: aconst_null
    //   170: astore_1
    //   171: aload #6
    //   173: astore_3
    //   174: goto -> 183
    //   177: aconst_null
    //   178: astore_1
    //   179: aload_1
    //   180: astore_3
    //   181: aconst_null
    //   182: astore_1
    //   183: aload_0
    //   184: monitorexit
    //   185: aload_1
    //   186: ifnonnull -> 191
    //   189: aload_3
    //   190: areturn
    //   191: aload_1
    //   192: areturn
    //   193: astore_1
    //   194: aload_0
    //   195: monitorexit
    //   196: aload_1
    //   197: athrow
    //   198: aload_0
    //   199: monitorexit
    //   200: aconst_null
    //   201: areturn
    //   202: astore #4
    //   204: aload_3
    //   205: astore #5
    //   207: goto -> 71
    //   210: astore_1
    //   211: goto -> 169
    //   214: astore_3
    //   215: goto -> 138
    //   218: astore_3
    //   219: goto -> 179
    //   222: iconst_0
    //   223: istore_2
    //   224: aconst_null
    //   225: astore_3
    //   226: goto -> 21
    // Exception table:
    //   from	to	target	type
    //   9	18	193	finally
    //   24	46	193	finally
    //   54	62	202	finally
    //   86	103	210	finally
    //   103	132	214	finally
    //   144	152	210	finally
    //   152	166	218	finally
  }
  
  private static dv a(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
    dv dv = new dv(paramInt1, paramBoolean);
    dv.a = paramInt2;
    dv.b = paramInt3;
    dv.c = paramInt4;
    dv.d = paramInt5;
    dv.j = paramInt6;
    return dv;
  }
  
  private dv a(CellInfo paramCellInfo) {
    dv dv;
    boolean bool = paramCellInfo.isRegistered();
    if (paramCellInfo instanceof CellInfoCdma) {
      dv = a((CellInfoCdma)paramCellInfo, bool);
    } else {
      if (dv instanceof CellInfoGsm) {
        CellInfoGsm cellInfoGsm = (CellInfoGsm)dv;
        if (cellInfoGsm != null) {
          if (cellInfoGsm.getCellIdentity() == null)
            return null; 
          CellIdentityGsm cellIdentityGsm = cellInfoGsm.getCellIdentity();
          if (c(cellIdentityGsm.getLac()) && d(cellIdentityGsm.getCid()))
            return a(1, bool, cellIdentityGsm.getMcc(), cellIdentityGsm.getMnc(), cellIdentityGsm.getLac(), cellIdentityGsm.getCid(), cellInfoGsm.getCellSignalStrength().getDbm()); 
        } 
      } else {
        int i;
        if (dv instanceof CellInfoWcdma) {
          CellInfoWcdma cellInfoWcdma = (CellInfoWcdma)dv;
          if (cellInfoWcdma != null) {
            if (cellInfoWcdma.getCellIdentity() == null)
              return null; 
            CellIdentityWcdma cellIdentityWcdma = cellInfoWcdma.getCellIdentity();
            if (c(cellIdentityWcdma.getLac()) && d(cellIdentityWcdma.getCid())) {
              dv = a(4, bool, cellIdentityWcdma.getMcc(), cellIdentityWcdma.getMnc(), cellIdentityWcdma.getLac(), cellIdentityWcdma.getCid(), cellInfoWcdma.getCellSignalStrength().getDbm());
              i = cellIdentityWcdma.getPsc();
            } else {
              return null;
            } 
          } else {
            return null;
          } 
        } else if (dv instanceof CellInfoLte) {
          CellInfoLte cellInfoLte = (CellInfoLte)dv;
          if (cellInfoLte != null) {
            if (cellInfoLte.getCellIdentity() == null)
              return null; 
            CellIdentityLte cellIdentityLte = cellInfoLte.getCellIdentity();
            if (c(cellIdentityLte.getTac()) && d(cellIdentityLte.getCi())) {
              dv = a(3, bool, cellIdentityLte.getMcc(), cellIdentityLte.getMnc(), cellIdentityLte.getTac(), cellIdentityLte.getCi(), cellInfoLte.getCellSignalStrength().getDbm());
              i = cellIdentityLte.getPci();
            } else {
              return null;
            } 
          } else {
            return null;
          } 
        } else {
          return null;
        } 
        dv.o = i;
        return dv;
      } 
      return null;
    } 
    return dv;
  }
  
  private dv a(CellInfoCdma paramCellInfoCdma, boolean paramBoolean) {
    if (paramCellInfoCdma != null) {
      if (paramCellInfoCdma.getCellIdentity() == null)
        return null; 
      CellIdentityCdma cellIdentityCdma = paramCellInfoCdma.getCellIdentity();
      if (cellIdentityCdma.getSystemId() > 0 && cellIdentityCdma.getNetworkId() >= 0 && cellIdentityCdma.getBasestationId() >= 0) {
        boolean bool1;
        cellIdentityCdma = paramCellInfoCdma.getCellIdentity();
        String[] arrayOfString = ep.a(this.d);
        try {
          int i = Integer.parseInt(arrayOfString[0]);
        } finally {
          arrayOfString = null;
        } 
        boolean bool3 = false;
        boolean bool2 = bool1;
        dv dv = a(2, paramBoolean, bool2, bool3, 0, 0, dv.getCellSignalStrength().getCdmaDbm());
        dv.g = cellIdentityCdma.getSystemId();
        dv.h = cellIdentityCdma.getNetworkId();
        dv.i = cellIdentityCdma.getBasestationId();
        dv.e = cellIdentityCdma.getLatitude();
        dv.f = cellIdentityCdma.getLongitude();
        return dv;
      } 
    } 
    return null;
  }
  
  private static dv a(NeighboringCellInfo paramNeighboringCellInfo, String[] paramArrayOfString) {
    try {
      dv dv = new dv(1, false);
      dv.a = Integer.parseInt(paramArrayOfString[0]);
      dv.b = Integer.parseInt(paramArrayOfString[1]);
      dv.c = em.b(paramNeighboringCellInfo, "getLac", new Object[0]);
      return dv;
    } finally {
      paramNeighboringCellInfo = null;
      ej.a((Throwable)paramNeighboringCellInfo, "CgiManager", "getGsm");
    } 
  }
  
  private void a(CellLocation paramCellLocation, String[] paramArrayOfString, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 268
    //   6: aload_0
    //   7: getfield d : Landroid/telephony/TelephonyManager;
    //   10: ifnonnull -> 16
    //   13: goto -> 268
    //   16: aload_0
    //   17: getfield b : Ljava/util/ArrayList;
    //   20: invokevirtual clear : ()V
    //   23: aload_0
    //   24: aload_1
    //   25: invokespecial b : (Landroid/telephony/CellLocation;)Z
    //   28: istore #4
    //   30: iload #4
    //   32: ifne -> 38
    //   35: aload_0
    //   36: monitorexit
    //   37: return
    //   38: aload_0
    //   39: iconst_1
    //   40: putfield a : I
    //   43: aload_0
    //   44: getfield b : Ljava/util/ArrayList;
    //   47: astore #5
    //   49: aload_1
    //   50: checkcast android/telephony/gsm/GsmCellLocation
    //   53: astore_1
    //   54: new com/loc/dv
    //   57: dup
    //   58: iconst_1
    //   59: iconst_1
    //   60: invokespecial <init> : (IZ)V
    //   63: astore #6
    //   65: aload #6
    //   67: aload_2
    //   68: iconst_0
    //   69: aaload
    //   70: invokestatic g : (Ljava/lang/String;)I
    //   73: putfield a : I
    //   76: aload #6
    //   78: aload_2
    //   79: iconst_1
    //   80: aaload
    //   81: invokestatic g : (Ljava/lang/String;)I
    //   84: putfield b : I
    //   87: aload #6
    //   89: aload_1
    //   90: invokevirtual getLac : ()I
    //   93: putfield c : I
    //   96: aload #6
    //   98: aload_1
    //   99: invokevirtual getCid : ()I
    //   102: putfield d : I
    //   105: aload #6
    //   107: aload_0
    //   108: getfield o : I
    //   111: putfield j : I
    //   114: aload #5
    //   116: aload #6
    //   118: invokevirtual add : (Ljava/lang/Object;)Z
    //   121: pop
    //   122: iload_3
    //   123: ifeq -> 129
    //   126: aload_0
    //   127: monitorexit
    //   128: return
    //   129: getstatic android/os/Build$VERSION.SDK_INT : I
    //   132: bipush #28
    //   134: if_icmpgt -> 260
    //   137: aload_0
    //   138: getfield d : Landroid/telephony/TelephonyManager;
    //   141: ldc_w 'getNeighboringCellInfo'
    //   144: iconst_0
    //   145: anewarray java/lang/Object
    //   148: invokestatic a : (Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    //   151: checkcast java/util/List
    //   154: astore_1
    //   155: aload_1
    //   156: ifnull -> 257
    //   159: aload_1
    //   160: invokeinterface isEmpty : ()Z
    //   165: ifeq -> 171
    //   168: goto -> 257
    //   171: aload_1
    //   172: invokeinterface iterator : ()Ljava/util/Iterator;
    //   177: astore_1
    //   178: aload_1
    //   179: invokeinterface hasNext : ()Z
    //   184: ifeq -> 260
    //   187: aload_1
    //   188: invokeinterface next : ()Ljava/lang/Object;
    //   193: checkcast android/telephony/NeighboringCellInfo
    //   196: astore #5
    //   198: aload #5
    //   200: ifnull -> 178
    //   203: aload #5
    //   205: invokevirtual getLac : ()I
    //   208: aload #5
    //   210: invokevirtual getCid : ()I
    //   213: invokestatic a : (II)Z
    //   216: ifeq -> 178
    //   219: aload #5
    //   221: aload_2
    //   222: invokestatic a : (Landroid/telephony/NeighboringCellInfo;[Ljava/lang/String;)Lcom/loc/dv;
    //   225: astore #5
    //   227: aload #5
    //   229: ifnull -> 178
    //   232: aload_0
    //   233: getfield b : Ljava/util/ArrayList;
    //   236: aload #5
    //   238: invokevirtual contains : (Ljava/lang/Object;)Z
    //   241: ifne -> 178
    //   244: aload_0
    //   245: getfield b : Ljava/util/ArrayList;
    //   248: aload #5
    //   250: invokevirtual add : (Ljava/lang/Object;)Z
    //   253: pop
    //   254: goto -> 178
    //   257: aload_0
    //   258: monitorexit
    //   259: return
    //   260: aload_0
    //   261: monitorexit
    //   262: return
    //   263: astore_1
    //   264: aload_0
    //   265: monitorexit
    //   266: aload_1
    //   267: athrow
    //   268: aload_0
    //   269: monitorexit
    //   270: return
    // Exception table:
    //   from	to	target	type
    //   6	13	263	finally
    //   16	30	263	finally
    //   38	122	263	finally
    //   129	155	263	finally
    //   159	168	263	finally
    //   171	178	263	finally
    //   178	198	263	finally
    //   203	227	263	finally
    //   232	254	263	finally
  }
  
  private void a(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield d : Landroid/telephony/TelephonyManager;
    //   6: invokestatic a : (Landroid/telephony/TelephonyManager;)[Ljava/lang/String;
    //   9: astore #4
    //   11: aload_0
    //   12: aload_0
    //   13: getfield f : Landroid/telephony/CellLocation;
    //   16: invokespecial c : (Landroid/telephony/CellLocation;)I
    //   19: istore_2
    //   20: iconst_1
    //   21: istore_3
    //   22: iload_2
    //   23: iconst_1
    //   24: if_icmpeq -> 408
    //   27: iload_2
    //   28: iconst_2
    //   29: if_icmpeq -> 35
    //   32: goto -> 405
    //   35: aload_0
    //   36: getfield f : Landroid/telephony/CellLocation;
    //   39: astore #5
    //   41: aload #5
    //   43: ifnull -> 405
    //   46: aload_0
    //   47: getfield b : Ljava/util/ArrayList;
    //   50: invokevirtual clear : ()V
    //   53: aload_0
    //   54: getfield q : Ljava/lang/Object;
    //   57: astore #6
    //   59: aload #6
    //   61: ifnull -> 140
    //   64: aload #5
    //   66: invokevirtual getClass : ()Ljava/lang/Class;
    //   69: ldc_w 'mGsmCellLoc'
    //   72: invokevirtual getDeclaredField : (Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   75: astore #6
    //   77: aload #6
    //   79: invokevirtual isAccessible : ()Z
    //   82: ifne -> 91
    //   85: aload #6
    //   87: iconst_1
    //   88: invokevirtual setAccessible : (Z)V
    //   91: aload #6
    //   93: aload #5
    //   95: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   98: checkcast android/telephony/gsm/GsmCellLocation
    //   101: astore #6
    //   103: aload #6
    //   105: ifnull -> 131
    //   108: aload_0
    //   109: aload #6
    //   111: invokespecial b : (Landroid/telephony/CellLocation;)Z
    //   114: ifeq -> 131
    //   117: aload_0
    //   118: aload #6
    //   120: aload #4
    //   122: iload_1
    //   123: invokespecial a : (Landroid/telephony/CellLocation;[Ljava/lang/String;Z)V
    //   126: iconst_1
    //   127: istore_2
    //   128: goto -> 133
    //   131: iconst_0
    //   132: istore_2
    //   133: iload_2
    //   134: ifeq -> 140
    //   137: aload_0
    //   138: monitorexit
    //   139: return
    //   140: aload_0
    //   141: aload #5
    //   143: invokespecial b : (Landroid/telephony/CellLocation;)Z
    //   146: istore_1
    //   147: iload_1
    //   148: ifne -> 154
    //   151: aload_0
    //   152: monitorexit
    //   153: return
    //   154: aload_0
    //   155: iconst_2
    //   156: putfield a : I
    //   159: new com/loc/dv
    //   162: dup
    //   163: iconst_2
    //   164: iconst_1
    //   165: invokespecial <init> : (IZ)V
    //   168: astore #6
    //   170: aload #6
    //   172: aload #4
    //   174: iconst_0
    //   175: aaload
    //   176: invokestatic parseInt : (Ljava/lang/String;)I
    //   179: putfield a : I
    //   182: aload #6
    //   184: aload #4
    //   186: iconst_1
    //   187: aaload
    //   188: invokestatic parseInt : (Ljava/lang/String;)I
    //   191: putfield b : I
    //   194: aload #6
    //   196: aload #5
    //   198: ldc_w 'getSystemId'
    //   201: iconst_0
    //   202: anewarray java/lang/Object
    //   205: invokestatic b : (Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)I
    //   208: putfield g : I
    //   211: aload #6
    //   213: aload #5
    //   215: ldc_w 'getNetworkId'
    //   218: iconst_0
    //   219: anewarray java/lang/Object
    //   222: invokestatic b : (Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)I
    //   225: putfield h : I
    //   228: aload #6
    //   230: aload #5
    //   232: ldc_w 'getBaseStationId'
    //   235: iconst_0
    //   236: anewarray java/lang/Object
    //   239: invokestatic b : (Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)I
    //   242: putfield i : I
    //   245: aload #6
    //   247: aload_0
    //   248: getfield o : I
    //   251: putfield j : I
    //   254: aload #6
    //   256: aload #5
    //   258: ldc_w 'getBaseStationLatitude'
    //   261: iconst_0
    //   262: anewarray java/lang/Object
    //   265: invokestatic b : (Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)I
    //   268: putfield e : I
    //   271: aload #6
    //   273: aload #5
    //   275: ldc_w 'getBaseStationLongitude'
    //   278: iconst_0
    //   279: anewarray java/lang/Object
    //   282: invokestatic b : (Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)I
    //   285: putfield f : I
    //   288: aload #6
    //   290: getfield e : I
    //   293: aload #6
    //   295: getfield f : I
    //   298: if_icmpne -> 434
    //   301: aload #6
    //   303: getfield e : I
    //   306: ifle -> 434
    //   309: iload_3
    //   310: istore_2
    //   311: goto -> 314
    //   314: aload #6
    //   316: getfield e : I
    //   319: iflt -> 356
    //   322: aload #6
    //   324: getfield f : I
    //   327: iflt -> 356
    //   330: aload #6
    //   332: getfield e : I
    //   335: ldc_w 2147483647
    //   338: if_icmpeq -> 356
    //   341: aload #6
    //   343: getfield f : I
    //   346: ldc_w 2147483647
    //   349: if_icmpeq -> 356
    //   352: iload_2
    //   353: ifeq -> 368
    //   356: aload #6
    //   358: iconst_0
    //   359: putfield e : I
    //   362: aload #6
    //   364: iconst_0
    //   365: putfield f : I
    //   368: aload_0
    //   369: getfield b : Ljava/util/ArrayList;
    //   372: aload #6
    //   374: invokevirtual contains : (Ljava/lang/Object;)Z
    //   377: ifne -> 390
    //   380: aload_0
    //   381: getfield b : Ljava/util/ArrayList;
    //   384: aload #6
    //   386: invokevirtual add : (Ljava/lang/Object;)Z
    //   389: pop
    //   390: aload_0
    //   391: monitorexit
    //   392: return
    //   393: astore #4
    //   395: aload #4
    //   397: ldc 'CgiManager'
    //   399: ldc_w 'hdlCdmaLocChange'
    //   402: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   405: aload_0
    //   406: monitorexit
    //   407: return
    //   408: aload_0
    //   409: aload_0
    //   410: getfield f : Landroid/telephony/CellLocation;
    //   413: aload #4
    //   415: iload_1
    //   416: invokespecial a : (Landroid/telephony/CellLocation;[Ljava/lang/String;Z)V
    //   419: aload_0
    //   420: monitorexit
    //   421: return
    //   422: astore #4
    //   424: aload_0
    //   425: monitorexit
    //   426: aload #4
    //   428: athrow
    //   429: astore #6
    //   431: goto -> 131
    //   434: iconst_0
    //   435: istore_2
    //   436: goto -> 314
    // Exception table:
    //   from	to	target	type
    //   2	20	422	finally
    //   35	41	422	finally
    //   46	53	422	finally
    //   53	59	393	finally
    //   64	91	429	finally
    //   91	103	429	finally
    //   108	126	429	finally
    //   140	147	393	finally
    //   154	309	393	finally
    //   314	352	393	finally
    //   356	368	393	finally
    //   368	390	393	finally
    //   395	405	422	finally
    //   408	419	422	finally
  }
  
  public static boolean a(int paramInt) {
    return !(paramInt <= 0 || paramInt > 15);
  }
  
  private static boolean a(int paramInt1, int paramInt2) {
    return !(paramInt1 == -1 || paramInt1 == 0 || paramInt1 > 65535 || paramInt2 == -1 || paramInt2 == 0 || paramInt2 == 65535 || paramInt2 >= 268435455);
  }
  
  private void b(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: bipush #-113
    //   5: if_icmpne -> 17
    //   8: aload_0
    //   9: bipush #-113
    //   11: putfield o : I
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: iload_1
    //   19: putfield o : I
    //   22: aload_0
    //   23: getfield a : I
    //   26: istore_1
    //   27: iload_1
    //   28: iconst_1
    //   29: if_icmpeq -> 40
    //   32: iload_1
    //   33: iconst_2
    //   34: if_icmpeq -> 40
    //   37: goto -> 80
    //   40: aload_0
    //   41: getfield b : Ljava/util/ArrayList;
    //   44: ifnull -> 80
    //   47: aload_0
    //   48: getfield b : Ljava/util/ArrayList;
    //   51: invokevirtual isEmpty : ()Z
    //   54: istore_2
    //   55: iload_2
    //   56: ifne -> 80
    //   59: aload_0
    //   60: getfield b : Ljava/util/ArrayList;
    //   63: iconst_0
    //   64: invokevirtual get : (I)Ljava/lang/Object;
    //   67: checkcast com/loc/dv
    //   70: aload_0
    //   71: getfield o : I
    //   74: putfield j : I
    //   77: aload_0
    //   78: monitorexit
    //   79: return
    //   80: aload_0
    //   81: monitorexit
    //   82: return
    //   83: astore_3
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_3
    //   87: athrow
    //   88: astore_3
    //   89: goto -> 80
    // Exception table:
    //   from	to	target	type
    //   8	14	83	finally
    //   17	27	83	finally
    //   40	55	83	finally
    //   59	77	88	finally
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield j : Z
    //   6: istore #6
    //   8: aconst_null
    //   9: astore #8
    //   11: iconst_0
    //   12: istore #4
    //   14: iload #6
    //   16: ifne -> 207
    //   19: aload_0
    //   20: getfield d : Landroid/telephony/TelephonyManager;
    //   23: ifnull -> 207
    //   26: getstatic android/os/Build$VERSION.SDK_INT : I
    //   29: bipush #29
    //   31: if_icmplt -> 123
    //   34: aload_0
    //   35: getfield l : Landroid/content/Context;
    //   38: invokevirtual getApplicationInfo : ()Landroid/content/pm/ApplicationInfo;
    //   41: getfield targetSdkVersion : I
    //   44: bipush #29
    //   46: if_icmplt -> 123
    //   49: aload_0
    //   50: getfield t : Landroid/telephony/TelephonyManager$CellInfoCallback;
    //   53: ifnonnull -> 68
    //   56: aload_0
    //   57: new com/loc/dw$a
    //   60: dup
    //   61: aload_0
    //   62: invokespecial <init> : (Lcom/loc/dw;)V
    //   65: putfield t : Landroid/telephony/TelephonyManager$CellInfoCallback;
    //   68: aload_0
    //   69: getfield d : Landroid/telephony/TelephonyManager;
    //   72: invokestatic d : ()Ljava/util/concurrent/ExecutorService;
    //   75: aload_0
    //   76: getfield t : Landroid/telephony/TelephonyManager$CellInfoCallback;
    //   79: invokevirtual requestCellInfoUpdate : (Ljava/util/concurrent/Executor;Landroid/telephony/TelephonyManager$CellInfoCallback;)V
    //   82: iload_2
    //   83: ifne -> 562
    //   86: iload_1
    //   87: ifeq -> 123
    //   90: goto -> 562
    //   93: aload_0
    //   94: getfield u : Z
    //   97: istore #6
    //   99: iload #6
    //   101: ifne -> 123
    //   104: iload_3
    //   105: bipush #20
    //   107: if_icmpge -> 123
    //   110: ldc2_w 5
    //   113: invokestatic sleep : (J)V
    //   116: iload_3
    //   117: iconst_1
    //   118: iadd
    //   119: istore_3
    //   120: goto -> 93
    //   123: aload_0
    //   124: invokespecial q : ()Landroid/telephony/CellLocation;
    //   127: astore #9
    //   129: aload #9
    //   131: astore #7
    //   133: aload_0
    //   134: aload #9
    //   136: invokespecial b : (Landroid/telephony/CellLocation;)Z
    //   139: ifne -> 148
    //   142: aload_0
    //   143: invokespecial r : ()Landroid/telephony/CellLocation;
    //   146: astore #7
    //   148: aload_0
    //   149: aload #7
    //   151: invokespecial b : (Landroid/telephony/CellLocation;)Z
    //   154: ifeq -> 173
    //   157: aload_0
    //   158: aload #7
    //   160: putfield f : Landroid/telephony/CellLocation;
    //   163: aload_0
    //   164: invokestatic b : ()J
    //   167: putfield s : J
    //   170: goto -> 207
    //   173: invokestatic b : ()J
    //   176: aload_0
    //   177: getfield s : J
    //   180: lsub
    //   181: ldc2_w 60000
    //   184: lcmp
    //   185: ifle -> 207
    //   188: aload_0
    //   189: aconst_null
    //   190: putfield f : Landroid/telephony/CellLocation;
    //   193: aload_0
    //   194: getfield b : Ljava/util/ArrayList;
    //   197: invokevirtual clear : ()V
    //   200: aload_0
    //   201: getfield n : Ljava/util/ArrayList;
    //   204: invokevirtual clear : ()V
    //   207: aload_0
    //   208: getfield g : Z
    //   211: ifne -> 269
    //   214: aload_0
    //   215: getfield f : Landroid/telephony/CellLocation;
    //   218: astore #7
    //   220: aload #7
    //   222: ifnonnull -> 269
    //   225: iload_2
    //   226: ifeq -> 269
    //   229: iconst_0
    //   230: istore_3
    //   231: ldc2_w 10
    //   234: invokestatic sleep : (J)V
    //   237: goto -> 247
    //   240: astore #7
    //   242: aload #7
    //   244: invokevirtual printStackTrace : ()V
    //   247: iload_3
    //   248: iconst_1
    //   249: iadd
    //   250: istore #5
    //   252: aload_0
    //   253: getfield f : Landroid/telephony/CellLocation;
    //   256: ifnonnull -> 269
    //   259: iload #5
    //   261: istore_3
    //   262: iload #5
    //   264: bipush #50
    //   266: if_icmplt -> 231
    //   269: aload_0
    //   270: iconst_1
    //   271: putfield g : Z
    //   274: aload_0
    //   275: aload_0
    //   276: getfield f : Landroid/telephony/CellLocation;
    //   279: invokespecial b : (Landroid/telephony/CellLocation;)Z
    //   282: ifeq -> 290
    //   285: aload_0
    //   286: iload_1
    //   287: invokespecial a : (Z)V
    //   290: invokestatic c : ()I
    //   293: bipush #18
    //   295: if_icmplt -> 498
    //   298: aload_0
    //   299: getfield d : Landroid/telephony/TelephonyManager;
    //   302: ifnull -> 498
    //   305: aload_0
    //   306: getfield n : Ljava/util/ArrayList;
    //   309: astore #10
    //   311: aload_0
    //   312: getfield p : Lcom/loc/du;
    //   315: astore #11
    //   317: aload_0
    //   318: getfield d : Landroid/telephony/TelephonyManager;
    //   321: invokevirtual getAllCellInfo : ()Ljava/util/List;
    //   324: astore #7
    //   326: aload_0
    //   327: aconst_null
    //   328: putfield i : Ljava/lang/String;
    //   331: goto -> 358
    //   334: astore #8
    //   336: goto -> 349
    //   339: astore #9
    //   341: aload #8
    //   343: astore #7
    //   345: aload #9
    //   347: astore #8
    //   349: aload_0
    //   350: aload #8
    //   352: invokevirtual getMessage : ()Ljava/lang/String;
    //   355: putfield i : Ljava/lang/String;
    //   358: aload #7
    //   360: ifnull -> 468
    //   363: aload #7
    //   365: invokeinterface size : ()I
    //   370: istore #5
    //   372: iload #5
    //   374: ifeq -> 468
    //   377: iload #4
    //   379: istore_3
    //   380: aload #10
    //   382: ifnull -> 393
    //   385: aload #10
    //   387: invokevirtual clear : ()V
    //   390: iload #4
    //   392: istore_3
    //   393: iload_3
    //   394: iload #5
    //   396: if_icmpge -> 468
    //   399: aload #7
    //   401: iload_3
    //   402: invokeinterface get : (I)Ljava/lang/Object;
    //   407: checkcast android/telephony/CellInfo
    //   410: astore #8
    //   412: aload #8
    //   414: ifnull -> 461
    //   417: aload_0
    //   418: aload #8
    //   420: invokespecial a : (Landroid/telephony/CellInfo;)Lcom/loc/dv;
    //   423: astore #8
    //   425: aload #8
    //   427: ifnonnull -> 433
    //   430: goto -> 461
    //   433: aload #8
    //   435: ldc2_w 65535
    //   438: aload #11
    //   440: aload #8
    //   442: invokevirtual a : (Lcom/loc/dv;)J
    //   445: invokestatic min : (JJ)J
    //   448: l2i
    //   449: i2s
    //   450: putfield l : S
    //   453: aload #10
    //   455: aload #8
    //   457: invokevirtual add : (Ljava/lang/Object;)Z
    //   460: pop
    //   461: iload_3
    //   462: iconst_1
    //   463: iadd
    //   464: istore_3
    //   465: goto -> 393
    //   468: aload #10
    //   470: ifnull -> 498
    //   473: aload #10
    //   475: invokevirtual size : ()I
    //   478: ifle -> 498
    //   481: aload_0
    //   482: aload_0
    //   483: getfield a : I
    //   486: iconst_4
    //   487: ior
    //   488: putfield a : I
    //   491: aload #11
    //   493: aload #10
    //   495: invokevirtual a : (Ljava/util/ArrayList;)V
    //   498: aload_0
    //   499: getfield d : Landroid/telephony/TelephonyManager;
    //   502: ifnull -> 537
    //   505: aload_0
    //   506: aload_0
    //   507: getfield d : Landroid/telephony/TelephonyManager;
    //   510: invokevirtual getNetworkOperator : ()Ljava/lang/String;
    //   513: putfield m : Ljava/lang/String;
    //   516: aload_0
    //   517: getfield m : Ljava/lang/String;
    //   520: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   523: ifne -> 537
    //   526: aload_0
    //   527: aload_0
    //   528: getfield a : I
    //   531: bipush #8
    //   533: ior
    //   534: putfield a : I
    //   537: aload_0
    //   538: monitorexit
    //   539: return
    //   540: astore #7
    //   542: aload_0
    //   543: monitorexit
    //   544: aload #7
    //   546: athrow
    //   547: astore #7
    //   549: goto -> 116
    //   552: astore #7
    //   554: goto -> 498
    //   557: astore #8
    //   559: goto -> 461
    //   562: iconst_0
    //   563: istore_3
    //   564: goto -> 93
    // Exception table:
    //   from	to	target	type
    //   2	8	540	finally
    //   19	68	540	finally
    //   68	82	540	finally
    //   93	99	540	finally
    //   110	116	547	finally
    //   123	129	540	finally
    //   133	148	540	finally
    //   148	170	540	finally
    //   173	207	540	finally
    //   207	220	540	finally
    //   231	237	240	java/lang/InterruptedException
    //   231	237	540	finally
    //   242	247	540	finally
    //   252	259	540	finally
    //   269	290	540	finally
    //   290	317	552	finally
    //   317	326	339	java/lang/SecurityException
    //   317	326	552	finally
    //   326	331	334	java/lang/SecurityException
    //   326	331	552	finally
    //   349	358	552	finally
    //   363	372	552	finally
    //   385	390	552	finally
    //   399	412	552	finally
    //   417	425	557	finally
    //   433	461	557	finally
    //   473	498	552	finally
    //   498	537	540	finally
  }
  
  private boolean b(CellLocation paramCellLocation) {
    boolean bool = a(paramCellLocation);
    if (!bool)
      this.a = 0; 
    return bool;
  }
  
  private int c(CellLocation paramCellLocation) {
    if (this.j)
      return 0; 
    if (paramCellLocation == null)
      return 0; 
    if (paramCellLocation instanceof GsmCellLocation)
      return 1; 
    try {
      return 2;
    } finally {
      paramCellLocation = null;
      ej.a((Throwable)paramCellLocation, "Utils", "getCellLocT");
    } 
  }
  
  private static boolean c(int paramInt) {
    return !(paramInt == -1 || paramInt == 0 || paramInt > 65535);
  }
  
  private static boolean d(int paramInt) {
    return !(paramInt == -1 || paramInt == 0 || paramInt == 65535 || paramInt >= 268435455);
  }
  
  public static int j() {
    try {
      Class.forName("android.telephony.MSimTelephonyManager");
      r = 1;
    } finally {
      Exception exception;
    } 
    if (r == 0)
      try {
        Class.forName("android.telephony.TelephonyManager2");
        r = 2;
      } finally {
        Exception exception;
      }  
    return r;
  }
  
  private CellLocation o() {
    TelephonyManager telephonyManager = this.d;
    if (telephonyManager != null)
      try {
        CellLocation cellLocation = telephonyManager.getCellLocation();
        this.i = null;
        if (b(cellLocation))
          return cellLocation; 
      } catch (SecurityException securityException) {
      
      } finally {
        telephonyManager = null;
        this.i = null;
        ej.a((Throwable)telephonyManager, "CgiManager", "getCellLocation");
      }  
    return null;
  }
  
  private void p() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : I
    //   6: iconst_3
    //   7: iand
    //   8: istore_1
    //   9: iload_1
    //   10: iconst_1
    //   11: if_icmpeq -> 40
    //   14: iload_1
    //   15: iconst_2
    //   16: if_icmpeq -> 22
    //   19: goto -> 58
    //   22: aload_0
    //   23: getfield b : Ljava/util/ArrayList;
    //   26: invokevirtual isEmpty : ()Z
    //   29: ifeq -> 58
    //   32: aload_0
    //   33: iconst_0
    //   34: putfield a : I
    //   37: goto -> 58
    //   40: aload_0
    //   41: getfield b : Ljava/util/ArrayList;
    //   44: invokevirtual isEmpty : ()Z
    //   47: ifeq -> 58
    //   50: aload_0
    //   51: iconst_0
    //   52: putfield a : I
    //   55: aload_0
    //   56: monitorexit
    //   57: return
    //   58: aload_0
    //   59: monitorexit
    //   60: return
    //   61: astore_2
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_2
    //   65: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	61	finally
    //   22	37	61	finally
    //   40	55	61	finally
  }
  
  private CellLocation q() {
    TelephonyManager telephonyManager = this.d;
    CellLocation cellLocation2 = null;
    if (telephonyManager == null)
      return null; 
    CellLocation cellLocation1 = cellLocation2;
    if (ep.c() >= 18)
      try {
        cellLocation1 = a(telephonyManager.getAllCellInfo());
      } catch (SecurityException securityException) {
        this.i = securityException.getMessage();
        cellLocation1 = cellLocation2;
      }  
    if (cellLocation1 != null)
      return cellLocation1; 
    cellLocation1 = o();
    if (b(cellLocation1))
      return cellLocation1; 
    cellLocation1 = a(telephonyManager, "getCellLocationExt", new Object[] { Integer.valueOf(1) });
    return (cellLocation1 != null) ? cellLocation1 : a(telephonyManager, "getCellLocationGemini", new Object[] { Integer.valueOf(1) });
  }
  
  private CellLocation r() {
    boolean bool = v;
    Integer integer = Integer.valueOf(1);
    if (!bool)
      v = true; 
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
      ej.a((Throwable)cellLocation2, "CgiManager", "getSim2Cgi");
    } 
    return cellLocation2;
  }
  
  private static Class<?> s() {
    String str;
    ClassLoader classLoader = ClassLoader.getSystemClassLoader();
    int i = r;
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
      ej.a((Throwable)str, "CgiManager", "getSim2TmClass");
    } 
  }
  
  public final List<cw> a() {
    ArrayList<da> arrayList = new ArrayList();
    List list = this.d.getAllCellInfo();
    if (Build.VERSION.SDK_INT >= 17 && list != null) {
      Iterator<CellInfo> iterator = list.iterator();
      while (true) {
        da da;
        if (iterator.hasNext()) {
          cx cx;
          CellInfo cellInfo = iterator.next();
          if (cellInfo instanceof CellInfoCdma) {
            CellInfoCdma cellInfoCdma = (CellInfoCdma)cellInfo;
            CellIdentityCdma cellIdentityCdma = cellInfoCdma.getCellIdentity();
            cx = new cx(cellInfo.isRegistered(), true);
            cx.m = cellIdentityCdma.getLatitude();
            cx.n = cellIdentityCdma.getLongitude();
            cx.j = cellIdentityCdma.getSystemId();
            cx.k = cellIdentityCdma.getNetworkId();
            cx.l = cellIdentityCdma.getBasestationId();
            cx.d = cellInfoCdma.getCellSignalStrength().getAsuLevel();
            cx.c = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
          } else {
            cy cy;
            if (cx instanceof CellInfoGsm) {
              CellInfoGsm cellInfoGsm = (CellInfoGsm)cx;
              CellIdentityGsm cellIdentityGsm = cellInfoGsm.getCellIdentity();
              cy cy1 = new cy(cx.isRegistered(), true);
              cy1.a = String.valueOf(cellIdentityGsm.getMcc());
              cy1.b = String.valueOf(cellIdentityGsm.getMnc());
              cy1.j = cellIdentityGsm.getLac();
              cy1.k = cellIdentityGsm.getCid();
              cy1.c = cellInfoGsm.getCellSignalStrength().getDbm();
              cy1.d = cellInfoGsm.getCellSignalStrength().getAsuLevel();
              cy = cy1;
              if (Build.VERSION.SDK_INT >= 24) {
                cy1.m = cellIdentityGsm.getArfcn();
                cy1.n = cellIdentityGsm.getBsic();
                cy = cy1;
              } 
            } else {
              cz cz;
              if (cy instanceof CellInfoLte) {
                CellInfoLte cellInfoLte = (CellInfoLte)cy;
                CellIdentityLte cellIdentityLte = cellInfoLte.getCellIdentity();
                cz cz1 = new cz(cy.isRegistered());
                cz1.a = String.valueOf(cellIdentityLte.getMcc());
                cz1.b = String.valueOf(cellIdentityLte.getMnc());
                cz1.l = cellIdentityLte.getPci();
                cz1.d = cellInfoLte.getCellSignalStrength().getAsuLevel();
                cz1.k = cellIdentityLte.getCi();
                cz1.j = cellIdentityLte.getTac();
                cz1.n = cellInfoLte.getCellSignalStrength().getTimingAdvance();
                cz1.c = cellInfoLte.getCellSignalStrength().getDbm();
                cz = cz1;
                if (Build.VERSION.SDK_INT >= 24) {
                  cz1.m = cellIdentityLte.getEarfcn();
                  cz = cz1;
                } 
              } else {
                if (Build.VERSION.SDK_INT >= 18 && cz instanceof CellInfoWcdma) {
                  CellInfoWcdma cellInfoWcdma = (CellInfoWcdma)cz;
                  CellIdentityWcdma cellIdentityWcdma = cellInfoWcdma.getCellIdentity();
                  da da1 = new da(cz.isRegistered(), true);
                  da1.a = String.valueOf(cellIdentityWcdma.getMcc());
                  da1.b = String.valueOf(cellIdentityWcdma.getMnc());
                  da1.j = cellIdentityWcdma.getLac();
                  da1.k = cellIdentityWcdma.getCid();
                  da1.l = cellIdentityWcdma.getPsc();
                  da1.d = cellInfoWcdma.getCellSignalStrength().getAsuLevel();
                  da1.c = cellInfoWcdma.getCellSignalStrength().getDbm();
                  da = da1;
                  if (Build.VERSION.SDK_INT >= 24) {
                    da1.m = cellIdentityWcdma.getUarfcn();
                    da = da1;
                  } 
                } else {
                  continue;
                } 
                arrayList.add(da);
              } 
              arrayList.add(da);
            } 
            arrayList.add(da);
          } 
        } else {
          break;
        } 
        arrayList.add(da);
      } 
    } 
    return (List)arrayList;
  }
  
  public final void a(do paramdo) {
    this.w = paramdo;
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield l : Landroid/content/Context;
    //   7: invokestatic a : (Landroid/content/Context;)Z
    //   10: putfield j : Z
    //   13: aload_0
    //   14: getfield j : Z
    //   17: istore #4
    //   19: iconst_0
    //   20: istore_3
    //   21: iload #4
    //   23: ifeq -> 29
    //   26: goto -> 47
    //   29: invokestatic b : ()J
    //   32: aload_0
    //   33: getfield e : J
    //   36: lsub
    //   37: ldc2_w 10000
    //   40: lcmp
    //   41: ifge -> 131
    //   44: goto -> 47
    //   47: iload_3
    //   48: ifne -> 61
    //   51: aload_0
    //   52: getfield b : Ljava/util/ArrayList;
    //   55: invokevirtual isEmpty : ()Z
    //   58: ifeq -> 74
    //   61: aload_0
    //   62: iload_1
    //   63: iload_2
    //   64: invokespecial b : (ZZ)V
    //   67: aload_0
    //   68: invokestatic b : ()J
    //   71: putfield e : J
    //   74: aload_0
    //   75: getfield j : Z
    //   78: ifeq -> 88
    //   81: aload_0
    //   82: invokevirtual i : ()V
    //   85: aload_0
    //   86: monitorexit
    //   87: return
    //   88: aload_0
    //   89: invokespecial p : ()V
    //   92: aload_0
    //   93: monitorexit
    //   94: return
    //   95: astore #5
    //   97: aload #5
    //   99: ldc 'CgiManager'
    //   101: ldc_w 'refresh'
    //   104: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   107: aload_0
    //   108: monitorexit
    //   109: return
    //   110: astore #5
    //   112: aload_0
    //   113: aload #5
    //   115: invokevirtual getMessage : ()Ljava/lang/String;
    //   118: putfield i : Ljava/lang/String;
    //   121: aload_0
    //   122: monitorexit
    //   123: return
    //   124: astore #5
    //   126: aload_0
    //   127: monitorexit
    //   128: aload #5
    //   130: athrow
    //   131: iconst_1
    //   132: istore_3
    //   133: goto -> 47
    // Exception table:
    //   from	to	target	type
    //   2	19	110	java/lang/SecurityException
    //   2	19	95	finally
    //   29	44	110	java/lang/SecurityException
    //   29	44	95	finally
    //   51	61	110	java/lang/SecurityException
    //   51	61	95	finally
    //   61	74	110	java/lang/SecurityException
    //   61	74	95	finally
    //   74	85	110	java/lang/SecurityException
    //   74	85	95	finally
    //   88	92	110	java/lang/SecurityException
    //   88	92	95	finally
    //   97	107	124	finally
    //   112	121	124	finally
  }
  
  final boolean a(CellLocation paramCellLocation) {
    String str;
    if (paramCellLocation == null)
      return false; 
    int i = c(paramCellLocation);
    if (i != 1) {
      if (i != 2)
        return true; 
      try {
      
      } finally {
        Exception exception = null;
        str = "cgiUseful Cgi.I_CDMA_T";
      } 
    } else {
      Exception exception;
      try {
        return a(gsmCellLocation.getLac(), gsmCellLocation.getCid());
      } finally {
        exception = null;
      } 
      ej.a(exception, "CgiManager", str);
    } 
    return true;
  }
  
  public final ArrayList<dv> b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Ljava/util/ArrayList;
    //   6: astore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: aload_1
    //   10: areturn
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public final ArrayList<dv> c() {
    return this.n;
  }
  
  public final dv d() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield j : Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq -> 15
    //   11: aload_0
    //   12: monitorexit
    //   13: aconst_null
    //   14: areturn
    //   15: aload_0
    //   16: getfield b : Ljava/util/ArrayList;
    //   19: astore_2
    //   20: aload_2
    //   21: invokevirtual size : ()I
    //   24: ifle -> 40
    //   27: aload_2
    //   28: iconst_0
    //   29: invokevirtual get : (I)Ljava/lang/Object;
    //   32: checkcast com/loc/dv
    //   35: astore_2
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_2
    //   39: areturn
    //   40: aload_0
    //   41: monitorexit
    //   42: aconst_null
    //   43: areturn
    //   44: astore_2
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_2
    //   48: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	44	finally
    //   15	36	44	finally
  }
  
  public final int e() {
    return this.a;
  }
  
  public final int f() {
    return this.a & 0x3;
  }
  
  public final TelephonyManager g() {
    return this.d;
  }
  
  public final void h() {
    this.p.a();
    this.s = 0L;
    synchronized (this.y) {
      this.x = true;
      null = this.d;
      if (null != null) {
        PhoneStateListener phoneStateListener = this.h;
        if (phoneStateListener != null)
          try {
            null.listen(phoneStateListener, 0);
          } finally {
            null = null;
          }  
      } 
      this.h = null;
      this.o = -113;
      this.d = null;
      this.q = null;
      return;
    } 
  }
  
  final void i() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aconst_null
    //   4: putfield i : Ljava/lang/String;
    //   7: aload_0
    //   8: aconst_null
    //   9: putfield f : Landroid/telephony/CellLocation;
    //   12: aload_0
    //   13: iconst_0
    //   14: putfield a : I
    //   17: aload_0
    //   18: getfield b : Ljava/util/ArrayList;
    //   21: invokevirtual clear : ()V
    //   24: aload_0
    //   25: getfield n : Ljava/util/ArrayList;
    //   28: invokevirtual clear : ()V
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    // Exception table:
    //   from	to	target	type
    //   2	31	34	finally
  }
  
  public final String k() {
    return this.i;
  }
  
  public final String l() {
    return this.m;
  }
  
  public final String m() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield j : Z
    //   6: ifeq -> 13
    //   9: aload_0
    //   10: invokevirtual i : ()V
    //   13: aload_0
    //   14: getfield k : Ljava/lang/StringBuilder;
    //   17: ifnonnull -> 34
    //   20: aload_0
    //   21: new java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial <init> : ()V
    //   28: putfield k : Ljava/lang/StringBuilder;
    //   31: goto -> 50
    //   34: aload_0
    //   35: getfield k : Ljava/lang/StringBuilder;
    //   38: iconst_0
    //   39: aload_0
    //   40: getfield k : Ljava/lang/StringBuilder;
    //   43: invokevirtual length : ()I
    //   46: invokevirtual delete : (II)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload_0
    //   51: getfield a : I
    //   54: istore_2
    //   55: iconst_1
    //   56: istore_1
    //   57: iload_2
    //   58: iconst_3
    //   59: iand
    //   60: iconst_1
    //   61: if_icmpeq -> 67
    //   64: goto -> 181
    //   67: iload_1
    //   68: aload_0
    //   69: getfield b : Ljava/util/ArrayList;
    //   72: invokevirtual size : ()I
    //   75: if_icmpge -> 181
    //   78: aload_0
    //   79: getfield k : Ljava/lang/StringBuilder;
    //   82: astore_3
    //   83: aload_3
    //   84: ldc_w '#'
    //   87: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload_3
    //   92: aload_0
    //   93: getfield b : Ljava/util/ArrayList;
    //   96: iload_1
    //   97: invokevirtual get : (I)Ljava/lang/Object;
    //   100: checkcast com/loc/dv
    //   103: getfield b : I
    //   106: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload_0
    //   111: getfield k : Ljava/lang/StringBuilder;
    //   114: astore_3
    //   115: aload_3
    //   116: ldc_w '|'
    //   119: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload_3
    //   124: aload_0
    //   125: getfield b : Ljava/util/ArrayList;
    //   128: iload_1
    //   129: invokevirtual get : (I)Ljava/lang/Object;
    //   132: checkcast com/loc/dv
    //   135: getfield c : I
    //   138: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload_0
    //   143: getfield k : Ljava/lang/StringBuilder;
    //   146: astore_3
    //   147: aload_3
    //   148: ldc_w '|'
    //   151: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: aload_3
    //   156: aload_0
    //   157: getfield b : Ljava/util/ArrayList;
    //   160: iload_1
    //   161: invokevirtual get : (I)Ljava/lang/Object;
    //   164: checkcast com/loc/dv
    //   167: getfield d : I
    //   170: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: iload_1
    //   175: iconst_1
    //   176: iadd
    //   177: istore_1
    //   178: goto -> 67
    //   181: aload_0
    //   182: getfield k : Ljava/lang/StringBuilder;
    //   185: invokevirtual length : ()I
    //   188: ifle -> 200
    //   191: aload_0
    //   192: getfield k : Ljava/lang/StringBuilder;
    //   195: iconst_0
    //   196: invokevirtual deleteCharAt : (I)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload_0
    //   201: getfield k : Ljava/lang/StringBuilder;
    //   204: invokevirtual toString : ()Ljava/lang/String;
    //   207: astore_3
    //   208: aload_0
    //   209: monitorexit
    //   210: aload_3
    //   211: areturn
    //   212: astore_3
    //   213: aload_0
    //   214: monitorexit
    //   215: aload_3
    //   216: athrow
    // Exception table:
    //   from	to	target	type
    //   2	13	212	finally
    //   13	31	212	finally
    //   34	50	212	finally
    //   50	55	212	finally
    //   67	174	212	finally
    //   181	200	212	finally
    //   200	208	212	finally
  }
  
  public final boolean n() {
    try {
      if (this.d != null) {
        if (!TextUtils.isEmpty(this.d.getSimOperator()))
          return true; 
        boolean bool = TextUtils.isEmpty(this.d.getSimCountryIso());
        if (!bool)
          return true; 
      } 
    } finally {
      Exception exception;
    } 
    try {
      int i = ep.a(ep.c(this.l));
      if (i == 0 || i == 4 || i == 2 || i == 5 || i == 3)
        return true; 
    } finally {
      Exception exception;
    } 
  }
  
  final class a extends TelephonyManager.CellInfoCallback {
    a(dw this$0) {}
    
    public final void onCellInfo(List<CellInfo> param1List) {
      dw.d(this.a);
      CellLocation cellLocation = dw.a(this.a, param1List);
      if (cellLocation != null) {
        dw dw1 = this.a;
        dw1.f = cellLocation;
        dw1.g = true;
        dw.e(dw1);
        dw.a(this.a, ep.b());
      } 
    }
  }
  
  final class b extends PhoneStateListener {
    b(dw this$0) {}
    
    public final void onCellInfoChanged(List<CellInfo> param1List) {
      try {
        return;
      } finally {
        param1List = null;
      } 
    }
    
    public final void onCellLocationChanged(CellLocation param1CellLocation) {
      try {
        if (!this.a.a(param1CellLocation))
          return; 
        this.a.f = param1CellLocation;
        this.a.g = true;
        dw.e(this.a);
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
      byte b1 = -113;
      try {
        int i = this.a.a;
        if (i != 1 && i != 2) {
          param1Int = b1;
        } else {
          param1Int = ep.a(param1Int);
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
          i = ep.a(param1SignalStrength.getGsmSignalStrength());
        } 
        dw.a(this.a, i);
        return;
      } finally {
        param1SignalStrength = null;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\dw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */