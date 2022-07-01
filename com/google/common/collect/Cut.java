package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Booleans;
import java.io.Serializable;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class Cut<C extends Comparable> implements Serializable, Comparable<Cut<C>> {
  @NullableDecl
  final C a;
  
  Cut(@NullableDecl C paramC) {
    this.a = paramC;
  }
  
  static <C extends Comparable> Cut<C> b(C paramC) {
    return new BelowValue<C>(paramC);
  }
  
  static <C extends Comparable> Cut<C> c(C paramC) {
    return new AboveValue<C>(paramC);
  }
  
  static <C extends Comparable> Cut<C> d() {
    return BelowAll.f();
  }
  
  static <C extends Comparable> Cut<C> e() {
    return AboveAll.f();
  }
  
  public int a(Cut<C> paramCut) {
    if (paramCut == d())
      return 1; 
    if (paramCut == e())
      return -1; 
    int i = Range.a((Comparable)this.a, (Comparable)paramCut.a);
    return (i != 0) ? i : Booleans.a(this instanceof AboveValue, paramCut instanceof AboveValue);
  }
  
  abstract BoundType a();
  
  abstract Cut<C> a(BoundType paramBoundType, DiscreteDomain<C> paramDiscreteDomain);
  
  abstract C a(DiscreteDomain<C> paramDiscreteDomain);
  
  abstract void a(StringBuilder paramStringBuilder);
  
  abstract boolean a(C paramC);
  
  abstract BoundType b();
  
  abstract Cut<C> b(BoundType paramBoundType, DiscreteDomain<C> paramDiscreteDomain);
  
  abstract C b(DiscreteDomain<C> paramDiscreteDomain);
  
  abstract void b(StringBuilder paramStringBuilder);
  
  Cut<C> c(DiscreteDomain<C> paramDiscreteDomain) {
    return this;
  }
  
  C c() {
    return this.a;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = paramObject instanceof Cut;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool) {
      paramObject = paramObject;
      try {
        int i = a((Cut<C>)paramObject);
        bool1 = bool2;
        if (i == 0)
          bool1 = true; 
        return bool1;
      } catch (ClassCastException classCastException) {
        return false;
      } 
    } 
    return bool1;
  }
  
  public abstract int hashCode();
  
  static final class AboveAll extends Cut<Comparable<?>> {
    private static final AboveAll b = new AboveAll();
    
    private AboveAll() {
      super(null);
    }
    
    public int a(Cut<Comparable<?>> param1Cut) {
      return (param1Cut == this) ? 0 : 1;
    }
    
    BoundType a() {
      throw new AssertionError("this statement should be unreachable");
    }
    
    Cut<Comparable<?>> a(BoundType param1BoundType, DiscreteDomain<Comparable<?>> param1DiscreteDomain) {
      throw new AssertionError("this statement should be unreachable");
    }
    
    Comparable<?> a(DiscreteDomain<Comparable<?>> param1DiscreteDomain) {
      throw new AssertionError();
    }
    
    void a(StringBuilder param1StringBuilder) {
      throw new AssertionError();
    }
    
    boolean a(Comparable<?> param1Comparable) {
      return false;
    }
    
    BoundType b() {
      throw new IllegalStateException();
    }
    
    Cut<Comparable<?>> b(BoundType param1BoundType, DiscreteDomain<Comparable<?>> param1DiscreteDomain) {
      throw new IllegalStateException();
    }
    
    Comparable<?> b(DiscreteDomain<Comparable<?>> param1DiscreteDomain) {
      return param1DiscreteDomain.b();
    }
    
    void b(StringBuilder param1StringBuilder) {
      param1StringBuilder.append("+∞)");
    }
    
    Comparable<?> c() {
      throw new IllegalStateException("range unbounded on this side");
    }
    
    public int hashCode() {
      return System.identityHashCode(this);
    }
    
    public String toString() {
      return "+∞";
    }
  }
  
  static final class AboveValue<C extends Comparable> extends Cut<C> {
    AboveValue(C param1C) {
      super((C)Preconditions.a(param1C));
    }
    
    BoundType a() {
      return BoundType.a;
    }
    
    Cut<C> a(BoundType param1BoundType, DiscreteDomain<C> param1DiscreteDomain) {
      int i = Cut.null.a[param1BoundType.ordinal()];
      if (i != 1) {
        if (i == 2)
          return this; 
        throw new AssertionError();
      } 
      param1BoundType = (BoundType)param1DiscreteDomain.a(this.a);
      return (param1BoundType == null) ? Cut.d() : b((C)param1BoundType);
    }
    
    C a(DiscreteDomain<C> param1DiscreteDomain) {
      return param1DiscreteDomain.a(this.a);
    }
    
    void a(StringBuilder param1StringBuilder) {
      param1StringBuilder.append('(');
      param1StringBuilder.append(this.a);
    }
    
    boolean a(C param1C) {
      return (Range.a((Comparable)this.a, (Comparable)param1C) < 0);
    }
    
    BoundType b() {
      return BoundType.b;
    }
    
    Cut<C> b(BoundType param1BoundType, DiscreteDomain<C> param1DiscreteDomain) {
      int i = Cut.null.a[param1BoundType.ordinal()];
      if (i != 1) {
        if (i == 2) {
          param1BoundType = (BoundType)param1DiscreteDomain.a(this.a);
          return (param1BoundType == null) ? Cut.e() : b((C)param1BoundType);
        } 
        throw new AssertionError();
      } 
      return this;
    }
    
    C b(DiscreteDomain<C> param1DiscreteDomain) {
      return this.a;
    }
    
    void b(StringBuilder param1StringBuilder) {
      param1StringBuilder.append(this.a);
      param1StringBuilder.append(']');
    }
    
    Cut<C> c(DiscreteDomain<C> param1DiscreteDomain) {
      param1DiscreteDomain = (DiscreteDomain<C>)a(param1DiscreteDomain);
      return (param1DiscreteDomain != null) ? b((C)param1DiscreteDomain) : Cut.e();
    }
    
    public int hashCode() {
      return this.a.hashCode();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("/");
      stringBuilder.append(this.a);
      stringBuilder.append("\\");
      return stringBuilder.toString();
    }
  }
  
  static final class BelowAll extends Cut<Comparable<?>> {
    private static final BelowAll b = new BelowAll();
    
    private BelowAll() {
      super(null);
    }
    
    public int a(Cut<Comparable<?>> param1Cut) {
      return (param1Cut == this) ? 0 : -1;
    }
    
    BoundType a() {
      throw new IllegalStateException();
    }
    
    Cut<Comparable<?>> a(BoundType param1BoundType, DiscreteDomain<Comparable<?>> param1DiscreteDomain) {
      throw new IllegalStateException();
    }
    
    Comparable<?> a(DiscreteDomain<Comparable<?>> param1DiscreteDomain) {
      return param1DiscreteDomain.a();
    }
    
    void a(StringBuilder param1StringBuilder) {
      param1StringBuilder.append("(-∞");
    }
    
    boolean a(Comparable<?> param1Comparable) {
      return true;
    }
    
    BoundType b() {
      throw new AssertionError("this statement should be unreachable");
    }
    
    Cut<Comparable<?>> b(BoundType param1BoundType, DiscreteDomain<Comparable<?>> param1DiscreteDomain) {
      throw new AssertionError("this statement should be unreachable");
    }
    
    Comparable<?> b(DiscreteDomain<Comparable<?>> param1DiscreteDomain) {
      throw new AssertionError();
    }
    
    void b(StringBuilder param1StringBuilder) {
      throw new AssertionError();
    }
    
    Cut<Comparable<?>> c(DiscreteDomain<Comparable<?>> param1DiscreteDomain) {
      try {
        return (Cut)Cut.b(param1DiscreteDomain.a());
      } catch (NoSuchElementException noSuchElementException) {
        return this;
      } 
    }
    
    Comparable<?> c() {
      throw new IllegalStateException("range unbounded on this side");
    }
    
    public int hashCode() {
      return System.identityHashCode(this);
    }
    
    public String toString() {
      return "-∞";
    }
  }
  
  static final class BelowValue<C extends Comparable> extends Cut<C> {
    BelowValue(C param1C) {
      super((C)Preconditions.a(param1C));
    }
    
    BoundType a() {
      return BoundType.b;
    }
    
    Cut<C> a(BoundType param1BoundType, DiscreteDomain<C> param1DiscreteDomain) {
      int i = Cut.null.a[param1BoundType.ordinal()];
      if (i != 1) {
        if (i == 2) {
          param1BoundType = (BoundType)param1DiscreteDomain.b(this.a);
          return (param1BoundType == null) ? Cut.d() : new Cut.AboveValue<C>((C)param1BoundType);
        } 
        throw new AssertionError();
      } 
      return this;
    }
    
    C a(DiscreteDomain<C> param1DiscreteDomain) {
      return this.a;
    }
    
    void a(StringBuilder param1StringBuilder) {
      param1StringBuilder.append('[');
      param1StringBuilder.append(this.a);
    }
    
    boolean a(C param1C) {
      return (Range.a((Comparable)this.a, (Comparable)param1C) <= 0);
    }
    
    BoundType b() {
      return BoundType.a;
    }
    
    Cut<C> b(BoundType param1BoundType, DiscreteDomain<C> param1DiscreteDomain) {
      int i = Cut.null.a[param1BoundType.ordinal()];
      if (i != 1) {
        if (i == 2)
          return this; 
        throw new AssertionError();
      } 
      param1BoundType = (BoundType)param1DiscreteDomain.b(this.a);
      return (param1BoundType == null) ? Cut.e() : new Cut.AboveValue<C>((C)param1BoundType);
    }
    
    C b(DiscreteDomain<C> param1DiscreteDomain) {
      return param1DiscreteDomain.b(this.a);
    }
    
    void b(StringBuilder param1StringBuilder) {
      param1StringBuilder.append(this.a);
      param1StringBuilder.append(')');
    }
    
    public int hashCode() {
      return this.a.hashCode();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("\\");
      stringBuilder.append(this.a);
      stringBuilder.append("/");
      return stringBuilder.toString();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\Cut.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */