package com.soft.blued.ui.video.fragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.module.player.audio.IAudioPlayer;
import com.blued.android.module.player.audio.TXVodAudioPlayer;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.google.android.material.appbar.AppBarLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.customview.SearchView;
import com.soft.blued.customview.smartrefresh.BluedAdapterLoadMoreView;
import com.soft.blued.ui.video.adapter.MyMusicCollectionAdapter;
import com.soft.blued.ui.video.manager.MusicManager;
import com.soft.blued.ui.video.model.VideoScanMusic;
import com.soft.blued.ui.video.presenter.MyMusicCollectionPresent;
import com.soft.blued.ui.video.view.CustomProgressDialog;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.util.List;

public class MyMusicCollectionFragment extends MvpFragment<MyMusicCollectionPresent> {
  @BindView(2131296447)
  AppBarLayout appbar;
  
  @BindView(2131296843)
  CoordinatorLayout coordinator;
  
  private IAudioPlayer d;
  
  private MyMusicCollectionAdapter e;
  
  private NoDataAndLoadFailView f;
  
  private ProgressDialog g;
  
  @BindView(2131298072)
  ConstraintLayout layoutMusic;
  
  @BindView(2131299605)
  RecyclerView recyclerView;
  
  @BindView(2131299616)
  SmartRefreshLayout refreshLayout;
  
  @BindView(2131299730)
  LinearLayout rlSquare;
  
  @BindView(2131299874)
  SearchView searchView;
  
  @BindView(2131300300)
  CommonTopTitleNoTrans topTitle;
  
  @BindView(2131301076)
  TextView tvMyCollection;
  
  private void a(int paramInt) {
    CommonAlertDialog.a(getContext(), getContext().getResources().getString(2131756094), getContext().getResources().getString(2131758144), getContext().getResources().getString(2131756086), new DialogInterface.OnClickListener(this, paramInt) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            VideoScanMusic videoScanMusic = MyMusicCollectionFragment.a(this.b).n().get(this.a);
            ((MyMusicCollectionPresent)this.b.s()).d(videoScanMusic.music_id);
            MyMusicCollectionFragment.a(this.b).d(this.a);
          }
        }getContext().getResources().getString(2131756057), null, null);
  }
  
  public static void a(Fragment paramFragment, int paramInt) {
    TerminalActivity.a(paramFragment, MyMusicCollectionFragment.class, null, paramInt);
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
  
  private void c(String paramString) {
    Intent intent = new Intent();
    intent.putExtra("music_file_path", paramString);
    getActivity().setResult(-1, intent);
    getActivity().finish();
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
    this.recyclerView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(getContext()));
    this.e = new MyMusicCollectionAdapter(getContext(), (IRequestHost)w_());
    this.recyclerView.setAdapter((RecyclerView.Adapter)this.e);
    this.f = new NoDataAndLoadFailView(getContext());
    this.f.setNoDataImg(2131232640);
    this.f.setNoDataStr(2131758231);
    this.e.e((View)this.f);
    this.e.a(new BaseQuickAdapter.OnItemChildClickListener(this) {
          public void onItemChildClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
            VideoScanMusic videoScanMusic = MyMusicCollectionFragment.a(this.a).n().get(param1Int);
            int i = param1View.getId();
            if (i != 2131297732) {
              ProgressDialog progressDialog;
              if (i != 2131298054) {
                if (i != 2131300126)
                  return; 
                progressDialog = MyMusicCollectionFragment.b(this.a);
                MyMusicCollectionFragment myMusicCollectionFragment = this.a;
                MusicManager.a(progressDialog, (BaseFragment)myMusicCollectionFragment, ((VideoScanMusic)MyMusicCollectionFragment.a(myMusicCollectionFragment).n().get(param1Int)).music_url, ((VideoScanMusic)MyMusicCollectionFragment.a(this.a).n().get(param1Int)).music_id, new MusicManager.ICallBack(this) {
                      public void a(String param2String) {
                        MyMusicCollectionFragment.a(this.a.a, param2String);
                      }
                    });
                return;
              } 
              if (!((VideoScanMusic)progressDialog).isPlaying) {
                MyMusicCollectionFragment.a(this.a).a((VideoScanMusic)progressDialog);
                MusicManager.a(MyMusicCollectionFragment.c(this.a), ((VideoScanMusic)progressDialog).music_url, ((VideoScanMusic)progressDialog).music_id);
                return;
              } 
              MyMusicCollectionFragment.a(this.a).a();
              MusicManager.a(MyMusicCollectionFragment.c(this.a));
              return;
            } 
            MyMusicCollectionFragment.a(this.a, param1Int);
          }
        });
    this.refreshLayout.b(false);
    this.refreshLayout.a(new OnRefreshListener(this) {
          public void onRefresh(RefreshLayout param1RefreshLayout) {
            MusicManager.a(MyMusicCollectionFragment.c(this.a));
            ((MyMusicCollectionPresent)this.a.s()).e();
          }
        });
    this.e.a((LoadMoreView)new BluedAdapterLoadMoreView());
    this.e.a(new BaseQuickAdapter.RequestLoadMoreListener(this) {
          public void onLoadMoreRequested() {
            ((MyMusicCollectionPresent)this.a.s()).f();
          }
        },  this.recyclerView);
    this.searchView.setOnSearchInfoListener(new SearchView.OnSearchInfoListener(this) {
          public void a() {
            KeyboardUtils.a((Activity)this.a.getActivity());
          }
          
          public void a(String param1String) {
            ((MyMusicCollectionPresent)this.a.s()).e(param1String);
            ((MyMusicCollectionPresent)this.a.s()).e();
          }
          
          public void b() {}
        });
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
  
  protected void a(List<VideoScanMusic> paramList) {
    this.e.c(paramList);
  }
  
  public void aL_() {
    super.aL_();
    this.f = null;
  }
  
  public void onDestroy() {
    super.onDestroy();
    IAudioPlayer iAudioPlayer = this.d;
    if (iAudioPlayer != null)
      iAudioPlayer.b(); 
  }
  
  public void onPause() {
    super.onPause();
    if (this.d != null) {
      MyMusicCollectionAdapter myMusicCollectionAdapter = this.e;
      if (myMusicCollectionAdapter != null) {
        myMusicCollectionAdapter.a();
        MusicManager.a(this.d);
      } 
    } 
  }
  
  public int p() {
    return 2131493245;
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\video\fragment\MyMusicCollectionFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */