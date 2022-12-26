package studentRecordsBackupTree.utilImpl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import studentRecordsBackupTree.util.FileProcessorInterface;

public class FileProcessorImpl implements FileProcessorInterface {

    private String BSTInput;
    private String frequency;
    private List<Integer> valuesList;
    private Scanner scanner;
    private List<Integer> input;
    private List<Integer> freq;

    public FileProcessorImpl(String BSTInput, String frequency) {
        this.BSTInput = BSTInput;
        this.frequency = frequency;
    }

    @Override
    public List<Integer> getInput() {
        return input = getListOfValues(BSTInput);
    }

    @Override
    public List<Integer> getFreq() {
        return freq = getListOfValues(frequency);
    }

    @Override
    public List<Integer> givenInput() {
        this.input = getListOfValues(BSTInput);
        System.out.println("\n \n list of BST values given as input: \n" + input);
        return input;
    }

    @Override
    public List<Integer> givenFrequency() {
        this.freq = getListOfValues(frequency);
        System.out.println("\n \n list of Frequencies given as input: \n" + freq);
        return freq;
    }

    private List<Integer> getListOfValues(String values) {
        valuesList = new ArrayList<Integer>();
        try {
            scanner = new Scanner(new File(values));

            while (scanner.hasNext()) {

                if (scanner.hasNextInt()) {
                    int val = scanner.nextInt();
                    valuesList.add(val);
                } else {
                    System.exit(1);
                }
            }

        } catch (Exception ex) {

            ex.printStackTrace();

        } finally {
            scanner.close();
        }
        return valuesList;
    }

}
