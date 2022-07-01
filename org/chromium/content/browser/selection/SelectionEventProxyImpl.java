package org.chromium.content.browser.selection;

import android.annotation.TargetApi;
import android.view.textclassifier.TextClassification;
import android.view.textclassifier.TextSelection;
import java.lang.reflect.Method;

@TargetApi(26)
public final class SelectionEventProxyImpl implements SmartSelectionMetricsLogger$SelectionEventProxy {
  private static boolean sReflectionFailed = false;
  
  private static Method sSelectionActionClassificationMethod;
  
  private static Method sSelectionActionMethod;
  
  private static Class sSelectionEventClass;
  
  private static Method sSelectionModifiedClassificationMethod;
  
  private static Method sSelectionModifiedMethod;
  
  private static Method sSelectionModifiedSelectionMethod;
  
  private static Method sSelectionStartedMethod;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static SelectionEventProxyImpl create() {
    if (sReflectionFailed)
      return null; 
    if (sSelectionEventClass == null)
      try {
        Class<?> clazz = Class.forName("android.view.textclassifier.logging.SmartSelectionEventTracker$SelectionEvent");
        sSelectionEventClass = clazz;
        sSelectionStartedMethod = clazz.getMethod("selectionStarted", new Class[] { int.class });
        sSelectionModifiedMethod = sSelectionEventClass.getMethod("selectionModified", new Class[] { int.class, int.class });
        sSelectionModifiedClassificationMethod = sSelectionEventClass.getMethod("selectionModified", new Class[] { int.class, int.class, TextClassification.class });
        sSelectionModifiedSelectionMethod = sSelectionEventClass.getMethod("selectionModified", new Class[] { int.class, int.class, TextSelection.class });
        sSelectionActionMethod = sSelectionEventClass.getMethod("selectionAction", new Class[] { int.class, int.class, int.class });
        sSelectionActionClassificationMethod = sSelectionEventClass.getMethod("selectionAction", new Class[] { int.class, int.class, int.class, TextClassification.class });
      } catch (ClassNotFoundException|NoSuchMethodException classNotFoundException) {
        sReflectionFailed = true;
        return null;
      }  
    return new SelectionEventProxyImpl();
  }
  
  public final Object createSelectionAction(int paramInt1, int paramInt2, int paramInt3) {
    try {
      return sSelectionActionMethod.invoke(null, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    } catch (ReflectiveOperationException reflectiveOperationException) {
      return null;
    } 
  }
  
  public final Object createSelectionAction(int paramInt1, int paramInt2, int paramInt3, Object paramObject) {
    try {
      return sSelectionActionClassificationMethod.invoke(null, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramObject });
    } catch (ReflectiveOperationException reflectiveOperationException) {
      return null;
    } 
  }
  
  public final Object createSelectionModified(int paramInt1, int paramInt2) {
    try {
      return sSelectionModifiedMethod.invoke(null, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    } catch (ReflectiveOperationException reflectiveOperationException) {
      return null;
    } 
  }
  
  public final Object createSelectionModifiedClassification(int paramInt1, int paramInt2, Object paramObject) {
    try {
      return sSelectionModifiedClassificationMethod.invoke(null, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramObject });
    } catch (ReflectiveOperationException reflectiveOperationException) {
      return null;
    } 
  }
  
  public final Object createSelectionModifiedSelection(int paramInt1, int paramInt2, Object paramObject) {
    try {
      return sSelectionModifiedSelectionMethod.invoke(null, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramObject });
    } catch (ReflectiveOperationException reflectiveOperationException) {
      return null;
    } 
  }
  
  public final Object createSelectionStarted(int paramInt) {
    try {
      return sSelectionStartedMethod.invoke(null, new Object[] { Integer.valueOf(paramInt) });
    } catch (ReflectiveOperationException reflectiveOperationException) {
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\selection\SelectionEventProxyImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */