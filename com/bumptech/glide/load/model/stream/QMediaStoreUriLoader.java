package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

public final class QMediaStoreUriLoader<DataT> implements ModelLoader<Uri, DataT> {
  private final Context a;
  
  private final ModelLoader<File, DataT> b;
  
  private final ModelLoader<Uri, DataT> c;
  
  private final Class<DataT> d;
  
  QMediaStoreUriLoader(Context paramContext, ModelLoader<File, DataT> paramModelLoader, ModelLoader<Uri, DataT> paramModelLoader1, Class<DataT> paramClass) {
    this.a = paramContext.getApplicationContext();
    this.b = paramModelLoader;
    this.c = paramModelLoader1;
    this.d = paramClass;
  }
  
  public ModelLoader.LoadData<DataT> a(Uri paramUri, int paramInt1, int paramInt2, Options paramOptions) {
    return new ModelLoader.LoadData((Key)new ObjectKey(paramUri), new QMediaStoreUriFetcher<DataT>(this.a, this.b, this.c, paramUri, paramInt1, paramInt2, paramOptions, this.d));
  }
  
  public boolean a(Uri paramUri) {
    return (Build.VERSION.SDK_INT >= 29 && MediaStoreUtil.a(paramUri));
  }
  
  static abstract class Factory<DataT> implements ModelLoaderFactory<Uri, DataT> {
    private final Context a;
    
    private final Class<DataT> b;
    
    Factory(Context param1Context, Class<DataT> param1Class) {
      this.a = param1Context;
      this.b = param1Class;
    }
    
    public final ModelLoader<Uri, DataT> a(MultiModelLoaderFactory param1MultiModelLoaderFactory) {
      return new QMediaStoreUriLoader<DataT>(this.a, param1MultiModelLoaderFactory.b(File.class, this.b), param1MultiModelLoaderFactory.b(Uri.class, this.b), this.b);
    }
    
    public final void a() {}
  }
  
  public static final class FileDescriptorFactory extends Factory<ParcelFileDescriptor> {
    public FileDescriptorFactory(Context param1Context) {
      super(param1Context, ParcelFileDescriptor.class);
    }
  }
  
  public static final class InputStreamFactory extends Factory<InputStream> {
    public InputStreamFactory(Context param1Context) {
      super(param1Context, InputStream.class);
    }
  }
  
  static final class QMediaStoreUriFetcher<DataT> implements DataFetcher<DataT> {
    private static final String[] a = new String[] { "_data" };
    
    private final Context b;
    
    private final ModelLoader<File, DataT> c;
    
    private final ModelLoader<Uri, DataT> d;
    
    private final Uri e;
    
    private final int f;
    
    private final int g;
    
    private final Options h;
    
    private final Class<DataT> i;
    
    private volatile boolean j;
    
    private volatile DataFetcher<DataT> k;
    
    QMediaStoreUriFetcher(Context param1Context, ModelLoader<File, DataT> param1ModelLoader, ModelLoader<Uri, DataT> param1ModelLoader1, Uri param1Uri, int param1Int1, int param1Int2, Options param1Options, Class<DataT> param1Class) {
      this.b = param1Context.getApplicationContext();
      this.c = param1ModelLoader;
      this.d = param1ModelLoader1;
      this.e = param1Uri;
      this.f = param1Int1;
      this.g = param1Int2;
      this.h = param1Options;
      this.i = param1Class;
    }
    
    private File a(Uri param1Uri) throws FileNotFoundException {
      Cursor cursor = null;
      try {
        File file;
        Cursor cursor1 = this.b.getContentResolver().query(param1Uri, a, null, null, null);
        if (cursor1 != null) {
          cursor = cursor1;
          if (cursor1.moveToFirst()) {
            cursor = cursor1;
            String str = cursor1.getString(cursor1.getColumnIndexOrThrow("_data"));
            cursor = cursor1;
            if (!TextUtils.isEmpty(str)) {
              cursor = cursor1;
              file = new File(str);
              return file;
            } 
            cursor = cursor1;
            StringBuilder stringBuilder1 = new StringBuilder();
            cursor = cursor1;
            stringBuilder1.append("File path was empty in media store for: ");
            cursor = cursor1;
            stringBuilder1.append(file);
            cursor = cursor1;
            throw new FileNotFoundException(stringBuilder1.toString());
          } 
        } 
        cursor = cursor1;
        StringBuilder stringBuilder = new StringBuilder();
        cursor = cursor1;
        stringBuilder.append("Failed to media store entry for: ");
        cursor = cursor1;
        stringBuilder.append(file);
        cursor = cursor1;
        throw new FileNotFoundException(stringBuilder.toString());
      } finally {
        if (cursor != null)
          cursor.close(); 
      } 
    }
    
    private DataFetcher<DataT> e() throws FileNotFoundException {
      ModelLoader.LoadData<DataT> loadData = f();
      return (loadData != null) ? loadData.c : null;
    }
    
    private ModelLoader.LoadData<DataT> f() throws FileNotFoundException {
      Uri uri;
      if (Environment.isExternalStorageLegacy())
        return this.c.a(a(this.e), this.f, this.g, this.h); 
      if (g()) {
        uri = MediaStore.setRequireOriginal(this.e);
      } else {
        uri = this.e;
      } 
      return this.d.a(uri, this.f, this.g, this.h);
    }
    
    private boolean g() {
      return (this.b.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0);
    }
    
    public void a() {
      DataFetcher<DataT> dataFetcher = this.k;
      if (dataFetcher != null)
        dataFetcher.a(); 
    }
    
    public void a(Priority param1Priority, DataFetcher.DataCallback<? super DataT> param1DataCallback) {
      try {
        StringBuilder stringBuilder;
        DataFetcher<DataT> dataFetcher = e();
        if (dataFetcher == null) {
          stringBuilder = new StringBuilder();
          stringBuilder.append("Failed to build fetcher for: ");
          stringBuilder.append(this.e);
          param1DataCallback.a(new IllegalArgumentException(stringBuilder.toString()));
          return;
        } 
        this.k = dataFetcher;
        if (this.j) {
          b();
          return;
        } 
        dataFetcher.a((Priority)stringBuilder, param1DataCallback);
        return;
      } catch (FileNotFoundException fileNotFoundException) {
        param1DataCallback.a(fileNotFoundException);
        return;
      } 
    }
    
    public void b() {
      this.j = true;
      DataFetcher<DataT> dataFetcher = this.k;
      if (dataFetcher != null)
        dataFetcher.b(); 
    }
    
    public Class<DataT> c() {
      return this.i;
    }
    
    public DataSource d() {
      return DataSource.a;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\model\stream\QMediaStoreUriLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */