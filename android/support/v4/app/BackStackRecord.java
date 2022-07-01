package android.support.v4.app;

import android.support.v4.util.LogWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

final class BackStackRecord extends FragmentTransaction implements FragmentManagerImpl$OpGenerator {
  boolean mAddToBackStack;
  
  int mBreadCrumbShortTitleRes;
  
  CharSequence mBreadCrumbShortTitleText;
  
  int mBreadCrumbTitleRes;
  
  CharSequence mBreadCrumbTitleText;
  
  private ArrayList mCommitRunnables;
  
  private boolean mCommitted;
  
  int mEnterAnim;
  
  int mExitAnim;
  
  int mIndex = -1;
  
  final FragmentManagerImpl mManager;
  
  String mName;
  
  ArrayList mOps = new ArrayList();
  
  int mPopEnterAnim;
  
  int mPopExitAnim;
  
  boolean mReorderingAllowed = false;
  
  ArrayList mSharedElementSourceNames;
  
  ArrayList mSharedElementTargetNames;
  
  int mTransition;
  
  int mTransitionStyle;
  
  public BackStackRecord(FragmentManagerImpl paramFragmentManagerImpl) {
    this.mManager = paramFragmentManagerImpl;
  }
  
  private int commitInternal(boolean paramBoolean) {
    if (!this.mCommitted) {
      if (FragmentManagerImpl.DEBUG) {
        (new StringBuilder("Commit: ")).append(this);
        PrintWriter printWriter = new PrintWriter((Writer)new LogWriter());
        dump$ec96877("  ", printWriter);
        printWriter.close();
      } 
      this.mCommitted = true;
      if (this.mAddToBackStack) {
        this.mIndex = this.mManager.allocBackStackIndex(this);
      } else {
        this.mIndex = -1;
      } 
      this.mManager.enqueueAction(this, paramBoolean);
      return this.mIndex;
    } 
    throw new IllegalStateException("commit already called");
  }
  
  static boolean isFragmentPostponed(BackStackRecord$Op paramBackStackRecord$Op) {
    Fragment fragment = paramBackStackRecord$Op.fragment;
    return (fragment != null && fragment.mAdded && fragment.mView != null && !fragment.mDetached && !fragment.mHidden && fragment.isPostponed());
  }
  
  public final FragmentTransaction add(Fragment paramFragment, String paramString) {
    StringBuilder stringBuilder2;
    Class<?> clazz = paramFragment.getClass();
    int i = clazz.getModifiers();
    if (!clazz.isAnonymousClass() && Modifier.isPublic(i) && (!clazz.isMemberClass() || Modifier.isStatic(i))) {
      paramFragment.mFragmentManager = this.mManager;
      if (paramString != null) {
        if (paramFragment.mTag == null || paramString.equals(paramFragment.mTag)) {
          paramFragment.mTag = paramString;
          addOp(new BackStackRecord$Op(1, paramFragment));
          return this;
        } 
        stringBuilder2 = new StringBuilder("Can't change tag of fragment ");
        stringBuilder2.append(paramFragment);
        stringBuilder2.append(": was ");
        stringBuilder2.append(paramFragment.mTag);
        stringBuilder2.append(" now ");
        stringBuilder2.append(paramString);
        throw new IllegalStateException(stringBuilder2.toString());
      } 
      addOp(new BackStackRecord$Op(1, paramFragment));
      return this;
    } 
    StringBuilder stringBuilder1 = new StringBuilder("Fragment ");
    stringBuilder1.append(stringBuilder2.getCanonicalName());
    stringBuilder1.append(" must be a public static class to be  properly recreated from instance state.");
    throw new IllegalStateException(stringBuilder1.toString());
  }
  
  final void addOp(BackStackRecord$Op paramBackStackRecord$Op) {
    this.mOps.add(paramBackStackRecord$Op);
    paramBackStackRecord$Op.enterAnim = this.mEnterAnim;
    paramBackStackRecord$Op.exitAnim = this.mExitAnim;
    paramBackStackRecord$Op.popEnterAnim = this.mPopEnterAnim;
    paramBackStackRecord$Op.popExitAnim = this.mPopExitAnim;
  }
  
  final void bumpBackStackNesting(int paramInt) {
    if (!this.mAddToBackStack)
      return; 
    if (FragmentManagerImpl.DEBUG) {
      StringBuilder stringBuilder = new StringBuilder("Bump nesting in ");
      stringBuilder.append(this);
      stringBuilder.append(" by ");
      stringBuilder.append(paramInt);
    } 
    int j = this.mOps.size();
    for (int i = 0; i < j; i++) {
      BackStackRecord$Op backStackRecord$Op = this.mOps.get(i);
      if (backStackRecord$Op.fragment != null) {
        Fragment fragment = backStackRecord$Op.fragment;
        fragment.mBackStackNesting += paramInt;
        if (FragmentManagerImpl.DEBUG) {
          StringBuilder stringBuilder = new StringBuilder("Bump nesting of ");
          stringBuilder.append(backStackRecord$Op.fragment);
          stringBuilder.append(" to ");
          stringBuilder.append(backStackRecord$Op.fragment.mBackStackNesting);
        } 
      } 
    } 
  }
  
  public final int commit() {
    return commitInternal(false);
  }
  
  public final int commitAllowingStateLoss() {
    return commitInternal(true);
  }
  
  public final void dump(String paramString, PrintWriter paramPrintWriter, boolean paramBoolean) {
    if (paramBoolean) {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mName=");
      paramPrintWriter.print(this.mName);
      paramPrintWriter.print(" mIndex=");
      paramPrintWriter.print(this.mIndex);
      paramPrintWriter.print(" mCommitted=");
      paramPrintWriter.println(this.mCommitted);
      if (this.mTransition != 0) {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mTransition=#");
        paramPrintWriter.print(Integer.toHexString(this.mTransition));
        paramPrintWriter.print(" mTransitionStyle=#");
        paramPrintWriter.println(Integer.toHexString(this.mTransitionStyle));
      } 
      if (this.mEnterAnim != 0 || this.mExitAnim != 0) {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(this.mEnterAnim));
        paramPrintWriter.print(" mExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(this.mExitAnim));
      } 
      if (this.mPopEnterAnim != 0 || this.mPopExitAnim != 0) {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mPopEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(this.mPopEnterAnim));
        paramPrintWriter.print(" mPopExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(this.mPopExitAnim));
      } 
      if (this.mBreadCrumbTitleRes != 0 || this.mBreadCrumbTitleText != null) {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(this.mBreadCrumbTitleRes));
        paramPrintWriter.print(" mBreadCrumbTitleText=");
        paramPrintWriter.println(this.mBreadCrumbTitleText);
      } 
      if (this.mBreadCrumbShortTitleRes != 0 || this.mBreadCrumbShortTitleText != null) {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbShortTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(this.mBreadCrumbShortTitleRes));
        paramPrintWriter.print(" mBreadCrumbShortTitleText=");
        paramPrintWriter.println(this.mBreadCrumbShortTitleText);
      } 
    } 
    if (!this.mOps.isEmpty()) {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Operations:");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append("    ");
      int j = this.mOps.size();
      int i;
      for (i = 0; i < j; i++) {
        String str;
        BackStackRecord$Op backStackRecord$Op = this.mOps.get(i);
        switch (backStackRecord$Op.cmd) {
          default:
            stringBuilder = new StringBuilder("cmd=");
            stringBuilder.append(backStackRecord$Op.cmd);
            str = stringBuilder.toString();
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
        paramPrintWriter.println(backStackRecord$Op.fragment);
        if (paramBoolean) {
          if (backStackRecord$Op.enterAnim != 0 || backStackRecord$Op.exitAnim != 0) {
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("enterAnim=#");
            paramPrintWriter.print(Integer.toHexString(backStackRecord$Op.enterAnim));
            paramPrintWriter.print(" exitAnim=#");
            paramPrintWriter.println(Integer.toHexString(backStackRecord$Op.exitAnim));
          } 
          if (backStackRecord$Op.popEnterAnim != 0 || backStackRecord$Op.popExitAnim != 0) {
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("popEnterAnim=#");
            paramPrintWriter.print(Integer.toHexString(backStackRecord$Op.popEnterAnim));
            paramPrintWriter.print(" popExitAnim=#");
            paramPrintWriter.println(Integer.toHexString(backStackRecord$Op.popExitAnim));
          } 
        } 
      } 
    } 
  }
  
  public final void dump$ec96877(String paramString, PrintWriter paramPrintWriter) {
    dump(paramString, paramPrintWriter, true);
  }
  
  final void executeOps() {
    int j = this.mOps.size();
    for (int i = 0; i < j; i++) {
      StringBuilder stringBuilder;
      BackStackRecord$Op backStackRecord$Op = this.mOps.get(i);
      Fragment fragment = backStackRecord$Op.fragment;
      if (fragment != null)
        fragment.setNextTransition(this.mTransition, this.mTransitionStyle); 
      int k = backStackRecord$Op.cmd;
      if (k != 1) {
        switch (k) {
          default:
            stringBuilder = new StringBuilder("Unknown cmd: ");
            stringBuilder.append(backStackRecord$Op.cmd);
            throw new IllegalArgumentException(stringBuilder.toString());
          case 9:
            this.mManager.setPrimaryNavigationFragment(null);
            break;
          case 8:
            this.mManager.setPrimaryNavigationFragment((Fragment)stringBuilder);
            break;
          case 7:
            stringBuilder.setNextAnim(backStackRecord$Op.enterAnim);
            this.mManager.attachFragment((Fragment)stringBuilder);
            break;
          case 6:
            stringBuilder.setNextAnim(backStackRecord$Op.exitAnim);
            this.mManager.detachFragment((Fragment)stringBuilder);
            break;
          case 5:
            stringBuilder.setNextAnim(backStackRecord$Op.enterAnim);
            FragmentManagerImpl.showFragment((Fragment)stringBuilder);
            break;
          case 4:
            stringBuilder.setNextAnim(backStackRecord$Op.exitAnim);
            FragmentManagerImpl.hideFragment((Fragment)stringBuilder);
            break;
          case 3:
            stringBuilder.setNextAnim(backStackRecord$Op.exitAnim);
            this.mManager.removeFragment((Fragment)stringBuilder);
            break;
        } 
      } else {
        stringBuilder.setNextAnim(backStackRecord$Op.enterAnim);
        this.mManager.addFragment((Fragment)stringBuilder, false);
      } 
      if (!this.mReorderingAllowed && backStackRecord$Op.cmd != 1 && stringBuilder != null)
        this.mManager.moveFragmentToExpectedState((Fragment)stringBuilder); 
    } 
    if (!this.mReorderingAllowed)
      this.mManager.moveToState(this.mManager.mCurState, true); 
  }
  
  final void executePopOps(boolean paramBoolean) {
    for (int i = this.mOps.size() - 1; i >= 0; i--) {
      StringBuilder stringBuilder;
      BackStackRecord$Op backStackRecord$Op = this.mOps.get(i);
      Fragment fragment = backStackRecord$Op.fragment;
      if (fragment != null)
        fragment.setNextTransition(FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle); 
      int j = backStackRecord$Op.cmd;
      if (j != 1) {
        switch (j) {
          default:
            stringBuilder = new StringBuilder("Unknown cmd: ");
            stringBuilder.append(backStackRecord$Op.cmd);
            throw new IllegalArgumentException(stringBuilder.toString());
          case 9:
            this.mManager.setPrimaryNavigationFragment((Fragment)stringBuilder);
            break;
          case 8:
            this.mManager.setPrimaryNavigationFragment(null);
            break;
          case 7:
            stringBuilder.setNextAnim(backStackRecord$Op.popExitAnim);
            this.mManager.detachFragment((Fragment)stringBuilder);
            break;
          case 6:
            stringBuilder.setNextAnim(backStackRecord$Op.popEnterAnim);
            this.mManager.attachFragment((Fragment)stringBuilder);
            break;
          case 5:
            stringBuilder.setNextAnim(backStackRecord$Op.popExitAnim);
            FragmentManagerImpl.hideFragment((Fragment)stringBuilder);
            break;
          case 4:
            stringBuilder.setNextAnim(backStackRecord$Op.popEnterAnim);
            FragmentManagerImpl.showFragment((Fragment)stringBuilder);
            break;
          case 3:
            stringBuilder.setNextAnim(backStackRecord$Op.popEnterAnim);
            this.mManager.addFragment((Fragment)stringBuilder, false);
            break;
        } 
      } else {
        stringBuilder.setNextAnim(backStackRecord$Op.popExitAnim);
        this.mManager.removeFragment((Fragment)stringBuilder);
      } 
      if (!this.mReorderingAllowed && backStackRecord$Op.cmd != 3 && stringBuilder != null)
        this.mManager.moveFragmentToExpectedState((Fragment)stringBuilder); 
    } 
    if (!this.mReorderingAllowed && paramBoolean)
      this.mManager.moveToState(this.mManager.mCurState, true); 
  }
  
  final Fragment expandOps(ArrayList<Fragment> paramArrayList, Fragment paramFragment) {
    int i = 0;
    Fragment fragment;
    for (fragment = paramFragment; i < this.mOps.size(); fragment = paramFragment) {
      int j;
      boolean bool;
      int k;
      Fragment fragment1;
      BackStackRecord$Op backStackRecord$Op = this.mOps.get(i);
      switch (backStackRecord$Op.cmd) {
        default:
          paramFragment = fragment;
          j = i;
          break;
        case 8:
          this.mOps.add(i, new BackStackRecord$Op(9, fragment));
          j = i + 1;
          paramFragment = backStackRecord$Op.fragment;
          break;
        case 3:
        case 6:
          paramArrayList.remove(backStackRecord$Op.fragment);
          paramFragment = fragment;
          j = i;
          if (backStackRecord$Op.fragment == fragment) {
            this.mOps.add(i, new BackStackRecord$Op(9, backStackRecord$Op.fragment));
            j = i + 1;
            paramFragment = null;
          } 
          break;
        case 2:
          fragment1 = backStackRecord$Op.fragment;
          k = fragment1.mContainerId;
          j = paramArrayList.size() - 1;
          paramFragment = fragment;
          for (bool = false; j >= 0; bool = bool1) {
            Fragment fragment2 = paramArrayList.get(j);
            int m = i;
            fragment = paramFragment;
            boolean bool1 = bool;
            if (fragment2.mContainerId == k)
              if (fragment2 == fragment1) {
                bool1 = true;
                m = i;
                fragment = paramFragment;
              } else {
                m = i;
                fragment = paramFragment;
                if (fragment2 == paramFragment) {
                  this.mOps.add(i, new BackStackRecord$Op(9, fragment2));
                  m = i + 1;
                  fragment = null;
                } 
                BackStackRecord$Op backStackRecord$Op1 = new BackStackRecord$Op(3, fragment2);
                backStackRecord$Op1.enterAnim = backStackRecord$Op.enterAnim;
                backStackRecord$Op1.popEnterAnim = backStackRecord$Op.popEnterAnim;
                backStackRecord$Op1.exitAnim = backStackRecord$Op.exitAnim;
                backStackRecord$Op1.popExitAnim = backStackRecord$Op.popExitAnim;
                this.mOps.add(m, backStackRecord$Op1);
                paramArrayList.remove(fragment2);
                m++;
                bool1 = bool;
              }  
            j--;
            i = m;
            paramFragment = fragment;
          } 
          if (bool) {
            this.mOps.remove(i);
            j = i - 1;
            break;
          } 
          backStackRecord$Op.cmd = 1;
          paramArrayList.add(fragment1);
          j = i;
          break;
        case 1:
        case 7:
          paramArrayList.add(backStackRecord$Op.fragment);
          j = i;
          paramFragment = fragment;
          break;
      } 
      i = j + 1;
    } 
    return fragment;
  }
  
  public final boolean generateOps(ArrayList<BackStackRecord> paramArrayList1, ArrayList<Boolean> paramArrayList2) {
    if (FragmentManagerImpl.DEBUG)
      (new StringBuilder("Run: ")).append(this); 
    paramArrayList1.add(this);
    paramArrayList2.add(Boolean.valueOf(false));
    if (this.mAddToBackStack) {
      FragmentManagerImpl fragmentManagerImpl = this.mManager;
      if (fragmentManagerImpl.mBackStack == null)
        fragmentManagerImpl.mBackStack = new ArrayList(); 
      fragmentManagerImpl.mBackStack.add(this);
    } 
    return true;
  }
  
  final boolean interactsWith(int paramInt) {
    int j = this.mOps.size();
    for (int i = 0; i < j; i++) {
      int k;
      BackStackRecord$Op backStackRecord$Op = this.mOps.get(i);
      if (backStackRecord$Op.fragment != null) {
        k = backStackRecord$Op.fragment.mContainerId;
      } else {
        k = 0;
      } 
      if (k && k == paramInt)
        return true; 
    } 
    return false;
  }
  
  final boolean interactsWith(ArrayList<BackStackRecord> paramArrayList, int paramInt1, int paramInt2) {
    if (paramInt2 == paramInt1)
      return false; 
    int k = this.mOps.size();
    int i = 0;
    int j;
    for (j = -1; i < k; j = n) {
      int m;
      BackStackRecord$Op backStackRecord$Op = this.mOps.get(i);
      if (backStackRecord$Op.fragment != null) {
        m = backStackRecord$Op.fragment.mContainerId;
      } else {
        m = 0;
      } 
      int n = j;
      if (m) {
        n = j;
        if (m != j) {
          for (j = paramInt1; j < paramInt2; j++) {
            BackStackRecord backStackRecord = paramArrayList.get(j);
            int i1 = backStackRecord.mOps.size();
            for (n = 0; n < i1; n++) {
              int i2;
              BackStackRecord$Op backStackRecord$Op1 = backStackRecord.mOps.get(n);
              if (backStackRecord$Op1.fragment != null) {
                i2 = backStackRecord$Op1.fragment.mContainerId;
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
  
  public final FragmentTransaction remove(Fragment paramFragment) {
    addOp(new BackStackRecord$Op(3, paramFragment));
    return this;
  }
  
  public final void runOnCommitRunnables() {
    if (this.mCommitRunnables != null) {
      int i = 0;
      int j = this.mCommitRunnables.size();
      while (i < j) {
        ((Runnable)this.mCommitRunnables.get(i)).run();
        i++;
      } 
      this.mCommitRunnables = null;
    } 
  }
  
  final void setOnStartPostponedListener(Fragment$OnStartEnterTransitionListener paramFragment$OnStartEnterTransitionListener) {
    for (int i = 0; i < this.mOps.size(); i++) {
      BackStackRecord$Op backStackRecord$Op = this.mOps.get(i);
      if (isFragmentPostponed(backStackRecord$Op))
        backStackRecord$Op.fragment.setOnStartEnterTransitionListener(paramFragment$OnStartEnterTransitionListener); 
    } 
  }
  
  public final String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);
    stringBuilder.append("BackStackEntry{");
    stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    if (this.mIndex >= 0) {
      stringBuilder.append(" #");
      stringBuilder.append(this.mIndex);
    } 
    if (this.mName != null) {
      stringBuilder.append(" ");
      stringBuilder.append(this.mName);
    } 
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
  
  final Fragment trackAddedFragmentsInPop(ArrayList<Fragment> paramArrayList, Fragment paramFragment) {
    int i = 0;
    while (i < this.mOps.size()) {
      BackStackRecord$Op backStackRecord$Op = this.mOps.get(i);
      int j = backStackRecord$Op.cmd;
      if (j != 1)
        if (j != 3) {
          switch (j) {
            case 9:
              paramFragment = backStackRecord$Op.fragment;
              break;
            case 8:
              paramFragment = null;
              break;
            case 6:
              paramArrayList.add(backStackRecord$Op.fragment);
              break;
            case 7:
              paramArrayList.remove(backStackRecord$Op.fragment);
              break;
          } 
          i++;
        }  
    } 
    return paramFragment;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\app\BackStackRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */