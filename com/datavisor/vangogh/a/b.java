package com.datavisor.vangogh.a;

import android.content.Context;
import com.datavisor.vangogh.bridge.crypto;
import com.datavisor.vangogh.bridge.storage;
import com.datavisor.vangogh.f.f;
import org.json.JSONArray;
import org.json.JSONObject;

public class b {
  private static b a;
  
  private Context b = null;
  
  private long c = 0L;
  
  private b(Context paramContext) {
    if (paramContext != null) {
      this.b = paramContext;
      this.c = 0L;
      return;
    } 
    throw new IllegalArgumentException("HookDetect initialization error: mContext is null.");
  }
  
  public static b a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/datavisor/vangogh/a/b.a : Lcom/datavisor/vangogh/a/b;
    //   3: ifnonnull -> 38
    //   6: ldc com/datavisor/vangogh/a/b
    //   8: monitorenter
    //   9: getstatic com/datavisor/vangogh/a/b.a : Lcom/datavisor/vangogh/a/b;
    //   12: ifnonnull -> 26
    //   15: new com/datavisor/vangogh/a/b
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Landroid/content/Context;)V
    //   23: putstatic com/datavisor/vangogh/a/b.a : Lcom/datavisor/vangogh/a/b;
    //   26: ldc com/datavisor/vangogh/a/b
    //   28: monitorexit
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc com/datavisor/vangogh/a/b
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic com/datavisor/vangogh/a/b.a : Lcom/datavisor/vangogh/a/b;
    //   41: areturn
    // Exception table:
    //   from	to	target	type
    //   9	26	32	finally
    //   26	29	32	finally
    //   33	36	32	finally
  }
  
  private void a(JSONArray paramJSONArray) {
    String str = storage.globalGet(crypto.convert("H6ih/XXMmPAdX5dBI+oF8QZ9zqL6"));
    if (f.a(str))
      return; 
    int i = 0;
    try {
      while (i < paramJSONArray.length()) {
        if (str.contains(paramJSONArray.getString(i).toLowerCase()))
          return; 
        i++;
      } 
    } finally {
      paramJSONArray = null;
    } 
  }
  
  private void b() {
    // Byte code:
    //   0: new java/lang/Exception
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: athrow
    //   8: astore #6
    //   10: aload #6
    //   12: invokevirtual getStackTrace : ()[Ljava/lang/StackTraceElement;
    //   15: astore #6
    //   17: aload #6
    //   19: arraylength
    //   20: istore #5
    //   22: iconst_0
    //   23: istore #4
    //   25: iconst_0
    //   26: istore_1
    //   27: iconst_0
    //   28: istore_2
    //   29: iload #4
    //   31: istore_3
    //   32: iload_1
    //   33: iload #5
    //   35: if_icmpge -> 207
    //   38: aload #6
    //   40: iload_1
    //   41: aaload
    //   42: astore #7
    //   44: new java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial <init> : ()V
    //   51: astore #8
    //   53: aload #8
    //   55: aload #7
    //   57: invokevirtual getClassName : ()Ljava/lang/String;
    //   60: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload #8
    //   66: ldc ''
    //   68: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload #8
    //   74: invokevirtual toString : ()Ljava/lang/String;
    //   77: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   80: ldc 'xposed'
    //   82: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   85: ifeq -> 91
    //   88: goto -> 227
    //   91: iload_2
    //   92: istore_3
    //   93: aload #7
    //   95: invokevirtual getClassName : ()Ljava/lang/String;
    //   98: ldc 'com.android.internal.os.ZygoteInit'
    //   100: invokevirtual equals : (Ljava/lang/Object;)Z
    //   103: ifeq -> 120
    //   106: iload_2
    //   107: iconst_1
    //   108: iadd
    //   109: istore_2
    //   110: iload_2
    //   111: istore_3
    //   112: iload_2
    //   113: iconst_2
    //   114: if_icmpne -> 120
    //   117: goto -> 227
    //   120: aload #7
    //   122: invokevirtual getClassName : ()Ljava/lang/String;
    //   125: ldc 'com.saurik.substrate.MS$2'
    //   127: invokevirtual equals : (Ljava/lang/Object;)Z
    //   130: ifeq -> 149
    //   133: aload #7
    //   135: invokevirtual getMethodName : ()Ljava/lang/String;
    //   138: ldc 'invoked'
    //   140: invokevirtual equals : (Ljava/lang/Object;)Z
    //   143: ifeq -> 149
    //   146: goto -> 227
    //   149: aload #7
    //   151: invokevirtual getClassName : ()Ljava/lang/String;
    //   154: ldc 'de.robv.android.xposed.XposedBridge'
    //   156: invokevirtual equals : (Ljava/lang/Object;)Z
    //   159: ifeq -> 178
    //   162: aload #7
    //   164: invokevirtual getMethodName : ()Ljava/lang/String;
    //   167: ldc 'main'
    //   169: invokevirtual equals : (Ljava/lang/Object;)Z
    //   172: ifeq -> 178
    //   175: goto -> 227
    //   178: aload #7
    //   180: invokevirtual getClassName : ()Ljava/lang/String;
    //   183: ldc 'de.robv.android.xposed.XposedBridge'
    //   185: invokevirtual equals : (Ljava/lang/Object;)Z
    //   188: ifeq -> 232
    //   191: aload #7
    //   193: invokevirtual getMethodName : ()Ljava/lang/String;
    //   196: ldc 'handleHookedMethod'
    //   198: invokevirtual equals : (Ljava/lang/Object;)Z
    //   201: ifeq -> 232
    //   204: goto -> 227
    //   207: iload_3
    //   208: ifeq -> 223
    //   211: aload_0
    //   212: aload_0
    //   213: getfield c : J
    //   216: ldc2_w 4
    //   219: lor
    //   220: putfield c : J
    //   223: return
    //   224: astore #6
    //   226: return
    //   227: iconst_1
    //   228: istore_3
    //   229: goto -> 207
    //   232: iload_1
    //   233: iconst_1
    //   234: iadd
    //   235: istore_1
    //   236: iload_3
    //   237: istore_2
    //   238: goto -> 29
    // Exception table:
    //   from	to	target	type
    //   0	8	8	finally
    //   10	22	224	finally
    //   44	88	224	finally
    //   93	106	224	finally
    //   120	146	224	finally
    //   149	175	224	finally
    //   178	204	224	finally
    //   211	223	224	finally
  }
  
  private void c() {
    try {
      ClassLoader.getSystemClassLoader().loadClass("de.robv.android.xposed.XposedHelpers").newInstance();
      this.c = 0x8L | this.c;
      return;
    } catch (InstantiationException|IllegalAccessException instantiationException) {
      this.c = 0x8L | this.c;
      return;
    } catch (ClassNotFoundException classNotFoundException) {
      return;
    } 
  }
  
  private void d() {
    try {
      ClassLoader.getSystemClassLoader().loadClass("de.robv.android.xposed.XposedBridge").newInstance();
      this.c = 0x10L | this.c;
      return;
    } catch (InstantiationException|IllegalAccessException instantiationException) {
      this.c = 0x10L | this.c;
      return;
    } catch (ClassNotFoundException classNotFoundException) {
      return;
    } 
  }
  
  public String a() {
    JSONObject jSONObject = com.datavisor.vangogh.d.b.a(this.b).c(crypto.convert("M5GRwg=="));
    if (jSONObject == null)
      return "empty"; 
    this.c = 0L;
    try {
      JSONArray jSONArray = jSONObject.getJSONArray(crypto.convert("K4yRyg=="));
      if (jSONArray != null && jSONArray.length() > 0)
        a(jSONArray); 
    } finally {}
    b();
    c();
    d();
    return String.valueOf(this.c);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\datavisor\vangogh\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */