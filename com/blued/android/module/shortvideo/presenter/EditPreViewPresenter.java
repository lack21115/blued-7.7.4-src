package com.blued.android.module.shortvideo.presenter;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.blued.android.core.AppMethods;
import com.blued.android.module.base.shortvideo.StvResultModel;
import com.blued.android.module.external_sense_library.manager.SenseTimeFactory;
import com.blued.android.module.external_sense_library.manager.SenseTimeQiniuEditVideoManager;
import com.blued.android.module.external_sense_library.utils.STLicenseUtils;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.contract.IBaseView;
import com.blued.android.module.shortvideo.contract.IStvVideoFrameForTimeCallback;
import com.blued.android.module.shortvideo.model.CommonModel;
import com.blued.android.module.shortvideo.model.EditDataModel;
import com.blued.android.module.shortvideo.model.FilterItem;
import com.blued.android.module.shortvideo.utils.StvLogUtils;
import com.blued.android.module.shortvideo.utils.StvTools;
import com.qiniu.pili.droid.shortvideo.PLDisplayMode;
import com.qiniu.pili.droid.shortvideo.PLShortVideoEditor;
import com.qiniu.pili.droid.shortvideo.PLVideoEditSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoFilterListener;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

public class EditPreViewPresenter extends ShortVideoBasePresent<IBaseView> {
  private static final String b = EditPreViewPresenter.class.getSimpleName();
  
  PLVideoFilterListener a = new PLVideoFilterListener(this) {
      public int onDrawFrame(int param1Int1, int param1Int2, int param1Int3, long param1Long, float[] param1ArrayOffloat) {
        return EditPreViewPresenter.c(this.a).drawFrame(param1Int1, param1Int2, param1Int3, false);
      }
      
      public void onSurfaceChanged(int param1Int1, int param1Int2) {
        EditPreViewPresenter.c(this.a).adjustViewPort(param1Int1, param1Int2);
      }
      
      public void onSurfaceCreated() {
        EditPreViewPresenter.c(this.a).onSurfaceCreated();
      }
      
      public void onSurfaceDestroy() {
        EditPreViewPresenter.c(this.a).onSurfaceDestroyed();
      }
    };
  
  private PLShortVideoEditor c;
  
  private SenseTimeQiniuEditVideoManager d;
  
  private Bundle g;
  
  private EditDataModel h;
  
  public EditPreViewPresenter(Bundle paramBundle) {
    this.g = paramBundle;
  }
  
  private void a(FilterItem paramFilterItem, int paramInt) {
    if (paramFilterItem != null) {
      if (paramFilterItem.b() != null) {
        this.d.setFilterStyle(paramFilterItem.b());
        return;
      } 
      this.d.setFilterStyle(null);
    } 
  }
  
  private void s() {
    if (D() != null)
      AppMethods.d(R.string.common_net_error); 
  }
  
  private void t() {
    this.d = (SenseTimeQiniuEditVideoManager)SenseTimeFactory.createInstance(D().getContext(), 2);
    this.d.enableBeautify(false);
  }
  
  private void u() {
    IBaseView iBaseView = D();
    if (iBaseView != null) {
      Intent intent = new Intent();
      StvResultModel stvResultModel = new StvResultModel();
      stvResultModel.a(true);
      stvResultModel.b(this.h.getCoverImgPath());
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(b);
      stringBuilder.append(" coverImagePath = ");
      stringBuilder.append(this.h.getCoverImgPath());
      StvLogUtils.a(stringBuilder.toString(), new Object[0]);
      stvResultModel.c(this.h.getSaveVideoPath());
      stvResultModel.a(this.h.getSaveVideoWidth());
      stvResultModel.b(this.h.getSaveVideoHeight());
      stvResultModel.a(this.h.getSaveDurationMs());
      stvResultModel.b(this.h.getVideoSize());
      stvResultModel.d(this.h.getSerializableData().getMusicId());
      stvResultModel.c(this.h.getSerializableData().getSelectFilterPosition());
      if (q() == 1 || q() == 61 || q() == 7)
        stvResultModel.b(r()); 
      intent.putExtra("result_model", (Serializable)stvResultModel);
      intent.putExtra("close_page", true);
      intent.putExtra("serializeble_data", (Serializable)this.h.getSerializableData());
      iBaseView.getActivity().setResult(-1, intent);
      iBaseView.getActivity().finish();
    } 
  }
  
  public void a() {
    IBaseView iBaseView = D();
    if (iBaseView != null) {
      File file;
      Bundle bundle2 = this.g;
      Bundle bundle1 = bundle2;
      if (bundle2 == null)
        bundle1 = iBaseView.getArguments(); 
      if (bundle1 == null) {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(b);
        stringBuilder1.append("EditPresenter bundle == null!!!");
        StvLogUtils.a(stringBuilder1.toString(), new Object[0]);
        s();
        iBaseView.getActivity().finish();
        return;
      } 
      if (!STLicenseUtils.a(D().getContext())) {
        AppMethods.a("请检查License授权！");
        D().getActivity().finish();
        return;
      } 
      EditDataModel.SerializableData serializableData = (EditDataModel.SerializableData)stringBuilder1.getSerializable("serializeble_data");
      CommonModel commonModel = (CommonModel)stringBuilder1.getSerializable("commont_model");
      if ((serializableData == null || TextUtils.isEmpty(serializableData.getVideoPath())) && (commonModel == null || TextUtils.isEmpty(commonModel.getVideoPath()))) {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(b);
        stringBuilder1.append("EditPresenter commonModel 数据错误！！！");
        StvLogUtils.a(stringBuilder1.toString(), new Object[0]);
        s();
        iBaseView.getActivity().finish();
        return;
      } 
      StringBuilder stringBuilder1 = null;
      if (serializableData != null) {
        file = new File(serializableData.getVideoPath());
      } else if (commonModel != null) {
        file = new File(commonModel.getVideoPath());
      } 
      if (file == null || !file.exists()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(b);
        stringBuilder.append("EditPresenter commonModel 视频文件不存在！！！");
        StvLogUtils.a(stringBuilder.toString(), new Object[0]);
        s();
        iBaseView.getActivity().finish();
        return;
      } 
      this.h = new EditDataModel();
      if (commonModel != null)
        this.h.copyModel(commonModel, serializableData); 
      if (serializableData != null)
        this.h.getSerializableData().a(serializableData); 
      this.h.setScreenWidth((iBaseView.getContext().getResources().getDisplayMetrics()).widthPixels);
      this.h.getSerializableData().setUseData(Boolean.valueOf(true));
      String str = this.h.getSerializableData().getVideoPath();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(b);
      stringBuilder2.append("editing file: ");
      stringBuilder2.append(str);
      StvLogUtils.a(stringBuilder2.toString(), new Object[0]);
      this.h.setMediaFile(str);
      int j = this.h.getVideoWidth();
      int k = this.h.getVideoHeight();
      int i = (iBaseView.getContext().getResources().getDisplayMetrics()).widthPixels;
      j = (int)(i * 1.0F / j * k);
      ViewGroup.LayoutParams layoutParams = iBaseView.a().getLayoutParams();
      layoutParams.width = i;
      layoutParams.height = j;
      iBaseView.a().setLayoutParams(layoutParams);
      PLVideoEditSetting pLVideoEditSetting = new PLVideoEditSetting();
      pLVideoEditSetting.setSourceFilepath(str);
      pLVideoEditSetting.setDestFilepath(StvTools.c());
      this.c = new PLShortVideoEditor(iBaseView.a(), pLVideoEditSetting);
      this.c.setDisplayMode(PLDisplayMode.FULL);
      c(false);
      try {
        AssetFileDescriptor assetFileDescriptor = iBaseView.getActivity().getAssets().openFd("silent_audio.mp3");
        if (assetFileDescriptor != null)
          this.c.setAudioMixAsset(assetFileDescriptor); 
        j = i();
        if (h()) {
          i = j();
        } else {
          i = 0;
        } 
        a(j, i);
      } catch (IOException iOException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(b);
        stringBuilder.append("读取 ");
        stringBuilder.append("silent_audio.mp3");
        stringBuilder.append(" IOException");
        StvLogUtils.a(stringBuilder.toString(), new Object[0]);
      } 
      if (this.h.getSerializableData().isHasBgMusic()) {
        a(this.h.getSerializableData().getMusicPath());
        this.h.getSerializableData().setMusicPath(this.h.getSerializableData().getMusicPath());
      } 
      if (this.h.getSerializableData().getSelectedFilter() != null) {
        t();
        a(this.h.getSerializableData().getSelectedFilter(), this.h.getSerializableData().getSelectFilterPosition());
      } 
      iBaseView.a((CommonModel)this.h.getSerializableData());
      iBaseView.a(q(), p(), k());
      return;
    } 
  }
  
  public void a(int paramInt) {
    EditDataModel editDataModel = this.h;
    if (editDataModel != null)
      editDataModel.getSerializableData().setShowVType(paramInt); 
  }
  
  public void a(int paramInt1, int paramInt2) {
    this.h.setCurrentFgVolume(paramInt1);
    this.h.setCurrentBgVolume(paramInt2);
    PLShortVideoEditor pLShortVideoEditor = this.c;
    if (pLShortVideoEditor != null)
      pLShortVideoEditor.setAudioMixVolume(paramInt1 / 100.0F, paramInt2 / 100.0F); 
  }
  
  public void a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Bundle paramBundle) {
    if (paramBundle != null && this.h != null) {
      CommonModel commonModel = new CommonModel();
      commonModel.copyModel((CommonModel)this.h.getSerializableData());
      paramBundle.putSerializable("commont_model", (Serializable)commonModel);
      if (this.h.getSerializableData() != null) {
        EditDataModel.SerializableData serializableData = new EditDataModel.SerializableData();
        serializableData.a(this.h.getSerializableData());
        paramBundle.putSerializable("serializeble_data", (Serializable)serializableData);
      } 
    } 
  }
  
  public void a(PLVideoFilterListener paramPLVideoFilterListener) {
    this.c.startPlayback(paramPLVideoFilterListener);
  }
  
  public void a(String paramString) {
    this.h.getSerializableData().setHasBgMusic(true);
    this.h.getSerializableData().setMusicPath(paramString);
    this.c.setAudioMixFile(paramString);
    a(this.h.getCurrentFgVolume(), 100);
  }
  
  public void a(boolean paramBoolean) {
    this.c.setPlaybackLoop(paramBoolean);
  }
  
  public void b() {
    SenseTimeQiniuEditVideoManager senseTimeQiniuEditVideoManager = this.d;
    if (senseTimeQiniuEditVideoManager != null)
      senseTimeQiniuEditVideoManager.onDestroy(); 
  }
  
  public void b(boolean paramBoolean) {
    this.c.setAudioMixLooping(paramBoolean);
  }
  
  public void c() {
    boolean bool;
    b(true);
    a(true);
    l();
    if (this.d != null) {
      a(this.a);
    } else {
      a((PLVideoFilterListener)null);
    } 
    int i = i();
    if (h()) {
      bool = j();
    } else {
      bool = false;
    } 
    a(i, bool);
  }
  
  public void c(boolean paramBoolean) {
    this.c.muteOriginAudio(paramBoolean);
  }
  
  public void d() {
    SenseTimeQiniuEditVideoManager senseTimeQiniuEditVideoManager = this.d;
    if (senseTimeQiniuEditVideoManager != null)
      senseTimeQiniuEditVideoManager.onStop(); 
  }
  
  public void e() {
    m();
    n();
    SenseTimeQiniuEditVideoManager senseTimeQiniuEditVideoManager = this.d;
    if (senseTimeQiniuEditVideoManager != null)
      senseTimeQiniuEditVideoManager.onPause(); 
    this.h.setCoverImgPath(null);
  }
  
  public void f() {
    SenseTimeQiniuEditVideoManager senseTimeQiniuEditVideoManager = this.d;
    if (senseTimeQiniuEditVideoManager != null)
      senseTimeQiniuEditVideoManager.onStart(); 
  }
  
  public boolean g() {
    return false;
  }
  
  public boolean h() {
    return this.h.getSerializableData().isHasBgMusic();
  }
  
  public int i() {
    return this.h.getCurrentFgVolume();
  }
  
  public int j() {
    return this.h.getCurrentBgVolume();
  }
  
  public int k() {
    return this.h.getSerializableData().getCurrentPage();
  }
  
  public void l() {
    this.c.resumePlayback();
  }
  
  public void m() {
    this.c.pausePlayback();
  }
  
  public void n() {
    this.c.stopPlayback();
  }
  
  public int o() {
    EditDataModel editDataModel = this.h;
    return (editDataModel != null) ? editDataModel.getSerializableData().getShowVType() : 0;
  }
  
  public int p() {
    return this.h.getSerializableData().getPrePageType();
  }
  
  public int q() {
    return this.h.getSerializableData().getFrom();
  }
  
  public boolean r() {
    return this.h.isAutoDelete();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\presenter\EditPreViewPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */