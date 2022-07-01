package com.google.common.base;

import java.io.Serializable;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class Converter<A, B> implements Function<A, B> {
  private final boolean a;
  
  public Converter() {
    this(true);
  }
  
  Converter(boolean paramBoolean) {
    this.a = paramBoolean;
  }
  
  protected abstract A a(B paramB);
  
  protected abstract B b(A paramA);
  
  @NullableDecl
  public final B c(@NullableDecl A paramA) {
    return d(paramA);
  }
  
  @NullableDecl
  B d(@NullableDecl A paramA) {
    return this.a ? ((paramA == null) ? null : Preconditions.a(b(paramA))) : b(paramA);
  }
  
  @NullableDecl
  A e(@NullableDecl B paramB) {
    return this.a ? ((paramB == null) ? null : Preconditions.a(a(paramB))) : a(paramB);
  }
  
  public boolean equals(@NullableDecl Object paramObject) {
    return super.equals(paramObject);
  }
  
  @Deprecated
  @NullableDecl
  public final B f(@NullableDecl A paramA) {
    return c(paramA);
  }
  
  static final class ConverterComposition<A, B, C> extends Converter<A, C> implements Serializable {
    final Converter<A, B> a;
    
    final Converter<B, C> b;
    
    protected A a(C param1C) {
      throw new AssertionError();
    }
    
    protected C b(A param1A) {
      throw new AssertionError();
    }
    
    @NullableDecl
    C d(@NullableDecl A param1A) {
      return this.b.d(this.a.d(param1A));
    }
    
    @NullableDecl
    A e(@NullableDecl C param1C) {
      return this.a.e(this.b.e(param1C));
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      boolean bool = param1Object instanceof ConverterComposition;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool) {
        param1Object = param1Object;
        bool1 = bool2;
        if (this.a.equals(((ConverterComposition)param1Object).a)) {
          bool1 = bool2;
          if (this.b.equals(((ConverterComposition)param1Object).b))
            bool1 = true; 
        } 
      } 
      return bool1;
    }
    
    public int hashCode() {
      return this.a.hashCode() * 31 + this.b.hashCode();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.a);
      stringBuilder.append(".andThen(");
      stringBuilder.append(this.b);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  static final class FunctionBasedConverter<A, B> extends Converter<A, B> implements Serializable {
    private final Function<? super A, ? extends B> a;
    
    private final Function<? super B, ? extends A> b;
    
    protected A a(B param1B) {
      return this.b.f(param1B);
    }
    
    protected B b(A param1A) {
      return this.a.f(param1A);
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      boolean bool = param1Object instanceof FunctionBasedConverter;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool) {
        param1Object = param1Object;
        bool1 = bool2;
        if (this.a.equals(((FunctionBasedConverter)param1Object).a)) {
          bool1 = bool2;
          if (this.b.equals(((FunctionBasedConverter)param1Object).b))
            bool1 = true; 
        } 
      } 
      return bool1;
    }
    
    public int hashCode() {
      return this.a.hashCode() * 31 + this.b.hashCode();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Converter.from(");
      stringBuilder.append(this.a);
      stringBuilder.append(", ");
      stringBuilder.append(this.b);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  static final class IdentityConverter<T> extends Converter<T, T> implements Serializable {
    static final IdentityConverter<?> a = new IdentityConverter();
    
    protected T a(T param1T) {
      return param1T;
    }
    
    protected T b(T param1T) {
      return param1T;
    }
    
    public String toString() {
      return "Converter.identity()";
    }
  }
  
  static final class ReverseConverter<A, B> extends Converter<B, A> implements Serializable {
    final Converter<A, B> a;
    
    protected B a(A param1A) {
      throw new AssertionError();
    }
    
    protected A b(B param1B) {
      throw new AssertionError();
    }
    
    @NullableDecl
    A d(@NullableDecl B param1B) {
      return this.a.e(param1B);
    }
    
    @NullableDecl
    B e(@NullableDecl A param1A) {
      return this.a.d(param1A);
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      if (param1Object instanceof ReverseConverter) {
        param1Object = param1Object;
        return this.a.equals(((ReverseConverter)param1Object).a);
      } 
      return false;
    }
    
    public int hashCode() {
      return this.a.hashCode();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.a);
      stringBuilder.append(".reverse()");
      return stringBuilder.toString();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\base\Converter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */