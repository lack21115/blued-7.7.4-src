package org.chromium.net;

import android.annotation.TargetApi;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

@TargetApi(21)
final class NetworkChangeNotifierAutoDetect$MyNetworkCallback extends ConnectivityManager.NetworkCallback {
  private Network mVpnInPlace;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private NetworkChangeNotifierAutoDetect$MyNetworkCallback() {}
  
  private boolean ignoreConnectedNetwork(Network paramNetwork, NetworkCapabilities paramNetworkCapabilities) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial ignoreNetworkDueToVpn : (Landroid/net/Network;)Z
    //   5: ifne -> 75
    //   8: aload_2
    //   9: astore #4
    //   11: aload_2
    //   12: ifnonnull -> 28
    //   15: aload_0
    //   16: getfield this$0 : Lorg/chromium/net/NetworkChangeNotifierAutoDetect;
    //   19: invokestatic access$200 : (Lorg/chromium/net/NetworkChangeNotifierAutoDetect;)Lorg/chromium/net/NetworkChangeNotifierAutoDetect$ConnectivityManagerDelegate;
    //   22: aload_1
    //   23: invokevirtual getNetworkCapabilities : (Landroid/net/Network;)Landroid/net/NetworkCapabilities;
    //   26: astore #4
    //   28: aload #4
    //   30: ifnull -> 65
    //   33: aload #4
    //   35: iconst_4
    //   36: invokevirtual hasTransport : (I)Z
    //   39: ifeq -> 60
    //   42: aload_0
    //   43: getfield this$0 : Lorg/chromium/net/NetworkChangeNotifierAutoDetect;
    //   46: invokestatic access$200 : (Lorg/chromium/net/NetworkChangeNotifierAutoDetect;)Lorg/chromium/net/NetworkChangeNotifierAutoDetect$ConnectivityManagerDelegate;
    //   49: pop
    //   50: aload_1
    //   51: invokestatic vpnAccessible : (Landroid/net/Network;)Z
    //   54: ifne -> 60
    //   57: goto -> 65
    //   60: iconst_0
    //   61: istore_3
    //   62: goto -> 67
    //   65: iconst_1
    //   66: istore_3
    //   67: iload_3
    //   68: ifeq -> 73
    //   71: iconst_1
    //   72: ireturn
    //   73: iconst_0
    //   74: ireturn
    //   75: iconst_1
    //   76: ireturn
  }
  
  private boolean ignoreNetworkDueToVpn(Network paramNetwork) {
    return (this.mVpnInPlace != null && !this.mVpnInPlace.equals(paramNetwork));
  }
  
  final void initializeVpnInPlace() {
    Network[] arrayOfNetwork = NetworkChangeNotifierAutoDetect.access$100(NetworkChangeNotifierAutoDetect.access$200(NetworkChangeNotifierAutoDetect.this), null);
    this.mVpnInPlace = null;
    if (arrayOfNetwork.length == 1) {
      NetworkCapabilities networkCapabilities = NetworkChangeNotifierAutoDetect.access$200(NetworkChangeNotifierAutoDetect.this).getNetworkCapabilities(arrayOfNetwork[0]);
      if (networkCapabilities != null && networkCapabilities.hasTransport(4))
        this.mVpnInPlace = arrayOfNetwork[0]; 
    } 
  }
  
  public final void onAvailable(Network paramNetwork) {
    NetworkCapabilities networkCapabilities = NetworkChangeNotifierAutoDetect.access$200(NetworkChangeNotifierAutoDetect.this).getNetworkCapabilities(paramNetwork);
    if (ignoreConnectedNetwork(paramNetwork, networkCapabilities))
      return; 
    boolean bool = networkCapabilities.hasTransport(4);
    if (bool)
      this.mVpnInPlace = paramNetwork; 
    long l = NetworkChangeNotifierAutoDetect.networkToNetId(paramNetwork);
    int i = NetworkChangeNotifierAutoDetect.access$200(NetworkChangeNotifierAutoDetect.this).getConnectionType(paramNetwork);
    NetworkChangeNotifierAutoDetect.access$400(NetworkChangeNotifierAutoDetect.this, new NetworkChangeNotifierAutoDetect$MyNetworkCallback$1(this, l, i, bool));
  }
  
  public final void onCapabilitiesChanged(Network paramNetwork, NetworkCapabilities paramNetworkCapabilities) {
    if (ignoreConnectedNetwork(paramNetwork, paramNetworkCapabilities))
      return; 
    long l = NetworkChangeNotifierAutoDetect.networkToNetId(paramNetwork);
    int i = NetworkChangeNotifierAutoDetect.access$200(NetworkChangeNotifierAutoDetect.this).getConnectionType(paramNetwork);
    NetworkChangeNotifierAutoDetect.access$400(NetworkChangeNotifierAutoDetect.this, new NetworkChangeNotifierAutoDetect$MyNetworkCallback$2(this, l, i));
  }
  
  public final void onLosing(Network paramNetwork, int paramInt) {
    if (ignoreConnectedNetwork(paramNetwork, null))
      return; 
    long l = NetworkChangeNotifierAutoDetect.networkToNetId(paramNetwork);
    NetworkChangeNotifierAutoDetect.access$400(NetworkChangeNotifierAutoDetect.this, new NetworkChangeNotifierAutoDetect$MyNetworkCallback$3(this, l));
  }
  
  public final void onLost(Network paramNetwork) {
    if (ignoreNetworkDueToVpn(paramNetwork))
      return; 
    NetworkChangeNotifierAutoDetect.access$400(NetworkChangeNotifierAutoDetect.this, new NetworkChangeNotifierAutoDetect$MyNetworkCallback$4(this, paramNetwork));
    if (this.mVpnInPlace != null) {
      assert false;
      throw new AssertionError();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\net\NetworkChangeNotifierAutoDetect$MyNetworkCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */