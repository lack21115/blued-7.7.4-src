package com.huawei.hms.framework.common;

import android.text.TextUtils;
import com.huawei.secure.android.common.util.SafeString;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

public class StringUtils {
  private static final int INIT_CAPACITY = 1024;
  
  private static boolean IS_AEGIS_STRING_LIBRARY_LOADED = false;
  
  private static final String SAFE_STRING_PATH = "com.huawei.secure.android.common.util.SafeString";
  
  private static final String TAG = "StringUtils";
  
  public static String anonymizeMessage(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return paramString; 
    char[] arrayOfChar = paramString.toCharArray();
    for (int i = 0; i < arrayOfChar.length; i++) {
      if (i % 2 != 0)
        arrayOfChar[i] = '*'; 
    } 
    return new String(arrayOfChar);
  }
  
  public static String byte2Str(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null)
      return ""; 
    try {
      return new String(paramArrayOfbyte, "UTF-8");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      Logger.w("StringUtils.byte2str error: UnsupportedEncodingException", unsupportedEncodingException);
      return "";
    } 
  }
  
  private static boolean checkCompatible(String paramString) {
    // Byte code:
    //   0: ldc com/huawei/hms/framework/common/SecurityBase64Utils
    //   2: invokevirtual getClassLoader : ()Ljava/lang/ClassLoader;
    //   5: astore_1
    //   6: aload_1
    //   7: ifnonnull -> 12
    //   10: iconst_0
    //   11: ireturn
    //   12: aload_1
    //   13: aload_0
    //   14: invokevirtual loadClass : (Ljava/lang/String;)Ljava/lang/Class;
    //   17: pop
    //   18: ldc com/huawei/hms/framework/common/StringUtils
    //   20: monitorenter
    //   21: iconst_1
    //   22: putstatic com/huawei/hms/framework/common/StringUtils.IS_AEGIS_STRING_LIBRARY_LOADED : Z
    //   25: ldc com/huawei/hms/framework/common/StringUtils
    //   27: monitorexit
    //   28: iconst_1
    //   29: ireturn
    //   30: astore_0
    //   31: ldc com/huawei/hms/framework/common/StringUtils
    //   33: monitorexit
    //   34: aload_0
    //   35: athrow
    //   36: astore_0
    //   37: iconst_0
    //   38: ireturn
    // Exception table:
    //   from	to	target	type
    //   12	21	36	java/lang/ClassNotFoundException
    //   21	28	30	finally
    //   31	34	30	finally
    //   34	36	36	java/lang/ClassNotFoundException
  }
  
  public static String format(String paramString, Object... paramVarArgs) {
    return (paramString == null) ? "" : String.format(Locale.ROOT, paramString, paramVarArgs);
  }
  
  public static byte[] getBytes(long paramLong) {
    return getBytes(String.valueOf(paramLong));
  }
  
  public static byte[] getBytes(String paramString) {
    byte[] arrayOfByte = new byte[0];
    if (paramString == null)
      return arrayOfByte; 
    try {
      return paramString.getBytes("utf-8");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      Logger.w("StringUtils", "the content has error while it is converted to bytes");
      return arrayOfByte;
    } 
  }
  
  public static String getTraceInfo(Throwable paramThrowable) {
    StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
    StringBuilder stringBuilder = new StringBuilder(1024);
    int j = arrayOfStackTraceElement.length;
    for (int i = 0; i < j; i++) {
      StackTraceElement stackTraceElement = arrayOfStackTraceElement[i];
      stringBuilder.append("at ");
      stringBuilder.append(stackTraceElement.toString());
      stringBuilder.append(";");
    } 
    return stringBuilder.toString();
  }
  
  public static String replace(String paramString, CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
    if (IS_AEGIS_STRING_LIBRARY_LOADED || checkCompatible("com.huawei.secure.android.common.util.SafeString"))
      return SafeString.a(paramString, paramCharSequence1, paramCharSequence2); 
    String str = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      str = paramString;
      if (!TextUtils.isEmpty(paramCharSequence1))
        try {
          return paramString.replace(paramCharSequence1, paramCharSequence2);
        } catch (Exception exception) {
          return paramString;
        }  
    } 
    return str;
  }
  
  public static byte[] str2Byte(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return new byte[0]; 
    try {
      return paramString.getBytes("UTF-8");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      Logger.w("StringUtils.str2Byte error: UnsupportedEncodingException", unsupportedEncodingException);
      return new byte[0];
    } 
  }
  
  public static boolean strEquals(String paramString1, String paramString2) {
    return (paramString1 == paramString2 || (paramString1 != null && paramString1.equals(paramString2)));
  }
  
  public static int stringToInteger(String paramString, int paramInt) {
    if (TextUtils.isEmpty(paramString))
      return paramInt; 
    try {
      return Integer.parseInt(paramString);
    } catch (NumberFormatException numberFormatException) {
      Logger.w("StringUtils", "String to Integer catch NumberFormatException.", numberFormatException);
      return paramInt;
    } 
  }
  
  public static long stringToLong(String paramString, long paramLong) {
    if (TextUtils.isEmpty(paramString))
      return paramLong; 
    try {
      return Long.parseLong(paramString);
    } catch (NumberFormatException numberFormatException) {
      Logger.w("StringUtils", "String to Long catch NumberFormatException.", numberFormatException);
      return paramLong;
    } 
  }
  
  public static String substring(String paramString, int paramInt) {
    if (checkCompatible("com.huawei.secure.android.common.util.SafeString"))
      return SafeString.a(paramString, paramInt); 
    if (!TextUtils.isEmpty(paramString) && paramString.length() >= paramInt && paramInt >= 0)
      try {
        return paramString.substring(paramInt);
      } catch (Exception exception) {
        return "";
      }  
    return "";
  }
  
  public static String substring(String paramString, int paramInt1, int paramInt2) {
    if (IS_AEGIS_STRING_LIBRARY_LOADED || checkCompatible("com.huawei.secure.android.common.util.SafeString"))
      return SafeString.a(paramString, paramInt1, paramInt2); 
    if (!TextUtils.isEmpty(paramString) && paramInt1 >= 0 && paramInt2 <= paramString.length() && paramInt2 >= paramInt1)
      try {
        return paramString.substring(paramInt1, paramInt2);
      } catch (Exception exception) {
        return "";
      }  
    return "";
  }
  
  public static String toLowerCase(String paramString) {
    return (paramString == null) ? paramString : paramString.toLowerCase(Locale.ROOT);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\common\StringUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */