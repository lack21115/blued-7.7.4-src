package com.soft.blued.ui.video.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.module.base.shortvideo.ShortVideoProxy;
import com.blued.android.module.base.shortvideo.StvResultModel;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.player.audio.IAudioPlayer;
import com.blued.android.module.player.audio.TXVodAudioPlayer;
import com.blued.android.module.shortvideo.utils.StvLogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.google.android.material.appbar.AppBarLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.FloatFooterView;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.customview.SpacesItemDecoration;
import com.soft.blued.customview.smartrefresh.BluedAdapterLoadMoreView;
import com.soft.blued.ui.feed.fragment.FeedPostFragment;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.video.adapter.MusicVideoCollectAdapter;
import com.soft.blued.ui.video.manager.MusicManager;
import com.soft.blued.ui.video.model.VideoScanMusic;
import com.soft.blued.ui.video.presenter.MusicVideoCollectPresent;
import com.soft.blued.ui.video.view.CustomProgressDialog;
import java.io.Serializable;
import java.util.List;

public class MusicVideoCollectFragment extends MvpFragment<MusicVideoCollectPresent> {
  @BindView(2131296447)
  AppBarLayout appbar;
  
  @BindView(2131296843)
  CoordinatorLayout coordinator;
  
  private IAudioPlayer d;
  
  private MusicVideoCollectAdapter e;
  
  private NoDataAndLoadFailView f;
  
  private ProgressDialog g;
  
  private boolean h = false;
  
  private int i;
  
  @BindView(2131297732)
  ImageView ivCollection;
  
  @BindView(2131297866)
  ImageView ivMusicAuthor;
  
  @BindView(2131297868)
  ImageView ivMusicBg;
  
  @BindView(2131297869)
  ImageView ivMusicPlay;
  
  @BindView(2131298072)
  FrameLayout layoutMusic;
  
  @BindView(2131298800)
  FloatFooterView llFeedPost;
  
  @BindView(2131299605)
  RecyclerView recyclerView;
  
  @BindView(2131299616)
  SmartRefreshLayout refreshLayout;
  
  @BindView(2131299975)
  ShapeLinearLayout sllCollection;
  
  @BindView(2131300300)
  CommonTopTitleNoTrans topTitle;
  
  @BindView(2131300648)
  TextView tvCollection;
  
  @BindView(2131301066)
  TextView tvMusicAuthor;
  
  @BindView(2131301068)
  TextView tvMusicName;
  
  public static void a(Context paramContext, VideoScanMusic paramVideoScanMusic) {
    if (paramVideoScanMusic == null)
      return; 
    Bundle bundle = new Bundle();
    bundle.putSerializable("video_scan_music", (Serializable)paramVideoScanMusic);
    TerminalActivity.d(paramContext, MusicVideoCollectFragment.class, bundle);
  }
  
  private void b(boolean paramBoolean) {
    this.refreshLayout.g();
    if (paramBoolean) {
      this.e.l();
    } else {
      this.e.m();
    } 
    if (this.e.n().size() <= 0) {
      if (paramBoolean) {
        this.f.a();
        return;
      } 
      this.f.b();
    } 
  }
  
  private void k() {
    if (!this.h) {
      l();
      return;
    } 
    m();
  }
  
  private void l() {
    this.ivMusicPlay.setImageResource(2131234406);
    MusicManager.a(this.d, (((MusicVideoCollectPresent)s()).p()).music_url, (((MusicVideoCollectPresent)s()).p()).music_id);
    this.h = true;
  }
  
  private void m() {
    this.ivMusicPlay.setImageResource(2131234407);
    MusicManager.a(this.d);
    this.h = false;
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    this.d = (IAudioPlayer)new TXVodAudioPlayer();
    this.g = (ProgressDialog)new CustomProgressDialog(getContext());
    this.g.setCanceledOnTouchOutside(true);
    this.topTitle.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.C();
          }
        });
    this.recyclerView.setLayoutManager((RecyclerView.LayoutManager)new GridLayoutManager(getContext(), 3));
    this.e = new MusicVideoCollectAdapter(getContext(), (IRequestHost)w_());
    this.recyclerView.setAdapter((RecyclerView.Adapter)this.e);
    SpacesItemDecoration spacesItemDecoration = new SpacesItemDecoration(DensityUtils.a(getContext(), 1.5F));
    spacesItemDecoration.a(5);
    spacesItemDecoration.a(true, true, true, true);
    spacesItemDecoration.a(0, 0, 0, 0);
    this.recyclerView.addItemDecoration((RecyclerView.ItemDecoration)spacesItemDecoration);
    this.f = new NoDataAndLoadFailView(getContext());
    this.f.setNoDataImg(2131232640);
    this.f.setNoDataStr(2131758231);
    this.e.e((View)this.f);
    this.llFeedPost.setOnBtnClickListener(new FloatFooterView.OnBtnClickListener(this) {
          public void onPostFeedClick() {
            ProgressDialog progressDialog = MusicVideoCollectFragment.a(this.a);
            MusicVideoCollectFragment musicVideoCollectFragment = this.a;
            MusicManager.a(progressDialog, (BaseFragment)musicVideoCollectFragment, (((MusicVideoCollectPresent)musicVideoCollectFragment.s()).p()).music_url, (((MusicVideoCollectPresent)this.a.s()).p()).music_id, new MusicManager.ICallBack(this) {
                  public void a(String param2String) {
                    ShortVideoProxy.e().a(this.a.a, 6, param2String, (((MusicVideoCollectPresent)this.a.a.s()).p()).music_name, 209);
                  }
                });
          }
        });
    this.llFeedPost.a(DensityUtils.a(getContext(), 155.0F), DensityUtils.a(getContext(), 40.0F));
    this.llFeedPost.setBtnBackgroundColor(2131100331);
    this.llFeedPost.setBtnIconImageDrawable(BluedSkinUtils.b(getContext(), 2131233466));
    this.llFeedPost.setBtnText(2131758149);
    this.refreshLayout.b(false);
    this.refreshLayout.a(new OnRefreshListener(this) {
          public void onRefresh(RefreshLayout param1RefreshLayout) {
            ((MusicVideoCollectPresent)this.a.s()).e();
          }
        });
    this.e.a((LoadMoreView)new BluedAdapterLoadMoreView());
    this.e.a(new BaseQuickAdapter.RequestLoadMoreListener(this) {
          public void onLoadMoreRequested() {
            ((MusicVideoCollectPresent)this.a.s()).f();
          }
        },  this.recyclerView);
    this.appbar.a(new -$$Lambda$MusicVideoCollectFragment$mGa8Mrpe_tNRB_9VadJKV0GjPQc(this));
  }
  
  protected void a(VideoScanMusic paramVideoScanMusic) {
    ImageLoader.a((IRequestHost)w_(), AvatarUtils.a(3, paramVideoScanMusic.music_cover)).a(2131234356).a(6.0F).a(this.ivMusicBg);
    this.tvMusicName.setText(paramVideoScanMusic.music_name);
    this.tvMusicAuthor.setText(paramVideoScanMusic.music_singer);
    if (paramVideoScanMusic.i_star == 1) {
      ShapeHelper.b((ShapeHelper.ShapeView)this.sllCollection, 2131100716);
      this.ivCollection.setImageDrawable(BluedSkinUtils.b(getContext(), 2131232445));
      this.tvCollection.setTextColor(getContext().getResources().getColor(2131100792));
    } else {
      ShapeHelper.b((ShapeHelper.ShapeView)this.sllCollection, 2131100793);
      this.ivCollection.setImageDrawable(BluedSkinUtils.b(getContext(), 2131232447));
      this.tvCollection.setTextColor(BluedSkinUtils.a(getContext(), 2131100806));
    } 
    this.e.a(paramVideoScanMusic.main_tid);
  }
  
  public void a(String paramString, boolean paramBoolean) {
    super.a(paramString, paramBoolean);
    if (paramString == null)
      return; 
    byte b = -1;
    int i = paramString.hashCode();
    if (i != -1290256561) {
      if (i == 623698297 && paramString.equals("_load_type_loadmore_"))
        b = 1; 
    } else if (paramString.equals("_load_type_refresh_")) {
      b = 0;
    } 
    if (b != 0 && b != 1)
      return; 
    b(paramBoolean);
  }
  
  protected void a(List<BluedIngSelfFeed> paramList) {
    this.e.c(paramList);
  }
  
  public void aL_() {
    super.aL_();
    this.f = null;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1 && paramInt1 == 209 && paramIntent != null) {
      StvResultModel stvResultModel = (StvResultModel)paramIntent.getSerializableExtra("result_model");
      if (stvResultModel != null) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("@@@@ ");
        stringBuilder.append(stvResultModel.toString());
        StvLogUtils.d(stringBuilder.toString(), new Object[0]);
        if (stvResultModel.a())
          FeedPostFragment.a(getContext(), stvResultModel); 
      } 
    } 
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onDestroy() {
    super.onDestroy();
    IAudioPlayer iAudioPlayer = this.d;
    if (iAudioPlayer != null)
      iAudioPlayer.b(); 
  }
  
  public void onPause() {
    super.onPause();
    if (this.d != null)
      m(); 
  }
  
  @OnClick({2131297868, 2131301066, 2131297866, 2131299975})
  public void onViewClicked(View paramView) {
    switch (paramView.getId()) {
      default:
        return;
      case 2131299975:
        ((MusicVideoCollectPresent)s()).m();
        return;
      case 2131297868:
        k();
        return;
      case 2131297866:
      case 2131301066:
        break;
    } 
    UserInfoFragmentNew.a(getContext(), (((MusicVideoCollectPresent)s()).p()).music_uid, "PAGE_MUSIC_VIDEO_COLLECT");
  }
  
  public int p() {
    return 2131493240;
  }
  
  public void u() {
    this.refreshLayout.i();
  }
  
  public void x() {
    super.x();
  }
  
  public void y() {
    super.y();
    this.e.c(false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\video\fragment\MusicVideoCollectFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */