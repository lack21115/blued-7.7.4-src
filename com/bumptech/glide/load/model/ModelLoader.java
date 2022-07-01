package com.bumptech.glide.load.model;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.util.Preconditions;
import java.util.Collections;
import java.util.List;

public interface ModelLoader<Model, Data> {
  LoadData<Data> a(Model paramModel, int paramInt1, int paramInt2, Options paramOptions);
  
  boolean a(Model paramModel);
  
  public static class LoadData<Data> {
    public final Key a;
    
    public final List<Key> b;
    
    public final DataFetcher<Data> c;
    
    public LoadData(Key param1Key, DataFetcher<Data> param1DataFetcher) {
      this(param1Key, Collections.emptyList(), param1DataFetcher);
    }
    
    public LoadData(Key param1Key, List<Key> param1List, DataFetcher<Data> param1DataFetcher) {
      this.a = (Key)Preconditions.a(param1Key);
      this.b = (List<Key>)Preconditions.a(param1List);
      this.c = (DataFetcher<Data>)Preconditions.a(param1DataFetcher);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\model\ModelLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */