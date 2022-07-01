package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class ConstraintSet {
  public static final int BASELINE = 5;
  
  public static final int BOTTOM = 4;
  
  public static final int CHAIN_PACKED = 2;
  
  public static final int CHAIN_SPREAD = 0;
  
  public static final int CHAIN_SPREAD_INSIDE = 1;
  
  public static final int END = 7;
  
  public static final int GONE = 8;
  
  public static final int HORIZONTAL = 0;
  
  public static final int HORIZONTAL_GUIDELINE = 0;
  
  public static final int INVISIBLE = 4;
  
  public static final int LEFT = 1;
  
  public static final int MATCH_CONSTRAINT = 0;
  
  public static final int MATCH_CONSTRAINT_SPREAD = 0;
  
  public static final int MATCH_CONSTRAINT_WRAP = 1;
  
  public static final int PARENT_ID = 0;
  
  public static final int RIGHT = 2;
  
  public static final int START = 6;
  
  public static final int TOP = 3;
  
  public static final int UNSET = -1;
  
  public static final int VERTICAL = 1;
  
  public static final int VERTICAL_GUIDELINE = 1;
  
  public static final int VISIBLE = 0;
  
  public static final int WRAP_CONTENT = -2;
  
  private static final int[] a = new int[] { 0, 4, 8 };
  
  private static SparseIntArray c = new SparseIntArray();
  
  private HashMap<Integer, Constraint> b = new HashMap<Integer, Constraint>();
  
  static {
    c.append(R.styleable.ConstraintSet_layout_constraintLeft_toLeftOf, 25);
    c.append(R.styleable.ConstraintSet_layout_constraintLeft_toRightOf, 26);
    c.append(R.styleable.ConstraintSet_layout_constraintRight_toLeftOf, 29);
    c.append(R.styleable.ConstraintSet_layout_constraintRight_toRightOf, 30);
    c.append(R.styleable.ConstraintSet_layout_constraintTop_toTopOf, 36);
    c.append(R.styleable.ConstraintSet_layout_constraintTop_toBottomOf, 35);
    c.append(R.styleable.ConstraintSet_layout_constraintBottom_toTopOf, 4);
    c.append(R.styleable.ConstraintSet_layout_constraintBottom_toBottomOf, 3);
    c.append(R.styleable.ConstraintSet_layout_constraintBaseline_toBaselineOf, 1);
    c.append(R.styleable.ConstraintSet_layout_editor_absoluteX, 6);
    c.append(R.styleable.ConstraintSet_layout_editor_absoluteY, 7);
    c.append(R.styleable.ConstraintSet_layout_constraintGuide_begin, 17);
    c.append(R.styleable.ConstraintSet_layout_constraintGuide_end, 18);
    c.append(R.styleable.ConstraintSet_layout_constraintGuide_percent, 19);
    c.append(R.styleable.ConstraintSet_android_orientation, 27);
    c.append(R.styleable.ConstraintSet_layout_constraintStart_toEndOf, 32);
    c.append(R.styleable.ConstraintSet_layout_constraintStart_toStartOf, 33);
    c.append(R.styleable.ConstraintSet_layout_constraintEnd_toStartOf, 10);
    c.append(R.styleable.ConstraintSet_layout_constraintEnd_toEndOf, 9);
    c.append(R.styleable.ConstraintSet_layout_goneMarginLeft, 13);
    c.append(R.styleable.ConstraintSet_layout_goneMarginTop, 16);
    c.append(R.styleable.ConstraintSet_layout_goneMarginRight, 14);
    c.append(R.styleable.ConstraintSet_layout_goneMarginBottom, 11);
    c.append(R.styleable.ConstraintSet_layout_goneMarginStart, 15);
    c.append(R.styleable.ConstraintSet_layout_goneMarginEnd, 12);
    c.append(R.styleable.ConstraintSet_layout_constraintVertical_weight, 40);
    c.append(R.styleable.ConstraintSet_layout_constraintHorizontal_weight, 39);
    c.append(R.styleable.ConstraintSet_layout_constraintHorizontal_chainStyle, 41);
    c.append(R.styleable.ConstraintSet_layout_constraintVertical_chainStyle, 42);
    c.append(R.styleable.ConstraintSet_layout_constraintHorizontal_bias, 20);
    c.append(R.styleable.ConstraintSet_layout_constraintVertical_bias, 37);
    c.append(R.styleable.ConstraintSet_layout_constraintDimensionRatio, 5);
    c.append(R.styleable.ConstraintSet_layout_constraintLeft_creator, 75);
    c.append(R.styleable.ConstraintSet_layout_constraintTop_creator, 75);
    c.append(R.styleable.ConstraintSet_layout_constraintRight_creator, 75);
    c.append(R.styleable.ConstraintSet_layout_constraintBottom_creator, 75);
    c.append(R.styleable.ConstraintSet_layout_constraintBaseline_creator, 75);
    c.append(R.styleable.ConstraintSet_android_layout_marginLeft, 24);
    c.append(R.styleable.ConstraintSet_android_layout_marginRight, 28);
    c.append(R.styleable.ConstraintSet_android_layout_marginStart, 31);
    c.append(R.styleable.ConstraintSet_android_layout_marginEnd, 8);
    c.append(R.styleable.ConstraintSet_android_layout_marginTop, 34);
    c.append(R.styleable.ConstraintSet_android_layout_marginBottom, 2);
    c.append(R.styleable.ConstraintSet_android_layout_width, 23);
    c.append(R.styleable.ConstraintSet_android_layout_height, 21);
    c.append(R.styleable.ConstraintSet_android_visibility, 22);
    c.append(R.styleable.ConstraintSet_android_alpha, 43);
    c.append(R.styleable.ConstraintSet_android_elevation, 44);
    c.append(R.styleable.ConstraintSet_android_rotationX, 45);
    c.append(R.styleable.ConstraintSet_android_rotationY, 46);
    c.append(R.styleable.ConstraintSet_android_rotation, 60);
    c.append(R.styleable.ConstraintSet_android_scaleX, 47);
    c.append(R.styleable.ConstraintSet_android_scaleY, 48);
    c.append(R.styleable.ConstraintSet_android_transformPivotX, 49);
    c.append(R.styleable.ConstraintSet_android_transformPivotY, 50);
    c.append(R.styleable.ConstraintSet_android_translationX, 51);
    c.append(R.styleable.ConstraintSet_android_translationY, 52);
    c.append(R.styleable.ConstraintSet_android_translationZ, 53);
    c.append(R.styleable.ConstraintSet_layout_constraintWidth_default, 54);
    c.append(R.styleable.ConstraintSet_layout_constraintHeight_default, 55);
    c.append(R.styleable.ConstraintSet_layout_constraintWidth_max, 56);
    c.append(R.styleable.ConstraintSet_layout_constraintHeight_max, 57);
    c.append(R.styleable.ConstraintSet_layout_constraintWidth_min, 58);
    c.append(R.styleable.ConstraintSet_layout_constraintHeight_min, 59);
    c.append(R.styleable.ConstraintSet_layout_constraintCircle, 61);
    c.append(R.styleable.ConstraintSet_layout_constraintCircleRadius, 62);
    c.append(R.styleable.ConstraintSet_layout_constraintCircleAngle, 63);
    c.append(R.styleable.ConstraintSet_android_id, 38);
    c.append(R.styleable.ConstraintSet_layout_constraintWidth_percent, 69);
    c.append(R.styleable.ConstraintSet_layout_constraintHeight_percent, 70);
    c.append(R.styleable.ConstraintSet_chainUseRtl, 71);
    c.append(R.styleable.ConstraintSet_barrierDirection, 72);
    c.append(R.styleable.ConstraintSet_constraint_referenced_ids, 73);
    c.append(R.styleable.ConstraintSet_barrierAllowsGoneWidgets, 74);
  }
  
  private static int a(TypedArray paramTypedArray, int paramInt1, int paramInt2) {
    int i = paramTypedArray.getResourceId(paramInt1, paramInt2);
    paramInt2 = i;
    if (i == -1)
      paramInt2 = paramTypedArray.getInt(paramInt1, -1); 
    return paramInt2;
  }
  
  private Constraint a(int paramInt) {
    if (!this.b.containsKey(Integer.valueOf(paramInt)))
      this.b.put(Integer.valueOf(paramInt), new Constraint()); 
    return this.b.get(Integer.valueOf(paramInt));
  }
  
  private Constraint a(Context paramContext, AttributeSet paramAttributeSet) {
    Constraint constraint = new Constraint();
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintSet);
    a(constraint, typedArray);
    typedArray.recycle();
    return constraint;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint, float[] paramArrayOffloat, int paramInt5, int paramInt6, int paramInt7) {
    if (paramArrayOfint.length >= 2) {
      if (paramArrayOffloat == null || paramArrayOffloat.length == paramArrayOfint.length) {
        if (paramArrayOffloat != null)
          (a(paramArrayOfint[0])).horizontalWeight = paramArrayOffloat[0]; 
        (a(paramArrayOfint[0])).horizontalChainStyle = paramInt5;
        connect(paramArrayOfint[0], paramInt6, paramInt1, paramInt2, -1);
        for (paramInt1 = 1; paramInt1 < paramArrayOfint.length; paramInt1++) {
          paramInt2 = paramArrayOfint[paramInt1];
          paramInt2 = paramArrayOfint[paramInt1];
          paramInt5 = paramInt1 - 1;
          connect(paramInt2, paramInt6, paramArrayOfint[paramInt5], paramInt7, -1);
          connect(paramArrayOfint[paramInt5], paramInt7, paramArrayOfint[paramInt1], paramInt6, -1);
          if (paramArrayOffloat != null)
            (a(paramArrayOfint[paramInt1])).horizontalWeight = paramArrayOffloat[paramInt1]; 
        } 
        connect(paramArrayOfint[paramArrayOfint.length - 1], paramInt7, paramInt3, paramInt4, -1);
        return;
      } 
      throw new IllegalArgumentException("must have 2 or more widgets in a chain");
    } 
    throw new IllegalArgumentException("must have 2 or more widgets in a chain");
  }
  
  private void a(Constraint paramConstraint, TypedArray paramTypedArray) {
    int j = paramTypedArray.getIndexCount();
    for (int i = 0; i < j; i++) {
      StringBuilder stringBuilder;
      int k = paramTypedArray.getIndex(i);
      int m = c.get(k);
      switch (m) {
        default:
          switch (m) {
            default:
              switch (m) {
                default:
                  stringBuilder = new StringBuilder();
                  stringBuilder.append("Unknown attribute 0x");
                  stringBuilder.append(Integer.toHexString(k));
                  stringBuilder.append("   ");
                  stringBuilder.append(c.get(k));
                  Log.w("ConstraintSet", stringBuilder.toString());
                  break;
                case 75:
                  stringBuilder = new StringBuilder();
                  stringBuilder.append("unused attribute 0x");
                  stringBuilder.append(Integer.toHexString(k));
                  stringBuilder.append("   ");
                  stringBuilder.append(c.get(k));
                  Log.w("ConstraintSet", stringBuilder.toString());
                  break;
                case 74:
                  paramConstraint.mBarrierAllowsGoneWidgets = paramTypedArray.getBoolean(k, paramConstraint.mBarrierAllowsGoneWidgets);
                  break;
                case 73:
                  paramConstraint.mReferenceIdString = paramTypedArray.getString(k);
                  break;
                case 72:
                  paramConstraint.mBarrierDirection = paramTypedArray.getInt(k, paramConstraint.mBarrierDirection);
                  break;
                case 71:
                  Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                  break;
                case 70:
                  paramConstraint.heightPercent = paramTypedArray.getFloat(k, 1.0F);
                  break;
                case 69:
                  break;
              } 
              paramConstraint.widthPercent = paramTypedArray.getFloat(k, 1.0F);
              break;
            case 63:
              paramConstraint.circleAngle = paramTypedArray.getFloat(k, paramConstraint.circleAngle);
              break;
            case 62:
              paramConstraint.circleRadius = paramTypedArray.getDimensionPixelSize(k, paramConstraint.circleRadius);
              break;
            case 61:
              paramConstraint.circleConstraint = a(paramTypedArray, k, paramConstraint.circleConstraint);
              break;
            case 60:
              break;
          } 
          paramConstraint.rotation = paramTypedArray.getFloat(k, paramConstraint.rotation);
          break;
        case 53:
          paramConstraint.translationZ = paramTypedArray.getDimension(k, paramConstraint.translationZ);
          break;
        case 52:
          paramConstraint.translationY = paramTypedArray.getDimension(k, paramConstraint.translationY);
          break;
        case 51:
          paramConstraint.translationX = paramTypedArray.getDimension(k, paramConstraint.translationX);
          break;
        case 50:
          paramConstraint.transformPivotY = paramTypedArray.getFloat(k, paramConstraint.transformPivotY);
          break;
        case 49:
          paramConstraint.transformPivotX = paramTypedArray.getFloat(k, paramConstraint.transformPivotX);
          break;
        case 48:
          paramConstraint.scaleY = paramTypedArray.getFloat(k, paramConstraint.scaleY);
          break;
        case 47:
          paramConstraint.scaleX = paramTypedArray.getFloat(k, paramConstraint.scaleX);
          break;
        case 46:
          paramConstraint.rotationY = paramTypedArray.getFloat(k, paramConstraint.rotationY);
          break;
        case 45:
          paramConstraint.rotationX = paramTypedArray.getFloat(k, paramConstraint.rotationX);
          break;
        case 44:
          paramConstraint.applyElevation = true;
          paramConstraint.elevation = paramTypedArray.getDimension(k, paramConstraint.elevation);
          break;
        case 43:
          paramConstraint.alpha = paramTypedArray.getFloat(k, paramConstraint.alpha);
          break;
        case 42:
          paramConstraint.verticalChainStyle = paramTypedArray.getInt(k, paramConstraint.verticalChainStyle);
          break;
        case 41:
          paramConstraint.horizontalChainStyle = paramTypedArray.getInt(k, paramConstraint.horizontalChainStyle);
          break;
        case 40:
          paramConstraint.verticalWeight = paramTypedArray.getFloat(k, paramConstraint.verticalWeight);
          break;
        case 39:
          paramConstraint.horizontalWeight = paramTypedArray.getFloat(k, paramConstraint.horizontalWeight);
          break;
        case 38:
          paramConstraint.b = paramTypedArray.getResourceId(k, paramConstraint.b);
          break;
        case 37:
          paramConstraint.verticalBias = paramTypedArray.getFloat(k, paramConstraint.verticalBias);
          break;
        case 36:
          paramConstraint.topToTop = a(paramTypedArray, k, paramConstraint.topToTop);
          break;
        case 35:
          paramConstraint.topToBottom = a(paramTypedArray, k, paramConstraint.topToBottom);
          break;
        case 34:
          paramConstraint.topMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.topMargin);
          break;
        case 33:
          paramConstraint.startToStart = a(paramTypedArray, k, paramConstraint.startToStart);
          break;
        case 32:
          paramConstraint.startToEnd = a(paramTypedArray, k, paramConstraint.startToEnd);
          break;
        case 31:
          paramConstraint.startMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.startMargin);
          break;
        case 30:
          paramConstraint.rightToRight = a(paramTypedArray, k, paramConstraint.rightToRight);
          break;
        case 29:
          paramConstraint.rightToLeft = a(paramTypedArray, k, paramConstraint.rightToLeft);
          break;
        case 28:
          paramConstraint.rightMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.rightMargin);
          break;
        case 27:
          paramConstraint.orientation = paramTypedArray.getInt(k, paramConstraint.orientation);
          break;
        case 26:
          paramConstraint.leftToRight = a(paramTypedArray, k, paramConstraint.leftToRight);
          break;
        case 25:
          paramConstraint.leftToLeft = a(paramTypedArray, k, paramConstraint.leftToLeft);
          break;
        case 24:
          paramConstraint.leftMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.leftMargin);
          break;
        case 23:
          paramConstraint.mWidth = paramTypedArray.getLayoutDimension(k, paramConstraint.mWidth);
          break;
        case 22:
          paramConstraint.visibility = paramTypedArray.getInt(k, paramConstraint.visibility);
          paramConstraint.visibility = a[paramConstraint.visibility];
          break;
        case 21:
          paramConstraint.mHeight = paramTypedArray.getLayoutDimension(k, paramConstraint.mHeight);
          break;
        case 20:
          paramConstraint.horizontalBias = paramTypedArray.getFloat(k, paramConstraint.horizontalBias);
          break;
        case 19:
          paramConstraint.guidePercent = paramTypedArray.getFloat(k, paramConstraint.guidePercent);
          break;
        case 18:
          paramConstraint.guideEnd = paramTypedArray.getDimensionPixelOffset(k, paramConstraint.guideEnd);
          break;
        case 17:
          paramConstraint.guideBegin = paramTypedArray.getDimensionPixelOffset(k, paramConstraint.guideBegin);
          break;
        case 16:
          paramConstraint.goneTopMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.goneTopMargin);
          break;
        case 15:
          paramConstraint.goneStartMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.goneStartMargin);
          break;
        case 14:
          paramConstraint.goneRightMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.goneRightMargin);
          break;
        case 13:
          paramConstraint.goneLeftMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.goneLeftMargin);
          break;
        case 12:
          paramConstraint.goneEndMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.goneEndMargin);
          break;
        case 11:
          paramConstraint.goneBottomMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.goneBottomMargin);
          break;
        case 10:
          paramConstraint.endToStart = a(paramTypedArray, k, paramConstraint.endToStart);
          break;
        case 9:
          paramConstraint.endToEnd = a(paramTypedArray, k, paramConstraint.endToEnd);
          break;
        case 8:
          paramConstraint.endMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.endMargin);
          break;
        case 7:
          paramConstraint.editorAbsoluteY = paramTypedArray.getDimensionPixelOffset(k, paramConstraint.editorAbsoluteY);
          break;
        case 6:
          paramConstraint.editorAbsoluteX = paramTypedArray.getDimensionPixelOffset(k, paramConstraint.editorAbsoluteX);
          break;
        case 5:
          paramConstraint.dimensionRatio = paramTypedArray.getString(k);
          break;
        case 4:
          paramConstraint.bottomToTop = a(paramTypedArray, k, paramConstraint.bottomToTop);
          break;
        case 3:
          paramConstraint.bottomToBottom = a(paramTypedArray, k, paramConstraint.bottomToBottom);
          break;
        case 2:
          paramConstraint.bottomMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.bottomMargin);
          break;
        case 1:
          paramConstraint.baselineToBaseline = a(paramTypedArray, k, paramConstraint.baselineToBaseline);
          break;
      } 
    } 
  }
  
  private int[] a(View paramView, String paramString) {
    String[] arrayOfString = paramString.split(",");
    Context context = paramView.getContext();
    int[] arrayOfInt = new int[arrayOfString.length];
    int j = 0;
    int i = 0;
    while (true) {
      if (j < arrayOfString.length) {
        String str = arrayOfString[j].trim();
        try {
          m = R.id.class.getField(str).getInt(null);
        } catch (Exception exception) {
          m = 0;
        } 
        int k = m;
        if (!m)
          k = context.getResources().getIdentifier(str, "id", context.getPackageName()); 
        int m = k;
        if (k == 0) {
          m = k;
          if (paramView.isInEditMode()) {
            m = k;
            if (paramView.getParent() instanceof ConstraintLayout) {
              Object object = ((ConstraintLayout)paramView.getParent()).getDesignInformation(0, str);
              m = k;
              if (object != null) {
                m = k;
                if (object instanceof Integer)
                  m = ((Integer)object).intValue(); 
              } 
            } 
          } 
        } 
        arrayOfInt[i] = m;
        j++;
        i++;
        continue;
      } 
      int[] arrayOfInt1 = arrayOfInt;
      if (i != arrayOfString.length)
        arrayOfInt1 = Arrays.copyOf(arrayOfInt, i); 
      return arrayOfInt1;
    } 
  }
  
  private String b(int paramInt) {
    switch (paramInt) {
      default:
        return "undefined";
      case 7:
        return "end";
      case 6:
        return "start";
      case 5:
        return "baseline";
      case 4:
        return "bottom";
      case 3:
        return "top";
      case 2:
        return "right";
      case 1:
        break;
    } 
    return "left";
  }
  
  void a(ConstraintLayout paramConstraintLayout) {
    int j = paramConstraintLayout.getChildCount();
    HashSet hashSet = new HashSet(this.b.keySet());
    int i = 0;
    while (i < j) {
      View view = paramConstraintLayout.getChildAt(i);
      int k = view.getId();
      if (k != -1) {
        if (this.b.containsKey(Integer.valueOf(k))) {
          hashSet.remove(Integer.valueOf(k));
          Constraint constraint = this.b.get(Integer.valueOf(k));
          if (view instanceof Barrier)
            constraint.mHelperType = 1; 
          if (constraint.mHelperType != -1 && constraint.mHelperType == 1) {
            Barrier barrier = (Barrier)view;
            barrier.setId(k);
            barrier.setType(constraint.mBarrierDirection);
            barrier.setAllowsGoneWidget(constraint.mBarrierAllowsGoneWidgets);
            if (constraint.mReferenceIds != null) {
              barrier.setReferencedIds(constraint.mReferenceIds);
            } else if (constraint.mReferenceIdString != null) {
              constraint.mReferenceIds = a(barrier, constraint.mReferenceIdString);
              barrier.setReferencedIds(constraint.mReferenceIds);
            } 
          } 
          ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams)view.getLayoutParams();
          constraint.applyTo(layoutParams);
          view.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
          view.setVisibility(constraint.visibility);
          if (Build.VERSION.SDK_INT >= 17) {
            view.setAlpha(constraint.alpha);
            view.setRotation(constraint.rotation);
            view.setRotationX(constraint.rotationX);
            view.setRotationY(constraint.rotationY);
            view.setScaleX(constraint.scaleX);
            view.setScaleY(constraint.scaleY);
            if (!Float.isNaN(constraint.transformPivotX))
              view.setPivotX(constraint.transformPivotX); 
            if (!Float.isNaN(constraint.transformPivotY))
              view.setPivotY(constraint.transformPivotY); 
            view.setTranslationX(constraint.translationX);
            view.setTranslationY(constraint.translationY);
            if (Build.VERSION.SDK_INT >= 21) {
              view.setTranslationZ(constraint.translationZ);
              if (constraint.applyElevation)
                view.setElevation(constraint.elevation); 
            } 
          } 
        } 
        i++;
        continue;
      } 
      throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    } 
    for (Integer integer : hashSet) {
      Constraint constraint = this.b.get(integer);
      if (constraint.mHelperType != -1 && constraint.mHelperType == 1) {
        Barrier barrier = new Barrier(paramConstraintLayout.getContext());
        barrier.setId(integer.intValue());
        if (constraint.mReferenceIds != null) {
          barrier.setReferencedIds(constraint.mReferenceIds);
        } else if (constraint.mReferenceIdString != null) {
          constraint.mReferenceIds = a(barrier, constraint.mReferenceIdString);
          barrier.setReferencedIds(constraint.mReferenceIds);
        } 
        barrier.setType(constraint.mBarrierDirection);
        ConstraintLayout.LayoutParams layoutParams = paramConstraintLayout.a();
        barrier.validateParams();
        constraint.applyTo(layoutParams);
        paramConstraintLayout.addView(barrier, (ViewGroup.LayoutParams)layoutParams);
      } 
      if (constraint.a) {
        Guideline guideline = new Guideline(paramConstraintLayout.getContext());
        guideline.setId(integer.intValue());
        ConstraintLayout.LayoutParams layoutParams = paramConstraintLayout.a();
        constraint.applyTo(layoutParams);
        paramConstraintLayout.addView(guideline, (ViewGroup.LayoutParams)layoutParams);
      } 
    } 
  }
  
  public void addToHorizontalChain(int paramInt1, int paramInt2, int paramInt3) {
    byte b;
    if (paramInt2 == 0) {
      b = 1;
    } else {
      b = 2;
    } 
    connect(paramInt1, 1, paramInt2, b, 0);
    if (paramInt3 == 0) {
      b = 2;
    } else {
      b = 1;
    } 
    connect(paramInt1, 2, paramInt3, b, 0);
    if (paramInt2 != 0)
      connect(paramInt2, 2, paramInt1, 1, 0); 
    if (paramInt3 != 0)
      connect(paramInt3, 1, paramInt1, 2, 0); 
  }
  
  public void addToHorizontalChainRTL(int paramInt1, int paramInt2, int paramInt3) {
    byte b;
    if (paramInt2 == 0) {
      b = 6;
    } else {
      b = 7;
    } 
    connect(paramInt1, 6, paramInt2, b, 0);
    if (paramInt3 == 0) {
      b = 7;
    } else {
      b = 6;
    } 
    connect(paramInt1, 7, paramInt3, b, 0);
    if (paramInt2 != 0)
      connect(paramInt2, 7, paramInt1, 6, 0); 
    if (paramInt3 != 0)
      connect(paramInt3, 6, paramInt1, 7, 0); 
  }
  
  public void addToVerticalChain(int paramInt1, int paramInt2, int paramInt3) {
    byte b;
    if (paramInt2 == 0) {
      b = 3;
    } else {
      b = 4;
    } 
    connect(paramInt1, 3, paramInt2, b, 0);
    if (paramInt3 == 0) {
      b = 4;
    } else {
      b = 3;
    } 
    connect(paramInt1, 4, paramInt3, b, 0);
    if (paramInt2 != 0)
      connect(paramInt2, 4, paramInt1, 3, 0); 
    if (paramInt2 != 0)
      connect(paramInt3, 3, paramInt1, 4, 0); 
  }
  
  public void applyTo(ConstraintLayout paramConstraintLayout) {
    a(paramConstraintLayout);
    paramConstraintLayout.setConstraintSet((ConstraintSet)null);
  }
  
  public void center(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float paramFloat) {
    if (paramInt4 >= 0) {
      if (paramInt7 >= 0) {
        if (paramFloat > 0.0F && paramFloat <= 1.0F) {
          if (paramInt3 == 1 || paramInt3 == 2) {
            connect(paramInt1, 1, paramInt2, paramInt3, paramInt4);
            connect(paramInt1, 2, paramInt5, paramInt6, paramInt7);
            ((Constraint)this.b.get(Integer.valueOf(paramInt1))).horizontalBias = paramFloat;
            return;
          } 
          if (paramInt3 == 6 || paramInt3 == 7) {
            connect(paramInt1, 6, paramInt2, paramInt3, paramInt4);
            connect(paramInt1, 7, paramInt5, paramInt6, paramInt7);
            ((Constraint)this.b.get(Integer.valueOf(paramInt1))).horizontalBias = paramFloat;
            return;
          } 
          connect(paramInt1, 3, paramInt2, paramInt3, paramInt4);
          connect(paramInt1, 4, paramInt5, paramInt6, paramInt7);
          ((Constraint)this.b.get(Integer.valueOf(paramInt1))).verticalBias = paramFloat;
          return;
        } 
        throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
      } 
      throw new IllegalArgumentException("margin must be > 0");
    } 
    throw new IllegalArgumentException("margin must be > 0");
  }
  
  public void centerHorizontally(int paramInt1, int paramInt2) {
    if (paramInt2 == 0) {
      center(paramInt1, 0, 1, 0, 0, 2, 0, 0.5F);
      return;
    } 
    center(paramInt1, paramInt2, 2, 0, paramInt2, 1, 0, 0.5F);
  }
  
  public void centerHorizontally(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float paramFloat) {
    connect(paramInt1, 1, paramInt2, paramInt3, paramInt4);
    connect(paramInt1, 2, paramInt5, paramInt6, paramInt7);
    ((Constraint)this.b.get(Integer.valueOf(paramInt1))).horizontalBias = paramFloat;
  }
  
  public void centerHorizontallyRtl(int paramInt1, int paramInt2) {
    if (paramInt2 == 0) {
      center(paramInt1, 0, 6, 0, 0, 7, 0, 0.5F);
      return;
    } 
    center(paramInt1, paramInt2, 7, 0, paramInt2, 6, 0, 0.5F);
  }
  
  public void centerHorizontallyRtl(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float paramFloat) {
    connect(paramInt1, 6, paramInt2, paramInt3, paramInt4);
    connect(paramInt1, 7, paramInt5, paramInt6, paramInt7);
    ((Constraint)this.b.get(Integer.valueOf(paramInt1))).horizontalBias = paramFloat;
  }
  
  public void centerVertically(int paramInt1, int paramInt2) {
    if (paramInt2 == 0) {
      center(paramInt1, 0, 3, 0, 0, 4, 0, 0.5F);
      return;
    } 
    center(paramInt1, paramInt2, 4, 0, paramInt2, 3, 0, 0.5F);
  }
  
  public void centerVertically(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float paramFloat) {
    connect(paramInt1, 3, paramInt2, paramInt3, paramInt4);
    connect(paramInt1, 4, paramInt5, paramInt6, paramInt7);
    ((Constraint)this.b.get(Integer.valueOf(paramInt1))).verticalBias = paramFloat;
  }
  
  public void clear(int paramInt) {
    this.b.remove(Integer.valueOf(paramInt));
  }
  
  public void clear(int paramInt1, int paramInt2) {
    if (this.b.containsKey(Integer.valueOf(paramInt1))) {
      Constraint constraint = this.b.get(Integer.valueOf(paramInt1));
      switch (paramInt2) {
        default:
          throw new IllegalArgumentException("unknown constraint");
        case 7:
          constraint.endToStart = -1;
          constraint.endToEnd = -1;
          constraint.endMargin = -1;
          constraint.goneEndMargin = -1;
          return;
        case 6:
          constraint.startToEnd = -1;
          constraint.startToStart = -1;
          constraint.startMargin = -1;
          constraint.goneStartMargin = -1;
          return;
        case 5:
          constraint.baselineToBaseline = -1;
          return;
        case 4:
          constraint.bottomToTop = -1;
          constraint.bottomToBottom = -1;
          constraint.bottomMargin = -1;
          constraint.goneBottomMargin = -1;
          return;
        case 3:
          constraint.topToBottom = -1;
          constraint.topToTop = -1;
          constraint.topMargin = -1;
          constraint.goneTopMargin = -1;
          return;
        case 2:
          constraint.rightToRight = -1;
          constraint.rightToLeft = -1;
          constraint.rightMargin = -1;
          constraint.goneRightMargin = -1;
          return;
        case 1:
          break;
      } 
      constraint.leftToRight = -1;
      constraint.leftToLeft = -1;
      constraint.leftMargin = -1;
      constraint.goneLeftMargin = -1;
    } 
  }
  
  public void clone(Context paramContext, int paramInt) {
    clone((ConstraintLayout)LayoutInflater.from(paramContext).inflate(paramInt, null));
  }
  
  public void clone(ConstraintLayout paramConstraintLayout) {
    int j = paramConstraintLayout.getChildCount();
    this.b.clear();
    int i = 0;
    while (i < j) {
      View view = paramConstraintLayout.getChildAt(i);
      ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams)view.getLayoutParams();
      int k = view.getId();
      if (k != -1) {
        if (!this.b.containsKey(Integer.valueOf(k)))
          this.b.put(Integer.valueOf(k), new Constraint()); 
        Constraint constraint = this.b.get(Integer.valueOf(k));
        Constraint.a(constraint, k, layoutParams);
        constraint.visibility = view.getVisibility();
        if (Build.VERSION.SDK_INT >= 17) {
          constraint.alpha = view.getAlpha();
          constraint.rotation = view.getRotation();
          constraint.rotationX = view.getRotationX();
          constraint.rotationY = view.getRotationY();
          constraint.scaleX = view.getScaleX();
          constraint.scaleY = view.getScaleY();
          float f1 = view.getPivotX();
          float f2 = view.getPivotY();
          if (f1 != 0.0D || f2 != 0.0D) {
            constraint.transformPivotX = f1;
            constraint.transformPivotY = f2;
          } 
          constraint.translationX = view.getTranslationX();
          constraint.translationY = view.getTranslationY();
          if (Build.VERSION.SDK_INT >= 21) {
            constraint.translationZ = view.getTranslationZ();
            if (constraint.applyElevation)
              constraint.elevation = view.getElevation(); 
          } 
        } 
        if (view instanceof Barrier) {
          view = view;
          constraint.mBarrierAllowsGoneWidgets = view.allowsGoneWidget();
          constraint.mReferenceIds = view.getReferencedIds();
          constraint.mBarrierDirection = view.getType();
        } 
        i++;
        continue;
      } 
      throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    } 
  }
  
  public void clone(ConstraintSet paramConstraintSet) {
    this.b.clear();
    for (Integer integer : paramConstraintSet.b.keySet())
      this.b.put(integer, ((Constraint)paramConstraintSet.b.get(integer)).clone()); 
  }
  
  public void clone(Constraints paramConstraints) {
    int j = paramConstraints.getChildCount();
    this.b.clear();
    int i = 0;
    while (i < j) {
      View view = paramConstraints.getChildAt(i);
      Constraints.LayoutParams layoutParams = (Constraints.LayoutParams)view.getLayoutParams();
      int k = view.getId();
      if (k != -1) {
        if (!this.b.containsKey(Integer.valueOf(k)))
          this.b.put(Integer.valueOf(k), new Constraint()); 
        Constraint constraint = this.b.get(Integer.valueOf(k));
        if (view instanceof ConstraintHelper)
          Constraint.a(constraint, (ConstraintHelper)view, k, layoutParams); 
        Constraint.a(constraint, k, layoutParams);
        i++;
        continue;
      } 
      throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    } 
  }
  
  public void connect(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (!this.b.containsKey(Integer.valueOf(paramInt1)))
      this.b.put(Integer.valueOf(paramInt1), new Constraint()); 
    Constraint constraint = this.b.get(Integer.valueOf(paramInt1));
    switch (paramInt2) {
      default:
        stringBuilder = new StringBuilder();
        stringBuilder.append(b(paramInt2));
        stringBuilder.append(" to ");
        stringBuilder.append(b(paramInt4));
        stringBuilder.append(" unknown");
        throw new IllegalArgumentException(stringBuilder.toString());
      case 7:
        if (paramInt4 == 7) {
          ((Constraint)stringBuilder).endToEnd = paramInt3;
          ((Constraint)stringBuilder).endToStart = -1;
          return;
        } 
        if (paramInt4 == 6) {
          ((Constraint)stringBuilder).endToStart = paramInt3;
          ((Constraint)stringBuilder).endToEnd = -1;
          return;
        } 
        stringBuilder = new StringBuilder();
        stringBuilder.append("right to ");
        stringBuilder.append(b(paramInt4));
        stringBuilder.append(" undefined");
        throw new IllegalArgumentException(stringBuilder.toString());
      case 6:
        if (paramInt4 == 6) {
          ((Constraint)stringBuilder).startToStart = paramInt3;
          ((Constraint)stringBuilder).startToEnd = -1;
          return;
        } 
        if (paramInt4 == 7) {
          ((Constraint)stringBuilder).startToEnd = paramInt3;
          ((Constraint)stringBuilder).startToStart = -1;
          return;
        } 
        stringBuilder = new StringBuilder();
        stringBuilder.append("right to ");
        stringBuilder.append(b(paramInt4));
        stringBuilder.append(" undefined");
        throw new IllegalArgumentException(stringBuilder.toString());
      case 5:
        if (paramInt4 == 5) {
          ((Constraint)stringBuilder).baselineToBaseline = paramInt3;
          ((Constraint)stringBuilder).bottomToBottom = -1;
          ((Constraint)stringBuilder).bottomToTop = -1;
          ((Constraint)stringBuilder).topToTop = -1;
          ((Constraint)stringBuilder).topToBottom = -1;
          return;
        } 
        stringBuilder = new StringBuilder();
        stringBuilder.append("right to ");
        stringBuilder.append(b(paramInt4));
        stringBuilder.append(" undefined");
        throw new IllegalArgumentException(stringBuilder.toString());
      case 4:
        if (paramInt4 == 4) {
          ((Constraint)stringBuilder).bottomToBottom = paramInt3;
          ((Constraint)stringBuilder).bottomToTop = -1;
          ((Constraint)stringBuilder).baselineToBaseline = -1;
          return;
        } 
        if (paramInt4 == 3) {
          ((Constraint)stringBuilder).bottomToTop = paramInt3;
          ((Constraint)stringBuilder).bottomToBottom = -1;
          ((Constraint)stringBuilder).baselineToBaseline = -1;
          return;
        } 
        stringBuilder = new StringBuilder();
        stringBuilder.append("right to ");
        stringBuilder.append(b(paramInt4));
        stringBuilder.append(" undefined");
        throw new IllegalArgumentException(stringBuilder.toString());
      case 3:
        if (paramInt4 == 3) {
          ((Constraint)stringBuilder).topToTop = paramInt3;
          ((Constraint)stringBuilder).topToBottom = -1;
          ((Constraint)stringBuilder).baselineToBaseline = -1;
          return;
        } 
        if (paramInt4 == 4) {
          ((Constraint)stringBuilder).topToBottom = paramInt3;
          ((Constraint)stringBuilder).topToTop = -1;
          ((Constraint)stringBuilder).baselineToBaseline = -1;
          return;
        } 
        stringBuilder = new StringBuilder();
        stringBuilder.append("right to ");
        stringBuilder.append(b(paramInt4));
        stringBuilder.append(" undefined");
        throw new IllegalArgumentException(stringBuilder.toString());
      case 2:
        if (paramInt4 == 1) {
          ((Constraint)stringBuilder).rightToLeft = paramInt3;
          ((Constraint)stringBuilder).rightToRight = -1;
          return;
        } 
        if (paramInt4 == 2) {
          ((Constraint)stringBuilder).rightToRight = paramInt3;
          ((Constraint)stringBuilder).rightToLeft = -1;
          return;
        } 
        stringBuilder = new StringBuilder();
        stringBuilder.append("right to ");
        stringBuilder.append(b(paramInt4));
        stringBuilder.append(" undefined");
        throw new IllegalArgumentException(stringBuilder.toString());
      case 1:
        break;
    } 
    if (paramInt4 == 1) {
      ((Constraint)stringBuilder).leftToLeft = paramInt3;
      ((Constraint)stringBuilder).leftToRight = -1;
      return;
    } 
    if (paramInt4 == 2) {
      ((Constraint)stringBuilder).leftToRight = paramInt3;
      ((Constraint)stringBuilder).leftToLeft = -1;
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("left to ");
    stringBuilder.append(b(paramInt4));
    stringBuilder.append(" undefined");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public void connect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    StringBuilder stringBuilder;
    if (!this.b.containsKey(Integer.valueOf(paramInt1)))
      this.b.put(Integer.valueOf(paramInt1), new Constraint()); 
    Constraint constraint = this.b.get(Integer.valueOf(paramInt1));
    switch (paramInt2) {
      default:
        stringBuilder = new StringBuilder();
        stringBuilder.append(b(paramInt2));
        stringBuilder.append(" to ");
        stringBuilder.append(b(paramInt4));
        stringBuilder.append(" unknown");
        throw new IllegalArgumentException(stringBuilder.toString());
      case 7:
        if (paramInt4 == 7) {
          ((Constraint)stringBuilder).endToEnd = paramInt3;
          ((Constraint)stringBuilder).endToStart = -1;
        } else if (paramInt4 == 6) {
          ((Constraint)stringBuilder).endToStart = paramInt3;
          ((Constraint)stringBuilder).endToEnd = -1;
        } else {
          stringBuilder = new StringBuilder();
          stringBuilder.append("right to ");
          stringBuilder.append(b(paramInt4));
          stringBuilder.append(" undefined");
          throw new IllegalArgumentException(stringBuilder.toString());
        } 
        ((Constraint)stringBuilder).endMargin = paramInt5;
        return;
      case 6:
        if (paramInt4 == 6) {
          ((Constraint)stringBuilder).startToStart = paramInt3;
          ((Constraint)stringBuilder).startToEnd = -1;
        } else if (paramInt4 == 7) {
          ((Constraint)stringBuilder).startToEnd = paramInt3;
          ((Constraint)stringBuilder).startToStart = -1;
        } else {
          stringBuilder = new StringBuilder();
          stringBuilder.append("right to ");
          stringBuilder.append(b(paramInt4));
          stringBuilder.append(" undefined");
          throw new IllegalArgumentException(stringBuilder.toString());
        } 
        ((Constraint)stringBuilder).startMargin = paramInt5;
        return;
      case 5:
        if (paramInt4 == 5) {
          ((Constraint)stringBuilder).baselineToBaseline = paramInt3;
          ((Constraint)stringBuilder).bottomToBottom = -1;
          ((Constraint)stringBuilder).bottomToTop = -1;
          ((Constraint)stringBuilder).topToTop = -1;
          ((Constraint)stringBuilder).topToBottom = -1;
          return;
        } 
        stringBuilder = new StringBuilder();
        stringBuilder.append("right to ");
        stringBuilder.append(b(paramInt4));
        stringBuilder.append(" undefined");
        throw new IllegalArgumentException(stringBuilder.toString());
      case 4:
        if (paramInt4 == 4) {
          ((Constraint)stringBuilder).bottomToBottom = paramInt3;
          ((Constraint)stringBuilder).bottomToTop = -1;
          ((Constraint)stringBuilder).baselineToBaseline = -1;
        } else if (paramInt4 == 3) {
          ((Constraint)stringBuilder).bottomToTop = paramInt3;
          ((Constraint)stringBuilder).bottomToBottom = -1;
          ((Constraint)stringBuilder).baselineToBaseline = -1;
        } else {
          stringBuilder = new StringBuilder();
          stringBuilder.append("right to ");
          stringBuilder.append(b(paramInt4));
          stringBuilder.append(" undefined");
          throw new IllegalArgumentException(stringBuilder.toString());
        } 
        ((Constraint)stringBuilder).bottomMargin = paramInt5;
        return;
      case 3:
        if (paramInt4 == 3) {
          ((Constraint)stringBuilder).topToTop = paramInt3;
          ((Constraint)stringBuilder).topToBottom = -1;
          ((Constraint)stringBuilder).baselineToBaseline = -1;
        } else if (paramInt4 == 4) {
          ((Constraint)stringBuilder).topToBottom = paramInt3;
          ((Constraint)stringBuilder).topToTop = -1;
          ((Constraint)stringBuilder).baselineToBaseline = -1;
        } else {
          stringBuilder = new StringBuilder();
          stringBuilder.append("right to ");
          stringBuilder.append(b(paramInt4));
          stringBuilder.append(" undefined");
          throw new IllegalArgumentException(stringBuilder.toString());
        } 
        ((Constraint)stringBuilder).topMargin = paramInt5;
        return;
      case 2:
        if (paramInt4 == 1) {
          ((Constraint)stringBuilder).rightToLeft = paramInt3;
          ((Constraint)stringBuilder).rightToRight = -1;
        } else if (paramInt4 == 2) {
          ((Constraint)stringBuilder).rightToRight = paramInt3;
          ((Constraint)stringBuilder).rightToLeft = -1;
        } else {
          stringBuilder = new StringBuilder();
          stringBuilder.append("right to ");
          stringBuilder.append(b(paramInt4));
          stringBuilder.append(" undefined");
          throw new IllegalArgumentException(stringBuilder.toString());
        } 
        ((Constraint)stringBuilder).rightMargin = paramInt5;
        return;
      case 1:
        break;
    } 
    if (paramInt4 == 1) {
      ((Constraint)stringBuilder).leftToLeft = paramInt3;
      ((Constraint)stringBuilder).leftToRight = -1;
    } else if (paramInt4 == 2) {
      ((Constraint)stringBuilder).leftToRight = paramInt3;
      ((Constraint)stringBuilder).leftToLeft = -1;
    } else {
      stringBuilder = new StringBuilder();
      stringBuilder.append("Left to ");
      stringBuilder.append(b(paramInt4));
      stringBuilder.append(" undefined");
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    ((Constraint)stringBuilder).leftMargin = paramInt5;
  }
  
  public void constrainCircle(int paramInt1, int paramInt2, int paramInt3, float paramFloat) {
    Constraint constraint = a(paramInt1);
    constraint.circleConstraint = paramInt2;
    constraint.circleRadius = paramInt3;
    constraint.circleAngle = paramFloat;
  }
  
  public void constrainDefaultHeight(int paramInt1, int paramInt2) {
    (a(paramInt1)).heightDefault = paramInt2;
  }
  
  public void constrainDefaultWidth(int paramInt1, int paramInt2) {
    (a(paramInt1)).widthDefault = paramInt2;
  }
  
  public void constrainHeight(int paramInt1, int paramInt2) {
    (a(paramInt1)).mHeight = paramInt2;
  }
  
  public void constrainMaxHeight(int paramInt1, int paramInt2) {
    (a(paramInt1)).heightMax = paramInt2;
  }
  
  public void constrainMaxWidth(int paramInt1, int paramInt2) {
    (a(paramInt1)).widthMax = paramInt2;
  }
  
  public void constrainMinHeight(int paramInt1, int paramInt2) {
    (a(paramInt1)).heightMin = paramInt2;
  }
  
  public void constrainMinWidth(int paramInt1, int paramInt2) {
    (a(paramInt1)).widthMin = paramInt2;
  }
  
  public void constrainPercentHeight(int paramInt, float paramFloat) {
    (a(paramInt)).heightPercent = paramFloat;
  }
  
  public void constrainPercentWidth(int paramInt, float paramFloat) {
    (a(paramInt)).widthPercent = paramFloat;
  }
  
  public void constrainWidth(int paramInt1, int paramInt2) {
    (a(paramInt1)).mWidth = paramInt2;
  }
  
  public void create(int paramInt1, int paramInt2) {
    Constraint constraint = a(paramInt1);
    constraint.a = true;
    constraint.orientation = paramInt2;
  }
  
  public void createBarrier(int paramInt1, int paramInt2, int... paramVarArgs) {
    Constraint constraint = a(paramInt1);
    constraint.mHelperType = 1;
    constraint.mBarrierDirection = paramInt2;
    constraint.a = false;
    constraint.mReferenceIds = paramVarArgs;
  }
  
  public void createHorizontalChain(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint, float[] paramArrayOffloat, int paramInt5) {
    a(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfint, paramArrayOffloat, paramInt5, 1, 2);
  }
  
  public void createHorizontalChainRtl(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint, float[] paramArrayOffloat, int paramInt5) {
    a(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfint, paramArrayOffloat, paramInt5, 6, 7);
  }
  
  public void createVerticalChain(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint, float[] paramArrayOffloat, int paramInt5) {
    if (paramArrayOfint.length >= 2) {
      if (paramArrayOffloat == null || paramArrayOffloat.length == paramArrayOfint.length) {
        if (paramArrayOffloat != null)
          (a(paramArrayOfint[0])).verticalWeight = paramArrayOffloat[0]; 
        (a(paramArrayOfint[0])).verticalChainStyle = paramInt5;
        connect(paramArrayOfint[0], 3, paramInt1, paramInt2, 0);
        for (paramInt1 = 1; paramInt1 < paramArrayOfint.length; paramInt1++) {
          paramInt2 = paramArrayOfint[paramInt1];
          paramInt2 = paramArrayOfint[paramInt1];
          paramInt5 = paramInt1 - 1;
          connect(paramInt2, 3, paramArrayOfint[paramInt5], 4, 0);
          connect(paramArrayOfint[paramInt5], 4, paramArrayOfint[paramInt1], 3, 0);
          if (paramArrayOffloat != null)
            (a(paramArrayOfint[paramInt1])).verticalWeight = paramArrayOffloat[paramInt1]; 
        } 
        connect(paramArrayOfint[paramArrayOfint.length - 1], 4, paramInt3, paramInt4, 0);
        return;
      } 
      throw new IllegalArgumentException("must have 2 or more widgets in a chain");
    } 
    throw new IllegalArgumentException("must have 2 or more widgets in a chain");
  }
  
  public boolean getApplyElevation(int paramInt) {
    return (a(paramInt)).applyElevation;
  }
  
  public Constraint getParameters(int paramInt) {
    return a(paramInt);
  }
  
  public void load(Context paramContext, int paramInt) {
    XmlResourceParser xmlResourceParser = paramContext.getResources().getXml(paramInt);
    try {
      paramInt = xmlResourceParser.getEventType();
    } catch (XmlPullParserException xmlPullParserException) {
      xmlPullParserException.printStackTrace();
      return;
    } catch (IOException iOException) {
      iOException.printStackTrace();
      return;
    } 
    while (true) {
      if (paramInt != 1) {
        if (paramInt != 0) {
          if (paramInt == 2) {
            String str = xmlResourceParser.getName();
            Constraint constraint = a((Context)iOException, Xml.asAttributeSet((XmlPullParser)xmlResourceParser));
            if (str.equalsIgnoreCase("Guideline"))
              constraint.a = true; 
            this.b.put(Integer.valueOf(constraint.b), constraint);
          } 
        } else {
          xmlResourceParser.getName();
        } 
        paramInt = xmlResourceParser.next();
        continue;
      } 
      return;
    } 
  }
  
  public void removeFromHorizontalChain(int paramInt) {
    if (this.b.containsKey(Integer.valueOf(paramInt))) {
      Constraint constraint = this.b.get(Integer.valueOf(paramInt));
      int i = constraint.leftToRight;
      int j = constraint.rightToLeft;
      if (i != -1 || j != -1) {
        if (i != -1 && j != -1) {
          connect(i, 2, j, 1, 0);
          connect(j, 1, i, 2, 0);
        } else if (i != -1 || j != -1) {
          if (constraint.rightToRight != -1) {
            connect(i, 2, constraint.rightToRight, 2, 0);
          } else if (constraint.leftToLeft != -1) {
            connect(j, 1, constraint.leftToLeft, 1, 0);
          } 
        } 
        clear(paramInt, 1);
        clear(paramInt, 2);
        return;
      } 
      j = constraint.startToEnd;
      int k = constraint.endToStart;
      if (j != -1 || k != -1)
        if (j != -1 && k != -1) {
          connect(j, 7, k, 6, 0);
          connect(k, 6, i, 7, 0);
        } else if (i != -1 || k != -1) {
          if (constraint.rightToRight != -1) {
            connect(i, 7, constraint.rightToRight, 7, 0);
          } else if (constraint.leftToLeft != -1) {
            connect(k, 6, constraint.leftToLeft, 6, 0);
          } 
        }  
      clear(paramInt, 6);
      clear(paramInt, 7);
      return;
    } 
  }
  
  public void removeFromVerticalChain(int paramInt) {
    if (this.b.containsKey(Integer.valueOf(paramInt))) {
      Constraint constraint = this.b.get(Integer.valueOf(paramInt));
      int i = constraint.topToBottom;
      int j = constraint.bottomToTop;
      if (i != -1 || j != -1)
        if (i != -1 && j != -1) {
          connect(i, 4, j, 3, 0);
          connect(j, 3, i, 4, 0);
        } else if (i != -1 || j != -1) {
          if (constraint.bottomToBottom != -1) {
            connect(i, 4, constraint.bottomToBottom, 4, 0);
          } else if (constraint.topToTop != -1) {
            connect(j, 3, constraint.topToTop, 3, 0);
          } 
        }  
    } 
    clear(paramInt, 3);
    clear(paramInt, 4);
  }
  
  public void setAlpha(int paramInt, float paramFloat) {
    (a(paramInt)).alpha = paramFloat;
  }
  
  public void setApplyElevation(int paramInt, boolean paramBoolean) {
    (a(paramInt)).applyElevation = paramBoolean;
  }
  
  public void setBarrierType(int paramInt1, int paramInt2) {}
  
  public void setDimensionRatio(int paramInt, String paramString) {
    (a(paramInt)).dimensionRatio = paramString;
  }
  
  public void setElevation(int paramInt, float paramFloat) {
    (a(paramInt)).elevation = paramFloat;
    (a(paramInt)).applyElevation = true;
  }
  
  public void setGoneMargin(int paramInt1, int paramInt2, int paramInt3) {
    Constraint constraint = a(paramInt1);
    switch (paramInt2) {
      default:
        throw new IllegalArgumentException("unknown constraint");
      case 7:
        constraint.goneEndMargin = paramInt3;
        return;
      case 6:
        constraint.goneStartMargin = paramInt3;
        return;
      case 5:
        throw new IllegalArgumentException("baseline does not support margins");
      case 4:
        constraint.goneBottomMargin = paramInt3;
        return;
      case 3:
        constraint.goneTopMargin = paramInt3;
        return;
      case 2:
        constraint.goneRightMargin = paramInt3;
        return;
      case 1:
        break;
    } 
    constraint.goneLeftMargin = paramInt3;
  }
  
  public void setGuidelineBegin(int paramInt1, int paramInt2) {
    (a(paramInt1)).guideBegin = paramInt2;
    (a(paramInt1)).guideEnd = -1;
    (a(paramInt1)).guidePercent = -1.0F;
  }
  
  public void setGuidelineEnd(int paramInt1, int paramInt2) {
    (a(paramInt1)).guideEnd = paramInt2;
    (a(paramInt1)).guideBegin = -1;
    (a(paramInt1)).guidePercent = -1.0F;
  }
  
  public void setGuidelinePercent(int paramInt, float paramFloat) {
    (a(paramInt)).guidePercent = paramFloat;
    (a(paramInt)).guideEnd = -1;
    (a(paramInt)).guideBegin = -1;
  }
  
  public void setHorizontalBias(int paramInt, float paramFloat) {
    (a(paramInt)).horizontalBias = paramFloat;
  }
  
  public void setHorizontalChainStyle(int paramInt1, int paramInt2) {
    (a(paramInt1)).horizontalChainStyle = paramInt2;
  }
  
  public void setHorizontalWeight(int paramInt, float paramFloat) {
    (a(paramInt)).horizontalWeight = paramFloat;
  }
  
  public void setMargin(int paramInt1, int paramInt2, int paramInt3) {
    Constraint constraint = a(paramInt1);
    switch (paramInt2) {
      default:
        throw new IllegalArgumentException("unknown constraint");
      case 7:
        constraint.endMargin = paramInt3;
        return;
      case 6:
        constraint.startMargin = paramInt3;
        return;
      case 5:
        throw new IllegalArgumentException("baseline does not support margins");
      case 4:
        constraint.bottomMargin = paramInt3;
        return;
      case 3:
        constraint.topMargin = paramInt3;
        return;
      case 2:
        constraint.rightMargin = paramInt3;
        return;
      case 1:
        break;
    } 
    constraint.leftMargin = paramInt3;
  }
  
  public void setRotation(int paramInt, float paramFloat) {
    (a(paramInt)).rotation = paramFloat;
  }
  
  public void setRotationX(int paramInt, float paramFloat) {
    (a(paramInt)).rotationX = paramFloat;
  }
  
  public void setRotationY(int paramInt, float paramFloat) {
    (a(paramInt)).rotationY = paramFloat;
  }
  
  public void setScaleX(int paramInt, float paramFloat) {
    (a(paramInt)).scaleX = paramFloat;
  }
  
  public void setScaleY(int paramInt, float paramFloat) {
    (a(paramInt)).scaleY = paramFloat;
  }
  
  public void setTransformPivot(int paramInt, float paramFloat1, float paramFloat2) {
    Constraint constraint = a(paramInt);
    constraint.transformPivotY = paramFloat2;
    constraint.transformPivotX = paramFloat1;
  }
  
  public void setTransformPivotX(int paramInt, float paramFloat) {
    (a(paramInt)).transformPivotX = paramFloat;
  }
  
  public void setTransformPivotY(int paramInt, float paramFloat) {
    (a(paramInt)).transformPivotY = paramFloat;
  }
  
  public void setTranslation(int paramInt, float paramFloat1, float paramFloat2) {
    Constraint constraint = a(paramInt);
    constraint.translationX = paramFloat1;
    constraint.translationY = paramFloat2;
  }
  
  public void setTranslationX(int paramInt, float paramFloat) {
    (a(paramInt)).translationX = paramFloat;
  }
  
  public void setTranslationY(int paramInt, float paramFloat) {
    (a(paramInt)).translationY = paramFloat;
  }
  
  public void setTranslationZ(int paramInt, float paramFloat) {
    (a(paramInt)).translationZ = paramFloat;
  }
  
  public void setVerticalBias(int paramInt, float paramFloat) {
    (a(paramInt)).verticalBias = paramFloat;
  }
  
  public void setVerticalChainStyle(int paramInt1, int paramInt2) {
    (a(paramInt1)).verticalChainStyle = paramInt2;
  }
  
  public void setVerticalWeight(int paramInt, float paramFloat) {
    (a(paramInt)).verticalWeight = paramFloat;
  }
  
  public void setVisibility(int paramInt1, int paramInt2) {
    (a(paramInt1)).visibility = paramInt2;
  }
  
  static class Constraint {
    boolean a = false;
    
    public float alpha = 1.0F;
    
    public boolean applyElevation = false;
    
    int b;
    
    public int baselineToBaseline = -1;
    
    public int bottomMargin = -1;
    
    public int bottomToBottom = -1;
    
    public int bottomToTop = -1;
    
    public float circleAngle = 0.0F;
    
    public int circleConstraint = -1;
    
    public int circleRadius = 0;
    
    public boolean constrainedHeight = false;
    
    public boolean constrainedWidth = false;
    
    public String dimensionRatio = null;
    
    public int editorAbsoluteX = -1;
    
    public int editorAbsoluteY = -1;
    
    public float elevation = 0.0F;
    
    public int endMargin = -1;
    
    public int endToEnd = -1;
    
    public int endToStart = -1;
    
    public int goneBottomMargin = -1;
    
    public int goneEndMargin = -1;
    
    public int goneLeftMargin = -1;
    
    public int goneRightMargin = -1;
    
    public int goneStartMargin = -1;
    
    public int goneTopMargin = -1;
    
    public int guideBegin = -1;
    
    public int guideEnd = -1;
    
    public float guidePercent = -1.0F;
    
    public int heightDefault = 0;
    
    public int heightMax = -1;
    
    public int heightMin = -1;
    
    public float heightPercent = 1.0F;
    
    public float horizontalBias = 0.5F;
    
    public int horizontalChainStyle = 0;
    
    public float horizontalWeight = 0.0F;
    
    public int leftMargin = -1;
    
    public int leftToLeft = -1;
    
    public int leftToRight = -1;
    
    public boolean mBarrierAllowsGoneWidgets = false;
    
    public int mBarrierDirection = -1;
    
    public int mHeight;
    
    public int mHelperType = -1;
    
    public String mReferenceIdString;
    
    public int[] mReferenceIds;
    
    public int mWidth;
    
    public int orientation = -1;
    
    public int rightMargin = -1;
    
    public int rightToLeft = -1;
    
    public int rightToRight = -1;
    
    public float rotation = 0.0F;
    
    public float rotationX = 0.0F;
    
    public float rotationY = 0.0F;
    
    public float scaleX = 1.0F;
    
    public float scaleY = 1.0F;
    
    public int startMargin = -1;
    
    public int startToEnd = -1;
    
    public int startToStart = -1;
    
    public int topMargin = -1;
    
    public int topToBottom = -1;
    
    public int topToTop = -1;
    
    public float transformPivotX = Float.NaN;
    
    public float transformPivotY = Float.NaN;
    
    public float translationX = 0.0F;
    
    public float translationY = 0.0F;
    
    public float translationZ = 0.0F;
    
    public float verticalBias = 0.5F;
    
    public int verticalChainStyle = 0;
    
    public float verticalWeight = 0.0F;
    
    public int visibility = 0;
    
    public int widthDefault = 0;
    
    public int widthMax = -1;
    
    public int widthMin = -1;
    
    public float widthPercent = 1.0F;
    
    private Constraint() {}
    
    private void a(int param1Int, ConstraintLayout.LayoutParams param1LayoutParams) {
      this.b = param1Int;
      this.leftToLeft = param1LayoutParams.leftToLeft;
      this.leftToRight = param1LayoutParams.leftToRight;
      this.rightToLeft = param1LayoutParams.rightToLeft;
      this.rightToRight = param1LayoutParams.rightToRight;
      this.topToTop = param1LayoutParams.topToTop;
      this.topToBottom = param1LayoutParams.topToBottom;
      this.bottomToTop = param1LayoutParams.bottomToTop;
      this.bottomToBottom = param1LayoutParams.bottomToBottom;
      this.baselineToBaseline = param1LayoutParams.baselineToBaseline;
      this.startToEnd = param1LayoutParams.startToEnd;
      this.startToStart = param1LayoutParams.startToStart;
      this.endToStart = param1LayoutParams.endToStart;
      this.endToEnd = param1LayoutParams.endToEnd;
      this.horizontalBias = param1LayoutParams.horizontalBias;
      this.verticalBias = param1LayoutParams.verticalBias;
      this.dimensionRatio = param1LayoutParams.dimensionRatio;
      this.circleConstraint = param1LayoutParams.circleConstraint;
      this.circleRadius = param1LayoutParams.circleRadius;
      this.circleAngle = param1LayoutParams.circleAngle;
      this.editorAbsoluteX = param1LayoutParams.editorAbsoluteX;
      this.editorAbsoluteY = param1LayoutParams.editorAbsoluteY;
      this.orientation = param1LayoutParams.orientation;
      this.guidePercent = param1LayoutParams.guidePercent;
      this.guideBegin = param1LayoutParams.guideBegin;
      this.guideEnd = param1LayoutParams.guideEnd;
      this.mWidth = param1LayoutParams.width;
      this.mHeight = param1LayoutParams.height;
      this.leftMargin = param1LayoutParams.leftMargin;
      this.rightMargin = param1LayoutParams.rightMargin;
      this.topMargin = param1LayoutParams.topMargin;
      this.bottomMargin = param1LayoutParams.bottomMargin;
      this.verticalWeight = param1LayoutParams.verticalWeight;
      this.horizontalWeight = param1LayoutParams.horizontalWeight;
      this.verticalChainStyle = param1LayoutParams.verticalChainStyle;
      this.horizontalChainStyle = param1LayoutParams.horizontalChainStyle;
      this.constrainedWidth = param1LayoutParams.constrainedWidth;
      this.constrainedHeight = param1LayoutParams.constrainedHeight;
      this.widthDefault = param1LayoutParams.matchConstraintDefaultWidth;
      this.heightDefault = param1LayoutParams.matchConstraintDefaultHeight;
      this.constrainedWidth = param1LayoutParams.constrainedWidth;
      this.widthMax = param1LayoutParams.matchConstraintMaxWidth;
      this.heightMax = param1LayoutParams.matchConstraintMaxHeight;
      this.widthMin = param1LayoutParams.matchConstraintMinWidth;
      this.heightMin = param1LayoutParams.matchConstraintMinHeight;
      this.widthPercent = param1LayoutParams.matchConstraintPercentWidth;
      this.heightPercent = param1LayoutParams.matchConstraintPercentHeight;
      if (Build.VERSION.SDK_INT >= 17) {
        this.endMargin = param1LayoutParams.getMarginEnd();
        this.startMargin = param1LayoutParams.getMarginStart();
      } 
    }
    
    private void a(int param1Int, Constraints.LayoutParams param1LayoutParams) {
      a(param1Int, param1LayoutParams);
      this.alpha = param1LayoutParams.alpha;
      this.rotation = param1LayoutParams.rotation;
      this.rotationX = param1LayoutParams.rotationX;
      this.rotationY = param1LayoutParams.rotationY;
      this.scaleX = param1LayoutParams.scaleX;
      this.scaleY = param1LayoutParams.scaleY;
      this.transformPivotX = param1LayoutParams.transformPivotX;
      this.transformPivotY = param1LayoutParams.transformPivotY;
      this.translationX = param1LayoutParams.translationX;
      this.translationY = param1LayoutParams.translationY;
      this.translationZ = param1LayoutParams.translationZ;
      this.elevation = param1LayoutParams.elevation;
      this.applyElevation = param1LayoutParams.applyElevation;
    }
    
    private void a(ConstraintHelper param1ConstraintHelper, int param1Int, Constraints.LayoutParams param1LayoutParams) {
      a(param1Int, param1LayoutParams);
      if (param1ConstraintHelper instanceof Barrier) {
        this.mHelperType = 1;
        param1ConstraintHelper = param1ConstraintHelper;
        this.mBarrierDirection = param1ConstraintHelper.getType();
        this.mReferenceIds = param1ConstraintHelper.getReferencedIds();
      } 
    }
    
    public void applyTo(ConstraintLayout.LayoutParams param1LayoutParams) {
      param1LayoutParams.leftToLeft = this.leftToLeft;
      param1LayoutParams.leftToRight = this.leftToRight;
      param1LayoutParams.rightToLeft = this.rightToLeft;
      param1LayoutParams.rightToRight = this.rightToRight;
      param1LayoutParams.topToTop = this.topToTop;
      param1LayoutParams.topToBottom = this.topToBottom;
      param1LayoutParams.bottomToTop = this.bottomToTop;
      param1LayoutParams.bottomToBottom = this.bottomToBottom;
      param1LayoutParams.baselineToBaseline = this.baselineToBaseline;
      param1LayoutParams.startToEnd = this.startToEnd;
      param1LayoutParams.startToStart = this.startToStart;
      param1LayoutParams.endToStart = this.endToStart;
      param1LayoutParams.endToEnd = this.endToEnd;
      param1LayoutParams.leftMargin = this.leftMargin;
      param1LayoutParams.rightMargin = this.rightMargin;
      param1LayoutParams.topMargin = this.topMargin;
      param1LayoutParams.bottomMargin = this.bottomMargin;
      param1LayoutParams.goneStartMargin = this.goneStartMargin;
      param1LayoutParams.goneEndMargin = this.goneEndMargin;
      param1LayoutParams.horizontalBias = this.horizontalBias;
      param1LayoutParams.verticalBias = this.verticalBias;
      param1LayoutParams.circleConstraint = this.circleConstraint;
      param1LayoutParams.circleRadius = this.circleRadius;
      param1LayoutParams.circleAngle = this.circleAngle;
      param1LayoutParams.dimensionRatio = this.dimensionRatio;
      param1LayoutParams.editorAbsoluteX = this.editorAbsoluteX;
      param1LayoutParams.editorAbsoluteY = this.editorAbsoluteY;
      param1LayoutParams.verticalWeight = this.verticalWeight;
      param1LayoutParams.horizontalWeight = this.horizontalWeight;
      param1LayoutParams.verticalChainStyle = this.verticalChainStyle;
      param1LayoutParams.horizontalChainStyle = this.horizontalChainStyle;
      param1LayoutParams.constrainedWidth = this.constrainedWidth;
      param1LayoutParams.constrainedHeight = this.constrainedHeight;
      param1LayoutParams.matchConstraintDefaultWidth = this.widthDefault;
      param1LayoutParams.matchConstraintDefaultHeight = this.heightDefault;
      param1LayoutParams.matchConstraintMaxWidth = this.widthMax;
      param1LayoutParams.matchConstraintMaxHeight = this.heightMax;
      param1LayoutParams.matchConstraintMinWidth = this.widthMin;
      param1LayoutParams.matchConstraintMinHeight = this.heightMin;
      param1LayoutParams.matchConstraintPercentWidth = this.widthPercent;
      param1LayoutParams.matchConstraintPercentHeight = this.heightPercent;
      param1LayoutParams.orientation = this.orientation;
      param1LayoutParams.guidePercent = this.guidePercent;
      param1LayoutParams.guideBegin = this.guideBegin;
      param1LayoutParams.guideEnd = this.guideEnd;
      param1LayoutParams.width = this.mWidth;
      param1LayoutParams.height = this.mHeight;
      if (Build.VERSION.SDK_INT >= 17) {
        param1LayoutParams.setMarginStart(this.startMargin);
        param1LayoutParams.setMarginEnd(this.endMargin);
      } 
      param1LayoutParams.validate();
    }
    
    public Constraint clone() {
      Constraint constraint = new Constraint();
      constraint.a = this.a;
      constraint.mWidth = this.mWidth;
      constraint.mHeight = this.mHeight;
      constraint.guideBegin = this.guideBegin;
      constraint.guideEnd = this.guideEnd;
      constraint.guidePercent = this.guidePercent;
      constraint.leftToLeft = this.leftToLeft;
      constraint.leftToRight = this.leftToRight;
      constraint.rightToLeft = this.rightToLeft;
      constraint.rightToRight = this.rightToRight;
      constraint.topToTop = this.topToTop;
      constraint.topToBottom = this.topToBottom;
      constraint.bottomToTop = this.bottomToTop;
      constraint.bottomToBottom = this.bottomToBottom;
      constraint.baselineToBaseline = this.baselineToBaseline;
      constraint.startToEnd = this.startToEnd;
      constraint.startToStart = this.startToStart;
      constraint.endToStart = this.endToStart;
      constraint.endToEnd = this.endToEnd;
      constraint.horizontalBias = this.horizontalBias;
      constraint.verticalBias = this.verticalBias;
      constraint.dimensionRatio = this.dimensionRatio;
      constraint.editorAbsoluteX = this.editorAbsoluteX;
      constraint.editorAbsoluteY = this.editorAbsoluteY;
      constraint.horizontalBias = this.horizontalBias;
      constraint.horizontalBias = this.horizontalBias;
      constraint.horizontalBias = this.horizontalBias;
      constraint.horizontalBias = this.horizontalBias;
      constraint.horizontalBias = this.horizontalBias;
      constraint.orientation = this.orientation;
      constraint.leftMargin = this.leftMargin;
      constraint.rightMargin = this.rightMargin;
      constraint.topMargin = this.topMargin;
      constraint.bottomMargin = this.bottomMargin;
      constraint.endMargin = this.endMargin;
      constraint.startMargin = this.startMargin;
      constraint.visibility = this.visibility;
      constraint.goneLeftMargin = this.goneLeftMargin;
      constraint.goneTopMargin = this.goneTopMargin;
      constraint.goneRightMargin = this.goneRightMargin;
      constraint.goneBottomMargin = this.goneBottomMargin;
      constraint.goneEndMargin = this.goneEndMargin;
      constraint.goneStartMargin = this.goneStartMargin;
      constraint.verticalWeight = this.verticalWeight;
      constraint.horizontalWeight = this.horizontalWeight;
      constraint.horizontalChainStyle = this.horizontalChainStyle;
      constraint.verticalChainStyle = this.verticalChainStyle;
      constraint.alpha = this.alpha;
      constraint.applyElevation = this.applyElevation;
      constraint.elevation = this.elevation;
      constraint.rotation = this.rotation;
      constraint.rotationX = this.rotationX;
      constraint.rotationY = this.rotationY;
      constraint.scaleX = this.scaleX;
      constraint.scaleY = this.scaleY;
      constraint.transformPivotX = this.transformPivotX;
      constraint.transformPivotY = this.transformPivotY;
      constraint.translationX = this.translationX;
      constraint.translationY = this.translationY;
      constraint.translationZ = this.translationZ;
      constraint.constrainedWidth = this.constrainedWidth;
      constraint.constrainedHeight = this.constrainedHeight;
      constraint.widthDefault = this.widthDefault;
      constraint.heightDefault = this.heightDefault;
      constraint.widthMax = this.widthMax;
      constraint.heightMax = this.heightMax;
      constraint.widthMin = this.widthMin;
      constraint.heightMin = this.heightMin;
      constraint.widthPercent = this.widthPercent;
      constraint.heightPercent = this.heightPercent;
      constraint.mBarrierDirection = this.mBarrierDirection;
      constraint.mHelperType = this.mHelperType;
      int[] arrayOfInt = this.mReferenceIds;
      if (arrayOfInt != null)
        constraint.mReferenceIds = Arrays.copyOf(arrayOfInt, arrayOfInt.length); 
      constraint.circleConstraint = this.circleConstraint;
      constraint.circleRadius = this.circleRadius;
      constraint.circleAngle = this.circleAngle;
      constraint.mBarrierAllowsGoneWidgets = this.mBarrierAllowsGoneWidgets;
      return constraint;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\constraintlayout\widget\ConstraintSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */