package com.bytedance.tea.crash.g;

import java.util.HashSet;
import java.util.Set;

public final class e {
  private static final Set<String> a = new HashSet<String>();
  
  static {
    a.add("HeapTaskDaemon");
    a.add("ThreadPlus");
    a.add("ApiDispatcher");
    a.add("ApiLocalDispatcher");
    a.add("AsyncLoader");
    a.add("AsyncTask");
    a.add("Binder");
    a.add("PackageProcessor");
    a.add("SettingsObserver");
    a.add("WifiManager");
    a.add("JavaBridge");
    a.add("Compiler");
    a.add("Signal Catcher");
    a.add("GC");
    a.add("ReferenceQueueDaemon");
    a.add("FinalizerDaemon");
    a.add("FinalizerWatchdogDaemon");
    a.add("CookieSyncManager");
    a.add("RefQueueWorker");
    a.add("CleanupReference");
    a.add("VideoManager");
    a.add("DBHelper-AsyncOp");
    a.add("InstalledAppTracker2");
    a.add("AppData-AsyncOp");
    a.add("IdleConnectionMonitor");
    a.add("LogReaper");
    a.add("ActionReaper");
    a.add("Okio Watchdog");
    a.add("CheckWaitingQueue");
    a.add("NPTH-CrashTimer");
    a.add("NPTH-JavaCallback");
    a.add("NPTH-LocalParser");
    a.add("ANR_FILE_MODIFY");
  }
  
  public static Set<String> a() {
    return a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\crash\g\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */