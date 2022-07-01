package com.blued.android.core.imagecache.drawable.apng;

import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import com.blued.android.core.imagecache.drawable.IRecyclingDrawable;

public class RecyclingApngDrawable extends ApngDrawable implements IRecyclingDrawable {
  String k;
  
  public RecyclingApngDrawable(String paramString, Bitmap paramBitmap, Uri paramUri, ImageView.ScaleType paramScaleType) {
    super(paramBitmap, paramUri, paramScaleType);
    a(paramString);
  }
  
  public void a(String paramString) {
    this.k = paramString;
  }
  
  public void a(boolean paramBoolean) {
    if (paramBoolean) {
      start();
      return;
    } 
    stop();
    a((ApngPlayListener)null);
  }
  
  public boolean a() {
    return true;
  }
  
  public String b() {
    return this.k;
  }
  
  public void b(boolean paramBoolean) {}
  
  public boolean c() {
    return true;
  }
  
  public void d() {
    stop();
    a((ApngPlayListener)null);
  }
  
  public int e() {
    return this.c * this.d * 4 * 4;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\imagecache\drawable\apng\RecyclingApngDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */