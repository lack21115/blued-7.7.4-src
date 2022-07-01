package com.mcxiaoke.packer.support.walle;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.Map;

final class PayloadReader {
  public static ByteBuffer a(File paramFile, int paramInt) throws IOException {
    Map<Integer, ByteBuffer> map = a(paramFile);
    return (map == null) ? null : map.get(Integer.valueOf(paramInt));
  }
  
  private static Map<Integer, ByteBuffer> a(File paramFile) throws IOException {
    Map<Integer, ByteBuffer> map1;
    Closeable closeable;
    Map<Integer, ByteBuffer> map2 = null;
    File file = null;
    try {
      closeable = new RandomAccessFile(paramFile, "r");
    } finally {
      file = null;
      closeable = null;
    } 
    V2Utils.a((Closeable)map1);
    V2Utils.a(closeable);
    throw file;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\mcxiaoke\packer\support\walle\PayloadReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */