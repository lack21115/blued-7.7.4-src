package org.chromium.net;

import android.annotation.SuppressLint;
import android.net.ConnectivityManager;
import android.net.Network;
import android.os.Build;
import java.util.ArrayList;
import java.util.Iterator;
import org.chromium.base.ContextUtils;
import org.chromium.base.ObserverList;
import org.chromium.base.annotations.CalledByNative;

public class NetworkChangeNotifier {
  @SuppressLint({"StaticFieldLeak"})
  private static NetworkChangeNotifier sInstance;
  
  private NetworkChangeNotifierAutoDetect mAutoDetector;
  
  private final ObserverList mConnectionTypeObservers = new ObserverList();
  
  private final ConnectivityManager mConnectivityManager = (ConnectivityManager)ContextUtils.sApplicationContext.getSystemService("connectivity");
  
  private int mCurrentConnectionType = 0;
  
  private final ArrayList mNativeChangeNotifiers = new ArrayList();
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  @CalledByNative
  public static void fakeConnectionSubtypeChanged(int paramInt) {
    setAutoDetectConnectivityState(false);
    getInstance().notifyObserversOfConnectionSubtypeChange(paramInt);
  }
  
  @CalledByNative
  public static void fakeDefaultNetwork(long paramLong, int paramInt) {
    setAutoDetectConnectivityState(false);
    getInstance().notifyObserversOfConnectionTypeChange(paramInt, paramLong);
  }
  
  @CalledByNative
  public static void fakeNetworkConnected(long paramLong, int paramInt) {
    setAutoDetectConnectivityState(false);
    getInstance().notifyObserversOfNetworkConnect(paramLong, paramInt);
  }
  
  @CalledByNative
  public static void fakeNetworkDisconnected(long paramLong) {
    setAutoDetectConnectivityState(false);
    getInstance().notifyObserversOfNetworkDisconnect(paramLong);
  }
  
  @CalledByNative
  public static void fakeNetworkSoonToBeDisconnected(long paramLong) {
    setAutoDetectConnectivityState(false);
    getInstance().notifyObserversOfNetworkSoonToDisconnect(paramLong);
  }
  
  @CalledByNative
  public static void fakePurgeActiveNetworkList(long[] paramArrayOflong) {
    setAutoDetectConnectivityState(false);
    getInstance().notifyObserversToPurgeActiveNetworkList(paramArrayOflong);
  }
  
  @CalledByNative
  public static void forceConnectivityState(boolean paramBoolean) {
    boolean bool1;
    boolean bool = false;
    setAutoDetectConnectivityState(false);
    NetworkChangeNotifier networkChangeNotifier = getInstance();
    int i = networkChangeNotifier.mCurrentConnectionType;
    byte b = 6;
    if (i != 6) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (bool1 != paramBoolean) {
      if (paramBoolean)
        b = 0; 
      networkChangeNotifier.updateCurrentConnectionType(b);
      if (paramBoolean) {
        b = bool;
      } else {
        b = 1;
      } 
      networkChangeNotifier.notifyObserversOfConnectionSubtypeChange(b);
    } 
  }
  
  private static NetworkChangeNotifier getInstance() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  public static NetworkChangeNotifier init() {
    if (sInstance == null)
      sInstance = new NetworkChangeNotifier(); 
    return sInstance;
  }
  
  @CalledByNative
  public static boolean isProcessBoundToNetwork() {
    NetworkChangeNotifier networkChangeNotifier = getInstance();
    if (Build.VERSION.SDK_INT >= 21) {
      if (Build.VERSION.SDK_INT < 23)
        return (ConnectivityManager.getProcessDefaultNetwork() != null); 
      if (networkChangeNotifier.mConnectivityManager.getBoundNetworkForProcess() != null)
        return true; 
    } 
    return false;
  }
  
  private native void nativeNotifyConnectionTypeChanged(long paramLong1, int paramInt, long paramLong2);
  
  private native void nativeNotifyMaxBandwidthChanged(long paramLong, int paramInt);
  
  private native void nativeNotifyOfNetworkConnect(long paramLong1, long paramLong2, int paramInt);
  
  private native void nativeNotifyOfNetworkDisconnect(long paramLong1, long paramLong2);
  
  private native void nativeNotifyOfNetworkSoonToDisconnect(long paramLong1, long paramLong2);
  
  private native void nativeNotifyPurgeActiveNetworkList(long paramLong, long[] paramArrayOflong);
  
  private void notifyObserversOfConnectionTypeChange(int paramInt, long paramLong) {
    Iterator<Long> iterator = this.mNativeChangeNotifiers.iterator();
    while (iterator.hasNext())
      nativeNotifyConnectionTypeChanged(((Long)iterator.next()).longValue(), paramInt, paramLong); 
    iterator = this.mConnectionTypeObservers.iterator();
    while (iterator.hasNext())
      iterator.next(); 
  }
  
  public static void setAutoDetectConnectivityState(NetworkChangeNotifierAutoDetect$RegistrationPolicy paramNetworkChangeNotifierAutoDetect$RegistrationPolicy) {
    getInstance().setAutoDetectConnectivityStateInternal(true, paramNetworkChangeNotifierAutoDetect$RegistrationPolicy);
  }
  
  public static void setAutoDetectConnectivityState(boolean paramBoolean) {
    getInstance().setAutoDetectConnectivityStateInternal(paramBoolean, new RegistrationPolicyApplicationStatus());
  }
  
  private void setAutoDetectConnectivityStateInternal(boolean paramBoolean, NetworkChangeNotifierAutoDetect$RegistrationPolicy paramNetworkChangeNotifierAutoDetect$RegistrationPolicy) {
    if (paramBoolean) {
      if (this.mAutoDetector == null) {
        this.mAutoDetector = new NetworkChangeNotifierAutoDetect(new NetworkChangeNotifier$1(this), paramNetworkChangeNotifierAutoDetect$RegistrationPolicy);
        NetworkChangeNotifierAutoDetect$NetworkState networkChangeNotifierAutoDetect$NetworkState = this.mAutoDetector.getCurrentNetworkState();
        updateCurrentConnectionType(networkChangeNotifierAutoDetect$NetworkState.getConnectionType());
        notifyObserversOfConnectionSubtypeChange(networkChangeNotifierAutoDetect$NetworkState.getConnectionSubtype());
        return;
      } 
    } else if (this.mAutoDetector != null) {
      this.mAutoDetector.destroy();
      this.mAutoDetector = null;
    } 
  }
  
  private void updateCurrentConnectionType(int paramInt) {
    this.mCurrentConnectionType = paramInt;
    notifyObserversOfConnectionTypeChange(paramInt, getCurrentDefaultNetId());
  }
  
  @CalledByNative
  public void addNativeObserver(long paramLong) {
    this.mNativeChangeNotifiers.add(Long.valueOf(paramLong));
  }
  
  @CalledByNative
  public int getCurrentConnectionSubtype() {
    return (this.mAutoDetector == null) ? 0 : this.mAutoDetector.getCurrentNetworkState().getConnectionSubtype();
  }
  
  @CalledByNative
  public int getCurrentConnectionType() {
    return this.mCurrentConnectionType;
  }
  
  @CalledByNative
  public long getCurrentDefaultNetId() {
    if (this.mAutoDetector == null)
      return -1L; 
    NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.mAutoDetector;
    if (Build.VERSION.SDK_INT < 21)
      return -1L; 
    Network network = networkChangeNotifierAutoDetect.mConnectivityManagerDelegate.getDefaultNetwork();
    return (network == null) ? -1L : NetworkChangeNotifierAutoDetect.networkToNetId(network);
  }
  
  @CalledByNative
  public long[] getCurrentNetworksAndTypes() {
    NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect = this.mAutoDetector;
    int i = 0;
    if (networkChangeNotifierAutoDetect == null)
      return new long[0]; 
    networkChangeNotifierAutoDetect = this.mAutoDetector;
    if (Build.VERSION.SDK_INT < 21)
      return new long[0]; 
    Network[] arrayOfNetwork = NetworkChangeNotifierAutoDetect.getAllNetworksFiltered(networkChangeNotifierAutoDetect.mConnectivityManagerDelegate, null);
    long[] arrayOfLong = new long[arrayOfNetwork.length << 1];
    int k = arrayOfNetwork.length;
    int j = 0;
    while (i < k) {
      Network network = arrayOfNetwork[i];
      int m = j + 1;
      arrayOfLong[j] = NetworkChangeNotifierAutoDetect.networkToNetId(network);
      j = m + 1;
      arrayOfLong[m] = networkChangeNotifierAutoDetect.mConnectivityManagerDelegate.getConnectionType(network);
      i++;
    } 
    return arrayOfLong;
  }
  
  final void notifyObserversOfConnectionSubtypeChange(int paramInt) {
    Iterator<Long> iterator = this.mNativeChangeNotifiers.iterator();
    while (iterator.hasNext())
      nativeNotifyMaxBandwidthChanged(((Long)iterator.next()).longValue(), paramInt); 
  }
  
  final void notifyObserversOfNetworkConnect(long paramLong, int paramInt) {
    Iterator<Long> iterator = this.mNativeChangeNotifiers.iterator();
    while (iterator.hasNext())
      nativeNotifyOfNetworkConnect(((Long)iterator.next()).longValue(), paramLong, paramInt); 
  }
  
  final void notifyObserversOfNetworkDisconnect(long paramLong) {
    Iterator<Long> iterator = this.mNativeChangeNotifiers.iterator();
    while (iterator.hasNext())
      nativeNotifyOfNetworkDisconnect(((Long)iterator.next()).longValue(), paramLong); 
  }
  
  final void notifyObserversOfNetworkSoonToDisconnect(long paramLong) {
    Iterator<Long> iterator = this.mNativeChangeNotifiers.iterator();
    while (iterator.hasNext())
      nativeNotifyOfNetworkSoonToDisconnect(((Long)iterator.next()).longValue(), paramLong); 
  }
  
  final void notifyObserversToPurgeActiveNetworkList(long[] paramArrayOflong) {
    Iterator<Long> iterator = this.mNativeChangeNotifiers.iterator();
    while (iterator.hasNext())
      nativeNotifyPurgeActiveNetworkList(((Long)iterator.next()).longValue(), paramArrayOflong); 
  }
  
  @CalledByNative
  public boolean registerNetworkCallbackFailed() {
    return (this.mAutoDetector == null) ? false : this.mAutoDetector.mRegisterNetworkCallbackFailed;
  }
  
  @CalledByNative
  public void removeNativeObserver(long paramLong) {
    this.mNativeChangeNotifiers.remove(Long.valueOf(paramLong));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\net\NetworkChangeNotifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */