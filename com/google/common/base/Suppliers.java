package com.google.common.base;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class Suppliers {
  public static <T> Supplier<T> a(@NullableDecl T paramT) {
    return new SupplierOfInstance<T>(paramT);
  }
  
  static class ExpiringMemoizingSupplier<T> implements Supplier<T>, Serializable {
    final Supplier<T> a;
    
    final long b;
    
    @NullableDecl
    volatile transient T c;
    
    volatile transient long d;
    
    public T get() {
      // Byte code:
      //   0: aload_0
      //   1: getfield d : J
      //   4: lstore_1
      //   5: invokestatic a : ()J
      //   8: lstore_3
      //   9: lload_1
      //   10: lconst_0
      //   11: lcmp
      //   12: ifeq -> 23
      //   15: lload_3
      //   16: lload_1
      //   17: lsub
      //   18: lconst_0
      //   19: lcmp
      //   20: iflt -> 80
      //   23: aload_0
      //   24: monitorenter
      //   25: lload_1
      //   26: aload_0
      //   27: getfield d : J
      //   30: lcmp
      //   31: ifne -> 78
      //   34: aload_0
      //   35: getfield a : Lcom/google/common/base/Supplier;
      //   38: invokeinterface get : ()Ljava/lang/Object;
      //   43: astore #5
      //   45: aload_0
      //   46: aload #5
      //   48: putfield c : Ljava/lang/Object;
      //   51: lload_3
      //   52: aload_0
      //   53: getfield b : J
      //   56: ladd
      //   57: lstore_3
      //   58: lload_3
      //   59: lstore_1
      //   60: lload_3
      //   61: lconst_0
      //   62: lcmp
      //   63: ifne -> 68
      //   66: lconst_1
      //   67: lstore_1
      //   68: aload_0
      //   69: lload_1
      //   70: putfield d : J
      //   73: aload_0
      //   74: monitorexit
      //   75: aload #5
      //   77: areturn
      //   78: aload_0
      //   79: monitorexit
      //   80: aload_0
      //   81: getfield c : Ljava/lang/Object;
      //   84: areturn
      //   85: astore #5
      //   87: aload_0
      //   88: monitorexit
      //   89: aload #5
      //   91: athrow
      // Exception table:
      //   from	to	target	type
      //   25	58	85	finally
      //   68	75	85	finally
      //   78	80	85	finally
      //   87	89	85	finally
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Suppliers.memoizeWithExpiration(");
      stringBuilder.append(this.a);
      stringBuilder.append(", ");
      stringBuilder.append(this.b);
      stringBuilder.append(", NANOS)");
      return stringBuilder.toString();
    }
  }
  
  static class MemoizingSupplier<T> implements Supplier<T>, Serializable {
    final Supplier<T> a;
    
    volatile transient boolean b;
    
    @NullableDecl
    transient T c;
    
    public T get() {
      // Byte code:
      //   0: aload_0
      //   1: getfield b : Z
      //   4: ifne -> 50
      //   7: aload_0
      //   8: monitorenter
      //   9: aload_0
      //   10: getfield b : Z
      //   13: ifne -> 40
      //   16: aload_0
      //   17: getfield a : Lcom/google/common/base/Supplier;
      //   20: invokeinterface get : ()Ljava/lang/Object;
      //   25: astore_1
      //   26: aload_0
      //   27: aload_1
      //   28: putfield c : Ljava/lang/Object;
      //   31: aload_0
      //   32: iconst_1
      //   33: putfield b : Z
      //   36: aload_0
      //   37: monitorexit
      //   38: aload_1
      //   39: areturn
      //   40: aload_0
      //   41: monitorexit
      //   42: goto -> 50
      //   45: astore_1
      //   46: aload_0
      //   47: monitorexit
      //   48: aload_1
      //   49: athrow
      //   50: aload_0
      //   51: getfield c : Ljava/lang/Object;
      //   54: areturn
      // Exception table:
      //   from	to	target	type
      //   9	38	45	finally
      //   40	42	45	finally
      //   46	48	45	finally
    }
    
    public String toString() {
      Supplier<T> supplier;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Suppliers.memoize(");
      if (this.b) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("<supplier that returned ");
        stringBuilder1.append(this.c);
        stringBuilder1.append(">");
        String str = stringBuilder1.toString();
      } else {
        supplier = this.a;
      } 
      stringBuilder.append(supplier);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  static class NonSerializableMemoizingSupplier<T> implements Supplier<T> {
    volatile Supplier<T> a;
    
    volatile boolean b;
    
    @NullableDecl
    T c;
    
    public T get() {
      // Byte code:
      //   0: aload_0
      //   1: getfield b : Z
      //   4: ifne -> 55
      //   7: aload_0
      //   8: monitorenter
      //   9: aload_0
      //   10: getfield b : Z
      //   13: ifne -> 45
      //   16: aload_0
      //   17: getfield a : Lcom/google/common/base/Supplier;
      //   20: invokeinterface get : ()Ljava/lang/Object;
      //   25: astore_1
      //   26: aload_0
      //   27: aload_1
      //   28: putfield c : Ljava/lang/Object;
      //   31: aload_0
      //   32: iconst_1
      //   33: putfield b : Z
      //   36: aload_0
      //   37: aconst_null
      //   38: putfield a : Lcom/google/common/base/Supplier;
      //   41: aload_0
      //   42: monitorexit
      //   43: aload_1
      //   44: areturn
      //   45: aload_0
      //   46: monitorexit
      //   47: goto -> 55
      //   50: astore_1
      //   51: aload_0
      //   52: monitorexit
      //   53: aload_1
      //   54: athrow
      //   55: aload_0
      //   56: getfield c : Ljava/lang/Object;
      //   59: areturn
      // Exception table:
      //   from	to	target	type
      //   9	43	50	finally
      //   45	47	50	finally
      //   51	53	50	finally
    }
    
    public String toString() {
      String str;
      Supplier<T> supplier2 = this.a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Suppliers.memoize(");
      Supplier<T> supplier1 = supplier2;
      if (supplier2 == null) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("<supplier that returned ");
        stringBuilder1.append(this.c);
        stringBuilder1.append(">");
        str = stringBuilder1.toString();
      } 
      stringBuilder.append(str);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  static class SupplierComposition<F, T> implements Supplier<T>, Serializable {
    final Function<? super F, T> a;
    
    final Supplier<F> b;
    
    public boolean equals(@NullableDecl Object param1Object) {
      boolean bool = param1Object instanceof SupplierComposition;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool) {
        param1Object = param1Object;
        bool1 = bool2;
        if (this.a.equals(((SupplierComposition)param1Object).a)) {
          bool1 = bool2;
          if (this.b.equals(((SupplierComposition)param1Object).b))
            bool1 = true; 
        } 
      } 
      return bool1;
    }
    
    public T get() {
      return this.a.f(this.b.get());
    }
    
    public int hashCode() {
      return Objects.a(new Object[] { this.a, this.b });
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Suppliers.compose(");
      stringBuilder.append(this.a);
      stringBuilder.append(", ");
      stringBuilder.append(this.b);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  static interface SupplierFunction<T> extends Function<Supplier<T>, T> {}
  
  enum SupplierFunctionImpl implements SupplierFunction<Object> {
    a;
    
    public Object a(Supplier<Object> param1Supplier) {
      return param1Supplier.get();
    }
    
    public String toString() {
      return "Suppliers.supplierFunction()";
    }
  }
  
  static class SupplierOfInstance<T> implements Supplier<T>, Serializable {
    @NullableDecl
    final T a;
    
    SupplierOfInstance(@NullableDecl T param1T) {
      this.a = param1T;
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      if (param1Object instanceof SupplierOfInstance) {
        param1Object = param1Object;
        return Objects.a(this.a, ((SupplierOfInstance)param1Object).a);
      } 
      return false;
    }
    
    public T get() {
      return this.a;
    }
    
    public int hashCode() {
      return Objects.a(new Object[] { this.a });
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Suppliers.ofInstance(");
      stringBuilder.append(this.a);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  static class ThreadSafeSupplier<T> implements Supplier<T>, Serializable {
    final Supplier<T> a;
    
    public T get() {
      synchronized (this.a) {
        return this.a.get();
      } 
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Suppliers.synchronizedSupplier(");
      stringBuilder.append(this.a);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\base\Suppliers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */