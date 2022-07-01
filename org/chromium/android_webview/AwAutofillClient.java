package org.chromium.android_webview;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.components.autofill.AutofillPopup;
import org.chromium.components.autofill.AutofillSuggestion;
import org.chromium.ui.DropdownAdapter;
import org.chromium.ui.DropdownPopupWindow;
import org.chromium.ui.base.WindowAndroid;

public class AwAutofillClient {
  private AutofillPopup mAutofillPopup;
  
  Context mContext;
  
  private final long mNativeAwAutofillClient;
  
  private AwAutofillClient(long paramLong) {
    this.mNativeAwAutofillClient = paramLong;
  }
  
  @CalledByNative
  private static void addToAutofillSuggestionArray(AutofillSuggestion[] paramArrayOfAutofillSuggestion, int paramInt1, String paramString1, String paramString2, int paramInt2) {
    paramArrayOfAutofillSuggestion[paramInt1] = new AutofillSuggestion(paramString1, paramString2, 0, false, paramInt2, false, false, false);
  }
  
  @CalledByNative
  public static AwAutofillClient create(long paramLong) {
    return new AwAutofillClient(paramLong);
  }
  
  @CalledByNative
  private static AutofillSuggestion[] createAutofillSuggestionArray(int paramInt) {
    return new AutofillSuggestion[paramInt];
  }
  
  private native void nativeDismissed(long paramLong);
  
  private native void nativeSuggestionSelected(long paramLong, int paramInt);
  
  @CalledByNative
  private void showAutofillPopup(View paramView, boolean paramBoolean, AutofillSuggestion[] paramArrayOfAutofillSuggestion) {
    if (this.mAutofillPopup == null) {
      if (WindowAndroid.activityFromContext(this.mContext) == null) {
        nativeDismissed(this.mNativeAwAutofillClient);
        return;
      } 
      try {
        this.mAutofillPopup = new AutofillPopup(this.mContext, paramView, new AwAutofillClient$1(this));
      } catch (RuntimeException runtimeException) {
        nativeDismissed(this.mNativeAwAutofillClient);
        return;
      } 
    } 
    AutofillPopup autofillPopup = this.mAutofillPopup;
    autofillPopup.mSuggestions = new ArrayList(Arrays.asList((Object[])paramArrayOfAutofillSuggestion));
    ArrayList<AutofillSuggestion> arrayList = new ArrayList();
    HashSet<Integer> hashSet = new HashSet();
    int i;
    for (i = 0; i < paramArrayOfAutofillSuggestion.length; i++) {
      if ((paramArrayOfAutofillSuggestion[i]).mSuggestionId == -3) {
        hashSet.add(Integer.valueOf(arrayList.size()));
      } else {
        arrayList.add(paramArrayOfAutofillSuggestion[i]);
      } 
    } 
    autofillPopup.setAdapter((ListAdapter)new DropdownAdapter(autofillPopup.mContext, arrayList, hashSet));
    autofillPopup.setRtl(paramBoolean);
    ((DropdownPopupWindow)autofillPopup).mPopup.show();
    autofillPopup.getListView().setOnItemLongClickListener((AdapterView.OnItemLongClickListener)autofillPopup);
    autofillPopup.getListView().setAccessibilityDelegate((View.AccessibilityDelegate)new Object(autofillPopup));
  }
  
  @CalledByNative
  public void hideAutofillPopup() {
    if (this.mAutofillPopup == null)
      return; 
    this.mAutofillPopup.dismiss();
    this.mAutofillPopup = null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwAutofillClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */