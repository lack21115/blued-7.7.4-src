package com.google.common.reflect;

import com.google.common.base.Preconditions;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

abstract class TypeCapture<T> {
  final Type a() {
    Type type = getClass().getGenericSuperclass();
    Preconditions.a(type instanceof ParameterizedType, "%s isn't parameterized", type);
    return ((ParameterizedType)type).getActualTypeArguments()[0];
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\reflect\TypeCapture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */