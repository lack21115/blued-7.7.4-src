package org.chromium.service_manager.mojom;

import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.system.Core;

final class InterfaceProvider_Internal$Stub extends Interface.Stub {
  InterfaceProvider_Internal$Stub(Core paramCore, InterfaceProvider paramInterfaceProvider) {
    super(paramCore, paramInterfaceProvider);
  }
  
  public final boolean accept(Message paramMessage) {
    try {
      InterfaceProvider_Internal$InterfaceProviderGetInterfaceParams interfaceProvider_Internal$InterfaceProviderGetInterfaceParams;
      ServiceMessage serviceMessage = paramMessage.asServiceMessage();
      MessageHeader messageHeader = serviceMessage.mHeader;
      if (!messageHeader.validateHeader(0))
        return false; 
      int i = messageHeader.mType;
      if (i != -2) {
        if (i != 0)
          return false; 
        interfaceProvider_Internal$InterfaceProviderGetInterfaceParams = InterfaceProvider_Internal$InterfaceProviderGetInterfaceParams.deserialize(serviceMessage.getPayload());
        ((InterfaceProvider)this.mImpl).getInterface(interfaceProvider_Internal$InterfaceProviderGetInterfaceParams.interfaceName, interfaceProvider_Internal$InterfaceProviderGetInterfaceParams.pipe);
        return true;
      } 
      return InterfaceControlMessagesHelper.handleRunOrClosePipe(InterfaceProvider_Internal.MANAGER, (ServiceMessage)interfaceProvider_Internal$InterfaceProviderGetInterfaceParams);
    } catch (DeserializationException deserializationException) {
      System.err.println(deserializationException.toString());
      return false;
    } 
  }
  
  public final boolean acceptWithResponder(Message paramMessage, MessageReceiver paramMessageReceiver) {
    try {
      ServiceMessage serviceMessage = paramMessage.asServiceMessage();
      MessageHeader messageHeader = serviceMessage.mHeader;
      return !messageHeader.validateHeader(1) ? false : ((messageHeader.mType != -1) ? false : InterfaceControlMessagesHelper.handleRun(this.mCore, InterfaceProvider_Internal.MANAGER, serviceMessage, paramMessageReceiver));
    } catch (DeserializationException deserializationException) {
      System.err.println(deserializationException.toString());
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\service_manager\mojom\InterfaceProvider_Internal$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */