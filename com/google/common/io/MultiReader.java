package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

class MultiReader extends Reader {
  private final Iterator<? extends CharSource> a;
  
  @NullableDecl
  private Reader b;
  
  MultiReader(Iterator<? extends CharSource> paramIterator) throws IOException {
    this.a = paramIterator;
    a();
  }
  
  private void a() throws IOException {
    close();
    if (this.a.hasNext())
      this.b = ((CharSource)this.a.next()).a(); 
  }
  
  public void close() throws IOException {
    Reader reader = this.b;
    if (reader != null)
      try {
        reader.close();
        return;
      } finally {
        this.b = null;
      }  
  }
  
  public int read(@NullableDecl char[] paramArrayOfchar, int paramInt1, int paramInt2) throws IOException {
    Reader reader = this.b;
    if (reader == null)
      return -1; 
    int i = reader.read(paramArrayOfchar, paramInt1, paramInt2);
    if (i == -1) {
      a();
      return read(paramArrayOfchar, paramInt1, paramInt2);
    } 
    return i;
  }
  
  public boolean ready() throws IOException {
    Reader reader = this.b;
    return (reader != null && reader.ready());
  }
  
  public long skip(long paramLong) throws IOException {
    boolean bool;
    int i = paramLong cmp 0L;
    if (i >= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.a(bool, "n is negative");
    if (i > 0)
      while (true) {
        Reader reader = this.b;
        if (reader != null) {
          long l = reader.skip(paramLong);
          if (l > 0L)
            return l; 
          a();
          continue;
        } 
        break;
      }  
    return 0L;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\io\MultiReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */