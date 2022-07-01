package org.chromium.components.spellcheck;

import android.os.SystemClock;
import android.view.textservice.SentenceSuggestionsInfo;
import android.view.textservice.SpellCheckerSession;
import android.view.textservice.SuggestionsInfo;
import android.view.textservice.TextInfo;
import android.view.textservice.TextServicesManager;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.chromium.base.ContextUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.metrics.RecordHistogram;

public class SpellCheckerSessionBridge implements SpellCheckerSession.SpellCheckerSessionListener {
  private long mNativeSpellCheckerSessionBridge;
  
  private final SpellCheckerSession mSpellCheckerSession;
  
  private long mStartMs;
  
  private long mStopMs;
  
  private SpellCheckerSessionBridge(long paramLong) {
    this.mNativeSpellCheckerSessionBridge = paramLong;
    this.mSpellCheckerSession = ((TextServicesManager)ContextUtils.sApplicationContext.getSystemService("textservices")).newSpellCheckerSession(null, null, this, true);
  }
  
  private static int[] convertListToArray(ArrayList paramArrayList) {
    int[] arrayOfInt = new int[paramArrayList.size()];
    for (int i = 0; i < arrayOfInt.length; i++)
      arrayOfInt[i] = ((Integer)paramArrayList.get(i)).intValue(); 
    return arrayOfInt;
  }
  
  @CalledByNative
  private static SpellCheckerSessionBridge create(long paramLong) {
    SpellCheckerSessionBridge spellCheckerSessionBridge = new SpellCheckerSessionBridge(paramLong);
    return (spellCheckerSessionBridge.mSpellCheckerSession == null) ? null : spellCheckerSessionBridge;
  }
  
  @CalledByNative
  private void disconnect() {
    this.mNativeSpellCheckerSessionBridge = 0L;
    this.mSpellCheckerSession.cancel();
    this.mSpellCheckerSession.close();
  }
  
  private native void nativeProcessSpellCheckResults(long paramLong, int[] paramArrayOfint1, int[] paramArrayOfint2, String[][] paramArrayOfString);
  
  @CalledByNative
  private void requestTextCheck(String paramString) {
    String str = paramString;
    if (paramString.endsWith("."))
      str = paramString.substring(0, paramString.length() - 1); 
    this.mStartMs = SystemClock.elapsedRealtime();
    this.mSpellCheckerSession.getSentenceSuggestions(new TextInfo[] { new TextInfo(str) }, 0);
  }
  
  public void onGetSentenceSuggestions(SentenceSuggestionsInfo[] paramArrayOfSentenceSuggestionsInfo) {
    this.mStopMs = SystemClock.elapsedRealtime();
    if (this.mNativeSpellCheckerSessionBridge == 0L)
      return; 
    ArrayList<Integer> arrayList1 = new ArrayList();
    ArrayList<Integer> arrayList2 = new ArrayList();
    ArrayList<String[]> arrayList = new ArrayList();
    int j = paramArrayOfSentenceSuggestionsInfo.length;
    for (int i = 0; i < j; i++) {
      SentenceSuggestionsInfo sentenceSuggestionsInfo = paramArrayOfSentenceSuggestionsInfo[i];
      if (sentenceSuggestionsInfo != null)
        for (int k = 0; k < sentenceSuggestionsInfo.getSuggestionsCount(); k++) {
          if ((sentenceSuggestionsInfo.getSuggestionsInfoAt(k).getSuggestionsAttributes() & 0x2) == 2) {
            arrayList1.add(Integer.valueOf(sentenceSuggestionsInfo.getOffsetAt(k)));
            arrayList2.add(Integer.valueOf(sentenceSuggestionsInfo.getLengthAt(k)));
            SuggestionsInfo suggestionsInfo = sentenceSuggestionsInfo.getSuggestionsInfoAt(k);
            ArrayList<String> arrayList3 = new ArrayList();
            int m;
            for (m = 0; m < suggestionsInfo.getSuggestionsCount(); m++) {
              String str2 = suggestionsInfo.getSuggestionAt(m);
              String str1 = str2;
              if (str2.charAt(str2.length() - 1) == '​')
                str1 = str2.substring(0, str2.length() - 1); 
              arrayList3.add(str1);
            } 
            arrayList.add(arrayList3.<String>toArray(new String[arrayList3.size()]));
          } 
        }  
    } 
    nativeProcessSpellCheckResults(this.mNativeSpellCheckerSessionBridge, convertListToArray(arrayList1), convertListToArray(arrayList2), arrayList.<String[]>toArray(new String[arrayList.size()][]));
    RecordHistogram.recordTimesHistogram("SpellCheck.Android.Latency", this.mStopMs - this.mStartMs, TimeUnit.MILLISECONDS);
  }
  
  public void onGetSuggestions(SuggestionsInfo[] paramArrayOfSuggestionsInfo) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\components\spellcheck\SpellCheckerSessionBridge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */