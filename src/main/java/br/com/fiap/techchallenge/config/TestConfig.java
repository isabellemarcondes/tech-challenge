package br.com.fiap.techchallenge.config;

import br.com.fiap.techchallenge.entities.Produto;
import br.com.fiap.techchallenge.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("dev")
public class TestConfig implements CommandLineRunner {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public TestConfig(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Produto p1 = new Produto(null, "40048");
        Produto p2 = new Produto(null, "52201");

        produtoRepository.saveAll(Arrays.asList(p1, p2));
    }

}
