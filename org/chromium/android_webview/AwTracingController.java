package org.chromium.android_webview;

import android.text.TextUtils;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.chromium.base.annotations.CalledByNative;

public class AwTracingController {
  private static final List CATEGORIES_ALL_LIST = new ArrayList(Arrays.asList((Object[])new String[] { "*" }));
  
  private static final List CATEGORIES_ANDROID_WEBVIEW_LIST = new ArrayList(Arrays.asList((Object[])new String[] { "android_webview", "Java", "toplevel" }));
  
  private static final List CATEGORIES_FRAME_VIEWER_LIST;
  
  private static final List CATEGORIES_INPUT_LATENCY_LIST;
  
  private static final List CATEGORIES_JAVASCRIPT_AND_RENDERING_LIST;
  
  private static final List CATEGORIES_RENDERING_LIST;
  
  private static final List CATEGORIES_WEB_DEVELOPER_LIST = new ArrayList(Arrays.asList((Object[])new String[] { "blink", "cc", "netlog", "renderer.scheduler", "toplevel", "v8" }));
  
  private static final List PREDEFINED_CATEGORIES_LIST;
  
  public long mNativeAwTracingController = nativeInit();
  
  private OutputStream mOutputStream;
  
  static {
    CATEGORIES_INPUT_LATENCY_LIST = new ArrayList(Arrays.asList((Object[])new String[] { "benchmark", "input", "evdev", "renderer.scheduler", "toplevel" }));
    CATEGORIES_RENDERING_LIST = new ArrayList(Arrays.asList((Object[])new String[] { "blink", "cc", "gpu", "toplevel" }));
    CATEGORIES_JAVASCRIPT_AND_RENDERING_LIST = new ArrayList(Arrays.asList((Object[])new String[] { "blink", "cc", "gpu", "renderer.scheduler", "v8", "toplevel" }));
    CATEGORIES_FRAME_VIEWER_LIST = new ArrayList(Arrays.asList((Object[])new String[] { "blink", "cc", "gpu", "renderer.scheduler", "v8", "toplevel", "disabled-by-default-cc.debug", "disabled-by-default-cc.debug.picture", "disabled-by-default-cc.debug.display_items" }));
    PREDEFINED_CATEGORIES_LIST = new ArrayList(Arrays.asList((Object[])new List[] { CATEGORIES_ALL_LIST, CATEGORIES_ANDROID_WEBVIEW_LIST, CATEGORIES_WEB_DEVELOPER_LIST, CATEGORIES_INPUT_LATENCY_LIST, CATEGORIES_RENDERING_LIST, CATEGORIES_JAVASCRIPT_AND_RENDERING_LIST, CATEGORIES_FRAME_VIEWER_LIST }));
    throw new VerifyError("bad dex opcode");
  }
  
  public static String constructCategoryFilterString(Collection paramCollection1, Collection paramCollection2) {
    HashSet<String> hashSet = new HashSet();
    Iterator<Integer> iterator = paramCollection1.iterator();
    while (iterator.hasNext()) {
      int i = ((Integer)iterator.next()).intValue();
      hashSet.addAll(PREDEFINED_CATEGORIES_LIST.get(i));
    } 
    hashSet.addAll(paramCollection2);
    if (hashSet.isEmpty())
      hashSet.add("-*"); 
    return TextUtils.join(",", hashSet);
  }
  
  public static boolean isValid(Collection paramCollection) {
    Iterator<String> iterator = paramCollection.iterator();
    while (true) {
      boolean bool1 = iterator.hasNext();
      boolean bool = true;
      if (bool1) {
        String str = iterator.next();
        if (str.startsWith("-") || str.contains(","))
          bool = false; 
        if (!bool)
          return false; 
        continue;
      } 
      return true;
    } 
  }
  
  public static boolean isValidMode(int paramInt) {
    return (paramInt != 0) ? ((paramInt == 1)) : true;
  }
  
  private native long nativeInit();
  
  private native boolean nativeIsTracing(long paramLong);
  
  private native boolean nativeStopAndFlush(long paramLong);
  
  @CalledByNative
  private void onTraceDataChunkReceived(byte[] paramArrayOfbyte) {
    if (this.mOutputStream != null)
      this.mOutputStream.write(paramArrayOfbyte); 
  }
  
  @CalledByNative
  private void onTraceDataComplete() {
    if (this.mOutputStream != null)
      this.mOutputStream.close(); 
  }
  
  public final boolean isTracing() {
    return nativeIsTracing(this.mNativeAwTracingController);
  }
  
  public native boolean nativeStart(long paramLong, String paramString, int paramInt);
  
  public final boolean stopAndFlush(OutputStream paramOutputStream) {
    if (!isTracing())
      return false; 
    this.mOutputStream = paramOutputStream;
    nativeStopAndFlush(this.mNativeAwTracingController);
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwTracingController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */