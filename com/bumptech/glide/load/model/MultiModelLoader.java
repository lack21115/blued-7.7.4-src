package com.bumptech.glide.load.model;

import androidx.core.util.Pools;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class MultiModelLoader<Model, Data> implements ModelLoader<Model, Data> {
  private final List<ModelLoader<Model, Data>> a;
  
  private final Pools.Pool<List<Throwable>> b;
  
  MultiModelLoader(List<ModelLoader<Model, Data>> paramList, Pools.Pool<List<Throwable>> paramPool) {
    this.a = paramList;
    this.b = paramPool;
  }
  
  public ModelLoader.LoadData<Data> a(Model paramModel, int paramInt1, int paramInt2, Options paramOptions) {
    ModelLoader.LoadData<Data> loadData;
    int j = this.a.size();
    ArrayList<DataFetcher> arrayList = new ArrayList(j);
    Model model = null;
    int i = 0;
    Key key;
    for (key = null; i < j; key = key1) {
      ModelLoader modelLoader = this.a.get(i);
      Key key1 = key;
      if (modelLoader.a(paramModel)) {
        ModelLoader.LoadData loadData1 = modelLoader.a(paramModel, paramInt1, paramInt2, paramOptions);
        key1 = key;
        if (loadData1 != null) {
          key1 = loadData1.a;
          arrayList.add(loadData1.c);
        } 
      } 
      i++;
    } 
    paramModel = model;
    if (!arrayList.isEmpty()) {
      paramModel = model;
      if (key != null)
        loadData = new ModelLoader.LoadData(key, new MultiFetcher((List)arrayList, this.b)); 
    } 
    return loadData;
  }
  
  public boolean a(Model paramModel) {
    Iterator<ModelLoader<Model, Data>> iterator = this.a.iterator();
    while (iterator.hasNext()) {
      if (((ModelLoader)iterator.next()).a(paramModel))
        return true; 
    } 
    return false;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("MultiModelLoader{modelLoaders=");
    stringBuilder.append(Arrays.toString(this.a.toArray()));
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
  
  static class MultiFetcher<Data> implements DataFetcher<Data>, DataFetcher.DataCallback<Data> {
    private final List<DataFetcher<Data>> a;
    
    private final Pools.Pool<List<Throwable>> b;
    
    private int c;
    
    private Priority d;
    
    private DataFetcher.DataCallback<? super Data> e;
    
    private List<Throwable> f;
    
    private boolean g;
    
    MultiFetcher(List<DataFetcher<Data>> param1List, Pools.Pool<List<Throwable>> param1Pool) {
      this.b = param1Pool;
      Preconditions.a(param1List);
      this.a = param1List;
      this.c = 0;
    }
    
    private void e() {
      if (this.g)
        return; 
      if (this.c < this.a.size() - 1) {
        this.c++;
        a(this.d, this.e);
        return;
      } 
      Preconditions.a(this.f);
      this.e.a((Exception)new GlideException("Fetch failed", new ArrayList<Throwable>(this.f)));
    }
    
    public void a() {
      List<Throwable> list = this.f;
      if (list != null)
        this.b.release(list); 
      this.f = null;
      Iterator<DataFetcher<Data>> iterator = this.a.iterator();
      while (iterator.hasNext())
        ((DataFetcher)iterator.next()).a(); 
    }
    
    public void a(Priority param1Priority, DataFetcher.DataCallback<? super Data> param1DataCallback) {
      this.d = param1Priority;
      this.e = param1DataCallback;
      this.f = (List<Throwable>)this.b.acquire();
      ((DataFetcher)this.a.get(this.c)).a(param1Priority, this);
      if (this.g)
        b(); 
    }
    
    public void a(Exception param1Exception) {
      ((List<Exception>)Preconditions.a(this.f)).add(param1Exception);
      e();
    }
    
    public void a(Data param1Data) {
      if (param1Data != null) {
        this.e.a(param1Data);
        return;
      } 
      e();
    }
    
    public void b() {
      this.g = true;
      Iterator<DataFetcher<Data>> iterator = this.a.iterator();
      while (iterator.hasNext())
        ((DataFetcher)iterator.next()).b(); 
    }
    
    public Class<Data> c() {
      return ((DataFetcher)this.a.get(0)).c();
    }
    
    public DataSource d() {
      return ((DataFetcher)this.a.get(0)).d();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\model\MultiModelLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */