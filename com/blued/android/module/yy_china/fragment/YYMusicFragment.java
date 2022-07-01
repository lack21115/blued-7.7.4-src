package com.blued.android.module.yy_china.fragment;

import android.text.TextUtils;
import androidx.lifecycle.Observer;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.live.base.music.PlayMusicListener;
import com.blued.android.module.live.base.music.fragment.LiveMusicFragment;
import com.blued.android.module.live.base.music.fragment.LiveMusicListFragment;
import com.blued.android.module.live.base.music.model.LiveMusicModel;
import com.blued.android.module.live.base.music.model.LiveMusicSongModel;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.presenter.YYMusicPresent;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.blued.android.module.yy_china.trtc_audio.model.TrtcMusicModel;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;

public class YYMusicFragment extends LiveMusicFragment<YYMusicPresent> {
  private Observer<TrtcMusicModel> e = new Observer<TrtcMusicModel>(this) {
      public void a(TrtcMusicModel param1TrtcMusicModel) {
        LogUtils.c("music", "更新进度条");
        if (param1TrtcMusicModel == null)
          return; 
        LiveMusicModel liveMusicModel = YYRoomInfoManager.d().n();
        if (liveMusicModel == null)
          return; 
        liveMusicModel.curDuration = param1TrtcMusicModel.c;
        this.a.a(param1TrtcMusicModel.c);
      }
    };
  
  public PlayMusicListener K() {
    return new PlayMusicListener(this) {
        public void a() {
          if (this.a.N() != null)
            this.a.N().y(); 
        }
        
        public void a(LiveMusicSongModel param1LiveMusicSongModel) {
          if (param1LiveMusicSongModel == null)
            return; 
          YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
          if (yYRoomModel != null)
            EventTrackYY.h(ChatRoomProtos.Event.CHAT_ROOM_TOOLBOX_MUSIC_PLAY_CLICK, yYRoomModel.room_id, param1LiveMusicSongModel.sheetId, param1LiveMusicSongModel.music_id); 
          ((YYMusicPresent)this.a.s()).a(param1LiveMusicSongModel.sheetId, param1LiveMusicSongModel.music_id, param1LiveMusicSongModel.music_name, param1LiveMusicSongModel.artist, param1LiveMusicSongModel.duration, param1LiveMusicSongModel.cover);
        }
        
        public boolean a(String param1String) {
          LiveMusicModel liveMusicModel = this.a.L();
          return (liveMusicModel != null && TextUtils.equals(liveMusicModel.music_id, param1String) && liveMusicModel.playStatus == 2);
        }
        
        public void b() {
          YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
          if (yYRoomModel != null)
            EventTrackYY.c(ChatRoomProtos.Event.CHAT_ROOM_TOOLBOX_MUSIC_PLAY_SEARCH_CLICK, yYRoomModel.room_id); 
        }
        
        public void b(LiveMusicSongModel param1LiveMusicSongModel) {
          YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
          if (yYRoomModel != null && param1LiveMusicSongModel != null)
            EventTrackYY.h(ChatRoomProtos.Event.CHAT_ROOM_TOOLBOX_MUSIC_PLAY_CLICK, yYRoomModel.room_id, param1LiveMusicSongModel.sheetId, param1LiveMusicSongModel.music_id); 
          (this.a.L()).playStatus = 2;
          this.a.m();
          this.a.N().V();
          AudioChannelManager.e().b(1);
        }
        
        public boolean b(String param1String) {
          return false;
        }
        
        public void c(LiveMusicSongModel param1LiveMusicSongModel) {
          YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
          if (yYRoomModel != null && param1LiveMusicSongModel != null)
            EventTrackYY.h(ChatRoomProtos.Event.CHAT_ROOM_TOOLBOX_MUSIC_PAUSE_CLICK, yYRoomModel.room_id, param1LiveMusicSongModel.sheetId, param1LiveMusicSongModel.music_id); 
          (this.a.L()).playStatus = 4;
          this.a.N().Y();
          AudioChannelManager.e().c(1);
        }
        
        public boolean c(String param1String) {
          return (this.a.L() != null && TextUtils.equals((this.a.L()).music_id, param1String) && (this.a.L()).playStatus == 3);
        }
        
        public void d(LiveMusicSongModel param1LiveMusicSongModel) {
          YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
          if (yYRoomModel != null && param1LiveMusicSongModel != null)
            EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_TOOLBOX_MUSIC_EXIT_CLICK, yYRoomModel.room_id, param1LiveMusicSongModel.sheetId, param1LiveMusicSongModel.music_id, param1LiveMusicSongModel.playTime); 
          YYRoomInfoManager.d().a(null);
          this.a.N().W();
          AudioChannelManager.e().d(1);
          LiveEventBus.get("live_music_changed").post("");
        }
        
        public boolean d(String param1String) {
          LiveMusicModel liveMusicModel = this.a.L();
          return (liveMusicModel != null && TextUtils.equals(liveMusicModel.music_id, param1String) && liveMusicModel.playStatus == 4);
        }
        
        public void e(LiveMusicSongModel param1LiveMusicSongModel) {
          YYRoomInfoManager.d().a(null);
          this.a.N().X();
        }
        
        public boolean e(String param1String) {
          return !(this.a.L() == null || TextUtils.isEmpty(param1String) || !TextUtils.equals(param1String, (this.a.L()).music_id) || TextUtils.isEmpty((this.a.L()).file_url));
        }
      };
  }
  
  public LiveMusicModel L() {
    return YYRoomInfoManager.d().n();
  }
  
  public LiveMusicListFragment M() {
    return new YYMusicItemFragment();
  }
  
  public RecordingStudioFragment N() {
    return (getParentFragment() instanceof RecordingStudioFragment) ? (RecordingStudioFragment)getParentFragment() : null;
  }
  
  public void a(LiveMusicModel paramLiveMusicModel) {
    paramLiveMusicModel.playStatus = 2;
    YYRoomInfoManager.d().a(paramLiveMusicModel);
    N().a(paramLiveMusicModel);
    H();
    AudioChannelManager.e().a(1, paramLiveMusicModel.file_url);
  }
  
  public void k() {
    super.k();
    LiveEventBus.get("live_music_play_progress", TrtcMusicModel.class).observeForever(this.e);
  }
  
  public void l() {
    super.l();
    LiveEventBus.get("live_music_play_progress", TrtcMusicModel.class).removeObserver(this.e);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\fragment\YYMusicFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */