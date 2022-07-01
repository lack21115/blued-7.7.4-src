package com.blued.android.module.common.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.CenterAlignImageSpan;
import com.blued.android.module.res_china.R;
import java.text.DecimalFormat;
import java.util.regex.Pattern;

public class CommonStringUtils {
  private static final Pattern a = Pattern.compile("\\s*|\t|\r|\n");
  
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
  
  public static int a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return 0; 
    try {
      return Integer.parseInt(paramString);
    } catch (Exception exception) {
      return 0;
    } 
  }
  
  public static SpannableStringBuilder a(Context paramContext, String paramString1, int paramInt, String paramString2, String paramString3) {
    return a(paramContext, paramString1, paramInt, paramString2, paramString3, true);
  }
  
  public static SpannableStringBuilder a(Context paramContext, String paramString1, int paramInt1, String paramString2, String paramString3, Bitmap paramBitmap, int paramInt2) {
    Object object;
    StringBuilder stringBuilder = new StringBuilder();
    boolean bool = TextUtils.isEmpty(paramString1);
    CenterAlignImageSpan centerAlignImageSpan = null;
    if (!bool) {
      stringBuilder.append(paramString1);
      stringBuilder.append(" ");
      ShapeTextView shapeTextView = new ShapeTextView(paramContext);
      ShapeHelper.b((ShapeHelper.ShapeView)shapeTextView, paramInt1);
      ShapeHelper.a((ShapeHelper.ShapeView)shapeTextView, R.color.syc_dark_b);
      shapeTextView.setTextSize(10.0F);
      shapeTextView.setPadding(DensityUtils.a(paramContext, 4.0F), DensityUtils.a(paramContext, 1.0F), DensityUtils.a(paramContext, 4.0F), DensityUtils.a(paramContext, 1.0F));
      shapeTextView.setText(paramString1);
      shapeTextView.setDrawingCacheEnabled(true);
      shapeTextView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      ShapeHelper.a((ShapeHelper.ShapeView)shapeTextView, shapeTextView.getMeasuredHeight());
      shapeTextView.layout(0, 0, shapeTextView.getMeasuredWidth(), shapeTextView.getMeasuredHeight());
      object = new CenterAlignImageSpan(paramContext, shapeTextView.getDrawingCache());
    } else {
      stringBuilder.append("");
      object = null;
    } 
    if (paramBitmap != null)
      centerAlignImageSpan = new CenterAlignImageSpan(paramContext, paramBitmap); 
    if (!TextUtils.isEmpty(paramString2)) {
      stringBuilder.append(paramString2);
      stringBuilder.append(": ");
    } 
    if (!TextUtils.isEmpty(paramString3))
      stringBuilder.append(paramString3); 
    if (centerAlignImageSpan != null)
      stringBuilder.append("gift"); 
    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(stringBuilder.toString());
    if (object != null)
      spannableStringBuilder.setSpan(object, 0, paramString1.length(), 33); 
    if (centerAlignImageSpan != null)
      spannableStringBuilder.setSpan(centerAlignImageSpan, stringBuilder.length() - 4, stringBuilder.length(), 33); 
    if (paramInt2 > 1) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(" x");
      stringBuilder1.append(paramInt2);
      String str = stringBuilder1.toString();
      SpannableStringBuilder spannableStringBuilder1 = new SpannableStringBuilder(str);
      spannableStringBuilder1.setSpan(new RelativeSizeSpan(0.8F), 1, 2, 33);
      spannableStringBuilder1.setSpan(new ForegroundColorSpan(Color.parseColor("#00E0AB")), 0, str.length(), 33);
      spannableStringBuilder.append((CharSequence)spannableStringBuilder1);
    } 
    return spannableStringBuilder;
  }
  
  public static SpannableStringBuilder a(Context paramContext, String paramString1, int paramInt, String paramString2, String paramString3, boolean paramBoolean) {
    StringBuilder stringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(paramString1)) {
      stringBuilder.append(paramString1);
      stringBuilder.append(" ");
      ShapeTextView shapeTextView = new ShapeTextView(paramContext);
      ShapeHelper.b((ShapeHelper.ShapeView)shapeTextView, paramInt);
      ShapeHelper.a((ShapeHelper.ShapeView)shapeTextView, R.color.syc_dark_b);
      shapeTextView.setTextSize(10.0F);
      shapeTextView.setPadding(DensityUtils.a(paramContext, 4.0F), DensityUtils.a(paramContext, 1.0F), DensityUtils.a(paramContext, 4.0F), DensityUtils.a(paramContext, 1.0F));
      shapeTextView.setText(paramString1);
      shapeTextView.setDrawingCacheEnabled(true);
      shapeTextView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      ShapeHelper.a((ShapeHelper.ShapeView)shapeTextView, shapeTextView.getMeasuredHeight());
      shapeTextView.layout(0, 0, shapeTextView.getMeasuredWidth(), shapeTextView.getMeasuredHeight());
      CenterAlignImageSpan centerAlignImageSpan = new CenterAlignImageSpan(paramContext, shapeTextView.getDrawingCache());
    } else {
      stringBuilder.append("");
      paramContext = null;
    } 
    if (!TextUtils.isEmpty(paramString2)) {
      stringBuilder.append(paramString2);
      if (paramBoolean)
        stringBuilder.append(":"); 
      stringBuilder.append(" ");
    } 
    if (!TextUtils.isEmpty(paramString3))
      stringBuilder.append(paramString3); 
    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(stringBuilder.toString());
    if (paramContext != null)
      spannableStringBuilder.setSpan(paramContext, 0, paramString1.length(), 33); 
    return spannableStringBuilder;
  }
  
  public static String a(double paramDouble) {
    return d(String.valueOf(paramDouble));
  }
  
  public static String a(long paramLong) {
    return d(String.valueOf(paramLong));
  }
  
  public static String a(String paramString1, String paramString2) {
    return TextUtils.isEmpty(paramString2) ? String.format("@%s", new Object[] { paramString1 }) : String.format("@(name:%s,id:%s)", new Object[] { paramString1, EncryptTool.b(paramString2) });
  }
  
  public static float b(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return 0.0F; 
    try {
      return Float.parseFloat(paramString);
    } catch (Exception exception) {
      exception.printStackTrace();
      return 0.0F;
    } 
  }
  
  public static long c(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return 0L; 
    try {
      return Long.parseLong(paramString);
    } catch (Exception exception) {
      exception.printStackTrace();
      return 0L;
    } 
  }
  
  public static String d(String paramString) {
    double d;
    DecimalFormat decimalFormat;
    if (TextUtils.isEmpty(paramString))
      return "0"; 
    if (paramString.indexOf(".") > 0) {
      int i = paramString.length() - paramString.indexOf(".") - 1;
      if (i == 0) {
        decimalFormat = new DecimalFormat("###,##0");
      } else if (i == 1) {
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
  
  public static int e(String paramString) {
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
  
  public static String f(String paramString) {
    String str = "";
    if (paramString != null)
      str = a.matcher(paramString).replaceAll(""); 
    return str;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\commo\\utils\CommonStringUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */