package clases;


@SuppressWarnings("unchecked")
public class contacto implements Comparable{
private int color;//1=verde(CONECTADO)/2=rojo(OCUPADO),3=gris(DESCONECTADO)
private String user;
private String name;

public void setColor(int color) {
	this.color = color;
}
public int getColor() {
	return color;
}
public void setUser(String user) {
	this.user = user;
}
public String getUser() {
	return user;
}
public void setName(String name) {
	this.name = name;
}
public String getName() {
	return name;
}
public int compareTo(Object o) {
   contacto c2 = (contacto) o;
    //podemos hacer esto porque String implementa Comparable
    return c2.color;//compareTo(c2.getColor());
  }

}
