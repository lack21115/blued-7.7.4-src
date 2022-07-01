package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.core.util.Pools;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DecodePath<DataType, ResourceType, Transcode> {
  private final Class<DataType> a;
  
  private final List<? extends ResourceDecoder<DataType, ResourceType>> b;
  
  private final ResourceTranscoder<ResourceType, Transcode> c;
  
  private final Pools.Pool<List<Throwable>> d;
  
  private final String e;
  
  public DecodePath(Class<DataType> paramClass, Class<ResourceType> paramClass1, Class<Transcode> paramClass2, List<? extends ResourceDecoder<DataType, ResourceType>> paramList, ResourceTranscoder<ResourceType, Transcode> paramResourceTranscoder, Pools.Pool<List<Throwable>> paramPool) {
    this.a = paramClass;
    this.b = paramList;
    this.c = paramResourceTranscoder;
    this.d = paramPool;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Failed DecodePath{");
    stringBuilder.append(paramClass.getSimpleName());
    stringBuilder.append("->");
    stringBuilder.append(paramClass1.getSimpleName());
    stringBuilder.append("->");
    stringBuilder.append(paramClass2.getSimpleName());
    stringBuilder.append("}");
    this.e = stringBuilder.toString();
  }
  
  private Resource<ResourceType> a(DataRewinder<DataType> paramDataRewinder, int paramInt1, int paramInt2, Options paramOptions) throws GlideException {
    List<Throwable> list = (List)Preconditions.a(this.d.acquire());
    try {
      return a(paramDataRewinder, paramInt1, paramInt2, paramOptions, list);
    } finally {
      this.d.release(list);
    } 
  }
  
  private Resource<ResourceType> a(DataRewinder<DataType> paramDataRewinder, int paramInt1, int paramInt2, Options paramOptions, List<Throwable> paramList) throws GlideException {
    int j = this.b.size();
    Resource resource = null;
    int i = 0;
    while (true) {
      Resource resource1 = resource;
      if (i < j) {
        ResourceDecoder resourceDecoder = this.b.get(i);
        resource1 = resource;
        try {
          if (resourceDecoder.a(paramDataRewinder.a(), paramOptions))
            resource1 = resourceDecoder.a(paramDataRewinder.a(), paramInt1, paramInt2, paramOptions); 
        } catch (IOException iOException) {
          if (Log.isLoggable("DecodePath", 2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to decode data for ");
            stringBuilder.append(resourceDecoder);
            Log.v("DecodePath", stringBuilder.toString(), iOException);
          } 
          paramList.add(iOException);
          Resource resource2 = resource;
        } catch (RuntimeException runtimeException) {
        
        } catch (OutOfMemoryError outOfMemoryError) {}
        if (outOfMemoryError != null)
          break; 
        i++;
        OutOfMemoryError outOfMemoryError1 = outOfMemoryError;
        continue;
      } 
      break;
    } 
    if (outOfMemoryError != null)
      return (Resource<ResourceType>)outOfMemoryError; 
    throw new GlideException(this.e, new ArrayList(paramList));
  }
  
  public Resource<Transcode> a(DataRewinder<DataType> paramDataRewinder, int paramInt1, int paramInt2, Options paramOptions, DecodeCallback<ResourceType> paramDecodeCallback) throws GlideException {
    Resource<ResourceType> resource = paramDecodeCallback.a(a(paramDataRewinder, paramInt1, paramInt2, paramOptions));
    return this.c.a(resource, paramOptions);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("DecodePath{ dataClass=");
    stringBuilder.append(this.a);
    stringBuilder.append(", decoders=");
    stringBuilder.append(this.b);
    stringBuilder.append(", transcoder=");
    stringBuilder.append(this.c);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
  
  static interface DecodeCallback<ResourceType> {
    Resource<ResourceType> a(Resource<ResourceType> param1Resource);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\engine\DecodePath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */