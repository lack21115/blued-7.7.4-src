package org.chromium.net;

public abstract class NetworkChangeNotifierAutoDetect$RegistrationPolicy {
  private NetworkChangeNotifierAutoDetect mNotifier;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public abstract void destroy();
  
  public void init(NetworkChangeNotifierAutoDetect paramNetworkChangeNotifierAutoDetect) {
    this.mNotifier = paramNetworkChangeNotifierAutoDetect;
  }
  
  public final void register() {
    assert false;
    throw new AssertionError();
  }
  
  public final void unregister() {
    assert false;
    throw new AssertionError();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\net\NetworkChangeNotifierAutoDetect$RegistrationPolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */