package com.google.common.collect;

import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.Map;

@Immutable(containerOf = {"B"})
public final class ImmutableClassToInstanceMap<B> extends ForwardingMap<Class<? extends B>, B> implements ClassToInstanceMap<B>, Serializable {
  private static final ImmutableClassToInstanceMap<Object> a = new ImmutableClassToInstanceMap(ImmutableMap.j());
  
  private final ImmutableMap<Class<? extends B>, B> b;
  
  private ImmutableClassToInstanceMap(ImmutableMap<Class<? extends B>, B> paramImmutableMap) {
    this.b = paramImmutableMap;
  }
  
  protected Map<Class<? extends B>, B> a() {
    return this.b;
  }
  
  public static final class Builder<B> {
    private final ImmutableMap.Builder<Class<? extends B>, B> a = ImmutableMap.k();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ImmutableClassToInstanceMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */