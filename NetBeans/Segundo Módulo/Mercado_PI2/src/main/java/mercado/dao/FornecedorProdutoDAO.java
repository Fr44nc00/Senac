
package mercado.dao;

import Connection.ConnectionFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;
import mercado.model.Fornecedor;
import mercado.model.FornecedorProduto;
import mercado.model.Produto;


public class FornecedorProdutoDAO {
    
    public List<Object[]> ListarProdutos() {
        EntityManager em = ConnectionFactory.getEntityManager();
        try {

            Query consulta = em.createQuery("SELECT fp.produto.id, fp.produto.nome, fp.produto.marca, fp.preco, fp.quantidade, fp.fornecedor.nome FROM FornecedorProduto fp");
            List<Object[]> Produtos = consulta.getResultList();
            
            return Produtos;

        } finally {
            ConnectionFactory.closeEntityManager();
        }
    }
    
       public void Insert(FornecedorProduto fp){
       EntityManager em = ConnectionFactory.getEntityManager();
         
        try{
            em.getTransaction().begin();
            em.persist(fp);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            throw e;
        }finally{
    ConnectionFactory.closeEntityManager();
        }
    }
       
       public void atualizar(FornecedorProduto fp) {
        EntityManager em = ConnectionFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(fp);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            ConnectionFactory.closeEntityManager();
        }
    }
       
        public FornecedorProduto BuscarFPId(int produtoId, int fornecedorId){
        EntityManager em = ConnectionFactory.getEntityManager();
        FornecedorProduto fp = null;
        try{
        Query consulta = em.createQuery("SELECT fp FROM FornecedorProduto fp WHERE fp.produto.id = :pId AND fp.fornecedor.id = :pId2");
        consulta.setParameter("pId", produtoId);
        consulta.setParameter("pId2", fornecedorId);
        fp = (FornecedorProduto) consulta.getSingleResult();
       }catch(Exception e){
           em.getTransaction().rollback();
           throw e;
       }finally{
           ConnectionFactory.closeEntityManager();
       }
       return fp;
    }
        
        public List<Object[]> FiltrarProdutos(String nome) { //Filtra por nome do produto
        EntityManager em = ConnectionFactory.getEntityManager();
        try {

            Query consulta = em.createQuery("SELECT fp.produto.id, fp.produto.nome, fp.produto.marca, fp.preco, fp.quantidade, fp.fornecedor.nome FROM FornecedorProduto fp WHERE fp.produto.nome = :pNome");
            consulta.setParameter("pNome", nome);
            List<Object[]> Produtos = consulta.getResultList();
            return Produtos;

        }catch(Exception e){
            em.getTransaction().rollback();
            throw e;
            
        } finally {
            ConnectionFactory.closeEntityManager();
        }
    }
        public List<Object[]> FiltrarProdutosId(String id) { //Filtra por nome do produto
        EntityManager em = ConnectionFactory.getEntityManager();
        try {

            Query consulta = em.createQuery("SELECT fp.produto.id, fp.produto.nome, fp.produto.marca, fp.preco, fp.quantidade, fp.fornecedor.nome FROM FornecedorProduto fp WHERE fp.produto.id = :pId");
            consulta.setParameter("pId", id);
            List<Object[]> Produtos = consulta.getResultList();
            return Produtos;

        }catch(Exception e){
            em.getTransaction().rollback();
            throw e;
            
        } finally {
            ConnectionFactory.closeEntityManager();
        }
    }
     
      public List<Object[]> FiltrarProdutos(String nome, String id) { //Filtra por nome do produto e id
        EntityManager em = ConnectionFactory.getEntityManager();
        try {

            Query consulta = em.createQuery("SELECT fp.produto.id, fp.produto.nome, fp.produto.marca, fp.preco, fp.quantidade, fp.fornecedor.nome FROM FornecedorProduto fp WHERE fp.produto.nome = :pNome AND fp.produto.id = :pId");
            consulta.setParameter("pNome", nome);
            consulta.setParameter("pId", id);
            List<Object[]> Produtos = consulta.getResultList();
            return Produtos;
            
            }catch(Exception e){
            em.getTransaction().rollback();
            throw e;
            
        } finally {
            ConnectionFactory.closeEntityManager();
        }
    }
      
       public List<Object[]> FiltrarProdutos(String nome, String id, String fornecedor) { //Filtra por nome do produto, id e fornecedor
        EntityManager em = ConnectionFactory.getEntityManager();
        try {

            Query consulta = em.createQuery("SELECT fp.produto.id, fp.produto.nome, fp.produto.marca, fp.preco, fp.quantidade, fp.fornecedor.nome FROM FornecedorProduto fp WHERE fp.produto.nome = :pNome AND fp.produto.id = :pId AND fp.fornecedor.nome = :pFornecedor");
            consulta.setParameter("pNome", nome);
            consulta.setParameter("pId", id);
            consulta.setParameter("pFornecedor", fornecedor);
            List<Object[]> Produtos = consulta.getResultList();
            return Produtos;
            
            }catch(Exception e){
            em.getTransaction().rollback();
            throw e;
            
        } finally {
            ConnectionFactory.closeEntityManager();
        }
    }
       
       public List<Object[]> filtrarFornecedor(String fornecedor) {
        EntityManager em = ConnectionFactory.getEntityManager();
        try {
            Query consulta = em.createQuery("SELECT fp.produto.id, fp.produto.nome, fp.produto.marca, fp.preco, fp.quantidade, fp.fornecedor.nome FROM FornecedorProduto fp WHERE fp.fornecedor.nome = :pFornecedor");
            consulta.setParameter("pFornecedor", fornecedor);
            List<Object[]> Produtos = consulta.getResultList();
            return Produtos;
            
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            ConnectionFactory.closeEntityManager();
        }
    }

    
    public List<Object[]> filtrarFornecedorENome(String fornecedor, String nome) {
        EntityManager em = ConnectionFactory.getEntityManager();
        try {
            Query consulta = em.createQuery("SELECT fp.produto.id, fp.produto.nome, fp.produto.marca, fp.preco, fp.quantidade, fp.fornecedor.nome FROM FornecedorProduto fp WHERE fp.fornecedor.nome = :pFornecedor AND fp.produto.nome = :pNome");
            consulta.setParameter("pFornecedor", fornecedor);
            consulta.setParameter("pNome", nome);
            List<Object[]> Produtos = consulta.getResultList();
            return Produtos;
            
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            ConnectionFactory.closeEntityManager();
        }
    }

    
    public List<Object[]> filtrarFornecedorEId(String fornecedor, String id) {
        EntityManager em = ConnectionFactory.getEntityManager();
        try {
            Query consulta = em.createQuery("SELECT fp.produto.id, fp.produto.nome, fp.produto.marca, fp.preco, fp.quantidade, fp.fornecedor.nome FROM FornecedorProduto fp WHERE fp.fornecedor.nome = :pFornecedor AND fp.produto.id = :pId");
            consulta.setParameter("pFornecedor", fornecedor);
            consulta.setParameter("pId", id);
            List<Object[]> Produtos = consulta.getResultList();
            return Produtos;
            
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            ConnectionFactory.closeEntityManager();
        }
    }
    
    public List<Object[]> FiltrarProdutosVenda(String nome) { //Filtra por nome do produto
        EntityManager em = ConnectionFactory.getEntityManager();
        try {

            Query consulta = em.createQuery("SELECT fp.produto.id, fp.produto.nome, fp.produto.marca, fp.preco, fp.produto.descricao FROM FornecedorProduto fp WHERE fp.produto.nome = :pNome");
            consulta.setParameter("pNome", nome);
            List<Object[]> Produtos = consulta.getResultList();
            return Produtos;

        }catch(Exception e){
            em.getTransaction().rollback();
            throw e;
            
        } finally {
            ConnectionFactory.closeEntityManager();
        }
    }
    
    public int ProdutosQuantidade(String nome) { //Filtra por nome do produto
        EntityManager em = ConnectionFactory.getEntityManager();
        try {

            Query consulta = em.createQuery("SELECT fp.quantidade FROM FornecedorProduto fp WHERE fp.produto.nome = :pNome");
            consulta.setParameter("pNome", nome);
            int quantidade = (int) consulta.getSingleResult();
            return quantidade;

        }catch(Exception e){
            em.getTransaction().rollback();
            throw e;
            
        } finally {
            ConnectionFactory.closeEntityManager();
        }
    }
       
    
       
       
}
