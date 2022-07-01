package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class AnimatorInflaterCompat {
  private static int a(Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, XmlPullParser paramXmlPullParser) {
    boolean bool;
    TypedArray typedArray = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.STYLEABLE_KEYFRAME);
    byte b2 = 0;
    TypedValue typedValue = TypedArrayUtils.peekNamedValue(typedArray, paramXmlPullParser, "value", 0);
    if (typedValue != null) {
      bool = true;
    } else {
      bool = false;
    } 
    byte b1 = b2;
    if (bool) {
      b1 = b2;
      if (a(typedValue.type))
        b1 = 3; 
    } 
    typedArray.recycle();
    return b1;
  }
  
  private static int a(TypedArray paramTypedArray, int paramInt1, int paramInt2) {
    boolean bool1;
    TypedValue typedValue2 = paramTypedArray.peekValue(paramInt1);
    int i = 1;
    boolean bool2 = false;
    if (typedValue2 != null) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    } 
    if (paramInt1 != 0) {
      bool1 = typedValue2.type;
    } else {
      bool1 = false;
    } 
    TypedValue typedValue1 = paramTypedArray.peekValue(paramInt2);
    if (typedValue1 != null) {
      paramInt2 = i;
    } else {
      paramInt2 = 0;
    } 
    if (paramInt2 != 0) {
      i = typedValue1.type;
    } else {
      i = 0;
    } 
    if (paramInt1 == 0 || !a(bool1)) {
      paramInt1 = bool2;
      if (paramInt2 != 0) {
        paramInt1 = bool2;
        if (a(i))
          return 3; 
      } 
      return paramInt1;
    } 
    return 3;
  }
  
  private static Animator a(Context paramContext, Resources paramResources, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser, float paramFloat) throws XmlPullParserException, IOException {
    return a(paramContext, paramResources, paramTheme, paramXmlPullParser, Xml.asAttributeSet(paramXmlPullParser), null, 0, paramFloat);
  }
  
  private static Animator a(Context paramContext, Resources paramResources, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, AnimatorSet paramAnimatorSet, int paramInt, float paramFloat) throws XmlPullParserException, IOException {
    int i;
    int j = paramXmlPullParser.getDepth();
    TypedArray typedArray = null;
    ArrayList<TypedArray> arrayList = null;
    while (true) {
      int k = paramXmlPullParser.next();
      i = 0;
      boolean bool = false;
      if ((k != 3 || paramXmlPullParser.getDepth() > j) && k != 1) {
        ObjectAnimator objectAnimator;
        TypedArray typedArray1;
        if (k != 2)
          continue; 
        String str = paramXmlPullParser.getName();
        if (str.equals("objectAnimator")) {
          objectAnimator = a(paramContext, paramResources, paramTheme, paramAttributeSet, paramFloat, paramXmlPullParser);
        } else {
          ValueAnimator valueAnimator;
          if (objectAnimator.equals("animator")) {
            valueAnimator = a(paramContext, paramResources, paramTheme, paramAttributeSet, null, paramFloat, paramXmlPullParser);
          } else {
            AnimatorSet animatorSet;
            if (valueAnimator.equals("set")) {
              animatorSet = new AnimatorSet();
              typedArray = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.STYLEABLE_ANIMATOR_SET);
              i = TypedArrayUtils.getNamedInt(typedArray, paramXmlPullParser, "ordering", 0, 0);
              a(paramContext, paramResources, paramTheme, paramXmlPullParser, paramAttributeSet, animatorSet, i, paramFloat);
              typedArray.recycle();
            } else if (animatorSet.equals("propertyValuesHolder")) {
              PropertyValuesHolder[] arrayOfPropertyValuesHolder = a(paramContext, paramResources, paramTheme, paramXmlPullParser, Xml.asAttributeSet(paramXmlPullParser));
              if (arrayOfPropertyValuesHolder != null && typedArray instanceof ValueAnimator)
                ((ValueAnimator)typedArray).setValues(arrayOfPropertyValuesHolder); 
              bool = true;
              typedArray1 = typedArray;
            } else {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("Unknown animator name: ");
              stringBuilder.append(paramXmlPullParser.getName());
              throw new RuntimeException(stringBuilder.toString());
            } 
          } 
        } 
        typedArray = typedArray1;
        if (paramAnimatorSet != null) {
          typedArray = typedArray1;
          if (!bool) {
            ArrayList<TypedArray> arrayList1 = arrayList;
            if (arrayList == null)
              arrayList1 = new ArrayList(); 
            arrayList1.add(typedArray1);
            typedArray = typedArray1;
            arrayList = arrayList1;
          } 
        } 
        continue;
      } 
      break;
    } 
    if (paramAnimatorSet != null && arrayList != null) {
      Animator[] arrayOfAnimator = new Animator[arrayList.size()];
      Iterator<TypedArray> iterator = arrayList.iterator();
      int k;
      for (k = i; iterator.hasNext(); k++)
        arrayOfAnimator[k] = (Animator)iterator.next(); 
      if (paramInt == 0) {
        paramAnimatorSet.playTogether(arrayOfAnimator);
        return (Animator)typedArray;
      } 
      paramAnimatorSet.playSequentially(arrayOfAnimator);
    } 
    return (Animator)typedArray;
  }
  
  private static Keyframe a(Keyframe paramKeyframe, float paramFloat) {
    return (paramKeyframe.getType() == float.class) ? Keyframe.ofFloat(paramFloat) : ((paramKeyframe.getType() == int.class) ? Keyframe.ofInt(paramFloat) : Keyframe.ofObject(paramFloat));
  }
  
  private static Keyframe a(Context paramContext, Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, int paramInt, XmlPullParser paramXmlPullParser) throws XmlPullParserException, IOException {
    Keyframe keyframe;
    boolean bool;
    TypedArray typedArray = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.STYLEABLE_KEYFRAME);
    float f = TypedArrayUtils.getNamedFloat(typedArray, paramXmlPullParser, "fraction", 3, -1.0F);
    TypedValue typedValue = TypedArrayUtils.peekNamedValue(typedArray, paramXmlPullParser, "value", 0);
    if (typedValue != null) {
      bool = true;
    } else {
      bool = false;
    } 
    int i = paramInt;
    if (paramInt == 4)
      if (bool && a(typedValue.type)) {
        i = 3;
      } else {
        i = 0;
      }  
    if (bool) {
      if (i != 0) {
        if (i != 1 && i != 3) {
          typedValue = null;
        } else {
          keyframe = Keyframe.ofInt(f, TypedArrayUtils.getNamedInt(typedArray, paramXmlPullParser, "value", 0, 0));
        } 
      } else {
        keyframe = Keyframe.ofFloat(f, TypedArrayUtils.getNamedFloat(typedArray, paramXmlPullParser, "value", 0, 0.0F));
      } 
    } else if (i == 0) {
      keyframe = Keyframe.ofFloat(f);
    } else {
      keyframe = Keyframe.ofInt(f);
    } 
    paramInt = TypedArrayUtils.getNamedResourceId(typedArray, paramXmlPullParser, "interpolator", 1, 0);
    if (paramInt > 0)
      keyframe.setInterpolator((TimeInterpolator)AnimationUtilsCompat.loadInterpolator(paramContext, paramInt)); 
    typedArray.recycle();
    return keyframe;
  }
  
  private static ObjectAnimator a(Context paramContext, Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, float paramFloat, XmlPullParser paramXmlPullParser) throws Resources.NotFoundException {
    ObjectAnimator objectAnimator = new ObjectAnimator();
    a(paramContext, paramResources, paramTheme, paramAttributeSet, (ValueAnimator)objectAnimator, paramFloat, paramXmlPullParser);
    return objectAnimator;
  }
  
  private static PropertyValuesHolder a(Context paramContext, Resources paramResources, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser, String paramString, int paramInt) throws XmlPullParserException, IOException {
    PropertyValuesHolder propertyValuesHolder;
    Context context = null;
    ArrayList<Keyframe> arrayList = null;
    int i = paramInt;
    while (true) {
      paramInt = paramXmlPullParser.next();
      if (paramInt != 3 && paramInt != 1) {
        if (paramXmlPullParser.getName().equals("keyframe")) {
          paramInt = i;
          if (i == 4)
            paramInt = a(paramResources, paramTheme, Xml.asAttributeSet(paramXmlPullParser), paramXmlPullParser); 
          Keyframe keyframe = a(paramContext, paramResources, paramTheme, Xml.asAttributeSet(paramXmlPullParser), paramInt, paramXmlPullParser);
          ArrayList<Keyframe> arrayList1 = arrayList;
          if (keyframe != null) {
            arrayList1 = arrayList;
            if (arrayList == null)
              arrayList1 = new ArrayList(); 
            arrayList1.add(keyframe);
          } 
          paramXmlPullParser.next();
          i = paramInt;
          arrayList = arrayList1;
        } 
        continue;
      } 
      break;
    } 
    paramContext = context;
    if (arrayList != null) {
      int j = arrayList.size();
      paramContext = context;
      if (j > 0) {
        int k = 0;
        Keyframe keyframe1 = arrayList.get(0);
        Keyframe keyframe2 = arrayList.get(j - 1);
        float f = keyframe2.getFraction();
        paramInt = j;
        if (f < 1.0F)
          if (f < 0.0F) {
            keyframe2.setFraction(1.0F);
            paramInt = j;
          } else {
            arrayList.add(arrayList.size(), a(keyframe2, 1.0F));
            paramInt = j + 1;
          }  
        f = keyframe1.getFraction();
        j = paramInt;
        if (f != 0.0F)
          if (f < 0.0F) {
            keyframe1.setFraction(0.0F);
            j = paramInt;
          } else {
            arrayList.add(0, a(keyframe1, 0.0F));
            j = paramInt + 1;
          }  
        Keyframe[] arrayOfKeyframe = new Keyframe[j];
        arrayList.toArray(arrayOfKeyframe);
        for (paramInt = k; paramInt < j; paramInt++) {
          keyframe2 = arrayOfKeyframe[paramInt];
          if (keyframe2.getFraction() < 0.0F)
            if (paramInt == 0) {
              keyframe2.setFraction(0.0F);
            } else {
              int m = j - 1;
              if (paramInt == m) {
                keyframe2.setFraction(1.0F);
              } else {
                k = paramInt + 1;
                int n = paramInt;
                while (k < m && arrayOfKeyframe[k].getFraction() < 0.0F) {
                  n = k;
                  k++;
                } 
                a(arrayOfKeyframe, arrayOfKeyframe[n + 1].getFraction() - arrayOfKeyframe[paramInt - 1].getFraction(), paramInt, n);
              } 
            }  
        } 
        PropertyValuesHolder propertyValuesHolder1 = PropertyValuesHolder.ofKeyframe(paramString, arrayOfKeyframe);
        propertyValuesHolder = propertyValuesHolder1;
        if (i == 3) {
          propertyValuesHolder1.setEvaluator(ArgbEvaluator.getInstance());
          propertyValuesHolder = propertyValuesHolder1;
        } 
      } 
    } 
    return propertyValuesHolder;
  }
  
  private static PropertyValuesHolder a(TypedArray paramTypedArray, int paramInt1, int paramInt2, int paramInt3, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: iload_2
    //   2: invokevirtual peekValue : (I)Landroid/util/TypedValue;
    //   5: astore #12
    //   7: aload #12
    //   9: ifnull -> 18
    //   12: iconst_1
    //   13: istore #8
    //   15: goto -> 21
    //   18: iconst_0
    //   19: istore #8
    //   21: iload #8
    //   23: ifeq -> 36
    //   26: aload #12
    //   28: getfield type : I
    //   31: istore #10
    //   33: goto -> 39
    //   36: iconst_0
    //   37: istore #10
    //   39: aload_0
    //   40: iload_3
    //   41: invokevirtual peekValue : (I)Landroid/util/TypedValue;
    //   44: astore #12
    //   46: aload #12
    //   48: ifnull -> 57
    //   51: iconst_1
    //   52: istore #9
    //   54: goto -> 60
    //   57: iconst_0
    //   58: istore #9
    //   60: iload #9
    //   62: ifeq -> 75
    //   65: aload #12
    //   67: getfield type : I
    //   70: istore #11
    //   72: goto -> 78
    //   75: iconst_0
    //   76: istore #11
    //   78: iload_1
    //   79: istore #7
    //   81: iload_1
    //   82: iconst_4
    //   83: if_icmpne -> 121
    //   86: iload #8
    //   88: ifeq -> 99
    //   91: iload #10
    //   93: invokestatic a : (I)Z
    //   96: ifne -> 112
    //   99: iload #9
    //   101: ifeq -> 118
    //   104: iload #11
    //   106: invokestatic a : (I)Z
    //   109: ifeq -> 118
    //   112: iconst_3
    //   113: istore #7
    //   115: goto -> 121
    //   118: iconst_0
    //   119: istore #7
    //   121: iload #7
    //   123: ifne -> 131
    //   126: iconst_1
    //   127: istore_1
    //   128: goto -> 133
    //   131: iconst_0
    //   132: istore_1
    //   133: aconst_null
    //   134: astore #12
    //   136: aconst_null
    //   137: astore #14
    //   139: iload #7
    //   141: iconst_2
    //   142: if_icmpne -> 336
    //   145: aload_0
    //   146: iload_2
    //   147: invokevirtual getString : (I)Ljava/lang/String;
    //   150: astore #13
    //   152: aload_0
    //   153: iload_3
    //   154: invokevirtual getString : (I)Ljava/lang/String;
    //   157: astore #14
    //   159: aload #13
    //   161: invokestatic createNodesFromPathData : (Ljava/lang/String;)[Landroidx/core/graphics/PathParser$PathDataNode;
    //   164: astore #15
    //   166: aload #14
    //   168: invokestatic createNodesFromPathData : (Ljava/lang/String;)[Landroidx/core/graphics/PathParser$PathDataNode;
    //   171: astore #16
    //   173: aload #15
    //   175: ifnonnull -> 186
    //   178: aload #12
    //   180: astore_0
    //   181: aload #16
    //   183: ifnull -> 724
    //   186: aload #15
    //   188: ifnull -> 306
    //   191: new androidx/vectordrawable/graphics/drawable/AnimatorInflaterCompat$PathDataEvaluator
    //   194: dup
    //   195: invokespecial <init> : ()V
    //   198: astore_0
    //   199: aload #16
    //   201: ifnull -> 288
    //   204: aload #15
    //   206: aload #16
    //   208: invokestatic canMorph : ([Landroidx/core/graphics/PathParser$PathDataNode;[Landroidx/core/graphics/PathParser$PathDataNode;)Z
    //   211: ifeq -> 238
    //   214: aload #4
    //   216: aload_0
    //   217: iconst_2
    //   218: anewarray java/lang/Object
    //   221: dup
    //   222: iconst_0
    //   223: aload #15
    //   225: aastore
    //   226: dup
    //   227: iconst_1
    //   228: aload #16
    //   230: aastore
    //   231: invokestatic ofObject : (Ljava/lang/String;Landroid/animation/TypeEvaluator;[Ljava/lang/Object;)Landroid/animation/PropertyValuesHolder;
    //   234: astore_0
    //   235: goto -> 304
    //   238: new java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial <init> : ()V
    //   245: astore_0
    //   246: aload_0
    //   247: ldc_w ' Can't morph from '
    //   250: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: aload_0
    //   255: aload #13
    //   257: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: pop
    //   261: aload_0
    //   262: ldc_w ' to '
    //   265: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload_0
    //   270: aload #14
    //   272: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: new android/view/InflateException
    //   279: dup
    //   280: aload_0
    //   281: invokevirtual toString : ()Ljava/lang/String;
    //   284: invokespecial <init> : (Ljava/lang/String;)V
    //   287: athrow
    //   288: aload #4
    //   290: aload_0
    //   291: iconst_1
    //   292: anewarray java/lang/Object
    //   295: dup
    //   296: iconst_0
    //   297: aload #15
    //   299: aastore
    //   300: invokestatic ofObject : (Ljava/lang/String;Landroid/animation/TypeEvaluator;[Ljava/lang/Object;)Landroid/animation/PropertyValuesHolder;
    //   303: astore_0
    //   304: aload_0
    //   305: areturn
    //   306: aload #12
    //   308: astore_0
    //   309: aload #16
    //   311: ifnull -> 724
    //   314: aload #4
    //   316: new androidx/vectordrawable/graphics/drawable/AnimatorInflaterCompat$PathDataEvaluator
    //   319: dup
    //   320: invokespecial <init> : ()V
    //   323: iconst_1
    //   324: anewarray java/lang/Object
    //   327: dup
    //   328: iconst_0
    //   329: aload #16
    //   331: aastore
    //   332: invokestatic ofObject : (Ljava/lang/String;Landroid/animation/TypeEvaluator;[Ljava/lang/Object;)Landroid/animation/PropertyValuesHolder;
    //   335: areturn
    //   336: iload #7
    //   338: iconst_3
    //   339: if_icmpne -> 350
    //   342: invokestatic getInstance : ()Landroidx/vectordrawable/graphics/drawable/ArgbEvaluator;
    //   345: astore #13
    //   347: goto -> 353
    //   350: aconst_null
    //   351: astore #13
    //   353: iload_1
    //   354: ifeq -> 501
    //   357: iload #8
    //   359: ifeq -> 456
    //   362: iload #10
    //   364: iconst_5
    //   365: if_icmpne -> 379
    //   368: aload_0
    //   369: iload_2
    //   370: fconst_0
    //   371: invokevirtual getDimension : (IF)F
    //   374: fstore #5
    //   376: goto -> 387
    //   379: aload_0
    //   380: iload_2
    //   381: fconst_0
    //   382: invokevirtual getFloat : (IF)F
    //   385: fstore #5
    //   387: iload #9
    //   389: ifeq -> 439
    //   392: iload #11
    //   394: iconst_5
    //   395: if_icmpne -> 409
    //   398: aload_0
    //   399: iload_3
    //   400: fconst_0
    //   401: invokevirtual getDimension : (IF)F
    //   404: fstore #6
    //   406: goto -> 417
    //   409: aload_0
    //   410: iload_3
    //   411: fconst_0
    //   412: invokevirtual getFloat : (IF)F
    //   415: fstore #6
    //   417: aload #4
    //   419: iconst_2
    //   420: newarray float
    //   422: dup
    //   423: iconst_0
    //   424: fload #5
    //   426: fastore
    //   427: dup
    //   428: iconst_1
    //   429: fload #6
    //   431: fastore
    //   432: invokestatic ofFloat : (Ljava/lang/String;[F)Landroid/animation/PropertyValuesHolder;
    //   435: astore_0
    //   436: goto -> 495
    //   439: aload #4
    //   441: iconst_1
    //   442: newarray float
    //   444: dup
    //   445: iconst_0
    //   446: fload #5
    //   448: fastore
    //   449: invokestatic ofFloat : (Ljava/lang/String;[F)Landroid/animation/PropertyValuesHolder;
    //   452: astore_0
    //   453: goto -> 495
    //   456: iload #11
    //   458: iconst_5
    //   459: if_icmpne -> 473
    //   462: aload_0
    //   463: iload_3
    //   464: fconst_0
    //   465: invokevirtual getDimension : (IF)F
    //   468: fstore #5
    //   470: goto -> 481
    //   473: aload_0
    //   474: iload_3
    //   475: fconst_0
    //   476: invokevirtual getFloat : (IF)F
    //   479: fstore #5
    //   481: aload #4
    //   483: iconst_1
    //   484: newarray float
    //   486: dup
    //   487: iconst_0
    //   488: fload #5
    //   490: fastore
    //   491: invokestatic ofFloat : (Ljava/lang/String;[F)Landroid/animation/PropertyValuesHolder;
    //   494: astore_0
    //   495: aload_0
    //   496: astore #12
    //   498: goto -> 698
    //   501: iload #8
    //   503: ifeq -> 633
    //   506: iload #10
    //   508: iconst_5
    //   509: if_icmpne -> 523
    //   512: aload_0
    //   513: iload_2
    //   514: fconst_0
    //   515: invokevirtual getDimension : (IF)F
    //   518: f2i
    //   519: istore_1
    //   520: goto -> 548
    //   523: iload #10
    //   525: invokestatic a : (I)Z
    //   528: ifeq -> 541
    //   531: aload_0
    //   532: iload_2
    //   533: iconst_0
    //   534: invokevirtual getColor : (II)I
    //   537: istore_1
    //   538: goto -> 548
    //   541: aload_0
    //   542: iload_2
    //   543: iconst_0
    //   544: invokevirtual getInt : (II)I
    //   547: istore_1
    //   548: iload #9
    //   550: ifeq -> 616
    //   553: iload #11
    //   555: iconst_5
    //   556: if_icmpne -> 570
    //   559: aload_0
    //   560: iload_3
    //   561: fconst_0
    //   562: invokevirtual getDimension : (IF)F
    //   565: f2i
    //   566: istore_2
    //   567: goto -> 595
    //   570: iload #11
    //   572: invokestatic a : (I)Z
    //   575: ifeq -> 588
    //   578: aload_0
    //   579: iload_3
    //   580: iconst_0
    //   581: invokevirtual getColor : (II)I
    //   584: istore_2
    //   585: goto -> 595
    //   588: aload_0
    //   589: iload_3
    //   590: iconst_0
    //   591: invokevirtual getInt : (II)I
    //   594: istore_2
    //   595: aload #4
    //   597: iconst_2
    //   598: newarray int
    //   600: dup
    //   601: iconst_0
    //   602: iload_1
    //   603: iastore
    //   604: dup
    //   605: iconst_1
    //   606: iload_2
    //   607: iastore
    //   608: invokestatic ofInt : (Ljava/lang/String;[I)Landroid/animation/PropertyValuesHolder;
    //   611: astore #12
    //   613: goto -> 698
    //   616: aload #4
    //   618: iconst_1
    //   619: newarray int
    //   621: dup
    //   622: iconst_0
    //   623: iload_1
    //   624: iastore
    //   625: invokestatic ofInt : (Ljava/lang/String;[I)Landroid/animation/PropertyValuesHolder;
    //   628: astore #12
    //   630: goto -> 698
    //   633: aload #14
    //   635: astore #12
    //   637: iload #9
    //   639: ifeq -> 698
    //   642: iload #11
    //   644: iconst_5
    //   645: if_icmpne -> 659
    //   648: aload_0
    //   649: iload_3
    //   650: fconst_0
    //   651: invokevirtual getDimension : (IF)F
    //   654: f2i
    //   655: istore_1
    //   656: goto -> 684
    //   659: iload #11
    //   661: invokestatic a : (I)Z
    //   664: ifeq -> 677
    //   667: aload_0
    //   668: iload_3
    //   669: iconst_0
    //   670: invokevirtual getColor : (II)I
    //   673: istore_1
    //   674: goto -> 684
    //   677: aload_0
    //   678: iload_3
    //   679: iconst_0
    //   680: invokevirtual getInt : (II)I
    //   683: istore_1
    //   684: aload #4
    //   686: iconst_1
    //   687: newarray int
    //   689: dup
    //   690: iconst_0
    //   691: iload_1
    //   692: iastore
    //   693: invokestatic ofInt : (Ljava/lang/String;[I)Landroid/animation/PropertyValuesHolder;
    //   696: astore #12
    //   698: aload #12
    //   700: astore_0
    //   701: aload #12
    //   703: ifnull -> 724
    //   706: aload #12
    //   708: astore_0
    //   709: aload #13
    //   711: ifnull -> 724
    //   714: aload #12
    //   716: aload #13
    //   718: invokevirtual setEvaluator : (Landroid/animation/TypeEvaluator;)V
    //   721: aload #12
    //   723: astore_0
    //   724: aload_0
    //   725: areturn
  }
  
  private static ValueAnimator a(Context paramContext, Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, ValueAnimator paramValueAnimator, float paramFloat, XmlPullParser paramXmlPullParser) throws Resources.NotFoundException {
    TypedArray typedArray2 = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.STYLEABLE_ANIMATOR);
    TypedArray typedArray1 = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.STYLEABLE_PROPERTY_ANIMATOR);
    ValueAnimator valueAnimator = paramValueAnimator;
    if (paramValueAnimator == null)
      valueAnimator = new ValueAnimator(); 
    a(valueAnimator, typedArray2, typedArray1, paramFloat, paramXmlPullParser);
    int i = TypedArrayUtils.getNamedResourceId(typedArray2, paramXmlPullParser, "interpolator", 0, 0);
    if (i > 0)
      valueAnimator.setInterpolator((TimeInterpolator)AnimationUtilsCompat.loadInterpolator(paramContext, i)); 
    typedArray2.recycle();
    if (typedArray1 != null)
      typedArray1.recycle(); 
    return valueAnimator;
  }
  
  private static void a(ValueAnimator paramValueAnimator, TypedArray paramTypedArray, int paramInt, float paramFloat, XmlPullParser paramXmlPullParser) {
    // Byte code:
    //   0: aload_0
    //   1: checkcast android/animation/ObjectAnimator
    //   4: astore_0
    //   5: aload_1
    //   6: aload #4
    //   8: ldc_w 'pathData'
    //   11: iconst_1
    //   12: invokestatic getNamedString : (Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;I)Ljava/lang/String;
    //   15: astore #5
    //   17: aload #5
    //   19: ifnull -> 120
    //   22: aload_1
    //   23: aload #4
    //   25: ldc_w 'propertyXName'
    //   28: iconst_2
    //   29: invokestatic getNamedString : (Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;I)Ljava/lang/String;
    //   32: astore #6
    //   34: aload_1
    //   35: aload #4
    //   37: ldc_w 'propertyYName'
    //   40: iconst_3
    //   41: invokestatic getNamedString : (Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;I)Ljava/lang/String;
    //   44: astore #4
    //   46: iload_2
    //   47: iconst_2
    //   48: if_icmpeq -> 51
    //   51: aload #6
    //   53: ifnonnull -> 101
    //   56: aload #4
    //   58: ifnull -> 64
    //   61: goto -> 101
    //   64: new java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: astore_0
    //   72: aload_0
    //   73: aload_1
    //   74: invokevirtual getPositionDescription : ()Ljava/lang/String;
    //   77: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload_0
    //   82: ldc_w ' propertyXName or propertyYName is needed for PathData'
    //   85: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: new android/view/InflateException
    //   92: dup
    //   93: aload_0
    //   94: invokevirtual toString : ()Ljava/lang/String;
    //   97: invokespecial <init> : (Ljava/lang/String;)V
    //   100: athrow
    //   101: aload #5
    //   103: invokestatic createPathFromPathData : (Ljava/lang/String;)Landroid/graphics/Path;
    //   106: aload_0
    //   107: fload_3
    //   108: ldc_w 0.5
    //   111: fmul
    //   112: aload #6
    //   114: aload #4
    //   116: invokestatic a : (Landroid/graphics/Path;Landroid/animation/ObjectAnimator;FLjava/lang/String;Ljava/lang/String;)V
    //   119: return
    //   120: aload_0
    //   121: aload_1
    //   122: aload #4
    //   124: ldc_w 'propertyName'
    //   127: iconst_0
    //   128: invokestatic getNamedString : (Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;I)Ljava/lang/String;
    //   131: invokevirtual setPropertyName : (Ljava/lang/String;)V
    //   134: return
  }
  
  private static void a(ValueAnimator paramValueAnimator, TypedArray paramTypedArray1, TypedArray paramTypedArray2, float paramFloat, XmlPullParser paramXmlPullParser) {
    long l1 = TypedArrayUtils.getNamedInt(paramTypedArray1, paramXmlPullParser, "duration", 1, 300);
    long l2 = TypedArrayUtils.getNamedInt(paramTypedArray1, paramXmlPullParser, "startOffset", 2, 0);
    int i = TypedArrayUtils.getNamedInt(paramTypedArray1, paramXmlPullParser, "valueType", 7, 4);
    int j = i;
    if (TypedArrayUtils.hasAttribute(paramXmlPullParser, "valueFrom")) {
      j = i;
      if (TypedArrayUtils.hasAttribute(paramXmlPullParser, "valueTo")) {
        int k = i;
        if (i == 4)
          k = a(paramTypedArray1, 5, 6); 
        PropertyValuesHolder propertyValuesHolder = a(paramTypedArray1, k, 5, 6, "");
        j = k;
        if (propertyValuesHolder != null) {
          paramValueAnimator.setValues(new PropertyValuesHolder[] { propertyValuesHolder });
          j = k;
        } 
      } 
    } 
    paramValueAnimator.setDuration(l1);
    paramValueAnimator.setStartDelay(l2);
    paramValueAnimator.setRepeatCount(TypedArrayUtils.getNamedInt(paramTypedArray1, paramXmlPullParser, "repeatCount", 3, 0));
    paramValueAnimator.setRepeatMode(TypedArrayUtils.getNamedInt(paramTypedArray1, paramXmlPullParser, "repeatMode", 4, 1));
    if (paramTypedArray2 != null)
      a(paramValueAnimator, paramTypedArray2, j, paramFloat, paramXmlPullParser); 
  }
  
  private static void a(Path paramPath, ObjectAnimator paramObjectAnimator, float paramFloat, String paramString1, String paramString2) {
    PathMeasure pathMeasure = new PathMeasure(paramPath, false);
    ArrayList<Float> arrayList = new ArrayList();
    arrayList.add(Float.valueOf(0.0F));
    float f = 0.0F;
    while (true) {
      float f1 = f + pathMeasure.getLength();
      arrayList.add(Float.valueOf(f1));
      f = f1;
      if (!pathMeasure.nextContour()) {
        PathMeasure pathMeasure1 = new PathMeasure(paramPath, false);
        int k = Math.min(100, (int)(f1 / paramFloat) + 1);
        float[] arrayOfFloat2 = new float[k];
        float[] arrayOfFloat1 = new float[k];
        float[] arrayOfFloat3 = new float[2];
        f = f1 / (k - 1);
        int i = 0;
        paramFloat = 0.0F;
        int j = 0;
        while (true) {
          PropertyValuesHolder propertyValuesHolder;
          pathMeasure = null;
          if (i < k) {
            pathMeasure1.getPosTan(paramFloat - ((Float)arrayList.get(j)).floatValue(), arrayOfFloat3, null);
            arrayOfFloat2[i] = arrayOfFloat3[0];
            arrayOfFloat1[i] = arrayOfFloat3[1];
            paramFloat += f;
            int n = j + 1;
            int m = j;
            if (n < arrayList.size()) {
              m = j;
              if (paramFloat > ((Float)arrayList.get(n)).floatValue()) {
                pathMeasure1.nextContour();
                m = n;
              } 
            } 
            i++;
            j = m;
            continue;
          } 
          if (paramString1 != null) {
            PropertyValuesHolder propertyValuesHolder1 = PropertyValuesHolder.ofFloat(paramString1, arrayOfFloat2);
          } else {
            pathMeasure1 = null;
          } 
          PathMeasure pathMeasure2 = pathMeasure;
          if (paramString2 != null)
            propertyValuesHolder = PropertyValuesHolder.ofFloat(paramString2, arrayOfFloat1); 
          if (pathMeasure1 == null) {
            paramObjectAnimator.setValues(new PropertyValuesHolder[] { propertyValuesHolder });
            return;
          } 
          if (propertyValuesHolder == null) {
            paramObjectAnimator.setValues(new PropertyValuesHolder[] { (PropertyValuesHolder)pathMeasure1 });
            return;
          } 
          paramObjectAnimator.setValues(new PropertyValuesHolder[] { (PropertyValuesHolder)pathMeasure1, propertyValuesHolder });
          return;
        } 
        break;
      } 
    } 
  }
  
  private static void a(Keyframe[] paramArrayOfKeyframe, float paramFloat, int paramInt1, int paramInt2) {
    paramFloat /= (paramInt2 - paramInt1 + 2);
    while (paramInt1 <= paramInt2) {
      paramArrayOfKeyframe[paramInt1].setFraction(paramArrayOfKeyframe[paramInt1 - 1].getFraction() + paramFloat);
      paramInt1++;
    } 
  }
  
  private static boolean a(int paramInt) {
    return (paramInt >= 28 && paramInt <= 31);
  }
  
  private static PropertyValuesHolder[] a(Context paramContext, Resources paramResources, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet) throws XmlPullParserException, IOException {
    PropertyValuesHolder[] arrayOfPropertyValuesHolder;
    int i;
    ArrayList<PropertyValuesHolder> arrayList;
    Context context = null;
    PropertyValuesHolder propertyValuesHolder = null;
    while (true) {
      int j = paramXmlPullParser.getEventType();
      i = 0;
      if (j != 3 && j != 1) {
        if (j != 2) {
          paramXmlPullParser.next();
          continue;
        } 
        if (paramXmlPullParser.getName().equals("propertyValuesHolder")) {
          ArrayList<PropertyValuesHolder> arrayList1;
          TypedArray typedArray = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.STYLEABLE_PROPERTY_VALUES_HOLDER);
          String str = TypedArrayUtils.getNamedString(typedArray, paramXmlPullParser, "propertyName", 3);
          i = TypedArrayUtils.getNamedInt(typedArray, paramXmlPullParser, "valueType", 2, 4);
          PropertyValuesHolder propertyValuesHolder1 = a(paramContext, paramResources, paramTheme, paramXmlPullParser, str, i);
          PropertyValuesHolder propertyValuesHolder2 = propertyValuesHolder1;
          if (propertyValuesHolder1 == null)
            propertyValuesHolder2 = a(typedArray, i, 0, 1, str); 
          propertyValuesHolder1 = propertyValuesHolder;
          if (propertyValuesHolder2 != null) {
            propertyValuesHolder1 = propertyValuesHolder;
            if (propertyValuesHolder == null)
              arrayList1 = new ArrayList(); 
            arrayList1.add(propertyValuesHolder2);
          } 
          typedArray.recycle();
          arrayList = arrayList1;
        } 
        paramXmlPullParser.next();
        continue;
      } 
      break;
    } 
    paramContext = context;
    if (arrayList != null) {
      int j = arrayList.size();
      PropertyValuesHolder[] arrayOfPropertyValuesHolder1 = new PropertyValuesHolder[j];
      while (true) {
        arrayOfPropertyValuesHolder = arrayOfPropertyValuesHolder1;
        if (i < j) {
          arrayOfPropertyValuesHolder1[i] = arrayList.get(i);
          i++;
          continue;
        } 
        break;
      } 
    } 
    return arrayOfPropertyValuesHolder;
  }
  
  public static Animator loadAnimator(Context paramContext, int paramInt) throws Resources.NotFoundException {
    return (Build.VERSION.SDK_INT >= 24) ? AnimatorInflater.loadAnimator(paramContext, paramInt) : loadAnimator(paramContext, paramContext.getResources(), paramContext.getTheme(), paramInt);
  }
  
  public static Animator loadAnimator(Context paramContext, Resources paramResources, Resources.Theme paramTheme, int paramInt) throws Resources.NotFoundException {
    return loadAnimator(paramContext, paramResources, paramTheme, paramInt, 1.0F);
  }
  
  public static Animator loadAnimator(Context paramContext, Resources paramResources, Resources.Theme paramTheme, int paramInt, float paramFloat) throws Resources.NotFoundException {
    XmlResourceParser xmlResourceParser2 = null;
    XmlResourceParser xmlResourceParser3 = null;
    XmlResourceParser xmlResourceParser1 = null;
    try {
      XmlResourceParser xmlResourceParser = paramResources.getAnimation(paramInt);
      xmlResourceParser1 = xmlResourceParser;
      xmlResourceParser2 = xmlResourceParser;
      xmlResourceParser3 = xmlResourceParser;
      Animator animator = a(paramContext, paramResources, paramTheme, (XmlPullParser)xmlResourceParser, paramFloat);
      if (xmlResourceParser != null)
        xmlResourceParser.close(); 
      return animator;
    } catch (XmlPullParserException xmlPullParserException) {
      xmlResourceParser1 = xmlResourceParser3;
      StringBuilder stringBuilder = new StringBuilder();
      xmlResourceParser1 = xmlResourceParser3;
      stringBuilder.append("Can't load animation resource ID #0x");
      xmlResourceParser1 = xmlResourceParser3;
      stringBuilder.append(Integer.toHexString(paramInt));
      xmlResourceParser1 = xmlResourceParser3;
      Resources.NotFoundException notFoundException = new Resources.NotFoundException(stringBuilder.toString());
      xmlResourceParser1 = xmlResourceParser3;
      notFoundException.initCause((Throwable)xmlPullParserException);
      xmlResourceParser1 = xmlResourceParser3;
      throw notFoundException;
    } catch (IOException iOException) {
      xmlResourceParser1 = xmlResourceParser2;
      StringBuilder stringBuilder = new StringBuilder();
      xmlResourceParser1 = xmlResourceParser2;
      stringBuilder.append("Can't load animation resource ID #0x");
      xmlResourceParser1 = xmlResourceParser2;
      stringBuilder.append(Integer.toHexString(paramInt));
      xmlResourceParser1 = xmlResourceParser2;
      Resources.NotFoundException notFoundException = new Resources.NotFoundException(stringBuilder.toString());
      xmlResourceParser1 = xmlResourceParser2;
      notFoundException.initCause(iOException);
      xmlResourceParser1 = xmlResourceParser2;
      throw notFoundException;
    } finally {}
    if (xmlResourceParser1 != null)
      xmlResourceParser1.close(); 
    throw paramContext;
  }
  
  static class PathDataEvaluator implements TypeEvaluator<PathParser.PathDataNode[]> {
    private PathParser.PathDataNode[] a;
    
    public PathParser.PathDataNode[] evaluate(float param1Float, PathParser.PathDataNode[] param1ArrayOfPathDataNode1, PathParser.PathDataNode[] param1ArrayOfPathDataNode2) {
      if (PathParser.canMorph(param1ArrayOfPathDataNode1, param1ArrayOfPathDataNode2)) {
        if (!PathParser.canMorph(this.a, param1ArrayOfPathDataNode1))
          this.a = PathParser.deepCopyNodes(param1ArrayOfPathDataNode1); 
        int i;
        for (i = 0; i < param1ArrayOfPathDataNode1.length; i++)
          this.a[i].interpolatePathDataNode(param1ArrayOfPathDataNode1[i], param1ArrayOfPathDataNode2[i], param1Float); 
        return this.a;
      } 
      throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\vectordrawable\graphics\drawable\AnimatorInflaterCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */