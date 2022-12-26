package studentRecordsBackupTree.driver;

import studentRecordsBackupTree.factory.Factory;
import studentRecordsBackupTree.factory.FactoryImpl;

public class Driver {

	private void doStuff(Factory factory) {
		factory.start();
	}

	public static void main(String[] args) {
		Factory factory = new FactoryImpl(args[0], args[1]);

		new Driver().doStuff(factory);
	}
}
