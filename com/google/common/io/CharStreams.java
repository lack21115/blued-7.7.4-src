package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Writer;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class CharStreams {
  static final class NullWriter extends Writer {
    private static final NullWriter a = new NullWriter();
    
    public Writer append(char param1Char) {
      return this;
    }
    
    public Writer append(@NullableDecl CharSequence param1CharSequence) {
      return this;
    }
    
    public Writer append(@NullableDecl CharSequence param1CharSequence, int param1Int1, int param1Int2) {
      int i;
      if (param1CharSequence == null) {
        i = 4;
      } else {
        i = param1CharSequence.length();
      } 
      Preconditions.a(param1Int1, param1Int2, i);
      return this;
    }
    
    public void close() {}
    
    public void flush() {}
    
    public String toString() {
      return "CharStreams.nullWriter()";
    }
    
    public void write(int param1Int) {}
    
    public void write(String param1String) {
      Preconditions.a(param1String);
    }
    
    public void write(String param1String, int param1Int1, int param1Int2) {
      Preconditions.a(param1Int1, param1Int2 + param1Int1, param1String.length());
    }
    
    public void write(char[] param1ArrayOfchar) {
      Preconditions.a(param1ArrayOfchar);
    }
    
    public void write(char[] param1ArrayOfchar, int param1Int1, int param1Int2) {
      Preconditions.a(param1Int1, param1Int2 + param1Int1, param1ArrayOfchar.length);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\io\CharStreams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */