package org.chromium.content.browser.framehost;

import org.chromium.base.Callback;
import org.chromium.base.UnguessableToken;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.content_public.browser.RenderFrameHost;
import org.chromium.mojo.system.impl.CoreImpl;
import org.chromium.services.service_manager.InterfaceProvider;

public class RenderFrameHostImpl implements RenderFrameHost {
  private final RenderFrameHostDelegate mDelegate;
  
  private RenderFrameHostImpl(RenderFrameHostDelegate paramRenderFrameHostDelegate, int paramInt) {
    this.mDelegate = paramRenderFrameHostDelegate;
    new InterfaceProvider(CoreImpl.getInstance().acquireNativeHandle(paramInt).toMessagePipeHandle());
    this.mDelegate.renderFrameCreated(this);
  }
  
  @CalledByNative
  private void clearNativePtr() {
    this.mDelegate.renderFrameDeleted(this);
  }
  
  @CalledByNative
  private static RenderFrameHostImpl create(long paramLong, RenderFrameHostDelegate paramRenderFrameHostDelegate, boolean paramBoolean, int paramInt) {
    return new RenderFrameHostImpl(paramRenderFrameHostDelegate, paramInt);
  }
  
  private native UnguessableToken nativeGetAndroidOverlayRoutingToken(long paramLong);
  
  private native void nativeGetCanonicalUrlForSharing(long paramLong, Callback paramCallback);
  
  private native String nativeGetLastCommittedURL(long paramLong);
  
  private native void nativeNotifyUserActivation(long paramLong);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\framehost\RenderFrameHostImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */