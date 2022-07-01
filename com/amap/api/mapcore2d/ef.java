package com.amap.api.mapcore2d;

import android.content.Context;
import java.io.File;
import java.lang.reflect.Constructor;

public class ef {
  public static Class a(Context paramContext, da paramda, String paramString) {
    ei ei = b(paramContext, paramda);
    try {
      return a(ei) ? ei.loadClass(paramString) : null;
    } finally {
      ei = null;
      eh.a((Throwable)ei, "InstanceFactory", "loadpn");
    } 
  }
  
  public static <T> T a(Context paramContext, da paramda, String paramString, Class paramClass, Class[] paramArrayOfClass, Object[] paramArrayOfObject) throws cp {
    paramContext = a(b(paramContext, paramda), paramString, paramArrayOfClass, paramArrayOfObject);
    if (paramContext != null)
      return (T)paramContext; 
    paramContext = a(paramClass, paramArrayOfClass, paramArrayOfObject);
    if (paramContext != null)
      return (T)paramContext; 
    throw new cp("获取对象错误");
  }
  
  private static <T> T a(ei paramei, String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject) {
    try {
      if (a(paramei)) {
        Class<?> clazz = paramei.loadClass(paramString);
        if (clazz != null) {
          null = clazz.getDeclaredConstructor(paramArrayOfClass);
          return (T)null.newInstance(paramArrayOfObject);
        } 
      } 
    } finally {
      paramei = null;
    } 
  }
  
  private static <T> T a(Class paramClass, Class[] paramArrayOfClass, Object[] paramArrayOfObject) {
    if (paramClass == null)
      return null; 
    try {
      return (T)null.newInstance(paramArrayOfObject);
    } finally {
      paramClass = null;
      eh.a((Throwable)paramClass, "IFactory", "gIns2()");
    } 
  }
  
  public static void a(Context paramContext, String paramString) {
    try {
      return;
    } finally {
      paramContext = null;
      eh.a((Throwable)paramContext, "InstanceFactory", "rollBack");
    } 
  }
  
  public static boolean a(Context paramContext, da paramda) {
    try {
      if (!(new File(eb.a(paramContext))).exists())
        return false; 
      File file = new File(eb.b(paramContext, paramda.a(), paramda.b()));
      return false;
    } finally {
      paramContext = null;
      eh.a((Throwable)paramContext, "IFactory", "isdowned");
    } 
  }
  
  private static boolean a(ei paramei) {
    return (paramei != null && paramei.a() && paramei.d);
  }
  
  private static ei b(Context paramContext, da paramda) {
    if (paramContext == null)
      return null; 
    try {
      if (a(paramContext, paramda))
        return eg.b().a(paramContext, paramda); 
    } finally {
      paramContext = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\ef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */