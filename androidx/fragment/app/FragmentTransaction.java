package androidx.fragment.app;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Lifecycle;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public abstract class FragmentTransaction {
  public static final int TRANSIT_ENTER_MASK = 4096;
  
  public static final int TRANSIT_EXIT_MASK = 8192;
  
  public static final int TRANSIT_FRAGMENT_CLOSE = 8194;
  
  public static final int TRANSIT_FRAGMENT_FADE = 4099;
  
  public static final int TRANSIT_FRAGMENT_OPEN = 4097;
  
  public static final int TRANSIT_NONE = 0;
  
  public static final int TRANSIT_UNSET = -1;
  
  ArrayList<Op> d = new ArrayList<Op>();
  
  int e;
  
  int f;
  
  int g;
  
  int h;
  
  int i;
  
  int j;
  
  boolean k;
  
  boolean l = true;
  
  String m;
  
  int n;
  
  CharSequence o;
  
  int p;
  
  CharSequence q;
  
  ArrayList<String> r;
  
  ArrayList<String> s;
  
  boolean t = false;
  
  ArrayList<Runnable> u;
  
  void a(int paramInt1, Fragment paramFragment, String paramString, int paramInt2) {
    StringBuilder stringBuilder2;
    Class<?> clazz = paramFragment.getClass();
    int i = clazz.getModifiers();
    if (!clazz.isAnonymousClass() && Modifier.isPublic(i) && (!clazz.isMemberClass() || Modifier.isStatic(i))) {
      if (paramString != null)
        if (paramFragment.mTag == null || paramString.equals(paramFragment.mTag)) {
          paramFragment.mTag = paramString;
        } else {
          stringBuilder2 = new StringBuilder();
          stringBuilder2.append("Can't change tag of fragment ");
          stringBuilder2.append(paramFragment);
          stringBuilder2.append(": was ");
          stringBuilder2.append(paramFragment.mTag);
          stringBuilder2.append(" now ");
          stringBuilder2.append(paramString);
          throw new IllegalStateException(stringBuilder2.toString());
        }  
      if (paramInt1 != 0) {
        StringBuilder stringBuilder;
        if (paramInt1 != -1) {
          if (paramFragment.mFragmentId == 0 || paramFragment.mFragmentId == paramInt1) {
            paramFragment.mFragmentId = paramInt1;
            paramFragment.mContainerId = paramInt1;
          } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Can't change container ID of fragment ");
            stringBuilder.append(paramFragment);
            stringBuilder.append(": was ");
            stringBuilder.append(paramFragment.mFragmentId);
            stringBuilder.append(" now ");
            stringBuilder.append(paramInt1);
            throw new IllegalStateException(stringBuilder.toString());
          } 
        } else {
          stringBuilder2 = new StringBuilder();
          stringBuilder2.append("Can't add fragment ");
          stringBuilder2.append(paramFragment);
          stringBuilder2.append(" with tag ");
          stringBuilder2.append((String)stringBuilder);
          stringBuilder2.append(" to container view with no id");
          throw new IllegalArgumentException(stringBuilder2.toString());
        } 
      } 
      a(new Op(paramInt2, paramFragment));
      return;
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("Fragment ");
    stringBuilder1.append(stringBuilder2.getCanonicalName());
    stringBuilder1.append(" must be a public static class to be  properly recreated from instance state.");
    throw new IllegalStateException(stringBuilder1.toString());
  }
  
  void a(Op paramOp) {
    this.d.add(paramOp);
    paramOp.c = this.e;
    paramOp.d = this.f;
    paramOp.e = this.g;
    paramOp.f = this.h;
  }
  
  public FragmentTransaction add(int paramInt, Fragment paramFragment) {
    a(paramInt, paramFragment, null, 1);
    return this;
  }
  
  public FragmentTransaction add(int paramInt, Fragment paramFragment, String paramString) {
    a(paramInt, paramFragment, paramString, 1);
    return this;
  }
  
  public FragmentTransaction add(Fragment paramFragment, String paramString) {
    a(0, paramFragment, paramString, 1);
    return this;
  }
  
  public FragmentTransaction addSharedElement(View paramView, String paramString) {
    if (FragmentTransition.a()) {
      String str = ViewCompat.getTransitionName(paramView);
      if (str != null) {
        StringBuilder stringBuilder1;
        StringBuilder stringBuilder2;
        if (this.r == null) {
          this.r = new ArrayList<String>();
          this.s = new ArrayList<String>();
        } else {
          if (!this.s.contains(paramString)) {
            if (this.r.contains(str)) {
              stringBuilder2 = new StringBuilder();
              stringBuilder2.append("A shared element with the source name '");
              stringBuilder2.append(str);
              stringBuilder2.append("' has already been added to the transaction.");
              throw new IllegalArgumentException(stringBuilder2.toString());
            } 
            this.r.add(str);
            this.s.add(stringBuilder2);
            return this;
          } 
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append("A shared element with the target name '");
          stringBuilder1.append((String)stringBuilder2);
          stringBuilder1.append("' has already been added to the transaction.");
          throw new IllegalArgumentException(stringBuilder1.toString());
        } 
        this.r.add(stringBuilder1);
        this.s.add(stringBuilder2);
        return this;
      } 
      throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
    } 
    return this;
  }
  
  public FragmentTransaction addToBackStack(String paramString) {
    if (this.l) {
      this.k = true;
      this.m = paramString;
      return this;
    } 
    throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
  }
  
  public FragmentTransaction attach(Fragment paramFragment) {
    a(new Op(7, paramFragment));
    return this;
  }
  
  public abstract int commit();
  
  public abstract int commitAllowingStateLoss();
  
  public abstract void commitNow();
  
  public abstract void commitNowAllowingStateLoss();
  
  public FragmentTransaction detach(Fragment paramFragment) {
    a(new Op(6, paramFragment));
    return this;
  }
  
  public FragmentTransaction disallowAddToBackStack() {
    if (!this.k) {
      this.l = false;
      return this;
    } 
    throw new IllegalStateException("This transaction is already being added to the back stack");
  }
  
  public FragmentTransaction hide(Fragment paramFragment) {
    a(new Op(4, paramFragment));
    return this;
  }
  
  public boolean isAddToBackStackAllowed() {
    return this.l;
  }
  
  public boolean isEmpty() {
    return this.d.isEmpty();
  }
  
  public FragmentTransaction remove(Fragment paramFragment) {
    a(new Op(3, paramFragment));
    return this;
  }
  
  public FragmentTransaction replace(int paramInt, Fragment paramFragment) {
    return replace(paramInt, paramFragment, null);
  }
  
  public FragmentTransaction replace(int paramInt, Fragment paramFragment, String paramString) {
    if (paramInt != 0) {
      a(paramInt, paramFragment, paramString, 2);
      return this;
    } 
    throw new IllegalArgumentException("Must use non-zero containerViewId");
  }
  
  public FragmentTransaction runOnCommit(Runnable paramRunnable) {
    disallowAddToBackStack();
    if (this.u == null)
      this.u = new ArrayList<Runnable>(); 
    this.u.add(paramRunnable);
    return this;
  }
  
  @Deprecated
  public FragmentTransaction setAllowOptimization(boolean paramBoolean) {
    return setReorderingAllowed(paramBoolean);
  }
  
  public FragmentTransaction setBreadCrumbShortTitle(int paramInt) {
    this.p = paramInt;
    this.q = null;
    return this;
  }
  
  public FragmentTransaction setBreadCrumbShortTitle(CharSequence paramCharSequence) {
    this.p = 0;
    this.q = paramCharSequence;
    return this;
  }
  
  public FragmentTransaction setBreadCrumbTitle(int paramInt) {
    this.n = paramInt;
    this.o = null;
    return this;
  }
  
  public FragmentTransaction setBreadCrumbTitle(CharSequence paramCharSequence) {
    this.n = 0;
    this.o = paramCharSequence;
    return this;
  }
  
  public FragmentTransaction setCustomAnimations(int paramInt1, int paramInt2) {
    return setCustomAnimations(paramInt1, paramInt2, 0, 0);
  }
  
  public FragmentTransaction setCustomAnimations(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.e = paramInt1;
    this.f = paramInt2;
    this.g = paramInt3;
    this.h = paramInt4;
    return this;
  }
  
  public FragmentTransaction setMaxLifecycle(Fragment paramFragment, Lifecycle.State paramState) {
    a(new Op(10, paramFragment, paramState));
    return this;
  }
  
  public FragmentTransaction setPrimaryNavigationFragment(Fragment paramFragment) {
    a(new Op(8, paramFragment));
    return this;
  }
  
  public FragmentTransaction setReorderingAllowed(boolean paramBoolean) {
    this.t = paramBoolean;
    return this;
  }
  
  public FragmentTransaction setTransition(int paramInt) {
    this.i = paramInt;
    return this;
  }
  
  public FragmentTransaction setTransitionStyle(int paramInt) {
    this.j = paramInt;
    return this;
  }
  
  public FragmentTransaction show(Fragment paramFragment) {
    a(new Op(5, paramFragment));
    return this;
  }
  
  static final class Op {
    int a;
    
    Fragment b;
    
    int c;
    
    int d;
    
    int e;
    
    int f;
    
    Lifecycle.State g;
    
    Lifecycle.State h;
    
    Op() {}
    
    Op(int param1Int, Fragment param1Fragment) {
      this.a = param1Int;
      this.b = param1Fragment;
      this.g = Lifecycle.State.RESUMED;
      this.h = Lifecycle.State.RESUMED;
    }
    
    Op(int param1Int, Fragment param1Fragment, Lifecycle.State param1State) {
      this.a = param1Int;
      this.b = param1Fragment;
      this.g = param1Fragment.mMaxState;
      this.h = param1State;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\fragment\app\FragmentTransaction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */