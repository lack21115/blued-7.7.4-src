package com.google.common.reflect;

import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ImmutableMap;
import java.util.Map;

public final class ImmutableTypeToInstanceMap<B> extends ForwardingMap<TypeToken<? extends B>, B> implements TypeToInstanceMap<B> {
  private final ImmutableMap<TypeToken<? extends B>, B> a;
  
  @Deprecated
  public B a(TypeToken<? extends B> paramTypeToken, B paramB) {
    throw new UnsupportedOperationException();
  }
  
  public Map<TypeToken<? extends B>, B> a() {
    return (Map<TypeToken<? extends B>, B>)this.a;
  }
  
  @Deprecated
  public void putAll(Map<? extends TypeToken<? extends B>, ? extends B> paramMap) {
    throw new UnsupportedOperationException();
  }
  
  public static final class Builder<B> {
    private final ImmutableMap.Builder<TypeToken<? extends B>, B> a = ImmutableMap.k();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\reflect\ImmutableTypeToInstanceMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */