package com.bumptech.glide.load.model;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;
import java.io.FileNotFoundException;

public final class MediaStoreFileLoader implements ModelLoader<Uri, File> {
  private final Context a;
  
  public MediaStoreFileLoader(Context paramContext) {
    this.a = paramContext;
  }
  
  public ModelLoader.LoadData<File> a(Uri paramUri, int paramInt1, int paramInt2, Options paramOptions) {
    return new ModelLoader.LoadData<File>((Key)new ObjectKey(paramUri), new FilePathFetcher(this.a, paramUri));
  }
  
  public boolean a(Uri paramUri) {
    return MediaStoreUtil.a(paramUri);
  }
  
  public static final class Factory implements ModelLoaderFactory<Uri, File> {
    private final Context a;
    
    public Factory(Context param1Context) {
      this.a = param1Context;
    }
    
    public ModelLoader<Uri, File> a(MultiModelLoaderFactory param1MultiModelLoaderFactory) {
      return new MediaStoreFileLoader(this.a);
    }
    
    public void a() {}
  }
  
  static class FilePathFetcher implements DataFetcher<File> {
    private static final String[] a = new String[] { "_data" };
    
    private final Context b;
    
    private final Uri c;
    
    FilePathFetcher(Context param1Context, Uri param1Uri) {
      this.b = param1Context;
      this.c = param1Uri;
    }
    
    public void a() {}
    
    public void a(Priority param1Priority, DataFetcher.DataCallback<? super File> param1DataCallback) {
      StringBuilder stringBuilder;
      Cursor cursor = this.b.getContentResolver().query(this.c, a, null, null, null);
      param1Priority = null;
      Priority priority = null;
      if (cursor != null) {
        param1Priority = priority;
        try {
          if (cursor.moveToFirst())
            String str = cursor.getString(cursor.getColumnIndexOrThrow("_data")); 
        } finally {
          cursor.close();
        } 
      } 
      if (TextUtils.isEmpty((CharSequence)param1Priority)) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to find file path for: ");
        stringBuilder.append(this.c);
        param1DataCallback.a(new FileNotFoundException(stringBuilder.toString()));
        return;
      } 
      param1DataCallback.a(new File((String)stringBuilder));
    }
    
    public void b() {}
    
    public Class<File> c() {
      return File.class;
    }
    
    public DataSource d() {
      return DataSource.a;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\model\MediaStoreFileLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */