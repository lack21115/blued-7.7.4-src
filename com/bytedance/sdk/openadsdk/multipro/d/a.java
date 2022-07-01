package com.bytedance.sdk.openadsdk.multipro.d;

import android.content.ContentResolver;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.multipro.e;
import com.bytedance.sdk.openadsdk.utils.t;
import java.util.Set;

public class a {
  private static Context a;
  
  public static float a(String paramString1, String paramString2, float paramFloat) {
    if (!a())
      return paramFloat; 
    try {
      ContentResolver contentResolver = b();
      return paramFloat;
    } finally {
      paramString1 = null;
    } 
  }
  
  public static int a(String paramString1, String paramString2, int paramInt) {
    if (!a())
      return paramInt; 
    try {
      ContentResolver contentResolver = b();
      return paramInt;
    } finally {
      paramString1 = null;
    } 
  }
  
  public static long a(String paramString1, String paramString2, long paramLong) {
    if (!a())
      return paramLong; 
    try {
      ContentResolver contentResolver = b();
      return paramLong;
    } finally {
      paramString1 = null;
    } 
  }
  
  public static void a(Context paramContext) {
    if (paramContext == null) {
      paramContext = o.a();
    } else {
      paramContext = paramContext.getApplicationContext();
    } 
    a = paramContext;
  }
  
  public static void a(String paramString) {
    if (!a())
      return; 
    try {
      ContentResolver contentResolver = b();
      return;
    } finally {
      paramString = null;
    } 
  }
  
  public static void a(String paramString1, String paramString2) {
    if (!a())
      return; 
    try {
      ContentResolver contentResolver = b();
      return;
    } finally {
      paramString1 = null;
    } 
  }
  
  public static void a(String paramString1, String paramString2, Boolean paramBoolean) {
    // Byte code:
    //   0: ldc com/bytedance/sdk/openadsdk/multipro/d/a
    //   2: monitorenter
    //   3: invokestatic a : ()Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifne -> 15
    //   11: ldc com/bytedance/sdk/openadsdk/multipro/d/a
    //   13: monitorexit
    //   14: return
    //   15: invokestatic b : ()Landroid/content/ContentResolver;
    //   18: astore #4
    //   20: aload #4
    //   22: ifnull -> 110
    //   25: new java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial <init> : ()V
    //   32: astore #5
    //   34: aload #5
    //   36: invokestatic d : ()Ljava/lang/String;
    //   39: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload #5
    //   45: ldc 'boolean'
    //   47: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload #5
    //   53: ldc '/'
    //   55: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload #5
    //   61: aload_1
    //   62: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload #5
    //   68: aload_0
    //   69: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   72: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload #5
    //   78: invokevirtual toString : ()Ljava/lang/String;
    //   81: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   84: astore_0
    //   85: new android/content/ContentValues
    //   88: dup
    //   89: invokespecial <init> : ()V
    //   92: astore_1
    //   93: aload_1
    //   94: ldc 'value'
    //   96: aload_2
    //   97: invokevirtual put : (Ljava/lang/String;Ljava/lang/Boolean;)V
    //   100: aload #4
    //   102: aload_0
    //   103: aload_1
    //   104: aconst_null
    //   105: aconst_null
    //   106: invokevirtual update : (Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   109: pop
    //   110: ldc com/bytedance/sdk/openadsdk/multipro/d/a
    //   112: monitorexit
    //   113: return
    //   114: astore_0
    //   115: ldc com/bytedance/sdk/openadsdk/multipro/d/a
    //   117: monitorexit
    //   118: aload_0
    //   119: athrow
    //   120: astore_0
    //   121: goto -> 110
    // Exception table:
    //   from	to	target	type
    //   3	7	114	finally
    //   15	20	120	finally
    //   25	110	120	finally
  }
  
  public static void a(String paramString1, String paramString2, Float paramFloat) {
    // Byte code:
    //   0: ldc com/bytedance/sdk/openadsdk/multipro/d/a
    //   2: monitorenter
    //   3: invokestatic a : ()Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifne -> 15
    //   11: ldc com/bytedance/sdk/openadsdk/multipro/d/a
    //   13: monitorexit
    //   14: return
    //   15: invokestatic b : ()Landroid/content/ContentResolver;
    //   18: astore #4
    //   20: aload #4
    //   22: ifnull -> 110
    //   25: new java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial <init> : ()V
    //   32: astore #5
    //   34: aload #5
    //   36: invokestatic d : ()Ljava/lang/String;
    //   39: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload #5
    //   45: ldc 'float'
    //   47: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload #5
    //   53: ldc '/'
    //   55: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload #5
    //   61: aload_1
    //   62: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload #5
    //   68: aload_0
    //   69: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   72: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload #5
    //   78: invokevirtual toString : ()Ljava/lang/String;
    //   81: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   84: astore_0
    //   85: new android/content/ContentValues
    //   88: dup
    //   89: invokespecial <init> : ()V
    //   92: astore_1
    //   93: aload_1
    //   94: ldc 'value'
    //   96: aload_2
    //   97: invokevirtual put : (Ljava/lang/String;Ljava/lang/Float;)V
    //   100: aload #4
    //   102: aload_0
    //   103: aload_1
    //   104: aconst_null
    //   105: aconst_null
    //   106: invokevirtual update : (Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   109: pop
    //   110: ldc com/bytedance/sdk/openadsdk/multipro/d/a
    //   112: monitorexit
    //   113: return
    //   114: astore_0
    //   115: ldc com/bytedance/sdk/openadsdk/multipro/d/a
    //   117: monitorexit
    //   118: aload_0
    //   119: athrow
    //   120: astore_0
    //   121: goto -> 110
    // Exception table:
    //   from	to	target	type
    //   3	7	114	finally
    //   15	20	120	finally
    //   25	110	120	finally
  }
  
  public static void a(String paramString1, String paramString2, Integer paramInteger) {
    // Byte code:
    //   0: ldc com/bytedance/sdk/openadsdk/multipro/d/a
    //   2: monitorenter
    //   3: invokestatic a : ()Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifne -> 15
    //   11: ldc com/bytedance/sdk/openadsdk/multipro/d/a
    //   13: monitorexit
    //   14: return
    //   15: invokestatic b : ()Landroid/content/ContentResolver;
    //   18: astore #4
    //   20: aload #4
    //   22: ifnull -> 110
    //   25: new java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial <init> : ()V
    //   32: astore #5
    //   34: aload #5
    //   36: invokestatic d : ()Ljava/lang/String;
    //   39: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload #5
    //   45: ldc 'int'
    //   47: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload #5
    //   53: ldc '/'
    //   55: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload #5
    //   61: aload_1
    //   62: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload #5
    //   68: aload_0
    //   69: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   72: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload #5
    //   78: invokevirtual toString : ()Ljava/lang/String;
    //   81: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   84: astore_0
    //   85: new android/content/ContentValues
    //   88: dup
    //   89: invokespecial <init> : ()V
    //   92: astore_1
    //   93: aload_1
    //   94: ldc 'value'
    //   96: aload_2
    //   97: invokevirtual put : (Ljava/lang/String;Ljava/lang/Integer;)V
    //   100: aload #4
    //   102: aload_0
    //   103: aload_1
    //   104: aconst_null
    //   105: aconst_null
    //   106: invokevirtual update : (Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   109: pop
    //   110: ldc com/bytedance/sdk/openadsdk/multipro/d/a
    //   112: monitorexit
    //   113: return
    //   114: astore_0
    //   115: ldc com/bytedance/sdk/openadsdk/multipro/d/a
    //   117: monitorexit
    //   118: aload_0
    //   119: athrow
    //   120: astore_0
    //   121: goto -> 110
    // Exception table:
    //   from	to	target	type
    //   3	7	114	finally
    //   15	20	120	finally
    //   25	110	120	finally
  }
  
  public static void a(String paramString1, String paramString2, Long paramLong) {
    // Byte code:
    //   0: ldc com/bytedance/sdk/openadsdk/multipro/d/a
    //   2: monitorenter
    //   3: invokestatic a : ()Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifne -> 15
    //   11: ldc com/bytedance/sdk/openadsdk/multipro/d/a
    //   13: monitorexit
    //   14: return
    //   15: invokestatic b : ()Landroid/content/ContentResolver;
    //   18: astore #4
    //   20: aload #4
    //   22: ifnull -> 110
    //   25: new java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial <init> : ()V
    //   32: astore #5
    //   34: aload #5
    //   36: invokestatic d : ()Ljava/lang/String;
    //   39: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload #5
    //   45: ldc 'long'
    //   47: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload #5
    //   53: ldc '/'
    //   55: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload #5
    //   61: aload_1
    //   62: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload #5
    //   68: aload_0
    //   69: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   72: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload #5
    //   78: invokevirtual toString : ()Ljava/lang/String;
    //   81: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   84: astore_0
    //   85: new android/content/ContentValues
    //   88: dup
    //   89: invokespecial <init> : ()V
    //   92: astore_1
    //   93: aload_1
    //   94: ldc 'value'
    //   96: aload_2
    //   97: invokevirtual put : (Ljava/lang/String;Ljava/lang/Long;)V
    //   100: aload #4
    //   102: aload_0
    //   103: aload_1
    //   104: aconst_null
    //   105: aconst_null
    //   106: invokevirtual update : (Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   109: pop
    //   110: ldc com/bytedance/sdk/openadsdk/multipro/d/a
    //   112: monitorexit
    //   113: return
    //   114: astore_0
    //   115: ldc com/bytedance/sdk/openadsdk/multipro/d/a
    //   117: monitorexit
    //   118: aload_0
    //   119: athrow
    //   120: astore_0
    //   121: goto -> 110
    // Exception table:
    //   from	to	target	type
    //   3	7	114	finally
    //   15	20	120	finally
    //   25	110	120	finally
  }
  
  public static void a(String paramString1, String paramString2, String paramString3) {
    // Byte code:
    //   0: ldc com/bytedance/sdk/openadsdk/multipro/d/a
    //   2: monitorenter
    //   3: invokestatic a : ()Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifne -> 15
    //   11: ldc com/bytedance/sdk/openadsdk/multipro/d/a
    //   13: monitorexit
    //   14: return
    //   15: invokestatic b : ()Landroid/content/ContentResolver;
    //   18: astore #4
    //   20: aload #4
    //   22: ifnull -> 110
    //   25: new java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial <init> : ()V
    //   32: astore #5
    //   34: aload #5
    //   36: invokestatic d : ()Ljava/lang/String;
    //   39: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload #5
    //   45: ldc 'string'
    //   47: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload #5
    //   53: ldc '/'
    //   55: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload #5
    //   61: aload_1
    //   62: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload #5
    //   68: aload_0
    //   69: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   72: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload #5
    //   78: invokevirtual toString : ()Ljava/lang/String;
    //   81: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   84: astore_0
    //   85: new android/content/ContentValues
    //   88: dup
    //   89: invokespecial <init> : ()V
    //   92: astore_1
    //   93: aload_1
    //   94: ldc 'value'
    //   96: aload_2
    //   97: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   100: aload #4
    //   102: aload_0
    //   103: aload_1
    //   104: aconst_null
    //   105: aconst_null
    //   106: invokevirtual update : (Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   109: pop
    //   110: ldc com/bytedance/sdk/openadsdk/multipro/d/a
    //   112: monitorexit
    //   113: return
    //   114: astore_0
    //   115: ldc com/bytedance/sdk/openadsdk/multipro/d/a
    //   117: monitorexit
    //   118: aload_0
    //   119: athrow
    //   120: astore_0
    //   121: goto -> 110
    // Exception table:
    //   from	to	target	type
    //   3	7	114	finally
    //   15	20	120	finally
    //   25	110	120	finally
  }
  
  public static void a(String paramString1, String paramString2, Set<String> paramSet) {
    // Byte code:
    //   0: ldc com/bytedance/sdk/openadsdk/multipro/d/a
    //   2: monitorenter
    //   3: invokestatic a : ()Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifne -> 15
    //   11: ldc com/bytedance/sdk/openadsdk/multipro/d/a
    //   13: monitorexit
    //   14: return
    //   15: invokestatic b : ()Landroid/content/ContentResolver;
    //   18: astore #4
    //   20: aload #4
    //   22: ifnull -> 166
    //   25: new java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial <init> : ()V
    //   32: astore #5
    //   34: aload #5
    //   36: invokestatic d : ()Ljava/lang/String;
    //   39: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload #5
    //   45: ldc 'string_set'
    //   47: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload #5
    //   53: ldc '/'
    //   55: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload #5
    //   61: aload_1
    //   62: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload #5
    //   68: aload_0
    //   69: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   72: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload #5
    //   78: invokevirtual toString : ()Ljava/lang/String;
    //   81: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   84: astore_0
    //   85: new android/content/ContentValues
    //   88: dup
    //   89: invokespecial <init> : ()V
    //   92: astore_1
    //   93: new java/util/HashSet
    //   96: dup
    //   97: invokespecial <init> : ()V
    //   100: astore #5
    //   102: aload_2
    //   103: invokeinterface iterator : ()Ljava/util/Iterator;
    //   108: astore_2
    //   109: aload_2
    //   110: invokeinterface hasNext : ()Z
    //   115: ifeq -> 145
    //   118: aload #5
    //   120: aload_2
    //   121: invokeinterface next : ()Ljava/lang/Object;
    //   126: checkcast java/lang/String
    //   129: ldc ','
    //   131: ldc '__COMMA__'
    //   133: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   136: invokeinterface add : (Ljava/lang/Object;)Z
    //   141: pop
    //   142: goto -> 109
    //   145: aload_1
    //   146: ldc 'value'
    //   148: aload #5
    //   150: invokevirtual toString : ()Ljava/lang/String;
    //   153: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   156: aload #4
    //   158: aload_0
    //   159: aload_1
    //   160: aconst_null
    //   161: aconst_null
    //   162: invokevirtual update : (Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   165: pop
    //   166: ldc com/bytedance/sdk/openadsdk/multipro/d/a
    //   168: monitorexit
    //   169: return
    //   170: astore_0
    //   171: ldc com/bytedance/sdk/openadsdk/multipro/d/a
    //   173: monitorexit
    //   174: aload_0
    //   175: athrow
    //   176: astore_0
    //   177: goto -> 166
    // Exception table:
    //   from	to	target	type
    //   3	7	170	finally
    //   15	20	176	finally
    //   25	109	176	finally
    //   109	142	176	finally
    //   145	166	176	finally
  }
  
  public static boolean a() {
    if (a == null || o.a() == null) {
      t.b("The context of SPHelper is null, please initialize sdk in main process");
      return false;
    } 
    return true;
  }
  
  public static boolean a(String paramString1, String paramString2, boolean paramBoolean) {
    if (!a())
      return paramBoolean; 
    try {
      ContentResolver contentResolver = b();
      return paramBoolean;
    } finally {
      paramString1 = null;
    } 
  }
  
  private static ContentResolver b() {
    try {
      if (a())
        return c().getContentResolver(); 
    } finally {
      Exception exception;
    } 
    return null;
  }
  
  private static String b(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return ""; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("?sp_file_name=");
    stringBuilder.append(paramString);
    return stringBuilder.toString();
  }
  
  public static String b(String paramString1, String paramString2, String paramString3) {
    if (!a())
      return paramString3; 
    try {
      ContentResolver contentResolver = b();
      return paramString3;
    } finally {
      paramString1 = null;
    } 
  }
  
  public static Set<String> b(String paramString1, String paramString2, Set<String> paramSet) {
    if (!a())
      return paramSet; 
    try {
      ContentResolver contentResolver = b();
      return paramSet;
    } finally {
      paramString1 = null;
    } 
  }
  
  private static Context c() {
    Context context2 = a;
    Context context1 = context2;
    if (context2 == null)
      context1 = o.a(); 
    return context1;
  }
  
  private static String d() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(e.b);
    stringBuilder.append("/");
    stringBuilder.append("t_sp");
    stringBuilder.append("/");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\multipro\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */