package com.qiniu.android.dns.local;

import com.qiniu.android.dns.Domain;
import com.qiniu.android.dns.IResolver;
import com.qiniu.android.dns.NetworkInfo;
import com.qiniu.android.dns.Record;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class AndroidDnsServer {
  public static IResolver defaultResolver() {
    return new IResolver() {
        public Record[] resolve(Domain param1Domain, NetworkInfo param1NetworkInfo) throws IOException {
          InetAddress[] arrayOfInetAddress2 = AndroidDnsServer.getByReflection();
          InetAddress[] arrayOfInetAddress1 = arrayOfInetAddress2;
          if (arrayOfInetAddress2 == null)
            arrayOfInetAddress1 = AndroidDnsServer.getByCommand(); 
          if (arrayOfInetAddress1 != null)
            return (new HijackingDetectWrapper(new Resolver(arrayOfInetAddress1[0]))).resolve(param1Domain, param1NetworkInfo); 
          throw new IOException("cant get local dns server");
        }
      };
  }
  
  public static InetAddress[] getByCommand() {
    // Byte code:
    //   0: invokestatic getRuntime : ()Ljava/lang/Runtime;
    //   3: ldc 'getprop'
    //   5: invokevirtual exec : (Ljava/lang/String;)Ljava/lang/Process;
    //   8: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   11: astore_1
    //   12: new java/io/LineNumberReader
    //   15: dup
    //   16: new java/io/InputStreamReader
    //   19: dup
    //   20: aload_1
    //   21: invokespecial <init> : (Ljava/io/InputStream;)V
    //   24: invokespecial <init> : (Ljava/io/Reader;)V
    //   27: astore_2
    //   28: aload_1
    //   29: astore_3
    //   30: aload_2
    //   31: astore #4
    //   33: new java/util/ArrayList
    //   36: dup
    //   37: iconst_5
    //   38: invokespecial <init> : (I)V
    //   41: astore #5
    //   43: aload_1
    //   44: astore_3
    //   45: aload_2
    //   46: astore #4
    //   48: aload_2
    //   49: invokevirtual readLine : ()Ljava/lang/String;
    //   52: astore #7
    //   54: aload #7
    //   56: ifnull -> 263
    //   59: aload_1
    //   60: astore_3
    //   61: aload_2
    //   62: astore #4
    //   64: aload #7
    //   66: ldc ']: ['
    //   68: invokevirtual indexOf : (Ljava/lang/String;)I
    //   71: istore_0
    //   72: iload_0
    //   73: iconst_m1
    //   74: if_icmpne -> 80
    //   77: goto -> 43
    //   80: aload_1
    //   81: astore_3
    //   82: aload_2
    //   83: astore #4
    //   85: aload #7
    //   87: iconst_1
    //   88: iload_0
    //   89: invokevirtual substring : (II)Ljava/lang/String;
    //   92: astore #6
    //   94: aload_1
    //   95: astore_3
    //   96: aload_2
    //   97: astore #4
    //   99: aload #7
    //   101: iload_0
    //   102: iconst_4
    //   103: iadd
    //   104: aload #7
    //   106: invokevirtual length : ()I
    //   109: iconst_1
    //   110: isub
    //   111: invokevirtual substring : (II)Ljava/lang/String;
    //   114: astore #7
    //   116: aload_1
    //   117: astore_3
    //   118: aload_2
    //   119: astore #4
    //   121: aload #6
    //   123: ldc '.dns'
    //   125: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   128: ifne -> 191
    //   131: aload_1
    //   132: astore_3
    //   133: aload_2
    //   134: astore #4
    //   136: aload #6
    //   138: ldc '.dns1'
    //   140: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   143: ifne -> 191
    //   146: aload_1
    //   147: astore_3
    //   148: aload_2
    //   149: astore #4
    //   151: aload #6
    //   153: ldc '.dns2'
    //   155: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   158: ifne -> 191
    //   161: aload_1
    //   162: astore_3
    //   163: aload_2
    //   164: astore #4
    //   166: aload #6
    //   168: ldc '.dns3'
    //   170: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   173: ifne -> 191
    //   176: aload_1
    //   177: astore_3
    //   178: aload_2
    //   179: astore #4
    //   181: aload #6
    //   183: ldc '.dns4'
    //   185: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   188: ifeq -> 43
    //   191: aload_1
    //   192: astore_3
    //   193: aload_2
    //   194: astore #4
    //   196: aload #7
    //   198: invokestatic getByName : (Ljava/lang/String;)Ljava/net/InetAddress;
    //   201: astore #6
    //   203: aload #6
    //   205: ifnonnull -> 211
    //   208: goto -> 43
    //   211: aload_1
    //   212: astore_3
    //   213: aload_2
    //   214: astore #4
    //   216: aload #6
    //   218: invokevirtual getHostAddress : ()Ljava/lang/String;
    //   221: astore #7
    //   223: aload #7
    //   225: ifnonnull -> 231
    //   228: goto -> 43
    //   231: aload_1
    //   232: astore_3
    //   233: aload_2
    //   234: astore #4
    //   236: aload #7
    //   238: invokevirtual length : ()I
    //   241: ifne -> 247
    //   244: goto -> 43
    //   247: aload_1
    //   248: astore_3
    //   249: aload_2
    //   250: astore #4
    //   252: aload #5
    //   254: aload #6
    //   256: invokevirtual add : (Ljava/lang/Object;)Z
    //   259: pop
    //   260: goto -> 43
    //   263: aload_1
    //   264: astore_3
    //   265: aload_2
    //   266: astore #4
    //   268: aload #5
    //   270: invokevirtual size : ()I
    //   273: ifle -> 314
    //   276: aload_1
    //   277: astore_3
    //   278: aload_2
    //   279: astore #4
    //   281: aload #5
    //   283: aload #5
    //   285: invokevirtual size : ()I
    //   288: anewarray java/net/InetAddress
    //   291: invokevirtual toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
    //   294: checkcast [Ljava/net/InetAddress;
    //   297: astore #5
    //   299: aload_2
    //   300: invokevirtual close : ()V
    //   303: aload_1
    //   304: ifnull -> 311
    //   307: aload_1
    //   308: invokevirtual close : ()V
    //   311: aload #5
    //   313: areturn
    //   314: aload_2
    //   315: invokevirtual close : ()V
    //   318: aload_1
    //   319: ifnull -> 398
    //   322: aload_1
    //   323: invokevirtual close : ()V
    //   326: aconst_null
    //   327: areturn
    //   328: astore #5
    //   330: goto -> 363
    //   333: astore_2
    //   334: aconst_null
    //   335: astore #4
    //   337: goto -> 403
    //   340: astore #5
    //   342: aconst_null
    //   343: astore_2
    //   344: goto -> 363
    //   347: astore_2
    //   348: aconst_null
    //   349: astore #4
    //   351: aload #4
    //   353: astore_1
    //   354: goto -> 403
    //   357: astore #5
    //   359: aconst_null
    //   360: astore_1
    //   361: aload_1
    //   362: astore_2
    //   363: aload_1
    //   364: astore_3
    //   365: aload_2
    //   366: astore #4
    //   368: ldc 'AndroidDnsServer'
    //   370: invokestatic getLogger : (Ljava/lang/String;)Ljava/util/logging/Logger;
    //   373: getstatic java/util/logging/Level.WARNING : Ljava/util/logging/Level;
    //   376: ldc 'Exception in findDNSByExec'
    //   378: aload #5
    //   380: invokevirtual log : (Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   383: aload_2
    //   384: ifnull -> 391
    //   387: aload_2
    //   388: invokevirtual close : ()V
    //   391: aload_1
    //   392: ifnull -> 398
    //   395: goto -> 322
    //   398: aconst_null
    //   399: areturn
    //   400: astore_2
    //   401: aload_3
    //   402: astore_1
    //   403: aload #4
    //   405: ifnull -> 413
    //   408: aload #4
    //   410: invokevirtual close : ()V
    //   413: aload_1
    //   414: ifnull -> 421
    //   417: aload_1
    //   418: invokevirtual close : ()V
    //   421: aload_2
    //   422: athrow
    //   423: astore_1
    //   424: aload #5
    //   426: areturn
    //   427: astore_1
    //   428: aconst_null
    //   429: areturn
    //   430: astore_1
    //   431: goto -> 421
    // Exception table:
    //   from	to	target	type
    //   0	12	357	java/io/IOException
    //   0	12	347	finally
    //   12	28	340	java/io/IOException
    //   12	28	333	finally
    //   33	43	328	java/io/IOException
    //   33	43	400	finally
    //   48	54	328	java/io/IOException
    //   48	54	400	finally
    //   64	72	328	java/io/IOException
    //   64	72	400	finally
    //   85	94	328	java/io/IOException
    //   85	94	400	finally
    //   99	116	328	java/io/IOException
    //   99	116	400	finally
    //   121	131	328	java/io/IOException
    //   121	131	400	finally
    //   136	146	328	java/io/IOException
    //   136	146	400	finally
    //   151	161	328	java/io/IOException
    //   151	161	400	finally
    //   166	176	328	java/io/IOException
    //   166	176	400	finally
    //   181	191	328	java/io/IOException
    //   181	191	400	finally
    //   196	203	328	java/io/IOException
    //   196	203	400	finally
    //   216	223	328	java/io/IOException
    //   216	223	400	finally
    //   236	244	328	java/io/IOException
    //   236	244	400	finally
    //   252	260	328	java/io/IOException
    //   252	260	400	finally
    //   268	276	328	java/io/IOException
    //   268	276	400	finally
    //   281	299	328	java/io/IOException
    //   281	299	400	finally
    //   299	303	423	java/lang/Exception
    //   307	311	423	java/lang/Exception
    //   314	318	427	java/lang/Exception
    //   322	326	427	java/lang/Exception
    //   368	383	400	finally
    //   387	391	427	java/lang/Exception
    //   408	413	430	java/lang/Exception
    //   417	421	430	java/lang/Exception
  }
  
  public static InetAddress[] getByReflection() {
    try {
      Method method = Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class });
      ArrayList<InetAddress> arrayList = new ArrayList(5);
      String[] arrayOfString = new String[4];
      arrayOfString[0] = "net.dns1";
      arrayOfString[1] = "net.dns2";
      arrayOfString[2] = "net.dns3";
      arrayOfString[3] = "net.dns4";
      int j = arrayOfString.length;
      for (int i = 0;; i++) {
        if (i < j) {
          String str = (String)method.invoke(null, new Object[] { arrayOfString[i] });
          if (str != null && str.length() != 0) {
            InetAddress inetAddress = InetAddress.getByName(str);
            if (inetAddress != null) {
              String str1 = inetAddress.getHostAddress();
              if (str1 != null && str1.length() != 0 && !arrayList.contains(inetAddress))
                arrayList.add(inetAddress); 
            } 
          } 
        } else {
          return (arrayList.size() > 0) ? arrayList.<InetAddress>toArray(new InetAddress[arrayList.size()]) : null;
        } 
      } 
    } catch (Exception exception) {
      Logger.getLogger("AndroidDnsServer").log(Level.WARNING, "Exception in findDNSByReflection", exception);
    } 
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\android\dns\local\AndroidDnsServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */