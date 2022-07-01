package com.ishumei.l111l11111Il;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.text.TextUtils;
import android.text.format.Formatter;
import com.ishumei.l1111l111111Il.l111l1111llIl;
import com.ishumei.l111l1111llIl.l111l1111l1Il;
import com.ishumei.l111l1111llIl.l111l1111lI1l;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

public final class l111l1111lIl {
  private static final int l111l11111I1l = -1;
  
  private static final int l111l11111Il = -101;
  
  private Context l1111l111111Il = null;
  
  private Object l111l11111lIl = null;
  
  public l111l1111lIl() {
    try {
      this.l1111l111111Il = l111l1111llIl.l1111l111111Il.l111l11111Il;
      if (this.l1111l111111Il != null) {
        Context context = this.l1111l111111Il;
        String str1 = l111l1111lI1l.l111l11111Il("989a8bac868c8b9a92ac9a8d89969c9a");
        String str2 = l111l1111lI1l.l111l11111Il("88969996");
        Object object = l111l1111l1Il.l1111l111111Il(context, str1, new Class[] { String.class }, new Object[] { str2 });
        if (object != null)
          this.l111l11111lIl = l111l1111l1Il.l1111l111111Il(object, l111l1111lI1l.l111l11111Il("989a8bbc9091919a9c8b969091b6919990")); 
      } 
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  private static String l1111l111111Il(int paramInt) {
    if (paramInt != -101) {
      switch (paramInt) {
        default:
          return String.format("%d", new Object[] { Integer.valueOf(paramInt) });
        case 15:
          return "3g.hspap";
        case 14:
          return "3g.ehrpd";
        case 13:
          return "4g.lte";
        case 12:
          return "3g.evdo_b";
        case 11:
          return "2g.iden";
        case 10:
          return "3g.hspa";
        case 9:
          return "3g.hsupa";
        case 8:
          return "3g.hsdpa";
        case 7:
          return "2g.1xrtt";
        case 6:
          return "3g.evdo_a";
        case 5:
          return "3g.evdo_0";
        case 4:
          return "2g.cdma";
        case 3:
          return "3g.umts";
        case 2:
          return "2g.edge";
        case 1:
          return "2g.gprs";
        case 0:
          return "unknown";
        case -1:
          break;
      } 
      return "nil";
    } 
    return "wifi";
  }
  
  private static String l1111l111111Il(String paramString) {
    if (paramString == null)
      return ""; 
    try {
      paramString = InetAddress.getByName(paramString).getHostAddress();
      return (paramString == null) ? "" : paramString;
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public static List<String> l111l1111l1Il() {
    ArrayList<String> arrayList = new ArrayList();
    try {
      Object object = l111l1111l1Il.l1111l111111Il(l111l1111lI1l.l111l11111Il("959e899ed1919a8bd1b19a8b88908d94b6918b9a8d999e9c9a"), l111l1111lI1l.l111l11111Il("989a8bb19a8b88908d94b6918b9a8d999e9c9a8c"));
      Method method1 = Enumeration.class.getDeclaredMethod(l111l1111lI1l.l111l11111Il("979e8cb2908d9aba939a929a918b8c"), new Class[0]);
      method1.setAccessible(true);
      Method method2 = Enumeration.class.getDeclaredMethod(l111l1111lI1l.l111l11111Il("919a878bba939a929a918b"), new Class[0]);
      method2.setAccessible(true);
      label34: while (true) {
        if (((Boolean)method1.invoke(object, new Object[0])).booleanValue()) {
          NetworkInterface networkInterface = (NetworkInterface)method2.invoke(object, new Object[0]);
          String str = networkInterface.getDisplayName();
          if ((str.startsWith("wlan") || str.startsWith("p2p")) && !networkInterface.isLoopback()) {
            String str1;
            byte[] arrayOfByte = networkInterface.getHardwareAddress();
            String str2 = "";
            if (arrayOfByte != null && arrayOfByte.length > 0) {
              str1 = com.ishumei.l111l1111llIl.l111l1111lIl.l111l11111Il(com.ishumei.l111l1111llIl.l111l1111lIl.l1111l111111Il(arrayOfByte));
            } else {
              str1 = "";
            } 
            if (!str1.isEmpty() && !str1.equals("000000000000")) {
              Enumeration<InetAddress> enumeration = networkInterface.getInetAddresses();
              String str3 = "";
              while (true) {
                if (enumeration.hasMoreElements()) {
                  InetAddress inetAddress = enumeration.nextElement();
                  if (!inetAddress.isLoopbackAddress()) {
                    String str4 = inetAddress.getHostAddress();
                    if (str4.trim().length() < 17) {
                      str2 = str4;
                      continue;
                    } 
                    str3 = str4;
                  } 
                  continue;
                } 
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(",");
                stringBuilder.append(str2);
                stringBuilder.append(",");
                stringBuilder.append(str1);
                stringBuilder.append(",");
                stringBuilder.append(str3);
                arrayList.add(stringBuilder.toString());
                continue label34;
              } 
              break;
            } 
          } 
          continue;
        } 
        return arrayList;
      } 
    } catch (Exception exception) {
      return arrayList;
    } 
  }
  
  public static boolean l111l1111lI1l() {
    try {
      NetworkInfo networkInfo = ((ConnectivityManager)l111l1111llIl.l1111l111111Il.l111l11111Il.getSystemService("connectivity")).getActiveNetworkInfo();
      return (networkInfo != null) ? networkInfo.isConnected() : false;
    } catch (Exception exception) {
      return true;
    } 
  }
  
  private static String l111l1111lIl() {
    try {
      return com.ishumei.l111l1111llIl.l111l1111lIl.l111l11111Il((String)null.getClass().getDeclaredMethod(l111l1111lI1l.l111l11111Il("989a8bbe9b9b8d9a8c8c"), new Class[0]).invoke(null, new Object[0]));
    } finally {
      Exception exception = null;
    } 
  }
  
  public static String l111l1111llIl() {
    try {
      String str;
      if (Build.VERSION.SDK_INT >= 14) {
        String str1 = System.getProperty("http.proxyHost");
        String str2 = System.getProperty("http.proxyPort");
        str = str1;
        null = str2;
        if (TextUtils.isEmpty(str2)) {
          null = "-1";
          str = str1;
        } 
      } else {
        Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
        if (context == null)
          return ""; 
        str = Proxy.getHost(context);
        null = String.valueOf(Proxy.getPort(context));
      } 
      if (TextUtils.isEmpty(str))
        return ""; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append(":");
      stringBuilder.append(null);
      return stringBuilder.toString();
    } catch (Exception exception) {
      return "";
    } 
  }
  
  private static HashMap<String, Object> l11l1111I11l() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    ArrayList<HashMap<Object, Object>> arrayList = new ArrayList();
    try {
      Object object = l111l1111l1Il.l1111l111111Il(l111l1111lI1l.l111l11111Il("959e899ed1919a8bd1b19a8b88908d94b6918b9a8d999e9c9a"), l111l1111lI1l.l111l11111Il("989a8bb19a8b88908d94b6918b9a8d999e9c9a8c"));
      Method method1 = Enumeration.class.getDeclaredMethod(l111l1111lI1l.l111l11111Il("979e8cb2908d9aba939a929a918b8c"), new Class[0]);
      method1.setAccessible(true);
      Method method2 = Enumeration.class.getDeclaredMethod(l111l1111lI1l.l111l11111Il("919a878bba939a929a918b"), new Class[0]);
      method2.setAccessible(true);
      while (true) {
        if (((Boolean)method1.invoke(object, new Object[] { null })).booleanValue()) {
          NetworkInterface networkInterface = (NetworkInterface)method2.invoke(object, new Object[] { null });
          if (!networkInterface.isLoopback()) {
            String str1;
            String str2;
            Enumeration<InetAddress> enumeration = networkInterface.getInetAddresses();
            while (true) {
              boolean bool = enumeration.hasMoreElements();
              str2 = "";
              if (bool) {
                InetAddress inetAddress = enumeration.nextElement();
                if (!inetAddress.isLoopbackAddress()) {
                  String str = inetAddress.getHostAddress().toString();
                  if (str.length() < 15)
                    break; 
                } 
                continue;
              } 
              str1 = "";
              break;
            } 
            if (!l111l1111lI1l.l1111l111111Il(str1)) {
              HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>();
              hashMap1.put(l111l1111lI1l.l111l11111Il("9b968c8f939e86"), networkInterface.getDisplayName());
              byte[] arrayOfByte = networkInterface.getHardwareAddress();
              String str = str2;
              if (arrayOfByte != null) {
                str = str2;
                if (arrayOfByte.length > 0)
                  str = com.ishumei.l111l1111llIl.l111l1111lIl.l1111l111111Il(arrayOfByte); 
              } 
              hashMap1.put(l111l1111lI1l.l111l11111Il("929e9c"), com.ishumei.l111l1111llIl.l111l1111lIl.l111l11111Il(str));
              hashMap1.put(l111l1111lI1l.l111l11111Il("968f"), str1);
              arrayList.add(hashMap1);
            } 
          } 
          continue;
        } 
        hashMap.put(l111l1111lI1l.l111l11111Il("96999c9091999698"), arrayList);
        return (HashMap)hashMap;
      } 
    } catch (Exception exception) {
      return (HashMap)hashMap;
    } 
  }
  
  private String l11l1111lIIl() {
    // Byte code:
    //   0: aload_0
    //   1: getfield l1111l111111Il : Landroid/content/Context;
    //   4: ldc 'connectivity'
    //   6: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   9: checkcast android/net/ConnectivityManager
    //   12: invokevirtual getActiveNetworkInfo : ()Landroid/net/NetworkInfo;
    //   15: astore_2
    //   16: aload_2
    //   17: ifnull -> 79
    //   20: aload_2
    //   21: invokevirtual isAvailable : ()Z
    //   24: ifeq -> 79
    //   27: aload_2
    //   28: invokevirtual isConnected : ()Z
    //   31: ifeq -> 79
    //   34: aload_2
    //   35: invokevirtual getType : ()I
    //   38: istore_1
    //   39: iload_1
    //   40: iconst_1
    //   41: if_icmpne -> 50
    //   44: bipush #-101
    //   46: istore_1
    //   47: goto -> 81
    //   50: iload_1
    //   51: ifne -> 74
    //   54: aload_0
    //   55: getfield l1111l111111Il : Landroid/content/Context;
    //   58: ldc_w 'phone'
    //   61: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   64: checkcast android/telephony/TelephonyManager
    //   67: invokevirtual getNetworkType : ()I
    //   70: istore_1
    //   71: goto -> 81
    //   74: iconst_0
    //   75: istore_1
    //   76: goto -> 81
    //   79: iconst_m1
    //   80: istore_1
    //   81: iload_1
    //   82: bipush #-101
    //   84: if_icmpeq -> 240
    //   87: iload_1
    //   88: tableswitch default -> 172, -1 -> 237, 0 -> 234, 1 -> 231, 2 -> 228, 3 -> 225, 4 -> 222, 5 -> 219, 6 -> 216, 7 -> 213, 8 -> 210, 9 -> 207, 10 -> 204, 11 -> 201, 12 -> 198, 13 -> 195, 14 -> 192, 15 -> 189
    //   172: ldc '%d'
    //   174: iconst_1
    //   175: anewarray java/lang/Object
    //   178: dup
    //   179: iconst_0
    //   180: iload_1
    //   181: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   184: aastore
    //   185: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   188: areturn
    //   189: ldc '3g.hspap'
    //   191: areturn
    //   192: ldc '3g.ehrpd'
    //   194: areturn
    //   195: ldc '4g.lte'
    //   197: areturn
    //   198: ldc '3g.evdo_b'
    //   200: areturn
    //   201: ldc '2g.iden'
    //   203: areturn
    //   204: ldc '3g.hspa'
    //   206: areturn
    //   207: ldc '3g.hsupa'
    //   209: areturn
    //   210: ldc '3g.hsdpa'
    //   212: areturn
    //   213: ldc '2g.1xrtt'
    //   215: areturn
    //   216: ldc '3g.evdo_a'
    //   218: areturn
    //   219: ldc '3g.evdo_0'
    //   221: areturn
    //   222: ldc '2g.cdma'
    //   224: areturn
    //   225: ldc '3g.umts'
    //   227: areturn
    //   228: ldc '2g.edge'
    //   230: areturn
    //   231: ldc '2g.gprs'
    //   233: areturn
    //   234: ldc 'unknown'
    //   236: areturn
    //   237: ldc 'nil'
    //   239: areturn
    //   240: ldc 'wifi'
    //   242: areturn
    //   243: astore_2
    //   244: goto -> 74
    // Exception table:
    //   from	to	target	type
    //   0	16	243	java/lang/Exception
    //   20	39	243	java/lang/Exception
    //   54	71	243	java/lang/Exception
  }
  
  public final String l1111l111111Il() {
    String str = "";
    try {
      if (this.l111l11111lIl != null) {
        str = (String)l111l1111l1Il.l1111l111111Il(this.l111l11111lIl, l111l1111lI1l.l111l11111Il("989a8bacacb6bb"));
        if (str == null)
          return ""; 
      } 
      return str;
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public final String l111l11111I1l() {
    String str = "";
    try {
      if (this.l111l11111lIl != null) {
        str = Formatter.formatIpAddress(((Integer)l111l1111l1Il.l1111l111111Il(this.l111l11111lIl, l111l1111lI1l.l111l11111Il("989a8bb68fbe9b9b8d9a8c8c"))).intValue());
        if (str == null)
          return ""; 
      } 
      return str;
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public final String l111l11111Il() {
    String str = "";
    try {
      if (this.l1111l111111Il != null) {
        str = l11l1111lIIl();
        if (str == null)
          return ""; 
      } 
      return str;
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public final String l111l11111lIl() {
    String str = "";
    try {
      if (this.l111l11111lIl != null) {
        str = (String)l111l1111l1Il.l1111l111111Il(this.l111l11111lIl, l111l1111lI1l.l111l11111Il("989a8bbdacacb6bb"));
        if (str == null)
          return ""; 
      } 
      return str;
    } catch (Exception exception) {
      return "";
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\l111l11111Il\l111l1111lIl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */