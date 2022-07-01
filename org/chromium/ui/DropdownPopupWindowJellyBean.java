package org.chromium.ui;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListPopupWindow;
import android.widget.ListView;
import android.widget.PopupWindow;
import org.chromium.base.Log;

class DropdownPopupWindowJellyBean implements DropdownPopupWindowInterface {
  private ListAdapter mAdapter;
  
  private final View mAnchorView;
  
  private CharSequence mDescription;
  
  private int mInitialSelection = -1;
  
  private View.OnLayoutChangeListener mLayoutChangeListener;
  
  private ListPopupWindow mListPopupWindow;
  
  private PopupWindow.OnDismissListener mOnDismissListener;
  
  private boolean mRtl;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public DropdownPopupWindowJellyBean(Context paramContext, View paramView) {
    this.mListPopupWindow = new ListPopupWindow(paramContext, null, 0, R$style.DropdownPopupWindow);
    this.mAnchorView = paramView;
    this.mAnchorView.setId(R$id.dropdown_popup_window);
    this.mAnchorView.setTag(this);
    this.mLayoutChangeListener = new DropdownPopupWindowJellyBean$1(this);
    this.mAnchorView.addOnLayoutChangeListener(this.mLayoutChangeListener);
    this.mListPopupWindow.setOnDismissListener(new DropdownPopupWindowJellyBean$2(this));
    this.mListPopupWindow.setAnchorView(this.mAnchorView);
    Rect rect = new Rect();
    this.mListPopupWindow.getBackground().getPadding(rect);
    this.mListPopupWindow.setVerticalOffset(-rect.top);
  }
  
  public final void disableHideOnOutsideTap() {
    try {
      ListPopupWindow.class.getMethod("setForceIgnoreOutsideTouch", new Class[] { boolean.class }).invoke(this.mListPopupWindow, new Object[] { Boolean.valueOf(true) });
      return;
    } catch (Exception exception) {
      Log.e("AutofillPopup", "ListPopupWindow.setForceIgnoreOutsideTouch not found", new Object[] { exception });
      return;
    } 
  }
  
  public final void dismiss() {
    this.mListPopupWindow.dismiss();
  }
  
  public final ListView getListView() {
    return this.mListPopupWindow.getListView();
  }
  
  public final void postShow() {
    this.mListPopupWindow.postShow();
  }
  
  public final void setAdapter(ListAdapter paramListAdapter) {
    this.mAdapter = paramListAdapter;
    this.mListPopupWindow.setAdapter(paramListAdapter);
  }
  
  public final void setContentDescriptionForAccessibility(CharSequence paramCharSequence) {
    this.mDescription = paramCharSequence;
  }
  
  public final void setInitialSelection(int paramInt) {
    this.mInitialSelection = paramInt;
  }
  
  public final void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener) {
    this.mOnDismissListener = paramOnDismissListener;
  }
  
  public final void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener) {
    this.mListPopupWindow.setOnItemClickListener(paramOnItemClickListener);
  }
  
  public final void setRtl(boolean paramBoolean) {
    this.mRtl = paramBoolean;
  }
  
  public final void show() {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\DropdownPopupWindowJellyBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */