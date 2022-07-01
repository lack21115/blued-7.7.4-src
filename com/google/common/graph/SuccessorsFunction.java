package com.google.common.graph;

import com.google.errorprone.annotations.DoNotMock;

@DoNotMock("Implement with a lambda, or use GraphBuilder to build a Graph with the desired edges")
public interface SuccessorsFunction<N> {
  Iterable<? extends N> h(N paramN);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\graph\SuccessorsFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */