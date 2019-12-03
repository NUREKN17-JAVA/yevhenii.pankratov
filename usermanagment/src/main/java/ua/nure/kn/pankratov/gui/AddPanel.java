package main.java.ua.nure.kn.pankratov.gui;

import main.java.ua.nure.kn.pankratov.db.DatabaseException;
import main.java.ua.nure.kn.pankratov.domain.User;
import main.java.ua.nure.kn.pankratov.util.Message;
import org.dbunit.DatabaseUnitException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;

public class AddPanel extends JPanel implements ActionListener {
    private MainFrame parent;
    private JPanel buttonPanel;
    private JPanel fieldPanel;
    private JButton cancelButton;
    private JButton okButton;
    private JTextField dateOfBirthField;
    private JTextField lastNameField;
    private JTextField firstNameField;
    private Color bgcolor;

    public AddPanel(MainFrame mainFrame) {
        this.parent = mainFrame;
        initialize();
    }

    private void initialize(){
        this.setName("addPanel");
        this.setLayout(new BorderLayout());
        this.add(getFieldPanel(),BorderLayout.NORTH);
        this.add(getButtonPanel(),BorderLayout.SOUTH);

    }
    private  JPanel getButtonPanel(){
        if (buttonPanel == null){
            buttonPanel = new JPanel();
            buttonPanel.add(getOkButton(),null);
            buttonPanel.add(getCancelButton(),null);
        }
        return buttonPanel;
    }

    private JButton getCancelButton() {
        if(cancelButton == null){
            cancelButton = new JButton();
            cancelButton.setText(Message.getString("AddPanel.cancel"));
            cancelButton.setName("cancelButton");
            cancelButton.setActionCommand("cancel");
            cancelButton.addActionListener(this);
        }
        return cancelButton;
    }

    private JButton getOkButton() {
        if(okButton == null){
            okButton = new JButton();
            okButton.setText(Message.getString("AddPanel.ok"));
            okButton.setName("okButton");
            okButton.setActionCommand("ok");
            okButton.addActionListener(this);
        }
        return okButton;
    }

    private JPanel getFieldPanel(){
        if(fieldPanel == null){
            fieldPanel = new JPanel();
            fieldPanel.setLayout(new GridLayout(3,2));
            addLabeledField(fieldPanel, Message.getString("AddPanel.first_name"), getFirstNameField()); //$NON-NLS-1$
            addLabeledField(fieldPanel, Message.getString("AddPanel.last_name"), getLastNameField()); //$NON-NLS-1$
            addLabeledField(fieldPanel, Message.getString("AddPanel.date_of_birth"), getDateOfBirthField()); //$NON-NLS-1$
        }
        return fieldPanel;
    }

    private JTextField getDateOfBirthField() {
        if (dateOfBirthField == null){
            dateOfBirthField = new JTextField();
            dateOfBirthField.setName("dateOfBirthField");
        }
        return dateOfBirthField;
    }

    private JTextField getLastNameField() {
        if (lastNameField == null){
            lastNameField = new JTextField();
            lastNameField.setName("lastNameField");
        }
        return lastNameField;
    }

    private void addLabeledField(JPanel panel, String labelText, JTextField textField) {
        JLabel label = new JLabel(labelText);
        label.setLabelFor(textField);
        panel.add(label);
        panel.add(textField);
    }

    private JTextField getFirstNameField() {
        if (firstNameField == null){
            firstNameField = new JTextField();
            firstNameField.setName("firstNameField");
        }
        return firstNameField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("ok".equalsIgnoreCase(e.getActionCommand())){
            User user = new User();
            user.setFirstName(getFirstNameField().getText());
            user.setLastName(getLastNameField().getText());
            DateFormat format = DateFormat.getDateInstance();
            try {
                user.setDateOfBirth(format.parse(getDateOfBirthField().getText()));
            } catch (ParseException ex) {
                getDateOfBirthField().setBackground(Color.RED);
                return;
            }
            try {
                parent.getDao().create(user);
            } catch (DatabaseException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(),"Error",
                        JOptionPane.ERROR_MESSAGE);
            } catch (DatabaseUnitException ex) {
                ex.printStackTrace();
            }
        }
        clearFields();
        this.setVisible(false);
        parent.showAddPanel();
    }

    private void clearFields() {
        getFirstNameField().setText("");
        getFirstNameField().setBackground(bgcolor);

        getLastNameField().setText("");
        getLastNameField().setBackground(bgcolor);

        getDateOfBirthField().setText("");
        getDateOfBirthField().setBackground(bgcolor);
    }
}