package com.blued.android.module.shortvideo.presenter;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.blued.android.core.AppMethods;
import com.blued.android.module.base.data_statistics.StatisticsProxy;
import com.blued.android.module.base.shortvideo.MusicListProxy;
import com.blued.android.module.base.shortvideo.StvResultModel;
import com.blued.android.module.base.user.UserProxy;
import com.blued.android.module.external_sense_library.manager.SenseTimeFactory;
import com.blued.android.module.external_sense_library.manager.SenseTimeQiniuEditVideoManager;
import com.blued.android.module.external_sense_library.utils.STLicenseUtils;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.contract.IEditView;
import com.blued.android.module.shortvideo.contract.IStvVideoFrameForTimeCallback;
import com.blued.android.module.shortvideo.manager.ObserverMgr;
import com.blued.android.module.shortvideo.model.CommonModel;
import com.blued.android.module.shortvideo.model.EditDataModel;
import com.blued.android.module.shortvideo.model.EventType;
import com.blued.android.module.shortvideo.model.FilterConfigModel;
import com.blued.android.module.shortvideo.model.FilterItem;
import com.blued.android.module.shortvideo.model.VideoFrameModel;
import com.blued.android.module.shortvideo.observer.EventObserver;
import com.blued.android.module.shortvideo.utils.StvLogUtils;
import com.blued.android.module.shortvideo.utils.StvMediaUtils;
import com.blued.android.module.shortvideo.utils.StvThreadPoolHelper;
import com.blued.android.module.shortvideo.utils.StvTools;
import com.blued.android.module.shortvideo.utils.VideoConfigData;
import com.qiniu.pili.droid.shortvideo.PLDisplayMode;
import com.qiniu.pili.droid.shortvideo.PLShortVideoEditor;
import com.qiniu.pili.droid.shortvideo.PLVideoEditSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoFilterListener;
import com.qiniu.pili.droid.shortvideo.PLVideoSaveListener;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

public class EditPresenter extends ShortVideoBasePresent<IEditView> implements EventObserver, PLVideoSaveListener {
  private static final String c = EditPresenter.class.getSimpleName();
  
  PLVideoFilterListener a = new PLVideoFilterListener(this) {
      public int onDrawFrame(int param1Int1, int param1Int2, int param1Int3, long param1Long, float[] param1ArrayOffloat) {
        return EditPresenter.e(this.a).drawFrame(param1Int1, param1Int2, param1Int3, false);
      }
      
      public void onSurfaceChanged(int param1Int1, int param1Int2) {
        EditPresenter.e(this.a).adjustViewPort(param1Int1, param1Int2);
      }
      
      public void onSurfaceCreated() {
        EditPresenter.e(this.a).onSurfaceCreated();
      }
      
      public void onSurfaceDestroy() {
        EditPresenter.e(this.a).onSurfaceDestroyed();
      }
    };
  
  PLVideoFilterListener b = new PLVideoFilterListener(this) {
      public int onDrawFrame(int param1Int1, int param1Int2, int param1Int3, long param1Long, float[] param1ArrayOffloat) {
        return EditPresenter.f(this.a).drawFrame(param1Int1, param1Int2, param1Int3, false);
      }
      
      public void onSurfaceChanged(int param1Int1, int param1Int2) {
        EditPresenter.f(this.a).adjustViewPort(param1Int1, param1Int2);
      }
      
      public void onSurfaceCreated() {
        EditPresenter.f(this.a).onSurfaceCreated();
      }
      
      public void onSurfaceDestroy() {
        EditPresenter.f(this.a).onSurfaceDestroyed();
      }
    };
  
  private PLShortVideoEditor d;
  
  private SenseTimeQiniuEditVideoManager g;
  
  private SenseTimeQiniuEditVideoManager h;
  
  private GestureDetector i;
  
  private Bundle j;
  
  private EditDataModel k;
  
  private GestureDetector.OnGestureListener l = new GestureDetector.OnGestureListener(this) {
      public boolean onDown(MotionEvent param1MotionEvent) {
        return false;
      }
      
      public boolean onFling(MotionEvent param1MotionEvent1, MotionEvent param1MotionEvent2, float param1Float1, float param1Float2) {
        float f1 = param1MotionEvent1.getX() - param1MotionEvent2.getX();
        float f2 = param1MotionEvent1.getY() - param1MotionEvent2.getY();
        if (f2 > 0.0F && f2 > 80.0F && Math.abs(param1Float2) > Math.abs(param1Float1)) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(EditPresenter.B());
          stringBuilder.append(" 向上滑...");
          StvLogUtils.a(stringBuilder.toString(), new Object[0]);
          if (EditPresenter.c(this.a).getSerializableData().getPrePageType() == 3) {
            int j = EditPresenter.c(this.a).getSerializableData().getSelectFilterPosition() + 1;
            int i = j;
            if (j >= EditPresenter.c(this.a).getSerializableData().getFilters().size())
              i = 0; 
            FilterItem filterItem = EditPresenter.c(this.a).getSerializableData().getFilters().get(i);
            if (EditPresenter.c(this.a).getSerializableData().getFrom() < 60)
              StatisticsProxy.a().a("sv_filter_click", i); 
            this.a.a(filterItem, i);
            EditPresenter.a(this.a, filterItem, i);
            ObserverMgr.a().a(EventType.VALUE.n);
            return true;
          } 
        } 
        if (f2 < 0.0F && Math.abs(f2) > 80.0F && Math.abs(param1Float2) > Math.abs(param1Float1)) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(EditPresenter.B());
          stringBuilder.append(" 向下滑...");
          StvLogUtils.a(stringBuilder.toString(), new Object[0]);
          if (EditPresenter.c(this.a).getSerializableData().getPrePageType() == 3) {
            int j = EditPresenter.c(this.a).getSerializableData().getSelectFilterPosition() - 1;
            int i = j;
            if (j < 0)
              i = EditPresenter.c(this.a).getSerializableData().getFilters().size() - 1; 
            FilterItem filterItem = EditPresenter.c(this.a).getSerializableData().getFilters().get(i);
            if (EditPresenter.c(this.a).getSerializableData().getFrom() < 60)
              StatisticsProxy.a().a("sv_filter_click", i); 
            this.a.a(filterItem, i);
            EditPresenter.a(this.a, filterItem, i);
            ObserverMgr.a().a(EventType.VALUE.n);
            return true;
          } 
        } 
        if (f1 > 0.0F && f1 > 80.0F && Math.abs(param1Float1) > Math.abs(param1Float2)) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(EditPresenter.B());
          stringBuilder.append(" 向左滑...");
          StvLogUtils.a(stringBuilder.toString(), new Object[0]);
          return true;
        } 
        if (f1 < 0.0F && Math.abs(f1) > 80.0F && Math.abs(param1Float1) > Math.abs(param1Float2)) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(EditPresenter.B());
          stringBuilder.append(" 向右滑...");
          StvLogUtils.a(stringBuilder.toString(), new Object[0]);
          return true;
        } 
        return false;
      }
      
      public void onLongPress(MotionEvent param1MotionEvent) {}
      
      public boolean onScroll(MotionEvent param1MotionEvent1, MotionEvent param1MotionEvent2, float param1Float1, float param1Float2) {
        return false;
      }
      
      public void onShowPress(MotionEvent param1MotionEvent) {}
      
      public boolean onSingleTapUp(MotionEvent param1MotionEvent) {
        IEditView iEditView = this.a.D();
        if (iEditView != null) {
          int i = EditPresenter.c(this.a).getSerializableData().getShowVType();
          if (i != 1)
            if (i != 2) {
              if (i != 3) {
                if (i == 4)
                  iEditView.e(); 
              } else {
                iEditView.ad_();
              } 
            } else {
              iEditView.d();
            }  
        } 
        return false;
      }
    };
  
  public EditPresenter(Bundle paramBundle) {
    this.j = paramBundle;
  }
  
  private void C() {
    if (D() != null)
      AppMethods.d(R.string.common_net_error); 
  }
  
  private void F() {
    IEditView iEditView = D();
    if (iEditView != null) {
      Intent intent = new Intent();
      StvResultModel stvResultModel = new StvResultModel();
      stvResultModel.a(true);
      stvResultModel.b(this.k.getCoverImgPath());
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(c);
      stringBuilder.append(" coverImagePath = ");
      stringBuilder.append(this.k.getCoverImgPath());
      StvLogUtils.a(stringBuilder.toString(), new Object[0]);
      stvResultModel.c(this.k.getSaveVideoPath());
      stvResultModel.a(this.k.getSaveVideoWidth());
      stvResultModel.b(this.k.getSaveVideoHeight());
      stvResultModel.a(this.k.getSaveDurationMs());
      stvResultModel.b(this.k.getVideoSize());
      stvResultModel.d(this.k.getSerializableData().getMusicId());
      stvResultModel.c(this.k.getSerializableData().getSelectFilterPosition());
      if (t() == 1 || t() == 61 || t() == 7)
        stvResultModel.b(u()); 
      intent.putExtra("result_model", (Serializable)stvResultModel);
      intent.putExtra("close_page", true);
      intent.putExtra("serializeble_data", (Serializable)this.k.getSerializableData());
      iEditView.getActivity().setResult(-1, intent);
      iEditView.getActivity().finish();
    } 
  }
  
  private void G() {
    this.g = (SenseTimeQiniuEditVideoManager)SenseTimeFactory.createInstance(D().getContext(), 2);
    this.g.enableBeautify(false);
    this.h = (SenseTimeQiniuEditVideoManager)SenseTimeFactory.createInstance(D().getContext(), 2);
    this.h.enableBeautify(false);
  }
  
  private void H() {
    ObserverMgr.a().a(this);
  }
  
  private void I() {
    ObserverMgr.a().b(this);
  }
  
  private void a(long paramLong) {
    this.k.setCurrentCoverTime(paramLong);
  }
  
  private void b(FilterItem paramFilterItem, int paramInt) {
    if (paramFilterItem != null) {
      if (paramFilterItem.b() != null) {
        this.g.setFilterStyle(paramFilterItem.b());
        this.h.setFilterStyle(paramFilterItem.b());
        return;
      } 
      this.g.setFilterStyle(null);
      this.h.setFilterStyle(null);
    } 
  }
  
  private void b(String paramString) {
    IEditView iEditView = D();
    if (iEditView != null && iEditView.getActivity() != null) {
      String str1 = this.k.getSerializableData().getVideoPath();
      String str2 = this.k.getNeedDeleteVideoPath();
      boolean bool = this.k.getSerializableData().isCanDeleteVideoFile();
      StvThreadPoolHelper.a().a((Runnable)new StvThreadPoolHelper.StvThread(new Runnable(this, bool, str1, paramString, str2) {
              public void run() {
                if (this.a && !TextUtils.isEmpty(this.b) && !this.b.equals(EditPresenter.c(this.e).getSerializableData().getOriginalVideoPath()) && !this.b.equals(this.c)) {
                  File file = new File(this.b);
                  if (file.exists()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("5 delete file videoPath");
                    stringBuilder.append(this.b);
                    Log.d("StvMediaUtils", stringBuilder.toString());
                    file.delete();
                  } 
                } 
                if (!TextUtils.isEmpty(this.d) && !this.d.equals(EditPresenter.c(this.e).getSerializableData().getOriginalVideoPath()) && !this.b.equals(this.c)) {
                  File file = new File(this.d);
                  if (file.exists()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("6 delete file videoPath");
                    stringBuilder.append(this.b);
                    Log.d("StvMediaUtils", stringBuilder.toString());
                    file.delete();
                  } 
                } 
              }
            }));
      if (this.k.getSerializableData().isAddAblum())
        StvMediaUtils.a(iEditView.getContext(), paramString); 
      this.k.setSaveVideoPath(paramString);
      this.k.getSerializableData().setMusicPath(this.k.getSerializableData().getMusicPath());
      VideoFrameModel.getInstance().saveVideoFrameByTime(this.k.getSaveVideoPath(), this.k.getCurrentCoverTime(), new IStvVideoFrameForTimeCallback(this) {
            public void a(String param1String) {
              StringBuilder stringBuilder;
              IEditView iEditView = this.a.D();
              if (iEditView == null || iEditView.getActivity() == null || iEditView.getActivity().isFinishing()) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(EditPresenter.B());
                stringBuilder.append(" getView() == null!!!");
                StvLogUtils.a(stringBuilder.toString(), new Object[0]);
                return;
              } 
              iEditView.a_(new Runnable(this, (String)stringBuilder) {
                    public void run() {
                      IEditView iEditView = this.b.a.D();
                      if (iEditView != null) {
                        iEditView.c(false);
                        EditPresenter.c(this.b.a).setCoverImgPath(this.a);
                        EditPresenter.d(this.b.a);
                      } 
                    }
                  });
            }
          });
    } 
  }
  
  public long A() {
    return this.k.getDurationMs();
  }
  
  public void a() {
    IEditView iEditView = D();
    if (iEditView != null) {
      boolean bool;
      StringBuilder stringBuilder1;
      File file;
      Bundle bundle = this.j;
      if (bundle == null) {
        bundle = iEditView.getArguments();
        bool = false;
      } else {
        bool = true;
      } 
      if (bundle == null) {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(c);
        stringBuilder1.append("EditPresenter bundle == null!!!");
        StvLogUtils.a(stringBuilder1.toString(), new Object[0]);
        C();
        iEditView.getActivity().finish();
        return;
      } 
      if (!STLicenseUtils.a(D().getContext())) {
        AppMethods.a("请检查License授权！");
        D().getActivity().finish();
        return;
      } 
      CommonModel commonModel = (CommonModel)stringBuilder1.getSerializable("commont_model");
      EditDataModel.SerializableData serializableData = (EditDataModel.SerializableData)stringBuilder1.getSerializable("serializeble_data");
      if (commonModel == null && serializableData == null) {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(c);
        stringBuilder1.append("EditPresenter commonModel 数据错误！！！");
        StvLogUtils.a(stringBuilder1.toString(), new Object[0]);
        C();
        iEditView.getActivity().finish();
        return;
      } 
      StringBuilder stringBuilder2 = null;
      if (commonModel != null && !TextUtils.isEmpty(commonModel.getVideoPath())) {
        file = new File(commonModel.getVideoPath());
      } else {
        stringBuilder1 = stringBuilder2;
        if (serializableData != null) {
          stringBuilder1 = stringBuilder2;
          if (!TextUtils.isEmpty(serializableData.getVideoPath()))
            file = new File(serializableData.getVideoPath()); 
        } 
      } 
      if (file == null || !file.exists()) {
        C();
        iEditView.getActivity().finish();
        return;
      } 
      this.k = new EditDataModel();
      this.k.copyModel(commonModel, serializableData);
      this.k.setScreenWidth((iEditView.getContext().getResources().getDisplayMetrics()).widthPixels);
      this.k.getSerializableData().setUseData(Boolean.valueOf(bool));
      FilterConfigModel filterConfigModel = new FilterConfigModel();
      this.k.getSerializableData().setFilters(filterConfigModel.getFilters());
      String str = UserProxy.b().a();
      if (!TextUtils.isEmpty(str) && (str.equals(String.valueOf(2)) || str.equals(String.valueOf(3))))
        this.k.getSerializableData().setPrivilegeUser(true); 
      str = this.k.getSerializableData().getVideoPath();
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(c);
      stringBuilder2.append("editing file: ");
      stringBuilder2.append(str);
      StvLogUtils.a(stringBuilder2.toString(), new Object[0]);
      int j = this.k.getVideoWidth();
      int k = this.k.getVideoHeight();
      int i = (iEditView.getContext().getResources().getDisplayMetrics()).widthPixels;
      j = (int)(i * 1.0F / j * k);
      ViewGroup.LayoutParams layoutParams = iEditView.a().getLayoutParams();
      layoutParams.width = i;
      layoutParams.height = j;
      iEditView.a().setLayoutParams(layoutParams);
      PLVideoEditSetting pLVideoEditSetting = new PLVideoEditSetting();
      pLVideoEditSetting.setSourceFilepath(str);
      pLVideoEditSetting.setDestFilepath(StvTools.c());
      this.d = new PLShortVideoEditor(iEditView.a(), pLVideoEditSetting);
      this.d.setDisplayMode(PLDisplayMode.FULL);
      if (s() == 3 && this.k.isTranscode()) {
        EditDataModel editDataModel1 = this.k;
        editDataModel1.calculateEncodingSize(editDataModel1.getVideoBitrate(), this.k.getVideoWidth(), this.k.getVideoHeight());
        PLVideoEncodeSetting pLVideoEncodeSetting = new PLVideoEncodeSetting(iEditView.getContext());
        pLVideoEncodeSetting.setEncodingBitrate(this.k.getEncodingVideoBitrate());
        pLVideoEncodeSetting.setEncodingBitrateMode(PLVideoEncodeSetting.BitrateMode.QUALITY_PRIORITY);
        pLVideoEncodeSetting.setEncodingFps(30);
        pLVideoEncodeSetting.setPreferredEncodingSize(this.k.getEncodingW(), this.k.getEncodingH());
        pLVideoEncodeSetting.setHWCodecEnabled(VideoConfigData.a.booleanValue());
        this.d.setVideoEncodeSetting(pLVideoEncodeSetting);
      } 
      this.d.setVideoSaveListener(this);
      c(false);
      try {
        AssetFileDescriptor assetFileDescriptor = iEditView.getActivity().getAssets().openFd("silent_audio.mp3");
        if (assetFileDescriptor != null)
          this.d.setAudioMixAsset(assetFileDescriptor); 
        j = k();
        if (j()) {
          i = l();
        } else {
          i = 0;
        } 
        a(j, i);
      } catch (IOException iOException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c);
        stringBuilder.append("读取 ");
        stringBuilder.append("silent_audio.mp3");
        stringBuilder.append(" IOException");
        StvLogUtils.a(stringBuilder.toString(), new Object[0]);
      } 
      G();
      this.i = new GestureDetector(iEditView.getContext(), this.l);
      iEditView.a().setOnTouchListener(new View.OnTouchListener(this) {
            public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
              EditPresenter.a(this.a).onTouchEvent(param1MotionEvent);
              return true;
            }
          });
      if (bool)
        if (s() == 3) {
          a(this.k.getSerializableData().getMusicPath());
          b(this.k.getSerializableData().getSelectedFilter(), this.k.getSerializableData().getSelectFilterPosition());
        } else if (!i()) {
          a(this.k.getSerializableData().getMusicPath());
        }  
      EditDataModel editDataModel = this.k;
      editDataModel.setSaveVideoPath(editDataModel.getSerializableData().getVideoPath());
      iEditView.a((CommonModel)this.k.getSerializableData());
      iEditView.a(t(), s(), n());
      return;
    } 
  }
  
  public void a(int paramInt) {
    this.d.seekTo(paramInt);
    if (this.k.getSerializableData().getShowVType() == 3) {
      this.d.resumePlayback();
      this.d.pausePlayback();
    } 
  }
  
  public void a(int paramInt1, int paramInt2) {
    this.k.setCurrentFgVolume(paramInt1);
    this.k.setCurrentBgVolume(paramInt2);
    PLShortVideoEditor pLShortVideoEditor = this.d;
    if (pLShortVideoEditor != null)
      pLShortVideoEditor.setAudioMixVolume(paramInt1 / 100.0F, paramInt2 / 100.0F); 
  }
  
  public void a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramInt2 == -1 && paramIntent != null) {
      if (paramInt1 != 3)
        return; 
      String str = paramIntent.getStringExtra("music_file_path");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(c);
      stringBuilder.append("Select file: ");
      stringBuilder.append(str);
      StvLogUtils.a(stringBuilder.toString(), new Object[0]);
      if (!TextUtils.isEmpty(str))
        a(str); 
    } 
  }
  
  public void a(Bundle paramBundle) {
    if (paramBundle != null && this.k != null) {
      CommonModel commonModel = new CommonModel();
      commonModel.copyModel((CommonModel)this.k.getSerializableData());
      paramBundle.putSerializable("commont_model", (Serializable)commonModel);
      if (this.k.getSerializableData() != null) {
        EditDataModel.SerializableData serializableData = new EditDataModel.SerializableData();
        serializableData.a(this.k.getSerializableData());
        paramBundle.putSerializable("serializeble_data", (Serializable)serializableData);
      } 
    } 
  }
  
  public void a(EventType.VALUE paramVALUE) {
    int i = null.a[paramVALUE.ordinal()];
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i != 4) {
            if (i != 5)
              return; 
            o();
            return;
          } 
          a((int)this.k.getCurrentCoverTime());
          p();
          return;
        } 
        if (t() == 2) {
          F();
          return;
        } 
        if (t() == 4 || t() == 0 || t() == 1 || t() == 7 || t() == 61 || t() == 60) {
          h();
          return;
        } 
        b(this.a);
        return;
      } 
      b(this.k.getSerializableData().getSelectedFilter(), this.k.getSerializableData().getSelectFilterPosition());
      return;
    } 
    m();
  }
  
  public void a(FilterItem paramFilterItem, int paramInt) {
    this.k.getSerializableData().setSelectedFilter(paramFilterItem);
    this.k.getSerializableData().setSelectFilterPosition(paramInt);
  }
  
  public void a(PLVideoFilterListener paramPLVideoFilterListener) {
    this.d.startPlayback(paramPLVideoFilterListener);
  }
  
  public void a(String paramString) {
    this.k.getSerializableData().setHasBgMusic(true);
    this.k.getSerializableData().setMusicPath(paramString);
    this.d.setAudioMixFile(paramString);
    a(this.k.getCurrentFgVolume(), 100);
  }
  
  public void a(boolean paramBoolean) {
    this.d.setPlaybackLoop(paramBoolean);
  }
  
  public void b() {
    I();
    SenseTimeQiniuEditVideoManager senseTimeQiniuEditVideoManager = this.g;
    if (senseTimeQiniuEditVideoManager != null)
      senseTimeQiniuEditVideoManager.onDestroy(); 
    senseTimeQiniuEditVideoManager = this.h;
    if (senseTimeQiniuEditVideoManager != null)
      senseTimeQiniuEditVideoManager.onDestroy(); 
  }
  
  public void b(int paramInt) {
    EditDataModel editDataModel = this.k;
    if (editDataModel != null)
      editDataModel.getSerializableData().setShowVType(paramInt); 
  }
  
  public void b(PLVideoFilterListener paramPLVideoFilterListener) {
    p();
    q();
    this.d.save(paramPLVideoFilterListener);
  }
  
  public void b(boolean paramBoolean) {
    this.d.setAudioMixLooping(paramBoolean);
  }
  
  public void c() {
    boolean bool;
    H();
    b(true);
    a(true);
    if (this.k.getSerializableData().getShowVType() != 3) {
      o();
      a(this.b);
    } 
    int i = k();
    if (j()) {
      bool = l();
    } else {
      bool = false;
    } 
    a(i, bool);
  }
  
  public void c(int paramInt) {
    int i = paramInt - x();
    paramInt = i;
    if (i < 0)
      paramInt = 0; 
    i = paramInt;
    if (paramInt > w())
      i = w(); 
    a(Math.round(i * 1.0F / w() * (float)A()));
  }
  
  public void c(boolean paramBoolean) {
    this.d.muteOriginAudio(paramBoolean);
  }
  
  public void d() {
    SenseTimeQiniuEditVideoManager senseTimeQiniuEditVideoManager = this.g;
    if (senseTimeQiniuEditVideoManager != null)
      senseTimeQiniuEditVideoManager.onStop(); 
    senseTimeQiniuEditVideoManager = this.h;
    if (senseTimeQiniuEditVideoManager != null)
      senseTimeQiniuEditVideoManager.onStop(); 
  }
  
  public void d(int paramInt) {
    this.k.setCoverVLenght(paramInt);
  }
  
  public void d(boolean paramBoolean) {
    this.k.setAutoDelete(paramBoolean);
  }
  
  public void e() {
    p();
    q();
    I();
    SenseTimeQiniuEditVideoManager senseTimeQiniuEditVideoManager = this.g;
    if (senseTimeQiniuEditVideoManager != null)
      senseTimeQiniuEditVideoManager.onPause(); 
    senseTimeQiniuEditVideoManager = this.h;
    if (senseTimeQiniuEditVideoManager != null)
      senseTimeQiniuEditVideoManager.onPause(); 
    this.k.setCoverImgPath(null);
  }
  
  public void e(int paramInt) {
    this.k.setCoverStartPositon(paramInt);
  }
  
  public void f() {
    SenseTimeQiniuEditVideoManager senseTimeQiniuEditVideoManager = this.g;
    if (senseTimeQiniuEditVideoManager != null)
      senseTimeQiniuEditVideoManager.onStart(); 
    senseTimeQiniuEditVideoManager = this.h;
    if (senseTimeQiniuEditVideoManager != null)
      senseTimeQiniuEditVideoManager.onStart(); 
  }
  
  public void f(int paramInt) {
    this.k.setCoverEndPosition(paramInt);
  }
  
  public void g(int paramInt) {
    this.k.setCoverCurrentLeftPosition(paramInt);
  }
  
  public boolean g() {
    return false;
  }
  
  public void h() {
    StvThreadPoolHelper.a().a((Runnable)new StvThreadPoolHelper.StvThread(new Runnable(this) {
            public void run() {
              VideoFrameModel.getInstance().saveVideoFrameByTime(EditPresenter.c(this.a).getSerializableData().getVideoPath(), EditPresenter.c(this.a).getCurrentCoverTime(), new IStvVideoFrameForTimeCallback(this) {
                    public void a(String param2String) {
                      EditPresenter.c(this.a.a).setCoverImgPath(param2String);
                      EditPresenter.d(this.a.a);
                    }
                  });
            }
          }));
  }
  
  public void h(int paramInt) {
    this.k.getSerializableData().setShowVType(paramInt);
  }
  
  public boolean i() {
    return this.k.getSerializableData().isAddMusic();
  }
  
  public boolean j() {
    return this.k.getSerializableData().isHasBgMusic();
  }
  
  public int k() {
    return this.k.getCurrentFgVolume();
  }
  
  public int l() {
    return this.k.getCurrentBgVolume();
  }
  
  public void m() {
    IEditView iEditView = D();
    if (iEditView != null) {
      iEditView.ab_();
      if (this.k.getSerializableData().getPrePageType() == 3) {
        MusicListProxy.a().a(iEditView.b(), 3);
        return;
      } 
      MusicListProxy.a().b(iEditView.b(), 3);
    } 
  }
  
  public int n() {
    return this.k.getSerializableData().getCurrentPage();
  }
  
  public void o() {
    this.d.resumePlayback();
  }
  
  public void onProgressUpdate(float paramFloat) {
    StringBuilder stringBuilder;
    IEditView iEditView = D();
    if (iEditView == null || iEditView.b() == null || !iEditView.b().isAdded()) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(c);
      stringBuilder.append(" getView() == null!!!");
      StvLogUtils.a(stringBuilder.toString(), new Object[0]);
      return;
    } 
    stringBuilder.a(paramFloat / 2.0F + 0.5F);
  }
  
  public void onSaveVideoCanceled() {
    StringBuilder stringBuilder1;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(c);
    stringBuilder2.append(" 转码取消");
    StvLogUtils.a(stringBuilder2.toString(), new Object[0]);
    IEditView iEditView = D();
    if (iEditView == null || iEditView.getActivity() == null || iEditView.getActivity().isFinishing()) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(c);
      stringBuilder1.append(" getView() == null!!!");
      StvLogUtils.a(stringBuilder1.toString(), new Object[0]);
      return;
    } 
    stringBuilder1.a_(new Runnable(this) {
          public void run() {
            IEditView iEditView = this.a.D();
            if (iEditView != null) {
              iEditView.c(false);
              EditPresenter.b(this.a);
            } 
          }
        });
  }
  
  public void onSaveVideoFailed(int paramInt) {
    StringBuilder stringBuilder1;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(c);
    stringBuilder2.append(" 转码失败 errorCode:");
    stringBuilder2.append(paramInt);
    StvLogUtils.a(stringBuilder2.toString(), new Object[0]);
    IEditView iEditView = D();
    if (iEditView == null || iEditView.getActivity() == null || iEditView.getActivity().isFinishing()) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(c);
      stringBuilder1.append(" getView() == null!!!");
      StvLogUtils.a(stringBuilder1.toString(), new Object[0]);
      return;
    } 
    stringBuilder1.a_(new Runnable(this, paramInt) {
          public void run() {
            IEditView iEditView = this.b.D();
            if (iEditView != null)
              iEditView.c(false); 
            EditPresenter.b(this.b);
            int i = this.a;
            if (i != 13) {
              if (i != 14) {
                if (i != 16)
                  return; 
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(EditPresenter.B());
                stringBuilder2.append("当前机型暂不支持该功能");
                StvLogUtils.a(stringBuilder2.toString(), new Object[0]);
                return;
              } 
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append(EditPresenter.B());
              stringBuilder1.append("源文件路径和目标路径不能相同！");
              StvLogUtils.a(stringBuilder1.toString(), new Object[0]);
              return;
            } 
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(EditPresenter.B());
            stringBuilder.append("该文件没有视频信息！");
            StvLogUtils.a(stringBuilder.toString(), new Object[0]);
          }
        });
  }
  
  public void onSaveVideoSuccess(String paramString) {
    StringBuilder stringBuilder1;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(c);
    stringBuilder2.append(" 转码成功 succes | path:");
    stringBuilder2.append(paramString);
    StvLogUtils.a(stringBuilder2.toString(), new Object[0]);
    IEditView iEditView = D();
    if (iEditView == null || iEditView.getActivity() == null || iEditView.getActivity().isFinishing()) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(c);
      stringBuilder1.append(" getView() == null!!!");
      StvLogUtils.a(stringBuilder1.toString(), new Object[0]);
      return;
    } 
    if (this.k.getSerializableData().getVideoPath().equals(stringBuilder1) || stringBuilder1.equals(this.k.getSerializableData().getOriginalVideoPath())) {
      this.k.getSerializableData().setCanDeleteVideoFile(false);
    } else {
      this.k.getSerializableData().setCanDeleteVideoFile(true);
    } 
    b((String)stringBuilder1);
  }
  
  public void p() {
    this.d.pausePlayback();
  }
  
  public void q() {
    this.d.stopPlayback();
  }
  
  public int r() {
    EditDataModel editDataModel = this.k;
    return (editDataModel != null) ? editDataModel.getSerializableData().getShowVType() : 0;
  }
  
  public int s() {
    return this.k.getSerializableData().getPrePageType();
  }
  
  public int t() {
    return this.k.getSerializableData().getFrom();
  }
  
  public boolean u() {
    return this.k.isAutoDelete();
  }
  
  public long v() {
    return this.k.getCurrentCoverTime();
  }
  
  public int w() {
    return this.k.getCoverVLenght();
  }
  
  public int x() {
    return this.k.getCoverStartPositon();
  }
  
  public int y() {
    return this.k.getCoverCurrentLeftPosition();
  }
  
  public String z() {
    return this.k.getSerializableData().getVideoPath();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\presenter\EditPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */