package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.core.view.ViewCompat;
import androidx.cursoradapter.widget.CursorAdapter;
import androidx.customview.view.AbsSavedState;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class SearchView extends LinearLayoutCompat implements CollapsibleActionView {
  static final AutoCompleteTextViewReflector i = new AutoCompleteTextViewReflector();
  
  private OnQueryTextListener A;
  
  private OnCloseListener B;
  
  private OnSuggestionListener C;
  
  private View.OnClickListener D;
  
  private boolean E;
  
  private boolean F;
  
  private boolean G;
  
  private CharSequence H;
  
  private boolean I;
  
  private boolean J;
  
  private int K;
  
  private boolean L;
  
  private CharSequence M;
  
  private CharSequence N;
  
  private boolean O;
  
  private int P;
  
  private Bundle Q;
  
  private final Runnable R = new Runnable(this) {
      public void run() {
        this.a.a();
      }
    };
  
  private Runnable S = new Runnable(this) {
      public void run() {
        if (this.a.g instanceof SuggestionsAdapter)
          this.a.g.changeCursor(null); 
      }
    };
  
  private final WeakHashMap<String, Drawable.ConstantState> T = new WeakHashMap<String, Drawable.ConstantState>();
  
  private final View.OnClickListener U = new View.OnClickListener(this) {
      public void onClick(View param1View) {
        if (param1View == this.a.b) {
          this.a.e();
          return;
        } 
        if (param1View == this.a.d) {
          this.a.d();
          return;
        } 
        if (param1View == this.a.c) {
          this.a.c();
          return;
        } 
        if (param1View == this.a.e) {
          this.a.f();
          return;
        } 
        if (param1View == this.a.a)
          this.a.i(); 
      }
    };
  
  private final TextView.OnEditorActionListener V = new TextView.OnEditorActionListener(this) {
      public boolean onEditorAction(TextView param1TextView, int param1Int, KeyEvent param1KeyEvent) {
        this.a.c();
        return true;
      }
    };
  
  private final AdapterView.OnItemClickListener W = new AdapterView.OnItemClickListener(this) {
      public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
        this.a.a(param1Int, 0, (String)null);
      }
    };
  
  final SearchAutoComplete a;
  
  private final AdapterView.OnItemSelectedListener aa = new AdapterView.OnItemSelectedListener(this) {
      public void onItemSelected(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
        this.a.a(param1Int);
      }
      
      public void onNothingSelected(AdapterView<?> param1AdapterView) {}
    };
  
  private TextWatcher ab = new TextWatcher(this) {
      public void afterTextChanged(Editable param1Editable) {}
      
      public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
      
      public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {
        this.a.b(param1CharSequence);
      }
    };
  
  final ImageView b;
  
  final ImageView c;
  
  final ImageView d;
  
  final ImageView e;
  
  View.OnFocusChangeListener f;
  
  CursorAdapter g;
  
  SearchableInfo h;
  
  View.OnKeyListener j = new View.OnKeyListener(this) {
      public boolean onKey(View param1View, int param1Int, KeyEvent param1KeyEvent) {
        if (this.a.h == null)
          return false; 
        if (this.a.a.isPopupShowing() && this.a.a.getListSelection() != -1)
          return this.a.a(param1View, param1Int, param1KeyEvent); 
        if (!this.a.a.a() && param1KeyEvent.hasNoModifiers() && param1KeyEvent.getAction() == 1 && param1Int == 66) {
          param1View.cancelLongPress();
          SearchView searchView = this.a;
          searchView.a(0, (String)null, searchView.a.getText().toString());
          return true;
        } 
        return false;
      }
    };
  
  private final View k;
  
  private final View l;
  
  private final View m;
  
  private final View n;
  
  private UpdatableTouchDelegate o;
  
  private Rect p = new Rect();
  
  private Rect q = new Rect();
  
  private int[] r = new int[2];
  
  private int[] s = new int[2];
  
  private final ImageView t;
  
  private final Drawable u;
  
  private final int v;
  
  private final int w;
  
  private final Intent x;
  
  private final Intent y;
  
  private final CharSequence z;
  
  public SearchView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public SearchView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.searchViewStyle);
  }
  
  public SearchView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.SearchView, paramInt, 0);
    LayoutInflater.from(paramContext).inflate(tintTypedArray.getResourceId(R.styleable.SearchView_layout, R.layout.abc_search_view), this, true);
    this.a = (SearchAutoComplete)findViewById(R.id.search_src_text);
    this.a.setSearchView(this);
    this.k = findViewById(R.id.search_edit_frame);
    this.l = findViewById(R.id.search_plate);
    this.m = findViewById(R.id.submit_area);
    this.b = (ImageView)findViewById(R.id.search_button);
    this.c = (ImageView)findViewById(R.id.search_go_btn);
    this.d = (ImageView)findViewById(R.id.search_close_btn);
    this.e = (ImageView)findViewById(R.id.search_voice_btn);
    this.t = (ImageView)findViewById(R.id.search_mag_icon);
    ViewCompat.setBackground(this.l, tintTypedArray.getDrawable(R.styleable.SearchView_queryBackground));
    ViewCompat.setBackground(this.m, tintTypedArray.getDrawable(R.styleable.SearchView_submitBackground));
    this.b.setImageDrawable(tintTypedArray.getDrawable(R.styleable.SearchView_searchIcon));
    this.c.setImageDrawable(tintTypedArray.getDrawable(R.styleable.SearchView_goIcon));
    this.d.setImageDrawable(tintTypedArray.getDrawable(R.styleable.SearchView_closeIcon));
    this.e.setImageDrawable(tintTypedArray.getDrawable(R.styleable.SearchView_voiceIcon));
    this.t.setImageDrawable(tintTypedArray.getDrawable(R.styleable.SearchView_searchIcon));
    this.u = tintTypedArray.getDrawable(R.styleable.SearchView_searchHintIcon);
    TooltipCompat.setTooltipText((View)this.b, getResources().getString(R.string.abc_searchview_description_search));
    this.v = tintTypedArray.getResourceId(R.styleable.SearchView_suggestionRowLayout, R.layout.abc_search_dropdown_item_icons_2line);
    this.w = tintTypedArray.getResourceId(R.styleable.SearchView_commitIcon, 0);
    this.b.setOnClickListener(this.U);
    this.d.setOnClickListener(this.U);
    this.c.setOnClickListener(this.U);
    this.e.setOnClickListener(this.U);
    this.a.setOnClickListener(this.U);
    this.a.addTextChangedListener(this.ab);
    this.a.setOnEditorActionListener(this.V);
    this.a.setOnItemClickListener(this.W);
    this.a.setOnItemSelectedListener(this.aa);
    this.a.setOnKeyListener(this.j);
    this.a.setOnFocusChangeListener(new View.OnFocusChangeListener(this) {
          public void onFocusChange(View param1View, boolean param1Boolean) {
            if (this.a.f != null)
              this.a.f.onFocusChange((View)this.a, param1Boolean); 
          }
        });
    setIconifiedByDefault(tintTypedArray.getBoolean(R.styleable.SearchView_iconifiedByDefault, true));
    paramInt = tintTypedArray.getDimensionPixelSize(R.styleable.SearchView_android_maxWidth, -1);
    if (paramInt != -1)
      setMaxWidth(paramInt); 
    this.z = tintTypedArray.getText(R.styleable.SearchView_defaultQueryHint);
    this.H = tintTypedArray.getText(R.styleable.SearchView_queryHint);
    paramInt = tintTypedArray.getInt(R.styleable.SearchView_android_imeOptions, -1);
    if (paramInt != -1)
      setImeOptions(paramInt); 
    paramInt = tintTypedArray.getInt(R.styleable.SearchView_android_inputType, -1);
    if (paramInt != -1)
      setInputType(paramInt); 
    setFocusable(tintTypedArray.getBoolean(R.styleable.SearchView_android_focusable, true));
    tintTypedArray.recycle();
    this.x = new Intent("android.speech.action.WEB_SEARCH");
    this.x.addFlags(268435456);
    this.x.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
    this.y = new Intent("android.speech.action.RECOGNIZE_SPEECH");
    this.y.addFlags(268435456);
    this.n = findViewById(this.a.getDropDownAnchor());
    View view = this.n;
    if (view != null)
      view.addOnLayoutChangeListener(new View.OnLayoutChangeListener(this) {
            public void onLayoutChange(View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4, int param1Int5, int param1Int6, int param1Int7, int param1Int8) {
              this.a.h();
            }
          }); 
    a(this.E);
    o();
  }
  
  private Intent a(Intent paramIntent, SearchableInfo paramSearchableInfo) {
    String str;
    Intent intent = new Intent(paramIntent);
    ComponentName componentName = paramSearchableInfo.getSearchActivity();
    if (componentName == null) {
      componentName = null;
    } else {
      str = componentName.flattenToShortString();
    } 
    intent.putExtra("calling_package", str);
    return intent;
  }
  
  private Intent a(Cursor paramCursor, int paramInt, String paramString) {
    StringBuilder stringBuilder;
    try {
      String str = SuggestionsAdapter.getColumnString(paramCursor, "suggest_intent_action");
      str1 = str;
      if (str == null)
        str1 = this.h.getSuggestIntentAction(); 
    } catch (RuntimeException runtimeException) {
      try {
        paramInt = paramCursor.getPosition();
      } catch (RuntimeException runtimeException1) {
        paramInt = -1;
      } 
      stringBuilder = new StringBuilder();
      stringBuilder.append("Search suggestions cursor at row ");
      stringBuilder.append(paramInt);
      stringBuilder.append(" returned exception.");
      Log.w("SearchView", stringBuilder.toString(), runtimeException);
      return null;
    } 
    String str2 = str1;
    if (str1 == null)
      str2 = "android.intent.action.SEARCH"; 
    String str3 = SuggestionsAdapter.getColumnString((Cursor)stringBuilder, "suggest_intent_data");
    String str1 = str3;
    if (str3 == null)
      str1 = this.h.getSuggestIntentData(); 
    str3 = str1;
    if (str1 != null) {
      String str = SuggestionsAdapter.getColumnString((Cursor)stringBuilder, "suggest_intent_data_id");
      str3 = str1;
      if (str != null) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str1);
        stringBuilder1.append("/");
        stringBuilder1.append(Uri.encode(str));
        str3 = stringBuilder1.toString();
      } 
    } 
    if (str3 == null) {
      str1 = null;
      str3 = SuggestionsAdapter.getColumnString((Cursor)stringBuilder, "suggest_intent_query");
      return a(str2, (Uri)str1, SuggestionsAdapter.getColumnString((Cursor)stringBuilder, "suggest_intent_extra_data"), str3, paramInt, (String)runtimeException);
    } 
    Uri uri = Uri.parse(str3);
    str3 = SuggestionsAdapter.getColumnString((Cursor)stringBuilder, "suggest_intent_query");
    return a(str2, uri, SuggestionsAdapter.getColumnString((Cursor)stringBuilder, "suggest_intent_extra_data"), str3, paramInt, (String)runtimeException);
  }
  
  private Intent a(String paramString1, Uri paramUri, String paramString2, String paramString3, int paramInt, String paramString4) {
    Intent intent = new Intent(paramString1);
    intent.addFlags(268435456);
    if (paramUri != null)
      intent.setData(paramUri); 
    intent.putExtra("user_query", this.N);
    if (paramString3 != null)
      intent.putExtra("query", paramString3); 
    if (paramString2 != null)
      intent.putExtra("intent_extra_data_key", paramString2); 
    Bundle bundle = this.Q;
    if (bundle != null)
      intent.putExtra("app_data", bundle); 
    if (paramInt != 0) {
      intent.putExtra("action_key", paramInt);
      intent.putExtra("action_msg", paramString4);
    } 
    intent.setComponent(this.h.getSearchActivity());
    return intent;
  }
  
  private void a(Intent paramIntent) {
    if (paramIntent == null)
      return; 
    try {
      getContext().startActivity(paramIntent);
      return;
    } catch (RuntimeException runtimeException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Failed launch activity: ");
      stringBuilder.append(paramIntent);
      Log.e("SearchView", stringBuilder.toString(), runtimeException);
      return;
    } 
  }
  
  private void a(View paramView, Rect paramRect) {
    paramView.getLocationInWindow(this.r);
    getLocationInWindow(this.s);
    int[] arrayOfInt1 = this.r;
    int i = arrayOfInt1[1];
    int[] arrayOfInt2 = this.s;
    i -= arrayOfInt2[1];
    int j = arrayOfInt1[0] - arrayOfInt2[0];
    paramRect.set(j, i, paramView.getWidth() + j, paramView.getHeight() + i);
  }
  
  private void a(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: putfield F : Z
    //   5: iconst_0
    //   6: istore_3
    //   7: iload_1
    //   8: ifeq -> 16
    //   11: iconst_0
    //   12: istore_2
    //   13: goto -> 19
    //   16: bipush #8
    //   18: istore_2
    //   19: aload_0
    //   20: getfield a : Landroidx/appcompat/widget/SearchView$SearchAutoComplete;
    //   23: invokevirtual getText : ()Landroid/text/Editable;
    //   26: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   29: iconst_1
    //   30: ixor
    //   31: istore #4
    //   33: aload_0
    //   34: getfield b : Landroid/widget/ImageView;
    //   37: iload_2
    //   38: invokevirtual setVisibility : (I)V
    //   41: aload_0
    //   42: iload #4
    //   44: invokespecial b : (Z)V
    //   47: aload_0
    //   48: getfield k : Landroid/view/View;
    //   51: astore #5
    //   53: iload_1
    //   54: ifeq -> 63
    //   57: bipush #8
    //   59: istore_2
    //   60: goto -> 65
    //   63: iconst_0
    //   64: istore_2
    //   65: aload #5
    //   67: iload_2
    //   68: invokevirtual setVisibility : (I)V
    //   71: aload_0
    //   72: getfield t : Landroid/widget/ImageView;
    //   75: invokevirtual getDrawable : ()Landroid/graphics/drawable/Drawable;
    //   78: ifnull -> 90
    //   81: iload_3
    //   82: istore_2
    //   83: aload_0
    //   84: getfield E : Z
    //   87: ifeq -> 93
    //   90: bipush #8
    //   92: istore_2
    //   93: aload_0
    //   94: getfield t : Landroid/widget/ImageView;
    //   97: iload_2
    //   98: invokevirtual setVisibility : (I)V
    //   101: aload_0
    //   102: invokespecial m : ()V
    //   105: aload_0
    //   106: iload #4
    //   108: iconst_1
    //   109: ixor
    //   110: invokespecial c : (Z)V
    //   113: aload_0
    //   114: invokespecial l : ()V
    //   117: return
  }
  
  static boolean a(Context paramContext) {
    return ((paramContext.getResources().getConfiguration()).orientation == 2);
  }
  
  private Intent b(Intent paramIntent, SearchableInfo paramSearchableInfo) {
    String str1;
    ComponentName componentName = paramSearchableInfo.getSearchActivity();
    Intent intent1 = new Intent("android.intent.action.SEARCH");
    intent1.setComponent(componentName);
    PendingIntent pendingIntent = PendingIntent.getActivity(getContext(), 0, intent1, 1073741824);
    Bundle bundle2 = new Bundle();
    Bundle bundle1 = this.Q;
    if (bundle1 != null)
      bundle2.putParcelable("app_data", (Parcelable)bundle1); 
    Intent intent2 = new Intent(paramIntent);
    int i = 1;
    Resources resources = getResources();
    if (paramSearchableInfo.getVoiceLanguageModeId() != 0) {
      str1 = resources.getString(paramSearchableInfo.getVoiceLanguageModeId());
    } else {
      str1 = "free_form";
    } 
    int j = paramSearchableInfo.getVoicePromptTextId();
    String str2 = null;
    if (j != 0) {
      String str = resources.getString(paramSearchableInfo.getVoicePromptTextId());
    } else {
      bundle1 = null;
    } 
    if (paramSearchableInfo.getVoiceLanguageId() != 0) {
      String str = resources.getString(paramSearchableInfo.getVoiceLanguageId());
    } else {
      resources = null;
    } 
    if (paramSearchableInfo.getVoiceMaxResults() != 0)
      i = paramSearchableInfo.getVoiceMaxResults(); 
    intent2.putExtra("android.speech.extra.LANGUAGE_MODEL", str1);
    intent2.putExtra("android.speech.extra.PROMPT", (String)bundle1);
    intent2.putExtra("android.speech.extra.LANGUAGE", (String)resources);
    intent2.putExtra("android.speech.extra.MAX_RESULTS", i);
    if (componentName == null) {
      str1 = str2;
    } else {
      str1 = componentName.flattenToShortString();
    } 
    intent2.putExtra("calling_package", str1);
    intent2.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", (Parcelable)pendingIntent);
    intent2.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle2);
    return intent2;
  }
  
  private void b(boolean paramBoolean) {
    byte b;
    if (this.G && k() && hasFocus() && (paramBoolean || !this.L)) {
      b = 0;
    } else {
      b = 8;
    } 
    this.c.setVisibility(b);
  }
  
  private boolean b(int paramInt1, int paramInt2, String paramString) {
    Cursor cursor = this.g.getCursor();
    if (cursor != null && cursor.moveToPosition(paramInt1)) {
      a(a(cursor, paramInt2, paramString));
      return true;
    } 
    return false;
  }
  
  private CharSequence c(CharSequence paramCharSequence) {
    if (this.E) {
      if (this.u == null)
        return paramCharSequence; 
      int i = (int)(this.a.getTextSize() * 1.25D);
      this.u.setBounds(0, 0, i, i);
      SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
      spannableStringBuilder.setSpan(new ImageSpan(this.u), 1, 2, 33);
      spannableStringBuilder.append(paramCharSequence);
      return (CharSequence)spannableStringBuilder;
    } 
    return paramCharSequence;
  }
  
  private void c(boolean paramBoolean) {
    byte b;
    if (this.L && !isIconified() && paramBoolean) {
      b = 0;
      this.c.setVisibility(8);
    } else {
      b = 8;
    } 
    this.e.setVisibility(b);
  }
  
  private void e(int paramInt) {
    Editable editable = this.a.getText();
    Cursor cursor = this.g.getCursor();
    if (cursor == null)
      return; 
    if (cursor.moveToPosition(paramInt)) {
      CharSequence charSequence = this.g.convertToString(cursor);
      if (charSequence != null) {
        setQuery(charSequence);
        return;
      } 
      setQuery((CharSequence)editable);
      return;
    } 
    setQuery((CharSequence)editable);
  }
  
  private int getPreferredHeight() {
    return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_height);
  }
  
  private int getPreferredWidth() {
    return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
  }
  
  private boolean j() {
    SearchableInfo searchableInfo = this.h;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (searchableInfo != null) {
      bool1 = bool2;
      if (searchableInfo.getVoiceSearchEnabled()) {
        Intent intent;
        searchableInfo = null;
        if (this.h.getVoiceSearchLaunchWebSearch()) {
          intent = this.x;
        } else if (this.h.getVoiceSearchLaunchRecognizer()) {
          intent = this.y;
        } 
        bool1 = bool2;
        if (intent != null) {
          bool1 = bool2;
          if (getContext().getPackageManager().resolveActivity(intent, 65536) != null)
            bool1 = true; 
        } 
      } 
    } 
    return bool1;
  }
  
  private boolean k() {
    return ((this.G || this.L) && !isIconified());
  }
  
  private void l() {
    byte b;
    if (k() && (this.c.getVisibility() == 0 || this.e.getVisibility() == 0)) {
      b = 0;
    } else {
      b = 8;
    } 
    this.m.setVisibility(b);
  }
  
  private void m() {
    boolean bool = TextUtils.isEmpty((CharSequence)this.a.getText());
    byte b3 = 1;
    int i = bool ^ true;
    byte b2 = 0;
    byte b1 = b3;
    if (i == 0)
      if (this.E && !this.O) {
        b1 = b3;
      } else {
        b1 = 0;
      }  
    ImageView imageView = this.d;
    if (b1) {
      b1 = b2;
    } else {
      b1 = 8;
    } 
    imageView.setVisibility(b1);
    Drawable drawable = this.d.getDrawable();
    if (drawable != null) {
      int[] arrayOfInt;
      if (i != 0) {
        arrayOfInt = ENABLED_STATE_SET;
      } else {
        arrayOfInt = EMPTY_STATE_SET;
      } 
      drawable.setState(arrayOfInt);
    } 
  }
  
  private void n() {
    post(this.R);
  }
  
  private void o() {
    CharSequence charSequence2 = getQueryHint();
    SearchAutoComplete searchAutoComplete = this.a;
    CharSequence charSequence1 = charSequence2;
    if (charSequence2 == null)
      charSequence1 = ""; 
    searchAutoComplete.setHint(c(charSequence1));
  }
  
  private void p() {
    this.a.setThreshold(this.h.getSuggestThreshold());
    this.a.setImeOptions(this.h.getImeOptions());
    int j = this.h.getInputType();
    boolean bool = true;
    int i = j;
    if ((j & 0xF) == 1) {
      j &= 0xFFFEFFFF;
      i = j;
      if (this.h.getSuggestAuthority() != null)
        i = j | 0x10000 | 0x80000; 
    } 
    this.a.setInputType(i);
    CursorAdapter cursorAdapter = this.g;
    if (cursorAdapter != null)
      cursorAdapter.changeCursor(null); 
    if (this.h.getSuggestAuthority() != null) {
      this.g = (CursorAdapter)new SuggestionsAdapter(getContext(), this, this.h, this.T);
      this.a.setAdapter((ListAdapter)this.g);
      SuggestionsAdapter suggestionsAdapter = (SuggestionsAdapter)this.g;
      i = bool;
      if (this.I)
        i = 2; 
      suggestionsAdapter.setQueryRefinement(i);
    } 
  }
  
  private void q() {
    this.a.dismissDropDown();
  }
  
  private void setQuery(CharSequence paramCharSequence) {
    int i;
    this.a.setText(paramCharSequence);
    SearchAutoComplete searchAutoComplete = this.a;
    if (TextUtils.isEmpty(paramCharSequence)) {
      i = 0;
    } else {
      i = paramCharSequence.length();
    } 
    searchAutoComplete.setSelection(i);
  }
  
  void a() {
    int[] arrayOfInt;
    if (this.a.hasFocus()) {
      arrayOfInt = FOCUSED_STATE_SET;
    } else {
      arrayOfInt = EMPTY_STATE_SET;
    } 
    Drawable drawable = this.l.getBackground();
    if (drawable != null)
      drawable.setState(arrayOfInt); 
    drawable = this.m.getBackground();
    if (drawable != null)
      drawable.setState(arrayOfInt); 
    invalidate();
  }
  
  void a(int paramInt, String paramString1, String paramString2) {
    Intent intent = a("android.intent.action.SEARCH", (Uri)null, (String)null, paramString2, paramInt, paramString1);
    getContext().startActivity(intent);
  }
  
  void a(CharSequence paramCharSequence) {
    setQuery(paramCharSequence);
  }
  
  boolean a(int paramInt) {
    OnSuggestionListener onSuggestionListener = this.C;
    if (onSuggestionListener == null || !onSuggestionListener.onSuggestionSelect(paramInt)) {
      e(paramInt);
      return true;
    } 
    return false;
  }
  
  boolean a(int paramInt1, int paramInt2, String paramString) {
    OnSuggestionListener onSuggestionListener = this.C;
    if (onSuggestionListener == null || !onSuggestionListener.onSuggestionClick(paramInt1)) {
      b(paramInt1, 0, (String)null);
      this.a.setImeVisibility(false);
      q();
      return true;
    } 
    return false;
  }
  
  boolean a(View paramView, int paramInt, KeyEvent paramKeyEvent) {
    if (this.h == null)
      return false; 
    if (this.g == null)
      return false; 
    if (paramKeyEvent.getAction() == 0 && paramKeyEvent.hasNoModifiers()) {
      if (paramInt == 66 || paramInt == 84 || paramInt == 61)
        return a(this.a.getListSelection(), 0, (String)null); 
      if (paramInt == 21 || paramInt == 22) {
        if (paramInt == 21) {
          paramInt = 0;
        } else {
          paramInt = this.a.length();
        } 
        this.a.setSelection(paramInt);
        this.a.setListSelection(0);
        this.a.clearListSelection();
        i.a(this.a, true);
        return true;
      } 
      if (paramInt == 19 && this.a.getListSelection() == 0)
        return false; 
    } 
    return false;
  }
  
  void b(CharSequence paramCharSequence) {
    Editable editable = this.a.getText();
    this.N = (CharSequence)editable;
    int i = TextUtils.isEmpty((CharSequence)editable) ^ true;
    b(i);
    c(i ^ 0x1);
    m();
    l();
    if (this.A != null && !TextUtils.equals(paramCharSequence, this.M))
      this.A.onQueryTextChange(paramCharSequence.toString()); 
    this.M = paramCharSequence.toString();
  }
  
  void c() {
    Editable editable = this.a.getText();
    if (editable != null && TextUtils.getTrimmedLength((CharSequence)editable) > 0) {
      OnQueryTextListener onQueryTextListener = this.A;
      if (onQueryTextListener == null || !onQueryTextListener.onQueryTextSubmit(editable.toString())) {
        if (this.h != null)
          a(0, (String)null, editable.toString()); 
        this.a.setImeVisibility(false);
        q();
      } 
    } 
  }
  
  public void clearFocus() {
    this.J = true;
    super.clearFocus();
    this.a.clearFocus();
    this.a.setImeVisibility(false);
    this.J = false;
  }
  
  void d() {
    if (TextUtils.isEmpty((CharSequence)this.a.getText())) {
      if (this.E) {
        OnCloseListener onCloseListener = this.B;
        if (onCloseListener == null || !onCloseListener.onClose()) {
          clearFocus();
          a(true);
          return;
        } 
      } 
    } else {
      this.a.setText("");
      this.a.requestFocus();
      this.a.setImeVisibility(true);
    } 
  }
  
  void e() {
    a(false);
    this.a.requestFocus();
    this.a.setImeVisibility(true);
    View.OnClickListener onClickListener = this.D;
    if (onClickListener != null)
      onClickListener.onClick((View)this); 
  }
  
  void f() {
    SearchableInfo searchableInfo = this.h;
    if (searchableInfo == null)
      return; 
    try {
      Intent intent;
      if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
        intent = a(this.x, searchableInfo);
        getContext().startActivity(intent);
        return;
      } 
      if (intent.getVoiceSearchLaunchRecognizer()) {
        intent = b(this.y, (SearchableInfo)intent);
        getContext().startActivity(intent);
        return;
      } 
    } catch (ActivityNotFoundException activityNotFoundException) {
      Log.w("SearchView", "Could not find voice search activity");
    } 
  }
  
  void g() {
    a(isIconified());
    n();
    if (this.a.hasFocus())
      i(); 
  }
  
  public int getImeOptions() {
    return this.a.getImeOptions();
  }
  
  public int getInputType() {
    return this.a.getInputType();
  }
  
  public int getMaxWidth() {
    return this.K;
  }
  
  public CharSequence getQuery() {
    return (CharSequence)this.a.getText();
  }
  
  public CharSequence getQueryHint() {
    CharSequence charSequence = this.H;
    if (charSequence != null)
      return charSequence; 
    SearchableInfo searchableInfo = this.h;
    return (searchableInfo != null && searchableInfo.getHintId() != 0) ? getContext().getText(this.h.getHintId()) : this.z;
  }
  
  int getSuggestionCommitIconResId() {
    return this.w;
  }
  
  int getSuggestionRowLayout() {
    return this.v;
  }
  
  public CursorAdapter getSuggestionsAdapter() {
    return this.g;
  }
  
  void h() {
    if (this.n.getWidth() > 1) {
      byte b;
      Resources resources = getContext().getResources();
      int j = this.l.getPaddingLeft();
      Rect rect = new Rect();
      boolean bool = ViewUtils.isLayoutRtl((View)this);
      if (this.E) {
        b = resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width) + resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left);
      } else {
        b = 0;
      } 
      this.a.getDropDownBackground().getPadding(rect);
      if (bool) {
        i = -rect.left;
      } else {
        i = j - rect.left + b;
      } 
      this.a.setDropDownHorizontalOffset(i);
      int i = this.n.getWidth();
      int k = rect.left;
      int m = rect.right;
      this.a.setDropDownWidth(i + k + m + b - j);
    } 
  }
  
  void i() {
    if (Build.VERSION.SDK_INT >= 29) {
      this.a.refreshAutoCompleteResults();
      return;
    } 
    i.a(this.a);
    i.b(this.a);
  }
  
  public boolean isIconfiedByDefault() {
    return this.E;
  }
  
  public boolean isIconified() {
    return this.F;
  }
  
  public boolean isQueryRefinementEnabled() {
    return this.I;
  }
  
  public boolean isSubmitButtonEnabled() {
    return this.G;
  }
  
  public void onActionViewCollapsed() {
    setQuery("", false);
    clearFocus();
    a(true);
    this.a.setImeOptions(this.P);
    this.O = false;
  }
  
  public void onActionViewExpanded() {
    if (this.O)
      return; 
    this.O = true;
    this.P = this.a.getImeOptions();
    this.a.setImeOptions(this.P | 0x2000000);
    this.a.setText("");
    setIconified(false);
  }
  
  protected void onDetachedFromWindow() {
    removeCallbacks(this.R);
    post(this.S);
    super.onDetachedFromWindow();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean) {
      a((View)this.a, this.p);
      this.q.set(this.p.left, 0, this.p.right, paramInt4 - paramInt2);
      UpdatableTouchDelegate updatableTouchDelegate = this.o;
      if (updatableTouchDelegate == null) {
        this.o = new UpdatableTouchDelegate(this.q, this.p, (View)this.a);
        setTouchDelegate(this.o);
        return;
      } 
      updatableTouchDelegate.setBounds(this.q, this.p);
    } 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    if (isIconified()) {
      super.onMeasure(paramInt1, paramInt2);
      return;
    } 
    int j = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    if (j != Integer.MIN_VALUE) {
      if (j != 0) {
        if (j != 1073741824) {
          paramInt1 = i;
        } else {
          j = this.K;
          paramInt1 = i;
          if (j > 0)
            paramInt1 = Math.min(j, i); 
        } 
      } else {
        paramInt1 = this.K;
        if (paramInt1 <= 0)
          paramInt1 = getPreferredWidth(); 
      } 
    } else {
      paramInt1 = this.K;
      if (paramInt1 > 0) {
        paramInt1 = Math.min(paramInt1, i);
      } else {
        paramInt1 = Math.min(getPreferredWidth(), i);
      } 
    } 
    i = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (i != Integer.MIN_VALUE) {
      if (i == 0)
        paramInt2 = getPreferredHeight(); 
    } else {
      paramInt2 = Math.min(getPreferredHeight(), paramInt2);
    } 
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable) {
    if (!(paramParcelable instanceof SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
      return;
    } 
    SavedState savedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(savedState.getSuperState());
    a(savedState.a);
    requestLayout();
  }
  
  protected Parcelable onSaveInstanceState() {
    SavedState savedState = new SavedState(super.onSaveInstanceState());
    savedState.a = isIconified();
    return (Parcelable)savedState;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean) {
    super.onWindowFocusChanged(paramBoolean);
    n();
  }
  
  public boolean requestFocus(int paramInt, Rect paramRect) {
    if (this.J)
      return false; 
    if (!isFocusable())
      return false; 
    if (!isIconified()) {
      boolean bool = this.a.requestFocus(paramInt, paramRect);
      if (bool)
        a(false); 
      return bool;
    } 
    return super.requestFocus(paramInt, paramRect);
  }
  
  public void setAppSearchData(Bundle paramBundle) {
    this.Q = paramBundle;
  }
  
  public void setIconified(boolean paramBoolean) {
    if (paramBoolean) {
      d();
      return;
    } 
    e();
  }
  
  public void setIconifiedByDefault(boolean paramBoolean) {
    if (this.E == paramBoolean)
      return; 
    this.E = paramBoolean;
    a(paramBoolean);
    o();
  }
  
  public void setImeOptions(int paramInt) {
    this.a.setImeOptions(paramInt);
  }
  
  public void setInputType(int paramInt) {
    this.a.setInputType(paramInt);
  }
  
  public void setMaxWidth(int paramInt) {
    this.K = paramInt;
    requestLayout();
  }
  
  public void setOnCloseListener(OnCloseListener paramOnCloseListener) {
    this.B = paramOnCloseListener;
  }
  
  public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener) {
    this.f = paramOnFocusChangeListener;
  }
  
  public void setOnQueryTextListener(OnQueryTextListener paramOnQueryTextListener) {
    this.A = paramOnQueryTextListener;
  }
  
  public void setOnSearchClickListener(View.OnClickListener paramOnClickListener) {
    this.D = paramOnClickListener;
  }
  
  public void setOnSuggestionListener(OnSuggestionListener paramOnSuggestionListener) {
    this.C = paramOnSuggestionListener;
  }
  
  public void setQuery(CharSequence paramCharSequence, boolean paramBoolean) {
    this.a.setText(paramCharSequence);
    if (paramCharSequence != null) {
      SearchAutoComplete searchAutoComplete = this.a;
      searchAutoComplete.setSelection(searchAutoComplete.length());
      this.N = paramCharSequence;
    } 
    if (paramBoolean && !TextUtils.isEmpty(paramCharSequence))
      c(); 
  }
  
  public void setQueryHint(CharSequence paramCharSequence) {
    this.H = paramCharSequence;
    o();
  }
  
  public void setQueryRefinementEnabled(boolean paramBoolean) {
    this.I = paramBoolean;
    CursorAdapter cursorAdapter = this.g;
    if (cursorAdapter instanceof SuggestionsAdapter) {
      boolean bool;
      SuggestionsAdapter suggestionsAdapter = (SuggestionsAdapter)cursorAdapter;
      if (paramBoolean) {
        bool = true;
      } else {
        bool = true;
      } 
      suggestionsAdapter.setQueryRefinement(bool);
    } 
  }
  
  public void setSearchableInfo(SearchableInfo paramSearchableInfo) {
    this.h = paramSearchableInfo;
    if (this.h != null) {
      p();
      o();
    } 
    this.L = j();
    if (this.L)
      this.a.setPrivateImeOptions("nm"); 
    a(isIconified());
  }
  
  public void setSubmitButtonEnabled(boolean paramBoolean) {
    this.G = paramBoolean;
    a(isIconified());
  }
  
  public void setSuggestionsAdapter(CursorAdapter paramCursorAdapter) {
    this.g = paramCursorAdapter;
    this.a.setAdapter((ListAdapter)this.g);
  }
  
  static class AutoCompleteTextViewReflector {
    private Method a;
    
    private Method b;
    
    private Method c;
    
    AutoCompleteTextViewReflector() {
      try {
        this.a = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
        this.a.setAccessible(true);
      } catch (NoSuchMethodException noSuchMethodException) {}
      try {
        this.b = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
        this.b.setAccessible(true);
        try {
          this.c = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[] { boolean.class });
          this.c.setAccessible(true);
          return;
        } catch (NoSuchMethodException noSuchMethodException) {}
      } catch (NoSuchMethodException noSuchMethodException) {
        try {
          this.c = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[] { boolean.class });
          this.c.setAccessible(true);
          return;
        } catch (NoSuchMethodException noSuchMethodException1) {}
      } 
    }
    
    void a(AutoCompleteTextView param1AutoCompleteTextView) {
      Method method = this.a;
      if (method != null)
        try {
          method.invoke(param1AutoCompleteTextView, new Object[0]);
          return;
        } catch (Exception exception) {
          return;
        }  
    }
    
    void a(AutoCompleteTextView param1AutoCompleteTextView, boolean param1Boolean) {
      Method method = this.c;
      if (method != null)
        try {
          method.invoke(param1AutoCompleteTextView, new Object[] { Boolean.valueOf(param1Boolean) });
          return;
        } catch (Exception exception) {
          return;
        }  
    }
    
    void b(AutoCompleteTextView param1AutoCompleteTextView) {
      Method method = this.b;
      if (method != null)
        try {
          method.invoke(param1AutoCompleteTextView, new Object[0]);
          return;
        } catch (Exception exception) {
          return;
        }  
    }
  }
  
  public static interface OnCloseListener {
    boolean onClose();
  }
  
  public static interface OnQueryTextListener {
    boolean onQueryTextChange(String param1String);
    
    boolean onQueryTextSubmit(String param1String);
  }
  
  public static interface OnSuggestionListener {
    boolean onSuggestionClick(int param1Int);
    
    boolean onSuggestionSelect(int param1Int);
  }
  
  static class SavedState extends AbsSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = (Parcelable.Creator<SavedState>)new Parcelable.ClassLoaderCreator<SavedState>() {
        public SearchView.SavedState createFromParcel(Parcel param2Parcel) {
          return new SearchView.SavedState(param2Parcel, null);
        }
        
        public SearchView.SavedState createFromParcel(Parcel param2Parcel, ClassLoader param2ClassLoader) {
          return new SearchView.SavedState(param2Parcel, param2ClassLoader);
        }
        
        public SearchView.SavedState[] newArray(int param2Int) {
          return new SearchView.SavedState[param2Int];
        }
      };
    
    boolean a;
    
    public SavedState(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      super(param1Parcel, param1ClassLoader);
      this.a = ((Boolean)param1Parcel.readValue(null)).booleanValue();
    }
    
    SavedState(Parcelable param1Parcelable) {
      super(param1Parcelable);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("SearchView.SavedState{");
      stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      stringBuilder.append(" isIconified=");
      stringBuilder.append(this.a);
      stringBuilder.append("}");
      return stringBuilder.toString();
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      super.writeToParcel(param1Parcel, param1Int);
      param1Parcel.writeValue(Boolean.valueOf(this.a));
    }
  }
  
  static final class null implements Parcelable.ClassLoaderCreator<SavedState> {
    public SearchView.SavedState createFromParcel(Parcel param1Parcel) {
      return new SearchView.SavedState(param1Parcel, null);
    }
    
    public SearchView.SavedState createFromParcel(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      return new SearchView.SavedState(param1Parcel, param1ClassLoader);
    }
    
    public SearchView.SavedState[] newArray(int param1Int) {
      return new SearchView.SavedState[param1Int];
    }
  }
  
  public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {
    final Runnable a = new Runnable(this) {
        public void run() {
          this.a.b();
        }
      };
    
    private int b = getThreshold();
    
    private SearchView c;
    
    private boolean d;
    
    public SearchAutoComplete(Context param1Context) {
      this(param1Context, (AttributeSet)null);
    }
    
    public SearchAutoComplete(Context param1Context, AttributeSet param1AttributeSet) {
      this(param1Context, param1AttributeSet, R.attr.autoCompleteTextViewStyle);
    }
    
    public SearchAutoComplete(Context param1Context, AttributeSet param1AttributeSet, int param1Int) {
      super(param1Context, param1AttributeSet, param1Int);
    }
    
    private int getSearchViewTextMinWidthDp() {
      Configuration configuration = getResources().getConfiguration();
      int i = configuration.screenWidthDp;
      int j = configuration.screenHeightDp;
      return (i >= 960 && j >= 720 && configuration.orientation == 2) ? 256 : ((i >= 600 || (i >= 640 && j >= 480)) ? 192 : 160);
    }
    
    boolean a() {
      return (TextUtils.getTrimmedLength((CharSequence)getText()) == 0);
    }
    
    void b() {
      if (this.d) {
        ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput((View)this, 0);
        this.d = false;
      } 
    }
    
    public boolean enoughToFilter() {
      return (this.b <= 0 || super.enoughToFilter());
    }
    
    public InputConnection onCreateInputConnection(EditorInfo param1EditorInfo) {
      InputConnection inputConnection = super.onCreateInputConnection(param1EditorInfo);
      if (this.d) {
        removeCallbacks(this.a);
        post(this.a);
      } 
      return inputConnection;
    }
    
    protected void onFinishInflate() {
      super.onFinishInflate();
      DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
      setMinWidth((int)TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), displayMetrics));
    }
    
    protected void onFocusChanged(boolean param1Boolean, int param1Int, Rect param1Rect) {
      super.onFocusChanged(param1Boolean, param1Int, param1Rect);
      this.c.g();
    }
    
    public boolean onKeyPreIme(int param1Int, KeyEvent param1KeyEvent) {
      if (param1Int == 4) {
        if (param1KeyEvent.getAction() == 0 && param1KeyEvent.getRepeatCount() == 0) {
          KeyEvent.DispatcherState dispatcherState = getKeyDispatcherState();
          if (dispatcherState != null)
            dispatcherState.startTracking(param1KeyEvent, this); 
          return true;
        } 
        if (param1KeyEvent.getAction() == 1) {
          KeyEvent.DispatcherState dispatcherState = getKeyDispatcherState();
          if (dispatcherState != null)
            dispatcherState.handleUpEvent(param1KeyEvent); 
          if (param1KeyEvent.isTracking() && !param1KeyEvent.isCanceled()) {
            this.c.clearFocus();
            setImeVisibility(false);
            return true;
          } 
        } 
      } 
      return super.onKeyPreIme(param1Int, param1KeyEvent);
    }
    
    public void onWindowFocusChanged(boolean param1Boolean) {
      super.onWindowFocusChanged(param1Boolean);
      if (param1Boolean && this.c.hasFocus() && getVisibility() == 0) {
        this.d = true;
        if (SearchView.a(getContext()))
          SearchView.i.a(this, true); 
      } 
    }
    
    public void performCompletion() {}
    
    protected void replaceText(CharSequence param1CharSequence) {}
    
    void setImeVisibility(boolean param1Boolean) {
      InputMethodManager inputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
      if (!param1Boolean) {
        this.d = false;
        removeCallbacks(this.a);
        inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        return;
      } 
      if (inputMethodManager.isActive((View)this)) {
        this.d = false;
        removeCallbacks(this.a);
        inputMethodManager.showSoftInput((View)this, 0);
        return;
      } 
      this.d = true;
    }
    
    void setSearchView(SearchView param1SearchView) {
      this.c = param1SearchView;
    }
    
    public void setThreshold(int param1Int) {
      super.setThreshold(param1Int);
      this.b = param1Int;
    }
  }
  
  class null implements Runnable {
    null(SearchView this$0) {}
    
    public void run() {
      this.a.b();
    }
  }
  
  static class UpdatableTouchDelegate extends TouchDelegate {
    private final View a;
    
    private final Rect b;
    
    private final Rect c;
    
    private final Rect d;
    
    private final int e;
    
    private boolean f;
    
    public UpdatableTouchDelegate(Rect param1Rect1, Rect param1Rect2, View param1View) {
      super(param1Rect1, param1View);
      this.e = ViewConfiguration.get(param1View.getContext()).getScaledTouchSlop();
      this.b = new Rect();
      this.d = new Rect();
      this.c = new Rect();
      setBounds(param1Rect1, param1Rect2);
      this.a = param1View;
    }
    
    public boolean onTouchEvent(MotionEvent param1MotionEvent) {
      // Byte code:
      //   0: aload_1
      //   1: invokevirtual getX : ()F
      //   4: f2i
      //   5: istore #4
      //   7: aload_1
      //   8: invokevirtual getY : ()F
      //   11: f2i
      //   12: istore #5
      //   14: aload_1
      //   15: invokevirtual getAction : ()I
      //   18: istore_2
      //   19: iconst_1
      //   20: istore_3
      //   21: iconst_0
      //   22: istore #7
      //   24: iload_2
      //   25: ifeq -> 108
      //   28: iload_2
      //   29: iconst_1
      //   30: if_icmpeq -> 62
      //   33: iload_2
      //   34: iconst_2
      //   35: if_icmpeq -> 62
      //   38: iload_2
      //   39: iconst_3
      //   40: if_icmpeq -> 46
      //   43: goto -> 135
      //   46: aload_0
      //   47: getfield f : Z
      //   50: istore #6
      //   52: aload_0
      //   53: iconst_0
      //   54: putfield f : Z
      //   57: iload_3
      //   58: istore_2
      //   59: goto -> 140
      //   62: aload_0
      //   63: getfield f : Z
      //   66: istore #8
      //   68: iload #8
      //   70: istore #6
      //   72: iload_3
      //   73: istore_2
      //   74: iload #8
      //   76: ifeq -> 140
      //   79: iload #8
      //   81: istore #6
      //   83: iload_3
      //   84: istore_2
      //   85: aload_0
      //   86: getfield d : Landroid/graphics/Rect;
      //   89: iload #4
      //   91: iload #5
      //   93: invokevirtual contains : (II)Z
      //   96: ifne -> 140
      //   99: iconst_0
      //   100: istore_2
      //   101: iload #8
      //   103: istore #6
      //   105: goto -> 140
      //   108: aload_0
      //   109: getfield b : Landroid/graphics/Rect;
      //   112: iload #4
      //   114: iload #5
      //   116: invokevirtual contains : (II)Z
      //   119: ifeq -> 135
      //   122: aload_0
      //   123: iconst_1
      //   124: putfield f : Z
      //   127: iconst_1
      //   128: istore #6
      //   130: iload_3
      //   131: istore_2
      //   132: goto -> 140
      //   135: iconst_0
      //   136: istore #6
      //   138: iload_3
      //   139: istore_2
      //   140: iload #6
      //   142: ifeq -> 226
      //   145: iload_2
      //   146: ifeq -> 190
      //   149: aload_0
      //   150: getfield c : Landroid/graphics/Rect;
      //   153: iload #4
      //   155: iload #5
      //   157: invokevirtual contains : (II)Z
      //   160: ifne -> 190
      //   163: aload_1
      //   164: aload_0
      //   165: getfield a : Landroid/view/View;
      //   168: invokevirtual getWidth : ()I
      //   171: iconst_2
      //   172: idiv
      //   173: i2f
      //   174: aload_0
      //   175: getfield a : Landroid/view/View;
      //   178: invokevirtual getHeight : ()I
      //   181: iconst_2
      //   182: idiv
      //   183: i2f
      //   184: invokevirtual setLocation : (FF)V
      //   187: goto -> 216
      //   190: aload_1
      //   191: iload #4
      //   193: aload_0
      //   194: getfield c : Landroid/graphics/Rect;
      //   197: getfield left : I
      //   200: isub
      //   201: i2f
      //   202: iload #5
      //   204: aload_0
      //   205: getfield c : Landroid/graphics/Rect;
      //   208: getfield top : I
      //   211: isub
      //   212: i2f
      //   213: invokevirtual setLocation : (FF)V
      //   216: aload_0
      //   217: getfield a : Landroid/view/View;
      //   220: aload_1
      //   221: invokevirtual dispatchTouchEvent : (Landroid/view/MotionEvent;)Z
      //   224: istore #7
      //   226: iload #7
      //   228: ireturn
    }
    
    public void setBounds(Rect param1Rect1, Rect param1Rect2) {
      this.b.set(param1Rect1);
      this.d.set(param1Rect1);
      param1Rect1 = this.d;
      int i = this.e;
      param1Rect1.inset(-i, -i);
      this.c.set(param1Rect2);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\widget\SearchView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */