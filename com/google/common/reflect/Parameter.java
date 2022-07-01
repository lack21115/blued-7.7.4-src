package com.google.common.reflect;

import com.google.common.base.Preconditions;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class Parameter implements AnnotatedElement {
  private final Invokable<?, ?> a;
  
  private final int b;
  
  private final TypeToken<?> c;
  
  private final ImmutableList<Annotation> d;
  
  public boolean equals(@NullableDecl Object paramObject) {
    boolean bool = paramObject instanceof Parameter;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool) {
      paramObject = paramObject;
      bool1 = bool2;
      if (this.b == ((Parameter)paramObject).b) {
        bool1 = bool2;
        if (this.a.equals(((Parameter)paramObject).a))
          bool1 = true; 
      } 
    } 
    return bool1;
  }
  
  @NullableDecl
  public <A extends Annotation> A getAnnotation(Class<A> paramClass) {
    Preconditions.a(paramClass);
    UnmodifiableIterator<Annotation> unmodifiableIterator = this.d.av_();
    while (unmodifiableIterator.hasNext()) {
      Annotation annotation = unmodifiableIterator.next();
      if (paramClass.isInstance(annotation))
        return paramClass.cast(annotation); 
    } 
    return null;
  }
  
  public Annotation[] getAnnotations() {
    return getDeclaredAnnotations();
  }
  
  public <A extends Annotation> A[] getAnnotationsByType(Class<A> paramClass) {
    return getDeclaredAnnotationsByType(paramClass);
  }
  
  @NullableDecl
  public <A extends Annotation> A getDeclaredAnnotation(Class<A> paramClass) {
    Preconditions.a(paramClass);
    return (A)FluentIterable.a((Iterable)this.d).a(paramClass).a().d();
  }
  
  public Annotation[] getDeclaredAnnotations() {
    return (Annotation[])this.d.toArray((Object[])new Annotation[0]);
  }
  
  public <A extends Annotation> A[] getDeclaredAnnotationsByType(Class<A> paramClass) {
    return (A[])FluentIterable.a((Iterable)this.d).a(paramClass).b(paramClass);
  }
  
  public int hashCode() {
    return this.b;
  }
  
  public boolean isAnnotationPresent(Class<? extends Annotation> paramClass) {
    return (getAnnotation(paramClass) != null);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.c);
    stringBuilder.append(" arg");
    stringBuilder.append(this.b);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\reflect\Parameter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */