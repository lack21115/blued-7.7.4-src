package com.soft.blued.ui.msg.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import java.util.ArrayList;
import java.util.List;

public class JustifyTextView extends AppCompatTextView {
  private float a;
  
  private float b = 0.0F;
  
  private int c;
  
  private List<String> d = new ArrayList<String>();
  
  private List<Integer> e = new ArrayList<Integer>();
  
  private Align f = Align.a;
  
  private boolean g = true;
  
  private float h = 1.0F;
  
  private float i = 0.0F;
  
  private int j = 0;
  
  private int k = 0;
  
  private int l = 0;
  
  private boolean m = false;
  
  public JustifyTextView(Context paramContext) {
    super(paramContext);
    setTextIsSelectable(false);
  }
  
  public JustifyTextView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    setTextIsSelectable(false);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, new int[] { 16843287, 16843288 });
    this.i = typedArray.getDimensionPixelSize(0, 0);
    this.h = typedArray.getFloat(1, 1.0F);
    this.l = getPaddingBottom();
    typedArray.recycle();
  }
  
  public JustifyTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    setTextIsSelectable(false);
  }
  
  private void a(Paint paramPaint, String paramString) {
    StringBuilder stringBuilder2;
    if (paramString.length() == 0) {
      this.d.add("\n");
      return;
    } 
    float f = paramPaint.measureText("中");
    int m = (int)(this.c / f);
    int i = m + 1;
    int k = Math.min(i, paramString.length());
    int j = 0;
    StringBuilder stringBuilder1 = new StringBuilder(paramString.substring(0, k));
    while (true) {
      stringBuilder2 = stringBuilder1;
      if (i < paramString.length()) {
        if (paramPaint.measureText(paramString.substring(j, i + 1)) > this.c) {
          this.d.add(stringBuilder1.toString());
          stringBuilder2 = new StringBuilder();
          if (paramString.length() - i > m) {
            j = i + m;
            stringBuilder2.append(paramString.substring(i, j));
            k = j - 1;
            stringBuilder1 = stringBuilder2;
            j = i;
          } else {
            this.d.add(paramString.substring(i));
            break;
          } 
        } else {
          stringBuilder1.append(paramString.charAt(i));
          k = i;
        } 
        i = k + 1;
        continue;
      } 
      break;
    } 
    if (stringBuilder2.length() > 0)
      this.d.add(stringBuilder2.toString()); 
    this.e.add(Integer.valueOf(this.d.size() - 1));
  }
  
  private void a(String paramString, float paramFloat, int paramInt) {
    TextView textView = new TextView(getContext());
    textView.setText(paramString);
    textView.setTextSize(0, paramFloat);
    textView.measure(View.MeasureSpec.makeMeasureSpec(paramInt, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
    this.k = textView.getLineCount();
    this.j = textView.getMeasuredHeight();
  }
  
  protected void onDraw(Canvas paramCanvas) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getPaint : ()Landroid/text/TextPaint;
    //   4: astore #15
    //   6: aload #15
    //   8: aload_0
    //   9: invokevirtual getCurrentTextColor : ()I
    //   12: invokevirtual setColor : (I)V
    //   15: aload #15
    //   17: aload_0
    //   18: invokevirtual getDrawableState : ()[I
    //   21: putfield drawableState : [I
    //   24: aload_0
    //   25: aload_0
    //   26: invokevirtual getMeasuredWidth : ()I
    //   29: putfield c : I
    //   32: aload #15
    //   34: invokevirtual getFontMetrics : ()Landroid/graphics/Paint$FontMetrics;
    //   37: astore #16
    //   39: aload_0
    //   40: invokevirtual getTextSize : ()F
    //   43: aload #16
    //   45: getfield bottom : F
    //   48: aload #16
    //   50: getfield descent : F
    //   53: fsub
    //   54: aload #16
    //   56: getfield ascent : F
    //   59: fadd
    //   60: aload #16
    //   62: getfield top : F
    //   65: fsub
    //   66: fsub
    //   67: fstore_3
    //   68: fload_3
    //   69: fstore_2
    //   70: aload_0
    //   71: invokevirtual getGravity : ()I
    //   74: sipush #4096
    //   77: iand
    //   78: ifne -> 92
    //   81: fload_3
    //   82: aload_0
    //   83: getfield a : F
    //   86: fload_3
    //   87: fsub
    //   88: fconst_2
    //   89: fdiv
    //   90: fadd
    //   91: fstore_2
    //   92: aload_0
    //   93: invokevirtual getPaddingTop : ()I
    //   96: istore #13
    //   98: aload_0
    //   99: invokevirtual getPaddingLeft : ()I
    //   102: istore #14
    //   104: aload_0
    //   105: invokevirtual getPaddingRight : ()I
    //   108: istore #10
    //   110: aload_0
    //   111: aload_0
    //   112: getfield c : I
    //   115: iload #14
    //   117: isub
    //   118: iload #10
    //   120: isub
    //   121: putfield c : I
    //   124: iconst_0
    //   125: istore #10
    //   127: iload #10
    //   129: aload_0
    //   130: getfield d : Ljava/util/List;
    //   133: invokeinterface size : ()I
    //   138: if_icmpge -> 373
    //   141: iload #10
    //   143: i2f
    //   144: fstore #8
    //   146: aload_0
    //   147: getfield a : F
    //   150: fstore #9
    //   152: aload_0
    //   153: getfield d : Ljava/util/List;
    //   156: iload #10
    //   158: invokeinterface get : (I)Ljava/lang/Object;
    //   163: checkcast java/lang/String
    //   166: astore #16
    //   168: iload #14
    //   170: i2f
    //   171: fstore #5
    //   173: aload_0
    //   174: getfield c : I
    //   177: i2f
    //   178: aload #15
    //   180: aload #16
    //   182: invokevirtual measureText : (Ljava/lang/String;)F
    //   185: fsub
    //   186: fstore #7
    //   188: fload #7
    //   190: aload #16
    //   192: invokevirtual length : ()I
    //   195: iconst_1
    //   196: isub
    //   197: i2f
    //   198: fdiv
    //   199: fstore #4
    //   201: fload #5
    //   203: fstore_3
    //   204: aload_0
    //   205: getfield e : Ljava/util/List;
    //   208: iload #10
    //   210: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   213: invokeinterface contains : (Ljava/lang/Object;)Z
    //   218: ifeq -> 274
    //   221: fconst_0
    //   222: fstore #6
    //   224: aload_0
    //   225: getfield f : Lcom/soft/blued/ui/msg/customview/JustifyTextView$Align;
    //   228: getstatic com/soft/blued/ui/msg/customview/JustifyTextView$Align.b : Lcom/soft/blued/ui/msg/customview/JustifyTextView$Align;
    //   231: if_acmpne -> 251
    //   234: fload #7
    //   236: fconst_2
    //   237: fdiv
    //   238: fstore_3
    //   239: fload #5
    //   241: fload_3
    //   242: fadd
    //   243: fstore_3
    //   244: fload #6
    //   246: fstore #4
    //   248: goto -> 274
    //   251: fload #5
    //   253: fstore_3
    //   254: fload #6
    //   256: fstore #4
    //   258: aload_0
    //   259: getfield f : Lcom/soft/blued/ui/msg/customview/JustifyTextView$Align;
    //   262: getstatic com/soft/blued/ui/msg/customview/JustifyTextView$Align.c : Lcom/soft/blued/ui/msg/customview/JustifyTextView$Align;
    //   265: if_acmpne -> 274
    //   268: fload #7
    //   270: fstore_3
    //   271: goto -> 239
    //   274: iconst_0
    //   275: istore #11
    //   277: iload #11
    //   279: aload #16
    //   281: invokevirtual length : ()I
    //   284: if_icmpge -> 364
    //   287: aload #15
    //   289: aload #16
    //   291: iconst_0
    //   292: iload #11
    //   294: invokevirtual substring : (II)Ljava/lang/String;
    //   297: invokevirtual measureText : (Ljava/lang/String;)F
    //   300: fstore #5
    //   302: iload #11
    //   304: i2f
    //   305: fstore #6
    //   307: iload #11
    //   309: iconst_1
    //   310: iadd
    //   311: istore #12
    //   313: aload_1
    //   314: aload #16
    //   316: iload #11
    //   318: iload #12
    //   320: invokevirtual substring : (II)Ljava/lang/String;
    //   323: fload #5
    //   325: fload #6
    //   327: fload #4
    //   329: fmul
    //   330: fadd
    //   331: fload_3
    //   332: fadd
    //   333: iload #13
    //   335: i2f
    //   336: fload #9
    //   338: fload #8
    //   340: fmul
    //   341: fload_2
    //   342: fadd
    //   343: fadd
    //   344: aload_0
    //   345: getfield b : F
    //   348: fload #8
    //   350: fmul
    //   351: fadd
    //   352: aload #15
    //   354: invokevirtual drawText : (Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   357: iload #12
    //   359: istore #11
    //   361: goto -> 277
    //   364: iload #10
    //   366: iconst_1
    //   367: iadd
    //   368: istore #10
    //   370: goto -> 127
    //   373: return
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.g) {
      this.c = getMeasuredWidth();
      String str = getText().toString();
      TextPaint textPaint = getPaint();
      this.d.clear();
      this.e.clear();
      String[] arrayOfString = str.split("\\n");
      paramInt2 = arrayOfString.length;
      for (paramInt1 = 0; paramInt1 < paramInt2; paramInt1++)
        a((Paint)textPaint, arrayOfString[paramInt1]); 
      a(str, textPaint.getTextSize(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
      this.a = this.j * 1.0F / this.k;
      float f = this.a;
      this.b = (this.h - 1.0F) * f + this.i;
      paramInt1 = (int)((this.b + f) * (this.d.size() - this.k));
      this.m = true;
      setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), this.l + paramInt1);
      this.g = false;
    } 
  }
  
  public void setAlign(Align paramAlign) {
    this.f = paramAlign;
    invalidate();
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (!this.m)
      this.l = paramInt4; 
    this.m = false;
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType) {
    this.g = true;
    super.setText(paramCharSequence, paramBufferType);
  }
  
  public enum Align {
    a, b, c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\customview\JustifyTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */