package com.google.common.collect;

import com.google.common.primitives.Primitives;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class MutableClassToInstanceMap<B> extends ForwardingMap<Class<? extends B>, B> implements ClassToInstanceMap<B>, Serializable {
  private final Map<Class<? extends B>, B> a;
  
  static <B> Map.Entry<Class<? extends B>, B> a(Map.Entry<Class<? extends B>, B> paramEntry) {
    return new ForwardingMapEntry<Class<? extends B>, B>(paramEntry) {
        protected Map.Entry<Class<? extends B>, B> a() {
          return this.a;
        }
        
        public B setValue(B param1B) {
          return super.setValue((B)MutableClassToInstanceMap.b(getKey(), param1B));
        }
      };
  }
  
  private static <B, T extends B> T c(Class<T> paramClass, B paramB) {
    return Primitives.a(paramClass).cast(paramB);
  }
  
  public B a(Class<? extends B> paramClass, B paramB) {
    return super.put(paramClass, c((Class)paramClass, paramB));
  }
  
  protected Map<Class<? extends B>, B> a() {
    return this.a;
  }
  
  public Set<Map.Entry<Class<? extends B>, B>> entrySet() {
    return new ForwardingSet<Map.Entry<Class<? extends B>, B>>(this) {
        protected Set<Map.Entry<Class<? extends B>, B>> a() {
          return this.a.a().entrySet();
        }
        
        public Iterator<Map.Entry<Class<? extends B>, B>> iterator() {
          return new TransformedIterator<Map.Entry<Class<? extends B>, B>, Map.Entry<Class<? extends B>, B>>(this, a().iterator()) {
              Map.Entry<Class<? extends B>, B> a(Map.Entry<Class<? extends B>, B> param2Entry) {
                return MutableClassToInstanceMap.a(param2Entry);
              }
            };
        }
        
        public Object[] toArray() {
          return o();
        }
        
        public <T> T[] toArray(T[] param1ArrayOfT) {
          return (T[])a((Object[])param1ArrayOfT);
        }
      };
  }
  
  public void putAll(Map<? extends Class<? extends B>, ? extends B> paramMap) {
    paramMap = new LinkedHashMap<Class<? extends B>, B>(paramMap);
    for (Map.Entry<? extends Class<? extends B>, ? extends B> entry : paramMap.entrySet())
      c((Class)entry.getKey(), entry.getValue()); 
    super.putAll(paramMap);
  }
  
  static final class SerializedForm<B> implements Serializable {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\MutableClassToInstanceMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */