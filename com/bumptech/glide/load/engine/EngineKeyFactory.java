package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import java.util.Map;

class EngineKeyFactory {
  EngineKey a(Object paramObject, Key paramKey, int paramInt1, int paramInt2, Map<Class<?>, Transformation<?>> paramMap, Class<?> paramClass1, Class<?> paramClass2, Options paramOptions) {
    return new EngineKey(paramObject, paramKey, paramInt1, paramInt2, paramMap, paramClass1, paramClass2, paramOptions);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\engine\EngineKeyFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */