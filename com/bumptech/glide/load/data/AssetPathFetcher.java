package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.IOException;

public abstract class AssetPathFetcher<T> implements DataFetcher<T> {
  private final String a;
  
  private final AssetManager b;
  
  private T c;
  
  public AssetPathFetcher(AssetManager paramAssetManager, String paramString) {
    this.b = paramAssetManager;
    this.a = paramString;
  }
  
  protected abstract T a(AssetManager paramAssetManager, String paramString) throws IOException;
  
  public void a() {
    T t = this.c;
    if (t == null)
      return; 
    try {
      a(t);
      return;
    } catch (IOException iOException) {
      return;
    } 
  }
  
  public void a(Priority paramPriority, DataFetcher.DataCallback<? super T> paramDataCallback) {
    try {
      this.c = a(this.b, this.a);
      paramDataCallback.a(this.c);
      return;
    } catch (IOException iOException) {
      if (Log.isLoggable("AssetPathFetcher", 3))
        Log.d("AssetPathFetcher", "Failed to load data from asset manager", iOException); 
      paramDataCallback.a(iOException);
      return;
    } 
  }
  
  protected abstract void a(T paramT) throws IOException;
  
  public void b() {}
  
  public DataSource d() {
    return DataSource.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\data\AssetPathFetcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */