package org.chromium.base;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;

final class EarlyTraceEvent$Event {
  final long mBeginThreadTimeMillis;
  
  final long mBeginTimeNanos;
  
  long mEndThreadTimeMillis;
  
  long mEndTimeNanos;
  
  final String mName;
  
  final int mThreadId;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  EarlyTraceEvent$Event(String paramString) {
    this.mName = paramString;
    this.mThreadId = Process.myTid();
    this.mBeginTimeNanos = elapsedRealtimeNanos();
    this.mBeginThreadTimeMillis = SystemClock.currentThreadTimeMillis();
  }
  
  @SuppressLint({"NewApi"})
  static long elapsedRealtimeNanos() {
    return (Build.VERSION.SDK_INT >= 17) ? SystemClock.elapsedRealtimeNanos() : (SystemClock.elapsedRealtime() * 1000000L);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\EarlyTraceEvent$Event.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */