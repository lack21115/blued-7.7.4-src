package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;

public class StreamAssetPathFetcher extends AssetPathFetcher<InputStream> {
  public StreamAssetPathFetcher(AssetManager paramAssetManager, String paramString) {
    super(paramAssetManager, paramString);
  }
  
  protected void a(InputStream paramInputStream) throws IOException {
    paramInputStream.close();
  }
  
  protected InputStream b(AssetManager paramAssetManager, String paramString) throws IOException {
    return paramAssetManager.open(paramString);
  }
  
  public Class<InputStream> c() {
    return InputStream.class;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\data\StreamAssetPathFetcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */