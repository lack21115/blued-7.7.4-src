package com.soft.blued.ui.feed.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.imagecache.ImageLoadEngine;
import com.blued.android.core.imagecache.MemoryRequest;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.base.shortvideo.ShortVideoProxy;
import com.blued.android.module.common.utils.DialogUtils;
import com.soft.blued.app.permission.PermissionHelper;
import com.soft.blued.constant.PhotoConstants;
import com.soft.blued.customview.PopMenu;
import com.soft.blued.customview.SelectPhotoBarView;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.common_contract.ISelectPhotoBarCallback;
import com.soft.blued.ui.feed.manager.ChildPhotoManager;
import com.soft.blued.ui.feed.manager.SelectPhotoManager;
import com.soft.blued.ui.feed.model.ChildImageInfo;
import com.soft.blued.ui.feed.model.GroupImageInfo;
import com.soft.blued.ui.live.utils.FormatUtils;
import com.soft.blued.ui.msg.util.LocalMediaLoader;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.ImageUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MsgPhotoSelectFragment extends BaseFragment implements MemoryRequest.MemoryListener, ISelectPhotoBarCallback {
  private String A;
  
  private Context d;
  
  private View e;
  
  private TextView f;
  
  private ImageView g;
  
  private View h;
  
  private TextView i;
  
  private TextView j;
  
  private SelectPhotoBarView k;
  
  private LayoutInflater l;
  
  private LinkedHashMap<String, List<ChildImageInfo>> m = new LinkedHashMap<String, List<ChildImageInfo>>();
  
  private List<GroupImageInfo> n = new ArrayList<GroupImageInfo>();
  
  private Dialog o;
  
  private GridView p;
  
  private MsgPhotoAdapter q;
  
  private PopMenu r;
  
  private PopAdapter s;
  
  private ArrayList<String> t = new ArrayList<String>();
  
  private ArrayList<Integer> u = new ArrayList<Integer>();
  
  private ArrayList<Integer> v = new ArrayList<Integer>();
  
  private boolean w = false;
  
  private int x = 0;
  
  private boolean y = false;
  
  private List<ViewHolder> z = new ArrayList<ViewHolder>();
  
  private List<GroupImageInfo> a(LinkedHashMap<String, List<ChildImageInfo>> paramLinkedHashMap) {
    if (paramLinkedHashMap == null || paramLinkedHashMap.size() == 0)
      return null; 
    ArrayList<GroupImageInfo> arrayList = new ArrayList();
    for (Map.Entry<String, List<ChildImageInfo>> entry : paramLinkedHashMap.entrySet()) {
      GroupImageInfo groupImageInfo = new GroupImageInfo();
      String str = (String)entry.getKey();
      List list = (List)entry.getValue();
      groupImageInfo.setFolderName(str);
      groupImageInfo.setImageCounts(list.size());
      if (list.size() > 0)
        groupImageInfo.setTopImagePath(((ChildImageInfo)list.get(0)).mImagePath); 
      arrayList.add(groupImageInfo);
    } 
    return arrayList;
  }
  
  private void a(ImageView paramImageView) {
    ScaleAnimation scaleAnimation1 = new ScaleAnimation(1.0F, 1.1F, 1.0F, 1.1F, 1, 0.5F, 1, 0.5F);
    scaleAnimation1.setDuration(200L);
    ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.5F, 1.1F, 0.5F, 1.1F, 1, 0.5F, 1, 0.5F);
    scaleAnimation2.setDuration(100L);
    ScaleAnimation scaleAnimation3 = new ScaleAnimation(1.1F, 1.0F, 1.1F, 1.0F, 1, 0.5F, 1, 0.5F);
    scaleAnimation3.setDuration(50L);
    scaleAnimation1.setAnimationListener(new Animation.AnimationListener(this, paramImageView, scaleAnimation2) {
          public void onAnimationEnd(Animation param1Animation) {
            this.a.setImageResource(2131233447);
            this.a.startAnimation((Animation)this.b);
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
    scaleAnimation2.setAnimationListener(new Animation.AnimationListener(this, paramImageView, scaleAnimation3) {
          public void onAnimationEnd(Animation param1Animation) {
            this.a.startAnimation((Animation)this.b);
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
    paramImageView.startAnimation((Animation)scaleAnimation1);
  }
  
  public static void a(BaseFragment paramBaseFragment, int paramInt1, boolean paramBoolean, int paramInt2) {
    PermissionHelper.e(new PermissionCallbacks(paramInt1, paramBoolean, paramBaseFragment, paramInt2) {
          public void a(String[] param1ArrayOfString) {}
          
          public void aa_() {
            Bundle bundle = new Bundle();
            bundle.putInt("select_photo", this.a);
            bundle.putBoolean("photo_from_group", this.b);
            TerminalActivity.a((Fragment)this.c, MsgPhotoSelectFragment.class, bundle, this.d);
          }
        });
  }
  
  private void a(String paramString) {
    boolean bool;
    boolean bool1 = (new File(paramString)).exists();
    int i = 0;
    if (bool1) {
      int[] arrayOfInt = ImageUtils.b(paramString);
      i = arrayOfInt[0];
      bool = arrayOfInt[1];
    } else {
      bool = false;
    } 
    this.v.add(Integer.valueOf(bool));
    this.u.add(Integer.valueOf(i));
  }
  
  private void m() {
    this.w = AppUtils.b();
    Bundle bundle = getArguments();
    if (bundle != null) {
      this.x = bundle.getInt("select_photo");
      this.y = bundle.getBoolean("photo_from_group", false);
    } 
    PhotoConstants.CONFIG.a = 9;
    SelectPhotoManager.a().d();
    q();
  }
  
  private void n() {
    this.l = LayoutInflater.from(this.d);
    this.p = (GridView)this.e.findViewById(2131297262);
    this.o = DialogUtils.a(this.d);
    this.q = new MsgPhotoAdapter(this);
    this.p.setOnScrollListener(new AbsListView.OnScrollListener(this) {
          public void onScroll(AbsListView param1AbsListView, int param1Int1, int param1Int2, int param1Int3) {}
          
          public void onScrollStateChanged(AbsListView param1AbsListView, int param1Int) {
            if (param1Int != 0) {
              if (param1Int != 1) {
                if (param1Int != 2)
                  return; 
                ImageLoadEngine.a();
                return;
              } 
              ImageLoadEngine.a();
              return;
            } 
            ImageLoadEngine.b();
          }
        });
    this.k = (SelectPhotoBarView)this.e.findViewById(2131296545);
    this.k.setOperationCallback(this);
    this.k.findViewById(2131299461).setVisibility(4);
    if (this.y) {
      this.k.b();
      return;
    } 
    this.k.c();
  }
  
  private void o() {
    ListView listView = new ListView(this.d);
    listView.setDivider(null);
    this.s = new PopAdapter(this);
    listView.setAdapter((ListAdapter)this.s);
    this.r = new PopMenu(this.d, (View)listView);
  }
  
  private void p() {
    this.h = this.e.findViewById(2131300273);
    this.i = (TextView)this.e.findViewById(2131296863);
    this.i.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            SelectPhotoManager.a().d();
            PhotosRefreshObserver.a().b();
            this.a.getActivity().finish();
          }
        });
    this.j = (TextView)this.e.findViewById(2131296867);
    this.j.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (SelectPhotoManager.a().b() > 0) {
              if (MsgPhotoSelectFragment.a(this.a)) {
                InstantLog.a("chat_preview_pic_click", Integer.valueOf(1));
              } else {
                InstantLog.a("chat_preview_pic_click", Integer.valueOf(0));
              } 
              MsgPhotoSelectFragment msgPhotoSelectFragment = this.a;
              MsgPhotoSelectedPagerFragment.a(msgPhotoSelectFragment, 0, 4, MsgPhotoSelectFragment.b(msgPhotoSelectFragment).a(), MsgPhotoSelectFragment.a(this.a));
            } 
          }
        });
    this.f = (TextView)this.e.findViewById(2131296857);
    this.g = (ImageView)this.e.findViewById(2131296860);
    this.e.findViewById(2131298004).setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            MsgPhotoSelectFragment.d(this.a).a(MsgPhotoSelectFragment.c(this.a));
            MsgPhotoSelectFragment.f(this.a).setImageDrawable(BluedSkinUtils.b(MsgPhotoSelectFragment.e(this.a), 2131233085));
          }
        });
    this.r.a(new PopupWindow.OnDismissListener(this) {
          public void onDismiss() {
            MsgPhotoSelectFragment.f(this.a).setImageDrawable(BluedSkinUtils.b(MsgPhotoSelectFragment.e(this.a), 2131233084));
          }
        });
  }
  
  private void q() {
    a(this.o);
    ThreadManager.a().a(new Runnable(this) {
          public void run() {
            if (this.a.getContext() == null)
              return; 
            MsgPhotoSelectFragment.g(this.a).clear();
            MsgPhotoSelectFragment msgPhotoSelectFragment = this.a;
            MsgPhotoSelectFragment.a(msgPhotoSelectFragment, (new LocalMediaLoader(msgPhotoSelectFragment.getContext(), 0)).a());
            msgPhotoSelectFragment = this.a;
            MsgPhotoSelectFragment.a(msgPhotoSelectFragment, MsgPhotoSelectFragment.b(msgPhotoSelectFragment, MsgPhotoSelectFragment.g(msgPhotoSelectFragment)));
            LogUtils.c("onLoadFinished subGroupOfImage end");
            AppInfo.n().post(new Runnable(this) {
                  public void run() {
                    if (MsgPhotoSelectFragment.h(this.a.a) != null && MsgPhotoSelectFragment.h(this.a.a).size() > 0) {
                      MsgPhotoSelectFragment.i(this.a.a).setText(((GroupImageInfo)MsgPhotoSelectFragment.h(this.a.a).get(0)).getFolderName());
                      ChildPhotoManager.a().a((List)MsgPhotoSelectFragment.g(this.a.a).get(((GroupImageInfo)MsgPhotoSelectFragment.h(this.a.a).get(0)).getFolderName()));
                    } 
                    MsgPhotoSelectFragment.k(this.a.a).setAdapter((ListAdapter)MsgPhotoSelectFragment.j(this.a.a));
                    if (MsgPhotoSelectFragment.l(this.a.a) != null)
                      MsgPhotoSelectFragment.l(this.a.a).notifyDataSetChanged(); 
                    this.a.a.b(MsgPhotoSelectFragment.m(this.a.a));
                  }
                });
          }
        });
  }
  
  private void r() {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void s() {
    MsgPhotoAdapter msgPhotoAdapter = this.q;
    if (msgPhotoAdapter != null)
      msgPhotoAdapter.notifyDataSetChanged(); 
    k();
  }
  
  public boolean V_() {
    getActivity().setResult(-1);
    SelectPhotoManager.a().d();
    return false;
  }
  
  public void a() {}
  
  public void a(Dialog paramDialog) {
    if (paramDialog != null && !paramDialog.isShowing())
      paramDialog.show(); 
  }
  
  public void a(boolean paramBoolean) {
    if (this.y) {
      InstantLog.a("chat_burn_pic_click", Integer.valueOf(1));
      return;
    } 
    InstantLog.a("chat_burn_pic_click", Integer.valueOf(0));
  }
  
  public void b(Dialog paramDialog) {
    if (paramDialog != null && paramDialog.isShowing())
      paramDialog.cancel(); 
  }
  
  public void d() {
    ThreadManager.a().a(new ThreadExecutor(this, "copy-file") {
          public void execute() {
            MsgPhotoSelectFragment.n(this.a);
          }
        });
  }
  
  public void e() {}
  
  protected void finalize() throws Throwable {
    super.finalize();
  }
  
  public void k() {
    int i = SelectPhotoManager.a().b();
    this.k.a(i);
    if (i == 0) {
      this.j.setTextColor(getResources().getColor(2131100541));
    } else {
      this.j.setTextColor(getResources().getColor(2131100527));
    } 
    for (ViewHolder viewHolder : this.z) {
      if (i >= PhotoConstants.CONFIG.a && !viewHolder.d) {
        viewHolder.a.setAlpha(0.5F);
        continue;
      } 
      viewHolder.a.setAlpha(1.0F);
    } 
    this.q.notifyDataSetChanged();
  }
  
  public void l() {
    LinkedHashMap<String, List<ChildImageInfo>> linkedHashMap = this.m;
    if (linkedHashMap != null && linkedHashMap.size() > 0)
      this.m.clear(); 
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramInt2 == 0) {
      s();
      return;
    } 
    boolean bool = false;
    if (paramInt1 != 1) {
      if (paramInt1 == 1000 && paramIntent != null && paramIntent.getBooleanExtra("close_page", false)) {
        paramIntent.putExtra("isVideo", true);
        getActivity().setResult(-1, paramIntent);
        getActivity().finish();
      } 
    } else if (paramIntent != null) {
      if (paramIntent.getBooleanExtra("close_page", false)) {
        paramIntent.putExtra("isVideo", true);
        getActivity().setResult(-1, paramIntent);
        getActivity().finish();
      } else {
        int i = paramIntent.getIntExtra("page_state", 0);
        int j = paramIntent.getIntExtra("photo_destroy_switch", 0);
        SelectPhotoBarView selectPhotoBarView = this.k;
        if (selectPhotoBarView != null) {
          if (j == 1)
            bool = true; 
          selectPhotoBarView.setBurnBtnChecked(bool);
        } 
        if (i == 0) {
          s();
        } else if (i == 1) {
          if (this.x != 4) {
            getActivity().finish();
          } else {
            r();
          } 
        } 
      } 
    } 
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = (Context)getActivity();
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(2131493237, paramViewGroup, false);
      m();
      o();
      p();
      n();
      k();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    if (paramBundle != null)
      this.A = paramBundle.getString("path"); 
    return this.e;
  }
  
  public void onDestroy() {
    this.z.clear();
    MemoryRequest.a().b(this);
    super.onDestroy();
  }
  
  public void onDetach() {
    l();
    super.onDetach();
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {
    paramBundle.putString("path", this.A);
    super.onSaveInstanceState(paramBundle);
  }
  
  public void onStart() {
    super.onStart();
    MemoryRequest.a().b(this);
  }
  
  public void onStop() {
    super.onStop();
    MemoryRequest.a().a(this);
  }
  
  public class MsgPhotoAdapter extends BaseAdapter {
    public MsgPhotoAdapter(MsgPhotoSelectFragment this$0) {}
    
    private void a(ChildImageInfo param1ChildImageInfo) {
      boolean bool;
      ShortVideoProxy shortVideoProxy = ShortVideoProxy.e();
      MsgPhotoSelectFragment msgPhotoSelectFragment = this.a;
      String str = param1ChildImageInfo.mImagePath;
      if (MsgPhotoSelectFragment.a(this.a)) {
        bool = true;
      } else {
        bool = true;
      } 
      shortVideoProxy.a(msgPhotoSelectFragment, str, bool, 1000);
    }
    
    public int getCount() {
      return ChildPhotoManager.a().b();
    }
    
    public Object getItem(int param1Int) {
      return Integer.valueOf(param1Int);
    }
    
    public long getItemId(int param1Int) {
      return param1Int;
    }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      MsgPhotoSelectFragment.ViewHolder viewHolder;
      if (param1View == null) {
        param1View = MsgPhotoSelectFragment.o(this.a).inflate(2131493236, param1ViewGroup, false);
        viewHolder = new MsgPhotoSelectFragment.ViewHolder(this.a);
        viewHolder.a = param1View;
        viewHolder.b = (ImageView)param1View.findViewById(2131297362);
        viewHolder.c = (ImageView)param1View.findViewById(2131299888);
        viewHolder.e = (TextView)param1View.findViewById(2131300727);
        viewHolder.f = param1View.findViewById(2131299915);
        param1View.setTag(viewHolder);
        MsgPhotoSelectFragment.p(this.a).add(viewHolder);
      } else {
        viewHolder = (MsgPhotoSelectFragment.ViewHolder)param1View.getTag();
      } 
      ChildImageInfo childImageInfo = ChildPhotoManager.a().a(param1Int);
      if (childImageInfo != null) {
        ImageWrapper imageWrapper;
        viewHolder.c.setVisibility(0);
        viewHolder.b.setVisibility(0);
        viewHolder.d = childImageInfo.mSelect;
        if (!TextUtils.isEmpty(childImageInfo.imgUri) && LocalMediaLoader.a(childImageInfo.imgUri)) {
          imageWrapper = ImageLoader.b((IRequestHost)this.a.w_(), childImageInfo.imgUri);
        } else {
          imageWrapper = ImageLoader.d((IRequestHost)this.a.w_(), childImageInfo.mImagePath);
        } 
        try {
          imageWrapper.a(2131231369).a(viewHolder.b);
        } finally {}
        if (LocalMediaLoader.MediaType.a(childImageInfo.mediaType)) {
          viewHolder.e.setVisibility(0);
          viewHolder.e.setText(FormatUtils.a(childImageInfo.duration / 1000L));
        } else {
          viewHolder.e.setVisibility(8);
        } 
        if (SelectPhotoManager.a().b() >= PhotoConstants.CONFIG.a && !childImageInfo.mSelect) {
          viewHolder.a.setAlpha(0.5F);
        } else {
          viewHolder.a.setAlpha(1.0F);
        } 
        viewHolder.b.setOnClickListener(new View.OnClickListener(this, childImageInfo, param1Int) {
              public void onClick(View param2View) {
                if (LocalMediaLoader.MediaType.b(this.a.mediaType)) {
                  MsgPhotoPagerFragment.a(this.c.a, this.b, MsgPhotoSelectFragment.q(this.c.a), MsgPhotoSelectFragment.b(this.c.a).a(), MsgPhotoSelectFragment.a(this.c.a));
                  return;
                } 
                if (SelectPhotoManager.a().b() > 0)
                  return; 
                MsgPhotoSelectFragment.MsgPhotoAdapter.a(this.c, this.a);
              }
            });
        if (LocalMediaLoader.MediaType.a(childImageInfo.mediaType)) {
          viewHolder.c.setVisibility(8);
          if (SelectPhotoManager.a().b() > 0) {
            viewHolder.f.setVisibility(0);
          } else {
            viewHolder.f.setVisibility(8);
          } 
        } else {
          viewHolder.f.setVisibility(8);
          viewHolder.c.setVisibility(0);
          if (childImageInfo.mSelect) {
            viewHolder.c.setImageResource(2131233447);
          } else {
            viewHolder.c.setImageResource(2131233448);
          } 
        } 
        viewHolder.c.setOnClickListener(new View.OnClickListener(this, childImageInfo, viewHolder) {
              public void onClick(View param2View) {
                if (this.a.mSelect) {
                  ChildImageInfo childImageInfo = this.a;
                  childImageInfo.mSelect = false;
                  this.b.d = childImageInfo.mSelect;
                  SelectPhotoManager.a().b(this.a);
                  this.b.c.setImageResource(2131233448);
                  this.c.a.k();
                  return;
                } 
                if (SelectPhotoManager.a().b() < PhotoConstants.CONFIG.a) {
                  MsgPhotoSelectFragment.a(this.c.a, this.b.c);
                  ChildImageInfo childImageInfo = this.a;
                  childImageInfo.mSelect = true;
                  this.b.d = childImageInfo.mSelect;
                  SelectPhotoManager.a().a(this.a);
                  this.c.a.k();
                  return;
                } 
                AppMethods.a(String.format(this.c.a.getResources().getString(2131757865), new Object[] { Integer.valueOf(PhotoConstants.CONFIG.a) }));
              }
            });
      } 
      return param1View;
    }
  }
  
  class null implements View.OnClickListener {
    null(MsgPhotoSelectFragment this$0, ChildImageInfo param1ChildImageInfo, int param1Int) {}
    
    public void onClick(View param1View) {
      if (LocalMediaLoader.MediaType.b(this.a.mediaType)) {
        MsgPhotoPagerFragment.a(this.c.a, this.b, MsgPhotoSelectFragment.q(this.c.a), MsgPhotoSelectFragment.b(this.c.a).a(), MsgPhotoSelectFragment.a(this.c.a));
        return;
      } 
      if (SelectPhotoManager.a().b() > 0)
        return; 
      MsgPhotoSelectFragment.MsgPhotoAdapter.a(this.c, this.a);
    }
  }
  
  class null implements View.OnClickListener {
    null(MsgPhotoSelectFragment this$0, ChildImageInfo param1ChildImageInfo, MsgPhotoSelectFragment.ViewHolder param1ViewHolder) {}
    
    public void onClick(View param1View) {
      if (this.a.mSelect) {
        ChildImageInfo childImageInfo = this.a;
        childImageInfo.mSelect = false;
        this.b.d = childImageInfo.mSelect;
        SelectPhotoManager.a().b(this.a);
        this.b.c.setImageResource(2131233448);
        this.c.a.k();
        return;
      } 
      if (SelectPhotoManager.a().b() < PhotoConstants.CONFIG.a) {
        MsgPhotoSelectFragment.a(this.c.a, this.b.c);
        ChildImageInfo childImageInfo = this.a;
        childImageInfo.mSelect = true;
        this.b.d = childImageInfo.mSelect;
        SelectPhotoManager.a().a(this.a);
        this.c.a.k();
        return;
      } 
      AppMethods.a(String.format(this.c.a.getResources().getString(2131757865), new Object[] { Integer.valueOf(PhotoConstants.CONFIG.a) }));
    }
  }
  
  public class PopAdapter extends BaseAdapter {
    public PopAdapter(MsgPhotoSelectFragment this$0) {}
    
    public int getCount() {
      return (MsgPhotoSelectFragment.h(this.a) == null) ? 0 : MsgPhotoSelectFragment.h(this.a).size();
    }
    
    public Object getItem(int param1Int) {
      return MsgPhotoSelectFragment.h(this.a).get(param1Int);
    }
    
    public long getItemId(int param1Int) {
      return param1Int;
    }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      ViewHolder viewHolder;
      if (param1View == null) {
        param1View = LayoutInflater.from(MsgPhotoSelectFragment.e(this.a)).inflate(2131493268, param1ViewGroup, false);
        viewHolder = new ViewHolder();
        param1View.setTag(viewHolder);
        viewHolder.a = (ImageView)param1View.findViewById(2131297362);
        viewHolder.b = (TextView)param1View.findViewById(2131299358);
      } else {
        viewHolder = (ViewHolder)param1View.getTag();
      } 
      GroupImageInfo groupImageInfo = MsgPhotoSelectFragment.h(this.a).get(param1Int);
      ImageLoader.d((IRequestHost)this.a.w_(), groupImageInfo.getTopImagePath()).a(2131231369).c().a(viewHolder.a);
      if (!TextUtils.isEmpty(groupImageInfo.getFolderName())) {
        viewHolder.b.setText(groupImageInfo.getFolderName());
      } else {
        viewHolder.b.setText("");
      } 
      param1View.setOnClickListener(new View.OnClickListener(this, groupImageInfo) {
            public void onClick(View param2View) {
              ChildPhotoManager.a().a((List)MsgPhotoSelectFragment.g(this.b.a).get(this.a.getFolderName()));
              MsgPhotoSelectFragment.i(this.b.a).setText(this.a.getFolderName());
              BluedPreferences.C(this.a.getFolderName());
              MsgPhotoSelectFragment.d(this.b.a).d();
              MsgPhotoSelectFragment.j(this.b.a).notifyDataSetChanged();
            }
          });
      return param1View;
    }
    
    class ViewHolder {
      ImageView a;
      
      TextView b;
      
      private ViewHolder(MsgPhotoSelectFragment.PopAdapter this$0) {}
    }
  }
  
  class null implements View.OnClickListener {
    null(MsgPhotoSelectFragment this$0, GroupImageInfo param1GroupImageInfo) {}
    
    public void onClick(View param1View) {
      ChildPhotoManager.a().a((List)MsgPhotoSelectFragment.g(this.b.a).get(this.a.getFolderName()));
      MsgPhotoSelectFragment.i(this.b.a).setText(this.a.getFolderName());
      BluedPreferences.C(this.a.getFolderName());
      MsgPhotoSelectFragment.d(this.b.a).d();
      MsgPhotoSelectFragment.j(this.b.a).notifyDataSetChanged();
    }
  }
  
  class ViewHolder {
    ImageView a;
    
    TextView b;
    
    private ViewHolder(MsgPhotoSelectFragment this$0) {}
  }
  
  public class ViewHolder {
    public View a;
    
    public ImageView b;
    
    public ImageView c;
    
    public boolean d;
    
    public TextView e;
    
    public View f;
    
    public ViewHolder(MsgPhotoSelectFragment this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\fragment\MsgPhotoSelectFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */