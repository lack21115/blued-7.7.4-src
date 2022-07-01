package com.soft.blued.ui.user.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedHttpUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.Houyi;
import com.blued.android.module.common.utils.DialogUtils;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.PhotoGridView;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.ui.feed.adapter.NewsFeedGirdAdapter;
import com.soft.blued.ui.feed.fragment.PhotoSelectFragment;
import com.soft.blued.ui.feed.manager.SelectPhotoManager;
import com.soft.blued.ui.feed.model.ChildImageInfo;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.photo.fragment.BasePhotoFragment;
import com.soft.blued.ui.user.model.ReportPic;
import com.soft.blued.ui.user.model.UserInfoEntity;
import com.soft.blued.ui.user.observer.ReportObserver;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.util.ArrayList;
import java.util.List;

public class ReportFragmentNew extends BaseFragment implements View.OnClickListener {
  private static String[] u;
  
  private String A;
  
  private boolean B;
  
  private Dialog C;
  
  private TextView D;
  
  private View d;
  
  private Context e;
  
  private CommonTopTitleNoTrans f;
  
  private TextView g;
  
  private TextView h;
  
  private TextView i;
  
  private TextView j;
  
  private EditText k;
  
  private TextView l;
  
  private PhotoGridView m;
  
  private TextView n;
  
  private TextWatcher o;
  
  private LinearLayout p;
  
  private ToggleButton q;
  
  private NewsFeedGirdAdapter r;
  
  private List<ChildImageInfo> s = new ArrayList<ChildImageInfo>();
  
  private List<ChildImageInfo> t = new ArrayList<ChildImageInfo>();
  
  private boolean v = false;
  
  private int w;
  
  private int x;
  
  private String y;
  
  private String z;
  
  private void a(int paramInt) {
    if (u == null)
      u = new String[this.s.size()]; 
    List<ChildImageInfo> list = this.s;
    if (list != null && paramInt < list.size()) {
      String str1 = ((ChildImageInfo)this.s.get(paramInt)).mImagePath;
      String str2 = RecyclingUtils.e("photo");
      Houyi.a().a(str1, str2).b();
      MineHttpUtils.a(this.e, new BluedUIHttpResponse<BluedEntityA<ReportPic>>(this, (IRequestHost)w_(), paramInt) {
            boolean a = false;
            
            protected void a(BluedEntityA<ReportPic> param1BluedEntityA) {
              if (param1BluedEntityA.data != null) {
                if (param1BluedEntityA.data.size() > 0) {
                  if (ReportFragmentNew.a() == null)
                    ReportFragmentNew.a(new String[ReportFragmentNew.h(this.c).size()]); 
                  ReportFragmentNew.a()[this.b] = ((ReportPic)param1BluedEntityA.data.get(0)).url;
                  if (this.b == ReportFragmentNew.h(this.c).size() - 1) {
                    ReportFragmentNew reportFragmentNew1 = this.c;
                    StringBuilder stringBuilder1 = new StringBuilder();
                    stringBuilder1.append(ReportFragmentNew.b(this.c).getText());
                    stringBuilder1.append("");
                    ReportFragmentNew.a(reportFragmentNew1, stringBuilder1.toString(), ReportFragmentNew.i(this.c), ReportFragmentNew.j(this.c), ReportFragmentNew.a());
                    return;
                  } 
                  ReportFragmentNew.a(this.c, this.b + 1);
                  return;
                } 
                ReportFragmentNew reportFragmentNew = this.c;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(ReportFragmentNew.b(this.c).getText());
                stringBuilder.append("");
                ReportFragmentNew.a(reportFragmentNew, stringBuilder.toString(), ReportFragmentNew.i(this.c), ReportFragmentNew.j(this.c), ReportFragmentNew.a());
              } 
            }
            
            public boolean onUIFailure(int param1Int, String param1String) {
              this.a = true;
              return super.onUIFailure(param1Int, param1String);
            }
            
            public void onUIFinish() {
              super.onUIFinish();
              if (this.a)
                DialogUtils.b(ReportFragmentNew.g(this.c)); 
              this.a = false;
            }
            
            public void onUIStart() {
              super.onUIStart();
              DialogUtils.a(ReportFragmentNew.g(this.c));
            }
          }str2);
    } 
  }
  
  public static void a(Context paramContext, int paramInt, String paramString1, String paramString2) {
    Bundle bundle = new Bundle();
    bundle.putInt("KEY_REPORT_TARGET", paramInt);
    bundle.putString("KEY_REPORT_TARGET_ID", paramString1);
    bundle.putString("KEY_REPORT_TARGET_TEXT", paramString2);
    TerminalActivity.d(paramContext, ReportFragmentNew.class, bundle);
  }
  
  public static void a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3) {
    Bundle bundle = new Bundle();
    bundle.putInt("KEY_REPORT_TARGET", paramInt);
    bundle.putString("KEY_REPORT_TARGET_ID", paramString1);
    bundle.putString("KEY_REPORT_TARGET_TEXT", paramString2);
    bundle.putString("KEY_REPORT_EXTRA", paramString3);
    TerminalActivity.d(paramContext, ReportFragmentNew.class, bundle);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3) {
    Bundle bundle = new Bundle();
    bundle.putInt("KEY_REPORT_TARGET", 5);
    bundle.putString("KEY_REPORT_TARGET_ID", paramString1);
    bundle.putString("KEY_REPORT_EXTRA", paramString2);
    bundle.putString("KEY_REPORT_TARGET_TEXT", paramString3);
    TerminalActivity.d(paramContext, ReportFragmentNew.class, bundle);
  }
  
  private void a(String paramString1, int paramInt, String paramString2, String[] paramArrayOfString) {
    ChatHttpUtils.a(this.e, new BluedUIHttpResponse<BluedEntityA<Object>>(this, (IRequestHost)w_()) {
          protected void a(BluedEntityA<Object> param1BluedEntityA) {
            CommonAlertDialog.a(ReportFragmentNew.k(this.a), null, this.a.getResources().getString(2131758601), this.a.getResources().getString(2131758600), this.a.getResources().getString(2131756100), new DialogInterface.OnClickListener(this) {
                  public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                    ReportObserver.a().a(true);
                    this.a.a.getActivity().finish();
                  }
                },  new DialogInterface.OnCancelListener(this) {
                  public void onCancel(DialogInterface param2DialogInterface) {
                    ReportObserver.a().a(true);
                    this.a.a.getActivity().finish();
                  }
                },  false);
          }
          
          public boolean onUIFailure(int param1Int, String param1String1, String param1String2) {
            if (((Integer)(BluedHttpUtils.a(null, param1Int, param1String2)).first).intValue() == 0)
              return super.onUIFailure(param1Int, param1String1, param1String2); 
            if (param1Int != 403001)
              return super.onUIFailure(param1Int, param1String1, param1String2); 
            CommonAlertDialog.a(ReportFragmentNew.k(this.a), ReportFragmentNew.k(this.a).getResources().getString(2131758948), ReportFragmentNew.k(this.a).getResources().getString(2131758949), ReportFragmentNew.k(this.a).getResources().getString(2131756086), new DialogInterface.OnClickListener(this) {
                  public void onClick(DialogInterface param2DialogInterface, int param2Int) {}
                },  null, 1);
            return true;
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(ReportFragmentNew.g(this.a));
          }
          
          public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(ReportFragmentNew.g(this.a));
          }
        }paramString1, paramArrayOfString, paramInt, paramString2, this.z, 0L, this.w, (IRequestHost)w_());
  }
  
  public static void b(Context paramContext, int paramInt, String paramString1, String paramString2) {
    Bundle bundle = new Bundle();
    bundle.putInt("KEY_REPORT_TARGET", paramInt);
    bundle.putString("KEY_REPORT_TARGET_ID", paramString1);
    bundle.putString("KEY_REPORT_TARGET_TEXT", paramString2);
    bundle.putBoolean("KEY_REPORT_SHOW_BLOCK", true);
    TerminalActivity.d(paramContext, ReportFragmentNew.class, bundle);
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2, String paramString3) {
    Bundle bundle = new Bundle();
    bundle.putInt("KEY_REPORT_TARGET", 10);
    bundle.putString("KEY_REPORT_TARGET_ID", paramString1);
    bundle.putString("KEY_REPORT_EXTRA", paramString2);
    bundle.putString("KEY_REPORT_TARGET_TEXT", paramString3);
    TerminalActivity.d(paramContext, ReportFragmentNew.class, bundle);
  }
  
  private void k() {
    String str;
    this.C = DialogUtils.a(this.e);
    this.f = (CommonTopTitleNoTrans)this.d.findViewById(2131300300);
    this.f.a();
    this.f.setCenterText(this.e.getResources().getString(2131758584));
    this.f.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.V_();
          }
        });
    this.g = (TextView)this.d.findViewById(2131301266);
    this.h = (TextView)this.d.findViewById(2131301267);
    this.i = (TextView)this.d.findViewById(2131301380);
    this.j = (TextView)this.d.findViewById(2131300909);
    this.D = (TextView)this.d.findViewById(2131301402);
    this.i.setText("0/200");
    this.k = (EditText)this.d.findViewById(2131297011);
    this.o = new TextWatcher(this) {
        private int b;
        
        private int c;
        
        public void afterTextChanged(Editable param1Editable) {
          try {
            ReportFragmentNew.b(this.a).removeTextChangedListener(ReportFragmentNew.a(this.a));
            this.b = ReportFragmentNew.b(this.a).getSelectionStart();
            this.c = ReportFragmentNew.b(this.a).getSelectionEnd();
            while (param1Editable.length() > 200) {
              param1Editable.delete(this.b - 1, this.c);
              this.b--;
              this.c--;
            } 
            int i = param1Editable.length();
            TextView textView = ReportFragmentNew.c(this.a);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i);
            stringBuilder.append("/");
            stringBuilder.append(200);
            textView.setText(stringBuilder.toString());
            ReportFragmentNew.d(this.a);
            ReportFragmentNew.b(this.a).addTextChangedListener(ReportFragmentNew.a(this.a));
            return;
          } catch (Exception exception) {
            exception.printStackTrace();
            return;
          } 
        }
        
        public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
        
        public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
      };
    this.k.addTextChangedListener(this.o);
    this.l = (TextView)this.d.findViewById(2131301172);
    this.l.setText("0/6");
    this.m = (PhotoGridView)this.d.findViewById(2131297289);
    this.r = new NewsFeedGirdAdapter(this.e, (IRequestHost)w_(), this.t);
    this.m.setAdapter((ListAdapter)this.r);
    this.m.setOnItemClickListener(new AdapterView.OnItemClickListener(this) {
          public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
            if (!ReportFragmentNew.e(this.a) && ReportFragmentNew.f(this.a) != null && param1Int < ReportFragmentNew.f(this.a).size()) {
              if (StringUtils.e(((ChildImageInfo)ReportFragmentNew.f(this.a).get(param1Int)).mImagePath)) {
                PhotoSelectFragment.a(this.a, 7, 0);
              } else {
                BasePhotoFragment.a((Context)this.a.getActivity(), param1Int, 0, null);
              } 
              ReportFragmentNew.a(this.a, true);
            } 
          }
        });
    this.p = (LinearLayout)this.d.findViewById(2131298724);
    this.q = (ToggleButton)this.d.findViewById(2131300184);
    if (this.B) {
      this.p.setVisibility(0);
      this.q.setChecked(false);
    } else {
      this.p.setVisibility(8);
      this.q.setChecked(false);
    } 
    this.n = (TextView)this.d.findViewById(2131301363);
    this.n.setOnClickListener(this);
    int i = this.x;
    if (i != 1) {
      if (i != 2) {
        if (i != 4) {
          if (i != 5) {
            switch (i) {
              default:
                str = "";
                break;
              case 11:
                str = String.format(this.e.getResources().getString(2131758585), new Object[] { this.A });
                break;
              case 10:
                str = String.format(this.e.getResources().getString(2131758587), new Object[] { this.A });
                break;
              case 9:
                str = String.format(this.e.getResources().getString(2131758590), new Object[] { this.A });
                break;
            } 
          } else {
          
          } 
        } else {
          str = String.format(this.e.getResources().getString(2131758591), new Object[] { this.A });
        } 
      } else {
      
      } 
    } else {
      str = String.format(this.e.getResources().getString(2131758606), new Object[] { this.A });
    } 
    this.h.setText(str);
    ChooseReportReasonFragment.a(this, false);
  }
  
  private void l() {
    int i = this.w;
    if (i != -1) {
      if (i == 0) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.k.getText());
        stringBuilder.append("");
        if (!StringUtils.e(stringBuilder.toString())) {
          this.n.setBackgroundColor(getResources().getColor(2131100234));
          this.n.setOnClickListener(this);
          return;
        } 
        this.n.setBackgroundColor(getResources().getColor(2131100235));
        this.n.setOnClickListener(null);
        return;
      } 
      this.n.setBackgroundColor(getResources().getColor(2131100234));
      this.n.setOnClickListener(this);
      return;
    } 
    this.n.setBackgroundColor(getResources().getColor(2131100235));
    this.n.setOnClickListener(null);
  }
  
  private void m() {
    u = null;
    this.s.clear();
    this.s.addAll(SelectPhotoManager.a().c());
    this.t.clear();
    this.t.addAll(SelectPhotoManager.a().c());
    if (this.t.size() < 6) {
      ChildImageInfo childImageInfo = new ChildImageInfo();
      childImageInfo.mImagePath = null;
      this.t.add(childImageInfo);
    } 
    TextView textView = this.l;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.s.size());
    stringBuilder.append(" / ");
    stringBuilder.append(6);
    textView.setText(stringBuilder.toString());
    NewsFeedGirdAdapter newsFeedGirdAdapter = this.r;
    if (newsFeedGirdAdapter != null)
      newsFeedGirdAdapter.notifyDataSetChanged(); 
  }
  
  private void n() {
    if (TextUtils.isEmpty(this.y))
      return; 
    UserHttpUtils.b(this.e, new BluedUIHttpResponse<BluedEntityA<Object>>(this, (IRequestHost)w_()) {
          protected void a(BluedEntityA<Object> param1BluedEntityA) {
            UserInfo.a().i().addBlackCount();
            ChatHelperV4.a().b(Long.parseLong(ReportFragmentNew.j(this.a)));
            UserInfoEntity userInfoEntity = new UserInfoEntity();
            userInfoEntity.uid = ReportFragmentNew.j(this.a);
            userInfoEntity.relationship = "4";
            LiveEventBus.get("feed_relation_ship").post(userInfoEntity);
          }
        }UserInfo.a().i().getUid(), this.y, (IRequestHost)w_());
  }
  
  public boolean V_() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.k.getText());
    stringBuilder.append("");
    if (StringUtils.e(stringBuilder.toString()) && this.s.size() == 0) {
      getActivity().finish();
    } else {
      CommonAlertDialog.a((Context)getActivity(), null, getResources().getString(2131756110), getResources().getString(2131756129), new DialogInterface.OnClickListener(this) {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
              ReportFragmentNew.g(this.a).show();
              if (ReportFragmentNew.h(this.a).size() > 0) {
                if (ReportFragmentNew.a() != null) {
                  if ((ReportFragmentNew.a()).length > 0)
                    ReportFragmentNew.a(this.a, (ReportFragmentNew.a()).length - 1); 
                } else {
                  ReportFragmentNew.a(this.a, 0);
                } 
              } else {
                ReportFragmentNew reportFragmentNew = this.a;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(ReportFragmentNew.b(this.a).getText());
                stringBuilder.append("");
                ReportFragmentNew.a(reportFragmentNew, stringBuilder.toString(), ReportFragmentNew.i(this.a), ReportFragmentNew.j(this.a), (String[])null);
              } 
              if (ReportFragmentNew.l(this.a).getVisibility() == 0 && ReportFragmentNew.m(this.a).isChecked())
                ReportFragmentNew.n(this.a); 
            }
          }getResources().getString(2131755730), new DialogInterface.OnClickListener(this) {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
              this.a.getActivity().finish();
            }
          },  null);
    } 
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1) {
      if (paramInt2 == -1 && paramIntent != null) {
        this.w = paramIntent.getIntExtra("KEY_REPORT_ITEM_ID", -1);
        String str = paramIntent.getStringExtra("KEY_REPORT_ITEM_TEXT");
        if (TextUtils.equals(str, this.e.getResources().getString(2131756126)))
          if ((UserInfo.a().i()).vbadge == 4 || (UserInfo.a().i()).vbadge == 7) {
            this.j.setText(2131757045);
          } else {
            this.D.setVisibility(0);
            String str1 = this.e.getResources().getString(2131757046);
            SpannableString spannableString = new SpannableString(str1);
            spannableString.setSpan(new ForegroundColorSpan(this.e.getResources().getColor(2131100837)), str1.indexOf("（"), spannableString.length(), 33);
            this.j.setText((CharSequence)spannableString);
          }  
        TextView textView = this.g;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.e.getResources().getString(2131758597));
        stringBuilder.append(str);
        textView.setText(stringBuilder.toString());
        l();
        return;
      } 
      getActivity().finish();
    } 
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() != 2131301363)
      return; 
    this.C.show();
    if (this.s.size() > 0) {
      String[] arrayOfString = u;
      if (arrayOfString != null) {
        if (arrayOfString.length > 0)
          a(arrayOfString.length - 1); 
      } else {
        a(0);
      } 
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.k.getText());
      stringBuilder.append("");
      a(stringBuilder.toString(), this.x, this.y, (String[])null);
    } 
    if (this.p.getVisibility() == 0 && this.q.isChecked())
      n(); 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.e = (Context)getActivity();
    if (this.d == null) {
      this.d = paramLayoutInflater.inflate(2131493298, paramViewGroup, false);
      if (getArguments() != null) {
        this.x = getArguments().getInt("KEY_REPORT_TARGET");
        this.y = getArguments().getString("KEY_REPORT_TARGET_ID");
        this.z = getArguments().getString("KEY_REPORT_EXTRA");
        this.A = getArguments().getString("KEY_REPORT_TARGET_TEXT");
        this.B = getArguments().getBoolean("KEY_REPORT_SHOW_BLOCK");
      } 
      SelectPhotoManager.a().d();
      k();
      m();
    } 
    return this.d;
  }
  
  public void onDestroy() {
    super.onDestroy();
    SelectPhotoManager.a().d();
  }
  
  public void onResume() {
    super.onResume();
    m();
    this.v = false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\fragment\ReportFragmentNew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */