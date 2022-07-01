package org.chromium.content_public.browser;

import android.content.Intent;
import android.view.ActionMode;
import android.view.textclassifier.TextClassifier;

public interface SelectionPopupController {
  ActionModeCallbackHelper getActionModeCallbackHelper();
  
  SelectionClient$ResultCallback getResultCallback();
  
  TextClassifier getTextClassifier();
  
  void onReceivedProcessTextResult(int paramInt, Intent paramIntent);
  
  void setActionModeCallback(ActionMode.Callback paramCallback);
  
  void setNonSelectionActionModeCallback(ActionMode.Callback paramCallback);
  
  void setSelectionClient(SelectionClient paramSelectionClient);
  
  void setTextClassifier(TextClassifier paramTextClassifier);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content_public\browser\SelectionPopupController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */