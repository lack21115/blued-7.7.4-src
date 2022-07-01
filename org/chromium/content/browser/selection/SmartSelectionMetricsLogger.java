package org.chromium.content.browser.selection;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.chromium.content_public.browser.SelectionClient;
import org.chromium.content_public.browser.SelectionMetricsLogger;

@TargetApi(26)
public final class SmartSelectionMetricsLogger implements SelectionMetricsLogger {
  private static Method sLogEventMethod;
  
  private static boolean sReflectionFailed;
  
  private static Class sSelectionEventClass;
  
  private static Class sTrackerClass;
  
  private static Constructor sTrackerConstructor;
  
  Context mContext;
  
  SelectionIndicesConverter mConverter;
  
  SmartSelectionMetricsLogger$SelectionEventProxy mSelectionEventProxy;
  
  Object mTracker;
  
  private SmartSelectionMetricsLogger(Context paramContext, SmartSelectionMetricsLogger$SelectionEventProxy paramSmartSelectionMetricsLogger$SelectionEventProxy) {
    this.mContext = paramContext;
    this.mSelectionEventProxy = paramSmartSelectionMetricsLogger$SelectionEventProxy;
  }
  
  public static SmartSelectionMetricsLogger create(Context paramContext) {
    if (Build.VERSION.SDK_INT > 26 && paramContext != null) {
      if (sReflectionFailed)
        return null; 
      if (sTrackerClass == null)
        try {
          sTrackerClass = Class.forName("android.view.textclassifier.logging.SmartSelectionEventTracker");
          sSelectionEventClass = Class.forName("android.view.textclassifier.logging.SmartSelectionEventTracker$SelectionEvent");
          sTrackerConstructor = sTrackerClass.getConstructor(new Class[] { Context.class, int.class });
          sLogEventMethod = sTrackerClass.getMethod("logEvent", new Class[] { sSelectionEventClass });
        } catch (ClassNotFoundException|NoSuchMethodException classNotFoundException) {
          sReflectionFailed = true;
          return null;
        }  
      SelectionEventProxyImpl selectionEventProxyImpl = SelectionEventProxyImpl.create();
      return (selectionEventProxyImpl == null) ? null : new SmartSelectionMetricsLogger((Context)classNotFoundException, selectionEventProxyImpl);
    } 
    return null;
  }
  
  public static Object createTracker(Context paramContext, boolean paramBoolean) {
    try {
      Constructor<Context> constructor = sTrackerConstructor;
      byte b = 2;
      if (paramBoolean)
        b = 4; 
      return constructor.newInstance(new Object[] { paramContext, Integer.valueOf(b) });
    } catch (ReflectiveOperationException reflectiveOperationException) {
      return null;
    } 
  }
  
  public final void logEvent(Object paramObject) {
    if (paramObject == null)
      return; 
    try {
      sLogEventMethod.invoke(this.mTracker, new Object[] { sSelectionEventClass.cast(paramObject) });
      return;
    } catch (ClassCastException|ReflectiveOperationException classCastException) {
      return;
    } 
  }
  
  public final void logSelectionAction(String paramString, int paramInt1, int paramInt2, SelectionClient.Result paramResult) {
    if (this.mTracker == null)
      return; 
    if (!this.mConverter.updateSelectionState(paramString, paramInt1)) {
      this.mTracker = null;
      return;
    } 
    int i = paramString.length();
    int[] arrayOfInt = new int[2];
    if (!this.mConverter.getWordDelta(paramInt1, i + paramInt1, arrayOfInt)) {
      this.mTracker = null;
      return;
    } 
    paramInt1 = 1;
    if (paramResult != null && paramResult.textClassification != null) {
      logEvent(this.mSelectionEventProxy.createSelectionAction(arrayOfInt[0], arrayOfInt[1], paramInt2, paramResult.textClassification));
    } else {
      logEvent(this.mSelectionEventProxy.createSelectionAction(arrayOfInt[0], arrayOfInt[1], paramInt2));
    } 
    switch (paramInt2) {
      default:
        paramInt1 = 0;
        break;
      case 100:
      case 101:
      case 102:
      case 103:
      case 104:
      case 105:
      case 106:
      case 107:
      case 108:
        break;
    } 
    if (paramInt1 != 0)
      this.mTracker = null; 
  }
  
  public final void logSelectionModified(String paramString, int paramInt, SelectionClient.Result paramResult) {
    if (this.mTracker == null)
      return; 
    if (!this.mConverter.updateSelectionState(paramString, paramInt)) {
      this.mTracker = null;
      return;
    } 
    int i = paramString.length();
    int[] arrayOfInt = new int[2];
    if (!this.mConverter.getWordDelta(paramInt, i + paramInt, arrayOfInt)) {
      this.mTracker = null;
      return;
    } 
    if (paramResult != null && paramResult.textSelection != null) {
      logEvent(this.mSelectionEventProxy.createSelectionModifiedSelection(arrayOfInt[0], arrayOfInt[1], paramResult.textSelection));
      return;
    } 
    if (paramResult != null && paramResult.textClassification != null) {
      logEvent(this.mSelectionEventProxy.createSelectionModifiedClassification(arrayOfInt[0], arrayOfInt[1], paramResult.textClassification));
      return;
    } 
    logEvent(this.mSelectionEventProxy.createSelectionModified(arrayOfInt[0], arrayOfInt[1]));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\selection\SmartSelectionMetricsLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */