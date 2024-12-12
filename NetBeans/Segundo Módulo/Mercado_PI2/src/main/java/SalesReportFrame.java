import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SalesReportFrame extends JFrame {
    private JPanel mainPanel;
    private JButton dailyButton;
    private JButton weeklyButton;
    private JButton monthlyButton;
    private JTable salesTable;
    private JTable topProductsTable;
    private JTable trendsTable;
    private JTable profitMarginTable;

    public SalesReportFrame() {
        setTitle("Relatórios de Vendas");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // North Panel with Buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        dailyButton = new JButton("Diário");
        weeklyButton = new JButton("Semanal");
        monthlyButton = new JButton("Mensal");

        buttonPanel.add(dailyButton);
        buttonPanel.add(weeklyButton);
        buttonPanel.add(monthlyButton);

        mainPanel.add(buttonPanel, BorderLayout.NORTH);

        // Center Panel with Tables
        JPanel tablesPanel = new JPanel();
        tablesPanel.setLayout(new GridLayout(2, 2));

        salesTable = new JTable();
        topProductsTable = new JTable();
        trendsTable = new JTable();
        profitMarginTable = new JTable();

        tablesPanel.add(new JScrollPane(salesTable));
        tablesPanel.add(new JScrollPane(topProductsTable));
        tablesPanel.add(new JScrollPane(trendsTable));
        tablesPanel.add(new JScrollPane(profitMarginTable));

        mainPanel.add(tablesPanel, BorderLayout.CENTER);

        // Add action listeners to buttons
        dailyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadSalesData("daily");
            }
        });

        weeklyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadSalesData("weekly");
            }
        });

        monthlyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadSalesData("monthly");
            }
        });

        add(mainPanel);
    }

    private void loadSalesData(String period) {
        // Mock data for demonstration purposes
        Object[][] salesData = {
                {"01/06/2024", "Produto A", 100, 500.00},
                {"02/06/2024", "Produto B", 150, 750.00},
        };

        Object[][] topProductsData = {
                {"Produto A", 500},
                {"Produto B", 400},
        };

        Object[][] trendsData = {
                {"Tendência A", "Alta"},
                {"Tendência B", "Baixa"},
        };

        Object[][] profitMarginData = {
                {"Produto A", 20.00},
                {"Produto B", 15.00},
        };

        String[] salesColumns = {"Data", "Produto", "Quantidade", "Valor"};
        String[] topProductsColumns = {"Produto", "Quantidade Vendida"};
        String[] trendsColumns = {"Tendência", "Status"};
        String[] profitMarginColumns = {"Produto", "Margem de Lucro (%)"};

        salesTable.setModel(new DefaultTableModel(salesData, salesColumns));
        topProductsTable.setModel(new DefaultTableModel(topProductsData, topProductsColumns));
        trendsTable.setModel(new DefaultTableModel(trendsData, trendsColumns));
        profitMarginTable.setModel(new DefaultTableModel(profitMarginData, profitMarginColumns));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SalesReportFrame().setVisible(true);
            }
        });
    }
}
