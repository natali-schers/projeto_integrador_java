package projetointegrador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProjetoIntegrador {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        BufferedReader inputString = new BufferedReader(new InputStreamReader(System.in));

        int escolha;
        int tipoCadastro;
        Usuario usuario = new Usuario();
        String email;
        String senha;
        int escolhaLogado;
        int escolhaEdicao;
        String dadoEdicao;

        do {
            System.out.println("\nEscolha uma opção: \n1 - Cadastro\n2 - Login\n10 - Sair");
            escolha = input.nextInt();

            switch (escolha) {
                case 1 -> {
                    System.out.println("\nVocê está se cadastrando como: \n1 - Aluno\n2 - Instituição de Ensino\n3 - Empresa");
                    tipoCadastro = input.nextInt();

                    if (tipoCadastro > 0 && tipoCadastro <= 3) {
                        System.out.print("\nDigite seu nome: ");
                        usuario.setNome(inputString.readLine());

                        System.out.print("Digite seu documento: ");
                        usuario.setDocumento(input.next());

                        System.out.print("Digite seu número de telefone: ");
                        usuario.setTelefone(inputString.readLine());

                        System.out.print("Digite seu email: ");
                        usuario.setEmail(input.next());

                        System.out.print("Digite sua senha: ");
                        usuario.setSenha(input.next());

                        usuario.Cadastro(usuario, tipoCadastro);
                    } else {
                        System.out.println("Opção inválida. Tente novamente!");
                    }
                }
                case 2 -> {
                    System.out.print("\nDigite seu e-mail: ");
                    email = input.next();

                    System.out.print("Digite sua senha: ");
                    senha = input.next();

                    Usuario usuarioLogado = usuario.Login(email, senha);
                    
                    if (usuarioLogado != null) {
                        System.out.println("Escolha uma opção: \n1 - Editar perfil\n2 - Enviar Relatório\n3 - Logoff");
                        escolhaLogado = input.nextInt();

                        switch (escolhaLogado) {
                            case 1:
                                System.out.println("\nQue informação deseja atualizar?\n1 - Nome\n2 - Documento\n3 - Telefone\n4 - Email\n5 - Senha");
                                escolhaEdicao = input.nextInt();
                                
                                System.out.print("Desejo substituir por: ");
                                dadoEdicao = inputString.readLine();
                                
                                usuario.EditarPerfil(usuarioLogado, escolhaEdicao, dadoEdicao);
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            default:
                                break;
                        }
                    } else {
                        System.out.println("Falha no login. Tente novamente!");
                    }
                }
                case 10 ->
                    System.out.println("Saindo...");
                default ->
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (escolha != 10);
    }
}
