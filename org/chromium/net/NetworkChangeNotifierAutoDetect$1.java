package org.chromium.net;

final class NetworkChangeNotifierAutoDetect$1 implements Runnable {
  public final void run() {
    if (!NetworkChangeNotifierAutoDetect.access$600(NetworkChangeNotifierAutoDetect.this))
      return; 
    if (NetworkChangeNotifierAutoDetect.access$700(NetworkChangeNotifierAutoDetect.this)) {
      NetworkChangeNotifierAutoDetect.access$702(NetworkChangeNotifierAutoDetect.this, false);
      return;
    } 
    NetworkChangeNotifierAutoDetect.access$800(NetworkChangeNotifierAutoDetect.this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\net\NetworkChangeNotifierAutoDetect$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */