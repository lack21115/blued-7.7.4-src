package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import org.xmlpull.v1.XmlPullParser;

public abstract class Transition implements Cloneable {
  private static ThreadLocal<ArrayMap<Animator, AnimationInfo>> A;
  
  public static final int MATCH_ID = 3;
  
  public static final int MATCH_INSTANCE = 1;
  
  public static final int MATCH_ITEM_ID = 4;
  
  public static final int MATCH_NAME = 2;
  
  private static final int[] a = new int[] { 2, 1, 3, 4 };
  
  private static final PathMotion i = new PathMotion() {
      public Path getPath(float param1Float1, float param1Float2, float param1Float3, float param1Float4) {
        Path path = new Path();
        path.moveTo(param1Float1, param1Float2);
        path.lineTo(param1Float3, param1Float4);
        return path;
      }
    };
  
  private ViewGroup B = null;
  
  private int C = 0;
  
  private boolean D = false;
  
  private boolean E = false;
  
  private ArrayList<TransitionListener> F = null;
  
  private ArrayList<Animator> G = new ArrayList<Animator>();
  
  private EpicenterCallback H;
  
  private ArrayMap<String, String> I;
  
  private PathMotion J = i;
  
  long b = -1L;
  
  ArrayList<Integer> c = new ArrayList<Integer>();
  
  ArrayList<View> d = new ArrayList<View>();
  
  TransitionSet e = null;
  
  boolean f = false;
  
  ArrayList<Animator> g = new ArrayList<Animator>();
  
  TransitionPropagation h;
  
  private String j = getClass().getName();
  
  private long k = -1L;
  
  private TimeInterpolator l = null;
  
  private ArrayList<String> m = null;
  
  private ArrayList<Class<?>> n = null;
  
  private ArrayList<Integer> o = null;
  
  private ArrayList<View> p = null;
  
  private ArrayList<Class<?>> q = null;
  
  private ArrayList<String> r = null;
  
  private ArrayList<Integer> s = null;
  
  private ArrayList<View> t = null;
  
  private ArrayList<Class<?>> u = null;
  
  private TransitionValuesMaps v = new TransitionValuesMaps();
  
  private TransitionValuesMaps w = new TransitionValuesMaps();
  
  private int[] x = a;
  
  private ArrayList<TransitionValues> y;
  
  private ArrayList<TransitionValues> z;
  
  static {
    A = new ThreadLocal<ArrayMap<Animator, AnimationInfo>>();
  }
  
  public Transition() {}
  
  public Transition(Context paramContext, AttributeSet paramAttributeSet) {
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, Styleable.c);
    XmlResourceParser xmlResourceParser = (XmlResourceParser)paramAttributeSet;
    long l = TypedArrayUtils.getNamedInt(typedArray, (XmlPullParser)xmlResourceParser, "duration", 1, -1);
    if (l >= 0L)
      setDuration(l); 
    l = TypedArrayUtils.getNamedInt(typedArray, (XmlPullParser)xmlResourceParser, "startDelay", 2, -1);
    if (l > 0L)
      setStartDelay(l); 
    int i = TypedArrayUtils.getNamedResourceId(typedArray, (XmlPullParser)xmlResourceParser, "interpolator", 0, 0);
    if (i > 0)
      setInterpolator((TimeInterpolator)AnimationUtils.loadInterpolator(paramContext, i)); 
    String str = TypedArrayUtils.getNamedString(typedArray, (XmlPullParser)xmlResourceParser, "matchOrder", 3);
    if (str != null)
      setMatchOrder(b(str)); 
    typedArray.recycle();
  }
  
  private ArrayList<Integer> a(ArrayList<Integer> paramArrayList, int paramInt, boolean paramBoolean) {
    ArrayList<Integer> arrayList = paramArrayList;
    if (paramInt > 0) {
      if (paramBoolean)
        return ArrayListManager.a(paramArrayList, Integer.valueOf(paramInt)); 
      arrayList = ArrayListManager.b(paramArrayList, Integer.valueOf(paramInt));
    } 
    return arrayList;
  }
  
  private ArrayList<View> a(ArrayList<View> paramArrayList, View paramView, boolean paramBoolean) {
    ArrayList<View> arrayList = paramArrayList;
    if (paramView != null) {
      if (paramBoolean)
        return ArrayListManager.a(paramArrayList, paramView); 
      arrayList = ArrayListManager.b(paramArrayList, paramView);
    } 
    return arrayList;
  }
  
  private ArrayList<Class<?>> a(ArrayList<Class<?>> paramArrayList, Class<?> paramClass, boolean paramBoolean) {
    ArrayList<Class<?>> arrayList = paramArrayList;
    if (paramClass != null) {
      if (paramBoolean)
        return ArrayListManager.a(paramArrayList, paramClass); 
      arrayList = ArrayListManager.b(paramArrayList, paramClass);
    } 
    return arrayList;
  }
  
  private static <T> ArrayList<T> a(ArrayList<T> paramArrayList, T paramT, boolean paramBoolean) {
    ArrayList<T> arrayList = paramArrayList;
    if (paramT != null) {
      if (paramBoolean)
        return ArrayListManager.a(paramArrayList, paramT); 
      arrayList = ArrayListManager.b(paramArrayList, paramT);
    } 
    return arrayList;
  }
  
  private void a(Animator paramAnimator, ArrayMap<Animator, AnimationInfo> paramArrayMap) {
    if (paramAnimator != null) {
      paramAnimator.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this, paramArrayMap) {
            public void onAnimationEnd(Animator param1Animator) {
              this.a.remove(param1Animator);
              this.b.g.remove(param1Animator);
            }
            
            public void onAnimationStart(Animator param1Animator) {
              this.b.g.add(param1Animator);
            }
          });
      a(paramAnimator);
    } 
  }
  
  private void a(ArrayMap<View, TransitionValues> paramArrayMap1, ArrayMap<View, TransitionValues> paramArrayMap2) {
    for (int i = paramArrayMap1.size() - 1; i >= 0; i--) {
      View view = (View)paramArrayMap1.keyAt(i);
      if (view != null && b(view)) {
        TransitionValues transitionValues = (TransitionValues)paramArrayMap2.remove(view);
        if (transitionValues != null && b(transitionValues.view)) {
          TransitionValues transitionValues1 = (TransitionValues)paramArrayMap1.removeAt(i);
          this.y.add(transitionValues1);
          this.z.add(transitionValues);
        } 
      } 
    } 
  }
  
  private void a(ArrayMap<View, TransitionValues> paramArrayMap1, ArrayMap<View, TransitionValues> paramArrayMap2, SparseArray<View> paramSparseArray1, SparseArray<View> paramSparseArray2) {
    int j = paramSparseArray1.size();
    int i;
    for (i = 0; i < j; i++) {
      View view = (View)paramSparseArray1.valueAt(i);
      if (view != null && b(view)) {
        View view1 = (View)paramSparseArray2.get(paramSparseArray1.keyAt(i));
        if (view1 != null && b(view1)) {
          TransitionValues transitionValues1 = (TransitionValues)paramArrayMap1.get(view);
          TransitionValues transitionValues2 = (TransitionValues)paramArrayMap2.get(view1);
          if (transitionValues1 != null && transitionValues2 != null) {
            this.y.add(transitionValues1);
            this.z.add(transitionValues2);
            paramArrayMap1.remove(view);
            paramArrayMap2.remove(view1);
          } 
        } 
      } 
    } 
  }
  
  private void a(ArrayMap<View, TransitionValues> paramArrayMap1, ArrayMap<View, TransitionValues> paramArrayMap2, ArrayMap<String, View> paramArrayMap3, ArrayMap<String, View> paramArrayMap4) {
    int j = paramArrayMap3.size();
    int i;
    for (i = 0; i < j; i++) {
      View view = (View)paramArrayMap3.valueAt(i);
      if (view != null && b(view)) {
        View view1 = (View)paramArrayMap4.get(paramArrayMap3.keyAt(i));
        if (view1 != null && b(view1)) {
          TransitionValues transitionValues1 = (TransitionValues)paramArrayMap1.get(view);
          TransitionValues transitionValues2 = (TransitionValues)paramArrayMap2.get(view1);
          if (transitionValues1 != null && transitionValues2 != null) {
            this.y.add(transitionValues1);
            this.z.add(transitionValues2);
            paramArrayMap1.remove(view);
            paramArrayMap2.remove(view1);
          } 
        } 
      } 
    } 
  }
  
  private void a(ArrayMap<View, TransitionValues> paramArrayMap1, ArrayMap<View, TransitionValues> paramArrayMap2, LongSparseArray<View> paramLongSparseArray1, LongSparseArray<View> paramLongSparseArray2) {
    int j = paramLongSparseArray1.size();
    int i;
    for (i = 0; i < j; i++) {
      View view = (View)paramLongSparseArray1.valueAt(i);
      if (view != null && b(view)) {
        View view1 = (View)paramLongSparseArray2.get(paramLongSparseArray1.keyAt(i));
        if (view1 != null && b(view1)) {
          TransitionValues transitionValues1 = (TransitionValues)paramArrayMap1.get(view);
          TransitionValues transitionValues2 = (TransitionValues)paramArrayMap2.get(view1);
          if (transitionValues1 != null && transitionValues2 != null) {
            this.y.add(transitionValues1);
            this.z.add(transitionValues2);
            paramArrayMap1.remove(view);
            paramArrayMap2.remove(view1);
          } 
        } 
      } 
    } 
  }
  
  private static void a(TransitionValuesMaps paramTransitionValuesMaps, View paramView, TransitionValues paramTransitionValues) {
    paramTransitionValuesMaps.a.put(paramView, paramTransitionValues);
    int i = paramView.getId();
    if (i >= 0)
      if (paramTransitionValuesMaps.b.indexOfKey(i) >= 0) {
        paramTransitionValuesMaps.b.put(i, null);
      } else {
        paramTransitionValuesMaps.b.put(i, paramView);
      }  
    String str = ViewCompat.getTransitionName(paramView);
    if (str != null)
      if (paramTransitionValuesMaps.d.containsKey(str)) {
        paramTransitionValuesMaps.d.put(str, null);
      } else {
        paramTransitionValuesMaps.d.put(str, paramView);
      }  
    if (paramView.getParent() instanceof ListView) {
      ListView listView = (ListView)paramView.getParent();
      if (listView.getAdapter().hasStableIds()) {
        long l = listView.getItemIdAtPosition(listView.getPositionForView(paramView));
        if (paramTransitionValuesMaps.c.indexOfKey(l) >= 0) {
          paramView = (View)paramTransitionValuesMaps.c.get(l);
          if (paramView != null) {
            ViewCompat.setHasTransientState(paramView, false);
            paramTransitionValuesMaps.c.put(l, null);
            return;
          } 
        } else {
          ViewCompat.setHasTransientState(paramView, true);
          paramTransitionValuesMaps.c.put(l, paramView);
        } 
      } 
    } 
  }
  
  private void a(TransitionValuesMaps paramTransitionValuesMaps1, TransitionValuesMaps paramTransitionValuesMaps2) {
    ArrayMap<View, TransitionValues> arrayMap1 = new ArrayMap((SimpleArrayMap)paramTransitionValuesMaps1.a);
    ArrayMap<View, TransitionValues> arrayMap2 = new ArrayMap((SimpleArrayMap)paramTransitionValuesMaps2.a);
    int i = 0;
    while (true) {
      int[] arrayOfInt = this.x;
      if (i < arrayOfInt.length) {
        int j = arrayOfInt[i];
        if (j != 1) {
          if (j != 2) {
            if (j != 3) {
              if (j == 4)
                a(arrayMap1, arrayMap2, paramTransitionValuesMaps1.c, paramTransitionValuesMaps2.c); 
            } else {
              a(arrayMap1, arrayMap2, paramTransitionValuesMaps1.b, paramTransitionValuesMaps2.b);
            } 
          } else {
            a(arrayMap1, arrayMap2, paramTransitionValuesMaps1.d, paramTransitionValuesMaps2.d);
          } 
        } else {
          a(arrayMap1, arrayMap2);
        } 
        i++;
        continue;
      } 
      b(arrayMap1, arrayMap2);
      return;
    } 
  }
  
  private static boolean a(int paramInt) {
    return (paramInt >= 1 && paramInt <= 4);
  }
  
  private static boolean a(TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2, String paramString) {
    paramTransitionValues1 = (TransitionValues)paramTransitionValues1.values.get(paramString);
    paramTransitionValues2 = (TransitionValues)paramTransitionValues2.values.get(paramString);
    int i = 1;
    if (paramTransitionValues1 == null && paramTransitionValues2 == null)
      return false; 
    if (paramTransitionValues1 != null) {
      if (paramTransitionValues2 == null)
        return true; 
      i = true ^ paramTransitionValues1.equals(paramTransitionValues2);
    } 
    return i;
  }
  
  private static boolean a(int[] paramArrayOfint, int paramInt) {
    int j = paramArrayOfint[paramInt];
    for (int i = 0; i < paramInt; i++) {
      if (paramArrayOfint[i] == j)
        return true; 
    } 
    return false;
  }
  
  private void b(View paramView, boolean paramBoolean) {
    if (paramView == null)
      return; 
    int i = paramView.getId();
    ArrayList<Integer> arrayList2 = this.o;
    if (arrayList2 != null && arrayList2.contains(Integer.valueOf(i)))
      return; 
    ArrayList<View> arrayList1 = this.p;
    if (arrayList1 != null && arrayList1.contains(paramView))
      return; 
    ArrayList<Class<?>> arrayList = this.q;
    byte b = 0;
    if (arrayList != null) {
      int k = arrayList.size();
      for (int j = 0; j < k; j++) {
        if (((Class)this.q.get(j)).isInstance(paramView))
          return; 
      } 
    } 
    if (paramView.getParent() instanceof ViewGroup) {
      TransitionValues transitionValues = new TransitionValues(paramView);
      if (paramBoolean) {
        captureStartValues(transitionValues);
      } else {
        captureEndValues(transitionValues);
      } 
      transitionValues.a.add(this);
      a(transitionValues);
      if (paramBoolean) {
        a(this.v, paramView, transitionValues);
      } else {
        a(this.w, paramView, transitionValues);
      } 
    } 
    if (paramView instanceof ViewGroup) {
      ArrayList<Integer> arrayList5 = this.s;
      if (arrayList5 != null && arrayList5.contains(Integer.valueOf(i)))
        return; 
      ArrayList<View> arrayList4 = this.t;
      if (arrayList4 != null && arrayList4.contains(paramView))
        return; 
      ArrayList<Class<?>> arrayList3 = this.u;
      if (arrayList3 != null) {
        i = arrayList3.size();
        for (int k = 0; k < i; k++) {
          if (((Class)this.u.get(k)).isInstance(paramView))
            return; 
        } 
      } 
      ViewGroup viewGroup = (ViewGroup)paramView;
      for (int j = b; j < viewGroup.getChildCount(); j++)
        b(viewGroup.getChildAt(j), paramBoolean); 
    } 
  }
  
  private void b(ArrayMap<View, TransitionValues> paramArrayMap1, ArrayMap<View, TransitionValues> paramArrayMap2) {
    int j;
    byte b = 0;
    int i = 0;
    while (true) {
      j = b;
      if (i < paramArrayMap1.size()) {
        TransitionValues transitionValues = (TransitionValues)paramArrayMap1.valueAt(i);
        if (b(transitionValues.view)) {
          this.y.add(transitionValues);
          this.z.add(null);
        } 
        i++;
        continue;
      } 
      break;
    } 
    while (j < paramArrayMap2.size()) {
      TransitionValues transitionValues = (TransitionValues)paramArrayMap2.valueAt(j);
      if (b(transitionValues.view)) {
        this.z.add(transitionValues);
        this.y.add(null);
      } 
      j++;
    } 
  }
  
  private static int[] b(String paramString) {
    StringBuilder stringBuilder;
    StringTokenizer stringTokenizer = new StringTokenizer(paramString, ",");
    int[] arrayOfInt = new int[stringTokenizer.countTokens()];
    for (int i = 0; stringTokenizer.hasMoreTokens(); i++) {
      String str = stringTokenizer.nextToken().trim();
      if ("id".equalsIgnoreCase(str)) {
        arrayOfInt[i] = 3;
      } else if ("instance".equalsIgnoreCase(str)) {
        arrayOfInt[i] = 1;
      } else if ("name".equalsIgnoreCase(str)) {
        arrayOfInt[i] = 2;
      } else if ("itemId".equalsIgnoreCase(str)) {
        arrayOfInt[i] = 4;
      } else {
        int[] arrayOfInt1;
        if (str.isEmpty()) {
          arrayOfInt1 = new int[arrayOfInt.length - 1];
          System.arraycopy(arrayOfInt, 0, arrayOfInt1, 0, i);
          i--;
          arrayOfInt = arrayOfInt1;
        } else {
          stringBuilder = new StringBuilder();
          stringBuilder.append("Unknown match type in matchOrder: '");
          stringBuilder.append((String)arrayOfInt1);
          stringBuilder.append("'");
          throw new InflateException(stringBuilder.toString());
        } 
      } 
    } 
    return (int[])stringBuilder;
  }
  
  private static ArrayMap<Animator, AnimationInfo> e() {
    ArrayMap<Animator, AnimationInfo> arrayMap2 = A.get();
    ArrayMap<Animator, AnimationInfo> arrayMap1 = arrayMap2;
    if (arrayMap2 == null) {
      arrayMap1 = new ArrayMap();
      A.set(arrayMap1);
    } 
    return arrayMap1;
  }
  
  TransitionValues a(View paramView, boolean paramBoolean) {
    TransitionValues transitionValues;
    int j;
    ArrayList<TransitionValues> arrayList;
    TransitionSet transitionSet = this.e;
    if (transitionSet != null)
      return transitionSet.a(paramView, paramBoolean); 
    if (paramBoolean) {
      arrayList = this.y;
    } else {
      arrayList = this.z;
    } 
    View view = null;
    if (arrayList == null)
      return null; 
    int k = arrayList.size();
    byte b = -1;
    int i = 0;
    while (true) {
      j = b;
      if (i < k) {
        TransitionValues transitionValues1 = arrayList.get(i);
        if (transitionValues1 == null)
          return null; 
        if (transitionValues1.view == paramView) {
          j = i;
          break;
        } 
        i++;
        continue;
      } 
      break;
    } 
    paramView = view;
    if (j >= 0) {
      ArrayList<TransitionValues> arrayList1;
      if (paramBoolean) {
        arrayList1 = this.z;
      } else {
        arrayList1 = this.y;
      } 
      transitionValues = arrayList1.get(j);
    } 
    return transitionValues;
  }
  
  String a(String paramString) {
    // Byte code:
    //   0: new java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #4
    //   9: aload #4
    //   11: aload_1
    //   12: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: pop
    //   16: aload #4
    //   18: aload_0
    //   19: invokevirtual getClass : ()Ljava/lang/Class;
    //   22: invokevirtual getSimpleName : ()Ljava/lang/String;
    //   25: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload #4
    //   31: ldc_w '@'
    //   34: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload #4
    //   40: aload_0
    //   41: invokevirtual hashCode : ()I
    //   44: invokestatic toHexString : (I)Ljava/lang/String;
    //   47: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload #4
    //   53: ldc_w ': '
    //   56: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload #4
    //   62: invokevirtual toString : ()Ljava/lang/String;
    //   65: astore #4
    //   67: aload #4
    //   69: astore_1
    //   70: aload_0
    //   71: getfield b : J
    //   74: ldc2_w -1
    //   77: lcmp
    //   78: ifeq -> 126
    //   81: new java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial <init> : ()V
    //   88: astore_1
    //   89: aload_1
    //   90: aload #4
    //   92: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload_1
    //   97: ldc_w 'dur('
    //   100: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload_1
    //   105: aload_0
    //   106: getfield b : J
    //   109: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload_1
    //   114: ldc_w ') '
    //   117: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload_1
    //   122: invokevirtual toString : ()Ljava/lang/String;
    //   125: astore_1
    //   126: aload_1
    //   127: astore #4
    //   129: aload_0
    //   130: getfield k : J
    //   133: ldc2_w -1
    //   136: lcmp
    //   137: ifeq -> 191
    //   140: new java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial <init> : ()V
    //   147: astore #4
    //   149: aload #4
    //   151: aload_1
    //   152: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload #4
    //   158: ldc_w 'dly('
    //   161: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload #4
    //   167: aload_0
    //   168: getfield k : J
    //   171: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload #4
    //   177: ldc_w ') '
    //   180: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload #4
    //   186: invokevirtual toString : ()Ljava/lang/String;
    //   189: astore #4
    //   191: aload #4
    //   193: astore_1
    //   194: aload_0
    //   195: getfield l : Landroid/animation/TimeInterpolator;
    //   198: ifnull -> 246
    //   201: new java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial <init> : ()V
    //   208: astore_1
    //   209: aload_1
    //   210: aload #4
    //   212: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload_1
    //   217: ldc_w 'interp('
    //   220: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload_1
    //   225: aload_0
    //   226: getfield l : Landroid/animation/TimeInterpolator;
    //   229: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload_1
    //   234: ldc_w ') '
    //   237: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: pop
    //   241: aload_1
    //   242: invokevirtual toString : ()Ljava/lang/String;
    //   245: astore_1
    //   246: aload_0
    //   247: getfield c : Ljava/util/ArrayList;
    //   250: invokevirtual size : ()I
    //   253: ifgt -> 269
    //   256: aload_1
    //   257: astore #4
    //   259: aload_0
    //   260: getfield d : Ljava/util/ArrayList;
    //   263: invokevirtual size : ()I
    //   266: ifle -> 550
    //   269: new java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial <init> : ()V
    //   276: astore #4
    //   278: aload #4
    //   280: aload_1
    //   281: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: aload #4
    //   287: ldc_w 'tgts('
    //   290: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload #4
    //   296: invokevirtual toString : ()Ljava/lang/String;
    //   299: astore #4
    //   301: aload_0
    //   302: getfield c : Ljava/util/ArrayList;
    //   305: invokevirtual size : ()I
    //   308: istore_2
    //   309: iconst_0
    //   310: istore_3
    //   311: aload #4
    //   313: astore_1
    //   314: iload_2
    //   315: ifle -> 413
    //   318: aload #4
    //   320: astore_1
    //   321: iconst_0
    //   322: istore_2
    //   323: iload_2
    //   324: aload_0
    //   325: getfield c : Ljava/util/ArrayList;
    //   328: invokevirtual size : ()I
    //   331: if_icmpge -> 413
    //   334: aload_1
    //   335: astore #4
    //   337: iload_2
    //   338: ifle -> 373
    //   341: new java/lang/StringBuilder
    //   344: dup
    //   345: invokespecial <init> : ()V
    //   348: astore #4
    //   350: aload #4
    //   352: aload_1
    //   353: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: pop
    //   357: aload #4
    //   359: ldc_w ', '
    //   362: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: pop
    //   366: aload #4
    //   368: invokevirtual toString : ()Ljava/lang/String;
    //   371: astore #4
    //   373: new java/lang/StringBuilder
    //   376: dup
    //   377: invokespecial <init> : ()V
    //   380: astore_1
    //   381: aload_1
    //   382: aload #4
    //   384: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: pop
    //   388: aload_1
    //   389: aload_0
    //   390: getfield c : Ljava/util/ArrayList;
    //   393: iload_2
    //   394: invokevirtual get : (I)Ljava/lang/Object;
    //   397: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   400: pop
    //   401: aload_1
    //   402: invokevirtual toString : ()Ljava/lang/String;
    //   405: astore_1
    //   406: iload_2
    //   407: iconst_1
    //   408: iadd
    //   409: istore_2
    //   410: goto -> 323
    //   413: aload_1
    //   414: astore #4
    //   416: aload_0
    //   417: getfield d : Ljava/util/ArrayList;
    //   420: invokevirtual size : ()I
    //   423: ifle -> 521
    //   426: iload_3
    //   427: istore_2
    //   428: aload_1
    //   429: astore #4
    //   431: iload_2
    //   432: aload_0
    //   433: getfield d : Ljava/util/ArrayList;
    //   436: invokevirtual size : ()I
    //   439: if_icmpge -> 521
    //   442: aload_1
    //   443: astore #4
    //   445: iload_2
    //   446: ifle -> 481
    //   449: new java/lang/StringBuilder
    //   452: dup
    //   453: invokespecial <init> : ()V
    //   456: astore #4
    //   458: aload #4
    //   460: aload_1
    //   461: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: pop
    //   465: aload #4
    //   467: ldc_w ', '
    //   470: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: pop
    //   474: aload #4
    //   476: invokevirtual toString : ()Ljava/lang/String;
    //   479: astore #4
    //   481: new java/lang/StringBuilder
    //   484: dup
    //   485: invokespecial <init> : ()V
    //   488: astore_1
    //   489: aload_1
    //   490: aload #4
    //   492: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: pop
    //   496: aload_1
    //   497: aload_0
    //   498: getfield d : Ljava/util/ArrayList;
    //   501: iload_2
    //   502: invokevirtual get : (I)Ljava/lang/Object;
    //   505: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   508: pop
    //   509: aload_1
    //   510: invokevirtual toString : ()Ljava/lang/String;
    //   513: astore_1
    //   514: iload_2
    //   515: iconst_1
    //   516: iadd
    //   517: istore_2
    //   518: goto -> 428
    //   521: new java/lang/StringBuilder
    //   524: dup
    //   525: invokespecial <init> : ()V
    //   528: astore_1
    //   529: aload_1
    //   530: aload #4
    //   532: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: pop
    //   536: aload_1
    //   537: ldc_w ')'
    //   540: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: pop
    //   544: aload_1
    //   545: invokevirtual toString : ()Ljava/lang/String;
    //   548: astore #4
    //   550: aload #4
    //   552: areturn
  }
  
  protected void a() {
    b();
    ArrayMap<Animator, AnimationInfo> arrayMap = e();
    for (Animator animator : this.G) {
      if (arrayMap.containsKey(animator)) {
        b();
        a(animator, arrayMap);
      } 
    } 
    this.G.clear();
    c();
  }
  
  protected void a(Animator paramAnimator) {
    if (paramAnimator == null) {
      c();
      return;
    } 
    if (getDuration() >= 0L)
      paramAnimator.setDuration(getDuration()); 
    if (getStartDelay() >= 0L)
      paramAnimator.setStartDelay(getStartDelay() + paramAnimator.getStartDelay()); 
    if (getInterpolator() != null)
      paramAnimator.setInterpolator(getInterpolator()); 
    paramAnimator.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this) {
          public void onAnimationEnd(Animator param1Animator) {
            this.a.c();
            param1Animator.removeListener((Animator.AnimatorListener)this);
          }
        });
    paramAnimator.start();
  }
  
  void a(ViewGroup paramViewGroup) {
    this.y = new ArrayList<TransitionValues>();
    this.z = new ArrayList<TransitionValues>();
    a(this.v, this.w);
    ArrayMap<Animator, AnimationInfo> arrayMap = e();
    int i = arrayMap.size();
    WindowIdImpl windowIdImpl = ViewUtils.b((View)paramViewGroup);
    while (--i >= 0) {
      Animator animator = (Animator)arrayMap.keyAt(i);
      if (animator != null) {
        AnimationInfo animationInfo = (AnimationInfo)arrayMap.get(animator);
        if (animationInfo != null && animationInfo.a != null && windowIdImpl.equals(animationInfo.d)) {
          boolean bool;
          TransitionValues transitionValues3 = animationInfo.c;
          View view = animationInfo.a;
          TransitionValues transitionValues4 = getTransitionValues(view, true);
          TransitionValues transitionValues2 = a(view, true);
          TransitionValues transitionValues1 = transitionValues2;
          if (transitionValues4 == null) {
            transitionValues1 = transitionValues2;
            if (transitionValues2 == null)
              transitionValues1 = (TransitionValues)this.w.a.get(view); 
          } 
          if ((transitionValues4 != null || transitionValues1 != null) && animationInfo.e.isTransitionRequired(transitionValues3, transitionValues1)) {
            bool = true;
          } else {
            bool = false;
          } 
          if (bool)
            if (animator.isRunning() || animator.isStarted()) {
              animator.cancel();
            } else {
              arrayMap.remove(animator);
            }  
        } 
      } 
      i--;
    } 
    a(paramViewGroup, this.v, this.w, this.y, this.z);
    a();
  }
  
  protected void a(ViewGroup paramViewGroup, TransitionValuesMaps paramTransitionValuesMaps1, TransitionValuesMaps paramTransitionValuesMaps2, ArrayList<TransitionValues> paramArrayList1, ArrayList<TransitionValues> paramArrayList2) {
    Object object;
    ArrayMap<Animator, AnimationInfo> arrayMap = e();
    SparseIntArray sparseIntArray = new SparseIntArray();
    int j = paramArrayList1.size();
    long l = Long.MAX_VALUE;
    int i = 0;
    while (i < j) {
      TransitionValues transitionValues2 = paramArrayList1.get(i);
      TransitionValues transitionValues1 = paramArrayList2.get(i);
      TransitionValues transitionValues3 = transitionValues2;
      if (transitionValues2 != null) {
        transitionValues3 = transitionValues2;
        if (!transitionValues2.a.contains(this))
          transitionValues3 = null; 
      } 
      TransitionValues transitionValues4 = transitionValues1;
      if (transitionValues1 != null) {
        transitionValues4 = transitionValues1;
        if (!transitionValues1.a.contains(this))
          transitionValues4 = null; 
      } 
      if (transitionValues3 != null || transitionValues4 != null) {
        int m;
        if (transitionValues3 == null || transitionValues4 == null || isTransitionRequired(transitionValues3, transitionValues4)) {
          m = 1;
        } else {
          m = 0;
        } 
        if (m) {
          Animator animator = createAnimator(paramViewGroup, transitionValues3, transitionValues4);
          if (animator != null) {
            TransitionValues transitionValues;
            View view;
            if (transitionValues4 != null) {
              View view1 = transitionValues4.view;
              String[] arrayOfString = getTransitionProperties();
              if (arrayOfString != null && arrayOfString.length > 0) {
                TransitionValues transitionValues5 = new TransitionValues(view1);
                transitionValues2 = (TransitionValues)paramTransitionValuesMaps2.a.get(view1);
                m = i;
                if (transitionValues2 != null) {
                  int i1 = 0;
                  while (true) {
                    m = i;
                    if (i1 < arrayOfString.length) {
                      transitionValues5.values.put(arrayOfString[i1], transitionValues2.values.get(arrayOfString[i1]));
                      i1++;
                      continue;
                    } 
                    break;
                  } 
                } 
                i = m;
                int n = arrayMap.size();
                m = 0;
                while (true) {
                  if (m < n) {
                    AnimationInfo animationInfo = (AnimationInfo)arrayMap.get(arrayMap.keyAt(m));
                    if (animationInfo.c != null && animationInfo.a == view1 && animationInfo.b.equals(getName()) && animationInfo.c.equals(transitionValues5)) {
                      animator = null;
                      TransitionValues transitionValues6 = transitionValues5;
                      break;
                    } 
                    m++;
                    continue;
                  } 
                  transitionValues2 = transitionValues5;
                  break;
                } 
              } else {
                transitionValues2 = null;
              } 
              Animator animator2 = animator;
              transitionValues = transitionValues2;
              Animator animator1 = animator2;
              view = view1;
            } else {
              view = transitionValues3.view;
              TransitionValues transitionValues5 = null;
              transitionValues2 = transitionValues;
              transitionValues = transitionValues5;
            } 
            Object object2 = object;
            m = i;
            if (transitionValues2 != null) {
              TransitionPropagation transitionPropagation = this.h;
              object2 = object;
              if (transitionPropagation != null) {
                long l1 = transitionPropagation.getStartDelay(paramViewGroup, this, transitionValues3, transitionValues4);
                sparseIntArray.put(this.G.size(), (int)l1);
                l1 = Math.min(l1, object);
              } 
              arrayMap.put(transitionValues2, new AnimationInfo(view, getName(), this, ViewUtils.b((View)paramViewGroup), transitionValues));
              this.G.add(transitionValues2);
              m = i;
            } 
            continue;
          } 
        } 
      } 
      Object object1 = object;
      int k = i;
      continue;
      i = SYNTHETIC_LOCAL_VARIABLE_7 + 1;
      object = SYNTHETIC_LOCAL_VARIABLE_12;
    } 
    if (sparseIntArray.size() != 0)
      for (i = 0; i < sparseIntArray.size(); i++) {
        int k = sparseIntArray.keyAt(i);
        Animator animator = this.G.get(k);
        animator.setStartDelay(sparseIntArray.valueAt(i) - object + animator.getStartDelay());
      }  
  }
  
  void a(ViewGroup paramViewGroup, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: iload_2
    //   2: invokevirtual a : (Z)V
    //   5: aload_0
    //   6: getfield c : Ljava/util/ArrayList;
    //   9: invokevirtual size : ()I
    //   12: istore_3
    //   13: iconst_0
    //   14: istore #5
    //   16: iload_3
    //   17: ifgt -> 30
    //   20: aload_0
    //   21: getfield d : Ljava/util/ArrayList;
    //   24: invokevirtual size : ()I
    //   27: ifle -> 71
    //   30: aload_0
    //   31: getfield m : Ljava/util/ArrayList;
    //   34: astore #7
    //   36: aload #7
    //   38: ifnull -> 49
    //   41: aload #7
    //   43: invokevirtual isEmpty : ()Z
    //   46: ifeq -> 71
    //   49: aload_0
    //   50: getfield n : Ljava/util/ArrayList;
    //   53: astore #7
    //   55: aload #7
    //   57: ifnull -> 80
    //   60: aload #7
    //   62: invokevirtual isEmpty : ()Z
    //   65: ifeq -> 71
    //   68: goto -> 80
    //   71: aload_0
    //   72: aload_1
    //   73: iload_2
    //   74: invokespecial b : (Landroid/view/View;Z)V
    //   77: goto -> 304
    //   80: iconst_0
    //   81: istore_3
    //   82: iload_3
    //   83: aload_0
    //   84: getfield c : Ljava/util/ArrayList;
    //   87: invokevirtual size : ()I
    //   90: if_icmpge -> 200
    //   93: aload_1
    //   94: aload_0
    //   95: getfield c : Ljava/util/ArrayList;
    //   98: iload_3
    //   99: invokevirtual get : (I)Ljava/lang/Object;
    //   102: checkcast java/lang/Integer
    //   105: invokevirtual intValue : ()I
    //   108: invokevirtual findViewById : (I)Landroid/view/View;
    //   111: astore #7
    //   113: aload #7
    //   115: ifnull -> 193
    //   118: new androidx/transition/TransitionValues
    //   121: dup
    //   122: aload #7
    //   124: invokespecial <init> : (Landroid/view/View;)V
    //   127: astore #8
    //   129: iload_2
    //   130: ifeq -> 142
    //   133: aload_0
    //   134: aload #8
    //   136: invokevirtual captureStartValues : (Landroidx/transition/TransitionValues;)V
    //   139: goto -> 148
    //   142: aload_0
    //   143: aload #8
    //   145: invokevirtual captureEndValues : (Landroidx/transition/TransitionValues;)V
    //   148: aload #8
    //   150: getfield a : Ljava/util/ArrayList;
    //   153: aload_0
    //   154: invokevirtual add : (Ljava/lang/Object;)Z
    //   157: pop
    //   158: aload_0
    //   159: aload #8
    //   161: invokevirtual a : (Landroidx/transition/TransitionValues;)V
    //   164: iload_2
    //   165: ifeq -> 182
    //   168: aload_0
    //   169: getfield v : Landroidx/transition/TransitionValuesMaps;
    //   172: aload #7
    //   174: aload #8
    //   176: invokestatic a : (Landroidx/transition/TransitionValuesMaps;Landroid/view/View;Landroidx/transition/TransitionValues;)V
    //   179: goto -> 193
    //   182: aload_0
    //   183: getfield w : Landroidx/transition/TransitionValuesMaps;
    //   186: aload #7
    //   188: aload #8
    //   190: invokestatic a : (Landroidx/transition/TransitionValuesMaps;Landroid/view/View;Landroidx/transition/TransitionValues;)V
    //   193: iload_3
    //   194: iconst_1
    //   195: iadd
    //   196: istore_3
    //   197: goto -> 82
    //   200: iconst_0
    //   201: istore_3
    //   202: iload_3
    //   203: aload_0
    //   204: getfield d : Ljava/util/ArrayList;
    //   207: invokevirtual size : ()I
    //   210: if_icmpge -> 304
    //   213: aload_0
    //   214: getfield d : Ljava/util/ArrayList;
    //   217: iload_3
    //   218: invokevirtual get : (I)Ljava/lang/Object;
    //   221: checkcast android/view/View
    //   224: astore_1
    //   225: new androidx/transition/TransitionValues
    //   228: dup
    //   229: aload_1
    //   230: invokespecial <init> : (Landroid/view/View;)V
    //   233: astore #7
    //   235: iload_2
    //   236: ifeq -> 248
    //   239: aload_0
    //   240: aload #7
    //   242: invokevirtual captureStartValues : (Landroidx/transition/TransitionValues;)V
    //   245: goto -> 254
    //   248: aload_0
    //   249: aload #7
    //   251: invokevirtual captureEndValues : (Landroidx/transition/TransitionValues;)V
    //   254: aload #7
    //   256: getfield a : Ljava/util/ArrayList;
    //   259: aload_0
    //   260: invokevirtual add : (Ljava/lang/Object;)Z
    //   263: pop
    //   264: aload_0
    //   265: aload #7
    //   267: invokevirtual a : (Landroidx/transition/TransitionValues;)V
    //   270: iload_2
    //   271: ifeq -> 287
    //   274: aload_0
    //   275: getfield v : Landroidx/transition/TransitionValuesMaps;
    //   278: aload_1
    //   279: aload #7
    //   281: invokestatic a : (Landroidx/transition/TransitionValuesMaps;Landroid/view/View;Landroidx/transition/TransitionValues;)V
    //   284: goto -> 297
    //   287: aload_0
    //   288: getfield w : Landroidx/transition/TransitionValuesMaps;
    //   291: aload_1
    //   292: aload #7
    //   294: invokestatic a : (Landroidx/transition/TransitionValuesMaps;Landroid/view/View;Landroidx/transition/TransitionValues;)V
    //   297: iload_3
    //   298: iconst_1
    //   299: iadd
    //   300: istore_3
    //   301: goto -> 202
    //   304: iload_2
    //   305: ifne -> 443
    //   308: aload_0
    //   309: getfield I : Landroidx/collection/ArrayMap;
    //   312: astore_1
    //   313: aload_1
    //   314: ifnull -> 443
    //   317: aload_1
    //   318: invokevirtual size : ()I
    //   321: istore #6
    //   323: new java/util/ArrayList
    //   326: dup
    //   327: iload #6
    //   329: invokespecial <init> : (I)V
    //   332: astore_1
    //   333: iconst_0
    //   334: istore_3
    //   335: iload #5
    //   337: istore #4
    //   339: iload_3
    //   340: iload #6
    //   342: if_icmpge -> 382
    //   345: aload_0
    //   346: getfield I : Landroidx/collection/ArrayMap;
    //   349: iload_3
    //   350: invokevirtual keyAt : (I)Ljava/lang/Object;
    //   353: checkcast java/lang/String
    //   356: astore #7
    //   358: aload_1
    //   359: aload_0
    //   360: getfield v : Landroidx/transition/TransitionValuesMaps;
    //   363: getfield d : Landroidx/collection/ArrayMap;
    //   366: aload #7
    //   368: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   371: invokevirtual add : (Ljava/lang/Object;)Z
    //   374: pop
    //   375: iload_3
    //   376: iconst_1
    //   377: iadd
    //   378: istore_3
    //   379: goto -> 335
    //   382: iload #4
    //   384: iload #6
    //   386: if_icmpge -> 443
    //   389: aload_1
    //   390: iload #4
    //   392: invokevirtual get : (I)Ljava/lang/Object;
    //   395: checkcast android/view/View
    //   398: astore #7
    //   400: aload #7
    //   402: ifnull -> 434
    //   405: aload_0
    //   406: getfield I : Landroidx/collection/ArrayMap;
    //   409: iload #4
    //   411: invokevirtual valueAt : (I)Ljava/lang/Object;
    //   414: checkcast java/lang/String
    //   417: astore #8
    //   419: aload_0
    //   420: getfield v : Landroidx/transition/TransitionValuesMaps;
    //   423: getfield d : Landroidx/collection/ArrayMap;
    //   426: aload #8
    //   428: aload #7
    //   430: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   433: pop
    //   434: iload #4
    //   436: iconst_1
    //   437: iadd
    //   438: istore #4
    //   440: goto -> 382
    //   443: return
  }
  
  void a(TransitionValues paramTransitionValues) {
    if (this.h != null && !paramTransitionValues.values.isEmpty()) {
      String[] arrayOfString = this.h.getPropagationProperties();
      if (arrayOfString == null)
        return; 
      byte b = 0;
      int i = 0;
      while (true) {
        if (i < arrayOfString.length) {
          if (!paramTransitionValues.values.containsKey(arrayOfString[i])) {
            i = b;
            break;
          } 
          i++;
          continue;
        } 
        i = 1;
        break;
      } 
      if (i == 0)
        this.h.captureValues(paramTransitionValues); 
    } 
  }
  
  void a(boolean paramBoolean) {
    if (paramBoolean) {
      this.v.a.clear();
      this.v.b.clear();
      this.v.c.clear();
      return;
    } 
    this.w.a.clear();
    this.w.b.clear();
    this.w.c.clear();
  }
  
  public Transition addListener(TransitionListener paramTransitionListener) {
    if (this.F == null)
      this.F = new ArrayList<TransitionListener>(); 
    this.F.add(paramTransitionListener);
    return this;
  }
  
  public Transition addTarget(int paramInt) {
    if (paramInt != 0)
      this.c.add(Integer.valueOf(paramInt)); 
    return this;
  }
  
  public Transition addTarget(View paramView) {
    this.d.add(paramView);
    return this;
  }
  
  public Transition addTarget(Class<?> paramClass) {
    if (this.n == null)
      this.n = new ArrayList<Class<?>>(); 
    this.n.add(paramClass);
    return this;
  }
  
  public Transition addTarget(String paramString) {
    if (this.m == null)
      this.m = new ArrayList<String>(); 
    this.m.add(paramString);
    return this;
  }
  
  protected void b() {
    if (this.C == 0) {
      ArrayList<TransitionListener> arrayList = this.F;
      if (arrayList != null && arrayList.size() > 0) {
        arrayList = (ArrayList<TransitionListener>)this.F.clone();
        int j = arrayList.size();
        for (int i = 0; i < j; i++)
          ((TransitionListener)arrayList.get(i)).onTransitionStart(this); 
      } 
      this.E = false;
    } 
    this.C++;
  }
  
  void b(ViewGroup paramViewGroup) {
    ArrayMap<Animator, AnimationInfo> arrayMap = e();
    int i = arrayMap.size();
    if (paramViewGroup != null) {
      if (i == 0)
        return; 
      WindowIdImpl windowIdImpl = ViewUtils.b((View)paramViewGroup);
      ArrayMap arrayMap1 = new ArrayMap((SimpleArrayMap)arrayMap);
      arrayMap.clear();
      while (--i >= 0) {
        AnimationInfo animationInfo = (AnimationInfo)arrayMap1.valueAt(i);
        if (animationInfo.a != null && windowIdImpl != null && windowIdImpl.equals(animationInfo.d))
          ((Animator)arrayMap1.keyAt(i)).end(); 
        i--;
      } 
    } 
  }
  
  void b(boolean paramBoolean) {
    this.f = paramBoolean;
  }
  
  boolean b(View paramView) {
    int i = paramView.getId();
    ArrayList<Integer> arrayList2 = this.o;
    if (arrayList2 != null && arrayList2.contains(Integer.valueOf(i)))
      return false; 
    ArrayList<View> arrayList1 = this.p;
    if (arrayList1 != null && arrayList1.contains(paramView))
      return false; 
    ArrayList<Class<?>> arrayList = this.q;
    if (arrayList != null) {
      int k = arrayList.size();
      for (int j = 0; j < k; j++) {
        if (((Class)this.q.get(j)).isInstance(paramView))
          return false; 
      } 
    } 
    if (this.r != null && ViewCompat.getTransitionName(paramView) != null && this.r.contains(ViewCompat.getTransitionName(paramView)))
      return false; 
    if (this.c.size() == 0 && this.d.size() == 0) {
      arrayList = this.n;
      if (arrayList == null || arrayList.isEmpty()) {
        ArrayList<String> arrayList3 = this.m;
        if (arrayList3 == null || arrayList3.isEmpty())
          return true; 
      } 
    } 
    if (!this.c.contains(Integer.valueOf(i))) {
      if (this.d.contains(paramView))
        return true; 
      ArrayList<String> arrayList3 = this.m;
      if (arrayList3 != null && arrayList3.contains(ViewCompat.getTransitionName(paramView)))
        return true; 
      if (this.n != null)
        for (int j = 0; j < this.n.size(); j++) {
          if (((Class)this.n.get(j)).isInstance(paramView))
            return true; 
        }  
      return false;
    } 
    return true;
  }
  
  Transition c(ViewGroup paramViewGroup) {
    this.B = paramViewGroup;
    return this;
  }
  
  protected void c() {
    this.C--;
    if (this.C == 0) {
      ArrayList<TransitionListener> arrayList = this.F;
      if (arrayList != null && arrayList.size() > 0) {
        arrayList = (ArrayList<TransitionListener>)this.F.clone();
        int k = arrayList.size();
        for (int j = 0; j < k; j++)
          ((TransitionListener)arrayList.get(j)).onTransitionEnd(this); 
      } 
      int i;
      for (i = 0; i < this.v.c.size(); i++) {
        View view = (View)this.v.c.valueAt(i);
        if (view != null)
          ViewCompat.setHasTransientState(view, false); 
      } 
      for (i = 0; i < this.w.c.size(); i++) {
        View view = (View)this.w.c.valueAt(i);
        if (view != null)
          ViewCompat.setHasTransientState(view, false); 
      } 
      this.E = true;
    } 
  }
  
  public abstract void captureEndValues(TransitionValues paramTransitionValues);
  
  public abstract void captureStartValues(TransitionValues paramTransitionValues);
  
  public Transition clone() {
    try {
      Transition transition = (Transition)super.clone();
      transition.G = new ArrayList<Animator>();
      transition.v = new TransitionValuesMaps();
      transition.w = new TransitionValuesMaps();
      transition.y = null;
      transition.z = null;
      return transition;
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      return null;
    } 
  }
  
  public Animator createAnimator(ViewGroup paramViewGroup, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2) {
    return null;
  }
  
  protected void d() {
    int i;
    for (i = this.g.size() - 1; i >= 0; i--)
      ((Animator)this.g.get(i)).cancel(); 
    ArrayList<TransitionListener> arrayList = this.F;
    if (arrayList != null && arrayList.size() > 0) {
      arrayList = (ArrayList<TransitionListener>)this.F.clone();
      int j = arrayList.size();
      for (i = 0; i < j; i++)
        ((TransitionListener)arrayList.get(i)).onTransitionCancel(this); 
    } 
  }
  
  public Transition excludeChildren(int paramInt, boolean paramBoolean) {
    this.s = a(this.s, paramInt, paramBoolean);
    return this;
  }
  
  public Transition excludeChildren(View paramView, boolean paramBoolean) {
    this.t = a(this.t, paramView, paramBoolean);
    return this;
  }
  
  public Transition excludeChildren(Class<?> paramClass, boolean paramBoolean) {
    this.u = a(this.u, paramClass, paramBoolean);
    return this;
  }
  
  public Transition excludeTarget(int paramInt, boolean paramBoolean) {
    this.o = a(this.o, paramInt, paramBoolean);
    return this;
  }
  
  public Transition excludeTarget(View paramView, boolean paramBoolean) {
    this.p = a(this.p, paramView, paramBoolean);
    return this;
  }
  
  public Transition excludeTarget(Class<?> paramClass, boolean paramBoolean) {
    this.q = a(this.q, paramClass, paramBoolean);
    return this;
  }
  
  public Transition excludeTarget(String paramString, boolean paramBoolean) {
    this.r = a(this.r, paramString, paramBoolean);
    return this;
  }
  
  public long getDuration() {
    return this.b;
  }
  
  public Rect getEpicenter() {
    EpicenterCallback epicenterCallback = this.H;
    return (epicenterCallback == null) ? null : epicenterCallback.onGetEpicenter(this);
  }
  
  public EpicenterCallback getEpicenterCallback() {
    return this.H;
  }
  
  public TimeInterpolator getInterpolator() {
    return this.l;
  }
  
  public String getName() {
    return this.j;
  }
  
  public PathMotion getPathMotion() {
    return this.J;
  }
  
  public TransitionPropagation getPropagation() {
    return this.h;
  }
  
  public long getStartDelay() {
    return this.k;
  }
  
  public List<Integer> getTargetIds() {
    return this.c;
  }
  
  public List<String> getTargetNames() {
    return this.m;
  }
  
  public List<Class<?>> getTargetTypes() {
    return this.n;
  }
  
  public List<View> getTargets() {
    return this.d;
  }
  
  public String[] getTransitionProperties() {
    return null;
  }
  
  public TransitionValues getTransitionValues(View paramView, boolean paramBoolean) {
    TransitionValuesMaps transitionValuesMaps;
    TransitionSet transitionSet = this.e;
    if (transitionSet != null)
      return transitionSet.getTransitionValues(paramView, paramBoolean); 
    if (paramBoolean) {
      transitionValuesMaps = this.v;
    } else {
      transitionValuesMaps = this.w;
    } 
    return (TransitionValues)transitionValuesMaps.a.get(paramView);
  }
  
  public boolean isTransitionRequired(TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2) {
    // Byte code:
    //   0: iconst_0
    //   1: istore #6
    //   3: iload #6
    //   5: istore #5
    //   7: aload_1
    //   8: ifnull -> 120
    //   11: iload #6
    //   13: istore #5
    //   15: aload_2
    //   16: ifnull -> 120
    //   19: aload_0
    //   20: invokevirtual getTransitionProperties : ()[Ljava/lang/String;
    //   23: astore #7
    //   25: aload #7
    //   27: ifnull -> 69
    //   30: aload #7
    //   32: arraylength
    //   33: istore #4
    //   35: iconst_0
    //   36: istore_3
    //   37: iload #6
    //   39: istore #5
    //   41: iload_3
    //   42: iload #4
    //   44: if_icmpge -> 120
    //   47: aload_1
    //   48: aload_2
    //   49: aload #7
    //   51: iload_3
    //   52: aaload
    //   53: invokestatic a : (Landroidx/transition/TransitionValues;Landroidx/transition/TransitionValues;Ljava/lang/String;)Z
    //   56: ifeq -> 62
    //   59: goto -> 117
    //   62: iload_3
    //   63: iconst_1
    //   64: iadd
    //   65: istore_3
    //   66: goto -> 37
    //   69: aload_1
    //   70: getfield values : Ljava/util/Map;
    //   73: invokeinterface keySet : ()Ljava/util/Set;
    //   78: invokeinterface iterator : ()Ljava/util/Iterator;
    //   83: astore #7
    //   85: iload #6
    //   87: istore #5
    //   89: aload #7
    //   91: invokeinterface hasNext : ()Z
    //   96: ifeq -> 120
    //   99: aload_1
    //   100: aload_2
    //   101: aload #7
    //   103: invokeinterface next : ()Ljava/lang/Object;
    //   108: checkcast java/lang/String
    //   111: invokestatic a : (Landroidx/transition/TransitionValues;Landroidx/transition/TransitionValues;Ljava/lang/String;)Z
    //   114: ifeq -> 85
    //   117: iconst_1
    //   118: istore #5
    //   120: iload #5
    //   122: ireturn
  }
  
  public void pause(View paramView) {
    if (!this.E) {
      ArrayMap<Animator, AnimationInfo> arrayMap = e();
      int i = arrayMap.size();
      WindowIdImpl windowIdImpl = ViewUtils.b(paramView);
      while (--i >= 0) {
        AnimationInfo animationInfo = (AnimationInfo)arrayMap.valueAt(i);
        if (animationInfo.a != null && windowIdImpl.equals(animationInfo.d))
          AnimatorUtils.a((Animator)arrayMap.keyAt(i)); 
        i--;
      } 
      ArrayList<TransitionListener> arrayList = this.F;
      if (arrayList != null && arrayList.size() > 0) {
        arrayList = (ArrayList<TransitionListener>)this.F.clone();
        int j = arrayList.size();
        for (i = 0; i < j; i++)
          ((TransitionListener)arrayList.get(i)).onTransitionPause(this); 
      } 
      this.D = true;
    } 
  }
  
  public Transition removeListener(TransitionListener paramTransitionListener) {
    ArrayList<TransitionListener> arrayList = this.F;
    if (arrayList == null)
      return this; 
    arrayList.remove(paramTransitionListener);
    if (this.F.size() == 0)
      this.F = null; 
    return this;
  }
  
  public Transition removeTarget(int paramInt) {
    if (paramInt != 0)
      this.c.remove(Integer.valueOf(paramInt)); 
    return this;
  }
  
  public Transition removeTarget(View paramView) {
    this.d.remove(paramView);
    return this;
  }
  
  public Transition removeTarget(Class<?> paramClass) {
    ArrayList<Class<?>> arrayList = this.n;
    if (arrayList != null)
      arrayList.remove(paramClass); 
    return this;
  }
  
  public Transition removeTarget(String paramString) {
    ArrayList<String> arrayList = this.m;
    if (arrayList != null)
      arrayList.remove(paramString); 
    return this;
  }
  
  public void resume(View paramView) {
    if (this.D) {
      if (!this.E) {
        ArrayMap<Animator, AnimationInfo> arrayMap = e();
        int i = arrayMap.size();
        WindowIdImpl windowIdImpl = ViewUtils.b(paramView);
        while (--i >= 0) {
          AnimationInfo animationInfo = (AnimationInfo)arrayMap.valueAt(i);
          if (animationInfo.a != null && windowIdImpl.equals(animationInfo.d))
            AnimatorUtils.b((Animator)arrayMap.keyAt(i)); 
          i--;
        } 
        ArrayList<TransitionListener> arrayList = this.F;
        if (arrayList != null && arrayList.size() > 0) {
          arrayList = (ArrayList<TransitionListener>)this.F.clone();
          int j = arrayList.size();
          for (i = 0; i < j; i++)
            ((TransitionListener)arrayList.get(i)).onTransitionResume(this); 
        } 
      } 
      this.D = false;
    } 
  }
  
  public Transition setDuration(long paramLong) {
    this.b = paramLong;
    return this;
  }
  
  public void setEpicenterCallback(EpicenterCallback paramEpicenterCallback) {
    this.H = paramEpicenterCallback;
  }
  
  public Transition setInterpolator(TimeInterpolator paramTimeInterpolator) {
    this.l = paramTimeInterpolator;
    return this;
  }
  
  public void setMatchOrder(int... paramVarArgs) {
    if (paramVarArgs == null || paramVarArgs.length == 0) {
      this.x = a;
      return;
    } 
    int i = 0;
    while (i < paramVarArgs.length) {
      if (a(paramVarArgs[i])) {
        if (!a(paramVarArgs, i)) {
          i++;
          continue;
        } 
        throw new IllegalArgumentException("matches contains a duplicate value");
      } 
      throw new IllegalArgumentException("matches contains invalid value");
    } 
    this.x = (int[])paramVarArgs.clone();
  }
  
  public void setPathMotion(PathMotion paramPathMotion) {
    if (paramPathMotion == null) {
      this.J = i;
      return;
    } 
    this.J = paramPathMotion;
  }
  
  public void setPropagation(TransitionPropagation paramTransitionPropagation) {
    this.h = paramTransitionPropagation;
  }
  
  public Transition setStartDelay(long paramLong) {
    this.k = paramLong;
    return this;
  }
  
  public String toString() {
    return a("");
  }
  
  static class AnimationInfo {
    View a;
    
    String b;
    
    TransitionValues c;
    
    WindowIdImpl d;
    
    Transition e;
    
    AnimationInfo(View param1View, String param1String, Transition param1Transition, WindowIdImpl param1WindowIdImpl, TransitionValues param1TransitionValues) {
      this.a = param1View;
      this.b = param1String;
      this.c = param1TransitionValues;
      this.d = param1WindowIdImpl;
      this.e = param1Transition;
    }
  }
  
  static class ArrayListManager {
    static <T> ArrayList<T> a(ArrayList<T> param1ArrayList, T param1T) {
      ArrayList<T> arrayList = param1ArrayList;
      if (param1ArrayList == null)
        arrayList = new ArrayList<T>(); 
      if (!arrayList.contains(param1T))
        arrayList.add(param1T); 
      return arrayList;
    }
    
    static <T> ArrayList<T> b(ArrayList<T> param1ArrayList, T param1T) {
      ArrayList<T> arrayList = param1ArrayList;
      if (param1ArrayList != null) {
        param1ArrayList.remove(param1T);
        arrayList = param1ArrayList;
        if (param1ArrayList.isEmpty())
          arrayList = null; 
      } 
      return arrayList;
    }
  }
  
  public static abstract class EpicenterCallback {
    public abstract Rect onGetEpicenter(Transition param1Transition);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface MatchOrder {}
  
  public static interface TransitionListener {
    void onTransitionCancel(Transition param1Transition);
    
    void onTransitionEnd(Transition param1Transition);
    
    void onTransitionPause(Transition param1Transition);
    
    void onTransitionResume(Transition param1Transition);
    
    void onTransitionStart(Transition param1Transition);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\transition\Transition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */