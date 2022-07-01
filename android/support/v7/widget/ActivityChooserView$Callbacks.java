package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.view.View;
import android.widget.AdapterView;
import android.widget.PopupWindow;

final class ActivityChooserView$Callbacks implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {
  public final void onClick(View paramView) {
    Intent intent;
    if (paramView == this.this$0.mDefaultActivityButton) {
      this.this$0.dismissPopup();
      ResolveInfo resolveInfo = this.this$0.mAdapter.mDataModel.getDefaultActivity();
      int i = this.this$0.mAdapter.mDataModel.getActivityIndex(resolveInfo);
      intent = this.this$0.mAdapter.mDataModel.chooseActivity(i);
      if (intent != null) {
        intent.addFlags(524288);
        this.this$0.getContext().startActivity(intent);
      } 
      return;
    } 
    if (intent == this.this$0.mExpandActivityOverflowButton) {
      this.this$0.mIsSelectingDefaultActivity = false;
      this.this$0.showPopupUnchecked(this.this$0.mInitialActivityCount);
      return;
    } 
    throw new IllegalArgumentException();
  }
  
  public final void onDismiss() {
    if (this.this$0.mOnDismissListener != null)
      this.this$0.mOnDismissListener.onDismiss(); 
    if (this.this$0.mProvider != null)
      this.this$0.mProvider.subUiVisibilityChanged(false); 
  }
  
  public final void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong) {
    switch (((ActivityChooserView$ActivityChooserViewAdapter)paramAdapterView.getAdapter()).getItemViewType(paramInt)) {
      default:
        throw new IllegalArgumentException();
      case 1:
        this.this$0.showPopupUnchecked(2147483647);
        return;
      case 0:
        break;
    } 
    this.this$0.dismissPopup();
    if (this.this$0.mIsSelectingDefaultActivity) {
      if (paramInt > 0) {
        null = this.this$0.mAdapter.mDataModel;
        synchronized (null.mInstanceLock) {
          float f;
          null.ensureConsistentState();
          ActivityChooserModel$ActivityResolveInfo activityChooserModel$ActivityResolveInfo1 = null.mActivities.get(paramInt);
          ActivityChooserModel$ActivityResolveInfo activityChooserModel$ActivityResolveInfo2 = null.mActivities.get(0);
          if (activityChooserModel$ActivityResolveInfo2 != null) {
            f = activityChooserModel$ActivityResolveInfo2.weight - activityChooserModel$ActivityResolveInfo1.weight + 5.0F;
          } else {
            f = 1.0F;
          } 
          null.addHistoricalRecord(new ActivityChooserModel$HistoricalRecord(new ComponentName(activityChooserModel$ActivityResolveInfo1.resolveInfo.activityInfo.packageName, activityChooserModel$ActivityResolveInfo1.resolveInfo.activityInfo.name), System.currentTimeMillis(), f));
          return;
        } 
      } 
      return;
    } 
    if (!this.this$0.mAdapter.mShowDefaultActivity)
      paramInt++; 
    Intent intent = this.this$0.mAdapter.mDataModel.chooseActivity(paramInt);
    if (intent != null) {
      intent.addFlags(524288);
      this.this$0.getContext().startActivity(intent);
    } 
  }
  
  public final boolean onLongClick(View paramView) {
    if (paramView == this.this$0.mDefaultActivityButton) {
      if (this.this$0.mAdapter.getCount() > 0) {
        this.this$0.mIsSelectingDefaultActivity = true;
        this.this$0.showPopupUnchecked(this.this$0.mInitialActivityCount);
      } 
      return true;
    } 
    throw new IllegalArgumentException();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\ActivityChooserView$Callbacks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */