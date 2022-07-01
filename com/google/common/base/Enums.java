package com.google.common.base;

import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class Enums {
  private static final Map<Class<? extends Enum<?>>, Map<String, WeakReference<? extends Enum<?>>>> a = new WeakHashMap<Class<? extends Enum<?>>, Map<String, WeakReference<? extends Enum<?>>>>();
  
  static final class StringConverter<T extends Enum<T>> extends Converter<String, T> implements Serializable {
    private final Class<T> a;
    
    protected T a(String param1String) {
      return Enum.valueOf(this.a, param1String);
    }
    
    protected String a(T param1T) {
      return param1T.name();
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      if (param1Object instanceof StringConverter) {
        param1Object = param1Object;
        return this.a.equals(((StringConverter)param1Object).a);
      } 
      return false;
    }
    
    public int hashCode() {
      return this.a.hashCode();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Enums.stringConverter(");
      stringBuilder.append(this.a.getName());
      stringBuilder.append(".class)");
      return stringBuilder.toString();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\base\Enums.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */