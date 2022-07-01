package com.facebook.stetho.dumpapp;

import com.facebook.stetho.common.LogUtil;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

class Framer {
  public static final byte ENTER_FRAME_PREFIX = 33;
  
  public static final byte EXIT_FRAME_PREFIX = 120;
  
  public static final byte STDERR_FRAME_PREFIX = 50;
  
  public static final byte STDIN_FRAME_PREFIX = 45;
  
  public static final byte STDIN_REQUEST_FRAME_PREFIX = 95;
  
  public static final byte STDOUT_FRAME_PREFIX = 49;
  
  private static final String TAG = "FramingSocket";
  
  private final DataInputStream mInput;
  
  private final DataOutputStream mMultiplexedOutputStream;
  
  private final PrintStream mStderr;
  
  private final InputStream mStdin;
  
  private final PrintStream mStdout;
  
  public Framer(InputStream paramInputStream, OutputStream paramOutputStream) throws IOException {
    this.mInput = new DataInputStream(paramInputStream);
    this.mMultiplexedOutputStream = new DataOutputStream(paramOutputStream);
    this.mStdin = new FramingInputStream();
    this.mStdout = new PrintStream(new BufferedOutputStream(new FramingOutputStream((byte)49)));
    this.mStderr = new PrintStream(new FramingOutputStream((byte)50));
  }
  
  private static <T extends Throwable> T handleSuppression(@Nullable T paramT1, T paramT2) {
    if (paramT1 == null)
      return paramT2; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Suppressed while handling ");
    stringBuilder.append(paramT1);
    LogUtil.i("FramingSocket", new Object[] { paramT2, stringBuilder.toString() });
    return paramT1;
  }
  
  public PrintStream getStderr() {
    return this.mStderr;
  }
  
  public InputStream getStdin() {
    return this.mStdin;
  }
  
  public PrintStream getStdout() {
    return this.mStdout;
  }
  
  public byte readFrameType() throws IOException {
    return this.mInput.readByte();
  }
  
  public int readInt() throws IOException {
    return this.mInput.readInt();
  }
  
  public String readString() throws IOException {
    byte[] arrayOfByte = new byte[this.mInput.readUnsignedShort()];
    this.mInput.readFully(arrayOfByte);
    return new String(arrayOfByte, Charset.forName("UTF-8"));
  }
  
  public void writeBlob(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    this.mMultiplexedOutputStream.write(paramArrayOfbyte, paramInt1, paramInt2);
  }
  
  public void writeExitCode(int paramInt) throws IOException {
    this.mStdout.flush();
    this.mStderr.flush();
    writeIntFrame((byte)120, paramInt);
  }
  
  public void writeIntFrame(byte paramByte, int paramInt) throws IOException {
    this.mMultiplexedOutputStream.write(paramByte);
    this.mMultiplexedOutputStream.writeInt(paramInt);
  }
  
  static class ClosedHelper {
    private volatile boolean mClosed;
    
    private ClosedHelper() {}
    
    public void close() {
      this.mClosed = true;
    }
    
    public void throwIfClosed() throws IOException {
      if (!this.mClosed)
        return; 
      throw new IOException("Stream is closed");
    }
  }
  
  class FramingInputStream extends InputStream {
    private final Framer.ClosedHelper mClosedHelper = new Framer.ClosedHelper();
    
    private FramingInputStream() {}
    
    public void close() throws IOException {
      this.mClosedHelper.close();
    }
    
    public int read() throws IOException {
      byte[] arrayOfByte = new byte[1];
      return (read(arrayOfByte) == 0) ? -1 : arrayOfByte[0];
    }
    
    public int read(byte[] param1ArrayOfbyte) throws IOException {
      return read(param1ArrayOfbyte, 0, param1ArrayOfbyte.length);
    }
    
    public int read(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
      this.mClosedHelper.throwIfClosed();
      synchronized (Framer.this) {
        Framer.this.writeIntFrame((byte)95, param1Int2);
        byte b = Framer.this.readFrameType();
        if (b == 45) {
          int i = Framer.this.readInt();
          if (i > 0)
            if (i <= param1Int2) {
              Framer.this.mInput.readFully(param1ArrayOfbyte, param1Int1, i);
            } else {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("Expected at most ");
              stringBuilder.append(param1Int2);
              stringBuilder.append(" bytes, got: ");
              stringBuilder.append(i);
              throw new DumpappFramingException(stringBuilder.toString());
            }  
          return i;
        } 
        throw new UnexpectedFrameException((byte)45, b);
      } 
    }
    
    public long skip(long param1Long) throws IOException {
      // Byte code:
      //   0: lload_1
      //   1: ldc2_w 2048
      //   4: invokestatic min : (JJ)J
      //   7: l2i
      //   8: newarray byte
      //   10: astore #7
      //   12: aload_0
      //   13: getfield this$0 : Lcom/facebook/stetho/dumpapp/Framer;
      //   16: astore #6
      //   18: aload #6
      //   20: monitorenter
      //   21: lconst_0
      //   22: lstore #4
      //   24: lload #4
      //   26: lload_1
      //   27: lcmp
      //   28: ifge -> 45
      //   31: aload_0
      //   32: aload #7
      //   34: invokevirtual read : ([B)I
      //   37: istore_3
      //   38: iload_3
      //   39: ifge -> 59
      //   42: goto -> 45
      //   45: aload #6
      //   47: monitorexit
      //   48: lload #4
      //   50: lreturn
      //   51: astore #7
      //   53: aload #6
      //   55: monitorexit
      //   56: aload #7
      //   58: athrow
      //   59: lload #4
      //   61: iload_3
      //   62: i2l
      //   63: ladd
      //   64: lstore #4
      //   66: goto -> 24
      // Exception table:
      //   from	to	target	type
      //   31	38	51	finally
      //   45	48	51	finally
      //   53	56	51	finally
    }
  }
  
  class FramingOutputStream extends OutputStream {
    private final Framer.ClosedHelper mClosedHelper = new Framer.ClosedHelper();
    
    private final byte mPrefix;
    
    public FramingOutputStream(byte param1Byte) {
      this.mPrefix = param1Byte;
    }
    
    public void close() throws IOException {
      this.mClosedHelper.close();
    }
    
    public void write(int param1Int) throws IOException {
      byte[] arrayOfByte = new byte[1];
      arrayOfByte[0] = (byte)param1Int;
      write(arrayOfByte, 0, arrayOfByte.length);
    }
    
    public void write(byte[] param1ArrayOfbyte) throws IOException {
      write(param1ArrayOfbyte, 0, param1ArrayOfbyte.length);
    }
    
    public void write(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
      this.mClosedHelper.throwIfClosed();
      if (param1Int2 > 0)
        try {
          synchronized (Framer.this) {
            Framer.this.writeIntFrame(this.mPrefix, param1Int2);
            Framer.this.writeBlob(param1ArrayOfbyte, param1Int1, param1Int2);
            Framer.this.mMultiplexedOutputStream.flush();
            return;
          } 
        } catch (IOException iOException) {
          throw new DumpappOutputBrokenException(iOException);
        }  
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\dumpapp\Framer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */