package com.blued.android.core.image.apng.decode;

import com.blued.android.core.image.apng.io.APNGReader;
import java.io.IOException;

class FCTLChunk extends Chunk {
  static final int a = Chunk.a("fcTL");
  
  int b;
  
  int c;
  
  int h;
  
  int i;
  
  int j;
  
  short k;
  
  short l;
  
  byte m;
  
  byte n;
  
  void a(APNGReader paramAPNGReader) throws IOException {
    this.b = paramAPNGReader.r_();
    this.c = paramAPNGReader.r_();
    this.h = paramAPNGReader.r_();
    this.i = paramAPNGReader.r_();
    this.j = paramAPNGReader.r_();
    this.k = paramAPNGReader.c();
    this.l = paramAPNGReader.c();
    this.m = paramAPNGReader.s_();
    this.n = paramAPNGReader.s_();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\image\apng\decode\FCTLChunk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */