package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import com.blued.android.module.live.base.music.adapter.LiveMusicListAdapter;
import com.blued.android.module.live.base.music.fragment.LiveMusicListFragment;
import com.blued.android.module.yy_china.adapter.YYMusicListAdapter;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.presenter.YYMusicItemPresent;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;

public class YYMusicItemFragment extends LiveMusicListFragment<YYMusicItemPresent> {
  public LiveMusicListAdapter l() {
    return (LiveMusicListAdapter)new YYMusicListAdapter(getContext());
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel != null)
      EventTrackYY.b(ChatRoomProtos.Event.CHAT_ROOM_TOOLBOX_MUSIC_TAB_SHOW, yYRoomModel.room_id, this.d); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\fragment\YYMusicItemFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */