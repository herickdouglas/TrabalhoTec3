package trabalho.periodo3;

import java.util.ArrayList;
import java.util.Scanner;

public class CallTheRoll {
	
	public static ArrayList<String> takeAttendance(Scanner input, ArrayList<String> presentsStudents) {
		
		System.out.println("Escreva os nomes dos alunos presentes na aula: \n(Digite \"0\" para finalizar)");
		
		String name;
		
		do {
			name = input.next();
			
			if(name.equals("0")) {
				System.out.println("Chamada finalizada!");
				return presentsStudents;
			}
			
			if(presentsStudents.contains(name)) {
				System.out.println("O estudante já esta presente na chamada!");
				continue;
			} else {
				presentsStudents.add(name);
			}
		} while(true);
		
	}

}
