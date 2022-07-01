package androidx.viewpager2.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.collection.ArraySet;
import androidx.collection.LongSparseArray;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Iterator;

public abstract class FragmentStateAdapter extends RecyclerView.Adapter<FragmentViewHolder> implements StatefulAdapter {
  final Lifecycle a;
  
  final FragmentManager b;
  
  final LongSparseArray<Fragment> c = new LongSparseArray();
  
  boolean d = false;
  
  private final LongSparseArray<Fragment.SavedState> e = new LongSparseArray();
  
  private final LongSparseArray<Integer> f = new LongSparseArray();
  
  private FragmentMaxLifecycleEnforcer g;
  
  private boolean h = false;
  
  public FragmentStateAdapter(Fragment paramFragment) {
    this(paramFragment.getChildFragmentManager(), paramFragment.getLifecycle());
  }
  
  public FragmentStateAdapter(FragmentActivity paramFragmentActivity) {
    this(paramFragmentActivity.getSupportFragmentManager(), paramFragmentActivity.getLifecycle());
  }
  
  public FragmentStateAdapter(FragmentManager paramFragmentManager, Lifecycle paramLifecycle) {
    this.b = paramFragmentManager;
    this.a = paramLifecycle;
    super.setHasStableIds(true);
  }
  
  private Long a(int paramInt) {
    Long long_ = null;
    int i = 0;
    while (i < this.f.size()) {
      Long long_1 = long_;
      if (((Integer)this.f.valueAt(i)).intValue() == paramInt)
        if (long_ == null) {
          long_1 = Long.valueOf(this.f.keyAt(i));
        } else {
          throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
        }  
      i++;
      long_ = long_1;
    } 
    return long_;
  }
  
  private static String a(String paramString, long paramLong) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(paramLong);
    return stringBuilder.toString();
  }
  
  private void a(Fragment paramFragment, FrameLayout paramFrameLayout) {
    this.b.registerFragmentLifecycleCallbacks(new FragmentManager.FragmentLifecycleCallbacks(this, paramFragment, paramFrameLayout) {
          public void onFragmentViewCreated(FragmentManager param1FragmentManager, Fragment param1Fragment, View param1View, Bundle param1Bundle) {
            if (param1Fragment == this.a) {
              param1FragmentManager.unregisterFragmentLifecycleCallbacks(this);
              this.c.a(param1View, this.b);
            } 
          }
        }false);
  }
  
  private boolean a(long paramLong) {
    if (this.f.containsKey(paramLong))
      return true; 
    Fragment fragment = (Fragment)this.c.get(paramLong);
    boolean bool = false;
    if (fragment == null)
      return false; 
    View view = fragment.getView();
    if (view == null)
      return false; 
    if (view.getParent() != null)
      bool = true; 
    return bool;
  }
  
  private static boolean a(String paramString1, String paramString2) {
    return (paramString1.startsWith(paramString2) && paramString1.length() > paramString2.length());
  }
  
  private static long b(String paramString1, String paramString2) {
    return Long.parseLong(paramString1.substring(paramString2.length()));
  }
  
  private void b(int paramInt) {
    long l = getItemId(paramInt);
    if (!this.c.containsKey(l)) {
      Fragment fragment = createFragment(paramInt);
      fragment.setInitialSavedState((Fragment.SavedState)this.e.get(l));
      this.c.put(l, fragment);
    } 
  }
  
  private void b(long paramLong) {
    Fragment fragment = (Fragment)this.c.get(paramLong);
    if (fragment == null)
      return; 
    if (fragment.getView() != null) {
      ViewParent viewParent = fragment.getView().getParent();
      if (viewParent != null)
        ((FrameLayout)viewParent).removeAllViews(); 
    } 
    if (!containsItem(paramLong))
      this.e.remove(paramLong); 
    if (!fragment.isAdded()) {
      this.c.remove(paramLong);
      return;
    } 
    if (b()) {
      this.h = true;
      return;
    } 
    if (fragment.isAdded() && containsItem(paramLong))
      this.e.put(paramLong, this.b.saveFragmentInstanceState(fragment)); 
    this.b.beginTransaction().remove(fragment).commitNow();
    this.c.remove(paramLong);
  }
  
  private void c() {
    Handler handler = new Handler(Looper.getMainLooper());
    Runnable runnable = new Runnable(this) {
        public void run() {
          FragmentStateAdapter fragmentStateAdapter = this.a;
          fragmentStateAdapter.d = false;
          fragmentStateAdapter.a();
        }
      };
    this.a.addObserver((LifecycleObserver)new LifecycleEventObserver(this, handler, runnable) {
          public void onStateChanged(LifecycleOwner param1LifecycleOwner, Lifecycle.Event param1Event) {
            if (param1Event == Lifecycle.Event.ON_DESTROY) {
              this.a.removeCallbacks(this.b);
              param1LifecycleOwner.getLifecycle().removeObserver((LifecycleObserver)this);
            } 
          }
        });
    handler.postDelayed(runnable, 10000L);
  }
  
  void a() {
    if (this.h) {
      if (b())
        return; 
      ArraySet<Long> arraySet = new ArraySet();
      boolean bool = false;
      int i;
      for (i = 0; i < this.c.size(); i++) {
        long l = this.c.keyAt(i);
        if (!containsItem(l)) {
          arraySet.add(Long.valueOf(l));
          this.f.remove(l);
        } 
      } 
      if (!this.d) {
        this.h = false;
        for (i = bool; i < this.c.size(); i++) {
          long l = this.c.keyAt(i);
          if (!a(l))
            arraySet.add(Long.valueOf(l)); 
        } 
      } 
      Iterator<Long> iterator = arraySet.iterator();
      while (iterator.hasNext())
        b(((Long)iterator.next()).longValue()); 
    } 
  }
  
  void a(View paramView, FrameLayout paramFrameLayout) {
    if (paramFrameLayout.getChildCount() <= 1) {
      if (paramView.getParent() == paramFrameLayout)
        return; 
      if (paramFrameLayout.getChildCount() > 0)
        paramFrameLayout.removeAllViews(); 
      if (paramView.getParent() != null)
        ((ViewGroup)paramView.getParent()).removeView(paramView); 
      paramFrameLayout.addView(paramView);
      return;
    } 
    throw new IllegalStateException("Design assumption violated.");
  }
  
  void a(FragmentViewHolder paramFragmentViewHolder) {
    Fragment fragment = (Fragment)this.c.get(paramFragmentViewHolder.getItemId());
    if (fragment != null) {
      FrameLayout frameLayout = paramFragmentViewHolder.w();
      View view = fragment.getView();
      if (fragment.isAdded() || view == null) {
        if (fragment.isAdded() && view == null) {
          a(fragment, frameLayout);
          return;
        } 
        if (fragment.isAdded() && view.getParent() != null) {
          if (view.getParent() != frameLayout)
            a(view, frameLayout); 
          return;
        } 
        if (fragment.isAdded()) {
          a(view, frameLayout);
          return;
        } 
        if (!b()) {
          a(fragment, frameLayout);
          FragmentTransaction fragmentTransaction = this.b.beginTransaction();
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("f");
          stringBuilder.append(paramFragmentViewHolder.getItemId());
          fragmentTransaction.add(fragment, stringBuilder.toString()).setMaxLifecycle(fragment, Lifecycle.State.STARTED).commitNow();
          this.g.a(false);
          return;
        } 
        if (this.b.isDestroyed())
          return; 
        this.a.addObserver((LifecycleObserver)new LifecycleEventObserver(this, paramFragmentViewHolder) {
              public void onStateChanged(LifecycleOwner param1LifecycleOwner, Lifecycle.Event param1Event) {
                if (this.b.b())
                  return; 
                param1LifecycleOwner.getLifecycle().removeObserver((LifecycleObserver)this);
                if (ViewCompat.isAttachedToWindow((View)this.a.w()))
                  this.b.a(this.a); 
              }
            });
        return;
      } 
      throw new IllegalStateException("Design assumption violated.");
    } 
    throw new IllegalStateException("Design assumption violated.");
  }
  
  boolean b() {
    return this.b.isStateSaved();
  }
  
  public boolean containsItem(long paramLong) {
    return (paramLong >= 0L && paramLong < getItemCount());
  }
  
  public abstract Fragment createFragment(int paramInt);
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView) {
    boolean bool;
    if (this.g == null) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool);
    this.g = new FragmentMaxLifecycleEnforcer(this);
    this.g.a(paramRecyclerView);
  }
  
  public final void onBindViewHolder(FragmentViewHolder paramFragmentViewHolder, int paramInt) {
    long l = paramFragmentViewHolder.getItemId();
    int i = paramFragmentViewHolder.w().getId();
    Long long_ = a(i);
    if (long_ != null && long_.longValue() != l) {
      b(long_.longValue());
      this.f.remove(long_.longValue());
    } 
    this.f.put(l, Integer.valueOf(i));
    b(paramInt);
    FrameLayout frameLayout = paramFragmentViewHolder.w();
    if (ViewCompat.isAttachedToWindow((View)frameLayout))
      if (frameLayout.getParent() == null) {
        frameLayout.addOnLayoutChangeListener(new View.OnLayoutChangeListener(this, frameLayout, paramFragmentViewHolder) {
              public void onLayoutChange(View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4, int param1Int5, int param1Int6, int param1Int7, int param1Int8) {
                if (this.a.getParent() != null) {
                  this.a.removeOnLayoutChangeListener(this);
                  this.c.a(this.b);
                } 
              }
            });
      } else {
        throw new IllegalStateException("Design assumption violated.");
      }  
    a();
  }
  
  public final FragmentViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt) {
    return FragmentViewHolder.a(paramViewGroup);
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView) {
    this.g.b(paramRecyclerView);
    this.g = null;
  }
  
  public final boolean onFailedToRecycleView(FragmentViewHolder paramFragmentViewHolder) {
    return true;
  }
  
  public final void onViewAttachedToWindow(FragmentViewHolder paramFragmentViewHolder) {
    a(paramFragmentViewHolder);
    a();
  }
  
  public final void onViewRecycled(FragmentViewHolder paramFragmentViewHolder) {
    Long long_ = a(paramFragmentViewHolder.w().getId());
    if (long_ != null) {
      b(long_.longValue());
      this.f.remove(long_.longValue());
    } 
  }
  
  public final void restoreState(Parcelable paramParcelable) {
    if (this.e.isEmpty() && this.c.isEmpty()) {
      Bundle bundle = (Bundle)paramParcelable;
      if (bundle.getClassLoader() == null)
        bundle.setClassLoader(getClass().getClassLoader()); 
      for (String str : bundle.keySet()) {
        Fragment fragment;
        Fragment.SavedState savedState;
        if (a(str, "f#")) {
          long l = b(str, "f#");
          fragment = this.b.getFragment(bundle, str);
          this.c.put(l, fragment);
          continue;
        } 
        if (a((String)fragment, "s#")) {
          long l = b((String)fragment, "s#");
          savedState = (Fragment.SavedState)bundle.getParcelable((String)fragment);
          if (containsItem(l))
            this.e.put(l, savedState); 
          continue;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected key in savedState: ");
        stringBuilder.append((String)savedState);
        throw new IllegalArgumentException(stringBuilder.toString());
      } 
      if (!this.c.isEmpty()) {
        this.h = true;
        this.d = true;
        a();
        c();
      } 
      return;
    } 
    throw new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
  }
  
  public final Parcelable saveState() {
    int j;
    Bundle bundle = new Bundle(this.c.size() + this.e.size());
    byte b = 0;
    int i = 0;
    while (true) {
      j = b;
      if (i < this.c.size()) {
        long l = this.c.keyAt(i);
        Fragment fragment = (Fragment)this.c.get(l);
        if (fragment != null && fragment.isAdded()) {
          String str = a("f#", l);
          this.b.putFragment(bundle, str, fragment);
        } 
        i++;
        continue;
      } 
      break;
    } 
    while (j < this.e.size()) {
      long l = this.e.keyAt(j);
      if (containsItem(l))
        bundle.putParcelable(a("s#", l), (Parcelable)this.e.get(l)); 
      j++;
    } 
    return (Parcelable)bundle;
  }
  
  public final void setHasStableIds(boolean paramBoolean) {
    throw new UnsupportedOperationException("Stable Ids are required for the adapter to function properly, and the adapter takes care of setting the flag.");
  }
  
  static abstract class DataSetChangeObserver extends RecyclerView.AdapterDataObserver {
    private DataSetChangeObserver() {}
    
    public abstract void onChanged();
    
    public final void onItemRangeChanged(int param1Int1, int param1Int2) {
      onChanged();
    }
    
    public final void onItemRangeChanged(int param1Int1, int param1Int2, Object param1Object) {
      onChanged();
    }
    
    public final void onItemRangeInserted(int param1Int1, int param1Int2) {
      onChanged();
    }
    
    public final void onItemRangeMoved(int param1Int1, int param1Int2, int param1Int3) {
      onChanged();
    }
    
    public final void onItemRangeRemoved(int param1Int1, int param1Int2) {
      onChanged();
    }
  }
  
  class FragmentMaxLifecycleEnforcer {
    private ViewPager2.OnPageChangeCallback b;
    
    private RecyclerView.AdapterDataObserver c;
    
    private LifecycleEventObserver d;
    
    private ViewPager2 e;
    
    private long f = -1L;
    
    FragmentMaxLifecycleEnforcer(FragmentStateAdapter this$0) {}
    
    private ViewPager2 c(RecyclerView param1RecyclerView) {
      ViewParent viewParent = param1RecyclerView.getParent();
      if (viewParent instanceof ViewPager2)
        return (ViewPager2)viewParent; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Expected ViewPager2 instance. Got: ");
      stringBuilder.append(viewParent);
      throw new IllegalStateException(stringBuilder.toString());
    }
    
    void a(RecyclerView param1RecyclerView) {
      this.e = c(param1RecyclerView);
      this.b = new ViewPager2.OnPageChangeCallback(this) {
          public void onPageScrollStateChanged(int param2Int) {
            this.a.a(false);
          }
          
          public void onPageSelected(int param2Int) {
            this.a.a(false);
          }
        };
      this.e.registerOnPageChangeCallback(this.b);
      this.c = new FragmentStateAdapter.DataSetChangeObserver(this) {
          public void onChanged() {
            this.a.a(true);
          }
        };
      this.a.registerAdapterDataObserver(this.c);
      this.d = new LifecycleEventObserver(this) {
          public void onStateChanged(LifecycleOwner param2LifecycleOwner, Lifecycle.Event param2Event) {
            this.a.a(false);
          }
        };
      this.a.a.addObserver((LifecycleObserver)this.d);
    }
    
    void a(boolean param1Boolean) {
      if (this.a.b())
        return; 
      if (this.e.getScrollState() != 0)
        return; 
      if (!this.a.c.isEmpty()) {
        if (this.a.getItemCount() == 0)
          return; 
        int i = this.e.getCurrentItem();
        if (i >= this.a.getItemCount())
          return; 
        long l = this.a.getItemId(i);
        if (l == this.f && !param1Boolean)
          return; 
        Fragment fragment = (Fragment)this.a.c.get(l);
        if (fragment != null) {
          if (!fragment.isAdded())
            return; 
          this.f = l;
          FragmentTransaction fragmentTransaction = this.a.b.beginTransaction();
          fragment = null;
          for (i = 0; i < this.a.c.size(); i++) {
            l = this.a.c.keyAt(i);
            Fragment fragment1 = (Fragment)this.a.c.valueAt(i);
            if (fragment1.isAdded()) {
              if (l != this.f) {
                fragmentTransaction.setMaxLifecycle(fragment1, Lifecycle.State.STARTED);
              } else {
                fragment = fragment1;
              } 
              if (l == this.f) {
                param1Boolean = true;
              } else {
                param1Boolean = false;
              } 
              fragment1.setMenuVisibility(param1Boolean);
            } 
          } 
          if (fragment != null)
            fragmentTransaction.setMaxLifecycle(fragment, Lifecycle.State.RESUMED); 
          if (!fragmentTransaction.isEmpty())
            fragmentTransaction.commitNow(); 
        } 
      } 
    }
    
    void b(RecyclerView param1RecyclerView) {
      c(param1RecyclerView).unregisterOnPageChangeCallback(this.b);
      this.a.unregisterAdapterDataObserver(this.c);
      this.a.a.removeObserver((LifecycleObserver)this.d);
      this.e = null;
    }
  }
  
  class null extends ViewPager2.OnPageChangeCallback {
    null(FragmentStateAdapter this$0) {}
    
    public void onPageScrollStateChanged(int param1Int) {
      this.a.a(false);
    }
    
    public void onPageSelected(int param1Int) {
      this.a.a(false);
    }
  }
  
  class null extends DataSetChangeObserver {
    null(FragmentStateAdapter this$0) {}
    
    public void onChanged() {
      this.a.a(true);
    }
  }
  
  class null implements LifecycleEventObserver {
    null(FragmentStateAdapter this$0) {}
    
    public void onStateChanged(LifecycleOwner param1LifecycleOwner, Lifecycle.Event param1Event) {
      this.a.a(false);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\viewpager2\adapter\FragmentStateAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */