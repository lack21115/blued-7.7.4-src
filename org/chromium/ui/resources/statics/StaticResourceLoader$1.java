package org.chromium.ui.resources.statics;

import android.content.res.Resources;
import org.chromium.ui.resources.Resource;
import org.chromium.ui.resources.async.AsyncPreloadResourceLoader;

final class StaticResourceLoader$1 implements AsyncPreloadResourceLoader.ResourceCreator {
  public final Resource create(int paramInt) {
    return StaticResource.create(resources, paramInt, 0, 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\resources\statics\StaticResourceLoader$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */