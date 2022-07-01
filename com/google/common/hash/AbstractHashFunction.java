package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;

@Immutable
abstract class AbstractHashFunction implements HashFunction {
  public <T> HashCode a(T paramT, Funnel<? super T> paramFunnel) {
    return a().<T>a(paramT, paramFunnel).a();
  }
  
  public HashCode a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    Preconditions.a(paramInt1, paramInt1 + paramInt2, paramArrayOfbyte.length);
    return a(paramInt2).b(paramArrayOfbyte, paramInt1, paramInt2).a();
  }
  
  public Hasher a(int paramInt) {
    boolean bool;
    if (paramInt >= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.a(bool, "expectedInputSize must be >= 0 but was %s", paramInt);
    return a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\hash\AbstractHashFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */