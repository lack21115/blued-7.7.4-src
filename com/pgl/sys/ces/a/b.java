package com.pgl.sys.ces.a;

import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class b {
  private static final FileFilter a = new FileFilter() {
      public boolean accept(File param1File) {
        return Pattern.matches("cpu[0-9]", param1File.getName());
      }
    };
  
  public static String a() {
    JSONObject jSONObject = new JSONObject();
    try {
      HashMap<String, String> hashMap = b();
      jSONObject.put("core", c());
      jSONObject.put("hw", a(hashMap, "Hardware"));
      jSONObject.put("max", a("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"));
      jSONObject.put("min", a("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq"));
      jSONObject.put("ft", a(hashMap, "Features"));
    } finally {
      Exception exception;
    } 
    String str = jSONObject.toString();
    return (str == null) ? "{}" : str.trim();
  }
  
  private static String a(String paramString) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: new java/io/FileReader
    //   7: dup
    //   8: aload_0
    //   9: invokespecial <init> : (Ljava/lang/String;)V
    //   12: astore_0
    //   13: new java/io/BufferedReader
    //   16: dup
    //   17: aload_0
    //   18: invokespecial <init> : (Ljava/io/Reader;)V
    //   21: astore_1
    //   22: aload_1
    //   23: invokevirtual readLine : ()Ljava/lang/String;
    //   26: astore #4
    //   28: aload_1
    //   29: invokevirtual close : ()V
    //   32: aload #4
    //   34: astore_1
    //   35: aload_0
    //   36: invokevirtual close : ()V
    //   39: goto -> 79
    //   42: goto -> 79
    //   45: goto -> 57
    //   48: aconst_null
    //   49: astore_1
    //   50: goto -> 57
    //   53: aconst_null
    //   54: astore_1
    //   55: aload_1
    //   56: astore_0
    //   57: aload_1
    //   58: ifnull -> 68
    //   61: aload_1
    //   62: invokevirtual close : ()V
    //   65: goto -> 68
    //   68: aload_3
    //   69: astore_1
    //   70: aload_0
    //   71: ifnull -> 79
    //   74: aload_2
    //   75: astore_1
    //   76: goto -> 35
    //   79: aload_1
    //   80: ifnonnull -> 86
    //   83: ldc '0'
    //   85: areturn
    //   86: aload_1
    //   87: invokevirtual trim : ()Ljava/lang/String;
    //   90: areturn
    //   91: astore_0
    //   92: goto -> 53
    //   95: astore_1
    //   96: goto -> 48
    //   99: astore #4
    //   101: goto -> 45
    //   104: astore_1
    //   105: aload #4
    //   107: astore_1
    //   108: goto -> 35
    //   111: astore_0
    //   112: goto -> 42
    //   115: astore_1
    //   116: goto -> 68
    // Exception table:
    //   from	to	target	type
    //   4	13	91	finally
    //   13	22	95	finally
    //   22	28	99	finally
    //   28	32	104	finally
    //   35	39	111	finally
    //   61	65	115	finally
  }
  
  private static String a(HashMap<String, String> paramHashMap, String paramString) {
    try {
      String str = paramHashMap.get(paramString);
    } finally {
      paramHashMap = null;
    } 
  }
  
  private static HashMap<String, String> b() {
    Exception exception1;
    Exception exception2;
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    try {
    
    } finally {
      exception1 = null;
      exception1 = null;
    } 
    if (exception2 != null)
      try {
        exception2.close();
      } finally {} 
    if (exception1 == null)
      return (HashMap)hashMap; 
    try {
      return (HashMap)hashMap;
    } finally {
      exception1 = null;
    } 
  }
  
  private static int c() {
    try {
      return ((new File("/sys/devices/system/cpu/")).listFiles(a)).length;
    } finally {
      Exception exception = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\pgl\sys\ces\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */