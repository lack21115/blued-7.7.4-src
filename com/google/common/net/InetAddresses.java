package com.google.common.net;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class InetAddresses {
  private static final Splitter a = Splitter.a('.').a(4);
  
  private static final Splitter b = Splitter.a(':').a(10);
  
  private static final Inet4Address c = (Inet4Address)a("127.0.0.1");
  
  private static final Inet4Address d = (Inet4Address)a("0.0.0.0");
  
  private static IllegalArgumentException a(String paramString, Object... paramVarArgs) {
    return new IllegalArgumentException(String.format(Locale.ROOT, paramString, paramVarArgs));
  }
  
  public static InetAddress a(String paramString) {
    byte[] arrayOfByte = b(paramString);
    if (arrayOfByte != null)
      return a(arrayOfByte); 
    throw a("'%s' is not an IP string literal.", new Object[] { paramString });
  }
  
  private static InetAddress a(byte[] paramArrayOfbyte) {
    try {
      return InetAddress.getByAddress(paramArrayOfbyte);
    } catch (UnknownHostException unknownHostException) {
      throw new AssertionError(unknownHostException);
    } 
  }
  
  @NullableDecl
  private static byte[] b(String paramString) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore #4
    //   5: iconst_0
    //   6: istore_3
    //   7: iload_2
    //   8: aload_0
    //   9: invokevirtual length : ()I
    //   12: if_icmpge -> 79
    //   15: aload_0
    //   16: iload_2
    //   17: invokevirtual charAt : (I)C
    //   20: istore_1
    //   21: iload_1
    //   22: bipush #46
    //   24: if_icmpne -> 33
    //   27: iconst_1
    //   28: istore #4
    //   30: goto -> 72
    //   33: iload_1
    //   34: bipush #58
    //   36: if_icmpne -> 51
    //   39: iload #4
    //   41: ifeq -> 46
    //   44: aconst_null
    //   45: areturn
    //   46: iconst_1
    //   47: istore_3
    //   48: goto -> 72
    //   51: iload_1
    //   52: bipush #37
    //   54: if_icmpne -> 60
    //   57: goto -> 81
    //   60: iload_1
    //   61: bipush #16
    //   63: invokestatic digit : (CI)I
    //   66: iconst_m1
    //   67: if_icmpne -> 72
    //   70: aconst_null
    //   71: areturn
    //   72: iload_2
    //   73: iconst_1
    //   74: iadd
    //   75: istore_2
    //   76: goto -> 7
    //   79: iconst_m1
    //   80: istore_2
    //   81: iload_3
    //   82: ifeq -> 128
    //   85: aload_0
    //   86: astore #5
    //   88: iload #4
    //   90: ifeq -> 107
    //   93: aload_0
    //   94: invokestatic e : (Ljava/lang/String;)Ljava/lang/String;
    //   97: astore_0
    //   98: aload_0
    //   99: astore #5
    //   101: aload_0
    //   102: ifnonnull -> 107
    //   105: aconst_null
    //   106: areturn
    //   107: aload #5
    //   109: astore_0
    //   110: iload_2
    //   111: iconst_m1
    //   112: if_icmpeq -> 123
    //   115: aload #5
    //   117: iconst_0
    //   118: iload_2
    //   119: invokevirtual substring : (II)Ljava/lang/String;
    //   122: astore_0
    //   123: aload_0
    //   124: invokestatic d : (Ljava/lang/String;)[B
    //   127: areturn
    //   128: iload #4
    //   130: ifeq -> 138
    //   133: aload_0
    //   134: invokestatic c : (Ljava/lang/String;)[B
    //   137: areturn
    //   138: aconst_null
    //   139: areturn
  }
  
  @NullableDecl
  private static byte[] c(String paramString) {
    byte[] arrayOfByte = new byte[4];
    try {
      Iterator iterator = a.a(paramString).iterator();
      int i;
      for (i = 0; iterator.hasNext(); i++)
        arrayOfByte[i] = f((String)iterator.next()); 
      return (i == 4) ? arrayOfByte : null;
    } catch (NumberFormatException numberFormatException) {
      return null;
    } 
  }
  
  @NullableDecl
  private static byte[] d(String paramString) {
    List<String> list = b.b(paramString);
    if (list.size() >= 3) {
      int k;
      if (list.size() > 9)
        return null; 
      int i = 1;
      int j;
      for (j = -1; i < list.size() - 1; j = n) {
        int n = j;
        if (((String)list.get(i)).length() == 0) {
          if (j >= 0)
            return null; 
          n = i;
        } 
        i++;
      } 
      if (j >= 0) {
        int n;
        int i1 = list.size() - j - 1;
        if (((String)list.get(0)).length() == 0) {
          i = j - 1;
          n = i;
          if (i != 0)
            return null; 
        } else {
          n = j;
        } 
        i = i1;
        k = n;
        if (((String)Iterables.c(list)).length() == 0) {
          i = --i1;
          k = n;
          if (i1 != 0)
            return null; 
        } 
      } else {
        k = list.size();
        i = 0;
      } 
      int m = 8 - k + i;
      if ((j >= 0) ? (m >= 1) : (m == 0)) {
        int n;
        ByteBuffer byteBuffer = ByteBuffer.allocate(16);
        j = 0;
        while (j < k) {
          try {
            byteBuffer.putShort(g(list.get(j)));
            j++;
          } catch (NumberFormatException numberFormatException) {
            return null;
          } 
        } 
        j = 0;
        while (true) {
          n = i;
          if (j < m) {
            byteBuffer.putShort((short)0);
            j++;
            continue;
          } 
          break;
        } 
        while (n > 0) {
          byteBuffer.putShort(g(numberFormatException.get(numberFormatException.size() - n)));
          n--;
        } 
        return byteBuffer.array();
      } 
      return null;
    } 
    return null;
  }
  
  @NullableDecl
  private static String e(String paramString) {
    int i = paramString.lastIndexOf(':') + 1;
    String str1 = paramString.substring(0, i);
    byte[] arrayOfByte = c(paramString.substring(i));
    if (arrayOfByte == null)
      return null; 
    paramString = Integer.toHexString((arrayOfByte[0] & 0xFF) << 8 | arrayOfByte[1] & 0xFF);
    i = arrayOfByte[2];
    String str2 = Integer.toHexString(arrayOfByte[3] & 0xFF | (i & 0xFF) << 8);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str1);
    stringBuilder.append(paramString);
    stringBuilder.append(":");
    stringBuilder.append(str2);
    return stringBuilder.toString();
  }
  
  private static byte f(String paramString) {
    int i = Integer.parseInt(paramString);
    if (i <= 255 && (!paramString.startsWith("0") || paramString.length() <= 1))
      return (byte)i; 
    throw new NumberFormatException();
  }
  
  private static short g(String paramString) {
    int i = Integer.parseInt(paramString, 16);
    if (i <= 65535)
      return (short)i; 
    throw new NumberFormatException();
  }
  
  public static final class TeredoInfo {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\net\InetAddresses.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */