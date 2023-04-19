    package org.example.exercicio20;

    import java.util.ArrayList;

    public class Estoque {
        int id = 1;
        ArrayList<Produto> listaDeProdutos;

        public void inicializaEstoque() {
            listaDeProdutos = new ArrayList<>();
        }

        public Produto encontraProduto(String nome) {
            for(Produto produto: listaDeProdutos)
                if(produto.getNome().equals((nome)))
                    return produto;
            return null;
        }

        public Produto encontraProduto(int id) {
            for(Produto produto: listaDeProdutos)
                if(produto.getId() == id)
                    return produto;
            return null;
        }

        public boolean cadastraProduto(Produto produto) {
            for(Produto x : listaDeProdutos)
                if(x.getNome().equals(produto.getNome())) {
                    x.setQuantidadeEmEstoque(x.getQuantidadeEmEstoque() + produto.getQuantidadeEmEstoque());
                    return true;
                }
            listaDeProdutos.add(produto);
            return true;
        }

        public void imprimeCatalogoDoEstoque() {
            StringBuilder sb = new StringBuilder();
            if(listaDeProdutos.size() == 0)
                sb.append("Lista vazia\n");
            else {
                sb.append("Catálogo:\n");
                for(Produto produto : listaDeProdutos)
                    sb.append(produto.getQuantidadeEmEstoque())
                            .append("x ")
                            .append(produto.getNome())
                            .append(", por: ")
                            .append(produto.getPreco())
                            .append(" cada um")
                            .append("\n");
            }
            System.out.println(sb);
        }


        public boolean darBaixaEmEstoque(String nome, int quantidadeParaDarBaixa) {
            Produto produto = encontraProduto(nome);
                if(temEstoqueOuNao(produto, quantidadeParaDarBaixa)) {
                    produto.setQuantidadeEmEstoque(produto.getQuantidadeEmEstoque() - quantidadeParaDarBaixa);
                    return true;
                } else
                    return false;
        }

        public boolean darBaixaEmEstoque(int id, int quantidadeParaDarBaixa) {
            Produto produto = encontraProduto(id);
                if(temEstoqueOuNao(produto, quantidadeParaDarBaixa)) {
                    produto.setQuantidadeEmEstoque(produto.getQuantidadeEmEstoque() - quantidadeParaDarBaixa);
                    return true;
                } else
                    return false;
        }

        public int getQuantidadeAtualEmEstoque(Produto produto) {
            for(Produto x : listaDeProdutos)
                if(x.getNome().equals(produto.getNome()))
                    return x.getQuantidadeEmEstoque();
            return 0;
        }

        public int getPosicaoDoProdutoNaLista(Produto produto) {
            for(int i = 0; i < listaDeProdutos.size(); i++)
                if(listaDeProdutos.get(i).equals(produto))
                    return i;
            return -1;
        }

        public boolean temEstoqueOuNao(Produto produto, int quantidadeParaDarBaixa) {
            for(Produto x : listaDeProdutos)
                if(x.equals(produto) && x.getQuantidadeEmEstoque() >= quantidadeParaDarBaixa)
                    return true;
            return false;
        }
    }
