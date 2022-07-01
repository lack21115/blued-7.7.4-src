package org.chromium.base;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Environment;
import android.os.SystemClock;
import android.system.Os;
import android.text.TextUtils;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.metrics.RecordHistogram;

public abstract class PathUtils {
  private static String sCacheSubDirectory;
  
  private static String sDataDirectorySuffix;
  
  private static AsyncTask sDirPathFetchTask;
  
  private static final AtomicBoolean sInitializationStarted;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  @CalledByNative
  public static String[] getAllPrivateDownloadsDirectories() {
    File[] arrayOfFile;
    int j = Build.VERSION.SDK_INT;
    int i = 0;
    if (j >= 19) {
      StrictModeContext strictModeContext = StrictModeContext.allowDiskWrites();
      arrayOfFile = null;
      try {
        File[] arrayOfFile1 = ContextUtils.sApplicationContext.getExternalFilesDirs(Environment.DIRECTORY_DOWNLOADS);
        arrayOfFile = arrayOfFile1;
        if (strictModeContext != null) {
          $closeResource(null, strictModeContext);
          arrayOfFile = arrayOfFile1;
        } 
      } catch (Throwable throwable2) {
        Throwable throwable1 = throwable2;
        throw throwable2;
      } finally {
        Exception exception;
      } 
    } else {
      arrayOfFile = new File[1];
      arrayOfFile[0] = Environment.getExternalStorageDirectory();
    } 
    ArrayList<String> arrayList = new ArrayList();
    while (i < arrayOfFile.length) {
      if (arrayOfFile[i] != null && !TextUtils.isEmpty(arrayOfFile[i].getAbsolutePath()))
        arrayList.add(arrayOfFile[i].getAbsolutePath()); 
      i++;
    } 
    return arrayList.<String>toArray(new String[arrayList.size()]);
  }
  
  @CalledByNative
  public static String getCacheDirectory() {
    assert false;
    throw new AssertionError("setDataDirectorySuffix must be called first.");
  }
  
  @CalledByNative
  public static String getDataDirectory() {
    assert false;
    throw new AssertionError("setDataDirectorySuffix must be called first.");
  }
  
  @CalledByNative
  private static String getDownloadsDirectory() {
    StrictModeContext strictModeContext = StrictModeContext.allowDiskReads();
    Throwable throwable2 = null;
    Throwable throwable1 = throwable2;
    try {
      long l = SystemClock.elapsedRealtime();
      throwable1 = throwable2;
      String str = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
      throwable1 = throwable2;
      RecordHistogram.recordTimesHistogram("Android.StrictMode.DownloadsDir", SystemClock.elapsedRealtime() - l, TimeUnit.MILLISECONDS);
      if (strictModeContext != null)
        $closeResource(null, strictModeContext); 
      return str;
    } catch (Throwable throwable) {
      throwable1 = throwable;
      throw throwable;
    } finally {}
    if (strictModeContext != null)
      $closeResource(throwable1, strictModeContext); 
    throw throwable2;
  }
  
  @CalledByNative
  public static String getExternalStorageDirectory() {
    return Environment.getExternalStorageDirectory().getAbsolutePath();
  }
  
  @CalledByNative
  private static String getNativeLibraryDirectory() {
    ApplicationInfo applicationInfo = ContextUtils.sApplicationContext.getApplicationInfo();
    return ((applicationInfo.flags & 0x80) != 0 || (applicationInfo.flags & 0x1) == 0) ? applicationInfo.nativeLibraryDir : "/system/lib/";
  }
  
  private static String[] getOrComputeDirectoryPaths() {
    try {
      if (sDirPathFetchTask.cancel(false)) {
        Throwable throwable;
        Exception exception;
        StrictModeContext strictModeContext = StrictModeContext.allowDiskWrites();
        try {
          throwable = (Throwable)setPrivateDataDirectorySuffixInternal();
          return (String[])throwable;
        } catch (Throwable null) {
          try {
            throw throwable;
          } finally {}
        } finally {
          exception = null;
        } 
        if (strictModeContext != null)
          $closeResource(throwable, strictModeContext); 
        throw exception;
      } 
      return sDirPathFetchTask.mFuture.get();
    } catch (InterruptedException interruptedException) {
      return null;
    } catch (ExecutionException executionException) {
      return null;
    } 
  }
  
  @CalledByNative
  public static String getThumbnailCacheDirectory() {
    assert false;
    throw new AssertionError("setDataDirectorySuffix must be called first.");
  }
  
  public static void setPrivateDataDirectorySuffix(String paramString) {
    setPrivateDataDirectorySuffix(paramString, null);
  }
  
  public static void setPrivateDataDirectorySuffix(String paramString1, String paramString2) {
    if (!sInitializationStarted.getAndSet(true)) {
      assert false;
      throw new AssertionError();
    } 
  }
  
  private static String[] setPrivateDataDirectorySuffixInternal() {
    String[] arrayOfString = new String[3];
    Context context = ContextUtils.sApplicationContext;
    arrayOfString[0] = context.getDir(sDataDirectorySuffix, 0).getPath();
    String str = arrayOfString[0];
    if (Build.VERSION.SDK_INT >= 21)
      try {
        Os.chmod(str, 448);
      } catch (Exception exception) {
        StringBuilder stringBuilder = new StringBuilder("Failed to set permissions for path \"");
        stringBuilder.append(str);
        stringBuilder.append("\"");
        Log.e("PathUtils", stringBuilder.toString(), new Object[0]);
      }  
    arrayOfString[1] = context.getDir("textures", 0).getPath();
    if (context.getCacheDir() != null) {
      if (sCacheSubDirectory == null) {
        arrayOfString[2] = context.getCacheDir().getPath();
        return arrayOfString;
      } 
      arrayOfString[2] = (new File(context.getCacheDir(), sCacheSubDirectory)).getPath();
    } 
    return arrayOfString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\PathUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */