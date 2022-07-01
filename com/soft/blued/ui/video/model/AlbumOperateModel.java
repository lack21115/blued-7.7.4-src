package com.soft.blued.ui.video.model;

import android.content.Intent;
import android.text.TextUtils;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.framework.utils.FileUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.base.shortvideo.ShortVideoProxy;
import com.blued.android.module.media.selector.model.AlbumDataManager;
import com.blued.android.module.media.selector.model.AlbumSelectInfo;
import com.blued.android.module.player.media.model.MediaInfo;
import com.soft.blued.ui.feed.manager.SelectPhotoManager;
import com.soft.blued.ui.feed.model.ChildImageInfo;
import com.soft.blued.utils.AppUtils;

public class AlbumOperateModel {
  public void a(BaseFragment paramBaseFragment, AlbumSelectInfo paramAlbumSelectInfo, int paramInt1, int paramInt2) {
    MediaInfo mediaInfo;
    if (paramAlbumSelectInfo == null)
      return; 
    if (paramAlbumSelectInfo.e() == AlbumDataManager.getMediaTypeVideo()) {
      if (paramAlbumSelectInfo.c() != null && paramAlbumSelectInfo.c().size() > 0) {
        mediaInfo = paramAlbumSelectInfo.c().get(0);
        if (mediaInfo != null) {
          ShortVideoProxy.e().a(paramBaseFragment, mediaInfo.path, paramInt1, paramInt2);
          return;
        } 
      } 
    } else if (paramInt1 != 1) {
      for (MediaInfo mediaInfo1 : mediaInfo.c()) {
        ChildImageInfo childImageInfo = new ChildImageInfo();
        if (AppUtils.b() && !TextUtils.isEmpty(mediaInfo1.imgUri) && !AppUtils.b(mediaInfo1.imagePath)) {
          String str = RecyclingUtils.e("photo");
          boolean bool = FileUtils.a(mediaInfo1.imgUri, str);
          childImageInfo.mImagePath = str;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("SaveSelectPhoto: ");
          stringBuilder.append(str);
          stringBuilder.append(" ");
          stringBuilder.append(bool);
          LogUtils.c(stringBuilder.toString());
        } else {
          childImageInfo.mImagePath = mediaInfo1.imagePath;
        } 
        childImageInfo.width = mediaInfo1.width;
        childImageInfo.height = mediaInfo1.height;
        SelectPhotoManager.a().c().add(childImageInfo);
      } 
      Intent intent = new Intent();
      intent.putExtra("close_page", true);
      paramBaseFragment.getActivity().setResult(-1, intent);
      paramBaseFragment.getActivity().finish();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\video\model\AlbumOperateModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */