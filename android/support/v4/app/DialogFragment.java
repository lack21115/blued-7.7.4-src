package android.support.v4.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class DialogFragment extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
  private int mBackStackId = -1;
  
  private boolean mCancelable = true;
  
  private Dialog mDialog;
  
  private boolean mDismissed;
  
  private boolean mShownByMe;
  
  public boolean mShowsDialog = true;
  
  private int mStyle = 0;
  
  private int mTheme = 0;
  
  private boolean mViewDestroyed;
  
  public final void onActivityCreated(Bundle paramBundle) {
    super.onActivityCreated(paramBundle);
    if (!this.mShowsDialog)
      return; 
    View view = this.mView;
    if (view != null)
      if (view.getParent() == null) {
        this.mDialog.setContentView(view);
      } else {
        throw new IllegalStateException("DialogFragment can not be attached to a container view");
      }  
    FragmentActivity fragmentActivity = getActivity();
    if (fragmentActivity != null)
      this.mDialog.setOwnerActivity(fragmentActivity); 
    this.mDialog.setCancelable(this.mCancelable);
    this.mDialog.setOnCancelListener(this);
    this.mDialog.setOnDismissListener(this);
    if (paramBundle != null) {
      paramBundle = paramBundle.getBundle("android:savedDialogState");
      if (paramBundle != null)
        this.mDialog.onRestoreInstanceState(paramBundle); 
    } 
  }
  
  public final void onAttach(Context paramContext) {
    super.onAttach(paramContext);
    if (!this.mShownByMe)
      this.mDismissed = false; 
  }
  
  public void onCancel(DialogInterface paramDialogInterface) {}
  
  public final void onCreate(Bundle paramBundle) {
    boolean bool;
    super.onCreate(paramBundle);
    if (this.mContainerId == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    this.mShowsDialog = bool;
    if (paramBundle != null) {
      this.mStyle = paramBundle.getInt("android:style", 0);
      this.mTheme = paramBundle.getInt("android:theme", 0);
      this.mCancelable = paramBundle.getBoolean("android:cancelable", true);
      this.mShowsDialog = paramBundle.getBoolean("android:showsDialog", this.mShowsDialog);
      this.mBackStackId = paramBundle.getInt("android:backStackId", -1);
    } 
  }
  
  public Dialog onCreateDialog$5709b310() {
    return new Dialog((Context)getActivity(), this.mTheme);
  }
  
  public final void onDestroyView() {
    super.onDestroyView();
    if (this.mDialog != null) {
      this.mViewDestroyed = true;
      this.mDialog.dismiss();
      this.mDialog = null;
    } 
  }
  
  public final void onDetach() {
    super.onDetach();
    if (!this.mShownByMe && !this.mDismissed)
      this.mDismissed = true; 
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {
    if (!this.mViewDestroyed && !this.mDismissed) {
      this.mDismissed = true;
      this.mShownByMe = false;
      if (this.mDialog != null) {
        this.mDialog.dismiss();
        this.mDialog = null;
      } 
      this.mViewDestroyed = true;
      if (this.mBackStackId >= 0) {
        this.mFragmentManager.popBackStack(this.mBackStackId, 1);
        this.mBackStackId = -1;
        return;
      } 
      FragmentTransaction fragmentTransaction = this.mFragmentManager.beginTransaction();
      fragmentTransaction.remove(this);
      fragmentTransaction.commitAllowingStateLoss();
      return;
    } 
  }
  
  public final LayoutInflater onGetLayoutInflater(Bundle paramBundle) {
    if (!this.mShowsDialog)
      return super.onGetLayoutInflater(paramBundle); 
    this.mDialog = onCreateDialog$5709b310();
    if (this.mDialog != null) {
      Dialog dialog = this.mDialog;
      switch (this.mStyle) {
        default:
          return (LayoutInflater)this.mDialog.getContext().getSystemService("layout_inflater");
        case 3:
          dialog.getWindow().addFlags(24);
          break;
        case 1:
        case 2:
          break;
      } 
      dialog.requestWindowFeature(1);
    } 
    return (LayoutInflater)this.mHost.mContext.getSystemService("layout_inflater");
  }
  
  public final void onSaveInstanceState(Bundle paramBundle) {
    super.onSaveInstanceState(paramBundle);
    if (this.mDialog != null) {
      Bundle bundle = this.mDialog.onSaveInstanceState();
      if (bundle != null)
        paramBundle.putBundle("android:savedDialogState", bundle); 
    } 
    if (this.mStyle != 0)
      paramBundle.putInt("android:style", this.mStyle); 
    if (this.mTheme != 0)
      paramBundle.putInt("android:theme", this.mTheme); 
    if (!this.mCancelable)
      paramBundle.putBoolean("android:cancelable", this.mCancelable); 
    if (!this.mShowsDialog)
      paramBundle.putBoolean("android:showsDialog", this.mShowsDialog); 
    if (this.mBackStackId != -1)
      paramBundle.putInt("android:backStackId", this.mBackStackId); 
  }
  
  public final void onStart() {
    super.onStart();
    if (this.mDialog != null) {
      this.mViewDestroyed = false;
      this.mDialog.show();
    } 
  }
  
  public final void onStop() {
    super.onStop();
    if (this.mDialog != null)
      this.mDialog.hide(); 
  }
  
  public void show(FragmentManager paramFragmentManager, String paramString) {
    this.mDismissed = false;
    this.mShownByMe = true;
    FragmentTransaction fragmentTransaction = paramFragmentManager.beginTransaction();
    fragmentTransaction.add(this, paramString);
    fragmentTransaction.commit();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\app\DialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */