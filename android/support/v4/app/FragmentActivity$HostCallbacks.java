package android.support.v4.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.ContainerHelpers;
import android.support.v4.util.SparseArrayCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;

final class FragmentActivity$HostCallbacks extends FragmentHostCallback {
  public FragmentActivity$HostCallbacks() {
    super(paramFragmentActivity);
  }
  
  public final void onDump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
    FragmentActivity.this.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  public final View onFindViewById(int paramInt) {
    return FragmentActivity.this.findViewById(paramInt);
  }
  
  public final LayoutInflater onGetLayoutInflater() {
    return FragmentActivity.this.getLayoutInflater().cloneInContext((Context)FragmentActivity.this);
  }
  
  public final int onGetWindowAnimations() {
    Window window = FragmentActivity.this.getWindow();
    return (window == null) ? 0 : (window.getAttributes()).windowAnimations;
  }
  
  public final boolean onHasView() {
    Window window = FragmentActivity.this.getWindow();
    return (window != null && window.peekDecorView() != null);
  }
  
  public final boolean onHasWindowAnimations() {
    return (FragmentActivity.this.getWindow() != null);
  }
  
  public final boolean onShouldSaveFragmentState$6585081f() {
    return !FragmentActivity.this.isFinishing();
  }
  
  public final void onStartActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt, Bundle paramBundle) {
    FragmentActivity fragmentActivity = FragmentActivity.this;
    fragmentActivity.mStartedActivityFromFragment = true;
    if (paramInt == -1)
      try {
        ActivityCompat.startActivityForResult(fragmentActivity, paramIntent, -1, paramBundle);
        return;
      } finally {
        fragmentActivity.mStartedActivityFromFragment = false;
      }  
    FragmentActivity.checkForValidRequestCode(paramInt);
    if (fragmentActivity.mPendingFragmentActivityResults.size() < 65534)
      while (true) {
        SparseArrayCompat sparseArrayCompat = fragmentActivity.mPendingFragmentActivityResults;
        int i = fragmentActivity.mNextCandidateRequestIndex;
        if (sparseArrayCompat.mGarbage)
          sparseArrayCompat.gc(); 
        if (ContainerHelpers.binarySearch(sparseArrayCompat.mKeys, sparseArrayCompat.mSize, i) >= 0) {
          fragmentActivity.mNextCandidateRequestIndex = (fragmentActivity.mNextCandidateRequestIndex + 1) % 65534;
          continue;
        } 
        i = fragmentActivity.mNextCandidateRequestIndex;
        fragmentActivity.mPendingFragmentActivityResults.put(i, paramFragment.mWho);
        fragmentActivity.mNextCandidateRequestIndex = (fragmentActivity.mNextCandidateRequestIndex + 1) % 65534;
        ActivityCompat.startActivityForResult(fragmentActivity, paramIntent, (i + 1 << 16) + (paramInt & 0xFFFF), paramBundle);
        fragmentActivity.mStartedActivityFromFragment = false;
        return;
      }  
    throw new IllegalStateException("Too many pending Fragment activity results.");
  }
  
  public final void onSupportInvalidateOptionsMenu() {
    FragmentActivity.this.invalidateOptionsMenu();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\app\FragmentActivity$HostCallbacks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */