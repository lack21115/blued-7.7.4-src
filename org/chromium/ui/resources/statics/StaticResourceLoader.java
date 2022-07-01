package org.chromium.ui.resources.statics;

import android.content.res.Resources;
import org.chromium.ui.resources.ResourceLoader;
import org.chromium.ui.resources.async.AsyncPreloadResourceLoader;

public final class StaticResourceLoader extends AsyncPreloadResourceLoader {
  public StaticResourceLoader(int paramInt, ResourceLoader.ResourceLoaderCallback paramResourceLoaderCallback, Resources paramResources) {
    super(paramInt, paramResourceLoaderCallback, new StaticResourceLoader$1(paramResources));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\resources\statics\StaticResourceLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */