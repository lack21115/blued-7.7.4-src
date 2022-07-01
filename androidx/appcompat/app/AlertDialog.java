package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R;

public class AlertDialog extends AppCompatDialog implements DialogInterface {
  final AlertController a = new AlertController(getContext(), this, getWindow());
  
  protected AlertDialog(Context paramContext, int paramInt) {
    super(paramContext, a(paramContext, paramInt));
  }
  
  static int a(Context paramContext, int paramInt) {
    if ((paramInt >>> 24 & 0xFF) >= 1)
      return paramInt; 
    TypedValue typedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
    return typedValue.resourceId;
  }
  
  public Button getButton(int paramInt) {
    return this.a.getButton(paramInt);
  }
  
  public ListView getListView() {
    return this.a.getListView();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.a.installContent();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    return this.a.onKeyDown(paramInt, paramKeyEvent) ? true : super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
    return this.a.onKeyUp(paramInt, paramKeyEvent) ? true : super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void setButton(int paramInt, CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener) {
    this.a.setButton(paramInt, paramCharSequence, paramOnClickListener, null, null);
  }
  
  public void setButton(int paramInt, CharSequence paramCharSequence, Drawable paramDrawable, DialogInterface.OnClickListener paramOnClickListener) {
    this.a.setButton(paramInt, paramCharSequence, paramOnClickListener, null, paramDrawable);
  }
  
  public void setButton(int paramInt, CharSequence paramCharSequence, Message paramMessage) {
    this.a.setButton(paramInt, paramCharSequence, null, paramMessage, null);
  }
  
  public void setCustomTitle(View paramView) {
    this.a.setCustomTitle(paramView);
  }
  
  public void setIcon(int paramInt) {
    this.a.setIcon(paramInt);
  }
  
  public void setIcon(Drawable paramDrawable) {
    this.a.setIcon(paramDrawable);
  }
  
  public void setIconAttribute(int paramInt) {
    TypedValue typedValue = new TypedValue();
    getContext().getTheme().resolveAttribute(paramInt, typedValue, true);
    this.a.setIcon(typedValue.resourceId);
  }
  
  public void setMessage(CharSequence paramCharSequence) {
    this.a.setMessage(paramCharSequence);
  }
  
  public void setTitle(CharSequence paramCharSequence) {
    super.setTitle(paramCharSequence);
    this.a.setTitle(paramCharSequence);
  }
  
  public void setView(View paramView) {
    this.a.setView(paramView);
  }
  
  public void setView(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.a.setView(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static class Builder {
    private final AlertController.AlertParams a;
    
    private final int b;
    
    public Builder(Context param1Context) {
      this(param1Context, AlertDialog.a(param1Context, 0));
    }
    
    public Builder(Context param1Context, int param1Int) {
      this.a = new AlertController.AlertParams((Context)new ContextThemeWrapper(param1Context, AlertDialog.a(param1Context, param1Int)));
      this.b = param1Int;
    }
    
    public AlertDialog create() {
      AlertDialog alertDialog = new AlertDialog(this.a.mContext, this.b);
      this.a.apply(alertDialog.a);
      alertDialog.setCancelable(this.a.mCancelable);
      if (this.a.mCancelable)
        alertDialog.setCanceledOnTouchOutside(true); 
      alertDialog.setOnCancelListener(this.a.mOnCancelListener);
      alertDialog.setOnDismissListener(this.a.mOnDismissListener);
      if (this.a.mOnKeyListener != null)
        alertDialog.setOnKeyListener(this.a.mOnKeyListener); 
      return alertDialog;
    }
    
    public Context getContext() {
      return this.a.mContext;
    }
    
    public Builder setAdapter(ListAdapter param1ListAdapter, DialogInterface.OnClickListener param1OnClickListener) {
      AlertController.AlertParams alertParams = this.a;
      alertParams.mAdapter = param1ListAdapter;
      alertParams.mOnClickListener = param1OnClickListener;
      return this;
    }
    
    public Builder setCancelable(boolean param1Boolean) {
      this.a.mCancelable = param1Boolean;
      return this;
    }
    
    public Builder setCursor(Cursor param1Cursor, DialogInterface.OnClickListener param1OnClickListener, String param1String) {
      AlertController.AlertParams alertParams = this.a;
      alertParams.mCursor = param1Cursor;
      alertParams.mLabelColumn = param1String;
      alertParams.mOnClickListener = param1OnClickListener;
      return this;
    }
    
    public Builder setCustomTitle(View param1View) {
      this.a.mCustomTitleView = param1View;
      return this;
    }
    
    public Builder setIcon(int param1Int) {
      this.a.mIconId = param1Int;
      return this;
    }
    
    public Builder setIcon(Drawable param1Drawable) {
      this.a.mIcon = param1Drawable;
      return this;
    }
    
    public Builder setIconAttribute(int param1Int) {
      TypedValue typedValue = new TypedValue();
      this.a.mContext.getTheme().resolveAttribute(param1Int, typedValue, true);
      this.a.mIconId = typedValue.resourceId;
      return this;
    }
    
    @Deprecated
    public Builder setInverseBackgroundForced(boolean param1Boolean) {
      this.a.mForceInverseBackground = param1Boolean;
      return this;
    }
    
    public Builder setItems(int param1Int, DialogInterface.OnClickListener param1OnClickListener) {
      AlertController.AlertParams alertParams = this.a;
      alertParams.mItems = alertParams.mContext.getResources().getTextArray(param1Int);
      this.a.mOnClickListener = param1OnClickListener;
      return this;
    }
    
    public Builder setItems(CharSequence[] param1ArrayOfCharSequence, DialogInterface.OnClickListener param1OnClickListener) {
      AlertController.AlertParams alertParams = this.a;
      alertParams.mItems = param1ArrayOfCharSequence;
      alertParams.mOnClickListener = param1OnClickListener;
      return this;
    }
    
    public Builder setMessage(int param1Int) {
      AlertController.AlertParams alertParams = this.a;
      alertParams.mMessage = alertParams.mContext.getText(param1Int);
      return this;
    }
    
    public Builder setMessage(CharSequence param1CharSequence) {
      this.a.mMessage = param1CharSequence;
      return this;
    }
    
    public Builder setMultiChoiceItems(int param1Int, boolean[] param1ArrayOfboolean, DialogInterface.OnMultiChoiceClickListener param1OnMultiChoiceClickListener) {
      AlertController.AlertParams alertParams = this.a;
      alertParams.mItems = alertParams.mContext.getResources().getTextArray(param1Int);
      alertParams = this.a;
      alertParams.mOnCheckboxClickListener = param1OnMultiChoiceClickListener;
      alertParams.mCheckedItems = param1ArrayOfboolean;
      alertParams.mIsMultiChoice = true;
      return this;
    }
    
    public Builder setMultiChoiceItems(Cursor param1Cursor, String param1String1, String param1String2, DialogInterface.OnMultiChoiceClickListener param1OnMultiChoiceClickListener) {
      AlertController.AlertParams alertParams = this.a;
      alertParams.mCursor = param1Cursor;
      alertParams.mOnCheckboxClickListener = param1OnMultiChoiceClickListener;
      alertParams.mIsCheckedColumn = param1String1;
      alertParams.mLabelColumn = param1String2;
      alertParams.mIsMultiChoice = true;
      return this;
    }
    
    public Builder setMultiChoiceItems(CharSequence[] param1ArrayOfCharSequence, boolean[] param1ArrayOfboolean, DialogInterface.OnMultiChoiceClickListener param1OnMultiChoiceClickListener) {
      AlertController.AlertParams alertParams = this.a;
      alertParams.mItems = param1ArrayOfCharSequence;
      alertParams.mOnCheckboxClickListener = param1OnMultiChoiceClickListener;
      alertParams.mCheckedItems = param1ArrayOfboolean;
      alertParams.mIsMultiChoice = true;
      return this;
    }
    
    public Builder setNegativeButton(int param1Int, DialogInterface.OnClickListener param1OnClickListener) {
      AlertController.AlertParams alertParams = this.a;
      alertParams.mNegativeButtonText = alertParams.mContext.getText(param1Int);
      this.a.mNegativeButtonListener = param1OnClickListener;
      return this;
    }
    
    public Builder setNegativeButton(CharSequence param1CharSequence, DialogInterface.OnClickListener param1OnClickListener) {
      AlertController.AlertParams alertParams = this.a;
      alertParams.mNegativeButtonText = param1CharSequence;
      alertParams.mNegativeButtonListener = param1OnClickListener;
      return this;
    }
    
    public Builder setNegativeButtonIcon(Drawable param1Drawable) {
      this.a.mNegativeButtonIcon = param1Drawable;
      return this;
    }
    
    public Builder setNeutralButton(int param1Int, DialogInterface.OnClickListener param1OnClickListener) {
      AlertController.AlertParams alertParams = this.a;
      alertParams.mNeutralButtonText = alertParams.mContext.getText(param1Int);
      this.a.mNeutralButtonListener = param1OnClickListener;
      return this;
    }
    
    public Builder setNeutralButton(CharSequence param1CharSequence, DialogInterface.OnClickListener param1OnClickListener) {
      AlertController.AlertParams alertParams = this.a;
      alertParams.mNeutralButtonText = param1CharSequence;
      alertParams.mNeutralButtonListener = param1OnClickListener;
      return this;
    }
    
    public Builder setNeutralButtonIcon(Drawable param1Drawable) {
      this.a.mNeutralButtonIcon = param1Drawable;
      return this;
    }
    
    public Builder setOnCancelListener(DialogInterface.OnCancelListener param1OnCancelListener) {
      this.a.mOnCancelListener = param1OnCancelListener;
      return this;
    }
    
    public Builder setOnDismissListener(DialogInterface.OnDismissListener param1OnDismissListener) {
      this.a.mOnDismissListener = param1OnDismissListener;
      return this;
    }
    
    public Builder setOnItemSelectedListener(AdapterView.OnItemSelectedListener param1OnItemSelectedListener) {
      this.a.mOnItemSelectedListener = param1OnItemSelectedListener;
      return this;
    }
    
    public Builder setOnKeyListener(DialogInterface.OnKeyListener param1OnKeyListener) {
      this.a.mOnKeyListener = param1OnKeyListener;
      return this;
    }
    
    public Builder setPositiveButton(int param1Int, DialogInterface.OnClickListener param1OnClickListener) {
      AlertController.AlertParams alertParams = this.a;
      alertParams.mPositiveButtonText = alertParams.mContext.getText(param1Int);
      this.a.mPositiveButtonListener = param1OnClickListener;
      return this;
    }
    
    public Builder setPositiveButton(CharSequence param1CharSequence, DialogInterface.OnClickListener param1OnClickListener) {
      AlertController.AlertParams alertParams = this.a;
      alertParams.mPositiveButtonText = param1CharSequence;
      alertParams.mPositiveButtonListener = param1OnClickListener;
      return this;
    }
    
    public Builder setPositiveButtonIcon(Drawable param1Drawable) {
      this.a.mPositiveButtonIcon = param1Drawable;
      return this;
    }
    
    public Builder setRecycleOnMeasureEnabled(boolean param1Boolean) {
      this.a.mRecycleOnMeasure = param1Boolean;
      return this;
    }
    
    public Builder setSingleChoiceItems(int param1Int1, int param1Int2, DialogInterface.OnClickListener param1OnClickListener) {
      AlertController.AlertParams alertParams = this.a;
      alertParams.mItems = alertParams.mContext.getResources().getTextArray(param1Int1);
      alertParams = this.a;
      alertParams.mOnClickListener = param1OnClickListener;
      alertParams.mCheckedItem = param1Int2;
      alertParams.mIsSingleChoice = true;
      return this;
    }
    
    public Builder setSingleChoiceItems(Cursor param1Cursor, int param1Int, String param1String, DialogInterface.OnClickListener param1OnClickListener) {
      AlertController.AlertParams alertParams = this.a;
      alertParams.mCursor = param1Cursor;
      alertParams.mOnClickListener = param1OnClickListener;
      alertParams.mCheckedItem = param1Int;
      alertParams.mLabelColumn = param1String;
      alertParams.mIsSingleChoice = true;
      return this;
    }
    
    public Builder setSingleChoiceItems(ListAdapter param1ListAdapter, int param1Int, DialogInterface.OnClickListener param1OnClickListener) {
      AlertController.AlertParams alertParams = this.a;
      alertParams.mAdapter = param1ListAdapter;
      alertParams.mOnClickListener = param1OnClickListener;
      alertParams.mCheckedItem = param1Int;
      alertParams.mIsSingleChoice = true;
      return this;
    }
    
    public Builder setSingleChoiceItems(CharSequence[] param1ArrayOfCharSequence, int param1Int, DialogInterface.OnClickListener param1OnClickListener) {
      AlertController.AlertParams alertParams = this.a;
      alertParams.mItems = param1ArrayOfCharSequence;
      alertParams.mOnClickListener = param1OnClickListener;
      alertParams.mCheckedItem = param1Int;
      alertParams.mIsSingleChoice = true;
      return this;
    }
    
    public Builder setTitle(int param1Int) {
      AlertController.AlertParams alertParams = this.a;
      alertParams.mTitle = alertParams.mContext.getText(param1Int);
      return this;
    }
    
    public Builder setTitle(CharSequence param1CharSequence) {
      this.a.mTitle = param1CharSequence;
      return this;
    }
    
    public Builder setView(int param1Int) {
      AlertController.AlertParams alertParams = this.a;
      alertParams.mView = null;
      alertParams.mViewLayoutResId = param1Int;
      alertParams.mViewSpacingSpecified = false;
      return this;
    }
    
    public Builder setView(View param1View) {
      AlertController.AlertParams alertParams = this.a;
      alertParams.mView = param1View;
      alertParams.mViewLayoutResId = 0;
      alertParams.mViewSpacingSpecified = false;
      return this;
    }
    
    @Deprecated
    public Builder setView(View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      AlertController.AlertParams alertParams = this.a;
      alertParams.mView = param1View;
      alertParams.mViewLayoutResId = 0;
      alertParams.mViewSpacingSpecified = true;
      alertParams.mViewSpacingLeft = param1Int1;
      alertParams.mViewSpacingTop = param1Int2;
      alertParams.mViewSpacingRight = param1Int3;
      alertParams.mViewSpacingBottom = param1Int4;
      return this;
    }
    
    public AlertDialog show() {
      AlertDialog alertDialog = create();
      alertDialog.show();
      return alertDialog;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\app\AlertDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */