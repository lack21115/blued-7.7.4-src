package com.huawei.updatesdk.a.a.c.i.c;

import com.huawei.updatesdk.a.a.b.a.a.a;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class b {
  private static a.a a = a.a.a;
  
  private static a b;
  
  public static a a() {
    c c;
    d();
    if (a == a.a.d) {
      d d = d.c();
    } else {
      c = c.c();
    } 
    b = c;
    return b;
  }
  
  public static boolean b() {
    boolean bool1;
    boolean bool2 = false;
    try {
      Object object = c.b();
      bool1 = bool2;
      if (object != null) {
        Class<?> clazz = object.getClass();
        object = clazz.getMethod("isMultiSimEnabled", new Class[0]).invoke(object, new Object[0]);
        bool1 = bool2;
        if (object instanceof Boolean)
          bool1 = ((Boolean)object).booleanValue(); 
      } 
    } catch (NoSuchMethodException noSuchMethodException) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("MSimTelephonyManager.getDefault().isMultiSimEnabled()?");
      stringBuilder1.append(noSuchMethodException.toString());
      String str = stringBuilder1.toString();
      a.b("mutiCardFactory", str);
      bool1 = bool2;
    } catch (IllegalAccessException illegalAccessException) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("MSimTelephonyManager.getDefault().isMultiSimEnabled()");
      String str = illegalAccessException.toString();
      stringBuilder1.append(str);
      str = stringBuilder1.toString();
    } catch (InvocationTargetException invocationTargetException) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("MSimTelephonyManager.getDefault().isMultiSimEnabled()");
      String str = invocationTargetException.toString();
      stringBuilder1.append(str);
      str = stringBuilder1.toString();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("isHwGeminiSupport1 ");
    stringBuilder.append(bool1);
    a.a("mutiCardFactory", stringBuilder.toString());
    return bool1;
  }
  
  private static boolean c() {
    boolean bool;
    try {
      Field field = Class.forName("com.mediatek.common.featureoption.FeatureOption").getDeclaredField("MTK_GEMINI_SUPPORT");
      field.setAccessible(true);
      bool = field.getBoolean((Object)null);
    } catch (ClassNotFoundException classNotFoundException) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("FeatureOption.MTK_GEMINI_SUPPORT");
      String str = classNotFoundException.toString();
      stringBuilder1.append(str);
      a.d("mutiCardFactory", stringBuilder1.toString());
      bool = false;
    } catch (NoSuchFieldException noSuchFieldException) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("FeatureOption.MTK_GEMINI_SUPPORT");
      String str = noSuchFieldException.toString();
    } catch (IllegalAccessException illegalAccessException) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("FeatureOption.MTK_GEMINI_SUPPORT");
      String str = illegalAccessException.toString();
    } catch (Exception exception) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("FeatureOption.MTK_GEMINI_SUPPORT");
      String str = exception.toString();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("isMtkGeminiSupport ");
    stringBuilder.append(bool);
    a.a("mutiCardFactory", stringBuilder.toString());
    return bool;
  }
  
  public static boolean d() {
    a.a a1 = a;
    a.a a2 = a.a.a;
    null = true;
    if (a1 != a2) {
      if (a != a.a.c) {
        if (a == a.a.d)
          return true; 
      } else {
        return null;
      } 
    } else {
      if (c()) {
        a1 = a.a.d;
        a = a1;
        return true;
      } 
      if (b()) {
        a1 = a.a.c;
        a = a1;
        return true;
      } 
      a = a.a.b;
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\a\a\c\i\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */