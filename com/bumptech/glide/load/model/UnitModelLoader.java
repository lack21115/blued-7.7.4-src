package com.bumptech.glide.load.model;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.signature.ObjectKey;

public class UnitModelLoader<Model> implements ModelLoader<Model, Model> {
  private static final UnitModelLoader<?> a = new UnitModelLoader();
  
  public static <T> UnitModelLoader<T> a() {
    return (UnitModelLoader)a;
  }
  
  public ModelLoader.LoadData<Model> a(Model paramModel, int paramInt1, int paramInt2, Options paramOptions) {
    return new ModelLoader.LoadData<Model>((Key)new ObjectKey(paramModel), new UnitFetcher<Model>(paramModel));
  }
  
  public boolean a(Model paramModel) {
    return true;
  }
  
  public static class Factory<Model> implements ModelLoaderFactory<Model, Model> {
    private static final Factory<?> a = new Factory();
    
    public static <T> Factory<T> b() {
      return (Factory)a;
    }
    
    public ModelLoader<Model, Model> a(MultiModelLoaderFactory param1MultiModelLoaderFactory) {
      return UnitModelLoader.a();
    }
    
    public void a() {}
  }
  
  static class UnitFetcher<Model> implements DataFetcher<Model> {
    private final Model a;
    
    UnitFetcher(Model param1Model) {
      this.a = param1Model;
    }
    
    public void a() {}
    
    public void a(Priority param1Priority, DataFetcher.DataCallback<? super Model> param1DataCallback) {
      param1DataCallback.a(this.a);
    }
    
    public void b() {}
    
    public Class<Model> c() {
      return (Class)this.a.getClass();
    }
    
    public DataSource d() {
      return DataSource.a;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\model\UnitModelLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */