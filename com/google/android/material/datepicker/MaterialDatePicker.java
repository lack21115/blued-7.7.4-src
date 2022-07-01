package com.google.android.material.datepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.R;
import com.google.android.material.dialog.InsetDialogOnTouchListener;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

public final class MaterialDatePicker<S> extends DialogFragment {
  static final Object a = "CONFIRM_BUTTON_TAG";
  
  static final Object b = "CANCEL_BUTTON_TAG";
  
  static final Object c = "TOGGLE_BUTTON_TAG";
  
  private final LinkedHashSet<MaterialPickerOnPositiveButtonClickListener<? super S>> d = new LinkedHashSet<MaterialPickerOnPositiveButtonClickListener<? super S>>();
  
  private final LinkedHashSet<View.OnClickListener> e = new LinkedHashSet<View.OnClickListener>();
  
  private final LinkedHashSet<DialogInterface.OnCancelListener> f = new LinkedHashSet<DialogInterface.OnCancelListener>();
  
  private final LinkedHashSet<DialogInterface.OnDismissListener> g = new LinkedHashSet<DialogInterface.OnDismissListener>();
  
  private int h;
  
  private DateSelector<S> i;
  
  private PickerFragment<S> j;
  
  private CalendarConstraints k;
  
  private MaterialCalendar<S> l;
  
  private int m;
  
  private CharSequence n;
  
  private boolean o;
  
  private int p;
  
  private TextView q;
  
  private CheckableImageButton r;
  
  private MaterialShapeDrawable s;
  
  private Button t;
  
  public static long a() {
    return (Month.a()).e;
  }
  
  private void a(CheckableImageButton paramCheckableImageButton) {
    String str;
    if (this.r.isChecked()) {
      str = paramCheckableImageButton.getContext().getString(R.string.mtrl_picker_toggle_to_calendar_input_mode);
    } else {
      str = str.getContext().getString(R.string.mtrl_picker_toggle_to_text_input_mode);
    } 
    this.r.setContentDescription(str);
  }
  
  static boolean a(Context paramContext) {
    TypedArray typedArray = paramContext.obtainStyledAttributes(MaterialAttributes.a(paramContext, R.attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), new int[] { 16843277 });
    boolean bool = typedArray.getBoolean(0, false);
    typedArray.recycle();
    return bool;
  }
  
  private int b(Context paramContext) {
    int i = this.h;
    return (i != 0) ? i : this.i.b(paramContext);
  }
  
  private void c(Context paramContext) {
    boolean bool;
    this.r.setTag(c);
    this.r.setImageDrawable(d(paramContext));
    CheckableImageButton checkableImageButton = this.r;
    if (this.p != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    checkableImageButton.setChecked(bool);
    ViewCompat.setAccessibilityDelegate((View)this.r, null);
    a(this.r);
    this.r.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            MaterialDatePicker.e(this.a).setEnabled(MaterialDatePicker.d(this.a).b());
            MaterialDatePicker.f(this.a).toggle();
            MaterialDatePicker materialDatePicker = this.a;
            MaterialDatePicker.a(materialDatePicker, MaterialDatePicker.f(materialDatePicker));
            MaterialDatePicker.g(this.a);
          }
        });
  }
  
  private static Drawable d(Context paramContext) {
    StateListDrawable stateListDrawable = new StateListDrawable();
    Drawable drawable2 = AppCompatResources.getDrawable(paramContext, R.drawable.material_ic_calendar_black_24dp);
    stateListDrawable.addState(new int[] { 16842912 }, drawable2);
    Drawable drawable1 = AppCompatResources.getDrawable(paramContext, R.drawable.material_ic_edit_black_24dp);
    stateListDrawable.addState(new int[0], drawable1);
    return (Drawable)stateListDrawable;
  }
  
  private void d() {
    String str = b();
    this.q.setContentDescription(String.format(getString(R.string.mtrl_picker_announce_current_selection), new Object[] { str }));
    this.q.setText(str);
  }
  
  private static int e(Context paramContext) {
    Resources resources = paramContext.getResources();
    return resources.getDimensionPixelSize(R.dimen.mtrl_calendar_navigation_height) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_bottom_padding) + resources.getDimensionPixelSize(R.dimen.mtrl_calendar_days_of_week_height) + MonthAdapter.a * resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) + (MonthAdapter.a - 1) * resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_vertical_padding) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_bottom_padding);
  }
  
  private void e() {
    MaterialCalendar<S> materialCalendar;
    this.l = MaterialCalendar.a(this.i, b(requireContext()), this.k);
    if (this.r.isChecked()) {
      MaterialTextInputPicker<S> materialTextInputPicker = MaterialTextInputPicker.a(this.i, this.k);
    } else {
      materialCalendar = this.l;
    } 
    this.j = materialCalendar;
    d();
    FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
    fragmentTransaction.replace(R.id.mtrl_calendar_frame, this.j);
    fragmentTransaction.commitNow();
    this.j.a(new OnSelectionChangedListener<S>(this) {
          void a() {
            MaterialDatePicker.e(this.a).setEnabled(false);
          }
          
          public void a(S param1S) {
            MaterialDatePicker.c(this.a);
            MaterialDatePicker.e(this.a).setEnabled(MaterialDatePicker.d(this.a).b());
          }
        });
  }
  
  private static int f(Context paramContext) {
    Resources resources = paramContext.getResources();
    int i = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_content_padding);
    int j = (Month.a()).c;
    return i * 2 + resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_width) * j + (j - 1) * resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_horizontal_padding);
  }
  
  public String b() {
    return this.i.a(getContext());
  }
  
  public final S c() {
    return this.i.a();
  }
  
  public final void onCancel(DialogInterface paramDialogInterface) {
    Iterator<DialogInterface.OnCancelListener> iterator = this.f.iterator();
    while (iterator.hasNext())
      ((DialogInterface.OnCancelListener)iterator.next()).onCancel(paramDialogInterface); 
    super.onCancel(paramDialogInterface);
  }
  
  public final void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    Bundle bundle = paramBundle;
    if (paramBundle == null)
      bundle = getArguments(); 
    this.h = bundle.getInt("OVERRIDE_THEME_RES_ID");
    this.i = (DateSelector<S>)bundle.getParcelable("DATE_SELECTOR_KEY");
    this.k = (CalendarConstraints)bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    this.m = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
    this.n = bundle.getCharSequence("TITLE_TEXT_KEY");
    this.p = bundle.getInt("INPUT_MODE_KEY");
  }
  
  public final Dialog onCreateDialog(Bundle paramBundle) {
    Dialog dialog = new Dialog(requireContext(), b(requireContext()));
    Context context = dialog.getContext();
    this.o = a(context);
    int i = MaterialAttributes.a(context, R.attr.colorSurface, MaterialDatePicker.class.getCanonicalName());
    this.s = new MaterialShapeDrawable(context, null, R.attr.materialCalendarStyle, R.style.Widget_MaterialComponents_MaterialCalendar);
    this.s.a(context);
    this.s.g(ColorStateList.valueOf(i));
    this.s.r(ViewCompat.getElevation(dialog.getWindow().getDecorView()));
    return dialog;
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    int i;
    if (this.o) {
      i = R.layout.mtrl_picker_fullscreen;
    } else {
      i = R.layout.mtrl_picker_dialog;
    } 
    View view = paramLayoutInflater.inflate(i, paramViewGroup);
    Context context = view.getContext();
    if (this.o) {
      view.findViewById(R.id.mtrl_calendar_frame).setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(f(context), -2));
    } else {
      View view1 = view.findViewById(R.id.mtrl_calendar_main_pane);
      View view2 = view.findViewById(R.id.mtrl_calendar_frame);
      view1.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(f(context), -1));
      view2.setMinimumHeight(e(requireContext()));
    } 
    this.q = (TextView)view.findViewById(R.id.mtrl_picker_header_selection_text);
    ViewCompat.setAccessibilityLiveRegion((View)this.q, 1);
    this.r = (CheckableImageButton)view.findViewById(R.id.mtrl_picker_header_toggle);
    TextView textView = (TextView)view.findViewById(R.id.mtrl_picker_title_text);
    CharSequence charSequence = this.n;
    if (charSequence != null) {
      textView.setText(charSequence);
    } else {
      textView.setText(this.m);
    } 
    c(context);
    this.t = (Button)view.findViewById(R.id.confirm_button);
    if (this.i.b()) {
      this.t.setEnabled(true);
    } else {
      this.t.setEnabled(false);
    } 
    this.t.setTag(a);
    this.t.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            Iterator<MaterialPickerOnPositiveButtonClickListener> iterator = MaterialDatePicker.a(this.a).iterator();
            while (iterator.hasNext())
              ((MaterialPickerOnPositiveButtonClickListener)iterator.next()).a(this.a.c()); 
            this.a.dismiss();
          }
        });
    Button button = (Button)view.findViewById(R.id.cancel_button);
    button.setTag(b);
    button.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            Iterator<View.OnClickListener> iterator = MaterialDatePicker.b(this.a).iterator();
            while (iterator.hasNext())
              ((View.OnClickListener)iterator.next()).onClick(param1View); 
            this.a.dismiss();
          }
        });
    return view;
  }
  
  public final void onDismiss(DialogInterface paramDialogInterface) {
    Iterator<DialogInterface.OnDismissListener> iterator = this.g.iterator();
    while (iterator.hasNext())
      ((DialogInterface.OnDismissListener)iterator.next()).onDismiss(paramDialogInterface); 
    ViewGroup viewGroup = (ViewGroup)getView();
    if (viewGroup != null)
      viewGroup.removeAllViews(); 
    super.onDismiss(paramDialogInterface);
  }
  
  public final void onSaveInstanceState(Bundle paramBundle) {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putInt("OVERRIDE_THEME_RES_ID", this.h);
    paramBundle.putParcelable("DATE_SELECTOR_KEY", this.i);
    CalendarConstraints.Builder builder = new CalendarConstraints.Builder(this.k);
    if (this.l.a() != null)
      builder.a((this.l.a()).e); 
    paramBundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", builder.a());
    paramBundle.putInt("TITLE_TEXT_RES_ID_KEY", this.m);
    paramBundle.putCharSequence("TITLE_TEXT_KEY", this.n);
  }
  
  public void onStart() {
    super.onStart();
    Window window = requireDialog().getWindow();
    if (this.o) {
      window.setLayout(-1, -1);
      window.setBackgroundDrawable((Drawable)this.s);
    } else {
      window.setLayout(-2, -2);
      int i = getResources().getDimensionPixelOffset(R.dimen.mtrl_calendar_dialog_background_inset);
      Rect rect = new Rect(i, i, i, i);
      window.setBackgroundDrawable((Drawable)new InsetDrawable((Drawable)this.s, i, i, i, i));
      window.getDecorView().setOnTouchListener((View.OnTouchListener)new InsetDialogOnTouchListener(requireDialog(), rect));
    } 
    e();
  }
  
  public void onStop() {
    this.j.g();
    super.onStop();
  }
  
  public static final class Builder<S> {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface InputMode {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\datepicker\MaterialDatePicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */