package com.soft.blued.ui.msg.pop;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.core.BottomPopupView;
import com.blued.android.framework.utils.DensityUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.SpacesItemDecoration;
import com.soft.blued.ui.msg.adapter.GiftVoucherAdapter;
import com.soft.blued.ui.msg.event.UpdateVoucherEvent;
import com.soft.blued.ui.msg.model.GiftVoucherModel;
import java.util.List;

public class GiftVoucherPop extends BottomPopupView {
  public static GiftVoucherPop b;
  
  public List<GiftVoucherModel> c;
  
  public double d;
  
  public GiftVoucherModel e;
  
  private CommonTopTitleNoTrans f;
  
  private GiftVoucherAdapter g = new GiftVoucherAdapter();
  
  private RecyclerView h;
  
  private boolean i;
  
  public GiftVoucherPop(Context paramContext) {
    super(paramContext);
  }
  
  private void c() {
    UpdateVoucherEvent updateVoucherEvent = new UpdateVoucherEvent();
    updateVoucherEvent.a = this.e;
    updateVoucherEvent.b = this.i;
    LiveEventBus.get("update_voucher").post(updateVoucherEvent);
    b = null;
    this.e = null;
  }
  
  public void b() {
    super.b();
    b = this;
    findViewById(2131299725).setBackgroundDrawable(BluedSkinUtils.b(getContext(), 2131233833));
    this.f = (CommonTopTitleNoTrans)findViewById(2131300300);
    this.f.getRightImg().setImageDrawable(BluedSkinUtils.b(getContext(), 2131232517));
    this.f.setLeftImg(2131232743);
    this.f.setRightClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            (new XPopup.Builder(this.a.getContext())).a((BasePopupView)new GiftVoucherHelpPop(this.a.getContext())).h();
          }
        });
    this.f.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.p();
          }
        });
    this.f.setCenterText(getContext().getString(2131759329));
    ViewGroup.LayoutParams layoutParams = this.f.getContent().getLayoutParams();
    layoutParams.height = DensityUtils.a(getContext(), 50.0F);
    this.f.getContent().setLayoutParams(layoutParams);
    this.h = (RecyclerView)findViewById(2131299601);
    this.h.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(getContext()));
    SpacesItemDecoration spacesItemDecoration = new SpacesItemDecoration(0, 0, 0, DensityUtils.a(AppInfo.d(), 9.0F));
    spacesItemDecoration.a(1);
    this.h.addItemDecoration((RecyclerView.ItemDecoration)spacesItemDecoration);
    GiftVoucherAdapter giftVoucherAdapter = this.g;
    giftVoucherAdapter.a = this.d;
    this.h.setAdapter((RecyclerView.Adapter)giftVoucherAdapter);
    this.g.c(this.c);
    this.g.a(new BaseQuickAdapter.OnItemClickListener(this) {
          public void onItemClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
            if (param1BaseQuickAdapter.n().size() > 0 && param1BaseQuickAdapter.n().size() > param1Int - 1) {
              GiftVoucherModel giftVoucherModel = param1BaseQuickAdapter.n().get(param1Int);
              if (giftVoucherModel.money >= this.a.d) {
                if (giftVoucherModel.isExpire)
                  return; 
                if (this.a.e != null && giftVoucherModel == this.a.e) {
                  this.a.e.isChecked = false;
                  this.a.e = null;
                } else {
                  if (this.a.e != null)
                    this.a.e.isChecked = false; 
                  GiftVoucherPop giftVoucherPop = this.a;
                  giftVoucherPop.e = giftVoucherModel;
                  giftVoucherPop.e.isChecked = true;
                } 
                param1BaseQuickAdapter.notifyDataSetChanged();
              } 
            } 
          }
        });
    findViewById(2131301130).setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            GiftVoucherPop.a(this.a, true);
            this.a.p();
          }
        });
  }
  
  public int getImplLayoutId() {
    return 2131494042;
  }
  
  public void q() {
    c();
    super.q();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\pop\GiftVoucherPop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */