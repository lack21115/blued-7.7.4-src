package org.chromium.content.browser.input;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.List;
import org.chromium.content.R;
import org.chromium.ui.widget.UiWidgetFactory;

public final class SelectPopupDialog implements SelectPopup$Ui {
  private static final int[] SELECT_DIALOG_ATTRS = new int[] { R.attr.select_dialog_multichoice, R.attr.select_dialog_singlechoice };
  
  private final AlertDialog mListBoxPopup;
  
  private final SelectPopup mSelectPopup;
  
  private boolean mSelectionNotified;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public SelectPopupDialog(SelectPopup paramSelectPopup, Context paramContext, List paramList, boolean paramBoolean, int[] paramArrayOfint) {
    this.mSelectPopup = paramSelectPopup;
    ListView listView = new ListView(paramContext);
    int i = 0;
    listView.setCacheColorHint(0);
    UiWidgetFactory.getInstance();
    this.mListBoxPopup = (new AlertDialog.Builder(paramContext)).create();
    this.mListBoxPopup.setView((View)listView);
    this.mListBoxPopup.setCancelable(true);
    this.mListBoxPopup.setInverseBackgroundForced(true);
    if (paramBoolean) {
      this.mListBoxPopup.setButton(-1, this.mListBoxPopup.getContext().getString(17039370), new SelectPopupDialog$1(this, listView));
      this.mListBoxPopup.setButton(-2, this.mListBoxPopup.getContext().getString(17039360), new SelectPopupDialog$2(this));
    } 
    paramContext = this.mListBoxPopup.getContext();
    TypedArray typedArray = this.mListBoxPopup.getContext().obtainStyledAttributes(R.style.SelectPopupDialog, SELECT_DIALOG_ATTRS);
    int j = typedArray.getResourceId(paramBoolean ^ true, 0);
    typedArray.recycle();
    listView.setAdapter((ListAdapter)new SelectPopupAdapter(paramContext, j, paramList));
    listView.setFocusableInTouchMode(true);
    if (paramBoolean) {
      listView.setChoiceMode(2);
      while (i < paramArrayOfint.length) {
        listView.setItemChecked(paramArrayOfint[i], true);
        i++;
      } 
    } else {
      listView.setChoiceMode(1);
      listView.setOnItemClickListener(new SelectPopupDialog$3(this, listView));
      if (paramArrayOfint.length > 0) {
        listView.setSelection(paramArrayOfint[0]);
        listView.setItemChecked(paramArrayOfint[0], true);
      } 
    } 
    this.mListBoxPopup.setOnCancelListener(new SelectPopupDialog$4(this));
  }
  
  private void notifySelection(int[] paramArrayOfint) {
    if (this.mSelectionNotified)
      return; 
    this.mSelectPopup.selectMenuItems(paramArrayOfint);
    this.mSelectionNotified = true;
  }
  
  public final void hide(boolean paramBoolean) {
    if (paramBoolean) {
      this.mListBoxPopup.cancel();
      notifySelection(null);
      return;
    } 
    this.mSelectionNotified = true;
    this.mListBoxPopup.cancel();
  }
  
  public final void show() {
    try {
      this.mListBoxPopup.show();
      return;
    } catch (android.view.WindowManager.BadTokenException badTokenException) {
      notifySelection(null);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\input\SelectPopupDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */