package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;

public abstract class FragmentStatePagerAdapter extends PagerAdapter {
  public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;
  
  @Deprecated
  public static final int BEHAVIOR_SET_USER_VISIBLE_HINT = 0;
  
  private final FragmentManager a;
  
  private final int b;
  
  private FragmentTransaction c = null;
  
  private ArrayList<Fragment.SavedState> d = new ArrayList<Fragment.SavedState>();
  
  private ArrayList<Fragment> e = new ArrayList<Fragment>();
  
  private Fragment f = null;
  
  @Deprecated
  public FragmentStatePagerAdapter(FragmentManager paramFragmentManager) {
    this(paramFragmentManager, 0);
  }
  
  public FragmentStatePagerAdapter(FragmentManager paramFragmentManager, int paramInt) {
    this.a = paramFragmentManager;
    this.b = paramInt;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject) {
    paramObject = paramObject;
    if (this.c == null)
      this.c = this.a.beginTransaction(); 
    while (this.d.size() <= paramInt)
      this.d.add(null); 
    ArrayList<Fragment.SavedState> arrayList = this.d;
    if (paramObject.isAdded()) {
      Fragment.SavedState savedState = this.a.saveFragmentInstanceState((Fragment)paramObject);
    } else {
      paramViewGroup = null;
    } 
    arrayList.set(paramInt, paramViewGroup);
    this.e.set(paramInt, null);
    this.c.remove((Fragment)paramObject);
    if (paramObject == this.f)
      this.f = null; 
  }
  
  public void finishUpdate(ViewGroup paramViewGroup) {
    FragmentTransaction fragmentTransaction = this.c;
    if (fragmentTransaction != null) {
      fragmentTransaction.commitNowAllowingStateLoss();
      this.c = null;
    } 
  }
  
  public abstract Fragment getItem(int paramInt);
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt) {
    if (this.e.size() > paramInt) {
      Fragment fragment1 = this.e.get(paramInt);
      if (fragment1 != null)
        return fragment1; 
    } 
    if (this.c == null)
      this.c = this.a.beginTransaction(); 
    Fragment fragment = getItem(paramInt);
    if (this.d.size() > paramInt) {
      Fragment.SavedState savedState = this.d.get(paramInt);
      if (savedState != null)
        fragment.setInitialSavedState(savedState); 
    } 
    while (this.e.size() <= paramInt)
      this.e.add(null); 
    fragment.setMenuVisibility(false);
    if (this.b == 0)
      fragment.setUserVisibleHint(false); 
    this.e.set(paramInt, fragment);
    this.c.add(paramViewGroup.getId(), fragment);
    if (this.b == 1)
      this.c.setMaxLifecycle(fragment, Lifecycle.State.STARTED); 
    return fragment;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject) {
    return (((Fragment)paramObject).getView() == paramView);
  }
  
  public void restoreState(Parcelable paramParcelable, ClassLoader paramClassLoader) {
    if (paramParcelable != null) {
      Bundle bundle = (Bundle)paramParcelable;
      bundle.setClassLoader(paramClassLoader);
      Parcelable[] arrayOfParcelable = bundle.getParcelableArray("states");
      this.d.clear();
      this.e.clear();
      if (arrayOfParcelable != null)
        for (int i = 0; i < arrayOfParcelable.length; i++)
          this.d.add((Fragment.SavedState)arrayOfParcelable[i]);  
      for (String str : bundle.keySet()) {
        if (str.startsWith("f")) {
          int i = Integer.parseInt(str.substring(1));
          Fragment fragment = this.a.getFragment(bundle, str);
          if (fragment != null) {
            while (this.e.size() <= i)
              this.e.add(null); 
            fragment.setMenuVisibility(false);
            this.e.set(i, fragment);
            continue;
          } 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Bad fragment at key ");
          stringBuilder.append(str);
          Log.w("FragmentStatePagerAdapt", stringBuilder.toString());
        } 
      } 
    } 
  }
  
  public Parcelable saveState() {
    Bundle bundle;
    if (this.d.size() > 0) {
      bundle = new Bundle();
      Fragment.SavedState[] arrayOfSavedState = new Fragment.SavedState[this.d.size()];
      this.d.toArray(arrayOfSavedState);
      bundle.putParcelableArray("states", (Parcelable[])arrayOfSavedState);
    } else {
      bundle = null;
    } 
    int i = 0;
    while (i < this.e.size()) {
      Fragment fragment = this.e.get(i);
      Bundle bundle1 = bundle;
      if (fragment != null) {
        bundle1 = bundle;
        if (fragment.isAdded()) {
          bundle1 = bundle;
          if (bundle == null)
            bundle1 = new Bundle(); 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("f");
          stringBuilder.append(i);
          String str = stringBuilder.toString();
          this.a.putFragment(bundle1, str, fragment);
        } 
      } 
      i++;
      bundle = bundle1;
    } 
    return (Parcelable)bundle;
  }
  
  public void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject) {
    Fragment fragment = (Fragment)paramObject;
    paramObject = this.f;
    if (fragment != paramObject) {
      if (paramObject != null) {
        paramObject.setMenuVisibility(false);
        if (this.b == 1) {
          if (this.c == null)
            this.c = this.a.beginTransaction(); 
          this.c.setMaxLifecycle(this.f, Lifecycle.State.STARTED);
        } else {
          this.f.setUserVisibleHint(false);
        } 
      } 
      fragment.setMenuVisibility(true);
      if (this.b == 1) {
        if (this.c == null)
          this.c = this.a.beginTransaction(); 
        this.c.setMaxLifecycle(fragment, Lifecycle.State.RESUMED);
      } else {
        fragment.setUserVisibleHint(true);
      } 
      this.f = fragment;
    } 
  }
  
  public void startUpdate(ViewGroup paramViewGroup) {
    if (paramViewGroup.getId() != -1)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("ViewPager with adapter ");
    stringBuilder.append(this);
    stringBuilder.append(" requires a view id");
    throw new IllegalStateException(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\fragment\app\FragmentStatePagerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */