package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import com.bumptech.glide.util.Util;
import java.util.NavigableMap;

final class SizeStrategy implements LruPoolStrategy {
  private final KeyPool a = new KeyPool();
  
  private final GroupedLinkedMap<Key, Bitmap> b = new GroupedLinkedMap<Key, Bitmap>();
  
  private final NavigableMap<Integer, Integer> c = new PrettyPrintTreeMap<Integer, Integer>();
  
  static String a(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[");
    stringBuilder.append(paramInt);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
  
  private void a(Integer paramInteger) {
    Integer integer = this.c.get(paramInteger);
    if (integer.intValue() == 1) {
      this.c.remove(paramInteger);
      return;
    } 
    this.c.put(paramInteger, Integer.valueOf(integer.intValue() - 1));
  }
  
  private static String d(Bitmap paramBitmap) {
    return a(Util.a(paramBitmap));
  }
  
  public Bitmap a() {
    Bitmap bitmap = this.b.a();
    if (bitmap != null)
      a(Integer.valueOf(Util.a(bitmap))); 
    return bitmap;
  }
  
  public Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig) {
    int i = Util.a(paramInt1, paramInt2, paramConfig);
    Key key2 = this.a.a(i);
    Integer integer = this.c.ceilingKey(Integer.valueOf(i));
    Key key1 = key2;
    if (integer != null) {
      key1 = key2;
      if (integer.intValue() != i) {
        key1 = key2;
        if (integer.intValue() <= i * 8) {
          this.a.a(key2);
          key1 = this.a.a(integer.intValue());
        } 
      } 
    } 
    Bitmap bitmap = this.b.a(key1);
    if (bitmap != null) {
      bitmap.reconfigure(paramInt1, paramInt2, paramConfig);
      a(integer);
    } 
    return bitmap;
  }
  
  public void a(Bitmap paramBitmap) {
    int i = Util.a(paramBitmap);
    Key key = this.a.a(i);
    this.b.a(key, paramBitmap);
    Integer integer = this.c.get(Integer.valueOf(key.a));
    NavigableMap<Integer, Integer> navigableMap = this.c;
    int j = key.a;
    i = 1;
    if (integer != null)
      i = 1 + integer.intValue(); 
    navigableMap.put(Integer.valueOf(j), Integer.valueOf(i));
  }
  
  public String b(int paramInt1, int paramInt2, Bitmap.Config paramConfig) {
    return a(Util.a(paramInt1, paramInt2, paramConfig));
  }
  
  public String b(Bitmap paramBitmap) {
    return d(paramBitmap);
  }
  
  public int c(Bitmap paramBitmap) {
    return Util.a(paramBitmap);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SizeStrategy:\n  ");
    stringBuilder.append(this.b);
    stringBuilder.append("\n  SortedSizes");
    stringBuilder.append(this.c);
    return stringBuilder.toString();
  }
  
  static final class Key implements Poolable {
    int a;
    
    private final SizeStrategy.KeyPool b;
    
    Key(SizeStrategy.KeyPool param1KeyPool) {
      this.b = param1KeyPool;
    }
    
    public void a() {
      this.b.a(this);
    }
    
    public void a(int param1Int) {
      this.a = param1Int;
    }
    
    public boolean equals(Object param1Object) {
      boolean bool = param1Object instanceof Key;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool) {
        param1Object = param1Object;
        bool1 = bool2;
        if (this.a == ((Key)param1Object).a)
          bool1 = true; 
      } 
      return bool1;
    }
    
    public int hashCode() {
      return this.a;
    }
    
    public String toString() {
      return SizeStrategy.a(this.a);
    }
  }
  
  static class KeyPool extends BaseKeyPool<Key> {
    protected SizeStrategy.Key a() {
      return new SizeStrategy.Key(this);
    }
    
    public SizeStrategy.Key a(int param1Int) {
      SizeStrategy.Key key = (SizeStrategy.Key)c();
      key.a(param1Int);
      return key;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\engine\bitmap_recycle\SizeStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */