package com.ishumei.l111l11111Il;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.ishumei.l1111l111111Il.l111l1111llIl;
import com.ishumei.l111l1111llIl.l111l1111lI1l;
import com.ishumei.l111l1111llIl.l111l1111lIl;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public final class l111l1111l1Il {
  private static final int l1111l111111Il = -1;
  
  private static final FileFilter l111l11111lIl = new FileFilter() {
      public final boolean accept(File param1File) {
        String str = param1File.getName();
        try {
          if (str.startsWith(l111l1111lI1l.l111l11111Il("9c8f8a"))) {
            for (int i = 3; i < str.length(); i++) {
              boolean bool = Character.isDigit(str.charAt(i));
              if (!bool)
                return false; 
            } 
            return true;
          } 
          return false;
        } catch (Exception exception) {
          return false;
        } 
      }
    };
  
  private static int l1111l111111Il(String paramString) {
    BufferedReader bufferedReader;
    byte b2 = -1;
    Exception exception = null;
    String str = null;
    try {
    
    } catch (IOException iOException) {
    
    } finally {
      paramString = null;
      l111l1111lIl.l1111l111111Il(bufferedReader);
      l111l1111lIl.l1111l111111Il((Closeable)paramString);
    } 
    l111l1111lIl.l1111l111111Il((Closeable)SYNTHETIC_LOCAL_VARIABLE_3);
    byte b1 = b2;
    l111l1111lIl.l1111l111111Il((Closeable)paramString);
    return b1;
  }
  
  private static int l1111l111111Il(String paramString, FileInputStream paramFileInputStream) {
    // Byte code:
    //   0: sipush #1024
    //   3: newarray byte
    //   5: astore #7
    //   7: aload_1
    //   8: aload #7
    //   10: invokevirtual read : ([B)I
    //   13: istore #5
    //   15: iconst_0
    //   16: istore_3
    //   17: goto -> 164
    //   20: iload_2
    //   21: istore #4
    //   23: iload_3
    //   24: iload #5
    //   26: if_icmpge -> 151
    //   29: iload_3
    //   30: iload_2
    //   31: isub
    //   32: istore #6
    //   34: iload_2
    //   35: istore #4
    //   37: aload #7
    //   39: iload_3
    //   40: baload
    //   41: aload_0
    //   42: iload #6
    //   44: invokevirtual charAt : (I)C
    //   47: if_icmpne -> 151
    //   50: iload #6
    //   52: aload_0
    //   53: invokevirtual length : ()I
    //   56: iconst_1
    //   57: isub
    //   58: if_icmpne -> 144
    //   61: iload_3
    //   62: sipush #1024
    //   65: if_icmpge -> 142
    //   68: aload #7
    //   70: iload_3
    //   71: baload
    //   72: bipush #10
    //   74: if_icmpeq -> 142
    //   77: aload #7
    //   79: iload_3
    //   80: baload
    //   81: invokestatic isDigit : (I)Z
    //   84: ifeq -> 135
    //   87: iload_3
    //   88: iconst_1
    //   89: iadd
    //   90: istore_2
    //   91: iload_2
    //   92: sipush #1024
    //   95: if_icmpge -> 115
    //   98: aload #7
    //   100: iload_2
    //   101: baload
    //   102: invokestatic isDigit : (I)Z
    //   105: ifeq -> 115
    //   108: iload_2
    //   109: iconst_1
    //   110: iadd
    //   111: istore_2
    //   112: goto -> 91
    //   115: new java/lang/String
    //   118: dup
    //   119: aload #7
    //   121: iconst_0
    //   122: iload_3
    //   123: iload_2
    //   124: iload_3
    //   125: isub
    //   126: invokespecial <init> : ([BIII)V
    //   129: invokestatic parseInt : (Ljava/lang/String;)I
    //   132: istore_2
    //   133: iload_2
    //   134: ireturn
    //   135: iload_3
    //   136: iconst_1
    //   137: iadd
    //   138: istore_3
    //   139: goto -> 61
    //   142: iconst_m1
    //   143: ireturn
    //   144: iload_3
    //   145: iconst_1
    //   146: iadd
    //   147: istore_3
    //   148: goto -> 20
    //   151: iload #4
    //   153: iconst_1
    //   154: iadd
    //   155: istore_3
    //   156: goto -> 164
    //   159: iconst_m1
    //   160: ireturn
    //   161: astore_0
    //   162: iconst_m1
    //   163: ireturn
    //   164: iload_3
    //   165: iload #5
    //   167: if_icmpge -> 159
    //   170: aload #7
    //   172: iload_3
    //   173: baload
    //   174: bipush #10
    //   176: if_icmpeq -> 186
    //   179: iload_3
    //   180: istore #4
    //   182: iload_3
    //   183: ifne -> 151
    //   186: iload_3
    //   187: istore_2
    //   188: aload #7
    //   190: iload_3
    //   191: baload
    //   192: bipush #10
    //   194: if_icmpne -> 201
    //   197: iload_3
    //   198: iconst_1
    //   199: iadd
    //   200: istore_2
    //   201: iload_2
    //   202: istore_3
    //   203: goto -> 20
    // Exception table:
    //   from	to	target	type
    //   7	15	161	java/io/IOException
    //   7	15	161	java/lang/NumberFormatException
    //   37	61	161	java/io/IOException
    //   37	61	161	java/lang/NumberFormatException
    //   77	87	161	java/io/IOException
    //   77	87	161	java/lang/NumberFormatException
    //   98	108	161	java/io/IOException
    //   98	108	161	java/lang/NumberFormatException
    //   115	133	161	java/io/IOException
    //   115	133	161	java/lang/NumberFormatException
  }
  
  private static int l1111l111111Il(byte[] paramArrayOfbyte, int paramInt) {
    while (paramInt < 1024 && paramArrayOfbyte[paramInt] != 10) {
      if (Character.isDigit(paramArrayOfbyte[paramInt])) {
        int i;
        for (i = paramInt + 1; i < 1024 && Character.isDigit(paramArrayOfbyte[i]); i++);
        return Integer.parseInt(new String(paramArrayOfbyte, 0, paramInt, i - paramInt));
      } 
      paramInt++;
    } 
    return -1;
  }
  
  public static l1111l111111Il l1111l111111Il() {
    l1111l111111Il l1111l111111Il = new l1111l111111Il();
    try {
      Iterator<String> iterator = l111l1111lIl.l111l11111I1l(l111l1111lI1l.l111l11111Il("d08f8d909cd09c8f8a96919990")).iterator();
      while (iterator.hasNext()) {
        String[] arrayOfString = ((String)iterator.next()).split(":");
        if (2 == arrayOfString.length) {
          String str1 = arrayOfString[0].trim();
          String str2 = arrayOfString[1].trim();
          if (TextUtils.equals(l111l1111lI1l.l111l11111Il("af8d909c9a8c8c908d"), str1) || TextUtils.equals(l111l1111lI1l.l111l11111Il("92909b9a93df919e929a"), str1))
            l1111l111111Il.l1111l111111Il = str2; 
        } 
      } 
      return l1111l111111Il;
    } catch (Exception exception) {
      return l1111l111111Il;
    } 
  }
  
  public static int l111l11111I1l() {
    try {
      int k = l111l11111lIl();
      int j = 0;
      int i = -1;
      while (true) {
        if (j < k) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(l111l1111lI1l.l111l11111Il("d08c868cd09b9a89969c9a8cd08c868c8b9a92d09c8f8ad09c8f8a"));
          stringBuilder.append(j);
          stringBuilder.append(l111l1111lI1l.l111l11111Il("d09c8f8a998d9a8ed09c8f8a96919990a0929e87a0998d9a8e"));
          File file = new File(stringBuilder.toString());
          int m = i;
          if (file.exists()) {
            null = new byte[128];
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
              fileInputStream.read(null);
              for (m = 0; m < 128 && Character.isDigit(null[m]); m++);
              Integer integer = Integer.valueOf(Integer.parseInt(new String(null, 0, m)));
              m = i;
            } catch (NumberFormatException numberFormatException) {
            
            } finally {
              l111l1111lIl.l1111l111111Il(fileInputStream);
            } 
            l111l1111lIl.l1111l111111Il(fileInputStream);
          } 
          j++;
          i = m;
          continue;
        } 
        if (i == -1) {
          Exception exception1;
          Exception exception2 = null;
          try {
          
          } finally {
            Exception exception = null;
            exception1 = exception2;
          } 
          l111l1111lIl.l1111l111111Il((Closeable)exception1);
          throw exception2;
        } 
        return i;
      } 
    } catch (Exception exception) {
      return -1;
    } 
  }
  
  public static long l111l11111Il() {
    Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
    if (context != null)
      if (Build.VERSION.SDK_INT >= 16) {
        try {
          ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
          ((ActivityManager)context.getSystemService("activity")).getMemoryInfo(memoryInfo);
          return memoryInfo.totalMem;
        } catch (Exception exception) {}
      } else {
        Exception exception1;
        long l2 = -1L;
        Exception exception2 = null;
        try {
        
        } finally {
          Exception exception = null;
          exception1 = exception2;
        } 
        long l1 = l2;
        l111l1111lIl.l1111l111111Il((Closeable)exception1);
        l1 = l2;
        throw exception2;
      }  
    return 0L;
  }
  
  public static int l111l11111lIl() {
    try {
      int j = l1111l111111Il(l111l1111lI1l.l111l11111Il("d08c868cd09b9a89969c9a8cd08c868c8b9a92d09c8f8ad08f908c8c969d939a"));
      int i = j;
      if (j == -1)
        i = l1111l111111Il(l111l1111lI1l.l111l11111Il("d08c868cd09b9a89969c9a8cd08c868c8b9a92d09c8f8ad08f8d9a8c9a918b")); 
      return (i == -1) ? l111l1111l1Il() : i;
    } catch (SecurityException|Exception securityException) {
      return -1;
    } 
  }
  
  private static int l111l11111lIl(String paramString) {
    return (paramString == null || !paramString.matches("0-[\\d]+$")) ? -1 : (Integer.parseInt(paramString.substring(2)) + 1);
  }
  
  private static int l111l1111l1Il() {
    try {
      return ((new File(l111l1111lI1l.l111l11111Il("d08c868cd09b9a89969c9a8cd08c868c8b9a92d09c8f8ad08f908c8c969d939a"))).listFiles(l111l11111lIl)).length;
    } catch (Exception exception) {
      return 0;
    } 
  }
  
  public static final class l1111l111111Il {
    public String l1111l111111Il = "";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\l111l11111Il\l111l1111l1Il.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */