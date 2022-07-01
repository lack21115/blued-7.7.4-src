package com.soft.blued.ui.video.presenter;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.soft.blued.http.FeedHttpUtils;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.video.model.VideoScanMusic;

public class MusicVideoCollectPresent extends MvpPresenter {
  private VideoScanMusic h;
  
  private String i;
  
  private int j = 1;
  
  private int k = 30;
  
  private boolean l;
  
  private void c(IFetchDataListener paramIFetchDataListener) {
    if (this.j == 1)
      this.l = true; 
    if (!this.l)
      return; 
    FeedHttpUtils.a(new BluedUIHttpResponse<BluedEntity<BluedIngSelfFeed, VideoScanMusic>>(this, g(), paramIFetchDataListener) {
          public void onUIFinish(boolean param1Boolean) {
            if (!param1Boolean && MusicVideoCollectPresent.a(this.b) != 1)
              MusicVideoCollectPresent.b(this.b); 
            if (!MusicVideoCollectPresent.c(this.b))
              this.a.b(); 
            this.a.a(param1Boolean);
          }
          
          public void onUIUpdate(BluedEntity<BluedIngSelfFeed, VideoScanMusic> param1BluedEntity) {
            boolean bool = false;
            if (param1BluedEntity != null) {
              if (param1BluedEntity.extra != null && !TextUtils.isEmpty(((VideoScanMusic)param1BluedEntity.extra).music_id))
                MusicVideoCollectPresent.a(this.b, (VideoScanMusic)param1BluedEntity.extra); 
              this.b.a("collect_music", param1BluedEntity.extra);
              if (param1BluedEntity.hasData())
                this.a.a("collect_list", param1BluedEntity.data); 
              if (param1BluedEntity.extra != null) {
                MusicVideoCollectPresent musicVideoCollectPresent = this.b;
                if (((VideoScanMusic)param1BluedEntity.extra).has_more == 1)
                  bool = true; 
                MusicVideoCollectPresent.a(musicVideoCollectPresent, bool);
                return;
              } 
              MusicVideoCollectPresent.a(this.b, false);
              return;
            } 
            MusicVideoCollectPresent.a(this.b, false);
          }
        }this.i, this.j, this.k, g());
  }
  
  public void a(FragmentActivity paramFragmentActivity, Bundle paramBundle1, Bundle paramBundle2) {
    super.a(paramFragmentActivity, paramBundle1, paramBundle2);
    this.h = (VideoScanMusic)paramBundle1.getSerializable("video_scan_music");
    VideoScanMusic videoScanMusic = this.h;
    if (videoScanMusic == null || TextUtils.isEmpty(videoScanMusic.music_id)) {
      i();
      return;
    } 
    this.i = this.h.music_id;
    a("collect_music", this.h);
  }
  
  public void a(IFetchDataListener paramIFetchDataListener) {
    this.j = 1;
    c(paramIFetchDataListener);
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {
    this.j++;
    c(paramIFetchDataListener);
  }
  
  public void m() {
    if ((p()).i_star == 1) {
      (p()).i_star = 0;
      a("collect_music", this.h);
      o();
      return;
    } 
    (p()).i_star = 1;
    a("collect_music", this.h);
    n();
  }
  
  public void n() {
    FeedHttpUtils.e(new BluedUIHttpResponse(this, g()) {
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            (this.a.p()).i_star = 1;
            MusicVideoCollectPresent musicVideoCollectPresent = this.a;
            musicVideoCollectPresent.a("collect_music", MusicVideoCollectPresent.d(musicVideoCollectPresent));
            AppMethods.d(2131758146);
          }
        }this.i, g());
  }
  
  public void o() {
    FeedHttpUtils.f(new BluedUIHttpResponse(this, g()) {
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            (this.a.p()).i_star = 0;
            MusicVideoCollectPresent musicVideoCollectPresent = this.a;
            musicVideoCollectPresent.a("collect_music", MusicVideoCollectPresent.d(musicVideoCollectPresent));
          }
        }this.i, g());
  }
  
  public VideoScanMusic p() {
    if (this.h == null)
      this.h = new VideoScanMusic(); 
    return this.h;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\video\presenter\MusicVideoCollectPresent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */