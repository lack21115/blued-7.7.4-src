package com.blued.android.module.shortvideo.presenter;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.base.user.UserProxy;
import com.blued.android.module.external_sense_library.utils.STLicenseUtils;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.contract.ITrimView;
import com.blued.android.module.shortvideo.fragment.EditFragment;
import com.blued.android.module.shortvideo.fragment.SaveVideoFragment;
import com.blued.android.module.shortvideo.model.CommonModel;
import com.blued.android.module.shortvideo.model.TrimDataModel;
import com.blued.android.module.shortvideo.utils.StvLogUtils;
import com.blued.android.module.shortvideo.utils.StvTools;
import com.blued.android.module.shortvideo.view.RangeSeekBar;
import com.qiniu.pili.droid.shortvideo.PLShortVideoTrimmer;
import com.qiniu.pili.droid.shortvideo.PLVideoSaveListener;
import java.io.File;
import java.io.Serializable;

public class TrimPresenter extends ShortVideoBasePresent<ITrimView> implements MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener {
  private static final String a = TrimPresenter.class.getSimpleName();
  
  private VideoView b;
  
  private PLShortVideoTrimmer c;
  
  private Bundle d;
  
  private TrimDataModel g;
  
  private boolean h;
  
  private final RangeSeekBar.OnRangeSeekBarChangeListener i = new RangeSeekBar.OnRangeSeekBarChangeListener(this) {
      public void a(RangeSeekBar param1RangeSeekBar, long param1Long1, long param1Long2, int param1Int, boolean param1Boolean, RangeSeekBar.Thumb param1Thumb) {
        double d;
        long l = TrimPresenter.a(this.a).getScrollMs();
        param1Long2 += TrimPresenter.a(this.a).getScrollMs();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TrimPresenter.q());
        stringBuilder.append(" bar.getWidth():");
        stringBuilder.append(param1RangeSeekBar.getWidth());
        StvLogUtils.a(stringBuilder.toString(), new Object[0]);
        TrimPresenter.a(this.a).setLeftProgress((param1Long1 + l));
        TrimDataModel trimDataModel = TrimPresenter.a(this.a);
        if (param1Long2 < TrimPresenter.a(this.a).getMinVideoDuration()) {
          d = TrimPresenter.a(this.a).getMinVideoDuration();
        } else {
          d = param1Long2;
        } 
        trimDataModel.setRightProgress(d);
        ITrimView iTrimView = this.a.D();
        if (param1Int != 0) {
          if (param1Int != 1) {
            if (param1Int != 2)
              return; 
            TrimPresenter.a(this.a, true);
            TrimPresenter trimPresenter = this.a;
            if (param1Thumb == RangeSeekBar.Thumb.a) {
              d = TrimPresenter.a(this.a).getLeftProgress();
            } else {
              d = TrimPresenter.a(this.a).getRightProgress();
            } 
            trimPresenter.b((int)d);
            if (iTrimView != null) {
              iTrimView.a(TrimPresenter.a(this.a).getRightProgress() - TrimPresenter.a(this.a).getLeftProgress());
              return;
            } 
          } else {
            TrimPresenter.a(this.a, false);
            if (iTrimView != null)
              iTrimView.a(TrimPresenter.a(this.a).getRightProgress() - TrimPresenter.a(this.a).getLeftProgress()); 
            TrimPresenter trimPresenter = this.a;
            trimPresenter.a((int)TrimPresenter.a(trimPresenter).getLeftProgress());
            return;
          } 
        } else {
          TrimPresenter.a(this.a, false);
          this.a.l();
        } 
      }
    };
  
  private final RecyclerView.OnScrollListener j = new RecyclerView.OnScrollListener(this) {
      private int b = 0;
      
      public void onScrollStateChanged(RecyclerView param1RecyclerView, int param1Int) {
        super.onScrollStateChanged(param1RecyclerView, param1Int);
        this.b = param1Int;
        if (param1Int == 0) {
          TrimPresenter.a(this.a, false);
          this.a.j();
          return;
        } 
        TrimPresenter.a(this.a, true);
        if (this.a.k())
          this.a.l(); 
      }
      
      public void onScrolled(RecyclerView param1RecyclerView, int param1Int1, int param1Int2) {
        long l1;
        long l2;
        super.onScrolled(param1RecyclerView, param1Int1, param1Int2);
        if (this.b == 0)
          return; 
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager)param1RecyclerView.getLayoutManager();
        param1Int1 = linearLayoutManager.findFirstVisibleItemPosition();
        View view = linearLayoutManager.findViewByPosition(param1Int1);
        param1Int1 = param1Int1 * view.getWidth() - view.getLeft();
        if (this.a.k())
          this.a.l(); 
        TrimPresenter.a(this.a, true);
        ITrimView iTrimView = this.a.D();
        if (iTrimView != null) {
          l1 = iTrimView.d();
          l2 = iTrimView.e();
        } else {
          l1 = 0L;
          l2 = l1;
        } 
        if (param1Int1 == -TrimPresenter.a(this.a).getMarginSize()) {
          TrimPresenter.a(this.a).setScrollMs(0L);
          TrimPresenter.a(this.a).setLeftProgress(l1);
        } else {
          TrimPresenter.a(this.a).setScrollMs((long)(TrimPresenter.a(this.a).getAveragePxMs() * param1Int1));
          TrimPresenter.a(this.a).setLeftProgress((l1 + TrimPresenter.a(this.a).getScrollMs()));
        } 
        TrimPresenter.a(this.a).setRightProgress((l2 + TrimPresenter.a(this.a).getScrollMs()));
        TrimPresenter trimPresenter = this.a;
        trimPresenter.b((int)TrimPresenter.a(trimPresenter).getLeftProgress());
      }
    };
  
  public TrimPresenter(Bundle paramBundle) {
    this.d = paramBundle;
  }
  
  private void b(View paramView, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a);
    stringBuilder.append(" 剪切视频，视频地址: ");
    stringBuilder.append(this.g.getVideoPath());
    stringBuilder.append(" 剪切范围: ");
    stringBuilder.append(o());
    stringBuilder.append(" - ");
    stringBuilder.append(p());
    StvLogUtils.a(stringBuilder.toString(), new Object[0]);
    this.c.trim((long)o(), (long)p(), PLShortVideoTrimmer.TRIM_MODE.FAST, new PLVideoSaveListener(this, paramView, paramInt) {
          public void onProgressUpdate(float param1Float) {
            if (this.c.D() == null || this.c.D().getActivity() == null || this.c.D().getActivity().isFinishing()) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(TrimPresenter.q());
              stringBuilder.append(" getView() == null!!!");
              StvLogUtils.a(stringBuilder.toString(), new Object[0]);
              return;
            } 
            this.c.D().a_(new Runnable(this, param1Float) {
                  public void run() {
                    this.b.c.D().a(this.a);
                  }
                });
          }
          
          public void onSaveVideoCanceled() {
            if (this.c.D() == null || this.c.D().getActivity() == null || this.c.D().getActivity().isFinishing()) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(TrimPresenter.q());
              stringBuilder.append(" getView() == null!!!");
              StvLogUtils.a(stringBuilder.toString(), new Object[0]);
              return;
            } 
            this.c.D().a_(new Runnable(this) {
                  public void run() {
                    this.a.a.setEnabled(true);
                    this.a.c.D().c(false);
                  }
                });
          }
          
          public void onSaveVideoFailed(int param1Int) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(TrimPresenter.q());
            stringBuilder.append(" 视频剪切失败, error code: ");
            stringBuilder.append(param1Int);
            StvLogUtils.a(stringBuilder.toString(), new Object[0]);
            if (param1Int == 16) {
              stringBuilder = new StringBuilder();
              stringBuilder.append(TrimPresenter.q());
              stringBuilder.append(" 视频剪切，当前机型暂不支持该功能");
              StvLogUtils.a(stringBuilder.toString(), new Object[0]);
            } 
            if (this.c.D() == null || this.c.D().getActivity() == null || this.c.D().getActivity().isFinishing()) {
              stringBuilder = new StringBuilder();
              stringBuilder.append(TrimPresenter.q());
              stringBuilder.append(" getView() == null!!!");
              StvLogUtils.a(stringBuilder.toString(), new Object[0]);
              return;
            } 
            this.c.D().a_(new Runnable(this) {
                  public void run() {
                    this.a.a.setEnabled(true);
                    this.a.c.D().c(false);
                    StvLogUtils.a(R.string.common_net_error);
                  }
                });
          }
          
          public void onSaveVideoSuccess(String param1String) {
            StringBuilder stringBuilder;
            if (this.c.D() == null || this.c.D().getActivity() == null || this.c.D().getActivity().isFinishing()) {
              stringBuilder = new StringBuilder();
              stringBuilder.append(TrimPresenter.q());
              stringBuilder.append(" getView() == null!!!");
              StvLogUtils.a(stringBuilder.toString(), new Object[0]);
              return;
            } 
            this.c.D().a_(new Runnable(this, (String)stringBuilder) {
                  public void run() {
                    this.b.a.setEnabled(true);
                    this.b.c.D().ab_();
                    this.b.c.D().c(false);
                    CommonModel commonModel = new CommonModel();
                    commonModel.copyModel((CommonModel)TrimPresenter.a(this.b.c));
                    commonModel.setVideoPath(this.a);
                    if (TrimPresenter.a(this.b.c).getVideoPath().equals(this.a) || this.a.equals(TrimPresenter.a(this.b.c).getOriginalVideoPath()))
                      commonModel.setCanDeleteVideoFile(false); 
                    commonModel.setCurrentPage(3);
                    if (commonModel.getFrom() == 60) {
                      Bundle bundle = new Bundle();
                      bundle.putSerializable("commont_model", (Serializable)commonModel);
                      SaveVideoFragment.a(this.b.c.D().a(), bundle, commonModel.getFrom(), this.b.b);
                      return;
                    } 
                    EditFragment.a(this.b.c.D().a(), commonModel, 2);
                  }
                });
          }
        });
  }
  
  public void a() {
    boolean bool;
    StringBuilder stringBuilder2;
    Bundle bundle = this.d;
    if (bundle == null) {
      bundle = D().getArguments();
      bool = false;
    } else {
      bool = true;
    } 
    if (bundle == null) {
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(a);
      stringBuilder2.append("TrimPresenter bundle == null!!!");
      StvLogUtils.a(stringBuilder2.toString(), new Object[0]);
      AppMethods.d(R.string.common_net_error);
      D().getActivity().finish();
      return;
    } 
    if (!STLicenseUtils.a(D().getContext())) {
      AppMethods.a("请检查License授权！");
      D().getActivity().finish();
      return;
    } 
    CommonModel commonModel = (CommonModel)stringBuilder2.getSerializable("commont_model");
    if (!(new File(commonModel.getVideoPath())).exists()) {
      StvLogUtils.a("TrimPresenter commonModel 视频文件不存在！！！", new Object[0]);
      AppMethods.d(R.string.common_net_error);
      D().getActivity().finish();
      return;
    } 
    TrimDataModel.SerializableData serializableData = (TrimDataModel.SerializableData)stringBuilder2.getSerializable("serializeble_data");
    this.g = new TrimDataModel();
    this.g.copyModel(commonModel, serializableData);
    this.g.setUseData(Boolean.valueOf(bool));
    String str = UserProxy.b().a();
    if (!TextUtils.isEmpty(str) && (str.equals(String.valueOf(2)) || str.equals(String.valueOf(3))))
      this.g.setPrivilegeUser(true); 
    if (this.g.isPrivilegeUser()) {
      this.g.setMaxVideoDuration(300000L);
    } else {
      this.g.setMaxVideoDuration(60000L);
    } 
    this.b = D().b();
    int j = this.g.getVideoWidth();
    int k = this.g.getVideoHeight();
    int i = (D().getContext().getResources().getDisplayMetrics()).widthPixels;
    j = (int)(i * 1.0F / j * k);
    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
    layoutParams.width = i;
    layoutParams.height = j;
    this.b.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.b.setVideoPath(this.g.getVideoPath());
    this.b.setOnPreparedListener(this);
    this.b.setOnCompletionListener(this);
    this.c = new PLShortVideoTrimmer(D().getContext(), this.g.getVideoPath(), StvTools.d());
    D().a(this.g);
    D().a(this.i);
    D().a(this.j);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(a);
    stringBuilder1.append("video duration: ");
    stringBuilder1.append(this.g.getDurationMs());
    StvLogUtils.a(stringBuilder1.toString(), new Object[0]);
  }
  
  public void a(int paramInt) {
    b(paramInt);
    if (paramInt == 0) {
      j();
      return;
    } 
    VideoView videoView = this.b;
    if (videoView != null) {
      videoView.start();
      ITrimView iTrimView = D();
      if (iTrimView != null)
        iTrimView.c(paramInt); 
    } 
  }
  
  public void a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramInt2 == -1) {
      paramInt2 = 0;
      if (paramIntent == null || paramIntent.getBooleanExtra("close_page", false))
        paramInt2 = 1; 
      if (paramInt1 == 2 && paramInt2 != 0) {
        Intent intent = paramIntent;
        if (paramIntent == null)
          intent = new Intent(); 
        intent.putExtra("close_page", true);
        paramActivity.setResult(-1, intent);
        paramActivity.finish();
      } 
    } 
  }
  
  public void a(Bundle paramBundle) {}
  
  public void a(View paramView, int paramInt) {
    m();
    b(paramView, paramInt);
  }
  
  public void b() {
    m();
    TrimDataModel trimDataModel = this.g;
    if (trimDataModel != null)
      trimDataModel.clear(); 
    PLShortVideoTrimmer pLShortVideoTrimmer = this.c;
    if (pLShortVideoTrimmer != null)
      pLShortVideoTrimmer.destroy(); 
  }
  
  public void b(int paramInt) {
    if (this.b == null)
      return; 
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("var1");
    stringBuilder.append(paramInt);
    Logger.c(str, new Object[] { stringBuilder.toString() });
    this.b.seekTo(paramInt);
  }
  
  public void c() {
    a((int)n());
  }
  
  public void d() {}
  
  public void e() {
    l();
  }
  
  public void f() {}
  
  public boolean g() {
    return false;
  }
  
  public CommonModel h() {
    return (CommonModel)this.g;
  }
  
  public TrimDataModel.SerializableData i() {
    return this.g.getSerializableData();
  }
  
  public void j() {
    VideoView videoView = this.b;
    if (videoView != null) {
      videoView.start();
      ITrimView iTrimView = D();
      if (iTrimView != null)
        iTrimView.c(0); 
    } 
  }
  
  public boolean k() {
    VideoView videoView = this.b;
    return (videoView == null) ? false : videoView.isPlaying();
  }
  
  public void l() {
    VideoView videoView = this.b;
    if (videoView == null)
      return; 
    videoView.pause();
    ITrimView iTrimView = D();
    if (iTrimView != null)
      iTrimView.ag_(); 
    this.h = false;
  }
  
  public void m() {
    VideoView videoView = this.b;
    if (videoView == null)
      return; 
    videoView.stopPlayback();
    ITrimView iTrimView = D();
    if (iTrimView != null)
      iTrimView.ag_(); 
    this.h = false;
  }
  
  public long n() {
    return this.g.getSelectedBeginMs();
  }
  
  public double o() {
    return this.g.getLeftProgress();
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer) {
    VideoView videoView = this.b;
    if (videoView != null)
      videoView.seekTo((int)this.g.getLeftProgress()); 
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer) {
    paramMediaPlayer.seekTo((int)this.g.getLeftProgress());
    paramMediaPlayer.setOnSeekCompleteListener(this);
  }
  
  public void onSeekComplete(MediaPlayer paramMediaPlayer) {
    boolean bool = this.h;
  }
  
  public double p() {
    return this.g.getRightProgress();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\presenter\TrimPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */