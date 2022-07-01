package com.google.common.collect;

import com.google.errorprone.annotations.DoNotMock;
import java.util.Iterator;

@DoNotMock("Use Iterators.peekingIterator")
public interface PeekingIterator<E> extends Iterator<E> {
  E a();
  
  E next();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\PeekingIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */