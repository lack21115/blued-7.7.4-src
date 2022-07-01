package com.soft.blued.ui.circle.fragment;

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
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.ui.custom.KeyboardListenLinearLayout;
import com.blued.android.framework.ui.custom.MvpKeyBoardFragment;
import com.blued.android.framework.ui.custom.SwitchPanelRelativeLayout;
import com.blued.android.framework.ui.markdown.MarkdownView;
import com.blued.android.framework.ui.markdown.atuser.OnClickAtUserListener;
import com.blued.android.framework.ui.markdown.image.OnClickImageListener;
import com.blued.android.framework.ui.markdown.link.OnClickLinkListener;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.RegExpUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeRelativeLayout;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.player.media.model.VideoPlayConfig;
import com.blued.android.module.player.media.view.PLVideoPageView;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.blued.das.client.feed.FeedProtos;
import com.blued.das.message.MessageProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.emoticon.manager.EmotionManager;
import com.soft.blued.emoticon.model.EmoticonModel;
import com.soft.blued.emoticon.model.EmoticonPackageModel;
import com.soft.blued.emoticon.ui.EmoticonsIndicatorView;
import com.soft.blued.emoticon.ui.EmoticonsPageView;
import com.soft.blued.emoticon.ui.EmoticonsToolBarView;
import com.soft.blued.emoticon.ui.IViewStateListener;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.circle.adapter.CircleMainDetailCommentAdapter;
import com.soft.blued.ui.circle.model.CircleConstants;
import com.soft.blued.ui.circle.model.CircleMethods;
import com.soft.blued.ui.circle.pop.CircleMainMenuPop;
import com.soft.blued.ui.circle.presenter.CirclePostDetailsPresenter;
import com.soft.blued.ui.circle.view.CircleJoinView;
import com.soft.blued.ui.circle.view.CircleTextVoteView;
import com.soft.blued.ui.feed.fragment.CommentFragment;
import com.soft.blued.ui.feed.manager.ChildPhotoManager;
import com.soft.blued.ui.feed.manager.FeedMethods;
import com.soft.blued.ui.feed.manager.SelectPhotoManager;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.feed.model.CircleTextVote;
import com.soft.blued.ui.feed.model.FeedComment;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.find.observer.FeedRefreshObserver;
import com.soft.blued.ui.msg.customview.Emotion;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.photo.fragment.BasePhotoFragment;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.AreaUtils;
import com.soft.blued.utils.AtChooseUserHelper;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.PopMenuUtils;
import com.soft.blued.utils.RecyclerViewAnimUtil;
import com.soft.blued.utils.ShareUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TimeAndDateUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import com.soft.blued.view.tip.pop.BluedPopupWindow;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CirclePostDetailsFragment extends MvpKeyBoardFragment<CirclePostDetailsPresenter> implements View.OnClickListener, FeedRefreshObserver.IFeedRefreshObserver {
  private static final Pattern A;
  
  private static final Pattern z = Pattern.compile("\n *\n");
  
  private BasePopupView B;
  
  private TextWatcher C = new TextWatcher(this) {
      private int b;
      
      private int c;
      
      private String d;
      
      private String e;
      
      public void afterTextChanged(Editable param1Editable) {
        this.b = this.a.editView.getSelectionStart();
        this.c = this.a.editView.getSelectionEnd();
        this.a.editView.removeTextChangedListener(this);
        if (!((CirclePostDetailsPresenter)this.a.s()).n().isPrivateCircle() && !CirclePostDetailsFragment.h(this.a).a(this.a, this.d, this.e, param1Editable, this.c))
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
  
  @BindView(2131296666)
  CheckBox cb_anonymous_comment;
  
  @BindView(2131296752)
  CircleJoinView cjv_join;
  
  @BindView(2131296770)
  ConstraintLayout cl_title_bar;
  
  @BindView(2131296799)
  RecyclerView comment_list;
  
  @BindView(2131296971)
  EditText editView;
  
  @BindView(2131296968)
  ShapeRelativeLayout edit_layout;
  
  @BindView(2131296983)
  LinearLayout emoticonLayout;
  
  @BindView(2131296984)
  SwitchPanelRelativeLayout emoticonLayoutRoot;
  
  @BindView(2131297083)
  FrameLayout fl_anonymous_comment;
  
  @BindView(2131297391)
  ImageView iconAlbum;
  
  @BindView(2131297405)
  ImageView iconShare;
  
  @BindView(2131297400)
  ImageView icon_like;
  
  @BindView(2131297733)
  ImageView iv_comment_header;
  
  @BindView(2131297734)
  ImageView iv_cover;
  
  @BindView(2131297858)
  ImageView iv_menu;
  
  @BindView(2131297982)
  KeyboardListenLinearLayout keyboardLayout;
  
  @BindView(2131297985)
  View keyboardView;
  
  @BindView(2131298052)
  LinearLayout layoutCommentAll;
  
  @BindView(2131298043)
  LinearLayout layout_album;
  
  @BindView(2131298068)
  View layout_like_comment;
  
  MarkdownView.Builder n;
  
  View.OnAttachStateChangeListener o = new View.OnAttachStateChangeListener(this) {
      public void onViewAttachedToWindow(View param1View) {
        String str;
        LogUtils.d("Markdown", "onViewAttachedToWindow ");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("markdownContent = ");
        stringBuilder.append(CirclePostDetailsFragment.a(this.a));
        LogUtils.d("Markdown", stringBuilder.toString());
        (CirclePostDetailsFragment.b(this.a)).markdownView.setTextColor(BluedSkinUtils.a(this.a.getContext(), 2131100838));
        MarkdownView markdownView = (CirclePostDetailsFragment.b(this.a)).markdownView;
        MarkdownView.Builder builder = this.a.n;
        if ((((CirclePostDetailsPresenter)this.a.s()).n()).is_essence == 1) {
          stringBuilder = new StringBuilder();
          stringBuilder.append("精");
          stringBuilder.append(CirclePostDetailsFragment.a(this.a));
          str = stringBuilder.toString();
        } else {
          str = CirclePostDetailsFragment.a(this.a);
        } 
        markdownView.a(builder, str);
      }
      
      public void onViewDetachedFromWindow(View param1View) {}
    };
  
  private String p = "";
  
  private CircleMainDetailCommentAdapter q;
  
  private NoDataAndLoadFailView r;
  
  @BindView(2131299616)
  SmartRefreshLayout refresh_layout;
  
  @BindView(2131299734)
  RelativeLayout rl_title_bar;
  
  private HeaderHolder s;
  
  private Unbinder t;
  
  @BindView(2131300308)
  View touchView;
  
  @BindView(2131300633)
  TextView tv_circle_name;
  
  @BindView(2131300651)
  TextView tv_comment_cnt_bottom;
  
  @BindView(2131301032)
  TextView tv_member_num;
  
  @BindView(2131301187)
  TextView tv_praise_cnt_bottom;
  
  private AtChooseUserHelper u;
  
  private Emotion v;
  
  @BindView(2131301642)
  EmoticonsIndicatorView viewEiv;
  
  @BindView(2131301643)
  EmoticonsPageView viewEpv;
  
  @BindView(2131301644)
  EmoticonsToolBarView viewEtv;
  
  private FeedComment w;
  
  private int x;
  
  private View y;
  
  static {
    A = Pattern.compile("([^ \n]) *(\\!\\[[^\\]]*\\]\\([^\\)]*)");
  }
  
  private void I() {
    if (((CirclePostDetailsPresenter)s()).n().isNotMember()) {
      int i = (((CirclePostDetailsPresenter)s()).n()).is_applied;
      if (i != 0) {
        if (i != 1) {
          if (i != 2) {
            AppMethods.d(2131755848);
            return;
          } 
          AppMethods.d(2131755860);
          return;
        } 
        AppMethods.d(2131755859);
        return;
      } 
      CommonAlertDialog.a(getContext(), "", getString(2131755937), getString(2131755918), new DialogInterface.OnClickListener(this) {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
              ((CirclePostDetailsPresenter)this.a.s()).a(this.a.getFragmentManager());
            }
          },  getString(2131755916), null, null);
      return;
    } 
    this.w = null;
    this.editView.setText(null);
    this.editView.setHint(FeedMethods.a(getContext()));
    KeyboardUtils.c((Activity)getActivity());
    this.editView.requestFocus();
  }
  
  private void J() {
    String str = this.editView.getText().toString();
    if (!TextUtils.isEmpty(str.trim())) {
      str = this.u.b(str);
      ((CirclePostDetailsPresenter)s()).a(this.w, str, this.cb_anonymous_comment.isChecked());
      return;
    } 
    AppMethods.d(2131756414);
  }
  
  private void K() {
    a(new Runnable(this) {
          public void run() {
            if (!this.a.editView.isFocusable())
              this.a.editView.requestFocus(); 
            KeyboardUtils.c((Activity)this.a.getActivity());
          }
        },  300L);
  }
  
  private void L() {
    if (((CirclePostDetailsPresenter)s()).n() == null)
      return; 
    this.B = (BasePopupView)new CircleMainMenuPop(getContext(), (CirclePostDetailsPresenter)s());
    (new XPopup.Builder(getContext())).a(this.B).h();
  }
  
  private void M() {
    a((View)this.emoticonLayoutRoot, this.keyboardLayout, this.editView, (View)this.emoticonLayout);
    ShapeHelper.b((ShapeHelper.ShapeView)this.edit_layout, 2131100881);
    this.u = new AtChooseUserHelper(getContext());
    this.v = new Emotion(getContext());
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
                spannableString = CirclePostDetailsFragment.g(this.a).a(((EmoticonModel)keyEvent).code);
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
    this.editView.setHint(FeedMethods.a(getContext()));
    this.editView.setFilters(new InputFilter[] { (InputFilter)new InputFilter.LengthFilter(256) });
    this.editView.addTextChangedListener(this.C);
    this.touchView.setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("touchView===");
            stringBuilder.append(param1MotionEvent.getAction());
            Logger.e("source", new Object[] { stringBuilder.toString() });
            if (param1MotionEvent.getAction() == 0) {
              Logger.e("source", new Object[] { "touchView===ACTION_DOWN" });
              if (((CirclePostDetailsPresenter)this.a.s()).n() == null)
                return false; 
              EventTrackFeed.a(FeedProtos.Event.CIRCLE_NOTE_COMMENT_GUIDE_CLICK, (((CirclePostDetailsPresenter)this.a.s()).n()).feed_id, FeedProtos.NoteSource.NOTE_DETAIL_BOTTOM);
            } 
            return false;
          }
        });
    this.editView.setOnFocusChangeListener(new View.OnFocusChangeListener(this) {
          public void onFocusChange(View param1View, boolean param1Boolean) {}
        });
    String str = AvatarUtils.a(1, UserInfo.a().i().getAvatar());
    ImageLoader.a((IRequestHost)w_(), str).a(2131234356).c(2131234356).c().a(this.iv_comment_header);
    this.cb_anonymous_comment.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this, str) {
          public void onCheckedChanged(CompoundButton param1CompoundButton, boolean param1Boolean) {
            if (param1Boolean) {
              ImageLoader.a((IRequestHost)this.b.w_(), (((CirclePostDetailsPresenter)this.b.s()).n()).anonym_avatar).a(CircleMethods.getAnonymousHeaderRes(this.b.getContext(), ((CirclePostDetailsPresenter)this.b.s()).s())).c(CircleMethods.getAnonymousHeaderRes(this.b.getContext(), ((CirclePostDetailsPresenter)this.b.s()).s())).c().a(this.b.iv_comment_header);
              return;
            } 
            ImageLoader.a((IRequestHost)this.b.w_(), this.a).a(2131234356).c(2131234356).c().a(this.b.iv_comment_header);
          }
        });
    this.fl_anonymous_comment.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (!this.a.cb_anonymous_comment.isEnabled()) {
              if ((((CirclePostDetailsPresenter)this.a.s()).n()).anonym_comment == 1) {
                AppMethods.d(2131755844);
                return;
              } 
              AppMethods.d(2131755841);
            } 
          }
        });
  }
  
  private void N() {
    this.layout_like_comment.setVisibility(0);
    this.layout_album.setVisibility(8);
    this.iv_comment_header.setVisibility(8);
    ViewGroup.LayoutParams layoutParams = this.layoutCommentAll.getLayoutParams();
    layoutParams.height = DensityUtils.a(getContext(), 50.0F);
    this.layoutCommentAll.setLayoutParams(layoutParams);
    this.emoticonLayoutRoot.setVisibility(8);
    this.keyboardView.setVisibility(8);
    this.iconAlbum.setVisibility(0);
    this.editView.setText(null);
    this.editView.setHint(FeedMethods.a(getContext()));
    this.editView.clearFocus();
    KeyboardUtils.a((Activity)getActivity());
    this.w = null;
  }
  
  private void O() {
    if (BluedPreferences.dd())
      return; 
    EventTrackFeed.a(FeedProtos.Event.CIRCLE_NOTE_COMMENT_GUIDE_SHOW, (((CirclePostDetailsPresenter)s()).n()).feed_id, FeedProtos.NoteSource.NOTE_DETAIL_BOTTOM);
    View view = View.inflate(getContext(), 2131494032, null);
    BluedPopupWindow bluedPopupWindow = BluedPopupWindow.Builder.a((Activity)getActivity(), view).a();
    view.setOnClickListener(new View.OnClickListener(this, bluedPopupWindow) {
          public void onClick(View param1View) {
            this.a.dismiss();
            EventTrackFeed.a(FeedProtos.Event.CIRCLE_NOTE_COMMENT_GUIDE_CLICK, (((CirclePostDetailsPresenter)this.b.s()).n()).feed_id, FeedProtos.NoteSource.NOTE_DETAIL_BOTTOM);
          }
        });
    bluedPopupWindow.a((View)this.editView, 1, 0, 0, 0);
    BluedPreferences.de();
  }
  
  private void a(int paramInt1, int paramInt2) {
    paramInt2 -= this.x;
    if (paramInt2 > 0)
      this.comment_list.smoothScrollBy(paramInt1, paramInt2); 
  }
  
  public static void a(Context paramContext, BluedIngSelfFeed paramBluedIngSelfFeed, FeedProtos.NoteSource paramNoteSource) {
    Bundle bundle = new Bundle();
    bundle.putSerializable("feed_data", (Serializable)paramBluedIngSelfFeed);
    bundle.putSerializable("circle_from_page", (Serializable)paramNoteSource);
    TerminalActivity.a(bundle);
    TerminalActivity.d(paramContext, CirclePostDetailsFragment.class, bundle);
  }
  
  public static void a(Context paramContext, String paramString, FeedProtos.NoteSource paramNoteSource) {
    a(paramContext, paramString, "", paramNoteSource, false);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, FeedProtos.NoteSource paramNoteSource, boolean paramBoolean) {
    Bundle bundle = new Bundle();
    bundle.putString("feed_id", paramString1);
    bundle.putString("comment_id", paramString2);
    bundle.putSerializable("circle_from_page", (Serializable)paramNoteSource);
    bundle.putBoolean("to_web_view", paramBoolean);
    TerminalActivity.a(bundle);
    TerminalActivity.d(paramContext, CirclePostDetailsFragment.class, bundle);
  }
  
  private void a(TextView paramTextView) {
    String str = paramTextView.getText().toString();
    if (Build.VERSION.SDK_INT >= 11 && Build.VERSION.SDK_INT != 18) {
      ((ClipboardManager)getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("simple text", RegExpUtils.a(str)));
    } else {
      ((ClipboardManager)getContext().getSystemService("clipboard")).setText(RegExpUtils.a(str));
    } 
    AppMethods.a(getContext().getResources().getString(2131756130));
  }
  
  private void c(String paramString) {
    CharSequence charSequence = StringUtils.a(StringUtils.a(paramString, (int)this.editView.getTextSize(), 3), true, true, true, null, true, "", "");
    this.editView.setText(charSequence);
    EditText editText = this.editView;
    editText.setSelection(editText.length());
  }
  
  private void d(BluedIngSelfFeed paramBluedIngSelfFeed) {
    byte b;
    this.q.e = paramBluedIngSelfFeed.circle_id;
    b(new Runnable(this) {
          public void run() {
            CirclePostDetailsFragment.f(this.a);
          }
        },  500L);
    this.iv_menu.setVisibility(0);
    UserRelationshipUtils.a(this.s.img_verify, paramBluedIngSelfFeed.vbadge, 3);
    ImageLoader.a((IRequestHost)w_(), paramBluedIngSelfFeed.user_avatar).c().a(2131234356).a(this.s.header_view);
    View.OnClickListener onClickListener = new View.OnClickListener(this, paramBluedIngSelfFeed) {
        public void onClick(View param1View) {
          if (this.a.is_anonym == 1) {
            AppMethods.d(2131755842);
            return;
          } 
          UserInfoFragmentNew.a(this.b.getContext(), this.a.feed_uid, "CIRCLE_NOTE_DETAIL", new MsgSourceEntity(MessageProtos.StrangerSource.CIRCLE_NOTE_DETAIL));
        }
      };
    this.s.header_view.setOnClickListener(onClickListener);
    if (!StringUtils.e(paramBluedIngSelfFeed.user_name)) {
      if (!StringUtils.e(paramBluedIngSelfFeed.note)) {
        this.s.tv_name.setText(StringUtils.a(paramBluedIngSelfFeed.note, paramBluedIngSelfFeed.user_name.replace(":", "")));
      } else {
        this.s.tv_name.setText(paramBluedIngSelfFeed.user_name.replace(":", ""));
      } 
    } else {
      this.s.tv_name.setText("");
    } 
    this.s.tv_name.setOnClickListener(onClickListener);
    if (!TextUtils.isEmpty(paramBluedIngSelfFeed.feed_timestamp)) {
      this.s.tv_time.setText(TimeAndDateUtils.i(getContext(), TimeAndDateUtils.b(paramBluedIngSelfFeed.feed_timestamp)));
    } else {
      this.s.tv_time.setText("");
    } 
    UserBasicModel userBasicModel = new UserBasicModel();
    userBasicModel.vip_grade = paramBluedIngSelfFeed.vip_grade;
    userBasicModel.is_vip_annual = paramBluedIngSelfFeed.is_vip_annual;
    userBasicModel.is_hide_vip_look = paramBluedIngSelfFeed.is_hide_vip_look;
    userBasicModel.vip_exp_lvl = paramBluedIngSelfFeed.vip_exp_lvl;
    UserRelationshipUtils.a(getContext(), this.s.tv_name, userBasicModel);
    CircleMethods.setLevelMark(this.s.iv_level, paramBluedIngSelfFeed.anchor_admin_level);
    ImageView imageView = this.s.iv_anonymous;
    if (paramBluedIngSelfFeed.is_anonym == 1) {
      b = 0;
    } else {
      b = 8;
    } 
    imageView.setVisibility(b);
    UserRelationshipUtils.a(this.s.img_blued_medal, userBasicModel);
    EventTrackFeed.a(FeedProtos.Event.CIRCLE_NOTE_COMMENT_GUIDE_SHOW, paramBluedIngSelfFeed.feed_id, FeedProtos.NoteSource.NOTE_DETAIL_COMMENT_LIST);
    if (!StringUtils.e(paramBluedIngSelfFeed.feed_origin_content)) {
      this.s.markdownView.setVisibility(0);
      if (!this.p.equals(paramBluedIngSelfFeed.feed_origin_content)) {
        String str;
        this.p = paramBluedIngSelfFeed.feed_origin_content;
        if (this.n == null) {
          Log.e("Markdown", "new MarkdownBuilder");
          this.n = (new MarkdownView.Builder()).a((IRequestHost)w_()).a(BluedSkinUtils.a(getContext(), 2131100881)).b(3).a("!original.png").a(new OnClickAtUserListener(this) {
                public void a(String param1String1, String param1String2) {
                  UserInfoFragmentNew.a(this.a.getContext(), param1String2, "CIRCLE_NOTE_DETAIL", new MsgSourceEntity(MessageProtos.StrangerSource.CIRCLE_NOTE_DETAIL));
                }
              }).a(new OnClickLinkListener(this) {
                public void a(String param1String) {
                  EventTrackFeed.f(FeedProtos.Event.NOTE_LINK_CLICK, ((CirclePostDetailsPresenter)this.a.s()).o(), ((CirclePostDetailsPresenter)this.a.s()).q());
                  WebViewShowInfoFragment.show(this.a.getContext(), param1String, 7);
                }
              }).a(new OnClickImageListener(this) {
                public void a(String[] param1ArrayOfString, int param1Int) {
                  String str;
                  EventTrackFeed.a(FeedProtos.Event.NOTE_IMAGE_CLICK, (((CirclePostDetailsPresenter)this.a.s()).n()).circle_id, (((CirclePostDetailsPresenter)this.a.s()).n()).feed_id, FeedProtos.NoteSource.NOTE_DETAIL);
                  if ((((CirclePostDetailsPresenter)this.a.s()).n()).is_anonym == 0) {
                    str = (((CirclePostDetailsPresenter)this.a.s()).n()).user_name;
                  } else {
                    str = null;
                  } 
                  BasePhotoFragment.a(this.a.getContext(), param1ArrayOfString, param1Int, 0, null, str, null, null);
                }
              });
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("markdownContent = ");
        stringBuilder.append(this.p);
        LogUtils.d("Markdown", stringBuilder.toString());
        this.s.markdownView.setTextColor(BluedSkinUtils.a(getContext(), 2131100838));
        MarkdownView markdownView = this.s.markdownView;
        MarkdownView.Builder builder = this.n;
        if ((((CirclePostDetailsPresenter)s()).n()).is_essence == 1) {
          stringBuilder = new StringBuilder();
          stringBuilder.append("精");
          stringBuilder.append(this.p);
          str = stringBuilder.toString();
        } else {
          str = this.p;
        } 
        markdownView.a(builder, str);
        this.s.rl_content.setOnLongClickListener(new View.OnLongClickListener(this) {
              public boolean onLongClick(View param1View) {
                CirclePostDetailsFragment circlePostDetailsFragment = this.a;
                CirclePostDetailsFragment.a(circlePostDetailsFragment, (TextView)(CirclePostDetailsFragment.b(circlePostDetailsFragment)).markdownView);
                return true;
              }
            });
      } 
    } else if ((((CirclePostDetailsPresenter)s()).n()).is_essence == 1) {
      this.s.markdownView.setVisibility(0);
    } else {
      this.s.markdownView.setVisibility(8);
    } 
    e(paramBluedIngSelfFeed);
    f(paramBluedIngSelfFeed);
    g(paramBluedIngSelfFeed);
    this.tv_circle_name.setText(paramBluedIngSelfFeed.circle_title);
    this.s.markdownView.setOnShowTextListener(new MarkdownView.OnShowTextListener(this) {
          public Spanned a(CharSequence param1CharSequence) {
            return (Spanned)CircleMethods.setEssence(((CirclePostDetailsPresenter)this.a.s()).n(), param1CharSequence, true);
          }
        });
  }
  
  private void e(BluedIngSelfFeed paramBluedIngSelfFeed) {
    if (paramBluedIngSelfFeed != null && paramBluedIngSelfFeed.is_video_posts == 1 && paramBluedIngSelfFeed.feed_videos.length >= 2) {
      this.s.cardVideo.setVisibility(0);
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
      int i = StringUtils.a(paramBluedIngSelfFeed.feed_videos_width[0], 480);
      int j = StringUtils.a(paramBluedIngSelfFeed.feed_videos_height[0], 480);
      if (i == 0 || j == 0) {
        i = 480;
        j = 480;
      } 
      int k = AppInfo.l - AppMethods.a(18);
      float f = i / j;
      int m = (int)(k / f);
      FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(k, m);
      layoutParams.gravity = 1;
      this.s.videoView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      String[] arrayOfString = paramBluedIngSelfFeed.feed_videos;
      String str = paramBluedIngSelfFeed.feed_video_size;
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
        Logger.b(CirclePostDetailsFragment.class.getSimpleName(), new Object[] { "setCircleVideo() Integer.parseInt(feed.feed_video_size) Exception" });
      } 
      videoPlayConfig.g = new View.OnClickListener(this, arrayOfString, str, paramBluedIngSelfFeed, i, j) {
          public void onClick(View param1View) {
            EventTrackFeed.a(FeedProtos.Event.NOTE_VIDEO_CLICK, (((CirclePostDetailsPresenter)this.f.s()).n()).circle_id, (((CirclePostDetailsPresenter)this.f.s()).n()).feed_id, FeedProtos.NoteSource.NOTE_DETAIL);
            if (AudioChannelManager.e().h()) {
              AppMethods.a(this.f.getActivity().getResources().getText(2131759450));
              return;
            } 
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
              Context context = this.f.getContext();
              String[] arrayOfString1 = this.a;
              BasePhotoFragment.a(context, arrayOfString1[0], arrayOfString1[1], this.c.feed_id, 7, this.d, this.e, l);
            } 
          }
        };
      this.s.videoView.b(videoPlayConfig);
      b(new Runnable(this) {
            public void run() {
              if (CirclePostDetailsFragment.b(this.a) != null && (CirclePostDetailsFragment.b(this.a)).videoView != null)
                (CirclePostDetailsFragment.b(this.a)).videoView.c(); 
            }
          });
      return;
    } 
    this.s.cardVideo.setVisibility(8);
  }
  
  private void f(BluedIngSelfFeed paramBluedIngSelfFeed) {
    if (paramBluedIngSelfFeed != null && paramBluedIngSelfFeed.is_posts_vote == 1) {
      this.s.circleTextVote.setOptionTitle(paramBluedIngSelfFeed.posts_vote_title);
      this.s.circleTextVote.setOptionList(paramBluedIngSelfFeed.option_count);
      this.s.circleTextVote.a(paramBluedIngSelfFeed.vote_count, paramBluedIngSelfFeed.ivoted);
      this.s.circleTextVote.setOnVoteListener(new CircleTextVoteView.OnVoteListener(this) {
            public void a(CircleTextVote param1CircleTextVote, int param1Int) {
              ((CirclePostDetailsPresenter)this.a.s()).a(param1Int + 1);
            }
          });
      this.s.circleTextVote.setVisibility(0);
      b(new Runnable(this) {
            public void run() {
              this.a.comment_list.scrollToPosition(0);
            }
          });
      return;
    } 
    this.s.circleTextVote.setVisibility(8);
  }
  
  private void g(BluedIngSelfFeed paramBluedIngSelfFeed) {
    TextView textView = this.s.tv_comment_cnt;
    String str = getString(2131755935);
    Context context = getContext();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramBluedIngSelfFeed.feed_comment);
    stringBuilder.append("");
    textView.setText(String.format(str, new Object[] { AreaUtils.a(context, stringBuilder.toString()) }));
  }
  
  private void h(BluedIngSelfFeed paramBluedIngSelfFeed) {
    TextView textView = this.tv_member_num;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramBluedIngSelfFeed.members_num);
    stringBuilder.append(getString(2131757871));
    textView.setText(stringBuilder.toString());
    ImageLoader.a((IRequestHost)w_(), AvatarUtils.a((((CirclePostDetailsPresenter)s()).n()).cover)).a(2131231281).a(5.0F).a(new ImageLoadResult(this, (IRequestHost)w_()) {
          private void d() {
            if (this.a.cl_title_bar != null && this.a.getContext() != null)
              this.a.cl_title_bar.setBackgroundColor(this.a.getContext().getResources().getColor(2131100795)); 
          }
          
          public void a() {
            ImageFileLoader.a((IRequestHost)this.a.w_()).b(AvatarUtils.a((((CirclePostDetailsPresenter)this.a.s()).n()).cover)).a(new ImageFileLoader.OnLoadFileListener(this) {
                  public void onUIFinish(File param2File, Exception param2Exception) {
                    if (param2File != null && param2File.exists()) {
                      Bitmap bitmap = BitmapFactory.decodeFile(param2File.getPath());
                    } else {
                      param2File = null;
                    } 
                    if (param2File != null) {
                      Palette.from((Bitmap)param2File).generate(new Palette.PaletteAsyncListener(this) {
                            public void onGenerated(Palette param3Palette) {
                              if (param3Palette != null) {
                                Palette.Swatch swatch = param3Palette.getLightVibrantSwatch();
                                if (swatch != null) {
                                  int i = swatch.getRgb();
                                  if (this.a.a.a.cl_title_bar != null && this.a.a.a.rl_title_bar != null) {
                                    this.a.a.a.cl_title_bar.setBackgroundColor(i);
                                    this.a.a.a.rl_title_bar.setBackgroundColor(i);
                                    return;
                                  } 
                                } else {
                                  CirclePostDetailsFragment.null.a(this.a.a);
                                  return;
                                } 
                              } else {
                                CirclePostDetailsFragment.null.a(this.a.a);
                              } 
                            }
                          });
                      return;
                    } 
                    CirclePostDetailsFragment.null.a(this.a);
                  }
                }).a();
          }
          
          public void a(int param1Int, Exception param1Exception) {
            super.a(param1Int, param1Exception);
            d();
          }
        }).a(this.iv_cover);
  }
  
  protected void E() {
    this.cjv_join.setJoinStatus(((CirclePostDetailsPresenter)s()).n().getJoinState());
    b(new Runnable(this) {
          public void run() {
            this.a.cjv_join.setVisibility(8);
          }
        },  1000L);
  }
  
  protected void F() {
    BluedIngSelfFeed bluedIngSelfFeed = ((CirclePostDetailsPresenter)s()).n();
    if (!UserRelationshipUtils.a(bluedIngSelfFeed.relationship))
      ShareUtils.a().a(getContext(), bluedIngSelfFeed, 15); 
  }
  
  protected void G() {
    SelectPhotoManager.a().d();
    ChildPhotoManager.a().d();
  }
  
  public void H() {
    if (((CirclePostDetailsPresenter)s()).t()) {
      CircleDetailsFragment.a(getContext(), (((CirclePostDetailsPresenter)s()).n()).circle_id, CircleConstants.CIRCLE_FROM_PAGE.CIRCLE_POST_DETAILS);
      getActivity().finish();
      return;
    } 
    getActivity().finish();
  }
  
  public boolean V_() {
    H();
    return super.V_();
  }
  
  public void a(int paramInt) {
    if (paramInt != -4 && paramInt != -3) {
      if (paramInt != -2)
        return; 
      if (this.emoticonLayoutRoot.getVisibility() != 0) {
        this.layout_album.setVisibility(0);
        this.iv_comment_header.setVisibility(0);
        ViewGroup.LayoutParams layoutParams1 = this.layoutCommentAll.getLayoutParams();
        layoutParams1.height = DensityUtils.a(getContext(), 100.0F);
        this.layoutCommentAll.setLayoutParams(layoutParams1);
        this.layout_like_comment.setVisibility(8);
      } else if (!this.editView.isFocusable()) {
        this.keyboardView.setVisibility(8);
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("======键盘隐藏==");
      stringBuilder1.append(this.emoticonLayoutRoot.getVisibility());
      Logger.e("Circle", new Object[] { stringBuilder1.toString() });
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("======键盘显示==");
    stringBuilder.append(this.emoticonLayoutRoot.getVisibility());
    Logger.e("Circle", new Object[] { stringBuilder.toString() });
    this.layout_album.setVisibility(0);
    this.iv_comment_header.setVisibility(0);
    ViewGroup.LayoutParams layoutParams = this.layoutCommentAll.getLayoutParams();
    layoutParams.height = DensityUtils.a(getContext(), 100.0F);
    this.layoutCommentAll.setLayoutParams(layoutParams);
    this.layout_like_comment.setVisibility(8);
    this.keyboardView.setVisibility(0);
    this.keyboardView.setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            KeyboardUtils.a((Activity)this.a.getActivity());
            if (this.a.w_().isActive() && this.a.t()) {
              this.a.layout_like_comment.setVisibility(0);
              this.a.layout_album.setVisibility(8);
              this.a.iv_comment_header.setVisibility(8);
              ViewGroup.LayoutParams layoutParams = this.a.layoutCommentAll.getLayoutParams();
              layoutParams.height = DensityUtils.a(this.a.getContext(), 50.0F);
              this.a.layoutCommentAll.setLayoutParams(layoutParams);
              this.a.emoticonLayoutRoot.setVisibility(8);
              this.a.keyboardView.setVisibility(8);
              this.a.iconAlbum.setVisibility(0);
              this.a.editView.clearFocus();
            } 
            return true;
          }
        });
    this.editView.setFocusable(true);
    this.editView.setFocusableInTouchMode(true);
    this.editView.requestFocus();
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    if (getArguments() == null || (!getArguments().containsKey("feed_data") && !getArguments().containsKey("feed_id"))) {
      H();
      return;
    } 
    StatusBarHelper.a((Activity)getActivity(), false);
    ViewGroup.LayoutParams layoutParams = this.rl_title_bar.getLayoutParams();
    layoutParams.height = StatusBarHelper.a(getContext());
    this.rl_title_bar.setLayoutParams(layoutParams);
    this.comment_list.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(this, getContext()) {
          public void onLayoutChildren(RecyclerView.Recycler param1Recycler, RecyclerView.State param1State) {
            try {
              super.onLayoutChildren(param1Recycler, param1State);
              return;
            } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
              return;
            } 
          }
        });
    this.y = View.inflate(getContext(), 2131493397, null);
    this.s = new HeaderHolder(this);
    this.t = ButterKnife.a(this.s, this.y);
    this.s.markdownView.addOnAttachStateChangeListener(this.o);
    if (this.q == null) {
      this.q = new CircleMainDetailCommentAdapter();
      this.q.b(this.y);
      this.r = new NoDataAndLoadFailView(getContext());
      this.r.setNoDataImg(2131232635);
      this.q.e((View)this.r);
      this.q.d(true);
      this.q.c(false);
      ((CirclePostDetailsPresenter)s()).a(this.q);
    } 
    this.q.a(new BaseQuickAdapter.OnItemChildClickListener(this) {
          public void onItemChildClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
            FeedComment feedComment = (FeedComment)param1BaseQuickAdapter.e(param1Int);
            switch (param1View.getId()) {
              default:
                return;
              case 2131299696:
                if (!PopMenuUtils.a(this.a.getContext())) {
                  CirclePostDetailsFragment.a(this.a, feedComment);
                  String str = this.a.getContext().getResources().getString(2131758580);
                  this.a.editView.setText("");
                  EditText editText = this.a.editView;
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append(str);
                  stringBuilder.append(feedComment.user_name);
                  stringBuilder.append(":");
                  editText.setHint(stringBuilder.toString());
                  this.a.editView.requestFocus();
                  this.a.iconAlbum.setVisibility(8);
                  KeyboardUtils.c((Activity)this.a.getActivity());
                  return;
                } 
                return;
              case 2131299051:
              case 2131301258:
              case 2131301261:
                break;
            } 
            if (feedComment != null) {
              String str = AppUtils.a(2131758583);
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(feedComment.comments_count);
              stringBuilder.append("");
              str = String.format(str, new Object[] { stringBuilder.toString() });
              if (CirclePostDetailsFragment.c(this.a) != null)
                CirclePostDetailsFragment.c(this.a).a(); 
              CommentFragment.a(this.a.getContext(), str, feedComment, ((CirclePostDetailsPresenter)this.a.s()).n(), CirclePostDetailsFragment.c(this.a).a(), ((CirclePostDetailsPresenter)this.a.s()).s(), 13, 101);
            } 
          }
        });
    this.comment_list.setAdapter((RecyclerView.Adapter)this.q);
    RecyclerViewAnimUtil.a(this.comment_list);
    this.refresh_layout.b(true);
    this.refresh_layout.a(new OnRefreshLoadMoreListener(this) {
          public void a(RefreshLayout param1RefreshLayout) {
            ((CirclePostDetailsPresenter)this.a.s()).f();
          }
          
          public void onRefresh(RefreshLayout param1RefreshLayout) {
            ((CirclePostDetailsPresenter)this.a.s()).e();
          }
        });
    M();
    this.editView.setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            if (param1MotionEvent.getAction() == 1 && ((CirclePostDetailsPresenter)this.a.s()).n() != null && ((CirclePostDetailsPresenter)this.a.s()).n().isNotMember()) {
              CirclePostDetailsFragment.d(this.a);
              return true;
            } 
            return false;
          }
        });
    this.comment_list.setOnScrollListener(new RecyclerView.OnScrollListener(this) {
          public void onScrolled(RecyclerView param1RecyclerView, int param1Int1, int param1Int2) {
            super.onScrolled(param1RecyclerView, param1Int1, param1Int2);
            CirclePostDetailsFragment circlePostDetailsFragment = this.a;
            CirclePostDetailsFragment.a(circlePostDetailsFragment, CirclePostDetailsFragment.e(circlePostDetailsFragment) + param1Int2);
          }
        });
  }
  
  protected void a(BluedIngSelfFeed paramBluedIngSelfFeed) {
    String str1;
    String str2;
    h(paramBluedIngSelfFeed);
    d(paramBluedIngSelfFeed);
    c(paramBluedIngSelfFeed);
    this.q.d = paramBluedIngSelfFeed;
    b(paramBluedIngSelfFeed);
    if (paramBluedIngSelfFeed.iliked == 0) {
      this.icon_like.setTag(null);
      this.icon_like.setImageDrawable(BluedSkinUtils.b(getContext(), 2131232487));
    } else if (paramBluedIngSelfFeed.isPlayLikeAnim) {
      this.icon_like.setTag("anim");
      ImageLoader.c((IRequestHost)w_(), FeedMethods.a()).f().a(new ImageLoader.OnAnimationStateListener(this, paramBluedIngSelfFeed) {
            public void a() {}
            
            public void b() {
              this.a.isPlayLikeAnim = false;
              if (this.b.icon_like != null && this.b.icon_like.getTag() != null)
                ImageLoader.a((IRequestHost)this.b.w_(), 2131232488).a(this.b.icon_like); 
            }
          }).a(this.icon_like);
    } else {
      this.icon_like.setTag(null);
      ImageLoader.a((IRequestHost)w_(), 2131232488).a(this.icon_like);
    } 
    if ("200".equals(paramBluedIngSelfFeed.feed_status) && paramBluedIngSelfFeed.is_disclosure == 1) {
      this.iconShare.setImageDrawable(BluedSkinUtils.b(getContext(), 2131232497));
    } else {
      this.iconShare.setImageDrawable(BluedSkinUtils.b(getContext(), 2131232501));
    } 
    TextView textView2 = this.tv_praise_cnt_bottom;
    int i = paramBluedIngSelfFeed.feed_dig;
    String str3 = "999+";
    if (i > 999) {
      str2 = "999+";
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramBluedIngSelfFeed.feed_dig);
      stringBuilder.append("");
      str2 = stringBuilder.toString();
    } 
    textView2.setText(str2);
    textView2 = this.tv_comment_cnt_bottom;
    if (paramBluedIngSelfFeed.feed_comment > 999) {
      str2 = str3;
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramBluedIngSelfFeed.feed_comment);
      stringBuilder.append("");
      str2 = stringBuilder.toString();
    } 
    textView2.setText(str2);
    TextView textView1 = this.tv_praise_cnt_bottom;
    Context context = getContext();
    if (paramBluedIngSelfFeed.iliked == 1) {
      i = 2131100319;
    } else {
      i = 2131100838;
    } 
    textView1.setTextColor(BluedSkinUtils.a(context, i));
    textView1 = this.tv_comment_cnt_bottom;
    i = paramBluedIngSelfFeed.feed_comment;
    byte b = 8;
    if (i == 0) {
      i = 8;
    } else {
      i = 0;
    } 
    textView1.setVisibility(i);
    textView1 = this.tv_praise_cnt_bottom;
    if (paramBluedIngSelfFeed.feed_dig == 0) {
      i = b;
    } else {
      i = 0;
    } 
    textView1.setVisibility(i);
    this.s.markdownView.setTextColor(BluedSkinUtils.a(getContext(), 2131100838));
    if ((((CirclePostDetailsPresenter)s()).n()).is_essence == 1) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("精");
      stringBuilder.append(this.p);
      str1 = stringBuilder.toString();
    } else {
      str1 = this.p;
    } 
    this.s.markdownView.a(this.n, str1);
  }
  
  protected void a(FeedComment paramFeedComment) {
    this.q.n().add(0, paramFeedComment);
    CircleMainDetailCommentAdapter circleMainDetailCommentAdapter = this.q;
    circleMainDetailCommentAdapter.notifyItemInserted(circleMainDetailCommentAdapter.o());
    this.comment_list.scrollToPosition(this.q.o());
    N();
  }
  
  protected void a(Boolean paramBoolean) {
    b(new Runnable(this, paramBoolean) {
          public void run() {
            if (this.a.booleanValue()) {
              byte b;
              if ((CirclePostDetailsFragment.b(this.b)).ll_refresh.getVisibility() == 0) {
                b = (CirclePostDetailsFragment.b(this.b)).ll_refresh.getHeight();
              } else {
                b = 0;
              } 
              CirclePostDetailsFragment circlePostDetailsFragment = this.b;
              CirclePostDetailsFragment.a(circlePostDetailsFragment, 0, CirclePostDetailsFragment.c(circlePostDetailsFragment).u().getHeight() - (CirclePostDetailsFragment.b(this.b)).tv_comment_cnt.getHeight() - b);
            } else {
              CirclePostDetailsFragment circlePostDetailsFragment = this.b;
              CirclePostDetailsFragment.a(circlePostDetailsFragment, 0, CirclePostDetailsFragment.c(circlePostDetailsFragment).u().getHeight() - this.b.comment_list.getHeight() / 2);
            } 
            this.b.b(new Runnable(this) {
                  public void run() {
                    CirclePostDetailsFragment.c(this.a.b).b();
                  }
                },  100L);
          }
        }1000L);
  }
  
  public void a(Object paramObject, int paramInt) {
    if (paramInt == 2 && paramObject instanceof FeedComment) {
      paramObject = paramObject;
      this.q.n().add(0, paramObject);
      paramObject = this.q;
      paramObject.notifyItemInserted(paramObject.o());
      this.comment_list.scrollToPosition(this.q.o());
    } 
  }
  
  public void a(String paramString, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: iload_2
    //   3: invokespecial a : (Ljava/lang/String;Z)V
    //   6: aload_1
    //   7: invokevirtual hashCode : ()I
    //   10: istore_3
    //   11: iload_3
    //   12: ldc_w -1290256561
    //   15: if_icmpeq -> 43
    //   18: iload_3
    //   19: ldc_w 623698297
    //   22: if_icmpeq -> 28
    //   25: goto -> 58
    //   28: aload_1
    //   29: ldc_w '_load_type_loadmore_'
    //   32: invokevirtual equals : (Ljava/lang/Object;)Z
    //   35: ifeq -> 58
    //   38: iconst_0
    //   39: istore_3
    //   40: goto -> 60
    //   43: aload_1
    //   44: ldc_w '_load_type_refresh_'
    //   47: invokevirtual equals : (Ljava/lang/Object;)Z
    //   50: ifeq -> 58
    //   53: iconst_1
    //   54: istore_3
    //   55: goto -> 60
    //   58: iconst_m1
    //   59: istore_3
    //   60: iload_3
    //   61: ifeq -> 125
    //   64: iload_3
    //   65: iconst_1
    //   66: if_icmpeq -> 70
    //   69: return
    //   70: aload_0
    //   71: getfield s : Lcom/soft/blued/ui/circle/fragment/CirclePostDetailsFragment$HeaderHolder;
    //   74: getfield ll_refresh : Landroid/widget/LinearLayout;
    //   77: bipush #8
    //   79: invokevirtual setVisibility : (I)V
    //   82: aload_0
    //   83: getfield refresh_layout : Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;
    //   86: invokevirtual g : ()Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;
    //   89: pop
    //   90: iload_2
    //   91: ifne -> 102
    //   94: aload_0
    //   95: getfield r : Lcom/soft/blued/customview/NoDataAndLoadFailView;
    //   98: invokevirtual b : ()V
    //   101: return
    //   102: aload_0
    //   103: getfield q : Lcom/soft/blued/ui/circle/adapter/CircleMainDetailCommentAdapter;
    //   106: invokevirtual n : ()Ljava/util/List;
    //   109: invokeinterface size : ()I
    //   114: ifne -> 134
    //   117: aload_0
    //   118: getfield r : Lcom/soft/blued/customview/NoDataAndLoadFailView;
    //   121: invokevirtual a : ()V
    //   124: return
    //   125: aload_0
    //   126: getfield refresh_layout : Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;
    //   129: iload_2
    //   130: invokevirtual g : (Z)Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;
    //   133: pop
    //   134: return
  }
  
  protected void a(List<FeedComment> paramList) {
    this.q.c(paramList);
  }
  
  public void aL_() {
    super.aL_();
    HeaderHolder headerHolder = this.s;
    if (headerHolder != null && headerHolder.markdownView != null)
      this.s.markdownView.removeOnAttachStateChangeListener(this.o); 
    Unbinder unbinder = this.t;
    if (unbinder != null)
      unbinder.unbind(); 
  }
  
  protected void b(BluedIngSelfFeed paramBluedIngSelfFeed) {
    if (paramBluedIngSelfFeed.isNotMember()) {
      this.cjv_join.setVisibility(0);
      this.cjv_join.setStyle(1);
      this.cjv_join.setJoinStatus(paramBluedIngSelfFeed.getJoinState());
      return;
    } 
    if (this.cjv_join.getVisibility() == 0)
      E(); 
  }
  
  protected void b(FeedComment paramFeedComment) {
    FeedComment feedComment = this.w;
    if (feedComment != null)
      this.q.a(paramFeedComment, feedComment.comment_id); 
    N();
  }
  
  protected void c(BluedIngSelfFeed paramBluedIngSelfFeed) {
    int i = paramBluedIngSelfFeed.must_anonym_reply;
    if (i != 0) {
      if (i != 1) {
        if (i != 2)
          return; 
        this.cb_anonymous_comment.setEnabled(false);
        this.cb_anonymous_comment.setClickable(false);
        this.cb_anonymous_comment.setTextColor(BluedSkinUtils.a(getContext(), 2131100842));
        this.cb_anonymous_comment.setChecked(false);
        return;
      } 
      this.cb_anonymous_comment.setEnabled(false);
      this.cb_anonymous_comment.setClickable(false);
      this.cb_anonymous_comment.setTextColor(BluedSkinUtils.a(getContext(), 2131100842));
      this.cb_anonymous_comment.setChecked(true);
      ImageLoader.a((IRequestHost)w_(), (((CirclePostDetailsPresenter)s()).n()).anonym_avatar).a(CircleMethods.getAnonymousHeaderRes(getContext(), ((CirclePostDetailsPresenter)s()).s())).c(CircleMethods.getAnonymousHeaderRes(getContext(), ((CirclePostDetailsPresenter)s()).s())).a(this.iv_comment_header);
      return;
    } 
    this.cb_anonymous_comment.setEnabled(true);
    this.cb_anonymous_comment.setClickable(true);
    this.cb_anonymous_comment.setTextColor(BluedSkinUtils.a(getContext(), 2131100838));
  }
  
  public void o() {
    super.o();
    getActivity().getWindow().setSoftInputMode(16);
    FeedRefreshObserver.a().a(this);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramInt2 == -1) {
      if (paramInt1 != 100) {
        if (paramInt1 != 101) {
          if (paramInt1 == 9090) {
            this.u.a(this.editView, paramIntent, this.C);
            K();
          } 
        } else if (paramIntent != null) {
          int i = paramIntent.getIntExtra("comment_state", 0);
          (((CirclePostDetailsPresenter)s()).n()).must_anonym_reply = i;
          c(((CirclePostDetailsPresenter)s()).n());
        } 
      } else if (paramIntent != null) {
        String str = paramIntent.getStringExtra("comment_content");
        boolean bool1 = paramIntent.getBooleanExtra("is_can_change_anonymous", true);
        boolean bool2 = paramIntent.getBooleanExtra("is_anonymous", false);
        if (!TextUtils.isEmpty(str)) {
          c(str);
        } else {
          this.editView.setText("");
        } 
        this.cb_anonymous_comment.setEnabled(bool1);
        this.cb_anonymous_comment.setClickable(bool1);
        this.cb_anonymous_comment.setChecked(bool2);
      } 
    } else if (paramInt1 == 9090) {
      K();
    } 
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  @OnClick({2131299890, 2131297394, 2131297400, 2131297858, 2131297701, 2131296752, 2131300633, 2131297391, 2131297397, 2131297405, 2131297734})
  public void onClick(View paramView) {
    BluedIngSelfFeed bluedIngSelfFeed;
    boolean bool1;
    boolean bool2;
    int i = paramView.getId();
    boolean bool = false;
    switch (i) {
      default:
        return;
      case 2131299890:
        KeyboardUtils.a((Activity)getActivity());
        J();
        return;
      case 2131297858:
        EventTrackFeed.a(FeedProtos.Event.NOTE_MORE_BTN_CLICK, (((CirclePostDetailsPresenter)s()).n()).circle_id, (((CirclePostDetailsPresenter)s()).n()).feed_id, FeedProtos.NoteSource.NOTE_DETAIL);
        L();
        return;
      case 2131297734:
      case 2131300633:
        if (((CirclePostDetailsPresenter)s()).n() == null)
          return; 
        CircleDetailsFragment.a(getContext(), (((CirclePostDetailsPresenter)s()).n()).circle_id, CircleConstants.CIRCLE_FROM_PAGE.CIRCLE_POST_DETAILS);
        return;
      case 2131297701:
        H();
        return;
      case 2131297405:
        if ("200".equals((((CirclePostDetailsPresenter)s()).n()).feed_status) && (((CirclePostDetailsPresenter)s()).n()).is_disclosure == 1) {
          F();
          return;
        } 
        return;
      case 2131297400:
        ((CirclePostDetailsPresenter)s()).m();
        return;
      case 2131297397:
        n();
        return;
      case 2131297394:
        if (this.s.ll_refresh.getVisibility() == 0) {
          i = this.s.ll_refresh.getHeight();
        } else {
          i = 0;
        } 
        a(0, this.q.u().getHeight() - this.s.tv_comment_cnt.getHeight() - i);
        return;
      case 2131297391:
        bluedIngSelfFeed = ((CirclePostDetailsPresenter)s()).n();
        str = this.editView.getText().toString();
        bool1 = this.cb_anonymous_comment.isEnabled();
        bool2 = this.cb_anonymous_comment.isChecked();
        if ((((CirclePostDetailsPresenter)s()).n()).anonym_comment == 1) {
          bool = true;
        } else {
          bool = false;
        } 
        CircleCommentFragment.a((BaseFragment)this, bluedIngSelfFeed, str, bool1, bool2, bool, ((CirclePostDetailsPresenter)s()).s(), (((CirclePostDetailsPresenter)s()).n()).anonym_avatar, 100, ((CirclePostDetailsPresenter)s()).r());
        return;
      case 2131296752:
        break;
    } 
    FeedProtos.Event event = FeedProtos.Event.CIRCLE_JOIN_BTN_CLICK;
    String str = ((CirclePostDetailsPresenter)s()).q();
    FeedProtos.CircleSource circleSource = FeedProtos.CircleSource.CIRCLE_NOTE_DETAIL_NAME;
    if ((((CirclePostDetailsPresenter)s()).n()).allow_join == 0)
      bool = true; 
    EventTrackFeed.a(event, str, circleSource, bool, (((CirclePostDetailsPresenter)s()).n()).classify_id);
    ((CirclePostDetailsPresenter)s()).a(getFragmentManager());
  }
  
  public void onDestroy() {
    super.onDestroy();
    G();
    FeedRefreshObserver.a().b(this);
    HeaderHolder headerHolder = this.s;
    if (headerHolder != null && headerHolder.markdownView != null)
      this.s.markdownView.removeOnAttachStateChangeListener(this.o); 
  }
  
  public void onPause() {
    super.onPause();
    HeaderHolder headerHolder = this.s;
    if (headerHolder != null && headerHolder.videoView != null)
      this.s.videoView.g(); 
    this.q.c();
  }
  
  public void onResume() {
    super.onResume();
    HeaderHolder headerHolder = this.s;
    if (headerHolder != null && headerHolder.videoView != null)
      this.s.videoView.f(); 
  }
  
  public int p() {
    return 2131493095;
  }
  
  public void x() {
    super.x();
    this.refresh_layout.b(true);
  }
  
  public void y() {
    super.y();
    this.refresh_layout.b(false);
  }
  
  public class HeaderHolder {
    @BindView(2131296658)
    CardView cardVideo;
    
    @BindView(2131296751)
    public CircleTextVoteView circleTextVote;
    
    @BindView(2131297362)
    public ImageView header_view;
    
    @BindView(2131297447)
    ImageView img_blued_medal;
    
    @BindView(2131297575)
    public ImageView img_verify;
    
    @BindView(2131297682)
    ImageView iv_anonymous;
    
    @BindView(2131297820)
    ImageView iv_level;
    
    @BindView(2131299045)
    public LinearLayout ll_refresh;
    
    @BindView(2131299200)
    public MarkdownView markdownView;
    
    @BindView(2131299697)
    public RelativeLayout rl_content;
    
    @BindView(2131300650)
    public TextView tv_comment_cnt;
    
    @BindView(2131301088)
    public TextView tv_name;
    
    @BindView(2131301386)
    public TextView tv_time;
    
    @BindView(2131301607)
    PLVideoPageView videoView;
    
    public HeaderHolder(CirclePostDetailsFragment this$0) {}
  }
  
  public class TopSmoothScroller extends LinearSmoothScroller {
    public int d() {
      return -1;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\fragment\CirclePostDetailsFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */