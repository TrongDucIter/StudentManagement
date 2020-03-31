/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.sub;

import entities.Course;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import org.apache.commons.io.FilenameUtils;
import utils.FileUtils;
import utils.ImageUtils;

/**
 *
 * @author Mr.Chien
 */
public class CourseInformationForm extends javax.swing.JFrame {

    private final String[] EXT_FILE = {"png", "jpg", "jpeg", "gif"};
    private File selectedFile;
    private Course course;

    public CourseInformationForm(Course course) {
        initComponents();
        if (course != null) {
            this.course = course;
            tfFullname.setText(course.getNameCourse());
            tfClassQuantity.setText(course.getGradeQuantity() + "");
            jDCStartDay.setDate(course.getStartTime());
            jDCEndDay.setDate(course.getEndTime());
            tfCost.setText(course.getCost() + "");
        }
        setLocationRelativeTo(null);
        initComponentsManually();
        initEvent();
    }

    private void initComponentsManually() {
    }

    private void initEvent() {
        btUploadEvent();
        btSubmitEvent();
        btResetEvent();
    }

    private void btResetEvent() {
        btReset.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                tfFullname.setText("");
                tfClassQuantity.setText("");
                jDCStartDay.setDate(null);
                jDCEndDay.setDate(null);
                tfCost.setText("");
            }

        });

    }

    private void btSubmitEvent() {
        btSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //set Course Of CourseInformationForm
                setInformation(course);
                //give new course on CourseInformationPanel
                callbackInformation(course);
                setVisible(false);
            }

        });
    }

    public void callbackInformation(Course course) {
    }

    public void setInformation(Course course) {
        if (course != null) {
            course.setNameCourse(tfFullname.getText());
            course.setGradeQuantity(Integer.valueOf(tfClassQuantity.getText()));
            course.setStartTime(jDCStartDay.getDate());
            course.setEndTime(jDCEndDay.getDate());
            course.setCost(Double.valueOf(tfCost.getText()));
        }
    }

    private void btUploadEvent() {
        btUpload.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                JFileChooser fc = new JFileChooser(FileUtils.getPath("images", "python.jfif"));
                if (fc.showDialog(null, "Open") == JFileChooser.APPROVE_OPTION) {
                    selectedFile = fc.getSelectedFile();
                    final String ext = FilenameUtils.getExtension(selectedFile.getName());
                    if (Arrays.stream(EXT_FILE).anyMatch(t -> t.equalsIgnoreCase(ext))) {
                        lbAvatar.setIcon(ImageUtils.loadImageIcon(selectedFile.getPath(), 120, 150));
                    }
                }
            }

        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgrGender = new javax.swing.ButtonGroup();
        PnTop = new javax.swing.JPanel();
        lbStudentInfo = new javax.swing.JLabel();
        PnBottom = new javax.swing.JPanel();
        btSubmit = new javax.swing.JButton();
        btReset = new javax.swing.JButton();
        PnCenter = new javax.swing.JPanel();
        pnCLeft = new javax.swing.JPanel();
        lbFullname = new javax.swing.JLabel();
        tfFullname = new javax.swing.JTextField();
        lbClassQuantity = new javax.swing.JLabel();
        lbStartDay = new javax.swing.JLabel();
        lbEndDay = new javax.swing.JLabel();
        tfClassQuantity = new javax.swing.JTextField();
        lbCost = new javax.swing.JLabel();
        tfCost = new javax.swing.JTextField();
        jDCStartDay = new com.toedter.calendar.JDateChooser();
        jDCEndDay = new com.toedter.calendar.JDateChooser();
        lbAvatar = new javax.swing.JLabel();
        btUpload = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbStudentInfo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbStudentInfo.setForeground(new java.awt.Color(0, 51, 153));
        lbStudentInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/course.png"))); // NOI18N
        lbStudentInfo.setText("Information Course");
        lbStudentInfo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        PnTop.add(lbStudentInfo);

        getContentPane().add(PnTop, java.awt.BorderLayout.PAGE_START);

        PnBottom.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20, 10));

        btSubmit.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btSubmit.setText("Submit");
        btSubmit.setFocusPainted(false);
        PnBottom.add(btSubmit);

        btReset.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btReset.setText("Reset");
        btReset.setFocusPainted(false);
        PnBottom.add(btReset);

        getContentPane().add(PnBottom, java.awt.BorderLayout.PAGE_END);

        PnCenter.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 255), 1, true), javax.swing.BorderFactory.createTitledBorder(null, "Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13), new java.awt.Color(0, 0, 204)))); // NOI18N
        PnCenter.setLayout(new java.awt.BorderLayout());

        pnCLeft.setBackground(new java.awt.Color(153, 255, 255));

        lbFullname.setText("Name: ");

        lbClassQuantity.setText("Class quantity: ");

        lbStartDay.setText("Start day:");

        lbEndDay.setText("End day:");

        lbCost.setText("Cost:");

        lbAvatar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 0)));
        lbAvatar.setPreferredSize(new java.awt.Dimension(100, 100));

        btUpload.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btUpload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/upload.png"))); // NOI18N
        btUpload.setFocusPainted(false);

        javax.swing.GroupLayout pnCLeftLayout = new javax.swing.GroupLayout(pnCLeft);
        pnCLeft.setLayout(pnCLeftLayout);
        pnCLeftLayout.setHorizontalGroup(
            pnCLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCLeftLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnCLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnCLeftLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btUpload)))
                .addGap(59, 59, 59)
                .addGroup(pnCLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lbStartDay)
                        .addComponent(lbClassQuantity)
                        .addComponent(lbEndDay)
                        .addComponent(lbCost, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbFullname))
                .addGap(60, 60, 60)
                .addGroup(pnCLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfFullname, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfClassQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDCEndDay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDCStartDay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfCost, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
                .addContainerGap(155, Short.MAX_VALUE))
        );

        pnCLeftLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lbClassQuantity, lbCost, lbEndDay, lbFullname, lbStartDay});

        pnCLeftLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jDCEndDay, jDCStartDay, tfClassQuantity, tfCost, tfFullname});

        pnCLeftLayout.setVerticalGroup(
            pnCLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCLeftLayout.createSequentialGroup()
                .addGroup(pnCLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCLeftLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pnCLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbFullname)
                            .addComponent(tfFullname, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(pnCLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfClassQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbClassQuantity))
                        .addGap(44, 44, 44)
                        .addGroup(pnCLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDCStartDay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbStartDay)))
                    .addGroup(pnCLeftLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lbAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btUpload)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(pnCLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbEndDay)
                    .addComponent(jDCEndDay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(pnCLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbCost)
                    .addComponent(tfCost, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PnCenter.add(pnCLeft, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(PnCenter, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CourseInformationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CourseInformationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CourseInformationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CourseInformationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //    new StudentForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PnBottom;
    private javax.swing.JPanel PnCenter;
    private javax.swing.JPanel PnTop;
    private javax.swing.JButton btReset;
    private javax.swing.JButton btSubmit;
    private javax.swing.JButton btUpload;
    private javax.swing.ButtonGroup btgrGender;
    private com.toedter.calendar.JDateChooser jDCEndDay;
    private com.toedter.calendar.JDateChooser jDCStartDay;
    private javax.swing.JLabel lbAvatar;
    private javax.swing.JLabel lbClassQuantity;
    private javax.swing.JLabel lbCost;
    private javax.swing.JLabel lbEndDay;
    private javax.swing.JLabel lbFullname;
    private javax.swing.JLabel lbStartDay;
    private javax.swing.JLabel lbStudentInfo;
    private javax.swing.JPanel pnCLeft;
    private javax.swing.JTextField tfClassQuantity;
    private javax.swing.JTextField tfCost;
    private javax.swing.JTextField tfFullname;
    // End of variables declaration//GEN-END:variables
}
