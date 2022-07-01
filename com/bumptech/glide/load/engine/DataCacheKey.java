package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

final class DataCacheKey implements Key {
  private final Key b;
  
  private final Key c;
  
  DataCacheKey(Key paramKey1, Key paramKey2) {
    this.b = paramKey1;
    this.c = paramKey2;
  }
  
  public void a(MessageDigest paramMessageDigest) {
    this.b.a(paramMessageDigest);
    this.c.a(paramMessageDigest);
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = paramObject instanceof DataCacheKey;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool) {
      paramObject = paramObject;
      bool1 = bool2;
      if (this.b.equals(((DataCacheKey)paramObject).b)) {
        bool1 = bool2;
        if (this.c.equals(((DataCacheKey)paramObject).c))
          bool1 = true; 
      } 
    } 
    return bool1;
  }
  
  public int hashCode() {
    return this.b.hashCode() * 31 + this.c.hashCode();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("DataCacheKey{sourceKey=");
    stringBuilder.append(this.b);
    stringBuilder.append(", signature=");
    stringBuilder.append(this.c);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\engine\DataCacheKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */