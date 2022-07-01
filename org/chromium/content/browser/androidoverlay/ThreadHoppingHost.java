package org.chromium.content.browser.androidoverlay;

import android.os.Handler;
import android.view.Surface;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

final class ThreadHoppingHost implements DialogOverlayCore$Host {
  private Handler mHandler = new Handler();
  
  final DialogOverlayCore$Host mHost;
  
  final Semaphore mSemaphore = new Semaphore(0);
  
  public ThreadHoppingHost(DialogOverlayCore$Host paramDialogOverlayCore$Host) {
    this.mHost = paramDialogOverlayCore$Host;
  }
  
  public final void enforceClose() {
    this.mHandler.post(new ThreadHoppingHost$3(this));
  }
  
  public final void onOverlayDestroyed() {
    this.mHandler.post(new ThreadHoppingHost$2(this));
  }
  
  public final void onSurfaceReady(Surface paramSurface) {
    this.mHandler.post(new ThreadHoppingHost$1(this, paramSurface));
  }
  
  public final void waitForClose() {
    while (true) {
      try {
        this.mSemaphore.tryAcquire(2L, TimeUnit.SECONDS);
        return;
      } catch (InterruptedException interruptedException) {}
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\androidoverlay\ThreadHoppingHost.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */