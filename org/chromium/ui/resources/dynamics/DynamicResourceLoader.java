package org.chromium.ui.resources.dynamics;

import android.util.SparseArray;
import org.chromium.ui.resources.ResourceLoader;

public class DynamicResourceLoader extends ResourceLoader {
  private final SparseArray mDynamicResources = new SparseArray();
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public DynamicResourceLoader(int paramInt, ResourceLoader.ResourceLoaderCallback paramResourceLoaderCallback) {
    super(paramInt, paramResourceLoaderCallback);
  }
  
  public final void loadResource(int paramInt) {
    DynamicResource dynamicResource = (DynamicResource)this.mDynamicResources.get(paramInt);
    if (dynamicResource == null)
      return; 
    if (dynamicResource.isDirty())
      notifyLoadFinished(paramInt, dynamicResource); 
  }
  
  public final void preloadResource(int paramInt) {
    assert false;
    throw new AssertionError("Preloading dynamic resources isn't supported.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\resources\dynamics\DynamicResourceLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */