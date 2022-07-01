package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.InvalidMarkException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

final class NioByteString extends ByteString.LeafByteString {
  private final ByteBuffer buffer;
  
  NioByteString(ByteBuffer paramByteBuffer) {
    Internal.checkNotNull(paramByteBuffer, "buffer");
    this.buffer = paramByteBuffer.slice().order(ByteOrder.nativeOrder());
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream) throws IOException {
    throw new InvalidObjectException("NioByteString instances are not to be serialized directly");
  }
  
  private ByteBuffer slice(int paramInt1, int paramInt2) {
    if (paramInt1 >= this.buffer.position() && paramInt2 <= this.buffer.limit() && paramInt1 <= paramInt2) {
      ByteBuffer byteBuffer = this.buffer.slice();
      byteBuffer.position(paramInt1 - this.buffer.position());
      byteBuffer.limit(paramInt2 - this.buffer.position());
      return byteBuffer;
    } 
    throw new IllegalArgumentException(String.format("Invalid indices [%d, %d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
  }
  
  private Object writeReplace() {
    return ByteString.copyFrom(this.buffer.slice());
  }
  
  public ByteBuffer asReadOnlyByteBuffer() {
    return this.buffer.asReadOnlyBuffer();
  }
  
  public List<ByteBuffer> asReadOnlyByteBufferList() {
    return Collections.singletonList(asReadOnlyByteBuffer());
  }
  
  public byte byteAt(int paramInt) {
    try {
      return this.buffer.get(paramInt);
    } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
      throw arrayIndexOutOfBoundsException;
    } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
      throw new ArrayIndexOutOfBoundsException(indexOutOfBoundsException.getMessage());
    } 
  }
  
  public void copyTo(ByteBuffer paramByteBuffer) {
    paramByteBuffer.put(this.buffer.slice());
  }
  
  protected void copyToInternal(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3) {
    ByteBuffer byteBuffer = this.buffer.slice();
    byteBuffer.position(paramInt1);
    byteBuffer.get(paramArrayOfbyte, paramInt2, paramInt3);
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof ByteString))
      return false; 
    ByteString byteString = (ByteString)paramObject;
    return (size() != byteString.size()) ? false : ((size() == 0) ? true : ((paramObject instanceof NioByteString) ? this.buffer.equals(((NioByteString)paramObject).buffer) : ((paramObject instanceof RopeByteString) ? paramObject.equals(this) : this.buffer.equals(byteString.asReadOnlyByteBuffer()))));
  }
  
  boolean equalsRange(ByteString paramByteString, int paramInt1, int paramInt2) {
    return substring(0, paramInt2).equals(paramByteString.substring(paramInt1, paramInt2 + paramInt1));
  }
  
  public byte internalByteAt(int paramInt) {
    return byteAt(paramInt);
  }
  
  public boolean isValidUtf8() {
    return Utf8.isValidUtf8(this.buffer);
  }
  
  public CodedInputStream newCodedInput() {
    return CodedInputStream.newInstance(this.buffer, true);
  }
  
  public InputStream newInput() {
    return new InputStream() {
        private final ByteBuffer buf = NioByteString.this.buffer.slice();
        
        public int available() throws IOException {
          return this.buf.remaining();
        }
        
        public void mark(int param1Int) {
          this.buf.mark();
        }
        
        public boolean markSupported() {
          return true;
        }
        
        public int read() throws IOException {
          return !this.buf.hasRemaining() ? -1 : (this.buf.get() & 0xFF);
        }
        
        public int read(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
          if (!this.buf.hasRemaining())
            return -1; 
          param1Int2 = Math.min(param1Int2, this.buf.remaining());
          this.buf.get(param1ArrayOfbyte, param1Int1, param1Int2);
          return param1Int2;
        }
        
        public void reset() throws IOException {
          try {
            this.buf.reset();
            return;
          } catch (InvalidMarkException invalidMarkException) {
            throw new IOException(invalidMarkException);
          } 
        }
      };
  }
  
  protected int partialHash(int paramInt1, int paramInt2, int paramInt3) {
    int i = paramInt1;
    for (paramInt1 = paramInt2; paramInt1 < paramInt2 + paramInt3; paramInt1++)
      i = i * 31 + this.buffer.get(paramInt1); 
    return i;
  }
  
  protected int partialIsValidUtf8(int paramInt1, int paramInt2, int paramInt3) {
    return Utf8.partialIsValidUtf8(paramInt1, this.buffer, paramInt2, paramInt3 + paramInt2);
  }
  
  public int size() {
    return this.buffer.remaining();
  }
  
  public ByteString substring(int paramInt1, int paramInt2) {
    try {
      return new NioByteString(slice(paramInt1, paramInt2));
    } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
      throw arrayIndexOutOfBoundsException;
    } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
      throw new ArrayIndexOutOfBoundsException(indexOutOfBoundsException.getMessage());
    } 
  }
  
  protected String toStringInternal(Charset paramCharset) {
    boolean bool;
    int i;
    byte[] arrayOfByte;
    if (this.buffer.hasArray()) {
      arrayOfByte = this.buffer.array();
      bool = this.buffer.arrayOffset() + this.buffer.position();
      i = this.buffer.remaining();
    } else {
      arrayOfByte = toByteArray();
      bool = false;
      i = arrayOfByte.length;
    } 
    return new String(arrayOfByte, bool, i, paramCharset);
  }
  
  void writeTo(ByteOutput paramByteOutput) throws IOException {
    paramByteOutput.writeLazy(this.buffer.slice());
  }
  
  public void writeTo(OutputStream paramOutputStream) throws IOException {
    paramOutputStream.write(toByteArray());
  }
  
  void writeToInternal(OutputStream paramOutputStream, int paramInt1, int paramInt2) throws IOException {
    if (this.buffer.hasArray()) {
      int i = this.buffer.arrayOffset();
      int j = this.buffer.position();
      paramOutputStream.write(this.buffer.array(), i + j + paramInt1, paramInt2);
      return;
    } 
    ByteBufferWriter.write(slice(paramInt1, paramInt2 + paramInt1), paramOutputStream);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\NioByteString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */