package com.sina.weibo.sdk.register.mobile;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.sina.weibo.sdk.utils.ResourceManager;

public class LetterIndexBar extends View {
  public static final int INDEX_COUNT_DEFAULT = 27;
  
  public static final String SEARCH_ICON_LETTER = "";
  
  private int count = 27;
  
  private int mIndex;
  
  private String[] mIndexLetter;
  
  private int mItemHeight;
  
  private int mItemPadding;
  
  private OnIndexChangeListener mListener;
  
  private boolean[] mNeedIndex;
  
  private int mOrgTextSzie;
  
  private Paint mPaint = new Paint();
  
  private RectF mRect;
  
  private Drawable mSeatchIcon;
  
  private boolean mTouching;
  
  public LetterIndexBar(Context paramContext) {
    super(paramContext);
    init();
  }
  
  public LetterIndexBar(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public LetterIndexBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init() {
    this.mPaint.setAntiAlias(true);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setColor(-10658467);
    this.mOrgTextSzie = ResourceManager.dp2px(getContext(), 13);
  }
  
  protected void onDraw(Canvas paramCanvas) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial onDraw : (Landroid/graphics/Canvas;)V
    //   5: aload_0
    //   6: getfield mTouching : Z
    //   9: ifeq -> 65
    //   12: aload_0
    //   13: getfield mPaint : Landroid/graphics/Paint;
    //   16: invokevirtual getColor : ()I
    //   19: istore #4
    //   21: aload_0
    //   22: getfield mPaint : Landroid/graphics/Paint;
    //   25: ldc -2005436536
    //   27: invokevirtual setColor : (I)V
    //   30: aload_1
    //   31: aload_0
    //   32: getfield mRect : Landroid/graphics/RectF;
    //   35: aload_0
    //   36: invokevirtual getMeasuredWidth : ()I
    //   39: iconst_2
    //   40: idiv
    //   41: i2f
    //   42: aload_0
    //   43: invokevirtual getMeasuredWidth : ()I
    //   46: iconst_2
    //   47: idiv
    //   48: i2f
    //   49: aload_0
    //   50: getfield mPaint : Landroid/graphics/Paint;
    //   53: invokevirtual drawRoundRect : (Landroid/graphics/RectF;FFLandroid/graphics/Paint;)V
    //   56: aload_0
    //   57: getfield mPaint : Landroid/graphics/Paint;
    //   60: iload #4
    //   62: invokevirtual setColor : (I)V
    //   65: aload_0
    //   66: getfield mOrgTextSzie : I
    //   69: istore #5
    //   71: aload_0
    //   72: getfield mItemHeight : I
    //   75: istore #6
    //   77: iload #5
    //   79: istore #4
    //   81: iload #5
    //   83: iload #6
    //   85: if_icmple -> 92
    //   88: iload #6
    //   90: istore #4
    //   92: aload_0
    //   93: getfield mPaint : Landroid/graphics/Paint;
    //   96: iload #4
    //   98: i2f
    //   99: invokevirtual setTextSize : (F)V
    //   102: aload_0
    //   103: getfield mIndexLetter : [Ljava/lang/String;
    //   106: astore #10
    //   108: iconst_0
    //   109: istore #5
    //   111: iconst_0
    //   112: istore #6
    //   114: aload #10
    //   116: ifnonnull -> 266
    //   119: bipush #65
    //   121: istore_2
    //   122: iload #6
    //   124: istore #5
    //   126: iload #5
    //   128: aload_0
    //   129: getfield count : I
    //   132: if_icmplt -> 136
    //   135: return
    //   136: aload_0
    //   137: getfield mItemHeight : I
    //   140: istore #6
    //   142: aload_0
    //   143: invokevirtual getPaddingTop : ()I
    //   146: istore #7
    //   148: aload_0
    //   149: getfield mItemPadding : I
    //   152: istore #8
    //   154: aload_0
    //   155: getfield mNeedIndex : [Z
    //   158: astore #10
    //   160: aload #10
    //   162: ifnull -> 175
    //   165: iload_2
    //   166: istore_3
    //   167: aload #10
    //   169: iload #5
    //   171: baload
    //   172: ifeq -> 255
    //   175: iload #5
    //   177: aload_0
    //   178: getfield count : I
    //   181: iconst_1
    //   182: isub
    //   183: if_icmpne -> 193
    //   186: ldc '#'
    //   188: astore #10
    //   190: goto -> 206
    //   193: iload_2
    //   194: iconst_1
    //   195: iadd
    //   196: i2c
    //   197: istore_3
    //   198: iload_2
    //   199: invokestatic valueOf : (C)Ljava/lang/String;
    //   202: astore #10
    //   204: iload_3
    //   205: istore_2
    //   206: aload_0
    //   207: getfield mPaint : Landroid/graphics/Paint;
    //   210: aload #10
    //   212: invokevirtual measureText : (Ljava/lang/String;)F
    //   215: f2i
    //   216: istore #9
    //   218: aload_1
    //   219: aload #10
    //   221: aload_0
    //   222: invokevirtual getMeasuredWidth : ()I
    //   225: iload #9
    //   227: isub
    //   228: iconst_2
    //   229: idiv
    //   230: i2f
    //   231: iload #6
    //   233: iload #5
    //   235: imul
    //   236: iload #7
    //   238: iadd
    //   239: iload #4
    //   241: iadd
    //   242: iload #8
    //   244: iadd
    //   245: i2f
    //   246: aload_0
    //   247: getfield mPaint : Landroid/graphics/Paint;
    //   250: invokevirtual drawText : (Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   253: iload_2
    //   254: istore_3
    //   255: iload #5
    //   257: iconst_1
    //   258: iadd
    //   259: istore #5
    //   261: iload_3
    //   262: istore_2
    //   263: goto -> 126
    //   266: iload #5
    //   268: aload_0
    //   269: getfield count : I
    //   272: if_icmplt -> 276
    //   275: return
    //   276: aload_0
    //   277: getfield mItemHeight : I
    //   280: iload #5
    //   282: imul
    //   283: aload_0
    //   284: invokevirtual getPaddingTop : ()I
    //   287: iadd
    //   288: iload #4
    //   290: iadd
    //   291: aload_0
    //   292: getfield mItemPadding : I
    //   295: iadd
    //   296: istore #6
    //   298: aload_0
    //   299: getfield mNeedIndex : [Z
    //   302: astore #10
    //   304: aload #10
    //   306: ifnull -> 317
    //   309: aload #10
    //   311: iload #5
    //   313: baload
    //   314: ifeq -> 432
    //   317: aload_0
    //   318: getfield mIndexLetter : [Ljava/lang/String;
    //   321: iload #5
    //   323: aaload
    //   324: astore #10
    //   326: aload #10
    //   328: ldc ''
    //   330: invokevirtual equals : (Ljava/lang/Object;)Z
    //   333: ifeq -> 397
    //   336: aload_0
    //   337: getfield mPaint : Landroid/graphics/Paint;
    //   340: ldc 'M'
    //   342: invokevirtual measureText : (Ljava/lang/String;)F
    //   345: f2i
    //   346: istore #7
    //   348: aload_0
    //   349: invokevirtual getMeasuredWidth : ()I
    //   352: iload #7
    //   354: isub
    //   355: iconst_2
    //   356: idiv
    //   357: istore #8
    //   359: aload_0
    //   360: getfield mSeatchIcon : Landroid/graphics/drawable/Drawable;
    //   363: iload #8
    //   365: iload #6
    //   367: iload #8
    //   369: isub
    //   370: iload #7
    //   372: iload #8
    //   374: iadd
    //   375: iload #7
    //   377: iload #6
    //   379: iadd
    //   380: iload #8
    //   382: isub
    //   383: invokevirtual setBounds : (IIII)V
    //   386: aload_0
    //   387: getfield mSeatchIcon : Landroid/graphics/drawable/Drawable;
    //   390: aload_1
    //   391: invokevirtual draw : (Landroid/graphics/Canvas;)V
    //   394: goto -> 432
    //   397: aload_0
    //   398: getfield mPaint : Landroid/graphics/Paint;
    //   401: aload #10
    //   403: invokevirtual measureText : (Ljava/lang/String;)F
    //   406: f2i
    //   407: istore #7
    //   409: aload_1
    //   410: aload #10
    //   412: aload_0
    //   413: invokevirtual getMeasuredWidth : ()I
    //   416: iload #7
    //   418: isub
    //   419: iconst_2
    //   420: idiv
    //   421: i2f
    //   422: iload #6
    //   424: i2f
    //   425: aload_0
    //   426: getfield mPaint : Landroid/graphics/Paint;
    //   429: invokevirtual drawText : (Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   432: iload #5
    //   434: iconst_1
    //   435: iadd
    //   436: istore #5
    //   438: goto -> 266
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    paramInt1 = View.MeasureSpec.getSize(paramInt2);
    this.mItemHeight = (paramInt1 - getPaddingTop() - getPaddingBottom()) / this.count;
    this.mItemPadding = (int)((this.mItemHeight - this.mPaint.getTextSize()) / 2.0F);
    setMeasuredDimension(this.mOrgTextSzie + getPaddingLeft() + getPaddingRight(), paramInt2);
    this.mRect = new RectF(0.0F, getPaddingTop(), getMeasuredWidth(), (paramInt1 - getPaddingTop() - getPaddingBottom()));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual getAction : ()I
    //   4: istore_2
    //   5: iload_2
    //   6: ifeq -> 40
    //   9: iload_2
    //   10: iconst_1
    //   11: if_icmpeq -> 32
    //   14: iload_2
    //   15: iconst_2
    //   16: if_icmpeq -> 40
    //   19: iload_2
    //   20: iconst_3
    //   21: if_icmpeq -> 32
    //   24: iload_2
    //   25: iconst_4
    //   26: if_icmpeq -> 32
    //   29: goto -> 120
    //   32: aload_0
    //   33: iconst_0
    //   34: putfield mTouching : Z
    //   37: goto -> 120
    //   40: aload_0
    //   41: iconst_1
    //   42: putfield mTouching : Z
    //   45: aload_1
    //   46: invokevirtual getY : ()F
    //   49: f2i
    //   50: aload_0
    //   51: invokevirtual getPaddingTop : ()I
    //   54: isub
    //   55: aload_0
    //   56: getfield mItemHeight : I
    //   59: idiv
    //   60: istore_2
    //   61: iload_2
    //   62: aload_0
    //   63: getfield mIndex : I
    //   66: if_icmpeq -> 120
    //   69: aload_0
    //   70: getfield mNeedIndex : [Z
    //   73: astore_1
    //   74: aload_1
    //   75: ifnull -> 84
    //   78: aload_1
    //   79: iload_2
    //   80: baload
    //   81: ifeq -> 120
    //   84: iload_2
    //   85: aload_0
    //   86: getfield count : I
    //   89: if_icmpge -> 120
    //   92: iload_2
    //   93: iflt -> 120
    //   96: aload_0
    //   97: iload_2
    //   98: putfield mIndex : I
    //   101: aload_0
    //   102: getfield mListener : Lcom/sina/weibo/sdk/register/mobile/LetterIndexBar$OnIndexChangeListener;
    //   105: astore_1
    //   106: aload_1
    //   107: ifnull -> 120
    //   110: aload_1
    //   111: aload_0
    //   112: getfield mIndex : I
    //   115: invokeinterface onIndexChange : (I)V
    //   120: aload_0
    //   121: invokevirtual invalidate : ()V
    //   124: iconst_1
    //   125: ireturn
  }
  
  public void setIndexChangeListener(OnIndexChangeListener paramOnIndexChangeListener) {
    this.mListener = paramOnIndexChangeListener;
  }
  
  public void setIndexLetter(String[] paramArrayOfString) {
    if (paramArrayOfString == null)
      return; 
    this.mIndexLetter = paramArrayOfString;
    this.count = this.mIndexLetter.length;
    this.mIndex = -1;
    invalidate();
  }
  
  public void setIndexMark(boolean[] paramArrayOfboolean) {
    if (paramArrayOfboolean == null)
      return; 
    this.mNeedIndex = paramArrayOfboolean;
    invalidate();
  }
  
  public static interface OnIndexChangeListener {
    void onIndexChange(int param1Int);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\register\mobile\LetterIndexBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */