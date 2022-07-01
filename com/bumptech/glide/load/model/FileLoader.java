package com.bumptech.glide.load.model;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileLoader<Data> implements ModelLoader<File, Data> {
  private final FileOpener<Data> a;
  
  public FileLoader(FileOpener<Data> paramFileOpener) {
    this.a = paramFileOpener;
  }
  
  public ModelLoader.LoadData<Data> a(File paramFile, int paramInt1, int paramInt2, Options paramOptions) {
    return new ModelLoader.LoadData<Data>((Key)new ObjectKey(paramFile), new FileFetcher<Data>(paramFile, this.a));
  }
  
  public boolean a(File paramFile) {
    return true;
  }
  
  public static class Factory<Data> implements ModelLoaderFactory<File, Data> {
    private final FileLoader.FileOpener<Data> a;
    
    public Factory(FileLoader.FileOpener<Data> param1FileOpener) {
      this.a = param1FileOpener;
    }
    
    public final ModelLoader<File, Data> a(MultiModelLoaderFactory param1MultiModelLoaderFactory) {
      return new FileLoader<Data>(this.a);
    }
    
    public final void a() {}
  }
  
  public static class FileDescriptorFactory extends Factory<ParcelFileDescriptor> {
    public FileDescriptorFactory() {
      super(new FileLoader.FileOpener<ParcelFileDescriptor>() {
            public ParcelFileDescriptor a(File param2File) throws FileNotFoundException {
              return ParcelFileDescriptor.open(param2File, 268435456);
            }
            
            public Class<ParcelFileDescriptor> a() {
              return ParcelFileDescriptor.class;
            }
            
            public void a(ParcelFileDescriptor param2ParcelFileDescriptor) throws IOException {
              param2ParcelFileDescriptor.close();
            }
          });
    }
  }
  
  class null implements FileOpener<ParcelFileDescriptor> {
    public ParcelFileDescriptor a(File param1File) throws FileNotFoundException {
      return ParcelFileDescriptor.open(param1File, 268435456);
    }
    
    public Class<ParcelFileDescriptor> a() {
      return ParcelFileDescriptor.class;
    }
    
    public void a(ParcelFileDescriptor param1ParcelFileDescriptor) throws IOException {
      param1ParcelFileDescriptor.close();
    }
  }
  
  static final class FileFetcher<Data> implements DataFetcher<Data> {
    private final File a;
    
    private final FileLoader.FileOpener<Data> b;
    
    private Data c;
    
    FileFetcher(File param1File, FileLoader.FileOpener<Data> param1FileOpener) {
      this.a = param1File;
      this.b = param1FileOpener;
    }
    
    public void a() {
      Data data = this.c;
      if (data != null)
        try {
          this.b.a(data);
          return;
        } catch (IOException iOException) {
          return;
        }  
    }
    
    public void a(Priority param1Priority, DataFetcher.DataCallback<? super Data> param1DataCallback) {
      try {
        this.c = this.b.b(this.a);
        param1DataCallback.a(this.c);
        return;
      } catch (FileNotFoundException fileNotFoundException) {
        if (Log.isLoggable("FileLoader", 3))
          Log.d("FileLoader", "Failed to open file", fileNotFoundException); 
        param1DataCallback.a(fileNotFoundException);
        return;
      } 
    }
    
    public void b() {}
    
    public Class<Data> c() {
      return this.b.a();
    }
    
    public DataSource d() {
      return DataSource.a;
    }
  }
  
  public static interface FileOpener<Data> {
    Class<Data> a();
    
    void a(Data param1Data) throws IOException;
    
    Data b(File param1File) throws FileNotFoundException;
  }
  
  public static class StreamFactory extends Factory<InputStream> {
    public StreamFactory() {
      super(new FileLoader.FileOpener<InputStream>() {
            public InputStream a(File param2File) throws FileNotFoundException {
              return new FileInputStream(param2File);
            }
            
            public Class<InputStream> a() {
              return InputStream.class;
            }
            
            public void a(InputStream param2InputStream) throws IOException {
              param2InputStream.close();
            }
          });
    }
  }
  
  class null implements FileOpener<InputStream> {
    public InputStream a(File param1File) throws FileNotFoundException {
      return new FileInputStream(param1File);
    }
    
    public Class<InputStream> a() {
      return InputStream.class;
    }
    
    public void a(InputStream param1InputStream) throws IOException {
      param1InputStream.close();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\model\FileLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */