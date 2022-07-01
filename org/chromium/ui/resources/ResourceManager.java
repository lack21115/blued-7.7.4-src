package org.chromium.ui.resources;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.SparseArray;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.ui.base.WindowAndroid;
import org.chromium.ui.display.DisplayAndroid;
import org.chromium.ui.resources.dynamics.DynamicResourceLoader;
import org.chromium.ui.resources.statics.StaticResourceLoader;
import org.chromium.ui.resources.system.SystemResourceLoader;

public class ResourceManager implements ResourceLoader$ResourceLoaderCallback {
  private final SparseArray mLoadedResources = new SparseArray();
  
  private long mNativeResourceManagerPtr;
  
  private final float mPxToDp;
  
  private final SparseArray mResourceLoaders = new SparseArray();
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private ResourceManager(Resources paramResources, int paramInt, long paramLong) {
    this.mPxToDp = 1.0F / (paramResources.getDisplayMetrics()).density;
    registerResourceLoader((ResourceLoader)new StaticResourceLoader(0, this, paramResources));
    registerResourceLoader((ResourceLoader)new DynamicResourceLoader(1, this));
    registerResourceLoader((ResourceLoader)new DynamicResourceLoader(2, this));
    registerResourceLoader((ResourceLoader)new SystemResourceLoader(3, this, paramInt));
    this.mNativeResourceManagerPtr = paramLong;
  }
  
  @CalledByNative
  private static ResourceManager create(WindowAndroid paramWindowAndroid, long paramLong) {
    Context context = paramWindowAndroid.getContext().get();
    if (context != null) {
      DisplayAndroid displayAndroid = paramWindowAndroid.mDisplayAndroid;
      int i = Math.min(displayAndroid.mSize.x, displayAndroid.mSize.y);
      return new ResourceManager(context.getResources(), i, paramLong);
    } 
    throw new IllegalStateException("Context should not be null during initialization.");
  }
  
  @CalledByNative
  private void destroy() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private long getNativePtr() {
    return this.mNativeResourceManagerPtr;
  }
  
  private native void nativeClearTintedResourceCache(long paramLong);
  
  private native void nativeOnResourceReady(long paramLong1, int paramInt1, int paramInt2, Bitmap paramBitmap, long paramLong2);
  
  private native void nativeRemoveResource(long paramLong, int paramInt1, int paramInt2);
  
  @CalledByNative
  private void preloadResource(int paramInt1, int paramInt2) {
    ResourceLoader resourceLoader = (ResourceLoader)this.mResourceLoaders.get(paramInt1);
    if (resourceLoader != null)
      resourceLoader.preloadResource(paramInt2); 
  }
  
  private void registerResourceLoader(ResourceLoader paramResourceLoader) {
    this.mResourceLoaders.put(paramResourceLoader.mResourceType, paramResourceLoader);
  }
  
  @CalledByNative
  private void resourceRequested(int paramInt1, int paramInt2) {
    ResourceLoader resourceLoader = (ResourceLoader)this.mResourceLoaders.get(paramInt1);
    if (resourceLoader != null)
      resourceLoader.loadResource(paramInt2); 
  }
  
  public final void onResourceLoaded(int paramInt1, int paramInt2, Resource paramResource) {
    if (paramResource != null) {
      if (paramResource.getBitmap() == null)
        return; 
      SparseArray sparseArray2 = (SparseArray)this.mLoadedResources.get(paramInt1);
      SparseArray sparseArray1 = sparseArray2;
      if (sparseArray2 == null) {
        sparseArray1 = new SparseArray();
        this.mLoadedResources.put(paramInt1, sparseArray1);
      } 
      sparseArray1.put(paramInt2, new LayoutResource(this.mPxToDp, paramResource));
      if (this.mNativeResourceManagerPtr == 0L)
        return; 
      nativeOnResourceReady(this.mNativeResourceManagerPtr, paramInt1, paramInt2, paramResource.getBitmap(), paramResource.createNativeResource());
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\resources\ResourceManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */