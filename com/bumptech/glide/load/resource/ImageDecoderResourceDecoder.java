package com.bumptech.glide.load.resource;

import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.HardwareConfigState;
import java.io.IOException;

public abstract class ImageDecoderResourceDecoder<T> implements ResourceDecoder<ImageDecoder.Source, T> {
  final HardwareConfigState a = HardwareConfigState.a();
  
  protected abstract Resource<T> a(ImageDecoder.Source paramSource, int paramInt1, int paramInt2, ImageDecoder.OnHeaderDecodedListener paramOnHeaderDecodedListener) throws IOException;
  
  public final Resource<T> a(ImageDecoder.Source paramSource, int paramInt1, int paramInt2, Options paramOptions) throws IOException {
    boolean bool;
    DecodeFormat decodeFormat = (DecodeFormat)paramOptions.a(Downsampler.a);
    DownsampleStrategy downsampleStrategy = (DownsampleStrategy)paramOptions.a(DownsampleStrategy.h);
    if (paramOptions.a(Downsampler.e) != null && ((Boolean)paramOptions.a(Downsampler.e)).booleanValue()) {
      bool = true;
    } else {
      bool = false;
    } 
    return a(paramSource, paramInt1, paramInt2, new ImageDecoder.OnHeaderDecodedListener(this, paramInt1, paramInt2, bool, decodeFormat, downsampleStrategy, (PreferredColorSpace)paramOptions.a(Downsampler.b)) {
          public void onHeaderDecoded(ImageDecoder param1ImageDecoder, ImageDecoder.ImageInfo param1ImageInfo, ImageDecoder.Source param1Source) {
            boolean bool1 = this.g.a.a(this.a, this.b, this.c, false);
            boolean bool = true;
            if (bool1) {
              param1ImageDecoder.setAllocator(3);
            } else {
              param1ImageDecoder.setAllocator(1);
            } 
            if (this.d == DecodeFormat.b)
              param1ImageDecoder.setMemorySizePolicy(0); 
            param1ImageDecoder.setOnPartialImageListener(new ImageDecoder.OnPartialImageListener(this) {
                  public boolean onPartialImage(ImageDecoder.DecodeException param2DecodeException) {
                    return false;
                  }
                });
            Size size = param1ImageInfo.getSize();
            int j = this.a;
            int i = j;
            if (j == Integer.MIN_VALUE)
              i = size.getWidth(); 
            int k = this.b;
            j = k;
            if (k == Integer.MIN_VALUE)
              j = size.getHeight(); 
            float f = this.e.a(size.getWidth(), size.getHeight(), i, j);
            i = Math.round(size.getWidth() * f);
            j = Math.round(size.getHeight() * f);
            if (Log.isLoggable("ImageDecoder", 2)) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("Resizing from [");
              stringBuilder.append(size.getWidth());
              stringBuilder.append("x");
              stringBuilder.append(size.getHeight());
              stringBuilder.append("] to [");
              stringBuilder.append(i);
              stringBuilder.append("x");
              stringBuilder.append(j);
              stringBuilder.append("] scaleFactor: ");
              stringBuilder.append(f);
              Log.v("ImageDecoder", stringBuilder.toString());
            } 
            param1ImageDecoder.setTargetSize(i, j);
            if (Build.VERSION.SDK_INT >= 28) {
              ColorSpace.Named named;
              if (this.f == PreferredColorSpace.b && param1ImageInfo.getColorSpace() != null && param1ImageInfo.getColorSpace().isWideGamut()) {
                i = bool;
              } else {
                i = 0;
              } 
              if (i != 0) {
                named = ColorSpace.Named.DISPLAY_P3;
              } else {
                named = ColorSpace.Named.SRGB;
              } 
              param1ImageDecoder.setTargetColorSpace(ColorSpace.get(named));
              return;
            } 
            if (Build.VERSION.SDK_INT >= 26)
              param1ImageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB)); 
          }
        });
  }
  
  public final boolean a(ImageDecoder.Source paramSource, Options paramOptions) {
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\ImageDecoderResourceDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */