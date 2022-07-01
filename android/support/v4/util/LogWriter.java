package android.support.v4.util;

import java.io.Writer;

public final class LogWriter extends Writer {
  private StringBuilder mBuilder = new StringBuilder(128);
  
  private void flushBuilder() {
    if (this.mBuilder.length() > 0)
      this.mBuilder.delete(0, this.mBuilder.length()); 
  }
  
  public final void close() {
    flushBuilder();
  }
  
  public final void flush() {
    flushBuilder();
  }
  
  public final void write(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
    int i;
    for (i = 0; i < paramInt2; i++) {
      char c = paramArrayOfchar[paramInt1 + i];
      if (c == '\n') {
        flushBuilder();
      } else {
        this.mBuilder.append(c);
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v\\util\LogWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */