package com.soft.blued.ui.find.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.help.Inputtips;
import com.amap.api.services.help.Tip;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.activity.keyboardpage.KeyBoardFragment;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.SearchEditText;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.das.guy.GuyProtos;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.customview.SearchView;
import com.soft.blued.log.trackUtils.EventTrackGuy;
import com.soft.blued.ui.find.adapter.MapSearchPositionAdapter;
import com.soft.blued.ui.find.manager.MapSearchHistoryManager;
import com.soft.blued.ui.find.model.SearchPositionModel;
import com.soft.blued.utils.ActivityChangeAnimationUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.NetworkUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapSearchPositionFragment extends KeyBoardFragment implements View.OnClickListener, Inputtips.InputtipsListener, PoiSearch.OnPoiSearchListener {
  private MapSearchPositionAdapter A;
  
  private List<String> B;
  
  private List<SearchPositionModel> C;
  
  private List<String> D;
  
  private List<SearchPositionModel> E;
  
  private boolean F = false;
  
  private String G;
  
  private boolean H = false;
  
  private PoiResult I;
  
  private int J = 0;
  
  private PoiSearch.Query K;
  
  private PoiSearch L;
  
  private String M;
  
  private List<PoiItem> N;
  
  private List<PoiItem> O;
  
  private List<PoiItem> P;
  
  private List<Tip> Q;
  
  private ViewPager R;
  
  private PositionPagerAdapter S;
  
  private List<String> T = new ArrayList<String>();
  
  private List<View> U = new ArrayList<View>();
  
  private TextView V;
  
  private TextView W;
  
  private int X;
  
  public FindSearchMapActivity e;
  
  private Context f;
  
  private View o;
  
  private Dialog p;
  
  private SearchView q;
  
  private SearchEditText r;
  
  private View s;
  
  private KeyboardListenLinearLayout t;
  
  private ImageView u;
  
  private ConstraintLayout v;
  
  private NoDataAndLoadFailView w;
  
  private NoDataAndLoadFailView x;
  
  private RecyclerView y;
  
  private MapSearchPositionAdapter z;
  
  private void a(boolean paramBoolean, int paramInt) {
    if (this.e != null)
      if (paramBoolean) {
        if (this.O.size() > paramInt) {
          this.e.a(this.O.get(paramInt), this.G);
          return;
        } 
      } else if (this.P.size() > paramInt) {
        this.e.a(this.P.get(paramInt), this.G);
      }  
  }
  
  private int b(int paramInt) {
    return BluedSkinUtils.a(this.f, paramInt);
  }
  
  private void b(String paramString) {
    StringBuilder stringBuilder;
    if (StringUtils.e(paramString))
      return; 
    paramString = paramString.trim();
    if (this.B.size() > 0) {
      boolean bool = false;
      int i;
      for (i = 0; i < this.B.size(); i++) {
        if (paramString.equals(this.B.get(i))) {
          this.B.remove(i);
          break;
        } 
      } 
      this.B.add(0, paramString);
      if (this.B.size() > 10) {
        List<String> list = this.B;
        list.remove(list.size() - 1);
      } 
      stringBuilder = new StringBuilder();
      for (i = bool; i < this.B.size(); i++) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(this.B.get(i));
        stringBuilder1.append(",");
        stringBuilder.append(stringBuilder1.toString());
      } 
      BluedPreferences.c(stringBuilder.toString());
    } else {
      this.B.add(stringBuilder);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append((String)stringBuilder);
      stringBuilder1.append(",");
      BluedPreferences.c(stringBuilder1.toString());
    } 
    this.z.a(this.B, true);
  }
  
  private void c(int paramInt) {
    if (paramInt != 0) {
      if (paramInt != 1)
        return; 
      this.V.setTextColor(b(2131100844));
      this.W.setTextColor(b(2131100838));
      return;
    } 
    this.V.setTextColor(b(2131100838));
    this.W.setTextColor(b(2131100844));
  }
  
  private void d(int paramInt) {
    Context context = this.f;
    CommonAlertDialog.a(context, null, context.getResources().getString(2131756011), this.f.getResources().getString(2131756014), new DialogInterface.OnClickListener(this, paramInt) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            EventTrackGuy.b(GuyProtos.Event.MAP_FIND_SEARCH_CLEAR_HISTORY);
            if (this.a == 0) {
              MapSearchPositionFragment.o(this.b);
              MapSearchPositionFragment.f(this.b).clear();
              MapSearchPositionFragment.i(this.b).a();
              return;
            } 
            MapSearchPositionFragment.o(this.b);
            MapSearchPositionFragment.n(this.b).clear();
            MapSearchPositionFragment.l(this.b).a();
          }
        }null, null, null);
  }
  
  private List<String> e(int paramInt) {
    String str;
    if (paramInt == 0) {
      str = BluedPreferences.v();
    } else {
      str = BluedPreferences.x();
    } 
    ArrayList<String> arrayList = new ArrayList(Arrays.asList((Object[])str.split(",")));
    if (arrayList.size() == 1 && ((String)arrayList.get(0)).equals(""))
      arrayList.clear(); 
    return arrayList;
  }
  
  private boolean u() {
    return (this.X == 0);
  }
  
  private void v() {
    String str = this.G;
    if (str == null)
      str = ""; 
    this.G = str;
    this.B = e(0);
    this.C = MapSearchHistoryManager.a().b().getModelList();
    this.D = new ArrayList<String>();
    this.E = new ArrayList<SearchPositionModel>();
    this.O = new ArrayList<PoiItem>();
    this.P = new ArrayList<PoiItem>();
    this.Q = new ArrayList<Tip>();
    String[] arrayOfString = this.f.getResources().getStringArray(2130903109);
    this.T.addAll(Arrays.asList(arrayOfString));
  }
  
  private void w() {
    this.z = new MapSearchPositionAdapter(this.f, this.B, 0);
    this.A = new MapSearchPositionAdapter(this.f, this.C);
    this.z.a(new MapSearchPositionAdapter.OnItemClickListener(this) {
          public void a(View param1View, int param1Int, SearchPositionModel param1SearchPositionModel) {
            if (param1SearchPositionModel.isDel) {
              MapSearchPositionFragment.a(this.a, 0);
              return;
            } 
            if (MapSearchPositionFragment.b(this.a)) {
              if (MapSearchPositionFragment.c(this.a).size() > param1Int) {
                MapSearchPositionFragment mapSearchPositionFragment2 = this.a;
                MapSearchPositionFragment.a(mapSearchPositionFragment2, MapSearchPositionFragment.c(mapSearchPositionFragment2).get(param1Int));
              } 
              MapSearchPositionFragment mapSearchPositionFragment1 = this.a;
              MapSearchPositionFragment.b(mapSearchPositionFragment1, MapSearchPositionFragment.d(mapSearchPositionFragment1));
              MapSearchPositionFragment.a(this.a, true, param1Int);
              return;
            } 
            if (NetworkUtils.b())
              DialogUtils.a(MapSearchPositionFragment.e(this.a)); 
            EventTrackGuy.b(GuyProtos.Event.MAP_FIND_SEARCH_HISTORY_CLICK);
            MapSearchPositionFragment.a(this.a).setText(MapSearchPositionFragment.f(this.a).get(param1Int));
            MapSearchPositionFragment.a(this.a).setSelection(MapSearchPositionFragment.a(this.a).getText().length());
            MapSearchPositionFragment mapSearchPositionFragment = this.a;
            MapSearchPositionFragment.b(mapSearchPositionFragment, MapSearchPositionFragment.d(mapSearchPositionFragment));
          }
        });
    this.A.a(new MapSearchPositionAdapter.OnItemClickListener(this) {
          public void a(View param1View, int param1Int, SearchPositionModel param1SearchPositionModel) {
            if (param1SearchPositionModel.isDel) {
              MapSearchPositionFragment.a(this.a, 1);
              return;
            } 
            if (MapSearchPositionFragment.b(this.a)) {
              MapSearchPositionFragment.a(this.a, param1SearchPositionModel.name);
              MapSearchPositionFragment mapSearchPositionFragment = this.a;
              MapSearchPositionFragment.b(mapSearchPositionFragment, MapSearchPositionFragment.d(mapSearchPositionFragment));
              if (MapSearchPositionFragment.g(this.a).size() > param1Int) {
                MapSearchPositionFragment.a(this.a, false, param1Int);
                return;
              } 
              if (this.a.e != null) {
                this.a.e.a(param1SearchPositionModel);
                return;
              } 
            } else if (this.a.e != null) {
              this.a.e.a(param1SearchPositionModel);
            } 
          }
        });
  }
  
  private void x() {
    this.q = (SearchView)this.o.findViewById(2131299874);
    this.r = this.q.getEditView();
    this.r.setImeOptions(3);
    this.s = this.o.findViewById(2131297985);
    this.q.setOnSearchInfoListener(new SearchView.OnSearchInfoListener(this) {
          public void a() {
            if (this.a.e != null) {
              KeyboardUtils.a((Activity)this.a.getActivity());
              this.a.e.l();
            } 
          }
          
          public void a(String param1String) {
            Log.v("drb", "doSearch");
            if (MapSearchPositionFragment.h(this.a)) {
              boolean bool;
              MapSearchPositionFragment mapSearchPositionFragment = this.a;
              if (param1String.length() > 0) {
                bool = true;
              } else {
                bool = false;
              } 
              MapSearchPositionFragment.a(mapSearchPositionFragment, bool);
              if (MapSearchPositionFragment.b(this.a)) {
                if (NetworkUtils.b()) {
                  this.a.a(param1String);
                  MapSearchPositionFragment.c(this.a).clear();
                  MapSearchPositionFragment.i(this.a).a(MapSearchPositionFragment.c(this.a), false);
                  return;
                } 
                if (MapSearchPositionFragment.j(this.a) != null) {
                  MapSearchPositionFragment.j(this.a).b();
                  return;
                } 
              } else {
                if (MapSearchPositionFragment.j(this.a) != null)
                  MapSearchPositionFragment.j(this.a).c(); 
                MapSearchPositionFragment.i(this.a).a(MapSearchPositionFragment.f(this.a), true);
                return;
              } 
            } else {
              boolean bool;
              MapSearchPositionFragment mapSearchPositionFragment = this.a;
              if (param1String.length() > 0) {
                bool = true;
              } else {
                bool = false;
              } 
              MapSearchPositionFragment.a(mapSearchPositionFragment, bool);
              if (MapSearchPositionFragment.b(this.a)) {
                if (NetworkUtils.b()) {
                  this.a.a(param1String);
                  MapSearchPositionFragment.k(this.a).clear();
                  MapSearchPositionFragment.l(this.a).b(MapSearchPositionFragment.k(this.a), false);
                  return;
                } 
                if (MapSearchPositionFragment.m(this.a) != null) {
                  MapSearchPositionFragment.m(this.a).b();
                  return;
                } 
              } else {
                if (MapSearchPositionFragment.m(this.a) != null)
                  MapSearchPositionFragment.m(this.a).c(); 
                MapSearchPositionFragment.l(this.a).b(MapSearchPositionFragment.n(this.a), true);
              } 
            } 
          }
          
          public void b() {}
        });
    this.r.setOnEditorActionListener(new TextView.OnEditorActionListener(this) {
          public boolean onEditorAction(TextView param1TextView, int param1Int, KeyEvent param1KeyEvent) {
            MapSearchPositionFragment mapSearchPositionFragment = this.a;
            MapSearchPositionFragment.a(mapSearchPositionFragment, MapSearchPositionFragment.a(mapSearchPositionFragment).getText().toString());
            if (StringUtils.e(MapSearchPositionFragment.d(this.a)))
              return false; 
            if (param1Int == 3) {
              mapSearchPositionFragment = this.a;
              MapSearchPositionFragment.b(mapSearchPositionFragment, MapSearchPositionFragment.d(mapSearchPositionFragment));
              KeyboardUtils.a((Activity)this.a.getActivity());
              if (NetworkUtils.b()) {
                MapSearchPositionFragment.b(this.a, true);
                DialogUtils.a(MapSearchPositionFragment.e(this.a));
                mapSearchPositionFragment = this.a;
                mapSearchPositionFragment.a(MapSearchPositionFragment.d(mapSearchPositionFragment));
                return true;
              } 
              MapSearchPositionFragment.j(this.a).b();
              return true;
            } 
            return false;
          }
        });
  }
  
  private void y() {
    this.p = DialogUtils.a(this.f);
    this.u = (ImageView)this.o.findViewById(2131297413);
    this.u.setOnClickListener(this);
    this.v = (ConstraintLayout)this.o.findViewById(2131298092);
    this.R = (ViewPager)this.o.findViewById(2131301672);
    this.V = (TextView)this.o.findViewById(2131301306);
    this.W = (TextView)this.o.findViewById(2131301307);
    this.V.setOnClickListener(this);
    this.W.setOnClickListener(this);
    this.S = new PositionPagerAdapter(this);
    this.R.setAdapter(this.S);
    c(0);
    this.R.addOnPageChangeListener(new ViewPager.OnPageChangeListener(this) {
          public void onPageScrollStateChanged(int param1Int) {}
          
          public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
          
          public void onPageSelected(int param1Int) {
            MapSearchPositionFragment.b(this.a, param1Int);
            MapSearchPositionFragment.c(this.a, param1Int);
          }
        });
  }
  
  private void z() {
    if (u()) {
      BluedPreferences.w();
      return;
    } 
    BluedPreferences.z();
  }
  
  public boolean V_() {
    if (getActivity() == null)
      return false; 
    getActivity().finish();
    ActivityChangeAnimationUtils.c((Activity)getActivity());
    return true;
  }
  
  protected void a(String paramString) {
    if (StringUtils.e(paramString)) {
      if (u()) {
        this.w.a();
        return;
      } 
      this.x.a();
      return;
    } 
    paramString = paramString.trim();
    this.J = 0;
    this.K = new PoiSearch.Query(paramString, "", "");
    this.K.setPageSize(30);
    this.K.setPageNum(this.J);
    this.L = new PoiSearch(this.f, this.K);
    this.L.setOnPoiSearchListener(this);
    this.L.searchPOIAsyn();
  }
  
  public void a(String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setData searchPosition:");
    stringBuilder.append(paramString1);
    stringBuilder.append(" -- :");
    stringBuilder.append(paramString2);
    Log.v("drb", stringBuilder.toString());
    this.M = paramString2;
    this.G = paramString1;
    this.r.setText(paramString1);
    SearchEditText searchEditText = this.r;
    searchEditText.setSelection(searchEditText.getText().length());
    this.r.postDelayed(new Runnable(this) {
          public void run() {
            MapSearchPositionFragment.a(this.a).setFocusable(true);
            MapSearchPositionFragment.a(this.a).setFocusableInTouchMode(true);
            MapSearchPositionFragment.a(this.a).requestFocus();
            KeyboardUtils.c((Activity)this.a.getActivity());
          }
        },  500L);
    this.C = MapSearchHistoryManager.a().b().getModelList();
  }
  
  public void e_(int paramInt) {
    if (paramInt != -3) {
      if (paramInt != -2)
        return; 
      this.s.setVisibility(8);
      this.s.setOnTouchListener(null);
      return;
    } 
    SearchView searchView = this.q;
    if (searchView != null)
      searchView.a(true); 
    this.s.setVisibility(0);
    this.s.setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            if (param1MotionEvent.getAction() == 0) {
              Log.v("drb", "ACTION_DOWN");
              KeyboardUtils.b((Context)this.a.getActivity(), (View)MapSearchPositionFragment.a(this.a));
            } 
            return false;
          }
        });
  }
  
  public void onClick(View paramView) {
    switch (paramView.getId()) {
      default:
        return;
      case 2131301307:
        c(1);
        this.R.setCurrentItem(1);
        return;
      case 2131301306:
        c(0);
        this.R.setCurrentItem(0);
        break;
      case 2131297413:
        break;
    } 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.f = (Context)getActivity();
    View view = this.o;
    if (view == null) {
      this.o = paramLayoutInflater.inflate(2131493219, paramViewGroup, false);
      this.o.setBackgroundColor(BluedSkinUtils.a(getContext(), 2131100728));
      v();
      y();
      w();
      x();
      t();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.o.getParent()).removeView(this.o);
    } 
    return this.o;
  }
  
  public void onDestroy() {
    super.onDestroy();
    this.e = null;
  }
  
  public void onGetInputtips(List<Tip> paramList, int paramInt) {
    DialogUtils.b(this.p);
    if (!this.F)
      return; 
    if (paramInt == 1000) {
      this.Q.clear();
      this.D.clear();
      this.E.clear();
      for (Tip tip : paramList) {
        if (tip.getPoint() != null && tip.getPoint().getLatitude() != 0.0D && tip.getPoint().getLongitude() != 0.0D) {
          this.Q.add(tip);
          if (u()) {
            this.D.add(tip.getName());
            continue;
          } 
          this.E.add(new SearchPositionModel(tip.getName(), tip.getPoint().getLatitude(), tip.getPoint().getLongitude()));
        } 
      } 
      if (u()) {
        MapSearchPositionAdapter mapSearchPositionAdapter = this.z;
        if (mapSearchPositionAdapter != null)
          mapSearchPositionAdapter.notifyDataSetChanged(); 
      } else {
        MapSearchPositionAdapter mapSearchPositionAdapter = this.A;
        if (mapSearchPositionAdapter != null)
          mapSearchPositionAdapter.notifyDataSetChanged(); 
      } 
      if (this.Q.size() == 0) {
        if (u()) {
          this.w.a();
        } else {
          this.x.a();
        } 
      } else if (u()) {
        this.w.c();
      } else {
        this.x.c();
      } 
      if (this.H) {
        this.H = false;
        if (u()) {
          if (this.D.size() > 0) {
            a(true, 0);
            return;
          } 
        } else if (this.E.size() > 0) {
          a(false, 0);
          return;
        } 
      } 
    } else {
      if (u()) {
        this.w.a();
        return;
      } 
      this.x.a();
    } 
  }
  
  public void onPoiItemSearched(PoiItem paramPoiItem, int paramInt) {}
  
  public void onPoiSearched(PoiResult paramPoiResult, int paramInt) {
    DialogUtils.b(this.p);
    if (!this.F)
      return; 
    if (paramInt == 1000) {
      if (paramPoiResult != null && paramPoiResult.getQuery() != null) {
        if (paramPoiResult.getQuery().equals(this.K)) {
          this.I = paramPoiResult;
          this.I.getSearchSuggestionCitys();
          List<PoiItem> list = this.N;
          if (list != null && list.size() > 0)
            this.N.clear(); 
          this.N = this.I.getPois();
          if (u()) {
            this.D.clear();
            this.O.clear();
            for (PoiItem poiItem : this.N) {
              this.D.add(poiItem.getTitle());
              this.O.add(poiItem);
            } 
            MapSearchPositionAdapter mapSearchPositionAdapter = this.z;
            if (mapSearchPositionAdapter != null) {
              mapSearchPositionAdapter.a(this.D, false);
              this.z.notifyDataSetChanged();
            } 
            if (this.N.size() == 0) {
              this.w.a();
            } else {
              this.w.c();
            } 
            if (this.H) {
              this.H = false;
              if (this.D.size() > 0) {
                a(true, 0);
                return;
              } 
            } 
          } else {
            this.E.clear();
            this.P.clear();
            for (PoiItem poiItem : this.N) {
              this.E.add(new SearchPositionModel(poiItem.getTitle(), poiItem.getLatLonPoint().getLatitude(), poiItem.getLatLonPoint().getLongitude()));
              this.P.add(poiItem);
            } 
            MapSearchPositionAdapter mapSearchPositionAdapter = this.A;
            if (mapSearchPositionAdapter != null) {
              mapSearchPositionAdapter.b(this.E, false);
              this.A.notifyDataSetChanged();
            } 
            if (this.N.size() == 0) {
              this.x.a();
            } else {
              this.x.c();
            } 
            if (this.H) {
              this.H = false;
              if (this.E.size() > 0) {
                a(false, 0);
                return;
              } 
            } 
          } 
        } 
      } else {
        if (u()) {
          this.w.a();
          return;
        } 
        this.x.a();
        return;
      } 
    } else {
      if (u()) {
        this.w.a();
        return;
      } 
      this.x.a();
    } 
  }
  
  public void t() {
    this.t = (KeyboardListenLinearLayout)this.o.findViewById(2131297981);
    a(this.t);
  }
  
  class PositionPagerAdapter extends PagerAdapter {
    PositionPagerAdapter(MapSearchPositionFragment this$0) {}
    
    public void destroyItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      param1ViewGroup.removeView((View)param1Object);
    }
    
    public int getCount() {
      return MapSearchPositionFragment.p(this.a).size();
    }
    
    public int getItemPosition(Object param1Object) {
      return -2;
    }
    
    public Object instantiateItem(ViewGroup param1ViewGroup, int param1Int) {
      while (MapSearchPositionFragment.q(this.a).size() < MapSearchPositionFragment.p(this.a).size()) {
        View view1 = LayoutInflater.from(MapSearchPositionFragment.r(this.a)).inflate(2131494103, param1ViewGroup, false);
        MapSearchPositionFragment.q(this.a).add(view1);
      } 
      View view = MapSearchPositionFragment.q(this.a).get(param1Int);
      MapSearchPositionFragment.a(this.a, (RecyclerView)view.findViewById(2131299605));
      LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MapSearchPositionFragment.r(this.a));
      MapSearchPositionFragment.s(this.a).setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
      if (param1Int != 0) {
        if (param1Int == 1) {
          MapSearchPositionFragment.b(this.a, (NoDataAndLoadFailView)view.findViewById(2131299395));
          MapSearchPositionFragment.m(this.a).setNoDataStr(2131758665);
          MapSearchPositionFragment.j(this.a).c();
          if (MapSearchPositionFragment.s(this.a).getAdapter() == null)
            MapSearchPositionFragment.s(this.a).setAdapter((RecyclerView.Adapter)MapSearchPositionFragment.l(this.a)); 
        } 
      } else {
        MapSearchPositionFragment.a(this.a, (NoDataAndLoadFailView)view.findViewById(2131299395));
        Log.v("drb", "findViewById nodataview");
        MapSearchPositionFragment.j(this.a).setNoDataStr(2131758665);
        MapSearchPositionFragment.j(this.a).c();
        if (MapSearchPositionFragment.s(this.a).getAdapter() == null)
          MapSearchPositionFragment.s(this.a).setAdapter((RecyclerView.Adapter)MapSearchPositionFragment.i(this.a)); 
      } 
      if (view.getParent() != null)
        ((ViewGroup)view.getParent()).removeView(view); 
      param1ViewGroup.addView(MapSearchPositionFragment.q(this.a).get(param1Int));
      return view;
    }
    
    public boolean isViewFromObject(View param1View, Object param1Object) {
      return (param1View == param1Object);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\fragment\MapSearchPositionFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */