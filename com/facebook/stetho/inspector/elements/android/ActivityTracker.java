package com.facebook.stetho.inspector.elements.android;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import com.facebook.stetho.common.Util;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.Nullable;

public final class ActivityTracker {
  private static final ActivityTracker sInstance = new ActivityTracker();
  
  private final ArrayList<WeakReference<Activity>> mActivities = new ArrayList<WeakReference<Activity>>();
  
  private final List<WeakReference<Activity>> mActivitiesUnmodifiable = Collections.unmodifiableList(this.mActivities);
  
  @Nullable
  private AutomaticTracker mAutomaticTracker;
  
  private final List<Listener> mListeners = new CopyOnWriteArrayList<Listener>();
  
  public static ActivityTracker get() {
    return sInstance;
  }
  
  private static <T> boolean removeFromWeakList(ArrayList<WeakReference<T>> paramArrayList, T paramT) {
    int j = paramArrayList.size();
    for (int i = 0; i < j; i++) {
      if (((WeakReference<T>)paramArrayList.get(i)).get() == paramT) {
        paramArrayList.remove(i);
        return true;
      } 
    } 
    return false;
  }
  
  public void add(Activity paramActivity) {
    boolean bool;
    Util.throwIfNull(paramActivity);
    if (Looper.myLooper() == Looper.getMainLooper()) {
      bool = true;
    } else {
      bool = false;
    } 
    Util.throwIfNot(bool);
    this.mActivities.add(new WeakReference<Activity>(paramActivity));
    Iterator<Listener> iterator = this.mListeners.iterator();
    while (iterator.hasNext())
      ((Listener)iterator.next()).onActivityAdded(paramActivity); 
  }
  
  public boolean beginTrackingIfPossible(Application paramApplication) {
    if (this.mAutomaticTracker == null) {
      AutomaticTracker automaticTracker = AutomaticTracker.newInstanceIfPossible(paramApplication, this);
      if (automaticTracker != null) {
        automaticTracker.register();
        this.mAutomaticTracker = automaticTracker;
        return true;
      } 
    } 
    return false;
  }
  
  public boolean endTracking() {
    AutomaticTracker automaticTracker = this.mAutomaticTracker;
    if (automaticTracker != null) {
      automaticTracker.unregister();
      this.mAutomaticTracker = null;
      return true;
    } 
    return false;
  }
  
  public List<WeakReference<Activity>> getActivitiesView() {
    return this.mActivitiesUnmodifiable;
  }
  
  public void registerListener(Listener paramListener) {
    this.mListeners.add(paramListener);
  }
  
  public void remove(Activity paramActivity) {
    boolean bool;
    Util.throwIfNull(paramActivity);
    if (Looper.myLooper() == Looper.getMainLooper()) {
      bool = true;
    } else {
      bool = false;
    } 
    Util.throwIfNot(bool);
    if (removeFromWeakList(this.mActivities, paramActivity)) {
      Iterator<Listener> iterator = this.mListeners.iterator();
      while (iterator.hasNext())
        ((Listener)iterator.next()).onActivityRemoved(paramActivity); 
    } 
  }
  
  @Nullable
  public Activity tryGetTopActivity() {
    if (this.mActivitiesUnmodifiable.isEmpty())
      return null; 
    for (int i = this.mActivitiesUnmodifiable.size() - 1; i >= 0; i--) {
      Activity activity = ((WeakReference<Activity>)this.mActivitiesUnmodifiable.get(i)).get();
      if (activity != null)
        return activity; 
    } 
    return null;
  }
  
  public void unregisterListener(Listener paramListener) {
    this.mListeners.remove(paramListener);
  }
  
  static abstract class AutomaticTracker {
    private AutomaticTracker() {}
    
    @Nullable
    public static AutomaticTracker newInstanceIfPossible(Application param1Application, ActivityTracker param1ActivityTracker) {
      return (Build.VERSION.SDK_INT >= 14) ? new AutomaticTrackerICSAndBeyond(param1Application, param1ActivityTracker) : null;
    }
    
    public abstract void register();
    
    public abstract void unregister();
    
    static class AutomaticTrackerICSAndBeyond extends AutomaticTracker {
      private final Application mApplication;
      
      private final Application.ActivityLifecycleCallbacks mLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() {
          public void onActivityCreated(Activity param3Activity, Bundle param3Bundle) {
            ActivityTracker.AutomaticTracker.AutomaticTrackerICSAndBeyond.this.mTracker.add(param3Activity);
          }
          
          public void onActivityDestroyed(Activity param3Activity) {
            ActivityTracker.AutomaticTracker.AutomaticTrackerICSAndBeyond.this.mTracker.remove(param3Activity);
          }
          
          public void onActivityPaused(Activity param3Activity) {}
          
          public void onActivityResumed(Activity param3Activity) {}
          
          public void onActivitySaveInstanceState(Activity param3Activity, Bundle param3Bundle) {}
          
          public void onActivityStarted(Activity param3Activity) {}
          
          public void onActivityStopped(Activity param3Activity) {}
        };
      
      private final ActivityTracker mTracker;
      
      public AutomaticTrackerICSAndBeyond(Application param2Application, ActivityTracker param2ActivityTracker) {
        this.mApplication = param2Application;
        this.mTracker = param2ActivityTracker;
      }
      
      public void register() {
        this.mApplication.registerActivityLifecycleCallbacks(this.mLifecycleCallbacks);
      }
      
      public void unregister() {
        this.mApplication.unregisterActivityLifecycleCallbacks(this.mLifecycleCallbacks);
      }
    }
    
    class null implements Application.ActivityLifecycleCallbacks {
      public void onActivityCreated(Activity param2Activity, Bundle param2Bundle) {
        this.this$0.mTracker.add(param2Activity);
      }
      
      public void onActivityDestroyed(Activity param2Activity) {
        this.this$0.mTracker.remove(param2Activity);
      }
      
      public void onActivityPaused(Activity param2Activity) {}
      
      public void onActivityResumed(Activity param2Activity) {}
      
      public void onActivitySaveInstanceState(Activity param2Activity, Bundle param2Bundle) {}
      
      public void onActivityStarted(Activity param2Activity) {}
      
      public void onActivityStopped(Activity param2Activity) {}
    }
  }
  
  static class AutomaticTrackerICSAndBeyond extends AutomaticTracker {
    private final Application mApplication;
    
    private final Application.ActivityLifecycleCallbacks mLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() {
        public void onActivityCreated(Activity param3Activity, Bundle param3Bundle) {
          ActivityTracker.AutomaticTracker.AutomaticTrackerICSAndBeyond.this.mTracker.add(param3Activity);
        }
        
        public void onActivityDestroyed(Activity param3Activity) {
          ActivityTracker.AutomaticTracker.AutomaticTrackerICSAndBeyond.this.mTracker.remove(param3Activity);
        }
        
        public void onActivityPaused(Activity param3Activity) {}
        
        public void onActivityResumed(Activity param3Activity) {}
        
        public void onActivitySaveInstanceState(Activity param3Activity, Bundle param3Bundle) {}
        
        public void onActivityStarted(Activity param3Activity) {}
        
        public void onActivityStopped(Activity param3Activity) {}
      };
    
    private final ActivityTracker mTracker;
    
    public AutomaticTrackerICSAndBeyond(Application param1Application, ActivityTracker param1ActivityTracker) {
      this.mApplication = param1Application;
      this.mTracker = param1ActivityTracker;
    }
    
    public void register() {
      this.mApplication.registerActivityLifecycleCallbacks(this.mLifecycleCallbacks);
    }
    
    public void unregister() {
      this.mApplication.unregisterActivityLifecycleCallbacks(this.mLifecycleCallbacks);
    }
  }
  
  class null implements Application.ActivityLifecycleCallbacks {
    public void onActivityCreated(Activity param1Activity, Bundle param1Bundle) {
      this.this$0.mTracker.add(param1Activity);
    }
    
    public void onActivityDestroyed(Activity param1Activity) {
      this.this$0.mTracker.remove(param1Activity);
    }
    
    public void onActivityPaused(Activity param1Activity) {}
    
    public void onActivityResumed(Activity param1Activity) {}
    
    public void onActivitySaveInstanceState(Activity param1Activity, Bundle param1Bundle) {}
    
    public void onActivityStarted(Activity param1Activity) {}
    
    public void onActivityStopped(Activity param1Activity) {}
  }
  
  public static interface Listener {
    void onActivityAdded(Activity param1Activity);
    
    void onActivityRemoved(Activity param1Activity);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\elements\android\ActivityTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */