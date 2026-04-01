// Programa que demuestra el uso de ciclos for en Java:
// - for simple con rango ascendente
// - for simple con rango negativo (descendente)
// - for anidado con break simple para salir del ciclo interno
// - for anidado con break etiquetado (labeled break) para salir de ambos ciclos
// - for anidado para imprimir un patrón de símbolos ASCII
public class For {

    public static void main(String[] args) {

        // ── Primer ejercicio ──────────────────────────────────────────────────
        // Ciclo que imprime los números del 1 al 10 de forma ascendente.
        // La variable 'c' inicia en 1, incrementa de 1 en 1 y termina cuando c > 10.
        System.out.println("primer ejercicio");

        for (int c = 1; c <= 10; c++) {
            System.out.println(""+c); // imprime el valor actual de c en cada iteración
        }

        // ── Segundo ejercicio ─────────────────────────────────────────────────
        // Ciclo que imprime los números del -10 al -1 (rango negativo ascendente).
        // La variable 'd' inicia en -10, incrementa de 1 en 1 y termina cuando d > -1.
        System.out.println("\nSegundo ejercicio");

        for (int d = -10; d <= -1; d++) {
            System.out.println(""+d); // imprime el valor actual de d en cada iteración
        }

        // ── Tercer ejercicio ──────────────────────────────────────────────────
        // Ciclos for anidados (a: 0-9, b: 0-9) con un break simple.
        // 'num' lleva la cuenta del total de iteraciones ejecutadas.
        // Cuando a == 5 y b == 5 se ejecuta 'break', que interrumpe SOLO
        // el ciclo interno (sobre b) y continúa con el siguiente valor de a.
        System.out.println("\nTercer ejercicio");

        int num = 0; // contador de iteraciones del ciclo anidado

        for (int a = 0; a < 10; a++) {
            for (int b = 0; b < 10; b++) {
                if (a == 5 && b == 5) {
                    break; // sale únicamente del ciclo interno (b) cuando a=5 y b=5
                }
                num++;                      // incrementa el contador en cada iteración válida
                System.out.println("\f"+num);    // muestra el valor acumulado del contador
            }
        }

        // ── Cuarto ejercicio ──────────────────────────────────────────────────
        // Ciclos for anidados (i: 0-9, j: 0-9) con un break etiquetado (labeled break).
        // 'numero' lleva la cuenta del total de iteraciones ejecutadas.
        // La etiqueta 'outer' marca el ciclo externo.
        // Cuando i == 5 y j == 5 se ejecuta 'break outer', que interrumpe AMBOS ciclos
        // (interno y externo) al mismo tiempo, terminando el ejercicio por completo.
        System.out.println("\nCuarto ejercicio");

        int numero = 0; // contador de iteraciones del ciclo anidado con break etiquetado

        outer: // etiqueta que identifica el ciclo externo para poder salir de él desde adentro
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == 5 && j == 5) {
                    break outer; // sale de AMBOS ciclos (interno y externo) cuando i=5 y j=5
                }
                numero++;                    // incrementa el contador en cada iteración válida
                System.out.println("\t"+numero);  // muestra el valor acumulado del contador
            }
        }

      
    }
}
