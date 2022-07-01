package com.soft.blued.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.ClickUtils;
import com.blued.android.module.common.utils.LinkMovementClickMethod;
import com.blued.das.message.MessageProtos;
import com.soft.blued.log.trackUtils.EventTrackMessage;
import com.soft.blued.ui.web.WebViewShowInfoFragment;

public class TypefaceUtils {
  public static SpannableStringBuilder a(Context paramContext, String paramString, boolean paramBoolean) {
    if (TextUtils.isEmpty(paramString))
      return new SpannableStringBuilder(paramString); 
    Spanned spanned = Html.fromHtml(paramString);
    if (!(spanned instanceof SpannableStringBuilder))
      return new SpannableStringBuilder(paramString); 
    SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder)spanned;
    int j = spannableStringBuilder.length();
    int i = 0;
    Object[] arrayOfObject = spannableStringBuilder.getSpans(0, j, URLSpan.class);
    if (arrayOfObject != null && arrayOfObject.length != 0) {
      j = arrayOfObject.length;
      while (i < j) {
        Object object = arrayOfObject[i];
        int k = spannableStringBuilder.getSpanStart(object);
        int m = spannableStringBuilder.getSpanEnd(object);
        if (object instanceof URLSpan) {
          URLSpan uRLSpan = (URLSpan)object;
          String str = uRLSpan.getURL();
          spannableStringBuilder.removeSpan(object);
          spannableStringBuilder.setSpan(new ClickableSpan(paramBoolean, str, paramContext, uRLSpan) {
                public void onClick(View param1View) {
                  if (this.a)
                    EventTrackMessage.a(MessageProtos.Event.BLUED_MSG_CLICK, this.b); 
                  WebViewShowInfoFragment.show(this.c, this.d.getURL(), -1);
                }
                
                public void updateDrawState(TextPaint param1TextPaint) {
                  super.updateDrawState(param1TextPaint);
                  param1TextPaint.setUnderlineText(false);
                }
              }k, m, 17);
        } 
        i++;
      } 
    } 
    return spannableStringBuilder;
  }
  
  public static View a(Context paramContext, String paramString, double paramDouble) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    View view = LayoutInflater.from(paramContext).inflate(2131493785, null);
    TextView textView = (TextView)view.findViewById(2131301088);
    textView.setText(paramString);
    if (paramDouble > 1.0D) {
      textView.setTextSize(DensityUtils.c(paramContext, (float)(textView.getTextSize() * paramDouble)));
      ImageView imageView = (ImageView)view.findViewById(2131297840);
      ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
      layoutParams.width = (int)(layoutParams.width * paramDouble);
      layoutParams.height = (int)(layoutParams.height * paramDouble);
      imageView.setLayoutParams(layoutParams);
    } 
    return view;
  }
  
  public static void a(Context paramContext, int paramInt1, TextView paramTextView, int paramInt2) {
    if (paramTextView != null) {
      paramTextView.setText(paramContext.getResources().getString(2131758671));
      if (paramInt1 > 0) {
        Drawable drawable = paramContext.getResources().getDrawable(paramInt1);
        if (paramInt2 == 0) {
          drawable.setBounds(0, 0, AppMethods.a(11), AppMethods.a(11));
        } else {
          drawable.setBounds(0, 0, AppMethods.a(paramInt2), AppMethods.a(paramInt2));
        } 
        paramTextView.setCompoundDrawables(drawable, null, null, null);
        paramTextView.setCompoundDrawablePadding(DensityUtils.a(paramContext, 3.0F));
      } 
    } 
  }
  
  public static void a(Context paramContext, TextView paramTextView, int paramInt1, int paramInt2) {
    a(paramContext, paramTextView, paramInt1, paramInt2, 0);
  }
  
  public static void a(Context paramContext, TextView paramTextView, int paramInt1, int paramInt2, int paramInt3) {
    if (paramInt1 == 1) {
      paramInt1 = -1;
      if (paramInt2 == 1)
        paramInt1 = 2131232741; 
      a(paramContext, paramInt1, paramTextView, paramInt3);
      return;
    } 
    paramTextView.setCompoundDrawables(null, null, null, null);
  }
  
  public static void a(Context paramContext, TextView paramTextView, View.OnClickListener paramOnClickListener, SpannIndex paramSpannIndex1, SpannIndex paramSpannIndex2) {
    a(paramContext, paramTextView, paramOnClickListener, paramSpannIndex1, paramSpannIndex2, false);
  }
  
  public static void a(Context paramContext, TextView paramTextView, View.OnClickListener paramOnClickListener, SpannIndex paramSpannIndex1, SpannIndex paramSpannIndex2, boolean paramBoolean) {
    if (paramTextView != null) {
      ClickUtils.RevoWhiteClickSpan revoWhiteClickSpan;
      ClickUtils.RevoClickSpan revoClickSpan;
      if (paramSpannIndex1 == null)
        return; 
      SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(paramTextView.getText());
      if (paramBoolean) {
        revoWhiteClickSpan = new ClickUtils.RevoWhiteClickSpan(paramContext, new View.OnClickListener(paramOnClickListener) {
              public void onClick(View param1View) {
                View.OnClickListener onClickListener = this.a;
                if (onClickListener != null)
                  onClickListener.onClick(param1View); 
              }
            });
      } else {
        revoClickSpan = new ClickUtils.RevoClickSpan((Context)revoWhiteClickSpan, new View.OnClickListener(paramOnClickListener) {
              public void onClick(View param1View) {
                View.OnClickListener onClickListener = this.a;
                if (onClickListener != null)
                  onClickListener.onClick(param1View); 
              }
            });
      } 
      if ("zh".equals(BlueAppLocal.c().getLanguage()) && paramSpannIndex1 != null) {
        if (paramSpannIndex1.a < spannableStringBuilder.length() && paramSpannIndex1.b <= spannableStringBuilder.length())
          spannableStringBuilder.setSpan(revoClickSpan, paramSpannIndex1.a, paramSpannIndex1.b, 17); 
      } else if (paramSpannIndex2 != null && paramSpannIndex2.a < spannableStringBuilder.length() && paramSpannIndex2.b <= spannableStringBuilder.length()) {
        spannableStringBuilder.setSpan(revoClickSpan, paramSpannIndex2.a, paramSpannIndex2.b, 17);
      } 
      paramTextView.setText((CharSequence)spannableStringBuilder);
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    } 
  }
  
  public static void a(Context paramContext, TextView paramTextView, String paramString, int paramInt) {
    if (!StringUtils.e(paramString) && paramTextView != null) {
      String str = paramTextView.getText().toString().toLowerCase();
      paramString = paramString.toLowerCase();
      if (str.contains(paramString)) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int i = 0;
        while (i < str.length() - 1) {
          int j = str.indexOf(paramString, i);
          if (j >= 0) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(paramInt), j, paramString.length() + j, 33);
            i = Math.max(i + 1, j);
          } 
        } 
        paramTextView.setText((CharSequence)spannableStringBuilder);
        return;
      } 
      paramTextView.setText(str);
    } 
  }
  
  public static void a(TextView paramTextView, CharSequence paramCharSequence, int paramInt1, ClickAtLinkListener paramClickAtLinkListener, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, int paramInt2, boolean... paramVarArgs) {
    if (paramTextView == null)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramCharSequence);
    stringBuilder.append("");
    if (TextUtils.isEmpty(stringBuilder.toString())) {
      paramTextView.setText("");
      return;
    } 
    CharSequence charSequence = StringUtils.a(StringUtils.a(paramCharSequence, (int)paramTextView.getTextSize(), paramInt1), true, true, false, paramClickAtLinkListener, paramBoolean2, "", paramString);
    paramCharSequence = charSequence;
    if (paramBoolean1)
      paramCharSequence = StringUtils.a(charSequence, paramBoolean2, paramVarArgs); 
    paramTextView.setText(paramCharSequence);
    if (paramBoolean3)
      paramTextView.setMovementMethod((MovementMethod)LinkMovementClickMethod.a()); 
  }
  
  public static void a(TextView paramTextView, CharSequence paramCharSequence, int paramInt, String paramString) {
    a(paramTextView, paramCharSequence, paramInt, null, true, true, true, paramString, -1, new boolean[0]);
  }
  
  public static void a(TextView paramTextView, CharSequence paramCharSequence, boolean paramBoolean, String paramString) {
    a(paramTextView, paramCharSequence, 0, null, true, paramBoolean, true, paramString, -1, new boolean[0]);
  }
  
  public static void a(TextView paramTextView, CharSequence paramCharSequence, boolean paramBoolean, String paramString, int paramInt, boolean... paramVarArgs) {
    a(paramTextView, paramCharSequence, 0, null, true, paramBoolean, true, paramString, paramInt, paramVarArgs);
  }
  
  public static void b(Context paramContext, TextView paramTextView, int paramInt1, int paramInt2) {
    b(paramContext, paramTextView, paramInt1, paramInt2, 0);
  }
  
  public static void b(Context paramContext, TextView paramTextView, int paramInt1, int paramInt2, int paramInt3) {
    if (paramInt1 == 1) {
      paramInt1 = -1;
      if (paramInt2 == 1)
        paramInt1 = 2131232435; 
      a(paramContext, paramInt1, paramTextView, paramInt3);
      return;
    } 
    paramTextView.setCompoundDrawables(null, null, null, null);
  }
  
  public static interface ClickAtLinkListener {
    void a(String param1String1, String param1String2);
  }
  
  public static class SpannIndex {
    public int a;
    
    public int b;
    
    public SpannIndex(int param1Int1, int param1Int2) {
      this.a = param1Int1;
      this.b = param1Int2;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\TypefaceUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */