package com.bumptech.glide.load.data;

import java.io.IOException;

public interface DataRewinder<T> {
  T a() throws IOException;
  
  void b();
  
  public static interface Factory<T> {
    DataRewinder<T> a(T param1T);
    
    Class<T> a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\data\DataRewinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */