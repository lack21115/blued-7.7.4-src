package androidx.fragment.app;

import android.util.Log;
import androidx.core.util.LogWriter;
import androidx.lifecycle.Lifecycle;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;

final class BackStackRecord extends FragmentTransaction implements FragmentManager.BackStackEntry, FragmentManagerImpl.OpGenerator {
  final FragmentManagerImpl a;
  
  boolean b;
  
  int c = -1;
  
  public BackStackRecord(FragmentManagerImpl paramFragmentManagerImpl) {
    this.a = paramFragmentManagerImpl;
  }
  
  private static boolean b(FragmentTransaction.Op paramOp) {
    Fragment fragment = paramOp.b;
    return (fragment != null && fragment.mAdded && fragment.mView != null && !fragment.mDetached && !fragment.mHidden && fragment.isPostponed());
  }
  
  int a(boolean paramBoolean) {
    if (!this.b) {
      if (FragmentManagerImpl.b) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Commit: ");
        stringBuilder.append(this);
        Log.v("FragmentManager", stringBuilder.toString());
        PrintWriter printWriter = new PrintWriter((Writer)new LogWriter("FragmentManager"));
        dump("  ", printWriter);
        printWriter.close();
      } 
      this.b = true;
      if (this.k) {
        this.c = this.a.allocBackStackIndex(this);
      } else {
        this.c = -1;
      } 
      this.a.enqueueAction(this, paramBoolean);
      return this.c;
    } 
    throw new IllegalStateException("commit already called");
  }
  
  Fragment a(ArrayList<Fragment> paramArrayList, Fragment paramFragment) {
    int i = 0;
    Fragment fragment;
    for (fragment = paramFragment; i < this.d.size(); fragment = paramFragment) {
      FragmentTransaction.Op op = this.d.get(i);
      int j = op.a;
      if (j != 1)
        if (j != 2) {
          if (j != 3 && j != 6) {
            if (j != 7) {
              if (j != 8) {
                j = i;
                paramFragment = fragment;
              } else {
                this.d.add(i, new FragmentTransaction.Op(9, fragment));
                j = i + 1;
                paramFragment = op.b;
              } 
              continue;
            } 
          } else {
            paramArrayList.remove(op.b);
            j = i;
            paramFragment = fragment;
            if (op.b == fragment) {
              this.d.add(i, new FragmentTransaction.Op(9, op.b));
              j = i + 1;
              paramFragment = null;
            } 
            continue;
          } 
        } else {
          Fragment fragment1 = op.b;
          int m = fragment1.mContainerId;
          j = paramArrayList.size() - 1;
          paramFragment = fragment;
          int k = 0;
          while (j >= 0) {
            Fragment fragment2 = paramArrayList.get(j);
            int n = k;
            int i1 = i;
            fragment = paramFragment;
            if (fragment2.mContainerId == m)
              if (fragment2 == fragment1) {
                n = 1;
                i1 = i;
                fragment = paramFragment;
              } else {
                n = i;
                fragment = paramFragment;
                if (fragment2 == paramFragment) {
                  this.d.add(i, new FragmentTransaction.Op(9, fragment2));
                  n = i + 1;
                  fragment = null;
                } 
                FragmentTransaction.Op op1 = new FragmentTransaction.Op(3, fragment2);
                op1.c = op.c;
                op1.e = op.e;
                op1.d = op.d;
                op1.f = op.f;
                this.d.add(n, op1);
                paramArrayList.remove(fragment2);
                i1 = n + 1;
                n = k;
              }  
            j--;
            k = n;
            i = i1;
            paramFragment = fragment;
          } 
          if (k != 0) {
            this.d.remove(i);
            i--;
          } else {
            op.a = 1;
            paramArrayList.add(fragment1);
          } 
          j = i;
          continue;
        }  
      paramArrayList.add(op.b);
      paramFragment = fragment;
      j = i;
      continue;
      i = SYNTHETIC_LOCAL_VARIABLE_4 + 1;
    } 
    return fragment;
  }
  
  void a() {
    int j = this.d.size();
    for (int i = 0; i < j; i++) {
      StringBuilder stringBuilder;
      FragmentTransaction.Op op = this.d.get(i);
      Fragment fragment = op.b;
      if (fragment != null)
        fragment.setNextTransition(this.i, this.j); 
      switch (op.a) {
        default:
          stringBuilder = new StringBuilder();
          stringBuilder.append("Unknown cmd: ");
          stringBuilder.append(op.a);
          throw new IllegalArgumentException(stringBuilder.toString());
        case 10:
          this.a.setMaxLifecycle((Fragment)stringBuilder, op.h);
          break;
        case 9:
          this.a.setPrimaryNavigationFragment(null);
          break;
        case 8:
          this.a.setPrimaryNavigationFragment((Fragment)stringBuilder);
          break;
        case 7:
          stringBuilder.setNextAnim(op.c);
          this.a.attachFragment((Fragment)stringBuilder);
          break;
        case 6:
          stringBuilder.setNextAnim(op.d);
          this.a.detachFragment((Fragment)stringBuilder);
          break;
        case 5:
          stringBuilder.setNextAnim(op.c);
          this.a.showFragment((Fragment)stringBuilder);
          break;
        case 4:
          stringBuilder.setNextAnim(op.d);
          this.a.hideFragment((Fragment)stringBuilder);
          break;
        case 3:
          stringBuilder.setNextAnim(op.d);
          this.a.removeFragment((Fragment)stringBuilder);
          break;
        case 1:
          stringBuilder.setNextAnim(op.c);
          this.a.addFragment((Fragment)stringBuilder, false);
          break;
      } 
      if (!this.t && op.a != 1 && stringBuilder != null)
        this.a.i((Fragment)stringBuilder); 
    } 
    if (!this.t) {
      FragmentManagerImpl fragmentManagerImpl = this.a;
      fragmentManagerImpl.a(fragmentManagerImpl.m, true);
    } 
  }
  
  void a(int paramInt) {
    if (!this.k)
      return; 
    if (FragmentManagerImpl.b) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Bump nesting in ");
      stringBuilder.append(this);
      stringBuilder.append(" by ");
      stringBuilder.append(paramInt);
      Log.v("FragmentManager", stringBuilder.toString());
    } 
    int j = this.d.size();
    for (int i = 0; i < j; i++) {
      FragmentTransaction.Op op = this.d.get(i);
      if (op.b != null) {
        Fragment fragment = op.b;
        fragment.mBackStackNesting += paramInt;
        if (FragmentManagerImpl.b) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Bump nesting of ");
          stringBuilder.append(op.b);
          stringBuilder.append(" to ");
          stringBuilder.append(op.b.mBackStackNesting);
          Log.v("FragmentManager", stringBuilder.toString());
        } 
      } 
    } 
  }
  
  void a(int paramInt1, Fragment paramFragment, String paramString, int paramInt2) {
    super.a(paramInt1, paramFragment, paramString, paramInt2);
    paramFragment.mFragmentManager = this.a;
  }
  
  void a(Fragment.OnStartEnterTransitionListener paramOnStartEnterTransitionListener) {
    for (int i = 0; i < this.d.size(); i++) {
      FragmentTransaction.Op op = this.d.get(i);
      if (b(op))
        op.b.setOnStartEnterTransitionListener(paramOnStartEnterTransitionListener); 
    } 
  }
  
  boolean a(ArrayList<BackStackRecord> paramArrayList, int paramInt1, int paramInt2) {
    if (paramInt2 == paramInt1)
      return false; 
    int k = this.d.size();
    int i = 0;
    int j;
    for (j = -1; i < k; j = n) {
      int m;
      FragmentTransaction.Op op = this.d.get(i);
      if (op.b != null) {
        m = op.b.mContainerId;
      } else {
        m = 0;
      } 
      int n = j;
      if (m) {
        n = j;
        if (m != j) {
          for (j = paramInt1; j < paramInt2; j++) {
            BackStackRecord backStackRecord = paramArrayList.get(j);
            int i1 = backStackRecord.d.size();
            for (n = 0; n < i1; n++) {
              int i2;
              FragmentTransaction.Op op1 = backStackRecord.d.get(n);
              if (op1.b != null) {
                i2 = op1.b.mContainerId;
              } else {
                i2 = 0;
              } 
              if (i2 == m)
                return true; 
            } 
          } 
          n = m;
        } 
      } 
      i++;
    } 
    return false;
  }
  
  Fragment b(ArrayList<Fragment> paramArrayList, Fragment paramFragment) {
    int i = this.d.size() - 1;
    while (i >= 0) {
      FragmentTransaction.Op op = this.d.get(i);
      int j = op.a;
      if (j != 1)
        if (j != 3) {
          switch (j) {
            case 10:
              op.h = op.g;
              break;
            case 9:
              paramFragment = op.b;
              break;
            case 8:
              paramFragment = null;
              break;
            case 6:
              paramArrayList.add(op.b);
              break;
            case 7:
              paramArrayList.remove(op.b);
              break;
          } 
          i--;
        }  
    } 
    return paramFragment;
  }
  
  void b(boolean paramBoolean) {
    for (int i = this.d.size() - 1; i >= 0; i--) {
      StringBuilder stringBuilder;
      FragmentTransaction.Op op = this.d.get(i);
      Fragment fragment = op.b;
      if (fragment != null)
        fragment.setNextTransition(FragmentManagerImpl.reverseTransit(this.i), this.j); 
      switch (op.a) {
        default:
          stringBuilder = new StringBuilder();
          stringBuilder.append("Unknown cmd: ");
          stringBuilder.append(op.a);
          throw new IllegalArgumentException(stringBuilder.toString());
        case 10:
          this.a.setMaxLifecycle((Fragment)stringBuilder, op.g);
          break;
        case 9:
          this.a.setPrimaryNavigationFragment((Fragment)stringBuilder);
          break;
        case 8:
          this.a.setPrimaryNavigationFragment(null);
          break;
        case 7:
          stringBuilder.setNextAnim(op.f);
          this.a.detachFragment((Fragment)stringBuilder);
          break;
        case 6:
          stringBuilder.setNextAnim(op.e);
          this.a.attachFragment((Fragment)stringBuilder);
          break;
        case 5:
          stringBuilder.setNextAnim(op.f);
          this.a.hideFragment((Fragment)stringBuilder);
          break;
        case 4:
          stringBuilder.setNextAnim(op.e);
          this.a.showFragment((Fragment)stringBuilder);
          break;
        case 3:
          stringBuilder.setNextAnim(op.e);
          this.a.addFragment((Fragment)stringBuilder, false);
          break;
        case 1:
          stringBuilder.setNextAnim(op.f);
          this.a.removeFragment((Fragment)stringBuilder);
          break;
      } 
      if (!this.t && op.a != 3 && stringBuilder != null)
        this.a.i((Fragment)stringBuilder); 
    } 
    if (!this.t && paramBoolean) {
      FragmentManagerImpl fragmentManagerImpl = this.a;
      fragmentManagerImpl.a(fragmentManagerImpl.m, true);
    } 
  }
  
  boolean b() {
    for (int i = 0; i < this.d.size(); i++) {
      if (b(this.d.get(i)))
        return true; 
    } 
    return false;
  }
  
  boolean b(int paramInt) {
    int j = this.d.size();
    for (int i = 0; i < j; i++) {
      int k;
      FragmentTransaction.Op op = this.d.get(i);
      if (op.b != null) {
        k = op.b.mContainerId;
      } else {
        k = 0;
      } 
      if (k && k == paramInt)
        return true; 
    } 
    return false;
  }
  
  public int commit() {
    return a(false);
  }
  
  public int commitAllowingStateLoss() {
    return a(true);
  }
  
  public void commitNow() {
    disallowAddToBackStack();
    this.a.execSingleAction(this, false);
  }
  
  public void commitNowAllowingStateLoss() {
    disallowAddToBackStack();
    this.a.execSingleAction(this, true);
  }
  
  public FragmentTransaction detach(Fragment paramFragment) {
    if (paramFragment.mFragmentManager == null || paramFragment.mFragmentManager == this.a)
      return super.detach(paramFragment); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Cannot detach Fragment attached to a different FragmentManager. Fragment ");
    stringBuilder.append(paramFragment.toString());
    stringBuilder.append(" is already attached to a FragmentManager.");
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public void dump(String paramString, PrintWriter paramPrintWriter) {
    dump(paramString, paramPrintWriter, true);
  }
  
  public void dump(String paramString, PrintWriter paramPrintWriter, boolean paramBoolean) {
    if (paramBoolean) {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mName=");
      paramPrintWriter.print(this.m);
      paramPrintWriter.print(" mIndex=");
      paramPrintWriter.print(this.c);
      paramPrintWriter.print(" mCommitted=");
      paramPrintWriter.println(this.b);
      if (this.i != 0) {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mTransition=#");
        paramPrintWriter.print(Integer.toHexString(this.i));
        paramPrintWriter.print(" mTransitionStyle=#");
        paramPrintWriter.println(Integer.toHexString(this.j));
      } 
      if (this.e != 0 || this.f != 0) {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(this.e));
        paramPrintWriter.print(" mExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(this.f));
      } 
      if (this.g != 0 || this.h != 0) {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mPopEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(this.g));
        paramPrintWriter.print(" mPopExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(this.h));
      } 
      if (this.n != 0 || this.o != null) {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(this.n));
        paramPrintWriter.print(" mBreadCrumbTitleText=");
        paramPrintWriter.println(this.o);
      } 
      if (this.p != 0 || this.q != null) {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbShortTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(this.p));
        paramPrintWriter.print(" mBreadCrumbShortTitleText=");
        paramPrintWriter.println(this.q);
      } 
    } 
    if (!this.d.isEmpty()) {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Operations:");
      int j = this.d.size();
      int i;
      for (i = 0; i < j; i++) {
        StringBuilder stringBuilder;
        String str;
        FragmentTransaction.Op op = this.d.get(i);
        switch (op.a) {
          default:
            stringBuilder = new StringBuilder();
            stringBuilder.append("cmd=");
            stringBuilder.append(op.a);
            str = stringBuilder.toString();
            break;
          case 10:
            str = "OP_SET_MAX_LIFECYCLE";
            break;
          case 9:
            str = "UNSET_PRIMARY_NAV";
            break;
          case 8:
            str = "SET_PRIMARY_NAV";
            break;
          case 7:
            str = "ATTACH";
            break;
          case 6:
            str = "DETACH";
            break;
          case 5:
            str = "SHOW";
            break;
          case 4:
            str = "HIDE";
            break;
          case 3:
            str = "REMOVE";
            break;
          case 2:
            str = "REPLACE";
            break;
          case 1:
            str = "ADD";
            break;
          case 0:
            str = "NULL";
            break;
        } 
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  Op #");
        paramPrintWriter.print(i);
        paramPrintWriter.print(": ");
        paramPrintWriter.print(str);
        paramPrintWriter.print(" ");
        paramPrintWriter.println(op.b);
        if (paramBoolean) {
          if (op.c != 0 || op.d != 0) {
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("enterAnim=#");
            paramPrintWriter.print(Integer.toHexString(op.c));
            paramPrintWriter.print(" exitAnim=#");
            paramPrintWriter.println(Integer.toHexString(op.d));
          } 
          if (op.e != 0 || op.f != 0) {
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("popEnterAnim=#");
            paramPrintWriter.print(Integer.toHexString(op.e));
            paramPrintWriter.print(" popExitAnim=#");
            paramPrintWriter.println(Integer.toHexString(op.f));
          } 
        } 
      } 
    } 
  }
  
  public boolean generateOps(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1) {
    if (FragmentManagerImpl.b) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Run: ");
      stringBuilder.append(this);
      Log.v("FragmentManager", stringBuilder.toString());
    } 
    paramArrayList.add(this);
    paramArrayList1.add(Boolean.valueOf(false));
    if (this.k)
      this.a.a(this); 
    return true;
  }
  
  public CharSequence getBreadCrumbShortTitle() {
    return (this.p != 0) ? this.a.n.b().getText(this.p) : this.q;
  }
  
  public int getBreadCrumbShortTitleRes() {
    return this.p;
  }
  
  public CharSequence getBreadCrumbTitle() {
    return (this.n != 0) ? this.a.n.b().getText(this.n) : this.o;
  }
  
  public int getBreadCrumbTitleRes() {
    return this.n;
  }
  
  public int getId() {
    return this.c;
  }
  
  public String getName() {
    return this.m;
  }
  
  public FragmentTransaction hide(Fragment paramFragment) {
    if (paramFragment.mFragmentManager == null || paramFragment.mFragmentManager == this.a)
      return super.hide(paramFragment); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Cannot hide Fragment attached to a different FragmentManager. Fragment ");
    stringBuilder.append(paramFragment.toString());
    stringBuilder.append(" is already attached to a FragmentManager.");
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public boolean isEmpty() {
    return this.d.isEmpty();
  }
  
  public FragmentTransaction remove(Fragment paramFragment) {
    if (paramFragment.mFragmentManager == null || paramFragment.mFragmentManager == this.a)
      return super.remove(paramFragment); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Cannot remove Fragment attached to a different FragmentManager. Fragment ");
    stringBuilder.append(paramFragment.toString());
    stringBuilder.append(" is already attached to a FragmentManager.");
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public void runOnCommitRunnables() {
    if (this.u != null) {
      for (int i = 0; i < this.u.size(); i++)
        ((Runnable)this.u.get(i)).run(); 
      this.u = null;
    } 
  }
  
  public FragmentTransaction setMaxLifecycle(Fragment paramFragment, Lifecycle.State paramState) {
    if (paramFragment.mFragmentManager == this.a) {
      if (paramState.isAtLeast(Lifecycle.State.CREATED))
        return super.setMaxLifecycle(paramFragment, paramState); 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Cannot set maximum Lifecycle below ");
      stringBuilder1.append(Lifecycle.State.CREATED);
      throw new IllegalArgumentException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Cannot setMaxLifecycle for Fragment not attached to FragmentManager ");
    stringBuilder.append(this.a);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public FragmentTransaction setPrimaryNavigationFragment(Fragment paramFragment) {
    if (paramFragment == null || paramFragment.mFragmentManager == null || paramFragment.mFragmentManager == this.a)
      return super.setPrimaryNavigationFragment(paramFragment); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment ");
    stringBuilder.append(paramFragment.toString());
    stringBuilder.append(" is already attached to a FragmentManager.");
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public FragmentTransaction show(Fragment paramFragment) {
    if (paramFragment.mFragmentManager == null || paramFragment.mFragmentManager == this.a)
      return super.show(paramFragment); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Cannot show Fragment attached to a different FragmentManager. Fragment ");
    stringBuilder.append(paramFragment.toString());
    stringBuilder.append(" is already attached to a FragmentManager.");
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);
    stringBuilder.append("BackStackEntry{");
    stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    if (this.c >= 0) {
      stringBuilder.append(" #");
      stringBuilder.append(this.c);
    } 
    if (this.m != null) {
      stringBuilder.append(" ");
      stringBuilder.append(this.m);
    } 
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\fragment\app\BackStackRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */