package ui;

import data.Product;
import dto.ProductDto;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;
import main.Device;
import service.ShopDatabase;

public class ShopScreen extends javax.swing.JPanel {
    
    private final ShopDatabase db = new ShopDatabase();
    
    List<ProductDto> products;
    
    String imagePath = "";

    public ShopScreen() {
        Device device = new Device();
        initComponents();
        setTotal(spPrice, spQty, spDiscount);
        refress();
    }
    
    private void refress() {
        products = db.getProducts(Device._ownerId);
        DefaultTableModel model = (DefaultTableModel) tblProduct.getModel();
        model.setRowCount(0);
        if (!products.isEmpty()) {
            products.forEach(product -> {
                Object[] row = {
                    product.getId(),
                    product.getName(),
                    product.getQty(),
                    product.getPrice(),
                    product.getDiscount(),
                    product.getTotal(),
                    product.getImage(),
                    product.getOwner(),
                };
                model.addRow(row);
            });
        } else {
            System.out.println("Products is empty");
        }
        
        txtName.setText("");
        spPrice.setValue(0);
        spQty.setValue(1);
        spDiscount.setValue(0);
        txtTotal.setText("");
        lbImage.setIcon(null);
        imagePath = "";
    }

    private void setTotal(JSpinner spPrice, JSpinner spQty, JSpinner spDiscount) {
        double price = Double.parseDouble(spPrice.getValue().toString());
        int qty = (int) spQty.getValue();
        int discount = (int) spDiscount.getValue();
        double subTotal = qty * price;
        double total = subTotal - (subTotal * discount) / 100;

        txtTotal.setText(String.valueOf(total));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        spQty = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        lbImage = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        spDiscount = new javax.swing.JSpinner();
        btnChooseImage = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduct = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnSort = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        spPrice = new javax.swing.JSpinner();

        jLabel1.setFont(new java.awt.Font("Barlow", 1, 48)); // NOI18N
        jLabel1.setText("Shop Screen");

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel2.setText("Name");

        txtName.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel3.setText("Quantity");

        spQty.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        spQty.setValue(1);
        spQty.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spQtyStateChanged(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel5.setText("Price");

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel4.setText("Total");

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N

        lbImage.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        lbImage.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jLabel8.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel8.setText("Discount");

        spDiscount.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        spDiscount.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spDiscountStateChanged(evt);
            }
        });

        btnChooseImage.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        btnChooseImage.setForeground(new java.awt.Color(0, 0, 255));
        btnChooseImage.setText("Choose Image");
        btnChooseImage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChooseImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChooseImageMouseClicked(evt);
            }
        });

        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Name", "Qty", "Price", "Discount", "Total", "Image", "Owner"
            }
        ));
        jScrollPane1.setViewportView(tblProduct);

        btnAdd.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        btnUpdate.setText("Update");

        btnRemove.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        btnRemove.setText("Remove");

        btnSort.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        btnSort.setText("Sort");

        btnExit.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        btnExit.setText("Exit");

        spPrice.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        spPrice.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spPriceStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnSort, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 921, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                            .addComponent(txtName)
                            .addComponent(spPrice))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3)
                                .addComponent(jLabel8)
                                .addComponent(spQty)
                                .addComponent(spDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(141, 141, 141)
                                .addComponent(btnChooseImage))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbImage, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lbImage, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnChooseImage)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addGap(41, 41, 41))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spQty, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(spDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnRemove)
                    .addComponent(btnSort)
                    .addComponent(btnExit))
                .addGap(23, 23, 23))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnChooseImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChooseImageMouseClicked
        imagePath = Device.openImageSelection();
        Image image = new ImageIcon(imagePath).getImage().getScaledInstance(lbImage.getWidth(), lbImage.getHeight(), Image.SCALE_SMOOTH);
        lbImage.setIcon(new ImageIcon(image));
    }//GEN-LAST:event_btnChooseImageMouseClicked

    private void spQtyStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spQtyStateChanged
        if ((int) spQty.getValue() < 1) {
            spQty.setValue(1);
        } else {
            setTotal(spPrice, spQty, spDiscount);
        }
    }//GEN-LAST:event_spQtyStateChanged

    private void spPriceStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spPriceStateChanged
        if ((int) spPrice.getValue() < 0) {
            spPrice.setValue(0);
        } else {
            setTotal(spPrice, spQty, spDiscount);
        }
    }//GEN-LAST:event_spPriceStateChanged

    private void spDiscountStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spDiscountStateChanged
        if ((int) spDiscount.getValue() < 0) {
            spDiscount.setValue(0);
        } else {
            setTotal(spPrice, spQty, spDiscount);
        }
    }//GEN-LAST:event_spDiscountStateChanged

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (txtName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter name.", "", JOptionPane.ERROR_MESSAGE);
        } else if (imagePath.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select image.", "", JOptionPane.ERROR_MESSAGE);
        } else {
            String name  = txtName.getText();
            double price = Double.parseDouble(spPrice.getValue().toString());
            int qty      = (int) spQty.getValue();
            int discount = (int) spDiscount.getValue();
            double total = Double.parseDouble(txtTotal.getText());
            
            if (db.addProduct(new Product(name, qty, price, discount, total, imagePath, Device._ownerId))) {
                refress();
            } else {
                System.err.println("Add failed");
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JLabel btnChooseImage;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSort;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbImage;
    private javax.swing.JSpinner spDiscount;
    private javax.swing.JSpinner spPrice;
    private javax.swing.JSpinner spQty;
    private javax.swing.JTable tblProduct;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
