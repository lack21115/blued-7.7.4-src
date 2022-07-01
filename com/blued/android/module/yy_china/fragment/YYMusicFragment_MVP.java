package com.blued.android.module.yy_china.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.live.base.music.model.LiveMusicModel;
import java.util.List;

public final class YYMusicFragment_MVP implements MvpDispatcher {
  public void a(MvpFragment paramMvpFragment, String paramString, List<List> paramList) {
    YYMusicFragment yYMusicFragment = (YYMusicFragment)paramMvpFragment;
    if (paramList != null && paramList.size() > 0) {
      byte b = 0;
      paramList = paramList.get(0);
      if (paramList != null) {
        if (paramString.hashCode() != 1900073223 || !paramString.equals("yy_music_info"))
          b = -1; 
        if (b != 0)
          return; 
        if (LiveMusicModel.class.isInstance(paramList))
          yYMusicFragment.a((LiveMusicModel)paramList); 
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\fragment\YYMusicFragment_MVP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */