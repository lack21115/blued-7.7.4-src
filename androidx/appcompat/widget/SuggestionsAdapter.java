package androidx.appcompat.widget;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.core.content.ContextCompat;
import androidx.cursoradapter.widget.ResourceCursorAdapter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

class SuggestionsAdapter extends ResourceCursorAdapter implements View.OnClickListener {
  private final SearchManager j = (SearchManager)this.d.getSystemService("search");
  
  private final SearchView k;
  
  private final SearchableInfo l;
  
  private final Context m;
  
  private final WeakHashMap<String, Drawable.ConstantState> n;
  
  private final int o;
  
  private boolean p = false;
  
  private int q = 1;
  
  private ColorStateList r;
  
  private int s = -1;
  
  private int t = -1;
  
  private int u = -1;
  
  private int v = -1;
  
  private int w = -1;
  
  private int x = -1;
  
  public SuggestionsAdapter(Context paramContext, SearchView paramSearchView, SearchableInfo paramSearchableInfo, WeakHashMap<String, Drawable.ConstantState> paramWeakHashMap) {
    super(paramContext, paramSearchView.getSuggestionRowLayout(), null, true);
    this.k = paramSearchView;
    this.l = paramSearchableInfo;
    this.o = paramSearchView.getSuggestionCommitIconResId();
    this.m = paramContext;
    this.n = paramWeakHashMap;
  }
  
  private Drawable a(ComponentName paramComponentName) {
    Drawable.ConstantState constantState1;
    String str = paramComponentName.flattenToShortString();
    boolean bool = this.n.containsKey(str);
    Drawable.ConstantState constantState2 = null;
    if (bool) {
      constantState1 = this.n.get(str);
      return (constantState1 == null) ? null : constantState1.newDrawable(this.m.getResources());
    } 
    Drawable drawable = b((ComponentName)constantState1);
    if (drawable == null) {
      constantState1 = constantState2;
    } else {
      constantState1 = drawable.getConstantState();
    } 
    this.n.put(str, constantState1);
    return drawable;
  }
  
  private Drawable a(String paramString) {
    StringBuilder stringBuilder2 = null;
    StringBuilder stringBuilder1 = stringBuilder2;
    if (paramString != null) {
      stringBuilder1 = stringBuilder2;
      if (!paramString.isEmpty()) {
        if ("0".equals(paramString))
          return null; 
        try {
          int i = Integer.parseInt(paramString);
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append("android.resource://");
          stringBuilder1.append(this.m.getPackageName());
          stringBuilder1.append("/");
          stringBuilder1.append(i);
          String str = stringBuilder1.toString();
          Drawable drawable = b(str);
          if (drawable != null)
            return drawable; 
          drawable = ContextCompat.getDrawable(this.m, i);
          a(str, drawable);
          return drawable;
        } catch (NumberFormatException numberFormatException) {
          Drawable drawable = b(paramString);
          if (drawable != null)
            return drawable; 
          drawable = b(Uri.parse(paramString));
          a(paramString, drawable);
          return drawable;
        } catch (android.content.res.Resources.NotFoundException notFoundException) {
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append("Icon resource not found: ");
          stringBuilder1.append(paramString);
          Log.w("SuggestionsAdapter", stringBuilder1.toString());
          return null;
        } 
      } 
    } 
    return (Drawable)stringBuilder1;
  }
  
  private CharSequence a(CharSequence paramCharSequence) {
    if (this.r == null) {
      TypedValue typedValue = new TypedValue();
      this.d.getTheme().resolveAttribute(R.attr.textColorSearchUrl, typedValue, true);
      this.r = this.d.getResources().getColorStateList(typedValue.resourceId);
    } 
    SpannableString spannableString = new SpannableString(paramCharSequence);
    spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.r, null), 0, paramCharSequence.length(), 33);
    return (CharSequence)spannableString;
  }
  
  private static String a(Cursor paramCursor, int paramInt) {
    if (paramInt == -1)
      return null; 
    try {
      return paramCursor.getString(paramInt);
    } catch (Exception exception) {
      Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", exception);
      return null;
    } 
  }
  
  private void a(Cursor paramCursor) {
    if (paramCursor != null) {
      Bundle bundle = paramCursor.getExtras();
    } else {
      paramCursor = null;
    } 
    if (paramCursor == null || paramCursor.getBoolean("in_progress"));
  }
  
  private void a(ImageView paramImageView, Drawable paramDrawable, int paramInt) {
    paramImageView.setImageDrawable(paramDrawable);
    if (paramDrawable == null) {
      paramImageView.setVisibility(paramInt);
      return;
    } 
    paramImageView.setVisibility(0);
    paramDrawable.setVisible(false, false);
    paramDrawable.setVisible(true, false);
  }
  
  private void a(TextView paramTextView, CharSequence paramCharSequence) {
    paramTextView.setText(paramCharSequence);
    if (TextUtils.isEmpty(paramCharSequence)) {
      paramTextView.setVisibility(8);
      return;
    } 
    paramTextView.setVisibility(0);
  }
  
  private void a(String paramString, Drawable paramDrawable) {
    if (paramDrawable != null)
      this.n.put(paramString, paramDrawable.getConstantState()); 
  }
  
  private Drawable b(ComponentName paramComponentName) {
    PackageManager packageManager = this.d.getPackageManager();
    try {
      StringBuilder stringBuilder;
      ActivityInfo activityInfo = packageManager.getActivityInfo(paramComponentName, 128);
      int i = activityInfo.getIconResource();
      if (i == 0)
        return null; 
      Drawable drawable = packageManager.getDrawable(paramComponentName.getPackageName(), i, activityInfo.applicationInfo);
      if (drawable == null) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid icon resource ");
        stringBuilder.append(i);
        stringBuilder.append(" for ");
        stringBuilder.append(paramComponentName.flattenToShortString());
        Log.w("SuggestionsAdapter", stringBuilder.toString());
        return null;
      } 
      return (Drawable)stringBuilder;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      Log.w("SuggestionsAdapter", nameNotFoundException.toString());
      return null;
    } 
  }
  
  private Drawable b(Cursor paramCursor) {
    int i = this.v;
    if (i == -1)
      return null; 
    Drawable drawable = a(paramCursor.getString(i));
    return (drawable != null) ? drawable : d(paramCursor);
  }
  
  private Drawable b(Uri paramUri) {
    try {
      boolean bool = "android.resource".equals(paramUri.getScheme());
      if (bool)
        try {
          return a(paramUri);
        } catch (android.content.res.Resources.NotFoundException notFoundException) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("Resource does not exist: ");
          stringBuilder1.append(paramUri);
          throw new FileNotFoundException(stringBuilder1.toString());
        }  
      InputStream inputStream = this.m.getContentResolver().openInputStream(paramUri);
      if (inputStream != null)
        try {
          Drawable drawable = Drawable.createFromStream(inputStream, null);
        } finally {
          try {
            iOException.close();
          } catch (IOException iOException1) {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("Error closing icon stream for ");
            stringBuilder1.append(paramUri);
            Log.e("SuggestionsAdapter", stringBuilder1.toString(), iOException1);
          } 
        }  
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Failed to open ");
      stringBuilder.append(paramUri);
      throw new FileNotFoundException(stringBuilder.toString());
    } catch (FileNotFoundException fileNotFoundException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Icon not found: ");
      stringBuilder.append(paramUri);
      stringBuilder.append(", ");
      stringBuilder.append(fileNotFoundException.getMessage());
      Log.w("SuggestionsAdapter", stringBuilder.toString());
      return null;
    } 
  }
  
  private Drawable b(String paramString) {
    Drawable.ConstantState constantState = this.n.get(paramString);
    return (constantState == null) ? null : constantState.newDrawable();
  }
  
  private Drawable c(Cursor paramCursor) {
    int i = this.w;
    return (i == -1) ? null : a(paramCursor.getString(i));
  }
  
  private Drawable d(Cursor paramCursor) {
    Drawable drawable = a(this.l.getSearchActivity());
    return (drawable != null) ? drawable : this.d.getPackageManager().getDefaultActivityIcon();
  }
  
  public static String getColumnString(Cursor paramCursor, String paramString) {
    return a(paramCursor, paramCursor.getColumnIndex(paramString));
  }
  
  Cursor a(SearchableInfo paramSearchableInfo, String paramString, int paramInt) {
    SearchableInfo searchableInfo = null;
    if (paramSearchableInfo == null)
      return null; 
    String str1 = paramSearchableInfo.getSuggestAuthority();
    if (str1 == null)
      return null; 
    Uri.Builder builder = (new Uri.Builder()).scheme("content").authority(str1).query("").fragment("");
    String str2 = paramSearchableInfo.getSuggestPath();
    if (str2 != null)
      builder.appendEncodedPath(str2); 
    builder.appendPath("search_suggest_query");
    str2 = paramSearchableInfo.getSuggestSelection();
    if (str2 != null) {
      String[] arrayOfString = new String[1];
      arrayOfString[0] = paramString;
    } else {
      builder.appendPath(paramString);
      paramSearchableInfo = searchableInfo;
    } 
    if (paramInt > 0)
      builder.appendQueryParameter("limit", String.valueOf(paramInt)); 
    Uri uri = builder.build();
    return this.d.getContentResolver().query(uri, null, str2, (String[])paramSearchableInfo, null);
  }
  
  Drawable a(Uri paramUri) throws FileNotFoundException {
    String str = paramUri.getAuthority();
    if (!TextUtils.isEmpty(str))
      try {
        int i;
        Resources resources = this.d.getPackageManager().getResourcesForApplication(str);
        List<String> list = paramUri.getPathSegments();
        if (list != null) {
          StringBuilder stringBuilder2;
          i = list.size();
          if (i == 1)
            try {
              i = Integer.parseInt(list.get(0));
              if (i != 0)
                return resources.getDrawable(i); 
              stringBuilder2 = new StringBuilder();
              stringBuilder2.append("No resource found for: ");
              stringBuilder2.append(paramUri);
              throw new FileNotFoundException(stringBuilder2.toString());
            } catch (NumberFormatException numberFormatException) {
              stringBuilder2 = new StringBuilder();
              stringBuilder2.append("Single path segment is not a resource ID: ");
              stringBuilder2.append(paramUri);
              throw new FileNotFoundException(stringBuilder2.toString());
            }  
          if (i == 2) {
            i = resources.getIdentifier(list.get(1), list.get(0), (String)stringBuilder2);
          } else {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("More than two path segments: ");
            stringBuilder2.append(paramUri);
            throw new FileNotFoundException(stringBuilder2.toString());
          } 
        } else {
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("No path: ");
          stringBuilder2.append(paramUri);
          throw new FileNotFoundException(stringBuilder2.toString());
        } 
        if (i != 0)
          return resources.getDrawable(i); 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("No resource found for: ");
        stringBuilder1.append(paramUri);
        throw new FileNotFoundException(stringBuilder1.toString());
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("No package found for authority: ");
        stringBuilder1.append(paramUri);
        throw new FileNotFoundException(stringBuilder1.toString());
      }  
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("No authority: ");
    stringBuilder.append(paramUri);
    throw new FileNotFoundException(stringBuilder.toString());
  }
  
  public void bindView(View paramView, Context paramContext, Cursor paramCursor) {
    ChildViewCache childViewCache = (ChildViewCache)paramView.getTag();
    int i = this.x;
    if (i != -1) {
      i = paramCursor.getInt(i);
    } else {
      i = 0;
    } 
    if (childViewCache.mText1 != null) {
      String str = a(paramCursor, this.s);
      a(childViewCache.mText1, str);
    } 
    if (childViewCache.mText2 != null) {
      String str = a(paramCursor, this.u);
      if (str != null) {
        CharSequence charSequence = a(str);
      } else {
        str = a(paramCursor, this.t);
      } 
      if (TextUtils.isEmpty(str)) {
        if (childViewCache.mText1 != null) {
          childViewCache.mText1.setSingleLine(false);
          childViewCache.mText1.setMaxLines(2);
        } 
      } else if (childViewCache.mText1 != null) {
        childViewCache.mText1.setSingleLine(true);
        childViewCache.mText1.setMaxLines(1);
      } 
      a(childViewCache.mText2, str);
    } 
    if (childViewCache.mIcon1 != null)
      a(childViewCache.mIcon1, b(paramCursor), 4); 
    if (childViewCache.mIcon2 != null)
      a(childViewCache.mIcon2, c(paramCursor), 8); 
    int j = this.q;
    if (j == 2 || (j == 1 && (i & 0x1) != 0)) {
      childViewCache.mIconRefine.setVisibility(0);
      childViewCache.mIconRefine.setTag(childViewCache.mText1.getText());
      childViewCache.mIconRefine.setOnClickListener(this);
      return;
    } 
    childViewCache.mIconRefine.setVisibility(8);
  }
  
  public void changeCursor(Cursor paramCursor) {
    if (this.p) {
      Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
      if (paramCursor != null)
        paramCursor.close(); 
      return;
    } 
    try {
      super.changeCursor(paramCursor);
      if (paramCursor != null) {
        this.s = paramCursor.getColumnIndex("suggest_text_1");
        this.t = paramCursor.getColumnIndex("suggest_text_2");
        this.u = paramCursor.getColumnIndex("suggest_text_2_url");
        this.v = paramCursor.getColumnIndex("suggest_icon_1");
        this.w = paramCursor.getColumnIndex("suggest_icon_2");
        this.x = paramCursor.getColumnIndex("suggest_flags");
        return;
      } 
    } catch (Exception exception) {
      Log.e("SuggestionsAdapter", "error changing cursor and caching columns", exception);
    } 
  }
  
  public void close() {
    changeCursor((Cursor)null);
    this.p = true;
  }
  
  public CharSequence convertToString(Cursor paramCursor) {
    if (paramCursor == null)
      return null; 
    String str = getColumnString(paramCursor, "suggest_intent_query");
    if (str != null)
      return str; 
    if (this.l.shouldRewriteQueryFromData()) {
      str = getColumnString(paramCursor, "suggest_intent_data");
      if (str != null)
        return str; 
    } 
    if (this.l.shouldRewriteQueryFromText()) {
      String str1 = getColumnString(paramCursor, "suggest_text_1");
      if (str1 != null)
        return str1; 
    } 
    return null;
  }
  
  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    try {
      return super.getDropDownView(paramInt, paramView, paramViewGroup);
    } catch (RuntimeException runtimeException) {
      Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", runtimeException);
      View view = newDropDownView(this.d, this.c, paramViewGroup);
      if (view != null)
        ((ChildViewCache)view.getTag()).mText1.setText(runtimeException.toString()); 
      return view;
    } 
  }
  
  public int getQueryRefinement() {
    return this.q;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    try {
      return super.getView(paramInt, paramView, paramViewGroup);
    } catch (RuntimeException runtimeException) {
      Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", runtimeException);
      View view = newView(this.d, this.c, paramViewGroup);
      if (view != null)
        ((ChildViewCache)view.getTag()).mText1.setText(runtimeException.toString()); 
      return view;
    } 
  }
  
  public boolean hasStableIds() {
    return false;
  }
  
  public View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup) {
    View view = super.newView(paramContext, paramCursor, paramViewGroup);
    view.setTag(new ChildViewCache(view));
    ((ImageView)view.findViewById(R.id.edit_query)).setImageResource(this.o);
    return view;
  }
  
  public void notifyDataSetChanged() {
    super.notifyDataSetChanged();
    a(getCursor());
  }
  
  public void notifyDataSetInvalidated() {
    super.notifyDataSetInvalidated();
    a(getCursor());
  }
  
  public void onClick(View paramView) {
    Object object = paramView.getTag();
    if (object instanceof CharSequence)
      this.k.a((CharSequence)object); 
  }
  
  public Cursor runQueryOnBackgroundThread(CharSequence paramCharSequence) {
    if (paramCharSequence == null) {
      paramCharSequence = "";
    } else {
      paramCharSequence = paramCharSequence.toString();
    } 
    if (this.k.getVisibility() == 0) {
      if (this.k.getWindowVisibility() != 0)
        return null; 
      try {
        Cursor cursor = a(this.l, (String)paramCharSequence, 50);
        if (cursor != null) {
          cursor.getCount();
          return cursor;
        } 
      } catch (RuntimeException runtimeException) {
        Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", runtimeException);
      } 
    } 
    return null;
  }
  
  public void setQueryRefinement(int paramInt) {
    this.q = paramInt;
  }
  
  static final class ChildViewCache {
    public final ImageView mIcon1;
    
    public final ImageView mIcon2;
    
    public final ImageView mIconRefine;
    
    public final TextView mText1;
    
    public final TextView mText2;
    
    public ChildViewCache(View param1View) {
      this.mText1 = (TextView)param1View.findViewById(16908308);
      this.mText2 = (TextView)param1View.findViewById(16908309);
      this.mIcon1 = (ImageView)param1View.findViewById(16908295);
      this.mIcon2 = (ImageView)param1View.findViewById(16908296);
      this.mIconRefine = (ImageView)param1View.findViewById(R.id.edit_query);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\widget\SuggestionsAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */