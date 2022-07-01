package com.bytedance.sdk.a.b.a;

import com.bytedance.sdk.a.a.f;
import com.bytedance.sdk.a.a.s;
import com.bytedance.sdk.a.b.ab;
import com.bytedance.sdk.a.b.s;
import com.bytedance.sdk.a.b.z;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public final class c {
  public static final byte[] a = new byte[0];
  
  public static final String[] b = new String[0];
  
  public static final ab c = ab.a(null, a);
  
  public static final z d = z.a(null, a);
  
  public static final Charset e;
  
  public static final Charset f;
  
  public static final TimeZone g;
  
  public static final Comparator<String> h;
  
  private static final f i = f.b("efbbbf");
  
  private static final f j = f.b("feff");
  
  private static final f k = f.b("fffe");
  
  private static final f l = f.b("0000ffff");
  
  private static final f m = f.b("ffff0000");
  
  private static final Charset n;
  
  private static final Charset o;
  
  private static final Charset p;
  
  private static final Charset q;
  
  private static final Pattern r;
  
  static {
    e = Charset.forName("UTF-8");
    f = Charset.forName("ISO-8859-1");
    n = Charset.forName("UTF-16BE");
    o = Charset.forName("UTF-16LE");
    p = Charset.forName("UTF-32BE");
    q = Charset.forName("UTF-32LE");
    g = TimeZone.getTimeZone("GMT");
    h = new Comparator<String>() {
        public int a(String param1String1, String param1String2) {
          return param1String1.compareTo(param1String2);
        }
      };
    r = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
  }
  
  public static int a(char paramChar) {
    if (paramChar >= '0' && paramChar <= '9')
      return paramChar - 48; 
    byte b = 97;
    if (paramChar < 'a' || paramChar > 'f') {
      b = 65;
      if (paramChar < 'A' || paramChar > 'F')
        return -1; 
    } 
    return paramChar - b + 10;
  }
  
  public static int a(String paramString, int paramInt1, int paramInt2) {
    while (paramInt1 < paramInt2) {
      char c1 = paramString.charAt(paramInt1);
      if (c1 != '\t' && c1 != '\n' && c1 != '\f' && c1 != '\r' && c1 != ' ')
        return paramInt1; 
      paramInt1++;
    } 
    return paramInt2;
  }
  
  public static int a(String paramString, int paramInt1, int paramInt2, char paramChar) {
    while (paramInt1 < paramInt2) {
      if (paramString.charAt(paramInt1) == paramChar)
        return paramInt1; 
      paramInt1++;
    } 
    return paramInt2;
  }
  
  public static int a(String paramString1, int paramInt1, int paramInt2, String paramString2) {
    while (paramInt1 < paramInt2) {
      if (paramString2.indexOf(paramString1.charAt(paramInt1)) != -1)
        return paramInt1; 
      paramInt1++;
    } 
    return paramInt2;
  }
  
  public static int a(String paramString, long paramLong, TimeUnit paramTimeUnit) {
    int i = paramLong cmp 0L;
    if (i >= 0) {
      if (paramTimeUnit != null) {
        paramLong = paramTimeUnit.toMillis(paramLong);
        if (paramLong <= 2147483647L) {
          if (paramLong != 0L || i <= 0)
            return (int)paramLong; 
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append(paramString);
          stringBuilder2.append(" too small.");
          throw new IllegalArgumentException(stringBuilder2.toString());
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramString);
        stringBuilder1.append(" too large.");
        throw new IllegalArgumentException(stringBuilder1.toString());
      } 
      throw new NullPointerException("unit == null");
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(" < 0");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public static int a(Comparator<String> paramComparator, String[] paramArrayOfString, String paramString) {
    int j = paramArrayOfString.length;
    for (int i = 0; i < j; i++) {
      if (paramComparator.compare(paramArrayOfString[i], paramString) == 0)
        return i; 
    } 
    return -1;
  }
  
  public static AssertionError a(String paramString, Exception paramException) {
    return (AssertionError)(new AssertionError(paramString)).initCause(paramException);
  }
  
  public static String a(s params, boolean paramBoolean) {
    String str;
    if (params.f().contains(":")) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("[");
      stringBuilder1.append(params.f());
      stringBuilder1.append("]");
      str = stringBuilder1.toString();
    } else {
      str = params.f();
    } 
    if (!paramBoolean) {
      String str1 = str;
      if (params.g() != s.a(params.b())) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str);
        stringBuilder1.append(":");
        stringBuilder1.append(params.g());
        return stringBuilder1.toString();
      } 
      return str1;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append(":");
    stringBuilder.append(params.g());
    return stringBuilder.toString();
  }
  
  public static String a(String paramString) {
    if (paramString.contains(":")) {
      InetAddress inetAddress;
      if (paramString.startsWith("[") && paramString.endsWith("]")) {
        inetAddress = d(paramString, 1, paramString.length() - 1);
      } else {
        inetAddress = d(paramString, 0, paramString.length());
      } 
      if (inetAddress == null)
        return null; 
      byte[] arrayOfByte = inetAddress.getAddress();
      if (arrayOfByte.length == 16)
        return a(arrayOfByte); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Invalid IPv6 address: '");
      stringBuilder.append(paramString);
      stringBuilder.append("'");
      throw new AssertionError(stringBuilder.toString());
    } 
    try {
      paramString = IDN.toASCII(paramString).toLowerCase(Locale.US);
      if (paramString.isEmpty())
        return null; 
      boolean bool = d(paramString);
      return bool ? null : paramString;
    } catch (IllegalArgumentException illegalArgumentException) {
      return null;
    } 
  }
  
  public static String a(String paramString, Object... paramVarArgs) {
    return String.format(Locale.US, paramString, paramVarArgs);
  }
  
  private static String a(byte[] paramArrayOfbyte) {
    boolean bool = false;
    int i = 0;
    int k = -1;
    int j;
    for (j = 0; i < paramArrayOfbyte.length; j = n) {
      int m;
      for (m = i; m < 16 && paramArrayOfbyte[m] == 0 && paramArrayOfbyte[m + 1] == 0; m += 2);
      int i2 = m - i;
      int i1 = k;
      int n = j;
      if (i2 > j) {
        i1 = k;
        n = j;
        if (i2 >= 4) {
          n = i2;
          i1 = i;
        } 
      } 
      i = m + 2;
      k = i1;
    } 
    com.bytedance.sdk.a.a.c c1 = new com.bytedance.sdk.a.a.c();
    for (i = bool; i < paramArrayOfbyte.length; i += 2) {
      if (i == k) {
        c1.b(58);
        int m = i + j;
        i = m;
        if (m == 16) {
          c1.b(58);
          i = m;
        } 
        continue;
      } 
      if (i > 0)
        c1.b(58); 
      c1.j(((paramArrayOfbyte[i] & 0xFF) << 8 | paramArrayOfbyte[i + 1] & 0xFF));
    } 
    return c1.o();
  }
  
  public static <T> List<T> a(List<T> paramList) {
    return Collections.unmodifiableList(new ArrayList<T>(paramList));
  }
  
  public static <T> List<T> a(T... paramVarArgs) {
    return Collections.unmodifiableList(Arrays.asList((T[])paramVarArgs.clone()));
  }
  
  public static ThreadFactory a(String paramString, boolean paramBoolean) {
    return new ThreadFactory(paramString, paramBoolean) {
        public Thread newThread(Runnable param1Runnable) {
          param1Runnable = new Thread(param1Runnable, this.a);
          param1Runnable.setDaemon(this.b);
          return (Thread)param1Runnable;
        }
      };
  }
  
  public static void a(long paramLong1, long paramLong2, long paramLong3) {
    if ((paramLong2 | paramLong3) >= 0L && paramLong2 <= paramLong1 && paramLong1 - paramLong2 >= paramLong3)
      return; 
    throw new ArrayIndexOutOfBoundsException();
  }
  
  public static void a(Closeable paramCloseable) {
    if (paramCloseable != null)
      try {
        paramCloseable.close();
        return;
      } catch (RuntimeException runtimeException) {
        throw runtimeException;
      } catch (Exception exception) {
        return;
      }  
  }
  
  public static void a(Socket paramSocket) {
    if (paramSocket != null)
      try {
        paramSocket.close();
        return;
      } catch (AssertionError assertionError) {
        if (a(assertionError))
          return; 
        throw assertionError;
      } catch (RuntimeException runtimeException) {
        throw runtimeException;
      } catch (Exception exception) {
        return;
      }  
  }
  
  public static boolean a(s params, int paramInt, TimeUnit paramTimeUnit) {
    try {
      return b(params, paramInt, paramTimeUnit);
    } catch (IOException iOException) {
      return false;
    } 
  }
  
  public static boolean a(AssertionError paramAssertionError) {
    return (paramAssertionError.getCause() != null && paramAssertionError.getMessage() != null && paramAssertionError.getMessage().contains("getsockname failed"));
  }
  
  public static boolean a(Object paramObject1, Object paramObject2) {
    return (paramObject1 == paramObject2 || (paramObject1 != null && paramObject1.equals(paramObject2)));
  }
  
  private static boolean a(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfbyte, int paramInt3) {
    int j = paramInt3;
    int i = paramInt1;
    while (i < paramInt2) {
      if (j == paramArrayOfbyte.length)
        return false; 
      paramInt1 = i;
      if (j != paramInt3) {
        if (paramString.charAt(i) != '.')
          return false; 
        paramInt1 = i + 1;
      } 
      i = paramInt1;
      int k = 0;
      while (i < paramInt2) {
        char c1 = paramString.charAt(i);
        if (c1 < '0' || c1 > '9')
          break; 
        if (!k && paramInt1 != i)
          return false; 
        k = k * 10 + c1 - 48;
        if (k > 255)
          return false; 
        i++;
      } 
      if (i - paramInt1 == 0)
        return false; 
      paramArrayOfbyte[j] = (byte)k;
      j++;
    } 
    return !(j != paramInt3 + 4);
  }
  
  public static String[] a(Comparator<? super String> paramComparator, String[] paramArrayOfString1, String[] paramArrayOfString2) {
    ArrayList<String> arrayList = new ArrayList();
    int j = paramArrayOfString1.length;
    for (int i = 0; i < j; i++) {
      String str = paramArrayOfString1[i];
      int m = paramArrayOfString2.length;
      int k;
      for (k = 0; k < m; k++) {
        if (paramComparator.compare(str, paramArrayOfString2[k]) == 0) {
          arrayList.add(str);
          break;
        } 
      } 
    } 
    return arrayList.<String>toArray(new String[arrayList.size()]);
  }
  
  public static String[] a(String[] paramArrayOfString, String paramString) {
    String[] arrayOfString = new String[paramArrayOfString.length + 1];
    System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, paramArrayOfString.length);
    arrayOfString[arrayOfString.length - 1] = paramString;
    return arrayOfString;
  }
  
  public static int b(String paramString) {
    int j = paramString.length();
    int i = 0;
    while (i < j) {
      char c1 = paramString.charAt(i);
      if (c1 > '\037') {
        if (c1 >= '')
          return i; 
        i++;
        continue;
      } 
      return i;
    } 
    return -1;
  }
  
  public static int b(String paramString, int paramInt1, int paramInt2) {
    while (--paramInt2 >= paramInt1) {
      char c1 = paramString.charAt(paramInt2);
      if (c1 != '\t' && c1 != '\n' && c1 != '\f' && c1 != '\r' && c1 != ' ')
        return paramInt2 + 1; 
      paramInt2--;
    } 
    return paramInt1;
  }
  
  public static boolean b(s params, int paramInt, TimeUnit paramTimeUnit) throws IOException {
    long l1;
    long l2 = System.nanoTime();
    if (params.a().ak_()) {
      l1 = params.a().d() - l2;
    } else {
      l1 = Long.MAX_VALUE;
    } 
    params.a().a(Math.min(l1, paramTimeUnit.toNanos(paramInt)) + l2);
    try {
      com.bytedance.sdk.a.a.c c1 = new com.bytedance.sdk.a.a.c();
      while (params.a(c1, 8192L) != -1L)
        c1.r(); 
      if (l1 == Long.MAX_VALUE)
        return true; 
      return true;
    } catch (InterruptedIOException interruptedIOException) {
      if (l1 == Long.MAX_VALUE)
        return false; 
      return false;
    } finally {
      if (l1 == Long.MAX_VALUE) {
        params.a().f();
      } else {
        params.a().a(l2 + l1);
      } 
    } 
  }
  
  public static boolean b(Comparator<String> paramComparator, String[] paramArrayOfString1, String[] paramArrayOfString2) {
    if (paramArrayOfString1 != null && paramArrayOfString2 != null && paramArrayOfString1.length != 0) {
      if (paramArrayOfString2.length == 0)
        return false; 
      int j = paramArrayOfString1.length;
      for (int i = 0; i < j; i++) {
        String str = paramArrayOfString1[i];
        int m = paramArrayOfString2.length;
        int k;
        for (k = 0; k < m; k++) {
          if (paramComparator.compare(str, paramArrayOfString2[k]) == 0)
            return true; 
        } 
      } 
    } 
    return false;
  }
  
  public static String c(String paramString, int paramInt1, int paramInt2) {
    paramInt1 = a(paramString, paramInt1, paramInt2);
    return paramString.substring(paramInt1, b(paramString, paramInt1, paramInt2));
  }
  
  public static boolean c(String paramString) {
    return r.matcher(paramString).matches();
  }
  
  private static InetAddress d(String paramString, int paramInt1, int paramInt2) {
    int k;
    int n;
    byte[] arrayOfByte = new byte[16];
    int i = 0;
    int j = -1;
    int m = -1;
    while (true) {
      k = i;
      n = j;
      if (paramInt1 < paramInt2) {
        if (i == arrayOfByte.length)
          return null; 
        n = paramInt1 + 2;
        if (n <= paramInt2 && paramString.regionMatches(paramInt1, "::", 0, 2)) {
          if (j != -1)
            return null; 
          k = i + 2;
          paramInt1 = k;
          if (n == paramInt2) {
            n = paramInt1;
            break;
          } 
          m = n;
          i = k;
          j = paramInt1;
          paramInt1 = m;
        } else {
          k = paramInt1;
          if (i != 0)
            if (paramString.regionMatches(paramInt1, ":", 0, 1)) {
              k = paramInt1 + 1;
            } else {
              if (paramString.regionMatches(paramInt1, ".", 0, 1)) {
                if (!a(paramString, m, paramInt2, arrayOfByte, i - 2))
                  return null; 
                k = i + 2;
                n = j;
                break;
              } 
              return null;
            }  
          paramInt1 = k;
        } 
        k = paramInt1;
        m = 0;
        while (k < paramInt2) {
          n = a(paramString.charAt(k));
          if (n == -1)
            break; 
          m = (m << 4) + n;
          k++;
        } 
        n = k - paramInt1;
        if (n != 0) {
          if (n > 4)
            return null; 
          n = i + 1;
          arrayOfByte[i] = (byte)(m >>> 8 & 0xFF);
          i = n + 1;
          arrayOfByte[n] = (byte)(m & 0xFF);
          m = paramInt1;
          paramInt1 = k;
          continue;
        } 
        return null;
      } 
      break;
    } 
    if (k != arrayOfByte.length) {
      if (n == -1)
        return null; 
      paramInt1 = arrayOfByte.length;
      paramInt2 = k - n;
      System.arraycopy(arrayOfByte, n, arrayOfByte, paramInt1 - paramInt2, paramInt2);
      Arrays.fill(arrayOfByte, n, arrayOfByte.length - k + n, (byte)0);
    } 
    try {
      return InetAddress.getByAddress(arrayOfByte);
    } catch (UnknownHostException unknownHostException) {
      throw new AssertionError();
    } 
  }
  
  private static boolean d(String paramString) {
    int i = 0;
    while (i < paramString.length()) {
      char c1 = paramString.charAt(i);
      if (c1 > '\037') {
        if (c1 >= '')
          return true; 
        if (" #%/:?@[\\]".indexOf(c1) != -1)
          return true; 
        i++;
        continue;
      } 
      return true;
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */