package com.soft.blued.ui.user.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.util.ImageSize;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.BinaryHttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.ImageUtils;
import com.blued.android.framework.utils.RegExpUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.LinkMovementClickMethod;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.blued.das.client.feed.FeedProtos;
import com.blued.das.message.MessageProtos;
import com.blued.das.profile.PersonalProfileProtos;
import com.blued.das.vip.VipProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.material.appbar.AppBarLayout;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener;
import com.soft.blued.BluedConstant;
import com.soft.blued.app.permission.PermissionHelper;
import com.soft.blued.customview.CustomViewPager;
import com.soft.blued.customview.RotateLayout;
import com.soft.blued.customview.TabPageIndicatorWithDot;
import com.soft.blued.customview.TextViewFixTouchForDynamic;
import com.soft.blued.customview.bluedad.BluedADConstraintLayout;
import com.soft.blued.http.BluedHttpUrl;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.http.H5Url;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.model.LogData;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.log.trackUtils.EventTrackPersonalProfile;
import com.soft.blued.model.BluedAlbum;
import com.soft.blued.ui.feed.fragment.FeedPostFragment;
import com.soft.blued.ui.feed.fragment.PhotoSelectFragment;
import com.soft.blued.ui.feed.model.BluedADExtra;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.event.FuGiftListEvent;
import com.soft.blued.ui.msg.manager.UserPagerGiftManager;
import com.soft.blued.ui.msg.model.ChatBundleExtra;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.photo.fragment.BasePhotoFragment;
import com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment;
import com.soft.blued.ui.setting.fragment.PersonalVerifyFragment;
import com.soft.blued.ui.setting.fragment.ShowVerifyFragment;
import com.soft.blued.ui.share_custom.Adapter.ShareOptionRecyclerAdapter;
import com.soft.blued.ui.share_custom.Model.ShareEntity;
import com.soft.blued.ui.user.adapter.UserinfoNewAlbumAdapter;
import com.soft.blued.ui.user.contract.IUserInfoNewContract;
import com.soft.blued.ui.user.manager.AvatarWidgetManager;
import com.soft.blued.ui.user.model.AlbumFlow;
import com.soft.blued.ui.user.model.AlbumForDataTrans;
import com.soft.blued.ui.user.model.GiftGivingOptionForJsonParse;
import com.soft.blued.ui.user.model.UserInfoEntity;
import com.soft.blued.ui.user.observer.AlbumDataObserver;
import com.soft.blued.ui.user.observer.UserinfoFeedScrollObserver;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.ui.user.presenter.UserInfoNewPresenter;
import com.soft.blued.ui.user.views.EcologyPopView;
import com.soft.blued.ui.user.views.UserProfileBtmOptions;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BitmapUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.DistanceUtils;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.PopMenuUtils;
import com.soft.blued.utils.ShareUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TimeAndDateUtils;
import com.soft.blued.utils.TypefaceUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserInfoFragmentNew extends BaseFragment implements View.OnClickListener, Observer<FuGiftListEvent>, IUserInfoNewContract.IView, AlbumDataObserver.IAlbumObserver, UserinfoFeedScrollObserver.IUserinFeedScrollObserver {
  public TextView A;
  
  public TextView B;
  
  public TextView C;
  
  public View D;
  
  public TextView E;
  
  public TextView F;
  
  public TextView G;
  
  public UserBasicModel H;
  
  public boolean I;
  
  public boolean J;
  
  public boolean K;
  
  public boolean L;
  
  public boolean M;
  
  public MsgSourceEntity N;
  
  public LogData O;
  
  public int P;
  
  public int Q;
  
  public ImageView R;
  
  public ImageView S;
  
  public ImageView T;
  
  public ImageView U;
  
  public TextView V;
  
  public SmartRefreshLayout W;
  
  public boolean X = false;
  
  private UserProfileBtmOptions Y;
  
  private View Z;
  
  private AppBarLayout aa;
  
  private View ab;
  
  private boolean ac = false;
  
  private boolean ad = true;
  
  private ShapeTextView ae;
  
  private ShapeTextView af;
  
  private View ag;
  
  private View ah;
  
  private boolean ai = false;
  
  private boolean aj = false;
  
  private boolean ak = false;
  
  private boolean al;
  
  private boolean am;
  
  private String an;
  
  private EcologyPopView ao;
  
  private FuGiftListEvent ap;
  
  private RecyclerView aq;
  
  private UserinfoNewAlbumAdapter ar;
  
  private int as;
  
  private int at;
  
  public Context d;
  
  public View e;
  
  public List<String> f;
  
  public View g;
  
  public View h;
  
  public CustomViewPager i;
  
  public MyAdapter j;
  
  public TabPageIndicatorWithDot k;
  
  public ImageView l;
  
  public ImageView m;
  
  public ImageView n;
  
  public ImageView o;
  
  public View p;
  
  public ShapeTextView q;
  
  public LoadOptions r;
  
  public UserInfoNewPresenter s;
  
  public boolean t;
  
  public RotateLayout u;
  
  public ImageView v;
  
  public ImageView w;
  
  public ImageView x;
  
  public ImageView y;
  
  public Dialog z;
  
  private void A() {
    AlertDialog alertDialog = (new AlertDialog.Builder((Context)getActivity())).create();
    alertDialog.setCanceledOnTouchOutside(true);
    Window window = alertDialog.getWindow();
    window.setGravity(17);
    window.setBackgroundDrawable((Drawable)new ColorDrawable(0));
    WindowManager.LayoutParams layoutParams = window.getAttributes();
    alertDialog.show();
    window.setContentView(2131493023);
    LinearLayout linearLayout = (LinearLayout)window.findViewById(2131299808);
    UserRelationshipUtils.a((ImageView)window.findViewById(2131297575), (this.s.d()).vbadge, 3);
    ImageView imageView1 = (ImageView)window.findViewById(2131299350);
    imageView1.setOnLongClickListener(new -$$Lambda$UserInfoFragmentNew$bJF5aa3oQqp-EuHFWN8xu_mp2Lc(this, linearLayout));
    layoutParams.width = -2;
    layoutParams.height = -2;
    window.setAttributes(layoutParams);
    ImageView imageView2 = (ImageView)window.findViewById(2131296928);
    ImageLoader.a((IRequestHost)w_(), AvatarUtils.a(0, (this.s.d()).avatar)).c().a(imageView2);
    TextView textView = (TextView)window.findViewById(2131296937);
    textView.setText((this.s.d()).name);
    UserRelationshipUtils.a(this.d, textView, (UserBasicModel)this.s.d());
    UserRelationshipUtils.a((ImageView)window.findViewById(2131297581), (UserBasicModel)this.s.d());
    if (!this.s.f())
      UserHttpUtils.a(this.d, (this.s.d()).uid, new BinaryHttpResponseHandler(this, true, imageView1) {
            public void a(Throwable param1Throwable, int param1Int, byte[] param1ArrayOfbyte) {
              super.onFailure(param1Throwable, param1Int, param1ArrayOfbyte);
            }
            
            public void a(byte[] param1ArrayOfbyte) {
              Bitmap bitmap2 = BitmapFactory.decodeByteArray(param1ArrayOfbyte, 0, param1ArrayOfbyte.length);
              Bitmap bitmap1 = BitmapFactory.decodeByteArray(param1ArrayOfbyte, 0, param1ArrayOfbyte.length);
              this.a.setImageBitmap(bitmap1);
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(this.b.d.getFilesDir());
              stringBuilder.append("/");
              stringBuilder.append(UserInfo.a().i().getUid());
              stringBuilder.append(".bmp");
              BitmapUtils.a(stringBuilder.toString(), bitmap2, 100, true);
            }
            
            public void onFinish() {
              DialogUtils.b(this.b.z);
              super.onFinish();
            }
            
            public void onStart() {
              super.onStart();
              DialogUtils.a(this.b.z);
            }
          }(IRequestHost)w_()); 
  }
  
  private Animation B() {
    TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    translateAnimation.setDuration(300L);
    return (Animation)translateAnimation;
  }
  
  private void a(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("个人主页 setAvatarWidget：");
    stringBuilder.append(paramInt);
    Log.v("drb", stringBuilder.toString());
    ImageLoader.a((IRequestHost)w_(), AvatarWidgetManager.a().a(paramInt)).a(this.T);
    ImageLoader.a((IRequestHost)w_(), AvatarWidgetManager.a().a(paramInt)).a(this.U);
  }
  
  private static void a(Context paramContext) {
    if (Build.MANUFACTURER.toLowerCase().equals("huawei") && paramContext instanceof Activity)
      ((Activity)paramContext).overridePendingTransition(2130771982, 2130772039); 
  }
  
  public static void a(Context paramContext, UserBasicModel paramUserBasicModel, String paramString, View paramView) {
    a(paramContext, paramUserBasicModel, paramString, false, paramView, (LogData)null, (MsgSourceEntity)null);
  }
  
  public static void a(Context paramContext, UserBasicModel paramUserBasicModel, String paramString, View paramView, LogData paramLogData, MsgSourceEntity paramMsgSourceEntity) {
    a(paramContext, paramUserBasicModel, paramString, false, paramView, paramLogData, paramMsgSourceEntity);
  }
  
  public static void a(Context paramContext, UserBasicModel paramUserBasicModel, String paramString, boolean paramBoolean, View paramView, LogData paramLogData, MsgSourceEntity paramMsgSourceEntity) {
    Bundle bundle = new Bundle();
    bundle.putSerializable("user", (Serializable)paramUserBasicModel);
    bundle.putString("userfrom", paramString);
    bundle.putBoolean("is_living", paramBoolean);
    int i = paramUserBasicModel.is_shadow;
    boolean bool = false;
    if (i == 1) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    } 
    bundle.putBoolean("is_shadow", paramBoolean);
    if (paramUserBasicModel.is_reactive_recommend == 1) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    } 
    bundle.putBoolean("is_reactive_recommend", paramBoolean);
    paramBoolean = bool;
    if (paramUserBasicModel.is_call == 1)
      paramBoolean = true; 
    bundle.putBoolean("is_call", paramBoolean);
    bundle.putSerializable("LOG_DATA", (Serializable)paramLogData);
    bundle.putSerializable("MSG_SOURCE_ENTITY", (Serializable)paramMsgSourceEntity);
    TerminalActivity.a(bundle);
    TerminalActivity.d(paramContext, UserInfoFragmentNew.class, bundle);
    a(paramContext);
  }
  
  public static void a(Context paramContext, UserBasicModel paramUserBasicModel, String paramString, boolean paramBoolean, MsgSourceEntity paramMsgSourceEntity) {
    Bundle bundle = new Bundle();
    bundle.putSerializable("user", (Serializable)paramUserBasicModel);
    bundle.putString("userfrom", paramString);
    bundle.putBoolean("is_living", paramBoolean);
    bundle.putSerializable("MSG_SOURCE_ENTITY", (Serializable)paramMsgSourceEntity);
    TerminalActivity.a(bundle);
    TerminalActivity.d(paramContext, UserInfoFragmentNew.class, bundle);
    a(paramContext);
  }
  
  public static void a(Context paramContext, String paramString) {
    Bundle bundle = new Bundle();
    bundle.putSerializable("user", (Serializable)new UserBasicModel(paramString));
    bundle.putBoolean("IF_SHOW_WITH_ECOLOGY_VIEW", true);
    TerminalActivity.a(bundle);
    TerminalActivity.d(paramContext, UserInfoFragmentNew.class, bundle);
    a(paramContext);
  }
  
  public static void a(Context paramContext, String paramString1, LogData paramLogData, String paramString2) {
    UserBasicModel userBasicModel = new UserBasicModel();
    String str = paramString1;
    if (StringUtils.e(paramString1))
      str = (UserInfo.a().i()).uid; 
    userBasicModel.uid = str;
    a(paramContext, userBasicModel, paramString2, (View)null, paramLogData, (MsgSourceEntity)null);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2) {
    UserBasicModel userBasicModel = new UserBasicModel();
    String str = paramString1;
    if (StringUtils.e(paramString1))
      str = (UserInfo.a().i()).uid; 
    userBasicModel.uid = str;
    a(paramContext, userBasicModel, paramString2, false, (MsgSourceEntity)null);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, MsgSourceEntity paramMsgSourceEntity) {
    UserBasicModel userBasicModel = new UserBasicModel();
    String str = paramString1;
    if (StringUtils.e(paramString1))
      str = (UserInfo.a().i()).uid; 
    userBasicModel.uid = str;
    a(paramContext, userBasicModel, paramString2, false, paramMsgSourceEntity);
  }
  
  public static void a(Fragment paramFragment, UserBasicModel paramUserBasicModel, String paramString, int paramInt) {
    Bundle bundle = new Bundle();
    bundle.putSerializable("user", (Serializable)paramUserBasicModel);
    bundle.putString("userfrom", paramString);
    TerminalActivity.a(bundle);
    TerminalActivity.a(paramFragment, UserInfoFragmentNew.class, bundle, paramInt);
    a((Context)paramFragment.getActivity());
  }
  
  private void a(String paramString) {
    ClipData clipData;
    if (Build.VERSION.SDK_INT != 18) {
      ClipboardManager clipboardManager = (ClipboardManager)this.d.getSystemService("clipboard");
      clipData = ClipData.newPlainText("simple text", RegExpUtils.a(paramString));
      if (clipboardManager != null)
        clipboardManager.setPrimaryClip(clipData); 
    } else {
      ((ClipboardManager)this.d.getSystemService("clipboard")).setText(RegExpUtils.a((String)clipData));
    } 
    AppMethods.a(this.d.getResources().getString(2131756130));
  }
  
  public static void b(Context paramContext, String paramString1, LogData paramLogData, String paramString2) {
    Bundle bundle = new Bundle();
    UserBasicModel userBasicModel = new UserBasicModel();
    userBasicModel.name = paramString1;
    bundle.putSerializable("user", (Serializable)userBasicModel);
    bundle.putString("userfrom", paramString2);
    bundle.putSerializable("LOG_DATA", (Serializable)paramLogData);
    TerminalActivity.a(bundle);
    TerminalActivity.d(paramContext, UserInfoFragmentNew.class, bundle);
    a(paramContext);
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2) {
    UserBasicModel userBasicModel = new UserBasicModel();
    String str = paramString1;
    if (StringUtils.e(paramString1))
      str = (UserInfo.a().i()).uid; 
    userBasicModel.uid = str;
    Bundle bundle = new Bundle();
    bundle.putSerializable("user", (Serializable)userBasicModel);
    bundle.putString("userfrom", paramString2);
    bundle.putInt("tab", 0);
    TerminalActivity.a(bundle);
    TerminalActivity.d(paramContext, UserInfoFragmentNew.class, bundle);
    a(paramContext);
  }
  
  private void b(View paramView) {
    AlertDialog alertDialog = (new AlertDialog.Builder((Context)getActivity())).create();
    alertDialog.setCanceledOnTouchOutside(true);
    Window window = alertDialog.getWindow();
    window.setGravity(80);
    window.setBackgroundDrawable((Drawable)new ColorDrawable(0));
    alertDialog.show();
    window.setContentView(2131493030);
    window.findViewById(2131299551).startAnimation(B());
    ((TextView)window.findViewById(2131296633)).setOnClickListener(new -$$Lambda$UserInfoFragmentNew$g_cCyLCfKgOPfQS5BlwaQMnUWjc(alertDialog));
    ((TextView)window.findViewById(2131299550)).setOnClickListener(new -$$Lambda$UserInfoFragmentNew$roLCpO9zgbCzziI1NCukHrmuhuk(this, paramView, alertDialog));
  }
  
  private Bitmap c(View paramView) {
    Bitmap bitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.RGB_565);
    paramView.draw(new Canvas(bitmap));
    return bitmap;
  }
  
  public static void c(Context paramContext, String paramString1, String paramString2) {
    Bundle bundle = new Bundle();
    UserBasicModel userBasicModel = new UserBasicModel();
    userBasicModel.name = paramString1;
    bundle.putSerializable("user", (Serializable)userBasicModel);
    bundle.putString("userfrom", paramString2);
    TerminalActivity.a(bundle);
    TerminalActivity.d(paramContext, UserInfoFragmentNew.class, bundle);
    a(paramContext);
  }
  
  private void l(UserInfoEntity paramUserInfoEntity) {
    if (paramUserInfoEntity == null || StringUtils.e(paramUserInfoEntity.uid)) {
      this.aq.setVisibility(8);
      return;
    } 
    if (paramUserInfoEntity.photos_count == 0) {
      this.aq.setVisibility(8);
      return;
    } 
    RecyclerView recyclerView = this.aq;
    int i = 0;
    recyclerView.setVisibility(0);
    UserinfoNewAlbumAdapter userinfoNewAlbumAdapter = this.ar;
    if (userinfoNewAlbumAdapter == null) {
      this.ar = new UserinfoNewAlbumAdapter((IRequestHost)w_(), this.d, this.H.name, TextUtils.equals((UserInfo.a().i()).uid, this.H.uid), paramUserInfoEntity.access_private_photos);
    } else {
      userinfoNewAlbumAdapter.a(paramUserInfoEntity.access_private_photos);
    } 
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.d);
    linearLayoutManager.setOrientation(0);
    this.aq.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    this.aq.setNestedScrollingEnabled(false);
    this.aq.setAdapter((RecyclerView.Adapter)this.ar);
    this.ar.a(new -$$Lambda$UserInfoFragmentNew$pYsiuQtR4Re-2H596snA8G8dhBI(this, paramUserInfoEntity));
    List list = paramUserInfoEntity.album;
    if (paramUserInfoEntity.vip_grade == 0 && list.size() > 6)
      while (i < list.size()) {
        int j = i;
        if (i > 5) {
          list.remove(list.get(i));
          j = i - 1;
        } 
        i = j + 1;
      }  
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("userInfo.album:");
    stringBuilder.append(paramUserInfoEntity.photos_count);
    Log.v("drb", stringBuilder.toString());
    if (paramUserInfoEntity.privacy_photos_has_locked == 1) {
      this.ar.c(list);
      return;
    } 
    if (paramUserInfoEntity.photos_count > 0) {
      BluedAlbum bluedAlbum = new BluedAlbum();
      int j = paramUserInfoEntity.privacy_photos_has_locked;
      i = 2;
      if (j != 2)
        i = 1; 
      bluedAlbum.applyStatus = i;
      ArrayList<BluedAlbum> arrayList = new ArrayList();
      arrayList.add(bluedAlbum);
      this.ar.c(arrayList);
      Log.v("drb", "albumFlow add showApply");
    } 
  }
  
  private void m(UserInfoEntity paramUserInfoEntity) {
    if (paramUserInfoEntity == null)
      return; 
    if (!this.s.f()) {
      if ("1".equals(paramUserInfoEntity.is_access_follows) || paramUserInfoEntity.uid.equalsIgnoreCase((UserInfo.a().i()).uid)) {
        BluedConstant.e = 0;
        Bundle bundle = new Bundle();
        bundle.putString("followed_or_fan", "followed");
        bundle.putString("uid", paramUserInfoEntity.uid);
        TerminalActivity.d(this.d, FollowedAndFansFragment.class, bundle);
        return;
      } 
      AppMethods.a(AppInfo.d().getResources().getString(2131756384));
      return;
    } 
  }
  
  private void n(UserInfoEntity paramUserInfoEntity) {
    if (paramUserInfoEntity == null)
      return; 
    if (!this.s.f()) {
      if ("1".equals(paramUserInfoEntity.is_access_followers) || paramUserInfoEntity.uid.equalsIgnoreCase((UserInfo.a().i()).uid)) {
        BluedConstant.e = 1;
        Bundle bundle = new Bundle();
        bundle.putString("followed_or_fan", "fans");
        bundle.putString("uid", paramUserInfoEntity.uid);
        TerminalActivity.d(this.d, FollowedAndFansFragment.class, bundle);
        return;
      } 
      AppMethods.d(2131756384);
      return;
    } 
  }
  
  private void z() {
    LiveEventBus.get("into_new_yy_room", String.class).observe((LifecycleOwner)this, new Observer<String>(this) {
          public void a(String param1String) {
            YYRoomInfoManager.d().a((BaseFragmentActivity)this.a.getActivity(), param1String, "mine_chat_room");
          }
        });
    LiveEventBus.get("remove_album", String.class).observe((LifecycleOwner)this, new Observer<String>(this) {
          public void a(String param1String) {
            UserInfoFragmentNew.a(this.a).a(false, param1String);
          }
        });
    LiveEventBus.get("feed_avatar_widget", Integer.class).observe((LifecycleOwner)this, new Observer<Integer>(this) {
          public void a(Integer param1Integer) {
            if (TextUtils.equals((this.a.s.d()).uid, (UserInfo.a().i()).uid))
              UserInfoFragmentNew.a(this.a, param1Integer.intValue()); 
          }
        });
  }
  
  public boolean V_() {
    u();
    return true;
  }
  
  public String X_() {
    UserBasicModel userBasicModel = (UserBasicModel)getArguments().getSerializable("user");
    return (userBasicModel != null && userBasicModel.uid.equalsIgnoreCase((UserInfo.a().i()).uid)) ? "A56" : "A57";
  }
  
  public void a(View paramView) {
    paramView.setOnClickListener(new -$$Lambda$UserInfoFragmentNew$06_N9Wc01njTwFdQcwBL9qlMVKg(this));
  }
  
  public void a(View paramView, View.OnClickListener paramOnClickListener) {
    Logger.c("hover_btns", new Object[] { " playImageButtonClickAnimator()" });
    AnimatorSet animatorSet = new AnimatorSet();
    ValueAnimator valueAnimator1 = ObjectAnimator.ofFloat(new float[] { 1.0F, 0.7F });
    valueAnimator1.setDuration(50L);
    valueAnimator1.addUpdateListener(new -$$Lambda$UserInfoFragmentNew$UWo8nvwzyVVjiCTGP0EVK6xIEfU(paramView));
    ValueAnimator valueAnimator2 = ObjectAnimator.ofFloat(new float[] { 0.7F, 1.0F });
    valueAnimator2.setDuration(50L);
    valueAnimator2.addUpdateListener(new -$$Lambda$UserInfoFragmentNew$UhiUuKYTHGXOfcS3jQiRSnvz-38(paramView));
    valueAnimator2.setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
    animatorSet.playSequentially(new Animator[] { (Animator)valueAnimator1, (Animator)valueAnimator2 });
    animatorSet.addListener(new Animator.AnimatorListener(this, paramView, paramOnClickListener) {
          public void onAnimationCancel(Animator param1Animator) {}
          
          public void onAnimationEnd(Animator param1Animator) {
            this.b.onClick(this.a);
            this.a.setOnClickListener(this.c);
          }
          
          public void onAnimationRepeat(Animator param1Animator) {}
          
          public void onAnimationStart(Animator param1Animator) {
            this.a.setOnClickListener(null);
          }
        });
    animatorSet.start();
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
  
  public void a(SmartRefreshLayout paramSmartRefreshLayout) {
    paramSmartRefreshLayout.a((OnMultiPurposeListener)new SimpleMultiPurposeListener(this) {
          public void a(RefreshHeader param1RefreshHeader, boolean param1Boolean, float param1Float, int param1Int1, int param1Int2, int param1Int3) {
            if (param1Int1 > 0) {
              this.a.u.d();
              this.a.u.a(-6.0F);
              FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.a.n.getLayoutParams();
              param1Int2 = AppInfo.l;
              param1Int1 = (int)(param1Int1 * 1.3F);
              layoutParams.height = param1Int2 + param1Int1;
              layoutParams.width = AppInfo.l + param1Int1;
              layoutParams.leftMargin = -param1Int1 / 2;
              this.a.n.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
              layoutParams = (FrameLayout.LayoutParams)this.a.q.getLayoutParams();
              layoutParams.height = AppInfo.l + param1Int1;
              this.a.q.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            } 
          }
          
          public void a(RefreshLayout param1RefreshLayout, RefreshState param1RefreshState1, RefreshState param1RefreshState2) {
            if (param1RefreshState2 == RefreshState.b) {
              this.a.u.setVisibility(0);
              this.a.v.setVisibility(4);
              this.a.w.setVisibility(4);
              return;
            } 
            if (param1RefreshState2 == RefreshState.d || param1RefreshState2 == RefreshState.a) {
              this.a.u.setVisibility(8);
              if (!this.a.s.g()) {
                this.a.v.setVisibility(0);
                this.a.w.setVisibility(0);
              } 
            } 
          }
          
          public void onRefresh(RefreshLayout param1RefreshLayout) {
            this.a.b(false);
          }
        });
  }
  
  public void a(FuGiftListEvent paramFuGiftListEvent) {
    if (paramFuGiftListEvent.a == null)
      return; 
    this.ap = paramFuGiftListEvent;
    y();
  }
  
  public void a(GiftGivingOptionForJsonParse paramGiftGivingOptionForJsonParse) {
    if (paramGiftGivingOptionForJsonParse == null)
      return; 
    if (paramGiftGivingOptionForJsonParse.type == -1)
      return; 
    UserInfoNewPresenter userInfoNewPresenter = this.s;
    if (userInfoNewPresenter != null)
      userInfoNewPresenter.a(paramGiftGivingOptionForJsonParse); 
    (UserPagerGiftManager.a()).a = paramGiftGivingOptionForJsonParse;
    if ("chat_setting".equalsIgnoreCase(this.an) || "private_chatting".equalsIgnoreCase(this.an)) {
      if (getActivity() != null) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putBoolean("chat_setting", true);
        intent.putExtras(bundle);
        getActivity().setResult(-1, intent);
        getActivity().finish();
      } 
      return;
    } 
    y();
  }
  
  public void a(UserInfoEntity paramUserInfoEntity) {
    if (paramUserInfoEntity != null) {
      if (StringUtils.e(paramUserInfoEntity.uid))
        return; 
      boolean bool1 = paramUserInfoEntity.uid.equals((UserInfo.a().i()).uid);
      boolean bool = false;
      if (bool1) {
        if (paramUserInfoEntity.background_photo_auditing == 1) {
          this.q.setVisibility(0);
        } else {
          this.q.setVisibility(8);
        } 
        this.o.setImageResource(2131232678);
      } else {
        this.o.setImageResource(2131232677);
      } 
      this.ao = (EcologyPopView)this.e.findViewById(2131296966);
      if (this.J) {
        this.ao.setVisibility(0);
        this.ao.a(paramUserInfoEntity.uid, (IRequestHost)w_(), new -$$Lambda$UserInfoFragmentNew$IhkDXbrKGcfxdolgQoQ4HWQwtWE(this));
      } else {
        this.ao.setVisibility(8);
      } 
      if (paramUserInfoEntity.uid.equalsIgnoreCase((UserInfo.a().i()).uid)) {
        this.m.setVisibility(0);
        this.l.setVisibility(0);
      } else {
        this.m.setVisibility(8);
        this.l.setVisibility(8);
      } 
      if (paramUserInfoEntity != null) {
        b(paramUserInfoEntity);
        d(paramUserInfoEntity);
        e(paramUserInfoEntity);
        l(paramUserInfoEntity);
        f(paramUserInfoEntity);
        i(paramUserInfoEntity);
        h(paramUserInfoEntity);
        g(paramUserInfoEntity);
        c(paramUserInfoEntity);
        a(paramUserInfoEntity.theme_pendant);
      } 
      Context context = this.d;
      bool1 = TextUtils.equals((UserInfo.a().i()).uid, paramUserInfoEntity.uid);
      if ((this.s.d()).is_official == 1)
        bool = true; 
      this.Y = new UserProfileBtmOptions(context, bool1, bool, new View.OnClickListener(this) {
            public void onClick(View param1View) {
              InstantLog.b("user_page_options_click", 5);
              EventTrackPersonalProfile.b(PersonalProfileProtos.Event.USER_PAGE_OPTIONS_CLICK, this.a.H.uid, 5);
            }
          });
      this.ac = true;
    } 
  }
  
  public void a(UserInfoEntity paramUserInfoEntity, int paramInt) {
    if (paramInt == 404) {
      getActivity().finish();
      return;
    } 
    this.ai = true;
    this.j.a.a(paramUserInfoEntity);
    UserBasicModel userBasicModel = this.H;
    if (userBasicModel == null || StringUtils.e(userBasicModel.uid)) {
      this.j.b.b((UserBasicModel)paramUserInfoEntity);
      this.j.c.h = (UserBasicModel)paramUserInfoEntity;
      this.j.c.a(true);
    } 
    v();
  }
  
  public void a(String paramString, ImageView paramImageView, ShapeTextView paramShapeTextView) {
    if (!StringUtils.e(paramString)) {
      if ("0".equals(paramString)) {
        if (paramImageView != null)
          paramImageView.setImageResource(2131232784); 
        paramShapeTextView.setText(2131756537);
        ShapeHelper.a((ShapeHelper.ShapeView)paramShapeTextView, 2131100716);
        ShapeHelper.d((ShapeHelper.ShapeView)paramShapeTextView, 2131100716);
        return;
      } 
      if ("1".equals(paramString)) {
        if (paramImageView != null)
          paramImageView.setImageResource(2131232788); 
        paramShapeTextView.setText(2131756545);
        ShapeHelper.a((ShapeHelper.ShapeView)paramShapeTextView, 2131100844);
        ShapeHelper.d((ShapeHelper.ShapeView)paramShapeTextView, 2131100733);
        return;
      } 
      if ("2".equals(paramString)) {
        if (paramImageView != null)
          paramImageView.setImageResource(2131232785); 
        paramShapeTextView.setText(2131755437);
        ShapeHelper.a((ShapeHelper.ShapeView)paramShapeTextView, 2131100844);
        ShapeHelper.d((ShapeHelper.ShapeView)paramShapeTextView, 2131100716);
        return;
      } 
      if ("3".equals(paramString)) {
        if (paramImageView != null)
          paramImageView.setImageResource(2131232787); 
        paramShapeTextView.setText(2131756538);
        ShapeHelper.a((ShapeHelper.ShapeView)paramShapeTextView, 2131100844);
        ShapeHelper.d((ShapeHelper.ShapeView)paramShapeTextView, 2131100733);
        return;
      } 
      if (paramImageView != null)
        paramImageView.setImageResource(2131232784); 
      paramShapeTextView.setText(2131756537);
      ShapeHelper.a((ShapeHelper.ShapeView)paramShapeTextView, 2131100716);
      ShapeHelper.d((ShapeHelper.ShapeView)paramShapeTextView, 2131100716);
      return;
    } 
    if (paramImageView != null)
      paramImageView.setImageResource(2131232784); 
    paramShapeTextView.setText(2131756537);
    ShapeHelper.a((ShapeHelper.ShapeView)paramShapeTextView, 2131100716);
    ShapeHelper.d((ShapeHelper.ShapeView)paramShapeTextView, 2131100716);
  }
  
  public void a(boolean paramBoolean) {
    byte b;
    View view2 = this.ab;
    boolean bool = false;
    if (paramBoolean) {
      b = 0;
    } else {
      b = 8;
    } 
    view2.setVisibility(b);
    SmartRefreshLayout smartRefreshLayout = this.W;
    if (paramBoolean) {
      b = 0;
    } else {
      b = 8;
    } 
    smartRefreshLayout.setVisibility(b);
    View view1 = this.g;
    if (paramBoolean) {
      b = 0;
    } else {
      b = 8;
    } 
    view1.setVisibility(b);
    if (this.J) {
      EcologyPopView ecologyPopView = this.ao;
      if (paramBoolean) {
        b = bool;
      } else {
        b = 8;
      } 
      ecologyPopView.setVisibility(b);
    } 
  }
  
  public void a(boolean paramBoolean, String paramString) {
    UserinfoNewAlbumAdapter userinfoNewAlbumAdapter = this.ar;
    if (userinfoNewAlbumAdapter != null)
      userinfoNewAlbumAdapter.a(paramBoolean, paramString); 
  }
  
  public boolean a() {
    return this.t;
  }
  
  public void b(UserInfoEntity paramUserInfoEntity) {
    if (paramUserInfoEntity != null) {
      if (StringUtils.e(paramUserInfoEntity.uid))
        return; 
      View view1 = this.e.findViewById(2131300542);
      if (paramUserInfoEntity.avatar_audited == 0 && this.s.e) {
        view1.setVisibility(0);
      } else {
        view1.setVisibility(8);
      } 
      TextView textView1 = (TextView)this.e.findViewById(2131301088);
      ImageView imageView1 = (ImageView)this.e.findViewById(2131297528);
      ImageView imageView2 = (ImageView)this.e.findViewById(2131297581);
      TextView textView2 = (TextView)this.e.findViewById(2131301122);
      this.B = (TextView)this.e.findViewById(2131300715);
      this.C = (TextView)this.e.findViewById(2131300946);
      TextView textView3 = (TextView)this.e.findViewById(2131300777);
      TextView textView4 = (TextView)this.e.findViewById(2131300749);
      TextView textView5 = (TextView)this.e.findViewById(2131300778);
      TextView textView6 = (TextView)this.e.findViewById(2131300753);
      View view2 = this.e.findViewById(2131299127);
      if (paramUserInfoEntity.is_shadow == 1) {
        view2.setVisibility(0);
        view2.setOnClickListener(new -$$Lambda$UserInfoFragmentNew$z7pPxQud-M6ok7qbDv7CIRe3bBo(this));
      } else {
        view2.setVisibility(8);
      } 
      textView3.setText(StringUtils.b(paramUserInfoEntity.followed_count));
      textView4.setText(StringUtils.b(paramUserInfoEntity.followers_count));
      textView3.setOnClickListener(new -$$Lambda$UserInfoFragmentNew$Zl25kP-9U3_wMZHWsAp9FD8_UD8(this, paramUserInfoEntity));
      textView5.setOnClickListener(new -$$Lambda$UserInfoFragmentNew$CzPsgNze3rfRLA51bcYWXiUifQQ(this, paramUserInfoEntity));
      textView4.setOnClickListener(new -$$Lambda$UserInfoFragmentNew$t1IsdSMogodTWVCsle-ONiP7SMc(this, paramUserInfoEntity));
      textView6.setOnClickListener(new -$$Lambda$UserInfoFragmentNew$_2h6ix6ui6a6aKqZkibUvqG3QzY(this, paramUserInfoEntity));
      textView3 = (TextView)this.h.findViewById(2131300554);
      UserRelationshipUtils.a(this.d, textView3, (UserBasicModel)paramUserInfoEntity, 2131100838);
      UserRelationshipUtils.a(this.d, textView1, (UserBasicModel)paramUserInfoEntity, 2131100838);
      UserRelationshipUtils.a(imageView1, paramUserInfoEntity.vbadge, 2);
      if (imageView1.getVisibility() == 4 || imageView1.getVisibility() == 8)
        if (paramUserInfoEntity.uid.equalsIgnoreCase((UserInfo.a().i()).uid)) {
          imageView1.setVisibility(0);
          imageView1.setImageResource(2131234373);
        } else {
          imageView1.setVisibility(8);
        }  
      imageView1.setOnClickListener(new -$$Lambda$UserInfoFragmentNew$SX6O84m_kqv1-NZ7EGZP9Z-Eye4(this, paramUserInfoEntity));
      UserRelationshipUtils.a(imageView2, (UserBasicModel)paramUserInfoEntity);
      if (!StringUtils.e(paramUserInfoEntity.vip_url)) {
        EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_PROFILE_VIP_ICON_SHOW, paramUserInfoEntity.uid, paramUserInfoEntity.vip_grade);
        imageView2.setOnClickListener(new -$$Lambda$UserInfoFragmentNew$lf3pJiNHVqUMFvv955iulwXo3fk(this, paramUserInfoEntity));
      } else {
        imageView2.setOnClickListener(null);
      } 
      if (StringUtils.e(paramUserInfoEntity.note)) {
        textView1.setText(paramUserInfoEntity.name);
        textView3.setText(paramUserInfoEntity.name);
        textView2.setVisibility(8);
      } else {
        textView1.setText(paramUserInfoEntity.note);
        textView3.setText(paramUserInfoEntity.note);
        textView2.setVisibility(0);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        stringBuilder.append(paramUserInfoEntity.name);
        stringBuilder.append(")");
        textView2.setText(stringBuilder.toString());
      } 
      textView1.setOnLongClickListener(new -$$Lambda$UserInfoFragmentNew$mjOjSdVSFYf_SVjZL48v-d4v1NY(this, paramUserInfoEntity));
      if (UserInfo.a().i().getUid().equals(paramUserInfoEntity.uid))
        this.X = true; 
      if (paramUserInfoEntity.vbadge_hide_profile == 1 || ((paramUserInfoEntity.vbadge == 3 || paramUserInfoEntity.vbadge == 5) && !this.X)) {
        this.A.setVisibility(8);
      } else {
        String str1;
        this.A.setVisibility(0);
        if (StringUtils.e(paramUserInfoEntity.age)) {
          str1 = "-";
        } else {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(paramUserInfoEntity.age);
          stringBuilder1.append(this.d.getResources().getString(2131755267));
          str1 = stringBuilder1.toString();
        } 
        String str3 = StringUtils.a(paramUserInfoEntity.height, BlueAppLocal.c(), true);
        String str2 = str3;
        if (StringUtils.e(str3))
          str2 = "- cm"; 
        String str4 = StringUtils.b(paramUserInfoEntity.weight, BlueAppLocal.c(), true);
        str3 = str4;
        if (StringUtils.e(str4))
          str3 = "- kg"; 
        if ("-1".equalsIgnoreCase(paramUserInfoEntity.role)) {
          str4 = "~";
        } else {
          str4 = paramUserInfoEntity.role;
        } 
        paramUserInfoEntity.role = str4;
        str4 = UserRelationshipUtils.d(this.d, paramUserInfoEntity.role);
        textView3 = this.A;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str1);
        stringBuilder.append(" • ");
        stringBuilder.append(str2);
        stringBuilder.append(" • ");
        stringBuilder.append(str3);
        stringBuilder.append(" • ");
        stringBuilder.append(str4);
        textView3.setText(stringBuilder.toString());
      } 
      if (paramUserInfoEntity.vbadge == 3 && !this.X) {
        this.B.setVisibility(8);
        this.C.setVisibility(8);
        return;
      } 
      if (!StringUtils.e(paramUserInfoEntity.location)) {
        this.B.setText(paramUserInfoEntity.location);
        this.B.setVisibility(0);
      } else if (!StringUtils.e(paramUserInfoEntity.distance)) {
        this.B.setText(DistanceUtils.a(paramUserInfoEntity.distance, BlueAppLocal.c(), true));
        this.B.setVisibility(0);
      } else {
        this.B.setText("            ");
      } 
      DistanceUtils.a(this.d, this.B, (UserBasicModel)paramUserInfoEntity, 1);
      if (!StringUtils.e(paramUserInfoEntity.last_operate)) {
        this.C.setVisibility(0);
        this.C.setText(TimeAndDateUtils.f((Context)getActivity(), TimeAndDateUtils.b(paramUserInfoEntity.last_operate)));
      } else {
        this.C.setText("            ");
      } 
      TypefaceUtils.a(this.d, this.C, paramUserInfoEntity.is_hide_last_operate, 1);
    } 
  }
  
  public void b(boolean paramBoolean) {
    this.u.setVisibility(0);
    this.u.d();
    this.u.a(-15.0F);
    this.u.b();
    this.v.setVisibility(4);
    this.w.setVisibility(4);
    this.s.a(this.H);
    this.aj = false;
    this.ai = false;
    this.ak = false;
    if (!StringUtils.e(this.H.uid)) {
      this.j.c.a(true);
      this.j.b.a(true);
    } 
  }
  
  public void c(UserInfoEntity paramUserInfoEntity) {
    View view1 = this.e.findViewById(2131296611);
    View view2 = this.e.findViewById(2131296613);
    View view3 = this.e.findViewById(2131296612);
    this.e.findViewById(2131296610).setOnClickListener(new -$$Lambda$UserInfoFragmentNew$v0i5HR7gAO97yetjyAx6F_AKsXY(this));
    view1.setOnClickListener(new -$$Lambda$UserInfoFragmentNew$M4bR3gbhu8pOv4_CUEAUUoRGRL8(this));
    view2.setOnClickListener(new -$$Lambda$UserInfoFragmentNew$Z4wRgPO-NJHa_3g3p_eYgv2JIcY(this));
    view3.setOnClickListener(new -$$Lambda$UserInfoFragmentNew$38NQCjCxWZXTG4jgfeGlVa358Fs(this));
    if (StringUtils.e(paramUserInfoEntity.background_photo)) {
      view2.setVisibility(8);
    } else {
      view2.setVisibility(0);
    } 
    if (this.s.e) {
      view3.setVisibility(0);
      if (StringUtils.e(paramUserInfoEntity.background_photo)) {
        view1.setVisibility(8);
        return;
      } 
      view1.setVisibility(0);
      return;
    } 
    view1.setVisibility(8);
    view3.setVisibility(8);
  }
  
  public void c(boolean paramBoolean) {
    if (paramBoolean) {
      this.ar.a();
      return;
    } 
    this.ar.b();
  }
  
  public void d() {
    getActivity().finish();
  }
  
  public void d(UserInfoEntity paramUserInfoEntity) {
    ImageView imageView1 = (ImageView)this.e.findViewById(2131297435);
    ShapeTextView shapeTextView = (ShapeTextView)this.e.findViewById(2131297441);
    ImageView imageView2 = (ImageView)this.e.findViewById(2131297514);
    ImageView imageView3 = (ImageView)this.e.findViewById(2131297440);
    imageView1.setImageResource(2131231088);
    shapeTextView.setVisibility(8);
    imageView2.setVisibility(8);
    imageView3.setVisibility(8);
    if (paramUserInfoEntity != null && !StringUtils.e(paramUserInfoEntity.uid)) {
      String str1;
      String str2;
      if (paramUserInfoEntity.liveshow != null && paramUserInfoEntity.liveshow.session_id != null && !paramUserInfoEntity.uid.equals((UserInfo.a().i()).uid)) {
        EventTrackPersonalProfile.b(PersonalProfileProtos.Event.PROFILE_LIVING_SHOW, paramUserInfoEntity.uid);
        imageView1.setImageResource(2131231089);
        shapeTextView.setVisibility(0);
        ShapeHelper.d((ShapeHelper.ShapeView)shapeTextView, 2131099652);
        imageView2.setVisibility(0);
        imageView3.setVisibility(0);
        boolean bool = BlueAppLocal.d();
        str2 = "anim_live_en";
        String str = str2;
        if (bool) {
          str = str2;
          if (BlueAppLocal.d())
            str = "anim_live_zh"; 
        } 
        str2 = str;
        if (!BluedSkinUtils.c()) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(str);
          stringBuilder1.append("_dark");
          str2 = stringBuilder1.toString();
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append(".png");
        str1 = stringBuilder.toString();
        ImageLoader.c((IRequestHost)w_(), str1).f().e(-1).a(imageView2);
        ImageLoader.c((IRequestHost)w_(), "anim_user_bar_living.png").f().e(-1).a(imageView3);
        Log.v("drb", "满足直播");
        return;
      } 
      if (((UserInfoEntity)str1).voice_broadcast != null && !TextUtils.isEmpty(((UserInfoEntity)str1).voice_broadcast.room_id)) {
        String str4;
        EventTrackYY.b(ChatRoomProtos.Event.CHAT_ROOM_PROFILE_ENTER_SHOW, ((UserInfoEntity)str1).voice_broadcast.room_id, ((UserInfoEntity)str1).voice_broadcast.uid, ((UserInfoEntity)str1).voice_broadcast.room_type);
        str2.setImageResource(2131231087);
        shapeTextView.setVisibility(0);
        ShapeHelper.d((ShapeHelper.ShapeView)shapeTextView, 2131100658);
        imageView2.setVisibility(0);
        imageView3.setVisibility(0);
        boolean bool = BlueAppLocal.d();
        str2 = "anim_chat_en";
        str1 = str2;
        if (bool) {
          str1 = str2;
          if (BlueAppLocal.d())
            str1 = "anim_chat_zh"; 
        } 
        str2 = str1;
        if (!BluedSkinUtils.c()) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(str1);
          stringBuilder1.append("_dark");
          str4 = stringBuilder1.toString();
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str4);
        stringBuilder.append(".png");
        String str3 = stringBuilder.toString();
        ImageLoader.c((IRequestHost)w_(), str3).f().e(-1).a(imageView2);
        ImageLoader.c((IRequestHost)w_(), "anim_user_bar_chat.png").f().e(-1).a(imageView3);
        Log.v("drb", "满足聊天");
      } 
    } 
  }
  
  public void d(boolean paramBoolean) {
    this.ak = true;
    this.am = paramBoolean;
    v();
  }
  
  public void e(UserInfoEntity paramUserInfoEntity) {
    this.Z = this.e.findViewById(2131299083);
    if (paramUserInfoEntity == null || StringUtils.e(paramUserInfoEntity.uid)) {
      this.Z.setVisibility(8);
      return;
    } 
    if (StringUtils.e(paramUserInfoEntity.description)) {
      this.Z.setVisibility(8);
      return;
    } 
    this.Z.setVisibility(0);
    this.Z.setOnLongClickListener(new -$$Lambda$UserInfoFragmentNew$9pbfsaMsNXqC_LJgvYkeWEvL-zA(this, paramUserInfoEntity));
    TextViewFixTouchForDynamic textViewFixTouchForDynamic = (TextViewFixTouchForDynamic)this.e.findViewById(2131301342);
    TextView textView = (TextView)this.e.findViewById(2131301343);
    if (paramUserInfoEntity.description.equalsIgnoreCase(textView.getText().toString()))
      return; 
    textViewFixTouchForDynamic.setVisibility(0);
    ViewGroup.LayoutParams layoutParams = textViewFixTouchForDynamic.getLayoutParams();
    layoutParams.width = AppInfo.l - DensityUtils.a(this.d, 20.0F);
    textViewFixTouchForDynamic.setLayoutParams(layoutParams);
    textViewFixTouchForDynamic.setMaxWidth(layoutParams.width);
    textViewFixTouchForDynamic.setMaxLines(3);
    textViewFixTouchForDynamic.setMovementMethod((MovementMethod)LinkMovementClickMethod.a());
    textViewFixTouchForDynamic.setMoreText(this.d.getResources().getString(2131759224));
    textViewFixTouchForDynamic.setMoeTextColor(BluedSkinUtils.a(this.d, 2131100838));
    textViewFixTouchForDynamic.setExpandText(paramUserInfoEntity.description);
    textView.setVisibility(4);
    textView.setText(paramUserInfoEntity.description);
    textView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this, textView, 3, textViewFixTouchForDynamic) {
          public void onGlobalLayout() {
            this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            if (this.a.getLineCount() > this.b) {
              this.a.setVisibility(8);
              UserInfoFragmentNew.c(this.d).setOnClickListener(new -$$Lambda$UserInfoFragmentNew$10$OglEfSUfjPQPOmujUXCdM_a-tZs(this.c, this.a));
              return;
            } 
            this.a.setVisibility(0);
            this.c.setVisibility(8);
          }
        });
  }
  
  public void e(boolean paramBoolean) {
    this.aj = true;
    this.al = paramBoolean;
    v();
  }
  
  public void f(UserInfoEntity paramUserInfoEntity) {
    if (paramUserInfoEntity != null) {
      if (StringUtils.e(paramUserInfoEntity.uid))
        return; 
      ImageView imageView = (ImageView)this.e.findViewById(2131297580);
      ImageLoader.a((IRequestHost)w_(), 2131233722).a(imageView);
      BluedAlbum bluedAlbum = new BluedAlbum();
      bluedAlbum.setUrl(paramUserInfoEntity.avatar);
      if (!this.ac)
        ImageFileLoader.a(null).a(AvatarUtils.b(paramUserInfoEntity.avatar)).a(); 
      this.R = (ImageView)this.e.findViewById(2131297558);
      this.S = (ImageView)this.e.findViewById(2131297438);
      ImageLoader.a((IRequestHost)w_(), AvatarUtils.a(2, paramUserInfoEntity.avatar)).a(2131234356).a(50.0F).a(this.R);
      ImageLoader.a((IRequestHost)w_(), AvatarUtils.a(2, paramUserInfoEntity.avatar)).a(2131234356).a(50.0F).a(this.S);
      this.R.setOnClickListener(new -$$Lambda$UserInfoFragmentNew$Ncc-jRA9J9HxkZyvN0hkJSerY8w(this, paramUserInfoEntity));
      this.S.setOnClickListener(new -$$Lambda$UserInfoFragmentNew$4KgkSBgkyIYFnuaO5xiRMZGR33c(this));
      this.p = this.e.findViewById(2131297159);
      this.p.setOnClickListener(new -$$Lambda$UserInfoFragmentNew$h6AtbSh5gX2rUuNuaQUuSvUZnTQ(this));
      LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.p.getLayoutParams();
      layoutParams.height = this.as;
      this.p.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      (new ArrayList<BluedAlbum>()).add(0, bluedAlbum);
      ImageLoader.a((IRequestHost)w_(), AvatarUtils.a(3, paramUserInfoEntity.background_photo)).a(2131231100).c(2131231100).a(this.n);
      this.V = (TextView)this.e.findViewById(2131300546);
      if (this.X && (UserInfo.a().i()).vip_grade != 0 && !BluedPreferences.dp()) {
        this.V.setVisibility(0);
        AppInfo.n().postDelayed(new Runnable(this) {
              public void run() {
                this.a.V.setVisibility(8);
                BluedPreferences.dq();
              }
            },  5000L);
      } 
    } 
  }
  
  protected void finalize() throws Throwable {
    super.finalize();
    Log.v("finalize", "Userinfo finalize");
  }
  
  public void g(UserInfoEntity paramUserInfoEntity) {
    View view1 = this.e.findViewById(2131297163);
    View view2 = this.e.findViewById(2131298781);
    View view3 = this.e.findViewById(2131298811);
    if (paramUserInfoEntity == null || StringUtils.e(paramUserInfoEntity.uid) || !this.s.g()) {
      this.D.setVisibility(8);
      view1.setVisibility(0);
      this.i.setVisibility(0);
      view2.setVisibility(0);
      view3.setVisibility(0);
      return;
    } 
    paramUserInfoEntity.is_show_vip_page = 0;
    f(paramUserInfoEntity);
    view2.setVisibility(8);
    view3.setVisibility(8);
    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.D.getLayoutParams();
    layoutParams.height = AppInfo.m - StatusBarHelper.a(this.d) - DensityUtils.a(this.d, 44.0F);
    this.D.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.D.setVisibility(0);
    this.A.setText(this.d.getResources().getString(2131757155));
    this.Z.setVisibility(8);
    view1.setVisibility(8);
    this.i.setVisibility(8);
    this.E.setOnClickListener(new -$$Lambda$UserInfoFragmentNew$77zVTBqH4bx6DXDnj8iB0AXzERc(this, paramUserInfoEntity));
    if ("4".equals(paramUserInfoEntity.relationship) || "12".equals(paramUserInfoEntity.relationship)) {
      this.F.setText(this.d.getResources().getString(2131758573));
    } else {
      this.F.setText(this.d.getResources().getString(2131755241));
    } 
    this.F.setOnClickListener(new -$$Lambda$UserInfoFragmentNew$b18_RdUw7YZpM_NH5_bkAbZw_9c(this));
    this.G.setOnClickListener(new -$$Lambda$UserInfoFragmentNew$Ha6bqExnZFFxEDjbOEvKnqO-Yno(this));
    this.w.setVisibility(4);
    this.v.setVisibility(4);
  }
  
  public void h(UserInfoEntity paramUserInfoEntity) {
    if (paramUserInfoEntity != null) {
      if (StringUtils.e(paramUserInfoEntity.uid))
        return; 
      if (paramUserInfoEntity.uid.equalsIgnoreCase((UserInfo.a().i()).uid)) {
        this.ag.setVisibility(8);
        this.ae.setVisibility(8);
        this.af.setVisibility(8);
        this.ah.setVisibility(0);
        return;
      } 
      a(paramUserInfoEntity.relationship, (ImageView)null, this.ae);
      a(paramUserInfoEntity.relationship, (ImageView)null, this.af);
      this.af.setVisibility(0);
      this.ag.setVisibility(0);
      this.ae.setVisibility(0);
      this.ah.setVisibility(8);
    } 
  }
  
  public void i(UserInfoEntity paramUserInfoEntity) {
    ImageSize imageSize;
    View view = this.e.findViewById(2131297140);
    if (paramUserInfoEntity == null) {
      view.setVisibility(8);
      return;
    } 
    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
    layoutParams.rightMargin = 0;
    view.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    ImageView imageView2 = (ImageView)this.e.findViewById(2131297520);
    TextView textView2 = (TextView)this.e.findViewById(2131301028);
    if (paramUserInfoEntity.match_activity != null && !StringUtils.e(paramUserInfoEntity.match_activity.icon)) {
      view.setVisibility(0);
      FindHttpUtils.a(paramUserInfoEntity.match_activity.show_url);
      view.setOnClickListener(new -$$Lambda$UserInfoFragmentNew$GN9eeUse0aBUKH9wyWHmY1iuks0(this, paramUserInfoEntity));
      imageSize = new ImageSize();
      ImageFileLoader.a((IRequestHost)w_()).a(paramUserInfoEntity.match_activity.icon).a(imageSize).a(new -$$Lambda$UserInfoFragmentNew$GxMqQDEmQMZlpSStXWARev23VW8(this, imageSize, imageView2, paramUserInfoEntity)).a();
      textView2.setText(paramUserInfoEntity.match_activity.match_activity_text);
    } else {
      imageSize.setVisibility(8);
    } 
    BluedADConstraintLayout bluedADConstraintLayout = (BluedADConstraintLayout)this.e.findViewById(2131296419);
    if (paramUserInfoEntity.ads_activity == null || StringUtils.e(paramUserInfoEntity.ads_activity.ads_pics)) {
      bluedADConstraintLayout.setVisibility(8);
      return;
    } 
    bluedADConstraintLayout.setVisibility(0);
    bluedADConstraintLayout.setADData((BluedADExtra)paramUserInfoEntity.ads_activity);
    ImageView imageView1 = (ImageView)this.e.findViewById(2131297443);
    TextView textView1 = (TextView)this.e.findViewById(2131300558);
    if (!StringUtils.e(paramUserInfoEntity.ads_activity.ads_pics)) {
      ImageLoader.a((IRequestHost)w_(), paramUserInfoEntity.ads_activity.ads_pics).a(imageView1);
    } else {
      imageView1.setImageResource(2131232676);
    } 
    textView1.setText(paramUserInfoEntity.ads_activity.title);
  }
  
  public void j(UserInfoEntity paramUserInfoEntity) {
    if (paramUserInfoEntity != null)
      if (paramUserInfoEntity.liveshow != null && paramUserInfoEntity.liveshow.session_id != null) {
        if (!this.s.f()) {
          EventTrackPersonalProfile.b(PersonalProfileProtos.Event.PERSONAL_PROFILE_PAGE_LIVE_ENTER_CLICK, paramUserInfoEntity.uid);
          InstantLog.a("live_view_from_userinfo", this.an);
          UserInfoEntity._liveshow _liveshow = paramUserInfoEntity.liveshow;
          UserRelationshipUtils.a(this.d, (UserBasicModel)paramUserInfoEntity, _liveshow.session_id.longValue(), "profile");
          return;
        } 
      } else if (!StringUtils.e(paramUserInfoEntity.game_url) && !StringUtils.e(paramUserInfoEntity.game_url)) {
        InstantLog.a(1, paramUserInfoEntity.game_url);
        WebViewShowInfoFragment.show(this.d, paramUserInfoEntity.game_url, -1);
      }  
  }
  
  public void k() {
    if (getArguments() != null) {
      this.an = getArguments().getString("userfrom");
      try {
        this.H = (UserBasicModel)getArguments().getSerializable("user");
      } catch (Exception exception) {}
      this.I = getArguments().getBoolean("is_living");
      this.K = getArguments().getBoolean("is_shadow");
      this.M = getArguments().getBoolean("is_reactive_recommend");
      this.L = getArguments().getBoolean("is_call");
      this.N = (MsgSourceEntity)getArguments().getSerializable("MSG_SOURCE_ENTITY");
      this.O = (LogData)getArguments().getSerializable("LOG_DATA");
      this.P = getArguments().getInt("tab", -1);
      this.J = getArguments().getBoolean("IF_SHOW_WITH_ECOLOGY_VIEW", false);
    } 
    if (this.O == null)
      this.O = new LogData(); 
  }
  
  public void k(UserInfoEntity paramUserInfoEntity) {
    if (!this.s.f()) {
      if (paramUserInfoEntity.vbadge == 4 && paramUserInfoEntity.uid.equals((UserInfo.a().i()).uid)) {
        if (paramUserInfoEntity.verify != null) {
          if (paramUserInfoEntity.verify.length > 0) {
            ShowVerifyFragment.a(this.d, paramUserInfoEntity.name, paramUserInfoEntity.avatar, (paramUserInfoEntity.verify[0]).verified_time, paramUserInfoEntity.uid, true);
            return;
          } 
          ShowVerifyFragment.a(this.d, paramUserInfoEntity.name, paramUserInfoEntity.avatar, "", paramUserInfoEntity.uid, true);
          return;
        } 
        ShowVerifyFragment.a(this.d, paramUserInfoEntity.name, paramUserInfoEntity.avatar, "", paramUserInfoEntity.uid, true);
        return;
      } 
      if ((UserInfo.a().i()).uid.equalsIgnoreCase(paramUserInfoEntity.uid) && paramUserInfoEntity.vbadge == 0) {
        PersonalVerifyFragment.a(this.d, 1);
        return;
      } 
      CommonAlertDialog.a(this.d, paramUserInfoEntity.vbadge);
    } 
  }
  
  public void l() {
    this.ab = this.e.findViewById(2131297580);
    this.ab.setOnClickListener(new -$$Lambda$UserInfoFragmentNew$3XDb0ULNu5k-5oa34fTwd1swbfg(this));
    this.aq = (RecyclerView)this.e.findViewById(2131299603);
    this.aq.setBackgroundColor(BluedSkinUtils.a(this.d, 2131100728));
    this.o = (ImageView)this.e.findViewById(2131297449);
    this.o.setOnClickListener(this);
    this.o.setAlpha(0.0F);
    this.ag = this.e.findViewById(2131296586);
    this.ag.setOnClickListener(this);
    this.ah = this.e.findViewById(2131296603);
    this.ah.setOnClickListener(this);
    this.ae = (ShapeTextView)this.e.findViewById(2131296590);
    this.ae.setOnClickListener(this);
    this.af = (ShapeTextView)this.e.findViewById(2131296583);
    this.af.setOnClickListener(this);
    this.W = (SmartRefreshLayout)this.e.findViewById(2131299616);
    this.W.d(false);
    this.W.c(0.0F);
    a(this.W);
    this.q = (ShapeTextView)this.e.findViewById(2131300541);
    this.i = (CustomViewPager)this.e.findViewById(2131301616);
    this.i.setBackgroundColor(BluedSkinUtils.a(getContext(), 2131100728));
    this.i.setOffscreenPageLimit(3);
    this.z = DialogUtils.a(this.d);
    this.u = (RotateLayout)this.e.findViewById(2131299755);
    this.u.setVisibility(0);
    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams)this.u.getLayoutParams();
    layoutParams2.topMargin = this.at;
    this.u.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    this.r = new LoadOptions();
    LoadOptions loadOptions = this.r;
    loadOptions.d = 2131234466;
    loadOptions.b = 2131234466;
    this.n = (ImageView)this.e.findViewById(2131297579);
    FrameLayout.LayoutParams layoutParams1 = (FrameLayout.LayoutParams)this.n.getLayoutParams();
    layoutParams1.width = AppInfo.l;
    layoutParams1.height = layoutParams1.width;
    layoutParams1.topMargin = -AppInfo.l / 4;
    this.n.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    this.n.setOnClickListener(new -$$Lambda$UserInfoFragmentNew$ZuffyJFakdqQ6eeK1L0WGbK5vk0(this));
    layoutParams1 = (FrameLayout.LayoutParams)this.q.getLayoutParams();
    layoutParams1.width = AppInfo.l;
    layoutParams1.height = layoutParams1.width;
    layoutParams1.topMargin = -AppInfo.l / 4;
    this.q.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    this.l = (ImageView)this.e.findViewById(2131297472);
    this.m = (ImageView)this.e.findViewById(2131297471);
    a((View)this.l);
    a((View)this.m);
    this.D = this.e.findViewById(2131298891);
    this.E = (TextView)this.e.findViewById(2131301263);
    this.F = (TextView)this.e.findViewById(2131300571);
    this.G = (TextView)this.e.findViewById(2131300493);
    this.A = (TextView)this.e.findViewById(2131301473);
    this.T = (ImageView)this.e.findViewById(2131297700);
    this.U = (ImageView)this.e.findViewById(2131297439);
    ((AppBarLayout.Behavior)((CoordinatorLayout.LayoutParams)((AppBarLayout)this.e.findViewById(2131296447)).getLayoutParams()).getBehavior()).a((AppBarLayout.BaseBehavior.BaseDragCallback)new AppBarLayout.Behavior.DragCallback(this) {
          public boolean a(AppBarLayout param1AppBarLayout) {
            return true;
          }
        });
  }
  
  public void m() {
    if (this.u.getVisibility() == 0)
      return; 
    EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_BACKGROUND_CLICK);
    ValueAnimator valueAnimator = p();
    valueAnimator.addListener(new Animator.AnimatorListener(this) {
          public void onAnimationCancel(Animator param1Animator) {}
          
          public void onAnimationEnd(Animator param1Animator) {
            this.a.a(new -$$Lambda$UserInfoFragmentNew$5$_gbxB6pb41UqLclnSo0hMeM4jOQ(this), 50L);
          }
          
          public void onAnimationRepeat(Animator param1Animator) {}
          
          public void onAnimationStart(Animator param1Animator) {
            this.a.a(true);
          }
        });
    valueAnimator.start();
  }
  
  public void n() {
    EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_BACKGROUND_CLICK);
    ValueAnimator valueAnimator = p();
    valueAnimator.addListener(new Animator.AnimatorListener(this) {
          public void onAnimationCancel(Animator param1Animator) {}
          
          public void onAnimationEnd(Animator param1Animator) {
            this.a.a(true);
          }
          
          public void onAnimationRepeat(Animator param1Animator) {}
          
          public void onAnimationStart(Animator param1Animator) {
            this.a.a(true);
          }
        });
    valueAnimator.reverse();
  }
  
  public void o() {
    Context context = this.d;
    CommonAlertDialog.a(context, context.getResources().getString(2131758460), new -$$Lambda$UserInfoFragmentNew$k3_TbMLQ4x1IBoAeDFttGHRo5sE(this));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      b(false);
      if (paramInt1 != 178)
        return; 
      if (paramIntent != null) {
        String str = paramIntent.getStringExtra("photo_path");
        if (!StringUtils.e(str))
          this.s.c(str); 
      } 
    } 
  }
  
  public void onClick(View paramView) {
    LogData logData = this.O;
    logData.F = this.an;
    logData.b = (this.s.d()).uid;
    switch (paramView.getId()) {
      default:
        return;
      case 2131297449:
        if (this.o.getAlpha() < 0.5F)
          return; 
        if (this.s.e) {
          a((View)this.o, new -$$Lambda$UserInfoFragmentNew$0HFhXhfvZnP2L9n6DQJTn5KdVtE(this));
          return;
        } 
        a((View)this.o, new -$$Lambda$UserInfoFragmentNew$7rFMCqnLlZrZhfDtJmbGMW5mv_A(this));
        return;
      case 2131296603:
        a(this.ah, new -$$Lambda$UserInfoFragmentNew$e4IkozQWs3OM--kGjCRGwICvIW8(this));
        return;
      case 2131296586:
        a(this.ag, new -$$Lambda$UserInfoFragmentNew$T5z-IDaL3kQbfY-pWGJtXZDw4EU(this));
        return;
      case 2131296583:
      case 2131296590:
        break;
    } 
    a((View)this.ae, new -$$Lambda$UserInfoFragmentNew$ve910mK0UaTVJbJxgYy4WLnYdcU(this));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = (Context)getActivity();
    getActivity().getWindow().setBackgroundDrawable(this.d.getResources().getDrawable(2131234242));
    this.at = StatusBarHelper.a(this.d);
    this.as = (int)(AppInfo.l / 2.0F) - DensityUtils.a(this.d, 74.0F) - this.at;
    View view = this.e;
    if (view == null) {
      k();
      this.s = new UserInfoNewPresenter(this.d, this, this.an, this.I, this.K, this.L, (IRequestHost)w_(), this.N);
      this.e = paramLayoutInflater.inflate(2131493347, paramViewGroup, false);
      this.f = new ArrayList<String>();
      this.f.add(this.d.getResources().getString(2131755272));
      this.f.add(this.d.getResources().getString(2131756467));
      this.f.add(this.d.getResources().getString(2131759181));
      q();
      l();
      r();
      UserinfoFeedScrollObserver.a().a(this);
      AlbumDataObserver.a().a(this);
      a(new UserInfoEntity(this.H));
      b(true);
      z();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    return this.e;
  }
  
  public void onDestroy() {
    Log.v("finalize", "Userinfo onDestroy");
    UserinfoFeedScrollObserver.a().b(this);
    AlbumDataObserver.a().b(this);
    super.onDestroy();
  }
  
  public void onPause() {
    super.onPause();
    LiveEventBus.get("buy_fu", FuGiftListEvent.class).removeObserver(this);
  }
  
  public void onResume() {
    super.onResume();
    LiveEventBus.get("buy_fu", FuGiftListEvent.class).observeForever(this);
  }
  
  public ValueAnimator p() {
    Logger.a("getanim", "1");
    this.aa.scrollTo(0, 0);
    FrameLayout.LayoutParams layoutParams1 = (FrameLayout.LayoutParams)this.n.getLayoutParams();
    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams)this.q.getLayoutParams();
    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.p.getLayoutParams();
    new ObjectAnimator();
    ValueAnimator valueAnimator = ObjectAnimator.ofInt(new int[] { 0, 100 });
    valueAnimator.setDuration(250L);
    valueAnimator.setInterpolator((TimeInterpolator)new LinearInterpolator());
    valueAnimator.addUpdateListener(new -$$Lambda$UserInfoFragmentNew$a3l6cMB0Iby_gaZUIHolSflcI1g(this, layoutParams1, layoutParams2, layoutParams));
    return valueAnimator;
  }
  
  public void q() {
    this.aa = (AppBarLayout)this.e.findViewById(2131296447);
    this.g = this.e.findViewById(2131300285);
    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.g.getLayoutParams();
    layoutParams.topMargin = StatusBarHelper.a(this.d);
    this.g.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.h = this.e.findViewById(2131300282);
    this.g.setAlpha(1.0F);
    this.v = (ImageView)this.g.findViewById(2131296868);
    this.w = (ImageView)this.h.findViewById(2131296856);
    this.x = (ImageView)this.g.findViewById(2131296865);
    this.x.setOnClickListener(new -$$Lambda$UserInfoFragmentNew$GBHFZBvFRLqdIeqH5eBigW0a7QM(this));
    this.y = (ImageView)this.h.findViewById(2131296855);
    this.y.setOnClickListener(new -$$Lambda$UserInfoFragmentNew$D7tdCK0r-b48a_fvv4c2vl8GWDs(this));
    this.h.setAlpha(0.0F);
    TextView textView = (TextView)this.e.findViewById(2131301439);
    textView.setAlpha(0.0F);
    LinearLayout.LayoutParams layoutParams1 = (LinearLayout.LayoutParams)textView.getLayoutParams();
    layoutParams1.height = StatusBarHelper.a(this.d);
    textView.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    this.v.setOnClickListener(new -$$Lambda$UserInfoFragmentNew$SM4ClZWYhXxf8VRNtjmfpdwR0MU(this));
    this.w.setOnClickListener(new -$$Lambda$UserInfoFragmentNew$TlqfTCuYGUS2x8vz0Xo7AQvPtmU(this));
    this.aa.a(new -$$Lambda$UserInfoFragmentNew$gjHjuBTrbs_D_e86ou75wYp-RK4(this, textView));
  }
  
  public void r() {
    this.j = new MyAdapter(this, getChildFragmentManager());
    this.i.setAdapter((PagerAdapter)this.j);
    this.k = (TabPageIndicatorWithDot)this.e.findViewById(2131300168);
    this.k.setIndicatorColor(2131100716);
    this.k.setViewPager((ViewPager)this.i);
    this.i.addOnPageChangeListener(new ViewPager.OnPageChangeListener(this) {
          public void onPageScrollStateChanged(int param1Int) {}
          
          public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
          
          public void onPageSelected(int param1Int) {
            if (!UserInfoFragmentNew.b(this.a)) {
              PersonalProfileProtos.TabType tabType = PersonalProfileProtos.TabType.UNKNOWN_TAB_TYPE;
              LogData logData = new LogData();
              logData.J = "userpage_shift_tab";
              if (param1Int != 0) {
                if (param1Int != 1) {
                  if (param1Int == 2) {
                    logData.g = "2";
                    tabType = PersonalProfileProtos.TabType.PROFILE_LOAD;
                  } 
                } else {
                  logData.g = "1";
                  tabType = PersonalProfileProtos.TabType.FEED_LOAD;
                } 
              } else {
                logData.g = "0";
                tabType = PersonalProfileProtos.TabType.PHOTO_LOAD;
              } 
              logData.c = (this.a.s.d()).uid;
              InstantLog.a(logData);
              EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_PROFILE_SHIFT_TAB, tabType, logData.c);
            } 
            if (param1Int == 0)
              EventTrackPersonalProfile.b(PersonalProfileProtos.Event.PERSONAL_PHOTO_PAGE_SHOW, (this.a.s.d()).uid); 
          }
        });
  }
  
  public void s() {
    Context context = this.d;
    CommonAlertDialog.a(context, context.getResources().getString(2131756101), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            MineHttpUtils.a((this.a.s.d()).uid, new BluedUIHttpResponse(this, (IRequestHost)this.a.w_()) {
                  public void onUIFinish() {
                    super.onUIFinish();
                    DialogUtils.b(this.a.a.z);
                  }
                  
                  public void onUIStart() {
                    super.onUIStart();
                    DialogUtils.a(this.a.a.z);
                  }
                  
                  public void onUIUpdate(BluedEntity param2BluedEntity) {
                    this.a.a.c(true);
                    AppMethods.d(2131755349);
                    ChatHelperV4.a().b((this.a.a.s.d()).uid, (this.a.a.s.d()).name, (this.a.a.s.d()).avatar, (this.a.a.s.d()).vbadge, (this.a.a.s.d()).vip_grade, (this.a.a.s.d()).is_vip_annual, (this.a.a.s.d()).vip_exp_lvl, (this.a.a.s.d()).is_hide_vip_look);
                  }
                }(IRequestHost)this.a.w_());
          }
        });
  }
  
  public void t() {
    if (TextUtils.isEmpty((this.s.d()).uid))
      return; 
    EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_PROFILE_MORE_BTN_CLICK, (this.s.d()).uid, (this.s.d()).vip_grade);
    -$$Lambda$UserInfoFragmentNew$1BwJPJwzdrMPEMtwA0_Q6h4TvP0 -$$Lambda$UserInfoFragmentNew$1BwJPJwzdrMPEMtwA0_Q6h4TvP0 = new -$$Lambda$UserInfoFragmentNew$1BwJPJwzdrMPEMtwA0_Q6h4TvP0(this);
    String str1;
    for (str1 = this.A.getText().toString(); str1.contains(" "); str1 = str1.replace(" ", ""));
    String str2 = BluedHttpUrl.a((this.s.d()).uid);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(this.d.getResources().getString(2131758759));
    stringBuilder1.append((this.s.d()).name);
    stringBuilder1.append(this.d.getResources().getString(2131758760));
    String str3 = stringBuilder1.toString();
    String str4 = (this.s.d()).location;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str4);
    stringBuilder2.append("\n");
    stringBuilder2.append(str1);
    str1 = stringBuilder2.toString();
    str4 = AvatarUtils.a(0, (this.s.d()).avatar);
    ImageFileLoader.a((IRequestHost)w_()).b(str4).a(new -$$Lambda$UserInfoFragmentNew$dpDnBHq_78nIhO5I9k5nGaslQUw(this, str4, str2, str3, str1, -$$Lambda$UserInfoFragmentNew$1BwJPJwzdrMPEMtwA0_Q6h4TvP0)).a();
  }
  
  public void u() {
    if (this.W.getVisibility() == 8) {
      n();
      return;
    } 
    UserInfoNewPresenter userInfoNewPresenter = this.s;
    if (userInfoNewPresenter != null && userInfoNewPresenter.d() != null && getActivity() != null) {
      Intent intent = new Intent();
      intent.putExtra("passby_is_in_blacklist", (this.s.d()).in_blacklist);
      getActivity().setResult(-1, intent);
    } 
    if (getActivity() != null) {
      if (Build.VERSION.SDK_INT >= 21) {
        getActivity().finishAfterTransition();
        return;
      } 
      getActivity().finish();
    } 
  }
  
  public void v() {
    // Byte code:
    //   0: aload_0
    //   1: getfield aj : Z
    //   4: ifeq -> 466
    //   7: aload_0
    //   8: getfield ak : Z
    //   11: ifne -> 15
    //   14: return
    //   15: aload_0
    //   16: getfield W : Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;
    //   19: invokevirtual g : ()Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;
    //   22: pop
    //   23: aload_0
    //   24: getfield u : Lcom/soft/blued/customview/RotateLayout;
    //   27: bipush #8
    //   29: invokevirtual setVisibility : (I)V
    //   32: aload_0
    //   33: getfield u : Lcom/soft/blued/customview/RotateLayout;
    //   36: invokevirtual e : ()V
    //   39: aload_0
    //   40: getfield s : Lcom/soft/blued/ui/user/presenter/UserInfoNewPresenter;
    //   43: invokevirtual g : ()Z
    //   46: ifne -> 65
    //   49: aload_0
    //   50: getfield v : Landroid/widget/ImageView;
    //   53: iconst_0
    //   54: invokevirtual setVisibility : (I)V
    //   57: aload_0
    //   58: getfield w : Landroid/widget/ImageView;
    //   61: iconst_0
    //   62: invokevirtual setVisibility : (I)V
    //   65: aload_0
    //   66: getfield ad : Z
    //   69: ifeq -> 466
    //   72: getstatic com/blued/das/profile/PersonalProfileProtos$TabType.UNKNOWN_TAB_TYPE : Lcom/blued/das/profile/PersonalProfileProtos$TabType;
    //   75: astore_2
    //   76: new com/soft/blued/log/model/LogData
    //   79: dup
    //   80: invokespecial <init> : ()V
    //   83: astore #4
    //   85: aload #4
    //   87: ldc_w 'userpage_default_tab'
    //   90: putfield J : Ljava/lang/String;
    //   93: aload #4
    //   95: aload_0
    //   96: getfield s : Lcom/soft/blued/ui/user/presenter/UserInfoNewPresenter;
    //   99: invokevirtual d : ()Lcom/soft/blued/ui/user/model/UserInfoEntity;
    //   102: getfield uid : Ljava/lang/String;
    //   105: putfield c : Ljava/lang/String;
    //   108: aload_0
    //   109: getfield P : I
    //   112: istore_1
    //   113: iload_1
    //   114: iconst_m1
    //   115: if_icmpeq -> 214
    //   118: iload_1
    //   119: ifeq -> 165
    //   122: iload_1
    //   123: iconst_1
    //   124: if_icmpeq -> 150
    //   127: iload_1
    //   128: iconst_2
    //   129: if_icmpeq -> 135
    //   132: goto -> 177
    //   135: aload #4
    //   137: ldc_w '2'
    //   140: putfield g : Ljava/lang/String;
    //   143: getstatic com/blued/das/profile/PersonalProfileProtos$TabType.PROFILE_LOAD : Lcom/blued/das/profile/PersonalProfileProtos$TabType;
    //   146: astore_2
    //   147: goto -> 177
    //   150: aload #4
    //   152: ldc_w '1'
    //   155: putfield g : Ljava/lang/String;
    //   158: getstatic com/blued/das/profile/PersonalProfileProtos$TabType.FEED_LOAD : Lcom/blued/das/profile/PersonalProfileProtos$TabType;
    //   161: astore_2
    //   162: goto -> 177
    //   165: aload #4
    //   167: ldc_w '0'
    //   170: putfield g : Ljava/lang/String;
    //   173: getstatic com/blued/das/profile/PersonalProfileProtos$TabType.PHOTO_LOAD : Lcom/blued/das/profile/PersonalProfileProtos$TabType;
    //   176: astore_2
    //   177: aload_0
    //   178: getfield P : I
    //   181: istore_1
    //   182: iload_1
    //   183: ifeq -> 198
    //   186: iload_1
    //   187: iconst_1
    //   188: if_icmpeq -> 198
    //   191: aload_2
    //   192: astore_3
    //   193: iload_1
    //   194: iconst_2
    //   195: if_icmpne -> 345
    //   198: aload_0
    //   199: getfield i : Lcom/soft/blued/customview/CustomViewPager;
    //   202: aload_0
    //   203: getfield P : I
    //   206: invokevirtual setCurrentItem : (I)V
    //   209: aload_2
    //   210: astore_3
    //   211: goto -> 345
    //   214: aload_2
    //   215: astore_3
    //   216: aload_0
    //   217: getfield am : Z
    //   220: ifeq -> 243
    //   223: aload #4
    //   225: ldc_w '0'
    //   228: putfield g : Ljava/lang/String;
    //   231: getstatic com/blued/das/profile/PersonalProfileProtos$TabType.PHOTO_LOAD : Lcom/blued/das/profile/PersonalProfileProtos$TabType;
    //   234: astore_3
    //   235: aload_0
    //   236: getfield i : Lcom/soft/blued/customview/CustomViewPager;
    //   239: iconst_0
    //   240: invokevirtual setCurrentItem : (I)V
    //   243: aload_3
    //   244: astore_2
    //   245: aload_0
    //   246: getfield am : Z
    //   249: ifne -> 281
    //   252: aload_3
    //   253: astore_2
    //   254: aload_0
    //   255: getfield al : Z
    //   258: ifeq -> 281
    //   261: aload #4
    //   263: ldc_w '1'
    //   266: putfield g : Ljava/lang/String;
    //   269: getstatic com/blued/das/profile/PersonalProfileProtos$TabType.FEED_LOAD : Lcom/blued/das/profile/PersonalProfileProtos$TabType;
    //   272: astore_2
    //   273: aload_0
    //   274: getfield i : Lcom/soft/blued/customview/CustomViewPager;
    //   277: iconst_1
    //   278: invokevirtual setCurrentItem : (I)V
    //   281: aload_2
    //   282: astore_3
    //   283: aload_0
    //   284: getfield am : Z
    //   287: ifne -> 345
    //   290: aload_2
    //   291: astore_3
    //   292: aload_0
    //   293: getfield al : Z
    //   296: ifne -> 345
    //   299: aload #4
    //   301: ldc_w '0'
    //   304: putfield g : Ljava/lang/String;
    //   307: getstatic com/blued/das/profile/PersonalProfileProtos$TabType.PHOTO_LOAD : Lcom/blued/das/profile/PersonalProfileProtos$TabType;
    //   310: astore_3
    //   311: aload_0
    //   312: getfield i : Lcom/soft/blued/customview/CustomViewPager;
    //   315: iconst_0
    //   316: invokevirtual setCurrentItem : (I)V
    //   319: aload_0
    //   320: getfield j : Lcom/soft/blued/ui/user/fragment/UserInfoFragmentNew$MyAdapter;
    //   323: getfield c : Lcom/soft/blued/ui/user/fragment/UserinfoFragmentAlbumTab;
    //   326: invokevirtual l : ()V
    //   329: getstatic com/blued/das/profile/PersonalProfileProtos$Event.PERSONAL_MORE_PROFILE_SHOW : Lcom/blued/das/profile/PersonalProfileProtos$Event;
    //   332: aload_0
    //   333: getfield s : Lcom/soft/blued/ui/user/presenter/UserInfoNewPresenter;
    //   336: invokevirtual d : ()Lcom/soft/blued/ui/user/model/UserInfoEntity;
    //   339: getfield uid : Ljava/lang/String;
    //   342: invokestatic b : (Lcom/blued/das/profile/PersonalProfileProtos$Event;Ljava/lang/String;)V
    //   345: aload_0
    //   346: getfield O : Lcom/soft/blued/log/model/LogData;
    //   349: aload_0
    //   350: getfield s : Lcom/soft/blued/ui/user/presenter/UserInfoNewPresenter;
    //   353: invokevirtual d : ()Lcom/soft/blued/ui/user/model/UserInfoEntity;
    //   356: getfield uid : Ljava/lang/String;
    //   359: putfield b : Ljava/lang/String;
    //   362: aload_0
    //   363: getfield O : Lcom/soft/blued/log/model/LogData;
    //   366: astore_2
    //   367: aload_2
    //   368: aload_0
    //   369: getfield an : Ljava/lang/String;
    //   372: putfield F : Ljava/lang/String;
    //   375: aload_2
    //   376: aload_0
    //   377: getfield M : Z
    //   380: putfield D : Z
    //   383: aload_0
    //   384: getfield s : Lcom/soft/blued/ui/user/presenter/UserInfoNewPresenter;
    //   387: invokevirtual d : ()Lcom/soft/blued/ui/user/model/UserInfoEntity;
    //   390: getfield liveshow : Lcom/soft/blued/ui/user/model/UserInfoEntity$_liveshow;
    //   393: ifnull -> 432
    //   396: aload_0
    //   397: getfield s : Lcom/soft/blued/ui/user/presenter/UserInfoNewPresenter;
    //   400: invokevirtual d : ()Lcom/soft/blued/ui/user/model/UserInfoEntity;
    //   403: getfield liveshow : Lcom/soft/blued/ui/user/model/UserInfoEntity$_liveshow;
    //   406: getfield session_id : Ljava/lang/Long;
    //   409: ifnull -> 432
    //   412: aload_0
    //   413: getfield O : Lcom/soft/blued/log/model/LogData;
    //   416: aload_0
    //   417: getfield s : Lcom/soft/blued/ui/user/presenter/UserInfoNewPresenter;
    //   420: invokevirtual d : ()Lcom/soft/blued/ui/user/model/UserInfoEntity;
    //   423: getfield liveshow : Lcom/soft/blued/ui/user/model/UserInfoEntity$_liveshow;
    //   426: getfield session_id : Ljava/lang/Long;
    //   429: putfield H : Ljava/lang/Long;
    //   432: getstatic com/blued/das/profile/PersonalProfileProtos$Event.PERSONAL_PROFILE_LOAD_DEFAULT_TAB : Lcom/blued/das/profile/PersonalProfileProtos$Event;
    //   435: aload_3
    //   436: aload_0
    //   437: getfield O : Lcom/soft/blued/log/model/LogData;
    //   440: getfield b : Ljava/lang/String;
    //   443: invokestatic a : (Lcom/blued/das/profile/PersonalProfileProtos$Event;Lcom/blued/das/profile/PersonalProfileProtos$TabType;Ljava/lang/String;)V
    //   446: getstatic com/blued/das/profile/PersonalProfileProtos$Event.PERSONAL_PROFILE_PAGE_SHOW : Lcom/blued/das/profile/PersonalProfileProtos$Event;
    //   449: aload_0
    //   450: getfield O : Lcom/soft/blued/log/model/LogData;
    //   453: invokestatic a : (Lcom/blued/das/profile/PersonalProfileProtos$Event;Lcom/soft/blued/log/model/LogData;)V
    //   456: aload #4
    //   458: invokestatic a : (Lcom/soft/blued/log/model/LogData;)V
    //   461: aload_0
    //   462: iconst_0
    //   463: putfield ad : Z
    //   466: return
  }
  
  public void w() {
    EventTrackFeed.a(FeedProtos.Event.FEED_PUBLISH_BTN_CLICK, FeedProtos.FeedFrom.PERSONAL);
    InstantLog.b("feed_post_btn_click", 2);
    FeedPostFragment.a(this.d);
  }
  
  public void x() {
    this.O.G = false;
    EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_PROFILE_CHAT_BTN_CLICK, this.O);
    LogData logData1 = new LogData("user_profile_chat_btn_click");
    logData1.g = this.an;
    logData1.b = (this.s.d()).uid;
    LogData logData2 = this.O;
    if (logData2 != null && ("0".equals(logData2.k) || "1".equals(this.O.k)))
      logData1.k = this.O.k; 
    InstantLog.a(logData1);
    if ("chat_setting".equalsIgnoreCase(this.an) || "private_chatting".equalsIgnoreCase(this.an)) {
      Intent intent = new Intent();
      Bundle bundle = new Bundle();
      bundle.putBoolean("chat_setting", true);
      intent.putExtras(bundle);
      if (getActivity() != null) {
        getActivity().setResult(-1, intent);
        getActivity().finish();
      } 
      return;
    } 
    y();
  }
  
  public void y() {
    if ((this.s.d()).uid != null && !this.s.f()) {
      LogData logData2 = new LogData();
      String str = this.an;
      logData2.g = str;
      logData2.F = str;
      logData2.b = (this.s.d()).uid;
      LogData logData1 = this.O;
      if (logData1 != null) {
        logData2.u = logData1.u;
        if ("0".equals(this.O.k) || "1".equals(this.O.k))
          logData2.k = this.O.k; 
        logData2.B = this.O.B;
        logData2.E = this.O.E;
        logData2.C = this.O.C;
        logData2.D = this.O.D;
      } 
      if (this.N == null)
        this.N = new MsgSourceEntity(MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, ""); 
      if (this.ap != null) {
        ChatBundleExtra chatBundleExtra = new ChatBundleExtra();
        chatBundleExtra.fuGiftListEvent = this.ap;
        this.ap = null;
      } else {
        logData1 = null;
      } 
      ChatHelperV4.a().a(this.d, Long.parseLong((this.s.d()).uid), (this.s.d()).name, (this.s.d()).avatar, (this.s.d()).vbadge, (this.s.d()).vip_grade, (this.s.d()).is_vip_annual, (this.s.d()).vip_exp_lvl, (this.s.d()).distance, false, 0, (this.s.d()).is_hide_vip_look, logData2, this.N, (ChatBundleExtra)logData1);
    } 
  }
  
  public class MyAdapter extends FragmentPagerAdapter {
    public UserinfoFragmentProfileTab a = new UserinfoFragmentProfileTab();
    
    public UserinfoFragmentFeedTab b = UserinfoFragmentFeedTab.a(this.d.H);
    
    public UserinfoFragmentAlbumTab c = UserinfoFragmentAlbumTab.a(this.d.H);
    
    public MyAdapter(UserInfoFragmentNew this$0, FragmentManager param1FragmentManager) {
      super(param1FragmentManager);
    }
    
    public void destroyItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      super.destroyItem(param1ViewGroup, param1Int, param1Object);
    }
    
    public int getCount() {
      return this.d.f.size();
    }
    
    public Fragment getItem(int param1Int) {
      if (param1Int == 0) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("userParse:");
        stringBuilder.append(this.d.H.photos_count);
        Log.v("drb", stringBuilder.toString());
        return (Fragment)this.c;
      } 
      return (Fragment)((param1Int == 1) ? this.b : this.a);
    }
    
    public CharSequence getPageTitle(int param1Int) {
      return this.d.f.get(param1Int);
    }
    
    public Object instantiateItem(ViewGroup param1ViewGroup, int param1Int) {
      return super.instantiateItem(param1ViewGroup, param1Int);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\fragment\UserInfoFragmentNew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */