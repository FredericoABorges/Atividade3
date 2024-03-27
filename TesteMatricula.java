import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TesteMatricula {

	public static void main(String[] args) {
	    	
	        Scanner scanner = new Scanner(System.in);

	        // Formato da data
	        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	        // Cadastro de aluno
	        System.out.println("Cadastro de Aluno:");
	        System.out.print("Número de matrícula: ");
	        int numeroMatricula = scanner.nextInt();
	        scanner.nextLine(); // Limpar o buffer
	        System.out.print("Nome do aluno: ");
	        String nomeAluno = scanner.nextLine();
	        System.out.print("Data de nascimento (DD-MM-AAAA): ");
	        LocalDate dataNascimentoAluno = LocalDate.parse(scanner.nextLine(), formatoData);

	        Aluno aluno = new Aluno(numeroMatricula, nomeAluno, dataNascimentoAluno);

	        // Cadastro de curso
	        System.out.println("\nCadastro de Curso:");
	        System.out.print("Código do curso: ");
	        int codigoCurso = scanner.nextInt();
	        scanner.nextLine(); // Limpar o buffer
	        System.out.print("Nome do curso: ");
	        String nomeCurso = scanner.nextLine();
	        System.out.print("Data de início do curso (DD-MM-AAAA): ");
	        LocalDate dataInicioCurso = LocalDate.parse(scanner.nextLine(), formatoData);

	        Curso curso = new Curso(codigoCurso, nomeCurso, dataInicioCurso);

	        // Matrícula
	        System.out.println("\nMatrícula:");
	        System.out.println("Idade mínima para matrícula: 18 anos");
	        int idadeAluno = LocalDate.now().getYear() - aluno.getDataNascimento().getYear();
	        if (idadeAluno < 18) {
	            System.out.println("O aluno não atende à idade mínima para matrícula.");
	        } else {
	            LocalDate dataMatricula = LocalDate.now();
	            Matricula matricula = new Matricula(aluno, curso, dataMatricula);
	            System.out.println("Matrícula realizada com sucesso!");
	            System.out.println("Detalhes da matrícula:");
	            System.out.println("Aluno: " + matricula.getAluno().getNome());
	            System.out.println("Curso: " + matricula.getCurso().getNomeCurso());
	            System.out.println("Data da matrícula: " + matricula.getDataMatricula().format(formatoData));
	        }

	        scanner.close();
	    }
}

