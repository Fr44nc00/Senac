package br.com.senac.financasjpa.persistencia;

import jakarta.persistence.EntityManager;
import br.com.senac.financasjpa.Despesa;
import jakarta.persistence.Query;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DespesaDAO {

    public void cadastrar(Despesa d){
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(d);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            throw e;
        }
        finally{
            JPAUtil.closeEntityManager();
        }
    }
    
    public List<Despesa> listar(String filtroDescricao, String dataIni, String dataFim){
        EntityManager em = JPAUtil.getEntityManager();
        List despesas = null;
        try{
            String textoQuery = "SELECT d FROM Despesa d "+
                    " WHERE (:descricao is null OR d.descricao LIKE :descricao ) "+
                    " AND (:dataInicial is null OR d.data >= :dataInicial)"+
                    " AND (:dataFinal is null OR d.data <= :dataFinal)";

            Query consulta = em.createQuery(textoQuery);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/y");

            consulta.setParameter("descricao", filtroDescricao.isEmpty() ? null : "%" + filtroDescricao + "%" );
            consulta.setParameter("dataInicial", dataIni.isEmpty() ? null : LocalDate.parse(dataIni, formatter));
            consulta.setParameter("dataFinal", dataFim.isEmpty() ? null : LocalDate.parse(dataFim, formatter));

            despesas = consulta.getResultList();
        }finally{
            JPAUtil.closeEntityManager();
        }
        return despesas;
    }
    
    //O método obter() será útil para recuperar o registro selecionado na tela de listagem
    //de despesas. O método atualizar(), por sua vez, é responsável por salvar as
    //informações no banco de dados usando o método merge() de EntityManager. A intenção
    //agora é usar a mesma tela de cadastro para realizar a edição
    
    public Despesa obter(int id){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            return em.find(Despesa.class, id);
        }finally{
            JPAUtil.closeEntityManager();
        }
    }
        
    public void atualizar(Despesa d){
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(d);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            throw e;
        }
        finally{
            JPAUtil.closeEntityManager();
        }
    }
    
    public void excluir(int id){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            Despesa d = em.find(Despesa.class, id);
            if(d != null){
                em.getTransaction().begin();
                em.remove(d);
                em.getTransaction().commit();
            }
        }catch(Exception e){
            em.getTransaction().rollback();
            throw e;
        }
        finally{
            JPAUtil.closeEntityManager();
        }
        
        //No método, você primeiro busca o registro que deseja excluir (a partir de seu id)
        //e depois o remove no repositório. É importante lembrar que, nessa operação, você
        //deve usar transações: commit(), quando tudo estiver OK, ou rollback(), caso tenha
        //havido falha.
    }

}
