package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.common.Util;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.Nullable;

public final class DescriptorMap implements DescriptorRegistrar {
  private Descriptor.Host mHost;
  
  private boolean mIsInitializing;
  
  private final Map<Class<?>, Descriptor> mMap = new IdentityHashMap<Class<?>, Descriptor>();
  
  @Nullable
  private Descriptor getImpl(Class<?> paramClass) {
    while (paramClass != null) {
      Descriptor descriptor = this.mMap.get(paramClass);
      if (descriptor != null)
        return descriptor; 
      paramClass = paramClass.getSuperclass();
    } 
    return null;
  }
  
  public DescriptorMap beginInit() {
    Util.throwIf(this.mIsInitializing);
    this.mIsInitializing = true;
    return this;
  }
  
  public DescriptorMap endInit() {
    Util.throwIfNot(this.mIsInitializing);
    Util.throwIfNull(this.mHost);
    this.mIsInitializing = false;
    for (Class<?> clazz : this.mMap.keySet()) {
      Descriptor descriptor = this.mMap.get(clazz);
      if (descriptor instanceof ChainedDescriptor)
        ((ChainedDescriptor)descriptor).setSuper(getImpl(clazz.getSuperclass())); 
      descriptor.initialize(this.mHost);
    } 
    return this;
  }
  
  @Nullable
  public Descriptor get(Class<?> paramClass) {
    Util.throwIfNull(paramClass);
    Util.throwIf(this.mIsInitializing);
    return getImpl(paramClass);
  }
  
  public DescriptorMap registerDescriptor(Class<?> paramClass, Descriptor paramDescriptor) {
    Util.throwIfNull(paramClass);
    Util.throwIfNull(paramDescriptor);
    Util.throwIf(paramDescriptor.isInitialized());
    Util.throwIfNot(this.mIsInitializing);
    if (!this.mMap.containsKey(paramClass)) {
      if (!this.mMap.containsValue(paramDescriptor)) {
        this.mMap.put(paramClass, paramDescriptor);
        return this;
      } 
      throw new UnsupportedOperationException();
    } 
    throw new UnsupportedOperationException();
  }
  
  public DescriptorMap setHost(Descriptor.Host paramHost) {
    Util.throwIfNull(paramHost);
    Util.throwIfNot(this.mIsInitializing);
    Util.throwIfNotNull(this.mHost);
    this.mHost = paramHost;
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\elements\DescriptorMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */