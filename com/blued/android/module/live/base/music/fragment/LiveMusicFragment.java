package com.blued.android.module.live.base.music.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live.base.R;
import com.blued.android.module.live.base.music.LiveMusicPresent;
import com.blued.android.module.live.base.music.PlayMusicListener;
import com.blued.android.module.live.base.music.adapter.LiveMusicTabAdapter;
import com.blued.android.module.live.base.music.model.LiveMusicModel;
import com.blued.android.module.live.base.music.model.LiveMusicSheetModel;
import com.blued.android.module.live.base.music.model.LiveMusicSongModel;
import com.blued.android.module.live.base.utils.LiveBasePreferences;
import com.blued.android.module.live.base.utils.LiveTimeAndDateUtils;
import com.blued.android.module.live.base.view.FlowLayout;
import com.google.gson.reflect.TypeToken;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class LiveMusicFragment<P extends LiveMusicPresent> extends MvpFragment<P> implements View.OnClickListener {
  private View A;
  
  private FlowLayout B;
  
  private View C;
  
  private Context D;
  
  private MusicPageAdapter E;
  
  private LiveMusicTabAdapter F;
  
  private LiveMusicListFragment G;
  
  private boolean H;
  
  private LiveMusicSongModel I;
  
  private PlayMusicListener J;
  
  private LiveMusicModel K;
  
  private Observer<String> L = new Observer<String>(this) {
      public void a(String param1String) {
        Log.i("xpm", "KEY_EVENT_LIVE_MUSIC_CHANGED");
        this.a.m();
      }
    };
  
  private TextWatcher M = new TextWatcher(this) {
      public void afterTextChanged(Editable param1Editable) {
        if (TextUtils.isEmpty(param1Editable.toString().trim()))
          return; 
        LiveMusicFragment liveMusicFragment = this.a;
        liveMusicFragment.e(LiveMusicFragment.c(liveMusicFragment).getText().toString());
      }
      
      public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
      
      public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
    };
  
  public List<LiveMusicSheetModel> d = new ArrayList<LiveMusicSheetModel>();
  
  private View e;
  
  private View f;
  
  private View g;
  
  private ImageView h;
  
  private TextView i;
  
  private TextView j;
  
  private View n;
  
  private View o;
  
  private View p;
  
  private View q;
  
  private View r;
  
  private RecyclerView s;
  
  private ViewPager t;
  
  private View u;
  
  private View v;
  
  private View w;
  
  private View x;
  
  private View y;
  
  private EditText z;
  
  private void N() {}
  
  private void O() {
    // Byte code:
    //   0: aload_0
    //   1: getfield d : Ljava/util/List;
    //   4: invokeinterface clear : ()V
    //   9: aload_0
    //   10: aload_0
    //   11: getfield l : Landroid/view/View;
    //   14: getstatic com/blued/android/module/live/base/R$id.empty_view : I
    //   17: invokevirtual findViewById : (I)Landroid/view/View;
    //   20: putfield e : Landroid/view/View;
    //   23: aload_0
    //   24: aload_0
    //   25: getfield l : Landroid/view/View;
    //   28: getstatic com/blued/android/module/live/base/R$id.fl_make_lover_dialog : I
    //   31: invokevirtual findViewById : (I)Landroid/view/View;
    //   34: putfield f : Landroid/view/View;
    //   37: aload_0
    //   38: aload_0
    //   39: getfield l : Landroid/view/View;
    //   42: getstatic com/blued/android/module/live/base/R$id.fl_player : I
    //   45: invokevirtual findViewById : (I)Landroid/view/View;
    //   48: putfield g : Landroid/view/View;
    //   51: aload_0
    //   52: aload_0
    //   53: getfield l : Landroid/view/View;
    //   56: getstatic com/blued/android/module/live/base/R$id.iv_start : I
    //   59: invokevirtual findViewById : (I)Landroid/view/View;
    //   62: checkcast android/widget/ImageView
    //   65: putfield h : Landroid/widget/ImageView;
    //   68: aload_0
    //   69: aload_0
    //   70: getfield l : Landroid/view/View;
    //   73: getstatic com/blued/android/module/live/base/R$id.tv_time : I
    //   76: invokevirtual findViewById : (I)Landroid/view/View;
    //   79: checkcast android/widget/TextView
    //   82: putfield i : Landroid/widget/TextView;
    //   85: aload_0
    //   86: aload_0
    //   87: getfield l : Landroid/view/View;
    //   90: getstatic com/blued/android/module/live/base/R$id.tv_exit : I
    //   93: invokevirtual findViewById : (I)Landroid/view/View;
    //   96: checkcast android/widget/TextView
    //   99: putfield j : Landroid/widget/TextView;
    //   102: aload_0
    //   103: aload_0
    //   104: getfield l : Landroid/view/View;
    //   107: getstatic com/blued/android/module/live/base/R$id.ll_main : I
    //   110: invokevirtual findViewById : (I)Landroid/view/View;
    //   113: putfield n : Landroid/view/View;
    //   116: aload_0
    //   117: aload_0
    //   118: getfield l : Landroid/view/View;
    //   121: getstatic com/blued/android/module/live/base/R$id.ll_tab_error : I
    //   124: invokevirtual findViewById : (I)Landroid/view/View;
    //   127: putfield o : Landroid/view/View;
    //   130: aload_0
    //   131: aload_0
    //   132: getfield l : Landroid/view/View;
    //   135: getstatic com/blued/android/module/live/base/R$id.tv_reload : I
    //   138: invokevirtual findViewById : (I)Landroid/view/View;
    //   141: putfield p : Landroid/view/View;
    //   144: aload_0
    //   145: aload_0
    //   146: getfield l : Landroid/view/View;
    //   149: getstatic com/blued/android/module/live/base/R$id.tv_music_title : I
    //   152: invokevirtual findViewById : (I)Landroid/view/View;
    //   155: putfield q : Landroid/view/View;
    //   158: aload_0
    //   159: aload_0
    //   160: getfield l : Landroid/view/View;
    //   163: getstatic com/blued/android/module/live/base/R$id.loading_view : I
    //   166: invokevirtual findViewById : (I)Landroid/view/View;
    //   169: putfield r : Landroid/view/View;
    //   172: aload_0
    //   173: aload_0
    //   174: getfield l : Landroid/view/View;
    //   177: getstatic com/blued/android/module/live/base/R$id.rv_tab : I
    //   180: invokevirtual findViewById : (I)Landroid/view/View;
    //   183: checkcast androidx/recyclerview/widget/RecyclerView
    //   186: putfield s : Landroidx/recyclerview/widget/RecyclerView;
    //   189: aload_0
    //   190: aload_0
    //   191: getfield l : Landroid/view/View;
    //   194: getstatic com/blued/android/module/live/base/R$id.view_pager : I
    //   197: invokevirtual findViewById : (I)Landroid/view/View;
    //   200: checkcast androidx/viewpager/widget/ViewPager
    //   203: putfield t : Landroidx/viewpager/widget/ViewPager;
    //   206: aload_0
    //   207: aload_0
    //   208: getfield l : Landroid/view/View;
    //   211: getstatic com/blued/android/module/live/base/R$id.ll_search : I
    //   214: invokevirtual findViewById : (I)Landroid/view/View;
    //   217: putfield u : Landroid/view/View;
    //   220: aload_0
    //   221: aload_0
    //   222: getfield l : Landroid/view/View;
    //   225: getstatic com/blued/android/module/live/base/R$id.iv_search : I
    //   228: invokevirtual findViewById : (I)Landroid/view/View;
    //   231: putfield v : Landroid/view/View;
    //   234: aload_0
    //   235: aload_0
    //   236: getfield l : Landroid/view/View;
    //   239: getstatic com/blued/android/module/live/base/R$id.iv_search_clear : I
    //   242: invokevirtual findViewById : (I)Landroid/view/View;
    //   245: putfield w : Landroid/view/View;
    //   248: aload_0
    //   249: aload_0
    //   250: getfield l : Landroid/view/View;
    //   253: getstatic com/blued/android/module/live/base/R$id.tv_search_close : I
    //   256: invokevirtual findViewById : (I)Landroid/view/View;
    //   259: putfield x : Landroid/view/View;
    //   262: aload_0
    //   263: aload_0
    //   264: getfield l : Landroid/view/View;
    //   267: getstatic com/blued/android/module/live/base/R$id.tv_history_clear : I
    //   270: invokevirtual findViewById : (I)Landroid/view/View;
    //   273: putfield y : Landroid/view/View;
    //   276: aload_0
    //   277: aload_0
    //   278: getfield l : Landroid/view/View;
    //   281: getstatic com/blued/android/module/live/base/R$id.edit_view : I
    //   284: invokevirtual findViewById : (I)Landroid/view/View;
    //   287: checkcast android/widget/EditText
    //   290: putfield z : Landroid/widget/EditText;
    //   293: aload_0
    //   294: aload_0
    //   295: getfield l : Landroid/view/View;
    //   298: getstatic com/blued/android/module/live/base/R$id.ll_search_history : I
    //   301: invokevirtual findViewById : (I)Landroid/view/View;
    //   304: putfield A : Landroid/view/View;
    //   307: aload_0
    //   308: aload_0
    //   309: getfield l : Landroid/view/View;
    //   312: getstatic com/blued/android/module/live/base/R$id.music_history : I
    //   315: invokevirtual findViewById : (I)Landroid/view/View;
    //   318: checkcast com/blued/android/module/live/base/view/FlowLayout
    //   321: putfield B : Lcom/blued/android/module/live/base/view/FlowLayout;
    //   324: aload_0
    //   325: aload_0
    //   326: getfield l : Landroid/view/View;
    //   329: getstatic com/blued/android/module/live/base/R$id.live_music_search_container_layout_id : I
    //   332: invokevirtual findViewById : (I)Landroid/view/View;
    //   335: putfield C : Landroid/view/View;
    //   338: aload_0
    //   339: getfield r : Landroid/view/View;
    //   342: iconst_0
    //   343: invokevirtual setVisibility : (I)V
    //   346: aload_0
    //   347: getfield A : Landroid/view/View;
    //   350: new com/blued/android/module/live/base/music/fragment/LiveMusicFragment$2
    //   353: dup
    //   354: aload_0
    //   355: invokespecial <init> : (Lcom/blued/android/module/live/base/music/fragment/LiveMusicFragment;)V
    //   358: invokevirtual setOnTouchListener : (Landroid/view/View$OnTouchListener;)V
    //   361: aload_0
    //   362: getfield s : Landroidx/recyclerview/widget/RecyclerView;
    //   365: new com/blued/android/module/live/base/view/TabLinearLayoutManager
    //   368: dup
    //   369: aload_0
    //   370: invokevirtual getContext : ()Landroid/content/Context;
    //   373: iconst_0
    //   374: iconst_0
    //   375: invokespecial <init> : (Landroid/content/Context;IZ)V
    //   378: invokevirtual setLayoutManager : (Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V
    //   381: aload_0
    //   382: getfield s : Landroidx/recyclerview/widget/RecyclerView;
    //   385: new com/blued/android/module/live/base/music/fragment/LiveMusicFragment$3
    //   388: dup
    //   389: aload_0
    //   390: invokespecial <init> : (Lcom/blued/android/module/live/base/music/fragment/LiveMusicFragment;)V
    //   393: invokevirtual addOnScrollListener : (Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;)V
    //   396: aload_0
    //   397: new com/blued/android/module/live/base/music/adapter/LiveMusicTabAdapter
    //   400: dup
    //   401: aload_0
    //   402: getfield D : Landroid/content/Context;
    //   405: aload_0
    //   406: getfield s : Landroidx/recyclerview/widget/RecyclerView;
    //   409: invokespecial <init> : (Landroid/content/Context;Landroidx/recyclerview/widget/RecyclerView;)V
    //   412: putfield F : Lcom/blued/android/module/live/base/music/adapter/LiveMusicTabAdapter;
    //   415: aload_0
    //   416: getfield F : Lcom/blued/android/module/live/base/music/adapter/LiveMusicTabAdapter;
    //   419: new com/blued/android/module/live/base/music/fragment/LiveMusicFragment$4
    //   422: dup
    //   423: aload_0
    //   424: invokespecial <init> : (Lcom/blued/android/module/live/base/music/fragment/LiveMusicFragment;)V
    //   427: invokevirtual a : (Lcom/blued/android/module/live/base/music/adapter/LiveMusicTabAdapter$EventCallBack;)V
    //   430: aload_0
    //   431: getfield s : Landroidx/recyclerview/widget/RecyclerView;
    //   434: aload_0
    //   435: getfield F : Lcom/blued/android/module/live/base/music/adapter/LiveMusicTabAdapter;
    //   438: invokevirtual setAdapter : (Landroidx/recyclerview/widget/RecyclerView$Adapter;)V
    //   441: aload_0
    //   442: new com/blued/android/module/live/base/music/fragment/LiveMusicFragment$MusicPageAdapter
    //   445: dup
    //   446: aload_0
    //   447: aload_0
    //   448: invokevirtual getChildFragmentManager : ()Landroidx/fragment/app/FragmentManager;
    //   451: invokespecial <init> : (Lcom/blued/android/module/live/base/music/fragment/LiveMusicFragment;Landroidx/fragment/app/FragmentManager;)V
    //   454: putfield E : Lcom/blued/android/module/live/base/music/fragment/LiveMusicFragment$MusicPageAdapter;
    //   457: aload_0
    //   458: getfield t : Landroidx/viewpager/widget/ViewPager;
    //   461: aload_0
    //   462: getfield E : Lcom/blued/android/module/live/base/music/fragment/LiveMusicFragment$MusicPageAdapter;
    //   465: invokevirtual setAdapter : (Landroidx/viewpager/widget/PagerAdapter;)V
    //   468: aload_0
    //   469: getfield t : Landroidx/viewpager/widget/ViewPager;
    //   472: iconst_1
    //   473: invokevirtual setCurrentItem : (I)V
    //   476: aload_0
    //   477: getfield t : Landroidx/viewpager/widget/ViewPager;
    //   480: iconst_1
    //   481: invokevirtual setOffscreenPageLimit : (I)V
    //   484: aload_0
    //   485: getfield t : Landroidx/viewpager/widget/ViewPager;
    //   488: new com/blued/android/module/live/base/music/fragment/LiveMusicFragment$5
    //   491: dup
    //   492: aload_0
    //   493: invokespecial <init> : (Lcom/blued/android/module/live/base/music/fragment/LiveMusicFragment;)V
    //   496: invokevirtual addOnPageChangeListener : (Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;)V
    //   499: aload_0
    //   500: invokevirtual L : ()Lcom/blued/android/module/live/base/music/model/LiveMusicModel;
    //   503: ifnull -> 558
    //   506: aload_0
    //   507: getfield J : Lcom/blued/android/module/live/base/music/PlayMusicListener;
    //   510: astore_1
    //   511: aload_1
    //   512: ifnull -> 558
    //   515: aload_1
    //   516: aload_0
    //   517: invokevirtual L : ()Lcom/blued/android/module/live/base/music/model/LiveMusicModel;
    //   520: getfield music_id : Ljava/lang/String;
    //   523: invokeinterface e : (Ljava/lang/String;)Z
    //   528: ifeq -> 546
    //   531: aload_0
    //   532: getfield g : Landroid/view/View;
    //   535: iconst_0
    //   536: invokevirtual setVisibility : (I)V
    //   539: aload_0
    //   540: invokevirtual m : ()V
    //   543: goto -> 567
    //   546: aload_0
    //   547: getfield g : Landroid/view/View;
    //   550: bipush #8
    //   552: invokevirtual setVisibility : (I)V
    //   555: goto -> 567
    //   558: aload_0
    //   559: getfield g : Landroid/view/View;
    //   562: bipush #8
    //   564: invokevirtual setVisibility : (I)V
    //   567: aload_0
    //   568: invokevirtual n : ()V
    //   571: aload_0
    //   572: invokevirtual J : ()V
    //   575: aload_0
    //   576: getfield v : Landroid/view/View;
    //   579: aload_0
    //   580: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   583: aload_0
    //   584: getfield w : Landroid/view/View;
    //   587: aload_0
    //   588: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   591: aload_0
    //   592: getfield x : Landroid/view/View;
    //   595: aload_0
    //   596: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   599: aload_0
    //   600: getfield e : Landroid/view/View;
    //   603: aload_0
    //   604: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   607: aload_0
    //   608: getfield h : Landroid/widget/ImageView;
    //   611: aload_0
    //   612: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   615: aload_0
    //   616: getfield j : Landroid/widget/TextView;
    //   619: aload_0
    //   620: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   623: aload_0
    //   624: getfield y : Landroid/view/View;
    //   627: aload_0
    //   628: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   631: aload_0
    //   632: getfield p : Landroid/view/View;
    //   635: aload_0
    //   636: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   639: aload_0
    //   640: getfield z : Landroid/widget/EditText;
    //   643: aload_0
    //   644: getfield M : Landroid/text/TextWatcher;
    //   647: invokevirtual addTextChangedListener : (Landroid/text/TextWatcher;)V
    //   650: aload_0
    //   651: getfield z : Landroid/widget/EditText;
    //   654: new com/blued/android/module/live/base/music/fragment/LiveMusicFragment$6
    //   657: dup
    //   658: aload_0
    //   659: invokespecial <init> : (Lcom/blued/android/module/live/base/music/fragment/LiveMusicFragment;)V
    //   662: invokevirtual setOnEditorActionListener : (Landroid/widget/TextView$OnEditorActionListener;)V
    //   665: return
  }
  
  private void P() {
    this.B.removeAllViews();
    LiveBasePreferences.c("");
    this.A.setVisibility(8);
  }
  
  public List<String> E() {
    String str = LiveBasePreferences.c();
    List<String> list = (List)AppInfo.f().fromJson(str, (new TypeToken<List<String>>(this) {
        
        }).getType());
    if (list != null)
      for (String str1 : list) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("get:");
        stringBuilder.append(str1);
        Log.i("==abcd", stringBuilder.toString());
      }  
    return list;
  }
  
  public void F() {
    this.z.setFocusableInTouchMode(true);
    this.z.setFocusable(true);
    this.z.requestFocus();
    ((InputMethodManager)getActivity().getSystemService("input_method")).showSoftInput((View)this.z, 0);
  }
  
  public void G() {
    ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.z.getWindowToken(), 0);
  }
  
  public void H() {
    a(0L);
    this.g.setVisibility(0);
    this.H = true;
    this.h.setImageResource(R.drawable.live_music_pause);
  }
  
  public void I() {
    if (this.E.getCount() > 1)
      this.t.setCurrentItem(1); 
    this.s.smoothScrollToPosition(0);
    this.n.setVisibility(0);
    this.u.setVisibility(8);
  }
  
  public void J() {
    Bundle bundle;
    FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
    LiveMusicListFragment liveMusicListFragment = this.G;
    if (liveMusicListFragment == null) {
      this.G = M();
      bundle = new Bundle();
      bundle.putLong("lid", 0L);
      bundle.putBoolean("searchPage", true);
      this.G.setArguments(bundle);
      fragmentTransaction.add(R.id.live_music_search_container_layout_id, (Fragment)this.G, "SearchMusicList");
      fragmentTransaction.commitNowAllowingStateLoss();
      return;
    } 
    if (!bundle.isAdded()) {
      fragmentTransaction.show((Fragment)this.G);
      fragmentTransaction.commitNowAllowingStateLoss();
    } 
  }
  
  public abstract PlayMusicListener K();
  
  public abstract LiveMusicModel L();
  
  public abstract LiveMusicListFragment M();
  
  public boolean V_() {
    if (super.V_())
      return true; 
    if (!isHidden()) {
      PlayMusicListener playMusicListener = this.J;
      if (playMusicListener != null) {
        playMusicListener.a();
        return true;
      } 
    } 
    return false;
  }
  
  public void a(long paramLong) {
    LiveMusicSongModel liveMusicSongModel = this.I;
    if (liveMusicSongModel != null)
      liveMusicSongModel.playTime = (int)(paramLong / 1000L); 
    this.i.setText(LiveTimeAndDateUtils.a(paramLong / 1000L, false));
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    O();
    k();
    ((LiveMusicPresent)s()).e();
  }
  
  public void a(LiveMusicSongModel paramLiveMusicSongModel) {
    PlayMusicListener playMusicListener = this.J;
    if (playMusicListener != null)
      playMusicListener.a(paramLiveMusicSongModel); 
    this.I = paramLiveMusicSongModel;
  }
  
  public void a(String paramString, List<? extends LiveMusicSheetModel> paramList) {
    super.a(paramString, paramList);
    if (paramString == "LIVE_MUSIC_SHEET") {
      if (paramList == null || paramList.size() == 0) {
        this.o.setVisibility(0);
        return;
      } 
      this.o.setVisibility(8);
      this.d.clear();
      this.d.addAll(paramList);
      this.F.a(this.d, 0);
      this.E.notifyDataSetChanged();
      if (this.E.getCount() > 1) {
        this.t.setCurrentItem(1);
        return;
      } 
    } 
  }
  
  public void a(String paramString, boolean paramBoolean) {
    super.a(paramString, paramBoolean);
    this.r.setVisibility(8);
  }
  
  public void aL_() {
    super.aL_();
    l();
  }
  
  public void b(String paramString) {
    super.b(paramString);
  }
  
  public void c(String paramString) {
    TextView textView = (TextView)LayoutInflater.from(this.D).inflate(R.layout.live_music_search_label_view, null);
    textView.setMaxLines(1);
    textView.setSingleLine(true);
    textView.setEllipsize(TextUtils.TruncateAt.END);
    ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
    marginLayoutParams.rightMargin = DensityUtils.a(this.D, 10.0F);
    this.B.addView((View)textView, (ViewGroup.LayoutParams)marginLayoutParams);
    textView.setText(paramString);
    this.B.setOnItemClickListener(new FlowLayout.OnItemClickListener(this) {
          public void a(View param1View, int param1Int) {
            if (param1View instanceof TextView)
              LiveMusicFragment.c(this.a).setText(((TextView)param1View).getText().toString()); 
          }
        });
  }
  
  public void d(String paramString) {
    int j;
    if (TextUtils.isEmpty(paramString))
      return; 
    List<String> list2 = E();
    List<String> list1 = list2;
    if (list2 == null)
      list1 = new ArrayList<String>(); 
    byte b = -1;
    int i = 0;
    while (true) {
      j = b;
      if (i < list1.size()) {
        if (TextUtils.equals(list1.get(i), paramString)) {
          j = i;
          break;
        } 
        i++;
        continue;
      } 
      break;
    } 
    if (j >= 0 && j < list1.size())
      list1.remove(j); 
    list2 = new ArrayList<String>();
    for (i = 0; i < list1.size(); i++) {
      if (i < 9)
        list2.add(list1.get(i)); 
    } 
    list2.add(0, paramString);
    try {
      LiveBasePreferences.c(AppInfo.f().toJson(list2));
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    n();
  }
  
  public void e(String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      this.G.c(paramString);
      this.A.setVisibility(8);
      this.C.setVisibility(0);
      return;
    } 
    this.A.setVisibility(0);
    this.C.setVisibility(8);
  }
  
  public void k() {
    LiveEventBus.get("live_music_changed", String.class).observeForever(this.L);
  }
  
  public void l() {
    LiveEventBus.get("live_music_changed", String.class).removeObserver(this.L);
  }
  
  public void m() {
    // Byte code:
    //   0: ldc_w '==record'
    //   3: ldc_w 'updateStartBtnStatus'
    //   6: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   9: pop
    //   10: aload_0
    //   11: invokevirtual L : ()Lcom/blued/android/module/live/base/music/model/LiveMusicModel;
    //   14: ifnull -> 43
    //   17: aload_0
    //   18: getfield J : Lcom/blued/android/module/live/base/music/PlayMusicListener;
    //   21: astore_3
    //   22: aload_3
    //   23: ifnull -> 43
    //   26: aload_3
    //   27: aload_0
    //   28: invokevirtual L : ()Lcom/blued/android/module/live/base/music/model/LiveMusicModel;
    //   31: getfield music_id : Ljava/lang/String;
    //   34: invokeinterface c : (Ljava/lang/String;)Z
    //   39: istore_2
    //   40: goto -> 45
    //   43: iconst_0
    //   44: istore_2
    //   45: iload_2
    //   46: ifeq -> 99
    //   49: ldc_w '==record'
    //   52: ldc_w 'musicStart:1'
    //   55: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   58: pop
    //   59: aload_0
    //   60: iconst_0
    //   61: putfield H : Z
    //   64: aload_0
    //   65: lconst_0
    //   66: invokevirtual a : (J)V
    //   69: aload_0
    //   70: getfield h : Landroid/widget/ImageView;
    //   73: getstatic com/blued/android/module/live/base/R$drawable.live_music_start_gray : I
    //   76: invokevirtual setImageResource : (I)V
    //   79: aload_0
    //   80: getfield J : Lcom/blued/android/module/live/base/music/PlayMusicListener;
    //   83: astore_3
    //   84: aload_3
    //   85: ifnull -> 199
    //   88: aload_3
    //   89: aload_0
    //   90: getfield I : Lcom/blued/android/module/live/base/music/model/LiveMusicSongModel;
    //   93: invokeinterface e : (Lcom/blued/android/module/live/base/music/model/LiveMusicSongModel;)V
    //   98: return
    //   99: ldc_w '==record'
    //   102: ldc_w 'musicStart:2'
    //   105: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   108: pop
    //   109: aload_0
    //   110: getfield J : Lcom/blued/android/module/live/base/music/PlayMusicListener;
    //   113: astore_3
    //   114: aload_3
    //   115: ifnull -> 145
    //   118: aload_3
    //   119: aload_0
    //   120: invokevirtual L : ()Lcom/blued/android/module/live/base/music/model/LiveMusicModel;
    //   123: getfield music_id : Ljava/lang/String;
    //   126: invokeinterface d : (Ljava/lang/String;)Z
    //   131: ifeq -> 145
    //   134: aload_0
    //   135: aload_0
    //   136: invokevirtual L : ()Lcom/blued/android/module/live/base/music/model/LiveMusicModel;
    //   139: getfield curDuration : J
    //   142: invokevirtual a : (J)V
    //   145: aload_0
    //   146: getfield J : Lcom/blued/android/module/live/base/music/PlayMusicListener;
    //   149: astore_3
    //   150: aload_3
    //   151: ifnull -> 171
    //   154: aload_0
    //   155: aload_3
    //   156: aload_0
    //   157: invokevirtual L : ()Lcom/blued/android/module/live/base/music/model/LiveMusicModel;
    //   160: getfield music_id : Ljava/lang/String;
    //   163: invokeinterface a : (Ljava/lang/String;)Z
    //   168: putfield H : Z
    //   171: aload_0
    //   172: getfield h : Landroid/widget/ImageView;
    //   175: astore_3
    //   176: aload_0
    //   177: getfield H : Z
    //   180: ifeq -> 190
    //   183: getstatic com/blued/android/module/live/base/R$drawable.live_music_pause : I
    //   186: istore_1
    //   187: goto -> 194
    //   190: getstatic com/blued/android/module/live/base/R$drawable.live_music_start : I
    //   193: istore_1
    //   194: aload_3
    //   195: iload_1
    //   196: invokevirtual setImageResource : (I)V
    //   199: return
  }
  
  public void n() {
    this.B.removeAllViews();
    List<String> list = E();
    if (list != null) {
      this.A.setVisibility(0);
      Iterator<String> iterator = list.iterator();
      while (iterator.hasNext())
        c(iterator.next()); 
    } else {
      this.A.setVisibility(8);
    } 
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i == R.id.iv_search) {
      this.n.setVisibility(8);
      this.u.setVisibility(0);
      F();
      PlayMusicListener playMusicListener = this.J;
      if (playMusicListener != null) {
        playMusicListener.b();
        return;
      } 
    } else {
      if (i == R.id.iv_search_clear) {
        this.z.setText("");
        this.A.setVisibility(0);
        this.C.setVisibility(8);
        return;
      } 
      if (i == R.id.tv_search_close) {
        this.z.setText("");
        this.n.setVisibility(0);
        this.A.setVisibility(0);
        this.C.setVisibility(8);
        this.u.setVisibility(8);
        G();
        return;
      } 
      if (i == R.id.empty_view) {
        PlayMusicListener playMusicListener = this.J;
        if (playMusicListener != null)
          playMusicListener.a(); 
        G();
        return;
      } 
      if (i == R.id.iv_start) {
        if (L() != null) {
          PlayMusicListener playMusicListener = this.J;
          if (playMusicListener == null || playMusicListener.c((L()).music_id))
            Log.i("==record", "play isCompleted"); 
          this.H ^= 0x1;
          ImageView imageView = this.h;
          if (this.H) {
            i = R.drawable.live_music_pause;
          } else {
            i = R.drawable.live_music_start;
          } 
          imageView.setImageResource(i);
          if (this.H) {
            PlayMusicListener playMusicListener1 = this.J;
            if (playMusicListener1 != null) {
              playMusicListener1.b(this.I);
              return;
            } 
          } else {
            PlayMusicListener playMusicListener1 = this.J;
            if (playMusicListener1 != null) {
              playMusicListener1.c(this.I);
              return;
            } 
          } 
          return;
        } 
      } else {
        if (i == R.id.tv_exit) {
          this.g.setVisibility(8);
          PlayMusicListener playMusicListener = this.J;
          if (playMusicListener != null) {
            playMusicListener.d(this.I);
            this.J.a();
          } 
          a(0L);
          G();
          return;
        } 
        if (i == R.id.tv_history_clear) {
          P();
          return;
        } 
        if (i == R.id.tv_reload) {
          n();
          ((LiveMusicPresent)s()).e();
        } 
        return;
      } 
      Log.i("==record", "play isCompleted");
    } 
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.D = getContext();
    N();
    this.J = K();
    this.K = L();
  }
  
  public void onDestroy() {
    super.onDestroy();
  }
  
  public int p() {
    return R.layout.fragment_live_music;
  }
  
  public class MusicPageAdapter extends FragmentPagerAdapter {
    public MusicPageAdapter(LiveMusicFragment this$0, FragmentManager param1FragmentManager) {
      super(param1FragmentManager);
    }
    
    public void destroyItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      super.destroyItem(param1ViewGroup, param1Int, param1Object);
    }
    
    public int getCount() {
      return this.a.d.size();
    }
    
    public Fragment getItem(int param1Int) {
      LiveMusicListFragment liveMusicListFragment = this.a.M();
      Bundle bundle = new Bundle();
      bundle.putString("sheetId", ((LiveMusicSheetModel)this.a.d.get(param1Int)).sheet_id);
      bundle.putInt("isPersonal", ((LiveMusicSheetModel)this.a.d.get(param1Int)).is_personal);
      bundle.putString("collectId", ((LiveMusicPresent)this.a.s()).n());
      bundle.putBoolean("searchPage", false);
      liveMusicListFragment.setArguments(bundle);
      return (Fragment)liveMusicListFragment;
    }
    
    public CharSequence getPageTitle(int param1Int) {
      return ((LiveMusicSheetModel)this.a.d.get(param1Int)).sheet_name;
    }
    
    public Object instantiateItem(ViewGroup param1ViewGroup, int param1Int) {
      return super.instantiateItem(param1ViewGroup, param1Int);
    }
    
    public void setPrimaryItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      super.setPrimaryItem(param1ViewGroup, param1Int, param1Object);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live\base\music\fragment\LiveMusicFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */