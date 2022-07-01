package com.google.protobuf;

import java.util.NoSuchElementException;

final class ByteString$1 implements ByteString$ByteIterator {
  private final int limit = ByteString.this.size();
  
  private int position = 0;
  
  private byte nextByte() {
    try {
      ByteString byteString = ByteString.this;
      int i = this.position;
      this.position = i + 1;
      return byteString.byteAt(i);
    } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
      throw new NoSuchElementException(indexOutOfBoundsException.getMessage());
    } 
  }
  
  public final boolean hasNext() {
    return (this.position < this.limit);
  }
  
  public final void remove() {
    throw new UnsupportedOperationException();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\ByteString$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */