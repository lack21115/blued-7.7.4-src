package org.chromium.content.browser.selection;

import java.text.BreakIterator;
import java.util.regex.Pattern;

public class SelectionIndicesConverter {
  private static final Pattern PATTERN_WHITESPACE;
  
  private String mGlobalSelectionText;
  
  private int mGlobalStartOffset;
  
  int mInitialStartOffset;
  
  private String mLastSelectionText;
  
  private int mLastStartOffset;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private int countWordsBackward(int paramInt1, int paramInt2, BreakIterator paramBreakIterator) {
    assert false;
    throw new AssertionError();
  }
  
  private int countWordsForward(int paramInt1, int paramInt2, BreakIterator paramBreakIterator) {
    assert false;
    throw new AssertionError();
  }
  
  private boolean isWhitespace(int paramInt1, int paramInt2) {
    return PATTERN_WHITESPACE.matcher(this.mGlobalSelectionText.substring(paramInt1, paramInt2)).matches();
  }
  
  private void updateGlobalSelection(String paramString, int paramInt) {
    this.mGlobalSelectionText = paramString;
    this.mGlobalStartOffset = paramInt;
  }
  
  private void updateLastSelection(String paramString, int paramInt) {
    this.mLastSelectionText = paramString;
    this.mLastStartOffset = paramInt;
  }
  
  public final boolean getWordDelta(int paramInt1, int paramInt2, int[] paramArrayOfint) {
    assert false;
    throw new AssertionError();
  }
  
  public final boolean updateSelectionState(String paramString, int paramInt) {
    boolean bool;
    if (this.mGlobalSelectionText == null) {
      updateLastSelection(paramString, paramInt);
      updateGlobalSelection(paramString, paramInt);
      return true;
    } 
    int j = paramString.length() + paramInt;
    int k = this.mLastStartOffset + this.mLastSelectionText.length();
    int i = this.mLastStartOffset;
    if ((i <= paramInt) ? (paramInt < k) : (j > i)) {
      i = 1;
    } else {
      i = 0;
    } 
    if (i != 0) {
      i = Math.max(this.mLastStartOffset, paramInt);
      int m = Math.min(k, j);
      bool = this.mLastSelectionText.regionMatches(i - this.mLastStartOffset, paramString, i - paramInt, m - i);
    } else {
      bool = false;
    } 
    if (this.mLastStartOffset == j || k == paramInt)
      bool = true; 
    if (!bool) {
      this.mGlobalSelectionText = null;
      this.mLastSelectionText = null;
      return false;
    } 
    updateLastSelection(paramString, paramInt);
    i = paramString.length();
    j = this.mGlobalStartOffset + this.mGlobalSelectionText.length();
    if (paramInt < this.mGlobalStartOffset) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString.substring(0, this.mGlobalStartOffset - paramInt));
      stringBuilder.append(this.mGlobalSelectionText);
      updateGlobalSelection(stringBuilder.toString(), paramInt);
    } 
    if (i + paramInt > j) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.mGlobalSelectionText);
      stringBuilder.append(paramString.substring(j - paramInt, paramString.length()));
      updateGlobalSelection(stringBuilder.toString(), this.mGlobalStartOffset);
    } 
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\selection\SelectionIndicesConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */