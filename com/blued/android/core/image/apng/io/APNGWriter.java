package com.blued.android.core.image.apng.io;

import java.nio.ByteOrder;

public class APNGWriter extends ByteBufferWriter {
  public void a(int paramInt) {
    a((byte)(paramInt & 0xFF));
    a((byte)(paramInt >> 8 & 0xFF));
    a((byte)(paramInt >> 16 & 0xFF));
    a((byte)(paramInt >> 24 & 0xFF));
  }
  
  public void b(int paramInt) {
    a((byte)(paramInt >> 24 & 0xFF));
    a((byte)(paramInt >> 16 & 0xFF));
    a((byte)(paramInt >> 8 & 0xFF));
    a((byte)(paramInt & 0xFF));
  }
  
  public void c(int paramInt) {
    super.c(paramInt);
    this.a.order(ByteOrder.BIG_ENDIAN);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\image\apng\io\APNGWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */