package com.bun.miitmdid.core;

import android.content.Context;
import android.util.Log;
import com.bun.supplier.IIdentifierListener;
import com.bun.supplier.IdSupplier;
import com.bun.supplier.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MdidSdkHelper {
  public static String TAG = "MdidSdkHelper";
  
  public static boolean _OuterIsOk = true;
  
  private String sdk_date = "2020011018";
  
  public static int InitSdk(Context paramContext, boolean paramBoolean, IIdentifierListener paramIIdentifierListener) {
    try {
      if (!_OuterIsOk) {
        if (paramIIdentifierListener != null) {
          paramIIdentifierListener.OnSupport(false, (IdSupplier)new a());
          return 1008615;
        } 
      } else {
        String str;
        Class<?> clazz = Class.forName("com.bun.miitmdid.core.MdidSdk");
        if (clazz == null) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("not found class:");
          stringBuilder1.append("com.bun.miitmdid.core.MdidSdk");
          str = stringBuilder1.toString();
          logd(paramBoolean, str);
          return 1008615;
        } 
        Constructor<?> constructor = clazz.getConstructor(new Class[] { boolean.class });
        if (constructor == null) {
          str = "not found MdidSdk Constructor";
          logd(paramBoolean, str);
          return 1008615;
        } 
        constructor = (Constructor<?>)constructor.newInstance(new Object[] { Boolean.valueOf(paramBoolean) });
        if (constructor == null) {
          str = "Create MdidSdk Instance failed";
          logd(paramBoolean, str);
          return 1008615;
        } 
        Method method = clazz.getDeclaredMethod("InitSdk", new Class[] { Context.class, IIdentifierListener.class });
        if (method == null) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("not found MdidSdk ");
          stringBuilder1.append("InitSdk");
          stringBuilder1.append(" function");
          str = stringBuilder1.toString();
          logd(paramBoolean, str);
          return 1008615;
        } 
        int i = ((Integer)method.invoke(constructor, new Object[] { str, paramIIdentifierListener })).intValue();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("call and retvalue:");
        stringBuilder.append(i);
        logd(paramBoolean, stringBuilder.toString());
        return i;
      } 
    } catch (ClassNotFoundException classNotFoundException) {
      loge(paramBoolean, classNotFoundException);
      logd(paramBoolean, "exception exit");
    } catch (NoSuchMethodException noSuchMethodException) {
    
    } catch (IllegalAccessException illegalAccessException) {
    
    } catch (InstantiationException instantiationException) {
    
    } catch (InvocationTargetException invocationTargetException) {}
    return 1008615;
  }
  
  public static void logd(boolean paramBoolean, String paramString) {
    if (!paramBoolean)
      return; 
    Log.d(TAG, paramString);
  }
  
  public static void loge(boolean paramBoolean, Exception paramException) {
    if (!paramBoolean)
      return; 
    Log.e(TAG, paramException.getClass().getSimpleName(), paramException);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bun\miitmdid\core\MdidSdkHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */