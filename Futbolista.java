public class Futbolista extends Thread {
    private int nGols;
    private int nTirades;
    private final static int NUM_JUGADORS = 11;
    private final static int NUM_TIRADES = 20;
    private final static float PROBABILITAT = 0.5f;
    private final static String[] NOMS = { "Piqué", "Vinicius", "Torres", "Ramos", "Ronaldo", "Lewan", "Belli", "Arnau",
            "Aspas", "Messi", "MBapé" };

    public Futbolista(String nom) {
        super(nom);
        this.nGols = 0;
        this.nTirades = 0;
    }

    public int getnGols() {
        return nGols;
    }

    public int getnTirades() {
        return nTirades;
    }

    @Override
    public void run() {
        for (int i = 0; i < NUM_TIRADES; i++) {
            if (Math.random() < PROBABILITAT) {
                nGols++;
            }
            nTirades++;
        }
    }

    public static void main(String[] args) {
        Futbolista llistaJugadors[] = new Futbolista[NUM_JUGADORS];

        // creació
        for (int i = 0; i < 11; i++) {
            Futbolista futolista = new Futbolista(NOMS[i]);
            llistaJugadors[i] = futolista;
        }
        System.out.println("Inici dels xuts --------------------");

        for (Futbolista jugador : llistaJugadors) {
            jugador.start();
        }
        // Espera a que acbin els fils
        for (Futbolista jugador : llistaJugadors) {
            try {
                jugador.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Fi dels xuts -----------------------");

        System.out.println("--- Estadístiques ------");
        for (Futbolista jugador : llistaJugadors) {
            System.out.println(
                    jugador.getName() + " -> " + jugador.getnGols() + " gols en " + jugador.getnTirades() + " tirades");
        }

    }
}