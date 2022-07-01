package androidx.core.os;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.Method;

public final class TraceCompat {
  private static long a;
  
  private static Method b;
  
  private static Method c;
  
  private static Method d;
  
  private static Method e;
  
  static {
    if (Build.VERSION.SDK_INT >= 18 && Build.VERSION.SDK_INT < 29)
      try {
        a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
        b = Trace.class.getMethod("isTagEnabled", new Class[] { long.class });
        c = Trace.class.getMethod("asyncTraceBegin", new Class[] { long.class, String.class, int.class });
        d = Trace.class.getMethod("asyncTraceEnd", new Class[] { long.class, String.class, int.class });
        e = Trace.class.getMethod("traceCounter", new Class[] { long.class, String.class, int.class });
        return;
      } catch (Exception exception) {
        Log.i("TraceCompat", "Unable to initialize via reflection.", exception);
      }  
  }
  
  public static void beginAsyncSection(String paramString, int paramInt) {
    if (Build.VERSION.SDK_INT >= 29) {
      Trace.beginAsyncSection(paramString, paramInt);
      return;
    } 
    if (Build.VERSION.SDK_INT >= 18)
      try {
        c.invoke(null, new Object[] { Long.valueOf(a), paramString, Integer.valueOf(paramInt) });
        return;
      } catch (Exception exception) {
        Log.v("TraceCompat", "Unable to invoke asyncTraceBegin() via reflection.");
      }  
  }
  
  public static void beginSection(String paramString) {
    if (Build.VERSION.SDK_INT >= 18)
      Trace.beginSection(paramString); 
  }
  
  public static void endAsyncSection(String paramString, int paramInt) {
    if (Build.VERSION.SDK_INT >= 29) {
      Trace.endAsyncSection(paramString, paramInt);
      return;
    } 
    if (Build.VERSION.SDK_INT >= 18)
      try {
        d.invoke(null, new Object[] { Long.valueOf(a), paramString, Integer.valueOf(paramInt) });
        return;
      } catch (Exception exception) {
        Log.v("TraceCompat", "Unable to invoke endAsyncSection() via reflection.");
      }  
  }
  
  public static void endSection() {
    if (Build.VERSION.SDK_INT >= 18)
      Trace.endSection(); 
  }
  
  public static boolean isEnabled() {
    if (Build.VERSION.SDK_INT >= 29)
      return Trace.isEnabled(); 
    if (Build.VERSION.SDK_INT >= 18)
      try {
        return ((Boolean)b.invoke(null, new Object[] { Long.valueOf(a) })).booleanValue();
      } catch (Exception exception) {
        Log.v("TraceCompat", "Unable to invoke isTagEnabled() via reflection.");
      }  
    return false;
  }
  
  public static void setCounter(String paramString, int paramInt) {
    if (Build.VERSION.SDK_INT >= 29) {
      Trace.setCounter(paramString, paramInt);
      return;
    } 
    if (Build.VERSION.SDK_INT >= 18)
      try {
        e.invoke(null, new Object[] { Long.valueOf(a), paramString, Integer.valueOf(paramInt) });
        return;
      } catch (Exception exception) {
        Log.v("TraceCompat", "Unable to invoke traceCounter() via reflection.");
      }  
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\os\TraceCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */