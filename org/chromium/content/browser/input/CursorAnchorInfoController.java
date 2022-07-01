package org.chromium.content.browser.input;

import android.annotation.TargetApi;
import android.graphics.Matrix;
import android.view.View;
import android.view.inputmethod.CursorAnchorInfo;
import org.chromium.content_public.browser.InputMethodManagerWrapper;

@TargetApi(21)
final class CursorAnchorInfoController {
  private final CursorAnchorInfoController$ComposingTextDelegate mComposingTextDelegate;
  
  float[] mCompositionCharacterBounds;
  
  private final CursorAnchorInfo.Builder mCursorAnchorInfoBuilder = new CursorAnchorInfo.Builder();
  
  boolean mHasCoordinateInfo;
  
  boolean mHasInsertionMarker;
  
  boolean mHasPendingImmediateRequest;
  
  private InputMethodManagerWrapper mInputMethodManagerWrapper;
  
  float mInsertionMarkerBottom;
  
  float mInsertionMarkerHorizontal;
  
  float mInsertionMarkerTop;
  
  boolean mIsEditable;
  
  boolean mIsInsertionMarkerVisible;
  
  CursorAnchorInfo mLastCursorAnchorInfo;
  
  private final Matrix mMatrix = new Matrix();
  
  boolean mMonitorModeEnabled;
  
  float mScale;
  
  float mTranslationX;
  
  float mTranslationY;
  
  final CursorAnchorInfoController$ViewDelegate mViewDelegate;
  
  final int[] mViewOrigin = new int[2];
  
  CursorAnchorInfoController(InputMethodManagerWrapper paramInputMethodManagerWrapper, CursorAnchorInfoController$ComposingTextDelegate paramCursorAnchorInfoController$ComposingTextDelegate, CursorAnchorInfoController$ViewDelegate paramCursorAnchorInfoController$ViewDelegate) {
    this.mInputMethodManagerWrapper = paramInputMethodManagerWrapper;
    this.mComposingTextDelegate = paramCursorAnchorInfoController$ComposingTextDelegate;
    this.mViewDelegate = paramCursorAnchorInfoController$ViewDelegate;
  }
  
  public final void focusedNodeChanged(boolean paramBoolean) {
    this.mIsEditable = paramBoolean;
    this.mCompositionCharacterBounds = null;
    this.mHasCoordinateInfo = false;
    this.mLastCursorAnchorInfo = null;
  }
  
  public final void invalidateLastCursorAnchorInfo() {
    if (!this.mIsEditable)
      return; 
    this.mLastCursorAnchorInfo = null;
  }
  
  public final boolean onRequestCursorUpdates(boolean paramBoolean1, boolean paramBoolean2, View paramView) {
    if (!this.mIsEditable)
      return false; 
    if (this.mMonitorModeEnabled && !paramBoolean2)
      invalidateLastCursorAnchorInfo(); 
    this.mMonitorModeEnabled = paramBoolean2;
    if (paramBoolean1) {
      this.mHasPendingImmediateRequest = true;
      updateCursorAnchorInfo(paramView);
    } 
    return true;
  }
  
  final void updateCursorAnchorInfo(View paramView) {
    if (!this.mHasCoordinateInfo)
      return; 
    if (this.mLastCursorAnchorInfo == null) {
      this.mCursorAnchorInfoBuilder.reset();
      CharSequence charSequence = this.mComposingTextDelegate.getText();
      int j = this.mComposingTextDelegate.getSelectionStart();
      int k = this.mComposingTextDelegate.getSelectionEnd();
      int m = this.mComposingTextDelegate.getComposingTextStart();
      int i = this.mComposingTextDelegate.getComposingTextEnd();
      if (charSequence != null && m >= 0 && i <= charSequence.length()) {
        this.mCursorAnchorInfoBuilder.setComposingText(m, charSequence.subSequence(m, i));
        float[] arrayOfFloat = this.mCompositionCharacterBounds;
        if (arrayOfFloat != null) {
          int n = arrayOfFloat.length / 4;
          for (i = 0; i < n; i++) {
            int i1 = i << 2;
            float f1 = arrayOfFloat[i1];
            float f2 = arrayOfFloat[i1 + 1];
            float f3 = arrayOfFloat[i1 + 2];
            float f4 = arrayOfFloat[i1 + 3];
            this.mCursorAnchorInfoBuilder.addCharacterBounds(m + i, f1, f2, f3, f4, 1);
          } 
        } 
      } 
      this.mCursorAnchorInfoBuilder.setSelectionRange(j, k);
      this.mMatrix.setScale(this.mScale, this.mScale);
      this.mMatrix.postTranslate(this.mTranslationX, this.mTranslationY);
      this.mCursorAnchorInfoBuilder.setMatrix(this.mMatrix);
      if (this.mHasInsertionMarker) {
        CursorAnchorInfo.Builder builder = this.mCursorAnchorInfoBuilder;
        float f1 = this.mInsertionMarkerHorizontal;
        float f2 = this.mInsertionMarkerTop;
        float f3 = this.mInsertionMarkerBottom;
        float f4 = this.mInsertionMarkerBottom;
        if (this.mIsInsertionMarkerVisible) {
          i = 1;
        } else {
          i = 2;
        } 
        builder.setInsertionMarkerLocation(f1, f2, f3, f4, i);
      } 
      this.mLastCursorAnchorInfo = this.mCursorAnchorInfoBuilder.build();
    } 
    if (this.mInputMethodManagerWrapper != null)
      this.mInputMethodManagerWrapper.updateCursorAnchorInfo(paramView, this.mLastCursorAnchorInfo); 
    this.mHasPendingImmediateRequest = false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\input\CursorAnchorInfoController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */