package org.chromium.ui;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import org.chromium.base.ApiCompatibilityUtils;
import org.chromium.ui.widget.AnchoredPopupWindow;
import org.chromium.ui.widget.RectProvider;
import org.chromium.ui.widget.ViewRectProvider;

class DropdownPopupWindowImpl implements DropdownPopupWindowInterface, AnchoredPopupWindow.LayoutObserver {
  private ListAdapter mAdapter;
  
  private final View mAnchorView;
  
  private AnchoredPopupWindow mAnchoredPopupWindow;
  
  private Drawable mBackground;
  
  private final Context mContext;
  
  private CharSequence mDescription;
  
  private int mHorizontalPadding;
  
  private int mInitialSelection = -1;
  
  private View.OnLayoutChangeListener mLayoutChangeListener;
  
  private ListView mListView;
  
  private boolean mRtl;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public DropdownPopupWindowImpl(Context paramContext, View paramView) {
    this.mContext = paramContext;
    this.mAnchorView = paramView;
    this.mAnchorView.setId(R$id.dropdown_popup_window);
    this.mAnchorView.setTag(this);
    this.mLayoutChangeListener = new DropdownPopupWindowImpl$1(this);
    this.mAnchorView.addOnLayoutChangeListener(this.mLayoutChangeListener);
    DropdownPopupWindowImpl$2 dropdownPopupWindowImpl$2 = new DropdownPopupWindowImpl$2(this);
    this.mListView = new ListView(paramContext);
    ViewRectProvider viewRectProvider = new ViewRectProvider(this.mAnchorView);
    viewRectProvider.mIncludePadding = true;
    this.mBackground = ApiCompatibilityUtils.getDrawable(paramContext.getResources(), R$drawable.dropdown_popup_background);
    this.mAnchoredPopupWindow = new AnchoredPopupWindow(paramContext, this.mAnchorView, this.mBackground, (View)this.mListView, (RectProvider)viewRectProvider);
    this.mAnchoredPopupWindow.addOnDismissListener(dropdownPopupWindowImpl$2);
    this.mAnchoredPopupWindow.mLayoutObserver = this;
    Rect rect = new Rect();
    this.mBackground.getPadding(rect);
    int i = rect.bottom;
    int j = rect.top;
    viewRectProvider.mInsetRect.set(0, i, 0, j);
    viewRectProvider.refreshRectBounds();
    this.mHorizontalPadding = rect.right + rect.left;
    this.mAnchoredPopupWindow.mPreferredHorizontalOrientation = 1;
    this.mAnchoredPopupWindow.mUpdateOrientationOnChange = true;
    this.mAnchoredPopupWindow.mPopupWindow.setOutsideTouchable(true);
  }
  
  public final void disableHideOnOutsideTap() {
    AnchoredPopupWindow anchoredPopupWindow = this.mAnchoredPopupWindow;
    anchoredPopupWindow.mDismissOnTouchInteraction = false;
    anchoredPopupWindow.mPopupWindow.setOutsideTouchable(anchoredPopupWindow.mDismissOnTouchInteraction);
  }
  
  public final void dismiss() {
    this.mAnchoredPopupWindow.mPopupWindow.dismiss();
  }
  
  public final ListView getListView() {
    return this.mListView;
  }
  
  public final void onPreLayoutChange$56a91b86(boolean paramBoolean, Rect paramRect) {
    Drawable drawable;
    this.mBackground.setBounds(paramRect);
    AnchoredPopupWindow anchoredPopupWindow = this.mAnchoredPopupWindow;
    if (paramBoolean) {
      drawable = ApiCompatibilityUtils.getDrawable(this.mContext.getResources(), R$drawable.dropdown_popup_background_down);
    } else {
      drawable = ApiCompatibilityUtils.getDrawable(this.mContext.getResources(), R$drawable.dropdown_popup_background_up);
    } 
    anchoredPopupWindow.mPopupWindow.setBackgroundDrawable(drawable);
  }
  
  public final void postShow() {
    this.mAnchoredPopupWindow.show();
  }
  
  public final void setAdapter(ListAdapter paramListAdapter) {
    this.mAdapter = paramListAdapter;
    this.mListView.setAdapter(paramListAdapter);
    this.mAnchoredPopupWindow.updatePopupLayout();
  }
  
  public final void setContentDescriptionForAccessibility(CharSequence paramCharSequence) {
    this.mDescription = paramCharSequence;
  }
  
  public final void setInitialSelection(int paramInt) {
    this.mInitialSelection = paramInt;
  }
  
  public final void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener) {
    this.mAnchoredPopupWindow.addOnDismissListener(paramOnDismissListener);
  }
  
  public final void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener) {
    this.mListView.setOnItemClickListener(paramOnItemClickListener);
  }
  
  public final void setRtl(boolean paramBoolean) {
    this.mRtl = paramBoolean;
  }
  
  public final void show() {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\DropdownPopupWindowImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */