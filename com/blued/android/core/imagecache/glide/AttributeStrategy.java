package com.blued.android.core.imagecache.glide;

import android.graphics.Bitmap;

class AttributeStrategy implements LruPoolStrategy {
  private final KeyPool a = new KeyPool();
  
  private final GroupedLinkedMap<Key, Bitmap> b = new GroupedLinkedMap<Key, Bitmap>();
  
  static String c(int paramInt1, int paramInt2, Bitmap.Config paramConfig) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[");
    stringBuilder.append(paramInt1);
    stringBuilder.append("x");
    stringBuilder.append(paramInt2);
    stringBuilder.append("], ");
    stringBuilder.append(paramConfig);
    return stringBuilder.toString();
  }
  
  private static String d(Bitmap paramBitmap) {
    return c(paramBitmap.getWidth(), paramBitmap.getHeight(), paramBitmap.getConfig());
  }
  
  public Bitmap a() {
    return this.b.a();
  }
  
  public Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig) {
    Key key = this.a.a(paramInt1, paramInt2, paramConfig);
    return this.b.a(key);
  }
  
  public void a(Bitmap paramBitmap) {
    Key key = this.a.a(paramBitmap.getWidth(), paramBitmap.getHeight(), paramBitmap.getConfig());
    this.b.a(key, paramBitmap);
  }
  
  public String b(int paramInt1, int paramInt2, Bitmap.Config paramConfig) {
    return c(paramInt1, paramInt2, paramConfig);
  }
  
  public String b(Bitmap paramBitmap) {
    return d(paramBitmap);
  }
  
  public int c(Bitmap paramBitmap) {
    return Util.a(paramBitmap);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("AttributeStrategy:\n  ");
    stringBuilder.append(this.b);
    return stringBuilder.toString();
  }
  
  static class Key implements Poolable {
    private final AttributeStrategy.KeyPool a;
    
    private int b;
    
    private int c;
    
    private Bitmap.Config d;
    
    public Key(AttributeStrategy.KeyPool param1KeyPool) {
      this.a = param1KeyPool;
    }
    
    public void a() {
      this.a.a(this);
    }
    
    public void a(int param1Int1, int param1Int2, Bitmap.Config param1Config) {
      this.b = param1Int1;
      this.c = param1Int2;
      this.d = param1Config;
    }
    
    public boolean equals(Object param1Object) {
      boolean bool = param1Object instanceof Key;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool) {
        param1Object = param1Object;
        bool1 = bool2;
        if (this.b == ((Key)param1Object).b) {
          bool1 = bool2;
          if (this.c == ((Key)param1Object).c) {
            bool1 = bool2;
            if (this.d == ((Key)param1Object).d)
              bool1 = true; 
          } 
        } 
      } 
      return bool1;
    }
    
    public int hashCode() {
      byte b;
      int i = this.b;
      int j = this.c;
      Bitmap.Config config = this.d;
      if (config != null) {
        b = config.hashCode();
      } else {
        b = 0;
      } 
      return (i * 31 + j) * 31 + b;
    }
    
    public String toString() {
      return AttributeStrategy.c(this.b, this.c, this.d);
    }
  }
  
  static class KeyPool extends BaseKeyPool<Key> {
    protected AttributeStrategy.Key a() {
      return new AttributeStrategy.Key(this);
    }
    
    public AttributeStrategy.Key a(int param1Int1, int param1Int2, Bitmap.Config param1Config) {
      AttributeStrategy.Key key = c();
      key.a(param1Int1, param1Int2, param1Config);
      return key;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\imagecache\glide\AttributeStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */