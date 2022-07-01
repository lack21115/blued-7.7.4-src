package org.chromium.mojo.bindings;

final class RouterImpl$HandleIncomingMessageThunk implements MessageReceiver {
  private RouterImpl$HandleIncomingMessageThunk() {}
  
  public final boolean accept(Message paramMessage) {
    return RouterImpl.access$000(RouterImpl.this, paramMessage);
  }
  
  public final void close() {
    RouterImpl.access$100(RouterImpl.this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\bindings\RouterImpl$HandleIncomingMessageThunk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */