package com.bumptech.glide.load.engine;

import androidx.core.util.Pools;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoadPath<Data, ResourceType, Transcode> {
  private final Class<Data> a;
  
  private final Pools.Pool<List<Throwable>> b;
  
  private final List<? extends DecodePath<Data, ResourceType, Transcode>> c;
  
  private final String d;
  
  public LoadPath(Class<Data> paramClass, Class<ResourceType> paramClass1, Class<Transcode> paramClass2, List<DecodePath<Data, ResourceType, Transcode>> paramList, Pools.Pool<List<Throwable>> paramPool) {
    this.a = paramClass;
    this.b = paramPool;
    this.c = (List<? extends DecodePath<Data, ResourceType, Transcode>>)Preconditions.a(paramList);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Failed LoadPath{");
    stringBuilder.append(paramClass.getSimpleName());
    stringBuilder.append("->");
    stringBuilder.append(paramClass1.getSimpleName());
    stringBuilder.append("->");
    stringBuilder.append(paramClass2.getSimpleName());
    stringBuilder.append("}");
    this.d = stringBuilder.toString();
  }
  
  private Resource<Transcode> a(DataRewinder<Data> paramDataRewinder, Options paramOptions, int paramInt1, int paramInt2, DecodePath.DecodeCallback<ResourceType> paramDecodeCallback, List<Throwable> paramList) throws GlideException {
    Resource<Transcode> resource;
    int j = this.c.size();
    int i = 0;
    DecodePath decodePath = null;
    while (true) {
      DecodePath decodePath1 = decodePath;
      if (i < j) {
        Resource<Transcode> resource1;
        decodePath1 = this.c.get(i);
        try {
          resource = decodePath1.a(paramDataRewinder, paramInt1, paramInt2, paramOptions, paramDecodeCallback);
          resource1 = resource;
        } catch (GlideException glideException) {
          paramList.add(glideException);
        } 
        if (resource1 != null) {
          resource = resource1;
          break;
        } 
        i++;
        continue;
      } 
      break;
    } 
    if (resource != null)
      return resource; 
    throw new GlideException(this.d, new ArrayList(paramList));
  }
  
  public Resource<Transcode> a(DataRewinder<Data> paramDataRewinder, Options paramOptions, int paramInt1, int paramInt2, DecodePath.DecodeCallback<ResourceType> paramDecodeCallback) throws GlideException {
    List<Throwable> list = (List)Preconditions.a(this.b.acquire());
    try {
      return a(paramDataRewinder, paramOptions, paramInt1, paramInt2, paramDecodeCallback, list);
    } finally {
      this.b.release(list);
    } 
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("LoadPath{decodePaths=");
    stringBuilder.append(Arrays.toString(this.c.toArray()));
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\engine\LoadPath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */