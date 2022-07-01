package org.chromium.content.browser;

import android.annotation.SuppressLint;
import android.os.Process;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.chromium.base.ApiCompatibilityUtils;
import org.chromium.base.ContextUtils;
import org.chromium.base.ThreadUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.metrics.RecordHistogram;
import org.chromium.net.NetworkChangeNotifierAutoDetect;
import org.chromium.net.RegistrationPolicyAlwaysRegister;

class BackgroundSyncNetworkObserver implements NetworkChangeNotifierAutoDetect.Observer {
  @SuppressLint({"StaticFieldLeak"})
  private static BackgroundSyncNetworkObserver sInstance;
  
  private boolean mHasBroadcastConnectionType;
  
  private int mLastBroadcastConnectionType;
  
  private List mNativePtrs;
  
  private NetworkChangeNotifierAutoDetect mNotifier;
  
  private BackgroundSyncNetworkObserver() {
    ThreadUtils.assertOnUiThread();
    this.mNativePtrs = new ArrayList();
  }
  
  private void broadcastNetworkChangeIfNecessary(int paramInt) {
    if (this.mHasBroadcastConnectionType && paramInt == this.mLastBroadcastConnectionType)
      return; 
    this.mHasBroadcastConnectionType = true;
    this.mLastBroadcastConnectionType = paramInt;
    Iterator<Long> iterator = this.mNativePtrs.iterator();
    while (iterator.hasNext())
      nativeNotifyConnectionTypeChanged(((Long)iterator.next()).longValue(), paramInt); 
  }
  
  @CalledByNative
  private static BackgroundSyncNetworkObserver createObserver(long paramLong) {
    boolean bool;
    ThreadUtils.assertOnUiThread();
    if (sInstance == null)
      sInstance = new BackgroundSyncNetworkObserver(); 
    BackgroundSyncNetworkObserver backgroundSyncNetworkObserver = sInstance;
    ThreadUtils.assertOnUiThread();
    if (ApiCompatibilityUtils.checkPermission(ContextUtils.sApplicationContext, "android.permission.ACCESS_NETWORK_STATE", Process.myPid(), Process.myUid()) == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    if (!bool) {
      RecordHistogram.recordBooleanHistogram("BackgroundSync.NetworkObserver.HasPermission", false);
    } else {
      if (backgroundSyncNetworkObserver.mNotifier == null) {
        backgroundSyncNetworkObserver.mNotifier = new NetworkChangeNotifierAutoDetect(backgroundSyncNetworkObserver, (NetworkChangeNotifierAutoDetect.RegistrationPolicy)new RegistrationPolicyAlwaysRegister());
        RecordHistogram.recordBooleanHistogram("BackgroundSync.NetworkObserver.HasPermission", true);
      } 
      backgroundSyncNetworkObserver.mNativePtrs.add(Long.valueOf(paramLong));
      backgroundSyncNetworkObserver.nativeNotifyConnectionTypeChanged(paramLong, backgroundSyncNetworkObserver.mNotifier.getCurrentNetworkState().getConnectionType());
    } 
    return sInstance;
  }
  
  private native void nativeNotifyConnectionTypeChanged(long paramLong, int paramInt);
  
  @CalledByNative
  private void removeObserver(long paramLong) {
    ThreadUtils.assertOnUiThread();
    this.mNativePtrs.remove(Long.valueOf(paramLong));
    if (this.mNativePtrs.size() == 0 && this.mNotifier != null) {
      this.mNotifier.destroy();
      this.mNotifier = null;
    } 
  }
  
  public final void onConnectionSubtypeChanged(int paramInt) {}
  
  public final void onConnectionTypeChanged(int paramInt) {
    ThreadUtils.assertOnUiThread();
    broadcastNetworkChangeIfNecessary(paramInt);
  }
  
  public final void onNetworkConnect(long paramLong, int paramInt) {
    ThreadUtils.assertOnUiThread();
    broadcastNetworkChangeIfNecessary(this.mNotifier.getCurrentNetworkState().getConnectionType());
  }
  
  public final void onNetworkDisconnect(long paramLong) {
    ThreadUtils.assertOnUiThread();
    broadcastNetworkChangeIfNecessary(this.mNotifier.getCurrentNetworkState().getConnectionType());
  }
  
  public final void onNetworkSoonToDisconnect(long paramLong) {}
  
  public final void purgeActiveNetworkList(long[] paramArrayOflong) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\BackgroundSyncNetworkObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */