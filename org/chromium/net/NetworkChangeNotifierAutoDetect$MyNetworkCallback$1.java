package org.chromium.net;

final class NetworkChangeNotifierAutoDetect$MyNetworkCallback$1 implements Runnable {
  public final void run() {
    NetworkChangeNotifierAutoDetect.access$300(this.this$1.this$0).onNetworkConnect(netId, connectionType);
    if (makeVpnDefault) {
      NetworkChangeNotifierAutoDetect.access$300(this.this$1.this$0).onConnectionTypeChanged(connectionType);
      NetworkChangeNotifierAutoDetect.access$300(this.this$1.this$0).purgeActiveNetworkList(new long[] { this.val$netId });
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\net\NetworkChangeNotifierAutoDetect$MyNetworkCallback$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */