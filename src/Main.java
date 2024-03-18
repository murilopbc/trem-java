import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        double posicaoInicial = 0, posicaoFinal = 10000, posicaoTremA, posicaoTremB, velocidadeTremA, velocidadeTremB;
        int opt, escolha;

        while (true) {
            try {
                System.out.println("\n1-Jogar\n2-Sair");
                opt = Integer.parseInt(sc.nextLine());

                if (opt != 1 && opt != 2) {
                    System.err.println("\nDigite 1 ou 2!");
                    continue;
                }
                break;

            } catch (NumberFormatException e) {
                System.err.println("\nValor Inválido!\n");

            }
        }
        while (true) {
            if (opt == 1) {
                while (true) {
                    try {
                        System.out.println("\nDigite a posição inicial do trem A: ");
                        posicaoTremA = sc.nextDouble();

                        if (posicaoTremA < posicaoInicial || posicaoTremA > posicaoFinal) {
                            System.err.println("\nDigite uma posição entre 0 e 10.000!");
                            continue;
                        }
                        break;

                    }
                    catch (InputMismatchException e) {
                        System.err.println("\nValor Inválido");
                        sc.next();
                    }

                }

                while (true) {
                    try {
                        System.out.println("\nDigite a posição inicial do trem B: ");
                        posicaoTremB = sc.nextDouble();

                        if (posicaoTremB < posicaoInicial || posicaoTremB > posicaoFinal) {
                            System.err.println("\nDigite uma posição entre 0 e 10.000!");
                            continue;
                        }
                        break;

                    } catch (InputMismatchException e) {
                        System.err.println("\nValor Inválido");
                    }
                }
                while (true) {
                    try {
                        System.out.println("\nDigite a velocidade do trem A: ");
                        velocidadeTremA = sc.nextDouble();

                        if (velocidadeTremA > 300 || velocidadeTremA < 0) {
                            System.err.println("\nDigite um valor entre 0 a 300");
                            continue;
                        }
                        break;

                    } catch (InputMismatchException e) {
                        System.out.println("\nValor Inválido");
                    }
                }
                while (true) {
                    try {
                        System.out.println("\nDigite a velocidade do trem B: ");
                        velocidadeTremB = sc.nextDouble();

                        if (velocidadeTremB > 0 || velocidadeTremB < -300) {
                            System.err.println("\nDigite um valor entre 0 a -300");
                            continue;
                        }
                        break;

                    } catch (InputMismatchException e) {
                        System.out.println("\nValor Inválido");
                        sc.next();
                    }
                }

                double t = (posicaoTremA - posicaoTremB) / (velocidadeTremB - velocidadeTremA);
                double segundos = t * 3600;
                double km = posicaoTremA + (velocidadeTremA * t);

                System.out.printf("\nA colisão de trens acontecerá no KM %.0f e ocorrerá após %.0f segundos", km, segundos);


                while (true) {
                    try {
                        System.out.println("\nDeseja jogar novamente?\n1-Sim\n2-Não");
                        escolha = Integer.parseInt(sc.nextLine());

                        if (escolha != 1 && escolha != 2) {
                            System.err.println("\nDigite 1 ou 2!");
                            continue;
                        }
                        break;

                    } catch (InputMismatchException e) {
                        sc.next();
                        System.err.println("\nValor Inválido!\n");
                    }
                }
                while (true){
                    if (escolha == 1){
                        break;
                    }
                    System.out.println("FIM DO PROGRAMA!");
                    return;
                }
            }
            System.out.println("FIM DO PROGRAMA!");
            break;
        }
    }
}
