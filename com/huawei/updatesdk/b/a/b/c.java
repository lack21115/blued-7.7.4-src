package com.huawei.updatesdk.b.a.b;

import android.util.ArrayMap;
import android.util.ArraySet;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.security.PublicKey;

class c {
  static a a(File paramFile) {
    a a = new a();
    Object object = b(paramFile);
    if (object != null) {
      Object object1 = a(object, "mKeySetMapping");
      if (object1 instanceof ArrayMap)
        a.a = (ArrayMap<String, ArraySet<PublicKey>>)object1; 
      object = a(object, "mUpgradeKeySets");
      if (object instanceof ArraySet)
        a.b = (ArraySet<String>)object; 
    } 
    return a;
  }
  
  private static Object a(Object paramObject, String paramString) {
    String str;
    try {
      return Class.forName("android.content.pm.PackageParser$Package").getDeclaredField(paramString).get(paramObject);
    } catch (ClassNotFoundException classNotFoundException) {
      str = "can not find class,ClassNotFoundException";
    } catch (NoSuchFieldException noSuchFieldException) {
      str = "can not find field,NoSuchFieldException";
    } catch (IllegalAccessException illegalAccessException) {
      str = "can not find field,IllegalAccessException";
    } catch (NoSuchFieldError noSuchFieldError) {
      str = "can not find field,NoSuchFieldError";
    } 
    com.huawei.updatesdk.a.a.b.a.a.a.c("KeySetsUtils", str);
    return null;
  }
  
  private static Object b(File paramFile) {
    String str;
    try {
      Class<?> clazz = Class.forName("android.content.pm.PackageParser");
      return clazz.getDeclaredMethod("parsePackage", new Class[] { File.class, int.class }).invoke(clazz.newInstance(), new Object[] { paramFile, Integer.valueOf(0) });
    } catch (ClassNotFoundException classNotFoundException) {
      str = "can not get PackageParser,ClassNotFoundException";
    } catch (NoSuchMethodException noSuchMethodException) {
      str = "can not get PackageParser,NoSuchMethodException";
    } catch (InstantiationException instantiationException) {
      str = "can not get PackageParser,InstantiationException";
    } catch (IllegalAccessException illegalAccessException) {
      str = "can not get PackageParser,IllegalAccessException";
    } catch (InvocationTargetException invocationTargetException) {
      str = "can not get PackageParser,InvocationTargetException";
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("can not get PackageParser,");
      stringBuilder.append(exception.getMessage());
      str = stringBuilder.toString();
    } 
    com.huawei.updatesdk.a.a.b.a.a.a.c("KeySetsUtils", str);
    return null;
  }
  
  static class a {
    ArrayMap<String, ArraySet<PublicKey>> a = null;
    
    ArraySet<String> b = null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\b\a\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */