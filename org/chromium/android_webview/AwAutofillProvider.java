package org.chromium.android_webview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.autofill.AutofillValue;
import org.chromium.base.BuildInfo;
import org.chromium.base.metrics.RecordHistogram;
import org.chromium.components.autofill.AutofillProvider;
import org.chromium.components.autofill.FormData;
import org.chromium.components.autofill.FormFieldData;
import org.chromium.content_public.browser.WebContents;

@TargetApi(26)
public class AwAutofillProvider extends AutofillProvider {
  private AwAutofillManager mAutofillManager;
  
  private long mAutofillTriggeredTimeMillis;
  
  private AwAutofillUMA mAutofillUMA;
  
  private ViewGroup mContainerView;
  
  private AwAutofillManager$InputUIObserver mInputUIObserver;
  
  private long mNativeAutofillProvider;
  
  private AwAutofillProvider$AutofillRequest mRequest;
  
  private WebContents mWebContents;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public AwAutofillProvider(Context paramContext, ViewGroup paramViewGroup) {
    this(paramViewGroup, new AwAutofillManager(paramContext), paramContext);
  }
  
  private AwAutofillProvider(ViewGroup paramViewGroup, AwAutofillManager paramAwAutofillManager, Context paramContext) {
    assert false;
    throw new AssertionError();
  }
  
  private void notifyFormValues() {
    if (this.mRequest == null)
      return; 
    for (int i = 0; i < this.mRequest.mFormData.mFields.size(); i++)
      notifyVirtualValueChanged(i); 
  }
  
  private void notifyVirtualValueChanged(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: getfield mRequest : Lorg/chromium/android_webview/AwAutofillProvider$AutofillRequest;
    //   4: getfield mFormData : Lorg/chromium/components/autofill/FormData;
    //   7: getfield mFields : Ljava/util/ArrayList;
    //   10: iload_1
    //   11: invokevirtual get : (I)Ljava/lang/Object;
    //   14: checkcast org/chromium/components/autofill/FormFieldData
    //   17: astore_3
    //   18: aload_3
    //   19: ifnull -> 102
    //   22: aload_3
    //   23: getfield mControlType : I
    //   26: tableswitch default -> 52, 0 -> 91, 1 -> 80, 2 -> 55
    //   52: goto -> 102
    //   55: aload_3
    //   56: getfield mOptionValues : [Ljava/lang/String;
    //   59: aload_3
    //   60: invokevirtual getValue : ()Ljava/lang/String;
    //   63: invokestatic findIndex : ([Ljava/lang/String;Ljava/lang/String;)I
    //   66: istore_2
    //   67: iload_2
    //   68: iconst_m1
    //   69: if_icmpeq -> 102
    //   72: iload_2
    //   73: invokestatic forList : (I)Landroid/view/autofill/AutofillValue;
    //   76: astore_3
    //   77: goto -> 104
    //   80: aload_3
    //   81: invokevirtual isChecked : ()Z
    //   84: invokestatic forToggle : (Z)Landroid/view/autofill/AutofillValue;
    //   87: astore_3
    //   88: goto -> 104
    //   91: aload_3
    //   92: invokevirtual getValue : ()Ljava/lang/String;
    //   95: invokestatic forText : (Ljava/lang/CharSequence;)Landroid/view/autofill/AutofillValue;
    //   98: astore_3
    //   99: goto -> 104
    //   102: aconst_null
    //   103: astore_3
    //   104: aload_3
    //   105: ifnonnull -> 109
    //   108: return
    //   109: aload_0
    //   110: getfield mAutofillManager : Lorg/chromium/android_webview/AwAutofillManager;
    //   113: astore #4
    //   115: aload_0
    //   116: getfield mContainerView : Landroid/view/ViewGroup;
    //   119: astore #5
    //   121: aload_0
    //   122: getfield mRequest : Lorg/chromium/android_webview/AwAutofillProvider$AutofillRequest;
    //   125: iload_1
    //   126: i2s
    //   127: invokevirtual getVirtualId : (S)I
    //   130: istore_1
    //   131: aload #4
    //   133: getfield mDisabled : Z
    //   136: ifne -> 172
    //   139: aload #4
    //   141: invokevirtual checkAndWarnIfDestroyed : ()Z
    //   144: ifeq -> 148
    //   147: return
    //   148: getstatic org/chromium/android_webview/AwAutofillManager.sIsLoggable : Z
    //   151: ifeq -> 159
    //   154: ldc 'notifyVirtualValueChanged'
    //   156: invokestatic log : (Ljava/lang/String;)V
    //   159: aload #4
    //   161: getfield mAutofillManager : Landroid/view/autofill/AutofillManager;
    //   164: aload #5
    //   166: iload_1
    //   167: aload_3
    //   168: invokevirtual notifyValueChanged : (Landroid/view/View;ILandroid/view/autofill/AutofillValue;)V
    //   171: return
    //   172: return
  }
  
  private void onFocusChangedImpl(boolean paramBoolean1, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean2) {
    AwAutofillManager awAutofillManager;
    if (this.mRequest == null)
      return; 
    AwAutofillProvider$FocusField awAutofillProvider$FocusField = this.mRequest.mFocusField;
    if (paramBoolean1) {
      Rect rect = transformToWindowBounds(new RectF(paramFloat1, paramFloat2, paramFloat3 + paramFloat1, paramFloat4 + paramFloat2));
      if (awAutofillProvider$FocusField != null && awAutofillProvider$FocusField.fieldIndex == paramInt && rect.equals(awAutofillProvider$FocusField.absBound))
        return; 
      if (awAutofillProvider$FocusField != null)
        this.mAutofillManager.notifyVirtualViewExited((View)this.mContainerView, this.mRequest.getVirtualId(awAutofillProvider$FocusField.fieldIndex)); 
      awAutofillManager = this.mAutofillManager;
      ViewGroup viewGroup = this.mContainerView;
      AwAutofillProvider$AutofillRequest awAutofillProvider$AutofillRequest = this.mRequest;
      short s = (short)paramInt;
      awAutofillManager.notifyVirtualViewEntered((View)viewGroup, awAutofillProvider$AutofillRequest.getVirtualId(s), rect);
      if (!paramBoolean2) {
        notifyVirtualValueChanged(paramInt);
        this.mAutofillTriggeredTimeMillis = System.currentTimeMillis();
      } 
      this.mRequest.mFocusField = new AwAutofillProvider$FocusField(s, rect);
      return;
    } 
    if (awAutofillManager == null)
      return; 
    this.mAutofillManager.notifyVirtualViewExited((View)this.mContainerView, this.mRequest.getVirtualId(((AwAutofillProvider$FocusField)awAutofillManager).fieldIndex));
    this.mRequest.mFocusField = null;
  }
  
  private Rect transformToWindowBounds(RectF paramRectF) {
    float f = (this.mWebContents.getTopLevelNativeWindow()).mDisplayAndroid.mDipScale;
    paramRectF = new RectF(paramRectF);
    Matrix matrix = new Matrix();
    matrix.setScale(f, f);
    int[] arrayOfInt = new int[2];
    this.mContainerView.getLocationOnScreen(arrayOfInt);
    matrix.postTranslate(arrayOfInt[0], arrayOfInt[1]);
    matrix.mapRect(paramRectF);
    return new Rect((int)paramRectF.left, (int)paramRectF.top, (int)paramRectF.right, (int)paramRectF.bottom);
  }
  
  public final void autofill(SparseArray paramSparseArray) {
    if (this.mNativeAutofillProvider != 0L && this.mRequest != null) {
      AwAutofillProvider$AutofillRequest awAutofillProvider$AutofillRequest = this.mRequest;
      byte b = 0;
      int i = 0;
      while (true) {
        if (i < paramSparseArray.size()) {
          int j = paramSparseArray.keyAt(i);
          if (AwAutofillProvider$AutofillRequest.toSessionId(j) != awAutofillProvider$AutofillRequest.sessionId) {
            i = b;
            break;
          } 
          AutofillValue autofillValue = (AutofillValue)paramSparseArray.get(j);
          if (autofillValue != null) {
            j = AwAutofillProvider$AutofillRequest.toIndex(j);
            if (j < 0 || j >= awAutofillProvider$AutofillRequest.mFormData.mFields.size()) {
              i = b;
              break;
            } 
            FormFieldData formFieldData = awAutofillProvider$AutofillRequest.mFormData.mFields.get(j);
            if (formFieldData == null) {
              i = b;
              break;
            } 
            switch (formFieldData.mControlType) {
              case 2:
                j = autofillValue.getListValue();
                if (j >= 0 || j < formFieldData.mOptionValues.length)
                  formFieldData.setAutofillValue(formFieldData.mOptionValues[j]); 
                break;
              case 1:
                formFieldData.mIsChecked = autofillValue.getToggleValue();
                formFieldData.updateAutofillState(true);
                break;
              case 0:
                formFieldData.setAutofillValue((String)autofillValue.getTextValue());
                break;
            } 
          } 
          i++;
          continue;
        } 
        i = 1;
        break;
      } 
      if (i != 0) {
        nativeOnAutofillAvailable(this.mNativeAutofillProvider, AwAutofillProvider$AutofillRequest.access$300(this.mRequest));
        if (AwAutofillManager.sIsLoggable) {
          StringBuilder stringBuilder = new StringBuilder("autofill values:");
          stringBuilder.append(paramSparseArray.size());
          AwAutofillManager.log(stringBuilder.toString());
        } 
        AwAutofillUMA awAutofillUMA = this.mAutofillUMA;
        if (awAutofillUMA.mRecorder != null)
          awAutofillUMA.mRecorder.record(4); 
      } 
    } 
  }
  
  public final void onContainerViewChanged(ViewGroup paramViewGroup) {
    this.mContainerView = paramViewGroup;
  }
  
  protected void onDidFillAutofillFormData() {
    notifyFormValues();
  }
  
  public void onFocusChanged(boolean paramBoolean, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    onFocusChangedImpl(paramBoolean, paramInt, paramFloat1, paramFloat2, paramFloat3, paramFloat4, false);
  }
  
  public void onFormFieldDidChange(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    if (this.mRequest == null)
      return; 
    short s = (short)paramInt;
    AwAutofillProvider$FocusField awAutofillProvider$FocusField = this.mRequest.mFocusField;
    if (awAutofillProvider$FocusField == null || s != awAutofillProvider$FocusField.fieldIndex) {
      onFocusChangedImpl(true, paramInt, paramFloat1, paramFloat2, paramFloat3, paramFloat4, true);
    } else {
      int i = this.mRequest.getVirtualId(s);
      Rect rect = transformToWindowBounds(new RectF(paramFloat1, paramFloat2, paramFloat3 + paramFloat1, paramFloat4 + paramFloat2));
      this.mAutofillManager.notifyVirtualViewExited((View)this.mContainerView, i);
      this.mAutofillManager.notifyVirtualViewEntered((View)this.mContainerView, i, rect);
      this.mRequest.mFocusField = new AwAutofillProvider$FocusField(awAutofillProvider$FocusField.fieldIndex, rect);
    } 
    notifyVirtualValueChanged(paramInt);
    AwAutofillUMA awAutofillUMA = this.mAutofillUMA;
    boolean bool = ((FormFieldData)this.mRequest.mFormData.mFields.get(s)).mPreviouslyAutofilled;
    if (awAutofillUMA.mRecorder != null) {
      if (bool) {
        awAutofillUMA.mRecorder.record(32);
        return;
      } 
      awAutofillUMA.mRecorder.record(8);
    } 
  }
  
  public void onFormSubmitted(int paramInt) {
    notifyFormValues();
    AwAutofillManager awAutofillManager = this.mAutofillManager;
    if (!awAutofillManager.mDisabled && !awAutofillManager.checkAndWarnIfDestroyed()) {
      if (AwAutofillManager.sIsLoggable) {
        StringBuilder stringBuilder = new StringBuilder("commit source:");
        stringBuilder.append(paramInt);
        AwAutofillManager.log(stringBuilder.toString());
      } 
      awAutofillManager.mAutofillManager.commit();
    } 
    this.mRequest = null;
    AwAutofillUMA awAutofillUMA = this.mAutofillUMA;
    if (awAutofillUMA.mRecorder != null)
      awAutofillUMA.mRecorder.record(16); 
    awAutofillUMA.recordSession();
    RecordHistogram.recordEnumeratedHistogram("Autofill.WebView.SubmissionSource", AwAutofillUMA.toUMASubmissionSource(paramInt), 6);
  }
  
  public final void onProvideAutoFillVirtualStructure$6304a4bd(ViewStructure paramViewStructure) {
    if (this.mRequest == null)
      throw new VerifyError("bad dex opcode"); 
    AwAutofillProvider$AutofillRequest awAutofillProvider$AutofillRequest = this.mRequest;
    paramViewStructure.setWebDomain(awAutofillProvider$AutofillRequest.mFormData.mHost);
    paramViewStructure.setHtmlInfo(paramViewStructure.newHtmlInfoBuilder("form").addAttribute("name", awAutofillProvider$AutofillRequest.mFormData.mName).build());
    int i = paramViewStructure.addChildCount(awAutofillProvider$AutofillRequest.mFormData.mFields.size());
    short s = 0;
    for (FormFieldData formFieldData : awAutofillProvider$AutofillRequest.mFormData.mFields) {
      ViewStructure viewStructure = paramViewStructure.newChild(i);
      int j = awAutofillProvider$AutofillRequest.sessionId;
      short s1 = (short)(s + 1);
      j = AwAutofillProvider$AutofillRequest.toVirtualId(j, s);
      viewStructure.setAutofillId(paramViewStructure.getAutofillId(), j);
      if (formFieldData.mAutocompleteAttr != null && !formFieldData.mAutocompleteAttr.isEmpty())
        viewStructure.setAutofillHints(formFieldData.mAutocompleteAttr.split(" +")); 
      viewStructure.setHint(formFieldData.mPlaceholder);
      ViewStructure.HtmlInfo.Builder builder = viewStructure.newHtmlInfoBuilder("input").addAttribute("name", formFieldData.mName).addAttribute("type", formFieldData.mType).addAttribute("label", formFieldData.mLabel).addAttribute("id", formFieldData.mId);
      switch (formFieldData.mControlType) {
        case 2:
          viewStructure.setAutofillType(3);
          viewStructure.setAutofillOptions((CharSequence[])formFieldData.mOptionContents);
          j = AwAutofillProvider$AutofillRequest.findIndex(formFieldData.mOptionValues, formFieldData.getValue());
          if (j != -1)
            viewStructure.setAutofillValue(AutofillValue.forList(j)); 
          break;
        case 1:
          viewStructure.setAutofillType(2);
          viewStructure.setAutofillValue(AutofillValue.forToggle(formFieldData.isChecked()));
          break;
        case 0:
          viewStructure.setAutofillType(1);
          viewStructure.setAutofillValue(AutofillValue.forText(formFieldData.getValue()));
          if (formFieldData.mMaxLength != 0)
            builder.addAttribute("maxlength", String.valueOf(formFieldData.mMaxLength)); 
          break;
      } 
      viewStructure.setHtmlInfo(builder.build());
      i++;
      s = s1;
    } 
    if (AwAutofillManager.sIsLoggable) {
      StringBuilder stringBuilder = new StringBuilder("onProvideAutoFillVirtualStructure fields:");
      stringBuilder.append(paramViewStructure.getChildCount());
      AwAutofillManager.log(stringBuilder.toString());
    } 
    AwAutofillUMA awAutofillUMA = this.mAutofillUMA;
    if (awAutofillUMA.mRecorder != null)
      awAutofillUMA.mRecorder.record(1); 
    throw new VerifyError("bad dex opcode");
  }
  
  public void onTextFieldDidScroll(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    if (BuildInfo.isAtLeastP())
      return; 
    if (this.mRequest == null)
      return; 
    short s = (short)paramInt;
    AwAutofillProvider$FocusField awAutofillProvider$FocusField = this.mRequest.mFocusField;
    if (awAutofillProvider$FocusField != null) {
      if (s != awAutofillProvider$FocusField.fieldIndex)
        return; 
      paramInt = this.mRequest.getVirtualId(s);
      Rect rect = transformToWindowBounds(new RectF(paramFloat1, paramFloat2, paramFloat3 + paramFloat1, paramFloat4 + paramFloat2));
      this.mAutofillManager.notifyVirtualViewEntered((View)this.mContainerView, paramInt, rect);
      this.mRequest.mFocusField = new AwAutofillProvider$FocusField(awAutofillProvider$FocusField.fieldIndex, rect);
      return;
    } 
  }
  
  public final void queryAutofillSuggestion() {
    if (shouldQueryAutofillSuggestion()) {
      AwAutofillProvider$FocusField awAutofillProvider$FocusField = this.mRequest.mFocusField;
      AwAutofillManager awAutofillManager = this.mAutofillManager;
      ViewGroup viewGroup = this.mContainerView;
      int i = this.mRequest.getVirtualId(awAutofillProvider$FocusField.fieldIndex);
      Rect rect = awAutofillProvider$FocusField.absBound;
      if (!awAutofillManager.mDisabled) {
        if (awAutofillManager.checkAndWarnIfDestroyed())
          return; 
        if (AwAutofillManager.sIsLoggable)
          AwAutofillManager.log("requestAutofill"); 
        awAutofillManager.mAutofillManager.requestAutofill((View)viewGroup, i, rect);
        return;
      } 
      return;
    } 
  }
  
  protected void reset() {}
  
  protected void setNativeAutofillProvider(long paramLong) {
    if (paramLong == this.mNativeAutofillProvider)
      return; 
    try {
      if (this.mNativeAutofillProvider != 0L)
        this.mRequest = null; 
      this.mNativeAutofillProvider = paramLong;
      if (paramLong == 0L) {
        AwAutofillManager awAutofillManager = this.mAutofillManager;
        if (!awAutofillManager.mDisabled) {
          if (awAutofillManager.checkAndWarnIfDestroyed())
            return; 
          if (AwAutofillManager.sIsLoggable)
            AwAutofillManager.log("destroy"); 
          awAutofillManager.mAutofillManager.unregisterCallback(awAutofillManager.mMonitor);
          awAutofillManager.mAutofillManager = null;
          awAutofillManager.mDestroyed = true;
          return;
        } 
        return;
      } 
      return;
    } catch (IllegalStateException illegalStateException) {
      return;
    } 
  }
  
  public final void setWebContents(WebContents paramWebContents) {
    if (paramWebContents == this.mWebContents)
      return; 
    if (this.mWebContents != null)
      this.mRequest = null; 
    this.mWebContents = paramWebContents;
  }
  
  public final boolean shouldQueryAutofillSuggestion() {
    if (this.mRequest != null && this.mRequest.mFocusField != null) {
      boolean bool;
      AwAutofillManager awAutofillManager = this.mAutofillManager;
      if (awAutofillManager.mDisabled || awAutofillManager.checkAndWarnIfDestroyed()) {
        bool = false;
      } else {
        if (AwAutofillManager.sIsLoggable) {
          StringBuilder stringBuilder = new StringBuilder("isAutofillInputUIShowing: ");
          stringBuilder.append(awAutofillManager.mIsAutofillInputUIShowing);
          AwAutofillManager.log(stringBuilder.toString());
        } 
        bool = awAutofillManager.mIsAutofillInputUIShowing;
      } 
      if (!bool)
        return true; 
    } 
    return false;
  }
  
  public void startAutofillSession(FormData paramFormData, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    if (!BuildInfo.isAtLeastP()) {
      AwAutofillManager awAutofillManager = this.mAutofillManager;
      if (!awAutofillManager.mDisabled && !awAutofillManager.checkAndWarnIfDestroyed()) {
        if (AwAutofillManager.sIsLoggable)
          AwAutofillManager.log("cancel"); 
        awAutofillManager.mAutofillManager.cancel();
      } 
    } 
    AwAutofillManager.updateLogStat();
    if (AwAutofillManager.sIsLoggable)
      AwAutofillManager.log("Session starts"); 
    Rect rect = transformToWindowBounds(new RectF(paramFloat1, paramFloat2, paramFloat3 + paramFloat1, paramFloat4 + paramFloat2));
    short s = (short)paramInt;
    this.mRequest = new AwAutofillProvider$AutofillRequest(paramFormData, new AwAutofillProvider$FocusField(s, rect));
    paramInt = this.mRequest.getVirtualId(s);
    this.mAutofillManager.notifyVirtualViewEntered((View)this.mContainerView, paramInt, rect);
    AwAutofillUMA awAutofillUMA = this.mAutofillUMA;
    boolean bool = this.mAutofillManager.mDisabled;
    if (awAutofillUMA.mAutofillDisabled == null || awAutofillUMA.mAutofillDisabled.booleanValue() != bool) {
      RecordHistogram.recordBooleanHistogram("Autofill.WebView.Enabled", bool ^ true);
      awAutofillUMA.mAutofillDisabled = Boolean.valueOf(bool);
    } 
    if (awAutofillUMA.mRecorder != null)
      awAutofillUMA.recordSession(); 
    awAutofillUMA.mRecorder = new AwAutofillUMA$SessionRecorder((byte)0);
    this.mAutofillTriggeredTimeMillis = System.currentTimeMillis();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwAutofillProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */