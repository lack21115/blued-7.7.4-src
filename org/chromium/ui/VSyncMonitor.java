package org.chromium.ui;

import android.content.Context;
import android.os.Handler;
import android.view.Choreographer;
import android.view.WindowManager;

public class VSyncMonitor {
  public final Choreographer mChoreographer;
  
  public boolean mConsecutiveVSync;
  
  private long mGoodStartingPointNano;
  
  public final Handler mHandler;
  
  public boolean mHaveRequestInFlight;
  
  public boolean mInsideVSync;
  
  private VSyncMonitor$Listener mListener;
  
  public long mRefreshPeriodNano;
  
  public final Choreographer.FrameCallback mVSyncFrameCallback;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public VSyncMonitor(Context paramContext, VSyncMonitor$Listener paramVSyncMonitor$Listener) {
    boolean bool;
    this.mHandler = new Handler();
    this.mListener = paramVSyncMonitor$Listener;
    float f2 = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getRefreshRate();
    if (f2 < 30.0F) {
      bool = true;
    } else {
      bool = false;
    } 
    float f1 = f2;
    if (f2 <= 0.0F)
      f1 = 60.0F; 
    this.mRefreshPeriodNano = (long)(1.0E9F / f1);
    this.mChoreographer = Choreographer.getInstance();
    this.mVSyncFrameCallback = new VSyncMonitor$1(this, bool);
    this.mGoodStartingPointNano = System.nanoTime();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\VSyncMonitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */