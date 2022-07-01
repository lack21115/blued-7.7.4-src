package org.chromium.content.browser.input;

import android.content.Context;
import android.os.Build;
import android.os.IBinder;
import android.os.ResultReceiver;
import android.os.StrictMode;
import android.view.View;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.InputMethodManager;
import org.chromium.content_public.browser.InputMethodManagerWrapper;

public final class InputMethodManagerWrapperImpl implements InputMethodManagerWrapper {
  private final Context mContext;
  
  public InputMethodManagerWrapperImpl(Context paramContext) {
    this.mContext = paramContext;
  }
  
  private InputMethodManager getInputMethodManager() {
    return (InputMethodManager)this.mContext.getSystemService("input_method");
  }
  
  public final boolean hideSoftInputFromWindow(IBinder paramIBinder, int paramInt, ResultReceiver paramResultReceiver) {
    StrictMode.ThreadPolicy threadPolicy = StrictMode.allowThreadDiskWrites();
    try {
      InputMethodManager inputMethodManager = getInputMethodManager();
      if (inputMethodManager != null) {
        boolean bool = inputMethodManager.hideSoftInputFromWindow(paramIBinder, paramInt, paramResultReceiver);
        if (bool) {
          bool = true;
          return bool;
        } 
      } 
      return false;
    } finally {
      StrictMode.setThreadPolicy(threadPolicy);
    } 
  }
  
  public final boolean isActive(View paramView) {
    InputMethodManager inputMethodManager = getInputMethodManager();
    return (inputMethodManager != null && inputMethodManager.isActive(paramView));
  }
  
  public final void notifyUserAction() {
    if (Build.VERSION.SDK_INT > 23)
      return; 
    InputMethodManager inputMethodManager = getInputMethodManager();
    if (inputMethodManager == null)
      return; 
    try {
      InputMethodManager.class.getMethod("notifyUserAction", new Class[0]).invoke(inputMethodManager, new Object[0]);
      return;
    } catch (NoSuchMethodException|IllegalAccessException|IllegalArgumentException|java.lang.reflect.InvocationTargetException noSuchMethodException) {
      return;
    } 
  }
  
  public final void restartInput(View paramView) {
    InputMethodManager inputMethodManager = getInputMethodManager();
    if (inputMethodManager == null)
      return; 
    inputMethodManager.restartInput(paramView);
  }
  
  public final void showSoftInput(View paramView, int paramInt, ResultReceiver paramResultReceiver) {
    StrictMode.ThreadPolicy threadPolicy = StrictMode.allowThreadDiskWrites();
    try {
      InputMethodManager inputMethodManager = getInputMethodManager();
      if (inputMethodManager != null)
        inputMethodManager.showSoftInput(paramView, paramInt, paramResultReceiver); 
      return;
    } finally {
      StrictMode.setThreadPolicy(threadPolicy);
    } 
  }
  
  public final void updateCursorAnchorInfo(View paramView, CursorAnchorInfo paramCursorAnchorInfo) {
    if (Build.VERSION.SDK_INT >= 21) {
      InputMethodManager inputMethodManager = getInputMethodManager();
      if (inputMethodManager == null)
        return; 
      inputMethodManager.updateCursorAnchorInfo(paramView, paramCursorAnchorInfo);
    } 
  }
  
  public final void updateExtractedText(View paramView, int paramInt, ExtractedText paramExtractedText) {
    InputMethodManager inputMethodManager = getInputMethodManager();
    if (inputMethodManager == null)
      return; 
    inputMethodManager.updateExtractedText(paramView, paramInt, paramExtractedText);
  }
  
  public final void updateSelection(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    InputMethodManager inputMethodManager = getInputMethodManager();
    if (inputMethodManager == null)
      return; 
    inputMethodManager.updateSelection(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\input\InputMethodManagerWrapperImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */