package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;

@Immutable
final class MacHashFunction extends AbstractHashFunction {
  private final Mac a;
  
  private final Key b;
  
  private final String c;
  
  private final int d;
  
  private final boolean e;
  
  private static Mac a(String paramString, Key paramKey) {
    try {
      Mac mac = Mac.getInstance(paramString);
      mac.init(paramKey);
      return mac;
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      throw new IllegalStateException(noSuchAlgorithmException);
    } catch (InvalidKeyException invalidKeyException) {
      throw new IllegalArgumentException(invalidKeyException);
    } 
  }
  
  public Hasher a() {
    if (this.e)
      try {
        return new MacHasher((Mac)this.a.clone());
      } catch (CloneNotSupportedException cloneNotSupportedException) {} 
    return new MacHasher(a(this.a.getAlgorithm(), this.b));
  }
  
  public int b() {
    return this.d;
  }
  
  public String toString() {
    return this.c;
  }
  
  static final class MacHasher extends AbstractByteHasher {
    private final Mac a;
    
    private boolean b;
    
    private MacHasher(Mac param1Mac) {
      this.a = param1Mac;
    }
    
    private void b() {
      Preconditions.b(this.b ^ true, "Cannot re-use a Hasher after calling hash() on it");
    }
    
    public HashCode a() {
      b();
      this.b = true;
      return HashCode.a(this.a.doFinal());
    }
    
    protected void a(byte param1Byte) {
      b();
      this.a.update(param1Byte);
    }
    
    protected void a(byte[] param1ArrayOfbyte) {
      b();
      this.a.update(param1ArrayOfbyte);
    }
    
    protected void a(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      b();
      this.a.update(param1ArrayOfbyte, param1Int1, param1Int2);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\hash\MacHashFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */