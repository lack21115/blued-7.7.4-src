package android.support.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.graphics.PathParser;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class AnimatorInflaterCompat {
  private static Animator createAnimatorFromXml(Context paramContext, Resources paramResources, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, AnimatorSet paramAnimatorSet, int paramInt, float paramFloat) {
    int i;
    AnimatorSet animatorSet;
    ArrayList<AnimatorSet> arrayList;
    int j = paramXmlPullParser.getDepth();
    ObjectAnimator objectAnimator = null;
    String str = null;
    while (true) {
      int k = paramXmlPullParser.next();
      i = 0;
      boolean bool = false;
      if ((k != 3 || paramXmlPullParser.getDepth() > j) && k != 1) {
        if (k == 2) {
          ArrayList<AnimatorSet> arrayList1;
          String str1 = paramXmlPullParser.getName();
          if (str1.equals("objectAnimator")) {
            objectAnimator = new ObjectAnimator();
            loadAnimator(paramContext, paramResources, paramTheme, paramAttributeSet, (ValueAnimator)objectAnimator, paramFloat, paramXmlPullParser);
          } else if (str1.equals("animator")) {
            ValueAnimator valueAnimator = loadAnimator(paramContext, paramResources, paramTheme, paramAttributeSet, null, paramFloat, paramXmlPullParser);
          } else {
            TypedArray typedArray;
            if (str1.equals("set")) {
              animatorSet = new AnimatorSet();
              typedArray = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.STYLEABLE_ANIMATOR_SET);
              i = TypedArrayUtils.getNamedInt(typedArray, paramXmlPullParser, "ordering", 0, 0);
              createAnimatorFromXml(paramContext, paramResources, paramTheme, paramXmlPullParser, paramAttributeSet, animatorSet, i, paramFloat);
              typedArray.recycle();
            } else if (typedArray.equals("propertyValuesHolder")) {
              PropertyValuesHolder[] arrayOfPropertyValuesHolder = loadValues(paramContext, paramResources, paramTheme, paramXmlPullParser, Xml.asAttributeSet(paramXmlPullParser));
              if (arrayOfPropertyValuesHolder != null && animatorSet != null && animatorSet instanceof ValueAnimator)
                ((ValueAnimator)animatorSet).setValues(arrayOfPropertyValuesHolder); 
              bool = true;
            } else {
              StringBuilder stringBuilder = new StringBuilder("Unknown animator name: ");
              stringBuilder.append(paramXmlPullParser.getName());
              throw new RuntimeException(stringBuilder.toString());
            } 
          } 
          str1 = str;
          if (paramAnimatorSet != null) {
            str1 = str;
            if (!bool) {
              str1 = str;
              if (str == null)
                arrayList1 = new ArrayList(); 
              arrayList1.add(animatorSet);
            } 
          } 
          arrayList = arrayList1;
        } 
        continue;
      } 
      break;
    } 
    if (paramAnimatorSet != null && arrayList != null) {
      Animator[] arrayOfAnimator = new Animator[arrayList.size()];
      Iterator<AnimatorSet> iterator = arrayList.iterator();
      int k;
      for (k = i; iterator.hasNext(); k++)
        arrayOfAnimator[k] = (Animator)iterator.next(); 
      if (paramInt == 0) {
        paramAnimatorSet.playTogether(arrayOfAnimator);
        return (Animator)animatorSet;
      } 
      paramAnimatorSet.playSequentially(arrayOfAnimator);
    } 
    return (Animator)animatorSet;
  }
  
  private static Keyframe createNewKeyframe(Keyframe paramKeyframe, float paramFloat) {
    return (paramKeyframe.getType() == float.class) ? Keyframe.ofFloat(paramFloat) : ((paramKeyframe.getType() == int.class) ? Keyframe.ofInt(paramFloat) : Keyframe.ofObject(paramFloat));
  }
  
  private static void distributeKeyframes(Keyframe[] paramArrayOfKeyframe, float paramFloat, int paramInt1, int paramInt2) {
    paramFloat /= (paramInt2 - paramInt1 + 2);
    while (paramInt1 <= paramInt2) {
      paramArrayOfKeyframe[paramInt1].setFraction(paramArrayOfKeyframe[paramInt1 - 1].getFraction() + paramFloat);
      paramInt1++;
    } 
  }
  
  private static PropertyValuesHolder getPVH(TypedArray paramTypedArray, int paramInt1, int paramInt2, int paramInt3, String paramString) {
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
    //   93: invokestatic isColorType : (I)Z
    //   96: ifne -> 112
    //   99: iload #9
    //   101: ifeq -> 118
    //   104: iload #11
    //   106: invokestatic isColorType : (I)Z
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
    //   134: astore #14
    //   136: aconst_null
    //   137: astore #12
    //   139: iload #7
    //   141: iconst_2
    //   142: if_icmpne -> 328
    //   145: aload_0
    //   146: iload_2
    //   147: invokevirtual getString : (I)Ljava/lang/String;
    //   150: astore #13
    //   152: aload_0
    //   153: iload_3
    //   154: invokevirtual getString : (I)Ljava/lang/String;
    //   157: astore #14
    //   159: aload #13
    //   161: invokestatic createNodesFromPathData : (Ljava/lang/String;)[Landroid/support/v4/graphics/PathParser$PathDataNode;
    //   164: astore #15
    //   166: aload #14
    //   168: invokestatic createNodesFromPathData : (Ljava/lang/String;)[Landroid/support/v4/graphics/PathParser$PathDataNode;
    //   171: astore #16
    //   173: aload #15
    //   175: ifnonnull -> 186
    //   178: aload #12
    //   180: astore_0
    //   181: aload #16
    //   183: ifnull -> 326
    //   186: aload #15
    //   188: ifnull -> 295
    //   191: new android/support/graphics/drawable/AnimatorInflaterCompat$PathDataEvaluator
    //   194: dup
    //   195: iconst_0
    //   196: invokespecial <init> : (B)V
    //   199: astore_0
    //   200: aload #16
    //   202: ifnull -> 279
    //   205: aload #15
    //   207: aload #16
    //   209: invokestatic canMorph : ([Landroid/support/v4/graphics/PathParser$PathDataNode;[Landroid/support/v4/graphics/PathParser$PathDataNode;)Z
    //   212: ifeq -> 236
    //   215: aload #4
    //   217: aload_0
    //   218: iconst_2
    //   219: anewarray java/lang/Object
    //   222: dup
    //   223: iconst_0
    //   224: aload #15
    //   226: aastore
    //   227: dup
    //   228: iconst_1
    //   229: aload #16
    //   231: aastore
    //   232: invokestatic ofObject : (Ljava/lang/String;Landroid/animation/TypeEvaluator;[Ljava/lang/Object;)Landroid/animation/PropertyValuesHolder;
    //   235: areturn
    //   236: new java/lang/StringBuilder
    //   239: dup
    //   240: ldc ' Can't morph from '
    //   242: invokespecial <init> : (Ljava/lang/String;)V
    //   245: astore_0
    //   246: aload_0
    //   247: aload #13
    //   249: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload_0
    //   254: ldc ' to '
    //   256: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload_0
    //   261: aload #14
    //   263: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: new android/view/InflateException
    //   270: dup
    //   271: aload_0
    //   272: invokevirtual toString : ()Ljava/lang/String;
    //   275: invokespecial <init> : (Ljava/lang/String;)V
    //   278: athrow
    //   279: aload #4
    //   281: aload_0
    //   282: iconst_1
    //   283: anewarray java/lang/Object
    //   286: dup
    //   287: iconst_0
    //   288: aload #15
    //   290: aastore
    //   291: invokestatic ofObject : (Ljava/lang/String;Landroid/animation/TypeEvaluator;[Ljava/lang/Object;)Landroid/animation/PropertyValuesHolder;
    //   294: areturn
    //   295: aload #12
    //   297: astore_0
    //   298: aload #16
    //   300: ifnull -> 326
    //   303: aload #4
    //   305: new android/support/graphics/drawable/AnimatorInflaterCompat$PathDataEvaluator
    //   308: dup
    //   309: iconst_0
    //   310: invokespecial <init> : (B)V
    //   313: iconst_1
    //   314: anewarray java/lang/Object
    //   317: dup
    //   318: iconst_0
    //   319: aload #16
    //   321: aastore
    //   322: invokestatic ofObject : (Ljava/lang/String;Landroid/animation/TypeEvaluator;[Ljava/lang/Object;)Landroid/animation/PropertyValuesHolder;
    //   325: astore_0
    //   326: aload_0
    //   327: areturn
    //   328: iload #7
    //   330: iconst_3
    //   331: if_icmpne -> 342
    //   334: invokestatic getInstance : ()Landroid/support/graphics/drawable/ArgbEvaluator;
    //   337: astore #13
    //   339: goto -> 345
    //   342: aconst_null
    //   343: astore #13
    //   345: iload_1
    //   346: ifeq -> 493
    //   349: iload #8
    //   351: ifeq -> 450
    //   354: iload #10
    //   356: iconst_5
    //   357: if_icmpne -> 371
    //   360: aload_0
    //   361: iload_2
    //   362: fconst_0
    //   363: invokevirtual getDimension : (IF)F
    //   366: fstore #5
    //   368: goto -> 379
    //   371: aload_0
    //   372: iload_2
    //   373: fconst_0
    //   374: invokevirtual getFloat : (IF)F
    //   377: fstore #5
    //   379: iload #9
    //   381: ifeq -> 432
    //   384: iload #11
    //   386: iconst_5
    //   387: if_icmpne -> 401
    //   390: aload_0
    //   391: iload_3
    //   392: fconst_0
    //   393: invokevirtual getDimension : (IF)F
    //   396: fstore #6
    //   398: goto -> 409
    //   401: aload_0
    //   402: iload_3
    //   403: fconst_0
    //   404: invokevirtual getFloat : (IF)F
    //   407: fstore #6
    //   409: aload #4
    //   411: iconst_2
    //   412: newarray float
    //   414: dup
    //   415: iconst_0
    //   416: fload #5
    //   418: fastore
    //   419: dup
    //   420: iconst_1
    //   421: fload #6
    //   423: fastore
    //   424: invokestatic ofFloat : (Ljava/lang/String;[F)Landroid/animation/PropertyValuesHolder;
    //   427: astore #12
    //   429: goto -> 690
    //   432: aload #4
    //   434: iconst_1
    //   435: newarray float
    //   437: dup
    //   438: iconst_0
    //   439: fload #5
    //   441: fastore
    //   442: invokestatic ofFloat : (Ljava/lang/String;[F)Landroid/animation/PropertyValuesHolder;
    //   445: astore #12
    //   447: goto -> 690
    //   450: iload #11
    //   452: iconst_5
    //   453: if_icmpne -> 467
    //   456: aload_0
    //   457: iload_3
    //   458: fconst_0
    //   459: invokevirtual getDimension : (IF)F
    //   462: fstore #5
    //   464: goto -> 475
    //   467: aload_0
    //   468: iload_3
    //   469: fconst_0
    //   470: invokevirtual getFloat : (IF)F
    //   473: fstore #5
    //   475: aload #4
    //   477: iconst_1
    //   478: newarray float
    //   480: dup
    //   481: iconst_0
    //   482: fload #5
    //   484: fastore
    //   485: invokestatic ofFloat : (Ljava/lang/String;[F)Landroid/animation/PropertyValuesHolder;
    //   488: astore #12
    //   490: goto -> 690
    //   493: iload #8
    //   495: ifeq -> 625
    //   498: iload #10
    //   500: iconst_5
    //   501: if_icmpne -> 515
    //   504: aload_0
    //   505: iload_2
    //   506: fconst_0
    //   507: invokevirtual getDimension : (IF)F
    //   510: f2i
    //   511: istore_1
    //   512: goto -> 540
    //   515: iload #10
    //   517: invokestatic isColorType : (I)Z
    //   520: ifeq -> 533
    //   523: aload_0
    //   524: iload_2
    //   525: iconst_0
    //   526: invokevirtual getColor : (II)I
    //   529: istore_1
    //   530: goto -> 540
    //   533: aload_0
    //   534: iload_2
    //   535: iconst_0
    //   536: invokevirtual getInt : (II)I
    //   539: istore_1
    //   540: iload #9
    //   542: ifeq -> 608
    //   545: iload #11
    //   547: iconst_5
    //   548: if_icmpne -> 562
    //   551: aload_0
    //   552: iload_3
    //   553: fconst_0
    //   554: invokevirtual getDimension : (IF)F
    //   557: f2i
    //   558: istore_2
    //   559: goto -> 587
    //   562: iload #11
    //   564: invokestatic isColorType : (I)Z
    //   567: ifeq -> 580
    //   570: aload_0
    //   571: iload_3
    //   572: iconst_0
    //   573: invokevirtual getColor : (II)I
    //   576: istore_2
    //   577: goto -> 587
    //   580: aload_0
    //   581: iload_3
    //   582: iconst_0
    //   583: invokevirtual getInt : (II)I
    //   586: istore_2
    //   587: aload #4
    //   589: iconst_2
    //   590: newarray int
    //   592: dup
    //   593: iconst_0
    //   594: iload_1
    //   595: iastore
    //   596: dup
    //   597: iconst_1
    //   598: iload_2
    //   599: iastore
    //   600: invokestatic ofInt : (Ljava/lang/String;[I)Landroid/animation/PropertyValuesHolder;
    //   603: astore #12
    //   605: goto -> 690
    //   608: aload #4
    //   610: iconst_1
    //   611: newarray int
    //   613: dup
    //   614: iconst_0
    //   615: iload_1
    //   616: iastore
    //   617: invokestatic ofInt : (Ljava/lang/String;[I)Landroid/animation/PropertyValuesHolder;
    //   620: astore #12
    //   622: goto -> 690
    //   625: aload #14
    //   627: astore #12
    //   629: iload #9
    //   631: ifeq -> 690
    //   634: iload #11
    //   636: iconst_5
    //   637: if_icmpne -> 651
    //   640: aload_0
    //   641: iload_3
    //   642: fconst_0
    //   643: invokevirtual getDimension : (IF)F
    //   646: f2i
    //   647: istore_1
    //   648: goto -> 676
    //   651: iload #11
    //   653: invokestatic isColorType : (I)Z
    //   656: ifeq -> 669
    //   659: aload_0
    //   660: iload_3
    //   661: iconst_0
    //   662: invokevirtual getColor : (II)I
    //   665: istore_1
    //   666: goto -> 676
    //   669: aload_0
    //   670: iload_3
    //   671: iconst_0
    //   672: invokevirtual getInt : (II)I
    //   675: istore_1
    //   676: aload #4
    //   678: iconst_1
    //   679: newarray int
    //   681: dup
    //   682: iconst_0
    //   683: iload_1
    //   684: iastore
    //   685: invokestatic ofInt : (Ljava/lang/String;[I)Landroid/animation/PropertyValuesHolder;
    //   688: astore #12
    //   690: aload #12
    //   692: ifnull -> 707
    //   695: aload #13
    //   697: ifnull -> 707
    //   700: aload #12
    //   702: aload #13
    //   704: invokevirtual setEvaluator : (Landroid/animation/TypeEvaluator;)V
    //   707: aload #12
    //   709: areturn
  }
  
  private static boolean isColorType(int paramInt) {
    return (paramInt >= 28 && paramInt <= 31);
  }
  
  public static Animator loadAnimator(Context paramContext, Resources paramResources, Resources.Theme paramTheme, int paramInt, float paramFloat) {
    Context context2 = null;
    Context context3 = null;
    XmlResourceParser xmlResourceParser = null;
    try {
      XmlResourceParser xmlResourceParser1 = paramResources.getAnimation(paramInt);
    } catch (XmlPullParserException xmlPullParserException) {
    
    } catch (IOException iOException) {
      paramContext = context2;
      context1 = paramContext;
      StringBuilder stringBuilder1 = new StringBuilder("Can't load animation resource ID #0x");
      context1 = paramContext;
      stringBuilder1.append(Integer.toHexString(paramInt));
      context1 = paramContext;
      Resources.NotFoundException notFoundException1 = new Resources.NotFoundException(stringBuilder1.toString());
      context1 = paramContext;
      notFoundException1.initCause(iOException);
      context1 = paramContext;
      throw notFoundException1;
    } finally {
      if (context1 != null)
        context1.close(); 
    } 
    Context context1 = paramContext;
    StringBuilder stringBuilder = new StringBuilder("Can't load animation resource ID #0x");
    context1 = paramContext;
    stringBuilder.append(Integer.toHexString(paramInt));
    context1 = paramContext;
    Resources.NotFoundException notFoundException = new Resources.NotFoundException(stringBuilder.toString());
    context1 = paramContext;
    notFoundException.initCause(iOException);
    context1 = paramContext;
    throw notFoundException;
  }
  
  private static ValueAnimator loadAnimator(Context paramContext, Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, ValueAnimator paramValueAnimator, float paramFloat, XmlPullParser paramXmlPullParser) {
    TypedArray typedArray2 = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.STYLEABLE_ANIMATOR);
    TypedArray typedArray1 = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.STYLEABLE_PROPERTY_ANIMATOR);
    ValueAnimator valueAnimator = paramValueAnimator;
    if (paramValueAnimator == null)
      valueAnimator = new ValueAnimator(); 
    parseAnimatorFromTypeArray(valueAnimator, typedArray2, typedArray1, paramFloat, paramXmlPullParser);
    int i = TypedArrayUtils.getNamedResourceId(typedArray2, paramXmlPullParser, "interpolator", 0, 0);
    if (i > 0)
      valueAnimator.setInterpolator((TimeInterpolator)AnimationUtilsCompat.loadInterpolator(paramContext, i)); 
    typedArray2.recycle();
    if (typedArray1 != null)
      typedArray1.recycle(); 
    return valueAnimator;
  }
  
  private static PropertyValuesHolder[] loadValues(Context paramContext, Resources paramResources, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #13
    //   3: aload_3
    //   4: invokeinterface getEventType : ()I
    //   9: istore #6
    //   11: iload #6
    //   13: iconst_3
    //   14: if_icmpeq -> 944
    //   17: iload #6
    //   19: iconst_1
    //   20: if_icmpeq -> 944
    //   23: iload #6
    //   25: iconst_2
    //   26: if_icmpeq -> 39
    //   29: aload_3
    //   30: invokeinterface next : ()I
    //   35: pop
    //   36: goto -> 3
    //   39: aload_3
    //   40: invokeinterface getName : ()Ljava/lang/String;
    //   45: ldc 'propertyValuesHolder'
    //   47: invokevirtual equals : (Ljava/lang/Object;)Z
    //   50: ifeq -> 934
    //   53: aload_1
    //   54: aload_2
    //   55: aload #4
    //   57: getstatic android/support/graphics/drawable/AndroidResources.STYLEABLE_PROPERTY_VALUES_HOLDER : [I
    //   60: invokestatic obtainAttributes : (Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   63: astore #17
    //   65: aload #17
    //   67: aload_3
    //   68: ldc_w 'propertyName'
    //   71: iconst_3
    //   72: invokestatic getNamedString : (Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;I)Ljava/lang/String;
    //   75: astore #18
    //   77: aload #17
    //   79: aload_3
    //   80: ldc_w 'valueType'
    //   83: iconst_2
    //   84: iconst_4
    //   85: invokestatic getNamedInt : (Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;II)I
    //   88: istore #11
    //   90: iload #11
    //   92: istore #7
    //   94: aconst_null
    //   95: astore #14
    //   97: aload_3
    //   98: invokeinterface next : ()I
    //   103: istore #6
    //   105: iload #6
    //   107: iconst_3
    //   108: if_icmpeq -> 507
    //   111: iload #6
    //   113: iconst_1
    //   114: if_icmpeq -> 507
    //   117: aload_3
    //   118: invokeinterface getName : ()Ljava/lang/String;
    //   123: ldc_w 'keyframe'
    //   126: invokevirtual equals : (Ljava/lang/Object;)Z
    //   129: ifeq -> 496
    //   132: iload #7
    //   134: istore #6
    //   136: iload #7
    //   138: iconst_4
    //   139: if_icmpne -> 212
    //   142: aload_1
    //   143: aload_2
    //   144: aload_3
    //   145: invokestatic asAttributeSet : (Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;
    //   148: getstatic android/support/graphics/drawable/AndroidResources.STYLEABLE_KEYFRAME : [I
    //   151: invokestatic obtainAttributes : (Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   154: astore #15
    //   156: aload #15
    //   158: aload_3
    //   159: ldc_w 'value'
    //   162: iconst_0
    //   163: invokestatic peekNamedValue : (Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;I)Landroid/util/TypedValue;
    //   166: astore #16
    //   168: aload #16
    //   170: ifnull -> 179
    //   173: iconst_1
    //   174: istore #6
    //   176: goto -> 182
    //   179: iconst_0
    //   180: istore #6
    //   182: iload #6
    //   184: ifeq -> 204
    //   187: aload #16
    //   189: getfield type : I
    //   192: invokestatic isColorType : (I)Z
    //   195: ifeq -> 204
    //   198: iconst_3
    //   199: istore #6
    //   201: goto -> 207
    //   204: iconst_0
    //   205: istore #6
    //   207: aload #15
    //   209: invokevirtual recycle : ()V
    //   212: aload_1
    //   213: aload_2
    //   214: aload_3
    //   215: invokestatic asAttributeSet : (Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;
    //   218: getstatic android/support/graphics/drawable/AndroidResources.STYLEABLE_KEYFRAME : [I
    //   221: invokestatic obtainAttributes : (Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   224: astore #16
    //   226: aload #16
    //   228: aload_3
    //   229: ldc_w 'fraction'
    //   232: iconst_3
    //   233: ldc_w -1.0
    //   236: invokestatic getNamedFloat : (Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;IF)F
    //   239: fstore #5
    //   241: aload #16
    //   243: aload_3
    //   244: ldc_w 'value'
    //   247: iconst_0
    //   248: invokestatic peekNamedValue : (Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;I)Landroid/util/TypedValue;
    //   251: astore #15
    //   253: aload #15
    //   255: ifnull -> 264
    //   258: iconst_1
    //   259: istore #8
    //   261: goto -> 267
    //   264: iconst_0
    //   265: istore #8
    //   267: iload #6
    //   269: iconst_4
    //   270: if_icmpne -> 301
    //   273: iload #8
    //   275: ifeq -> 295
    //   278: aload #15
    //   280: getfield type : I
    //   283: invokestatic isColorType : (I)Z
    //   286: ifeq -> 295
    //   289: iconst_3
    //   290: istore #7
    //   292: goto -> 305
    //   295: iconst_0
    //   296: istore #7
    //   298: goto -> 305
    //   301: iload #6
    //   303: istore #7
    //   305: iload #8
    //   307: ifeq -> 388
    //   310: iload #7
    //   312: iconst_3
    //   313: if_icmpeq -> 367
    //   316: iload #7
    //   318: tableswitch default -> 340, 0 -> 346, 1 -> 367
    //   340: aconst_null
    //   341: astore #15
    //   343: goto -> 385
    //   346: fload #5
    //   348: aload #16
    //   350: aload_3
    //   351: ldc_w 'value'
    //   354: iconst_0
    //   355: fconst_0
    //   356: invokestatic getNamedFloat : (Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;IF)F
    //   359: invokestatic ofFloat : (FF)Landroid/animation/Keyframe;
    //   362: astore #15
    //   364: goto -> 410
    //   367: fload #5
    //   369: aload #16
    //   371: aload_3
    //   372: ldc_w 'value'
    //   375: iconst_0
    //   376: iconst_0
    //   377: invokestatic getNamedInt : (Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;II)I
    //   380: invokestatic ofInt : (FI)Landroid/animation/Keyframe;
    //   383: astore #15
    //   385: goto -> 410
    //   388: iload #7
    //   390: ifne -> 403
    //   393: fload #5
    //   395: invokestatic ofFloat : (F)Landroid/animation/Keyframe;
    //   398: astore #15
    //   400: goto -> 410
    //   403: fload #5
    //   405: invokestatic ofInt : (F)Landroid/animation/Keyframe;
    //   408: astore #15
    //   410: aload #16
    //   412: aload_3
    //   413: ldc_w 'interpolator'
    //   416: iconst_1
    //   417: iconst_0
    //   418: invokestatic getNamedResourceId : (Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;II)I
    //   421: istore #7
    //   423: iload #7
    //   425: ifle -> 442
    //   428: aload #15
    //   430: aload_0
    //   431: iload #7
    //   433: invokestatic loadInterpolator : (Landroid/content/Context;I)Landroid/view/animation/Interpolator;
    //   436: invokevirtual setInterpolator : (Landroid/animation/TimeInterpolator;)V
    //   439: goto -> 442
    //   442: aload #16
    //   444: invokevirtual recycle : ()V
    //   447: aload #14
    //   449: astore #16
    //   451: aload #15
    //   453: ifnull -> 482
    //   456: aload #14
    //   458: astore #16
    //   460: aload #14
    //   462: ifnonnull -> 474
    //   465: new java/util/ArrayList
    //   468: dup
    //   469: invokespecial <init> : ()V
    //   472: astore #16
    //   474: aload #16
    //   476: aload #15
    //   478: invokevirtual add : (Ljava/lang/Object;)Z
    //   481: pop
    //   482: aload_3
    //   483: invokeinterface next : ()I
    //   488: pop
    //   489: aload #16
    //   491: astore #14
    //   493: goto -> 500
    //   496: iload #7
    //   498: istore #6
    //   500: iload #6
    //   502: istore #7
    //   504: goto -> 97
    //   507: aload #14
    //   509: ifnull -> 862
    //   512: aload #14
    //   514: invokevirtual size : ()I
    //   517: istore #8
    //   519: iload #8
    //   521: ifle -> 862
    //   524: aload #14
    //   526: iconst_0
    //   527: invokevirtual get : (I)Ljava/lang/Object;
    //   530: checkcast android/animation/Keyframe
    //   533: astore #15
    //   535: aload #14
    //   537: iload #8
    //   539: iconst_1
    //   540: isub
    //   541: invokevirtual get : (I)Ljava/lang/Object;
    //   544: checkcast android/animation/Keyframe
    //   547: astore #16
    //   549: aload #16
    //   551: invokevirtual getFraction : ()F
    //   554: fstore #5
    //   556: iload #8
    //   558: istore #6
    //   560: fload #5
    //   562: fconst_1
    //   563: fcmpg
    //   564: ifge -> 609
    //   567: fload #5
    //   569: fconst_0
    //   570: fcmpg
    //   571: ifge -> 587
    //   574: aload #16
    //   576: fconst_1
    //   577: invokevirtual setFraction : (F)V
    //   580: iload #8
    //   582: istore #6
    //   584: goto -> 609
    //   587: aload #14
    //   589: aload #14
    //   591: invokevirtual size : ()I
    //   594: aload #16
    //   596: fconst_1
    //   597: invokestatic createNewKeyframe : (Landroid/animation/Keyframe;F)Landroid/animation/Keyframe;
    //   600: invokevirtual add : (ILjava/lang/Object;)V
    //   603: iload #8
    //   605: iconst_1
    //   606: iadd
    //   607: istore #6
    //   609: aload #15
    //   611: invokevirtual getFraction : ()F
    //   614: fstore #5
    //   616: iload #6
    //   618: istore #9
    //   620: fload #5
    //   622: fconst_0
    //   623: fcmpl
    //   624: ifeq -> 665
    //   627: fload #5
    //   629: fconst_0
    //   630: fcmpg
    //   631: ifge -> 647
    //   634: aload #15
    //   636: fconst_0
    //   637: invokevirtual setFraction : (F)V
    //   640: iload #6
    //   642: istore #9
    //   644: goto -> 665
    //   647: aload #14
    //   649: iconst_0
    //   650: aload #15
    //   652: fconst_0
    //   653: invokestatic createNewKeyframe : (Landroid/animation/Keyframe;F)Landroid/animation/Keyframe;
    //   656: invokevirtual add : (ILjava/lang/Object;)V
    //   659: iload #6
    //   661: iconst_1
    //   662: iadd
    //   663: istore #9
    //   665: iload #9
    //   667: anewarray android/animation/Keyframe
    //   670: astore #15
    //   672: aload #14
    //   674: aload #15
    //   676: invokevirtual toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
    //   679: pop
    //   680: iconst_0
    //   681: istore #6
    //   683: iload #6
    //   685: iload #9
    //   687: if_icmpge -> 828
    //   690: aload #15
    //   692: iload #6
    //   694: aaload
    //   695: astore #14
    //   697: aload #14
    //   699: invokevirtual getFraction : ()F
    //   702: fconst_0
    //   703: fcmpg
    //   704: ifge -> 819
    //   707: iload #6
    //   709: ifne -> 721
    //   712: aload #14
    //   714: fconst_0
    //   715: invokevirtual setFraction : (F)V
    //   718: goto -> 819
    //   721: iload #9
    //   723: iconst_1
    //   724: isub
    //   725: istore #12
    //   727: iload #6
    //   729: iload #12
    //   731: if_icmpne -> 743
    //   734: aload #14
    //   736: fconst_1
    //   737: invokevirtual setFraction : (F)V
    //   740: goto -> 819
    //   743: iload #6
    //   745: iconst_1
    //   746: iadd
    //   747: istore #8
    //   749: iload #6
    //   751: istore #10
    //   753: iload #8
    //   755: iload #12
    //   757: if_icmpge -> 786
    //   760: aload #15
    //   762: iload #8
    //   764: aaload
    //   765: invokevirtual getFraction : ()F
    //   768: fconst_0
    //   769: fcmpl
    //   770: ifge -> 786
    //   773: iload #8
    //   775: istore #10
    //   777: iload #8
    //   779: iconst_1
    //   780: iadd
    //   781: istore #8
    //   783: goto -> 753
    //   786: aload #15
    //   788: aload #15
    //   790: iload #10
    //   792: iconst_1
    //   793: iadd
    //   794: aaload
    //   795: invokevirtual getFraction : ()F
    //   798: aload #15
    //   800: iload #6
    //   802: iconst_1
    //   803: isub
    //   804: aaload
    //   805: invokevirtual getFraction : ()F
    //   808: fsub
    //   809: iload #6
    //   811: iload #10
    //   813: invokestatic distributeKeyframes : ([Landroid/animation/Keyframe;FII)V
    //   816: goto -> 819
    //   819: iload #6
    //   821: iconst_1
    //   822: iadd
    //   823: istore #6
    //   825: goto -> 683
    //   828: aload #18
    //   830: aload #15
    //   832: invokestatic ofKeyframe : (Ljava/lang/String;[Landroid/animation/Keyframe;)Landroid/animation/PropertyValuesHolder;
    //   835: astore #15
    //   837: aload #15
    //   839: astore #14
    //   841: iload #7
    //   843: iconst_3
    //   844: if_icmpne -> 865
    //   847: aload #15
    //   849: invokestatic getInstance : ()Landroid/support/graphics/drawable/ArgbEvaluator;
    //   852: invokevirtual setEvaluator : (Landroid/animation/TypeEvaluator;)V
    //   855: aload #15
    //   857: astore #14
    //   859: goto -> 865
    //   862: aconst_null
    //   863: astore #14
    //   865: aload #14
    //   867: astore #15
    //   869: aload #14
    //   871: ifnonnull -> 887
    //   874: aload #17
    //   876: iload #11
    //   878: iconst_0
    //   879: iconst_1
    //   880: aload #18
    //   882: invokestatic getPVH : (Landroid/content/res/TypedArray;IIILjava/lang/String;)Landroid/animation/PropertyValuesHolder;
    //   885: astore #15
    //   887: aload #13
    //   889: astore #14
    //   891: aload #15
    //   893: ifnull -> 922
    //   896: aload #13
    //   898: astore #14
    //   900: aload #13
    //   902: ifnonnull -> 914
    //   905: new java/util/ArrayList
    //   908: dup
    //   909: invokespecial <init> : ()V
    //   912: astore #14
    //   914: aload #14
    //   916: aload #15
    //   918: invokevirtual add : (Ljava/lang/Object;)Z
    //   921: pop
    //   922: aload #17
    //   924: invokevirtual recycle : ()V
    //   927: aload #14
    //   929: astore #13
    //   931: goto -> 934
    //   934: aload_3
    //   935: invokeinterface next : ()I
    //   940: pop
    //   941: goto -> 3
    //   944: iconst_0
    //   945: istore #6
    //   947: aload #13
    //   949: ifnull -> 997
    //   952: aload #13
    //   954: invokevirtual size : ()I
    //   957: istore #7
    //   959: iload #7
    //   961: anewarray android/animation/PropertyValuesHolder
    //   964: astore_0
    //   965: iload #6
    //   967: iload #7
    //   969: if_icmpge -> 995
    //   972: aload_0
    //   973: iload #6
    //   975: aload #13
    //   977: iload #6
    //   979: invokevirtual get : (I)Ljava/lang/Object;
    //   982: checkcast android/animation/PropertyValuesHolder
    //   985: aastore
    //   986: iload #6
    //   988: iconst_1
    //   989: iadd
    //   990: istore #6
    //   992: goto -> 965
    //   995: aload_0
    //   996: areturn
    //   997: aconst_null
    //   998: areturn
  }
  
  private static void parseAnimatorFromTypeArray(ValueAnimator paramValueAnimator, TypedArray paramTypedArray1, TypedArray paramTypedArray2, float paramFloat, XmlPullParser paramXmlPullParser) {
    long l1 = TypedArrayUtils.getNamedInt(paramTypedArray1, paramXmlPullParser, "duration", 1, 300);
    long l2 = TypedArrayUtils.getNamedInt(paramTypedArray1, paramXmlPullParser, "startOffset", 2, 0);
    int i = TypedArrayUtils.getNamedInt(paramTypedArray1, paramXmlPullParser, "valueType", 7, 4);
    if (TypedArrayUtils.hasAttribute(paramXmlPullParser, "valueFrom") && TypedArrayUtils.hasAttribute(paramXmlPullParser, "valueTo")) {
      int j = i;
      if (i == 4) {
        boolean bool1;
        boolean bool2;
        TypedValue typedValue = paramTypedArray1.peekValue(5);
        if (typedValue != null) {
          j = 1;
        } else {
          j = 0;
        } 
        if (j != 0) {
          i = typedValue.type;
        } else {
          i = 0;
        } 
        typedValue = paramTypedArray1.peekValue(6);
        if (typedValue != null) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        if (bool1) {
          bool2 = typedValue.type;
        } else {
          bool2 = false;
        } 
        if ((j != 0 && isColorType(i)) || (bool1 && isColorType(bool2))) {
          j = 3;
        } else {
          j = 0;
        } 
      } 
      PropertyValuesHolder propertyValuesHolder = getPVH(paramTypedArray1, j, 5, 6, "");
      if (propertyValuesHolder != null)
        paramValueAnimator.setValues(new PropertyValuesHolder[] { propertyValuesHolder }); 
    } 
    paramValueAnimator.setDuration(l1);
    paramValueAnimator.setStartDelay(l2);
    paramValueAnimator.setRepeatCount(TypedArrayUtils.getNamedInt(paramTypedArray1, paramXmlPullParser, "repeatCount", 3, 0));
    paramValueAnimator.setRepeatMode(TypedArrayUtils.getNamedInt(paramTypedArray1, paramXmlPullParser, "repeatMode", 4, 1));
    if (paramTypedArray2 != null) {
      StringBuilder stringBuilder;
      String str2;
      ObjectAnimator objectAnimator = (ObjectAnimator)paramValueAnimator;
      String str1 = TypedArrayUtils.getNamedString(paramTypedArray2, paramXmlPullParser, "pathData", 1);
      if (str1 != null) {
        String str = TypedArrayUtils.getNamedString(paramTypedArray2, paramXmlPullParser, "propertyXName", 2);
        str2 = TypedArrayUtils.getNamedString(paramTypedArray2, paramXmlPullParser, "propertyYName", 3);
        if (str != null || str2 != null) {
          setupPathMotion(PathParser.createPathFromPathData(str1), objectAnimator, 0.5F * paramFloat, str, str2);
          return;
        } 
        stringBuilder = new StringBuilder();
        stringBuilder.append(paramTypedArray2.getPositionDescription());
        stringBuilder.append(" propertyXName or propertyYName is needed for PathData");
        throw new InflateException(stringBuilder.toString());
      } 
      stringBuilder.setPropertyName(TypedArrayUtils.getNamedString(paramTypedArray2, (XmlPullParser)str2, "propertyName", 0));
    } 
  }
  
  private static void setupPathMotion(Path paramPath, ObjectAnimator paramObjectAnimator, float paramFloat, String paramString1, String paramString2) {
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
        f1 /= (k - 1);
        int i = 0;
        paramFloat = 0.0F;
        int j = 0;
        while (true) {
          PropertyValuesHolder propertyValuesHolder;
          pathMeasure = null;
          if (i < k) {
            pathMeasure1.getPosTan(paramFloat, arrayOfFloat3, null);
            pathMeasure1.getPosTan(paramFloat, arrayOfFloat3, null);
            arrayOfFloat2[i] = arrayOfFloat3[0];
            arrayOfFloat1[i] = arrayOfFloat3[1];
            f = paramFloat + f1;
            int n = j + 1;
            paramFloat = f;
            int m = j;
            if (n < arrayList.size()) {
              paramFloat = f;
              m = j;
              if (f > ((Float)arrayList.get(n)).floatValue()) {
                paramFloat = f - ((Float)arrayList.get(n)).floatValue();
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
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\graphics\drawable\AnimatorInflaterCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */