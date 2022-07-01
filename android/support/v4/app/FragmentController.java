package android.support.v4.app;

public final class FragmentController {
  final FragmentHostCallback mHost;
  
  FragmentController(FragmentHostCallback paramFragmentHostCallback) {
    this.mHost = paramFragmentHostCallback;
  }
  
  public final void doLoaderStart() {
    FragmentHostCallback fragmentHostCallback = this.mHost;
    if (!fragmentHostCallback.mLoadersStarted) {
      fragmentHostCallback.mLoadersStarted = true;
      if (fragmentHostCallback.mLoaderManager != null) {
        fragmentHostCallback.mLoaderManager.doStart();
      } else if (!fragmentHostCallback.mCheckedForLoaderManager) {
        fragmentHostCallback.mLoaderManager = fragmentHostCallback.getLoaderManager("(root)", fragmentHostCallback.mLoadersStarted, false);
        if (fragmentHostCallback.mLoaderManager != null && !fragmentHostCallback.mLoaderManager.mStarted)
          fragmentHostCallback.mLoaderManager.doStart(); 
      } 
      fragmentHostCallback.mCheckedForLoaderManager = true;
    } 
  }
  
  public final void doLoaderStop(boolean paramBoolean) {
    FragmentHostCallback fragmentHostCallback = this.mHost;
    fragmentHostCallback.mRetainLoaders = paramBoolean;
    if (fragmentHostCallback.mLoaderManager != null && fragmentHostCallback.mLoadersStarted) {
      fragmentHostCallback.mLoadersStarted = false;
      if (paramBoolean) {
        fragmentHostCallback.mLoaderManager.doRetain();
        return;
      } 
      fragmentHostCallback.mLoaderManager.doStop();
    } 
  }
  
  public final boolean execPendingActions() {
    return this.mHost.mFragmentManager.execPendingActions();
  }
  
  public final Fragment findFragmentByWho(String paramString) {
    return this.mHost.mFragmentManager.findFragmentByWho(paramString);
  }
  
  public final void noteStateNotSaved() {
    this.mHost.mFragmentManager.noteStateNotSaved();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\app\FragmentController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */