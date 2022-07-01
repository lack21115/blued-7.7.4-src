package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.data.InputStreamRewinder;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

interface ImageReader {
  Bitmap a(BitmapFactory.Options paramOptions) throws IOException;
  
  ImageHeaderParser.ImageType a() throws IOException;
  
  int b() throws IOException;
  
  void c();
  
  public static final class InputStreamImageReader implements ImageReader {
    private final InputStreamRewinder a;
    
    private final ArrayPool b;
    
    private final List<ImageHeaderParser> c;
    
    InputStreamImageReader(InputStream param1InputStream, List<ImageHeaderParser> param1List, ArrayPool param1ArrayPool) {
      this.b = (ArrayPool)Preconditions.a(param1ArrayPool);
      this.c = (List<ImageHeaderParser>)Preconditions.a(param1List);
      this.a = new InputStreamRewinder(param1InputStream, param1ArrayPool);
    }
    
    public Bitmap a(BitmapFactory.Options param1Options) throws IOException {
      return BitmapFactory.decodeStream(this.a.c(), null, param1Options);
    }
    
    public ImageHeaderParser.ImageType a() throws IOException {
      return ImageHeaderParserUtils.a(this.c, this.a.c(), this.b);
    }
    
    public int b() throws IOException {
      return ImageHeaderParserUtils.b(this.c, this.a.c(), this.b);
    }
    
    public void c() {
      this.a.d();
    }
  }
  
  public static final class ParcelFileDescriptorImageReader implements ImageReader {
    private final ArrayPool a;
    
    private final List<ImageHeaderParser> b;
    
    private final ParcelFileDescriptorRewinder c;
    
    ParcelFileDescriptorImageReader(ParcelFileDescriptor param1ParcelFileDescriptor, List<ImageHeaderParser> param1List, ArrayPool param1ArrayPool) {
      this.a = (ArrayPool)Preconditions.a(param1ArrayPool);
      this.b = (List<ImageHeaderParser>)Preconditions.a(param1List);
      this.c = new ParcelFileDescriptorRewinder(param1ParcelFileDescriptor);
    }
    
    public Bitmap a(BitmapFactory.Options param1Options) throws IOException {
      return BitmapFactory.decodeFileDescriptor(this.c.d().getFileDescriptor(), null, param1Options);
    }
    
    public ImageHeaderParser.ImageType a() throws IOException {
      return ImageHeaderParserUtils.a(this.b, this.c, this.a);
    }
    
    public int b() throws IOException {
      return ImageHeaderParserUtils.b(this.b, this.c, this.a);
    }
    
    public void c() {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\bitmap\ImageReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */