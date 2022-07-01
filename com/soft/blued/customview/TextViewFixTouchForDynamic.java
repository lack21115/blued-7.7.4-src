package com.soft.blued.customview;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.soft.blued.customview.emoji.view.EmojiTextView;

public class TextViewFixTouchForDynamic extends EmojiTextView {
  private int a = -1;
  
  private int b = -1;
  
  private SpannableString c = null;
  
  private CharSequence d;
  
  private boolean e;
  
  private String f = "";
  
  public TextViewFixTouchForDynamic(Context paramContext) {
    super(paramContext);
    a();
  }
  
  public TextViewFixTouchForDynamic(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private Layout a(CharSequence paramCharSequence) {
    return (Layout)((Build.VERSION.SDK_INT >= 23) ? StaticLayout.Builder.obtain(paramCharSequence, 0, paramCharSequence.length(), getPaint(), getMaxWidth() - getPaddingLeft() - getPaddingRight()).setLineSpacing(getLineSpacingExtra(), getLineSpacingMultiplier()).setAlignment(Layout.Alignment.ALIGN_NORMAL).setBreakStrategy(1).setHyphenationFrequency(2).build() : new StaticLayout(paramCharSequence, 0, paramCharSequence.length(), getPaint(), getMaxWidth() - getPaddingLeft() - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, 1.0F, 1.0F, true));
  }
  
  public void a() {
    setMoreText(getContext().getResources().getString(2131756574));
    setMoeTextColor(BluedSkinUtils.a(getContext(), 2131100716));
  }
  
  public void g() {
    super.g();
  }
  
  public boolean getIfShowedMore() {
    return this.e;
  }
  
  public boolean hasFocusable() {
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    boolean bool = super.onTouchEvent(paramMotionEvent);
    try {
      int i = paramMotionEvent.getAction();
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      int m = getTotalPaddingLeft();
      int n = getTotalPaddingTop();
      int i1 = getScrollX();
      int i2 = getScrollY();
      Layout layout = getLayout();
      j = layout.getOffsetForHorizontal(layout.getLineForVertical(k - n + i2), (j - m + i1));
      CharSequence charSequence = getText();
      if (!TextUtils.isEmpty(charSequence)) {
        if (!(charSequence instanceof Spannable))
          return bool; 
        Spannable spannable = (Spannable)charSequence;
        ClickableSpan[] arrayOfClickableSpan = (ClickableSpan[])spannable.getSpans(j, j, ClickableSpan.class);
        if (arrayOfClickableSpan.length != 0) {
          if (i == 0) {
            this.a = spannable.getSpanStart(arrayOfClickableSpan[0]);
            this.b = spannable.getSpanEnd(arrayOfClickableSpan[0]);
            if (this.a >= 0 && this.b >= this.a && this.b <= spannable.length()) {
              spannable.setSpan(new BackgroundColorSpan(Color.parseColor("#0A000000")), this.a, this.b, 33);
              return true;
            } 
          } else if ((i == 1 || i == 3) && this.a >= 0 && this.b >= this.a && this.b <= spannable.length()) {
            spannable.setSpan(new BackgroundColorSpan(0), this.a, this.b, 33);
            this.a = -1;
            this.b = -1;
            return true;
          } 
        } else {
          if (this.a >= 0 && this.b >= this.a) {
            if (spannable.length() >= this.b)
              spannable.setSpan(new BackgroundColorSpan(0), this.a, this.b, 33); 
            this.a = -1;
            this.b = -1;
          } 
          Selection.removeSelection(spannable);
          return false;
        } 
      } else {
        return bool;
      } 
    } catch (Exception exception) {
      return bool;
    } 
    return true;
  }
  
  public void setExpandText(CharSequence paramCharSequence) {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   4: ifeq -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield c : Landroid/text/SpannableString;
    //   12: ifnonnull -> 19
    //   15: aload_0
    //   16: invokevirtual a : ()V
    //   19: aload_0
    //   20: aload_1
    //   21: putfield d : Ljava/lang/CharSequence;
    //   24: aload_0
    //   25: aload_1
    //   26: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   29: aload_0
    //   30: iconst_0
    //   31: iconst_0
    //   32: invokestatic makeMeasureSpec : (II)I
    //   35: iconst_0
    //   36: iconst_0
    //   37: invokestatic makeMeasureSpec : (II)I
    //   40: invokevirtual measure : (II)V
    //   43: aload_0
    //   44: iconst_0
    //   45: iconst_0
    //   46: aload_0
    //   47: invokevirtual getMeasuredWidth : ()I
    //   50: aload_0
    //   51: invokevirtual getMeasuredHeight : ()I
    //   54: invokevirtual layout : (IIII)V
    //   57: aload_0
    //   58: invokevirtual getMaxLines : ()I
    //   61: istore_2
    //   62: aload_0
    //   63: getfield d : Ljava/lang/CharSequence;
    //   66: astore_1
    //   67: iload_2
    //   68: iconst_m1
    //   69: if_icmpeq -> 234
    //   72: aload_0
    //   73: aload_1
    //   74: invokespecial a : (Ljava/lang/CharSequence;)Landroid/text/Layout;
    //   77: astore #4
    //   79: aload #4
    //   81: invokevirtual getLineCount : ()I
    //   84: iload_2
    //   85: if_icmple -> 234
    //   88: aload_0
    //   89: getfield d : Ljava/lang/CharSequence;
    //   92: iconst_0
    //   93: aload #4
    //   95: iload_2
    //   96: iconst_1
    //   97: isub
    //   98: invokevirtual getLineEnd : (I)I
    //   101: invokeinterface subSequence : (II)Ljava/lang/CharSequence;
    //   106: astore_1
    //   107: aload_0
    //   108: new android/text/SpannableStringBuilder
    //   111: dup
    //   112: invokespecial <init> : ()V
    //   115: aload_1
    //   116: invokevirtual append : (Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    //   119: ldc_w '...'
    //   122: invokevirtual append : (Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    //   125: aload_0
    //   126: getfield c : Landroid/text/SpannableString;
    //   129: invokevirtual append : (Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    //   132: invokespecial a : (Ljava/lang/CharSequence;)Landroid/text/Layout;
    //   135: astore #4
    //   137: aload #4
    //   139: invokevirtual getLineCount : ()I
    //   142: iload_2
    //   143: if_icmple -> 211
    //   146: aload_1
    //   147: invokeinterface length : ()I
    //   152: iconst_1
    //   153: isub
    //   154: istore_3
    //   155: iload_3
    //   156: ifle -> 211
    //   159: aload_1
    //   160: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   163: ifeq -> 169
    //   166: goto -> 211
    //   169: aload_1
    //   170: iconst_0
    //   171: iload_3
    //   172: invokeinterface subSequence : (II)Ljava/lang/CharSequence;
    //   177: astore_1
    //   178: aload_0
    //   179: new android/text/SpannableStringBuilder
    //   182: dup
    //   183: invokespecial <init> : ()V
    //   186: aload_1
    //   187: invokevirtual append : (Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    //   190: ldc_w '...'
    //   193: invokevirtual append : (Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    //   196: aload_0
    //   197: getfield c : Landroid/text/SpannableString;
    //   200: invokevirtual append : (Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    //   203: invokespecial a : (Ljava/lang/CharSequence;)Landroid/text/Layout;
    //   206: astore #4
    //   208: goto -> 137
    //   211: new android/text/SpannableStringBuilder
    //   214: dup
    //   215: invokespecial <init> : ()V
    //   218: aload_1
    //   219: invokevirtual append : (Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    //   222: ldc_w '...'
    //   225: invokevirtual append : (Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    //   228: astore_1
    //   229: iconst_1
    //   230: istore_2
    //   231: goto -> 236
    //   234: iconst_0
    //   235: istore_2
    //   236: aload_0
    //   237: aload_1
    //   238: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   241: iload_2
    //   242: ifeq -> 259
    //   245: aload_0
    //   246: iconst_1
    //   247: putfield e : Z
    //   250: aload_0
    //   251: aload_0
    //   252: getfield c : Landroid/text/SpannableString;
    //   255: invokevirtual append : (Ljava/lang/CharSequence;)V
    //   258: return
    //   259: aload_0
    //   260: iconst_0
    //   261: putfield e : Z
    //   264: return
  }
  
  public void setMoeTextColor(int paramInt) {
    this.c = new SpannableString(this.f);
    ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(paramInt);
    this.c.setSpan(foregroundColorSpan, 0, this.f.length(), 17);
    StyleSpan styleSpan = new StyleSpan(1);
    this.c.setSpan(styleSpan, 0, this.f.length(), 17);
  }
  
  public void setMoreText(String paramString) {
    this.f = paramString;
  }
  
  public class ButtonSpan extends ClickableSpan {
    View.OnClickListener a;
    
    private Context b;
    
    private int c;
    
    public void onClick(View param1View) {
      View.OnClickListener onClickListener = this.a;
      if (onClickListener != null)
        onClickListener.onClick(param1View); 
    }
    
    public void updateDrawState(TextPaint param1TextPaint) {
      param1TextPaint.setColor(BluedSkinUtils.a(this.b, this.c));
      param1TextPaint.setUnderlineText(false);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\TextViewFixTouchForDynamic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */