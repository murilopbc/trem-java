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
                                System.out.println("Posição inválida do Trem A!");
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
                            System.out.println("Digite a velocidade do trem A em Km/h: ");
                            velocidadeTremA = sc.nextDouble();

                            if (velocidadeTremA > 300 || velocidadeTremA < 0) {
                                System.out.println("Digite um valor entre 0 a 300");
                                continue;
                            }
                            posicaoTremA += velocidadeTremA;
                            System.out.println("KM atual do trem A: " + posicaoTremA);
                            break;

                        } catch (InputMismatchException e) {
                            System.out.println("Você digitou um caractere inválido!");
                            sc.next();
                        }
                    }

                    while (true) {
                        try {
                            System.out.println("\nDigite a posição inicial do Trem B: ");
                            posicaoTremB = sc.nextDouble();

                            if (posicaoTremB <= posicaoInicial || posicaoTremB > posicaoFinal || posicaoTremB <= posicaoTremA) {
                                System.out.println("Posição inválida do Trem B");
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
                            System.out.println("Digite a velocidade do trem B em Km/h: ");
                            velocidadeTremB = sc.nextDouble();

                            if (velocidadeTremB < -300 || velocidadeTremB > 0) {
                                System.out.println("Digite um valor entre 0 e -300!");
                                continue;
                            }
                            posicaoTremB += velocidadeTremB;
                            System.out.println("KM atual do trem B " + posicaoTremB);
                            sc.next();
                            break;

                        } catch (InputMismatchException e) {
                            System.out.println("Você digitou um caractere inválido!");
                            sc.next();
                        }
                    }

                    if (posicaoTremB <= posicaoTremA ){
                        System.out.printf("A colisão de trens acontecerá no KM %f e ocorrerá", posicaoTremB);
                    }
                    if (velocidadeTremA == 0 && velocidadeTremB == 0 ){
                        System.out.println("Os trens não colidiram!");
                        break;
                    }

                }

                if (opt == 2) {
                    System.out.println("FIM DO PROGRAMA!");
                    break;

                } else {
                    System.out.println("Digite 1 ou 2!\n");

                }
            } catch (NumberFormatException e) {
                System.out.println("\nValor Inválido!\n");

            }
        }
    }
}
