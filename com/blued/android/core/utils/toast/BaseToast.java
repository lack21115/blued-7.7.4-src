package com.blued.android.core.utils.toast;

import android.app.Application;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class BaseToast extends Toast {
  private TextView a;
  
  public BaseToast(Application paramApplication) {
    super((Context)paramApplication);
  }
  
  private static TextView a(View paramView) {
    if (paramView instanceof TextView)
      return (TextView)paramView; 
    if (paramView.findViewById(16908299) instanceof TextView)
      return (TextView)paramView.findViewById(16908299); 
    if (paramView instanceof ViewGroup) {
      TextView textView = a((ViewGroup)paramView);
      if (textView != null)
        return textView; 
    } 
    throw new IllegalArgumentException("The layout must contain a TextView");
  }
  
  private static TextView a(ViewGroup paramViewGroup) {
    for (int i = 0; i < paramViewGroup.getChildCount(); i++) {
      View view = paramViewGroup.getChildAt(i);
      if (view instanceof TextView)
        return (TextView)view; 
      if (view instanceof ViewGroup) {
        TextView textView = a((ViewGroup)view);
        if (textView != null)
          return textView; 
      } 
    } 
    return null;
  }
  
  public void setText(CharSequence paramCharSequence) {
    this.a.setText(paramCharSequence);
  }
  
  public void setView(View paramView) {
    super.setView(paramView);
    this.a = a(paramView);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\cor\\utils\toast\BaseToast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */