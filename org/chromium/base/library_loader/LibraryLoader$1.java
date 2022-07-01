package org.chromium.base.library_loader;

import java.io.File;
import org.chromium.base.BuildInfo;
import org.chromium.base.Log;

final class LibraryLoader$1 implements Runnable {
  public final void run() {
    String str = (BuildInfo.getInstance()).extractedFileSuffix;
    File[] arrayOfFile = LibraryLoader.access$200().listFiles();
    if (arrayOfFile == null)
      return; 
    int j = arrayOfFile.length;
    for (int i = 0; i < j; i++) {
      File file = arrayOfFile[i];
      if (!file.getName().contains(str)) {
        String str1 = file.getName();
        if (!file.delete()) {
          Log.w("LibraryLoader", "Unable to remove %s", new Object[] { str1 });
        } else {
          Log.i("LibraryLoader", "Removed obsolete file %s", new Object[] { str1 });
        } 
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\library_loader\LibraryLoader$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */