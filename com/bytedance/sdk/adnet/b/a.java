package com.bytedance.sdk.adnet.b;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.LruCache;
import android.widget.ImageView;
import com.bytedance.sdk.adnet.core.p;

public class a implements d.b {
  protected LruCache<String, Bitmap> a = new LruCache<String, Bitmap>(this, Long.valueOf(Runtime.getRuntime().maxMemory()).intValue() / 16) {
      protected int a(String param1String, Bitmap param1Bitmap) {
        return param1Bitmap.getRowBytes() * param1Bitmap.getHeight();
      }
    };
  
  public Bitmap a(String paramString) {
    try {
      return (Bitmap)this.a.get(paramString);
    } finally {
      paramString = null;
      p.a((Throwable)paramString, "DefaultImageCache get bitmap error", new Object[0]);
    } 
  }
  
  public String a(String paramString, int paramInt1, int paramInt2, ImageView.ScaleType paramScaleType) {
    return null;
  }
  
  public void a(String paramString, Bitmap paramBitmap) {
    if (!TextUtils.isEmpty(paramString) && paramBitmap != null)
      try {
        return;
      } finally {
        paramString = null;
      }  
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\adnet\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */