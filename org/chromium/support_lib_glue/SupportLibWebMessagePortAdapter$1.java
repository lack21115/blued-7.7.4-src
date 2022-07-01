package org.chromium.support_lib_glue;

import org.chromium.content_public.browser.MessagePort;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

final class SupportLibWebMessagePortAdapter$1 implements MessagePort.MessageCallback {
  public final void onMessage(String paramString, MessagePort[] paramArrayOfMessagePort) {
    SupportLibWebMessageCallbackAdapter supportLibWebMessageCallbackAdapter = callbackAdapter;
    SupportLibWebMessagePortAdapter supportLibWebMessagePortAdapter = SupportLibWebMessagePortAdapter.this;
    SupportLibWebMessagePortAdapter$SupportLibWebMessageAdapter supportLibWebMessagePortAdapter$SupportLibWebMessageAdapter = new SupportLibWebMessagePortAdapter$SupportLibWebMessageAdapter(paramString, paramArrayOfMessagePort);
    if (BoundaryInterfaceReflectionUtil.containsFeature(supportLibWebMessageCallbackAdapter.mImpl.getSupportedFeatures(), "WEB_MESSAGE_CALLBACK_ON_MESSAGE"))
      supportLibWebMessageCallbackAdapter.mImpl.onMessage(BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(supportLibWebMessagePortAdapter), BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(supportLibWebMessagePortAdapter$SupportLibWebMessageAdapter)); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\support_lib_glue\SupportLibWebMessagePortAdapter$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */