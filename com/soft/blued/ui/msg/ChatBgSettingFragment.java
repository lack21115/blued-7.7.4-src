package com.soft.blued.ui.msg;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.soft.blued.base.mvp.MVPBaseFragment;
import com.soft.blued.base.mvp.MVPBasePresent;
import com.soft.blued.customview.LabeledTextView;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.msg.contract.IChatBgSettingIView;
import com.soft.blued.ui.msg.presenter.ChatBgSettingPresent;
import com.soft.blued.view.tip.CommonAlertDialog;

public class ChatBgSettingFragment extends MVPBaseFragment<IChatBgSettingIView, ChatBgSettingPresent> implements View.OnClickListener, IChatBgSettingIView {
  private LabeledTextView m;
  
  private LabeledTextView n;
  
  private LabeledTextView o;
  
  private TextView p;
  
  private Dialog q;
  
  public static void a(Context paramContext, int paramInt) {
    Bundle bundle = new Bundle();
    bundle.putInt("from", paramInt);
    TerminalActivity.d(paramContext, ChatBgSettingFragment.class, bundle);
  }
  
  public static void a(BaseFragment paramBaseFragment, int paramInt1, int paramInt2) {
    Bundle bundle = new Bundle();
    bundle.putInt("from", paramInt1);
    TerminalActivity.a((Fragment)paramBaseFragment, ChatBgSettingFragment.class, bundle, paramInt2);
  }
  
  public static void a(BaseFragment paramBaseFragment, int paramInt1, long paramLong, short paramShort, int paramInt2) {
    Bundle bundle = new Bundle();
    bundle.putLong("passby_session_id", paramLong);
    bundle.putShort("passby_session_type", paramShort);
    bundle.putInt("from", paramInt1);
    TerminalActivity.a((Fragment)paramBaseFragment, ChatBgSettingFragment.class, bundle, paramInt2);
  }
  
  private void u() {
    Dialog dialog = this.q;
    if (dialog == null) {
      this.q = (Dialog)CommonAlertDialog.a(getContext(), getString(2131758969), null, getString(2131756086), new DialogInterface.OnClickListener(this) {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
              if (ChatBgSettingFragment.a(this.a) != null)
                ((ChatBgSettingPresent)ChatBgSettingFragment.b(this.a)).g(); 
            }
          },  null, null, null);
      return;
    } 
    dialog.show();
  }
  
  public boolean a(Bundle paramBundle) {
    return false;
  }
  
  public void b(Bundle paramBundle) {
    this.i.setCenterText(2131755591);
    this.i.a();
    this.i.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.getActivity().finish();
          }
        });
    this.m = (LabeledTextView)this.f.findViewById(2131296722);
    this.n = (LabeledTextView)this.f.findViewById(2131296723);
    this.o = (LabeledTextView)this.f.findViewById(2131296725);
    this.p = (TextView)this.f.findViewById(2131296724);
    this.m.setOnClickListener(this);
    this.n.setOnClickListener(this);
    this.o.setOnClickListener(this);
    this.p.setOnClickListener(this);
    this.p.setVisibility(8);
  }
  
  public void o() {}
  
  public void onClick(View paramView) {
    if (this.d != null) {
      switch (paramView.getId()) {
        default:
          return;
        case 2131296725:
          InstantLog.b("set_chat_bg_option_click", 2);
          ((ChatBgSettingPresent)this.d).f();
          return;
        case 2131296724:
          u();
          return;
        case 2131296723:
          InstantLog.b("set_chat_bg_option_click", 1);
          ((ChatBgSettingPresent)this.d).e();
          return;
        case 2131296722:
          break;
      } 
      InstantLog.b("set_chat_bg_option_click", 0);
      ((ChatBgSettingPresent)this.d).d();
    } 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    return a(2131493086, paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  protected ChatBgSettingPresent r() {
    return new ChatBgSettingPresent();
  }
  
  public BaseFragment s() {
    return (BaseFragment)this;
  }
  
  public void t() {
    TextView textView = this.p;
    if (textView != null)
      textView.setVisibility(0); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\ChatBgSettingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */