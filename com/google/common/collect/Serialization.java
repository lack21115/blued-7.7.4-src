package com.google.common.collect;

import java.lang.reflect.Field;

final class Serialization {
  static <T> FieldSetter<T> a(Class<T> paramClass, String paramString) {
    try {
      return new FieldSetter(paramClass.getDeclaredField(paramString));
    } catch (NoSuchFieldException noSuchFieldException) {
      throw new AssertionError(noSuchFieldException);
    } 
  }
  
  static final class FieldSetter<T> {
    private final Field a;
    
    private FieldSetter(Field param1Field) {
      this.a = param1Field;
      param1Field.setAccessible(true);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\Serialization.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */