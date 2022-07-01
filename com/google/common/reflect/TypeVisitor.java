package com.google.common.reflect;

import com.google.common.collect.Sets;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Set;

abstract class TypeVisitor {
  private final Set<Type> a = Sets.a();
  
  void a(Class<?> paramClass) {}
  
  void a(GenericArrayType paramGenericArrayType) {}
  
  void a(ParameterizedType paramParameterizedType) {}
  
  void a(TypeVariable<?> paramTypeVariable) {}
  
  void a(WildcardType paramWildcardType) {}
  
  public final void a(Type... paramVarArgs) {
    int j = paramVarArgs.length;
    for (int i = 0; i < j; i++) {
      Type type = paramVarArgs[i];
      if (type != null && this.a.add(type))
        try {
        
        } finally {
          this.a.remove(type);
        }  
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\reflect\TypeVisitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */