package com.baidu.mobads.nativecpu.a;

import android.content.Context;
import com.baidu.mobads.f.b;
import com.baidu.mobads.f.g;
import com.baidu.mobads.utils.q;
import dalvik.system.DexClassLoader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class c {
  private static volatile Map<String, c> c = new HashMap<String, c>();
  
  private Class<?> a;
  
  private Method[] b = null;
  
  private c(Context paramContext, String paramString) {
    try {
      DexClassLoader dexClassLoader = b.d();
      return;
    } finally {
      paramContext = null;
      q.a().d((Throwable)paramContext);
    } 
  }
  
  public static c a(Context paramContext, String paramString) {
    // Byte code:
    //   0: getstatic com/baidu/mobads/nativecpu/a/c.c : Ljava/util/Map;
    //   3: aload_1
    //   4: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   9: ifeq -> 30
    //   12: getstatic com/baidu/mobads/nativecpu/a/c.c : Ljava/util/Map;
    //   15: aload_1
    //   16: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   21: checkcast com/baidu/mobads/nativecpu/a/c
    //   24: getfield a : Ljava/lang/Class;
    //   27: ifnonnull -> 85
    //   30: ldc com/baidu/mobads/nativecpu/a/c
    //   32: monitorenter
    //   33: getstatic com/baidu/mobads/nativecpu/a/c.c : Ljava/util/Map;
    //   36: aload_1
    //   37: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   42: ifeq -> 63
    //   45: getstatic com/baidu/mobads/nativecpu/a/c.c : Ljava/util/Map;
    //   48: aload_1
    //   49: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   54: checkcast com/baidu/mobads/nativecpu/a/c
    //   57: getfield a : Ljava/lang/Class;
    //   60: ifnonnull -> 82
    //   63: getstatic com/baidu/mobads/nativecpu/a/c.c : Ljava/util/Map;
    //   66: aload_1
    //   67: new com/baidu/mobads/nativecpu/a/c
    //   70: dup
    //   71: aload_0
    //   72: aload_1
    //   73: invokespecial <init> : (Landroid/content/Context;Ljava/lang/String;)V
    //   76: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   81: pop
    //   82: ldc com/baidu/mobads/nativecpu/a/c
    //   84: monitorexit
    //   85: getstatic com/baidu/mobads/nativecpu/a/c.c : Ljava/util/Map;
    //   88: aload_1
    //   89: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   94: checkcast com/baidu/mobads/nativecpu/a/c
    //   97: areturn
    //   98: astore_0
    //   99: ldc com/baidu/mobads/nativecpu/a/c
    //   101: monitorexit
    //   102: aload_0
    //   103: athrow
    // Exception table:
    //   from	to	target	type
    //   33	63	98	finally
    //   63	82	98	finally
    //   82	85	98	finally
    //   99	102	98	finally
  }
  
  private Method a(String paramString) {
    Method[] arrayOfMethod = this.b;
    if (arrayOfMethod == null)
      return null; 
    int j = arrayOfMethod.length;
    for (int i = 0; i < j; i++) {
      Method method = arrayOfMethod[i];
      if (method.getName().equals(paramString)) {
        method.setAccessible(true);
        return method;
      } 
    } 
    return null;
  }
  
  public Object a(Class<?>[] paramArrayOfClass, Object... paramVarArgs) {
    if (paramVarArgs != null)
      try {
        return null.newInstance(paramVarArgs);
      } finally {
        paramArrayOfClass = null;
        q.a().d((Throwable)paramArrayOfClass);
      }  
    null = this.a.getConstructor(new Class[0]);
    return null.newInstance(paramVarArgs);
  }
  
  public void a(Object paramObject, String paramString, Object... paramVarArgs) {
    try {
      Method method = a(paramString);
    } finally {
      paramObject = null;
    } 
  }
  
  public Class<?> b(Context paramContext, String paramString) {
    StringBuilder stringBuilder;
    q q = q.a();
    ClassLoader classLoader = c.class.getClass().getClassLoader();
    Context context = null;
    try {
      Class<?> clazz = Class.forName(paramString, true, (ClassLoader)new DexClassLoader(g.a(paramContext), paramContext.getFilesDir().getAbsolutePath(), null, classLoader));
    } finally {
      paramContext = null;
      q.d((Throwable)paramContext);
    } 
    stringBuilder.append(paramContext);
    q.d(stringBuilder.toString());
    return (Class<?>)paramContext;
  }
  
  public Object b(Object paramObject, String paramString, Object... paramVarArgs) {
    try {
      Method method = a(paramString);
    } finally {
      paramObject = null;
    } 
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\nativecpu\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */