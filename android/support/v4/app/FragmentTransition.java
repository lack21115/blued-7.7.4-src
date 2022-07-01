package android.support.v4.app;

import android.os.Build;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.MapCollections;
import android.support.v4.view.ViewCompat;
import android.util.SparseArray;
import android.view.View;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

final class FragmentTransition {
  private static final int[] INVERSE_OPS = new int[] { 0, 3, 0, 1, 5, 4, 7, 6, 9, 8 };
  
  private static final FragmentTransitionImpl PLATFORM_IMPL;
  
  private static final FragmentTransitionImpl SUPPORT_IMPL = resolveSupportImpl();
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private static void addSharedElementsWithMatchingNames(ArrayList<View> paramArrayList, ArrayMap paramArrayMap, Collection paramCollection) {
    for (int i = paramArrayMap.size() - 1; i >= 0; i--) {
      View view = (View)paramArrayMap.valueAt(i);
      if (paramCollection.contains(ViewCompat.getTransitionName(view)))
        paramArrayList.add(view); 
    } 
  }
  
  private static void addToFirstInLastOut(BackStackRecord paramBackStackRecord, BackStackRecord$Op paramBackStackRecord$Op, SparseArray paramSparseArray, boolean paramBoolean1, boolean paramBoolean2) {
    // Byte code:
    //   0: aload_1
    //   1: getfield fragment : Landroid/support/v4/app/Fragment;
    //   4: astore #12
    //   6: aload #12
    //   8: ifnonnull -> 12
    //   11: return
    //   12: aload #12
    //   14: getfield mContainerId : I
    //   17: istore #8
    //   19: iload #8
    //   21: ifne -> 25
    //   24: return
    //   25: iload_3
    //   26: ifeq -> 42
    //   29: getstatic android/support/v4/app/FragmentTransition.INVERSE_OPS : [I
    //   32: aload_1
    //   33: getfield cmd : I
    //   36: iaload
    //   37: istore #5
    //   39: goto -> 48
    //   42: aload_1
    //   43: getfield cmd : I
    //   46: istore #5
    //   48: iconst_0
    //   49: istore #10
    //   51: iconst_0
    //   52: istore #9
    //   54: iconst_1
    //   55: istore #6
    //   57: iload #5
    //   59: iconst_1
    //   60: if_icmpeq -> 322
    //   63: iload #5
    //   65: tableswitch default -> 100, 3 -> 229, 4 -> 163, 5 -> 112, 6 -> 229, 7 -> 322
    //   100: iconst_0
    //   101: istore #5
    //   103: iconst_0
    //   104: istore #7
    //   106: iconst_0
    //   107: istore #6
    //   109: goto -> 369
    //   112: iload #4
    //   114: ifeq -> 153
    //   117: aload #12
    //   119: getfield mHiddenChanged : Z
    //   122: ifeq -> 147
    //   125: aload #12
    //   127: getfield mHidden : Z
    //   130: ifne -> 147
    //   133: aload #12
    //   135: getfield mAdded : Z
    //   138: ifeq -> 147
    //   141: iconst_1
    //   142: istore #9
    //   144: goto -> 160
    //   147: iconst_0
    //   148: istore #9
    //   150: goto -> 160
    //   153: aload #12
    //   155: getfield mHidden : Z
    //   158: istore #9
    //   160: goto -> 362
    //   163: iload #4
    //   165: ifeq -> 204
    //   168: aload #12
    //   170: getfield mHiddenChanged : Z
    //   173: ifeq -> 198
    //   176: aload #12
    //   178: getfield mAdded : Z
    //   181: ifeq -> 198
    //   184: aload #12
    //   186: getfield mHidden : Z
    //   189: ifeq -> 198
    //   192: iconst_1
    //   193: istore #5
    //   195: goto -> 226
    //   198: iconst_0
    //   199: istore #5
    //   201: goto -> 226
    //   204: aload #12
    //   206: getfield mAdded : Z
    //   209: ifeq -> 223
    //   212: aload #12
    //   214: getfield mHidden : Z
    //   217: ifne -> 223
    //   220: goto -> 192
    //   223: goto -> 198
    //   226: goto -> 305
    //   229: iload #4
    //   231: ifeq -> 283
    //   234: aload #12
    //   236: getfield mAdded : Z
    //   239: ifne -> 277
    //   242: aload #12
    //   244: getfield mView : Landroid/view/View;
    //   247: ifnull -> 277
    //   250: aload #12
    //   252: getfield mView : Landroid/view/View;
    //   255: invokevirtual getVisibility : ()I
    //   258: ifne -> 277
    //   261: aload #12
    //   263: getfield mPostponedAlpha : F
    //   266: fconst_0
    //   267: fcmpl
    //   268: iflt -> 277
    //   271: iconst_1
    //   272: istore #5
    //   274: goto -> 305
    //   277: iconst_0
    //   278: istore #5
    //   280: goto -> 305
    //   283: aload #12
    //   285: getfield mAdded : Z
    //   288: ifeq -> 302
    //   291: aload #12
    //   293: getfield mHidden : Z
    //   296: ifne -> 302
    //   299: goto -> 271
    //   302: goto -> 277
    //   305: iload #5
    //   307: istore #6
    //   309: iconst_1
    //   310: istore #7
    //   312: iconst_0
    //   313: istore #5
    //   315: iload #10
    //   317: istore #9
    //   319: goto -> 369
    //   322: iload #4
    //   324: ifeq -> 337
    //   327: aload #12
    //   329: getfield mIsNewlyAdded : Z
    //   332: istore #9
    //   334: goto -> 362
    //   337: aload #12
    //   339: getfield mAdded : Z
    //   342: ifne -> 359
    //   345: aload #12
    //   347: getfield mHidden : Z
    //   350: ifne -> 359
    //   353: iconst_1
    //   354: istore #9
    //   356: goto -> 362
    //   359: iconst_0
    //   360: istore #9
    //   362: iload #6
    //   364: istore #5
    //   366: goto -> 103
    //   369: aload_2
    //   370: iload #8
    //   372: invokevirtual get : (I)Ljava/lang/Object;
    //   375: checkcast android/support/v4/app/FragmentTransition$FragmentContainerTransition
    //   378: astore #11
    //   380: aload #11
    //   382: astore_1
    //   383: iload #9
    //   385: ifeq -> 413
    //   388: aload #11
    //   390: aload_2
    //   391: iload #8
    //   393: invokestatic ensureContainer : (Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;Landroid/util/SparseArray;I)Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;
    //   396: astore_1
    //   397: aload_1
    //   398: aload #12
    //   400: putfield lastIn : Landroid/support/v4/app/Fragment;
    //   403: aload_1
    //   404: iload_3
    //   405: putfield lastInIsPop : Z
    //   408: aload_1
    //   409: aload_0
    //   410: putfield lastInTransaction : Landroid/support/v4/app/BackStackRecord;
    //   413: iload #4
    //   415: ifne -> 488
    //   418: iload #5
    //   420: ifeq -> 488
    //   423: aload_1
    //   424: ifnull -> 441
    //   427: aload_1
    //   428: getfield firstOut : Landroid/support/v4/app/Fragment;
    //   431: aload #12
    //   433: if_acmpne -> 441
    //   436: aload_1
    //   437: aconst_null
    //   438: putfield firstOut : Landroid/support/v4/app/Fragment;
    //   441: aload_0
    //   442: getfield mManager : Landroid/support/v4/app/FragmentManagerImpl;
    //   445: astore #11
    //   447: aload #12
    //   449: getfield mState : I
    //   452: ifgt -> 488
    //   455: aload #11
    //   457: getfield mCurState : I
    //   460: ifle -> 488
    //   463: aload_0
    //   464: getfield mReorderingAllowed : Z
    //   467: ifne -> 488
    //   470: aload #11
    //   472: aload #12
    //   474: invokevirtual makeActive : (Landroid/support/v4/app/Fragment;)V
    //   477: aload #11
    //   479: aload #12
    //   481: iconst_1
    //   482: iconst_0
    //   483: iconst_0
    //   484: iconst_0
    //   485: invokevirtual moveToState : (Landroid/support/v4/app/Fragment;IIIZ)V
    //   488: aload_1
    //   489: astore #11
    //   491: iload #6
    //   493: ifeq -> 538
    //   496: aload_1
    //   497: ifnull -> 510
    //   500: aload_1
    //   501: astore #11
    //   503: aload_1
    //   504: getfield firstOut : Landroid/support/v4/app/Fragment;
    //   507: ifnonnull -> 538
    //   510: aload_1
    //   511: aload_2
    //   512: iload #8
    //   514: invokestatic ensureContainer : (Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;Landroid/util/SparseArray;I)Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;
    //   517: astore #11
    //   519: aload #11
    //   521: aload #12
    //   523: putfield firstOut : Landroid/support/v4/app/Fragment;
    //   526: aload #11
    //   528: iload_3
    //   529: putfield firstOutIsPop : Z
    //   532: aload #11
    //   534: aload_0
    //   535: putfield firstOutTransaction : Landroid/support/v4/app/BackStackRecord;
    //   538: iload #4
    //   540: ifne -> 569
    //   543: iload #7
    //   545: ifeq -> 569
    //   548: aload #11
    //   550: ifnull -> 569
    //   553: aload #11
    //   555: getfield lastIn : Landroid/support/v4/app/Fragment;
    //   558: aload #12
    //   560: if_acmpne -> 569
    //   563: aload #11
    //   565: aconst_null
    //   566: putfield lastIn : Landroid/support/v4/app/Fragment;
    //   569: return
  }
  
  private static void calculateFragments(BackStackRecord paramBackStackRecord, SparseArray paramSparseArray, boolean paramBoolean) {
    int j = paramBackStackRecord.mOps.size();
    for (int i = 0; i < j; i++)
      addToFirstInLastOut(paramBackStackRecord, paramBackStackRecord.mOps.get(i), paramSparseArray, false, paramBoolean); 
  }
  
  private static ArrayMap calculateNameOverrides(int paramInt1, ArrayList<BackStackRecord> paramArrayList1, ArrayList<Boolean> paramArrayList2, int paramInt2, int paramInt3) {
    ArrayMap arrayMap = new ArrayMap();
    while (--paramInt3 >= paramInt2) {
      BackStackRecord backStackRecord = paramArrayList1.get(paramInt3);
      if (backStackRecord.interactsWith(paramInt1)) {
        boolean bool = ((Boolean)paramArrayList2.get(paramInt3)).booleanValue();
        if (backStackRecord.mSharedElementSourceNames != null) {
          ArrayList<String> arrayList1;
          ArrayList<String> arrayList2;
          int j = backStackRecord.mSharedElementSourceNames.size();
          if (bool) {
            arrayList2 = backStackRecord.mSharedElementSourceNames;
            arrayList1 = backStackRecord.mSharedElementTargetNames;
          } else {
            arrayList1 = backStackRecord.mSharedElementSourceNames;
            arrayList2 = backStackRecord.mSharedElementTargetNames;
          } 
          int i;
          for (i = 0; i < j; i++) {
            String str1 = arrayList1.get(i);
            String str2 = arrayList2.get(i);
            String str3 = (String)arrayMap.remove(str2);
            if (str3 != null) {
              arrayMap.put(str1, str3);
            } else {
              arrayMap.put(str1, str2);
            } 
          } 
        } 
      } 
      paramInt3--;
    } 
    return arrayMap;
  }
  
  private static void calculatePopFragments(BackStackRecord paramBackStackRecord, SparseArray paramSparseArray, boolean paramBoolean) {
    if (!paramBackStackRecord.mManager.mContainer.onHasView())
      return; 
    for (int i = paramBackStackRecord.mOps.size() - 1; i >= 0; i--)
      addToFirstInLastOut(paramBackStackRecord, paramBackStackRecord.mOps.get(i), paramSparseArray, true, paramBoolean); 
  }
  
  private static void callSharedElementStartEnd$5a6982c5(Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean, ArrayMap paramArrayMap) {
    SharedElementCallback sharedElementCallback;
    if (paramBoolean) {
      sharedElementCallback = paramFragment2.getEnterTransitionCallback();
    } else {
      sharedElementCallback = sharedElementCallback.getEnterTransitionCallback();
    } 
    if (sharedElementCallback != null) {
      int i;
      ArrayList<Object> arrayList1 = new ArrayList();
      ArrayList<Object> arrayList2 = new ArrayList();
      int j = 0;
      if (paramArrayMap == null) {
        i = 0;
      } else {
        i = paramArrayMap.size();
      } 
      while (j < i) {
        arrayList2.add(paramArrayMap.keyAt(j));
        arrayList1.add(paramArrayMap.valueAt(j));
        j++;
      } 
    } 
  }
  
  private static boolean canHandleAll(FragmentTransitionImpl paramFragmentTransitionImpl, List paramList) {
    int j = paramList.size();
    for (int i = 0; i < j; i++) {
      if (!paramFragmentTransitionImpl.canHandle(paramList.get(i)))
        return false; 
    } 
    return true;
  }
  
  private static ArrayMap captureInSharedElements(FragmentTransitionImpl paramFragmentTransitionImpl, ArrayMap paramArrayMap, Object paramObject, FragmentTransition$FragmentContainerTransition paramFragmentTransition$FragmentContainerTransition) {
    ArrayList<String> arrayList;
    Fragment fragment = paramFragmentTransition$FragmentContainerTransition.lastIn;
    View view = fragment.mView;
    if (paramArrayMap.isEmpty() || paramObject == null || view == null) {
      paramArrayMap.clear();
      return null;
    } 
    ArrayMap arrayMap = new ArrayMap();
    paramFragmentTransitionImpl.findNamedViews((Map)arrayMap, view);
    BackStackRecord backStackRecord = paramFragmentTransition$FragmentContainerTransition.lastInTransaction;
    if (paramFragmentTransition$FragmentContainerTransition.lastInIsPop) {
      paramObject = fragment.getExitTransitionCallback();
      arrayList = backStackRecord.mSharedElementSourceNames;
    } else {
      paramObject = fragment.getEnterTransitionCallback();
      arrayList = ((BackStackRecord)arrayList).mSharedElementTargetNames;
    } 
    if (arrayList != null)
      MapCollections.retainAllHelper((Map)arrayMap, arrayList); 
    if (paramObject != null) {
      int i;
      for (i = arrayList.size() - 1; i >= 0; i--) {
        String str = arrayList.get(i);
        paramObject = arrayMap.get(str);
        if (paramObject == null) {
          paramObject = findKeyForValue(paramArrayMap, str);
          if (paramObject != null)
            paramArrayMap.remove(paramObject); 
        } else if (!str.equals(ViewCompat.getTransitionName((View)paramObject))) {
          str = findKeyForValue(paramArrayMap, str);
          if (str != null)
            paramArrayMap.put(str, ViewCompat.getTransitionName((View)paramObject)); 
        } 
      } 
    } else {
      int i;
      for (i = paramArrayMap.size() - 1; i >= 0; i--) {
        if (!arrayMap.containsKey(paramArrayMap.valueAt(i)))
          paramArrayMap.removeAt(i); 
      } 
    } 
    return arrayMap;
  }
  
  private static ArrayMap captureOutSharedElements(FragmentTransitionImpl paramFragmentTransitionImpl, ArrayMap paramArrayMap, Object paramObject, FragmentTransition$FragmentContainerTransition paramFragmentTransition$FragmentContainerTransition) {
    ArrayList<String> arrayList;
    if (paramArrayMap.isEmpty() || paramObject == null) {
      paramArrayMap.clear();
      return null;
    } 
    paramObject = paramFragmentTransition$FragmentContainerTransition.firstOut;
    ArrayMap arrayMap = new ArrayMap();
    paramFragmentTransitionImpl.findNamedViews((Map)arrayMap, ((Fragment)paramObject).mView);
    BackStackRecord backStackRecord = paramFragmentTransition$FragmentContainerTransition.firstOutTransaction;
    if (paramFragmentTransition$FragmentContainerTransition.firstOutIsPop) {
      paramObject = paramObject.getEnterTransitionCallback();
      arrayList = backStackRecord.mSharedElementTargetNames;
    } else {
      paramObject = paramObject.getExitTransitionCallback();
      arrayList = ((BackStackRecord)arrayList).mSharedElementSourceNames;
    } 
    MapCollections.retainAllHelper((Map)arrayMap, arrayList);
    if (paramObject != null) {
      int i;
      for (i = arrayList.size() - 1; i >= 0; i--) {
        String str = arrayList.get(i);
        paramObject = arrayMap.get(str);
        if (paramObject == null) {
          paramArrayMap.remove(str);
        } else if (!str.equals(ViewCompat.getTransitionName((View)paramObject))) {
          str = (String)paramArrayMap.remove(str);
          paramArrayMap.put(ViewCompat.getTransitionName((View)paramObject), str);
        } 
      } 
    } else {
      MapCollections.retainAllHelper((Map)paramArrayMap, arrayMap.keySet());
    } 
    return arrayMap;
  }
  
  private static FragmentTransitionImpl chooseImpl(Fragment paramFragment1, Fragment paramFragment2) {
    ArrayList<Object> arrayList = new ArrayList();
    if (paramFragment1 != null) {
      Object object2 = paramFragment1.getExitTransition();
      if (object2 != null)
        arrayList.add(object2); 
      object2 = paramFragment1.getReturnTransition();
      if (object2 != null)
        arrayList.add(object2); 
      Object object1 = paramFragment1.getSharedElementReturnTransition();
      if (object1 != null)
        arrayList.add(object1); 
    } 
    if (paramFragment2 != null) {
      Object object = paramFragment2.getEnterTransition();
      if (object != null)
        arrayList.add(object); 
      object = paramFragment2.getReenterTransition();
      if (object != null)
        arrayList.add(object); 
      object = paramFragment2.getSharedElementEnterTransition();
      if (object != null)
        arrayList.add(object); 
    } 
    if (arrayList.isEmpty())
      return null; 
    if (PLATFORM_IMPL != null && canHandleAll(PLATFORM_IMPL, arrayList))
      return PLATFORM_IMPL; 
    if (SUPPORT_IMPL != null && canHandleAll(SUPPORT_IMPL, arrayList))
      return SUPPORT_IMPL; 
    if (PLATFORM_IMPL == null && SUPPORT_IMPL == null)
      return null; 
    throw new IllegalArgumentException("Invalid Transition types");
  }
  
  private static ArrayList configureEnteringExitingViews(FragmentTransitionImpl paramFragmentTransitionImpl, Object paramObject, Fragment paramFragment, ArrayList<?> paramArrayList, View paramView) {
    if (paramObject != null) {
      ArrayList<View> arrayList2 = new ArrayList();
      View view = paramFragment.mView;
      if (view != null)
        paramFragmentTransitionImpl.captureTransitioningViews(arrayList2, view); 
      if (paramArrayList != null)
        arrayList2.removeAll(paramArrayList); 
      ArrayList<View> arrayList1 = arrayList2;
      if (!arrayList2.isEmpty()) {
        arrayList2.add(paramView);
        paramFragmentTransitionImpl.addTargets(paramObject, arrayList2);
        return arrayList2;
      } 
    } else {
      paramFragment = null;
    } 
    return (ArrayList)paramFragment;
  }
  
  private static FragmentTransition$FragmentContainerTransition ensureContainer(FragmentTransition$FragmentContainerTransition paramFragmentTransition$FragmentContainerTransition, SparseArray paramSparseArray, int paramInt) {
    FragmentTransition$FragmentContainerTransition fragmentTransition$FragmentContainerTransition = paramFragmentTransition$FragmentContainerTransition;
    if (paramFragmentTransition$FragmentContainerTransition == null) {
      fragmentTransition$FragmentContainerTransition = new FragmentTransition$FragmentContainerTransition();
      paramSparseArray.put(paramInt, fragmentTransition$FragmentContainerTransition);
    } 
    return fragmentTransition$FragmentContainerTransition;
  }
  
  private static String findKeyForValue(ArrayMap paramArrayMap, String paramString) {
    int j = paramArrayMap.size();
    for (int i = 0; i < j; i++) {
      if (paramString.equals(paramArrayMap.valueAt(i)))
        return (String)paramArrayMap.keyAt(i); 
    } 
    return null;
  }
  
  private static Object getEnterTransition(FragmentTransitionImpl paramFragmentTransitionImpl, Fragment paramFragment, boolean paramBoolean) {
    Object object;
    if (paramFragment == null)
      return null; 
    if (paramBoolean) {
      object = paramFragment.getReenterTransition();
    } else {
      object = object.getEnterTransition();
    } 
    return paramFragmentTransitionImpl.cloneTransition(object);
  }
  
  private static Object getExitTransition(FragmentTransitionImpl paramFragmentTransitionImpl, Fragment paramFragment, boolean paramBoolean) {
    Object object;
    if (paramFragment == null)
      return null; 
    if (paramBoolean) {
      object = paramFragment.getReturnTransition();
    } else {
      object = object.getExitTransition();
    } 
    return paramFragmentTransitionImpl.cloneTransition(object);
  }
  
  private static View getInEpicenterView(ArrayMap paramArrayMap, FragmentTransition$FragmentContainerTransition paramFragmentTransition$FragmentContainerTransition, Object paramObject, boolean paramBoolean) {
    BackStackRecord backStackRecord = paramFragmentTransition$FragmentContainerTransition.lastInTransaction;
    if (paramObject != null && paramArrayMap != null && backStackRecord.mSharedElementSourceNames != null && !backStackRecord.mSharedElementSourceNames.isEmpty()) {
      String str;
      if (paramBoolean) {
        str = backStackRecord.mSharedElementSourceNames.get(0);
      } else {
        str = ((BackStackRecord)str).mSharedElementTargetNames.get(0);
      } 
      return (View)paramArrayMap.get(str);
    } 
    return null;
  }
  
  private static Object getSharedElementTransition(FragmentTransitionImpl paramFragmentTransitionImpl, Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean) {
    Object object;
    if (paramFragment1 == null || paramFragment2 == null)
      return null; 
    if (paramBoolean) {
      object = paramFragment2.getSharedElementReturnTransition();
    } else {
      object = object.getSharedElementEnterTransition();
    } 
    return paramFragmentTransitionImpl.wrapTransitionInSet(paramFragmentTransitionImpl.cloneTransition(object));
  }
  
  private static Object mergeTransitions(FragmentTransitionImpl paramFragmentTransitionImpl, Object paramObject1, Object paramObject2, Object paramObject3, Fragment paramFragment, boolean paramBoolean) {
    boolean bool2 = true;
    boolean bool = true;
    boolean bool1 = bool2;
    if (paramObject1 != null) {
      bool1 = bool2;
      if (paramObject2 != null) {
        bool1 = bool2;
        if (paramFragment != null) {
          if (paramBoolean) {
            if (paramFragment.mAnimationInfo == null || paramFragment.mAnimationInfo.mAllowReturnTransitionOverlap == null) {
              paramBoolean = bool;
            } else {
              paramBoolean = paramFragment.mAnimationInfo.mAllowReturnTransitionOverlap.booleanValue();
            } 
          } else if (paramFragment.mAnimationInfo == null || paramFragment.mAnimationInfo.mAllowEnterTransitionOverlap == null) {
            paramBoolean = bool;
          } else {
            paramBoolean = paramFragment.mAnimationInfo.mAllowEnterTransitionOverlap.booleanValue();
          } 
          bool1 = paramBoolean;
        } 
      } 
    } 
    return bool1 ? paramFragmentTransitionImpl.mergeTransitionsTogether(paramObject2, paramObject1, paramObject3) : paramFragmentTransitionImpl.mergeTransitionsInSequence(paramObject2, paramObject1, paramObject3);
  }
  
  private static FragmentTransitionImpl resolveSupportImpl() {
    try {
      return Class.forName("android.support.transition.FragmentTransitionSupport").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    } catch (Exception exception) {
      return null;
    } 
  }
  
  private static void setOutEpicenter(FragmentTransitionImpl paramFragmentTransitionImpl, Object paramObject1, Object paramObject2, ArrayMap paramArrayMap, boolean paramBoolean, BackStackRecord paramBackStackRecord) {
    if (paramBackStackRecord.mSharedElementSourceNames != null && !paramBackStackRecord.mSharedElementSourceNames.isEmpty()) {
      String str;
      if (paramBoolean) {
        str = paramBackStackRecord.mSharedElementTargetNames.get(0);
      } else {
        str = ((BackStackRecord)str).mSharedElementSourceNames.get(0);
      } 
      View view = (View)paramArrayMap.get(str);
      paramFragmentTransitionImpl.setEpicenter(paramObject1, view);
      if (paramObject2 != null)
        paramFragmentTransitionImpl.setEpicenter(paramObject2, view); 
    } 
  }
  
  private static void setViewVisibility(ArrayList<View> paramArrayList, int paramInt) {
    if (paramArrayList == null)
      return; 
    for (int i = paramArrayList.size() - 1; i >= 0; i--)
      ((View)paramArrayList.get(i)).setVisibility(paramInt); 
  }
  
  static void startTransitions(FragmentManagerImpl paramFragmentManagerImpl, ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt1, int paramInt2, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: astore #12
    //   3: iload #5
    //   5: istore #10
    //   7: aload #12
    //   9: getfield mCurState : I
    //   12: ifgt -> 16
    //   15: return
    //   16: new android/util/SparseArray
    //   19: dup
    //   20: invokespecial <init> : ()V
    //   23: astore #13
    //   25: iload_3
    //   26: istore #6
    //   28: iload #6
    //   30: iload #4
    //   32: if_icmpge -> 91
    //   35: aload_1
    //   36: iload #6
    //   38: invokevirtual get : (I)Ljava/lang/Object;
    //   41: checkcast android/support/v4/app/BackStackRecord
    //   44: astore #14
    //   46: aload_2
    //   47: iload #6
    //   49: invokevirtual get : (I)Ljava/lang/Object;
    //   52: checkcast java/lang/Boolean
    //   55: invokevirtual booleanValue : ()Z
    //   58: ifeq -> 73
    //   61: aload #14
    //   63: aload #13
    //   65: iload #10
    //   67: invokestatic calculatePopFragments : (Landroid/support/v4/app/BackStackRecord;Landroid/util/SparseArray;Z)V
    //   70: goto -> 82
    //   73: aload #14
    //   75: aload #13
    //   77: iload #10
    //   79: invokestatic calculateFragments : (Landroid/support/v4/app/BackStackRecord;Landroid/util/SparseArray;Z)V
    //   82: iload #6
    //   84: iconst_1
    //   85: iadd
    //   86: istore #6
    //   88: goto -> 28
    //   91: aload #13
    //   93: invokevirtual size : ()I
    //   96: ifeq -> 1439
    //   99: new android/view/View
    //   102: dup
    //   103: aload #12
    //   105: getfield mHost : Landroid/support/v4/app/FragmentHostCallback;
    //   108: getfield mContext : Landroid/content/Context;
    //   111: invokespecial <init> : (Landroid/content/Context;)V
    //   114: astore #22
    //   116: aload #13
    //   118: invokevirtual size : ()I
    //   121: istore #7
    //   123: iconst_0
    //   124: istore #6
    //   126: aload_0
    //   127: astore #12
    //   129: iload #6
    //   131: iload #7
    //   133: if_icmpge -> 1439
    //   136: aload #13
    //   138: iload #6
    //   140: invokevirtual keyAt : (I)I
    //   143: istore #9
    //   145: iload #9
    //   147: aload_1
    //   148: aload_2
    //   149: iload_3
    //   150: iload #4
    //   152: invokestatic calculateNameOverrides : (ILjava/util/ArrayList;Ljava/util/ArrayList;II)Landroid/support/v4/util/ArrayMap;
    //   155: astore #18
    //   157: aload #13
    //   159: iload #6
    //   161: invokevirtual valueAt : (I)Ljava/lang/Object;
    //   164: checkcast android/support/v4/app/FragmentTransition$FragmentContainerTransition
    //   167: astore #23
    //   169: iload #5
    //   171: ifeq -> 830
    //   174: aload #12
    //   176: getfield mContainer : Landroid/support/v4/app/FragmentContainer;
    //   179: invokevirtual onHasView : ()Z
    //   182: ifeq -> 203
    //   185: aload #12
    //   187: getfield mContainer : Landroid/support/v4/app/FragmentContainer;
    //   190: iload #9
    //   192: invokevirtual onFindViewById : (I)Landroid/view/View;
    //   195: checkcast android/view/ViewGroup
    //   198: astore #14
    //   200: goto -> 206
    //   203: aconst_null
    //   204: astore #14
    //   206: aload #14
    //   208: ifnull -> 827
    //   211: aload #23
    //   213: getfield lastIn : Landroid/support/v4/app/Fragment;
    //   216: astore #19
    //   218: aload #23
    //   220: getfield firstOut : Landroid/support/v4/app/Fragment;
    //   223: astore #27
    //   225: aload #27
    //   227: aload #19
    //   229: invokestatic chooseImpl : (Landroid/support/v4/app/Fragment;Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransitionImpl;
    //   232: astore #21
    //   234: aload #21
    //   236: ifnull -> 827
    //   239: aload #23
    //   241: getfield lastInIsPop : Z
    //   244: istore #10
    //   246: aload #23
    //   248: getfield firstOutIsPop : Z
    //   251: istore #11
    //   253: new java/util/ArrayList
    //   256: dup
    //   257: invokespecial <init> : ()V
    //   260: astore #20
    //   262: new java/util/ArrayList
    //   265: dup
    //   266: invokespecial <init> : ()V
    //   269: astore #24
    //   271: aload #21
    //   273: aload #19
    //   275: iload #10
    //   277: invokestatic getEnterTransition : (Landroid/support/v4/app/FragmentTransitionImpl;Landroid/support/v4/app/Fragment;Z)Ljava/lang/Object;
    //   280: astore #25
    //   282: aload #21
    //   284: aload #27
    //   286: iload #11
    //   288: invokestatic getExitTransition : (Landroid/support/v4/app/FragmentTransitionImpl;Landroid/support/v4/app/Fragment;Z)Ljava/lang/Object;
    //   291: astore #26
    //   293: aload #23
    //   295: getfield lastIn : Landroid/support/v4/app/Fragment;
    //   298: astore #28
    //   300: aload #23
    //   302: getfield firstOut : Landroid/support/v4/app/Fragment;
    //   305: astore #29
    //   307: aload #28
    //   309: ifnull -> 324
    //   312: aload #28
    //   314: getfield mView : Landroid/view/View;
    //   317: iconst_0
    //   318: invokevirtual setVisibility : (I)V
    //   321: goto -> 324
    //   324: aload #28
    //   326: ifnull -> 611
    //   329: aload #29
    //   331: ifnonnull -> 337
    //   334: goto -> 611
    //   337: aload #23
    //   339: getfield lastInIsPop : Z
    //   342: istore #11
    //   344: aload #18
    //   346: invokevirtual isEmpty : ()Z
    //   349: ifeq -> 358
    //   352: aconst_null
    //   353: astore #12
    //   355: goto -> 371
    //   358: aload #21
    //   360: aload #28
    //   362: aload #29
    //   364: iload #11
    //   366: invokestatic getSharedElementTransition : (Landroid/support/v4/app/FragmentTransitionImpl;Landroid/support/v4/app/Fragment;Landroid/support/v4/app/Fragment;Z)Ljava/lang/Object;
    //   369: astore #12
    //   371: aload #21
    //   373: aload #18
    //   375: aload #12
    //   377: aload #23
    //   379: invokestatic captureOutSharedElements : (Landroid/support/v4/app/FragmentTransitionImpl;Landroid/support/v4/util/ArrayMap;Ljava/lang/Object;Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;)Landroid/support/v4/util/ArrayMap;
    //   382: astore #15
    //   384: aload #21
    //   386: aload #18
    //   388: aload #12
    //   390: aload #23
    //   392: invokestatic captureInSharedElements : (Landroid/support/v4/app/FragmentTransitionImpl;Landroid/support/v4/util/ArrayMap;Ljava/lang/Object;Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;)Landroid/support/v4/util/ArrayMap;
    //   395: astore #30
    //   397: aload #18
    //   399: invokevirtual isEmpty : ()Z
    //   402: ifeq -> 431
    //   405: aload #15
    //   407: ifnull -> 415
    //   410: aload #15
    //   412: invokevirtual clear : ()V
    //   415: aload #30
    //   417: ifnull -> 425
    //   420: aload #30
    //   422: invokevirtual clear : ()V
    //   425: aconst_null
    //   426: astore #12
    //   428: goto -> 455
    //   431: aload #24
    //   433: aload #15
    //   435: aload #18
    //   437: invokevirtual keySet : ()Ljava/util/Set;
    //   440: invokestatic addSharedElementsWithMatchingNames : (Ljava/util/ArrayList;Landroid/support/v4/util/ArrayMap;Ljava/util/Collection;)V
    //   443: aload #20
    //   445: aload #30
    //   447: aload #18
    //   449: invokevirtual values : ()Ljava/util/Collection;
    //   452: invokestatic addSharedElementsWithMatchingNames : (Ljava/util/ArrayList;Landroid/support/v4/util/ArrayMap;Ljava/util/Collection;)V
    //   455: aload #25
    //   457: ifnonnull -> 473
    //   460: aload #26
    //   462: ifnonnull -> 473
    //   465: aload #12
    //   467: ifnonnull -> 473
    //   470: goto -> 611
    //   473: aload #28
    //   475: aload #29
    //   477: iload #11
    //   479: aload #15
    //   481: invokestatic callSharedElementStartEnd$5a6982c5 : (Landroid/support/v4/app/Fragment;Landroid/support/v4/app/Fragment;ZLandroid/support/v4/util/ArrayMap;)V
    //   484: aload #12
    //   486: ifnull -> 572
    //   489: aload #20
    //   491: aload #22
    //   493: invokevirtual add : (Ljava/lang/Object;)Z
    //   496: pop
    //   497: aload #21
    //   499: aload #12
    //   501: aload #22
    //   503: aload #24
    //   505: invokevirtual setSharedElementTargets : (Ljava/lang/Object;Landroid/view/View;Ljava/util/ArrayList;)V
    //   508: aload #21
    //   510: aload #12
    //   512: aload #26
    //   514: aload #15
    //   516: aload #23
    //   518: getfield firstOutIsPop : Z
    //   521: aload #23
    //   523: getfield firstOutTransaction : Landroid/support/v4/app/BackStackRecord;
    //   526: invokestatic setOutEpicenter : (Landroid/support/v4/app/FragmentTransitionImpl;Ljava/lang/Object;Ljava/lang/Object;Landroid/support/v4/util/ArrayMap;ZLandroid/support/v4/app/BackStackRecord;)V
    //   529: new android/graphics/Rect
    //   532: dup
    //   533: invokespecial <init> : ()V
    //   536: astore #15
    //   538: aload #30
    //   540: aload #23
    //   542: aload #25
    //   544: iload #11
    //   546: invokestatic getInEpicenterView : (Landroid/support/v4/util/ArrayMap;Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;Ljava/lang/Object;Z)Landroid/view/View;
    //   549: astore #16
    //   551: aload #16
    //   553: ifnull -> 565
    //   556: aload #21
    //   558: aload #25
    //   560: aload #15
    //   562: invokevirtual setEpicenter : (Ljava/lang/Object;Landroid/graphics/Rect;)V
    //   565: aload #15
    //   567: astore #17
    //   569: goto -> 583
    //   572: aconst_null
    //   573: astore #15
    //   575: aload #15
    //   577: astore #17
    //   579: aload #15
    //   581: astore #16
    //   583: aload #14
    //   585: new android/support/v4/app/FragmentTransition$3
    //   588: dup
    //   589: aload #28
    //   591: aload #29
    //   593: iload #11
    //   595: aload #30
    //   597: aload #16
    //   599: aload #17
    //   601: invokespecial <init> : (Landroid/support/v4/app/Fragment;Landroid/support/v4/app/Fragment;ZLandroid/support/v4/util/ArrayMap;Landroid/view/View;Landroid/graphics/Rect;)V
    //   604: invokestatic add : (Landroid/view/View;Ljava/lang/Runnable;)Landroid/support/v4/app/OneShotPreDrawListener;
    //   607: pop
    //   608: goto -> 614
    //   611: aconst_null
    //   612: astore #12
    //   614: aload #25
    //   616: ifnonnull -> 629
    //   619: aload #12
    //   621: ifnonnull -> 629
    //   624: aload #26
    //   626: ifnull -> 827
    //   629: aload #21
    //   631: aload #26
    //   633: aload #27
    //   635: aload #24
    //   637: aload #22
    //   639: invokestatic configureEnteringExitingViews : (Landroid/support/v4/app/FragmentTransitionImpl;Ljava/lang/Object;Landroid/support/v4/app/Fragment;Ljava/util/ArrayList;Landroid/view/View;)Ljava/util/ArrayList;
    //   642: astore #15
    //   644: aload #21
    //   646: aload #25
    //   648: aload #19
    //   650: aload #20
    //   652: aload #22
    //   654: invokestatic configureEnteringExitingViews : (Landroid/support/v4/app/FragmentTransitionImpl;Ljava/lang/Object;Landroid/support/v4/app/Fragment;Ljava/util/ArrayList;Landroid/view/View;)Ljava/util/ArrayList;
    //   657: astore #16
    //   659: aload #16
    //   661: iconst_4
    //   662: invokestatic setViewVisibility : (Ljava/util/ArrayList;I)V
    //   665: aload #21
    //   667: aload #25
    //   669: aload #26
    //   671: aload #12
    //   673: aload #19
    //   675: iload #10
    //   677: invokestatic mergeTransitions : (Landroid/support/v4/app/FragmentTransitionImpl;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Landroid/support/v4/app/Fragment;Z)Ljava/lang/Object;
    //   680: astore #17
    //   682: aload #17
    //   684: ifnull -> 827
    //   687: aload #27
    //   689: ifnull -> 759
    //   692: aload #26
    //   694: ifnull -> 759
    //   697: aload #27
    //   699: getfield mAdded : Z
    //   702: ifeq -> 759
    //   705: aload #27
    //   707: getfield mHidden : Z
    //   710: ifeq -> 759
    //   713: aload #27
    //   715: getfield mHiddenChanged : Z
    //   718: ifeq -> 759
    //   721: aload #27
    //   723: iconst_1
    //   724: invokevirtual setHideReplaced : (Z)V
    //   727: aload #21
    //   729: aload #26
    //   731: aload #27
    //   733: getfield mView : Landroid/view/View;
    //   736: aload #15
    //   738: invokevirtual scheduleHideFragmentView : (Ljava/lang/Object;Landroid/view/View;Ljava/util/ArrayList;)V
    //   741: aload #27
    //   743: getfield mContainer : Landroid/view/ViewGroup;
    //   746: new android/support/v4/app/FragmentTransition$1
    //   749: dup
    //   750: aload #15
    //   752: invokespecial <init> : (Ljava/util/ArrayList;)V
    //   755: invokestatic add : (Landroid/view/View;Ljava/lang/Runnable;)Landroid/support/v4/app/OneShotPreDrawListener;
    //   758: pop
    //   759: aload #20
    //   761: invokestatic prepareSetNameOverridesReordered : (Ljava/util/ArrayList;)Ljava/util/ArrayList;
    //   764: astore #19
    //   766: aload #21
    //   768: aload #17
    //   770: aload #25
    //   772: aload #16
    //   774: aload #26
    //   776: aload #15
    //   778: aload #12
    //   780: aload #20
    //   782: invokevirtual scheduleRemoveTargets : (Ljava/lang/Object;Ljava/lang/Object;Ljava/util/ArrayList;Ljava/lang/Object;Ljava/util/ArrayList;Ljava/lang/Object;Ljava/util/ArrayList;)V
    //   785: aload #21
    //   787: aload #14
    //   789: aload #17
    //   791: invokevirtual beginDelayedTransition : (Landroid/view/ViewGroup;Ljava/lang/Object;)V
    //   794: aload #14
    //   796: aload #24
    //   798: aload #20
    //   800: aload #19
    //   802: aload #18
    //   804: invokestatic setNameOverridesReordered : (Landroid/view/View;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/Map;)V
    //   807: aload #16
    //   809: iconst_0
    //   810: invokestatic setViewVisibility : (Ljava/util/ArrayList;I)V
    //   813: aload #21
    //   815: aload #12
    //   817: aload #24
    //   819: aload #20
    //   821: invokevirtual swapSharedElementTargets : (Ljava/lang/Object;Ljava/util/ArrayList;Ljava/util/ArrayList;)V
    //   824: goto -> 827
    //   827: goto -> 1410
    //   830: iload #6
    //   832: istore #8
    //   834: iload #7
    //   836: istore #8
    //   838: aload_0
    //   839: getfield mContainer : Landroid/support/v4/app/FragmentContainer;
    //   842: invokevirtual onHasView : ()Z
    //   845: ifeq -> 865
    //   848: aload_0
    //   849: getfield mContainer : Landroid/support/v4/app/FragmentContainer;
    //   852: iload #9
    //   854: invokevirtual onFindViewById : (I)Landroid/view/View;
    //   857: checkcast android/view/ViewGroup
    //   860: astore #14
    //   862: goto -> 868
    //   865: aconst_null
    //   866: astore #14
    //   868: aload #14
    //   870: ifnull -> 1410
    //   873: aload #23
    //   875: getfield lastIn : Landroid/support/v4/app/Fragment;
    //   878: astore #19
    //   880: aload #23
    //   882: getfield firstOut : Landroid/support/v4/app/Fragment;
    //   885: astore #24
    //   887: aload #24
    //   889: aload #19
    //   891: invokestatic chooseImpl : (Landroid/support/v4/app/Fragment;Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransitionImpl;
    //   894: astore #16
    //   896: aload #16
    //   898: ifnull -> 1410
    //   901: aload #23
    //   903: getfield lastInIsPop : Z
    //   906: istore #10
    //   908: aload #23
    //   910: getfield firstOutIsPop : Z
    //   913: istore #11
    //   915: aload #16
    //   917: aload #19
    //   919: iload #10
    //   921: invokestatic getEnterTransition : (Landroid/support/v4/app/FragmentTransitionImpl;Landroid/support/v4/app/Fragment;Z)Ljava/lang/Object;
    //   924: astore #21
    //   926: aload #16
    //   928: aload #24
    //   930: iload #11
    //   932: invokestatic getExitTransition : (Landroid/support/v4/app/FragmentTransitionImpl;Landroid/support/v4/app/Fragment;Z)Ljava/lang/Object;
    //   935: astore #17
    //   937: new java/util/ArrayList
    //   940: dup
    //   941: invokespecial <init> : ()V
    //   944: astore #25
    //   946: new java/util/ArrayList
    //   949: dup
    //   950: invokespecial <init> : ()V
    //   953: astore #20
    //   955: aload #23
    //   957: getfield lastIn : Landroid/support/v4/app/Fragment;
    //   960: astore #26
    //   962: aload #23
    //   964: getfield firstOut : Landroid/support/v4/app/Fragment;
    //   967: astore #27
    //   969: aload #26
    //   971: ifnull -> 1192
    //   974: aload #27
    //   976: ifnonnull -> 982
    //   979: goto -> 1192
    //   982: aload #23
    //   984: getfield lastInIsPop : Z
    //   987: istore #10
    //   989: aload #18
    //   991: invokevirtual isEmpty : ()Z
    //   994: ifeq -> 1003
    //   997: aconst_null
    //   998: astore #12
    //   1000: goto -> 1016
    //   1003: aload #16
    //   1005: aload #26
    //   1007: aload #27
    //   1009: iload #10
    //   1011: invokestatic getSharedElementTransition : (Landroid/support/v4/app/FragmentTransitionImpl;Landroid/support/v4/app/Fragment;Landroid/support/v4/app/Fragment;Z)Ljava/lang/Object;
    //   1014: astore #12
    //   1016: aload #16
    //   1018: aload #18
    //   1020: aload #12
    //   1022: aload #23
    //   1024: invokestatic captureOutSharedElements : (Landroid/support/v4/app/FragmentTransitionImpl;Landroid/support/v4/util/ArrayMap;Ljava/lang/Object;Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;)Landroid/support/v4/util/ArrayMap;
    //   1027: astore #28
    //   1029: aload #18
    //   1031: invokevirtual isEmpty : ()Z
    //   1034: ifeq -> 1043
    //   1037: aconst_null
    //   1038: astore #12
    //   1040: goto -> 1054
    //   1043: aload #25
    //   1045: aload #28
    //   1047: invokevirtual values : ()Ljava/util/Collection;
    //   1050: invokevirtual addAll : (Ljava/util/Collection;)Z
    //   1053: pop
    //   1054: aload #21
    //   1056: ifnonnull -> 1075
    //   1059: aload #17
    //   1061: ifnonnull -> 1075
    //   1064: aload #12
    //   1066: ifnonnull -> 1075
    //   1069: aconst_null
    //   1070: astore #12
    //   1072: goto -> 1195
    //   1075: aload #26
    //   1077: aload #27
    //   1079: iload #10
    //   1081: aload #28
    //   1083: invokestatic callSharedElementStartEnd$5a6982c5 : (Landroid/support/v4/app/Fragment;Landroid/support/v4/app/Fragment;ZLandroid/support/v4/util/ArrayMap;)V
    //   1086: aload #12
    //   1088: ifnull -> 1149
    //   1091: new android/graphics/Rect
    //   1094: dup
    //   1095: invokespecial <init> : ()V
    //   1098: astore #15
    //   1100: aload #16
    //   1102: aload #12
    //   1104: aload #22
    //   1106: aload #25
    //   1108: invokevirtual setSharedElementTargets : (Ljava/lang/Object;Landroid/view/View;Ljava/util/ArrayList;)V
    //   1111: aload #16
    //   1113: aload #12
    //   1115: aload #17
    //   1117: aload #28
    //   1119: aload #23
    //   1121: getfield firstOutIsPop : Z
    //   1124: aload #23
    //   1126: getfield firstOutTransaction : Landroid/support/v4/app/BackStackRecord;
    //   1129: invokestatic setOutEpicenter : (Landroid/support/v4/app/FragmentTransitionImpl;Ljava/lang/Object;Ljava/lang/Object;Landroid/support/v4/util/ArrayMap;ZLandroid/support/v4/app/BackStackRecord;)V
    //   1132: aload #21
    //   1134: ifnull -> 1146
    //   1137: aload #16
    //   1139: aload #21
    //   1141: aload #15
    //   1143: invokevirtual setEpicenter : (Ljava/lang/Object;Landroid/graphics/Rect;)V
    //   1146: goto -> 1152
    //   1149: aconst_null
    //   1150: astore #15
    //   1152: aload #14
    //   1154: new android/support/v4/app/FragmentTransition$4
    //   1157: dup
    //   1158: aload #16
    //   1160: aload #18
    //   1162: aload #12
    //   1164: aload #23
    //   1166: aload #20
    //   1168: aload #22
    //   1170: aload #26
    //   1172: aload #27
    //   1174: iload #10
    //   1176: aload #25
    //   1178: aload #21
    //   1180: aload #15
    //   1182: invokespecial <init> : (Landroid/support/v4/app/FragmentTransitionImpl;Landroid/support/v4/util/ArrayMap;Ljava/lang/Object;Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;Ljava/util/ArrayList;Landroid/view/View;Landroid/support/v4/app/Fragment;Landroid/support/v4/app/Fragment;ZLjava/util/ArrayList;Ljava/lang/Object;Landroid/graphics/Rect;)V
    //   1185: invokestatic add : (Landroid/view/View;Ljava/lang/Runnable;)Landroid/support/v4/app/OneShotPreDrawListener;
    //   1188: pop
    //   1189: goto -> 1195
    //   1192: aconst_null
    //   1193: astore #12
    //   1195: iload #6
    //   1197: istore #8
    //   1199: aload #17
    //   1201: astore #15
    //   1203: aload #21
    //   1205: ifnonnull -> 1226
    //   1208: aload #12
    //   1210: ifnonnull -> 1226
    //   1213: iload #8
    //   1215: istore #9
    //   1217: iload #7
    //   1219: istore #6
    //   1221: aload #15
    //   1223: ifnull -> 1422
    //   1226: aload #16
    //   1228: aload #15
    //   1230: aload #24
    //   1232: aload #25
    //   1234: aload #22
    //   1236: invokestatic configureEnteringExitingViews : (Landroid/support/v4/app/FragmentTransitionImpl;Ljava/lang/Object;Landroid/support/v4/app/Fragment;Ljava/util/ArrayList;Landroid/view/View;)Ljava/util/ArrayList;
    //   1239: astore #17
    //   1241: aload #17
    //   1243: ifnull -> 1254
    //   1246: aload #17
    //   1248: invokevirtual isEmpty : ()Z
    //   1251: ifeq -> 1257
    //   1254: aconst_null
    //   1255: astore #15
    //   1257: aload #16
    //   1259: aload #21
    //   1261: aload #22
    //   1263: invokevirtual addTarget : (Ljava/lang/Object;Landroid/view/View;)V
    //   1266: aload #16
    //   1268: aload #21
    //   1270: aload #15
    //   1272: aload #12
    //   1274: aload #19
    //   1276: aload #23
    //   1278: getfield lastInIsPop : Z
    //   1281: invokestatic mergeTransitions : (Landroid/support/v4/app/FragmentTransitionImpl;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Landroid/support/v4/app/Fragment;Z)Ljava/lang/Object;
    //   1284: astore #23
    //   1286: iload #8
    //   1288: istore #9
    //   1290: iload #7
    //   1292: istore #6
    //   1294: aload #23
    //   1296: ifnull -> 1422
    //   1299: new java/util/ArrayList
    //   1302: dup
    //   1303: invokespecial <init> : ()V
    //   1306: astore #24
    //   1308: aload #16
    //   1310: aload #23
    //   1312: aload #21
    //   1314: aload #24
    //   1316: aload #15
    //   1318: aload #17
    //   1320: aload #12
    //   1322: aload #20
    //   1324: invokevirtual scheduleRemoveTargets : (Ljava/lang/Object;Ljava/lang/Object;Ljava/util/ArrayList;Ljava/lang/Object;Ljava/util/ArrayList;Ljava/lang/Object;Ljava/util/ArrayList;)V
    //   1327: aload #14
    //   1329: new android/support/v4/app/FragmentTransition$2
    //   1332: dup
    //   1333: aload #21
    //   1335: aload #16
    //   1337: aload #22
    //   1339: aload #19
    //   1341: aload #20
    //   1343: aload #24
    //   1345: aload #17
    //   1347: aload #15
    //   1349: invokespecial <init> : (Ljava/lang/Object;Landroid/support/v4/app/FragmentTransitionImpl;Landroid/view/View;Landroid/support/v4/app/Fragment;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/Object;)V
    //   1352: invokestatic add : (Landroid/view/View;Ljava/lang/Runnable;)Landroid/support/v4/app/OneShotPreDrawListener;
    //   1355: pop
    //   1356: aload #14
    //   1358: new android/support/v4/app/FragmentTransitionImpl$2
    //   1361: dup
    //   1362: aload #20
    //   1364: aload #18
    //   1366: invokespecial <init> : (Ljava/util/ArrayList;Ljava/util/Map;)V
    //   1369: invokestatic add : (Landroid/view/View;Ljava/lang/Runnable;)Landroid/support/v4/app/OneShotPreDrawListener;
    //   1372: pop
    //   1373: aload #16
    //   1375: aload #14
    //   1377: aload #23
    //   1379: invokevirtual beginDelayedTransition : (Landroid/view/ViewGroup;Ljava/lang/Object;)V
    //   1382: aload #14
    //   1384: new android/support/v4/app/FragmentTransitionImpl$3
    //   1387: dup
    //   1388: aload #20
    //   1390: aload #18
    //   1392: invokespecial <init> : (Ljava/util/ArrayList;Ljava/util/Map;)V
    //   1395: invokestatic add : (Landroid/view/View;Ljava/lang/Runnable;)Landroid/support/v4/app/OneShotPreDrawListener;
    //   1398: pop
    //   1399: iload #8
    //   1401: istore #9
    //   1403: iload #7
    //   1405: istore #6
    //   1407: goto -> 1422
    //   1410: iload #6
    //   1412: istore #8
    //   1414: iload #7
    //   1416: istore #6
    //   1418: iload #8
    //   1420: istore #9
    //   1422: iload #9
    //   1424: iconst_1
    //   1425: iadd
    //   1426: istore #8
    //   1428: iload #6
    //   1430: istore #7
    //   1432: iload #8
    //   1434: istore #6
    //   1436: goto -> 126
    //   1439: return
  }
  
  static {
    FragmentTransitionImpl fragmentTransitionImpl;
  }
  
  static {
    if (Build.VERSION.SDK_INT >= 21) {
      fragmentTransitionImpl = new FragmentTransitionCompat21();
    } else {
      fragmentTransitionImpl = null;
    } 
    PLATFORM_IMPL = fragmentTransitionImpl;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\app\FragmentTransition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */