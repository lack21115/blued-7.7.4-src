package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.gifdecoder.GifHeaderParser;
import com.bumptech.glide.gifdecoder.StandardGifDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.UnitTransformation;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

public class ByteBufferGifDecoder implements ResourceDecoder<ByteBuffer, GifDrawable> {
  private static final GifDecoderFactory a = new GifDecoderFactory();
  
  private static final GifHeaderParserPool b = new GifHeaderParserPool();
  
  private final Context c;
  
  private final List<ImageHeaderParser> d;
  
  private final GifHeaderParserPool e;
  
  private final GifDecoderFactory f;
  
  private final GifBitmapProvider g;
  
  public ByteBufferGifDecoder(Context paramContext, List<ImageHeaderParser> paramList, BitmapPool paramBitmapPool, ArrayPool paramArrayPool) {
    this(paramContext, paramList, paramBitmapPool, paramArrayPool, b, a);
  }
  
  ByteBufferGifDecoder(Context paramContext, List<ImageHeaderParser> paramList, BitmapPool paramBitmapPool, ArrayPool paramArrayPool, GifHeaderParserPool paramGifHeaderParserPool, GifDecoderFactory paramGifDecoderFactory) {
    this.c = paramContext.getApplicationContext();
    this.d = paramList;
    this.f = paramGifDecoderFactory;
    this.g = new GifBitmapProvider(paramBitmapPool, paramArrayPool);
    this.e = paramGifHeaderParserPool;
  }
  
  private static int a(GifHeader paramGifHeader, int paramInt1, int paramInt2) {
    int i = Math.min(paramGifHeader.a() / paramInt2, paramGifHeader.b() / paramInt1);
    if (i == 0) {
      i = 0;
    } else {
      i = Integer.highestOneBit(i);
    } 
    i = Math.max(1, i);
    if (Log.isLoggable("BufferGifDecoder", 2) && i > 1) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Downsampling GIF, sampleSize: ");
      stringBuilder.append(i);
      stringBuilder.append(", target dimens: [");
      stringBuilder.append(paramInt1);
      stringBuilder.append("x");
      stringBuilder.append(paramInt2);
      stringBuilder.append("], actual dimens: [");
      stringBuilder.append(paramGifHeader.b());
      stringBuilder.append("x");
      stringBuilder.append(paramGifHeader.a());
      stringBuilder.append("]");
      Log.v("BufferGifDecoder", stringBuilder.toString());
    } 
    return i;
  }
  
  private GifDrawableResource a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, GifHeaderParser paramGifHeaderParser, Options paramOptions) {
    long l = LogTime.a();
    try {
      StringBuilder stringBuilder2;
      StringBuilder stringBuilder1;
      Bitmap.Config config;
      GifHeader gifHeader = paramGifHeaderParser.b();
      if (gifHeader.c() <= 0 || gifHeader.d() != 0)
        return null; 
      if (paramOptions.a(GifOptions.a) == DecodeFormat.b) {
        config = Bitmap.Config.RGB_565;
      } else {
        config = Bitmap.Config.ARGB_8888;
      } 
      int i = a(gifHeader, paramInt1, paramInt2);
      GifDecoder gifDecoder = this.f.a(this.g, gifHeader, (ByteBuffer)stringBuilder2, i);
      gifDecoder.a(config);
      gifDecoder.b();
      Bitmap bitmap = gifDecoder.i();
      if (bitmap == null)
        return null; 
      UnitTransformation unitTransformation = UnitTransformation.a();
      return new GifDrawableResource(new GifDrawable(this.c, (GifDecoder)stringBuilder1, (Transformation<Bitmap>)unitTransformation, paramInt1, paramInt2, bitmap));
    } finally {
      if (Log.isLoggable("BufferGifDecoder", 2)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Decoded GIF from stream in ");
        stringBuilder.append(LogTime.a(l));
        Log.v("BufferGifDecoder", stringBuilder.toString());
      } 
    } 
  }
  
  public GifDrawableResource a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, Options paramOptions) {
    GifHeaderParser gifHeaderParser = this.e.a(paramByteBuffer);
    try {
      return a(paramByteBuffer, paramInt1, paramInt2, gifHeaderParser, paramOptions);
    } finally {
      this.e.a(gifHeaderParser);
    } 
  }
  
  public boolean a(ByteBuffer paramByteBuffer, Options paramOptions) throws IOException {
    return (!((Boolean)paramOptions.a(GifOptions.b)).booleanValue() && ImageHeaderParserUtils.a(this.d, paramByteBuffer) == ImageHeaderParser.ImageType.GIF);
  }
  
  static class GifDecoderFactory {
    GifDecoder a(GifDecoder.BitmapProvider param1BitmapProvider, GifHeader param1GifHeader, ByteBuffer param1ByteBuffer, int param1Int) {
      return (GifDecoder)new StandardGifDecoder(param1BitmapProvider, param1GifHeader, param1ByteBuffer, param1Int);
    }
  }
  
  static class GifHeaderParserPool {
    private final Queue<GifHeaderParser> a = Util.a(0);
    
    GifHeaderParser a(ByteBuffer param1ByteBuffer) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield a : Ljava/util/Queue;
      //   6: invokeinterface poll : ()Ljava/lang/Object;
      //   11: checkcast com/bumptech/glide/gifdecoder/GifHeaderParser
      //   14: astore_3
      //   15: aload_3
      //   16: astore_2
      //   17: aload_3
      //   18: ifnonnull -> 29
      //   21: new com/bumptech/glide/gifdecoder/GifHeaderParser
      //   24: dup
      //   25: invokespecial <init> : ()V
      //   28: astore_2
      //   29: aload_2
      //   30: aload_1
      //   31: invokevirtual a : (Ljava/nio/ByteBuffer;)Lcom/bumptech/glide/gifdecoder/GifHeaderParser;
      //   34: astore_1
      //   35: aload_0
      //   36: monitorexit
      //   37: aload_1
      //   38: areturn
      //   39: astore_1
      //   40: aload_0
      //   41: monitorexit
      //   42: aload_1
      //   43: athrow
      // Exception table:
      //   from	to	target	type
      //   2	15	39	finally
      //   21	29	39	finally
      //   29	35	39	finally
    }
    
    void a(GifHeaderParser param1GifHeaderParser) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_1
      //   3: invokevirtual a : ()V
      //   6: aload_0
      //   7: getfield a : Ljava/util/Queue;
      //   10: aload_1
      //   11: invokeinterface offer : (Ljava/lang/Object;)Z
      //   16: pop
      //   17: aload_0
      //   18: monitorexit
      //   19: return
      //   20: astore_1
      //   21: aload_0
      //   22: monitorexit
      //   23: aload_1
      //   24: athrow
      // Exception table:
      //   from	to	target	type
      //   2	17	20	finally
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\gif\ByteBufferGifDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */