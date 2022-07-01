package com.google.protobuf;

import sun.misc.Unsafe;

abstract class UnsafeUtil$MemoryAccessor {
  Unsafe unsafe;
  
  UnsafeUtil$MemoryAccessor(Unsafe paramUnsafe) {
    this.unsafe = paramUnsafe;
  }
  
  public abstract void putByte(Object paramObject, long paramLong, byte paramByte);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\UnsafeUtil$MemoryAccessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */