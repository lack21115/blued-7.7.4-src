package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class StreamLocalUriFetcher extends LocalUriFetcher<InputStream> {
  private static final UriMatcher a = new UriMatcher(-1);
  
  static {
    a.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
    a.addURI("com.android.contacts", "contacts/lookup/*", 1);
    a.addURI("com.android.contacts", "contacts/#/photo", 2);
    a.addURI("com.android.contacts", "contacts/#", 3);
    a.addURI("com.android.contacts", "contacts/#/display_photo", 4);
    a.addURI("com.android.contacts", "phone_lookup/*", 5);
  }
  
  public StreamLocalUriFetcher(ContentResolver paramContentResolver, Uri paramUri) {
    super(paramContentResolver, paramUri);
  }
  
  private InputStream a(ContentResolver paramContentResolver, Uri paramUri) {
    return ContactsContract.Contacts.openContactPhotoInputStream(paramContentResolver, paramUri, true);
  }
  
  private InputStream c(Uri paramUri, ContentResolver paramContentResolver) throws FileNotFoundException {
    int i = a.match(paramUri);
    if (i != 1)
      if (i != 3) {
        if (i != 5)
          return paramContentResolver.openInputStream(paramUri); 
      } else {
        return a(paramContentResolver, paramUri);
      }  
    paramUri = ContactsContract.Contacts.lookupContact(paramContentResolver, paramUri);
    if (paramUri != null)
      return a(paramContentResolver, paramUri); 
    throw new FileNotFoundException("Contact cannot be found");
  }
  
  protected InputStream a(Uri paramUri, ContentResolver paramContentResolver) throws FileNotFoundException {
    InputStream inputStream = c(paramUri, paramContentResolver);
    if (inputStream != null)
      return inputStream; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("InputStream is null for ");
    stringBuilder.append(paramUri);
    throw new FileNotFoundException(stringBuilder.toString());
  }
  
  protected void a(InputStream paramInputStream) throws IOException {
    paramInputStream.close();
  }
  
  public Class<InputStream> c() {
    return InputStream.class;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\data\StreamLocalUriFetcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */