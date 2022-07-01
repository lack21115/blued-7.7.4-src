package com.google.common.graph;

import com.google.common.base.Function;
import com.google.errorprone.annotations.Immutable;
import java.util.Set;

@Immutable(containerOf = {"N", "E"})
public final class ImmutableNetwork<N, E> extends StandardNetwork<N, E> {
  public static class Builder<N, E> {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\graph\ImmutableNetwork.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */