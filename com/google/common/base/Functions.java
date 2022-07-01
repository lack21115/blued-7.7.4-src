package com.google.common.base;

import java.io.Serializable;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class Functions {
  static class ConstantFunction<E> implements Function<Object, E>, Serializable {
    @NullableDecl
    private final E a;
    
    public boolean equals(@NullableDecl Object param1Object) {
      if (param1Object instanceof ConstantFunction) {
        param1Object = param1Object;
        return Objects.a(this.a, ((ConstantFunction)param1Object).a);
      } 
      return false;
    }
    
    public E f(@NullableDecl Object param1Object) {
      return this.a;
    }
    
    public int hashCode() {
      E e = this.a;
      return (e == null) ? 0 : e.hashCode();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Functions.constant(");
      stringBuilder.append(this.a);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  static class ForMapWithDefault<K, V> implements Function<K, V>, Serializable {
    final Map<K, ? extends V> a;
    
    @NullableDecl
    final V b;
    
    public boolean equals(@NullableDecl Object param1Object) {
      boolean bool = param1Object instanceof ForMapWithDefault;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool) {
        param1Object = param1Object;
        bool1 = bool2;
        if (this.a.equals(((ForMapWithDefault)param1Object).a)) {
          bool1 = bool2;
          if (Objects.a(this.b, ((ForMapWithDefault)param1Object).b))
            bool1 = true; 
        } 
      } 
      return bool1;
    }
    
    public V f(@NullableDecl K param1K) {
      V v2 = this.a.get(param1K);
      V v1 = v2;
      if (v2 == null) {
        if (this.a.containsKey(param1K))
          return v2; 
        v1 = this.b;
      } 
      return v1;
    }
    
    public int hashCode() {
      return Objects.a(new Object[] { this.a, this.b });
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Functions.forMap(");
      stringBuilder.append(this.a);
      stringBuilder.append(", defaultValue=");
      stringBuilder.append(this.b);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  static class FunctionComposition<A, B, C> implements Function<A, C>, Serializable {
    private final Function<B, C> a;
    
    private final Function<A, ? extends B> b;
    
    public boolean equals(@NullableDecl Object param1Object) {
      boolean bool = param1Object instanceof FunctionComposition;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool) {
        param1Object = param1Object;
        bool1 = bool2;
        if (this.b.equals(((FunctionComposition)param1Object).b)) {
          bool1 = bool2;
          if (this.a.equals(((FunctionComposition)param1Object).a))
            bool1 = true; 
        } 
      } 
      return bool1;
    }
    
    public C f(@NullableDecl A param1A) {
      return this.a.f(this.b.f(param1A));
    }
    
    public int hashCode() {
      return this.b.hashCode() ^ this.a.hashCode();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.a);
      stringBuilder.append("(");
      stringBuilder.append(this.b);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  static class FunctionForMapNoDefault<K, V> implements Function<K, V>, Serializable {
    final Map<K, V> a;
    
    public boolean equals(@NullableDecl Object param1Object) {
      if (param1Object instanceof FunctionForMapNoDefault) {
        param1Object = param1Object;
        return this.a.equals(((FunctionForMapNoDefault)param1Object).a);
      } 
      return false;
    }
    
    public V f(@NullableDecl K param1K) {
      V v = this.a.get(param1K);
      if (v != null || this.a.containsKey(param1K)) {
        boolean bool1 = true;
        Preconditions.a(bool1, "Key '%s' not present in map", param1K);
        return v;
      } 
      boolean bool = false;
      Preconditions.a(bool, "Key '%s' not present in map", param1K);
      return v;
    }
    
    public int hashCode() {
      return this.a.hashCode();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Functions.forMap(");
      stringBuilder.append(this.a);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  enum IdentityFunction implements Function<Object, Object> {
    a;
    
    @NullableDecl
    public Object f(@NullableDecl Object param1Object) {
      return param1Object;
    }
    
    public String toString() {
      return "Functions.identity()";
    }
  }
  
  static class PredicateFunction<T> implements Function<T, Boolean>, Serializable {
    private final Predicate<T> a;
    
    public Boolean a(@NullableDecl T param1T) {
      return Boolean.valueOf(this.a.a(param1T));
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      if (param1Object instanceof PredicateFunction) {
        param1Object = param1Object;
        return this.a.equals(((PredicateFunction)param1Object).a);
      } 
      return false;
    }
    
    public int hashCode() {
      return this.a.hashCode();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Functions.forPredicate(");
      stringBuilder.append(this.a);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  static class SupplierFunction<T> implements Function<Object, T>, Serializable {
    private final Supplier<T> a;
    
    public boolean equals(@NullableDecl Object param1Object) {
      if (param1Object instanceof SupplierFunction) {
        param1Object = param1Object;
        return this.a.equals(((SupplierFunction)param1Object).a);
      } 
      return false;
    }
    
    public T f(@NullableDecl Object param1Object) {
      return this.a.get();
    }
    
    public int hashCode() {
      return this.a.hashCode();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Functions.forSupplier(");
      stringBuilder.append(this.a);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  enum ToStringFunction implements Function<Object, String> {
    a;
    
    public String a(Object param1Object) {
      Preconditions.a(param1Object);
      return param1Object.toString();
    }
    
    public String toString() {
      return "Functions.toStringFunction()";
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\base\Functions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */