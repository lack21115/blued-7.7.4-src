package org.chromium.content.browser.androidoverlay;

import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.view.Surface;
import org.chromium.base.ContextUtils;
import org.chromium.base.ThreadUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.gfx.mojom.Rect;
import org.chromium.media.mojom.AndroidOverlay;
import org.chromium.media.mojom.AndroidOverlayClient;
import org.chromium.media.mojom.AndroidOverlayConfig;
import org.chromium.mojo.system.MojoException;

public class DialogOverlayImpl implements DialogOverlayCore$Host, AndroidOverlay {
  private AndroidOverlayClient mClient;
  
  private boolean mClosed;
  
  private DialogOverlayCore mDialogCore;
  
  private final ThreadHoppingHost mHoppingHost;
  
  private long mNativeHandle;
  
  private Handler mOverlayHandler;
  
  private Runnable mReleaseCoreRunnable;
  
  private Runnable mReleasedRunnable;
  
  private int mSurfaceId;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public DialogOverlayImpl(AndroidOverlayClient paramAndroidOverlayClient, AndroidOverlayConfig paramAndroidOverlayConfig, Handler paramHandler, Runnable paramRunnable, boolean paramBoolean) {
    ThreadUtils.assertOnUiThread();
    this.mClient = paramAndroidOverlayClient;
    this.mReleasedRunnable = paramRunnable;
    this.mOverlayHandler = paramHandler;
    this.mDialogCore = new DialogOverlayCore();
    this.mHoppingHost = new ThreadHoppingHost(this);
    this.mNativeHandle = nativeInit(paramAndroidOverlayConfig.routingToken.high, paramAndroidOverlayConfig.routingToken.low, paramAndroidOverlayConfig.powerEfficient);
    if (this.mNativeHandle == 0L) {
      this.mClient.onDestroyed();
      cleanup();
      return;
    } 
    DialogOverlayCore dialogOverlayCore = this.mDialogCore;
    Context context = ContextUtils.sApplicationContext;
    nativeGetCompositorOffset(this.mNativeHandle, paramAndroidOverlayConfig.rect);
    this.mOverlayHandler.post(new DialogOverlayImpl$1(this, dialogOverlayCore, context, paramAndroidOverlayConfig, paramBoolean));
    this.mReleaseCoreRunnable = new DialogOverlayImpl$2(dialogOverlayCore);
  }
  
  private void cleanup() {
    ThreadUtils.assertOnUiThread();
    if (this.mSurfaceId != 0) {
      nativeUnregisterSurface(this.mSurfaceId);
      this.mSurfaceId = 0;
    } 
    if (this.mNativeHandle != 0L) {
      nativeDestroy(this.mNativeHandle);
      this.mNativeHandle = 0L;
    } 
    this.mDialogCore = null;
    if (this.mClient != null)
      this.mClient.close(); 
    this.mClient = null;
  }
  
  private native void nativeCompleteInit(long paramLong);
  
  private native void nativeDestroy(long paramLong);
  
  private native void nativeGetCompositorOffset(long paramLong, Rect paramRect);
  
  private native long nativeInit(long paramLong1, long paramLong2, boolean paramBoolean);
  
  static native Surface nativeLookupSurfaceForTesting(int paramInt);
  
  private static native int nativeRegisterSurface(Surface paramSurface);
  
  private static native void nativeUnregisterSurface(int paramInt);
  
  @CalledByNative
  private void onPowerEfficientState(boolean paramBoolean) {
    ThreadUtils.assertOnUiThread();
    if (this.mDialogCore == null)
      return; 
    if (this.mClient == null)
      return; 
    this.mClient.onPowerEfficientState(paramBoolean);
  }
  
  @CalledByNative
  private static void receiveCompositorOffset(Rect paramRect, int paramInt1, int paramInt2) {
    paramRect.x += paramInt1;
    paramRect.y += paramInt2;
  }
  
  private void sendWindowTokenToCore(IBinder paramIBinder) {
    ThreadUtils.assertOnUiThread();
    if (this.mDialogCore != null) {
      DialogOverlayCore dialogOverlayCore = this.mDialogCore;
      this.mOverlayHandler.post(new DialogOverlayImpl$4(dialogOverlayCore, paramIBinder));
    } 
  }
  
  public void close() {
    ThreadUtils.assertOnUiThread();
    if (this.mClosed)
      return; 
    this.mClosed = true;
    this.mHoppingHost.mSemaphore.release(1);
    if (this.mReleaseCoreRunnable != null) {
      this.mOverlayHandler.post(this.mReleaseCoreRunnable);
      this.mReleaseCoreRunnable = null;
      cleanup();
    } 
    this.mReleasedRunnable.run();
  }
  
  public final void enforceClose() {
    close();
  }
  
  public final void onConnectionError(MojoException paramMojoException) {
    ThreadUtils.assertOnUiThread();
    close();
  }
  
  @CalledByNative
  public void onDismissed() {
    ThreadUtils.assertOnUiThread();
    if (this.mClient != null)
      this.mClient.onDestroyed(); 
    sendWindowTokenToCore(null);
    cleanup();
  }
  
  public final void onOverlayDestroyed() {
    ThreadUtils.assertOnUiThread();
    if (this.mDialogCore == null)
      return; 
    if (this.mClient != null)
      this.mClient.onDestroyed(); 
    cleanup();
  }
  
  public final void onSurfaceReady(Surface paramSurface) {
    ThreadUtils.assertOnUiThread();
    if (this.mDialogCore != null) {
      if (this.mClient == null)
        return; 
      this.mSurfaceId = nativeRegisterSurface(paramSurface);
      this.mClient.onSurfaceReady(this.mSurfaceId);
      return;
    } 
  }
  
  @CalledByNative
  public void onWindowToken(IBinder paramIBinder) {
    ThreadUtils.assertOnUiThread();
    if (this.mDialogCore == null)
      return; 
    sendWindowTokenToCore(paramIBinder);
  }
  
  public final void scheduleLayout(Rect paramRect) {
    ThreadUtils.assertOnUiThread();
    if (this.mDialogCore == null)
      return; 
    nativeGetCompositorOffset(this.mNativeHandle, paramRect);
    DialogOverlayCore dialogOverlayCore = this.mDialogCore;
    this.mOverlayHandler.post(new DialogOverlayImpl$3(dialogOverlayCore, paramRect));
  }
  
  public final void waitForClose() {
    assert false;
    throw new AssertionError("Not reached");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\androidoverlay\DialogOverlayImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */