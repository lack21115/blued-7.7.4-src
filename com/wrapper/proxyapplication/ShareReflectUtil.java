package com.wrapper.proxyapplication;

import android.content.Context;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ShareReflectUtil {
  public ShareReflectUtil() {
    throw new VerifyError("bad dex opcode");
  }
  
  public static void expandFieldArray(Object paramObject, String paramString, Object[] paramArrayOfObject) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
    findField(paramObject, paramString);
    throw new VerifyError("bad dex opcode");
  }
  
  public static Constructor<?> findConstructor(Object paramObject, Class<?>... paramVarArgs) throws NoSuchMethodException {
    throw new VerifyError("bad dex opcode");
  }
  
  public static Field findField(Class<?> paramClass, String paramString) throws NoSuchFieldException {
    if (paramClass != null)
      try {
        throw new VerifyError("bad dex opcode");
      } catch (NoSuchFieldException noSuchFieldException) {
        throw new VerifyError("bad dex opcode");
      }  
    new StringBuilder();
    throw new VerifyError("bad dex opcode");
  }
  
  public static Field findField(Object paramObject, String paramString) throws NoSuchFieldException {
    throw new VerifyError("bad dex opcode");
  }
  
  public static Method findMethod(Class<?> paramClass, String paramString, Class<?>... paramVarArgs) throws NoSuchMethodException {
    if (paramClass != null)
      try {
        throw new VerifyError("bad dex opcode");
      } catch (NoSuchMethodException noSuchMethodException) {
        throw new VerifyError("bad dex opcode");
      }  
    new StringBuilder();
    throw new VerifyError("bad dex opcode");
  }
  
  public static Method findMethod(Object paramObject, String paramString, Class<?>... paramVarArgs) throws NoSuchMethodException {
    throw new VerifyError("bad dex opcode");
  }
  
  public static Object getActivityThread(Context paramContext, Class<?> paramClass) {
    if (paramClass == null)
      try {
        Class.forName("android.app.ActivityThread");
        throw new VerifyError("bad dex opcode");
      } finally {
        paramContext = null;
      }  
    throw new VerifyError("bad dex opcode");
  }
  
  public static int getValueOfStaticIntField(Class<?> paramClass, String paramString, int paramInt) {
    try {
      findField(paramClass, paramString);
      throw new VerifyError("bad dex opcode");
    } finally {
      paramClass = null;
    } 
  }
  
  public static void reduceFieldArray(Object paramObject, String paramString, int paramInt) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
    if (paramInt <= 0)
      throw new VerifyError("bad dex opcode"); 
    findField(paramObject, paramString);
    throw new VerifyError("bad dex opcode");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\wrapper\proxyapplication\ShareReflectUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */