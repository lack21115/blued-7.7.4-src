package org.chromium.ui.resources;

public abstract class ResourceLoader {
  private final ResourceLoader$ResourceLoaderCallback mCallback;
  
  final int mResourceType;
  
  public ResourceLoader(int paramInt, ResourceLoader$ResourceLoaderCallback paramResourceLoader$ResourceLoaderCallback) {
    this.mResourceType = paramInt;
    this.mCallback = paramResourceLoader$ResourceLoaderCallback;
  }
  
  public abstract void loadResource(int paramInt);
  
  public final void notifyLoadFinished(int paramInt, Resource paramResource) {
    if (this.mCallback != null)
      this.mCallback.onResourceLoaded(this.mResourceType, paramInt, paramResource); 
  }
  
  public abstract void preloadResource(int paramInt);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\resources\ResourceLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */