package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.util.Pair;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import java.util.Iterator;

public final class MaterialCalendar<S> extends PickerFragment<S> {
  static final Object a = "MONTHS_VIEW_GROUP_TAG";
  
  static final Object b = "NAVIGATION_PREV_TAG";
  
  static final Object c = "NAVIGATION_NEXT_TAG";
  
  static final Object d = "SELECTOR_TOGGLE_TAG";
  
  private int f;
  
  private DateSelector<S> g;
  
  private CalendarConstraints h;
  
  private Month i;
  
  private CalendarSelector j;
  
  private CalendarStyle k;
  
  private RecyclerView l;
  
  private RecyclerView m;
  
  private View n;
  
  private View o;
  
  static int a(Context paramContext) {
    return paramContext.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height);
  }
  
  static <T> MaterialCalendar<T> a(DateSelector<T> paramDateSelector, int paramInt, CalendarConstraints paramCalendarConstraints) {
    MaterialCalendar<T> materialCalendar = new MaterialCalendar();
    Bundle bundle = new Bundle();
    bundle.putInt("THEME_RES_ID_KEY", paramInt);
    bundle.putParcelable("GRID_SELECTOR_KEY", paramDateSelector);
    bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", paramCalendarConstraints);
    bundle.putParcelable("CURRENT_MONTH_KEY", paramCalendarConstraints.d());
    materialCalendar.setArguments(bundle);
    return materialCalendar;
  }
  
  private void a(int paramInt) {
    this.m.post(new Runnable(this, paramInt) {
          public void run() {
            MaterialCalendar.a(this.b).smoothScrollToPosition(this.a);
          }
        });
  }
  
  private void a(View paramView, MonthsPagerAdapter paramMonthsPagerAdapter) {
    MaterialButton materialButton1 = (MaterialButton)paramView.findViewById(R.id.month_navigation_fragment_toggle);
    materialButton1.setTag(d);
    ViewCompat.setAccessibilityDelegate((View)materialButton1, new AccessibilityDelegateCompat(this) {
          public void onInitializeAccessibilityNodeInfo(View param1View, AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat) {
            String str;
            super.onInitializeAccessibilityNodeInfo(param1View, param1AccessibilityNodeInfoCompat);
            if (MaterialCalendar.f(this.a).getVisibility() == 0) {
              str = this.a.getString(R.string.mtrl_picker_toggle_to_year_selection);
            } else {
              str = this.a.getString(R.string.mtrl_picker_toggle_to_day_selection);
            } 
            param1AccessibilityNodeInfoCompat.setHintText(str);
          }
        });
    MaterialButton materialButton2 = (MaterialButton)paramView.findViewById(R.id.month_navigation_previous);
    materialButton2.setTag(b);
    MaterialButton materialButton3 = (MaterialButton)paramView.findViewById(R.id.month_navigation_next);
    materialButton3.setTag(c);
    this.n = paramView.findViewById(R.id.mtrl_calendar_year_selector_frame);
    this.o = paramView.findViewById(R.id.mtrl_calendar_day_selector_frame);
    a(CalendarSelector.a);
    materialButton1.setText(this.i.d());
    this.m.addOnScrollListener(new RecyclerView.OnScrollListener(this, paramMonthsPagerAdapter, materialButton1) {
          public void onScrollStateChanged(RecyclerView param1RecyclerView, int param1Int) {
            if (param1Int == 0) {
              CharSequence charSequence = this.b.getText();
              if (Build.VERSION.SDK_INT >= 16) {
                param1RecyclerView.announceForAccessibility(charSequence);
                return;
              } 
              param1RecyclerView.sendAccessibilityEvent(2048);
            } 
          }
          
          public void onScrolled(RecyclerView param1RecyclerView, int param1Int1, int param1Int2) {
            if (param1Int1 < 0) {
              param1Int1 = this.c.f().findFirstVisibleItemPosition();
            } else {
              param1Int1 = this.c.f().findLastVisibleItemPosition();
            } 
            MaterialCalendar.a(this.c, this.a.b(param1Int1));
            this.b.setText(this.a.a(param1Int1));
          }
        });
    materialButton1.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.e();
          }
        });
    materialButton3.setOnClickListener(new View.OnClickListener(this, paramMonthsPagerAdapter) {
          public void onClick(View param1View) {
            int i = this.b.f().findFirstVisibleItemPosition() + 1;
            if (i < MaterialCalendar.a(this.b).getAdapter().getItemCount())
              this.b.a(this.a.b(i)); 
          }
        });
    materialButton2.setOnClickListener(new View.OnClickListener(this, paramMonthsPagerAdapter) {
          public void onClick(View param1View) {
            int i = this.b.f().findLastVisibleItemPosition() - 1;
            if (i >= 0)
              this.b.a(this.a.b(i)); 
          }
        });
  }
  
  private RecyclerView.ItemDecoration h() {
    return new RecyclerView.ItemDecoration(this) {
        private final Calendar b = UtcDates.c();
        
        private final Calendar c = UtcDates.c();
        
        public void onDraw(Canvas param1Canvas, RecyclerView param1RecyclerView, RecyclerView.State param1State) {
          if (param1RecyclerView.getAdapter() instanceof YearGridAdapter) {
            if (!(param1RecyclerView.getLayoutManager() instanceof GridLayoutManager))
              return; 
            YearGridAdapter yearGridAdapter = (YearGridAdapter)param1RecyclerView.getAdapter();
            GridLayoutManager gridLayoutManager = (GridLayoutManager)param1RecyclerView.getLayoutManager();
            for (Pair<Long, Long> pair : MaterialCalendar.c(this.a).d()) {
              if (pair.first == null || pair.second == null)
                continue; 
              this.b.setTimeInMillis(((Long)pair.first).longValue());
              this.c.setTimeInMillis(((Long)pair.second).longValue());
              int j = yearGridAdapter.a(this.b.get(1));
              int i = yearGridAdapter.a(this.c.get(1));
              View view1 = gridLayoutManager.findViewByPosition(j);
              View view2 = gridLayoutManager.findViewByPosition(i);
              int k = j / gridLayoutManager.getSpanCount();
              int m = i / gridLayoutManager.getSpanCount();
              for (i = k; i <= m; i++) {
                View view = gridLayoutManager.findViewByPosition(gridLayoutManager.getSpanCount() * i);
                if (view != null) {
                  int n;
                  int i1 = view.getTop();
                  int i2 = (MaterialCalendar.e(this.a)).d.a();
                  int i3 = view.getBottom();
                  int i4 = (MaterialCalendar.e(this.a)).d.b();
                  if (i == k) {
                    j = view1.getLeft() + view1.getWidth() / 2;
                  } else {
                    j = 0;
                  } 
                  if (i == m) {
                    n = view2.getLeft() + view2.getWidth() / 2;
                  } else {
                    n = param1RecyclerView.getWidth();
                  } 
                  param1Canvas.drawRect(j, (i1 + i2), n, (i3 - i4), (MaterialCalendar.e(this.a)).h);
                } 
              } 
            } 
          } 
        }
      };
  }
  
  Month a() {
    return this.i;
  }
  
  void a(CalendarSelector paramCalendarSelector) {
    this.j = paramCalendarSelector;
    if (paramCalendarSelector == CalendarSelector.b) {
      this.l.getLayoutManager().scrollToPosition(((YearGridAdapter)this.l.getAdapter()).a(this.i.b));
      this.n.setVisibility(0);
      this.o.setVisibility(8);
      return;
    } 
    if (paramCalendarSelector == CalendarSelector.a) {
      this.n.setVisibility(8);
      this.o.setVisibility(0);
      a(this.i);
    } 
  }
  
  void a(Month paramMonth) {
    MonthsPagerAdapter monthsPagerAdapter = (MonthsPagerAdapter)this.m.getAdapter();
    int j = monthsPagerAdapter.a(paramMonth);
    int k = j - monthsPagerAdapter.a(this.i);
    int i = Math.abs(k);
    boolean bool = true;
    if (i > 3) {
      i = 1;
    } else {
      i = 0;
    } 
    if (k <= 0)
      bool = false; 
    this.i = paramMonth;
    if (i != 0 && bool) {
      this.m.scrollToPosition(j - 3);
      a(j);
      return;
    } 
    if (i != 0) {
      this.m.scrollToPosition(j + 3);
      a(j);
      return;
    } 
    a(j);
  }
  
  CalendarConstraints b() {
    return this.h;
  }
  
  public DateSelector<S> c() {
    return this.g;
  }
  
  CalendarStyle d() {
    return this.k;
  }
  
  void e() {
    if (this.j == CalendarSelector.b) {
      a(CalendarSelector.a);
      return;
    } 
    if (this.j == CalendarSelector.a)
      a(CalendarSelector.b); 
  }
  
  LinearLayoutManager f() {
    return (LinearLayoutManager)this.m.getLayoutManager();
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    Bundle bundle = paramBundle;
    if (paramBundle == null)
      bundle = getArguments(); 
    this.f = bundle.getInt("THEME_RES_ID_KEY");
    this.g = (DateSelector<S>)bundle.getParcelable("GRID_SELECTOR_KEY");
    this.h = (CalendarConstraints)bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    this.i = (Month)bundle.getParcelable("CURRENT_MONTH_KEY");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    boolean bool;
    ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.f);
    this.k = new CalendarStyle((Context)contextThemeWrapper);
    paramLayoutInflater = paramLayoutInflater.cloneInContext((Context)contextThemeWrapper);
    Month month = this.h.b();
    if (MaterialDatePicker.a((Context)contextThemeWrapper)) {
      i = R.layout.mtrl_calendar_vertical;
      bool = true;
    } else {
      i = R.layout.mtrl_calendar_horizontal;
      bool = false;
    } 
    View view = paramLayoutInflater.inflate(i, paramViewGroup, false);
    GridView gridView = (GridView)view.findViewById(R.id.mtrl_calendar_days_of_week);
    ViewCompat.setAccessibilityDelegate((View)gridView, new AccessibilityDelegateCompat(this) {
          public void onInitializeAccessibilityNodeInfo(View param1View, AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(param1View, param1AccessibilityNodeInfoCompat);
            param1AccessibilityNodeInfoCompat.setCollectionInfo(null);
          }
        });
    gridView.setAdapter((ListAdapter)new DaysOfWeekAdapter());
    gridView.setNumColumns(month.c);
    gridView.setEnabled(false);
    this.m = (RecyclerView)view.findViewById(R.id.mtrl_calendar_months);
    SmoothCalendarLayoutManager smoothCalendarLayoutManager = new SmoothCalendarLayoutManager(this, getContext(), bool, false, bool) {
        public void a(RecyclerView.State param1State, int[] param1ArrayOfint) {
          if (this.a == 0) {
            param1ArrayOfint[0] = MaterialCalendar.a(this.b).getWidth();
            param1ArrayOfint[1] = MaterialCalendar.a(this.b).getWidth();
            return;
          } 
          param1ArrayOfint[0] = MaterialCalendar.a(this.b).getHeight();
          param1ArrayOfint[1] = MaterialCalendar.a(this.b).getHeight();
        }
      };
    this.m.setLayoutManager((RecyclerView.LayoutManager)smoothCalendarLayoutManager);
    this.m.setTag(a);
    MonthsPagerAdapter monthsPagerAdapter = new MonthsPagerAdapter((Context)contextThemeWrapper, this.g, this.h, new OnDayClickListener(this) {
          public void a(long param1Long) {
            if (MaterialCalendar.b(this.a).a().a(param1Long)) {
              MaterialCalendar.c(this.a).a(param1Long);
              Iterator<OnSelectionChangedListener> iterator = this.a.e.iterator();
              while (iterator.hasNext())
                ((OnSelectionChangedListener)iterator.next()).a(MaterialCalendar.c(this.a).a()); 
              MaterialCalendar.a(this.a).getAdapter().notifyDataSetChanged();
              if (MaterialCalendar.d(this.a) != null)
                MaterialCalendar.d(this.a).getAdapter().notifyDataSetChanged(); 
            } 
          }
        });
    this.m.setAdapter(monthsPagerAdapter);
    int i = contextThemeWrapper.getResources().getInteger(R.integer.mtrl_calendar_year_selector_span);
    this.l = (RecyclerView)view.findViewById(R.id.mtrl_calendar_year_selector_frame);
    RecyclerView recyclerView = this.l;
    if (recyclerView != null) {
      recyclerView.setHasFixedSize(true);
      this.l.setLayoutManager((RecyclerView.LayoutManager)new GridLayoutManager((Context)contextThemeWrapper, i, 1, false));
      this.l.setAdapter(new YearGridAdapter(this));
      this.l.addItemDecoration(h());
    } 
    if (view.findViewById(R.id.month_navigation_fragment_toggle) != null)
      a(view, monthsPagerAdapter); 
    if (!MaterialDatePicker.a((Context)contextThemeWrapper))
      (new LinearSnapHelper()).attachToRecyclerView(this.m); 
    this.m.scrollToPosition(monthsPagerAdapter.a(this.i));
    return view;
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putInt("THEME_RES_ID_KEY", this.f);
    paramBundle.putParcelable("GRID_SELECTOR_KEY", this.g);
    paramBundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.h);
    paramBundle.putParcelable("CURRENT_MONTH_KEY", this.i);
  }
  
  enum CalendarSelector {
    a, b;
  }
  
  static interface OnDayClickListener {
    void a(long param1Long);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\datepicker\MaterialCalendar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */