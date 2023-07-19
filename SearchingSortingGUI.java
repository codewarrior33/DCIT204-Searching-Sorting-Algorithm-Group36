import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchingSortingGUI extends JFrame {
    private JTextField arraySizeField;
    private JTextArea arrayElementsArea;
    private JTextArea resultArea;
    private JComboBox<String> operationComboBox;
    private JButton executeButton;

    public SearchingSortingGUI() {
        setTitle("Search and Sort Algorithm");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        JLabel arraySizeLabel = new JLabel("Array Size:");
        arraySizeField = new JTextField();
        JLabel arrayElementsLabel = new JLabel("Array Elements:");
        arrayElementsArea = new JTextArea();
        JLabel operationLabel = new JLabel("Operation:");
        operationComboBox = new JComboBox<>(new String[]{"Searching", "Sorting"});
        JLabel resultLabel = new JLabel("Result:");
        resultArea = new JTextArea();

        inputPanel.add(arraySizeLabel);
        inputPanel.add(arraySizeField);
        inputPanel.add(arrayElementsLabel);
        inputPanel.add(arrayElementsArea);
        inputPanel.add(operationLabel);
        inputPanel.add(operationComboBox);
        inputPanel.add(resultLabel);
        inputPanel.add(resultArea);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        executeButton = new JButton("Execute");
        buttonPanel.add(executeButton);

        executeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeOperation();
            }
        });

        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void executeOperation() {
        int operation = operationComboBox.getSelectedIndex();

        if (operation == 0) {
            // Searching
            Searching searching = new Searching();

            int size = Integer.parseInt(arraySizeField.getText());
            int[] array = new int[size];

            String[] elements = arrayElementsArea.getText().split("\\s+");
            for (int i = 0; i < size; i++) {
                array[i] = Integer.parseInt(elements[i]);
            }

            int searchAlgorithm = JOptionPane.showOptionDialog(
                    this,
                    "Please select the search algorithm:",
                    "Search Algorithm",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new String[]{"Linear Search", "Binary Search"},
                    "Linear Search"
            );

            int key = Integer.parseInt(JOptionPane.showInputDialog(this, "Please enter the key you want to search for:"));

            if (searchAlgorithm == 0) {
                searching.linearSearch(array, key);
            } else if (searchAlgorithm == 1) {
                searching.binarySearch(array, key);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid search algorithm selection.");
            }
        } else if (operation == 1) {
            // Sorting
            Sorting sorting = new Sorting();

            int size = Integer.parseInt(arraySizeField.getText());
            int[] array = new int[size];

            String[] elements = arrayElementsArea.getText().split("\\s+");
            for (int i = 0; i < size; i++) {
                array[i] = Integer.parseInt(elements[i]);
            }

            int sortAlgorithm = JOptionPane.showOptionDialog(
                    this,
                    "Please select the sorting algorithm:",
                    "Sort Algorithm",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new String[]{"Bubble Sort", "Insertion Sort", "Radix Sort", "Merge Sort", "Quick Sort", "Selection Sort"},
                    "Bubble Sort"
            );

            if (sortAlgorithm == 0) {
                sorting.bubbleSort(array);
            } else if (sortAlgorithm == 1) {
                sorting.insertionSort(array);
            } else if (sortAlgorithm == 2) {
                sorting.radixSort(array);
            } else if (sortAlgorithm == 3) {
                sorting.mergeSort(array);
            } else if (sortAlgorithm == 4) {
                sorting.quickSort(array);
            } else if (sortAlgorithm == 5) {
                sorting.selectionSort(array);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid sorting algorithm selection.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Invalid operation selection.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                SearchingSortingGUI gui = new SearchingSortingGUI();
                gui.setVisible(true);
            }
        });
    }
}
