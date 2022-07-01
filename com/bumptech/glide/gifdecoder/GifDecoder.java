package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;

public interface GifDecoder {
  ByteBuffer a();
  
  void a(Bitmap.Config paramConfig);
  
  void b();
  
  int c();
  
  int d();
  
  int e();
  
  void f();
  
  int g();
  
  int h();
  
  Bitmap i();
  
  void j();
  
  public static interface BitmapProvider {
    Bitmap a(int param1Int1, int param1Int2, Bitmap.Config param1Config);
    
    void a(Bitmap param1Bitmap);
    
    void a(byte[] param1ArrayOfbyte);
    
    void a(int[] param1ArrayOfint);
    
    byte[] a(int param1Int);
    
    int[] b(int param1Int);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface GifDecodeStatus {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\gifdecoder\GifDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */