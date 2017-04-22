/*
 * WANDORA
 * Knowledge Extraction, Management, and Publishing Application
 * http://wandora.org
 * 
 * Copyright (C) 2004-2016 Wandora Team
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.wandora.application.tools.git;

import java.io.File;
import javax.swing.JDialog;
import org.wandora.application.Wandora;
import org.wandora.application.gui.UIConstants;
import org.wandora.application.gui.simple.SimpleButton;
import org.wandora.application.gui.simple.SimpleCheckBox;
import org.wandora.application.gui.simple.SimpleField;
import org.wandora.application.gui.simple.SimpleFileChooser;
import org.wandora.application.gui.simple.SimpleLabel;

/**
 *
 * @author akikivela
 */
public class CloneUI extends javax.swing.JPanel {

    private JDialog dialog = null;
    private boolean wasAccepted = false;
    
    
    /**
     * Creates new form CloneUI
     */
    public CloneUI() {
        initComponents();
    }
    
    
    
    public void openInDialog() {
        if(dialog == null) {
            Wandora wandora = Wandora.getWandora();
            dialog = new JDialog(wandora, true);
            dialog.add(this);
            dialog.setSize(600,300);
            wandora.centerWindow(dialog);
            dialog.setTitle("Git clone options");
        }
        wasAccepted = false;
        dialog.setVisible(true);
    }
    
    
    // -------------------------------------------------------------------------
    
    
    public String getCloneUrl() {
        return cloneURLField.getText();
    }
    public void setCloneUrl(String url) {
        cloneURLField.setText(url);
    }
    
    
    
    public String getDestinationDirectory() {
        return destinationDirectoryField.getText();
    }
    public void setDestinationDirectory(String dd) {
        destinationDirectoryField.setText(dd);
    }
    
    
    
    public String getUsername() {
        return usernameField.getText();
    }
    public void setUsername(String un) {
        usernameField.setText(un);
    }
    
    
    
    public String getPassword() {
        return passwordField.getText();
    }
    public void setPassword(String pw) {
        passwordField.setText(pw);
    }
    
    
    
    public boolean getOpenProject() {
        return openProjectCheckBox.isSelected();
    }
    
    public void setOpenProject(Boolean op) {
        openProjectCheckBox.setSelected(op);
    }
    
    
    
    public boolean wasAccepted() {
        return wasAccepted;
    }
    
    
    // -------------------------------------------------------------------------
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        cloneLabel = new SimpleLabel();
        cloneConfPanel = new javax.swing.JPanel();
        remotePanel = new javax.swing.JPanel();
        cloneURLLabel = new SimpleLabel();
        cloneURLField = new SimpleField();
        usernameLabel = new SimpleLabel();
        usernameField = new SimpleField();
        passwordLabel = new SimpleLabel();
        passwordField = new SimpleField();
        destinationDirectoryLabel = new SimpleLabel();
        destinationPanel = new javax.swing.JPanel();
        destinationDirectoryField = new SimpleField();
        selectDestinationButton = new SimpleButton();
        confPanel = new javax.swing.JPanel();
        openProjectCheckBox = new SimpleCheckBox();
        cloneButtonPanel = new javax.swing.JPanel();
        buttonPanelFiller = new javax.swing.JPanel();
        okButton = new SimpleButton();
        cancelButton = new SimpleButton();

        setLayout(new java.awt.GridBagLayout());

        cloneLabel.setText("<html>Clone git repository. Enter remote repository URL, destination directory and credentials. Leave username empty for anonymous clone.</html>");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 10, 4);
        add(cloneLabel, gridBagConstraints);

        cloneConfPanel.setLayout(new java.awt.GridBagLayout());

        remotePanel.setLayout(new java.awt.GridBagLayout());

        cloneURLLabel.setText("Remote URL");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 4);
        remotePanel.add(cloneURLLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        remotePanel.add(cloneURLField, gridBagConstraints);

        usernameLabel.setText("User name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 4);
        remotePanel.add(usernameLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        remotePanel.add(usernameField, gridBagConstraints);

        passwordLabel.setText("Password");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 4);
        remotePanel.add(passwordLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        remotePanel.add(passwordField, gridBagConstraints);

        destinationDirectoryLabel.setText("Destination directory");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 4);
        remotePanel.add(destinationDirectoryLabel, gridBagConstraints);

        destinationPanel.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        destinationPanel.add(destinationDirectoryField, gridBagConstraints);

        selectDestinationButton.setText("Browse");
        selectDestinationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectDestinationButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        destinationPanel.add(selectDestinationButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        remotePanel.add(destinationPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        cloneConfPanel.add(remotePanel, gridBagConstraints);

        confPanel.setLayout(new java.awt.GridBagLayout());

        openProjectCheckBox.setSelected(true);
        openProjectCheckBox.setText("Open project to Wandora");
        confPanel.add(openProjectCheckBox, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(16, 0, 0, 0);
        cloneConfPanel.add(confPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 4);
        add(cloneConfPanel, gridBagConstraints);

        cloneButtonPanel.setLayout(new java.awt.GridBagLayout());

        buttonPanelFiller.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        cloneButtonPanel.add(buttonPanelFiller, gridBagConstraints);

        okButton.setText("Clone");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 3);
        cloneButtonPanel.add(okButton, gridBagConstraints);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        cloneButtonPanel.add(cancelButton, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(cloneButtonPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        wasAccepted = false;
        if(dialog != null) {
            dialog.setVisible(false);
        }
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        wasAccepted = true;
        if(dialog != null) {
            dialog.setVisible(false);
        }
    }//GEN-LAST:event_okButtonActionPerformed

    private void selectDestinationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectDestinationButtonActionPerformed
        SimpleFileChooser chooser=UIConstants.getFileChooser();
        chooser.setFileSelectionMode(SimpleFileChooser.DIRECTORIES_ONLY);
        chooser.setDialogTitle("Select destination directory");
        if(chooser.open(Wandora.getWandora()) == SimpleFileChooser.APPROVE_OPTION) {
            File f=chooser.getSelectedFile();
            if(f != null) {
                destinationDirectoryField.setText(f.getAbsolutePath());
            }
        }
    }//GEN-LAST:event_selectDestinationButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonPanelFiller;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel cloneButtonPanel;
    private javax.swing.JPanel cloneConfPanel;
    private javax.swing.JLabel cloneLabel;
    private javax.swing.JTextField cloneURLField;
    private javax.swing.JLabel cloneURLLabel;
    private javax.swing.JPanel confPanel;
    private javax.swing.JTextField destinationDirectoryField;
    private javax.swing.JLabel destinationDirectoryLabel;
    private javax.swing.JPanel destinationPanel;
    private javax.swing.JButton okButton;
    private javax.swing.JCheckBox openProjectCheckBox;
    private javax.swing.JTextField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPanel remotePanel;
    private javax.swing.JButton selectDestinationButton;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
