package com.google.protobuf;

import java.util.Iterator;

final class SmallSortedMap$EmptySet {
  private static final Iterable ITERABLE;
  
  private static final Iterator ITERATOR = new SmallSortedMap$EmptySet$1();
  
  static {
    ITERABLE = new SmallSortedMap$EmptySet$2();
    throw new VerifyError("bad dex opcode");
  }
  
  static Iterable iterable() {
    return ITERABLE;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\SmallSortedMap$EmptySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */