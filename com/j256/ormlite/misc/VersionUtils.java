package com.j256.ormlite.misc;

import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;

public class VersionUtils {
  private static final String CORE_VERSION = "VERSION__4.48__";
  
  private static String coreVersion = "VERSION__4.48__";
  
  private static Logger logger;
  
  private static boolean thrownOnErrors = false;
  
  public static final void checkCoreVersusAndroidVersions(String paramString) {
    logVersionWarnings("core", coreVersion, "android", paramString);
  }
  
  public static final void checkCoreVersusJdbcVersions(String paramString) {
    logVersionWarnings("core", coreVersion, "jdbc", paramString);
  }
  
  public static String getCoreVersion() {
    return coreVersion;
  }
  
  private static Logger getLogger() {
    if (logger == null)
      logger = LoggerFactory.getLogger(VersionUtils.class); 
    return logger;
  }
  
  private static void logVersionWarnings(String paramString1, String paramString2, String paramString3, String paramString4) {
    if (paramString2 == null) {
      if (paramString4 != null) {
        warning(null, "Unknown version", " for {}, version for {} is '{}'", new Object[] { paramString1, paramString3, paramString4 });
        return;
      } 
    } else {
      if (paramString4 == null) {
        warning(null, "Unknown version", " for {}, version for {} is '{}'", new Object[] { paramString3, paramString1, paramString2 });
        return;
      } 
      if (!paramString2.equals(paramString4))
        warning(null, "Mismatched versions", ": {} is '{}', while {} is '{}'", new Object[] { paramString1, paramString2, paramString3, paramString4 }); 
    } 
  }
  
  static void setThrownOnErrors(boolean paramBoolean) {
    thrownOnErrors = paramBoolean;
  }
  
  private static void warning(Throwable paramThrowable, String paramString1, String paramString2, Object[] paramArrayOfObject) {
    Logger logger = getLogger();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramString1);
    stringBuilder2.append(paramString2);
    logger.warn(paramThrowable, stringBuilder2.toString(), paramArrayOfObject);
    if (!thrownOnErrors)
      return; 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("See error log for details:");
    stringBuilder1.append(paramString1);
    throw new IllegalStateException(stringBuilder1.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\misc\VersionUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */