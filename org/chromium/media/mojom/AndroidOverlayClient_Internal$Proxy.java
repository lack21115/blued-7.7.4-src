package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.system.Core;

final class AndroidOverlayClient_Internal$Proxy extends Interface.AbstractProxy implements AndroidOverlayClient$Proxy {
  AndroidOverlayClient_Internal$Proxy(Core paramCore, MessageReceiverWithResponder paramMessageReceiverWithResponder) {
    super(paramCore, paramMessageReceiverWithResponder);
  }
  
  public final void onDestroyed() {
    AndroidOverlayClient_Internal$AndroidOverlayClientOnDestroyedParams androidOverlayClient_Internal$AndroidOverlayClientOnDestroyedParams = new AndroidOverlayClient_Internal$AndroidOverlayClientOnDestroyedParams((byte)0);
    this.mHandler.mMessageReceiver.accept((Message)androidOverlayClient_Internal$AndroidOverlayClientOnDestroyedParams.serializeWithHeader(this.mHandler.mCore, new MessageHeader(1)));
  }
  
  public final void onPowerEfficientState(boolean paramBoolean) {
    AndroidOverlayClient_Internal$AndroidOverlayClientOnPowerEfficientStateParams androidOverlayClient_Internal$AndroidOverlayClientOnPowerEfficientStateParams = new AndroidOverlayClient_Internal$AndroidOverlayClientOnPowerEfficientStateParams((byte)0);
    androidOverlayClient_Internal$AndroidOverlayClientOnPowerEfficientStateParams.isPowerEfficient = paramBoolean;
    this.mHandler.mMessageReceiver.accept((Message)androidOverlayClient_Internal$AndroidOverlayClientOnPowerEfficientStateParams.serializeWithHeader(this.mHandler.mCore, new MessageHeader(2)));
  }
  
  public final void onSurfaceReady(long paramLong) {
    AndroidOverlayClient_Internal$AndroidOverlayClientOnSurfaceReadyParams androidOverlayClient_Internal$AndroidOverlayClientOnSurfaceReadyParams = new AndroidOverlayClient_Internal$AndroidOverlayClientOnSurfaceReadyParams((byte)0);
    androidOverlayClient_Internal$AndroidOverlayClientOnSurfaceReadyParams.surfaceKey = paramLong;
    this.mHandler.mMessageReceiver.accept((Message)androidOverlayClient_Internal$AndroidOverlayClientOnSurfaceReadyParams.serializeWithHeader(this.mHandler.mCore, new MessageHeader(0)));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\mojom\AndroidOverlayClient_Internal$Proxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */