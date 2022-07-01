package com.soft.blued.ui.video.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.framework.utils.FileUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.media.selector.model.AlbumDataManager;
import com.blued.android.module.media.selector.model.AlbumSelectInfo;
import com.blued.android.module.media.selector.present.AlbumBasePresenter;
import com.blued.android.module.media.selector.present.MediaBasePresent;
import com.blued.android.module.player.media.model.MediaInfo;
import com.blued.das.client.feed.FeedProtos;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.feed.manager.SelectPhotoManager;
import com.soft.blued.ui.feed.model.ChildImageInfo;
import com.soft.blued.ui.feed.vm.FeedPostViewModel;
import com.soft.blued.ui.video.adapter.AlbumSelectHalfAdapter;
import com.soft.blued.ui.video.presenter.AlbumSelectHalfPresenter;
import com.soft.blued.utils.AppUtils;
import java.io.Serializable;
import java.util.List;

public class AlbumSelectHalfFragment extends AlbumSelectFragment {
  private FeedPostViewModel g;
  
  private OnClosePageListener h;
  
  private void G() {
    View view = s().findViewById(2131300279);
    if (view != null)
      view.setVisibility(8); 
  }
  
  public AlbumBasePresenter A() {
    return (AlbumBasePresenter)new AlbumSelectHalfPresenter();
  }
  
  public void a(float paramFloat) {
    if (s() == null)
      return; 
    s().setAlpha(paramFloat);
    if (paramFloat <= 0.0F) {
      s().setVisibility(4);
      return;
    } 
    s().setVisibility(0);
  }
  
  protected void a(int paramInt) {
    AlbumSelectPreviewFragment.b(b(), this.d, paramInt, 1);
  }
  
  public void a(OnClosePageListener paramOnClosePageListener) {
    this.h = paramOnClosePageListener;
  }
  
  public void a(boolean paramBoolean) {}
  
  public boolean a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramInt2 == -1) {
      if (paramInt1 != 1)
        switch (paramInt1) {
          default:
            return false;
          case 1000:
          case 1001:
          case 1002:
            break;
        }  
      if (paramIntent != null && paramIntent.getBooleanExtra("close_page", false)) {
        getActivity().setResult(-1, paramIntent);
        return true;
      } 
    } 
    return false;
  }
  
  public boolean a(AlbumSelectInfo paramAlbumSelectInfo) {
    b(paramAlbumSelectInfo);
    c();
    return true;
  }
  
  public void b(AlbumSelectInfo paramAlbumSelectInfo) {
    AlbumSelectInfo albumSelectInfo = new AlbumSelectInfo();
    albumSelectInfo.a(paramAlbumSelectInfo);
    this.g.z().setValue(albumSelectInfo);
    SelectPhotoManager.a().d();
    for (MediaInfo mediaInfo : albumSelectInfo.c()) {
      ChildImageInfo childImageInfo = new ChildImageInfo();
      if (AppUtils.b() && !TextUtils.isEmpty(mediaInfo.imgUri) && !AppUtils.b(mediaInfo.imagePath)) {
        String str = RecyclingUtils.e("photo");
        boolean bool = FileUtils.a(mediaInfo.imgUri, str);
        childImageInfo.mImagePath = str;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SaveSelectPhoto: ");
        stringBuilder.append(str);
        stringBuilder.append(" ");
        stringBuilder.append(bool);
        LogUtils.c(stringBuilder.toString());
      } else {
        childImageInfo.mImagePath = mediaInfo.imagePath;
      } 
      childImageInfo.width = mediaInfo.width;
      childImageInfo.height = mediaInfo.height;
      SelectPhotoManager.a().a(childImageInfo);
    } 
    this.g.D().setValue(Boolean.valueOf(true));
  }
  
  public void c() {
    OnClosePageListener onClosePageListener = this.h;
    if (onClosePageListener != null) {
      onClosePageListener.a();
      return;
    } 
    super.c();
  }
  
  public void c(Bundle paramBundle) {
    setArguments(paramBundle);
    k();
    if (this.e != null) {
      paramBundle = new Bundle();
      AlbumSelectInfo albumSelectInfo = new AlbumSelectInfo();
      albumSelectInfo.a((AlbumSelectInfo)this.g.z().getValue());
      paramBundle.putSerializable("serializeble_data", (Serializable)albumSelectInfo);
      ((AlbumBasePresenter)this.e).a(paramBundle);
    } 
    z();
    G();
    AlbumDataManager.setMaxSelectNum(S_());
  }
  
  public void e() {
    super.e();
    if (SelectPhotoManager.a().b() == 0 && AlbumDataManager.getAlbumSelectInfo().c().size() == 0)
      return; 
    if (this.g.C()) {
      EventTrackFeed.a(FeedProtos.Event.FEED_PUBLISH_HALF_SCREEN_PHOTO_CLICK);
      b(AlbumDataManager.getAlbumSelectInfo());
    } 
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent != null) {
      AlbumSelectInfo albumSelectInfo = (AlbumSelectInfo)paramIntent.getSerializableExtra("album_result_model");
      if (albumSelectInfo != null)
        b(albumSelectInfo); 
      if (paramIntent.getSerializableExtra("result_model") != null) {
        this.g.A().setValue(paramIntent);
      } else {
        this.g.A().setValue(null);
      } 
      c();
    } 
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.g = (FeedPostViewModel)(new ViewModelProvider(getActivity().getViewModelStore(), (ViewModelProvider.Factory)new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication()))).get(FeedPostViewModel.class);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.g.B().observe(getViewLifecycleOwner(), new Observer<String>(this) {
          public void a(String param1String) {
            try {
              AlbumSelectHalfAdapter albumSelectHalfAdapter = (AlbumSelectHalfAdapter)((RecyclerView)this.a.getView().findViewById(2131301733)).getAdapter();
              List<MediaInfo> list = AlbumDataManager.getCurrentList();
              for (int i = 0; i < list.size(); i++) {
                MediaInfo mediaInfo = list.get(i);
                if (TextUtils.equals(mediaInfo.imagePath, param1String)) {
                  AlbumDataManager.removeFromPath(param1String);
                  mediaInfo.isSelected = false;
                  albumSelectHalfAdapter.notifyItemChanged(i);
                  return;
                } 
              } 
              return;
            } catch (Exception exception) {
              return;
            } 
          }
        });
    return view;
  }
  
  public View q() {
    return null;
  }
  
  public View r() {
    return super.r();
  }
  
  public static interface OnClosePageListener {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\video\fragment\AlbumSelectHalfFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */