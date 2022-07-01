package com.soft.blued.ui.video.adapter;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.utils.AvatarUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.ui.video.model.VideoScanMusic;

public class MyMusicCollectionAdapter extends BaseQuickAdapter<VideoScanMusic, BaseViewHolder> {
  private Context a;
  
  private IRequestHost b;
  
  public MyMusicCollectionAdapter(Context paramContext, IRequestHost paramIRequestHost) {
    super(2131493609);
    this.a = paramContext;
    this.b = paramIRequestHost;
  }
  
  private String a(long paramLong) {
    if (paramLong >= 60L) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramLong / 60L);
      stringBuilder.append(":");
      stringBuilder.append(paramLong % 60L);
      return stringBuilder.toString();
    } 
    if (paramLong > 0L) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("0:");
      stringBuilder.append(paramLong);
      return stringBuilder.toString();
    } 
    return "";
  }
  
  public void a() {
    for (int i = 0; i < this.n.size(); i++)
      ((VideoScanMusic)this.n.get(i)).isPlaying = false; 
    notifyDataSetChanged();
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, VideoScanMusic paramVideoScanMusic) {
    if (paramBaseViewHolder != null) {
      Animation animation;
      ImageView imageView1 = (ImageView)paramBaseViewHolder.d(2131297734);
      ImageLoader.a(this.b, AvatarUtils.a(1, paramVideoScanMusic.music_cover)).a(2131234356).c().a(imageView1);
      FrameLayout frameLayout = (FrameLayout)paramBaseViewHolder.d(2131298054);
      ImageView imageView2 = (ImageView)paramBaseViewHolder.d(2131297869);
      if (paramVideoScanMusic.isPlaying) {
        imageView2.setImageResource(2131234406);
        animation = AnimationUtils.loadAnimation(this.a, 2130771998);
        animation.setInterpolator((Interpolator)new LinearInterpolator());
        frameLayout.startAnimation(animation);
      } else {
        animation.setImageResource(2131234407);
        frameLayout.clearAnimation();
      } 
      paramBaseViewHolder.a(2131301068, paramVideoScanMusic.music_name);
      paramBaseViewHolder.a(2131301070, a((long)paramVideoScanMusic.music_duration));
      paramBaseViewHolder.c(2131300126);
      paramBaseViewHolder.c(2131297732);
      paramBaseViewHolder.c(2131298054);
    } 
  }
  
  public void a(VideoScanMusic paramVideoScanMusic) {
    if (paramVideoScanMusic.isPlaying) {
      paramVideoScanMusic.isPlaying = false;
    } else {
      a();
      paramVideoScanMusic.isPlaying = true;
    } 
    notifyDataSetChanged();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\video\adapter\MyMusicCollectionAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */