package com.soft.blued.ui.home.help;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.blued.android.framework.utils.DensityUtils;
import java.util.List;

public class FragmentViewContainer extends ScrollView {
  private Context a;
  
  private LinearLayout b;
  
  private int c;
  
  private int d;
  
  public FragmentViewContainer(Context paramContext) {
    super(paramContext);
    a(paramContext);
  }
  
  public FragmentViewContainer(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public FragmentViewContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private TextView a(FragmentRecord paramFragmentRecord, int paramInt) {
    TextView textView = new TextView(this.a);
    textView.setLayoutParams(new ViewGroup.LayoutParams(-1, this.c));
    if (paramInt == 0) {
      textView.setTextColor(Color.parseColor("#333333"));
      textView.setTextSize(16.0F);
    } 
    textView.setGravity(16);
    int i = this.d;
    textView.setPadding((int)(i + (paramInt * i) * 1.5D), 0, i, 0);
    textView.setCompoundDrawablePadding(this.d / 2);
    TypedArray typedArray = this.a.obtainStyledAttributes(new int[] { 16843534 });
    textView.setBackgroundDrawable(typedArray.getDrawable(0));
    typedArray.recycle();
    textView.setText(paramFragmentRecord.a);
    return textView;
  }
  
  private void a(int paramInt) {
    for (int i = this.b.getChildCount() - 1; i >= 0; i--) {
      View view = this.b.getChildAt(i);
      if (view.getTag(2131297373) != null && ((Integer)view.getTag(2131297373)).intValue() >= paramInt)
        this.b.removeView(view); 
    } 
  }
  
  private void a(Context paramContext) {
    this.a = paramContext;
    HorizontalScrollView horizontalScrollView = new HorizontalScrollView(paramContext);
    this.b = new LinearLayout(paramContext);
    this.b.setOrientation(1);
    horizontalScrollView.addView((View)this.b);
    addView((View)horizontalScrollView);
    this.c = DensityUtils.a(paramContext, 50.0F);
    this.d = DensityUtils.a(paramContext, 16.0F);
  }
  
  private void a(List<FragmentRecord> paramList, int paramInt, TextView paramTextView) {
    int i;
    for (i = paramList.size() - 1; i >= 0; i--) {
      FragmentRecord fragmentRecord = paramList.get(i);
      TextView textView = a(fragmentRecord, paramInt);
      textView.setTag(2131297373, Integer.valueOf(paramInt));
      List<FragmentRecord> list = fragmentRecord.b;
      if (list != null && list.size() > 0) {
        textView.setCompoundDrawablesWithIntrinsicBounds(2131232451, 0, 0, 0);
        textView.setOnClickListener(new View.OnClickListener(this, textView, paramInt + 1, list) {
              public void onClick(View param1View) {
                if (param1View.getTag(2131297607) != null) {
                  boolean bool = ((Boolean)param1View.getTag(2131297607)).booleanValue();
                  if (bool) {
                    this.a.setCompoundDrawablesWithIntrinsicBounds(2131232451, 0, 0, 0);
                    FragmentViewContainer.a(this.d, this.b);
                  } else {
                    FragmentViewContainer.a(this.d, this.c, this.b, this.a);
                  } 
                  param1View.setTag(2131297607, Boolean.valueOf(bool ^ true));
                  return;
                } 
                this.a.setTag(2131297607, Boolean.valueOf(true));
                FragmentViewContainer.a(this.d, this.c, this.b, this.a);
              }
            });
      } else {
        int j = textView.getPaddingLeft();
        int k = this.d;
        textView.setPadding(j + k, 0, k, 0);
      } 
      if (paramTextView == null) {
        this.b.addView((View)textView);
      } else {
        LinearLayout linearLayout = this.b;
        linearLayout.addView((View)textView, linearLayout.indexOfChild((View)paramTextView) + 1);
      } 
    } 
  }
  
  private void b(List<FragmentRecord> paramList, int paramInt, TextView paramTextView) {
    a(paramList, paramInt, paramTextView);
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(2131232538, 0, 0, 0);
  }
  
  public void a(List<FragmentRecord> paramList) {
    this.b.removeAllViews();
    if (paramList == null)
      return; 
    a(paramList, 0, (TextView)null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\home\help\FragmentViewContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */