package android.support.v7.widget;

import android.database.DataSetObserver;
import android.support.v4.view.ActionProvider;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

public final class ActivityChooserView extends ViewGroup {
  private final LinearLayoutCompat mActivityChooserContent;
  
  final ActivityChooserView$ActivityChooserViewAdapter mAdapter;
  
  private final ActivityChooserView$Callbacks mCallbacks;
  
  final FrameLayout mDefaultActivityButton;
  
  final FrameLayout mExpandActivityOverflowButton;
  
  int mInitialActivityCount;
  
  boolean mIsSelectingDefaultActivity;
  
  private final int mListPopupMaxWidth;
  
  private ListPopupWindow mListPopupWindow;
  
  private DataSetObserver mModelDataSetObserver;
  
  PopupWindow.OnDismissListener mOnDismissListener;
  
  private final ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
  
  ActionProvider mProvider;
  
  private ListPopupWindow getListPopupWindow() {
    if (this.mListPopupWindow == null) {
      this.mListPopupWindow = new ListPopupWindow(getContext());
      this.mListPopupWindow.setAdapter((ListAdapter)this.mAdapter);
      this.mListPopupWindow.mDropDownAnchorView = (View)this;
      this.mListPopupWindow.setModal(true);
      this.mListPopupWindow.mItemClickListener = this.mCallbacks;
      this.mListPopupWindow.setOnDismissListener(this.mCallbacks);
    } 
    return this.mListPopupWindow;
  }
  
  private boolean isShowingPopup() {
    return (getListPopupWindow()).mPopup.isShowing();
  }
  
  public final boolean dismissPopup() {
    if ((getListPopupWindow()).mPopup.isShowing()) {
      getListPopupWindow().dismiss();
      ViewTreeObserver viewTreeObserver = getViewTreeObserver();
      if (viewTreeObserver.isAlive())
        viewTreeObserver.removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener); 
    } 
    return true;
  }
  
  protected final void onAttachedToWindow() {
    super.onAttachedToWindow();
    ActivityChooserModel activityChooserModel = this.mAdapter.mDataModel;
    if (activityChooserModel != null)
      activityChooserModel.registerObserver(this.mModelDataSetObserver); 
  }
  
  protected final void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    ActivityChooserModel activityChooserModel = this.mAdapter.mDataModel;
    if (activityChooserModel != null)
      activityChooserModel.unregisterObserver(this.mModelDataSetObserver); 
    ViewTreeObserver viewTreeObserver = getViewTreeObserver();
    if (viewTreeObserver.isAlive())
      viewTreeObserver.removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener); 
    if (isShowingPopup())
      dismissPopup(); 
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.mActivityChooserContent.layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
    if (!isShowingPopup())
      dismissPopup(); 
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2) {
    LinearLayoutCompat linearLayoutCompat = this.mActivityChooserContent;
    int i = paramInt2;
    if (this.mDefaultActivityButton.getVisibility() != 0)
      i = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt2), 1073741824); 
    measureChild((View)linearLayoutCompat, paramInt1, i);
    setMeasuredDimension(linearLayoutCompat.getMeasuredWidth(), linearLayoutCompat.getMeasuredHeight());
  }
  
  final void showPopupUnchecked(int paramInt) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\ActivityChooserView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */