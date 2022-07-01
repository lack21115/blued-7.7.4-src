package com.google.protobuf;

import sun.misc.Unsafe;

final class UnsafeUtil$JvmMemoryAccessor extends UnsafeUtil$MemoryAccessor {
  UnsafeUtil$JvmMemoryAccessor(Unsafe paramUnsafe) {
    super(paramUnsafe);
  }
  
  public final void putByte(Object paramObject, long paramLong, byte paramByte) {
    this.unsafe.putByte(paramObject, paramLong, paramByte);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\UnsafeUtil$JvmMemoryAccessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */