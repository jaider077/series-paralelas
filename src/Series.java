import java.util.Scanner;

public class Series {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N;
        do {
            N = sc.nextInt();
        } while (N < 5 || N > 50);

        int[] A = leerArreglo(N);
        int[] B = leerArreglo(N);

        int[] suma = sumaElementoElemento(A, B);
        int escalar = productoEscalar(A, B);
        int rot = rotacionDerechaDeAParaObtenerB(A, B);
        boolean multi = mismosElementosComoMulticonjunto(A, B);

        imprimir(suma);
        System.out.println(escalar);
        System.out.println(rot);
        System.out.println(multi);
    }

    // -----------------------------

    public static int[] leerArreglo(int n) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static int[] sumaElementoElemento(int[] a, int[] b) {
        int[] c = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i] + b[i];
        }
        return c;
    }

    public static int productoEscalar(int[] a, int[] b) {
        int s = 0;
        for (int i = 0; i < a.length; i++) {
            s += a[i] * b[i];
        }
        return s;
    }

    public static int rotacionDerechaDeAParaObtenerB(int[] a, int[] b) {
        int n = a.length;

        for (int k = 0; k < n; k++) {
            boolean iguales = true;

            for (int i = 0; i < n; i++) {
                int pos = (i - k + n) % n;
                if (a[pos] != b[i]) {
                    iguales = false;
                    break;
                }
            }
            if (iguales) return k;
        }
        return -1;
    }

    public static boolean mismosElementosComoMulticonjunto(int[] a, int[] b) {
        int n = a.length;

        for (int i = 0; i < n; i++) {
            int valor = a[i];
            int fa = 0, fb = 0;

            for (int j = 0; j < n; j++) {
                if (a[j] == valor) fa++;
                if (b[j] == valor) fb++;
            }

            if (fa != fb) return false;
        }
        return true;
    }

    public static void imprimir(int[] arr) {
        for (int x : arr) System.out.print(x + " ");
        System.out.println();
    }
}
