package TAD.testes;

public class TestaCadastro
{
    public void teste()
    {
        CadastroDeFuncionarios cad = new CadastroDeFuncionarios();
        cad.insere("Arlete Carraros", 20009123456L, (float)2008.90);
        cad.insere("Alberto Marbelo", 26578978634L, (float)1534.23);
        cad.insere("Marialba Souza", 78981078631L, (float)3289.50);
        cad.insere("João Silva", 72333460034L, (float)980.00);
        cad.insere("Paulo Santos", 68889121023L, (float)1708.10);
        cad.insere("Maria Mendes", 91990124536L, (float)1001.46);
        
        System.out.println("\nTodos Funcionarios: \n" + cad.getRelatorio());
           
        System.out.println("Primeiro funcionario do cadastro: "+cad.getPrimeiroFuncionarioCadastro());
        System.out.println("Ultimo funcionario do cadastro: "+cad.getUltimoFuncionarioCadastro()+"\n");
        
        if (cad.exclui(20009123456L))
            System.out.println("Funcionario de CPF 20009123456 removido com sucesso!!");
        else
            System.out.println("Problemas na exclusão do funcionario de CPF 20009123456!!");
            
        if (cad.alteraSalarioFuncionario(72333460034L,(float)1010.00))
            System.out.println("Funcionario de CPF 72333460034 teve o valor do salário alterado com sucesso!!");
        else
            System.out.println("Não foi possível alterar o valor do salário do funcionario de CPF 72384460034!!");

        if (cad.alteraSalarioFuncionario(68889121023L,4000))
            System.out.println("Funcionario de CPF 68889121023 teve o valor do salário alterado com sucesso!!");
        else
            System.out.println("Não foi possível alterar o valor do salário do funcionario de CPF 68889121023!!"); 
            
        if (cad.exclui(91990124536L))
            System.out.println("Funcionario de CPF 91990124536 removido com sucesso!!");
        else
            System.out.println("Problemas na exclusão do funcionario de CPF 91990124536!!");
            
        if (cad.pesquisa("Arlete Carraros"))
            System.out.println("Funcionario Arlete Carraros consta no cadastro");
        else
            System.out.println("Funcionario Arlete Carraros não consta no cadastro");         
            
        System.out.println("\nTodos Funcionarios: \n" + cad.getRelatorio());            
    }
}
