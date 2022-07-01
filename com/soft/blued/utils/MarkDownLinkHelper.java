package com.soft.blued.utils;

import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.soft.blued.customview.SelectionEditText;
import com.soft.blued.customview.emoji.view.EmojiEditText;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MarkDownLinkHelper {
  public static CharSequence a(Context paramContext, CharSequence paramCharSequence) {
    return a(paramContext, paramCharSequence, false, 0, false, (MDLinkOnClickListener)null);
  }
  
  public static CharSequence a(Context paramContext, CharSequence paramCharSequence, boolean paramBoolean, int paramInt) {
    return a(paramContext, paramCharSequence, paramBoolean, paramInt, false, (MDLinkOnClickListener)null);
  }
  
  public static CharSequence a(Context paramContext, CharSequence paramCharSequence, boolean paramBoolean1, int paramInt, boolean paramBoolean2, MDLinkOnClickListener paramMDLinkOnClickListener) {
    if (TextUtils.isEmpty(paramCharSequence))
      return paramCharSequence; 
    SpannableStringBuilder spannableStringBuilder = null;
    Matcher matcher = Pattern.compile("\\[([\\s\\S]*?)\\]\\(([\\s\\S]*?)\\)").matcher(paramCharSequence);
    int i = 0;
    while (matcher.find()) {
      SpannableStringBuilder spannableStringBuilder1 = spannableStringBuilder;
      if (spannableStringBuilder == null)
        spannableStringBuilder1 = new SpannableStringBuilder(); 
      String str1 = matcher.group(1);
      String str2 = matcher.group(2);
      spannableStringBuilder = spannableStringBuilder1;
      if (!TextUtils.isEmpty(str1)) {
        if (TextUtils.isEmpty(str2)) {
          spannableStringBuilder = spannableStringBuilder1;
          continue;
        } 
        spannableStringBuilder1.append(paramCharSequence.subSequence(i, matcher.start()));
        i = spannableStringBuilder1.length();
        int j = str1.length() + i;
        spannableStringBuilder1.append(str1);
        if (paramBoolean1) {
          MDLinkForegroundColorSpan mDLinkForegroundColorSpan = new MDLinkForegroundColorSpan(BluedSkinUtils.a(paramContext, paramInt));
          mDLinkForegroundColorSpan.a = str1;
          mDLinkForegroundColorSpan.b = str2;
          mDLinkForegroundColorSpan.c = matcher.group();
          spannableStringBuilder1.setSpan(mDLinkForegroundColorSpan, i, j, 33);
        } 
        if (paramBoolean2)
          spannableStringBuilder1.setSpan(new ClickableSpan(paramMDLinkOnClickListener, str2, paramContext, paramInt) {
                public void onClick(View param1View) {
                  Selection.removeSelection((Spannable)((TextView)param1View).getText());
                  MarkDownLinkHelper.MDLinkOnClickListener mDLinkOnClickListener = this.a;
                  if (mDLinkOnClickListener != null) {
                    mDLinkOnClickListener.a(this.b);
                    return;
                  } 
                  WebViewShowInfoFragment.show(this.c, this.b);
                }
                
                public void updateDrawState(TextPaint param1TextPaint) {
                  super.updateDrawState(param1TextPaint);
                  param1TextPaint.setColor(BluedSkinUtils.a(this.c, this.d));
                  param1TextPaint.setUnderlineText(true);
                  param1TextPaint.setFakeBoldText(false);
                }
              }i, j, 33); 
        i = matcher.end();
        spannableStringBuilder = spannableStringBuilder1;
      } 
    } 
    if (spannableStringBuilder != null && i < paramCharSequence.length() - 1)
      spannableStringBuilder.append(paramCharSequence.subSequence(i, paramCharSequence.length())); 
    return (CharSequence)((spannableStringBuilder != null) ? spannableStringBuilder : paramCharSequence);
  }
  
  public static String a(Editable paramEditable) {
    if (TextUtils.isEmpty((CharSequence)paramEditable))
      return null; 
    String str1 = paramEditable.toString();
    String str2 = str1;
    if (paramEditable instanceof SpannableStringBuilder) {
      SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder)paramEditable;
      MDLinkForegroundColorSpan[] arrayOfMDLinkForegroundColorSpan = (MDLinkForegroundColorSpan[])spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), MDLinkForegroundColorSpan.class);
      int j = arrayOfMDLinkForegroundColorSpan.length;
      String str = str1;
      for (int i = 0; i < j; i++) {
        MDLinkForegroundColorSpan mDLinkForegroundColorSpan = arrayOfMDLinkForegroundColorSpan[i];
        int k = spannableStringBuilder.getSpanStart(mDLinkForegroundColorSpan);
        int m = spannableStringBuilder.getSpanEnd(mDLinkForegroundColorSpan);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str.substring(0, k));
        stringBuilder.append(mDLinkForegroundColorSpan.c);
        stringBuilder.append(str.substring(m, spannableStringBuilder.length()));
        str = stringBuilder.toString();
      } 
      str2 = str;
    } 
    return str2;
  }
  
  public static void a(EmojiEditText paramEmojiEditText) {
    paramEmojiEditText.setOnSelectionChangeListener(new SelectionEditText.OnSelectionChangeListener(paramEmojiEditText) {
          public void a(int param1Int1, int param1Int2) {
            Editable editable = this.a.getText();
            if (editable instanceof SpannableStringBuilder) {
              SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder)editable;
              MarkDownLinkHelper.MDLinkForegroundColorSpan[] arrayOfMDLinkForegroundColorSpan = (MarkDownLinkHelper.MDLinkForegroundColorSpan[])spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), MarkDownLinkHelper.MDLinkForegroundColorSpan.class);
              int k = arrayOfMDLinkForegroundColorSpan.length;
              int i = 0;
              int j;
              for (j = param1Int2; i < k; j = m) {
                MarkDownLinkHelper.MDLinkForegroundColorSpan mDLinkForegroundColorSpan = arrayOfMDLinkForegroundColorSpan[i];
                int i1 = spannableStringBuilder.getSpanStart(mDLinkForegroundColorSpan);
                int i2 = spannableStringBuilder.getSpanEnd(mDLinkForegroundColorSpan);
                if (param1Int1 > i1 && param1Int1 < i2) {
                  param1Int1 = i1;
                  param1Int2 = 1;
                } else {
                  param1Int2 = 0;
                } 
                int m = j;
                int n = param1Int2;
                if (j < i2) {
                  m = j;
                  n = param1Int2;
                  if (j > i1) {
                    m = i2;
                    n = 1;
                  } 
                } 
                if (n != 0)
                  this.a.setSelection(param1Int1, m); 
                i++;
              } 
            } 
          }
        });
  }
  
  public static boolean a(EditText paramEditText, CharSequence paramCharSequence1, CharSequence paramCharSequence2, Editable paramEditable, int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   4: ifne -> 244
    //   7: aload_1
    //   8: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   11: ifne -> 244
    //   14: aload_2
    //   15: instanceof android/text/SpannableStringBuilder
    //   18: ifeq -> 244
    //   21: aload_1
    //   22: instanceof android/text/SpannableStringBuilder
    //   25: ifne -> 30
    //   28: iconst_0
    //   29: ireturn
    //   30: aload_2
    //   31: invokeinterface length : ()I
    //   36: aload_1
    //   37: invokeinterface length : ()I
    //   42: if_icmpge -> 244
    //   45: aload_1
    //   46: checkcast android/text/SpannableStringBuilder
    //   49: astore_2
    //   50: aload_2
    //   51: iconst_0
    //   52: aload_2
    //   53: invokevirtual length : ()I
    //   56: ldc com/soft/blued/utils/MarkDownLinkHelper$MDLinkForegroundColorSpan
    //   58: invokevirtual getSpans : (IILjava/lang/Class;)[Ljava/lang/Object;
    //   61: checkcast [Lcom/soft/blued/utils/MarkDownLinkHelper$MDLinkForegroundColorSpan;
    //   64: astore #11
    //   66: aload #11
    //   68: arraylength
    //   69: istore #8
    //   71: iconst_0
    //   72: istore #6
    //   74: iconst_0
    //   75: istore #10
    //   77: iload #6
    //   79: iload #8
    //   81: if_icmpge -> 241
    //   84: aload #11
    //   86: iload #6
    //   88: aaload
    //   89: astore #12
    //   91: aload_2
    //   92: aload #12
    //   94: invokevirtual getSpanStart : (Ljava/lang/Object;)I
    //   97: istore #7
    //   99: aload_2
    //   100: aload #12
    //   102: invokevirtual getSpanEnd : (Ljava/lang/Object;)I
    //   105: istore #9
    //   107: iload #4
    //   109: iload #5
    //   111: if_icmpne -> 137
    //   114: iload #5
    //   116: iload #9
    //   118: if_icmpne -> 137
    //   121: aload_0
    //   122: aload_1
    //   123: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   126: aload_0
    //   127: iload #7
    //   129: iload #9
    //   131: invokevirtual setSelection : (II)V
    //   134: goto -> 215
    //   137: iload #4
    //   139: iload #7
    //   141: if_icmpgt -> 153
    //   144: iload #5
    //   146: iload #9
    //   148: if_icmplt -> 153
    //   151: iconst_0
    //   152: ireturn
    //   153: iload #4
    //   155: iload #7
    //   157: if_icmpgt -> 187
    //   160: iload #5
    //   162: iload #7
    //   164: if_icmple -> 187
    //   167: aload_3
    //   168: iload #4
    //   170: iload #9
    //   172: iload #5
    //   174: isub
    //   175: invokeinterface delete : (II)Landroid/text/Editable;
    //   180: pop
    //   181: iconst_1
    //   182: istore #7
    //   184: goto -> 218
    //   187: iload #4
    //   189: iload #9
    //   191: if_icmpge -> 215
    //   194: iload #5
    //   196: iload #9
    //   198: if_icmplt -> 215
    //   201: aload_3
    //   202: iload #7
    //   204: iload #4
    //   206: invokeinterface delete : (II)Landroid/text/Editable;
    //   211: pop
    //   212: goto -> 181
    //   215: iconst_0
    //   216: istore #7
    //   218: iload #7
    //   220: ifeq -> 232
    //   223: aload_2
    //   224: aload #12
    //   226: invokevirtual removeSpan : (Ljava/lang/Object;)V
    //   229: iconst_1
    //   230: istore #10
    //   232: iload #6
    //   234: iconst_1
    //   235: iadd
    //   236: istore #6
    //   238: goto -> 77
    //   241: iload #10
    //   243: ireturn
    //   244: iconst_0
    //   245: ireturn
  }
  
  public static boolean a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return false; 
    Matcher matcher = Pattern.compile("\\[([\\s\\S]*?)\\]\\(([\\s\\S]*?)\\)").matcher(paramString);
    while (matcher.find()) {
      String str1 = matcher.group(1);
      String str2 = matcher.group(2);
      if (TextUtils.isEmpty(str1) || TextUtils.isEmpty(str2))
        continue; 
      return true;
    } 
    return false;
  }
  
  public static class MDLinkForegroundColorSpan extends ForegroundColorSpan {
    public String a;
    
    public String b;
    
    public String c;
    
    public MDLinkForegroundColorSpan(int param1Int) {
      super(param1Int);
    }
  }
  
  public static interface MDLinkOnClickListener {
    void a(String param1String);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\MarkDownLinkHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */