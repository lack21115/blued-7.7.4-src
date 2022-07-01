package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;

interface DataFetcherGenerator {
  boolean a();
  
  void b();
  
  public static interface FetcherReadyCallback {
    void a(Key param1Key, Exception param1Exception, DataFetcher<?> param1DataFetcher, DataSource param1DataSource);
    
    void a(Key param1Key1, Object param1Object, DataFetcher<?> param1DataFetcher, DataSource param1DataSource, Key param1Key2);
    
    void c();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\engine\DataFetcherGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */