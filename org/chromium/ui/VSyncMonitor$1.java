package org.chromium.ui;

import android.view.Choreographer;
import org.chromium.base.TraceEvent;

final class VSyncMonitor$1 implements Choreographer.FrameCallback {
  public final void doFrame(long paramLong) {
    TraceEvent.begin("VSync");
    if (useEstimatedRefreshPeriod && VSyncMonitor.access$000(VSyncMonitor.this)) {
      long l = VSyncMonitor.access$100(VSyncMonitor.this);
      VSyncMonitor.access$214(VSyncMonitor.this, (long)((float)(paramLong - l - VSyncMonitor.access$200(VSyncMonitor.this)) * 0.1F));
    } 
    VSyncMonitor.access$102(VSyncMonitor.this, paramLong);
    VSyncMonitor vSyncMonitor = VSyncMonitor.this;
    VSyncMonitor.access$300$7b14289e();
    VSyncMonitor.access$400$69d7392(vSyncMonitor, paramLong);
    TraceEvent.end("VSync");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\VSyncMonitor$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */