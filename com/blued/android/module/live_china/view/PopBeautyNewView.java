package com.blued.android.module.live_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.blued.android.module.common.view.CustomViewPager;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.manager.RecordingOnliveManager;
import com.blued.android.module.live_china.model.BeautyModel;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;

public class PopBeautyNewView {
  private LayoutInflater a;
  
  private Context b;
  
  private View c;
  
  private View d;
  
  private MyPopupWindow e;
  
  private TextView f;
  
  private SeekBar g;
  
  private LinearLayout h;
  
  private CustomViewPager i;
  
  private LiveBeautyToolBarView j;
  
  private BeautyPagerAdapter k;
  
  private RecordingOnliveFragment l;
  
  private RecordingOnliveManager m;
  
  private BeautyModel n;
  
  private BeautyAdapter o;
  
  private BeautyAdapter p;
  
  private BeautyAdapter q;
  
  private BeautyAdapter r;
  
  private List<View> s = new ArrayList<View>();
  
  private List<String> t = new ArrayList<String>();
  
  private List<BeautyModel> u = new ArrayList<BeautyModel>();
  
  private List<BeautyModel> v = new ArrayList<BeautyModel>();
  
  private List<BeautyModel> w = new ArrayList<BeautyModel>();
  
  private List<BeautyModel> x = new ArrayList<BeautyModel>();
  
  private ViewPager.OnPageChangeListener y = new ViewPager.OnPageChangeListener(this) {
      public void onPageScrollStateChanged(int param1Int) {}
      
      public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
      
      public void onPageSelected(int param1Int) {
        PopBeautyNewView.r(this.a).setToolBtnSelect(param1Int);
        PopBeautyNewView popBeautyNewView = this.a;
        PopBeautyNewView.a(popBeautyNewView, PopBeautyNewView.c(popBeautyNewView, param1Int));
        if (PopBeautyNewView.b(this.a) != null) {
          popBeautyNewView = this.a;
          PopBeautyNewView.a(popBeautyNewView, (PopBeautyNewView.b(popBeautyNewView)).progress);
          if ((PopBeautyNewView.b(this.a)).isFilter) {
            popBeautyNewView = this.a;
            if (PopBeautyNewView.a(popBeautyNewView, (PopBeautyNewView.b(popBeautyNewView)).id)) {
              PopBeautyNewView.p(this.a);
              return;
            } 
          } 
          PopBeautyNewView.q(this.a);
        } 
      }
    };
  
  public PopBeautyNewView(RecordingOnliveFragment paramRecordingOnliveFragment, RecordingOnliveManager paramRecordingOnliveManager) {
    this.m = paramRecordingOnliveManager;
    this.l = paramRecordingOnliveFragment;
    this.b = paramRecordingOnliveFragment.getContext();
    c();
    f();
  }
  
  private boolean a(String paramString) {
    return TextUtils.equals(this.n.id, "filter_none");
  }
  
  private void b(int paramInt) {
    BeautyModel beautyModel = this.n;
    if (beautyModel != null) {
      if (TextUtils.equals(beautyModel.id, "white")) {
        LiveRoomPreferences.a(this.n.id, paramInt);
        return;
      } 
      if (TextUtils.equals(this.n.id, "ruddy")) {
        LiveRoomPreferences.b(this.n.id, paramInt);
        return;
      } 
      if (TextUtils.equals(this.n.id, "grinding")) {
        LiveRoomPreferences.c(this.n.id, paramInt);
        return;
      } 
      if (TextUtils.equals(this.n.id, "highlight")) {
        LiveRoomPreferences.d(this.n.id, paramInt);
        return;
      } 
      if (TextUtils.equals(this.n.id, "face_1")) {
        LiveRoomPreferences.e(this.n.id, paramInt);
        return;
      } 
      if (TextUtils.equals(this.n.id, "face_2")) {
        LiveRoomPreferences.f(this.n.id, paramInt);
        return;
      } 
      if (TextUtils.equals(this.n.id, "face_3")) {
        LiveRoomPreferences.g(this.n.id, paramInt);
        return;
      } 
      if (TextUtils.equals(this.n.id, "face_4")) {
        LiveRoomPreferences.h(this.n.id, paramInt);
        return;
      } 
      if (TextUtils.equals(this.n.id, "face_5")) {
        LiveRoomPreferences.i(this.n.id, paramInt);
        return;
      } 
      if (TextUtils.equals(this.n.id, "face_6")) {
        LiveRoomPreferences.j(this.n.id, paramInt);
        return;
      } 
      if (TextUtils.equals(this.n.id, "face_7")) {
        LiveRoomPreferences.k(this.n.id, paramInt);
        return;
      } 
      if (TextUtils.equals(this.n.id, "face_8")) {
        LiveRoomPreferences.l(this.n.id, paramInt);
        return;
      } 
      if (TextUtils.equals(this.n.id, "contrast")) {
        LiveRoomPreferences.m(this.n.id, paramInt);
        return;
      } 
      if (TextUtils.equals(this.n.id, "saturation")) {
        LiveRoomPreferences.n(this.n.id, paramInt);
        return;
      } 
      if (TextUtils.equals(this.n.id, "filter_ruby")) {
        LiveRoomPreferences.o(this.n.id, paramInt);
        return;
      } 
      if (TextUtils.equals(this.n.id, "filter_pansy")) {
        LiveRoomPreferences.p(this.n.id, paramInt);
        return;
      } 
      if (TextUtils.equals(this.n.id, "filter_morden")) {
        LiveRoomPreferences.q(this.n.id, paramInt);
        return;
      } 
      if (TextUtils.equals(this.n.id, "filter_city")) {
        LiveRoomPreferences.r(this.n.id, paramInt);
        return;
      } 
      if (TextUtils.equals(this.n.id, "filter_babypink"))
        LiveRoomPreferences.s(this.n.id, paramInt); 
    } 
  }
  
  private void c(int paramInt) {
    TextView textView = this.f;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("%");
    textView.setText(stringBuilder.toString());
    this.g.setProgress(paramInt);
  }
  
  private BeautyModel d(int paramInt) {
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt != 2) {
          if (paramInt == 3) {
            BeautyAdapter beautyAdapter = this.r;
            if (beautyAdapter != null)
              for (BeautyModel beautyModel : beautyAdapter.n()) {
                if (beautyModel.isSelect)
                  return beautyModel; 
              }  
          } 
        } else {
          BeautyAdapter beautyAdapter = this.q;
          if (beautyAdapter != null)
            for (BeautyModel beautyModel : beautyAdapter.n()) {
              if (beautyModel.isSelect)
                return beautyModel; 
            }  
        } 
      } else {
        BeautyAdapter beautyAdapter = this.p;
        if (beautyAdapter != null)
          for (BeautyModel beautyModel : beautyAdapter.n()) {
            if (beautyModel.isSelect)
              return beautyModel; 
          }  
      } 
    } else {
      BeautyAdapter beautyAdapter = this.o;
      if (beautyAdapter != null)
        for (BeautyModel beautyModel : beautyAdapter.n()) {
          if (beautyModel.isSelect)
            return beautyModel; 
        }  
    } 
    return null;
  }
  
  private void f() {
    this.a = LayoutInflater.from(this.b);
    View view = this.a.inflate(R.layout.pop_window_beauty_new, null);
    this.c = view.findViewById(R.id.tv_bg);
    this.c.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.b();
          }
        });
    this.d = view.findViewById(R.id.ll_content);
    this.d.setVisibility(8);
    this.d.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {}
        });
    this.f = (TextView)view.findViewById(R.id.live_beauty_progress);
    this.g = (SeekBar)view.findViewById(R.id.filter_seekbar);
    this.h = (LinearLayout)view.findViewById(R.id.live_beauty_reset_btn);
    this.i = (CustomViewPager)view.findViewById(R.id.live_beauty_viewpager);
    this.j = (LiveBeautyToolBarView)view.findViewById(R.id.live_beauty_tool_bar);
    this.i.setOnPageChangeListener(this.y);
    this.j.setOnToolBarItemClickListener(new LiveBeautyToolBarView.OnToolBarItemClickListener(this) {
          public void a(int param1Int) {
            PopBeautyNewView.a(this.a).setCurrentItem(param1Int);
          }
        });
    this.g.setMax(100);
    this.g.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(this) {
          public void onProgressChanged(SeekBar param1SeekBar, int param1Int, boolean param1Boolean) {
            if (PopBeautyNewView.b(this.a) != null) {
              if ((PopBeautyNewView.b(this.a)).isFilter) {
                this.a.a(param1Int);
              } else if (TextUtils.equals((PopBeautyNewView.b(this.a)).id, "face_6") || TextUtils.equals((PopBeautyNewView.b(this.a)).id, "face_7")) {
                PopBeautyNewView.c(this.a).a((PopBeautyNewView.b(this.a)).beautifyKey, (float)(((param1Int - 50) * 2) * 0.01D));
              } else {
                PopBeautyNewView.c(this.a).a((PopBeautyNewView.b(this.a)).beautifyKey, (float)(param1Int * 0.01D));
              } 
              PopBeautyNewView.a(this.a, param1Int);
              (PopBeautyNewView.b(this.a)).progress = param1Int;
            } 
          }
          
          public void onStartTrackingTouch(SeekBar param1SeekBar) {}
          
          public void onStopTrackingTouch(SeekBar param1SeekBar) {
            int i = param1SeekBar.getProgress();
            PopBeautyNewView.b(this.a, i);
          }
        });
    this.k = new BeautyPagerAdapter(this);
    this.i.setAdapter(this.k);
    BeautyModel beautyModel = this.n;
    if (beautyModel != null)
      c(beautyModel.progress); 
    this.h.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            // Byte code:
            //   0: aload_0
            //   1: getfield a : Lcom/blued/android/module/live_china/view/PopBeautyNewView;
            //   4: invokestatic b : (Lcom/blued/android/module/live_china/view/PopBeautyNewView;)Lcom/blued/android/module/live_china/model/BeautyModel;
            //   7: ifnull -> 308
            //   10: iconst_0
            //   11: istore_2
            //   12: aload_0
            //   13: getfield a : Lcom/blued/android/module/live_china/view/PopBeautyNewView;
            //   16: invokestatic b : (Lcom/blued/android/module/live_china/view/PopBeautyNewView;)Lcom/blued/android/module/live_china/model/BeautyModel;
            //   19: getfield isFilter : Z
            //   22: ifeq -> 40
            //   25: bipush #60
            //   27: istore_2
            //   28: aload_0
            //   29: getfield a : Lcom/blued/android/module/live_china/view/PopBeautyNewView;
            //   32: bipush #60
            //   34: invokevirtual a : (I)V
            //   37: goto -> 281
            //   40: aload_0
            //   41: getfield a : Lcom/blued/android/module/live_china/view/PopBeautyNewView;
            //   44: invokestatic b : (Lcom/blued/android/module/live_china/view/PopBeautyNewView;)Lcom/blued/android/module/live_china/model/BeautyModel;
            //   47: getfield id : Ljava/lang/String;
            //   50: ldc 'white'
            //   52: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
            //   55: ifeq -> 63
            //   58: iconst_5
            //   59: istore_2
            //   60: goto -> 180
            //   63: aload_0
            //   64: getfield a : Lcom/blued/android/module/live_china/view/PopBeautyNewView;
            //   67: invokestatic b : (Lcom/blued/android/module/live_china/view/PopBeautyNewView;)Lcom/blued/android/module/live_china/model/BeautyModel;
            //   70: getfield id : Ljava/lang/String;
            //   73: ldc 'ruddy'
            //   75: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
            //   78: ifeq -> 87
            //   81: bipush #40
            //   83: istore_2
            //   84: goto -> 180
            //   87: aload_0
            //   88: getfield a : Lcom/blued/android/module/live_china/view/PopBeautyNewView;
            //   91: invokestatic b : (Lcom/blued/android/module/live_china/view/PopBeautyNewView;)Lcom/blued/android/module/live_china/model/BeautyModel;
            //   94: getfield id : Ljava/lang/String;
            //   97: ldc 'grinding'
            //   99: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
            //   102: ifeq -> 111
            //   105: bipush #75
            //   107: istore_2
            //   108: goto -> 180
            //   111: aload_0
            //   112: getfield a : Lcom/blued/android/module/live_china/view/PopBeautyNewView;
            //   115: invokestatic b : (Lcom/blued/android/module/live_china/view/PopBeautyNewView;)Lcom/blued/android/module/live_china/model/BeautyModel;
            //   118: getfield id : Ljava/lang/String;
            //   121: ldc 'face_1'
            //   123: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
            //   126: ifeq -> 135
            //   129: bipush #10
            //   131: istore_2
            //   132: goto -> 180
            //   135: aload_0
            //   136: getfield a : Lcom/blued/android/module/live_china/view/PopBeautyNewView;
            //   139: invokestatic b : (Lcom/blued/android/module/live_china/view/PopBeautyNewView;)Lcom/blued/android/module/live_china/model/BeautyModel;
            //   142: getfield id : Ljava/lang/String;
            //   145: ldc 'face_2'
            //   147: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
            //   150: ifeq -> 159
            //   153: bipush #15
            //   155: istore_2
            //   156: goto -> 180
            //   159: aload_0
            //   160: getfield a : Lcom/blued/android/module/live_china/view/PopBeautyNewView;
            //   163: invokestatic b : (Lcom/blued/android/module/live_china/view/PopBeautyNewView;)Lcom/blued/android/module/live_china/model/BeautyModel;
            //   166: getfield id : Ljava/lang/String;
            //   169: ldc 'face_3'
            //   171: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
            //   174: ifeq -> 180
            //   177: goto -> 129
            //   180: aload_0
            //   181: getfield a : Lcom/blued/android/module/live_china/view/PopBeautyNewView;
            //   184: invokestatic b : (Lcom/blued/android/module/live_china/view/PopBeautyNewView;)Lcom/blued/android/module/live_china/model/BeautyModel;
            //   187: getfield id : Ljava/lang/String;
            //   190: ldc 'face_6'
            //   192: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
            //   195: ifne -> 249
            //   198: aload_0
            //   199: getfield a : Lcom/blued/android/module/live_china/view/PopBeautyNewView;
            //   202: invokestatic b : (Lcom/blued/android/module/live_china/view/PopBeautyNewView;)Lcom/blued/android/module/live_china/model/BeautyModel;
            //   205: getfield id : Ljava/lang/String;
            //   208: ldc 'face_7'
            //   210: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
            //   213: ifeq -> 219
            //   216: goto -> 249
            //   219: aload_0
            //   220: getfield a : Lcom/blued/android/module/live_china/view/PopBeautyNewView;
            //   223: invokestatic c : (Lcom/blued/android/module/live_china/view/PopBeautyNewView;)Lcom/blued/android/module/live_china/manager/RecordingOnliveManager;
            //   226: aload_0
            //   227: getfield a : Lcom/blued/android/module/live_china/view/PopBeautyNewView;
            //   230: invokestatic b : (Lcom/blued/android/module/live_china/view/PopBeautyNewView;)Lcom/blued/android/module/live_china/model/BeautyModel;
            //   233: getfield beautifyKey : Lcom/blued/android/module/external_sense_library/config/BluedBeautifyKey$KEY;
            //   236: iload_2
            //   237: i2d
            //   238: ldc2_w 0.01
            //   241: dmul
            //   242: d2f
            //   243: invokevirtual a : (Lcom/blued/android/module/external_sense_library/config/BluedBeautifyKey$KEY;F)V
            //   246: goto -> 281
            //   249: aload_0
            //   250: getfield a : Lcom/blued/android/module/live_china/view/PopBeautyNewView;
            //   253: invokestatic c : (Lcom/blued/android/module/live_china/view/PopBeautyNewView;)Lcom/blued/android/module/live_china/manager/RecordingOnliveManager;
            //   256: aload_0
            //   257: getfield a : Lcom/blued/android/module/live_china/view/PopBeautyNewView;
            //   260: invokestatic b : (Lcom/blued/android/module/live_china/view/PopBeautyNewView;)Lcom/blued/android/module/live_china/model/BeautyModel;
            //   263: getfield beautifyKey : Lcom/blued/android/module/external_sense_library/config/BluedBeautifyKey$KEY;
            //   266: iload_2
            //   267: bipush #50
            //   269: isub
            //   270: iconst_2
            //   271: imul
            //   272: i2d
            //   273: ldc2_w 0.01
            //   276: dmul
            //   277: d2f
            //   278: invokevirtual a : (Lcom/blued/android/module/external_sense_library/config/BluedBeautifyKey$KEY;F)V
            //   281: aload_0
            //   282: getfield a : Lcom/blued/android/module/live_china/view/PopBeautyNewView;
            //   285: iload_2
            //   286: invokestatic a : (Lcom/blued/android/module/live_china/view/PopBeautyNewView;I)V
            //   289: aload_0
            //   290: getfield a : Lcom/blued/android/module/live_china/view/PopBeautyNewView;
            //   293: iload_2
            //   294: invokestatic b : (Lcom/blued/android/module/live_china/view/PopBeautyNewView;I)V
            //   297: aload_0
            //   298: getfield a : Lcom/blued/android/module/live_china/view/PopBeautyNewView;
            //   301: invokestatic b : (Lcom/blued/android/module/live_china/view/PopBeautyNewView;)Lcom/blued/android/module/live_china/model/BeautyModel;
            //   304: iload_2
            //   305: putfield progress : I
            //   308: return
          }
        });
    this.e = new MyPopupWindow(this, view, -1, -1, true);
    this.e.setBackgroundDrawable(this.b.getResources().getDrawable(17170445));
    this.e.setTouchable(true);
    this.e.setOutsideTouchable(true);
    this.e.setFocusable(true);
    this.e.update();
  }
  
  private void g() {
    this.f.setVisibility(0);
    this.g.setVisibility(0);
    this.h.setVisibility(0);
  }
  
  private void h() {
    this.f.setVisibility(8);
    this.g.setVisibility(8);
    this.h.setVisibility(8);
  }
  
  public void a() {
    RecordingOnliveFragment recordingOnliveFragment = this.l;
    if (recordingOnliveFragment != null)
      recordingOnliveFragment.Q(); 
    this.c.clearAnimation();
    this.d.clearAnimation();
    if (this.e.isShowing())
      this.e.a(); 
    this.e.showAtLocation(this.d, 81, 0, 0);
    this.d.setVisibility(0);
    this.d.startAnimation(AnimationUtils.loadAnimation(this.b, R.anim.push_bottom_in));
  }
  
  public void a(int paramInt) {
    this.m.a((float)(paramInt * 0.01D));
  }
  
  public void b() {
    RecordingOnliveFragment recordingOnliveFragment = this.l;
    if (recordingOnliveFragment != null)
      recordingOnliveFragment.R(); 
    this.d.setVisibility(8);
    this.d.startAnimation(AnimationUtils.loadAnimation(this.b, R.anim.push_bottom_out));
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            PopBeautyNewView.d(this.a).a();
          }
        },  300L);
  }
  
  public void c() {
    // Byte code:
    //   0: aload_0
    //   1: getfield t : Ljava/util/List;
    //   4: invokeinterface clear : ()V
    //   9: aload_0
    //   10: getfield u : Ljava/util/List;
    //   13: invokeinterface clear : ()V
    //   18: aload_0
    //   19: getfield v : Ljava/util/List;
    //   22: invokeinterface clear : ()V
    //   27: aload_0
    //   28: getfield w : Ljava/util/List;
    //   31: invokeinterface clear : ()V
    //   36: aload_0
    //   37: getfield x : Ljava/util/List;
    //   40: invokeinterface clear : ()V
    //   45: aload_0
    //   46: getfield b : Landroid/content/Context;
    //   49: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   52: getstatic com/blued/android/module/live_china/R$array.live_beauty_title : I
    //   55: invokevirtual getStringArray : (I)[Ljava/lang/String;
    //   58: astore #6
    //   60: aload_0
    //   61: getfield b : Landroid/content/Context;
    //   64: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   67: getstatic com/blued/android/module/live_china/R$array.live_beauty_skin : I
    //   70: invokevirtual getStringArray : (I)[Ljava/lang/String;
    //   73: astore #13
    //   75: aload_0
    //   76: getfield b : Landroid/content/Context;
    //   79: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   82: getstatic com/blued/android/module/live_china/R$array.live_beauty_face : I
    //   85: invokevirtual getStringArray : (I)[Ljava/lang/String;
    //   88: astore #12
    //   90: invokestatic getInstance : ()Lcom/blued/android/module/external_sense_library/manager/FilterDataManager;
    //   93: invokevirtual getFilters : ()Ljava/util/List;
    //   96: pop
    //   97: aload_0
    //   98: getfield b : Landroid/content/Context;
    //   101: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   104: getstatic com/blued/android/module/live_china/R$array.live_beauty_filter : I
    //   107: invokevirtual getStringArray : (I)[Ljava/lang/String;
    //   110: astore #11
    //   112: aload_0
    //   113: getfield b : Landroid/content/Context;
    //   116: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   119: getstatic com/blued/android/module/live_china/R$array.live_beauty_frame : I
    //   122: invokevirtual getStringArray : (I)[Ljava/lang/String;
    //   125: astore #10
    //   127: aload #6
    //   129: arraylength
    //   130: istore_2
    //   131: iconst_0
    //   132: istore_1
    //   133: iload_1
    //   134: iload_2
    //   135: if_icmpge -> 163
    //   138: aload #6
    //   140: iload_1
    //   141: aaload
    //   142: astore #7
    //   144: aload_0
    //   145: getfield t : Ljava/util/List;
    //   148: aload #7
    //   150: invokeinterface add : (Ljava/lang/Object;)Z
    //   155: pop
    //   156: iload_1
    //   157: iconst_1
    //   158: iadd
    //   159: istore_1
    //   160: goto -> 133
    //   163: iconst_0
    //   164: istore_3
    //   165: iload_3
    //   166: aload #13
    //   168: arraylength
    //   169: if_icmpge -> 422
    //   172: iload_3
    //   173: ifne -> 182
    //   176: iconst_1
    //   177: istore #5
    //   179: goto -> 185
    //   182: iconst_0
    //   183: istore #5
    //   185: iload_3
    //   186: ifeq -> 308
    //   189: iload_3
    //   190: iconst_1
    //   191: if_icmpeq -> 281
    //   194: iload_3
    //   195: iconst_2
    //   196: if_icmpeq -> 254
    //   199: iload_3
    //   200: iconst_3
    //   201: if_icmpeq -> 227
    //   204: ldc_w ''
    //   207: astore #6
    //   209: aload #6
    //   211: astore #7
    //   213: iconst_0
    //   214: istore_1
    //   215: iconst_0
    //   216: istore_2
    //   217: aconst_null
    //   218: astore #8
    //   220: aload #7
    //   222: astore #9
    //   224: goto -> 340
    //   227: getstatic com/blued/android/module/external_sense_library/config/BluedBeautifyKey$KEY.ST_BEAUTIFY_DEHIGHLIGHT_STRENGTH : Lcom/blued/android/module/external_sense_library/config/BluedBeautifyKey$KEY;
    //   230: astore #7
    //   232: ldc 'highlight'
    //   234: astore #8
    //   236: getstatic com/blued/android/module/live_china/R$drawable.live_beauty_hightlight : I
    //   239: istore_1
    //   240: ldc 'highlight'
    //   242: invokestatic h : (Ljava/lang/String;)I
    //   245: istore_2
    //   246: ldc_w 'Matte'
    //   249: astore #6
    //   251: goto -> 332
    //   254: getstatic com/blued/android/module/external_sense_library/config/BluedBeautifyKey$KEY.ST_BEAUTIFY_SMOOTH_STRENGTH : Lcom/blued/android/module/external_sense_library/config/BluedBeautifyKey$KEY;
    //   257: astore #7
    //   259: ldc 'grinding'
    //   261: astore #8
    //   263: getstatic com/blued/android/module/live_china/R$drawable.live_beauty_grinding : I
    //   266: istore_1
    //   267: ldc 'grinding'
    //   269: invokestatic g : (Ljava/lang/String;)I
    //   272: istore_2
    //   273: ldc_w 'Smooth'
    //   276: astore #6
    //   278: goto -> 332
    //   281: getstatic com/blued/android/module/external_sense_library/config/BluedBeautifyKey$KEY.ST_BEAUTIFY_REDDEN_STRENGTH : Lcom/blued/android/module/external_sense_library/config/BluedBeautifyKey$KEY;
    //   284: astore #7
    //   286: ldc 'ruddy'
    //   288: astore #8
    //   290: getstatic com/blued/android/module/live_china/R$drawable.live_beauty_ruddy : I
    //   293: istore_1
    //   294: ldc 'ruddy'
    //   296: invokestatic f : (Ljava/lang/String;)I
    //   299: istore_2
    //   300: ldc_w 'Ruddy'
    //   303: astore #6
    //   305: goto -> 332
    //   308: getstatic com/blued/android/module/external_sense_library/config/BluedBeautifyKey$KEY.ST_BEAUTIFY_WHITEN_STRENGTH : Lcom/blued/android/module/external_sense_library/config/BluedBeautifyKey$KEY;
    //   311: astore #7
    //   313: ldc 'white'
    //   315: astore #8
    //   317: getstatic com/blued/android/module/live_china/R$drawable.live_beauty_white : I
    //   320: istore_1
    //   321: ldc 'white'
    //   323: invokestatic e : (Ljava/lang/String;)I
    //   326: istore_2
    //   327: ldc_w 'Skin'
    //   330: astore #6
    //   332: aload #8
    //   334: astore #9
    //   336: aload #7
    //   338: astore #8
    //   340: new com/blued/android/module/live_china/model/BeautyModel
    //   343: dup
    //   344: aload #8
    //   346: aload #9
    //   348: aload #13
    //   350: iload_3
    //   351: aaload
    //   352: iconst_0
    //   353: iload #5
    //   355: iload_2
    //   356: invokespecial <init> : (Lcom/blued/android/module/external_sense_library/config/BluedBeautifyKey$KEY;Ljava/lang/String;Ljava/lang/String;IZI)V
    //   359: astore #7
    //   361: aload #7
    //   363: iload_1
    //   364: putfield resource : I
    //   367: aload #7
    //   369: aload #6
    //   371: putfield eventName : Ljava/lang/String;
    //   374: iload_3
    //   375: ifne -> 384
    //   378: aload_0
    //   379: aload #7
    //   381: putfield n : Lcom/blued/android/module/live_china/model/BeautyModel;
    //   384: aload_0
    //   385: getfield u : Ljava/util/List;
    //   388: aload #7
    //   390: invokeinterface add : (Ljava/lang/Object;)Z
    //   395: pop
    //   396: aload_0
    //   397: getfield m : Lcom/blued/android/module/live_china/manager/RecordingOnliveManager;
    //   400: aload #7
    //   402: getfield beautifyKey : Lcom/blued/android/module/external_sense_library/config/BluedBeautifyKey$KEY;
    //   405: iload_2
    //   406: i2d
    //   407: ldc2_w 0.01
    //   410: dmul
    //   411: d2f
    //   412: invokevirtual a : (Lcom/blued/android/module/external_sense_library/config/BluedBeautifyKey$KEY;F)V
    //   415: iload_3
    //   416: iconst_1
    //   417: iadd
    //   418: istore_3
    //   419: goto -> 165
    //   422: iconst_0
    //   423: istore #4
    //   425: iload #4
    //   427: aload #12
    //   429: arraylength
    //   430: if_icmpge -> 888
    //   433: iload #4
    //   435: ifne -> 444
    //   438: iconst_1
    //   439: istore #5
    //   441: goto -> 447
    //   444: iconst_0
    //   445: istore #5
    //   447: iload #4
    //   449: tableswitch default -> 496, 0 -> 701, 1 -> 674, 2 -> 647, 3 -> 620, 4 -> 591, 5 -> 564, 6 -> 537, 7 -> 515
    //   496: ldc_w ''
    //   499: astore #6
    //   501: aload #6
    //   503: astore #8
    //   505: iconst_0
    //   506: istore_1
    //   507: iconst_0
    //   508: istore_2
    //   509: aconst_null
    //   510: astore #7
    //   512: goto -> 757
    //   515: getstatic com/blued/android/module/external_sense_library/config/BluedBeautifyKey$KEY.ST_BEAUTIFY_3D_APPLE_MUSLE_RATIO : Lcom/blued/android/module/external_sense_library/config/BluedBeautifyKey$KEY;
    //   518: astore #8
    //   520: ldc 'face_8'
    //   522: astore #7
    //   524: getstatic com/blued/android/module/live_china/R$drawable.live_beauty_face8 : I
    //   527: istore_2
    //   528: ldc 'face_8'
    //   530: invokestatic p : (Ljava/lang/String;)I
    //   533: istore_1
    //   534: goto -> 610
    //   537: getstatic com/blued/android/module/external_sense_library/config/BluedBeautifyKey$KEY.ST_BEAUTIFY_3D_HAIRLINE_HEIGHT_RATIO : Lcom/blued/android/module/external_sense_library/config/BluedBeautifyKey$KEY;
    //   540: astore #7
    //   542: getstatic com/blued/android/module/live_china/R$drawable.live_beauty_face7 : I
    //   545: istore_1
    //   546: ldc 'face_7'
    //   548: invokestatic o : (Ljava/lang/String;)I
    //   551: istore_2
    //   552: ldc_w ''
    //   555: astore #6
    //   557: ldc 'face_7'
    //   559: astore #8
    //   561: goto -> 757
    //   564: getstatic com/blued/android/module/external_sense_library/config/BluedBeautifyKey$KEY.ST_BEAUTIFY_3D_CHIN_LENGTH_RATIO : Lcom/blued/android/module/external_sense_library/config/BluedBeautifyKey$KEY;
    //   567: astore #7
    //   569: getstatic com/blued/android/module/live_china/R$drawable.live_beauty_face6 : I
    //   572: istore_1
    //   573: ldc 'face_6'
    //   575: invokestatic n : (Ljava/lang/String;)I
    //   578: istore_2
    //   579: ldc_w ''
    //   582: astore #6
    //   584: ldc 'face_6'
    //   586: astore #8
    //   588: goto -> 757
    //   591: getstatic com/blued/android/module/external_sense_library/config/BluedBeautifyKey$KEY.ST_BEAUTIFY_SHRINK_FACE_RATIO : Lcom/blued/android/module/external_sense_library/config/BluedBeautifyKey$KEY;
    //   594: astore #8
    //   596: ldc 'face_5'
    //   598: astore #7
    //   600: getstatic com/blued/android/module/live_china/R$drawable.live_beauty_face5 : I
    //   603: istore_2
    //   604: ldc 'face_5'
    //   606: invokestatic m : (Ljava/lang/String;)I
    //   609: istore_1
    //   610: ldc_w ''
    //   613: astore #6
    //   615: iload_2
    //   616: istore_3
    //   617: goto -> 741
    //   620: getstatic com/blued/android/module/external_sense_library/config/BluedBeautifyKey$KEY.ST_BEAUTIFY_NARROW_FACE_STRENGTH : Lcom/blued/android/module/external_sense_library/config/BluedBeautifyKey$KEY;
    //   623: astore #6
    //   625: ldc 'face_4'
    //   627: astore #7
    //   629: getstatic com/blued/android/module/live_china/R$drawable.live_beauty_face4 : I
    //   632: istore_1
    //   633: ldc 'face_4'
    //   635: invokestatic l : (Ljava/lang/String;)I
    //   638: istore_2
    //   639: ldc_w 'Face width'
    //   642: astore #8
    //   644: goto -> 725
    //   647: getstatic com/blued/android/module/external_sense_library/config/BluedBeautifyKey$KEY.ST_BEAUTIFY_SHRINK_JAW_RATIO : Lcom/blued/android/module/external_sense_library/config/BluedBeautifyKey$KEY;
    //   650: astore #6
    //   652: ldc 'face_3'
    //   654: astore #7
    //   656: getstatic com/blued/android/module/live_china/R$drawable.live_beauty_face3 : I
    //   659: istore_1
    //   660: ldc 'face_3'
    //   662: invokestatic k : (Ljava/lang/String;)I
    //   665: istore_2
    //   666: ldc_w 'Face Length'
    //   669: astore #8
    //   671: goto -> 725
    //   674: getstatic com/blued/android/module/external_sense_library/config/BluedBeautifyKey$KEY.ST_BEAUTIFY_ENLARGE_EYE_RATIO : Lcom/blued/android/module/external_sense_library/config/BluedBeautifyKey$KEY;
    //   677: astore #6
    //   679: ldc 'face_2'
    //   681: astore #7
    //   683: getstatic com/blued/android/module/live_china/R$drawable.live_beauty_face2 : I
    //   686: istore_1
    //   687: ldc 'face_2'
    //   689: invokestatic j : (Ljava/lang/String;)I
    //   692: istore_2
    //   693: ldc_w 'Enlarge'
    //   696: astore #8
    //   698: goto -> 725
    //   701: getstatic com/blued/android/module/external_sense_library/config/BluedBeautifyKey$KEY.ST_BEAUTIFY_SHRINK_FACE_RATIO : Lcom/blued/android/module/external_sense_library/config/BluedBeautifyKey$KEY;
    //   704: astore #6
    //   706: ldc 'face_1'
    //   708: astore #7
    //   710: getstatic com/blued/android/module/live_china/R$drawable.live_beauty_face1 : I
    //   713: istore_1
    //   714: ldc 'face_1'
    //   716: invokestatic i : (Ljava/lang/String;)I
    //   719: istore_2
    //   720: ldc_w 'Slim'
    //   723: astore #8
    //   725: iload_1
    //   726: istore_3
    //   727: aload #8
    //   729: astore #9
    //   731: iload_2
    //   732: istore_1
    //   733: aload #6
    //   735: astore #8
    //   737: aload #9
    //   739: astore #6
    //   741: aload #8
    //   743: astore #9
    //   745: aload #7
    //   747: astore #8
    //   749: aload #9
    //   751: astore #7
    //   753: iload_1
    //   754: istore_2
    //   755: iload_3
    //   756: istore_1
    //   757: new com/blued/android/module/live_china/model/BeautyModel
    //   760: dup
    //   761: aload #7
    //   763: aload #8
    //   765: aload #12
    //   767: iload #4
    //   769: aaload
    //   770: iconst_0
    //   771: iload #5
    //   773: iload_2
    //   774: invokespecial <init> : (Lcom/blued/android/module/external_sense_library/config/BluedBeautifyKey$KEY;Ljava/lang/String;Ljava/lang/String;IZI)V
    //   777: astore #7
    //   779: aload #7
    //   781: iload_1
    //   782: putfield resource : I
    //   785: aload #7
    //   787: aload #6
    //   789: putfield eventName : Ljava/lang/String;
    //   792: aload_0
    //   793: getfield v : Ljava/util/List;
    //   796: aload #7
    //   798: invokeinterface add : (Ljava/lang/Object;)Z
    //   803: pop
    //   804: aload #7
    //   806: getfield id : Ljava/lang/String;
    //   809: ldc 'face_6'
    //   811: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   814: ifne -> 855
    //   817: aload #7
    //   819: getfield id : Ljava/lang/String;
    //   822: ldc 'face_7'
    //   824: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   827: ifeq -> 833
    //   830: goto -> 855
    //   833: aload_0
    //   834: getfield m : Lcom/blued/android/module/live_china/manager/RecordingOnliveManager;
    //   837: aload #7
    //   839: getfield beautifyKey : Lcom/blued/android/module/external_sense_library/config/BluedBeautifyKey$KEY;
    //   842: iload_2
    //   843: i2d
    //   844: ldc2_w 0.01
    //   847: dmul
    //   848: d2f
    //   849: invokevirtual a : (Lcom/blued/android/module/external_sense_library/config/BluedBeautifyKey$KEY;F)V
    //   852: goto -> 879
    //   855: aload_0
    //   856: getfield m : Lcom/blued/android/module/live_china/manager/RecordingOnliveManager;
    //   859: aload #7
    //   861: getfield beautifyKey : Lcom/blued/android/module/external_sense_library/config/BluedBeautifyKey$KEY;
    //   864: iload_2
    //   865: bipush #50
    //   867: isub
    //   868: iconst_2
    //   869: imul
    //   870: i2d
    //   871: ldc2_w 0.01
    //   874: dmul
    //   875: d2f
    //   876: invokevirtual a : (Lcom/blued/android/module/external_sense_library/config/BluedBeautifyKey$KEY;F)V
    //   879: iload #4
    //   881: iconst_1
    //   882: iadd
    //   883: istore #4
    //   885: goto -> 425
    //   888: iconst_0
    //   889: istore_3
    //   890: iload_3
    //   891: aload #11
    //   893: arraylength
    //   894: if_icmpge -> 1164
    //   897: iload_3
    //   898: ifeq -> 1080
    //   901: iload_3
    //   902: iconst_1
    //   903: if_icmpeq -> 1053
    //   906: iload_3
    //   907: iconst_2
    //   908: if_icmpeq -> 1026
    //   911: iload_3
    //   912: iconst_3
    //   913: if_icmpeq -> 999
    //   916: iload_3
    //   917: iconst_4
    //   918: if_icmpeq -> 972
    //   921: iload_3
    //   922: iconst_5
    //   923: if_icmpeq -> 945
    //   926: ldc_w ''
    //   929: astore #6
    //   931: aload #6
    //   933: astore #7
    //   935: iconst_0
    //   936: istore_2
    //   937: iconst_0
    //   938: istore_1
    //   939: aconst_null
    //   940: astore #8
    //   942: goto -> 1096
    //   945: getstatic com/blued/android/module/external_sense_library/config/BluedFilterType$FILER.BABYPINK : Lcom/blued/android/module/external_sense_library/config/BluedFilterType$FILER;
    //   948: astore #8
    //   950: ldc 'filter_babypink'
    //   952: astore #6
    //   954: getstatic com/blued/android/module/live_china/R$drawable.live_beauty_filter_babypink : I
    //   957: istore_2
    //   958: ldc 'filter_babypink'
    //   960: invokestatic v : (Ljava/lang/String;)I
    //   963: istore_1
    //   964: ldc_w 'babypink'
    //   967: astore #7
    //   969: goto -> 1096
    //   972: getstatic com/blued/android/module/external_sense_library/config/BluedFilterType$FILER.CITY : Lcom/blued/android/module/external_sense_library/config/BluedFilterType$FILER;
    //   975: astore #8
    //   977: ldc 'filter_city'
    //   979: astore #6
    //   981: getstatic com/blued/android/module/live_china/R$drawable.live_beauty_filter_city : I
    //   984: istore_2
    //   985: ldc 'filter_city'
    //   987: invokestatic u : (Ljava/lang/String;)I
    //   990: istore_1
    //   991: ldc_w 'city'
    //   994: astore #7
    //   996: goto -> 1096
    //   999: getstatic com/blued/android/module/external_sense_library/config/BluedFilterType$FILER.MODERN : Lcom/blued/android/module/external_sense_library/config/BluedFilterType$FILER;
    //   1002: astore #8
    //   1004: ldc 'filter_morden'
    //   1006: astore #6
    //   1008: getstatic com/blued/android/module/live_china/R$drawable.live_beauty_filter_morden : I
    //   1011: istore_2
    //   1012: ldc 'filter_morden'
    //   1014: invokestatic t : (Ljava/lang/String;)I
    //   1017: istore_1
    //   1018: ldc_w 'morden'
    //   1021: astore #7
    //   1023: goto -> 1096
    //   1026: getstatic com/blued/android/module/external_sense_library/config/BluedFilterType$FILER.PANSY : Lcom/blued/android/module/external_sense_library/config/BluedFilterType$FILER;
    //   1029: astore #8
    //   1031: ldc 'filter_pansy'
    //   1033: astore #6
    //   1035: getstatic com/blued/android/module/live_china/R$drawable.live_beauty_filter_pansy : I
    //   1038: istore_2
    //   1039: ldc 'filter_pansy'
    //   1041: invokestatic s : (Ljava/lang/String;)I
    //   1044: istore_1
    //   1045: ldc_w 'pansy'
    //   1048: astore #7
    //   1050: goto -> 1096
    //   1053: getstatic com/blued/android/module/external_sense_library/config/BluedFilterType$FILER.RUBY : Lcom/blued/android/module/external_sense_library/config/BluedFilterType$FILER;
    //   1056: astore #8
    //   1058: ldc 'filter_ruby'
    //   1060: astore #6
    //   1062: getstatic com/blued/android/module/live_china/R$drawable.live_beauty_filter_ruby : I
    //   1065: istore_2
    //   1066: ldc 'filter_ruby'
    //   1068: invokestatic f : (Ljava/lang/String;)I
    //   1071: istore_1
    //   1072: ldc_w 'ruby'
    //   1075: astore #7
    //   1077: goto -> 1096
    //   1080: getstatic com/blued/android/module/live_china/R$drawable.live_beauty_filter_none : I
    //   1083: istore_2
    //   1084: ldc 'filter_none'
    //   1086: astore #6
    //   1088: ldc_w 'off'
    //   1091: astore #7
    //   1093: goto -> 937
    //   1096: new com/blued/android/module/live_china/model/BeautyModel
    //   1099: dup
    //   1100: aload #6
    //   1102: aload #11
    //   1104: iload_3
    //   1105: aaload
    //   1106: iconst_0
    //   1107: iconst_0
    //   1108: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;IZ)V
    //   1111: astore #6
    //   1113: aload #6
    //   1115: iload_2
    //   1116: putfield resource : I
    //   1119: aload #6
    //   1121: aload #8
    //   1123: putfield filer : Lcom/blued/android/module/external_sense_library/config/BluedFilterType$FILER;
    //   1126: aload #6
    //   1128: iload_1
    //   1129: putfield progress : I
    //   1132: aload #6
    //   1134: iconst_1
    //   1135: putfield isFilter : Z
    //   1138: aload #6
    //   1140: aload #7
    //   1142: putfield eventName : Ljava/lang/String;
    //   1145: aload_0
    //   1146: getfield w : Ljava/util/List;
    //   1149: aload #6
    //   1151: invokeinterface add : (Ljava/lang/Object;)Z
    //   1156: pop
    //   1157: iload_3
    //   1158: iconst_1
    //   1159: iadd
    //   1160: istore_3
    //   1161: goto -> 890
    //   1164: invokestatic p : ()Ljava/lang/String;
    //   1167: astore #6
    //   1169: aload #6
    //   1171: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1174: ifeq -> 1265
    //   1177: aload_0
    //   1178: getfield w : Ljava/util/List;
    //   1181: astore #6
    //   1183: aload #6
    //   1185: ifnull -> 1262
    //   1188: aload #6
    //   1190: invokeinterface size : ()I
    //   1195: ifle -> 1262
    //   1198: aload_0
    //   1199: getfield w : Ljava/util/List;
    //   1202: iconst_1
    //   1203: invokeinterface get : (I)Ljava/lang/Object;
    //   1208: checkcast com/blued/android/module/live_china/model/BeautyModel
    //   1211: astore #6
    //   1213: aload #6
    //   1215: iconst_1
    //   1216: putfield isSelect : Z
    //   1219: aload_0
    //   1220: getfield m : Lcom/blued/android/module/live_china/manager/RecordingOnliveManager;
    //   1223: aload #6
    //   1225: getfield filer : Lcom/blued/android/module/external_sense_library/config/BluedFilterType$FILER;
    //   1228: invokevirtual a : (Lcom/blued/android/module/external_sense_library/config/BluedFilterType$FILER;)V
    //   1231: aload_0
    //   1232: aload #6
    //   1234: getfield progress : I
    //   1237: invokevirtual a : (I)V
    //   1240: aload #6
    //   1242: getfield id : Ljava/lang/String;
    //   1245: invokestatic w : (Ljava/lang/String;)V
    //   1248: getstatic com/blued/das/live/LiveProtos$Event.LIVE_FILTER_USE : Lcom/blued/das/live/LiveProtos$Event;
    //   1251: aload #6
    //   1253: getfield eventName : Ljava/lang/String;
    //   1256: getstatic com/blued/das/live/LiveProtos$Status.START : Lcom/blued/das/live/LiveProtos$Status;
    //   1259: invokestatic a : (Lcom/blued/das/live/LiveProtos$Event;Ljava/lang/String;Lcom/blued/das/live/LiveProtos$Status;)V
    //   1262: goto -> 1365
    //   1265: aload_0
    //   1266: aload #6
    //   1268: invokespecial a : (Ljava/lang/String;)Z
    //   1271: ifeq -> 1285
    //   1274: aload_0
    //   1275: getfield m : Lcom/blued/android/module/live_china/manager/RecordingOnliveManager;
    //   1278: aconst_null
    //   1279: invokevirtual a : (Lcom/blued/android/module/external_sense_library/config/BluedFilterType$FILER;)V
    //   1282: goto -> 1365
    //   1285: iconst_0
    //   1286: istore_1
    //   1287: iload_1
    //   1288: aload_0
    //   1289: getfield w : Ljava/util/List;
    //   1292: invokeinterface size : ()I
    //   1297: if_icmpge -> 1365
    //   1300: aload_0
    //   1301: getfield w : Ljava/util/List;
    //   1304: iload_1
    //   1305: invokeinterface get : (I)Ljava/lang/Object;
    //   1310: checkcast com/blued/android/module/live_china/model/BeautyModel
    //   1313: astore #7
    //   1315: aload #6
    //   1317: aload #7
    //   1319: getfield id : Ljava/lang/String;
    //   1322: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1325: ifeq -> 1358
    //   1328: aload #7
    //   1330: iconst_1
    //   1331: putfield isSelect : Z
    //   1334: aload_0
    //   1335: getfield m : Lcom/blued/android/module/live_china/manager/RecordingOnliveManager;
    //   1338: aload #7
    //   1340: getfield filer : Lcom/blued/android/module/external_sense_library/config/BluedFilterType$FILER;
    //   1343: invokevirtual a : (Lcom/blued/android/module/external_sense_library/config/BluedFilterType$FILER;)V
    //   1346: aload_0
    //   1347: aload #7
    //   1349: getfield progress : I
    //   1352: invokevirtual a : (I)V
    //   1355: goto -> 1365
    //   1358: iload_1
    //   1359: iconst_1
    //   1360: iadd
    //   1361: istore_1
    //   1362: goto -> 1287
    //   1365: iconst_0
    //   1366: istore_3
    //   1367: iload_3
    //   1368: aload #10
    //   1370: arraylength
    //   1371: if_icmpge -> 1550
    //   1374: iload_3
    //   1375: ifne -> 1384
    //   1378: iconst_1
    //   1379: istore #5
    //   1381: goto -> 1387
    //   1384: iconst_0
    //   1385: istore #5
    //   1387: iload_3
    //   1388: ifeq -> 1442
    //   1391: iload_3
    //   1392: iconst_1
    //   1393: if_icmpeq -> 1415
    //   1396: aconst_null
    //   1397: astore #8
    //   1399: ldc_w ''
    //   1402: astore #6
    //   1404: aload #6
    //   1406: astore #7
    //   1408: iconst_0
    //   1409: istore_1
    //   1410: iconst_0
    //   1411: istore_2
    //   1412: goto -> 1478
    //   1415: getstatic com/blued/android/module/external_sense_library/config/BluedBeautifyKey$KEY.ST_BEAUTIFY_SATURATION_STRENGTH : Lcom/blued/android/module/external_sense_library/config/BluedBeautifyKey$KEY;
    //   1418: astore #7
    //   1420: ldc 'saturation'
    //   1422: astore #8
    //   1424: getstatic com/blued/android/module/live_china/R$drawable.live_beauty_saturation : I
    //   1427: istore_2
    //   1428: ldc 'saturation'
    //   1430: invokestatic r : (Ljava/lang/String;)I
    //   1433: istore_1
    //   1434: ldc_w 'Saturation'
    //   1437: astore #6
    //   1439: goto -> 1466
    //   1442: getstatic com/blued/android/module/external_sense_library/config/BluedBeautifyKey$KEY.ST_BEAUTIFY_CONSTRACT_STRENGTH : Lcom/blued/android/module/external_sense_library/config/BluedBeautifyKey$KEY;
    //   1445: astore #7
    //   1447: ldc 'contrast'
    //   1449: astore #8
    //   1451: getstatic com/blued/android/module/live_china/R$drawable.live_beauty_contrast : I
    //   1454: istore_2
    //   1455: ldc 'contrast'
    //   1457: invokestatic q : (Ljava/lang/String;)I
    //   1460: istore_1
    //   1461: ldc_w 'Contrast'
    //   1464: astore #6
    //   1466: aload #7
    //   1468: astore #9
    //   1470: aload #8
    //   1472: astore #7
    //   1474: aload #9
    //   1476: astore #8
    //   1478: new com/blued/android/module/live_china/model/BeautyModel
    //   1481: dup
    //   1482: aload #8
    //   1484: aload #7
    //   1486: aload #10
    //   1488: iload_3
    //   1489: aaload
    //   1490: iconst_0
    //   1491: iload #5
    //   1493: iload_1
    //   1494: invokespecial <init> : (Lcom/blued/android/module/external_sense_library/config/BluedBeautifyKey$KEY;Ljava/lang/String;Ljava/lang/String;IZI)V
    //   1497: astore #7
    //   1499: aload #7
    //   1501: iload_2
    //   1502: putfield resource : I
    //   1505: aload #7
    //   1507: aload #6
    //   1509: putfield eventName : Ljava/lang/String;
    //   1512: aload_0
    //   1513: getfield x : Ljava/util/List;
    //   1516: aload #7
    //   1518: invokeinterface add : (Ljava/lang/Object;)Z
    //   1523: pop
    //   1524: aload_0
    //   1525: getfield m : Lcom/blued/android/module/live_china/manager/RecordingOnliveManager;
    //   1528: aload #7
    //   1530: getfield beautifyKey : Lcom/blued/android/module/external_sense_library/config/BluedBeautifyKey$KEY;
    //   1533: iload_1
    //   1534: i2d
    //   1535: ldc2_w 0.01
    //   1538: dmul
    //   1539: d2f
    //   1540: invokevirtual a : (Lcom/blued/android/module/external_sense_library/config/BluedBeautifyKey$KEY;F)V
    //   1543: iload_3
    //   1544: iconst_1
    //   1545: iadd
    //   1546: istore_3
    //   1547: goto -> 1367
    //   1550: aload_0
    //   1551: getfield k : Lcom/blued/android/module/live_china/view/PopBeautyNewView$BeautyPagerAdapter;
    //   1554: astore #6
    //   1556: aload #6
    //   1558: ifnull -> 1566
    //   1561: aload #6
    //   1563: invokevirtual notifyDataSetChanged : ()V
    //   1566: return
  }
  
  public boolean d() {
    return TextUtils.isEmpty(LiveRoomPreferences.p());
  }
  
  public String e() {
    BeautyModel beautyModel = d(2);
    return (beautyModel != null) ? beautyModel.eventName : "";
  }
  
  class BeautyAdapter extends BaseQuickAdapter<BeautyModel, BaseViewHolder> {
    private ImageView b;
    
    private ImageView c;
    
    public BeautyAdapter(PopBeautyNewView this$0) {
      super(R.layout.beauty_view_item_new, null);
    }
    
    protected void a(BaseViewHolder param1BaseViewHolder, BeautyModel param1BeautyModel) {
      if (param1BaseViewHolder != null) {
        this.b = (ImageView)param1BaseViewHolder.d(R.id.beauty_image_bg);
        this.c = (ImageView)param1BaseViewHolder.d(R.id.beauty_image);
        this.b = (ImageView)param1BaseViewHolder.d(R.id.beauty_image_bg);
        param1BaseViewHolder.c(R.id.beauty_image, param1BeautyModel.resource);
        param1BaseViewHolder.a(R.id.beauty_text, param1BeautyModel.customName);
        if (param1BeautyModel.isSelect) {
          this.b.setVisibility(0);
        } else {
          this.b.setVisibility(8);
        } 
        param1BaseViewHolder.a(R.id.beauty_root_layout, new View.OnClickListener(this, param1BeautyModel) {
              public void onClick(View param2View) {
                if (!this.a.isSelect) {
                  EventTrackLive.a(LiveProtos.Event.LIVE_FILTER_USE, this.b.a.e(), LiveProtos.Status.END);
                  for (int i = 0; i < PopBeautyNewView.BeautyAdapter.a(this.b).size(); i++)
                    ((BeautyModel)PopBeautyNewView.BeautyAdapter.b(this.b).get(i)).isSelect = false; 
                  this.a.isSelect = true;
                  PopBeautyNewView.a(this.b.a, this.a);
                  PopBeautyNewView.a(this.b.a, this.a.progress);
                  if (this.a.isFilter) {
                    if (PopBeautyNewView.a(this.b.a, this.a.id)) {
                      PopBeautyNewView.c(this.b.a).a(null);
                      PopBeautyNewView.p(this.b.a);
                    } else {
                      PopBeautyNewView.c(this.b.a).a(this.a.filer);
                      this.b.a.a(this.a.progress);
                      PopBeautyNewView.q(this.b.a);
                    } 
                    LiveRoomPreferences.w(this.a.id);
                    EventTrackLive.a(LiveProtos.Event.LIVE_FILTER_USE, this.a.eventName, LiveProtos.Status.START);
                  } 
                } 
                this.b.notifyDataSetChanged();
              }
            });
      } 
    }
  }
  
  class null implements View.OnClickListener {
    null(PopBeautyNewView this$0, BeautyModel param1BeautyModel) {}
    
    public void onClick(View param1View) {
      if (!this.a.isSelect) {
        EventTrackLive.a(LiveProtos.Event.LIVE_FILTER_USE, this.b.a.e(), LiveProtos.Status.END);
        for (int i = 0; i < PopBeautyNewView.BeautyAdapter.a(this.b).size(); i++)
          ((BeautyModel)PopBeautyNewView.BeautyAdapter.b(this.b).get(i)).isSelect = false; 
        this.a.isSelect = true;
        PopBeautyNewView.a(this.b.a, this.a);
        PopBeautyNewView.a(this.b.a, this.a.progress);
        if (this.a.isFilter) {
          if (PopBeautyNewView.a(this.b.a, this.a.id)) {
            PopBeautyNewView.c(this.b.a).a(null);
            PopBeautyNewView.p(this.b.a);
          } else {
            PopBeautyNewView.c(this.b.a).a(this.a.filer);
            this.b.a.a(this.a.progress);
            PopBeautyNewView.q(this.b.a);
          } 
          LiveRoomPreferences.w(this.a.id);
          EventTrackLive.a(LiveProtos.Event.LIVE_FILTER_USE, this.a.eventName, LiveProtos.Status.START);
        } 
      } 
      this.b.notifyDataSetChanged();
    }
  }
  
  class BeautyPagerAdapter extends PagerAdapter {
    BeautyPagerAdapter(PopBeautyNewView this$0) {}
    
    public void destroyItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      param1ViewGroup.removeView((View)param1Object);
    }
    
    public int getCount() {
      return PopBeautyNewView.e(this.a).size();
    }
    
    public int getItemPosition(Object param1Object) {
      return -2;
    }
    
    public Object instantiateItem(ViewGroup param1ViewGroup, int param1Int) {
      while (PopBeautyNewView.f(this.a).size() < PopBeautyNewView.e(this.a).size()) {
        View view1 = LayoutInflater.from(PopBeautyNewView.g(this.a)).inflate(R.layout.live_beauty_pager, param1ViewGroup, false);
        PopBeautyNewView.f(this.a).add(view1);
      } 
      View view = PopBeautyNewView.f(this.a).get(param1Int);
      RecyclerView recyclerView = (RecyclerView)((PullToRefreshRecyclerView)view.findViewById(R.id.live_beauty_recycler_view)).getRefreshableView();
      LinearLayoutManager linearLayoutManager = new LinearLayoutManager(PopBeautyNewView.g(this.a));
      linearLayoutManager.setOrientation(0);
      recyclerView.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
      if (param1Int != 0) {
        if (param1Int != 1) {
          if (param1Int != 2) {
            if (param1Int == 3) {
              PopBeautyNewView popBeautyNewView = this.a;
              PopBeautyNewView.d(popBeautyNewView, new PopBeautyNewView.BeautyAdapter(popBeautyNewView));
              PopBeautyNewView.o(this.a).a(PopBeautyNewView.n(this.a));
              recyclerView.setAdapter((RecyclerView.Adapter)PopBeautyNewView.o(this.a));
            } 
          } else {
            PopBeautyNewView popBeautyNewView = this.a;
            PopBeautyNewView.c(popBeautyNewView, new PopBeautyNewView.BeautyAdapter(popBeautyNewView));
            PopBeautyNewView.m(this.a).a(PopBeautyNewView.l(this.a));
            recyclerView.setAdapter((RecyclerView.Adapter)PopBeautyNewView.m(this.a));
          } 
        } else {
          PopBeautyNewView popBeautyNewView = this.a;
          PopBeautyNewView.b(popBeautyNewView, new PopBeautyNewView.BeautyAdapter(popBeautyNewView));
          PopBeautyNewView.k(this.a).a(PopBeautyNewView.j(this.a));
          recyclerView.setAdapter((RecyclerView.Adapter)PopBeautyNewView.k(this.a));
        } 
      } else {
        PopBeautyNewView popBeautyNewView = this.a;
        PopBeautyNewView.a(popBeautyNewView, new PopBeautyNewView.BeautyAdapter(popBeautyNewView));
        PopBeautyNewView.i(this.a).a(PopBeautyNewView.h(this.a));
        recyclerView.setAdapter((RecyclerView.Adapter)PopBeautyNewView.i(this.a));
      } 
      if (view.getParent() != null)
        ((ViewGroup)view.getParent()).removeView(view); 
      param1ViewGroup.addView(PopBeautyNewView.f(this.a).get(param1Int));
      return view;
    }
    
    public boolean isViewFromObject(View param1View, Object param1Object) {
      return (param1View == param1Object);
    }
  }
  
  class MyPopupWindow extends PopupWindow {
    public MyPopupWindow(PopBeautyNewView this$0, View param1View, int param1Int1, int param1Int2, boolean param1Boolean) {
      super(param1View, param1Int1, param1Int2, param1Boolean);
    }
    
    public void a() {
      super.dismiss();
    }
    
    public void dismiss() {
      try {
        this.a.b();
        return;
      } catch (Exception exception) {
        a();
        return;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\PopBeautyNewView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */