package org.chromium.media.mojom;

import org.chromium.gfx.mojom.Rect;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.system.Core;

final class AndroidOverlay_Internal$Proxy extends Interface.AbstractProxy implements AndroidOverlay$Proxy {
  AndroidOverlay_Internal$Proxy(Core paramCore, MessageReceiverWithResponder paramMessageReceiverWithResponder) {
    super(paramCore, paramMessageReceiverWithResponder);
  }
  
  public final void scheduleLayout(Rect paramRect) {
    AndroidOverlay_Internal$AndroidOverlayScheduleLayoutParams androidOverlay_Internal$AndroidOverlayScheduleLayoutParams = new AndroidOverlay_Internal$AndroidOverlayScheduleLayoutParams((byte)0);
    androidOverlay_Internal$AndroidOverlayScheduleLayoutParams.rect = paramRect;
    this.mHandler.mMessageReceiver.accept((Message)androidOverlay_Internal$AndroidOverlayScheduleLayoutParams.serializeWithHeader(this.mHandler.mCore, new MessageHeader(0)));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\mojom\AndroidOverlay_Internal$Proxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */