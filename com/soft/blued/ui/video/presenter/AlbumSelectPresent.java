package com.soft.blued.ui.video.presenter;

import android.app.Activity;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.media.selector.model.AlbumSelectInfo;
import com.soft.blued.ui.video.model.AlbumOperateModel;
import com.soft.blued.user.UserInfo;

public class AlbumSelectPresent {
  private AlbumOperateModel a;
  
  public AlbumSelectPresent(Activity paramActivity) {
    a(paramActivity);
  }
  
  private void a(Activity paramActivity) {
    if (UserInfo.a() == null) {
      paramActivity.finish();
      return;
    } 
    this.a = new AlbumOperateModel();
  }
  
  public long a() {
    return 300000L;
  }
  
  public void a(BaseFragment paramBaseFragment, AlbumSelectInfo paramAlbumSelectInfo, int paramInt1, int paramInt2) {
    AlbumOperateModel albumOperateModel = this.a;
    if (albumOperateModel != null)
      albumOperateModel.a(paramBaseFragment, paramAlbumSelectInfo, paramInt1, paramInt2); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\video\presenter\AlbumSelectPresent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */