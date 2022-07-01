package com.soft.blued.ui.mine.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.das.settings.SettingsProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.trackUtils.EventTrackSettings;
import com.soft.blued.ui.mine.model.MineEntryInfo;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.AreaUtils;
import com.soft.blued.utils.BitmapUtils;
import com.soft.blued.utils.BluedPreferences;

public class MineFourEntryAdapter extends BaseQuickAdapter<MineEntryInfo.ColumnsItem, BaseViewHolder> {
  private Context a;
  
  private IRequestHost b;
  
  public MineFourEntryAdapter(Context paramContext, IRequestHost paramIRequestHost) {
    super(2131493594);
    this.a = paramContext;
    this.b = paramIRequestHost;
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, MineEntryInfo.ColumnsItem paramColumnsItem) {
    ImageView imageView1;
    ImageView imageView2 = (ImageView)paramBaseViewHolder.d(2131297496);
    ImageLoader.a(this.b, paramColumnsItem.icon).a(imageView2);
    paramBaseViewHolder.a(2131301409, paramColumnsItem.title);
    if (!TextUtils.isEmpty(paramColumnsItem.recommend_text)) {
      paramBaseViewHolder.a(2131300663, paramColumnsItem.recommend_text);
    } else {
      paramBaseViewHolder.a(2131300663, "");
    } 
    if (BluedPreferences.af(paramColumnsItem.item_key)) {
      paramBaseViewHolder.b(2131297751, true);
    } else {
      paramBaseViewHolder.b(2131297751, false);
    } 
    paramBaseViewHolder.d(2131298026).setOnClickListener(new View.OnClickListener(this, paramColumnsItem) {
          public void onClick(View param1View) {
            boolean bool;
            SettingsProtos.Event event = SettingsProtos.Event.MINE_BTN_CLICK;
            String str1 = this.a.url;
            String str2 = this.a.id;
            if ((BluedConfig.b().j()).is_chat_shadow == 1) {
              bool = true;
            } else {
              bool = false;
            } 
            EventTrackSettings.a(event, str1, str2, bool);
            InstantLog.f("mine", this.a.url);
            WebViewShowInfoFragment.show(MineFourEntryAdapter.a(this.b), this.a.url, 9);
            BluedPreferences.ag(this.a.item_key);
            if (this.a.extra != null && !TextUtils.isEmpty(this.a.extra.type)) {
              String str = this.a.extra.type;
              byte b = -1;
              int i = str.hashCode();
              if (i != -1361632588) {
                if (i == -358591903 && str.equals("rich_level"))
                  b = 1; 
              } else if (str.equals("charge")) {
                b = 0;
              } 
              if (b != 0) {
                if (b != 1)
                  return; 
                InstantLog.b("my_model", 12);
                return;
              } 
              InstantLog.b("my_model", 11);
            } 
          }
        });
    paramBaseViewHolder.b(2131297804, false);
    paramBaseViewHolder.b(2131300670, false);
    if (paramColumnsItem.extra != null && !TextUtils.isEmpty(paramColumnsItem.extra.type)) {
      String str = paramColumnsItem.extra.type;
      int i = -1;
      int j = str.hashCode();
      if (j != -1361632588) {
        if (j != -378396698) {
          if (j == -358591903 && str.equals("rich_level"))
            i = 1; 
        } else if (str.equals("call_orders")) {
          i = 2;
        } 
      } else if (str.equals("charge")) {
        i = 0;
      } 
      if (i != 0) {
        if (i != 1) {
          if (i != 2) {
            if (TextUtils.isEmpty(paramColumnsItem.recommend_text)) {
              paramBaseViewHolder.b(2131298053, false);
              return;
            } 
          } else {
            paramBaseViewHolder.b(2131300670, false);
            i = paramColumnsItem.extra.times;
            if (i > 0) {
              paramBaseViewHolder.a(2131300663, String.format(this.a.getString(2131755662), new Object[] { Integer.valueOf(i) }));
              return;
            } 
            paramBaseViewHolder.a(2131300663, this.a.getString(2131755661));
            return;
          } 
        } else {
          paramBaseViewHolder.b(2131300663, false);
          paramBaseViewHolder.b(2131297804, true);
          imageView1 = (ImageView)paramBaseViewHolder.d(2131297804);
          BitmapUtils.a(this.a, imageView1, paramColumnsItem.extra.rich_level, false);
          return;
        } 
      } else {
        imageView1.b(2131300670, true);
        long l = paramColumnsItem.extra.beans;
        UserInfo.a().a(l);
        imageView1.a(2131300670, AreaUtils.a(this.a, Long.valueOf(l)));
        imageView1.a(2131300663, this.a.getString(2131755033));
        return;
      } 
    } else if (TextUtils.isEmpty(paramColumnsItem.recommend_text)) {
      imageView1.b(2131298053, false);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\mine\adapter\MineFourEntryAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */