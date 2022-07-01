package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class LocalUriFetcher<T> implements DataFetcher<T> {
  private final Uri a;
  
  private final ContentResolver b;
  
  private T c;
  
  public LocalUriFetcher(ContentResolver paramContentResolver, Uri paramUri) {
    this.b = paramContentResolver;
    this.a = paramUri;
  }
  
  public void a() {
    T t = this.c;
    if (t != null)
      try {
        a(t);
        return;
      } catch (IOException iOException) {
        return;
      }  
  }
  
  public final void a(Priority paramPriority, DataFetcher.DataCallback<? super T> paramDataCallback) {
    try {
      this.c = b(this.a, this.b);
      paramDataCallback.a(this.c);
      return;
    } catch (FileNotFoundException fileNotFoundException) {
      if (Log.isLoggable("LocalUriFetcher", 3))
        Log.d("LocalUriFetcher", "Failed to open Uri", fileNotFoundException); 
      paramDataCallback.a(fileNotFoundException);
      return;
    } 
  }
  
  protected abstract void a(T paramT) throws IOException;
  
  protected abstract T b(Uri paramUri, ContentResolver paramContentResolver) throws FileNotFoundException;
  
  public void b() {}
  
  public DataSource d() {
    return DataSource.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\data\LocalUriFetcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */