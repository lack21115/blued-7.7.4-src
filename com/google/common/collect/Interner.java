package com.google.common.collect;

import com.google.errorprone.annotations.DoNotMock;

@DoNotMock("Use Interners.new*Interner")
public interface Interner<E> {
  E a(E paramE);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\Interner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */