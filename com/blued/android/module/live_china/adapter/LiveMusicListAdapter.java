package com.blued.android.module.live_china.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.common.ZegoCommonHelper;
import com.blued.android.module.live_china.model.LiveMusicSongModel;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;

public class LiveMusicListAdapter extends BaseMultiItemQuickAdapter<LiveMusicSongModel, BaseViewHolder> {
  LiveMusicEventCallBack a;
  
  private Context b;
  
  public LiveMusicListAdapter(Context paramContext) {
    super(new ArrayList());
    this.b = paramContext;
    b(0, R.layout.live_music_item_view);
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
    if (ZegoCommonHelper.b().a(paramLiveMusicSongModel.music_id)) {
      textView3.setVisibility(8);
      textView2.setVisibility(0);
      textView1.setVisibility(8);
    } else if (ZegoCommonHelper.b().b(paramLiveMusicSongModel.music_id)) {
      textView3.setVisibility(8);
      textView2.setVisibility(8);
      textView1.setVisibility(0);
    } else {
      textView3.setVisibility(0);
      textView2.setVisibility(8);
      textView1.setVisibility(8);
    } 
    if (paramLiveMusicSongModel.is_collect == 1) {
      i = R.drawable.live_music_mark_light;
    } else {
      i = R.drawable.live_music_mark_gray;
    } 
    imageView1.setImageResource(i);
    imageView1.setOnClickListener(new View.OnClickListener(this, paramLiveMusicSongModel) {
          public void onClick(View param1View) {
            if (this.b.a != null)
              this.b.a.b(this.a); 
          }
        });
    view.setOnClickListener(new View.OnClickListener(this, paramLiveMusicSongModel) {
          public void onClick(View param1View) {
            if (this.b.a != null)
              this.b.a.a(this.a); 
            this.b.notifyDataSetChanged();
          }
        });
  }
  
  public int a() {
    return (n() != null) ? n().size() : 0;
  }
  
  public void a(LiveMusicEventCallBack paramLiveMusicEventCallBack) {
    this.a = paramLiveMusicEventCallBack;
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, LiveMusicSongModel paramLiveMusicSongModel) {
    if (paramBaseViewHolder != null) {
      if (paramBaseViewHolder.getItemViewType() != 0)
        return; 
      b(paramBaseViewHolder, paramLiveMusicSongModel);
    } 
  }
  
  public void a(List<LiveMusicSongModel> paramList) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("models.szie:");
    stringBuilder.append(paramList.size());
    Log.i("==abc", stringBuilder.toString());
    c(paramList);
    c(false);
  }
  
  public static interface LiveMusicEventCallBack {
    void a(LiveMusicSongModel param1LiveMusicSongModel);
    
    void b(LiveMusicSongModel param1LiveMusicSongModel);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\adapter\LiveMusicListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */