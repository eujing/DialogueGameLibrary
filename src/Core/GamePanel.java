/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

/**
 *
 * @author Owner
 */
public class GamePanel extends javax.swing.JPanel {

	/**
	 * Creates new form GamePanel
	 */
	public int boundWidth;
	public int boundHeight;

	public GamePanel (DialogueNode dNode) {
		initComponents ();
		
		this.lblName.setText (dNode.playerName);
		this.lblText.setText (dNode.text);
		this.lblType.setText (dNode.type.toString ());
		this.boundWidth = this.getPreferredSize ().width;
		this.boundHeight = this.getPreferredSize ().height;
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
	 */
	@SuppressWarnings ("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblName = new javax.swing.JLabel();
        lblText = new javax.swing.JLabel();
        lblType = new javax.swing.JLabel();
        bRespond = new javax.swing.JButton();

        lblName.setText("<name>");

        lblText.setText("<text>");

        lblType.setText("<type>");

        bRespond.setText("Respond");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblName)
                .addGap(18, 18, 18)
                .addComponent(lblText, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lblType)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bRespond)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(lblText)
                    .addComponent(lblType)
                    .addComponent(bRespond))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bRespond;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblText;
    private javax.swing.JLabel lblType;
    // End of variables declaration//GEN-END:variables
}
