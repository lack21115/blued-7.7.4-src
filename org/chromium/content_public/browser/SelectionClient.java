package org.chromium.content_public.browser;

import android.view.textclassifier.TextClassifier;

public interface SelectionClient {
  void cancelAllRequests();
  
  SelectionMetricsLogger getSelectionMetricsLogger();
  
  TextClassifier getTextClassifier();
  
  boolean requestSelectionPopupUpdates(boolean paramBoolean);
  
  void setTextClassifier(TextClassifier paramTextClassifier);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content_public\browser\SelectionClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */