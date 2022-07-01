package com.blued.android.core.image.http;

import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.utils.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.util.ContentLengthInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileDataFetcher implements DataFetcher<InputStream> {
  private String a;
  
  private InputStream b;
  
  public FileDataFetcher(String paramString) {
    if (ImageLoader.a()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("-- FileDataFetcher :");
      stringBuilder.append(paramString);
      Log.e("IMAGE", stringBuilder.toString());
    } 
    this.a = paramString;
  }
  
  public void a() {
    if (ImageLoader.a())
      Log.e("IMAGE", "-- FileDataFetcher cleanup"); 
    try {
      if (this.b != null) {
        this.b.close();
        this.b = null;
        return;
      } 
    } catch (IOException iOException) {
      iOException.printStackTrace();
    } 
  }
  
  public void a(Priority paramPriority, DataFetcher.DataCallback<? super InputStream> paramDataCallback) {
    if (ImageLoader.a())
      Log.e("IMAGE", "-- FileDataFetcher loadData"); 
    try {
      DataInputStream dataInputStream = new DataInputStream(new FileInputStream(this.a));
      this.b = ContentLengthInputStream.a(dataInputStream, dataInputStream.available());
      if (ImageLoader.a())
        Log.e("IMAGE", "-- FileDataFetcher loadData ++ onSuccess"); 
      paramDataCallback.a(this.b);
      return;
    } catch (Exception exception) {
      if (ImageLoader.a())
        Log.e("IMAGE", "-- FileDataFetcher loadData ++ onFailure"); 
      paramDataCallback.a(exception);
      return;
    } 
  }
  
  public void b() {
    if (ImageLoader.a())
      Log.e("IMAGE", "-- FileDataFetcher cancel"); 
  }
  
  public Class<InputStream> c() {
    return InputStream.class;
  }
  
  public DataSource d() {
    return DataSource.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\image\http\FileDataFetcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */