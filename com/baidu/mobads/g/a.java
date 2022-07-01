package com.baidu.mobads.g;

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
import android.telephony.TelephonyManager;
import com.baidu.mobads.MobadsPermissionSettings;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class a {
  private static Method c;
  
  private static Method d;
  
  private static Method e;
  
  private static Class<?> f;
  
  private static char[] h = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_.".toCharArray();
  
  private TelephonyManager a = null;
  
  private a b = new a(null);
  
  private String g = null;
  
  public a(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("&");
    stringBuilder.append(paramString);
    stringBuilder.append("&null");
    this.g = stringBuilder.toString();
  }
  
  private a a(CellInfo paramCellInfo) {
    int i = Integer.valueOf(Build.VERSION.SDK_INT).intValue();
    if (i < 17)
      return null; 
    a a1 = new a(null);
    boolean bool1 = paramCellInfo instanceof CellInfoGsm;
    boolean bool = true;
    if (bool1) {
      CellIdentityGsm cellIdentityGsm = ((CellInfoGsm)paramCellInfo).getCellIdentity();
      a1.c = b(cellIdentityGsm.getMcc());
      a1.d = b(cellIdentityGsm.getMnc());
      a1.a = b(cellIdentityGsm.getLac());
      a1.b = b(cellIdentityGsm.getCid());
      a1.e = 'g';
    } else if (paramCellInfo instanceof CellInfoCdma) {
      CellIdentityCdma cellIdentityCdma = ((CellInfoCdma)paramCellInfo).getCellIdentity();
      a1.d = b(cellIdentityCdma.getSystemId());
      a1.a = b(cellIdentityCdma.getNetworkId());
      a1.b = b(cellIdentityCdma.getBasestationId());
      a1.e = 'w';
    } else if (paramCellInfo instanceof CellInfoLte) {
      CellIdentityLte cellIdentityLte = ((CellInfoLte)paramCellInfo).getCellIdentity();
      a1.c = b(cellIdentityLte.getMcc());
      a1.d = b(cellIdentityLte.getMnc());
      a1.a = b(cellIdentityLte.getTac());
      a1.b = b(cellIdentityLte.getCi());
      a1.e = 'g';
    } else {
      bool = false;
    } 
    if (i >= 18 && !bool)
      try {
        if (paramCellInfo instanceof CellInfoWcdma) {
          CellIdentityWcdma cellIdentityWcdma = ((CellInfoWcdma)paramCellInfo).getCellIdentity();
          a1.c = b(cellIdentityWcdma.getMcc());
          a1.d = b(cellIdentityWcdma.getMnc());
          a1.a = b(cellIdentityWcdma.getLac());
          a1.b = b(cellIdentityWcdma.getCid());
          a1.e = 'g';
        } 
        return a1;
      } catch (Exception exception) {
        return a1;
      }  
    return a1;
  }
  
  private String a(int paramInt) {
    String str;
    try {
      a a1 = b();
      if (a1 == null || !a.a(a1)) {
        a(this.a.getCellLocation());
      } else {
        this.b = a1;
      } 
      String str1 = this.b.a();
    } catch (Exception exception1) {
      exception1 = null;
    } 
    Exception exception2 = exception1;
    if (exception1 == null)
      str = "Z"; 
    if (str.equals("Z"))
      return null; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append("t");
    stringBuilder.append(System.currentTimeMillis());
    stringBuilder.append(this.g);
    return a(stringBuilder.toString());
  }
  
  private static String a(String paramString) {
    if (paramString == null)
      return null; 
    byte[] arrayOfByte1 = paramString.getBytes();
    byte b1 = (byte)(new Random()).nextInt(255);
    byte b2 = (byte)(new Random()).nextInt(255);
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + 2];
    int k = arrayOfByte1.length;
    int j = 0;
    int i;
    for (i = 0; j < k; i++) {
      arrayOfByte2[i] = (byte)(arrayOfByte1[j] ^ b1);
      j++;
    } 
    arrayOfByte2[i] = b1;
    arrayOfByte2[i + 1] = b2;
    return a(arrayOfByte2);
  }
  
  private static String a(byte[] paramArrayOfbyte) {
    char[] arrayOfChar = new char[(paramArrayOfbyte.length + 2) / 3 * 4];
    int j = 0;
    for (int i = 0; j < paramArrayOfbyte.length; i += 4) {
      int m = (paramArrayOfbyte[j] & 0xFF) << 8;
      int k = j + 1;
      int i1 = paramArrayOfbyte.length;
      int n = 1;
      if (k < i1) {
        m |= paramArrayOfbyte[k] & 0xFF;
        k = 1;
      } else {
        k = 0;
      } 
      m <<= 8;
      i1 = j + 2;
      if (i1 < paramArrayOfbyte.length) {
        m |= paramArrayOfbyte[i1] & 0xFF;
      } else {
        n = 0;
      } 
      char[] arrayOfChar1 = h;
      i1 = 64;
      if (n) {
        n = 63 - (m & 0x3F);
      } else {
        n = 64;
      } 
      arrayOfChar[i + 3] = arrayOfChar1[n];
      n = m >> 6;
      arrayOfChar1 = h;
      m = i1;
      if (k != 0)
        m = 63 - (n & 0x3F); 
      arrayOfChar[i + 2] = arrayOfChar1[m];
      k = n >> 6;
      arrayOfChar1 = h;
      arrayOfChar[i + 1] = arrayOfChar1[63 - (k & 0x3F)];
      arrayOfChar[i + 0] = arrayOfChar1[63 - (k >> 6 & 0x3F)];
      j += 3;
    } 
    return new String(arrayOfChar);
  }
  
  private void a(CellLocation paramCellLocation) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 408
    //   4: aload_0
    //   5: getfield a : Landroid/telephony/TelephonyManager;
    //   8: ifnonnull -> 12
    //   11: return
    //   12: new com/baidu/mobads/g/a$a
    //   15: dup
    //   16: aload_0
    //   17: aconst_null
    //   18: invokespecial <init> : (Lcom/baidu/mobads/g/a;Lcom/baidu/mobads/g/b;)V
    //   21: astore #4
    //   23: aload_0
    //   24: getfield a : Landroid/telephony/TelephonyManager;
    //   27: invokevirtual getNetworkOperator : ()Ljava/lang/String;
    //   30: astore #5
    //   32: aload #5
    //   34: ifnull -> 167
    //   37: aload #5
    //   39: invokevirtual length : ()I
    //   42: ifle -> 167
    //   45: aload #5
    //   47: invokevirtual length : ()I
    //   50: iconst_3
    //   51: if_icmplt -> 88
    //   54: aload #5
    //   56: iconst_0
    //   57: iconst_3
    //   58: invokevirtual substring : (II)Ljava/lang/String;
    //   61: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Integer;
    //   64: invokevirtual intValue : ()I
    //   67: istore_3
    //   68: iload_3
    //   69: istore_2
    //   70: iload_3
    //   71: ifge -> 82
    //   74: aload_0
    //   75: getfield b : Lcom/baidu/mobads/g/a$a;
    //   78: getfield c : I
    //   81: istore_2
    //   82: aload #4
    //   84: iload_2
    //   85: putfield c : I
    //   88: aload #5
    //   90: iconst_3
    //   91: invokevirtual substring : (I)Ljava/lang/String;
    //   94: astore #5
    //   96: aload #5
    //   98: ifnull -> 167
    //   101: aload #5
    //   103: invokevirtual toCharArray : ()[C
    //   106: astore #6
    //   108: iconst_0
    //   109: istore_2
    //   110: iload_2
    //   111: aload #6
    //   113: arraylength
    //   114: if_icmpge -> 130
    //   117: aload #6
    //   119: iload_2
    //   120: caload
    //   121: invokestatic isDigit : (C)Z
    //   124: ifne -> 420
    //   127: goto -> 130
    //   130: aload #5
    //   132: iconst_0
    //   133: iload_2
    //   134: invokevirtual substring : (II)Ljava/lang/String;
    //   137: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Integer;
    //   140: invokevirtual intValue : ()I
    //   143: istore_3
    //   144: iload_3
    //   145: istore_2
    //   146: iload_3
    //   147: ifge -> 158
    //   150: aload_0
    //   151: getfield b : Lcom/baidu/mobads/g/a$a;
    //   154: getfield d : I
    //   157: istore_2
    //   158: aload #4
    //   160: iload_2
    //   161: putfield d : I
    //   164: goto -> 167
    //   167: aload_1
    //   168: instanceof android/telephony/gsm/GsmCellLocation
    //   171: ifeq -> 207
    //   174: aload_1
    //   175: checkcast android/telephony/gsm/GsmCellLocation
    //   178: astore_1
    //   179: aload #4
    //   181: aload_1
    //   182: invokevirtual getLac : ()I
    //   185: putfield a : I
    //   188: aload #4
    //   190: aload_1
    //   191: invokevirtual getCid : ()I
    //   194: putfield b : I
    //   197: aload #4
    //   199: bipush #103
    //   201: putfield e : C
    //   204: goto -> 394
    //   207: aload_1
    //   208: instanceof android/telephony/cdma/CdmaCellLocation
    //   211: ifeq -> 394
    //   214: aload #4
    //   216: bipush #119
    //   218: putfield e : C
    //   221: getstatic com/baidu/mobads/g/a.f : Ljava/lang/Class;
    //   224: ifnonnull -> 290
    //   227: ldc 'android.telephony.cdma.CdmaCellLocation'
    //   229: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   232: putstatic com/baidu/mobads/g/a.f : Ljava/lang/Class;
    //   235: getstatic com/baidu/mobads/g/a.f : Ljava/lang/Class;
    //   238: ldc 'getBaseStationId'
    //   240: iconst_0
    //   241: anewarray java/lang/Class
    //   244: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   247: putstatic com/baidu/mobads/g/a.c : Ljava/lang/reflect/Method;
    //   250: getstatic com/baidu/mobads/g/a.f : Ljava/lang/Class;
    //   253: ldc_w 'getNetworkId'
    //   256: iconst_0
    //   257: anewarray java/lang/Class
    //   260: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   263: putstatic com/baidu/mobads/g/a.d : Ljava/lang/reflect/Method;
    //   266: getstatic com/baidu/mobads/g/a.f : Ljava/lang/Class;
    //   269: ldc_w 'getSystemId'
    //   272: iconst_0
    //   273: anewarray java/lang/Class
    //   276: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   279: putstatic com/baidu/mobads/g/a.e : Ljava/lang/reflect/Method;
    //   282: goto -> 290
    //   285: aconst_null
    //   286: putstatic com/baidu/mobads/g/a.f : Ljava/lang/Class;
    //   289: return
    //   290: getstatic com/baidu/mobads/g/a.f : Ljava/lang/Class;
    //   293: astore #5
    //   295: aload #5
    //   297: ifnull -> 394
    //   300: aload #5
    //   302: aload_1
    //   303: invokevirtual isInstance : (Ljava/lang/Object;)Z
    //   306: ifeq -> 394
    //   309: getstatic com/baidu/mobads/g/a.e : Ljava/lang/reflect/Method;
    //   312: aload_1
    //   313: iconst_0
    //   314: anewarray java/lang/Object
    //   317: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   320: checkcast java/lang/Integer
    //   323: invokevirtual intValue : ()I
    //   326: istore_3
    //   327: iload_3
    //   328: istore_2
    //   329: iload_3
    //   330: ifge -> 341
    //   333: aload_0
    //   334: getfield b : Lcom/baidu/mobads/g/a$a;
    //   337: getfield d : I
    //   340: istore_2
    //   341: aload #4
    //   343: iload_2
    //   344: putfield d : I
    //   347: aload #4
    //   349: getstatic com/baidu/mobads/g/a.c : Ljava/lang/reflect/Method;
    //   352: aload_1
    //   353: iconst_0
    //   354: anewarray java/lang/Object
    //   357: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   360: checkcast java/lang/Integer
    //   363: invokevirtual intValue : ()I
    //   366: putfield b : I
    //   369: aload #4
    //   371: getstatic com/baidu/mobads/g/a.d : Ljava/lang/reflect/Method;
    //   374: aload_1
    //   375: iconst_0
    //   376: anewarray java/lang/Object
    //   379: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   382: checkcast java/lang/Integer
    //   385: invokevirtual intValue : ()I
    //   388: putfield a : I
    //   391: goto -> 394
    //   394: aload #4
    //   396: invokestatic a : (Lcom/baidu/mobads/g/a$a;)Z
    //   399: ifeq -> 408
    //   402: aload_0
    //   403: aload #4
    //   405: putfield b : Lcom/baidu/mobads/g/a$a;
    //   408: return
    //   409: astore #5
    //   411: goto -> 167
    //   414: astore_1
    //   415: goto -> 285
    //   418: astore_1
    //   419: return
    //   420: iload_2
    //   421: iconst_1
    //   422: iadd
    //   423: istore_2
    //   424: goto -> 110
    // Exception table:
    //   from	to	target	type
    //   45	68	409	java/lang/Exception
    //   74	82	409	java/lang/Exception
    //   82	88	409	java/lang/Exception
    //   88	96	409	java/lang/Exception
    //   101	108	409	java/lang/Exception
    //   110	127	409	java/lang/Exception
    //   130	144	409	java/lang/Exception
    //   150	158	409	java/lang/Exception
    //   158	164	409	java/lang/Exception
    //   227	282	414	java/lang/Exception
    //   309	327	418	java/lang/Exception
    //   333	341	418	java/lang/Exception
    //   341	391	418	java/lang/Exception
  }
  
  private int b(int paramInt) {
    int i = paramInt;
    if (paramInt == Integer.MAX_VALUE)
      i = -1; 
    return i;
  }
  
  private a b() {
    int i = Integer.valueOf(Build.VERSION.SDK_INT).intValue();
    List list = null;
    if (i < 17)
      return null; 
    try {
      List list2 = this.a.getAllCellInfo();
      List list1 = list;
      if (list2 != null) {
        list1 = list;
        if (list2.size() > 0) {
          Iterator<CellInfo> iterator = list2.iterator();
          list1 = null;
          while (true) {
            a a1;
            a a2;
            list2 = list1;
            list = list1;
            try {
              if (iterator.hasNext()) {
                list = list1;
                CellInfo cellInfo = iterator.next();
                list = list1;
                if (cellInfo.isRegistered()) {
                  list = list1;
                  a a3 = a(cellInfo);
                  if (a3 == null)
                    continue; 
                  a1 = a3;
                  boolean bool = a.a(a3);
                  return !bool ? null : a3;
                } 
                continue;
              } 
            } catch (Exception exception) {
              a2 = a1;
            } 
            return a2;
          } 
        } 
      } 
      return (a)list1;
    } catch (Exception|NoSuchMethodError exception) {
      return null;
    } 
  }
  
  public String a() {
    if (!MobadsPermissionSettings.hasPermissionGranted("permission_location"))
      return ""; 
    try {
      return a(10);
    } catch (Exception exception) {
      return null;
    } 
  }
  
  class a {
    public int a = -1;
    
    public int b = -1;
    
    public int c = -1;
    
    public int d = -1;
    
    public char e = Character.MIN_VALUE;
    
    private a(a this$0) {}
    
    private boolean b() {
      return (this.a > -1 && this.b > 0);
    }
    
    public String a() {
      if (!b())
        return null; 
      StringBuffer stringBuffer = new StringBuffer(128);
      stringBuffer.append(this.e);
      stringBuffer.append("h");
      int i = this.c;
      if (i != 460)
        stringBuffer.append(i); 
      stringBuffer.append(String.format(Locale.CHINA, "h%xh%xh%x", new Object[] { Integer.valueOf(this.d), Integer.valueOf(this.a), Integer.valueOf(this.b) }));
      return stringBuffer.toString();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\g\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */