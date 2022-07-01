package com.blued.android.module.live_china.view;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Chronometer;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.core.util.Pair;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.net.http.FileDownloader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedHttpUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.live.base.utils.LiveTimeAndDateUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.manager.PlayGifObserver;
import com.blued.android.module.live_china.model.GrabBoxModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.OpenBoxModel;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GrabBoxView extends FrameLayout implements View.OnClickListener {
  public BaseFragment a;
  
  public ActivityFragmentActive b;
  
  public boolean c;
  
  PopGrabBoxView.DismissLisnter d = new PopGrabBoxView.DismissLisnter(this) {
      public void a() {
        if (this.a.a instanceof PlayingOnliveFragment) {
          LiveRefreshUIObserver.a().d(0);
          LiveSetDataObserver.a().e(0);
          return;
        } 
        if (this.a.a instanceof RecordingOnliveFragment) {
          if ((GrabBoxView.a(this.a)).be) {
            GrabBoxView.a(this.a).h(0);
          } else {
            GrabBoxView.a(this.a).g(0);
          } 
          (GrabBoxView.a(this.a)).cG.a(0);
        } 
      }
      
      public void b() {
        if (this.a.a instanceof PlayingOnliveFragment) {
          LiveRefreshUIObserver.a().d(4);
          LiveSetDataObserver.a().e(4);
          return;
        } 
        if (this.a.a instanceof RecordingOnliveFragment) {
          if ((GrabBoxView.a(this.a)).be) {
            GrabBoxView.a(this.a).h(4);
          } else {
            GrabBoxView.a(this.a).g(4);
          } 
          (GrabBoxView.a(this.a)).cG.a(4);
        } 
      }
    };
  
  private View e;
  
  private Context f;
  
  private LayoutInflater g;
  
  private ImageView h;
  
  private BackgroundTextView i;
  
  private ProgressBar j;
  
  private LinearLayout k;
  
  private Chronometer l;
  
  private RecordingOnliveFragment m;
  
  private PlayingOnliveFragment n;
  
  private List<GrabBoxModel> o = new ArrayList<GrabBoxModel>();
  
  private GrabBoxModel p;
  
  private Set<String> q = new HashSet<String>();
  
  private Handler r = new Handler();
  
  private long s;
  
  public GrabBoxView(Context paramContext) {
    this(paramContext, null);
  }
  
  public GrabBoxView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.f = paramContext;
    b();
  }
  
  private void a(GrabBoxModel paramGrabBoxModel1, GrabBoxModel paramGrabBoxModel2) {
    paramGrabBoxModel2.type = paramGrabBoxModel1.type;
    paramGrabBoxModel2.duration = paramGrabBoxModel1.duration;
    paramGrabBoxModel2.progress = paramGrabBoxModel1.progress;
  }
  
  private void a(GrabBoxModel paramGrabBoxModel, boolean paramBoolean) {
    setVisibility(0);
    d();
    setBoxImage(paramGrabBoxModel);
    setReceiveBtn(paramGrabBoxModel);
    if (!paramBoolean && paramGrabBoxModel != null && paramGrabBoxModel.type == 2) {
      Logger.a("drb", new Object[] { "下一个宝箱也是开启状态，继续倒计时 宝箱id为 = ", paramGrabBoxModel.box_id });
      LiveMsgSendManager liveMsgSendManager = LiveMsgSendManager.a();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("下一个宝箱也是开启状态，继续倒计时 宝箱id为 = ");
      stringBuilder.append(paramGrabBoxModel.box_id);
      liveMsgSendManager.b(stringBuilder.toString());
      this.r.removeCallbacksAndMessages(null);
      this.r.postDelayed(new DurationThread(this, this.p), 1000L);
    } 
  }
  
  private void a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    String str = RecyclingUtils.e(paramString);
    if ((new File(str)).exists())
      return; 
    synchronized (this.q) {
      if (this.q.contains(paramString))
        return; 
      this.q.add(paramString);
      FileDownloader.a(paramString, str, null, null);
      return;
    } 
  }
  
  private void b() {
    this.g = LayoutInflater.from(this.f);
    this.e = this.g.inflate(R.layout.live_grab_box_layout, (ViewGroup)this, true);
    this.h = (ImageView)this.e.findViewById(R.id.grab_box_image);
    this.i = (BackgroundTextView)this.e.findViewById(R.id.grab_box_num);
    this.j = (ProgressBar)this.e.findViewById(R.id.grab_box_progress);
    this.k = (LinearLayout)this.e.findViewById(R.id.receive_btn);
    this.l = (Chronometer)this.e.findViewById(R.id.grab_box_chronometer);
    this.h.setOnClickListener(this);
    this.k.setOnClickListener(this);
    setVisibility(8);
  }
  
  private void b(GrabBoxModel paramGrabBoxModel) {
    Logger.a("drb", new Object[] { "删除当前宝箱 = ", paramGrabBoxModel.box_id });
    LiveMsgSendManager liveMsgSendManager = LiveMsgSendManager.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("删除当前宝箱 = ");
    stringBuilder.append(paramGrabBoxModel.box_id);
    liveMsgSendManager.b(stringBuilder.toString());
    if (!this.o.remove(paramGrabBoxModel))
      for (int i = 0; i < this.o.size(); i++) {
        GrabBoxModel grabBoxModel = this.o.get(i);
        if (grabBoxModel.box_id.equals(paramGrabBoxModel.box_id)) {
          this.o.remove(grabBoxModel);
          break;
        } 
      }  
    if (this.o.size() > 0) {
      this.p = this.o.get(0);
      Logger.a("drb", new Object[] { "删除当前宝箱后 还有宝箱 新宝箱id = ", this.p.box_id });
      Logger.a("drb", new Object[] { "初始化宝箱" });
      LiveMsgSendManager liveMsgSendManager1 = LiveMsgSendManager.a();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("删除当前宝箱后 还有宝箱 新宝箱id = ");
      stringBuilder1.append(this.p.box_id);
      stringBuilder1.append(" -- 初始化宝箱");
      liveMsgSendManager1.b(stringBuilder1.toString());
      a(this.p, false);
      return;
    } 
    this.p = null;
    setVisibility(8);
    BaseFragment baseFragment = this.a;
    if (baseFragment instanceof PlayingOnliveFragment) {
      LiveSetDataObserver.a().n();
      return;
    } 
    if (baseFragment instanceof RecordingOnliveFragment)
      this.m.K(); 
  }
  
  private boolean b(String paramString) {
    for (int i = 0; i < this.o.size(); i++) {
      if (((GrabBoxModel)this.o.get(i)).box_id.equals(paramString))
        return true; 
    } 
    return false;
  }
  
  private void c() {
    if (this.o.size() > 0) {
      List<GrabBoxModel> list = this.o;
      setBoxProgress(list.get(list.size() - 1));
      return;
    } 
    setBoxProgress(this.p);
  }
  
  private void c(GrabBoxModel paramGrabBoxModel) {
    this.l.setVisibility(0);
    this.l.setOnChronometerTickListener(new MyChronometerTickListener(this, paramGrabBoxModel));
    this.l.start();
  }
  
  private void d() {
    int i = 0;
    int j;
    for (j = 0; i < this.o.size(); j = k) {
      int k = j;
      if (((GrabBoxModel)this.o.get(i)).type == 2)
        k = j + 1; 
      i++;
    } 
    Logger.a("drb", new Object[] { "设置右上角宝箱数量 = ", Integer.valueOf(j) });
    LiveMsgSendManager liveMsgSendManager = LiveMsgSendManager.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("设置右上角宝箱数量 = ");
    stringBuilder.append(j);
    liveMsgSendManager.b(stringBuilder.toString());
    if (j < 1) {
      this.i.setVisibility(8);
      return;
    } 
    this.i.setVisibility(0);
    this.i.setBadgeCount(j);
  }
  
  private boolean e() {
    boolean bool = false;
    int i = 0;
    int j;
    for (j = 0; i < this.o.size(); j = k) {
      GrabBoxModel grabBoxModel = this.o.get(i);
      Logger.a("drb", new Object[] { "hasUnclaimedBox type = ", Integer.valueOf(grabBoxModel.type) });
      int k = j;
      if (grabBoxModel.type == 2)
        k = j + 1; 
      i++;
    } 
    if (j > 0)
      bool = true; 
    return bool;
  }
  
  private int getBoxOpenNum() {
    int i = 0;
    int j;
    for (j = 0; i < this.o.size(); j = k) {
      int k = j;
      if (((GrabBoxModel)this.o.get(i)).type == 2)
        k = j + 1; 
      i++;
    } 
    return j;
  }
  
  private void setBoxImage(GrabBoxModel paramGrabBoxModel) {
    if (paramGrabBoxModel == null)
      return; 
    ImageLoader.a(null, paramGrabBoxModel.box_image).a(this.h);
    Logger.a("drb", new Object[] { "model.box_image = ", paramGrabBoxModel.box_image });
  }
  
  private void setBoxProgress(GrabBoxModel paramGrabBoxModel) {
    if (paramGrabBoxModel == null)
      return; 
    if (Build.VERSION.SDK_INT >= 24) {
      this.j.setProgress(paramGrabBoxModel.progress, true);
    } else {
      this.j.setProgress(paramGrabBoxModel.progress);
    } 
    Logger.a("drb", new Object[] { "setBoxProgress", Integer.valueOf(paramGrabBoxModel.progress) });
    LiveMsgSendManager liveMsgSendManager = LiveMsgSendManager.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setBoxProgress");
    stringBuilder.append(paramGrabBoxModel.progress);
    liveMsgSendManager.b(stringBuilder.toString());
  }
  
  private void setBoxReceive(String paramString) {
    for (int i = 0; i < this.o.size(); i++) {
      GrabBoxModel grabBoxModel = this.o.get(i);
      if (grabBoxModel.box_id.equals(paramString)) {
        grabBoxModel.type = 4;
        return;
      } 
    } 
  }
  
  private void setReceiveBtn(GrabBoxModel paramGrabBoxModel) {
    if (paramGrabBoxModel == null)
      return; 
    if (paramGrabBoxModel.type == 2) {
      if (this.c)
        return; 
      Logger.a("drb", new Object[] { "setReceiveBtn 显示领取按钮   " });
      LiveMsgSendManager.a().b("setReceiveBtn 显示领取按钮");
      this.k.setVisibility(0);
      return;
    } 
    Logger.a("drb", new Object[] { "setReceiveBtn 隐藏领取按钮  " });
    LiveMsgSendManager.a().b("setReceiveBtn 隐藏领取按钮");
    this.k.setVisibility(8);
  }
  
  public List<GrabBoxModel> a(List<GrabBoxModel> paramList) {
    ArrayList<GrabBoxModel> arrayList = new ArrayList();
    for (int i = 0; i < paramList.size(); i++) {
      if (!arrayList.contains(paramList.get(i)))
        arrayList.add(paramList.get(i)); 
    } 
    return arrayList;
  }
  
  public void a(BaseFragment paramBaseFragment) {
    this.a = paramBaseFragment;
    if (paramBaseFragment instanceof RecordingOnliveFragment) {
      this.c = true;
      this.m = (RecordingOnliveFragment)paramBaseFragment;
      this.b = this.m.w_();
      this.s = this.m.u;
      return;
    } 
    if (paramBaseFragment instanceof PlayingOnliveFragment) {
      this.c = false;
      this.n = (PlayingOnliveFragment)paramBaseFragment;
      this.b = this.n.w_();
      this.s = this.n.u;
    } 
  }
  
  public void a(GrabBoxModel paramGrabBoxModel) {
    if (paramGrabBoxModel == null)
      return; 
    Logger.a("drb", new Object[] { "调用领取宝箱接口 id = ", paramGrabBoxModel.box_id });
    LiveRoomHttpUtils.a(this.f, new BluedUIHttpResponse<BluedEntity<OpenBoxModel, OpenBoxModel>>(this, paramGrabBoxModel) {
          public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
            super.onFailure(param1Throwable, param1Int, param1String);
            AppInfo.n().post(new Runnable(this, param1Throwable, param1Int, param1String) {
                  public void run() {
                    Pair pair = BluedHttpUtils.a(this.a, this.b, this.c);
                    Logger.a("drb", new Object[] { "领取宝箱失败 id = ", this.d.a.box_id });
                    if (pair != null) {
                      if (((Integer)pair.first).intValue() == 40301001) {
                        GrabBoxView.a(this.d.b, this.d.a.box_id);
                        Logger.a("drb", new Object[] { "领取宝箱失败 删除当前宝箱 id = ", this.d.a.box_id });
                        GrabBoxView.c(this.d.b, this.d.a);
                        GrabBoxView.b(this.d.b);
                        AppMethods.a((CharSequence)pair.second);
                        return;
                      } 
                      BluedHttpUtils.b(this.a, this.b, this.c);
                    } 
                  }
                });
          }
          
          public void onUIFinish() {}
          
          public void onUIUpdate(BluedEntity<OpenBoxModel, OpenBoxModel> param1BluedEntity) {
            if (param1BluedEntity != null && param1BluedEntity.extra != null) {
              OpenBoxModel openBoxModel = (OpenBoxModel)param1BluedEntity.extra;
              if (this.b.a instanceof PlayingOnliveFragment) {
                LiveMsgSendManager liveMsgSendManager = LiveMsgSendManager.a();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("领取宝箱成功 id = ");
                stringBuilder.append(this.a.box_id);
                stringBuilder.append("-- duration = ");
                stringBuilder.append(this.a.duration);
                liveMsgSendManager.b(stringBuilder.toString());
                Logger.a("drb", new Object[] { "领取宝箱成功 id = ", this.a.box_id, "-- duration = ", Integer.valueOf(this.a.duration) });
                LiveRefreshUIObserver.a().a(this.a);
                LiveRefreshUIObserver.a().a(openBoxModel.num, openBoxModel.pic);
                GrabBoxModel grabBoxModel = this.a;
                grabBoxModel.type = 4;
                GrabBoxView.a(this.b, grabBoxModel.box_id);
                GrabBoxView.b(this.b);
                if (GrabBoxView.c(this.b)) {
                  Logger.a("drb", new Object[] { "领取宝箱成功 还有未领取的宝箱" });
                  if (GrabBoxView.b(this.b, this.a.box_id)) {
                    Logger.a("drb", new Object[] { "当前宝箱队列含有当前领取的宝箱id 隐藏领取按钮" });
                    GrabBoxView.a(this.b, this.a);
                    Logger.a("drb", new Object[] { "领取宝箱成功 开启展示倒计时" });
                    GrabBoxView.b(this.b, this.a);
                    GrabBoxView.d(this.b).removeCallbacksAndMessages(null);
                  } 
                } else {
                  Logger.a("drb", new Object[] { "领取宝箱成功 没有未领取的宝箱" });
                  Logger.a("drb", new Object[] { "领取宝箱成功 隐藏领取按钮" });
                  GrabBoxView.a(this.b, this.a);
                } 
                if (openBoxModel.goods_id == 1) {
                  LiveRefreshUIObserver.a().o();
                  return;
                } 
                LiveEventBus.get("live_refresh_gift_list").post(Boolean.valueOf(true));
              } 
            } 
          }
        }this.p.box_id, this.s, (IRequestHost)this.b);
  }
  
  public boolean a() {
    return (this.o.size() > 0);
  }
  
  public void onClick(View paramView) {
    String str;
    if (paramView.getId() == R.id.grab_box_image) {
      if (this.o.size() > 0) {
        List<GrabBoxModel> list = this.o;
        str = ((GrabBoxModel)list.get(list.size() - 1)).box_id;
      } else {
        str = "";
      } 
      if (TextUtils.isEmpty(str))
        return; 
      if (this.c) {
        if (LiveFloatManager.a().B()) {
          PopGrabBoxCenterView.a(this.a, LiveRoomInfo.a().f(), str, this.d, (IRequestHost)this.a.w_());
          return;
        } 
        PopGrabBoxView.b(this.a, LiveRoomInfo.a().f(), str, this.d, (IRequestHost)this.a.w_());
        return;
      } 
      if (LiveFloatManager.a().B()) {
        if (this.n != null && !LiveRoomManager.a().l()) {
          PopGrabBoxCenterView.a(this.a, LiveRoomManager.a().e(), str, this.d, (IRequestHost)this.a.w_());
          return;
        } 
      } else if (this.n != null && !LiveRoomManager.a().l()) {
        PopGrabBoxView.b(this.a, LiveRoomManager.a().e(), str, this.d, (IRequestHost)this.a.w_());
        return;
      } 
    } else if (str.getId() == R.id.receive_btn) {
      a(this.p);
    } 
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    this.r.removeCallbacksAndMessages(null);
  }
  
  public void setData(List<GrabBoxModel> paramList) {
    GrabBoxModel grabBoxModel = paramList.get(0);
    if (this.p != null && grabBoxModel.type == 1 && grabBoxModel.index < this.p.index) {
      Logger.a("drb", new Object[] { "新宝箱消息的index小于老宝箱的index，那么丢弃这条消息" });
      LiveMsgSendManager.a().b("新宝箱消息的index小于老宝箱的index，那么丢弃这条消息");
      return;
    } 
    this.o.addAll(paramList);
    this.o = a(this.o);
    Collections.sort(this.o, (Comparator<? super GrabBoxModel>)new GrabBoxModel.GrabBoxModelComparator());
    int i;
    for (i = 0; i < this.o.size(); i++) {
      GrabBoxModel grabBoxModel1 = this.o.get(i);
      LiveMsgSendManager liveMsgSendManager = LiveMsgSendManager.a();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("model index = ");
      stringBuilder.append(grabBoxModel1.index);
      stringBuilder.append(",,,,box_id = ");
      stringBuilder.append(grabBoxModel1.box_id);
      liveMsgSendManager.b(stringBuilder.toString());
      Logger.a("drb", new Object[] { "model index = ", Integer.valueOf(grabBoxModel1.index), ",,,,box_id = ", grabBoxModel1.box_id });
    } 
    if (this.o.size() > 0) {
      this.p = this.o.get(0);
      Logger.a("drb", new Object[] { "收到宝箱消息 ＝ ", grabBoxModel.toString() });
      LiveMsgSendManager liveMsgSendManager = LiveMsgSendManager.a();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("收到宝箱消息 ＝ ");
      stringBuilder.append(grabBoxModel.toString());
      liveMsgSendManager.b(stringBuilder.toString());
      Logger.a("drb", new Object[] { "初始化UI" });
      a(this.p, true);
      a(this.p.progress_full_gif);
      a(this.p.box_gif);
    } 
    if (grabBoxModel.type == 2) {
      setVisibility(0);
      GrabBoxModel grabBoxModel1 = this.p;
      if (grabBoxModel1 != null && !TextUtils.isEmpty(grabBoxModel1.box_id) && this.p.box_id.equals(grabBoxModel.box_id)) {
        if (!this.p.isPlayAnim) {
          Logger.a("drb", new Object[] { "这是宝箱开启消息 当前正在展示的宝箱" });
          LiveMsgSendManager.a().b("这是宝箱开启消息 当前正在展示的宝箱");
          LiveGiftModel liveGiftModel = new LiveGiftModel();
          liveGiftModel.images_gif = this.p.progress_full_gif;
          BaseFragment baseFragment = this.a;
          if (baseFragment instanceof PlayingOnliveFragment) {
            LiveSetDataObserver.a().b(liveGiftModel);
          } else if (baseFragment instanceof RecordingOnliveFragment) {
            this.m.a(liveGiftModel);
          } 
          this.p.isPlayAnim = true;
          PlayGifObserver.a().b();
        } 
        this.p = grabBoxModel;
        Logger.a("drb", new Object[] { "这是宝箱开启消息 设置领取按钮状态" });
        LiveMsgSendManager.a().b("这是宝箱开启消息 设置领取按钮状态");
        setReceiveBtn(this.p);
        for (i = 0; i < this.o.size(); i++) {
          grabBoxModel1 = this.o.get(i);
          if (!TextUtils.isEmpty(grabBoxModel1.box_id) && grabBoxModel1.box_id.equals(grabBoxModel.box_id)) {
            a(grabBoxModel, grabBoxModel1);
            break;
          } 
        } 
        Logger.a("drb", new Object[] { "宝箱开启消息 开始倒计时" });
        LiveMsgSendManager.a().b("这是宝箱开启消息  开始倒计时");
        this.r.removeCallbacksAndMessages(null);
        this.r.postDelayed(new DurationThread(this, this.p), 1000L);
      } else {
        Logger.a("drb", new Object[] { "这是宝箱开启消息 不是当前正在展示的宝箱" });
        LiveMsgSendManager.a().b("这是宝箱开启消息 不是当前正在展示的宝箱");
        for (i = 0; i < this.o.size(); i++) {
          grabBoxModel1 = this.o.get(i);
          if (!TextUtils.isEmpty(grabBoxModel1.box_id) && grabBoxModel1.box_id.equals(grabBoxModel.box_id)) {
            a(grabBoxModel, grabBoxModel1);
            if (!grabBoxModel1.isPlayAnim) {
              LiveGiftModel liveGiftModel = new LiveGiftModel();
              liveGiftModel.images_gif = this.p.progress_full_gif;
              BaseFragment baseFragment = this.a;
              if (baseFragment instanceof PlayingOnliveFragment) {
                LiveSetDataObserver.a().b(liveGiftModel);
              } else if (baseFragment instanceof RecordingOnliveFragment) {
                this.m.a(liveGiftModel);
              } 
              grabBoxModel1.isPlayAnim = true;
              PlayGifObserver.a().b();
            } 
            break;
          } 
        } 
        if (this.p.type == 4 && this.o.size() > 0) {
          c(this.o.get(0));
          setReceiveBtn(this.p);
          this.r.removeCallbacksAndMessages(null);
        } 
      } 
      d();
      List<GrabBoxModel> list = this.o;
      setBoxProgress(list.get(list.size() - 1));
    } 
    if (grabBoxModel.type == 1) {
      setVisibility(0);
      if (this.p != null && !TextUtils.isEmpty(grabBoxModel.box_id) && this.p.box_id.equals(grabBoxModel.box_id)) {
        Logger.a("drb", new Object[] { "这是宝箱进度消息 -- 当前宝箱 ＝ ", grabBoxModel.box_id });
        LiveMsgSendManager liveMsgSendManager = LiveMsgSendManager.a();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("这是宝箱进度消息 -- 当前宝箱 ＝ ");
        stringBuilder.append(grabBoxModel.box_id);
        liveMsgSendManager.b(stringBuilder.toString());
        this.p.progress = grabBoxModel.progress;
      } else {
        Logger.a("drb", new Object[] { "这是宝箱进度消息 -- 不是当前宝箱 ＝ ", grabBoxModel.box_id });
        LiveMsgSendManager liveMsgSendManager = LiveMsgSendManager.a();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("这是宝箱进度消息 -- 不是当前宝箱 ＝ ");
        stringBuilder.append(grabBoxModel.box_id);
        liveMsgSendManager.b(stringBuilder.toString());
        for (i = 0; i < this.o.size(); i++) {
          GrabBoxModel grabBoxModel1 = this.o.get(i);
          if (!TextUtils.isEmpty(grabBoxModel1.box_id) && grabBoxModel1.box_id.equals(grabBoxModel.box_id)) {
            a(grabBoxModel, grabBoxModel1);
            break;
          } 
        } 
      } 
      setBoxProgress(grabBoxModel);
    } 
    if (grabBoxModel.type == 3) {
      setVisibility(0);
      Logger.a("drb", new Object[] { "这是宝箱失效消息" });
      LiveMsgSendManager.a().b("这是宝箱失效消息");
      this.r.removeCallbacksAndMessages(Integer.valueOf(0));
      Logger.a("drb", new Object[] { "停止 隐藏倒计时 GONE" });
      LiveMsgSendManager.a().b("停止 隐藏倒计时 GONE");
      this.l.stop();
      this.l.setVisibility(8);
      for (i = 0; i < this.o.size(); i = j + 1) {
        GrabBoxModel grabBoxModel1 = this.o.get(i);
        Logger.a("drb", new Object[] { "列表中的数据有 index = ", Integer.valueOf(grabBoxModel1.index), "-- id = ", grabBoxModel1.box_id, "当前这条消息 index = ", Integer.valueOf(grabBoxModel.index) });
        int j = i;
        if (grabBoxModel1.index < grabBoxModel.index) {
          Logger.a("drb", new Object[] { "------------列表中比这条消息小的index数据有 index = ", Integer.valueOf(grabBoxModel1.index), "-- id = ", grabBoxModel1.box_id });
          this.o.remove(grabBoxModel1);
          j = i - 1;
        } 
      } 
      Logger.a("drb", new Object[] { "删除当前宝箱 id ＝ ", grabBoxModel.box_id });
      LiveMsgSendManager liveMsgSendManager = LiveMsgSendManager.a();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("删除当前宝箱 id ＝ ");
      stringBuilder.append(grabBoxModel.box_id);
      liveMsgSendManager.b(stringBuilder.toString());
      b(grabBoxModel);
    } 
    if (grabBoxModel.type == 4) {
      Logger.a("drb", new Object[] { "这是宝箱已领取消息" });
      LiveMsgSendManager.a().b("这是宝箱已领取消息");
      if (getBoxOpenNum() == 0) {
        Logger.a("drb", new Object[] { "没有可领取的宝箱" });
        LiveMsgSendManager.a().b("没有可领取的宝箱");
        this.r.removeCallbacksAndMessages(null);
        this.r.postDelayed(new DurationThread(this, grabBoxModel), 1000L);
        a(grabBoxModel, true);
        c();
        BaseFragment baseFragment = this.a;
        if (baseFragment instanceof PlayingOnliveFragment) {
          LiveSetDataObserver.a().n();
          return;
        } 
        if (baseFragment instanceof RecordingOnliveFragment) {
          this.m.K();
          return;
        } 
      } else {
        GrabBoxModel grabBoxModel1 = this.o.get(1);
        Logger.a("drb", new Object[] { "有多个宝箱 id =", grabBoxModel1.box_id });
        LiveMsgSendManager liveMsgSendManager = LiveMsgSendManager.a();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("有多个宝箱 id =");
        stringBuilder.append(grabBoxModel1.box_id);
        liveMsgSendManager.b(stringBuilder.toString());
        Logger.a("drb", new Object[] { "初始化宝箱 此时宝箱为队列中第二条" });
        LiveMsgSendManager.a().b("初始化宝箱 此时宝箱为队列中第二条");
        a(grabBoxModel1, true);
        c();
        Logger.a("drb", new Object[] { "隐藏领取按钮" });
        LiveMsgSendManager.a().b("隐藏领取按钮");
        setReceiveBtn(grabBoxModel);
        Logger.a("drb", new Object[] { "展示开启 倒计时" });
        LiveMsgSendManager.a().b("展示开启 倒计时");
        c(grabBoxModel);
      } 
    } 
  }
  
  class DurationThread implements Runnable {
    GrabBoxModel a;
    
    public DurationThread(GrabBoxView this$0, GrabBoxModel param1GrabBoxModel) {
      this.a = param1GrabBoxModel;
    }
    
    public void run() {
      if (this.a == null)
        return; 
      if (GrabBoxView.e(this.b) != null && this.a != GrabBoxView.e(this.b)) {
        GrabBoxModel grabBoxModel1 = GrabBoxView.e(this.b);
        grabBoxModel1.duration--;
      } 
      GrabBoxModel grabBoxModel = this.a;
      grabBoxModel.duration--;
      LiveMsgSendManager liveMsgSendManager = LiveMsgSendManager.a();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("开始倒计时删除： box id = ");
      stringBuilder.append(this.a.box_id);
      stringBuilder.append("---");
      stringBuilder.append(this.a.duration);
      liveMsgSendManager.b(stringBuilder.toString());
      if (this.a.duration == 0) {
        GrabBoxView.c(this.b, this.a);
        return;
      } 
      GrabBoxView.d(this.b).postDelayed(new DurationThread(this.b, this.a), 1000L);
    }
  }
  
  class MyChronometerTickListener implements Chronometer.OnChronometerTickListener {
    GrabBoxModel a;
    
    public MyChronometerTickListener(GrabBoxView this$0, GrabBoxModel param1GrabBoxModel) {
      this.a = param1GrabBoxModel;
    }
    
    public void onChronometerTick(Chronometer param1Chronometer) {
      GrabBoxModel grabBoxModel = this.a;
      if (grabBoxModel == null)
        return; 
      grabBoxModel.duration--;
      Logger.a("drb", new Object[] { "onChronometerTick id duration = ", this.a.box_id, "--", Integer.valueOf(this.a.duration) });
      if (this.a.duration <= 0) {
        param1Chronometer.stop();
        param1Chronometer.setVisibility(8);
        GrabBoxView.c(this.b, this.a);
        Logger.a("drb", new Object[] { "chronometer.stop" });
        return;
      } 
      param1Chronometer.setVisibility(0);
      param1Chronometer.setText(LiveTimeAndDateUtils.a(this.a.duration, false));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\GrabBoxView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */