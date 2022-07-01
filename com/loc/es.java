package com.loc;

import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class es {
  public static final ThreadLocal<Charset> a;
  
  private static final ThreadLocal<CharsetDecoder> b = new ThreadLocal<CharsetDecoder>() {
    
    };
  
  private static final ThreadLocal<CharBuffer> c;
  
  static {
    a = new ThreadLocal<Charset>() {
      
      };
    c = new ThreadLocal<CharBuffer>();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\es.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */