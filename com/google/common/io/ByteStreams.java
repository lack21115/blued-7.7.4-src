package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.Deque;

public final class ByteStreams {
  private static final OutputStream a = new OutputStream() {
      public String toString() {
        return "ByteStreams.nullOutputStream()";
      }
      
      public void write(int param1Int) {}
      
      public void write(byte[] param1ArrayOfbyte) {
        Preconditions.a(param1ArrayOfbyte);
      }
      
      public void write(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
        Preconditions.a(param1ArrayOfbyte);
      }
    };
  
  public static long a(InputStream paramInputStream, OutputStream paramOutputStream) throws IOException {
    Preconditions.a(paramInputStream);
    Preconditions.a(paramOutputStream);
    byte[] arrayOfByte = a();
    for (long l = 0L;; l += i) {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1)
        return l; 
      paramOutputStream.write(arrayOfByte, 0, i);
    } 
  }
  
  public static InputStream a(InputStream paramInputStream, long paramLong) {
    return new LimitedInputStream(paramInputStream, paramLong);
  }
  
  public static void a(InputStream paramInputStream, byte[] paramArrayOfbyte) throws IOException {
    a(paramInputStream, paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  public static void a(InputStream paramInputStream, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    paramInt1 = b(paramInputStream, paramArrayOfbyte, paramInt1, paramInt2);
    if (paramInt1 == paramInt2)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("reached end of stream after reading ");
    stringBuilder.append(paramInt1);
    stringBuilder.append(" bytes; ");
    stringBuilder.append(paramInt2);
    stringBuilder.append(" bytes expected");
    throw new EOFException(stringBuilder.toString());
  }
  
  static byte[] a() {
    return new byte[8192];
  }
  
  public static byte[] a(InputStream paramInputStream) throws IOException {
    Preconditions.a(paramInputStream);
    return a(paramInputStream, (Deque)new ArrayDeque<byte>(20), 0);
  }
  
  private static byte[] a(InputStream paramInputStream, Deque<byte[]> paramDeque, int paramInt) throws IOException {
    int j = 8192;
    int i = paramInt;
    for (paramInt = j; i < 2147483639; paramInt = IntMath.f(paramInt, 2)) {
      byte[] arrayOfByte = new byte[Math.min(paramInt, 2147483639 - i)];
      paramDeque.add(arrayOfByte);
      j = 0;
      while (j < arrayOfByte.length) {
        int k = paramInputStream.read(arrayOfByte, j, arrayOfByte.length - j);
        if (k == -1)
          return a(paramDeque, i); 
        j += k;
        i += k;
      } 
    } 
    if (paramInputStream.read() == -1)
      return a(paramDeque, 2147483639); 
    throw new OutOfMemoryError("input is too large to fit in a byte array");
  }
  
  private static byte[] a(Deque<byte[]> paramDeque, int paramInt) {
    byte[] arrayOfByte = new byte[paramInt];
    for (int i = paramInt; i > 0; i -= j) {
      byte[] arrayOfByte1 = paramDeque.removeFirst();
      int j = Math.min(i, arrayOfByte1.length);
      System.arraycopy(arrayOfByte1, 0, arrayOfByte, paramInt - i, j);
    } 
    return arrayOfByte;
  }
  
  public static int b(InputStream paramInputStream, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    Preconditions.a(paramInputStream);
    Preconditions.a(paramArrayOfbyte);
    int i = 0;
    if (paramInt2 >= 0) {
      Preconditions.a(paramInt1, paramInt1 + paramInt2, paramArrayOfbyte.length);
      while (i < paramInt2) {
        int j = paramInputStream.read(paramArrayOfbyte, paramInt1 + i, paramInt2 - i);
        if (j == -1)
          return i; 
        i += j;
      } 
      return i;
    } 
    throw new IndexOutOfBoundsException(String.format("len (%s) cannot be negative", new Object[] { Integer.valueOf(paramInt2) }));
  }
  
  static long b(InputStream paramInputStream, long paramLong) throws IOException {
    byte[] arrayOfByte = null;
    long l = 0L;
    while (l < paramLong) {
      long l3 = paramLong - l;
      long l2 = c(paramInputStream, l3);
      byte[] arrayOfByte1 = arrayOfByte;
      long l1 = l2;
      if (l2 == 0L) {
        int i = (int)Math.min(l3, 8192L);
        arrayOfByte1 = arrayOfByte;
        if (arrayOfByte == null)
          arrayOfByte1 = new byte[i]; 
        l2 = paramInputStream.read(arrayOfByte1, 0, i);
        l1 = l2;
        if (l2 == -1L)
          return l; 
      } 
      l += l1;
      arrayOfByte = arrayOfByte1;
    } 
    return l;
  }
  
  private static long c(InputStream paramInputStream, long paramLong) throws IOException {
    int i = paramInputStream.available();
    return (i == 0) ? 0L : paramInputStream.skip(Math.min(i, paramLong));
  }
  
  static class ByteArrayDataInputStream implements ByteArrayDataInput {
    final DataInput a;
    
    public boolean readBoolean() {
      try {
        return this.a.readBoolean();
      } catch (IOException iOException) {
        throw new IllegalStateException(iOException);
      } 
    }
    
    public byte readByte() {
      try {
        return this.a.readByte();
      } catch (EOFException eOFException) {
        throw new IllegalStateException(eOFException);
      } catch (IOException iOException) {
        throw new AssertionError(iOException);
      } 
    }
    
    public char readChar() {
      try {
        return this.a.readChar();
      } catch (IOException iOException) {
        throw new IllegalStateException(iOException);
      } 
    }
    
    public double readDouble() {
      try {
        return this.a.readDouble();
      } catch (IOException iOException) {
        throw new IllegalStateException(iOException);
      } 
    }
    
    public float readFloat() {
      try {
        return this.a.readFloat();
      } catch (IOException iOException) {
        throw new IllegalStateException(iOException);
      } 
    }
    
    public void readFully(byte[] param1ArrayOfbyte) {
      try {
        this.a.readFully(param1ArrayOfbyte);
        return;
      } catch (IOException iOException) {
        throw new IllegalStateException(iOException);
      } 
    }
    
    public void readFully(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      try {
        this.a.readFully(param1ArrayOfbyte, param1Int1, param1Int2);
        return;
      } catch (IOException iOException) {
        throw new IllegalStateException(iOException);
      } 
    }
    
    public int readInt() {
      try {
        return this.a.readInt();
      } catch (IOException iOException) {
        throw new IllegalStateException(iOException);
      } 
    }
    
    public String readLine() {
      try {
        return this.a.readLine();
      } catch (IOException iOException) {
        throw new IllegalStateException(iOException);
      } 
    }
    
    public long readLong() {
      try {
        return this.a.readLong();
      } catch (IOException iOException) {
        throw new IllegalStateException(iOException);
      } 
    }
    
    public short readShort() {
      try {
        return this.a.readShort();
      } catch (IOException iOException) {
        throw new IllegalStateException(iOException);
      } 
    }
    
    public String readUTF() {
      try {
        return this.a.readUTF();
      } catch (IOException iOException) {
        throw new IllegalStateException(iOException);
      } 
    }
    
    public int readUnsignedByte() {
      try {
        return this.a.readUnsignedByte();
      } catch (IOException iOException) {
        throw new IllegalStateException(iOException);
      } 
    }
    
    public int readUnsignedShort() {
      try {
        return this.a.readUnsignedShort();
      } catch (IOException iOException) {
        throw new IllegalStateException(iOException);
      } 
    }
    
    public int skipBytes(int param1Int) {
      try {
        return this.a.skipBytes(param1Int);
      } catch (IOException iOException) {
        throw new IllegalStateException(iOException);
      } 
    }
  }
  
  static class ByteArrayDataOutputStream implements ByteArrayDataOutput {
    final DataOutput a;
    
    public void write(int param1Int) {
      try {
        this.a.write(param1Int);
        return;
      } catch (IOException iOException) {
        throw new AssertionError(iOException);
      } 
    }
    
    public void write(byte[] param1ArrayOfbyte) {
      try {
        this.a.write(param1ArrayOfbyte);
        return;
      } catch (IOException iOException) {
        throw new AssertionError(iOException);
      } 
    }
    
    public void write(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      try {
        this.a.write(param1ArrayOfbyte, param1Int1, param1Int2);
        return;
      } catch (IOException iOException) {
        throw new AssertionError(iOException);
      } 
    }
    
    public void writeBoolean(boolean param1Boolean) {
      try {
        this.a.writeBoolean(param1Boolean);
        return;
      } catch (IOException iOException) {
        throw new AssertionError(iOException);
      } 
    }
    
    public void writeByte(int param1Int) {
      try {
        this.a.writeByte(param1Int);
        return;
      } catch (IOException iOException) {
        throw new AssertionError(iOException);
      } 
    }
    
    public void writeBytes(String param1String) {
      try {
        this.a.writeBytes(param1String);
        return;
      } catch (IOException iOException) {
        throw new AssertionError(iOException);
      } 
    }
    
    public void writeChar(int param1Int) {
      try {
        this.a.writeChar(param1Int);
        return;
      } catch (IOException iOException) {
        throw new AssertionError(iOException);
      } 
    }
    
    public void writeChars(String param1String) {
      try {
        this.a.writeChars(param1String);
        return;
      } catch (IOException iOException) {
        throw new AssertionError(iOException);
      } 
    }
    
    public void writeDouble(double param1Double) {
      try {
        this.a.writeDouble(param1Double);
        return;
      } catch (IOException iOException) {
        throw new AssertionError(iOException);
      } 
    }
    
    public void writeFloat(float param1Float) {
      try {
        this.a.writeFloat(param1Float);
        return;
      } catch (IOException iOException) {
        throw new AssertionError(iOException);
      } 
    }
    
    public void writeInt(int param1Int) {
      try {
        this.a.writeInt(param1Int);
        return;
      } catch (IOException iOException) {
        throw new AssertionError(iOException);
      } 
    }
    
    public void writeLong(long param1Long) {
      try {
        this.a.writeLong(param1Long);
        return;
      } catch (IOException iOException) {
        throw new AssertionError(iOException);
      } 
    }
    
    public void writeShort(int param1Int) {
      try {
        this.a.writeShort(param1Int);
        return;
      } catch (IOException iOException) {
        throw new AssertionError(iOException);
      } 
    }
    
    public void writeUTF(String param1String) {
      try {
        this.a.writeUTF(param1String);
        return;
      } catch (IOException iOException) {
        throw new AssertionError(iOException);
      } 
    }
  }
  
  static final class LimitedInputStream extends FilterInputStream {
    private long a;
    
    private long b;
    
    LimitedInputStream(InputStream param1InputStream, long param1Long) {
      super(param1InputStream);
      boolean bool;
      this.b = -1L;
      Preconditions.a(param1InputStream);
      if (param1Long >= 0L) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.a(bool, "limit must be non-negative");
      this.a = param1Long;
    }
    
    public int available() throws IOException {
      return (int)Math.min(this.in.available(), this.a);
    }
    
    public void mark(int param1Int) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield in : Ljava/io/InputStream;
      //   6: iload_1
      //   7: invokevirtual mark : (I)V
      //   10: aload_0
      //   11: aload_0
      //   12: getfield a : J
      //   15: putfield b : J
      //   18: aload_0
      //   19: monitorexit
      //   20: return
      //   21: astore_2
      //   22: aload_0
      //   23: monitorexit
      //   24: aload_2
      //   25: athrow
      // Exception table:
      //   from	to	target	type
      //   2	18	21	finally
    }
    
    public int read() throws IOException {
      if (this.a == 0L)
        return -1; 
      int i = this.in.read();
      if (i != -1)
        this.a--; 
      return i;
    }
    
    public int read(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
      long l = this.a;
      if (l == 0L)
        return -1; 
      param1Int2 = (int)Math.min(param1Int2, l);
      param1Int1 = this.in.read(param1ArrayOfbyte, param1Int1, param1Int2);
      if (param1Int1 != -1)
        this.a -= param1Int1; 
      return param1Int1;
    }
    
    public void reset() throws IOException {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield in : Ljava/io/InputStream;
      //   6: invokevirtual markSupported : ()Z
      //   9: ifeq -> 51
      //   12: aload_0
      //   13: getfield b : J
      //   16: ldc2_w -1
      //   19: lcmp
      //   20: ifeq -> 41
      //   23: aload_0
      //   24: getfield in : Ljava/io/InputStream;
      //   27: invokevirtual reset : ()V
      //   30: aload_0
      //   31: aload_0
      //   32: getfield b : J
      //   35: putfield a : J
      //   38: aload_0
      //   39: monitorexit
      //   40: return
      //   41: new java/io/IOException
      //   44: dup
      //   45: ldc 'Mark not set'
      //   47: invokespecial <init> : (Ljava/lang/String;)V
      //   50: athrow
      //   51: new java/io/IOException
      //   54: dup
      //   55: ldc 'Mark not supported'
      //   57: invokespecial <init> : (Ljava/lang/String;)V
      //   60: athrow
      //   61: astore_1
      //   62: aload_0
      //   63: monitorexit
      //   64: aload_1
      //   65: athrow
      // Exception table:
      //   from	to	target	type
      //   2	38	61	finally
      //   41	51	61	finally
      //   51	61	61	finally
    }
    
    public long skip(long param1Long) throws IOException {
      param1Long = Math.min(param1Long, this.a);
      param1Long = this.in.skip(param1Long);
      this.a -= param1Long;
      return param1Long;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\io\ByteStreams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */