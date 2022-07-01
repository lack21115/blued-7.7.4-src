package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;

public class BitmapDrawableDecoder<DataType> implements ResourceDecoder<DataType, BitmapDrawable> {
  private final ResourceDecoder<DataType, Bitmap> a;
  
  private final Resources b;
  
  public BitmapDrawableDecoder(Resources paramResources, ResourceDecoder<DataType, Bitmap> paramResourceDecoder) {
    this.b = (Resources)Preconditions.a(paramResources);
    this.a = (ResourceDecoder<DataType, Bitmap>)Preconditions.a(paramResourceDecoder);
  }
  
  public Resource<BitmapDrawable> a(DataType paramDataType, int paramInt1, int paramInt2, Options paramOptions) throws IOException {
    Resource<Bitmap> resource = this.a.a(paramDataType, paramInt1, paramInt2, paramOptions);
    return LazyBitmapDrawableResource.a(this.b, resource);
  }
  
  public boolean a(DataType paramDataType, Options paramOptions) throws IOException {
    return this.a.a(paramDataType, paramOptions);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\bitmap\BitmapDrawableDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */