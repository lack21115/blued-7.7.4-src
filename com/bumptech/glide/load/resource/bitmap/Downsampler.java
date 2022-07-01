package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public final class Downsampler {
  public static final Option<DecodeFormat> a = Option.a("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.c);
  
  public static final Option<PreferredColorSpace> b = Option.a("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", PreferredColorSpace.a);
  
  @Deprecated
  public static final Option<DownsampleStrategy> c = DownsampleStrategy.h;
  
  public static final Option<Boolean> d;
  
  public static final Option<Boolean> e;
  
  private static final Set<String> f = Collections.unmodifiableSet(new HashSet<String>(Arrays.asList(new String[] { "image/vnd.wap.wbmp", "image/x-ico" })));
  
  private static final DecodeCallbacks g = new DecodeCallbacks() {
      public void a() {}
      
      public void a(BitmapPool param1BitmapPool, Bitmap param1Bitmap) {}
    };
  
  private static final Set<ImageHeaderParser.ImageType> h = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
  
  private static final Queue<BitmapFactory.Options> i = Util.a(0);
  
  private final BitmapPool j;
  
  private final DisplayMetrics k;
  
  private final ArrayPool l;
  
  private final List<ImageHeaderParser> m;
  
  private final HardwareConfigState n = HardwareConfigState.a();
  
  public Downsampler(List<ImageHeaderParser> paramList, DisplayMetrics paramDisplayMetrics, BitmapPool paramBitmapPool, ArrayPool paramArrayPool) {
    this.m = paramList;
    this.k = (DisplayMetrics)Preconditions.a(paramDisplayMetrics);
    this.j = (BitmapPool)Preconditions.a(paramBitmapPool);
    this.l = (ArrayPool)Preconditions.a(paramArrayPool);
  }
  
  private static int a(double paramDouble) {
    int i = b(paramDouble);
    int j = c(i * paramDouble);
    return c(paramDouble / (j / i) * j);
  }
  
  private Bitmap a(ImageReader paramImageReader, BitmapFactory.Options paramOptions, DownsampleStrategy paramDownsampleStrategy, DecodeFormat paramDecodeFormat, PreferredColorSpace paramPreferredColorSpace, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, DecodeCallbacks paramDecodeCallbacks) throws IOException {
    Bitmap bitmap1;
    int i;
    long l = LogTime.a();
    int[] arrayOfInt = a(paramImageReader, paramOptions, paramDecodeCallbacks, this.j);
    boolean bool = false;
    int k = arrayOfInt[0];
    int m = arrayOfInt[1];
    String str = paramOptions.outMimeType;
    if (k == -1 || m == -1)
      paramBoolean1 = false; 
    int i1 = paramImageReader.b();
    int n = TransformationUtils.a(i1);
    boolean bool1 = TransformationUtils.b(i1);
    if (paramInt1 == Integer.MIN_VALUE) {
      if (a(n)) {
        i = m;
      } else {
        i = k;
      } 
    } else {
      i = paramInt1;
    } 
    int j = paramInt2;
    if (j == Integer.MIN_VALUE)
      if (a(n)) {
        j = k;
      } else {
        j = m;
      }  
    ImageHeaderParser.ImageType imageType = paramImageReader.a();
    a(imageType, paramImageReader, paramDecodeCallbacks, this.j, paramDownsampleStrategy, n, k, m, i, j, paramOptions);
    a(paramImageReader, paramDecodeFormat, paramBoolean1, bool1, paramOptions, i, j);
    if (Build.VERSION.SDK_INT >= 19) {
      n = 1;
    } else {
      n = 0;
    } 
    if (paramOptions.inSampleSize == 1 || n != 0) {
      Downsampler downsampler1 = this;
      if (downsampler1.a(imageType)) {
        if (k < 0 || m < 0 || !paramBoolean2 || n == 0) {
          float f1;
          if (a(paramOptions)) {
            f1 = paramOptions.inTargetDensity / paramOptions.inDensity;
          } else {
            f1 = 1.0F;
          } 
          int i3 = paramOptions.inSampleSize;
          float f2 = k;
          float f3 = i3;
          j = (int)Math.ceil((f2 / f3));
          i = (int)Math.ceil((m / f3));
          n = Math.round(j * f1);
          int i2 = Math.round(i * f1);
          i = n;
          j = i2;
          if (Log.isLoggable("Downsampler", 2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Calculated target [");
            stringBuilder.append(n);
            stringBuilder.append("x");
            stringBuilder.append(i2);
            stringBuilder.append("] for source [");
            stringBuilder.append(k);
            stringBuilder.append("x");
            stringBuilder.append(m);
            stringBuilder.append("], sampleSize: ");
            stringBuilder.append(i3);
            stringBuilder.append(", targetDensity: ");
            stringBuilder.append(paramOptions.inTargetDensity);
            stringBuilder.append(", density: ");
            stringBuilder.append(paramOptions.inDensity);
            stringBuilder.append(", density multiplier: ");
            stringBuilder.append(f1);
            Log.v("Downsampler", stringBuilder.toString());
            j = i2;
            i = n;
          } 
        } 
        if (i > 0 && j > 0)
          a(paramOptions, downsampler1.j, i, j); 
      } 
    } 
    Downsampler downsampler = this;
    if (Build.VERSION.SDK_INT >= 28) {
      ColorSpace.Named named;
      i = bool;
      if (paramPreferredColorSpace == PreferredColorSpace.b) {
        i = bool;
        if (paramOptions.outColorSpace != null) {
          i = bool;
          if (paramOptions.outColorSpace.isWideGamut())
            i = 1; 
        } 
      } 
      if (i != 0) {
        named = ColorSpace.Named.DISPLAY_P3;
      } else {
        named = ColorSpace.Named.SRGB;
      } 
      paramOptions.inPreferredColorSpace = ColorSpace.get(named);
    } else if (Build.VERSION.SDK_INT >= 26) {
      paramOptions.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
    } 
    Bitmap bitmap2 = b(paramImageReader, paramOptions, paramDecodeCallbacks, downsampler.j);
    paramDecodeCallbacks.a(downsampler.j, bitmap2);
    if (Log.isLoggable("Downsampler", 2))
      a(k, m, str, paramOptions, bitmap2, paramInt1, paramInt2, l); 
    paramImageReader = null;
    if (bitmap2 != null) {
      bitmap2.setDensity(downsampler.k.densityDpi);
      Bitmap bitmap = TransformationUtils.a(downsampler.j, bitmap2, i1);
      bitmap1 = bitmap;
      if (!bitmap2.equals(bitmap)) {
        downsampler.j.a(bitmap2);
        bitmap1 = bitmap;
      } 
    } 
    return bitmap1;
  }
  
  private static BitmapFactory.Options a() {
    // Byte code:
    //   0: ldc com/bumptech/glide/load/resource/bitmap/Downsampler
    //   2: monitorenter
    //   3: getstatic com/bumptech/glide/load/resource/bitmap/Downsampler.i : Ljava/util/Queue;
    //   6: astore_0
    //   7: aload_0
    //   8: monitorenter
    //   9: getstatic com/bumptech/glide/load/resource/bitmap/Downsampler.i : Ljava/util/Queue;
    //   12: invokeinterface poll : ()Ljava/lang/Object;
    //   17: checkcast android/graphics/BitmapFactory$Options
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: astore_0
    //   25: aload_1
    //   26: ifnonnull -> 41
    //   29: new android/graphics/BitmapFactory$Options
    //   32: dup
    //   33: invokespecial <init> : ()V
    //   36: astore_0
    //   37: aload_0
    //   38: invokestatic d : (Landroid/graphics/BitmapFactory$Options;)V
    //   41: ldc com/bumptech/glide/load/resource/bitmap/Downsampler
    //   43: monitorexit
    //   44: aload_0
    //   45: areturn
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    //   51: astore_0
    //   52: ldc com/bumptech/glide/load/resource/bitmap/Downsampler
    //   54: monitorexit
    //   55: aload_0
    //   56: athrow
    // Exception table:
    //   from	to	target	type
    //   3	9	51	finally
    //   9	23	46	finally
    //   29	41	51	finally
    //   47	49	46	finally
    //   49	51	51	finally
  }
  
  private Resource<Bitmap> a(ImageReader paramImageReader, int paramInt1, int paramInt2, Options paramOptions, DecodeCallbacks paramDecodeCallbacks) throws IOException {
    boolean bool;
    byte[] arrayOfByte = (byte[])this.l.a(65536, byte[].class);
    BitmapFactory.Options options = a();
    options.inTempStorage = arrayOfByte;
    DecodeFormat decodeFormat = (DecodeFormat)paramOptions.a(a);
    PreferredColorSpace preferredColorSpace = (PreferredColorSpace)paramOptions.a(b);
    DownsampleStrategy downsampleStrategy = (DownsampleStrategy)paramOptions.a(DownsampleStrategy.h);
    boolean bool1 = ((Boolean)paramOptions.a(d)).booleanValue();
    if (paramOptions.a(e) != null && ((Boolean)paramOptions.a(e)).booleanValue()) {
      bool = true;
    } else {
      bool = false;
    } 
    try {
      return BitmapResource.a(a(paramImageReader, options, downsampleStrategy, decodeFormat, preferredColorSpace, bool, paramInt1, paramInt2, bool1, paramDecodeCallbacks), this.j);
    } finally {
      c(options);
      this.l.a(arrayOfByte);
    } 
  }
  
  private static IOException a(IllegalArgumentException paramIllegalArgumentException, int paramInt1, int paramInt2, String paramString, BitmapFactory.Options paramOptions) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Exception decoding bitmap, outWidth: ");
    stringBuilder.append(paramInt1);
    stringBuilder.append(", outHeight: ");
    stringBuilder.append(paramInt2);
    stringBuilder.append(", outMimeType: ");
    stringBuilder.append(paramString);
    stringBuilder.append(", inBitmap: ");
    stringBuilder.append(b(paramOptions));
    return new IOException(stringBuilder.toString(), paramIllegalArgumentException);
  }
  
  private static String a(Bitmap paramBitmap) {
    String str;
    if (paramBitmap == null)
      return null; 
    if (Build.VERSION.SDK_INT >= 19) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(" (");
      stringBuilder1.append(paramBitmap.getAllocationByteCount());
      stringBuilder1.append(")");
      str = stringBuilder1.toString();
    } else {
      str = "";
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[");
    stringBuilder.append(paramBitmap.getWidth());
    stringBuilder.append("x");
    stringBuilder.append(paramBitmap.getHeight());
    stringBuilder.append("] ");
    stringBuilder.append(paramBitmap.getConfig());
    stringBuilder.append(str);
    return stringBuilder.toString();
  }
  
  private static void a(int paramInt1, int paramInt2, String paramString, BitmapFactory.Options paramOptions, Bitmap paramBitmap, int paramInt3, int paramInt4, long paramLong) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Decoded ");
    stringBuilder.append(a(paramBitmap));
    stringBuilder.append(" from [");
    stringBuilder.append(paramInt1);
    stringBuilder.append("x");
    stringBuilder.append(paramInt2);
    stringBuilder.append("] ");
    stringBuilder.append(paramString);
    stringBuilder.append(" with inBitmap ");
    stringBuilder.append(b(paramOptions));
    stringBuilder.append(" for [");
    stringBuilder.append(paramInt3);
    stringBuilder.append("x");
    stringBuilder.append(paramInt4);
    stringBuilder.append("], sample size: ");
    stringBuilder.append(paramOptions.inSampleSize);
    stringBuilder.append(", density: ");
    stringBuilder.append(paramOptions.inDensity);
    stringBuilder.append(", target density: ");
    stringBuilder.append(paramOptions.inTargetDensity);
    stringBuilder.append(", thread: ");
    stringBuilder.append(Thread.currentThread().getName());
    stringBuilder.append(", duration: ");
    stringBuilder.append(LogTime.a(paramLong));
    Log.v("Downsampler", stringBuilder.toString());
  }
  
  private static void a(BitmapFactory.Options paramOptions, BitmapPool paramBitmapPool, int paramInt1, int paramInt2) {
    Bitmap.Config config1;
    if (Build.VERSION.SDK_INT >= 26) {
      if (paramOptions.inPreferredConfig == Bitmap.Config.HARDWARE)
        return; 
      config1 = paramOptions.outConfig;
    } else {
      config1 = null;
    } 
    Bitmap.Config config2 = config1;
    if (config1 == null)
      config2 = paramOptions.inPreferredConfig; 
    paramOptions.inBitmap = paramBitmapPool.b(paramInt1, paramInt2, config2);
  }
  
  private static void a(ImageHeaderParser.ImageType paramImageType, ImageReader paramImageReader, DecodeCallbacks paramDecodeCallbacks, BitmapPool paramBitmapPool, DownsampleStrategy paramDownsampleStrategy, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, BitmapFactory.Options paramOptions) throws IOException {
    StringBuilder stringBuilder;
    int i;
    int j;
    if (paramInt2 <= 0 || paramInt3 <= 0) {
      if (Log.isLoggable("Downsampler", 3)) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to determine dimensions for: ");
        stringBuilder.append(paramImageType);
        stringBuilder.append(" with target [");
        stringBuilder.append(paramInt4);
        stringBuilder.append("x");
        stringBuilder.append(paramInt5);
        stringBuilder.append("]");
        Log.d("Downsampler", stringBuilder.toString());
      } 
      return;
    } 
    if (a(paramInt1)) {
      i = paramInt2;
      j = paramInt3;
    } else {
      j = paramInt2;
      i = paramInt3;
    } 
    float f = paramDownsampleStrategy.a(j, i, paramInt4, paramInt5);
    if (f > 0.0F) {
      DownsampleStrategy.SampleSizeRounding sampleSizeRounding = paramDownsampleStrategy.b(j, i, paramInt4, paramInt5);
      if (sampleSizeRounding != null) {
        float f1 = j;
        int m = c((f * f1));
        float f2 = i;
        int k = c((f * f2));
        m = j / m;
        k = i / k;
        if (sampleSizeRounding == DownsampleStrategy.SampleSizeRounding.a) {
          k = Math.max(m, k);
        } else {
          k = Math.min(m, k);
        } 
        if (Build.VERSION.SDK_INT <= 23 && f.contains(paramOptions.outMimeType)) {
          k = 1;
        } else {
          m = Math.max(1, Integer.highestOneBit(k));
          k = m;
          if (sampleSizeRounding == DownsampleStrategy.SampleSizeRounding.a) {
            k = m;
            if (m < 1.0F / f)
              k = m << 1; 
          } 
        } 
        paramOptions.inSampleSize = k;
        if (paramImageType == ImageHeaderParser.ImageType.JPEG) {
          float f3 = Math.min(k, 8);
          int n = (int)Math.ceil((f1 / f3));
          m = (int)Math.ceil((f2 / f3));
          int i1 = k / 8;
          i = m;
          j = n;
          if (i1 > 0) {
            j = n / i1;
            i = m / i1;
          } 
        } else {
          double d1;
          if (paramImageType == ImageHeaderParser.ImageType.PNG || paramImageType == ImageHeaderParser.ImageType.PNG_A) {
            float f3 = k;
            j = (int)Math.floor((f1 / f3));
            d1 = Math.floor((f2 / f3));
          } else {
            if (paramImageType == ImageHeaderParser.ImageType.WEBP || paramImageType == ImageHeaderParser.ImageType.WEBP_A) {
              if (Build.VERSION.SDK_INT >= 24) {
                float f3 = k;
                j = Math.round(f1 / f3);
                i = Math.round(f2 / f3);
              } else {
                float f3 = k;
                j = (int)Math.floor((f1 / f3));
                double d2 = Math.floor((f2 / f3));
                i = (int)d2;
              } 
            } else if (j % k != 0 || i % k != 0) {
              int[] arrayOfInt = a((ImageReader)stringBuilder, paramOptions, paramDecodeCallbacks, paramBitmapPool);
              j = arrayOfInt[0];
              i = arrayOfInt[1];
            } else {
              j /= k;
              i /= k;
            } 
            d1 = paramDownsampleStrategy.a(j, i, paramInt4, paramInt5);
          } 
          i = (int)d1;
        } 
      } else {
        throw new IllegalArgumentException("Cannot round with null rounding");
      } 
    } else {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Cannot scale with factor: ");
      stringBuilder1.append(f);
      stringBuilder1.append(" from: ");
      stringBuilder1.append(paramDownsampleStrategy);
      stringBuilder1.append(", source: [");
      stringBuilder1.append(paramInt2);
      stringBuilder1.append("x");
      stringBuilder1.append(paramInt3);
      stringBuilder1.append("], target: [");
      stringBuilder1.append(paramInt4);
      stringBuilder1.append("x");
      stringBuilder1.append(paramInt5);
      stringBuilder1.append("]");
      throw new IllegalArgumentException(stringBuilder1.toString());
    } 
    double d = paramDownsampleStrategy.a(j, i, paramInt4, paramInt5);
  }
  
  private void a(ImageReader paramImageReader, DecodeFormat paramDecodeFormat, boolean paramBoolean1, boolean paramBoolean2, BitmapFactory.Options paramOptions, int paramInt1, int paramInt2) {
    Bitmap.Config config;
    if (this.n.a(paramInt1, paramInt2, paramOptions, paramBoolean1, paramBoolean2))
      return; 
    if (paramDecodeFormat == DecodeFormat.a || Build.VERSION.SDK_INT == 16) {
      paramOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
      return;
    } 
    paramBoolean2 = false;
    try {
      paramBoolean1 = paramImageReader.a().hasAlpha();
    } catch (IOException iOException) {
      paramBoolean1 = paramBoolean2;
      if (Log.isLoggable("Downsampler", 3)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot determine whether the image has alpha or not from header, format ");
        stringBuilder.append(paramDecodeFormat);
        Log.d("Downsampler", stringBuilder.toString(), iOException);
        paramBoolean1 = paramBoolean2;
      } 
    } 
    if (paramBoolean1) {
      config = Bitmap.Config.ARGB_8888;
    } else {
      config = Bitmap.Config.RGB_565;
    } 
    paramOptions.inPreferredConfig = config;
    if (paramOptions.inPreferredConfig == Bitmap.Config.RGB_565)
      paramOptions.inDither = true; 
  }
  
  private static boolean a(int paramInt) {
    return (paramInt == 90 || paramInt == 270);
  }
  
  private static boolean a(BitmapFactory.Options paramOptions) {
    return (paramOptions.inTargetDensity > 0 && paramOptions.inDensity > 0 && paramOptions.inTargetDensity != paramOptions.inDensity);
  }
  
  private boolean a(ImageHeaderParser.ImageType paramImageType) {
    return (Build.VERSION.SDK_INT >= 19) ? true : h.contains(paramImageType);
  }
  
  private static int[] a(ImageReader paramImageReader, BitmapFactory.Options paramOptions, DecodeCallbacks paramDecodeCallbacks, BitmapPool paramBitmapPool) throws IOException {
    paramOptions.inJustDecodeBounds = true;
    b(paramImageReader, paramOptions, paramDecodeCallbacks, paramBitmapPool);
    paramOptions.inJustDecodeBounds = false;
    return new int[] { paramOptions.outWidth, paramOptions.outHeight };
  }
  
  private static int b(double paramDouble) {
    if (paramDouble > 1.0D)
      paramDouble = 1.0D / paramDouble; 
    return (int)Math.round(paramDouble * 2.147483647E9D);
  }
  
  private static Bitmap b(ImageReader paramImageReader, BitmapFactory.Options paramOptions, DecodeCallbacks paramDecodeCallbacks, BitmapPool paramBitmapPool) throws IOException {
    if (!paramOptions.inJustDecodeBounds) {
      paramDecodeCallbacks.a();
      paramImageReader.c();
    } 
    int i = paramOptions.outWidth;
    int j = paramOptions.outHeight;
    String str = paramOptions.outMimeType;
    TransformationUtils.a().lock();
    try {
      Bitmap bitmap = paramImageReader.a(paramOptions);
      TransformationUtils.a().unlock();
      return bitmap;
    } catch (IllegalArgumentException illegalArgumentException) {
      IOException iOException = a(illegalArgumentException, i, j, str, paramOptions);
      if (Log.isLoggable("Downsampler", 3))
        Log.d("Downsampler", "Failed to decode with inBitmap, trying again without Bitmap re-use", iOException); 
      Bitmap bitmap = paramOptions.inBitmap;
      if (bitmap != null)
        try {
          paramBitmapPool.a(paramOptions.inBitmap);
          paramOptions.inBitmap = null;
          Bitmap bitmap1 = b(paramImageReader, paramOptions, paramDecodeCallbacks, paramBitmapPool);
          TransformationUtils.a().unlock();
          return bitmap1;
        } catch (IOException iOException1) {
          throw iOException;
        }  
      throw iOException;
    } finally {}
    TransformationUtils.a().unlock();
    throw paramImageReader;
  }
  
  private static String b(BitmapFactory.Options paramOptions) {
    return a(paramOptions.inBitmap);
  }
  
  private static int c(double paramDouble) {
    return (int)(paramDouble + 0.5D);
  }
  
  private static void c(BitmapFactory.Options paramOptions) {
    d(paramOptions);
    synchronized (i) {
      i.offer(paramOptions);
      return;
    } 
  }
  
  private static void d(BitmapFactory.Options paramOptions) {
    paramOptions.inTempStorage = null;
    paramOptions.inDither = false;
    paramOptions.inScaled = false;
    paramOptions.inSampleSize = 1;
    paramOptions.inPreferredConfig = null;
    paramOptions.inJustDecodeBounds = false;
    paramOptions.inDensity = 0;
    paramOptions.inTargetDensity = 0;
    if (Build.VERSION.SDK_INT >= 26) {
      paramOptions.inPreferredColorSpace = null;
      paramOptions.outColorSpace = null;
      paramOptions.outConfig = null;
    } 
    paramOptions.outWidth = 0;
    paramOptions.outHeight = 0;
    paramOptions.outMimeType = null;
    paramOptions.inBitmap = null;
    paramOptions.inMutable = true;
  }
  
  public Resource<Bitmap> a(ParcelFileDescriptor paramParcelFileDescriptor, int paramInt1, int paramInt2, Options paramOptions) throws IOException {
    return a(new ImageReader.ParcelFileDescriptorImageReader(paramParcelFileDescriptor, this.m, this.l), paramInt1, paramInt2, paramOptions, g);
  }
  
  public Resource<Bitmap> a(InputStream paramInputStream, int paramInt1, int paramInt2, Options paramOptions) throws IOException {
    return a(paramInputStream, paramInt1, paramInt2, paramOptions, g);
  }
  
  public Resource<Bitmap> a(InputStream paramInputStream, int paramInt1, int paramInt2, Options paramOptions, DecodeCallbacks paramDecodeCallbacks) throws IOException {
    return a(new ImageReader.InputStreamImageReader(paramInputStream, this.m, this.l), paramInt1, paramInt2, paramOptions, paramDecodeCallbacks);
  }
  
  public boolean a(ParcelFileDescriptor paramParcelFileDescriptor) {
    return ParcelFileDescriptorRewinder.c();
  }
  
  public boolean a(InputStream paramInputStream) {
    return true;
  }
  
  public boolean a(ByteBuffer paramByteBuffer) {
    return true;
  }
  
  static {
    Boolean bool = Boolean.valueOf(false);
    d = Option.a("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
    e = Option.a("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
  }
  
  public static interface DecodeCallbacks {
    void a();
    
    void a(BitmapPool param1BitmapPool, Bitmap param1Bitmap) throws IOException;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\bitmap\Downsampler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */