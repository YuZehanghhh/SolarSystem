
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A class to provide a simple GUI to add and remove planets and moons in a solar system.
 * @see SolarSystemController
 * @author Joe Finney
 */
public class SolarSystemGUI implements ActionListener
{
	private JFrame window = new JFrame("Solar System GUI");
    private String[] attributes = {"Name", "Orbital Distance", "Orbital Angle", "Size", "Speed", "Colour", "Orbits"};  
    private JTextField[] values = new JTextField[attributes.length];
    private JPanel dataPanel = new JPanel();
    private JPanel buttonPanel = new JPanel();
    private JPanel panel = new JPanel();
    private JButton addButton = new JButton("Add");
	private JButton removeButton = new JButton("Remove");
    private SolarSystemController controller;

    /**
     * Creates a new SolarSystemGUI
     * 
     * A simple graphical user interface is displayed, which prompts the user to
     * enter data relating to new planets and moons. These solar object are identified
     * by name, and can be dynamically added and removed by the user.
     */
	public SolarSystemGUI()
	{
		window.setContentPane(panel);
		window.setSize(300,300);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        dataPanel.setLayout(new GridLayout(attributes.length,2));
        for (int i=0; i<attributes.length; i++)
        {
            dataPanel.add(new JLabel(attributes[i]));
            values[i] = new JTextField("");
            dataPanel.add(values[i]);
        }

        buttonPanel.setLayout(new GridLayout(1,2));
		buttonPanel.add(addButton);
		buttonPanel.add(removeButton);

        panel.setLayout(new BorderLayout());
		panel.add("Center", dataPanel);
		panel.add("South", buttonPanel);

		addButton.addActionListener(this);
		removeButton.addActionListener(this);

		window.setVisible(true);
	}

    /**
     * Register a given SolarSystemController with this GUI.
     * Once registered, this controller will then receive add and remove method calls
     * when the user interacts with the user interface.
     * 
     * @param controller an object satisfying the SolarSystemController interface which
     * will subsequently receive add/remove method invocations.
     */
    public void addSolarSystemController(SolarSystemController controller)
    {
        this.controller = controller;
    }

    private void reportInvalidData()
    {
        System.out.println("Invalid data entered. Please check data feilds and try again.");
    }

    /**
     * Event handler. Called by the Swing package when a button related to this GUI is clicked.
     */
	public void actionPerformed(ActionEvent e)
	{
        boolean valid = true;

		if (e.getSource() == addButton)
		{
            // Validate the data fields...
            try
            {
                String name = values[0].getText();
                double distance = Double.parseDouble(values[1].getText());
                double angle = Double.parseDouble(values[2].getText());
                double size = Double.parseDouble(values[3].getText());
                double speed = Double.parseDouble(values[4].getText());
                String colour = values[5].getText();
                String orbits = values[6].getText();

                // Ensure required fields are valid
                if (name == null || name.equals("") || colour == null || colour.equals("") || size <= 0.0)
                {
                    this.reportInvalidData();
                    return;
                }

                if (controller != null)
                {
                    if (orbits != null && !orbits.equals(""))
                        controller.add(name, distance, angle, size, speed, colour, orbits);
                    else
                        controller.add(name, distance, angle, size, speed, colour);
                }
                else
                {
                    System.out.println(" --- No SolarSystemController Registered ---");
                }
    
            } catch (Exception ex)
            {
                this.reportInvalidData();
                return;
            }
        }

        if (e.getSource() == removeButton)
		{
            String name = values[0].getText();
            if (name == null || name.equals(""))
            {
                this.reportInvalidData();
                return;
            }

            if (controller != null)
            {
                controller.remove(name);
            }
        }

	}
    public static void main(String[] args) {
        SolarSystemGUI sg = new SolarSystemGUI();
        sg.addSolarSystemController(); 
            
        
    }
}
