package com.google.protobuf;

import java.nio.ByteBuffer;

abstract class AllocatedBuffer {
  public static AllocatedBuffer wrap(final ByteBuffer buffer) {
    Internal.checkNotNull(buffer, "buffer");
    return new AllocatedBuffer() {
        public byte[] array() {
          return buffer.array();
        }
        
        public int arrayOffset() {
          return buffer.arrayOffset();
        }
        
        public boolean hasArray() {
          return buffer.hasArray();
        }
        
        public boolean hasNioBuffer() {
          return true;
        }
        
        public int limit() {
          return buffer.limit();
        }
        
        public ByteBuffer nioBuffer() {
          return buffer;
        }
        
        public int position() {
          return buffer.position();
        }
        
        public AllocatedBuffer position(int param1Int) {
          buffer.position(param1Int);
          return this;
        }
        
        public int remaining() {
          return buffer.remaining();
        }
      };
  }
  
  public static AllocatedBuffer wrap(byte[] paramArrayOfbyte) {
    return wrapNoCheck(paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  public static AllocatedBuffer wrap(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    if (paramInt1 >= 0 && paramInt2 >= 0 && paramInt1 + paramInt2 <= paramArrayOfbyte.length)
      return wrapNoCheck(paramArrayOfbyte, paramInt1, paramInt2); 
    throw new IndexOutOfBoundsException(String.format("bytes.length=%d, offset=%d, length=%d", new Object[] { Integer.valueOf(paramArrayOfbyte.length), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
  }
  
  private static AllocatedBuffer wrapNoCheck(final byte[] bytes, final int offset, final int length) {
    return new AllocatedBuffer() {
        private int position;
        
        public byte[] array() {
          return bytes;
        }
        
        public int arrayOffset() {
          return offset;
        }
        
        public boolean hasArray() {
          return true;
        }
        
        public boolean hasNioBuffer() {
          return false;
        }
        
        public int limit() {
          return length;
        }
        
        public ByteBuffer nioBuffer() {
          throw new UnsupportedOperationException();
        }
        
        public int position() {
          return this.position;
        }
        
        public AllocatedBuffer position(int param1Int) {
          if (param1Int >= 0 && param1Int <= length) {
            this.position = param1Int;
            return this;
          } 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Invalid position: ");
          stringBuilder.append(param1Int);
          throw new IllegalArgumentException(stringBuilder.toString());
        }
        
        public int remaining() {
          return length - this.position;
        }
      };
  }
  
  public abstract byte[] array();
  
  public abstract int arrayOffset();
  
  public abstract boolean hasArray();
  
  public abstract boolean hasNioBuffer();
  
  public abstract int limit();
  
  public abstract ByteBuffer nioBuffer();
  
  public abstract int position();
  
  public abstract AllocatedBuffer position(int paramInt);
  
  public abstract int remaining();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\AllocatedBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */