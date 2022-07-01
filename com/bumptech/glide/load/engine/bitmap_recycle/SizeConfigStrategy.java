package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.os.Build;
import com.bumptech.glide.util.Util;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class SizeConfigStrategy implements LruPoolStrategy {
  private static final Bitmap.Config[] a;
  
  private static final Bitmap.Config[] b = a;
  
  private static final Bitmap.Config[] c = new Bitmap.Config[] { Bitmap.Config.RGB_565 };
  
  private static final Bitmap.Config[] d = new Bitmap.Config[] { Bitmap.Config.ARGB_4444 };
  
  private static final Bitmap.Config[] e = new Bitmap.Config[] { Bitmap.Config.ALPHA_8 };
  
  private final KeyPool f = new KeyPool();
  
  private final GroupedLinkedMap<Key, Bitmap> g = new GroupedLinkedMap<Key, Bitmap>();
  
  private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> h = new HashMap<Bitmap.Config, NavigableMap<Integer, Integer>>();
  
  static String a(int paramInt, Bitmap.Config paramConfig) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[");
    stringBuilder.append(paramInt);
    stringBuilder.append("](");
    stringBuilder.append(paramConfig);
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
  
  private NavigableMap<Integer, Integer> a(Bitmap.Config paramConfig) {
    NavigableMap<Object, Object> navigableMap2 = (NavigableMap)this.h.get(paramConfig);
    NavigableMap<Object, Object> navigableMap1 = navigableMap2;
    if (navigableMap2 == null) {
      navigableMap1 = new TreeMap<Object, Object>();
      this.h.put(paramConfig, navigableMap1);
    } 
    return (NavigableMap)navigableMap1;
  }
  
  private void a(Integer paramInteger, Bitmap paramBitmap) {
    NavigableMap<Integer, Integer> navigableMap = a(paramBitmap.getConfig());
    Integer integer = navigableMap.get(paramInteger);
    if (integer != null) {
      if (integer.intValue() == 1) {
        navigableMap.remove(paramInteger);
        return;
      } 
      navigableMap.put(paramInteger, Integer.valueOf(integer.intValue() - 1));
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Tried to decrement empty size, size: ");
    stringBuilder.append(paramInteger);
    stringBuilder.append(", removed: ");
    stringBuilder.append(b(paramBitmap));
    stringBuilder.append(", this: ");
    stringBuilder.append(this);
    throw new NullPointerException(stringBuilder.toString());
  }
  
  private Key b(int paramInt, Bitmap.Config paramConfig) {
    Key key = this.f.a(paramInt, paramConfig);
    for (Bitmap.Config config : b(paramConfig)) {
      Integer integer = a(config).ceilingKey(Integer.valueOf(paramInt));
      if (integer != null && integer.intValue() <= paramInt * 8) {
        if (integer.intValue() != paramInt || ((config == null) ? (paramConfig != null) : !config.equals(paramConfig))) {
          this.f.a(key);
          return this.f.a(integer.intValue(), config);
        } 
        break;
      } 
    } 
    return key;
  }
  
  private static Bitmap.Config[] b(Bitmap.Config paramConfig) {
    if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(paramConfig))
      return b; 
    int i = null.a[paramConfig.ordinal()];
    return (i != 1) ? ((i != 2) ? ((i != 3) ? ((i != 4) ? new Bitmap.Config[] { paramConfig } : e) : d) : c) : a;
  }
  
  public Bitmap a() {
    Bitmap bitmap = this.g.a();
    if (bitmap != null)
      a(Integer.valueOf(Util.a(bitmap)), bitmap); 
    return bitmap;
  }
  
  public Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig) {
    Key key = b(Util.a(paramInt1, paramInt2, paramConfig), paramConfig);
    Bitmap bitmap = this.g.a(key);
    if (bitmap != null) {
      a(Integer.valueOf(key.a), bitmap);
      bitmap.reconfigure(paramInt1, paramInt2, paramConfig);
    } 
    return bitmap;
  }
  
  public void a(Bitmap paramBitmap) {
    int i = Util.a(paramBitmap);
    Key key = this.f.a(i, paramBitmap.getConfig());
    this.g.a(key, paramBitmap);
    NavigableMap<Integer, Integer> navigableMap = a(paramBitmap.getConfig());
    Integer integer = navigableMap.get(Integer.valueOf(key.a));
    int j = key.a;
    i = 1;
    if (integer != null)
      i = 1 + integer.intValue(); 
    navigableMap.put(Integer.valueOf(j), Integer.valueOf(i));
  }
  
  public String b(int paramInt1, int paramInt2, Bitmap.Config paramConfig) {
    return a(Util.a(paramInt1, paramInt2, paramConfig), paramConfig);
  }
  
  public String b(Bitmap paramBitmap) {
    return a(Util.a(paramBitmap), paramBitmap.getConfig());
  }
  
  public int c(Bitmap paramBitmap) {
    return Util.a(paramBitmap);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SizeConfigStrategy{groupedMap=");
    stringBuilder.append(this.g);
    stringBuilder.append(", sortedSizes=(");
    for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.h.entrySet()) {
      stringBuilder.append(entry.getKey());
      stringBuilder.append('[');
      stringBuilder.append(entry.getValue());
      stringBuilder.append("], ");
    } 
    if (!this.h.isEmpty())
      stringBuilder.replace(stringBuilder.length() - 2, stringBuilder.length(), ""); 
    stringBuilder.append(")}");
    return stringBuilder.toString();
  }
  
  static {
    Bitmap.Config[] arrayOfConfig2 = new Bitmap.Config[2];
    arrayOfConfig2[0] = Bitmap.Config.ARGB_8888;
    arrayOfConfig2[1] = null;
    Bitmap.Config[] arrayOfConfig1 = arrayOfConfig2;
    if (Build.VERSION.SDK_INT >= 26) {
      arrayOfConfig1 = Arrays.<Bitmap.Config>copyOf(arrayOfConfig2, arrayOfConfig2.length + 1);
      arrayOfConfig1[arrayOfConfig1.length - 1] = Bitmap.Config.RGBA_F16;
    } 
    a = arrayOfConfig1;
  }
  
  static final class Key implements Poolable {
    int a;
    
    private final SizeConfigStrategy.KeyPool b;
    
    private Bitmap.Config c;
    
    public Key(SizeConfigStrategy.KeyPool param1KeyPool) {
      this.b = param1KeyPool;
    }
    
    public void a() {
      this.b.a(this);
    }
    
    public void a(int param1Int, Bitmap.Config param1Config) {
      this.a = param1Int;
      this.c = param1Config;
    }
    
    public boolean equals(Object param1Object) {
      boolean bool = param1Object instanceof Key;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool) {
        param1Object = param1Object;
        bool1 = bool2;
        if (this.a == ((Key)param1Object).a) {
          bool1 = bool2;
          if (Util.a(this.c, ((Key)param1Object).c))
            bool1 = true; 
        } 
      } 
      return bool1;
    }
    
    public int hashCode() {
      byte b;
      int i = this.a;
      Bitmap.Config config = this.c;
      if (config != null) {
        b = config.hashCode();
      } else {
        b = 0;
      } 
      return i * 31 + b;
    }
    
    public String toString() {
      return SizeConfigStrategy.a(this.a, this.c);
    }
  }
  
  static class KeyPool extends BaseKeyPool<Key> {
    protected SizeConfigStrategy.Key a() {
      return new SizeConfigStrategy.Key(this);
    }
    
    public SizeConfigStrategy.Key a(int param1Int, Bitmap.Config param1Config) {
      SizeConfigStrategy.Key key = c();
      key.a(param1Int, param1Config);
      return key;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\engine\bitmap_recycle\SizeConfigStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */