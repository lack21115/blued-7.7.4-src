package com.google.common.io;

import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.AbstractIterator;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.Iterator;

public abstract class CharSource {
  public abstract Reader a() throws IOException;
  
  final class AsByteSource extends ByteSource {
    final Charset a;
    
    public InputStream a() throws IOException {
      return new ReaderInputStream(this.b.a(), this.a, 8192);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.b.toString());
      stringBuilder.append(".asByteSource(");
      stringBuilder.append(this.a);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  static class CharSequenceCharSource extends CharSource {
    private static final Splitter b = Splitter.b("\r\n|\n|\r");
    
    protected final CharSequence a;
    
    protected CharSequenceCharSource(CharSequence param1CharSequence) {
      this.a = (CharSequence)Preconditions.a(param1CharSequence);
    }
    
    public Reader a() {
      return new CharSequenceReader(this.a);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("CharSource.wrap(");
      stringBuilder.append(Ascii.a(this.a, 30, "..."));
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  class null extends AbstractIterator<String> {
    Iterator<String> a;
    
    protected String c() {
      if (this.a.hasNext()) {
        String str = this.a.next();
        if (this.a.hasNext() || !str.isEmpty())
          return str; 
      } 
      return (String)b();
    }
  }
  
  static final class ConcatenatedCharSource extends CharSource {
    private final Iterable<? extends CharSource> a;
    
    public Reader a() throws IOException {
      return new MultiReader(this.a.iterator());
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("CharSource.concat(");
      stringBuilder.append(this.a);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  static final class EmptyCharSource extends StringCharSource {
    private static final EmptyCharSource b = new EmptyCharSource();
    
    private EmptyCharSource() {
      super("");
    }
    
    public String toString() {
      return "CharSource.empty()";
    }
  }
  
  static class StringCharSource extends CharSequenceCharSource {
    protected StringCharSource(String param1String) {
      super(param1String);
    }
    
    public Reader a() {
      return new StringReader((String)this.a);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\io\CharSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */