package com.qq.e.comm.plugin.p;

import android.graphics.Bitmap;
import android.graphics.Movie;

final class c {
  private Bitmap a;
  
  private Movie b;
  
  c() {}
  
  c(Bitmap paramBitmap) {
    this.a = paramBitmap;
  }
  
  c(Movie paramMovie) {
    this.b = paramMovie;
  }
  
  boolean a() {
    return (this.b != null);
  }
  
  Movie b() {
    return this.b;
  }
  
  Bitmap c() {
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\p\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */