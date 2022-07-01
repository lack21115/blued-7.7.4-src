package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.File;
import java.util.List;

class DataCacheGenerator implements DataFetcher.DataCallback<Object>, DataFetcherGenerator {
  private final List<Key> a;
  
  private final DecodeHelper<?> b;
  
  private final DataFetcherGenerator.FetcherReadyCallback c;
  
  private int d = -1;
  
  private Key e;
  
  private List<ModelLoader<File, ?>> f;
  
  private int g;
  
  private volatile ModelLoader.LoadData<?> h;
  
  private File i;
  
  DataCacheGenerator(DecodeHelper<?> paramDecodeHelper, DataFetcherGenerator.FetcherReadyCallback paramFetcherReadyCallback) {
    this(paramDecodeHelper.o(), paramDecodeHelper, paramFetcherReadyCallback);
  }
  
  DataCacheGenerator(List<Key> paramList, DecodeHelper<?> paramDecodeHelper, DataFetcherGenerator.FetcherReadyCallback paramFetcherReadyCallback) {
    this.a = paramList;
    this.b = paramDecodeHelper;
    this.c = paramFetcherReadyCallback;
  }
  
  private boolean c() {
    return (this.g < this.f.size());
  }
  
  public void a(Exception paramException) {
    this.c.a(this.e, paramException, this.h.c, DataSource.c);
  }
  
  public void a(Object paramObject) {
    this.c.a(this.e, paramObject, this.h.c, DataSource.c, this.e);
  }
  
  public boolean a() {
    while (true) {
      List<ModelLoader<File, ?>> list = this.f;
      boolean bool = false;
      if (list == null || !c()) {
        this.d++;
        if (this.d >= this.a.size())
          return false; 
        Key key = this.a.get(this.d);
        DataCacheKey dataCacheKey = new DataCacheKey(key, this.b.f());
        this.i = this.b.b().a(dataCacheKey);
        File file = this.i;
        if (file != null) {
          this.e = key;
          this.f = this.b.a(file);
          this.g = 0;
        } 
        continue;
      } 
      this.h = null;
      while (!bool && c()) {
        list = this.f;
        int i = this.g;
        this.g = i + 1;
        this.h = ((ModelLoader)list.get(i)).a(this.i, this.b.g(), this.b.h(), this.b.e());
        if (this.h != null && this.b.a(this.h.c.c())) {
          this.h.c.a(this.b.d(), this);
          bool = true;
        } 
      } 
      return bool;
    } 
  }
  
  public void b() {
    ModelLoader.LoadData<?> loadData = this.h;
    if (loadData != null)
      loadData.c.b(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\engine\DataCacheGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */