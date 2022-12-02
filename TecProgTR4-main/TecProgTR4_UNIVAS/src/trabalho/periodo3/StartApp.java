package trabalho.periodo3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class StartApp {
	
	public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        File csv = new File(System.getenv("CSV_FILE"));
        Scanner csvContent = null;
		try {
			csvContent = new Scanner(csv);
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado!");
			e.printStackTrace();
		}
        
        ArrayList<String> subjects = new ArrayList<>();
		
        int index = 1;
        
		while(csvContent.hasNext()) {
			subjects.add(csvContent.next());
		}
		
		System.out.println("\t~ Chamada ~");
		System.out.println("Escolha uma matéria para fazer a chamada:");
		
		for(String subject : subjects) {
			subject = subject.replaceAll(",", " ");
			System.out.println(index + " - " + subject);
			index++;
		}
		
		System.out.println(index + " - Sair");
		
		System.out.printf("> ");
		int option = input.nextInt();
		
		if(option == index) System.exit(0);
		
		String subject = subjects.get(option - 1);
		subject = subject.replaceAll(",", " ");
		
		ArrayList<String> presentsStudents = new ArrayList<>();
		presentsStudents = CallTheRoll.takeAttendance(input, presentsStudents);
		
		String name = csv.getName();
		String path = csv.getPath();
		
		path = path.replaceAll(name, "");
		
		try {
			GenerateTxtFile.createFile(subject, path, presentsStudents);
		} catch (InterruptedException e) {
			System.out.println("Chamada interrompida!");
			e.printStackTrace();
		}
		
		csvContent.close();
		

	}

}
