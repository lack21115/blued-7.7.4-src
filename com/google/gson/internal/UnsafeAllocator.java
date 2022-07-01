package com.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public abstract class UnsafeAllocator {
  static void assertInstantiable(Class<?> paramClass) {
    int i = paramClass.getModifiers();
    if (!Modifier.isInterface(i)) {
      if (!Modifier.isAbstract(i))
        return; 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Abstract class can't be instantiated! Class name: ");
      stringBuilder1.append(paramClass.getName());
      throw new UnsupportedOperationException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Interface can't be instantiated! Interface name: ");
    stringBuilder.append(paramClass.getName());
    throw new UnsupportedOperationException(stringBuilder.toString());
  }
  
  public static UnsafeAllocator create() {
    try {
      Class<?> clazz = Class.forName("sun.misc.Unsafe");
      Field field = clazz.getDeclaredField("theUnsafe");
      field.setAccessible(true);
      final Object unsafe = field.get((Object)null);
      return new UnsafeAllocator() {
          public <T> T newInstance(Class<T> param1Class) throws Exception {
            assertInstantiable(param1Class);
            return (T)allocateInstance.invoke(unsafe, new Object[] { param1Class });
          }
        };
    } catch (Exception exception) {
      try {
        final Method newInstance = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[] { Class.class });
        method.setAccessible(true);
        final int constructorId = ((Integer)method.invoke((Object)null, new Object[] { Object.class })).intValue();
        method = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[] { Class.class, int.class });
        method.setAccessible(true);
        return new UnsafeAllocator() {
            public <T> T newInstance(Class<T> param1Class) throws Exception {
              assertInstantiable(param1Class);
              return (T)newInstance.invoke((Object)null, new Object[] { param1Class, Integer.valueOf(this.val$constructorId) });
            }
          };
      } catch (Exception exception1) {
        try {
          final Method newInstance = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[] { Class.class, Class.class });
          method.setAccessible(true);
          return new UnsafeAllocator() {
              public <T> T newInstance(Class<T> param1Class) throws Exception {
                assertInstantiable(param1Class);
                return (T)newInstance.invoke((Object)null, new Object[] { param1Class, Object.class });
              }
            };
        } catch (Exception exception2) {
          return new UnsafeAllocator() {
              public <T> T newInstance(Class<T> param1Class) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Cannot allocate ");
                stringBuilder.append(param1Class);
                throw new UnsupportedOperationException(stringBuilder.toString());
              }
            };
        } 
      } 
    } 
  }
  
  public abstract <T> T newInstance(Class<T> paramClass) throws Exception;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\gson\internal\UnsafeAllocator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */