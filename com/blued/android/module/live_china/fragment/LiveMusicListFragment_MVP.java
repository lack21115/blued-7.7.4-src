package com.blued.android.module.live_china.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.live_china.model.LiveMusicSongModel;
import java.util.List;

public final class LiveMusicListFragment_MVP implements MvpDispatcher {
  public void a(MvpFragment paramMvpFragment, String paramString, List<Object> paramList) {
    paramMvpFragment = paramMvpFragment;
    if (paramList != null && paramList.size() > 0) {
      byte b = 0;
      Object object = paramList.get(0);
      if (object != null) {
        if (paramString.hashCode() != -311507036 || !paramString.equals("MUSIC_SHEET_SONGS"))
          b = -1; 
        if (b != 0)
          return; 
        if (LiveMusicSongModel.class.isInstance(object))
          paramMvpFragment.a((List)paramList); 
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\LiveMusicListFragment_MVP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */