package com.google.common.io;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

class AppendableWriter extends Writer {
  private final Appendable a;
  
  private boolean b;
  
  private void a() throws IOException {
    if (!this.b)
      return; 
    throw new IOException("Cannot write to a closed writer.");
  }
  
  public Writer append(char paramChar) throws IOException {
    a();
    this.a.append(paramChar);
    return this;
  }
  
  public Writer append(@NullableDecl CharSequence paramCharSequence) throws IOException {
    a();
    this.a.append(paramCharSequence);
    return this;
  }
  
  public Writer append(@NullableDecl CharSequence paramCharSequence, int paramInt1, int paramInt2) throws IOException {
    a();
    this.a.append(paramCharSequence, paramInt1, paramInt2);
    return this;
  }
  
  public void close() throws IOException {
    this.b = true;
    Appendable appendable = this.a;
    if (appendable instanceof Closeable)
      ((Closeable)appendable).close(); 
  }
  
  public void flush() throws IOException {
    a();
    Appendable appendable = this.a;
    if (appendable instanceof Flushable)
      ((Flushable)appendable).flush(); 
  }
  
  public void write(int paramInt) throws IOException {
    a();
    this.a.append((char)paramInt);
  }
  
  public void write(@NullableDecl String paramString) throws IOException {
    a();
    this.a.append(paramString);
  }
  
  public void write(@NullableDecl String paramString, int paramInt1, int paramInt2) throws IOException {
    a();
    this.a.append(paramString, paramInt1, paramInt2 + paramInt1);
  }
  
  public void write(char[] paramArrayOfchar, int paramInt1, int paramInt2) throws IOException {
    a();
    this.a.append(new String(paramArrayOfchar, paramInt1, paramInt2));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\io\AppendableWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */