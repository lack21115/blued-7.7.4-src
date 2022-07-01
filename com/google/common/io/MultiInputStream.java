package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class MultiInputStream extends InputStream {
  private Iterator<? extends ByteSource> a;
  
  @NullableDecl
  private InputStream b;
  
  public MultiInputStream(Iterator<? extends ByteSource> paramIterator) throws IOException {
    this.a = (Iterator<? extends ByteSource>)Preconditions.a(paramIterator);
    a();
  }
  
  private void a() throws IOException {
    close();
    if (this.a.hasNext())
      this.b = ((ByteSource)this.a.next()).a(); 
  }
  
  public int available() throws IOException {
    InputStream inputStream = this.b;
    return (inputStream == null) ? 0 : inputStream.available();
  }
  
  public void close() throws IOException {
    InputStream inputStream = this.b;
    if (inputStream != null)
      try {
        inputStream.close();
        return;
      } finally {
        this.b = null;
      }  
  }
  
  public boolean markSupported() {
    return false;
  }
  
  public int read() throws IOException {
    while (true) {
      InputStream inputStream = this.b;
      if (inputStream != null) {
        int i = inputStream.read();
        if (i != -1)
          return i; 
        a();
        continue;
      } 
      return -1;
    } 
  }
  
  public int read(@NullableDecl byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    while (true) {
      InputStream inputStream = this.b;
      if (inputStream != null) {
        int i = inputStream.read(paramArrayOfbyte, paramInt1, paramInt2);
        if (i != -1)
          return i; 
        a();
        continue;
      } 
      return -1;
    } 
  }
  
  public long skip(long paramLong) throws IOException {
    InputStream inputStream = this.b;
    if (inputStream != null) {
      if (paramLong <= 0L)
        return 0L; 
      long l = inputStream.skip(paramLong);
      return (l != 0L) ? l : ((read() == -1) ? 0L : (this.b.skip(paramLong - 1L) + 1L));
    } 
    return 0L;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\io\MultiInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */