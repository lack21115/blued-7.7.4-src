package androidx.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.core.app.ComponentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;

public class ComponentActivity extends ComponentActivity implements OnBackPressedDispatcherOwner, LifecycleOwner, ViewModelStoreOwner, SavedStateRegistryOwner {
  private int mContentLayoutId;
  
  private final LifecycleRegistry mLifecycleRegistry = new LifecycleRegistry(this);
  
  private final OnBackPressedDispatcher mOnBackPressedDispatcher = new OnBackPressedDispatcher(new Runnable(this) {
        public void run() {
          this.a.onBackPressed();
        }
      });
  
  private final SavedStateRegistryController mSavedStateRegistryController = SavedStateRegistryController.create(this);
  
  private ViewModelStore mViewModelStore;
  
  public ComponentActivity() {
    if (getLifecycle() != null) {
      if (Build.VERSION.SDK_INT >= 19)
        getLifecycle().addObserver((LifecycleObserver)new LifecycleEventObserver(this) {
              public void onStateChanged(LifecycleOwner param1LifecycleOwner, Lifecycle.Event param1Event) {
                if (param1Event == Lifecycle.Event.ON_STOP) {
                  Window window = this.a.getWindow();
                  if (window != null) {
                    View view = window.peekDecorView();
                  } else {
                    window = null;
                  } 
                  if (window != null)
                    window.cancelPendingInputEvents(); 
                } 
              }
            }); 
      getLifecycle().addObserver((LifecycleObserver)new LifecycleEventObserver(this) {
            public void onStateChanged(LifecycleOwner param1LifecycleOwner, Lifecycle.Event param1Event) {
              if (param1Event == Lifecycle.Event.ON_DESTROY && !this.a.isChangingConfigurations())
                this.a.getViewModelStore().clear(); 
            }
          });
      if (19 <= Build.VERSION.SDK_INT && Build.VERSION.SDK_INT <= 23)
        getLifecycle().addObserver((LifecycleObserver)new ImmLeaksCleaner((Activity)this)); 
      return;
    } 
    throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
  }
  
  public ComponentActivity(int paramInt) {
    this();
    this.mContentLayoutId = paramInt;
  }
  
  @Deprecated
  public Object getLastCustomNonConfigurationInstance() {
    NonConfigurationInstances nonConfigurationInstances = (NonConfigurationInstances)getLastNonConfigurationInstance();
    return (nonConfigurationInstances != null) ? nonConfigurationInstances.a : null;
  }
  
  public Lifecycle getLifecycle() {
    return (Lifecycle)this.mLifecycleRegistry;
  }
  
  public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
    return this.mOnBackPressedDispatcher;
  }
  
  public final SavedStateRegistry getSavedStateRegistry() {
    return this.mSavedStateRegistryController.getSavedStateRegistry();
  }
  
  public ViewModelStore getViewModelStore() {
    if (getApplication() != null) {
      if (this.mViewModelStore == null) {
        NonConfigurationInstances nonConfigurationInstances = (NonConfigurationInstances)getLastNonConfigurationInstance();
        if (nonConfigurationInstances != null)
          this.mViewModelStore = nonConfigurationInstances.b; 
        if (this.mViewModelStore == null)
          this.mViewModelStore = new ViewModelStore(); 
      } 
      return this.mViewModelStore;
    } 
    throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
  }
  
  public void onBackPressed() {
    this.mOnBackPressedDispatcher.onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.mSavedStateRegistryController.performRestore(paramBundle);
    ReportFragment.injectIfNeededIn((Activity)this);
    int i = this.mContentLayoutId;
    if (i != 0)
      setContentView(i); 
  }
  
  @Deprecated
  public Object onRetainCustomNonConfigurationInstance() {
    return null;
  }
  
  public final Object onRetainNonConfigurationInstance() {
    Object object = onRetainCustomNonConfigurationInstance();
    ViewModelStore viewModelStore2 = this.mViewModelStore;
    ViewModelStore viewModelStore1 = viewModelStore2;
    if (viewModelStore2 == null) {
      NonConfigurationInstances nonConfigurationInstances1 = (NonConfigurationInstances)getLastNonConfigurationInstance();
      viewModelStore1 = viewModelStore2;
      if (nonConfigurationInstances1 != null)
        viewModelStore1 = nonConfigurationInstances1.b; 
    } 
    if (viewModelStore1 == null && object == null)
      return null; 
    NonConfigurationInstances nonConfigurationInstances = new NonConfigurationInstances();
    nonConfigurationInstances.a = object;
    nonConfigurationInstances.b = viewModelStore1;
    return nonConfigurationInstances;
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {
    Lifecycle lifecycle = getLifecycle();
    if (lifecycle instanceof LifecycleRegistry)
      ((LifecycleRegistry)lifecycle).setCurrentState(Lifecycle.State.CREATED); 
    super.onSaveInstanceState(paramBundle);
    this.mSavedStateRegistryController.performSave(paramBundle);
  }
  
  static final class NonConfigurationInstances {
    Object a;
    
    ViewModelStore b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\activity\ComponentActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */