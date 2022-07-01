package com.blued.android.framework.view.wheel.widget.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public abstract class AbstractWheelTextAdapter extends AbstractWheelAdapter {
  protected Context a;
  
  protected LayoutInflater b;
  
  protected int c;
  
  protected int d;
  
  protected int e;
  
  private int f;
  
  private View a(int paramInt, ViewGroup paramViewGroup) {
    return (View)((paramInt != -1) ? ((paramInt != 0) ? this.b.inflate(paramInt, paramViewGroup, false) : null) : new TextView(this.a));
  }
  
  private TextView a(View paramView, int paramInt) {
    if (paramInt == 0)
      try {
        return (paramView instanceof TextView) ? (TextView)paramView : ((paramInt != 0) ? (TextView)paramView.findViewById(paramInt) : null);
      } catch (ClassCastException classCastException) {
        Log.e("AbstractWheelAdapter", "You must supply a resource ID for a TextView");
        throw new IllegalStateException("AbstractWheelAdapter requires the resource ID to be a TextView", classCastException);
      }  
    return (paramInt != 0) ? (TextView)classCastException.findViewById(paramInt) : null;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup) {
    if (paramInt >= 0 && paramInt < a()) {
      View view = paramView;
      if (paramView == null)
        view = a(this.c, paramViewGroup); 
      TextView textView = a(view, this.d);
      textView.setTextSize(this.f);
      textView.setGravity(17);
      textView.setLines(2);
      if (textView != null) {
        CharSequence charSequence2 = a(paramInt);
        CharSequence charSequence1 = charSequence2;
        if (charSequence2 == null)
          charSequence1 = ""; 
        textView.setText(charSequence1);
        if (this.c == -1)
          a(textView); 
      } 
      return view;
    } 
    return null;
  }
  
  public View a(View paramView, ViewGroup paramViewGroup) {
    View view = paramView;
    if (paramView == null)
      view = a(this.e, paramViewGroup); 
    if (this.e == -1 && view instanceof TextView)
      a((TextView)view); 
    return view;
  }
  
  protected abstract CharSequence a(int paramInt);
  
  protected void a(TextView paramTextView) {
    paramTextView.setGravity(17);
    paramTextView.setTextSize(this.f);
    paramTextView.setLines(2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\wheel\widget\adapters\AbstractWheelTextAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */