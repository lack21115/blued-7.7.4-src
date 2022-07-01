package org.chromium.components.autofill;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import java.util.List;
import org.chromium.ui.DropdownAdapter;
import org.chromium.ui.DropdownPopupWindow;

public class AutofillPopup extends DropdownPopupWindow implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, PopupWindow.OnDismissListener {
  private final AutofillDelegate mAutofillDelegate;
  
  private final Runnable mClearAccessibilityFocusRunnable = new AutofillPopup$1(this);
  
  public final Context mContext;
  
  public List mSuggestions;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public AutofillPopup(Context paramContext, View paramView, AutofillDelegate paramAutofillDelegate) {
    super(paramContext, paramView);
    this.mContext = paramContext;
    this.mAutofillDelegate = paramAutofillDelegate;
    setOnItemClickListener(this);
    setOnDismissListener(this);
    this.mPopup.disableHideOnOutsideTap();
    String str = this.mContext.getString(R$string.autofill_popup_content_description);
    this.mPopup.setContentDescriptionForAccessibility(str);
  }
  
  public void onDismiss() {
    this.mAutofillDelegate.dismissed();
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong) {
    DropdownAdapter dropdownAdapter = (DropdownAdapter)paramAdapterView.getAdapter();
    paramInt = this.mSuggestions.indexOf(dropdownAdapter.getItem(paramInt));
    assert false;
    throw new AssertionError();
  }
  
  public boolean onItemLongClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong) {
    AutofillSuggestion autofillSuggestion = (AutofillSuggestion)((DropdownAdapter)paramAdapterView.getAdapter()).getItem(paramInt);
    if (!autofillSuggestion.mIsDeletable)
      return false; 
    paramInt = this.mSuggestions.indexOf(autofillSuggestion);
    assert false;
    throw new AssertionError();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\components\autofill\AutofillPopup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */