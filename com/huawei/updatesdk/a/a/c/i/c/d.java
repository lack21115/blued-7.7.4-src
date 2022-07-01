package com.huawei.updatesdk.a.a.c.i.c;

import com.huawei.updatesdk.a.a.b.a.a.a;
import java.lang.reflect.InvocationTargetException;

public final class d implements a {
  private static final Object a = new Object();
  
  private static d b;
  
  private static Object b() {
    String str;
    StringBuilder stringBuilder;
    try {
      Class<?> clazz = Class.forName("com.mediatek.telephony.TelephonyManagerEx");
      return clazz.getDeclaredMethod("getDefault", new Class[0]).invoke(clazz, new Object[0]);
    } catch (ClassNotFoundException classNotFoundException) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(" getDefaultTelephonyManagerEx wrong ");
      str = classNotFoundException.toString();
    } catch (SecurityException securityException) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(" getDefaultTelephonyManagerEx wrong ");
      str = securityException.toString();
    } catch (NoSuchMethodException noSuchMethodException) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(" getDefaultTelephonyManagerEx wrong ");
      str = noSuchMethodException.toString();
    } catch (IllegalAccessException illegalAccessException) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(" getDefaultTelephonyManagerEx wrong ");
      str = illegalAccessException.toString();
    } catch (IllegalArgumentException illegalArgumentException) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(" getDefaultTelephonyManagerEx wrong ");
      str = illegalArgumentException.toString();
    } catch (InvocationTargetException invocationTargetException) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(" getDefaultTelephonyManagerEx wrong ");
      str = invocationTargetException.toString();
    } catch (Exception exception) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(" getDefaultTelephonyManagerEx wrong ");
      str = exception.toString();
    } 
    stringBuilder.append(str);
    a.b("mutiCardMTKImpl", stringBuilder.toString());
    return null;
  }
  
  public static d c() {
    synchronized (a) {
      if (b == null)
        b = new d(); 
      return b;
    } 
  }
  
  public int a() {
    Object object = b();
    if (object != null)
      try {
        Class<?> clazz = object.getClass();
        object = clazz.getMethod("getPreferredDataSubscription", new Class[0]).invoke(object, new Object[0]);
        if (object instanceof Integer)
          return ((Integer)object).intValue(); 
      } catch (NoSuchMethodException noSuchMethodException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" getPreferredDataSubscription wrong ");
        String str = noSuchMethodException.toString();
        stringBuilder.append(str);
        a.b("mutiCardMTKImpl", stringBuilder.toString());
        return -1;
      } catch (InvocationTargetException invocationTargetException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" getPreferredDataSubscription wrong ");
        String str = invocationTargetException.toString();
      } catch (IllegalAccessException illegalAccessException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" getPreferredDataSubscription wrong ");
        String str = illegalAccessException.toString();
      }  
    return 0;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\a\a\c\i\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */