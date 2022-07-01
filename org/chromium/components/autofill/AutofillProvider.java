package org.chromium.components.autofill;

import android.util.SparseArray;
import android.view.ViewGroup;
import android.view.ViewStructure;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.content_public.browser.WebContents;

public abstract class AutofillProvider {
  public abstract void autofill(SparseArray paramSparseArray);
  
  public native void nativeOnAutofillAvailable(long paramLong, FormData paramFormData);
  
  public abstract void onContainerViewChanged(ViewGroup paramViewGroup);
  
  @CalledByNative
  public abstract void onDidFillAutofillFormData();
  
  @CalledByNative
  public abstract void onFocusChanged(boolean paramBoolean, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  @CalledByNative
  public abstract void onFormFieldDidChange(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  @CalledByNative
  public abstract void onFormSubmitted(int paramInt);
  
  public abstract void onProvideAutoFillVirtualStructure$6304a4bd(ViewStructure paramViewStructure);
  
  @CalledByNative
  public abstract void onTextFieldDidScroll(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  public abstract void queryAutofillSuggestion();
  
  @CalledByNative
  public abstract void reset();
  
  @CalledByNative
  public abstract void setNativeAutofillProvider(long paramLong);
  
  public abstract void setWebContents(WebContents paramWebContents);
  
  public abstract boolean shouldQueryAutofillSuggestion();
  
  @CalledByNative
  public abstract void startAutofillSession(FormData paramFormData, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\components\autofill\AutofillProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */