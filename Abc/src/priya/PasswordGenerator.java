package priya;
import java.util.Random;
 class PasswordGenerator {
    private static final int number = 100;
    private static char [] number_of_char = new char [number];
    private static int loop = 0;
    private int pass_size;
    public PasswordGenerator( int pass_size ) {
      this.pass_size = pass_size;
      initnumber_of_char();
    }
    private static char [] initnumber_of_char() {
      int i = 0;
      for ( int j = 48; j < 58; ++i, ++j, ++loop ) {
        number_of_char[i] = (char) j;
      }
      for ( int j = 64; j < 91; ++i, ++j, ++loop ) {
        number_of_char[i] = (char) j;
      }
      for ( int j = 97; j < 123; ++i, ++j, ++loop ) {
        number_of_char[i] = (char) j;
      }

      return number_of_char;
    }

    
    public char [] get() {

      
      Random rnd = new Random();

      char [] password = new char [pass_size];
      for ( int i = 0; i < pass_size; ++i ) {
        password[i] = number_of_char[ rnd.nextInt(loop) ];
      }

      return password;
    }
    public void typechar() {
      for ( int i = 0; i < loop && number_of_char[i] != 0; ++i ) {
        System.out.println(number_of_char[i]);
      }
    }
    public static void main(String[] args) {
      PasswordGenerator password = new PasswordGenerator( 6);
      System.out.println( password.get() );   
    }

}