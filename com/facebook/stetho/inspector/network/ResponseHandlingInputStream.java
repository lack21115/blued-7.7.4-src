package com.facebook.stetho.inspector.network;

import com.facebook.stetho.inspector.console.CLog;
import com.facebook.stetho.inspector.helper.ChromePeerManager;
import com.facebook.stetho.inspector.protocol.module.Console;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class ResponseHandlingInputStream extends FilterInputStream {
  private static final int BUFFER_SIZE = 1024;
  
  public static final String TAG = "ResponseHandlingInputStream";
  
  private boolean mClosed;
  
  @Nullable
  private final CountingOutputStream mDecompressedCounter;
  
  private boolean mEofSeen;
  
  private long mLastDecompressedCount = 0L;
  
  private final ChromePeerManager mNetworkPeerManager;
  
  private final OutputStream mOutputStream;
  
  private final String mRequestId;
  
  private final ResponseHandler mResponseHandler;
  
  @Nullable
  private byte[] mSkipBuffer;
  
  public ResponseHandlingInputStream(InputStream paramInputStream, String paramString, OutputStream paramOutputStream, @Nullable CountingOutputStream paramCountingOutputStream, ChromePeerManager paramChromePeerManager, ResponseHandler paramResponseHandler) {
    super(paramInputStream);
    this.mRequestId = paramString;
    this.mOutputStream = paramOutputStream;
    this.mDecompressedCounter = paramCountingOutputStream;
    this.mNetworkPeerManager = paramChromePeerManager;
    this.mResponseHandler = paramResponseHandler;
    this.mClosed = false;
  }
  
  private int checkEOF(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: iconst_m1
    //   4: if_icmpne -> 33
    //   7: aload_0
    //   8: invokespecial closeOutputStreamQuietly : ()V
    //   11: aload_0
    //   12: getfield mResponseHandler : Lcom/facebook/stetho/inspector/network/ResponseHandler;
    //   15: invokeinterface onEOF : ()V
    //   20: aload_0
    //   21: iconst_1
    //   22: putfield mEofSeen : Z
    //   25: goto -> 33
    //   28: astore_2
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_2
    //   32: athrow
    //   33: aload_0
    //   34: monitorexit
    //   35: iload_1
    //   36: ireturn
    // Exception table:
    //   from	to	target	type
    //   7	25	28	finally
  }
  
  private void closeOutputStreamQuietly() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mClosed : Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne -> 97
    //   11: aload_0
    //   12: getfield mOutputStream : Ljava/io/OutputStream;
    //   15: invokevirtual close : ()V
    //   18: aload_0
    //   19: invokespecial reportDecodedSizeIfApplicable : ()V
    //   22: aload_0
    //   23: iconst_1
    //   24: putfield mClosed : Z
    //   27: goto -> 97
    //   30: astore_2
    //   31: goto -> 90
    //   34: astore_2
    //   35: aload_0
    //   36: getfield mNetworkPeerManager : Lcom/facebook/stetho/inspector/helper/ChromePeerManager;
    //   39: astore_3
    //   40: getstatic com/facebook/stetho/inspector/protocol/module/Console$MessageLevel.ERROR : Lcom/facebook/stetho/inspector/protocol/module/Console$MessageLevel;
    //   43: astore #4
    //   45: getstatic com/facebook/stetho/inspector/protocol/module/Console$MessageSource.NETWORK : Lcom/facebook/stetho/inspector/protocol/module/Console$MessageSource;
    //   48: astore #5
    //   50: new java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial <init> : ()V
    //   57: astore #6
    //   59: aload #6
    //   61: ldc 'Could not close the output stream'
    //   63: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload #6
    //   69: aload_2
    //   70: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload_3
    //   75: aload #4
    //   77: aload #5
    //   79: aload #6
    //   81: invokevirtual toString : ()Ljava/lang/String;
    //   84: invokestatic writeToConsole : (Lcom/facebook/stetho/inspector/helper/ChromePeerManager;Lcom/facebook/stetho/inspector/protocol/module/Console$MessageLevel;Lcom/facebook/stetho/inspector/protocol/module/Console$MessageSource;Ljava/lang/String;)V
    //   87: goto -> 22
    //   90: aload_0
    //   91: iconst_1
    //   92: putfield mClosed : Z
    //   95: aload_2
    //   96: athrow
    //   97: aload_0
    //   98: monitorexit
    //   99: return
    //   100: astore_2
    //   101: aload_0
    //   102: monitorexit
    //   103: aload_2
    //   104: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	100	finally
    //   11	22	34	java/io/IOException
    //   11	22	30	finally
    //   22	27	100	finally
    //   35	87	30	finally
    //   90	97	100	finally
  }
  
  @Nonnull
  private byte[] getSkipBufferLocked() {
    if (this.mSkipBuffer == null)
      this.mSkipBuffer = new byte[1024]; 
    return this.mSkipBuffer;
  }
  
  private IOException handleIOException(IOException paramIOException) {
    this.mResponseHandler.onError(paramIOException);
    return paramIOException;
  }
  
  private void handleIOExceptionWritingToStream(IOException paramIOException) {
    ChromePeerManager chromePeerManager = this.mNetworkPeerManager;
    Console.MessageLevel messageLevel = Console.MessageLevel.ERROR;
    Console.MessageSource messageSource = Console.MessageSource.NETWORK;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Could not write response body to the stream ");
    stringBuilder.append(paramIOException);
    CLog.writeToConsole(chromePeerManager, messageLevel, messageSource, stringBuilder.toString());
    closeOutputStreamQuietly();
  }
  
  private void reportDecodedSizeIfApplicable() {
    CountingOutputStream countingOutputStream = this.mDecompressedCounter;
    if (countingOutputStream != null) {
      long l = countingOutputStream.getCount();
      int i = (int)(l - this.mLastDecompressedCount);
      this.mResponseHandler.onReadDecoded(i);
      this.mLastDecompressedCount = l;
    } 
  }
  
  private void writeToOutputStream(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mClosed : Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield mOutputStream : Ljava/io/OutputStream;
    //   18: iload_1
    //   19: invokevirtual write : (I)V
    //   22: aload_0
    //   23: invokespecial reportDecodedSizeIfApplicable : ()V
    //   26: goto -> 35
    //   29: astore_3
    //   30: aload_0
    //   31: aload_3
    //   32: invokespecial handleIOExceptionWritingToStream : (Ljava/io/IOException;)V
    //   35: aload_0
    //   36: monitorexit
    //   37: return
    //   38: astore_3
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_3
    //   42: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	38	finally
    //   14	26	29	java/io/IOException
    //   14	26	38	finally
    //   30	35	38	finally
  }
  
  private void writeToOutputStream(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mClosed : Z
    //   6: istore #4
    //   8: iload #4
    //   10: ifeq -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: getfield mOutputStream : Ljava/io/OutputStream;
    //   20: aload_1
    //   21: iload_2
    //   22: iload_3
    //   23: invokevirtual write : ([BII)V
    //   26: aload_0
    //   27: invokespecial reportDecodedSizeIfApplicable : ()V
    //   30: goto -> 39
    //   33: astore_1
    //   34: aload_0
    //   35: aload_1
    //   36: invokespecial handleIOExceptionWritingToStream : (Ljava/io/IOException;)V
    //   39: aload_0
    //   40: monitorexit
    //   41: return
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Exception table:
    //   from	to	target	type
    //   2	8	42	finally
    //   16	30	33	java/io/IOException
    //   16	30	42	finally
    //   34	39	42	finally
  }
  
  public void close() throws IOException {
    try {
      long l;
      if (!this.mEofSeen) {
        byte[] arrayOfByte = new byte[1024];
        long l1 = 0L;
        while (true) {
          int i = read(arrayOfByte);
          l = l1;
          if (i != -1) {
            l1 += i;
            continue;
          } 
          break;
        } 
      } else {
        l = 0L;
      } 
      if (l > 0L) {
        ChromePeerManager chromePeerManager = this.mNetworkPeerManager;
        Console.MessageLevel messageLevel = Console.MessageLevel.ERROR;
        Console.MessageSource messageSource = Console.MessageSource.NETWORK;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("There were ");
        stringBuilder.append(String.valueOf(l));
        stringBuilder.append(" bytes that were not consumed while processing request ");
        stringBuilder.append(this.mRequestId);
        CLog.writeToConsole(chromePeerManager, messageLevel, messageSource, stringBuilder.toString());
      } 
      return;
    } finally {
      super.close();
      closeOutputStreamQuietly();
    } 
  }
  
  public void mark(int paramInt) {}
  
  public boolean markSupported() {
    return false;
  }
  
  public int read() throws IOException {
    try {
      int i = checkEOF(this.in.read());
      if (i != -1) {
        this.mResponseHandler.onRead(1);
        writeToOutputStream(i);
      } 
      return i;
    } catch (IOException iOException) {
      throw handleIOException(iOException);
    } 
  }
  
  public int read(byte[] paramArrayOfbyte) throws IOException {
    return read(paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    try {
      paramInt2 = checkEOF(this.in.read(paramArrayOfbyte, paramInt1, paramInt2));
      if (paramInt2 != -1) {
        this.mResponseHandler.onRead(paramInt2);
        writeToOutputStream(paramArrayOfbyte, paramInt1, paramInt2);
      } 
      return paramInt2;
    } catch (IOException iOException) {
      throw handleIOException(iOException);
    } 
  }
  
  public void reset() throws IOException {
    throw new UnsupportedOperationException("Mark not supported");
  }
  
  public long skip(long paramLong) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial getSkipBufferLocked : ()[B
    //   6: astore #6
    //   8: lconst_0
    //   9: lstore #4
    //   11: lload #4
    //   13: lload_1
    //   14: lcmp
    //   15: ifge -> 56
    //   18: aload_0
    //   19: aload #6
    //   21: iconst_0
    //   22: aload #6
    //   24: arraylength
    //   25: i2l
    //   26: lload_1
    //   27: lload #4
    //   29: lsub
    //   30: invokestatic min : (JJ)J
    //   33: l2i
    //   34: invokevirtual read : ([BII)I
    //   37: istore_3
    //   38: iload_3
    //   39: iconst_m1
    //   40: if_icmpne -> 46
    //   43: goto -> 56
    //   46: lload #4
    //   48: iload_3
    //   49: i2l
    //   50: ladd
    //   51: lstore #4
    //   53: goto -> 11
    //   56: aload_0
    //   57: monitorexit
    //   58: lload #4
    //   60: lreturn
    //   61: astore #6
    //   63: aload_0
    //   64: monitorexit
    //   65: aload #6
    //   67: athrow
    // Exception table:
    //   from	to	target	type
    //   2	8	61	finally
    //   18	38	61	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\network\ResponseHandlingInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */