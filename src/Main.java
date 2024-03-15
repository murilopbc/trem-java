import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        double posicaoInicial = 0, posicaoFinal = 10000, posicaoTremA, posicaoTremB, velocidadeTremA, velocidadeTremB;
        int opt;

        while (true) {
            try {
                System.out.println("1-Jogar\n2-Sair");
                opt = Integer.parseInt(sc.nextLine());

                if (opt == 1) {
                    while (true) {
                        try {
                            System.out.println("\nDigite a posição inicial do trem A: ");
                            posicaoTremA = sc.nextDouble();
                            System.out.println("\nDigite a posição inicial do Trem B: ");
                            posicaoTremB = sc.nextDouble();

                            if (posicaoTremA < posicaoInicial || posicaoTremB < posicaoInicial || posicaoTremA > posicaoFinal || posicaoTremB > posicaoFinal) {
                                System.err.println("\nDigite uma posição entre 0 e 10.000!");
                                continue;
                            }
                            if (posicaoTremB <= posicaoTremA) {
                                System.out.println("\nOs trens não colidiram!");
                                continue;
                            }
                            while (true) {
                                try {
                                    System.out.println("\nDigite a velocidade do trem A em Km/h: ");
                                    velocidadeTremA = sc.nextDouble();
                                    System.out.println("\nDigite a velocidade do trem B em Km/h: ");
                                    velocidadeTremB = sc.nextDouble();

                                    if (velocidadeTremA > 300 || velocidadeTremA < 0 || velocidadeTremB < -300 || velocidadeTremB > 0) {
                                        System.err.println("\nDigite um valor entre 0 a 300, sendo que a velocidade do trem B deve ser negativo!");
                                    }
                                    if (velocidadeTremA == 0 && velocidadeTremB == 0) {
                                        System.out.println("\nOs trens não colidiram!");
                                    }

                                    // Lógica colisão

                                    double t = (posicaoTremA - posicaoTremB) / (velocidadeTremB - velocidadeTremA);
                                    double segundos = t * 3600;
                                    double km = posicaoTremA + (velocidadeTremA * t);

                                    System.out.printf("\nA colisão de trens acontecerá no KM %.0f e ocorrerá após %.0f segundos", km, segundos);
                                    sc.next();
                                    break;


                                } catch (InputMismatchException e) {
                                    System.err.println("\nVocê digitou um caractere inválido!");
                                    sc.next();
                                }
                            }
                        } catch (InputMismatchException e) {
                            System.err.println("Valor Inválido!");

                        }
                        sc.nextLine();
                        break;
                    }

                }
                if (opt == 2) {
                    System.out.println("FIM DO PROGRAMA!");
                    break;

                } else {
                    System.err.println("\nDigite 1 ou 2!\n");
                }
            } catch (NumberFormatException e) {
                System.err.println("\nValor Inválido!\n");

            }

        }
    }
}
