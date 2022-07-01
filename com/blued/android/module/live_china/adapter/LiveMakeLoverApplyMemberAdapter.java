package com.blued.android.module.live_china.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveMakeLoverApplyMemberModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;

public class LiveMakeLoverApplyMemberAdapter extends BaseQuickAdapter<LiveMakeLoverApplyMemberModel, BaseViewHolder> {
  private Context a;
  
  private boolean b;
  
  public LiveMakeLoverApplyMemberAdapter(Context paramContext, boolean paramBoolean) {
    super(R.layout.live_make_lover_apply_member_item_view, new ArrayList());
    this.a = paramContext;
    this.b = paramBoolean;
  }
  
  public int a() {
    return (n() != null) ? n().size() : 0;
  }
  
  public LiveMakeLoverApplyMemberModel a(int paramInt) {
    return (n() == null) ? null : ((paramInt < n().size() && paramInt >= 0) ? n().get(paramInt) : null);
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, LiveMakeLoverApplyMemberModel paramLiveMakeLoverApplyMemberModel) {
    View view = paramBaseViewHolder.d(R.id.ll_items_view);
    if (TextUtils.equals(paramLiveMakeLoverApplyMemberModel.uid, LiveRoomInfo.a().f())) {
      view.setBackgroundColor(this.a.getResources().getColor(R.color.syc_dark_ded9ff));
    } else {
      view.setBackground(null);
    } 
    TextView textView3 = (TextView)paramBaseViewHolder.d(R.id.tv_level);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(paramLiveMakeLoverApplyMemberModel.position + 1);
    textView3.setText(stringBuilder.toString());
    ImageView imageView = (ImageView)paramBaseViewHolder.d(R.id.avatar);
    ImageLoader.a(null, paramLiveMakeLoverApplyMemberModel.avatar).a(R.drawable.user_bg_round).c().a(imageView);
    ((TextView)paramBaseViewHolder.d(R.id.tv_name)).setText(paramLiveMakeLoverApplyMemberModel.name);
    TextView textView1 = (TextView)paramBaseViewHolder.d(R.id.tv_done);
    TextView textView2 = (TextView)paramBaseViewHolder.d(R.id.tv_ignore);
    if (this.b) {
      textView1.setVisibility(8);
      textView2.setVisibility(8);
    } else {
      textView1.setVisibility(0);
      textView2.setVisibility(0);
    } 
    paramBaseViewHolder.c(R.id.ll_items_view);
    paramBaseViewHolder.c(R.id.tv_done);
    paramBaseViewHolder.c(R.id.tv_ignore);
  }
  
  public void a(List<LiveMakeLoverApplyMemberModel> paramList) {
    if (paramList == null)
      return; 
    for (int i = 0; i < paramList.size(); i++)
      ((LiveMakeLoverApplyMemberModel)paramList.get(i)).position = i; 
    c(paramList);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\adapter\LiveMakeLoverApplyMemberAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */