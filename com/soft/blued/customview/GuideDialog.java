package com.soft.blued.customview;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.view.View;
import com.soft.blued.utils.BluedPreferences;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class GuideDialog extends Dialog {
  public static void a(String paramString) {
    SharedPreferences.Editor editor = BluedPreferences.b().edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(GuideDialog.class.getName());
    stringBuilder.append(paramString);
    editor.putBoolean(stringBuilder.toString(), true).commit();
  }
  
  public static interface GUIDE_KEY {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface GuideKeyDef {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\GuideDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */