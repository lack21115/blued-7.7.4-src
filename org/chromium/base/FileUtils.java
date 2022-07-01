package org.chromium.base;

import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public final class FileUtils {
  public static void copyFileStreamAtomicWithBuffer(InputStream paramInputStream, File paramFile, byte[] paramArrayOfbyte) {
    Throwable throwable;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramFile.getPath());
    stringBuilder1.append(".tmp");
    File file = new File(stringBuilder1.toString());
    FileOutputStream fileOutputStream = new FileOutputStream(file);
    StringBuilder stringBuilder2 = null;
    stringBuilder1 = stringBuilder2;
    try {
      Log.i("FileUtils", "Writing to %s", new Object[] { paramFile });
      while (true) {
        stringBuilder1 = stringBuilder2;
        int i = paramInputStream.read(paramArrayOfbyte, 0, paramArrayOfbyte.length);
        if (i != -1) {
          stringBuilder1 = stringBuilder2;
          fileOutputStream.write(paramArrayOfbyte, 0, i);
          continue;
        } 
        fileOutputStream.close();
        if (file.renameTo(paramFile))
          return; 
        throw new IOException();
      } 
    } catch (Throwable throwable1) {
      throwable = throwable1;
      throw throwable1;
    } finally {}
    if (throwable != null) {
      try {
        fileOutputStream.close();
      } catch (Throwable throwable1) {
        ThrowableExtension.addSuppressed(throwable, throwable1);
      } 
    } else {
      fileOutputStream.close();
    } 
    throw paramInputStream;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\FileUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */