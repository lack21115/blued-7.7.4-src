package com.soft.blued.customview.selectabletextview;

import android.text.Spannable;
import android.widget.TextView;

public class SelectionInfo {
  public String a;
  
  private int b;
  
  private int c;
  
  public int a(Spannable paramSpannable) {
    if (paramSpannable == null)
      return 0; 
    if (this.b > paramSpannable.length())
      return paramSpannable.length(); 
    int i = this.b;
    return (i < 0) ? 0 : i;
  }
  
  public int a(TextView paramTextView) {
    if (paramTextView == null)
      return 0; 
    if (this.b > paramTextView.length())
      return paramTextView.length(); 
    int i = this.b;
    return (i < 0) ? 0 : i;
  }
  
  public void a(int paramInt) {
    this.b = paramInt;
  }
  
  public int b(Spannable paramSpannable) {
    if (paramSpannable == null)
      return 0; 
    if (this.c > paramSpannable.length())
      return paramSpannable.length(); 
    int i = this.c;
    return (i < 0) ? 0 : i;
  }
  
  public int b(TextView paramTextView) {
    if (paramTextView == null)
      return 0; 
    if (this.c > paramTextView.length())
      return paramTextView.length(); 
    int i = this.c;
    return (i < 0) ? 0 : i;
  }
  
  public void b(int paramInt) {
    this.c = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\selectabletextview\SelectionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */