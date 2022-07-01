package org.chromium.base;

import android.os.Process;
import android.os.SystemClock;
import java.util.List;
import java.util.Map;

public class EarlyTraceEvent {
  private static List sAsyncEvents;
  
  private static List sCompletedEvents;
  
  private static final Object sLock = new Object();
  
  private static List sPendingAsyncEvents;
  
  private static Map sPendingEventByKey;
  
  private static volatile int sState = 0;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static void begin(String paramString) {
    if (!enabled())
      return; 
    EarlyTraceEvent$Event earlyTraceEvent$Event = new EarlyTraceEvent$Event(paramString);
    synchronized (sLock) {
      if (!enabled())
        return; 
      EarlyTraceEvent$Event earlyTraceEvent$Event1 = sPendingEventByKey.put(makeEventKeyForCurrentThread(paramString), earlyTraceEvent$Event);
      if (earlyTraceEvent$Event1 == null)
        return; 
      throw new IllegalArgumentException("Multiple pending trace events can't have the same name");
    } 
  }
  
  static void disable() {
    synchronized (sLock) {
      if (!enabled())
        return; 
      sState = 2;
      maybeFinishLocked();
      return;
    } 
  }
  
  static boolean enabled() {
    return (sState == 1);
  }
  
  public static void end(String paramString) {
    if (!isActive())
      return; 
    synchronized (sLock) {
      if (!isActive())
        return; 
      EarlyTraceEvent$Event earlyTraceEvent$Event = (EarlyTraceEvent$Event)sPendingEventByKey.remove(makeEventKeyForCurrentThread(paramString));
      if (earlyTraceEvent$Event == null)
        return; 
      if (EarlyTraceEvent$Event.$assertionsDisabled || earlyTraceEvent$Event.mEndTimeNanos == 0L) {
        if (EarlyTraceEvent$Event.$assertionsDisabled || earlyTraceEvent$Event.mEndThreadTimeMillis == 0L) {
          earlyTraceEvent$Event.mEndTimeNanos = EarlyTraceEvent$Event.elapsedRealtimeNanos();
          earlyTraceEvent$Event.mEndThreadTimeMillis = SystemClock.currentThreadTimeMillis();
          sCompletedEvents.add(earlyTraceEvent$Event);
          if (sState == 2)
            maybeFinishLocked(); 
          return;
        } 
        throw new AssertionError();
      } 
      throw new AssertionError();
    } 
  }
  
  private static long getOffsetNanos() {
    return TimeUtils.nativeGetTimeTicksNowUs() * 1000L - EarlyTraceEvent$Event.elapsedRealtimeNanos();
  }
  
  static boolean isActive() {
    int i = sState;
    return (i != 1) ? ((i == 2)) : true;
  }
  
  private static String makeEventKeyForCurrentThread(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("@");
    stringBuilder.append(Process.myTid());
    return stringBuilder.toString();
  }
  
  private static void maybeFinishLocked() {
    if (!sCompletedEvents.isEmpty()) {
      List list = sCompletedEvents;
      long l = getOffsetNanos();
      for (EarlyTraceEvent$Event earlyTraceEvent$Event : list)
        nativeRecordEarlyEvent(earlyTraceEvent$Event.mName, earlyTraceEvent$Event.mBeginTimeNanos + l, earlyTraceEvent$Event.mEndTimeNanos + l, earlyTraceEvent$Event.mThreadId, earlyTraceEvent$Event.mEndThreadTimeMillis - earlyTraceEvent$Event.mBeginThreadTimeMillis); 
      sCompletedEvents.clear();
    } 
    if (!sAsyncEvents.isEmpty()) {
      List list = sAsyncEvents;
      long l = getOffsetNanos();
      for (EarlyTraceEvent$AsyncEvent earlyTraceEvent$AsyncEvent : list) {
        if (earlyTraceEvent$AsyncEvent.mIsStart) {
          nativeRecordEarlyStartAsyncEvent(earlyTraceEvent$AsyncEvent.mName, earlyTraceEvent$AsyncEvent.mId, earlyTraceEvent$AsyncEvent.mTimestampNanos + l);
          continue;
        } 
        nativeRecordEarlyFinishAsyncEvent(earlyTraceEvent$AsyncEvent.mName, earlyTraceEvent$AsyncEvent.mId, earlyTraceEvent$AsyncEvent.mTimestampNanos + l);
      } 
      sAsyncEvents.clear();
    } 
    if (sPendingEventByKey.isEmpty() && sPendingAsyncEvents.isEmpty()) {
      sState = 3;
      sPendingEventByKey = null;
      sCompletedEvents = null;
      sPendingAsyncEvents = null;
      sAsyncEvents = null;
    } 
  }
  
  private static native void nativeRecordEarlyEvent(String paramString, long paramLong1, long paramLong2, int paramInt, long paramLong3);
  
  private static native void nativeRecordEarlyFinishAsyncEvent(String paramString, long paramLong1, long paramLong2);
  
  private static native void nativeRecordEarlyStartAsyncEvent(String paramString, long paramLong1, long paramLong2);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\EarlyTraceEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */