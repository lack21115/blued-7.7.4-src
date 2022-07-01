package org.chromium.content.browser.picker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;
import org.chromium.content.R;

final class DateTimeSuggestionListAdapter extends ArrayAdapter {
  private final Context mContext;
  
  DateTimeSuggestionListAdapter(Context paramContext, List paramList) {
    super(paramContext, R.layout.date_time_suggestion, paramList);
    this.mContext = paramContext;
  }
  
  public final int getCount() {
    return super.getCount() + 1;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    View view = paramView;
    if (paramView == null)
      view = LayoutInflater.from(this.mContext).inflate(R.layout.date_time_suggestion, paramViewGroup, false); 
    TextView textView1 = (TextView)view.findViewById(R.id.date_time_suggestion_value);
    TextView textView2 = (TextView)view.findViewById(R.id.date_time_suggestion_label);
    if (paramInt == getCount() - 1) {
      textView1.setText(this.mContext.getText(R.string.date_picker_dialog_other_button_label));
      textView2.setText("");
      return view;
    } 
    textView1.setText(((DateTimeSuggestion)getItem(paramInt)).mLocalizedValue);
    textView2.setText(((DateTimeSuggestion)getItem(paramInt)).mLabel);
    return view;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\picker\DateTimeSuggestionListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */