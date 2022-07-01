package com.facebook.stetho.server;

import com.facebook.stetho.common.LogUtil;
import java.io.IOException;
import java.io.InputStream;

public class CompositeInputStream extends InputStream {
  private int mCurrentIndex;
  
  private final InputStream[] mStreams;
  
  public CompositeInputStream(InputStream[] paramArrayOfInputStream) {
    if (paramArrayOfInputStream != null && paramArrayOfInputStream.length >= 2) {
      this.mStreams = paramArrayOfInputStream;
      this.mCurrentIndex = 0;
      return;
    } 
    throw new IllegalArgumentException("Streams must be non-null and have more than 1 entry");
  }
  
  private void closeAll(int paramInt) throws IOException {
    IOException iOException = null;
    int i = 0;
    while (true) {
      InputStream[] arrayOfInputStream = this.mStreams;
      if (i < arrayOfInputStream.length) {
        try {
          arrayOfInputStream[i].close();
        } catch (IOException iOException2) {
          IOException iOException1 = iOException2;
          if (i != paramInt)
            if (iOException == null) {
              iOException1 = iOException2;
            } else {
              iOException1 = iOException;
            }  
          if (iOException != null && iOException != iOException1)
            LogUtil.w(iOException, "Suppressing exception"); 
          iOException = iOException1;
        } 
        i++;
        continue;
      } 
      break;
    } 
  }
  
  private boolean tryMoveToNextStream() {
    int i = this.mCurrentIndex;
    if (i + 1 < this.mStreams.length) {
      this.mCurrentIndex = i + 1;
      return true;
    } 
    return false;
  }
  
  public int available() throws IOException {
    return this.mStreams[this.mCurrentIndex].available();
  }
  
  public void close() throws IOException {
    closeAll(this.mCurrentIndex);
  }
  
  public void mark(int paramInt) {
    throw new UnsupportedOperationException();
  }
  
  public boolean markSupported() {
    return false;
  }
  
  public int read() throws IOException {
    int i;
    do {
      i = this.mStreams[this.mCurrentIndex].read();
    } while (i == -1 && tryMoveToNextStream());
    return i;
  }
  
  public int read(byte[] paramArrayOfbyte) throws IOException {
    return read(paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    int i;
    do {
      i = this.mStreams[this.mCurrentIndex].read(paramArrayOfbyte, paramInt1, paramInt2);
    } while (i == -1 && tryMoveToNextStream());
    return i;
  }
  
  public void reset() throws IOException {
    throw new UnsupportedOperationException();
  }
  
  public long skip(long paramLong) throws IOException {
    int i = read(new byte[(int)paramLong]);
    return (i >= 0) ? i : -1L;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\server\CompositeInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */