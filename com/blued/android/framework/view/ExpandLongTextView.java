package com.blued.android.framework.view;

import android.content.Context;
import android.os.Build;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.blued.android.framework.R;

public class ExpandLongTextView extends TextView {
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
    String str = paramContext.getResources().getString(R.string.read_more);
    this.e = new SpannableString(str);
    ButtonSpan buttonSpan = new ButtonSpan(this, getContext(), null, R.color.expand_text_color);
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
    //   58: getstatic android/os/Build$VERSION.SDK_INT : I
    //   61: bipush #16
    //   63: if_icmplt -> 74
    //   66: aload_0
    //   67: invokevirtual getMaxLines : ()I
    //   70: istore_2
    //   71: goto -> 79
    //   74: aload_0
    //   75: getfield c : I
    //   78: istore_2
    //   79: new java/lang/StringBuilder
    //   82: dup
    //   83: aload_0
    //   84: getfield b : Ljava/lang/String;
    //   87: invokespecial <init> : (Ljava/lang/String;)V
    //   90: invokevirtual toString : ()Ljava/lang/String;
    //   93: astore_1
    //   94: iload_2
    //   95: iconst_m1
    //   96: if_icmpeq -> 294
    //   99: aload_0
    //   100: aload_1
    //   101: invokespecial a : (Ljava/lang/String;)Landroid/text/Layout;
    //   104: astore #4
    //   106: aload #4
    //   108: invokevirtual getLineCount : ()I
    //   111: iload_2
    //   112: if_icmple -> 294
    //   115: aload_0
    //   116: getfield b : Ljava/lang/String;
    //   119: iconst_0
    //   120: aload #4
    //   122: iload_2
    //   123: iconst_1
    //   124: isub
    //   125: invokevirtual getLineEnd : (I)I
    //   128: invokevirtual substring : (II)Ljava/lang/String;
    //   131: invokevirtual trim : ()Ljava/lang/String;
    //   134: astore_1
    //   135: new java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial <init> : ()V
    //   142: astore #4
    //   144: aload #4
    //   146: aload_1
    //   147: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload #4
    //   153: ldc '...'
    //   155: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload #4
    //   161: aload_0
    //   162: getfield e : Landroid/text/SpannableString;
    //   165: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload_0
    //   170: aload #4
    //   172: invokevirtual toString : ()Ljava/lang/String;
    //   175: invokespecial a : (Ljava/lang/String;)Landroid/text/Layout;
    //   178: astore #4
    //   180: aload #4
    //   182: invokevirtual getLineCount : ()I
    //   185: iload_2
    //   186: if_icmple -> 259
    //   189: aload_1
    //   190: invokevirtual length : ()I
    //   193: iconst_1
    //   194: isub
    //   195: istore_3
    //   196: iload_3
    //   197: iconst_m1
    //   198: if_icmpne -> 204
    //   201: goto -> 259
    //   204: aload_1
    //   205: iconst_0
    //   206: iload_3
    //   207: invokevirtual substring : (II)Ljava/lang/String;
    //   210: astore_1
    //   211: new java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial <init> : ()V
    //   218: astore #4
    //   220: aload #4
    //   222: aload_1
    //   223: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: aload #4
    //   229: ldc '...'
    //   231: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload #4
    //   237: aload_0
    //   238: getfield e : Landroid/text/SpannableString;
    //   241: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   244: pop
    //   245: aload_0
    //   246: aload #4
    //   248: invokevirtual toString : ()Ljava/lang/String;
    //   251: invokespecial a : (Ljava/lang/String;)Landroid/text/Layout;
    //   254: astore #4
    //   256: goto -> 180
    //   259: new java/lang/StringBuilder
    //   262: dup
    //   263: invokespecial <init> : ()V
    //   266: astore #4
    //   268: aload #4
    //   270: aload_1
    //   271: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: pop
    //   275: aload #4
    //   277: ldc '...'
    //   279: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: aload #4
    //   285: invokevirtual toString : ()Ljava/lang/String;
    //   288: astore_1
    //   289: iconst_1
    //   290: istore_2
    //   291: goto -> 296
    //   294: iconst_0
    //   295: istore_2
    //   296: aload_0
    //   297: aload_1
    //   298: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   301: iload_2
    //   302: ifeq -> 319
    //   305: aload_0
    //   306: iconst_1
    //   307: putfield d : Z
    //   310: aload_0
    //   311: aload_0
    //   312: getfield e : Landroid/text/SpannableString;
    //   315: invokevirtual append : (Ljava/lang/CharSequence;)V
    //   318: return
    //   319: aload_0
    //   320: iconst_0
    //   321: putfield d : Z
    //   324: return
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\ExpandLongTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */