package projetointegrador;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    protected int Id;
    protected String Nome;
    protected String Documento;
    protected String DataNascimento;
    protected String Telefone;
    protected String TelefoneSecundario;
    protected String Email;
    protected String EmailSecundario;
    protected String Senha;
    protected String Status;
    protected String TipoUsuario;
    protected List<Usuario> usuarios = new ArrayList<>();

    
    public Usuario() {}
    
    public Usuario(int Id, String Nome, String Documento, String DataNascimento, String Telefone, String Email, String Senha) {
        this.Id = Id;
        this.Nome = Nome;
        this.Documento = Documento;
        this.DataNascimento = DataNascimento;
        this.Telefone = Telefone;
        this.Email = Email;
        this.Senha = Senha;
    }
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getDocumento() {
        return Documento;
    }

    public void setDocumento(String Documento) {
        this.Documento = Documento;
    }

    public String getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(String DataNascimento) {
        this.DataNascimento = DataNascimento;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getTelefoneSecundario() {
        return TelefoneSecundario;
    }

    public void setTelefoneSecundario(String TelefoneSecundario) {
        this.TelefoneSecundario = TelefoneSecundario;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getEmailSecundario() {
        return EmailSecundario;
    }

    public void setEmailSecundario(String EmailSecundario) {
        this.EmailSecundario = EmailSecundario;
    }
    
    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getTipoUsuario() {
        return TipoUsuario;
    }

    public void setTipoUsuario(String TipoUsuario) {
        this.TipoUsuario = TipoUsuario;
    }
    
        public void Cadastro(Usuario usuario, int tipoCadastro) {
        usuario.Id++;
        
        switch(tipoCadastro) {
            case 1:
                usuario.setTipoUsuario("Aluno");
                break;
            case 2:
                usuario.setTipoUsuario("Instituição de Ensino");
                break;
            case 3:
                usuario.setTipoUsuario("Empresa");
                break;
        }
        
        this.usuarios.add(usuario);
    }

    public Usuario Login(String email, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                System.out.println("\nBem-vindo(a), " + usuario.getNome() + "!");
                return usuario;
            }
        }

        System.out.println("\nEmail ou senha incorretos!");
        return null;
    }

    public void EditarPerfil (Usuario usuario, int opcao, String dado) {
        switch(opcao) {
            case 1:
                usuario.setNome(dado);
                break;
            case 2: 
                usuario.setDocumento(dado);
                break;
            case 3:
                usuario.setTelefone(dado);
                break;
            case 4: 
                usuario.setEmail(dado);
                break;
            case 5: 
                usuario.setSenha(dado);
                break;
        }
        
        System.out.println("\nAtualizado com sucesso!");
    }
}