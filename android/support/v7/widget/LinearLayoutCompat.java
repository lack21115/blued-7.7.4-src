package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

public class LinearLayoutCompat extends ViewGroup {
  boolean mBaselineAligned;
  
  private int mBaselineAlignedChildIndex;
  
  private int mBaselineChildTop;
  
  Drawable mDivider;
  
  private int mDividerHeight;
  
  private int mDividerPadding;
  
  int mDividerWidth;
  
  int mGravity;
  
  private int[] mMaxAscent;
  
  private int[] mMaxDescent;
  
  private int mOrientation;
  
  private int mShowDividers;
  
  private int mTotalLength;
  
  private boolean mUseLargestChild;
  
  private float mWeightSum;
  
  public LinearLayoutCompat(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public LinearLayoutCompat(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LinearLayoutCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    boolean bool = true;
    this.mBaselineAligned = true;
    this.mBaselineAlignedChildIndex = -1;
    this.mBaselineChildTop = 0;
    this.mGravity = 8388659;
    TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.LinearLayoutCompat, paramInt, 0);
    paramInt = tintTypedArray.getInt(R.styleable.LinearLayoutCompat_android_orientation, -1);
    if (paramInt >= 0 && this.mOrientation != paramInt) {
      this.mOrientation = paramInt;
      requestLayout();
    } 
    int i = tintTypedArray.getInt(R.styleable.LinearLayoutCompat_android_gravity, -1);
    if (i >= 0 && this.mGravity != i) {
      paramInt = i;
      if ((0x800007 & i) == 0)
        paramInt = i | 0x800003; 
      i = paramInt;
      if ((paramInt & 0x70) == 0)
        i = paramInt | 0x30; 
      this.mGravity = i;
      requestLayout();
    } 
    boolean bool1 = tintTypedArray.getBoolean(R.styleable.LinearLayoutCompat_android_baselineAligned, true);
    if (!bool1)
      this.mBaselineAligned = bool1; 
    paramInt = R.styleable.LinearLayoutCompat_android_weightSum;
    this.mWeightSum = tintTypedArray.mWrapped.getFloat(paramInt, -1.0F);
    this.mBaselineAlignedChildIndex = tintTypedArray.getInt(R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
    this.mUseLargestChild = tintTypedArray.getBoolean(R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
    Drawable drawable = tintTypedArray.getDrawable(R.styleable.LinearLayoutCompat_divider);
    if (drawable != this.mDivider) {
      this.mDivider = drawable;
      if (drawable != null) {
        this.mDividerWidth = drawable.getIntrinsicWidth();
        this.mDividerHeight = drawable.getIntrinsicHeight();
      } else {
        this.mDividerWidth = 0;
        this.mDividerHeight = 0;
      } 
      if (drawable != null)
        bool = false; 
      setWillNotDraw(bool);
      requestLayout();
    } 
    this.mShowDividers = tintTypedArray.getInt(R.styleable.LinearLayoutCompat_showDividers, 0);
    this.mDividerPadding = tintTypedArray.getDimensionPixelSize(R.styleable.LinearLayoutCompat_dividerPadding, 0);
    tintTypedArray.mWrapped.recycle();
  }
  
  private void drawHorizontalDivider(Canvas paramCanvas, int paramInt) {
    this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, paramInt, getWidth() - getPaddingRight() - this.mDividerPadding, this.mDividerHeight + paramInt);
    this.mDivider.draw(paramCanvas);
  }
  
  private void drawVerticalDivider(Canvas paramCanvas, int paramInt) {
    this.mDivider.setBounds(paramInt, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + paramInt, getHeight() - getPaddingBottom() - this.mDividerPadding);
    this.mDivider.draw(paramCanvas);
  }
  
  private void forceUniformWidth(int paramInt1, int paramInt2) {
    int j = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
    for (int i = 0; i < paramInt1; i++) {
      View view = getChildAt(i);
      if (view.getVisibility() != 8) {
        LinearLayoutCompat$LayoutParams linearLayoutCompat$LayoutParams = (LinearLayoutCompat$LayoutParams)view.getLayoutParams();
        if (linearLayoutCompat$LayoutParams.width == -1) {
          int k = linearLayoutCompat$LayoutParams.height;
          linearLayoutCompat$LayoutParams.height = view.getMeasuredHeight();
          measureChildWithMargins(view, j, 0, paramInt2, 0);
          linearLayoutCompat$LayoutParams.height = k;
        } 
      } 
    } 
  }
  
  private void measureChildBeforeLayout$12802926(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    measureChildWithMargins(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  private void measureHorizontal(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: putfield mTotalLength : I
    //   5: aload_0
    //   6: invokevirtual getChildCount : ()I
    //   9: istore #17
    //   11: iload_1
    //   12: invokestatic getMode : (I)I
    //   15: istore #6
    //   17: iload_2
    //   18: invokestatic getMode : (I)I
    //   21: istore #21
    //   23: aload_0
    //   24: getfield mMaxAscent : [I
    //   27: ifnull -> 37
    //   30: aload_0
    //   31: getfield mMaxDescent : [I
    //   34: ifnonnull -> 51
    //   37: aload_0
    //   38: iconst_4
    //   39: newarray int
    //   41: putfield mMaxAscent : [I
    //   44: aload_0
    //   45: iconst_4
    //   46: newarray int
    //   48: putfield mMaxDescent : [I
    //   51: aload_0
    //   52: getfield mMaxAscent : [I
    //   55: astore #28
    //   57: aload_0
    //   58: getfield mMaxDescent : [I
    //   61: astore #29
    //   63: aload #28
    //   65: iconst_3
    //   66: iconst_m1
    //   67: iastore
    //   68: aload #28
    //   70: iconst_2
    //   71: iconst_m1
    //   72: iastore
    //   73: aload #28
    //   75: iconst_1
    //   76: iconst_m1
    //   77: iastore
    //   78: aload #28
    //   80: iconst_0
    //   81: iconst_m1
    //   82: iastore
    //   83: aload #29
    //   85: iconst_3
    //   86: iconst_m1
    //   87: iastore
    //   88: aload #29
    //   90: iconst_2
    //   91: iconst_m1
    //   92: iastore
    //   93: aload #29
    //   95: iconst_1
    //   96: iconst_m1
    //   97: iastore
    //   98: aload #29
    //   100: iconst_0
    //   101: iconst_m1
    //   102: iastore
    //   103: aload_0
    //   104: getfield mBaselineAligned : Z
    //   107: istore #25
    //   109: aload_0
    //   110: getfield mUseLargestChild : Z
    //   113: istore #24
    //   115: iload #6
    //   117: ldc 1073741824
    //   119: if_icmpne -> 128
    //   122: iconst_1
    //   123: istore #16
    //   125: goto -> 131
    //   128: iconst_0
    //   129: istore #16
    //   131: fconst_0
    //   132: fstore_3
    //   133: iconst_0
    //   134: istore #18
    //   136: iconst_0
    //   137: istore #12
    //   139: iconst_0
    //   140: istore #13
    //   142: iconst_0
    //   143: istore #9
    //   145: iconst_0
    //   146: istore #5
    //   148: iconst_0
    //   149: istore #8
    //   151: iconst_0
    //   152: istore #11
    //   154: iconst_0
    //   155: istore #10
    //   157: iconst_1
    //   158: istore #7
    //   160: iload #18
    //   162: iload #17
    //   164: if_icmpge -> 802
    //   167: aload_0
    //   168: iload #18
    //   170: invokevirtual getChildAt : (I)Landroid/view/View;
    //   173: astore #30
    //   175: aload #30
    //   177: ifnonnull -> 191
    //   180: aload_0
    //   181: aload_0
    //   182: getfield mTotalLength : I
    //   185: putfield mTotalLength : I
    //   188: goto -> 793
    //   191: aload #30
    //   193: invokevirtual getVisibility : ()I
    //   196: bipush #8
    //   198: if_icmpeq -> 188
    //   201: aload_0
    //   202: iload #18
    //   204: invokevirtual hasDividerBeforeChildAt : (I)Z
    //   207: ifeq -> 223
    //   210: aload_0
    //   211: aload_0
    //   212: getfield mTotalLength : I
    //   215: aload_0
    //   216: getfield mDividerWidth : I
    //   219: iadd
    //   220: putfield mTotalLength : I
    //   223: aload #30
    //   225: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   228: checkcast android/support/v7/widget/LinearLayoutCompat$LayoutParams
    //   231: astore #26
    //   233: fload_3
    //   234: aload #26
    //   236: getfield weight : F
    //   239: fadd
    //   240: fstore_3
    //   241: iload #6
    //   243: ldc 1073741824
    //   245: if_icmpne -> 361
    //   248: aload #26
    //   250: getfield width : I
    //   253: ifne -> 361
    //   256: aload #26
    //   258: getfield weight : F
    //   261: fconst_0
    //   262: fcmpl
    //   263: ifle -> 361
    //   266: iload #16
    //   268: ifeq -> 294
    //   271: aload_0
    //   272: aload_0
    //   273: getfield mTotalLength : I
    //   276: aload #26
    //   278: getfield leftMargin : I
    //   281: aload #26
    //   283: getfield rightMargin : I
    //   286: iadd
    //   287: iadd
    //   288: putfield mTotalLength : I
    //   291: goto -> 323
    //   294: aload_0
    //   295: getfield mTotalLength : I
    //   298: istore #14
    //   300: aload_0
    //   301: iload #14
    //   303: aload #26
    //   305: getfield leftMargin : I
    //   308: iload #14
    //   310: iadd
    //   311: aload #26
    //   313: getfield rightMargin : I
    //   316: iadd
    //   317: invokestatic max : (II)I
    //   320: putfield mTotalLength : I
    //   323: iload #25
    //   325: ifeq -> 347
    //   328: iconst_0
    //   329: iconst_0
    //   330: invokestatic makeMeasureSpec : (II)I
    //   333: istore #14
    //   335: aload #30
    //   337: iload #14
    //   339: iload #14
    //   341: invokevirtual measure : (II)V
    //   344: goto -> 350
    //   347: iconst_1
    //   348: istore #9
    //   350: iload #12
    //   352: istore #15
    //   354: iload #9
    //   356: istore #14
    //   358: goto -> 539
    //   361: aload #26
    //   363: getfield width : I
    //   366: ifne -> 392
    //   369: aload #26
    //   371: getfield weight : F
    //   374: fconst_0
    //   375: fcmpl
    //   376: ifle -> 392
    //   379: aload #26
    //   381: bipush #-2
    //   383: putfield width : I
    //   386: iconst_0
    //   387: istore #14
    //   389: goto -> 396
    //   392: ldc -2147483648
    //   394: istore #14
    //   396: fload_3
    //   397: fconst_0
    //   398: fcmpl
    //   399: ifne -> 411
    //   402: aload_0
    //   403: getfield mTotalLength : I
    //   406: istore #15
    //   408: goto -> 414
    //   411: iconst_0
    //   412: istore #15
    //   414: aload #26
    //   416: astore #27
    //   418: aload_0
    //   419: aload #30
    //   421: iload_1
    //   422: iload #15
    //   424: iload_2
    //   425: iconst_0
    //   426: invokespecial measureChildBeforeLayout$12802926 : (Landroid/view/View;IIII)V
    //   429: iload #14
    //   431: ldc -2147483648
    //   433: if_icmpeq -> 443
    //   436: aload #27
    //   438: iload #14
    //   440: putfield width : I
    //   443: aload #30
    //   445: invokevirtual getMeasuredWidth : ()I
    //   448: istore #19
    //   450: iload #16
    //   452: ifeq -> 481
    //   455: aload_0
    //   456: aload_0
    //   457: getfield mTotalLength : I
    //   460: aload #27
    //   462: getfield leftMargin : I
    //   465: iload #19
    //   467: iadd
    //   468: aload #27
    //   470: getfield rightMargin : I
    //   473: iadd
    //   474: iadd
    //   475: putfield mTotalLength : I
    //   478: goto -> 513
    //   481: aload_0
    //   482: getfield mTotalLength : I
    //   485: istore #14
    //   487: aload_0
    //   488: iload #14
    //   490: iload #14
    //   492: iload #19
    //   494: iadd
    //   495: aload #27
    //   497: getfield leftMargin : I
    //   500: iadd
    //   501: aload #27
    //   503: getfield rightMargin : I
    //   506: iadd
    //   507: invokestatic max : (II)I
    //   510: putfield mTotalLength : I
    //   513: iload #12
    //   515: istore #15
    //   517: iload #9
    //   519: istore #14
    //   521: iload #24
    //   523: ifeq -> 539
    //   526: iload #19
    //   528: iload #12
    //   530: invokestatic max : (II)I
    //   533: istore #15
    //   535: iload #9
    //   537: istore #14
    //   539: iload #21
    //   541: ldc 1073741824
    //   543: if_icmpeq -> 564
    //   546: aload #26
    //   548: getfield height : I
    //   551: iconst_m1
    //   552: if_icmpne -> 564
    //   555: iconst_1
    //   556: istore #9
    //   558: iconst_1
    //   559: istore #11
    //   561: goto -> 567
    //   564: iconst_0
    //   565: istore #9
    //   567: aload #26
    //   569: getfield topMargin : I
    //   572: aload #26
    //   574: getfield bottomMargin : I
    //   577: iadd
    //   578: istore #12
    //   580: aload #30
    //   582: invokevirtual getMeasuredHeight : ()I
    //   585: iload #12
    //   587: iadd
    //   588: istore #19
    //   590: iload #10
    //   592: aload #30
    //   594: invokevirtual getMeasuredState : ()I
    //   597: invokestatic combineMeasuredStates : (II)I
    //   600: istore #20
    //   602: iload #25
    //   604: ifeq -> 691
    //   607: aload #30
    //   609: invokevirtual getBaseline : ()I
    //   612: istore #22
    //   614: iload #22
    //   616: iconst_m1
    //   617: if_icmpeq -> 691
    //   620: aload #26
    //   622: getfield gravity : I
    //   625: ifge -> 637
    //   628: aload_0
    //   629: getfield mGravity : I
    //   632: istore #10
    //   634: goto -> 644
    //   637: aload #26
    //   639: getfield gravity : I
    //   642: istore #10
    //   644: iload #10
    //   646: bipush #112
    //   648: iand
    //   649: iconst_4
    //   650: ishr
    //   651: bipush #-2
    //   653: iand
    //   654: iconst_1
    //   655: ishr
    //   656: istore #10
    //   658: aload #28
    //   660: iload #10
    //   662: aload #28
    //   664: iload #10
    //   666: iaload
    //   667: iload #22
    //   669: invokestatic max : (II)I
    //   672: iastore
    //   673: aload #29
    //   675: iload #10
    //   677: aload #29
    //   679: iload #10
    //   681: iaload
    //   682: iload #19
    //   684: iload #22
    //   686: isub
    //   687: invokestatic max : (II)I
    //   690: iastore
    //   691: iload #13
    //   693: iload #19
    //   695: invokestatic max : (II)I
    //   698: istore #13
    //   700: iload #7
    //   702: ifeq -> 720
    //   705: aload #26
    //   707: getfield height : I
    //   710: iconst_m1
    //   711: if_icmpne -> 720
    //   714: iconst_1
    //   715: istore #7
    //   717: goto -> 723
    //   720: iconst_0
    //   721: istore #7
    //   723: aload #26
    //   725: getfield weight : F
    //   728: fconst_0
    //   729: fcmpl
    //   730: ifle -> 769
    //   733: iload #9
    //   735: ifeq -> 741
    //   738: goto -> 745
    //   741: iload #19
    //   743: istore #12
    //   745: iload #8
    //   747: iload #12
    //   749: invokestatic max : (II)I
    //   752: istore #8
    //   754: iload #20
    //   756: istore #10
    //   758: iload #15
    //   760: istore #12
    //   762: iload #14
    //   764: istore #9
    //   766: goto -> 793
    //   769: iload #9
    //   771: ifeq -> 777
    //   774: goto -> 781
    //   777: iload #19
    //   779: istore #12
    //   781: iload #5
    //   783: iload #12
    //   785: invokestatic max : (II)I
    //   788: istore #5
    //   790: goto -> 754
    //   793: iload #18
    //   795: iconst_1
    //   796: iadd
    //   797: istore #18
    //   799: goto -> 160
    //   802: aload_0
    //   803: getfield mTotalLength : I
    //   806: ifle -> 831
    //   809: aload_0
    //   810: iload #17
    //   812: invokevirtual hasDividerBeforeChildAt : (I)Z
    //   815: ifeq -> 831
    //   818: aload_0
    //   819: aload_0
    //   820: getfield mTotalLength : I
    //   823: aload_0
    //   824: getfield mDividerWidth : I
    //   827: iadd
    //   828: putfield mTotalLength : I
    //   831: aload #28
    //   833: iconst_1
    //   834: iaload
    //   835: iconst_m1
    //   836: if_icmpne -> 870
    //   839: aload #28
    //   841: iconst_0
    //   842: iaload
    //   843: iconst_m1
    //   844: if_icmpne -> 870
    //   847: aload #28
    //   849: iconst_2
    //   850: iaload
    //   851: iconst_m1
    //   852: if_icmpne -> 870
    //   855: iload #13
    //   857: istore #14
    //   859: aload #28
    //   861: iconst_3
    //   862: iaload
    //   863: iconst_m1
    //   864: if_icmpeq -> 928
    //   867: goto -> 870
    //   870: iload #13
    //   872: aload #28
    //   874: iconst_3
    //   875: iaload
    //   876: aload #28
    //   878: iconst_0
    //   879: iaload
    //   880: aload #28
    //   882: iconst_1
    //   883: iaload
    //   884: aload #28
    //   886: iconst_2
    //   887: iaload
    //   888: invokestatic max : (II)I
    //   891: invokestatic max : (II)I
    //   894: invokestatic max : (II)I
    //   897: aload #29
    //   899: iconst_3
    //   900: iaload
    //   901: aload #29
    //   903: iconst_0
    //   904: iaload
    //   905: aload #29
    //   907: iconst_1
    //   908: iaload
    //   909: aload #29
    //   911: iconst_2
    //   912: iaload
    //   913: invokestatic max : (II)I
    //   916: invokestatic max : (II)I
    //   919: invokestatic max : (II)I
    //   922: iadd
    //   923: invokestatic max : (II)I
    //   926: istore #14
    //   928: iload #24
    //   930: ifeq -> 1098
    //   933: iload #6
    //   935: istore #15
    //   937: iload #15
    //   939: ldc -2147483648
    //   941: if_icmpeq -> 963
    //   944: iload #10
    //   946: istore #13
    //   948: iload #15
    //   950: ifne -> 956
    //   953: goto -> 963
    //   956: iload #13
    //   958: istore #10
    //   960: goto -> 1098
    //   963: aload_0
    //   964: iconst_0
    //   965: putfield mTotalLength : I
    //   968: iconst_0
    //   969: istore #15
    //   971: iload #10
    //   973: istore #13
    //   975: iload #15
    //   977: iload #17
    //   979: if_icmpge -> 956
    //   982: aload_0
    //   983: iload #15
    //   985: invokevirtual getChildAt : (I)Landroid/view/View;
    //   988: astore #26
    //   990: aload #26
    //   992: ifnonnull -> 1006
    //   995: aload_0
    //   996: aload_0
    //   997: getfield mTotalLength : I
    //   1000: putfield mTotalLength : I
    //   1003: goto -> 1089
    //   1006: aload #26
    //   1008: invokevirtual getVisibility : ()I
    //   1011: bipush #8
    //   1013: if_icmpeq -> 1003
    //   1016: aload #26
    //   1018: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   1021: checkcast android/support/v7/widget/LinearLayoutCompat$LayoutParams
    //   1024: astore #26
    //   1026: iload #16
    //   1028: ifeq -> 1057
    //   1031: aload_0
    //   1032: aload_0
    //   1033: getfield mTotalLength : I
    //   1036: aload #26
    //   1038: getfield leftMargin : I
    //   1041: iload #12
    //   1043: iadd
    //   1044: aload #26
    //   1046: getfield rightMargin : I
    //   1049: iadd
    //   1050: iadd
    //   1051: putfield mTotalLength : I
    //   1054: goto -> 1003
    //   1057: aload_0
    //   1058: getfield mTotalLength : I
    //   1061: istore #13
    //   1063: aload_0
    //   1064: iload #13
    //   1066: iload #13
    //   1068: iload #12
    //   1070: iadd
    //   1071: aload #26
    //   1073: getfield leftMargin : I
    //   1076: iadd
    //   1077: aload #26
    //   1079: getfield rightMargin : I
    //   1082: iadd
    //   1083: invokestatic max : (II)I
    //   1086: putfield mTotalLength : I
    //   1089: iload #15
    //   1091: iconst_1
    //   1092: iadd
    //   1093: istore #15
    //   1095: goto -> 971
    //   1098: iload #6
    //   1100: istore #15
    //   1102: aload_0
    //   1103: aload_0
    //   1104: getfield mTotalLength : I
    //   1107: aload_0
    //   1108: invokevirtual getPaddingLeft : ()I
    //   1111: aload_0
    //   1112: invokevirtual getPaddingRight : ()I
    //   1115: iadd
    //   1116: iadd
    //   1117: putfield mTotalLength : I
    //   1120: aload_0
    //   1121: getfield mTotalLength : I
    //   1124: aload_0
    //   1125: invokevirtual getSuggestedMinimumWidth : ()I
    //   1128: invokestatic max : (II)I
    //   1131: iload_1
    //   1132: iconst_0
    //   1133: invokestatic resolveSizeAndState : (III)I
    //   1136: istore #19
    //   1138: ldc_w 16777215
    //   1141: iload #19
    //   1143: iand
    //   1144: aload_0
    //   1145: getfield mTotalLength : I
    //   1148: isub
    //   1149: istore #6
    //   1151: iload #9
    //   1153: ifne -> 1278
    //   1156: iload #6
    //   1158: ifeq -> 1170
    //   1161: fload_3
    //   1162: fconst_0
    //   1163: fcmpl
    //   1164: ifle -> 1170
    //   1167: goto -> 1278
    //   1170: iload #5
    //   1172: iload #8
    //   1174: invokestatic max : (II)I
    //   1177: istore #6
    //   1179: iload #24
    //   1181: ifeq -> 1271
    //   1184: iload #15
    //   1186: ldc 1073741824
    //   1188: if_icmpeq -> 1271
    //   1191: iconst_0
    //   1192: istore #5
    //   1194: iload #5
    //   1196: iload #17
    //   1198: if_icmpge -> 1271
    //   1201: aload_0
    //   1202: iload #5
    //   1204: invokevirtual getChildAt : (I)Landroid/view/View;
    //   1207: astore #26
    //   1209: aload #26
    //   1211: ifnull -> 1262
    //   1214: aload #26
    //   1216: invokevirtual getVisibility : ()I
    //   1219: bipush #8
    //   1221: if_icmpeq -> 1262
    //   1224: aload #26
    //   1226: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   1229: checkcast android/support/v7/widget/LinearLayoutCompat$LayoutParams
    //   1232: getfield weight : F
    //   1235: fconst_0
    //   1236: fcmpl
    //   1237: ifle -> 1262
    //   1240: aload #26
    //   1242: iload #12
    //   1244: ldc 1073741824
    //   1246: invokestatic makeMeasureSpec : (II)I
    //   1249: aload #26
    //   1251: invokevirtual getMeasuredHeight : ()I
    //   1254: ldc 1073741824
    //   1256: invokestatic makeMeasureSpec : (II)I
    //   1259: invokevirtual measure : (II)V
    //   1262: iload #5
    //   1264: iconst_1
    //   1265: iadd
    //   1266: istore #5
    //   1268: goto -> 1194
    //   1271: iload #17
    //   1273: istore #5
    //   1275: goto -> 2008
    //   1278: aload_0
    //   1279: getfield mWeightSum : F
    //   1282: fconst_0
    //   1283: fcmpl
    //   1284: ifle -> 1292
    //   1287: aload_0
    //   1288: getfield mWeightSum : F
    //   1291: fstore_3
    //   1292: aload #28
    //   1294: iconst_3
    //   1295: iconst_m1
    //   1296: iastore
    //   1297: aload #28
    //   1299: iconst_2
    //   1300: iconst_m1
    //   1301: iastore
    //   1302: aload #28
    //   1304: iconst_1
    //   1305: iconst_m1
    //   1306: iastore
    //   1307: aload #28
    //   1309: iconst_0
    //   1310: iconst_m1
    //   1311: iastore
    //   1312: aload #29
    //   1314: iconst_3
    //   1315: iconst_m1
    //   1316: iastore
    //   1317: aload #29
    //   1319: iconst_2
    //   1320: iconst_m1
    //   1321: iastore
    //   1322: aload #29
    //   1324: iconst_1
    //   1325: iconst_m1
    //   1326: iastore
    //   1327: aload #29
    //   1329: iconst_0
    //   1330: iconst_m1
    //   1331: iastore
    //   1332: aload_0
    //   1333: iconst_0
    //   1334: putfield mTotalLength : I
    //   1337: iconst_m1
    //   1338: istore #13
    //   1340: iconst_0
    //   1341: istore #12
    //   1343: iload #7
    //   1345: istore #8
    //   1347: iload #5
    //   1349: istore #9
    //   1351: iload #10
    //   1353: istore #5
    //   1355: iload #17
    //   1357: istore #7
    //   1359: iload #13
    //   1361: istore #10
    //   1363: iload #12
    //   1365: iload #7
    //   1367: if_icmpge -> 1870
    //   1370: aload_0
    //   1371: iload #12
    //   1373: invokevirtual getChildAt : (I)Landroid/view/View;
    //   1376: astore #26
    //   1378: aload #26
    //   1380: ifnull -> 1861
    //   1383: aload #26
    //   1385: invokevirtual getVisibility : ()I
    //   1388: bipush #8
    //   1390: if_icmpeq -> 1861
    //   1393: aload #26
    //   1395: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   1398: checkcast android/support/v7/widget/LinearLayoutCompat$LayoutParams
    //   1401: astore #27
    //   1403: aload #27
    //   1405: getfield weight : F
    //   1408: fstore #4
    //   1410: fload #4
    //   1412: fconst_0
    //   1413: fcmpl
    //   1414: ifle -> 1587
    //   1417: iload #6
    //   1419: i2f
    //   1420: fload #4
    //   1422: fmul
    //   1423: fload_3
    //   1424: fdiv
    //   1425: f2i
    //   1426: istore #14
    //   1428: aload_0
    //   1429: invokevirtual getPaddingTop : ()I
    //   1432: istore #17
    //   1434: aload_0
    //   1435: invokevirtual getPaddingBottom : ()I
    //   1438: istore #18
    //   1440: fload_3
    //   1441: fload #4
    //   1443: fsub
    //   1444: fstore_3
    //   1445: aload #27
    //   1447: getfield topMargin : I
    //   1450: istore #20
    //   1452: aload #27
    //   1454: getfield bottomMargin : I
    //   1457: istore #22
    //   1459: aload #27
    //   1461: getfield height : I
    //   1464: istore #23
    //   1466: iload #6
    //   1468: iload #14
    //   1470: isub
    //   1471: istore #13
    //   1473: iload_2
    //   1474: iload #17
    //   1476: iload #18
    //   1478: iadd
    //   1479: iload #20
    //   1481: iadd
    //   1482: iload #22
    //   1484: iadd
    //   1485: iload #23
    //   1487: invokestatic getChildMeasureSpec : (III)I
    //   1490: istore #17
    //   1492: aload #27
    //   1494: getfield width : I
    //   1497: ifne -> 1528
    //   1500: iload #15
    //   1502: ldc 1073741824
    //   1504: if_icmpeq -> 1510
    //   1507: goto -> 1528
    //   1510: iload #14
    //   1512: ifle -> 1522
    //   1515: iload #14
    //   1517: istore #6
    //   1519: goto -> 1550
    //   1522: iconst_0
    //   1523: istore #6
    //   1525: goto -> 1550
    //   1528: aload #26
    //   1530: invokevirtual getMeasuredWidth : ()I
    //   1533: iload #14
    //   1535: iadd
    //   1536: istore #14
    //   1538: iload #14
    //   1540: istore #6
    //   1542: iload #14
    //   1544: ifge -> 1550
    //   1547: iconst_0
    //   1548: istore #6
    //   1550: aload #26
    //   1552: iload #6
    //   1554: ldc 1073741824
    //   1556: invokestatic makeMeasureSpec : (II)I
    //   1559: iload #17
    //   1561: invokevirtual measure : (II)V
    //   1564: iload #5
    //   1566: aload #26
    //   1568: invokevirtual getMeasuredState : ()I
    //   1571: ldc_w -16777216
    //   1574: iand
    //   1575: invokestatic combineMeasuredStates : (II)I
    //   1578: istore #5
    //   1580: iload #13
    //   1582: istore #6
    //   1584: goto -> 1587
    //   1587: iload #16
    //   1589: ifeq -> 1621
    //   1592: aload_0
    //   1593: aload_0
    //   1594: getfield mTotalLength : I
    //   1597: aload #26
    //   1599: invokevirtual getMeasuredWidth : ()I
    //   1602: aload #27
    //   1604: getfield leftMargin : I
    //   1607: iadd
    //   1608: aload #27
    //   1610: getfield rightMargin : I
    //   1613: iadd
    //   1614: iadd
    //   1615: putfield mTotalLength : I
    //   1618: goto -> 1656
    //   1621: aload_0
    //   1622: getfield mTotalLength : I
    //   1625: istore #13
    //   1627: aload_0
    //   1628: iload #13
    //   1630: aload #26
    //   1632: invokevirtual getMeasuredWidth : ()I
    //   1635: iload #13
    //   1637: iadd
    //   1638: aload #27
    //   1640: getfield leftMargin : I
    //   1643: iadd
    //   1644: aload #27
    //   1646: getfield rightMargin : I
    //   1649: iadd
    //   1650: invokestatic max : (II)I
    //   1653: putfield mTotalLength : I
    //   1656: iload #21
    //   1658: ldc 1073741824
    //   1660: if_icmpeq -> 1678
    //   1663: aload #27
    //   1665: getfield height : I
    //   1668: iconst_m1
    //   1669: if_icmpne -> 1678
    //   1672: iconst_1
    //   1673: istore #13
    //   1675: goto -> 1681
    //   1678: iconst_0
    //   1679: istore #13
    //   1681: aload #27
    //   1683: getfield topMargin : I
    //   1686: aload #27
    //   1688: getfield bottomMargin : I
    //   1691: iadd
    //   1692: istore #18
    //   1694: aload #26
    //   1696: invokevirtual getMeasuredHeight : ()I
    //   1699: iload #18
    //   1701: iadd
    //   1702: istore #17
    //   1704: iload #10
    //   1706: iload #17
    //   1708: invokestatic max : (II)I
    //   1711: istore #14
    //   1713: iload #13
    //   1715: ifeq -> 1725
    //   1718: iload #18
    //   1720: istore #10
    //   1722: goto -> 1729
    //   1725: iload #17
    //   1727: istore #10
    //   1729: iload #9
    //   1731: iload #10
    //   1733: invokestatic max : (II)I
    //   1736: istore #10
    //   1738: iload #8
    //   1740: ifeq -> 1758
    //   1743: aload #27
    //   1745: getfield height : I
    //   1748: iconst_m1
    //   1749: if_icmpne -> 1758
    //   1752: iconst_1
    //   1753: istore #8
    //   1755: goto -> 1761
    //   1758: iconst_0
    //   1759: istore #8
    //   1761: iload #25
    //   1763: ifeq -> 1850
    //   1766: aload #26
    //   1768: invokevirtual getBaseline : ()I
    //   1771: istore #13
    //   1773: iload #13
    //   1775: iconst_m1
    //   1776: if_icmpeq -> 1850
    //   1779: aload #27
    //   1781: getfield gravity : I
    //   1784: ifge -> 1796
    //   1787: aload_0
    //   1788: getfield mGravity : I
    //   1791: istore #9
    //   1793: goto -> 1803
    //   1796: aload #27
    //   1798: getfield gravity : I
    //   1801: istore #9
    //   1803: iload #9
    //   1805: bipush #112
    //   1807: iand
    //   1808: iconst_4
    //   1809: ishr
    //   1810: bipush #-2
    //   1812: iand
    //   1813: iconst_1
    //   1814: ishr
    //   1815: istore #9
    //   1817: aload #28
    //   1819: iload #9
    //   1821: aload #28
    //   1823: iload #9
    //   1825: iaload
    //   1826: iload #13
    //   1828: invokestatic max : (II)I
    //   1831: iastore
    //   1832: aload #29
    //   1834: iload #9
    //   1836: aload #29
    //   1838: iload #9
    //   1840: iaload
    //   1841: iload #17
    //   1843: iload #13
    //   1845: isub
    //   1846: invokestatic max : (II)I
    //   1849: iastore
    //   1850: iload #10
    //   1852: istore #9
    //   1854: iload #14
    //   1856: istore #10
    //   1858: goto -> 1861
    //   1861: iload #12
    //   1863: iconst_1
    //   1864: iadd
    //   1865: istore #12
    //   1867: goto -> 1363
    //   1870: aload_0
    //   1871: aload_0
    //   1872: getfield mTotalLength : I
    //   1875: aload_0
    //   1876: invokevirtual getPaddingLeft : ()I
    //   1879: aload_0
    //   1880: invokevirtual getPaddingRight : ()I
    //   1883: iadd
    //   1884: iadd
    //   1885: putfield mTotalLength : I
    //   1888: aload #28
    //   1890: iconst_1
    //   1891: iaload
    //   1892: iconst_m1
    //   1893: if_icmpne -> 1930
    //   1896: aload #28
    //   1898: iconst_0
    //   1899: iaload
    //   1900: iconst_m1
    //   1901: if_icmpne -> 1930
    //   1904: aload #28
    //   1906: iconst_2
    //   1907: iaload
    //   1908: iconst_m1
    //   1909: if_icmpne -> 1930
    //   1912: aload #28
    //   1914: iconst_3
    //   1915: iaload
    //   1916: iconst_m1
    //   1917: if_icmpeq -> 1923
    //   1920: goto -> 1930
    //   1923: iload #10
    //   1925: istore #6
    //   1927: goto -> 1988
    //   1930: iload #10
    //   1932: aload #28
    //   1934: iconst_3
    //   1935: iaload
    //   1936: aload #28
    //   1938: iconst_0
    //   1939: iaload
    //   1940: aload #28
    //   1942: iconst_1
    //   1943: iaload
    //   1944: aload #28
    //   1946: iconst_2
    //   1947: iaload
    //   1948: invokestatic max : (II)I
    //   1951: invokestatic max : (II)I
    //   1954: invokestatic max : (II)I
    //   1957: aload #29
    //   1959: iconst_3
    //   1960: iaload
    //   1961: aload #29
    //   1963: iconst_0
    //   1964: iaload
    //   1965: aload #29
    //   1967: iconst_1
    //   1968: iaload
    //   1969: aload #29
    //   1971: iconst_2
    //   1972: iaload
    //   1973: invokestatic max : (II)I
    //   1976: invokestatic max : (II)I
    //   1979: invokestatic max : (II)I
    //   1982: iadd
    //   1983: invokestatic max : (II)I
    //   1986: istore #6
    //   1988: iload #5
    //   1990: istore #10
    //   1992: iload #7
    //   1994: istore #5
    //   1996: iload #8
    //   1998: istore #7
    //   2000: iload #6
    //   2002: istore #14
    //   2004: iload #9
    //   2006: istore #6
    //   2008: iload #14
    //   2010: istore #8
    //   2012: iload #7
    //   2014: ifne -> 2032
    //   2017: iload #14
    //   2019: istore #8
    //   2021: iload #21
    //   2023: ldc 1073741824
    //   2025: if_icmpeq -> 2032
    //   2028: iload #6
    //   2030: istore #8
    //   2032: aload_0
    //   2033: iload #10
    //   2035: ldc_w -16777216
    //   2038: iand
    //   2039: iload #19
    //   2041: ior
    //   2042: iload #8
    //   2044: aload_0
    //   2045: invokevirtual getPaddingTop : ()I
    //   2048: aload_0
    //   2049: invokevirtual getPaddingBottom : ()I
    //   2052: iadd
    //   2053: iadd
    //   2054: aload_0
    //   2055: invokevirtual getSuggestedMinimumHeight : ()I
    //   2058: invokestatic max : (II)I
    //   2061: iload_2
    //   2062: iload #10
    //   2064: bipush #16
    //   2066: ishl
    //   2067: invokestatic resolveSizeAndState : (III)I
    //   2070: invokevirtual setMeasuredDimension : (II)V
    //   2073: iload #11
    //   2075: ifeq -> 2178
    //   2078: aload_0
    //   2079: invokevirtual getMeasuredHeight : ()I
    //   2082: ldc 1073741824
    //   2084: invokestatic makeMeasureSpec : (II)I
    //   2087: istore #6
    //   2089: iconst_0
    //   2090: istore_2
    //   2091: iload_2
    //   2092: iload #5
    //   2094: if_icmpge -> 2178
    //   2097: aload_0
    //   2098: iload_2
    //   2099: invokevirtual getChildAt : (I)Landroid/view/View;
    //   2102: astore #26
    //   2104: aload #26
    //   2106: invokevirtual getVisibility : ()I
    //   2109: bipush #8
    //   2111: if_icmpeq -> 2171
    //   2114: aload #26
    //   2116: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   2119: checkcast android/support/v7/widget/LinearLayoutCompat$LayoutParams
    //   2122: astore #27
    //   2124: aload #27
    //   2126: getfield height : I
    //   2129: iconst_m1
    //   2130: if_icmpne -> 2171
    //   2133: aload #27
    //   2135: getfield width : I
    //   2138: istore #7
    //   2140: aload #27
    //   2142: aload #26
    //   2144: invokevirtual getMeasuredWidth : ()I
    //   2147: putfield width : I
    //   2150: aload_0
    //   2151: aload #26
    //   2153: iload_1
    //   2154: iconst_0
    //   2155: iload #6
    //   2157: iconst_0
    //   2158: invokevirtual measureChildWithMargins : (Landroid/view/View;IIII)V
    //   2161: aload #27
    //   2163: iload #7
    //   2165: putfield width : I
    //   2168: goto -> 2171
    //   2171: iload_2
    //   2172: iconst_1
    //   2173: iadd
    //   2174: istore_2
    //   2175: goto -> 2091
    //   2178: return
  }
  
  private static void setChildFrame(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    paramView.layout(paramInt1, paramInt2, paramInt3 + paramInt1, paramInt4 + paramInt2);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return paramLayoutParams instanceof LinearLayoutCompat$LayoutParams;
  }
  
  protected LinearLayoutCompat$LayoutParams generateDefaultLayoutParams() {
    return (this.mOrientation == 0) ? new LinearLayoutCompat$LayoutParams(-2, -2) : ((this.mOrientation == 1) ? new LinearLayoutCompat$LayoutParams(-1, -2) : null);
  }
  
  public LinearLayoutCompat$LayoutParams generateLayoutParams(AttributeSet paramAttributeSet) {
    return new LinearLayoutCompat$LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected LinearLayoutCompat$LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return new LinearLayoutCompat$LayoutParams(paramLayoutParams);
  }
  
  public int getBaseline() {
    if (this.mBaselineAlignedChildIndex < 0)
      return super.getBaseline(); 
    if (getChildCount() > this.mBaselineAlignedChildIndex) {
      View view = getChildAt(this.mBaselineAlignedChildIndex);
      int k = view.getBaseline();
      if (k == -1) {
        if (this.mBaselineAlignedChildIndex == 0)
          return -1; 
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
      } 
      int j = this.mBaselineChildTop;
      int i = j;
      if (this.mOrientation == 1) {
        int m = this.mGravity & 0x70;
        i = j;
        if (m != 48)
          if (m != 16) {
            if (m != 80) {
              i = j;
            } else {
              i = getBottom() - getTop() - getPaddingBottom() - this.mTotalLength;
            } 
          } else {
            i = j + (getBottom() - getTop() - getPaddingTop() - getPaddingBottom() - this.mTotalLength) / 2;
          }  
      } 
      return i + ((LinearLayoutCompat$LayoutParams)view.getLayoutParams()).topMargin + k;
    } 
    throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
  }
  
  protected final boolean hasDividerBeforeChildAt(int paramInt) {
    if (paramInt == 0)
      return ((this.mShowDividers & 0x1) != 0); 
    if (paramInt == getChildCount())
      return ((this.mShowDividers & 0x4) != 0); 
    if ((this.mShowDividers & 0x2) != 0) {
      while (--paramInt >= 0) {
        if (getChildAt(paramInt).getVisibility() != 8)
          return true; 
        paramInt--;
      } 
      return false;
    } 
    return false;
  }
  
  protected void onDraw(Canvas paramCanvas) {
    if (this.mDivider == null)
      return; 
    int k = this.mOrientation;
    int j = 0;
    int i = 0;
    if (k == 1) {
      j = getChildCount();
      while (i < j) {
        View view = getChildAt(i);
        if (view != null && view.getVisibility() != 8 && hasDividerBeforeChildAt(i)) {
          LinearLayoutCompat$LayoutParams linearLayoutCompat$LayoutParams = (LinearLayoutCompat$LayoutParams)view.getLayoutParams();
          drawHorizontalDivider(paramCanvas, view.getTop() - linearLayoutCompat$LayoutParams.topMargin - this.mDividerHeight);
        } 
        i++;
      } 
      if (hasDividerBeforeChildAt(j)) {
        View view = getChildAt(j - 1);
        if (view == null) {
          i = getHeight() - getPaddingBottom() - this.mDividerHeight;
        } else {
          LinearLayoutCompat$LayoutParams linearLayoutCompat$LayoutParams = (LinearLayoutCompat$LayoutParams)view.getLayoutParams();
          i = view.getBottom() + linearLayoutCompat$LayoutParams.bottomMargin;
        } 
        drawHorizontalDivider(paramCanvas, i);
      } 
      return;
    } 
    k = getChildCount();
    boolean bool = ViewUtils.isLayoutRtl((View)this);
    for (i = j; i < k; i++) {
      View view = getChildAt(i);
      if (view != null && view.getVisibility() != 8 && hasDividerBeforeChildAt(i)) {
        LinearLayoutCompat$LayoutParams linearLayoutCompat$LayoutParams = (LinearLayoutCompat$LayoutParams)view.getLayoutParams();
        if (bool) {
          j = view.getRight() + linearLayoutCompat$LayoutParams.rightMargin;
        } else {
          j = view.getLeft() - linearLayoutCompat$LayoutParams.leftMargin - this.mDividerWidth;
        } 
        drawVerticalDivider(paramCanvas, j);
      } 
    } 
    if (hasDividerBeforeChildAt(k)) {
      View view = getChildAt(k - 1);
      if (view == null) {
        if (bool) {
          i = getPaddingLeft();
        } else {
          i = getWidth() - getPaddingRight() - this.mDividerWidth;
        } 
      } else {
        LinearLayoutCompat$LayoutParams linearLayoutCompat$LayoutParams = (LinearLayoutCompat$LayoutParams)view.getLayoutParams();
        if (bool) {
          i = view.getLeft() - linearLayoutCompat$LayoutParams.leftMargin - this.mDividerWidth;
        } else {
          i = view.getRight() + linearLayoutCompat$LayoutParams.rightMargin;
        } 
      } 
      drawVerticalDivider(paramCanvas, i);
    } 
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent) {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(LinearLayoutCompat.class.getName());
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo) {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(LinearLayoutCompat.class.getName());
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    byte b;
    if (this.mOrientation == 1) {
      b = getPaddingLeft();
      int i2 = paramInt3 - paramInt1;
      int i3 = getPaddingRight();
      int i4 = getPaddingRight();
      int i5 = getChildCount();
      paramInt1 = this.mGravity & 0x70;
      int i6 = this.mGravity;
      if (paramInt1 != 16) {
        if (paramInt1 != 80) {
          paramInt1 = getPaddingTop();
        } else {
          paramInt1 = getPaddingTop() + paramInt4 - paramInt2 - this.mTotalLength;
        } 
      } else {
        paramInt1 = getPaddingTop();
        paramInt1 = (paramInt4 - paramInt2 - this.mTotalLength) / 2 + paramInt1;
      } 
      paramInt3 = 0;
      while (paramInt3 < i5) {
        View view = getChildAt(paramInt3);
        paramInt2 = paramInt1;
        if (view != null) {
          paramInt2 = paramInt1;
          if (view.getVisibility() != 8) {
            int i7 = view.getMeasuredWidth();
            int i8 = view.getMeasuredHeight();
            LinearLayoutCompat$LayoutParams linearLayoutCompat$LayoutParams = (LinearLayoutCompat$LayoutParams)view.getLayoutParams();
            paramInt4 = linearLayoutCompat$LayoutParams.gravity;
            paramInt2 = paramInt4;
            if (paramInt4 < 0)
              paramInt2 = 0x800007 & i6; 
            paramInt2 = GravityCompat.getAbsoluteGravity(paramInt2, ViewCompat.getLayoutDirection((View)this)) & 0x7;
            if (paramInt2 != 1) {
              if (paramInt2 != 5) {
                paramInt2 = linearLayoutCompat$LayoutParams.leftMargin + b;
              } else {
                paramInt2 = i2 - i3 - i7 - linearLayoutCompat$LayoutParams.rightMargin;
              } 
            } else {
              paramInt2 = (i2 - b - i4 - i7) / 2 + b + linearLayoutCompat$LayoutParams.leftMargin - linearLayoutCompat$LayoutParams.rightMargin;
            } 
            paramInt4 = paramInt1;
            if (hasDividerBeforeChildAt(paramInt3))
              paramInt4 = paramInt1 + this.mDividerHeight; 
            paramInt1 = paramInt4 + linearLayoutCompat$LayoutParams.topMargin;
            setChildFrame(view, paramInt2, paramInt1, i7, i8);
            paramInt2 = paramInt1 + i8 + linearLayoutCompat$LayoutParams.bottomMargin;
          } 
        } 
        paramInt3++;
        paramInt1 = paramInt2;
      } 
      return;
    } 
    boolean bool = ViewUtils.isLayoutRtl((View)this);
    int k = getPaddingTop();
    int m = paramInt4 - paramInt2;
    int n = getPaddingBottom();
    int i1 = getPaddingBottom();
    int i = getChildCount();
    paramInt4 = this.mGravity;
    paramInt2 = this.mGravity & 0x70;
    paramBoolean = this.mBaselineAligned;
    int[] arrayOfInt1 = this.mMaxAscent;
    int[] arrayOfInt2 = this.mMaxDescent;
    paramInt4 = GravityCompat.getAbsoluteGravity(0x800007 & paramInt4, ViewCompat.getLayoutDirection((View)this));
    if (paramInt4 != 1) {
      if (paramInt4 != 5) {
        paramInt1 = getPaddingLeft();
      } else {
        paramInt1 = getPaddingLeft() + paramInt3 - paramInt1 - this.mTotalLength;
      } 
    } else {
      paramInt4 = getPaddingLeft();
      paramInt1 = (paramInt3 - paramInt1 - this.mTotalLength) / 2 + paramInt4;
    } 
    if (bool) {
      paramInt4 = i - 1;
      b = -1;
    } else {
      paramInt4 = 0;
      b = 1;
    } 
    int j = 0;
    paramInt3 = paramInt1;
    while (j < i) {
      int i2 = b * j + paramInt4;
      View view = getChildAt(i2);
      if (view != null && view.getVisibility() != 8) {
        int i5 = view.getMeasuredWidth();
        int i6 = view.getMeasuredHeight();
        LinearLayoutCompat$LayoutParams linearLayoutCompat$LayoutParams = (LinearLayoutCompat$LayoutParams)view.getLayoutParams();
        if (paramBoolean && linearLayoutCompat$LayoutParams.height != -1) {
          paramInt1 = view.getBaseline();
        } else {
          paramInt1 = -1;
        } 
        int i4 = linearLayoutCompat$LayoutParams.gravity;
        int i3 = i4;
        if (i4 < 0)
          i3 = paramInt2; 
        i3 &= 0x70;
        if (i3 != 16) {
          if (i3 != 48) {
            if (i3 != 80) {
              paramInt1 = k;
            } else {
              i3 = m - n - i6 - linearLayoutCompat$LayoutParams.bottomMargin;
              if (paramInt1 != -1) {
                i4 = view.getMeasuredHeight();
                paramInt1 = i3 - arrayOfInt2[2] - i4 - paramInt1;
              } else {
                paramInt1 = i3;
              } 
            } 
          } else {
            i3 = linearLayoutCompat$LayoutParams.topMargin + k;
            if (paramInt1 != -1) {
              paramInt1 = i3 + arrayOfInt1[1] - paramInt1;
            } else {
              paramInt1 = i3;
            } 
          } 
        } else {
          paramInt1 = (m - k - i1 - i6) / 2 + k + linearLayoutCompat$LayoutParams.topMargin - linearLayoutCompat$LayoutParams.bottomMargin;
        } 
        i3 = paramInt3;
        if (hasDividerBeforeChildAt(i2))
          i3 = paramInt3 + this.mDividerWidth; 
        paramInt3 = i3 + linearLayoutCompat$LayoutParams.leftMargin;
        setChildFrame(view, paramInt3, paramInt1, i5, i6);
        paramInt3 += i5 + linearLayoutCompat$LayoutParams.rightMargin;
      } 
      j++;
    } 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    if (this.mOrientation == 1) {
      this.mTotalLength = 0;
      int i3 = getChildCount();
      int i7 = View.MeasureSpec.getMode(paramInt1);
      int k = View.MeasureSpec.getMode(paramInt2);
      int i8 = this.mBaselineAlignedChildIndex;
      boolean bool1 = this.mUseLargestChild;
      float f = 0.0F;
      int i2 = 0;
      int i = 0;
      int i1 = 0;
      int j = 0;
      int i4 = 0;
      int m = 0;
      int i5 = 0;
      int n = 1;
      boolean bool = false;
      while (i4 < i3) {
        View view = getChildAt(i4);
        if (view == null) {
          this.mTotalLength = this.mTotalLength;
        } else if (view.getVisibility() != 8) {
          if (hasDividerBeforeChildAt(i4))
            this.mTotalLength += this.mDividerHeight; 
          LinearLayoutCompat$LayoutParams linearLayoutCompat$LayoutParams = (LinearLayoutCompat$LayoutParams)view.getLayoutParams();
          f += linearLayoutCompat$LayoutParams.weight;
          if (k == 1073741824 && linearLayoutCompat$LayoutParams.height == 0 && linearLayoutCompat$LayoutParams.weight > 0.0F) {
            i5 = this.mTotalLength;
            this.mTotalLength = Math.max(i5, linearLayoutCompat$LayoutParams.topMargin + i5 + linearLayoutCompat$LayoutParams.bottomMargin);
            i5 = 1;
          } else {
            if (linearLayoutCompat$LayoutParams.height == 0 && linearLayoutCompat$LayoutParams.weight > 0.0F) {
              linearLayoutCompat$LayoutParams.height = -2;
              i10 = 0;
            } else {
              i10 = Integer.MIN_VALUE;
            } 
            if (f == 0.0F) {
              i11 = this.mTotalLength;
            } else {
              i11 = 0;
            } 
            measureChildBeforeLayout$12802926(view, paramInt1, 0, paramInt2, i11);
            if (i10 != Integer.MIN_VALUE)
              linearLayoutCompat$LayoutParams.height = i10; 
            int i10 = view.getMeasuredHeight();
            int i11 = this.mTotalLength;
            this.mTotalLength = Math.max(i11, i11 + i10 + linearLayoutCompat$LayoutParams.topMargin + linearLayoutCompat$LayoutParams.bottomMargin);
            if (bool1)
              i = Math.max(i10, i); 
          } 
          int i9 = j;
          j = i4;
          if (i8 >= 0 && i8 == j + 1)
            this.mBaselineChildTop = this.mTotalLength; 
          if (j >= i8 || linearLayoutCompat$LayoutParams.weight <= 0.0F) {
            boolean bool2;
            if (i7 != 1073741824 && linearLayoutCompat$LayoutParams.width == -1) {
              bool2 = true;
              bool = true;
            } else {
              bool2 = false;
            } 
            int i10 = linearLayoutCompat$LayoutParams.leftMargin + linearLayoutCompat$LayoutParams.rightMargin;
            int i11 = view.getMeasuredWidth() + i10;
            i2 = Math.max(i2, i11);
            m = View.combineMeasuredStates(m, view.getMeasuredState());
            if (n && linearLayoutCompat$LayoutParams.width == -1) {
              j = 1;
            } else {
              j = 0;
            } 
            if (linearLayoutCompat$LayoutParams.weight > 0.0F) {
              if (!bool2)
                i10 = i11; 
              i1 = Math.max(i1, i10);
              n = j;
              j = i9;
            } else {
              if (!bool2)
                i10 = i11; 
              i9 = Math.max(i9, i10);
              n = j;
              j = i9;
            } 
          } else {
            throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
          } 
        } 
        i4++;
      } 
      if (this.mTotalLength > 0 && hasDividerBeforeChildAt(i3))
        this.mTotalLength += this.mDividerHeight; 
      i4 = i3;
      if (bool1) {
        i3 = k;
        if (i3 == Integer.MIN_VALUE || i3 == 0) {
          this.mTotalLength = 0;
          for (i3 = 0; i3 < i4; i3++) {
            View view = getChildAt(i3);
            if (view == null) {
              this.mTotalLength = this.mTotalLength;
            } else if (view.getVisibility() != 8) {
              LinearLayoutCompat$LayoutParams linearLayoutCompat$LayoutParams = (LinearLayoutCompat$LayoutParams)view.getLayoutParams();
              int i9 = this.mTotalLength;
              this.mTotalLength = Math.max(i9, i9 + i + linearLayoutCompat$LayoutParams.topMargin + linearLayoutCompat$LayoutParams.bottomMargin);
            } 
          } 
        } 
      } 
      i3 = k;
      this.mTotalLength += getPaddingTop() + getPaddingBottom();
      int i6 = View.resolveSizeAndState(Math.max(this.mTotalLength, getSuggestedMinimumHeight()), paramInt2, 0);
      k = (0xFFFFFF & i6) - this.mTotalLength;
      if (i5 != 0 || (k != 0 && f > 0.0F)) {
        if (this.mWeightSum > 0.0F)
          f = this.mWeightSum; 
        this.mTotalLength = 0;
        i5 = 0;
        i = k;
        i1 = i2;
        k = j;
        i2 = i3;
        for (i3 = i5; i3 < i4; i3++) {
          View view = getChildAt(i3);
          if (view.getVisibility() != 8) {
            LinearLayoutCompat$LayoutParams linearLayoutCompat$LayoutParams = (LinearLayoutCompat$LayoutParams)view.getLayoutParams();
            float f1 = linearLayoutCompat$LayoutParams.weight;
            if (f1 > 0.0F) {
              i5 = (int)(i * f1 / f);
              j = getPaddingLeft();
              int i11 = getPaddingRight();
              f -= f1;
              int i12 = getChildMeasureSpec(paramInt1, j + i11 + linearLayoutCompat$LayoutParams.leftMargin + linearLayoutCompat$LayoutParams.rightMargin, linearLayoutCompat$LayoutParams.width);
              if (linearLayoutCompat$LayoutParams.height != 0 || i2 != 1073741824) {
                i11 = view.getMeasuredHeight() + i5;
                j = i11;
                if (i11 < 0)
                  j = 0; 
              } else if (i5 > 0) {
                j = i5;
              } else {
                j = 0;
              } 
              view.measure(i12, View.MeasureSpec.makeMeasureSpec(j, 1073741824));
              m = View.combineMeasuredStates(m, view.getMeasuredState() & 0xFFFFFF00);
              i -= i5;
            } 
            int i9 = linearLayoutCompat$LayoutParams.leftMargin + linearLayoutCompat$LayoutParams.rightMargin;
            int i10 = view.getMeasuredWidth() + i9;
            i5 = Math.max(i1, i10);
            if (i7 != 1073741824 && linearLayoutCompat$LayoutParams.width == -1) {
              j = 1;
            } else {
              j = 0;
            } 
            i1 = i10;
            if (j != 0)
              i1 = i9; 
            k = Math.max(k, i1);
            if (n != 0 && linearLayoutCompat$LayoutParams.width == -1) {
              j = 1;
            } else {
              j = 0;
            } 
            n = this.mTotalLength;
            this.mTotalLength = Math.max(n, view.getMeasuredHeight() + n + linearLayoutCompat$LayoutParams.topMargin + linearLayoutCompat$LayoutParams.bottomMargin);
            i1 = i5;
            n = j;
          } 
        } 
        this.mTotalLength += getPaddingTop() + getPaddingBottom();
        i = k;
      } else {
        k = Math.max(j, i1);
        if (bool1 && i3 != 1073741824)
          for (j = 0; j < i4; j++) {
            View view = getChildAt(j);
            if (view != null && view.getVisibility() != 8 && ((LinearLayoutCompat$LayoutParams)view.getLayoutParams()).weight > 0.0F)
              view.measure(View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i, 1073741824)); 
          }  
        i = k;
        i1 = i2;
      } 
      if (n != 0 || i7 == 1073741824)
        i = i1; 
      setMeasuredDimension(View.resolveSizeAndState(Math.max(i + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), paramInt1, m), i6);
      if (bool)
        forceUniformWidth(i4, paramInt2); 
      return;
    } 
    measureHorizontal(paramInt1, paramInt2);
  }
  
  public boolean shouldDelayChildPressedState() {
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\LinearLayoutCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */