package org.chromium.content.browser.input;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import org.chromium.content.R;

final class SuggestionsPopupWindow$SuggestionAdapter extends BaseAdapter {
  private LayoutInflater mInflater = (LayoutInflater)SuggestionsPopupWindow.access$100(SuggestionsPopupWindow.this).getSystemService("layout_inflater");
  
  private SuggestionsPopupWindow$SuggestionAdapter() {}
  
  public final int getCount() {
    return SuggestionsPopupWindow.access$200(SuggestionsPopupWindow.this);
  }
  
  public final Object getItem(int paramInt) {
    return SuggestionsPopupWindow.this.getSuggestionItem(paramInt);
  }
  
  public final long getItemId(int paramInt) {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    TextView textView2 = (TextView)paramView;
    TextView textView1 = textView2;
    if (textView2 == null)
      textView1 = (TextView)this.mInflater.inflate(R.layout.text_edit_suggestion_item, paramViewGroup, false); 
    textView1.setText((CharSequence)SuggestionsPopupWindow.this.getSuggestionText(paramInt));
    return (View)textView1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\input\SuggestionsPopupWindow$SuggestionAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */