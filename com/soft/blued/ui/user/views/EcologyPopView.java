package com.soft.blued.ui.user.views;

import android.app.Dialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.das.profile.PersonalProfileProtos;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackPersonalProfile;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.user.model.EcoVoteJsonParse;
import com.soft.blued.utils.StringUtils;

public class EcologyPopView extends LinearLayout {
  public Context a;
  
  private View b;
  
  private ImageView c;
  
  private LinearLayout d;
  
  private ShapeTextView e;
  
  private LinearLayout f;
  
  private ShapeTextView g;
  
  private ShapeTextView h;
  
  private ShapeTextView i;
  
  private String j;
  
  private String k;
  
  private IRequestHost l;
  
  private View.OnClickListener m;
  
  private Dialog n;
  
  public EcologyPopView(Context paramContext) {
    super(paramContext);
    a(paramContext);
  }
  
  public EcologyPopView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public EcologyPopView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a() {
    this.c = (ImageView)findViewById(2131297457);
    this.d = (LinearLayout)findViewById(2131299057);
    this.e = (ShapeTextView)findViewById(2131300547);
    this.f = (LinearLayout)findViewById(2131299028);
    this.g = (ShapeTextView)findViewById(2131300925);
    this.h = (ShapeTextView)findViewById(2131301115);
    this.i = (ShapeTextView)findViewById(2131301111);
    a(this.g, 2131100881);
    a(this.h, 2131100881);
    a(this.i, 2131100881);
    b(this.g, 2131100838);
    b(this.h, 2131100838);
    b(this.i, 2131100838);
  }
  
  private void a(ShapeTextView paramShapeTextView, int paramInt) {
    ShapeHelper.b((ShapeHelper.ShapeView)paramShapeTextView, paramInt);
  }
  
  private void b(ShapeTextView paramShapeTextView, int paramInt) {
    ShapeHelper.a((ShapeHelper.ShapeView)paramShapeTextView, paramInt);
  }
  
  public void a(int paramInt) {
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt == 2)
          EventTrackPersonalProfile.a(this.j, PersonalProfileProtos.VoteOption.NOT_JUNK); 
      } else {
        EventTrackPersonalProfile.a(this.j, PersonalProfileProtos.VoteOption.IS_JUNK);
      } 
    } else {
      EventTrackPersonalProfile.a(this.j, PersonalProfileProtos.VoteOption.UNCERTAIN);
    } 
    UserHttpUtils.a(this.j, paramInt, new BluedUIHttpResponse<BluedEntityA<EcoVoteJsonParse>>(this, this.l) {
          protected void a(BluedEntityA<EcoVoteJsonParse> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.hasData()) {
              EcoVoteJsonParse ecoVoteJsonParse = param1BluedEntityA.data.get(0);
              if (ecoVoteJsonParse != null && !StringUtils.e(ecoVoteJsonParse.next_uid) && !"0".equals(ecoVoteJsonParse.next_uid)) {
                EcologyPopView.a(this.a, ecoVoteJsonParse.next_uid);
                EventTrackPersonalProfile.a(PersonalProfileProtos.Event.BLUED_OFFICER_CONTINUE_BTN_CLICK);
                if (EcologyPopView.f(this.a) != null)
                  EcologyPopView.f(this.a).onClick((View)this.a); 
                UserInfoFragmentNew.a(this.a.a, EcologyPopView.g(this.a));
                return;
              } 
              EcologyPopView.h(this.a).setVisibility(8);
              EcologyPopView.i(this.a).setVisibility(0);
            } 
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(EcologyPopView.a(this.a));
          }
          
          public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(EcologyPopView.a(this.a));
          }
        }this.l);
  }
  
  public void a(Context paramContext) {
    this.a = paramContext;
    this.n = DialogUtils.a(this.a);
    this.b = LayoutInflater.from(this.a).inflate(2131494235, (ViewGroup)this);
    a();
    getConfig();
    this.g.setOnClickListener(new -$$Lambda$EcologyPopView$ofBMmRhjY0qX8yGo544fnXbnVF8(this));
    this.h.setOnClickListener(new -$$Lambda$EcologyPopView$UUsk60dI5tAdiPJNO4ZwcEzBs0U(this));
    this.i.setOnClickListener(new -$$Lambda$EcologyPopView$E_FS1E0uFBtIp2mlndfEPiQHoM4(this));
    this.e.setOnClickListener(new -$$Lambda$EcologyPopView$6E7ss3Uv4l2vaGqT11rOtnIRsCA(this));
    this.c.setOnClickListener(new -$$Lambda$EcologyPopView$gzClnMZrzXwxO7HdGnyFIGHFoaE(this));
  }
  
  public void a(String paramString, IRequestHost paramIRequestHost, View.OnClickListener paramOnClickListener) {
    this.j = paramString;
    this.l = paramIRequestHost;
    this.m = paramOnClickListener;
    setVisibility(0);
    this.f.setVisibility(0);
    this.d.setVisibility(8);
    this.c.setVisibility(8);
  }
  
  public void getConfig() {
    UserHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<EcoVoteJsonParse>>(this, this.l) {
          protected void a(BluedEntityA<EcoVoteJsonParse> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.hasData()) {
              EcoVoteJsonParse ecoVoteJsonParse = param1BluedEntityA.data.get(0);
              if (ecoVoteJsonParse != null) {
                EcologyPopView.b(this.a).setText(ecoVoteJsonParse.voted_button1);
                EcologyPopView.c(this.a).setText(ecoVoteJsonParse.vote_option1);
                EcologyPopView.d(this.a).setText(ecoVoteJsonParse.vote_option2);
                EcologyPopView.e(this.a).setText(ecoVoteJsonParse.vote_option3);
              } 
            } 
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(EcologyPopView.a(this.a));
          }
          
          public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(EcologyPopView.a(this.a));
          }
        }this.l);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\views\EcologyPopView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */