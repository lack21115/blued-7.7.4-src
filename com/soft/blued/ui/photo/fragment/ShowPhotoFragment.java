package com.soft.blued.ui.photo.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.das.profile.PersonalProfileProtos;
import com.blued.das.vip.VipProtos;
import com.github.chrisbanes.photoview.PhotoView;
import com.soft.blued.app.permission.PermissionHelper;
import com.soft.blued.customview.ActionSheet;
import com.soft.blued.customview.HackyViewPager;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.http.ProfileHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.trackUtils.EventTrackPersonalProfile;
import com.soft.blued.model.BluedAlbum;
import com.soft.blued.ui.live.manager.LiveApplyDelPhotoObserver;
import com.soft.blued.ui.msg.pop.BottomMenuPop;
import com.soft.blued.ui.user.fragment.WidgetListFragment;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.view.tip.CommonAlertDialog;
import com.soft.blued.view.tip.CommonShowBottomWindow;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ShowPhotoFragment extends BasePhotoFragment implements View.OnClickListener {
  private Context f;
  
  private View g;
  
  private LayoutInflater h;
  
  private ImagePagerAdapter i;
  
  private LoadOptions j;
  
  private int k;
  
  private int l;
  
  private Dialog m;
  
  private HackyViewPager n;
  
  private ImageView o;
  
  private int p;
  
  private String q;
  
  private List<BluedAlbum> r = new ArrayList<BluedAlbum>();
  
  private String[] s;
  
  private String[] t;
  
  private View u;
  
  private TextView v;
  
  private TextView w;
  
  private String x;
  
  private int y;
  
  private BottomMenuPop z;
  
  private void a(String paramString) {
    DialogUtils.a(this.m);
    MineHttpUtils.c(this.f, new BluedUIHttpResponse<BluedEntityA<Object>>(this, paramString) {
          public void a(BluedEntityA<Object> param1BluedEntityA) {
            // Byte code:
            //   0: invokestatic a : ()Lcom/soft/blued/user/UserInfo;
            //   3: invokevirtual i : ()Lcom/soft/blued/ui/login_register/model/BluedLoginResult;
            //   6: invokevirtual getVip_avatars : ()Ljava/util/List;
            //   9: astore_3
            //   10: aload_3
            //   11: ifnull -> 69
            //   14: aload_3
            //   15: invokeinterface size : ()I
            //   20: ifle -> 69
            //   23: iconst_0
            //   24: istore_2
            //   25: iload_2
            //   26: aload_3
            //   27: invokeinterface size : ()I
            //   32: if_icmpge -> 69
            //   35: aload_3
            //   36: iload_2
            //   37: invokeinterface get : (I)Ljava/lang/Object;
            //   42: checkcast com/soft/blued/model/BluedAlbum
            //   45: invokevirtual getPid : ()Ljava/lang/String;
            //   48: aload_0
            //   49: getfield a : Ljava/lang/String;
            //   52: invokevirtual equals : (Ljava/lang/Object;)Z
            //   55: ifeq -> 224
            //   58: aload_3
            //   59: iload_2
            //   60: invokeinterface remove : (I)Ljava/lang/Object;
            //   65: pop
            //   66: goto -> 69
            //   69: invokestatic a : ()Lcom/soft/blued/ui/find/observer/UserInfoDataObserver;
            //   72: invokevirtual b : ()V
            //   75: aload_0
            //   76: getfield b : Lcom/soft/blued/ui/photo/fragment/ShowPhotoFragment;
            //   79: invokestatic e : (Lcom/soft/blued/ui/photo/fragment/ShowPhotoFragment;)Ljava/util/List;
            //   82: aload_0
            //   83: getfield b : Lcom/soft/blued/ui/photo/fragment/ShowPhotoFragment;
            //   86: invokestatic l : (Lcom/soft/blued/ui/photo/fragment/ShowPhotoFragment;)I
            //   89: invokeinterface remove : (I)Ljava/lang/Object;
            //   94: pop
            //   95: aload_0
            //   96: getfield b : Lcom/soft/blued/ui/photo/fragment/ShowPhotoFragment;
            //   99: invokestatic l : (Lcom/soft/blued/ui/photo/fragment/ShowPhotoFragment;)I
            //   102: aload_0
            //   103: getfield b : Lcom/soft/blued/ui/photo/fragment/ShowPhotoFragment;
            //   106: invokestatic e : (Lcom/soft/blued/ui/photo/fragment/ShowPhotoFragment;)Ljava/util/List;
            //   109: invokeinterface size : ()I
            //   114: iconst_1
            //   115: isub
            //   116: if_icmplt -> 141
            //   119: aload_0
            //   120: getfield b : Lcom/soft/blued/ui/photo/fragment/ShowPhotoFragment;
            //   123: aload_0
            //   124: getfield b : Lcom/soft/blued/ui/photo/fragment/ShowPhotoFragment;
            //   127: invokestatic e : (Lcom/soft/blued/ui/photo/fragment/ShowPhotoFragment;)Ljava/util/List;
            //   130: invokeinterface size : ()I
            //   135: iconst_1
            //   136: isub
            //   137: invokestatic a : (Lcom/soft/blued/ui/photo/fragment/ShowPhotoFragment;I)I
            //   140: pop
            //   141: aload_0
            //   142: getfield b : Lcom/soft/blued/ui/photo/fragment/ShowPhotoFragment;
            //   145: invokestatic n : (Lcom/soft/blued/ui/photo/fragment/ShowPhotoFragment;)Lcom/soft/blued/customview/HackyViewPager;
            //   148: aload_0
            //   149: getfield b : Lcom/soft/blued/ui/photo/fragment/ShowPhotoFragment;
            //   152: invokestatic m : (Lcom/soft/blued/ui/photo/fragment/ShowPhotoFragment;)Lcom/soft/blued/ui/photo/fragment/ShowPhotoFragment$ImagePagerAdapter;
            //   155: invokevirtual setAdapter : (Landroidx/viewpager/widget/PagerAdapter;)V
            //   158: aload_0
            //   159: getfield b : Lcom/soft/blued/ui/photo/fragment/ShowPhotoFragment;
            //   162: invokestatic n : (Lcom/soft/blued/ui/photo/fragment/ShowPhotoFragment;)Lcom/soft/blued/customview/HackyViewPager;
            //   165: aload_0
            //   166: getfield b : Lcom/soft/blued/ui/photo/fragment/ShowPhotoFragment;
            //   169: invokestatic l : (Lcom/soft/blued/ui/photo/fragment/ShowPhotoFragment;)I
            //   172: invokevirtual setCurrentItem : (I)V
            //   175: aload_0
            //   176: getfield b : Lcom/soft/blued/ui/photo/fragment/ShowPhotoFragment;
            //   179: invokestatic a : (Lcom/soft/blued/ui/photo/fragment/ShowPhotoFragment;)V
            //   182: aload_1
            //   183: getfield code : I
            //   186: sipush #200
            //   189: if_icmpne -> 198
            //   192: ldc 2131756206
            //   194: invokestatic d : (I)V
            //   197: return
            //   198: ldc 2131756082
            //   200: invokestatic d : (I)V
            //   203: return
            //   204: astore_1
            //   205: aload_1
            //   206: invokevirtual printStackTrace : ()V
            //   209: invokestatic d : ()Landroid/content/Context;
            //   212: invokevirtual getResources : ()Landroid/content/res/Resources;
            //   215: ldc 2131756082
            //   217: invokevirtual getString : (I)Ljava/lang/String;
            //   220: invokestatic a : (Ljava/lang/CharSequence;)V
            //   223: return
            //   224: iload_2
            //   225: iconst_1
            //   226: iadd
            //   227: istore_2
            //   228: goto -> 25
            // Exception table:
            //   from	to	target	type
            //   0	10	204	java/lang/Exception
            //   14	23	204	java/lang/Exception
            //   25	66	204	java/lang/Exception
            //   69	141	204	java/lang/Exception
            //   141	197	204	java/lang/Exception
            //   198	203	204	java/lang/Exception
          }
          
          public void onUIFinish() {
            DialogUtils.b(ShowPhotoFragment.o(this.b));
            if (ShowPhotoFragment.e(this.b).size() == 0)
              this.b.getActivity().finish(); 
          }
        }paramString, (IRequestHost)w_());
  }
  
  private void b(String paramString) {
    DialogUtils.a(this.m);
    ProfileHttpUtils.b(this.f, new BluedUIHttpResponse<BluedEntityA<Object>>(this, paramString) {
          public void a(BluedEntityA<Object> param1BluedEntityA) {
            // Byte code:
            //   0: invokestatic a : ()Lcom/soft/blued/user/UserInfo;
            //   3: invokevirtual i : ()Lcom/soft/blued/ui/login_register/model/BluedLoginResult;
            //   6: invokevirtual getAlbum : ()Ljava/util/List;
            //   9: astore_3
            //   10: aload_3
            //   11: ifnull -> 69
            //   14: aload_3
            //   15: invokeinterface size : ()I
            //   20: ifle -> 69
            //   23: iconst_0
            //   24: istore_2
            //   25: iload_2
            //   26: aload_3
            //   27: invokeinterface size : ()I
            //   32: if_icmpge -> 69
            //   35: aload_3
            //   36: iload_2
            //   37: invokeinterface get : (I)Ljava/lang/Object;
            //   42: checkcast com/soft/blued/model/BluedAlbum
            //   45: invokevirtual getPid : ()Ljava/lang/String;
            //   48: aload_0
            //   49: getfield a : Ljava/lang/String;
            //   52: invokevirtual equals : (Ljava/lang/Object;)Z
            //   55: ifeq -> 224
            //   58: aload_3
            //   59: iload_2
            //   60: invokeinterface remove : (I)Ljava/lang/Object;
            //   65: pop
            //   66: goto -> 69
            //   69: invokestatic a : ()Lcom/soft/blued/ui/find/observer/UserInfoDataObserver;
            //   72: invokevirtual b : ()V
            //   75: aload_0
            //   76: getfield b : Lcom/soft/blued/ui/photo/fragment/ShowPhotoFragment;
            //   79: invokestatic e : (Lcom/soft/blued/ui/photo/fragment/ShowPhotoFragment;)Ljava/util/List;
            //   82: aload_0
            //   83: getfield b : Lcom/soft/blued/ui/photo/fragment/ShowPhotoFragment;
            //   86: invokestatic l : (Lcom/soft/blued/ui/photo/fragment/ShowPhotoFragment;)I
            //   89: invokeinterface remove : (I)Ljava/lang/Object;
            //   94: pop
            //   95: aload_0
            //   96: getfield b : Lcom/soft/blued/ui/photo/fragment/ShowPhotoFragment;
            //   99: invokestatic l : (Lcom/soft/blued/ui/photo/fragment/ShowPhotoFragment;)I
            //   102: aload_0
            //   103: getfield b : Lcom/soft/blued/ui/photo/fragment/ShowPhotoFragment;
            //   106: invokestatic e : (Lcom/soft/blued/ui/photo/fragment/ShowPhotoFragment;)Ljava/util/List;
            //   109: invokeinterface size : ()I
            //   114: iconst_1
            //   115: isub
            //   116: if_icmplt -> 141
            //   119: aload_0
            //   120: getfield b : Lcom/soft/blued/ui/photo/fragment/ShowPhotoFragment;
            //   123: aload_0
            //   124: getfield b : Lcom/soft/blued/ui/photo/fragment/ShowPhotoFragment;
            //   127: invokestatic e : (Lcom/soft/blued/ui/photo/fragment/ShowPhotoFragment;)Ljava/util/List;
            //   130: invokeinterface size : ()I
            //   135: iconst_1
            //   136: isub
            //   137: invokestatic a : (Lcom/soft/blued/ui/photo/fragment/ShowPhotoFragment;I)I
            //   140: pop
            //   141: aload_0
            //   142: getfield b : Lcom/soft/blued/ui/photo/fragment/ShowPhotoFragment;
            //   145: invokestatic n : (Lcom/soft/blued/ui/photo/fragment/ShowPhotoFragment;)Lcom/soft/blued/customview/HackyViewPager;
            //   148: aload_0
            //   149: getfield b : Lcom/soft/blued/ui/photo/fragment/ShowPhotoFragment;
            //   152: invokestatic m : (Lcom/soft/blued/ui/photo/fragment/ShowPhotoFragment;)Lcom/soft/blued/ui/photo/fragment/ShowPhotoFragment$ImagePagerAdapter;
            //   155: invokevirtual setAdapter : (Landroidx/viewpager/widget/PagerAdapter;)V
            //   158: aload_0
            //   159: getfield b : Lcom/soft/blued/ui/photo/fragment/ShowPhotoFragment;
            //   162: invokestatic n : (Lcom/soft/blued/ui/photo/fragment/ShowPhotoFragment;)Lcom/soft/blued/customview/HackyViewPager;
            //   165: aload_0
            //   166: getfield b : Lcom/soft/blued/ui/photo/fragment/ShowPhotoFragment;
            //   169: invokestatic l : (Lcom/soft/blued/ui/photo/fragment/ShowPhotoFragment;)I
            //   172: invokevirtual setCurrentItem : (I)V
            //   175: aload_0
            //   176: getfield b : Lcom/soft/blued/ui/photo/fragment/ShowPhotoFragment;
            //   179: invokestatic a : (Lcom/soft/blued/ui/photo/fragment/ShowPhotoFragment;)V
            //   182: aload_1
            //   183: getfield code : I
            //   186: sipush #200
            //   189: if_icmpne -> 198
            //   192: ldc 2131756206
            //   194: invokestatic d : (I)V
            //   197: return
            //   198: ldc 2131756082
            //   200: invokestatic d : (I)V
            //   203: return
            //   204: astore_1
            //   205: aload_1
            //   206: invokevirtual printStackTrace : ()V
            //   209: invokestatic d : ()Landroid/content/Context;
            //   212: invokevirtual getResources : ()Landroid/content/res/Resources;
            //   215: ldc 2131756082
            //   217: invokevirtual getString : (I)Ljava/lang/String;
            //   220: invokestatic a : (Ljava/lang/CharSequence;)V
            //   223: return
            //   224: iload_2
            //   225: iconst_1
            //   226: iadd
            //   227: istore_2
            //   228: goto -> 25
            // Exception table:
            //   from	to	target	type
            //   0	10	204	java/lang/Exception
            //   14	23	204	java/lang/Exception
            //   25	66	204	java/lang/Exception
            //   69	141	204	java/lang/Exception
            //   141	197	204	java/lang/Exception
            //   198	203	204	java/lang/Exception
          }
          
          public void onUIFinish() {
            DialogUtils.b(ShowPhotoFragment.o(this.b));
            if (ShowPhotoFragment.e(this.b).size() == 0)
              this.b.getActivity().finish(); 
          }
        }paramString, (IRequestHost)w_());
  }
  
  private void n() {
    Bundle bundle = getArguments();
    if (bundle != null) {
      this.p = getArguments().getInt("show_photo");
      this.q = getArguments().getString("WATER_MASK_NAME");
      byte b = 0;
      this.k = bundle.getInt("photo_index", 0);
      this.j = (LoadOptions)bundle.getSerializable("photo_options");
      this.x = bundle.getString("UID");
      this.y = bundle.getInt("avatar_widget");
      this.l = this.k;
      this.t = bundle.getStringArray("photo_datas");
      this.s = bundle.getStringArray("photo_pids");
      if (this.t != null) {
        int j;
        String str = "";
        int i = 0;
        while (true) {
          j = b;
          if (i < this.t.length) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("<>");
            stringBuilder.append(this.t[i]);
            str = stringBuilder.toString();
            i++;
            continue;
          } 
          break;
        } 
        while (j < this.t.length) {
          BluedAlbum bluedAlbum = new BluedAlbum();
          bluedAlbum.setUrl(this.t[j]);
          String[] arrayOfString = this.s;
          if (arrayOfString != null)
            bluedAlbum.setPid(arrayOfString[j]); 
          this.r.add(bluedAlbum);
          j++;
        } 
      } 
    } 
  }
  
  private void o() {
    this.m = DialogUtils.a((Context)getActivity());
    this.h = LayoutInflater.from(this.f);
    this.n = (HackyViewPager)this.g.findViewById(2131299443);
    this.o = (ImageView)this.g.findViewById(2131296787);
    this.o.setOnClickListener(this);
    this.u = this.g.findViewById(2131300702);
    this.w = (TextView)this.g.findViewById(2131300546);
    this.u.setOnClickListener(this);
    this.v = (TextView)this.g.findViewById(2131301182);
    this.i = new ImagePagerAdapter(this, getChildFragmentManager());
    this.n.setAdapter((PagerAdapter)this.i);
    this.n.setCurrentItem(this.k);
    this.n.setOnPageChangeListener(new ViewPager.OnPageChangeListener(this) {
          public void onPageScrollStateChanged(int param1Int) {}
          
          public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
          
          public void onPageSelected(int param1Int) {
            ShowPhotoFragment.a(this.a, param1Int);
            ShowPhotoFragment.a(this.a);
          }
        });
    this.o.setVisibility(0);
    q();
    if (this.s != null) {
      this.u.setVisibility(0);
    } else {
      this.u.setVisibility(8);
    } 
    if (this.p == 8)
      this.u.setVisibility(8); 
  }
  
  private void p() {
    if (this.p == 1 && TextUtils.equals((UserInfo.a().i()).uid, this.x) && (UserInfo.a().i()).vip_grade != 0 && !BluedPreferences.dr()) {
      this.w.setVisibility(0);
      AppInfo.n().postDelayed(new Runnable(this) {
            public void run() {
              ShowPhotoFragment.b(this.a).setVisibility(8);
              BluedPreferences.ds();
            }
          },  5000L);
    } 
  }
  
  private void q() {
    if (this.r.size() > 1) {
      TextView textView = this.v;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.k + 1);
      stringBuilder.append("/");
      stringBuilder.append(this.r.size());
      textView.setText(stringBuilder.toString());
      if (this.d) {
        this.v.setVisibility(0);
        return;
      } 
    } else {
      this.v.setVisibility(8);
    } 
  }
  
  public void a(View paramView) {
    super.a(paramView);
    l();
  }
  
  public void a(Object... paramVarArgs) {
    super.a(paramVarArgs);
    if (paramVarArgs != null && paramVarArgs.length >= 2) {
      boolean bool = true;
      if (paramVarArgs[1] != null && paramVarArgs[1] instanceof File) {
        File file = (File)paramVarArgs[1];
        ArrayList<String> arrayList = new ArrayList();
        if (TextUtils.equals((UserInfo.a().i()).uid, this.x)) {
          arrayList.add(this.f.getResources().getString(2131756150));
          EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_SET_PHOTO_PENDANT_SHOW);
        } else if (this.y != 0) {
          arrayList.add(this.f.getResources().getString(2131759217));
          PersonalProfileProtos.Event event = PersonalProfileProtos.Event.PERSONAL_LOOK_PHOTO_PENDANT_SHOW;
          String str = this.x;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(this.y);
          stringBuilder.append("");
          EventTrackPersonalProfile.a(event, str, stringBuilder.toString());
        } else {
          bool = false;
        } 
        arrayList.add(this.f.getResources().getString(2131756089));
        if (bool) {
          CommonShowBottomWindow.a((FragmentActivity)this.f, arrayList.<String>toArray(new String[arrayList.size()]), new ActionSheet.ActionSheetListener(this, file) {
                public void a(ActionSheet param1ActionSheet, int param1Int) {
                  PersonalProfileProtos.Event event;
                  String str = param1ActionSheet.a(param1Int);
                  if (str.equals(ShowPhotoFragment.f(this.b).getResources().getString(2131756150))) {
                    BluedPreferences.du();
                    EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_SET_PHOTO_PENDANT_CLICK);
                    WidgetListFragment.a(ShowPhotoFragment.f(this.b), 2, "photo_pendant_own", VipProtos.FromType.PHOTO_PENDANT_OWN);
                    return;
                  } 
                  if (str.equals(ShowPhotoFragment.f(this.b).getResources().getString(2131759217))) {
                    event = PersonalProfileProtos.Event.PERSONAL_LOOK_PHOTO_PENDANT_CLICK;
                    String str1 = ShowPhotoFragment.g(this.b);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(ShowPhotoFragment.h(this.b));
                    stringBuilder.append("");
                    EventTrackPersonalProfile.a(event, str1, stringBuilder.toString());
                    WidgetListFragment.a(ShowPhotoFragment.f(this.b), 2, "photo_pendant_other", VipProtos.FromType.PHOTO_PENDANT_OTHER);
                    return;
                  } 
                  if (event.equals(ShowPhotoFragment.f(this.b).getResources().getString(2131756089))) {
                    InstantLog.a("save_pic_click");
                    PermissionHelper.e(new PermissionCallbacks(this) {
                          public void a(String[] param2ArrayOfString) {}
                          
                          public void aa_() {
                            this.a.b.a(this.a.a, ShowPhotoFragment.i(this.a.b));
                          }
                        });
                  } 
                }
                
                public void a(ActionSheet param1ActionSheet, boolean param1Boolean) {}
              });
          return;
        } 
        String[] arrayOfString = getResources().getStringArray(2130903078);
        if (arrayOfString.length > 0) {
          ArrayList<BottomMenuPop.MenuItemInfo> arrayList1 = new ArrayList();
          BottomMenuPop.MenuItemInfo menuItemInfo = new BottomMenuPop.MenuItemInfo();
          menuItemInfo.a = arrayOfString[0];
          menuItemInfo.b = 2131100716;
          menuItemInfo.c = new View.OnClickListener(this, file) {
              public void onClick(View param1View) {
                if (ShowPhotoFragment.j(this.b) != null)
                  ShowPhotoFragment.j(this.b).p(); 
                InstantLog.a("save_pic_click");
                PermissionHelper.e(new PermissionCallbacks(this) {
                      public void a(String[] param2ArrayOfString) {}
                      
                      public void aa_() {
                        this.a.b.a(this.a.a, ShowPhotoFragment.i(this.a.b));
                      }
                    });
              }
            };
          arrayList1.add(menuItemInfo);
          this.z = new BottomMenuPop(getContext());
          this.z.b = arrayList1;
          (new XPopup.Builder(getContext())).a((BasePopupView)this.z).h();
        } 
      } 
    } 
  }
  
  public void aS_() {
    super.aS_();
    if (!this.d) {
      ImageView imageView = this.o;
      TextView textView = this.v;
      int i = this.r.size();
      boolean bool = true;
      if (i <= 1)
        bool = false; 
      b((View)imageView, (View)textView, bool);
    } 
  }
  
  public void b(View paramView) {
    super.b(paramView);
    l();
  }
  
  public void f_(int paramInt) {
    super.f_(paramInt);
    this.n.getBackground().setAlpha(paramInt);
    if (this.d) {
      ImageView imageView = this.o;
      TextView textView = this.v;
      paramInt = this.r.size();
      boolean bool = true;
      if (paramInt <= 1)
        bool = false; 
      a((View)imageView, (View)textView, bool);
    } 
  }
  
  public boolean j() {
    return false;
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296787) {
      if (i != 2131300702)
        return; 
      Context context = this.f;
      CommonAlertDialog.a(context, null, context.getResources().getString(2131756416), this.f.getResources().getString(2131756086), new DialogInterface.OnClickListener(this) {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
              if (ShowPhotoFragment.k(this.a) == 8) {
                LiveApplyDelPhotoObserver.a().b();
                this.a.l();
                return;
              } 
              String str = ((BluedAlbum)ShowPhotoFragment.e(this.a).get(ShowPhotoFragment.l(this.a))).getPid();
              param1Int = ShowPhotoFragment.k(this.a);
              if (param1Int != 3) {
                if (param1Int != 13)
                  return; 
                ShowPhotoFragment.b(this.a, str);
                return;
              } 
              ShowPhotoFragment.a(this.a, str);
            }
          }null, null, null);
      return;
    } 
    k();
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
      getActivity().postponeEnterTransition(); 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.f = (Context)getActivity();
    View view = this.g;
    if (view == null) {
      this.g = paramLayoutInflater.inflate(2131493320, paramViewGroup, false);
      n();
      o();
      p();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.g.getParent()).removeView(this.g);
    } 
    if (paramBundle != null)
      this.k = paramBundle.getInt("state_position"); 
    return this.g;
  }
  
  public void onDestroy() {
    super.onDestroy();
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {
    paramBundle.putInt("state_position", this.n.getCurrentItem());
  }
  
  class ImagePagerAdapter extends FragmentStatePagerAdapter {
    public ImagePagerAdapter(ShowPhotoFragment this$0, FragmentManager param1FragmentManager) {
      super(param1FragmentManager);
    }
    
    public int getCount() {
      return ShowPhotoFragment.e(this.a).size();
    }
    
    public Fragment getItem(int param1Int) {
      return (Fragment)BizPhotoDetailFragment.a(((BluedAlbum)ShowPhotoFragment.e(this.a).get(param1Int)).getUrl(), ShowPhotoFragment.k(this.a), ShowPhotoFragment.p(this.a));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\photo\fragment\ShowPhotoFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */