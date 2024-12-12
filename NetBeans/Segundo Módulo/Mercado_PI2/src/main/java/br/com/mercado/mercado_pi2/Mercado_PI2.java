

package br.com.mercado.mercado_pi2;

import java.util.List;
import mercado.dao.CargoDAO;
import mercado.model.Cargo;
import mercado.view.Login;


public class Mercado_PI2 {

    public static void main(String[] args) {
        CargoDAO cDao = new CargoDAO();
//        List<Cargo> lista = cDao.ListarCargo();
//        for (Cargo c : lista) {
//            System.out.println(c);
//        }
        new Login().setVisible(true);

    }
}
