package com.geetest.onelogin.j;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.geetest.onelogin.activity.OneLoginWebActivity;
import com.geetest.onelogin.config.OneLoginThemeConfig;
import com.geetest.onelogin.listener.c;

public class k {
  private static SpannableString a(String paramString1, String paramString2, boolean paramBoolean, OneLoginThemeConfig paramOneLoginThemeConfig, Context paramContext) {
    String str = a(paramString1, paramOneLoginThemeConfig);
    SpannableString spannableString = new SpannableString(str);
    spannableString.setSpan(new ClickableSpan(paramString1, paramString2, paramOneLoginThemeConfig, paramContext, paramBoolean) {
          public void onClick(View param1View) {
            c.a(this.a, this.b);
            if (this.c.isUseNormalWebActivity())
              try {
                Intent intent = new Intent(this.d, OneLoginWebActivity.class);
                intent.addFlags(268435456);
                intent.putExtra("web_intent", this.b);
                intent.putExtra("web_title_name", k.a(this.a));
                intent.putExtra("web_is_operator_privacy", this.e);
                this.d.startActivity(intent);
                return;
              } catch (Exception exception) {
                exception.printStackTrace();
              }  
          }
          
          public void updateDrawState(TextPaint param1TextPaint) {
            param1TextPaint.setColor(this.c.getClauseColor());
            param1TextPaint.setUnderlineText(false);
            param1TextPaint.setTypeface(this.c.getPrivacyClauseTextViewTypeface());
          }
        }0, str.length(), 33);
    return spannableString;
  }
  
  private static String a(String paramString, OneLoginThemeConfig paramOneLoginThemeConfig) {
    String str = paramString;
    if (paramOneLoginThemeConfig.isPrivacyAddFrenchQuotes()) {
      String str1 = paramString;
      if (!paramString.startsWith("《")) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("《");
        stringBuilder.append(paramString);
        str1 = stringBuilder.toString();
      } 
      str = str1;
      if (!str1.endsWith("》")) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str1);
        stringBuilder.append("》");
        str = stringBuilder.toString();
      } 
    } 
    return str;
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean) {
    try {
      Window window = paramActivity.getWindow();
      WindowManager.LayoutParams layoutParams = window.getAttributes();
      layoutParams.width = d.a(paramActivity.getApplicationContext(), paramInt1);
      layoutParams.height = d.a(paramActivity.getApplicationContext(), paramInt2);
      layoutParams.x = d.a(paramActivity.getApplicationContext(), paramInt3);
      if (paramBoolean) {
        layoutParams.gravity = 80;
      } else {
        layoutParams.y = d.a(paramActivity.getApplicationContext(), paramInt4);
      } 
      window.setAttributes(layoutParams);
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("设置主题失败: ");
      stringBuilder.append(exception.toString());
      h.c(stringBuilder.toString());
      return;
    } 
  }
  
  public static void a(TextView paramTextView, String paramString1, String paramString2, OneLoginThemeConfig paramOneLoginThemeConfig, Context paramContext) {
    try {
      paramTextView.setTypeface(paramOneLoginThemeConfig.getPrivacyClauseBaseTextViewTypeface());
      paramTextView.setText(paramOneLoginThemeConfig.getPrivacyTextViewTv1());
      paramTextView.setLineSpacing(8.0F, 1.0F);
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
      paramTextView.setHighlightColor(0);
      if (!TextUtils.isEmpty(paramOneLoginThemeConfig.getClause_name()) && !TextUtils.isEmpty(paramOneLoginThemeConfig.getClause_url())) {
        paramTextView.append((CharSequence)a(paramOneLoginThemeConfig.getClause_name(), paramOneLoginThemeConfig.getClause_url(), false, paramOneLoginThemeConfig, paramContext));
        if (!TextUtils.isEmpty(paramOneLoginThemeConfig.getClause_name_two()) && !TextUtils.isEmpty(paramOneLoginThemeConfig.getClause_url_two())) {
          paramTextView.append(paramOneLoginThemeConfig.getPrivacyTextViewTv2());
          paramTextView.append((CharSequence)a(paramOneLoginThemeConfig.getClause_name_two(), paramOneLoginThemeConfig.getClause_url_two(), false, paramOneLoginThemeConfig, paramContext));
          paramTextView.append(paramOneLoginThemeConfig.getPrivacyTextViewTv3());
          paramTextView.append((CharSequence)a(paramString1, paramString2, true, paramOneLoginThemeConfig, paramContext));
        } else {
          paramTextView.append(paramOneLoginThemeConfig.getPrivacyTextViewTv2());
          paramTextView.append((CharSequence)a(paramString1, paramString2, true, paramOneLoginThemeConfig, paramContext));
          if (!TextUtils.isEmpty(paramOneLoginThemeConfig.getClause_name_three()) && !TextUtils.isEmpty(paramOneLoginThemeConfig.getClause_url_three())) {
            paramTextView.append(paramOneLoginThemeConfig.getPrivacyTextViewTv3());
            paramTextView.append((CharSequence)a(paramOneLoginThemeConfig.getClause_name_three(), paramOneLoginThemeConfig.getClause_url_three(), false, paramOneLoginThemeConfig, paramContext));
          } 
        } 
      } else {
        paramTextView.append((CharSequence)a(paramString1, paramString2, true, paramOneLoginThemeConfig, paramContext));
        if (!TextUtils.isEmpty(paramOneLoginThemeConfig.getClause_name_two()) && !TextUtils.isEmpty(paramOneLoginThemeConfig.getClause_url_two())) {
          paramTextView.append(paramOneLoginThemeConfig.getPrivacyTextViewTv2());
          paramTextView.append((CharSequence)a(paramOneLoginThemeConfig.getClause_name_two(), paramOneLoginThemeConfig.getClause_url_two(), false, paramOneLoginThemeConfig, paramContext));
          if (!TextUtils.isEmpty(paramOneLoginThemeConfig.getClause_name_three()) && !TextUtils.isEmpty(paramOneLoginThemeConfig.getClause_url_three())) {
            paramTextView.append(paramOneLoginThemeConfig.getPrivacyTextViewTv3());
            paramTextView.append((CharSequence)a(paramOneLoginThemeConfig.getClause_name_three(), paramOneLoginThemeConfig.getClause_url_three(), false, paramOneLoginThemeConfig, paramContext));
          } 
        } 
      } 
      paramTextView.append(paramOneLoginThemeConfig.getPrivacyTextViewTv4());
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("设置隐私协议失败: ");
      stringBuilder.append(exception.toString());
      h.c(stringBuilder.toString());
      return;
    } 
  }
  
  private static String b(String paramString) {
    return paramString.replaceFirst("《", "").replace("》", "");
  }
  
  public static void b(TextView paramTextView, String paramString1, String paramString2, OneLoginThemeConfig paramOneLoginThemeConfig, Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: aload_3
    //   2: invokevirtual getPrivacyClauseBaseTextViewTypeface : ()Landroid/graphics/Typeface;
    //   5: invokevirtual setTypeface : (Landroid/graphics/Typeface;)V
    //   8: aload_0
    //   9: ldc 8.0
    //   11: fconst_1
    //   12: invokevirtual setLineSpacing : (FF)V
    //   15: aload_0
    //   16: invokestatic getInstance : ()Landroid/text/method/MovementMethod;
    //   19: invokevirtual setMovementMethod : (Landroid/text/method/MovementMethod;)V
    //   22: aload_0
    //   23: iconst_0
    //   24: invokevirtual setHighlightColor : (I)V
    //   27: aload_3
    //   28: invokevirtual getPrivacyClauseTextStrings : ()[Ljava/lang/String;
    //   31: astore #9
    //   33: aload #9
    //   35: ifnull -> 223
    //   38: aload #9
    //   40: arraylength
    //   41: ifeq -> 223
    //   44: aload #9
    //   46: arraylength
    //   47: iconst_4
    //   48: irem
    //   49: ifne -> 223
    //   52: iconst_0
    //   53: istore #5
    //   55: iload #5
    //   57: aload #9
    //   59: arraylength
    //   60: if_icmpge -> 232
    //   63: iload #5
    //   65: iconst_4
    //   66: irem
    //   67: ifne -> 286
    //   70: aload #9
    //   72: iload #5
    //   74: aaload
    //   75: astore #13
    //   77: aload #9
    //   79: iload #5
    //   81: iconst_1
    //   82: iadd
    //   83: aaload
    //   84: astore #10
    //   86: aload #9
    //   88: iload #5
    //   90: iconst_2
    //   91: iadd
    //   92: aaload
    //   93: astore #11
    //   95: aload #9
    //   97: iload #5
    //   99: iconst_3
    //   100: iadd
    //   101: aaload
    //   102: astore #12
    //   104: aload_0
    //   105: aload #13
    //   107: invokevirtual append : (Ljava/lang/CharSequence;)V
    //   110: aload #10
    //   112: invokevirtual trim : ()Ljava/lang/String;
    //   115: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   118: astore #13
    //   120: getstatic com/geetest/onelogin/g/d.a : [Lcom/geetest/onelogin/g/c;
    //   123: astore #14
    //   125: aload #14
    //   127: arraylength
    //   128: istore #7
    //   130: iconst_0
    //   131: istore #6
    //   133: iload #6
    //   135: iload #7
    //   137: if_icmpge -> 280
    //   140: aload #14
    //   142: iload #6
    //   144: aaload
    //   145: invokevirtual b : ()Ljava/lang/String;
    //   148: aload #13
    //   150: invokevirtual equals : (Ljava/lang/Object;)Z
    //   153: ifeq -> 271
    //   156: iconst_1
    //   157: istore #8
    //   159: goto -> 162
    //   162: aload #10
    //   164: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   167: ifne -> 200
    //   170: aload #11
    //   172: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   175: ifeq -> 181
    //   178: goto -> 200
    //   181: aload_0
    //   182: aload #10
    //   184: aload #11
    //   186: iload #8
    //   188: aload_3
    //   189: aload #4
    //   191: invokestatic a : (Ljava/lang/String;Ljava/lang/String;ZLcom/geetest/onelogin/config/OneLoginThemeConfig;Landroid/content/Context;)Landroid/text/SpannableString;
    //   194: invokevirtual append : (Ljava/lang/CharSequence;)V
    //   197: goto -> 214
    //   200: aload_0
    //   201: aload_1
    //   202: aload_2
    //   203: iload #8
    //   205: aload_3
    //   206: aload #4
    //   208: invokestatic a : (Ljava/lang/String;Ljava/lang/String;ZLcom/geetest/onelogin/config/OneLoginThemeConfig;Landroid/content/Context;)Landroid/text/SpannableString;
    //   211: invokevirtual append : (Ljava/lang/CharSequence;)V
    //   214: aload_0
    //   215: aload #12
    //   217: invokevirtual append : (Ljava/lang/CharSequence;)V
    //   220: goto -> 286
    //   223: aload_0
    //   224: aload_1
    //   225: aload_2
    //   226: aload_3
    //   227: aload #4
    //   229: invokestatic a : (Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/String;Lcom/geetest/onelogin/config/OneLoginThemeConfig;Landroid/content/Context;)V
    //   232: aload_0
    //   233: iconst_0
    //   234: invokevirtual setLongClickable : (Z)V
    //   237: return
    //   238: astore_0
    //   239: new java/lang/StringBuilder
    //   242: dup
    //   243: invokespecial <init> : ()V
    //   246: astore_1
    //   247: aload_1
    //   248: ldc '设置隐私协议失败: '
    //   250: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: aload_1
    //   255: aload_0
    //   256: invokevirtual toString : ()Ljava/lang/String;
    //   259: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: aload_1
    //   264: invokevirtual toString : ()Ljava/lang/String;
    //   267: invokestatic c : (Ljava/lang/String;)V
    //   270: return
    //   271: iload #6
    //   273: iconst_1
    //   274: iadd
    //   275: istore #6
    //   277: goto -> 133
    //   280: iconst_0
    //   281: istore #8
    //   283: goto -> 162
    //   286: iload #5
    //   288: iconst_1
    //   289: iadd
    //   290: istore #5
    //   292: goto -> 55
    // Exception table:
    //   from	to	target	type
    //   0	33	238	java/lang/Exception
    //   38	52	238	java/lang/Exception
    //   55	63	238	java/lang/Exception
    //   104	130	238	java/lang/Exception
    //   140	156	238	java/lang/Exception
    //   162	178	238	java/lang/Exception
    //   181	197	238	java/lang/Exception
    //   200	214	238	java/lang/Exception
    //   214	220	238	java/lang/Exception
    //   223	232	238	java/lang/Exception
    //   232	237	238	java/lang/Exception
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\j\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */