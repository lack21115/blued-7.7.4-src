package com.soft.blued.ui.feed.adapter;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Build;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.amap.api.maps2d.CoordinateConverter;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.framework.utils.NetworkUtils;
import com.blued.android.framework.utils.RegExpUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.LinkMovementClickMethod;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.player.media.model.VideoPlayConfig;
import com.blued.android.module.player.media.view.PLVideoPageView;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.blued.das.client.feed.FeedProtos;
import com.blued.das.client.vote.VoteProtos;
import com.blued.das.guy.GuyProtos;
import com.blued.das.message.MessageProtos;
import com.blued.das.profile.PersonalProfileProtos;
import com.blued.das.superexpose.SuperExposeProtos;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.customview.ActionSheet;
import com.soft.blued.customview.AvatarLivingAnimView;
import com.soft.blued.customview.PhotoGridView;
import com.soft.blued.customview.TextViewFixTouchForDynamic;
import com.soft.blued.http.CircleHttpUtils;
import com.soft.blued.http.FeedHttpUtils;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.http.LiveHttpUtils;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.model.LogData;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.log.trackUtils.EventTrackGuy;
import com.soft.blued.log.trackUtils.EventTrackPersonalProfile;
import com.soft.blued.log.trackUtils.EventTrackSuperExpose;
import com.soft.blued.log.trackUtils.EventTrackVote;
import com.soft.blued.ui.circle.adapter.CircleListAdapter;
import com.soft.blued.ui.circle.fragment.CircleDetailsFragment;
import com.soft.blued.ui.circle.fragment.CirclePostDetailsFragment;
import com.soft.blued.ui.circle.fragment.CircleTypeListFragment;
import com.soft.blued.ui.circle.model.CircleConstants;
import com.soft.blued.ui.circle.model.CircleJoinState;
import com.soft.blued.ui.circle.model.CircleMethods;
import com.soft.blued.ui.circle.observer.ICircleDataObserver;
import com.soft.blued.ui.circle.view.CircleJoinView;
import com.soft.blued.ui.discover.fragment.SuperTopicFragment;
import com.soft.blued.ui.feed.fragment.FeedDetailsFragment;
import com.soft.blued.ui.feed.fragment.SuperTopicDetailFragment;
import com.soft.blued.ui.feed.manager.FeedMethods;
import com.soft.blued.ui.feed.model.BluedADExtra;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.feed.model.FeedComment;
import com.soft.blued.ui.feed.model.FeedParse;
import com.soft.blued.ui.feed.model.FeedRecommendUser;
import com.soft.blued.ui.feed.model.FeedRepost;
import com.soft.blued.ui.feed.observer.FeedShowVisitedObserver;
import com.soft.blued.ui.feed.observer.IFeedDataObserver;
import com.soft.blued.ui.feed.view.FeedVoteGroup;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.find.observer.PersonalVerifyObserver;
import com.soft.blued.ui.live.LiveRoomInfoChannel;
import com.soft.blued.ui.live.model.LiveRecommendExtra;
import com.soft.blued.ui.live.view.RecommendLoadMoreView;
import com.soft.blued.ui.msg.ShowPositionActivity;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.photo.fragment.BasePhotoFragment;
import com.soft.blued.ui.user.fragment.DynamicSkinFragment;
import com.soft.blued.ui.user.fragment.ReportFragmentNew;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.user.manager.AvatarWidgetManager;
import com.soft.blued.ui.user.manager.DynamicSkinManager;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.ui.user.views.FollowStatusView;
import com.soft.blued.ui.video.fragment.VideoScanFragment;
import com.soft.blued.ui.video.fragment.VideoUserInfoFragment;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.DistanceUtils;
import com.soft.blued.utils.FlutterRouter;
import com.soft.blued.utils.ImageUtils;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.MarkDownLinkHelper;
import com.soft.blued.utils.PopMenuUtils;
import com.soft.blued.utils.ShareUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.soft.blued.utils.click.SingleClickProxy;
import com.soft.blued.view.tip.CommonAlertDialog;
import com.soft.blued.view.tip.CommonShowBottomWindow;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class FeedListAdapterForRecyclerView extends BaseMultiItemQuickAdapter<BluedIngSelfFeed, BaseViewHolder> implements ICircleDataObserver, IFeedDataObserver {
  private String A;
  
  private String B;
  
  private int C = -1;
  
  private int D;
  
  private int E;
  
  private PLVideoPageView F;
  
  public Context a;
  
  public IRequestHost b;
  
  public int c;
  
  public int d;
  
  public Dialog e;
  
  public int f;
  
  public int g;
  
  public boolean h;
  
  public boolean i = false;
  
  public int o = 0;
  
  public RecyclerView.OnScrollListener p = new RecyclerView.OnScrollListener(this) {
      public void onScrollStateChanged(RecyclerView param1RecyclerView, int param1Int) {
        super.onScrollStateChanged(param1RecyclerView, param1Int);
        FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.a;
        feedListAdapterForRecyclerView.o = param1Int;
        feedListAdapterForRecyclerView.i = false;
        if (param1Int != 0)
          return; 
        AppInfo.n().postDelayed(new Runnable(this, param1RecyclerView) {
              public void run() {
                if (this.b.a.o == 0) {
                  FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.b.a;
                  RecyclerView recyclerView = this.a;
                  feedListAdapterForRecyclerView.a(recyclerView, recyclerView.getChildCount());
                } 
              }
            }300L);
      }
      
      public void onScrolled(RecyclerView param1RecyclerView, int param1Int1, int param1Int2) {
        super.onScrolled(param1RecyclerView, param1Int1, param1Int2);
        RecyclerView.LayoutManager layoutManager = param1RecyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
          LinearLayoutManager linearLayoutManager = (LinearLayoutManager)layoutManager;
          FeedListAdapterForRecyclerView.a(this.a, linearLayoutManager.findFirstVisibleItemPosition());
          FeedListAdapterForRecyclerView.b(this.a, linearLayoutManager.findLastVisibleItemPosition());
        } 
      }
    };
  
  public String q;
  
  public String r;
  
  public String s;
  
  public int t;
  
  public FeedHorizontalRecommendAdapter u;
  
  public RecommendTopicAdapter v;
  
  public CircleListAdapter w;
  
  private ImageOptions x;
  
  private HashSet<String> y = new HashSet<String>();
  
  private boolean z = false;
  
  public FeedListAdapterForRecyclerView(List<BluedIngSelfFeed> paramList, Context paramContext, IRequestHost paramIRequestHost, RecyclerView paramRecyclerView, int paramInt) {
    super(paramList);
    this.a = paramContext;
    this.b = paramIRequestHost;
    this.c = paramInt;
    a(paramRecyclerView);
    d();
    b(0, 2131493506);
    b(1, 2131493508);
    b(2, 2131493507);
    b(3, 2131493524);
    b(4, 2131493527);
    b(8, 2131493526);
    b(5, 2131493501);
    b(6, 2131493519);
    b(10, 2131493527);
    b(9, 2131493518);
    b(14, 2131493517);
    b(15, 2131493527);
    b(16, 2131493510);
    b(17, 2131493527);
  }
  
  private void A() {
    if (e() != null)
      for (int i = 0; i < e().getChildCount(); i++)
        f(e().getChildAt(i));  
  }
  
  private void a(BluedIngSelfFeed paramBluedIngSelfFeed, int paramInt) {
    if (paramBluedIngSelfFeed != null && !paramBluedIngSelfFeed.isShowAdVisited) {
      EventTrackGuy.a(GuyProtos.Event.AD_PRE_ROW_SHOW, this.c, paramInt);
      paramBluedIngSelfFeed.isShowAdVisited = true;
    } 
  }
  
  private boolean a(RecyclerView paramRecyclerView, VideoFeedViewHolder paramVideoFeedViewHolder) {
    if (paramRecyclerView != null && VideoFeedViewHolder.b(paramVideoFeedViewHolder) != null && VideoFeedViewHolder.b(paramVideoFeedViewHolder).getVisibility() == 0) {
      Rect rect = new Rect();
      VideoFeedViewHolder.b(paramVideoFeedViewHolder).getLocalVisibleRect(rect);
      int i = VideoFeedViewHolder.b(paramVideoFeedViewHolder).getHeight();
      if (rect.top == 0 && rect.bottom >= i * 0.9D)
        return true; 
      if (rect.top != 0 || rect.top != 0 || rect.bottom < i * 0.9D);
    } 
    return false;
  }
  
  private boolean a(PLVideoPageView paramPLVideoPageView) {
    if (paramPLVideoPageView != null) {
      if (!paramPLVideoPageView.a() && !NetworkUtils.a()) {
        PLVideoPageView pLVideoPageView = this.F;
        if (pLVideoPageView != null)
          pLVideoPageView.g(); 
        paramPLVideoPageView.c();
        Logger.b("PLVideoPageView", new Object[] { paramPLVideoPageView.getVideoUrl() });
      } 
      this.F = paramPLVideoPageView;
      LogData logData = new LogData();
      logData.J = "feed_video_play";
      logData.g = "0";
      if (!TextUtils.isEmpty(this.B))
        logData.t = this.B; 
      if (this.C != -1) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.C);
        stringBuilder.append("");
        logData.h = stringBuilder.toString();
      } 
      InstantLog.a(logData);
      return true;
    } 
    return false;
  }
  
  private BluedIngSelfFeed b(BluedIngSelfFeed paramBluedIngSelfFeed) {
    return paramBluedIngSelfFeed;
  }
  
  private List<BluedIngSelfFeed> b(Collection<? extends BluedIngSelfFeed> paramCollection) {
    ArrayList<BluedIngSelfFeed> arrayList = new ArrayList();
    for (BluedIngSelfFeed bluedIngSelfFeed : paramCollection) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(bluedIngSelfFeed.feed_id);
      stringBuilder.append(bluedIngSelfFeed.is_ads);
      stringBuilder.append(bluedIngSelfFeed.lid);
      stringBuilder.append(bluedIngSelfFeed.dataType);
      String str = stringBuilder.toString();
      if (!this.y.contains(str)) {
        arrayList.add(bluedIngSelfFeed);
        this.y.add(str);
      } 
    } 
    return arrayList;
  }
  
  private List<BluedIngSelfFeed> d(List<BluedIngSelfFeed> paramList) {
    ArrayList<BluedIngSelfFeed> arrayList = new ArrayList();
    Iterator<BluedIngSelfFeed> iterator = paramList.iterator();
    while (iterator.hasNext())
      arrayList.add(b(iterator.next())); 
    return arrayList;
  }
  
  private void d() {
    this.m = LayoutInflater.from(this.a);
    this.e = DialogUtils.a(this.a);
    this.x = new ImageOptions();
    ImageOptions imageOptions = this.x;
    imageOptions.c = 2131231369;
    imageOptions.a = 2131231369;
    if (this.c != 1) {
      this.f = 0;
      this.g = 7;
    } else {
      this.f = 1;
      this.g = 1;
    } 
    this.d = FeedMethods.a(this.c);
  }
  
  private void f(View paramView) {
    if (paramView != null) {
      paramView = paramView.findViewById(2131298685);
      if (paramView != null && paramView instanceof AvatarLivingAnimView)
        ((AvatarLivingAnimView)paramView).a(); 
    } 
  }
  
  public String a() {
    StringBuffer stringBuffer = new StringBuffer();
    if (this.n != null && this.n.size() > 0)
      for (int i = 0; i < this.n.size(); i++) {
        if (((BluedIngSelfFeed)this.n.get(i)).is_ads == 1 || ((BluedIngSelfFeed)this.n.get(i)).is_ads == 2)
          if (TextUtils.isEmpty(stringBuffer.toString())) {
            stringBuffer.append(((BluedIngSelfFeed)this.n.get(i)).exclude_id);
          } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(",");
            stringBuilder.append(((BluedIngSelfFeed)this.n.get(i)).exclude_id);
            stringBuffer.append(stringBuilder.toString());
          }  
      }  
    return stringBuffer.toString();
  }
  
  public void a(int paramInt) {
    if (paramInt != -1)
      for (int i = 0; i < this.n.size(); i++) {
        if (((BluedIngSelfFeed)this.n.get(i)).isFeed() && TextUtils.equals(((BluedIngSelfFeed)this.n.get(i)).feed_uid, (UserInfo.a().i()).uid))
          ((BluedIngSelfFeed)this.n.get(i)).theme_id = paramInt; 
      }  
    notifyDataSetChanged();
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, BluedIngSelfFeed paramBluedIngSelfFeed) {
    a(paramBluedIngSelfFeed, paramBaseViewHolder.getAdapterPosition() - o());
    if (paramBaseViewHolder != null) {
      VideoFeedViewHolder videoFeedViewHolder;
      int i = paramBaseViewHolder.getAdapterPosition() - o();
      View view = paramBaseViewHolder.z();
      switch (paramBaseViewHolder.getItemViewType()) {
        default:
          (new ImageOneFeedViewHolder(this, view)).a(paramBluedIngSelfFeed, i);
          return;
        case 17:
          (new JoinCircleViewHolder(this, view)).a(paramBluedIngSelfFeed, i);
          return;
        case 16:
          (new LiveFeedViewHolder(this, view)).a(paramBluedIngSelfFeed, i);
          return;
        case 15:
          (new ShareCircleFeedViewHolder(view)).a(paramBluedIngSelfFeed, i);
          return;
        case 14:
          (new RecommendCircleViewHolder(this, view)).a(paramBluedIngSelfFeed, i);
          return;
        case 10:
          (new ShareTopicFeedViewHolder(this, view)).a(paramBluedIngSelfFeed, i);
          return;
        case 9:
          (new RecommendTopicViewHolder(this, view)).a(paramBluedIngSelfFeed, i);
          return;
        case 8:
          (new VoteFeedViewHolder(this, view)).a(paramBluedIngSelfFeed, i);
          return;
        case 6:
          (new RecommendUserFeedViewHolder(this, view)).a(paramBluedIngSelfFeed, i);
          return;
        case 5:
          (new AdFeedViewHolder(this, view)).a(paramBluedIngSelfFeed, i);
          return;
        case 4:
          (new WebFeedViewHolder(this, view)).a(paramBluedIngSelfFeed, i);
          return;
        case 3:
          videoFeedViewHolder = new VideoFeedViewHolder(this, view);
          videoFeedViewHolder.a(paramBluedIngSelfFeed, i);
          view.setTag(videoFeedViewHolder);
          AppInfo.n().postDelayed(new Runnable(this) {
                public void run() {
                  FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.a;
                  feedListAdapterForRecyclerView.a(FeedListAdapterForRecyclerView.a(feedListAdapterForRecyclerView), FeedListAdapterForRecyclerView.b(this.a).getChildCount());
                }
              }1000L);
          return;
        case 2:
          (new ImageOtherFeedViewHolder(this, view)).a(paramBluedIngSelfFeed, i);
          return;
        case 1:
          break;
      } 
      (new ImageTwoFourFeedViewHolder(this, view)).a(paramBluedIngSelfFeed, i);
    } 
  }
  
  public void a(CircleJoinState paramCircleJoinState) {
    for (int i = 0; i < this.n.size(); i++) {
      if (((BluedIngSelfFeed)this.n.get(i)).isCirclePost() && !TextUtils.isEmpty(((BluedIngSelfFeed)this.n.get(i)).circle_id) && ((BluedIngSelfFeed)this.n.get(i)).circle_id.equals(paramCircleJoinState.circle_id))
        ((BluedIngSelfFeed)this.n.get(i)).setJoinState(paramCircleJoinState); 
    } 
    notifyDataSetChanged();
  }
  
  public void a(BluedIngSelfFeed paramBluedIngSelfFeed) {
    for (int i = 0; i < this.n.size(); i++) {
      if (((BluedIngSelfFeed)this.n.get(i)).isFeed() && !TextUtils.isEmpty(((BluedIngSelfFeed)this.n.get(i)).feed_id) && ((BluedIngSelfFeed)this.n.get(i)).feed_id.equals(paramBluedIngSelfFeed.feed_id)) {
        ((BluedIngSelfFeed)this.n.get(i)).is_vote = paramBluedIngSelfFeed.is_vote;
        ((BluedIngSelfFeed)this.n.get(i)).a_vote_count = paramBluedIngSelfFeed.a_vote_count;
        ((BluedIngSelfFeed)this.n.get(i)).b_vote_count = paramBluedIngSelfFeed.b_vote_count;
        ((BluedIngSelfFeed)this.n.get(i)).vote_count = paramBluedIngSelfFeed.vote_count;
        ((BluedIngSelfFeed)this.n.get(i)).ivoted = paramBluedIngSelfFeed.ivoted;
      } 
    } 
    notifyDataSetChanged();
  }
  
  public void a(FeedComment paramFeedComment) {
    for (int i = 0; i < this.n.size(); i++) {
      BluedIngSelfFeed bluedIngSelfFeed = this.n.get(i);
      if (((BluedIngSelfFeed)this.n.get(i)).isFeed() && bluedIngSelfFeed.feed_id != null && bluedIngSelfFeed.feed_id.equals(paramFeedComment.feed_id)) {
        bluedIngSelfFeed.feed_comment++;
        bluedIngSelfFeed.comments.add(0, paramFeedComment);
        notifyDataSetChanged();
        return;
      } 
    } 
  }
  
  public void a(FeedRepost paramFeedRepost) {
    if (!TextUtils.isEmpty(paramFeedRepost.feed_id) && this.n != null && this.n.size() > 0)
      for (int i = 0; i < this.n.size(); i++) {
        if (((BluedIngSelfFeed)this.n.get(i)).isFeed() && paramFeedRepost.feed_id.equals(((BluedIngSelfFeed)this.n.get(i)).feed_id)) {
          int j = ((BluedIngSelfFeed)this.n.get(i)).repost_count;
          ((BluedIngSelfFeed)this.n.get(i)).repost_count = j + 1;
          notifyDataSetChanged();
          return;
        } 
      }  
  }
  
  public void a(String paramString) {
    if (this.n != null && !TextUtils.isEmpty(paramString))
      for (BluedIngSelfFeed bluedIngSelfFeed : this.n) {
        if (CircleMethods.isCircle(bluedIngSelfFeed) && paramString.equals(bluedIngSelfFeed.feed_id)) {
          this.n.remove(bluedIngSelfFeed);
          notifyDataSetChanged();
          break;
        } 
      }  
  }
  
  public void a(String paramString, int paramInt) {
    if (!TextUtils.isEmpty(paramString) && this.n != null && this.n.size() > 0)
      for (int i = 0; i < this.n.size(); i++) {
        if (((BluedIngSelfFeed)this.n.get(i)).isFeed() && paramString.equals(((BluedIngSelfFeed)this.n.get(i)).feed_id)) {
          ((BluedIngSelfFeed)this.n.get(i)).allow_comments = paramInt;
          notifyDataSetChanged();
          return;
        } 
      }  
  }
  
  public void a(String paramString1, String paramString2) {
    if (!TextUtils.isEmpty(paramString1) && !TextUtils.isEmpty(paramString2) && this.n != null && this.n.size() > 0) {
      int i = 0;
      while (true) {
        if (i < this.n.size()) {
          if (((BluedIngSelfFeed)this.n.get(i)).isFeed() && paramString1.equals(((BluedIngSelfFeed)this.n.get(i)).feed_id)) {
            BluedIngSelfFeed bluedIngSelfFeed = this.n.get(i);
            if (bluedIngSelfFeed != null && bluedIngSelfFeed.comments != null && bluedIngSelfFeed.comments.size() > 0) {
              i = 0;
              while (true) {
                if (i < bluedIngSelfFeed.comments.size()) {
                  if (paramString2.equals(((FeedComment)bluedIngSelfFeed.comments.get(i)).comment_id)) {
                    bluedIngSelfFeed.comments.remove(i);
                    try {
                      int j = bluedIngSelfFeed.feed_comment;
                      i = j;
                      if (j > 0)
                        i = j - 1; 
                      bluedIngSelfFeed.feed_comment = i;
                      break;
                    } catch (Exception exception) {
                      bluedIngSelfFeed.feed_comment = 0;
                    } 
                  } else {
                    i++;
                    continue;
                  } 
                } else {
                  break;
                } 
                notifyDataSetChanged();
                return;
              } 
            } else {
              break;
            } 
          } else {
            i++;
            continue;
          } 
        } else {
          break;
        } 
        notifyDataSetChanged();
        return;
      } 
    } 
  }
  
  public void a(Collection<? extends BluedIngSelfFeed> paramCollection) {
    super.a(b(paramCollection));
    notifyDataSetChanged();
  }
  
  public void a(List<BluedIngSelfFeed> paramList) {
    if (paramList != null)
      c(d(paramList)); 
  }
  
  public boolean a(RecyclerView paramRecyclerView, int paramInt) {
    if (paramRecyclerView != null)
      for (int i = 0; i < paramInt; i++) {
        View view = paramRecyclerView.getChildAt(i);
        if (view != null && view.getTag() instanceof VideoFeedViewHolder) {
          VideoFeedViewHolder videoFeedViewHolder = (VideoFeedViewHolder)view.getTag();
          if (videoFeedViewHolder != null && VideoFeedViewHolder.a(videoFeedViewHolder) != null && a(paramRecyclerView, videoFeedViewHolder))
            return a(VideoFeedViewHolder.a(videoFeedViewHolder)); 
        } 
      }  
    return false;
  }
  
  public void b() {
    if (this.F != null && !NetworkUtils.a())
      this.F.f(); 
  }
  
  public void b(int paramInt) {
    if (paramInt != -1)
      for (int i = 0; i < this.n.size(); i++) {
        if (((BluedIngSelfFeed)this.n.get(i)).isFeed() && TextUtils.equals(((BluedIngSelfFeed)this.n.get(i)).feed_uid, (UserInfo.a().i()).uid))
          ((BluedIngSelfFeed)this.n.get(i)).theme_pendant = paramInt; 
      }  
    notifyDataSetChanged();
  }
  
  public void b(BaseViewHolder paramBaseViewHolder) {
    super.onViewRecycled((RecyclerView.ViewHolder)paramBaseViewHolder);
    if (paramBaseViewHolder != null)
      f(paramBaseViewHolder.z()); 
  }
  
  public void b(String paramString, int paramInt) {
    if (!TextUtils.isEmpty(paramString) && this.n != null && this.n.size() > 0)
      for (int i = 0; i < this.n.size(); i++) {
        if (((BluedIngSelfFeed)this.n.get(i)).isFeed() && paramString.equals(((BluedIngSelfFeed)this.n.get(i)).feed_id)) {
          ((BluedIngSelfFeed)this.n.get(i)).reading_scope = paramInt;
          notifyDataSetChanged();
          return;
        } 
      }  
  }
  
  public void b(String paramString1, String paramString2) {
    for (int i = 0; i < this.n.size(); i++) {
      if (((BluedIngSelfFeed)this.n.get(i)).isFeed() && !TextUtils.isEmpty(((BluedIngSelfFeed)this.n.get(i)).feed_uid) && ((BluedIngSelfFeed)this.n.get(i)).feed_uid.equals(paramString1)) {
        ((BluedIngSelfFeed)this.n.get(i)).relationship = paramString2;
        int j = o() + i;
        if (j >= this.D && j <= this.E)
          notifyItemChanged(j); 
      } 
    } 
  }
  
  public void b(List<BluedIngSelfFeed> paramList) {
    if (paramList != null)
      a(d(paramList)); 
  }
  
  public void c() {
    PLVideoPageView pLVideoPageView = this.F;
    if (pLVideoPageView != null && pLVideoPageView.a())
      this.F.g(); 
    A();
    FeedHorizontalRecommendAdapter feedHorizontalRecommendAdapter = this.u;
    if (feedHorizontalRecommendAdapter != null)
      feedHorizontalRecommendAdapter.a(); 
  }
  
  public void c(String paramString, int paramInt) {
    if (!TextUtils.isEmpty(paramString) && this.n != null && this.n.size() > 0) {
      boolean bool = false;
      for (int i = 0; i < this.n.size(); i++) {
        if (((BluedIngSelfFeed)this.n.get(i)).isFeed() && paramString.equals(((BluedIngSelfFeed)this.n.get(i)).feed_id)) {
          if (paramInt == 0 || paramInt == 1) {
            ((BluedIngSelfFeed)this.n.get(i)).iliked = paramInt;
            try {
              int j = ((BluedIngSelfFeed)this.n.get(i)).feed_dig;
              if (paramInt == 1) {
                paramInt = ++j;
                if (this.h) {
                  ((BluedIngSelfFeed)this.n.get(i)).isPlayLikeAnim = true;
                  this.h = false;
                  paramInt = j;
                } 
              } else {
                paramInt = j - 1;
              } 
              if (paramInt < 0)
                paramInt = bool; 
            } catch (Exception exception) {
              paramInt = bool;
            } 
            ((BluedIngSelfFeed)this.n.get(i)).feed_dig = paramInt;
          } 
          notifyDataSetChanged();
          return;
        } 
      } 
    } 
  }
  
  public void c(List<BluedIngSelfFeed> paramList) {
    this.i = true;
    this.y.clear();
    if (this.n != null && this.n.size() > 0) {
      this.n.clear();
    } else {
      this.n = new ArrayList();
    } 
    if (paramList != null)
      this.n.addAll(b(paramList)); 
    notifyDataSetChanged();
  }
  
  public void d(String paramString) {
    if (!TextUtils.isEmpty(paramString) && this.n != null && this.n.size() > 0)
      for (int i = 0; i < this.n.size(); i++) {
        if (((BluedIngSelfFeed)this.n.get(i)).isFeed() && paramString.equals(((BluedIngSelfFeed)this.n.get(i)).feed_id)) {
          this.n.remove(i);
          notifyDataSetChanged();
          return;
        } 
      }  
  }
  
  public void e(String paramString) {
    if (!TextUtils.isEmpty(paramString) && this.n != null && this.n.size() > 0)
      for (int i = 0; i < this.n.size(); i++) {
        if (((BluedIngSelfFeed)this.n.get(i)).isFeed() && paramString.equals(((BluedIngSelfFeed)this.n.get(i)).feed_id)) {
          int j = ((BluedIngSelfFeed)this.n.get(i)).repost_count - 1;
          BluedIngSelfFeed bluedIngSelfFeed = this.n.get(i);
          i = j;
          if (j < 0)
            i = 0; 
          bluedIngSelfFeed.repost_count = i;
          notifyDataSetChanged();
          return;
        } 
      }  
  }
  
  class AdFeedViewHolder implements View.OnClickListener {
    private BluedIngSelfFeed b;
    
    private int c;
    
    private ImageView d;
    
    private TextView e;
    
    private ImageView f;
    
    private TextView g;
    
    private ImageView h;
    
    private ImageView i;
    
    public AdFeedViewHolder(FeedListAdapterForRecyclerView this$0, View param1View) {
      this.d = (ImageView)param1View.findViewById(2131297362);
      this.e = (TextView)param1View.findViewById(2131299358);
      this.f = (ImageView)param1View.findViewById(2131296418);
      this.g = (TextView)param1View.findViewById(2131300488);
      this.h = (ImageView)param1View.findViewById(2131297419);
      this.i = (ImageView)param1View.findViewById(2131297421);
    }
    
    private void a() {
      if (this.b.can_close == 1) {
        this.f.setVisibility(0);
        this.f.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
        return;
      } 
      this.f.setVisibility(8);
      this.f.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
    }
    
    private void b() {
      ImageLoader.a(this.a.b, AvatarUtils.a(0, this.b.user_avatar)).a(2131234356).c().a(this.d);
      TextView textView = this.e;
      if (!TextUtils.isEmpty(this.b.note)) {
        str = this.b.note;
      } else {
        str = this.b.user_name;
      } 
      textView.setText(str);
      if (!TextUtils.isEmpty(this.b.target_url)) {
        this.d.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
        this.e.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
      } else {
        this.d.setOnClickListener(null);
        this.e.setOnClickListener(null);
      } 
      if (!TextUtils.isEmpty(this.b.feed_content)) {
        this.g.setText(this.b.feed_content);
        this.g.setVisibility(0);
      } else {
        this.g.setVisibility(8);
      } 
      if (this.b.is_show_adm_icon == 1) {
        this.i.setVisibility(0);
      } else {
        this.i.setVisibility(8);
      } 
      try {
        if (this.b.feed_pics_width != null && this.b.feed_pics_width.length > 0) {
          float f = Float.parseFloat(this.b.feed_pics_height[0]) / Float.parseFloat(this.b.feed_pics_width[0]);
          ViewGroup.LayoutParams layoutParams = this.h.getLayoutParams();
          layoutParams.width = AppInfo.l - DensityUtils.a(this.a.a, 20.0F);
          layoutParams.height = (int)(layoutParams.width * f);
          this.h.setLayoutParams(layoutParams);
        } 
      } catch (Exception exception) {}
      String str = AvatarUtils.a(this.b.feed_pics[0]);
      ImageLoader.a(this.a.b, str).a(FeedListAdapterForRecyclerView.h(this.a)).a(this.h);
      this.h.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
    }
    
    private void c() {
      if (!this.b.isShowUrlVisited) {
        if (this.a.c == 5 && FeedListAdapterForRecyclerView.d(this.a) >= 0) {
          InstantLog.a(this.b.feed_id, FeedListAdapterForRecyclerView.e(this.a), FeedListAdapterForRecyclerView.d(this.a), this.b.feed_uid);
        } else {
          InstantLog.a(FeedMethods.a(this.a.c), this.b.feed_id, this.b.recommend_text, this.b.feed_uid);
        } 
        if (this.b.show_url != null && this.b.show_url.length > 0)
          for (int i = 0; i < this.b.show_url.length; i++)
            FindHttpUtils.a(this.b.show_url[i]);  
        FeedShowVisitedObserver.a().a(this.b.feed_id);
        this.b.isShowUrlVisited = true;
      } 
    }
    
    private void d() {
      String str = this.b.feed_id;
      ArrayList<String> arrayList = new ArrayList();
      arrayList.add(this.a.a.getResources().getString(2131758278));
      CommonShowBottomWindow.a((FragmentActivity)this.a.a, arrayList.<String>toArray(new String[arrayList.size()]), new ActionSheet.ActionSheetListener(this) {
            public void a(ActionSheet param2ActionSheet, int param2Int) {
              if (param2ActionSheet.a(param2Int).equals(this.a.a.a.getResources().getString(2131758278))) {
                this.a.a.d(FeedListAdapterForRecyclerView.AdFeedViewHolder.a(this.a));
                BluedADExtra bluedADExtra = new BluedADExtra();
                bluedADExtra.ads_id = Long.parseLong((FeedListAdapterForRecyclerView.AdFeedViewHolder.b(this.a)).feed_id);
                bluedADExtra.local_closed_time = System.currentTimeMillis();
                bluedADExtra.close_time = (FeedListAdapterForRecyclerView.AdFeedViewHolder.b(this.a)).close_time;
                BluedPreferences.a(bluedADExtra);
                if ((FeedListAdapterForRecyclerView.AdFeedViewHolder.b(this.a)).hidden_url != null && (FeedListAdapterForRecyclerView.AdFeedViewHolder.b(this.a)).hidden_url.length > 0)
                  for (param2Int = 0; param2Int < (FeedListAdapterForRecyclerView.AdFeedViewHolder.b(this.a)).hidden_url.length; param2Int++)
                    FindHttpUtils.a((FeedListAdapterForRecyclerView.AdFeedViewHolder.b(this.a)).hidden_url[param2Int]);  
              } 
            }
            
            public void a(ActionSheet param2ActionSheet, boolean param2Boolean) {}
          });
    }
    
    private void e() {
      WebViewShowInfoFragment.show(this.a.a, this.b.detail_url, 9);
      if (this.b.click_url != null && this.b.click_url.length > 0)
        for (int i = 0; i < this.b.click_url.length; i++)
          FindHttpUtils.a(this.b.click_url[i]);  
    }
    
    private void f() {
      WebViewShowInfoFragment.show(this.a.a, this.b.target_url, 9);
      if (this.b.click_url != null && this.b.click_url.length > 0)
        for (int i = 0; i < this.b.click_url.length; i++)
          FindHttpUtils.a(this.b.click_url[i]);  
    }
    
    public void a(BluedIngSelfFeed param1BluedIngSelfFeed, int param1Int) {
      this.b = param1BluedIngSelfFeed;
      this.c = param1Int;
      c();
      b();
      a();
    }
    
    public void onClick(View param1View) {
      switch (param1View.getId()) {
        default:
          return;
        case 2131297419:
          e();
          return;
        case 2131297362:
        case 2131299358:
          f();
          return;
        case 2131296418:
          break;
      } 
      d();
    }
  }
  
  class null implements ActionSheet.ActionSheetListener {
    null(FeedListAdapterForRecyclerView this$0) {}
    
    public void a(ActionSheet param1ActionSheet, int param1Int) {
      if (param1ActionSheet.a(param1Int).equals(this.a.a.a.getResources().getString(2131758278))) {
        this.a.a.d(FeedListAdapterForRecyclerView.AdFeedViewHolder.a(this.a));
        BluedADExtra bluedADExtra = new BluedADExtra();
        bluedADExtra.ads_id = Long.parseLong((FeedListAdapterForRecyclerView.AdFeedViewHolder.b(this.a)).feed_id);
        bluedADExtra.local_closed_time = System.currentTimeMillis();
        bluedADExtra.close_time = (FeedListAdapterForRecyclerView.AdFeedViewHolder.b(this.a)).close_time;
        BluedPreferences.a(bluedADExtra);
        if ((FeedListAdapterForRecyclerView.AdFeedViewHolder.b(this.a)).hidden_url != null && (FeedListAdapterForRecyclerView.AdFeedViewHolder.b(this.a)).hidden_url.length > 0)
          for (param1Int = 0; param1Int < (FeedListAdapterForRecyclerView.AdFeedViewHolder.b(this.a)).hidden_url.length; param1Int++)
            FindHttpUtils.a((FeedListAdapterForRecyclerView.AdFeedViewHolder.b(this.a)).hidden_url[param1Int]);  
      } 
    }
    
    public void a(ActionSheet param1ActionSheet, boolean param1Boolean) {}
  }
  
  abstract class BaseFeedViewHolder implements View.OnClickListener {
    private ShapeLinearLayout A;
    
    private TextView B;
    
    private ImageView C;
    
    private LinearLayout D;
    
    private View E;
    
    private TextView F;
    
    private View G;
    
    private TextView H;
    
    private View I;
    
    private TextView J;
    
    private TextView K;
    
    private ImageView L;
    
    private View M;
    
    private View N;
    
    private ImageView O;
    
    private TextView P;
    
    private View Q;
    
    private View R;
    
    private TextView S;
    
    private View T;
    
    private LinearLayout U;
    
    private ImageView V;
    
    private TextView W;
    
    private LinearLayout X;
    
    private ImageView Y;
    
    private TextView Z;
    
    protected BluedIngSelfFeed a;
    
    private LinearLayout aa;
    
    private LinearLayout ab;
    
    private ImageView ac;
    
    private TextView ad;
    
    private ImageView ae;
    
    private View af;
    
    private TextView ag;
    
    private TextView ah;
    
    private LinearLayout ai;
    
    private View aj;
    
    private ImageView ak;
    
    private ImageView al;
    
    protected String b;
    
    protected View c;
    
    private View e;
    
    private int f;
    
    private View g;
    
    private View h;
    
    private ImageView i;
    
    private TextView j;
    
    private ImageView k;
    
    private ImageView l;
    
    private View m;
    
    private ImageView n;
    
    private AvatarLivingAnimView o;
    
    private ImageView p;
    
    private ImageView q;
    
    private TextView r;
    
    private ImageView s;
    
    private ImageView t;
    
    private LinearLayout u;
    
    private TextView v;
    
    private ImageView w;
    
    private ImageView x;
    
    private FollowStatusView y;
    
    private LinearLayout z;
    
    public BaseFeedViewHolder(FeedListAdapterForRecyclerView this$0, View param1View) {
      this.e = param1View;
      this.g = a(2131297032);
      this.g.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
      this.h = a(2131297050);
      this.i = a(2131297969);
      this.j = a(2131301507);
      this.k = a(2131301714);
      this.l = a(2131297543);
      this.m = a(2131297049);
      this.n = a(2131297362);
      this.o = a(2131298685);
      this.p = a(2131297575);
      this.q = a(2131297536);
      this.r = a(2131299358);
      this.s = a(2131297528);
      this.t = a(2131297447);
      this.u = (LinearLayout)param1View.findViewById(2131298695);
      this.v = (TextView)param1View.findViewById(2131300756);
      this.w = (ImageView)param1View.findViewById(2131297481);
      this.x = a(2131299215);
      this.y = a(2131297199);
      this.A = a(2131299038);
      ShapeHelper.b((ShapeHelper.ShapeView)this.A, 2131100881);
      this.z = a(2131299039);
      this.B = a(2131301233);
      this.C = a(2131297908);
      this.D = a(2131298780);
      this.E = a(2131296958);
      this.F = a(2131296943);
      this.G = a(2131296957);
      this.J = a(2131300267);
      this.K = a(2131300763);
      this.L = a(2131297482);
      this.I = a(2131296956);
      this.H = a(2131300501);
      this.M = a(2131297043);
      this.N = a(2131299162);
      this.O = a(2131299161);
      this.P = a(2131299163);
      this.Q = a(2131298095);
      this.R = a(2131299980);
      this.S = a(2131301364);
      this.T = a(2131297039);
      this.U = a(2131299146);
      this.V = a(2131297400);
      this.W = a(2131301787);
      this.X = a(2131298773);
      this.Y = a(2131297395);
      this.Z = a(2131296800);
      this.aa = a(2131298774);
      this.ab = a(2131298877);
      this.ac = a(2131297405);
      this.ad = a(2131301336);
      this.ae = a(2131297507);
      this.af = a(2131297036);
      this.ag = a(2131299647);
      this.ah = a(2131299648);
      this.ai = a(2131299646);
      this.aj = a(2131301626);
      this.ak = a(2131297038);
      this.al = a(2131297700);
    }
    
    private void A() {
      if (!g()) {
        this.z.setVisibility(8);
        return;
      } 
      this.z.setVisibility(0);
      this.z.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
      this.B.setText(p().getFeedFeedShow(this.d.a, this.a.feed_show));
      if (this.a.can_promotion == 1) {
        int i = this.a.promotion_status;
        if (i != 1) {
          if (i != 2) {
            if (i != 3) {
              this.C.setVisibility(8);
              return;
            } 
            this.C.setImageResource(2131232191);
            this.C.setVisibility(0);
            return;
          } 
          this.C.setImageResource(2131232195);
          this.C.setVisibility(0);
          return;
        } 
        this.C.setImageResource(2131232190);
        this.C.setVisibility(0);
        return;
      } 
      this.C.setVisibility(8);
    }
    
    private void B() {
      if (g()) {
        this.x.setVisibility(8);
        this.u.setVisibility(8);
      } else if (this.a.is_recommend != 1) {
        this.x.setVisibility(0);
        this.x.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
        this.x.setImageDrawable(this.d.a.getResources().getDrawable(2131232197));
        this.u.setVisibility(8);
      } else {
        this.x.setVisibility(8);
        this.u.setVisibility(0);
        this.u.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
      } 
      if (i() || j() || g() || l() || h()) {
        if (this.a.forceShowFollowedStatus && h()) {
          this.y.setVisibility(0);
          this.y.setRelationShip(this.a.relationship);
          this.y.setOnClickListener(new -$$Lambda$FeedListAdapterForRecyclerView$BaseFeedViewHolder$efFTN3hxQhvA1h_iE4F_YTHTNxY(this));
        } else {
          this.y.setVisibility(8);
        } 
      } else {
        this.y.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
        this.y.setVisibility(0);
        this.y.setRelationShip("0");
      } 
      if (!g()) {
        if (i() && this.a.feed_views == 1) {
          this.L.setVisibility(0);
          return;
        } 
        this.L.setVisibility(8);
        return;
      } 
      this.L.setVisibility(8);
    }
    
    private void C() {
      String str;
      ImageLoader.a(this.d.b, AvatarUtils.a(0, this.a.user_avatar)).a(2131234356).c().a(this.n);
      this.n.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
      TextView textView = this.r;
      if (!TextUtils.isEmpty(this.a.note)) {
        str = this.a.note;
      } else {
        str = this.a.user_name;
      } 
      textView.setText(str);
      this.r.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
      UserBasicModel userBasicModel = new UserBasicModel();
      userBasicModel.vip_grade = this.a.vip_grade;
      userBasicModel.is_vip_annual = this.a.is_vip_annual;
      userBasicModel.is_hide_vip_look = this.a.is_hide_vip_look;
      userBasicModel.vip_exp_lvl = this.a.vip_exp_lvl;
      UserRelationshipUtils.a(this.d.a, this.r, userBasicModel);
      UserRelationshipUtils.a(this.t, userBasicModel);
      if (l()) {
        this.p.setVisibility(8);
        this.q.setVisibility(0);
        this.s.setVisibility(0);
        this.o.setVisibility(8);
        UserRelationshipUtils.b(this.s, this.a.vbadge, 2, 8);
        if (this.a.live > 0) {
          this.q.setImageDrawable(BluedSkinUtils.b(this.d.a, 2131234363));
          return;
        } 
        if (this.a.online_state == 1) {
          this.q.setImageDrawable(BluedSkinUtils.b(this.d.a, 2131234365));
          return;
        } 
        this.q.setVisibility(8);
        return;
      } 
      this.q.setVisibility(8);
      this.s.setVisibility(8);
      if (this.a.live > 0) {
        this.p.setVisibility(8);
        this.o.setVisibility(0);
        return;
      } 
      UserRelationshipUtils.a(this.p, this.a.vbadge, 3);
      this.o.setVisibility(8);
    }
    
    private void D() {
      if (!g() || this.d.c == 11 || this.d.c == 12) {
        this.h.setVisibility(8);
        return;
      } 
      this.h.setVisibility(0);
      if (this.a.feed_views == 1) {
        this.i.setImageResource(2131232228);
        this.j.setText(this.d.a.getString(2131756454));
        this.j.setTextColor(this.d.a.getResources().getColor(2131100819));
      } else {
        this.j.setTextColor(this.d.a.getResources().getColor(2131100844));
        FeedMethods.a(this.d.a, this.a.reading_scope, this.i, this.j);
      } 
      if (!TextUtils.isEmpty(this.a.promotion_bubble)) {
        ImageLoader.a(this.d.b, this.a.promotion_bubble).f().a(this.l);
        this.l.setVisibility(0);
        this.l.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
      } else {
        this.l.setVisibility(8);
      } 
      this.k.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
    }
    
    private boolean E() {
      return (this.a.theme_id != 0);
    }
    
    private boolean F() {
      return (this.a.theme_pendant != 0);
    }
    
    private void G() {
      a(this.a, false);
    }
    
    private void H() {
      a(this.a, false);
    }
    
    private void I() {
      a(this.a, false);
      LogData logData = new LogData();
      logData.J = "feed_comment_area_click";
      logData.n = this.a.feed_id;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(FeedMethods.a(this.d.c));
      stringBuilder.append("");
      logData.g = stringBuilder.toString();
      logData.k = this.a.recommend_text;
      if (!TextUtils.isEmpty(FeedListAdapterForRecyclerView.e(this.d)))
        logData.t = FeedListAdapterForRecyclerView.e(this.d); 
      if (FeedListAdapterForRecyclerView.d(this.d) != -1) {
        stringBuilder = new StringBuilder();
        stringBuilder.append(FeedListAdapterForRecyclerView.d(this.d));
        stringBuilder.append("");
        logData.h = stringBuilder.toString();
      } 
      InstantLog.a(logData);
    }
    
    private void J() {
      if (e()) {
        EventTrackFeed.f(FeedProtos.Event.PLAZA_RECOMMEND_NOTE_COMMENT_CLICK, this.a.circle_id, this.a.feed_id);
      } else {
        InstantLog.b(FeedMethods.a(this.d.c), this.a, FeedListAdapterForRecyclerView.e(this.d), FeedListAdapterForRecyclerView.d(this.d));
      } 
      if (!PopMenuUtils.a(this.d.a))
        a(this.a, true); 
    }
    
    private void K() {
      if (e()) {
        boolean bool1;
        boolean bool2;
        FeedProtos.Event event = FeedProtos.Event.CIRCLE_NOTE_LIKE;
        String str1 = this.a.circle_id;
        String str2 = this.a.feed_id;
        if (this.a.iliked == 0) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        boolean bool = StringUtils.a(this.a.feed_content);
        FeedProtos.FeedClass feedClass = EventTrackFeed.a(this.a);
        FeedProtos.NoteType noteType = EventTrackFeed.b(this.a);
        if (this.a.is_anonym == 1) {
          bool2 = true;
        } else {
          bool2 = false;
        } 
        EventTrackFeed.a(event, str1, str2, "", bool1, bool, feedClass, noteType, bool2, false, EventTrackFeed.g(this.d.c));
      } else {
        boolean bool1;
        boolean bool2;
        FeedProtos.Event event = FeedProtos.Event.FEED_LIKE_BTN_CLICK;
        String str1 = this.a.feed_id;
        String str2 = this.a.super_did;
        if (this.a.iliked == 0) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        FeedProtos.SourcePage sourcePage = EventTrackFeed.c(this.d.c);
        String str3 = this.a.feed_uid;
        if (this.a.in_promotion == 1) {
          bool2 = true;
        } else {
          bool2 = false;
        } 
        EventTrackFeed.a(event, str1, str2, bool1, sourcePage, str3, bool2, this.a.recommend_text);
      } 
      if (!UserRelationshipUtils.a(this.a.relationship)) {
        if (this.a.iliked == 0) {
          this.a.iliked = 1;
          InstantLog.a(FeedMethods.a(this.d.c), this.a, FeedListAdapterForRecyclerView.e(this.d), FeedListAdapterForRecyclerView.d(this.d));
          b(this.a);
          return;
        } 
        this.V.setImageDrawable(BluedSkinUtils.b(this.d.a, 2131232487));
        BluedIngSelfFeed bluedIngSelfFeed = this.a;
        bluedIngSelfFeed.iliked = 0;
        c(bluedIngSelfFeed);
      } 
    }
    
    private void L() {
      EventTrackFeed.a(FeedProtos.Event.FEED_SUPER_TOPIC_ENTER_CLICK, this.a.feed_id, this.a.super_did, FeedProtos.FeedTopicPage.FEED_TOPIC_FEED_LIST);
      EventTrackFeed.a(FeedProtos.Event.SUPER_TOPIC_DETAIL_SHOW, EventTrackFeed.a(this.d.c));
      SuperTopicDetailFragment.a(this.d.a, this.a.super_did);
    }
    
    private void M() {
      if (N())
        ShowPositionActivity.a(this.d.a, this.a.location_lot, this.a.location_lat, this.a.location, 1); 
    }
    
    private boolean N() {
      new CoordinateConverter();
      boolean bool = CoordinateConverter.isAMapDataAvailable(Double.parseDouble(this.a.location_lat), Double.parseDouble(this.a.location_lot));
      return ((!TextUtils.isEmpty(this.a.location_lot) || !TextUtils.isEmpty(this.a.location_lat)) && bool);
    }
    
    private void O() {
      boolean bool1;
      FeedProtos.FollowLocation followLocation;
      String str1;
      LogData logData = new LogData();
      logData.J = "square_attention_click";
      logData.b = this.a.feed_uid;
      logData.k = this.a.recommend_text;
      InstantLog.a(logData);
      this.y.setRelationShip("1");
      UserHttpUtils.b(this.d.a, new UserRelationshipUtils.IAddOrRemoveAttentionDone(this) {
            public void a() {}
            
            public void a(String param2String) {
              this.a.a.relationship = "1";
              this.a.a.forceShowFollowedStatus = true;
              AppMethods.d(2131756542);
            }
            
            public void b() {}
            
            public void b(String param2String) {}
            
            public void c() {
              FeedListAdapterForRecyclerView.BaseFeedViewHolder.c(this.a).setRelationShip("0");
            }
          },  this.a.feed_uid, "shine_video_list", this.d.b);
      int i = this.d.c;
      if (i != 2) {
        if (i != 10) {
          if (i != 12) {
            if (i != 14) {
              if (i != 4) {
                if (i != 5) {
                  if (i != 6) {
                    logData = null;
                  } else {
                    followLocation = FeedProtos.FollowLocation.FOLLOW_PLAZA_RECOMMEND_FEED;
                  } 
                } else {
                  followLocation = FeedProtos.FollowLocation.FOLLOW_SUPER_TOPIC_FEED;
                } 
              } else {
                followLocation = FeedProtos.FollowLocation.FOLLOW_PLAZA_NEARBY;
              } 
            } else {
              followLocation = FeedProtos.FollowLocation.FOLLOW_FEED_DETAIL_MORE;
            } 
          } else {
            followLocation = FeedProtos.FollowLocation.FOLLOW_FEED_LIKE;
          } 
        } else {
          followLocation = FeedProtos.FollowLocation.FOLLOW_PLAZA_IMAGE;
        } 
      } else {
        followLocation = FeedProtos.FollowLocation.FOLLOW_FEED_DETAIL_MORE;
      } 
      if (TextUtils.isEmpty(this.a.super_did)) {
        str1 = "";
      } else {
        str1 = this.a.super_did;
      } 
      FeedProtos.Event event = FeedProtos.Event.OTHER_FOLLOW_CLICK;
      String str2 = this.a.feed_uid;
      String str3 = this.a.feed_id;
      i = this.a.live;
      boolean bool2 = true;
      if (i > 0) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      if (this.a.in_promotion != 1)
        bool2 = false; 
      EventTrackFeed.a(event, str2, str3, str1, followLocation, true, bool1, bool2);
    }
    
    private void P() {
      EventTrackFeed.a(FeedProtos.Event.FEED_VIEW_NUM_CLICK, this.a.feed_id, this.a.feed_uid, EventTrackFeed.c(this.d.c));
      if (!TextUtils.isEmpty(this.a.promotion_url)) {
        InstantLog.a("feed_read_count_click", Integer.valueOf(FeedMethods.a(this.d.c)));
        WebViewShowInfoFragment.show(this.d.a, this.a.promotion_url, 0);
      } 
    }
    
    private void a(View param1View) {
      this.w.setImageDrawable(this.d.a.getResources().getDrawable(2131232484));
      String str = this.a.feed_id;
      View view = LayoutInflater.from(this.d.a).inflate(2131493050, null);
      TextView textView2 = (TextView)view.findViewById(2131300498);
      TextView textView1 = (TextView)view.findViewById(2131300499);
      if (!TextUtils.isEmpty(this.a.recommend_text)) {
        textView2.setText(this.a.recommend_text);
      } else {
        textView2.setText(this.d.a.getResources().getString(2131755634));
      } 
      PopupWindow popupWindow = new PopupWindow(view, -2, -2, true);
      popupWindow.setTouchable(true);
      popupWindow.setBackgroundDrawable(this.d.a.getResources().getDrawable(17170445));
      popupWindow.showAsDropDown(param1View);
      popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener(this) {
            public void onDismiss() {
              FeedListAdapterForRecyclerView.BaseFeedViewHolder.d(this.a).setImageDrawable(this.a.d.a.getResources().getDrawable(2131232483));
            }
          });
      textView1.setOnClickListener(new View.OnClickListener(this, popupWindow) {
            public void onClick(View param2View) {
              FeedListAdapterForRecyclerView.BaseFeedViewHolder baseFeedViewHolder = this.b;
              baseFeedViewHolder.a(baseFeedViewHolder.a);
              this.a.dismiss();
              BluedADExtra bluedADExtra = new BluedADExtra();
              bluedADExtra.ads_id = Long.parseLong(this.b.a.feed_id);
              bluedADExtra.local_closed_time = System.currentTimeMillis();
              bluedADExtra.close_time = this.b.a.close_time;
              BluedPreferences.a(bluedADExtra);
              if (this.b.a.hidden_url != null && this.b.a.hidden_url.length > 0)
                for (int i = 0; i < this.b.a.hidden_url.length; i++)
                  FindHttpUtils.a(this.b.a.hidden_url[i]);  
            }
          });
    }
    
    private void a(boolean param1Boolean) {
      EventTrackFeed.b(FeedProtos.Event.FEED_PHOTO_CLICK, this.a.feed_id, this.a.feed_uid);
      if (!i()) {
        String str1 = FeedMethods.a(this.d.c, this.a.is_vote);
        UserBasicModel userBasicModel = new UserBasicModel();
        userBasicModel.uid = this.a.feed_uid;
        userBasicModel.name = this.a.user_name;
        userBasicModel.avatar = this.a.user_avatar;
        userBasicModel.is_show_vip_page = this.a.is_show_vip_page;
        LogData logData1 = new LogData();
        logData1.J = "feed_avatar_click";
        logData1.n = this.a.feed_id;
        logData1.k = this.a.recommend_text;
        logData1.b = this.a.feed_uid;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(FeedMethods.a(this.d.c));
        stringBuilder.append("");
        logData1.g = stringBuilder.toString();
        if (!TextUtils.isEmpty(FeedListAdapterForRecyclerView.e(this.d)))
          logData1.t = FeedListAdapterForRecyclerView.e(this.d); 
        if (FeedListAdapterForRecyclerView.d(this.d) != -1) {
          stringBuilder = new StringBuilder();
          stringBuilder.append(FeedListAdapterForRecyclerView.d(this.d));
          stringBuilder.append("");
          logData1.h = stringBuilder.toString();
        } 
        InstantLog.a(logData1);
        if (this.a.live > 0 && param1Boolean) {
          UserRelationshipUtils.a(this.d.a, userBasicModel, this.a.live, str1);
          return;
        } 
        String str2 = EncryptTool.b(this.a.feed_id);
        MessageProtos.StrangerSource strangerSource = FeedMethods.b(this.d.c, this.a.in_promotion);
        LogData logData2 = new LogData();
        logData2.x = p().getDistance();
        int j = this.a.in_promotion;
        int i = 0;
        param1Boolean = true;
        if (j != 1)
          param1Boolean = false; 
        logData2.B = param1Boolean;
        logData2.I = this.a.feed_id;
        UserInfoFragmentNew.a(this.d.a, userBasicModel, str1, (View)this.n, logData2, new MsgSourceEntity(strangerSource, str2));
        if (this.a.click_url != null && this.a.click_url.length > 0)
          while (i < this.a.click_url.length) {
            FindHttpUtils.a(this.a.click_url[i]);
            i++;
          }  
      } 
    }
    
    private void b(BluedIngSelfFeed param1BluedIngSelfFeed) {
      this.d.h = true;
      b(param1BluedIngSelfFeed, 1);
      if (e()) {
        CircleHttpUtils.a(null, UserInfo.a().i().getUid(), param1BluedIngSelfFeed.feed_id, param1BluedIngSelfFeed.liked_url, this.d.b);
        return;
      } 
      FeedHttpUtils.a(this.d.a, null, UserInfo.a().i().getUid(), param1BluedIngSelfFeed.feed_id, param1BluedIngSelfFeed.is_ads, param1BluedIngSelfFeed.liked_url, this.d.b);
    }
    
    private void b(BluedIngSelfFeed param1BluedIngSelfFeed, int param1Int) {
      if (param1Int == 0 || param1Int == 1) {
        param1BluedIngSelfFeed.iliked = param1Int;
        boolean bool = false;
        try {
          int i = param1BluedIngSelfFeed.feed_dig;
          if (param1Int == 1) {
            param1Int = ++i;
            if (this.d.h) {
              param1BluedIngSelfFeed.isPlayLikeAnim = true;
              this.d.h = false;
              param1Int = i;
            } 
          } else {
            param1Int = i - 1;
          } 
          if (param1Int < 0)
            param1Int = bool; 
        } catch (Exception exception) {
          param1Int = bool;
        } 
        param1BluedIngSelfFeed.feed_dig = param1Int;
      } 
      x();
    }
    
    private void c(BluedIngSelfFeed param1BluedIngSelfFeed) {
      param1BluedIngSelfFeed.iliked = 0;
      b(param1BluedIngSelfFeed, 0);
      if (e()) {
        CircleHttpUtils.a(null, UserInfo.a().i().getUid(), param1BluedIngSelfFeed.feed_id, this.d.b);
        return;
      } 
      FeedHttpUtils.a(this.d.a, null, UserInfo.a().i().getUid(), param1BluedIngSelfFeed.feed_id, param1BluedIngSelfFeed.is_ads, this.d.b);
    }
    
    private void d(BluedIngSelfFeed param1BluedIngSelfFeed) {
      FeedHttpUtils.a(this.d.a, new BluedUIHttpResponse<BluedEntity>(this, param1BluedIngSelfFeed) {
            public void onUIFinish() {
              super.onUIFinish();
              DialogUtils.b(this.b.d.e);
            }
            
            public void onUIStart() {
              super.onUIStart();
              DialogUtils.a(this.b.d.e);
            }
            
            public void onUIUpdate(BluedEntity param2BluedEntity) {
              this.b.a(this.a);
              if (this.a.repost != null)
                LiveEventBus.get("feed_delete_repost").post(this.a.repost.feed_id); 
              AppMethods.d(2131756175);
            }
          }param1BluedIngSelfFeed.feed_id, this.d.b, true);
    }
    
    private void s() {
      if (F()) {
        this.al.setVisibility(0);
        ImageLoader.a(this.d.b, AvatarWidgetManager.a().a(this.a.theme_pendant)).a(this.al);
        return;
      } 
      this.al.setVisibility(8);
    }
    
    private void t() {
      if (E()) {
        this.ak.setVisibility(0);
        ImageLoader.a(this.d.b, DynamicSkinManager.a().a(this.a.theme_id)).a(this.ak);
        this.ak.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
        return;
      } 
      this.ak.setVisibility(8);
    }
    
    private void u() {
      if (this.aj != null && i()) {
        if (this.f == FeedListAdapterForRecyclerView.c(this.d).size() - 1) {
          this.aj.setVisibility(8);
          return;
        } 
        this.aj.setVisibility(0);
      } 
    }
    
    private void v() {
      this.b = b();
      this.c = a();
    }
    
    private void w() {
      List<CharSequence> list = p().getCommentList();
      if (list != null && list.size() > 0) {
        this.af.setVisibility(0);
        this.ag.setText(list.get(0));
        this.ag.setMovementMethod((MovementMethod)LinkMovementClickMethod.a());
        this.ag.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
        if (list.size() >= 2) {
          this.ah.setVisibility(0);
          this.ah.setText(list.get(1));
          this.ah.setMovementMethod((MovementMethod)LinkMovementClickMethod.a());
          this.ah.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
        } else {
          this.ah.setVisibility(8);
        } 
        if (this.a.feed_comment > 2) {
          this.ai.setVisibility(0);
        } else {
          this.ai.setVisibility(8);
        } 
      } else {
        this.af.setVisibility(8);
      } 
      this.af.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
      this.ai.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
    }
    
    private void x() {
      this.U.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
      if (this.a.iliked == 0) {
        this.V.setImageDrawable(BluedSkinUtils.b(this.d.a, 2131232487));
        this.W.setTextColor(BluedSkinUtils.a(this.d.a, 2131100838));
      } else {
        if (this.a.isPlayLikeAnim) {
          ImageLoader.c(this.d.b, "feed_like_big_anim_708.png").g().a(new ImageLoader.OnAnimationStateListener(this) {
                public void a() {}
                
                public void b() {
                  FeedListAdapterForRecyclerView.BaseFeedViewHolder.a(this.a).setImageDrawable(null);
                }
              }).a(this.ae);
          ImageLoader.c(this.d.b, FeedMethods.a()).g().a(new ImageLoader.OnAnimationStateListener(this) {
                public void a() {}
                
                public void b() {
                  if (this.a.a.iliked != 0)
                    ImageLoader.a(this.a.d.b, 2131232488).a(FeedListAdapterForRecyclerView.BaseFeedViewHolder.b(this.a)); 
                }
              }).a(this.V);
          this.a.isPlayLikeAnim = false;
        } else {
          ImageLoader.a(this.d.b, 2131232488).a(this.V);
        } 
        this.W.setTextColor(this.d.a.getResources().getColor(2131100538));
      } 
      this.W.setText(p().getFeedDig(this.d.a, this.a.feed_dig));
      this.X.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
      this.Z.setText(p().getFeedComment(this.d.a, this.a.feed_comment));
      if (c()) {
        this.aa.setVisibility(0);
        if (o() || this.a.disallow_share == 1) {
          this.ac.setImageDrawable(BluedSkinUtils.b(this.d.a, 2131232501));
          this.ad.setTextColor(BluedSkinUtils.a(this.d.a, 2131100845));
          this.aa.setEnabled(false);
        } else {
          this.ac.setImageDrawable(BluedSkinUtils.b(this.d.a, 2131232497));
          this.ad.setTextColor(BluedSkinUtils.a(this.d.a, 2131100838));
          this.aa.setEnabled(true);
          this.aa.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
        } 
      } else {
        this.aa.setVisibility(8);
      } 
      if (d()) {
        this.ab.setVisibility(0);
        this.ab.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
        return;
      } 
      this.ab.setVisibility(8);
    }
    
    private void y() {
      if (this.a.is_super_topics == 1 && !TextUtils.isEmpty(this.a.super_topics_name)) {
        this.Q.setVisibility(0);
        this.R.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
        this.S.setText(this.a.super_topics_name);
      } else {
        this.Q.setVisibility(8);
      } 
      if (!TextUtils.isEmpty(this.a.location) || (this.a.is_super_topics == 1 && !TextUtils.isEmpty(this.a.super_topics_name))) {
        this.M.setVisibility(0);
        if (!TextUtils.isEmpty(this.a.location)) {
          this.N.setVisibility(0);
          this.N.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
          this.P.setText(this.a.location);
          return;
        } 
        this.N.setVisibility(8);
        return;
      } 
      this.M.setVisibility(8);
      this.N.setVisibility(8);
    }
    
    private void z() {
      boolean bool1;
      boolean bool2;
      boolean bool3;
      boolean bool = m();
      boolean bool4 = true;
      if (bool && this.a.is_recommend_ticktocks == 1) {
        String str1;
        this.F.setVisibility(8);
        this.K.setVisibility(0);
        TextView textView = this.K;
        if (!TextUtils.isEmpty(this.a.recommend_text)) {
          str1 = this.a.recommend_text;
        } else {
          str1 = this.d.a.getString(2131756501);
        } 
        textView.setText(str1);
      } else {
        this.K.setVisibility(8);
        if (!TextUtils.isEmpty(p().getDistance()) && !g()) {
          this.F.setVisibility(0);
          this.F.setText(p().getDistance());
          DistanceUtils.a(this.d.a, this.F, this.a.is_hide_distance, 0);
        } else {
          this.F.setVisibility(8);
        } 
      } 
      String str = p().getFeedTimestamp();
      if (!TextUtils.isEmpty(str) && !l()) {
        this.J.setText(str);
        this.J.setVisibility(0);
      } else {
        this.J.setText("");
        this.J.setVisibility(8);
      } 
      if (l() && !g() && !h() && this.a.vbadge != 5) {
        if (this.a.age > 0 || this.a.height > 0 || this.a.weight > 0) {
          this.H.setVisibility(0);
          StringBuilder stringBuilder = new StringBuilder();
          if (this.a.age > 0) {
            stringBuilder.append(this.a.age);
          } else {
            stringBuilder.append("~");
          } 
          stringBuilder.append(this.d.a.getString(2131756158));
          if (this.a.height > 0) {
            stringBuilder.append(this.a.height);
          } else {
            stringBuilder.append("~");
          } 
          stringBuilder.append(this.d.a.getString(2131756158));
          if (this.a.weight > 0) {
            stringBuilder.append(this.a.weight);
          } else {
            stringBuilder.append("~");
          } 
          this.H.setText(stringBuilder.toString());
        } else {
          this.H.setVisibility(8);
        } 
      } else {
        this.H.setVisibility(8);
      } 
      if (this.K.getVisibility() == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      if (this.F.getVisibility() == 0) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      if (this.J.getVisibility() == 0) {
        bool3 = true;
      } else {
        bool3 = false;
      } 
      if (this.H.getVisibility() != 0)
        bool4 = false; 
      if (bool1 && (bool2 || bool3)) {
        this.E.setVisibility(0);
      } else {
        this.E.setVisibility(8);
      } 
      if (bool2 && bool3) {
        this.G.setVisibility(0);
      } else {
        this.G.setVisibility(8);
      } 
      if ((bool1 || bool2 || bool3) && bool4) {
        this.I.setVisibility(0);
      } else {
        this.I.setVisibility(8);
      } 
      if (this.F.getVisibility() != 0 && this.J.getVisibility() != 0 && this.K.getVisibility() != 0 && this.H.getVisibility() != 0) {
        ViewGroup.LayoutParams layoutParams = this.r.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
          ((ConstraintLayout.LayoutParams)layoutParams).verticalBias = 0.5F;
          return;
        } 
      } else {
        ViewGroup.LayoutParams layoutParams = this.r.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams)
          ((ConstraintLayout.LayoutParams)layoutParams).verticalBias = 0.0F; 
      } 
    }
    
    protected abstract View a();
    
    protected final <T extends View> T a(int param1Int) {
      return (T)this.e.findViewById(param1Int);
    }
    
    protected void a(BluedIngSelfFeed param1BluedIngSelfFeed) {
      this.d.d(this.f);
    }
    
    public void a(BluedIngSelfFeed param1BluedIngSelfFeed, int param1Int) {
      this.a = param1BluedIngSelfFeed;
      this.f = param1Int;
      v();
      f();
      D();
      C();
      B();
      A();
      z();
      y();
      x();
      w();
      u();
      t();
      s();
    }
    
    protected void a(BluedIngSelfFeed param1BluedIngSelfFeed, boolean param1Boolean) {
      if (!UserRelationshipUtils.a(param1BluedIngSelfFeed.relationship)) {
        if (this.d.c == 6) {
          InstantLog.a("discovery_hot");
        } else {
          InstantLog.a("featured_all_to_detail");
        } 
        LogData logData = new LogData();
        logData.J = "recommend_to_detail";
        logData.n = param1BluedIngSelfFeed.feed_id;
        logData.k = param1BluedIngSelfFeed.recommend_text;
        logData.d = param1BluedIngSelfFeed.recommend_type;
        if (!TextUtils.isEmpty(FeedListAdapterForRecyclerView.e(this.d)))
          logData.t = FeedListAdapterForRecyclerView.e(this.d); 
        if (FeedListAdapterForRecyclerView.d(this.d) != -1) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(FeedListAdapterForRecyclerView.d(this.d));
          stringBuilder.append("");
          logData.h = stringBuilder.toString();
        } 
        InstantLog.a(logData);
        FeedDetailsFragment.a(this.d.a, param1BluedIngSelfFeed, this.d.c, this.d.f, param1Boolean);
      } 
    }
    
    protected void a(BluedIngSelfFeed param1BluedIngSelfFeed, boolean param1Boolean, String param1String1, String param1String2) {
      if (!UserRelationshipUtils.a(param1BluedIngSelfFeed.relationship)) {
        LogData logData = new LogData();
        logData.J = "square_video_click";
        logData.n = param1BluedIngSelfFeed.feed_id;
        logData.k = param1BluedIngSelfFeed.recommend_text;
        InstantLog.a(logData);
        param1BluedIngSelfFeed = (BluedIngSelfFeed)param1BluedIngSelfFeed.clone();
        if (this.d.c == 1) {
          param1BluedIngSelfFeed.feed_uid = param1String2;
          param1BluedIngSelfFeed.feed_id = param1String1;
          VideoUserInfoFragment.a(this.d.a, param1BluedIngSelfFeed);
          return;
        } 
        VideoScanFragment.a(this.d.a, param1BluedIngSelfFeed, param1Boolean, this.d.c);
      } 
    }
    
    protected void a(String param1String) {
      if (this.d.c == 1)
        EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_PROFILE_FEED_MORE_CLICK, param1String); 
      ArrayList<String> arrayList = new ArrayList();
      if (g()) {
        arrayList.add(this.d.a.getResources().getString(2131756457));
        if (this.a.can_promotion == 1)
          arrayList.add(this.d.a.getResources().getString(2131756452)); 
        arrayList.add(this.d.a.getResources().getString(2131756052));
        if (i())
          if (this.a.feed_views == 0) {
            arrayList.add(this.d.a.getResources().getString(2131758909));
          } else {
            arrayList.add(this.d.a.getResources().getString(2131755731));
          }  
        arrayList.add(this.d.a.getResources().getString(2131756224));
        arrayList.add(this.d.a.getResources().getString(2131756176));
      } else {
        if (E())
          arrayList.add(this.d.a.getResources().getString(2131756223)); 
        if (l()) {
          if (!g() && !"1".equalsIgnoreCase(this.a.relationship) && !"3".equalsIgnoreCase(this.a.relationship)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("＋");
            stringBuilder.append(this.d.a.getResources().getString(2131755359));
            arrayList.add(stringBuilder.toString());
          } 
          arrayList.add(this.d.a.getResources().getString(2131758584));
        } else {
          if (this.a.unliked_users_url != null && this.a.unliked_users_url.length > 0)
            arrayList.add(this.d.a.getResources().getString(2131756209)); 
          if (this.a.unliked_url != null && this.a.unliked_url.length > 0)
            arrayList.add(this.d.a.getResources().getString(2131756210)); 
          arrayList.add(this.d.a.getResources().getString(2131758584));
        } 
      } 
      CommonShowBottomWindow.a((FragmentActivity)this.d.a, arrayList.<String>toArray(new String[arrayList.size()]), new ActionSheet.ActionSheetListener(this, param1String) {
            public void a(ActionSheet param2ActionSheet, int param2Int) {
              Context context;
              FeedListAdapterForRecyclerView.BaseFeedViewHolder baseFeedViewHolder;
              String str = param2ActionSheet.a(param2Int);
              if (str.equals(this.b.d.a.getResources().getString(2131756176))) {
                CommonAlertDialog.a(this.b.d.a, this.b.d.a.getResources().getString(2131756094), this.b.d.a.getResources().getString(2131756395), this.b.d.a.getResources().getString(2131756394), new DialogInterface.OnClickListener(this) {
                      public void onClick(DialogInterface param3DialogInterface, int param3Int) {
                        FeedListAdapterForRecyclerView.BaseFeedViewHolder.a(this.a.b, this.a.b.a);
                      }
                    }this.b.d.a.getResources().getString(2131756462), null, null);
                return;
              } 
              if (str.equals(this.b.d.a.getResources().getString(2131758584))) {
                context = this.b.d.a;
                String str1 = this.b.a.feed_id;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(FeedListAdapterForRecyclerView.BaseFeedViewHolder.e(this.b).getText());
                stringBuilder.append("");
                ReportFragmentNew.a(context, 2, str1, stringBuilder.toString());
                return;
              } 
              if (context.equals(this.b.d.a.getResources().getString(2131756209))) {
                if (!this.b.a.isIs_unliked_users_url_visited) {
                  if (this.b.a.unliked_users_url != null && this.b.a.unliked_users_url.length > 0)
                    FindHttpUtils.a(this.b.a.unliked_users_url); 
                  this.b.a.isIs_unliked_users_url_visited = true;
                  baseFeedViewHolder = this.b;
                  baseFeedViewHolder.a(baseFeedViewHolder.a);
                  return;
                } 
              } else if (baseFeedViewHolder.equals(this.b.d.a.getResources().getString(2131756210))) {
                if (!this.b.a.is_unliked_url_visited) {
                  if (this.b.a.unliked_url != null && this.b.a.unliked_url.length > 0)
                    FindHttpUtils.a(this.b.a.unliked_url); 
                  this.b.a.is_unliked_url_visited = true;
                  baseFeedViewHolder = this.b;
                  baseFeedViewHolder.a(baseFeedViewHolder.a);
                  return;
                } 
              } else {
                if (baseFeedViewHolder.equals(this.b.d.a.getResources().getString(2131756052))) {
                  FeedMethods.b((FragmentActivity)this.b.d.a, this.b.a, this.b.d.b);
                  return;
                } 
                if (this.b.d.a.getResources().getString(2131758909).equalsIgnoreCase((String)baseFeedViewHolder)) {
                  EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_PROFILE_FEED_MORE_TOP_CLICK, this.a);
                  FeedHttpUtils.a(new BluedUIHttpResponse(this) {
                        public boolean onUIFailure(int param3Int, String param3String) {
                          if (param3Int == 4031201) {
                            FeedListAdapterForRecyclerView.a(this.a.b.d, true);
                            return true;
                          } 
                          return super.onUIFailure(param3Int, param3String);
                        }
                        
                        public void onUIFinish() {
                          if (FeedListAdapterForRecyclerView.g(this.a.b.d) && this.a.b.d.a != null) {
                            PayUtils.a(this.a.b.d.a, 9, "feed_stay_top");
                            InstantLog.a("feed_stay_top_click", 0);
                            FeedListAdapterForRecyclerView.a(this.a.b.d, false);
                          } else {
                            InstantLog.a("feed_stay_top_click", 1);
                          } 
                          super.onUIFinish();
                        }
                        
                        public void onUIUpdate(BluedEntity param3BluedEntity) {
                          AppMethods.d(2131756206);
                        }
                      }this.b.a.feed_id, this.b.d.b);
                  return;
                } 
                if (baseFeedViewHolder.equalsIgnoreCase(this.b.d.a.getResources().getString(2131756224))) {
                  EventTrackFeed.a(FeedProtos.Event.FEED_SETTING_DYNAMIC_SKIN_SETTINGS_BTN_CLICK, this.b.a.feed_id);
                  DynamicSkinFragment.a(this.b.d.a, 0, "feed_dynamic_skin_setting_main");
                  return;
                } 
                if (baseFeedViewHolder.equalsIgnoreCase(this.b.d.a.getResources().getString(2131755731))) {
                  FeedHttpUtils.b(new BluedUIHttpResponse(this) {
                        public void onUIUpdate(BluedEntity param3BluedEntity) {
                          AppMethods.d(2131756206);
                          PersonalVerifyObserver.a().b();
                        }
                      },  this.b.a.feed_id, this.b.d.b);
                  return;
                } 
                if (this.b.d.a.getResources().getString(2131756457).equals(baseFeedViewHolder)) {
                  FeedMethods.a((FragmentActivity)this.b.d.a, this.b.a, this.b.d.b);
                  return;
                } 
                if (this.b.d.a.getResources().getString(2131756452).equals(baseFeedViewHolder)) {
                  EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_PROFILE_FEED_MORE_EXPOSE_CLICK, this.b.a.feed_id);
                  FlutterRouter.a(this.b.d.a, this.b.a.feed_id, "my_feed_more_option");
                  return;
                } 
                if (this.b.d.a.getResources().getString(2131756223).equals(baseFeedViewHolder)) {
                  EventTrackFeed.a(FeedProtos.Event.FEED_SETTING_DYNAMIC_SKIN_LOOK_BTN_CLICK, this.b.a.feed_id);
                  DynamicSkinFragment.a(this.b.d.a, 0, "feed_dynamic_skin_look_guest");
                  return;
                } 
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("＋");
                stringBuilder.append(this.b.d.a.getResources().getString(2131755359));
                if (stringBuilder.toString().equals(baseFeedViewHolder))
                  FeedListAdapterForRecyclerView.BaseFeedViewHolder.f(this.b); 
              } 
            }
            
            public void a(ActionSheet param2ActionSheet, boolean param2Boolean) {}
          });
    }
    
    protected abstract String b();
    
    protected boolean c() {
      return (this.a.reading_scope == 0 && !l());
    }
    
    protected boolean d() {
      return (l() && !g());
    }
    
    protected abstract boolean e();
    
    protected void f() {
      if (!this.a.isShowUrlVisited) {
        boolean bool1;
        boolean bool2;
        String str1;
        if (this.d.c == 5 && FeedListAdapterForRecyclerView.d(this.d) >= 0) {
          InstantLog.a(this.a.feed_id, FeedListAdapterForRecyclerView.e(this.d), FeedListAdapterForRecyclerView.d(this.d), this.a.feed_uid);
        } else {
          InstantLog.a(FeedMethods.a(this.d.c), this.a.feed_id, this.a.recommend_text, this.a.feed_uid);
        } 
        if (this.a.show_url != null && this.a.show_url.length > 0)
          for (int i = 0; i < this.a.show_url.length; i++)
            FindHttpUtils.a(this.a.show_url[i]);  
        FeedShowVisitedObserver.a().a(this.a.feed_id);
        BluedIngSelfFeed bluedIngSelfFeed = this.a;
        bluedIngSelfFeed.isShowUrlVisited = true;
        if (!TextUtils.isEmpty(bluedIngSelfFeed.promotion_bubble))
          EventTrackSuperExpose.a(SuperExposeProtos.Event.PERSONAL_PAGE_HISTORY_BUBBLE_SHOW, this.a.feed_id, this.a.promotion_bubble_type); 
        if (TextUtils.isEmpty(this.a.super_did)) {
          str1 = "";
        } else {
          str1 = this.a.super_did;
        } 
        FeedProtos.Event event = FeedProtos.Event.FEED_DRAW;
        String str2 = this.a.feed_id;
        FeedProtos.FeedClass feedClass = EventTrackFeed.a(this.a);
        FeedProtos.FeedPage feedPage = EventTrackFeed.b(this.d.c);
        String str3 = this.a.feed_uid;
        if (this.a.in_promotion == 1) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        if (this.a.feed_pics != null && this.a.feed_pics.length > 1) {
          bool2 = true;
        } else {
          bool2 = false;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a.join_circle_id);
        stringBuilder.append("");
        EventTrackFeed.a(event, str2, str1, feedClass, feedPage, str3, bool1, bool2, stringBuilder.toString(), String.valueOf(this.a.live));
      } 
    }
    
    protected boolean g() {
      return UserInfo.a().i().getUid().equals(this.a.feed_uid);
    }
    
    protected boolean h() {
      return ("1".equalsIgnoreCase(this.a.relationship) || "3".equalsIgnoreCase(this.a.relationship));
    }
    
    protected boolean i() {
      return (this.d.c == 1);
    }
    
    protected boolean j() {
      return (this.d.c == 0);
    }
    
    protected boolean k() {
      return (this.d.c == 6);
    }
    
    protected boolean l() {
      return (this.d.c == 4);
    }
    
    protected boolean m() {
      return (this.d.c == 0 || this.d.c == 6 || this.d.c == 10 || this.d.c == 4 || this.d.c == 14);
    }
    
    protected boolean n() {
      return this.a.isRepost();
    }
    
    protected boolean o() {
      return (n() && this.a.repost.feed_is_delete == 1);
    }
    
    public void onClick(View param1View) {
      switch (param1View.getId()) {
        default:
          return;
        case 2131301714:
          a(this.a.feed_id);
          return;
        case 2131299980:
          L();
          return;
        case 2131299646:
          H();
          return;
        case 2131299358:
          a(false);
          return;
        case 2131299215:
          a(this.a.feed_id);
          return;
        case 2131299162:
          M();
          return;
        case 2131299146:
          K();
          return;
        case 2131298877:
          q();
          return;
        case 2131298774:
          r();
          return;
        case 2131298773:
          J();
          return;
        case 2131298695:
          a(param1View);
          return;
        case 2131297543:
        case 2131299039:
          P();
          return;
        case 2131297362:
          a(true);
          return;
        case 2131297199:
          O();
          return;
        case 2131297038:
          if (E()) {
            EventTrackFeed.a(FeedProtos.Event.FEED_DYNAMIC_SKIN_CLICK, this.a.feed_id, this.a.feed_uid, EventTrackFeed.c(this.d.c), 0);
            DynamicSkinFragment.a(this.d.a, 0, "dynamic_skin");
            return;
          } 
          return;
        case 2131297036:
        case 2131299647:
        case 2131299648:
          I();
          return;
        case 2131297032:
          break;
      } 
      G();
    }
    
    protected FeedParse p() {
      if (this.a.feedParse == null)
        this.a.feedParse = new FeedParse(this.d.a, this.a, this.d.c, FeedListAdapterForRecyclerView.f(this.d)); 
      return this.a.feedParse;
    }
    
    protected void q() {
      EventTrackFeed.b(FeedProtos.Event.CITY_SAY_HI_CLICK, this.a.feed_id, this.a.feed_uid);
      if (this.a.feed_uid != null && !UserRelationshipUtils.a(this.a.relationship)) {
        LogData logData = new LogData();
        logData.g = FeedMethods.a(this.d.c, this.a.is_vote);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("from=");
        stringBuilder.append(logData.g);
        Logger.e("logDataChat", new Object[] { stringBuilder.toString() });
        logData.b = this.a.feed_uid;
        MsgSourceEntity msgSourceEntity = new MsgSourceEntity(MessageProtos.StrangerSource.FEED_NEARBY, "");
        ChatHelperV4.a().a(this.d.a, Long.parseLong(this.a.feed_uid), this.a.user_name, this.a.user_avatar, this.a.vbadge, this.a.vip_grade, this.a.is_vip_annual, this.a.vip_exp_lvl, p().getDistance(), false, 0, this.a.is_hide_vip_look, logData, msgSourceEntity);
      } 
    }
    
    protected void r() {
      if (e()) {
        EventTrackFeed.f(FeedProtos.Event.PLAZA_RECOMMEND_NOTE_SHARE_CLICK, this.a.circle_id, this.a.feed_id);
      } else {
        InstantLog.c(FeedMethods.a(this.d.c), this.a, FeedListAdapterForRecyclerView.e(this.d), FeedListAdapterForRecyclerView.d(this.d));
      } 
      if (!UserRelationshipUtils.a(this.a.relationship)) {
        String str;
        if (this.a.feed_pics.length > 0) {
          if (this.a.feed_pics.length == 1 && this.a.is_ads != 1) {
            int i = StringUtils.a(this.a.feed_pics_width[0], 0);
            int j = StringUtils.a(this.a.feed_pics_height[0], 0);
            int k = (int)(AppInfo.l * 0.77D);
            int m = (int)(k * 0.73D);
            int[] arrayOfInt = ImageUtils.a(i, j, k, k, m, m);
            str = AvatarUtils.a(this.a.feed_pics[0], arrayOfInt[0]);
          } else {
            String str1 = this.b;
            str = str1;
            if (str1 == null)
              str = ""; 
          } 
        } else {
          str = AvatarUtils.a(0, this.a.user_avatar);
        } 
        ImageFileLoader.a(null).b(str).a(new ImageFileLoader.OnLoadFileListener(this) {
              public void onUIFinish(File param2File, Exception param2Exception) {
                String str;
                if (param2File != null && param2File.exists()) {
                  Bitmap bitmap = BitmapFactory.decodeFile(param2File.getPath());
                } else {
                  param2Exception = null;
                } 
                int i = this.a.d.c;
                if (i != 0) {
                  if (i != 6) {
                    str = "";
                  } else {
                    str = "discovery_square";
                  } 
                } else {
                  str = "discovery_attention";
                } 
                ShareUtils.a().a(this.a.d.a, this.a.c, null, (Bitmap)param2Exception, this.a.a, str, false, FeedMethods.a(this.a.d.c), FeedListAdapterForRecyclerView.e(this.a.d), FeedListAdapterForRecyclerView.d(this.a.d), this.a.d.c);
              }
            }).a();
      } 
    }
  }
  
  class null implements ImageLoader.OnAnimationStateListener {
    null(FeedListAdapterForRecyclerView this$0) {}
    
    public void a() {}
    
    public void b() {
      FeedListAdapterForRecyclerView.BaseFeedViewHolder.a(this.a).setImageDrawable(null);
    }
  }
  
  class null implements ImageLoader.OnAnimationStateListener {
    null(FeedListAdapterForRecyclerView this$0) {}
    
    public void a() {}
    
    public void b() {
      if (this.a.a.iliked != 0)
        ImageLoader.a(this.a.d.b, 2131232488).a(FeedListAdapterForRecyclerView.BaseFeedViewHolder.b(this.a)); 
    }
  }
  
  class null implements ImageFileLoader.OnLoadFileListener {
    null(FeedListAdapterForRecyclerView this$0) {}
    
    public void onUIFinish(File param1File, Exception param1Exception) {
      String str;
      if (param1File != null && param1File.exists()) {
        Bitmap bitmap = BitmapFactory.decodeFile(param1File.getPath());
      } else {
        param1Exception = null;
      } 
      int i = this.a.d.c;
      if (i != 0) {
        if (i != 6) {
          str = "";
        } else {
          str = "discovery_square";
        } 
      } else {
        str = "discovery_attention";
      } 
      ShareUtils.a().a(this.a.d.a, this.a.c, null, (Bitmap)param1Exception, this.a.a, str, false, FeedMethods.a(this.a.d.c), FeedListAdapterForRecyclerView.e(this.a.d), FeedListAdapterForRecyclerView.d(this.a.d), this.a.d.c);
    }
  }
  
  class null implements UserRelationshipUtils.IAddOrRemoveAttentionDone {
    null(FeedListAdapterForRecyclerView this$0) {}
    
    public void a() {}
    
    public void a(String param1String) {
      this.a.a.relationship = "1";
      this.a.a.forceShowFollowedStatus = true;
      AppMethods.d(2131756542);
    }
    
    public void b() {}
    
    public void b(String param1String) {}
    
    public void c() {
      FeedListAdapterForRecyclerView.BaseFeedViewHolder.c(this.a).setRelationShip("0");
    }
  }
  
  class null implements PopupWindow.OnDismissListener {
    null(FeedListAdapterForRecyclerView this$0) {}
    
    public void onDismiss() {
      FeedListAdapterForRecyclerView.BaseFeedViewHolder.d(this.a).setImageDrawable(this.a.d.a.getResources().getDrawable(2131232483));
    }
  }
  
  class null implements View.OnClickListener {
    null(FeedListAdapterForRecyclerView this$0, PopupWindow param1PopupWindow) {}
    
    public void onClick(View param1View) {
      FeedListAdapterForRecyclerView.BaseFeedViewHolder baseFeedViewHolder = this.b;
      baseFeedViewHolder.a(baseFeedViewHolder.a);
      this.a.dismiss();
      BluedADExtra bluedADExtra = new BluedADExtra();
      bluedADExtra.ads_id = Long.parseLong(this.b.a.feed_id);
      bluedADExtra.local_closed_time = System.currentTimeMillis();
      bluedADExtra.close_time = this.b.a.close_time;
      BluedPreferences.a(bluedADExtra);
      if (this.b.a.hidden_url != null && this.b.a.hidden_url.length > 0)
        for (int i = 0; i < this.b.a.hidden_url.length; i++)
          FindHttpUtils.a(this.b.a.hidden_url[i]);  
    }
  }
  
  class null implements ActionSheet.ActionSheetListener {
    null(FeedListAdapterForRecyclerView this$0, String param1String) {}
    
    public void a(ActionSheet param1ActionSheet, int param1Int) {
      Context context;
      FeedListAdapterForRecyclerView.BaseFeedViewHolder baseFeedViewHolder;
      String str = param1ActionSheet.a(param1Int);
      if (str.equals(this.b.d.a.getResources().getString(2131756176))) {
        CommonAlertDialog.a(this.b.d.a, this.b.d.a.getResources().getString(2131756094), this.b.d.a.getResources().getString(2131756395), this.b.d.a.getResources().getString(2131756394), new DialogInterface.OnClickListener(this) {
              public void onClick(DialogInterface param3DialogInterface, int param3Int) {
                FeedListAdapterForRecyclerView.BaseFeedViewHolder.a(this.a.b, this.a.b.a);
              }
            }this.b.d.a.getResources().getString(2131756462), null, null);
        return;
      } 
      if (str.equals(this.b.d.a.getResources().getString(2131758584))) {
        context = this.b.d.a;
        String str1 = this.b.a.feed_id;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(FeedListAdapterForRecyclerView.BaseFeedViewHolder.e(this.b).getText());
        stringBuilder.append("");
        ReportFragmentNew.a(context, 2, str1, stringBuilder.toString());
        return;
      } 
      if (context.equals(this.b.d.a.getResources().getString(2131756209))) {
        if (!this.b.a.isIs_unliked_users_url_visited) {
          if (this.b.a.unliked_users_url != null && this.b.a.unliked_users_url.length > 0)
            FindHttpUtils.a(this.b.a.unliked_users_url); 
          this.b.a.isIs_unliked_users_url_visited = true;
          baseFeedViewHolder = this.b;
          baseFeedViewHolder.a(baseFeedViewHolder.a);
          return;
        } 
      } else if (baseFeedViewHolder.equals(this.b.d.a.getResources().getString(2131756210))) {
        if (!this.b.a.is_unliked_url_visited) {
          if (this.b.a.unliked_url != null && this.b.a.unliked_url.length > 0)
            FindHttpUtils.a(this.b.a.unliked_url); 
          this.b.a.is_unliked_url_visited = true;
          baseFeedViewHolder = this.b;
          baseFeedViewHolder.a(baseFeedViewHolder.a);
          return;
        } 
      } else {
        if (baseFeedViewHolder.equals(this.b.d.a.getResources().getString(2131756052))) {
          FeedMethods.b((FragmentActivity)this.b.d.a, this.b.a, this.b.d.b);
          return;
        } 
        if (this.b.d.a.getResources().getString(2131758909).equalsIgnoreCase((String)baseFeedViewHolder)) {
          EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_PROFILE_FEED_MORE_TOP_CLICK, this.a);
          FeedHttpUtils.a(new BluedUIHttpResponse(this) {
                public boolean onUIFailure(int param3Int, String param3String) {
                  if (param3Int == 4031201) {
                    FeedListAdapterForRecyclerView.a(this.a.b.d, true);
                    return true;
                  } 
                  return super.onUIFailure(param3Int, param3String);
                }
                
                public void onUIFinish() {
                  if (FeedListAdapterForRecyclerView.g(this.a.b.d) && this.a.b.d.a != null) {
                    PayUtils.a(this.a.b.d.a, 9, "feed_stay_top");
                    InstantLog.a("feed_stay_top_click", 0);
                    FeedListAdapterForRecyclerView.a(this.a.b.d, false);
                  } else {
                    InstantLog.a("feed_stay_top_click", 1);
                  } 
                  super.onUIFinish();
                }
                
                public void onUIUpdate(BluedEntity param3BluedEntity) {
                  AppMethods.d(2131756206);
                }
              }this.b.a.feed_id, this.b.d.b);
          return;
        } 
        if (baseFeedViewHolder.equalsIgnoreCase(this.b.d.a.getResources().getString(2131756224))) {
          EventTrackFeed.a(FeedProtos.Event.FEED_SETTING_DYNAMIC_SKIN_SETTINGS_BTN_CLICK, this.b.a.feed_id);
          DynamicSkinFragment.a(this.b.d.a, 0, "feed_dynamic_skin_setting_main");
          return;
        } 
        if (baseFeedViewHolder.equalsIgnoreCase(this.b.d.a.getResources().getString(2131755731))) {
          FeedHttpUtils.b(new BluedUIHttpResponse(this) {
                public void onUIUpdate(BluedEntity param3BluedEntity) {
                  AppMethods.d(2131756206);
                  PersonalVerifyObserver.a().b();
                }
              },  this.b.a.feed_id, this.b.d.b);
          return;
        } 
        if (this.b.d.a.getResources().getString(2131756457).equals(baseFeedViewHolder)) {
          FeedMethods.a((FragmentActivity)this.b.d.a, this.b.a, this.b.d.b);
          return;
        } 
        if (this.b.d.a.getResources().getString(2131756452).equals(baseFeedViewHolder)) {
          EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_PROFILE_FEED_MORE_EXPOSE_CLICK, this.b.a.feed_id);
          FlutterRouter.a(this.b.d.a, this.b.a.feed_id, "my_feed_more_option");
          return;
        } 
        if (this.b.d.a.getResources().getString(2131756223).equals(baseFeedViewHolder)) {
          EventTrackFeed.a(FeedProtos.Event.FEED_SETTING_DYNAMIC_SKIN_LOOK_BTN_CLICK, this.b.a.feed_id);
          DynamicSkinFragment.a(this.b.d.a, 0, "feed_dynamic_skin_look_guest");
          return;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("＋");
        stringBuilder.append(this.b.d.a.getResources().getString(2131755359));
        if (stringBuilder.toString().equals(baseFeedViewHolder))
          FeedListAdapterForRecyclerView.BaseFeedViewHolder.f(this.b); 
      } 
    }
    
    public void a(ActionSheet param1ActionSheet, boolean param1Boolean) {}
  }
  
  class null implements DialogInterface.OnClickListener {
    public void onClick(DialogInterface param1DialogInterface, int param1Int) {
      FeedListAdapterForRecyclerView.BaseFeedViewHolder.a(this.a.b, this.a.b.a);
    }
  }
  
  class null extends BluedUIHttpResponse {
    public boolean onUIFailure(int param1Int, String param1String) {
      if (param1Int == 4031201) {
        FeedListAdapterForRecyclerView.a(this.a.b.d, true);
        return true;
      } 
      return super.onUIFailure(param1Int, param1String);
    }
    
    public void onUIFinish() {
      if (FeedListAdapterForRecyclerView.g(this.a.b.d) && this.a.b.d.a != null) {
        PayUtils.a(this.a.b.d.a, 9, "feed_stay_top");
        InstantLog.a("feed_stay_top_click", 0);
        FeedListAdapterForRecyclerView.a(this.a.b.d, false);
      } else {
        InstantLog.a("feed_stay_top_click", 1);
      } 
      super.onUIFinish();
    }
    
    public void onUIUpdate(BluedEntity param1BluedEntity) {
      AppMethods.d(2131756206);
    }
  }
  
  class null extends BluedUIHttpResponse {
    public void onUIUpdate(BluedEntity param1BluedEntity) {
      AppMethods.d(2131756206);
      PersonalVerifyObserver.a().b();
    }
  }
  
  class null extends BluedUIHttpResponse<BluedEntity> {
    null(FeedListAdapterForRecyclerView this$0, BluedIngSelfFeed param1BluedIngSelfFeed) {}
    
    public void onUIFinish() {
      super.onUIFinish();
      DialogUtils.b(this.b.d.e);
    }
    
    public void onUIStart() {
      super.onUIStart();
      DialogUtils.a(this.b.d.e);
    }
    
    public void onUIUpdate(BluedEntity param1BluedEntity) {
      this.b.a(this.a);
      if (this.a.repost != null)
        LiveEventBus.get("feed_delete_repost").post(this.a.repost.feed_id); 
      AppMethods.d(2131756175);
    }
  }
  
  abstract class FeedOrCircleViewHolder extends RepostAndTextFeedViewHolder implements View.OnClickListener {
    private View f = a(2131297050);
    
    private View h = a(2131297049);
    
    private View i = a(2131297035);
    
    private ImageView j = a(2131296746);
    
    private TextView k = a(2131296749);
    
    private ImageView l = a(2131296744);
    
    private TextView m = a(2131296750);
    
    private ImageView n = a(2131296748);
    
    private CircleJoinView o = a(2131296752);
    
    private FeedOrCircleViewHolder(FeedListAdapterForRecyclerView this$0, View param1View) {
      super(param1View);
      this.o.setStyle(0);
      this.o.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
    }
    
    private void b(BluedIngSelfFeed param1BluedIngSelfFeed, boolean param1Boolean) {
      CirclePostDetailsFragment.a(this.e.a, param1BluedIngSelfFeed, EventTrackFeed.g(this.e.c));
    }
    
    private void u() {
      this.h.setVisibility(0);
      this.i.setVisibility(8);
    }
    
    private void v() {
      byte b;
      this.f.setVisibility(8);
      this.h.setVisibility(4);
      this.i.setVisibility(0);
      ImageLoader.a(this.e.b, this.a.cover).a(2131231281).a(5.0F).a(this.j);
      this.k.setText(this.a.circle_title);
      ImageView imageView = this.l;
      if (this.a.is_anonym == 1) {
        b = 0;
      } else {
        b = 8;
      } 
      imageView.setVisibility(b);
      if (k())
        if (this.a.isNotMember()) {
          this.m.setVisibility(0);
          TextView textView = this.m;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(this.a.members_num);
          stringBuilder.append(this.e.a.getString(2131757871));
          textView.setText(stringBuilder.toString());
        } else {
          this.m.setVisibility(0);
          this.m.setText(2131755883);
        }  
      if (g()) {
        this.n.setVisibility(8);
      } else {
        this.n.setVisibility(0);
      } 
      this.j.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
      this.k.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
      this.n.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
      w();
    }
    
    private void w() {
      if (this.a.isNotMember() && k()) {
        this.o.setVisibility(0);
        this.o.setJoinStatus(this.a.getJoinState());
        return;
      } 
      this.o.setVisibility(8);
    }
    
    private void x() {
      CircleDetailsFragment.a(this.e.a, this.a.circle_id, this.e.c);
    }
    
    private void y() {
      boolean bool;
      FragmentManager fragmentManager;
      FeedProtos.Event event = FeedProtos.Event.CIRCLE_JOIN_BTN_CLICK;
      String str1 = this.a.circle_id;
      String str2 = this.a.feed_id;
      FeedProtos.CircleSource circleSource = EventTrackFeed.h(this.e.c);
      if (this.a.allow_join == 0) {
        bool = true;
      } else {
        bool = false;
      } 
      EventTrackFeed.a(event, str1, str2, circleSource, bool, this.a.classify_id);
      if (this.a.is_applied == 1) {
        AppMethods.d(2131755859);
        return;
      } 
      event = null;
      if (this.e.a instanceof AppCompatActivity)
        fragmentManager = ((AppCompatActivity)this.e.a).getSupportFragmentManager(); 
      CircleMethods.joinCircle(this.e.a, new CircleMethods.JoinViewChangeListener(this) {
            public void joinViewChange(CircleJoinState param2CircleJoinState) {
              this.a.a.setJoinState(param2CircleJoinState);
              FeedListAdapterForRecyclerView.FeedOrCircleViewHolder.b(this.a).setJoinStatus(this.a.a.getJoinState());
              if (this.a.a.isMember())
                FeedListAdapterForRecyclerView.FeedOrCircleViewHolder.c(this.a); 
            }
          },  this.a.getJoinState(), this.e.b, fragmentManager, false, true);
    }
    
    private void z() {
      AppInfo.n().postDelayed(new Runnable(this) {
            public void run() {
              FeedListAdapterForRecyclerView.FeedOrCircleViewHolder.b(this.a).setVisibility(8);
              if (this.a.k())
                FeedListAdapterForRecyclerView.FeedOrCircleViewHolder.d(this.a).setText(2131755883); 
            }
          },  1000L);
    }
    
    public void a(BluedIngSelfFeed param1BluedIngSelfFeed, int param1Int) {
      super.a(param1BluedIngSelfFeed, param1Int);
      if (e()) {
        v();
        return;
      } 
      u();
    }
    
    protected void a(BluedIngSelfFeed param1BluedIngSelfFeed, boolean param1Boolean) {
      if (e()) {
        b(param1BluedIngSelfFeed, param1Boolean);
        return;
      } 
      super.a(param1BluedIngSelfFeed, param1Boolean);
    }
    
    protected boolean c() {
      return e() ? true : super.c();
    }
    
    protected boolean d() {
      return e() ? false : super.d();
    }
    
    protected boolean e() {
      return CircleMethods.isCircle(this.a);
    }
    
    protected void f() {
      if (e()) {
        if (!this.a.isShowUrlVisited) {
          boolean bool1;
          boolean bool2;
          boolean bool3;
          FeedProtos.Event event = FeedProtos.Event.CIRCLE_NOTE_DRAW;
          String str1 = this.a.circle_id;
          String str2 = this.a.feed_id;
          FeedProtos.NoteSource noteSource = EventTrackFeed.g(this.e.c);
          if (this.a.is_top == 1) {
            bool1 = true;
          } else {
            bool1 = false;
          } 
          FeedProtos.NoteType noteType = EventTrackFeed.b(this.a);
          String str3 = this.a.note_from;
          if (this.a.is_anonym == 1) {
            bool2 = true;
          } else {
            bool2 = false;
          } 
          if (this.a.is_essence == 1) {
            bool3 = true;
          } else {
            bool3 = false;
          } 
          EventTrackFeed.a(event, str1, str2, noteSource, bool1, noteType, str3, bool2, bool3, MarkDownLinkHelper.a(this.a.feed_pure_content));
          this.a.isShowUrlVisited = true;
          return;
        } 
      } else {
        super.f();
      } 
    }
    
    public void onClick(View param1View) {
      super.onClick(param1View);
      switch (param1View.getId()) {
        default:
          return;
        case 2131296752:
          y();
          return;
        case 2131296748:
          EventTrackFeed.a(FeedProtos.Event.NOTE_MORE_BTN_CLICK, this.a.circle_id, this.a.feed_id, EventTrackFeed.g(this.e.c));
          s();
          return;
        case 2131296746:
        case 2131296749:
          break;
      } 
      x();
    }
    
    protected void r() {
      if (e()) {
        if (!UserRelationshipUtils.a(this.a.relationship)) {
          ShareUtils.a().a(this.e.a, this.a, this.e.c);
          return;
        } 
      } else {
        super.r();
      } 
    }
    
    protected void s() {
      ArrayList<String> arrayList = new ArrayList();
      if (k()) {
        arrayList.add(this.e.a.getResources().getString(2131755869));
      } else if (l() && this.a.isNotMember()) {
        if (this.a.allow_join == 1) {
          arrayList.add(this.e.a.getResources().getString(2131755878));
        } else {
          arrayList.add(this.e.a.getResources().getString(2131755846));
        } 
      } 
      arrayList.add(this.e.a.getResources().getString(2131758584));
      CommonShowBottomWindow.a((FragmentActivity)this.e.a, arrayList.<String>toArray(new String[arrayList.size()]), new ActionSheet.ActionSheetListener(this) {
            public void a(ActionSheet param2ActionSheet, int param2Int) {
              FeedListAdapterForRecyclerView.FeedOrCircleViewHolder feedOrCircleViewHolder;
              String str = param2ActionSheet.a(param2Int);
              if (str.equals(this.a.e.a.getResources().getString(2131755869))) {
                EventTrackFeed.f(FeedProtos.Event.NOTE_MORE_DISLIKE_CLICK, this.a.a.circle_id, this.a.a.feed_id);
                if (!this.a.a.isIs_unliked_users_url_visited) {
                  if (this.a.a.unliked_users_url != null && this.a.a.unliked_users_url.length > 0)
                    FindHttpUtils.a(this.a.a.unliked_users_url); 
                  this.a.a.isIs_unliked_users_url_visited = true;
                  feedOrCircleViewHolder = this.a;
                  feedOrCircleViewHolder.a(feedOrCircleViewHolder.a);
                  return;
                } 
              } else {
                if (feedOrCircleViewHolder.equals(this.a.e.a.getResources().getString(2131755878)) || feedOrCircleViewHolder.equals(this.a.e.a.getResources().getString(2131755846))) {
                  FeedListAdapterForRecyclerView.FeedOrCircleViewHolder.a(this.a);
                  return;
                } 
                if (feedOrCircleViewHolder.equals(this.a.e.a.getResources().getString(2131758584))) {
                  Context context = this.a.e.a;
                  String str1 = this.a.a.feed_id;
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append(this.a.a.user_name);
                  stringBuilder.append("");
                  ReportFragmentNew.a(context, 9, str1, stringBuilder.toString());
                  return;
                } 
              } 
            }
            
            public void a(ActionSheet param2ActionSheet, boolean param2Boolean) {}
          });
    }
  }
  
  class null implements ActionSheet.ActionSheetListener {
    null(FeedListAdapterForRecyclerView this$0) {}
    
    public void a(ActionSheet param1ActionSheet, int param1Int) {
      FeedListAdapterForRecyclerView.FeedOrCircleViewHolder feedOrCircleViewHolder;
      String str = param1ActionSheet.a(param1Int);
      if (str.equals(this.a.e.a.getResources().getString(2131755869))) {
        EventTrackFeed.f(FeedProtos.Event.NOTE_MORE_DISLIKE_CLICK, this.a.a.circle_id, this.a.a.feed_id);
        if (!this.a.a.isIs_unliked_users_url_visited) {
          if (this.a.a.unliked_users_url != null && this.a.a.unliked_users_url.length > 0)
            FindHttpUtils.a(this.a.a.unliked_users_url); 
          this.a.a.isIs_unliked_users_url_visited = true;
          feedOrCircleViewHolder = this.a;
          feedOrCircleViewHolder.a(feedOrCircleViewHolder.a);
          return;
        } 
      } else {
        if (feedOrCircleViewHolder.equals(this.a.e.a.getResources().getString(2131755878)) || feedOrCircleViewHolder.equals(this.a.e.a.getResources().getString(2131755846))) {
          FeedListAdapterForRecyclerView.FeedOrCircleViewHolder.a(this.a);
          return;
        } 
        if (feedOrCircleViewHolder.equals(this.a.e.a.getResources().getString(2131758584))) {
          Context context = this.a.e.a;
          String str1 = this.a.a.feed_id;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(this.a.a.user_name);
          stringBuilder.append("");
          ReportFragmentNew.a(context, 9, str1, stringBuilder.toString());
          return;
        } 
      } 
    }
    
    public void a(ActionSheet param1ActionSheet, boolean param1Boolean) {}
  }
  
  class null implements CircleMethods.JoinViewChangeListener {
    null(FeedListAdapterForRecyclerView this$0) {}
    
    public void joinViewChange(CircleJoinState param1CircleJoinState) {
      this.a.a.setJoinState(param1CircleJoinState);
      FeedListAdapterForRecyclerView.FeedOrCircleViewHolder.b(this.a).setJoinStatus(this.a.a.getJoinState());
      if (this.a.a.isMember())
        FeedListAdapterForRecyclerView.FeedOrCircleViewHolder.c(this.a); 
    }
  }
  
  class null implements Runnable {
    null(FeedListAdapterForRecyclerView this$0) {}
    
    public void run() {
      FeedListAdapterForRecyclerView.FeedOrCircleViewHolder.b(this.a).setVisibility(8);
      if (this.a.k())
        FeedListAdapterForRecyclerView.FeedOrCircleViewHolder.d(this.a).setText(2131755883); 
    }
  }
  
  class ImageOneFeedViewHolder extends FeedOrCircleViewHolder implements View.OnClickListener {
    private TextViewFixTouchForDynamic h = a(2131296838);
    
    private CardView i = a(2131296891);
    
    private ImageView j = a(2131297414);
    
    private ShapeTextView k = a(2131300102);
    
    private String l;
    
    private String m;
    
    public ImageOneFeedViewHolder(FeedListAdapterForRecyclerView this$0, View param1View) {
      super(this$0, param1View);
    }
    
    private void u() {
      BluedIngSelfFeed bluedIngSelfFeed = t();
      if (bluedIngSelfFeed.feed_pics == null || bluedIngSelfFeed.feed_pics.length <= 0) {
        this.i.setVisibility(8);
        this.j.setVisibility(8);
        ((ViewGroup.MarginLayoutParams)this.h.getLayoutParams()).bottomMargin = DensityUtils.a(this.f.a, 2.0F);
        return;
      } 
      this.i.setVisibility(0);
      this.j.setVisibility(0);
      ((ViewGroup.MarginLayoutParams)this.h.getLayoutParams()).bottomMargin = DensityUtils.a(this.f.a, 10.0F);
      try {
        if (bluedIngSelfFeed.feed_pics_width.length == 0 || bluedIngSelfFeed.feed_pics_height.length == 0) {
          bluedIngSelfFeed.feed_pics_width = new String[] { "480" };
          bluedIngSelfFeed.feed_pics_height = new String[] { "480" };
        } 
        int i = StringUtils.a(bluedIngSelfFeed.feed_pics_width[0], 0);
        int j = StringUtils.a(bluedIngSelfFeed.feed_pics_height[0], 0);
        int[] arrayOfInt = FeedMethods.a(this.f.a, i, j, this.a.isRepost());
        ViewGroup.LayoutParams layoutParams = this.j.getLayoutParams();
        layoutParams.width = arrayOfInt[0];
        boolean bool = true;
        layoutParams.height = arrayOfInt[1];
        this.j.setLayoutParams(layoutParams);
        this.l = bluedIngSelfFeed.feed_pics[0];
        String str = bluedIngSelfFeed.feed_pics[0];
        int k = layoutParams.width;
        if (i != j)
          bool = false; 
        this.m = AvatarUtils.a(str, k, bool);
        if (j > i * 3) {
          this.k.setVisibility(0);
          String str1 = bluedIngSelfFeed.getImageMogr(false);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(bluedIngSelfFeed.feed_pics[0]);
          stringBuilder.append(str1);
          this.m = stringBuilder.toString();
        } else {
          this.k.setVisibility(8);
        } 
        ImageLoader.a(this.f.b, this.m).a(FeedListAdapterForRecyclerView.h(this.f)).a(this.j);
        this.j.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
        this.b = bluedIngSelfFeed.feed_pics[0];
        if (Build.VERSION.SDK_INT >= 21) {
          this.j.setTransitionName(bluedIngSelfFeed.feed_pics[0]);
          return;
        } 
        return;
      } catch (Exception exception) {
        return;
      } 
    }
    
    private void v() {
      if (e())
        EventTrackFeed.a(FeedProtos.Event.NOTE_IMAGE_CLICK, this.a.circle_id, this.a.feed_id, EventTrackFeed.g(this.f.c)); 
      if (!UserRelationshipUtils.a((t()).relationship)) {
        Context context = this.f.a;
        String str1 = this.l;
        int i = this.f.f;
        String str2 = (t()).user_name;
        ImageView imageView = this.j;
        String str3 = this.l;
        BasePhotoFragment.a(context, new String[] { str1 }, 0, i, null, str2, (View)imageView, str3);
        LogData logData = new LogData();
        logData.n = (t()).feed_id;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f.d);
        stringBuilder.append("");
        logData.g = stringBuilder.toString();
        logData.J = "feed_pic_click";
        logData.k = (t()).recommend_text;
        if (!TextUtils.isEmpty(FeedListAdapterForRecyclerView.e(this.f)))
          logData.t = FeedListAdapterForRecyclerView.e(this.f); 
        if (FeedListAdapterForRecyclerView.d(this.f) != -1) {
          stringBuilder = new StringBuilder();
          stringBuilder.append(FeedListAdapterForRecyclerView.d(this.f));
          stringBuilder.append("");
          logData.h = stringBuilder.toString();
        } 
        InstantLog.a(logData);
      } 
    }
    
    public void a(BluedIngSelfFeed param1BluedIngSelfFeed, int param1Int) {
      super.a(param1BluedIngSelfFeed, param1Int);
      u();
      this.j.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
    }
    
    public void onClick(View param1View) {
      super.onClick(param1View);
      if (param1View.getId() != 2131297414)
        return; 
      v();
    }
  }
  
  class ImageOtherFeedViewHolder extends FeedOrCircleViewHolder implements View.OnClickListener {
    private PhotoGridView h = a(2131297415);
    
    public ImageOtherFeedViewHolder(FeedListAdapterForRecyclerView this$0, View param1View) {
      super(this$0, param1View);
    }
    
    private void u() {
      FeedListAdapterForRecyclerView.PhotoAdapter photoAdapter = new FeedListAdapterForRecyclerView.PhotoAdapter(this.f, t());
      this.h.setAdapter((ListAdapter)photoAdapter);
    }
    
    public void a(BluedIngSelfFeed param1BluedIngSelfFeed, int param1Int) {
      super.a(param1BluedIngSelfFeed, param1Int);
      u();
    }
    
    public void onClick(View param1View) {
      super.onClick(param1View);
    }
  }
  
  class ImageTwoFourFeedViewHolder extends FeedOrCircleViewHolder implements View.OnClickListener {
    private PhotoGridView h = a(2131297416);
    
    public ImageTwoFourFeedViewHolder(FeedListAdapterForRecyclerView this$0, View param1View) {
      super(this$0, param1View);
    }
    
    private void u() {
      FeedListAdapterForRecyclerView.PhotoAdapter photoAdapter = new FeedListAdapterForRecyclerView.PhotoAdapter(this.f, t());
      this.h.setAdapter((ListAdapter)photoAdapter);
    }
    
    public void a(BluedIngSelfFeed param1BluedIngSelfFeed, int param1Int) {
      super.a(param1BluedIngSelfFeed, param1Int);
      u();
    }
    
    public void onClick(View param1View) {
      super.onClick(param1View);
    }
  }
  
  class JoinCircleViewHolder extends WebFeedViewHolder {
    public JoinCircleViewHolder(FeedListAdapterForRecyclerView this$0, View param1View) {
      super(this$0, param1View);
    }
    
    public void a(BluedIngSelfFeed param1BluedIngSelfFeed, int param1Int) {
      super.a(param1BluedIngSelfFeed, param1Int);
      a(2131301689).setVisibility(8);
      this.m.setVisibility(0);
      this.o.setVisibility(0);
      this.n.setVisibility(0);
      this.m.setText((t()).join_circle_title);
      this.o.setText((t()).join_circle_description);
      TextView textView = this.n;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append((t()).members_num);
      stringBuilder.append(this.e.a.getString(2131757871));
      textView.setText(stringBuilder.toString());
    }
    
    public void s() {
      super.s();
      ImageLoader.a(this.e.b, (t()).join_circle_pic).a(2131231369).a(this.j);
      this.i.setOnClickListener(new -$$Lambda$FeedListAdapterForRecyclerView$JoinCircleViewHolder$KSVzDyqacvULiq5SfZqEP9ct9eI(this));
    }
  }
  
  public class LiveFeedViewHolder implements View.OnClickListener {
    private BluedIngSelfFeed b;
    
    private int c;
    
    private LinearLayout d;
    
    private ImageView e;
    
    private TextView f;
    
    private ImageView g;
    
    private ImageView h;
    
    private TextView i;
    
    private TextView j;
    
    private FrameLayout k;
    
    private ImageView l;
    
    private ImageView m;
    
    private TextView n;
    
    private ShapeTextView o;
    
    public LiveFeedViewHolder(FeedListAdapterForRecyclerView this$0, View param1View) {
      this.d = (LinearLayout)param1View.findViewById(2131299753);
      this.e = (ImageView)param1View.findViewById(2131297797);
      this.f = (TextView)param1View.findViewById(2131301088);
      this.g = (ImageView)param1View.findViewById(2131297528);
      this.h = (ImageView)param1View.findViewById(2131297447);
      this.i = (TextView)param1View.findViewById(2131300704);
      this.j = (TextView)param1View.findViewById(2131300663);
      this.k = (FrameLayout)param1View.findViewById(2131297100);
      this.l = (ImageView)param1View.findViewById(2131297734);
      this.m = (ImageView)param1View.findViewById(2131297831);
      this.n = (TextView)param1View.findViewById(2131300670);
      this.o = (ShapeTextView)param1View.findViewById(2131301417);
    }
    
    private void a() {
      this.d.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
      ImageLoader.a(this.a.b, AvatarUtils.a(0, this.b.user_avatar)).a(2131234356).c().a(this.e);
      this.f.setText(this.b.user_name);
      UserBasicModel userBasicModel = new UserBasicModel();
      userBasicModel.vip_grade = this.b.vip_grade;
      userBasicModel.is_vip_annual = this.b.is_vip_annual;
      userBasicModel.is_hide_vip_look = this.b.is_hide_vip_look;
      userBasicModel.vip_exp_lvl = this.b.vip_exp_lvl;
      UserRelationshipUtils.a(this.a.a, this.f, userBasicModel);
      UserRelationshipUtils.a(this.h, userBasicModel);
      UserRelationshipUtils.b(this.g, this.b.vbadge, 2, 8);
      this.e.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
      this.f.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
      if (!TextUtils.isEmpty(this.b.distance)) {
        String str = DistanceUtils.a(this.b.distance, BlueAppLocal.c(), false);
        this.i.setText(str);
        DistanceUtils.a(this.a.a, this.i, this.b.is_hide_distance, 0);
        TextView textView1 = this.i;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(this.i.getText().toString());
        stringBuilder1.append(" ");
        stringBuilder1.append(this.a.a.getString(2131756409));
        textView1.setText(stringBuilder1.toString());
      } else {
        this.i.setText(2131756409);
      } 
      if (!TextUtils.isEmpty(this.b.feed_content)) {
        this.j.setVisibility(0);
        this.j.setText(this.b.feed_content);
      } else {
        this.j.setVisibility(8);
      } 
      if (this.b.feed_pics == null || this.b.feed_pics.length <= 0) {
        this.k.setVisibility(8);
        this.l.setVisibility(8);
      } else {
        this.k.setVisibility(0);
        this.l.setVisibility(0);
        this.l.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
        try {
          if (this.b.feed_pics_width.length == 0 || this.b.feed_pics_height.length == 0) {
            this.b.feed_pics_width = new String[] { "480" };
            this.b.feed_pics_height = new String[] { "480" };
          } 
          int j = StringUtils.a(this.b.feed_pics_width[0], 0);
          int k = StringUtils.a(this.b.feed_pics_height[0], 0);
          int[] arrayOfInt = FeedMethods.a(this.a.a, j, k, false);
          ViewGroup.LayoutParams layoutParams = this.l.getLayoutParams();
          layoutParams.width = arrayOfInt[0];
          layoutParams.height = arrayOfInt[1];
          String str = AvatarUtils.a(this.b.feed_pics[0], layoutParams.width);
          ImageLoader.a(this.a.b, str).a(FeedListAdapterForRecyclerView.h(this.a)).a(this.l);
          this.l.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
          if (Build.VERSION.SDK_INT >= 21)
            this.l.setTransitionName(this.b.feed_pics[0]); 
        } catch (Exception exception) {
          this.k.setVisibility(8);
          this.l.setVisibility(8);
        } 
      } 
      int i = this.b.link_type;
      if (i != 1) {
        if (i != 2) {
          if (i != 3) {
            this.m.setImageResource(2131232573);
          } else {
            this.m.setImageResource(2131232551);
          } 
        } else {
          this.m.setImageResource(2131232555);
        } 
      } else {
        this.m.setImageResource(2131232565);
      } 
      TextView textView = this.n;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.b.realtime_count);
      stringBuilder.append(this.a.a.getString(2131756410));
      textView.setText(stringBuilder.toString());
      this.o.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
      if (!this.b.isShowUrlVisited) {
        EventTrackFeed.a(FeedProtos.Event.CITY_LIVE_USER_SHOW, this.b.uid, this.b.lid);
        this.b.isShowUrlVisited = true;
      } 
    }
    
    public void a(BluedIngSelfFeed param1BluedIngSelfFeed, int param1Int) {
      this.b = param1BluedIngSelfFeed;
      this.c = param1Int;
      a();
    }
    
    public void onClick(View param1View) {
      String str;
      UserBasicModel userBasicModel;
      switch (param1View.getId()) {
        default:
          return;
        case 2131297797:
        case 2131301088:
          str = FeedMethods.a(this.a.c, this.b.is_vote);
          userBasicModel = new UserBasicModel();
          userBasicModel.uid = this.b.uid;
          userBasicModel.name = this.b.user_name;
          userBasicModel.avatar = this.b.user_avatar;
          userBasicModel.is_show_vip_page = this.b.is_show_vip_page;
          UserInfoFragmentNew.a(this.a.a, userBasicModel, str, (View)this.e);
          if (this.b.click_url != null && this.b.click_url.length > 0)
            for (int i = 0; i < this.b.click_url.length; i++)
              FindHttpUtils.a(this.b.click_url[i]);  
          return;
        case 2131297734:
        case 2131299753:
        case 2131301417:
          break;
      } 
      EventTrackFeed.a(FeedProtos.Event.CITY_LIVE_USER_CLICK, this.b.uid, this.b.lid);
      LiveRoomData liveRoomData = new LiveRoomData(Long.parseLong(this.b.lid), 0, "", this.b.uid, this.b.user_name, this.b.user_avatar, this.b.vbadge);
      LiveRoomInfoChannel.a(this.a.a, liveRoomData);
    }
  }
  
  public class PhotoAdapter extends BaseAdapter {
    private BluedIngSelfFeed b;
    
    public PhotoAdapter(FeedListAdapterForRecyclerView this$0, BluedIngSelfFeed param1BluedIngSelfFeed) {
      this.b = param1BluedIngSelfFeed;
    }
    
    public int getCount() {
      return this.b.feed_pics.length;
    }
    
    public Object getItem(int param1Int) {
      return Integer.valueOf(param1Int);
    }
    
    public long getItemId(int param1Int) {
      return param1Int;
    }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      // Byte code:
      //   0: aload_2
      //   1: ifnonnull -> 65
      //   4: aload_0
      //   5: getfield a : Lcom/soft/blued/ui/feed/adapter/FeedListAdapterForRecyclerView;
      //   8: getfield a : Landroid/content/Context;
      //   11: invokestatic from : (Landroid/content/Context;)Landroid/view/LayoutInflater;
      //   14: ldc 2131493122
      //   16: aconst_null
      //   17: invokevirtual inflate : (ILandroid/view/ViewGroup;)Landroid/view/View;
      //   20: astore_2
      //   21: new com/soft/blued/ui/feed/adapter/FeedListAdapterForRecyclerView$PhotoAdapter$ViewHolder
      //   24: dup
      //   25: aload_0
      //   26: aconst_null
      //   27: invokespecial <init> : (Lcom/soft/blued/ui/feed/adapter/FeedListAdapterForRecyclerView$PhotoAdapter;Lcom/soft/blued/ui/feed/adapter/FeedListAdapterForRecyclerView$1;)V
      //   30: astore_3
      //   31: aload_3
      //   32: aload_2
      //   33: ldc 2131299472
      //   35: invokevirtual findViewById : (I)Landroid/view/View;
      //   38: checkcast android/widget/ImageView
      //   41: putfield a : Landroid/widget/ImageView;
      //   44: aload_3
      //   45: aload_2
      //   46: ldc 2131300102
      //   48: invokevirtual findViewById : (I)Landroid/view/View;
      //   51: checkcast com/blued/android/framework/view/shape/ShapeTextView
      //   54: putfield b : Lcom/blued/android/framework/view/shape/ShapeTextView;
      //   57: aload_2
      //   58: aload_3
      //   59: invokevirtual setTag : (Ljava/lang/Object;)V
      //   62: goto -> 73
      //   65: aload_2
      //   66: invokevirtual getTag : ()Ljava/lang/Object;
      //   69: checkcast com/soft/blued/ui/feed/adapter/FeedListAdapterForRecyclerView$PhotoAdapter$ViewHolder
      //   72: astore_3
      //   73: aload_0
      //   74: getfield b : Lcom/soft/blued/ui/feed/model/BluedIngSelfFeed;
      //   77: getfield feed_pics : [Ljava/lang/String;
      //   80: iload_1
      //   81: aaload
      //   82: astore #9
      //   84: aload_0
      //   85: getfield b : Lcom/soft/blued/ui/feed/model/BluedIngSelfFeed;
      //   88: getfield feed_pics : [Ljava/lang/String;
      //   91: iload_1
      //   92: aaload
      //   93: astore #8
      //   95: aload_0
      //   96: getfield b : Lcom/soft/blued/ui/feed/model/BluedIngSelfFeed;
      //   99: getfield feed_pics_width : [Ljava/lang/String;
      //   102: ifnull -> 176
      //   105: aload_0
      //   106: getfield b : Lcom/soft/blued/ui/feed/model/BluedIngSelfFeed;
      //   109: getfield feed_pics_width : [Ljava/lang/String;
      //   112: arraylength
      //   113: iload_1
      //   114: if_icmple -> 176
      //   117: aload_0
      //   118: getfield b : Lcom/soft/blued/ui/feed/model/BluedIngSelfFeed;
      //   121: getfield feed_pics_height : [Ljava/lang/String;
      //   124: ifnull -> 176
      //   127: aload_0
      //   128: getfield b : Lcom/soft/blued/ui/feed/model/BluedIngSelfFeed;
      //   131: getfield feed_pics_height : [Ljava/lang/String;
      //   134: arraylength
      //   135: iload_1
      //   136: if_icmple -> 176
      //   139: aload_0
      //   140: getfield b : Lcom/soft/blued/ui/feed/model/BluedIngSelfFeed;
      //   143: getfield feed_pics_width : [Ljava/lang/String;
      //   146: iload_1
      //   147: aaload
      //   148: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Integer;
      //   151: invokevirtual intValue : ()I
      //   154: istore #6
      //   156: aload_0
      //   157: getfield b : Lcom/soft/blued/ui/feed/model/BluedIngSelfFeed;
      //   160: getfield feed_pics_height : [Ljava/lang/String;
      //   163: iload_1
      //   164: aaload
      //   165: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Integer;
      //   168: invokevirtual intValue : ()I
      //   171: istore #7
      //   173: goto -> 182
      //   176: iconst_0
      //   177: istore #6
      //   179: iconst_0
      //   180: istore #7
      //   182: iload #7
      //   184: iload #6
      //   186: iconst_3
      //   187: imul
      //   188: if_icmple -> 245
      //   191: aload_3
      //   192: getfield b : Lcom/blued/android/framework/view/shape/ShapeTextView;
      //   195: iconst_0
      //   196: invokevirtual setVisibility : (I)V
      //   199: aload_0
      //   200: getfield b : Lcom/soft/blued/ui/feed/model/BluedIngSelfFeed;
      //   203: iconst_1
      //   204: iload_1
      //   205: invokevirtual getImageMogr : (ZI)Ljava/lang/String;
      //   208: astore #10
      //   210: new java/lang/StringBuilder
      //   213: dup
      //   214: invokespecial <init> : ()V
      //   217: astore #11
      //   219: aload #11
      //   221: aload #8
      //   223: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   226: pop
      //   227: aload #11
      //   229: aload #10
      //   231: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   234: pop
      //   235: aload #11
      //   237: invokevirtual toString : ()Ljava/lang/String;
      //   240: astore #8
      //   242: goto -> 254
      //   245: aload_3
      //   246: getfield b : Lcom/blued/android/framework/view/shape/ShapeTextView;
      //   249: bipush #8
      //   251: invokevirtual setVisibility : (I)V
      //   254: aload_0
      //   255: getfield b : Lcom/soft/blued/ui/feed/model/BluedIngSelfFeed;
      //   258: getfield face_point : [Ljava/lang/String;
      //   261: astore #10
      //   263: ldc -1.0
      //   265: fstore #5
      //   267: aload #10
      //   269: ifnull -> 334
      //   272: aload_0
      //   273: getfield b : Lcom/soft/blued/ui/feed/model/BluedIngSelfFeed;
      //   276: getfield face_point : [Ljava/lang/String;
      //   279: arraylength
      //   280: iload_1
      //   281: if_icmple -> 334
      //   284: aload_0
      //   285: getfield b : Lcom/soft/blued/ui/feed/model/BluedIngSelfFeed;
      //   288: getfield face_point : [Ljava/lang/String;
      //   291: iload_1
      //   292: aaload
      //   293: ldc ','
      //   295: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
      //   298: astore #10
      //   300: aload #10
      //   302: arraylength
      //   303: iconst_2
      //   304: if_icmpne -> 334
      //   307: aload #10
      //   309: iconst_0
      //   310: aaload
      //   311: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Float;
      //   314: invokevirtual floatValue : ()F
      //   317: fstore #5
      //   319: aload #10
      //   321: iconst_1
      //   322: aaload
      //   323: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Float;
      //   326: invokevirtual floatValue : ()F
      //   329: fstore #4
      //   331: goto -> 338
      //   334: ldc -1.0
      //   336: fstore #4
      //   338: aload_0
      //   339: getfield a : Lcom/soft/blued/ui/feed/adapter/FeedListAdapterForRecyclerView;
      //   342: getfield b : Lcom/blued/android/core/net/IRequestHost;
      //   345: aload #8
      //   347: invokestatic a : (Lcom/blued/android/core/net/IRequestHost;Ljava/lang/String;)Lcom/blued/android/core/image/ImageWrapper;
      //   350: ldc 2131100257
      //   352: invokevirtual a : (I)Lcom/blued/android/core/image/ImageWrapper;
      //   355: ldc 6.0
      //   357: invokevirtual a : (F)Lcom/blued/android/core/image/ImageWrapper;
      //   360: fload #5
      //   362: fload #4
      //   364: invokevirtual a : (FF)Lcom/blued/android/core/image/ImageWrapper;
      //   367: aload_3
      //   368: getfield a : Landroid/widget/ImageView;
      //   371: invokevirtual a : (Landroid/widget/ImageView;)V
      //   374: aload_3
      //   375: getfield a : Landroid/widget/ImageView;
      //   378: new com/soft/blued/utils/click/SingleClickProxy
      //   381: dup
      //   382: new com/soft/blued/ui/feed/adapter/FeedListAdapterForRecyclerView$PhotoAdapter$1
      //   385: dup
      //   386: aload_0
      //   387: iload_1
      //   388: aload_3
      //   389: aload #9
      //   391: invokespecial <init> : (Lcom/soft/blued/ui/feed/adapter/FeedListAdapterForRecyclerView$PhotoAdapter;ILcom/soft/blued/ui/feed/adapter/FeedListAdapterForRecyclerView$PhotoAdapter$ViewHolder;Ljava/lang/String;)V
      //   394: invokespecial <init> : (Landroid/view/View$OnClickListener;)V
      //   397: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
      //   400: getstatic android/os/Build$VERSION.SDK_INT : I
      //   403: bipush #21
      //   405: if_icmplt -> 417
      //   408: aload_3
      //   409: getfield a : Landroid/widget/ImageView;
      //   412: aload #9
      //   414: invokevirtual setTransitionName : (Ljava/lang/String;)V
      //   417: aload_2
      //   418: areturn
    }
    
    class ViewHolder {
      ImageView a;
      
      ShapeTextView b;
      
      private ViewHolder(FeedListAdapterForRecyclerView.PhotoAdapter this$0) {}
    }
  }
  
  class null implements View.OnClickListener {
    null(FeedListAdapterForRecyclerView this$0, int param1Int, FeedListAdapterForRecyclerView.PhotoAdapter.ViewHolder param1ViewHolder, String param1String) {}
    
    public void onClick(View param1View) {
      if (CircleMethods.isCircle(FeedListAdapterForRecyclerView.PhotoAdapter.a(this.d))) {
        EventTrackFeed.a(FeedProtos.Event.NOTE_IMAGE_CLICK, (FeedListAdapterForRecyclerView.PhotoAdapter.a(this.d)).circle_id, (FeedListAdapterForRecyclerView.PhotoAdapter.a(this.d)).feed_id, EventTrackFeed.g(this.d.a.c));
      } else {
        EventTrackFeed.a(FeedProtos.Event.FEED_MULTI_IMAGE_CLICK, (FeedListAdapterForRecyclerView.PhotoAdapter.a(this.d)).feed_id);
      } 
      if (!UserRelationshipUtils.a((FeedListAdapterForRecyclerView.PhotoAdapter.a(this.d)).relationship)) {
        LogData logData = new LogData();
        logData.n = (FeedListAdapterForRecyclerView.PhotoAdapter.a(this.d)).feed_id;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.d.a.d);
        stringBuilder.append("");
        logData.g = stringBuilder.toString();
        logData.J = "feed_pic_click";
        if (!TextUtils.isEmpty(FeedListAdapterForRecyclerView.e(this.d.a)))
          logData.t = FeedListAdapterForRecyclerView.e(this.d.a); 
        if (FeedListAdapterForRecyclerView.d(this.d.a) != -1) {
          stringBuilder = new StringBuilder();
          stringBuilder.append(FeedListAdapterForRecyclerView.d(this.d.a));
          stringBuilder.append("");
          logData.h = stringBuilder.toString();
        } 
        logData.k = (FeedListAdapterForRecyclerView.PhotoAdapter.a(this.d)).recommend_text;
        InstantLog.a(logData);
        BasePhotoFragment.a(this.d.a.a, (FeedListAdapterForRecyclerView.PhotoAdapter.a(this.d)).feed_pics, this.a, this.d.a.f, null, (FeedListAdapterForRecyclerView.PhotoAdapter.a(this.d)).user_name, (View)this.b.a, this.c);
      } 
    }
  }
  
  class ViewHolder {
    ImageView a;
    
    ShapeTextView b;
    
    private ViewHolder(FeedListAdapterForRecyclerView this$0) {}
  }
  
  class RecommendCircleViewHolder {
    private BluedIngSelfFeed b;
    
    private int c;
    
    private TextView d;
    
    private ImageView e;
    
    private RecyclerView f;
    
    public RecommendCircleViewHolder(FeedListAdapterForRecyclerView this$0, View param1View) {
      this.d = (TextView)param1View.findViewById(2131301050);
      this.e = (ImageView)param1View.findViewById(2131297863);
      this.f = (RecyclerView)param1View.findViewById(2131299605);
      LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, this$0.a, this$0) {
          public boolean canScrollVertically() {
            return false;
          }
        };
      this.f.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    }
    
    private void a() {
      SingleClickProxy singleClickProxy = new SingleClickProxy(new View.OnClickListener(this) {
            public void onClick(View param2View) {
              EventTrackFeed.a(FeedProtos.Event.CIRCLE_FIND_PAGE_SHOW, FeedProtos.CircleSource.PLAZA_RECOMMEND_CIRCLE);
              CircleTypeListFragment.e.a(this.a.a.a, CircleConstants.CIRCLE_FROM_PAGE.EXPLORE_MORE, CircleConstants.CIRCLE_FROM_PAGE.FEED_PLAZA_RECOMMEND_MORE);
            }
          });
      this.d.setOnClickListener((View.OnClickListener)singleClickProxy);
      this.e.setOnClickListener((View.OnClickListener)singleClickProxy);
    }
    
    private void b() {
      if (this.f.getAdapter() == null && this.a.w != null) {
        this.f.setAdapter((RecyclerView.Adapter)this.a.w);
        this.a.w.notifyDataSetChanged();
        this.a.w.c(false);
      } 
    }
    
    public void a(BluedIngSelfFeed param1BluedIngSelfFeed, int param1Int) {
      this.b = param1BluedIngSelfFeed;
      this.c = param1Int;
      a();
      b();
    }
  }
  
  class null extends LinearLayoutManager {
    null(FeedListAdapterForRecyclerView this$0, Context param1Context, FeedListAdapterForRecyclerView param1FeedListAdapterForRecyclerView) {
      super(param1Context);
    }
    
    public boolean canScrollVertically() {
      return false;
    }
  }
  
  class null implements View.OnClickListener {
    null(FeedListAdapterForRecyclerView this$0) {}
    
    public void onClick(View param1View) {
      EventTrackFeed.a(FeedProtos.Event.CIRCLE_FIND_PAGE_SHOW, FeedProtos.CircleSource.PLAZA_RECOMMEND_CIRCLE);
      CircleTypeListFragment.e.a(this.a.a.a, CircleConstants.CIRCLE_FROM_PAGE.EXPLORE_MORE, CircleConstants.CIRCLE_FROM_PAGE.FEED_PLAZA_RECOMMEND_MORE);
    }
  }
  
  class RecommendTopicViewHolder {
    private BluedIngSelfFeed b;
    
    private int c;
    
    private TextView d;
    
    private ImageView e;
    
    private RecyclerView f;
    
    public RecommendTopicViewHolder(FeedListAdapterForRecyclerView this$0, View param1View) {
      this.d = (TextView)param1View.findViewById(2131301050);
      this.e = (ImageView)param1View.findViewById(2131297863);
      this.f = (RecyclerView)param1View.findViewById(2131299605);
      LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this$0.a);
      linearLayoutManager.setOrientation(0);
      this.f.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    }
    
    private void a() {
      SingleClickProxy singleClickProxy = new SingleClickProxy(new View.OnClickListener(this) {
            public void onClick(View param2View) {
              EventTrackFeed.a(FeedProtos.Event.FIND_PLAZA_RECOMMEND_SUPER_TOPIC_MORE_CLICK);
              SuperTopicFragment.a(this.a.a.a);
            }
          });
      this.d.setOnClickListener((View.OnClickListener)singleClickProxy);
      this.e.setOnClickListener((View.OnClickListener)singleClickProxy);
    }
    
    private void b() {
      if (this.f.getAdapter() == null && this.a.v != null) {
        this.f.setAdapter((RecyclerView.Adapter)this.a.v);
        this.a.v.notifyDataSetChanged();
        this.a.v.c(false);
      } 
    }
    
    public void a(BluedIngSelfFeed param1BluedIngSelfFeed, int param1Int) {
      this.b = param1BluedIngSelfFeed;
      this.c = param1Int;
      a();
      b();
    }
  }
  
  class null implements View.OnClickListener {
    null(FeedListAdapterForRecyclerView this$0) {}
    
    public void onClick(View param1View) {
      EventTrackFeed.a(FeedProtos.Event.FIND_PLAZA_RECOMMEND_SUPER_TOPIC_MORE_CLICK);
      SuperTopicFragment.a(this.a.a.a);
    }
  }
  
  class RecommendUserFeedViewHolder {
    private BluedIngSelfFeed b;
    
    private int c;
    
    private RecyclerView d;
    
    public RecommendUserFeedViewHolder(FeedListAdapterForRecyclerView this$0, View param1View) {
      this.d = (RecyclerView)param1View.findViewById(2131299605);
      LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this$0.a);
      linearLayoutManager.setOrientation(0);
      this.d.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    }
    
    private void a() {
      if (this.d.getAdapter() == null) {
        this.d.setAdapter((RecyclerView.Adapter)this.a.u);
        this.a.u.notifyDataSetChanged();
        this.a.u.a((LoadMoreView)new RecommendLoadMoreView());
        this.a.u.a(new BaseQuickAdapter.RequestLoadMoreListener(this) {
              public void onLoadMoreRequested() {
                if (this.a.a.t == 1) {
                  FeedListAdapterForRecyclerView.RecommendUserFeedViewHolder recommendUserFeedViewHolder = this.a;
                  FeedListAdapterForRecyclerView.RecommendUserFeedViewHolder.a(recommendUserFeedViewHolder, FeedListAdapterForRecyclerView.RecommendUserFeedViewHolder.a(recommendUserFeedViewHolder));
                } 
              }
            }this.d);
      } 
    }
    
    private void a(BluedIngSelfFeed param1BluedIngSelfFeed) {
      LiveHttpUtils.a(this.a.q, this.a.r, this.a.s, this.a.b, new BluedUIHttpResponse<BluedEntity<FeedRecommendUser, LiveRecommendExtra>>(this, param1BluedIngSelfFeed) {
            public void onUIFinish() {
              super.onUIFinish();
              this.b.a.u.l();
              if (this.b.a.t != 1) {
                this.b.a.u.b(true);
                this.b.a.u.c(false);
              } 
            }
            
            public void onUIUpdate(BluedEntity<FeedRecommendUser, LiveRecommendExtra> param2BluedEntity) {
              if (param2BluedEntity != null && param2BluedEntity.extra != null) {
                this.b.a.u.a(param2BluedEntity.data);
                this.b.a.u.notifyDataSetChanged();
                this.b.a.t = ((LiveRecommendExtra)param2BluedEntity.extra).hasmore;
                this.b.a.q = ((LiveRecommendExtra)param2BluedEntity.extra).last_lid;
                this.b.a.r = ((LiveRecommendExtra)param2BluedEntity.extra).ai_last_uid;
                this.b.a.s = ((LiveRecommendExtra)param2BluedEntity.extra).recommend_char;
                if (this.b.a.u.getItemCount() <= 3) {
                  FeedListAdapterForRecyclerView.i(this.b.a).remove(this.a);
                  this.b.a.notifyDataSetChanged();
                } 
              } 
            }
          });
    }
    
    public void a(BluedIngSelfFeed param1BluedIngSelfFeed, int param1Int) {
      this.b = param1BluedIngSelfFeed;
      this.c = param1Int;
      a();
    }
  }
  
  class null implements BaseQuickAdapter.RequestLoadMoreListener {
    null(FeedListAdapterForRecyclerView this$0) {}
    
    public void onLoadMoreRequested() {
      if (this.a.a.t == 1) {
        FeedListAdapterForRecyclerView.RecommendUserFeedViewHolder recommendUserFeedViewHolder = this.a;
        FeedListAdapterForRecyclerView.RecommendUserFeedViewHolder.a(recommendUserFeedViewHolder, FeedListAdapterForRecyclerView.RecommendUserFeedViewHolder.a(recommendUserFeedViewHolder));
      } 
    }
  }
  
  class null extends BluedUIHttpResponse<BluedEntity<FeedRecommendUser, LiveRecommendExtra>> {
    null(FeedListAdapterForRecyclerView this$0, BluedIngSelfFeed param1BluedIngSelfFeed) {}
    
    public void onUIFinish() {
      super.onUIFinish();
      this.b.a.u.l();
      if (this.b.a.t != 1) {
        this.b.a.u.b(true);
        this.b.a.u.c(false);
      } 
    }
    
    public void onUIUpdate(BluedEntity<FeedRecommendUser, LiveRecommendExtra> param1BluedEntity) {
      if (param1BluedEntity != null && param1BluedEntity.extra != null) {
        this.b.a.u.a(param1BluedEntity.data);
        this.b.a.u.notifyDataSetChanged();
        this.b.a.t = ((LiveRecommendExtra)param1BluedEntity.extra).hasmore;
        this.b.a.q = ((LiveRecommendExtra)param1BluedEntity.extra).last_lid;
        this.b.a.r = ((LiveRecommendExtra)param1BluedEntity.extra).ai_last_uid;
        this.b.a.s = ((LiveRecommendExtra)param1BluedEntity.extra).recommend_char;
        if (this.b.a.u.getItemCount() <= 3) {
          FeedListAdapterForRecyclerView.i(this.b.a).remove(this.a);
          this.b.a.notifyDataSetChanged();
        } 
      } 
    }
  }
  
  abstract class RepostAndTextFeedViewHolder extends BaseFeedViewHolder implements View.OnClickListener {
    private LinearLayout e = a(2131297040);
    
    private TextViewFixTouchForDynamic f = a(2131299649);
    
    private ShapeLinearLayout h = a(2131298759);
    
    private TextViewFixTouchForDynamic i = a(2131296838);
    
    private RelativeLayout j = a(2131299650);
    
    private RepostAndTextFeedViewHolder(FeedListAdapterForRecyclerView this$0, View param1View) {
      super(param1View);
      this.j.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
    }
    
    private void a(View param1View, TextViewFixTouchForDynamic param1TextViewFixTouchForDynamic, CharSequence param1CharSequence) {
      param1TextViewFixTouchForDynamic.setMaxLines(5);
      param1TextViewFixTouchForDynamic.setExpandText(param1CharSequence);
      param1TextViewFixTouchForDynamic.setMovementMethod((MovementMethod)LinkMovementClickMethod.a());
      param1View.setOnLongClickListener(new View.OnLongClickListener(this, param1TextViewFixTouchForDynamic) {
            public boolean onLongClick(View param2View) {
              String str = this.a.getText().toString();
              if (Build.VERSION.SDK_INT >= 11 && Build.VERSION.SDK_INT != 18) {
                ((ClipboardManager)this.b.g.a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("simple text", RegExpUtils.a(str)));
              } else {
                ((ClipboardManager)this.b.g.a.getSystemService("clipboard")).setText(RegExpUtils.a(str));
              } 
              AppMethods.a(this.b.g.a.getResources().getString(2131756130));
              return true;
            }
          });
    }
    
    private void s() {
      this.f.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
      this.h.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
    }
    
    private void u() {
      int i = AppInfo.l;
      if (n()) {
        this.f.setMaxWidth(i - DensityUtils.a(this.g.a, 20.0F));
        this.i.setMaxWidth(i - DensityUtils.a(this.g.a, 40.0F));
        a((View)this.j, this.f, p().getFeedRepostContent());
        this.i.setVisibility(0);
        a((View)this.h, this.i, p().getFeedContent());
        return;
      } 
      this.i.setMaxWidth(i - DensityUtils.a(this.g.a, 20.0F));
      if (!TextUtils.isEmpty((t()).feed_content)) {
        a((View)this.h, this.i, p().getFeedContent());
        this.i.setVisibility(0);
        return;
      } 
      this.i.setVisibility(8);
    }
    
    private void v() {
      if (n()) {
        this.j.setVisibility(0);
        ShapeHelper.b((ShapeHelper.ShapeView)this.h, 2131100881);
        int i = DensityUtils.a(this.g.a, 10.0F);
        this.h.setPadding(i, i, i, i);
        return;
      } 
      ShapeHelper.b((ShapeHelper.ShapeView)this.h, 2131100897);
      this.j.setVisibility(8);
      ShapeHelper.b((ShapeHelper.ShapeView)this.h, 2131100897);
      this.h.setPadding(0, 0, 0, 0);
    }
    
    private void w() {
      if (n() && this.a.repost.feed_is_delete == 1) {
        this.a.repost.feed_pics = null;
        this.a.repost.is_videos = "0";
        this.a.repost.relationship = this.a.relationship;
        this.a.repost.recommend_type = this.a.recommend_type;
      } 
    }
    
    private void x() {
      if (!o())
        a(t(), false); 
    }
    
    private void y() {
      a(this.a, false);
    }
    
    protected View a() {
      return null;
    }
    
    public void a(BluedIngSelfFeed param1BluedIngSelfFeed, int param1Int) {
      super.a(param1BluedIngSelfFeed, param1Int);
      w();
      v();
      u();
      s();
    }
    
    protected String b() {
      return ((t()).feed_pics != null && (t()).feed_pics.length > 0) ? (t()).feed_pics[0] : null;
    }
    
    public void onClick(View param1View) {
      super.onClick(param1View);
      int i = param1View.getId();
      if (i != 2131298759) {
        if (i != 2131299650)
          return; 
        y();
        return;
      } 
      x();
    }
    
    protected BluedIngSelfFeed t() {
      return n() ? this.a.repost : this.a;
    }
  }
  
  class null implements View.OnLongClickListener {
    null(FeedListAdapterForRecyclerView this$0, TextViewFixTouchForDynamic param1TextViewFixTouchForDynamic) {}
    
    public boolean onLongClick(View param1View) {
      String str = this.a.getText().toString();
      if (Build.VERSION.SDK_INT >= 11 && Build.VERSION.SDK_INT != 18) {
        ((ClipboardManager)this.b.g.a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("simple text", RegExpUtils.a(str)));
      } else {
        ((ClipboardManager)this.b.g.a.getSystemService("clipboard")).setText(RegExpUtils.a(str));
      } 
      AppMethods.a(this.b.g.a.getResources().getString(2131756130));
      return true;
    }
  }
  
  class ShareCircleFeedViewHolder extends WebFeedViewHolder {
    private ShareCircleFeedViewHolder(FeedListAdapterForRecyclerView this$0, View param1View) {
      super(param1View);
      this.l.setVisibility(0);
    }
    
    public void a(BluedIngSelfFeed param1BluedIngSelfFeed, int param1Int) {
      super.a(param1BluedIngSelfFeed, param1Int);
      if (n()) {
        this.i.setCardBackgroundColor(BluedSkinUtils.a(this.e.a, 2131100882));
      } else {
        this.i.setCardBackgroundColor(BluedSkinUtils.a(this.e.a, 2131100881));
      } 
      ImageLoader.a(this.e.b, (param1BluedIngSelfFeed.getContentData()).share_circle_posting_pic).a(2131231369).c(2131231280).a(this.j);
      this.m.setText((param1BluedIngSelfFeed.getContentData()).share_circle_title);
      this.m.setVisibility(0);
      if (!TextUtils.isEmpty((param1BluedIngSelfFeed.getContentData()).share_circle_posting_content)) {
        this.o.setText((param1BluedIngSelfFeed.getContentData()).share_circle_posting_content);
      } else {
        this.o.setText(this.e.a.getResources().getString(2131755943));
      } 
      this.o.setVisibility(0);
      this.i.setOnClickListener(new -$$Lambda$FeedListAdapterForRecyclerView$ShareCircleFeedViewHolder$ewEOCp58OG6X5MPvN9MnqI2Mc48(this));
    }
    
    protected String b() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("http://native.blued.cn/?action=base_post_detail&post_id=");
      stringBuilder.append((this.a.getContentData()).share_circle_posting_id);
      return stringBuilder.toString();
    }
    
    protected boolean e() {
      return false;
    }
  }
  
  class ShareTopicFeedViewHolder extends WebFeedViewHolder {
    public ShareTopicFeedViewHolder(FeedListAdapterForRecyclerView this$0, View param1View) {
      super(this$0, param1View);
    }
    
    public void a(BluedIngSelfFeed param1BluedIngSelfFeed, int param1Int) {
      super.a(param1BluedIngSelfFeed, param1Int);
      a(2131301689).setVisibility(0);
      this.o.setVisibility(0);
      if (param1BluedIngSelfFeed.isRepost() && param1BluedIngSelfFeed.repost.is_share_super_topics == 1) {
        if (!TextUtils.isEmpty(param1BluedIngSelfFeed.repost.share_s_t_des)) {
          this.o.setText(param1BluedIngSelfFeed.repost.share_s_t_des);
          return;
        } 
        this.o.setText(this.e.a.getResources().getString(2131758768));
        return;
      } 
      if (!TextUtils.isEmpty(param1BluedIngSelfFeed.share_s_t_des)) {
        this.o.setText(param1BluedIngSelfFeed.share_s_t_des);
        return;
      } 
      this.o.setText(this.e.a.getResources().getString(2131758768));
    }
    
    protected String b() {
      if (this.a.isRepost() && this.a.repost.is_share_super_topics == 1) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("https://native.blued.cn?action=topic&id=");
        stringBuilder1.append((this.a.getContentData()).share_s_t_did);
        stringBuilder1.append("&from=feed");
        return stringBuilder1.toString();
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("https://native.blued.cn?action=topic&id=");
      stringBuilder.append(this.a.share_s_t_did);
      stringBuilder.append("&from=feed");
      return stringBuilder.toString();
    }
    
    public void s() {
      String str;
      super.s();
      if (this.a.isRepost() && this.a.repost.is_share_super_topics == 1) {
        this.m.setText((this.a.getContentData()).share_s_t_name);
        str = (this.a.getContentData()).share_s_t_avatar;
      } else {
        this.m.setText(this.a.share_s_t_name);
        str = this.a.share_s_t_avatar;
      } 
      ImageLoader.a(this.e.b, str).a(2131231369).a(this.j);
      this.i.setOnClickListener(new -$$Lambda$FeedListAdapterForRecyclerView$ShareTopicFeedViewHolder$gkd2hxt_F4x0gUGhSgaT0s1293A(this));
    }
  }
  
  class VideoFeedViewHolder extends FeedOrCircleViewHolder implements View.OnClickListener {
    private CardView h = a(2131296646);
    
    private PLVideoPageView i = a(2131301607);
    
    public VideoFeedViewHolder(FeedListAdapterForRecyclerView this$0, View param1View) {
      super(this$0, param1View);
    }
    
    private void u() {
      if ((t()).feed_videos.length >= 2) {
        if ((t()).feed_videos_height == null)
          (t()).feed_videos_height = new String[0]; 
        if ((t()).feed_videos_width == null)
          (t()).feed_videos_width = new String[0]; 
        if ((t()).feed_videos_width.length == 0 || (t()).feed_videos_height.length == 0) {
          (t()).feed_videos_width = new String[] { "480" };
          (t()).feed_videos_height = new String[] { "480" };
        } 
        String str1 = (t()).feed_videos_width[0];
        int j = 480;
        int i = StringUtils.a(str1, 480);
        int k = StringUtils.a((t()).feed_videos_height[0], 480);
        if (i == 0 || k == 0) {
          i = 480;
        } else {
          j = k;
        } 
        int[] arrayOfInt = FeedMethods.a(this.f.a, i, j, this.a.isRepost());
        k = arrayOfInt[0];
        int m = arrayOfInt[1];
        ViewGroup.LayoutParams layoutParams1 = this.h.getLayoutParams();
        layoutParams1.width = k;
        layoutParams1.height = m;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)this.i.getLayoutParams();
        marginLayoutParams.width = k;
        marginLayoutParams.height = marginLayoutParams.width * j / i;
        marginLayoutParams.setMargins(0, (layoutParams1.height - marginLayoutParams.height) / 2, 0, 0);
        ViewGroup.LayoutParams layoutParams2 = this.i.getLayoutParams();
        String[] arrayOfString = (t()).feed_videos;
        String str2 = (t()).feed_video_size;
        VideoPlayConfig videoPlayConfig = new VideoPlayConfig();
        videoPlayConfig.a = (t()).feed_videos[0];
        videoPlayConfig.b = (t()).feed_videos[1];
        videoPlayConfig.e = layoutParams2.width;
        videoPlayConfig.f = layoutParams2.height;
        videoPlayConfig.a(i);
        videoPlayConfig.b(j);
        try {
          videoPlayConfig.c = Integer.parseInt((t()).feed_video_size);
        } catch (Exception exception) {
          Logger.b(FeedListAdapterForRecyclerView.class.getSimpleName(), new Object[] { " initVideo Integer.parseInt(getContentData().feed_video_size) Exception" });
        } 
        videoPlayConfig.g = (View.OnClickListener)new SingleClickProxy(new View.OnClickListener(this, arrayOfString, str2) {
              public void onClick(View param2View) {
                if (AudioChannelManager.e().h()) {
                  AppMethods.a(this.c.f.a.getResources().getText(2131759450));
                  return;
                } 
                if (this.c.e())
                  EventTrackFeed.a(FeedProtos.Event.NOTE_VIDEO_CLICK, this.c.a.circle_id, this.c.a.feed_id, EventTrackFeed.g(this.c.f.c)); 
                String[] arrayOfString = this.a;
                if (arrayOfString != null && arrayOfString.length >= 2) {
                  float f2 = 0.0F;
                  float f1 = f2;
                  if (!TextUtils.isEmpty(this.b))
                    try {
                      f1 = Float.parseFloat(this.b);
                    } catch (Exception exception) {
                      exception.printStackTrace();
                      f1 = f2;
                    }  
                  long l = (long)f1;
                  InstantLog.a("feed_video_play", Integer.valueOf(1));
                  Context context = this.c.f.a;
                  String[] arrayOfString1 = this.a;
                  BasePhotoFragment.a(context, arrayOfString1[0], arrayOfString1[1], (this.c.t()).feed_id, this.c.f.g, l);
                } 
              }
            });
        this.i.b(videoPlayConfig);
      } 
    }
    
    private void v() {
      if (e()) {
        x();
        return;
      } 
      w();
    }
    
    private void w() {
      if (AudioChannelManager.e().h()) {
        AppMethods.a(this.f.a.getResources().getText(2131759450));
        return;
      } 
      if (!o()) {
        if (this.f.c == 1 || this.f.c == 5) {
          a(t(), true, this.a.feed_id, this.a.feed_uid);
          return;
        } 
        a(t(), false, this.a.feed_id, this.a.feed_uid);
        return;
      } 
      a(this.a, false);
    }
    
    private void x() {
      EventTrackFeed.a(FeedProtos.Event.NOTE_VIDEO_CLICK, this.a.circle_id, this.a.feed_id, EventTrackFeed.g(this.f.c));
      if (AudioChannelManager.e().h()) {
        AppMethods.a(this.f.a.getResources().getText(2131759450));
        return;
      } 
      String[] arrayOfString = (t()).feed_videos;
      String str = (t()).feed_video_size;
      if (arrayOfString != null && arrayOfString.length >= 2) {
        float f2 = 0.0F;
        float f1 = f2;
        if (!TextUtils.isEmpty(str))
          try {
            f1 = Float.parseFloat(str);
          } catch (Exception exception) {
            exception.printStackTrace();
            f1 = f2;
          }  
        long l = (long)f1;
        BasePhotoFragment.a(this.f.a, arrayOfString[0], arrayOfString[1], this.a.feed_id, 7, l);
      } 
    }
    
    protected View a() {
      return (View)this.i;
    }
    
    public void a(BluedIngSelfFeed param1BluedIngSelfFeed, int param1Int) {
      super.a(param1BluedIngSelfFeed, param1Int);
      u();
      this.i.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
    }
    
    public void onClick(View param1View) {
      super.onClick(param1View);
      if (param1View.getId() != 2131301607)
        return; 
      v();
    }
  }
  
  class null implements View.OnClickListener {
    null(FeedListAdapterForRecyclerView this$0, String[] param1ArrayOfString, String param1String) {}
    
    public void onClick(View param1View) {
      if (AudioChannelManager.e().h()) {
        AppMethods.a(this.c.f.a.getResources().getText(2131759450));
        return;
      } 
      if (this.c.e())
        EventTrackFeed.a(FeedProtos.Event.NOTE_VIDEO_CLICK, this.c.a.circle_id, this.c.a.feed_id, EventTrackFeed.g(this.c.f.c)); 
      String[] arrayOfString = this.a;
      if (arrayOfString != null && arrayOfString.length >= 2) {
        float f2 = 0.0F;
        float f1 = f2;
        if (!TextUtils.isEmpty(this.b))
          try {
            f1 = Float.parseFloat(this.b);
          } catch (Exception exception) {
            exception.printStackTrace();
            f1 = f2;
          }  
        long l = (long)f1;
        InstantLog.a("feed_video_play", Integer.valueOf(1));
        Context context = this.c.f.a;
        String[] arrayOfString1 = this.a;
        BasePhotoFragment.a(context, arrayOfString1[0], arrayOfString1[1], (this.c.t()).feed_id, this.c.f.g, l);
      } 
    }
  }
  
  class VoteFeedViewHolder extends RepostAndTextFeedViewHolder implements View.OnClickListener {
    private CardView f = a(2131296659);
    
    private FeedVoteGroup h = a(2131297051);
    
    private View i = a(2131297043);
    
    private LinearLayout j = a(2131299162);
    
    private TextView k = a(2131299163);
    
    private LinearLayout l = a(2131301719);
    
    private TextView m = a(2131301720);
    
    private View n = a(2131299146);
    
    private View o = a(2131298774);
    
    public VoteFeedViewHolder(FeedListAdapterForRecyclerView this$0, View param1View) {
      super(this$0, param1View);
    }
    
    private void s() {
      this.n.setVisibility(8);
      this.o.setVisibility(0);
      this.o.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
    }
    
    private void u() {
      this.i.setVisibility(0);
      this.l.setVisibility(0);
    }
    
    private void v() {
      String[] arrayOfString = this.a.feed_pics;
      boolean bool = false;
      if (arrayOfString != null && this.a.feed_pics.length > 0) {
        this.h.setVisibility(0);
        String str = this.a.feed_pics[0];
        this.h.a(this.e.b, AvatarUtils.a(str));
        TextView textView = this.m;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.e.a.getString(2131756460));
        stringBuilder.append("：");
        stringBuilder.append(this.a.vote_count);
        textView.setText(stringBuilder.toString());
        if (this.a.ivoted != 0) {
          FeedVoteGroup feedVoteGroup = this.h;
          if (this.a.ivoted == 1)
            bool = true; 
          feedVoteGroup.a(true, bool);
          int i = (int)(this.a.a_vote_count / this.a.vote_count * 100.0F);
          this.h.a(i, 100 - i);
        } else {
          this.h.setVote(false);
        } 
        this.h.setOnViewClickListener(new FeedVoteGroup.OnViewClickListener(this, str) {
              public void a(boolean param2Boolean) {
                FeedHttpUtils.a(new BluedUIHttpResponse<BluedEntityA>(this) {
                      public void a(BluedEntityA param3BluedEntityA) {}
                    },  this.b.a.feed_id, (UserInfo.a().i()).uid, param2Boolean, this.b.e.b);
                this.b.a.is_vote = 1;
                BluedIngSelfFeed bluedIngSelfFeed = this.b.a;
                bluedIngSelfFeed.vote_count++;
                if (param2Boolean) {
                  EventTrackVote.a(VoteProtos.Event.VOTE_FEED_CHOOSE_PHOTO_CLICK, VoteProtos.PhotoOption.PHOTO_A, this.b.a.feed_uid, this.b.a.feed_id);
                  bluedIngSelfFeed = this.b.a;
                  bluedIngSelfFeed.a_vote_count++;
                  this.b.a.ivoted = 1;
                } else {
                  EventTrackVote.a(VoteProtos.Event.VOTE_FEED_CHOOSE_PHOTO_CLICK, VoteProtos.PhotoOption.PHOTO_B, this.b.a.feed_uid, this.b.a.feed_id);
                  bluedIngSelfFeed = this.b.a;
                  bluedIngSelfFeed.b_vote_count++;
                  this.b.a.ivoted = 2;
                } 
                FeedListAdapterForRecyclerView.VoteFeedViewHolder.a(this.b).a(true, param2Boolean);
                int i = (int)(this.b.a.a_vote_count / this.b.a.vote_count * 100.0F);
                FeedListAdapterForRecyclerView.VoteFeedViewHolder.a(this.b).a(i, 100 - i);
                FeedListAdapterForRecyclerView.VoteFeedViewHolder.a(this.b).a(this.b.e.b);
                TextView textView = FeedListAdapterForRecyclerView.VoteFeedViewHolder.b(this.b);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.b.e.a.getString(2131756460));
                stringBuilder.append("：");
                stringBuilder.append(this.b.a.vote_count);
                textView.setText(stringBuilder.toString());
                LiveEventBus.get("feed_vote_change").post(this.b.a);
              }
              
              public void b(boolean param2Boolean) {
                EventTrackVote.a(VoteProtos.Event.VOTE_FEED_ENLARGE_PHOTO_CLICK, this.b.a.feed_uid, this.b.a.feed_id);
                Context context = this.b.e.a;
                String str1 = this.a;
                int i = this.b.e.f;
                String str2 = this.b.a.user_name;
                String str3 = this.a;
                BasePhotoFragment.a(context, new String[] { str1 }, 0, i, null, str2, null, str3);
              }
            });
        return;
      } 
      this.h.setVote(false);
      this.h.setVisibility(8);
    }
    
    public void a(BluedIngSelfFeed param1BluedIngSelfFeed, int param1Int) {
      super.a(param1BluedIngSelfFeed, param1Int);
      u();
      s();
      v();
    }
    
    protected boolean e() {
      return false;
    }
    
    public void onClick(View param1View) {
      super.onClick(param1View);
      param1View.getId();
    }
    
    protected void r() {
      if (this.a.reading_scope == 0) {
        super.r();
        return;
      } 
      AppMethods.d(2131756461);
    }
  }
  
  class null implements FeedVoteGroup.OnViewClickListener {
    null(FeedListAdapterForRecyclerView this$0, String param1String) {}
    
    public void a(boolean param1Boolean) {
      FeedHttpUtils.a(new BluedUIHttpResponse<BluedEntityA>(this) {
            public void a(BluedEntityA param3BluedEntityA) {}
          },  this.b.a.feed_id, (UserInfo.a().i()).uid, param1Boolean, this.b.e.b);
      this.b.a.is_vote = 1;
      BluedIngSelfFeed bluedIngSelfFeed = this.b.a;
      bluedIngSelfFeed.vote_count++;
      if (param1Boolean) {
        EventTrackVote.a(VoteProtos.Event.VOTE_FEED_CHOOSE_PHOTO_CLICK, VoteProtos.PhotoOption.PHOTO_A, this.b.a.feed_uid, this.b.a.feed_id);
        bluedIngSelfFeed = this.b.a;
        bluedIngSelfFeed.a_vote_count++;
        this.b.a.ivoted = 1;
      } else {
        EventTrackVote.a(VoteProtos.Event.VOTE_FEED_CHOOSE_PHOTO_CLICK, VoteProtos.PhotoOption.PHOTO_B, this.b.a.feed_uid, this.b.a.feed_id);
        bluedIngSelfFeed = this.b.a;
        bluedIngSelfFeed.b_vote_count++;
        this.b.a.ivoted = 2;
      } 
      FeedListAdapterForRecyclerView.VoteFeedViewHolder.a(this.b).a(true, param1Boolean);
      int i = (int)(this.b.a.a_vote_count / this.b.a.vote_count * 100.0F);
      FeedListAdapterForRecyclerView.VoteFeedViewHolder.a(this.b).a(i, 100 - i);
      FeedListAdapterForRecyclerView.VoteFeedViewHolder.a(this.b).a(this.b.e.b);
      TextView textView = FeedListAdapterForRecyclerView.VoteFeedViewHolder.b(this.b);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.b.e.a.getString(2131756460));
      stringBuilder.append("：");
      stringBuilder.append(this.b.a.vote_count);
      textView.setText(stringBuilder.toString());
      LiveEventBus.get("feed_vote_change").post(this.b.a);
    }
    
    public void b(boolean param1Boolean) {
      EventTrackVote.a(VoteProtos.Event.VOTE_FEED_ENLARGE_PHOTO_CLICK, this.b.a.feed_uid, this.b.a.feed_id);
      Context context = this.b.e.a;
      String str1 = this.a;
      int i = this.b.e.f;
      String str2 = this.b.a.user_name;
      String str3 = this.a;
      BasePhotoFragment.a(context, new String[] { str1 }, 0, i, null, str2, null, str3);
    }
  }
  
  class null extends BluedUIHttpResponse<BluedEntityA> {
    public void a(BluedEntityA param1BluedEntityA) {}
  }
  
  class WebFeedViewHolder extends RepostAndTextFeedViewHolder implements View.OnClickListener {
    protected LinearLayout f = a(2131297040);
    
    protected TextView h = a(2131296838);
    
    protected CardView i = a(2131296902);
    
    protected ImageView j = a(2131297586);
    
    protected View k = a(2131301689);
    
    protected View l = a(2131301632);
    
    protected TextView m = a(2131301524);
    
    protected TextView n = a(2131301526);
    
    protected TextView o = a(2131301525);
    
    public WebFeedViewHolder(FeedListAdapterForRecyclerView this$0, View param1View) {
      super(this$0, param1View);
    }
    
    private void u() {
      if (n()) {
        this.i.setCardBackgroundColor(BluedSkinUtils.a(this.p.a, 2131100882));
        return;
      } 
      this.i.setCardBackgroundColor(BluedSkinUtils.a(this.p.a, 2131100881));
    }
    
    private void v() {
      InstantLog.b("feed_web_card_click", 1);
      if ((t()).feed_extras != null)
        WebViewShowInfoFragment.show(this.p.a, (t()).feed_extras.url, -1); 
    }
    
    public void a(BluedIngSelfFeed param1BluedIngSelfFeed, int param1Int) {
      super.a(param1BluedIngSelfFeed, param1Int);
      u();
      s();
      this.k.setVisibility(8);
      this.l.setVisibility(8);
      this.o.setVisibility(8);
      this.n.setVisibility(8);
    }
    
    protected String b() {
      return ((t()).feed_extras != null && (t()).feed_extras.thumb != null && (t()).feed_extras.thumb.size() > 0) ? ((String)(t()).feed_extras.thumb.get(0)).replace(";", "") : ((this.a.feed_extras != null && this.a.feed_extras.thumb != null && this.a.feed_extras.thumb.size() > 0) ? ((String)this.a.feed_extras.thumb.get(0)).replace(";", "") : null);
    }
    
    protected boolean e() {
      return false;
    }
    
    public void onClick(View param1View) {
      super.onClick(param1View);
      if (param1View.getId() != 2131296902)
        return; 
      v();
    }
    
    public void s() {
      this.i.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
      if ((t()).feed_extras != null)
        this.m.setText((t()).feed_extras.title); 
      ImageLoader.a(this.p.b, b()).a(2131231369).a(this.j);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\adapter\FeedListAdapterForRecyclerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */