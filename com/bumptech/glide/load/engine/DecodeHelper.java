package com.bumptech.glide.load.engine;

import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.UnitTransformation;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class DecodeHelper<Transcode> {
  private final List<ModelLoader.LoadData<?>> a = new ArrayList<ModelLoader.LoadData<?>>();
  
  private final List<Key> b = new ArrayList<Key>();
  
  private GlideContext c;
  
  private Object d;
  
  private int e;
  
  private int f;
  
  private Class<?> g;
  
  private DecodeJob.DiskCacheProvider h;
  
  private Options i;
  
  private Map<Class<?>, Transformation<?>> j;
  
  private Class<Transcode> k;
  
  private boolean l;
  
  private boolean m;
  
  private Key n;
  
  private Priority o;
  
  private DiskCacheStrategy p;
  
  private boolean q;
  
  private boolean r;
  
  <X> Encoder<X> a(X paramX) throws Registry.NoSourceEncoderAvailableException {
    return this.c.d().a(paramX);
  }
  
  List<ModelLoader<File, ?>> a(File paramFile) throws Registry.NoModelLoaderAvailableException {
    return this.c.d().c(paramFile);
  }
  
  void a() {
    this.c = null;
    this.d = null;
    this.n = null;
    this.g = null;
    this.k = null;
    this.i = null;
    this.o = null;
    this.j = null;
    this.p = null;
    this.a.clear();
    this.l = false;
    this.b.clear();
    this.m = false;
  }
  
  <R> void a(GlideContext paramGlideContext, Object paramObject, Key paramKey, int paramInt1, int paramInt2, DiskCacheStrategy paramDiskCacheStrategy, Class<?> paramClass, Class<R> paramClass1, Priority paramPriority, Options paramOptions, Map<Class<?>, Transformation<?>> paramMap, boolean paramBoolean1, boolean paramBoolean2, DecodeJob.DiskCacheProvider paramDiskCacheProvider) {
    this.c = paramGlideContext;
    this.d = paramObject;
    this.n = paramKey;
    this.e = paramInt1;
    this.f = paramInt2;
    this.p = paramDiskCacheStrategy;
    this.g = paramClass;
    this.h = paramDiskCacheProvider;
    this.k = paramClass1;
    this.o = paramPriority;
    this.i = paramOptions;
    this.j = paramMap;
    this.q = paramBoolean1;
    this.r = paramBoolean2;
  }
  
  boolean a(Key paramKey) {
    List<ModelLoader.LoadData<?>> list = n();
    int j = list.size();
    for (int i = 0; i < j; i++) {
      if (((ModelLoader.LoadData)list.get(i)).a.equals(paramKey))
        return true; 
    } 
    return false;
  }
  
  boolean a(Resource<?> paramResource) {
    return this.c.d().a(paramResource);
  }
  
  boolean a(Class<?> paramClass) {
    return (b(paramClass) != null);
  }
  
  <Z> ResourceEncoder<Z> b(Resource<Z> paramResource) {
    return this.c.d().b(paramResource);
  }
  
  <Data> LoadPath<Data, ?, Transcode> b(Class<Data> paramClass) {
    return this.c.d().a(paramClass, this.g, this.k);
  }
  
  DiskCache b() {
    return this.h.a();
  }
  
  <Z> Transformation<Z> c(Class<Z> paramClass) {
    StringBuilder stringBuilder;
    Transformation transformation2 = this.j.get(paramClass);
    Transformation transformation1 = transformation2;
    if (transformation2 == null) {
      Iterator<Map.Entry> iterator = this.j.entrySet().iterator();
      while (true) {
        transformation1 = transformation2;
        if (iterator.hasNext()) {
          Map.Entry entry = iterator.next();
          if (((Class)entry.getKey()).isAssignableFrom(paramClass)) {
            transformation1 = (Transformation)entry.getValue();
            break;
          } 
          continue;
        } 
        break;
      } 
    } 
    if (transformation1 == null) {
      if (!this.j.isEmpty() || !this.q)
        return (Transformation<Z>)UnitTransformation.a(); 
      stringBuilder = new StringBuilder();
      stringBuilder.append("Missing transformation for ");
      stringBuilder.append(paramClass);
      stringBuilder.append(". If you wish to ignore unknown resource types, use the optional transformation methods.");
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    return (Transformation<Z>)stringBuilder;
  }
  
  DiskCacheStrategy c() {
    return this.p;
  }
  
  Priority d() {
    return this.o;
  }
  
  Options e() {
    return this.i;
  }
  
  Key f() {
    return this.n;
  }
  
  int g() {
    return this.e;
  }
  
  int h() {
    return this.f;
  }
  
  ArrayPool i() {
    return this.c.f();
  }
  
  Class<?> j() {
    return this.k;
  }
  
  Class<?> k() {
    return this.d.getClass();
  }
  
  List<Class<?>> l() {
    return this.c.d().b(this.d.getClass(), this.g, this.k);
  }
  
  boolean m() {
    return this.r;
  }
  
  List<ModelLoader.LoadData<?>> n() {
    if (!this.l) {
      this.l = true;
      this.a.clear();
      List<ModelLoader> list = this.c.d().c(this.d);
      int i = 0;
      int j = list.size();
      while (i < j) {
        ModelLoader.LoadData<?> loadData = ((ModelLoader)list.get(i)).a(this.d, this.e, this.f, this.i);
        if (loadData != null)
          this.a.add(loadData); 
        i++;
      } 
    } 
    return this.a;
  }
  
  List<Key> o() {
    if (!this.m) {
      this.m = true;
      this.b.clear();
      List<ModelLoader.LoadData<?>> list = n();
      int j = list.size();
      for (int i = 0; i < j; i++) {
        ModelLoader.LoadData loadData = list.get(i);
        if (!this.b.contains(loadData.a))
          this.b.add(loadData.a); 
        for (int k = 0; k < loadData.b.size(); k++) {
          if (!this.b.contains(loadData.b.get(k)))
            this.b.add(loadData.b.get(k)); 
        } 
      } 
    } 
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\engine\DecodeHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */