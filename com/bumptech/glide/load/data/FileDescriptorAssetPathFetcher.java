package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import java.io.IOException;

public class FileDescriptorAssetPathFetcher extends AssetPathFetcher<ParcelFileDescriptor> {
  public FileDescriptorAssetPathFetcher(AssetManager paramAssetManager, String paramString) {
    super(paramAssetManager, paramString);
  }
  
  protected void a(ParcelFileDescriptor paramParcelFileDescriptor) throws IOException {
    paramParcelFileDescriptor.close();
  }
  
  protected ParcelFileDescriptor b(AssetManager paramAssetManager, String paramString) throws IOException {
    return paramAssetManager.openFd(paramString).getParcelFileDescriptor();
  }
  
  public Class<ParcelFileDescriptor> c() {
    return ParcelFileDescriptor.class;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\data\FileDescriptorAssetPathFetcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */