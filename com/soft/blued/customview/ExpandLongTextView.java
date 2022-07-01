package com.soft.blued.customview;

import android.content.Context;
import android.os.Build;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;

public class ExpandLongTextView extends AppCompatTextView {
  private Context a;
  
  private String b;
  
  private int c = 6;
  
  private boolean d = false;
  
  private SpannableString e = null;
  
  public ExpandLongTextView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public ExpandLongTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private Layout a(String paramString) {
    return (Layout)((Build.VERSION.SDK_INT >= 23) ? StaticLayout.Builder.obtain(paramString, 0, paramString.length(), getPaint(), getMaxWidth() - getPaddingLeft() - getPaddingRight()).setLineSpacing(getLineSpacingExtra(), getLineSpacingMultiplier()).setAlignment(Layout.Alignment.ALIGN_NORMAL).setBreakStrategy(1).setHyphenationFrequency(2).build() : new StaticLayout(paramString, 0, paramString.length(), getPaint(), getWidth() - getPaddingLeft() - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, 1.0F, 1.0F, true));
  }
  
  private void a(Context paramContext) {
    this.a = paramContext;
    String str = paramContext.getResources().getString(2131758526);
    this.e = new SpannableString(str);
    ButtonSpan buttonSpan = new ButtonSpan(this, getContext(), null, 2131100311);
    this.e.setSpan(buttonSpan, 0, str.length(), 17);
  }
  
  public boolean getIfShowedMore() {
    return this.d;
  }
  
  public void setExpandText(CharSequence paramCharSequence) {
    // Byte code:
    //   0: aload_0
    //   1: getfield e : Landroid/text/SpannableString;
    //   4: ifnonnull -> 15
    //   7: aload_0
    //   8: aload_0
    //   9: getfield a : Landroid/content/Context;
    //   12: invokespecial a : (Landroid/content/Context;)V
    //   15: aload_0
    //   16: aload_1
    //   17: invokeinterface toString : ()Ljava/lang/String;
    //   22: putfield b : Ljava/lang/String;
    //   25: aload_0
    //   26: aload_1
    //   27: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   30: aload_0
    //   31: iconst_0
    //   32: iconst_0
    //   33: invokestatic makeMeasureSpec : (II)I
    //   36: iconst_0
    //   37: iconst_0
    //   38: invokestatic makeMeasureSpec : (II)I
    //   41: invokevirtual measure : (II)V
    //   44: aload_0
    //   45: iconst_0
    //   46: iconst_0
    //   47: aload_0
    //   48: invokevirtual getMeasuredWidth : ()I
    //   51: aload_0
    //   52: invokevirtual getMeasuredHeight : ()I
    //   55: invokevirtual layout : (IIII)V
    //   58: aload_0
    //   59: invokevirtual getMaxLines : ()I
    //   62: istore_2
    //   63: new java/lang/StringBuilder
    //   66: dup
    //   67: aload_0
    //   68: getfield b : Ljava/lang/String;
    //   71: invokespecial <init> : (Ljava/lang/String;)V
    //   74: invokevirtual toString : ()Ljava/lang/String;
    //   77: astore_1
    //   78: iload_2
    //   79: iconst_m1
    //   80: if_icmpeq -> 284
    //   83: aload_0
    //   84: aload_1
    //   85: invokespecial a : (Ljava/lang/String;)Landroid/text/Layout;
    //   88: astore #4
    //   90: aload #4
    //   92: invokevirtual getLineCount : ()I
    //   95: iload_2
    //   96: if_icmple -> 284
    //   99: aload_0
    //   100: getfield b : Ljava/lang/String;
    //   103: iconst_0
    //   104: aload #4
    //   106: iload_2
    //   107: iconst_1
    //   108: isub
    //   109: invokevirtual getLineEnd : (I)I
    //   112: invokevirtual substring : (II)Ljava/lang/String;
    //   115: invokevirtual trim : ()Ljava/lang/String;
    //   118: astore_1
    //   119: new java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial <init> : ()V
    //   126: astore #4
    //   128: aload #4
    //   130: aload_1
    //   131: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: aload #4
    //   137: ldc '...'
    //   139: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload #4
    //   145: aload_0
    //   146: getfield e : Landroid/text/SpannableString;
    //   149: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload_0
    //   154: aload #4
    //   156: invokevirtual toString : ()Ljava/lang/String;
    //   159: invokespecial a : (Ljava/lang/String;)Landroid/text/Layout;
    //   162: astore #4
    //   164: aload #4
    //   166: invokevirtual getLineCount : ()I
    //   169: iload_2
    //   170: if_icmple -> 249
    //   173: aload_1
    //   174: invokevirtual length : ()I
    //   177: iconst_1
    //   178: isub
    //   179: istore_3
    //   180: iload_3
    //   181: ifle -> 249
    //   184: aload_1
    //   185: invokestatic e : (Ljava/lang/String;)Z
    //   188: ifeq -> 194
    //   191: goto -> 249
    //   194: aload_1
    //   195: iconst_0
    //   196: iload_3
    //   197: invokevirtual substring : (II)Ljava/lang/String;
    //   200: astore_1
    //   201: new java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial <init> : ()V
    //   208: astore #4
    //   210: aload #4
    //   212: aload_1
    //   213: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: aload #4
    //   219: ldc '...'
    //   221: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: aload #4
    //   227: aload_0
    //   228: getfield e : Landroid/text/SpannableString;
    //   231: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload_0
    //   236: aload #4
    //   238: invokevirtual toString : ()Ljava/lang/String;
    //   241: invokespecial a : (Ljava/lang/String;)Landroid/text/Layout;
    //   244: astore #4
    //   246: goto -> 164
    //   249: new java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial <init> : ()V
    //   256: astore #4
    //   258: aload #4
    //   260: aload_1
    //   261: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: aload #4
    //   267: ldc '...'
    //   269: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: aload #4
    //   275: invokevirtual toString : ()Ljava/lang/String;
    //   278: astore_1
    //   279: iconst_1
    //   280: istore_2
    //   281: goto -> 286
    //   284: iconst_0
    //   285: istore_2
    //   286: aload_0
    //   287: aload_1
    //   288: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   291: iload_2
    //   292: ifeq -> 309
    //   295: aload_0
    //   296: iconst_1
    //   297: putfield d : Z
    //   300: aload_0
    //   301: aload_0
    //   302: getfield e : Landroid/text/SpannableString;
    //   305: invokevirtual append : (Ljava/lang/CharSequence;)V
    //   308: return
    //   309: aload_0
    //   310: iconst_0
    //   311: putfield d : Z
    //   314: return
  }
  
  public void setMaxLines(int paramInt) {
    this.c = paramInt;
    super.setMaxLines(paramInt);
  }
  
  public class ButtonSpan extends ClickableSpan {
    View.OnClickListener a;
    
    private Context c;
    
    private int d;
    
    public ButtonSpan(ExpandLongTextView this$0, Context param1Context, View.OnClickListener param1OnClickListener, int param1Int) {
      this.a = param1OnClickListener;
      this.c = param1Context;
      this.d = param1Int;
    }
    
    public void onClick(View param1View) {
      View.OnClickListener onClickListener = this.a;
      if (onClickListener != null)
        onClickListener.onClick(param1View); 
    }
    
    public void updateDrawState(TextPaint param1TextPaint) {
      param1TextPaint.setColor(this.c.getResources().getColor(this.d));
      param1TextPaint.setUnderlineText(false);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\ExpandLongTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */