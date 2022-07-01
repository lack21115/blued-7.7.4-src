package com.soft.blued.ui.mine.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.das.settings.SettingsProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.trackUtils.EventTrackSettings;
import com.soft.blued.ui.live.utils.LiveUtils;
import com.soft.blued.ui.mine.model.MineEntryInfo;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.AreaUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;

public class MineNineEntryAdapter extends BaseQuickAdapter<MineEntryInfo.ColumnsItem, BaseViewHolder> {
  private Context a;
  
  private IRequestHost b;
  
  public MineNineEntryAdapter(Context paramContext, IRequestHost paramIRequestHost) {
    super(2131493595);
    this.a = paramContext;
    this.b = paramIRequestHost;
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, MineEntryInfo.ColumnsItem paramColumnsItem) {
    ImageView imageView = (ImageView)paramBaseViewHolder.d(2131297496);
    TextView textView = (TextView)paramBaseViewHolder.d(2131300663);
    paramBaseViewHolder.b(2131300516, false);
    imageView.setVisibility(0);
    ImageLoader.a(this.b, paramColumnsItem.icon).a(imageView);
    if (paramColumnsItem.extra != null && paramColumnsItem.extra.show_new_icon == 1) {
      paramBaseViewHolder.b(2131297872, true);
    } else {
      paramBaseViewHolder.b(2131297872, false);
    } 
    paramBaseViewHolder.a(2131301409, paramColumnsItem.title);
    paramBaseViewHolder.b(2131300670, false);
    if (!TextUtils.isEmpty(paramColumnsItem.recommend_text)) {
      paramBaseViewHolder.a(2131300663, paramColumnsItem.recommend_text);
    } else {
      paramBaseViewHolder.a(2131300663, "");
    } 
    if (paramColumnsItem.extra != null && !TextUtils.isEmpty(paramColumnsItem.extra.type)) {
      StringBuilder stringBuilder;
      String str = paramColumnsItem.extra.type;
      int i = -1;
      switch (str.hashCode()) {
        case -358591903:
          if (str.equals("rich_level"))
            i = 2; 
          break;
        case -378396698:
          if (str.equals("call_orders"))
            i = 3; 
          break;
        case -634444422:
          if (str.equals("anchor_level"))
            i = 0; 
          break;
        case -1361632588:
          if (str.equals("charge"))
            i = 1; 
          break;
      } 
      if (i != 0) {
        if (i != 1) {
          if (i != 2) {
            if (i == 3) {
              i = paramColumnsItem.extra.times;
              if (i > 0) {
                paramBaseViewHolder.a(2131300663, String.format(this.a.getString(2131755662), new Object[] { Integer.valueOf(i) }));
              } else {
                paramBaseViewHolder.a(2131300663, this.a.getString(2131755661));
              } 
            } 
          } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Lv.");
            stringBuilder.append(LiveUtils.a(paramColumnsItem.extra.rich_level));
            paramBaseViewHolder.a(2131300663, stringBuilder.toString());
          } 
        } else {
          paramBaseViewHolder.b(2131300670, true);
          long l = paramColumnsItem.extra.beans;
          UserInfo.a().a(l);
          paramBaseViewHolder.a(2131300670, AreaUtils.a(this.a, Long.valueOf(l)));
          paramBaseViewHolder.a(2131300663, this.a.getString(2131755033));
        } 
      } else {
        stringBuilder.setVisibility(4);
        paramBaseViewHolder.b(2131300516, true);
        paramBaseViewHolder.a(2131300516, paramColumnsItem.extra.anchor_level);
      } 
    } 
    if (paramColumnsItem.is_highlight == 1) {
      textView.setTextColor(Color.parseColor("#00CCCC"));
    } else {
      textView.setTextColor(BluedSkinUtils.a(this.a, 2131100844));
    } 
    if (BluedPreferences.af(paramColumnsItem.item_key) || (paramColumnsItem.title != null && paramColumnsItem.title.equals(this.a.getResources().getString(2131758707)) && BluedPreferences.ek())) {
      paramBaseViewHolder.b(2131297751, true);
    } else {
      paramBaseViewHolder.b(2131297751, false);
    } 
    paramBaseViewHolder.d(2131298026).setOnClickListener(new View.OnClickListener(this, paramColumnsItem) {
          public void onClick(View param1View) {
            SettingsProtos.Event event = SettingsProtos.Event.MINE_BTN_CLICK;
            String str1 = this.a.url;
            String str2 = this.a.id;
            int i = (BluedConfig.b().j()).is_chat_shadow;
            boolean bool = true;
            if (i != 1)
              bool = false; 
            EventTrackSettings.a(event, str1, str2, bool);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("MineNineEntryAdapter===");
            stringBuilder.append(this.a.title);
            Logger.e(stringBuilder.toString(), new Object[0]);
            stringBuilder = new StringBuilder();
            stringBuilder.append("MineNineEntryAdapter===");
            stringBuilder.append(this.a.url);
            Logger.e(stringBuilder.toString(), new Object[0]);
            InstantLog.f("mine", this.a.url);
            WebViewShowInfoFragment.show(MineNineEntryAdapter.a(this.b), this.a.url, 9);
            BluedPreferences.ag(this.a.item_key);
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\mine\adapter\MineNineEntryAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */