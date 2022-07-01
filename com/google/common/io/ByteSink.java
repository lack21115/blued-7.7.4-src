package com.google.common.io;

import java.nio.charset.Charset;

public abstract class ByteSink {
  final class AsCharSink extends CharSink {
    private final Charset b;
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.a.toString());
      stringBuilder.append(".asCharSink(");
      stringBuilder.append(this.b);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\io\ByteSink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */