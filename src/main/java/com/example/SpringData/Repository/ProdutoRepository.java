package com.example.SpringData.Repository;

import com.example.SpringData.Domain.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {

    Produto findByNome(String nome);
    List<Produto> findByQuantidadeAndValor(int qtde, Double valor);
    List<Produto> findByQuantidade(int qtde);

}
