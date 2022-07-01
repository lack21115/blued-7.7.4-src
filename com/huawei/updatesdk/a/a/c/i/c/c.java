package com.huawei.updatesdk.a.a.c.i.c;

import com.huawei.updatesdk.a.a.b.a.a.a;
import java.lang.reflect.InvocationTargetException;

public class c implements a {
  private static final Object a = new Object();
  
  private static c b;
  
  public static Object b() {
    String str;
    StringBuilder stringBuilder;
    try {
      Class<?> clazz = Class.forName("android.telephony.MSimTelephonyManager");
      return clazz.getDeclaredMethod("getDefault", new Class[0]).invoke(clazz, new Object[0]);
    } catch (NoSuchMethodException noSuchMethodException) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(" getDefaultMSimTelephonyManager wrong ");
      str = noSuchMethodException.toString();
    } catch (IllegalAccessException illegalAccessException) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(" getDefaultMSimTelephonyManager wrong ");
      str = illegalAccessException.toString();
    } catch (IllegalArgumentException illegalArgumentException) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(" getDefaultMSimTelephonyManager wrong ");
      str = illegalArgumentException.toString();
    } catch (InvocationTargetException invocationTargetException) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(" getDefaultMSimTelephonyManager wrong ");
      str = invocationTargetException.toString();
    } catch (ClassNotFoundException classNotFoundException) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(" getDefaultMSimTelephonyManager wrong ");
      str = classNotFoundException.toString();
    } catch (Exception exception) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(" getDefaultMSimTelephonyManager wrong ");
      str = exception.toString();
    } 
    stringBuilder.append(str);
    a.b("MutiCardHwImpl", stringBuilder.toString());
    return null;
  }
  
  public static c c() {
    synchronized (a) {
      if (b == null)
        b = new c(); 
      return b;
    } 
  }
  
  public int a() {
    Object object;
    StringBuilder stringBuilder;
    try {
      object = b();
      if (object != null) {
        Class<?> clazz = object.getClass();
        object = clazz.getMethod("getPreferredDataSubscription", new Class[0]).invoke(object, new Object[0]);
        if (object instanceof Integer)
          return ((Integer)object).intValue(); 
      } 
      return 0;
    } catch (NoSuchMethodException noSuchMethodException) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(" getPreferredDataSubscription wrong ");
      object = noSuchMethodException.toString();
    } catch (IllegalAccessException illegalAccessException) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(" getPreferredDataSubscription wrong ");
      object = illegalAccessException.toString();
    } catch (InvocationTargetException invocationTargetException) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(" getPreferredDataSubscription wrong ");
      object = invocationTargetException.toString();
    } 
    stringBuilder.append((String)object);
    a.b("MutiCardHwImpl", stringBuilder.toString());
    return -1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\a\a\c\i\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */