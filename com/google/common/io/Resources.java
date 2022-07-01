package com.google.common.io;

import com.google.common.collect.Lists;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public final class Resources {
  static final class UrlByteSource extends ByteSource {
    private final URL a;
    
    public InputStream a() throws IOException {
      return this.a.openStream();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Resources.asByteSource(");
      stringBuilder.append(this.a);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\io\Resources.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */