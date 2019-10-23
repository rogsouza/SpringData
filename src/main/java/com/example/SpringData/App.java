package com.example.SpringData;

import com.example.SpringData.Domain.Produto;
import com.example.SpringData.Repository.ProdutoRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }

    @Bean
    public String exemplo (ProdutoRepository repositorio) {

        List<Produto> produtos = (List<Produto>) repositorio.findAll();

        if (produtos.isEmpty()) {
            System.out.println("Cadastrando produtos...");
            repositorio.save(new Produto("Sabonete", 10, 1.35));
            repositorio.save(new Produto("Lâmpada", 35, 7.50));
            repositorio.save(new Produto("Impressora", 20, 350.00));
            repositorio.save(new Produto("Computador", 10, 2500.00));
            System.out.println("-----------------------------------------------------");
        }

        System.out.println("Produtos cadastrados:");
        for (Produto produto : repositorio.findAll()) {
            System.out.println(produto.toString());
        }
        System.out.println("-----------------------------------------------------");

        System.out.println("Produto com o nome: Impressora");
        System.out.println(repositorio.findByNome("Impressora"));
        System.out.println("-----------------------------------------------------");

        System.out.println("Produto com quantidade 35 e valor 7.50");
        for (Produto produto : repositorio.findByQuantidadeAndValor(35, 7.5)) {
            System.out.println(produto.toString());
        }
        System.out.println("-----------------------------------------------------");

        System.out.println("Produto com quantidade 10");
        for (Produto produto : repositorio.findByQuantidade(10)) {
            System.out.println(produto.toString());
        }
        System.out.println("-----------------------------------------------------");

        return "";
    }

}
