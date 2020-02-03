import java.util.ArrayList;
import java.util.Scanner;

public class Permutacao {
	static ArrayList<String> comuta = null;
	static int base;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean fica = true;
		String digitado = null;
		while (fica) {
			comuta = new ArrayList<String>();
			fica = false;
			System.out.println("Informe a numeracao: ");
			try {
				digitado = scan.nextLine();
				digitado = digitado.replace(" ", "");
				Integer.parseInt(digitado);
				Combine(digitado, 0);
			} catch (NumberFormatException parse) {
				System.out.println("Informe um numero valido");
				fica = true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				fica = true;
			}
		}
		System.out.println("A quantidade de combinações possiveis com esta numeração '" + digitado + "' é: " + comuta.size());
		comuta.forEach(System.out::println);
		scan.close();
	}

	private static void Combine(String digitado, int pos) {
		String mudado = digitado;
		if (pos > digitado.length())
			return;
		for (int pIni = pos; pIni < digitado.length(); pIni++) {
			if (digitado.charAt(pIni) == '0')
				continue;
			if (pIni == 0) {
				base = digitado.length() - 1;
			} else {
				base = pIni-1;
			}
			do {
				mudado = Troca(mudado);
				String strCombina = Character.toString(digitado.charAt(pIni));
				for (int pFin = 0; pFin < mudado.length(); pFin++) {
					if (base == pFin)
						continue;
					strCombina += Character.toString(mudado.charAt(pFin));
				}
				if (!comuta.contains(strCombina)) {
					comuta.add(strCombina);
				}
				base--;
				if (base < 0) {
					base = digitado.length() - 1;
				}
			} while (!mudado.equals(digitado));
		}
		Combine(digitado, pos + 1);
	}

	private static String Troca(String texto) {
		return texto.substring(1) + texto.charAt(0);
	}
}
