package com.blued.android.core.imagecache;

import android.text.TextUtils;
import java.io.Serializable;

public class LoadOptions implements Serializable {
  public static boolean a = false;
  
  private static boolean n = false;
  
  public int b = 0;
  
  public String c = null;
  
  public int d = 0;
  
  public boolean e = a;
  
  public String f = ImageLoaderUtils.b();
  
  public boolean g = false;
  
  public boolean h = true;
  
  public boolean i = true;
  
  public boolean j = false;
  
  public boolean k = false;
  
  public boolean l = false;
  
  public boolean m = true;
  
  private boolean o = n;
  
  public LoadOptions() {}
  
  public LoadOptions(LoadOptions paramLoadOptions) {
    this.b = paramLoadOptions.b;
    this.c = paramLoadOptions.c;
    this.d = paramLoadOptions.d;
    this.e = paramLoadOptions.e;
    this.f = paramLoadOptions.f;
    this.g = paramLoadOptions.g;
    this.h = paramLoadOptions.h;
    this.i = paramLoadOptions.i;
    this.o = paramLoadOptions.o;
    this.j = paramLoadOptions.j;
    this.k = paramLoadOptions.k;
    this.l = paramLoadOptions.l;
    this.m = paramLoadOptions.m;
  }
  
  public static LoadOptions c() {
    return new LoadOptions();
  }
  
  public LoadOptions a(int paramInt1, int paramInt2) {
    this.f = ImageLoaderUtils.a(paramInt1, paramInt2);
    return this;
  }
  
  public boolean a() {
    return this.o;
  }
  
  public boolean b() {
    return (!TextUtils.isEmpty(this.f) && this.f.equals(ImageLoaderUtils.a(0, 0)));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\imagecache\LoadOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */