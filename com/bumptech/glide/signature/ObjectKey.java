package com.bumptech.glide.signature;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

public final class ObjectKey implements Key {
  private final Object b;
  
  public ObjectKey(Object paramObject) {
    this.b = Preconditions.a(paramObject);
  }
  
  public void a(MessageDigest paramMessageDigest) {
    paramMessageDigest.update(this.b.toString().getBytes(a));
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject instanceof ObjectKey) {
      paramObject = paramObject;
      return this.b.equals(((ObjectKey)paramObject).b);
    } 
    return false;
  }
  
  public int hashCode() {
    return this.b.hashCode();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("ObjectKey{object=");
    stringBuilder.append(this.b);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\signature\ObjectKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */