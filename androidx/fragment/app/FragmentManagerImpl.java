package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.collection.ArraySet;
import androidx.core.util.DebugUtils;
import androidx.core.util.LogWriter;
import androidx.core.view.OneShotPreDrawListener;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

final class FragmentManagerImpl extends FragmentManager implements LayoutInflater.Factory2 {
  public static final int ANIM_STYLE_CLOSE_ENTER = 3;
  
  public static final int ANIM_STYLE_CLOSE_EXIT = 4;
  
  public static final int ANIM_STYLE_FADE_ENTER = 5;
  
  public static final int ANIM_STYLE_FADE_EXIT = 6;
  
  public static final int ANIM_STYLE_OPEN_ENTER = 1;
  
  public static final int ANIM_STYLE_OPEN_EXIT = 2;
  
  static final Interpolator D = (Interpolator)new DecelerateInterpolator(2.5F);
  
  static final Interpolator E = (Interpolator)new DecelerateInterpolator(1.5F);
  
  static boolean b = false;
  
  SparseArray<Parcelable> A = null;
  
  ArrayList<StartEnterTransitionListener> B;
  
  Runnable C = new Runnable(this) {
      public void run() {
        this.a.execPendingActions();
      }
    };
  
  private OnBackPressedDispatcher F;
  
  private final OnBackPressedCallback G = new OnBackPressedCallback(this, false) {
      public void handleOnBackPressed() {
        this.a.a();
      }
    };
  
  private final CopyOnWriteArrayList<FragmentLifecycleCallbacksHolder> H = new CopyOnWriteArrayList<FragmentLifecycleCallbacksHolder>();
  
  private FragmentManagerViewModel I;
  
  ArrayList<OpGenerator> c;
  
  boolean d;
  
  int e = 0;
  
  final ArrayList<Fragment> f = new ArrayList<Fragment>();
  
  final HashMap<String, Fragment> g = new HashMap<String, Fragment>();
  
  ArrayList<BackStackRecord> h;
  
  ArrayList<Fragment> i;
  
  ArrayList<BackStackRecord> j;
  
  ArrayList<Integer> k;
  
  ArrayList<FragmentManager.OnBackStackChangedListener> l;
  
  int m = 0;
  
  FragmentHostCallback n;
  
  FragmentContainer o;
  
  Fragment p;
  
  Fragment q;
  
  boolean r;
  
  boolean s;
  
  boolean t;
  
  boolean u;
  
  boolean v;
  
  ArrayList<BackStackRecord> w;
  
  ArrayList<Boolean> x;
  
  ArrayList<Fragment> y;
  
  Bundle z = null;
  
  private int a(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2, ArraySet<Fragment> paramArraySet) {
    int i = paramInt2 - 1;
    int j;
    for (j = paramInt2; i >= paramInt1; j = k) {
      boolean bool;
      BackStackRecord backStackRecord = paramArrayList.get(i);
      boolean bool1 = ((Boolean)paramArrayList1.get(i)).booleanValue();
      if (backStackRecord.b() && !backStackRecord.a(paramArrayList, i + 1, paramInt2)) {
        bool = true;
      } else {
        bool = false;
      } 
      int k = j;
      if (bool) {
        if (this.B == null)
          this.B = new ArrayList<StartEnterTransitionListener>(); 
        StartEnterTransitionListener startEnterTransitionListener = new StartEnterTransitionListener(backStackRecord, bool1);
        this.B.add(startEnterTransitionListener);
        backStackRecord.a(startEnterTransitionListener);
        if (bool1) {
          backStackRecord.a();
        } else {
          backStackRecord.b(false);
        } 
        k = j - 1;
        if (i != k) {
          paramArrayList.remove(i);
          paramArrayList.add(k, backStackRecord);
        } 
        b(paramArraySet);
      } 
      i--;
    } 
    return j;
  }
  
  static AnimationOrAnimator a(float paramFloat1, float paramFloat2) {
    AlphaAnimation alphaAnimation = new AlphaAnimation(paramFloat1, paramFloat2);
    alphaAnimation.setInterpolator(E);
    alphaAnimation.setDuration(220L);
    return new AnimationOrAnimator((Animation)alphaAnimation);
  }
  
  static AnimationOrAnimator a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    AnimationSet animationSet = new AnimationSet(false);
    ScaleAnimation scaleAnimation = new ScaleAnimation(paramFloat1, paramFloat2, paramFloat1, paramFloat2, 1, 0.5F, 1, 0.5F);
    scaleAnimation.setInterpolator(D);
    scaleAnimation.setDuration(220L);
    animationSet.addAnimation((Animation)scaleAnimation);
    AlphaAnimation alphaAnimation = new AlphaAnimation(paramFloat3, paramFloat4);
    alphaAnimation.setInterpolator(E);
    alphaAnimation.setDuration(220L);
    animationSet.addAnimation((Animation)alphaAnimation);
    return new AnimationOrAnimator((Animation)animationSet);
  }
  
  private void a(ArraySet<Fragment> paramArraySet) {
    int j = paramArraySet.size();
    for (int i = 0; i < j; i++) {
      Fragment fragment = (Fragment)paramArraySet.valueAt(i);
      if (!fragment.mAdded) {
        View view = fragment.requireView();
        fragment.mPostponedAlpha = view.getAlpha();
        view.setAlpha(0.0F);
      } 
    } 
  }
  
  private void a(Fragment paramFragment, AnimationOrAnimator paramAnimationOrAnimator, int paramInt) {
    EndViewTransitionAnimation endViewTransitionAnimation;
    View view = paramFragment.mView;
    ViewGroup viewGroup = paramFragment.mContainer;
    viewGroup.startViewTransition(view);
    paramFragment.setStateAfterAnimating(paramInt);
    if (paramAnimationOrAnimator.animation != null) {
      endViewTransitionAnimation = new EndViewTransitionAnimation(paramAnimationOrAnimator.animation, viewGroup, view);
      paramFragment.setAnimatingAway(paramFragment.mView);
      endViewTransitionAnimation.setAnimationListener(new Animation.AnimationListener(this, viewGroup, paramFragment) {
            public void onAnimationEnd(Animation param1Animation) {
              this.a.post(new Runnable(this) {
                    public void run() {
                      if (this.a.b.getAnimatingAway() != null) {
                        this.a.b.setAnimatingAway(null);
                        this.a.c.a(this.a.b, this.a.b.getStateAfterAnimating(), 0, 0, false);
                      } 
                    }
                  });
            }
            
            public void onAnimationRepeat(Animation param1Animation) {}
            
            public void onAnimationStart(Animation param1Animation) {}
          });
      paramFragment.mView.startAnimation((Animation)endViewTransitionAnimation);
      return;
    } 
    Animator animator = ((AnimationOrAnimator)endViewTransitionAnimation).animator;
    paramFragment.setAnimator(((AnimationOrAnimator)endViewTransitionAnimation).animator);
    animator.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this, viewGroup, view, paramFragment) {
          public void onAnimationEnd(Animator param1Animator) {
            this.a.endViewTransition(this.b);
            param1Animator = this.c.getAnimator();
            this.c.setAnimator(null);
            if (param1Animator != null && this.a.indexOfChild(this.b) < 0) {
              FragmentManagerImpl fragmentManagerImpl = this.d;
              Fragment fragment = this.c;
              fragmentManagerImpl.a(fragment, fragment.getStateAfterAnimating(), 0, 0, false);
            } 
          }
        });
    animator.setTarget(paramFragment.mView);
    animator.start();
  }
  
  private void a(RuntimeException paramRuntimeException) {
    Log.e("FragmentManager", paramRuntimeException.getMessage());
    Log.e("FragmentManager", "Activity state:");
    PrintWriter printWriter = new PrintWriter((Writer)new LogWriter("FragmentManager"));
    FragmentHostCallback fragmentHostCallback = this.n;
    if (fragmentHostCallback != null) {
      try {
        fragmentHostCallback.onDump("  ", (FileDescriptor)null, printWriter, new String[0]);
      } catch (Exception exception) {
        Log.e("FragmentManager", "Failed dumping state", exception);
      } 
    } else {
      try {
        dump("  ", (FileDescriptor)null, (PrintWriter)exception, new String[0]);
      } catch (Exception exception1) {
        Log.e("FragmentManager", "Failed dumping state", exception1);
      } 
    } 
    throw paramRuntimeException;
  }
  
  private void a(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1) {
    // Byte code:
    //   0: aload_0
    //   1: getfield B : Ljava/util/ArrayList;
    //   4: astore #7
    //   6: aload #7
    //   8: ifnonnull -> 16
    //   11: iconst_0
    //   12: istore_3
    //   13: goto -> 22
    //   16: aload #7
    //   18: invokevirtual size : ()I
    //   21: istore_3
    //   22: iconst_0
    //   23: istore #5
    //   25: iload_3
    //   26: istore #6
    //   28: iload #5
    //   30: iload #6
    //   32: if_icmpge -> 252
    //   35: aload_0
    //   36: getfield B : Ljava/util/ArrayList;
    //   39: iload #5
    //   41: invokevirtual get : (I)Ljava/lang/Object;
    //   44: checkcast androidx/fragment/app/FragmentManagerImpl$StartEnterTransitionListener
    //   47: astore #7
    //   49: aload_1
    //   50: ifnull -> 119
    //   53: aload #7
    //   55: getfield a : Z
    //   58: ifne -> 119
    //   61: aload_1
    //   62: aload #7
    //   64: getfield b : Landroidx/fragment/app/BackStackRecord;
    //   67: invokevirtual indexOf : (Ljava/lang/Object;)I
    //   70: istore_3
    //   71: iload_3
    //   72: iconst_m1
    //   73: if_icmpeq -> 119
    //   76: aload_2
    //   77: iload_3
    //   78: invokevirtual get : (I)Ljava/lang/Object;
    //   81: checkcast java/lang/Boolean
    //   84: invokevirtual booleanValue : ()Z
    //   87: ifeq -> 119
    //   90: aload_0
    //   91: getfield B : Ljava/util/ArrayList;
    //   94: iload #5
    //   96: invokevirtual remove : (I)Ljava/lang/Object;
    //   99: pop
    //   100: iload #5
    //   102: iconst_1
    //   103: isub
    //   104: istore_3
    //   105: iload #6
    //   107: iconst_1
    //   108: isub
    //   109: istore #4
    //   111: aload #7
    //   113: invokevirtual cancelTransaction : ()V
    //   116: goto -> 240
    //   119: aload #7
    //   121: invokevirtual isReady : ()Z
    //   124: ifne -> 162
    //   127: iload #5
    //   129: istore_3
    //   130: iload #6
    //   132: istore #4
    //   134: aload_1
    //   135: ifnull -> 240
    //   138: iload #5
    //   140: istore_3
    //   141: iload #6
    //   143: istore #4
    //   145: aload #7
    //   147: getfield b : Landroidx/fragment/app/BackStackRecord;
    //   150: aload_1
    //   151: iconst_0
    //   152: aload_1
    //   153: invokevirtual size : ()I
    //   156: invokevirtual a : (Ljava/util/ArrayList;II)Z
    //   159: ifeq -> 240
    //   162: aload_0
    //   163: getfield B : Ljava/util/ArrayList;
    //   166: iload #5
    //   168: invokevirtual remove : (I)Ljava/lang/Object;
    //   171: pop
    //   172: iload #5
    //   174: iconst_1
    //   175: isub
    //   176: istore_3
    //   177: iload #6
    //   179: iconst_1
    //   180: isub
    //   181: istore #4
    //   183: aload_1
    //   184: ifnull -> 235
    //   187: aload #7
    //   189: getfield a : Z
    //   192: ifne -> 235
    //   195: aload_1
    //   196: aload #7
    //   198: getfield b : Landroidx/fragment/app/BackStackRecord;
    //   201: invokevirtual indexOf : (Ljava/lang/Object;)I
    //   204: istore #5
    //   206: iload #5
    //   208: iconst_m1
    //   209: if_icmpeq -> 235
    //   212: aload_2
    //   213: iload #5
    //   215: invokevirtual get : (I)Ljava/lang/Object;
    //   218: checkcast java/lang/Boolean
    //   221: invokevirtual booleanValue : ()Z
    //   224: ifeq -> 235
    //   227: aload #7
    //   229: invokevirtual cancelTransaction : ()V
    //   232: goto -> 240
    //   235: aload #7
    //   237: invokevirtual completeTransaction : ()V
    //   240: iload_3
    //   241: iconst_1
    //   242: iadd
    //   243: istore #5
    //   245: iload #4
    //   247: istore #6
    //   249: goto -> 28
    //   252: return
  }
  
  private void a(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2) {
    int i = paramInt1;
    boolean bool1 = ((BackStackRecord)paramArrayList.get(i)).t;
    ArrayList<Fragment> arrayList = this.y;
    if (arrayList == null) {
      this.y = new ArrayList<Fragment>();
    } else {
      arrayList.clear();
    } 
    this.y.addAll(this.f);
    Fragment fragment = getPrimaryNavigationFragment();
    int j = i;
    boolean bool = false;
    while (j < paramInt2) {
      BackStackRecord backStackRecord = paramArrayList.get(j);
      if (!((Boolean)paramArrayList1.get(j)).booleanValue()) {
        fragment = backStackRecord.a(this.y, fragment);
      } else {
        fragment = backStackRecord.b(this.y, fragment);
      } 
      if (bool || backStackRecord.k) {
        bool = true;
      } else {
        bool = false;
      } 
      j++;
    } 
    this.y.clear();
    if (!bool1)
      FragmentTransition.a(this, paramArrayList, paramArrayList1, paramInt1, paramInt2, false); 
    b(paramArrayList, paramArrayList1, paramInt1, paramInt2);
    if (bool1) {
      ArraySet<Fragment> arraySet = new ArraySet();
      b(arraySet);
      j = a(paramArrayList, paramArrayList1, paramInt1, paramInt2, arraySet);
      a(arraySet);
    } else {
      j = paramInt2;
    } 
    int k = i;
    if (j != i) {
      k = i;
      if (bool1) {
        FragmentTransition.a(this, paramArrayList, paramArrayList1, paramInt1, j, true);
        a(this.m, true);
        k = i;
      } 
    } 
    while (k < paramInt2) {
      BackStackRecord backStackRecord = paramArrayList.get(k);
      if (((Boolean)paramArrayList1.get(k)).booleanValue() && backStackRecord.c >= 0) {
        freeBackStackIndex(backStackRecord.c);
        backStackRecord.c = -1;
      } 
      backStackRecord.runOnCommitRunnables();
      k++;
    } 
    if (bool)
      g(); 
  }
  
  private void a(boolean paramBoolean) {
    if (!this.d) {
      if (this.n != null) {
        if (Looper.myLooper() == this.n.c().getLooper()) {
          if (!paramBoolean)
            n(); 
          if (this.w == null) {
            this.w = new ArrayList<BackStackRecord>();
            this.x = new ArrayList<Boolean>();
          } 
          this.d = true;
          try {
            a((ArrayList<BackStackRecord>)null, (ArrayList<Boolean>)null);
            return;
          } finally {
            this.d = false;
          } 
        } 
        throw new IllegalStateException("Must be called from main thread of fragment host");
      } 
      throw new IllegalStateException("Fragment host has been destroyed");
    } 
    throw new IllegalStateException("FragmentManager is already executing transactions");
  }
  
  private boolean a(String paramString, int paramInt1, int paramInt2) {
    execPendingActions();
    a(true);
    Fragment fragment = this.q;
    if (fragment != null && paramInt1 < 0 && paramString == null && fragment.getChildFragmentManager().popBackStackImmediate())
      return true; 
    boolean bool = a(this.w, this.x, paramString, paramInt1, paramInt2);
    if (bool) {
      this.d = true;
      try {
        b(this.w, this.x);
      } finally {
        o();
      } 
    } 
    m();
    f();
    r();
    return bool;
  }
  
  private void b(int paramInt) {
    try {
      this.d = true;
      a(paramInt, false);
      this.d = false;
      return;
    } finally {
      this.d = false;
    } 
  }
  
  private void b(ArraySet<Fragment> paramArraySet) {
    int i = this.m;
    if (i < 1)
      return; 
    int j = Math.min(i, 3);
    int k = this.f.size();
    for (i = 0; i < k; i++) {
      Fragment fragment = this.f.get(i);
      if (fragment.mState < j) {
        a(fragment, j, fragment.getNextAnim(), fragment.getNextTransition(), false);
        if (fragment.mView != null && !fragment.mHidden && fragment.mIsNewlyAdded)
          paramArraySet.add(fragment); 
      } 
    } 
  }
  
  private void b(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1) {
    if (paramArrayList != null) {
      if (paramArrayList.isEmpty())
        return; 
      if (paramArrayList1 != null && paramArrayList.size() == paramArrayList1.size()) {
        a(paramArrayList, paramArrayList1);
        int k = paramArrayList.size();
        int i = 0;
        int j;
        for (j = 0; i < k; j = m) {
          int n = i;
          int m = j;
          if (!((BackStackRecord)paramArrayList.get(i)).t) {
            if (j != i)
              a(paramArrayList, paramArrayList1, j, i); 
            j = i + 1;
            m = j;
            if (((Boolean)paramArrayList1.get(i)).booleanValue())
              while (true) {
                m = j;
                if (j < k) {
                  m = j;
                  if (((Boolean)paramArrayList1.get(j)).booleanValue()) {
                    m = j;
                    if (!((BackStackRecord)paramArrayList.get(j)).t) {
                      j++;
                      continue;
                    } 
                  } 
                } 
                break;
              }  
            a(paramArrayList, paramArrayList1, i, m);
            n = m - 1;
          } 
          i = n + 1;
        } 
        if (j != k)
          a(paramArrayList, paramArrayList1, j, k); 
        return;
      } 
      throw new IllegalStateException("Internal error with the back stack records");
    } 
  }
  
  private static void b(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2) {
    while (paramInt1 < paramInt2) {
      BackStackRecord backStackRecord = paramArrayList.get(paramInt1);
      boolean bool1 = ((Boolean)paramArrayList1.get(paramInt1)).booleanValue();
      boolean bool = true;
      if (bool1) {
        backStackRecord.a(-1);
        if (paramInt1 != paramInt2 - 1)
          bool = false; 
        backStackRecord.b(bool);
      } else {
        backStackRecord.a(1);
        backStackRecord.a();
      } 
      paramInt1++;
    } 
  }
  
  private boolean c(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield c : Ljava/util/ArrayList;
    //   6: astore #6
    //   8: iconst_0
    //   9: istore_3
    //   10: aload #6
    //   12: ifnull -> 102
    //   15: aload_0
    //   16: getfield c : Ljava/util/ArrayList;
    //   19: invokevirtual size : ()I
    //   22: ifne -> 28
    //   25: goto -> 102
    //   28: aload_0
    //   29: getfield c : Ljava/util/ArrayList;
    //   32: invokevirtual size : ()I
    //   35: istore #4
    //   37: iconst_0
    //   38: istore #5
    //   40: iload_3
    //   41: iload #4
    //   43: if_icmpge -> 76
    //   46: iload #5
    //   48: aload_0
    //   49: getfield c : Ljava/util/ArrayList;
    //   52: iload_3
    //   53: invokevirtual get : (I)Ljava/lang/Object;
    //   56: checkcast androidx/fragment/app/FragmentManagerImpl$OpGenerator
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
    //   77: getfield c : Ljava/util/ArrayList;
    //   80: invokevirtual clear : ()V
    //   83: aload_0
    //   84: getfield n : Landroidx/fragment/app/FragmentHostCallback;
    //   87: invokevirtual c : ()Landroid/os/Handler;
    //   90: aload_0
    //   91: getfield C : Ljava/lang/Runnable;
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
  
  private void m() {
    ArrayList<OpGenerator> arrayList = this.c;
    boolean bool = true;
    if (arrayList != null && !arrayList.isEmpty()) {
      this.G.setEnabled(true);
      return;
    } 
    OnBackPressedCallback onBackPressedCallback = this.G;
    if (getBackStackEntryCount() <= 0 || !a(this.p))
      bool = false; 
    onBackPressedCallback.setEnabled(bool);
  }
  
  private Fragment n(Fragment paramFragment) {
    ViewGroup viewGroup = paramFragment.mContainer;
    View view = paramFragment.mView;
    if (viewGroup != null) {
      if (view == null)
        return null; 
      for (int i = this.f.indexOf(paramFragment) - 1; i >= 0; i--) {
        paramFragment = this.f.get(i);
        if (paramFragment.mContainer == viewGroup && paramFragment.mView != null)
          return paramFragment; 
      } 
    } 
    return null;
  }
  
  private void n() {
    if (!isStateSaved())
      return; 
    throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
  }
  
  private void o() {
    this.d = false;
    this.x.clear();
    this.w.clear();
  }
  
  private void o(Fragment paramFragment) {
    if (paramFragment != null && this.g.get(paramFragment.mWho) == paramFragment)
      paramFragment.performPrimaryNavigationFragmentChanged(); 
  }
  
  private void p() {
    if (this.B != null)
      while (!this.B.isEmpty())
        ((StartEnterTransitionListener)this.B.remove(0)).completeTransaction();  
  }
  
  private boolean p(Fragment paramFragment) {
    return ((paramFragment.mHasMenu && paramFragment.mMenuVisible) || paramFragment.mChildFragmentManager.k());
  }
  
  private void q() {
    for (Fragment fragment : this.g.values()) {
      if (fragment != null) {
        if (fragment.getAnimatingAway() != null) {
          int i = fragment.getStateAfterAnimating();
          View view = fragment.getAnimatingAway();
          Animation animation = view.getAnimation();
          if (animation != null) {
            animation.cancel();
            view.clearAnimation();
          } 
          fragment.setAnimatingAway(null);
          a(fragment, i, 0, 0, false);
          continue;
        } 
        if (fragment.getAnimator() != null)
          fragment.getAnimator().end(); 
      } 
    } 
  }
  
  private void r() {
    this.g.values().removeAll(Collections.singleton(null));
  }
  
  public static int reverseTransit(int paramInt) {
    char c = ' ';
    if (paramInt != 4097) {
      if (paramInt != 4099)
        return (paramInt != 8194) ? 0 : 4097; 
      c = 'ဃ';
    } 
    return c;
  }
  
  public static int transitToStyleIndex(int paramInt, boolean paramBoolean) {
    return (paramInt != 4097) ? ((paramInt != 4099) ? ((paramInt != 8194) ? -1 : (paramBoolean ? 3 : 4)) : (paramBoolean ? 5 : 6)) : (paramBoolean ? 1 : 2);
  }
  
  AnimationOrAnimator a(Fragment paramFragment, int paramInt1, boolean paramBoolean, int paramInt2) {
    int i = paramFragment.getNextAnim();
    boolean bool = false;
    paramFragment.setNextAnim(0);
    if (paramFragment.mContainer != null && paramFragment.mContainer.getLayoutTransition() != null)
      return null; 
    Animation animation = paramFragment.onCreateAnimation(paramInt1, paramBoolean, i);
    if (animation != null)
      return new AnimationOrAnimator(animation); 
    Animator animator = paramFragment.onCreateAnimator(paramInt1, paramBoolean, i);
    if (animator != null)
      return new AnimationOrAnimator(animator); 
    if (i != 0) {
      boolean bool2 = "anim".equals(this.n.b().getResources().getResourceTypeName(i));
      boolean bool1 = bool;
      if (bool2)
        try {
          Animation animation1 = AnimationUtils.loadAnimation(this.n.b(), i);
          if (animation1 != null)
            return new AnimationOrAnimator(animation1); 
          bool1 = true;
        } catch (android.content.res.Resources.NotFoundException notFoundException) {
          throw notFoundException;
        } catch (RuntimeException runtimeException) {
          bool1 = bool;
        }  
      if (!bool1)
        try {
          animator = AnimatorInflater.loadAnimator(this.n.b(), i);
          if (animator != null)
            return new AnimationOrAnimator(animator); 
        } catch (RuntimeException runtimeException) {
          Animation animation1;
          if (!bool2) {
            animation1 = AnimationUtils.loadAnimation(this.n.b(), i);
            if (animation1 != null)
              return new AnimationOrAnimator(animation1); 
          } else {
            throw animation1;
          } 
        }  
    } 
    if (paramInt1 == 0)
      return null; 
    paramInt1 = transitToStyleIndex(paramInt1, paramBoolean);
    if (paramInt1 < 0)
      return null; 
    switch (paramInt1) {
      default:
        paramInt1 = paramInt2;
        if (paramInt2 == 0) {
          paramInt1 = paramInt2;
          if (this.n.onHasWindowAnimations())
            paramInt1 = this.n.onGetWindowAnimations(); 
        } 
        break;
      case 6:
        return a(1.0F, 0.0F);
      case 5:
        return a(0.0F, 1.0F);
      case 4:
        return a(1.0F, 1.075F, 1.0F, 0.0F);
      case 3:
        return a(0.975F, 1.0F, 0.0F, 1.0F);
      case 2:
        return a(1.0F, 0.975F, 1.0F, 0.0F);
      case 1:
        return a(1.125F, 1.0F, 0.0F, 1.0F);
    } 
    if (paramInt1 == 0);
    return null;
  }
  
  void a() {
    execPendingActions();
    if (this.G.isEnabled()) {
      popBackStackImmediate();
      return;
    } 
    this.F.onBackPressed();
  }
  
  void a(int paramInt, boolean paramBoolean) {
    if (this.n != null || paramInt == 0) {
      if (!paramBoolean && paramInt == this.m)
        return; 
      this.m = paramInt;
      int i = this.f.size();
      for (paramInt = 0; paramInt < i; paramInt++)
        i(this.f.get(paramInt)); 
      for (Fragment fragment : this.g.values()) {
        if (fragment != null && (fragment.mRemoving || fragment.mDetached) && !fragment.mIsNewlyAdded)
          i(fragment); 
      } 
      d();
      if (this.r) {
        FragmentHostCallback fragmentHostCallback = this.n;
        if (fragmentHostCallback != null && this.m == 4) {
          fragmentHostCallback.onSupportInvalidateOptionsMenu();
          this.r = false;
        } 
      } 
      return;
    } 
    throw new IllegalStateException("No activity");
  }
  
  void a(Parcelable paramParcelable) {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull -> 5
    //   4: return
    //   5: aload_1
    //   6: checkcast androidx/fragment/app/FragmentManagerState
    //   9: astore #4
    //   11: aload #4
    //   13: getfield a : Ljava/util/ArrayList;
    //   16: ifnonnull -> 20
    //   19: return
    //   20: aload_0
    //   21: getfield I : Landroidx/fragment/app/FragmentManagerViewModel;
    //   24: invokevirtual b : ()Ljava/util/Collection;
    //   27: invokeinterface iterator : ()Ljava/util/Iterator;
    //   32: astore #5
    //   34: aload #5
    //   36: invokeinterface hasNext : ()Z
    //   41: ifeq -> 350
    //   44: aload #5
    //   46: invokeinterface next : ()Ljava/lang/Object;
    //   51: checkcast androidx/fragment/app/Fragment
    //   54: astore #6
    //   56: getstatic androidx/fragment/app/FragmentManagerImpl.b : Z
    //   59: ifeq -> 96
    //   62: new java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial <init> : ()V
    //   69: astore_1
    //   70: aload_1
    //   71: ldc_w 'restoreSaveState: re-attaching retained '
    //   74: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload_1
    //   79: aload #6
    //   81: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: ldc_w 'FragmentManager'
    //   88: aload_1
    //   89: invokevirtual toString : ()Ljava/lang/String;
    //   92: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   95: pop
    //   96: aload #4
    //   98: getfield a : Ljava/util/ArrayList;
    //   101: invokevirtual iterator : ()Ljava/util/Iterator;
    //   104: astore_3
    //   105: aload_3
    //   106: invokeinterface hasNext : ()Z
    //   111: ifeq -> 142
    //   114: aload_3
    //   115: invokeinterface next : ()Ljava/lang/Object;
    //   120: checkcast androidx/fragment/app/FragmentState
    //   123: astore_1
    //   124: aload_1
    //   125: getfield b : Ljava/lang/String;
    //   128: aload #6
    //   130: getfield mWho : Ljava/lang/String;
    //   133: invokevirtual equals : (Ljava/lang/Object;)Z
    //   136: ifeq -> 105
    //   139: goto -> 144
    //   142: aconst_null
    //   143: astore_1
    //   144: aload_1
    //   145: ifnonnull -> 235
    //   148: getstatic androidx/fragment/app/FragmentManagerImpl.b : Z
    //   151: ifeq -> 206
    //   154: new java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial <init> : ()V
    //   161: astore_1
    //   162: aload_1
    //   163: ldc_w 'Discarding retained Fragment '
    //   166: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload_1
    //   171: aload #6
    //   173: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload_1
    //   178: ldc_w ' that was not found in the set of active Fragments '
    //   181: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload_1
    //   186: aload #4
    //   188: getfield a : Ljava/util/ArrayList;
    //   191: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: ldc_w 'FragmentManager'
    //   198: aload_1
    //   199: invokevirtual toString : ()Ljava/lang/String;
    //   202: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   205: pop
    //   206: aload_0
    //   207: aload #6
    //   209: iconst_1
    //   210: iconst_0
    //   211: iconst_0
    //   212: iconst_0
    //   213: invokevirtual a : (Landroidx/fragment/app/Fragment;IIIZ)V
    //   216: aload #6
    //   218: iconst_1
    //   219: putfield mRemoving : Z
    //   222: aload_0
    //   223: aload #6
    //   225: iconst_0
    //   226: iconst_0
    //   227: iconst_0
    //   228: iconst_0
    //   229: invokevirtual a : (Landroidx/fragment/app/Fragment;IIIZ)V
    //   232: goto -> 34
    //   235: aload_1
    //   236: aload #6
    //   238: putfield n : Landroidx/fragment/app/Fragment;
    //   241: aload #6
    //   243: aconst_null
    //   244: putfield mSavedViewState : Landroid/util/SparseArray;
    //   247: aload #6
    //   249: iconst_0
    //   250: putfield mBackStackNesting : I
    //   253: aload #6
    //   255: iconst_0
    //   256: putfield mInLayout : Z
    //   259: aload #6
    //   261: iconst_0
    //   262: putfield mAdded : Z
    //   265: aload #6
    //   267: getfield mTarget : Landroidx/fragment/app/Fragment;
    //   270: ifnull -> 285
    //   273: aload #6
    //   275: getfield mTarget : Landroidx/fragment/app/Fragment;
    //   278: getfield mWho : Ljava/lang/String;
    //   281: astore_3
    //   282: goto -> 287
    //   285: aconst_null
    //   286: astore_3
    //   287: aload #6
    //   289: aload_3
    //   290: putfield mTargetWho : Ljava/lang/String;
    //   293: aload #6
    //   295: aconst_null
    //   296: putfield mTarget : Landroidx/fragment/app/Fragment;
    //   299: aload_1
    //   300: getfield m : Landroid/os/Bundle;
    //   303: ifnull -> 34
    //   306: aload_1
    //   307: getfield m : Landroid/os/Bundle;
    //   310: aload_0
    //   311: getfield n : Landroidx/fragment/app/FragmentHostCallback;
    //   314: invokevirtual b : ()Landroid/content/Context;
    //   317: invokevirtual getClassLoader : ()Ljava/lang/ClassLoader;
    //   320: invokevirtual setClassLoader : (Ljava/lang/ClassLoader;)V
    //   323: aload #6
    //   325: aload_1
    //   326: getfield m : Landroid/os/Bundle;
    //   329: ldc_w 'android:view_state'
    //   332: invokevirtual getSparseParcelableArray : (Ljava/lang/String;)Landroid/util/SparseArray;
    //   335: putfield mSavedViewState : Landroid/util/SparseArray;
    //   338: aload #6
    //   340: aload_1
    //   341: getfield m : Landroid/os/Bundle;
    //   344: putfield mSavedFragmentState : Landroid/os/Bundle;
    //   347: goto -> 34
    //   350: aload_0
    //   351: getfield g : Ljava/util/HashMap;
    //   354: invokevirtual clear : ()V
    //   357: aload #4
    //   359: getfield a : Ljava/util/ArrayList;
    //   362: invokevirtual iterator : ()Ljava/util/Iterator;
    //   365: astore_1
    //   366: aload_1
    //   367: invokeinterface hasNext : ()Z
    //   372: ifeq -> 502
    //   375: aload_1
    //   376: invokeinterface next : ()Ljava/lang/Object;
    //   381: checkcast androidx/fragment/app/FragmentState
    //   384: astore_3
    //   385: aload_3
    //   386: ifnull -> 366
    //   389: aload_3
    //   390: aload_0
    //   391: getfield n : Landroidx/fragment/app/FragmentHostCallback;
    //   394: invokevirtual b : ()Landroid/content/Context;
    //   397: invokevirtual getClassLoader : ()Ljava/lang/ClassLoader;
    //   400: aload_0
    //   401: invokevirtual getFragmentFactory : ()Landroidx/fragment/app/FragmentFactory;
    //   404: invokevirtual instantiate : (Ljava/lang/ClassLoader;Landroidx/fragment/app/FragmentFactory;)Landroidx/fragment/app/Fragment;
    //   407: astore #5
    //   409: aload #5
    //   411: aload_0
    //   412: putfield mFragmentManager : Landroidx/fragment/app/FragmentManagerImpl;
    //   415: getstatic androidx/fragment/app/FragmentManagerImpl.b : Z
    //   418: ifeq -> 479
    //   421: new java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial <init> : ()V
    //   428: astore #6
    //   430: aload #6
    //   432: ldc_w 'restoreSaveState: active ('
    //   435: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: pop
    //   439: aload #6
    //   441: aload #5
    //   443: getfield mWho : Ljava/lang/String;
    //   446: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: pop
    //   450: aload #6
    //   452: ldc_w '): '
    //   455: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: pop
    //   459: aload #6
    //   461: aload #5
    //   463: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   466: pop
    //   467: ldc_w 'FragmentManager'
    //   470: aload #6
    //   472: invokevirtual toString : ()Ljava/lang/String;
    //   475: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   478: pop
    //   479: aload_0
    //   480: getfield g : Ljava/util/HashMap;
    //   483: aload #5
    //   485: getfield mWho : Ljava/lang/String;
    //   488: aload #5
    //   490: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   493: pop
    //   494: aload_3
    //   495: aconst_null
    //   496: putfield n : Landroidx/fragment/app/Fragment;
    //   499: goto -> 366
    //   502: aload_0
    //   503: getfield f : Ljava/util/ArrayList;
    //   506: invokevirtual clear : ()V
    //   509: aload #4
    //   511: getfield b : Ljava/util/ArrayList;
    //   514: ifnull -> 754
    //   517: aload #4
    //   519: getfield b : Ljava/util/ArrayList;
    //   522: invokevirtual iterator : ()Ljava/util/Iterator;
    //   525: astore_3
    //   526: aload_3
    //   527: invokeinterface hasNext : ()Z
    //   532: ifeq -> 754
    //   535: aload_3
    //   536: invokeinterface next : ()Ljava/lang/Object;
    //   541: checkcast java/lang/String
    //   544: astore #5
    //   546: aload_0
    //   547: getfield g : Ljava/util/HashMap;
    //   550: aload #5
    //   552: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   555: checkcast androidx/fragment/app/Fragment
    //   558: astore_1
    //   559: aload_1
    //   560: ifnonnull -> 614
    //   563: new java/lang/StringBuilder
    //   566: dup
    //   567: invokespecial <init> : ()V
    //   570: astore #6
    //   572: aload #6
    //   574: ldc_w 'No instantiated fragment for ('
    //   577: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: pop
    //   581: aload #6
    //   583: aload #5
    //   585: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: pop
    //   589: aload #6
    //   591: ldc_w ')'
    //   594: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: pop
    //   598: aload_0
    //   599: new java/lang/IllegalStateException
    //   602: dup
    //   603: aload #6
    //   605: invokevirtual toString : ()Ljava/lang/String;
    //   608: invokespecial <init> : (Ljava/lang/String;)V
    //   611: invokespecial a : (Ljava/lang/RuntimeException;)V
    //   614: aload_1
    //   615: iconst_1
    //   616: putfield mAdded : Z
    //   619: getstatic androidx/fragment/app/FragmentManagerImpl.b : Z
    //   622: ifeq -> 679
    //   625: new java/lang/StringBuilder
    //   628: dup
    //   629: invokespecial <init> : ()V
    //   632: astore #6
    //   634: aload #6
    //   636: ldc_w 'restoreSaveState: added ('
    //   639: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: pop
    //   643: aload #6
    //   645: aload #5
    //   647: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   650: pop
    //   651: aload #6
    //   653: ldc_w '): '
    //   656: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: pop
    //   660: aload #6
    //   662: aload_1
    //   663: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   666: pop
    //   667: ldc_w 'FragmentManager'
    //   670: aload #6
    //   672: invokevirtual toString : ()Ljava/lang/String;
    //   675: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   678: pop
    //   679: aload_0
    //   680: getfield f : Ljava/util/ArrayList;
    //   683: aload_1
    //   684: invokevirtual contains : (Ljava/lang/Object;)Z
    //   687: ifne -> 720
    //   690: aload_0
    //   691: getfield f : Ljava/util/ArrayList;
    //   694: astore #5
    //   696: aload #5
    //   698: monitorenter
    //   699: aload_0
    //   700: getfield f : Ljava/util/ArrayList;
    //   703: aload_1
    //   704: invokevirtual add : (Ljava/lang/Object;)Z
    //   707: pop
    //   708: aload #5
    //   710: monitorexit
    //   711: goto -> 526
    //   714: astore_1
    //   715: aload #5
    //   717: monitorexit
    //   718: aload_1
    //   719: athrow
    //   720: new java/lang/StringBuilder
    //   723: dup
    //   724: invokespecial <init> : ()V
    //   727: astore_3
    //   728: aload_3
    //   729: ldc_w 'Already added '
    //   732: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: pop
    //   736: aload_3
    //   737: aload_1
    //   738: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   741: pop
    //   742: new java/lang/IllegalStateException
    //   745: dup
    //   746: aload_3
    //   747: invokevirtual toString : ()Ljava/lang/String;
    //   750: invokespecial <init> : (Ljava/lang/String;)V
    //   753: athrow
    //   754: aload #4
    //   756: getfield c : [Landroidx/fragment/app/BackStackState;
    //   759: ifnull -> 936
    //   762: aload_0
    //   763: new java/util/ArrayList
    //   766: dup
    //   767: aload #4
    //   769: getfield c : [Landroidx/fragment/app/BackStackState;
    //   772: arraylength
    //   773: invokespecial <init> : (I)V
    //   776: putfield h : Ljava/util/ArrayList;
    //   779: iconst_0
    //   780: istore_2
    //   781: iload_2
    //   782: aload #4
    //   784: getfield c : [Landroidx/fragment/app/BackStackState;
    //   787: arraylength
    //   788: if_icmpge -> 941
    //   791: aload #4
    //   793: getfield c : [Landroidx/fragment/app/BackStackState;
    //   796: iload_2
    //   797: aaload
    //   798: aload_0
    //   799: invokevirtual instantiate : (Landroidx/fragment/app/FragmentManagerImpl;)Landroidx/fragment/app/BackStackRecord;
    //   802: astore_1
    //   803: getstatic androidx/fragment/app/FragmentManagerImpl.b : Z
    //   806: ifeq -> 904
    //   809: new java/lang/StringBuilder
    //   812: dup
    //   813: invokespecial <init> : ()V
    //   816: astore_3
    //   817: aload_3
    //   818: ldc_w 'restoreAllState: back stack #'
    //   821: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   824: pop
    //   825: aload_3
    //   826: iload_2
    //   827: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   830: pop
    //   831: aload_3
    //   832: ldc_w ' (index '
    //   835: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   838: pop
    //   839: aload_3
    //   840: aload_1
    //   841: getfield c : I
    //   844: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   847: pop
    //   848: aload_3
    //   849: ldc_w '): '
    //   852: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   855: pop
    //   856: aload_3
    //   857: aload_1
    //   858: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   861: pop
    //   862: ldc_w 'FragmentManager'
    //   865: aload_3
    //   866: invokevirtual toString : ()Ljava/lang/String;
    //   869: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   872: pop
    //   873: new java/io/PrintWriter
    //   876: dup
    //   877: new androidx/core/util/LogWriter
    //   880: dup
    //   881: ldc_w 'FragmentManager'
    //   884: invokespecial <init> : (Ljava/lang/String;)V
    //   887: invokespecial <init> : (Ljava/io/Writer;)V
    //   890: astore_3
    //   891: aload_1
    //   892: ldc_w '  '
    //   895: aload_3
    //   896: iconst_0
    //   897: invokevirtual dump : (Ljava/lang/String;Ljava/io/PrintWriter;Z)V
    //   900: aload_3
    //   901: invokevirtual close : ()V
    //   904: aload_0
    //   905: getfield h : Ljava/util/ArrayList;
    //   908: aload_1
    //   909: invokevirtual add : (Ljava/lang/Object;)Z
    //   912: pop
    //   913: aload_1
    //   914: getfield c : I
    //   917: iflt -> 929
    //   920: aload_0
    //   921: aload_1
    //   922: getfield c : I
    //   925: aload_1
    //   926: invokevirtual setBackStackIndex : (ILandroidx/fragment/app/BackStackRecord;)V
    //   929: iload_2
    //   930: iconst_1
    //   931: iadd
    //   932: istore_2
    //   933: goto -> 781
    //   936: aload_0
    //   937: aconst_null
    //   938: putfield h : Ljava/util/ArrayList;
    //   941: aload #4
    //   943: getfield d : Ljava/lang/String;
    //   946: ifnull -> 976
    //   949: aload_0
    //   950: aload_0
    //   951: getfield g : Ljava/util/HashMap;
    //   954: aload #4
    //   956: getfield d : Ljava/lang/String;
    //   959: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   962: checkcast androidx/fragment/app/Fragment
    //   965: putfield q : Landroidx/fragment/app/Fragment;
    //   968: aload_0
    //   969: aload_0
    //   970: getfield q : Landroidx/fragment/app/Fragment;
    //   973: invokespecial o : (Landroidx/fragment/app/Fragment;)V
    //   976: aload_0
    //   977: aload #4
    //   979: getfield e : I
    //   982: putfield e : I
    //   985: return
    // Exception table:
    //   from	to	target	type
    //   699	711	714	finally
    //   715	718	714	finally
  }
  
  void a(Parcelable paramParcelable, FragmentManagerNonConfig paramFragmentManagerNonConfig) {
    if (this.n instanceof ViewModelStoreOwner)
      a(new IllegalStateException("You must use restoreSaveState when your FragmentHostCallback implements ViewModelStoreOwner")); 
    this.I.a(paramFragmentManagerNonConfig);
    a(paramParcelable);
  }
  
  void a(BackStackRecord paramBackStackRecord) {
    if (this.h == null)
      this.h = new ArrayList<BackStackRecord>(); 
    this.h.add(paramBackStackRecord);
  }
  
  void a(BackStackRecord paramBackStackRecord, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    if (paramBoolean1) {
      paramBackStackRecord.b(paramBoolean3);
    } else {
      paramBackStackRecord.a();
    } 
    ArrayList<BackStackRecord> arrayList = new ArrayList(1);
    ArrayList<Boolean> arrayList1 = new ArrayList(1);
    arrayList.add(paramBackStackRecord);
    arrayList1.add(Boolean.valueOf(paramBoolean1));
    if (paramBoolean2)
      FragmentTransition.a(this, arrayList, arrayList1, 0, 1, true); 
    if (paramBoolean3)
      a(this.m, true); 
    for (Fragment fragment : this.g.values()) {
      if (fragment != null && fragment.mView != null && fragment.mIsNewlyAdded && paramBackStackRecord.b(fragment.mContainerId)) {
        if (fragment.mPostponedAlpha > 0.0F)
          fragment.mView.setAlpha(fragment.mPostponedAlpha); 
        if (paramBoolean3) {
          fragment.mPostponedAlpha = 0.0F;
          continue;
        } 
        fragment.mPostponedAlpha = -1.0F;
        fragment.mIsNewlyAdded = false;
      } 
    } 
  }
  
  void a(Fragment paramFragment, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
    // Byte code:
    //   0: aload_1
    //   1: getfield mAdded : Z
    //   4: istore #10
    //   6: iconst_1
    //   7: istore #9
    //   9: iconst_1
    //   10: istore #7
    //   12: iconst_1
    //   13: istore #8
    //   15: iload #10
    //   17: ifeq -> 33
    //   20: aload_1
    //   21: getfield mDetached : Z
    //   24: ifeq -> 30
    //   27: goto -> 33
    //   30: goto -> 47
    //   33: iload_2
    //   34: istore #6
    //   36: iload #6
    //   38: istore_2
    //   39: iload #6
    //   41: iconst_1
    //   42: if_icmple -> 47
    //   45: iconst_1
    //   46: istore_2
    //   47: iload_2
    //   48: istore #6
    //   50: aload_1
    //   51: getfield mRemoving : Z
    //   54: ifeq -> 94
    //   57: iload_2
    //   58: istore #6
    //   60: iload_2
    //   61: aload_1
    //   62: getfield mState : I
    //   65: if_icmple -> 94
    //   68: aload_1
    //   69: getfield mState : I
    //   72: ifne -> 88
    //   75: aload_1
    //   76: invokevirtual isInBackStack : ()Z
    //   79: ifeq -> 88
    //   82: iconst_1
    //   83: istore #6
    //   85: goto -> 94
    //   88: aload_1
    //   89: getfield mState : I
    //   92: istore #6
    //   94: iload #6
    //   96: istore_2
    //   97: aload_1
    //   98: getfield mDeferStart : Z
    //   101: ifeq -> 126
    //   104: iload #6
    //   106: istore_2
    //   107: aload_1
    //   108: getfield mState : I
    //   111: iconst_3
    //   112: if_icmpge -> 126
    //   115: iload #6
    //   117: istore_2
    //   118: iload #6
    //   120: iconst_2
    //   121: if_icmple -> 126
    //   124: iconst_2
    //   125: istore_2
    //   126: aload_1
    //   127: getfield mMaxState : Landroidx/lifecycle/Lifecycle$State;
    //   130: getstatic androidx/lifecycle/Lifecycle$State.CREATED : Landroidx/lifecycle/Lifecycle$State;
    //   133: if_acmpne -> 145
    //   136: iload_2
    //   137: iconst_1
    //   138: invokestatic min : (II)I
    //   141: istore_2
    //   142: goto -> 157
    //   145: iload_2
    //   146: aload_1
    //   147: getfield mMaxState : Landroidx/lifecycle/Lifecycle$State;
    //   150: invokevirtual ordinal : ()I
    //   153: invokestatic min : (II)I
    //   156: istore_2
    //   157: aload_1
    //   158: getfield mState : I
    //   161: iload_2
    //   162: if_icmpgt -> 1502
    //   165: aload_1
    //   166: getfield mFromLayout : Z
    //   169: ifeq -> 180
    //   172: aload_1
    //   173: getfield mInLayout : Z
    //   176: ifne -> 180
    //   179: return
    //   180: aload_1
    //   181: invokevirtual getAnimatingAway : ()Landroid/view/View;
    //   184: ifnonnull -> 194
    //   187: aload_1
    //   188: invokevirtual getAnimator : ()Landroid/animation/Animator;
    //   191: ifnull -> 216
    //   194: aload_1
    //   195: aconst_null
    //   196: invokevirtual setAnimatingAway : (Landroid/view/View;)V
    //   199: aload_1
    //   200: aconst_null
    //   201: invokevirtual setAnimator : (Landroid/animation/Animator;)V
    //   204: aload_0
    //   205: aload_1
    //   206: aload_1
    //   207: invokevirtual getStateAfterAnimating : ()I
    //   210: iconst_0
    //   211: iconst_0
    //   212: iconst_1
    //   213: invokevirtual a : (Landroidx/fragment/app/Fragment;IIIZ)V
    //   216: aload_1
    //   217: getfield mState : I
    //   220: istore #6
    //   222: iload #6
    //   224: ifeq -> 264
    //   227: iload_2
    //   228: istore_3
    //   229: iload #6
    //   231: iconst_1
    //   232: if_icmpeq -> 890
    //   235: iload_2
    //   236: istore #4
    //   238: iload #6
    //   240: iconst_2
    //   241: if_icmpeq -> 261
    //   244: iload_2
    //   245: istore_3
    //   246: iload #6
    //   248: iconst_3
    //   249: if_icmpeq -> 258
    //   252: iload_2
    //   253: istore #6
    //   255: goto -> 2301
    //   258: goto -> 1425
    //   261: goto -> 1357
    //   264: iload_2
    //   265: istore_3
    //   266: iload_2
    //   267: ifle -> 890
    //   270: getstatic androidx/fragment/app/FragmentManagerImpl.b : Z
    //   273: ifeq -> 313
    //   276: new java/lang/StringBuilder
    //   279: dup
    //   280: invokespecial <init> : ()V
    //   283: astore #11
    //   285: aload #11
    //   287: ldc_w 'moveto CREATED: '
    //   290: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload #11
    //   296: aload_1
    //   297: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: ldc_w 'FragmentManager'
    //   304: aload #11
    //   306: invokevirtual toString : ()Ljava/lang/String;
    //   309: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   312: pop
    //   313: iload_2
    //   314: istore_3
    //   315: aload_1
    //   316: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   319: ifnull -> 476
    //   322: aload_1
    //   323: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   326: aload_0
    //   327: getfield n : Landroidx/fragment/app/FragmentHostCallback;
    //   330: invokevirtual b : ()Landroid/content/Context;
    //   333: invokevirtual getClassLoader : ()Ljava/lang/ClassLoader;
    //   336: invokevirtual setClassLoader : (Ljava/lang/ClassLoader;)V
    //   339: aload_1
    //   340: aload_1
    //   341: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   344: ldc_w 'android:view_state'
    //   347: invokevirtual getSparseParcelableArray : (Ljava/lang/String;)Landroid/util/SparseArray;
    //   350: putfield mSavedViewState : Landroid/util/SparseArray;
    //   353: aload_0
    //   354: aload_1
    //   355: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   358: ldc_w 'android:target_state'
    //   361: invokevirtual getFragment : (Landroid/os/Bundle;Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    //   364: astore #11
    //   366: aload #11
    //   368: ifnull -> 381
    //   371: aload #11
    //   373: getfield mWho : Ljava/lang/String;
    //   376: astore #11
    //   378: goto -> 384
    //   381: aconst_null
    //   382: astore #11
    //   384: aload_1
    //   385: aload #11
    //   387: putfield mTargetWho : Ljava/lang/String;
    //   390: aload_1
    //   391: getfield mTargetWho : Ljava/lang/String;
    //   394: ifnull -> 412
    //   397: aload_1
    //   398: aload_1
    //   399: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   402: ldc_w 'android:target_req_state'
    //   405: iconst_0
    //   406: invokevirtual getInt : (Ljava/lang/String;I)I
    //   409: putfield mTargetRequestCode : I
    //   412: aload_1
    //   413: getfield mSavedUserVisibleHint : Ljava/lang/Boolean;
    //   416: ifnull -> 438
    //   419: aload_1
    //   420: aload_1
    //   421: getfield mSavedUserVisibleHint : Ljava/lang/Boolean;
    //   424: invokevirtual booleanValue : ()Z
    //   427: putfield mUserVisibleHint : Z
    //   430: aload_1
    //   431: aconst_null
    //   432: putfield mSavedUserVisibleHint : Ljava/lang/Boolean;
    //   435: goto -> 453
    //   438: aload_1
    //   439: aload_1
    //   440: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   443: ldc_w 'android:user_visible_hint'
    //   446: iconst_1
    //   447: invokevirtual getBoolean : (Ljava/lang/String;Z)Z
    //   450: putfield mUserVisibleHint : Z
    //   453: iload_2
    //   454: istore_3
    //   455: aload_1
    //   456: getfield mUserVisibleHint : Z
    //   459: ifne -> 476
    //   462: aload_1
    //   463: iconst_1
    //   464: putfield mDeferStart : Z
    //   467: iload_2
    //   468: istore_3
    //   469: iload_2
    //   470: iconst_2
    //   471: if_icmple -> 476
    //   474: iconst_2
    //   475: istore_3
    //   476: aload_0
    //   477: getfield n : Landroidx/fragment/app/FragmentHostCallback;
    //   480: astore #11
    //   482: aload_1
    //   483: aload #11
    //   485: putfield mHost : Landroidx/fragment/app/FragmentHostCallback;
    //   488: aload_0
    //   489: getfield p : Landroidx/fragment/app/Fragment;
    //   492: astore #12
    //   494: aload_1
    //   495: aload #12
    //   497: putfield mParentFragment : Landroidx/fragment/app/Fragment;
    //   500: aload #12
    //   502: ifnull -> 515
    //   505: aload #12
    //   507: getfield mChildFragmentManager : Landroidx/fragment/app/FragmentManagerImpl;
    //   510: astore #11
    //   512: goto -> 522
    //   515: aload #11
    //   517: getfield b : Landroidx/fragment/app/FragmentManagerImpl;
    //   520: astore #11
    //   522: aload_1
    //   523: aload #11
    //   525: putfield mFragmentManager : Landroidx/fragment/app/FragmentManagerImpl;
    //   528: aload_1
    //   529: getfield mTarget : Landroidx/fragment/app/Fragment;
    //   532: ifnull -> 667
    //   535: aload_0
    //   536: getfield g : Ljava/util/HashMap;
    //   539: aload_1
    //   540: getfield mTarget : Landroidx/fragment/app/Fragment;
    //   543: getfield mWho : Ljava/lang/String;
    //   546: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   549: aload_1
    //   550: getfield mTarget : Landroidx/fragment/app/Fragment;
    //   553: if_acmpne -> 601
    //   556: aload_1
    //   557: getfield mTarget : Landroidx/fragment/app/Fragment;
    //   560: getfield mState : I
    //   563: iconst_1
    //   564: if_icmpge -> 582
    //   567: aload_0
    //   568: aload_1
    //   569: getfield mTarget : Landroidx/fragment/app/Fragment;
    //   572: iconst_1
    //   573: iconst_0
    //   574: iconst_0
    //   575: iconst_1
    //   576: invokevirtual a : (Landroidx/fragment/app/Fragment;IIIZ)V
    //   579: goto -> 582
    //   582: aload_1
    //   583: aload_1
    //   584: getfield mTarget : Landroidx/fragment/app/Fragment;
    //   587: getfield mWho : Ljava/lang/String;
    //   590: putfield mTargetWho : Ljava/lang/String;
    //   593: aload_1
    //   594: aconst_null
    //   595: putfield mTarget : Landroidx/fragment/app/Fragment;
    //   598: goto -> 667
    //   601: new java/lang/StringBuilder
    //   604: dup
    //   605: invokespecial <init> : ()V
    //   608: astore #11
    //   610: aload #11
    //   612: ldc_w 'Fragment '
    //   615: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: pop
    //   619: aload #11
    //   621: aload_1
    //   622: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   625: pop
    //   626: aload #11
    //   628: ldc_w ' declared target fragment '
    //   631: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: pop
    //   635: aload #11
    //   637: aload_1
    //   638: getfield mTarget : Landroidx/fragment/app/Fragment;
    //   641: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   644: pop
    //   645: aload #11
    //   647: ldc_w ' that does not belong to this FragmentManager!'
    //   650: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   653: pop
    //   654: new java/lang/IllegalStateException
    //   657: dup
    //   658: aload #11
    //   660: invokevirtual toString : ()Ljava/lang/String;
    //   663: invokespecial <init> : (Ljava/lang/String;)V
    //   666: athrow
    //   667: aload_1
    //   668: getfield mTargetWho : Ljava/lang/String;
    //   671: ifnull -> 783
    //   674: aload_0
    //   675: getfield g : Ljava/util/HashMap;
    //   678: aload_1
    //   679: getfield mTargetWho : Ljava/lang/String;
    //   682: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   685: checkcast androidx/fragment/app/Fragment
    //   688: astore #11
    //   690: aload #11
    //   692: ifnull -> 717
    //   695: aload #11
    //   697: getfield mState : I
    //   700: iconst_1
    //   701: if_icmpge -> 783
    //   704: aload_0
    //   705: aload #11
    //   707: iconst_1
    //   708: iconst_0
    //   709: iconst_0
    //   710: iconst_1
    //   711: invokevirtual a : (Landroidx/fragment/app/Fragment;IIIZ)V
    //   714: goto -> 783
    //   717: new java/lang/StringBuilder
    //   720: dup
    //   721: invokespecial <init> : ()V
    //   724: astore #11
    //   726: aload #11
    //   728: ldc_w 'Fragment '
    //   731: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: pop
    //   735: aload #11
    //   737: aload_1
    //   738: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   741: pop
    //   742: aload #11
    //   744: ldc_w ' declared target fragment '
    //   747: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   750: pop
    //   751: aload #11
    //   753: aload_1
    //   754: getfield mTargetWho : Ljava/lang/String;
    //   757: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   760: pop
    //   761: aload #11
    //   763: ldc_w ' that does not belong to this FragmentManager!'
    //   766: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   769: pop
    //   770: new java/lang/IllegalStateException
    //   773: dup
    //   774: aload #11
    //   776: invokevirtual toString : ()Ljava/lang/String;
    //   779: invokespecial <init> : (Ljava/lang/String;)V
    //   782: athrow
    //   783: aload_0
    //   784: aload_1
    //   785: aload_0
    //   786: getfield n : Landroidx/fragment/app/FragmentHostCallback;
    //   789: invokevirtual b : ()Landroid/content/Context;
    //   792: iconst_0
    //   793: invokevirtual a : (Landroidx/fragment/app/Fragment;Landroid/content/Context;Z)V
    //   796: aload_1
    //   797: invokevirtual performAttach : ()V
    //   800: aload_1
    //   801: getfield mParentFragment : Landroidx/fragment/app/Fragment;
    //   804: ifnonnull -> 818
    //   807: aload_0
    //   808: getfield n : Landroidx/fragment/app/FragmentHostCallback;
    //   811: aload_1
    //   812: invokevirtual onAttachFragment : (Landroidx/fragment/app/Fragment;)V
    //   815: goto -> 826
    //   818: aload_1
    //   819: getfield mParentFragment : Landroidx/fragment/app/Fragment;
    //   822: aload_1
    //   823: invokevirtual onAttachFragment : (Landroidx/fragment/app/Fragment;)V
    //   826: aload_0
    //   827: aload_1
    //   828: aload_0
    //   829: getfield n : Landroidx/fragment/app/FragmentHostCallback;
    //   832: invokevirtual b : ()Landroid/content/Context;
    //   835: iconst_0
    //   836: invokevirtual b : (Landroidx/fragment/app/Fragment;Landroid/content/Context;Z)V
    //   839: aload_1
    //   840: getfield mIsCreated : Z
    //   843: ifne -> 877
    //   846: aload_0
    //   847: aload_1
    //   848: aload_1
    //   849: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   852: iconst_0
    //   853: invokevirtual a : (Landroidx/fragment/app/Fragment;Landroid/os/Bundle;Z)V
    //   856: aload_1
    //   857: aload_1
    //   858: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   861: invokevirtual performCreate : (Landroid/os/Bundle;)V
    //   864: aload_0
    //   865: aload_1
    //   866: aload_1
    //   867: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   870: iconst_0
    //   871: invokevirtual b : (Landroidx/fragment/app/Fragment;Landroid/os/Bundle;Z)V
    //   874: goto -> 890
    //   877: aload_1
    //   878: aload_1
    //   879: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   882: invokevirtual restoreChildFragmentState : (Landroid/os/Bundle;)V
    //   885: aload_1
    //   886: iconst_1
    //   887: putfield mState : I
    //   890: iload_3
    //   891: ifle -> 899
    //   894: aload_0
    //   895: aload_1
    //   896: invokevirtual g : (Landroidx/fragment/app/Fragment;)V
    //   899: iload_3
    //   900: istore #4
    //   902: iload_3
    //   903: iconst_1
    //   904: if_icmple -> 261
    //   907: getstatic androidx/fragment/app/FragmentManagerImpl.b : Z
    //   910: ifeq -> 950
    //   913: new java/lang/StringBuilder
    //   916: dup
    //   917: invokespecial <init> : ()V
    //   920: astore #11
    //   922: aload #11
    //   924: ldc_w 'moveto ACTIVITY_CREATED: '
    //   927: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   930: pop
    //   931: aload #11
    //   933: aload_1
    //   934: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   937: pop
    //   938: ldc_w 'FragmentManager'
    //   941: aload #11
    //   943: invokevirtual toString : ()Ljava/lang/String;
    //   946: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   949: pop
    //   950: aload_1
    //   951: getfield mFromLayout : Z
    //   954: ifne -> 1313
    //   957: aload_1
    //   958: getfield mContainerId : I
    //   961: ifeq -> 1166
    //   964: aload_1
    //   965: getfield mContainerId : I
    //   968: iconst_m1
    //   969: if_icmpne -> 1022
    //   972: new java/lang/StringBuilder
    //   975: dup
    //   976: invokespecial <init> : ()V
    //   979: astore #11
    //   981: aload #11
    //   983: ldc_w 'Cannot create fragment '
    //   986: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   989: pop
    //   990: aload #11
    //   992: aload_1
    //   993: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   996: pop
    //   997: aload #11
    //   999: ldc_w ' for a container view with no id'
    //   1002: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1005: pop
    //   1006: aload_0
    //   1007: new java/lang/IllegalArgumentException
    //   1010: dup
    //   1011: aload #11
    //   1013: invokevirtual toString : ()Ljava/lang/String;
    //   1016: invokespecial <init> : (Ljava/lang/String;)V
    //   1019: invokespecial a : (Ljava/lang/RuntimeException;)V
    //   1022: aload_0
    //   1023: getfield o : Landroidx/fragment/app/FragmentContainer;
    //   1026: aload_1
    //   1027: getfield mContainerId : I
    //   1030: invokevirtual onFindViewById : (I)Landroid/view/View;
    //   1033: checkcast android/view/ViewGroup
    //   1036: astore #12
    //   1038: aload #12
    //   1040: astore #11
    //   1042: aload #12
    //   1044: ifnonnull -> 1169
    //   1047: aload #12
    //   1049: astore #11
    //   1051: aload_1
    //   1052: getfield mRestored : Z
    //   1055: ifne -> 1169
    //   1058: aload_1
    //   1059: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   1062: aload_1
    //   1063: getfield mContainerId : I
    //   1066: invokevirtual getResourceName : (I)Ljava/lang/String;
    //   1069: astore #11
    //   1071: goto -> 1079
    //   1074: ldc_w 'unknown'
    //   1077: astore #11
    //   1079: new java/lang/StringBuilder
    //   1082: dup
    //   1083: invokespecial <init> : ()V
    //   1086: astore #13
    //   1088: aload #13
    //   1090: ldc_w 'No view found for id 0x'
    //   1093: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1096: pop
    //   1097: aload #13
    //   1099: aload_1
    //   1100: getfield mContainerId : I
    //   1103: invokestatic toHexString : (I)Ljava/lang/String;
    //   1106: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1109: pop
    //   1110: aload #13
    //   1112: ldc_w ' ('
    //   1115: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1118: pop
    //   1119: aload #13
    //   1121: aload #11
    //   1123: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1126: pop
    //   1127: aload #13
    //   1129: ldc_w ') for fragment '
    //   1132: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1135: pop
    //   1136: aload #13
    //   1138: aload_1
    //   1139: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1142: pop
    //   1143: aload_0
    //   1144: new java/lang/IllegalArgumentException
    //   1147: dup
    //   1148: aload #13
    //   1150: invokevirtual toString : ()Ljava/lang/String;
    //   1153: invokespecial <init> : (Ljava/lang/String;)V
    //   1156: invokespecial a : (Ljava/lang/RuntimeException;)V
    //   1159: aload #12
    //   1161: astore #11
    //   1163: goto -> 1169
    //   1166: aconst_null
    //   1167: astore #11
    //   1169: aload_1
    //   1170: aload #11
    //   1172: putfield mContainer : Landroid/view/ViewGroup;
    //   1175: aload_1
    //   1176: aload_1
    //   1177: aload_1
    //   1178: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   1181: invokevirtual performGetLayoutInflater : (Landroid/os/Bundle;)Landroid/view/LayoutInflater;
    //   1184: aload #11
    //   1186: aload_1
    //   1187: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   1190: invokevirtual performCreateView : (Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)V
    //   1193: aload_1
    //   1194: getfield mView : Landroid/view/View;
    //   1197: ifnull -> 1308
    //   1200: aload_1
    //   1201: aload_1
    //   1202: getfield mView : Landroid/view/View;
    //   1205: putfield mInnerView : Landroid/view/View;
    //   1208: aload_1
    //   1209: getfield mView : Landroid/view/View;
    //   1212: iconst_0
    //   1213: invokevirtual setSaveFromParentEnabled : (Z)V
    //   1216: aload #11
    //   1218: ifnull -> 1230
    //   1221: aload #11
    //   1223: aload_1
    //   1224: getfield mView : Landroid/view/View;
    //   1227: invokevirtual addView : (Landroid/view/View;)V
    //   1230: aload_1
    //   1231: getfield mHidden : Z
    //   1234: ifeq -> 1246
    //   1237: aload_1
    //   1238: getfield mView : Landroid/view/View;
    //   1241: bipush #8
    //   1243: invokevirtual setVisibility : (I)V
    //   1246: aload_1
    //   1247: aload_1
    //   1248: getfield mView : Landroid/view/View;
    //   1251: aload_1
    //   1252: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   1255: invokevirtual onViewCreated : (Landroid/view/View;Landroid/os/Bundle;)V
    //   1258: aload_0
    //   1259: aload_1
    //   1260: aload_1
    //   1261: getfield mView : Landroid/view/View;
    //   1264: aload_1
    //   1265: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   1268: iconst_0
    //   1269: invokevirtual a : (Landroidx/fragment/app/Fragment;Landroid/view/View;Landroid/os/Bundle;Z)V
    //   1272: aload_1
    //   1273: getfield mView : Landroid/view/View;
    //   1276: invokevirtual getVisibility : ()I
    //   1279: ifne -> 1296
    //   1282: aload_1
    //   1283: getfield mContainer : Landroid/view/ViewGroup;
    //   1286: ifnull -> 1296
    //   1289: iload #8
    //   1291: istore #5
    //   1293: goto -> 1299
    //   1296: iconst_0
    //   1297: istore #5
    //   1299: aload_1
    //   1300: iload #5
    //   1302: putfield mIsNewlyAdded : Z
    //   1305: goto -> 1313
    //   1308: aload_1
    //   1309: aconst_null
    //   1310: putfield mInnerView : Landroid/view/View;
    //   1313: aload_1
    //   1314: aload_1
    //   1315: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   1318: invokevirtual performActivityCreated : (Landroid/os/Bundle;)V
    //   1321: aload_0
    //   1322: aload_1
    //   1323: aload_1
    //   1324: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   1327: iconst_0
    //   1328: invokevirtual c : (Landroidx/fragment/app/Fragment;Landroid/os/Bundle;Z)V
    //   1331: aload_1
    //   1332: getfield mView : Landroid/view/View;
    //   1335: ifnull -> 1346
    //   1338: aload_1
    //   1339: aload_1
    //   1340: getfield mSavedFragmentState : Landroid/os/Bundle;
    //   1343: invokevirtual restoreViewState : (Landroid/os/Bundle;)V
    //   1346: aload_1
    //   1347: aconst_null
    //   1348: putfield mSavedFragmentState : Landroid/os/Bundle;
    //   1351: iload_3
    //   1352: istore #4
    //   1354: goto -> 261
    //   1357: iload #4
    //   1359: istore_3
    //   1360: iload #4
    //   1362: iconst_2
    //   1363: if_icmple -> 258
    //   1366: getstatic androidx/fragment/app/FragmentManagerImpl.b : Z
    //   1369: ifeq -> 1409
    //   1372: new java/lang/StringBuilder
    //   1375: dup
    //   1376: invokespecial <init> : ()V
    //   1379: astore #11
    //   1381: aload #11
    //   1383: ldc_w 'moveto STARTED: '
    //   1386: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1389: pop
    //   1390: aload #11
    //   1392: aload_1
    //   1393: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1396: pop
    //   1397: ldc_w 'FragmentManager'
    //   1400: aload #11
    //   1402: invokevirtual toString : ()Ljava/lang/String;
    //   1405: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   1408: pop
    //   1409: aload_1
    //   1410: invokevirtual performStart : ()V
    //   1413: aload_0
    //   1414: aload_1
    //   1415: iconst_0
    //   1416: invokevirtual a : (Landroidx/fragment/app/Fragment;Z)V
    //   1419: iload #4
    //   1421: istore_3
    //   1422: goto -> 258
    //   1425: iload_3
    //   1426: istore #6
    //   1428: iload_3
    //   1429: iconst_3
    //   1430: if_icmple -> 2301
    //   1433: getstatic androidx/fragment/app/FragmentManagerImpl.b : Z
    //   1436: ifeq -> 1476
    //   1439: new java/lang/StringBuilder
    //   1442: dup
    //   1443: invokespecial <init> : ()V
    //   1446: astore #11
    //   1448: aload #11
    //   1450: ldc_w 'moveto RESUMED: '
    //   1453: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1456: pop
    //   1457: aload #11
    //   1459: aload_1
    //   1460: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1463: pop
    //   1464: ldc_w 'FragmentManager'
    //   1467: aload #11
    //   1469: invokevirtual toString : ()Ljava/lang/String;
    //   1472: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   1475: pop
    //   1476: aload_1
    //   1477: invokevirtual performResume : ()V
    //   1480: aload_0
    //   1481: aload_1
    //   1482: iconst_0
    //   1483: invokevirtual b : (Landroidx/fragment/app/Fragment;Z)V
    //   1486: aload_1
    //   1487: aconst_null
    //   1488: putfield mSavedFragmentState : Landroid/os/Bundle;
    //   1491: aload_1
    //   1492: aconst_null
    //   1493: putfield mSavedViewState : Landroid/util/SparseArray;
    //   1496: iload_3
    //   1497: istore #6
    //   1499: goto -> 2301
    //   1502: iload_2
    //   1503: istore #6
    //   1505: aload_1
    //   1506: getfield mState : I
    //   1509: iload_2
    //   1510: if_icmple -> 2301
    //   1513: aload_1
    //   1514: getfield mState : I
    //   1517: istore #6
    //   1519: iload #6
    //   1521: iconst_1
    //   1522: if_icmpeq -> 1914
    //   1525: iload #6
    //   1527: iconst_2
    //   1528: if_icmpeq -> 1665
    //   1531: iload #6
    //   1533: iconst_3
    //   1534: if_icmpeq -> 1607
    //   1537: iload #6
    //   1539: iconst_4
    //   1540: if_icmpeq -> 1549
    //   1543: iload_2
    //   1544: istore #6
    //   1546: goto -> 2301
    //   1549: iload_2
    //   1550: iconst_4
    //   1551: if_icmpge -> 1607
    //   1554: getstatic androidx/fragment/app/FragmentManagerImpl.b : Z
    //   1557: ifeq -> 1597
    //   1560: new java/lang/StringBuilder
    //   1563: dup
    //   1564: invokespecial <init> : ()V
    //   1567: astore #11
    //   1569: aload #11
    //   1571: ldc_w 'movefrom RESUMED: '
    //   1574: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1577: pop
    //   1578: aload #11
    //   1580: aload_1
    //   1581: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1584: pop
    //   1585: ldc_w 'FragmentManager'
    //   1588: aload #11
    //   1590: invokevirtual toString : ()Ljava/lang/String;
    //   1593: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   1596: pop
    //   1597: aload_1
    //   1598: invokevirtual performPause : ()V
    //   1601: aload_0
    //   1602: aload_1
    //   1603: iconst_0
    //   1604: invokevirtual c : (Landroidx/fragment/app/Fragment;Z)V
    //   1607: iload_2
    //   1608: iconst_3
    //   1609: if_icmpge -> 1665
    //   1612: getstatic androidx/fragment/app/FragmentManagerImpl.b : Z
    //   1615: ifeq -> 1655
    //   1618: new java/lang/StringBuilder
    //   1621: dup
    //   1622: invokespecial <init> : ()V
    //   1625: astore #11
    //   1627: aload #11
    //   1629: ldc_w 'movefrom STARTED: '
    //   1632: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1635: pop
    //   1636: aload #11
    //   1638: aload_1
    //   1639: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1642: pop
    //   1643: ldc_w 'FragmentManager'
    //   1646: aload #11
    //   1648: invokevirtual toString : ()Ljava/lang/String;
    //   1651: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   1654: pop
    //   1655: aload_1
    //   1656: invokevirtual performStop : ()V
    //   1659: aload_0
    //   1660: aload_1
    //   1661: iconst_0
    //   1662: invokevirtual d : (Landroidx/fragment/app/Fragment;Z)V
    //   1665: iload_2
    //   1666: iconst_2
    //   1667: if_icmpge -> 1914
    //   1670: getstatic androidx/fragment/app/FragmentManagerImpl.b : Z
    //   1673: ifeq -> 1713
    //   1676: new java/lang/StringBuilder
    //   1679: dup
    //   1680: invokespecial <init> : ()V
    //   1683: astore #11
    //   1685: aload #11
    //   1687: ldc_w 'movefrom ACTIVITY_CREATED: '
    //   1690: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1693: pop
    //   1694: aload #11
    //   1696: aload_1
    //   1697: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1700: pop
    //   1701: ldc_w 'FragmentManager'
    //   1704: aload #11
    //   1706: invokevirtual toString : ()Ljava/lang/String;
    //   1709: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   1712: pop
    //   1713: aload_1
    //   1714: getfield mView : Landroid/view/View;
    //   1717: ifnull -> 1743
    //   1720: aload_0
    //   1721: getfield n : Landroidx/fragment/app/FragmentHostCallback;
    //   1724: aload_1
    //   1725: invokevirtual onShouldSaveFragmentState : (Landroidx/fragment/app/Fragment;)Z
    //   1728: ifeq -> 1743
    //   1731: aload_1
    //   1732: getfield mSavedViewState : Landroid/util/SparseArray;
    //   1735: ifnonnull -> 1743
    //   1738: aload_0
    //   1739: aload_1
    //   1740: invokevirtual l : (Landroidx/fragment/app/Fragment;)V
    //   1743: aload_1
    //   1744: invokevirtual performDestroyView : ()V
    //   1747: aload_0
    //   1748: aload_1
    //   1749: iconst_0
    //   1750: invokevirtual e : (Landroidx/fragment/app/Fragment;Z)V
    //   1753: aload_1
    //   1754: getfield mView : Landroid/view/View;
    //   1757: ifnull -> 1881
    //   1760: aload_1
    //   1761: getfield mContainer : Landroid/view/ViewGroup;
    //   1764: ifnull -> 1881
    //   1767: aload_1
    //   1768: getfield mContainer : Landroid/view/ViewGroup;
    //   1771: aload_1
    //   1772: getfield mView : Landroid/view/View;
    //   1775: invokevirtual endViewTransition : (Landroid/view/View;)V
    //   1778: aload_1
    //   1779: getfield mView : Landroid/view/View;
    //   1782: invokevirtual clearAnimation : ()V
    //   1785: aload_1
    //   1786: invokevirtual getParentFragment : ()Landroidx/fragment/app/Fragment;
    //   1789: ifnull -> 1802
    //   1792: aload_1
    //   1793: invokevirtual getParentFragment : ()Landroidx/fragment/app/Fragment;
    //   1796: getfield mRemoving : Z
    //   1799: ifne -> 1881
    //   1802: aload_0
    //   1803: getfield m : I
    //   1806: ifle -> 1849
    //   1809: aload_0
    //   1810: getfield u : Z
    //   1813: ifne -> 1849
    //   1816: aload_1
    //   1817: getfield mView : Landroid/view/View;
    //   1820: invokevirtual getVisibility : ()I
    //   1823: ifne -> 1849
    //   1826: aload_1
    //   1827: getfield mPostponedAlpha : F
    //   1830: fconst_0
    //   1831: fcmpl
    //   1832: iflt -> 1849
    //   1835: aload_0
    //   1836: aload_1
    //   1837: iload_3
    //   1838: iconst_0
    //   1839: iload #4
    //   1841: invokevirtual a : (Landroidx/fragment/app/Fragment;IZI)Landroidx/fragment/app/FragmentManagerImpl$AnimationOrAnimator;
    //   1844: astore #11
    //   1846: goto -> 1852
    //   1849: aconst_null
    //   1850: astore #11
    //   1852: aload_1
    //   1853: fconst_0
    //   1854: putfield mPostponedAlpha : F
    //   1857: aload #11
    //   1859: ifnull -> 1870
    //   1862: aload_0
    //   1863: aload_1
    //   1864: aload #11
    //   1866: iload_2
    //   1867: invokespecial a : (Landroidx/fragment/app/Fragment;Landroidx/fragment/app/FragmentManagerImpl$AnimationOrAnimator;I)V
    //   1870: aload_1
    //   1871: getfield mContainer : Landroid/view/ViewGroup;
    //   1874: aload_1
    //   1875: getfield mView : Landroid/view/View;
    //   1878: invokevirtual removeView : (Landroid/view/View;)V
    //   1881: aload_1
    //   1882: aconst_null
    //   1883: putfield mContainer : Landroid/view/ViewGroup;
    //   1886: aload_1
    //   1887: aconst_null
    //   1888: putfield mView : Landroid/view/View;
    //   1891: aload_1
    //   1892: aconst_null
    //   1893: putfield mViewLifecycleOwner : Landroidx/fragment/app/FragmentViewLifecycleOwner;
    //   1896: aload_1
    //   1897: getfield mViewLifecycleOwnerLiveData : Landroidx/lifecycle/MutableLiveData;
    //   1900: aconst_null
    //   1901: invokevirtual setValue : (Ljava/lang/Object;)V
    //   1904: aload_1
    //   1905: aconst_null
    //   1906: putfield mInnerView : Landroid/view/View;
    //   1909: aload_1
    //   1910: iconst_0
    //   1911: putfield mInLayout : Z
    //   1914: iload_2
    //   1915: istore #6
    //   1917: iload_2
    //   1918: iconst_1
    //   1919: if_icmpge -> 2301
    //   1922: aload_0
    //   1923: getfield u : Z
    //   1926: ifeq -> 1978
    //   1929: aload_1
    //   1930: invokevirtual getAnimatingAway : ()Landroid/view/View;
    //   1933: ifnull -> 1955
    //   1936: aload_1
    //   1937: invokevirtual getAnimatingAway : ()Landroid/view/View;
    //   1940: astore #11
    //   1942: aload_1
    //   1943: aconst_null
    //   1944: invokevirtual setAnimatingAway : (Landroid/view/View;)V
    //   1947: aload #11
    //   1949: invokevirtual clearAnimation : ()V
    //   1952: goto -> 1978
    //   1955: aload_1
    //   1956: invokevirtual getAnimator : ()Landroid/animation/Animator;
    //   1959: ifnull -> 1978
    //   1962: aload_1
    //   1963: invokevirtual getAnimator : ()Landroid/animation/Animator;
    //   1966: astore #11
    //   1968: aload_1
    //   1969: aconst_null
    //   1970: invokevirtual setAnimator : (Landroid/animation/Animator;)V
    //   1973: aload #11
    //   1975: invokevirtual cancel : ()V
    //   1978: aload_1
    //   1979: invokevirtual getAnimatingAway : ()Landroid/view/View;
    //   1982: ifnonnull -> 2289
    //   1985: aload_1
    //   1986: invokevirtual getAnimator : ()Landroid/animation/Animator;
    //   1989: ifnull -> 1995
    //   1992: goto -> 2289
    //   1995: getstatic androidx/fragment/app/FragmentManagerImpl.b : Z
    //   1998: ifeq -> 2038
    //   2001: new java/lang/StringBuilder
    //   2004: dup
    //   2005: invokespecial <init> : ()V
    //   2008: astore #11
    //   2010: aload #11
    //   2012: ldc_w 'movefrom CREATED: '
    //   2015: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2018: pop
    //   2019: aload #11
    //   2021: aload_1
    //   2022: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2025: pop
    //   2026: ldc_w 'FragmentManager'
    //   2029: aload #11
    //   2031: invokevirtual toString : ()Ljava/lang/String;
    //   2034: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   2037: pop
    //   2038: aload_1
    //   2039: getfield mRemoving : Z
    //   2042: ifeq -> 2057
    //   2045: aload_1
    //   2046: invokevirtual isInBackStack : ()Z
    //   2049: ifne -> 2057
    //   2052: iconst_1
    //   2053: istore_3
    //   2054: goto -> 2059
    //   2057: iconst_0
    //   2058: istore_3
    //   2059: iload_3
    //   2060: ifne -> 2085
    //   2063: aload_0
    //   2064: getfield I : Landroidx/fragment/app/FragmentManagerViewModel;
    //   2067: aload_1
    //   2068: invokevirtual b : (Landroidx/fragment/app/Fragment;)Z
    //   2071: ifeq -> 2077
    //   2074: goto -> 2085
    //   2077: aload_1
    //   2078: iconst_0
    //   2079: putfield mState : I
    //   2082: goto -> 2170
    //   2085: aload_0
    //   2086: getfield n : Landroidx/fragment/app/FragmentHostCallback;
    //   2089: astore #11
    //   2091: aload #11
    //   2093: instanceof androidx/lifecycle/ViewModelStoreOwner
    //   2096: ifeq -> 2111
    //   2099: aload_0
    //   2100: getfield I : Landroidx/fragment/app/FragmentManagerViewModel;
    //   2103: invokevirtual a : ()Z
    //   2106: istore #8
    //   2108: goto -> 2143
    //   2111: iload #9
    //   2113: istore #8
    //   2115: aload #11
    //   2117: invokevirtual b : ()Landroid/content/Context;
    //   2120: instanceof android/app/Activity
    //   2123: ifeq -> 2143
    //   2126: iconst_1
    //   2127: aload_0
    //   2128: getfield n : Landroidx/fragment/app/FragmentHostCallback;
    //   2131: invokevirtual b : ()Landroid/content/Context;
    //   2134: checkcast android/app/Activity
    //   2137: invokevirtual isChangingConfigurations : ()Z
    //   2140: ixor
    //   2141: istore #8
    //   2143: iload_3
    //   2144: ifne -> 2152
    //   2147: iload #8
    //   2149: ifeq -> 2160
    //   2152: aload_0
    //   2153: getfield I : Landroidx/fragment/app/FragmentManagerViewModel;
    //   2156: aload_1
    //   2157: invokevirtual f : (Landroidx/fragment/app/Fragment;)V
    //   2160: aload_1
    //   2161: invokevirtual performDestroy : ()V
    //   2164: aload_0
    //   2165: aload_1
    //   2166: iconst_0
    //   2167: invokevirtual f : (Landroidx/fragment/app/Fragment;Z)V
    //   2170: aload_1
    //   2171: invokevirtual performDetach : ()V
    //   2174: aload_0
    //   2175: aload_1
    //   2176: iconst_0
    //   2177: invokevirtual g : (Landroidx/fragment/app/Fragment;Z)V
    //   2180: iload_2
    //   2181: istore #6
    //   2183: iload #5
    //   2185: ifne -> 2301
    //   2188: iload_3
    //   2189: ifne -> 2278
    //   2192: aload_0
    //   2193: getfield I : Landroidx/fragment/app/FragmentManagerViewModel;
    //   2196: aload_1
    //   2197: invokevirtual b : (Landroidx/fragment/app/Fragment;)Z
    //   2200: ifeq -> 2206
    //   2203: goto -> 2278
    //   2206: aload_1
    //   2207: aconst_null
    //   2208: putfield mHost : Landroidx/fragment/app/FragmentHostCallback;
    //   2211: aload_1
    //   2212: aconst_null
    //   2213: putfield mParentFragment : Landroidx/fragment/app/Fragment;
    //   2216: aload_1
    //   2217: aconst_null
    //   2218: putfield mFragmentManager : Landroidx/fragment/app/FragmentManagerImpl;
    //   2221: iload_2
    //   2222: istore #6
    //   2224: aload_1
    //   2225: getfield mTargetWho : Ljava/lang/String;
    //   2228: ifnull -> 2301
    //   2231: aload_0
    //   2232: getfield g : Ljava/util/HashMap;
    //   2235: aload_1
    //   2236: getfield mTargetWho : Ljava/lang/String;
    //   2239: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   2242: checkcast androidx/fragment/app/Fragment
    //   2245: astore #11
    //   2247: iload_2
    //   2248: istore #6
    //   2250: aload #11
    //   2252: ifnull -> 2301
    //   2255: iload_2
    //   2256: istore #6
    //   2258: aload #11
    //   2260: invokevirtual getRetainInstance : ()Z
    //   2263: ifeq -> 2301
    //   2266: aload_1
    //   2267: aload #11
    //   2269: putfield mTarget : Landroidx/fragment/app/Fragment;
    //   2272: iload_2
    //   2273: istore #6
    //   2275: goto -> 2301
    //   2278: aload_0
    //   2279: aload_1
    //   2280: invokevirtual k : (Landroidx/fragment/app/Fragment;)V
    //   2283: iload_2
    //   2284: istore #6
    //   2286: goto -> 2301
    //   2289: aload_1
    //   2290: iload_2
    //   2291: invokevirtual setStateAfterAnimating : (I)V
    //   2294: iload #7
    //   2296: istore #6
    //   2298: goto -> 2301
    //   2301: aload_1
    //   2302: getfield mState : I
    //   2305: iload #6
    //   2307: if_icmpeq -> 2389
    //   2310: new java/lang/StringBuilder
    //   2313: dup
    //   2314: invokespecial <init> : ()V
    //   2317: astore #11
    //   2319: aload #11
    //   2321: ldc_w 'moveToState: Fragment state for '
    //   2324: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2327: pop
    //   2328: aload #11
    //   2330: aload_1
    //   2331: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2334: pop
    //   2335: aload #11
    //   2337: ldc_w ' not updated inline; expected state '
    //   2340: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2343: pop
    //   2344: aload #11
    //   2346: iload #6
    //   2348: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   2351: pop
    //   2352: aload #11
    //   2354: ldc_w ' found '
    //   2357: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2360: pop
    //   2361: aload #11
    //   2363: aload_1
    //   2364: getfield mState : I
    //   2367: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   2370: pop
    //   2371: ldc_w 'FragmentManager'
    //   2374: aload #11
    //   2376: invokevirtual toString : ()Ljava/lang/String;
    //   2379: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   2382: pop
    //   2383: aload_1
    //   2384: iload #6
    //   2386: putfield mState : I
    //   2389: return
    //   2390: astore #11
    //   2392: goto -> 1074
    // Exception table:
    //   from	to	target	type
    //   1058	1071	2390	android/content/res/Resources$NotFoundException
  }
  
  void a(Fragment paramFragment, Context paramContext, boolean paramBoolean) {
    Fragment fragment = this.p;
    if (fragment != null) {
      FragmentManager fragmentManager = fragment.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).a(paramFragment, paramContext, true); 
    } 
    for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.H) {
      if (!paramBoolean || fragmentLifecycleCallbacksHolder.b)
        fragmentLifecycleCallbacksHolder.a.onFragmentPreAttached(this, paramFragment, paramContext); 
    } 
  }
  
  void a(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean) {
    Fragment fragment = this.p;
    if (fragment != null) {
      FragmentManager fragmentManager = fragment.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).a(paramFragment, paramBundle, true); 
    } 
    for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.H) {
      if (!paramBoolean || fragmentLifecycleCallbacksHolder.b)
        fragmentLifecycleCallbacksHolder.a.onFragmentPreCreated(this, paramFragment, paramBundle); 
    } 
  }
  
  void a(Fragment paramFragment, View paramView, Bundle paramBundle, boolean paramBoolean) {
    Fragment fragment = this.p;
    if (fragment != null) {
      FragmentManager fragmentManager = fragment.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).a(paramFragment, paramView, paramBundle, true); 
    } 
    for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.H) {
      if (!paramBoolean || fragmentLifecycleCallbacksHolder.b)
        fragmentLifecycleCallbacksHolder.a.onFragmentViewCreated(this, paramFragment, paramView, paramBundle); 
    } 
  }
  
  void a(Fragment paramFragment, boolean paramBoolean) {
    Fragment fragment = this.p;
    if (fragment != null) {
      FragmentManager fragmentManager = fragment.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).a(paramFragment, true); 
    } 
    for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.H) {
      if (!paramBoolean || fragmentLifecycleCallbacksHolder.b)
        fragmentLifecycleCallbacksHolder.a.onFragmentStarted(this, paramFragment); 
    } 
  }
  
  boolean a(int paramInt) {
    return (this.m >= paramInt);
  }
  
  boolean a(Fragment paramFragment) {
    if (paramFragment == null)
      return true; 
    FragmentManagerImpl fragmentManagerImpl = paramFragment.mFragmentManager;
    return (paramFragment == fragmentManagerImpl.getPrimaryNavigationFragment() && a(fragmentManagerImpl.p));
  }
  
  boolean a(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1, String paramString, int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: getfield h : Ljava/util/ArrayList;
    //   4: astore #8
    //   6: aload #8
    //   8: ifnonnull -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: aload_3
    //   14: ifnonnull -> 70
    //   17: iload #4
    //   19: ifge -> 70
    //   22: iload #5
    //   24: iconst_1
    //   25: iand
    //   26: ifne -> 70
    //   29: aload #8
    //   31: invokevirtual size : ()I
    //   34: iconst_1
    //   35: isub
    //   36: istore #4
    //   38: iload #4
    //   40: ifge -> 45
    //   43: iconst_0
    //   44: ireturn
    //   45: aload_1
    //   46: aload_0
    //   47: getfield h : Ljava/util/ArrayList;
    //   50: iload #4
    //   52: invokevirtual remove : (I)Ljava/lang/Object;
    //   55: invokevirtual add : (Ljava/lang/Object;)Z
    //   58: pop
    //   59: aload_2
    //   60: iconst_1
    //   61: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   64: invokevirtual add : (Ljava/lang/Object;)Z
    //   67: pop
    //   68: iconst_1
    //   69: ireturn
    //   70: aload_3
    //   71: ifnonnull -> 88
    //   74: iload #4
    //   76: iflt -> 82
    //   79: goto -> 88
    //   82: iconst_m1
    //   83: istore #7
    //   85: goto -> 261
    //   88: aload_0
    //   89: getfield h : Ljava/util/ArrayList;
    //   92: invokevirtual size : ()I
    //   95: iconst_1
    //   96: isub
    //   97: istore #6
    //   99: iload #6
    //   101: iflt -> 164
    //   104: aload_0
    //   105: getfield h : Ljava/util/ArrayList;
    //   108: iload #6
    //   110: invokevirtual get : (I)Ljava/lang/Object;
    //   113: checkcast androidx/fragment/app/BackStackRecord
    //   116: astore #8
    //   118: aload_3
    //   119: ifnull -> 137
    //   122: aload_3
    //   123: aload #8
    //   125: invokevirtual getName : ()Ljava/lang/String;
    //   128: invokevirtual equals : (Ljava/lang/Object;)Z
    //   131: ifeq -> 137
    //   134: goto -> 164
    //   137: iload #4
    //   139: iflt -> 155
    //   142: iload #4
    //   144: aload #8
    //   146: getfield c : I
    //   149: if_icmpne -> 155
    //   152: goto -> 164
    //   155: iload #6
    //   157: iconst_1
    //   158: isub
    //   159: istore #6
    //   161: goto -> 99
    //   164: iload #6
    //   166: ifge -> 171
    //   169: iconst_0
    //   170: ireturn
    //   171: iload #6
    //   173: istore #7
    //   175: iload #5
    //   177: iconst_1
    //   178: iand
    //   179: ifeq -> 261
    //   182: iload #6
    //   184: iconst_1
    //   185: isub
    //   186: istore #5
    //   188: iload #5
    //   190: istore #7
    //   192: iload #5
    //   194: iflt -> 261
    //   197: aload_0
    //   198: getfield h : Ljava/util/ArrayList;
    //   201: iload #5
    //   203: invokevirtual get : (I)Ljava/lang/Object;
    //   206: checkcast androidx/fragment/app/BackStackRecord
    //   209: astore #8
    //   211: aload_3
    //   212: ifnull -> 231
    //   215: iload #5
    //   217: istore #6
    //   219: aload_3
    //   220: aload #8
    //   222: invokevirtual getName : ()Ljava/lang/String;
    //   225: invokevirtual equals : (Ljava/lang/Object;)Z
    //   228: ifne -> 182
    //   231: iload #5
    //   233: istore #7
    //   235: iload #4
    //   237: iflt -> 261
    //   240: iload #5
    //   242: istore #7
    //   244: iload #4
    //   246: aload #8
    //   248: getfield c : I
    //   251: if_icmpne -> 261
    //   254: iload #5
    //   256: istore #6
    //   258: goto -> 182
    //   261: iload #7
    //   263: aload_0
    //   264: getfield h : Ljava/util/ArrayList;
    //   267: invokevirtual size : ()I
    //   270: iconst_1
    //   271: isub
    //   272: if_icmpne -> 277
    //   275: iconst_0
    //   276: ireturn
    //   277: aload_0
    //   278: getfield h : Ljava/util/ArrayList;
    //   281: invokevirtual size : ()I
    //   284: iconst_1
    //   285: isub
    //   286: istore #4
    //   288: iload #4
    //   290: iload #7
    //   292: if_icmple -> 327
    //   295: aload_1
    //   296: aload_0
    //   297: getfield h : Ljava/util/ArrayList;
    //   300: iload #4
    //   302: invokevirtual remove : (I)Ljava/lang/Object;
    //   305: invokevirtual add : (Ljava/lang/Object;)Z
    //   308: pop
    //   309: aload_2
    //   310: iconst_1
    //   311: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   314: invokevirtual add : (Ljava/lang/Object;)Z
    //   317: pop
    //   318: iload #4
    //   320: iconst_1
    //   321: isub
    //   322: istore #4
    //   324: goto -> 288
    //   327: iconst_1
    //   328: ireturn
  }
  
  public void addFragment(Fragment paramFragment, boolean paramBoolean) {
    if (b) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("add: ");
      stringBuilder.append(paramFragment);
      Log.v("FragmentManager", stringBuilder.toString());
    } 
    j(paramFragment);
    if (!paramFragment.mDetached)
      if (!this.f.contains(paramFragment)) {
        synchronized (this.f) {
          this.f.add(paramFragment);
          paramFragment.mAdded = true;
          paramFragment.mRemoving = false;
          if (paramFragment.mView == null)
            paramFragment.mHiddenChanged = false; 
          if (p(paramFragment))
            this.r = true; 
          if (paramBoolean) {
            f(paramFragment);
            return;
          } 
        } 
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment already added: ");
        stringBuilder.append(paramFragment);
        throw new IllegalStateException(stringBuilder.toString());
      }  
  }
  
  public void addOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener paramOnBackStackChangedListener) {
    if (this.l == null)
      this.l = new ArrayList<FragmentManager.OnBackStackChangedListener>(); 
    this.l.add(paramOnBackStackChangedListener);
  }
  
  public int allocBackStackIndex(BackStackRecord paramBackStackRecord) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield k : Ljava/util/ArrayList;
    //   6: ifnull -> 112
    //   9: aload_0
    //   10: getfield k : Ljava/util/ArrayList;
    //   13: invokevirtual size : ()I
    //   16: ifgt -> 22
    //   19: goto -> 112
    //   22: aload_0
    //   23: getfield k : Ljava/util/ArrayList;
    //   26: aload_0
    //   27: getfield k : Ljava/util/ArrayList;
    //   30: invokevirtual size : ()I
    //   33: iconst_1
    //   34: isub
    //   35: invokevirtual remove : (I)Ljava/lang/Object;
    //   38: checkcast java/lang/Integer
    //   41: invokevirtual intValue : ()I
    //   44: istore_2
    //   45: getstatic androidx/fragment/app/FragmentManagerImpl.b : Z
    //   48: ifeq -> 98
    //   51: new java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial <init> : ()V
    //   58: astore_3
    //   59: aload_3
    //   60: ldc_w 'Adding back stack index '
    //   63: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload_3
    //   68: iload_2
    //   69: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload_3
    //   74: ldc_w ' with '
    //   77: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload_3
    //   82: aload_1
    //   83: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: ldc_w 'FragmentManager'
    //   90: aload_3
    //   91: invokevirtual toString : ()Ljava/lang/String;
    //   94: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   97: pop
    //   98: aload_0
    //   99: getfield j : Ljava/util/ArrayList;
    //   102: iload_2
    //   103: aload_1
    //   104: invokevirtual set : (ILjava/lang/Object;)Ljava/lang/Object;
    //   107: pop
    //   108: aload_0
    //   109: monitorexit
    //   110: iload_2
    //   111: ireturn
    //   112: aload_0
    //   113: getfield j : Ljava/util/ArrayList;
    //   116: ifnonnull -> 130
    //   119: aload_0
    //   120: new java/util/ArrayList
    //   123: dup
    //   124: invokespecial <init> : ()V
    //   127: putfield j : Ljava/util/ArrayList;
    //   130: aload_0
    //   131: getfield j : Ljava/util/ArrayList;
    //   134: invokevirtual size : ()I
    //   137: istore_2
    //   138: getstatic androidx/fragment/app/FragmentManagerImpl.b : Z
    //   141: ifeq -> 191
    //   144: new java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial <init> : ()V
    //   151: astore_3
    //   152: aload_3
    //   153: ldc_w 'Setting back stack index '
    //   156: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload_3
    //   161: iload_2
    //   162: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: aload_3
    //   167: ldc_w ' to '
    //   170: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload_3
    //   175: aload_1
    //   176: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: ldc_w 'FragmentManager'
    //   183: aload_3
    //   184: invokevirtual toString : ()Ljava/lang/String;
    //   187: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   190: pop
    //   191: aload_0
    //   192: getfield j : Ljava/util/ArrayList;
    //   195: aload_1
    //   196: invokevirtual add : (Ljava/lang/Object;)Z
    //   199: pop
    //   200: aload_0
    //   201: monitorexit
    //   202: iload_2
    //   203: ireturn
    //   204: astore_1
    //   205: aload_0
    //   206: monitorexit
    //   207: aload_1
    //   208: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	204	finally
    //   22	98	204	finally
    //   98	110	204	finally
    //   112	130	204	finally
    //   130	191	204	finally
    //   191	202	204	finally
    //   205	207	204	finally
  }
  
  public void attachController(FragmentHostCallback paramFragmentHostCallback, FragmentContainer paramFragmentContainer, Fragment paramFragment) {
    if (this.n == null) {
      this.n = paramFragmentHostCallback;
      this.o = paramFragmentContainer;
      this.p = paramFragment;
      if (this.p != null)
        m(); 
      if (paramFragmentHostCallback instanceof OnBackPressedDispatcherOwner) {
        Fragment fragment;
        OnBackPressedDispatcherOwner onBackPressedDispatcherOwner = (OnBackPressedDispatcherOwner)paramFragmentHostCallback;
        this.F = onBackPressedDispatcherOwner.getOnBackPressedDispatcher();
        if (paramFragment != null)
          fragment = paramFragment; 
        this.F.addCallback(fragment, this.G);
      } 
      if (paramFragment != null) {
        this.I = paramFragment.mFragmentManager.c(paramFragment);
        return;
      } 
      if (paramFragmentHostCallback instanceof ViewModelStoreOwner) {
        this.I = FragmentManagerViewModel.a(((ViewModelStoreOwner)paramFragmentHostCallback).getViewModelStore());
        return;
      } 
      this.I = new FragmentManagerViewModel(false);
      return;
    } 
    throw new IllegalStateException("Already attached");
  }
  
  public void attachFragment(Fragment paramFragment) {
    if (b) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("attach: ");
      stringBuilder.append(paramFragment);
      Log.v("FragmentManager", stringBuilder.toString());
    } 
    if (paramFragment.mDetached) {
      paramFragment.mDetached = false;
      if (!paramFragment.mAdded)
        if (!this.f.contains(paramFragment)) {
          if (b) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("add from attach: ");
            stringBuilder.append(paramFragment);
            Log.v("FragmentManager", stringBuilder.toString());
          } 
          synchronized (this.f) {
            this.f.add(paramFragment);
            paramFragment.mAdded = true;
            if (p(paramFragment)) {
              this.r = true;
              return;
            } 
          } 
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Fragment already added: ");
          stringBuilder.append(paramFragment);
          throw new IllegalStateException(stringBuilder.toString());
        }  
    } 
  }
  
  ViewModelStore b(Fragment paramFragment) {
    return this.I.e(paramFragment);
  }
  
  List<Fragment> b() {
    return new ArrayList<Fragment>(this.g.values());
  }
  
  void b(Fragment paramFragment, Context paramContext, boolean paramBoolean) {
    Fragment fragment = this.p;
    if (fragment != null) {
      FragmentManager fragmentManager = fragment.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).b(paramFragment, paramContext, true); 
    } 
    for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.H) {
      if (!paramBoolean || fragmentLifecycleCallbacksHolder.b)
        fragmentLifecycleCallbacksHolder.a.onFragmentAttached(this, paramFragment, paramContext); 
    } 
  }
  
  void b(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean) {
    Fragment fragment = this.p;
    if (fragment != null) {
      FragmentManager fragmentManager = fragment.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).b(paramFragment, paramBundle, true); 
    } 
    for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.H) {
      if (!paramBoolean || fragmentLifecycleCallbacksHolder.b)
        fragmentLifecycleCallbacksHolder.a.onFragmentCreated(this, paramFragment, paramBundle); 
    } 
  }
  
  void b(Fragment paramFragment, boolean paramBoolean) {
    Fragment fragment = this.p;
    if (fragment != null) {
      FragmentManager fragmentManager = fragment.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).b(paramFragment, true); 
    } 
    for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.H) {
      if (!paramBoolean || fragmentLifecycleCallbacksHolder.b)
        fragmentLifecycleCallbacksHolder.a.onFragmentResumed(this, paramFragment); 
    } 
  }
  
  public FragmentTransaction beginTransaction() {
    return new BackStackRecord(this);
  }
  
  int c() {
    return this.g.size();
  }
  
  FragmentManagerViewModel c(Fragment paramFragment) {
    return this.I.d(paramFragment);
  }
  
  void c(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean) {
    Fragment fragment = this.p;
    if (fragment != null) {
      FragmentManager fragmentManager = fragment.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).c(paramFragment, paramBundle, true); 
    } 
    for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.H) {
      if (!paramBoolean || fragmentLifecycleCallbacksHolder.b)
        fragmentLifecycleCallbacksHolder.a.onFragmentActivityCreated(this, paramFragment, paramBundle); 
    } 
  }
  
  void c(Fragment paramFragment, boolean paramBoolean) {
    Fragment fragment = this.p;
    if (fragment != null) {
      FragmentManager fragmentManager = fragment.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).c(paramFragment, true); 
    } 
    for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.H) {
      if (!paramBoolean || fragmentLifecycleCallbacksHolder.b)
        fragmentLifecycleCallbacksHolder.a.onFragmentPaused(this, paramFragment); 
    } 
  }
  
  void d() {
    for (Fragment fragment : this.g.values()) {
      if (fragment != null)
        performPendingDeferredStart(fragment); 
    } 
  }
  
  void d(Fragment paramFragment) {
    if (isStateSaved()) {
      if (b)
        Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved"); 
      return;
    } 
    if (this.I.a(paramFragment) && b) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Updating retained Fragments: Added ");
      stringBuilder.append(paramFragment);
      Log.v("FragmentManager", stringBuilder.toString());
    } 
  }
  
  void d(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean) {
    Fragment fragment = this.p;
    if (fragment != null) {
      FragmentManager fragmentManager = fragment.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).d(paramFragment, paramBundle, true); 
    } 
    for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.H) {
      if (!paramBoolean || fragmentLifecycleCallbacksHolder.b)
        fragmentLifecycleCallbacksHolder.a.onFragmentSaveInstanceState(this, paramFragment, paramBundle); 
    } 
  }
  
  void d(Fragment paramFragment, boolean paramBoolean) {
    Fragment fragment = this.p;
    if (fragment != null) {
      FragmentManager fragmentManager = fragment.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).d(paramFragment, true); 
    } 
    for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.H) {
      if (!paramBoolean || fragmentLifecycleCallbacksHolder.b)
        fragmentLifecycleCallbacksHolder.a.onFragmentStopped(this, paramFragment); 
    } 
  }
  
  public void detachFragment(Fragment paramFragment) {
    if (b) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("detach: ");
      stringBuilder.append(paramFragment);
      Log.v("FragmentManager", stringBuilder.toString());
    } 
    if (!paramFragment.mDetached) {
      paramFragment.mDetached = true;
      if (paramFragment.mAdded) {
        if (b) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("remove from detach: ");
          stringBuilder.append(paramFragment);
          Log.v("FragmentManager", stringBuilder.toString());
        } 
        synchronized (this.f) {
          this.f.remove(paramFragment);
          if (p(paramFragment))
            this.r = true; 
          paramFragment.mAdded = false;
          return;
        } 
      } 
    } 
  }
  
  public void dispatchActivityCreated() {
    this.s = false;
    this.t = false;
    b(2);
  }
  
  public void dispatchConfigurationChanged(Configuration paramConfiguration) {
    for (int i = 0; i < this.f.size(); i++) {
      Fragment fragment = this.f.get(i);
      if (fragment != null)
        fragment.performConfigurationChanged(paramConfiguration); 
    } 
  }
  
  public boolean dispatchContextItemSelected(MenuItem paramMenuItem) {
    if (this.m < 1)
      return false; 
    for (int i = 0; i < this.f.size(); i++) {
      Fragment fragment = this.f.get(i);
      if (fragment != null && fragment.performContextItemSelected(paramMenuItem))
        return true; 
    } 
    return false;
  }
  
  public void dispatchCreate() {
    this.s = false;
    this.t = false;
    b(1);
  }
  
  public boolean dispatchCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater) {
    int i = this.m;
    boolean bool1 = false;
    if (i < 1)
      return false; 
    ArrayList<Fragment> arrayList = null;
    i = 0;
    boolean bool2;
    for (bool2 = false; i < this.f.size(); bool2 = bool) {
      Fragment fragment = this.f.get(i);
      ArrayList<Fragment> arrayList1 = arrayList;
      boolean bool = bool2;
      if (fragment != null) {
        arrayList1 = arrayList;
        bool = bool2;
        if (fragment.performCreateOptionsMenu(paramMenu, paramMenuInflater)) {
          arrayList1 = arrayList;
          if (arrayList == null)
            arrayList1 = new ArrayList(); 
          arrayList1.add(fragment);
          bool = true;
        } 
      } 
      i++;
      arrayList = arrayList1;
    } 
    if (this.i != null)
      for (i = bool1; i < this.i.size(); i++) {
        Fragment fragment = this.i.get(i);
        if (arrayList == null || !arrayList.contains(fragment))
          fragment.onDestroyOptionsMenu(); 
      }  
    this.i = arrayList;
    return bool2;
  }
  
  public void dispatchDestroy() {
    this.u = true;
    execPendingActions();
    b(0);
    this.n = null;
    this.o = null;
    this.p = null;
    if (this.F != null) {
      this.G.remove();
      this.F = null;
    } 
  }
  
  public void dispatchDestroyView() {
    b(1);
  }
  
  public void dispatchLowMemory() {
    for (int i = 0; i < this.f.size(); i++) {
      Fragment fragment = this.f.get(i);
      if (fragment != null)
        fragment.performLowMemory(); 
    } 
  }
  
  public void dispatchMultiWindowModeChanged(boolean paramBoolean) {
    for (int i = this.f.size() - 1; i >= 0; i--) {
      Fragment fragment = this.f.get(i);
      if (fragment != null)
        fragment.performMultiWindowModeChanged(paramBoolean); 
    } 
  }
  
  public boolean dispatchOptionsItemSelected(MenuItem paramMenuItem) {
    if (this.m < 1)
      return false; 
    for (int i = 0; i < this.f.size(); i++) {
      Fragment fragment = this.f.get(i);
      if (fragment != null && fragment.performOptionsItemSelected(paramMenuItem))
        return true; 
    } 
    return false;
  }
  
  public void dispatchOptionsMenuClosed(Menu paramMenu) {
    if (this.m < 1)
      return; 
    for (int i = 0; i < this.f.size(); i++) {
      Fragment fragment = this.f.get(i);
      if (fragment != null)
        fragment.performOptionsMenuClosed(paramMenu); 
    } 
  }
  
  public void dispatchPause() {
    b(3);
  }
  
  public void dispatchPictureInPictureModeChanged(boolean paramBoolean) {
    for (int i = this.f.size() - 1; i >= 0; i--) {
      Fragment fragment = this.f.get(i);
      if (fragment != null)
        fragment.performPictureInPictureModeChanged(paramBoolean); 
    } 
  }
  
  public boolean dispatchPrepareOptionsMenu(Menu paramMenu) {
    int j = this.m;
    int i = 0;
    if (j < 1)
      return false; 
    boolean bool;
    for (bool = false; i < this.f.size(); bool = bool1) {
      Fragment fragment = this.f.get(i);
      boolean bool1 = bool;
      if (fragment != null) {
        bool1 = bool;
        if (fragment.performPrepareOptionsMenu(paramMenu))
          bool1 = true; 
      } 
      i++;
    } 
    return bool;
  }
  
  public void dispatchResume() {
    this.s = false;
    this.t = false;
    b(4);
  }
  
  public void dispatchStart() {
    this.s = false;
    this.t = false;
    b(3);
  }
  
  public void dispatchStop() {
    this.t = true;
    b(2);
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
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
    //   33: getfield g : Ljava/util/HashMap;
    //   36: invokevirtual isEmpty : ()Z
    //   39: ifne -> 138
    //   42: aload_3
    //   43: aload_1
    //   44: invokevirtual print : (Ljava/lang/String;)V
    //   47: aload_3
    //   48: ldc_w 'Active Fragments in '
    //   51: invokevirtual print : (Ljava/lang/String;)V
    //   54: aload_3
    //   55: aload_0
    //   56: invokestatic identityHashCode : (Ljava/lang/Object;)I
    //   59: invokestatic toHexString : (I)Ljava/lang/String;
    //   62: invokevirtual print : (Ljava/lang/String;)V
    //   65: aload_3
    //   66: ldc_w ':'
    //   69: invokevirtual println : (Ljava/lang/String;)V
    //   72: aload_0
    //   73: getfield g : Ljava/util/HashMap;
    //   76: invokevirtual values : ()Ljava/util/Collection;
    //   79: invokeinterface iterator : ()Ljava/util/Iterator;
    //   84: astore #9
    //   86: aload #9
    //   88: invokeinterface hasNext : ()Z
    //   93: ifeq -> 138
    //   96: aload #9
    //   98: invokeinterface next : ()Ljava/lang/Object;
    //   103: checkcast androidx/fragment/app/Fragment
    //   106: astore #10
    //   108: aload_3
    //   109: aload_1
    //   110: invokevirtual print : (Ljava/lang/String;)V
    //   113: aload_3
    //   114: aload #10
    //   116: invokevirtual println : (Ljava/lang/Object;)V
    //   119: aload #10
    //   121: ifnull -> 86
    //   124: aload #10
    //   126: aload #8
    //   128: aload_2
    //   129: aload_3
    //   130: aload #4
    //   132: invokevirtual dump : (Ljava/lang/String;Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V
    //   135: goto -> 86
    //   138: aload_0
    //   139: getfield f : Ljava/util/ArrayList;
    //   142: invokevirtual size : ()I
    //   145: istore #7
    //   147: iconst_0
    //   148: istore #6
    //   150: iload #7
    //   152: ifle -> 232
    //   155: aload_3
    //   156: aload_1
    //   157: invokevirtual print : (Ljava/lang/String;)V
    //   160: aload_3
    //   161: ldc_w 'Added Fragments:'
    //   164: invokevirtual println : (Ljava/lang/String;)V
    //   167: iconst_0
    //   168: istore #5
    //   170: iload #5
    //   172: iload #7
    //   174: if_icmpge -> 232
    //   177: aload_0
    //   178: getfield f : Ljava/util/ArrayList;
    //   181: iload #5
    //   183: invokevirtual get : (I)Ljava/lang/Object;
    //   186: checkcast androidx/fragment/app/Fragment
    //   189: astore_2
    //   190: aload_3
    //   191: aload_1
    //   192: invokevirtual print : (Ljava/lang/String;)V
    //   195: aload_3
    //   196: ldc_w '  #'
    //   199: invokevirtual print : (Ljava/lang/String;)V
    //   202: aload_3
    //   203: iload #5
    //   205: invokevirtual print : (I)V
    //   208: aload_3
    //   209: ldc_w ': '
    //   212: invokevirtual print : (Ljava/lang/String;)V
    //   215: aload_3
    //   216: aload_2
    //   217: invokevirtual toString : ()Ljava/lang/String;
    //   220: invokevirtual println : (Ljava/lang/String;)V
    //   223: iload #5
    //   225: iconst_1
    //   226: iadd
    //   227: istore #5
    //   229: goto -> 170
    //   232: aload_0
    //   233: getfield i : Ljava/util/ArrayList;
    //   236: astore_2
    //   237: aload_2
    //   238: ifnull -> 329
    //   241: aload_2
    //   242: invokevirtual size : ()I
    //   245: istore #7
    //   247: iload #7
    //   249: ifle -> 329
    //   252: aload_3
    //   253: aload_1
    //   254: invokevirtual print : (Ljava/lang/String;)V
    //   257: aload_3
    //   258: ldc_w 'Fragments Created Menus:'
    //   261: invokevirtual println : (Ljava/lang/String;)V
    //   264: iconst_0
    //   265: istore #5
    //   267: iload #5
    //   269: iload #7
    //   271: if_icmpge -> 329
    //   274: aload_0
    //   275: getfield i : Ljava/util/ArrayList;
    //   278: iload #5
    //   280: invokevirtual get : (I)Ljava/lang/Object;
    //   283: checkcast androidx/fragment/app/Fragment
    //   286: astore_2
    //   287: aload_3
    //   288: aload_1
    //   289: invokevirtual print : (Ljava/lang/String;)V
    //   292: aload_3
    //   293: ldc_w '  #'
    //   296: invokevirtual print : (Ljava/lang/String;)V
    //   299: aload_3
    //   300: iload #5
    //   302: invokevirtual print : (I)V
    //   305: aload_3
    //   306: ldc_w ': '
    //   309: invokevirtual print : (Ljava/lang/String;)V
    //   312: aload_3
    //   313: aload_2
    //   314: invokevirtual toString : ()Ljava/lang/String;
    //   317: invokevirtual println : (Ljava/lang/String;)V
    //   320: iload #5
    //   322: iconst_1
    //   323: iadd
    //   324: istore #5
    //   326: goto -> 267
    //   329: aload_0
    //   330: getfield h : Ljava/util/ArrayList;
    //   333: astore_2
    //   334: aload_2
    //   335: ifnull -> 433
    //   338: aload_2
    //   339: invokevirtual size : ()I
    //   342: istore #7
    //   344: iload #7
    //   346: ifle -> 433
    //   349: aload_3
    //   350: aload_1
    //   351: invokevirtual print : (Ljava/lang/String;)V
    //   354: aload_3
    //   355: ldc_w 'Back Stack:'
    //   358: invokevirtual println : (Ljava/lang/String;)V
    //   361: iconst_0
    //   362: istore #5
    //   364: iload #5
    //   366: iload #7
    //   368: if_icmpge -> 433
    //   371: aload_0
    //   372: getfield h : Ljava/util/ArrayList;
    //   375: iload #5
    //   377: invokevirtual get : (I)Ljava/lang/Object;
    //   380: checkcast androidx/fragment/app/BackStackRecord
    //   383: astore_2
    //   384: aload_3
    //   385: aload_1
    //   386: invokevirtual print : (Ljava/lang/String;)V
    //   389: aload_3
    //   390: ldc_w '  #'
    //   393: invokevirtual print : (Ljava/lang/String;)V
    //   396: aload_3
    //   397: iload #5
    //   399: invokevirtual print : (I)V
    //   402: aload_3
    //   403: ldc_w ': '
    //   406: invokevirtual print : (Ljava/lang/String;)V
    //   409: aload_3
    //   410: aload_2
    //   411: invokevirtual toString : ()Ljava/lang/String;
    //   414: invokevirtual println : (Ljava/lang/String;)V
    //   417: aload_2
    //   418: aload #8
    //   420: aload_3
    //   421: invokevirtual dump : (Ljava/lang/String;Ljava/io/PrintWriter;)V
    //   424: iload #5
    //   426: iconst_1
    //   427: iadd
    //   428: istore #5
    //   430: goto -> 364
    //   433: aload_0
    //   434: monitorenter
    //   435: aload_0
    //   436: getfield j : Ljava/util/ArrayList;
    //   439: ifnull -> 530
    //   442: aload_0
    //   443: getfield j : Ljava/util/ArrayList;
    //   446: invokevirtual size : ()I
    //   449: istore #7
    //   451: iload #7
    //   453: ifle -> 530
    //   456: aload_3
    //   457: aload_1
    //   458: invokevirtual print : (Ljava/lang/String;)V
    //   461: aload_3
    //   462: ldc_w 'Back Stack Indices:'
    //   465: invokevirtual println : (Ljava/lang/String;)V
    //   468: iconst_0
    //   469: istore #5
    //   471: iload #5
    //   473: iload #7
    //   475: if_icmpge -> 530
    //   478: aload_0
    //   479: getfield j : Ljava/util/ArrayList;
    //   482: iload #5
    //   484: invokevirtual get : (I)Ljava/lang/Object;
    //   487: checkcast androidx/fragment/app/BackStackRecord
    //   490: astore_2
    //   491: aload_3
    //   492: aload_1
    //   493: invokevirtual print : (Ljava/lang/String;)V
    //   496: aload_3
    //   497: ldc_w '  #'
    //   500: invokevirtual print : (Ljava/lang/String;)V
    //   503: aload_3
    //   504: iload #5
    //   506: invokevirtual print : (I)V
    //   509: aload_3
    //   510: ldc_w ': '
    //   513: invokevirtual print : (Ljava/lang/String;)V
    //   516: aload_3
    //   517: aload_2
    //   518: invokevirtual println : (Ljava/lang/Object;)V
    //   521: iload #5
    //   523: iconst_1
    //   524: iadd
    //   525: istore #5
    //   527: goto -> 471
    //   530: aload_0
    //   531: getfield k : Ljava/util/ArrayList;
    //   534: ifnull -> 573
    //   537: aload_0
    //   538: getfield k : Ljava/util/ArrayList;
    //   541: invokevirtual size : ()I
    //   544: ifle -> 573
    //   547: aload_3
    //   548: aload_1
    //   549: invokevirtual print : (Ljava/lang/String;)V
    //   552: aload_3
    //   553: ldc_w 'mAvailBackStackIndices: '
    //   556: invokevirtual print : (Ljava/lang/String;)V
    //   559: aload_3
    //   560: aload_0
    //   561: getfield k : Ljava/util/ArrayList;
    //   564: invokevirtual toArray : ()[Ljava/lang/Object;
    //   567: invokestatic toString : ([Ljava/lang/Object;)Ljava/lang/String;
    //   570: invokevirtual println : (Ljava/lang/String;)V
    //   573: aload_0
    //   574: monitorexit
    //   575: aload_0
    //   576: getfield c : Ljava/util/ArrayList;
    //   579: astore_2
    //   580: aload_2
    //   581: ifnull -> 670
    //   584: aload_2
    //   585: invokevirtual size : ()I
    //   588: istore #7
    //   590: iload #7
    //   592: ifle -> 670
    //   595: aload_3
    //   596: aload_1
    //   597: invokevirtual print : (Ljava/lang/String;)V
    //   600: aload_3
    //   601: ldc_w 'Pending Actions:'
    //   604: invokevirtual println : (Ljava/lang/String;)V
    //   607: iload #6
    //   609: istore #5
    //   611: iload #5
    //   613: iload #7
    //   615: if_icmpge -> 670
    //   618: aload_0
    //   619: getfield c : Ljava/util/ArrayList;
    //   622: iload #5
    //   624: invokevirtual get : (I)Ljava/lang/Object;
    //   627: checkcast androidx/fragment/app/FragmentManagerImpl$OpGenerator
    //   630: astore_2
    //   631: aload_3
    //   632: aload_1
    //   633: invokevirtual print : (Ljava/lang/String;)V
    //   636: aload_3
    //   637: ldc_w '  #'
    //   640: invokevirtual print : (Ljava/lang/String;)V
    //   643: aload_3
    //   644: iload #5
    //   646: invokevirtual print : (I)V
    //   649: aload_3
    //   650: ldc_w ': '
    //   653: invokevirtual print : (Ljava/lang/String;)V
    //   656: aload_3
    //   657: aload_2
    //   658: invokevirtual println : (Ljava/lang/Object;)V
    //   661: iload #5
    //   663: iconst_1
    //   664: iadd
    //   665: istore #5
    //   667: goto -> 611
    //   670: aload_3
    //   671: aload_1
    //   672: invokevirtual print : (Ljava/lang/String;)V
    //   675: aload_3
    //   676: ldc_w 'FragmentManager misc state:'
    //   679: invokevirtual println : (Ljava/lang/String;)V
    //   682: aload_3
    //   683: aload_1
    //   684: invokevirtual print : (Ljava/lang/String;)V
    //   687: aload_3
    //   688: ldc_w '  mHost='
    //   691: invokevirtual print : (Ljava/lang/String;)V
    //   694: aload_3
    //   695: aload_0
    //   696: getfield n : Landroidx/fragment/app/FragmentHostCallback;
    //   699: invokevirtual println : (Ljava/lang/Object;)V
    //   702: aload_3
    //   703: aload_1
    //   704: invokevirtual print : (Ljava/lang/String;)V
    //   707: aload_3
    //   708: ldc_w '  mContainer='
    //   711: invokevirtual print : (Ljava/lang/String;)V
    //   714: aload_3
    //   715: aload_0
    //   716: getfield o : Landroidx/fragment/app/FragmentContainer;
    //   719: invokevirtual println : (Ljava/lang/Object;)V
    //   722: aload_0
    //   723: getfield p : Landroidx/fragment/app/Fragment;
    //   726: ifnull -> 749
    //   729: aload_3
    //   730: aload_1
    //   731: invokevirtual print : (Ljava/lang/String;)V
    //   734: aload_3
    //   735: ldc_w '  mParent='
    //   738: invokevirtual print : (Ljava/lang/String;)V
    //   741: aload_3
    //   742: aload_0
    //   743: getfield p : Landroidx/fragment/app/Fragment;
    //   746: invokevirtual println : (Ljava/lang/Object;)V
    //   749: aload_3
    //   750: aload_1
    //   751: invokevirtual print : (Ljava/lang/String;)V
    //   754: aload_3
    //   755: ldc_w '  mCurState='
    //   758: invokevirtual print : (Ljava/lang/String;)V
    //   761: aload_3
    //   762: aload_0
    //   763: getfield m : I
    //   766: invokevirtual print : (I)V
    //   769: aload_3
    //   770: ldc_w ' mStateSaved='
    //   773: invokevirtual print : (Ljava/lang/String;)V
    //   776: aload_3
    //   777: aload_0
    //   778: getfield s : Z
    //   781: invokevirtual print : (Z)V
    //   784: aload_3
    //   785: ldc_w ' mStopped='
    //   788: invokevirtual print : (Ljava/lang/String;)V
    //   791: aload_3
    //   792: aload_0
    //   793: getfield t : Z
    //   796: invokevirtual print : (Z)V
    //   799: aload_3
    //   800: ldc_w ' mDestroyed='
    //   803: invokevirtual print : (Ljava/lang/String;)V
    //   806: aload_3
    //   807: aload_0
    //   808: getfield u : Z
    //   811: invokevirtual println : (Z)V
    //   814: aload_0
    //   815: getfield r : Z
    //   818: ifeq -> 841
    //   821: aload_3
    //   822: aload_1
    //   823: invokevirtual print : (Ljava/lang/String;)V
    //   826: aload_3
    //   827: ldc_w '  mNeedMenuInvalidate='
    //   830: invokevirtual print : (Ljava/lang/String;)V
    //   833: aload_3
    //   834: aload_0
    //   835: getfield r : Z
    //   838: invokevirtual println : (Z)V
    //   841: return
    //   842: astore_1
    //   843: aload_0
    //   844: monitorexit
    //   845: aload_1
    //   846: athrow
    // Exception table:
    //   from	to	target	type
    //   435	451	842	finally
    //   456	468	842	finally
    //   478	521	842	finally
    //   530	573	842	finally
    //   573	575	842	finally
    //   843	845	842	finally
  }
  
  void e() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield B : Ljava/util/ArrayList;
    //   6: astore #4
    //   8: iconst_0
    //   9: istore_3
    //   10: aload #4
    //   12: ifnull -> 100
    //   15: aload_0
    //   16: getfield B : Ljava/util/ArrayList;
    //   19: invokevirtual isEmpty : ()Z
    //   22: ifne -> 100
    //   25: iconst_1
    //   26: istore_1
    //   27: goto -> 30
    //   30: iload_3
    //   31: istore_2
    //   32: aload_0
    //   33: getfield c : Ljava/util/ArrayList;
    //   36: ifnull -> 105
    //   39: iload_3
    //   40: istore_2
    //   41: aload_0
    //   42: getfield c : Ljava/util/ArrayList;
    //   45: invokevirtual size : ()I
    //   48: iconst_1
    //   49: if_icmpne -> 105
    //   52: iconst_1
    //   53: istore_2
    //   54: goto -> 105
    //   57: aload_0
    //   58: getfield n : Landroidx/fragment/app/FragmentHostCallback;
    //   61: invokevirtual c : ()Landroid/os/Handler;
    //   64: aload_0
    //   65: getfield C : Ljava/lang/Runnable;
    //   68: invokevirtual removeCallbacks : (Ljava/lang/Runnable;)V
    //   71: aload_0
    //   72: getfield n : Landroidx/fragment/app/FragmentHostCallback;
    //   75: invokevirtual c : ()Landroid/os/Handler;
    //   78: aload_0
    //   79: getfield C : Ljava/lang/Runnable;
    //   82: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   85: pop
    //   86: aload_0
    //   87: invokespecial m : ()V
    //   90: aload_0
    //   91: monitorexit
    //   92: return
    //   93: astore #4
    //   95: aload_0
    //   96: monitorexit
    //   97: aload #4
    //   99: athrow
    //   100: iconst_0
    //   101: istore_1
    //   102: goto -> 30
    //   105: iload_1
    //   106: ifne -> 57
    //   109: iload_2
    //   110: ifeq -> 90
    //   113: goto -> 57
    // Exception table:
    //   from	to	target	type
    //   2	8	93	finally
    //   15	25	93	finally
    //   32	39	93	finally
    //   41	52	93	finally
    //   57	90	93	finally
    //   90	92	93	finally
    //   95	97	93	finally
  }
  
  void e(Fragment paramFragment) {
    if (isStateSaved()) {
      if (b)
        Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved"); 
      return;
    } 
    if (this.I.c(paramFragment) && b) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Updating retained Fragments: Removed ");
      stringBuilder.append(paramFragment);
      Log.v("FragmentManager", stringBuilder.toString());
    } 
  }
  
  void e(Fragment paramFragment, boolean paramBoolean) {
    Fragment fragment = this.p;
    if (fragment != null) {
      FragmentManager fragmentManager = fragment.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).e(paramFragment, true); 
    } 
    for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.H) {
      if (!paramBoolean || fragmentLifecycleCallbacksHolder.b)
        fragmentLifecycleCallbacksHolder.a.onFragmentViewDestroyed(this, paramFragment); 
    } 
  }
  
  public void enqueueAction(OpGenerator paramOpGenerator, boolean paramBoolean) {
    // Byte code:
    //   0: iload_2
    //   1: ifne -> 8
    //   4: aload_0
    //   5: invokespecial n : ()V
    //   8: aload_0
    //   9: monitorenter
    //   10: aload_0
    //   11: getfield u : Z
    //   14: ifne -> 61
    //   17: aload_0
    //   18: getfield n : Landroidx/fragment/app/FragmentHostCallback;
    //   21: ifnonnull -> 27
    //   24: goto -> 61
    //   27: aload_0
    //   28: getfield c : Ljava/util/ArrayList;
    //   31: ifnonnull -> 45
    //   34: aload_0
    //   35: new java/util/ArrayList
    //   38: dup
    //   39: invokespecial <init> : ()V
    //   42: putfield c : Ljava/util/ArrayList;
    //   45: aload_0
    //   46: getfield c : Ljava/util/ArrayList;
    //   49: aload_1
    //   50: invokevirtual add : (Ljava/lang/Object;)Z
    //   53: pop
    //   54: aload_0
    //   55: invokevirtual e : ()V
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
  
  public boolean execPendingActions() {
    a(true);
    boolean bool = false;
    while (c(this.w, this.x)) {
      this.d = true;
      try {
        b(this.w, this.x);
        o();
      } finally {
        o();
      } 
    } 
    m();
    f();
    r();
    return bool;
  }
  
  public void execSingleAction(OpGenerator paramOpGenerator, boolean paramBoolean) {
    if (paramBoolean && (this.n == null || this.u))
      return; 
    a(paramBoolean);
    if (paramOpGenerator.generateOps(this.w, this.x)) {
      this.d = true;
      try {
        b(this.w, this.x);
      } finally {
        o();
      } 
    } 
    m();
    f();
    r();
  }
  
  public boolean executePendingTransactions() {
    boolean bool = execPendingActions();
    p();
    return bool;
  }
  
  void f() {
    if (this.v) {
      this.v = false;
      d();
    } 
  }
  
  void f(Fragment paramFragment) {
    a(paramFragment, this.m, 0, 0, false);
  }
  
  void f(Fragment paramFragment, boolean paramBoolean) {
    Fragment fragment = this.p;
    if (fragment != null) {
      FragmentManager fragmentManager = fragment.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).f(paramFragment, true); 
    } 
    for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.H) {
      if (!paramBoolean || fragmentLifecycleCallbacksHolder.b)
        fragmentLifecycleCallbacksHolder.a.onFragmentDestroyed(this, paramFragment); 
    } 
  }
  
  public Fragment findFragmentById(int paramInt) {
    for (int i = this.f.size() - 1; i >= 0; i--) {
      Fragment fragment = this.f.get(i);
      if (fragment != null && fragment.mFragmentId == paramInt)
        return fragment; 
    } 
    for (Fragment fragment : this.g.values()) {
      if (fragment != null && fragment.mFragmentId == paramInt)
        return fragment; 
    } 
    return null;
  }
  
  public Fragment findFragmentByTag(String paramString) {
    if (paramString != null)
      for (int i = this.f.size() - 1; i >= 0; i--) {
        Fragment fragment = this.f.get(i);
        if (fragment != null && paramString.equals(fragment.mTag))
          return fragment; 
      }  
    if (paramString != null)
      for (Fragment fragment : this.g.values()) {
        if (fragment != null && paramString.equals(fragment.mTag))
          return fragment; 
      }  
    return null;
  }
  
  public Fragment findFragmentByWho(String paramString) {
    for (Fragment fragment : this.g.values()) {
      if (fragment != null) {
        fragment = fragment.findFragmentByWho(paramString);
        if (fragment != null)
          return fragment; 
      } 
    } 
    return null;
  }
  
  public void freeBackStackIndex(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield j : Ljava/util/ArrayList;
    //   6: iload_1
    //   7: aconst_null
    //   8: invokevirtual set : (ILjava/lang/Object;)Ljava/lang/Object;
    //   11: pop
    //   12: aload_0
    //   13: getfield k : Ljava/util/ArrayList;
    //   16: ifnonnull -> 30
    //   19: aload_0
    //   20: new java/util/ArrayList
    //   23: dup
    //   24: invokespecial <init> : ()V
    //   27: putfield k : Ljava/util/ArrayList;
    //   30: getstatic androidx/fragment/app/FragmentManagerImpl.b : Z
    //   33: ifeq -> 69
    //   36: new java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial <init> : ()V
    //   43: astore_2
    //   44: aload_2
    //   45: ldc_w 'Freeing back stack index '
    //   48: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload_2
    //   53: iload_1
    //   54: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: ldc_w 'FragmentManager'
    //   61: aload_2
    //   62: invokevirtual toString : ()Ljava/lang/String;
    //   65: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   68: pop
    //   69: aload_0
    //   70: getfield k : Ljava/util/ArrayList;
    //   73: iload_1
    //   74: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   77: invokevirtual add : (Ljava/lang/Object;)Z
    //   80: pop
    //   81: aload_0
    //   82: monitorexit
    //   83: return
    //   84: astore_2
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_2
    //   88: athrow
    // Exception table:
    //   from	to	target	type
    //   2	30	84	finally
    //   30	69	84	finally
    //   69	83	84	finally
    //   85	87	84	finally
  }
  
  void g() {
    if (this.l != null)
      for (int i = 0; i < this.l.size(); i++)
        ((FragmentManager.OnBackStackChangedListener)this.l.get(i)).onBackStackChanged();  
  }
  
  void g(Fragment paramFragment) {
    if (paramFragment.mFromLayout && !paramFragment.mPerformedCreateView) {
      paramFragment.performCreateView(paramFragment.performGetLayoutInflater(paramFragment.mSavedFragmentState), null, paramFragment.mSavedFragmentState);
      if (paramFragment.mView != null) {
        paramFragment.mInnerView = paramFragment.mView;
        paramFragment.mView.setSaveFromParentEnabled(false);
        if (paramFragment.mHidden)
          paramFragment.mView.setVisibility(8); 
        paramFragment.onViewCreated(paramFragment.mView, paramFragment.mSavedFragmentState);
        a(paramFragment, paramFragment.mView, paramFragment.mSavedFragmentState, false);
        return;
      } 
      paramFragment.mInnerView = null;
    } 
  }
  
  void g(Fragment paramFragment, boolean paramBoolean) {
    Fragment fragment = this.p;
    if (fragment != null) {
      FragmentManager fragmentManager = fragment.getFragmentManager();
      if (fragmentManager instanceof FragmentManagerImpl)
        ((FragmentManagerImpl)fragmentManager).g(paramFragment, true); 
    } 
    for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.H) {
      if (!paramBoolean || fragmentLifecycleCallbacksHolder.b)
        fragmentLifecycleCallbacksHolder.a.onFragmentDetached(this, paramFragment); 
    } 
  }
  
  public FragmentManager.BackStackEntry getBackStackEntryAt(int paramInt) {
    return this.h.get(paramInt);
  }
  
  public int getBackStackEntryCount() {
    ArrayList<BackStackRecord> arrayList = this.h;
    return (arrayList != null) ? arrayList.size() : 0;
  }
  
  public Fragment getFragment(Bundle paramBundle, String paramString) {
    String str = paramBundle.getString(paramString);
    if (str == null)
      return null; 
    Fragment fragment = this.g.get(str);
    if (fragment == null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Fragment no longer exists for key ");
      stringBuilder.append(paramString);
      stringBuilder.append(": unique id ");
      stringBuilder.append(str);
      a(new IllegalStateException(stringBuilder.toString()));
    } 
    return fragment;
  }
  
  public FragmentFactory getFragmentFactory() {
    if (super.getFragmentFactory() == a) {
      Fragment fragment = this.p;
      if (fragment != null)
        return fragment.mFragmentManager.getFragmentFactory(); 
      setFragmentFactory(new FragmentFactory(this) {
            public Fragment instantiate(ClassLoader param1ClassLoader, String param1String) {
              return this.a.n.instantiate(this.a.n.b(), param1String, null);
            }
          });
    } 
    return super.getFragmentFactory();
  }
  
  public List<Fragment> getFragments() {
    if (this.f.isEmpty())
      return Collections.emptyList(); 
    synchronized (this.f) {
      return (List)this.f.clone();
    } 
  }
  
  public Fragment getPrimaryNavigationFragment() {
    return this.q;
  }
  
  @Deprecated
  FragmentManagerNonConfig h() {
    if (this.n instanceof ViewModelStoreOwner)
      a(new IllegalStateException("You cannot use retainNonConfig when your FragmentHostCallback implements ViewModelStoreOwner.")); 
    return this.I.c();
  }
  
  void h(Fragment paramFragment) {
    if (paramFragment.mView != null) {
      AnimationOrAnimator animationOrAnimator = a(paramFragment, paramFragment.getNextTransition(), paramFragment.mHidden ^ true, paramFragment.getNextTransitionStyle());
      if (animationOrAnimator != null && animationOrAnimator.animator != null) {
        animationOrAnimator.animator.setTarget(paramFragment.mView);
        if (paramFragment.mHidden) {
          if (paramFragment.isHideReplaced()) {
            paramFragment.setHideReplaced(false);
          } else {
            ViewGroup viewGroup = paramFragment.mContainer;
            View view = paramFragment.mView;
            viewGroup.startViewTransition(view);
            animationOrAnimator.animator.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this, viewGroup, view, paramFragment) {
                  public void onAnimationEnd(Animator param1Animator) {
                    this.a.endViewTransition(this.b);
                    param1Animator.removeListener((Animator.AnimatorListener)this);
                    if (this.c.mView != null && this.c.mHidden)
                      this.c.mView.setVisibility(8); 
                  }
                });
          } 
        } else {
          paramFragment.mView.setVisibility(0);
        } 
        animationOrAnimator.animator.start();
      } else {
        boolean bool;
        if (animationOrAnimator != null) {
          paramFragment.mView.startAnimation(animationOrAnimator.animation);
          animationOrAnimator.animation.start();
        } 
        if (paramFragment.mHidden && !paramFragment.isHideReplaced()) {
          bool = true;
        } else {
          bool = false;
        } 
        paramFragment.mView.setVisibility(bool);
        if (paramFragment.isHideReplaced())
          paramFragment.setHideReplaced(false); 
      } 
    } 
    if (paramFragment.mAdded && p(paramFragment))
      this.r = true; 
    paramFragment.mHiddenChanged = false;
    paramFragment.onHiddenChanged(paramFragment.mHidden);
  }
  
  public void hideFragment(Fragment paramFragment) {
    if (b) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("hide: ");
      stringBuilder.append(paramFragment);
      Log.v("FragmentManager", stringBuilder.toString());
    } 
    if (!paramFragment.mHidden) {
      paramFragment.mHidden = true;
      paramFragment.mHiddenChanged = true ^ paramFragment.mHiddenChanged;
    } 
  }
  
  Parcelable i() {
    StringBuilder stringBuilder;
    p();
    q();
    execPendingActions();
    this.s = true;
    boolean bool1 = this.g.isEmpty();
    BackStackState[] arrayOfBackStackState2 = null;
    if (bool1)
      return null; 
    ArrayList<FragmentState> arrayList = new ArrayList(this.g.size());
    Iterator<Fragment> iterator = this.g.values().iterator();
    boolean bool = false;
    int i = 0;
    while (iterator.hasNext()) {
      Fragment fragment1 = iterator.next();
      if (fragment1 != null) {
        if (fragment1.mFragmentManager != this) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("Failure saving state: active ");
          stringBuilder1.append(fragment1);
          stringBuilder1.append(" was removed from the FragmentManager");
          a(new IllegalStateException(stringBuilder1.toString()));
        } 
        FragmentState fragmentState = new FragmentState(fragment1);
        arrayList.add(fragmentState);
        if (fragment1.mState > 0 && fragmentState.m == null) {
          fragmentState.m = m(fragment1);
          if (fragment1.mTargetWho != null) {
            Fragment fragment2 = this.g.get(fragment1.mTargetWho);
            if (fragment2 == null) {
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append("Failure saving state: ");
              stringBuilder1.append(fragment1);
              stringBuilder1.append(" has target not in fragment manager: ");
              stringBuilder1.append(fragment1.mTargetWho);
              a(new IllegalStateException(stringBuilder1.toString()));
            } 
            if (fragmentState.m == null)
              fragmentState.m = new Bundle(); 
            putFragment(fragmentState.m, "android:target_state", fragment2);
            if (fragment1.mTargetRequestCode != 0)
              fragmentState.m.putInt("android:target_req_state", fragment1.mTargetRequestCode); 
          } 
        } else {
          fragmentState.m = fragment1.mSavedFragmentState;
        } 
        if (b) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("Saved state of ");
          stringBuilder1.append(fragment1);
          stringBuilder1.append(": ");
          stringBuilder1.append(fragmentState.m);
          Log.v("FragmentManager", stringBuilder1.toString());
        } 
        i = 1;
      } 
    } 
    if (!i) {
      if (b)
        Log.v("FragmentManager", "saveAllState: no fragments!"); 
      return null;
    } 
    i = this.f.size();
    if (i > 0) {
      ArrayList<String> arrayList2 = new ArrayList(i);
      Iterator<Fragment> iterator1 = this.f.iterator();
      while (true) {
        ArrayList<String> arrayList3 = arrayList2;
        if (iterator1.hasNext()) {
          Fragment fragment1 = iterator1.next();
          arrayList2.add(fragment1.mWho);
          if (fragment1.mFragmentManager != this) {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("Failure saving state: active ");
            stringBuilder1.append(fragment1);
            stringBuilder1.append(" was removed from the FragmentManager");
            a(new IllegalStateException(stringBuilder1.toString()));
          } 
          if (b) {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("saveAllState: adding fragment (");
            stringBuilder1.append(fragment1.mWho);
            stringBuilder1.append("): ");
            stringBuilder1.append(fragment1);
            Log.v("FragmentManager", stringBuilder1.toString());
          } 
          continue;
        } 
        break;
      } 
    } else {
      iterator = null;
    } 
    ArrayList<BackStackRecord> arrayList1 = this.h;
    BackStackState[] arrayOfBackStackState1 = arrayOfBackStackState2;
    if (arrayList1 != null) {
      int j = arrayList1.size();
      arrayOfBackStackState1 = arrayOfBackStackState2;
      if (j > 0) {
        arrayOfBackStackState2 = new BackStackState[j];
        i = bool;
        while (true) {
          arrayOfBackStackState1 = arrayOfBackStackState2;
          if (i < j) {
            arrayOfBackStackState2[i] = new BackStackState(this.h.get(i));
            if (b) {
              stringBuilder = new StringBuilder();
              stringBuilder.append("saveAllState: adding back stack #");
              stringBuilder.append(i);
              stringBuilder.append(": ");
              stringBuilder.append(this.h.get(i));
              Log.v("FragmentManager", stringBuilder.toString());
            } 
            i++;
            continue;
          } 
          break;
        } 
      } 
    } 
    FragmentManagerState fragmentManagerState = new FragmentManagerState();
    fragmentManagerState.a = arrayList;
    fragmentManagerState.b = (ArrayList)iterator;
    fragmentManagerState.c = (BackStackState[])stringBuilder;
    Fragment fragment = this.q;
    if (fragment != null)
      fragmentManagerState.d = fragment.mWho; 
    fragmentManagerState.e = this.e;
    return fragmentManagerState;
  }
  
  void i(Fragment paramFragment) {
    if (paramFragment == null)
      return; 
    if (!this.g.containsKey(paramFragment.mWho)) {
      if (b) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Ignoring moving ");
        stringBuilder.append(paramFragment);
        stringBuilder.append(" to state ");
        stringBuilder.append(this.m);
        stringBuilder.append("since it is not added to ");
        stringBuilder.append(this);
        Log.v("FragmentManager", stringBuilder.toString());
      } 
      return;
    } 
    int j = this.m;
    int i = j;
    if (paramFragment.mRemoving)
      if (paramFragment.isInBackStack()) {
        i = Math.min(j, 1);
      } else {
        i = Math.min(j, 0);
      }  
    a(paramFragment, i, paramFragment.getNextTransition(), paramFragment.getNextTransitionStyle(), false);
    if (paramFragment.mView != null) {
      Fragment fragment = n(paramFragment);
      if (fragment != null) {
        View view = fragment.mView;
        ViewGroup viewGroup = paramFragment.mContainer;
        i = viewGroup.indexOfChild(view);
        j = viewGroup.indexOfChild(paramFragment.mView);
        if (j < i) {
          viewGroup.removeViewAt(j);
          viewGroup.addView(paramFragment.mView, i);
        } 
      } 
      if (paramFragment.mIsNewlyAdded && paramFragment.mContainer != null) {
        if (paramFragment.mPostponedAlpha > 0.0F)
          paramFragment.mView.setAlpha(paramFragment.mPostponedAlpha); 
        paramFragment.mPostponedAlpha = 0.0F;
        paramFragment.mIsNewlyAdded = false;
        AnimationOrAnimator animationOrAnimator = a(paramFragment, paramFragment.getNextTransition(), true, paramFragment.getNextTransitionStyle());
        if (animationOrAnimator != null)
          if (animationOrAnimator.animation != null) {
            paramFragment.mView.startAnimation(animationOrAnimator.animation);
          } else {
            animationOrAnimator.animator.setTarget(paramFragment.mView);
            animationOrAnimator.animator.start();
          }  
      } 
    } 
    if (paramFragment.mHiddenChanged)
      h(paramFragment); 
  }
  
  public boolean isDestroyed() {
    return this.u;
  }
  
  public boolean isStateSaved() {
    return (this.s || this.t);
  }
  
  void j() {
    m();
    o(this.q);
  }
  
  void j(Fragment paramFragment) {
    if (this.g.get(paramFragment.mWho) != null)
      return; 
    this.g.put(paramFragment.mWho, paramFragment);
    if (paramFragment.mRetainInstanceChangedWhileDetached) {
      if (paramFragment.mRetainInstance) {
        d(paramFragment);
      } else {
        e(paramFragment);
      } 
      paramFragment.mRetainInstanceChangedWhileDetached = false;
    } 
    if (b) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Added fragment to active set ");
      stringBuilder.append(paramFragment);
      Log.v("FragmentManager", stringBuilder.toString());
    } 
  }
  
  void k(Fragment paramFragment) {
    if (this.g.get(paramFragment.mWho) == null)
      return; 
    if (b) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Removed fragment from active set ");
      stringBuilder.append(paramFragment);
      Log.v("FragmentManager", stringBuilder.toString());
    } 
    for (Fragment fragment : this.g.values()) {
      if (fragment != null && paramFragment.mWho.equals(fragment.mTargetWho)) {
        fragment.mTarget = paramFragment;
        fragment.mTargetWho = null;
      } 
    } 
    this.g.put(paramFragment.mWho, null);
    e(paramFragment);
    if (paramFragment.mTargetWho != null)
      paramFragment.mTarget = this.g.get(paramFragment.mTargetWho); 
    paramFragment.initState();
  }
  
  boolean k() {
    Iterator<Fragment> iterator = this.g.values().iterator();
    boolean bool = false;
    while (iterator.hasNext()) {
      Fragment fragment = iterator.next();
      boolean bool1 = bool;
      if (fragment != null)
        bool1 = p(fragment); 
      bool = bool1;
      if (bool1)
        return true; 
    } 
    return false;
  }
  
  LayoutInflater.Factory2 l() {
    return this;
  }
  
  void l(Fragment paramFragment) {
    if (paramFragment.mInnerView == null)
      return; 
    SparseArray<Parcelable> sparseArray = this.A;
    if (sparseArray == null) {
      this.A = new SparseArray();
    } else {
      sparseArray.clear();
    } 
    paramFragment.mInnerView.saveHierarchyState(this.A);
    if (this.A.size() > 0) {
      paramFragment.mSavedViewState = this.A;
      this.A = null;
    } 
  }
  
  Bundle m(Fragment paramFragment) {
    if (this.z == null)
      this.z = new Bundle(); 
    paramFragment.performSaveInstanceState(this.z);
    d(paramFragment, this.z, false);
    if (!this.z.isEmpty()) {
      bundle2 = this.z;
      this.z = null;
    } else {
      bundle2 = null;
    } 
    if (paramFragment.mView != null)
      l(paramFragment); 
    Bundle bundle1 = bundle2;
    if (paramFragment.mSavedViewState != null) {
      bundle1 = bundle2;
      if (bundle2 == null)
        bundle1 = new Bundle(); 
      bundle1.putSparseParcelableArray("android:view_state", paramFragment.mSavedViewState);
    } 
    Bundle bundle2 = bundle1;
    if (!paramFragment.mUserVisibleHint) {
      bundle2 = bundle1;
      if (bundle1 == null)
        bundle2 = new Bundle(); 
      bundle2.putBoolean("android:user_visible_hint", paramFragment.mUserVisibleHint);
    } 
    return bundle2;
  }
  
  public void noteStateNotSaved() {
    int i = 0;
    this.s = false;
    this.t = false;
    int j = this.f.size();
    while (i < j) {
      Fragment fragment = this.f.get(i);
      if (fragment != null)
        fragment.noteStateNotSaved(); 
      i++;
    } 
  }
  
  public View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet) {
    boolean bool = "fragment".equals(paramString);
    paramString = null;
    if (!bool)
      return null; 
    String str2 = paramAttributeSet.getAttributeValue(null, "class");
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, FragmentTag.Fragment);
    int i = 0;
    String str1 = str2;
    if (str2 == null)
      str1 = typedArray.getString(0); 
    int j = typedArray.getResourceId(1, -1);
    str2 = typedArray.getString(2);
    typedArray.recycle();
    if (str1 != null) {
      if (!FragmentFactory.a(paramContext.getClassLoader(), str1))
        return null; 
      if (paramView != null)
        i = paramView.getId(); 
      if (i != -1 || j != -1 || str2 != null) {
        String str = paramString;
        if (j != -1)
          fragment1 = findFragmentById(j); 
        Fragment fragment2 = fragment1;
        if (fragment1 == null) {
          fragment2 = fragment1;
          if (str2 != null)
            fragment2 = findFragmentByTag(str2); 
        } 
        Fragment fragment1 = fragment2;
        if (fragment2 == null) {
          fragment1 = fragment2;
          if (i != -1)
            fragment1 = findFragmentById(i); 
        } 
        if (b) {
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("onCreateView: id=0x");
          stringBuilder2.append(Integer.toHexString(j));
          stringBuilder2.append(" fname=");
          stringBuilder2.append(str1);
          stringBuilder2.append(" existing=");
          stringBuilder2.append(fragment1);
          Log.v("FragmentManager", stringBuilder2.toString());
        } 
        if (fragment1 == null) {
          int k;
          fragment1 = getFragmentFactory().instantiate(paramContext.getClassLoader(), str1);
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
          FragmentHostCallback fragmentHostCallback = this.n;
          fragment1.mHost = fragmentHostCallback;
          fragment1.onInflate(fragmentHostCallback.b(), paramAttributeSet, fragment1.mSavedFragmentState);
          addFragment(fragment1, true);
        } else if (!fragment1.mInLayout) {
          fragment1.mInLayout = true;
          FragmentHostCallback fragmentHostCallback = this.n;
          fragment1.mHost = fragmentHostCallback;
          fragment1.onInflate(fragmentHostCallback.b(), paramAttributeSet, fragment1.mSavedFragmentState);
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
        if (this.m < 1 && ((Fragment)stringBuilder1).mFromLayout) {
          a((Fragment)stringBuilder1, 1, 0, 0, false);
        } else {
          f((Fragment)stringBuilder1);
        } 
        if (((Fragment)stringBuilder1).mView != null) {
          if (j != 0)
            ((Fragment)stringBuilder1).mView.setId(j); 
          if (((Fragment)stringBuilder1).mView.getTag() == null)
            ((Fragment)stringBuilder1).mView.setTag(str2); 
          return ((Fragment)stringBuilder1).mView;
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Fragment ");
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
    return null;
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet) {
    return onCreateView((View)null, paramString, paramContext, paramAttributeSet);
  }
  
  public void performPendingDeferredStart(Fragment paramFragment) {
    if (paramFragment.mDeferStart) {
      if (this.d) {
        this.v = true;
        return;
      } 
      paramFragment.mDeferStart = false;
      a(paramFragment, this.m, 0, 0, false);
    } 
  }
  
  public void popBackStack() {
    enqueueAction(new PopBackStackState(this, null, -1, 0), false);
  }
  
  public void popBackStack(int paramInt1, int paramInt2) {
    if (paramInt1 >= 0) {
      enqueueAction(new PopBackStackState(this, null, paramInt1, paramInt2), false);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Bad id: ");
    stringBuilder.append(paramInt1);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public void popBackStack(String paramString, int paramInt) {
    enqueueAction(new PopBackStackState(this, paramString, -1, paramInt), false);
  }
  
  public boolean popBackStackImmediate() {
    n();
    return a((String)null, -1, 0);
  }
  
  public boolean popBackStackImmediate(int paramInt1, int paramInt2) {
    n();
    execPendingActions();
    if (paramInt1 >= 0)
      return a((String)null, paramInt1, paramInt2); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Bad id: ");
    stringBuilder.append(paramInt1);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public boolean popBackStackImmediate(String paramString, int paramInt) {
    n();
    return a(paramString, -1, paramInt);
  }
  
  public void putFragment(Bundle paramBundle, String paramString, Fragment paramFragment) {
    if (paramFragment.mFragmentManager != this) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Fragment ");
      stringBuilder.append(paramFragment);
      stringBuilder.append(" is not currently in the FragmentManager");
      a(new IllegalStateException(stringBuilder.toString()));
    } 
    paramBundle.putString(paramString, paramFragment.mWho);
  }
  
  public void registerFragmentLifecycleCallbacks(FragmentManager.FragmentLifecycleCallbacks paramFragmentLifecycleCallbacks, boolean paramBoolean) {
    this.H.add(new FragmentLifecycleCallbacksHolder(paramFragmentLifecycleCallbacks, paramBoolean));
  }
  
  public void removeFragment(Fragment paramFragment) {
    if (b) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("remove: ");
      stringBuilder.append(paramFragment);
      stringBuilder.append(" nesting=");
      stringBuilder.append(paramFragment.mBackStackNesting);
      Log.v("FragmentManager", stringBuilder.toString());
    } 
    boolean bool = paramFragment.isInBackStack();
    if (!paramFragment.mDetached || (bool ^ true) != 0)
      synchronized (this.f) {
        this.f.remove(paramFragment);
        if (p(paramFragment))
          this.r = true; 
        paramFragment.mAdded = false;
        paramFragment.mRemoving = true;
        return;
      }  
  }
  
  public void removeOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener paramOnBackStackChangedListener) {
    ArrayList<FragmentManager.OnBackStackChangedListener> arrayList = this.l;
    if (arrayList != null)
      arrayList.remove(paramOnBackStackChangedListener); 
  }
  
  public Fragment.SavedState saveFragmentInstanceState(Fragment paramFragment) {
    if (paramFragment.mFragmentManager != this) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Fragment ");
      stringBuilder.append(paramFragment);
      stringBuilder.append(" is not currently in the FragmentManager");
      a(new IllegalStateException(stringBuilder.toString()));
    } 
    int i = paramFragment.mState;
    Fragment.SavedState savedState2 = null;
    Fragment.SavedState savedState1 = savedState2;
    if (i > 0) {
      Bundle bundle = m(paramFragment);
      savedState1 = savedState2;
      if (bundle != null)
        savedState1 = new Fragment.SavedState(bundle); 
    } 
    return savedState1;
  }
  
  public void setBackStackIndex(int paramInt, BackStackRecord paramBackStackRecord) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield j : Ljava/util/ArrayList;
    //   6: ifnonnull -> 20
    //   9: aload_0
    //   10: new java/util/ArrayList
    //   13: dup
    //   14: invokespecial <init> : ()V
    //   17: putfield j : Ljava/util/ArrayList;
    //   20: aload_0
    //   21: getfield j : Ljava/util/ArrayList;
    //   24: invokevirtual size : ()I
    //   27: istore #4
    //   29: iload #4
    //   31: istore_3
    //   32: iload_1
    //   33: iload #4
    //   35: if_icmpge -> 110
    //   38: getstatic androidx/fragment/app/FragmentManagerImpl.b : Z
    //   41: ifeq -> 97
    //   44: new java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial <init> : ()V
    //   51: astore #5
    //   53: aload #5
    //   55: ldc_w 'Setting back stack index '
    //   58: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload #5
    //   64: iload_1
    //   65: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload #5
    //   71: ldc_w ' to '
    //   74: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload #5
    //   80: aload_2
    //   81: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: ldc_w 'FragmentManager'
    //   88: aload #5
    //   90: invokevirtual toString : ()Ljava/lang/String;
    //   93: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   96: pop
    //   97: aload_0
    //   98: getfield j : Ljava/util/ArrayList;
    //   101: iload_1
    //   102: aload_2
    //   103: invokevirtual set : (ILjava/lang/Object;)Ljava/lang/Object;
    //   106: pop
    //   107: goto -> 272
    //   110: iload_3
    //   111: iload_1
    //   112: if_icmpge -> 204
    //   115: aload_0
    //   116: getfield j : Ljava/util/ArrayList;
    //   119: aconst_null
    //   120: invokevirtual add : (Ljava/lang/Object;)Z
    //   123: pop
    //   124: aload_0
    //   125: getfield k : Ljava/util/ArrayList;
    //   128: ifnonnull -> 142
    //   131: aload_0
    //   132: new java/util/ArrayList
    //   135: dup
    //   136: invokespecial <init> : ()V
    //   139: putfield k : Ljava/util/ArrayList;
    //   142: getstatic androidx/fragment/app/FragmentManagerImpl.b : Z
    //   145: ifeq -> 185
    //   148: new java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial <init> : ()V
    //   155: astore #5
    //   157: aload #5
    //   159: ldc_w 'Adding available back stack index '
    //   162: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: aload #5
    //   168: iload_3
    //   169: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: ldc_w 'FragmentManager'
    //   176: aload #5
    //   178: invokevirtual toString : ()Ljava/lang/String;
    //   181: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   184: pop
    //   185: aload_0
    //   186: getfield k : Ljava/util/ArrayList;
    //   189: iload_3
    //   190: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   193: invokevirtual add : (Ljava/lang/Object;)Z
    //   196: pop
    //   197: iload_3
    //   198: iconst_1
    //   199: iadd
    //   200: istore_3
    //   201: goto -> 110
    //   204: getstatic androidx/fragment/app/FragmentManagerImpl.b : Z
    //   207: ifeq -> 263
    //   210: new java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial <init> : ()V
    //   217: astore #5
    //   219: aload #5
    //   221: ldc_w 'Adding back stack index '
    //   224: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: aload #5
    //   230: iload_1
    //   231: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload #5
    //   237: ldc_w ' with '
    //   240: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: aload #5
    //   246: aload_2
    //   247: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: ldc_w 'FragmentManager'
    //   254: aload #5
    //   256: invokevirtual toString : ()Ljava/lang/String;
    //   259: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   262: pop
    //   263: aload_0
    //   264: getfield j : Ljava/util/ArrayList;
    //   267: aload_2
    //   268: invokevirtual add : (Ljava/lang/Object;)Z
    //   271: pop
    //   272: aload_0
    //   273: monitorexit
    //   274: return
    //   275: astore_2
    //   276: aload_0
    //   277: monitorexit
    //   278: aload_2
    //   279: athrow
    // Exception table:
    //   from	to	target	type
    //   2	20	275	finally
    //   20	29	275	finally
    //   38	97	275	finally
    //   97	107	275	finally
    //   115	142	275	finally
    //   142	185	275	finally
    //   185	197	275	finally
    //   204	263	275	finally
    //   263	272	275	finally
    //   272	274	275	finally
    //   276	278	275	finally
  }
  
  public void setMaxLifecycle(Fragment paramFragment, Lifecycle.State paramState) {
    if (this.g.get(paramFragment.mWho) == paramFragment && (paramFragment.mHost == null || paramFragment.getFragmentManager() == this)) {
      paramFragment.mMaxState = paramState;
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Fragment ");
    stringBuilder.append(paramFragment);
    stringBuilder.append(" is not an active fragment of FragmentManager ");
    stringBuilder.append(this);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public void setPrimaryNavigationFragment(Fragment paramFragment) {
    if (paramFragment == null || (this.g.get(paramFragment.mWho) == paramFragment && (paramFragment.mHost == null || paramFragment.getFragmentManager() == this))) {
      Fragment fragment = this.q;
      this.q = paramFragment;
      o(fragment);
      o(this.q);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Fragment ");
    stringBuilder.append(paramFragment);
    stringBuilder.append(" is not an active fragment of FragmentManager ");
    stringBuilder.append(this);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public void showFragment(Fragment paramFragment) {
    if (b) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("show: ");
      stringBuilder.append(paramFragment);
      Log.v("FragmentManager", stringBuilder.toString());
    } 
    if (paramFragment.mHidden) {
      paramFragment.mHidden = false;
      paramFragment.mHiddenChanged ^= 0x1;
    } 
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);
    stringBuilder.append("FragmentManager{");
    stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    stringBuilder.append(" in ");
    Fragment fragment = this.p;
    if (fragment != null) {
      DebugUtils.buildShortClassTag(fragment, stringBuilder);
    } else {
      DebugUtils.buildShortClassTag(this.n, stringBuilder);
    } 
    stringBuilder.append("}}");
    return stringBuilder.toString();
  }
  
  public void unregisterFragmentLifecycleCallbacks(FragmentManager.FragmentLifecycleCallbacks paramFragmentLifecycleCallbacks) {
    // Byte code:
    //   0: aload_0
    //   1: getfield H : Ljava/util/concurrent/CopyOnWriteArrayList;
    //   4: astore #4
    //   6: aload #4
    //   8: monitorenter
    //   9: iconst_0
    //   10: istore_2
    //   11: aload_0
    //   12: getfield H : Ljava/util/concurrent/CopyOnWriteArrayList;
    //   15: invokevirtual size : ()I
    //   18: istore_3
    //   19: iload_2
    //   20: iload_3
    //   21: if_icmpge -> 54
    //   24: aload_0
    //   25: getfield H : Ljava/util/concurrent/CopyOnWriteArrayList;
    //   28: iload_2
    //   29: invokevirtual get : (I)Ljava/lang/Object;
    //   32: checkcast androidx/fragment/app/FragmentManagerImpl$FragmentLifecycleCallbacksHolder
    //   35: getfield a : Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;
    //   38: aload_1
    //   39: if_acmpne -> 64
    //   42: aload_0
    //   43: getfield H : Ljava/util/concurrent/CopyOnWriteArrayList;
    //   46: iload_2
    //   47: invokevirtual remove : (I)Ljava/lang/Object;
    //   50: pop
    //   51: goto -> 54
    //   54: aload #4
    //   56: monitorexit
    //   57: return
    //   58: astore_1
    //   59: aload #4
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    //   64: iload_2
    //   65: iconst_1
    //   66: iadd
    //   67: istore_2
    //   68: goto -> 19
    // Exception table:
    //   from	to	target	type
    //   11	19	58	finally
    //   24	51	58	finally
    //   54	57	58	finally
    //   59	62	58	finally
  }
  
  static class AnimationOrAnimator {
    public final Animation animation = null;
    
    public final Animator animator;
    
    AnimationOrAnimator(Animator param1Animator) {
      this.animator = param1Animator;
      if (param1Animator != null)
        return; 
      throw new IllegalStateException("Animator cannot be null");
    }
    
    AnimationOrAnimator(Animation param1Animation) {
      this.animator = null;
      if (param1Animation != null)
        return; 
      throw new IllegalStateException("Animation cannot be null");
    }
  }
  
  static class EndViewTransitionAnimation extends AnimationSet implements Runnable {
    private final ViewGroup a;
    
    private final View b;
    
    private boolean c;
    
    private boolean d;
    
    private boolean e = true;
    
    EndViewTransitionAnimation(Animation param1Animation, ViewGroup param1ViewGroup, View param1View) {
      super(false);
      this.a = param1ViewGroup;
      this.b = param1View;
      addAnimation(param1Animation);
      this.a.post(this);
    }
    
    public boolean getTransformation(long param1Long, Transformation param1Transformation) {
      this.e = true;
      if (this.c)
        return this.d ^ true; 
      if (!super.getTransformation(param1Long, param1Transformation)) {
        this.c = true;
        OneShotPreDrawListener.add((View)this.a, this);
      } 
      return true;
    }
    
    public boolean getTransformation(long param1Long, Transformation param1Transformation, float param1Float) {
      this.e = true;
      if (this.c)
        return this.d ^ true; 
      if (!super.getTransformation(param1Long, param1Transformation, param1Float)) {
        this.c = true;
        OneShotPreDrawListener.add((View)this.a, this);
      } 
      return true;
    }
    
    public void run() {
      if (!this.c && this.e) {
        this.e = false;
        this.a.post(this);
        return;
      } 
      this.a.endViewTransition(this.b);
      this.d = true;
    }
  }
  
  static final class FragmentLifecycleCallbacksHolder {
    final FragmentManager.FragmentLifecycleCallbacks a;
    
    final boolean b;
    
    FragmentLifecycleCallbacksHolder(FragmentManager.FragmentLifecycleCallbacks param1FragmentLifecycleCallbacks, boolean param1Boolean) {
      this.a = param1FragmentLifecycleCallbacks;
      this.b = param1Boolean;
    }
  }
  
  static class FragmentTag {
    public static final int[] Fragment = new int[] { 16842755, 16842960, 16842961 };
    
    public static final int Fragment_id = 1;
    
    public static final int Fragment_name = 0;
    
    public static final int Fragment_tag = 2;
  }
  
  static interface OpGenerator {
    boolean generateOps(ArrayList<BackStackRecord> param1ArrayList, ArrayList<Boolean> param1ArrayList1);
  }
  
  class PopBackStackState implements OpGenerator {
    final String a;
    
    final int b;
    
    final int c;
    
    PopBackStackState(FragmentManagerImpl this$0, String param1String, int param1Int1, int param1Int2) {
      this.a = param1String;
      this.b = param1Int1;
      this.c = param1Int2;
    }
    
    public boolean generateOps(ArrayList<BackStackRecord> param1ArrayList, ArrayList<Boolean> param1ArrayList1) {
      return (this.d.q != null && this.b < 0 && this.a == null && this.d.q.getChildFragmentManager().popBackStackImmediate()) ? false : this.d.a(param1ArrayList, param1ArrayList1, this.a, this.b, this.c);
    }
  }
  
  static class StartEnterTransitionListener implements Fragment.OnStartEnterTransitionListener {
    final boolean a;
    
    final BackStackRecord b;
    
    private int c;
    
    StartEnterTransitionListener(BackStackRecord param1BackStackRecord, boolean param1Boolean) {
      this.a = param1Boolean;
      this.b = param1BackStackRecord;
    }
    
    public void cancelTransaction() {
      this.b.a.a(this.b, this.a, false, false);
    }
    
    public void completeTransaction() {
      int i = this.c;
      int j = 0;
      if (i > 0) {
        i = 1;
      } else {
        i = 0;
      } 
      FragmentManagerImpl fragmentManagerImpl = this.b.a;
      int k = fragmentManagerImpl.f.size();
      while (j < k) {
        Fragment fragment = fragmentManagerImpl.f.get(j);
        fragment.setOnStartEnterTransitionListener(null);
        if (i != 0 && fragment.isPostponed())
          fragment.startPostponedEnterTransition(); 
        j++;
      } 
      this.b.a.a(this.b, this.a, i ^ 0x1, true);
    }
    
    public boolean isReady() {
      return (this.c == 0);
    }
    
    public void onStartEnterTransition() {
      this.c--;
      if (this.c != 0)
        return; 
      this.b.a.e();
    }
    
    public void startListening() {
      this.c++;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\fragment\app\FragmentManagerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */