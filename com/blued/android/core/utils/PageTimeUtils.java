package com.blued.android.core.utils;

import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.statistics.BluedStatistics;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

public class PageTimeUtils {
  private static final String a = PageTimeUtils.class.getSimpleName();
  
  private static final Map<String, Long> b = new HashMap<String, Long>();
  
  private static Map<String, String> c = new HashMap<String, String>();
  
  public static String a(APMInterface paramAPMInterface, String paramString) {
    String str2 = paramAPMInterface.X_();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      Map<String, String> map = c;
      if (map != null && !map.isEmpty() && c.containsKey(paramString))
        return (c.get(paramString) != null) ? (TextUtils.isEmpty(c.get(paramString)) ? paramString : c.get(paramString)) : paramString; 
      str1 = paramString;
    } 
    return str1;
  }
  
  public static void a(APMInterface paramAPMInterface) {
    if (a(paramAPMInterface))
      try {
        String str = Integer.toHexString(paramAPMInterface.hashCode());
        if (!b.containsKey(str)) {
          b.put(str, Long.valueOf(System.currentTimeMillis()));
          if (AppInfo.m()) {
            String str2 = paramAPMInterface.X_();
            String str1 = str2;
            if (TextUtils.isEmpty(str2))
              str1 = d(paramAPMInterface.getClass().getSimpleName()); 
            a(new Object[] { str1, str, "start" });
            return;
          } 
        } 
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  public static void a(String paramString) {
    c = c(paramString);
  }
  
  private static void a(Object... paramVarArgs) {
    if (AppInfo.m()) {
      StringBuilder stringBuilder = new StringBuilder();
      int j = paramVarArgs.length;
      for (int i = 0; i < j; i++) {
        stringBuilder.append(paramVarArgs[i]);
        stringBuilder.append("  ");
      } 
      Log.b(a, stringBuilder.toString());
    } 
  }
  
  private static boolean a(Object paramObject) {
    if (paramObject != null && !TextUtils.isEmpty(paramObject.getClass().getSimpleName()))
      return true; 
    a(new Object[] { "object or getSimpleName() is null" });
    return false;
  }
  
  public static String b(String paramString) {
    // Byte code:
    //   0: invokestatic d : ()Landroid/content/Context;
    //   3: invokevirtual getAssets : ()Landroid/content/res/AssetManager;
    //   6: aload_0
    //   7: invokevirtual open : (Ljava/lang/String;)Ljava/io/InputStream;
    //   10: astore_1
    //   11: new java/io/BufferedReader
    //   14: dup
    //   15: new java/io/InputStreamReader
    //   18: dup
    //   19: aload_1
    //   20: ldc 'UTF-8'
    //   22: invokespecial <init> : (Ljava/io/InputStream;Ljava/lang/String;)V
    //   25: invokespecial <init> : (Ljava/io/Reader;)V
    //   28: astore_0
    //   29: aload_0
    //   30: astore_2
    //   31: aload_1
    //   32: astore_3
    //   33: new java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial <init> : ()V
    //   40: astore #4
    //   42: aload_0
    //   43: astore_2
    //   44: aload_1
    //   45: astore_3
    //   46: aload_0
    //   47: invokevirtual readLine : ()Ljava/lang/String;
    //   50: astore #5
    //   52: aload #5
    //   54: ifnull -> 72
    //   57: aload_0
    //   58: astore_2
    //   59: aload_1
    //   60: astore_3
    //   61: aload #4
    //   63: aload #5
    //   65: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: goto -> 42
    //   72: aload_0
    //   73: astore_2
    //   74: aload_1
    //   75: astore_3
    //   76: aload #4
    //   78: invokevirtual toString : ()Ljava/lang/String;
    //   81: astore #4
    //   83: aload_1
    //   84: ifnull -> 94
    //   87: aload_1
    //   88: invokevirtual close : ()V
    //   91: goto -> 94
    //   94: aload_0
    //   95: invokevirtual close : ()V
    //   98: aload #4
    //   100: areturn
    //   101: aload_0
    //   102: invokevirtual printStackTrace : ()V
    //   105: aload #4
    //   107: areturn
    //   108: astore #4
    //   110: goto -> 140
    //   113: astore_0
    //   114: aconst_null
    //   115: astore_2
    //   116: goto -> 181
    //   119: astore #4
    //   121: aconst_null
    //   122: astore_0
    //   123: goto -> 140
    //   126: astore_0
    //   127: aconst_null
    //   128: astore_2
    //   129: aload_2
    //   130: astore_1
    //   131: goto -> 181
    //   134: astore #4
    //   136: aconst_null
    //   137: astore_0
    //   138: aload_0
    //   139: astore_1
    //   140: aload_0
    //   141: astore_2
    //   142: aload_1
    //   143: astore_3
    //   144: aload #4
    //   146: invokevirtual printStackTrace : ()V
    //   149: aload_1
    //   150: ifnull -> 160
    //   153: aload_1
    //   154: invokevirtual close : ()V
    //   157: goto -> 160
    //   160: aload_0
    //   161: ifnull -> 175
    //   164: aload_0
    //   165: invokevirtual close : ()V
    //   168: goto -> 175
    //   171: aload_0
    //   172: invokevirtual printStackTrace : ()V
    //   175: ldc ''
    //   177: areturn
    //   178: astore_0
    //   179: aload_3
    //   180: astore_1
    //   181: aload_1
    //   182: ifnull -> 192
    //   185: aload_1
    //   186: invokevirtual close : ()V
    //   189: goto -> 192
    //   192: aload_2
    //   193: ifnull -> 207
    //   196: aload_2
    //   197: invokevirtual close : ()V
    //   200: goto -> 207
    //   203: aload_1
    //   204: invokevirtual printStackTrace : ()V
    //   207: aload_0
    //   208: athrow
    //   209: astore_0
    //   210: goto -> 101
    //   213: astore_0
    //   214: goto -> 171
    //   217: astore_1
    //   218: goto -> 203
    // Exception table:
    //   from	to	target	type
    //   0	11	134	java/io/IOException
    //   0	11	126	finally
    //   11	29	119	java/io/IOException
    //   11	29	113	finally
    //   33	42	108	java/io/IOException
    //   33	42	178	finally
    //   46	52	108	java/io/IOException
    //   46	52	178	finally
    //   61	69	108	java/io/IOException
    //   61	69	178	finally
    //   76	83	108	java/io/IOException
    //   76	83	178	finally
    //   87	91	209	java/io/IOException
    //   94	98	209	java/io/IOException
    //   144	149	178	finally
    //   153	157	213	java/io/IOException
    //   164	168	213	java/io/IOException
    //   185	189	217	java/io/IOException
    //   196	200	217	java/io/IOException
  }
  
  public static void b(APMInterface paramAPMInterface) {
    if (a(paramAPMInterface)) {
      String str = Integer.toHexString(paramAPMInterface.hashCode());
      if (b.containsKey(str)) {
        Long long_ = b.get(str);
        if (long_.longValue() > 0L) {
          b.remove(str);
          long l = System.currentTimeMillis() - long_.longValue();
          if (l >= 86400000L)
            return; 
          try {
            String str2 = paramAPMInterface.X_();
            String str1 = str2;
            if (TextUtils.isEmpty(str2))
              str1 = d(paramAPMInterface.getClass().getSimpleName()); 
            BluedStatistics.d().a(str1, str, l);
            if (AppInfo.m()) {
              a(new Object[] { str1, str, "end", Long.valueOf(l) });
              return;
            } 
          } catch (Exception exception) {
            exception.printStackTrace();
            return;
          } 
        } 
      } else {
        a(new Object[] { exception.getClass().getSimpleName(), str, "mObjectRecord Don't contain" });
      } 
    } 
  }
  
  public static Map<String, String> c(String paramString) {
    paramString = b(paramString);
    return (Map<String, String>)(new Gson()).fromJson(paramString, Map.class);
  }
  
  public static String d(String paramString) {
    Map<String, String> map = c;
    String str = paramString;
    if (map != null) {
      str = paramString;
      if (!map.isEmpty()) {
        str = paramString;
        if (c.containsKey(paramString)) {
          str = paramString;
          if (c.get(paramString) != null) {
            if (TextUtils.isEmpty(c.get(paramString)))
              return paramString; 
            str = c.get(paramString);
          } 
        } 
      } 
    } 
    return str;
  }
  
  public static interface APMInterface {
    String X_();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\cor\\utils\PageTimeUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */