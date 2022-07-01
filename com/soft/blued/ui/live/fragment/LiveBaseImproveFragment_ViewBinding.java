package com.soft.blued.ui.live.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.soft.blued.customview.CommonTopTitleNoTrans;

public class LiveBaseImproveFragment_ViewBinding implements Unbinder {
  private LiveBaseImproveFragment b;
  
  public LiveBaseImproveFragment_ViewBinding(LiveBaseImproveFragment paramLiveBaseImproveFragment, View paramView) {
    this.b = paramLiveBaseImproveFragment;
    paramLiveBaseImproveFragment.ll_main = Utils.a(paramView, 2131298932, "field 'll_main'");
    paramLiveBaseImproveFragment.fl_error_page = Utils.a(paramView, 2131297106, "field 'fl_error_page'");
    paramLiveBaseImproveFragment.tv_reload = Utils.a(paramView, 2131301252, "field 'tv_reload'");
    paramLiveBaseImproveFragment.tv_start_verify = (TextView)Utils.a(paramView, 2131301354, "field 'tv_start_verify'", TextView.class);
    paramLiveBaseImproveFragment.top_title = (CommonTopTitleNoTrans)Utils.a(paramView, 2131300300, "field 'top_title'", CommonTopTitleNoTrans.class);
    paramLiveBaseImproveFragment.live_id_card_error = Utils.a(paramView, 2131298313, "field 'live_id_card_error'");
    paramLiveBaseImproveFragment.live_add_card_layout1 = Utils.a(paramView, 2131298156, "field 'live_add_card_layout1'");
    paramLiveBaseImproveFragment.live_add_card_layout2 = Utils.a(paramView, 2131298157, "field 'live_add_card_layout2'");
    paramLiveBaseImproveFragment.live_card1 = (ImageView)Utils.a(paramView, 2131298183, "field 'live_card1'", ImageView.class);
    paramLiveBaseImproveFragment.live_card2 = (ImageView)Utils.a(paramView, 2131298184, "field 'live_card2'", ImageView.class);
    paramLiveBaseImproveFragment.cover_del_btn1 = (ImageView)Utils.a(paramView, 2131296846, "field 'cover_del_btn1'", ImageView.class);
    paramLiveBaseImproveFragment.cover_del_btn2 = (ImageView)Utils.a(paramView, 2131296847, "field 'cover_del_btn2'", ImageView.class);
    paramLiveBaseImproveFragment.tv_binding_credit_card = (TextView)Utils.a(paramView, 2131300563, "field 'tv_binding_credit_card'", TextView.class);
    paramLiveBaseImproveFragment.tv_binding_credit_card_status = (TextView)Utils.a(paramView, 2131300564, "field 'tv_binding_credit_card_status'", TextView.class);
    paramLiveBaseImproveFragment.iv_card_binded = (ImageView)Utils.a(paramView, 2131297717, "field 'iv_card_binded'", ImageView.class);
    paramLiveBaseImproveFragment.ll_bottom_button = Utils.a(paramView, 2131298728, "field 'll_bottom_button'");
  }
  
  public void unbind() {
    LiveBaseImproveFragment liveBaseImproveFragment = this.b;
    if (liveBaseImproveFragment != null) {
      this.b = null;
      liveBaseImproveFragment.ll_main = null;
      liveBaseImproveFragment.fl_error_page = null;
      liveBaseImproveFragment.tv_reload = null;
      liveBaseImproveFragment.tv_start_verify = null;
      liveBaseImproveFragment.top_title = null;
      liveBaseImproveFragment.live_id_card_error = null;
      liveBaseImproveFragment.live_add_card_layout1 = null;
      liveBaseImproveFragment.live_add_card_layout2 = null;
      liveBaseImproveFragment.live_card1 = null;
      liveBaseImproveFragment.live_card2 = null;
      liveBaseImproveFragment.cover_del_btn1 = null;
      liveBaseImproveFragment.cover_del_btn2 = null;
      liveBaseImproveFragment.tv_binding_credit_card = null;
      liveBaseImproveFragment.tv_binding_credit_card_status = null;
      liveBaseImproveFragment.iv_card_binded = null;
      liveBaseImproveFragment.ll_bottom_button = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\fragment\LiveBaseImproveFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */