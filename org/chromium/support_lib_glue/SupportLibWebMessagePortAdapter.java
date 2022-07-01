package org.chromium.support_lib_glue;

import android.os.Handler;
import java.lang.reflect.InvocationHandler;
import org.chromium.content_public.browser.MessagePort;
import org.chromium.support_lib_boundary.WebMessageBoundaryInterface;
import org.chromium.support_lib_boundary.WebMessageCallbackBoundaryInterface;
import org.chromium.support_lib_boundary.WebMessagePortBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

final class SupportLibWebMessagePortAdapter implements WebMessagePortBoundaryInterface {
  MessagePort mPort;
  
  SupportLibWebMessagePortAdapter(MessagePort paramMessagePort) {
    this.mPort = paramMessagePort;
  }
  
  public static InvocationHandler[] fromMessagePorts(MessagePort[] paramArrayOfMessagePort) {
    if (paramArrayOfMessagePort == null)
      return null; 
    InvocationHandler[] arrayOfInvocationHandler = new InvocationHandler[paramArrayOfMessagePort.length];
    for (int i = 0; i < paramArrayOfMessagePort.length; i++)
      arrayOfInvocationHandler[i] = BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new SupportLibWebMessagePortAdapter(paramArrayOfMessagePort[i])); 
    return arrayOfInvocationHandler;
  }
  
  public static MessagePort[] toMessagePorts(InvocationHandler[] paramArrayOfInvocationHandler) {
    if (paramArrayOfInvocationHandler == null)
      return null; 
    MessagePort[] arrayOfMessagePort = new MessagePort[paramArrayOfInvocationHandler.length];
    for (int i = 0; i < paramArrayOfInvocationHandler.length; i++)
      arrayOfMessagePort[i] = ((SupportLibWebMessagePortAdapter)BoundaryInterfaceReflectionUtil.getDelegateFromInvocationHandler(paramArrayOfInvocationHandler[i])).mPort; 
    return arrayOfMessagePort;
  }
  
  public final void close() {
    this.mPort.close();
  }
  
  public final void postMessage(InvocationHandler paramInvocationHandler) {
    WebMessageBoundaryInterface webMessageBoundaryInterface = (WebMessageBoundaryInterface)BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebMessageBoundaryInterface.class, paramInvocationHandler);
    this.mPort.postMessage(webMessageBoundaryInterface.getData(), toMessagePorts(webMessageBoundaryInterface.getPorts()));
  }
  
  public final void setWebMessageCallback(InvocationHandler paramInvocationHandler) {
    setWebMessageCallback(paramInvocationHandler, null);
  }
  
  public final void setWebMessageCallback(InvocationHandler paramInvocationHandler, Handler paramHandler) {
    SupportLibWebMessageCallbackAdapter supportLibWebMessageCallbackAdapter = new SupportLibWebMessageCallbackAdapter((WebMessageCallbackBoundaryInterface)BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebMessageCallbackBoundaryInterface.class, paramInvocationHandler));
    this.mPort.setMessageCallback(new SupportLibWebMessagePortAdapter$1(this, supportLibWebMessageCallbackAdapter), paramHandler);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\support_lib_glue\SupportLibWebMessagePortAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */