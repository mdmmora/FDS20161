package TAD.testes;

/**
 * Uma interface simples para ler numeros e strings
 * do teclado
 * 
 * Traduzida e baseada na classe Console de Cay
 * Horstmann (1997)
 * 
 * - incluído método readFloat
 * - incluídas versões sobrecarregadas dos métodos sem prompt
 * - incluído wrappers para print, println e printf
 * 
 * @version 2 09 Jan 2008
 * @author Marcelo Cohen
 */
public class Console
{
  /**
   * Exibe uma mensagem no terminal sem nova linha no final
   * 
   * @param prompt a mensagem a exibir
   */
  public static void printPrompt(String prompt)
  {
     System.out.print(prompt + " ");
     System.out.flush();
  }
   
  /**
   * Lê uma string do teclado, finalizada com ENTER
   * 
   * @return a string de entrada (sem o caractere de nova linha)
   */
  public static String readLine()
  {
     int ch;
     String r = "";
     boolean done = false;
     while (!done)
     {
        try
        {
           ch = System.in.read();
           if (ch < 0 || (char)ch == '\n')
              done = true;
           else if ((char)ch != '\r') // weird--it used to do \r\n translation
              r = r + (char) ch;
        }
        catch(java.io.IOException e) {  done = true; }
     }
     return r;
  }

  /**
   * Lê uma string do teclado, finalizada com ENTER
   * 
   * @param prompt a mensagem a exibir antes
   * @return a string de entrada (sem o caractere de nova linha)
   */
  public static String readLine(String prompt)
  {
     printPrompt(prompt);
     return readLine();
  }

  /**
   * Lê um inteiro do teclado, finalizado com ENTER
   * 
   * @param prompt a mensagem a exibir antes
   * @return o valor de entrada como um int
   * @exception NumberFormatException se ocorrer entrada inválida
   */
  public static int readInt(String prompt)
  {  
     while(true)
     {
        printPrompt(prompt);
        try
        {
            return Integer.valueOf(readLine().trim()).intValue();
        } catch(NumberFormatException e)
        {
            System.out.println("Não é um inteiro - digite novamente!");
        }
     }
  }

  /**
   * Lê um inteiro do teclado, finalizado com ENTER
   * 
   * @return o valor de entrada como um int
   * @exception NumberFormatException se ocorrer entrada inválida
   */
  public static int readInt()
  {
     while(true)
     {  
        try
        {
            return Integer.valueOf(readLine().trim()).intValue();
        } catch(NumberFormatException e)
        {
            System.out.println("Não é um inteiro - digite novamente!");
        }
     }
  }
  
  /**
   * Lê um número real (float) do teclado, finalizado com ENTER
   * 
   * @param prompt a mensagem a exibir antes
   * @return o valor de entrada como float
   * @exception NumberFormatException se ocorrer entrada inválida
   */
  public static float readFloat(String prompt)
  {  
     while(true)
     {
        printPrompt(prompt);
        try
        {
          return Float.parseFloat(readLine().trim());
        } catch(NumberFormatException e)
        {
          System.out.println("Não é um número real - digite novamente!");
        }
     }
  }

  /**
   * Lê um número real (float) do teclado, finalizado com ENTER
   * 
   * @return o valor de entrada como float
   * @exception NumberFormatException se ocorrer entrada inválida
   */
  public static float readFloat()
  {  
     while(true)
     {
        try
        {
          return Float.parseFloat(readLine().trim());
        } catch(NumberFormatException e)
        {
          System.out.println("Não é um número real - digite novamente!");
        }
     }
  }
   
  /**
   * Lê um número real (double) do teclado, finalizado com ENTER
   * 
   * @param prompt a mensagem a exibir antes
   * @return o valor de entrada como float
   * @exception NumberFormatException se ocorrer entrada inválida
   */
  public static double readDouble(String prompt)
  {
     while(true)
     {
        printPrompt(prompt);
        try
        {
            return Double.parseDouble(readLine().trim());
        } catch(NumberFormatException e)
        {
            System.out.println("Não é um número real - digite novamente!");
        }
     }
  }
   
  /**
   * Lê um número real (double) do teclado, finalizado com ENTER
   * 
   * @return o valor de entrada como float
   * @exception NumberFormatException se ocorrer entrada inválida
   */
  public static double readDouble()
  {
     while(true)
     {
        try
        {
            return Double.parseDouble(readLine().trim());
        } catch(NumberFormatException e)
        {
            System.out.println("Não é um número real - digite novamente!");
        }
     }
  }

  /**
   * Escreve uma string na tela (wrapper para System.out.print)
   * 
   * @param string string a escrever
   */
  public static void print(String arg)
  {
      System.out.print(arg);
  }
   
  /**
   * Escreve uma string na tela (wrapper para System.out.println)
   * 
   * @param string string a escrever
   */
  public static void println(String arg)
  {
      System.out.println(arg);
  }

  /**
   * Escreve com saída formatada (wrapper para System.out.printf)
   * 
   * @param format string que descreve o formato de saída e a ordem dos argumentos
   * @param args zero ou mais argumentos, na ordem especificada pela string de formato
   */
  public static void printf(String format, Object ...args)
  {
      System.out.printf(format,args);
  }
}
