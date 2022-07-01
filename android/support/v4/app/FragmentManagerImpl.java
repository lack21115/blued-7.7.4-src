package android.support.v4.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.util.ArraySet;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.LogWriter;
import android.support.v4.util.Pair;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

final class FragmentManagerImpl extends FragmentManager implements LayoutInflater.Factory2 {
  static boolean DEBUG = false;
  
  private static Interpolator DECELERATE_CUBIC;
  
  private static Interpolator DECELERATE_QUINT;
  
  private static Field sAnimationListenerField = null;
  
  SparseArray mActive;
  
  final ArrayList mAdded = new ArrayList();
  
  private ArrayList mAvailBackStackIndices;
  
  ArrayList mBackStack;
  
  private ArrayList mBackStackChangeListeners;
  
  private ArrayList mBackStackIndices;
  
  FragmentContainer mContainer;
  
  private ArrayList mCreatedMenus;
  
  int mCurState = 0;
  
  private boolean mDestroyed;
  
  private Runnable mExecCommit = new FragmentManagerImpl$1(this);
  
  private boolean mExecutingActions;
  
  private boolean mHavePendingDeferredStart;
  
  FragmentHostCallback mHost;
  
  private final CopyOnWriteArrayList mLifecycleCallbacks = new CopyOnWriteArrayList();
  
  private boolean mNeedMenuInvalidate;
  
  private int mNextFragmentIndex = 0;
  
  String mNoTransactionsBecause;
  
  private Fragment mParent;
  
  private ArrayList mPendingActions;
  
  private ArrayList mPostponedTransactions;
  
  Fragment mPrimaryNav;
  
  FragmentManagerNonConfig mSavedNonConfig;
  
  private SparseArray mStateArray = null;
  
  private Bundle mStateBundle = null;
  
  boolean mStateSaved;
  
  private ArrayList mTmpAddedFragments;
  
  private ArrayList mTmpIsPop;
  
  private ArrayList mTmpRecords;
  
  static {
    DECELERATE_QUINT = (Interpolator)new DecelerateInterpolator(2.5F);
    DECELERATE_CUBIC = (Interpolator)new DecelerateInterpolator(1.5F);
    new AccelerateInterpolator(2.5F);
    new AccelerateInterpolator(1.5F);
    throw new VerifyError("bad dex opcode");
  }
  
  private void addAddedFragments(ArraySet paramArraySet) {
    if (this.mCurState <= 0)
      return; 
    int j = Math.min(this.mCurState, 4);
    int k = this.mAdded.size();
    for (int i = 0; i < k; i++) {
      Fragment fragment = this.mAdded.get(i);
      if (fragment.mState < j) {
        moveToState(fragment, j, fragment.getNextAnim(), fragment.getNextTransition(), false);
        if (fragment.mView != null && !fragment.mHidden && fragment.mIsNewlyAdded)
          paramArraySet.add(fragment); 
      } 
    } 
  }
  
  private void burpActive() {
    if (this.mActive != null)
      for (int i = this.mActive.size() - 1; i >= 0; i--) {
        if (this.mActive.valueAt(i) == null)
          this.mActive.delete(this.mActive.keyAt(i)); 
      }  
  }
  
  private void checkStateLoss() {
    if (!this.mStateSaved) {
      if (this.mNoTransactionsBecause == null)
        return; 
      StringBuilder stringBuilder = new StringBuilder("Can not perform this action inside of ");
      stringBuilder.append(this.mNoTransactionsBecause);
      throw new IllegalStateException(stringBuilder.toString());
    } 
    throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
  }
  
  private void cleanupExec() {
    this.mExecutingActions = false;
    this.mTmpIsPop.clear();
    this.mTmpRecords.clear();
  }
  
  private void dispatchOnFragmentActivityCreated(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean) {
    if (this.mParent != null) {
      FragmentManagerImpl fragmentManagerImpl = this.mParent.mFragmentManager;
      if (fragmentManagerImpl instanceof FragmentManagerImpl)
        fragmentManagerImpl.dispatchOnFragmentActivityCreated(paramFragment, paramBundle, true); 
    } 
    for (Pair pair : this.mLifecycleCallbacks) {
      if (paramBoolean)
        ((Boolean)pair.second).booleanValue(); 
    } 
  }
  
  private void dispatchOnFragmentAttached(Fragment paramFragment, Context paramContext, boolean paramBoolean) {
    if (this.mParent != null) {
      FragmentManagerImpl fragmentManagerImpl = this.mParent.mFragmentManager;
      if (fragmentManagerImpl instanceof FragmentManagerImpl)
        fragmentManagerImpl.dispatchOnFragmentAttached(paramFragment, paramContext, true); 
    } 
    for (Pair pair : this.mLifecycleCallbacks) {
      if (paramBoolean)
        ((Boolean)pair.second).booleanValue(); 
    } 
  }
  
  private void dispatchOnFragmentCreated(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean) {
    if (this.mParent != null) {
      FragmentManagerImpl fragmentManagerImpl = this.mParent.mFragmentManager;
      if (fragmentManagerImpl instanceof FragmentManagerImpl)
        fragmentManagerImpl.dispatchOnFragmentCreated(paramFragment, paramBundle, true); 
    } 
    for (Pair pair : this.mLifecycleCallbacks) {
      if (paramBoolean)
        ((Boolean)pair.second).booleanValue(); 
    } 
  }
  
  private void dispatchOnFragmentDestroyed(Fragment paramFragment, boolean paramBoolean) {
    if (this.mParent != null) {
      FragmentManagerImpl fragmentManagerImpl = this.mParent.mFragmentManager;
      if (fragmentManagerImpl instanceof FragmentManagerImpl)
        fragmentManagerImpl.dispatchOnFragmentDestroyed(paramFragment, true); 
    } 
    for (Pair pair : this.mLifecycleCallbacks) {
      if (paramBoolean)
        ((Boolean)pair.second).booleanValue(); 
    } 
  }
  
  private void dispatchOnFragmentDetached(Fragment paramFragment, boolean paramBoolean) {
    if (this.mParent != null) {
      FragmentManagerImpl fragmentManagerImpl = this.mParent.mFragmentManager;
      if (fragmentManagerImpl instanceof FragmentManagerImpl)
        fragmentManagerImpl.dispatchOnFragmentDetached(paramFragment, true); 
    } 
    for (Pair pair : this.mLifecycleCallbacks) {
      if (paramBoolean)
        ((Boolean)pair.second).booleanValue(); 
    } 
  }
  
  private void dispatchOnFragmentPaused(Fragment paramFragment, boolean paramBoolean) {
    if (this.mParent != null) {
      FragmentManagerImpl fragmentManagerImpl = this.mParent.mFragmentManager;
      if (fragmentManagerImpl instanceof FragmentManagerImpl)
        fragmentManagerImpl.dispatchOnFragmentPaused(paramFragment, true); 
    } 
    for (Pair pair : this.mLifecycleCallbacks) {
      if (paramBoolean)
        ((Boolean)pair.second).booleanValue(); 
    } 
  }
  
  private void dispatchOnFragmentPreAttached(Fragment paramFragment, Context paramContext, boolean paramBoolean) {
    if (this.mParent != null) {
      FragmentManagerImpl fragmentManagerImpl = this.mParent.mFragmentManager;
      if (fragmentManagerImpl instanceof FragmentManagerImpl)
        fragmentManagerImpl.dispatchOnFragmentPreAttached(paramFragment, paramContext, true); 
    } 
    for (Pair pair : this.mLifecycleCallbacks) {
      if (paramBoolean)
        ((Boolean)pair.second).booleanValue(); 
    } 
  }
  
  private void dispatchOnFragmentPreCreated(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean) {
    if (this.mParent != null) {
      FragmentManagerImpl fragmentManagerImpl = this.mParent.mFragmentManager;
      if (fragmentManagerImpl instanceof FragmentManagerImpl)
        fragmentManagerImpl.dispatchOnFragmentPreCreated(paramFragment, paramBundle, true); 
    } 
    for (Pair pair : this.mLifecycleCallbacks) {
      if (paramBoolean)
        ((Boolean)pair.second).booleanValue(); 
    } 
  }
  
  private void dispatchOnFragmentResumed(Fragment paramFragment, boolean paramBoolean) {
    if (this.mParent != null) {
      FragmentManagerImpl fragmentManagerImpl = this.mParent.mFragmentManager;
      if (fragmentManagerImpl instanceof FragmentManagerImpl)
        fragmentManagerImpl.dispatchOnFragmentResumed(paramFragment, true); 
    } 
    for (Pair pair : this.mLifecycleCallbacks) {
      if (paramBoolean)
        ((Boolean)pair.second).booleanValue(); 
    } 
  }
  
  private void dispatchOnFragmentSaveInstanceState(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean) {
    if (this.mParent != null) {
      FragmentManagerImpl fragmentManagerImpl = this.mParent.mFragmentManager;
      if (fragmentManagerImpl instanceof FragmentManagerImpl)
        fragmentManagerImpl.dispatchOnFragmentSaveInstanceState(paramFragment, paramBundle, true); 
    } 
    for (Pair pair : this.mLifecycleCallbacks) {
      if (paramBoolean)
        ((Boolean)pair.second).booleanValue(); 
    } 
  }
  
  private void dispatchOnFragmentStarted(Fragment paramFragment, boolean paramBoolean) {
    if (this.mParent != null) {
      FragmentManagerImpl fragmentManagerImpl = this.mParent.mFragmentManager;
      if (fragmentManagerImpl instanceof FragmentManagerImpl)
        fragmentManagerImpl.dispatchOnFragmentStarted(paramFragment, true); 
    } 
    for (Pair pair : this.mLifecycleCallbacks) {
      if (paramBoolean)
        ((Boolean)pair.second).booleanValue(); 
    } 
  }
  
  private void dispatchOnFragmentStopped(Fragment paramFragment, boolean paramBoolean) {
    if (this.mParent != null) {
      FragmentManagerImpl fragmentManagerImpl = this.mParent.mFragmentManager;
      if (fragmentManagerImpl instanceof FragmentManagerImpl)
        fragmentManagerImpl.dispatchOnFragmentStopped(paramFragment, true); 
    } 
    for (Pair pair : this.mLifecycleCallbacks) {
      if (paramBoolean)
        ((Boolean)pair.second).booleanValue(); 
    } 
  }
  
  private void dispatchOnFragmentViewCreated(Fragment paramFragment, View paramView, Bundle paramBundle, boolean paramBoolean) {
    if (this.mParent != null) {
      FragmentManagerImpl fragmentManagerImpl = this.mParent.mFragmentManager;
      if (fragmentManagerImpl instanceof FragmentManagerImpl)
        fragmentManagerImpl.dispatchOnFragmentViewCreated(paramFragment, paramView, paramBundle, true); 
    } 
    for (Pair pair : this.mLifecycleCallbacks) {
      if (paramBoolean)
        ((Boolean)pair.second).booleanValue(); 
    } 
  }
  
  private void dispatchOnFragmentViewDestroyed(Fragment paramFragment, boolean paramBoolean) {
    if (this.mParent != null) {
      FragmentManagerImpl fragmentManagerImpl = this.mParent.mFragmentManager;
      if (fragmentManagerImpl instanceof FragmentManagerImpl)
        fragmentManagerImpl.dispatchOnFragmentViewDestroyed(paramFragment, true); 
    } 
    for (Pair pair : this.mLifecycleCallbacks) {
      if (paramBoolean)
        ((Boolean)pair.second).booleanValue(); 
    } 
  }
  
  private void doPendingDeferredStart() {
    if (this.mHavePendingDeferredStart) {
      int i = 0;
      boolean bool;
      for (bool = false; i < this.mActive.size(); bool = bool1) {
        Fragment fragment = (Fragment)this.mActive.valueAt(i);
        boolean bool1 = bool;
        if (fragment != null) {
          bool1 = bool;
          if (fragment.mLoaderManager != null)
            bool1 = bool | fragment.mLoaderManager.hasRunningLoaders(); 
        } 
        i++;
      } 
      if (!bool) {
        this.mHavePendingDeferredStart = false;
        startPendingDeferredFragments();
      } 
    } 
  }
  
  private void ensureExecReady(boolean paramBoolean) {
    if (!this.mExecutingActions) {
      if (Looper.myLooper() == this.mHost.mHandler.getLooper()) {
        if (!paramBoolean)
          checkStateLoss(); 
        if (this.mTmpRecords == null) {
          this.mTmpRecords = new ArrayList();
          this.mTmpIsPop = new ArrayList();
        } 
        this.mExecutingActions = true;
        try {
          executePostponedTransaction(null, null);
          return;
        } finally {
          this.mExecutingActions = false;
        } 
      } 
      throw new IllegalStateException("Must be called from main thread of fragment host");
    } 
    throw new IllegalStateException("FragmentManager is already executing transactions");
  }
  
  private static void executeOps(ArrayList<BackStackRecord> paramArrayList1, ArrayList<Boolean> paramArrayList2, int paramInt1, int paramInt2) {
    while (paramInt1 < paramInt2) {
      BackStackRecord backStackRecord = paramArrayList1.get(paramInt1);
      boolean bool1 = ((Boolean)paramArrayList2.get(paramInt1)).booleanValue();
      boolean bool = true;
      if (bool1) {
        backStackRecord.bumpBackStackNesting(-1);
        if (paramInt1 != paramInt2 - 1)
          bool = false; 
        backStackRecord.executePopOps(bool);
      } else {
        backStackRecord.bumpBackStackNesting(1);
        backStackRecord.executeOps();
      } 
      paramInt1++;
    } 
  }
  
  private void executeOpsTogether(ArrayList<BackStackRecord> paramArrayList1, ArrayList<Boolean> paramArrayList2, int paramInt1, int paramInt2) {
    // Byte code:
    //   0: iload_3
    //   1: istore #5
    //   3: aload_1
    //   4: iload #5
    //   6: invokevirtual get : (I)Ljava/lang/Object;
    //   9: checkcast android/support/v4/app/BackStackRecord
    //   12: getfield mReorderingAllowed : Z
    //   15: istore #9
    //   17: aload_0
    //   18: getfield mTmpAddedFragments : Ljava/util/ArrayList;
    //   21: ifnonnull -> 38
    //   24: aload_0
    //   25: new java/util/ArrayList
    //   28: dup
    //   29: invokespecial <init> : ()V
    //   32: putfield mTmpAddedFragments : Ljava/util/ArrayList;
    //   35: goto -> 45
    //   38: aload_0
    //   39: getfield mTmpAddedFragments : Ljava/util/ArrayList;
    //   42: invokevirtual clear : ()V
    //   45: aload_0
    //   46: getfield mTmpAddedFragments : Ljava/util/ArrayList;
    //   49: aload_0
    //   50: getfield mAdded : Ljava/util/ArrayList;
    //   53: invokevirtual addAll : (Ljava/util/Collection;)Z
    //   56: pop
    //   57: aload_0
    //   58: getfield mPrimaryNav : Landroid/support/v4/app/Fragment;
    //   61: astore #10
    //   63: iload #5
    //   65: istore #7
    //   67: iconst_0
    //   68: istore #6
    //   70: iload #7
    //   72: iload #4
    //   74: if_icmpge -> 166
    //   77: aload_1
    //   78: iload #7
    //   80: invokevirtual get : (I)Ljava/lang/Object;
    //   83: checkcast android/support/v4/app/BackStackRecord
    //   86: astore #11
    //   88: aload_2
    //   89: iload #7
    //   91: invokevirtual get : (I)Ljava/lang/Object;
    //   94: checkcast java/lang/Boolean
    //   97: invokevirtual booleanValue : ()Z
    //   100: ifne -> 119
    //   103: aload #11
    //   105: aload_0
    //   106: getfield mTmpAddedFragments : Ljava/util/ArrayList;
    //   109: aload #10
    //   111: invokevirtual expandOps : (Ljava/util/ArrayList;Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/Fragment;
    //   114: astore #10
    //   116: goto -> 132
    //   119: aload #11
    //   121: aload_0
    //   122: getfield mTmpAddedFragments : Ljava/util/ArrayList;
    //   125: aload #10
    //   127: invokevirtual trackAddedFragmentsInPop : (Ljava/util/ArrayList;Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/Fragment;
    //   130: astore #10
    //   132: iload #6
    //   134: ifne -> 154
    //   137: aload #11
    //   139: getfield mAddToBackStack : Z
    //   142: ifeq -> 148
    //   145: goto -> 154
    //   148: iconst_0
    //   149: istore #6
    //   151: goto -> 157
    //   154: iconst_1
    //   155: istore #6
    //   157: iload #7
    //   159: iconst_1
    //   160: iadd
    //   161: istore #7
    //   163: goto -> 70
    //   166: aload_0
    //   167: getfield mTmpAddedFragments : Ljava/util/ArrayList;
    //   170: invokevirtual clear : ()V
    //   173: iload #9
    //   175: ifne -> 188
    //   178: aload_0
    //   179: aload_1
    //   180: aload_2
    //   181: iload_3
    //   182: iload #4
    //   184: iconst_0
    //   185: invokestatic startTransitions : (Landroid/support/v4/app/FragmentManagerImpl;Ljava/util/ArrayList;Ljava/util/ArrayList;IIZ)V
    //   188: aload_1
    //   189: aload_2
    //   190: iload_3
    //   191: iload #4
    //   193: invokestatic executeOps : (Ljava/util/ArrayList;Ljava/util/ArrayList;II)V
    //   196: iload #9
    //   198: ifeq -> 237
    //   201: new android/support/v4/util/ArraySet
    //   204: dup
    //   205: invokespecial <init> : ()V
    //   208: astore #10
    //   210: aload_0
    //   211: aload #10
    //   213: invokespecial addAddedFragments : (Landroid/support/v4/util/ArraySet;)V
    //   216: aload_0
    //   217: aload_1
    //   218: aload_2
    //   219: iload_3
    //   220: iload #4
    //   222: aload #10
    //   224: invokespecial postponePostponableTransactions : (Ljava/util/ArrayList;Ljava/util/ArrayList;IILandroid/support/v4/util/ArraySet;)I
    //   227: istore #8
    //   229: aload #10
    //   231: invokestatic makeRemovedFragmentsInvisible : (Landroid/support/v4/util/ArraySet;)V
    //   234: goto -> 241
    //   237: iload #4
    //   239: istore #8
    //   241: iload #5
    //   243: istore #7
    //   245: iload #8
    //   247: iload #5
    //   249: if_icmpeq -> 284
    //   252: iload #5
    //   254: istore #7
    //   256: iload #9
    //   258: ifeq -> 284
    //   261: aload_0
    //   262: aload_1
    //   263: aload_2
    //   264: iload_3
    //   265: iload #8
    //   267: iconst_1
    //   268: invokestatic startTransitions : (Landroid/support/v4/app/FragmentManagerImpl;Ljava/util/ArrayList;Ljava/util/ArrayList;IIZ)V
    //   271: aload_0
    //   272: aload_0
    //   273: getfield mCurState : I
    //   276: iconst_1
    //   277: invokevirtual moveToState : (IZ)V
    //   280: iload #5
    //   282: istore #7
    //   284: iload #7
    //   286: iload #4
    //   288: if_icmpge -> 403
    //   291: aload_1
    //   292: iload #7
    //   294: invokevirtual get : (I)Ljava/lang/Object;
    //   297: checkcast android/support/v4/app/BackStackRecord
    //   300: astore #10
    //   302: aload_2
    //   303: iload #7
    //   305: invokevirtual get : (I)Ljava/lang/Object;
    //   308: checkcast java/lang/Boolean
    //   311: invokevirtual booleanValue : ()Z
    //   314: ifeq -> 389
    //   317: aload #10
    //   319: getfield mIndex : I
    //   322: iflt -> 389
    //   325: aload #10
    //   327: getfield mIndex : I
    //   330: istore_3
    //   331: aload_0
    //   332: monitorenter
    //   333: aload_0
    //   334: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   337: iload_3
    //   338: aconst_null
    //   339: invokevirtual set : (ILjava/lang/Object;)Ljava/lang/Object;
    //   342: pop
    //   343: aload_0
    //   344: getfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   347: ifnonnull -> 361
    //   350: aload_0
    //   351: new java/util/ArrayList
    //   354: dup
    //   355: invokespecial <init> : ()V
    //   358: putfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   361: aload_0
    //   362: getfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   365: iload_3
    //   366: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   369: invokevirtual add : (Ljava/lang/Object;)Z
    //   372: pop
    //   373: aload_0
    //   374: monitorexit
    //   375: aload #10
    //   377: iconst_m1
    //   378: putfield mIndex : I
    //   381: goto -> 389
    //   384: astore_1
    //   385: aload_0
    //   386: monitorexit
    //   387: aload_1
    //   388: athrow
    //   389: aload #10
    //   391: invokevirtual runOnCommitRunnables : ()V
    //   394: iload #7
    //   396: iconst_1
    //   397: iadd
    //   398: istore #7
    //   400: goto -> 284
    //   403: iload #6
    //   405: ifeq -> 412
    //   408: aload_0
    //   409: invokespecial reportBackStackChanged : ()V
    //   412: return
    // Exception table:
    //   from	to	target	type
    //   333	361	384	finally
    //   361	375	384	finally
    //   385	387	384	finally
  }
  
  private void executePostponedTransaction(ArrayList paramArrayList1, ArrayList paramArrayList2) {
    // Byte code:
    //   0: aload_0
    //   1: getfield mPostponedTransactions : Ljava/util/ArrayList;
    //   4: ifnonnull -> 12
    //   7: iconst_0
    //   8: istore_3
    //   9: goto -> 20
    //   12: aload_0
    //   13: getfield mPostponedTransactions : Ljava/util/ArrayList;
    //   16: invokevirtual size : ()I
    //   19: istore_3
    //   20: iconst_0
    //   21: istore #5
    //   23: iload_3
    //   24: istore #4
    //   26: iload #5
    //   28: istore_3
    //   29: iload_3
    //   30: iload #4
    //   32: if_icmpge -> 250
    //   35: aload_0
    //   36: getfield mPostponedTransactions : Ljava/util/ArrayList;
    //   39: iload_3
    //   40: invokevirtual get : (I)Ljava/lang/Object;
    //   43: checkcast android/support/v4/app/FragmentManagerImpl$StartEnterTransitionListener
    //   46: astore #7
    //   48: aload_1
    //   49: ifnull -> 107
    //   52: aload #7
    //   54: getfield mIsBack : Z
    //   57: ifne -> 107
    //   60: aload_1
    //   61: aload #7
    //   63: getfield mRecord : Landroid/support/v4/app/BackStackRecord;
    //   66: invokevirtual indexOf : (Ljava/lang/Object;)I
    //   69: istore #5
    //   71: iload #5
    //   73: iconst_m1
    //   74: if_icmpeq -> 107
    //   77: aload_2
    //   78: iload #5
    //   80: invokevirtual get : (I)Ljava/lang/Object;
    //   83: checkcast java/lang/Boolean
    //   86: invokevirtual booleanValue : ()Z
    //   89: ifeq -> 107
    //   92: aload #7
    //   94: invokevirtual cancelTransaction : ()V
    //   97: iload_3
    //   98: istore #6
    //   100: iload #4
    //   102: istore #5
    //   104: goto -> 238
    //   107: aload #7
    //   109: getfield mNumPostponed : I
    //   112: ifne -> 121
    //   115: iconst_1
    //   116: istore #5
    //   118: goto -> 124
    //   121: iconst_0
    //   122: istore #5
    //   124: iload #5
    //   126: ifne -> 164
    //   129: iload_3
    //   130: istore #6
    //   132: iload #4
    //   134: istore #5
    //   136: aload_1
    //   137: ifnull -> 238
    //   140: iload_3
    //   141: istore #6
    //   143: iload #4
    //   145: istore #5
    //   147: aload #7
    //   149: getfield mRecord : Landroid/support/v4/app/BackStackRecord;
    //   152: aload_1
    //   153: iconst_0
    //   154: aload_1
    //   155: invokevirtual size : ()I
    //   158: invokevirtual interactsWith : (Ljava/util/ArrayList;II)Z
    //   161: ifeq -> 238
    //   164: aload_0
    //   165: getfield mPostponedTransactions : Ljava/util/ArrayList;
    //   168: iload_3
    //   169: invokevirtual remove : (I)Ljava/lang/Object;
    //   172: pop
    //   173: iload_3
    //   174: iconst_1
    //   175: isub
    //   176: istore #6
    //   178: iload #4
    //   180: iconst_1
    //   181: isub
    //   182: istore #5
    //   184: aload_1
    //   185: ifnull -> 233
    //   188: aload #7
    //   190: getfield mIsBack : Z
    //   193: ifne -> 233
    //   196: aload_1
    //   197: aload #7
    //   199: getfield mRecord : Landroid/support/v4/app/BackStackRecord;
    //   202: invokevirtual indexOf : (Ljava/lang/Object;)I
    //   205: istore_3
    //   206: iload_3
    //   207: iconst_m1
    //   208: if_icmpeq -> 233
    //   211: aload_2
    //   212: iload_3
    //   213: invokevirtual get : (I)Ljava/lang/Object;
    //   216: checkcast java/lang/Boolean
    //   219: invokevirtual booleanValue : ()Z
    //   222: ifeq -> 233
    //   225: aload #7
    //   227: invokevirtual cancelTransaction : ()V
    //   230: goto -> 238
    //   233: aload #7
    //   235: invokevirtual completeTransaction : ()V
    //   238: iload #6
    //   240: iconst_1
    //   241: iadd
    //   242: istore_3
    //   243: iload #5
    //   245: istore #4
    //   247: goto -> 29
    //   250: return
  }
  
  private Fragment findFragmentById(int paramInt) {
    int i;
    for (i = this.mAdded.size() - 1; i >= 0; i--) {
      Fragment fragment = this.mAdded.get(i);
      if (fragment != null && fragment.mFragmentId == paramInt)
        return fragment; 
    } 
    if (this.mActive != null)
      for (i = this.mActive.size() - 1; i >= 0; i--) {
        Fragment fragment = (Fragment)this.mActive.valueAt(i);
        if (fragment != null && fragment.mFragmentId == paramInt)
          return fragment; 
      }  
    return null;
  }
  
  private boolean generateOpsForPendingActions(ArrayList paramArrayList1, ArrayList paramArrayList2) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mPendingActions : Ljava/util/ArrayList;
    //   6: astore #6
    //   8: iconst_0
    //   9: istore_3
    //   10: aload #6
    //   12: ifnull -> 102
    //   15: aload_0
    //   16: getfield mPendingActions : Ljava/util/ArrayList;
    //   19: invokevirtual size : ()I
    //   22: ifne -> 28
    //   25: goto -> 102
    //   28: aload_0
    //   29: getfield mPendingActions : Ljava/util/ArrayList;
    //   32: invokevirtual size : ()I
    //   35: istore #4
    //   37: iconst_0
    //   38: istore #5
    //   40: iload_3
    //   41: iload #4
    //   43: if_icmpge -> 76
    //   46: iload #5
    //   48: aload_0
    //   49: getfield mPendingActions : Ljava/util/ArrayList;
    //   52: iload_3
    //   53: invokevirtual get : (I)Ljava/lang/Object;
    //   56: checkcast android/support/v4/app/FragmentManagerImpl$OpGenerator
    //   59: aload_1
    //   60: aload_2
    //   61: invokeinterface generateOps : (Ljava/util/ArrayList;Ljava/util/ArrayList;)Z
    //   66: ior
    //   67: istore #5
    //   69: iload_3
    //   70: iconst_1
    //   71: iadd
    //   72: istore_3
    //   73: goto -> 40
    //   76: aload_0
    //   77: getfield mPendingActions : Ljava/util/ArrayList;
    //   80: invokevirtual clear : ()V
    //   83: aload_0
    //   84: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   87: getfield mHandler : Landroid/os/Handler;
    //   90: aload_0
    //   91: getfield mExecCommit : Ljava/lang/Runnable;
    //   94: invokevirtual removeCallbacks : (Ljava/lang/Runnable;)V
    //   97: aload_0
    //   98: monitorexit
    //   99: iload #5
    //   101: ireturn
    //   102: aload_0
    //   103: monitorexit
    //   104: iconst_0
    //   105: ireturn
    //   106: astore_1
    //   107: aload_0
    //   108: monitorexit
    //   109: aload_1
    //   110: athrow
    // Exception table:
    //   from	to	target	type
    //   2	8	106	finally
    //   15	25	106	finally
    //   28	37	106	finally
    //   46	69	106	finally
    //   76	99	106	finally
    //   102	104	106	finally
    //   107	109	106	finally
  }
  
  private static Animation.AnimationListener getAnimationListener(Animation paramAnimation) {
    try {
      if (sAnimationListenerField == null) {
        Field field = Animation.class.getDeclaredField("mListener");
        sAnimationListenerField = field;
        field.setAccessible(true);
      } 
      return (Animation.AnimationListener)sAnimationListenerField.get(paramAnimation);
    } catch (NoSuchFieldException noSuchFieldException) {
      Log.e("FragmentManager", "No field with the name mListener is found in Animation class", noSuchFieldException);
    } catch (IllegalAccessException illegalAccessException) {
      Log.e("FragmentManager", "Cannot access Animation's mListener field", illegalAccessException);
    } 
    return null;
  }
  
  private Fragment getFragment(Bundle paramBundle, String paramString) {
    int i = paramBundle.getInt(paramString, -1);
    if (i == -1)
      return null; 
    Fragment fragment = (Fragment)this.mActive.get(i);
    if (fragment == null) {
      StringBuilder stringBuilder = new StringBuilder("Fragment no longer exists for key ");
      stringBuilder.append(paramString);
      stringBuilder.append(": index ");
      stringBuilder.append(i);
      throwException(new IllegalStateException(stringBuilder.toString()));
    } 
    return fragment;
  }
  
  public static void hideFragment(Fragment paramFragment) {
    if (DEBUG)
      (new StringBuilder("hide: ")).append(paramFragment); 
    if (!paramFragment.mHidden) {
      paramFragment.mHidden = true;
      paramFragment.mHiddenChanged = true ^ paramFragment.mHiddenChanged;
    } 
  }
  
  private FragmentManagerImpl$AnimationOrAnimator loadAnimation(Fragment paramFragment, int paramInt1, boolean paramBoolean, int paramInt2) {
    int i = paramFragment.getNextAnim();
    Animation animation = Fragment.onCreateAnimation$24236ca7();
    if (animation != null)
      return new FragmentManagerImpl$AnimationOrAnimator(animation, (byte)0); 
    Animator animator = Fragment.onCreateAnimator$ed6a78a();
    if (animator != null)
      return new FragmentManagerImpl$AnimationOrAnimator(animator, (byte)0); 
    if (i != 0) {
      boolean bool;
      boolean bool1 = "anim".equals(this.mHost.mContext.getResources().getResourceTypeName(i));
      if (bool1) {
        try {
          Animation animation1 = AnimationUtils.loadAnimation(this.mHost.mContext, i);
          if (animation1 != null)
            return new FragmentManagerImpl$AnimationOrAnimator(animation1, (byte)0); 
          bool = true;
        } catch (android.content.res.Resources.NotFoundException notFoundException) {
          throw notFoundException;
        } catch (RuntimeException runtimeException) {}
      } else {
        bool = false;
      } 
      if (!bool)
        try {
          animator = AnimatorInflater.loadAnimator(this.mHost.mContext, i);
          if (animator != null)
            return new FragmentManagerImpl$AnimationOrAnimator(animator, (byte)0); 
        } catch (RuntimeException runtimeException) {
          Animation animation1;
          if (!bool1) {
            animation1 = AnimationUtils.loadAnimation(this.mHost.mContext, i);
            if (animation1 != null)
              return new FragmentManagerImpl$AnimationOrAnimator(animation1, (byte)0); 
          } else {
            throw animation1;
          } 
        }  
    } 
    if (paramInt1 == 0)
      return null; 
    byte b = -1;
    if (paramInt1 != 4097) {
      if (paramInt1 != 4099) {
        if (paramInt1 != 8194) {
          paramInt1 = b;
        } else if (paramBoolean) {
          paramInt1 = 3;
        } else {
          paramInt1 = 4;
        } 
      } else if (paramBoolean) {
        paramInt1 = 5;
      } else {
        paramInt1 = 6;
      } 
    } else if (paramBoolean) {
      paramInt1 = 1;
    } else {
      paramInt1 = 2;
    } 
    if (paramInt1 < 0)
      return null; 
    switch (paramInt1) {
      default:
        paramInt1 = paramInt2;
        if (paramInt2 == 0) {
          paramInt1 = paramInt2;
          if (this.mHost.onHasWindowAnimations())
            paramInt1 = this.mHost.onGetWindowAnimations(); 
        } 
        break;
      case 6:
        return makeFadeAnimation$232aeb16(1.0F, 0.0F);
      case 5:
        return makeFadeAnimation$232aeb16(0.0F, 1.0F);
      case 4:
        return makeOpenCloseAnimation$5da6b5aa(1.0F, 1.075F, 1.0F, 0.0F);
      case 3:
        return makeOpenCloseAnimation$5da6b5aa(0.975F, 1.0F, 0.0F, 1.0F);
      case 2:
        return makeOpenCloseAnimation$5da6b5aa(1.0F, 0.975F, 1.0F, 0.0F);
      case 1:
        return makeOpenCloseAnimation$5da6b5aa(1.125F, 1.0F, 0.0F, 1.0F);
    } 
    return (FragmentManagerImpl$AnimationOrAnimator)((paramInt1 == 0) ? null : null);
  }
  
  private static FragmentManagerImpl$AnimationOrAnimator makeFadeAnimation$232aeb16(float paramFloat1, float paramFloat2) {
    AlphaAnimation alphaAnimation = new AlphaAnimation(paramFloat1, paramFloat2);
    alphaAnimation.setInterpolator(DECELERATE_CUBIC);
    alphaAnimation.setDuration(220L);
    return new FragmentManagerImpl$AnimationOrAnimator((Animation)alphaAnimation, (byte)0);
  }
  
  private static FragmentManagerImpl$AnimationOrAnimator makeOpenCloseAnimation$5da6b5aa(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    AnimationSet animationSet = new AnimationSet(false);
    ScaleAnimation scaleAnimation = new ScaleAnimation(paramFloat1, paramFloat2, paramFloat1, paramFloat2, 1, 0.5F, 1, 0.5F);
    scaleAnimation.setInterpolator(DECELERATE_QUINT);
    scaleAnimation.setDuration(220L);
    animationSet.addAnimation((Animation)scaleAnimation);
    AlphaAnimation alphaAnimation = new AlphaAnimation(paramFloat3, paramFloat4);
    alphaAnimation.setInterpolator(DECELERATE_CUBIC);
    alphaAnimation.setDuration(220L);
    animationSet.addAnimation((Animation)alphaAnimation);
    return new FragmentManagerImpl$AnimationOrAnimator((Animation)animationSet, (byte)0);
  }
  
  private static void makeRemovedFragmentsInvisible(ArraySet paramArraySet) {
    int j = paramArraySet.size();
    for (int i = 0; i < j; i++) {
      Fragment fragment = (Fragment)paramArraySet.mArray[i];
      if (!fragment.mAdded) {
        View view = fragment.mView;
        fragment.mPostponedAlpha = view.getAlpha();
        view.setAlpha(0.0F);
      } 
    } 
  }
  
  private static boolean modifiesAlpha(Animator paramAnimator) {
    PropertyValuesHolder[] arrayOfPropertyValuesHolder;
    if (paramAnimator == null)
      return false; 
    if (paramAnimator instanceof ValueAnimator) {
      arrayOfPropertyValuesHolder = ((ValueAnimator)paramAnimator).getValues();
      for (int i = 0; i < arrayOfPropertyValuesHolder.length; i++) {
        if ("alpha".equals(arrayOfPropertyValuesHolder[i].getPropertyName()))
          return true; 
      } 
      return false;
    } 
    if (arrayOfPropertyValuesHolder instanceof AnimatorSet) {
      ArrayList<Animator> arrayList = ((AnimatorSet)arrayOfPropertyValuesHolder).getChildAnimations();
      for (int i = 0; i < arrayList.size(); i++) {
        if (modifiesAlpha(arrayList.get(i)))
          return true; 
      } 
    } 
    return false;
  }
  
  private void moveToState(Fragment paramFragment) {
    moveToState(paramFragment, this.mCurState, 0, 0, false);
  }
  
  private boolean popBackStackImmediate(String paramString, int paramInt1, int paramInt2) {
    execPendingActions();
    ensureExecReady(true);
    if (this.mPrimaryNav != null && paramInt1 < 0 && paramString == null) {
      FragmentManagerImpl fragmentManagerImpl = this.mPrimaryNav.mChildFragmentManager;
      if (fragmentManagerImpl != null && fragmentManagerImpl.popBackStackImmediate())
        return true; 
    } 
    boolean bool = popBackStackState(this.mTmpRecords, this.mTmpIsPop, paramString, paramInt1, paramInt2);
    if (bool) {
      this.mExecutingActions = true;
      try {
        removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
      } finally {
        cleanupExec();
      } 
    } 
    doPendingDeferredStart();
    burpActive();
    return bool;
  }
  
  private int postponePostponableTransactions(ArrayList<BackStackRecord> paramArrayList1, ArrayList<Boolean> paramArrayList2, int paramInt1, int paramInt2, ArraySet paramArraySet) {
    int i = paramInt2 - 1;
    int j;
    for (j = paramInt2; i >= paramInt1; j = k) {
      boolean bool;
      BackStackRecord backStackRecord = paramArrayList1.get(i);
      boolean bool1 = ((Boolean)paramArrayList2.get(i)).booleanValue();
      int k = 0;
      while (true) {
        int m = backStackRecord.mOps.size();
        bool = true;
        if (k < m) {
          if (BackStackRecord.isFragmentPostponed(backStackRecord.mOps.get(k))) {
            k = 1;
            break;
          } 
          k++;
          continue;
        } 
        k = 0;
        break;
      } 
      if (k == 0 || backStackRecord.interactsWith(paramArrayList1, i + 1, paramInt2))
        bool = false; 
      k = j;
      if (bool) {
        if (this.mPostponedTransactions == null)
          this.mPostponedTransactions = new ArrayList(); 
        FragmentManagerImpl$StartEnterTransitionListener fragmentManagerImpl$StartEnterTransitionListener = new FragmentManagerImpl$StartEnterTransitionListener(backStackRecord, bool1);
        this.mPostponedTransactions.add(fragmentManagerImpl$StartEnterTransitionListener);
        backStackRecord.setOnStartPostponedListener(fragmentManagerImpl$StartEnterTransitionListener);
        if (bool1) {
          backStackRecord.executeOps();
        } else {
          backStackRecord.executePopOps(false);
        } 
        k = j - 1;
        if (i != k) {
          paramArrayList1.remove(i);
          paramArrayList1.add(k, backStackRecord);
        } 
        addAddedFragments(paramArraySet);
      } 
      i--;
    } 
    return j;
  }
  
  private void removeRedundantOperationsAndExecute(ArrayList paramArrayList1, ArrayList<Boolean> paramArrayList2) {
    if (paramArrayList1 != null) {
      if (paramArrayList1.isEmpty())
        return; 
      if (paramArrayList2 != null && paramArrayList1.size() == paramArrayList2.size()) {
        executePostponedTransaction(paramArrayList1, paramArrayList2);
        int k = paramArrayList1.size();
        int i = 0;
        int j;
        for (j = 0; i < k; j = m) {
          int n = i;
          int m = j;
          if (!((BackStackRecord)paramArrayList1.get(i)).mReorderingAllowed) {
            if (j != i)
              executeOpsTogether(paramArrayList1, paramArrayList2, j, i); 
            j = i + 1;
            m = j;
            if (((Boolean)paramArrayList2.get(i)).booleanValue())
              while (true) {
                m = j;
                if (j < k) {
                  m = j;
                  if (((Boolean)paramArrayList2.get(j)).booleanValue()) {
                    m = j;
                    if (!((BackStackRecord)paramArrayList1.get(j)).mReorderingAllowed) {
                      j++;
                      continue;
                    } 
                  } 
                } 
                break;
              }  
            executeOpsTogether(paramArrayList1, paramArrayList2, i, m);
            n = m - 1;
          } 
          i = n + 1;
        } 
        if (j != k)
          executeOpsTogether(paramArrayList1, paramArrayList2, j, k); 
        return;
      } 
      throw new IllegalStateException("Internal error with the back stack records");
    } 
  }
  
  private void reportBackStackChanged() {
    if (this.mBackStackChangeListeners != null)
      for (int i = 0; i < this.mBackStackChangeListeners.size(); i++)
        this.mBackStackChangeListeners.get(i);  
  }
  
  public static int reverseTransit(int paramInt) {
    return (paramInt != 4097) ? ((paramInt != 4099) ? ((paramInt != 8194) ? 0 : 4097) : 4099) : 8194;
  }
  
  private void saveFragmentViewState(Fragment paramFragment) {
    if (paramFragment.mInnerView == null)
      return; 
    if (this.mStateArray == null) {
      this.mStateArray = new SparseArray();
    } else {
      this.mStateArray.clear();
    } 
    paramFragment.mInnerView.saveHierarchyState(this.mStateArray);
    if (this.mStateArray.size() > 0) {
      paramFragment.mSavedViewState = this.mStateArray;
      this.mStateArray = null;
    } 
  }
  
  private void saveNonConfig() {
    List list1;
    List list2;
    if (this.mActive != null) {
      ArrayList<Fragment> arrayList1 = null;
      ArrayList<Fragment> arrayList2 = arrayList1;
      int i = 0;
      while (true) {
        list2 = arrayList1;
        list1 = arrayList2;
        if (i < this.mActive.size()) {
          Fragment fragment = (Fragment)this.mActive.valueAt(i);
          list2 = arrayList1;
          ArrayList<Fragment> arrayList = arrayList2;
          if (fragment != null) {
            FragmentManagerNonConfig fragmentManagerNonConfig;
            list1 = arrayList1;
            if (fragment.mRetainInstance) {
              byte b;
              list2 = arrayList1;
              if (arrayList1 == null)
                list2 = new ArrayList(); 
              list2.add(fragment);
              if (fragment.mTarget != null) {
                b = fragment.mTarget.mIndex;
              } else {
                b = -1;
              } 
              fragment.mTargetIndex = b;
              list1 = list2;
              if (DEBUG) {
                (new StringBuilder("retainNonConfig: keeping retained ")).append(fragment);
                list1 = list2;
              } 
            } 
            if (fragment.mChildFragmentManager != null) {
              fragment.mChildFragmentManager.saveNonConfig();
              fragmentManagerNonConfig = fragment.mChildFragmentManager.mSavedNonConfig;
            } else {
              fragmentManagerNonConfig = ((Fragment)fragmentManagerNonConfig).mChildNonConfig;
            } 
            arrayList1 = arrayList2;
            if (arrayList2 == null) {
              arrayList1 = arrayList2;
              if (fragmentManagerNonConfig != null) {
                arrayList2 = new ArrayList<Fragment>(this.mActive.size());
                int j = 0;
                while (true) {
                  arrayList1 = arrayList2;
                  if (j < i) {
                    arrayList2.add(null);
                    j++;
                    continue;
                  } 
                  break;
                } 
              } 
            } 
            list2 = list1;
            arrayList = arrayList1;
            if (arrayList1 != null) {
              arrayList1.add(fragmentManagerNonConfig);
              arrayList = arrayList1;
              list2 = list1;
            } 
          } 
          i++;
          arrayList1 = (ArrayList<Fragment>)list2;
          arrayList2 = arrayList;
          continue;
        } 
        break;
      } 
    } else {
      list2 = null;
      list1 = list2;
    } 
    if (list2 == null && list1 == null) {
      this.mSavedNonConfig = null;
      return;
    } 
    this.mSavedNonConfig = new FragmentManagerNonConfig(list2, list1);
  }
  
  private void scheduleCommit() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mPostponedTransactions : Ljava/util/ArrayList;
    //   6: astore_3
    //   7: iconst_0
    //   8: istore_2
    //   9: aload_3
    //   10: ifnull -> 88
    //   13: aload_0
    //   14: getfield mPostponedTransactions : Ljava/util/ArrayList;
    //   17: invokevirtual isEmpty : ()Z
    //   20: ifne -> 88
    //   23: iconst_1
    //   24: istore_1
    //   25: goto -> 28
    //   28: aload_0
    //   29: getfield mPendingActions : Ljava/util/ArrayList;
    //   32: ifnull -> 93
    //   35: aload_0
    //   36: getfield mPendingActions : Ljava/util/ArrayList;
    //   39: invokevirtual size : ()I
    //   42: iconst_1
    //   43: if_icmpne -> 93
    //   46: iconst_1
    //   47: istore_2
    //   48: goto -> 93
    //   51: aload_0
    //   52: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   55: getfield mHandler : Landroid/os/Handler;
    //   58: aload_0
    //   59: getfield mExecCommit : Ljava/lang/Runnable;
    //   62: invokevirtual removeCallbacks : (Ljava/lang/Runnable;)V
    //   65: aload_0
    //   66: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   69: getfield mHandler : Landroid/os/Handler;
    //   72: aload_0
    //   73: getfield mExecCommit : Ljava/lang/Runnable;
    //   76: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   79: pop
    //   80: aload_0
    //   81: monitorexit
    //   82: return
    //   83: astore_3
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_3
    //   87: athrow
    //   88: iconst_0
    //   89: istore_1
    //   90: goto -> 28
    //   93: iload_1
    //   94: ifne -> 51
    //   97: iload_2
    //   98: ifeq -> 80
    //   101: goto -> 51
    // Exception table:
    //   from	to	target	type
    //   2	7	83	finally
    //   13	23	83	finally
    //   28	46	83	finally
    //   51	80	83	finally
    //   80	82	83	finally
    //   84	86	83	finally
  }
  
  private void setBackStackIndex(int paramInt, BackStackRecord paramBackStackRecord) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   6: ifnonnull -> 20
    //   9: aload_0
    //   10: new java/util/ArrayList
    //   13: dup
    //   14: invokespecial <init> : ()V
    //   17: putfield mBackStackIndices : Ljava/util/ArrayList;
    //   20: aload_0
    //   21: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   24: invokevirtual size : ()I
    //   27: istore #4
    //   29: iload #4
    //   31: istore_3
    //   32: iload_1
    //   33: iload #4
    //   35: if_icmpge -> 92
    //   38: getstatic android/support/v4/app/FragmentManagerImpl.DEBUG : Z
    //   41: ifeq -> 79
    //   44: new java/lang/StringBuilder
    //   47: dup
    //   48: ldc_w 'Setting back stack index '
    //   51: invokespecial <init> : (Ljava/lang/String;)V
    //   54: astore #5
    //   56: aload #5
    //   58: iload_1
    //   59: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload #5
    //   65: ldc_w ' to '
    //   68: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload #5
    //   74: aload_2
    //   75: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload_0
    //   80: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   83: iload_1
    //   84: aload_2
    //   85: invokevirtual set : (ILjava/lang/Object;)Ljava/lang/Object;
    //   88: pop
    //   89: goto -> 193
    //   92: iload_3
    //   93: iload_1
    //   94: if_icmpge -> 143
    //   97: aload_0
    //   98: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   101: aconst_null
    //   102: invokevirtual add : (Ljava/lang/Object;)Z
    //   105: pop
    //   106: aload_0
    //   107: getfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   110: ifnonnull -> 124
    //   113: aload_0
    //   114: new java/util/ArrayList
    //   117: dup
    //   118: invokespecial <init> : ()V
    //   121: putfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   124: aload_0
    //   125: getfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   128: iload_3
    //   129: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   132: invokevirtual add : (Ljava/lang/Object;)Z
    //   135: pop
    //   136: iload_3
    //   137: iconst_1
    //   138: iadd
    //   139: istore_3
    //   140: goto -> 92
    //   143: getstatic android/support/v4/app/FragmentManagerImpl.DEBUG : Z
    //   146: ifeq -> 184
    //   149: new java/lang/StringBuilder
    //   152: dup
    //   153: ldc_w 'Adding back stack index '
    //   156: invokespecial <init> : (Ljava/lang/String;)V
    //   159: astore #5
    //   161: aload #5
    //   163: iload_1
    //   164: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload #5
    //   170: ldc_w ' with '
    //   173: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload #5
    //   179: aload_2
    //   180: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload_0
    //   185: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   188: aload_2
    //   189: invokevirtual add : (Ljava/lang/Object;)Z
    //   192: pop
    //   193: aload_0
    //   194: monitorexit
    //   195: return
    //   196: astore_2
    //   197: aload_0
    //   198: monitorexit
    //   199: aload_2
    //   200: athrow
    // Exception table:
    //   from	to	target	type
    //   2	20	196	finally
    //   20	29	196	finally
    //   38	79	196	finally
    //   79	89	196	finally
    //   97	124	196	finally
    //   124	136	196	finally
    //   143	184	196	finally
    //   184	193	196	finally
    //   193	195	196	finally
    //   197	199	196	finally
  }
  
  private static void setHWLayerAnimListenerIfAlpha(View paramView, FragmentManagerImpl$AnimationOrAnimator paramFragmentManagerImpl$AnimationOrAnimator) {
    // Byte code:
    //   0: aload_0
    //   1: ifnull -> 211
    //   4: aload_1
    //   5: ifnonnull -> 9
    //   8: return
    //   9: iconst_0
    //   10: istore_3
    //   11: aload_0
    //   12: ifnull -> 149
    //   15: aload_1
    //   16: ifnonnull -> 22
    //   19: goto -> 149
    //   22: getstatic android/os/Build$VERSION.SDK_INT : I
    //   25: bipush #19
    //   27: if_icmplt -> 144
    //   30: aload_0
    //   31: invokevirtual getLayerType : ()I
    //   34: ifne -> 144
    //   37: aload_0
    //   38: invokestatic hasOverlappingRendering : (Landroid/view/View;)Z
    //   41: ifeq -> 144
    //   44: aload_1
    //   45: getfield animation : Landroid/view/animation/Animation;
    //   48: instanceof android/view/animation/AlphaAnimation
    //   51: ifeq -> 60
    //   54: iconst_1
    //   55: istore #4
    //   57: goto -> 134
    //   60: aload_1
    //   61: getfield animation : Landroid/view/animation/Animation;
    //   64: instanceof android/view/animation/AnimationSet
    //   67: ifeq -> 125
    //   70: aload_1
    //   71: getfield animation : Landroid/view/animation/Animation;
    //   74: checkcast android/view/animation/AnimationSet
    //   77: invokevirtual getAnimations : ()Ljava/util/List;
    //   80: astore #5
    //   82: iconst_0
    //   83: istore_2
    //   84: iload_2
    //   85: aload #5
    //   87: invokeinterface size : ()I
    //   92: if_icmpge -> 119
    //   95: aload #5
    //   97: iload_2
    //   98: invokeinterface get : (I)Ljava/lang/Object;
    //   103: instanceof android/view/animation/AlphaAnimation
    //   106: ifeq -> 112
    //   109: goto -> 54
    //   112: iload_2
    //   113: iconst_1
    //   114: iadd
    //   115: istore_2
    //   116: goto -> 84
    //   119: iconst_0
    //   120: istore #4
    //   122: goto -> 134
    //   125: aload_1
    //   126: getfield animator : Landroid/animation/Animator;
    //   129: invokestatic modifiesAlpha : (Landroid/animation/Animator;)Z
    //   132: istore #4
    //   134: iload #4
    //   136: ifeq -> 144
    //   139: iconst_1
    //   140: istore_2
    //   141: goto -> 151
    //   144: iload_3
    //   145: istore_2
    //   146: goto -> 151
    //   149: iload_3
    //   150: istore_2
    //   151: iload_2
    //   152: ifeq -> 210
    //   155: aload_1
    //   156: getfield animator : Landroid/animation/Animator;
    //   159: ifnull -> 178
    //   162: aload_1
    //   163: getfield animator : Landroid/animation/Animator;
    //   166: new android/support/v4/app/FragmentManagerImpl$AnimatorOnHWLayerIfNeededListener
    //   169: dup
    //   170: aload_0
    //   171: invokespecial <init> : (Landroid/view/View;)V
    //   174: invokevirtual addListener : (Landroid/animation/Animator$AnimatorListener;)V
    //   177: return
    //   178: aload_1
    //   179: getfield animation : Landroid/view/animation/Animation;
    //   182: invokestatic getAnimationListener : (Landroid/view/animation/Animation;)Landroid/view/animation/Animation$AnimationListener;
    //   185: astore #5
    //   187: aload_0
    //   188: iconst_2
    //   189: aconst_null
    //   190: invokevirtual setLayerType : (ILandroid/graphics/Paint;)V
    //   193: aload_1
    //   194: getfield animation : Landroid/view/animation/Animation;
    //   197: new android/support/v4/app/FragmentManagerImpl$AnimateOnHWLayerIfNeededListener
    //   200: dup
    //   201: aload_0
    //   202: aload #5
    //   204: invokespecial <init> : (Landroid/view/View;Landroid/view/animation/Animation$AnimationListener;)V
    //   207: invokevirtual setAnimationListener : (Landroid/view/animation/Animation$AnimationListener;)V
    //   210: return
    //   211: return
  }
  
  static void setRetaining(FragmentManagerNonConfig paramFragmentManagerNonConfig) {
    if (paramFragmentManagerNonConfig == null)
      return; 
    List list2 = paramFragmentManagerNonConfig.mFragments;
    if (list2 != null) {
      Iterator iterator = list2.iterator();
      while (iterator.hasNext())
        ((Fragment)iterator.next()).mRetaining = true; 
    } 
    List list1 = paramFragmentManagerNonConfig.mChildNonConfigs;
    if (list1 != null) {
      Iterator<FragmentManagerNonConfig> iterator = list1.iterator();
      while (iterator.hasNext())
        setRetaining(iterator.next()); 
    } 
  }
  
  public static void showFragment(Fragment paramFragment) {
    if (DEBUG)
      (new StringBuilder("show: ")).append(paramFragment); 
    if (paramFragment.mHidden) {
      paramFragment.mHidden = false;
      paramFragment.mHiddenChanged ^= 0x1;
    } 
  }
  
  private void startPendingDeferredFragments() {
    if (this.mActive == null)
      return; 
    for (int i = 0; i < this.mActive.size(); i++) {
      Fragment fragment = (Fragment)this.mActive.valueAt(i);
      if (fragment != null && fragment.mDeferStart)
        if (this.mExecutingActions) {
          this.mHavePendingDeferredStart = true;
        } else {
          fragment.mDeferStart = false;
          moveToState(fragment, this.mCurState, 0, 0, false);
        }  
    } 
  }
  
  private void throwException(RuntimeException paramRuntimeException) {
    Log.e("FragmentManager", paramRuntimeException.getMessage());
    Log.e("FragmentManager", "Activity state:");
    PrintWriter printWriter = new PrintWriter((Writer)new LogWriter());
    if (this.mHost != null) {
      try {
        this.mHost.onDump("  ", null, printWriter, new String[0]);
      } catch (Exception exception) {
        Log.e("FragmentManager", "Failed dumping state", exception);
      } 
    } else {
      try {
        dump("  ", null, (PrintWriter)exception, new String[0]);
      } catch (Exception exception1) {
        Log.e("FragmentManager", "Failed dumping state", exception1);
      } 
    } 
    throw paramRuntimeException;
  }
  
  public final void addFragment(Fragment paramFragment, boolean paramBoolean) {
    if (DEBUG)
      (new StringBuilder("add: ")).append(paramFragment); 
    makeActive(paramFragment);
    if (!paramFragment.mDetached)
      if (!this.mAdded.contains(paramFragment)) {
        synchronized (this.mAdded) {
          this.mAdded.add(paramFragment);
          paramFragment.mAdded = true;
          paramFragment.mRemoving = false;
          if (paramFragment.mView == null)
            paramFragment.mHiddenChanged = false; 
          if (paramFragment.mHasMenu && paramFragment.mMenuVisible)
            this.mNeedMenuInvalidate = true; 
          if (paramBoolean) {
            moveToState(paramFragment);
            return;
          } 
        } 
      } else {
        StringBuilder stringBuilder = new StringBuilder("Fragment already added: ");
        stringBuilder.append(paramFragment);
        throw new IllegalStateException(stringBuilder.toString());
      }  
  }
  
  public final int allocBackStackIndex(BackStackRecord paramBackStackRecord) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   6: ifnull -> 96
    //   9: aload_0
    //   10: getfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   13: invokevirtual size : ()I
    //   16: ifgt -> 22
    //   19: goto -> 96
    //   22: aload_0
    //   23: getfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   26: aload_0
    //   27: getfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   30: invokevirtual size : ()I
    //   33: iconst_1
    //   34: isub
    //   35: invokevirtual remove : (I)Ljava/lang/Object;
    //   38: checkcast java/lang/Integer
    //   41: invokevirtual intValue : ()I
    //   44: istore_2
    //   45: getstatic android/support/v4/app/FragmentManagerImpl.DEBUG : Z
    //   48: ifeq -> 82
    //   51: new java/lang/StringBuilder
    //   54: dup
    //   55: ldc_w 'Adding back stack index '
    //   58: invokespecial <init> : (Ljava/lang/String;)V
    //   61: astore_3
    //   62: aload_3
    //   63: iload_2
    //   64: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload_3
    //   69: ldc_w ' with '
    //   72: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload_3
    //   77: aload_1
    //   78: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload_0
    //   83: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   86: iload_2
    //   87: aload_1
    //   88: invokevirtual set : (ILjava/lang/Object;)Ljava/lang/Object;
    //   91: pop
    //   92: aload_0
    //   93: monitorexit
    //   94: iload_2
    //   95: ireturn
    //   96: aload_0
    //   97: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   100: ifnonnull -> 114
    //   103: aload_0
    //   104: new java/util/ArrayList
    //   107: dup
    //   108: invokespecial <init> : ()V
    //   111: putfield mBackStackIndices : Ljava/util/ArrayList;
    //   114: aload_0
    //   115: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   118: invokevirtual size : ()I
    //   121: istore_2
    //   122: getstatic android/support/v4/app/FragmentManagerImpl.DEBUG : Z
    //   125: ifeq -> 159
    //   128: new java/lang/StringBuilder
    //   131: dup
    //   132: ldc_w 'Setting back stack index '
    //   135: invokespecial <init> : (Ljava/lang/String;)V
    //   138: astore_3
    //   139: aload_3
    //   140: iload_2
    //   141: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload_3
    //   146: ldc_w ' to '
    //   149: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload_3
    //   154: aload_1
    //   155: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload_0
    //   160: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   163: aload_1
    //   164: invokevirtual add : (Ljava/lang/Object;)Z
    //   167: pop
    //   168: aload_0
    //   169: monitorexit
    //   170: iload_2
    //   171: ireturn
    //   172: astore_1
    //   173: aload_0
    //   174: monitorexit
    //   175: aload_1
    //   176: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	172	finally
    //   22	82	172	finally
    //   82	94	172	finally
    //   96	114	172	finally
    //   114	159	172	finally
    //   159	170	172	finally
    //   173	175	172	finally
  }
  
  public final void attachController(FragmentHostCallback paramFragmentHostCallback, FragmentContainer paramFragmentContainer, Fragment paramFragment) {
    if (this.mHost == null) {
      this.mHost = paramFragmentHostCallback;
      this.mContainer = paramFragmentContainer;
      this.mParent = paramFragment;
      return;
    } 
    throw new IllegalStateException("Already attached");
  }
  
  public final void attachFragment(Fragment paramFragment) {
    if (DEBUG)
      (new StringBuilder("attach: ")).append(paramFragment); 
    if (paramFragment.mDetached) {
      paramFragment.mDetached = false;
      if (!paramFragment.mAdded)
        if (!this.mAdded.contains(paramFragment)) {
          if (DEBUG)
            (new StringBuilder("add from attach: ")).append(paramFragment); 
          synchronized (this.mAdded) {
            this.mAdded.add(paramFragment);
            paramFragment.mAdded = true;
            if (paramFragment.mHasMenu && paramFragment.mMenuVisible) {
              this.mNeedMenuInvalidate = true;
              return;
            } 
          } 
        } else {
          StringBuilder stringBuilder = new StringBuilder("Fragment already added: ");
          stringBuilder.append(paramFragment);
          throw new IllegalStateException(stringBuilder.toString());
        }  
    } 
  }
  
  public final FragmentTransaction beginTransaction() {
    return new BackStackRecord(this);
  }
  
  public final void detachFragment(Fragment paramFragment) {
    if (DEBUG)
      (new StringBuilder("detach: ")).append(paramFragment); 
    if (!paramFragment.mDetached) {
      paramFragment.mDetached = true;
      if (paramFragment.mAdded) {
        if (DEBUG)
          (new StringBuilder("remove from detach: ")).append(paramFragment); 
        synchronized (this.mAdded) {
          this.mAdded.remove(paramFragment);
          if (paramFragment.mHasMenu && paramFragment.mMenuVisible)
            this.mNeedMenuInvalidate = true; 
          paramFragment.mAdded = false;
          return;
        } 
      } 
    } 
  }
  
  public final void dispatchActivityCreated() {
    this.mStateSaved = false;
    dispatchStateChange(2);
  }
  
  public final void dispatchConfigurationChanged(Configuration paramConfiguration) {
    for (int i = 0; i < this.mAdded.size(); i++) {
      Fragment fragment = this.mAdded.get(i);
      if (fragment != null) {
        fragment.onConfigurationChanged(paramConfiguration);
        if (fragment.mChildFragmentManager != null)
          fragment.mChildFragmentManager.dispatchConfigurationChanged(paramConfiguration); 
      } 
    } 
  }
  
  public final boolean dispatchContextItemSelected(MenuItem paramMenuItem) {
    if (this.mCurState <= 0)
      return false; 
    for (int i = 0; i < this.mAdded.size(); i++) {
      Fragment fragment = this.mAdded.get(i);
      if (fragment != null) {
        boolean bool;
        if (!fragment.mHidden && fragment.mChildFragmentManager != null && fragment.mChildFragmentManager.dispatchContextItemSelected(paramMenuItem)) {
          bool = true;
        } else {
          bool = false;
        } 
        if (bool)
          return true; 
      } 
    } 
    return false;
  }
  
  public final void dispatchCreate() {
    this.mStateSaved = false;
    dispatchStateChange(1);
  }
  
  public final boolean dispatchCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater) {
    int i = this.mCurState;
    boolean bool1 = false;
    if (i <= 0)
      return false; 
    ArrayList<Fragment> arrayList = null;
    int j = 0;
    boolean bool2;
    for (bool2 = false; j < this.mAdded.size(); bool2 = bool) {
      Fragment fragment = this.mAdded.get(j);
      ArrayList<Fragment> arrayList1 = arrayList;
      boolean bool = bool2;
      if (fragment != null) {
        boolean bool3;
        if (!fragment.mHidden) {
          if (fragment.mHasMenu && fragment.mMenuVisible) {
            i = 1;
          } else {
            i = 0;
          } 
          bool3 = i;
          if (fragment.mChildFragmentManager != null)
            boolean bool4 = i | fragment.mChildFragmentManager.dispatchCreateOptionsMenu(paramMenu, paramMenuInflater); 
        } else {
          bool3 = false;
        } 
        arrayList1 = arrayList;
        bool = bool2;
        if (bool3) {
          arrayList1 = arrayList;
          if (arrayList == null)
            arrayList1 = new ArrayList(); 
          arrayList1.add(fragment);
          bool = true;
        } 
      } 
      j++;
      arrayList = arrayList1;
    } 
    if (this.mCreatedMenus != null)
      for (i = bool1; i < this.mCreatedMenus.size(); i++) {
        Fragment fragment = this.mCreatedMenus.get(i);
        if (arrayList == null || !arrayList.contains(fragment))
          Fragment.onDestroyOptionsMenu(); 
      }  
    this.mCreatedMenus = arrayList;
    return bool2;
  }
  
  public final void dispatchDestroy() {
    this.mDestroyed = true;
    execPendingActions();
    dispatchStateChange(0);
    this.mHost = null;
    this.mContainer = null;
    this.mParent = null;
  }
  
  public final void dispatchLowMemory() {
    for (int i = 0; i < this.mAdded.size(); i++) {
      Fragment fragment = this.mAdded.get(i);
      if (fragment != null) {
        fragment.onLowMemory();
        if (fragment.mChildFragmentManager != null)
          fragment.mChildFragmentManager.dispatchLowMemory(); 
      } 
    } 
  }
  
  public final void dispatchMultiWindowModeChanged(boolean paramBoolean) {
    for (int i = this.mAdded.size() - 1; i >= 0; i--) {
      Fragment fragment = this.mAdded.get(i);
      if (fragment != null && fragment.mChildFragmentManager != null)
        fragment.mChildFragmentManager.dispatchMultiWindowModeChanged(paramBoolean); 
    } 
  }
  
  public final boolean dispatchOptionsItemSelected(MenuItem paramMenuItem) {
    // Byte code:
    //   0: aload_0
    //   1: getfield mCurState : I
    //   4: ifgt -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: iconst_0
    //   10: istore_2
    //   11: iload_2
    //   12: aload_0
    //   13: getfield mAdded : Ljava/util/ArrayList;
    //   16: invokevirtual size : ()I
    //   19: if_icmpge -> 103
    //   22: aload_0
    //   23: getfield mAdded : Ljava/util/ArrayList;
    //   26: iload_2
    //   27: invokevirtual get : (I)Ljava/lang/Object;
    //   30: checkcast android/support/v4/app/Fragment
    //   33: astore #5
    //   35: aload #5
    //   37: ifnull -> 96
    //   40: aload #5
    //   42: getfield mHidden : Z
    //   45: ifne -> 88
    //   48: aload #5
    //   50: getfield mHasMenu : Z
    //   53: ifeq -> 63
    //   56: aload #5
    //   58: getfield mMenuVisible : Z
    //   61: istore #4
    //   63: aload #5
    //   65: getfield mChildFragmentManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   68: ifnull -> 88
    //   71: aload #5
    //   73: getfield mChildFragmentManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   76: aload_1
    //   77: invokevirtual dispatchOptionsItemSelected : (Landroid/view/MenuItem;)Z
    //   80: ifeq -> 88
    //   83: iconst_1
    //   84: istore_3
    //   85: goto -> 90
    //   88: iconst_0
    //   89: istore_3
    //   90: iload_3
    //   91: ifeq -> 96
    //   94: iconst_1
    //   95: ireturn
    //   96: iload_2
    //   97: iconst_1
    //   98: iadd
    //   99: istore_2
    //   100: goto -> 11
    //   103: iconst_0
    //   104: ireturn
  }
  
  public final void dispatchOptionsMenuClosed(Menu paramMenu) {
    if (this.mCurState <= 0)
      return; 
    for (int i = 0; i < this.mAdded.size(); i++) {
      Fragment fragment = this.mAdded.get(i);
      if (fragment != null && !fragment.mHidden && fragment.mChildFragmentManager != null)
        fragment.mChildFragmentManager.dispatchOptionsMenuClosed(paramMenu); 
    } 
  }
  
  public final void dispatchPictureInPictureModeChanged(boolean paramBoolean) {
    for (int i = this.mAdded.size() - 1; i >= 0; i--) {
      Fragment fragment = this.mAdded.get(i);
      if (fragment != null && fragment.mChildFragmentManager != null)
        fragment.mChildFragmentManager.dispatchPictureInPictureModeChanged(paramBoolean); 
    } 
  }
  
  public final boolean dispatchPrepareOptionsMenu(Menu paramMenu) {
    if (this.mCurState <= 0)
      return false; 
    int i = 0;
    boolean bool;
    for (bool = false; i < this.mAdded.size(); bool = bool1) {
      Fragment fragment = this.mAdded.get(i);
      boolean bool1 = bool;
      if (fragment != null) {
        boolean bool2;
        if (!fragment.mHidden) {
          if (fragment.mHasMenu && fragment.mMenuVisible) {
            bool2 = true;
          } else {
            bool2 = false;
          } 
          if (fragment.mChildFragmentManager != null)
            bool2 = fragment.mChildFragmentManager.dispatchPrepareOptionsMenu(paramMenu) | bool2; 
        } else {
          bool2 = false;
        } 
        bool1 = bool;
        if (bool2)
          bool1 = true; 
      } 
      i++;
    } 
    return bool;
  }
  
  public final void dispatchResume() {
    this.mStateSaved = false;
    dispatchStateChange(5);
  }
  
  public final void dispatchStart() {
    this.mStateSaved = false;
    dispatchStateChange(4);
  }
  
  final void dispatchStateChange(int paramInt) {
    try {
      this.mExecutingActions = true;
      moveToState(paramInt, false);
      this.mExecutingActions = false;
      return;
    } finally {
      this.mExecutingActions = false;
    } 
  }
  
  public final void dispatchStop() {
    this.mStateSaved = true;
    dispatchStateChange(3);
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
    // Byte code:
    //   0: new java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #8
    //   9: aload #8
    //   11: aload_1
    //   12: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: pop
    //   16: aload #8
    //   18: ldc_w '    '
    //   21: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload #8
    //   27: invokevirtual toString : ()Ljava/lang/String;
    //   30: astore #8
    //   32: aload_0
    //   33: getfield mActive : Landroid/util/SparseArray;
    //   36: astore #9
    //   38: iconst_0
    //   39: istore #6
    //   41: aload #9
    //   43: ifnull -> 170
    //   46: aload_0
    //   47: getfield mActive : Landroid/util/SparseArray;
    //   50: invokevirtual size : ()I
    //   53: istore #7
    //   55: iload #7
    //   57: ifle -> 170
    //   60: aload_3
    //   61: aload_1
    //   62: invokevirtual print : (Ljava/lang/String;)V
    //   65: aload_3
    //   66: ldc_w 'Active Fragments in '
    //   69: invokevirtual print : (Ljava/lang/String;)V
    //   72: aload_3
    //   73: aload_0
    //   74: invokestatic identityHashCode : (Ljava/lang/Object;)I
    //   77: invokestatic toHexString : (I)Ljava/lang/String;
    //   80: invokevirtual print : (Ljava/lang/String;)V
    //   83: aload_3
    //   84: ldc_w ':'
    //   87: invokevirtual println : (Ljava/lang/String;)V
    //   90: iconst_0
    //   91: istore #5
    //   93: iload #5
    //   95: iload #7
    //   97: if_icmpge -> 170
    //   100: aload_0
    //   101: getfield mActive : Landroid/util/SparseArray;
    //   104: iload #5
    //   106: invokevirtual valueAt : (I)Ljava/lang/Object;
    //   109: checkcast android/support/v4/app/Fragment
    //   112: astore #9
    //   114: aload_3
    //   115: aload_1
    //   116: invokevirtual print : (Ljava/lang/String;)V
    //   119: aload_3
    //   120: ldc_w '  #'
    //   123: invokevirtual print : (Ljava/lang/String;)V
    //   126: aload_3
    //   127: iload #5
    //   129: invokevirtual print : (I)V
    //   132: aload_3
    //   133: ldc_w ': '
    //   136: invokevirtual print : (Ljava/lang/String;)V
    //   139: aload_3
    //   140: aload #9
    //   142: invokevirtual println : (Ljava/lang/Object;)V
    //   145: aload #9
    //   147: ifnull -> 161
    //   150: aload #9
    //   152: aload #8
    //   154: aload_2
    //   155: aload_3
    //   156: aload #4
    //   158: invokevirtual dump : (Ljava/lang/String;Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V
    //   161: iload #5
    //   163: iconst_1
    //   164: iadd
    //   165: istore #5
    //   167: goto -> 93
    //   170: aload_0
    //   171: getfield mAdded : Ljava/util/ArrayList;
    //   174: invokevirtual size : ()I
    //   177: istore #7
    //   179: iload #7
    //   181: ifle -> 261
    //   184: aload_3
    //   185: aload_1
    //   186: invokevirtual print : (Ljava/lang/String;)V
    //   189: aload_3
    //   190: ldc_w 'Added Fragments:'
    //   193: invokevirtual println : (Ljava/lang/String;)V
    //   196: iconst_0
    //   197: istore #5
    //   199: iload #5
    //   201: iload #7
    //   203: if_icmpge -> 261
    //   206: aload_0
    //   207: getfield mAdded : Ljava/util/ArrayList;
    //   210: iload #5
    //   212: invokevirtual get : (I)Ljava/lang/Object;
    //   215: checkcast android/support/v4/app/Fragment
    //   218: astore_2
    //   219: aload_3
    //   220: aload_1
    //   221: invokevirtual print : (Ljava/lang/String;)V
    //   224: aload_3
    //   225: ldc_w '  #'
    //   228: invokevirtual print : (Ljava/lang/String;)V
    //   231: aload_3
    //   232: iload #5
    //   234: invokevirtual print : (I)V
    //   237: aload_3
    //   238: ldc_w ': '
    //   241: invokevirtual print : (Ljava/lang/String;)V
    //   244: aload_3
    //   245: aload_2
    //   246: invokevirtual toString : ()Ljava/lang/String;
    //   249: invokevirtual println : (Ljava/lang/String;)V
    //   252: iload #5
    //   254: iconst_1
    //   255: iadd
    //   256: istore #5
    //   258: goto -> 199
    //   261: aload_0
    //   262: getfield mCreatedMenus : Ljava/util/ArrayList;
    //   265: ifnull -> 359
    //   268: aload_0
    //   269: getfield mCreatedMenus : Ljava/util/ArrayList;
    //   272: invokevirtual size : ()I
    //   275: istore #7
    //   277: iload #7
    //   279: ifle -> 359
    //   282: aload_3
    //   283: aload_1
    //   284: invokevirtual print : (Ljava/lang/String;)V
    //   287: aload_3
    //   288: ldc_w 'Fragments Created Menus:'
    //   291: invokevirtual println : (Ljava/lang/String;)V
    //   294: iconst_0
    //   295: istore #5
    //   297: iload #5
    //   299: iload #7
    //   301: if_icmpge -> 359
    //   304: aload_0
    //   305: getfield mCreatedMenus : Ljava/util/ArrayList;
    //   308: iload #5
    //   310: invokevirtual get : (I)Ljava/lang/Object;
    //   313: checkcast android/support/v4/app/Fragment
    //   316: astore_2
    //   317: aload_3
    //   318: aload_1
    //   319: invokevirtual print : (Ljava/lang/String;)V
    //   322: aload_3
    //   323: ldc_w '  #'
    //   326: invokevirtual print : (Ljava/lang/String;)V
    //   329: aload_3
    //   330: iload #5
    //   332: invokevirtual print : (I)V
    //   335: aload_3
    //   336: ldc_w ': '
    //   339: invokevirtual print : (Ljava/lang/String;)V
    //   342: aload_3
    //   343: aload_2
    //   344: invokevirtual toString : ()Ljava/lang/String;
    //   347: invokevirtual println : (Ljava/lang/String;)V
    //   350: iload #5
    //   352: iconst_1
    //   353: iadd
    //   354: istore #5
    //   356: goto -> 297
    //   359: aload_0
    //   360: getfield mBackStack : Ljava/util/ArrayList;
    //   363: ifnull -> 464
    //   366: aload_0
    //   367: getfield mBackStack : Ljava/util/ArrayList;
    //   370: invokevirtual size : ()I
    //   373: istore #7
    //   375: iload #7
    //   377: ifle -> 464
    //   380: aload_3
    //   381: aload_1
    //   382: invokevirtual print : (Ljava/lang/String;)V
    //   385: aload_3
    //   386: ldc_w 'Back Stack:'
    //   389: invokevirtual println : (Ljava/lang/String;)V
    //   392: iconst_0
    //   393: istore #5
    //   395: iload #5
    //   397: iload #7
    //   399: if_icmpge -> 464
    //   402: aload_0
    //   403: getfield mBackStack : Ljava/util/ArrayList;
    //   406: iload #5
    //   408: invokevirtual get : (I)Ljava/lang/Object;
    //   411: checkcast android/support/v4/app/BackStackRecord
    //   414: astore_2
    //   415: aload_3
    //   416: aload_1
    //   417: invokevirtual print : (Ljava/lang/String;)V
    //   420: aload_3
    //   421: ldc_w '  #'
    //   424: invokevirtual print : (Ljava/lang/String;)V
    //   427: aload_3
    //   428: iload #5
    //   430: invokevirtual print : (I)V
    //   433: aload_3
    //   434: ldc_w ': '
    //   437: invokevirtual print : (Ljava/lang/String;)V
    //   440: aload_3
    //   441: aload_2
    //   442: invokevirtual toString : ()Ljava/lang/String;
    //   445: invokevirtual println : (Ljava/lang/String;)V
    //   448: aload_2
    //   449: aload #8
    //   451: aload_3
    //   452: invokevirtual dump$ec96877 : (Ljava/lang/String;Ljava/io/PrintWriter;)V
    //   455: iload #5
    //   457: iconst_1
    //   458: iadd
    //   459: istore #5
    //   461: goto -> 395
    //   464: aload_0
    //   465: monitorenter
    //   466: aload_0
    //   467: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   470: ifnull -> 561
    //   473: aload_0
    //   474: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   477: invokevirtual size : ()I
    //   480: istore #7
    //   482: iload #7
    //   484: ifle -> 561
    //   487: aload_3
    //   488: aload_1
    //   489: invokevirtual print : (Ljava/lang/String;)V
    //   492: aload_3
    //   493: ldc_w 'Back Stack Indices:'
    //   496: invokevirtual println : (Ljava/lang/String;)V
    //   499: iconst_0
    //   500: istore #5
    //   502: iload #5
    //   504: iload #7
    //   506: if_icmpge -> 561
    //   509: aload_0
    //   510: getfield mBackStackIndices : Ljava/util/ArrayList;
    //   513: iload #5
    //   515: invokevirtual get : (I)Ljava/lang/Object;
    //   518: checkcast android/support/v4/app/BackStackRecord
    //   521: astore_2
    //   522: aload_3
    //   523: aload_1
    //   524: invokevirtual print : (Ljava/lang/String;)V
    //   527: aload_3
    //   528: ldc_w '  #'
    //   531: invokevirtual print : (Ljava/lang/String;)V
    //   534: aload_3
    //   535: iload #5
    //   537: invokevirtual print : (I)V
    //   540: aload_3
    //   541: ldc_w ': '
    //   544: invokevirtual print : (Ljava/lang/String;)V
    //   547: aload_3
    //   548: aload_2
    //   549: invokevirtual println : (Ljava/lang/Object;)V
    //   552: iload #5
    //   554: iconst_1
    //   555: iadd
    //   556: istore #5
    //   558: goto -> 502
    //   561: aload_0
    //   562: getfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   565: ifnull -> 604
    //   568: aload_0
    //   569: getfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   572: invokevirtual size : ()I
    //   575: ifle -> 604
    //   578: aload_3
    //   579: aload_1
    //   580: invokevirtual print : (Ljava/lang/String;)V
    //   583: aload_3
    //   584: ldc_w 'mAvailBackStackIndices: '
    //   587: invokevirtual print : (Ljava/lang/String;)V
    //   590: aload_3
    //   591: aload_0
    //   592: getfield mAvailBackStackIndices : Ljava/util/ArrayList;
    //   595: invokevirtual toArray : ()[Ljava/lang/Object;
    //   598: invokestatic toString : ([Ljava/lang/Object;)Ljava/lang/String;
    //   601: invokevirtual println : (Ljava/lang/String;)V
    //   604: aload_0
    //   605: monitorexit
    //   606: aload_0
    //   607: getfield mPendingActions : Ljava/util/ArrayList;
    //   610: ifnull -> 702
    //   613: aload_0
    //   614: getfield mPendingActions : Ljava/util/ArrayList;
    //   617: invokevirtual size : ()I
    //   620: istore #7
    //   622: iload #7
    //   624: ifle -> 702
    //   627: aload_3
    //   628: aload_1
    //   629: invokevirtual print : (Ljava/lang/String;)V
    //   632: aload_3
    //   633: ldc_w 'Pending Actions:'
    //   636: invokevirtual println : (Ljava/lang/String;)V
    //   639: iload #6
    //   641: istore #5
    //   643: iload #5
    //   645: iload #7
    //   647: if_icmpge -> 702
    //   650: aload_0
    //   651: getfield mPendingActions : Ljava/util/ArrayList;
    //   654: iload #5
    //   656: invokevirtual get : (I)Ljava/lang/Object;
    //   659: checkcast android/support/v4/app/FragmentManagerImpl$OpGenerator
    //   662: astore_2
    //   663: aload_3
    //   664: aload_1
    //   665: invokevirtual print : (Ljava/lang/String;)V
    //   668: aload_3
    //   669: ldc_w '  #'
    //   672: invokevirtual print : (Ljava/lang/String;)V
    //   675: aload_3
    //   676: iload #5
    //   678: invokevirtual print : (I)V
    //   681: aload_3
    //   682: ldc_w ': '
    //   685: invokevirtual print : (Ljava/lang/String;)V
    //   688: aload_3
    //   689: aload_2
    //   690: invokevirtual println : (Ljava/lang/Object;)V
    //   693: iload #5
    //   695: iconst_1
    //   696: iadd
    //   697: istore #5
    //   699: goto -> 643
    //   702: aload_3
    //   703: aload_1
    //   704: invokevirtual print : (Ljava/lang/String;)V
    //   707: aload_3
    //   708: ldc_w 'FragmentManager misc state:'
    //   711: invokevirtual println : (Ljava/lang/String;)V
    //   714: aload_3
    //   715: aload_1
    //   716: invokevirtual print : (Ljava/lang/String;)V
    //   719: aload_3
    //   720: ldc_w '  mHost='
    //   723: invokevirtual print : (Ljava/lang/String;)V
    //   726: aload_3
    //   727: aload_0
    //   728: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   731: invokevirtual println : (Ljava/lang/Object;)V
    //   734: aload_3
    //   735: aload_1
    //   736: invokevirtual print : (Ljava/lang/String;)V
    //   739: aload_3
    //   740: ldc_w '  mContainer='
    //   743: invokevirtual print : (Ljava/lang/String;)V
    //   746: aload_3
    //   747: aload_0
    //   748: getfield mContainer : Landroid/support/v4/app/FragmentContainer;
    //   751: invokevirtual println : (Ljava/lang/Object;)V
    //   754: aload_0
    //   755: getfield mParent : Landroid/support/v4/app/Fragment;
    //   758: ifnull -> 781
    //   761: aload_3
    //   762: aload_1
    //   763: invokevirtual print : (Ljava/lang/String;)V
    //   766: aload_3
    //   767: ldc_w '  mParent='
    //   770: invokevirtual print : (Ljava/lang/String;)V
    //   773: aload_3
    //   774: aload_0
    //   775: getfield mParent : Landroid/support/v4/app/Fragment;
    //   778: invokevirtual println : (Ljava/lang/Object;)V
    //   781: aload_3
    //   782: aload_1
    //   783: invokevirtual print : (Ljava/lang/String;)V
    //   786: aload_3
    //   787: ldc_w '  mCurState='
    //   790: invokevirtual print : (Ljava/lang/String;)V
    //   793: aload_3
    //   794: aload_0
    //   795: getfield mCurState : I
    //   798: invokevirtual print : (I)V
    //   801: aload_3
    //   802: ldc_w ' mStateSaved='
    //   805: invokevirtual print : (Ljava/lang/String;)V
    //   808: aload_3
    //   809: aload_0
    //   810: getfield mStateSaved : Z
    //   813: invokevirtual print : (Z)V
    //   816: aload_3
    //   817: ldc_w ' mDestroyed='
    //   820: invokevirtual print : (Ljava/lang/String;)V
    //   823: aload_3
    //   824: aload_0
    //   825: getfield mDestroyed : Z
    //   828: invokevirtual println : (Z)V
    //   831: aload_0
    //   832: getfield mNeedMenuInvalidate : Z
    //   835: ifeq -> 858
    //   838: aload_3
    //   839: aload_1
    //   840: invokevirtual print : (Ljava/lang/String;)V
    //   843: aload_3
    //   844: ldc_w '  mNeedMenuInvalidate='
    //   847: invokevirtual print : (Ljava/lang/String;)V
    //   850: aload_3
    //   851: aload_0
    //   852: getfield mNeedMenuInvalidate : Z
    //   855: invokevirtual println : (Z)V
    //   858: aload_0
    //   859: getfield mNoTransactionsBecause : Ljava/lang/String;
    //   862: ifnull -> 885
    //   865: aload_3
    //   866: aload_1
    //   867: invokevirtual print : (Ljava/lang/String;)V
    //   870: aload_3
    //   871: ldc_w '  mNoTransactionsBecause='
    //   874: invokevirtual print : (Ljava/lang/String;)V
    //   877: aload_3
    //   878: aload_0
    //   879: getfield mNoTransactionsBecause : Ljava/lang/String;
    //   882: invokevirtual println : (Ljava/lang/String;)V
    //   885: return
    //   886: astore_1
    //   887: aload_0
    //   888: monitorexit
    //   889: aload_1
    //   890: athrow
    // Exception table:
    //   from	to	target	type
    //   466	482	886	finally
    //   487	499	886	finally
    //   509	552	886	finally
    //   561	604	886	finally
    //   604	606	886	finally
    //   887	889	886	finally
  }
  
  public final void enqueueAction(FragmentManagerImpl$OpGenerator paramFragmentManagerImpl$OpGenerator, boolean paramBoolean) {
    // Byte code:
    //   0: iload_2
    //   1: ifne -> 8
    //   4: aload_0
    //   5: invokespecial checkStateLoss : ()V
    //   8: aload_0
    //   9: monitorenter
    //   10: aload_0
    //   11: getfield mDestroyed : Z
    //   14: ifne -> 61
    //   17: aload_0
    //   18: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   21: ifnonnull -> 27
    //   24: goto -> 61
    //   27: aload_0
    //   28: getfield mPendingActions : Ljava/util/ArrayList;
    //   31: ifnonnull -> 45
    //   34: aload_0
    //   35: new java/util/ArrayList
    //   38: dup
    //   39: invokespecial <init> : ()V
    //   42: putfield mPendingActions : Ljava/util/ArrayList;
    //   45: aload_0
    //   46: getfield mPendingActions : Ljava/util/ArrayList;
    //   49: aload_1
    //   50: invokevirtual add : (Ljava/lang/Object;)Z
    //   53: pop
    //   54: aload_0
    //   55: invokespecial scheduleCommit : ()V
    //   58: aload_0
    //   59: monitorexit
    //   60: return
    //   61: iload_2
    //   62: ifeq -> 68
    //   65: aload_0
    //   66: monitorexit
    //   67: return
    //   68: new java/lang/IllegalStateException
    //   71: dup
    //   72: ldc_w 'Activity has been destroyed'
    //   75: invokespecial <init> : (Ljava/lang/String;)V
    //   78: athrow
    //   79: astore_1
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    // Exception table:
    //   from	to	target	type
    //   10	24	79	finally
    //   27	45	79	finally
    //   45	60	79	finally
    //   65	67	79	finally
    //   68	79	79	finally
    //   80	82	79	finally
  }
  
  public final boolean execPendingActions() {
    ensureExecReady(true);
    boolean bool = false;
    while (generateOpsForPendingActions(this.mTmpRecords, this.mTmpIsPop)) {
      this.mExecutingActions = true;
      try {
        removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
        cleanupExec();
      } finally {
        cleanupExec();
      } 
    } 
    doPendingDeferredStart();
    burpActive();
    return bool;
  }
  
  public final Fragment findFragmentByTag(String paramString) {
    if (paramString != null)
      for (int i = this.mAdded.size() - 1; i >= 0; i--) {
        Fragment fragment = this.mAdded.get(i);
        if (fragment != null && paramString.equals(fragment.mTag))
          return fragment; 
      }  
    if (this.mActive != null && paramString != null)
      for (int i = this.mActive.size() - 1; i >= 0; i--) {
        Fragment fragment = (Fragment)this.mActive.valueAt(i);
        if (fragment != null && paramString.equals(fragment.mTag))
          return fragment; 
      }  
    return null;
  }
  
  public final Fragment findFragmentByWho(String paramString) {
    if (this.mActive != null && paramString != null)
      for (int i = this.mActive.size() - 1; i >= 0; i--) {
        Fragment fragment = (Fragment)this.mActive.valueAt(i);
        if (fragment != null) {
          if (!paramString.equals(fragment.mWho))
            if (fragment.mChildFragmentManager != null) {
              fragment = fragment.mChildFragmentManager.findFragmentByWho(paramString);
            } else {
              fragment = null;
            }  
          if (fragment != null)
            return fragment; 
        } 
      }  
    return null;
  }
  
  public final List getFragments() {
    if (this.mAdded.isEmpty())
      return Collections.EMPTY_LIST; 
    synchronized (this.mAdded) {
      return (List)this.mAdded.clone();
    } 
  }
  
  public final boolean isStateSaved() {
    return this.mStateSaved;
  }
  
  final void makeActive(Fragment paramFragment) {
    if (paramFragment.mIndex >= 0)
      return; 
    int i = this.mNextFragmentIndex;
    this.mNextFragmentIndex = i + 1;
    paramFragment.setIndex(i, this.mParent);
    if (this.mActive == null)
      this.mActive = new SparseArray(); 
    this.mActive.put(paramFragment.mIndex, paramFragment);
    if (DEBUG)
      (new StringBuilder("Allocated fragment index ")).append(paramFragment); 
  }
  
  final void moveFragmentToExpectedState(Fragment paramFragment) {
    if (paramFragment == null)
      return; 
    int j = this.mCurState;
    int i = j;
    if (paramFragment.mRemoving)
      if (paramFragment.isInBackStack()) {
        i = Math.min(j, 1);
      } else {
        i = Math.min(j, 0);
      }  
    moveToState(paramFragment, i, paramFragment.getNextTransition(), paramFragment.getNextTransitionStyle(), false);
    if (paramFragment.mView != null) {
      ViewGroup viewGroup = paramFragment.mContainer;
      View view = paramFragment.mView;
      Fragment fragment = null;
      if (viewGroup != null && view != null)
        for (i = this.mAdded.indexOf(paramFragment) - 1; i >= 0; i--) {
          Fragment fragment1 = this.mAdded.get(i);
          if (fragment1.mContainer == viewGroup && fragment1.mView != null) {
            fragment = fragment1;
            break;
          } 
        }  
      if (fragment != null) {
        View view1 = fragment.mView;
        ViewGroup viewGroup1 = paramFragment.mContainer;
        i = viewGroup1.indexOfChild(view1);
        j = viewGroup1.indexOfChild(paramFragment.mView);
        if (j < i) {
          viewGroup1.removeViewAt(j);
          viewGroup1.addView(paramFragment.mView, i);
        } 
      } 
      if (paramFragment.mIsNewlyAdded && paramFragment.mContainer != null) {
        if (paramFragment.mPostponedAlpha > 0.0F)
          paramFragment.mView.setAlpha(paramFragment.mPostponedAlpha); 
        paramFragment.mPostponedAlpha = 0.0F;
        paramFragment.mIsNewlyAdded = false;
        FragmentManagerImpl$AnimationOrAnimator fragmentManagerImpl$AnimationOrAnimator = loadAnimation(paramFragment, paramFragment.getNextTransition(), true, paramFragment.getNextTransitionStyle());
        if (fragmentManagerImpl$AnimationOrAnimator != null) {
          setHWLayerAnimListenerIfAlpha(paramFragment.mView, fragmentManagerImpl$AnimationOrAnimator);
          if (fragmentManagerImpl$AnimationOrAnimator.animation != null) {
            paramFragment.mView.startAnimation(fragmentManagerImpl$AnimationOrAnimator.animation);
          } else {
            fragmentManagerImpl$AnimationOrAnimator.animator.setTarget(paramFragment.mView);
            fragmentManagerImpl$AnimationOrAnimator.animator.start();
          } 
        } 
      } 
    } 
    if (paramFragment.mHiddenChanged) {
      if (paramFragment.mView != null) {
        FragmentManagerImpl$AnimationOrAnimator fragmentManagerImpl$AnimationOrAnimator = loadAnimation(paramFragment, paramFragment.getNextTransition(), paramFragment.mHidden ^ true, paramFragment.getNextTransitionStyle());
        if (fragmentManagerImpl$AnimationOrAnimator != null && fragmentManagerImpl$AnimationOrAnimator.animator != null) {
          fragmentManagerImpl$AnimationOrAnimator.animator.setTarget(paramFragment.mView);
          if (paramFragment.mHidden) {
            if (paramFragment.isHideReplaced()) {
              paramFragment.setHideReplaced(false);
            } else {
              ViewGroup viewGroup = paramFragment.mContainer;
              View view = paramFragment.mView;
              viewGroup.startViewTransition(view);
              fragmentManagerImpl$AnimationOrAnimator.animator.addListener((Animator.AnimatorListener)new FragmentManagerImpl$4(viewGroup, view, paramFragment));
            } 
          } else {
            paramFragment.mView.setVisibility(0);
          } 
          setHWLayerAnimListenerIfAlpha(paramFragment.mView, fragmentManagerImpl$AnimationOrAnimator);
          fragmentManagerImpl$AnimationOrAnimator.animator.start();
        } else {
          if (fragmentManagerImpl$AnimationOrAnimator != null) {
            setHWLayerAnimListenerIfAlpha(paramFragment.mView, fragmentManagerImpl$AnimationOrAnimator);
            paramFragment.mView.startAnimation(fragmentManagerImpl$AnimationOrAnimator.animation);
            fragmentManagerImpl$AnimationOrAnimator.animation.start();
          } 
          if (paramFragment.mHidden && !paramFragment.isHideReplaced()) {
            i = 8;
          } else {
            i = 0;
          } 
          paramFragment.mView.setVisibility(i);
          if (paramFragment.isHideReplaced())
            paramFragment.setHideReplaced(false); 
        } 
      } 
      if (paramFragment.mAdded && paramFragment.mHasMenu && paramFragment.mMenuVisible)
        this.mNeedMenuInvalidate = true; 
      paramFragment.mHiddenChanged = false;
      boolean bool = paramFragment.mHidden;
      Fragment.onHiddenChanged$1385ff();
    } 
  }
  
  final void moveToState(int paramInt, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   4: ifnonnull -> 25
    //   7: iload_1
    //   8: ifne -> 14
    //   11: goto -> 25
    //   14: new java/lang/IllegalStateException
    //   17: dup
    //   18: ldc_w 'No activity'
    //   21: invokespecial <init> : (Ljava/lang/String;)V
    //   24: athrow
    //   25: iload_2
    //   26: ifne -> 38
    //   29: iload_1
    //   30: aload_0
    //   31: getfield mCurState : I
    //   34: if_icmpne -> 38
    //   37: return
    //   38: aload_0
    //   39: iload_1
    //   40: putfield mCurState : I
    //   43: aload_0
    //   44: getfield mActive : Landroid/util/SparseArray;
    //   47: ifnull -> 276
    //   50: aload_0
    //   51: getfield mAdded : Ljava/util/ArrayList;
    //   54: invokevirtual size : ()I
    //   57: istore #5
    //   59: iconst_0
    //   60: istore_3
    //   61: iconst_0
    //   62: istore_1
    //   63: iload_3
    //   64: iload #5
    //   66: if_icmpge -> 121
    //   69: aload_0
    //   70: getfield mAdded : Ljava/util/ArrayList;
    //   73: iload_3
    //   74: invokevirtual get : (I)Ljava/lang/Object;
    //   77: checkcast android/support/v4/app/Fragment
    //   80: astore #6
    //   82: aload_0
    //   83: aload #6
    //   85: invokevirtual moveFragmentToExpectedState : (Landroid/support/v4/app/Fragment;)V
    //   88: iload_1
    //   89: istore #4
    //   91: aload #6
    //   93: getfield mLoaderManager : Landroid/support/v4/app/LoaderManagerImpl;
    //   96: ifnull -> 111
    //   99: iload_1
    //   100: aload #6
    //   102: getfield mLoaderManager : Landroid/support/v4/app/LoaderManagerImpl;
    //   105: invokevirtual hasRunningLoaders : ()Z
    //   108: ior
    //   109: istore #4
    //   111: iload_3
    //   112: iconst_1
    //   113: iadd
    //   114: istore_3
    //   115: iload #4
    //   117: istore_1
    //   118: goto -> 63
    //   121: aload_0
    //   122: getfield mActive : Landroid/util/SparseArray;
    //   125: invokevirtual size : ()I
    //   128: istore #5
    //   130: iconst_0
    //   131: istore #4
    //   133: iload_1
    //   134: istore_3
    //   135: iload #4
    //   137: istore_1
    //   138: iload_1
    //   139: iload #5
    //   141: if_icmpge -> 234
    //   144: aload_0
    //   145: getfield mActive : Landroid/util/SparseArray;
    //   148: iload_1
    //   149: invokevirtual valueAt : (I)Ljava/lang/Object;
    //   152: checkcast android/support/v4/app/Fragment
    //   155: astore #6
    //   157: iload_3
    //   158: istore #4
    //   160: aload #6
    //   162: ifnull -> 224
    //   165: aload #6
    //   167: getfield mRemoving : Z
    //   170: ifne -> 184
    //   173: iload_3
    //   174: istore #4
    //   176: aload #6
    //   178: getfield mDetached : Z
    //   181: ifeq -> 224
    //   184: iload_3
    //   185: istore #4
    //   187: aload #6
    //   189: getfield mIsNewlyAdded : Z
    //   192: ifne -> 224
    //   195: aload_0
    //   196: aload #6
    //   198: invokevirtual moveFragmentToExpectedState : (Landroid/support/v4/app/Fragment;)V
    //   201: iload_3
    //   202: istore #4
    //   204: aload #6
    //   206: getfield mLoaderManager : Landroid/support/v4/app/LoaderManagerImpl;
    //   209: ifnull -> 224
    //   212: iload_3
    //   213: aload #6
    //   215: getfield mLoaderManager : Landroid/support/v4/app/LoaderManagerImpl;
    //   218: invokevirtual hasRunningLoaders : ()Z
    //   221: ior
    //   222: istore #4
    //   224: iload_1
    //   225: iconst_1
    //   226: iadd
    //   227: istore_1
    //   228: iload #4
    //   230: istore_3
    //   231: goto -> 138
    //   234: iload_3
    //   235: ifne -> 242
    //   238: aload_0
    //   239: invokespecial startPendingDeferredFragments : ()V
    //   242: aload_0
    //   243: getfield mNeedMenuInvalidate : Z
    //   246: ifeq -> 276
    //   249: aload_0
    //   250: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   253: ifnull -> 276
    //   256: aload_0
    //   257: getfield mCurState : I
    //   260: iconst_5
    //   261: if_icmpne -> 276
    //   264: aload_0
    //   265: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   268: invokevirtual onSupportInvalidateOptionsMenu : ()V
    //   271: aload_0
    //   272: iconst_0
    //   273: putfield mNeedMenuInvalidate : Z
    //   276: return
  }
  
  final void moveToState(Fragment paramFragment, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
    if (!paramFragment.mAdded || paramFragment.mDetached) {
      int j = paramInt1;
      paramInt1 = j;
      if (j > 1)
        paramInt1 = 1; 
    } 
    int i = paramInt1;
    if (paramFragment.mRemoving) {
      i = paramInt1;
      if (paramInt1 > paramFragment.mState)
        if (paramFragment.mState == 0 && paramFragment.isInBackStack()) {
          i = 1;
        } else {
          i = paramFragment.mState;
        }  
    } 
    paramInt1 = i;
    if (paramFragment.mDeferStart) {
      paramInt1 = i;
      if (paramFragment.mState < 4) {
        paramInt1 = i;
        if (i > 3)
          paramInt1 = 3; 
      } 
    } 
    if (paramFragment.mState <= paramInt1) {
      if (paramFragment.mFromLayout && !paramFragment.mInLayout)
        return; 
      if (paramFragment.getAnimatingAway() != null || paramFragment.getAnimator() != null) {
        paramFragment.setAnimatingAway(null);
        paramFragment.setAnimator(null);
        moveToState(paramFragment, paramFragment.getStateAfterAnimating(), 0, 0, true);
      } 
      paramInt3 = paramInt1;
      i = paramInt1;
      int j = paramInt1;
      paramInt2 = paramInt1;
      switch (paramFragment.mState) {
        case 0:
          paramInt3 = paramInt1;
          if (paramInt1 > 0) {
            FragmentManagerImpl fragmentManagerImpl;
            if (DEBUG)
              (new StringBuilder("moveto CREATED: ")).append(paramFragment); 
            paramInt3 = paramInt1;
            if (paramFragment.mSavedFragmentState != null) {
              paramFragment.mSavedFragmentState.setClassLoader(this.mHost.mContext.getClassLoader());
              paramFragment.mSavedViewState = paramFragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
              paramFragment.mTarget = getFragment(paramFragment.mSavedFragmentState, "android:target_state");
              if (paramFragment.mTarget != null)
                paramFragment.mTargetRequestCode = paramFragment.mSavedFragmentState.getInt("android:target_req_state", 0); 
              paramFragment.mUserVisibleHint = paramFragment.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
              paramInt3 = paramInt1;
              if (!paramFragment.mUserVisibleHint) {
                paramFragment.mDeferStart = true;
                paramInt3 = paramInt1;
                if (paramInt1 > 3)
                  paramInt3 = 3; 
              } 
            } 
            paramFragment.mHost = this.mHost;
            paramFragment.mParentFragment = this.mParent;
            if (this.mParent != null) {
              fragmentManagerImpl = this.mParent.mChildFragmentManager;
            } else {
              fragmentManagerImpl = this.mHost.mFragmentManager;
            } 
            paramFragment.mFragmentManager = fragmentManagerImpl;
            if (paramFragment.mTarget != null)
              if (this.mActive.get(paramFragment.mTarget.mIndex) == paramFragment.mTarget) {
                if (paramFragment.mTarget.mState <= 0)
                  moveToState(paramFragment.mTarget, 1, 0, 0, true); 
              } else {
                StringBuilder stringBuilder = new StringBuilder("Fragment ");
                stringBuilder.append(paramFragment);
                stringBuilder.append(" declared target fragment ");
                stringBuilder.append(paramFragment.mTarget);
                stringBuilder.append(" that does not belong to this FragmentManager!");
                throw new IllegalStateException(stringBuilder.toString());
              }  
            dispatchOnFragmentPreAttached(paramFragment, this.mHost.mContext, false);
            paramFragment.mCalled = false;
            paramFragment.onAttach(this.mHost.mContext);
            if (paramFragment.mCalled) {
              if (paramFragment.mParentFragment != null) {
                Fragment fragment = paramFragment.mParentFragment;
                Fragment.onAttachFragment$65850823();
              } 
              dispatchOnFragmentAttached(paramFragment, this.mHost.mContext, false);
              if (!paramFragment.mIsCreated) {
                dispatchOnFragmentPreCreated(paramFragment, paramFragment.mSavedFragmentState, false);
                paramFragment.performCreate(paramFragment.mSavedFragmentState);
                dispatchOnFragmentCreated(paramFragment, paramFragment.mSavedFragmentState, false);
              } else {
                paramFragment.restoreChildFragmentState(paramFragment.mSavedFragmentState);
                paramFragment.mState = 1;
              } 
              paramFragment.mRetaining = false;
            } else {
              StringBuilder stringBuilder = new StringBuilder("Fragment ");
              stringBuilder.append(paramFragment);
              stringBuilder.append(" did not call through to super.onAttach()");
              throw new SuperNotCalledException(stringBuilder.toString());
            } 
          } 
        case 1:
          if (paramFragment.mFromLayout && !paramFragment.mPerformedCreateView) {
            paramFragment.performGetLayoutInflater(paramFragment.mSavedFragmentState);
            Bundle bundle = paramFragment.mSavedFragmentState;
            paramFragment.mView = paramFragment.performCreateView$469ccb8a();
            if (paramFragment.mView != null) {
              paramFragment.mInnerView = paramFragment.mView;
              paramFragment.mView.setSaveFromParentEnabled(false);
              if (paramFragment.mHidden)
                paramFragment.mView.setVisibility(8); 
              View view = paramFragment.mView;
              Bundle bundle1 = paramFragment.mSavedFragmentState;
              Fragment.onViewCreated$65f1d89();
              dispatchOnFragmentViewCreated(paramFragment, paramFragment.mView, paramFragment.mSavedFragmentState, false);
            } else {
              paramFragment.mInnerView = null;
            } 
          } 
          if (paramInt3 > 1) {
            if (DEBUG)
              (new StringBuilder("moveto ACTIVITY_CREATED: ")).append(paramFragment); 
            if (!paramFragment.mFromLayout) {
              ViewGroup viewGroup;
              if (paramFragment.mContainerId != 0) {
                if (paramFragment.mContainerId == -1) {
                  StringBuilder stringBuilder = new StringBuilder("Cannot create fragment ");
                  stringBuilder.append(paramFragment);
                  stringBuilder.append(" for a container view with no id");
                  throwException(new IllegalArgumentException(stringBuilder.toString()));
                } 
                ViewGroup viewGroup1 = (ViewGroup)this.mContainer.onFindViewById(paramFragment.mContainerId);
                viewGroup = viewGroup1;
                if (viewGroup1 == null) {
                  viewGroup = viewGroup1;
                  if (!paramFragment.mRestored) {
                    String str;
                    try {
                      if (paramFragment.mHost != null) {
                        str = paramFragment.mHost.mContext.getResources().getResourceName(paramFragment.mContainerId);
                      } else {
                        StringBuilder stringBuilder1 = new StringBuilder("Fragment ");
                        stringBuilder1.append(paramFragment);
                        stringBuilder1.append(" not attached to Activity");
                        throw new IllegalStateException(stringBuilder1.toString());
                      } 
                    } catch (android.content.res.Resources.NotFoundException notFoundException) {
                      str = "unknown";
                    } 
                    StringBuilder stringBuilder = new StringBuilder("No view found for id 0x");
                    stringBuilder.append(Integer.toHexString(paramFragment.mContainerId));
                    stringBuilder.append(" (");
                    stringBuilder.append(str);
                    stringBuilder.append(") for fragment ");
                    stringBuilder.append(paramFragment);
                    throwException(new IllegalArgumentException(stringBuilder.toString()));
                    ViewGroup viewGroup2 = viewGroup1;
                  } 
                } 
              } else {
                viewGroup = null;
              } 
              paramFragment.mContainer = viewGroup;
              paramFragment.performGetLayoutInflater(paramFragment.mSavedFragmentState);
              Bundle bundle = paramFragment.mSavedFragmentState;
              paramFragment.mView = paramFragment.performCreateView$469ccb8a();
              if (paramFragment.mView != null) {
                paramFragment.mInnerView = paramFragment.mView;
                paramFragment.mView.setSaveFromParentEnabled(false);
                if (viewGroup != null)
                  viewGroup.addView(paramFragment.mView); 
                if (paramFragment.mHidden)
                  paramFragment.mView.setVisibility(8); 
                View view = paramFragment.mView;
                Bundle bundle1 = paramFragment.mSavedFragmentState;
                Fragment.onViewCreated$65f1d89();
                dispatchOnFragmentViewCreated(paramFragment, paramFragment.mView, paramFragment.mSavedFragmentState, false);
                if (paramFragment.mView.getVisibility() == 0 && paramFragment.mContainer != null) {
                  paramBoolean = true;
                } else {
                  paramBoolean = false;
                } 
                paramFragment.mIsNewlyAdded = paramBoolean;
              } else {
                paramFragment.mInnerView = null;
              } 
            } 
            paramFragment.performActivityCreated(paramFragment.mSavedFragmentState);
            dispatchOnFragmentActivityCreated(paramFragment, paramFragment.mSavedFragmentState, false);
            if (paramFragment.mView != null) {
              Bundle bundle = paramFragment.mSavedFragmentState;
              if (paramFragment.mSavedViewState != null) {
                paramFragment.mInnerView.restoreHierarchyState(paramFragment.mSavedViewState);
                paramFragment.mSavedViewState = null;
              } 
              paramFragment.mCalled = false;
              paramFragment.mCalled = true;
              if (!paramFragment.mCalled) {
                StringBuilder stringBuilder = new StringBuilder("Fragment ");
                stringBuilder.append(paramFragment);
                stringBuilder.append(" did not call through to super.onViewStateRestored()");
                throw new SuperNotCalledException(stringBuilder.toString());
              } 
            } 
            paramFragment.mSavedFragmentState = null;
          } 
          i = paramInt3;
        case 2:
          j = i;
          if (i > 2) {
            paramFragment.mState = 3;
            j = i;
          } 
        case 3:
          paramInt2 = j;
          if (j > 3) {
            if (DEBUG)
              (new StringBuilder("moveto STARTED: ")).append(paramFragment); 
            paramFragment.performStart();
            dispatchOnFragmentStarted(paramFragment, false);
            paramInt2 = j;
          } 
        case 4:
          paramInt1 = paramInt2;
          if (paramInt2 > 4) {
            if (DEBUG)
              (new StringBuilder("moveto RESUMED: ")).append(paramFragment); 
            paramFragment.performResume();
            dispatchOnFragmentResumed(paramFragment, false);
            paramFragment.mSavedFragmentState = null;
            paramFragment.mSavedViewState = null;
            paramInt1 = paramInt2;
          } 
          break;
      } 
      i = paramInt1;
    } else {
      i = paramInt1;
      if (paramFragment.mState > paramInt1)
        switch (paramFragment.mState) {
          default:
            i = paramInt1;
            break;
          case 5:
            if (paramInt1 < 5) {
              if (DEBUG)
                (new StringBuilder("movefrom RESUMED: ")).append(paramFragment); 
              paramFragment.performPause();
              dispatchOnFragmentPaused(paramFragment, false);
            } 
          case 4:
            if (paramInt1 < 4) {
              if (DEBUG)
                (new StringBuilder("movefrom STARTED: ")).append(paramFragment); 
              paramFragment.performStop();
              dispatchOnFragmentStopped(paramFragment, false);
            } 
          case 3:
            if (paramInt1 < 3) {
              if (DEBUG)
                (new StringBuilder("movefrom STOPPED: ")).append(paramFragment); 
              paramFragment.performReallyStop();
            } 
          case 2:
            if (paramInt1 < 2) {
              if (DEBUG)
                (new StringBuilder("movefrom ACTIVITY_CREATED: ")).append(paramFragment); 
              if (paramFragment.mView != null && this.mHost.onShouldSaveFragmentState$6585081f() && paramFragment.mSavedViewState == null)
                saveFragmentViewState(paramFragment); 
              if (paramFragment.mChildFragmentManager != null)
                paramFragment.mChildFragmentManager.dispatchStateChange(1); 
              paramFragment.mState = 1;
              paramFragment.mCalled = false;
              paramFragment.onDestroyView();
              if (paramFragment.mCalled) {
                if (paramFragment.mLoaderManager != null)
                  paramFragment.mLoaderManager.doReportNextStart(); 
                paramFragment.mPerformedCreateView = false;
                dispatchOnFragmentViewDestroyed(paramFragment, false);
                if (paramFragment.mView != null && paramFragment.mContainer != null) {
                  FragmentManagerImpl$AnimationOrAnimator fragmentManagerImpl$AnimationOrAnimator;
                  paramFragment.mView.clearAnimation();
                  paramFragment.mContainer.endViewTransition(paramFragment.mView);
                  if (this.mCurState > 0 && !this.mDestroyed && paramFragment.mView.getVisibility() == 0 && paramFragment.mPostponedAlpha >= 0.0F) {
                    fragmentManagerImpl$AnimationOrAnimator = loadAnimation(paramFragment, paramInt2, false, paramInt3);
                  } else {
                    fragmentManagerImpl$AnimationOrAnimator = null;
                  } 
                  paramFragment.mPostponedAlpha = 0.0F;
                  if (fragmentManagerImpl$AnimationOrAnimator != null) {
                    View view = paramFragment.mView;
                    ViewGroup viewGroup = paramFragment.mContainer;
                    viewGroup.startViewTransition(view);
                    paramFragment.setStateAfterAnimating(paramInt1);
                    if (fragmentManagerImpl$AnimationOrAnimator.animation != null) {
                      Animation animation = fragmentManagerImpl$AnimationOrAnimator.animation;
                      paramFragment.setAnimatingAway(paramFragment.mView);
                      animation.setAnimationListener(new FragmentManagerImpl$2(this, getAnimationListener(animation), viewGroup, view, paramFragment));
                      setHWLayerAnimListenerIfAlpha(view, fragmentManagerImpl$AnimationOrAnimator);
                      paramFragment.mView.startAnimation(animation);
                    } else {
                      Animator animator = fragmentManagerImpl$AnimationOrAnimator.animator;
                      paramFragment.setAnimator(fragmentManagerImpl$AnimationOrAnimator.animator);
                      animator.addListener((Animator.AnimatorListener)new FragmentManagerImpl$3(this, viewGroup, view, paramFragment));
                      animator.setTarget(paramFragment.mView);
                      setHWLayerAnimListenerIfAlpha(paramFragment.mView, fragmentManagerImpl$AnimationOrAnimator);
                      animator.start();
                    } 
                  } 
                  paramFragment.mContainer.removeView(paramFragment.mView);
                } 
                paramFragment.mContainer = null;
                paramFragment.mView = null;
                paramFragment.mInnerView = null;
                paramFragment.mInLayout = false;
              } else {
                StringBuilder stringBuilder = new StringBuilder("Fragment ");
                stringBuilder.append(paramFragment);
                stringBuilder.append(" did not call through to super.onDestroyView()");
                throw new SuperNotCalledException(stringBuilder.toString());
              } 
            } 
          case 1:
            i = paramInt1;
            if (paramInt1 <= 0) {
              if (this.mDestroyed)
                if (paramFragment.getAnimatingAway() != null) {
                  View view = paramFragment.getAnimatingAway();
                  paramFragment.setAnimatingAway(null);
                  view.clearAnimation();
                } else if (paramFragment.getAnimator() != null) {
                  Animator animator = paramFragment.getAnimator();
                  paramFragment.setAnimator(null);
                  animator.cancel();
                }  
              if (paramFragment.getAnimatingAway() != null || paramFragment.getAnimator() != null) {
                paramFragment.setStateAfterAnimating(paramInt1);
                i = 1;
                break;
              } 
              if (DEBUG)
                (new StringBuilder("movefrom CREATED: ")).append(paramFragment); 
              if (!paramFragment.mRetaining) {
                paramFragment.performDestroy();
                dispatchOnFragmentDestroyed(paramFragment, false);
              } else {
                paramFragment.mState = 0;
              } 
              paramFragment.mCalled = false;
              paramFragment.onDetach();
              paramFragment.mLayoutInflater = null;
              if (paramFragment.mCalled) {
                if (paramFragment.mChildFragmentManager != null)
                  if (paramFragment.mRetaining) {
                    paramFragment.mChildFragmentManager.dispatchDestroy();
                    paramFragment.mChildFragmentManager = null;
                  } else {
                    StringBuilder stringBuilder1 = new StringBuilder("Child FragmentManager of ");
                    stringBuilder1.append(paramFragment);
                    stringBuilder1.append(" was not  destroyed and this fragment is not retaining instance");
                    throw new IllegalStateException(stringBuilder1.toString());
                  }  
                dispatchOnFragmentDetached(paramFragment, false);
                i = paramInt1;
                if (!paramBoolean) {
                  if (!paramFragment.mRetaining) {
                    if (paramFragment.mIndex >= 0) {
                      if (DEBUG)
                        (new StringBuilder("Freeing fragment index ")).append(paramFragment); 
                      this.mActive.put(paramFragment.mIndex, null);
                      this.mHost.inactivateFragment(paramFragment.mWho);
                      paramFragment.mIndex = -1;
                      paramFragment.mWho = null;
                      paramFragment.mAdded = false;
                      paramFragment.mRemoving = false;
                      paramFragment.mFromLayout = false;
                      paramFragment.mInLayout = false;
                      paramFragment.mRestored = false;
                      paramFragment.mBackStackNesting = 0;
                      paramFragment.mFragmentManager = null;
                      paramFragment.mChildFragmentManager = null;
                      paramFragment.mHost = null;
                      paramFragment.mFragmentId = 0;
                      paramFragment.mContainerId = 0;
                      paramFragment.mTag = null;
                      paramFragment.mHidden = false;
                      paramFragment.mDetached = false;
                      paramFragment.mRetaining = false;
                      paramFragment.mLoaderManager = null;
                      paramFragment.mLoadersStarted = false;
                      paramFragment.mCheckedForLoaderManager = false;
                    } 
                    i = paramInt1;
                    break;
                  } 
                  paramFragment.mHost = null;
                  paramFragment.mParentFragment = null;
                  paramFragment.mFragmentManager = null;
                  i = paramInt1;
                } 
                break;
              } 
              StringBuilder stringBuilder = new StringBuilder("Fragment ");
              stringBuilder.append(paramFragment);
              stringBuilder.append(" did not call through to super.onDetach()");
              throw new SuperNotCalledException(stringBuilder.toString());
            } 
            break;
        }  
    } 
    if (paramFragment.mState != i) {
      StringBuilder stringBuilder = new StringBuilder("moveToState: Fragment state for ");
      stringBuilder.append(paramFragment);
      stringBuilder.append(" not updated inline; expected state ");
      stringBuilder.append(i);
      stringBuilder.append(" found ");
      stringBuilder.append(paramFragment.mState);
      Log.w("FragmentManager", stringBuilder.toString());
      paramFragment.mState = i;
    } 
  }
  
  public final void noteStateNotSaved() {
    this.mSavedNonConfig = null;
    int i = 0;
    this.mStateSaved = false;
    int j = this.mAdded.size();
    while (i < j) {
      Fragment fragment = this.mAdded.get(i);
      if (fragment != null && fragment.mChildFragmentManager != null)
        fragment.mChildFragmentManager.noteStateNotSaved(); 
      i++;
    } 
  }
  
  public final View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet) {
    if (!"fragment".equals(paramString))
      return null; 
    paramString = paramAttributeSet.getAttributeValue(null, "class");
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, FragmentManagerImpl$FragmentTag.Fragment);
    int i = 0;
    String str1 = paramString;
    if (paramString == null)
      str1 = typedArray.getString(0); 
    int j = typedArray.getResourceId(1, -1);
    String str2 = typedArray.getString(2);
    typedArray.recycle();
    if (!Fragment.isSupportFragmentClass(this.mHost.mContext, str1))
      return null; 
    if (paramView != null)
      i = paramView.getId(); 
    if (i != -1 || j != -1 || str2 != null) {
      Fragment fragment2;
      if (j != -1) {
        Fragment fragment = findFragmentById(j);
      } else {
        paramView = null;
      } 
      View view = paramView;
      if (paramView == null) {
        view = paramView;
        if (str2 != null)
          fragment2 = findFragmentByTag(str2); 
      } 
      Fragment fragment1 = fragment2;
      if (fragment2 == null) {
        fragment1 = fragment2;
        if (i != -1)
          fragment1 = findFragmentById(i); 
      } 
      if (DEBUG) {
        StringBuilder stringBuilder2 = new StringBuilder("onCreateView: id=0x");
        stringBuilder2.append(Integer.toHexString(j));
        stringBuilder2.append(" fname=");
        stringBuilder2.append(str1);
        stringBuilder2.append(" existing=");
        stringBuilder2.append(fragment1);
      } 
      if (fragment1 == null) {
        int k;
        fragment1 = this.mContainer.instantiate(paramContext, str1, null);
        fragment1.mFromLayout = true;
        if (j != 0) {
          k = j;
        } else {
          k = i;
        } 
        fragment1.mFragmentId = k;
        fragment1.mContainerId = i;
        fragment1.mTag = str2;
        fragment1.mInLayout = true;
        fragment1.mFragmentManager = this;
        fragment1.mHost = this.mHost;
        Bundle bundle = fragment1.mSavedFragmentState;
        fragment1.onInflate$2c1ed547$6a2adb45();
        addFragment(fragment1, true);
      } else if (!fragment1.mInLayout) {
        fragment1.mInLayout = true;
        fragment1.mHost = this.mHost;
        if (!fragment1.mRetaining) {
          Bundle bundle = fragment1.mSavedFragmentState;
          fragment1.onInflate$2c1ed547$6a2adb45();
        } 
      } else {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramAttributeSet.getPositionDescription());
        stringBuilder1.append(": Duplicate id 0x");
        stringBuilder1.append(Integer.toHexString(j));
        stringBuilder1.append(", tag ");
        stringBuilder1.append(str2);
        stringBuilder1.append(", or parent id 0x");
        stringBuilder1.append(Integer.toHexString(i));
        stringBuilder1.append(" with another fragment for ");
        stringBuilder1.append(str1);
        throw new IllegalArgumentException(stringBuilder1.toString());
      } 
      if (this.mCurState <= 0 && ((Fragment)stringBuilder1).mFromLayout) {
        moveToState((Fragment)stringBuilder1, 1, 0, 0, false);
      } else {
        moveToState((Fragment)stringBuilder1);
      } 
      if (((Fragment)stringBuilder1).mView != null) {
        if (j != 0)
          ((Fragment)stringBuilder1).mView.setId(j); 
        if (((Fragment)stringBuilder1).mView.getTag() == null)
          ((Fragment)stringBuilder1).mView.setTag(str2); 
        return ((Fragment)stringBuilder1).mView;
      } 
      StringBuilder stringBuilder1 = new StringBuilder("Fragment ");
      stringBuilder1.append(str1);
      stringBuilder1.append(" did not create a view.");
      throw new IllegalStateException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramAttributeSet.getPositionDescription());
    stringBuilder.append(": Must specify unique android:id, android:tag, or have a parent with an id for ");
    stringBuilder.append(str1);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public final View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet) {
    return onCreateView(null, paramString, paramContext, paramAttributeSet);
  }
  
  public final void popBackStack(int paramInt1, int paramInt2) {
    if (paramInt1 >= 0) {
      enqueueAction(new FragmentManagerImpl$PopBackStackState(this, null, paramInt1, paramInt2), false);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder("Bad id: ");
    stringBuilder.append(paramInt1);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public final boolean popBackStackImmediate() {
    checkStateLoss();
    return popBackStackImmediate(null, -1, 0);
  }
  
  final boolean popBackStackState(ArrayList paramArrayList1, ArrayList<Boolean> paramArrayList2, String paramString, int paramInt1, int paramInt2) {
    byte b;
    if (this.mBackStack == null)
      return false; 
    if (paramString == null && paramInt1 < 0 && (paramInt2 & 0x1) == 0) {
      paramInt1 = this.mBackStack.size() - 1;
      if (paramInt1 < 0)
        return false; 
      paramArrayList1.add(this.mBackStack.remove(paramInt1));
      paramArrayList2.add(Boolean.valueOf(true));
      return true;
    } 
    if (paramString != null || paramInt1 >= 0) {
      int i = this.mBackStack.size() - 1;
      while (i >= 0) {
        BackStackRecord backStackRecord = this.mBackStack.get(i);
        if ((paramString == null || !paramString.equals(backStackRecord.mName)) && (paramInt1 < 0 || paramInt1 != backStackRecord.mIndex))
          i--; 
      } 
      if (i < 0)
        return false; 
      b = i;
      if ((paramInt2 & 0x1) != 0)
        for (paramInt2 = i - 1;; paramInt2--) {
          b = paramInt2;
          if (paramInt2 >= 0) {
            BackStackRecord backStackRecord = this.mBackStack.get(paramInt2);
            if (paramString == null || !paramString.equals(backStackRecord.mName)) {
              b = paramInt2;
              if (paramInt1 >= 0) {
                b = paramInt2;
                if (paramInt1 == backStackRecord.mIndex)
                  continue; 
              } 
              break;
            } 
            continue;
          } 
          break;
        }  
    } else {
      b = -1;
    } 
    if (b == this.mBackStack.size() - 1)
      return false; 
    for (paramInt1 = this.mBackStack.size() - 1; paramInt1 > b; paramInt1--) {
      paramArrayList1.add(this.mBackStack.remove(paramInt1));
      paramArrayList2.add(Boolean.valueOf(true));
    } 
    return true;
  }
  
  public final void removeFragment(Fragment paramFragment) {
    if (DEBUG) {
      StringBuilder stringBuilder = new StringBuilder("remove: ");
      stringBuilder.append(paramFragment);
      stringBuilder.append(" nesting=");
      stringBuilder.append(paramFragment.mBackStackNesting);
    } 
    boolean bool = paramFragment.isInBackStack();
    if (!paramFragment.mDetached || (bool ^ true) != 0)
      synchronized (this.mAdded) {
        this.mAdded.remove(paramFragment);
        if (paramFragment.mHasMenu && paramFragment.mMenuVisible)
          this.mNeedMenuInvalidate = true; 
        paramFragment.mAdded = false;
        paramFragment.mRemoving = true;
        return;
      }  
  }
  
  final void restoreAllState(Parcelable<FragmentManagerNonConfig> paramParcelable, FragmentManagerNonConfig paramFragmentManagerNonConfig) {
    if (paramParcelable == null)
      return; 
    FragmentManagerState fragmentManagerState = (FragmentManagerState)paramParcelable;
    if (fragmentManagerState.mActive == null)
      return; 
    if (paramFragmentManagerNonConfig != null) {
      byte b;
      List<Fragment> list1 = paramFragmentManagerNonConfig.mFragments;
      List list = paramFragmentManagerNonConfig.mChildNonConfigs;
      if (list1 != null) {
        b = list1.size();
      } else {
        b = 0;
      } 
      int j = 0;
      while (true) {
        List list2 = list;
        if (j < b) {
          Fragment fragment = list1.get(j);
          if (DEBUG)
            (new StringBuilder("restoreAllState: re-attaching retained ")).append(fragment); 
          int k;
          for (k = 0; k < fragmentManagerState.mActive.length && (fragmentManagerState.mActive[k]).mIndex != fragment.mIndex; k++);
          if (k == fragmentManagerState.mActive.length) {
            StringBuilder stringBuilder = new StringBuilder("Could not find active fragment with index ");
            stringBuilder.append(fragment.mIndex);
            throwException(new IllegalStateException(stringBuilder.toString()));
          } 
          FragmentState fragmentState = fragmentManagerState.mActive[k];
          fragmentState.mInstance = fragment;
          fragment.mSavedViewState = null;
          fragment.mBackStackNesting = 0;
          fragment.mInLayout = false;
          fragment.mAdded = false;
          fragment.mTarget = null;
          if (fragmentState.mSavedFragmentState != null) {
            fragmentState.mSavedFragmentState.setClassLoader(this.mHost.mContext.getClassLoader());
            fragment.mSavedViewState = fragmentState.mSavedFragmentState.getSparseParcelableArray("android:view_state");
            fragment.mSavedFragmentState = fragmentState.mSavedFragmentState;
          } 
          j++;
          continue;
        } 
        break;
      } 
    } else {
      paramParcelable = null;
    } 
    this.mActive = new SparseArray(fragmentManagerState.mActive.length);
    int i;
    for (i = 0; i < fragmentManagerState.mActive.length; i++) {
      FragmentState fragmentState = fragmentManagerState.mActive[i];
      if (fragmentState != null) {
        FragmentManagerNonConfig fragmentManagerNonConfig;
        if (paramParcelable != null && i < paramParcelable.size()) {
          fragmentManagerNonConfig = paramParcelable.get(i);
        } else {
          fragmentManagerNonConfig = null;
        } 
        FragmentHostCallback fragmentHostCallback = this.mHost;
        FragmentContainer fragmentContainer = this.mContainer;
        Fragment fragment2 = this.mParent;
        if (fragmentState.mInstance == null) {
          Context context = fragmentHostCallback.mContext;
          if (fragmentState.mArguments != null)
            fragmentState.mArguments.setClassLoader(context.getClassLoader()); 
          if (fragmentContainer != null) {
            fragmentState.mInstance = fragmentContainer.instantiate(context, fragmentState.mClassName, fragmentState.mArguments);
          } else {
            fragmentState.mInstance = Fragment.instantiate(context, fragmentState.mClassName, fragmentState.mArguments);
          } 
          if (fragmentState.mSavedFragmentState != null) {
            fragmentState.mSavedFragmentState.setClassLoader(context.getClassLoader());
            fragmentState.mInstance.mSavedFragmentState = fragmentState.mSavedFragmentState;
          } 
          fragmentState.mInstance.setIndex(fragmentState.mIndex, fragment2);
          fragmentState.mInstance.mFromLayout = fragmentState.mFromLayout;
          fragmentState.mInstance.mRestored = true;
          fragmentState.mInstance.mFragmentId = fragmentState.mFragmentId;
          fragmentState.mInstance.mContainerId = fragmentState.mContainerId;
          fragmentState.mInstance.mTag = fragmentState.mTag;
          fragmentState.mInstance.mRetainInstance = fragmentState.mRetainInstance;
          fragmentState.mInstance.mDetached = fragmentState.mDetached;
          fragmentState.mInstance.mHidden = fragmentState.mHidden;
          fragmentState.mInstance.mFragmentManager = fragmentHostCallback.mFragmentManager;
          if (DEBUG)
            (new StringBuilder("Instantiated fragment ")).append(fragmentState.mInstance); 
        } 
        fragmentState.mInstance.mChildNonConfig = fragmentManagerNonConfig;
        Fragment fragment1 = fragmentState.mInstance;
        if (DEBUG) {
          StringBuilder stringBuilder = new StringBuilder("restoreAllState: active #");
          stringBuilder.append(i);
          stringBuilder.append(": ");
          stringBuilder.append(fragment1);
        } 
        this.mActive.put(fragment1.mIndex, fragment1);
        fragmentState.mInstance = null;
      } 
    } 
    if (paramFragmentManagerNonConfig != null) {
      List<Fragment> list = paramFragmentManagerNonConfig.mFragments;
      if (list != null) {
        i = list.size();
      } else {
        i = 0;
      } 
      int j;
      for (j = 0; j < i; j++) {
        Fragment fragment = list.get(j);
        if (fragment.mTargetIndex >= 0) {
          fragment.mTarget = (Fragment)this.mActive.get(fragment.mTargetIndex);
          if (fragment.mTarget == null) {
            StringBuilder stringBuilder = new StringBuilder("Re-attaching retained fragment ");
            stringBuilder.append(fragment);
            stringBuilder.append(" target no longer exists: ");
            stringBuilder.append(fragment.mTargetIndex);
            Log.w("FragmentManager", stringBuilder.toString());
          } 
        } 
      } 
    } 
    this.mAdded.clear();
    if (fragmentManagerState.mAdded != null) {
      i = 0;
      while (i < fragmentManagerState.mAdded.length) {
        Fragment fragment = (Fragment)this.mActive.get(fragmentManagerState.mAdded[i]);
        if (fragment == null) {
          StringBuilder stringBuilder = new StringBuilder("No instantiated fragment for index #");
          stringBuilder.append(fragmentManagerState.mAdded[i]);
          throwException(new IllegalStateException(stringBuilder.toString()));
        } 
        fragment.mAdded = true;
        if (DEBUG) {
          StringBuilder stringBuilder = new StringBuilder("restoreAllState: added #");
          stringBuilder.append(i);
          stringBuilder.append(": ");
          stringBuilder.append(fragment);
        } 
        if (!this.mAdded.contains(fragment)) {
          synchronized (this.mAdded) {
            this.mAdded.add(fragment);
            i++;
          } 
          continue;
        } 
        throw new IllegalStateException("Already added!");
      } 
    } 
    if (fragmentManagerState.mBackStack != null) {
      this.mBackStack = new ArrayList(fragmentManagerState.mBackStack.length);
      for (i = 0; i < fragmentManagerState.mBackStack.length; i++) {
        BackStackRecord backStackRecord = fragmentManagerState.mBackStack[i].instantiate(this);
        if (DEBUG) {
          StringBuilder stringBuilder = new StringBuilder("restoreAllState: back stack #");
          stringBuilder.append(i);
          stringBuilder.append(" (index ");
          stringBuilder.append(backStackRecord.mIndex);
          stringBuilder.append("): ");
          stringBuilder.append(backStackRecord);
          PrintWriter printWriter = new PrintWriter((Writer)new LogWriter());
          backStackRecord.dump("  ", printWriter, false);
          printWriter.close();
        } 
        this.mBackStack.add(backStackRecord);
        if (backStackRecord.mIndex >= 0)
          setBackStackIndex(backStackRecord.mIndex, backStackRecord); 
      } 
    } else {
      this.mBackStack = null;
    } 
    if (fragmentManagerState.mPrimaryNavActiveIndex >= 0)
      this.mPrimaryNav = (Fragment)this.mActive.get(fragmentManagerState.mPrimaryNavActiveIndex); 
    this.mNextFragmentIndex = fragmentManagerState.mNextFragmentIndex;
  }
  
  final Parcelable saveAllState() {
    int i;
    ArrayList arrayList = this.mPostponedTransactions;
    boolean bool = false;
    if (arrayList != null)
      while (!this.mPostponedTransactions.isEmpty())
        ((FragmentManagerImpl$StartEnterTransitionListener)this.mPostponedTransactions.remove(0)).completeTransaction();  
    if (this.mActive == null) {
      i = 0;
    } else {
      i = this.mActive.size();
    } 
    int j = 0;
    while (true) {
      Animation animation = null;
      if (j < i) {
        Fragment fragment = (Fragment)this.mActive.valueAt(j);
        if (fragment != null)
          if (fragment.getAnimatingAway() != null) {
            int k = fragment.getStateAfterAnimating();
            View view = fragment.getAnimatingAway();
            animation = view.getAnimation();
            if (animation != null) {
              animation.cancel();
              view.clearAnimation();
            } 
            fragment.setAnimatingAway(null);
            moveToState(fragment, k, 0, 0, false);
          } else if (fragment.getAnimator() != null) {
            fragment.getAnimator().end();
          }  
        j++;
        continue;
      } 
      execPendingActions();
      this.mStateSaved = true;
      this.mSavedNonConfig = null;
      if (this.mActive != null) {
        StringBuilder stringBuilder;
        if (this.mActive.size() <= 0)
          return null; 
        int k = this.mActive.size();
        FragmentState[] arrayOfFragmentState = new FragmentState[k];
        i = 0;
        j = 0;
        while (i < k) {
          Fragment fragment = (Fragment)this.mActive.valueAt(i);
          if (fragment != null) {
            if (fragment.mIndex < 0) {
              StringBuilder stringBuilder1 = new StringBuilder("Failure saving state: active ");
              stringBuilder1.append(fragment);
              stringBuilder1.append(" has cleared index: ");
              stringBuilder1.append(fragment.mIndex);
              throwException(new IllegalStateException(stringBuilder1.toString()));
            } 
            FragmentState fragmentState = new FragmentState(fragment);
            arrayOfFragmentState[i] = fragmentState;
            if (fragment.mState > 0 && fragmentState.mSavedFragmentState == null) {
              Bundle bundle1;
              ArrayList arrayList1;
              if (this.mStateBundle == null)
                this.mStateBundle = new Bundle(); 
              fragment.performSaveInstanceState(this.mStateBundle);
              dispatchOnFragmentSaveInstanceState(fragment, this.mStateBundle, false);
              if (!this.mStateBundle.isEmpty()) {
                arrayList1 = (ArrayList)this.mStateBundle;
                this.mStateBundle = null;
              } else {
                arrayList1 = null;
              } 
              if (fragment.mView != null)
                saveFragmentViewState(fragment); 
              arrayList = arrayList1;
              if (fragment.mSavedViewState != null) {
                arrayList = arrayList1;
                if (arrayList1 == null)
                  bundle1 = new Bundle(); 
                bundle1.putSparseParcelableArray("android:view_state", fragment.mSavedViewState);
              } 
              Bundle bundle2 = bundle1;
              if (!fragment.mUserVisibleHint) {
                bundle2 = bundle1;
                if (bundle1 == null)
                  bundle2 = new Bundle(); 
                bundle2.putBoolean("android:user_visible_hint", fragment.mUserVisibleHint);
              } 
              fragmentState.mSavedFragmentState = bundle2;
              if (fragment.mTarget != null) {
                if (fragment.mTarget.mIndex < 0) {
                  StringBuilder stringBuilder1 = new StringBuilder("Failure saving state: ");
                  stringBuilder1.append(fragment);
                  stringBuilder1.append(" has target not in fragment manager: ");
                  stringBuilder1.append(fragment.mTarget);
                  throwException(new IllegalStateException(stringBuilder1.toString()));
                } 
                if (fragmentState.mSavedFragmentState == null)
                  fragmentState.mSavedFragmentState = new Bundle(); 
                bundle1 = fragmentState.mSavedFragmentState;
                Fragment fragment1 = fragment.mTarget;
                if (fragment1.mIndex < 0) {
                  StringBuilder stringBuilder1 = new StringBuilder("Fragment ");
                  stringBuilder1.append(fragment1);
                  stringBuilder1.append(" is not currently in the FragmentManager");
                  throwException(new IllegalStateException(stringBuilder1.toString()));
                } 
                bundle1.putInt("android:target_state", fragment1.mIndex);
                if (fragment.mTargetRequestCode != 0)
                  fragmentState.mSavedFragmentState.putInt("android:target_req_state", fragment.mTargetRequestCode); 
              } 
            } else {
              fragmentState.mSavedFragmentState = fragment.mSavedFragmentState;
            } 
            if (DEBUG) {
              StringBuilder stringBuilder1 = new StringBuilder("Saved state of ");
              stringBuilder1.append(fragment);
              stringBuilder1.append(": ");
              stringBuilder1.append(fragmentState.mSavedFragmentState);
            } 
            j = 1;
          } 
          i++;
        } 
        if (j == 0)
          return null; 
        j = this.mAdded.size();
        if (j > 0) {
          int[] arrayOfInt = new int[j];
          i = 0;
          while (true) {
            int[] arrayOfInt1 = arrayOfInt;
            if (i < j) {
              arrayOfInt[i] = ((Fragment)this.mAdded.get(i)).mIndex;
              if (arrayOfInt[i] < 0) {
                StringBuilder stringBuilder1 = new StringBuilder("Failure saving state: active ");
                stringBuilder1.append(this.mAdded.get(i));
                stringBuilder1.append(" has cleared index: ");
                stringBuilder1.append(arrayOfInt[i]);
                throwException(new IllegalStateException(stringBuilder1.toString()));
              } 
              if (DEBUG) {
                StringBuilder stringBuilder1 = new StringBuilder("saveAllState: adding fragment #");
                stringBuilder1.append(i);
                stringBuilder1.append(": ");
                stringBuilder1.append(this.mAdded.get(i));
              } 
              i++;
              continue;
            } 
            break;
          } 
        } else {
          arrayList = null;
        } 
        Animation animation1 = animation;
        if (this.mBackStack != null) {
          j = this.mBackStack.size();
          animation1 = animation;
          if (j > 0) {
            BackStackState[] arrayOfBackStackState = new BackStackState[j];
            i = bool;
            while (true) {
              BackStackState[] arrayOfBackStackState1 = arrayOfBackStackState;
              if (i < j) {
                arrayOfBackStackState[i] = new BackStackState(this.mBackStack.get(i));
                if (DEBUG) {
                  stringBuilder = new StringBuilder("saveAllState: adding back stack #");
                  stringBuilder.append(i);
                  stringBuilder.append(": ");
                  stringBuilder.append(this.mBackStack.get(i));
                } 
                i++;
                continue;
              } 
              break;
            } 
          } 
        } 
        FragmentManagerState fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.mActive = arrayOfFragmentState;
        fragmentManagerState.mAdded = (int[])arrayList;
        fragmentManagerState.mBackStack = (BackStackState[])stringBuilder;
        if (this.mPrimaryNav != null)
          fragmentManagerState.mPrimaryNavActiveIndex = this.mPrimaryNav.mIndex; 
        fragmentManagerState.mNextFragmentIndex = this.mNextFragmentIndex;
        saveNonConfig();
        return fragmentManagerState;
      } 
      return null;
    } 
  }
  
  public final void setPrimaryNavigationFragment(Fragment paramFragment) {
    if (paramFragment == null || (this.mActive.get(paramFragment.mIndex) == paramFragment && (paramFragment.mHost == null || paramFragment.mFragmentManager == this))) {
      this.mPrimaryNav = paramFragment;
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder("Fragment ");
    stringBuilder.append(paramFragment);
    stringBuilder.append(" is not an active fragment of FragmentManager ");
    stringBuilder.append(this);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public final String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);
    stringBuilder.append("FragmentManager{");
    stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    stringBuilder.append(" in ");
    if (this.mParent != null) {
      DebugUtils.buildShortClassTag(this.mParent, stringBuilder);
    } else {
      DebugUtils.buildShortClassTag(this.mHost, stringBuilder);
    } 
    stringBuilder.append("}}");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\app\FragmentManagerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */