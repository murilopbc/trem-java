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
                            System.out.println("Digite a posição inicial do trem A: ");
                            posicaoTremA = sc.nextDouble();

                            if (posicaoTremA < posicaoInicial || posicaoTremA >= posicaoFinal) {
                                System.out.println("Posição Inválida Inicial do Trem A!");
                                continue;
                            }
                            break;

                        } catch (InputMismatchException e) {
                            System.out.println("Valor Inválido!");
                            sc.next();
                        }
                    }

                    while (true) {
                        try {
                            System.out.println("Digite quantos KM o trem A deseja andar: ");
                            velocidadeTremA = sc.nextDouble();

                            if (velocidadeTremA > 300 || velocidadeTremA <= 0) {
                                System.out.println("Digite um valor maior que 0 e menor que 300");
                                continue;
                            }
                            posicaoTremA += velocidadeTremA;
                            System.out.println("KM atual do trem A: " + posicaoTremA);
                            break;


                        } catch (InputMismatchException e) {
                            System.out.println("Você digitou um caractere Inválido!");
                        }
                    }

                    while (true) {
                        try {
                            System.out.println("\nDigite a posição inicial do Trem B: ");
                            posicaoTremB = sc.nextDouble();

                            if (posicaoTremB <= posicaoInicial || posicaoTremB > posicaoFinal) {
                                System.out.println("Posição Inválida Inicial do Trem B");
                                continue;
                            }
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Valor Inválido!");
                            sc.next();
                        }
                    }

                    while (true) {
                        try {
                            System.out.println("Digite quantos KM o trem B deseja andar: ");
                            velocidadeTremB = sc.nextDouble();

                            if (velocidadeTremB < -300 || velocidadeTremB >= 0) {
                                System.out.println("Digite um valor menor que 0 e até -300!");
                                continue;
                            }
                            posicaoTremB += velocidadeTremB;
                            System.out.println("KM atual DO trem B " + posicaoTremB);
                            break;

                        } catch (InputMismatchException e) {
                            System.out.println("Você digitou um caractere Inválido!");
                        }
                    }
                    break;

                    // fazer conferência se encostou ou não

                }

                if (opt == 2) {
                    System.out.println("FIM DO PROGRAMA!");
                    break;

                } else {
                    System.out.println("Valor Inválido!\n");

                }
            } catch (NumberFormatException e) {
                System.out.println("\nValor Inválido!\n");

            }
        }
    }
}
