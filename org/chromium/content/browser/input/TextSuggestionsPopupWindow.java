package org.chromium.content.browser.input;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import org.chromium.content.R;
import org.chromium.ui.base.WindowAndroid;

public final class TextSuggestionsPopupWindow extends SuggestionsPopupWindow {
  private TextAppearanceSpan mPrefixSpan;
  
  private TextAppearanceSpan mSuffixSpan;
  
  private SuggestionInfo[] mSuggestionInfos;
  
  public TextSuggestionsPopupWindow(Context paramContext, TextSuggestionHost paramTextSuggestionHost, WindowAndroid paramWindowAndroid, View paramView) {
    super(paramContext, paramTextSuggestionHost, paramWindowAndroid, paramView);
    this.mPrefixSpan = new TextAppearanceSpan(paramContext, R.style.SuggestionPrefixOrSuffix);
    this.mSuffixSpan = new TextAppearanceSpan(paramContext, R.style.SuggestionPrefixOrSuffix);
  }
  
  protected final void applySuggestion(int paramInt) {
    SuggestionInfo suggestionInfo = this.mSuggestionInfos[paramInt];
    TextSuggestionHost textSuggestionHost = this.mTextSuggestionHost;
    paramInt = suggestionInfo.mMarkerTag;
    int i = suggestionInfo.mSuggestionIndex;
    textSuggestionHost.nativeApplyTextSuggestion(textSuggestionHost.mNativeTextSuggestionHost, paramInt, i);
  }
  
  protected final Object getSuggestionItem(int paramInt) {
    return this.mSuggestionInfos[paramInt];
  }
  
  protected final SpannableString getSuggestionText(int paramInt) {
    SuggestionInfo suggestionInfo = this.mSuggestionInfos[paramInt];
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(suggestionInfo.mPrefix);
    stringBuilder.append(suggestionInfo.mSuggestion);
    stringBuilder.append(suggestionInfo.mSuffix);
    SpannableString spannableString = new SpannableString(stringBuilder.toString());
    spannableString.setSpan(this.mPrefixSpan, 0, suggestionInfo.mPrefix.length(), 33);
    spannableString.setSpan(this.mSuffixSpan, suggestionInfo.mPrefix.length() + suggestionInfo.mSuggestion.length(), suggestionInfo.mPrefix.length() + suggestionInfo.mSuggestion.length() + suggestionInfo.mSuffix.length(), 33);
    return spannableString;
  }
  
  protected final int getSuggestionsCount() {
    return this.mSuggestionInfos.length;
  }
  
  public final void show(double paramDouble1, double paramDouble2, String paramString, SuggestionInfo[] paramArrayOfSuggestionInfo) {
    this.mSuggestionInfos = (SuggestionInfo[])paramArrayOfSuggestionInfo.clone();
    setAddToDictionaryEnabled(false);
    show(paramDouble1, paramDouble2, paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\input\TextSuggestionsPopupWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */