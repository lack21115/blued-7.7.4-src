package org.chromium.content.browser.selection;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.LocaleList;
import android.view.textclassifier.TextClassification;
import android.view.textclassifier.TextClassifier;
import android.view.textclassifier.TextSelection;
import java.util.Locale;
import org.chromium.base.AsyncTask;
import org.chromium.content_public.browser.SelectionClient;

@TargetApi(26)
final class SmartSelectionProvider$ClassificationTask extends AsyncTask {
  private final Locale[] mLocales;
  
  private final int mOriginalEnd;
  
  private final int mOriginalStart;
  
  private final int mRequestType;
  
  private final CharSequence mText;
  
  private final TextClassifier mTextClassifier;
  
  SmartSelectionProvider$ClassificationTask(TextClassifier paramTextClassifier, int paramInt1, CharSequence paramCharSequence, int paramInt2, int paramInt3, Locale[] paramArrayOfLocale) {
    this.mTextClassifier = paramTextClassifier;
    this.mRequestType = paramInt1;
    this.mText = paramCharSequence;
    this.mOriginalStart = paramInt2;
    this.mOriginalEnd = paramInt3;
    this.mLocales = paramArrayOfLocale;
  }
  
  @SuppressLint({"NewApi"})
  private static LocaleList makeLocaleList(Locale[] paramArrayOfLocale) {
    return (paramArrayOfLocale == null || paramArrayOfLocale.length == 0) ? null : new LocaleList(paramArrayOfLocale);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\selection\SmartSelectionProvider$ClassificationTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */