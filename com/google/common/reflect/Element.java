package com.google.common.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

class Element extends AccessibleObject implements Member {
  private final AccessibleObject a;
  
  private final Member b;
  
  public TypeToken<?> a() {
    return TypeToken.a(getDeclaringClass());
  }
  
  public boolean equals(@NullableDecl Object paramObject) {
    boolean bool = paramObject instanceof Element;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool) {
      paramObject = paramObject;
      bool1 = bool2;
      if (a().equals(paramObject.a())) {
        bool1 = bool2;
        if (this.b.equals(((Element)paramObject).b))
          bool1 = true; 
      } 
    } 
    return bool1;
  }
  
  public final <A extends Annotation> A getAnnotation(Class<A> paramClass) {
    return this.a.getAnnotation(paramClass);
  }
  
  public final Annotation[] getAnnotations() {
    return this.a.getAnnotations();
  }
  
  public final Annotation[] getDeclaredAnnotations() {
    return this.a.getDeclaredAnnotations();
  }
  
  public Class<?> getDeclaringClass() {
    return this.b.getDeclaringClass();
  }
  
  public final int getModifiers() {
    return this.b.getModifiers();
  }
  
  public final String getName() {
    return this.b.getName();
  }
  
  public int hashCode() {
    return this.b.hashCode();
  }
  
  public final boolean isAccessible() {
    return this.a.isAccessible();
  }
  
  public final boolean isAnnotationPresent(Class<? extends Annotation> paramClass) {
    return this.a.isAnnotationPresent(paramClass);
  }
  
  public final boolean isSynthetic() {
    return this.b.isSynthetic();
  }
  
  public final void setAccessible(boolean paramBoolean) throws SecurityException {
    this.a.setAccessible(paramBoolean);
  }
  
  public String toString() {
    return this.b.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\reflect\Element.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */