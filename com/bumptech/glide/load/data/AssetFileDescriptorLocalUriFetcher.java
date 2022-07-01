package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.FileNotFoundException;
import java.io.IOException;

public final class AssetFileDescriptorLocalUriFetcher extends LocalUriFetcher<AssetFileDescriptor> {
  public AssetFileDescriptorLocalUriFetcher(ContentResolver paramContentResolver, Uri paramUri) {
    super(paramContentResolver, paramUri);
  }
  
  protected AssetFileDescriptor a(Uri paramUri, ContentResolver paramContentResolver) throws FileNotFoundException {
    AssetFileDescriptor assetFileDescriptor = paramContentResolver.openAssetFileDescriptor(paramUri, "r");
    if (assetFileDescriptor != null)
      return assetFileDescriptor; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("FileDescriptor is null for: ");
    stringBuilder.append(paramUri);
    throw new FileNotFoundException(stringBuilder.toString());
  }
  
  protected void a(AssetFileDescriptor paramAssetFileDescriptor) throws IOException {
    paramAssetFileDescriptor.close();
  }
  
  public Class<AssetFileDescriptor> c() {
    return AssetFileDescriptor.class;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\data\AssetFileDescriptorLocalUriFetcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */