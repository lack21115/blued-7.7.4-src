package com.soft.blued.ui.user.fragment;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.das.vip.VipProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.PhotoGridView;
import com.soft.blued.http.ProfileHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackVIP;
import com.soft.blued.ui.find.manager.FilterHelper;
import com.soft.blued.ui.find.view.TwoWaysBar;
import com.soft.blued.ui.user.adapter.UserTagAdapter;
import com.soft.blued.ui.user.model.UserTag;
import com.soft.blued.ui.user.model.VipInvisibleSettingModel;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VipInvisibleFragment extends BaseFragment implements View.OnClickListener {
  private boolean A;
  
  private Dialog B;
  
  private CommonTopTitleNoTrans C;
  
  private VipInvisibleSettingModel D;
  
  private Map<String, String> E;
  
  private boolean F;
  
  private Context G;
  
  private String H = "";
  
  private String I = "";
  
  public VipInvisibleDialogFragment d;
  
  private View e;
  
  private ImageView f;
  
  private TextView g;
  
  private TwoWaysBar h;
  
  private ImageView i;
  
  private ImageView j;
  
  private PhotoGridView k;
  
  private ImageView l;
  
  private TwoWaysBar m;
  
  private TextView n;
  
  private TextView o;
  
  private TextView p;
  
  private TextView q;
  
  private String[] r;
  
  private UserTagAdapter s;
  
  private List<UserTag> t = new ArrayList<UserTag>();
  
  private boolean u;
  
  private String v;
  
  private boolean w;
  
  private String x;
  
  private boolean y;
  
  private String z;
  
  private void a() {
    if (getArguments() != null) {
      this.H = getArguments().getString("title");
      this.I = getArguments().getString("KEY_VIP_DETAIL");
    } 
    this.E = BluedHttpTools.a();
    this.r = FilterHelper.d().a();
    String[] arrayOfString = this.r;
    if (arrayOfString.length > 0) {
      arrayOfString = new String[arrayOfString.length - 1];
      int i = 0;
      while (true) {
        String[] arrayOfString1 = this.r;
        if (i < arrayOfString1.length - 1) {
          arrayOfString[i] = arrayOfString1[i];
          i++;
          continue;
        } 
        this.r = arrayOfString;
        break;
      } 
    } 
  }
  
  private void a(boolean paramBoolean) {
    this.f.setSelected(paramBoolean);
    if (paramBoolean) {
      d(false);
      e(false);
      c(false);
      b(false);
    } else {
      b(true);
    } 
    this.u = paramBoolean;
  }
  
  private boolean a(int paramInt) {
    String str1;
    if ((BluedConfig.b().j()).is_invisible_all == 1)
      return true; 
    switch (paramInt) {
      default:
        str1 = "";
        break;
      case 2131299821:
        str1 = "vip_center_super_hide_role_svip";
        break;
      case 2131299817:
        str1 = "vip_center_super_hide_distance_svip";
        break;
      case 2131299816:
        str1 = "vip_center_super_hide_all_svip";
        break;
      case 2131299814:
        str1 = "vip_center_super_hide_age_svip";
        break;
    } 
    String str2 = this.I;
    if (str2 != "")
      str1 = str2; 
    PayUtils.a(this.G, 2, str1, 4, VipProtos.FromType.UNKNOWN_FROM);
    return false;
  }
  
  private void b(boolean paramBoolean) {
    int i;
    this.j.setEnabled(paramBoolean);
    this.l.setEnabled(paramBoolean);
    this.i.setEnabled(paramBoolean);
    TextView textView = this.o;
    Context context = this.G;
    int j = 2131100838;
    if (paramBoolean) {
      i = 2131100838;
    } else {
      i = 2131100670;
    } 
    textView.setTextColor(BluedSkinUtils.a(context, i));
    textView = this.q;
    context = this.G;
    if (paramBoolean) {
      i = 2131100838;
    } else {
      i = 2131100670;
    } 
    textView.setTextColor(BluedSkinUtils.a(context, i));
    textView = this.p;
    context = this.G;
    if (paramBoolean) {
      i = j;
    } else {
      i = 2131100670;
    } 
    textView.setTextColor(BluedSkinUtils.a(context, i));
  }
  
  private void c(boolean paramBoolean) {
    byte b;
    this.j.setSelected(paramBoolean);
    PhotoGridView photoGridView = this.k;
    if (paramBoolean) {
      b = 0;
    } else {
      b = 8;
    } 
    photoGridView.setVisibility(b);
    this.y = paramBoolean;
  }
  
  private void d(boolean paramBoolean) {
    byte b;
    this.l.setSelected(paramBoolean);
    TwoWaysBar twoWaysBar = this.m;
    boolean bool = false;
    if (paramBoolean) {
      b = 0;
    } else {
      b = 8;
    } 
    twoWaysBar.setVisibility(b);
    TextView textView = this.n;
    if (paramBoolean) {
      b = bool;
    } else {
      b = 8;
    } 
    textView.setVisibility(b);
    this.A = paramBoolean;
  }
  
  private void e(boolean paramBoolean) {
    byte b;
    this.i.setSelected(paramBoolean);
    TwoWaysBar twoWaysBar = this.h;
    boolean bool = false;
    if (paramBoolean) {
      b = 0;
    } else {
      b = 8;
    } 
    twoWaysBar.setVisibility(b);
    TextView textView = this.g;
    if (paramBoolean) {
      b = bool;
    } else {
      b = 8;
    } 
    textView.setVisibility(b);
    this.w = paramBoolean;
  }
  
  private void k() {
    this.C = (CommonTopTitleNoTrans)this.e.findViewById(2131300300);
    this.C.setCenterText(this.H);
    this.C.setRightText(2131756206);
    this.C.setLeftClickListener(this);
    this.C.setRightClickListener(this);
    this.C.getTitleBackground().setBackground((Drawable)new ColorDrawable(0));
    ShapeTextView shapeTextView = this.C.getRightTextView();
    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)shapeTextView.getLayoutParams();
    layoutParams.rightMargin = DensityUtils.a(getContext(), 10.0F);
    shapeTextView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    shapeTextView.setTextColor(getResources().getColor(2131100716));
    ImageView imageView = this.C.getLeftImg();
    layoutParams = (RelativeLayout.LayoutParams)imageView.getLayoutParams();
    layoutParams.leftMargin = DensityUtils.a(getContext(), 10.0F);
    imageView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    imageView.setImageResource(2131232745);
  }
  
  private void l() {
    this.f = (ImageView)this.e.findViewById(2131299816);
    this.g = (TextView)this.e.findViewById(2131300717);
    this.h = (TwoWaysBar)this.e.findViewById(2131296500);
    this.i = (ImageView)this.e.findViewById(2131299817);
    this.j = (ImageView)this.e.findViewById(2131299821);
    this.k = (PhotoGridView)this.e.findViewById(2131297352);
    this.l = (ImageView)this.e.findViewById(2131299814);
    this.m = (TwoWaysBar)this.e.findViewById(2131296498);
    this.n = (TextView)this.e.findViewById(2131300502);
    this.o = (TextView)this.e.findViewById(2131300715);
    this.p = (TextView)this.e.findViewById(2131301285);
    this.q = (TextView)this.e.findViewById(2131300500);
    this.h.a(this.v, 100);
    this.g.setText(TwoWaysBar.a(getContext(), this.v, 1));
    this.h.setTwoWaysBarListner((TwoWaysBar.TwoWaysBarListner)new TwoWaysBar.TowWaysBarListenerAdapter(this) {
          public void a(int param1Int1, int param1Int2) {
            Integer integer;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(param1Int1);
            stringBuilder.append("-");
            if (param1Int2 >= 100) {
              String str1 = "max";
            } else {
              integer = Integer.valueOf(param1Int2);
            } 
            stringBuilder.append(integer);
            String str = stringBuilder.toString();
            VipInvisibleFragment.a(this.a, str);
            VipInvisibleFragment.a(this.a).setText(TwoWaysBar.a(this.a.getContext(), param1Int1, param1Int2, 1));
          }
        });
    this.z = m();
    this.m.d = 3;
    this.n.setText(a(this.z));
    this.m.a(this.z, this.r.length);
    this.m.setTwoWaysBarListner((TwoWaysBar.TwoWaysBarListner)new TwoWaysBar.TowWaysBarListenerAdapter(this) {
          public void a(int param1Int1, int param1Int2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(param1Int1);
            stringBuilder.append("-");
            stringBuilder.append(param1Int2);
            String str = stringBuilder.toString();
            VipInvisibleFragment.b(this.a, str);
            VipInvisibleFragment.b(this.a).setText(this.a.a(str));
          }
        });
    o();
    this.f.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.j.setOnClickListener(this);
    if (this.u)
      a(true); 
    if (this.y)
      c(true); 
    if (this.w)
      e(true); 
    if (this.A)
      d(true); 
  }
  
  private String m() {
    if (!TextUtils.isEmpty(this.z)) {
      String[] arrayOfString = this.r;
      if (arrayOfString != null && arrayOfString.length != 0) {
        StringBuilder stringBuilder1;
        String str;
        try {
          String[] arrayOfString1 = this.z.split("-");
          j = 0;
          String str1 = arrayOfString1[0];
          str = arrayOfString1[1];
          if (str.equals("max")) {
            i = this.r.length - 1;
          } else {
            i = -1;
          } 
        } catch (Exception exception) {
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append("0-");
          stringBuilder1.append(this.r.length - 1);
          return stringBuilder1.toString();
        } 
        int k = i;
        int m = -1;
        int i = j;
        int j = m;
        while (true) {
          m = j;
          int n = k;
          if (i < this.r.length) {
            if (j == -1 && stringBuilder1.equals(this.r[i])) {
              m = i;
              n = k;
            } else {
              m = j;
              n = k;
              if (k == -1) {
                m = j;
                n = k;
                if (str.equals(this.r[i])) {
                  n = i;
                  m = j;
                } 
              } 
            } 
          } else {
            stringBuilder1 = new StringBuilder();
            stringBuilder1.append(m);
            stringBuilder1.append("-");
            stringBuilder1.append(n);
            return stringBuilder1.toString();
          } 
          if (m == -1 || n == -1) {
            i++;
            j = m;
            k = n;
            continue;
          } 
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append(m);
          stringBuilder1.append("-");
          stringBuilder1.append(n);
          return stringBuilder1.toString();
        } 
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("0-");
    stringBuilder.append(this.r.length - 1);
    return stringBuilder.toString();
  }
  
  private void n() {
    this.B = DialogUtils.a(getContext());
    this.B.show();
    ProfileHttpUtils.a(getContext(), new BluedUIHttpResponse<BluedEntityA<VipInvisibleSettingModel>>(this, (IRequestHost)w_()) {
          protected void a(BluedEntityA<VipInvisibleSettingModel> param1BluedEntityA) {
            // Byte code:
            //   0: aload_0
            //   1: getfield a : Lcom/soft/blued/ui/user/fragment/VipInvisibleFragment;
            //   4: invokestatic c : (Lcom/soft/blued/ui/user/fragment/VipInvisibleFragment;)Landroid/app/Dialog;
            //   7: ifnull -> 20
            //   10: aload_0
            //   11: getfield a : Lcom/soft/blued/ui/user/fragment/VipInvisibleFragment;
            //   14: invokestatic c : (Lcom/soft/blued/ui/user/fragment/VipInvisibleFragment;)Landroid/app/Dialog;
            //   17: invokevirtual dismiss : ()V
            //   20: aload_1
            //   21: ifnull -> 314
            //   24: aload_1
            //   25: getfield data : Ljava/util/List;
            //   28: ifnull -> 314
            //   31: aload_1
            //   32: getfield data : Ljava/util/List;
            //   35: invokeinterface size : ()I
            //   40: ifle -> 314
            //   43: aload_0
            //   44: getfield a : Lcom/soft/blued/ui/user/fragment/VipInvisibleFragment;
            //   47: astore #4
            //   49: aload_1
            //   50: getfield data : Ljava/util/List;
            //   53: astore_1
            //   54: iconst_0
            //   55: istore_3
            //   56: aload #4
            //   58: aload_1
            //   59: iconst_0
            //   60: invokeinterface get : (I)Ljava/lang/Object;
            //   65: checkcast com/soft/blued/ui/user/model/VipInvisibleSettingModel
            //   68: invokestatic a : (Lcom/soft/blued/ui/user/fragment/VipInvisibleFragment;Lcom/soft/blued/ui/user/model/VipInvisibleSettingModel;)Lcom/soft/blued/ui/user/model/VipInvisibleSettingModel;
            //   71: pop
            //   72: aload_0
            //   73: getfield a : Lcom/soft/blued/ui/user/fragment/VipInvisibleFragment;
            //   76: astore_1
            //   77: aload_1
            //   78: invokestatic d : (Lcom/soft/blued/ui/user/fragment/VipInvisibleFragment;)Lcom/soft/blued/ui/user/model/VipInvisibleSettingModel;
            //   81: getfield is_invisible_all : I
            //   84: iconst_1
            //   85: if_icmpne -> 93
            //   88: iconst_1
            //   89: istore_2
            //   90: goto -> 95
            //   93: iconst_0
            //   94: istore_2
            //   95: aload_1
            //   96: iload_2
            //   97: invokestatic a : (Lcom/soft/blued/ui/user/fragment/VipInvisibleFragment;Z)Z
            //   100: pop
            //   101: aload_0
            //   102: getfield a : Lcom/soft/blued/ui/user/fragment/VipInvisibleFragment;
            //   105: astore_1
            //   106: aload_1
            //   107: aload_1
            //   108: invokestatic d : (Lcom/soft/blued/ui/user/fragment/VipInvisibleFragment;)Lcom/soft/blued/ui/user/model/VipInvisibleSettingModel;
            //   111: getfield age_range_stealth : Ljava/lang/String;
            //   114: invokestatic b : (Lcom/soft/blued/ui/user/fragment/VipInvisibleFragment;Ljava/lang/String;)Ljava/lang/String;
            //   117: pop
            //   118: aload_0
            //   119: getfield a : Lcom/soft/blued/ui/user/fragment/VipInvisibleFragment;
            //   122: astore_1
            //   123: aload_1
            //   124: aload_1
            //   125: invokestatic d : (Lcom/soft/blued/ui/user/fragment/VipInvisibleFragment;)Lcom/soft/blued/ui/user/model/VipInvisibleSettingModel;
            //   128: getfield stealth_distance : Ljava/lang/String;
            //   131: invokestatic a : (Lcom/soft/blued/ui/user/fragment/VipInvisibleFragment;Ljava/lang/String;)Ljava/lang/String;
            //   134: pop
            //   135: aload_0
            //   136: getfield a : Lcom/soft/blued/ui/user/fragment/VipInvisibleFragment;
            //   139: astore_1
            //   140: aload_1
            //   141: aload_1
            //   142: invokestatic d : (Lcom/soft/blued/ui/user/fragment/VipInvisibleFragment;)Lcom/soft/blued/ui/user/model/VipInvisibleSettingModel;
            //   145: getfield role_range_stealth : Ljava/lang/String;
            //   148: invokestatic c : (Lcom/soft/blued/ui/user/fragment/VipInvisibleFragment;Ljava/lang/String;)Ljava/lang/String;
            //   151: pop
            //   152: aload_0
            //   153: getfield a : Lcom/soft/blued/ui/user/fragment/VipInvisibleFragment;
            //   156: astore_1
            //   157: aload_1
            //   158: invokestatic d : (Lcom/soft/blued/ui/user/fragment/VipInvisibleFragment;)Lcom/soft/blued/ui/user/model/VipInvisibleSettingModel;
            //   161: getfield is_age_stealth : I
            //   164: iconst_1
            //   165: if_icmpne -> 173
            //   168: iconst_1
            //   169: istore_2
            //   170: goto -> 175
            //   173: iconst_0
            //   174: istore_2
            //   175: aload_1
            //   176: iload_2
            //   177: invokestatic b : (Lcom/soft/blued/ui/user/fragment/VipInvisibleFragment;Z)Z
            //   180: pop
            //   181: aload_0
            //   182: getfield a : Lcom/soft/blued/ui/user/fragment/VipInvisibleFragment;
            //   185: astore_1
            //   186: aload_1
            //   187: invokestatic d : (Lcom/soft/blued/ui/user/fragment/VipInvisibleFragment;)Lcom/soft/blued/ui/user/model/VipInvisibleSettingModel;
            //   190: getfield is_stealth_distance : I
            //   193: iconst_1
            //   194: if_icmpne -> 202
            //   197: iconst_1
            //   198: istore_2
            //   199: goto -> 204
            //   202: iconst_0
            //   203: istore_2
            //   204: aload_1
            //   205: iload_2
            //   206: invokestatic c : (Lcom/soft/blued/ui/user/fragment/VipInvisibleFragment;Z)Z
            //   209: pop
            //   210: aload_0
            //   211: getfield a : Lcom/soft/blued/ui/user/fragment/VipInvisibleFragment;
            //   214: astore_1
            //   215: aload_1
            //   216: invokestatic d : (Lcom/soft/blued/ui/user/fragment/VipInvisibleFragment;)Lcom/soft/blued/ui/user/model/VipInvisibleSettingModel;
            //   219: getfield is_role_stealth : I
            //   222: iconst_1
            //   223: if_icmpne -> 231
            //   226: iconst_1
            //   227: istore_2
            //   228: goto -> 233
            //   231: iconst_0
            //   232: istore_2
            //   233: aload_1
            //   234: iload_2
            //   235: invokestatic d : (Lcom/soft/blued/ui/user/fragment/VipInvisibleFragment;Z)Z
            //   238: pop
            //   239: aload_0
            //   240: getfield a : Lcom/soft/blued/ui/user/fragment/VipInvisibleFragment;
            //   243: invokestatic e : (Lcom/soft/blued/ui/user/fragment/VipInvisibleFragment;)Z
            //   246: ifne -> 281
            //   249: aload_0
            //   250: getfield a : Lcom/soft/blued/ui/user/fragment/VipInvisibleFragment;
            //   253: invokestatic f : (Lcom/soft/blued/ui/user/fragment/VipInvisibleFragment;)Z
            //   256: ifne -> 281
            //   259: aload_0
            //   260: getfield a : Lcom/soft/blued/ui/user/fragment/VipInvisibleFragment;
            //   263: invokestatic g : (Lcom/soft/blued/ui/user/fragment/VipInvisibleFragment;)Z
            //   266: ifne -> 281
            //   269: iload_3
            //   270: istore_2
            //   271: aload_0
            //   272: getfield a : Lcom/soft/blued/ui/user/fragment/VipInvisibleFragment;
            //   275: invokestatic h : (Lcom/soft/blued/ui/user/fragment/VipInvisibleFragment;)Z
            //   278: ifeq -> 283
            //   281: iconst_1
            //   282: istore_2
            //   283: aload_0
            //   284: getfield a : Lcom/soft/blued/ui/user/fragment/VipInvisibleFragment;
            //   287: invokestatic i : (Lcom/soft/blued/ui/user/fragment/VipInvisibleFragment;)Ljava/lang/String;
            //   290: invokestatic u : (Ljava/lang/String;)V
            //   293: ldc 'INVISIBLE_DISTANCE'
            //   295: invokestatic get : (Ljava/lang/String;)Lcom/jeremyliao/liveeventbus/core/Observable;
            //   298: iload_2
            //   299: invokestatic valueOf : (Z)Ljava/lang/Boolean;
            //   302: invokeinterface post : (Ljava/lang/Object;)V
            //   307: aload_0
            //   308: getfield a : Lcom/soft/blued/ui/user/fragment/VipInvisibleFragment;
            //   311: invokestatic j : (Lcom/soft/blued/ui/user/fragment/VipInvisibleFragment;)V
            //   314: return
          }
        }UserInfo.a().i().getUid(), (IRequestHost)w_());
  }
  
  private void o() {
    String str = this.G.getResources().getString(2131756489);
    int i = 0;
    UserTag userTag1 = new UserTag("1", str, 0);
    UserTag userTag2 = new UserTag("0.75", this.G.getResources().getString(2131758635), 0);
    UserTag userTag3 = new UserTag("0.5", this.G.getResources().getString(2131756484), 0);
    userTag4 = new UserTag("0.25", this.G.getResources().getString(2131758633), 0);
    UserTag userTag5 = new UserTag("0", this.G.getResources().getString(2131756500), 0);
    UserTag userTag6 = new UserTag("-1", this.G.getResources().getString(2131756491), 0);
    this.t.add(userTag1);
    this.t.add(userTag2);
    this.t.add(userTag3);
    this.t.add(userTag4);
    this.t.add(userTag5);
    this.t.add(userTag6);
    if (!TextUtils.isEmpty(this.x)) {
      String[] arrayOfString = this.x.split(",");
    } else {
      userTag1 = null;
    } 
    if (userTag1 != null && userTag1.length > 0) {
      int j = userTag1.length;
      while (i < j) {
        userTag2 = userTag1[i];
        for (UserTag userTag4 : this.t) {
          if (userTag2.equals(userTag4.id))
            userTag4.checked = 1; 
        } 
        i++;
      } 
    } 
    this.s = new UserTagAdapter(getContext(), this.t);
    this.k.setAdapter((ListAdapter)this.s);
    this.k.setOnItemClickListener(new -$$Lambda$VipInvisibleFragment$V0BxkOmwjPaGgcGqOlM1GhHM7b8(this));
  }
  
  private void p() {
    boolean bool;
    if (this.u || this.A || this.y || this.w) {
      bool = true;
    } else {
      bool = false;
    } 
    LiveEventBus.get("INVISIBLE_DISTANCE").post(Boolean.valueOf(bool));
  }
  
  private void q() {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private String r() {
    try {
      String[] arrayOfString = this.z.split("-");
      int i = Integer.parseInt(arrayOfString[0]);
      int j = Integer.parseInt(arrayOfString[1]);
      if (i > this.r.length - 1 || j > this.r.length - 1) {
        String str1 = this.r[0];
        null = this.r[this.r.length - 1];
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str1);
        stringBuilder1.append("-");
        stringBuilder1.append(null);
        return stringBuilder1.toString();
      } 
      String str = this.r[i];
      if (j == this.r.length - 1) {
        null = "max";
      } else {
        null = this.r[j];
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append("-");
      stringBuilder.append(null);
      return stringBuilder.toString();
    } catch (Exception exception) {
      return "18-max";
    } 
  }
  
  public String a(String paramString) {
    String str = AppInfo.d().getResources().getString(2131758299);
    if (!StringUtils.e(paramString) && (paramString.split("-")).length == 2) {
      String str1;
      String str2;
      StringBuilder stringBuilder1;
      String[] arrayOfString1 = paramString.split("-");
      int i = Integer.parseInt(arrayOfString1[0]);
      int j = Integer.parseInt(arrayOfString1[1]);
      String[] arrayOfString2 = this.r;
      if (i > arrayOfString2.length - 1 || j > arrayOfString2.length - 1) {
        arrayOfString2 = this.r;
        str1 = arrayOfString2[0];
        str2 = arrayOfString2[arrayOfString2.length - 1];
      } else {
        str1 = str2[i];
        str2 = str2[j];
      } 
      if (str1.equals(str2)) {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str1);
        stringBuilder1.append(str);
        return stringBuilder1.toString();
      } 
      if (j == this.r.length - 1) {
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(str1);
        stringBuilder3.append(" ～ ");
        stringBuilder3.append((String)stringBuilder1);
        stringBuilder3.append(str);
        stringBuilder3.append("+");
        return stringBuilder3.toString();
      } 
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(str1);
      stringBuilder2.append(" ～ ");
      stringBuilder2.append((String)stringBuilder1);
      stringBuilder2.append(str);
      return stringBuilder2.toString();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("18-80");
    stringBuilder.append(str);
    stringBuilder.append("+");
    return stringBuilder.toString();
  }
  
  public void onClick(View paramView) {
    switch (paramView.getId()) {
      default:
        return;
      case 2131299821:
        if (a(paramView.getId()))
          c(this.y ^ true); 
        EventTrackVIP.a(VipProtos.Event.VIP_CENTRE_SUPER_HIDE_SECOND_BTN_CLICK, VipProtos.HideType.HIDE_ROLE);
        p();
        return;
      case 2131299817:
        if (a(paramView.getId()))
          e(this.w ^ true); 
        EventTrackVIP.a(VipProtos.Event.VIP_CENTRE_SUPER_HIDE_SECOND_BTN_CLICK, VipProtos.HideType.HIDE_DISTANCE);
        p();
        return;
      case 2131299816:
        if (a(paramView.getId()))
          a(this.u ^ true); 
        EventTrackVIP.a(VipProtos.Event.VIP_CENTRE_SUPER_HIDE_SECOND_BTN_CLICK, VipProtos.HideType.HIDE_ALL);
        p();
        return;
      case 2131299814:
        if (a(paramView.getId()))
          d(this.A ^ true); 
        EventTrackVIP.a(VipProtos.Event.VIP_CENTRE_SUPER_HIDE_SECOND_BTN_CLICK, VipProtos.HideType.HIDE_AGE);
        p();
        return;
      case 2131296867:
        vipInvisibleDialogFragment = this.d;
        if (vipInvisibleDialogFragment != null)
          vipInvisibleDialogFragment.dismiss(); 
        q();
        return;
      case 2131296863:
        break;
    } 
    VipInvisibleDialogFragment vipInvisibleDialogFragment = this.d;
    if (vipInvisibleDialogFragment != null)
      vipInvisibleDialogFragment.dismiss(); 
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    EventTrackVIP.a(VipProtos.Event.VIP_CENTRE_SUPER_HIDE_SECOND_PAGE_SHOW, EventTrackVIP.b((UserInfo.a().i()).vip_grade));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.G = (Context)getActivity();
    this.e = paramLayoutInflater.inflate(2131494073, null);
    a();
    k();
    n();
    return this.e;
  }
  
  public void onDestroy() {
    super.onDestroy();
    this.d = null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\fragment\VipInvisibleFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */