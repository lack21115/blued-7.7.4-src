package org.chromium.mojo.bindings;

import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.MessagePipeHandle;

public abstract class Interface$Manager {
  public final Interface$Proxy attachProxy(MessagePipeHandle paramMessagePipeHandle, int paramInt) {
    RouterImpl routerImpl = new RouterImpl(paramMessagePipeHandle);
    Core core = paramMessagePipeHandle.getCore();
    Interface$Proxy interface$Proxy = buildProxy(core, new AutoCloseableRouter(core, routerImpl));
    DelegatingConnectionErrorHandler delegatingConnectionErrorHandler = new DelegatingConnectionErrorHandler();
    delegatingConnectionErrorHandler.mHandlers.add(interface$Proxy);
    routerImpl.setErrorHandler(delegatingConnectionErrorHandler);
    routerImpl.mConnector.start();
    ((Interface$AbstractProxy$HandlerImpl)interface$Proxy.getProxyHandler()).mVersion = paramInt;
    return interface$Proxy;
  }
  
  public final void bind(Interface paramInterface, InterfaceRequest paramInterfaceRequest) {
    bind(paramInterface, paramInterfaceRequest.passHandle());
  }
  
  public final void bind(Interface paramInterface, MessagePipeHandle paramMessagePipeHandle) {
    RouterImpl routerImpl = new RouterImpl(paramMessagePipeHandle);
    Core core = paramMessagePipeHandle.getCore();
    routerImpl.setErrorHandler(paramInterface);
    routerImpl.setIncomingMessageReceiver(buildStub(core, paramInterface));
    routerImpl.start();
  }
  
  public abstract Interface$Proxy buildProxy(Core paramCore, MessageReceiverWithResponder paramMessageReceiverWithResponder);
  
  public abstract Interface$Stub buildStub(Core paramCore, Interface paramInterface);
  
  public abstract String getName();
  
  public abstract int getVersion();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\bindings\Interface$Manager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */