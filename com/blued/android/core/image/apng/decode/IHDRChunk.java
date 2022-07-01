package com.blued.android.core.image.apng.decode;

import com.blued.android.core.image.apng.io.APNGReader;
import java.io.IOException;

class IHDRChunk extends Chunk {
  static final int a = Chunk.a("IHDR");
  
  int b;
  
  int c;
  
  byte[] h = new byte[5];
  
  void a(APNGReader paramAPNGReader) throws IOException {
    this.b = paramAPNGReader.r_();
    this.c = paramAPNGReader.r_();
    byte[] arrayOfByte = this.h;
    paramAPNGReader.read(arrayOfByte, 0, arrayOfByte.length);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\image\apng\decode\IHDRChunk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */