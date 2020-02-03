import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Permutacao2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean fica = true;
		String digitado = null;
		ArrayList<String> combina = new ArrayList<String>();
		while (fica) {
			fica = false;
			System.out.println("Informe a numeracao: ");
			try {
				digitado = scan.nextLine();
				digitado = digitado.replace(" ", "");
				Integer.parseInt(digitado);
				for (int posicao = 0; posicao < digitado.length(); posicao++) {
					if (digitado.charAt(posicao) == '0')
						continue;

					ArrayList<Character> opera = new ArrayList<>(
							digitado.chars().mapToObj(e -> (char) e).collect(Collectors.toList()));
					opera.remove(posicao);

					for (int cont = 0; cont < opera.size(); cont++) {
						String item = String.valueOf(digitado.charAt(posicao));
						for (Character character : opera) {
							item += String.valueOf(character);
						}
						char temp = opera.get(0);
						opera.remove(0);
						opera.add(temp);
						if (!combina.contains(item))
							combina.add(item);
					}
				}
			} catch (NumberFormatException parse) {
				System.out.println("Informe um numero valido");
				fica = true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				fica = true;
			}
		}
		System.out.println(
				"A quantidade de combinações possiveis com esta numeração '" + digitado + "' é: " + combina.size());
		combina.forEach(System.out::println);
		scan.close();
	}
}
