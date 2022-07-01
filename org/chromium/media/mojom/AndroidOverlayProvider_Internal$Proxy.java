package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.system.Core;

final class AndroidOverlayProvider_Internal$Proxy extends Interface.AbstractProxy implements AndroidOverlayProvider$Proxy {
  AndroidOverlayProvider_Internal$Proxy(Core paramCore, MessageReceiverWithResponder paramMessageReceiverWithResponder) {
    super(paramCore, paramMessageReceiverWithResponder);
  }
  
  public final void createOverlay(InterfaceRequest paramInterfaceRequest, AndroidOverlayClient paramAndroidOverlayClient, AndroidOverlayConfig paramAndroidOverlayConfig) {
    AndroidOverlayProvider_Internal$AndroidOverlayProviderCreateOverlayParams androidOverlayProvider_Internal$AndroidOverlayProviderCreateOverlayParams = new AndroidOverlayProvider_Internal$AndroidOverlayProviderCreateOverlayParams((byte)0);
    androidOverlayProvider_Internal$AndroidOverlayProviderCreateOverlayParams.overlay = paramInterfaceRequest;
    androidOverlayProvider_Internal$AndroidOverlayProviderCreateOverlayParams.client = paramAndroidOverlayClient;
    androidOverlayProvider_Internal$AndroidOverlayProviderCreateOverlayParams.config = paramAndroidOverlayConfig;
    this.mHandler.mMessageReceiver.accept((Message)androidOverlayProvider_Internal$AndroidOverlayProviderCreateOverlayParams.serializeWithHeader(this.mHandler.mCore, new MessageHeader(0)));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\mojom\AndroidOverlayProvider_Internal$Proxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */