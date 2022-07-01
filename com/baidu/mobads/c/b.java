package com.baidu.mobads.c;

import android.graphics.Bitmap;
import android.util.LruCache;

class b extends LruCache<String, Bitmap> {
  b(a parama, int paramInt) {
    super(paramInt);
  }
  
  protected int a(String paramString, Bitmap paramBitmap) {
    return (paramBitmap == null) ? 0 : paramBitmap.getByteCount();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */