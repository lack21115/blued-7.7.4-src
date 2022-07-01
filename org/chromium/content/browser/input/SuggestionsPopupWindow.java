package org.chromium.content.browser.input;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.SpannableString;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import org.chromium.base.ApiCompatibilityUtils;
import org.chromium.content.R;
import org.chromium.ui.UiUtils;
import org.chromium.ui.base.WindowAndroid;

public abstract class SuggestionsPopupWindow implements View.OnClickListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {
  private Activity mActivity;
  
  private TextView mAddToDictionaryButton;
  
  private LinearLayout mContentView;
  
  private final Context mContext;
  
  private TextView mDeleteButton;
  
  private boolean mDismissedByItemTap;
  
  private DisplayMetrics mDisplayMetrics;
  
  private View mDivider;
  
  private String mHighlightedText;
  
  private LinearLayout mListFooter;
  
  private int mNumberOfSuggestionsToUse;
  
  private final View mParentView;
  
  private int mPopupVerticalMargin;
  
  PopupWindow mPopupWindow;
  
  private ListView mSuggestionListView;
  
  protected final TextSuggestionHost mTextSuggestionHost;
  
  WindowAndroid mWindowAndroid;
  
  public SuggestionsPopupWindow(Context paramContext, TextSuggestionHost paramTextSuggestionHost, WindowAndroid paramWindowAndroid, View paramView) {
    this.mContext = paramContext;
    this.mTextSuggestionHost = paramTextSuggestionHost;
    this.mWindowAndroid = paramWindowAndroid;
    this.mParentView = paramView;
    this.mPopupWindow = new PopupWindow();
    this.mPopupWindow.setWidth(-2);
    this.mPopupWindow.setHeight(-2);
    if (Build.VERSION.SDK_INT >= 21) {
      this.mPopupWindow.setBackgroundDrawable(ApiCompatibilityUtils.getDrawable(this.mContext.getResources(), R.drawable.floating_popup_background_light));
      this.mPopupWindow.setElevation(this.mContext.getResources().getDimensionPixelSize(R.dimen.text_suggestion_popup_elevation));
    } else {
      this.mPopupWindow.setBackgroundDrawable((Drawable)new ColorDrawable(0));
    } 
    this.mPopupWindow.setInputMethodMode(2);
    this.mPopupWindow.setFocusable(true);
    this.mPopupWindow.setClippingEnabled(false);
    this.mPopupWindow.setOnDismissListener(this);
    LayoutInflater layoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    this.mContentView = (LinearLayout)layoutInflater.inflate(R.layout.text_edit_suggestion_container, null);
    if (Build.VERSION.SDK_INT < 21)
      this.mContentView.setBackground(ApiCompatibilityUtils.getDrawable(this.mContext.getResources(), R.drawable.dropdown_popup_background)); 
    this.mPopupVerticalMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.text_suggestion_popup_vertical_margin);
    this.mSuggestionListView = (ListView)this.mContentView.findViewById(R.id.suggestionContainer);
    this.mSuggestionListView.setDivider(null);
    this.mListFooter = (LinearLayout)layoutInflater.inflate(R.layout.text_edit_suggestion_list_footer, null);
    this.mSuggestionListView.addFooterView((View)this.mListFooter, null, false);
    this.mSuggestionListView.setAdapter((ListAdapter)new SuggestionsPopupWindow$SuggestionAdapter(this, (byte)0));
    this.mSuggestionListView.setOnItemClickListener(this);
    this.mDivider = this.mContentView.findViewById(R.id.divider);
    this.mAddToDictionaryButton = (TextView)this.mContentView.findViewById(R.id.addToDictionaryButton);
    this.mAddToDictionaryButton.setOnClickListener(this);
    this.mDeleteButton = (TextView)this.mContentView.findViewById(R.id.deleteButton);
    this.mDeleteButton.setOnClickListener(this);
    this.mPopupWindow.setContentView((View)this.mContentView);
  }
  
  protected abstract void applySuggestion(int paramInt);
  
  protected abstract Object getSuggestionItem(int paramInt);
  
  protected abstract SpannableString getSuggestionText(int paramInt);
  
  protected abstract int getSuggestionsCount();
  
  public void onClick(View paramView) {
    TextSuggestionHost textSuggestionHost;
    if (paramView == this.mAddToDictionaryButton) {
      Intent intent = new Intent("com.android.settings.USER_DICTIONARY_INSERT");
      String str2 = this.mHighlightedText;
      String str1 = str2;
      if (Build.VERSION.SDK_INT < 19) {
        str1 = str2;
        if (str2.length() > 48)
          str1 = str2.substring(0, 48); 
      } 
      intent.putExtra("word", str1);
      intent.setFlags(intent.getFlags() | 0x10000000);
      this.mContext.startActivity(intent);
      textSuggestionHost = this.mTextSuggestionHost;
      str2 = this.mHighlightedText;
      textSuggestionHost.nativeOnNewWordAddedToDictionary(textSuggestionHost.mNativeTextSuggestionHost, str2);
      this.mDismissedByItemTap = true;
      this.mPopupWindow.dismiss();
      return;
    } 
    if (textSuggestionHost == this.mDeleteButton) {
      textSuggestionHost = this.mTextSuggestionHost;
      textSuggestionHost.nativeDeleteActiveSuggestionRange(textSuggestionHost.mNativeTextSuggestionHost);
      this.mDismissedByItemTap = true;
      this.mPopupWindow.dismiss();
    } 
  }
  
  public void onDismiss() {
    this.mTextSuggestionHost.onSuggestionMenuClosed(this.mDismissedByItemTap);
    this.mDismissedByItemTap = false;
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong) {
    if (paramInt >= this.mNumberOfSuggestionsToUse)
      return; 
    applySuggestion(paramInt);
    this.mDismissedByItemTap = true;
    this.mPopupWindow.dismiss();
  }
  
  protected final void setAddToDictionaryEnabled(boolean paramBoolean) {
    byte b;
    TextView textView = this.mAddToDictionaryButton;
    if (paramBoolean) {
      b = 0;
    } else {
      b = 8;
    } 
    textView.setVisibility(b);
  }
  
  protected final void show(double paramDouble1, double paramDouble2, String paramString) {
    this.mNumberOfSuggestionsToUse = getSuggestionsCount();
    this.mHighlightedText = paramString;
    this.mActivity = this.mWindowAndroid.getActivity().get();
    if (this.mActivity != null) {
      this.mDisplayMetrics = this.mActivity.getResources().getDisplayMetrics();
    } else {
      this.mDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
    } 
    if (this.mActivity != null && !ApiCompatibilityUtils.isInMultiWindowMode(this.mActivity)) {
      Rect rect = new Rect();
      this.mActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
      i = rect.top;
    } else {
      i = 0;
    } 
    this.mListFooter.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    int i = this.mDisplayMetrics.heightPixels - i - this.mListFooter.getMeasuredHeight() - this.mPopupVerticalMargin * 2 - this.mContentView.getPaddingTop() - this.mContentView.getPaddingBottom();
    int j = this.mContext.getResources().getDimensionPixelSize(R.dimen.text_edit_suggestion_item_layout_height);
    if (i > 0) {
      i /= j;
    } else {
      i = 0;
    } 
    this.mNumberOfSuggestionsToUse = Math.min(this.mNumberOfSuggestionsToUse, i);
    if (this.mNumberOfSuggestionsToUse == 0) {
      this.mDivider.setVisibility(8);
    } else {
      this.mDivider.setVisibility(0);
    } 
    i = UiUtils.computeMaxWidthOfListAdapterItems(this.mSuggestionListView.getAdapter()) + this.mContentView.getPaddingLeft() + this.mContentView.getPaddingRight();
    j = View.MeasureSpec.makeMeasureSpec(this.mDisplayMetrics.heightPixels, -2147483648);
    this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), j);
    this.mPopupWindow.setWidth(i);
    int n = this.mContentView.getMeasuredWidth();
    i = this.mContentView.getMeasuredHeight();
    int i1 = (int)Math.round(paramDouble1 - (n / 2.0F));
    j = (int)Math.round(paramDouble2);
    int[] arrayOfInt = new int[2];
    this.mParentView.getLocationInWindow(arrayOfInt);
    int i2 = arrayOfInt[0];
    int k = arrayOfInt[1];
    int m = this.mContentView.getPaddingTop();
    n = Math.min(this.mDisplayMetrics.widthPixels - n + this.mContentView.getPaddingRight(), i1 + i2);
    n = Math.max(-this.mContentView.getPaddingLeft(), n);
    i = Math.min(j + k - m, this.mDisplayMetrics.heightPixels - i - this.mContentView.getPaddingTop() - this.mPopupVerticalMargin);
    this.mPopupWindow.showAtLocation(this.mParentView, 0, n, i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\input\SuggestionsPopupWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */