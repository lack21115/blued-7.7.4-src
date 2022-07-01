package com.bumptech.glide.load.data.mediastore;

import java.io.File;

class FileService {
  public File a(String paramString) {
    return new File(paramString);
  }
  
  public boolean a(File paramFile) {
    return paramFile.exists();
  }
  
  public long b(File paramFile) {
    return paramFile.length();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\data\mediastore\FileService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */