package com.bumptech.glide.load.resource.bitmap;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public class VideoDecoder<T> implements ResourceDecoder<T, Bitmap> {
  public static final Option<Long> a = Option.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", Long.valueOf(-1L), new Option.CacheKeyUpdater<Long>() {
        private final ByteBuffer a = ByteBuffer.allocate(8);
        
        public void a(byte[] param1ArrayOfbyte, Long param1Long, MessageDigest param1MessageDigest) {
          param1MessageDigest.update(param1ArrayOfbyte);
          synchronized (this.a) {
            this.a.position(0);
            param1MessageDigest.update(this.a.putLong(param1Long.longValue()).array());
            return;
          } 
        }
      });
  
  public static final Option<Integer> b = Option.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", Integer.valueOf(2), new Option.CacheKeyUpdater<Integer>() {
        private final ByteBuffer a = ByteBuffer.allocate(4);
        
        public void a(byte[] param1ArrayOfbyte, Integer param1Integer, MessageDigest param1MessageDigest) {
          if (param1Integer == null)
            return; 
          param1MessageDigest.update(param1ArrayOfbyte);
          synchronized (this.a) {
            this.a.position(0);
            param1MessageDigest.update(this.a.putInt(param1Integer.intValue()).array());
            return;
          } 
        }
      });
  
  private static final MediaMetadataRetrieverFactory c = new MediaMetadataRetrieverFactory();
  
  private final MediaMetadataRetrieverInitializer<T> d;
  
  private final BitmapPool e;
  
  private final MediaMetadataRetrieverFactory f;
  
  VideoDecoder(BitmapPool paramBitmapPool, MediaMetadataRetrieverInitializer<T> paramMediaMetadataRetrieverInitializer) {
    this(paramBitmapPool, paramMediaMetadataRetrieverInitializer, c);
  }
  
  VideoDecoder(BitmapPool paramBitmapPool, MediaMetadataRetrieverInitializer<T> paramMediaMetadataRetrieverInitializer, MediaMetadataRetrieverFactory paramMediaMetadataRetrieverFactory) {
    this.e = paramBitmapPool;
    this.d = paramMediaMetadataRetrieverInitializer;
    this.f = paramMediaMetadataRetrieverFactory;
  }
  
  private static Bitmap a(MediaMetadataRetriever paramMediaMetadataRetriever, long paramLong, int paramInt) {
    return paramMediaMetadataRetriever.getFrameAtTime(paramLong, paramInt);
  }
  
  private static Bitmap a(MediaMetadataRetriever paramMediaMetadataRetriever, long paramLong, int paramInt1, int paramInt2, int paramInt3, DownsampleStrategy paramDownsampleStrategy) {
    Bitmap bitmap;
    if (Build.VERSION.SDK_INT >= 27 && paramInt2 != Integer.MIN_VALUE && paramInt3 != Integer.MIN_VALUE && paramDownsampleStrategy != DownsampleStrategy.f) {
      Bitmap bitmap1 = b(paramMediaMetadataRetriever, paramLong, paramInt1, paramInt2, paramInt3, paramDownsampleStrategy);
    } else {
      paramDownsampleStrategy = null;
    } 
    DownsampleStrategy downsampleStrategy = paramDownsampleStrategy;
    if (paramDownsampleStrategy == null)
      bitmap = a(paramMediaMetadataRetriever, paramLong, paramInt1); 
    return bitmap;
  }
  
  public static ResourceDecoder<AssetFileDescriptor, Bitmap> a(BitmapPool paramBitmapPool) {
    return new VideoDecoder<AssetFileDescriptor>(paramBitmapPool, new AssetFileDescriptorInitializer());
  }
  
  private static Bitmap b(MediaMetadataRetriever paramMediaMetadataRetriever, long paramLong, int paramInt1, int paramInt2, int paramInt3, DownsampleStrategy paramDownsampleStrategy) {
    int i;
    int k;
    try {
      k = Integer.parseInt(paramMediaMetadataRetriever.extractMetadata(18));
      i = Integer.parseInt(paramMediaMetadataRetriever.extractMetadata(19));
    } finally {
      paramMediaMetadataRetriever = null;
      if (Log.isLoggable("VideoDecoder", 3))
        Log.d("VideoDecoder", "Exception trying to decode frame on oreo+", (Throwable)paramMediaMetadataRetriever); 
    } 
    int j = i;
    int m = k;
    float f = paramDownsampleStrategy.a(j, m, paramInt2, paramInt3);
    return paramMediaMetadataRetriever.getScaledFrameAtTime(paramLong, paramInt1, Math.round(j * f), Math.round(f * m));
  }
  
  public static ResourceDecoder<ParcelFileDescriptor, Bitmap> b(BitmapPool paramBitmapPool) {
    return new VideoDecoder<ParcelFileDescriptor>(paramBitmapPool, new ParcelFileDescriptorInitializer());
  }
  
  public static ResourceDecoder<ByteBuffer, Bitmap> c(BitmapPool paramBitmapPool) {
    return new VideoDecoder<ByteBuffer>(paramBitmapPool, new ByteBufferInitializer());
  }
  
  public Resource<Bitmap> a(T paramT, int paramInt1, int paramInt2, Options paramOptions) throws IOException {
    long l = ((Long)paramOptions.a(a)).longValue();
    if (l >= 0L || l == -1L) {
      Integer integer2 = (Integer)paramOptions.a(b);
      Integer integer1 = integer2;
      if (integer2 == null)
        integer1 = Integer.valueOf(2); 
      DownsampleStrategy downsampleStrategy2 = (DownsampleStrategy)paramOptions.a(DownsampleStrategy.h);
      DownsampleStrategy downsampleStrategy1 = downsampleStrategy2;
      if (downsampleStrategy2 == null)
        downsampleStrategy1 = DownsampleStrategy.g; 
      MediaMetadataRetriever mediaMetadataRetriever = this.f.a();
      try {
        this.d.a(mediaMetadataRetriever, paramT);
        Bitmap bitmap = a(mediaMetadataRetriever, l, integer1.intValue(), paramInt1, paramInt2, downsampleStrategy1);
        mediaMetadataRetriever.release();
        return BitmapResource.a(bitmap, this.e);
      } catch (RuntimeException runtimeException) {
        throw new IOException(runtimeException);
      } finally {}
      mediaMetadataRetriever.release();
      throw paramT;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Requested frame must be non-negative, or DEFAULT_FRAME, given: ");
    stringBuilder.append(l);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public boolean a(T paramT, Options paramOptions) {
    return true;
  }
  
  static final class AssetFileDescriptorInitializer implements MediaMetadataRetrieverInitializer<AssetFileDescriptor> {
    private AssetFileDescriptorInitializer() {}
    
    public void a(MediaMetadataRetriever param1MediaMetadataRetriever, AssetFileDescriptor param1AssetFileDescriptor) {
      param1MediaMetadataRetriever.setDataSource(param1AssetFileDescriptor.getFileDescriptor(), param1AssetFileDescriptor.getStartOffset(), param1AssetFileDescriptor.getLength());
    }
  }
  
  static final class ByteBufferInitializer implements MediaMetadataRetrieverInitializer<ByteBuffer> {
    public void a(MediaMetadataRetriever param1MediaMetadataRetriever, ByteBuffer param1ByteBuffer) {
      param1MediaMetadataRetriever.setDataSource(new MediaDataSource(this, param1ByteBuffer) {
            public void close() {}
            
            public long getSize() {
              return this.a.limit();
            }
            
            public int readAt(long param2Long, byte[] param2ArrayOfbyte, int param2Int1, int param2Int2) {
              if (param2Long >= this.a.limit())
                return -1; 
              this.a.position((int)param2Long);
              param2Int2 = Math.min(param2Int2, this.a.remaining());
              this.a.get(param2ArrayOfbyte, param2Int1, param2Int2);
              return param2Int2;
            }
          });
    }
  }
  
  class null extends MediaDataSource {
    null(VideoDecoder this$0, ByteBuffer param1ByteBuffer) {}
    
    public void close() {}
    
    public long getSize() {
      return this.a.limit();
    }
    
    public int readAt(long param1Long, byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      if (param1Long >= this.a.limit())
        return -1; 
      this.a.position((int)param1Long);
      param1Int2 = Math.min(param1Int2, this.a.remaining());
      this.a.get(param1ArrayOfbyte, param1Int1, param1Int2);
      return param1Int2;
    }
  }
  
  static class MediaMetadataRetrieverFactory {
    public MediaMetadataRetriever a() {
      return new MediaMetadataRetriever();
    }
  }
  
  static interface MediaMetadataRetrieverInitializer<T> {
    void a(MediaMetadataRetriever param1MediaMetadataRetriever, T param1T);
  }
  
  static final class ParcelFileDescriptorInitializer implements MediaMetadataRetrieverInitializer<ParcelFileDescriptor> {
    public void a(MediaMetadataRetriever param1MediaMetadataRetriever, ParcelFileDescriptor param1ParcelFileDescriptor) {
      param1MediaMetadataRetriever.setDataSource(param1ParcelFileDescriptor.getFileDescriptor());
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\bitmap\VideoDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */