package com.google.common.graph;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class MultiEdgesConnecting<E> extends AbstractSet<E> {
  private final Map<E, ?> a;
  
  private final Object b;
  
  public UnmodifiableIterator<E> a() {
    return (UnmodifiableIterator<E>)new AbstractIterator<E>(this, this.a.entrySet().iterator()) {
        public E a() {
          while (this.a.hasNext()) {
            Map.Entry entry = this.a.next();
            if (MultiEdgesConnecting.a(this.b).equals(entry.getValue()))
              return (E)entry.getKey(); 
          } 
          return (E)b();
        }
      };
  }
  
  public boolean contains(@NullableDecl Object paramObject) {
    return this.b.equals(this.a.get(paramObject));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\graph\MultiEdgesConnecting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */