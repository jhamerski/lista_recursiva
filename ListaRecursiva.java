
public class ListaRecursiva<E> {

    private E elemento;
    private ListaRecursiva<E> resto;

    // Obter tamanho
    public int obterTamanho() {
        if (elemento == null) {
            return 0;
        }
        return 1 + resto.obterTamanho();
    }

    // Adicionar
    public void adicionar(int posicao, E el) {
        if (posicao == 0) {
            ListaRecursiva<E> novoResto = new ListaRecursiva<>();
            novoResto.elemento = elemento;
            novoResto.resto = resto;

            elemento = el;
            resto = novoResto;
            // não tem caso negativo.
        } else if (elemento == null) {
            throw new IllegalArgumentException("Indice invalido");
        } else {
            // Posição diferente de zero, passa a ser do resto. O resto é sempre a posição
            // menos um
            resto.adicionar(posicao - 1, el);
        }
    }

    public E obter(int posicao) {
        if (elemento == null) {
            throw new IllegalArgumentException("Lista vazia");
        }
        if (posicao == 0) {
            return elemento;
        }

        return resto.obter(posicao - 1);
    }

    public E remover(int posicao) {
        if (elemento == null) {
            throw new IllegalArgumentException("Lista vazia");
        }
        if (posicao == 0) {
            // criar uma variavel para o elemento pq vou jogar ele fora
            E resultado = elemento;
            elemento = resto.elemento;
            resto = resto.resto;
            return resultado;
        } else {
            return resto.remover(posicao - 1);
        }
    }

    public void alterar(int posicao, E elemento) {
        if (elemento == null) {
            throw new IllegalArgumentException("lISTA VAZIA");
        }
        if (posicao == 0) {
            this.elemento = elemento;
        } else {
            resto.alterar(posicao - 1, elemento);
        }
    }

    public int encontrar(E elemento) {
        if (elemento == null) {
            throw new IllegalArgumentException("Lista Vazia ");
        }

        if (this.elemento != elemento) {
            return 1 + resto.encontrar(elemento);
        } else {
            return 0;
        }

    }
}
