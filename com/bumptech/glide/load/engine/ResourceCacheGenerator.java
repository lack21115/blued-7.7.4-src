package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.File;
import java.util.List;

class ResourceCacheGenerator implements DataFetcher.DataCallback<Object>, DataFetcherGenerator {
  private final DataFetcherGenerator.FetcherReadyCallback a;
  
  private final DecodeHelper<?> b;
  
  private int c;
  
  private int d = -1;
  
  private Key e;
  
  private List<ModelLoader<File, ?>> f;
  
  private int g;
  
  private volatile ModelLoader.LoadData<?> h;
  
  private File i;
  
  private ResourceCacheKey j;
  
  ResourceCacheGenerator(DecodeHelper<?> paramDecodeHelper, DataFetcherGenerator.FetcherReadyCallback paramFetcherReadyCallback) {
    this.b = paramDecodeHelper;
    this.a = paramFetcherReadyCallback;
  }
  
  private boolean c() {
    return (this.g < this.f.size());
  }
  
  public void a(Exception paramException) {
    this.a.a(this.j, paramException, this.h.c, DataSource.d);
  }
  
  public void a(Object paramObject) {
    this.a.a(this.e, paramObject, this.h.c, DataSource.d, this.j);
  }
  
  public boolean a() {
    StringBuilder stringBuilder;
    List<Key> list = this.b.o();
    boolean bool1 = list.isEmpty();
    boolean bool = false;
    if (bool1)
      return false; 
    List<Class<?>> list1 = this.b.l();
    if (list1.isEmpty()) {
      if (File.class.equals(this.b.j()))
        return false; 
      stringBuilder = new StringBuilder();
      stringBuilder.append("Failed to find any load path from ");
      stringBuilder.append(this.b.k());
      stringBuilder.append(" to ");
      stringBuilder.append(this.b.j());
      throw new IllegalStateException(stringBuilder.toString());
    } 
    while (true) {
      if (this.f == null || !c()) {
        this.d++;
        if (this.d >= list1.size()) {
          this.c++;
          if (this.c >= stringBuilder.size())
            return false; 
          this.d = 0;
        } 
        Key key = stringBuilder.get(this.c);
        Class<?> clazz = list1.get(this.d);
        Transformation<?> transformation = this.b.c(clazz);
        this.j = new ResourceCacheKey(this.b.i(), key, this.b.f(), this.b.g(), this.b.h(), transformation, clazz, this.b.e());
        this.i = this.b.b().a(this.j);
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
        List<ModelLoader<File, ?>> list2 = this.f;
        int i = this.g;
        this.g = i + 1;
        this.h = ((ModelLoader)list2.get(i)).a(this.i, this.b.g(), this.b.h(), this.b.e());
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\engine\ResourceCacheGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */