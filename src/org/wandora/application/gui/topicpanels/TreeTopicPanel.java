/*
 * WANDORA
 * Knowledge Extraction, Management, and Publishing Application
 * http://wandora.org
 * 
 * Copyright (C) 2004-2014 Wandora Team
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
 *
 */


package org.wandora.application.gui.topicpanels;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import org.wandora.application.CancelledException;
import org.wandora.application.LocatorHistory;
import org.wandora.application.Wandora;
import org.wandora.application.gui.UIBox;
import org.wandora.application.gui.topicstringify.TopicToString;
import org.wandora.application.gui.tree.TopicTree;
import org.wandora.application.gui.tree.TopicTreeConfigPanel;
import org.wandora.application.gui.tree.TopicTreeRelation;
import org.wandora.application.gui.tree.TopicTreeRelationsEditor;
import org.wandora.exceptions.OpenTopicNotSupportedException;
import org.wandora.topicmap.Association;
import org.wandora.topicmap.Locator;
import org.wandora.topicmap.TMBox;
import org.wandora.topicmap.Topic;
import org.wandora.topicmap.TopicMapException;
import org.wandora.utils.Options;

/**
 *
 * @author akivela
 */


public class TreeTopicPanel extends javax.swing.JPanel implements ActionListener, TopicPanel {
    
    
    private String title = "Tree";
    private Options options = null;
    private TopicTree topicTree = null;
    private String rootSubject = TMBox.WANDORACLASS_SI;
    private Set<String> selectedRelations = null;
    private TopicTreeRelation[] allRelations = TopicTreeRelationsEditor.readRelationTypes();
            
    
    /**
     * Creates new form TreeTopicPanel
     */
    public TreeTopicPanel() {
        Wandora wandora = Wandora.getWandora();
        this.options = wandora.getOptions();
        initComponents();
    }
    
    
    
    @Override
    public void init() {
        try {
            allRelations = TopicTreeRelationsEditor.readRelationTypes();
            selectedRelations = new HashSet();
            for(TopicTreeRelation allRelation : allRelations) {
                selectedRelations.add(allRelation.name);
            }
            
            treeContainerPanel.removeAll();
            Wandora wandora = Wandora.getWandora();
            topicTree = new TopicTree(rootSubject, wandora, selectedRelations, allRelations);
            treeContainerPanel.add(topicTree, BorderLayout.CENTER);
            revalidate();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        treeContainerPanel = new javax.swing.JPanel();

        setLayout(new java.awt.GridBagLayout());

        treeContainerPanel.setLayout(new java.awt.BorderLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(treeContainerPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel treeContainerPanel;
    // End of variables declaration//GEN-END:variables



    
    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if(cmd != null) {
            if("Set root topic...".equalsIgnoreCase(cmd)) {
                try {
                    Wandora wandora = Wandora.getWandora();
                    Topic t = wandora.showTopicFinder();                
                    if(t != null) {
                        setRootTopic(t);
                    }
                }
                catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
            else if("Configure...".equalsIgnoreCase(cmd)) {
                configure();
            }
            else {
                System.out.println("Unprosessed action captured '"+cmd+"' in TreeTopicPanel.");
            }
        }
    }

    
    public void configure() {
        try {
            Wandora wandora = Wandora.getWandora();
            JDialog jd=new JDialog(wandora, true);
            jd.setTitle("Configure topic tree");

            TopicTreeConfigPanel configurationPanel = new TopicTreeConfigPanel(allRelations, selectedRelations, rootSubject, getTitle(), jd, wandora);
            jd.add(configurationPanel);
            jd.setSize(500,400);
            wandora.centerWindow(jd);

            jd.setVisible(true);
            
            if(configurationPanel.wasCancelled()) return;

            title = configurationPanel.getTreeName();
            rootSubject = configurationPanel.getRoot();
            selectedRelations = configurationPanel.getSelectedRelations();
            topicTree.updateModel(rootSubject, selectedRelations, allRelations);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    @Override
    public boolean supportsOpenTopic() {
        return false;
    }
    
    
    @Override
    public void open(Topic topic) throws TopicMapException, OpenTopicNotSupportedException {
        throw new OpenTopicNotSupportedException();
    }

    
    
    @Override
    public void stop() {
        treeContainerPanel.removeAll();
        topicTree = null;
    }

    
    
    @Override
    public void refresh() throws TopicMapException {
        if(topicTree != null) {
            topicTree.refresh();
            topicTree.repaint();
        }
        revalidate();
    }

    
    
    @Override
    public boolean applyChanges() throws CancelledException, TopicMapException {
        return true;
    }

    @Override
    public JPanel getGui() {
        return this;
    }

    @Override
    public Topic getTopic() throws TopicMapException {
        return null;
    }
    
    @Override
    public String getName(){
        return title;
    }
    
    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Icon getIcon() {
        return UIBox.getIcon("gui/icons/topic_panel_tree.png");
    }

    @Override
    public boolean noScroll(){
        return false;
    }
    
    @Override
    public int getOrder() {
        return 30;
    }

    @Override
    public Object[] getViewMenuStruct() {
        return new Object[] {
            // If you change these, update method actionPerformed too
            "Set root topic...", this /* as an ActionListener */,
            "Configure...", this /* as an ActionListener */,
        };
    }

    @Override
    public JMenu getViewMenu() {
        return UIBox.makeMenu(getViewMenuStruct(), this);
    }

    @Override
    public JPopupMenu getViewPopupMenu() {
        return UIBox.makePopupMenu(getViewMenuStruct(), this);
    }

    @Override
    public LocatorHistory getTopicHistory() {
        return null;
    }

    public void setRootTopic(Topic newRoot) {
        try {
            if(newRoot != null && !newRoot.isRemoved()) {
                rootSubject = newRoot.getOneSubjectIdentifier().toExternalForm();
                init();
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    

    
    // ---------------------------------------------------- TopicMapListener ---
    

    @Override
    public void topicSubjectIdentifierChanged(Topic t, Locator added, Locator removed) throws TopicMapException {
        refresh();
    }

    @Override
    public void topicBaseNameChanged(Topic t, String newName, String oldName) throws TopicMapException {
        refresh();
    }

    @Override
    public void topicTypeChanged(Topic t, Topic added, Topic removed) throws TopicMapException {
        refresh();
    }

    @Override
    public void topicVariantChanged(Topic t, Collection<Topic> scope, String newName, String oldName) throws TopicMapException {
        refresh();
    }

    @Override
    public void topicDataChanged(Topic t, Topic type, Topic version, String newValue, String oldValue) throws TopicMapException {
        refresh();
    }

    @Override
    public void topicSubjectLocatorChanged(Topic t, Locator newLocator, Locator oldLocator) throws TopicMapException {
        refresh();
    }

    @Override
    public void topicRemoved(Topic t) throws TopicMapException {
        refresh();
    }

    @Override
    public void topicChanged(Topic t) throws TopicMapException {
        refresh();
    }

    @Override
    public void associationTypeChanged(Association a, Topic newType, Topic oldType) throws TopicMapException {
        refresh();
    }

    @Override
    public void associationPlayerChanged(Association a, Topic role, Topic newPlayer, Topic oldPlayer) throws TopicMapException {
        refresh();
    }

    @Override
    public void associationRemoved(Association a) throws TopicMapException {
        refresh();
    }

    @Override
    public void associationChanged(Association a) throws TopicMapException {
        refresh();
    }


}
