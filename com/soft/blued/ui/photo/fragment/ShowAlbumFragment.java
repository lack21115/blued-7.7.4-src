package com.soft.blued.ui.photo.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.player.media.model.VideoPlayConfig;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.blued.das.profile.PersonalProfileProtos;
import com.github.chrisbanes.photoview.PhotoView;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.app.permission.PermissionHelper;
import com.soft.blued.customview.ActionSheet;
import com.soft.blued.customview.HackyViewPager;
import com.soft.blued.http.FeedHttpUtils;
import com.soft.blued.http.ProfileHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.model.LogData;
import com.soft.blued.log.trackUtils.EventTrackPersonalProfile;
import com.soft.blued.model.BluedAlbum;
import com.soft.blued.ui.feed.fragment.FeedDetailsFragment;
import com.soft.blued.ui.feed.manager.FeedMethods;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.feed.model.FeedComment;
import com.soft.blued.ui.feed.model.FeedRepost;
import com.soft.blued.ui.feed.observer.IFeedDataObserver;
import com.soft.blued.ui.find.observer.FeedRefreshObserver;
import com.soft.blued.ui.find.observer.UserInfoDataObserver;
import com.soft.blued.ui.photo.manager.AlbumViewDataManager;
import com.soft.blued.ui.photo.observer.AlbumDownLoadObserver;
import com.soft.blued.ui.photo.observer.PhotoListPositionObserver;
import com.soft.blued.ui.user.fragment.ReportFragmentNew;
import com.soft.blued.ui.user.model.AlbumFlow;
import com.soft.blued.ui.user.model.AlbumForDataTrans;
import com.soft.blued.ui.user.observer.AlbumDataObserver;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.AreaUtils;
import com.soft.blued.utils.DistanceUtils;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TimeAndDateUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import com.soft.blued.view.tip.CommonShowBottomWindow;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ShowAlbumFragment extends BasePhotoFragment implements View.OnClickListener, IFeedDataObserver, FeedRefreshObserver.IFeedRefreshObserver {
  public static AlbumForDataTrans f;
  
  private LinearLayout A;
  
  private LinearLayout B;
  
  private TextView C;
  
  private LinearLayout D;
  
  private ImageView E;
  
  private TextView F;
  
  private RelativeLayout G;
  
  private ImageView H;
  
  private LinearLayout I;
  
  private ImageView J;
  
  private LinearLayout K;
  
  private boolean L = true;
  
  private boolean M = true;
  
  private boolean N;
  
  private int O;
  
  private String P;
  
  private String Q;
  
  private View R;
  
  private TextView S;
  
  private int T;
  
  private boolean U;
  
  private AlbumFlow V;
  
  public LinearLayout g;
  
  public TextView h;
  
  AlbumViewDataManager.IAlbumDataListener i = new AlbumViewDataManager.IAlbumDataListener(this) {
      public void a() {
        AlbumDownLoadObserver.a().b();
      }
      
      public void a(boolean param1Boolean, List<AlbumFlow> param1List) {
        Log.v("drb", "onDownloadSuccess");
        int j = ShowAlbumFragment.b(this.a).getCurrentItem();
        ShowAlbumFragment.c(this.a).clear();
        if (param1List != null)
          ShowAlbumFragment.c(this.a).addAll(param1List); 
        for (int i = 0; i < ShowAlbumFragment.c(this.a).size(); i++) {
          AlbumFlow albumFlow = ShowAlbumFragment.c(this.a).get(i);
          if (albumFlow != null)
            Logger.a("drb", new Object[] { "id = ", Integer.valueOf(i), "name = ", albumFlow.user_name, "-- ", Boolean.valueOf(albumFlow.isOccupyModel) }); 
        } 
        if (param1Boolean)
          ShowAlbumFragment.c(this.a).add(ShowAlbumFragment.d(this.a)); 
        ShowAlbumFragment.b(this.a).setAdapter((PagerAdapter)ShowAlbumFragment.e(this.a));
        ShowAlbumFragment.b(this.a).setCurrentItem(j);
      }
    };
  
  BluedUIHttpResponse j = new BluedUIHttpResponse<BluedEntityA<FeedComment>>(this) {
      public void a(BluedEntityA<FeedComment> param1BluedEntityA) {
        if (param1BluedEntityA != null)
          try {
            if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
              FeedComment feedComment = param1BluedEntityA.data.get(0);
              LiveEventBus.get("feed_add_comment").post(feedComment);
              UserInfoDataObserver.a().c();
              AppMethods.a(this.a.getString(2131756054));
              return;
            } 
          } catch (Exception exception) {
            exception.printStackTrace();
            AppMethods.a(ShowAlbumFragment.i(this.a).getResources().getString(2131756082));
          }  
      }
      
      public void onUIFinish() {
        DialogUtils.b(ShowAlbumFragment.l(this.a));
      }
      
      public void onUIStart() {
        DialogUtils.a(ShowAlbumFragment.l(this.a));
      }
    };
  
  private Context k;
  
  private View l;
  
  private LayoutInflater m;
  
  private ImagePagerAdapter n;
  
  private LoadOptions o;
  
  private int p;
  
  private int q;
  
  private List<AlbumFlow> r = new ArrayList<AlbumFlow>();
  
  private AlbumFlow s;
  
  private Dialog t;
  
  private HackyViewPager u;
  
  private LinearLayout v;
  
  private TextView w;
  
  private LinearLayout x;
  
  private TextView y;
  
  private TextView z;
  
  private void a(TextView paramTextView, String paramString) {
    paramTextView.setText(StringUtils.a(StringUtils.a(StringUtils.a(paramString, (int)paramTextView.getTextSize(), 0), true, true, true, ""), true, new boolean[0]));
  }
  
  private void a(BluedIngSelfFeed paramBluedIngSelfFeed, int paramInt) {
    if (paramInt == 0 || paramInt == 1) {
      paramBluedIngSelfFeed.iliked = paramInt;
      boolean bool = false;
      try {
        int i = paramBluedIngSelfFeed.feed_dig;
        if (paramInt == 1) {
          paramInt = i + 1;
          paramBluedIngSelfFeed.isPlayLikeAnim = true;
        } else {
          paramInt = i - 1;
        } 
        if (paramInt < 0)
          paramInt = bool; 
      } catch (Exception exception) {
        paramInt = bool;
      } 
      paramBluedIngSelfFeed.feed_dig = paramInt;
    } 
    d(paramBluedIngSelfFeed);
  }
  
  private void a(BluedIngSelfFeed paramBluedIngSelfFeed, int paramInt, String paramString) {
    FeedHttpUtils.a(this.k, new BluedUIHttpResponse<BluedEntity>(this) {
          public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
            BluedHttpUtils.b(param1Throwable, param1Int, param1String);
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {}
        }UserInfo.a().i().getUid(), paramBluedIngSelfFeed.feed_id, paramInt, paramString, (IRequestHost)w_());
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2) {
    if (this.N)
      return; 
    if (paramBoolean2)
      this.T = 2; 
    this.H.setVisibility(8);
    this.v.setVisibility(8);
    if (!paramBoolean1) {
      this.N = false;
      this.L = false;
      this.M = false;
      return;
    } 
    Animation animation1 = AnimationUtils.loadAnimation(this.k, 2130772054);
    this.v.startAnimation(animation1);
    Animation animation2 = AnimationUtils.loadAnimation(this.k, 2130772062);
    this.H.startAnimation(animation2);
    animation1.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {
            ShowAlbumFragment.a(this.a, false);
            ShowAlbumFragment.b(this.a, false);
            ShowAlbumFragment.c(this.a, false);
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {
            ShowAlbumFragment.a(this.a, true);
          }
        });
  }
  
  private boolean a(AlbumFlow paramAlbumFlow) {
    return "1".equals(paramAlbumFlow.is_videos);
  }
  
  private void b(BluedIngSelfFeed paramBluedIngSelfFeed, int paramInt) {
    if (paramInt == 0 || paramInt == 1) {
      paramBluedIngSelfFeed.iliked = paramInt;
      int i = paramBluedIngSelfFeed.feed_dig;
      if (paramInt == 1) {
        paramInt = i + 1;
      } else {
        paramInt = i - 1;
      } 
      i = paramInt;
      if (paramInt < 0)
        i = 0; 
      paramBluedIngSelfFeed.feed_dig = i;
      c(paramBluedIngSelfFeed);
    } 
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2) {
    if (this.N)
      return; 
    if (paramBoolean2)
      this.T = 1; 
    this.H.setVisibility(0);
    if (this.O != 1) {
      this.v.setVisibility(0);
    } else {
      this.v.setVisibility(8);
    } 
    AlbumFlow albumFlow = this.V;
    if (albumFlow != null && albumFlow.isFeed == 0) {
      this.K.setVisibility(8);
      this.I.setVisibility(0);
    } else {
      this.K.setVisibility(0);
      this.I.setVisibility(8);
    } 
    if (!paramBoolean1) {
      this.N = false;
      this.L = true;
      this.M = true;
      return;
    } 
    if (this.O != 1) {
      Animation animation1 = AnimationUtils.loadAnimation(this.k, 2130772053);
      this.v.startAnimation(animation1);
    } 
    Animation animation = AnimationUtils.loadAnimation(this.k, 2130772061);
    this.H.startAnimation(animation);
    animation.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {
            ShowAlbumFragment.a(this.a, false);
            ShowAlbumFragment.b(this.a, true);
            ShowAlbumFragment.c(this.a, true);
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {
            ShowAlbumFragment.a(this.a, true);
          }
        });
  }
  
  private boolean b(AlbumFlow paramAlbumFlow) {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAlbumFlow != null) {
      bool1 = bool2;
      if (paramAlbumFlow.album_status == 0) {
        bool1 = bool2;
        if (!paramAlbumFlow.isSelf)
          bool1 = true; 
      } 
    } 
    return bool1;
  }
  
  private void c(View paramView) {
    boolean bool = paramView instanceof PhotoView;
    String str = "";
    if (bool) {
      PhotoView photoView = (PhotoView)paramView;
      LogData logData = new LogData();
      AlbumFlow albumFlow1 = this.V;
      if (albumFlow1 != null) {
        str1 = albumFlow1.feed_id;
      } else {
        str1 = "";
      } 
      logData.n = str1;
      logData.g = "6";
      logData.J = "feed_pic_click";
      AlbumFlow albumFlow2 = this.V;
      String str1 = str;
      if (albumFlow2 != null)
        str1 = albumFlow2.recommend_text; 
      logData.k = str1;
      InstantLog.a(logData);
      Logger.a("drb", new Object[] { "setPhotoClick" });
      if (photoView.getScale() > (int)photoView.getMinimumScale()) {
        photoView.a(photoView.getMinimumScale(), true);
        if (!this.L) {
          b(true, true);
          return;
        } 
      } else {
        r();
        return;
      } 
    } else {
      Log.v("drb", "");
    } 
  }
  
  private void c(BluedIngSelfFeed paramBluedIngSelfFeed) {
    this.D.setOnClickListener(new View.OnClickListener(this, paramBluedIngSelfFeed) {
          public void onClick(View param1View) {
            InstantLog.a(11, this.a, "", -1);
            if (!UserRelationshipUtils.a(this.a.relationship)) {
              if (this.a.iliked == 0) {
                BluedIngSelfFeed bluedIngSelfFeed1 = this.a;
                bluedIngSelfFeed1.iliked = 1;
                ShowAlbumFragment.a(this.b, bluedIngSelfFeed1, 1);
                ShowAlbumFragment showAlbumFragment = this.b;
                BluedIngSelfFeed bluedIngSelfFeed2 = this.a;
                ShowAlbumFragment.a(showAlbumFragment, bluedIngSelfFeed2, bluedIngSelfFeed2.is_ads, this.a.liked_url);
              } else {
                BluedIngSelfFeed bluedIngSelfFeed = this.a;
                bluedIngSelfFeed.iliked = 0;
                ShowAlbumFragment.a(this.b, bluedIngSelfFeed, 0);
                ShowAlbumFragment.a(this.b, this.a);
              } 
              if (this.a.feed_dig == 0) {
                ShowAlbumFragment.o(this.b).setText(2131759525);
              } else {
                ShowAlbumFragment.o(this.b).setText(AreaUtils.a(ShowAlbumFragment.i(this.b), Long.valueOf(this.a.feed_dig)));
              } 
            } 
            EventTrackPersonalProfile.c(PersonalProfileProtos.Event.PERSONAL_FULL_SCREEN_LIKE_CLICK, this.a.feed_uid, this.a.feed_id);
          }
        });
    e(paramBluedIngSelfFeed);
  }
  
  private void d(BluedIngSelfFeed paramBluedIngSelfFeed) {
    if (paramBluedIngSelfFeed.iliked == 0) {
      this.E.setImageResource(2131230928);
      this.F.setTextColor(this.k.getResources().getColor(2131100694));
    } else {
      ImageLoader.a((IRequestHost)w_(), 2131230927).a(this.E);
      this.F.setTextColor(this.k.getResources().getColor(2131100319));
    } 
    this.F.setText(AreaUtils.a(this.k, Long.valueOf(this.V.feed_dig)));
  }
  
  private void e(BluedIngSelfFeed paramBluedIngSelfFeed) {
    if (paramBluedIngSelfFeed.iliked == 0) {
      this.E.setImageResource(2131230928);
      this.F.setTextColor(this.k.getResources().getColor(2131100694));
    } else {
      ImageLoader.a((IRequestHost)w_(), 2131230927).a(this.E);
      this.F.setTextColor(this.k.getResources().getColor(2131100319));
    } 
    if (paramBluedIngSelfFeed.feed_dig == 0) {
      this.F.setText(2131759525);
      return;
    } 
    this.F.setText(AreaUtils.a(this.k, Long.valueOf(paramBluedIngSelfFeed.feed_dig)));
  }
  
  private void f(BluedIngSelfFeed paramBluedIngSelfFeed) {
    FeedHttpUtils.a(this.k, new BluedUIHttpResponse<BluedEntity>(this) {
          public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
            BluedHttpUtils.b(param1Throwable, param1Int, param1String);
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {}
        }UserInfo.a().i().getUid(), paramBluedIngSelfFeed.feed_id, paramBluedIngSelfFeed.is_ads, (IRequestHost)w_());
  }
  
  private void n() {
    Bundle bundle = getArguments();
    if (bundle != null) {
      this.O = getArguments().getInt("show_photo");
      this.P = getArguments().getString("WATER_MASK_NAME");
      this.Q = getArguments().getString("TARGET_UID");
      this.p = bundle.getInt("photo_index", 0);
      this.o = (LoadOptions)bundle.getSerializable("photo_options");
      this.q = this.p;
      if (f != null) {
        boolean bool = AlbumViewDataManager.a().d();
        this.r.addAll(f.data);
        if (bool && this.O != 15)
          this.r.add(p()); 
        f = null;
      } 
    } 
  }
  
  private void o() {
    this.t = DialogUtils.a((Context)getActivity());
    this.m = LayoutInflater.from(this.k);
    this.u = (HackyViewPager)this.l.findViewById(2131299443);
    this.v = (LinearLayout)this.l.findViewById(2131296554);
    this.w = (TextView)this.l.findViewById(2131297037);
    this.x = (LinearLayout)this.l.findViewById(2131298780);
    this.y = (TextView)this.l.findViewById(2131296943);
    this.z = (TextView)this.l.findViewById(2131300267);
    this.A = (LinearLayout)this.l.findViewById(2131298774);
    this.B = (LinearLayout)this.l.findViewById(2131298773);
    this.C = (TextView)this.l.findViewById(2131296801);
    this.D = (LinearLayout)this.l.findViewById(2131301789);
    this.E = (ImageView)this.l.findViewById(2131301786);
    this.F = (TextView)this.l.findViewById(2131301787);
    this.G = (RelativeLayout)this.l.findViewById(2131299353);
    this.I = (LinearLayout)this.l.findViewById(2131296432);
    this.J = (ImageView)this.l.findViewById(2131299513);
    this.K = (LinearLayout)this.l.findViewById(2131297041);
    this.g = (LinearLayout)this.l.findViewById(2131299162);
    this.h = (TextView)this.l.findViewById(2131299163);
    this.H = (ImageView)this.l.findViewById(2131296787);
    this.H.setOnClickListener(this);
    this.R = this.l.findViewById(2131300702);
    this.R.setOnClickListener(this);
    this.S = (TextView)this.l.findViewById(2131301182);
    this.n = new ImagePagerAdapter(this, getChildFragmentManager());
    this.u.setAdapter((PagerAdapter)this.n);
    this.u.setCurrentItem(this.p);
    this.R.setVisibility(8);
    this.S.setVisibility(8);
    this.u.setOnPageChangeListener(new ViewPager.OnPageChangeListener(this) {
          public void onPageScrollStateChanged(int param1Int) {}
          
          public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
          
          public void onPageSelected(int param1Int) {
            ShowAlbumFragment.a(this.a, param1Int);
            ShowAlbumFragment.a(this.a);
          }
        });
    t();
  }
  
  private AlbumFlow p() {
    if (this.s == null) {
      this.s = new AlbumFlow();
      AlbumFlow albumFlow = this.s;
      albumFlow.isOccupyModel = true;
      albumFlow.album_status = 1;
      albumFlow.isFeed = 1;
    } 
    return this.s;
  }
  
  private void q() {}
  
  private void r() {
    if (this.N)
      return; 
    if (this.L) {
      Logger.a("drb", new Object[] { "pushOutBottomLayout" });
      a(true, true);
      return;
    } 
    Logger.a("drb", new Object[] { "pushInBottomLayout" });
    b(true, true);
  }
  
  private void s() {
    AlbumFlow albumFlow = this.r.get(this.p);
    if (albumFlow != null && albumFlow.isFeed == 1) {
      Context context1 = this.k;
      CommonAlertDialog.a(context1, null, context1.getResources().getString(2131755275), this.k.getResources().getString(2131756086), new DialogInterface.OnClickListener(this, albumFlow) {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
              this.b.b((BluedIngSelfFeed)this.a);
            }
          }null, null, null);
      return;
    } 
    Context context = this.k;
    CommonAlertDialog.a(context, null, context.getResources().getString(2131755276), this.k.getResources().getString(2131756086), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            String str = ((AlbumFlow)ShowAlbumFragment.c(this.a).get(ShowAlbumFragment.k(this.a))).pid;
            ProfileHttpUtils.b(ShowAlbumFragment.i(this.a), new BluedUIHttpResponse<BluedEntityA<Object>>(this, str) {
                  public void a(BluedEntityA<Object> param2BluedEntityA) {
                    try {
                      List<BluedAlbum> list = UserInfo.a().i().getAlbum();
                      if (list != null && list.size() > 0) {
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0;; i++) {
                          if (i < list.size()) {
                            if (!((BluedAlbum)list.get(i)).getPid().equals(this.a)) {
                              arrayList.add(list.get(i));
                            } else {
                              LiveEventBus.get("remove_album").post(this.a);
                            } 
                          } else {
                            UserInfo.a().i().setAlbum(arrayList);
                            AlbumDataObserver.a().a(false, this.a);
                          } 
                        } 
                      } 
                      AlbumDataObserver.a().a(false, this.a);
                    } catch (Exception exception) {
                      exception.printStackTrace();
                      AppMethods.a(AppInfo.d().getResources().getString(2131756082));
                      return;
                    } 
                  }
                  
                  public void onUIFinish() {
                    DialogUtils.b(ShowAlbumFragment.l(this.b.a));
                    if (ShowAlbumFragment.c(this.b.a).size() == 0)
                      this.b.a.l(); 
                  }
                }str, (IRequestHost)this.a.w_());
          }
        }null, null, null);
  }
  
  private void t() {
    if (this.r.size() != 0) {
      int i = this.r.size();
      int j = this.p;
      if (i <= j)
        return; 
      this.V = this.r.get(j);
      if (!StringUtils.e(this.V.feed_id)) {
        LogData logData = new LogData();
        logData.n = this.V.feed_id;
        if (a(this.V)) {
          if (this.V.feed_videos != null && this.V.feed_videos.length > 1)
            logData.d = this.V.feed_videos[1]; 
          logData.k = "1";
          Log.v("drb", "个人主页-相册页面-【图片/视频】全屏页-曝光 true");
          EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_PHOTO_PAGE_PHOTO_SHOW, this.V.feed_uid, this.V.feed_id, true);
          if (AudioChannelManager.e().h()) {
            AppMethods.a(getActivity().getResources().getText(2131759450));
            a(new Runnable(this) {
                  public void run() {
                    this.a.l();
                  }
                },  300L);
          } 
          EventTrackPersonalProfile.a(PersonalProfileProtos.Event.FEED_FULL_SCREEN_SHOW, this.V.feed_uid, logData.n, 1, logData.d);
        } else {
          String str;
          if (this.O == 10) {
            if (this.V.feed_pics != null && this.V.feed_pics.length > 0) {
              str = this.V.feed_pics[0];
            } else {
              str = "";
            } 
          } else {
            str = this.V.album_pic;
          } 
          logData.d = str;
          logData.k = "0";
          Log.v("drb", "个人主页-相册页面-【图片/视频】全屏页-曝光 false");
          EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_PHOTO_PAGE_PHOTO_SHOW, this.V.feed_uid, this.V.feed_id, false);
          EventTrackPersonalProfile.a(PersonalProfileProtos.Event.FEED_FULL_SCREEN_SHOW, this.V.feed_uid, logData.n, 0, logData.d);
        } 
        logData.J = "feed_full_screen_show";
        InstantLog.a(logData);
      } 
      AlbumFlow albumFlow = this.V;
      if (albumFlow == null)
        return; 
      if (b(albumFlow)) {
        if (this.L)
          a(false, false); 
        this.H.setVisibility(0);
      } else if (this.V.isFeed == 0) {
        if (this.V.album_status == 0) {
          this.J.setImageResource(2131232782);
        } else {
          this.J.setImageResource(2131232783);
        } 
      } 
      if (!b(this.V)) {
        i = this.T;
        if (i != 0) {
          if (i != 1) {
            if (i == 2)
              a(false, false); 
          } else {
            b(false, false);
            if (this.V.isFeed == 0) {
              this.K.setVisibility(8);
              this.I.setVisibility(0);
            } else {
              this.K.setVisibility(0);
              this.I.setVisibility(8);
              this.G.setVisibility(0);
            } 
          } 
        } else {
          b(false, false);
          if (this.V.isFeed == 0) {
            this.K.setVisibility(8);
            this.I.setVisibility(0);
          } else {
            this.K.setVisibility(0);
            this.I.setVisibility(8);
            this.G.setVisibility(0);
          } 
        } 
      } 
      if (this.V.isOccupyModel) {
        this.G.setVisibility(8);
        this.x.setVisibility(8);
      } 
      if (!TextUtils.isEmpty(this.V.feed_content)) {
        this.w.setVisibility(0);
        a(this.w, this.V.feed_content);
      } else {
        this.w.setVisibility(8);
      } 
      if (!TextUtils.isEmpty(this.V.feed_timestamp)) {
        this.z.setText(TimeAndDateUtils.c(this.k, TimeAndDateUtils.b(this.V.feed_timestamp)));
      } else {
        this.z.setText("");
      } 
      if (!TextUtils.isEmpty(this.V.distance)) {
        this.y.setText(DistanceUtils.a(this.V.distance, BlueAppLocal.c(), false));
      } else {
        this.y.setText("");
      } 
      c((BluedIngSelfFeed)this.V);
      if (this.V.feed_comment == 0) {
        this.C.setText(2131756043);
      } else {
        TextView textView = this.C;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(AreaUtils.a(this.k, String.valueOf(this.V.feed_comment)));
        stringBuilder.append("");
        textView.setText(stringBuilder.toString());
      } 
      if (!TextUtils.isEmpty(this.V.location)) {
        this.g.setVisibility(0);
        this.h.setText(this.V.location);
      } else {
        this.g.setVisibility(8);
      } 
      this.G.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              if (!UserRelationshipUtils.a((ShowAlbumFragment.f(this.a)).relationship) && (ShowAlbumFragment.f(this.a)).isFeed != 0) {
                if (ShowAlbumFragment.m(this.a) == 10) {
                  FeedDetailsFragment.a((Context)this.a.getActivity(), (BluedIngSelfFeed)ShowAlbumFragment.f(this.a), 9, 0, false);
                  return;
                } 
                FeedDetailsFragment.a((Context)this.a.getActivity(), (BluedIngSelfFeed)ShowAlbumFragment.f(this.a), -1, 0, false);
                EventTrackPersonalProfile.c(PersonalProfileProtos.Event.PERSONAL_FULL_SCREEN_TEXT_CLICK, (ShowAlbumFragment.f(this.a)).feed_uid, (ShowAlbumFragment.f(this.a)).feed_id);
              } 
            }
          });
      this.v.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              if (!UserRelationshipUtils.a((ShowAlbumFragment.f(this.a)).relationship) && (ShowAlbumFragment.f(this.a)).isFeed != 0) {
                if (ShowAlbumFragment.m(this.a) == 10) {
                  FeedDetailsFragment.a((Context)this.a.getActivity(), (BluedIngSelfFeed)ShowAlbumFragment.f(this.a), 9, 0, false);
                  return;
                } 
                FeedDetailsFragment.a((Context)this.a.getActivity(), (BluedIngSelfFeed)ShowAlbumFragment.f(this.a), -1, 0, false);
              } 
            }
          });
      this.A.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              FeedDetailsFragment.a(ShowAlbumFragment.i(this.a), (BluedIngSelfFeed)ShowAlbumFragment.f(this.a), -1, 6, false);
              EventTrackPersonalProfile.c(PersonalProfileProtos.Event.PERSONAL_FULL_SCREEN_SHARE_CLICK, (ShowAlbumFragment.f(this.a)).feed_uid, (ShowAlbumFragment.f(this.a)).feed_id);
            }
          });
      this.B.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              InstantLog.b(11, (BluedIngSelfFeed)ShowAlbumFragment.f(this.a), "", -1);
              if (ShowAlbumFragment.m(this.a) == 10) {
                FeedDetailsFragment.a(ShowAlbumFragment.i(this.a), (BluedIngSelfFeed)ShowAlbumFragment.f(this.a), 9, 6, true);
                return;
              } 
              EventTrackPersonalProfile.c(PersonalProfileProtos.Event.PERSONAL_FULL_SCREEN_COMMENT_CLICK, (ShowAlbumFragment.f(this.a)).feed_uid, (ShowAlbumFragment.f(this.a)).feed_id);
              FeedDetailsFragment.a(ShowAlbumFragment.i(this.a), (BluedIngSelfFeed)ShowAlbumFragment.f(this.a), -1, 6, true);
            }
          });
    } 
  }
  
  public void a(int paramInt) {}
  
  public void a(View paramView) {
    super.a(paramView);
    Log.v("drb", "onSingleClick");
    c(paramView);
  }
  
  public void a(BluedIngSelfFeed paramBluedIngSelfFeed) {}
  
  public void a(FeedComment paramFeedComment) {
    if (this.V != null && paramFeedComment.feed_id.equals(this.V.feed_id)) {
      int i = this.V.feed_comment + 1;
      this.V.feed_comment = i;
      TextView textView = this.C;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(AreaUtils.a(this.k, String.valueOf(i)));
      stringBuilder.append("");
      textView.setText(stringBuilder.toString());
    } 
  }
  
  public void a(FeedRepost paramFeedRepost) {}
  
  public void a(Object paramObject, int paramInt) {}
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String paramString1, String paramString2) {
    if (this.V != null && !TextUtils.isEmpty(paramString1) && this.V.feed_id.equals(paramString1)) {
      int i = this.V.feed_comment;
      if (i > 0) {
        if (--i == 0) {
          this.V.feed_comment = i;
          this.C.setText(2131756043);
          return;
        } 
        this.V.feed_comment = i;
        TextView textView = this.C;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(AreaUtils.a(this.k, String.valueOf(i)));
        stringBuilder.append("");
        textView.setText(stringBuilder.toString());
        return;
      } 
      this.V.feed_comment = 0;
      this.C.setText(2131756043);
    } 
  }
  
  public void a(Object... paramVarArgs) {
    super.a(paramVarArgs);
    if (paramVarArgs == null)
      return; 
    if (this.O == 1)
      return; 
    if (paramVarArgs[1] != null && paramVarArgs[1] instanceof File)
      try {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.O);
        stringBuilder.append("");
        Logger.a("album_longclick", stringBuilder.toString());
        File file = (File)paramVarArgs[1];
        String[] arrayOfString = new String[1];
        arrayOfString[0] = this.k.getResources().getString(2131756089);
        if (this.V != null && this.V.isSelf) {
          arrayOfString = getResources().getStringArray(2130903096);
        } else if (this.O == 15) {
          arrayOfString = getResources().getStringArray(2130903078);
        } 
        CommonShowBottomWindow.a(getActivity(), arrayOfString, "#3494f4", new ActionSheet.ActionSheetListener(this, file) {
              public void a(ActionSheet param1ActionSheet, int param1Int) {
                if (ShowAlbumFragment.f(this.b) != null && (ShowAlbumFragment.f(this.b)).isSelf) {
                  if (param1Int != 0) {
                    if (param1Int != 1)
                      return; 
                    InstantLog.a("save_pic_click");
                    PermissionHelper.e(new PermissionCallbacks(this) {
                          public void a(String[] param2ArrayOfString) {}
                          
                          public void aa_() {
                            this.a.b.a(this.a.a, ShowAlbumFragment.h(this.a.b));
                          }
                        });
                    return;
                  } 
                  ShowAlbumFragment.g(this.b);
                  return;
                } 
                if (param1Int != 0) {
                  if (param1Int != 1)
                    return; 
                  Context context = ShowAlbumFragment.i(this.b);
                  String str1 = (ShowAlbumFragment.f(this.b)).album_pic;
                  String str2 = ShowAlbumFragment.h(this.b);
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append((ShowAlbumFragment.f(this.b)).pid);
                  stringBuilder.append(",");
                  stringBuilder.append(ShowAlbumFragment.j(this.b));
                  ReportFragmentNew.a(context, 11, str1, str2, stringBuilder.toString());
                  return;
                } 
                InstantLog.a("save_pic_click");
                PermissionHelper.e(new PermissionCallbacks(this) {
                      public void a(String[] param2ArrayOfString) {}
                      
                      public void aa_() {
                        this.a.b.a(this.a.a, ShowAlbumFragment.h(this.a.b));
                      }
                    });
              }
              
              public void a(ActionSheet param1ActionSheet, boolean param1Boolean) {}
            });
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  public void aS_() {
    super.aS_();
    AlbumFlow albumFlow = this.V;
    if (albumFlow != null && !b(albumFlow) && !this.L) {
      int i = this.T;
      if (i != 0) {
        if (i != 1)
          return; 
        b(true, false);
        return;
      } 
      b(true, false);
    } 
  }
  
  public void aT_() {
    super.aT_();
    PhotoListPositionObserver.a().a(this.p);
  }
  
  public void b(int paramInt) {}
  
  public void b(View paramView) {
    super.b(paramView);
    c(paramView);
  }
  
  public void b(BluedIngSelfFeed paramBluedIngSelfFeed) {
    FeedHttpUtils.a(this.k, new BluedUIHttpResponse(this, paramBluedIngSelfFeed) {
          public void onUIFinish() {
            DialogUtils.b(ShowAlbumFragment.l(this.b));
          }
          
          public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(ShowAlbumFragment.l(this.b));
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            AppMethods.d(2131756175);
            LiveEventBus.get("feed_delete").post(this.a.feed_id);
            if (this.a.repost != null)
              LiveEventBus.get("feed_delete_repost").post(this.a.repost.feed_id); 
            AlbumDataObserver.a().a(true, this.a.feed_id);
            this.b.m();
          }
        }paramBluedIngSelfFeed.feed_id, (IRequestHost)w_(), true);
  }
  
  public void b(String paramString, int paramInt) {}
  
  public void b(String paramString1, String paramString2) {}
  
  public void c(String paramString, int paramInt) {
    if (this.V != null && !TextUtils.isEmpty(paramString) && paramString.equals(this.V.feed_id)) {
      Log.v("drb", "notifyLikeChanged refreshZan");
      b((BluedIngSelfFeed)this.V, paramInt);
    } 
  }
  
  public void d(String paramString) {
    l();
  }
  
  public void e(String paramString) {}
  
  public void f_(int paramInt) {
    super.f_(paramInt);
    Log.v("drb", "onProgress");
    this.u.getBackground().setAlpha(paramInt);
    AlbumFlow albumFlow = this.V;
    if (albumFlow != null && !b(albumFlow) && this.L && this.U)
      a(true, false); 
  }
  
  public boolean j() {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramInt2 == -1)
      if (paramInt1 != 3) {
        if (paramInt1 == 4)
          l(); 
      } else if (!StringUtils.e(paramIntent.getStringExtra("string_edit"))) {
        String str = paramIntent.getStringExtra("string_edit");
        BluedIngSelfFeed bluedIngSelfFeed = (BluedIngSelfFeed)this.r.get(this.p);
        FeedHttpUtils.a(this.j, bluedIngSelfFeed, null, str, (IRequestHost)w_());
      }  
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() != 2131296787)
      return; 
    PhotoListPositionObserver.a().a(this.p);
    k();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.k = (Context)getActivity();
    View view = this.l;
    if (view == null) {
      this.l = paramLayoutInflater.inflate(2131493320, paramViewGroup, false);
      n();
      o();
      q();
      FeedRefreshObserver.a().a(this);
      FeedMethods.a((LifecycleOwner)getActivity(), this);
    } else if (view.getParent() != null) {
      ((ViewGroup)this.l.getParent()).removeView(this.l);
    } 
    if (paramBundle != null)
      this.p = paramBundle.getInt("state_position"); 
    return this.l;
  }
  
  public void onDestroy() {
    super.onDestroy();
    FeedRefreshObserver.a().b(this);
  }
  
  public void onPause() {
    super.onPause();
    this.U = false;
  }
  
  public void onResume() {
    super.onResume();
    HackyViewPager hackyViewPager = this.u;
    if (hackyViewPager != null)
      hackyViewPager.f(); 
    AlbumViewDataManager.a().a(this.i);
    this.U = true;
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {
    paramBundle.putInt("state_position", this.u.getCurrentItem());
  }
  
  public void onStop() {
    super.onStop();
    AlbumViewDataManager.a().b();
  }
  
  class ImagePagerAdapter extends FragmentPagerAdapter {
    public ImagePagerAdapter(ShowAlbumFragment this$0, FragmentManager param1FragmentManager) {
      super(param1FragmentManager);
    }
    
    public int getCount() {
      return ShowAlbumFragment.c(this.a).size();
    }
    
    public Fragment getItem(int param1Int) {
      String str1;
      AlbumFlow albumFlow = ShowAlbumFragment.c(this.a).get(param1Int);
      if (ShowAlbumFragment.a(this.a, albumFlow))
        return (Fragment)GlassDetailFragment.a(albumFlow.album_pic, false, ShowAlbumFragment.m(this.a), param1Int, albumFlow.album_pics_num); 
      boolean bool = ShowAlbumFragment.b(this.a, albumFlow);
      String str2 = "";
      if (bool) {
        String[] arrayOfString1 = albumFlow.feed_videos;
        str1 = null;
        if (arrayOfString1 != null && arrayOfString1.length > 1) {
          str1 = arrayOfString1[0];
          String str = arrayOfString1[1];
        } else {
          arrayOfString1 = null;
        } 
        String[] arrayOfString2 = albumFlow.feed_videos_width;
        if (arrayOfString2 != null && arrayOfString2.length > 0)
          Integer.valueOf(arrayOfString2[0]).intValue(); 
        arrayOfString2 = albumFlow.feed_videos_height;
        if (arrayOfString2 != null && arrayOfString2.length > 0)
          Integer.valueOf(arrayOfString2[0]).intValue(); 
        float f2 = 0.0F;
        float f1 = f2;
        if (!TextUtils.isEmpty(albumFlow.feed_video_size))
          try {
            f1 = Float.parseFloat(albumFlow.feed_video_size);
          } catch (Exception exception) {
            exception.printStackTrace();
            f1 = f2;
          }  
        long l = (long)f1;
        Logger.a("drb", new Object[] { "albumVideoPath = ", arrayOfString1 });
        LogData logData1 = new LogData();
        if (ShowAlbumFragment.f(this.a) != null)
          str2 = (ShowAlbumFragment.f(this.a)).feed_id; 
        logData1.n = str2;
        logData1.d = str1;
        logData1.k = "1";
        logData1.J = "feed_full_screen_show";
        InstantLog.a(logData1);
        VideoPlayConfig videoPlayConfig = BizVideoDetailFragment.m();
        videoPlayConfig.a = str1;
        videoPlayConfig.b = (String)arrayOfString1;
        videoPlayConfig.c = l;
        Log.v("drb", "getItem 个人主页-相册页面-【图片/视频】全屏页-曝光 ：1");
        return (Fragment)BizVideoDetailFragment.a(videoPlayConfig, ShowAlbumFragment.m(this.a), albumFlow.feed_id, albumFlow.uid);
      } 
      if (albumFlow.isOccupyModel)
        return (Fragment)OccupyDetailFragment.a(ShowAlbumFragment.m(this.a), param1Int); 
      if (ShowAlbumFragment.m(this.a) == 10) {
        if (albumFlow.feed_pics != null && albumFlow.feed_pics.length > 0) {
          str1 = albumFlow.feed_pics[0];
        } else {
          str1 = "";
        } 
      } else {
        str1 = albumFlow.album_pic;
      } 
      LogData logData = new LogData();
      if (ShowAlbumFragment.f(this.a) != null)
        str2 = (ShowAlbumFragment.f(this.a)).feed_id; 
      logData.n = str2;
      logData.d = str1;
      logData.k = "0";
      logData.J = "feed_full_screen_show";
      InstantLog.a(logData);
      Log.v("drb", "getItem 个人主页-相册页面-【图片/视频】全屏页-曝光 ：0");
      return (Fragment)BizPhotoDetailFragment.a(str1, ShowAlbumFragment.m(this.a), ShowAlbumFragment.n(this.a), albumFlow.feed_id, albumFlow.uid);
    }
    
    public long getItemId(int param1Int) {
      return ((AlbumFlow)ShowAlbumFragment.c(this.a).get(param1Int)).hashCode();
    }
    
    public int getItemPosition(Object param1Object) {
      return -2;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\photo\fragment\ShowAlbumFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */