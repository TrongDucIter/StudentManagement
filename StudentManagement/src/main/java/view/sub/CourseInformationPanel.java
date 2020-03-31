/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.sub;
//import model.StudentTableModel;

import common.CourseTableColumns;
import entities.Course;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.RowFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;
import model.CourseTableModel;
import service.CourseService;
import service.CourseServiceImpl;

/**
 *
 * @author Mr.Chien
 */
public class CourseInformationPanel extends javax.swing.JPanel {

    private final CourseTableModel courseModel;
    private Font defaultFont;
    private final CourseService courseService;
    private final Font newFont = new Font("Tahoma", Font.BOLD, 14);
    private Course course;
    private int idSelected;
    private final CourseTableColumns COLUMNS_NAME[] = CourseTableColumns.values();

    public CourseInformationPanel() {
        initComponents();
        btAdd.setFocusPainted(false);
        btEdit.setFocusPainted(false);
        courseModel = new CourseTableModel(tbCourse);
        course = new Course();
        courseService = new CourseServiceImpl();
        courseModel.loadDataTable();
        courseModel.cssForTable();
        initEvents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void initEvents() {
        tbCourseEvent();
        btAddEvents();
        btEditEvents();
    }

    private void tfSearchEvent() {
        tfSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String text = tfSearch.getText();
                TableRowSorter<AbstractTableModel> sorter = new TableRowSorter<>();
                sorter.setModel(courseModel);
                RowFilter<AbstractTableModel, Object> filter = RowFilter.regexFilter("(?i)" + text);
                sorter.setRowFilter(filter);
                tbCourse.setRowSorter(sorter);
            }
        });
    }

    private void tbCourseEvent() {
        tbCourse.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
//                int selectedRow = tbCourse.getSelectedRow();
//                int selectedCol = tbCourse.getSelectedColumn();
//                int rowIndex = tbCourse.convertColumnIndexToModel(selectedRow);
//                idSelected = (int) tbCourse.getValueAt(rowIndex, 0);
//                System.out.println("IdSelected: " + idSelected);
                //course =courseService.getCourseById(idSelected);
//                System.out.println("Student: " + student);
//                //set thông tin cá nhân
//                lbFulname.setText(student.getFullname());
//                lbGrade.setText(student.getGrade().getName());
//                lbGender.setText(student.getGender());
//                lbMath.setText(String.valueOf(student.getMathPoint()));
//                lbLitterature.setText(String.valueOf(student.getLiteraturePoint()));
//                lbHobbies.setText(student.getHobbies());
            }

        });
    }

    private void btAddEvents() {
        defaultFont = btAdd.getFont();
        btAdd.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
//                CourseForm courseForm = CourseForm.newCourseformAdd();
//                courseForm.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//                courseForm.setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btAdd.setFont(newFont);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btAdd.setFont(defaultFont);
            }

        });
    }

    private void btEditEvents() {
        btEdit.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
//                CourseForm courseForm = CourseForm.newCourseformEdit(student);
//                courseForm.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//                courseForm.setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btEdit.setFont(newFont);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btEdit.setFont(defaultFont);
            }

        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnTop = new javax.swing.JPanel();
        lbFind = new javax.swing.JLabel();
        tfSearch = new javax.swing.JTextField();
        btAdd = new javax.swing.JButton();
        pnBottom = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbFulname = new javax.swing.JLabel();
        lbClassQuantity = new javax.swing.JLabel();
        lbStartDay = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbEndday = new javax.swing.JLabel();
        lbCost = new javax.swing.JLabel();
        lbAvatarCourse = new javax.swing.JLabel();
        btEdit = new javax.swing.JButton();
        pnCenter = new javax.swing.JPanel();
        jSCourse = new javax.swing.JScrollPane();
        tbCourse = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1587, 903));
        setLayout(new java.awt.BorderLayout());

        pnTop.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(5, 2, 5, 2), javax.swing.BorderFactory.createEtchedBorder()));

        lbFind.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbFind.setText("Search");

        tfSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSearchActionPerformed(evt);
            }
        });

        btAdd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btAdd.setText("Add");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnTopLayout = new javax.swing.GroupLayout(pnTop);
        pnTop.setLayout(pnTopLayout);
        pnTopLayout.setHorizontalGroup(
            pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbFind)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 632, Short.MAX_VALUE)
                .addComponent(btAdd)
                .addContainerGap())
        );
        pnTopLayout.setVerticalGroup(
            pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTopLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbFind)
                    .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAdd))
                .addGap(3, 3, 3))
        );

        add(pnTop, java.awt.BorderLayout.PAGE_START);

        pnBottom.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Information Of Courses", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 204, 51))); // NOI18N
        pnBottom.setPreferredSize(new java.awt.Dimension(400, 100));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Name:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Class quantity:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Start day:");

        lbFulname.setText("............");

        lbClassQuantity.setText("............");

        lbStartDay.setText("...........");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("End day:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Cost: ");

        lbEndday.setText(".......");

        lbCost.setText(".......");

        btEdit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit-icon.gif"))); // NOI18N
        btEdit.setText("Edit");
        btEdit.setMaximumSize(new java.awt.Dimension(67, 25));
        btEdit.setMinimumSize(new java.awt.Dimension(67, 25));
        btEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnBottomLayout = new javax.swing.GroupLayout(pnBottom);
        pnBottom.setLayout(pnBottomLayout);
        pnBottomLayout.setHorizontalGroup(
            pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBottomLayout.createSequentialGroup()
                .addGroup(pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGroup(pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnBottomLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbFulname))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBottomLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbClassQuantity)
                        .addGap(1, 1, 1)))
                .addGap(192, 192, 192)
                .addComponent(lbAvatarCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnBottomLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(41, 41, 41)
                        .addComponent(lbEndday)
                        .addGap(108, 108, 108)
                        .addComponent(jLabel8)
                        .addGap(30, 30, 30)
                        .addComponent(lbCost)
                        .addGap(0, 184, Short.MAX_VALUE))
                    .addGroup(pnBottomLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(27, 27, 27)
                        .addComponent(lbStartDay)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnBottomLayout.setVerticalGroup(
            pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBottomLayout.createSequentialGroup()
                .addComponent(btEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnBottomLayout.createSequentialGroup()
                .addGroup(pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnBottomLayout.createSequentialGroup()
                        .addGroup(pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lbFulname)
                            .addComponent(jLabel3)
                            .addComponent(lbStartDay))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(lbCost)
                            .addGroup(pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(lbClassQuantity)
                                .addComponent(jLabel7)
                                .addComponent(lbEndday)))
                        .addGap(28, 28, 28))
                    .addComponent(lbAvatarCourse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        add(pnBottom, java.awt.BorderLayout.PAGE_END);

        pnCenter.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(5, 2, 5, 2), javax.swing.BorderFactory.createEtchedBorder()));
        pnCenter.setLayout(new javax.swing.OverlayLayout(pnCenter));

        tbCourse.setAutoCreateRowSorter(true);
        tbCourse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Class Quantity", "Start day", "End day"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbCourse.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jSCourse.setViewportView(tbCourse);
        tbCourse.getAccessibleContext().setAccessibleParent(pnCenter);

        pnCenter.add(jSCourse);

        add(pnCenter, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void tfSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSearchActionPerformed

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btAddActionPerformed

    private void btEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btEditActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jSCourse;
    private javax.swing.JLabel lbAvatarCourse;
    private javax.swing.JLabel lbClassQuantity;
    private javax.swing.JLabel lbCost;
    private javax.swing.JLabel lbEndday;
    private javax.swing.JLabel lbFind;
    private javax.swing.JLabel lbFulname;
    private javax.swing.JLabel lbStartDay;
    private javax.swing.JPanel pnBottom;
    private javax.swing.JPanel pnCenter;
    private javax.swing.JPanel pnTop;
    private javax.swing.JTable tbCourse;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables

}
