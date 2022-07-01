package com.amap.api.mapcore2d;

import android.graphics.Bitmap;
import android.graphics.Canvas;

class i {
  private Bitmap a = null;
  
  private Canvas b = null;
  
  private Bitmap.Config c;
  
  public i(Bitmap.Config paramConfig) {
    this.c = paramConfig;
  }
  
  public void a(Bitmap paramBitmap) {
    this.a = paramBitmap;
    this.b = new Canvas(this.a);
  }
  
  public void a(j paramj) {
    this.b.save(1);
    paramj.a(this.b);
    this.b.restore();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */