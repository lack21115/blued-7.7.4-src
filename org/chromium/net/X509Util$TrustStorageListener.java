package org.chromium.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

final class X509Util$TrustStorageListener extends BroadcastReceiver {
  private X509Util$TrustStorageListener() {}
  
  public final void onReceive(Context paramContext, Intent paramIntent) {
    int i = Build.VERSION.SDK_INT;
    boolean bool = true;
    if (i >= 26) {
      if (!"android.security.action.KEYCHAIN_CHANGED".equals(paramIntent.getAction()) && !"android.security.action.TRUST_STORE_CHANGED".equals(paramIntent.getAction()) && (!"android.security.action.KEY_ACCESS_CHANGED".equals(paramIntent.getAction()) || paramIntent.getBooleanExtra("android.security.extra.KEY_ACCESSIBLE", false)))
        bool = false; 
    } else {
      bool = "android.security.STORAGE_CHANGED".equals(paramIntent.getAction());
    } 
    if (bool)
      try {
        X509Util.access$000();
        return;
      } catch (CertificateException certificateException) {
        Log.e("X509Util", "Unable to reload the default TrustManager", certificateException);
        return;
      } catch (KeyStoreException keyStoreException) {
        Log.e("X509Util", "Unable to reload the default TrustManager", keyStoreException);
        return;
      } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
        Log.e("X509Util", "Unable to reload the default TrustManager", noSuchAlgorithmException);
        return;
      }  
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\net\X509Util$TrustStorageListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */