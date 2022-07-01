package com.ss.android.socialbase.downloader.m;

import java.util.LinkedHashMap;
import java.util.Map;

public class h<K, T> extends LinkedHashMap<K, T> {
  private int a;
  
  public h() {
    this(4, 4);
  }
  
  public h(int paramInt1, int paramInt2) {
    super(paramInt1, 0.75F, true);
    a(paramInt2);
  }
  
  public void a(int paramInt) {
    this.a = paramInt;
  }
  
  protected boolean removeEldestEntry(Map.Entry<K, T> paramEntry) {
    return (size() > this.a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\m\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */