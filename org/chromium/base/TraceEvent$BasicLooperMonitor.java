package org.chromium.base;

import android.util.Printer;

class TraceEvent$BasicLooperMonitor implements Printer {
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private TraceEvent$BasicLooperMonitor() {}
  
  private static String getTarget(String paramString) {
    int i;
    int j = paramString.indexOf('(', 21);
    if (j == -1) {
      i = -1;
    } else {
      i = paramString.indexOf(')', j);
    } 
    return (i != -1) ? paramString.substring(j + 1, i) : "";
  }
  
  void beginHandling(String paramString) {
    boolean bool = EarlyTraceEvent.isActive();
    if (TraceEvent.access$000() || bool) {
      paramString = getTarget(paramString);
      if (TraceEvent.access$000()) {
        TraceEvent.access$100(paramString);
        return;
      } 
      if (bool) {
        StringBuilder stringBuilder = new StringBuilder("Looper.dispatchMessage: ");
        stringBuilder.append(paramString);
        EarlyTraceEvent.begin(stringBuilder.toString());
      } 
    } 
  }
  
  void endHandling(String paramString) {
    if (EarlyTraceEvent.isActive()) {
      StringBuilder stringBuilder = new StringBuilder("Looper.dispatchMessage: ");
      stringBuilder.append(getTarget(paramString));
      EarlyTraceEvent.end(stringBuilder.toString());
    } 
    if (TraceEvent.access$000())
      TraceEvent.access$200(); 
  }
  
  public void println(String paramString) {
    if (paramString.startsWith(">")) {
      beginHandling(paramString);
      return;
    } 
    assert false;
    throw new AssertionError();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\TraceEvent$BasicLooperMonitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */