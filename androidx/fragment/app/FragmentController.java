package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Preconditions;
import androidx.loader.app.LoaderManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FragmentController {
  private final FragmentHostCallback<?> a;
  
  private FragmentController(FragmentHostCallback<?> paramFragmentHostCallback) {
    this.a = paramFragmentHostCallback;
  }
  
  public static FragmentController createController(FragmentHostCallback<?> paramFragmentHostCallback) {
    return new FragmentController((FragmentHostCallback)Preconditions.checkNotNull(paramFragmentHostCallback, "callbacks == null"));
  }
  
  public void attachHost(Fragment paramFragment) {
    FragmentManagerImpl fragmentManagerImpl = this.a.b;
    FragmentHostCallback<?> fragmentHostCallback = this.a;
    fragmentManagerImpl.attachController(fragmentHostCallback, fragmentHostCallback, paramFragment);
  }
  
  public void dispatchActivityCreated() {
    this.a.b.dispatchActivityCreated();
  }
  
  public void dispatchConfigurationChanged(Configuration paramConfiguration) {
    this.a.b.dispatchConfigurationChanged(paramConfiguration);
  }
  
  public boolean dispatchContextItemSelected(MenuItem paramMenuItem) {
    return this.a.b.dispatchContextItemSelected(paramMenuItem);
  }
  
  public void dispatchCreate() {
    this.a.b.dispatchCreate();
  }
  
  public boolean dispatchCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater) {
    return this.a.b.dispatchCreateOptionsMenu(paramMenu, paramMenuInflater);
  }
  
  public void dispatchDestroy() {
    this.a.b.dispatchDestroy();
  }
  
  public void dispatchDestroyView() {
    this.a.b.dispatchDestroyView();
  }
  
  public void dispatchLowMemory() {
    this.a.b.dispatchLowMemory();
  }
  
  public void dispatchMultiWindowModeChanged(boolean paramBoolean) {
    this.a.b.dispatchMultiWindowModeChanged(paramBoolean);
  }
  
  public boolean dispatchOptionsItemSelected(MenuItem paramMenuItem) {
    return this.a.b.dispatchOptionsItemSelected(paramMenuItem);
  }
  
  public void dispatchOptionsMenuClosed(Menu paramMenu) {
    this.a.b.dispatchOptionsMenuClosed(paramMenu);
  }
  
  public void dispatchPause() {
    this.a.b.dispatchPause();
  }
  
  public void dispatchPictureInPictureModeChanged(boolean paramBoolean) {
    this.a.b.dispatchPictureInPictureModeChanged(paramBoolean);
  }
  
  public boolean dispatchPrepareOptionsMenu(Menu paramMenu) {
    return this.a.b.dispatchPrepareOptionsMenu(paramMenu);
  }
  
  @Deprecated
  public void dispatchReallyStop() {}
  
  public void dispatchResume() {
    this.a.b.dispatchResume();
  }
  
  public void dispatchStart() {
    this.a.b.dispatchStart();
  }
  
  public void dispatchStop() {
    this.a.b.dispatchStop();
  }
  
  @Deprecated
  public void doLoaderDestroy() {}
  
  @Deprecated
  public void doLoaderRetain() {}
  
  @Deprecated
  public void doLoaderStart() {}
  
  @Deprecated
  public void doLoaderStop(boolean paramBoolean) {}
  
  @Deprecated
  public void dumpLoaders(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  public boolean execPendingActions() {
    return this.a.b.execPendingActions();
  }
  
  public Fragment findFragmentByWho(String paramString) {
    return this.a.b.findFragmentByWho(paramString);
  }
  
  public List<Fragment> getActiveFragments(List<Fragment> paramList) {
    return this.a.b.b();
  }
  
  public int getActiveFragmentsCount() {
    return this.a.b.c();
  }
  
  public FragmentManager getSupportFragmentManager() {
    return this.a.b;
  }
  
  @Deprecated
  public LoaderManager getSupportLoaderManager() {
    throw new UnsupportedOperationException("Loaders are managed separately from FragmentController, use LoaderManager.getInstance() to obtain a LoaderManager.");
  }
  
  public void noteStateNotSaved() {
    this.a.b.noteStateNotSaved();
  }
  
  public View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet) {
    return this.a.b.onCreateView(paramView, paramString, paramContext, paramAttributeSet);
  }
  
  @Deprecated
  public void reportLoaderStart() {}
  
  @Deprecated
  public void restoreAllState(Parcelable paramParcelable, FragmentManagerNonConfig paramFragmentManagerNonConfig) {
    this.a.b.a(paramParcelable, paramFragmentManagerNonConfig);
  }
  
  @Deprecated
  public void restoreAllState(Parcelable paramParcelable, List<Fragment> paramList) {
    this.a.b.a(paramParcelable, new FragmentManagerNonConfig(paramList, null, null));
  }
  
  @Deprecated
  public void restoreLoaderNonConfig(SimpleArrayMap<String, LoaderManager> paramSimpleArrayMap) {}
  
  public void restoreSaveState(Parcelable paramParcelable) {
    FragmentHostCallback<?> fragmentHostCallback = this.a;
    if (fragmentHostCallback instanceof androidx.lifecycle.ViewModelStoreOwner) {
      fragmentHostCallback.b.a(paramParcelable);
      return;
    } 
    throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
  }
  
  @Deprecated
  public SimpleArrayMap<String, LoaderManager> retainLoaderNonConfig() {
    return null;
  }
  
  @Deprecated
  public FragmentManagerNonConfig retainNestedNonConfig() {
    return this.a.b.h();
  }
  
  @Deprecated
  public List<Fragment> retainNonConfig() {
    FragmentManagerNonConfig fragmentManagerNonConfig = this.a.b.h();
    return (fragmentManagerNonConfig != null && fragmentManagerNonConfig.a() != null) ? new ArrayList<Fragment>(fragmentManagerNonConfig.a()) : null;
  }
  
  public Parcelable saveAllState() {
    return this.a.b.i();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\fragment\app\FragmentController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */