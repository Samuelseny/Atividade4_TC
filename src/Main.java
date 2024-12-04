public class Main {
    public static void main(String[] args) {
        String palavra = "001";
        System.out.println((verificaLinguagem(palavra) ? "Pertence" : "Não pertence"));
    }
    enum Estado {
        INICIAL, LENDO_ZERO, LENDO_UM, FINAL
    }
    public static boolean verificaLinguagem(String palavra) {
        Estado estadoAtual = Estado.INICIAL;

        for (char c : palavra.toCharArray()) {
            switch (estadoAtual) {
                case INICIAL:
                    if (c == '0') {
                        estadoAtual = Estado.LENDO_ZERO;
                    } else {
                        return false;
                    }
                    break;

                case LENDO_ZERO:
                    if (c == '0') {
                    } else if (c == '1') {
                        estadoAtual = Estado.LENDO_UM;
                    } else {
                        return false;
                    }
                    break;

                case LENDO_UM:
                    if (c == '1') {
                    } else {
                        return false;
                    }
                    break;

                default:
                    return false;
            }
        }

        return estadoAtual == Estado.LENDO_UM || estadoAtual == Estado.INICIAL;
    }
}