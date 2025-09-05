import java.util.Scanner; 
public class Main {
    public static void main(String[] args) {
        // 1 - Fibonacci
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Insira o valor que sera testado para fibonacci: ");
        int numero = scanner.nextInt();

        System.out.println("Resultado Fibonacci Linear: " + fibonacciLinar(numero));
        System.out.println("Resultado Fibonacci Recursivo: " + fibonacciRecursiva(numero));
    }
    

    /*
     1 - Fibonacci
     
     -- Criar uma função em sua linguagem preferida. A função deve receber um
     numero N >= 0 (deve validar o input para a função), e retornar o valor
     correspondente desse número na sequência Fibonacci. EX. fib(0) =0; fib(1) =
     1; fib(2) = 1; fib(3) = 2; fib(5) = 5; fib(6) = 8.
     
     --- Criar uma função recursiva que resolva Fibonacci
     
     --- Criar uma função linear que resolva Fibonacci
     
     */
    public static int fibonacciLinar(int n) {
        /*
         pelo que entendi a sequencia a sequencia de fibonacci consiste no seguinte
         se inicio com um casal de coelhos jovens, e conforme no primeiro mes eles
         ainda sao um casal
         porém sao um casal de adultos
         utilizei esse video pra entender a sequencia:
         https://www.youtube.com/watch?v=cHZWZhHQq4g
         */
        if(n < 0){
            System.out.println("Valor invalido, insira um valor maior ou igual a 0");
            return -1; // valor invalido
        }
        if (n == 0 || n == 1) {
            return 1;
            // temos apenas um casal de coelhos, infantil no primeiro mes e adulto no 2, ele
            // so ira reproduzir a partir do 2 mes
        } else {
            /*
            mas aqui ja complica um pouco essa charada,
            a partir do segundo mes nos teremos 2 casais de coelhos, um adulto e um jovem
            a partir do terceiro mes nos ja teremos os casais de adultos, e o casal que
            nasceu no segundo mes, entao nosso resultado sera 3
            porque 3? o casal de coelhos reproduz a cada 2 meses, porque no primeiro 1
            nascido sao criancas e no 2 mes sao adultos (mas acabaram de se conhecer
            vamos por assim)
            logo eles se reproduzem de 3 em 3 meses, por isso no 4 mes o resultado sera:
            5
            m0: 1casalJovem 1 = 1
            m1: 1cAdultos 1 = 1
            m2: 1cAdultos 1casalJovem 2 =2
            m3: 1cAdultos 1cAdultos 1casalJovem = 3
            m4: 1cAdultos 1cAdultos 1cAdultos 1casalJovem 1casalJovem = 5
            m5: 1cAdultos 1cAdultos 1cAdultos 1cAdultos 1cAdultos 1casalJovem 1casalJovem 1casalJovem = 8
            ok com base nisso
             */
          
            int temp[] = new int[n];
            
            for (int i = 0; i < temp.length; i++) {
                if (i == 0 || i == 1) {
                    temp[i] = fibonacciLinar(i);
                }else{
                    temp[i] = temp[i - 1] + temp[i - 2]; // a sequencia constiste na soma dos dois numeros anteriores
                }
                
               // System.out.println("Coelho:" +  i + "=" + temp[i]);
            }

            return temp[temp.length - 1];
        }
    }

    public static int fibonacciRecursiva(int n) {
        int result = 0;
        if(n < 0){
            System.out.println("Valor invalido, insira um valor maior ou igual a 0");
            return 0; // valor invalido
        }
        if (n ==  0) {
            return 1;
        }else if(n ==  1){
            return 1;
        } else {
            int temp[] = new int[n];

            
            result = fibonacciRecursiva(n - 1) + fibonacciRecursiva(n - 2);
            }

            return result;
        }
    
}