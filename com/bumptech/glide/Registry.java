package com.bumptech.glide;

import androidx.core.util.Pools;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.data.DataRewinderRegistry;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.LoadPath;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.ModelLoaderRegistry;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.resource.transcode.TranscoderRegistry;
import com.bumptech.glide.provider.EncoderRegistry;
import com.bumptech.glide.provider.ImageHeaderParserRegistry;
import com.bumptech.glide.provider.LoadPathCache;
import com.bumptech.glide.provider.ModelToResourceClassCache;
import com.bumptech.glide.provider.ResourceDecoderRegistry;
import com.bumptech.glide.provider.ResourceEncoderRegistry;
import com.bumptech.glide.util.pool.FactoryPools;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Registry {
  private final ModelLoaderRegistry a = new ModelLoaderRegistry(this.j);
  
  private final EncoderRegistry b = new EncoderRegistry();
  
  private final ResourceDecoderRegistry c = new ResourceDecoderRegistry();
  
  private final ResourceEncoderRegistry d = new ResourceEncoderRegistry();
  
  private final DataRewinderRegistry e = new DataRewinderRegistry();
  
  private final TranscoderRegistry f = new TranscoderRegistry();
  
  private final ImageHeaderParserRegistry g = new ImageHeaderParserRegistry();
  
  private final ModelToResourceClassCache h = new ModelToResourceClassCache();
  
  private final LoadPathCache i = new LoadPathCache();
  
  private final Pools.Pool<List<Throwable>> j = FactoryPools.a();
  
  public Registry() {
    a(Arrays.asList(new String[] { "Gif", "Bitmap", "BitmapDrawable" }));
  }
  
  private <Data, TResource, Transcode> List<DecodePath<Data, TResource, Transcode>> c(Class<Data> paramClass, Class<TResource> paramClass1, Class<Transcode> paramClass2) {
    ArrayList<DecodePath> arrayList = new ArrayList();
    for (Class clazz : this.c.b(paramClass, paramClass1)) {
      for (Class clazz1 : this.f.b(clazz, paramClass2))
        arrayList.add(new DecodePath(paramClass, clazz, clazz1, this.c.a(paramClass, clazz), this.f.a(clazz, clazz1), this.j)); 
    } 
    return (List)arrayList;
  }
  
  public Registry a(ImageHeaderParser paramImageHeaderParser) {
    this.g.a(paramImageHeaderParser);
    return this;
  }
  
  public Registry a(DataRewinder.Factory<?> paramFactory) {
    this.e.a(paramFactory);
    return this;
  }
  
  public <Data> Registry a(Class<Data> paramClass, Encoder<Data> paramEncoder) {
    this.b.a(paramClass, paramEncoder);
    return this;
  }
  
  public <TResource> Registry a(Class<TResource> paramClass, ResourceEncoder<TResource> paramResourceEncoder) {
    this.d.a(paramClass, paramResourceEncoder);
    return this;
  }
  
  public <Data, TResource> Registry a(Class<Data> paramClass, Class<TResource> paramClass1, ResourceDecoder<Data, TResource> paramResourceDecoder) {
    a("legacy_append", paramClass, paramClass1, paramResourceDecoder);
    return this;
  }
  
  public <Model, Data> Registry a(Class<Model> paramClass, Class<Data> paramClass1, ModelLoaderFactory<Model, Data> paramModelLoaderFactory) {
    this.a.a(paramClass, paramClass1, paramModelLoaderFactory);
    return this;
  }
  
  public <TResource, Transcode> Registry a(Class<TResource> paramClass, Class<Transcode> paramClass1, ResourceTranscoder<TResource, Transcode> paramResourceTranscoder) {
    this.f.a(paramClass, paramClass1, paramResourceTranscoder);
    return this;
  }
  
  public <Data, TResource> Registry a(String paramString, Class<Data> paramClass, Class<TResource> paramClass1, ResourceDecoder<Data, TResource> paramResourceDecoder) {
    this.c.a(paramString, paramResourceDecoder, paramClass, paramClass1);
    return this;
  }
  
  public final Registry a(List<String> paramList) {
    ArrayList<String> arrayList = new ArrayList(paramList.size());
    arrayList.addAll(paramList);
    arrayList.add(0, "legacy_prepend_all");
    arrayList.add("legacy_append");
    this.c.a(arrayList);
    return this;
  }
  
  public <X> Encoder<X> a(X paramX) throws NoSourceEncoderAvailableException {
    Encoder<X> encoder = this.b.a(paramX.getClass());
    if (encoder != null)
      return encoder; 
    throw new NoSourceEncoderAvailableException(paramX.getClass());
  }
  
  public <Data, TResource, Transcode> LoadPath<Data, TResource, Transcode> a(Class<Data> paramClass, Class<TResource> paramClass1, Class<Transcode> paramClass2) {
    LoadPath loadPath1 = this.i.a(paramClass, paramClass1, paramClass2);
    if (this.i.a(loadPath1))
      return null; 
    LoadPath<Data, TResource, Transcode> loadPath = loadPath1;
    if (loadPath1 == null) {
      List<DecodePath<Data, TResource, Transcode>> list = c(paramClass, paramClass1, paramClass2);
      if (list.isEmpty()) {
        list = null;
      } else {
        loadPath = new LoadPath(paramClass, paramClass1, paramClass2, list, this.j);
      } 
      this.i.a(paramClass, paramClass1, paramClass2, loadPath);
    } 
    return loadPath;
  }
  
  public List<ImageHeaderParser> a() {
    List<ImageHeaderParser> list = this.g.a();
    if (!list.isEmpty())
      return list; 
    throw new NoImageHeaderParserException();
  }
  
  public boolean a(Resource<?> paramResource) {
    return (this.d.a(paramResource.a()) != null);
  }
  
  public <Data, TResource> Registry b(Class<Data> paramClass, Class<TResource> paramClass1, ResourceDecoder<Data, TResource> paramResourceDecoder) {
    b("legacy_prepend_all", paramClass, paramClass1, paramResourceDecoder);
    return this;
  }
  
  public <Model, Data> Registry b(Class<Model> paramClass, Class<Data> paramClass1, ModelLoaderFactory<? extends Model, ? extends Data> paramModelLoaderFactory) {
    this.a.b(paramClass, paramClass1, paramModelLoaderFactory);
    return this;
  }
  
  public <Data, TResource> Registry b(String paramString, Class<Data> paramClass, Class<TResource> paramClass1, ResourceDecoder<Data, TResource> paramResourceDecoder) {
    this.c.b(paramString, paramResourceDecoder, paramClass, paramClass1);
    return this;
  }
  
  public <X> ResourceEncoder<X> b(Resource<X> paramResource) throws NoResultEncoderAvailableException {
    ResourceEncoder<X> resourceEncoder = this.d.a(paramResource.a());
    if (resourceEncoder != null)
      return resourceEncoder; 
    throw new NoResultEncoderAvailableException(paramResource.a());
  }
  
  public <X> DataRewinder<X> b(X paramX) {
    return this.e.a(paramX);
  }
  
  public <Model, TResource, Transcode> List<Class<?>> b(Class<Model> paramClass, Class<TResource> paramClass1, Class<Transcode> paramClass2) {
    List<Class<?>> list2 = this.h.a(paramClass, paramClass1, paramClass2);
    List<Class<?>> list1 = list2;
    if (list2 == null) {
      list1 = new ArrayList();
      for (Class clazz : this.a.a(paramClass)) {
        for (Class<?> clazz1 : (Iterable<Class<?>>)this.c.b(clazz, paramClass1)) {
          if (!this.f.b(clazz1, paramClass2).isEmpty() && !list1.contains(clazz1))
            list1.add(clazz1); 
        } 
      } 
      this.h.a(paramClass, paramClass1, paramClass2, Collections.unmodifiableList(list1));
    } 
    return list1;
  }
  
  public <Model> List<ModelLoader<Model, ?>> c(Model paramModel) {
    return this.a.a(paramModel);
  }
  
  public static class MissingComponentException extends RuntimeException {
    public MissingComponentException(String param1String) {
      super(param1String);
    }
  }
  
  public static final class NoImageHeaderParserException extends MissingComponentException {
    public NoImageHeaderParserException() {
      super("Failed to find image header parser.");
    }
  }
  
  public static class NoModelLoaderAvailableException extends MissingComponentException {
    public NoModelLoaderAvailableException(Class<?> param1Class1, Class<?> param1Class2) {
      super(stringBuilder.toString());
    }
    
    public NoModelLoaderAvailableException(Object param1Object) {
      super(stringBuilder.toString());
    }
    
    public <M> NoModelLoaderAvailableException(M param1M, List<ModelLoader<M, ?>> param1List) {
      super(stringBuilder.toString());
    }
  }
  
  public static class NoResultEncoderAvailableException extends MissingComponentException {
    public NoResultEncoderAvailableException(Class<?> param1Class) {
      super(stringBuilder.toString());
    }
  }
  
  public static class NoSourceEncoderAvailableException extends MissingComponentException {
    public NoSourceEncoderAvailableException(Class<?> param1Class) {
      super(stringBuilder.toString());
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\Registry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */