package org.chromium.content.browser.input;

import org.chromium.base.annotations.CalledByNative;

public class SuggestionInfo {
  final int mMarkerTag;
  
  final String mPrefix;
  
  final String mSuffix;
  
  final String mSuggestion;
  
  final int mSuggestionIndex;
  
  private SuggestionInfo(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3) {
    this.mMarkerTag = paramInt1;
    this.mSuggestionIndex = paramInt2;
    this.mPrefix = paramString1;
    this.mSuggestion = paramString2;
    this.mSuffix = paramString3;
  }
  
  @CalledByNative
  private static SuggestionInfo[] createArray(int paramInt) {
    return new SuggestionInfo[paramInt];
  }
  
  @CalledByNative
  private static void createSuggestionInfoAndPutInArray(SuggestionInfo[] paramArrayOfSuggestionInfo, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3) {
    paramArrayOfSuggestionInfo[paramInt1] = new SuggestionInfo(paramInt2, paramInt3, paramString1, paramString2, paramString3);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\input\SuggestionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */