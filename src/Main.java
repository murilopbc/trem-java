import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        double posicaoInicial = 0, posicaoFinal = 10000;
        int opt, escolha, velocidadeTremB, velocidadeTremA, posicaoTremA, posicaoTremB;

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

        if (opt == 1) {
            while (true) {
                while (true) {
                    try {
                        System.out.println("\nDigite a posição inicial do trem A: ");
                        posicaoTremA = Integer.parseInt(sc.nextLine());

                        if (posicaoTremA < posicaoInicial || posicaoTremA > posicaoFinal) {
                            System.err.println("\nDigite uma posição entre 0 e 10.000!");
                            continue;
                        }
                        break;
                    } catch (NumberFormatException e) {
                        System.err.println("\nValor Inválido");
                    }
                }

                while (true) {
                    try {
                        System.out.println("\nDigite a posição inicial do trem B: ");
                        posicaoTremB = Integer.parseInt(sc.nextLine());

                        if (posicaoTremB < posicaoInicial || posicaoTremB > posicaoFinal || posicaoTremA == posicaoTremB) {
                            System.err.println("\nDigite uma posição entre 0 e 10.000!");
                            continue;
                        }
                        break;

                    } catch (NumberFormatException e) {
                        System.err.println("\nValor Inválido");
                    }
                }
                while (true) {
                    try {
                        System.out.println("\nDigite a velocidade do trem A: ");
                        velocidadeTremA = Integer.parseInt(sc.nextLine());

                        if (velocidadeTremA > 300 || velocidadeTremA < 0) {
                            System.err.println("\nDigite um valor entre 0 a 300");
                            continue;
                        }
                        break;

                    } catch (NumberFormatException e) {
                        System.err.println("\nValor Inválido");
                    }
                }
                while (true) {
                    try {
                        System.out.println("\nDigite a velocidade do trem B: ");
                        velocidadeTremB = Integer.parseInt(sc.nextLine());

                        if (velocidadeTremB > 0 || velocidadeTremB < -300) {
                            System.err.println("\nDigite um valor entre 0 a -300");
                            continue;
                        }
                        break;

                    } catch (NumberFormatException e) {
                        System.err.println("\nValor Inválido");
                    }
                }

                if (posicaoTremB < posicaoTremA || velocidadeTremA == 0 && velocidadeTremB == 0) {
                    System.out.println("\nOs trens não colidiram!");
                    continue;

                }

                int hora = 17;
                double tempo = 0.0, horas, minuto, segundo;
                String horario;

                double t = (double) (posicaoTremA - posicaoTremB) / (velocidadeTremB - velocidadeTremA);
                double segundos = t * 3600;
                double km = posicaoTremA + (velocidadeTremA * t);

                horas = t + hora;
                minuto = (tempo/60)%60;
                segundo = tempo % 60;


                // Formatando a hora
                horario = String.format("%02.0f:%02.0f:%02.0f", horas, minuto, segundo);


                System.out.printf("\nA colisão de trens acontecerá no KM %.0f e ocorrerá após %.0f segundos no horário %s\n", km, segundos, horario);

                while (true) {
                    try {
                        System.out.println("\nDeseja jogar novamente?\n1-Sim\n2-Não");
                        escolha = Integer.parseInt(sc.nextLine());

                        if (escolha <= 0 || escolha > 2) {
                            System.err.println("\nDigite 1 ou 2!");
                            continue;
                        }
                        break;

                    } catch (NumberFormatException e) {
                        System.err.println("\nValor Inválido!");
                    }
                }
                if (escolha == 2) {
                    System.out.println("\nFIM DO PROGRAMA!");
                    return;
                }
            }
        }
    }
}
