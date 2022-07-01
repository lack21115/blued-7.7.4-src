package android.support.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.util.Stack;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class VectorDrawableCompat extends VectorDrawableCommon {
  static final PorterDuff.Mode DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
  
  boolean mAllowCaching = true;
  
  private ColorFilter mColorFilter;
  
  private boolean mMutated;
  
  private PorterDuffColorFilter mTintFilter;
  
  private final Rect mTmpBounds = new Rect();
  
  private final float[] mTmpFloats = new float[9];
  
  private final Matrix mTmpMatrix = new Matrix();
  
  private VectorDrawableCompat$VectorDrawableCompatState mVectorState = new VectorDrawableCompat$VectorDrawableCompatState();
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  VectorDrawableCompat() {}
  
  VectorDrawableCompat(VectorDrawableCompat$VectorDrawableCompatState paramVectorDrawableCompat$VectorDrawableCompatState) {
    this.mTintFilter = updateTintFilter$5c32a288(paramVectorDrawableCompat$VectorDrawableCompatState.mTint, paramVectorDrawableCompat$VectorDrawableCompatState.mTintMode);
  }
  
  static int applyAlpha(int paramInt, float paramFloat) {
    return paramInt & 0xFFFFFF | (int)(Color.alpha(paramInt) * paramFloat) << 24;
  }
  
  public static VectorDrawableCompat create(Resources paramResources, int paramInt, Resources.Theme paramTheme) {
    Drawable drawable;
    if (Build.VERSION.SDK_INT >= 24) {
      VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
      if (Build.VERSION.SDK_INT >= 21) {
        drawable = paramResources.getDrawable(paramInt, paramTheme);
      } else {
        drawable = drawable.getDrawable(paramInt);
      } 
      vectorDrawableCompat.mDelegateDrawable = drawable;
      new VectorDrawableCompat$VectorDrawableDelegateState(vectorDrawableCompat.mDelegateDrawable.getConstantState());
      return vectorDrawableCompat;
    } 
    try {
      XmlResourceParser xmlResourceParser = drawable.getXml(paramInt);
      AttributeSet attributeSet = Xml.asAttributeSet((XmlPullParser)xmlResourceParser);
      do {
        paramInt = xmlResourceParser.next();
      } while (paramInt != 2 && paramInt != 1);
      if (paramInt == 2)
        return createFromXmlInner((Resources)drawable, (XmlPullParser)xmlResourceParser, attributeSet, paramTheme); 
      throw new XmlPullParserException("No start tag found");
    } catch (XmlPullParserException xmlPullParserException) {
      Log.e("VectorDrawableCompat", "parser error", (Throwable)xmlPullParserException);
    } catch (IOException iOException) {
      Log.e("VectorDrawableCompat", "parser error", iOException);
    } 
    return null;
  }
  
  public static VectorDrawableCompat createFromXmlInner(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme) {
    VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
    vectorDrawableCompat.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    return vectorDrawableCompat;
  }
  
  private void inflateInternal(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme) {
    VectorDrawableCompat$VectorDrawableCompatState vectorDrawableCompat$VectorDrawableCompatState = this.mVectorState;
    VectorDrawableCompat$VPathRenderer vectorDrawableCompat$VPathRenderer = vectorDrawableCompat$VectorDrawableCompatState.mVPathRenderer;
    Stack<VectorDrawableCompat$VGroup> stack = new Stack();
    stack.push(vectorDrawableCompat$VPathRenderer.mRootGroup);
    int j = paramXmlPullParser.getEventType();
    int k = paramXmlPullParser.getDepth();
    int i;
    for (i = 1; j != 1 && (paramXmlPullParser.getDepth() >= k + 1 || j != 3); i = m) {
      int m;
      if (j == 2) {
        VectorDrawableCompat$VFullPath vectorDrawableCompat$VFullPath;
        String str = paramXmlPullParser.getName();
        VectorDrawableCompat$VGroup vectorDrawableCompat$VGroup = stack.peek();
        if ("path".equals(str)) {
          vectorDrawableCompat$VFullPath = new VectorDrawableCompat$VFullPath();
          TypedArray typedArray = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_PATH);
          vectorDrawableCompat$VFullPath.updateStateFromTypedArray(typedArray, paramXmlPullParser);
          typedArray.recycle();
          vectorDrawableCompat$VGroup.mChildren.add(vectorDrawableCompat$VFullPath);
          if (vectorDrawableCompat$VFullPath.getPathName() != null)
            vectorDrawableCompat$VPathRenderer.mVGTargetsMap.put(vectorDrawableCompat$VFullPath.getPathName(), vectorDrawableCompat$VFullPath); 
          i = vectorDrawableCompat$VectorDrawableCompatState.mChangingConfigurations;
          vectorDrawableCompat$VectorDrawableCompatState.mChangingConfigurations = vectorDrawableCompat$VFullPath.mChangingConfigurations | i;
          m = 0;
        } else {
          VectorDrawableCompat$VClipPath vectorDrawableCompat$VClipPath;
          if ("clip-path".equals(vectorDrawableCompat$VFullPath)) {
            vectorDrawableCompat$VClipPath = new VectorDrawableCompat$VClipPath();
            if (TypedArrayUtils.hasAttribute(paramXmlPullParser, "pathData")) {
              TypedArray typedArray = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_CLIP_PATH);
              vectorDrawableCompat$VClipPath.updateStateFromTypedArray(typedArray);
              typedArray.recycle();
            } 
            vectorDrawableCompat$VGroup.mChildren.add(vectorDrawableCompat$VClipPath);
            if (vectorDrawableCompat$VClipPath.getPathName() != null)
              vectorDrawableCompat$VPathRenderer.mVGTargetsMap.put(vectorDrawableCompat$VClipPath.getPathName(), vectorDrawableCompat$VClipPath); 
            m = vectorDrawableCompat$VectorDrawableCompatState.mChangingConfigurations;
            vectorDrawableCompat$VectorDrawableCompatState.mChangingConfigurations = vectorDrawableCompat$VClipPath.mChangingConfigurations | m;
            m = i;
          } else {
            if ("group".equals(vectorDrawableCompat$VClipPath)) {
              VectorDrawableCompat$VGroup vectorDrawableCompat$VGroup1 = new VectorDrawableCompat$VGroup();
              TypedArray typedArray = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_GROUP);
              vectorDrawableCompat$VGroup1.mThemeAttrs = null;
              vectorDrawableCompat$VGroup1.mRotate = TypedArrayUtils.getNamedFloat(typedArray, paramXmlPullParser, "rotation", 5, vectorDrawableCompat$VGroup1.mRotate);
              vectorDrawableCompat$VGroup1.mPivotX = typedArray.getFloat(1, vectorDrawableCompat$VGroup1.mPivotX);
              vectorDrawableCompat$VGroup1.mPivotY = typedArray.getFloat(2, vectorDrawableCompat$VGroup1.mPivotY);
              vectorDrawableCompat$VGroup1.mScaleX = TypedArrayUtils.getNamedFloat(typedArray, paramXmlPullParser, "scaleX", 3, vectorDrawableCompat$VGroup1.mScaleX);
              vectorDrawableCompat$VGroup1.mScaleY = TypedArrayUtils.getNamedFloat(typedArray, paramXmlPullParser, "scaleY", 4, vectorDrawableCompat$VGroup1.mScaleY);
              vectorDrawableCompat$VGroup1.mTranslateX = TypedArrayUtils.getNamedFloat(typedArray, paramXmlPullParser, "translateX", 6, vectorDrawableCompat$VGroup1.mTranslateX);
              vectorDrawableCompat$VGroup1.mTranslateY = TypedArrayUtils.getNamedFloat(typedArray, paramXmlPullParser, "translateY", 7, vectorDrawableCompat$VGroup1.mTranslateY);
              String str1 = typedArray.getString(0);
              if (str1 != null)
                vectorDrawableCompat$VGroup1.mGroupName = str1; 
              vectorDrawableCompat$VGroup1.updateLocalMatrix();
              typedArray.recycle();
              vectorDrawableCompat$VGroup.mChildren.add(vectorDrawableCompat$VGroup1);
              stack.push(vectorDrawableCompat$VGroup1);
              if (vectorDrawableCompat$VGroup1.getGroupName() != null)
                vectorDrawableCompat$VPathRenderer.mVGTargetsMap.put(vectorDrawableCompat$VGroup1.getGroupName(), vectorDrawableCompat$VGroup1); 
              int n = vectorDrawableCompat$VectorDrawableCompatState.mChangingConfigurations;
              vectorDrawableCompat$VectorDrawableCompatState.mChangingConfigurations = vectorDrawableCompat$VGroup1.mChangingConfigurations | n;
            } 
            m = i;
          } 
        } 
      } else {
        m = i;
        if (j == 3) {
          m = i;
          if ("group".equals(paramXmlPullParser.getName())) {
            stack.pop();
            m = i;
          } 
        } 
      } 
      j = paramXmlPullParser.next();
    } 
    if (i != 0) {
      StringBuffer stringBuffer = new StringBuffer();
      if (stringBuffer.length() > 0)
        stringBuffer.append(" or "); 
      stringBuffer.append("path");
      StringBuilder stringBuilder = new StringBuilder("no ");
      stringBuilder.append(stringBuffer);
      stringBuilder.append(" defined");
      throw new XmlPullParserException(stringBuilder.toString());
    } 
  }
  
  private PorterDuffColorFilter updateTintFilter$5c32a288(ColorStateList paramColorStateList, PorterDuff.Mode paramMode) {
    return (paramColorStateList == null || paramMode == null) ? null : new PorterDuffColorFilter(paramColorStateList.getColorForState(getState(), 0), paramMode);
  }
  
  public final boolean canApplyTheme() {
    if (this.mDelegateDrawable != null)
      DrawableCompat.canApplyTheme(this.mDelegateDrawable); 
    return false;
  }
  
  public final void draw(Canvas paramCanvas) {
    // Byte code:
    //   0: aload_0
    //   1: getfield mDelegateDrawable : Landroid/graphics/drawable/Drawable;
    //   4: ifnull -> 16
    //   7: aload_0
    //   8: getfield mDelegateDrawable : Landroid/graphics/drawable/Drawable;
    //   11: aload_1
    //   12: invokevirtual draw : (Landroid/graphics/Canvas;)V
    //   15: return
    //   16: aload_0
    //   17: aload_0
    //   18: getfield mTmpBounds : Landroid/graphics/Rect;
    //   21: invokevirtual copyBounds : (Landroid/graphics/Rect;)V
    //   24: aload_0
    //   25: getfield mTmpBounds : Landroid/graphics/Rect;
    //   28: invokevirtual width : ()I
    //   31: ifle -> 688
    //   34: aload_0
    //   35: getfield mTmpBounds : Landroid/graphics/Rect;
    //   38: invokevirtual height : ()I
    //   41: ifgt -> 45
    //   44: return
    //   45: aload_0
    //   46: getfield mColorFilter : Landroid/graphics/ColorFilter;
    //   49: ifnonnull -> 61
    //   52: aload_0
    //   53: getfield mTintFilter : Landroid/graphics/PorterDuffColorFilter;
    //   56: astore #11
    //   58: goto -> 67
    //   61: aload_0
    //   62: getfield mColorFilter : Landroid/graphics/ColorFilter;
    //   65: astore #11
    //   67: aload_1
    //   68: aload_0
    //   69: getfield mTmpMatrix : Landroid/graphics/Matrix;
    //   72: invokevirtual getMatrix : (Landroid/graphics/Matrix;)V
    //   75: aload_0
    //   76: getfield mTmpMatrix : Landroid/graphics/Matrix;
    //   79: aload_0
    //   80: getfield mTmpFloats : [F
    //   83: invokevirtual getValues : ([F)V
    //   86: aload_0
    //   87: getfield mTmpFloats : [F
    //   90: astore #12
    //   92: iconst_0
    //   93: istore #7
    //   95: aload #12
    //   97: iconst_0
    //   98: faload
    //   99: invokestatic abs : (F)F
    //   102: fstore_2
    //   103: aload_0
    //   104: getfield mTmpFloats : [F
    //   107: iconst_4
    //   108: faload
    //   109: invokestatic abs : (F)F
    //   112: fstore_3
    //   113: aload_0
    //   114: getfield mTmpFloats : [F
    //   117: iconst_1
    //   118: faload
    //   119: invokestatic abs : (F)F
    //   122: fstore #5
    //   124: aload_0
    //   125: getfield mTmpFloats : [F
    //   128: iconst_3
    //   129: faload
    //   130: invokestatic abs : (F)F
    //   133: fstore #4
    //   135: fload #5
    //   137: fconst_0
    //   138: fcmpl
    //   139: ifne -> 149
    //   142: fload #4
    //   144: fconst_0
    //   145: fcmpl
    //   146: ifeq -> 153
    //   149: fconst_1
    //   150: fstore_2
    //   151: fconst_1
    //   152: fstore_3
    //   153: aload_0
    //   154: getfield mTmpBounds : Landroid/graphics/Rect;
    //   157: invokevirtual width : ()I
    //   160: i2f
    //   161: fload_2
    //   162: fmul
    //   163: f2i
    //   164: istore #8
    //   166: aload_0
    //   167: getfield mTmpBounds : Landroid/graphics/Rect;
    //   170: invokevirtual height : ()I
    //   173: i2f
    //   174: fload_3
    //   175: fmul
    //   176: f2i
    //   177: istore #6
    //   179: sipush #2048
    //   182: iload #8
    //   184: invokestatic min : (II)I
    //   187: istore #9
    //   189: sipush #2048
    //   192: iload #6
    //   194: invokestatic min : (II)I
    //   197: istore #10
    //   199: iload #9
    //   201: ifle -> 687
    //   204: iload #10
    //   206: ifgt -> 210
    //   209: return
    //   210: aload_1
    //   211: invokevirtual save : ()I
    //   214: istore #8
    //   216: aload_1
    //   217: aload_0
    //   218: getfield mTmpBounds : Landroid/graphics/Rect;
    //   221: getfield left : I
    //   224: i2f
    //   225: aload_0
    //   226: getfield mTmpBounds : Landroid/graphics/Rect;
    //   229: getfield top : I
    //   232: i2f
    //   233: invokevirtual translate : (FF)V
    //   236: getstatic android/os/Build$VERSION.SDK_INT : I
    //   239: bipush #17
    //   241: if_icmplt -> 268
    //   244: aload_0
    //   245: invokevirtual isAutoMirrored : ()Z
    //   248: ifeq -> 265
    //   251: aload_0
    //   252: invokestatic getLayoutDirection : (Landroid/graphics/drawable/Drawable;)I
    //   255: iconst_1
    //   256: if_icmpne -> 265
    //   259: iconst_1
    //   260: istore #6
    //   262: goto -> 271
    //   265: goto -> 268
    //   268: iconst_0
    //   269: istore #6
    //   271: iload #6
    //   273: ifeq -> 297
    //   276: aload_1
    //   277: aload_0
    //   278: getfield mTmpBounds : Landroid/graphics/Rect;
    //   281: invokevirtual width : ()I
    //   284: i2f
    //   285: fconst_0
    //   286: invokevirtual translate : (FF)V
    //   289: aload_1
    //   290: ldc_w -1.0
    //   293: fconst_1
    //   294: invokevirtual scale : (FF)V
    //   297: aload_0
    //   298: getfield mTmpBounds : Landroid/graphics/Rect;
    //   301: iconst_0
    //   302: iconst_0
    //   303: invokevirtual offsetTo : (II)V
    //   306: aload_0
    //   307: getfield mVectorState : Landroid/support/graphics/drawable/VectorDrawableCompat$VectorDrawableCompatState;
    //   310: astore #12
    //   312: aload #12
    //   314: getfield mCachedBitmap : Landroid/graphics/Bitmap;
    //   317: ifnull -> 360
    //   320: iload #9
    //   322: aload #12
    //   324: getfield mCachedBitmap : Landroid/graphics/Bitmap;
    //   327: invokevirtual getWidth : ()I
    //   330: if_icmpne -> 352
    //   333: iload #10
    //   335: aload #12
    //   337: getfield mCachedBitmap : Landroid/graphics/Bitmap;
    //   340: invokevirtual getHeight : ()I
    //   343: if_icmpne -> 352
    //   346: iconst_1
    //   347: istore #6
    //   349: goto -> 355
    //   352: iconst_0
    //   353: istore #6
    //   355: iload #6
    //   357: ifne -> 381
    //   360: aload #12
    //   362: iload #9
    //   364: iload #10
    //   366: getstatic android/graphics/Bitmap$Config.ARGB_8888 : Landroid/graphics/Bitmap$Config;
    //   369: invokestatic createBitmap : (IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   372: putfield mCachedBitmap : Landroid/graphics/Bitmap;
    //   375: aload #12
    //   377: iconst_1
    //   378: putfield mCacheDirty : Z
    //   381: aload_0
    //   382: getfield mAllowCaching : Z
    //   385: ifne -> 402
    //   388: aload_0
    //   389: getfield mVectorState : Landroid/support/graphics/drawable/VectorDrawableCompat$VectorDrawableCompatState;
    //   392: iload #9
    //   394: iload #10
    //   396: invokevirtual updateCachedBitmap : (II)V
    //   399: goto -> 551
    //   402: aload_0
    //   403: getfield mVectorState : Landroid/support/graphics/drawable/VectorDrawableCompat$VectorDrawableCompatState;
    //   406: astore #12
    //   408: aload #12
    //   410: getfield mCacheDirty : Z
    //   413: ifne -> 477
    //   416: aload #12
    //   418: getfield mCachedTint : Landroid/content/res/ColorStateList;
    //   421: aload #12
    //   423: getfield mTint : Landroid/content/res/ColorStateList;
    //   426: if_acmpne -> 477
    //   429: aload #12
    //   431: getfield mCachedTintMode : Landroid/graphics/PorterDuff$Mode;
    //   434: aload #12
    //   436: getfield mTintMode : Landroid/graphics/PorterDuff$Mode;
    //   439: if_acmpne -> 477
    //   442: aload #12
    //   444: getfield mCachedAutoMirrored : Z
    //   447: aload #12
    //   449: getfield mAutoMirrored : Z
    //   452: if_icmpne -> 477
    //   455: aload #12
    //   457: getfield mCachedRootAlpha : I
    //   460: aload #12
    //   462: getfield mVPathRenderer : Landroid/support/graphics/drawable/VectorDrawableCompat$VPathRenderer;
    //   465: invokevirtual getRootAlpha : ()I
    //   468: if_icmpne -> 477
    //   471: iconst_1
    //   472: istore #6
    //   474: goto -> 480
    //   477: iconst_0
    //   478: istore #6
    //   480: iload #6
    //   482: ifne -> 551
    //   485: aload_0
    //   486: getfield mVectorState : Landroid/support/graphics/drawable/VectorDrawableCompat$VectorDrawableCompatState;
    //   489: iload #9
    //   491: iload #10
    //   493: invokevirtual updateCachedBitmap : (II)V
    //   496: aload_0
    //   497: getfield mVectorState : Landroid/support/graphics/drawable/VectorDrawableCompat$VectorDrawableCompatState;
    //   500: astore #12
    //   502: aload #12
    //   504: aload #12
    //   506: getfield mTint : Landroid/content/res/ColorStateList;
    //   509: putfield mCachedTint : Landroid/content/res/ColorStateList;
    //   512: aload #12
    //   514: aload #12
    //   516: getfield mTintMode : Landroid/graphics/PorterDuff$Mode;
    //   519: putfield mCachedTintMode : Landroid/graphics/PorterDuff$Mode;
    //   522: aload #12
    //   524: aload #12
    //   526: getfield mVPathRenderer : Landroid/support/graphics/drawable/VectorDrawableCompat$VPathRenderer;
    //   529: invokevirtual getRootAlpha : ()I
    //   532: putfield mCachedRootAlpha : I
    //   535: aload #12
    //   537: aload #12
    //   539: getfield mAutoMirrored : Z
    //   542: putfield mCachedAutoMirrored : Z
    //   545: aload #12
    //   547: iconst_0
    //   548: putfield mCacheDirty : Z
    //   551: aload_0
    //   552: getfield mVectorState : Landroid/support/graphics/drawable/VectorDrawableCompat$VectorDrawableCompatState;
    //   555: astore #12
    //   557: aload_0
    //   558: getfield mTmpBounds : Landroid/graphics/Rect;
    //   561: astore #13
    //   563: aload #12
    //   565: getfield mVPathRenderer : Landroid/support/graphics/drawable/VectorDrawableCompat$VPathRenderer;
    //   568: invokevirtual getRootAlpha : ()I
    //   571: sipush #255
    //   574: if_icmpge -> 583
    //   577: iconst_1
    //   578: istore #6
    //   580: goto -> 587
    //   583: iload #7
    //   585: istore #6
    //   587: iload #6
    //   589: ifne -> 603
    //   592: aload #11
    //   594: ifnonnull -> 603
    //   597: aconst_null
    //   598: astore #11
    //   600: goto -> 666
    //   603: aload #12
    //   605: getfield mTempPaint : Landroid/graphics/Paint;
    //   608: ifnonnull -> 632
    //   611: aload #12
    //   613: new android/graphics/Paint
    //   616: dup
    //   617: invokespecial <init> : ()V
    //   620: putfield mTempPaint : Landroid/graphics/Paint;
    //   623: aload #12
    //   625: getfield mTempPaint : Landroid/graphics/Paint;
    //   628: iconst_1
    //   629: invokevirtual setFilterBitmap : (Z)V
    //   632: aload #12
    //   634: getfield mTempPaint : Landroid/graphics/Paint;
    //   637: aload #12
    //   639: getfield mVPathRenderer : Landroid/support/graphics/drawable/VectorDrawableCompat$VPathRenderer;
    //   642: invokevirtual getRootAlpha : ()I
    //   645: invokevirtual setAlpha : (I)V
    //   648: aload #12
    //   650: getfield mTempPaint : Landroid/graphics/Paint;
    //   653: aload #11
    //   655: invokevirtual setColorFilter : (Landroid/graphics/ColorFilter;)Landroid/graphics/ColorFilter;
    //   658: pop
    //   659: aload #12
    //   661: getfield mTempPaint : Landroid/graphics/Paint;
    //   664: astore #11
    //   666: aload_1
    //   667: aload #12
    //   669: getfield mCachedBitmap : Landroid/graphics/Bitmap;
    //   672: aconst_null
    //   673: aload #13
    //   675: aload #11
    //   677: invokevirtual drawBitmap : (Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   680: aload_1
    //   681: iload #8
    //   683: invokevirtual restoreToCount : (I)V
    //   686: return
    //   687: return
    //   688: return
  }
  
  public final int getAlpha() {
    return (this.mDelegateDrawable != null) ? DrawableCompat.getAlpha(this.mDelegateDrawable) : this.mVectorState.mVPathRenderer.getRootAlpha();
  }
  
  public final int getChangingConfigurations() {
    return (this.mDelegateDrawable != null) ? this.mDelegateDrawable.getChangingConfigurations() : (super.getChangingConfigurations() | this.mVectorState.getChangingConfigurations());
  }
  
  public final Drawable.ConstantState getConstantState() {
    if (this.mDelegateDrawable != null && Build.VERSION.SDK_INT >= 24)
      return new VectorDrawableCompat$VectorDrawableDelegateState(this.mDelegateDrawable.getConstantState()); 
    this.mVectorState.mChangingConfigurations = getChangingConfigurations();
    return this.mVectorState;
  }
  
  public final int getIntrinsicHeight() {
    return (this.mDelegateDrawable != null) ? this.mDelegateDrawable.getIntrinsicHeight() : (int)this.mVectorState.mVPathRenderer.mBaseHeight;
  }
  
  public final int getIntrinsicWidth() {
    return (this.mDelegateDrawable != null) ? this.mDelegateDrawable.getIntrinsicWidth() : (int)this.mVectorState.mVPathRenderer.mBaseWidth;
  }
  
  public final int getOpacity() {
    return (this.mDelegateDrawable != null) ? this.mDelegateDrawable.getOpacity() : -3;
  }
  
  final Object getTargetByName(String paramString) {
    return this.mVectorState.mVPathRenderer.mVGTargetsMap.get(paramString);
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet) {
    if (this.mDelegateDrawable != null) {
      this.mDelegateDrawable.inflate(paramResources, paramXmlPullParser, paramAttributeSet);
      return;
    } 
    inflate(paramResources, paramXmlPullParser, paramAttributeSet, null);
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme) {
    if (this.mDelegateDrawable != null) {
      DrawableCompat.inflate(this.mDelegateDrawable, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return;
    } 
    VectorDrawableCompat$VectorDrawableCompatState vectorDrawableCompat$VectorDrawableCompatState1 = this.mVectorState;
    vectorDrawableCompat$VectorDrawableCompatState1.mVPathRenderer = new VectorDrawableCompat$VPathRenderer();
    TypedArray typedArray = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_TYPE_ARRAY);
    VectorDrawableCompat$VectorDrawableCompatState vectorDrawableCompat$VectorDrawableCompatState2 = this.mVectorState;
    VectorDrawableCompat$VPathRenderer vectorDrawableCompat$VPathRenderer = vectorDrawableCompat$VectorDrawableCompatState2.mVPathRenderer;
    int i = TypedArrayUtils.getNamedInt(typedArray, paramXmlPullParser, "tintMode", 6, -1);
    PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
    if (i != 3) {
      if (i != 5) {
        if (i != 9) {
          switch (i) {
            case 16:
              if (Build.VERSION.SDK_INT >= 11)
                mode = PorterDuff.Mode.ADD; 
              break;
            case 15:
              mode = PorterDuff.Mode.SCREEN;
              break;
            case 14:
              mode = PorterDuff.Mode.MULTIPLY;
              break;
          } 
        } else {
          mode = PorterDuff.Mode.SRC_ATOP;
        } 
      } else {
        mode = PorterDuff.Mode.SRC_IN;
      } 
    } else {
      mode = PorterDuff.Mode.SRC_OVER;
    } 
    vectorDrawableCompat$VectorDrawableCompatState2.mTintMode = mode;
    ColorStateList colorStateList = typedArray.getColorStateList(1);
    if (colorStateList != null)
      vectorDrawableCompat$VectorDrawableCompatState2.mTint = colorStateList; 
    boolean bool = vectorDrawableCompat$VectorDrawableCompatState2.mAutoMirrored;
    if (TypedArrayUtils.hasAttribute(paramXmlPullParser, "autoMirrored"))
      bool = typedArray.getBoolean(5, bool); 
    vectorDrawableCompat$VectorDrawableCompatState2.mAutoMirrored = bool;
    vectorDrawableCompat$VPathRenderer.mViewportWidth = TypedArrayUtils.getNamedFloat(typedArray, paramXmlPullParser, "viewportWidth", 7, vectorDrawableCompat$VPathRenderer.mViewportWidth);
    vectorDrawableCompat$VPathRenderer.mViewportHeight = TypedArrayUtils.getNamedFloat(typedArray, paramXmlPullParser, "viewportHeight", 8, vectorDrawableCompat$VPathRenderer.mViewportHeight);
    if (vectorDrawableCompat$VPathRenderer.mViewportWidth > 0.0F) {
      if (vectorDrawableCompat$VPathRenderer.mViewportHeight > 0.0F) {
        vectorDrawableCompat$VPathRenderer.mBaseWidth = typedArray.getDimension(3, vectorDrawableCompat$VPathRenderer.mBaseWidth);
        vectorDrawableCompat$VPathRenderer.mBaseHeight = typedArray.getDimension(2, vectorDrawableCompat$VPathRenderer.mBaseHeight);
        if (vectorDrawableCompat$VPathRenderer.mBaseWidth > 0.0F) {
          if (vectorDrawableCompat$VPathRenderer.mBaseHeight > 0.0F) {
            vectorDrawableCompat$VPathRenderer.setAlpha(TypedArrayUtils.getNamedFloat(typedArray, paramXmlPullParser, "alpha", 4, vectorDrawableCompat$VPathRenderer.getAlpha()));
            String str = typedArray.getString(0);
            if (str != null) {
              vectorDrawableCompat$VPathRenderer.mRootName = str;
              vectorDrawableCompat$VPathRenderer.mVGTargetsMap.put(str, vectorDrawableCompat$VPathRenderer);
            } 
            typedArray.recycle();
            vectorDrawableCompat$VectorDrawableCompatState1.mChangingConfigurations = getChangingConfigurations();
            vectorDrawableCompat$VectorDrawableCompatState1.mCacheDirty = true;
            inflateInternal(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
            this.mTintFilter = updateTintFilter$5c32a288(vectorDrawableCompat$VectorDrawableCompatState1.mTint, vectorDrawableCompat$VectorDrawableCompatState1.mTintMode);
            return;
          } 
          StringBuilder stringBuilder3 = new StringBuilder();
          stringBuilder3.append(typedArray.getPositionDescription());
          stringBuilder3.append("<vector> tag requires height > 0");
          throw new XmlPullParserException(stringBuilder3.toString());
        } 
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(typedArray.getPositionDescription());
        stringBuilder2.append("<vector> tag requires width > 0");
        throw new XmlPullParserException(stringBuilder2.toString());
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(typedArray.getPositionDescription());
      stringBuilder1.append("<vector> tag requires viewportHeight > 0");
      throw new XmlPullParserException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(typedArray.getPositionDescription());
    stringBuilder.append("<vector> tag requires viewportWidth > 0");
    throw new XmlPullParserException(stringBuilder.toString());
  }
  
  public final void invalidateSelf() {
    if (this.mDelegateDrawable != null) {
      this.mDelegateDrawable.invalidateSelf();
      return;
    } 
    super.invalidateSelf();
  }
  
  public final boolean isAutoMirrored() {
    return (this.mDelegateDrawable != null) ? DrawableCompat.isAutoMirrored(this.mDelegateDrawable) : this.mVectorState.mAutoMirrored;
  }
  
  public final boolean isStateful() {
    return (this.mDelegateDrawable != null) ? this.mDelegateDrawable.isStateful() : ((super.isStateful() || (this.mVectorState != null && this.mVectorState.mTint != null && this.mVectorState.mTint.isStateful())));
  }
  
  public final Drawable mutate() {
    if (this.mDelegateDrawable != null) {
      this.mDelegateDrawable.mutate();
      return this;
    } 
    if (!this.mMutated && super.mutate() == this) {
      this.mVectorState = new VectorDrawableCompat$VectorDrawableCompatState(this.mVectorState);
      this.mMutated = true;
    } 
    return this;
  }
  
  protected final void onBoundsChange(Rect paramRect) {
    if (this.mDelegateDrawable != null)
      this.mDelegateDrawable.setBounds(paramRect); 
  }
  
  protected final boolean onStateChange(int[] paramArrayOfint) {
    if (this.mDelegateDrawable != null)
      return this.mDelegateDrawable.setState(paramArrayOfint); 
    VectorDrawableCompat$VectorDrawableCompatState vectorDrawableCompat$VectorDrawableCompatState = this.mVectorState;
    if (vectorDrawableCompat$VectorDrawableCompatState.mTint != null && vectorDrawableCompat$VectorDrawableCompatState.mTintMode != null) {
      this.mTintFilter = updateTintFilter$5c32a288(vectorDrawableCompat$VectorDrawableCompatState.mTint, vectorDrawableCompat$VectorDrawableCompatState.mTintMode);
      invalidateSelf();
      return true;
    } 
    return false;
  }
  
  public final void scheduleSelf(Runnable paramRunnable, long paramLong) {
    if (this.mDelegateDrawable != null) {
      this.mDelegateDrawable.scheduleSelf(paramRunnable, paramLong);
      return;
    } 
    super.scheduleSelf(paramRunnable, paramLong);
  }
  
  public final void setAlpha(int paramInt) {
    if (this.mDelegateDrawable != null) {
      this.mDelegateDrawable.setAlpha(paramInt);
      return;
    } 
    if (this.mVectorState.mVPathRenderer.getRootAlpha() != paramInt) {
      this.mVectorState.mVPathRenderer.setRootAlpha(paramInt);
      invalidateSelf();
    } 
  }
  
  public final void setAutoMirrored(boolean paramBoolean) {
    if (this.mDelegateDrawable != null) {
      DrawableCompat.setAutoMirrored(this.mDelegateDrawable, paramBoolean);
      return;
    } 
    this.mVectorState.mAutoMirrored = paramBoolean;
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter) {
    if (this.mDelegateDrawable != null) {
      this.mDelegateDrawable.setColorFilter(paramColorFilter);
      return;
    } 
    this.mColorFilter = paramColorFilter;
    invalidateSelf();
  }
  
  public final void setTint(int paramInt) {
    if (this.mDelegateDrawable != null) {
      DrawableCompat.setTint(this.mDelegateDrawable, paramInt);
      return;
    } 
    setTintList(ColorStateList.valueOf(paramInt));
  }
  
  public final void setTintList(ColorStateList paramColorStateList) {
    if (this.mDelegateDrawable != null) {
      DrawableCompat.setTintList(this.mDelegateDrawable, paramColorStateList);
      return;
    } 
    VectorDrawableCompat$VectorDrawableCompatState vectorDrawableCompat$VectorDrawableCompatState = this.mVectorState;
    if (vectorDrawableCompat$VectorDrawableCompatState.mTint != paramColorStateList) {
      vectorDrawableCompat$VectorDrawableCompatState.mTint = paramColorStateList;
      this.mTintFilter = updateTintFilter$5c32a288(paramColorStateList, vectorDrawableCompat$VectorDrawableCompatState.mTintMode);
      invalidateSelf();
    } 
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode) {
    if (this.mDelegateDrawable != null) {
      DrawableCompat.setTintMode(this.mDelegateDrawable, paramMode);
      return;
    } 
    VectorDrawableCompat$VectorDrawableCompatState vectorDrawableCompat$VectorDrawableCompatState = this.mVectorState;
    if (vectorDrawableCompat$VectorDrawableCompatState.mTintMode != paramMode) {
      vectorDrawableCompat$VectorDrawableCompatState.mTintMode = paramMode;
      this.mTintFilter = updateTintFilter$5c32a288(vectorDrawableCompat$VectorDrawableCompatState.mTint, paramMode);
      invalidateSelf();
    } 
  }
  
  public final boolean setVisible(boolean paramBoolean1, boolean paramBoolean2) {
    return (this.mDelegateDrawable != null) ? this.mDelegateDrawable.setVisible(paramBoolean1, paramBoolean2) : super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public final void unscheduleSelf(Runnable paramRunnable) {
    if (this.mDelegateDrawable != null) {
      this.mDelegateDrawable.unscheduleSelf(paramRunnable);
      return;
    } 
    super.unscheduleSelf(paramRunnable);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\graphics\drawable\VectorDrawableCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */