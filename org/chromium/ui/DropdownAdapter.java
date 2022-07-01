package org.chromium.ui;

import android.content.Context;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.content.res.AppCompatResources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;
import java.util.Set;
import org.chromium.base.ApiCompatibilityUtils;

public final class DropdownAdapter extends ArrayAdapter {
  private final boolean mAreAllItemsEnabled;
  
  private final Context mContext;
  
  private final int mLabelMargin;
  
  private final Set mSeparators;
  
  public DropdownAdapter(Context paramContext, List paramList, Set paramSet) {
    super(paramContext, R$layout.dropdown_item);
    this.mContext = paramContext;
    addAll(paramList);
    this.mSeparators = paramSet;
    this.mAreAllItemsEnabled = checkAreAllItemsEnabled();
    this.mLabelMargin = paramContext.getResources().getDimensionPixelSize(R$dimen.dropdown_item_label_margin);
  }
  
  private boolean checkAreAllItemsEnabled() {
    for (int i = 0; i < getCount(); i++) {
      DropdownItem dropdownItem = (DropdownItem)getItem(i);
      if (dropdownItem.isEnabled() && !dropdownItem.isGroupHeader())
        return false; 
    } 
    return true;
  }
  
  public final boolean areAllItemsEnabled() {
    return this.mAreAllItemsEnabled;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    View view = paramView;
    if (paramView == null) {
      view = ((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(R$layout.dropdown_item, null);
      view.setBackground(new DropdownDividerDrawable(null));
    } 
    DropdownDividerDrawable dropdownDividerDrawable = (DropdownDividerDrawable)view.getBackground();
    int i = this.mContext.getResources().getDimensionPixelSize(R$dimen.dropdown_item_height);
    if (paramInt == 0) {
      dropdownDividerDrawable.setDividerColor(0);
    } else {
      int k = this.mContext.getResources().getDimensionPixelSize(R$dimen.dropdown_item_divider_height);
      int j = i + k;
      dropdownDividerDrawable.mDividerRect.set(0, 0, dropdownDividerDrawable.mDividerRect.right, k);
      if (this.mSeparators != null && this.mSeparators.contains(Integer.valueOf(paramInt))) {
        i = ApiCompatibilityUtils.getColor(this.mContext.getResources(), R$color.dropdown_dark_divider_color);
      } else {
        i = ApiCompatibilityUtils.getColor(this.mContext.getResources(), R$color.dropdown_divider_color);
      } 
      dropdownDividerDrawable.setDividerColor(i);
      i = j;
    } 
    DropdownItem dropdownItem = (DropdownItem)getItem(paramInt);
    LinearLayout linearLayout = (LinearLayout)view.findViewById(R$id.dropdown_label_wrapper);
    boolean bool = dropdownItem.isMultilineLabel();
    paramInt = -2;
    if (bool)
      i = -2; 
    linearLayout.setOrientation(1);
    linearLayout.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(0, i, 1.0F));
    TextView textView = (TextView)view.findViewById(R$id.dropdown_label);
    textView.setText(dropdownItem.getLabel());
    textView.setSingleLine(dropdownItem.isMultilineLabel() ^ true);
    if (dropdownItem.isMultilineLabel()) {
      i = ViewCompat.getPaddingStart((View)textView);
      int j = ViewCompat.getPaddingEnd((View)textView);
      ViewCompat.setPaddingRelative((View)textView, i, this.mLabelMargin, j, this.mLabelMargin);
    } 
    textView.setEnabled(dropdownItem.isEnabled());
    if (dropdownItem.isGroupHeader() || dropdownItem.isBoldLabel()) {
      textView.setTypeface(null, 1);
    } else {
      textView.setTypeface(null, 0);
    } 
    textView.setTextColor(ApiCompatibilityUtils.getColor(this.mContext.getResources(), dropdownItem.getLabelFontColorResId()));
    textView.setTextSize(0, this.mContext.getResources().getDimension(R$dimen.text_size_large));
    textView = (TextView)view.findViewById(R$id.dropdown_sublabel);
    String str = dropdownItem.getSublabel();
    if (TextUtils.isEmpty(str)) {
      textView.setVisibility(8);
    } else {
      textView.setText(str);
      textView.setTextSize(0, this.mContext.getResources().getDimension(dropdownItem.getSublabelFontSizeResId()));
      textView.setVisibility(0);
    } 
    ImageView imageView1 = (ImageView)view.findViewById(R$id.start_dropdown_icon);
    ImageView imageView2 = (ImageView)view.findViewById(R$id.end_dropdown_icon);
    if (dropdownItem.isIconAtStart()) {
      imageView2.setVisibility(8);
    } else {
      imageView1.setVisibility(8);
    } 
    if (!dropdownItem.isIconAtStart())
      imageView1 = imageView2; 
    if (dropdownItem.getIconId() == 0) {
      imageView1.setVisibility(8);
      return view;
    } 
    i = dropdownItem.getIconSizeResId();
    if (i != 0)
      paramInt = this.mContext.getResources().getDimensionPixelSize(i); 
    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)imageView1.getLayoutParams();
    marginLayoutParams.width = paramInt;
    marginLayoutParams.height = paramInt;
    paramInt = this.mContext.getResources().getDimensionPixelSize(dropdownItem.getIconMarginResId());
    MarginLayoutParamsCompat.setMarginStart(marginLayoutParams, paramInt);
    MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, paramInt);
    imageView1.setLayoutParams((ViewGroup.LayoutParams)marginLayoutParams);
    imageView1.setImageDrawable(AppCompatResources.getDrawable(this.mContext, dropdownItem.getIconId()));
    imageView1.setVisibility(0);
    return view;
  }
  
  public final boolean isEnabled(int paramInt) {
    if (paramInt >= 0) {
      if (paramInt >= getCount())
        return false; 
      DropdownItem dropdownItem = (DropdownItem)getItem(paramInt);
      return (dropdownItem.isEnabled() && !dropdownItem.isGroupHeader());
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\DropdownAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */