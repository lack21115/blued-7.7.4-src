package com.google.common.io;

import com.google.common.base.Ascii;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

public abstract class ByteSource {
  public abstract InputStream a() throws IOException;
  
  class AsCharSource extends CharSource {
    final Charset a;
    
    public Reader a() throws IOException {
      return new InputStreamReader(this.b.a(), this.a);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.b.toString());
      stringBuilder.append(".asCharSource(");
      stringBuilder.append(this.a);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  static class ByteArrayByteSource extends ByteSource {
    final byte[] a;
    
    final int b;
    
    final int c;
    
    ByteArrayByteSource(byte[] param1ArrayOfbyte) {
      this(param1ArrayOfbyte, 0, param1ArrayOfbyte.length);
    }
    
    ByteArrayByteSource(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      this.a = param1ArrayOfbyte;
      this.b = param1Int1;
      this.c = param1Int2;
    }
    
    public InputStream a() {
      return new ByteArrayInputStream(this.a, this.b, this.c);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("ByteSource.wrap(");
      stringBuilder.append(Ascii.a(BaseEncoding.d().a(this.a, this.b, this.c), 30, "..."));
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  static final class ConcatenatedByteSource extends ByteSource {
    final Iterable<? extends ByteSource> a;
    
    public InputStream a() throws IOException {
      return new MultiInputStream(this.a.iterator());
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("ByteSource.concat(");
      stringBuilder.append(this.a);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  static final class EmptyByteSource extends ByteArrayByteSource {
    static final EmptyByteSource d = new EmptyByteSource();
    
    EmptyByteSource() {
      super(new byte[0]);
    }
    
    public String toString() {
      return "ByteSource.empty()";
    }
  }
  
  final class SlicedByteSource extends ByteSource {
    final long a;
    
    final long b;
    
    private InputStream a(InputStream param1InputStream) throws IOException {
      long l = this.a;
      if (l > 0L)
        try {
        
        } finally {
          Exception exception = null;
          Closer closer = Closer.a();
          closer.a(param1InputStream);
        }  
      return ByteStreams.a(param1InputStream, this.b);
    }
    
    public InputStream a() throws IOException {
      return a(this.c.a());
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.c.toString());
      stringBuilder.append(".slice(");
      stringBuilder.append(this.a);
      stringBuilder.append(", ");
      stringBuilder.append(this.b);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\io\ByteSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */