import java.util.Arrays;
public class MergeSort {
	public static void mergesort(int[] L, int inicio, int fin) {
		int med = 0;
		if (inicio < fin) {
			med = (inicio + fin) / 2; // calcular la posicion media
			int[] Lizq = new int[(L.length) + 1];// listas aux
			int[] Lder = new int[(L.length) + 1];// listas aux
			for (int i = inicio; i <= med; i++) {
				Lizq[i] = L[i]; // copiar mitad izquierda
			}
			for (int i = med + 1; i <= fin; i++) {
				Lder[i] = L[i]; // copiar mitad derecha
			}
			mergesort(Lizq, inicio, med);
			mergesort(Lder, (med + 1), fin);
			merge(Lizq, Lder, L, inicio, fin, med);
		}
		System.out.println("Array final" + Arrays.toString(L));
	}

	public static void merge(int[] Lizq, int[] Lder, int[] L, int inicio, int fin, int med) {
		Lizq[med + 1] = Integer.MAX_VALUE; // marcadores para indicar el fin de la
		Lder[fin + 1] = Integer.MAX_VALUE; // sublista y gestionar comparaciones
		int i = inicio; // contador lista izquierda
		int d = (med + 1); // contador lista derecha
		for (int cont = inicio; cont <= fin; cont++) { // rellenar lista L
			if (Lizq[i] < Lder[d]) {
				L[cont] = Lizq[i];
				i++;
			} else {
				L[cont] = Lder[d];
				d++;
			}
		}
	}
	public static void main(String[] args) {
		int[] L = { 23, 10, 10, 11, 20, 22 };
		mergesort(L, 0, (L.length - 1));
	}

}
