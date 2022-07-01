package org.chromium.android_webview.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import java.io.File;
import java.io.IOException;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.build.BuildHooksAndroid;
import org.chromium.components.minidump_uploader.CrashFileManager;

public class CrashReceiverService extends Service {
  private final ICrashReceiverService$Stub mBinder = new CrashReceiverService$1(this);
  
  final Object mCopyingLock = new Object();
  
  boolean mIsCopying = false;
  
  public static boolean copyMinidumps(int paramInt, ParcelFileDescriptor[] paramArrayOfParcelFileDescriptor) {
    File file = getWebViewCrashDir();
    if (!file.mkdir() && !file.isDirectory())
      file = null; 
    CrashFileManager crashFileManager = new CrashFileManager(file);
    boolean bool = false;
    if (paramArrayOfParcelFileDescriptor != null) {
      int j = paramArrayOfParcelFileDescriptor.length;
      int i = 0;
      for (bool = false; i < j; bool = bool1) {
        ParcelFileDescriptor parcelFileDescriptor = paramArrayOfParcelFileDescriptor[i];
        boolean bool1 = bool;
        if (parcelFileDescriptor != null)
          try {
            if (crashFileManager.copyMinidumpFromFD(parcelFileDescriptor.getFileDescriptor(), getWebViewTmpCrashDir(), paramInt) == null) {
              StringBuilder stringBuilder = new StringBuilder("failed to copy minidump from ");
              stringBuilder.append(parcelFileDescriptor.toString());
              Log.w("CrashReceiverService", stringBuilder.toString(), new Object[0]);
            } else {
              bool = true;
            } 
            deleteFilesInWebViewTmpDirIfExists();
            bool1 = bool;
          } catch (IOException iOException) {
            StringBuilder stringBuilder = new StringBuilder("failed to copy minidump from ");
            stringBuilder.append(parcelFileDescriptor.toString());
            stringBuilder.append(": ");
            stringBuilder.append(iOException.getMessage());
            Log.w("CrashReceiverService", stringBuilder.toString(), new Object[0]);
            deleteFilesInWebViewTmpDirIfExists();
            bool1 = bool;
          } finally {} 
        i++;
      } 
    } 
    return bool;
  }
  
  private static void deleteFilesInWebViewTmpDirIfExists() {
    File file = getWebViewTmpCrashDir();
    if (file.isDirectory()) {
      File[] arrayOfFile = file.listFiles();
      if (arrayOfFile != null) {
        int j = arrayOfFile.length;
        for (int i = 0; i < j; i++) {
          File file1 = arrayOfFile[i];
          if (!file1.delete()) {
            StringBuilder stringBuilder = new StringBuilder("Couldn't delete file ");
            stringBuilder.append(file1.getAbsolutePath());
            Log.w("CrashReceiverService", stringBuilder.toString(), new Object[0]);
          } 
        } 
      } 
    } 
  }
  
  public static File getWebViewCrashDir() {
    return new File(ContextUtils.sApplicationContext.getCacheDir(), "WebView_Crashes");
  }
  
  private static File getWebViewTmpCrashDir() {
    return new File(ContextUtils.sApplicationContext.getCacheDir(), "WebView_Crashes_Tmp");
  }
  
  public Context createConfigurationContext(Configuration paramConfiguration) {
    if (Build.VERSION.SDK_INT < 17)
      return null; 
    if (!BuildHooksAndroid.isEnabled())
      return super.createConfigurationContext(paramConfiguration); 
    super.createConfigurationContext(paramConfiguration);
    return BuildHooksAndroid.createConfigurationContext$6263c3eb();
  }
  
  public AssetManager getAssets() {
    return !BuildHooksAndroid.isEnabled() ? super.getAssets() : BuildHooksAndroid.getAssets$49f66a90();
  }
  
  public Resources getResources() {
    return !BuildHooksAndroid.isEnabled() ? super.getResources() : BuildHooksAndroid.getResources$177d0c3c();
  }
  
  public Resources.Theme getTheme() {
    return !BuildHooksAndroid.isEnabled() ? super.getTheme() : BuildHooksAndroid.getTheme$21e91261();
  }
  
  public IBinder onBind(Intent paramIntent) {
    return (IBinder)this.mBinder;
  }
  
  public void onCreate() {
    super.onCreate();
    ServiceInit.init(getApplicationContext());
  }
  
  public void setTheme(int paramInt) {
    if (!BuildHooksAndroid.isEnabled()) {
      super.setTheme(paramInt);
      return;
    } 
    BuildHooksAndroid.get();
  }
  
  final boolean waitUntilWeCanCopy() {
    synchronized (this.mCopyingLock) {
      while (true) {
        boolean bool = this.mIsCopying;
        if (bool) {
          try {
            this.mCopyingLock.wait();
          } catch (InterruptedException interruptedException) {
            Log.e("CrashReceiverService", "Was interrupted when waiting to copy minidumps", new Object[] { interruptedException });
            return false;
          } 
          continue;
        } 
        this.mIsCopying = true;
        return true;
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\services\CrashReceiverService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */