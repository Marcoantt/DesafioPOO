import java.util.Scanner;

public class Iphone implements AparelhoTelefonico, NavegadorInternet, ReprodutorMusical {
    Scanner scanner = new Scanner(System.in);
    public void main(String[] args) {
        boolean iphoneLigado = true;
        while (iphoneLigado) {
            System.out.println("\n----------X----------\n\nOpcoes disponiveis:\n 1 - Conferir ligacoes;\n 2 - Reproduzir musicas;\n 3 - Acessar o navegador;\n 0 - Desligar o iPhone.");
            switch (selecionarOpcao()) {
                case 1 -> {
                    System.out.println("\nAbrindo aplicativo de ligacoes.");
                    conferirLigacoes();
                }

                case 2 -> {
                    System.out.println("\nAbrindo aplicativo de musica.");
                    reproduzirMusicas();
                }

                case 3 -> {
                    System.out.println("\nAbrindo o aplicativo de navegacao da internet.");
                    navegarInternet();
                }

                case 0 -> {
                    System.out.println("\nDesligando o aparelho...");
                    iphoneLigado = false;
                }

                default -> System.out.println("\nOpcao invalida.");
            }
        }
    }



    //Metodos do Iphone



    public int selecionarOpcao() {
        System.out.println("\nSelecione a opcao desejada.");
        int opcao = scanner.nextInt();
        return opcao;
    }

    private void reproduzirMusicas() {
        String[] listaMusicas = {
            "Reflexos do Crepusculo - TakaB",
            "Redencao - Henrique Mendonca",
            "Dorian Gray - Chrono Rapper",
            "9.9.9 - M4rkim",
            "Abismo - Chrono Rapper",
            "Ecos da Dissolucao - TakaB",
            "Saudem o Rei - Enygma Rapper",
            "My Marmalade - Katya Lel"};
        System.out.println("Inicializando aplicativo de reproducao musical.");
        selecionarMusica(listaMusicas);
        boolean reproduzindo = true;
        boolean tocando = true;
        while (reproduzindo) {
            System.out.println("\n----------X----------\n\nOpcoes disponiveis:\n 1 - Pausar musica;\n 2 - Tocar musica;\n 3 - Trocar musica;\n 0 - Sair do aplicativo.");
            switch (selecionarOpcao()) {
                case 1 -> {
                    if (tocando) {
                        pausarMusica();
                        tocando = false;
                    } else {
                        System.out.println("A musica ja esta pausada.");
                    }
                }

                case 2 -> {
                    if (tocando) {
                        System.out.println("A musica ja esta tocando.");
                    } else {
                        tocarMusica();
                        tocando = true;
                    }
                }

                case 3 -> selecionarMusica(listaMusicas);

                case 0 -> {
                    System.out.println("Fechando o aplicativo de musica...");
                    reproduzindo = false;
                }

                default -> System.out.println("Opcao invalida!");
            }
        }
    }

    private void navegarInternet() {
        System.out.println("Inicializando o navegador de internet.");
        boolean navegando = true;
        while (navegando) {
            System.out.println("\n----------X----------\n\nOpcoes disponiveis:\n 1 - Abrir nova aba;\n 2 - Atualizar pagina;\n 0 - Sair do aplicativo.");
            switch (selecionarOpcao()) {
                case 1 -> adicionarNovaAba();

                case 2 -> atualizarPagina();

                case 0 -> {
                    System.out.println("Fechando o navegador de internet...");
                    navegando = false;
                }

                default -> System.out.println("Opcao invalida!");
            }
        }
    }

    private void conferirLigacoes() {
        System.out.println("Inicializando aplicativo de ligacoes.");
        boolean conferindo = true;
        boolean mensagensCorreioVoz = true;
        while (conferindo) {
            System.out.println("\n----------X----------\n\nOpcoes disponiveis:\n 1 - Iniciar correio de voz;\n 2 - Fazer uma ligacao;\n 3 - Receber uma ligacao;\n 0 - Sair do aplicativo.");
            switch (selecionarOpcao()) {
                case 1 -> mensagensCorreioVoz = iniciarCorreioVoz(mensagensCorreioVoz);

                case 2 -> ligar();

                case 3 -> receberLigação();

                case 0 -> {
                    System.out.println("Fechando o aplicativo de ligacoes...");
                    conferindo = false;
                }

                default -> System.out.println("Opcao invalida!");
            }
        }
    }



    //Metodos implementados 



        //Metodos do Aparelho Telefonico:



    @Override
    public boolean iniciarCorreioVoz(boolean mensagensCorreioVoz) {
        if (mensagensCorreioVoz) {
            System.out.println("Você tem mensagens para ouvir no seu Correio de Voz. Deseja ouvir agora?\n > Nao = 0\n > Sim = 1");
            int ouvirMensagens = scanner.nextInt();
            if (ouvirMensagens == 1) {
                System.out.println("Você ouviu as mensagens no seu Correio de Voz!\n");
                return false;
            }
        } else {
            System.out.println("Você não tem mensagens no seu Correio de Voz.\n");
        }
    return true;
    }

    @Override
    public void ligar() {
        System.out.println("Digite o numero de telefone que deseja ligar:");
        long numero = scanner.nextLong();
        System.out.println("Ligando para o numero " + numero + "...");
    }

    @Override
    public void receberLigação() {
        System.out.println("Recebendo ligação. Deseja atender?\n > Nao = 0\n > Sim = 1");
        int atendido = scanner.nextInt();
        if (atendido == 1) {
            atender();
        }        
    }

    @Override
    public void atender() {
        System.out.println("Ligação atendida!");
        System.out.println("\n- Olá!\n- Tudo bem?\n- Muito obrigado por estar usando o meu programa!\n- Sei que ele e bem simples, mas foi bem trabalhoso.\n- Tambem sei que esta cheio de erros, mas ainda estou aprendendo.\n- E acredito que erros fazem parte do aprendizado!\n- Tenha um otimo dia!\n- Desligando!");
    }



        //Metodos do Navegador Internet:



    @Override
    public void adicionarNovaAba() {
        System.out.println("Digite o URL da aba desejada.");
        String url = scanner.next();
        exibirPagina(url);
    }

    @Override
    public void atualizarPagina() {
        System.out.println("Atualizando página...\nPágina atualizada!");
    }

    @Override
    public void exibirPagina(String url) {
        System.out.println("Exibindo a página de url '" + url + "'");
    }



        //Metodos do Reprodutor Musical:



    @Override
    public void pausarMusica() {
        System.out.println("Música pausada!");
    }

    @Override
    public void selecionarMusica(String[] listaMusicas) {
        System.out.println("Exibindo lista de músicas");
        int indice = 0;
        for (String musica : listaMusicas) {
            System.out.println(" Musica nº"+(indice+1)+ " - " + musica);
            indice++;
        }
        System.out.println("Selecione o numero da musica desejada: ");
        indice = scanner.nextInt();
        System.out.println("A musica "+ listaMusicas[(indice-1)] +" foi selecionada!");
        tocarMusica();
    }

    @Override
    public void tocarMusica() {
        System.out.println("Música tocando!");
    }
}
