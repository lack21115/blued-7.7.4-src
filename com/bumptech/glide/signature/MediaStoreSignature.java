package com.bumptech.glide.signature;

import com.bumptech.glide.load.Key;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public class MediaStoreSignature implements Key {
  private final String b;
  
  private final long c;
  
  private final int d;
  
  public void a(MessageDigest paramMessageDigest) {
    paramMessageDigest.update(ByteBuffer.allocate(12).putLong(this.c).putInt(this.d).array());
    paramMessageDigest.update(this.b.getBytes(a));
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject != null) {
      if (getClass() != paramObject.getClass())
        return false; 
      paramObject = paramObject;
      return (this.c != ((MediaStoreSignature)paramObject).c) ? false : ((this.d != ((MediaStoreSignature)paramObject).d) ? false : (!!this.b.equals(((MediaStoreSignature)paramObject).b)));
    } 
    return false;
  }
  
  public int hashCode() {
    int i = this.b.hashCode();
    long l = this.c;
    return (i * 31 + (int)(l ^ l >>> 32L)) * 31 + this.d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\signature\MediaStoreSignature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */