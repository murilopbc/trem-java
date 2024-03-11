import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        double posicaoTremA = 0, posicaoTremB = 10000, velocidadeTremA, velocidadeTremB;
        int opt, qtdTremA, qtdTremB;

        while (true) {
            try {
                System.out.println("1-Jogar\n2-Encerrar");
                opt = Integer.parseInt(sc.nextLine());

                if (opt == 1) {

                        try {
                            System.out.println("Digite quantos KM o trem A deseja andar: ");
                            velocidadeTremA = sc.nextDouble();

                            if (velocidadeTremA > 300 || velocidadeTremA <= 0) {
                                System.out.println("Digite um valor maior que 0 e menor que 300");
                            } else {
                                posicaoTremA += velocidadeTremA;
                                System.out.println("KM atual do trem A: " + posicaoTremA);
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Você digitou um caractere Inválido!");
                        }


                    try {
                        System.out.println("Digite quantos KM o trem B deseja andar: ");
                        velocidadeTremB = sc.nextDouble();

                        if (velocidadeTremB < -300 || velocidadeTremB >= 0) {
                            System.out.println("Digite um valor menor que 0 e até -300!");

                        }
                        else {

                            posicaoTremB += velocidadeTremB;
                            System.out.println("KM DO trem B " + posicaoTremB);
                            break;
                        }
                        break;

                    } catch (InputMismatchException e) {
                        System.out.println("Você digitou um caractere Inválido!");
                    }

                }
                if (opt == 2) {

                    System.out.println("FIM DO PROGRAMA!");
                    break;

                } else {
                    System.out.println("Valor Inválido!\n");

                }
            }
            catch (NumberFormatException e) {
                System.out.println("\nValor Inválido!\n");

            }
        }
    }
}
