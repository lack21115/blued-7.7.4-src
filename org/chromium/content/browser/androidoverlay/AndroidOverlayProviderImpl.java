package org.chromium.content.browser.androidoverlay;

import android.os.Handler;
import android.os.HandlerThread;
import org.chromium.base.ThreadUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.media.mojom.AndroidOverlayClient;
import org.chromium.media.mojom.AndroidOverlayConfig;
import org.chromium.media.mojom.AndroidOverlayProvider;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.system.MojoException;

public class AndroidOverlayProviderImpl implements AndroidOverlayProvider {
  private Handler mHandler;
  
  private Runnable mNotifyReleasedRunnable = new AndroidOverlayProviderImpl$1(this);
  
  private int mNumOverlays;
  
  private HandlerThread mOverlayUiThread;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  @CalledByNative
  private static boolean areOverlaysSupported() {
    return true;
  }
  
  public void close() {}
  
  public final void createOverlay(InterfaceRequest paramInterfaceRequest, AndroidOverlayClient paramAndroidOverlayClient, AndroidOverlayConfig paramAndroidOverlayConfig) {
    ThreadUtils.assertOnUiThread();
    if (this.mNumOverlays > 0) {
      paramAndroidOverlayClient.onDestroyed();
      paramAndroidOverlayClient.close();
      return;
    } 
    if (this.mOverlayUiThread == null) {
      this.mOverlayUiThread = new HandlerThread("AndroidOverlayThread");
      this.mOverlayUiThread.start();
      this.mHandler = new Handler(this.mOverlayUiThread.getLooper());
    } 
    this.mNumOverlays++;
    DialogOverlayImpl dialogOverlayImpl = new DialogOverlayImpl(paramAndroidOverlayClient, paramAndroidOverlayConfig, this.mHandler, this.mNotifyReleasedRunnable, false);
    DialogOverlayImpl.MANAGER.bind((Interface)dialogOverlayImpl, paramInterfaceRequest);
  }
  
  public final void onConnectionError(MojoException paramMojoException) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\androidoverlay\AndroidOverlayProviderImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */