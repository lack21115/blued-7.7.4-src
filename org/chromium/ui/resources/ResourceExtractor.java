package org.chromium.ui.resources;

import android.content.res.AssetManager;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import org.chromium.base.BuildConfig;
import org.chromium.base.ContextUtils;
import org.chromium.base.LocaleUtils;
import org.chromium.base.Log;
import org.chromium.base.PathUtils;
import org.chromium.ui.base.LocalizationUtils;

public class ResourceExtractor {
  private static ResourceExtractor sInstance;
  
  public ResourceExtractor$ExtractTask mExtractTask;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private static boolean assetPathHasFile(AssetManager paramAssetManager, String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString1);
    stringBuilder.append('/');
    stringBuilder.append(paramString2);
    paramString1 = stringBuilder.toString();
    try {
      paramAssetManager.open(paramString1).close();
      StringBuilder stringBuilder1 = new StringBuilder("Found asset file: ");
      stringBuilder1.append(paramString1);
      Log.i("ui", stringBuilder1.toString(), new Object[0]);
      return true;
    } catch (IOException iOException) {
      StringBuilder stringBuilder1 = new StringBuilder("Missing asset file: ");
      stringBuilder1.append(paramString1);
      Log.i("ui", stringBuilder1.toString(), new Object[0]);
      return false;
    } 
  }
  
  private static void deleteFile(File paramFile) {
    if (paramFile.exists() && !paramFile.delete())
      Log.w("ui", "Unable to remove %s", new Object[] { paramFile.getName() }); 
  }
  
  public static ResourceExtractor get() {
    if (sInstance == null)
      sInstance = new ResourceExtractor(); 
    return sInstance;
  }
  
  private static File getAppDataDir() {
    return new File(PathUtils.getDataDirectory());
  }
  
  private static File getOutputDir() {
    return new File(getAppDataDir(), "paks");
  }
  
  public static boolean shouldSkipPakExtraction() {
    return (BuildConfig.COMPRESSED_LOCALES.length == 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\resources\ResourceExtractor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */