package org.chromium.net;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.util.Arrays;
import org.chromium.base.BuildConfig;
import org.chromium.base.ContextUtils;

@SuppressLint({"NewApi"})
public class NetworkChangeNotifierAutoDetect extends BroadcastReceiver {
  NetworkChangeNotifierAutoDetect$ConnectivityManagerDelegate mConnectivityManagerDelegate;
  
  private final Handler mHandler = new Handler(this.mLooper);
  
  private boolean mIgnoreNextBroadcast;
  
  private final NetworkChangeNotifierAutoDetect$NetworkConnectivityIntentFilter mIntentFilter;
  
  private final Looper mLooper = Looper.myLooper();
  
  private NetworkChangeNotifierAutoDetect$MyNetworkCallback mNetworkCallback;
  
  private NetworkRequest mNetworkRequest;
  
  private NetworkChangeNotifierAutoDetect$NetworkState mNetworkState;
  
  private final NetworkChangeNotifierAutoDetect$Observer mObserver;
  
  boolean mRegisterNetworkCallbackFailed;
  
  private boolean mRegistered;
  
  private final NetworkChangeNotifierAutoDetect$RegistrationPolicy mRegistrationPolicy;
  
  private boolean mShouldSignalObserver;
  
  private NetworkChangeNotifierAutoDetect$WifiManagerDelegate mWifiManagerDelegate;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  @TargetApi(21)
  public NetworkChangeNotifierAutoDetect(NetworkChangeNotifierAutoDetect$Observer paramNetworkChangeNotifierAutoDetect$Observer, NetworkChangeNotifierAutoDetect$RegistrationPolicy paramNetworkChangeNotifierAutoDetect$RegistrationPolicy) {
    this.mObserver = paramNetworkChangeNotifierAutoDetect$Observer;
    this.mConnectivityManagerDelegate = new NetworkChangeNotifierAutoDetect$ConnectivityManagerDelegate(ContextUtils.sApplicationContext);
    if (Build.VERSION.SDK_INT < 23)
      this.mWifiManagerDelegate = new NetworkChangeNotifierAutoDetect$WifiManagerDelegate(ContextUtils.sApplicationContext); 
    if (Build.VERSION.SDK_INT >= 21) {
      this.mNetworkCallback = new NetworkChangeNotifierAutoDetect$MyNetworkCallback(this, (byte)0);
      this.mNetworkRequest = (new NetworkRequest.Builder()).addCapability(12).removeCapability(15).build();
    } else {
      this.mNetworkCallback = null;
      this.mNetworkRequest = null;
    } 
    this.mNetworkState = getCurrentNetworkState();
    this.mIntentFilter = new NetworkChangeNotifierAutoDetect$NetworkConnectivityIntentFilter();
    this.mIgnoreNextBroadcast = false;
    this.mShouldSignalObserver = false;
    this.mRegistrationPolicy = paramNetworkChangeNotifierAutoDetect$RegistrationPolicy;
    this.mRegistrationPolicy.init(this);
    this.mShouldSignalObserver = true;
  }
  
  private void assertOnThread() {
    if (BuildConfig.DCHECK_IS_ON) {
      if (onThread())
        return; 
      throw new IllegalStateException("Must be called on NetworkChangeNotifierAutoDetect thread.");
    } 
  }
  
  private void connectionTypeChanged() {
    NetworkChangeNotifierAutoDetect$NetworkState networkChangeNotifierAutoDetect$NetworkState = getCurrentNetworkState();
    if (networkChangeNotifierAutoDetect$NetworkState.getConnectionType() != this.mNetworkState.getConnectionType() || !networkChangeNotifierAutoDetect$NetworkState.mNetworkIdentifier.equals(this.mNetworkState.mNetworkIdentifier))
      this.mObserver.onConnectionTypeChanged(networkChangeNotifierAutoDetect$NetworkState.getConnectionType()); 
    if (networkChangeNotifierAutoDetect$NetworkState.getConnectionType() != this.mNetworkState.getConnectionType() || networkChangeNotifierAutoDetect$NetworkState.getConnectionSubtype() != this.mNetworkState.getConnectionSubtype())
      this.mObserver.onConnectionSubtypeChanged(networkChangeNotifierAutoDetect$NetworkState.getConnectionSubtype()); 
    this.mNetworkState = networkChangeNotifierAutoDetect$NetworkState;
  }
  
  @TargetApi(21)
  static Network[] getAllNetworksFiltered(NetworkChangeNotifierAutoDetect$ConnectivityManagerDelegate paramNetworkChangeNotifierAutoDetect$ConnectivityManagerDelegate, Network paramNetwork) {
    Network[] arrayOfNetwork2 = paramNetworkChangeNotifierAutoDetect$ConnectivityManagerDelegate.mConnectivityManager.getAllNetworks();
    Network[] arrayOfNetwork1 = arrayOfNetwork2;
    if (arrayOfNetwork2 == null)
      arrayOfNetwork1 = new Network[0]; 
    int k = arrayOfNetwork1.length;
    int i = 0;
    int j;
    for (j = 0; i < k; j = m) {
      Network network = arrayOfNetwork1[i];
      int m = j;
      if (!network.equals(paramNetwork)) {
        NetworkCapabilities networkCapabilities = paramNetworkChangeNotifierAutoDetect$ConnectivityManagerDelegate.getNetworkCapabilities(network);
        m = j;
        if (networkCapabilities != null) {
          m = j;
          if (networkCapabilities.hasCapability(12))
            if (networkCapabilities.hasTransport(4)) {
              m = j;
              if (NetworkChangeNotifierAutoDetect$ConnectivityManagerDelegate.vpnAccessible(network))
                return new Network[] { network }; 
            } else {
              arrayOfNetwork1[j] = network;
              m = j + 1;
            }  
        } 
      } 
      i++;
    } 
    return Arrays.<Network>copyOf(arrayOfNetwork1, j);
  }
  
  @TargetApi(21)
  static long networkToNetId(Network paramNetwork) {
    return (Build.VERSION.SDK_INT >= 23) ? paramNetwork.getNetworkHandle() : Integer.parseInt(paramNetwork.toString());
  }
  
  private boolean onThread() {
    return (this.mLooper == Looper.myLooper());
  }
  
  private void runOnThread(Runnable paramRunnable) {
    if (onThread()) {
      paramRunnable.run();
      return;
    } 
    this.mHandler.post(paramRunnable);
  }
  
  public final void destroy() {
    assertOnThread();
    this.mRegistrationPolicy.destroy();
    unregister();
  }
  
  public final NetworkChangeNotifierAutoDetect$NetworkState getCurrentNetworkState() {
    Network network;
    NetworkChangeNotifierAutoDetect$ConnectivityManagerDelegate networkChangeNotifierAutoDetect$ConnectivityManagerDelegate = this.mConnectivityManagerDelegate;
    NetworkChangeNotifierAutoDetect$WifiManagerDelegate networkChangeNotifierAutoDetect$WifiManagerDelegate = this.mWifiManagerDelegate;
    if (Build.VERSION.SDK_INT >= 23) {
      network = networkChangeNotifierAutoDetect$ConnectivityManagerDelegate.getDefaultNetwork();
      networkInfo = networkChangeNotifierAutoDetect$ConnectivityManagerDelegate.mConnectivityManager.getNetworkInfo(network);
    } else {
      networkInfo = ((NetworkChangeNotifierAutoDetect$ConnectivityManagerDelegate)networkInfo).mConnectivityManager.getActiveNetworkInfo();
      network = null;
    } 
    NetworkInfo networkInfo = NetworkChangeNotifierAutoDetect$ConnectivityManagerDelegate.processActiveNetworkInfo(networkInfo);
    if (networkInfo == null)
      return new NetworkChangeNotifierAutoDetect$NetworkState(false, -1, -1, null); 
    if (network != null)
      return new NetworkChangeNotifierAutoDetect$NetworkState(true, networkInfo.getType(), networkInfo.getSubtype(), String.valueOf(networkToNetId(network))); 
    if (NetworkChangeNotifierAutoDetect$ConnectivityManagerDelegate.$assertionsDisabled || Build.VERSION.SDK_INT < 23)
      return (networkInfo.getType() == 1) ? ((networkInfo.getExtraInfo() != null && !"".equals(networkInfo.getExtraInfo())) ? new NetworkChangeNotifierAutoDetect$NetworkState(true, networkInfo.getType(), networkInfo.getSubtype(), networkInfo.getExtraInfo()) : new NetworkChangeNotifierAutoDetect$NetworkState(true, networkInfo.getType(), networkInfo.getSubtype(), networkChangeNotifierAutoDetect$WifiManagerDelegate.getWifiSsid())) : new NetworkChangeNotifierAutoDetect$NetworkState(true, networkInfo.getType(), networkInfo.getSubtype(), null); 
    throw new AssertionError();
  }
  
  public void onReceive(Context paramContext, Intent paramIntent) {
    runOnThread(new NetworkChangeNotifierAutoDetect$1(this));
  }
  
  public final void register() {
    boolean bool;
    assertOnThread();
    if (this.mRegistered)
      return; 
    if (this.mShouldSignalObserver)
      connectionTypeChanged(); 
    Intent intent = ContextUtils.sApplicationContext.registerReceiver(this, this.mIntentFilter);
    int i = 0;
    if (intent != null) {
      bool = true;
    } else {
      bool = false;
    } 
    this.mIgnoreNextBroadcast = bool;
    this.mRegistered = true;
    if (this.mNetworkCallback != null) {
      this.mNetworkCallback.initializeVpnInPlace();
      try {
        NetworkChangeNotifierAutoDetect$ConnectivityManagerDelegate networkChangeNotifierAutoDetect$ConnectivityManagerDelegate = this.mConnectivityManagerDelegate;
        NetworkRequest networkRequest = this.mNetworkRequest;
        NetworkChangeNotifierAutoDetect$MyNetworkCallback networkChangeNotifierAutoDetect$MyNetworkCallback = this.mNetworkCallback;
        networkChangeNotifierAutoDetect$ConnectivityManagerDelegate.mConnectivityManager.registerNetworkCallback(networkRequest, networkChangeNotifierAutoDetect$MyNetworkCallback);
      } catch (IllegalArgumentException illegalArgumentException) {
        this.mRegisterNetworkCallbackFailed = true;
        this.mNetworkCallback = null;
      } 
      if (!this.mRegisterNetworkCallbackFailed && this.mShouldSignalObserver) {
        Network[] arrayOfNetwork = getAllNetworksFiltered(this.mConnectivityManagerDelegate, null);
        long[] arrayOfLong = new long[arrayOfNetwork.length];
        while (i < arrayOfNetwork.length) {
          arrayOfLong[i] = networkToNetId(arrayOfNetwork[i]);
          i++;
        } 
        this.mObserver.purgeActiveNetworkList(arrayOfLong);
      } 
    } 
  }
  
  public final void unregister() {
    assertOnThread();
    if (!this.mRegistered)
      return; 
    ContextUtils.sApplicationContext.unregisterReceiver(this);
    this.mRegistered = false;
    if (this.mNetworkCallback != null) {
      NetworkChangeNotifierAutoDetect$ConnectivityManagerDelegate networkChangeNotifierAutoDetect$ConnectivityManagerDelegate = this.mConnectivityManagerDelegate;
      NetworkChangeNotifierAutoDetect$MyNetworkCallback networkChangeNotifierAutoDetect$MyNetworkCallback = this.mNetworkCallback;
      networkChangeNotifierAutoDetect$ConnectivityManagerDelegate.mConnectivityManager.unregisterNetworkCallback(networkChangeNotifierAutoDetect$MyNetworkCallback);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\net\NetworkChangeNotifierAutoDetect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */