package androidx.core.util;

import java.io.PrintWriter;

public final class TimeUtils {
  public static final int HUNDRED_DAY_FIELD_LEN = 19;
  
  private static final Object a = new Object();
  
  private static char[] b = new char[24];
  
  private static int a(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3) {
    return (paramInt1 > 99 || (paramBoolean && paramInt3 >= 3)) ? (paramInt2 + 3) : ((paramInt1 > 9 || (paramBoolean && paramInt3 >= 2)) ? (paramInt2 + 2) : ((paramBoolean || paramInt1 > 0) ? (paramInt2 + 1) : 0));
  }
  
  private static int a(long paramLong, int paramInt) {
    byte b1;
    int j;
    boolean bool1;
    boolean bool2;
    byte b2;
    boolean bool3;
    if (b.length < paramInt)
      b = new char[paramInt]; 
    char[] arrayOfChar = b;
    int i = paramLong cmp 0L;
    if (i == 0) {
      while (paramInt - 1 > 0)
        arrayOfChar[0] = ' '; 
      arrayOfChar[0] = '0';
      return 1;
    } 
    if (i > 0) {
      b1 = 43;
    } else {
      b1 = 45;
      paramLong = -paramLong;
    } 
    int n = (int)(paramLong % 1000L);
    i = (int)Math.floor((paramLong / 1000L));
    if (i > 86400) {
      k = i / 86400;
      i -= 86400 * k;
    } else {
      k = 0;
    } 
    if (i > 3600) {
      bool1 = i / 3600;
      i -= bool1 * 3600;
    } else {
      bool1 = false;
    } 
    if (i > 60) {
      bool2 = i / 60;
      j = i - bool2 * 60;
    } else {
      bool2 = false;
      j = i;
    } 
    if (paramInt != 0) {
      i = a(k, 1, false, 0);
      if (i > 0) {
        bool3 = true;
      } else {
        bool3 = false;
      } 
      i += a(bool1, 1, bool3, 2);
      if (i > 0) {
        bool3 = true;
      } else {
        bool3 = false;
      } 
      i += a(bool2, 1, bool3, 2);
      if (i > 0) {
        bool3 = true;
      } else {
        bool3 = false;
      } 
      int i1 = i + a(j, 1, bool3, 2);
      if (i1 > 0) {
        i = 3;
      } else {
        i = 0;
      } 
      i1 += a(n, 2, true, i) + 1;
      i = 0;
      while (true) {
        b2 = i;
        if (i1 < paramInt) {
          arrayOfChar[i] = ' ';
          i++;
          i1++;
          continue;
        } 
        break;
      } 
    } else {
      b2 = 0;
    } 
    arrayOfChar[b2] = b1;
    int m = b2 + 1;
    if (paramInt != 0) {
      paramInt = 1;
    } else {
      paramInt = 0;
    } 
    int k = a(arrayOfChar, k, 'd', m, false, 0);
    if (k != m) {
      bool3 = true;
    } else {
      bool3 = false;
    } 
    if (paramInt != 0) {
      i = 2;
    } else {
      i = 0;
    } 
    k = a(arrayOfChar, bool1, 'h', k, bool3, i);
    if (k != m) {
      bool3 = true;
    } else {
      bool3 = false;
    } 
    if (paramInt != 0) {
      i = 2;
    } else {
      i = 0;
    } 
    k = a(arrayOfChar, bool2, 'm', k, bool3, i);
    if (k != m) {
      bool3 = true;
    } else {
      bool3 = false;
    } 
    if (paramInt != 0) {
      i = 2;
    } else {
      i = 0;
    } 
    i = a(arrayOfChar, j, 's', k, bool3, i);
    if (paramInt != 0 && i != m) {
      paramInt = 3;
    } else {
      paramInt = 0;
    } 
    paramInt = a(arrayOfChar, n, 'm', i, true, paramInt);
    arrayOfChar[paramInt] = 's';
    return paramInt + 1;
  }
  
  private static int a(char[] paramArrayOfchar, int paramInt1, char paramChar, int paramInt2, boolean paramBoolean, int paramInt3) {
    // Byte code:
    //   0: iload #4
    //   2: ifne -> 12
    //   5: iload_3
    //   6: istore #6
    //   8: iload_1
    //   9: ifle -> 145
    //   12: iload #4
    //   14: ifeq -> 23
    //   17: iload #5
    //   19: iconst_3
    //   20: if_icmpge -> 29
    //   23: iload_1
    //   24: bipush #99
    //   26: if_icmple -> 60
    //   29: iload_1
    //   30: bipush #100
    //   32: idiv
    //   33: istore #7
    //   35: aload_0
    //   36: iload_3
    //   37: iload #7
    //   39: bipush #48
    //   41: iadd
    //   42: i2c
    //   43: castore
    //   44: iload_3
    //   45: iconst_1
    //   46: iadd
    //   47: istore #6
    //   49: iload_1
    //   50: iload #7
    //   52: bipush #100
    //   54: imul
    //   55: isub
    //   56: istore_1
    //   57: goto -> 63
    //   60: iload_3
    //   61: istore #6
    //   63: iload #4
    //   65: ifeq -> 74
    //   68: iload #5
    //   70: iconst_2
    //   71: if_icmpge -> 93
    //   74: iload_1
    //   75: bipush #9
    //   77: if_icmpgt -> 93
    //   80: iload #6
    //   82: istore #7
    //   84: iload_1
    //   85: istore #5
    //   87: iload_3
    //   88: iload #6
    //   90: if_icmpeq -> 121
    //   93: iload_1
    //   94: bipush #10
    //   96: idiv
    //   97: istore_3
    //   98: aload_0
    //   99: iload #6
    //   101: iload_3
    //   102: bipush #48
    //   104: iadd
    //   105: i2c
    //   106: castore
    //   107: iload #6
    //   109: iconst_1
    //   110: iadd
    //   111: istore #7
    //   113: iload_1
    //   114: iload_3
    //   115: bipush #10
    //   117: imul
    //   118: isub
    //   119: istore #5
    //   121: aload_0
    //   122: iload #7
    //   124: iload #5
    //   126: bipush #48
    //   128: iadd
    //   129: i2c
    //   130: castore
    //   131: iload #7
    //   133: iconst_1
    //   134: iadd
    //   135: istore_1
    //   136: aload_0
    //   137: iload_1
    //   138: iload_2
    //   139: castore
    //   140: iload_1
    //   141: iconst_1
    //   142: iadd
    //   143: istore #6
    //   145: iload #6
    //   147: ireturn
  }
  
  public static void formatDuration(long paramLong1, long paramLong2, PrintWriter paramPrintWriter) {
    if (paramLong1 == 0L) {
      paramPrintWriter.print("--");
      return;
    } 
    formatDuration(paramLong1 - paramLong2, paramPrintWriter, 0);
  }
  
  public static void formatDuration(long paramLong, PrintWriter paramPrintWriter) {
    formatDuration(paramLong, paramPrintWriter, 0);
  }
  
  public static void formatDuration(long paramLong, PrintWriter paramPrintWriter, int paramInt) {
    synchronized (a) {
      paramInt = a(paramLong, paramInt);
      paramPrintWriter.print(new String(b, 0, paramInt));
      return;
    } 
  }
  
  public static void formatDuration(long paramLong, StringBuilder paramStringBuilder) {
    synchronized (a) {
      int i = a(paramLong, 0);
      paramStringBuilder.append(b, 0, i);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\cor\\util\TimeUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */