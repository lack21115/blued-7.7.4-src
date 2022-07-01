package org.chromium.content_public.browser;

import android.annotation.TargetApi;
import android.os.IBinder;
import android.os.ResultReceiver;
import android.view.View;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.ExtractedText;

public interface InputMethodManagerWrapper {
  boolean hideSoftInputFromWindow(IBinder paramIBinder, int paramInt, ResultReceiver paramResultReceiver);
  
  boolean isActive(View paramView);
  
  void notifyUserAction();
  
  void restartInput(View paramView);
  
  void showSoftInput(View paramView, int paramInt, ResultReceiver paramResultReceiver);
  
  @TargetApi(21)
  void updateCursorAnchorInfo(View paramView, CursorAnchorInfo paramCursorAnchorInfo);
  
  void updateExtractedText(View paramView, int paramInt, ExtractedText paramExtractedText);
  
  void updateSelection(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content_public\browser\InputMethodManagerWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */