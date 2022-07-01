package com.bumptech.glide.load;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.security.MessageDigest;

public final class Options implements Key {
  private final ArrayMap<Option<?>, Object> b = (ArrayMap<Option<?>, Object>)new CachedHashCodeArrayMap();
  
  private static <T> void a(Option<T> paramOption, Object paramObject, MessageDigest paramMessageDigest) {
    paramOption.a((T)paramObject, paramMessageDigest);
  }
  
  public <T> Options a(Option<T> paramOption, T paramT) {
    this.b.put(paramOption, paramT);
    return this;
  }
  
  public <T> T a(Option<T> paramOption) {
    return (T)(this.b.containsKey(paramOption) ? this.b.get(paramOption) : (Object)paramOption.a());
  }
  
  public void a(Options paramOptions) {
    this.b.putAll((SimpleArrayMap)paramOptions.b);
  }
  
  public void a(MessageDigest paramMessageDigest) {
    for (int i = 0; i < this.b.size(); i++)
      a((Option)this.b.keyAt(i), this.b.valueAt(i), paramMessageDigest); 
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject instanceof Options) {
      paramObject = paramObject;
      return this.b.equals(((Options)paramObject).b);
    } 
    return false;
  }
  
  public int hashCode() {
    return this.b.hashCode();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Options{values=");
    stringBuilder.append(this.b);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\Options.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */