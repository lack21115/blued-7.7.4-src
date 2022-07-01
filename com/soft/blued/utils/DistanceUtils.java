package com.soft.blued.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import com.soft.blued.ui.find.model.UserBasicModel;
import java.text.DecimalFormat;
import java.util.Locale;

public class DistanceUtils {
  public static String a(String paramString) {
    if (!TextUtils.isEmpty(paramString) && paramString.endsWith("km"))
      return paramString.substring(0, paramString.length() - 2); 
    try {
      double d = Double.valueOf(paramString).doubleValue();
      if (d >= 100.0D) {
        int i = (int)Math.floor(d);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append("");
        return stringBuilder.toString();
      } 
      return (new DecimalFormat("#0.00")).format(d);
    } catch (Exception exception) {
      exception.printStackTrace();
      return "0";
    } 
  }
  
  public static String a(String paramString, Locale paramLocale, boolean paramBoolean) {
    if (!StringUtils.e(paramString)) {
      int i = BluedPreferences.aD();
      if (i != 1) {
        if (i == 2) {
          double d = StringUtils.a(paramString, 0.0D) * 0.62D;
          paramString = " mi";
          if (d >= 1000.0D) {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append((int)Math.round(d));
            if (!paramBoolean)
              paramString = "mi"; 
            stringBuilder1.append(paramString);
            return stringBuilder1.toString();
          } 
          DecimalFormat decimalFormat = new DecimalFormat("#0.00");
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(decimalFormat.format(d));
          if (!paramBoolean)
            paramString = "mi"; 
          stringBuilder.append(paramString);
          return stringBuilder.toString();
        } 
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a(paramString));
        if (paramBoolean) {
          paramString = " km";
        } else {
          paramString = "km";
        } 
        stringBuilder.append(paramString);
        return stringBuilder.toString();
      } 
    } 
    return "";
  }
  
  public static void a(Context paramContext, TextView paramTextView, int paramInt1, int paramInt2) {
    UserBasicModel userBasicModel = new UserBasicModel();
    userBasicModel.is_hide_distance = paramInt1;
    a(paramContext, paramTextView, userBasicModel, paramInt2, 0, true);
  }
  
  public static void a(Context paramContext, TextView paramTextView, int paramInt1, int paramInt2, boolean paramBoolean) {
    UserBasicModel userBasicModel = new UserBasicModel();
    userBasicModel.is_hide_distance = paramInt1;
    a(paramContext, paramTextView, userBasicModel, paramInt2, 0, paramBoolean);
  }
  
  public static void a(Context paramContext, TextView paramTextView, UserBasicModel paramUserBasicModel, int paramInt) {
    a(paramContext, paramTextView, paramUserBasicModel, paramInt, 0, true);
  }
  
  public static void a(Context paramContext, TextView paramTextView, UserBasicModel paramUserBasicModel, int paramInt1, int paramInt2, boolean paramBoolean) {
    if (paramUserBasicModel.is_hide_distance == 1) {
      byte b1;
      byte b2 = -1;
      if (paramInt1 == 1) {
        b1 = 2131232472;
      } else {
        b1 = b2;
        if (paramInt1 == 2) {
          b1 = b2;
          if (paramTextView != null) {
            if (paramBoolean) {
              paramTextView.setText(paramContext.getResources().getString(2131756199));
              return;
            } 
            paramTextView.setVisibility(8);
            return;
          } 
        } 
      } 
      TypefaceUtils.a(paramContext, b1, paramTextView, paramInt2);
      paramTextView.setVisibility(0);
      return;
    } 
    paramTextView.setCompoundDrawables(null, null, null, null);
  }
  
  public static String b(String paramString) {
    if (!TextUtils.isEmpty(paramString) && paramString.endsWith("km"))
      return paramString.substring(0, paramString.length() - 2); 
    try {
      double d = Double.valueOf(paramString).doubleValue();
      return (d >= 100.0D) ? (new DecimalFormat("#0.00")).format(d) : (new DecimalFormat("#0.00")).format(d);
    } catch (Exception exception) {
      exception.printStackTrace();
      return "0";
    } 
  }
  
  public static String b(String paramString, Locale paramLocale, boolean paramBoolean) {
    if (!StringUtils.e(paramString)) {
      int i = BluedPreferences.aD();
      if (i != 1) {
        if (i == 2) {
          double d = StringUtils.a(paramString, 0.0D) * 0.62D;
          paramString = " mi";
          if (d >= 1000.0D) {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append((int)Math.round(d));
            if (!paramBoolean)
              paramString = "mi"; 
            stringBuilder1.append(paramString);
            return stringBuilder1.toString();
          } 
          DecimalFormat decimalFormat = new DecimalFormat("#0.00");
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(decimalFormat.format(d));
          if (!paramBoolean)
            paramString = "mi"; 
          stringBuilder.append(paramString);
          return stringBuilder.toString();
        } 
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(b(paramString));
        if (paramBoolean) {
          paramString = " km";
        } else {
          paramString = "km";
        } 
        stringBuilder.append(paramString);
        return stringBuilder.toString();
      } 
    } 
    return "";
  }
  
  public static boolean c(String paramString) {
    boolean bool = StringUtils.e(paramString);
    boolean bool2 = false;
    if (!bool) {
      boolean bool3;
      try {
        if (paramString.contains(".")) {
          bool3 = (int)Float.parseFloat(paramString);
        } else {
          bool3 = Integer.parseInt(paramString);
        } 
      } catch (Exception exception) {
        exception.printStackTrace();
        bool3 = false;
      } 
      if (bool3 == 99999)
        bool2 = true; 
      return bool2;
    } 
    boolean bool1 = false;
  }
  
  static interface HIDE_DISTANCE_DRAW_ICON_OPT {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\DistanceUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */