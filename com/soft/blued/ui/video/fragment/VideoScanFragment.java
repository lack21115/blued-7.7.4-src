package com.soft.blued.ui.video.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.AeroGlassUtils;
import com.blued.android.framework.activity.keyboardpage.KeyBoardFragment;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.utils.AudioManagerUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.player.media.view.PLVideoPageView;
import com.blued.das.client.feed.FeedProtos;
import com.soft.blued.emoticon.manager.EmotionManager;
import com.soft.blued.emoticon.model.EmoticonModel;
import com.soft.blued.emoticon.model.EmoticonPackageModel;
import com.soft.blued.emoticon.ui.EmoticonsIndicatorView;
import com.soft.blued.emoticon.ui.EmoticonsPageView;
import com.soft.blued.emoticon.ui.EmoticonsToolBarView;
import com.soft.blued.emoticon.ui.IViewStateListener;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.feed.contract.IFeedDetailContract;
import com.soft.blued.ui.feed.manager.FeedMethods;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.feed.model.FeedComment;
import com.soft.blued.ui.feed.model.FeedRepost;
import com.soft.blued.ui.feed.observer.IFeedDataObserver;
import com.soft.blued.ui.feed.presenter.FeedDetailOldPresenter;
import com.soft.blued.ui.find.model.BluedRecommendUsers;
import com.soft.blued.ui.msg.customview.Emotion;
import com.soft.blued.ui.video.adapter.VideoCommentAdapter;
import com.soft.blued.ui.video.adapter.VideoScanAdapter;
import com.soft.blued.ui.video.manager.ShineVideoDataManager;
import com.soft.blued.ui.video.view.HorInterceptFrameLayout;
import com.soft.blued.utils.AreaUtils;
import com.soft.blued.utils.AtChooseUserHelper;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.PopMenuUtils;
import com.soft.blued.utils.TypefaceUtils;
import java.util.ArrayList;
import java.util.List;

public class VideoScanFragment extends KeyBoardFragment implements View.OnClickListener, IFeedDetailContract.IView, ShineVideoDataManager.IShineVideoDataDownloadListner, HorInterceptFrameLayout.OnHorScrollListener {
  private View A;
  
  private View B;
  
  private View C;
  
  private View D;
  
  private View E;
  
  private TextView F;
  
  private TextView G;
  
  private TextView H;
  
  private ImageView I;
  
  private ImageView J;
  
  private ImageView K;
  
  private View L;
  
  private HorInterceptFrameLayout M;
  
  private RenrenPullToRefreshListView N;
  
  private ListView O;
  
  private VideoCommentAdapter P;
  
  private EmoticonsPageView Q;
  
  private EmoticonsIndicatorView R;
  
  private EmoticonsToolBarView S;
  
  private View T;
  
  private ViewGroup U;
  
  private TextView V;
  
  private Emotion W;
  
  private AtChooseUserHelper X;
  
  private AudioManager Y;
  
  private int Z;
  
  private int aa;
  
  private FeedDetailOldPresenter ab;
  
  private int ac;
  
  private View ad;
  
  private SeekBar ae;
  
  private SeekBar af;
  
  private TextView ag;
  
  private PLVideoPageView ah;
  
  private int ai;
  
  private int aj;
  
  private boolean ak = false;
  
  private String al;
  
  private String am;
  
  private TextWatcher an = new TextWatcher(this) {
      private int b;
      
      private int c;
      
      private String d;
      
      private String e;
      
      public void afterTextChanged(Editable param1Editable) {
        this.b = this.a.p.getSelectionStart();
        this.c = this.a.p.getSelectionEnd();
        this.a.p.removeTextChangedListener(VideoScanFragment.l(this.a));
        if (!VideoScanFragment.m(this.a).a(this.a, this.d, this.e, param1Editable, this.c))
          this.a.p.setSelection(this.b); 
        this.a.p.addTextChangedListener(VideoScanFragment.l(this.a));
      }
      
      public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(param1CharSequence);
        stringBuilder.append("");
        this.d = stringBuilder.toString();
      }
      
      public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(param1CharSequence);
        stringBuilder.append("");
        this.e = stringBuilder.toString();
      }
    };
  
  public KeyboardListenLinearLayout e;
  
  public View f;
  
  public ImageView o;
  
  public EditText p;
  
  public Dialog q;
  
  public BluedIngSelfFeed r = new BluedIngSelfFeed();
  
  public boolean s = false;
  
  public long t = 0L;
  
  public long u = 0L;
  
  public boolean v = false;
  
  private Activity w;
  
  private View x;
  
  private RecyclerView y;
  
  private VideoScanAdapter z;
  
  private void A() {
    this.ab = new FeedDetailOldPresenter((Context)this.w, this, this.r, -1, (IRequestHost)w_());
    this.ab.a(false);
  }
  
  private void B() {
    this.y = (RecyclerView)this.x.findViewById(2131301602);
    this.y.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(getContext()));
    this.A = this.x.findViewById(2131296985);
    this.A.setOnClickListener(this);
    this.B = this.x.findViewById(2131296913);
    this.B.setOnClickListener(this);
    this.I = (ImageView)this.x.findViewById(2131297460);
    this.I.setOnClickListener(this);
    this.F = (TextView)this.x.findViewById(2131300652);
    this.H = (TextView)this.x.findViewById(2131300654);
    this.J = (ImageView)this.x.findViewById(2131297467);
    this.J.setOnClickListener(this);
    this.G = (TextView)this.x.findViewById(2131300703);
    this.C = this.x.findViewById(2131299183);
    this.D = this.x.findViewById(2131296914);
    this.C.setOnClickListener(this);
    this.D.setOnClickListener(this);
    this.I.setOnClickListener(this);
    this.F.setOnClickListener(this);
    this.U = (ViewGroup)this.x.findViewById(2131297596);
    this.p = (EditText)this.x.findViewById(2131296971);
    this.V = (TextView)this.x.findViewById(2131299890);
    this.e = (KeyboardListenLinearLayout)this.x.findViewById(2131297981);
    this.p = (EditText)this.x.findViewById(2131296971);
    this.o = (ImageView)this.x.findViewById(2131297025);
    this.f = this.x.findViewById(2131296983);
    this.T = this.x.findViewById(2131297985);
    this.q = DialogUtils.a((Context)this.w);
    this.L = this.x.findViewById(2131299389);
    this.L.setVisibility(8);
    this.ad = this.x.findViewById(2131299880);
    this.ae = (SeekBar)this.x.findViewById(2131299882);
    this.af = (SeekBar)this.x.findViewById(2131299883);
    this.ag = (TextView)this.x.findViewById(2131301386);
    this.ae.setMax(1000);
    this.ae.setPadding(0, 0, 0, 0);
    this.af.setMax(1000);
    this.af.setPadding(0, 0, 0, 0);
    D();
    E();
    this.V.setOnClickListener(this);
    this.o.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.N_();
          }
        });
    this.p.setFilters(new InputFilter[] { (InputFilter)new InputFilter.LengthFilter(256) });
    this.p.addTextChangedListener(this.an);
    this.W = new Emotion((Context)this.w);
    ArrayList<EmoticonPackageModel> arrayList = new ArrayList();
    arrayList.add(EmotionManager.h());
    this.Q = (EmoticonsPageView)this.f.findViewById(2131301643);
    this.R = (EmoticonsIndicatorView)this.f.findViewById(2131301642);
    this.S = (EmoticonsToolBarView)this.f.findViewById(2131301644);
    this.S.setModel(true);
    this.S.a((IRequestHost)w_(), arrayList);
    this.Q.a((IRequestHost)w_(), arrayList);
    this.Q.setOnIndicatorListener(new EmoticonsPageView.OnEmoticonsPageViewListener(this) {
          public void a(int param1Int) {
            VideoScanFragment.a(this.a).a(param1Int);
          }
          
          public void a(int param1Int1, int param1Int2) {
            VideoScanFragment.a(this.a).a(param1Int1, param1Int2);
          }
          
          public void b(int param1Int) {
            VideoScanFragment.a(this.a).setIndicatorCount(param1Int);
          }
          
          public void c(int param1Int) {
            VideoScanFragment.a(this.a).b(param1Int);
          }
        });
    this.Q.setIViewListener(new IViewStateListener(this) {
          public void a(EmoticonModel param1EmoticonModel) {
            if (this.a.p != null) {
              KeyEvent keyEvent;
              SpannableString spannableString;
              this.a.p.setFocusable(true);
              this.a.p.setFocusableInTouchMode(true);
              this.a.p.requestFocus();
              if (param1EmoticonModel.eventType == 1L) {
                keyEvent = new KeyEvent(0, 67);
                this.a.p.onKeyDown(67, keyEvent);
                return;
              } 
              if (((EmoticonModel)keyEvent).eventType == 2L)
                return; 
              if (((EmoticonModel)keyEvent).emoji == null) {
                spannableString = VideoScanFragment.b(this.a).a(((EmoticonModel)keyEvent).code);
                this.a.p.getText().insert(this.a.p.getSelectionStart(), (CharSequence)spannableString);
                return;
              } 
              this.a.p.append(((EmoticonModel)spannableString).emoji.a());
            } 
          }
          
          public void c(int param1Int) {
            VideoScanFragment.c(this.a).setToolBtnSelect(param1Int);
          }
        });
    this.S.setOnToolBarItemClickListener(new EmoticonsToolBarView.OnToolBarItemClickListener(this) {
          public void a(int param1Int) {
            VideoScanFragment.d(this.a).setPageSelect(param1Int);
          }
        });
    C();
  }
  
  private void C() {
    if (this.ac == 1)
      BluedPreferences.bv(); 
  }
  
  private void D() {
    this.M = (HorInterceptFrameLayout)this.x.findViewById(2131297385);
    this.M.setOnHorScrollListener(this);
    this.N = (RenrenPullToRefreshListView)this.x.findViewById(2131299181);
    this.N.setRefreshEnabled(true);
    this.O = (ListView)this.N.getRefreshableView();
    this.O.setClipToPadding(false);
    this.O.setScrollBarStyle(33554432);
    this.O.setHeaderDividersEnabled(false);
    this.O.setDividerHeight(0);
    this.N.setOnPullDownListener(new RenrenPullToRefreshListView.OnPullDownListener(this) {
          public void a() {
            (VideoScanFragment.e(this.a).f()).e = 1;
            (VideoScanFragment.e(this.a).f()).b = true;
            VideoScanFragment.e(this.a).c();
          }
          
          public void b() {
            VideoScanFragment.e(this.a).d();
          }
        });
    this.K = (ImageView)this.x.findViewById(2131296796);
    this.E = this.x.findViewById(2131296912);
    Bitmap bitmap = BitmapFactory.decodeResource(this.w.getResources(), 2131234147);
    if (bitmap != null)
      try {
        bitmap = AeroGlassUtils.a(AppInfo.d(), bitmap, 20);
        this.K.setImageBitmap(bitmap);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bitmap);
        this.E.setBackground((Drawable)bitmapDrawable);
        return;
      } catch (Exception|OutOfMemoryError exception) {
        return;
      }  
    Logger.b("VideoScanFragment", new Object[] { "2 null" });
  }
  
  private void E() {
    this.P = new VideoCommentAdapter((Context)this.w, (IRequestHost)w_(), this.r, new VideoCommentAdapter.FeedCommentListner(this) {
          public void a(FeedComment param1FeedComment) {
            VideoScanFragment.a(this.a, false);
            VideoScanFragment.a(this.a, param1FeedComment.comment_id);
            String str = VideoScanFragment.f(this.a).getResources().getString(2131758580);
            EditText editText = this.a.p;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(param1FeedComment.user_name);
            stringBuilder.append(":");
            editText.setHint(stringBuilder.toString());
            this.a.p.requestFocus();
            KeyboardUtils.c((Activity)this.a.getActivity());
            VideoScanFragment.b(this.a, param1FeedComment.user_name);
          }
        }true);
    this.N.setAdapter((ListAdapter)this.P);
    this.z = new VideoScanAdapter((Context)this.w, (IRequestHost)w_(), this, this.y, this.ac);
    this.z.a(new VideoScanAdapter.PageChangeListener(this) {
          public void a(PLVideoPageView param1PLVideoPageView) {
            VideoScanFragment.a(this.a, param1PLVideoPageView);
            if (VideoScanFragment.g(this.a) != null && VideoScanFragment.g(this.a).getTag(2131299224) != null) {
              VideoScanFragment videoScanFragment = this.a;
              videoScanFragment.r = (BluedIngSelfFeed)VideoScanFragment.g(videoScanFragment).getTag(2131299224);
              VideoScanFragment.e(this.a).b(this.a.r);
              VideoScanFragment.h(this.a).a(this.a.r);
              VideoScanFragment.i(this.a).setVisibility(8);
            } 
          }
        });
    this.y.setAdapter((RecyclerView.Adapter)this.z);
    if (ShineVideoDataManager.a().j() != -1)
      this.y.scrollToPosition(ShineVideoDataManager.a().j()); 
    this.ab.b(this.r);
    this.P.a(this.r);
    if (this.r.feed_videos == null || ShineVideoDataManager.a().e()) {
      this.ab.c();
      this.r.recommend_text = "";
    } 
  }
  
  private int F() {
    return this.Y.getStreamVolume(3);
  }
  
  public static void a(Context paramContext, BluedIngSelfFeed paramBluedIngSelfFeed) {
    ShineVideoDataManager.a().a(paramBluedIngSelfFeed);
    Bundle bundle = new Bundle();
    TerminalActivity.a(bundle);
    TerminalActivity.b(bundle);
    TerminalActivity.d(paramContext, VideoScanFragment.class, bundle);
  }
  
  public static void a(Context paramContext, BluedIngSelfFeed paramBluedIngSelfFeed, boolean paramBoolean, int paramInt) {
    ShineVideoDataManager.a().a(paramBluedIngSelfFeed, true, paramBoolean);
    Bundle bundle = new Bundle();
    bundle.putInt("feedFrom", paramInt);
    TerminalActivity.a(bundle);
    TerminalActivity.b(bundle);
    TerminalActivity.d(paramContext, VideoScanFragment.class, bundle);
  }
  
  public static void a(Context paramContext, String paramString) {
    BluedIngSelfFeed bluedIngSelfFeed = new BluedIngSelfFeed();
    bluedIngSelfFeed.feed_id = paramString;
    a(paramContext, bluedIngSelfFeed, false, -1);
  }
  
  private void f(int paramInt) {
    this.Y.setStreamVolume(3, paramInt, 4);
  }
  
  private void g(int paramInt) {
    int i = paramInt + this.aa;
    int j = this.Z;
    paramInt = i;
    if (i >= j)
      paramInt = j; 
    f(paramInt);
    this.z.b((int)(paramInt * 1.0F / this.Z * 15.0F));
  }
  
  private void h(int paramInt) {
    int i = paramInt - this.aa;
    paramInt = i;
    if (i <= 0)
      paramInt = 0; 
    f(paramInt);
    this.z.b((int)(paramInt * 1.0F / this.Z * 15.0F));
  }
  
  private void z() {
    if (ShineVideoDataManager.a().c() != null)
      this.r = ShineVideoDataManager.a().c(); 
    Bundle bundle = getArguments();
    if (bundle != null)
      this.ac = bundle.getInt("feedFrom", -1); 
    ShineVideoDataManager.a().d();
    BluedIngSelfFeed bluedIngSelfFeed = this.r;
    if (bluedIngSelfFeed != null) {
      String str;
      if (bluedIngSelfFeed.super_did != null) {
        str = this.r.super_did;
      } else {
        str = "";
      } 
      if (this.r.live > 0) {
        FeedProtos.Event event = FeedProtos.Event.FLASH_PLAY_PAGE_SHOW;
        String str1 = this.r.feed_id;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.r.live);
        stringBuilder.append("");
        EventTrackFeed.a(event, str1, str, stringBuilder.toString(), EventTrackFeed.c(this.ac));
        return;
      } 
      EventTrackFeed.a(FeedProtos.Event.FLASH_PLAY_PAGE_SHOW, this.r.feed_id, str, "", EventTrackFeed.c(this.ac));
    } 
  }
  
  public boolean V_() {
    t();
    return super.V_();
  }
  
  public void a() {
    this.P.notifyDataSetChanged();
  }
  
  public void a(int paramInt, float paramFloat) {
    if (this.z.b) {
      this.ad.setVisibility(8);
      this.v = true;
      return;
    } 
    PLVideoPageView pLVideoPageView = this.ah;
    if (pLVideoPageView == null)
      return; 
    this.t = pLVideoPageView.getTotalTime();
    if (this.t <= 60000L)
      return; 
    if (!this.s) {
      this.s = true;
      this.t = this.ah.getTotalTime();
      this.u = this.ah.getPlayTime();
      if (this.t > 0L)
        this.aj = (int)(this.ai * this.z.b() / 1000.0F); 
      this.ad.setVisibility(4);
    } 
    Logger.b("VideoScanFragment", new Object[] { "barCurrentLength:", Integer.valueOf(this.aj) });
    this.aj = (int)(this.aj + 2.0F * paramFloat);
    Logger.b("VideoScanFragment", new Object[] { "barCurrentLength 1:", Integer.valueOf(this.aj) });
    int i = this.aj;
    int j = this.ai;
    if (i > j)
      this.aj = j; 
    if (this.aj < 0)
      this.aj = 0; 
    Logger.b("VideoScanFragment", new Object[] { "barCurrentLength 1:", Integer.valueOf(this.aj) });
    Logger.b("VideoScanFragment", new Object[] { "barCurrentLength 1:", Integer.valueOf(this.ai) });
    i = (int)(this.aj / this.ai * 1000.0F);
    Logger.b("VideoScanFragment", new Object[] { "progress:", Integer.valueOf(i) });
    long l = this.t;
    this.u = (long)((float)l * this.aj / this.ai);
    this.z.a(this.u, l, i);
    if (1 == paramInt || 3 == paramInt) {
      this.ad.setVisibility(8);
      if (!this.v)
        this.z.b(this.u, this.t, i); 
      this.t = 0L;
      this.v = false;
      this.s = false;
    } 
  }
  
  public void a(BluedIngSelfFeed paramBluedIngSelfFeed) {
    this.z.a(paramBluedIngSelfFeed);
    this.r = paramBluedIngSelfFeed;
    String str = AreaUtils.a((Context)this.w, Integer.toString(this.r.feed_comment));
    TextView textView = this.H;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append(getResources().getString(2131758776));
    textView.setText(stringBuilder.toString());
    if (this.r.feed_comment == 0) {
      this.L.setVisibility(0);
      return;
    } 
    this.L.setVisibility(8);
  }
  
  public void a(List<BluedRecommendUsers> paramList) {}
  
  public void a(List<BluedIngSelfFeed> paramList, int paramInt, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, List<BluedIngSelfFeed> paramList) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onSuccess Hasmore:");
    stringBuilder.append(paramBoolean);
    Log.v("drb", stringBuilder.toString());
    this.z.a(paramList);
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt != 24) {
      if (paramInt != 25)
        return super.a(paramInt, paramKeyEvent); 
      h(F());
      return true;
    } 
    g(F());
    return true;
  }
  
  public void b() {
    DialogUtils.a(this.q);
  }
  
  public void b(int paramInt) {
    FeedDetailOldPresenter.DataStatus dataStatus = this.ab.f();
    this.N.q();
    this.N.j();
    paramInt = dataStatus.e;
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt != 2)
          return; 
        this.P.a(new ArrayList());
        this.N.p();
        d(0);
        return;
      } 
      if (dataStatus.b) {
        y();
        return;
      } 
      bg_();
      return;
    } 
    this.P.a(new ArrayList());
    x();
  }
  
  public void b(BluedIngSelfFeed paramBluedIngSelfFeed) {
    this.z.b(paramBluedIngSelfFeed);
  }
  
  public void b(List<BluedIngSelfFeed> paramList) {}
  
  public void bg_() {
    x();
  }
  
  public void c(int paramInt) {}
  
  public void c(BluedIngSelfFeed paramBluedIngSelfFeed) {
    Logger.b("VideoScanFragment", new Object[] { "setDataToView" });
    if (ShineVideoDataManager.a().e() && (ShineVideoDataManager.a().c()).feed_videos == null) {
      this.r = paramBluedIngSelfFeed;
      ShineVideoDataManager.a().b(paramBluedIngSelfFeed);
      this.z.a();
      return;
    } 
    ShineVideoDataManager.a().c(paramBluedIngSelfFeed);
  }
  
  public void c(List<BluedIngSelfFeed> paramList) {}
  
  public void d() {
    DialogUtils.b(this.q);
  }
  
  public void d(int paramInt) {
    this.N.p();
  }
  
  public void d(List<BluedRecommendUsers> paramList) {}
  
  public void e() {
    this.ak = true;
    this.p.setHint("");
    this.p.setText("");
    this.f.setVisibility(8);
    KeyboardUtils.a((Activity)getActivity());
    this.U.setVisibility(8);
    this.T.setVisibility(8);
  }
  
  public void e(int paramInt) {
    if (BluedPreferences.bM() && paramInt >= 20)
      BluedPreferences.bN(); 
  }
  
  public void e(List<FeedComment> paramList) {
    this.P.a(paramList);
  }
  
  public void e_(int paramInt) {
    if (paramInt != -3) {
      if (paramInt != -2)
        return; 
      this.U.setVisibility(8);
      if (this.f.getVisibility() != 0) {
        this.T.setVisibility(8);
        return;
      } 
      this.U.setVisibility(0);
      return;
    } 
    this.U.setVisibility(0);
    this.p.requestFocus();
    this.T.setVisibility(0);
    this.T.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            KeyboardUtils.a((Activity)this.a.getActivity());
            if (this.a.f.getVisibility() == 0) {
              this.a.f.setVisibility(8);
              VideoScanFragment.j(this.a).setVisibility(8);
              VideoScanFragment.k(this.a).setVisibility(8);
            } 
          }
        });
    this.f.setVisibility(8);
  }
  
  public void f(List<FeedComment> paramList) {
    this.P.b(paramList);
  }
  
  public void g() {
    this.N.j();
    this.N.q();
  }
  
  public void g(List<FeedRepost> paramList) {}
  
  public void h() {}
  
  public void h(List<FeedRepost> paramList) {}
  
  public void i() {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramInt2 == -1) {
      if (paramInt1 == 9090) {
        this.X.a(this.p, paramIntent, this.an);
        a(new Runnable(this) {
              public void run() {
                VideoScanFragment.j(this.a).setVisibility(0);
                this.a.p.requestFocus();
                KeyboardUtils.c((Activity)this.a.getActivity());
              }
            },  300L);
      } 
    } else if (paramInt1 == 9090) {
      AppInfo.n().postDelayed(new Runnable(this) {
            public void run() {
              VideoScanFragment.j(this.a).setVisibility(0);
              this.a.p.requestFocus();
              KeyboardUtils.c((Activity)this.a.getActivity());
            }
          },  300L);
    } 
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView) {
    boolean bool;
    FeedProtos.Event event;
    String str2;
    FeedProtos.SourcePage sourcePage;
    String str3;
    int i = paramView.getId();
    String str1 = "";
    switch (i) {
      default:
        return;
      case 2131300652:
        if (!PopMenuUtils.a((Context)this.w)) {
          InstantLog.b(5, this.r, "", -1);
          u();
          return;
        } 
        return;
      case 2131299890:
        if ((this.ab.g()).super_did != null)
          str1 = (this.ab.g()).super_did; 
        event = FeedProtos.Event.FEED_COMMENT_SEND_BTN_CLICK;
        str2 = (this.ab.g()).feed_id;
        sourcePage = EventTrackFeed.c(this.ac);
        str3 = (this.ab.g()).feed_uid;
        if ((this.ab.g()).in_promotion == 1) {
          bool = true;
        } else {
          bool = false;
        } 
        EventTrackFeed.a(event, str2, str1, sourcePage, str3, bool, (this.ab.g()).recommend_text);
        if (this.C.getVisibility() != 0) {
          InstantLog.a("shine_video_comment_send_click", 0);
        } else {
          InstantLog.a("shine_video_comment_send_click", 1);
        } 
        str1 = this.p.getText().toString();
        if (!TextUtils.isEmpty(str1.trim())) {
          str1 = this.X.b(str1);
          this.ab.a(str1, this.am, this.al, this.ak);
          return;
        } 
        AppMethods.d(2131756414);
        return;
      case 2131296913:
      case 2131296985:
      case 2131297460:
      case 2131297467:
        break;
    } 
    this.C.setVisibility(8);
    this.D.setVisibility(8);
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.w = (Activity)getActivity();
    this.Y = (AudioManager)getActivity().getSystemService("audio");
    this.Z = this.Y.getStreamMaxVolume(3);
    this.aa = this.Z / 15;
    this.ai = DensityUtils.a((Context)getActivity(), 300.0F);
    z();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    getActivity().getWindow().setSoftInputMode(16);
    getActivity().getWindow().addFlags(128);
    this.X = new AtChooseUserHelper((Context)this.w);
    View view = this.x;
    if (view == null) {
      this.x = paramLayoutInflater.inflate(2131493352, null);
      A();
      B();
      FeedMethods.a((LifecycleOwner)getActivity(), (IFeedDataObserver)this.ab);
      ShineVideoDataManager.a().a(this);
      a(this.f, this.e, this.p);
    } else {
      ((ViewGroup)view.getParent()).removeView(this.x);
    } 
    return this.x;
  }
  
  public void onDestroy() {
    super.onDestroy();
    VideoScanAdapter videoScanAdapter = this.z;
    if (videoScanAdapter != null)
      videoScanAdapter.e(); 
    getActivity().getWindow().clearFlags(128);
    ShineVideoDataManager.a().b(this);
  }
  
  public void onPause() {
    super.onPause();
    InstantLog.a(1);
    VideoScanAdapter videoScanAdapter = this.z;
    if (videoScanAdapter != null)
      videoScanAdapter.d(); 
    AudioManagerUtils.a().a(true);
  }
  
  public void onResume() {
    super.onResume();
    AudioManagerUtils.a().b();
    InstantLog.a();
    VideoScanAdapter videoScanAdapter = this.z;
    if (videoScanAdapter != null)
      videoScanAdapter.c(); 
    super.onResume();
  }
  
  public void t() {
    ShineVideoDataManager.a().c(this);
    getActivity().finish();
  }
  
  public void u() {
    this.ak = true;
    this.p.setHint("");
    this.al = "";
    this.p.requestFocus();
    this.U.setVisibility(0);
    KeyboardUtils.c((Activity)getActivity());
  }
  
  public void v() {
    Logger.b("VideoScanFragment", new Object[] { "showComment" });
    if (this.P.a()) {
      this.P.b();
      this.N.k();
    } 
    String str = AreaUtils.a((Context)this.w, Integer.toString(this.r.feed_comment));
    TextView textView = this.H;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append(getResources().getString(2131758776));
    textView.setText(stringBuilder.toString());
    this.C.setVisibility(0);
  }
  
  public void w() {
    InstantLog.a("shine_video_text_area_expand");
    this.C.setVisibility(8);
    this.D.setVisibility(0);
    TypefaceUtils.a(this.G, this.r.feed_content, 1, "");
  }
  
  public void x() {
    this.N.p();
  }
  
  public void y() {
    this.N.o();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\video\fragment\VideoScanFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */