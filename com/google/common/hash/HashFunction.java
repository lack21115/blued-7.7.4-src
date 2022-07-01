package com.google.common.hash;

import com.google.errorprone.annotations.Immutable;

@Immutable
public interface HashFunction {
  <T> HashCode a(T paramT, Funnel<? super T> paramFunnel);
  
  Hasher a();
  
  Hasher a(int paramInt);
  
  int b();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\hash\HashFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */