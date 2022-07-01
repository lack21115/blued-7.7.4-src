package com.google.common.hash;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class BloomFilter<T> implements Predicate<T>, Serializable {
  private final BloomFilterStrategies.LockFreeBitArray a;
  
  private final int b;
  
  private final Funnel<? super T> c;
  
  private final Strategy d;
  
  @Deprecated
  public boolean a(T paramT) {
    return b(paramT);
  }
  
  public boolean b(T paramT) {
    return this.d.a(paramT, this.c, this.b, this.a);
  }
  
  public boolean equals(@NullableDecl Object paramObject) {
    if (paramObject == this)
      return true; 
    if (paramObject instanceof BloomFilter) {
      paramObject = paramObject;
      return (this.b == ((BloomFilter)paramObject).b && this.c.equals(((BloomFilter)paramObject).c) && this.a.equals(((BloomFilter)paramObject).a) && this.d.equals(((BloomFilter)paramObject).d));
    } 
    return false;
  }
  
  public int hashCode() {
    return Objects.a(new Object[] { Integer.valueOf(this.b), this.c, this.d, this.a });
  }
  
  static class SerialForm<T> implements Serializable {}
  
  static interface Strategy extends Serializable {
    <T> boolean a(T param1T, Funnel<? super T> param1Funnel, int param1Int, BloomFilterStrategies.LockFreeBitArray param1LockFreeBitArray);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\hash\BloomFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */