package org.chromium.components.minidump_uploader;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

final class CrashFileManager$2 implements FilenameFilter {
  public final boolean accept(File paramFile, String paramString) {
    return pattern.matcher(paramString).find();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\components\minidump_uploader\CrashFileManager$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */