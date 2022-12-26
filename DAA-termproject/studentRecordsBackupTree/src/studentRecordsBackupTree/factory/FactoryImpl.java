package studentRecordsBackupTree.factory;

import java.util.List;

import studentRecordsBackupTree.util.FileProcessorInterface;
import studentRecordsBackupTree.utilImpl.FileProcessorImpl;

public class FactoryImpl implements Factory {
    private String string;
    private String string2;

    public FactoryImpl(String string, String string2) {
        this.string = string;
        this.string2 = string2;

    }

    @Override
    public void start() {
        try {
            FileProcessorInterface fileProcessor = new FileProcessorImpl(string, string2);
            List<Integer> bstInptList = fileProcessor.getInput();
            List<Integer> frequencyList = fileProcessor.getFreq();
            if (bstInptList.size() == frequencyList.size()) {
                Tree tree = new Tree(fileProcessor);
                tree.displayTree();
                new OptimalBST(fileProcessor);
            } else {
                System.out.println(
                        "Bst inputs and frequencies must be in same number, if there are 3 BST inputs then there must be 3 frequencies");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

}
