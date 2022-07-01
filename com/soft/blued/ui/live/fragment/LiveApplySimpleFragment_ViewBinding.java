package com.soft.blued.ui.live.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.soft.blued.customview.CommonTopTitleNoTrans;

public class LiveApplySimpleFragment_ViewBinding implements Unbinder {
  private LiveApplySimpleFragment b;
  
  public LiveApplySimpleFragment_ViewBinding(LiveApplySimpleFragment paramLiveApplySimpleFragment, View paramView) {
    this.b = paramLiveApplySimpleFragment;
    paramLiveApplySimpleFragment.top_title = (CommonTopTitleNoTrans)Utils.a(paramView, 2131300300, "field 'top_title'", CommonTopTitleNoTrans.class);
    paramLiveApplySimpleFragment.ll_main = Utils.a(paramView, 2131298932, "field 'll_main'");
    paramLiveApplySimpleFragment.fl_error_page = Utils.a(paramView, 2131297106, "field 'fl_error_page'");
    paramLiveApplySimpleFragment.tv_reload = Utils.a(paramView, 2131301252, "field 'tv_reload'");
    paramLiveApplySimpleFragment.live_agree = (TextView)Utils.a(paramView, 2131298159, "field 'live_agree'", TextView.class);
    paramLiveApplySimpleFragment.live_clause = (ImageView)Utils.a(paramView, 2131298220, "field 'live_clause'", ImageView.class);
    paramLiveApplySimpleFragment.tv_other = (TextView)Utils.a(paramView, 2131301149, "field 'tv_other'", TextView.class);
    paramLiveApplySimpleFragment.tv_id = (EditText)Utils.a(paramView, 2131300908, "field 'tv_id'", EditText.class);
    paramLiveApplySimpleFragment.tv_name = (EditText)Utils.a(paramView, 2131301088, "field 'tv_name'", EditText.class);
    paramLiveApplySimpleFragment.tv_identify = (TextView)Utils.a(paramView, 2131300910, "field 'tv_identify'", TextView.class);
    paramLiveApplySimpleFragment.tv_binding_cellphone_status = (TextView)Utils.a(paramView, 2131300562, "field 'tv_binding_cellphone_status'", TextView.class);
    paramLiveApplySimpleFragment.tv_binding_cellphone = (TextView)Utils.a(paramView, 2131300561, "field 'tv_binding_cellphone'", TextView.class);
    paramLiveApplySimpleFragment.iv_phone_binded = (ImageView)Utils.a(paramView, 2131297889, "field 'iv_phone_binded'", ImageView.class);
    paramLiveApplySimpleFragment.header_view = (ImageView)Utils.a(paramView, 2131297362, "field 'header_view'", ImageView.class);
    paramLiveApplySimpleFragment.img_verify = (ImageView)Utils.a(paramView, 2131297575, "field 'img_verify'", ImageView.class);
    paramLiveApplySimpleFragment.tv_tip_one = (TextView)Utils.a(paramView, 2131301400, "field 'tv_tip_one'", TextView.class);
    paramLiveApplySimpleFragment.tv_tip_two = (TextView)Utils.a(paramView, 2131301401, "field 'tv_tip_two'", TextView.class);
  }
  
  public void unbind() {
    LiveApplySimpleFragment liveApplySimpleFragment = this.b;
    if (liveApplySimpleFragment != null) {
      this.b = null;
      liveApplySimpleFragment.top_title = null;
      liveApplySimpleFragment.ll_main = null;
      liveApplySimpleFragment.fl_error_page = null;
      liveApplySimpleFragment.tv_reload = null;
      liveApplySimpleFragment.live_agree = null;
      liveApplySimpleFragment.live_clause = null;
      liveApplySimpleFragment.tv_other = null;
      liveApplySimpleFragment.tv_id = null;
      liveApplySimpleFragment.tv_name = null;
      liveApplySimpleFragment.tv_identify = null;
      liveApplySimpleFragment.tv_binding_cellphone_status = null;
      liveApplySimpleFragment.tv_binding_cellphone = null;
      liveApplySimpleFragment.iv_phone_binded = null;
      liveApplySimpleFragment.header_view = null;
      liveApplySimpleFragment.img_verify = null;
      liveApplySimpleFragment.tv_tip_one = null;
      liveApplySimpleFragment.tv_tip_two = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\fragment\LiveApplySimpleFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */