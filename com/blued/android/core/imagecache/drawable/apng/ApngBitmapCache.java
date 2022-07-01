package com.blued.android.core.imagecache.drawable.apng;

import android.graphics.Bitmap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ApngBitmapCache {
  private int a = 2;
  
  private Map<Integer, Bitmap> b = new HashMap<Integer, Bitmap>();
  
  private Set<Bitmap> c = new HashSet<Bitmap>();
  
  Bitmap a(int paramInt1, int paramInt2) {
    Iterator<Bitmap> iterator = this.c.iterator();
    Bitmap bitmap = null;
    while (iterator.hasNext()) {
      bitmap = iterator.next();
      if (bitmap != null && bitmap.getAllocationByteCount() >= paramInt1 * paramInt2 * 4) {
        iterator.remove();
        if (bitmap.getWidth() != paramInt1 || bitmap.getHeight() != paramInt2)
          bitmap.reconfigure(paramInt1, paramInt2, Bitmap.Config.ARGB_8888); 
        bitmap.eraseColor(0);
        return bitmap;
      } 
    } 
    try {
      return Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    } catch (OutOfMemoryError outOfMemoryError) {
      outOfMemoryError.printStackTrace();
      return bitmap;
    } 
  }
  
  public void a() {
    this.b.clear();
    this.c.clear();
  }
  
  public void a(int paramInt) {
    this.a = paramInt;
  }
  
  void a(int paramInt, Bitmap paramBitmap) {
    if (paramBitmap == null)
      return; 
    if (paramInt == 0) {
      this.b.clear();
    } else if (this.b.size() >= this.a) {
      Iterator<Map.Entry> iterator = this.b.entrySet().iterator();
      while (iterator.hasNext()) {
        Map.Entry entry = iterator.next();
        int i = ((Integer)entry.getKey()).intValue();
        if (i > paramInt || paramInt >= i + this.a) {
          Bitmap bitmap = (Bitmap)entry.getValue();
          iterator.remove();
          b(bitmap);
        } 
      } 
    } 
    this.b.put(Integer.valueOf(paramInt), paramBitmap);
  }
  
  boolean a(Bitmap paramBitmap) {
    return this.b.containsValue(paramBitmap);
  }
  
  Bitmap b(int paramInt) {
    return this.b.get(Integer.valueOf(paramInt));
  }
  
  void b(Bitmap paramBitmap) {
    if (paramBitmap != null && !a(paramBitmap))
      this.c.add(paramBitmap); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\imagecache\drawable\apng\ApngBitmapCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */