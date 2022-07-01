package com.bytedance.sdk.openadsdk.multipro.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class b {
  private static SoftReference<ConcurrentHashMap<String, Map<String, Object>>> a;
  
  private static float a(Context paramContext, String paramString1, String paramString2, float paramFloat) {
    SharedPreferences sharedPreferences = c(paramContext, paramString1);
    return (sharedPreferences == null) ? paramFloat : sharedPreferences.getFloat(paramString2, paramFloat);
  }
  
  private static int a(Context paramContext, String paramString1, String paramString2, int paramInt) {
    SharedPreferences sharedPreferences = c(paramContext, paramString1);
    return (sharedPreferences == null) ? paramInt : sharedPreferences.getInt(paramString2, paramInt);
  }
  
  private static long a(Context paramContext, String paramString1, String paramString2, long paramLong) {
    SharedPreferences sharedPreferences = c(paramContext, paramString1);
    return (sharedPreferences == null) ? paramLong : sharedPreferences.getLong(paramString2, paramLong);
  }
  
  private static Object a(String paramString1, String paramString2) {
    SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = a;
    if (softReference != null) {
      ConcurrentHashMap concurrentHashMap = softReference.get();
      if (concurrentHashMap != null) {
        Map map = (Map)concurrentHashMap.get(a(paramString1));
        if (map != null)
          return map.get(paramString2); 
      } 
    } 
    return null;
  }
  
  static String a(Context paramContext, String paramString1, String paramString2, String paramString3) {
    StringBuilder stringBuilder1;
    Object object2 = a(paramString1, paramString2);
    if (object2 != null) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(object2);
      stringBuilder1.append("");
      return stringBuilder1.toString();
    } 
    Object object1 = b((Context)stringBuilder1, paramString1, paramString2, paramString3);
    a(paramString1, paramString2, object1);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(object1);
    stringBuilder2.append("");
    return stringBuilder2.toString();
  }
  
  private static String a(String paramString) {
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
      str = "sphelper_ttopenadsdk"; 
    return str;
  }
  
  static void a(Context paramContext, String paramString) {
    SharedPreferences.Editor editor = c(paramContext, paramString).edit();
    editor.clear();
    editor.apply();
    b(paramString);
  }
  
  static <T> void a(Context paramContext, String paramString1, String paramString2, T paramT) {
    // Byte code:
    //   0: ldc com/bytedance/sdk/openadsdk/multipro/d/b
    //   2: monitorenter
    //   3: aload_0
    //   4: aload_1
    //   5: invokestatic c : (Landroid/content/Context;Ljava/lang/String;)Landroid/content/SharedPreferences;
    //   8: astore_0
    //   9: aload_0
    //   10: ifnonnull -> 17
    //   13: ldc com/bytedance/sdk/openadsdk/multipro/d/b
    //   15: monitorexit
    //   16: return
    //   17: aload_3
    //   18: aload_1
    //   19: aload_2
    //   20: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   23: invokevirtual equals : (Ljava/lang/Object;)Z
    //   26: istore #4
    //   28: iload #4
    //   30: ifeq -> 37
    //   33: ldc com/bytedance/sdk/openadsdk/multipro/d/b
    //   35: monitorexit
    //   36: return
    //   37: aload_0
    //   38: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   43: astore_0
    //   44: aload_3
    //   45: instanceof java/lang/Boolean
    //   48: ifeq -> 66
    //   51: aload_0
    //   52: aload_2
    //   53: aload_3
    //   54: checkcast java/lang/Boolean
    //   57: invokevirtual booleanValue : ()Z
    //   60: invokeinterface putBoolean : (Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;
    //   65: pop
    //   66: aload_3
    //   67: instanceof java/lang/String
    //   70: ifeq -> 85
    //   73: aload_0
    //   74: aload_2
    //   75: aload_3
    //   76: checkcast java/lang/String
    //   79: invokeinterface putString : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   84: pop
    //   85: aload_3
    //   86: instanceof java/lang/Integer
    //   89: ifeq -> 107
    //   92: aload_0
    //   93: aload_2
    //   94: aload_3
    //   95: checkcast java/lang/Integer
    //   98: invokevirtual intValue : ()I
    //   101: invokeinterface putInt : (Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   106: pop
    //   107: aload_3
    //   108: instanceof java/lang/Long
    //   111: ifeq -> 129
    //   114: aload_0
    //   115: aload_2
    //   116: aload_3
    //   117: checkcast java/lang/Long
    //   120: invokevirtual longValue : ()J
    //   123: invokeinterface putLong : (Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   128: pop
    //   129: aload_3
    //   130: instanceof java/lang/Float
    //   133: ifeq -> 151
    //   136: aload_0
    //   137: aload_2
    //   138: aload_3
    //   139: checkcast java/lang/Float
    //   142: invokevirtual floatValue : ()F
    //   145: invokeinterface putFloat : (Ljava/lang/String;F)Landroid/content/SharedPreferences$Editor;
    //   150: pop
    //   151: aload_0
    //   152: invokeinterface apply : ()V
    //   157: aload_1
    //   158: aload_2
    //   159: aload_3
    //   160: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   163: ldc com/bytedance/sdk/openadsdk/multipro/d/b
    //   165: monitorexit
    //   166: return
    //   167: astore_0
    //   168: ldc com/bytedance/sdk/openadsdk/multipro/d/b
    //   170: monitorexit
    //   171: aload_0
    //   172: athrow
    // Exception table:
    //   from	to	target	type
    //   3	9	167	finally
    //   17	28	167	finally
    //   37	66	167	finally
    //   66	85	167	finally
    //   85	107	167	finally
    //   107	129	167	finally
    //   129	151	167	finally
    //   151	163	167	finally
  }
  
  private static void a(String paramString1, String paramString2, Object paramObject) {
    SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = a;
    if (softReference == null || softReference.get() == null)
      a = new SoftReference<ConcurrentHashMap<String, Map<String, Object>>>(new ConcurrentHashMap<String, Map<String, Object>>()); 
    paramString1 = a(paramString1);
    ConcurrentHashMap concurrentHashMap = a.get();
    if (concurrentHashMap.get(paramString1) == null)
      concurrentHashMap.put(paramString1, new HashMap<Object, Object>()); 
    ((Map<String, Object>)concurrentHashMap.get(paramString1)).put(paramString2, paramObject);
  }
  
  static boolean a(Context paramContext, String paramString1, String paramString2) {
    SharedPreferences sharedPreferences = c(paramContext, paramString1);
    return (sharedPreferences != null && sharedPreferences.contains(paramString2));
  }
  
  private static boolean a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean) {
    SharedPreferences sharedPreferences = c(paramContext, paramString1);
    return (sharedPreferences == null) ? paramBoolean : sharedPreferences.getBoolean(paramString2, paramBoolean);
  }
  
  private static Object b(Context paramContext, String paramString1, String paramString2, String paramString3) {
    paramString1 = a(paramString1);
    return !a(paramContext, paramString1, paramString2) ? null : (paramString3.equalsIgnoreCase("string") ? c(paramContext, paramString1, paramString2, null) : (paramString3.equalsIgnoreCase("boolean") ? Boolean.valueOf(a(paramContext, paramString1, paramString2, false)) : (paramString3.equalsIgnoreCase("int") ? Integer.valueOf(a(paramContext, paramString1, paramString2, 0)) : (paramString3.equalsIgnoreCase("long") ? Long.valueOf(a(paramContext, paramString1, paramString2, 0L)) : (paramString3.equalsIgnoreCase("float") ? Float.valueOf(a(paramContext, paramString1, paramString2, 0.0F)) : (paramString3.equalsIgnoreCase("string_set") ? c(paramContext, paramString1, paramString2, null) : null))))));
  }
  
  static Map<String, ?> b(Context paramContext, String paramString) {
    return c(paramContext, paramString).getAll();
  }
  
  static void b(Context paramContext, String paramString1, String paramString2) {
    try {
      SharedPreferences sharedPreferences = c(paramContext, paramString1);
      if (sharedPreferences == null)
        return; 
      SharedPreferences.Editor editor = sharedPreferences.edit();
      editor.remove(paramString2);
      editor.apply();
      return;
    } finally {
      paramContext = null;
    } 
  }
  
  private static void b(String paramString) {
    SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = a;
    if (softReference != null && softReference.get() != null) {
      Map map = (Map)((ConcurrentHashMap)a.get()).get(a(paramString));
      if (map != null)
        map.clear(); 
    } 
  }
  
  private static SharedPreferences c(Context paramContext, String paramString) {
    return (paramContext == null) ? null : paramContext.getSharedPreferences(a(paramString), 0);
  }
  
  private static String c(Context paramContext, String paramString1, String paramString2, String paramString3) {
    SharedPreferences sharedPreferences = c(paramContext, paramString1);
    return (sharedPreferences == null) ? paramString3 : sharedPreferences.getString(paramString2, paramString3);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\multipro\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */