/*
Projeto feito no Maven

Para criar dependências, clicar com o botão direito na pasta "Dependencies"

Depois de adicionar as dependências (pesquise "Maven Central Repository" na internet e
digite "org.hibernate.orm hibernate-core" pra primeira dependência e "MySQL Connector Java"
e digite na criação da dependência os dados no primeiro resultado) clique no botão "Clean
and Build" (o martelo com uma vassoura)

Agora, deve ser criado um caminho de pastas que leia src/main/resources/META-INF através
da aba "Files" ao lado de "Projects".

Após isso, clique com o botão direito na pasta "META-INF" e crie um arquivo do tipo
"XML/XML Document" em "Other". Chame-o de "persistence.xml". É necessário que o caminho
e o nome do arquivo estejam exatamente assim: src/main/resources/META-INF/persistence.xml.
Caso não esteja, o Hibernate não será capaz de localizá-lo. 

Depois de clicar em Next, você pode optar por Well-formed Document e clicar em Finish.
*/
 package br.com.senac.financasjpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.time.LocalDate;
import br.com.senac.financasjpa.persistencia.DespesaDAO;
import br.com.senac.financasjpa.persistencia.JPAUtil;

public class FinancasJPA {

    public static void main(String[] args) {
        //Essa parte deve estar sempre no início do código
        EntityManagerFactory fabricaEntidade = Persistence.
                createEntityManagerFactory("Financas-PU");
        EntityManager manager = fabricaEntidade.createEntityManager();

        //Código para inclusão de dados no banco
        Despesa gasto = new Despesa();
        gasto.setDescricao("Primeira despesa");
        gasto.setValor(10.50);
        gasto.setData(LocalDate.of(2022, 5, 30));

        manager.getTransaction().begin();
        manager.persist(gasto);
        manager.getTransaction().commit();

        //Código para recuperação de dados do banco
        Despesa gasto2 = manager.find(Despesa.class, 1);
        System.out.println(gasto2.getDescricao());
        
        //Código para atualização de dados
        Despesa gasto3 = manager.find(Despesa.class, 1);

        manager.getTransaction().begin();
        gasto3.setDescricao("Despesa atualizada");
        manager.getTransaction().commit();
        
        //Código de atualização usando Merge
        Despesa gasto4 = new Despesa();
        gasto4.setId(1);
        gasto4.setDescricao("Atualizado com Merge");
        gasto4.setData(LocalDate.of(2022, 5, 30));

        manager.getTransaction().begin();
        manager.merge(gasto4);
        manager.getTransaction().commit();
        
        //Código para exclusão de dados
        Despesa gasto5 = manager.find(Despesa.class, 1);
        manager.getTransaction().begin();
        manager.remove(gasto5);
        manager.getTransaction().commit();  

        //Essa parte sempre deve estar no fim do código
        manager.close();
        fabricaEntidade.close();
    }
}             

//Usando o pacote br.com.senac.financasjpa.persistencia
//DespesaDAO despesaDao = new DespesaDAO();
//    
//Despesa d = new Despesa();
//d.setDescricao("Compras de mercado");
//d.setValor(165.70);
//d.setData(LocalDate.of(2022, 11, 15));
//
//despesaDao.cadastrar(d);
