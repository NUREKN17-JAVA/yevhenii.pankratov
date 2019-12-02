package test.java.ua.nure.kn.pankratov.gui;

import junit.extensions.jfcunit.JFCTestCase;
import junit.extensions.jfcunit.JFCTestHelper;
import junit.extensions.jfcunit.TestHelper;
import junit.extensions.jfcunit.finder.NamedComponentFinder;
import main.java.ua.nure.kn.pankratov.gui.MainFrame;

import javax.swing.*;
import java.awt.*;

public class MainFrameTest extends JFCTestCase {

    public static final String BROWSE_PANEL_COMPONENT_NAME = "browsePanel";
    public static final String ADD_BUTTON_COMPONENT_NAME = "addButton";
    public static final String EDIT_BUTTON_COMPONENT_NAME = "editButton";
    public static final String DETAIL_BUTTON_COMPONENT_NAME = "detailButton";
    public static final String DELETE_BUTTON_COMPONENT_NAME = "deleteButton";
    private MainFrame mainFrame;
    @Override
    public void setUp() throws Exception {
        super.setUp();
        setHelper(new JFCTestHelper());
        mainFrame = new MainFrame();
        mainFrame.setVisible(true);

    }

    @Override
    public void tearDown() throws Exception {
        mainFrame.setVisible(true);
        getHelper();
        TestHelper.cleanUp(this);
        super.tearDown();
    }

    private Component find(Class<?> componentClass, String name){
        NamedComponentFinder finder;
        finder = new NamedComponentFinder(componentClass, name);
        finder.setWait(0);
        Component component = finder.find(mainFrame, 0);
        assertNotNull("Could not find component '" + name + "'", component);
                return component;
    }

    public void testBrowseControls(){
        find(JPanel.class, BROWSE_PANEL_COMPONENT_NAME);
        find(JButton.class, ADD_BUTTON_COMPONENT_NAME);
        find(JButton.class, EDIT_BUTTON_COMPONENT_NAME);
        find(JButton.class, DETAIL_BUTTON_COMPONENT_NAME);
        find(JButton.class, DELETE_BUTTON_COMPONENT_NAME);
    }
}