package android.arch.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ReflectiveGenericLifecycleObserver implements GenericLifecycleObserver {
  private static Map sInfoCache = new HashMap<Object, Object>();
  
  private final ReflectiveGenericLifecycleObserver$CallbackInfo mInfo;
  
  private final Object mWrapped;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  ReflectiveGenericLifecycleObserver(Object paramObject) {
    this.mWrapped = paramObject;
    this.mInfo = getInfo(this.mWrapped.getClass());
  }
  
  private static ReflectiveGenericLifecycleObserver$CallbackInfo getInfo(Class<?> paramClass) {
    ReflectiveGenericLifecycleObserver$CallbackInfo reflectiveGenericLifecycleObserver$CallbackInfo2 = (ReflectiveGenericLifecycleObserver$CallbackInfo)sInfoCache.get(paramClass);
    if (reflectiveGenericLifecycleObserver$CallbackInfo2 != null)
      return reflectiveGenericLifecycleObserver$CallbackInfo2; 
    Class clazz = paramClass.getSuperclass();
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    if (clazz != null) {
      ReflectiveGenericLifecycleObserver$CallbackInfo reflectiveGenericLifecycleObserver$CallbackInfo = getInfo(clazz);
      if (reflectiveGenericLifecycleObserver$CallbackInfo != null)
        hashMap.putAll(reflectiveGenericLifecycleObserver$CallbackInfo.mHandlerToEvent); 
    } 
    Method[] arrayOfMethod = paramClass.getDeclaredMethods();
    Class[] arrayOfClass = paramClass.getInterfaces();
    int j = arrayOfClass.length;
    int i;
    for (i = 0; i < j; i++) {
      for (Map.Entry entry : (getInfo(arrayOfClass[i])).mHandlerToEvent.entrySet())
        verifyAndPutHandler(hashMap, (ReflectiveGenericLifecycleObserver$MethodReference)entry.getKey(), (Lifecycle$Event)entry.getValue(), paramClass); 
    } 
    int k = arrayOfMethod.length;
    for (j = 0; j < k; j++) {
      Method method = arrayOfMethod[j];
      OnLifecycleEvent onLifecycleEvent = method.<OnLifecycleEvent>getAnnotation(OnLifecycleEvent.class);
      if (onLifecycleEvent != null) {
        Class[] arrayOfClass1 = method.getParameterTypes();
        if (arrayOfClass1.length > 0) {
          if (arrayOfClass1[0].isAssignableFrom(LifecycleOwner.class)) {
            i = 1;
          } else {
            throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
          } 
        } else {
          i = 0;
        } 
        Lifecycle$Event lifecycle$Event = onLifecycleEvent.value();
        if (arrayOfClass1.length > 1)
          if (arrayOfClass1[1].isAssignableFrom(Lifecycle$Event.class)) {
            if (lifecycle$Event == Lifecycle$Event.ON_ANY) {
              i = 2;
            } else {
              throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
            } 
          } else {
            throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
          }  
        if (arrayOfClass1.length <= 2) {
          verifyAndPutHandler(hashMap, new ReflectiveGenericLifecycleObserver$MethodReference(i, method), lifecycle$Event, paramClass);
        } else {
          throw new IllegalArgumentException("cannot have more than 2 params");
        } 
      } 
    } 
    ReflectiveGenericLifecycleObserver$CallbackInfo reflectiveGenericLifecycleObserver$CallbackInfo1 = new ReflectiveGenericLifecycleObserver$CallbackInfo(hashMap);
    sInfoCache.put(paramClass, reflectiveGenericLifecycleObserver$CallbackInfo1);
    return reflectiveGenericLifecycleObserver$CallbackInfo1;
  }
  
  private void invokeMethodsForEvent(List<ReflectiveGenericLifecycleObserver$MethodReference> paramList, LifecycleOwner paramLifecycleOwner, Lifecycle$Event paramLifecycle$Event) {
    if (paramList != null) {
      int i = paramList.size() - 1;
      while (i >= 0) {
        ReflectiveGenericLifecycleObserver$MethodReference reflectiveGenericLifecycleObserver$MethodReference = paramList.get(i);
        try {
          switch (reflectiveGenericLifecycleObserver$MethodReference.mCallType) {
            case 2:
              reflectiveGenericLifecycleObserver$MethodReference.mMethod.invoke(this.mWrapped, new Object[] { paramLifecycleOwner, paramLifecycle$Event });
              break;
            case 1:
              reflectiveGenericLifecycleObserver$MethodReference.mMethod.invoke(this.mWrapped, new Object[] { paramLifecycleOwner });
              break;
            case 0:
              reflectiveGenericLifecycleObserver$MethodReference.mMethod.invoke(this.mWrapped, new Object[0]);
              break;
          } 
          i--;
        } catch (InvocationTargetException invocationTargetException) {
          throw new RuntimeException("Failed to call observer method", invocationTargetException.getCause());
        } catch (IllegalAccessException illegalAccessException) {
          throw new RuntimeException(illegalAccessException);
        } 
      } 
    } 
  }
  
  private static void verifyAndPutHandler(Map<ReflectiveGenericLifecycleObserver$MethodReference, Lifecycle$Event> paramMap, ReflectiveGenericLifecycleObserver$MethodReference paramReflectiveGenericLifecycleObserver$MethodReference, Lifecycle$Event paramLifecycle$Event, Class paramClass) {
    Lifecycle$Event lifecycle$Event = (Lifecycle$Event)paramMap.get(paramReflectiveGenericLifecycleObserver$MethodReference);
    if (lifecycle$Event == null || paramLifecycle$Event == lifecycle$Event) {
      if (lifecycle$Event == null)
        paramMap.put(paramReflectiveGenericLifecycleObserver$MethodReference, paramLifecycle$Event); 
      return;
    } 
    Method method = paramReflectiveGenericLifecycleObserver$MethodReference.mMethod;
    StringBuilder stringBuilder = new StringBuilder("Method ");
    stringBuilder.append(method.getName());
    stringBuilder.append(" in ");
    stringBuilder.append(paramClass.getName());
    stringBuilder.append(" already declared with different @OnLifecycleEvent value: previous value ");
    stringBuilder.append(lifecycle$Event);
    stringBuilder.append(", new value ");
    stringBuilder.append(paramLifecycle$Event);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public final void onStateChanged(LifecycleOwner paramLifecycleOwner, Lifecycle$Event paramLifecycle$Event) {
    ReflectiveGenericLifecycleObserver$CallbackInfo reflectiveGenericLifecycleObserver$CallbackInfo = this.mInfo;
    invokeMethodsForEvent((List)reflectiveGenericLifecycleObserver$CallbackInfo.mEventToHandlers.get(paramLifecycle$Event), paramLifecycleOwner, paramLifecycle$Event);
    invokeMethodsForEvent((List)reflectiveGenericLifecycleObserver$CallbackInfo.mEventToHandlers.get(Lifecycle$Event.ON_ANY), paramLifecycleOwner, paramLifecycle$Event);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\arch\lifecycle\ReflectiveGenericLifecycleObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */