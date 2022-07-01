package org.chromium.components.autofill;

import java.util.ArrayList;
import org.chromium.base.annotations.CalledByNative;

public class FormData {
  public final ArrayList mFields;
  
  public final String mHost;
  
  public final String mName;
  
  private long mNativeObj;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private FormData(long paramLong, String paramString1, String paramString2, int paramInt) {
    this.mNativeObj = paramLong;
    this.mName = paramString1;
    this.mHost = paramString2;
    this.mFields = new ArrayList(paramInt);
    popupFormFields(paramInt);
  }
  
  @CalledByNative
  private static FormData createFormData(long paramLong, String paramString1, String paramString2, int paramInt) {
    return new FormData(paramLong, paramString1, paramString2, paramInt);
  }
  
  private native FormFieldData nativeGetNextFormFieldData(long paramLong);
  
  @CalledByNative
  private void onNativeDestroyed() {
    this.mNativeObj = 0L;
  }
  
  private void popupFormFields(int paramInt) {
    for (FormFieldData formFieldData = nativeGetNextFormFieldData(this.mNativeObj); formFieldData != null; formFieldData = nativeGetNextFormFieldData(this.mNativeObj))
      this.mFields.add(formFieldData); 
    assert false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\components\autofill\FormData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */