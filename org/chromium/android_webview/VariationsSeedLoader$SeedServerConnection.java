package org.chromium.android_webview;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import java.io.Closeable;
import org.chromium.android_webview.services.IVariationsSeedServer;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;

final class VariationsSeedLoader$SeedServerConnection implements ServiceConnection {
  private ParcelFileDescriptor mNewSeedFd;
  
  private long mOldSeedDate;
  
  public VariationsSeedLoader$SeedServerConnection(ParcelFileDescriptor paramParcelFileDescriptor, long paramLong) {
    this.mNewSeedFd = paramParcelFileDescriptor;
    this.mOldSeedDate = paramLong;
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
    try {
      IVariationsSeedServer.Stub.asInterface(paramIBinder).getSeed(this.mNewSeedFd, this.mOldSeedDate);
      Context context = ContextUtils.sApplicationContext;
    } catch (RemoteException remoteException) {
    
    } finally {}
    paramComponentName.unbindService(this);
    VariationsUtils.closeSafely((Closeable)this.mNewSeedFd);
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName) {}
  
  public final void start() {
    try {
      if (!ContextUtils.sApplicationContext.bindService(VariationsSeedLoader.getServerIntent(), this, 1))
        Log.e("VariationsSeedLoader", "Failed to bind to WebView service", new Object[0]); 
      return;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      StringBuilder stringBuilder = new StringBuilder("WebView provider \"");
      stringBuilder.append(AwBrowserProcess.getWebViewPackageName());
      stringBuilder.append("\" not found!");
      Log.e("VariationsSeedLoader", stringBuilder.toString(), new Object[0]);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\VariationsSeedLoader$SeedServerConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */