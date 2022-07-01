package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.text.TextUtils;
import java.security.PrivilegedAction;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class v {
  private static volatile v c;
  
  private Map<String, String> a;
  
  private volatile boolean b = false;
  
  private Context d;
  
  private v(Context paramContext) {
    if (paramContext != null && this.d == null) {
      this.d = paramContext.getApplicationContext();
      a();
    } 
    this.d = paramContext;
  }
  
  static v a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/openadsdk/utils/v.c : Lcom/bytedance/sdk/openadsdk/utils/v;
    //   3: ifnonnull -> 38
    //   6: ldc com/bytedance/sdk/openadsdk/utils/v
    //   8: monitorenter
    //   9: getstatic com/bytedance/sdk/openadsdk/utils/v.c : Lcom/bytedance/sdk/openadsdk/utils/v;
    //   12: ifnonnull -> 26
    //   15: new com/bytedance/sdk/openadsdk/utils/v
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Landroid/content/Context;)V
    //   23: putstatic com/bytedance/sdk/openadsdk/utils/v.c : Lcom/bytedance/sdk/openadsdk/utils/v;
    //   26: ldc com/bytedance/sdk/openadsdk/utils/v
    //   28: monitorexit
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc com/bytedance/sdk/openadsdk/utils/v
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic com/bytedance/sdk/openadsdk/utils/v.c : Lcom/bytedance/sdk/openadsdk/utils/v;
    //   41: areturn
    // Exception table:
    //   from	to	target	type
    //   9	26	32	finally
    //   26	29	32	finally
    //   33	36	32	finally
  }
  
  public static String a(Context paramContext, String paramString) {
    String str = paramString;
    if (paramString != null) {
      str = paramString;
      String str1 = paramString;
      try {
      
      } finally {
        paramString = null;
      } 
    } 
    return a(paramContext).a(str);
  }
  
  private void a() {
    // Byte code:
    //   0: aload_0
    //   1: getfield d : Landroid/content/Context;
    //   4: ifnonnull -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield b : Z
    //   12: ifne -> 174
    //   15: aload_0
    //   16: monitorenter
    //   17: aload_0
    //   18: getfield b : Z
    //   21: ifne -> 166
    //   24: new com/bytedance/sdk/openadsdk/utils/v$1
    //   27: dup
    //   28: aload_0
    //   29: invokespecial <init> : (Lcom/bytedance/sdk/openadsdk/utils/v;)V
    //   32: invokestatic doPrivileged : (Ljava/security/PrivilegedAction;)Ljava/lang/Object;
    //   35: checkcast java/util/List
    //   38: astore_2
    //   39: aload_0
    //   40: new java/util/HashMap
    //   43: dup
    //   44: aload_2
    //   45: invokeinterface size : ()I
    //   50: invokespecial <init> : (I)V
    //   53: putfield a : Ljava/util/Map;
    //   56: ldc ''
    //   58: astore_1
    //   59: aload_2
    //   60: invokeinterface iterator : ()Ljava/util/Iterator;
    //   65: astore_2
    //   66: aload_2
    //   67: invokeinterface hasNext : ()Z
    //   72: ifeq -> 149
    //   75: aload_2
    //   76: invokeinterface next : ()Ljava/lang/Object;
    //   81: checkcast java/lang/String
    //   84: astore_3
    //   85: new java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial <init> : ()V
    //   92: astore #4
    //   94: aload #4
    //   96: aload_1
    //   97: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload #4
    //   103: aload_3
    //   104: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload #4
    //   110: invokevirtual toString : ()Ljava/lang/String;
    //   113: astore_1
    //   114: aload_1
    //   115: ldc '\'
    //   117: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   120: ifeq -> 138
    //   123: aload_1
    //   124: iconst_0
    //   125: aload_1
    //   126: invokevirtual length : ()I
    //   129: iconst_1
    //   130: isub
    //   131: invokevirtual substring : (II)Ljava/lang/String;
    //   134: astore_1
    //   135: goto -> 66
    //   138: aload_0
    //   139: aload_1
    //   140: invokespecial f : (Ljava/lang/String;)V
    //   143: ldc ''
    //   145: astore_1
    //   146: goto -> 66
    //   149: aload_1
    //   150: invokevirtual isEmpty : ()Z
    //   153: ifne -> 161
    //   156: aload_0
    //   157: aload_1
    //   158: invokespecial f : (Ljava/lang/String;)V
    //   161: aload_0
    //   162: iconst_1
    //   163: putfield b : Z
    //   166: aload_0
    //   167: monitorexit
    //   168: return
    //   169: astore_1
    //   170: aload_0
    //   171: monitorexit
    //   172: aload_1
    //   173: athrow
    //   174: return
    // Exception table:
    //   from	to	target	type
    //   17	56	169	finally
    //   59	66	169	finally
    //   66	135	169	finally
    //   138	143	169	finally
    //   149	161	169	finally
    //   161	166	169	finally
    //   166	168	169	finally
    //   170	172	169	finally
  }
  
  private void a(String paramString1, String paramString2) {
    if (paramString1 != null && !paramString1.isEmpty() && paramString2 != null && !paramString2.isEmpty() && !this.a.containsKey(paramString1))
      this.a.put(paramString1, paramString2); 
  }
  
  private static boolean a(char paramChar) {
    return (paramChar > ' ' && paramChar < '' && "()<>@,;:/[]?=\\\"".indexOf(paramChar) < 0);
  }
  
  private static String b(String paramString) {
    int j = paramString.indexOf('/');
    int i = paramString.indexOf(';');
    if (j < 0)
      return null; 
    String str = paramString.substring(0, j).trim().toLowerCase(Locale.ENGLISH);
    if (!c(str))
      return null; 
    j++;
    if (i < 0) {
      paramString = paramString.substring(j);
    } else {
      paramString = paramString.substring(j, i);
    } 
    paramString = paramString.trim().toLowerCase(Locale.ENGLISH);
    if (!c(paramString))
      return null; 
    StringBuilder stringBuilder = new StringBuilder(str.length() + paramString.length() + 1);
    stringBuilder.append(str);
    stringBuilder.append('/');
    stringBuilder.append(paramString);
    return stringBuilder.toString();
  }
  
  private static boolean c(String paramString) {
    int j = paramString.length();
    if (j == 0)
      return false; 
    for (int i = 0; i < j; i++) {
      if (!a(paramString.charAt(i)))
        return false; 
    } 
    return true;
  }
  
  private String d(String paramString) {
    paramString = e(paramString);
    if (paramString.isEmpty())
      return null; 
    a();
    Map<String, String> map = this.a;
    if (map != null) {
      String str;
      if (map.isEmpty())
        return null; 
      while (true) {
        str = this.a.get(paramString);
        String str1 = paramString;
        if (str == null)
          str1 = e(paramString); 
        if (str == null) {
          paramString = str1;
          if (str1.isEmpty())
            break; 
          continue;
        } 
        break;
      } 
      return str;
    } 
    return null;
  }
  
  private static String e(String paramString) {
    if (paramString != null && !paramString.isEmpty()) {
      int i = paramString.indexOf('.');
      if (i >= 0 && i < paramString.length() - 1)
        return paramString.substring(i + 1); 
    } 
    return "";
  }
  
  private void f(String paramString) {
    paramString = paramString.trim();
    if (!paramString.isEmpty()) {
      int i = 0;
      if (paramString.charAt(0) == '#')
        return; 
      String str = paramString.replaceAll("\\s*#.*", "");
      int k = str.indexOf('=');
      int j = 1;
      if (k > 0) {
        Matcher matcher = Pattern.compile("\\btype=(\"\\p{Graph}+?/\\p{Graph}+?\"|\\p{Graph}+/\\p{Graph}+\\b)").matcher(str);
        if (matcher.find()) {
          String str2 = matcher.group().substring(5);
          String str1 = str2;
          if (str2.charAt(0) == '"')
            str1 = str2.substring(1, str2.length() - 1); 
          Matcher matcher1 = Pattern.compile("\\bexts=(\"[\\p{Graph}|\\p{Blank}]+?\"|\\p{Graph}+\\b)").matcher(str);
          if (matcher1.find()) {
            str = matcher1.group().substring(5);
            String str3 = str;
            if (str.charAt(0) == '"')
              str3 = str.substring(1, str.length() - 1); 
            String[] arrayOfString = str3.split("[\\p{Blank}|\\p{Punct}]+");
            j = arrayOfString.length;
            while (i < j) {
              a(arrayOfString[i], str1);
              i++;
            } 
          } 
        } 
      } else {
        String[] arrayOfString = str.split("\\s+");
        for (i = j; i < arrayOfString.length; i++)
          a(arrayOfString[i], arrayOfString[0]); 
      } 
    } 
  }
  
  public final String a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    paramString = d(paramString);
    return TextUtils.isEmpty(paramString) ? null : b(paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsd\\utils\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */