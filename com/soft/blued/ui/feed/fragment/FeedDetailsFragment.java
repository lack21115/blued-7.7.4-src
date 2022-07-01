package com.soft.blued.ui.feed.fragment;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.MovementMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.ui.custom.KeyboardListenLinearLayout;
import com.blued.android.framework.ui.custom.MvpKeyBoardFragment;
import com.blued.android.framework.ui.custom.SwitchPanelRelativeLayout;
import com.blued.android.framework.ui.mvp.MvpUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.utils.RegExpUtils;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeRelativeLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.LinkMovementClickMethod;
import com.blued.android.module.player.media.model.VideoPlayConfig;
import com.blued.android.module.player.media.view.PLVideoPageView;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.blued.android.similarity_operation_provider.BluedURIRouterAdapter;
import com.blued.das.client.feed.FeedProtos;
import com.blued.das.client.vote.VoteProtos;
import com.blued.das.message.MessageProtos;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.soft.blued.constant.ADConstants;
import com.soft.blued.customview.ActionSheet;
import com.soft.blued.customview.AvatarLivingAnimView;
import com.soft.blued.customview.BannerADView;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.PhotoGridView;
import com.soft.blued.customview.TextViewFixTouchForDynamic;
import com.soft.blued.customview.consecutivescroller.ConsecutiveScrollerLayout;
import com.soft.blued.emoticon.manager.EmotionManager;
import com.soft.blued.emoticon.model.EmoticonModel;
import com.soft.blued.emoticon.model.EmoticonPackageModel;
import com.soft.blued.emoticon.ui.EmoticonsIndicatorView;
import com.soft.blued.emoticon.ui.EmoticonsPageView;
import com.soft.blued.emoticon.ui.EmoticonsToolBarView;
import com.soft.blued.emoticon.ui.IViewStateListener;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.model.LogData;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.log.trackUtils.EventTrackVote;
import com.soft.blued.ui.circle.fragment.CircleDetailsFragment;
import com.soft.blued.ui.circle.model.CircleConstants;
import com.soft.blued.ui.feed.adapter.FeedDetailsCommentListAdapter;
import com.soft.blued.ui.feed.adapter.FeedDetailsLikeListAdapter;
import com.soft.blued.ui.feed.adapter.FeedDetailsPhotoAdapter;
import com.soft.blued.ui.feed.adapter.FeedDetailsRepostListAdapter;
import com.soft.blued.ui.feed.adapter.FeedListAdapterForRecyclerView;
import com.soft.blued.ui.feed.manager.FeedMethods;
import com.soft.blued.ui.feed.model.BluedADExtra;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.feed.model.FeedComment;
import com.soft.blued.ui.feed.model.FeedRepost;
import com.soft.blued.ui.feed.presenter.FeedDetailsPresenter;
import com.soft.blued.ui.feed.view.FeedVoteGroup;
import com.soft.blued.ui.find.model.BluedRecommendUsers;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.msg.ShowPositionActivity;
import com.soft.blued.ui.msg.customview.Emotion;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.photo.fragment.BasePhotoFragment;
import com.soft.blued.ui.user.fragment.DynamicSkinFragment;
import com.soft.blued.ui.user.fragment.ReportFragmentNew;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.user.manager.AvatarWidgetManager;
import com.soft.blued.ui.user.manager.DynamicSkinManager;
import com.soft.blued.ui.user.views.FollowStatusView;
import com.soft.blued.ui.video.fragment.VideoScanFragment;
import com.soft.blued.ui.video.fragment.VideoUserInfoFragment;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.AreaUtils;
import com.soft.blued.utils.AtChooseUserHelper;
import com.soft.blued.utils.DistanceUtils;
import com.soft.blued.utils.ImageUtils;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.ShareUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TimeAndDateUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.soft.blued.utils.click.SingleClickProxy;
import com.soft.blued.view.tip.CommonAlertDialog;
import com.soft.blued.view.tip.CommonShowBottomWindow;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FeedDetailsFragment extends MvpKeyBoardFragment<FeedDetailsPresenter> {
  @BindView(2131297700)
  ImageView avatarWidget;
  
  @BindView(2131296495)
  BannerADView bannerAD;
  
  @BindView(2131296496)
  View bannerLine;
  
  @BindView(2131296658)
  CardView cardVideo;
  
  @BindView(2131296661)
  CardView cardVote;
  
  @BindView(2131296800)
  TextView commentNumText;
  
  @BindView(2131296802)
  TextView commentText;
  
  @BindView(2131296838)
  TextViewFixTouchForDynamic contentView;
  
  @BindView(2131296854)
  ConsecutiveScrollerLayout cslView;
  
  @BindView(2131296891)
  CardView cvImageOne;
  
  @BindView(2131296902)
  CardView cvWebShare;
  
  @BindView(2131296943)
  TextView distanceView;
  
  @BindView(2131296957)
  ShapeFrameLayout dotIconDistance;
  
  @BindView(2131296958)
  ShapeFrameLayout dotIconRecommend;
  
  @BindView(2131297038)
  ImageView dynamicSkin;
  
  @BindView(2131296968)
  ShapeRelativeLayout editLayout;
  
  @BindView(2131296971)
  EditText editView;
  
  @BindView(2131296983)
  LinearLayout emoticonLayout;
  
  @BindView(2131296984)
  SwitchPanelRelativeLayout emoticonLayoutRoot;
  
  @BindView(2131297025)
  ImageView expressionBtn;
  
  @BindView(2131297032)
  ConstraintLayout feed;
  
  @BindView(2131297040)
  LinearLayout feedInfo;
  
  @BindView(2131297042)
  ShapeRelativeLayout feedLike;
  
  @BindView(2131297043)
  LinearLayout feedLocation;
  
  @BindView(2131297049)
  ConstraintLayout feedUserInfo;
  
  @BindView(2131297050)
  ConstraintLayout feedVisible;
  
  @BindView(2131297051)
  FeedVoteGroup feedVote;
  
  @BindView(2131297199)
  FollowStatusView followStatusView;
  
  @BindView(2131297362)
  ImageView headerView;
  
  @BindView(2131297400)
  ImageView iconLike;
  
  @BindView(2131297405)
  ImageView iconShare;
  
  @BindView(2131297414)
  ImageView imageOne;
  
  @BindView(2131297415)
  PhotoGridView imageOther;
  
  @BindView(2131297416)
  PhotoGridView imageTwoFour;
  
  @BindView(2131297447)
  ImageView imgBluedMedal;
  
  @BindView(2131297481)
  ImageView imgFeedAdArrow;
  
  @BindView(2131297482)
  ImageView imgFeedSticky;
  
  @BindView(2131298685)
  AvatarLivingAnimView imgLivingAnim;
  
  @BindView(2131297543)
  ImageView imgPromotionBubble;
  
  @BindView(2131297575)
  ImageView imgVerify;
  
  @BindView(2131297586)
  ImageView imgWebShare;
  
  @BindView(2131297596)
  LinearLayout inputLayoutUp;
  
  @BindView(2131297878)
  ImageView ivNoData;
  
  @BindView(2131297908)
  ImageView ivReadExtend;
  
  @BindView(2131297969)
  ImageView ivVisible;
  
  @BindView(2131297981)
  KeyboardListenLinearLayout keyboardRelativeLayout;
  
  @BindView(2131297985)
  View keyboardView;
  
  @BindView(2131298051)
  LinearLayout layoutComment;
  
  @BindView(2131298069)
  LinearLayout layoutLikeShare;
  
  @BindView(2131298095)
  ShapeLinearLayout layoutSuperTopic;
  
  @BindView(2131298118)
  TextView line;
  
  @BindView(2131298695)
  LinearLayout llAdOption;
  
  @BindView(2131298753)
  ShapeLinearLayout llComment;
  
  @BindView(2131298759)
  ShapeLinearLayout llContentAll;
  
  @BindView(2131298774)
  ShapeRelativeLayout llDetailsShare;
  
  @BindView(2131298780)
  LinearLayout llDistanceAndTime;
  
  @BindView(2131298911)
  ShapeLinearLayout llLike;
  
  @BindView(2131298956)
  LinearLayout llMore;
  
  @BindView(2131298957)
  LinearLayout llMoreComment;
  
  @BindView(2131298982)
  LinearLayout llNoData;
  
  @BindView(2131299038)
  ShapeLinearLayout llRead;
  
  @BindView(2131299039)
  LinearLayout llReadNum;
  
  @BindView(2131299043)
  LinearLayout llRecommendMore;
  
  @BindView(2131299045)
  LinearLayout llRefresh;
  
  @BindView(2131299055)
  ShapeLinearLayout llRepost;
  
  @BindView(2131299091)
  ShapeLinearLayout llTab;
  
  @BindView(2131299161)
  ImageView locationIcon;
  
  @BindView(2131299162)
  ShapeLinearLayout locationLayout;
  
  @BindView(2131299163)
  TextView locationText;
  
  @BindView(2131299215)
  ImageView menuView;
  
  private Context n;
  
  @BindView(2131299358)
  TextView nameView;
  
  private AtChooseUserHelper o;
  
  private FeedListAdapterForRecyclerView p;
  
  private FeedDetailsCommentListAdapter q;
  
  private FeedDetailsLikeListAdapter r;
  
  @BindView(2131299585)
  View recommendLine;
  
  @BindView(2131299605)
  RecyclerView recyclerView;
  
  @BindView(2131299616)
  SmartRefreshLayout refreshLayout;
  
  @BindView(2131299649)
  TextViewFixTouchForDynamic repostContentView;
  
  @BindView(2131299650)
  View repostLayout;
  
  @BindView(2131299651)
  TextView repostNumText;
  
  @BindView(2131299652)
  TextView repostText;
  
  @BindView(2131299771)
  RecyclerView rvFeed;
  
  private FeedDetailsRepostListAdapter s;
  
  @BindView(2131299890)
  ShapeTextView sendBtn;
  
  @BindView(2131299980)
  ShapeLinearLayout sllSuperTopic;
  
  @BindView(2131300102)
  ShapeTextView stvLongPicIcon;
  
  @BindView(2131300145)
  ScrollView svHeader;
  
  private LoadOptions t;
  
  @BindView(2131300267)
  TextView timeView;
  
  @BindView(2131300293)
  View topBar;
  
  @BindView(2131300300)
  CommonTopTitleNoTrans topTitle;
  
  @BindView(2131300756)
  TextView tvFeedAd;
  
  @BindView(2131300763)
  TextView tvFeedRecommendSource;
  
  @BindView(2131301108)
  TextView tvNoData;
  
  @BindView(2131301233)
  TextView tvReadNum;
  
  @BindView(2131301238)
  TextView tvRecommend;
  
  @BindView(2131301364)
  TextView tvSuperTopic;
  
  @BindView(2131301507)
  TextView tvVisible;
  
  @BindView(2131301524)
  TextView tvWebShareContent;
  
  @BindView(2131301525)
  TextView tvWebShareDesc;
  
  @BindView(2131301526)
  TextView tvWebShareTitleRight;
  
  private int u;
  
  private int v;
  
  @BindView(2131301607)
  PLVideoPageView videoView;
  
  @BindView(2131301632)
  View viewCircleCorner;
  
  @BindView(2131301642)
  EmoticonsIndicatorView viewEiv;
  
  @BindView(2131301643)
  EmoticonsPageView viewEpv;
  
  @BindView(2131301644)
  EmoticonsToolBarView viewEtv;
  
  @BindView(2131301689)
  View viewTopicCorner;
  
  @BindView(2131301714)
  ImageView visibleMenuView;
  
  @BindView(2131301719)
  ShapeLinearLayout voteNumLayout;
  
  @BindView(2131301720)
  TextView voteText;
  
  private int w;
  
  private int x;
  
  private RecyclerView.OnScrollListener y = new RecyclerView.OnScrollListener(this) {
      public void onScrollStateChanged(RecyclerView param1RecyclerView, int param1Int) {
        if (FeedDetailsFragment.b(this.a) != null && (FeedDetailsFragment.b(this.a)).p != null)
          (FeedDetailsFragment.b(this.a)).p.onScrollStateChanged(param1RecyclerView, param1Int); 
      }
      
      public void onScrolled(RecyclerView param1RecyclerView, int param1Int1, int param1Int2) {
        if (FeedDetailsFragment.b(this.a) != null && (FeedDetailsFragment.b(this.a)).p != null)
          (FeedDetailsFragment.b(this.a)).p.onScrolled(param1RecyclerView, param1Int1, param1Int2); 
      }
    };
  
  private TextWatcher z = new TextWatcher(this) {
      private int b;
      
      private int c;
      
      private String d;
      
      private String e;
      
      public void afterTextChanged(Editable param1Editable) {
        this.b = this.a.editView.getSelectionStart();
        this.c = this.a.editView.getSelectionEnd();
        this.a.editView.removeTextChangedListener(FeedDetailsFragment.e(this.a));
        if (!FeedDetailsFragment.d(this.a).a(this.a, this.d, this.e, param1Editable, this.c))
          this.a.editView.setSelection(this.b); 
        this.a.editView.addTextChangedListener(FeedDetailsFragment.e(this.a));
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
  
  @BindView(2131301787)
  TextView zanNumText;
  
  @BindView(2131301788)
  TextView zanText;
  
  private void F() {
    ShapeHelper.b((ShapeHelper.ShapeView)this.editLayout, 2131100881);
    ShapeHelper.b((ShapeHelper.ShapeView)this.feedLike, 2131100881);
    ShapeHelper.b((ShapeHelper.ShapeView)this.llDetailsShare, 2131100881);
    this.tvVisible.setTextColor(BluedSkinUtils.a(this.n, 2131100842));
    ShapeHelper.b((ShapeHelper.ShapeView)this.llRead, 2131100881);
    ShapeHelper.b((ShapeHelper.ShapeView)this.llTab, 2131100881);
    ShapeHelper.b((ShapeHelper.ShapeView)this.llLike, 2131100881);
    ShapeHelper.b((ShapeHelper.ShapeView)this.llComment, 2131100882);
    ShapeHelper.b((ShapeHelper.ShapeView)this.llRepost, 2131100881);
    this.refreshLayout.setBackgroundColor(BluedSkinUtils.a(this.n, 2131100728));
    this.visibleMenuView.setVisibility(8);
    this.feed.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            KeyboardUtils.a((Activity)this.a.getActivity());
          }
        });
  }
  
  private void G() {
    this.refreshLayout.setBackgroundColor(BluedSkinUtils.a(this.n, 2131100733));
    this.refreshLayout.c(true);
    this.refreshLayout.b(true);
    this.ivNoData.setImageResource(2131232635);
    this.tvNoData.setText(2131757788);
    this.llNoData.setVisibility(8);
    this.llRefresh.setVisibility(0);
    this.refreshLayout.a(new OnRefreshLoadMoreListener(this) {
          public void a(RefreshLayout param1RefreshLayout) {
            ((FeedDetailsPresenter)this.a.s()).f();
          }
          
          public void onRefresh(RefreshLayout param1RefreshLayout) {
            ((FeedDetailsPresenter)this.a.s()).e();
          }
        });
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
    this.recyclerView.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    if (this.r == null)
      this.r = new FeedDetailsLikeListAdapter(this.n, (IRequestHost)w_(), "feed_detail"); 
    this.r.c(false);
    if (this.s == null)
      this.s = new FeedDetailsRepostListAdapter(this.n, (IRequestHost)w_(), "feed_detail"); 
    this.s.c(false);
    if (this.q == null)
      this.q = new FeedDetailsCommentListAdapter(this.n, (IRequestHost)w_(), "feed_detail"); 
    this.q.a(new FeedDetailsCommentListAdapter.FeedCommentListener(this) {
          public void a(FeedComment param1FeedComment) {
            ((FeedDetailsPresenter)this.a.s()).c(false);
            ((FeedDetailsPresenter)this.a.s()).h(param1FeedComment.comment_id);
            ((FeedDetailsPresenter)this.a.s()).g(param1FeedComment.user_name);
            String str = FeedDetailsFragment.a(this.a).getResources().getString(2131758580);
            EditText editText = this.a.editView;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(param1FeedComment.user_name);
            stringBuilder.append(":");
            editText.setHint(stringBuilder.toString());
            this.a.inputLayoutUp.setVisibility(0);
            this.a.editView.requestFocus();
            KeyboardUtils.c((Activity)this.a.getActivity());
          }
        });
    this.q.c(false);
    this.recyclerView.setAdapter((RecyclerView.Adapter)this.q);
    if (this.p == null)
      this.p = new FeedListAdapterForRecyclerView(new ArrayList(), getContext(), (IRequestHost)w_(), this.rvFeed, 14); 
    this.p.c(false);
    this.llMoreComment.setOnClickListener((View.OnClickListener)new SingleClickProxy(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              EventTrackFeed.a(FeedProtos.Event.FEED_DETAIL_COMMENT_MORE_CLICK, (((FeedDetailsPresenter)this.a.s()).r()).feed_id);
              ((FeedDetailsPresenter)this.a.s()).a(true);
              ((FeedDetailsPresenter)this.a.s()).f();
            }
          }));
    linearLayoutManager = new LinearLayoutManager(getContext());
    this.rvFeed.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    this.rvFeed.setAdapter((RecyclerView.Adapter)this.p);
    this.rvFeed.addOnScrollListener(this.y);
  }
  
  private void H() {
    a((View)this.emoticonLayoutRoot, this.keyboardRelativeLayout, this.editView, (View)this.emoticonLayout);
    this.feedLike.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            boolean bool1;
            boolean bool2;
            FeedProtos.Event event = FeedProtos.Event.FEED_LIKE_BTN_CLICK;
            String str1 = (((FeedDetailsPresenter)this.a.s()).r()).feed_id;
            String str2 = (((FeedDetailsPresenter)this.a.s()).r()).super_did;
            if ((((FeedDetailsPresenter)this.a.s()).r()).iliked == 0) {
              bool1 = true;
            } else {
              bool1 = false;
            } 
            FeedProtos.SourcePage sourcePage = EventTrackFeed.e(((FeedDetailsPresenter)this.a.s()).w());
            String str3 = (((FeedDetailsPresenter)this.a.s()).r()).feed_uid;
            if ((((FeedDetailsPresenter)this.a.s()).r()).in_promotion == 1) {
              bool2 = true;
            } else {
              bool2 = false;
            } 
            EventTrackFeed.a(event, str1, str2, bool1, sourcePage, str3, bool2, (((FeedDetailsPresenter)this.a.s()).r()).recommend_text);
            if (1 == (((FeedDetailsPresenter)this.a.s()).r()).iliked) {
              ((FeedDetailsPresenter)this.a.s()).o();
              return;
            } 
            ((FeedDetailsPresenter)this.a.s()).n();
            InstantLog.a(((FeedDetailsPresenter)this.a.s()).x(), ((FeedDetailsPresenter)this.a.s()).r(), "", -1);
          }
        });
    this.llDetailsShare.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            FeedDetailsFragment.c(this.a);
          }
        });
    this.sendBtn.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if ((((FeedDetailsPresenter)this.a.s()).r()).super_did != null) {
              str1 = (((FeedDetailsPresenter)this.a.s()).r()).super_did;
            } else {
              str1 = "";
            } 
            FeedProtos.Event event = FeedProtos.Event.FEED_COMMENT_SEND_BTN_CLICK;
            String str2 = (((FeedDetailsPresenter)this.a.s()).r()).feed_id;
            FeedProtos.SourcePage sourcePage = EventTrackFeed.c(((FeedDetailsPresenter)this.a.s()).w());
            String str3 = (((FeedDetailsPresenter)this.a.s()).r()).feed_uid;
            int i = (((FeedDetailsPresenter)this.a.s()).r()).in_promotion;
            boolean bool = true;
            if (i != 1)
              bool = false; 
            EventTrackFeed.a(event, str2, str1, sourcePage, str3, bool, (((FeedDetailsPresenter)this.a.s()).r()).recommend_text);
            String str1 = this.a.editView.getText().toString();
            if (!TextUtils.isEmpty(str1.trim())) {
              if (((FeedDetailsPresenter)this.a.s()).r() != null)
                EventTrackFeed.a(FeedProtos.Event.FEED_INTERACTIVE, (((FeedDetailsPresenter)this.a.s()).r()).feed_id, FeedProtos.InteractiveType.COMMENT, FeedProtos.Location.FEED_DETAIL, ((FeedDetailsPresenter)this.a.s()).C(), (((FeedDetailsPresenter)this.a.s()).r()).feed_uid); 
              str1 = FeedDetailsFragment.d(this.a).b(str1);
              ((FeedDetailsPresenter)this.a.s()).f(str1);
              return;
            } 
            AppMethods.d(2131756414);
          }
        });
    this.expressionBtn.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.n();
          }
        });
    this.editView.setFilters(new InputFilter[] { (InputFilter)new InputFilter.LengthFilter(256) });
    this.editView.addTextChangedListener(this.z);
    this.editView.setHint(FeedMethods.a(this.n));
    this.editView.setOnFocusChangeListener(new View.OnFocusChangeListener(this) {
          public void onFocusChange(View param1View, boolean param1Boolean) {
            if (param1Boolean && ((FeedDetailsPresenter)this.a.s()).r() != null)
              EventTrackFeed.a(FeedProtos.Event.FEED_COMMENT_BOX_CLICK, (((FeedDetailsPresenter)this.a.s()).r()).feed_id, FeedProtos.Location.FEED_DETAIL); 
          }
        });
  }
  
  private void I() {
    if ((((FeedDetailsPresenter)s()).r()).reading_scope != 0 && (((FeedDetailsPresenter)s()).r()).is_vote == 1) {
      AppMethods.d(2131756461);
      return;
    } 
    int i = ((FeedDetailsPresenter)s()).x();
    BluedIngSelfFeed bluedIngSelfFeed = ((FeedDetailsPresenter)s()).r();
    String str = "";
    InstantLog.c(i, bluedIngSelfFeed, "", -1);
    if (this.llDetailsShare.getTag() != null) {
      if (this.llDetailsShare.getTag() != null)
        str = (String)this.llDetailsShare.getTag(); 
      ImageFileLoader.a((IRequestHost)w_()).b(str).a(new ImageFileLoader.OnLoadFileListener(this) {
            public void onUIFinish(File param1File, Exception param1Exception) {
              if (param1File != null && param1File.exists()) {
                Bitmap bitmap = BitmapFactory.decodeFile(param1File.getPath());
              } else {
                param1File = null;
              } 
              FeedDetailsFragment.a(this.a, (Bitmap)param1File);
            }
          }).a();
      return;
    } 
    a((Bitmap)null);
  }
  
  private void J() {
    Emotion emotion = new Emotion(this.n);
    ArrayList<EmoticonPackageModel> arrayList = new ArrayList();
    arrayList.add(EmotionManager.h());
    this.viewEtv.setModel(true);
    this.viewEtv.a((IRequestHost)w_(), arrayList);
    this.viewEpv.a((IRequestHost)w_(), arrayList);
    this.viewEpv.setOnIndicatorListener(new EmoticonsPageView.OnEmoticonsPageViewListener(this) {
          public void a(int param1Int) {
            this.a.viewEiv.a(param1Int);
          }
          
          public void a(int param1Int1, int param1Int2) {
            this.a.viewEiv.a(param1Int1, param1Int2);
          }
          
          public void b(int param1Int) {
            this.a.viewEiv.setIndicatorCount(param1Int);
          }
          
          public void c(int param1Int) {
            this.a.viewEiv.b(param1Int);
          }
        });
    this.viewEpv.setIViewListener(new IViewStateListener(this, emotion) {
          public void a(EmoticonModel param1EmoticonModel) {
            if (this.b.editView != null) {
              KeyEvent keyEvent;
              SpannableString spannableString;
              this.b.editView.setFocusable(true);
              this.b.editView.setFocusableInTouchMode(true);
              this.b.editView.requestFocus();
              if (param1EmoticonModel.eventType == 1L) {
                keyEvent = new KeyEvent(0, 67);
                this.b.editView.onKeyDown(67, keyEvent);
                return;
              } 
              if (((EmoticonModel)keyEvent).eventType == 2L)
                return; 
              if (((EmoticonModel)keyEvent).emoji == null) {
                spannableString = this.a.a(((EmoticonModel)keyEvent).code);
                this.b.editView.getText().insert(this.b.editView.getSelectionStart(), (CharSequence)spannableString);
                return;
              } 
              this.b.editView.append(((EmoticonModel)spannableString).emoji.a());
            } 
          }
          
          public void c(int param1Int) {
            this.b.viewEtv.setToolBtnSelect(param1Int);
          }
        });
    this.viewEtv.setOnToolBarItemClickListener(new EmoticonsToolBarView.OnToolBarItemClickListener(this) {
          public void a(int param1Int) {
            this.a.viewEpv.setPageSelect(param1Int);
          }
        });
  }
  
  private void K() {
    this.llComment.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            FeedDetailsFragment.a(this.a, 1);
          }
        });
    this.llLike.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            FeedDetailsFragment.a(this.a, 0);
          }
        });
    this.llRepost.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            FeedDetailsFragment.a(this.a, 2);
          }
        });
  }
  
  private void L() {
    ViewGroup.LayoutParams layoutParams = this.topBar.getLayoutParams();
    layoutParams.height = StatusBarHelper.a(getContext());
    this.topBar.setLayoutParams(layoutParams);
    this.topTitle.setCenterText(getString(2131756399));
    this.topTitle.setCenterTextColor(2131100838);
    this.topTitle.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.E();
          }
        });
    this.topTitle.setRightImgDrawable(BluedSkinUtils.b(this.n, 2131232753));
    this.topTitle.setRightClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            ArrayList<String> arrayList = new ArrayList();
            if (UserInfo.a().i().getUid().equals((((FeedDetailsPresenter)this.a.s()).r()).feed_uid)) {
              arrayList.add(FeedDetailsFragment.a(this.a).getResources().getString(2131756457));
              if ((((FeedDetailsPresenter)this.a.s()).r()).can_promotion == 1)
                arrayList.add(FeedDetailsFragment.a(this.a).getResources().getString(2131756452)); 
              arrayList.add(FeedDetailsFragment.a(this.a).getResources().getString(2131756052));
              arrayList.add(FeedDetailsFragment.a(this.a).getResources().getString(2131756224));
              arrayList.add(FeedDetailsFragment.a(this.a).getResources().getString(2131756176));
            } else {
              FeedDetailsFragment feedDetailsFragment = this.a;
              if (FeedDetailsFragment.a(feedDetailsFragment, ((FeedDetailsPresenter)feedDetailsFragment.s()).r()))
                arrayList.add(FeedDetailsFragment.a(this.a).getResources().getString(2131756223)); 
              if ((((FeedDetailsPresenter)this.a.s()).r()).unliked_url != null && (((FeedDetailsPresenter)this.a.s()).r()).unliked_url.length > 0)
                arrayList.add(FeedDetailsFragment.a(this.a).getResources().getString(2131756210)); 
              arrayList.add(FeedDetailsFragment.a(this.a).getResources().getString(2131758584));
            } 
            CommonShowBottomWindow.a((FragmentActivity)FeedDetailsFragment.a(this.a), arrayList.<String>toArray(new String[arrayList.size()]), new ActionSheet.ActionSheetListener(this) {
                  public void a(ActionSheet param2ActionSheet, int param2Int) {
                    FragmentActivity fragmentActivity;
                    String str = param2ActionSheet.a(param2Int);
                    if (str.equals(FeedDetailsFragment.a(this.a.a).getResources().getString(2131756176))) {
                      CommonAlertDialog.a(FeedDetailsFragment.a(this.a.a), FeedDetailsFragment.a(this.a.a).getResources().getString(2131756094), FeedDetailsFragment.a(this.a.a).getResources().getString(2131756395), FeedDetailsFragment.a(this.a.a).getResources().getString(2131756394), new DialogInterface.OnClickListener(this) {
                            public void onClick(DialogInterface param3DialogInterface, int param3Int) {
                              ((FeedDetailsPresenter)this.a.a.a.s()).m();
                            }
                          },  FeedDetailsFragment.a(this.a.a).getResources().getString(2131756462), null, null);
                      return;
                    } 
                    if (str.equals(FeedDetailsFragment.a(this.a.a).getResources().getString(2131755680))) {
                      FeedDetailsFragment.c(this.a.a);
                      return;
                    } 
                    if (str.equals(FeedDetailsFragment.a(this.a.a).getResources().getString(2131758584))) {
                      fragmentActivity = this.a.a.getActivity();
                      String str1 = (((FeedDetailsPresenter)this.a.a.s()).r()).feed_id;
                      StringBuilder stringBuilder = new StringBuilder();
                      stringBuilder.append(this.a.a.nameView.getText());
                      stringBuilder.append("");
                      ReportFragmentNew.a((Context)fragmentActivity, 2, str1, stringBuilder.toString());
                      return;
                    } 
                    if (fragmentActivity.equals(FeedDetailsFragment.a(this.a.a).getResources().getString(2131756210))) {
                      if ((((FeedDetailsPresenter)this.a.a.s()).r()).unliked_url != null && (((FeedDetailsPresenter)this.a.a.s()).r()).unliked_url.length > 0) {
                        FindHttpUtils.a((((FeedDetailsPresenter)this.a.a.s()).r()).unliked_url);
                        return;
                      } 
                    } else {
                      if (fragmentActivity.equals(FeedDetailsFragment.a(this.a.a).getResources().getString(2131756052))) {
                        FeedMethods.b((FragmentActivity)FeedDetailsFragment.a(this.a.a), ((FeedDetailsPresenter)this.a.a.s()).r(), (IRequestHost)this.a.a.w_());
                        return;
                      } 
                      if (fragmentActivity.equals(FeedDetailsFragment.a(this.a.a).getResources().getString(2131756457))) {
                        FeedMethods.a((FragmentActivity)FeedDetailsFragment.a(this.a.a), ((FeedDetailsPresenter)this.a.a.s()).r(), (IRequestHost)this.a.a.w_());
                        return;
                      } 
                      if (FeedDetailsFragment.a(this.a.a).getResources().getString(2131756452).equals(fragmentActivity)) {
                        WebViewShowInfoFragment.show(FeedDetailsFragment.a(this.a.a), (((FeedDetailsPresenter)this.a.a.s()).r()).promotion_url, 0);
                        return;
                      } 
                      if (fragmentActivity.equalsIgnoreCase(FeedDetailsFragment.a(this.a.a).getResources().getString(2131756224))) {
                        EventTrackFeed.a(FeedProtos.Event.FEED_SETTING_DYNAMIC_SKIN_SETTINGS_BTN_CLICK, (((FeedDetailsPresenter)this.a.a.s()).r()).feed_id);
                        DynamicSkinFragment.a(FeedDetailsFragment.a(this.a.a), 0, "feed_dynamic_skin_setting_main");
                        return;
                      } 
                      if (FeedDetailsFragment.a(this.a.a).getResources().getString(2131756223).equals(fragmentActivity)) {
                        EventTrackFeed.a(FeedProtos.Event.FEED_SETTING_DYNAMIC_SKIN_LOOK_BTN_CLICK, (((FeedDetailsPresenter)this.a.a.s()).r()).feed_id);
                        DynamicSkinFragment.a(FeedDetailsFragment.a(this.a.a), 0, "feed_dynamic_skin_look_guest");
                      } 
                    } 
                  }
                  
                  public void a(ActionSheet param2ActionSheet, boolean param2Boolean) {}
                });
          }
        });
  }
  
  private void M() {
    int i = (this.n.getResources().getDisplayMetrics()).widthPixels;
    this.t = new LoadOptions();
    LoadOptions loadOptions = this.t;
    loadOptions.d = 2131231369;
    loadOptions.b = 2131231369;
    i >>= 1;
    loadOptions.a(i, i);
    this.u = AppInfo.l - DensityUtils.a(this.n, 10.0F) * 2;
    i = this.u;
    this.v = (int)(i * 1.5D);
    this.w = i;
    this.x = (int)(i * 0.73D);
  }
  
  private void N() {
    b(new Runnable(this) {
          public void run() {
            this.a.editView.setFocusable(true);
            this.a.editView.setFocusableInTouchMode(true);
            KeyboardUtils.c((Activity)this.a.getActivity());
          }
        },  300L);
  }
  
  private void O() {
    b(new Runnable(this) {
          public void run() {
            this.a.cslView.scrollTo(0, this.a.feed.getHeight() - this.a.refreshLayout.getHeight() / 2);
            this.a.b(new Runnable(this) {
                  public void run() {
                    FeedDetailsFragment.f(this.a.a).a();
                  }
                },  100L);
          }
        }300L);
  }
  
  private void P() {
    ((FeedDetailsPresenter)s()).c(true);
    ((FeedDetailsPresenter)s()).h("");
    ((FeedDetailsPresenter)s()).g("");
    this.editView.setText(null);
    this.editView.setHint(FeedMethods.a(this.n));
    this.layoutComment.setVisibility(8);
    this.keyboardView.setVisibility(8);
    if (this.emoticonLayoutRoot.getVisibility() != 8)
      this.emoticonLayoutRoot.setVisibility(8); 
    this.layoutLikeShare.setVisibility(0);
    KeyboardUtils.a((Activity)getActivity());
    this.editView.clearFocus();
  }
  
  private void a(int paramInt, boolean paramBoolean) {
    if (paramInt == 0) {
      this.iconLike.setTag(null);
      this.iconLike.setImageDrawable(BluedSkinUtils.b(this.n, 2131232487));
    } else if (1 == paramInt) {
      if (paramBoolean) {
        this.iconLike.setTag("anim");
        ImageLoader.c((IRequestHost)w_(), FeedMethods.a()).f().a(new ImageLoader.OnAnimationStateListener(this) {
              public void a() {}
              
              public void b() {
                if (this.a.iconLike != null && this.a.iconLike.getTag() != null)
                  ImageLoader.a((IRequestHost)this.a.w_(), 2131232488).a(this.a.iconLike); 
              }
            }).a(this.iconLike);
      } else {
        this.iconLike.setTag(null);
        ImageLoader.a((IRequestHost)w_(), 2131232488).a(this.iconLike);
      } 
    } 
    this.r.notifyDataSetChanged();
  }
  
  public static void a(Context paramContext, BluedIngSelfFeed paramBluedIngSelfFeed, int paramInt1, int paramInt2) {
    a(paramContext, paramBluedIngSelfFeed, paramInt1, paramInt2, false);
  }
  
  public static void a(Context paramContext, BluedIngSelfFeed paramBluedIngSelfFeed, int paramInt1, int paramInt2, boolean paramBoolean) {
    a(paramContext, paramBluedIngSelfFeed, "", paramInt1, paramInt2, paramBoolean);
  }
  
  public static void a(Context paramContext, BluedIngSelfFeed paramBluedIngSelfFeed, String paramString, int paramInt) {
    a(paramContext, paramBluedIngSelfFeed, paramString, paramInt, 0, false);
  }
  
  public static void a(Context paramContext, BluedIngSelfFeed paramBluedIngSelfFeed, String paramString, int paramInt1, int paramInt2, boolean paramBoolean) {
    Bundle bundle = new Bundle();
    bundle.putSerializable("feed_data", (Serializable)paramBluedIngSelfFeed);
    bundle.putString("feed_comment_id", paramString);
    bundle.putInt("show_photo", paramInt2);
    bundle.putInt("from", paramInt1);
    bundle.putInt("feed_is_ads", paramBluedIngSelfFeed.is_ads);
    bundle.putString("feed_aid", paramBluedIngSelfFeed.aid);
    bundle.putBoolean("if_from_comment", paramBoolean);
    TerminalActivity.a(bundle);
    TerminalActivity.d(paramContext, FeedDetailsFragment.class, bundle);
  }
  
  private void a(Bitmap paramBitmap) {
    String str;
    int i = ((FeedDetailsPresenter)s()).w();
    if (i != 0) {
      if (i != 6) {
        str = "";
      } else {
        str = "discovery_square_detail";
      } 
    } else {
      str = "discovery_attention_detail";
    } 
    ShareUtils.a().a(this.n, (View)this.videoView, null, paramBitmap, ((FeedDetailsPresenter)s()).r(), str, false, ((FeedDetailsPresenter)s()).x(), "", -1, 2);
  }
  
  private void a(View paramView, TextViewFixTouchForDynamic paramTextViewFixTouchForDynamic, CharSequence paramCharSequence) {
    paramTextViewFixTouchForDynamic.setText(paramCharSequence);
    paramTextViewFixTouchForDynamic.setMovementMethod((MovementMethod)LinkMovementClickMethod.a());
    paramView.setOnLongClickListener(new View.OnLongClickListener(this, paramTextViewFixTouchForDynamic) {
          public boolean onLongClick(View param1View) {
            String str = this.a.getText().toString();
            if (Build.VERSION.SDK_INT >= 11 && Build.VERSION.SDK_INT != 18) {
              ((ClipboardManager)FeedDetailsFragment.a(this.b).getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("simple text", RegExpUtils.a(str)));
            } else {
              ((ClipboardManager)FeedDetailsFragment.a(this.b).getSystemService("clipboard")).setText(RegExpUtils.a(str));
            } 
            AppMethods.a(FeedDetailsFragment.a(this.b).getResources().getString(2131756130));
            return true;
          }
        });
  }
  
  private void a(BluedIngSelfFeed paramBluedIngSelfFeed) {
    if (paramBluedIngSelfFeed == null)
      return; 
    this.q.a(((FeedDetailsPresenter)s()).w());
    this.q.a(paramBluedIngSelfFeed);
    this.r.a(paramBluedIngSelfFeed);
    this.s.a(paramBluedIngSelfFeed);
    this.p.a(paramBluedIngSelfFeed.theme_id);
    this.p.b(paramBluedIngSelfFeed.theme_pendant);
    q(paramBluedIngSelfFeed);
    s(paramBluedIngSelfFeed);
    x(paramBluedIngSelfFeed);
    y(paramBluedIngSelfFeed);
    r(paramBluedIngSelfFeed);
    p(paramBluedIngSelfFeed);
    o(paramBluedIngSelfFeed);
    n(paramBluedIngSelfFeed);
    l(paramBluedIngSelfFeed);
    c(paramBluedIngSelfFeed);
    b(paramBluedIngSelfFeed);
  }
  
  private void a(List<BluedIngSelfFeed> paramList) {
    this.p.c(paramList);
  }
  
  private void b(int paramInt) {
    ((FeedDetailsPresenter)s()).c(paramInt);
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt == 2) {
          ShapeHelper.b((ShapeHelper.ShapeView)this.llLike, 2131100881);
          ShapeHelper.b((ShapeHelper.ShapeView)this.llComment, 2131100881);
          ShapeHelper.b((ShapeHelper.ShapeView)this.llRepost, 2131100882);
          this.zanText.setTextColor(BluedSkinUtils.a(this.n, 2131100844));
          this.zanNumText.setTextColor(BluedSkinUtils.a(this.n, 2131100844));
          this.commentText.setTextColor(BluedSkinUtils.a(this.n, 2131100844));
          this.commentNumText.setTextColor(BluedSkinUtils.a(this.n, 2131100844));
          this.repostText.setTextColor(BluedSkinUtils.a(this.n, 2131100838));
          this.repostNumText.setTextColor(BluedSkinUtils.a(this.n, 2131100838));
          this.recyclerView.setAdapter((RecyclerView.Adapter)this.s);
          this.s.notifyDataSetChanged();
          if (this.s.n().size() > 0 && (((FeedDetailsPresenter)s()).A()).c) {
            x();
          } else {
            y();
          } 
          this.llRecommendMore.setVisibility(8);
          this.rvFeed.setVisibility(8);
        } 
      } else {
        ShapeHelper.b((ShapeHelper.ShapeView)this.llLike, 2131100881);
        ShapeHelper.b((ShapeHelper.ShapeView)this.llComment, 2131100882);
        ShapeHelper.b((ShapeHelper.ShapeView)this.llRepost, 2131100881);
        this.zanText.setTextColor(BluedSkinUtils.a(this.n, 2131100844));
        this.zanNumText.setTextColor(BluedSkinUtils.a(this.n, 2131100844));
        this.commentText.setTextColor(BluedSkinUtils.a(this.n, 2131100838));
        this.commentNumText.setTextColor(BluedSkinUtils.a(this.n, 2131100838));
        this.repostText.setTextColor(BluedSkinUtils.a(this.n, 2131100844));
        this.repostNumText.setTextColor(BluedSkinUtils.a(this.n, 2131100844));
        this.recyclerView.setAdapter((RecyclerView.Adapter)this.q);
        this.q.notifyDataSetChanged();
        if (((FeedDetailsPresenter)s()).v()) {
          if (this.p.n().size() > 0 && (((FeedDetailsPresenter)s()).A()).d) {
            x();
          } else {
            y();
          } 
        } else if (this.q.n().size() > 0 && (((FeedDetailsPresenter)s()).A()).b) {
          x();
        } else {
          y();
        } 
        this.llRecommendMore.setVisibility(0);
        if (this.q.n().size() > 0) {
          this.tvRecommend.setText(2131756401);
        } else {
          this.tvRecommend.setText(2131756402);
        } 
        if (this.p.n().size() > 0) {
          this.tvRecommend.setVisibility(0);
          this.recommendLine.setVisibility(0);
        } else {
          this.tvRecommend.setVisibility(8);
          this.recommendLine.setVisibility(8);
        } 
        if (this.q.n().size() > 0 && ((((FeedDetailsPresenter)s()).A()).b || ((FeedDetailsPresenter)s()).B())) {
          EventTrackFeed.a(FeedProtos.Event.FEED_DETAIL_COMMENT_MORE_SHOW, (((FeedDetailsPresenter)s()).r()).feed_id);
          this.llMoreComment.setVisibility(0);
        } else {
          this.llMoreComment.setVisibility(8);
        } 
        this.rvFeed.setVisibility(0);
      } 
    } else {
      ShapeHelper.b((ShapeHelper.ShapeView)this.llLike, 2131100882);
      ShapeHelper.b((ShapeHelper.ShapeView)this.llComment, 2131100881);
      ShapeHelper.b((ShapeHelper.ShapeView)this.llRepost, 2131100881);
      this.zanText.setTextColor(BluedSkinUtils.a(this.n, 2131100838));
      this.zanNumText.setTextColor(BluedSkinUtils.a(this.n, 2131100838));
      this.commentText.setTextColor(BluedSkinUtils.a(this.n, 2131100844));
      this.commentNumText.setTextColor(BluedSkinUtils.a(this.n, 2131100844));
      this.repostText.setTextColor(BluedSkinUtils.a(this.n, 2131100844));
      this.repostNumText.setTextColor(BluedSkinUtils.a(this.n, 2131100844));
      this.recyclerView.setAdapter((RecyclerView.Adapter)this.r);
      this.r.notifyDataSetChanged();
      if (this.r.n().size() > 0 && (((FeedDetailsPresenter)s()).A()).a) {
        x();
      } else {
        y();
      } 
      this.llRecommendMore.setVisibility(8);
      this.rvFeed.setVisibility(8);
    } 
    c(paramInt);
  }
  
  private void b(BluedIngSelfFeed paramBluedIngSelfFeed) {
    if (!paramBluedIngSelfFeed.isShowUrlVisited) {
      boolean bool1;
      String str1;
      FeedProtos.Event event = FeedProtos.Event.FEED_DETAIL_PAGE_SOURCE;
      String str2 = paramBluedIngSelfFeed.feed_id;
      if (TextUtils.isEmpty(paramBluedIngSelfFeed.super_did)) {
        str1 = "";
      } else {
        str1 = paramBluedIngSelfFeed.super_did;
      } 
      FeedProtos.FeedClass feedClass = EventTrackFeed.a(paramBluedIngSelfFeed);
      FeedProtos.FeedPage feedPage = EventTrackFeed.b(((FeedDetailsPresenter)s()).w());
      String str3 = paramBluedIngSelfFeed.feed_uid;
      int i = paramBluedIngSelfFeed.in_promotion;
      boolean bool3 = false;
      if (i == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      boolean bool2 = bool3;
      if (paramBluedIngSelfFeed.feed_pics != null) {
        bool2 = bool3;
        if (paramBluedIngSelfFeed.feed_pics.length > 1)
          bool2 = true; 
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramBluedIngSelfFeed.join_circle_id);
      stringBuilder.append("");
      EventTrackFeed.a(event, str2, str1, feedClass, feedPage, str3, bool1, bool2, stringBuilder.toString(), "");
      paramBluedIngSelfFeed.isShowUrlVisited = true;
    } 
  }
  
  private void b(List<FeedComment> paramList) {
    this.q.c(paramList);
  }
  
  private void c(int paramInt) {
    if (((FeedDetailsPresenter)s()).p() == paramInt) {
      if (paramInt != 0) {
        if (paramInt != 1) {
          if (paramInt != 2)
            return; 
          if (this.s.n().size() <= 0) {
            if ((((FeedDetailsPresenter)s()).A()).g) {
              this.ivNoData.setImageResource(2131232466);
              this.tvNoData.setText(2131756115);
            } else {
              this.ivNoData.setImageResource(2131232641);
              this.tvNoData.setText(2131758231);
            } 
            this.llNoData.setVisibility(0);
            if ((((FeedDetailsPresenter)s()).A()).c) {
              this.llRefresh.setVisibility(0);
              this.llNoData.setVisibility(8);
              return;
            } 
            this.llRefresh.setVisibility(8);
            return;
          } 
          this.llRefresh.setVisibility(8);
          this.llNoData.setVisibility(8);
          return;
        } 
        if (this.q.n().size() <= 0) {
          if ((((FeedDetailsPresenter)s()).A()).f) {
            this.ivNoData.setImageResource(2131232466);
            this.tvNoData.setText(2131756115);
          } else {
            this.ivNoData.setImageResource(2131232635);
            this.tvNoData.setText(2131758231);
          } 
          this.llNoData.setVisibility(0);
          if ((((FeedDetailsPresenter)s()).A()).b) {
            this.llNoData.setVisibility(8);
            this.llRefresh.setVisibility(0);
            return;
          } 
          this.llRefresh.setVisibility(8);
          return;
        } 
        this.llRefresh.setVisibility(8);
        this.llNoData.setVisibility(8);
        return;
      } 
      if (this.r.n().size() <= 0) {
        if ((((FeedDetailsPresenter)s()).A()).e) {
          this.ivNoData.setImageResource(2131232466);
          this.tvNoData.setText(2131756115);
        } else {
          this.ivNoData.setImageResource(2131232638);
          this.tvNoData.setText(2131758231);
        } 
        this.llNoData.setVisibility(0);
        if ((((FeedDetailsPresenter)s()).A()).a) {
          this.llRefresh.setVisibility(0);
          this.llNoData.setVisibility(8);
          return;
        } 
        this.llRefresh.setVisibility(8);
        return;
      } 
      this.llRefresh.setVisibility(8);
      this.llNoData.setVisibility(8);
    } 
  }
  
  private void c(BluedIngSelfFeed paramBluedIngSelfFeed) {
    this.cvImageOne.setVisibility(8);
    this.imageTwoFour.setVisibility(8);
    this.imageOther.setVisibility(8);
    this.cardVideo.setVisibility(8);
    this.cvWebShare.setVisibility(8);
    this.cardVote.setVisibility(8);
    int i = paramBluedIngSelfFeed.getItemType();
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i != 4)
            if (i != 8) {
              if (i != 10) {
                if (i != 15) {
                  if (i != 17) {
                    h(paramBluedIngSelfFeed.getContentData());
                    return;
                  } 
                  d(paramBluedIngSelfFeed.getContentData());
                  return;
                } 
                e(paramBluedIngSelfFeed.getContentData());
                return;
              } 
            } else {
              j(paramBluedIngSelfFeed.getContentData());
              return;
            }  
          k(paramBluedIngSelfFeed.getContentData());
          return;
        } 
        i(paramBluedIngSelfFeed.getContentData());
        return;
      } 
      f(paramBluedIngSelfFeed.getContentData());
      return;
    } 
    g(paramBluedIngSelfFeed.getContentData());
  }
  
  private void c(List<BluedRecommendUsers> paramList) {
    this.r.c(paramList);
  }
  
  private void d(BluedIngSelfFeed paramBluedIngSelfFeed) {
    this.cvWebShare.setVisibility(0);
    if (((FeedDetailsPresenter)s()).t()) {
      this.cvWebShare.setCardBackgroundColor(BluedSkinUtils.a(this.n, 2131100882));
    } else {
      this.cvWebShare.setCardBackgroundColor(BluedSkinUtils.a(this.n, 2131100881));
    } 
    ImageLoader.a((IRequestHost)w_(), paramBluedIngSelfFeed.join_circle_pic).a(2131231369).c(2131231280).a(this.imgWebShare);
    this.tvWebShareContent.setText(paramBluedIngSelfFeed.join_circle_title);
    this.tvWebShareDesc.setText(paramBluedIngSelfFeed.join_circle_description);
    TextView textView = this.tvWebShareTitleRight;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramBluedIngSelfFeed.members_num);
    stringBuilder.append(this.n.getString(2131757871));
    textView.setText(stringBuilder.toString());
    this.cvWebShare.setOnClickListener(new -$$Lambda$FeedDetailsFragment$eFUy1MXsa4M-RiTjbi5AN4Gxwwk(this, paramBluedIngSelfFeed));
  }
  
  private void d(List<FeedRepost> paramList) {
    this.s.c(paramList);
  }
  
  private void e(BluedIngSelfFeed paramBluedIngSelfFeed) {
    this.cvWebShare.setVisibility(0);
    this.viewCircleCorner.setVisibility(0);
    if (((FeedDetailsPresenter)s()).t()) {
      this.cvWebShare.setCardBackgroundColor(BluedSkinUtils.a(this.n, 2131100882));
    } else {
      this.cvWebShare.setCardBackgroundColor(BluedSkinUtils.a(this.n, 2131100881));
    } 
    ImageLoader.a((IRequestHost)w_(), paramBluedIngSelfFeed.share_circle_posting_pic).a(2131231369).c(2131231280).a(this.imgWebShare);
    this.tvWebShareContent.setText(paramBluedIngSelfFeed.share_circle_title);
    if (!TextUtils.isEmpty(paramBluedIngSelfFeed.share_circle_posting_content)) {
      this.tvWebShareDesc.setText(paramBluedIngSelfFeed.share_circle_posting_content);
    } else {
      this.tvWebShareDesc.setText(this.n.getResources().getString(2131755943));
    } 
    this.cvWebShare.setOnClickListener(new -$$Lambda$FeedDetailsFragment$FJQcsMsWaPCCi7oa77LSPtNxuGI(this, paramBluedIngSelfFeed));
  }
  
  private void f(BluedIngSelfFeed paramBluedIngSelfFeed) {
    this.imageOther.setVisibility(0);
    FeedDetailsPhotoAdapter feedDetailsPhotoAdapter = new FeedDetailsPhotoAdapter(this.n, (IRequestHost)w_(), paramBluedIngSelfFeed, this.t, (View)this.llDetailsShare, ((FeedDetailsPresenter)s()).z());
    this.imageOther.setAdapter((ListAdapter)feedDetailsPhotoAdapter);
  }
  
  private void g(BluedIngSelfFeed paramBluedIngSelfFeed) {
    this.imageTwoFour.setVisibility(0);
    FeedDetailsPhotoAdapter feedDetailsPhotoAdapter = new FeedDetailsPhotoAdapter(this.n, (IRequestHost)w_(), paramBluedIngSelfFeed, this.t, (View)this.llDetailsShare, ((FeedDetailsPresenter)s()).z());
    this.imageTwoFour.setAdapter((ListAdapter)feedDetailsPhotoAdapter);
  }
  
  private void h(BluedIngSelfFeed paramBluedIngSelfFeed) {
    byte b1;
    byte b2;
    if (paramBluedIngSelfFeed.feed_pics == null || paramBluedIngSelfFeed.feed_pics.length <= 0) {
      this.cvImageOne.setVisibility(8);
      this.imageOne.setVisibility(8);
      ((ViewGroup.MarginLayoutParams)this.contentView.getLayoutParams()).bottomMargin = DensityUtils.a(this.n, 2.0F);
      return;
    } 
    this.cvImageOne.setVisibility(0);
    this.imageOne.setVisibility(0);
    ((ViewGroup.MarginLayoutParams)this.contentView.getLayoutParams()).bottomMargin = DensityUtils.a(this.n, 10.0F);
    if (paramBluedIngSelfFeed.feed_pics_width != null && paramBluedIngSelfFeed.feed_pics_width.length > 0 && paramBluedIngSelfFeed.feed_pics_height != null && paramBluedIngSelfFeed.feed_pics_height.length > 0) {
      b1 = StringUtils.a(paramBluedIngSelfFeed.feed_pics_width[0], 0);
      b2 = StringUtils.a(paramBluedIngSelfFeed.feed_pics_height[0], 0);
    } else {
      b1 = 0;
      b2 = 0;
    } 
    int[] arrayOfInt = ImageUtils.a(b1, b2, this.u, this.v, this.w, this.x);
    ViewGroup.LayoutParams layoutParams = this.imageOne.getLayoutParams();
    layoutParams.width = arrayOfInt[0];
    boolean bool = true;
    layoutParams.height = arrayOfInt[1];
    this.imageOne.setLayoutParams(layoutParams);
    String str2 = paramBluedIngSelfFeed.feed_pics[0];
    int i = layoutParams.width;
    if (b1 != b2)
      bool = false; 
    String str1 = AvatarUtils.a(str2, i, bool);
    if (b2 > b1 * 3) {
      this.stvLongPicIcon.setVisibility(0);
      str1 = paramBluedIngSelfFeed.getImageMogr(false);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramBluedIngSelfFeed.feed_pics[0]);
      stringBuilder.append(str1);
      str1 = stringBuilder.toString();
    } else {
      this.stvLongPicIcon.setVisibility(8);
    } 
    ImageLoader.a((IRequestHost)w_(), str1).a(2131231369).a(2131231369).a(this.imageOne);
    this.llDetailsShare.setTag(paramBluedIngSelfFeed.feed_pics[0]);
    this.imageOne.setOnClickListener(new View.OnClickListener(this, paramBluedIngSelfFeed) {
          public void onClick(View param1View) {
            LogData logData = new LogData();
            logData.n = this.a.feed_id;
            logData.g = "5";
            logData.J = "feed_pic_click";
            logData.k = this.a.recommend_text;
            InstantLog.a(logData);
            if (this.a.feed_pics != null && this.a.feed_pics.length > 0)
              BasePhotoFragment.a(FeedDetailsFragment.a(this.b), this.a.feed_pics, 0, 0, FeedDetailsFragment.g(this.b), ((FeedDetailsPresenter)this.b.s()).z(), (View)this.b.imageOne, this.a.feed_pics[0]); 
          }
        });
  }
  
  private void i(BluedIngSelfFeed paramBluedIngSelfFeed) {
    if (paramBluedIngSelfFeed.feed_videos.length >= 2) {
      this.cardVideo.setVisibility(0);
      if (paramBluedIngSelfFeed.feed_videos_width == null || paramBluedIngSelfFeed.feed_videos_height == null) {
        paramBluedIngSelfFeed.feed_videos_width = new String[] { "480" };
        paramBluedIngSelfFeed.feed_videos_height = new String[] { "480" };
      } 
      if (paramBluedIngSelfFeed.feed_videos_width.length == 0 || paramBluedIngSelfFeed.feed_videos_height.length == 0) {
        paramBluedIngSelfFeed.feed_videos_width = new String[] { "480" };
        paramBluedIngSelfFeed.feed_videos_height = new String[] { "480" };
      } 
      if (paramBluedIngSelfFeed.feed_videos_width.length == 0 || paramBluedIngSelfFeed.feed_videos_height.length == 0) {
        paramBluedIngSelfFeed.feed_videos_width = new String[] { "480" };
        paramBluedIngSelfFeed.feed_videos_height = new String[] { "480" };
      } 
      String str1 = paramBluedIngSelfFeed.feed_videos_width[0];
      int j = 480;
      int i = StringUtils.a(str1, 480);
      int k = StringUtils.a(paramBluedIngSelfFeed.feed_videos_height[0], 480);
      if (i == 0 || k == 0) {
        i = 480;
      } else {
        j = k;
      } 
      k = AppInfo.l - AppMethods.a(18);
      float f = i / j;
      int m = (int)(k / f);
      FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(k, m);
      layoutParams.gravity = 1;
      this.videoView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      String[] arrayOfString = paramBluedIngSelfFeed.feed_videos;
      String str2 = paramBluedIngSelfFeed.feed_video_size;
      VideoPlayConfig videoPlayConfig = new VideoPlayConfig();
      videoPlayConfig.a = paramBluedIngSelfFeed.feed_videos[0];
      videoPlayConfig.b = paramBluedIngSelfFeed.feed_videos[1];
      videoPlayConfig.e = k;
      videoPlayConfig.f = m;
      videoPlayConfig.a(i);
      videoPlayConfig.b(j);
      try {
        videoPlayConfig.c = Integer.parseInt(paramBluedIngSelfFeed.feed_video_size);
      } catch (Exception exception) {
        Logger.b(FeedDetailsFragment.class.getSimpleName(), new Object[] { "setContentView() Integer.parseInt(feed.feed_video_size) Exception" });
      } 
      videoPlayConfig.g = new View.OnClickListener(this, arrayOfString, str2, paramBluedIngSelfFeed) {
          public void onClick(View param1View) {
            String[] arrayOfString = this.a;
            if (arrayOfString != null && arrayOfString.length >= 2) {
              if (AudioChannelManager.e().h()) {
                AppMethods.a(FeedDetailsFragment.a(this.d).getResources().getText(2131759450));
                return;
              } 
              if (!TextUtils.isEmpty(this.b))
                try {
                  Float.parseFloat(this.b);
                } catch (Exception exception) {
                  exception.printStackTrace();
                }  
              boolean bool = true;
              InstantLog.a("feed_video_play", Integer.valueOf(1));
              BluedIngSelfFeed bluedIngSelfFeed = (BluedIngSelfFeed)this.c.clone();
              if (((FeedDetailsPresenter)this.d.s()).w() == 1) {
                bluedIngSelfFeed.feed_uid = (((FeedDetailsPresenter)this.d.s()).r()).feed_uid;
                bluedIngSelfFeed.feed_id = (((FeedDetailsPresenter)this.d.s()).r()).feed_id;
                VideoUserInfoFragment.a(FeedDetailsFragment.a(this.d), bluedIngSelfFeed);
                return;
              } 
              if (((FeedDetailsPresenter)this.d.s()).w() != 5)
                bool = false; 
              VideoScanFragment.a(FeedDetailsFragment.a(this.d), bluedIngSelfFeed, bool, 2);
            } 
          }
        };
      this.videoView.b(videoPlayConfig);
      b(new Runnable(this) {
            public void run() {
              if (this.a.videoView != null)
                this.a.videoView.c(); 
            }
          });
    } 
  }
  
  private void j(BluedIngSelfFeed paramBluedIngSelfFeed) {
    if (paramBluedIngSelfFeed.feed_pics == null || paramBluedIngSelfFeed.feed_pics.length <= 0) {
      this.cardVote.setVisibility(8);
      return;
    } 
    this.cardVote.setVisibility(0);
    String str = paramBluedIngSelfFeed.feed_pics[0];
    int[] arrayOfInt = ImageUtils.a(StringUtils.a(paramBluedIngSelfFeed.feed_pics_width[0], 0), StringUtils.a(paramBluedIngSelfFeed.feed_pics_height[0], 0), this.u, this.v, this.w, this.x);
    this.feedVote.a((IRequestHost)w_(), AvatarUtils.a(str, arrayOfInt[0]));
    this.feedLocation.setVisibility(0);
    this.voteNumLayout.setVisibility(0);
    TextView textView = this.voteText;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getString(2131756460));
    stringBuilder.append("：");
    stringBuilder.append(paramBluedIngSelfFeed.vote_count);
    textView.setText(stringBuilder.toString());
    if (paramBluedIngSelfFeed.ivoted != 0) {
      boolean bool;
      FeedVoteGroup feedVoteGroup = this.feedVote;
      if (paramBluedIngSelfFeed.ivoted == 1) {
        bool = true;
      } else {
        bool = false;
      } 
      feedVoteGroup.a(true, bool);
      int i = (int)(paramBluedIngSelfFeed.a_vote_count / paramBluedIngSelfFeed.vote_count * 100.0F);
      this.feedVote.a(i, 100 - i);
    } else {
      this.feedVote.setVote(false);
    } 
    this.feedVote.setOnViewClickListener(new FeedVoteGroup.OnViewClickListener(this, paramBluedIngSelfFeed, str) {
          public void a(boolean param1Boolean) {
            BluedIngSelfFeed bluedIngSelfFeed = this.a;
            bluedIngSelfFeed.is_vote = 1;
            bluedIngSelfFeed.vote_count++;
            if (param1Boolean) {
              EventTrackVote.a(VoteProtos.Event.VOTE_FEED_CHOOSE_PHOTO_CLICK, VoteProtos.PhotoOption.PHOTO_A, this.a.feed_uid, this.a.feed_id);
              bluedIngSelfFeed = this.a;
              bluedIngSelfFeed.a_vote_count++;
              this.a.ivoted = 1;
            } else {
              EventTrackVote.a(VoteProtos.Event.VOTE_FEED_CHOOSE_PHOTO_CLICK, VoteProtos.PhotoOption.PHOTO_B, this.a.feed_uid, this.a.feed_id);
              bluedIngSelfFeed = this.a;
              bluedIngSelfFeed.b_vote_count++;
              this.a.ivoted = 2;
            } 
            this.c.feedVote.a(true, param1Boolean);
            int i = (int)(this.a.a_vote_count / this.a.vote_count * 100.0F);
            this.c.feedVote.a(i, 100 - i);
            this.c.feedVote.a((IRequestHost)this.c.w_());
            ((FeedDetailsPresenter)this.c.s()).b(param1Boolean);
          }
          
          public void b(boolean param1Boolean) {
            EventTrackVote.a(VoteProtos.Event.VOTE_FEED_ENLARGE_PHOTO_CLICK, this.a.feed_uid, this.a.feed_id);
            Context context = FeedDetailsFragment.a(this.c);
            String str1 = this.b;
            LoadOptions loadOptions = FeedDetailsFragment.g(this.c);
            String str2 = this.a.user_name;
            String str3 = this.b;
            BasePhotoFragment.a(context, new String[] { str1 }, 0, 0, loadOptions, str2, null, str3);
          }
        });
    this.llDetailsShare.setTag(str);
    this.feedVote.setVisibility(0);
  }
  
  private void k(BluedIngSelfFeed paramBluedIngSelfFeed) {
    this.cvWebShare.setVisibility(0);
    if (((FeedDetailsPresenter)s()).t()) {
      this.cvWebShare.setCardBackgroundColor(BluedSkinUtils.a(this.n, 2131100882));
    } else {
      this.cvWebShare.setCardBackgroundColor(BluedSkinUtils.a(this.n, 2131100881));
    } 
    if (paramBluedIngSelfFeed != null && paramBluedIngSelfFeed.is_url == 1 && paramBluedIngSelfFeed.feed_extras != null) {
      if (paramBluedIngSelfFeed.feed_extras.thumb != null && paramBluedIngSelfFeed.feed_extras.thumb.size() > 0) {
        ImageLoader.a((IRequestHost)w_(), ((String)paramBluedIngSelfFeed.feed_extras.thumb.get(0)).replace(";", "")).a(2131231369).a(this.imgWebShare);
        this.llDetailsShare.setTag(((String)paramBluedIngSelfFeed.feed_extras.thumb.get(0)).replace(";", ""));
      } 
      if (!StringUtils.e(paramBluedIngSelfFeed.feed_extras.title))
        this.tvWebShareContent.setText(paramBluedIngSelfFeed.feed_extras.title); 
      this.cvWebShare.setOnClickListener(new -$$Lambda$FeedDetailsFragment$TshnM9UPW-2rXeHVsXH-3xULXbg(this, paramBluedIngSelfFeed));
      return;
    } 
    if (paramBluedIngSelfFeed != null && (paramBluedIngSelfFeed.is_share_super_topics == 1 || (paramBluedIngSelfFeed.isRepost() && paramBluedIngSelfFeed.repost.is_share_super_topics == 1))) {
      BluedIngSelfFeed bluedIngSelfFeed = paramBluedIngSelfFeed;
      if (paramBluedIngSelfFeed.isRepost())
        bluedIngSelfFeed = paramBluedIngSelfFeed.repost; 
      this.cvWebShare.setOnClickListener(new -$$Lambda$FeedDetailsFragment$Z-AXYj4TolfTuZJFGevEdQk-crs(this, bluedIngSelfFeed));
      ImageLoader.a((IRequestHost)w_(), bluedIngSelfFeed.share_s_t_avatar).a(2131231369).a(this.imgWebShare);
      this.llDetailsShare.setTag(bluedIngSelfFeed.share_s_t_avatar);
      this.tvWebShareContent.setText(bluedIngSelfFeed.share_s_t_name);
      this.cvWebShare.setVisibility(0);
      this.viewTopicCorner.setVisibility(0);
      return;
    } 
    if (paramBluedIngSelfFeed != null && paramBluedIngSelfFeed.repost != null && paramBluedIngSelfFeed.repost.is_url == 1) {
      this.cvWebShare.setOnClickListener(new -$$Lambda$FeedDetailsFragment$1ve_bwV2NYRQgCLF9iKrxTP-xAU(this, paramBluedIngSelfFeed));
      if (paramBluedIngSelfFeed.repost.feed_extras.thumb != null && paramBluedIngSelfFeed.repost.feed_extras.thumb.size() > 0) {
        ImageLoader.a((IRequestHost)w_(), ((String)paramBluedIngSelfFeed.repost.feed_extras.thumb.get(0)).replace(";", "")).a(2131231369).a(this.imgWebShare);
        this.llDetailsShare.setTag(((String)paramBluedIngSelfFeed.repost.feed_extras.thumb.get(0)).replace(";", ""));
      } 
      if (!StringUtils.e(paramBluedIngSelfFeed.repost.feed_extras.title))
        this.tvWebShareContent.setText(paramBluedIngSelfFeed.repost.feed_extras.title); 
      this.cvWebShare.setVisibility(0);
      return;
    } 
    this.cvWebShare.setVisibility(8);
  }
  
  private void l(BluedIngSelfFeed paramBluedIngSelfFeed) {
    if (UserInfo.a().i().getUid().equals(paramBluedIngSelfFeed.feed_uid) || "1".equalsIgnoreCase(paramBluedIngSelfFeed.relationship) || "3".equalsIgnoreCase(paramBluedIngSelfFeed.relationship)) {
      this.followStatusView.setVisibility(8);
      return;
    } 
    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)this.followStatusView.getLayoutParams();
    marginLayoutParams.rightMargin = DensityUtils.a(this.n, 10.0F);
    this.followStatusView.setLayoutParams((ViewGroup.LayoutParams)marginLayoutParams);
    this.followStatusView.setOnClickListener(new View.OnClickListener(this, paramBluedIngSelfFeed) {
          public void onClick(View param1View) {
            if (this.a.relationship == "1") {
              this.b.nameView.callOnClick();
              return;
            } 
            FeedDetailsFragment.c(this.b, this.a);
          }
        });
    this.followStatusView.setVisibility(0);
    this.followStatusView.setRelationShip("0");
  }
  
  private void m(BluedIngSelfFeed paramBluedIngSelfFeed) {
    boolean bool1;
    boolean bool2;
    String str1;
    this.followStatusView.setRelationShip("1");
    UserHttpUtils.b(this.n, new UserRelationshipUtils.IAddOrRemoveAttentionDone(this, paramBluedIngSelfFeed) {
          public void a() {}
          
          public void a(String param1String) {
            AppMethods.d(2131756542);
            this.a.relationship = "1";
          }
          
          public void b() {}
          
          public void b(String param1String) {}
          
          public void c() {
            this.b.followStatusView.setRelationShip("0");
          }
        }paramBluedIngSelfFeed.feed_uid, "shine_video_list", (IRequestHost)w_());
    FeedProtos.FollowLocation followLocation = FeedProtos.FollowLocation.FOLLOW_PLAZA_FEED_DETAIL;
    if (TextUtils.isEmpty(paramBluedIngSelfFeed.super_did)) {
      str1 = "";
    } else {
      str1 = paramBluedIngSelfFeed.super_did;
    } 
    FeedProtos.Event event = FeedProtos.Event.OTHER_FOLLOW_CLICK;
    String str2 = paramBluedIngSelfFeed.feed_uid;
    String str3 = paramBluedIngSelfFeed.feed_id;
    if (paramBluedIngSelfFeed.live > 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (paramBluedIngSelfFeed.in_promotion == 1) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    EventTrackFeed.a(event, str2, str3, str1, followLocation, true, bool1, bool2);
  }
  
  private void n(BluedIngSelfFeed paramBluedIngSelfFeed) {
    if (!UserInfo.a().i().getUid().equals(paramBluedIngSelfFeed.feed_uid)) {
      this.llReadNum.setVisibility(8);
      return;
    } 
    this.llReadNum.setVisibility(0);
    this.tvReadNum.setText(StringUtils.a(String.valueOf(paramBluedIngSelfFeed.feed_show)));
    this.llReadNum.setOnClickListener(new View.OnClickListener(this, paramBluedIngSelfFeed) {
          public void onClick(View param1View) {
            if (!TextUtils.isEmpty(this.a.promotion_url))
              InstantLog.a("feed_read_count_click", Integer.valueOf(5)); 
            WebViewShowInfoFragment.show(FeedDetailsFragment.a(this.b), this.a.promotion_url, 0);
          }
        });
    if (paramBluedIngSelfFeed.can_promotion == 1) {
      this.ivReadExtend.setVisibility(0);
      return;
    } 
    this.ivReadExtend.setVisibility(8);
  }
  
  private void o(BluedIngSelfFeed paramBluedIngSelfFeed) {
    if (!TextUtils.isEmpty(paramBluedIngSelfFeed.location)) {
      this.feedLocation.setVisibility(0);
      this.locationLayout.setVisibility(0);
      this.locationText.setText(paramBluedIngSelfFeed.location);
      this.locationLayout.setOnClickListener(new View.OnClickListener(this, paramBluedIngSelfFeed) {
            public void onClick(View param1View) {
              ShowPositionActivity.a(FeedDetailsFragment.a(this.b), this.a.location_lot, this.a.location_lat, this.a.location, 1);
            }
          });
      return;
    } 
    this.feedLocation.setVisibility(8);
    this.locationLayout.setVisibility(8);
  }
  
  private void p(BluedIngSelfFeed paramBluedIngSelfFeed) {
    if (paramBluedIngSelfFeed.is_super_topics == 1 && !TextUtils.isEmpty(paramBluedIngSelfFeed.super_topics_name)) {
      this.layoutSuperTopic.setVisibility(0);
      this.tvSuperTopic.setText(paramBluedIngSelfFeed.super_topics_name);
      this.sllSuperTopic.setOnClickListener(new View.OnClickListener(this, paramBluedIngSelfFeed) {
            public void onClick(View param1View) {
              EventTrackFeed.a(FeedProtos.Event.FEED_SUPER_TOPIC_ENTER_CLICK, this.a.feed_id, this.a.super_did, FeedProtos.FeedTopicPage.FEED_TOPIC_FEED_DETAIL);
              if (this.a.super_topics_status == 0) {
                AppMethods.d(2131758967);
                return;
              } 
              SuperTopicDetailFragment.a(FeedDetailsFragment.a(this.b), this.a.super_did);
            }
          });
      return;
    } 
    this.layoutSuperTopic.setVisibility(8);
  }
  
  private void q(BluedIngSelfFeed paramBluedIngSelfFeed) {
    if (paramBluedIngSelfFeed.is_vote == 1) {
      this.llLike.setVisibility(8);
      this.feedLike.setVisibility(8);
    } else {
      this.llLike.setVisibility(0);
      this.feedLike.setVisibility(0);
    } 
    if ((paramBluedIngSelfFeed.isRepost() && paramBluedIngSelfFeed.repost.feed_is_delete == 1) || paramBluedIngSelfFeed.disallow_share == 1) {
      this.iconShare.setImageDrawable(BluedSkinUtils.b(getContext(), 2131232501));
      this.llDetailsShare.setEnabled(false);
    } else {
      this.iconShare.setImageDrawable(BluedSkinUtils.b(this.n, 2131232497));
      this.llDetailsShare.setEnabled(true);
    } 
    if (paramBluedIngSelfFeed.reading_scope != 0 && paramBluedIngSelfFeed.is_vote != 1) {
      this.llDetailsShare.setVisibility(8);
    } else {
      this.llDetailsShare.setVisibility(0);
    } 
    a(paramBluedIngSelfFeed.iliked, paramBluedIngSelfFeed.isPlayLikeAnim);
  }
  
  private void r(BluedIngSelfFeed paramBluedIngSelfFeed) {
    int i = paramBluedIngSelfFeed.feed_comment;
    if (i > 0) {
      this.commentNumText.setVisibility(0);
      this.commentNumText.setText(AreaUtils.a(this.n, Integer.toString(i)));
    } else {
      this.commentNumText.setVisibility(8);
    } 
    i = paramBluedIngSelfFeed.feed_dig;
    if (i > 0) {
      this.zanNumText.setText(AreaUtils.a(this.n, Integer.toString(i)));
      this.zanNumText.setVisibility(0);
    } else {
      this.zanNumText.setVisibility(8);
    } 
    i = paramBluedIngSelfFeed.repost_count;
    if (i > 0) {
      this.repostNumText.setText(AreaUtils.a(this.n, Integer.toString(i)));
      this.repostNumText.setVisibility(0);
      return;
    } 
    this.repostNumText.setVisibility(8);
  }
  
  private void s(BluedIngSelfFeed paramBluedIngSelfFeed) {
    this.menuView.setVisibility(8);
    this.menuView.setEnabled(false);
    if (!StringUtils.e(paramBluedIngSelfFeed.feed_uid) && paramBluedIngSelfFeed.feed_uid.equals(UserInfo.a().i().getUid())) {
      this.feedVisible.setVisibility(0);
      FeedMethods.a(this.n, paramBluedIngSelfFeed.reading_scope, this.ivVisible, this.tvVisible);
    } else {
      this.feedVisible.setVisibility(8);
    } 
    ImageLoader.a((IRequestHost)w_(), AvatarUtils.a(0, paramBluedIngSelfFeed.user_avatar)).a(2131234356).c().a(this.headerView);
    UserRelationshipUtils.a(this.imgVerify, paramBluedIngSelfFeed.vbadge, 3);
    if (!StringUtils.e(paramBluedIngSelfFeed.user_name)) {
      if (!StringUtils.e(paramBluedIngSelfFeed.note)) {
        this.nameView.setText(StringUtils.a(paramBluedIngSelfFeed.note, paramBluedIngSelfFeed.user_name));
      } else {
        this.nameView.setText(paramBluedIngSelfFeed.user_name);
      } 
    } else {
      this.nameView.setText("");
    } 
    if (paramBluedIngSelfFeed.live > 0) {
      this.imgVerify.setVisibility(8);
      this.imgLivingAnim.setVisibility(0);
    } else {
      UserRelationshipUtils.a(this.imgVerify, paramBluedIngSelfFeed.vbadge, 3);
      this.imgLivingAnim.setVisibility(8);
    } 
    UserBasicModel userBasicModel = new UserBasicModel();
    userBasicModel.vip_grade = paramBluedIngSelfFeed.vip_grade;
    userBasicModel.is_vip_annual = paramBluedIngSelfFeed.is_vip_annual;
    userBasicModel.is_hide_vip_look = paramBluedIngSelfFeed.is_hide_vip_look;
    userBasicModel.vip_exp_lvl = paramBluedIngSelfFeed.vip_exp_lvl;
    UserRelationshipUtils.a(this.n, this.nameView, userBasicModel);
    UserRelationshipUtils.a(this.imgBluedMedal, userBasicModel);
    View.OnClickListener onClickListener = new View.OnClickListener(this, paramBluedIngSelfFeed, FeedMethods.a(2, paramBluedIngSelfFeed.is_vote)) {
        public void onClick(View param1View) {
          MessageProtos.StrangerSource strangerSource;
          UserBasicModel userBasicModel = new UserBasicModel();
          userBasicModel.uid = this.a.feed_uid;
          userBasicModel.name = this.a.user_name;
          userBasicModel.avatar = this.a.user_avatar;
          userBasicModel.is_show_vip_page = this.a.is_show_vip_page;
          if (this.a.live > 0) {
            UserRelationshipUtils.a(FeedDetailsFragment.a(this.c), userBasicModel, this.a.live, this.b);
            return;
          } 
          String str = EncryptTool.b(this.a.feed_id);
          if (this.a.in_promotion == 1) {
            strangerSource = MessageProtos.StrangerSource.APPRECIATE_SUPER_EXPOSURE;
          } else {
            strangerSource = MessageProtos.StrangerSource.FEED_DETAIL;
          } 
          LogData logData = new LogData();
          logData.I = this.a.feed_id;
          UserInfoFragmentNew.a(FeedDetailsFragment.a(this.c), userBasicModel, this.b, (View)this.c.headerView, logData, new MsgSourceEntity(strangerSource, str));
          if (this.a.click_url != null && this.a.click_url.length > 0)
            for (int i = 0; i < this.a.click_url.length; i++)
              FindHttpUtils.a(this.a.click_url[i]);  
        }
      };
    this.nameView.setOnClickListener(onClickListener);
    this.headerView.setOnClickListener(onClickListener);
    t(paramBluedIngSelfFeed);
    u(paramBluedIngSelfFeed);
  }
  
  private void t(BluedIngSelfFeed paramBluedIngSelfFeed) {
    if (w(paramBluedIngSelfFeed)) {
      this.dynamicSkin.setVisibility(0);
      ImageLoader.a((IRequestHost)w_(), DynamicSkinManager.a().a(paramBluedIngSelfFeed.theme_id)).a(this.dynamicSkin);
      this.dynamicSkin.setOnClickListener(new -$$Lambda$FeedDetailsFragment$i4TCIIeHxrtgfCoYt8vnRcv032w(this));
      return;
    } 
    this.dynamicSkin.setVisibility(8);
  }
  
  private void u(BluedIngSelfFeed paramBluedIngSelfFeed) {
    if (v(paramBluedIngSelfFeed)) {
      this.avatarWidget.setVisibility(0);
      ImageLoader.a((IRequestHost)w_(), AvatarWidgetManager.a().a(paramBluedIngSelfFeed.theme_pendant)).a(this.avatarWidget);
      return;
    } 
    this.avatarWidget.setVisibility(8);
  }
  
  private boolean v(BluedIngSelfFeed paramBluedIngSelfFeed) {
    return (paramBluedIngSelfFeed.theme_pendant != 0);
  }
  
  private boolean w(BluedIngSelfFeed paramBluedIngSelfFeed) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("hasDynamicSkin feed.theme_id:");
    stringBuilder.append(paramBluedIngSelfFeed.theme_id);
    Log.v("drb", stringBuilder.toString());
    return (paramBluedIngSelfFeed.theme_id != 0);
  }
  
  private void x(BluedIngSelfFeed paramBluedIngSelfFeed) {
    boolean bool1;
    int i = paramBluedIngSelfFeed.is_recommend_ticktocks;
    boolean bool2 = true;
    if (i == 1) {
      String str;
      this.distanceView.setVisibility(8);
      this.tvFeedRecommendSource.setVisibility(0);
      TextView textView = this.tvFeedRecommendSource;
      if (!TextUtils.isEmpty(paramBluedIngSelfFeed.recommend_text)) {
        str = paramBluedIngSelfFeed.recommend_text;
      } else {
        str = this.n.getString(2131756501);
      } 
      textView.setText(str);
    } else {
      this.tvFeedRecommendSource.setVisibility(8);
      if (UserInfo.a().i().getUid().equals(paramBluedIngSelfFeed.feed_uid)) {
        this.distanceView.setVisibility(8);
      } else {
        this.distanceView.setVisibility(0);
        String str = paramBluedIngSelfFeed.getFeedParse(this.n, ((FeedDetailsPresenter)s()).w()).getDistance();
        if (!TextUtils.isEmpty(str)) {
          this.distanceView.setText(str);
        } else {
          this.distanceView.setText("");
          this.distanceView.setVisibility(8);
        } 
        DistanceUtils.a(this.n, this.distanceView, paramBluedIngSelfFeed.is_hide_distance, 0, false);
      } 
    } 
    if (!TextUtils.isEmpty(paramBluedIngSelfFeed.feed_timestamp)) {
      String str = TimeAndDateUtils.e(this.n, TimeAndDateUtils.b(paramBluedIngSelfFeed.feed_timestamp));
      if (!StringUtils.e(str)) {
        this.timeView.setText(str);
      } else {
        this.timeView.setText("");
      } 
    } else {
      this.timeView.setText("");
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.timeView.getText());
    stringBuilder.append("");
    if (!StringUtils.e(stringBuilder.toString())) {
      this.timeView.setVisibility(0);
    } else {
      this.timeView.setVisibility(4);
    } 
    if (this.tvFeedRecommendSource.getVisibility() == 0) {
      i = 1;
    } else {
      i = 0;
    } 
    if (this.distanceView.getVisibility() == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (this.timeView.getVisibility() != 0)
      bool2 = false; 
    if (i != 0 && (bool1 || bool2)) {
      this.dotIconRecommend.setVisibility(0);
    } else {
      this.dotIconRecommend.setVisibility(8);
    } 
    if (bool1 && bool2) {
      this.dotIconDistance.setVisibility(0);
    } else {
      this.dotIconDistance.setVisibility(8);
    } 
    if (this.distanceView.getVisibility() != 0 && this.timeView.getVisibility() != 0) {
      this.llDistanceAndTime.setVisibility(8);
      return;
    } 
    this.llDistanceAndTime.setVisibility(0);
  }
  
  private void y(BluedIngSelfFeed paramBluedIngSelfFeed) {
    if (((FeedDetailsPresenter)s()).t()) {
      this.repostLayout.setVisibility(0);
      ShapeHelper.b((ShapeHelper.ShapeView)this.llContentAll, 2131100881);
      int i = DensityUtils.a(this.n, 10.0F);
      this.llContentAll.setPadding(i, i, i, i);
    } else {
      this.repostLayout.setVisibility(8);
      ShapeHelper.b((ShapeHelper.ShapeView)this.llContentAll, 2131100897);
      this.llContentAll.setPadding(0, 0, 0, 0);
    } 
    if (((FeedDetailsPresenter)s()).t()) {
      TextViewFixTouchForDynamic textViewFixTouchForDynamic = this.repostContentView;
      a((View)textViewFixTouchForDynamic, textViewFixTouchForDynamic, ((FeedDetailsPresenter)s()).s().getFeedRepostContent());
      this.contentView.setVisibility(0);
      a((View)this.llContentAll, this.contentView, ((FeedDetailsPresenter)s()).s().getFeedContent());
      this.llContentAll.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              FeedDetailsFragment.a(FeedDetailsFragment.a(this.a), ((FeedDetailsPresenter)this.a.s()).u(), -1, ((FeedDetailsPresenter)this.a.s()).y(), false);
            }
          });
      return;
    } 
    if (!TextUtils.isEmpty((((FeedDetailsPresenter)s()).u()).feed_content)) {
      a((View)this.llContentAll, this.contentView, ((FeedDetailsPresenter)s()).s().getFeedContent());
      this.contentView.setVisibility(0);
      return;
    } 
    this.contentView.setVisibility(8);
  }
  
  public void E() {
    getActivity().finish();
  }
  
  public boolean V_() {
    if (this.emoticonLayoutRoot.getVisibility() == 0) {
      P();
      return true;
    } 
    return false;
  }
  
  public void a(int paramInt) {
    if (paramInt != -3) {
      if (paramInt != -2)
        return; 
      if (this.emoticonLayoutRoot.getVisibility() != 0) {
        this.layoutComment.setVisibility(0);
        this.layoutLikeShare.setVisibility(8);
        return;
      } 
      if (!this.editView.isFocusable()) {
        this.keyboardView.setVisibility(8);
        return;
      } 
    } else {
      this.layoutComment.setVisibility(0);
      this.layoutLikeShare.setVisibility(8);
      this.keyboardView.setVisibility(0);
      this.keyboardView.setOnTouchListener(new View.OnTouchListener(this) {
            public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
              FeedDetailsFragment.h(this.a);
              this.a.keyboardView.setOnTouchListener(null);
              return true;
            }
          });
      this.editView.setFocusable(true);
      this.editView.setFocusableInTouchMode(true);
      this.editView.requestFocus();
    } 
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    this.n = getContext();
    this.o = new AtChooseUserHelper(this.n);
    M();
    L();
    K();
    J();
    H();
    G();
    F();
    this.r.a();
    this.q.c();
    this.s.a();
    ((FeedDetailsPresenter)s()).e();
  }
  
  public void a(BluedADExtra paramBluedADExtra) {
    this.bannerLine.setVisibility(0);
    this.bannerAD.a((IRequestHost)w_(), paramBluedADExtra, ADConstants.AD_POSITION.j, new BannerADView.ADListener(this) {
          public void a() {
            this.a.bannerAD.setVisibility(8);
            this.a.bannerLine.setVisibility(8);
          }
          
          public void b() {
            if (this.a.bannerAD != null && this.a.bannerLine != null) {
              this.a.bannerAD.setVisibility(8);
              this.a.bannerLine.setVisibility(8);
            } 
          }
        });
  }
  
  public void a(String paramString, List paramList) {
    super.a(paramString, paramList);
    if (paramString == null)
      return; 
    byte b = -1;
    switch (paramString.hashCode()) {
      case 2067290277:
        if (paramString.equals("show_ad"))
          b = 10; 
        break;
      case 1238832461:
        if (paramString.equals("scroll_to_comment"))
          b = 5; 
        break;
      case 795385470:
        if (paramString.equals("comment_list"))
          b = 7; 
        break;
      case 640708618:
        if (paramString.equals("repost_list"))
          b = 9; 
        break;
      case -163848122:
        if (paramString.equals("like_list"))
          b = 8; 
        break;
      case -191572620:
        if (paramString.equals("feed_tab"))
          b = 1; 
        break;
      case -258118695:
        if (paramString.equals("init_edit"))
          b = 3; 
        break;
      case -864760547:
        if (paramString.equals("feed_no_data_tab"))
          b = 2; 
        break;
      case -1644013921:
        if (paramString.equals("feed_list"))
          b = 6; 
        break;
      case -1644259925:
        if (paramString.equals("feed_data"))
          b = 0; 
        break;
      case -2051025175:
        if (paramString.equals("show_keyboard"))
          b = 4; 
        break;
    } 
    switch (b) {
      default:
        return;
      case 10:
        MvpUtils.a(paramList, BluedADExtra.class, new MvpUtils.DataHandler<BluedADExtra>(this) {
              public void a() {
                this.a.bannerAD.setVisibility(8);
              }
              
              public void a(BluedADExtra param1BluedADExtra) {
                this.a.a(param1BluedADExtra);
              }
            });
        return;
      case 9:
        MvpUtils.a(paramList, FeedRepost.class, new MvpUtils.DataListHandler<FeedRepost>(this) {
              public void a() {}
              
              public void a(List<FeedRepost> param1List) {
                FeedDetailsFragment.d(this.a, param1List);
              }
            });
        return;
      case 8:
        MvpUtils.a(paramList, BluedRecommendUsers.class, new MvpUtils.DataListHandler<BluedRecommendUsers>(this) {
              public void a() {}
              
              public void a(List<BluedRecommendUsers> param1List) {
                FeedDetailsFragment.c(this.a, param1List);
              }
            });
        return;
      case 7:
        MvpUtils.a(paramList, FeedComment.class, new MvpUtils.DataListHandler<FeedComment>(this) {
              public void a() {}
              
              public void a(List<FeedComment> param1List) {
                FeedDetailsFragment.b(this.a, param1List);
              }
            });
        return;
      case 6:
        MvpUtils.a(paramList, BluedIngSelfFeed.class, new MvpUtils.DataListHandler<BluedIngSelfFeed>(this) {
              public void a() {}
              
              public void a(List<BluedIngSelfFeed> param1List) {
                FeedDetailsFragment.a(this.a, param1List);
              }
            });
        return;
      case 5:
        O();
        return;
      case 4:
        N();
        return;
      case 3:
        P();
        return;
      case 2:
        MvpUtils.a(paramList, Integer.class, new MvpUtils.DataHandler<Integer>(this) {
              public void a() {}
              
              public void a(Integer param1Integer) {
                FeedDetailsFragment.b(this.a, param1Integer.intValue());
              }
            });
        return;
      case 1:
        MvpUtils.a(paramList, Integer.class, new MvpUtils.DataHandler<Integer>(this) {
              public void a() {}
              
              public void a(Integer param1Integer) {
                FeedDetailsFragment.a(this.a, param1Integer.intValue());
              }
            });
        return;
      case 0:
        break;
    } 
    MvpUtils.a(paramList, BluedIngSelfFeed.class, new MvpUtils.DataHandler<BluedIngSelfFeed>(this) {
          public void a() {
            FeedDetailsFragment feedDetailsFragment = this.a;
            FeedDetailsFragment.b(feedDetailsFragment, ((FeedDetailsPresenter)feedDetailsFragment.s()).r());
          }
          
          public void a(BluedIngSelfFeed param1BluedIngSelfFeed) {
            FeedDetailsFragment.b(this.a, param1BluedIngSelfFeed);
          }
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
    if (b == 0 || b == 1) {
      this.refreshLayout.g();
      this.refreshLayout.h();
    } 
    if (paramString.equals("_load_type_refresh_"))
      b(((FeedDetailsPresenter)s()).p()); 
    if (((FeedDetailsPresenter)s()).p() == 1 && this.q.n().size() > 0 && ((((FeedDetailsPresenter)s()).A()).b || ((FeedDetailsPresenter)s()).B())) {
      EventTrackFeed.a(FeedProtos.Event.FEED_DETAIL_COMMENT_MORE_SHOW, (((FeedDetailsPresenter)s()).r()).feed_id);
      this.llMoreComment.setVisibility(0);
      return;
    } 
    this.llMoreComment.setVisibility(8);
  }
  
  public void aL_() {
    super.aL_();
    this.r.b();
    this.q.d();
    this.s.b();
  }
  
  public void o() {
    super.o();
    getActivity().getWindow().setSoftInputMode(16);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramInt2 == -1) {
      if (paramInt1 != 100) {
        if (paramInt1 == 9090) {
          this.o.a(this.editView, paramIntent, this.z);
          b(new Runnable(this) {
                public void run() {
                  this.a.editView.requestFocus();
                  KeyboardUtils.c((Activity)this.a.getActivity());
                }
              },  300L);
        } 
      } else if (paramIntent != null && !StringUtils.e("string_edit")) {
        String str1 = paramIntent.getStringExtra("string_edit");
        String str2 = paramIntent.getStringExtra("feed_id");
        ((FeedDetailsPresenter)s()).c(str2, str1);
      } 
    } else if (paramInt1 == 9090) {
      b(new Runnable(this) {
            public void run() {
              this.a.editView.requestFocus();
              KeyboardUtils.c((Activity)this.a.getActivity());
            }
          },  300L);
    } 
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onPause() {
    super.onPause();
    if (((FeedDetailsPresenter)s()).r().getItemType() == 3) {
      PLVideoPageView pLVideoPageView = this.videoView;
      if (pLVideoPageView != null)
        pLVideoPageView.g(); 
    } 
    this.p.c();
    this.q.b();
    this.imgLivingAnim.a();
  }
  
  public void onResume() {
    super.onResume();
    if (((FeedDetailsPresenter)s()).r().getItemType() == 3) {
      PLVideoPageView pLVideoPageView = this.videoView;
      if (pLVideoPageView != null)
        pLVideoPageView.f(); 
    } 
    this.p.b();
  }
  
  public int p() {
    return 2131493121;
  }
  
  public void x() {
    super.x();
    this.refreshLayout.b(true);
  }
  
  public void y() {
    super.y();
    this.refreshLayout.b(false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\fragment\FeedDetailsFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */