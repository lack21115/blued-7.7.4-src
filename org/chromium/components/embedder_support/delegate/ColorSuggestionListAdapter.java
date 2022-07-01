package org.chromium.components.embedder_support.delegate;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

public final class ColorSuggestionListAdapter extends BaseAdapter implements View.OnClickListener {
  private Context mContext;
  
  ColorSuggestionListAdapter$OnColorSuggestionClickListener mListener;
  
  private ColorSuggestion[] mSuggestions;
  
  ColorSuggestionListAdapter(Context paramContext, ColorSuggestion[] paramArrayOfColorSuggestion) {
    this.mContext = paramContext;
    this.mSuggestions = paramArrayOfColorSuggestion;
  }
  
  public final int getCount() {
    return (this.mSuggestions.length + 4 - 1) / 4;
  }
  
  public final Object getItem(int paramInt) {
    return null;
  }
  
  public final long getItemId(int paramInt) {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    View view;
    if (paramView instanceof LinearLayout) {
      LinearLayout linearLayout = (LinearLayout)paramView;
    } else {
      LinearLayout linearLayout = new LinearLayout(this.mContext);
      linearLayout.setLayoutParams((ViewGroup.LayoutParams)new AbsListView.LayoutParams(-1, -2));
      linearLayout.setOrientation(0);
      linearLayout.setBackgroundColor(-1);
      int k = this.mContext.getResources().getDimensionPixelOffset(R$dimen.color_button_height);
      int j = 0;
      while (true) {
        LinearLayout linearLayout1 = linearLayout;
        if (j < 4) {
          view = new View(this.mContext);
          LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, k, 1.0F);
          MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams)layoutParams, -1);
          if (j == 3)
            MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams)layoutParams, -1); 
          view.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
          view.setBackgroundResource(R$drawable.color_button_background);
          linearLayout.addView(view);
          j++;
          continue;
        } 
        break;
      } 
    } 
    int i;
    for (i = 0; i < 4; i++) {
      View view1 = view.getChildAt(i);
      int j = (paramInt << 2) + i;
      if (j >= this.mSuggestions.length) {
        view1.setTag(null);
        view1.setContentDescription(null);
        view1.setVisibility(4);
      } else {
        view1.setTag(this.mSuggestions[j]);
        view1.setVisibility(0);
        ColorSuggestion colorSuggestion = this.mSuggestions[j];
        ((GradientDrawable)((LayerDrawable)view1.getBackground()).findDrawableByLayerId(R$id.color_button_swatch)).setColor(colorSuggestion.mColor);
        String str2 = colorSuggestion.mLabel;
        String str1 = str2;
        if (TextUtils.isEmpty(str2))
          str1 = String.format("#%06X", new Object[] { Integer.valueOf(colorSuggestion.mColor & 0xFFFFFF) }); 
        view1.setContentDescription(str1);
        view1.setOnClickListener(this);
      } 
    } 
    return view;
  }
  
  public final void onClick(View paramView) {
    if (this.mListener == null)
      return; 
    ColorSuggestion colorSuggestion = (ColorSuggestion)paramView.getTag();
    if (colorSuggestion == null)
      return; 
    this.mListener.onColorSuggestionClick(colorSuggestion);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\components\embedder_support\delegate\ColorSuggestionListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */