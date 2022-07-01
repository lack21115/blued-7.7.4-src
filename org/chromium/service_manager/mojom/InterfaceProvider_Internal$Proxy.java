package org.chromium.service_manager.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.MessagePipeHandle;

final class InterfaceProvider_Internal$Proxy extends Interface.AbstractProxy implements InterfaceProvider$Proxy {
  InterfaceProvider_Internal$Proxy(Core paramCore, MessageReceiverWithResponder paramMessageReceiverWithResponder) {
    super(paramCore, paramMessageReceiverWithResponder);
  }
  
  public final void getInterface(String paramString, MessagePipeHandle paramMessagePipeHandle) {
    InterfaceProvider_Internal$InterfaceProviderGetInterfaceParams interfaceProvider_Internal$InterfaceProviderGetInterfaceParams = new InterfaceProvider_Internal$InterfaceProviderGetInterfaceParams((byte)0);
    interfaceProvider_Internal$InterfaceProviderGetInterfaceParams.interfaceName = paramString;
    interfaceProvider_Internal$InterfaceProviderGetInterfaceParams.pipe = paramMessagePipeHandle;
    this.mHandler.mMessageReceiver.accept((Message)interfaceProvider_Internal$InterfaceProviderGetInterfaceParams.serializeWithHeader(this.mHandler.mCore, new MessageHeader(0)));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\service_manager\mojom\InterfaceProvider_Internal$Proxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */