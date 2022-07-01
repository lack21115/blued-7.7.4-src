package android.support.v4.app;

import android.arch.lifecycle.Lifecycle;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.util.SimpleArrayMap;
import android.support.v4.util.SparseArrayCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public final class FragmentActivity extends BaseFragmentActivityApi16 {
  private boolean mCreated;
  
  final FragmentController mFragments = new FragmentController(new FragmentActivity$HostCallbacks(this));
  
  final Handler mHandler = new FragmentActivity$1(this);
  
  int mNextCandidateRequestIndex;
  
  SparseArrayCompat mPendingFragmentActivityResults;
  
  private boolean mReallyStopped = true;
  
  private boolean mResumed;
  
  private boolean mRetaining;
  
  boolean mStopped = true;
  
  private static void markState(FragmentManager paramFragmentManager, Lifecycle.State paramState) {
    for (Fragment fragment : paramFragmentManager.getFragments()) {
      if (fragment != null) {
        fragment.mLifecycleRegistry.mState = paramState;
        markState(fragment.getChildFragmentManager(), paramState);
      } 
    } 
  }
  
  final View dispatchFragmentsOnCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet) {
    return this.mFragments.mHost.mFragmentManager.onCreateView(paramView, paramString, paramContext, paramAttributeSet);
  }
  
  final void doReallyStop(boolean paramBoolean) {
    if (!this.mReallyStopped) {
      this.mReallyStopped = true;
      this.mRetaining = paramBoolean;
      this.mHandler.removeMessages(1);
      this.mFragments.doLoaderStop(this.mRetaining);
      this.mFragments.mHost.mFragmentManager.dispatchStateChange(2);
      return;
    } 
    if (paramBoolean) {
      this.mFragments.doLoaderStart();
      this.mFragments.doLoaderStop(true);
    } 
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
    super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("Local FragmentActivity ");
    paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this)));
    paramPrintWriter.println(" State:");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("  ");
    String str = stringBuilder.toString();
    paramPrintWriter.print(str);
    paramPrintWriter.print("mCreated=");
    paramPrintWriter.print(this.mCreated);
    paramPrintWriter.print("mResumed=");
    paramPrintWriter.print(this.mResumed);
    paramPrintWriter.print(" mStopped=");
    paramPrintWriter.print(this.mStopped);
    paramPrintWriter.print(" mReallyStopped=");
    paramPrintWriter.println(this.mReallyStopped);
    FragmentHostCallback fragmentHostCallback = this.mFragments.mHost;
    paramPrintWriter.print(str);
    paramPrintWriter.print("mLoadersStarted=");
    paramPrintWriter.println(fragmentHostCallback.mLoadersStarted);
    if (fragmentHostCallback.mLoaderManager != null) {
      paramPrintWriter.print(str);
      paramPrintWriter.print("Loader Manager ");
      paramPrintWriter.print(Integer.toHexString(System.identityHashCode(fragmentHostCallback.mLoaderManager)));
      paramPrintWriter.println(":");
      LoaderManagerImpl loaderManagerImpl = fragmentHostCallback.mLoaderManager;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str);
      stringBuilder1.append("  ");
      loaderManagerImpl.dump$ec96877(stringBuilder1.toString(), paramFileDescriptor, paramPrintWriter);
    } 
    this.mFragments.mHost.mFragmentManager.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  public final Lifecycle getLifecycle() {
    return super.getLifecycle();
  }
  
  public final FragmentManager getSupportFragmentManager() {
    return this.mFragments.mHost.mFragmentManager;
  }
  
  protected final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    StringBuilder stringBuilder;
    this.mFragments.noteStateNotSaved();
    int i = paramInt1 >> 16;
    if (i != 0) {
      String str = (String)this.mPendingFragmentActivityResults.get(--i);
      this.mPendingFragmentActivityResults.remove(i);
      if (str == null) {
        Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
        return;
      } 
      Fragment fragment = this.mFragments.findFragmentByWho(str);
      if (fragment == null) {
        stringBuilder = new StringBuilder("Activity result no fragment exists for who: ");
        stringBuilder.append(str);
        Log.w("FragmentActivity", stringBuilder.toString());
        return;
      } 
      fragment.onActivityResult(paramInt1 & 0xFFFF, paramInt2, (Intent)stringBuilder);
      return;
    } 
    ActivityCompat$PermissionCompatDelegate activityCompat$PermissionCompatDelegate = ActivityCompat.getPermissionCompatDelegate();
    if (activityCompat$PermissionCompatDelegate != null && activityCompat$PermissionCompatDelegate.onActivityResult$51b9da68())
      return; 
    super.onActivityResult(paramInt1, paramInt2, (Intent)stringBuilder);
  }
  
  public final void onBackPressed() {
    FragmentManagerImpl fragmentManagerImpl = this.mFragments.mHost.mFragmentManager;
    boolean bool = fragmentManagerImpl.isStateSaved();
    if (bool && Build.VERSION.SDK_INT <= 25)
      return; 
    if (bool || !fragmentManagerImpl.popBackStackImmediate())
      super.onBackPressed(); 
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {
    super.onConfigurationChanged(paramConfiguration);
    this.mFragments.mHost.mFragmentManager.dispatchConfigurationChanged(paramConfiguration);
  }
  
  protected final void onCreate(Bundle paramBundle) {
    FragmentController fragmentController = this.mFragments;
    FragmentManagerImpl fragmentManagerImpl = fragmentController.mHost.mFragmentManager;
    FragmentHostCallback fragmentHostCallback1 = fragmentController.mHost;
    FragmentHostCallback fragmentHostCallback2 = fragmentController.mHost;
    fragmentController = null;
    fragmentManagerImpl.attachController(fragmentHostCallback1, fragmentHostCallback2, null);
    super.onCreate(paramBundle);
    FragmentActivity$NonConfigurationInstances fragmentActivity$NonConfigurationInstances = (FragmentActivity$NonConfigurationInstances)getLastNonConfigurationInstance();
    if (fragmentActivity$NonConfigurationInstances != null) {
      FragmentController fragmentController1 = this.mFragments;
      SimpleArrayMap simpleArrayMap = fragmentActivity$NonConfigurationInstances.loaders;
      FragmentHostCallback fragmentHostCallback = fragmentController1.mHost;
      if (simpleArrayMap != null) {
        int j = simpleArrayMap.size();
        for (int i = 0; i < j; i++)
          ((LoaderManagerImpl)simpleArrayMap.valueAt(i)).mHost = fragmentHostCallback; 
      } 
      fragmentHostCallback.mAllLoaderManagers = simpleArrayMap;
    } 
    if (paramBundle != null) {
      FragmentManagerNonConfig fragmentManagerNonConfig;
      Parcelable parcelable = paramBundle.getParcelable("android:support:fragments");
      FragmentController fragmentController1 = this.mFragments;
      if (fragmentActivity$NonConfigurationInstances != null)
        fragmentManagerNonConfig = fragmentActivity$NonConfigurationInstances.fragments; 
      fragmentController1.mHost.mFragmentManager.restoreAllState(parcelable, fragmentManagerNonConfig);
      if (paramBundle.containsKey("android:support:next_request_index")) {
        this.mNextCandidateRequestIndex = paramBundle.getInt("android:support:next_request_index");
        int[] arrayOfInt = paramBundle.getIntArray("android:support:request_indicies");
        String[] arrayOfString = paramBundle.getStringArray("android:support:request_fragment_who");
        if (arrayOfInt == null || arrayOfString == null || arrayOfInt.length != arrayOfString.length) {
          Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
        } else {
          this.mPendingFragmentActivityResults = new SparseArrayCompat(arrayOfInt.length);
          for (int i = 0; i < arrayOfInt.length; i++)
            this.mPendingFragmentActivityResults.put(arrayOfInt[i], arrayOfString[i]); 
        } 
      } 
    } 
    if (this.mPendingFragmentActivityResults == null) {
      this.mPendingFragmentActivityResults = new SparseArrayCompat();
      this.mNextCandidateRequestIndex = 0;
    } 
    this.mFragments.mHost.mFragmentManager.dispatchCreate();
  }
  
  public final boolean onCreatePanelMenu(int paramInt, Menu paramMenu) {
    if (paramInt == 0) {
      boolean bool = super.onCreatePanelMenu(paramInt, paramMenu);
      FragmentController fragmentController = this.mFragments;
      MenuInflater menuInflater = getMenuInflater();
      return bool | fragmentController.mHost.mFragmentManager.dispatchCreateOptionsMenu(paramMenu, menuInflater);
    } 
    return super.onCreatePanelMenu(paramInt, paramMenu);
  }
  
  protected final void onDestroy() {
    super.onDestroy();
    doReallyStop(false);
    this.mFragments.mHost.mFragmentManager.dispatchDestroy();
    FragmentHostCallback fragmentHostCallback = this.mFragments.mHost;
    if (fragmentHostCallback.mLoaderManager != null)
      fragmentHostCallback.mLoaderManager.doDestroy(); 
  }
  
  public final void onLowMemory() {
    super.onLowMemory();
    this.mFragments.mHost.mFragmentManager.dispatchLowMemory();
  }
  
  public final boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem) {
    return super.onMenuItemSelected(paramInt, paramMenuItem) ? true : ((paramInt != 0) ? ((paramInt != 6) ? false : this.mFragments.mHost.mFragmentManager.dispatchContextItemSelected(paramMenuItem)) : this.mFragments.mHost.mFragmentManager.dispatchOptionsItemSelected(paramMenuItem));
  }
  
  public final void onMultiWindowModeChanged(boolean paramBoolean) {
    this.mFragments.mHost.mFragmentManager.dispatchMultiWindowModeChanged(paramBoolean);
  }
  
  protected final void onNewIntent(Intent paramIntent) {
    super.onNewIntent(paramIntent);
    this.mFragments.noteStateNotSaved();
  }
  
  public final void onPanelClosed(int paramInt, Menu paramMenu) {
    if (paramInt == 0)
      this.mFragments.mHost.mFragmentManager.dispatchOptionsMenuClosed(paramMenu); 
    super.onPanelClosed(paramInt, paramMenu);
  }
  
  protected final void onPause() {
    super.onPause();
    this.mResumed = false;
    if (this.mHandler.hasMessages(2)) {
      this.mHandler.removeMessages(2);
      onResumeFragments();
    } 
    this.mFragments.mHost.mFragmentManager.dispatchStateChange(4);
  }
  
  public final void onPictureInPictureModeChanged(boolean paramBoolean) {
    this.mFragments.mHost.mFragmentManager.dispatchPictureInPictureModeChanged(paramBoolean);
  }
  
  protected final void onPostResume() {
    super.onPostResume();
    this.mHandler.removeMessages(2);
    onResumeFragments();
    this.mFragments.execPendingActions();
  }
  
  public final boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu) {
    return (paramInt == 0 && paramMenu != null) ? (super.onPreparePanel(0, paramView, paramMenu) | this.mFragments.mHost.mFragmentManager.dispatchPrepareOptionsMenu(paramMenu)) : super.onPreparePanel(paramInt, paramView, paramMenu);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfint) {
    this.mFragments.noteStateNotSaved();
    paramInt = paramInt >> 16 & 0xFFFF;
    if (paramInt != 0) {
      String str = (String)this.mPendingFragmentActivityResults.get(--paramInt);
      this.mPendingFragmentActivityResults.remove(paramInt);
      if (str == null) {
        Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
        return;
      } 
      if (this.mFragments.findFragmentByWho(str) == null) {
        StringBuilder stringBuilder = new StringBuilder("Activity result no fragment exists for who: ");
        stringBuilder.append(str);
        Log.w("FragmentActivity", stringBuilder.toString());
        return;
      } 
      Fragment.onRequestPermissionsResult$6f5af501();
    } 
  }
  
  protected final void onResume() {
    super.onResume();
    this.mHandler.sendEmptyMessage(2);
    this.mResumed = true;
    this.mFragments.execPendingActions();
  }
  
  protected final void onResumeFragments() {
    this.mFragments.mHost.mFragmentManager.dispatchResume();
  }
  
  public final Object onRetainNonConfigurationInstance() {
    if (this.mStopped)
      doReallyStop(true); 
    FragmentManagerImpl fragmentManagerImpl = this.mFragments.mHost.mFragmentManager;
    FragmentManagerImpl.setRetaining(fragmentManagerImpl.mSavedNonConfig);
    FragmentManagerNonConfig fragmentManagerNonConfig = fragmentManagerImpl.mSavedNonConfig;
    FragmentHostCallback fragmentHostCallback = this.mFragments.mHost;
    SimpleArrayMap simpleArrayMap = fragmentHostCallback.mAllLoaderManagers;
    int i = 0;
    int j = 0;
    if (simpleArrayMap != null) {
      int k = fragmentHostCallback.mAllLoaderManagers.size();
      LoaderManagerImpl[] arrayOfLoaderManagerImpl = new LoaderManagerImpl[k];
      for (i = k - 1; i >= 0; i--)
        arrayOfLoaderManagerImpl[i] = (LoaderManagerImpl)fragmentHostCallback.mAllLoaderManagers.valueAt(i); 
      boolean bool = fragmentHostCallback.mRetainLoaders;
      i = 0;
      while (j < k) {
        LoaderManagerImpl loaderManagerImpl = arrayOfLoaderManagerImpl[j];
        if (!loaderManagerImpl.mRetaining && bool) {
          if (!loaderManagerImpl.mStarted)
            loaderManagerImpl.doStart(); 
          loaderManagerImpl.doRetain();
        } 
        if (loaderManagerImpl.mRetaining) {
          i = 1;
        } else {
          loaderManagerImpl.doDestroy();
          fragmentHostCallback.mAllLoaderManagers.remove(loaderManagerImpl.mWho);
        } 
        j++;
      } 
    } 
    if (i != 0) {
      SimpleArrayMap simpleArrayMap1 = fragmentHostCallback.mAllLoaderManagers;
    } else {
      fragmentHostCallback = null;
    } 
    if (fragmentManagerNonConfig == null && fragmentHostCallback == null)
      return null; 
    FragmentActivity$NonConfigurationInstances fragmentActivity$NonConfigurationInstances = new FragmentActivity$NonConfigurationInstances();
    fragmentActivity$NonConfigurationInstances.fragments = fragmentManagerNonConfig;
    fragmentActivity$NonConfigurationInstances.loaders = (SimpleArrayMap)fragmentHostCallback;
    return fragmentActivity$NonConfigurationInstances;
  }
  
  protected final void onSaveInstanceState(Bundle paramBundle) {
    super.onSaveInstanceState(paramBundle);
    markState(this.mFragments.mHost.mFragmentManager, Lifecycle.State.CREATED);
    Parcelable parcelable = this.mFragments.mHost.mFragmentManager.saveAllState();
    if (parcelable != null)
      paramBundle.putParcelable("android:support:fragments", parcelable); 
    if (this.mPendingFragmentActivityResults.size() > 0) {
      paramBundle.putInt("android:support:next_request_index", this.mNextCandidateRequestIndex);
      int[] arrayOfInt = new int[this.mPendingFragmentActivityResults.size()];
      String[] arrayOfString = new String[this.mPendingFragmentActivityResults.size()];
      for (int i = 0; i < this.mPendingFragmentActivityResults.size(); i++) {
        arrayOfInt[i] = this.mPendingFragmentActivityResults.keyAt(i);
        arrayOfString[i] = (String)this.mPendingFragmentActivityResults.valueAt(i);
      } 
      paramBundle.putIntArray("android:support:request_indicies", arrayOfInt);
      paramBundle.putStringArray("android:support:request_fragment_who", arrayOfString);
    } 
  }
  
  protected final void onStart() {
    super.onStart();
    this.mStopped = false;
    this.mReallyStopped = false;
    this.mHandler.removeMessages(1);
    if (!this.mCreated) {
      this.mCreated = true;
      this.mFragments.mHost.mFragmentManager.dispatchActivityCreated();
    } 
    this.mFragments.noteStateNotSaved();
    this.mFragments.execPendingActions();
    this.mFragments.doLoaderStart();
    this.mFragments.mHost.mFragmentManager.dispatchStart();
    FragmentHostCallback fragmentHostCallback = this.mFragments.mHost;
    if (fragmentHostCallback.mAllLoaderManagers != null) {
      int j = fragmentHostCallback.mAllLoaderManagers.size();
      LoaderManagerImpl[] arrayOfLoaderManagerImpl = new LoaderManagerImpl[j];
      int i;
      for (i = j - 1; i >= 0; i--)
        arrayOfLoaderManagerImpl[i] = (LoaderManagerImpl)fragmentHostCallback.mAllLoaderManagers.valueAt(i); 
      for (i = 0; i < j; i++) {
        LoaderManagerImpl loaderManagerImpl = arrayOfLoaderManagerImpl[i];
        if (loaderManagerImpl.mRetaining) {
          if (LoaderManagerImpl.DEBUG)
            (new StringBuilder("Finished Retaining in ")).append(loaderManagerImpl); 
          loaderManagerImpl.mRetaining = false;
          for (int k = loaderManagerImpl.mLoaders.size() - 1; k >= 0; k--) {
            LoaderManagerImpl$LoaderInfo loaderManagerImpl$LoaderInfo = (LoaderManagerImpl$LoaderInfo)loaderManagerImpl.mLoaders.valueAt(k);
            if (loaderManagerImpl$LoaderInfo.mRetaining) {
              if (LoaderManagerImpl.DEBUG)
                (new StringBuilder("  Finished Retaining: ")).append(loaderManagerImpl$LoaderInfo); 
              loaderManagerImpl$LoaderInfo.mRetaining = false;
              if (loaderManagerImpl$LoaderInfo.mStarted != loaderManagerImpl$LoaderInfo.mRetainingStarted && !loaderManagerImpl$LoaderInfo.mStarted)
                loaderManagerImpl$LoaderInfo.stop(); 
            } 
            if (loaderManagerImpl$LoaderInfo.mStarted && loaderManagerImpl$LoaderInfo.mHaveData && !loaderManagerImpl$LoaderInfo.mReportNextStart)
              loaderManagerImpl$LoaderInfo.callOnLoadFinished(loaderManagerImpl$LoaderInfo.mLoader, loaderManagerImpl$LoaderInfo.mData); 
          } 
        } 
        loaderManagerImpl.doReportStart();
      } 
    } 
  }
  
  public final void onStateNotSaved() {
    this.mFragments.noteStateNotSaved();
  }
  
  protected final void onStop() {
    super.onStop();
    this.mStopped = true;
    markState(this.mFragments.mHost.mFragmentManager, Lifecycle.State.CREATED);
    this.mHandler.sendEmptyMessage(1);
    this.mFragments.mHost.mFragmentManager.dispatchStop();
  }
  
  public final void startActivityForResult(Intent paramIntent, int paramInt) {
    if (!this.mStartedActivityFromFragment && paramInt != -1)
      checkForValidRequestCode(paramInt); 
    super.startActivityForResult(paramIntent, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\app\FragmentActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */