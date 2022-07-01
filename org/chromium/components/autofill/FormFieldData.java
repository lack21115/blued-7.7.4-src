package org.chromium.components.autofill;

import org.chromium.base.annotations.CalledByNative;

public class FormFieldData {
  public final String mAutocompleteAttr;
  
  private boolean mAutofilled;
  
  public final int mControlType;
  
  public final String mId;
  
  public boolean mIsChecked;
  
  public final String mLabel;
  
  public final int mMaxLength;
  
  public final String mName;
  
  public final String[] mOptionContents;
  
  public final String[] mOptionValues;
  
  public final String mPlaceholder;
  
  public boolean mPreviouslyAutofilled;
  
  public final String mType;
  
  private String mValue;
  
  private FormFieldData(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String[] paramArrayOfString1, String[] paramArrayOfString2, boolean paramBoolean1, boolean paramBoolean2, int paramInt) {
    this.mName = paramString1;
    this.mLabel = paramString2;
    this.mValue = paramString3;
    this.mAutocompleteAttr = paramString4;
    this.mPlaceholder = paramString5;
    this.mType = paramString6;
    this.mId = paramString7;
    this.mOptionValues = paramArrayOfString1;
    this.mOptionContents = paramArrayOfString2;
    this.mIsChecked = paramBoolean2;
    if (this.mOptionValues != null && this.mOptionValues.length != 0) {
      this.mControlType = 2;
    } else if (paramBoolean1) {
      this.mControlType = 1;
    } else {
      this.mControlType = 0;
    } 
    this.mMaxLength = paramInt;
  }
  
  @CalledByNative
  private static FormFieldData createFormFieldData(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, String paramString5, String paramString6, String paramString7, String[] paramArrayOfString1, String[] paramArrayOfString2, boolean paramBoolean2, boolean paramBoolean3, int paramInt) {
    return new FormFieldData(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramArrayOfString1, paramArrayOfString2, paramBoolean2, paramBoolean3, paramInt);
  }
  
  @CalledByNative
  private void updateValue(String paramString) {
    this.mValue = paramString;
    updateAutofillState(false);
  }
  
  @CalledByNative
  public String getValue() {
    return this.mValue;
  }
  
  @CalledByNative
  public boolean isChecked() {
    return this.mIsChecked;
  }
  
  public final void setAutofillValue(String paramString) {
    this.mValue = paramString;
    updateAutofillState(true);
  }
  
  public final void updateAutofillState(boolean paramBoolean) {
    if (this.mAutofilled && !paramBoolean)
      this.mPreviouslyAutofilled = true; 
    this.mAutofilled = paramBoolean;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\components\autofill\FormFieldData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */