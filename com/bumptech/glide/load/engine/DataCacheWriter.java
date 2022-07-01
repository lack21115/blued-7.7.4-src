package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;

class DataCacheWriter<DataType> implements DiskCache.Writer {
  private final Encoder<DataType> a;
  
  private final DataType b;
  
  private final Options c;
  
  DataCacheWriter(Encoder<DataType> paramEncoder, DataType paramDataType, Options paramOptions) {
    this.a = paramEncoder;
    this.b = paramDataType;
    this.c = paramOptions;
  }
  
  public boolean a(File paramFile) {
    return this.a.a(this.b, paramFile, this.c);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\engine\DataCacheWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */