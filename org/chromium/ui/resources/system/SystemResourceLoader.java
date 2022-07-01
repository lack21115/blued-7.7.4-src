package org.chromium.ui.resources.system;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import org.chromium.build.BuildHooksAndroid;
import org.chromium.ui.resources.Resource;
import org.chromium.ui.resources.ResourceLoader;
import org.chromium.ui.resources.async.AsyncPreloadResourceLoader;
import org.chromium.ui.resources.statics.StaticResource;

public class SystemResourceLoader extends AsyncPreloadResourceLoader {
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public SystemResourceLoader(int paramInt1, ResourceLoader.ResourceLoaderCallback paramResourceLoaderCallback, int paramInt2) {
    super(paramInt1, paramResourceLoaderCallback, new SystemResourceLoader$1(paramInt2));
  }
  
  private static int getResourceId(String paramString) {
    return BuildHooksAndroid.getIdentifier(Resources.getSystem(), paramString, null, null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\resources\system\SystemResourceLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */