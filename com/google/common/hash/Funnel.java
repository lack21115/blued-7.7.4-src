package com.google.common.hash;

import com.google.errorprone.annotations.DoNotMock;
import java.io.Serializable;

@DoNotMock("Implement with a lambda")
public interface Funnel<T> extends Serializable {
  void a(T paramT, PrimitiveSink paramPrimitiveSink);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\hash\Funnel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */