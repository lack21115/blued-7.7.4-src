package org.chromium.content.browser.input;

import android.text.TextUtils;
import java.util.Locale;

public class TextInputState {
  final Range mComposition;
  
  final boolean mReplyToRequest;
  
  final Range mSelection;
  
  final boolean mSingleLine;
  
  final CharSequence mText;
  
  public TextInputState(CharSequence paramCharSequence, Range paramRange1, Range paramRange2, boolean paramBoolean1, boolean paramBoolean2) {
    paramRange1.clamp(0, paramCharSequence.length());
    if (paramRange2.mStart != -1 || paramRange2.mEnd != -1)
      paramRange2.clamp(0, paramCharSequence.length()); 
    this.mText = paramCharSequence;
    this.mSelection = paramRange1;
    this.mComposition = paramRange2;
    this.mSingleLine = paramBoolean1;
    this.mReplyToRequest = paramBoolean2;
  }
  
  public boolean equals(Object paramObject) {
    if (!(paramObject instanceof TextInputState))
      return false; 
    paramObject = paramObject;
    return (paramObject == this) ? true : ((TextUtils.equals(this.mText, ((TextInputState)paramObject).mText) && this.mSelection.equals(((TextInputState)paramObject).mSelection) && this.mComposition.equals(((TextInputState)paramObject).mComposition) && this.mSingleLine == ((TextInputState)paramObject).mSingleLine && this.mReplyToRequest == ((TextInputState)paramObject).mReplyToRequest));
  }
  
  public int hashCode() {
    byte b1;
    int i = this.mText.hashCode();
    int j = this.mSelection.hashCode();
    int k = this.mComposition.hashCode();
    boolean bool = this.mSingleLine;
    byte b2 = 0;
    if (bool) {
      b1 = 19;
    } else {
      b1 = 0;
    } 
    if (this.mReplyToRequest)
      b2 = 23; 
    return i * 7 + j * 11 + k * 13 + b1 + b2;
  }
  
  public boolean shouldUnblock() {
    return false;
  }
  
  public String toString() {
    String str1;
    String str2;
    Locale locale = Locale.US;
    CharSequence charSequence = this.mText;
    Range range1 = this.mSelection;
    Range range2 = this.mComposition;
    if (this.mSingleLine) {
      str1 = "SIN";
    } else {
      str1 = "MUL";
    } 
    if (this.mReplyToRequest) {
      str2 = " ReplyToRequest";
    } else {
      str2 = "";
    } 
    return String.format(locale, "TextInputState {[%s] SEL%s COM%s %s%s}", new Object[] { charSequence, range1, range2, str1, str2 });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\input\TextInputState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */