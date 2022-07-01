package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;

public final class ParcelFileDescriptorBitmapDecoder implements ResourceDecoder<ParcelFileDescriptor, Bitmap> {
  private final Downsampler a;
  
  public ParcelFileDescriptorBitmapDecoder(Downsampler paramDownsampler) {
    this.a = paramDownsampler;
  }
  
  public Resource<Bitmap> a(ParcelFileDescriptor paramParcelFileDescriptor, int paramInt1, int paramInt2, Options paramOptions) throws IOException {
    return this.a.a(paramParcelFileDescriptor, paramInt1, paramInt2, paramOptions);
  }
  
  public boolean a(ParcelFileDescriptor paramParcelFileDescriptor, Options paramOptions) {
    return this.a.a(paramParcelFileDescriptor);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\bitmap\ParcelFileDescriptorBitmapDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */