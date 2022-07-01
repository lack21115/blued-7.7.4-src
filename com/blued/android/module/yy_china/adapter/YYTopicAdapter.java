package com.blued.android.module.yy_china.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.model.YYTopicModel;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;

public class YYTopicAdapter extends BaseQuickAdapter<YYTopicModel, BaseViewHolder> {
  private YYTopicModel a;
  
  private int b;
  
  private String c;
  
  private String d;
  
  public YYTopicAdapter(Context paramContext, String paramString1, String paramString2) {
    super(R.layout.item_create_yy_topic, new ArrayList());
    this.k = paramContext;
    this.c = paramString1;
    this.d = paramString2;
    this.b = (AppInfo.l - DensityUtils.a(this.k, 10.0F) * 2 - DensityUtils.a(this.k, 8.0F) * 2) / 3;
  }
  
  public YYTopicModel a() {
    return this.a;
  }
  
  public void a(int paramInt) {
    if (n() != null) {
      if (n().size() <= paramInt)
        return; 
      YYTopicModel yYTopicModel = n().get(paramInt);
      if (yYTopicModel.isChecked)
        return; 
      for (YYTopicModel yYTopicModel1 : n()) {
        if (TextUtils.equals(yYTopicModel1.type_id, yYTopicModel.type_id)) {
          yYTopicModel1.isChecked = true;
          continue;
        } 
        yYTopicModel1.isChecked = false;
      } 
      notifyDataSetChanged();
    } 
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, YYTopicModel paramYYTopicModel) {
    TextView textView = (TextView)paramBaseViewHolder.d(R.id.tv_tab_name);
    (textView.getLayoutParams()).width = this.b;
    textView.setText(paramYYTopicModel.room_type);
    if (paramYYTopicModel.isChecked) {
      this.a = paramYYTopicModel;
      textView.setBackgroundResource(R.drawable.shape_miaobian);
      textView.setTextColor(BluedSkinUtils.a(this.k, R.color.syc_h));
    } else {
      textView.setBackgroundResource(R.drawable.shape_unmiaobian);
      textView.setTextColor(BluedSkinUtils.a(this.k, R.color.syc_j));
    } 
    if (!paramYYTopicModel.isUpdload) {
      paramYYTopicModel.isUpdload = true;
      EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_HOME_PAGE_TAB_SHOW, "", "", this.c, this.d);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\adapter\YYTopicAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */