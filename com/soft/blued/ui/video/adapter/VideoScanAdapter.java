package com.soft.blued.ui.video.adapter;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.amap.api.location.CoordinateConverter;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.framework.http.BluedHttpUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.utils.AssetsUtils;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.LinkMovementClickMethod;
import com.blued.android.module.live.base.view.animation.AnimationListenerAdapter;
import com.blued.android.module.live.base.view.animation.LiveAnimationListener;
import com.blued.android.module.live.base.view.animation.LiveAnimationView;
import com.blued.android.module.player.media.model.VideoPlayConfig;
import com.blued.android.module.player.media.view.PLVideoPageView;
import com.blued.das.client.feed.FeedProtos;
import com.blued.das.message.MessageProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.customview.EllipSizeText;
import com.soft.blued.customview.VideoLoadingView;
import com.soft.blued.http.FeedHttpUtils;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.model.LogData;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.feed.fragment.FeedDetailsFragment;
import com.soft.blued.ui.feed.fragment.FeedPostFragment;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.find.observer.UserInfoDataObserver;
import com.soft.blued.ui.msg.ShowPositionActivity;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.video.fragment.MusicVideoCollectFragment;
import com.soft.blued.ui.video.fragment.VideoScanFragment;
import com.soft.blued.ui.video.manager.ShineVideoDataManager;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.AreaUtils;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.ShareUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TypefaceUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class VideoScanAdapter extends RecyclerView.Adapter<VideoScanAdapter.ViewHolder> {
  PagerSnapHelper a = null;
  
  public boolean b;
  
  public int c;
  
  CoordinateConverter d;
  
  RecyclerView.OnScrollListener e = new RecyclerView.OnScrollListener(this) {
      public void onScrollStateChanged(RecyclerView param1RecyclerView, int param1Int) {
        super.onScrollStateChanged(param1RecyclerView, param1Int);
        VideoScanAdapter.c(this.a, true);
        RecyclerView.LayoutManager layoutManager = param1RecyclerView.getLayoutManager();
        if (param1Int != 0) {
          if (param1Int != 1)
            return; 
          boolean bool = ShineVideoDataManager.a().h();
          if (!bool) {
            Logger.b("VideoScanAdapter", new Object[] { "no more data" });
            return;
          } 
          if (layoutManager instanceof LinearLayoutManager && ((LinearLayoutManager)layoutManager).findLastVisibleItemPosition() > VideoScanAdapter.l(this.a).size() - 5 && bool) {
            Logger.b("VideoScanAdapter", new Object[] { "get more data check" });
            if (ShineVideoDataManager.a().g()) {
              Logger.b("VideoScanAdapter", new Object[] { "get more data" });
              InstantLog.a(1, 1);
              ShineVideoDataManager.a().a(false, (IRequestHost)VideoScanAdapter.e(this.a).w_());
              return;
            } 
          } 
        } else {
          VideoScanAdapter.c(this.a, false);
          if (layoutManager == null)
            return; 
          View view = this.a.a.findSnapView(layoutManager);
          if (VideoScanAdapter.b(this.a) == null)
            VideoScanAdapter.a(this.a, view); 
          if (VideoScanAdapter.b(this.a) != null) {
            if (view == null)
              return; 
            VideoScanAdapter.ViewHolder viewHolder2 = (VideoScanAdapter.ViewHolder)VideoScanAdapter.d(this.a).getChildViewHolder(VideoScanAdapter.b(this.a));
            VideoScanAdapter.ViewHolder viewHolder1 = (VideoScanAdapter.ViewHolder)VideoScanAdapter.d(this.a).getChildViewHolder(view);
            PLVideoPageView pLVideoPageView2 = VideoScanAdapter.ViewHolder.a(viewHolder2);
            PLVideoPageView pLVideoPageView1 = VideoScanAdapter.ViewHolder.a(viewHolder1);
            if (!TextUtils.equals(pLVideoPageView2.getVideoUrl(), pLVideoPageView1.getVideoUrl()) || VideoScanAdapter.b(this.a) != view) {
              Logger.b("VideoScanAdapter", new Object[] { "onPageChange" });
              InstantLog.a("shine_video_detail_show");
              pLVideoPageView2.j();
              VideoScanAdapter.ViewHolder.i(viewHolder2).setVisibility(8);
              VideoScanAdapter videoScanAdapter = this.a;
              videoScanAdapter.b = false;
              VideoScanAdapter.a(videoScanAdapter, view);
              VideoScanAdapter.a(this.a, ((Integer)pLVideoPageView1.getTag(2131299508)).intValue());
              ShineVideoDataManager.a().a(VideoScanAdapter.i(this.a));
              pLVideoPageView1.setOnPLVideoListener(viewHolder1);
              pLVideoPageView1.c();
              if (VideoScanAdapter.g(this.a) != null)
                VideoScanAdapter.g(this.a).a(pLVideoPageView1); 
            } 
          } 
        } 
      }
    };
  
  private Context f;
  
  private IRequestHost g;
  
  private List<BluedIngSelfFeed> h = new ArrayList<BluedIngSelfFeed>();
  
  private RecyclerView i = null;
  
  private boolean j = false;
  
  private VideoScanFragment k;
  
  private PageChangeListener l;
  
  private View m;
  
  private GestureDetector n;
  
  private boolean o;
  
  private int p;
  
  private boolean q;
  
  private boolean r = false;
  
  private final SimpleDateFormat s = new SimpleDateFormat("mm:ss");
  
  public VideoScanAdapter(Context paramContext, IRequestHost paramIRequestHost, VideoScanFragment paramVideoScanFragment, RecyclerView paramRecyclerView, int paramInt) {
    this.f = paramContext;
    this.g = paramIRequestHost;
    this.c = paramInt;
    this.d = new CoordinateConverter(this.f);
    this.k = paramVideoScanFragment;
    this.i = paramRecyclerView;
    this.a = new PagerSnapHelper();
    this.a.attachToRecyclerView(this.i);
    f();
    a();
  }
  
  private void a(BluedIngSelfFeed paramBluedIngSelfFeed, PLVideoPageView paramPLVideoPageView, View.OnClickListener paramOnClickListener) {
    boolean bool1;
    boolean bool2;
    if (paramBluedIngSelfFeed.feed_videos_width != null && paramBluedIngSelfFeed.feed_videos_width.length > 0 && paramBluedIngSelfFeed.feed_videos_height != null && paramBluedIngSelfFeed.feed_videos_height.length > 0) {
      bool1 = StringUtils.a(paramBluedIngSelfFeed.feed_videos_width[0], 480);
      bool2 = StringUtils.a(paramBluedIngSelfFeed.feed_videos_height[0], 480);
    } else {
      bool1 = false;
      bool2 = false;
    } 
    float f2 = 0.0F;
    float f1 = f2;
    if (!TextUtils.isEmpty(paramBluedIngSelfFeed.feed_video_size))
      try {
        f1 = Float.parseFloat(paramBluedIngSelfFeed.feed_video_size);
      } catch (Exception exception) {
        exception.printStackTrace();
        f1 = f2;
      }  
    long l = (long)f1;
    VideoPlayConfig videoPlayConfig = new VideoPlayConfig();
    videoPlayConfig.i = paramBluedIngSelfFeed.feed_id;
    if (paramBluedIngSelfFeed.feed_videos != null && paramBluedIngSelfFeed.feed_videos.length >= 2) {
      videoPlayConfig.a = paramBluedIngSelfFeed.feed_videos[0];
      videoPlayConfig.b = paramBluedIngSelfFeed.feed_videos[1];
    } 
    videoPlayConfig.j = true;
    videoPlayConfig.a(bool1);
    videoPlayConfig.b(bool2);
    videoPlayConfig.c = l;
    videoPlayConfig.g = paramOnClickListener;
    videoPlayConfig.k = false;
    if (!StringUtils.e(videoPlayConfig.b))
      paramPLVideoPageView.b(videoPlayConfig); 
  }
  
  private void f() {
    this.i.addOnScrollListener(this.e);
    this.i.addOnItemTouchListener((RecyclerView.OnItemTouchListener)new RecyclerView.SimpleOnItemTouchListener(this) {
          public boolean onInterceptTouchEvent(RecyclerView param1RecyclerView, MotionEvent param1MotionEvent) {
            return VideoScanAdapter.a(this.a).onTouchEvent(param1MotionEvent);
          }
        });
    this.n = new GestureDetector(this.f, (GestureDetector.OnGestureListener)new GestureDetector.SimpleOnGestureListener(this) {
          public boolean onDoubleTap(MotionEvent param1MotionEvent) {
            if (VideoScanAdapter.b(this.a) != null && !VideoScanAdapter.c(this.a))
              VideoScanAdapter.ViewHolder.a((VideoScanAdapter.ViewHolder)VideoScanAdapter.d(this.a).getChildViewHolder(VideoScanAdapter.b(this.a)), false); 
            return false;
          }
          
          public boolean onDown(MotionEvent param1MotionEvent) {
            VideoScanAdapter.a(this.a, false);
            return false;
          }
          
          public boolean onFling(MotionEvent param1MotionEvent1, MotionEvent param1MotionEvent2, float param1Float1, float param1Float2) {
            return false;
          }
          
          public void onLongPress(MotionEvent param1MotionEvent) {
            Logger.b("VideoScanAdapter", new Object[] { "onLongPress" });
            if (VideoScanAdapter.b(this.a) != null && !VideoScanAdapter.c(this.a) && !(VideoScanAdapter.e(this.a)).s)
              VideoScanAdapter.ViewHolder.b((VideoScanAdapter.ViewHolder)VideoScanAdapter.d(this.a).getChildViewHolder(VideoScanAdapter.b(this.a))); 
            super.onLongPress(param1MotionEvent);
          }
          
          public boolean onSingleTapConfirmed(MotionEvent param1MotionEvent) {
            Logger.b("VideoScanAdapter", new Object[] { "onSingleTapConfirmed" });
            if (VideoScanAdapter.b(this.a) != null && !VideoScanAdapter.c(this.a))
              VideoScanAdapter.ViewHolder.a((VideoScanAdapter.ViewHolder)VideoScanAdapter.d(this.a).getChildViewHolder(VideoScanAdapter.b(this.a))).d(); 
            return false;
          }
        });
  }
  
  public ViewHolder a(ViewGroup paramViewGroup, int paramInt) {
    return new ViewHolder(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131494220, paramViewGroup, false));
  }
  
  public String a(int paramInt) {
    if (++paramInt < ShineVideoDataManager.a().b().size()) {
      BluedIngSelfFeed bluedIngSelfFeed = ShineVideoDataManager.a().b().get(paramInt);
      if (bluedIngSelfFeed != null && bluedIngSelfFeed.feed_videos != null && bluedIngSelfFeed.feed_videos.length >= 2)
        return bluedIngSelfFeed.feed_videos[1]; 
    } 
    return "";
  }
  
  public void a() {
    null = ShineVideoDataManager.a().b();
    if (null == null)
      return; 
    Iterator iterator = null.iterator();
    while (iterator.hasNext())
      ((BluedIngSelfFeed)iterator.next()).isShowUrlVisited = false; 
    synchronized (this.h) {
      Logger.b("VideoScanAdapter", new Object[] { "setDatas:", Integer.valueOf(null.size()) });
      this.h.clear();
      this.h.addAll(null);
      notifyDataSetChanged();
      return;
    } 
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt) {
    View view = this.m;
    if (view != null)
      ((ViewHolder)this.i.getChildViewHolder(view)).a(paramLong1, paramLong2, paramInt); 
  }
  
  public void a(BluedIngSelfFeed paramBluedIngSelfFeed) {
    if (paramBluedIngSelfFeed == null)
      return; 
    Logger.b("VideoScanAdapter", new Object[] { "updateData:", paramBluedIngSelfFeed.feed_id });
    View view = this.m;
    if (view != null) {
      ViewHolder viewHolder = (ViewHolder)this.i.getChildViewHolder(view);
      if (TextUtils.equals(paramBluedIngSelfFeed.feed_id, (ViewHolder.c(viewHolder)).feed_id))
        viewHolder.a(paramBluedIngSelfFeed); 
    } 
  }
  
  public void a(PageChangeListener paramPageChangeListener) {
    this.l = paramPageChangeListener;
  }
  
  public void a(ViewHolder paramViewHolder, int paramInt) {
    int i = paramInt;
    if (paramInt >= this.h.size()) {
      i = paramInt;
      if (paramInt != 0)
        i = this.h.size() - 1; 
    } 
    if (this.h.size() == 0)
      return; 
    Logger.b("VideoScanAdapter", new Object[] { "position:", Integer.valueOf(i) });
    paramViewHolder.a(this.h.get(i), i);
  }
  
  public void a(List<BluedIngSelfFeed> paramList) {
    if (paramList != null) {
      if (paramList.size() == 0)
        return; 
      synchronized (this.h) {
        this.h.addAll(paramList);
        notifyItemInserted(this.h.size());
        return;
      } 
    } 
  }
  
  public int b() {
    View view = this.m;
    return (view != null) ? ViewHolder.d((ViewHolder)this.i.getChildViewHolder(view)).getProgress() : 0;
  }
  
  public void b(int paramInt) {
    View view = this.m;
    if (view != null)
      ViewHolder.a((ViewHolder)this.i.getChildViewHolder(view)).setVolumeProgress(paramInt); 
  }
  
  public void b(long paramLong1, long paramLong2, int paramInt) {
    View view = this.m;
    if (view != null)
      ((ViewHolder)this.i.getChildViewHolder(view)).b(paramLong1, paramLong2, paramInt); 
  }
  
  public void b(BluedIngSelfFeed paramBluedIngSelfFeed) {
    if (paramBluedIngSelfFeed == null)
      return; 
    Logger.b("VideoScanAdapter", new Object[] { "removeData:", paramBluedIngSelfFeed.feed_id });
    a();
  }
  
  public void c() {
    Logger.b("VideoScanAdapter", new Object[] { "resume" });
    View view = this.m;
    if (view != null)
      ViewHolder.a((ViewHolder)this.i.getChildViewHolder(view)).f(); 
  }
  
  public void d() {
    Logger.b("VideoScanAdapter", new Object[] { "pause" });
    View view = this.m;
    if (view != null)
      ViewHolder.a((ViewHolder)this.i.getChildViewHolder(view)).g(); 
  }
  
  public void e() {
    if (this.i != null)
      for (int i = 0; i < this.i.getChildCount(); i++) {
        View view = this.i.getChildAt(i);
        ((PLVideoPageView)view.findViewById(2131301607)).h();
        VideoLoadingView videoLoadingView = (VideoLoadingView)view.findViewById(2131299159);
        if (videoLoadingView != null)
          videoLoadingView.b(); 
      }  
  }
  
  public int getItemCount() {
    return this.h.size();
  }
  
  public static interface PageChangeListener {
    void a(PLVideoPageView param1PLVideoPageView);
  }
  
  public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, PLVideoPageView.OnPLVideoListener {
    private TextView A;
    
    private TextView B;
    
    private TextView C;
    
    private TextView D;
    
    private TextView E;
    
    private TextView F;
    
    private EllipSizeText G;
    
    private ImageView H;
    
    private ImageView I;
    
    private ImageView J;
    
    private ImageView K;
    
    private ImageView L;
    
    private ImageView M;
    
    private ImageView N;
    
    private View O;
    
    private View P;
    
    private View Q;
    
    private View R;
    
    private View S;
    
    private View T;
    
    private View U;
    
    private View V;
    
    private LinearLayout W;
    
    private TextView X;
    
    private FrameLayout Y;
    
    private FrameLayout Z;
    
    private ImageView aa;
    
    private ImageView ab;
    
    private ImageView ac;
    
    private LoadOptions ad;
    
    private boolean ae;
    
    private VideoLoadingView af;
    
    private View ag;
    
    private TextView ah;
    
    private TextView ai;
    
    private SeekBar aj;
    
    private long ak = 0L;
    
    private BluedIngSelfFeed al = new BluedIngSelfFeed();
    
    private View.OnClickListener am = new View.OnClickListener(this) {
        public void onClick(View param2View) {
          if (VideoScanAdapter.ViewHolder.a(this.a).getTotalTime() <= 60000L)
            return; 
          AppInfo.n().removeCallbacks(this.a.q);
          if (VideoScanAdapter.ViewHolder.a(this.a).a()) {
            VideoScanAdapter.ViewHolder.e(this.a).setVisibility(8);
            VideoScanAdapter.ViewHolder.f(this.a).setVisibility(8);
            VideoScanAdapter.ViewHolder.d(this.a).setThumb(null);
            VideoScanAdapter.ViewHolder.d(this.a).setOnSeekBarChangeListener(null);
            return;
          } 
          VideoScanAdapter.ViewHolder.e(this.a).setVisibility(0);
          VideoScanAdapter.ViewHolder.f(this.a).setVisibility(0);
          VideoScanAdapter.ViewHolder.d(this.a).setThumb(VideoScanAdapter.f(this.a.s).getResources().getDrawable(2131234074));
          VideoScanAdapter.ViewHolder.d(this.a).setThumbOffset(0);
          VideoScanAdapter.ViewHolder.d(this.a).setOnSeekBarChangeListener(this.a.r);
          if (VideoScanAdapter.ViewHolder.d(this.a).getThumb() instanceof AnimationDrawable)
            ((AnimationDrawable)VideoScanAdapter.ViewHolder.d(this.a).getThumb()).start(); 
          VideoScanAdapter.ViewHolder.g(this.a);
        }
      };
    
    public LiveAnimationView p;
    
    Runnable q = new Runnable(this) {
        public void run() {
          VideoScanAdapter.ViewHolder.e(this.a).setVisibility(8);
          VideoScanAdapter.ViewHolder.f(this.a).setVisibility(8);
          VideoScanAdapter.ViewHolder.d(this.a).setThumb(null);
          VideoScanAdapter.ViewHolder.d(this.a).setOnSeekBarChangeListener(null);
        }
      };
    
    SeekBar.OnSeekBarChangeListener r = new SeekBar.OnSeekBarChangeListener(this) {
        public void onProgressChanged(SeekBar param2SeekBar, int param2Int, boolean param2Boolean) {
          if (param2Boolean)
            this.a.c(param2SeekBar.getProgress()); 
        }
        
        public void onStartTrackingTouch(SeekBar param2SeekBar) {
          Logger.c("VideoScanAdapter", new Object[] { "onStartTrackingTouch" });
        }
        
        public void onStopTrackingTouch(SeekBar param2SeekBar) {
          Logger.c("VideoScanAdapter", new Object[] { "onStopTrackingTouch" });
          this.a.d(param2SeekBar.getProgress());
        }
      };
    
    private final View t;
    
    private final PLVideoPageView u;
    
    private ImageView v;
    
    private ImageView w;
    
    private ImageView x;
    
    private TextView y;
    
    private TextView z;
    
    public ViewHolder(VideoScanAdapter this$0, View param1View) {
      super(param1View);
      this.t = param1View;
      this.u = (PLVideoPageView)param1View.findViewById(2131301607);
      this.H = (ImageView)param1View.findViewById(2131297575);
      this.J = (ImageView)param1View.findViewById(2131297436);
      this.K = (ImageView)param1View.findViewById(2131297556);
      this.T = param1View.findViewById(2131298025);
      this.v = (ImageView)param1View.findViewById(2131297362);
      this.w = (ImageView)param1View.findViewById(2131297513);
      this.x = (ImageView)param1View.findViewById(2131297514);
      this.y = (TextView)param1View.findViewById(2131301088);
      this.G = (EllipSizeText)param1View.findViewById(2131300703);
      this.z = (TextView)param1View.findViewById(2131301317);
      this.A = (TextView)param1View.findViewById(2131301006);
      this.E = (TextView)param1View.findViewById(2131300998);
      this.M = (ImageView)param1View.findViewById(2131297517);
      this.p = (LiveAnimationView)param1View.findViewById(2131301595);
      this.B = (TextView)param1View.findViewById(2131300956);
      this.C = (TextView)param1View.findViewById(2131300654);
      this.D = (TextView)param1View.findViewById(2131300783);
      this.I = (ImageView)param1View.findViewById(2131297506);
      this.O = param1View.findViewById(2131298011);
      this.P = param1View.findViewById(2131298005);
      this.Q = param1View.findViewById(2131298008);
      this.R = param1View.findViewById(2131298015);
      this.S = param1View.findViewById(2131298014);
      this.F = (TextView)param1View.findViewById(2131300649);
      this.L = (ImageView)param1View.findViewById(2131297431);
      this.L.setOnClickListener(this);
      this.N = (ImageView)param1View.findViewById(2131297581);
      this.V = param1View.findViewById(2131298019);
      this.U = param1View.findViewById(2131298020);
      this.af = (VideoLoadingView)param1View.findViewById(2131299159);
      this.ag = param1View.findViewById(2131299881);
      this.ah = (TextView)param1View.findViewById(2131301315);
      this.ai = (TextView)param1View.findViewById(2131301316);
      this.aj = (SeekBar)param1View.findViewById(2131299879);
      this.ah.setVisibility(8);
      this.ai.setVisibility(8);
      this.aj.setMax(1000);
      this.aj.setPadding(0, 0, 0, 0);
      this.aj.setThumb(null);
      int i = StatusBarHelper.a(VideoScanAdapter.f(this$0));
      this.J.setOnClickListener(this);
      FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.J.getLayoutParams();
      layoutParams.topMargin += i;
      this.J.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      this.K.setOnClickListener(this);
      layoutParams = (FrameLayout.LayoutParams)this.K.getLayoutParams();
      layoutParams.topMargin = i + layoutParams.topMargin;
      this.K.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      this.O.setOnClickListener(this);
      this.P.setOnClickListener(this);
      this.Q.setOnClickListener(this);
      this.R.setOnClickListener(this);
      this.F.setOnClickListener(this);
      this.G.setOnClickListener(this);
      this.U.setOnClickListener(this);
      this.V.setOnClickListener(this);
      this.ad = new LoadOptions();
      LoadOptions loadOptions = this.ad;
      loadOptions.b = 2131234356;
      loadOptions.d = 2131234356;
      this.u.setOnPLVideoListener(this);
      this.W = (LinearLayout)param1View.findViewById(2131298016);
      this.X = (TextView)param1View.findViewById(2131301065);
      this.Y = (FrameLayout)param1View.findViewById(2131298017);
      this.Z = (FrameLayout)param1View.findViewById(2131298018);
      this.aa = (ImageView)param1View.findViewById(2131297526);
      this.ab = (ImageView)param1View.findViewById(2131297527);
      this.ac = (ImageView)param1View.findViewById(2131297525);
      this.W.setOnClickListener(this);
      this.Y.setOnClickListener(this);
    }
    
    private void A() {
      FeedHttpUtils.a(VideoScanAdapter.f(this.s), new BluedUIHttpResponse<BluedEntity>(this) {
            public void onFailure(Throwable param2Throwable, int param2Int, String param2String) {
              Pair pair = BluedHttpUtils.a(param2Throwable, param2Int, param2String);
              if (pair != null && ((Integer)pair.first).intValue() == 404100) {
                AppMethods.d(2131758773);
                return;
              } 
              super.onFailure(param2Throwable, param2Int, param2String);
            }
            
            public void onUIUpdate(BluedEntity param2BluedEntity) {
              (VideoScanAdapter.ViewHolder.c(this.a)).iliked = 1;
              LiveEventBus.get("feed_like_change").post(VideoScanAdapter.ViewHolder.c(this.a));
              UserInfoDataObserver.a().c();
            }
          }UserInfo.a().i().getUid(), this.al.feed_id, this.al.is_ads, "", (IRequestHost)VideoScanAdapter.e(this.s).w_());
    }
    
    private void B() {
      FeedHttpUtils.a(VideoScanAdapter.f(this.s), new BluedUIHttpResponse<BluedEntity>(this) {
            public void onFailure(Throwable param2Throwable, int param2Int, String param2String) {
              Pair pair = BluedHttpUtils.a(param2Throwable, param2Int, param2String);
              if (pair != null && ((Integer)pair.first).intValue() == 404100) {
                AppMethods.d(2131758773);
                return;
              } 
              super.onFailure(param2Throwable, param2Int, param2String);
            }
            
            public void onUIUpdate(BluedEntity param2BluedEntity) {
              (VideoScanAdapter.ViewHolder.c(this.a)).iliked = 0;
              LiveEventBus.get("feed_like_change").post(VideoScanAdapter.ViewHolder.c(this.a));
              UserInfoDataObserver.a().c();
            }
          }UserInfo.a().i().getUid(), this.al.feed_id, this.al.is_ads, (IRequestHost)VideoScanAdapter.e(this.s).w_());
    }
    
    private void C() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: iconst_1
      //   3: aload_0
      //   4: getfield al : Lcom/soft/blued/ui/feed/model/BluedIngSelfFeed;
      //   7: getfield feed_uid : Ljava/lang/String;
      //   10: invokestatic b : (ILjava/lang/String;)V
      //   13: aload_0
      //   14: getfield s : Lcom/soft/blued/ui/video/adapter/VideoScanAdapter;
      //   17: invokestatic f : (Lcom/soft/blued/ui/video/adapter/VideoScanAdapter;)Landroid/content/Context;
      //   20: new com/soft/blued/ui/video/adapter/VideoScanAdapter$ViewHolder$9
      //   23: dup
      //   24: aload_0
      //   25: invokespecial <init> : (Lcom/soft/blued/ui/video/adapter/VideoScanAdapter$ViewHolder;)V
      //   28: aload_0
      //   29: getfield al : Lcom/soft/blued/ui/feed/model/BluedIngSelfFeed;
      //   32: getfield feed_uid : Ljava/lang/String;
      //   35: ldc_w ''
      //   38: aload_0
      //   39: getfield s : Lcom/soft/blued/ui/video/adapter/VideoScanAdapter;
      //   42: invokestatic e : (Lcom/soft/blued/ui/video/adapter/VideoScanAdapter;)Lcom/soft/blued/ui/video/fragment/VideoScanFragment;
      //   45: invokevirtual w_ : ()Lcom/blued/android/core/ui/ActivityFragmentActive;
      //   48: invokestatic b : (Landroid/content/Context;Lcom/soft/blued/utils/UserRelationshipUtils$IAddOrRemoveAttentionDone;Ljava/lang/String;Ljava/lang/String;Lcom/blued/android/core/net/IRequestHost;)V
      //   51: getstatic com/blued/das/client/feed/FeedProtos$FollowLocation.FOLLOW_PLAZA_FLASH_DETAIL : Lcom/blued/das/client/feed/FeedProtos$FollowLocation;
      //   54: astore_3
      //   55: ldc_w '0'
      //   58: aload_0
      //   59: getfield al : Lcom/soft/blued/ui/feed/model/BluedIngSelfFeed;
      //   62: getfield relationship : Ljava/lang/String;
      //   65: invokevirtual equals : (Ljava/lang/Object;)Z
      //   68: pop
      //   69: getstatic com/blued/das/client/feed/FeedProtos$Event.OTHER_FOLLOW_CLICK : Lcom/blued/das/client/feed/FeedProtos$Event;
      //   72: astore #4
      //   74: aload_0
      //   75: getfield al : Lcom/soft/blued/ui/feed/model/BluedIngSelfFeed;
      //   78: getfield feed_uid : Ljava/lang/String;
      //   81: astore #5
      //   83: aload_0
      //   84: getfield al : Lcom/soft/blued/ui/feed/model/BluedIngSelfFeed;
      //   87: getfield feed_id : Ljava/lang/String;
      //   90: astore #6
      //   92: aload_0
      //   93: getfield al : Lcom/soft/blued/ui/feed/model/BluedIngSelfFeed;
      //   96: getfield super_did : Ljava/lang/String;
      //   99: astore #7
      //   101: aload_0
      //   102: getfield al : Lcom/soft/blued/ui/feed/model/BluedIngSelfFeed;
      //   105: getfield live : I
      //   108: ifle -> 155
      //   111: iconst_1
      //   112: istore_1
      //   113: goto -> 116
      //   116: aload_0
      //   117: getfield al : Lcom/soft/blued/ui/feed/model/BluedIngSelfFeed;
      //   120: getfield in_promotion : I
      //   123: iconst_1
      //   124: if_icmpne -> 160
      //   127: iconst_1
      //   128: istore_2
      //   129: goto -> 132
      //   132: aload #4
      //   134: aload #5
      //   136: aload #6
      //   138: aload #7
      //   140: aload_3
      //   141: iconst_1
      //   142: iload_1
      //   143: iload_2
      //   144: invokestatic a : (Lcom/blued/das/client/feed/FeedProtos$Event;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/blued/das/client/feed/FeedProtos$FollowLocation;ZZZ)V
      //   147: aload_0
      //   148: monitorexit
      //   149: return
      //   150: astore_3
      //   151: aload_0
      //   152: monitorexit
      //   153: aload_3
      //   154: athrow
      //   155: iconst_0
      //   156: istore_1
      //   157: goto -> 116
      //   160: iconst_0
      //   161: istore_2
      //   162: goto -> 132
      // Exception table:
      //   from	to	target	type
      //   2	111	150	finally
      //   116	127	150	finally
      //   132	147	150	finally
    }
    
    private void D() {
      this.s.b = true;
      this.U.setVisibility(0);
      this.U.setAlpha(1.0F);
      ValueAnimator valueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      valueAnimator.setDuration(1000L);
      valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
            public void onAnimationUpdate(ValueAnimator param2ValueAnimator) {
              float f = ((Float)param2ValueAnimator.getAnimatedValue()).floatValue();
              VideoScanAdapter.ViewHolder.i(this.a).setAlpha(f);
            }
          });
      valueAnimator.start();
    }
    
    private void E() {
      InstantLog.c(5, this.al, "", -1);
      ImageFileLoader.a(null).b(this.al.user_avatar).a(new ImageFileLoader.OnLoadFileListener(this) {
            public void onUIFinish(File param2File, Exception param2Exception) {
              if (param2File != null && param2File.exists()) {
                Bitmap bitmap = BitmapFactory.decodeFile(param2File.getPath());
              } else {
                param2File = null;
              } 
              ShareUtils.a().a(VideoScanAdapter.f(this.a.s), (View)VideoScanAdapter.ViewHolder.a(this.a), null, (Bitmap)param2File, VideoScanAdapter.ViewHolder.c(this.a), "shine_video_list_detail", false, 5, "", -1, 8);
            }
          }).a();
    }
    
    private void a(TextView param1TextView, String param1String) {
      TypefaceUtils.a(param1TextView, param1String, 1, "");
    }
    
    private void a(boolean param1Boolean) {
      boolean bool1;
      boolean bool2;
      FeedProtos.Event event = FeedProtos.Event.FEED_LIKE_BTN_CLICK;
      String str1 = this.al.feed_id;
      String str2 = this.al.super_did;
      if (this.al.iliked == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      FeedProtos.SourcePage sourcePage = EventTrackFeed.c(8);
      String str3 = this.al.feed_uid;
      if (this.al.in_promotion == 1) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      EventTrackFeed.a(event, str1, str2, bool1, sourcePage, str3, bool2, this.al.recommend_text);
      if (!UserRelationshipUtils.a(this.al.relationship)) {
        if (this.al.iliked == 0) {
          this.al.iliked = 1;
          this.I.setImageResource(2131234151);
          InstantLog.a(5, this.al, "", -1);
          A();
          y();
          return;
        } 
        if (param1Boolean) {
          this.al.iliked = 0;
          this.I.setImageResource(2131234158);
          B();
          return;
        } 
        y();
      } 
    }
    
    private void c(BluedIngSelfFeed param1BluedIngSelfFeed) {
      ActivityFragmentActive activityFragmentActive;
      if (param1BluedIngSelfFeed == null)
        return; 
      VideoScanFragment videoScanFragment = VideoScanAdapter.e(this.s);
      StringBuilder stringBuilder = null;
      if (videoScanFragment == null) {
        videoScanFragment = null;
      } else {
        activityFragmentActive = VideoScanAdapter.e(this.s).w_();
      } 
      ImageLoader.a((IRequestHost)activityFragmentActive, param1BluedIngSelfFeed.user_avatar).a(2131234356).c().a(this.v);
      UserRelationshipUtils.a(this.H, param1BluedIngSelfFeed.vbadge, 3);
      int j = param1BluedIngSelfFeed.live;
      int i = 0;
      if (j > 0) {
        this.H.setVisibility(8);
        this.w.setVisibility(0);
        this.x.setVisibility(0);
        Animation animation = AnimationUtils.loadAnimation(VideoScanAdapter.f(this.s), 2130771996);
        animation.setInterpolator((Interpolator)new AccelerateDecelerateInterpolator());
        this.x.startAnimation(animation);
      } else {
        this.w.setVisibility(8);
        this.x.setVisibility(8);
        this.x.clearAnimation();
      } 
      this.y.setText(param1BluedIngSelfFeed.user_name);
      UserBasicModel userBasicModel = new UserBasicModel();
      userBasicModel.vip_grade = param1BluedIngSelfFeed.vip_grade;
      userBasicModel.is_vip_annual = param1BluedIngSelfFeed.is_vip_annual;
      userBasicModel.is_hide_vip_look = param1BluedIngSelfFeed.is_hide_vip_look;
      userBasicModel.vip_exp_lvl = param1BluedIngSelfFeed.vip_exp_lvl;
      UserRelationshipUtils.a(VideoScanAdapter.f(this.s), this.y, userBasicModel, 2131100792);
      UserRelationshipUtils.a(this.N, userBasicModel);
      if (!TextUtils.isEmpty(param1BluedIngSelfFeed.feed_content)) {
        a((TextView)this.G, param1BluedIngSelfFeed.feed_content);
        this.G.setVisibility(0);
      } else {
        this.G.setVisibility(8);
      } 
      this.B.setText(AreaUtils.a(VideoScanAdapter.f(this.s), Integer.toString(param1BluedIngSelfFeed.feed_dig)));
      this.C.setText(AreaUtils.a(VideoScanAdapter.f(this.s), Integer.toString(param1BluedIngSelfFeed.feed_comment)));
      this.D.setText(AreaUtils.a(VideoScanAdapter.f(this.s), Integer.toString(param1BluedIngSelfFeed.repost_count)));
      if ("1".equalsIgnoreCase(param1BluedIngSelfFeed.relationship) || "3".equalsIgnoreCase(param1BluedIngSelfFeed.relationship) || TextUtils.equals(UserInfo.a().i().getUid(), param1BluedIngSelfFeed.feed_uid)) {
        this.L.setVisibility(8);
      } else {
        this.L.setImageResource(2131234142);
        this.L.setVisibility(0);
      } 
      if (param1BluedIngSelfFeed.iliked == 0) {
        this.I.setImageResource(2131234158);
      } else {
        this.I.setImageResource(2131234151);
      } 
      if (!TextUtils.isEmpty(param1BluedIngSelfFeed.location)) {
        this.E.setText(param1BluedIngSelfFeed.location);
        this.S.setVisibility(0);
      } else {
        this.S.setVisibility(8);
      } 
      if (!b(param1BluedIngSelfFeed)) {
        this.M.setImageResource(2131234153);
      } else {
        this.M.setImageResource(2131234152);
      } 
      if (d(param1BluedIngSelfFeed)) {
        ActivityFragmentActive activityFragmentActive1;
        this.W.setVisibility(0);
        this.Y.setVisibility(0);
        StringBuilder stringBuilder1 = new StringBuilder();
        if (param1BluedIngSelfFeed.music.music_name != null) {
          stringBuilder1.append(param1BluedIngSelfFeed.music.music_name);
          while (i < 10) {
            stringBuilder1.append("    ");
            stringBuilder1.append(param1BluedIngSelfFeed.music.music_name);
            i++;
          } 
        } 
        this.X.setText(stringBuilder1.toString());
        if (VideoScanAdapter.e(this.s) == null) {
          stringBuilder1 = stringBuilder;
        } else {
          activityFragmentActive1 = VideoScanAdapter.e(this.s).w_();
        } 
        ImageLoader.a((IRequestHost)activityFragmentActive1, AvatarUtils.a(1, param1BluedIngSelfFeed.music.music_cover)).a(2131234356).c().a(this.ab);
        return;
      } 
      this.W.setVisibility(8);
      this.Y.setVisibility(8);
    }
    
    private boolean d(BluedIngSelfFeed param1BluedIngSelfFeed) {
      return (param1BluedIngSelfFeed != null && param1BluedIngSelfFeed.music != null && !TextUtils.isEmpty(param1BluedIngSelfFeed.music.music_id) && Long.valueOf(param1BluedIngSelfFeed.music.music_id).longValue() > 0L && !TextUtils.isEmpty(param1BluedIngSelfFeed.music.music_name));
    }
    
    private void w() {
      if (this.af.getVisibility() == 0)
        return; 
      this.ag.setVisibility(4);
      this.af.setVisibility(0);
      this.af.a();
    }
    
    private void x() {
      int i = this.aj.getProgress();
      this.aj.setProgress(i);
      if (this.ag.getVisibility() == 0)
        return; 
      this.ag.setVisibility(0);
      this.af.b();
      this.af.setVisibility(4);
      VideoScanAdapter.b(this.s, false);
    }
    
    private void y() {
      String str = AssetsUtils.a("video_like.png", false);
      this.p.setVisibility(0);
      str = RecyclingUtils.Scheme.c.b(str);
      Logger.b("VideoScanAdapter", new Object[] { "path:", str });
      this.p.a((IRequestHost)VideoScanAdapter.e(this.s).w_(), "", str, "", "", (LiveAnimationListener)new AnimationListenerAdapter(this) {
            public void b() {}
          });
    }
    
    private void z() {
      InstantLog.a("shine_video_feed_detail_btn_click");
      if (!UserRelationshipUtils.a(this.al.relationship)) {
        if (!this.ae) {
          this.ae = true;
          LogData logData = new LogData();
          logData.J = "recommend_to_detail";
          logData.n = this.al.feed_id;
          logData.k = this.al.recommend_text;
          logData.d = this.al.recommend_type;
          InstantLog.a(logData);
          FeedDetailsFragment.a(VideoScanAdapter.f(this.s), this.al, 8, 7, false);
        } 
        this.t.postDelayed(new Runnable(this) {
              public void run() {
                VideoScanAdapter.ViewHolder.b(this.a, false);
              }
            }500L);
      } 
    }
    
    public void a(long param1Long1, long param1Long2) {
      long l1;
      if (VideoScanAdapter.j(this.s))
        return; 
      VideoLoadingView videoLoadingView = this.af;
      if (videoLoadingView != null && videoLoadingView.getVisibility() == 0)
        x(); 
      if (param1Long2 > 0L) {
        l1 = (long)((float)param1Long1 / (float)param1Long2 * 1000.0F);
      } else {
        l1 = 0L;
      } 
      long l2 = param1Long1;
      if (param1Long1 < 0L)
        l2 = 0L; 
      this.aj.setProgress((int)l1);
      if (this.aj.getThumb() instanceof AnimationDrawable) {
        AnimationDrawable animationDrawable = (AnimationDrawable)this.aj.getThumb();
        if (animationDrawable != null && animationDrawable.isRunning())
          animationDrawable.stop(); 
        VideoLoadingView videoLoadingView1 = this.af;
        if (videoLoadingView1 != null && videoLoadingView1.getVisibility() == 0)
          x(); 
        this.aj.setThumb(VideoScanAdapter.f(this.s).getResources().getDrawable(2131234075));
        this.aj.setThumbOffset(0);
        this.aj.setOnSeekBarChangeListener(this.r);
        Logger.b("xpf", new Object[] { "---------------------" });
      } 
      String str = VideoScanAdapter.k(this.s).format(new Date(l2));
      this.ah.setText(str);
      str = VideoScanAdapter.k(this.s).format(new Date(param1Long2));
      this.ai.setText(str);
      if (param1Long2 > 60000L) {
        if (this.A.getVisibility() == 8) {
          this.A.setVisibility(0);
          this.A.setText(VideoScanAdapter.f(this.s).getResources().getString(2131758777));
          return;
        } 
      } else {
        this.A.setVisibility(8);
      } 
    }
    
    public void a(long param1Long1, long param1Long2, int param1Int) {
      if (this.u.getTotalTime() <= 60000L)
        return; 
      VideoScanAdapter.b(this.s, true);
      AppInfo.n().removeCallbacks(this.q);
      String str = VideoScanAdapter.k(this.s).format(new Date(param1Long1));
      this.ah.setText(str);
      str = VideoScanAdapter.k(this.s).format(new Date(param1Long2));
      this.ai.setText(str);
      if (this.ah.getVisibility() != 0)
        this.ah.setVisibility(0); 
      if (this.ai.getVisibility() != 0)
        this.ai.setVisibility(0); 
      if (this.aj.getThumb() == null) {
        this.aj.setThumb(VideoScanAdapter.f(this.s).getResources().getDrawable(2131234075));
        this.aj.setThumbOffset(0);
        this.aj.setOnSeekBarChangeListener(this.r);
      } else if (this.aj.getThumb() instanceof AnimationDrawable) {
        ((AnimationDrawable)this.aj.getThumb()).stop();
      } 
      this.aj.setProgress(param1Int);
    }
    
    public void a(BluedIngSelfFeed param1BluedIngSelfFeed) {
      Logger.b("VideoScanAdapter", new Object[] { "onBindView:", param1BluedIngSelfFeed.feed_id });
      this.al.feed_dig = param1BluedIngSelfFeed.feed_dig;
      this.al.feed_comment = param1BluedIngSelfFeed.feed_comment;
      this.al.repost_count = param1BluedIngSelfFeed.repost_count;
      this.al.is_followed = param1BluedIngSelfFeed.is_followed;
      this.al.user_avatar = param1BluedIngSelfFeed.user_avatar;
      this.al.user_name = param1BluedIngSelfFeed.user_name;
      this.al.feed_content = param1BluedIngSelfFeed.feed_content;
      this.al.vip_grade = param1BluedIngSelfFeed.vip_grade;
      this.al.is_vip_annual = param1BluedIngSelfFeed.is_vip_annual;
      this.al.relationship = param1BluedIngSelfFeed.relationship;
      this.al.iliked = param1BluedIngSelfFeed.iliked;
      this.al.vbadge = param1BluedIngSelfFeed.vbadge;
      this.al.location = param1BluedIngSelfFeed.location;
      this.al.location_lat = param1BluedIngSelfFeed.location_lat;
      this.al.location_lot = param1BluedIngSelfFeed.location_lot;
      c(this.al);
    }
    
    public void a(BluedIngSelfFeed param1BluedIngSelfFeed, int param1Int) {
      if (param1BluedIngSelfFeed != null)
        this.al = param1BluedIngSelfFeed; 
      c(param1BluedIngSelfFeed);
      VideoScanAdapter.a(this.s, this.al, this.u, this.am);
      this.u.setTag(2131299508, Integer.valueOf(param1Int));
      this.u.setTag(2131299224, this.al);
      if (this.al.feed_videos != null)
        if (VideoScanAdapter.b(this.s) == null) {
          if (ShineVideoDataManager.a().j() == param1Int) {
            InstantLog.a("shine_video_detail_show");
            this.u.c();
            VideoScanAdapter.a(this.s, this.t);
            VideoScanAdapter.a(this.s, param1Int);
            if (VideoScanAdapter.g(this.s) != null)
              VideoScanAdapter.g(this.s).a(this.u); 
          } 
        } else if (VideoScanAdapter.b(this.s) == this.t) {
          this.u.c();
          String str = this.s.a(ShineVideoDataManager.a().j());
          if (!StringUtils.e(str)) {
            Logger.a("pre_video", str);
            this.u.a(str);
          } 
          if (VideoScanAdapter.g(this.s) != null)
            VideoScanAdapter.g(this.s).a(this.u); 
        }  
      if (this.al.is_recommend_ticktocks == 0 || TextUtils.isEmpty(this.al.recommend_text)) {
        this.z.setVisibility(8);
      } else {
        this.z.setVisibility(0);
        this.z.setText(this.al.recommend_text);
      } 
      if (this.al.feed_videos_duration * 1000.0D > 60000.0D) {
        this.A.setVisibility(0);
        this.A.setText(VideoScanAdapter.f(this.s).getResources().getString(2131758777));
      } else {
        this.A.setVisibility(8);
      } 
      this.S.setOnClickListener(this);
      this.v.setOnClickListener(this);
      if (StatusBarHelper.a()) {
        this.T.setVisibility(0);
      } else {
        this.T.setVisibility(8);
      } 
      if (!this.al.isShowUrlVisited) {
        String str1;
        boolean bool1;
        boolean bool2;
        InstantLog.a(6, this.al.feed_id, this.al.recommend_text, this.al.feed_uid);
        FindHttpUtils.a(this.al.show_url);
        param1BluedIngSelfFeed = this.al;
        param1BluedIngSelfFeed.isShowUrlVisited = true;
        if (TextUtils.isEmpty(param1BluedIngSelfFeed.super_did)) {
          str1 = "";
        } else {
          str1 = this.al.super_did;
        } 
        FeedProtos.Event event = FeedProtos.Event.FEED_DRAW;
        String str2 = this.al.feed_id;
        FeedProtos.FeedClass feedClass = FeedProtos.FeedClass.FEED_VIDEO;
        FeedProtos.FeedPage feedPage = FeedProtos.FeedPage.FLASH_DETAIL;
        String str3 = this.al.feed_uid;
        if (this.al.in_promotion == 1) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        if (this.al.feed_pics != null && this.al.feed_pics.length > 1) {
          bool2 = true;
        } else {
          bool2 = false;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.al.join_circle_id);
        stringBuilder.append("");
        EventTrackFeed.a(event, str2, str1, feedClass, feedPage, str3, bool1, bool2, stringBuilder.toString(), "");
      } 
    }
    
    public void b() {
      x();
    }
    
    public void b(long param1Long1, long param1Long2, int param1Int) {
      if (this.u.getTotalTime() <= 60000L)
        return; 
      VideoScanAdapter.b(this.s, false);
      Logger.b("VideoScanAdapter", new Object[] { "seekTime_________________:", Long.valueOf(param1Long1) });
      AppInfo.n().removeCallbacks(this.q);
      this.u.a(param1Long1, param1Int, new PLVideoPageView.OnSeekListener(this) {
          
          });
      String str = VideoScanAdapter.k(this.s).format(new Date(param1Long1));
      this.ah.setText(str);
      str = VideoScanAdapter.k(this.s).format(new Date(param1Long2));
      this.ai.setText(str);
      AppInfo.n().postDelayed(this.q, 3000L);
    }
    
    public boolean b(BluedIngSelfFeed param1BluedIngSelfFeed) {
      boolean bool;
      try {
        bool = CoordinateConverter.isAMapDataAvailable(Double.parseDouble(param1BluedIngSelfFeed.location_lat), Double.parseDouble(param1BluedIngSelfFeed.location_lot));
      } catch (Exception exception) {
        exception.printStackTrace();
        bool = true;
      } 
      return (!TextUtils.isEmpty(this.al.location_lot) && !TextUtils.isEmpty(this.al.location_lat) && bool);
    }
    
    public void bc_() {
      if (this.Y != null) {
        this.Z.clearAnimation();
        this.ac.setVisibility(8);
        this.X.setEllipsize(null);
        this.X.setFocusable(false);
        this.X.setFocusableInTouchMode(false);
      } 
    }
    
    public void bd_() {
      w();
    }
    
    public void c() {
      if (this.Y != null && d(this.al)) {
        this.W.setVisibility(0);
        this.Y.setVisibility(0);
        Animation animation = AnimationUtils.loadAnimation(VideoScanAdapter.f(this.s), 2130771998);
        animation.setInterpolator((Interpolator)new LinearInterpolator());
        this.Z.startAnimation(animation);
        this.ac.setVisibility(0);
        ImageLoader.c(VideoScanAdapter.h(this.s), "video_scan_music_anim.png").e(-1).f().a(this.ac);
        this.X.setLines(1);
        this.X.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.X.setSingleLine(true);
        this.X.setSelected(true);
        this.X.setFocusable(true);
        this.X.setFocusableInTouchMode(true);
      } 
    }
    
    public void c(int param1Int) {
      long l = this.u.getTotalTime();
      a((long)((float)l * param1Int / 1000.0F), l, param1Int);
    }
    
    public void d(int param1Int) {
      long l = this.u.getTotalTime();
      b((long)((float)l * param1Int / 1000.0F), l, param1Int);
    }
    
    public void g_(int param1Int) {
      VideoScanAdapter.e(this.s).e(param1Int);
      VideoScanAdapter videoScanAdapter = this.s;
      String str = videoScanAdapter.a(VideoScanAdapter.i(videoScanAdapter));
      if (!StringUtils.e(str)) {
        Logger.a("pre_video", str);
        this.u.a(str);
      } 
    }
    
    public void onClick(View param1View) {
      VideoScanAdapter.a(this.s, true);
      int i = param1View.getId();
      String str1 = "";
      switch (i) {
        default:
          return;
        case 2131300703:
          if (this.G.a() && !LinkMovementClickMethod.a().b()) {
            VideoScanAdapter.e(this.s).w();
            return;
          } 
          return;
        case 2131300649:
          InstantLog.b(5, this.al, "", -1);
          VideoScanAdapter.e(this.s).u();
          return;
        case 2131298020:
          this.U.setVisibility(8);
          this.s.b = false;
          return;
        case 2131298019:
          this.U.setVisibility(8);
          this.s.b = false;
          if (this.al.unliked_url != null && this.al.unliked_url.length > 0)
            FindHttpUtils.a(this.al.unliked_url); 
          ShineVideoDataManager.a().d(this.al);
          return;
        case 2131298016:
        case 2131298017:
          MusicVideoCollectFragment.a(VideoScanAdapter.f(this.s), this.al.music);
          return;
        case 2131298015:
          z();
          return;
        case 2131298014:
          InstantLog.a("shine_video_position_area_click");
          if (b(this.al)) {
            ShowPositionActivity.a(VideoScanAdapter.f(this.s), this.al.location_lot, this.al.location_lat, this.al.location, 1);
            return;
          } 
          return;
        case 2131298011:
          a(true);
          return;
        case 2131298008:
          E();
          return;
        case 2131298005:
          VideoScanAdapter.e(this.s).v();
          return;
        case 2131297556:
          InstantLog.b("feed_post_btn_click", 4);
          EventTrackFeed.a(FeedProtos.Event.FEED_PUBLISH_BTN_CLICK, FeedProtos.FeedFrom.PUBLISH_FLASH_DETAIL);
          FeedPostFragment.a(VideoScanAdapter.f(this.s));
          return;
        case 2131297436:
          VideoScanAdapter.e(this.s).t();
          return;
        case 2131297431:
          C();
          return;
        case 2131297362:
          break;
      } 
      UserBasicModel userBasicModel = new UserBasicModel();
      userBasicModel.name = this.al.user_name;
      userBasicModel.uid = this.al.feed_uid;
      userBasicModel.avatar = this.al.user_avatar;
      userBasicModel.is_vip_annual = this.al.is_vip_annual;
      userBasicModel.is_show_vip_page = this.al.is_show_vip_page;
      if (this.al.live > 0) {
        UserRelationshipUtils.a(VideoScanAdapter.f(this.s), userBasicModel, this.al.live, "flash_detail_live");
      } else {
        LogData logData1 = new LogData();
        logData1.I = this.al.feed_id;
        UserInfoFragmentNew.a(VideoScanAdapter.f(this.s), userBasicModel, "shine_video_detail", (View)this.v, logData1, new MsgSourceEntity(MessageProtos.StrangerSource.FIND_PLAZA_FLASH_DETAIL, EncryptTool.b(this.al.feed_id)));
      } 
      LogData logData = new LogData();
      logData.J = "shine_video_detail_to_profile";
      logData.b = this.al.feed_uid;
      logData.n = this.al.feed_id;
      if (!StringUtils.e(this.al.recommend_text))
        logData.i = this.al.recommend_text; 
      InstantLog.a(logData);
      FeedProtos.Event event = FeedProtos.Event.FLASH_VIDEO_USER_LIVE_PHOTO_CLICK;
      String str2 = this.al.feed_uid;
      if (this.al.live > 0)
        str1 = String.valueOf(this.al.live); 
      EventTrackFeed.d(event, str2, str1);
    }
  }
  
  class null implements View.OnClickListener {
    null(VideoScanAdapter this$0) {}
    
    public void onClick(View param1View) {
      if (VideoScanAdapter.ViewHolder.a(this.a).getTotalTime() <= 60000L)
        return; 
      AppInfo.n().removeCallbacks(this.a.q);
      if (VideoScanAdapter.ViewHolder.a(this.a).a()) {
        VideoScanAdapter.ViewHolder.e(this.a).setVisibility(8);
        VideoScanAdapter.ViewHolder.f(this.a).setVisibility(8);
        VideoScanAdapter.ViewHolder.d(this.a).setThumb(null);
        VideoScanAdapter.ViewHolder.d(this.a).setOnSeekBarChangeListener(null);
        return;
      } 
      VideoScanAdapter.ViewHolder.e(this.a).setVisibility(0);
      VideoScanAdapter.ViewHolder.f(this.a).setVisibility(0);
      VideoScanAdapter.ViewHolder.d(this.a).setThumb(VideoScanAdapter.f(this.a.s).getResources().getDrawable(2131234074));
      VideoScanAdapter.ViewHolder.d(this.a).setThumbOffset(0);
      VideoScanAdapter.ViewHolder.d(this.a).setOnSeekBarChangeListener(this.a.r);
      if (VideoScanAdapter.ViewHolder.d(this.a).getThumb() instanceof AnimationDrawable)
        ((AnimationDrawable)VideoScanAdapter.ViewHolder.d(this.a).getThumb()).start(); 
      VideoScanAdapter.ViewHolder.g(this.a);
    }
  }
  
  class null implements ValueAnimator.AnimatorUpdateListener {
    null(VideoScanAdapter this$0) {}
    
    public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
      float f = ((Float)param1ValueAnimator.getAnimatedValue()).floatValue();
      VideoScanAdapter.ViewHolder.i(this.a).setAlpha(f);
    }
  }
  
  class null implements ImageFileLoader.OnLoadFileListener {
    null(VideoScanAdapter this$0) {}
    
    public void onUIFinish(File param1File, Exception param1Exception) {
      if (param1File != null && param1File.exists()) {
        Bitmap bitmap = BitmapFactory.decodeFile(param1File.getPath());
      } else {
        param1File = null;
      } 
      ShareUtils.a().a(VideoScanAdapter.f(this.a.s), (View)VideoScanAdapter.ViewHolder.a(this.a), null, (Bitmap)param1File, VideoScanAdapter.ViewHolder.c(this.a), "shine_video_list_detail", false, 5, "", -1, 8);
    }
  }
  
  class null implements PLVideoPageView.OnSeekListener {
    null(VideoScanAdapter this$0) {}
  }
  
  class null implements Runnable {
    null(VideoScanAdapter this$0) {}
    
    public void run() {
      VideoScanAdapter.ViewHolder.e(this.a).setVisibility(8);
      VideoScanAdapter.ViewHolder.f(this.a).setVisibility(8);
      VideoScanAdapter.ViewHolder.d(this.a).setThumb(null);
      VideoScanAdapter.ViewHolder.d(this.a).setOnSeekBarChangeListener(null);
    }
  }
  
  class null implements SeekBar.OnSeekBarChangeListener {
    null(VideoScanAdapter this$0) {}
    
    public void onProgressChanged(SeekBar param1SeekBar, int param1Int, boolean param1Boolean) {
      if (param1Boolean)
        this.a.c(param1SeekBar.getProgress()); 
    }
    
    public void onStartTrackingTouch(SeekBar param1SeekBar) {
      Logger.c("VideoScanAdapter", new Object[] { "onStartTrackingTouch" });
    }
    
    public void onStopTrackingTouch(SeekBar param1SeekBar) {
      Logger.c("VideoScanAdapter", new Object[] { "onStopTrackingTouch" });
      this.a.d(param1SeekBar.getProgress());
    }
  }
  
  class null extends AnimationListenerAdapter {
    null(VideoScanAdapter this$0) {}
    
    public void b() {}
  }
  
  class null implements Runnable {
    null(VideoScanAdapter this$0) {}
    
    public void run() {
      VideoScanAdapter.ViewHolder.b(this.a, false);
    }
  }
  
  class null extends BluedUIHttpResponse<BluedEntity> {
    null(VideoScanAdapter this$0) {}
    
    public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
      Pair pair = BluedHttpUtils.a(param1Throwable, param1Int, param1String);
      if (pair != null && ((Integer)pair.first).intValue() == 404100) {
        AppMethods.d(2131758773);
        return;
      } 
      super.onFailure(param1Throwable, param1Int, param1String);
    }
    
    public void onUIUpdate(BluedEntity param1BluedEntity) {
      (VideoScanAdapter.ViewHolder.c(this.a)).iliked = 1;
      LiveEventBus.get("feed_like_change").post(VideoScanAdapter.ViewHolder.c(this.a));
      UserInfoDataObserver.a().c();
    }
  }
  
  class null extends BluedUIHttpResponse<BluedEntity> {
    null(VideoScanAdapter this$0) {}
    
    public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
      Pair pair = BluedHttpUtils.a(param1Throwable, param1Int, param1String);
      if (pair != null && ((Integer)pair.first).intValue() == 404100) {
        AppMethods.d(2131758773);
        return;
      } 
      super.onFailure(param1Throwable, param1Int, param1String);
    }
    
    public void onUIUpdate(BluedEntity param1BluedEntity) {
      (VideoScanAdapter.ViewHolder.c(this.a)).iliked = 0;
      LiveEventBus.get("feed_like_change").post(VideoScanAdapter.ViewHolder.c(this.a));
      UserInfoDataObserver.a().c();
    }
  }
  
  class null implements UserRelationshipUtils.IAddOrRemoveAttentionDone {
    null(VideoScanAdapter this$0) {}
    
    public void a() {
      DialogUtils.a((VideoScanAdapter.e(this.a.s)).q);
    }
    
    public void a(String param1String) {
      if ("1".equalsIgnoreCase(param1String) || "3".equalsIgnoreCase(param1String)) {
        VideoScanAdapter.ViewHolder.h(this.a).setImageResource(2131234143);
        AppInfo.n().postDelayed(new Runnable(this) {
              public void run() {
                VideoScanAdapter.ViewHolder.h(this.a.a).setVisibility(8);
              }
            },  1000L);
      } else {
        VideoScanAdapter.ViewHolder.h(this.a).setImageResource(2131234142);
      } 
      (VideoScanAdapter.ViewHolder.c(this.a)).relationship = param1String;
      ShineVideoDataManager.a().a((VideoScanAdapter.ViewHolder.c(this.a)).feed_id, (VideoScanAdapter.ViewHolder.c(this.a)).relationship);
      UserInfoDataObserver.a().c();
    }
    
    public void b() {
      DialogUtils.b((VideoScanAdapter.e(this.a.s)).q);
    }
    
    public void b(String param1String) {}
    
    public void c() {
      DialogUtils.b((VideoScanAdapter.e(this.a.s)).q);
    }
  }
  
  class null implements Runnable {
    public void run() {
      VideoScanAdapter.ViewHolder.h(this.a.a).setVisibility(8);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\video\adapter\VideoScanAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */