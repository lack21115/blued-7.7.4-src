package com.google.common.base;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class Equivalence<T> {
  public static Equivalence<Object> a() {
    return Equals.a;
  }
  
  public static Equivalence<Object> b() {
    return Identity.a;
  }
  
  public final int a(@NullableDecl T paramT) {
    return (paramT == null) ? 0 : b(paramT);
  }
  
  public final boolean a(@NullableDecl T paramT1, @NullableDecl T paramT2) {
    return (paramT1 == paramT2) ? true : ((paramT1 == null || paramT2 == null) ? false : b(paramT1, paramT2));
  }
  
  protected abstract int b(T paramT);
  
  protected abstract boolean b(T paramT1, T paramT2);
  
  static final class Equals extends Equivalence<Object> implements Serializable {
    static final Equals a = new Equals();
    
    protected int b(Object param1Object) {
      return param1Object.hashCode();
    }
    
    protected boolean b(Object param1Object1, Object param1Object2) {
      return param1Object1.equals(param1Object2);
    }
  }
  
  static final class EquivalentToPredicate<T> implements Predicate<T>, Serializable {
    private final Equivalence<T> a;
    
    @NullableDecl
    private final T b;
    
    public boolean a(@NullableDecl T param1T) {
      return this.a.a(param1T, this.b);
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      if (this == param1Object)
        return true; 
      if (param1Object instanceof EquivalentToPredicate) {
        param1Object = param1Object;
        return (this.a.equals(((EquivalentToPredicate)param1Object).a) && Objects.a(this.b, ((EquivalentToPredicate)param1Object).b));
      } 
      return false;
    }
    
    public int hashCode() {
      return Objects.a(new Object[] { this.a, this.b });
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.a);
      stringBuilder.append(".equivalentTo(");
      stringBuilder.append(this.b);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  static final class Identity extends Equivalence<Object> implements Serializable {
    static final Identity a = new Identity();
    
    protected int b(Object param1Object) {
      return System.identityHashCode(param1Object);
    }
    
    protected boolean b(Object param1Object1, Object param1Object2) {
      return false;
    }
  }
  
  public static final class Wrapper<T> implements Serializable {
    private final Equivalence<? super T> a;
    
    @NullableDecl
    private final T b;
    
    public boolean equals(@NullableDecl Object param1Object) {
      if (param1Object == this)
        return true; 
      if (param1Object instanceof Wrapper) {
        param1Object = param1Object;
        if (this.a.equals(((Wrapper)param1Object).a))
          return this.a.a(this.b, ((Wrapper)param1Object).b); 
      } 
      return false;
    }
    
    public int hashCode() {
      return this.a.a(this.b);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.a);
      stringBuilder.append(".wrap(");
      stringBuilder.append(this.b);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\base\Equivalence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */