package com.soft.blued.utils;

import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.util.Pair;
import com.blued.android.core.AppInfo;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.das.message.MessageProtos;
import com.soft.blued.log.trackUtils.EventTrackMessage;
import com.soft.blued.ui.feed.manager.FeedSendManager;
import com.soft.blued.ui.msg.customview.Emotion;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.UserInfo;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
  private static final Pattern a = Pattern.compile("[^一-龥]");
  
  private static final Pattern b = Pattern.compile("((http[s]{0,1}|blued)://|www\\.)[A-Za-z0-9\\.\\?\\-_~!@#$%^&/:=]+[A-Za-z0-9/#]");
  
  private static final Pattern c = Pattern.compile("@\\(name:([^\\n\\r`~\\!@#\\$%\\^&\\*\\(\\)\\+=\\|'\\:;'\\,\\[\\]\\.\\<\\>/\\?！@#￥%……（）——\\{\\}【】‘；：”“’。，、？]+),id:([A-Za-z0-9]+)\\)");
  
  private static final Pattern d = Pattern.compile("@([^\\s`~\\!@#\\$%\\^&\\*\\(\\)\\+=\\|'\\:;'\\,\\[\\]\\.\\<\\>/\\?！@#￥%……（）——\\{\\}【】‘；：”“’。，、？]+)");
  
  private static final Pattern e = Pattern.compile("[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+");
  
  public static double a(String paramString, double paramDouble) {
    if (e(paramString))
      return paramDouble; 
    try {
      return Double.valueOf(paramString).doubleValue();
    } catch (Exception exception) {
      exception.printStackTrace();
      return paramDouble;
    } 
  }
  
  public static int a(int paramInt, Locale paramLocale) {
    int i = paramInt;
    if (paramInt == 0)
      i = 1; 
    return i;
  }
  
  public static int a(Editable paramEditable) {
    int j = 0;
    int i = 0;
    while (j < paramEditable.length()) {
      if (paramEditable.charAt(j) < '') {
        i++;
      } else {
        i += 2;
      } 
      j++;
    } 
    return i;
  }
  
  public static int a(String paramString, int paramInt) {
    if (e(paramString))
      return paramInt; 
    try {
      return Integer.parseInt(paramString);
    } catch (Exception exception) {
      exception.printStackTrace();
      return paramInt;
    } 
  }
  
  public static long a(String paramString, long paramLong) {
    if (e(paramString))
      return paramLong; 
    try {
      return Long.parseLong(paramString);
    } catch (Exception exception) {
      exception.printStackTrace();
      return paramLong;
    } 
  }
  
  public static InputFilter a() {
    return new InputFilter() {
        public CharSequence filter(CharSequence param1CharSequence, int param1Int1, int param1Int2, Spanned param1Spanned, int param1Int3, int param1Int4) {
          if (TextUtils.isEmpty(param1CharSequence))
            return ""; 
          while (param1Int1 < param1Int2) {
            if (StringUtils.b(param1CharSequence) && !param1CharSequence.toString().contains("。") && !param1CharSequence.toString().contains("，") && !param1CharSequence.toString().contains("·"))
              return ""; 
            param1Int1++;
          } 
          return null;
        }
      };
  }
  
  public static CharSequence a(CharSequence paramCharSequence, int paramInt) {
    return a(paramCharSequence, paramInt, 0);
  }
  
  public static CharSequence a(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
    return TextUtils.isEmpty(paramCharSequence) ? paramCharSequence : Emotion.a(paramCharSequence, paramInt1, paramInt2);
  }
  
  public static CharSequence a(CharSequence paramCharSequence, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, TypefaceUtils.ClickAtLinkListener paramClickAtLinkListener, boolean paramBoolean4, String paramString1, String paramString2) {
    if (TextUtils.isEmpty(paramCharSequence))
      return paramCharSequence; 
    Matcher matcher = c.matcher(paramCharSequence);
    SpannableStringBuilder spannableStringBuilder3 = null;
    SpannableStringBuilder spannableStringBuilder1 = null;
    int i = 0;
    while (matcher.find()) {
      boolean bool1;
      boolean bool2;
      SpannableStringBuilder spannableStringBuilder = spannableStringBuilder1;
      if (spannableStringBuilder1 == null)
        spannableStringBuilder = new SpannableStringBuilder(); 
      String str3 = matcher.group(1);
      String str2 = matcher.group(2);
      String str1 = str2;
      if (!TextUtils.isEmpty(str2)) {
        str1 = str2;
        if (!str2.equals("000000"))
          str1 = EncryptTool.a(str2); 
      } 
      if (paramBoolean3)
        FeedSendManager.a().c().put(str3, str1); 
      if (!TextUtils.isEmpty(str1) && str1.equals((UserInfo.a().i()).uid)) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      if (!TextUtils.isEmpty(str1) && str1.equals("000000")) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      str2 = str3;
      if (paramBoolean2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("@");
        stringBuilder.append(str3);
        str2 = stringBuilder.toString();
      } 
      spannableStringBuilder.append(paramCharSequence.subSequence(i, matcher.start()));
      i = spannableStringBuilder.length();
      int j = str2.length() + i;
      spannableStringBuilder.append(str2);
      if (paramBoolean1) {
        if (bool1)
          spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(AppInfo.d(), 2131100849)), i, j, 33); 
        spannableStringBuilder.setSpan(new ClickableSpan(bool2, paramClickAtLinkListener, str2, str1, paramString2, paramBoolean4, paramString1) {
              public void onClick(View param1View) {
                if (this.a)
                  return; 
                Selection.removeSelection((Spannable)((TextView)param1View).getText());
                TypefaceUtils.ClickAtLinkListener clickAtLinkListener = this.b;
                if (clickAtLinkListener != null) {
                  clickAtLinkListener.a(this.c, this.d);
                  return;
                } 
                UserInfoFragmentNew.a(AppInfo.d(), this.d, this.e);
              }
              
              public void updateDrawState(TextPaint param1TextPaint) {
                if (this.f)
                  if (!TextUtils.isEmpty(this.g)) {
                    try {
                      param1TextPaint.setColor(Color.parseColor(this.g));
                    } catch (Exception exception) {
                      param1TextPaint.setColor(AppInfo.d().getResources().getColor(2131099736));
                    } 
                  } else {
                    param1TextPaint.setColor(AppInfo.d().getResources().getColor(2131100849));
                  }  
                param1TextPaint.setUnderlineText(false);
                param1TextPaint.clearShadowLayer();
              }
            }i, j, 33);
        spannableStringBuilder.setSpan(new StyleSpan(1), i, j, 33);
      } 
      i = matcher.end();
      spannableStringBuilder1 = spannableStringBuilder;
    } 
    if (spannableStringBuilder1 != null && i < paramCharSequence.length() - 1)
      spannableStringBuilder1.append(paramCharSequence.subSequence(i, paramCharSequence.length())); 
    SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder1;
    if (spannableStringBuilder1 == null) {
      ArrayList<Pair> arrayList;
      Matcher matcher2 = e.matcher(paramCharSequence);
      SpannableStringBuilder spannableStringBuilder = spannableStringBuilder3;
      while (matcher2.find()) {
        ArrayList<Pair> arrayList1;
        spannableStringBuilder2 = spannableStringBuilder;
        if (spannableStringBuilder == null)
          arrayList1 = new ArrayList(); 
        arrayList1.add(new Pair(Integer.valueOf(matcher2.start()), Integer.valueOf(matcher2.end())));
        arrayList = arrayList1;
      } 
      Matcher matcher1 = d.matcher(paramCharSequence);
      while (true) {
        spannableStringBuilder2 = spannableStringBuilder1;
        if (matcher1.find()) {
          if (arrayList != null && arrayList.size() > 0) {
            Iterator<Pair> iterator = arrayList.iterator();
            while (true) {
              if (iterator.hasNext()) {
                Pair pair = iterator.next();
                if (matcher1.start() >= ((Integer)pair.first).intValue() && matcher1.end() <= ((Integer)pair.second).intValue()) {
                  iterator.remove();
                  i = 1;
                  break;
                } 
                if (matcher1.start() > ((Integer)pair.second).intValue())
                  iterator.remove(); 
                continue;
              } 
              i = 0;
              break;
            } 
            if (i != 0)
              continue; 
          } 
          String str = matcher1.group(1);
          spannableStringBuilder2 = spannableStringBuilder1;
          if (spannableStringBuilder1 == null)
            spannableStringBuilder2 = new SpannableStringBuilder(paramCharSequence); 
          spannableStringBuilder1 = spannableStringBuilder2;
          if (paramBoolean1) {
            if (!TextUtils.isEmpty(str) && str.equals((UserInfo.a().i()).name))
              spannableStringBuilder2.setSpan(new ForegroundColorSpan(ContextCompat.getColor(AppInfo.d(), 2131100849)), matcher1.start(), matcher1.end(), 33); 
            spannableStringBuilder2.setSpan(new ClickableSpan(str, paramClickAtLinkListener, paramString2, paramBoolean4, paramString1) {
                  public void onClick(View param1View) {
                    if (this.a.equals(param1View.getContext().getString(2131756638)))
                      return; 
                    Selection.removeSelection((Spannable)((TextView)param1View).getText());
                    TypefaceUtils.ClickAtLinkListener clickAtLinkListener = this.b;
                    if (clickAtLinkListener != null) {
                      clickAtLinkListener.a(this.a, null);
                      return;
                    } 
                    UserInfoFragmentNew.c(AppInfo.d(), this.a, this.c);
                  }
                  
                  public void updateDrawState(TextPaint param1TextPaint) {
                    if (this.d)
                      if (!TextUtils.isEmpty(this.e)) {
                        try {
                          param1TextPaint.setColor(Color.parseColor(this.e));
                        } catch (Exception exception) {
                          param1TextPaint.setColor(AppInfo.d().getResources().getColor(2131099736));
                        } 
                      } else {
                        param1TextPaint.setColor(AppInfo.d().getResources().getColor(2131100849));
                      }  
                    param1TextPaint.setUnderlineText(false);
                    param1TextPaint.clearShadowLayer();
                  }
                }matcher1.start(), matcher1.end(), 33);
            spannableStringBuilder2.setSpan(new StyleSpan(1), matcher1.start(), matcher1.end(), 33);
            spannableStringBuilder1 = spannableStringBuilder2;
          } 
          continue;
        } 
        break;
      } 
    } 
    return (CharSequence)((spannableStringBuilder2 != null) ? spannableStringBuilder2 : paramCharSequence);
  }
  
  public static CharSequence a(CharSequence paramCharSequence, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString) {
    return a(paramCharSequence, paramBoolean1, paramBoolean2, false, null, paramBoolean3, "", paramString);
  }
  
  public static CharSequence a(CharSequence paramCharSequence, boolean paramBoolean, boolean... paramVarArgs) {
    if (TextUtils.isEmpty(paramCharSequence))
      return paramCharSequence; 
    Matcher matcher = b.matcher(paramCharSequence);
    SpannableStringBuilder spannableStringBuilder = null;
    while (matcher.find()) {
      SpannableStringBuilder spannableStringBuilder1 = spannableStringBuilder;
      if (spannableStringBuilder == null)
        spannableStringBuilder1 = new SpannableStringBuilder(paramCharSequence); 
      JayceSpan jayceSpan = new JayceSpan(matcher.group(), paramBoolean);
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (paramVarArgs != null) {
        bool1 = bool2;
        if (paramVarArgs.length > 0) {
          bool1 = bool2;
          if (paramVarArgs[0])
            bool1 = true; 
        } 
      } 
      jayceSpan.a = bool1;
      spannableStringBuilder1.setSpan(jayceSpan, matcher.start(), matcher.end(), 33);
      spannableStringBuilder = spannableStringBuilder1;
    } 
    return (CharSequence)((spannableStringBuilder != null) ? spannableStringBuilder : paramCharSequence);
  }
  
  public static String a(int paramInt) {
    return (paramInt != 2) ? ((paramInt != 3) ? ((paramInt != 4) ? ((paramInt != 5) ? ((paramInt != 7) ? "" : AppInfo.d().getResources().getString(2131757023)) : AppInfo.d().getResources().getString(2131758298)) : AppInfo.d().getResources().getString(2131758297)) : AppInfo.d().getResources().getString(2131758294)) : AppInfo.d().getResources().getString(2131758296);
  }
  
  public static String a(int paramInt, String paramString) {
    return String.valueOf(paramInt);
  }
  
  public static String a(long paramLong) {
    if (paramLong < 10000L)
      return a(String.valueOf(paramLong)); 
    String str2 = String.format("%.1f", new Object[] { Double.valueOf(paramLong / 10000.0D) });
    String str1 = str2;
    if (str2.indexOf(".") > 0)
      str1 = str2.replaceAll("0+?$", "").replaceAll("[.]$", ""); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str1);
    stringBuilder.append("万");
    return stringBuilder.toString();
  }
  
  public static String a(Context paramContext, Locale paramLocale, int paramInt) {
    String str1;
    int i = paramInt - 1;
    String[] arrayOfString = paramContext.getResources().getStringArray(2130903104);
    if (i < arrayOfString.length && i >= 0) {
      str1 = arrayOfString[i];
    } else {
      str1 = "";
    } 
    String str2 = str1;
    if ("zh".equals(paramLocale.getLanguage())) {
      paramInt = 0;
      while (true) {
        str2 = str1;
        if (paramInt < UserRelationshipUtils.l.length) {
          if (i == UserRelationshipUtils.l[paramInt]) {
            str2 = "";
            break;
          } 
          paramInt++;
          continue;
        } 
        break;
      } 
    } 
    if (i <= 0)
      str2 = ""; 
    return str2;
  }
  
  public static String a(String paramString) {
    double d;
    DecimalFormat decimalFormat;
    if (TextUtils.isEmpty(paramString))
      return "0"; 
    if (paramString.indexOf(".") > 0) {
      if (paramString.length() - paramString.indexOf(".") - 1 == 0) {
        decimalFormat = new DecimalFormat("###,##0");
      } else if (paramString.length() - paramString.indexOf(".") - 1 == 1) {
        decimalFormat = new DecimalFormat("###,##0.0");
      } else {
        decimalFormat = new DecimalFormat("###,##0.00");
      } 
    } else {
      decimalFormat = new DecimalFormat("###,##0");
    } 
    try {
      d = Double.parseDouble(paramString);
    } catch (Exception exception) {
      d = 0.0D;
    } 
    String str = decimalFormat.format(d);
    paramString = str;
    if (str.indexOf(".") > 0)
      paramString = str.replaceAll("0+?$", "").replaceAll("[.]$", ""); 
    return paramString;
  }
  
  public static String a(String paramString1, String paramString2) {
    if (e(paramString1) && e(paramString2))
      return null; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString1);
    stringBuilder.append("(");
    stringBuilder.append(paramString2);
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
  
  public static String a(String paramString, Locale paramLocale) {
    if (!e(paramString)) {
      int i = BluedPreferences.aD();
      String str = paramString;
      if (i != 1) {
        if (i == 2) {
          i = (int)Math.round(a(paramString, 0) * 2.2D);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(i);
          stringBuilder.append("");
          return stringBuilder.toString();
        } 
      } else {
        return str;
      } 
    } 
    return "";
  }
  
  public static String a(String paramString, Locale paramLocale, boolean paramBoolean) {
    boolean bool = e(paramString);
    String str1 = "";
    String str2 = str1;
    if (!bool) {
      StringBuilder stringBuilder1;
      int i = BluedPreferences.aD();
      if (i != 1) {
        if (i != 2)
          return ""; 
        int j = 0;
        double d = a(paramString, 0) / 30.48D;
        i = (int)d;
        int k = (int)Math.round((d - i) * 12.0D);
        if (k == 12) {
          i++;
        } else {
          j = k;
        } 
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(i);
        stringBuilder1.append("'");
        stringBuilder1.append(j);
        stringBuilder1.append("\"");
        return stringBuilder1.toString();
      } 
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append((String)stringBuilder1);
      if (paramBoolean)
        str1 = " cm"; 
      stringBuilder2.append(str1);
      str2 = stringBuilder2.toString();
    } 
    return str2;
  }
  
  public static String a(String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString) {
    if (!e(paramString))
      for (int i = 0; i < paramArrayOfString2.length; i++) {
        if (paramString.equals(paramArrayOfString2[i]))
          return paramArrayOfString1[i]; 
      }  
    return "";
  }
  
  public static boolean a(CharSequence paramCharSequence) {
    return Pattern.compile("@\\(name:([^\\n\\r`~\\!@#\\$%\\^&\\*\\(\\)\\+=\\|'\\:;'\\,\\[\\]\\.\\<\\>/\\?！@#￥%……（）——\\{\\}【】‘；：”“’。，、？]+),id:([A-Za-z0-9]+)\\)").matcher(paramCharSequence).find();
  }
  
  public static String[] a(Context paramContext) {
    String[] arrayOfString = new String[373];
    String str = paramContext.getResources().getString(2131759104);
    int j = 70;
    for (int i = 0; i < arrayOfString.length; i++) {
      if (i == 0 || i == arrayOfString.length - 1) {
        arrayOfString[i] = str;
      } else {
        arrayOfString[i] = String.valueOf(j);
        j++;
      } 
    } 
    return arrayOfString;
  }
  
  public static String[] a(Context paramContext, Locale paramLocale) {
    String[] arrayOfString2 = paramContext.getResources().getStringArray(2130903104);
    ArrayList<String> arrayList = new ArrayList();
    String[] arrayOfString1 = arrayOfString2;
    if ("zh".equals(paramLocale.getLanguage())) {
      for (int i = 0; i < arrayOfString2.length; i++) {
        int j = 0;
        boolean bool = false;
        while (j < UserRelationshipUtils.l.length) {
          if (bool || UserRelationshipUtils.l[j] == i) {
            bool = true;
          } else {
            bool = false;
          } 
          j++;
        } 
        if (!bool)
          arrayList.add(arrayOfString2[i]); 
      } 
      arrayOfString1 = arrayList.<String>toArray(new String[arrayList.size()]);
    } 
    return arrayOfString1;
  }
  
  public static CharSequence b(CharSequence paramCharSequence, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, TypefaceUtils.ClickAtLinkListener paramClickAtLinkListener, boolean paramBoolean4, String paramString1, String paramString2) {
    if (TextUtils.isEmpty(paramCharSequence))
      return paramCharSequence; 
    Matcher matcher = c.matcher(paramCharSequence);
    TypefaceUtils.ClickAtLinkListener clickAtLinkListener = null;
    SpannableStringBuilder spannableStringBuilder = null;
    int i = 0;
    while (matcher.find()) {
      SpannableStringBuilder spannableStringBuilder1 = spannableStringBuilder;
      if (spannableStringBuilder == null)
        spannableStringBuilder1 = new SpannableStringBuilder(); 
      String str3 = matcher.group(1);
      String str2 = matcher.group(2);
      String str1 = str2;
      if (!TextUtils.isEmpty(str2))
        str1 = EncryptTool.a(str2); 
      if (paramBoolean3)
        FeedSendManager.a().c().put(str3, str1); 
      str2 = str3;
      if (paramBoolean2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("@");
        stringBuilder.append(str3);
        str2 = stringBuilder.toString();
      } 
      spannableStringBuilder1.append(paramCharSequence.subSequence(i, matcher.start()));
      i = spannableStringBuilder1.length();
      int j = str2.length() + i;
      spannableStringBuilder1.append(str2);
      if (paramBoolean1) {
        spannableStringBuilder1.setSpan(new ClickableSpan(paramClickAtLinkListener, str2, str1, paramString2, paramBoolean4, paramString1) {
              public void onClick(View param1View) {
                Selection.removeSelection((Spannable)((TextView)param1View).getText());
                TypefaceUtils.ClickAtLinkListener clickAtLinkListener = this.a;
                if (clickAtLinkListener != null) {
                  clickAtLinkListener.a(this.b, this.c);
                  return;
                } 
                UserInfoFragmentNew.a(AppInfo.d(), this.c, this.d);
              }
              
              public void updateDrawState(TextPaint param1TextPaint) {
                if (this.e)
                  if (!TextUtils.isEmpty(this.f)) {
                    try {
                      param1TextPaint.setColor(Color.parseColor(this.f));
                    } catch (Exception exception) {
                      param1TextPaint.setColor(AppInfo.d().getResources().getColor(2131099736));
                    } 
                  } else {
                    param1TextPaint.setColor(AppInfo.d().getResources().getColor(2131100849));
                  }  
                param1TextPaint.setUnderlineText(false);
                param1TextPaint.clearShadowLayer();
              }
            }i, j, 33);
        spannableStringBuilder1.setSpan(new StyleSpan(1), i, j, 33);
      } 
      i = matcher.end();
      spannableStringBuilder = spannableStringBuilder1;
    } 
    if (spannableStringBuilder != null && i < paramCharSequence.length() - 1)
      spannableStringBuilder.append(paramCharSequence.subSequence(i, paramCharSequence.length())); 
    if (spannableStringBuilder == null) {
      Matcher matcher1 = e.matcher(paramCharSequence);
      paramClickAtLinkListener = clickAtLinkListener;
      while (matcher1.find()) {
        ArrayList<Pair> arrayList2;
        TypefaceUtils.ClickAtLinkListener clickAtLinkListener1 = paramClickAtLinkListener;
        if (paramClickAtLinkListener == null)
          arrayList2 = new ArrayList(); 
        arrayList2.add(new Pair(Integer.valueOf(matcher1.start()), Integer.valueOf(matcher1.end())));
        ArrayList<Pair> arrayList1 = arrayList2;
      } 
    } 
    return (CharSequence)((spannableStringBuilder != null) ? spannableStringBuilder : paramCharSequence);
  }
  
  public static CharSequence b(String paramString1, String paramString2) {
    SpannableStringBuilder spannableStringBuilder;
    if (TextUtils.isEmpty(paramString1))
      return paramString1; 
    if (TextUtils.isEmpty(paramString2))
      return paramString1; 
    String str = null;
    Matcher matcher = Pattern.compile(paramString2).matcher(paramString1);
    paramString2 = str;
    while (matcher.find()) {
      SpannableStringBuilder spannableStringBuilder1;
      str = paramString2;
      if (paramString2 == null)
        spannableStringBuilder1 = new SpannableStringBuilder(paramString1); 
      spannableStringBuilder1.setSpan(new ClickableSpan() {
            public void onClick(View param1View) {}
            
            public void updateDrawState(TextPaint param1TextPaint) {
              param1TextPaint.setColor(AppInfo.d().getResources().getColor(2131100527));
              param1TextPaint.setFakeBoldText(true);
              param1TextPaint.setUnderlineText(true);
              param1TextPaint.clearShadowLayer();
            }
          },  matcher.start(), matcher.end(), 33);
      spannableStringBuilder = spannableStringBuilder1;
    } 
    return (CharSequence)((spannableStringBuilder == null) ? paramString1 : spannableStringBuilder);
  }
  
  public static String b(int paramInt) {
    return AppInfo.d().getResources().getStringArray(2130903100)[paramInt + 1];
  }
  
  public static String b(String paramString) {
    double d;
    DecimalFormat decimalFormat;
    if (TextUtils.isEmpty(paramString))
      return " - "; 
    if (paramString.indexOf(".") > 0) {
      if (paramString.length() - paramString.indexOf(".") - 1 == 0) {
        decimalFormat = new DecimalFormat("###,##0");
      } else if (paramString.length() - paramString.indexOf(".") - 1 == 1) {
        decimalFormat = new DecimalFormat("###,##0.0");
      } else {
        decimalFormat = new DecimalFormat("###,##0.00");
      } 
    } else {
      decimalFormat = new DecimalFormat("###,##0");
    } 
    try {
      d = Double.parseDouble(paramString);
    } catch (Exception exception) {
      d = 0.0D;
    } 
    String str = decimalFormat.format(d);
    paramString = str;
    if (str.indexOf(".") > 0)
      paramString = str.replaceAll("0+?$", "").replaceAll("[.]$", ""); 
    return paramString;
  }
  
  public static String b(String paramString, Locale paramLocale, boolean paramBoolean) {
    boolean bool = e(paramString);
    String str1 = "";
    String str2 = str1;
    if (!bool) {
      StringBuilder stringBuilder1;
      int i = BluedPreferences.aD();
      if (i != 1) {
        if (i != 2)
          return ""; 
        i = (int)Math.round(a(paramString, 0) * 2.2D);
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(i);
        stringBuilder1.append(" lbs");
        return stringBuilder1.toString();
      } 
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append((String)stringBuilder1);
      if (paramBoolean)
        str1 = " kg"; 
      stringBuilder2.append(str1);
      str2 = stringBuilder2.toString();
    } 
    return str2;
  }
  
  public static boolean b(CharSequence paramCharSequence) {
    return a.matcher(paramCharSequence).find();
  }
  
  public static int c(String paramString) {
    if (e(paramString))
      return 0; 
    if (!Pattern.compile("[0-9]*").matcher(paramString).matches())
      return 0; 
    try {
      return Integer.parseInt(paramString);
    } catch (NumberFormatException numberFormatException) {
      return 0;
    } 
  }
  
  public static String c(String paramString1, String paramString2) {
    if (TextUtils.isEmpty(paramString2))
      return String.format("@%s", new Object[] { paramString1 }); 
    String str = EncryptTool.b(paramString2);
    if (!paramString2.equals("000000"))
      paramString2 = str; 
    return String.format("@(name:%s,id:%s)", new Object[] { paramString1, paramString2 });
  }
  
  public static String d(String paramString1, String paramString2) {
    return String.format("(name:%s,id:%s)", new Object[] { paramString1, EncryptTool.b(paramString2) });
  }
  
  public static boolean d(String paramString) {
    Pattern pattern = Pattern.compile("[0-9]*");
    return (!TextUtils.isEmpty(paramString.trim()) && pattern.matcher(paramString).matches());
  }
  
  public static boolean e(String paramString) {
    return (paramString == null || "".equals(paramString.trim()) || "null".equals(paramString) || " ".equals(paramString));
  }
  
  public static String f(String paramString) {
    if (!e(paramString)) {
      String[] arrayOfString1 = AppInfo.d().getResources().getStringArray(2130903108);
      String[] arrayOfString2 = AppInfo.d().getResources().getStringArray(2130903107);
      for (int i = 0; i < arrayOfString2.length; i++) {
        if (arrayOfString2[i].equals(paramString))
          return arrayOfString1[i]; 
      } 
      return "~";
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(AppInfo.d().getResources().getString(2131758638));
    stringBuilder.append("");
    return stringBuilder.toString();
  }
  
  public static String g(String paramString) {
    if (!e(paramString)) {
      String[] arrayOfString1 = AppInfo.d().getResources().getStringArray(2130903108);
      String[] arrayOfString2 = AppInfo.d().getResources().getStringArray(2130903107);
      for (int i = 0; i < arrayOfString1.length; i++) {
        if (arrayOfString1[i].equals(paramString))
          return arrayOfString2[i]; 
      } 
    } 
    return "-1";
  }
  
  public static boolean h(String paramString) {
    return (TextUtils.isEmpty(paramString) || "0".equals(paramString));
  }
  
  public static boolean i(String paramString) {
    return TextUtils.isEmpty(paramString) ? false : b.matcher(paramString).find();
  }
  
  public static int j(String paramString) {
    int j = 0;
    int i = 0;
    while (j < paramString.length()) {
      if (paramString.charAt(j) < '') {
        i++;
      } else {
        i += 2;
      } 
      j++;
    } 
    return i;
  }
  
  public static String k(String paramString) {
    String str = "";
    if (paramString != null)
      str = Pattern.compile("\t|\r|\n|\\s*").matcher(paramString).replaceAll(""); 
    return str;
  }
  
  static class JayceSpan extends ClickableSpan {
    public boolean a;
    
    private String b;
    
    private boolean c;
    
    JayceSpan(String param1String, boolean param1Boolean) {
      this.b = param1String;
      this.c = param1Boolean;
    }
    
    public void onClick(View param1View) {
      if (this.a)
        EventTrackMessage.a(MessageProtos.Event.BLUED_MSG_CLICK, this.b); 
      Selection.removeSelection((Spannable)((TextView)param1View).getText());
      WebViewShowInfoFragment.show(AppInfo.d(), this.b, 7);
    }
    
    public void updateDrawState(TextPaint param1TextPaint) {
      if (this.c)
        param1TextPaint.setColor(BluedSkinUtils.a(AppInfo.d(), 2131100849)); 
      param1TextPaint.setUnderlineText(true);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\StringUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */