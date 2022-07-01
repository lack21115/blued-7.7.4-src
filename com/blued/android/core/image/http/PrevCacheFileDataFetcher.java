package com.blued.android.core.image.http;

import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.utils.Log;
import java.io.File;

public class PrevCacheFileDataFetcher extends FileDataFetcher {
  private File a;
  
  public PrevCacheFileDataFetcher(File paramFile) {
    super(paramFile.getPath());
    this.a = paramFile;
  }
  
  public void a() {
    super.a();
    File file = this.a;
    if (file != null && file.exists()) {
      if (ImageLoader.a()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-- PrevCacheFileDataFetcher delete : ");
        stringBuilder.append(this.a.getPath());
        Log.e("IMAGE", stringBuilder.toString());
      } 
      this.a.delete();
      this.a = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\image\http\PrevCacheFileDataFetcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */