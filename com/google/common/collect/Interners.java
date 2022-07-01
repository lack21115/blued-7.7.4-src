package com.google.common.collect;

import com.google.common.base.Function;

public final class Interners {
  public static class InternerBuilder {
    private final MapMaker a = new MapMaker();
    
    private boolean b = true;
  }
  
  static class InternerFunction<E> implements Function<E, E> {
    private final Interner<E> a;
    
    public boolean equals(Object param1Object) {
      if (param1Object instanceof InternerFunction) {
        param1Object = param1Object;
        return this.a.equals(((InternerFunction)param1Object).a);
      } 
      return false;
    }
    
    public E f(E param1E) {
      return this.a.a(param1E);
    }
    
    public int hashCode() {
      return this.a.hashCode();
    }
  }
  
  static final class InternerImpl<E> implements Interner<E> {
    final MapMakerInternalMap<E, MapMaker.Dummy, ?, ?> a;
    
    public E a(E param1E) {
      while (true) {
        Object object = this.a.b(param1E);
        if (object != null) {
          object = object.a();
          if (object != null)
            return (E)object; 
        } 
        if ((MapMaker.Dummy)this.a.putIfAbsent(param1E, MapMaker.Dummy.a) == null)
          return param1E; 
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\Interners.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */