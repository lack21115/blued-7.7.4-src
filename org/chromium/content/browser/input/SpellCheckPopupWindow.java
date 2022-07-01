package org.chromium.content.browser.input;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import org.chromium.ui.base.WindowAndroid;

public final class SpellCheckPopupWindow extends SuggestionsPopupWindow {
  private String[] mSuggestions = new String[0];
  
  public SpellCheckPopupWindow(Context paramContext, TextSuggestionHost paramTextSuggestionHost, WindowAndroid paramWindowAndroid, View paramView) {
    super(paramContext, paramTextSuggestionHost, paramWindowAndroid, paramView);
  }
  
  protected final void applySuggestion(int paramInt) {
    TextSuggestionHost textSuggestionHost = this.mTextSuggestionHost;
    String str = this.mSuggestions[paramInt];
    textSuggestionHost.nativeApplySpellCheckSuggestion(textSuggestionHost.mNativeTextSuggestionHost, str);
  }
  
  protected final Object getSuggestionItem(int paramInt) {
    return this.mSuggestions[paramInt];
  }
  
  protected final SpannableString getSuggestionText(int paramInt) {
    return new SpannableString(this.mSuggestions[paramInt]);
  }
  
  protected final int getSuggestionsCount() {
    return this.mSuggestions.length;
  }
  
  public final void show(double paramDouble1, double paramDouble2, String paramString, String[] paramArrayOfString) {
    this.mSuggestions = (String[])paramArrayOfString.clone();
    setAddToDictionaryEnabled(true);
    show(paramDouble1, paramDouble2, paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\input\SpellCheckPopupWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */