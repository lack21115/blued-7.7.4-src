package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.ExifOrientationStream;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ThumbFetcher implements DataFetcher<InputStream> {
  private final Uri a;
  
  private final ThumbnailStreamOpener b;
  
  private InputStream c;
  
  ThumbFetcher(Uri paramUri, ThumbnailStreamOpener paramThumbnailStreamOpener) {
    this.a = paramUri;
    this.b = paramThumbnailStreamOpener;
  }
  
  public static ThumbFetcher a(Context paramContext, Uri paramUri) {
    return a(paramContext, paramUri, new ImageThumbnailQuery(paramContext.getContentResolver()));
  }
  
  private static ThumbFetcher a(Context paramContext, Uri paramUri, ThumbnailQuery paramThumbnailQuery) {
    ArrayPool arrayPool = Glide.a(paramContext).b();
    return new ThumbFetcher(paramUri, new ThumbnailStreamOpener(Glide.a(paramContext).i().a(), paramThumbnailQuery, arrayPool, paramContext.getContentResolver()));
  }
  
  public static ThumbFetcher b(Context paramContext, Uri paramUri) {
    return a(paramContext, paramUri, new VideoThumbnailQuery(paramContext.getContentResolver()));
  }
  
  private InputStream e() throws FileNotFoundException {
    byte b;
    ExifOrientationStream exifOrientationStream;
    InputStream inputStream2 = this.b.b(this.a);
    if (inputStream2 != null) {
      b = this.b.a(this.a);
    } else {
      b = -1;
    } 
    InputStream inputStream1 = inputStream2;
    if (b != -1)
      exifOrientationStream = new ExifOrientationStream(inputStream2, b); 
    return (InputStream)exifOrientationStream;
  }
  
  public void a() {
    InputStream inputStream = this.c;
    if (inputStream != null)
      try {
        inputStream.close();
        return;
      } catch (IOException iOException) {
        return;
      }  
  }
  
  public void a(Priority paramPriority, DataFetcher.DataCallback<? super InputStream> paramDataCallback) {
    try {
      this.c = e();
      paramDataCallback.a(this.c);
      return;
    } catch (FileNotFoundException fileNotFoundException) {
      if (Log.isLoggable("MediaStoreThumbFetcher", 3))
        Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", fileNotFoundException); 
      paramDataCallback.a(fileNotFoundException);
      return;
    } 
  }
  
  public void b() {}
  
  public Class<InputStream> c() {
    return InputStream.class;
  }
  
  public DataSource d() {
    return DataSource.a;
  }
  
  static class ImageThumbnailQuery implements ThumbnailQuery {
    private static final String[] b = new String[] { "_data" };
    
    private final ContentResolver a;
    
    ImageThumbnailQuery(ContentResolver param1ContentResolver) {
      this.a = param1ContentResolver;
    }
    
    public Cursor a(Uri param1Uri) {
      String str = param1Uri.getLastPathSegment();
      return this.a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, b, "kind = 1 AND image_id = ?", new String[] { str }, null);
    }
  }
  
  static class VideoThumbnailQuery implements ThumbnailQuery {
    private static final String[] b = new String[] { "_data" };
    
    private final ContentResolver a;
    
    VideoThumbnailQuery(ContentResolver param1ContentResolver) {
      this.a = param1ContentResolver;
    }
    
    public Cursor a(Uri param1Uri) {
      String str = param1Uri.getLastPathSegment();
      return this.a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, b, "kind = 1 AND video_id = ?", new String[] { str }, null);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\data\mediastore\ThumbFetcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */