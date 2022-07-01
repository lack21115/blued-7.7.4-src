package com.blued.android.module.yy_china.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.module.live.base.R;
import com.blued.android.module.live.base.music.adapter.LiveMusicListAdapter;
import com.blued.android.module.live.base.music.model.LiveMusicSongModel;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.chad.library.adapter.base.BaseViewHolder;

public class YYMusicListAdapter extends LiveMusicListAdapter<LiveMusicSongModel> {
  public YYMusicListAdapter(Context paramContext) {
    super(paramContext);
    b(0, R.layout.item_music_list_layout);
    b(1, R.layout.live_music_item_no_more_view);
  }
  
  private void b(BaseViewHolder paramBaseViewHolder, LiveMusicSongModel paramLiveMusicSongModel) {
    int i;
    View view = paramBaseViewHolder.d(R.id.ll_items_view);
    ImageView imageView2 = (ImageView)paramBaseViewHolder.d(R.id.iv_avatar);
    ImageLoader.a(null, paramLiveMusicSongModel.cover).a(R.drawable.live_music_no_cover).a(3.0F).a(imageView2);
    TextView textView1 = (TextView)paramBaseViewHolder.d(R.id.iv_loading);
    TextView textView2 = (TextView)paramBaseViewHolder.d(R.id.iv_playing);
    TextView textView3 = (TextView)paramBaseViewHolder.d(R.id.iv_start);
    TextView textView4 = (TextView)paramBaseViewHolder.d(R.id.tv_name);
    if (TextUtils.isEmpty(paramLiveMusicSongModel.music_name)) {
      textView4.setText(this.k.getString(R.string.live_music_no_name));
    } else {
      textView4.setText(paramLiveMusicSongModel.music_name);
    } 
    textView4 = (TextView)paramBaseViewHolder.d(R.id.tv_owner);
    if (TextUtils.isEmpty(paramLiveMusicSongModel.artist)) {
      textView4.setText(this.k.getString(R.string.live_music_no_owner));
    } else {
      textView4.setText(paramLiveMusicSongModel.artist);
    } 
    ImageView imageView1 = (ImageView)paramBaseViewHolder.d(R.id.iv_collection);
    if (this.a != null) {
      if (this.a.a(paramLiveMusicSongModel.music_id) || this.a.c(paramLiveMusicSongModel.music_id)) {
        textView3.setVisibility(8);
        textView2.setVisibility(0);
        textView1.setVisibility(8);
      } else if (this.a.b(paramLiveMusicSongModel.music_id)) {
        textView3.setVisibility(8);
        textView2.setVisibility(8);
        textView1.setVisibility(0);
      } else {
        textView3.setVisibility(0);
        textView2.setVisibility(8);
        textView1.setVisibility(8);
      } 
    } else {
      textView3.setVisibility(0);
      textView2.setVisibility(8);
      textView1.setVisibility(8);
    } 
    if (paramLiveMusicSongModel.is_collect == 1) {
      i = R.drawable.icon_yy_music_liked;
    } else {
      i = R.drawable.icon_yy_music_unlike;
    } 
    imageView1.setImageResource(i);
    imageView1.setOnClickListener(new View.OnClickListener(this, paramLiveMusicSongModel) {
          public void onClick(View param1View) {
            if (this.a.is_collect == 0) {
              YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
              if (yYRoomModel != null) {
                String str1;
                ChatRoomProtos.Event event = ChatRoomProtos.Event.CHAT_ROOM_TOOLBOX_MUSIC_LIKE_CLICK;
                String str2 = yYRoomModel.room_id;
                if (TextUtils.isEmpty(this.a.sheetId)) {
                  str1 = "search";
                } else {
                  str1 = this.a.sheetId;
                } 
                EventTrackYY.h(event, str2, str1, this.a.music_id);
              } 
            } 
            if (this.b.a != null)
              this.b.a.c(this.a); 
          }
        });
    view.setOnClickListener(new View.OnClickListener(this, paramLiveMusicSongModel) {
          public void onClick(View param1View) {
            if (this.b.a != null)
              if (this.b.a.c(this.a.music_id)) {
                this.b.a.b(this.a);
              } else if (!this.b.a.a(this.a.music_id)) {
                this.b.a.a(this.a);
              }  
            this.b.notifyDataSetChanged();
          }
        });
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, LiveMusicSongModel paramLiveMusicSongModel) {
    if (paramBaseViewHolder == null)
      return; 
    if (paramBaseViewHolder.getItemViewType() != 0)
      return; 
    b(paramBaseViewHolder, paramLiveMusicSongModel);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\adapter\YYMusicListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */