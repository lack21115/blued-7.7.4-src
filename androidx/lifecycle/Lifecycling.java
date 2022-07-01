package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lifecycling {
  private static final int GENERATED_CALLBACK = 2;
  
  private static final int REFLECTIVE_CALLBACK = 1;
  
  private static Map<Class<?>, Integer> sCallbackCache = new HashMap<Class<?>, Integer>();
  
  private static Map<Class<?>, List<Constructor<? extends GeneratedAdapter>>> sClassToAdapters = new HashMap<Class<?>, List<Constructor<? extends GeneratedAdapter>>>();
  
  private static GeneratedAdapter createGeneratedAdapter(Constructor<? extends GeneratedAdapter> paramConstructor, Object paramObject) {
    try {
      return paramConstructor.newInstance(new Object[] { paramObject });
    } catch (IllegalAccessException illegalAccessException) {
      throw new RuntimeException(illegalAccessException);
    } catch (InstantiationException instantiationException) {
      throw new RuntimeException(instantiationException);
    } catch (InvocationTargetException invocationTargetException) {
      throw new RuntimeException(invocationTargetException);
    } 
  }
  
  private static Constructor<? extends GeneratedAdapter> generatedConstructor(Class<?> paramClass) {
    try {
      String str1;
      Package package_ = paramClass.getPackage();
      String str2 = paramClass.getCanonicalName();
      if (package_ != null) {
        str1 = package_.getName();
      } else {
        str1 = "";
      } 
      if (!str1.isEmpty())
        str2 = str2.substring(str1.length() + 1); 
      str2 = getAdapterName(str2);
      if (str1.isEmpty()) {
        str1 = str2;
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str1);
        stringBuilder.append(".");
        stringBuilder.append(str2);
        str1 = stringBuilder.toString();
      } 
      Constructor<?> constructor = Class.forName(str1).getDeclaredConstructor(new Class[] { paramClass });
      if (!constructor.isAccessible())
        constructor.setAccessible(true); 
      return (Constructor)constructor;
    } catch (ClassNotFoundException classNotFoundException) {
      return null;
    } catch (NoSuchMethodException noSuchMethodException) {
      throw new RuntimeException(noSuchMethodException);
    } 
  }
  
  public static String getAdapterName(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString.replace(".", "_"));
    stringBuilder.append("_LifecycleAdapter");
    return stringBuilder.toString();
  }
  
  @Deprecated
  static GenericLifecycleObserver getCallback(Object paramObject) {
    return new GenericLifecycleObserver(lifecycleEventObserver(paramObject)) {
        public void onStateChanged(LifecycleOwner param1LifecycleOwner, Lifecycle.Event param1Event) {
          observer.onStateChanged(param1LifecycleOwner, param1Event);
        }
      };
  }
  
  private static int getObserverConstructorType(Class<?> paramClass) {
    Integer integer = sCallbackCache.get(paramClass);
    if (integer != null)
      return integer.intValue(); 
    int i = resolveObserverCallbackType(paramClass);
    sCallbackCache.put(paramClass, Integer.valueOf(i));
    return i;
  }
  
  private static boolean isLifecycleParent(Class<?> paramClass) {
    return (paramClass != null && LifecycleObserver.class.isAssignableFrom(paramClass));
  }
  
  static LifecycleEventObserver lifecycleEventObserver(Object paramObject) {
    boolean bool1 = paramObject instanceof LifecycleEventObserver;
    boolean bool2 = paramObject instanceof FullLifecycleObserver;
    if (bool1 && bool2)
      return new FullLifecycleObserverAdapter((FullLifecycleObserver)paramObject, (LifecycleEventObserver)paramObject); 
    if (bool2)
      return new FullLifecycleObserverAdapter((FullLifecycleObserver)paramObject, null); 
    if (bool1)
      return (LifecycleEventObserver)paramObject; 
    Class<?> clazz = paramObject.getClass();
    if (getObserverConstructorType(clazz) == 2) {
      List<Constructor<? extends GeneratedAdapter>> list = sClassToAdapters.get(clazz);
      int j = list.size();
      int i = 0;
      if (j == 1)
        return new SingleGeneratedAdapterObserver(createGeneratedAdapter(list.get(0), paramObject)); 
      GeneratedAdapter[] arrayOfGeneratedAdapter = new GeneratedAdapter[list.size()];
      while (i < list.size()) {
        arrayOfGeneratedAdapter[i] = createGeneratedAdapter(list.get(i), paramObject);
        i++;
      } 
      return new CompositeGeneratedAdaptersObserver(arrayOfGeneratedAdapter);
    } 
    return new ReflectiveGenericLifecycleObserver(paramObject);
  }
  
  private static int resolveObserverCallbackType(Class<?> paramClass) {
    ArrayList<Constructor<? extends GeneratedAdapter>> arrayList;
    if (paramClass.getCanonicalName() == null)
      return 1; 
    Constructor<? extends GeneratedAdapter> constructor = generatedConstructor(paramClass);
    if (constructor != null) {
      sClassToAdapters.put(paramClass, Collections.singletonList(constructor));
      return 2;
    } 
    if (ClassesInfoCache.sInstance.hasLifecycleMethods(paramClass))
      return 1; 
    Class<?> clazz = paramClass.getSuperclass();
    constructor = null;
    if (isLifecycleParent(clazz)) {
      if (getObserverConstructorType(clazz) == 1)
        return 1; 
      arrayList = new ArrayList(sClassToAdapters.get(clazz));
    } 
    for (Class<?> clazz1 : paramClass.getInterfaces()) {
      if (isLifecycleParent(clazz1)) {
        if (getObserverConstructorType(clazz1) == 1)
          return 1; 
        ArrayList<Constructor<? extends GeneratedAdapter>> arrayList1 = arrayList;
        if (arrayList == null)
          arrayList1 = new ArrayList(); 
        arrayList1.addAll(sClassToAdapters.get(clazz1));
        arrayList = arrayList1;
      } 
    } 
    if (arrayList != null) {
      sClassToAdapters.put(paramClass, arrayList);
      return 2;
    } 
    return 1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\lifecycle\Lifecycling.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */