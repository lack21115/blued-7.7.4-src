package androidx.fragment.app;

import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

class FragmentTransition {
  private static final int[] a = new int[] { 
      0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 
      10 };
  
  private static final FragmentTransitionImpl b;
  
  private static final FragmentTransitionImpl c = b();
  
  static View a(ArrayMap<String, View> paramArrayMap, FragmentContainerTransition paramFragmentContainerTransition, Object paramObject, boolean paramBoolean) {
    BackStackRecord backStackRecord = paramFragmentContainerTransition.lastInTransaction;
    if (paramObject != null && paramArrayMap != null && backStackRecord.r != null && !backStackRecord.r.isEmpty()) {
      String str;
      if (paramBoolean) {
        str = backStackRecord.r.get(0);
      } else {
        str = ((BackStackRecord)str).s.get(0);
      } 
      return (View)paramArrayMap.get(str);
    } 
    return null;
  }
  
  private static ArrayMap<String, String> a(int paramInt1, ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt2, int paramInt3) {
    ArrayMap<String, String> arrayMap = new ArrayMap();
    while (--paramInt3 >= paramInt2) {
      BackStackRecord backStackRecord = paramArrayList.get(paramInt3);
      if (backStackRecord.b(paramInt1)) {
        boolean bool = ((Boolean)paramArrayList1.get(paramInt3)).booleanValue();
        if (backStackRecord.r != null) {
          ArrayList<String> arrayList1;
          ArrayList<String> arrayList2;
          int j = backStackRecord.r.size();
          if (bool) {
            arrayList2 = backStackRecord.r;
            arrayList1 = backStackRecord.s;
          } else {
            arrayList1 = backStackRecord.r;
            arrayList2 = backStackRecord.s;
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
  
  static ArrayMap<String, View> a(FragmentTransitionImpl paramFragmentTransitionImpl, ArrayMap<String, String> paramArrayMap, Object paramObject, FragmentContainerTransition paramFragmentContainerTransition) {
    ArrayList<String> arrayList;
    Fragment fragment = paramFragmentContainerTransition.lastIn;
    View view = fragment.getView();
    if (paramArrayMap.isEmpty() || paramObject == null || view == null) {
      paramArrayMap.clear();
      return null;
    } 
    ArrayMap<String, View> arrayMap = new ArrayMap();
    paramFragmentTransitionImpl.a((Map<String, View>)arrayMap, view);
    BackStackRecord backStackRecord = paramFragmentContainerTransition.lastInTransaction;
    if (paramFragmentContainerTransition.lastInIsPop) {
      paramObject = fragment.getExitTransitionCallback();
      arrayList = backStackRecord.r;
    } else {
      paramObject = fragment.getEnterTransitionCallback();
      arrayList = ((BackStackRecord)arrayList).s;
    } 
    if (arrayList != null) {
      arrayMap.retainAll(arrayList);
      arrayMap.retainAll(paramArrayMap.values());
    } 
    if (paramObject != null) {
      paramObject.onMapSharedElements(arrayList, (Map)arrayMap);
      int i;
      for (i = arrayList.size() - 1; i >= 0; i--) {
        String str = arrayList.get(i);
        paramObject = arrayMap.get(str);
        if (paramObject == null) {
          paramObject = a(paramArrayMap, str);
          if (paramObject != null)
            paramArrayMap.remove(paramObject); 
        } else if (!str.equals(ViewCompat.getTransitionName((View)paramObject))) {
          str = a(paramArrayMap, str);
          if (str != null)
            paramArrayMap.put(str, ViewCompat.getTransitionName((View)paramObject)); 
        } 
      } 
    } else {
      a(paramArrayMap, arrayMap);
    } 
    return arrayMap;
  }
  
  private static FragmentContainerTransition a(FragmentContainerTransition paramFragmentContainerTransition, SparseArray<FragmentContainerTransition> paramSparseArray, int paramInt) {
    FragmentContainerTransition fragmentContainerTransition = paramFragmentContainerTransition;
    if (paramFragmentContainerTransition == null) {
      fragmentContainerTransition = new FragmentContainerTransition();
      paramSparseArray.put(paramInt, fragmentContainerTransition);
    } 
    return fragmentContainerTransition;
  }
  
  private static FragmentTransitionImpl a(Fragment paramFragment1, Fragment paramFragment2) {
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
    FragmentTransitionImpl fragmentTransitionImpl = b;
    if (fragmentTransitionImpl != null && a(fragmentTransitionImpl, arrayList))
      return b; 
    fragmentTransitionImpl = c;
    if (fragmentTransitionImpl != null && a(fragmentTransitionImpl, arrayList))
      return c; 
    if (b == null && c == null)
      return null; 
    throw new IllegalArgumentException("Invalid Transition types");
  }
  
  private static Object a(FragmentTransitionImpl paramFragmentTransitionImpl, ViewGroup paramViewGroup, View paramView, ArrayMap<String, String> paramArrayMap, FragmentContainerTransition paramFragmentContainerTransition, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2, Object paramObject1, Object paramObject2) {
    Fragment fragment1 = paramFragmentContainerTransition.lastIn;
    Fragment fragment2 = paramFragmentContainerTransition.firstOut;
    if (fragment1 != null)
      fragment1.requireView().setVisibility(0); 
    if (fragment1 != null) {
      Object object1;
      View view1;
      View view2;
      Object object2;
      if (fragment2 == null)
        return null; 
      boolean bool = paramFragmentContainerTransition.lastInIsPop;
      if (paramArrayMap.isEmpty()) {
        object2 = null;
      } else {
        object2 = a(paramFragmentTransitionImpl, fragment1, fragment2, bool);
      } 
      ArrayMap<String, View> arrayMap2 = b(paramFragmentTransitionImpl, paramArrayMap, object2, paramFragmentContainerTransition);
      ArrayMap<String, View> arrayMap1 = a(paramFragmentTransitionImpl, paramArrayMap, object2, paramFragmentContainerTransition);
      if (paramArrayMap.isEmpty()) {
        if (arrayMap2 != null)
          arrayMap2.clear(); 
        if (arrayMap1 != null)
          arrayMap1.clear(); 
        paramArrayMap = null;
      } else {
        a(paramArrayList1, arrayMap2, paramArrayMap.keySet());
        a(paramArrayList2, arrayMap1, paramArrayMap.values());
        object1 = object2;
      } 
      if (paramObject1 == null && paramObject2 == null && object1 == null)
        return null; 
      a(fragment1, fragment2, bool, arrayMap2, true);
      if (object1 != null) {
        paramArrayList2.add(paramView);
        paramFragmentTransitionImpl.setSharedElementTargets(object1, paramView, paramArrayList1);
        a(paramFragmentTransitionImpl, object1, paramObject2, arrayMap2, paramFragmentContainerTransition.firstOutIsPop, paramFragmentContainerTransition.firstOutTransaction);
        Rect rect1 = new Rect();
        view1 = a(arrayMap1, paramFragmentContainerTransition, paramObject1, bool);
        if (view1 != null)
          paramFragmentTransitionImpl.setEpicenter(paramObject1, rect1); 
        Rect rect2 = rect1;
      } else {
        paramView = null;
        view2 = paramView;
        view1 = paramView;
      } 
      OneShotPreDrawListener.add((View)paramViewGroup, new Runnable(fragment1, fragment2, bool, arrayMap1, view1, paramFragmentTransitionImpl, (Rect)view2) {
            public void run() {
              FragmentTransition.a(this.a, this.b, this.c, this.d, false);
              View view = this.e;
              if (view != null)
                this.f.a(view, this.g); 
            }
          });
      return object1;
    } 
    return null;
  }
  
  private static Object a(FragmentTransitionImpl paramFragmentTransitionImpl, Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean) {
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
  
  private static Object a(FragmentTransitionImpl paramFragmentTransitionImpl, Fragment paramFragment, boolean paramBoolean) {
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
  
  private static Object a(FragmentTransitionImpl paramFragmentTransitionImpl, Object paramObject1, Object paramObject2, Object paramObject3, Fragment paramFragment, boolean paramBoolean) {
    if (paramObject1 != null && paramObject2 != null && paramFragment != null) {
      if (paramBoolean) {
        paramBoolean = paramFragment.getAllowReturnTransitionOverlap();
      } else {
        paramBoolean = paramFragment.getAllowEnterTransitionOverlap();
      } 
    } else {
      paramBoolean = true;
    } 
    return paramBoolean ? paramFragmentTransitionImpl.mergeTransitionsTogether(paramObject2, paramObject1, paramObject3) : paramFragmentTransitionImpl.mergeTransitionsInSequence(paramObject2, paramObject1, paramObject3);
  }
  
  private static String a(ArrayMap<String, String> paramArrayMap, String paramString) {
    int j = paramArrayMap.size();
    for (int i = 0; i < j; i++) {
      if (paramString.equals(paramArrayMap.valueAt(i)))
        return (String)paramArrayMap.keyAt(i); 
    } 
    return null;
  }
  
  static ArrayList<View> a(FragmentTransitionImpl paramFragmentTransitionImpl, Object paramObject, Fragment paramFragment, ArrayList<View> paramArrayList, View paramView) {
    if (paramObject != null) {
      ArrayList<View> arrayList2 = new ArrayList();
      View view = paramFragment.getView();
      if (view != null)
        paramFragmentTransitionImpl.a(arrayList2, view); 
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
    return (ArrayList<View>)paramFragment;
  }
  
  private static void a(ArrayMap<String, String> paramArrayMap, ArrayMap<String, View> paramArrayMap1) {
    for (int i = paramArrayMap.size() - 1; i >= 0; i--) {
      if (!paramArrayMap1.containsKey(paramArrayMap.valueAt(i)))
        paramArrayMap.removeAt(i); 
    } 
  }
  
  private static void a(BackStackRecord paramBackStackRecord, FragmentTransaction.Op paramOp, SparseArray<FragmentContainerTransition> paramSparseArray, boolean paramBoolean1, boolean paramBoolean2) {
    // Byte code:
    //   0: aload_1
    //   1: getfield b : Landroidx/fragment/app/Fragment;
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
    //   29: getstatic androidx/fragment/app/FragmentTransition.a : [I
    //   32: aload_1
    //   33: getfield a : I
    //   36: iaload
    //   37: istore #5
    //   39: goto -> 48
    //   42: aload_1
    //   43: getfield a : I
    //   46: istore #5
    //   48: iconst_0
    //   49: istore #10
    //   51: iconst_0
    //   52: istore #9
    //   54: iload #5
    //   56: iconst_1
    //   57: if_icmpeq -> 287
    //   60: iload #5
    //   62: iconst_3
    //   63: if_icmpeq -> 197
    //   66: iload #5
    //   68: iconst_4
    //   69: if_icmpeq -> 146
    //   72: iload #5
    //   74: iconst_5
    //   75: if_icmpeq -> 104
    //   78: iload #5
    //   80: bipush #6
    //   82: if_icmpeq -> 197
    //   85: iload #5
    //   87: bipush #7
    //   89: if_icmpeq -> 287
    //   92: iconst_0
    //   93: istore #5
    //   95: iconst_0
    //   96: istore #7
    //   98: iconst_0
    //   99: istore #6
    //   101: goto -> 333
    //   104: iload #4
    //   106: ifeq -> 136
    //   109: aload #12
    //   111: getfield mHiddenChanged : Z
    //   114: ifeq -> 324
    //   117: aload #12
    //   119: getfield mHidden : Z
    //   122: ifne -> 324
    //   125: aload #12
    //   127: getfield mAdded : Z
    //   130: ifeq -> 324
    //   133: goto -> 318
    //   136: aload #12
    //   138: getfield mHidden : Z
    //   141: istore #9
    //   143: goto -> 327
    //   146: iload #4
    //   148: ifeq -> 178
    //   151: aload #12
    //   153: getfield mHiddenChanged : Z
    //   156: ifeq -> 245
    //   159: aload #12
    //   161: getfield mAdded : Z
    //   164: ifeq -> 245
    //   167: aload #12
    //   169: getfield mHidden : Z
    //   172: ifeq -> 245
    //   175: goto -> 239
    //   178: aload #12
    //   180: getfield mAdded : Z
    //   183: ifeq -> 245
    //   186: aload #12
    //   188: getfield mHidden : Z
    //   191: ifne -> 245
    //   194: goto -> 175
    //   197: iload #4
    //   199: ifeq -> 251
    //   202: aload #12
    //   204: getfield mAdded : Z
    //   207: ifne -> 245
    //   210: aload #12
    //   212: getfield mView : Landroid/view/View;
    //   215: ifnull -> 245
    //   218: aload #12
    //   220: getfield mView : Landroid/view/View;
    //   223: invokevirtual getVisibility : ()I
    //   226: ifne -> 245
    //   229: aload #12
    //   231: getfield mPostponedAlpha : F
    //   234: fconst_0
    //   235: fcmpl
    //   236: iflt -> 245
    //   239: iconst_1
    //   240: istore #5
    //   242: goto -> 270
    //   245: iconst_0
    //   246: istore #5
    //   248: goto -> 270
    //   251: aload #12
    //   253: getfield mAdded : Z
    //   256: ifeq -> 245
    //   259: aload #12
    //   261: getfield mHidden : Z
    //   264: ifne -> 245
    //   267: goto -> 239
    //   270: iload #5
    //   272: istore #6
    //   274: iconst_0
    //   275: istore #5
    //   277: iconst_1
    //   278: istore #7
    //   280: iload #10
    //   282: istore #9
    //   284: goto -> 333
    //   287: iload #4
    //   289: ifeq -> 302
    //   292: aload #12
    //   294: getfield mIsNewlyAdded : Z
    //   297: istore #9
    //   299: goto -> 327
    //   302: aload #12
    //   304: getfield mAdded : Z
    //   307: ifne -> 324
    //   310: aload #12
    //   312: getfield mHidden : Z
    //   315: ifne -> 324
    //   318: iconst_1
    //   319: istore #9
    //   321: goto -> 327
    //   324: iconst_0
    //   325: istore #9
    //   327: iconst_1
    //   328: istore #5
    //   330: goto -> 95
    //   333: aload_2
    //   334: iload #8
    //   336: invokevirtual get : (I)Ljava/lang/Object;
    //   339: checkcast androidx/fragment/app/FragmentTransition$FragmentContainerTransition
    //   342: astore #11
    //   344: aload #11
    //   346: astore_1
    //   347: iload #9
    //   349: ifeq -> 377
    //   352: aload #11
    //   354: aload_2
    //   355: iload #8
    //   357: invokestatic a : (Landroidx/fragment/app/FragmentTransition$FragmentContainerTransition;Landroid/util/SparseArray;I)Landroidx/fragment/app/FragmentTransition$FragmentContainerTransition;
    //   360: astore_1
    //   361: aload_1
    //   362: aload #12
    //   364: putfield lastIn : Landroidx/fragment/app/Fragment;
    //   367: aload_1
    //   368: iload_3
    //   369: putfield lastInIsPop : Z
    //   372: aload_1
    //   373: aload_0
    //   374: putfield lastInTransaction : Landroidx/fragment/app/BackStackRecord;
    //   377: iload #4
    //   379: ifne -> 454
    //   382: iload #5
    //   384: ifeq -> 454
    //   387: aload_1
    //   388: ifnull -> 405
    //   391: aload_1
    //   392: getfield firstOut : Landroidx/fragment/app/Fragment;
    //   395: aload #12
    //   397: if_acmpne -> 405
    //   400: aload_1
    //   401: aconst_null
    //   402: putfield firstOut : Landroidx/fragment/app/Fragment;
    //   405: aload_0
    //   406: getfield a : Landroidx/fragment/app/FragmentManagerImpl;
    //   409: astore #11
    //   411: aload #12
    //   413: getfield mState : I
    //   416: iconst_1
    //   417: if_icmpge -> 454
    //   420: aload #11
    //   422: getfield m : I
    //   425: iconst_1
    //   426: if_icmplt -> 454
    //   429: aload_0
    //   430: getfield t : Z
    //   433: ifne -> 454
    //   436: aload #11
    //   438: aload #12
    //   440: invokevirtual j : (Landroidx/fragment/app/Fragment;)V
    //   443: aload #11
    //   445: aload #12
    //   447: iconst_1
    //   448: iconst_0
    //   449: iconst_0
    //   450: iconst_0
    //   451: invokevirtual a : (Landroidx/fragment/app/Fragment;IIIZ)V
    //   454: aload_1
    //   455: astore #11
    //   457: iload #6
    //   459: ifeq -> 504
    //   462: aload_1
    //   463: ifnull -> 476
    //   466: aload_1
    //   467: astore #11
    //   469: aload_1
    //   470: getfield firstOut : Landroidx/fragment/app/Fragment;
    //   473: ifnonnull -> 504
    //   476: aload_1
    //   477: aload_2
    //   478: iload #8
    //   480: invokestatic a : (Landroidx/fragment/app/FragmentTransition$FragmentContainerTransition;Landroid/util/SparseArray;I)Landroidx/fragment/app/FragmentTransition$FragmentContainerTransition;
    //   483: astore #11
    //   485: aload #11
    //   487: aload #12
    //   489: putfield firstOut : Landroidx/fragment/app/Fragment;
    //   492: aload #11
    //   494: iload_3
    //   495: putfield firstOutIsPop : Z
    //   498: aload #11
    //   500: aload_0
    //   501: putfield firstOutTransaction : Landroidx/fragment/app/BackStackRecord;
    //   504: iload #4
    //   506: ifne -> 535
    //   509: iload #7
    //   511: ifeq -> 535
    //   514: aload #11
    //   516: ifnull -> 535
    //   519: aload #11
    //   521: getfield lastIn : Landroidx/fragment/app/Fragment;
    //   524: aload #12
    //   526: if_acmpne -> 535
    //   529: aload #11
    //   531: aconst_null
    //   532: putfield lastIn : Landroidx/fragment/app/Fragment;
    //   535: return
  }
  
  static void a(Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean1, ArrayMap<String, View> paramArrayMap, boolean paramBoolean2) {
    SharedElementCallback sharedElementCallback;
    if (paramBoolean1) {
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
      if (paramBoolean2) {
        sharedElementCallback.onSharedElementStart(arrayList2, arrayList1, null);
        return;
      } 
      sharedElementCallback.onSharedElementEnd(arrayList2, arrayList1, null);
    } 
  }
  
  private static void a(FragmentManagerImpl paramFragmentManagerImpl, int paramInt, FragmentContainerTransition paramFragmentContainerTransition, View paramView, ArrayMap<String, String> paramArrayMap) {
    if (paramFragmentManagerImpl.o.onHasView()) {
      ViewGroup viewGroup = (ViewGroup)paramFragmentManagerImpl.o.onFindViewById(paramInt);
    } else {
      paramFragmentManagerImpl = null;
    } 
    if (paramFragmentManagerImpl == null)
      return; 
    Fragment fragment2 = paramFragmentContainerTransition.lastIn;
    Fragment fragment1 = paramFragmentContainerTransition.firstOut;
    FragmentTransitionImpl fragmentTransitionImpl = a(fragment1, fragment2);
    if (fragmentTransitionImpl == null)
      return; 
    boolean bool1 = paramFragmentContainerTransition.lastInIsPop;
    boolean bool2 = paramFragmentContainerTransition.firstOutIsPop;
    ArrayList<View> arrayList2 = new ArrayList();
    ArrayList<View> arrayList3 = new ArrayList();
    Object object3 = a(fragmentTransitionImpl, fragment2, bool1);
    Object<View> object2 = (Object<View>)b(fragmentTransitionImpl, fragment1, bool2);
    Object object4 = a(fragmentTransitionImpl, (ViewGroup)paramFragmentManagerImpl, paramView, paramArrayMap, paramFragmentContainerTransition, arrayList3, arrayList2, object3, object2);
    if (object3 == null && object4 == null && object2 == null)
      return; 
    Object<View> object1 = object2;
    object2 = (Object<View>)a(fragmentTransitionImpl, object1, fragment1, arrayList3, paramView);
    ArrayList<View> arrayList1 = a(fragmentTransitionImpl, object3, fragment2, arrayList2, paramView);
    a(arrayList1, 4);
    Object object5 = a(fragmentTransitionImpl, object3, object1, object4, fragment2, bool1);
    if (object5 != null) {
      a(fragmentTransitionImpl, object1, fragment1, (ArrayList<View>)object2);
      ArrayList<String> arrayList = fragmentTransitionImpl.a(arrayList2);
      fragmentTransitionImpl.scheduleRemoveTargets(object5, object3, arrayList1, object1, (ArrayList<View>)object2, object4, arrayList2);
      fragmentTransitionImpl.beginDelayedTransition((ViewGroup)paramFragmentManagerImpl, object5);
      fragmentTransitionImpl.a((View)paramFragmentManagerImpl, arrayList3, arrayList2, arrayList, (Map<String, String>)paramArrayMap);
      a(arrayList1, 0);
      fragmentTransitionImpl.swapSharedElementTargets(object4, arrayList3, arrayList2);
    } 
  }
  
  static void a(FragmentManagerImpl paramFragmentManagerImpl, ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2, boolean paramBoolean) {
    if (paramFragmentManagerImpl.m < 1)
      return; 
    SparseArray<FragmentContainerTransition> sparseArray = new SparseArray();
    int i;
    for (i = paramInt1; i < paramInt2; i++) {
      BackStackRecord backStackRecord = paramArrayList.get(i);
      if (((Boolean)paramArrayList1.get(i)).booleanValue()) {
        calculatePopFragments(backStackRecord, sparseArray, paramBoolean);
      } else {
        calculateFragments(backStackRecord, sparseArray, paramBoolean);
      } 
    } 
    if (sparseArray.size() != 0) {
      View view = new View(paramFragmentManagerImpl.n.b());
      int j = sparseArray.size();
      for (i = 0; i < j; i++) {
        int k = sparseArray.keyAt(i);
        ArrayMap<String, String> arrayMap = a(k, paramArrayList, paramArrayList1, paramInt1, paramInt2);
        FragmentContainerTransition fragmentContainerTransition = (FragmentContainerTransition)sparseArray.valueAt(i);
        if (paramBoolean) {
          a(paramFragmentManagerImpl, k, fragmentContainerTransition, view, arrayMap);
        } else {
          b(paramFragmentManagerImpl, k, fragmentContainerTransition, view, arrayMap);
        } 
      } 
    } 
  }
  
  private static void a(FragmentTransitionImpl paramFragmentTransitionImpl, ViewGroup paramViewGroup, Fragment paramFragment, View paramView, ArrayList<View> paramArrayList1, Object paramObject1, ArrayList<View> paramArrayList2, Object paramObject2, ArrayList<View> paramArrayList3) {
    OneShotPreDrawListener.add((View)paramViewGroup, new Runnable(paramObject1, paramFragmentTransitionImpl, paramView, paramFragment, paramArrayList1, paramArrayList2, paramArrayList3, paramObject2) {
          public void run() {
            Object<View> object = (Object<View>)this.a;
            if (object != null) {
              this.b.removeTarget(object, this.c);
              object = (Object<View>)FragmentTransition.a(this.b, this.a, this.d, this.e, this.c);
              this.f.addAll((Collection<? extends View>)object);
            } 
            if (this.g != null) {
              if (this.h != null) {
                object = (Object<View>)new ArrayList();
                object.add(this.c);
                this.b.replaceTargets(this.h, this.g, (ArrayList<View>)object);
              } 
              this.g.clear();
              this.g.add(this.c);
            } 
          }
        });
  }
  
  private static void a(FragmentTransitionImpl paramFragmentTransitionImpl, Object paramObject, Fragment paramFragment, ArrayList<View> paramArrayList) {
    if (paramFragment != null && paramObject != null && paramFragment.mAdded && paramFragment.mHidden && paramFragment.mHiddenChanged) {
      paramFragment.setHideReplaced(true);
      paramFragmentTransitionImpl.scheduleHideFragmentView(paramObject, paramFragment.getView(), paramArrayList);
      OneShotPreDrawListener.add((View)paramFragment.mContainer, new Runnable(paramArrayList) {
            public void run() {
              FragmentTransition.a(this.a, 4);
            }
          });
    } 
  }
  
  private static void a(FragmentTransitionImpl paramFragmentTransitionImpl, Object paramObject1, Object paramObject2, ArrayMap<String, View> paramArrayMap, boolean paramBoolean, BackStackRecord paramBackStackRecord) {
    if (paramBackStackRecord.r != null && !paramBackStackRecord.r.isEmpty()) {
      String str;
      if (paramBoolean) {
        str = paramBackStackRecord.s.get(0);
      } else {
        str = ((BackStackRecord)str).r.get(0);
      } 
      View view = (View)paramArrayMap.get(str);
      paramFragmentTransitionImpl.setEpicenter(paramObject1, view);
      if (paramObject2 != null)
        paramFragmentTransitionImpl.setEpicenter(paramObject2, view); 
    } 
  }
  
  static void a(ArrayList<View> paramArrayList, int paramInt) {
    if (paramArrayList == null)
      return; 
    for (int i = paramArrayList.size() - 1; i >= 0; i--)
      ((View)paramArrayList.get(i)).setVisibility(paramInt); 
  }
  
  private static void a(ArrayList<View> paramArrayList, ArrayMap<String, View> paramArrayMap, Collection<String> paramCollection) {
    for (int i = paramArrayMap.size() - 1; i >= 0; i--) {
      View view = (View)paramArrayMap.valueAt(i);
      if (paramCollection.contains(ViewCompat.getTransitionName(view)))
        paramArrayList.add(view); 
    } 
  }
  
  static boolean a() {
    return (b != null || c != null);
  }
  
  private static boolean a(FragmentTransitionImpl paramFragmentTransitionImpl, List<Object> paramList) {
    int j = paramList.size();
    for (int i = 0; i < j; i++) {
      if (!paramFragmentTransitionImpl.canHandle(paramList.get(i)))
        return false; 
    } 
    return true;
  }
  
  private static ArrayMap<String, View> b(FragmentTransitionImpl paramFragmentTransitionImpl, ArrayMap<String, String> paramArrayMap, Object paramObject, FragmentContainerTransition paramFragmentContainerTransition) {
    ArrayList<String> arrayList;
    if (paramArrayMap.isEmpty() || paramObject == null) {
      paramArrayMap.clear();
      return null;
    } 
    paramObject = paramFragmentContainerTransition.firstOut;
    ArrayMap<String, View> arrayMap = new ArrayMap();
    paramFragmentTransitionImpl.a((Map<String, View>)arrayMap, paramObject.requireView());
    BackStackRecord backStackRecord = paramFragmentContainerTransition.firstOutTransaction;
    if (paramFragmentContainerTransition.firstOutIsPop) {
      paramObject = paramObject.getEnterTransitionCallback();
      arrayList = backStackRecord.s;
    } else {
      paramObject = paramObject.getExitTransitionCallback();
      arrayList = ((BackStackRecord)arrayList).r;
    } 
    arrayMap.retainAll(arrayList);
    if (paramObject != null) {
      paramObject.onMapSharedElements(arrayList, (Map)arrayMap);
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
      paramArrayMap.retainAll(arrayMap.keySet());
    } 
    return arrayMap;
  }
  
  private static FragmentTransitionImpl b() {
    try {
      return Class.forName("androidx.transition.FragmentTransitionSupport").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    } catch (Exception exception) {
      return null;
    } 
  }
  
  private static Object b(FragmentTransitionImpl paramFragmentTransitionImpl, ViewGroup paramViewGroup, View paramView, ArrayMap<String, String> paramArrayMap, FragmentContainerTransition paramFragmentContainerTransition, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2, Object paramObject1, Object paramObject2) {
    Fragment fragment1 = paramFragmentContainerTransition.lastIn;
    Fragment fragment2 = paramFragmentContainerTransition.firstOut;
    if (fragment1 != null) {
      Object object;
      if (fragment2 == null)
        return null; 
      boolean bool = paramFragmentContainerTransition.lastInIsPop;
      if (paramArrayMap.isEmpty()) {
        object = null;
      } else {
        object = a(paramFragmentTransitionImpl, fragment1, fragment2, bool);
      } 
      ArrayMap<String, View> arrayMap = b(paramFragmentTransitionImpl, paramArrayMap, object, paramFragmentContainerTransition);
      if (paramArrayMap.isEmpty()) {
        object = null;
      } else {
        paramArrayList1.addAll(arrayMap.values());
      } 
      if (paramObject1 == null && paramObject2 == null && object == null)
        return null; 
      a(fragment1, fragment2, bool, arrayMap, true);
      if (object != null) {
        Rect rect = new Rect();
        paramFragmentTransitionImpl.setSharedElementTargets(object, paramView, paramArrayList1);
        a(paramFragmentTransitionImpl, object, paramObject2, arrayMap, paramFragmentContainerTransition.firstOutIsPop, paramFragmentContainerTransition.firstOutTransaction);
        paramObject2 = rect;
        if (paramObject1 != null) {
          paramFragmentTransitionImpl.setEpicenter(paramObject1, rect);
          paramObject2 = rect;
        } 
      } else {
        paramObject2 = null;
      } 
      OneShotPreDrawListener.add((View)paramViewGroup, new Runnable(paramFragmentTransitionImpl, paramArrayMap, object, paramFragmentContainerTransition, paramArrayList2, paramView, fragment1, fragment2, bool, paramArrayList1, paramObject1, (Rect)paramObject2) {
            public void run() {
              ArrayMap<String, View> arrayMap = FragmentTransition.a(this.a, this.b, this.c, this.d);
              if (arrayMap != null) {
                this.e.addAll(arrayMap.values());
                this.e.add(this.f);
              } 
              FragmentTransition.a(this.g, this.h, this.i, arrayMap, false);
              Object object = this.c;
              if (object != null) {
                this.a.swapSharedElementTargets(object, this.j, this.e);
                View view = FragmentTransition.a(arrayMap, this.d, this.k, this.i);
                if (view != null)
                  this.a.a(view, this.l); 
              } 
            }
          });
      return object;
    } 
    return null;
  }
  
  private static Object b(FragmentTransitionImpl paramFragmentTransitionImpl, Fragment paramFragment, boolean paramBoolean) {
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
  
  private static void b(FragmentManagerImpl paramFragmentManagerImpl, int paramInt, FragmentContainerTransition paramFragmentContainerTransition, View paramView, ArrayMap<String, String> paramArrayMap) {
    if (paramFragmentManagerImpl.o.onHasView()) {
      ViewGroup viewGroup = (ViewGroup)paramFragmentManagerImpl.o.onFindViewById(paramInt);
    } else {
      paramFragmentManagerImpl = null;
    } 
    if (paramFragmentManagerImpl == null)
      return; 
    Fragment fragment1 = paramFragmentContainerTransition.lastIn;
    Fragment fragment2 = paramFragmentContainerTransition.firstOut;
    FragmentTransitionImpl fragmentTransitionImpl = a(fragment2, fragment1);
    if (fragmentTransitionImpl == null)
      return; 
    boolean bool1 = paramFragmentContainerTransition.lastInIsPop;
    boolean bool2 = paramFragmentContainerTransition.firstOutIsPop;
    Object object3 = a(fragmentTransitionImpl, fragment1, bool1);
    Object object2 = b(fragmentTransitionImpl, fragment2, bool2);
    ArrayList<View> arrayList3 = new ArrayList();
    ArrayList<View> arrayList1 = new ArrayList();
    Object object4 = b(fragmentTransitionImpl, (ViewGroup)paramFragmentManagerImpl, paramView, paramArrayMap, paramFragmentContainerTransition, arrayList3, arrayList1, object3, object2);
    if (object3 == null && object4 == null && object2 == null)
      return; 
    ArrayList<View> arrayList2 = a(fragmentTransitionImpl, object2, fragment2, arrayList3, paramView);
    if (arrayList2 == null || arrayList2.isEmpty())
      object2 = null; 
    fragmentTransitionImpl.addTarget(object3, paramView);
    Object object1 = a(fragmentTransitionImpl, object3, object2, object4, fragment1, paramFragmentContainerTransition.lastInIsPop);
    if (object1 != null) {
      arrayList3 = new ArrayList<View>();
      fragmentTransitionImpl.scheduleRemoveTargets(object1, object3, arrayList3, object2, arrayList2, object4, arrayList1);
      a(fragmentTransitionImpl, (ViewGroup)paramFragmentManagerImpl, fragment1, paramView, arrayList1, object3, arrayList3, object2, arrayList2);
      fragmentTransitionImpl.a((View)paramFragmentManagerImpl, arrayList1, (Map<String, String>)paramArrayMap);
      fragmentTransitionImpl.beginDelayedTransition((ViewGroup)paramFragmentManagerImpl, object1);
      fragmentTransitionImpl.a((ViewGroup)paramFragmentManagerImpl, arrayList1, (Map<String, String>)paramArrayMap);
    } 
  }
  
  public static void calculateFragments(BackStackRecord paramBackStackRecord, SparseArray<FragmentContainerTransition> paramSparseArray, boolean paramBoolean) {
    int j = paramBackStackRecord.d.size();
    for (int i = 0; i < j; i++)
      a(paramBackStackRecord, paramBackStackRecord.d.get(i), paramSparseArray, false, paramBoolean); 
  }
  
  public static void calculatePopFragments(BackStackRecord paramBackStackRecord, SparseArray<FragmentContainerTransition> paramSparseArray, boolean paramBoolean) {
    if (!paramBackStackRecord.a.o.onHasView())
      return; 
    for (int i = paramBackStackRecord.d.size() - 1; i >= 0; i--)
      a(paramBackStackRecord, paramBackStackRecord.d.get(i), paramSparseArray, true, paramBoolean); 
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
    b = fragmentTransitionImpl;
  }
  
  static class FragmentContainerTransition {
    public Fragment firstOut;
    
    public boolean firstOutIsPop;
    
    public BackStackRecord firstOutTransaction;
    
    public Fragment lastIn;
    
    public boolean lastInIsPop;
    
    public BackStackRecord lastInTransaction;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\fragment\app\FragmentTransition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */