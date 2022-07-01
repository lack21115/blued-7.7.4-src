package com.soft.blued.ui.circle.pop;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.ui.xpop.core.BottomPopupView;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.das.client.feed.FeedProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.http.CircleHttpUtils;
import com.soft.blued.http.FeedHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.circle.presenter.CirclePostDetailsPresenter;
import com.soft.blued.ui.user.fragment.ReportFragmentNew;
import com.soft.blued.view.tip.CommonAlertDialog;

public class CircleMainMenuPop extends BottomPopupView implements View.OnClickListener {
  public static final String b = CircleMainMenuPop.class.getSimpleName();
  
  private CirclePostDetailsPresenter c;
  
  private TextView d;
  
  private TextView e;
  
  private TextView f;
  
  private TextView g;
  
  private ShapeTextView h;
  
  private ShapeFrameLayout i;
  
  private TextView j;
  
  private TextView k;
  
  public CircleMainMenuPop(Context paramContext, CirclePostDetailsPresenter paramCirclePostDetailsPresenter) {
    super(paramContext);
    this.c = paramCirclePostDetailsPresenter;
  }
  
  private void A() {
    boolean bool;
    FeedProtos.Event event = FeedProtos.Event.CIRCLE_NOTE_MANAGE_BTN_CLICK;
    String str1 = (this.c.n()).circle_id;
    String str2 = (this.c.n()).feed_id;
    String str3 = (this.c.n()).feed_uid;
    FeedProtos.OptType optType = FeedProtos.OptType.OPT_DELETE;
    FeedProtos.NoteType noteType = EventTrackFeed.b(this.c.n());
    if ((this.c.n()).is_anonym == 1) {
      bool = true;
    } else {
      bool = false;
    } 
    EventTrackFeed.a(event, str1, str2, str3, optType, noteType, bool);
    CommonAlertDialog.a(getContext(), "", getResources().getString(2131755922), getResources().getString(2131756176), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            param1DialogInterface.dismiss();
            FeedHttpUtils.a(this.a.getContext(), new BluedUIHttpResponse(this, CircleMainMenuPop.a(this.a).g()) {
                  public void onUIUpdate(BluedEntity param2BluedEntity) {
                    this.a.a.p();
                    LiveEventBus.get("circle_delete_feed").post((CircleMainMenuPop.a(this.a.a).n()).feed_id);
                    ToastUtils.a(this.a.a.getResources().getString(2131755923));
                  }
                }(CircleMainMenuPop.a(this.a).n()).feed_id, CircleMainMenuPop.a(this.a).g(), false);
          }
        }null, null, null);
  }
  
  private boolean c() {
    return ((this.c.n()).posting_allow_delete == 1);
  }
  
  private void d() {
    if ((this.c.n()).is_essence == 0) {
      CircleHttpUtils.c(new BluedUIHttpResponse(this, this.c.g()) {
            public void onUIUpdate(BluedEntity param1BluedEntity) {
              AppMethods.a(this.a.getResources().getText(2131755925));
              (CircleMainMenuPop.a(this.a).n()).is_essence = 1;
              CircleMainMenuPop.a(this.a).e();
            }
          }this.c.q(), this.c.g());
      return;
    } 
    CircleHttpUtils.d(new BluedUIHttpResponse(this, this.c.g()) {
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            AppMethods.a(this.a.getResources().getText(2131755931));
            (CircleMainMenuPop.a(this.a).n()).is_essence = 0;
            CircleMainMenuPop.a(this.a).e();
          }
        }this.c.q(), this.c.g());
  }
  
  private void e() {
    if ((this.c.n()).is_muted == 1) {
      CircleHttpUtils.a((this.c.n()).circle_id, new BluedUIHttpResponse(this, this.c.g()) {
            public void onUIUpdate(BluedEntity param1BluedEntity) {
              (CircleMainMenuPop.a(this.a).n()).is_muted = 0;
            }
          }(this.c.n()).feed_uid, (this.c.n()).is_anonym, this.c.g());
      return;
    } 
    CircleHttpUtils.a((this.c.n()).circle_id, new BluedUIHttpResponse(this, this.c.g()) {
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            boolean bool;
            (CircleMainMenuPop.a(this.a).n()).is_muted = 1;
            ToastUtils.a(this.a.getResources().getString(2131755929));
            FeedProtos.Event event = FeedProtos.Event.CIRCLE_NOTE_MANAGE_BTN_CLICK;
            String str1 = (CircleMainMenuPop.a(this.a).n()).circle_id;
            String str2 = (CircleMainMenuPop.a(this.a).n()).feed_id;
            String str3 = (CircleMainMenuPop.a(this.a).n()).feed_uid;
            FeedProtos.OptType optType = FeedProtos.OptType.OPT_FORB;
            FeedProtos.NoteType noteType = EventTrackFeed.b(CircleMainMenuPop.a(this.a).n());
            if ((CircleMainMenuPop.a(this.a).n()).is_anonym == 1) {
              bool = true;
            } else {
              bool = false;
            } 
            EventTrackFeed.a(event, str1, str2, str3, optType, noteType, bool);
          }
        }(this.c.n()).feed_uid, (this.c.n()).is_anonym, (this.c.n()).user_name, (this.c.n()).user_avatar, this.c.g());
  }
  
  private void y() {
    if ((this.c.n()).is_top == 0) {
      CircleHttpUtils.a(new BluedUIHttpResponse(this, this.c.g()) {
            public void onUIUpdate(BluedEntity param1BluedEntity) {
              boolean bool;
              (CircleMainMenuPop.a(this.a).n()).is_top = 1;
              ToastUtils.a(this.a.getResources().getString(2131755934));
              FeedProtos.Event event = FeedProtos.Event.CIRCLE_NOTE_MANAGE_BTN_CLICK;
              String str1 = (CircleMainMenuPop.a(this.a).n()).circle_id;
              String str2 = (CircleMainMenuPop.a(this.a).n()).feed_id;
              String str3 = (CircleMainMenuPop.a(this.a).n()).feed_uid;
              FeedProtos.OptType optType = FeedProtos.OptType.OPT_TOP;
              FeedProtos.NoteType noteType = EventTrackFeed.b(CircleMainMenuPop.a(this.a).n());
              if ((CircleMainMenuPop.a(this.a).n()).is_anonym == 1) {
                bool = true;
              } else {
                bool = false;
              } 
              EventTrackFeed.a(event, str1, str2, str3, optType, noteType, bool);
            }
          }(this.c.n()).feed_id, this.c.g());
      return;
    } 
    CircleHttpUtils.b(new BluedUIHttpResponse(this, this.c.g()) {
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            (CircleMainMenuPop.a(this.a).n()).is_top = 0;
          }
        }(this.c.n()).feed_id, this.c.g());
  }
  
  private void z() {
    boolean bool;
    p();
    Context context = getContext();
    String str1 = (this.c.n()).feed_id;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append((this.c.n()).user_name);
    stringBuilder.append("");
    ReportFragmentNew.a(context, 9, str1, stringBuilder.toString());
    FeedProtos.Event event = FeedProtos.Event.CIRCLE_NOTE_MANAGE_BTN_CLICK;
    str1 = (this.c.n()).circle_id;
    String str2 = (this.c.n()).feed_id;
    String str3 = (this.c.n()).feed_uid;
    FeedProtos.OptType optType = FeedProtos.OptType.OPT_REPORT;
    FeedProtos.NoteType noteType = EventTrackFeed.b(this.c.n());
    if ((this.c.n()).is_anonym == 1) {
      bool = true;
    } else {
      bool = false;
    } 
    EventTrackFeed.a(event, str1, str2, str3, optType, noteType, bool);
  }
  
  public void b() {
    super.b();
    if (this.c.n() == null) {
      p();
      return;
    } 
    this.d = (TextView)findViewById(2131301433);
    this.e = (TextView)findViewById(2131301072);
    this.f = (TextView)findViewById(2131300702);
    this.g = (TextView)findViewById(2131301263);
    this.h = (ShapeTextView)findViewById(2131301264);
    this.i = (ShapeFrameLayout)findViewById(2131297195);
    this.j = (TextView)findViewById(2131300611);
    this.k = (TextView)findViewById(2131300734);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.k.setOnClickListener(this);
    if ((this.c.n()).is_top == 1) {
      Drawable drawable = getResources().getDrawable(2131232433);
      this.d.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null);
      this.d.setCompoundDrawablePadding(DensityUtils.a(getContext(), 11.5F));
      this.d.setText(getResources().getString(2131755933));
    } 
    if ((this.c.n()).is_muted == 1) {
      Drawable drawable = getResources().getDrawable(2131232430);
      this.e.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null);
      this.e.setCompoundDrawablePadding(DensityUtils.a(getContext(), 11.5F));
      this.e.setText(getResources().getString(2131755928));
    } 
    if ((this.c.n()).is_essence == 1) {
      Drawable drawable = getResources().getDrawable(2131232428);
      this.k.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null);
      this.k.setCompoundDrawablePadding(DensityUtils.a(getContext(), 11.5F));
      this.k.setText(getResources().getString(2131755931));
    } 
    if (this.c.n().isOwner() || this.c.n().isManager()) {
      this.h.setVisibility(8);
      this.i.setVisibility(0);
      if (this.c.n().isManager() && !c())
        this.f.setVisibility(8); 
      return;
    } 
    this.h.setVisibility(0);
    this.i.setVisibility(8);
    if (c()) {
      this.h.setText(getResources().getString(2131756176));
      return;
    } 
    this.h.setText(getResources().getString(2131758584));
  }
  
  public int getImplLayoutId() {
    return 2131494034;
  }
  
  public void onClick(View paramView) {
    switch (paramView.getId()) {
      default:
        return;
      case 2131301433:
        p();
        y();
        return;
      case 2131301263:
      case 2131301264:
        if (!this.c.n().isOwner() && !this.c.n().isManager() && c()) {
          A();
          return;
        } 
        z();
        return;
      case 2131301072:
        p();
        e();
        return;
      case 2131300734:
        d();
        p();
        return;
      case 2131300702:
        A();
        return;
      case 2131300611:
        break;
    } 
    p();
    FeedProtos.Event event = FeedProtos.Event.CIRCLE_NOTE_MANAGE_BTN_CLICK;
    String str1 = (this.c.n()).circle_id;
    String str2 = (this.c.n()).feed_id;
    String str3 = (this.c.n()).feed_uid;
    FeedProtos.OptType optType = FeedProtos.OptType.OPT_CANCEL;
    FeedProtos.NoteType noteType = EventTrackFeed.b(this.c.n());
    int i = (this.c.n()).is_anonym;
    boolean bool = true;
    if (i != 1)
      bool = false; 
    EventTrackFeed.a(event, str1, str2, str3, optType, noteType, bool);
  }
  
  public void v() {
    super.v();
    EventTrackFeed.i(FeedProtos.Event.CIRCLE_NOTE_MANAGE_SHOW, (this.c.n()).circle_id, (this.c.n()).feed_id);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\pop\CircleMainMenuPop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */