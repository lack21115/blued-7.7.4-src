package com.loopj.android.http;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.cookie.BasicClientCookie;

public class SerializableCookie implements Serializable {
  private static final long serialVersionUID = 6374381828722046732L;
  
  private transient BasicClientCookie clientCookie;
  
  private final transient Cookie cookie;
  
  public SerializableCookie(Cookie paramCookie) {
    this.cookie = paramCookie;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
    this.clientCookie = new BasicClientCookie((String)paramObjectInputStream.readObject(), (String)paramObjectInputStream.readObject());
    this.clientCookie.setComment((String)paramObjectInputStream.readObject());
    this.clientCookie.setDomain((String)paramObjectInputStream.readObject());
    this.clientCookie.setExpiryDate((Date)paramObjectInputStream.readObject());
    this.clientCookie.setPath((String)paramObjectInputStream.readObject());
    this.clientCookie.setVersion(paramObjectInputStream.readInt());
    this.clientCookie.setSecure(paramObjectInputStream.readBoolean());
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
    paramObjectOutputStream.writeObject(this.cookie.getName());
    paramObjectOutputStream.writeObject(this.cookie.getValue());
    paramObjectOutputStream.writeObject(this.cookie.getComment());
    paramObjectOutputStream.writeObject(this.cookie.getDomain());
    paramObjectOutputStream.writeObject(this.cookie.getExpiryDate());
    paramObjectOutputStream.writeObject(this.cookie.getPath());
    paramObjectOutputStream.writeInt(this.cookie.getVersion());
    paramObjectOutputStream.writeBoolean(this.cookie.isSecure());
  }
  
  public Cookie getCookie() {
    BasicClientCookie basicClientCookie1;
    Cookie cookie = this.cookie;
    BasicClientCookie basicClientCookie2 = this.clientCookie;
    if (basicClientCookie2 != null)
      basicClientCookie1 = basicClientCookie2; 
    return (Cookie)basicClientCookie1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loopj\android\http\SerializableCookie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */