package maven_package_1;

import java.util.Random;

import org.testng.annotations.Test;

public class Random_String {
  @Test
  public void f() {
	  String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
      StringBuilder salt = new StringBuilder();
      Random rnd = new Random();
      while (salt.length() < 6) {
          int index = (int) (rnd.nextFloat() * SALTCHARS.length());
          salt.append(SALTCHARS.charAt(index));
      }
      String saltStr = salt.toString();
      System.out.println(saltStr);
  }
}
