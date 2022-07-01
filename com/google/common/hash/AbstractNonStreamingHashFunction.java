package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.ByteArrayOutputStream;

@Immutable
abstract class AbstractNonStreamingHashFunction extends AbstractHashFunction {
  public abstract HashCode a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2);
  
  public Hasher a() {
    return a(32);
  }
  
  public Hasher a(int paramInt) {
    boolean bool;
    if (paramInt >= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.a(bool);
    return new BufferingHasher(this, paramInt);
  }
  
  final class BufferingHasher extends AbstractHasher {
    final AbstractNonStreamingHashFunction.ExposedByteArrayOutputStream a;
    
    BufferingHasher(AbstractNonStreamingHashFunction this$0, int param1Int) {
      this.a = new AbstractNonStreamingHashFunction.ExposedByteArrayOutputStream(param1Int);
    }
    
    public HashCode a() {
      return this.b.a(this.a.a(), 0, this.a.b());
    }
    
    public Hasher b(byte param1Byte) {
      this.a.write(param1Byte);
      return this;
    }
    
    public Hasher b(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      this.a.write(param1ArrayOfbyte, param1Int1, param1Int2);
      return this;
    }
  }
  
  static final class ExposedByteArrayOutputStream extends ByteArrayOutputStream {
    ExposedByteArrayOutputStream(int param1Int) {
      super(param1Int);
    }
    
    byte[] a() {
      return this.buf;
    }
    
    int b() {
      return this.count;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\hash\AbstractNonStreamingHashFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */