package org.chromium.android_webview;

import org.chromium.base.ThreadUtils;
import org.chromium.components.autofill.FormData;

final class AwAutofillProvider$AutofillRequest {
  private static int sSessionId = 1;
  
  AwAutofillProvider$FocusField mFocusField;
  
  FormData mFormData;
  
  public final int sessionId;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public AwAutofillProvider$AutofillRequest(FormData paramFormData, AwAutofillProvider$FocusField paramAwAutofillProvider$FocusField) {
    ThreadUtils.assertOnUiThread();
    if (sSessionId == 65535)
      sSessionId = 1; 
    int i = sSessionId;
    sSessionId = i + 1;
    this.sessionId = i;
    this.mFormData = paramFormData;
    this.mFocusField = paramAwAutofillProvider$FocusField;
  }
  
  static int findIndex(String[] paramArrayOfString, String paramString) {
    if (paramArrayOfString != null && paramString != null)
      for (int i = 0; i < paramArrayOfString.length; i++) {
        if (paramString.equals(paramArrayOfString[i]))
          return i; 
      }  
    return -1;
  }
  
  static short toIndex(int paramInt) {
    return (short)paramInt;
  }
  
  static int toSessionId(int paramInt) {
    return paramInt >> 16;
  }
  
  static int toVirtualId(int paramInt, short paramShort) {
    return paramInt << 16 | paramShort;
  }
  
  public final int getVirtualId(short paramShort) {
    return paramShort | this.sessionId << 16;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwAutofillProvider$AutofillRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */