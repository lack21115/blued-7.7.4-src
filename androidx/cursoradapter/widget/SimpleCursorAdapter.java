package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SimpleCursorAdapter extends ResourceCursorAdapter {
  protected int[] j;
  
  protected int[] k;
  
  String[] l;
  
  private int m = -1;
  
  private CursorToStringConverter n;
  
  private ViewBinder o;
  
  @Deprecated
  public SimpleCursorAdapter(Context paramContext, int paramInt, Cursor paramCursor, String[] paramArrayOfString, int[] paramArrayOfint) {
    super(paramContext, paramInt, paramCursor);
    this.k = paramArrayOfint;
    this.l = paramArrayOfString;
    a(paramCursor, paramArrayOfString);
  }
  
  public SimpleCursorAdapter(Context paramContext, int paramInt1, Cursor paramCursor, String[] paramArrayOfString, int[] paramArrayOfint, int paramInt2) {
    super(paramContext, paramInt1, paramCursor, paramInt2);
    this.k = paramArrayOfint;
    this.l = paramArrayOfString;
    a(paramCursor, paramArrayOfString);
  }
  
  private void a(Cursor paramCursor, String[] paramArrayOfString) {
    if (paramCursor != null) {
      int j = paramArrayOfString.length;
      int[] arrayOfInt = this.j;
      if (arrayOfInt == null || arrayOfInt.length != j)
        this.j = new int[j]; 
      for (int i = 0; i < j; i++)
        this.j[i] = paramCursor.getColumnIndexOrThrow(paramArrayOfString[i]); 
    } else {
      this.j = null;
    } 
  }
  
  public void bindView(View paramView, Context paramContext, Cursor paramCursor) {
    ViewBinder viewBinder = this.o;
    int[] arrayOfInt1 = this.k;
    int j = arrayOfInt1.length;
    int[] arrayOfInt2 = this.j;
    int i;
    for (i = 0; i < j; i++) {
      View view = paramView.findViewById(arrayOfInt1[i]);
      if (view != null) {
        boolean bool;
        if (viewBinder != null) {
          bool = viewBinder.setViewValue(view, paramCursor, arrayOfInt2[i]);
        } else {
          bool = false;
        } 
        if (!bool) {
          String str2 = paramCursor.getString(arrayOfInt2[i]);
          String str1 = str2;
          if (str2 == null)
            str1 = ""; 
          if (view instanceof TextView) {
            setViewText((TextView)view, str1);
          } else if (view instanceof ImageView) {
            setViewImage((ImageView)view, str1);
          } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(view.getClass().getName());
            stringBuilder.append(" is not a ");
            stringBuilder.append(" view that can be bounds by this SimpleCursorAdapter");
            throw new IllegalStateException(stringBuilder.toString());
          } 
        } 
      } 
    } 
  }
  
  public void changeCursorAndColumns(Cursor paramCursor, String[] paramArrayOfString, int[] paramArrayOfint) {
    this.l = paramArrayOfString;
    this.k = paramArrayOfint;
    a(paramCursor, this.l);
    changeCursor(paramCursor);
  }
  
  public CharSequence convertToString(Cursor paramCursor) {
    CursorToStringConverter cursorToStringConverter = this.n;
    if (cursorToStringConverter != null)
      return cursorToStringConverter.convertToString(paramCursor); 
    int i = this.m;
    return (i > -1) ? paramCursor.getString(i) : super.convertToString(paramCursor);
  }
  
  public CursorToStringConverter getCursorToStringConverter() {
    return this.n;
  }
  
  public int getStringConversionColumn() {
    return this.m;
  }
  
  public ViewBinder getViewBinder() {
    return this.o;
  }
  
  public void setCursorToStringConverter(CursorToStringConverter paramCursorToStringConverter) {
    this.n = paramCursorToStringConverter;
  }
  
  public void setStringConversionColumn(int paramInt) {
    this.m = paramInt;
  }
  
  public void setViewBinder(ViewBinder paramViewBinder) {
    this.o = paramViewBinder;
  }
  
  public void setViewImage(ImageView paramImageView, String paramString) {
    try {
      paramImageView.setImageResource(Integer.parseInt(paramString));
      return;
    } catch (NumberFormatException numberFormatException) {
      paramImageView.setImageURI(Uri.parse(paramString));
      return;
    } 
  }
  
  public void setViewText(TextView paramTextView, String paramString) {
    paramTextView.setText(paramString);
  }
  
  public Cursor swapCursor(Cursor paramCursor) {
    a(paramCursor, this.l);
    return super.swapCursor(paramCursor);
  }
  
  public static interface CursorToStringConverter {
    CharSequence convertToString(Cursor param1Cursor);
  }
  
  public static interface ViewBinder {
    boolean setViewValue(View param1View, Cursor param1Cursor, int param1Int);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\cursoradapter\widget\SimpleCursorAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */