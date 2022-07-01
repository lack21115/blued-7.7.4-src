package org.chromium.net;

public interface NetworkChangeNotifierAutoDetect$Observer {
  void onConnectionSubtypeChanged(int paramInt);
  
  void onConnectionTypeChanged(int paramInt);
  
  void onNetworkConnect(long paramLong, int paramInt);
  
  void onNetworkDisconnect(long paramLong);
  
  void onNetworkSoonToDisconnect(long paramLong);
  
  void purgeActiveNetworkList(long[] paramArrayOflong);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\net\NetworkChangeNotifierAutoDetect$Observer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */