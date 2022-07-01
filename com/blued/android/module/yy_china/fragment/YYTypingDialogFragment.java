package com.blued.android.module.yy_china.fragment;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.listener.ISendMsgListener;
import com.blued.android.module.yy_china.view.YYTypingView;

public class YYTypingDialogFragment extends BaseDialogFragment {
  private YYTypingView a;
  
  private View b;
  
  private String c;
  
  private String d;
  
  private void a(View paramView) {
    this.a = (YYTypingView)paramView.findViewById(R.id.ll_input_view);
    this.b = paramView.findViewById(R.id.conver_view);
    this.a.a(f(), this.c, this.d);
    this.b.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            KeyboardUtils.a((Activity)this.a.getActivity());
            this.a.dismiss();
          }
        });
    this.a.setListener(new ISendMsgListener(this) {
          public void a() {
            KeyboardUtils.a((Activity)this.a.getActivity());
            this.a.dismiss();
          }
        });
  }
  
  private BaseYYStudioFragment f() {
    return (BaseYYStudioFragment)getParentFragment();
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setStyle(0, 16973946);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = paramLayoutInflater.inflate(R.layout.fragment_yy_typing_layout, null);
    getDialog().getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
    getDialog().getWindow().setSoftInputMode(16);
    a(view);
    return view;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\fragment\YYTypingDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */