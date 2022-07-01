package org.chromium.mojo.bindings;

final class RouterImpl$ResponderThunk implements MessageReceiver {
  private boolean mAcceptWasInvoked;
  
  public final boolean accept(Message paramMessage) {
    this.mAcceptWasInvoked = true;
    return RouterImpl.this.accept(paramMessage);
  }
  
  public final void close() {
    RouterImpl.this.close();
  }
  
  protected final void finalize() {
    if (!this.mAcceptWasInvoked)
      RouterImpl.access$200(RouterImpl.this); 
    super.finalize();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\bindings\RouterImpl$ResponderThunk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */