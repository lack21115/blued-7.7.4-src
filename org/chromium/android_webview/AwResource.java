package org.chromium.android_webview;

import android.content.res.Resources;
import android.util.SparseArray;
import org.chromium.base.annotations.CalledByNative;

public class AwResource {
  private static Resources sResources;
  
  private static int sStringArrayConfigKeySystemUUIDMapping;
  
  @CalledByNative
  private static String[] getConfigKeySystemUuidMapping() {
    return sResources.getStringArray(sStringArrayConfigKeySystemUUIDMapping);
  }
  
  public static void setConfigKeySystemUuidMapping(int paramInt) {
    sStringArrayConfigKeySystemUUIDMapping = paramInt;
  }
  
  public static void setResources(Resources paramResources) {
    sResources = paramResources;
    new SparseArray();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwResource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */