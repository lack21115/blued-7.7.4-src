package com.soft.blued.ui.live.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.upload.QiniuUploadTools;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.BluedLiveState;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.das.live.LiveProtos;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.http.H5Url;
import com.soft.blued.http.LiveHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.trackUtils.EventTrackLive;
import com.soft.blued.model.BluedAlbum;
import com.soft.blued.ui.feed.fragment.ClipPhotoFragment;
import com.soft.blued.ui.feed.fragment.PhotoSelectFragment;
import com.soft.blued.ui.live.manager.LiveApplyDelPhotoObserver;
import com.soft.blued.ui.live.model.BluedLiveListData;
import com.soft.blued.ui.live.model.LiveIDCardUploadResult;
import com.soft.blued.ui.login_register.LinkMobileFragment;
import com.soft.blued.ui.login_register.LoginRegisterTools;
import com.soft.blued.ui.photo.fragment.BasePhotoFragment;
import com.soft.blued.ui.setting.fragment.PersonalVerifyFragment;
import com.soft.blued.ui.setting.fragment.ShowVerifyFragment;
import com.soft.blued.ui.user.model.VerifyStatus;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.CameraUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.soft.blued.utils.third.QiniuUploadUtils;

public class LiveApplyFragment extends BaseFragment implements View.OnClickListener, LiveApplyDelPhotoObserver.IDelPhotoObserver {
  private ImageView A;
  
  private ImageView B;
  
  private ImageView C;
  
  private ImageView D;
  
  private String[] E = new String[2];
  
  private boolean F = true;
  
  private boolean G;
  
  private boolean H;
  
  private String I;
  
  private String J;
  
  private String K;
  
  private String L;
  
  private String M;
  
  private String N;
  
  private String O;
  
  private boolean P;
  
  private boolean Q;
  
  private boolean R;
  
  private boolean S;
  
  private boolean T;
  
  private boolean U;
  
  private boolean V = true;
  
  private boolean W = true;
  
  private boolean X = true;
  
  private boolean Y = true;
  
  private boolean Z;
  
  private TextView aA;
  
  private TextWatcher aB = new TextWatcher(this) {
      private int b;
      
      private int c;
      
      public void afterTextChanged(Editable param1Editable) {
        this.b = LiveApplyFragment.E(this.a).getSelectionStart();
        this.c = LiveApplyFragment.E(this.a).getSelectionEnd();
        LiveApplyFragment.E(this.a).removeTextChangedListener(LiveApplyFragment.N(this.a));
        if (param1Editable.length() > 0) {
          LiveApplyFragment.i(this.a, true);
          LiveApplyFragment.O(this.a).setVisibility(0);
          if (LiveApplyFragment.F(this.a).getText().length() > 0)
            LiveApplyFragment.j(this.a, true); 
        } else {
          LiveApplyFragment.i(this.a, false);
          LiveApplyFragment.O(this.a).setVisibility(8);
        } 
        while (param1Editable.length() > 10) {
          param1Editable.delete(this.b - 1, this.c);
          this.b--;
          this.c--;
        } 
        LiveApplyFragment.E(this.a).setSelection(this.b);
        LiveApplyFragment.z(this.a);
        LiveApplyFragment.E(this.a).addTextChangedListener(LiveApplyFragment.N(this.a));
      }
      
      public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
      
      public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
    };
  
  private TextWatcher aC = new TextWatcher(this) {
      private int b;
      
      private int c;
      
      public void afterTextChanged(Editable param1Editable) {
        this.b = LiveApplyFragment.F(this.a).getSelectionStart();
        this.c = LiveApplyFragment.F(this.a).getSelectionEnd();
        LiveApplyFragment.F(this.a).removeTextChangedListener(LiveApplyFragment.P(this.a));
        if (param1Editable.length() > 0) {
          LiveApplyFragment.j(this.a, true);
          LiveApplyFragment.Q(this.a).setVisibility(0);
          if (LiveApplyFragment.F(this.a).getText().length() > 0)
            LiveApplyFragment.i(this.a, true); 
        } else {
          LiveApplyFragment.j(this.a, false);
          LiveApplyFragment.Q(this.a).setVisibility(8);
        } 
        while (param1Editable.length() > 18) {
          param1Editable.delete(this.b - 1, this.c);
          this.b--;
          this.c--;
        } 
        LiveApplyFragment.F(this.a).setSelection(this.b);
        LiveApplyFragment.z(this.a);
        LiveApplyFragment.F(this.a).addTextChangedListener(LiveApplyFragment.P(this.a));
      }
      
      public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
      
      public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
    };
  
  private boolean aa;
  
  private Dialog ab;
  
  private ImageView ac;
  
  private ImageView ad;
  
  private Dialog ae;
  
  private ImageView af;
  
  private ImageView ag;
  
  private ImageView ah;
  
  private View ai;
  
  private View aj;
  
  private View ak;
  
  private View al;
  
  private View am;
  
  private LinearLayout an;
  
  private ImageView ao;
  
  private ImageView ap;
  
  private TextView aq;
  
  private EditText ar;
  
  private EditText as;
  
  private ImageView at;
  
  private final int au = 0;
  
  private final int av = 1;
  
  private final int aw = 2;
  
  private int ax;
  
  private View ay;
  
  private TextView az;
  
  boolean d = false;
  
  Dialog e;
  
  public BluedUIHttpResponse f = new BluedUIHttpResponse<BluedEntityA<BluedLiveListData>>(this, (IRequestHost)w_()) {
      protected void a(BluedEntityA<BluedLiveListData> param1BluedEntityA) {
        LiveApplyFragment.u(this.a).setBackgroundColor(-4144960);
        LiveApplyFragment.u(this.a).setOnClickListener(null);
        LiveApplyFragment.v(this.a).setText(2131755037);
        LiveApplyFragment.t(this.a).setVisibility(8);
        LiveApplyFragment.q(this.a).setVisibility(8);
        LiveApplyFragment.n(this.a).setVisibility(8);
        LiveApplyFragment.w(this.a).setText(this.a.getResources().getString(2131755040));
        LiveApplyFragment.x(this.a).setText(this.a.getResources().getString(2131755041));
        LiveApplyFragment.C(this.a).setVisibility(8);
        LiveApplyFragment.D(this.a).setVisibility(8);
        LiveApplyFragment.y(this.a).setVisibility(8);
        LiveApplyFragment.E(this.a).setEnabled(false);
        LiveApplyFragment.F(this.a).setEnabled(false);
      }
      
      public boolean onUIFailure(int param1Int, String param1String) {
        if (param1Int == 4036703) {
          LiveApplyFragment.G(this.a);
          LiveApplyFragment.C(this.a).setVisibility(0);
          return true;
        } 
        if (param1Int == 4036705) {
          LiveApplyFragment.H(this.a);
          LiveApplyFragment.A(this.a);
          LiveApplyFragment.t(this.a).setVisibility(8);
          LiveApplyFragment.q(this.a).setVisibility(8);
          LiveApplyFragment.n(this.a).setVisibility(8);
          return true;
        } 
        return false;
      }
      
      public void onUIFinish() {
        super.onUIFinish();
        DialogUtils.b(LiveApplyFragment.B(this.a));
      }
      
      public void onUIStart() {
        super.onUIStart();
        DialogUtils.a(LiveApplyFragment.B(this.a));
      }
    };
  
  private String g = LiveApplyFragment.class.getSimpleName();
  
  private View h;
  
  private Context i;
  
  private TextView j;
  
  private TextView k;
  
  private TextView l;
  
  private TextView m;
  
  private TextView n;
  
  private TextView o;
  
  private TextView p;
  
  private TextView q;
  
  private TextView r;
  
  private TextView s;
  
  private TextView t;
  
  private TextView u;
  
  private TextView v;
  
  private LinearLayout w;
  
  private TextView x;
  
  private ImageView y;
  
  private ImageView z;
  
  private void a(int paramInt) {
    View view = getActivity().getLayoutInflater().inflate(2131494017, null);
    ImageView imageView = (ImageView)view.findViewById(2131301696);
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt == 2)
          imageView.setImageResource(2131233096); 
      } else {
        imageView.setImageResource(2131233092);
      } 
    } else {
      imageView.setImageResource(2131233094);
    } 
    this.e = new Dialog((Context)getActivity(), 2131821496);
    this.e.requestWindowFeature(1);
    this.e.setContentView(view, new ViewGroup.LayoutParams(-1, -1));
    Window window = this.e.getWindow();
    window.setWindowAnimations(2131821418);
    WindowManager.LayoutParams layoutParams = window.getAttributes();
    layoutParams.x = 0;
    layoutParams.y = getActivity().getWindowManager().getDefaultDisplay().getHeight();
    layoutParams.width = -1;
    layoutParams.height = -1;
    this.e.onWindowAttributesChanged(layoutParams);
    String[] arrayOfString = getResources().getStringArray(2130903110);
    Button button = (Button)view.findViewById(2131299424);
    button.setText(arrayOfString[1]);
    button.setOnClickListener(this);
    button = (Button)view.findViewById(2131299421);
    button.setText(arrayOfString[0]);
    button.setOnClickListener(this);
    ((ImageView)view.findViewById(2131299422)).setOnClickListener(this);
    this.e.setCanceledOnTouchOutside(true);
    this.e.show();
  }
  
  private void a(int paramInt, String paramString) {
    LiveHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<LiveIDCardUploadResult>>(this, (IRequestHost)w_(), paramInt) {
          protected void a(BluedEntityA<LiveIDCardUploadResult> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
              String str = ((LiveIDCardUploadResult)param1BluedEntityA.data.get(0)).pic;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("上传图片成功：");
              stringBuilder.append(this.a);
              Log.v("pk", stringBuilder.toString());
              int i = this.a;
              if (i != 0) {
                if (i != 1) {
                  if (i == 2) {
                    LiveApplyFragment.f(this.b, true);
                    LiveApplyFragment.c(this.b, str);
                    LiveApplyFragment.s(this.b).setVisibility(0);
                    ImageLoader.d((IRequestHost)this.b.w_(), LiveApplyFragment.L(this.b)).a(2131233093).a(LiveApplyFragment.s(this.b));
                    LiveApplyFragment.t(this.b).setVisibility(0);
                  } 
                } else {
                  LiveApplyFragment.e(this.b, true);
                  LiveApplyFragment.b(this.b, str);
                  LiveApplyFragment.p(this.b).setVisibility(0);
                  ImageLoader.d((IRequestHost)this.b.w_(), LiveApplyFragment.K(this.b)).a(2131233093).a(LiveApplyFragment.p(this.b));
                  LiveApplyFragment.q(this.b).setVisibility(0);
                  InstantLog.b("verify_photo_uploaded", 1);
                } 
              } else {
                LiveApplyFragment.d(this.b, true);
                LiveApplyFragment.a(this.b, str);
                LiveApplyFragment.m(this.b).setVisibility(0);
                ImageLoader.d((IRequestHost)this.b.w_(), LiveApplyFragment.J(this.b)).a(2131233093).a(LiveApplyFragment.m(this.b));
                LiveApplyFragment.n(this.b).setVisibility(0);
                InstantLog.b("verify_photo_uploaded", 0);
              } 
              LiveApplyFragment.g(this.b, true);
              LiveApplyFragment.z(this.b);
            } 
          }
        }UserInfo.a().i().getUid(), paramInt, paramString, (IRequestHost)w_());
  }
  
  private void a(String paramString, int paramInt) {
    LiveHttpUtils.a(this.i, new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>(this, (IRequestHost)w_(), paramString, paramInt) {
          protected void a(BluedEntityA<BluedAlbum> param1BluedEntityA) {
            if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
              BluedAlbum bluedAlbum = param1BluedEntityA.data.get(0);
              LiveApplyFragment.a(this.c, this.a, bluedAlbum, this.b);
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("获取token成功：");
              stringBuilder.append(this.b);
              Log.v("pk", stringBuilder.toString());
            } 
          }
          
          public void onUIFinish() {
            LiveApplyFragment.h(this.c, false);
          }
          
          public void onUIStart() {
            LiveApplyFragment.h(this.c, true);
          }
        }(IRequestHost)w_());
  }
  
  private void a(String paramString, BluedAlbum paramBluedAlbum, int paramInt) {
    QiniuUploadUtils.a(paramString, paramBluedAlbum, new QiniuUploadTools.QiNiuListener(this, paramInt) {
          public void a(String param1String) {
            LiveApplyFragment.h(this.b, false);
          }
          
          public void a(String param1String, double param1Double) {}
          
          public void a(String param1String1, String param1String2) {
            int i = this.a;
            if (i != 0) {
              if (i != 1) {
                if (i == 2)
                  LiveApplyFragment.c(this.b, param1String1); 
              } else {
                LiveApplyFragment.b(this.b, param1String1);
              } 
            } else {
              LiveApplyFragment.a(this.b, param1String1);
            } 
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("七牛上传成功：");
            stringBuilder.append(this.a);
            Log.v("pk", stringBuilder.toString());
            LiveApplyFragment.a(this.b, this.a, param1String1);
          }
          
          public boolean a() {
            return LiveApplyFragment.I(this.b);
          }
        });
  }
  
  private void b(int paramInt, String paramString) {
    DialogUtils.a(this.ab);
    LiveHttpUtils.b(new BluedUIHttpResponse(this, (IRequestHost)w_(), paramInt) {
          public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(LiveApplyFragment.M(this.b));
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            try {
              int i = this.a;
              if (i != 0) {
                if (i != 1) {
                  if (i == 2) {
                    LiveApplyFragment.f(this.b, false);
                    LiveApplyFragment.s(this.b).setVisibility(8);
                    LiveApplyFragment.t(this.b).setVisibility(8);
                    LiveApplyFragment.c(this.b, "");
                  } 
                } else {
                  LiveApplyFragment.e(this.b, false);
                  LiveApplyFragment.p(this.b).setVisibility(8);
                  LiveApplyFragment.q(this.b).setVisibility(8);
                  LiveApplyFragment.b(this.b, "");
                } 
              } else {
                LiveApplyFragment.d(this.b, false);
                LiveApplyFragment.m(this.b).setVisibility(8);
                LiveApplyFragment.n(this.b).setVisibility(8);
                LiveApplyFragment.a(this.b, "");
              } 
              LiveApplyFragment.z(this.b);
              return;
            } catch (Exception exception) {
              exception.printStackTrace();
              return;
            } 
          }
        }UserInfo.a().i().getUid(), paramInt, paramString, (IRequestHost)w_());
  }
  
  private void c(int paramInt, String paramString) {
    this.ax = paramInt;
    LoadOptions loadOptions = new LoadOptions();
    BasePhotoFragment.a(this.i, new String[] { paramString }, 0, 8, loadOptions);
  }
  
  private void k() {
    this.ab = DialogUtils.a((Context)getActivity());
    this.ae = DialogUtils.a((Context)getActivity(), this.i.getResources().getString(2131757301), false);
    this.B = (ImageView)this.h.findViewById(2131298183);
    this.C = (ImageView)this.h.findViewById(2131298184);
    this.D = (ImageView)this.h.findViewById(2131298185);
    this.y = (ImageView)this.h.findViewById(2131296846);
    this.z = (ImageView)this.h.findViewById(2131296847);
    this.A = (ImageView)this.h.findViewById(2131296848);
    this.y.setVisibility(8);
    this.z.setVisibility(8);
    this.A.setVisibility(8);
    this.l = (TextView)this.h.findViewById(2131298159);
    this.m = (TextView)this.h.findViewById(2131298160);
    this.n = (TextView)this.h.findViewById(2131298161);
    this.o = (TextView)this.h.findViewById(2131298162);
    this.p = (TextView)this.h.findViewById(2131298163);
    TextView textView = this.m;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("1.");
    stringBuilder.append(getString(2131755108));
    textView.setText(stringBuilder.toString());
    textView = this.n;
    stringBuilder = new StringBuilder();
    stringBuilder.append("2.");
    stringBuilder.append(getString(2131755109));
    textView.setText(stringBuilder.toString());
    textView = this.o;
    stringBuilder = new StringBuilder();
    stringBuilder.append("3.");
    stringBuilder.append(getString(2131755110));
    textView.setText(stringBuilder.toString());
    textView = this.p;
    stringBuilder = new StringBuilder();
    stringBuilder.append("4.");
    stringBuilder.append(getString(2131755111));
    textView.setText(stringBuilder.toString());
    this.w = (LinearLayout)this.h.findViewById(2131298728);
    this.x = (TextView)this.h.findViewById(2131301354);
    this.u = (TextView)this.h.findViewById(2131300971);
    this.v = (TextView)this.h.findViewById(2131300972);
    this.r = (TextView)this.h.findViewById(2131300561);
    this.q = (TextView)this.h.findViewById(2131301483);
    this.r.setOnClickListener(this);
    this.q.setOnClickListener(this);
    this.k = (TextView)this.h.findViewById(2131300562);
    this.j = (TextView)this.h.findViewById(2131301487);
    this.s = (TextView)this.h.findViewById(2131300563);
    this.t = (TextView)this.h.findViewById(2131300564);
    this.af = (ImageView)this.h.findViewById(2131297956);
    this.ag = (ImageView)this.h.findViewById(2131297889);
    this.ah = (ImageView)this.h.findViewById(2131297717);
    this.ai = this.h.findViewById(2131298313);
    this.aj = this.h.findViewById(2131298156);
    this.ak = this.h.findViewById(2131298157);
    this.al = this.h.findViewById(2131298158);
    this.am = this.h.findViewById(2131298314);
    this.an = (LinearLayout)this.h.findViewById(2131298234);
    this.ao = (ImageView)this.h.findViewById(2131297810);
    this.aq = (TextView)this.h.findViewById(2131298472);
    this.ap = (ImageView)this.h.findViewById(2131297811);
    this.ar = (EditText)this.h.findViewById(2131298235);
    this.as = (EditText)this.h.findViewById(2131298236);
    this.ay = this.h.findViewById(2131298173);
    this.az = (TextView)this.ay.findViewById(2131300272);
    this.aA = (TextView)this.ay.findViewById(2131300269);
    this.at = (ImageView)this.h.findViewById(2131298220);
    this.aj.setOnClickListener(this);
    this.ak.setOnClickListener(this);
    this.al.setOnClickListener(this);
    this.at.setOnClickListener(this);
    this.B.setOnClickListener(this);
    this.C.setOnClickListener(this);
    this.D.setOnClickListener(this);
    this.ao.setOnClickListener(this);
    this.ap.setOnClickListener(this);
    this.t.setOnClickListener(this);
    this.s.setOnClickListener(this);
    this.y.setOnClickListener(this);
    this.z.setOnClickListener(this);
    this.A.setOnClickListener(this);
    this.ay.setOnClickListener(this);
    this.ac = (ImageView)this.h.findViewById(2131297362);
    ImageLoader.a((IRequestHost)w_(), UserInfo.a().i().getAvatar()).a(2131234356).c().a(this.ac);
    this.ad = (ImageView)this.h.findViewById(2131297575);
    UserRelationshipUtils.a(this.ad, UserInfo.a().i().getVBadge(), 3);
    if (this.ad.getVisibility() == 8 || this.ad.getVisibility() == 4) {
      this.ad.setImageResource(2131234373);
      this.ad.setVisibility(0);
    } 
    o();
    this.ar.setFilters(new InputFilter[] { StringUtils.a() });
    this.ar.addTextChangedListener(this.aB);
    this.as.addTextChangedListener(this.aC);
  }
  
  private void l() {
    this.an.setVisibility(0);
    this.aq.setVisibility(0);
    this.X = false;
    this.Y = false;
    r();
  }
  
  private void m() {
    this.ay.setVisibility(0);
    this.az.setText(this.i.getString(2131755062));
    this.aA.setText(this.i.getString(2131755106));
    this.aA.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            LiveApplyFragment.a(this.a).setVisibility(8);
            EventTrackLive.a(LiveProtos.Event.LIVE_APPLY_PAGE_REUPLOAD_BTN_CLICK);
          }
        });
  }
  
  private void n() {
    this.ay.setVisibility(0);
    this.az.setText(this.i.getString(2131755063));
    this.aA.setText(this.i.getString(2131755105));
    this.aA.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            LiveApplyFragment.a(this.a).setVisibility(8);
            EventTrackLive.a(LiveProtos.Event.LIVE_APPLY_PAGE_MANUALLY_MODIFY_BTN_CLICK);
          }
        });
  }
  
  private void o() {
    String str1 = this.i.getString(2131755035);
    String str2 = this.i.getString(2131755051);
    String str4 = this.i.getString(2131755036);
    String str3 = this.i.getString(2131757205);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(str1);
    stringBuilder1.append(" ");
    stringBuilder1.append(str2);
    stringBuilder1.append(" ");
    stringBuilder1.append(str4);
    stringBuilder1.append(" ");
    stringBuilder1.append(str3);
    str4 = stringBuilder1.toString();
    SpannableString spannableString = new SpannableString(str4);
    this.l.setMovementMethod(LinkMovementMethod.getInstance());
    ClickableSpan clickableSpan = new ClickableSpan(this) {
        public void onClick(View param1View) {
          WebViewShowInfoFragment.show((Context)this.a.getActivity(), "https://www.blued.cn/live/agreement", 7);
        }
        
        public void updateDrawState(TextPaint param1TextPaint) {
          param1TextPaint.setColor(LiveApplyFragment.b(this.a).getResources().getColor(2131100527));
          param1TextPaint.setUnderlineText(false);
        }
      };
    int i = str4.indexOf(str2);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str1);
    stringBuilder2.append(" ");
    stringBuilder2.append(str2);
    spannableString.setSpan(clickableSpan, i, stringBuilder2.toString().length(), 33);
    spannableString.setSpan(new ClickableSpan(this) {
          public void onClick(View param1View) {
            WebViewShowInfoFragment.show((Context)this.a.getActivity(), "https://app.blued.cn/livereports/agreement/1", 7);
          }
          
          public void updateDrawState(TextPaint param1TextPaint) {
            param1TextPaint.setColor(LiveApplyFragment.b(this.a).getResources().getColor(2131100527));
            param1TextPaint.setUnderlineText(false);
          }
        }str4.indexOf(str3), str4.length(), 33);
    this.l.setText((CharSequence)spannableString);
  }
  
  private void p() {
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)this.h.findViewById(2131300300);
    commonTopTitleNoTrans.a();
    commonTopTitleNoTrans.setCenterText(getString(2131755104));
    commonTopTitleNoTrans.setLeftClickListener(this);
    commonTopTitleNoTrans.setCenterTextColor(2131100838);
  }
  
  private void q() {
    LiveRoomHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<BluedLiveState>>(this, (IRequestHost)w_()) {
          protected void a(BluedEntityA<BluedLiveState> param1BluedEntityA) {
            BluedLiveState bluedLiveState = param1BluedEntityA.data.get(0);
            if (bluedLiveState.vbadge == 2 || bluedLiveState.vbadge == 4 || bluedLiveState.vbadge == 7 || bluedLiveState.vbadge == 5 || (bluedLiveState.vbadge == 0 && (bluedLiveState.verify == 0 || bluedLiveState.verify == 1 || bluedLiveState.verify == 2 || bluedLiveState.verify == -1))) {
              if (bluedLiveState.verify == 0) {
                LiveApplyFragment.a(this.a, false);
                LiveApplyFragment.c(this.a).setText(this.a.getResources().getString(2131759209));
                LiveApplyFragment.c(this.a).setVisibility(0);
                LiveApplyFragment.c(this.a).setTextColor(LiveApplyFragment.b(this.a).getResources().getColor(2131100535));
                LiveApplyFragment.d(this.a).setVisibility(8);
                LiveApplyFragment.e(this.a).setVisibility(8);
              } else if (bluedLiveState.verify == 1) {
                LiveApplyFragment.a(this.a, true);
                LiveApplyFragment.c(this.a).setText(this.a.getResources().getString(2131759196));
                LiveApplyFragment.c(this.a).setVisibility(0);
                LiveApplyFragment.c(this.a).setTextColor(LiveApplyFragment.b(this.a).getResources().getColor(2131100543));
                LiveApplyFragment.d(this.a).setVisibility(8);
                LiveApplyFragment.e(this.a).setVisibility(0);
              } else if (bluedLiveState.verify == 2) {
                LiveApplyFragment.a(this.a, false);
                LiveApplyFragment.c(this.a).setText(this.a.getResources().getString(2131759105));
                LiveApplyFragment.c(this.a).setTextColor(LiveApplyFragment.b(this.a).getResources().getColor(2131100538));
                LiveApplyFragment.c(this.a).setVisibility(0);
                LiveApplyFragment.c(this.a).setOnClickListener(new View.OnClickListener(this) {
                      public void onClick(View param2View) {
                        PersonalVerifyFragment.a(LiveApplyFragment.b(this.a.a), 0);
                      }
                    });
                LiveApplyFragment.d(this.a).setVisibility(8);
                LiveApplyFragment.e(this.a).setVisibility(8);
              } else if (bluedLiveState.verify == -1) {
                LiveApplyFragment.a(this.a, false);
                LiveApplyFragment.c(this.a).setVisibility(8);
                LiveApplyFragment.d(this.a).setVisibility(0);
              } 
            } else {
              LiveApplyFragment.a(this.a, false);
              LiveApplyFragment.c(this.a).setVisibility(8);
              LiveApplyFragment.d(this.a).setVisibility(0);
              LiveApplyFragment.e(this.a).setVisibility(8);
            } 
            if (bluedLiveState.mobile == 1) {
              LiveApplyFragment.b(this.a, true);
              LiveApplyFragment.f(this.a).setVisibility(0);
              LiveApplyFragment.f(this.a).setText(this.a.getResources().getString(2131755049));
              LiveApplyFragment.g(this.a).setVisibility(8);
              LiveApplyFragment.h(this.a).setVisibility(0);
            } else {
              LiveApplyFragment.b(this.a, false);
              LiveApplyFragment.f(this.a).setVisibility(8);
              LiveApplyFragment.g(this.a).setVisibility(0);
              LiveApplyFragment.h(this.a).setVisibility(8);
            } 
            if (bluedLiveState.has_bankcard == 1) {
              LiveApplyFragment.c(this.a, true);
              LiveApplyFragment.i(this.a).setVisibility(0);
              LiveApplyFragment.j(this.a).setVisibility(8);
              LiveApplyFragment.k(this.a).setVisibility(0);
            } else {
              LiveApplyFragment.c(this.a, false);
              LiveApplyFragment.i(this.a).setVisibility(8);
              LiveApplyFragment.j(this.a).setVisibility(0);
              LiveApplyFragment.k(this.a).setVisibility(8);
            } 
            LiveApplyFragment.a(this.a, bluedLiveState.idcard_front);
            LiveApplyFragment.b(this.a, bluedLiveState.idcard_after);
            LiveApplyFragment.c(this.a, bluedLiveState.idcard_hands);
            if (!TextUtils.isEmpty(LiveApplyFragment.l(this.a))) {
              LiveApplyFragment.m(this.a).setVisibility(0);
              ImageLoader.a((IRequestHost)this.a.w_(), LiveApplyFragment.l(this.a)).a(2131233093).a(LiveApplyFragment.m(this.a));
              LiveApplyFragment.d(this.a, true);
              LiveApplyFragment.n(this.a).setVisibility(0);
            } else {
              LiveApplyFragment.n(this.a).setVisibility(8);
            } 
            if (!TextUtils.isEmpty(LiveApplyFragment.o(this.a))) {
              LiveApplyFragment.p(this.a).setVisibility(0);
              ImageLoader.a((IRequestHost)this.a.w_(), LiveApplyFragment.o(this.a)).a(2131233093).a(LiveApplyFragment.p(this.a));
              LiveApplyFragment.e(this.a, true);
              LiveApplyFragment.q(this.a).setVisibility(0);
            } else {
              LiveApplyFragment.q(this.a).setVisibility(8);
            } 
            if (!TextUtils.isEmpty(LiveApplyFragment.r(this.a))) {
              LiveApplyFragment.s(this.a).setVisibility(0);
              ImageLoader.a((IRequestHost)this.a.w_(), LiveApplyFragment.r(this.a)).a(2131233093).a(LiveApplyFragment.s(this.a));
              LiveApplyFragment.f(this.a, true);
              LiveApplyFragment.t(this.a).setVisibility(0);
            } else {
              LiveApplyFragment.t(this.a).setVisibility(8);
            } 
            if (bluedLiveState.has_audited == 0) {
              LiveApplyFragment.u(this.a).setBackgroundColor(-4144960);
              LiveApplyFragment.u(this.a).setOnClickListener(null);
              LiveApplyFragment.v(this.a).setText(2131755037);
              LiveApplyFragment.w(this.a).setText(this.a.getResources().getString(2131755040));
              LiveApplyFragment.x(this.a).setText(this.a.getResources().getString(2131755041));
              LiveApplyFragment.t(this.a).setVisibility(8);
              LiveApplyFragment.q(this.a).setVisibility(8);
              LiveApplyFragment.n(this.a).setVisibility(8);
            } else if (bluedLiveState.has_audited == 1) {
              LiveApplyFragment.u(this.a).setBackgroundColor(-4144960);
              LiveApplyFragment.u(this.a).setOnClickListener(null);
              LiveApplyFragment.v(this.a).setText(2131755039);
              LiveApplyFragment.t(this.a).setVisibility(8);
              LiveApplyFragment.q(this.a).setVisibility(8);
              LiveApplyFragment.n(this.a).setVisibility(8);
            } else if (bluedLiveState.has_audited == 2) {
              LiveApplyFragment.u(this.a).setBackgroundColor(-4144960);
              LiveApplyFragment.u(this.a).setOnClickListener(null);
              LiveApplyFragment.v(this.a).setText(2131755038);
              LiveApplyFragment.w(this.a).setText(2131755073);
              LiveApplyFragment.x(this.a).setText(2131755074);
              if (!TextUtils.isEmpty(LiveApplyFragment.l(this.a))) {
                LiveApplyFragment.d(this.a, true);
                LiveApplyFragment.n(this.a).setVisibility(0);
              } else {
                LiveApplyFragment.n(this.a).setVisibility(8);
              } 
              if (!TextUtils.isEmpty(LiveApplyFragment.o(this.a))) {
                LiveApplyFragment.e(this.a, true);
                LiveApplyFragment.q(this.a).setVisibility(0);
              } else {
                LiveApplyFragment.q(this.a).setVisibility(8);
              } 
              if (!TextUtils.isEmpty(LiveApplyFragment.r(this.a))) {
                LiveApplyFragment.f(this.a, true);
                LiveApplyFragment.t(this.a).setVisibility(0);
              } else {
                LiveApplyFragment.t(this.a).setVisibility(8);
              } 
              if (bluedLiveState.idcard_front_status == 1) {
                LiveApplyFragment.y(this.a).setVisibility(0);
                LiveApplyFragment.g(this.a, false);
                LiveApplyFragment.z(this.a);
              } 
            } else {
              if (!TextUtils.isEmpty(LiveApplyFragment.l(this.a))) {
                LiveApplyFragment.d(this.a, true);
                LiveApplyFragment.n(this.a).setVisibility(0);
              } else {
                LiveApplyFragment.n(this.a).setVisibility(8);
              } 
              if (!TextUtils.isEmpty(LiveApplyFragment.o(this.a))) {
                LiveApplyFragment.e(this.a, true);
                LiveApplyFragment.q(this.a).setVisibility(0);
              } else {
                LiveApplyFragment.q(this.a).setVisibility(8);
              } 
              if (!TextUtils.isEmpty(LiveApplyFragment.r(this.a))) {
                LiveApplyFragment.f(this.a, true);
                LiveApplyFragment.t(this.a).setVisibility(0);
              } else {
                LiveApplyFragment.t(this.a).setVisibility(8);
              } 
              LiveApplyFragment.z(this.a);
            } 
            if (bluedLiveState.idcard_front_status == 0) {
              LiveApplyFragment.g(this.a, true);
              return;
            } 
            if (bluedLiveState.idcard_front_status == 2) {
              LiveApplyFragment.t(this.a).setVisibility(8);
              LiveApplyFragment.q(this.a).setVisibility(8);
              LiveApplyFragment.n(this.a).setVisibility(8);
              LiveApplyFragment.A(this.a);
            } 
          }
        }UserInfo.a().i().getUid(), (IRequestHost)w_());
  }
  
  private void r() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("isVertyfied = ");
    stringBuilder.append(this.P);
    Log.v("pk", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("isBided = ");
    stringBuilder.append(this.Q);
    Log.v("pk", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("isCardFrontOk = ");
    stringBuilder.append(this.R);
    Log.v("pk", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("isCardBackOk = ");
    stringBuilder.append(this.S);
    Log.v("pk", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("hasBindedBankCard = ");
    stringBuilder.append(this.U);
    Log.v("pk", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("isCardHandOk = ");
    stringBuilder.append(this.T);
    Log.v("pk", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("isAgreeClause = ");
    stringBuilder.append(this.V);
    Log.v("pk", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("isNameOk = ");
    stringBuilder.append(this.X);
    Log.v("pk", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("isNumberOk = ");
    stringBuilder.append(this.Y);
    Log.v("pk", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("isCardVerifyOk = ");
    stringBuilder.append(this.W);
    Log.v("pk", stringBuilder.toString());
    if (this.P && this.Q && this.R && this.S && this.U && this.T && this.V && this.X && this.Y && this.W) {
      this.w.setBackgroundColor(-16738064);
      this.x.setText(getResources().getString(2131755054));
      this.w.setOnClickListener(this);
      return;
    } 
    this.w.setBackgroundColor(-4144960);
    this.x.setText(getResources().getString(2131755054));
    this.w.setOnClickListener(null);
  }
  
  private void s() {
    this.I = CameraUtils.a((Fragment)this);
  }
  
  public void a() {
    String str;
    int i = this.ax;
    if (i != 0) {
      if (i != 1) {
        if (i != 2) {
          str = "";
        } else {
          str = this.O;
        } 
      } else {
        str = this.N;
      } 
    } else {
      str = this.M;
    } 
    b(this.ax, str);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramInt2 == -1)
      if (paramInt1 != 0) {
        if (paramInt1 == 22 && paramIntent != null) {
          this.I = paramIntent.getStringExtra("photo_path");
          int i = this.ax;
          if (i != 0) {
            if (i != 1) {
              if (i == 2) {
                String str = this.I;
                this.L = str;
                a(str, 2);
              } 
            } else {
              String str = this.I;
              this.K = str;
              a(str, 1);
            } 
          } else {
            String str = this.I;
            this.J = str;
            a(str, 0);
          } 
        } 
      } else {
        ClipPhotoFragment.a(this, 9, this.I, 22);
      }  
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView) {
    String str1;
    BluedUIHttpResponse bluedUIHttpResponse;
    ActivityFragmentActive activityFragmentActive;
    int i = paramView.getId();
    String str2 = "";
    switch (i) {
      default:
        return;
      case 2131301483:
        this.aa = true;
        this.Z = true;
        if (4 == UserInfo.a().i().getVBadge() || 7 == UserInfo.a().i().getVBadge()) {
          VerifyStatus[] arrayOfVerifyStatus = UserInfo.a().i().getVerify();
          String str = str2;
          if (arrayOfVerifyStatus != null) {
            str = str2;
            if (arrayOfVerifyStatus.length > 0)
              str = (arrayOfVerifyStatus[0]).verified_time; 
          } 
          ShowVerifyFragment.a((Context)getActivity(), UserInfo.a().i().getName(), UserInfo.a().i().getAvatar(), str, UserInfo.a().i().getUid(), false);
          return;
        } 
        PersonalVerifyFragment.a((Context)getActivity(), 0);
        return;
      case 2131300563:
      case 2131300564:
        this.aa = true;
        this.Z = true;
        WebViewShowInfoFragment.show((Context)getActivity(), H5Url.a(6), 0);
        return;
      case 2131300561:
        this.aa = true;
        this.Z = true;
        str1 = LoginRegisterTools.b();
        if (!TextUtils.isEmpty(str1)) {
          String[] arrayOfString = LoginRegisterTools.h(str1);
          LoginRegisterTools.a((Context)getActivity(), arrayOfString[0], arrayOfString[1]);
          return;
        } 
        TerminalActivity.d((Context)getActivity(), LinkMobileFragment.class, null);
        return;
      case 2131299424:
        this.Z = false;
        this.e.cancel();
        PhotoSelectFragment.a(this, 9, 22);
        return;
      case 2131299422:
        this.e.cancel();
        return;
      case 2131299421:
        this.Z = false;
        this.e.cancel();
        s();
        return;
      case 2131298728:
        EventTrackLive.a(LiveProtos.Event.LIVE_APPLY_PAGE_CONFIRM_BTN_CLICK);
        bluedUIHttpResponse = this.f;
        str2 = UserInfo.a().i().getUid();
        activityFragmentActive = w_();
        if (this.an.getVisibility() == 0) {
          i = 1;
        } else {
          i = 0;
        } 
        LiveRoomHttpUtils.a(bluedUIHttpResponse, str2, (IRequestHost)activityFragmentActive, i, this.ar.getText().toString(), this.as.getText().toString(), 0);
        return;
      case 2131298220:
        if (this.V) {
          this.V = false;
          this.at.setImageResource(2131233001);
        } else {
          this.V = true;
          this.at.setImageResource(2131233002);
        } 
        r();
        return;
      case 2131298185:
        c(2, this.O);
        return;
      case 2131298184:
        c(1, this.N);
        return;
      case 2131298183:
        c(0, this.M);
        return;
      case 2131298158:
        this.ax = 2;
        a(2);
        return;
      case 2131298157:
        this.ax = 1;
        a(1);
        return;
      case 2131298156:
        this.ax = 0;
        a(0);
        return;
      case 2131297811:
        this.as.setText("");
        return;
      case 2131297810:
        this.ar.setText("");
        return;
      case 2131296863:
        getActivity().finish();
        return;
      case 2131296848:
        AppMethods.a("删除第三张照片");
        b(2, this.O);
        return;
      case 2131296847:
        b(1, this.N);
        return;
      case 2131296846:
        break;
    } 
    b(0, this.M);
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.i = (Context)getActivity();
    View view = this.h;
    if (view == null) {
      this.h = paramLayoutInflater.inflate(2131493168, paramViewGroup, false);
      k();
      p();
      this.Z = true;
      if (LiveRoomManager.a().h() != null)
        EventTrackLive.a(LiveProtos.Event.LIVE_APPLY_PREPARE, LiveRoomManager.a().e()); 
      InstantLog.a("live_apply_prepare");
      LiveApplyDelPhotoObserver.a().a(this);
    } else if (view.getParent() != null) {
      ((ViewGroup)this.h.getParent()).removeView(this.h);
    } 
    return this.h;
  }
  
  public void onDestroy() {
    super.onDestroy();
    LiveApplyDelPhotoObserver.a().b(this);
  }
  
  public void onPause() {
    super.onPause();
    this.Z = false;
  }
  
  public void onResume() {
    super.onResume();
    if (this.Z || this.aa)
      q(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\fragment\LiveApplyFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */