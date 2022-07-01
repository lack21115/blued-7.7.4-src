package com.facebook.stetho.inspector.elements.android;

import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.Util;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

public class MethodInvoker {
  private static final List<TypedMethodInvoker<?>> invokers = Arrays.asList((TypedMethodInvoker<?>[])new TypedMethodInvoker[] { new StringMethodInvoker(), new CharSequenceMethodInvoker(), new IntegerMethodInvoker(), new FloatMethodInvoker(), new BooleanMethodInvoker() });
  
  public void invoke(Object paramObject, String paramString1, String paramString2) {
    Util.throwIfNull(paramObject, paramString1, paramString2);
    int j = invokers.size();
    int i;
    for (i = 0; i < j; i++) {
      if (((TypedMethodInvoker)invokers.get(i)).invoke(paramObject, paramString1, paramString2))
        return; 
    } 
    paramObject = new StringBuilder();
    paramObject.append("Method with name ");
    paramObject.append(paramString1);
    paramObject.append(" not found for any of the MethodInvoker supported argument types.");
    LogUtil.w(paramObject.toString());
  }
  
  static class BooleanMethodInvoker extends TypedMethodInvoker<Boolean> {
    BooleanMethodInvoker() {
      super((Class)boolean.class);
    }
    
    Boolean convertArgument(String param1String) {
      return Boolean.valueOf(Boolean.parseBoolean(param1String));
    }
  }
  
  static class CharSequenceMethodInvoker extends TypedMethodInvoker<CharSequence> {
    CharSequenceMethodInvoker() {
      super(CharSequence.class);
    }
    
    CharSequence convertArgument(String param1String) {
      return param1String;
    }
  }
  
  static class FloatMethodInvoker extends TypedMethodInvoker<Float> {
    FloatMethodInvoker() {
      super((Class)float.class);
    }
    
    Float convertArgument(String param1String) {
      return Float.valueOf(Float.parseFloat(param1String));
    }
  }
  
  static class IntegerMethodInvoker extends TypedMethodInvoker<Integer> {
    IntegerMethodInvoker() {
      super((Class)int.class);
    }
    
    Integer convertArgument(String param1String) {
      return Integer.valueOf(Integer.parseInt(param1String));
    }
  }
  
  static class StringMethodInvoker extends TypedMethodInvoker<String> {
    StringMethodInvoker() {
      super(String.class);
    }
    
    String convertArgument(String param1String) {
      return param1String;
    }
  }
  
  static abstract class TypedMethodInvoker<T> {
    private final Class<T> mArgType;
    
    TypedMethodInvoker(Class<T> param1Class) {
      this.mArgType = param1Class;
    }
    
    abstract T convertArgument(String param1String);
    
    boolean invoke(Object param1Object, String param1String1, String param1String2) {
      try {
        param1Object.getClass().getMethod(param1String1, new Class[] { this.mArgType }).invoke(param1Object, new Object[] { convertArgument(param1String2) });
        return true;
      } catch (NoSuchMethodException noSuchMethodException) {
        return false;
      } catch (InvocationTargetException invocationTargetException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("InvocationTargetException: ");
        stringBuilder.append(invocationTargetException.getMessage());
        LogUtil.w(stringBuilder.toString());
        return false;
      } catch (IllegalAccessException illegalAccessException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("IllegalAccessException: ");
        stringBuilder.append(illegalAccessException.getMessage());
        LogUtil.w(stringBuilder.toString());
        return false;
      } catch (IllegalArgumentException illegalArgumentException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("IllegalArgumentException: ");
        stringBuilder.append(illegalArgumentException.getMessage());
        LogUtil.w(stringBuilder.toString());
        return false;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\elements\android\MethodInvoker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */