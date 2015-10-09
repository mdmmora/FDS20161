package TAD.testes;

public class TestaCadastroAVL
{
    
    public static void main(String args[])
    {
        CadastroDeClientes cad = new CadastroDeClientes();
        
        cad.insere("Joao Silva", "Rua dos Andradas 1212", "123456789/12", 12, 9, 1980);
        cad.insere("Maria Rita", "Av. Ipiranga 902/302", "122456444/23", 26, 5, 1965);
        cad.insere("Pedro Moraes", "Rua Padre Chagas 234/506", "989456789/49", 30, 2, 1985);
        cad.insere("Ana Sakura", "Rua Pedro Ivo 234", "321455789/58", 5, 10, 1975);
        cad.insere("Carlos Miura", "Av. Bento Gonçalves 1898/401", "223456589/61", 18, 7, 1973);
        cad.insere("Patricia Raida", "Av. Independência 802/101", "908416789/72", 20, 8, 1978);
        
        System.out.println("Todos Clientes: \n" + cad.getRelatorio());
            
        if (cad.exclui("Carlos Miura"))
            System.out.println("Cliente Carlos Miura removido com sucesso!!");
        else
            System.out.println("Problemas na exclusão do cliente Carlos Miura");
            
        if (cad.alteraEndereco("Maria Rita","Rua Lucas de Oliveira 2345/506"))
            System.out.println("Endereco da Maria Rita alterado com sucesso!!");
        else
            System.out.println("Não foi possível alterar o endereco da Maria Rita");
            
        System.out.println("Todos Clientes: \n" + cad.getRelatorio());
        
        if (cad.pesquisa("Patricia Raida"))
            System.out.println("Cliente Patricia Raida consta no cadastro");
        else
            System.out.println("Cliente Patricia Raida não consta no cadastro");          
    }
}
