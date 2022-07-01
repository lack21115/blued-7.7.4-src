package com.blued.android.module.shortvideo.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.base.album.AlbumProxy;
import com.blued.android.module.base.data_statistics.StatisticsProxy;
import com.blued.android.module.base.http.FeedStateObserverProxy;
import com.blued.android.module.base.shortvideo.MusicListProxy;
import com.blued.android.module.base.shortvideo.StvResultModel;
import com.blued.android.module.base.user.UserProxy;
import com.blued.android.module.external_sense_library.manager.SenseTimeFactory;
import com.blued.android.module.external_sense_library.manager.SenseTimeQiniuShortVideoManager;
import com.blued.android.module.external_sense_library.utils.STLicenseUtils;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.contract.IShineView;
import com.blued.android.module.shortvideo.contract.IStvVideoFrameCallback;
import com.blued.android.module.shortvideo.fragment.EditFragment;
import com.blued.android.module.shortvideo.fragment.PhotoPreviewFragment;
import com.blued.android.module.shortvideo.manager.ObserverMgr;
import com.blued.android.module.shortvideo.manager.StvFragmentManager;
import com.blued.android.module.shortvideo.model.CommonModel;
import com.blued.android.module.shortvideo.model.EventType;
import com.blued.android.module.shortvideo.model.FilterConfigModel;
import com.blued.android.module.shortvideo.model.FilterItem;
import com.blued.android.module.shortvideo.model.ShineDataModel;
import com.blued.android.module.shortvideo.model.VideoFrameModel;
import com.blued.android.module.shortvideo.observer.EventObserver;
import com.blued.android.module.shortvideo.utils.SenseConfigData;
import com.blued.android.module.shortvideo.utils.StvCameraUtils;
import com.blued.android.module.shortvideo.utils.StvConfig;
import com.blued.android.module.shortvideo.utils.StvGuideUtils;
import com.blued.android.module.shortvideo.utils.StvLogUtils;
import com.blued.android.module.shortvideo.utils.StvThreadPoolHelper;
import com.blued.android.module.shortvideo.utils.StvTools;
import com.blued.android.module.shortvideo.utils.VideoConfigData;
import com.blued.android.module.shortvideo.view.SectionProgressBar;
import com.qiniu.pili.droid.shortvideo.PLAudioEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLCameraPreviewListener;
import com.qiniu.pili.droid.shortvideo.PLCameraSetting;
import com.qiniu.pili.droid.shortvideo.PLCaptureFrameListener;
import com.qiniu.pili.droid.shortvideo.PLDisplayMode;
import com.qiniu.pili.droid.shortvideo.PLFaceBeautySetting;
import com.qiniu.pili.droid.shortvideo.PLFocusListener;
import com.qiniu.pili.droid.shortvideo.PLMicrophoneSetting;
import com.qiniu.pili.droid.shortvideo.PLRecordSetting;
import com.qiniu.pili.droid.shortvideo.PLRecordStateListener;
import com.qiniu.pili.droid.shortvideo.PLShortVideoEnv;
import com.qiniu.pili.droid.shortvideo.PLShortVideoRecorder;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoFilterListener;
import com.qiniu.pili.droid.shortvideo.PLVideoFrame;
import com.qiniu.pili.droid.shortvideo.PLVideoSaveListener;
import java.io.File;
import java.io.Serializable;

public class ShinePresenter extends ShortVideoBasePresent<IShineView> implements FeedStateObserverProxy.IFeedStateListener, EventObserver, PLFocusListener, PLRecordStateListener, PLVideoSaveListener {
  private static final String g = ShinePresenter.class.getSimpleName();
  
  PLMicrophoneSetting a;
  
  PLVideoEncodeSetting b;
  
  PLAudioEncodeSetting c;
  
  PLFaceBeautySetting d;
  
  private Bundle h;
  
  private PLShortVideoRecorder i;
  
  private GestureDetector j;
  
  private PLRecordSetting k;
  
  private PLCameraSetting l;
  
  private String m;
  
  private int n;
  
  private int o;
  
  private boolean p = false;
  
  private SenseTimeQiniuShortVideoManager q;
  
  private ShineDataModel r;
  
  private GestureDetector.OnGestureListener s = new GestureDetector.OnGestureListener(this) {
      public boolean onDown(MotionEvent param1MotionEvent) {
        ShinePresenter.a(this.a, param1MotionEvent);
        return false;
      }
      
      public boolean onFling(MotionEvent param1MotionEvent1, MotionEvent param1MotionEvent2, float param1Float1, float param1Float2) {
        if (!ShinePresenter.b(this.a).isRecording()) {
          float f1 = param1MotionEvent1.getX() - param1MotionEvent2.getX();
          float f2 = param1MotionEvent1.getY() - param1MotionEvent2.getY();
          if (f2 > 0.0F && f2 > 80.0F && Math.abs(param1Float2) > Math.abs(param1Float1)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(ShinePresenter.C());
            stringBuilder.append(" 向上滑...");
            StvLogUtils.a(stringBuilder.toString(), new Object[0]);
            int k = ShinePresenter.b(this.a).getFilters().size();
            if (k <= 0) {
              stringBuilder = new StringBuilder();
              stringBuilder.append(ShinePresenter.C());
              stringBuilder.append(" 没有滤镜数据...");
              StvLogUtils.a(stringBuilder.toString(), new Object[0]);
              return true;
            } 
            int j = ShinePresenter.b(this.a).getSelectFilterPosition() + 1;
            int i = j;
            if (j >= k)
              i = 0; 
            FilterItem filterItem = ShinePresenter.b(this.a).getFilters().get(i);
            if (filterItem != null) {
              if (ShinePresenter.b(this.a).getFrom() < 60)
                StatisticsProxy.a().a("sv_filter_click", i); 
              this.a.a(filterItem, i);
              ObserverMgr.a().a(EventType.VALUE.n);
            } 
            return true;
          } 
          if (f2 < 0.0F && Math.abs(f2) > 80.0F && Math.abs(param1Float2) > Math.abs(param1Float1)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(ShinePresenter.C());
            stringBuilder.append(" 向下滑...");
            StvLogUtils.a(stringBuilder.toString(), new Object[0]);
            if (ShinePresenter.b(this.a).getFilters().size() <= 0) {
              stringBuilder = new StringBuilder();
              stringBuilder.append(ShinePresenter.C());
              stringBuilder.append(" 没有滤镜数据...");
              StvLogUtils.a(stringBuilder.toString(), new Object[0]);
              return true;
            } 
            int j = ShinePresenter.b(this.a).getSelectFilterPosition() - 1;
            int i = j;
            if (j < 0)
              i = ShinePresenter.b(this.a).getFilters().size() - 1; 
            FilterItem filterItem = ShinePresenter.b(this.a).getFilters().get(i);
            if (filterItem != null) {
              if (ShinePresenter.b(this.a).getFrom() < 60)
                StatisticsProxy.a().a("sv_filter_click", i); 
              this.a.a(filterItem, i);
              ObserverMgr.a().a(EventType.VALUE.n);
            } 
            return true;
          } 
          if (f1 > 0.0F && f1 > 80.0F && Math.abs(param1Float1) > Math.abs(param1Float2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(ShinePresenter.C());
            stringBuilder.append(" 向左滑...");
            StvLogUtils.a(stringBuilder.toString(), new Object[0]);
            if (ShinePresenter.b(this.a).getFrom() == 0 && !ShinePresenter.e(this.a))
              this.a.i(); 
            return true;
          } 
          if (f1 < 0.0F && Math.abs(f1) > 80.0F && Math.abs(param1Float1) > Math.abs(param1Float2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(ShinePresenter.C());
            stringBuilder.append(" 向右滑...");
            StvLogUtils.a(stringBuilder.toString(), new Object[0]);
            if (ShinePresenter.b(this.a).getFrom() == 0 && ShinePresenter.e(this.a))
              this.a.h(); 
            return true;
          } 
          return false;
        } 
        return true;
      }
      
      public void onLongPress(MotionEvent param1MotionEvent) {}
      
      public boolean onScroll(MotionEvent param1MotionEvent1, MotionEvent param1MotionEvent2, float param1Float1, float param1Float2) {
        return false;
      }
      
      public void onShowPress(MotionEvent param1MotionEvent) {}
      
      public boolean onSingleTapUp(MotionEvent param1MotionEvent) {
        if (ShinePresenter.b(this.a).getShowVType() != 2) {
          ShinePresenter.b(this.a, (int)param1MotionEvent.getX() - this.a.D().ae_().getWidth() / 2);
          ShinePresenter.c(this.a, (int)param1MotionEvent.getY() - this.a.D().ae_().getHeight() / 2);
          ShinePresenter.d(this.a).manualFocus(this.a.D().ae_().getWidth(), this.a.D().ae_().getHeight(), (int)param1MotionEvent.getX(), (int)param1MotionEvent.getY());
        } else {
          this.a.D().d();
        } 
        return false;
      }
    };
  
  public ShinePresenter(Bundle paramBundle) {
    this.h = paramBundle;
  }
  
  private void F() {
    IShineView iShineView = D();
    if (iShineView != null) {
      Intent intent = new Intent();
      StvResultModel stvResultModel = new StvResultModel();
      stvResultModel.a(false);
      stvResultModel.a(this.r.getFramePath());
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(g);
      stringBuilder.append(" picturePath = ");
      stringBuilder.append(this.r.getFramePath());
      StvLogUtils.a(stringBuilder.toString(), new Object[0]);
      intent.putExtra("result_model", (Serializable)stvResultModel);
      intent.putExtra("close_page", true);
      iShineView.getActivity().setResult(-1, intent);
      iShineView.getActivity().finish();
    } 
  }
  
  private void G() {
    D().ab_();
    MusicListProxy.a().b(D().b(), 3);
  }
  
  private void H() {
    ObserverMgr.a().a(this);
  }
  
  private void I() {
    ObserverMgr.a().b(this);
  }
  
  private void J() {
    int i = this.r.isOpenBeauty() ^ true;
    this.r.setOpenBeauty(i);
    this.q.enableBeautify(i);
  }
  
  private void K() {
    SenseTimeQiniuShortVideoManager senseTimeQiniuShortVideoManager = this.q;
    if (senseTimeQiniuShortVideoManager != null) {
      senseTimeQiniuShortVideoManager.onResume();
      this.q.enableBeautify(this.r.isOpenBeauty());
      if (this.r.getSelectedFilter() != null)
        b(this.r.getSelectedFilter(), this.r.getSelectFilterPosition()); 
    } 
  }
  
  private void L() {
    this.q = (SenseTimeQiniuShortVideoManager)SenseTimeFactory.createInstance(D().getContext(), 1);
    this.q.enableBeautify(false);
    SenseConfigData.a(this.q);
    this.i.setCameraPreviewListener(new PLCameraPreviewListener(this) {
          public boolean onPreviewFrame(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2, int param1Int3, int param1Int4, long param1Long) {
            if (ShinePresenter.f(this.a) != null)
              ShinePresenter.f(this.a).handlePreviewFrame(param1ArrayOfbyte, param1Int1, param1Int2, param1Int3); 
            return true;
          }
        });
    this.i.setVideoFilterListener(new PLVideoFilterListener(this) {
          public int onDrawFrame(int param1Int1, int param1Int2, int param1Int3, long param1Long, float[] param1ArrayOffloat) {
            return ShinePresenter.f(this.a).drawFrame(param1Int1, param1Int2, param1Int3, false);
          }
          
          public void onSurfaceChanged(int param1Int1, int param1Int2) {
            ShinePresenter.f(this.a).adjustViewPort(param1Int1, param1Int2);
          }
          
          public void onSurfaceCreated() {
            ShinePresenter.f(this.a).onSurfaceCreated();
          }
          
          public void onSurfaceDestroy() {
            ShinePresenter.f(this.a).onSurfaceDestroyed();
          }
        });
  }
  
  private boolean a(MotionEvent paramMotionEvent) {
    int i = paramMotionEvent.getAction();
    Rect rect = this.q.getIndexRect();
    if (paramMotionEvent.getPointerCount() == 1) {
      if (i != 0)
        return true; 
      if ((int)paramMotionEvent.getX() >= rect.left && (int)paramMotionEvent.getX() <= rect.right && (int)paramMotionEvent.getY() >= rect.top && (int)paramMotionEvent.getY() <= rect.bottom) {
        i = (int)paramMotionEvent.getX();
        int j = (int)paramMotionEvent.getY();
        this.q.setIndexRect(i - rect.width() / 2, j - rect.width() / 2, true);
      } 
      this.q.changeCustomEvent();
    } 
    return true;
  }
  
  private void b(int paramInt) {
    StvLogUtils.a(paramInt);
  }
  
  private void b(String paramString) {
    StvLogUtils.a(paramString);
  }
  
  private void c(String paramString) {
    D().ab_();
    D().b(false);
    ObserverMgr.a().a(EventType.VALUE.l);
    CommonModel commonModel = new CommonModel();
    commonModel.copyModel((CommonModel)this.r);
    commonModel.setVideoPath(paramString);
    commonModel.setAddAblum(true);
    commonModel.setCurrentPage(1);
    EditFragment.a(D().b(), commonModel, 2);
  }
  
  public boolean A() {
    return this.r.isConcatSections();
  }
  
  public boolean B() {
    return this.i.isFlashSupport();
  }
  
  public void a() {
    boolean bool;
    StringBuilder stringBuilder2;
    Bundle bundle = this.h;
    if (bundle == null) {
      bundle = D().getArguments();
      bool = false;
    } else {
      bool = true;
    } 
    if (bundle == null) {
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(g);
      stringBuilder2.append(" bundle == null!!!");
      StvLogUtils.a(stringBuilder2.toString(), new Object[0]);
      b(R.string.common_net_error);
      D().getActivity().finish();
      return;
    } 
    if (!STLicenseUtils.a(D().getContext())) {
      AppMethods.a("请检查License授权！");
      D().getActivity().finish();
      return;
    } 
    CommonModel commonModel = (CommonModel)stringBuilder2.getSerializable("commont_model");
    if (commonModel == null) {
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(g);
      stringBuilder2.append(" commonModel 数据错误！！！");
      StvLogUtils.a(stringBuilder2.toString(), new Object[0]);
      b(R.string.common_net_error);
      D().getActivity().finish();
      return;
    } 
    ShineDataModel.SerializableData serializableData = (ShineDataModel.SerializableData)stringBuilder2.getSerializable("serializeble_data");
    this.r = new ShineDataModel();
    this.r.copyModel(commonModel, serializableData);
    if (o() == 3) {
      this.p = true;
      this.r.setCurrentPage(5);
    } else {
      this.r.setCurrentPage(1);
    } 
    FilterConfigModel filterConfigModel = new FilterConfigModel();
    this.r.setFilters(filterConfigModel.getFilters());
    this.r.setUseData(Boolean.valueOf(bool));
    if (!bool)
      this.r.setOpenBeauty(true); 
    String str = UserProxy.b().a();
    if (!TextUtils.isEmpty(str) && (str.equals(String.valueOf(2)) || str.equals(String.valueOf(3))))
      this.r.setPrivilegeUser(true); 
    if (this.r.isPrivilegeUser()) {
      this.r.setMaxVideoDuration(300000L);
    } else {
      this.r.setMaxVideoDuration(60000L);
    } 
    D().a((CommonModel)this.r);
    D().a(o(), m(), n());
    if (this.r.getFrom() == 0 && StvGuideUtils.a()) {
      D().af_();
      StvGuideUtils.b();
    } 
    if (!AppInfo.m())
      PLShortVideoEnv.setLogLevel(7); 
    this.i = new PLShortVideoRecorder();
    this.i.setRecordStateListener(this);
    this.i.setFocusListener(this);
    this.l = new PLCameraSetting();
    PLCameraSetting.CAMERA_FACING_ID cAMERA_FACING_ID = StvCameraUtils.a();
    if (bool)
      cAMERA_FACING_ID = StvCameraUtils.a(this.r.getCurrentCameraId()); 
    this.l.setCameraId(cAMERA_FACING_ID);
    this.l.setCameraPreviewSizeRatio(VideoConfigData.a());
    this.l.setCameraPreviewSizeLevel(VideoConfigData.b());
    this.a = new PLMicrophoneSetting();
    this.b = new PLVideoEncodeSetting(D().getContext());
    this.b.setPreferredEncodingSize(720, 1280);
    this.b.setEncodingBitrate(VideoConfigData.c());
    this.b.setEncodingFps(30);
    this.b.setHWCodecEnabled(VideoConfigData.a.booleanValue());
    this.b.setProfileMode(PLVideoEncodeSetting.ProfileMode.HIGH);
    this.c = new PLAudioEncodeSetting();
    this.c.setHWCodecEnabled(false);
    this.k = new PLRecordSetting();
    this.k.setVideoCacheDir(StvConfig.a());
    this.k.setVideoFilepath(StvTools.b());
    this.k.setDisplayMode(PLDisplayMode.FULL);
    this.r.setMaxRecordDuration(15000L);
    this.k.setMaxRecordDuration((long)(this.r.getRecordSpeed() * 15000.0D));
    D().e().setFirstPointPre(this.r.getMinRecordDurationPre());
    D().e().a((Context)D().getActivity(), this.k.getMaxRecordDuration());
    this.i.prepare(D().a(), this.l, this.a, this.b, this.c, this.d, this.k);
    this.i.setRecordSpeed(this.r.getRecordSpeed());
    L();
    this.j = new GestureDetector(D().getContext(), this.s);
    D().a().setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            ShinePresenter.a(this.a).onTouchEvent(param1MotionEvent);
            return true;
          }
        });
    if (!StringUtils.a(this.r.getMusicPath()))
      a(this.r.getMusicPath()); 
    FeedStateObserverProxy.a().a(this);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(g);
    stringBuilder1.append("ShinePresenter initV()");
    StvLogUtils.a(stringBuilder1.toString(), new Object[0]);
    if (60 > this.r.getFrom())
      StatisticsProxy.a().a("sv_page", "shoot"); 
  }
  
  public void a(double paramDouble) {
    this.r.setRecordSpeed(paramDouble);
  }
  
  public void a(int paramInt) {
    this.r.setShowVType(paramInt);
  }
  
  public void a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramActivity != null) {
      String str;
      StringBuilder stringBuilder;
      if (paramInt2 == -1) {
        if (paramInt1 != 2)
          if (paramInt1 != 3) {
            if (paramInt1 != 4) {
              if (paramInt1 != 7)
                return; 
              F();
              return;
            } 
          } else {
            if (paramIntent != null) {
              str = paramIntent.getStringExtra("music_file_path");
              stringBuilder = new StringBuilder();
              stringBuilder.append(g);
              stringBuilder.append("Select file: ");
              stringBuilder.append(str);
              StvLogUtils.a(stringBuilder.toString(), new Object[0]);
              if (!TextUtils.isEmpty(str)) {
                a(str);
                return;
              } 
            } 
            return;
          }  
        if (stringBuilder != null && stringBuilder.getBooleanExtra("close_page", false)) {
          str.setResult(-1, (Intent)stringBuilder);
          str.finish();
          return;
        } 
      } else {
        if (paramInt1 != 4)
          return; 
        if (stringBuilder != null && stringBuilder.getBooleanExtra("close_page", false))
          str.finish(); 
      } 
    } 
  }
  
  public void a(Bundle paramBundle) {
    if (paramBundle != null) {
      CommonModel commonModel = new CommonModel();
      if (this.r != null) {
        commonModel.copyModel(commonModel);
        paramBundle.putSerializable("commont_model", (Serializable)commonModel);
        if (this.r.getSerializableData() != null) {
          ShineDataModel.SerializableData serializableData = new ShineDataModel.SerializableData();
          serializableData.a(this.r.getSerializableData());
          paramBundle.putSerializable("serializeble_data", (Serializable)serializableData);
        } 
      } 
    } 
  }
  
  public void a(EventType.VALUE paramVALUE) {
    double d;
    boolean bool;
    switch (null.a[paramVALUE.ordinal()]) {
      default:
        return;
      case 10:
        bool = s();
        if (!bool) {
          StvLogUtils.a("回删视频段失败", new Object[0]);
          b(R.string.common_net_error);
        } 
        ObserverMgr.a().a(paramVALUE, bool);
        return;
      case 9:
        d = this.r.getRecordSpeed();
        this.k.setMaxRecordDuration((long)(this.r.getMaxRecordDuration() * d));
        this.i.setRecordSpeed(d);
        D().e().a((Context)D().getActivity(), this.k.getMaxRecordDuration());
        return;
      case 8:
        bool = q();
        this.r.setRecording(bool ^ true);
        ObserverMgr.a().a(paramVALUE, bool);
        return;
      case 7:
        if (this.r.isRecordCompleted()) {
          ObserverMgr.a().a(paramVALUE, false);
          this.r.setRecording(false);
          c(this.r.getVideoPath());
          return;
        } 
        bool = p();
        this.r.setRecording(bool);
        ObserverMgr.a().a(paramVALUE, bool);
        return;
      case 6:
        k();
        return;
      case 5:
        this.r.setShowVType(0);
        return;
      case 4:
        b(this.r.getSelectedFilter(), this.r.getSelectFilterPosition());
        return;
      case 2:
        J();
        return;
      case 1:
        G();
        break;
      case 3:
        break;
    } 
  }
  
  public void a(FilterItem paramFilterItem, int paramInt) {
    this.r.setSelectedFilter(paramFilterItem);
    this.r.setSelectFilterPosition(paramInt);
  }
  
  public void a(String paramString) {
    this.r.setHasBgMusic(true);
    this.r.setMusicPath(paramString);
    this.i.setMusicFile(paramString);
  }
  
  public boolean a(boolean paramBoolean) {
    return this.i.setFlashEnabled(paramBoolean);
  }
  
  public void ah_() {
    StvFragmentManager.a().b();
  }
  
  public void b() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(g);
    stringBuilder.append("destroy()");
    StvLogUtils.a(stringBuilder.toString(), new Object[0]);
    FeedStateObserverProxy.a().b(this);
    I();
    PLShortVideoRecorder pLShortVideoRecorder = this.i;
    if (pLShortVideoRecorder != null)
      pLShortVideoRecorder.destroy(); 
    SenseTimeQiniuShortVideoManager senseTimeQiniuShortVideoManager = this.q;
    if (senseTimeQiniuShortVideoManager != null)
      senseTimeQiniuShortVideoManager.onDestroy(); 
    ShineDataModel shineDataModel = this.r;
    if (shineDataModel != null)
      shineDataModel.clear(); 
  }
  
  public void b(FilterItem paramFilterItem, int paramInt) {
    if (paramFilterItem != null) {
      if (paramFilterItem.b() != null) {
        this.q.setFilterStyle(paramFilterItem.b());
        return;
      } 
      this.q.setFilterStyle(null);
    } 
  }
  
  public void c() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(g);
    stringBuilder.append("resume()");
    StvLogUtils.a(stringBuilder.toString(), new Object[0]);
    H();
    this.i.resume();
    K();
  }
  
  public void d() {
    SenseTimeQiniuShortVideoManager senseTimeQiniuShortVideoManager = this.q;
    if (senseTimeQiniuShortVideoManager != null)
      senseTimeQiniuShortVideoManager.onStop(); 
  }
  
  public void e() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(g);
    stringBuilder.append("pause()");
    StvLogUtils.a(stringBuilder.toString(), new Object[0]);
    this.i.pause();
    SenseTimeQiniuShortVideoManager senseTimeQiniuShortVideoManager = this.q;
    if (senseTimeQiniuShortVideoManager != null)
      senseTimeQiniuShortVideoManager.onPause(); 
    I();
  }
  
  public void f() {
    SenseTimeQiniuShortVideoManager senseTimeQiniuShortVideoManager = this.q;
    if (senseTimeQiniuShortVideoManager != null)
      senseTimeQiniuShortVideoManager.onStart(); 
  }
  
  public boolean g() {
    if (D() != null) {
      ShineDataModel shineDataModel = this.r;
      if (shineDataModel == null)
        return false; 
      int i = shineDataModel.getShowVType();
      if (i != 2) {
        if (i != 5) {
          if (D().e().i()) {
            D().c_(0);
            return true;
          } 
          u();
          D().getActivity().finish();
          return false;
        } 
        return true;
      } 
      D().d();
      this.r.setShowVType(0);
      return true;
    } 
    return false;
  }
  
  public void h() {
    StringBuilder stringBuilder;
    this.r.setCurrentPage(1);
    this.p = false;
    IShineView iShineView = D();
    if (iShineView == null || iShineView.getActivity() == null || iShineView.getActivity().isFinishing()) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(g);
      stringBuilder.append(" getView() == null!!!");
      StvLogUtils.a(stringBuilder.toString(), new Object[0]);
      return;
    } 
    stringBuilder.a(o(), m(), n());
  }
  
  public void i() {
    StringBuilder stringBuilder;
    this.r.setCurrentPage(5);
    this.p = true;
    IShineView iShineView = D();
    if (iShineView == null || iShineView.getActivity() == null || iShineView.getActivity().isFinishing()) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(g);
      stringBuilder.append(" getView() == null!!!");
      StvLogUtils.a(stringBuilder.toString(), new Object[0]);
      return;
    } 
    stringBuilder.a(o(), m(), n());
  }
  
  public void j() {
    if (m() == 2) {
      D().getActivity().finish();
      return;
    } 
    AlbumProxy.a().a(D().b(), this.r.getFrom(), 1, 4);
  }
  
  public void k() {
    if (D() == null || D().getActivity() == null || D().getActivity().isFinishing()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(g);
      stringBuilder.append(" getView() == null!!!");
      StvLogUtils.a(stringBuilder.toString(), new Object[0]);
      return;
    } 
    D().b(true);
    this.i.captureFrame(new PLCaptureFrameListener(this) {
          public void onFrameCaptured(PLVideoFrame param1PLVideoFrame) {
            StringBuilder stringBuilder;
            IShineView iShineView = this.a.D();
            if (iShineView == null || iShineView.getActivity() == null || iShineView.getActivity().isFinishing()) {
              stringBuilder = new StringBuilder();
              stringBuilder.append(ShinePresenter.C());
              stringBuilder.append(" getView() == null!!!");
              StvLogUtils.a(stringBuilder.toString(), new Object[0]);
              return;
            } 
            if (stringBuilder == null) {
              iShineView.b(false);
              StvLogUtils.b(ShinePresenter.C(), new Object[] { "capture frame failed" });
              return;
            } 
            if (AppInfo.m()) {
              String str = ShinePresenter.C();
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append("captured frame width: ");
              stringBuilder1.append(stringBuilder.getWidth());
              stringBuilder1.append(" height: ");
              stringBuilder1.append(stringBuilder.getHeight());
              stringBuilder1.append(" timestamp: ");
              stringBuilder1.append(stringBuilder.getTimestampMs());
              StvLogUtils.c(str, new Object[] { stringBuilder1.toString() });
            } 
            VideoFrameModel.getInstance().saveVideoFrameToPicture((PLVideoFrame)stringBuilder, new IStvVideoFrameCallback(this) {
                  public void a(Object param2Object, PLVideoFrame param2PLVideoFrame, Bitmap param2Bitmap, String param2String) {
                    param2Object = this.a.a.D();
                    if (param2Object == null || param2Object.getActivity() == null || param2Object.getActivity().isFinishing()) {
                      param2Object = new StringBuilder();
                      param2Object.append(ShinePresenter.C());
                      param2Object.append(" getView() == null!!!");
                      StvLogUtils.a(param2Object.toString(), new Object[0]);
                      return;
                    } 
                    param2Object.a_(new Runnable(this, param2String, (IShineView)param2Object) {
                          public void run() {
                            ShinePresenter.b(this.c.a.a).setFramePath(this.a);
                            this.b.b(false);
                            this.c.a.a.l();
                          }
                        });
                  }
                });
          }
        });
  }
  
  public void l() {
    StringBuilder stringBuilder;
    IShineView iShineView = D();
    if (iShineView == null || iShineView.getActivity() == null || iShineView.getActivity().isFinishing()) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(g);
      stringBuilder.append(" getView() == null!!!");
      StvLogUtils.d(stringBuilder.toString(), new Object[0]);
      return;
    } 
    PhotoPreviewFragment.a(stringBuilder.b(), this.r.getFramePath(), 7);
  }
  
  public int m() {
    return this.r.getPrePageType();
  }
  
  public int n() {
    return this.r.getCurrentPage();
  }
  
  public int o() {
    return this.r.getFrom();
  }
  
  public void onAutoFocusStart() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(g);
    stringBuilder.append("auto focus start");
    StvLogUtils.a(stringBuilder.toString(), new Object[0]);
  }
  
  public void onAutoFocusStop() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(g);
    stringBuilder.append("auto focus stop");
    StvLogUtils.a(stringBuilder.toString(), new Object[0]);
  }
  
  public void onDurationTooShort() {
    if (D() == null || D().getActivity() == null || D().getActivity().isFinishing()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(g);
      stringBuilder.append(" getView() == null!!!");
      StvLogUtils.a(stringBuilder.toString(), new Object[0]);
      return;
    } 
    D().a_(new Runnable(this) {
          public void run() {
            ShinePresenter.a(this.a, R.string.stv_upload_video_time_too_short);
          }
        });
  }
  
  public void onError(int paramInt) {
    if (paramInt == 4) {
      this.m = "摄像头配置错误";
    } else if (paramInt == 5) {
      this.m = "麦克风配置错误";
    } 
    if (!TextUtils.isEmpty(this.m))
      StvLogUtils.a(this.m, new Object[0]); 
    if (D() == null || D().getActivity() == null || D().getActivity().isFinishing()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(g);
      stringBuilder.append(" getView() == null!!!");
      StvLogUtils.a(stringBuilder.toString(), new Object[0]);
      return;
    } 
    D().a_(new Runnable(this) {
          public void run() {
            ShinePresenter.a(this.a, R.string.common_net_error);
          }
        });
  }
  
  public void onManualFocusCancel() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(g);
    stringBuilder.append("manual focus canceled");
    StvLogUtils.a(stringBuilder.toString(), new Object[0]);
    D().ae_().d();
  }
  
  public void onManualFocusStart(boolean paramBoolean) {
    if (paramBoolean) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(g);
      stringBuilder1.append("manual focus begin success");
      StvLogUtils.a(stringBuilder1.toString(), new Object[0]);
      FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)D().ae_().getLayoutParams();
      layoutParams.leftMargin = this.n;
      layoutParams.topMargin = this.o;
      D().ae_().setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      D().ae_().a();
      return;
    } 
    D().ae_().d();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(g);
    stringBuilder.append("manual focus not supported");
    StvLogUtils.a(stringBuilder.toString(), new Object[0]);
  }
  
  public void onManualFocusStop(boolean paramBoolean) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(g);
    stringBuilder.append("manual focus end result: ");
    stringBuilder.append(paramBoolean);
    StvLogUtils.a(stringBuilder.toString(), new Object[0]);
    if (paramBoolean) {
      D().ae_().b();
      return;
    } 
    D().ae_().c();
  }
  
  public void onProgressUpdate(float paramFloat) {
    if (D() == null || D().getActivity() == null || D().getActivity().isFinishing()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(g);
      stringBuilder.append(" getView() == null");
      StvLogUtils.a(stringBuilder.toString(), new Object[0]);
      return;
    } 
    D().a_(new Runnable(this, paramFloat) {
          public void run() {
            this.b.D().a(this.a);
          }
        });
  }
  
  public void onReady() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(g);
    stringBuilder.append("onReady()");
    StvLogUtils.a(stringBuilder.toString(), new Object[0]);
    if (D() == null || D().getActivity() == null || D().getActivity().isFinishing()) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(g);
      stringBuilder.append(" getView() == null!!!");
      StvLogUtils.a(stringBuilder.toString(), new Object[0]);
      return;
    } 
    D().a_(new Runnable(this) {
          public void run() {
            this.a.D().c();
          }
        });
  }
  
  public void onRecordCompleted() {
    if (D() == null || D().getActivity() == null || D().getActivity().isFinishing()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(g);
      stringBuilder.append(" getView() == null");
      StvLogUtils.a(stringBuilder.toString(), new Object[0]);
      return;
    } 
    this.i.concatSections(this);
    this.r.setRecordCompleted(true);
    D().a_(new Runnable(this) {
          public void run() {
            this.a.D().b(false);
            this.a.D().c(true);
          }
        });
  }
  
  public void onRecordStarted() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(g);
    stringBuilder.append("record start time: ");
    stringBuilder.append(System.currentTimeMillis());
    StvLogUtils.a(stringBuilder.toString(), new Object[0]);
    if (D() == null || D().getActivity() == null || D().getActivity().isFinishing()) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(g);
      stringBuilder.append(" getView() == null");
      StvLogUtils.a(stringBuilder.toString(), new Object[0]);
      return;
    } 
    D().a_(new Runnable(this) {
          public void run() {
            this.a.D().e().setCurrentState(SectionProgressBar.State.a);
          }
        });
  }
  
  public void onRecordStopped() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(g);
    stringBuilder.append("record stop time: ");
    stringBuilder.append(System.currentTimeMillis());
    StvLogUtils.a(stringBuilder.toString(), new Object[0]);
    if (D() == null || D().getActivity() == null || D().getActivity().isFinishing()) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(g);
      stringBuilder.append(" getView() == null");
      StvLogUtils.a(stringBuilder.toString(), new Object[0]);
      return;
    } 
    D().a_(new Runnable(this) {
          public void run() {
            this.a.D().e().setCurrentState(SectionProgressBar.State.b);
          }
        });
  }
  
  public void onSaveVideoCanceled() {
    if (D() == null || D().getActivity() == null || D().getActivity().isFinishing()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(g);
      stringBuilder.append(" getView() == null");
      StvLogUtils.a(stringBuilder.toString(), new Object[0]);
      return;
    } 
    D().a_(new Runnable(this) {
          public void run() {
            this.a.D().c(false);
          }
        });
  }
  
  public void onSaveVideoFailed(int paramInt) {
    if (D() == null || D().getActivity() == null || D().getActivity().isFinishing()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(g);
      stringBuilder.append(" getView() == null");
      StvLogUtils.a(stringBuilder.toString(), new Object[0]);
      return;
    } 
    D().a_(new Runnable(this, paramInt) {
          public void run() {
            this.b.D().c(false);
            String str = this.b.D().getContext().getString(R.string.stv_video_progress_error);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" :");
            stringBuilder.append(this.a);
            StvLogUtils.a(stringBuilder.toString(), new Object[0]);
            ShinePresenter.a(this.b, str);
          }
        });
  }
  
  public void onSaveVideoSuccess(String paramString) {
    StringBuilder stringBuilder1;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(g);
    stringBuilder2.append("concat sections success filePath: ");
    stringBuilder2.append(paramString);
    StvLogUtils.a(stringBuilder2.toString(), new Object[0]);
    if (D() == null || D().getActivity() == null || D().getActivity().isFinishing()) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(g);
      stringBuilder1.append(" getView() == null");
      StvLogUtils.a(stringBuilder1.toString(), new Object[0]);
      return;
    } 
    D().a_(new Runnable(this, (String)stringBuilder1) {
          public void run() {
            this.b.D().c(false);
            ShinePresenter.b(this.b).setVideoPath(this.a);
            ShinePresenter.b(this.b, this.a);
          }
        });
  }
  
  public void onSectionDecreased(long paramLong1, long paramLong2, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(g);
    stringBuilder.append("section decreased decDuration: ");
    stringBuilder.append(paramLong1);
    stringBuilder.append(" totalDuration: ");
    stringBuilder.append(paramLong2);
    stringBuilder.append(" sectionCount: ");
    stringBuilder.append(paramInt);
    StvLogUtils.a(stringBuilder.toString(), new Object[0]);
    if (D() == null || D().getActivity() == null || D().getActivity().isFinishing()) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(g);
      stringBuilder.append(" getView() == null");
      StvLogUtils.a(stringBuilder.toString(), new Object[0]);
      return;
    } 
    D().a_(new Runnable(this, paramLong2, paramInt) {
          public void run() {
            ShinePresenter.b(this.c).onSectionCountChanged(this.a, this.b);
            if (this.a <= 0L) {
              ShinePresenter.b(this.c).setMusicPath(null);
              ShinePresenter.c(this.c).setVideoFilepath(StvTools.b());
            } 
            this.c.D().a(this.b, this.a, false);
            this.c.D().e().g();
          }
        });
  }
  
  public void onSectionIncreased(long paramLong1, long paramLong2, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(g);
    stringBuilder.append("section increased incDuration: ");
    stringBuilder.append(paramLong1);
    stringBuilder.append(" totalDuration: ");
    stringBuilder.append(paramLong2);
    stringBuilder.append(" sectionCount: ");
    stringBuilder.append(paramInt);
    StvLogUtils.a(stringBuilder.toString(), new Object[0]);
    if (D() == null || D().getActivity() == null || D().getActivity().isFinishing()) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(g);
      stringBuilder.append(" getView() == null");
      StvLogUtils.a(stringBuilder.toString(), new Object[0]);
      return;
    } 
    D().a_(new Runnable(this, paramLong2, paramInt) {
          public void run() {
            ShinePresenter.b(this.c).onSectionCountChanged(this.a, this.b);
            this.c.D().a(this.b, this.a, true);
            this.c.D().e().a(this.a);
          }
        });
  }
  
  public void onSectionRecording(long paramLong1, long paramLong2, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(g);
    stringBuilder.append("section recording sectionDurationMs: ");
    stringBuilder.append(paramLong1);
    stringBuilder.append(" videoDurationMs: ");
    stringBuilder.append(paramLong2);
    stringBuilder.append(" sectionCount: ");
    stringBuilder.append(paramInt);
    StvLogUtils.a(stringBuilder.toString(), new Object[0]);
  }
  
  public boolean p() {
    boolean bool = this.i.beginSection();
    this.r.setBeginSection(bool);
    if (bool) {
      ShineDataModel shineDataModel = this.r;
      shineDataModel.setMusicPath(shineDataModel.getMusicPath());
    } 
    return bool;
  }
  
  public boolean q() {
    boolean bool = this.i.endSection();
    if (bool)
      this.r.setBeginSection(false); 
    return bool;
  }
  
  public boolean r() {
    boolean bool = this.i.deleteAllSections();
    if (bool) {
      this.r.setRecordCompleted(false);
      this.r.onSectionCountChanged(0L, 0);
      this.r.setMusicPath(null);
      this.k.setVideoFilepath(StvTools.b());
      D().e().h();
      D().a(0, 0L, false);
    } 
    return bool;
  }
  
  public boolean s() {
    boolean bool = this.i.deleteLastSection();
    if (bool)
      this.r.setRecordCompleted(false); 
    return bool;
  }
  
  public void t() {
    this.i.concatSections(this);
  }
  
  public void u() {
    this.i.cancelConcat();
  }
  
  public void v() {
    String str = this.r.getVideoPath();
    StvThreadPoolHelper.a().a((Runnable)new StvThreadPoolHelper.StvThread(new Runnable(this, str) {
            public void run() {
              if (!TextUtils.isEmpty(this.a)) {
                File file = new File(this.a);
                if (file.exists())
                  file.delete(); 
              } 
            }
          }));
  }
  
  public void w() {
    this.i.switchCamera();
    SenseTimeQiniuShortVideoManager senseTimeQiniuShortVideoManager = this.q;
    if (senseTimeQiniuShortVideoManager != null)
      senseTimeQiniuShortVideoManager.switchCamera(); 
    this.r.setCurrentCameraId(StvCameraUtils.a(this.l.getCameraId()));
  }
  
  public long x() {
    return this.r.getMinRecordDuration();
  }
  
  public double y() {
    return this.r.getRecordSpeed();
  }
  
  public boolean z() {
    return this.r.isRecordSection();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\presenter\ShinePresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */