package com.bumptech.glide.load;

import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class ImageHeaderParserUtils {
  private static int a(List<ImageHeaderParser> paramList, OrientationReader paramOrientationReader) throws IOException {
    int j = paramList.size();
    for (int i = 0; i < j; i++) {
      int k = paramOrientationReader.a(paramList.get(i));
      if (k != -1)
        return k; 
    } 
    return -1;
  }
  
  private static ImageHeaderParser.ImageType a(List<ImageHeaderParser> paramList, TypeReader paramTypeReader) throws IOException {
    int j = paramList.size();
    for (int i = 0; i < j; i++) {
      ImageHeaderParser.ImageType imageType = paramTypeReader.a(paramList.get(i));
      if (imageType != ImageHeaderParser.ImageType.UNKNOWN)
        return imageType; 
    } 
    return ImageHeaderParser.ImageType.UNKNOWN;
  }
  
  public static ImageHeaderParser.ImageType a(List<ImageHeaderParser> paramList, ParcelFileDescriptorRewinder paramParcelFileDescriptorRewinder, ArrayPool paramArrayPool) throws IOException {
    return a(paramList, new TypeReader(paramParcelFileDescriptorRewinder, paramArrayPool) {
          public ImageHeaderParser.ImageType a(ImageHeaderParser param1ImageHeaderParser) throws IOException {
            RecyclableBufferedInputStream recyclableBufferedInputStream = null;
            try {
              RecyclableBufferedInputStream recyclableBufferedInputStream1 = new RecyclableBufferedInputStream(new FileInputStream(this.a.d().getFileDescriptor()), this.b);
              try {
                ImageHeaderParser.ImageType imageType = param1ImageHeaderParser.a((InputStream)recyclableBufferedInputStream1);
              } finally {
                param1ImageHeaderParser = null;
              } 
            } finally {}
            if (recyclableBufferedInputStream != null)
              try {
                recyclableBufferedInputStream.close();
              } catch (IOException iOException) {} 
            this.a.d();
            throw param1ImageHeaderParser;
          }
        });
  }
  
  public static ImageHeaderParser.ImageType a(List<ImageHeaderParser> paramList, InputStream paramInputStream, ArrayPool paramArrayPool) throws IOException {
    RecyclableBufferedInputStream recyclableBufferedInputStream;
    if (paramInputStream == null)
      return ImageHeaderParser.ImageType.UNKNOWN; 
    InputStream inputStream = paramInputStream;
    if (!paramInputStream.markSupported())
      recyclableBufferedInputStream = new RecyclableBufferedInputStream(paramInputStream, paramArrayPool); 
    recyclableBufferedInputStream.mark(5242880);
    return a(paramList, new TypeReader((InputStream)recyclableBufferedInputStream) {
          public ImageHeaderParser.ImageType a(ImageHeaderParser param1ImageHeaderParser) throws IOException {
            try {
              return param1ImageHeaderParser.a(this.a);
            } finally {
              this.a.reset();
            } 
          }
        });
  }
  
  public static ImageHeaderParser.ImageType a(List<ImageHeaderParser> paramList, ByteBuffer paramByteBuffer) throws IOException {
    return (paramByteBuffer == null) ? ImageHeaderParser.ImageType.UNKNOWN : a(paramList, new TypeReader(paramByteBuffer) {
          public ImageHeaderParser.ImageType a(ImageHeaderParser param1ImageHeaderParser) throws IOException {
            return param1ImageHeaderParser.a(this.a);
          }
        });
  }
  
  public static int b(List<ImageHeaderParser> paramList, ParcelFileDescriptorRewinder paramParcelFileDescriptorRewinder, ArrayPool paramArrayPool) throws IOException {
    return a(paramList, new OrientationReader(paramParcelFileDescriptorRewinder, paramArrayPool) {
          public int a(ImageHeaderParser param1ImageHeaderParser) throws IOException {
            RecyclableBufferedInputStream recyclableBufferedInputStream = null;
            try {
              RecyclableBufferedInputStream recyclableBufferedInputStream1 = new RecyclableBufferedInputStream(new FileInputStream(this.a.d().getFileDescriptor()), this.b);
              try {
                int i = param1ImageHeaderParser.a((InputStream)recyclableBufferedInputStream1, this.b);
              } finally {
                param1ImageHeaderParser = null;
              } 
            } finally {}
            if (recyclableBufferedInputStream != null)
              try {
                recyclableBufferedInputStream.close();
              } catch (IOException iOException) {} 
            this.a.d();
            throw param1ImageHeaderParser;
          }
        });
  }
  
  public static int b(List<ImageHeaderParser> paramList, InputStream paramInputStream, ArrayPool paramArrayPool) throws IOException {
    RecyclableBufferedInputStream recyclableBufferedInputStream;
    if (paramInputStream == null)
      return -1; 
    InputStream inputStream = paramInputStream;
    if (!paramInputStream.markSupported())
      recyclableBufferedInputStream = new RecyclableBufferedInputStream(paramInputStream, paramArrayPool); 
    recyclableBufferedInputStream.mark(5242880);
    return a(paramList, new OrientationReader((InputStream)recyclableBufferedInputStream, paramArrayPool) {
          public int a(ImageHeaderParser param1ImageHeaderParser) throws IOException {
            try {
              return param1ImageHeaderParser.a(this.a, this.b);
            } finally {
              this.a.reset();
            } 
          }
        });
  }
  
  static interface OrientationReader {
    int a(ImageHeaderParser param1ImageHeaderParser) throws IOException;
  }
  
  static interface TypeReader {
    ImageHeaderParser.ImageType a(ImageHeaderParser param1ImageHeaderParser) throws IOException;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\ImageHeaderParserUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */