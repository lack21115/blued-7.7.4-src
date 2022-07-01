package org.chromium.base;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.util.Log;

final class TraceEvent$IdleTracingLooperMonitor extends TraceEvent$BasicLooperMonitor implements MessageQueue.IdleHandler {
  private boolean mIdleMonitorAttached;
  
  private long mLastIdleStartedAt;
  
  private long mLastWorkStartedAt;
  
  private int mNumIdlesSeen;
  
  private int mNumTasksSeen;
  
  private int mNumTasksSinceLastIdle;
  
  private TraceEvent$IdleTracingLooperMonitor() {
    super((byte)0);
  }
  
  private final void syncIdleMonitoring() {
    if (TraceEvent.access$000() && !this.mIdleMonitorAttached) {
      this.mLastIdleStartedAt = SystemClock.elapsedRealtime();
      Looper.myQueue().addIdleHandler(this);
      this.mIdleMonitorAttached = true;
      return;
    } 
    if (this.mIdleMonitorAttached && !TraceEvent.access$000()) {
      Looper.myQueue().removeIdleHandler(this);
      this.mIdleMonitorAttached = false;
    } 
  }
  
  private static void traceAndLog(int paramInt, String paramString) {
    TraceEvent.instant("TraceEvent.LooperMonitor:IdleStats", paramString);
    Log.println(paramInt, "TraceEvent.LooperMonitor", paramString);
  }
  
  final void beginHandling(String paramString) {
    if (this.mNumTasksSinceLastIdle == 0)
      TraceEvent.end("Looper.queueIdle"); 
    this.mLastWorkStartedAt = SystemClock.elapsedRealtime();
    syncIdleMonitoring();
    super.beginHandling(paramString);
  }
  
  final void endHandling(String paramString) {
    long l = SystemClock.elapsedRealtime() - this.mLastWorkStartedAt;
    if (l > 16L) {
      StringBuilder stringBuilder = new StringBuilder("observed a task that took ");
      stringBuilder.append(l);
      stringBuilder.append("ms: ");
      stringBuilder.append(paramString);
      traceAndLog(5, stringBuilder.toString());
    } 
    super.endHandling(paramString);
    syncIdleMonitoring();
    this.mNumTasksSeen++;
    this.mNumTasksSinceLastIdle++;
  }
  
  public final boolean queueIdle() {
    long l1 = SystemClock.elapsedRealtime();
    if (this.mLastIdleStartedAt == 0L)
      this.mLastIdleStartedAt = l1; 
    long l2 = l1 - this.mLastIdleStartedAt;
    this.mNumIdlesSeen++;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.mNumTasksSinceLastIdle);
    stringBuilder.append(" tasks since last idle.");
    TraceEvent.begin("Looper.queueIdle", stringBuilder.toString());
    if (l2 > 48L) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(this.mNumTasksSeen);
      stringBuilder.append(" tasks and ");
      stringBuilder.append(this.mNumIdlesSeen);
      stringBuilder.append(" idles processed so far, ");
      stringBuilder.append(this.mNumTasksSinceLastIdle);
      stringBuilder.append(" tasks bursted and ");
      stringBuilder.append(l2);
      stringBuilder.append("ms elapsed since last idle");
      traceAndLog(3, stringBuilder.toString());
    } 
    this.mLastIdleStartedAt = l1;
    this.mNumTasksSinceLastIdle = 0;
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\TraceEvent$IdleTracingLooperMonitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */