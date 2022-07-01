package org.chromium.content.browser.selection;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler;
import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import java.util.Locale;
import org.chromium.content_public.browser.SelectionClient;
import org.chromium.ui.base.WindowAndroid;

public final class SmartSelectionProvider {
  private SmartSelectionProvider$ClassificationTask mClassificationTask;
  
  private Runnable mFailureResponseRunnable;
  
  private Handler mHandler;
  
  SelectionClient.ResultCallback mResultCallback;
  
  TextClassifier mTextClassifier;
  
  private WindowAndroid mWindowAndroid;
  
  public SmartSelectionProvider(SelectionClient.ResultCallback paramResultCallback, WindowAndroid paramWindowAndroid) {
    this.mResultCallback = paramResultCallback;
    this.mWindowAndroid = paramWindowAndroid;
    this.mHandler = new Handler();
    this.mFailureResponseRunnable = new SmartSelectionProvider$1(this);
  }
  
  public final void cancelAllRequests() {
    if (this.mClassificationTask != null) {
      this.mClassificationTask.cancel(false);
      this.mClassificationTask = null;
    } 
  }
  
  @SuppressLint({"WrongConstant"})
  @TargetApi(26)
  public final TextClassifier getTextClassifier() {
    if (this.mTextClassifier != null)
      return this.mTextClassifier; 
    Context context = this.mWindowAndroid.getContext().get();
    return (context == null) ? null : ((TextClassificationManager)context.getSystemService("textclassification")).getTextClassifier();
  }
  
  @TargetApi(26)
  final void sendSmartSelectionRequest(int paramInt1, CharSequence paramCharSequence, int paramInt2, int paramInt3, Locale[] paramArrayOfLocale) {
    TextClassifier textClassifier = getTextClassifier();
    if (textClassifier == null || textClassifier == TextClassifier.NO_OP) {
      this.mHandler.post(this.mFailureResponseRunnable);
      return;
    } 
    if (this.mClassificationTask != null) {
      this.mClassificationTask.cancel(false);
      this.mClassificationTask = null;
    } 
    this.mClassificationTask = new SmartSelectionProvider$ClassificationTask(this, textClassifier, paramInt1, paramCharSequence, paramInt2, paramInt3, paramArrayOfLocale);
    this.mClassificationTask.execute((Object[])new Void[0]);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\selection\SmartSelectionProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */