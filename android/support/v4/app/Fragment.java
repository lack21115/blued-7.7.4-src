package android.support.v4.app;

import android.animation.Animator;
import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.SimpleArrayMap;
import android.support.v4.view.LayoutInflaterCompat;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class Fragment implements LifecycleOwner, ComponentCallbacks, View.OnCreateContextMenuListener {
  static final Object USE_DEFAULT_TRANSITION;
  
  private static final SimpleArrayMap sClassMap = new SimpleArrayMap();
  
  boolean mAdded;
  
  Fragment$AnimationInfo mAnimationInfo;
  
  Bundle mArguments;
  
  int mBackStackNesting;
  
  boolean mCalled;
  
  boolean mCheckedForLoaderManager;
  
  FragmentManagerImpl mChildFragmentManager;
  
  FragmentManagerNonConfig mChildNonConfig;
  
  ViewGroup mContainer;
  
  int mContainerId;
  
  boolean mDeferStart;
  
  boolean mDetached;
  
  int mFragmentId;
  
  FragmentManagerImpl mFragmentManager;
  
  boolean mFromLayout;
  
  boolean mHasMenu;
  
  boolean mHidden;
  
  boolean mHiddenChanged;
  
  FragmentHostCallback mHost;
  
  boolean mInLayout;
  
  int mIndex = -1;
  
  View mInnerView;
  
  boolean mIsCreated;
  
  boolean mIsNewlyAdded;
  
  LayoutInflater mLayoutInflater;
  
  LifecycleRegistry mLifecycleRegistry = new LifecycleRegistry(this);
  
  LoaderManagerImpl mLoaderManager;
  
  boolean mLoadersStarted;
  
  boolean mMenuVisible = true;
  
  Fragment mParentFragment;
  
  boolean mPerformedCreateView;
  
  float mPostponedAlpha;
  
  public boolean mRemoving;
  
  boolean mRestored;
  
  boolean mRetainInstance;
  
  boolean mRetaining;
  
  Bundle mSavedFragmentState;
  
  SparseArray mSavedViewState;
  
  int mState = 0;
  
  String mTag;
  
  Fragment mTarget;
  
  int mTargetIndex = -1;
  
  int mTargetRequestCode;
  
  boolean mUserVisibleHint = true;
  
  View mView;
  
  String mWho;
  
  static {
    USE_DEFAULT_TRANSITION = new Object();
    throw new VerifyError("bad dex opcode");
  }
  
  public static Fragment instantiate(Context paramContext, String paramString, Bundle paramBundle) {
    // Byte code:
    //   0: getstatic android/support/v4/app/Fragment.sClassMap : Landroid/support/v4/util/SimpleArrayMap;
    //   3: aload_1
    //   4: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   7: checkcast java/lang/Class
    //   10: astore #5
    //   12: aload #5
    //   14: astore #4
    //   16: aload #5
    //   18: ifnonnull -> 41
    //   21: aload_0
    //   22: invokevirtual getClassLoader : ()Ljava/lang/ClassLoader;
    //   25: aload_1
    //   26: invokevirtual loadClass : (Ljava/lang/String;)Ljava/lang/Class;
    //   29: astore #4
    //   31: getstatic android/support/v4/app/Fragment.sClassMap : Landroid/support/v4/util/SimpleArrayMap;
    //   34: aload_1
    //   35: aload #4
    //   37: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   40: pop
    //   41: iconst_0
    //   42: istore_3
    //   43: aload #4
    //   45: iconst_0
    //   46: anewarray java/lang/Class
    //   49: invokevirtual getConstructor : ([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   52: iconst_0
    //   53: anewarray java/lang/Object
    //   56: invokevirtual newInstance : ([Ljava/lang/Object;)Ljava/lang/Object;
    //   59: checkcast android/support/v4/app/Fragment
    //   62: astore_0
    //   63: aload_2
    //   64: ifnull -> 121
    //   67: aload_2
    //   68: aload_0
    //   69: invokevirtual getClass : ()Ljava/lang/Class;
    //   72: invokevirtual getClassLoader : ()Ljava/lang/ClassLoader;
    //   75: invokevirtual setClassLoader : (Ljava/lang/ClassLoader;)V
    //   78: aload_0
    //   79: getfield mIndex : I
    //   82: iflt -> 116
    //   85: aload_0
    //   86: getfield mFragmentManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   89: ifnonnull -> 95
    //   92: goto -> 308
    //   95: aload_0
    //   96: getfield mFragmentManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   99: getfield mStateSaved : Z
    //   102: istore_3
    //   103: goto -> 308
    //   106: new java/lang/IllegalStateException
    //   109: dup
    //   110: ldc 'Fragment already active and state has been saved'
    //   112: invokespecial <init> : (Ljava/lang/String;)V
    //   115: athrow
    //   116: aload_0
    //   117: aload_2
    //   118: putfield mArguments : Landroid/os/Bundle;
    //   121: aload_0
    //   122: areturn
    //   123: astore_0
    //   124: new java/lang/StringBuilder
    //   127: dup
    //   128: ldc 'Unable to instantiate fragment '
    //   130: invokespecial <init> : (Ljava/lang/String;)V
    //   133: astore_2
    //   134: aload_2
    //   135: aload_1
    //   136: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload_2
    //   141: ldc ': calling Fragment constructor caused an exception'
    //   143: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: new android/support/v4/app/Fragment$InstantiationException
    //   150: dup
    //   151: aload_2
    //   152: invokevirtual toString : ()Ljava/lang/String;
    //   155: aload_0
    //   156: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Exception;)V
    //   159: athrow
    //   160: astore_0
    //   161: new java/lang/StringBuilder
    //   164: dup
    //   165: ldc 'Unable to instantiate fragment '
    //   167: invokespecial <init> : (Ljava/lang/String;)V
    //   170: astore_2
    //   171: aload_2
    //   172: aload_1
    //   173: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload_2
    //   178: ldc ': could not find Fragment constructor'
    //   180: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: new android/support/v4/app/Fragment$InstantiationException
    //   187: dup
    //   188: aload_2
    //   189: invokevirtual toString : ()Ljava/lang/String;
    //   192: aload_0
    //   193: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Exception;)V
    //   196: athrow
    //   197: astore_0
    //   198: new java/lang/StringBuilder
    //   201: dup
    //   202: ldc 'Unable to instantiate fragment '
    //   204: invokespecial <init> : (Ljava/lang/String;)V
    //   207: astore_2
    //   208: aload_2
    //   209: aload_1
    //   210: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload_2
    //   215: ldc ': make sure class name exists, is public, and has an empty constructor that is public'
    //   217: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: new android/support/v4/app/Fragment$InstantiationException
    //   224: dup
    //   225: aload_2
    //   226: invokevirtual toString : ()Ljava/lang/String;
    //   229: aload_0
    //   230: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Exception;)V
    //   233: athrow
    //   234: astore_0
    //   235: new java/lang/StringBuilder
    //   238: dup
    //   239: ldc 'Unable to instantiate fragment '
    //   241: invokespecial <init> : (Ljava/lang/String;)V
    //   244: astore_2
    //   245: aload_2
    //   246: aload_1
    //   247: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: aload_2
    //   252: ldc ': make sure class name exists, is public, and has an empty constructor that is public'
    //   254: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: new android/support/v4/app/Fragment$InstantiationException
    //   261: dup
    //   262: aload_2
    //   263: invokevirtual toString : ()Ljava/lang/String;
    //   266: aload_0
    //   267: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Exception;)V
    //   270: athrow
    //   271: astore_0
    //   272: new java/lang/StringBuilder
    //   275: dup
    //   276: ldc 'Unable to instantiate fragment '
    //   278: invokespecial <init> : (Ljava/lang/String;)V
    //   281: astore_2
    //   282: aload_2
    //   283: aload_1
    //   284: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload_2
    //   289: ldc ': make sure class name exists, is public, and has an empty constructor that is public'
    //   291: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: new android/support/v4/app/Fragment$InstantiationException
    //   298: dup
    //   299: aload_2
    //   300: invokevirtual toString : ()Ljava/lang/String;
    //   303: aload_0
    //   304: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Exception;)V
    //   307: athrow
    //   308: iload_3
    //   309: ifne -> 106
    //   312: goto -> 116
    // Exception table:
    //   from	to	target	type
    //   0	12	271	java/lang/ClassNotFoundException
    //   0	12	234	java/lang/InstantiationException
    //   0	12	197	java/lang/IllegalAccessException
    //   0	12	160	java/lang/NoSuchMethodException
    //   0	12	123	java/lang/reflect/InvocationTargetException
    //   21	41	271	java/lang/ClassNotFoundException
    //   21	41	234	java/lang/InstantiationException
    //   21	41	197	java/lang/IllegalAccessException
    //   21	41	160	java/lang/NoSuchMethodException
    //   21	41	123	java/lang/reflect/InvocationTargetException
    //   43	63	271	java/lang/ClassNotFoundException
    //   43	63	234	java/lang/InstantiationException
    //   43	63	197	java/lang/IllegalAccessException
    //   43	63	160	java/lang/NoSuchMethodException
    //   43	63	123	java/lang/reflect/InvocationTargetException
    //   67	92	271	java/lang/ClassNotFoundException
    //   67	92	234	java/lang/InstantiationException
    //   67	92	197	java/lang/IllegalAccessException
    //   67	92	160	java/lang/NoSuchMethodException
    //   67	92	123	java/lang/reflect/InvocationTargetException
    //   95	103	271	java/lang/ClassNotFoundException
    //   95	103	234	java/lang/InstantiationException
    //   95	103	197	java/lang/IllegalAccessException
    //   95	103	160	java/lang/NoSuchMethodException
    //   95	103	123	java/lang/reflect/InvocationTargetException
    //   106	116	271	java/lang/ClassNotFoundException
    //   106	116	234	java/lang/InstantiationException
    //   106	116	197	java/lang/IllegalAccessException
    //   106	116	160	java/lang/NoSuchMethodException
    //   106	116	123	java/lang/reflect/InvocationTargetException
    //   116	121	271	java/lang/ClassNotFoundException
    //   116	121	234	java/lang/InstantiationException
    //   116	121	197	java/lang/IllegalAccessException
    //   116	121	160	java/lang/NoSuchMethodException
    //   116	121	123	java/lang/reflect/InvocationTargetException
  }
  
  private void instantiateChildFragmentManager() {
    if (this.mHost != null) {
      this.mChildFragmentManager = new FragmentManagerImpl();
      this.mChildFragmentManager.attachController(this.mHost, new Fragment$2(this), this);
      return;
    } 
    throw new IllegalStateException("Fragment has not been attached yet.");
  }
  
  static boolean isSupportFragmentClass(Context paramContext, String paramString) {
    try {
      Class<?> clazz2 = (Class)sClassMap.get(paramString);
      Class<?> clazz1 = clazz2;
      if (clazz2 == null) {
        clazz1 = paramContext.getClassLoader().loadClass(paramString);
        sClassMap.put(paramString, clazz1);
      } 
      return Fragment.class.isAssignableFrom(clazz1);
    } catch (ClassNotFoundException classNotFoundException) {
      return false;
    } 
  }
  
  public static void onAttachFragment$65850823() {}
  
  public static Animation onCreateAnimation$24236ca7() {
    return null;
  }
  
  public static Animator onCreateAnimator$ed6a78a() {
    return null;
  }
  
  public static void onDestroyOptionsMenu() {}
  
  public static void onHiddenChanged$1385ff() {}
  
  public static void onRequestPermissionsResult$6f5af501() {}
  
  public static void onViewCreated$65f1d89() {}
  
  final void callStartTransitionListener() {
    Fragment$OnStartEnterTransitionListener fragment$OnStartEnterTransitionListener;
    if (this.mAnimationInfo == null) {
      fragment$OnStartEnterTransitionListener = null;
    } else {
      this.mAnimationInfo.mEnterTransitionPostponed = false;
      fragment$OnStartEnterTransitionListener = this.mAnimationInfo.mStartEnterTransitionListener;
      this.mAnimationInfo.mStartEnterTransitionListener = null;
    } 
    if (fragment$OnStartEnterTransitionListener != null)
      fragment$OnStartEnterTransitionListener.onStartEnterTransition(); 
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mFragmentId=#");
    paramPrintWriter.print(Integer.toHexString(this.mFragmentId));
    paramPrintWriter.print(" mContainerId=#");
    paramPrintWriter.print(Integer.toHexString(this.mContainerId));
    paramPrintWriter.print(" mTag=");
    paramPrintWriter.println(this.mTag);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mState=");
    paramPrintWriter.print(this.mState);
    paramPrintWriter.print(" mIndex=");
    paramPrintWriter.print(this.mIndex);
    paramPrintWriter.print(" mWho=");
    paramPrintWriter.print(this.mWho);
    paramPrintWriter.print(" mBackStackNesting=");
    paramPrintWriter.println(this.mBackStackNesting);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mAdded=");
    paramPrintWriter.print(this.mAdded);
    paramPrintWriter.print(" mRemoving=");
    paramPrintWriter.print(this.mRemoving);
    paramPrintWriter.print(" mFromLayout=");
    paramPrintWriter.print(this.mFromLayout);
    paramPrintWriter.print(" mInLayout=");
    paramPrintWriter.println(this.mInLayout);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mHidden=");
    paramPrintWriter.print(this.mHidden);
    paramPrintWriter.print(" mDetached=");
    paramPrintWriter.print(this.mDetached);
    paramPrintWriter.print(" mMenuVisible=");
    paramPrintWriter.print(this.mMenuVisible);
    paramPrintWriter.print(" mHasMenu=");
    paramPrintWriter.println(this.mHasMenu);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mRetainInstance=");
    paramPrintWriter.print(this.mRetainInstance);
    paramPrintWriter.print(" mRetaining=");
    paramPrintWriter.print(this.mRetaining);
    paramPrintWriter.print(" mUserVisibleHint=");
    paramPrintWriter.println(this.mUserVisibleHint);
    if (this.mFragmentManager != null) {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mFragmentManager=");
      paramPrintWriter.println(this.mFragmentManager);
    } 
    if (this.mHost != null) {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mHost=");
      paramPrintWriter.println(this.mHost);
    } 
    if (this.mParentFragment != null) {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mParentFragment=");
      paramPrintWriter.println(this.mParentFragment);
    } 
    if (this.mArguments != null) {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mArguments=");
      paramPrintWriter.println(this.mArguments);
    } 
    if (this.mSavedFragmentState != null) {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mSavedFragmentState=");
      paramPrintWriter.println(this.mSavedFragmentState);
    } 
    if (this.mSavedViewState != null) {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mSavedViewState=");
      paramPrintWriter.println(this.mSavedViewState);
    } 
    if (this.mTarget != null) {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mTarget=");
      paramPrintWriter.print(this.mTarget);
      paramPrintWriter.print(" mTargetRequestCode=");
      paramPrintWriter.println(this.mTargetRequestCode);
    } 
    if (getNextAnim() != 0) {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mNextAnim=");
      paramPrintWriter.println(getNextAnim());
    } 
    if (this.mContainer != null) {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mContainer=");
      paramPrintWriter.println(this.mContainer);
    } 
    if (this.mView != null) {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mView=");
      paramPrintWriter.println(this.mView);
    } 
    if (this.mInnerView != null) {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mInnerView=");
      paramPrintWriter.println(this.mView);
    } 
    if (getAnimatingAway() != null) {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mAnimatingAway=");
      paramPrintWriter.println(getAnimatingAway());
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mStateAfterAnimating=");
      paramPrintWriter.println(getStateAfterAnimating());
    } 
    if (this.mLoaderManager != null) {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Loader Manager:");
      LoaderManagerImpl loaderManagerImpl = this.mLoaderManager;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append("  ");
      loaderManagerImpl.dump$ec96877(stringBuilder.toString(), paramFileDescriptor, paramPrintWriter);
    } 
    if (this.mChildFragmentManager != null) {
      paramPrintWriter.print(paramString);
      StringBuilder stringBuilder1 = new StringBuilder("Child ");
      stringBuilder1.append(this.mChildFragmentManager);
      stringBuilder1.append(":");
      paramPrintWriter.println(stringBuilder1.toString());
      FragmentManagerImpl fragmentManagerImpl = this.mChildFragmentManager;
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(paramString);
      stringBuilder2.append("  ");
      fragmentManagerImpl.dump(stringBuilder2.toString(), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    } 
  }
  
  final Fragment$AnimationInfo ensureAnimationInfo() {
    if (this.mAnimationInfo == null)
      this.mAnimationInfo = new Fragment$AnimationInfo(); 
    return this.mAnimationInfo;
  }
  
  public final boolean equals(Object paramObject) {
    return super.equals(paramObject);
  }
  
  public final FragmentActivity getActivity() {
    return (this.mHost == null) ? null : (FragmentActivity)this.mHost.mActivity;
  }
  
  final View getAnimatingAway() {
    return (this.mAnimationInfo == null) ? null : this.mAnimationInfo.mAnimatingAway;
  }
  
  final Animator getAnimator() {
    return (this.mAnimationInfo == null) ? null : this.mAnimationInfo.mAnimator;
  }
  
  public final FragmentManager getChildFragmentManager() {
    if (this.mChildFragmentManager == null) {
      instantiateChildFragmentManager();
      if (this.mState >= 5) {
        this.mChildFragmentManager.dispatchResume();
      } else if (this.mState >= 4) {
        this.mChildFragmentManager.dispatchStart();
      } else if (this.mState >= 2) {
        this.mChildFragmentManager.dispatchActivityCreated();
      } else if (this.mState > 0) {
        this.mChildFragmentManager.dispatchCreate();
      } 
    } 
    return this.mChildFragmentManager;
  }
  
  public final Object getEnterTransition() {
    return (this.mAnimationInfo == null) ? null : this.mAnimationInfo.mEnterTransition;
  }
  
  final SharedElementCallback getEnterTransitionCallback() {
    return (this.mAnimationInfo == null) ? null : this.mAnimationInfo.mEnterTransitionCallback;
  }
  
  public final Object getExitTransition() {
    return (this.mAnimationInfo == null) ? null : this.mAnimationInfo.mExitTransition;
  }
  
  final SharedElementCallback getExitTransitionCallback() {
    return (this.mAnimationInfo == null) ? null : this.mAnimationInfo.mExitTransitionCallback;
  }
  
  public final Lifecycle getLifecycle() {
    return (Lifecycle)this.mLifecycleRegistry;
  }
  
  final int getNextAnim() {
    return (this.mAnimationInfo == null) ? 0 : this.mAnimationInfo.mNextAnim;
  }
  
  final int getNextTransition() {
    return (this.mAnimationInfo == null) ? 0 : this.mAnimationInfo.mNextTransition;
  }
  
  final int getNextTransitionStyle() {
    return (this.mAnimationInfo == null) ? 0 : this.mAnimationInfo.mNextTransitionStyle;
  }
  
  public final Object getReenterTransition() {
    return (this.mAnimationInfo == null) ? null : ((this.mAnimationInfo.mReenterTransition == USE_DEFAULT_TRANSITION) ? getExitTransition() : this.mAnimationInfo.mReenterTransition);
  }
  
  public final Object getReturnTransition() {
    return (this.mAnimationInfo == null) ? null : ((this.mAnimationInfo.mReturnTransition == USE_DEFAULT_TRANSITION) ? getEnterTransition() : this.mAnimationInfo.mReturnTransition);
  }
  
  public final Object getSharedElementEnterTransition() {
    return (this.mAnimationInfo == null) ? null : this.mAnimationInfo.mSharedElementEnterTransition;
  }
  
  public final Object getSharedElementReturnTransition() {
    return (this.mAnimationInfo == null) ? null : ((this.mAnimationInfo.mSharedElementReturnTransition == USE_DEFAULT_TRANSITION) ? getSharedElementEnterTransition() : this.mAnimationInfo.mSharedElementReturnTransition);
  }
  
  final int getStateAfterAnimating() {
    return (this.mAnimationInfo == null) ? 0 : this.mAnimationInfo.mStateAfterAnimating;
  }
  
  public final int hashCode() {
    return super.hashCode();
  }
  
  final boolean isHideReplaced() {
    return (this.mAnimationInfo == null) ? false : this.mAnimationInfo.mIsHideReplaced;
  }
  
  final boolean isInBackStack() {
    return (this.mBackStackNesting > 0);
  }
  
  final boolean isPostponed() {
    return (this.mAnimationInfo == null) ? false : this.mAnimationInfo.mEnterTransitionPostponed;
  }
  
  public void onActivityCreated(Bundle paramBundle) {
    this.mCalled = true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onAttach(Context paramContext) {
    Activity activity;
    this.mCalled = true;
    if (this.mHost == null) {
      paramContext = null;
    } else {
      activity = this.mHost.mActivity;
    } 
    if (activity != null) {
      this.mCalled = false;
      this.mCalled = true;
    } 
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    this.mCalled = true;
  }
  
  public void onCreate(Bundle paramBundle) {
    boolean bool = true;
    this.mCalled = true;
    restoreChildFragmentState(paramBundle);
    if (this.mChildFragmentManager != null) {
      if (this.mChildFragmentManager.mCurState <= 0)
        bool = false; 
      if (!bool)
        this.mChildFragmentManager.dispatchCreate(); 
    } 
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo) {
    getActivity().onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
  }
  
  public void onDestroy() {
    this.mCalled = true;
    if (!this.mCheckedForLoaderManager) {
      this.mCheckedForLoaderManager = true;
      this.mLoaderManager = this.mHost.getLoaderManager(this.mWho, this.mLoadersStarted, false);
    } 
    if (this.mLoaderManager != null)
      this.mLoaderManager.doDestroy(); 
  }
  
  public void onDestroyView() {
    this.mCalled = true;
  }
  
  public void onDetach() {
    this.mCalled = true;
  }
  
  public LayoutInflater onGetLayoutInflater(Bundle paramBundle) {
    if (this.mHost != null) {
      LayoutInflater layoutInflater = this.mHost.onGetLayoutInflater();
      getChildFragmentManager();
      LayoutInflaterCompat.setFactory2(layoutInflater, this.mChildFragmentManager);
      return layoutInflater;
    } 
    throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
  }
  
  public final void onInflate$2c1ed547$6a2adb45() {
    Activity activity;
    this.mCalled = true;
    if (this.mHost == null) {
      activity = null;
    } else {
      activity = this.mHost.mActivity;
    } 
    if (activity != null) {
      this.mCalled = false;
      this.mCalled = true;
    } 
  }
  
  public void onLowMemory() {
    this.mCalled = true;
  }
  
  public void onResume() {
    this.mCalled = true;
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public void onStart() {
    this.mCalled = true;
    if (!this.mLoadersStarted) {
      this.mLoadersStarted = true;
      if (!this.mCheckedForLoaderManager) {
        this.mCheckedForLoaderManager = true;
        this.mLoaderManager = this.mHost.getLoaderManager(this.mWho, this.mLoadersStarted, false);
        return;
      } 
      if (this.mLoaderManager != null)
        this.mLoaderManager.doStart(); 
    } 
  }
  
  public void onStop() {
    this.mCalled = true;
  }
  
  final void performActivityCreated(Bundle paramBundle) {
    if (this.mChildFragmentManager != null)
      this.mChildFragmentManager.noteStateNotSaved(); 
    this.mState = 2;
    this.mCalled = false;
    onActivityCreated(paramBundle);
    if (this.mCalled) {
      if (this.mChildFragmentManager != null)
        this.mChildFragmentManager.dispatchActivityCreated(); 
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder("Fragment ");
    stringBuilder.append(this);
    stringBuilder.append(" did not call through to super.onActivityCreated()");
    throw new SuperNotCalledException(stringBuilder.toString());
  }
  
  final void performCreate(Bundle paramBundle) {
    if (this.mChildFragmentManager != null)
      this.mChildFragmentManager.noteStateNotSaved(); 
    this.mState = 1;
    this.mCalled = false;
    onCreate(paramBundle);
    this.mIsCreated = true;
    if (this.mCalled) {
      this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder("Fragment ");
    stringBuilder.append(this);
    stringBuilder.append(" did not call through to super.onCreate()");
    throw new SuperNotCalledException(stringBuilder.toString());
  }
  
  final View performCreateView$469ccb8a() {
    if (this.mChildFragmentManager != null)
      this.mChildFragmentManager.noteStateNotSaved(); 
    this.mPerformedCreateView = true;
    return null;
  }
  
  final void performDestroy() {
    this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    if (this.mChildFragmentManager != null)
      this.mChildFragmentManager.dispatchDestroy(); 
    this.mState = 0;
    this.mCalled = false;
    this.mIsCreated = false;
    onDestroy();
    if (this.mCalled) {
      this.mChildFragmentManager = null;
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder("Fragment ");
    stringBuilder.append(this);
    stringBuilder.append(" did not call through to super.onDestroy()");
    throw new SuperNotCalledException(stringBuilder.toString());
  }
  
  final LayoutInflater performGetLayoutInflater(Bundle paramBundle) {
    this.mLayoutInflater = onGetLayoutInflater(paramBundle);
    return this.mLayoutInflater;
  }
  
  final void performPause() {
    this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    if (this.mChildFragmentManager != null)
      this.mChildFragmentManager.dispatchStateChange(4); 
    this.mState = 4;
    this.mCalled = false;
    this.mCalled = true;
    if (this.mCalled)
      return; 
    StringBuilder stringBuilder = new StringBuilder("Fragment ");
    stringBuilder.append(this);
    stringBuilder.append(" did not call through to super.onPause()");
    throw new SuperNotCalledException(stringBuilder.toString());
  }
  
  final void performReallyStop() {
    if (this.mChildFragmentManager != null)
      this.mChildFragmentManager.dispatchStateChange(2); 
    this.mState = 2;
    if (this.mLoadersStarted) {
      this.mLoadersStarted = false;
      if (!this.mCheckedForLoaderManager) {
        this.mCheckedForLoaderManager = true;
        this.mLoaderManager = this.mHost.getLoaderManager(this.mWho, this.mLoadersStarted, false);
      } 
      if (this.mLoaderManager != null) {
        if (this.mHost.mRetainLoaders) {
          this.mLoaderManager.doRetain();
          return;
        } 
        this.mLoaderManager.doStop();
      } 
    } 
  }
  
  final void performResume() {
    if (this.mChildFragmentManager != null) {
      this.mChildFragmentManager.noteStateNotSaved();
      this.mChildFragmentManager.execPendingActions();
    } 
    this.mState = 5;
    this.mCalled = false;
    onResume();
    if (this.mCalled) {
      if (this.mChildFragmentManager != null) {
        this.mChildFragmentManager.dispatchResume();
        this.mChildFragmentManager.execPendingActions();
      } 
      this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder("Fragment ");
    stringBuilder.append(this);
    stringBuilder.append(" did not call through to super.onResume()");
    throw new SuperNotCalledException(stringBuilder.toString());
  }
  
  final void performSaveInstanceState(Bundle paramBundle) {
    onSaveInstanceState(paramBundle);
    if (this.mChildFragmentManager != null) {
      Parcelable parcelable = this.mChildFragmentManager.saveAllState();
      if (parcelable != null)
        paramBundle.putParcelable("android:support:fragments", parcelable); 
    } 
  }
  
  final void performStart() {
    if (this.mChildFragmentManager != null) {
      this.mChildFragmentManager.noteStateNotSaved();
      this.mChildFragmentManager.execPendingActions();
    } 
    this.mState = 4;
    this.mCalled = false;
    onStart();
    if (this.mCalled) {
      if (this.mChildFragmentManager != null)
        this.mChildFragmentManager.dispatchStart(); 
      if (this.mLoaderManager != null)
        this.mLoaderManager.doReportStart(); 
      this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder("Fragment ");
    stringBuilder.append(this);
    stringBuilder.append(" did not call through to super.onStart()");
    throw new SuperNotCalledException(stringBuilder.toString());
  }
  
  final void performStop() {
    this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    if (this.mChildFragmentManager != null)
      this.mChildFragmentManager.dispatchStop(); 
    this.mState = 3;
    this.mCalled = false;
    onStop();
    if (this.mCalled)
      return; 
    StringBuilder stringBuilder = new StringBuilder("Fragment ");
    stringBuilder.append(this);
    stringBuilder.append(" did not call through to super.onStop()");
    throw new SuperNotCalledException(stringBuilder.toString());
  }
  
  final void restoreChildFragmentState(Bundle paramBundle) {
    if (paramBundle != null) {
      Parcelable parcelable = paramBundle.getParcelable("android:support:fragments");
      if (parcelable != null) {
        if (this.mChildFragmentManager == null)
          instantiateChildFragmentManager(); 
        this.mChildFragmentManager.restoreAllState(parcelable, this.mChildNonConfig);
        this.mChildNonConfig = null;
        this.mChildFragmentManager.dispatchCreate();
      } 
    } 
  }
  
  final void setAnimatingAway(View paramView) {
    (ensureAnimationInfo()).mAnimatingAway = paramView;
  }
  
  final void setAnimator(Animator paramAnimator) {
    (ensureAnimationInfo()).mAnimator = paramAnimator;
  }
  
  final void setHideReplaced(boolean paramBoolean) {
    (ensureAnimationInfo()).mIsHideReplaced = paramBoolean;
  }
  
  final void setIndex(int paramInt, Fragment paramFragment) {
    this.mIndex = paramInt;
    if (paramFragment != null) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramFragment.mWho);
      stringBuilder1.append(":");
      stringBuilder1.append(this.mIndex);
      this.mWho = stringBuilder1.toString();
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder("android:fragment:");
    stringBuilder.append(this.mIndex);
    this.mWho = stringBuilder.toString();
  }
  
  final void setNextAnim(int paramInt) {
    if (this.mAnimationInfo == null && paramInt == 0)
      return; 
    (ensureAnimationInfo()).mNextAnim = paramInt;
  }
  
  final void setNextTransition(int paramInt1, int paramInt2) {
    if (this.mAnimationInfo == null && paramInt1 == 0 && paramInt2 == 0)
      return; 
    ensureAnimationInfo();
    this.mAnimationInfo.mNextTransition = paramInt1;
    this.mAnimationInfo.mNextTransitionStyle = paramInt2;
  }
  
  final void setOnStartEnterTransitionListener(Fragment$OnStartEnterTransitionListener paramFragment$OnStartEnterTransitionListener) {
    ensureAnimationInfo();
    if (paramFragment$OnStartEnterTransitionListener == this.mAnimationInfo.mStartEnterTransitionListener)
      return; 
    if (paramFragment$OnStartEnterTransitionListener == null || this.mAnimationInfo.mStartEnterTransitionListener == null) {
      if (this.mAnimationInfo.mEnterTransitionPostponed)
        this.mAnimationInfo.mStartEnterTransitionListener = paramFragment$OnStartEnterTransitionListener; 
      if (paramFragment$OnStartEnterTransitionListener != null)
        paramFragment$OnStartEnterTransitionListener.startListening(); 
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder("Trying to set a replacement startPostponedEnterTransition on ");
    stringBuilder.append(this);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  final void setStateAfterAnimating(int paramInt) {
    (ensureAnimationInfo()).mStateAfterAnimating = paramInt;
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt) {
    if (this.mHost != null) {
      this.mHost.onStartActivityFromFragment(this, paramIntent, paramInt, null);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder("Fragment ");
    stringBuilder.append(this);
    stringBuilder.append(" not attached to Activity");
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);
    DebugUtils.buildShortClassTag(this, stringBuilder);
    if (this.mIndex >= 0) {
      stringBuilder.append(" #");
      stringBuilder.append(this.mIndex);
    } 
    if (this.mFragmentId != 0) {
      stringBuilder.append(" id=0x");
      stringBuilder.append(Integer.toHexString(this.mFragmentId));
    } 
    if (this.mTag != null) {
      stringBuilder.append(" ");
      stringBuilder.append(this.mTag);
    } 
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\app\Fragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */