package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@Immutable
final class MessageDigestHashFunction extends AbstractHashFunction implements Serializable {
  private final MessageDigest a;
  
  private final int b;
  
  private final boolean c;
  
  private final String d;
  
  MessageDigestHashFunction(String paramString1, String paramString2) {
    this.a = a(paramString1);
    this.b = this.a.getDigestLength();
    this.d = (String)Preconditions.a(paramString2);
    this.c = a(this.a);
  }
  
  private static MessageDigest a(String paramString) {
    try {
      return MessageDigest.getInstance(paramString);
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      throw new AssertionError(noSuchAlgorithmException);
    } 
  }
  
  private static boolean a(MessageDigest paramMessageDigest) {
    try {
      paramMessageDigest.clone();
      return true;
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      return false;
    } 
  }
  
  public Hasher a() {
    if (this.c)
      try {
        return new MessageDigestHasher((MessageDigest)this.a.clone(), this.b);
      } catch (CloneNotSupportedException cloneNotSupportedException) {} 
    return new MessageDigestHasher(a(this.a.getAlgorithm()), this.b);
  }
  
  public int b() {
    return this.b * 8;
  }
  
  public String toString() {
    return this.d;
  }
  
  static final class MessageDigestHasher extends AbstractByteHasher {
    private final MessageDigest a;
    
    private final int b;
    
    private boolean c;
    
    private MessageDigestHasher(MessageDigest param1MessageDigest, int param1Int) {
      this.a = param1MessageDigest;
      this.b = param1Int;
    }
    
    private void b() {
      Preconditions.b(this.c ^ true, "Cannot re-use a Hasher after calling hash() on it");
    }
    
    public HashCode a() {
      b();
      this.c = true;
      return (this.b == this.a.getDigestLength()) ? HashCode.a(this.a.digest()) : HashCode.a(Arrays.copyOf(this.a.digest(), this.b));
    }
    
    protected void a(byte param1Byte) {
      b();
      this.a.update(param1Byte);
    }
    
    protected void a(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      b();
      this.a.update(param1ArrayOfbyte, param1Int1, param1Int2);
    }
  }
  
  static final class SerializedForm implements Serializable {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\hash\MessageDigestHashFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */