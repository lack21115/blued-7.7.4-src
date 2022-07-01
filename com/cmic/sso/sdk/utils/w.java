package com.cmic.sso.sdk.utils;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cmic.sso.sdk.AuthThemeConfig;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.widget.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class w {
  private static ArrayList<WeakReference<Activity>> a;
  
  public static int a(Context paramContext) {
    WindowManager windowManager = (WindowManager)paramContext.getSystemService("window");
    DisplayMetrics displayMetrics = new DisplayMetrics();
    if (windowManager != null)
      windowManager.getDefaultDisplay().getMetrics(displayMetrics); 
    return displayMetrics.widthPixels;
  }
  
  public static int a(Context paramContext, float paramFloat) {
    if (paramFloat < 0.0F)
      return (int)paramFloat; 
    try {
      float f = (paramContext.getResources().getDisplayMetrics()).density;
      return (int)(paramFloat * f + 0.5F);
    } catch (Exception exception) {
      return (int)paramFloat;
    } 
  }
  
  public static SpannableString a(Context paramContext, String paramString1, String paramString2, a parama1, a parama2, a parama3) {
    SpannableString spannableString = new SpannableString(paramString1);
    try {
      String str;
      ClickableSpan clickableSpan2 = new ClickableSpan(paramContext, parama1) {
          public void onClick(View param1View) {
            a a1 = this.b;
            if (a1 != null && !a1.isShowing())
              this.b.show(); 
          }
          
          public void updateDrawState(TextPaint param1TextPaint) {
            super.updateDrawState(param1TextPaint);
            param1TextPaint.setUnderlineText(false);
            try {
              param1TextPaint.setColor(AuthnHelper.getInstance(this.a).getAuthThemeConfig().getClauseColor());
              return;
            } catch (Exception exception) {
              param1TextPaint.setColor(-16007674);
              return;
            } 
          }
        };
      ClickableSpan clickableSpan1 = null;
      if (parama2 != null) {
        ClickableSpan clickableSpan = new ClickableSpan(paramContext, parama2) {
            public void onClick(View param1View) {
              a a1 = this.b;
              if (a1 != null && !a1.isShowing())
                this.b.show(); 
            }
            
            public void updateDrawState(TextPaint param1TextPaint) {
              super.updateDrawState(param1TextPaint);
              param1TextPaint.setUnderlineText(false);
              try {
                param1TextPaint.setColor(AuthnHelper.getInstance(this.a).getAuthThemeConfig().getClauseColor());
                return;
              } catch (Exception exception) {
                param1TextPaint.setColor(-16007674);
                return;
              } 
            }
          };
      } else {
        parama1 = null;
      } 
      if (parama3 != null)
        clickableSpan1 = new ClickableSpan(paramContext, parama3) {
            public void onClick(View param1View) {
              a a1 = this.b;
              if (a1 != null && !a1.isShowing())
                this.b.show(); 
            }
            
            public void updateDrawState(TextPaint param1TextPaint) {
              super.updateDrawState(param1TextPaint);
              param1TextPaint.setUnderlineText(false);
              try {
                param1TextPaint.setColor(AuthnHelper.getInstance(this.a).getAuthThemeConfig().getClauseColor());
                return;
              } catch (Exception exception) {
                param1TextPaint.setColor(-16007674);
                return;
              } 
            }
          }; 
      AuthThemeConfig authThemeConfig = AuthnHelper.getInstance(paramContext).getAuthThemeConfig();
      int i = paramString1.indexOf(paramString2);
      spannableString.setSpan(clickableSpan2, i, paramString2.length() + i, 34);
      if (parama2 != null && parama3 != null) {
        paramString2 = authThemeConfig.getClauseName();
        i = paramString1.indexOf(paramString2);
        spannableString.setSpan(parama1, i, paramString2.length() + i, 34);
        int j = paramString2.length();
        str = authThemeConfig.getClauseName2();
        i = paramString1.indexOf(str, i + j);
        spannableString.setSpan(clickableSpan1, i, str.length() + i, 34);
        return spannableString;
      } 
      if (parama2 != null) {
        str = str.getClauseName();
        i = paramString1.indexOf(str);
        spannableString.setSpan(parama1, i, str.length() + i, 34);
        return spannableString;
      } 
      if (parama3 != null) {
        str = str.getClauseName2();
        i = paramString1.indexOf(str);
        spannableString.setSpan(clickableSpan1, i, str.length() + i, 34);
      } 
      return spannableString;
    } catch (Exception exception) {
      exception.printStackTrace();
      return spannableString;
    } 
  }
  
  public static RelativeLayout a(Context paramContext, View paramView, int paramInt1, int paramInt2, String paramString, View.OnClickListener paramOnClickListener) {
    int i;
    AuthThemeConfig authThemeConfig = AuthnHelper.getInstance(paramContext).getAuthThemeConfig();
    RelativeLayout relativeLayout = new RelativeLayout(paramContext);
    if (paramView != null) {
      i = -2;
    } else {
      i = a(paramContext, 49.0F);
    } 
    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, i);
    layoutParams2.addRule(10, -1);
    relativeLayout.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    relativeLayout.setId(paramInt1);
    TextView textView = new TextView(paramContext);
    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams3.addRule(13, -1);
    textView.setLayoutParams((ViewGroup.LayoutParams)layoutParams3);
    textView.setTextColor(authThemeConfig.getNavTextColor());
    textView.setTextSize(2, authThemeConfig.getNavTextSize());
    textView.setText(paramString);
    if (paramView != null) {
      relativeLayout.addView(paramView);
      relativeLayout.addView((View)textView);
      return relativeLayout;
    } 
    relativeLayout.addView((View)textView);
    ImageButton imageButton = new ImageButton(paramContext);
    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(a(paramContext, authThemeConfig.getNavReturnImgWidth()), a(paramContext, authThemeConfig.getNavReturnImgHeight()));
    layoutParams1.addRule(9, -1);
    layoutParams1.addRule(15, -1);
    layoutParams1.setMargins(a(paramContext, 12.0F), 0, 0, 0);
    imageButton.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    imageButton.setId(paramInt2);
    imageButton.setOnClickListener(paramOnClickListener);
    imageButton.setBackgroundColor(0);
    relativeLayout.addView((View)imageButton);
    relativeLayout.setBackgroundColor(-16742704);
    imageButton.setImageResource(n.a(paramContext, "umcsdk_return_bg"));
    return relativeLayout;
  }
  
  public static int b(Context paramContext) {
    WindowManager windowManager = (WindowManager)paramContext.getSystemService("window");
    DisplayMetrics displayMetrics = new DisplayMetrics();
    if (windowManager != null)
      windowManager.getDefaultDisplay().getMetrics(displayMetrics); 
    return displayMetrics.heightPixels;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\cmic\sso\sd\\utils\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */