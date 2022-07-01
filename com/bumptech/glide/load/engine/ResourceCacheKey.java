package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

final class ResourceCacheKey implements Key {
  private static final LruCache<Class<?>, byte[]> b = new LruCache(50L);
  
  private final ArrayPool c;
  
  private final Key d;
  
  private final Key e;
  
  private final int f;
  
  private final int g;
  
  private final Class<?> h;
  
  private final Options i;
  
  private final Transformation<?> j;
  
  ResourceCacheKey(ArrayPool paramArrayPool, Key paramKey1, Key paramKey2, int paramInt1, int paramInt2, Transformation<?> paramTransformation, Class<?> paramClass, Options paramOptions) {
    this.c = paramArrayPool;
    this.d = paramKey1;
    this.e = paramKey2;
    this.f = paramInt1;
    this.g = paramInt2;
    this.j = paramTransformation;
    this.h = paramClass;
    this.i = paramOptions;
  }
  
  private byte[] a() {
    byte[] arrayOfByte2 = (byte[])b.b(this.h);
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null) {
      arrayOfByte1 = this.h.getName().getBytes(a);
      b.b(this.h, arrayOfByte1);
    } 
    return arrayOfByte1;
  }
  
  public void a(MessageDigest paramMessageDigest) {
    byte[] arrayOfByte = (byte[])this.c.b(8, byte[].class);
    ByteBuffer.wrap(arrayOfByte).putInt(this.f).putInt(this.g).array();
    this.e.a(paramMessageDigest);
    this.d.a(paramMessageDigest);
    paramMessageDigest.update(arrayOfByte);
    Transformation<?> transformation = this.j;
    if (transformation != null)
      transformation.a(paramMessageDigest); 
    this.i.a(paramMessageDigest);
    paramMessageDigest.update(a());
    this.c.a(arrayOfByte);
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = paramObject instanceof ResourceCacheKey;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool) {
      paramObject = paramObject;
      bool1 = bool2;
      if (this.g == ((ResourceCacheKey)paramObject).g) {
        bool1 = bool2;
        if (this.f == ((ResourceCacheKey)paramObject).f) {
          bool1 = bool2;
          if (Util.a(this.j, ((ResourceCacheKey)paramObject).j)) {
            bool1 = bool2;
            if (this.h.equals(((ResourceCacheKey)paramObject).h)) {
              bool1 = bool2;
              if (this.d.equals(((ResourceCacheKey)paramObject).d)) {
                bool1 = bool2;
                if (this.e.equals(((ResourceCacheKey)paramObject).e)) {
                  bool1 = bool2;
                  if (this.i.equals(((ResourceCacheKey)paramObject).i))
                    bool1 = true; 
                } 
              } 
            } 
          } 
        } 
      } 
    } 
    return bool1;
  }
  
  public int hashCode() {
    int j = ((this.d.hashCode() * 31 + this.e.hashCode()) * 31 + this.f) * 31 + this.g;
    Transformation<?> transformation = this.j;
    int i = j;
    if (transformation != null)
      i = j * 31 + transformation.hashCode(); 
    return (i * 31 + this.h.hashCode()) * 31 + this.i.hashCode();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("ResourceCacheKey{sourceKey=");
    stringBuilder.append(this.d);
    stringBuilder.append(", signature=");
    stringBuilder.append(this.e);
    stringBuilder.append(", width=");
    stringBuilder.append(this.f);
    stringBuilder.append(", height=");
    stringBuilder.append(this.g);
    stringBuilder.append(", decodedResourceClass=");
    stringBuilder.append(this.h);
    stringBuilder.append(", transformation='");
    stringBuilder.append(this.j);
    stringBuilder.append('\'');
    stringBuilder.append(", options=");
    stringBuilder.append(this.i);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\engine\ResourceCacheKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */