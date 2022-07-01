package org.chromium.mojo.bindings;

public interface Router extends HandleOwner, MessageReceiverWithResponder {
  void setErrorHandler(ConnectionErrorHandler paramConnectionErrorHandler);
  
  void setIncomingMessageReceiver(MessageReceiverWithResponder paramMessageReceiverWithResponder);
  
  void start();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\bindings\Router.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */