package org.chromium.net;

final class NetworkChangeNotifier$1 implements NetworkChangeNotifierAutoDetect$Observer {
  public final void onConnectionSubtypeChanged(int paramInt) {
    NetworkChangeNotifier.this.notifyObserversOfConnectionSubtypeChange(paramInt);
  }
  
  public final void onConnectionTypeChanged(int paramInt) {
    NetworkChangeNotifier.access$000(NetworkChangeNotifier.this, paramInt);
  }
  
  public final void onNetworkConnect(long paramLong, int paramInt) {
    NetworkChangeNotifier.this.notifyObserversOfNetworkConnect(paramLong, paramInt);
  }
  
  public final void onNetworkDisconnect(long paramLong) {
    NetworkChangeNotifier.this.notifyObserversOfNetworkDisconnect(paramLong);
  }
  
  public final void onNetworkSoonToDisconnect(long paramLong) {
    NetworkChangeNotifier.this.notifyObserversOfNetworkSoonToDisconnect(paramLong);
  }
  
  public final void purgeActiveNetworkList(long[] paramArrayOflong) {
    NetworkChangeNotifier.this.notifyObserversToPurgeActiveNetworkList(paramArrayOflong);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\net\NetworkChangeNotifier$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */