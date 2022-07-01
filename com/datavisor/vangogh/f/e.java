package com.datavisor.vangogh.f;

import android.content.ContentResolver;
import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;

public class e {
  public static int a(Object paramObject, String paramString) {
    Field field = paramObject.getClass().getEnclosingClass().getDeclaredField(paramString);
    field.setAccessible(true);
    return ((Integer)field.get(paramObject)).intValue();
  }
  
  public static String a(Context paramContext) {
    try {
      TelephonyManager telephonyManager;
    } finally {
      paramContext = null;
      d.a((Throwable)paramContext);
    } 
  }
  
  public static String a(Object paramObject) {
    return (String)paramObject.getClass().getDeclaredMethod("getInterfaceDescriptor", new Class[0]).invoke(paramObject, new Object[0]);
  }
  
  private static String a(String paramString1, IBinder paramIBinder, String paramString2, int paramInt) {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken(paramString2);
      if (!TextUtils.isEmpty(paramString1))
        parcel1.writeString(paramString1); 
      paramIBinder.transact(paramInt, parcel1, parcel2, 0);
      parcel2.readException();
      paramString1 = parcel2.readString();
      return paramString1;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public static String b(Context paramContext) {
    try {
      Class<?> clazz = Class.forName("android.os.ServiceManager");
      Method method = clazz.getDeclaredMethod("getService", new Class[] { String.class });
      method.setAccessible(true);
      return "empty";
    } finally {
      paramContext = null;
    } 
  }
  
  public static String c(Context paramContext) {
    try {
      Class<?> clazz = Class.forName("android.os.ServiceManager");
      Method method = clazz.getDeclaredMethod("getService", new Class[] { String.class });
      method.setAccessible(true);
    } finally {
      paramContext = null;
    } 
  }
  
  public static String d(Context paramContext) {
    try {
      Class<?> clazz2 = Class.forName("android.os.UserHandle");
      Method method2 = clazz2.getDeclaredMethod("getUserId", new Class[] { int.class });
      method2.setAccessible(true);
      int i = ((Integer)method2.invoke((Object)null, new Object[] { Integer.valueOf(Process.myUid()) })).intValue();
      Class<?> clazz1 = Class.forName("android.provider.Settings$Secure");
      Method method1 = clazz1.getDeclaredMethod("getStringForUser", new Class[] { ContentResolver.class, String.class, int.class });
      return (String)method1.invoke((Object)null, new Object[] { paramContext.getContentResolver(), "android_id", Integer.valueOf(i) });
    } finally {
      paramContext = null;
    } 
  }
  
  public static String e(Context paramContext) {
    try {
      ContentResolver contentResolver = paramContext.getContentResolver();
      Class<?> clazz = Class.forName("android.os.UserHandle");
      Method method = clazz.getDeclaredMethod("getUserId", new Class[] { int.class });
      method.setAccessible(true);
      int i = ((Integer)method.invoke((Object)null, new Object[] { Integer.valueOf(Process.myUid()) })).intValue();
      HashSet hashSet1 = new HashSet();
      HashSet hashSet2 = new HashSet();
      HashSet hashSet3 = new HashSet();
      try {
        Class<?> clazz1 = Class.forName("android.provider.Settings$Global");
        Field field1 = clazz1.getDeclaredField("MOVED_TO_SECURE");
        field1.setAccessible(true);
        HashSet hashSet = (HashSet)field1.get(clazz1);
        hashSet1 = hashSet;
      } finally {
        Exception exception;
      } 
      try {
        Class<?> clazz1 = Class.forName("android.provider.Settings$Secure");
        Field field1 = clazz1.getDeclaredField("MOVED_TO_LOCK_SETTINGS");
        field1.setAccessible(true);
        HashSet hashSet = (HashSet)field1.get(clazz1);
        hashSet2 = hashSet;
      } finally {
        Exception exception;
      } 
      try {
        Class<?> clazz1 = Class.forName("android.provider.Settings$Secure");
        Field field1 = clazz1.getDeclaredField("MOVED_TO_GLOBAL");
        field1.setAccessible(true);
        HashSet hashSet = (HashSet)field1.get(clazz1);
        hashSet3 = hashSet;
      } finally {
        Exception exception;
      } 
      boolean bool = hashSet1.contains("android_id");
      if (!bool) {
        if (hashSet3.contains("android_id")) {
          Method method1 = Class.forName("android.provider.Global").getDeclaredMethod("getStringForUser", new Class[] { ContentResolver.class, String.class, int.class });
          return (String)method1.invoke((Object)null, new Object[] { contentResolver, "android_id", Integer.valueOf(i) });
        } 
        if (hashSet2.contains("android_id")) {
          boolean bool1;
          Class<?> clazz1 = Class.forName("android.os.ServiceManager");
          Method method1 = clazz1.getDeclaredMethod("getService", new Class[0]);
          method1.setAccessible(true);
          IBinder iBinder = (IBinder)method1.invoke((Object)null, new Object[] { "lock_settings" });
          Class<?> clazz2 = Class.forName("com.android.internal.widget.ILockSettings$Stub");
          Method method2 = clazz2.getDeclaredMethod("asInterface", new Class[] { IBinder.class });
          method2.setAccessible(true);
          Object<?> object = (Object<?>)method2.invoke((Object)null, new Object[] { iBinder });
          if (Process.myUid() == 1000) {
            bool1 = true;
          } else {
            bool1 = false;
          } 
          if (hashSet2.contains("android_id") && object != null && !bool1)
            return (String)object.getDeclaredMethod("getString", new Class[] { String.class, String.class, int.class }).invoke("android_id", new Object[] { "0", Integer.valueOf(i) }); 
        } 
      } 
      Field field = Class.forName("android.provider.Settings$Secure").getDeclaredField("sNameValueCache");
      field.setAccessible(true);
      return (String)null.getClass().getDeclaredMethod("getStringForUser", new Class[] { ContentResolver.class, String.class, int.class }).invoke(null, new Object[] { contentResolver, "android_id", Integer.valueOf(i) });
    } finally {
      paramContext = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\datavisor\vangogh\f\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */