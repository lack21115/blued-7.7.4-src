package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.util.SimpleArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class FragmentHostCallback extends FragmentContainer {
  final Activity mActivity;
  
  SimpleArrayMap mAllLoaderManagers;
  
  boolean mCheckedForLoaderManager;
  
  final Context mContext;
  
  final FragmentManagerImpl mFragmentManager = new FragmentManagerImpl();
  
  final Handler mHandler;
  
  LoaderManagerImpl mLoaderManager;
  
  boolean mLoadersStarted;
  
  boolean mRetainLoaders;
  
  private int mWindowAnimations;
  
  private FragmentHostCallback(Activity paramActivity, Context paramContext, Handler paramHandler, int paramInt) {
    this.mActivity = paramActivity;
    this.mContext = paramContext;
    this.mHandler = paramHandler;
    this.mWindowAnimations = paramInt;
  }
  
  FragmentHostCallback(FragmentActivity paramFragmentActivity) {
    this(paramFragmentActivity, (Context)paramFragmentActivity, paramFragmentActivity.mHandler, 0);
  }
  
  final LoaderManagerImpl getLoaderManager(String paramString, boolean paramBoolean1, boolean paramBoolean2) {
    if (this.mAllLoaderManagers == null)
      this.mAllLoaderManagers = new SimpleArrayMap(); 
    LoaderManagerImpl loaderManagerImpl = (LoaderManagerImpl)this.mAllLoaderManagers.get(paramString);
    if (loaderManagerImpl == null && paramBoolean2) {
      loaderManagerImpl = new LoaderManagerImpl(paramString, this, paramBoolean1);
      this.mAllLoaderManagers.put(paramString, loaderManagerImpl);
      return loaderManagerImpl;
    } 
    if (paramBoolean1 && loaderManagerImpl != null && !loaderManagerImpl.mStarted)
      loaderManagerImpl.doStart(); 
    return loaderManagerImpl;
  }
  
  final void inactivateFragment(String paramString) {
    if (this.mAllLoaderManagers != null) {
      LoaderManagerImpl loaderManagerImpl = (LoaderManagerImpl)this.mAllLoaderManagers.get(paramString);
      if (loaderManagerImpl != null && !loaderManagerImpl.mRetaining) {
        loaderManagerImpl.doDestroy();
        this.mAllLoaderManagers.remove(paramString);
      } 
    } 
  }
  
  public void onDump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  public View onFindViewById(int paramInt) {
    return null;
  }
  
  public LayoutInflater onGetLayoutInflater() {
    return LayoutInflater.from(this.mContext);
  }
  
  public int onGetWindowAnimations() {
    return this.mWindowAnimations;
  }
  
  public boolean onHasView() {
    return true;
  }
  
  public boolean onHasWindowAnimations() {
    return true;
  }
  
  public boolean onShouldSaveFragmentState$6585081f() {
    return true;
  }
  
  public void onStartActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt, Bundle paramBundle) {
    if (paramInt == -1) {
      this.mContext.startActivity(paramIntent);
      return;
    } 
    throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
  }
  
  public void onSupportInvalidateOptionsMenu() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\app\FragmentHostCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */