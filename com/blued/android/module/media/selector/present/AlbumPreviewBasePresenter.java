package com.blued.android.module.media.selector.present;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.media.selector.R;
import com.blued.android.module.media.selector.adapter.AlbumPreviewBaseAdapter;
import com.blued.android.module.media.selector.contract.IAlbumPreviewBaseCallback;
import com.blued.android.module.media.selector.contract.IAlbumPreviewBaseView;
import com.blued.android.module.media.selector.model.AlbumDataManager;
import com.blued.android.module.media.selector.model.AlbumSelectInfo;
import com.blued.android.module.media.selector.utils.ThumbLoader;
import com.blued.android.module.player.media.fragment.VideoDetailFragment;
import com.blued.android.module.player.media.model.MediaInfo;
import com.blued.android.module.player.media.model.VideoPlayConfig;
import java.io.Serializable;

public class AlbumPreviewBasePresenter extends MediaBasePresent<IAlbumPreviewBaseView> implements IAlbumPreviewBaseCallback {
  public static void a(MediaInfo paramMediaInfo, int paramInt) {
    AlbumDataManager.addSelectImage(paramMediaInfo, paramInt);
  }
  
  public static int b(int paramInt) {
    return AlbumDataManager.setCurrentPosition(paramInt);
  }
  
  public static void b(MediaInfo paramMediaInfo) {
    AlbumDataManager.removeSelectImage(paramMediaInfo);
  }
  
  public static int e() {
    return AlbumDataManager.getCurrentPosition();
  }
  
  public static MediaInfo f() {
    return AlbumDataManager.getCurrentChildImageInfo();
  }
  
  public static int g() {
    return AlbumDataManager.getMediaTypeVideo();
  }
  
  public static int h() {
    return AlbumDataManager.getMediaTypeImage();
  }
  
  public static int i() {
    return AlbumDataManager.getSelectImageSize();
  }
  
  public int a() {
    return AlbumDataManager.getCurrentListSize();
  }
  
  public int a(MediaInfo paramMediaInfo) {
    b(paramMediaInfo);
    return i();
  }
  
  public BaseFragment a(VideoPlayConfig paramVideoPlayConfig) {
    return (BaseFragment)((p() != null) ? p().a(paramVideoPlayConfig) : VideoDetailFragment.a(paramVideoPlayConfig));
  }
  
  public MediaInfo a(int paramInt) {
    return AlbumDataManager.getVRChildImageInfo(paramInt);
  }
  
  public void a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent) {
    if (p() != null && !p().a(paramActivity, paramInt1, paramInt2, paramIntent) && paramInt1 == 1 && paramInt2 == 0)
      p().getActivity().finish(); 
  }
  
  public void a(Intent paramIntent) {
    AlbumSelectInfo albumSelectInfo = new AlbumSelectInfo();
    albumSelectInfo.a(AlbumDataManager.getAlbumSelectInfo());
    AlbumDataManager.clearAlbumSelectData();
    if (!p().a(albumSelectInfo)) {
      Intent intent = paramIntent;
      if (paramIntent == null)
        intent = new Intent(); 
      intent.putExtra("album_result_model", (Serializable)albumSelectInfo);
      p().getActivity().setResult(-1, intent);
      p().getActivity().finish();
    } 
  }
  
  public void a(Bundle paramBundle) {
    if (paramBundle != null) {
      AlbumSelectInfo albumSelectInfo = (AlbumSelectInfo)paramBundle.getSerializable("serializeble_data");
      if (albumSelectInfo != null)
        AlbumDataManager.setAlbumSelectInfo(albumSelectInfo); 
    } 
  }
  
  public FragmentStatePagerAdapter b() {
    return (FragmentStatePagerAdapter)new AlbumPreviewBaseAdapter(p().a().getChildFragmentManager(), this);
  }
  
  public void b(Bundle paramBundle) {
    Bundle bundle = paramBundle;
    if (paramBundle == null)
      bundle = new Bundle(); 
    bundle.putSerializable("serializeble_data", (Serializable)AlbumDataManager.getAlbumSelectInfo());
  }
  
  public boolean c() {
    if (i() < AlbumDataManager.getMaxSelectNum()) {
      MediaInfo mediaInfo = f();
      mediaInfo.isSelected = true;
      a(mediaInfo, e());
      return true;
    } 
    AppMethods.a(String.format(p().getActivity().getResources().getString(R.string.foudation_media_max_select_num), new Object[] { Integer.valueOf(AlbumDataManager.getMaxSelectNum()) }));
    return false;
  }
  
  public void d() {
    MediaInfo mediaInfo = f();
    if (mediaInfo != null)
      if (mediaInfo.media_type == g()) {
        if (i() == 0) {
          a(mediaInfo, e());
          AlbumDataManager.setSelectMediaType(g());
          return;
        } 
      } else if (i() == 0) {
        a(f(), e());
        p().a(e());
        AlbumDataManager.setSelectMediaType(h());
      }  
  }
  
  public void j() {
    ThumbLoader.a().b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\media\selector\present\AlbumPreviewBasePresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */