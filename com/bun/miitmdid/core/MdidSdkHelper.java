package com.bun.miitmdid.core;

import android.content.Context;
import android.support.annotation.Keep;
import android.util.Log;
import com.bun.supplier.IIdentifierListener;
import com.bun.supplier.IdSupplier;
import com.bun.supplier.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Keep
public class MdidSdkHelper {
  public static String TAG = "MdidSdkHelper";
  
  @Keep
  public static boolean _OuterIsOk = true;
  
  @Keep
  private String sdk_date = "2020011018";
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  @Keep
  public static int InitSdk(Context paramContext, boolean paramBoolean, IIdentifierListener paramIIdentifierListener) {
    try {
      if (!_OuterIsOk) {
        if (paramIIdentifierListener != null)
          paramIIdentifierListener.OnSupport(false, (IdSupplier)new a()); 
        return 1008615;
      } 
      Class<?> clazz = Class.forName("com.bun.miitmdid.core.MdidSdk");
      if (clazz == null) {
        logd(paramBoolean, "not found class:" + "com.bun.miitmdid.core.MdidSdk");
        return 1008615;
      } 
      Constructor<?> constructor = clazz.getConstructor(new Class[] { boolean.class });
      if (constructor == null) {
        logd(paramBoolean, "not found MdidSdk Constructor");
        return 1008615;
      } 
      constructor = (Constructor<?>)constructor.newInstance(new Object[] { Boolean.valueOf(paramBoolean) });
      if (constructor == null) {
        logd(paramBoolean, "Create MdidSdk Instance failed");
        return 1008615;
      } 
      Method method = clazz.getDeclaredMethod("InitSdk", new Class[] { Context.class, IIdentifierListener.class });
      if (method == null) {
        logd(paramBoolean, "not found MdidSdk " + "InitSdk" + " function");
        return 1008615;
      } 
      int i = ((Integer)method.invoke(constructor, new Object[] { paramContext, paramIIdentifierListener })).intValue();
      logd(paramBoolean, "call and retvalue:" + i);
      return i;
    } catch (ClassNotFoundException classNotFoundException) {
    
    } catch (NoSuchMethodException noSuchMethodException) {
    
    } catch (IllegalAccessException illegalAccessException) {
    
    } catch (InstantiationException instantiationException) {
    
    } catch (InvocationTargetException invocationTargetException) {}
    loge(paramBoolean, invocationTargetException);
    logd(paramBoolean, "exception exit");
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\bun\miitmdid\core\MdidSdkHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */