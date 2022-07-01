package com.blued.android.module.live_china.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveFansPrivilegeModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;

public class LiveFansPrivilegeAdapater extends BaseQuickAdapter<LiveFansPrivilegeModel, BaseViewHolder> {
  private Context a;
  
  private int b = 0;
  
  public LiveFansPrivilegeAdapater(Context paramContext, int paramInt) {
    super(R.layout.live_fans_privilege_item_views);
    this.a = paramContext;
    this.b = paramInt;
    a();
    c(a());
  }
  
  public List<LiveFansPrivilegeModel> a() {
    ArrayList<LiveFansPrivilegeModel> arrayList = new ArrayList();
    LiveFansPrivilegeModel liveFansPrivilegeModel1 = new LiveFansPrivilegeModel(this.a.getString(R.string.live_fans_privilege_one), this.a.getString(R.string.live_fans_privilege_one_tip), R.drawable.live_privilege_one);
    LiveFansPrivilegeModel liveFansPrivilegeModel2 = new LiveFansPrivilegeModel(this.a.getString(R.string.live_fans_privilege_two), this.a.getString(R.string.live_fans_privilege_two_tip), R.drawable.live_privilege_two);
    LiveFansPrivilegeModel liveFansPrivilegeModel3 = new LiveFansPrivilegeModel(this.a.getString(R.string.live_fans_privilege_three), this.a.getString(R.string.live_fans_privilege_three_tip), R.drawable.live_privilege_three);
    LiveFansPrivilegeModel liveFansPrivilegeModel4 = new LiveFansPrivilegeModel(this.a.getString(R.string.live_fans_privilege_four), String.format(this.a.getString(R.string.live_fans_privilege_open_level), new Object[] { Integer.valueOf(6) }), R.drawable.live_privilege_four);
    LiveFansPrivilegeModel liveFansPrivilegeModel5 = new LiveFansPrivilegeModel(this.a.getString(R.string.live_fans_privilege_five), String.format(this.a.getString(R.string.live_fans_privilege_open_level), new Object[] { Integer.valueOf(16) }), R.drawable.live_privilege_five);
    LiveFansPrivilegeModel liveFansPrivilegeModel6 = new LiveFansPrivilegeModel(this.a.getString(R.string.live_fans_privilege_six), String.format(this.a.getString(R.string.live_fans_privilege_open_level), new Object[] { Integer.valueOf(26) }), R.drawable.live_privilege_six);
    arrayList.add(liveFansPrivilegeModel1);
    arrayList.add(liveFansPrivilegeModel2);
    arrayList.add(liveFansPrivilegeModel3);
    arrayList.add(liveFansPrivilegeModel4);
    arrayList.add(liveFansPrivilegeModel5);
    arrayList.add(liveFansPrivilegeModel6);
    return arrayList;
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, LiveFansPrivilegeModel paramLiveFansPrivilegeModel) {
    if (this.b == 0) {
      paramBaseViewHolder.d(R.id.fl_view).setPadding(0, 0, 0, DensityUtils.a(this.a, 20.0F));
    } else {
      paramBaseViewHolder.d(R.id.fl_view).setPadding(0, 0, 0, DensityUtils.a(this.a, 10.0F));
    } 
    ((ImageView)paramBaseViewHolder.d(R.id.iv_privilege)).setImageResource(paramLiveFansPrivilegeModel.iconResourse);
    ((TextView)paramBaseViewHolder.d(R.id.tv_privilege_name)).setText(paramLiveFansPrivilegeModel.name);
    ((TextView)paramBaseViewHolder.d(R.id.tv_privilege_des)).setText(paramLiveFansPrivilegeModel.des);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\adapter\LiveFansPrivilegeAdapater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */