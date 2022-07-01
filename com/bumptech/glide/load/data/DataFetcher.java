package com.bumptech.glide.load.data;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;

public interface DataFetcher<T> {
  void a();
  
  void a(Priority paramPriority, DataCallback<? super T> paramDataCallback);
  
  void b();
  
  Class<T> c();
  
  DataSource d();
  
  public static interface DataCallback<T> {
    void a(Exception param1Exception);
    
    void a(T param1T);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\data\DataFetcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */