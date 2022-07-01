package org.chromium.content.browser.input;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.chromium.base.Log;
import org.chromium.base.ThreadUtils;

final class ThreadedInputConnection extends BaseInputConnection implements ChromiumBaseInputConnection {
  private static final TextInputState UNBLOCKER = new ThreadedInputConnection$1("", new Range(0, 0), new Range(-1, -1), false, false);
  
  private TextInputState mCachedTextInputState;
  
  private int mCurrentExtractedTextRequestToken;
  
  private final Runnable mFinishComposingTextRunnable = new ThreadedInputConnection$5(this);
  
  final Handler mHandler;
  
  private final ImeAdapterImpl mImeAdapter;
  
  private final Runnable mNotifyUserActionRunnable = new ThreadedInputConnection$4(this);
  
  private int mNumNestedBatchEdits;
  
  private int mPendingAccent;
  
  private final Runnable mProcessPendingInputStatesRunnable = new ThreadedInputConnection$2(this);
  
  private final BlockingQueue mQueue = new LinkedBlockingQueue();
  
  private final Runnable mRequestTextInputStateUpdate = new ThreadedInputConnection$3(this);
  
  private boolean mShouldUpdateExtractedText;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  ThreadedInputConnection(View paramView, ImeAdapterImpl paramImeAdapterImpl, Handler paramHandler) {
    super(paramView, true);
    ImeUtils.checkOnUiThread();
    this.mImeAdapter = paramImeAdapterImpl;
    this.mHandler = paramHandler;
  }
  
  private void addToQueueOnUiThread(TextInputState paramTextInputState) {
    ImeUtils.checkOnUiThread();
    try {
      this.mQueue.put(paramTextInputState);
      return;
    } catch (InterruptedException interruptedException) {
      Log.e("cr_Ime", "addToQueueOnUiThread interrupted", new Object[] { interruptedException });
      return;
    } 
  }
  
  private void assertOnImeThread() {
    boolean bool;
    if (this.mHandler.getLooper() == Looper.myLooper()) {
      bool = true;
    } else {
      bool = false;
    } 
    ImeUtils.checkCondition(bool);
  }
  
  private TextInputState blockAndGetStateUpdate() {
    assertOnImeThread();
    boolean bool = false;
    try {
      while (true) {
        TextInputState textInputState = this.mQueue.take();
        if (textInputState.shouldUnblock())
          return null; 
        if (textInputState.mReplyToRequest) {
          if (bool)
            updateSelection(textInputState); 
          return textInputState;
        } 
        bool = true;
      } 
    } catch (InterruptedException interruptedException) {
      ThrowableExtension.printStackTrace(interruptedException);
      ImeUtils.checkCondition(false);
      return null;
    } 
  }
  
  private void commitCodePointOnUiThread(int paramInt1, int paramInt2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.appendCodePoint(paramInt1);
    String str = stringBuilder.toString();
    this.mImeAdapter.sendCompositionToNative(str, 1, true, 0);
    this.mPendingAccent = paramInt2;
  }
  
  private static ExtractedText convertToExtractedText(TextInputState paramTextInputState) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void finishComposingTextOnUiThread() {
    ImeAdapterImpl imeAdapterImpl = this.mImeAdapter;
    if (imeAdapterImpl.isValid())
      imeAdapterImpl.nativeFinishComposingText(imeAdapterImpl.mNativeImeAdapterAndroid); 
  }
  
  private TextInputState requestAndWaitForTextInputState() {
    if (ThreadUtils.runningOnUiThread()) {
      Log.w("cr_Ime", "InputConnection API is not called on IME thread. Returning cached result.", new Object[0]);
      return this.mCachedTextInputState;
    } 
    assertOnImeThread();
    ThreadUtils.postOnUiThread(this.mRequestTextInputStateUpdate);
    return blockAndGetStateUpdate();
  }
  
  private void updateSelection(TextInputState paramTextInputState) {
    if (paramTextInputState == null)
      return; 
    assertOnImeThread();
    if (this.mNumNestedBatchEdits != 0)
      return; 
    Range range1 = paramTextInputState.mSelection;
    Range range2 = paramTextInputState.mComposition;
    if (this.mShouldUpdateExtractedText) {
      ExtractedText extractedText = convertToExtractedText(paramTextInputState);
      ImeAdapterImpl imeAdapterImpl1 = this.mImeAdapter;
      int n = this.mCurrentExtractedTextRequestToken;
      imeAdapterImpl1.mInputMethodManagerWrapper.updateExtractedText((View)imeAdapterImpl1.mViewDelegate.getContainerView(), n, extractedText);
    } 
    ImeAdapterImpl imeAdapterImpl = this.mImeAdapter;
    int i = range1.mStart;
    int j = range1.mEnd;
    int k = range2.mStart;
    int m = range2.mEnd;
    imeAdapterImpl.mInputMethodManagerWrapper.updateSelection((View)imeAdapterImpl.mViewDelegate.getContainerView(), i, j, k, m);
  }
  
  public final boolean beginBatchEdit() {
    assertOnImeThread();
    assertOnImeThread();
    this.mNumNestedBatchEdits++;
    return true;
  }
  
  public final boolean clearMetaKeyStates(int paramInt) {
    return false;
  }
  
  @SuppressLint({"MissingSuperCall"})
  public final void closeConnection() {}
  
  public final boolean commitCompletion(CompletionInfo paramCompletionInfo) {
    return false;
  }
  
  public final boolean commitCorrection(CorrectionInfo paramCorrectionInfo) {
    return false;
  }
  
  public final boolean commitText(CharSequence paramCharSequence, int paramInt) {
    if (paramCharSequence == null)
      return false; 
    if (TextUtils.equals(paramCharSequence, "\n")) {
      beginBatchEdit();
      commitText("", 1);
      ThreadUtils.postOnUiThread(new ThreadedInputConnection$9(this));
      endBatchEdit();
      return true;
    } 
    ThreadUtils.postOnUiThread(new ThreadedInputConnection$10(this, paramCharSequence, paramInt));
    ThreadUtils.postOnUiThread(this.mNotifyUserActionRunnable);
    return true;
  }
  
  public final boolean deleteSurroundingText(int paramInt1, int paramInt2) {
    ThreadUtils.postOnUiThread(new ThreadedInputConnection$13(this, paramInt1, paramInt2));
    return true;
  }
  
  public final boolean deleteSurroundingTextInCodePoints(int paramInt1, int paramInt2) {
    ThreadUtils.postOnUiThread(new ThreadedInputConnection$14(this, paramInt1, paramInt2));
    return true;
  }
  
  public final boolean endBatchEdit() {
    assertOnImeThread();
    if (this.mNumNestedBatchEdits == 0)
      return false; 
    this.mNumNestedBatchEdits--;
    if (this.mNumNestedBatchEdits == 0)
      updateSelection(requestAndWaitForTextInputState()); 
    return (this.mNumNestedBatchEdits != 0);
  }
  
  public final boolean finishComposingText() {
    ThreadUtils.postOnUiThread(this.mFinishComposingTextRunnable);
    return true;
  }
  
  public final int getCursorCapsMode(int paramInt) {
    TextInputState textInputState = requestAndWaitForTextInputState();
    return (textInputState != null) ? TextUtils.getCapsMode(textInputState.mText, textInputState.mSelection.mStart, paramInt) : 0;
  }
  
  public final ExtractedText getExtractedText(ExtractedTextRequest paramExtractedTextRequest, int paramInt) {
    assertOnImeThread();
    boolean bool2 = true;
    boolean bool1 = false;
    if ((paramInt & 0x1) <= 0)
      bool2 = false; 
    this.mShouldUpdateExtractedText = bool2;
    if (this.mShouldUpdateExtractedText) {
      paramInt = bool1;
      if (paramExtractedTextRequest != null)
        paramInt = paramExtractedTextRequest.token; 
      this.mCurrentExtractedTextRequestToken = paramInt;
    } 
    return convertToExtractedText(requestAndWaitForTextInputState());
  }
  
  public final Handler getHandler() {
    return this.mHandler;
  }
  
  public final CharSequence getSelectedText(int paramInt) {
    TextInputState textInputState = requestAndWaitForTextInputState();
    return (textInputState == null) ? null : ((textInputState.mSelection.mStart == textInputState.mSelection.mEnd) ? null : TextUtils.substring(textInputState.mText, textInputState.mSelection.mStart, textInputState.mSelection.mEnd));
  }
  
  public final CharSequence getTextAfterCursor(int paramInt1, int paramInt2) {
    TextInputState textInputState = requestAndWaitForTextInputState();
    return (textInputState == null) ? null : TextUtils.substring(textInputState.mText, textInputState.mSelection.mEnd, Math.min(textInputState.mText.length(), textInputState.mSelection.mEnd + paramInt1));
  }
  
  public final CharSequence getTextBeforeCursor(int paramInt1, int paramInt2) {
    TextInputState textInputState = requestAndWaitForTextInputState();
    return (textInputState == null) ? null : TextUtils.substring(textInputState.mText, Math.max(0, textInputState.mSelection.mStart - paramInt1), textInputState.mSelection.mStart);
  }
  
  public final boolean performContextMenuAction(int paramInt) {
    ThreadUtils.postOnUiThread(new ThreadedInputConnection$12(this, paramInt));
    return true;
  }
  
  public final boolean performEditorAction(int paramInt) {
    ThreadUtils.postOnUiThread(new ThreadedInputConnection$11(this, paramInt));
    return true;
  }
  
  public final boolean performPrivateCommand(String paramString, Bundle paramBundle) {
    return false;
  }
  
  public final boolean reportFullscreenMode(boolean paramBoolean) {
    return false;
  }
  
  public final boolean requestCursorUpdates(int paramInt) {
    ThreadUtils.postOnUiThread(new ThreadedInputConnection$18(this, paramInt));
    return true;
  }
  
  public final boolean sendKeyEvent(KeyEvent paramKeyEvent) {
    ThreadUtils.postOnUiThread(new ThreadedInputConnection$15(this, paramKeyEvent));
    ThreadUtils.postOnUiThread(this.mNotifyUserActionRunnable);
    return true;
  }
  
  public final boolean sendKeyEventOnUiThread(KeyEvent paramKeyEvent) {
    ImeUtils.checkOnUiThread();
    this.mHandler.post(new ThreadedInputConnection$7(this, paramKeyEvent));
    return true;
  }
  
  public final boolean setComposingRegion(int paramInt1, int paramInt2) {
    ThreadUtils.postOnUiThread(new ThreadedInputConnection$17(this, paramInt1, paramInt2));
    return true;
  }
  
  public final boolean setComposingText(CharSequence paramCharSequence, int paramInt) {
    if (paramCharSequence == null)
      return false; 
    ThreadUtils.postOnUiThread(new ThreadedInputConnection$8(this, paramCharSequence, paramInt, false));
    ThreadUtils.postOnUiThread(this.mNotifyUserActionRunnable);
    return true;
  }
  
  public final boolean setSelection(int paramInt1, int paramInt2) {
    ThreadUtils.postOnUiThread(new ThreadedInputConnection$16(this, paramInt1, paramInt2));
    return true;
  }
  
  public final void unblockOnUiThread() {
    ImeUtils.checkOnUiThread();
    addToQueueOnUiThread(UNBLOCKER);
    this.mHandler.post(this.mProcessPendingInputStatesRunnable);
  }
  
  public final void updateStateOnUiThread(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2) {
    ImeUtils.checkOnUiThread();
    this.mCachedTextInputState = new TextInputState(paramString, new Range(paramInt1, paramInt2), new Range(paramInt3, paramInt4), paramBoolean1, paramBoolean2);
    addToQueueOnUiThread(this.mCachedTextInputState);
    if (!paramBoolean2)
      this.mHandler.post(this.mProcessPendingInputStatesRunnable); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\input\ThreadedInputConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */