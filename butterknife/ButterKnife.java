package butterknife;

import android.util.Log;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

public final class ButterKnife {
  static final Map<Class<?>, Constructor<? extends Unbinder>> a = new LinkedHashMap<Class<?>, Constructor<? extends Unbinder>>();
  
  private static boolean b = false;
  
  private ButterKnife() {
    throw new AssertionError("No instances.");
  }
  
  public static Unbinder a(Object paramObject, View paramView) {
    Class<?> clazz = paramObject.getClass();
    if (b) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Looking up binding for ");
      stringBuilder.append(clazz.getName());
      Log.d("ButterKnife", stringBuilder.toString());
    } 
    Constructor<? extends Unbinder> constructor = a(clazz);
    if (constructor == null)
      return Unbinder.a; 
    try {
      return constructor.newInstance(new Object[] { paramObject, paramView });
    } catch (IllegalAccessException illegalAccessException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unable to invoke ");
      stringBuilder.append(constructor);
      throw new RuntimeException(stringBuilder.toString(), illegalAccessException);
    } catch (InstantiationException instantiationException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unable to invoke ");
      stringBuilder.append(constructor);
      throw new RuntimeException(stringBuilder.toString(), instantiationException);
    } catch (InvocationTargetException invocationTargetException) {
      Throwable throwable = invocationTargetException.getCause();
      if (!(throwable instanceof RuntimeException)) {
        if (throwable instanceof Error)
          throw (Error)throwable; 
        throw new RuntimeException("Unable to create binding instance.", throwable);
      } 
      throw (RuntimeException)throwable;
    } 
  }
  
  private static Constructor<? extends Unbinder> a(Class<?> paramClass) {
    StringBuilder stringBuilder;
    Constructor<? extends Unbinder> constructor = a.get(paramClass);
    if (constructor != null || a.containsKey(paramClass)) {
      if (b)
        Log.d("ButterKnife", "HIT: Cached in binding map."); 
      return constructor;
    } 
    String str = paramClass.getName();
    if (str.startsWith("android.") || str.startsWith("java.") || str.startsWith("androidx.")) {
      if (b)
        Log.d("ButterKnife", "MISS: Reached framework class. Abandoning search."); 
      return null;
    } 
    try {
      ClassLoader classLoader = paramClass.getClassLoader();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str);
      stringBuilder1.append("_ViewBinding");
      Constructor<?> constructor2 = classLoader.loadClass(stringBuilder1.toString()).getConstructor(new Class[] { paramClass, View.class });
      Constructor<?> constructor1 = constructor2;
      if (b) {
        Log.d("ButterKnife", "HIT: Loaded binding class and constructor.");
        constructor1 = constructor2;
      } 
    } catch (ClassNotFoundException classNotFoundException) {
      if (b) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("Not found. Trying superclass ");
        stringBuilder.append(paramClass.getSuperclass().getName());
        Log.d("ButterKnife", stringBuilder.toString());
      } 
      Constructor<? extends Unbinder> constructor1 = a(paramClass.getSuperclass());
    } catch (NoSuchMethodException noSuchMethodException) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("Unable to find binding constructor for ");
      stringBuilder.append(str);
      throw new RuntimeException(stringBuilder.toString(), noSuchMethodException);
    } 
    a.put(noSuchMethodException, stringBuilder);
    return (Constructor<? extends Unbinder>)stringBuilder;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\butterknife\ButterKnife.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */