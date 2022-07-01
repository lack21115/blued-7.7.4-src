package org.chromium.content.browser.selection;

import android.os.Build;
import android.text.TextUtils;
import android.view.textclassifier.TextClassifier;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.content_public.browser.SelectionClient;
import org.chromium.content_public.browser.SelectionMetricsLogger;
import org.chromium.content_public.browser.WebContents;
import org.chromium.ui.base.WindowAndroid;

public class SmartSelectionClient implements SelectionClient {
  private SelectionClient.ResultCallback mCallback;
  
  private long mNativeSmartSelectionClient;
  
  private SmartSelectionProvider mProvider;
  
  private SmartSelectionMetricsLogger mSmartSelectionMetricLogger;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private SmartSelectionClient(SelectionClient.ResultCallback paramResultCallback, WebContents paramWebContents, WindowAndroid paramWindowAndroid) {
    assert false;
    throw new AssertionError();
  }
  
  public static SmartSelectionClient create(SelectionClient.ResultCallback paramResultCallback, WebContents paramWebContents) {
    WindowAndroid windowAndroid = paramWebContents.getTopLevelNativeWindow();
    return (Build.VERSION.SDK_INT < 26 || windowAndroid == null) ? null : new SmartSelectionClient(paramResultCallback, paramWebContents, windowAndroid);
  }
  
  private native void nativeCancelAllRequests(long paramLong);
  
  private native long nativeInit(WebContents paramWebContents);
  
  private native void nativeRequestSurroundingText(long paramLong, int paramInt1, int paramInt2);
  
  @CalledByNative
  private void onNativeSideDestroyed(long paramLong) {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private void onSurroundingTextReceived(int paramInt1, String paramString, int paramInt2, int paramInt3) {
    boolean bool;
    if (!TextUtils.isEmpty(paramString) && paramInt2 >= 0 && paramInt2 < paramInt3 && paramInt3 <= paramString.length()) {
      bool = true;
    } else {
      bool = false;
    } 
    if (!bool) {
      this.mCallback.onClassified(new SelectionClient.Result());
      return;
    } 
    switch (paramInt1) {
      default:
        assert false;
        throw new AssertionError("Unexpected callback data");
      case 1:
        this.mProvider.sendSmartSelectionRequest(1, paramString, paramInt2, paramInt3, null);
        return;
      case 0:
        break;
    } 
    this.mProvider.sendSmartSelectionRequest(0, paramString, paramInt2, paramInt3, null);
  }
  
  public final void cancelAllRequests() {
    if (this.mNativeSmartSelectionClient != 0L)
      nativeCancelAllRequests(this.mNativeSmartSelectionClient); 
    this.mProvider.cancelAllRequests();
  }
  
  public final SelectionMetricsLogger getSelectionMetricsLogger() {
    return this.mSmartSelectionMetricLogger;
  }
  
  public final TextClassifier getTextClassifier() {
    return this.mProvider.getTextClassifier();
  }
  
  public final boolean requestSelectionPopupUpdates(boolean paramBoolean) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final void setTextClassifier(TextClassifier paramTextClassifier) {
    this.mProvider.mTextClassifier = paramTextClassifier;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\selection\SmartSelectionClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */