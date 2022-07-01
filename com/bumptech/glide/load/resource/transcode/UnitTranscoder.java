package com.bumptech.glide.load.resource.transcode;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;

public class UnitTranscoder<Z> implements ResourceTranscoder<Z, Z> {
  private static final UnitTranscoder<?> a = new UnitTranscoder();
  
  public static <Z> ResourceTranscoder<Z, Z> a() {
    return (ResourceTranscoder)a;
  }
  
  public Resource<Z> a(Resource<Z> paramResource, Options paramOptions) {
    return paramResource;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\transcode\UnitTranscoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */