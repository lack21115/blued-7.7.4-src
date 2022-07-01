package com.android.webview.chromium;

import android.annotation.SuppressLint;
import android.webkit.TracingConfig;
import android.webkit.TracingController;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import org.chromium.android_webview.AwTracingController;
import org.chromium.base.ThreadUtils;

@SuppressLint({"NewApi", "Override"})
public final class TracingControllerAdapter extends TracingController {
  private final AwTracingController mAwTracingController;
  
  private final WebViewChromiumFactoryProvider mFactory;
  
  public TracingControllerAdapter(WebViewChromiumFactoryProvider paramWebViewChromiumFactoryProvider, AwTracingController paramAwTracingController) {
    this.mFactory = paramWebViewChromiumFactoryProvider;
    this.mAwTracingController = paramAwTracingController;
  }
  
  private static boolean categoryIsSet(int paramInt1, int paramInt2) {
    return ((paramInt1 & paramInt2) == paramInt2);
  }
  
  private static boolean checkNeedsPost() {
    return !ThreadUtils.runningOnUiThread();
  }
  
  private int startOnUI(TracingConfig paramTracingConfig) {
    AwTracingController awTracingController = this.mAwTracingController;
    int i = paramTracingConfig.getPredefinedCategories();
    ArrayList<Integer> arrayList = new ArrayList();
    if (categoryIsSet(i, 1))
      arrayList.add(Integer.valueOf(0)); 
    if (categoryIsSet(i, 2))
      arrayList.add(Integer.valueOf(1)); 
    if (categoryIsSet(i, 4))
      arrayList.add(Integer.valueOf(2)); 
    if (categoryIsSet(i, 8))
      arrayList.add(Integer.valueOf(3)); 
    if (categoryIsSet(i, 16))
      arrayList.add(Integer.valueOf(4)); 
    if (categoryIsSet(i, 32))
      arrayList.add(Integer.valueOf(5)); 
    if (categoryIsSet(i, 64))
      arrayList.add(Integer.valueOf(6)); 
    List list = paramTracingConfig.getCustomIncludedCategories();
    switch (paramTracingConfig.getTracingMode()) {
      default:
        i = 1;
        break;
      case 1:
        i = 1;
        break;
      case 0:
        i = 0;
        break;
    } 
    if (awTracingController.isTracing())
      return 1; 
    if (!AwTracingController.isValid(list))
      return 2; 
    if (!AwTracingController.isValidMode(i))
      return 3; 
    String str = AwTracingController.constructCategoryFilterString(arrayList, list);
    awTracingController.nativeStart(awTracingController.mNativeAwTracingController, str, i);
    return 0;
  }
  
  public final boolean isTracing() {
    return checkNeedsPost() ? ((Boolean)this.mFactory.runOnUiThreadBlocking(new TracingControllerAdapter$3(this))).booleanValue() : this.mAwTracingController.isTracing();
  }
  
  public final void start(TracingConfig paramTracingConfig) {
    if (paramTracingConfig != null) {
      int i;
      if (checkNeedsPost()) {
        i = ((Integer)this.mFactory.runOnUiThreadBlocking(new TracingControllerAdapter$1(this, paramTracingConfig))).intValue();
      } else {
        i = startOnUI(paramTracingConfig);
      } 
      if (i != 0) {
        switch (i) {
          default:
            return;
          case 3:
            throw new IllegalArgumentException("invalid tracing mode");
          case 2:
            throw new IllegalArgumentException("category patterns starting with '-' or containing ',' are not allowed");
          case 1:
            break;
        } 
        throw new IllegalStateException("cannot start tracing: tracing is already enabled");
      } 
      return;
    } 
    throw new IllegalArgumentException("tracingConfig cannot be null");
  }
  
  public final boolean stop(OutputStream paramOutputStream, Executor paramExecutor) {
    return checkNeedsPost() ? ((Boolean)this.mFactory.runOnUiThreadBlocking(new TracingControllerAdapter$2(this, paramOutputStream, paramExecutor))).booleanValue() : stopOnUI(paramOutputStream, paramExecutor);
  }
  
  public final boolean stopOnUI(OutputStream paramOutputStream, Executor paramExecutor) {
    return (paramOutputStream == null) ? this.mAwTracingController.stopAndFlush(null) : this.mAwTracingController.stopAndFlush(new TracingControllerAdapter$4(paramExecutor, paramOutputStream));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\TracingControllerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */