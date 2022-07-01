package com.loc;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class bt {
  bv a;
  
  private ByteBuffer b;
  
  bt(int paramInt) {
    this.b = ByteBuffer.allocate(paramInt);
    this.b.order(ByteOrder.LITTLE_ENDIAN);
    this.a = new bv(this.b);
  }
  
  public final bt a() {
    this.a.a(this.b);
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */