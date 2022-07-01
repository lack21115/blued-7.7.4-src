package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;
import java.util.Map;

class EngineKey implements Key {
  private final Object b;
  
  private final int c;
  
  private final int d;
  
  private final Class<?> e;
  
  private final Class<?> f;
  
  private final Key g;
  
  private final Map<Class<?>, Transformation<?>> h;
  
  private final Options i;
  
  private int j;
  
  EngineKey(Object paramObject, Key paramKey, int paramInt1, int paramInt2, Map<Class<?>, Transformation<?>> paramMap, Class<?> paramClass1, Class<?> paramClass2, Options paramOptions) {
    this.b = Preconditions.a(paramObject);
    this.g = (Key)Preconditions.a(paramKey, "Signature must not be null");
    this.c = paramInt1;
    this.d = paramInt2;
    this.h = (Map<Class<?>, Transformation<?>>)Preconditions.a(paramMap);
    this.e = (Class)Preconditions.a(paramClass1, "Resource class must not be null");
    this.f = (Class)Preconditions.a(paramClass2, "Transcode class must not be null");
    this.i = (Options)Preconditions.a(paramOptions);
  }
  
  public void a(MessageDigest paramMessageDigest) {
    throw new UnsupportedOperationException();
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = paramObject instanceof EngineKey;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool) {
      paramObject = paramObject;
      bool1 = bool2;
      if (this.b.equals(((EngineKey)paramObject).b)) {
        bool1 = bool2;
        if (this.g.equals(((EngineKey)paramObject).g)) {
          bool1 = bool2;
          if (this.d == ((EngineKey)paramObject).d) {
            bool1 = bool2;
            if (this.c == ((EngineKey)paramObject).c) {
              bool1 = bool2;
              if (this.h.equals(((EngineKey)paramObject).h)) {
                bool1 = bool2;
                if (this.e.equals(((EngineKey)paramObject).e)) {
                  bool1 = bool2;
                  if (this.f.equals(((EngineKey)paramObject).f)) {
                    bool1 = bool2;
                    if (this.i.equals(((EngineKey)paramObject).i))
                      bool1 = true; 
                  } 
                } 
              } 
            } 
          } 
        } 
      } 
    } 
    return bool1;
  }
  
  public int hashCode() {
    if (this.j == 0) {
      this.j = this.b.hashCode();
      this.j = this.j * 31 + this.g.hashCode();
      this.j = this.j * 31 + this.c;
      this.j = this.j * 31 + this.d;
      this.j = this.j * 31 + this.h.hashCode();
      this.j = this.j * 31 + this.e.hashCode();
      this.j = this.j * 31 + this.f.hashCode();
      this.j = this.j * 31 + this.i.hashCode();
    } 
    return this.j;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("EngineKey{model=");
    stringBuilder.append(this.b);
    stringBuilder.append(", width=");
    stringBuilder.append(this.c);
    stringBuilder.append(", height=");
    stringBuilder.append(this.d);
    stringBuilder.append(", resourceClass=");
    stringBuilder.append(this.e);
    stringBuilder.append(", transcodeClass=");
    stringBuilder.append(this.f);
    stringBuilder.append(", signature=");
    stringBuilder.append(this.g);
    stringBuilder.append(", hashCode=");
    stringBuilder.append(this.j);
    stringBuilder.append(", transformations=");
    stringBuilder.append(this.h);
    stringBuilder.append(", options=");
    stringBuilder.append(this.i);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\engine\EngineKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */