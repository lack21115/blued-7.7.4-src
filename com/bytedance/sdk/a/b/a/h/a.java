package com.bytedance.sdk.a.b.a.h;

import com.bytedance.sdk.a.b.a.c;
import com.bytedance.sdk.a.b.a.g.e;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a {
  private static final byte[] a = new byte[] { 42 };
  
  private static final String[] b = new String[0];
  
  private static final String[] c = new String[] { "*" };
  
  private static final a d = new a();
  
  private final AtomicBoolean e = new AtomicBoolean(false);
  
  private final CountDownLatch f = new CountDownLatch(1);
  
  private byte[] g;
  
  private byte[] h;
  
  public static a a() {
    return d;
  }
  
  private static String a(byte[] paramArrayOfbyte, byte[][] paramArrayOfbyte1, int paramInt) {
    int i = paramArrayOfbyte.length;
    int j = 0;
    label56: while (j < i) {
      int k;
      for (k = (j + i) / 2; k > -1 && paramArrayOfbyte[k] != 10; k--);
      int m = k + 1;
      k = 1;
      while (true) {
        int i2 = m + k;
        if (paramArrayOfbyte[i2] != 10) {
          k++;
          continue;
        } 
        int i3 = i2 - m;
        int n = paramInt;
        boolean bool = false;
        k = 0;
        int i1 = 0;
        label53: while (true) {
          int i4;
          if (bool) {
            bool = false;
            i4 = 46;
          } else {
            i4 = paramArrayOfbyte1[n][k] & 0xFF;
          } 
          int i5 = i4 - (paramArrayOfbyte[m + i1] & 0xFF);
          if (i5 == 0) {
            i4 = i1 + 1;
            int i6 = k + 1;
            if (i4 == i3) {
              k = i6;
              i1 = i4;
            } else {
              k = i6;
              i1 = i4;
              if ((paramArrayOfbyte1[n]).length == i6) {
                if (n == paramArrayOfbyte1.length - 1) {
                  i1 = i4;
                  k = i6;
                } else {
                  n++;
                  bool = true;
                  k = -1;
                  i1 = i4;
                  continue;
                } 
              } else {
                continue;
              } 
            } 
          } 
          if (i5 < 0) {
            i = m - 1;
            continue label56;
          } 
          if (i5 > 0) {
            j = i2 + 1;
            continue label56;
          } 
          i1 = i3 - i1;
          k = (paramArrayOfbyte1[n]).length - k;
          while (true) {
            if (++n < paramArrayOfbyte1.length) {
              k += (paramArrayOfbyte1[n]).length;
              continue;
            } 
            if (k < i1)
              continue label53; 
            if (k > i1)
              continue label53; 
            return new String(paramArrayOfbyte, m, i3, c.e);
          } 
          break;
        } 
      } 
      continue;
    } 
    return null;
  }
  
  private String[] a(String[] paramArrayOfString) {
    // Byte code:
    //   0: aload_0
    //   1: getfield e : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   4: invokevirtual get : ()Z
    //   7: istore #4
    //   9: iconst_0
    //   10: istore_3
    //   11: iload #4
    //   13: ifne -> 35
    //   16: aload_0
    //   17: getfield e : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   20: iconst_0
    //   21: iconst_1
    //   22: invokevirtual compareAndSet : (ZZ)Z
    //   25: ifeq -> 35
    //   28: aload_0
    //   29: invokespecial b : ()V
    //   32: goto -> 42
    //   35: aload_0
    //   36: getfield f : Ljava/util/concurrent/CountDownLatch;
    //   39: invokevirtual await : ()V
    //   42: aload_0
    //   43: monitorenter
    //   44: aload_0
    //   45: getfield g : [B
    //   48: ifnull -> 338
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: arraylength
    //   55: anewarray [B
    //   58: astore #7
    //   60: iconst_0
    //   61: istore_2
    //   62: iload_2
    //   63: aload_1
    //   64: arraylength
    //   65: if_icmpge -> 88
    //   68: aload #7
    //   70: iload_2
    //   71: aload_1
    //   72: iload_2
    //   73: aaload
    //   74: getstatic com/bytedance/sdk/a/b/a/c.e : Ljava/nio/charset/Charset;
    //   77: invokevirtual getBytes : (Ljava/nio/charset/Charset;)[B
    //   80: aastore
    //   81: iload_2
    //   82: iconst_1
    //   83: iadd
    //   84: istore_2
    //   85: goto -> 62
    //   88: iconst_0
    //   89: istore_2
    //   90: iload_2
    //   91: aload #7
    //   93: arraylength
    //   94: if_icmpge -> 122
    //   97: aload_0
    //   98: getfield g : [B
    //   101: aload #7
    //   103: iload_2
    //   104: invokestatic a : ([B[[BI)Ljava/lang/String;
    //   107: astore_1
    //   108: aload_1
    //   109: ifnull -> 115
    //   112: goto -> 124
    //   115: iload_2
    //   116: iconst_1
    //   117: iadd
    //   118: istore_2
    //   119: goto -> 90
    //   122: aconst_null
    //   123: astore_1
    //   124: aload #7
    //   126: arraylength
    //   127: iconst_1
    //   128: if_icmple -> 186
    //   131: aload #7
    //   133: invokevirtual clone : ()Ljava/lang/Object;
    //   136: checkcast [[B
    //   139: astore #6
    //   141: iconst_0
    //   142: istore_2
    //   143: iload_2
    //   144: aload #6
    //   146: arraylength
    //   147: iconst_1
    //   148: isub
    //   149: if_icmpge -> 186
    //   152: aload #6
    //   154: iload_2
    //   155: getstatic com/bytedance/sdk/a/b/a/h/a.a : [B
    //   158: aastore
    //   159: aload_0
    //   160: getfield g : [B
    //   163: aload #6
    //   165: iload_2
    //   166: invokestatic a : ([B[[BI)Ljava/lang/String;
    //   169: astore #5
    //   171: aload #5
    //   173: ifnull -> 179
    //   176: goto -> 189
    //   179: iload_2
    //   180: iconst_1
    //   181: iadd
    //   182: istore_2
    //   183: goto -> 143
    //   186: aconst_null
    //   187: astore #5
    //   189: aload #5
    //   191: ifnull -> 232
    //   194: iload_3
    //   195: istore_2
    //   196: iload_2
    //   197: aload #7
    //   199: arraylength
    //   200: iconst_1
    //   201: isub
    //   202: if_icmpge -> 232
    //   205: aload_0
    //   206: getfield h : [B
    //   209: aload #7
    //   211: iload_2
    //   212: invokestatic a : ([B[[BI)Ljava/lang/String;
    //   215: astore #6
    //   217: aload #6
    //   219: ifnull -> 225
    //   222: goto -> 235
    //   225: iload_2
    //   226: iconst_1
    //   227: iadd
    //   228: istore_2
    //   229: goto -> 196
    //   232: aconst_null
    //   233: astore #6
    //   235: aload #6
    //   237: ifnull -> 272
    //   240: new java/lang/StringBuilder
    //   243: dup
    //   244: invokespecial <init> : ()V
    //   247: astore_1
    //   248: aload_1
    //   249: ldc '!'
    //   251: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: aload_1
    //   256: aload #6
    //   258: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: aload_1
    //   263: invokevirtual toString : ()Ljava/lang/String;
    //   266: ldc '\.'
    //   268: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   271: areturn
    //   272: aload_1
    //   273: ifnonnull -> 285
    //   276: aload #5
    //   278: ifnonnull -> 285
    //   281: getstatic com/bytedance/sdk/a/b/a/h/a.c : [Ljava/lang/String;
    //   284: areturn
    //   285: aload_1
    //   286: ifnull -> 299
    //   289: aload_1
    //   290: ldc '\.'
    //   292: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   295: astore_1
    //   296: goto -> 303
    //   299: getstatic com/bytedance/sdk/a/b/a/h/a.b : [Ljava/lang/String;
    //   302: astore_1
    //   303: aload #5
    //   305: ifnull -> 320
    //   308: aload #5
    //   310: ldc '\.'
    //   312: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   315: astore #5
    //   317: goto -> 325
    //   320: getstatic com/bytedance/sdk/a/b/a/h/a.b : [Ljava/lang/String;
    //   323: astore #5
    //   325: aload_1
    //   326: arraylength
    //   327: aload #5
    //   329: arraylength
    //   330: if_icmple -> 335
    //   333: aload_1
    //   334: areturn
    //   335: aload #5
    //   337: areturn
    //   338: new java/lang/IllegalStateException
    //   341: dup
    //   342: ldc 'Unable to load publicsuffixes.gz resource from the classpath.'
    //   344: invokespecial <init> : (Ljava/lang/String;)V
    //   347: athrow
    //   348: astore_1
    //   349: aload_0
    //   350: monitorexit
    //   351: aload_1
    //   352: athrow
    //   353: astore #5
    //   355: goto -> 42
    // Exception table:
    //   from	to	target	type
    //   35	42	353	java/lang/InterruptedException
    //   44	53	348	finally
    //   338	348	348	finally
    //   349	351	348	finally
  }
  
  private void b() {
    boolean bool = false;
    while (true) {
      try {
        c();
        return;
      } catch (InterruptedIOException interruptedIOException) {
      
      } catch (IOException iOException) {
        e.b().a(5, "Failed to read public suffix list", iOException);
        return;
      } finally {
        if (bool)
          Thread.currentThread().interrupt(); 
      } 
    } 
  }
  
  private void c() throws IOException {
    // Byte code:
    //   0: ldc com/bytedance/sdk/a/b/a/h/a
    //   2: ldc 'publicsuffixes.gz'
    //   4: invokevirtual getResourceAsStream : (Ljava/lang/String;)Ljava/io/InputStream;
    //   7: astore_1
    //   8: aload_1
    //   9: ifnonnull -> 13
    //   12: return
    //   13: new com/bytedance/sdk/a/a/j
    //   16: dup
    //   17: aload_1
    //   18: invokestatic a : (Ljava/io/InputStream;)Lcom/bytedance/sdk/a/a/s;
    //   21: invokespecial <init> : (Lcom/bytedance/sdk/a/a/s;)V
    //   24: invokestatic a : (Lcom/bytedance/sdk/a/a/s;)Lcom/bytedance/sdk/a/a/e;
    //   27: astore_1
    //   28: aload_1
    //   29: invokeinterface j : ()I
    //   34: newarray byte
    //   36: astore_2
    //   37: aload_1
    //   38: aload_2
    //   39: invokeinterface a : ([B)V
    //   44: aload_1
    //   45: invokeinterface j : ()I
    //   50: newarray byte
    //   52: astore_3
    //   53: aload_1
    //   54: aload_3
    //   55: invokeinterface a : ([B)V
    //   60: aload_1
    //   61: invokestatic a : (Ljava/io/Closeable;)V
    //   64: aload_0
    //   65: monitorenter
    //   66: aload_0
    //   67: aload_2
    //   68: putfield g : [B
    //   71: aload_0
    //   72: aload_3
    //   73: putfield h : [B
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_0
    //   79: getfield f : Ljava/util/concurrent/CountDownLatch;
    //   82: invokevirtual countDown : ()V
    //   85: return
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    //   91: astore_2
    //   92: aload_1
    //   93: invokestatic a : (Ljava/io/Closeable;)V
    //   96: aload_2
    //   97: athrow
    // Exception table:
    //   from	to	target	type
    //   28	60	91	finally
    //   66	78	86	finally
    //   87	89	86	finally
  }
  
  public String a(String paramString) {
    if (paramString != null) {
      int i;
      int j;
      String[] arrayOfString2 = IDN.toUnicode(paramString).split("\\.");
      String[] arrayOfString3 = a(arrayOfString2);
      if (arrayOfString2.length == arrayOfString3.length && arrayOfString3[0].charAt(0) != '!')
        return null; 
      if (arrayOfString3[0].charAt(0) == '!') {
        i = arrayOfString2.length;
        j = arrayOfString3.length;
      } else {
        i = arrayOfString2.length;
        j = arrayOfString3.length + 1;
      } 
      i -= j;
      StringBuilder stringBuilder = new StringBuilder();
      String[] arrayOfString1 = paramString.split("\\.");
      while (i < arrayOfString1.length) {
        stringBuilder.append(arrayOfString1[i]);
        stringBuilder.append('.');
        i++;
      } 
      stringBuilder.deleteCharAt(stringBuilder.length() - 1);
      return stringBuilder.toString();
    } 
    throw new NullPointerException("domain == null");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\a\h\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */