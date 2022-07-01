package com.google.common.base;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class Predicates {
  public static <T> Predicate<T> a() {
    return ObjectPredicate.a.a();
  }
  
  public static <T> Predicate<T> a(Predicate<T> paramPredicate) {
    return new NotPredicate<T>(paramPredicate);
  }
  
  public static <A, B> Predicate<A> a(Predicate<B> paramPredicate, Function<A, ? extends B> paramFunction) {
    return new CompositionPredicate<A, Object>(paramPredicate, paramFunction);
  }
  
  public static <T> Predicate<T> a(Predicate<? super T> paramPredicate1, Predicate<? super T> paramPredicate2) {
    return new AndPredicate<T>(b(Preconditions.<Predicate>a(paramPredicate1), Preconditions.<Predicate>a(paramPredicate2)));
  }
  
  public static Predicate<Object> a(Class<?> paramClass) {
    return new InstanceOfPredicate(paramClass);
  }
  
  public static <T> Predicate<T> a(@NullableDecl T paramT) {
    return (paramT == null) ? b() : new IsEqualToPredicate<T>(paramT);
  }
  
  public static <T> Predicate<T> a(Collection<? extends T> paramCollection) {
    return new InPredicate<T>(paramCollection);
  }
  
  public static <T> Predicate<T> b() {
    return ObjectPredicate.c.a();
  }
  
  private static String b(String paramString, Iterable<?> paramIterable) {
    StringBuilder stringBuilder = new StringBuilder("Predicates.");
    stringBuilder.append(paramString);
    stringBuilder.append('(');
    Iterator<?> iterator = paramIterable.iterator();
    for (boolean bool = true; iterator.hasNext(); bool = false) {
      paramIterable = (Iterable<?>)iterator.next();
      if (!bool)
        stringBuilder.append(','); 
      stringBuilder.append(paramIterable);
    } 
    stringBuilder.append(')');
    return stringBuilder.toString();
  }
  
  private static <T> List<Predicate<? super T>> b(Predicate<? super T> paramPredicate1, Predicate<? super T> paramPredicate2) {
    return Arrays.asList((Predicate<? super T>[])new Predicate[] { paramPredicate1, paramPredicate2 });
  }
  
  static class AndPredicate<T> implements Predicate<T>, Serializable {
    private final List<? extends Predicate<? super T>> a;
    
    private AndPredicate(List<? extends Predicate<? super T>> param1List) {
      this.a = param1List;
    }
    
    public boolean a(@NullableDecl T param1T) {
      for (int i = 0; i < this.a.size(); i++) {
        if (!((Predicate<T>)this.a.get(i)).a(param1T))
          return false; 
      } 
      return true;
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      if (param1Object instanceof AndPredicate) {
        param1Object = param1Object;
        return this.a.equals(((AndPredicate)param1Object).a);
      } 
      return false;
    }
    
    public int hashCode() {
      return this.a.hashCode() + 306654252;
    }
    
    public String toString() {
      return Predicates.a("and", this.a);
    }
  }
  
  static class CompositionPredicate<A, B> implements Predicate<A>, Serializable {
    final Predicate<B> a;
    
    final Function<A, ? extends B> b;
    
    private CompositionPredicate(Predicate<B> param1Predicate, Function<A, ? extends B> param1Function) {
      this.a = Preconditions.<Predicate<B>>a(param1Predicate);
      this.b = Preconditions.<Function<A, ? extends B>>a(param1Function);
    }
    
    public boolean a(@NullableDecl A param1A) {
      return this.a.a(this.b.f(param1A));
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      boolean bool = param1Object instanceof CompositionPredicate;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool) {
        param1Object = param1Object;
        bool1 = bool2;
        if (this.b.equals(((CompositionPredicate)param1Object).b)) {
          bool1 = bool2;
          if (this.a.equals(((CompositionPredicate)param1Object).a))
            bool1 = true; 
        } 
      } 
      return bool1;
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
  
  static class ContainsPatternFromStringPredicate extends ContainsPatternPredicate {
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Predicates.containsPattern(");
      stringBuilder.append(this.a.a());
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  static class ContainsPatternPredicate implements Predicate<CharSequence>, Serializable {
    final CommonPattern a;
    
    public boolean a(CharSequence param1CharSequence) {
      return this.a.a(param1CharSequence).b();
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      boolean bool = param1Object instanceof ContainsPatternPredicate;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool) {
        param1Object = param1Object;
        bool1 = bool2;
        if (Objects.a(this.a.a(), ((ContainsPatternPredicate)param1Object).a.a())) {
          bool1 = bool2;
          if (this.a.b() == ((ContainsPatternPredicate)param1Object).a.b())
            bool1 = true; 
        } 
      } 
      return bool1;
    }
    
    public int hashCode() {
      return Objects.a(new Object[] { this.a.a(), Integer.valueOf(this.a.b()) });
    }
    
    public String toString() {
      String str = MoreObjects.a(this.a).a("pattern", this.a.a()).a("pattern.flags", this.a.b()).toString();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Predicates.contains(");
      stringBuilder.append(str);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  static class InPredicate<T> implements Predicate<T>, Serializable {
    private final Collection<?> a;
    
    private InPredicate(Collection<?> param1Collection) {
      this.a = Preconditions.<Collection>a(param1Collection);
    }
    
    public boolean a(@NullableDecl T param1T) {
      try {
        return this.a.contains(param1T);
      } catch (NullPointerException|ClassCastException nullPointerException) {
        return false;
      } 
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      if (param1Object instanceof InPredicate) {
        param1Object = param1Object;
        return this.a.equals(((InPredicate)param1Object).a);
      } 
      return false;
    }
    
    public int hashCode() {
      return this.a.hashCode();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Predicates.in(");
      stringBuilder.append(this.a);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  static class InstanceOfPredicate implements Predicate<Object>, Serializable {
    private final Class<?> a;
    
    private InstanceOfPredicate(Class<?> param1Class) {
      this.a = Preconditions.<Class<?>>a(param1Class);
    }
    
    public boolean a(@NullableDecl Object param1Object) {
      return this.a.isInstance(param1Object);
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      boolean bool = param1Object instanceof InstanceOfPredicate;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool) {
        param1Object = param1Object;
        bool1 = bool2;
        if (this.a == ((InstanceOfPredicate)param1Object).a)
          bool1 = true; 
      } 
      return bool1;
    }
    
    public int hashCode() {
      return this.a.hashCode();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Predicates.instanceOf(");
      stringBuilder.append(this.a.getName());
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  static class IsEqualToPredicate<T> implements Predicate<T>, Serializable {
    private final T a;
    
    private IsEqualToPredicate(T param1T) {
      this.a = param1T;
    }
    
    public boolean a(T param1T) {
      return this.a.equals(param1T);
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      if (param1Object instanceof IsEqualToPredicate) {
        param1Object = param1Object;
        return this.a.equals(((IsEqualToPredicate)param1Object).a);
      } 
      return false;
    }
    
    public int hashCode() {
      return this.a.hashCode();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Predicates.equalTo(");
      stringBuilder.append(this.a);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  static class NotPredicate<T> implements Predicate<T>, Serializable {
    final Predicate<T> a;
    
    NotPredicate(Predicate<T> param1Predicate) {
      this.a = Preconditions.<Predicate<T>>a(param1Predicate);
    }
    
    public boolean a(@NullableDecl T param1T) {
      return this.a.a(param1T) ^ true;
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      if (param1Object instanceof NotPredicate) {
        param1Object = param1Object;
        return this.a.equals(((NotPredicate)param1Object).a);
      } 
      return false;
    }
    
    public int hashCode() {
      return this.a.hashCode();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Predicates.not(");
      stringBuilder.append(this.a);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  enum ObjectPredicate implements Predicate<Object> {
    a {
      public boolean a(@NullableDecl Object param2Object) {
        return true;
      }
      
      public String toString() {
        return "Predicates.alwaysTrue()";
      }
    },
    b {
      public boolean a(@NullableDecl Object param2Object) {
        return false;
      }
      
      public String toString() {
        return "Predicates.alwaysFalse()";
      }
    },
    c {
      public boolean a(@NullableDecl Object param2Object) {
        return (param2Object == null);
      }
      
      public String toString() {
        return "Predicates.isNull()";
      }
    },
    d {
      public boolean a(@NullableDecl Object param2Object) {
        return (param2Object != null);
      }
      
      public String toString() {
        return "Predicates.notNull()";
      }
    };
    
    <T> Predicate<T> a() {
      return this;
    }
  }
  
  enum null {
    public boolean a(@NullableDecl Object param1Object) {
      return true;
    }
    
    public String toString() {
      return "Predicates.alwaysTrue()";
    }
  }
  
  enum null {
    public boolean a(@NullableDecl Object param1Object) {
      return false;
    }
    
    public String toString() {
      return "Predicates.alwaysFalse()";
    }
  }
  
  enum null {
    public boolean a(@NullableDecl Object param1Object) {
      return (param1Object == null);
    }
    
    public String toString() {
      return "Predicates.isNull()";
    }
  }
  
  enum null {
    public boolean a(@NullableDecl Object param1Object) {
      return (param1Object != null);
    }
    
    public String toString() {
      return "Predicates.notNull()";
    }
  }
  
  static class OrPredicate<T> implements Predicate<T>, Serializable {
    private final List<? extends Predicate<? super T>> a;
    
    public boolean a(@NullableDecl T param1T) {
      for (int i = 0; i < this.a.size(); i++) {
        if (((Predicate<T>)this.a.get(i)).a(param1T))
          return true; 
      } 
      return false;
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      if (param1Object instanceof OrPredicate) {
        param1Object = param1Object;
        return this.a.equals(((OrPredicate)param1Object).a);
      } 
      return false;
    }
    
    public int hashCode() {
      return this.a.hashCode() + 87855567;
    }
    
    public String toString() {
      return Predicates.a("or", this.a);
    }
  }
  
  static class SubtypeOfPredicate implements Predicate<Class<?>>, Serializable {
    private final Class<?> a;
    
    public boolean a(Class<?> param1Class) {
      return this.a.isAssignableFrom(param1Class);
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      boolean bool = param1Object instanceof SubtypeOfPredicate;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool) {
        param1Object = param1Object;
        bool1 = bool2;
        if (this.a == ((SubtypeOfPredicate)param1Object).a)
          bool1 = true; 
      } 
      return bool1;
    }
    
    public int hashCode() {
      return this.a.hashCode();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Predicates.subtypeOf(");
      stringBuilder.append(this.a.getName());
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\base\Predicates.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */