package android.support.v4.app;

import android.os.Looper;

final class FragmentManagerImpl$StartEnterTransitionListener implements Fragment$OnStartEnterTransitionListener {
  final boolean mIsBack;
  
  int mNumPostponed;
  
  final BackStackRecord mRecord;
  
  FragmentManagerImpl$StartEnterTransitionListener(BackStackRecord paramBackStackRecord, boolean paramBoolean) {
    this.mIsBack = paramBoolean;
    this.mRecord = paramBackStackRecord;
  }
  
  public final void cancelTransaction() {
    FragmentManagerImpl.access$600(this.mRecord.mManager, this.mRecord, this.mIsBack, false, false);
  }
  
  public final void completeTransaction() {
    boolean bool;
    if (this.mNumPostponed > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    FragmentManagerImpl fragmentManagerImpl = this.mRecord.mManager;
    int j = fragmentManagerImpl.mAdded.size();
    for (int i = 0; i < j; i++) {
      Fragment fragment = fragmentManagerImpl.mAdded.get(i);
      fragment.setOnStartEnterTransitionListener(null);
      if (bool && fragment.isPostponed())
        if (fragment.mFragmentManager == null || fragment.mFragmentManager.mHost == null) {
          (fragment.ensureAnimationInfo()).mEnterTransitionPostponed = false;
        } else if (Looper.myLooper() != fragment.mFragmentManager.mHost.mHandler.getLooper()) {
          fragment.mFragmentManager.mHost.mHandler.postAtFrontOfQueue(new Fragment$1(fragment));
        } else {
          fragment.callStartTransitionListener();
        }  
    } 
    FragmentManagerImpl.access$600(this.mRecord.mManager, this.mRecord, this.mIsBack, bool ^ true, true);
  }
  
  public final void onStartEnterTransition() {
    this.mNumPostponed--;
    if (this.mNumPostponed != 0)
      return; 
    FragmentManagerImpl.access$500(this.mRecord.mManager);
  }
  
  public final void startListening() {
    this.mNumPostponed++;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\app\FragmentManagerImpl$StartEnterTransitionListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */