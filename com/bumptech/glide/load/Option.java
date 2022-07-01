package com.bumptech.glide.load;

import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

public final class Option<T> {
  private static final CacheKeyUpdater<Object> a = new CacheKeyUpdater() {
      public void a(byte[] param1ArrayOfbyte, Object param1Object, MessageDigest param1MessageDigest) {}
    };
  
  private final T b;
  
  private final CacheKeyUpdater<T> c;
  
  private final String d;
  
  private volatile byte[] e;
  
  private Option(String paramString, T paramT, CacheKeyUpdater<T> paramCacheKeyUpdater) {
    this.d = Preconditions.a(paramString);
    this.b = paramT;
    this.c = (CacheKeyUpdater<T>)Preconditions.a(paramCacheKeyUpdater);
  }
  
  public static <T> Option<T> a(String paramString) {
    return new Option<T>(paramString, null, c());
  }
  
  public static <T> Option<T> a(String paramString, T paramT) {
    return new Option<T>(paramString, paramT, c());
  }
  
  public static <T> Option<T> a(String paramString, T paramT, CacheKeyUpdater<T> paramCacheKeyUpdater) {
    return new Option<T>(paramString, paramT, paramCacheKeyUpdater);
  }
  
  private byte[] b() {
    if (this.e == null)
      this.e = this.d.getBytes(Key.a); 
    return this.e;
  }
  
  private static <T> CacheKeyUpdater<T> c() {
    return (CacheKeyUpdater)a;
  }
  
  public T a() {
    return this.b;
  }
  
  public void a(T paramT, MessageDigest paramMessageDigest) {
    this.c.a(b(), paramT, paramMessageDigest);
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject instanceof Option) {
      paramObject = paramObject;
      return this.d.equals(((Option)paramObject).d);
    } 
    return false;
  }
  
  public int hashCode() {
    return this.d.hashCode();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Option{key='");
    stringBuilder.append(this.d);
    stringBuilder.append('\'');
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
  
  public static interface CacheKeyUpdater<T> {
    void a(byte[] param1ArrayOfbyte, T param1T, MessageDigest param1MessageDigest);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\Option.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */