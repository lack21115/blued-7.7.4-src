package com.blued.android.core.image.apng.decode;

import com.blued.android.core.image.apng.io.APNGReader;
import java.io.IOException;

class FDATChunk extends Chunk {
  static final int a = Chunk.a("fdAT");
  
  int b;
  
  void a(APNGReader paramAPNGReader) throws IOException {
    this.b = paramAPNGReader.r_();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\image\apng\decode\FDATChunk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */