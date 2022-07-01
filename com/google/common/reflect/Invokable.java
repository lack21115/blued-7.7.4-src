package com.google.common.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class Invokable<T, R> extends Element implements GenericDeclaration {
  public TypeToken<T> a() {
    return TypeToken.a((Class)getDeclaringClass());
  }
  
  abstract Type[] b();
  
  public final Class<? super T> getDeclaringClass() {
    return (Class)super.getDeclaringClass();
  }
  
  static class ConstructorInvokable<T> extends Invokable<T, T> {
    final Constructor<?> a;
    
    private boolean c() {
      Class<?> clazz = this.a.getDeclaringClass();
      if (clazz.getEnclosingConstructor() != null)
        return true; 
      Method method = clazz.getEnclosingMethod();
      return (method != null) ? (Modifier.isStatic(method.getModifiers()) ^ true) : ((clazz.getEnclosingClass() != null && !Modifier.isStatic(clazz.getModifiers())));
    }
    
    Type[] b() {
      Type[] arrayOfType2 = this.a.getGenericParameterTypes();
      Type[] arrayOfType1 = arrayOfType2;
      if (arrayOfType2.length > 0) {
        arrayOfType1 = arrayOfType2;
        if (c()) {
          Class[] arrayOfClass = this.a.getParameterTypes();
          arrayOfType1 = arrayOfType2;
          if (arrayOfType2.length == arrayOfClass.length) {
            arrayOfType1 = arrayOfType2;
            if (arrayOfClass[0] == getDeclaringClass().getEnclosingClass())
              arrayOfType1 = Arrays.<Type>copyOfRange(arrayOfType2, 1, arrayOfType2.length); 
          } 
        } 
      } 
      return arrayOfType1;
    }
    
    public final TypeVariable<?>[] getTypeParameters() {
      TypeVariable[] arrayOfTypeVariable1 = (TypeVariable[])getDeclaringClass().getTypeParameters();
      TypeVariable[] arrayOfTypeVariable2 = (TypeVariable[])this.a.getTypeParameters();
      TypeVariable[] arrayOfTypeVariable3 = new TypeVariable[arrayOfTypeVariable1.length + arrayOfTypeVariable2.length];
      System.arraycopy(arrayOfTypeVariable1, 0, arrayOfTypeVariable3, 0, arrayOfTypeVariable1.length);
      System.arraycopy(arrayOfTypeVariable2, 0, arrayOfTypeVariable3, arrayOfTypeVariable1.length, arrayOfTypeVariable2.length);
      return (TypeVariable<?>[])arrayOfTypeVariable3;
    }
  }
  
  static class MethodInvokable<T> extends Invokable<T, Object> {
    final Method a;
    
    Type[] b() {
      return this.a.getGenericParameterTypes();
    }
    
    public final TypeVariable<?>[] getTypeParameters() {
      return (TypeVariable<?>[])this.a.getTypeParameters();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\reflect\Invokable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */