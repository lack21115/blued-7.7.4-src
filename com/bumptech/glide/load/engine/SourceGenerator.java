package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.LogTime;

class SourceGenerator implements DataFetcherGenerator, DataFetcherGenerator.FetcherReadyCallback {
  private final DecodeHelper<?> a;
  
  private final DataFetcherGenerator.FetcherReadyCallback b;
  
  private int c;
  
  private DataCacheGenerator d;
  
  private Object e;
  
  private volatile ModelLoader.LoadData<?> f;
  
  private DataCacheKey g;
  
  SourceGenerator(DecodeHelper<?> paramDecodeHelper, DataFetcherGenerator.FetcherReadyCallback paramFetcherReadyCallback) {
    this.a = paramDecodeHelper;
    this.b = paramFetcherReadyCallback;
  }
  
  private void a(Object paramObject) {
    long l = LogTime.a();
    try {
      Encoder encoder = this.a.a(paramObject);
      DataCacheWriter dataCacheWriter = new DataCacheWriter(encoder, paramObject, this.a.e());
      this.g = new DataCacheKey(this.f.a, this.a.f());
      this.a.b().a(this.g, dataCacheWriter);
      if (Log.isLoggable("SourceGenerator", 2)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Finished encoding source to cache, key: ");
        stringBuilder.append(this.g);
        stringBuilder.append(", data: ");
        stringBuilder.append(paramObject);
        stringBuilder.append(", encoder: ");
        stringBuilder.append(encoder);
        stringBuilder.append(", duration: ");
        stringBuilder.append(LogTime.a(l));
        Log.v("SourceGenerator", stringBuilder.toString());
      } 
      this.f.c.a();
      return;
    } finally {
      this.f.c.a();
    } 
  }
  
  private void b(ModelLoader.LoadData<?> paramLoadData) {
    this.f.c.a(this.a.d(), new DataFetcher.DataCallback<Object>(this, paramLoadData) {
          public void a(Exception param1Exception) {
            if (this.b.a(this.a))
              this.b.a(this.a, param1Exception); 
          }
          
          public void a(Object param1Object) {
            if (this.b.a(this.a))
              this.b.a(this.a, param1Object); 
          }
        });
  }
  
  private boolean d() {
    return (this.c < this.a.n().size());
  }
  
  public void a(Key paramKey, Exception paramException, DataFetcher<?> paramDataFetcher, DataSource paramDataSource) {
    this.b.a(paramKey, paramException, paramDataFetcher, this.f.c.d());
  }
  
  public void a(Key paramKey1, Object paramObject, DataFetcher<?> paramDataFetcher, DataSource paramDataSource, Key paramKey2) {
    this.b.a(paramKey1, paramObject, paramDataFetcher, this.f.c.d(), paramKey1);
  }
  
  void a(ModelLoader.LoadData<?> paramLoadData, Exception paramException) {
    this.b.a(this.g, paramException, paramLoadData.c, paramLoadData.c.d());
  }
  
  void a(ModelLoader.LoadData<?> paramLoadData, Object paramObject) {
    DiskCacheStrategy diskCacheStrategy = this.a.c();
    if (paramObject != null && diskCacheStrategy.a(paramLoadData.c.d())) {
      this.e = paramObject;
      this.b.c();
      return;
    } 
    this.b.a(paramLoadData.a, paramObject, paramLoadData.c, paramLoadData.c.d(), this.g);
  }
  
  public boolean a() {
    Object<ModelLoader.LoadData<?>> object = (Object<ModelLoader.LoadData<?>>)this.e;
    if (object != null) {
      this.e = null;
      a(object);
    } 
    object = (Object<ModelLoader.LoadData<?>>)this.d;
    if (object != null && object.a())
      return true; 
    this.d = null;
    this.f = null;
    boolean bool = false;
    while (!bool && d()) {
      object = (Object<ModelLoader.LoadData<?>>)this.a.n();
      int i = this.c;
      this.c = i + 1;
      this.f = object.get(i);
      if (this.f != null && (this.a.c().a(this.f.c.d()) || this.a.a(this.f.c.c()))) {
        b(this.f);
        bool = true;
      } 
    } 
    return bool;
  }
  
  boolean a(ModelLoader.LoadData<?> paramLoadData) {
    ModelLoader.LoadData<?> loadData = this.f;
    return (loadData != null && loadData == paramLoadData);
  }
  
  public void b() {
    ModelLoader.LoadData<?> loadData = this.f;
    if (loadData != null)
      loadData.c.b(); 
  }
  
  public void c() {
    throw new UnsupportedOperationException();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\engine\SourceGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */