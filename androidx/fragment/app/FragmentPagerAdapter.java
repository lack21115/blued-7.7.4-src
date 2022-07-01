package androidx.fragment.app;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.PagerAdapter;

public abstract class FragmentPagerAdapter extends PagerAdapter {
  public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;
  
  @Deprecated
  public static final int BEHAVIOR_SET_USER_VISIBLE_HINT = 0;
  
  private final FragmentManager a;
  
  private final int b;
  
  private FragmentTransaction c = null;
  
  private Fragment d = null;
  
  @Deprecated
  public FragmentPagerAdapter(FragmentManager paramFragmentManager) {
    this(paramFragmentManager, 0);
  }
  
  public FragmentPagerAdapter(FragmentManager paramFragmentManager, int paramInt) {
    this.a = paramFragmentManager;
    this.b = paramInt;
  }
  
  private static String a(int paramInt, long paramLong) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("android:switcher:");
    stringBuilder.append(paramInt);
    stringBuilder.append(":");
    stringBuilder.append(paramLong);
    return stringBuilder.toString();
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject) {
    Fragment fragment = (Fragment)paramObject;
    if (this.c == null)
      this.c = this.a.beginTransaction(); 
    this.c.detach(fragment);
    if (fragment == this.d)
      this.d = null; 
  }
  
  public void finishUpdate(ViewGroup paramViewGroup) {
    FragmentTransaction fragmentTransaction = this.c;
    if (fragmentTransaction != null) {
      fragmentTransaction.commitNowAllowingStateLoss();
      this.c = null;
    } 
  }
  
  public abstract Fragment getItem(int paramInt);
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt) {
    Fragment fragment1;
    if (this.c == null)
      this.c = this.a.beginTransaction(); 
    long l = getItemId(paramInt);
    String str = a(paramViewGroup.getId(), l);
    Fragment fragment2 = this.a.findFragmentByTag(str);
    if (fragment2 != null) {
      this.c.attach(fragment2);
      fragment1 = fragment2;
    } else {
      fragment2 = getItem(paramInt);
      this.c.add(fragment1.getId(), fragment2, a(fragment1.getId(), l));
      fragment1 = fragment2;
    } 
    if (fragment1 != this.d) {
      fragment1.setMenuVisibility(false);
      if (this.b == 1) {
        this.c.setMaxLifecycle(fragment1, Lifecycle.State.STARTED);
        return fragment1;
      } 
      fragment1.setUserVisibleHint(false);
    } 
    return fragment1;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject) {
    return (((Fragment)paramObject).getView() == paramView);
  }
  
  public void restoreState(Parcelable paramParcelable, ClassLoader paramClassLoader) {}
  
  public Parcelable saveState() {
    return null;
  }
  
  public void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject) {
    Fragment fragment = (Fragment)paramObject;
    paramObject = this.d;
    if (fragment != paramObject) {
      if (paramObject != null) {
        paramObject.setMenuVisibility(false);
        if (this.b == 1) {
          if (this.c == null)
            this.c = this.a.beginTransaction(); 
          this.c.setMaxLifecycle(this.d, Lifecycle.State.STARTED);
        } else {
          this.d.setUserVisibleHint(false);
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
      this.d = fragment;
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\fragment\app\FragmentPagerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */