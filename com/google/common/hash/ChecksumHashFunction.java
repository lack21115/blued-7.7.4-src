package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.zip.Checksum;

@Immutable
final class ChecksumHashFunction extends AbstractHashFunction implements Serializable {
  private final ImmutableSupplier<? extends Checksum> a;
  
  private final int b;
  
  private final String c;
  
  ChecksumHashFunction(ImmutableSupplier<? extends Checksum> paramImmutableSupplier, int paramInt, String paramString) {
    boolean bool;
    this.a = (ImmutableSupplier<? extends Checksum>)Preconditions.a(paramImmutableSupplier);
    if (paramInt == 32 || paramInt == 64) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.a(bool, "bits (%s) must be either 32 or 64", paramInt);
    this.b = paramInt;
    this.c = (String)Preconditions.a(paramString);
  }
  
  public Hasher a() {
    return new ChecksumHasher((Checksum)this.a.get());
  }
  
  public int b() {
    return this.b;
  }
  
  public String toString() {
    return this.c;
  }
  
  final class ChecksumHasher extends AbstractByteHasher {
    private final Checksum b;
    
    private ChecksumHasher(ChecksumHashFunction this$0, Checksum param1Checksum) {
      this.b = (Checksum)Preconditions.a(param1Checksum);
    }
    
    public HashCode a() {
      long l = this.b.getValue();
      return (ChecksumHashFunction.a(this.a) == 32) ? HashCode.a((int)l) : HashCode.a(l);
    }
    
    protected void a(byte param1Byte) {
      this.b.update(param1Byte);
    }
    
    protected void a(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      this.b.update(param1ArrayOfbyte, param1Int1, param1Int2);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\hash\ChecksumHashFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */