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
 *
 */

package org.wandora.application.gui.topicpanels.queryeditorpanel;

import java.util.Collection;
import javax.swing.Icon;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import org.wandora.application.CancelledException;
import org.wandora.application.LocatorHistory;
import org.wandora.application.gui.UIBox;
import org.wandora.application.gui.topicpanels.TopicPanel;
import org.wandora.exceptions.OpenTopicNotSupportedException;
import org.wandora.topicmap.Association;
import org.wandora.topicmap.Locator;
import org.wandora.topicmap.Topic;
import org.wandora.topicmap.TopicMapException;

/**
 *
 * @author olli
 */


public class QueryEditorTopicPanel implements TopicPanel {

    protected Topic openedTopic;
    protected QueryEditorComponent panel;
    
    public QueryEditorTopicPanel(){
        panel=new QueryEditorComponent();
    }
    
    
    @Override
    public void init() {
    }
    
    
    @Override
    public boolean supportsOpenTopic() {
        return true;
    }

    @Override
    public void open(Topic topic) throws TopicMapException, OpenTopicNotSupportedException {
        openedTopic=topic;
    }

    @Override
    public void stop() {
        
    }

    @Override
    public void refresh() throws TopicMapException {
        
    }

    @Override
    public boolean applyChanges() throws CancelledException, TopicMapException {
        return true;
    }

    @Override
    public JPanel getGui() {
        return panel;
    }

    @Override
    public Topic getTopic() throws TopicMapException {
        return openedTopic;
    }

    @Override
    public String getName() {
        return "Query editor";
    }

    @Override
    public String getTitle() {
        return getName();
    }

    @Override
    public Icon getIcon() {
        return UIBox.getIcon("gui/icons/topic_panel_custom.png");
    }

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public boolean noScroll(){
        return true;
    }
    
    @Override
    public Object[] getViewMenuStruct() {
        return new Object[0];
    }

    @Override
    public JMenu getViewMenu() {
        return null;
    }

    @Override
    public JPopupMenu getViewPopupMenu() {
        return null;
    }

    @Override
    public LocatorHistory getTopicHistory() {
        return null;
    }

    @Override
    public void topicSubjectIdentifierChanged(Topic t, Locator added, Locator removed) throws TopicMapException {
    }

    @Override
    public void topicBaseNameChanged(Topic t, String newName, String oldName) throws TopicMapException {
    }

    @Override
    public void topicTypeChanged(Topic t, Topic added, Topic removed) throws TopicMapException {
    }

    @Override
    public void topicVariantChanged(Topic t, Collection<Topic> scope, String newName, String oldName) throws TopicMapException {
    }

    @Override
    public void topicDataChanged(Topic t, Topic type, Topic version, String newValue, String oldValue) throws TopicMapException {
    }

    @Override
    public void topicSubjectLocatorChanged(Topic t, Locator newLocator, Locator oldLocator) throws TopicMapException {
    }

    @Override
    public void topicRemoved(Topic t) throws TopicMapException {
    }

    @Override
    public void topicChanged(Topic t) throws TopicMapException {
    }

    @Override
    public void associationTypeChanged(Association a, Topic newType, Topic oldType) throws TopicMapException {
    }

    @Override
    public void associationPlayerChanged(Association a, Topic role, Topic newPlayer, Topic oldPlayer) throws TopicMapException {
    }

    @Override
    public void associationRemoved(Association a) throws TopicMapException {
    }

    @Override
    public void associationChanged(Association a) throws TopicMapException {
    }
    
}