package com.soft.blued.ui.feed.fragment;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Space;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.ui.custom.KeyboardListenLinearLayout;
import com.blued.android.framework.ui.custom.MvpKeyBoardFragment;
import com.blued.android.framework.ui.custom.SwitchPanelRelativeLayout;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.utils.RegExpUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.das.client.feed.FeedProtos;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.soft.blued.customview.ActionSheet;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.emoticon.manager.EmotionManager;
import com.soft.blued.emoticon.model.EmoticonModel;
import com.soft.blued.emoticon.model.EmoticonPackageModel;
import com.soft.blued.emoticon.ui.EmoticonsIndicatorView;
import com.soft.blued.emoticon.ui.EmoticonsPageView;
import com.soft.blued.emoticon.ui.EmoticonsToolBarView;
import com.soft.blued.emoticon.ui.IViewStateListener;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.circle.model.CircleMethods;
import com.soft.blued.ui.feed.adapter.CommentListAdapter;
import com.soft.blued.ui.feed.manager.FeedMethods;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.feed.model.FeedComment;
import com.soft.blued.ui.feed.presenter.CommentPresenter;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.msg.customview.Emotion;
import com.soft.blued.ui.photo.fragment.BasePhotoFragment;
import com.soft.blued.ui.user.fragment.ReportFragmentNew;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.AreaUtils;
import com.soft.blued.utils.AtChooseUserHelper;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TimeAndDateUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.soft.blued.view.tip.CommonShowBottomWindow;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CommentFragment extends MvpKeyBoardFragment<CommentPresenter> implements View.OnClickListener {
  @BindView(2131296666)
  CheckBox cbAnonymousComment;
  
  @BindView(2131296971)
  EditText editView;
  
  @BindView(2131296983)
  LinearLayout emoticonLayout;
  
  @BindView(2131296984)
  SwitchPanelRelativeLayout emoticonLayoutRoot;
  
  @BindView(2131297083)
  FrameLayout flAnonymousComment;
  
  @BindView(2131297397)
  ImageView iconEmoji;
  
  @BindView(2131297596)
  LinearLayout inputLayoutUp;
  
  @BindView(2131297733)
  ImageView ivCommentHeader;
  
  @BindView(2131297982)
  KeyboardListenLinearLayout keyboardLayout;
  
  @BindView(2131297985)
  View keyboardView;
  
  @BindView(2131298043)
  LinearLayout layoutAlbum;
  
  @BindView(2131298052)
  LinearLayout layoutCommentAll;
  
  @BindView(2131298144)
  ListView listView;
  
  private Unbinder n;
  
  private HeaderViewHolder o = new HeaderViewHolder(this);
  
  private BluedIngSelfFeed p;
  
  private CommentListAdapter q;
  
  private Context r;
  
  @BindView(2131299616)
  SmartRefreshLayout refreshLayout;
  
  private AtChooseUserHelper s;
  
  @BindView(2131299890)
  ShapeTextView sendBtn;
  
  @BindView(2131300002)
  Space spaceWithHeader;
  
  private Emotion t;
  
  @BindView(2131300293)
  View topBar;
  
  @BindView(2131300300)
  CommonTopTitleNoTrans topTitle;
  
  private TextWatcher u = new TextWatcher(this) {
      private int b;
      
      private int c;
      
      private String d;
      
      private String e;
      
      public void afterTextChanged(Editable param1Editable) {
        this.b = this.a.editView.getSelectionStart();
        this.c = this.a.editView.getSelectionEnd();
        this.a.editView.removeTextChangedListener(this);
        if (((CommentPresenter)this.a.s()).C() && !CommentFragment.e(this.a).a(this.a, this.d, this.e, param1Editable, this.c))
          this.a.editView.setSelection(this.b); 
        this.a.editView.addTextChangedListener(this);
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
  
  @BindView(2131301642)
  EmoticonsIndicatorView viewEiv;
  
  @BindView(2131301643)
  EmoticonsPageView viewEpv;
  
  @BindView(2131301644)
  EmoticonsToolBarView viewEtv;
  
  private void G() {
    ViewGroup.LayoutParams layoutParams = this.topBar.getLayoutParams();
    layoutParams.height = StatusBarHelper.a(getContext());
    this.topBar.setLayoutParams(layoutParams);
    this.topTitle.setLeftClickListener(new -$$Lambda$CommentFragment$Zzx74QBoBXQHOHV7_vNMSEJULZQ(this));
    this.topTitle.setCenterText(((CommentPresenter)s()).o());
    this.topTitle.setCenterTextColor(2131100838);
    this.topTitle.setRightImg(2131232753);
    this.topTitle.setRightClickListener(new -$$Lambda$CommentFragment$vZtcKQ6ntj3aOFVNfR59LzfJB-0(this));
  }
  
  private void H() {
    this.refreshLayout.setBackgroundColor(BluedSkinUtils.a(this.r, 2131100728));
    this.listView.setBackgroundColor(BluedSkinUtils.a(this.r, 2131100881));
    this.q = new CommentListAdapter(this.r, (IRequestHost)w_(), this.p, new -$$Lambda$CommentFragment$GOly0yQ525DwFRgsKjPGd-50fpg(this), ((CommentPresenter)s()).p(), ((CommentPresenter)s()).n());
    this.q.a(((CommentPresenter)s()).z());
    this.listView.setAdapter((ListAdapter)this.q);
    this.refreshLayout.a(new OnRefreshLoadMoreListener(this) {
          public void a(RefreshLayout param1RefreshLayout) {
            ((CommentPresenter)this.a.s()).f();
          }
          
          public void onRefresh(RefreshLayout param1RefreshLayout) {
            ((CommentPresenter)this.a.s()).e();
          }
        });
  }
  
  private void I() {
    View view = LayoutInflater.from(this.r).inflate(2131493740, null);
    this.n = ButterKnife.a(this.o, view);
    this.o.imgHeader.setOnClickListener(this);
    this.o.nameView.setOnClickListener(this);
    this.o.imgLike.setOnClickListener(this);
    this.o.tvLikeCount.setOnClickListener(this);
    view.setOnLongClickListener(new View.OnLongClickListener(this, view) {
          public boolean onLongClick(View param1View) {
            KeyboardUtils.b(CommentFragment.a(this.b), this.a);
            CommentFragment.b(this.b);
            return true;
          }
        });
    view.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            ((CommentPresenter)this.a.s()).w();
            CommentFragment.c(this.a);
          }
        });
    this.o.noDataView.setBackgroundColorRes(2131100881);
    this.o.noDataView.setNoDataImg(2131232635);
    this.o.noDataView.c();
    view.setBackgroundColor(BluedSkinUtils.a(this.r, 2131100728));
    this.o.rlComment.setVisibility(8);
    this.listView.addHeaderView(view);
    this.listView.setHeaderDividersEnabled(false);
  }
  
  private void J() {
    String str = this.r.getResources().getString(2131758580);
    EditText editText = this.editView;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append(((CommentPresenter)s()).v());
    stringBuilder.append(":");
    editText.setHint(stringBuilder.toString());
    this.editView.requestFocus();
    KeyboardUtils.c((Activity)getActivity());
  }
  
  private void K() {
    a((View)this.emoticonLayoutRoot, this.keyboardLayout, this.editView, (View)this.emoticonLayout);
    this.s = new AtChooseUserHelper(this.r);
    this.t = new Emotion(this.r);
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
    this.viewEpv.setIViewListener(new IViewStateListener(this) {
          public void a(EmoticonModel param1EmoticonModel) {
            if (this.a.editView != null) {
              KeyEvent keyEvent;
              SpannableString spannableString;
              this.a.editView.setFocusable(true);
              this.a.editView.setFocusableInTouchMode(true);
              this.a.editView.requestFocus();
              if (param1EmoticonModel.eventType == 1L) {
                keyEvent = new KeyEvent(0, 67);
                this.a.editView.onKeyDown(67, keyEvent);
                return;
              } 
              if (((EmoticonModel)keyEvent).eventType == 2L)
                return; 
              if (((EmoticonModel)keyEvent).emoji == null) {
                spannableString = CommentFragment.d(this.a).a(((EmoticonModel)keyEvent).code);
                this.a.editView.getText().insert(this.a.editView.getSelectionStart(), (CharSequence)spannableString);
                return;
              } 
              this.a.editView.append(((EmoticonModel)spannableString).emoji.a());
            } 
          }
          
          public void c(int param1Int) {
            this.a.viewEtv.setToolBtnSelect(param1Int);
          }
        });
    this.viewEtv.setOnToolBarItemClickListener(new EmoticonsToolBarView.OnToolBarItemClickListener(this) {
          public void a(int param1Int) {
            this.a.viewEpv.setPageSelect(param1Int);
          }
        });
    this.editView.setHint(FeedMethods.a(this.r));
    this.editView.setFilters(new InputFilter[] { (InputFilter)new InputFilter.LengthFilter(256) });
    this.editView.addTextChangedListener(this.u);
    this.editView.setOnFocusChangeListener(new View.OnFocusChangeListener(this) {
          public void onFocusChange(View param1View, boolean param1Boolean) {
            if (param1Boolean)
              EventTrackFeed.a(FeedProtos.Event.FEED_COMMENT_BOX_CLICK, ((CommentPresenter)this.a.s()).r(), FeedProtos.Location.COMMENT_DETAIL); 
          }
        });
    if (((CommentPresenter)s()).B()) {
      String str = AvatarUtils.a(1, UserInfo.a().i().getAvatar());
      ImageLoader.a((IRequestHost)w_(), str).a(2131234356).c(2131234356).c().a(this.ivCommentHeader);
      this.cbAnonymousComment.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this, str) {
            public void onCheckedChanged(CompoundButton param1CompoundButton, boolean param1Boolean) {
              if (param1Boolean) {
                ImageLoader.a((IRequestHost)this.b.w_(), (((CommentPresenter)this.b.s()).m()).anonym_avatar).a(CircleMethods.getAnonymousHeaderRes(this.b.getContext(), ((CommentPresenter)this.b.s()).y())).c(CircleMethods.getAnonymousHeaderRes(this.b.getContext(), ((CommentPresenter)this.b.s()).y())).a(this.b.ivCommentHeader);
                return;
              } 
              ImageLoader.a((IRequestHost)this.b.w_(), this.a).a(2131234356).c(2131234356).c().a(this.b.ivCommentHeader);
            }
          });
      this.flAnonymousComment.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              if (!this.a.cbAnonymousComment.isEnabled()) {
                if ((((CommentPresenter)this.a.s()).m()).anonym_comment == 1) {
                  AppMethods.d(2131755844);
                  return;
                } 
                AppMethods.d(2131755841);
              } 
            }
          });
      E();
      this.cbAnonymousComment.setVisibility(0);
    } else {
      this.cbAnonymousComment.setVisibility(8);
    } 
    this.ivCommentHeader.setVisibility(8);
    this.spaceWithHeader.setVisibility(8);
  }
  
  private void L() {
    FeedComment feedComment = ((CommentPresenter)s()).q();
    if (feedComment == null)
      return; 
    ArrayList<String> arrayList = new ArrayList();
    arrayList.add(this.r.getResources().getString(2131758501));
    if (!((CommentPresenter)s()).s())
      arrayList.add(this.r.getResources().getString(2131758584)); 
    CommonShowBottomWindow.a((FragmentActivity)this.r, arrayList.<String>toArray(new String[arrayList.size()]), new ActionSheet.ActionSheetListener(this, feedComment) {
          public void a(ActionSheet param1ActionSheet, int param1Int) {
            String str = param1ActionSheet.a(param1Int);
            if (str.equals(CommentFragment.a(this.b).getResources().getString(2131758501))) {
              this.b.c(this.a.comment_content);
              return;
            } 
            if (str.equals(CommentFragment.a(this.b).getResources().getString(2131758584))) {
              if (((CommentPresenter)this.b.s()).B()) {
                ReportFragmentNew.b(CommentFragment.a(this.b), (((CommentPresenter)this.b.s()).q()).comment_id, this.a.feed_id, this.a.user_name);
                return;
              } 
              ReportFragmentNew.a(CommentFragment.a(this.b), (((CommentPresenter)this.b.s()).q()).comment_id, this.a.feed_id, this.a.user_name);
            } 
          }
          
          public void a(ActionSheet param1ActionSheet, boolean param1Boolean) {}
        });
  }
  
  private void M() {
    a(new Runnable(this) {
          public void run() {
            if (!this.a.editView.isFocusable())
              this.a.editView.requestFocus(); 
            KeyboardUtils.c((Activity)this.a.getActivity());
          }
        },  300L);
  }
  
  private void N() {
    if (((CommentPresenter)s()).B()) {
      Intent intent = new Intent();
      intent.putExtra("comment_state", ((CommentPresenter)s()).x());
      getActivity().setResult(-1, intent);
    } 
    getActivity().finish();
  }
  
  public static void a(Context paramContext, String paramString1, FeedComment paramFeedComment, BluedIngSelfFeed paramBluedIngSelfFeed, String paramString2, int paramInt) {
    Bundle bundle = new Bundle();
    bundle.putString("title", paramString1);
    bundle.putString("feed_id", paramFeedComment.feed_id);
    bundle.putString("comment_id", paramFeedComment.comment_id);
    bundle.putSerializable("feed_data", (Serializable)paramBluedIngSelfFeed);
    bundle.putInt("from", paramInt);
    TerminalActivity.a(bundle);
    TerminalActivity.d(paramContext, CommentFragment.class, bundle);
  }
  
  public static void a(Context paramContext, String paramString1, FeedComment paramFeedComment, BluedIngSelfFeed paramBluedIngSelfFeed, String paramString2, int paramInt1, int paramInt2, int paramInt3) {
    Bundle bundle = new Bundle();
    bundle.putString("title", paramString1);
    bundle.putString("feed_id", paramFeedComment.feed_id);
    bundle.putString("comment_id", paramFeedComment.comment_id);
    bundle.putString("circle_id", paramBluedIngSelfFeed.circle_id);
    bundle.putSerializable("feed_data", (Serializable)paramBluedIngSelfFeed);
    bundle.putInt("from", paramInt2);
    bundle.putInt("anonymous_header_number", paramInt1);
    bundle.putBoolean("can_at", paramBluedIngSelfFeed.isPrivateCircle() ^ true);
    TerminalActivity.a(bundle);
    TerminalActivity.a(paramContext, CommentFragment.class, bundle, paramInt3);
  }
  
  private void b(boolean paramBoolean) {
    this.refreshLayout.g();
    this.refreshLayout.h();
    c(paramBoolean);
  }
  
  private void c(FeedComment paramFeedComment) {
    int i;
    this.o.rlComment.setVisibility(0);
    UserRelationshipUtils.a(this.o.imgVerify, paramFeedComment.vbadge, 3);
    ImageLoader.a((IRequestHost)w_(), paramFeedComment.user_avatar).a(2131234356).c().a(this.o.imgHeader);
    if (!TextUtils.isEmpty(paramFeedComment.comment_timestamp)) {
      this.o.timeView.setText(TimeAndDateUtils.i(this.r, TimeAndDateUtils.b(paramFeedComment.comment_timestamp)));
    } else {
      this.o.timeView.setText("");
    } 
    if (!TextUtils.isEmpty(paramFeedComment.user_name)) {
      if (!TextUtils.isEmpty(paramFeedComment.note)) {
        this.o.nameView.setText(StringUtils.a(paramFeedComment.note, paramFeedComment.user_name.replace(":", "")));
      } else {
        this.o.nameView.setText(paramFeedComment.user_name.replace(":", ""));
      } 
    } else {
      this.o.nameView.setText("");
    } 
    UserBasicModel userBasicModel = new UserBasicModel();
    userBasicModel.vip_grade = paramFeedComment.vip_grade;
    userBasicModel.is_vip_annual = paramFeedComment.is_vip_annual;
    userBasicModel.is_hide_vip_look = paramFeedComment.is_hide_vip_look;
    userBasicModel.vip_exp_lvl = paramFeedComment.vip_exp_lvl;
    UserRelationshipUtils.a(this.r, this.o.nameView, userBasicModel);
    UserRelationshipUtils.a(this.o.imgVIPIcon, userBasicModel);
    if (((CommentPresenter)s()).A()) {
      FeedMethods.a(this.o.ivLevel, paramFeedComment.is_author);
    } else {
      CircleMethods.setLevelMark(this.o.ivLevel, paramFeedComment.admin_level, paramFeedComment.is_author);
    } 
    ImageView imageView = this.o.ivAnonymous;
    if (paramFeedComment.is_anonym == 1) {
      i = 0;
    } else {
      i = 8;
    } 
    imageView.setVisibility(i);
    if (!TextUtils.isEmpty(paramFeedComment.is_reply)) {
      if ("1".equals(paramFeedComment.is_reply)) {
        FeedMethods.a(this.r, this.o.contentView, paramFeedComment, ((CommentPresenter)s()).p(), 2131100716);
      } else if ("0".equals(paramFeedComment.is_reply)) {
        FeedMethods.a(this.o.contentView, paramFeedComment, ((CommentPresenter)s()).p());
      } else {
        this.o.contentView.setText("");
      } 
    } else {
      this.o.contentView.setText("");
    } 
    if (paramFeedComment.comment_pics != null && paramFeedComment.comment_pics.length > 0) {
      this.o.ll_img.setVisibility(0);
      i = (this.r.getResources().getDisplayMetrics()).widthPixels;
      LoadOptions loadOptions = new LoadOptions();
      loadOptions.d = 2131231369;
      loadOptions.b = 2131231369;
      i >>= 1;
      loadOptions.a(i, i);
      int j = AppInfo.l - DensityUtils.a(AppInfo.d(), 74.0F);
      double d = j;
      int k = (int)(d * 1.5D);
      i = (int)(d * 0.73D);
      try {
        int m;
        return;
      } finally {
        paramFeedComment = null;
        Logger.e("图片越界", new Object[0]);
      } 
    } 
    this.o.ll_img.setVisibility(8);
  }
  
  private void c(boolean paramBoolean) {
    if (this.q.getCount() <= 0) {
      if (paramBoolean) {
        this.o.noDataView.a();
        return;
      } 
      this.o.noDataView.b();
      return;
    } 
    this.o.noDataView.c();
  }
  
  protected void E() {
    int i = ((CommentPresenter)s()).x();
    if (i != 0) {
      if (i != 1) {
        if (i != 2)
          return; 
        this.cbAnonymousComment.setEnabled(false);
        this.cbAnonymousComment.setClickable(false);
        this.cbAnonymousComment.setTextColor(BluedSkinUtils.a(getContext(), 2131100842));
        this.cbAnonymousComment.setChecked(false);
        return;
      } 
      this.cbAnonymousComment.setEnabled(false);
      this.cbAnonymousComment.setClickable(false);
      this.cbAnonymousComment.setTextColor(BluedSkinUtils.a(getContext(), 2131100842));
      this.cbAnonymousComment.setChecked(true);
      return;
    } 
    this.cbAnonymousComment.setEnabled(true);
    this.cbAnonymousComment.setClickable(true);
    this.cbAnonymousComment.setTextColor(BluedSkinUtils.a(getContext(), 2131100838));
  }
  
  protected void F() {
    this.layoutAlbum.setVisibility(8);
    this.ivCommentHeader.setVisibility(8);
    this.spaceWithHeader.setVisibility(8);
    ViewGroup.LayoutParams layoutParams = this.layoutCommentAll.getLayoutParams();
    layoutParams.height = DensityUtils.a(getContext(), 50.0F);
    this.layoutCommentAll.setLayoutParams(layoutParams);
    this.emoticonLayoutRoot.setVisibility(8);
    this.keyboardView.setVisibility(8);
    this.editView.setText(null);
    this.editView.setHint(FeedMethods.a(this.r));
    this.editView.clearFocus();
    ((CommentPresenter)s()).w();
    KeyboardUtils.a((Activity)getActivity());
    this.listView.setSelection(0);
    c(true);
  }
  
  public boolean V_() {
    if (this.emoticonLayoutRoot.getVisibility() == 0) {
      F();
      return true;
    } 
    N();
    return true;
  }
  
  public void a(int paramInt) {
    if (paramInt != -4 && paramInt != -3) {
      if (paramInt != -2)
        return; 
      if (this.emoticonLayoutRoot.getVisibility() != 0) {
        this.layoutAlbum.setVisibility(0);
        if (((CommentPresenter)s()).B()) {
          this.ivCommentHeader.setVisibility(0);
          this.spaceWithHeader.setVisibility(0);
        } 
        ViewGroup.LayoutParams layoutParams = this.layoutCommentAll.getLayoutParams();
        layoutParams.height = DensityUtils.a(getContext(), 100.0F);
        this.layoutCommentAll.setLayoutParams(layoutParams);
        return;
      } 
      if (!this.editView.isFocusable()) {
        this.keyboardView.setVisibility(8);
        return;
      } 
    } else {
      this.layoutAlbum.setVisibility(0);
      if (((CommentPresenter)s()).B()) {
        this.ivCommentHeader.setVisibility(0);
        this.spaceWithHeader.setVisibility(0);
      } 
      ViewGroup.LayoutParams layoutParams = this.layoutCommentAll.getLayoutParams();
      layoutParams.height = DensityUtils.a(getContext(), 100.0F);
      this.layoutCommentAll.setLayoutParams(layoutParams);
      this.keyboardView.setVisibility(0);
      this.keyboardView.setOnTouchListener(new View.OnTouchListener(this) {
            public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
              this.a.F();
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
    this.p = (BluedIngSelfFeed)getArguments().getSerializable("feed_data");
    this.r = (Context)getActivity();
    G();
    H();
    I();
    K();
    this.refreshLayout.i();
  }
  
  protected void a(FeedComment paramFeedComment) {
    c(paramFeedComment);
    b(paramFeedComment);
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
    if (b != 0 && b != 1)
      return; 
    b(paramBoolean);
  }
  
  protected void a(List<FeedComment> paramList) {
    this.q.a(paramList);
  }
  
  public void aL_() {
    super.aL_();
    Unbinder unbinder = this.n;
    if (unbinder != null)
      unbinder.unbind(); 
  }
  
  protected void b(FeedComment paramFeedComment) {
    if (paramFeedComment.iliked == 1) {
      this.o.imgLike.setImageResource(2131232450);
      this.o.tvLikeCount.setTextColor(this.r.getResources().getColor(2131100716));
    } else {
      this.o.imgLike.setImageResource(2131232449);
      this.o.tvLikeCount.setTextColor(this.r.getResources().getColor(2131100842));
    } 
    if (paramFeedComment.liked_count > 0) {
      TextView textView = this.o.tvLikeCount;
      Context context = this.r;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramFeedComment.liked_count);
      stringBuilder.append("");
      textView.setText(AreaUtils.a(context, stringBuilder.toString()));
      this.o.tvLikeCount.setVisibility(0);
    } else {
      this.o.tvLikeCount.setVisibility(8);
    } 
    this.q.a(paramFeedComment.comment_id, paramFeedComment.iliked);
  }
  
  public void b(String paramString) {
    super.b(paramString);
  }
  
  public void c(String paramString) {
    if (Build.VERSION.SDK_INT >= 11 && Build.VERSION.SDK_INT != 18) {
      ((ClipboardManager)this.r.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("simple text", RegExpUtils.a(paramString)));
    } else {
      ((ClipboardManager)this.r.getSystemService("clipboard")).setText(RegExpUtils.a(paramString));
    } 
    AppMethods.a(this.r.getResources().getString(2131756130));
  }
  
  public void o() {
    super.o();
    getActivity().getWindow().setSoftInputMode(16);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramInt2 == -1) {
      if (paramInt1 == 9090) {
        this.s.a(this.editView, paramIntent, this.u);
        M();
      } 
    } else if (paramInt1 == 9090) {
      M();
    } 
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView) {
    FeedProtos.InteractiveType interactiveType;
    FeedProtos.Event event;
    String str;
    switch (paramView.getId()) {
      default:
        return;
      case 2131297461:
      case 2131300653:
        event = FeedProtos.Event.FEED_INTERACTIVE;
        str = ((CommentPresenter)s()).r();
        if ((((CommentPresenter)s()).q()).iliked == 1) {
          interactiveType = FeedProtos.InteractiveType.NO_LIKE;
        } else {
          interactiveType = FeedProtos.InteractiveType.LIKE;
        } 
        EventTrackFeed.a(event, str, interactiveType, FeedProtos.Location.COMMENT_DETAIL, (((CommentPresenter)s()).q()).comment_id, (((CommentPresenter)s()).q()).feed_uid);
        ((CommentPresenter)s()).u();
        return;
      case 2131297362:
      case 2131299358:
        break;
    } 
    if ((((CommentPresenter)s()).q()).is_anonym == 1) {
      AppMethods.d(2131755842);
      return;
    } 
    if (((CommentPresenter)s()).t() != null)
      UserInfoFragmentNew.a(this.r, ((CommentPresenter)s()).t(), ((CommentPresenter)s()).p(), (View)this.o.imgHeader); 
  }
  
  @OnClick({2131297397, 2131299890})
  public void onViewClicked(View paramView) {
    int i = paramView.getId();
    if (i != 2131297397) {
      if (i != 2131299890)
        return; 
      String str = this.editView.getText().toString();
      if (!TextUtils.isEmpty(str.trim())) {
        EventTrackFeed.a(FeedProtos.Event.FEED_INTERACTIVE, ((CommentPresenter)s()).r(), FeedProtos.InteractiveType.COMMENT, FeedProtos.Location.COMMENT_DETAIL, (((CommentPresenter)s()).q()).comment_id, (((CommentPresenter)s()).q()).feed_uid);
        str = this.s.b(str);
        ((CommentPresenter)s()).c(str, this.cbAnonymousComment.isChecked());
        return;
      } 
      AppMethods.d(2131756414);
      return;
    } 
    n();
  }
  
  public int p() {
    return 2131493107;
  }
  
  public void x() {
    super.x();
    this.refreshLayout.b(true);
  }
  
  public void y() {
    super.y();
    this.refreshLayout.b(false);
  }
  
  class HeaderViewHolder {
    @BindView(2131296838)
    TextView contentView;
    
    @BindView(2131297362)
    ImageView imgHeader;
    
    @BindView(2131297461)
    ImageView imgLike;
    
    @BindView(2131297581)
    ImageView imgVIPIcon;
    
    @BindView(2131297575)
    ImageView imgVerify;
    
    @BindView(2131297682)
    ImageView ivAnonymous;
    
    @BindView(2131297820)
    ImageView ivLevel;
    
    @BindView(2131298890)
    LinearLayout ll_img;
    
    @BindView(2131299358)
    TextView nameView;
    
    @BindView(2131299389)
    NoDataAndLoadFailView noDataView;
    
    @BindView(2131299696)
    View rlComment;
    
    @BindView(2131300267)
    TextView timeView;
    
    @BindView(2131300653)
    TextView tvLikeCount;
    
    HeaderViewHolder(CommentFragment this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\fragment\CommentFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */