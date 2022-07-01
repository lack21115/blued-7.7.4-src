package org.chromium.ui.base;

import java.util.Arrays;
import org.chromium.base.BuildConfig;
import org.chromium.base.annotations.CalledByNative;

final class ResourceBundle {
  @CalledByNative
  private static String getLocalePakResourcePath(String paramString) {
    if (Arrays.binarySearch((Object[])BuildConfig.UNCOMPRESSED_LOCALES, paramString) >= 0) {
      StringBuilder stringBuilder = new StringBuilder("assets/stored-locales/");
      stringBuilder.append(paramString);
      stringBuilder.append(".pak");
      return stringBuilder.toString();
    } 
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\base\ResourceBundle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */