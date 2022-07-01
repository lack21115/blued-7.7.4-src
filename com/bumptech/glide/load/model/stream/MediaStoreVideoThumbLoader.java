package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.data.mediastore.ThumbFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.signature.ObjectKey;
import java.io.InputStream;

public class MediaStoreVideoThumbLoader implements ModelLoader<Uri, InputStream> {
  private final Context a;
  
  public MediaStoreVideoThumbLoader(Context paramContext) {
    this.a = paramContext.getApplicationContext();
  }
  
  private boolean a(Options paramOptions) {
    Long long_ = (Long)paramOptions.a(VideoDecoder.a);
    return (long_ != null && long_.longValue() == -1L);
  }
  
  public ModelLoader.LoadData<InputStream> a(Uri paramUri, int paramInt1, int paramInt2, Options paramOptions) {
    return (MediaStoreUtil.a(paramInt1, paramInt2) && a(paramOptions)) ? new ModelLoader.LoadData((Key)new ObjectKey(paramUri), (DataFetcher)ThumbFetcher.b(this.a, paramUri)) : null;
  }
  
  public boolean a(Uri paramUri) {
    return MediaStoreUtil.b(paramUri);
  }
  
  public static class Factory implements ModelLoaderFactory<Uri, InputStream> {
    private final Context a;
    
    public Factory(Context param1Context) {
      this.a = param1Context;
    }
    
    public ModelLoader<Uri, InputStream> a(MultiModelLoaderFactory param1MultiModelLoaderFactory) {
      return new MediaStoreVideoThumbLoader(this.a);
    }
    
    public void a() {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\model\stream\MediaStoreVideoThumbLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */