package com.blued.android.module.media.selector.present;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppMethods;
import com.blued.android.module.media.selector.R;
import com.blued.android.module.media.selector.adapter.AlbumBaseAdapter;
import com.blued.android.module.media.selector.contract.IAlbumBaseCallback;
import com.blued.android.module.media.selector.contract.IAlbumBaseView;
import com.blued.android.module.media.selector.fragment.AlbumPreviewBaseFragment;
import com.blued.android.module.media.selector.model.AlbumDataManager;
import com.blued.android.module.media.selector.model.AlbumLoadDataModel;
import com.blued.android.module.media.selector.model.AlbumSelectInfo;
import com.blued.android.module.media.selector.model.GroupImageInfo;
import com.blued.android.module.media.selector.utils.ThumbLoader;
import com.blued.android.module.player.media.model.MediaInfo;
import java.io.Serializable;
import java.util.List;

public class AlbumBasePresenter extends MediaBasePresent<IAlbumBaseView> implements IAlbumBaseCallback, AlbumLoadDataModel.IAlbumLoadDataCallback {
  private static final String c = AlbumBasePresenter.class.getSimpleName();
  
  protected AlbumLoadDataModel a;
  
  public static List<MediaInfo> a(String paramString) {
    return AlbumDataManager.getGroupFileList(paramString);
  }
  
  public static void a(String paramString, List<MediaInfo> paramList) {
    AlbumDataManager.setCurrentList(paramString, paramList);
  }
  
  public static int b(MediaInfo paramMediaInfo) {
    return AlbumDataManager.removeSelectImage(paramMediaInfo);
  }
  
  public static int b(MediaInfo paramMediaInfo, int paramInt) {
    return AlbumDataManager.addSelectImage(paramMediaInfo, paramInt);
  }
  
  public static GroupImageInfo b(int paramInt) {
    return AlbumDataManager.getGroupListFileInfo(paramInt);
  }
  
  public static int m() {
    return AlbumDataManager.getMediaTypeVideo();
  }
  
  public static int n() {
    return AlbumDataManager.getGroupListSize();
  }
  
  public static void o() {
    AlbumDataManager.clearSelectImageList();
  }
  
  public int a(MediaInfo paramMediaInfo) {
    int i = b(paramMediaInfo);
    p().e();
    return i;
  }
  
  public Context a() {
    return p().getContext();
  }
  
  public MediaInfo a(int paramInt) {
    return AlbumDataManager.getVRChildImageInfo(paramInt);
  }
  
  public void a(int paramInt, MediaInfo paramMediaInfo) {
    if (p() != null && paramMediaInfo != null && !p().a(paramInt, paramMediaInfo))
      if (paramMediaInfo.media_type == m()) {
        if (AlbumDataManager.getSelectImageSize() <= 0) {
          AlbumPreviewBaseFragment.a(p().b(), null, paramInt, 1);
          return;
        } 
      } else {
        AlbumPreviewBaseFragment.a(p().b(), null, paramInt, 1);
      }  
  }
  
  public void a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent) {
    if (p() != null && !p().a(paramActivity, paramInt1, paramInt2, paramIntent) && paramInt1 == 1) {
      if (paramInt2 == -1) {
        a(paramIntent);
        return;
      } 
      if (p() != null)
        p().d(); 
    } 
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
      p().c();
    } 
  }
  
  public void a(Bundle paramBundle) {
    AlbumDataManager.clear();
    AlbumDataManager.setMaxSelectNum(p().S_());
    this.a = new AlbumLoadDataModel(p().getContext(), paramBundle, this);
  }
  
  public void a(boolean paramBoolean, String paramString) {
    if (p() != null && p().b() != null) {
      p().a(false);
      p().a(paramBoolean, paramString);
    } 
  }
  
  public boolean a(MediaInfo paramMediaInfo, int paramInt) {
    if (c() < p().S_()) {
      b(paramMediaInfo, paramInt);
      p().e();
      return true;
    } 
    AppMethods.a(String.format(p().getActivity().getResources().getString(R.string.foudation_media_max_select_num), new Object[] { Integer.valueOf(p().S_()) }));
    return false;
  }
  
  public int b() {
    return AlbumDataManager.getCurrentListSize();
  }
  
  public void b(Bundle paramBundle) {
    Bundle bundle = paramBundle;
    if (paramBundle == null)
      bundle = new Bundle(); 
    bundle.putSerializable("serializeble_data", (Serializable)AlbumDataManager.getAlbumSelectInfo());
  }
  
  public int c() {
    return AlbumDataManager.getSelectImageSize();
  }
  
  public boolean d() {
    return (c() >= p().S_());
  }
  
  public void e() {
    if (p() != null)
      p().a(true); 
  }
  
  public Activity f() {
    return (Activity)((p() != null) ? p().getActivity() : null);
  }
  
  public int g() {
    return (p() != null) ? p().i() : 3;
  }
  
  public long h() {
    return (p() != null) ? p().T_() : 2950L;
  }
  
  public long i() {
    return (p() != null) ? p().U_() : 60000L;
  }
  
  public void j() {
    AlbumLoadDataModel albumLoadDataModel = this.a;
    if (albumLoadDataModel != null)
      albumLoadDataModel.d(); 
    AlbumDataManager.clear();
    ThumbLoader.a().b();
  }
  
  public RecyclerView.Adapter k() {
    return (RecyclerView.Adapter)new AlbumBaseAdapter(this);
  }
  
  public void l() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\media\selector\present\AlbumBasePresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */